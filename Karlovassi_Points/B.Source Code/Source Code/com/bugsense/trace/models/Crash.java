package com.bugsense.trace.models;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Log;
import com.bugsense.trace.ActivityAsyncTask;
import com.bugsense.trace.BugSense.Processor;
import com.bugsense.trace.BugSenseHandler;
import com.bugsense.trace.G;
import com.bugsense.trace.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONObject;

public class Crash
  implements Serializable
{
  public static final int CRASH = 1;
  public static final int EXCEPTION = 0;
  private static final long serialVersionUID = 5665643267788332700L;
  private String androidVersion = "";
  private String appPackage = "";
  private String appVerCode = "";
  private String appVersion = "";
  private String consoleLogs = "";
  private HashMap<String, String> customData = new HashMap();
  private String date = "";
  private HashMap<String, String> extraData = new HashMap();
  private int handled = 1;
  private int isGPSOn = 2;
  private int isMobileNetworkOn = 2;
  private int isWifiOn = 2;
  private String ms_from_start = "";
  private String phoneBrand = "";
  private String phoneModel = "";
  private String rooted = "";
  private String[] screenProperties;
  private String stacktrace = "";

  private static String createJSON(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString, String paramString8, Map<String, String> paramMap, int paramInt4)
    throws Exception
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject3 = new JSONObject();
    JSONObject localJSONObject4 = new JSONObject();
    JSONObject localJSONObject5 = new JSONObject();
    JSONObject localJSONObject6 = new JSONObject();
    localJSONObject2.put("remote_ip", "");
    localJSONObject2.put("tag", "");
    localJSONObject1.put("request", localJSONObject2);
    StringReader localStringReader = new StringReader(paramString7);
    BufferedReader localBufferedReader = new BufferedReader(localStringReader);
    if (paramString8 == null)
      localJSONObject3.put("occured_at", localBufferedReader.readLine());
    while (true)
    {
      localJSONObject3.put("message", localBufferedReader.readLine());
      Object localObject = localBufferedReader.readLine();
      try
      {
        int i = 1 + ((String)localObject).lastIndexOf("(");
        int j = ((String)localObject).lastIndexOf(")");
        String str = ((String)localObject).substring(i, j);
        localObject = str;
        label179: localJSONObject3.put("where", localObject);
        localJSONObject3.put("handled", paramInt4);
        localJSONObject3.put("klass", getClass(paramString7));
        localJSONObject3.put("backtrace", paramString7);
        localJSONObject1.put("exception", localJSONObject3);
        localBufferedReader.close();
        localJSONObject5.put("uid", Utils.getUid(paramContext));
        localJSONObject5.put("phone", paramString4);
        localJSONObject5.put("brand", paramString5);
        localJSONObject5.put("appver", paramString2);
        localJSONObject5.put("appname", paramString1);
        localJSONObject5.put("internal_version", paramString3);
        localJSONObject5.put("osver", paramString6);
        localJSONObject5.put("wifi_on", paramInt1);
        localJSONObject5.put("mobile_net_on", paramInt2);
        localJSONObject5.put("gps_on", paramInt3);
        localJSONObject5.put("screen:width", paramArrayOfString[0]);
        localJSONObject5.put("screen:height", paramArrayOfString[1]);
        localJSONObject5.put("screen:orientation", paramArrayOfString[2]);
        localJSONObject5.put("screen_dpi(x:y)", paramArrayOfString[3] + ":" + paramArrayOfString[4]);
        if ((paramMap != null) && (!paramMap.isEmpty()))
        {
          Iterator localIterator = paramMap.entrySet().iterator();
          while (true)
            if (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              localJSONObject4.put((String)localEntry.getKey(), localEntry.getValue());
              continue;
              localJSONObject3.put("occured_at", paramString8);
              break;
            }
          localJSONObject5.put("log_data", localJSONObject4);
        }
        localJSONObject1.put("application_environment", localJSONObject5);
        localJSONObject6.put("version", "3.0.4");
        localJSONObject6.put("name", "bugsense-android");
        localJSONObject1.put("client", localJSONObject6);
        return localJSONObject1.toString();
      }
      catch (Exception localException)
      {
        break label179;
      }
    }
  }

  private static String getClass(String paramString)
  {
    Object localObject = "";
    try
    {
      int i = paramString.indexOf(":");
      if ((i != -1) && (i + 1 < paramString.length()))
      {
        String str = paramString.substring(0, i);
        localObject = str;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return localObject;
  }

  public static void sendCrash(final Context paramContext, final Crash paramCrash)
  {
    String str = Thread.currentThread().getName();
    if (!str.equals("main"))
    {
      Log.i(G.TAG, "Error in thread: " + str);
      transmitCrash(paramContext, paramCrash);
      return;
    }
    ActivityAsyncTask local2 = new ActivityAsyncTask(new BugSense.Processor()
    {
      public boolean beginSubmit()
      {
        return true;
      }

      public void handlerInstalled()
      {
      }

      public void submitDone()
      {
      }
    })
    {
      protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
      {
        Crash.transmitCrash(paramContext, paramCrash);
        return null;
      }

      protected void onCancelled()
      {
        super.onCancelled();
      }

      protected void onPreExecute()
      {
        super.onPreExecute();
      }

      protected void processPostExecute(Object paramAnonymousObject)
      {
        ((BugSense.Processor)this.mWrapped).submitDone();
      }
    };
    if (Build.VERSION.SDK_INT >= 11)
    {
      local2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
      return;
    }
    local2.execute(new Object[0]);
  }

  public static boolean transmitCrash(Context paramContext, Crash paramCrash)
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG)
    {
      Log.d(G.TAG, "URL: " + G.URL);
      Log.d(G.TAG, "APIKEY: " + G.API_KEY);
    }
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localHashMap.put("rooted", paramCrash.rooted);
    localHashMap.put("ms_from_start", paramCrash.ms_from_start);
    if ((G.SEND_LOG) && (paramCrash.handled == 1))
      localHashMap.put("log", paramCrash.consoleLogs);
    localHashMap.putAll(paramCrash.extraData);
    localHashMap.putAll(paramCrash.customData);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    HttpParams localHttpParams = localDefaultHttpClient.getParams();
    HttpProtocolParams.setUseExpectContinue(localHttpParams, false);
    HttpConnectionParams.setConnectionTimeout(localHttpParams, 20000);
    HttpConnectionParams.setSoTimeout(localHttpParams, 20000);
    HttpPost localHttpPost = new HttpPost(G.URL);
    localHttpPost.addHeader("X-BugSense-Api-Key", G.API_KEY);
    try
    {
      BasicNameValuePair localBasicNameValuePair = new BasicNameValuePair("data", createJSON(paramContext, paramCrash.appPackage, paramCrash.appVersion, paramCrash.appVerCode, paramCrash.phoneModel, paramCrash.phoneBrand, paramCrash.androidVersion, paramCrash.stacktrace, paramCrash.isWifiOn, paramCrash.isMobileNetworkOn, paramCrash.isGPSOn, paramCrash.screenProperties, paramCrash.date, localHashMap, paramCrash.handled));
      localArrayList.add(localBasicNameValuePair);
      localArrayList.add(new BasicNameValuePair("hash", Utils.MD5(paramCrash.stacktrace)));
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(localArrayList, "UTF-8");
      localHttpPost.setEntity(localUrlEncodedFormEntity);
      localHttpEntity = localDefaultHttpClient.execute(localHttpPost).getEntity();
      if (localHttpEntity == null)
      {
        Log.w(G.TAG, "It seems that there is no internet connectivity");
        throw new Exception("no internet connection");
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      HttpEntity localHttpEntity;
      CrashMechanism.getInstance(paramContext).saveCrash(paramCrash);
      Log.w(G.TAG, "Transmitting crash ClientProtocolException " + localClientProtocolException.getMessage());
      if (BugSenseHandler.I_WANT_TO_DEBUG)
        localClientProtocolException.printStackTrace();
      return false;
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localHttpEntity.getContent()));
      String str = localBufferedReader.readLine();
      localBufferedReader.close();
      if (BugSenseHandler.I_WANT_TO_DEBUG)
        Log.i(G.TAG, "Crash Response: " + str);
      if ((str != null) && (str.contains("tickerText")) && (str.contains("contentTitle")) && (str.contains("url")))
        BugSenseHandler.showUpgradeNotification(str);
      return true;
    }
    catch (IOException localIOException)
    {
      CrashMechanism.getInstance(paramContext).saveCrash(paramCrash);
      Log.w(G.TAG, "Transmitting crash IOException " + localIOException.getMessage());
      if (BugSenseHandler.I_WANT_TO_DEBUG)
        localIOException.printStackTrace();
      return false;
    }
    catch (Exception localException)
    {
      CrashMechanism.getInstance(paramContext).saveCrash(paramCrash);
      Log.w(G.TAG, "Transmitting crash Exception " + localException.getMessage());
      if (BugSenseHandler.I_WANT_TO_DEBUG)
        localException.printStackTrace();
    }
    return false;
  }

  public String getStacktrace()
  {
    return this.stacktrace;
  }

  public int getType()
  {
    return this.handled;
  }

  public void setAndroidVersion(String paramString)
  {
    this.androidVersion = paramString;
  }

  public void setAppPackage(String paramString)
  {
    this.appPackage = paramString;
  }

  public void setAppVerCode(String paramString)
  {
    this.appVerCode = paramString;
  }

  public void setAppVersion(String paramString)
  {
    this.appVersion = paramString;
  }

  public void setConsoleLogs(String paramString)
  {
    this.consoleLogs = paramString;
  }

  public void setCustomData(HashMap<String, String> paramHashMap)
  {
    this.customData = paramHashMap;
  }

  public void setDate(String paramString)
  {
    this.date = paramString;
  }

  public void setExtraData(HashMap<String, String> paramHashMap)
  {
    this.extraData = paramHashMap;
  }

  public void setHandled(int paramInt)
  {
    this.handled = paramInt;
  }

  public void setIsGPSOn(int paramInt)
  {
    this.isGPSOn = paramInt;
  }

  public void setIsMobileNetworkOn(int paramInt)
  {
    this.isMobileNetworkOn = paramInt;
  }

  public void setIsWifiOn(int paramInt)
  {
    this.isWifiOn = paramInt;
  }

  public void setMs_from_start(String paramString)
  {
    this.ms_from_start = paramString;
  }

  public void setPhoneBrand(String paramString)
  {
    this.phoneBrand = paramString;
  }

  public void setPhoneModel(String paramString)
  {
    this.phoneModel = paramString;
  }

  public void setRooted(String paramString)
  {
    this.rooted = paramString;
  }

  public void setScreenProperties(String[] paramArrayOfString)
  {
    this.screenProperties = paramArrayOfString;
  }

  public void setStacktrace(String paramString)
  {
    this.stacktrace = paramString;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.bugsense.trace.models.Crash
 * JD-Core Version:    0.6.2
 */