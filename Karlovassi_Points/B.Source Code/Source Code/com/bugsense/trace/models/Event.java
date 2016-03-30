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

public final class Event
  implements Serializable
{
  private static final long serialVersionUID = -7312496369662304956L;
  private final int MAX_BYTES = 256;
  private String apiVersion = "";
  private String appVerCode = "";
  private String appVersion = "";
  private String locale = "";
  private String os = "";
  private String phoneBrand = "";
  private String phoneModel = "";
  private String tag = "";
  private String timestamp = "";

  private static void sendEvent(final Context paramContext, final Event paramEvent)
  {
    String str = Thread.currentThread().getName();
    if (!str.equals("main"))
    {
      Log.d(G.TAG, "Error in thread: " + str);
      transmitEvent(paramContext, paramEvent);
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
        Event.transmitEvent(paramContext, paramEvent);
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

  public static void submitEvent(Context paramContext, Event paramEvent)
  {
    sendEvent(paramContext, paramEvent);
  }

  public static boolean transmitEvent(Context paramContext, Event paramEvent)
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG)
    {
      Log.d(G.TAG, "URL: " + G.ANALYTICS_URL);
      Log.d(G.TAG, "APIKEY: " + G.API_KEY);
    }
    label333: StringBuilder localStringBuilder;
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
        new ArrayList().add(new BasicNameValuePair("data", paramEvent.getFlatLine()));
        localHttpPost.setEntity(new StringEntity(paramEvent.getFlatLine()));
        localHttpEntity = ((DefaultHttpClient)localObject).execute(localHttpPost).getEntity();
        if (localHttpEntity != null)
          break label333;
        Log.w(G.TAG, "It seems that there is no internet connectivity");
        throw new Exception("no internet connection");
      }
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      while (true)
      {
        EventsMechanism.getInstance(paramContext).saveEvent(paramEvent);
        Log.w(G.TAG, "Transmitting event ClientProtocolException " + localClientProtocolException.getMessage());
        if (BugSenseHandler.I_WANT_TO_DEBUG)
          localClientProtocolException.printStackTrace();
        return false;
        Object localObject = new DefaultHttpClient();
      }
    }
    catch (IOException localIOException)
    {
      HttpEntity localHttpEntity;
      EventsMechanism.getInstance(paramContext).saveEvent(paramEvent);
      Log.w(G.TAG, "Transmitting event IOException " + localIOException.getMessage());
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
      EventsMechanism.getInstance(paramContext).saveEvent(paramEvent);
      Log.w(G.TAG, "Transmitting event Exception " + localException.getMessage());
      if (BugSenseHandler.I_WANT_TO_DEBUG)
        localException.printStackTrace();
      return false;
    }
    if (BugSenseHandler.I_WANT_TO_DEBUG)
      Log.i(G.TAG, "Event Response '" + paramEvent.tag + "' :" + localStringBuilder.toString());
    return true;
  }

  public String getFlatLine()
  {
    String str1 = this.apiVersion + ":";
    String str2 = ":" + this.phoneModel + ":" + this.phoneBrand + ":" + this.os + ":" + this.appVersion + ":" + this.locale + ":" + this.timestamp;
    int i = 256 - (str1.getBytes().length + str2.getBytes().length);
    if (this.tag.getBytes().length > i)
      this.tag = this.tag.substring(0, i);
    return this.apiVersion + ":" + this.tag + ":" + this.phoneModel + ":" + this.phoneBrand + ":" + this.os + ":" + this.appVersion + ":" + this.locale + ":" + this.timestamp;
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
    if (paramString.getBytes().length > 256);
    for (this.tag = paramString.substring(0, 256); ; this.tag = paramString)
    {
      if ((this.tag.equals("_ping")) || (this.tag.equals("_gnip")))
        this.tag = this.tag.replaceAll("_", "-");
      if ((this.tag.contains(":")) || (this.tag.contains("|")))
        this.tag = this.tag.replaceAll(":", "_").replace("|", "_");
      return;
    }
  }

  public void setTimestamp(long paramLong)
  {
    this.timestamp = Long.toString(paramLong);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.bugsense.trace.models.Event
 * JD-Core Version:    0.6.2
 */