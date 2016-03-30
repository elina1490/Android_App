package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.telephony.gsm.SmsManager;
import android.telephony.gsm.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.OAuth2Helper;
import com.google.appinventor.components.runtime.util.OnInitializeListener;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@DesignerComponent(category=ComponentCategory.SOCIAL, description="<p>A component that will, when the <code>SendMessage</code>  method is called, send the text message specified in the <code>Message</code> property to the phone number specified in the <code>PhoneNumber</code> property. <p>This component will also receive text messages if the <code>ReceivingEnabled</code> property is True.  When a message arrives, the <code>MessageReceived</code> event is raised and provides the sending number and message.</p><p> An app that includes this component will receive messages even when it is in the background (i.e. when it's not visible on the screen) and, moreso, even if the app is not running, so long as it's installed on the phone. If the phone receives a text message when the app is not in the foreground, the phone  will show a notification in the notification bar.  Selecting the notification will bring up the app.As an app developer, you'll probably want to give your users the ability to control ReceivingEnabled so that they can make the phone ignore text messages.<p>If the GoogleVoiceEnabled property is true, messages can be sent over Wifi using Google Voice. This option requires that the user have a Google Voice account and that the mobile Voice app is installed on the phone. The Google Voice option works only on phones that support Android 2.0 (Eclair) or higher. </p><p>To specify the phone number (e.g., 650-555-1212), set the <code>PhoneNumber</code> property to a Text string with the specified digits (e.g., 6505551212).  Dashes, dots, and parentheses may be included (e.g., (650)-555-1212) but will be ignored; spaces may not be included.</p><p>Another way for an app to specify a phone number would be to include a <code>PhoneNumberPicker</code> component, which lets the users select a phone numbers from the ones stored in the the phone's contacts.</p>", iconName="images/texting.png", nonVisible=true, version=2)
@SimpleObject
@UsesLibraries(libraries="google-api-client-beta.jar,google-api-client-android2-beta.jar,google-http-client-beta.jar,google-http-client-android2-beta.jar,google-http-client-android3-beta.jar,google-oauth-client-beta.jar,guava-11.0.1.jar")
@UsesPermissions(permissionNames="android.permission.RECEIVE_SMS, android.permission.SEND_SMS, com.google.android.apps.googlevoice.permission.RECEIVE_SMS, com.google.android.apps.googlevoice.permission.SEND_SMS, android.permission.ACCOUNT_MANAGER, android.permission.MANAGE_ACCOUNTS, android.permission.GET_ACCOUNTS, android.permission.USE_CREDENTIALS")
public class Texting extends AndroidNonvisibleComponent
  implements Component, OnResumeListener, OnPauseListener, OnInitializeListener, OnStopListener
{
  private static final String CACHE_FILE = "textingmsgcache";
  public static final String GV_INTENT_FILTER = "com.google.android.apps.googlevoice.SMS_RECEIVED";
  public static final String GV_PACKAGE_NAME = "com.google.android.apps.googlevoice";
  private static final String GV_SERVICE = "grandcentral";
  public static final String GV_SMS_RECEIVED = "com.google.android.apps.googlevoice.SMS_RECEIVED";
  public static final String GV_SMS_SEND_URL = "https://www.google.com/voice/b/0/sms/send/";
  public static final String GV_URL = "https://www.google.com/voice/b/0";
  private static final String MESSAGE_DELIMITER = "\001";
  public static final String MESSAGE_TAG = "com.google.android.apps.googlevoice.TEXT";
  public static final String META_DATA_SMS_KEY = "sms_handler_component";
  public static final String META_DATA_SMS_VALUE = "Texting";
  public static final String PHONE_NUMBER_TAG = "com.google.android.apps.googlevoice.PHONE_NUMBER";
  private static final String PREF_FILE = "TextingState";
  private static final String PREF_GVENABLED = "gvenabled";
  private static final String PREF_RCVENABLED = "receiving";
  private static final String SENT = "SMS_SENT";
  private static final int SERVER_TIMEOUT_MS = 30000;
  public static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
  public static final String TAG = "Texting Component";
  public static final String TELEPHONY_INTENT_FILTER = "android.provider.Telephony.SMS_RECEIVED";
  private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/525.13 (KHTML, like Gecko) Chrome/0.A.B.C Safari/525.13";
  private static final String UTF8 = "UTF-8";
  private static Activity activity;
  private static Object cacheLock = new Object();
  private static Component component;
  private static boolean isRunning;
  private static int messagesCached;
  public static boolean receivingEnabled = true;
  private boolean googleVoiceEnabled;
  private GoogleVoiceUtil gvHelper;
  private boolean isInitialized;
  private String message;
  private String phoneNumber;
  private SmsManager smsManager;

  public Texting(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    Log.d("Texting Component", "Texting constructor");
    component = this;
    activity = paramComponentContainer.$context();
    SharedPreferences localSharedPreferences = activity.getSharedPreferences("TextingState", 0);
    if (localSharedPreferences != null)
    {
      receivingEnabled = localSharedPreferences.getBoolean("receiving", true);
      this.googleVoiceEnabled = localSharedPreferences.getBoolean("gvenabled", false);
      Log.i("Texting Component", "Starting with receiving Enabled=" + receivingEnabled + " GV enabled=" + this.googleVoiceEnabled);
    }
    while (true)
    {
      this.smsManager = SmsManager.getDefault();
      PhoneNumber("");
      this.isInitialized = false;
      isRunning = false;
      paramComponentContainer.$form().registerForOnInitialize(this);
      paramComponentContainer.$form().registerForOnResume(this);
      paramComponentContainer.$form().registerForOnPause(this);
      paramComponentContainer.$form().registerForOnStop(this);
      return;
      receivingEnabled = true;
      this.googleVoiceEnabled = false;
    }
  }

  @SimpleEvent
  public static void MessageReceived(String paramString1, String paramString2)
  {
    if (receivingEnabled)
    {
      Log.i("Texting Component", "MessageReceived from " + paramString1 + ":" + paramString2);
      if (EventDispatcher.dispatchEvent(component, "MessageReceived", new Object[] { paramString1, paramString2 }))
        Log.i("Texting Component", "Dispatch successful");
    }
    else
    {
      return;
    }
    Log.i("Texting Component", "Dispatch failed, caching");
    synchronized (cacheLock)
    {
      addMessageToCache(activity, paramString1, paramString2);
      return;
    }
  }

  private static void addMessageToCache(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = paramString1 + ":" + paramString2 + "\001";
      Log.i("Texting Component", "Caching " + str);
      FileOutputStream localFileOutputStream = paramContext.openFileOutput("textingmsgcache", 32768);
      localFileOutputStream.write(str.getBytes());
      localFileOutputStream.close();
      messagesCached = 1 + messagesCached;
      Log.i("Texting Component", "Cached " + str);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.e("Texting Component", "File not found error writing to cache file");
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("Texting Component", "I/O Error writing to cache file");
      localIOException.printStackTrace();
    }
  }

  public static int getCachedMsgCount()
  {
    return messagesCached;
  }

  public static SmsMessage[] getMessagesFromIntent(Intent paramIntent)
  {
    Object[] arrayOfObject = (Object[])paramIntent.getSerializableExtra("pdus");
    byte[][] arrayOfByte1 = new byte[arrayOfObject.length][];
    for (int i = 0; i < arrayOfObject.length; i++)
      arrayOfByte1[i] = ((byte[])(byte[])arrayOfObject[i]);
    byte[][] arrayOfByte2 = new byte[arrayOfByte1.length][];
    int j = arrayOfByte2.length;
    SmsMessage[] arrayOfSmsMessage = new SmsMessage[j];
    for (int k = 0; k < j; k++)
    {
      arrayOfByte2[k] = arrayOfByte1[k];
      arrayOfSmsMessage[k] = SmsMessage.createFromPdu(arrayOfByte2[k]);
    }
    return arrayOfSmsMessage;
  }

  private void handleSentMessage(Context paramContext, BroadcastReceiver paramBroadcastReceiver, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 0:
    default:
    case -1:
    case 1:
    case 4:
    case 3:
    case 2:
    }
    while (true)
    {
      return;
      try
      {
        Log.i("Texting Component", "Received OK, msg:" + paramString);
        Toast.makeText(activity, "Message sent", 0).show();
        continue;
      }
      finally
      {
      }
      Log.e("Texting Component", "Received generic failure, msg:" + paramString);
      Toast.makeText(activity, "Generic failure: message not sent", 0).show();
      continue;
      Log.e("Texting Component", "Received no service error, msg:" + paramString);
      Toast.makeText(activity, "No Sms service available. Message not sent.", 0).show();
      continue;
      Log.e("Texting Component", "Received null PDU error, msg:" + paramString);
      Toast.makeText(activity, "Received null PDU error. Message not sent.", 0).show();
      continue;
      Log.e("Texting Component", "Received radio off error, msg:" + paramString);
      Toast.makeText(activity, "Could not send SMS message: radio off.", 1).show();
    }
  }

  public static void handledReceivedMessage(Context paramContext, String paramString1, String paramString2)
  {
    if (isRunning)
    {
      MessageReceived(paramString1, paramString2);
      return;
    }
    synchronized (cacheLock)
    {
      addMessageToCache(paramContext, paramString1, paramString2);
      return;
    }
  }

  public static boolean isReceivingEnabled(Context paramContext)
  {
    return paramContext.getSharedPreferences("TextingState", 0).getBoolean("receiving", true);
  }

  public static boolean isRunning()
  {
    return isRunning;
  }

  private void processCachedMessages()
  {
    String[] arrayOfString;
    synchronized (cacheLock)
    {
      arrayOfString = retrieveCachedMessages();
      if (arrayOfString == null)
        return;
    }
    Log.i("Texting Component", "processing " + arrayOfString.length + " cached messages ");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      String str = arrayOfString[i];
      Log.i("Texting Component", "Message + " + i + " " + str);
      int j = str.indexOf(":");
      if ((receivingEnabled) && (j != -1))
        MessageReceived(str.substring(0, j), str.substring(j + 1));
    }
  }

  // ERROR //
  private String[] retrieveCachedMessages()
  {
    // Byte code:
    //   0: ldc 89
    //   2: ldc_w 398
    //   5: invokestatic 186	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: getstatic 151	com/google/appinventor/components/runtime/Texting:activity	Landroid/app/Activity;
    //   12: ldc 37
    //   14: invokevirtual 402	android/app/Activity:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   17: astore 7
    //   19: sipush 8192
    //   22: newarray byte
    //   24: astore 8
    //   26: aload 7
    //   28: ifnonnull +14 -> 42
    //   31: ldc 89
    //   33: ldc_w 404
    //   36: invokestatic 305	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   39: pop
    //   40: aconst_null
    //   41: areturn
    //   42: aload 7
    //   44: aload 8
    //   46: invokevirtual 410	java/io/FileInputStream:read	([B)I
    //   49: istore 10
    //   51: ldc 89
    //   53: new 167	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 412
    //   63: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload 10
    //   68: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc_w 414
    //   74: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 37
    //   79: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 186	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   88: pop
    //   89: new 283	java/lang/String
    //   92: dup
    //   93: aload 8
    //   95: iconst_0
    //   96: iload 10
    //   98: invokespecial 417	java/lang/String:<init>	([BII)V
    //   101: astore 12
    //   103: aload 7
    //   105: invokevirtual 418	java/io/FileInputStream:close	()V
    //   108: getstatic 151	com/google/appinventor/components/runtime/Texting:activity	Landroid/app/Activity;
    //   111: ldc 37
    //   113: invokevirtual 422	android/app/Activity:deleteFile	(Ljava/lang/String;)Z
    //   116: pop
    //   117: iconst_0
    //   118: putstatic 298	com/google/appinventor/components/runtime/Texting:messagesCached	I
    //   121: ldc 89
    //   123: new 167	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 424
    //   133: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload 12
    //   138: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 186	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   147: pop
    //   148: aload 12
    //   150: ldc 56
    //   152: invokevirtual 428	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   155: areturn
    //   156: astore 5
    //   158: ldc 89
    //   160: ldc_w 430
    //   163: invokestatic 305	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   166: pop
    //   167: aconst_null
    //   168: areturn
    //   169: astore_2
    //   170: aload_2
    //   171: astore_3
    //   172: ldc 89
    //   174: ldc_w 432
    //   177: invokestatic 305	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   180: pop
    //   181: aload_3
    //   182: invokevirtual 311	java/io/IOException:printStackTrace	()V
    //   185: aconst_null
    //   186: areturn
    //   187: astore 14
    //   189: aload 14
    //   191: astore_3
    //   192: goto -20 -> 172
    //   195: astore 13
    //   197: goto -39 -> 158
    //
    // Exception table:
    //   from	to	target	type
    //   9	26	156	java/io/FileNotFoundException
    //   31	40	156	java/io/FileNotFoundException
    //   42	103	156	java/io/FileNotFoundException
    //   9	26	169	java/io/IOException
    //   31	40	169	java/io/IOException
    //   42	103	169	java/io/IOException
    //   103	148	187	java/io/IOException
    //   103	148	195	java/io/FileNotFoundException
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void GoogleVoiceEnabled(boolean paramBoolean)
  {
    if (SdkLevel.getLevel() >= 5)
    {
      this.googleVoiceEnabled = paramBoolean;
      SharedPreferences.Editor localEditor = activity.getSharedPreferences("TextingState", 0).edit();
      localEditor.putBoolean("gvenabled", paramBoolean);
      localEditor.commit();
      return;
    }
    Toast.makeText(activity, "Sorry, your phone's system does not support this option.", 1).show();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="If true, then SendMessage will attempt to send messages over Wifi using Google Voice.  This requires that the Google Voice app must be installed and set up on the phone or tablet, with a Google Voice account.  If GoogleVoiceEnabled is false, the device must have phone and texting service in order to send or receive messages with this component.")
  public boolean GoogleVoiceEnabled()
  {
    return this.googleVoiceEnabled;
  }

  @SimpleProperty
  public String Message()
  {
    return this.message;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The message that will be sent when the SendMessage method is called.")
  public void Message(String paramString)
  {
    this.message = paramString;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The number that the message will be sent to when the SendMessage method is called. The number is a text string with the specified digits (e.g., 6505551212).  Dashes, dots, and parentheses may be included (e.g., (650)-555-1212) but will be ignored; spaces should not be included.")
  public String PhoneNumber()
  {
    return this.phoneNumber;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public void PhoneNumber(String paramString)
  {
    this.phoneNumber = paramString;
  }

  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty
  public void ReceivingEnabled(boolean paramBoolean)
  {
    receivingEnabled = paramBoolean;
    SharedPreferences.Editor localEditor = activity.getSharedPreferences("TextingState", 0).edit();
    localEditor.putBoolean("receiving", paramBoolean);
    localEditor.commit();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="If true, the component will respond to messages received.  If the app is in the foreground, the MessageReceived event will be signaled.  If the app is running in the background, or even not running at all, the phone will show a notification.  Selecting the notification will bring up the app and signal the MessageReceived event.  Messages received when the app is dormant will be queued, and so several MessageReceived events might appear when the app awakens.  As an app developer, it would be a good idea to give your users control over this property, so they can make their phones ignore text messages when your app is installed.")
  public boolean ReceivingEnabled()
  {
    return receivingEnabled;
  }

  @SimpleFunction
  public void SendMessage()
  {
    Log.i("Texting Component", "Sending message " + this.message + " to " + this.phoneNumber);
    new AsyncSendMessage().execute(new Void[0]);
  }

  public void onInitialize()
  {
    Log.i("Texting Component", "onInitialize()");
    this.isInitialized = true;
    isRunning = true;
    processCachedMessages();
    ((NotificationManager)activity.getSystemService("notification")).cancel(8647);
  }

  public void onPause()
  {
    Log.i("Texting Component", "onPause()");
    isRunning = false;
  }

  public void onResume()
  {
    Log.i("Texting Component", "onResume()");
    isRunning = true;
    if (this.isInitialized)
    {
      processCachedMessages();
      ((NotificationManager)activity.getSystemService("notification")).cancel(8647);
    }
  }

  public void onStop()
  {
    SharedPreferences.Editor localEditor = activity.getSharedPreferences("TextingState", 0).edit();
    localEditor.putBoolean("receiving", receivingEnabled);
    localEditor.putBoolean("gvenabled", this.googleVoiceEnabled);
    localEditor.commit();
  }

  class AsyncSendMessage extends AsyncTask<Void, Void, String>
  {
    AsyncSendMessage()
    {
    }

    protected String doInBackground(Void[] paramArrayOfVoid)
    {
      String str1 = "";
      Log.i("Texting Component", "Async sending message");
      try
      {
        if (Texting.this.googleVoiceEnabled)
        {
          Log.i("Texting Component", "Sending via GV");
          String str2 = new OAuth2Helper().getRefreshedAuthToken(Texting.activity, "grandcentral");
          Log.i("Texting Component", "authToken = " + str2);
          if (Texting.this.gvHelper == null)
            Texting.access$402(Texting.this, new Texting.GoogleVoiceUtil(Texting.this, str2));
          if (!Texting.this.gvHelper.isInitialized())
            break label250;
          str1 = Texting.GoogleVoiceUtil.access$500(Texting.this.gvHelper);
          Log.i("Texting Component", "Sent SMS, response = " + str1);
        }
        else
        {
          Log.i("Texting Component", "Sending via built-in Sms");
          PendingIntent localPendingIntent = PendingIntent.getBroadcast(Texting.activity, 0, new Intent("SMS_SENT"), 0);
          BroadcastReceiver local1 = new BroadcastReceiver()
          {
            public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
            {
              try
              {
                Texting.this.handleSentMessage(paramAnonymousContext, null, getResultCode(), Texting.this.message);
                Texting.activity.unregisterReceiver(this);
                return;
              }
              catch (Exception localException)
              {
                while (true)
                {
                  Log.e("BroadcastReceiver", "Error in onReceive for msgId " + paramAnonymousIntent.getAction());
                  Log.e("BroadcastReceiver", localException.getMessage());
                  localException.printStackTrace();
                }
              }
              finally
              {
              }
            }
          };
          Texting.activity.registerReceiver(local1, new IntentFilter("SMS_SENT"));
          Texting.this.smsManager.sendTextMessage(Texting.this.phoneNumber, null, Texting.this.message, localPendingIntent, null);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return str1;
      label250: return "IO Error: unable to create GvHelper";
    }

    protected void onPostExecute(String paramString)
    {
      super.onPostExecute(paramString);
      if (paramString.contains("ok"))
        Toast.makeText(Texting.activity, "Message sent", 0).show();
      while (!paramString.contains("IO Error"))
        return;
      Toast.makeText(Texting.activity, paramString, 0).show();
    }
  }

  class GoogleVoiceUtil
  {
    private final int MAX_REDIRECTS = 5;
    String authToken;
    String general;
    private boolean isInitialized;
    int redirectCounter;
    String rnrSEE;

    public GoogleVoiceUtil(String arg2)
    {
      Log.i("Texting Component", "Creating GV Util");
      Object localObject;
      this.authToken = localObject;
      try
      {
        this.general = getGeneral();
        Log.i("Texting Component", "general = " + this.general);
        setRNRSEE();
        this.isInitialized = true;
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }

    private String sendGvSms()
    {
      Log.i("Texting Component", "sendGvSms()");
      String str1 = "";
      try
      {
        String str2 = URLEncoder.encode("phoneNumber", "UTF-8") + "=" + URLEncoder.encode(Texting.this.phoneNumber, "UTF-8") + "&" + URLEncoder.encode("text", "UTF-8") + "=" + URLEncoder.encode(Texting.this.message, "UTF-8") + "&" + URLEncoder.encode("_rnr_se", "UTF-8") + "=" + URLEncoder.encode(this.rnrSEE, "UTF-8");
        Log.i("Texting Component", "smsData = " + str2);
        URLConnection localURLConnection = new URL("https://www.google.com/voice/b/0/sms/send/").openConnection();
        localURLConnection.setRequestProperty("Authorization", "GoogleLogin auth=" + this.authToken);
        localURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/525.13 (KHTML, like Gecko) Chrome/0.A.B.C Safari/525.13");
        localURLConnection.setDoOutput(true);
        localURLConnection.setConnectTimeout(30000);
        Log.i("Texting Component", "sms request = " + localURLConnection);
        OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localURLConnection.getOutputStream());
        localOutputStreamWriter.write(str2);
        localOutputStreamWriter.flush();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localURLConnection.getInputStream()));
        while (true)
        {
          String str3 = localBufferedReader.readLine();
          if (str3 == null)
            break;
          str1 = str1 + str3 + "\n\r";
        }
        Log.i("Texting Component", "Sent SMS, response = " + str1);
        localOutputStreamWriter.close();
        localBufferedReader.close();
        if (str1.equals(""))
          throw new IOException("No Response Data Received.");
      }
      catch (IOException localIOException)
      {
        Log.i("Texting Component", "IO Error on Send " + localIOException.getMessage());
        localIOException.printStackTrace();
        return "IO Error Message not sent";
      }
      return str1;
    }

    private void setRNRSEE()
      throws IOException
    {
      Log.i("Texting Component", "setRNRSEE()");
      if (this.general != null)
      {
        if (this.general.contains("'_rnr_se': '"))
        {
          this.rnrSEE = this.general.split("'_rnr_se': '", 2)[1].split("',", 2)[0];
          Log.i("Texting Component", "Successfully Received rnr_se.");
          return;
        }
        Log.i("Texting Component", "Answer did not contain rnr_se! " + this.general);
        throw new IOException("Answer did not contain rnr_se! " + this.general);
      }
      Log.i("Texting Component", "setRNRSEE(): Answer was null!");
      throw new IOException("setRNRSEE(): Answer was null!");
    }

    String get(String paramString)
      throws IOException
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      int i = 0;
      InputStream localInputStream;
      while (true)
      {
        try
        {
          localHttpURLConnection.setRequestProperty("Authorization", "GoogleLogin auth=" + this.authToken);
          localHttpURLConnection.setRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/525.13 (KHTML, like Gecko) Chrome/0.A.B.C Safari/525.13");
          localHttpURLConnection.setInstanceFollowRedirects(false);
          localHttpURLConnection.connect();
          i = localHttpURLConnection.getResponseCode();
          Log.i("Texting Component", paramString + " - " + localHttpURLConnection.getResponseMessage());
          if (i == 200)
          {
            localInputStream = localHttpURLConnection.getInputStream();
            this.redirectCounter = 0;
            if (localInputStream != null)
              break;
            throw new IOException(paramString + " : " + localHttpURLConnection.getResponseMessage() + "(" + i + ") : InputStream was null : exiting.");
          }
        }
        catch (Exception localException1)
        {
          throw new IOException(paramString + " : " + localHttpURLConnection.getResponseMessage() + "(" + i + ") : IO Error.");
        }
        if ((i == 301) || (i == 302) || (i == 303) || (i == 307))
        {
          this.redirectCounter = (1 + this.redirectCounter);
          if (this.redirectCounter > 5)
          {
            this.redirectCounter = 0;
            throw new IOException(paramString + " : " + localHttpURLConnection.getResponseMessage() + "(" + i + ") : Too many redirects. exiting.");
          }
          String str1 = localHttpURLConnection.getHeaderField("Location");
          if ((str1 != null) && (!str1.equals("")))
          {
            System.out.println(paramString + " - " + i + " - new URL: " + str1);
            return get(str1);
          }
          throw new IOException(paramString + " : " + localHttpURLConnection.getResponseMessage() + "(" + i + ") : Received moved answer but no Location. exiting.");
        }
        localInputStream = localHttpURLConnection.getErrorStream();
      }
      BufferedReader localBufferedReader;
      StringBuffer localStringBuffer;
      try
      {
        localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
        localStringBuffer = new StringBuffer();
        while (true)
        {
          String str2 = localBufferedReader.readLine();
          if (str2 == null)
            break;
          localStringBuffer.append(str2 + "\n\r");
        }
      }
      catch (Exception localException2)
      {
        throw new IOException(paramString + " - " + localHttpURLConnection.getResponseMessage() + "(" + i + ") - " + localException2.getLocalizedMessage());
      }
      localBufferedReader.close();
      String str3 = localStringBuffer.toString();
      return str3;
    }

    public String getGeneral()
      throws IOException
    {
      Log.i("Texting Component", "getGeneral()");
      return get("https://www.google.com/voice/b/0");
    }

    public boolean isInitialized()
    {
      return this.isInitialized;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Texting
 * JD-Core Version:    0.6.2
 */