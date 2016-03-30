package com.google.appinventor.components.runtime.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.gsm.SmsMessage;
import android.util.Log;
import com.google.appinventor.components.runtime.ReplForm;
import com.google.appinventor.components.runtime.Texting;

public class SmsBroadcastReceiver extends BroadcastReceiver
{
  public static final int NOTIFICATION_ID = 8647;
  public static final String TAG = "SmsBroadcastReceiver";

  private String getMessage(Intent paramIntent)
  {
    String str = "";
    if (paramIntent.getAction().equals("com.google.android.apps.googlevoice.SMS_RECEIVED"))
      str = paramIntent.getExtras().getString("com.google.android.apps.googlevoice.TEXT");
    while (true)
    {
      return str;
      Object[] arrayOfObject = (Object[])paramIntent.getExtras().get("pdus");
      int i = arrayOfObject.length;
      for (int j = 0; j < i; j++)
        str = SmsMessage.createFromPdu((byte[])arrayOfObject[j]).getMessageBody();
    }
  }

  private String getPhoneNumber(Intent paramIntent)
  {
    String str = "";
    if (paramIntent.getAction().equals("com.google.android.apps.googlevoice.SMS_RECEIVED"))
      str = PhoneNumberUtils.formatNumber(paramIntent.getExtras().getString("com.google.android.apps.googlevoice.PHONE_NUMBER"));
    while (true)
    {
      return str;
      Object[] arrayOfObject = (Object[])paramIntent.getExtras().get("pdus");
      int i = arrayOfObject.length;
      for (int j = 0; j < i; j++)
        str = PhoneNumberUtils.formatNumber(SmsMessage.createFromPdu((byte[])arrayOfObject[j]).getOriginatingAddress());
    }
  }

  private boolean isRepl(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      boolean bool = Class.forName(str + ".Screen1").getSuperclass().equals(ReplForm.class);
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    return false;
  }

  // ERROR //
  private void sendNotification(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 11
    //   2: new 86	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9: ldc 118
    //   11: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_2
    //   15: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 120
    //   20: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_3
    //   24: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 126	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   33: pop
    //   34: aload_1
    //   35: invokevirtual 84	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: astore 5
    //   40: ldc 11
    //   42: new 86	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   49: ldc 128
    //   51: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload 5
    //   56: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 126	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   65: pop
    //   66: new 86	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   73: aload 5
    //   75: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 93
    //   80: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: astore 9
    //   88: new 21	android/content/Intent
    //   91: dup
    //   92: aload_1
    //   93: aload 9
    //   95: invokestatic 102	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   98: invokespecial 131	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   101: astore 10
    //   103: aload 10
    //   105: ldc 133
    //   107: invokevirtual 137	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   110: pop
    //   111: aload 10
    //   113: ldc 139
    //   115: invokevirtual 142	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   118: pop
    //   119: aload 10
    //   121: ldc 143
    //   123: invokevirtual 147	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   126: pop
    //   127: aload_1
    //   128: ldc 149
    //   130: invokevirtual 152	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   133: checkcast 154	android/app/NotificationManager
    //   136: astore 15
    //   138: new 156	android/app/Notification
    //   141: dup
    //   142: ldc 157
    //   144: new 86	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   151: aload_2
    //   152: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 159
    //   157: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_3
    //   161: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 165	java/lang/System:currentTimeMillis	()J
    //   170: invokespecial 168	android/app/Notification:<init>	(ILjava/lang/CharSequence;J)V
    //   173: astore 16
    //   175: aload 16
    //   177: bipush 16
    //   179: aload 16
    //   181: getfield 171	android/app/Notification:flags	I
    //   184: ior
    //   185: putfield 171	android/app/Notification:flags	I
    //   188: aload 16
    //   190: iconst_1
    //   191: aload 16
    //   193: getfield 174	android/app/Notification:defaults	I
    //   196: ior
    //   197: putfield 174	android/app/Notification:defaults	I
    //   200: aload_1
    //   201: iconst_0
    //   202: aload 10
    //   204: ldc 175
    //   206: invokestatic 181	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   209: astore 17
    //   211: aload 16
    //   213: aload_1
    //   214: new 86	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   221: ldc 183
    //   223: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_2
    //   227: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: aload_3
    //   234: aload 17
    //   236: invokevirtual 187	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   239: aload 16
    //   241: invokestatic 193	com/google/appinventor/components/runtime/Texting:getCachedMsgCount	()I
    //   244: putfield 196	android/app/Notification:number	I
    //   247: aload 15
    //   249: aconst_null
    //   250: sipush 8647
    //   253: aload 16
    //   255: invokevirtual 200	android/app/NotificationManager:notify	(Ljava/lang/String;ILandroid/app/Notification;)V
    //   258: ldc 11
    //   260: new 86	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   267: ldc 202
    //   269: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload 9
    //   274: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 126	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   283: pop
    //   284: return
    //   285: astore 7
    //   287: aload 7
    //   289: astore 8
    //   291: aload 8
    //   293: invokevirtual 114	java/lang/ClassNotFoundException:printStackTrace	()V
    //   296: return
    //   297: astore 11
    //   299: aload 11
    //   301: astore 8
    //   303: goto -12 -> 291
    //
    // Exception table:
    //   from	to	target	type
    //   66	103	285	java/lang/ClassNotFoundException
    //   103	284	297	java/lang/ClassNotFoundException
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i("SmsBroadcastReceiver", "onReceive");
    String str1 = getPhoneNumber(paramIntent);
    String str2 = getMessage(paramIntent);
    Log.i("SmsBroadcastReceiver", "Received " + str1 + " : " + str2);
    if (Texting.isReceivingEnabled(paramContext))
    {
      if (isRepl(paramContext))
      {
        if (Texting.isRunning())
        {
          Texting.handledReceivedMessage(paramContext, str1, str2);
          return;
        }
        Log.i("SmsBroadcastReceiver", paramContext.getApplicationInfo().packageName + " is not running and we are the repl, ignoring message.");
        return;
      }
      Texting.handledReceivedMessage(paramContext, str1, str2);
      if (!Texting.isRunning())
      {
        sendNotification(paramContext, str1, str2);
        return;
      }
      Log.i("SmsBroadcastReceiver", paramContext.getApplicationInfo().packageName + " is running");
      return;
    }
    Log.i("SmsBroadcastReceiver", paramContext.getApplicationInfo().packageName + " receiving disabled");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.SmsBroadcastReceiver
 * JD-Core Version:    0.6.2
 */