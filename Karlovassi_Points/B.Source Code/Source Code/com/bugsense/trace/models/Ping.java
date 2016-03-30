package com.bugsense.trace.models;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Log;
import com.bugsense.trace.ActivityAsyncTask;
import com.bugsense.trace.BugSense.Processor;
import com.bugsense.trace.BugSenseHandler;
import com.bugsense.trace.CryptoHttpClient;
import com.bugsense.trace.G;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class Ping
  implements Serializable
{
  private static final long serialVersionUID = -841601581361004004L;
  private String apiVersion = "";
  private String appVerCode = "";
  private String appVersion = "";
  private String locale = "";
  private String os = "";
  private String phoneBrand = "";
  private String phoneModel = "";
  private String tag = "_ping";
  private String timestamp = "";

  private static void sendPing(final Context paramContext, final Ping paramPing)
  {
    String str = Thread.currentThread().getName();
    if (!str.equals("main"))
    {
      Log.d(G.TAG, "Error in thread: " + str);
      transmitPing(paramContext, paramPing);
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
        Ping.transmitPing(paramContext, paramPing);
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

  public static void submitPing(Context paramContext)
  {
    Ping localPing = new Ping();
    localPing.setApiVersion("3.0.4");
    localPing.setAppVersion(G.APP_VERSION);
    localPing.setAppVerCode(G.APP_VERSIONCODE);
    localPing.setLocale(Locale.getDefault().getDisplayLanguage());
    localPing.setOs(G.ANDROID_VERSION);
    localPing.setPhoneModel(G.PHONE_MODEL);
    localPing.setPhoneBrand(G.PHONE_BRAND);
    localPing.setTimestamp(System.currentTimeMillis());
    sendPing(paramContext, localPing);
  }

  public static boolean transmitPing(Context paramContext, Ping paramPing)
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG)
    {
      Log.d(G.TAG, "URL: " + G.ANALYTICS_URL);
      Log.d(G.TAG, "APIKEY: " + G.API_KEY);
    }
    label338: StringBuilder localStringBuilder;
    try
    {
      if (G.ANALYTICS_URL.startsWith("https://"))
      {
        localObject = new CryptoHttpClient(paramContext, 0);
        HttpParams localHttpParams = ((DefaultHttpClient)localObject).getParams();
        HttpProtocolParams.setUseExpectContinue(localHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(localHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(localHttpParams, 20000);
        HttpPost localHttpPost = new HttpPost(G.ANALYTICS_URL);
        localHttpPost.addHeader("X-BugSense-Api-Key", G.API_KEY);
        new ArrayList().add(new BasicNameValuePair("data", paramPing.getFlatLine()));
        localHttpPost.setEntity(new StringEntity(paramPing.getFlatLine()));
        localHttpEntity = ((DefaultHttpClient)localObject).execute(localHttpPost).getEntity();
        if (localHttpEntity != null)
          break label338;
        Log.w(G.TAG, "It seems that there is no internet connectivity");
        throw new Exception("no internet connection");
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      while (true)
      {
        PingsMechanism.getInstance(paramContext).savePing(paramPing);
        Log.w(G.TAG, "Transmitting ping ClientProtocolException " + localClientProtocolException.getMessage());
        if (BugSenseHandler.I_WANT_TO_DEBUG)
          localClientProtocolException.printStackTrace();
        return false;
        Object localObject = new DefaultHttpClient();
      }
    }
    catch (IOException localIOException)
    {
      HttpEntity localHttpEntity;
      PingsMechanism.getInstance(paramContext).savePing(paramPing);
      Log.w(G.TAG, "Transmitting ping IOException " + localIOException.getMessage());
      if (BugSenseHandler.I_WANT_TO_DEBUG)
        localIOException.printStackTrace();
      return false;
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localHttpEntity.getContent()));
      localStringBuilder = new StringBuilder();
      while (true)
      {
        String str = localBufferedReader.readLine();
        if (str == null)
          break;
        localStringBuilder.append(str);
      }
    }
    catch (Exception localException)
    {
      PingsMechanism.getInstance(paramContext).savePing(paramPing);
      Log.w(G.TAG, "Transmitting ping Exception " + localException.getMessage());
      if (BugSenseHandler.I_WANT_TO_DEBUG)
        localException.printStackTrace();
      return false;
    }
    if (BugSenseHandler.I_WANT_TO_DEBUG)
      Log.i(G.TAG, "Ping Response for '" + paramPing.tag + "' :" + localStringBuilder.toString());
    return true;
  }

  public String getFlatLine()
  {
    return this.apiVersion + ":" + this.tag + ":" + this.phoneModel + ":" + this.phoneBrand + ":" + this.os + ":" + this.appVersion + ":" + this.locale + ":" + this.timestamp;
  }

  public String getTag()
  {
    return this.tag;
  }

  public void setApiVersion(String paramString)
  {
    this.apiVersion = paramString;
  }

  public void setAppVerCode(String paramString)
  {
    this.appVerCode = paramString;
  }

  public void setAppVersion(String paramString)
  {
    this.appVersion = paramString;
  }

  public void setLocale(String paramString)
  {
    this.locale = paramString;
  }

  public void setOs(String paramString)
  {
    this.os = paramString;
  }

  public void setPhoneBrand(String paramString)
  {
    this.phoneBrand = paramString;
  }

  public void setPhoneModel(String paramString)
  {
    this.phoneModel = paramString;
  }

  public void setTag(String paramString)
  {
    this.tag = paramString;
  }

  public void setTimestamp(long paramLong)
  {
    this.timestamp = "";
    try
    {
      this.timestamp = String.valueOf(paramLong);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.bugsense.trace.models.Ping
 * JD-Core Version:    0.6.2
 */