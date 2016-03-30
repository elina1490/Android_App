package com.google.appinventor.components.runtime.util;

import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebServiceUtil
{
  private static final WebServiceUtil INSTANCE = new WebServiceUtil();
  private static final String LOG_TAG = "WebServiceUtil";
  private static HttpClient httpClient = null;
  private static Object httpClientSynchronizer = new Object();

  public static WebServiceUtil getInstance()
  {
    synchronized (httpClientSynchronizer)
    {
      if (httpClient == null)
      {
        SchemeRegistry localSchemeRegistry = new SchemeRegistry();
        localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
        ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 20);
        httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      }
      return INSTANCE;
    }
  }

  public void postCommand(String paramString1, String paramString2, List<NameValuePair> paramList, AsyncCallbackPair<String> paramAsyncCallbackPair)
  {
    Log.d("WebServiceUtil", "Posting " + paramString2 + " to " + paramString1 + " with arguments " + paramList);
    if ((paramString1 == null) || (paramString1.equals("")))
      paramAsyncCallbackPair.onFailure("No service url to post command to.");
    HttpPost localHttpPost = new HttpPost(paramString1 + "/" + paramString2);
    if (paramList == null)
      paramList = new ArrayList();
    try
    {
      BasicResponseHandler localBasicResponseHandler = new BasicResponseHandler();
      localHttpPost.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
      localHttpPost.setHeader("Accept", "application/json");
      paramAsyncCallbackPair.onSuccess((String)httpClient.execute(localHttpPost, localBasicResponseHandler));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.w("WebServiceUtil", localUnsupportedEncodingException);
      paramAsyncCallbackPair.onFailure("Failed to encode params for web service call.");
      return;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      Log.w("WebServiceUtil", localClientProtocolException);
      paramAsyncCallbackPair.onFailure("Communication with the web service encountered a protocol exception.");
      return;
    }
    catch (IOException localIOException)
    {
      Log.w("WebServiceUtil", localIOException);
      paramAsyncCallbackPair.onFailure("Communication with the web service timed out.");
    }
  }

  public void postCommandReturningArray(String paramString1, String paramString2, List<NameValuePair> paramList, final AsyncCallbackPair<JSONArray> paramAsyncCallbackPair)
  {
    postCommand(paramString1, paramString2, paramList, new AsyncCallbackPair()
    {
      public void onFailure(String paramAnonymousString)
      {
        paramAsyncCallbackPair.onFailure(paramAnonymousString);
      }

      public void onSuccess(String paramAnonymousString)
      {
        try
        {
          paramAsyncCallbackPair.onSuccess(new JSONArray(paramAnonymousString));
          return;
        }
        catch (JSONException localJSONException)
        {
          paramAsyncCallbackPair.onFailure(localJSONException.getMessage());
        }
      }
    });
  }

  public void postCommandReturningObject(String paramString1, String paramString2, List<NameValuePair> paramList, final AsyncCallbackPair<JSONObject> paramAsyncCallbackPair)
  {
    postCommand(paramString1, paramString2, paramList, new AsyncCallbackPair()
    {
      public void onFailure(String paramAnonymousString)
      {
        paramAsyncCallbackPair.onFailure(paramAnonymousString);
      }

      public void onSuccess(String paramAnonymousString)
      {
        try
        {
          paramAsyncCallbackPair.onSuccess(new JSONObject(paramAnonymousString));
          return;
        }
        catch (JSONException localJSONException)
        {
          paramAsyncCallbackPair.onFailure(localJSONException.getMessage());
        }
      }
    });
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.WebServiceUtil
 * JD-Core Version:    0.6.2
 */