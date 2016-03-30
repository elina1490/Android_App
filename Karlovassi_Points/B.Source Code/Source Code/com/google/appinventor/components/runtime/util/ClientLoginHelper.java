package com.google.appinventor.components.runtime.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClientLoginHelper
  implements IClientLoginHelper
{
  private static final String ACCOUNT_TYPE = "com.google";
  private static final String AUTHORIZATION_HEADER_PREFIX = "GoogleLogin auth=";
  private static final String LOG_TAG = "ClientLoginHelper";
  private AccountChooser accountChooser;
  private AccountManager accountManager;
  private Activity activity;
  private String authToken;
  private HttpClient client;
  private boolean initialized = false;
  private String service;

  public ClientLoginHelper(Activity paramActivity, String paramString1, String paramString2, HttpClient paramHttpClient)
  {
    this.service = paramString1;
    if (paramHttpClient == null);
    for (Object localObject = new DefaultHttpClient(); ; localObject = paramHttpClient)
    {
      this.client = ((HttpClient)localObject);
      this.activity = paramActivity;
      this.accountManager = AccountManager.get(paramActivity);
      this.accountChooser = new AccountChooser(paramActivity, paramString1, paramString2, paramString1);
      return;
    }
  }

  private static void addGoogleAuthHeader(HttpUriRequest paramHttpUriRequest, String paramString)
  {
    if (paramString != null)
    {
      Log.i("ClientLoginHelper", "adding auth token token: " + paramString);
      paramHttpUriRequest.addHeader("Authorization", "GoogleLogin auth=" + paramString);
    }
  }

  private void initialize()
    throws ClientProtocolException
  {
    if (!this.initialized)
    {
      Log.i("ClientLoginHelper", "initializing");
      if (isUiThread())
        throw new IllegalArgumentException("Can't initialize login helper from UI thread");
      this.authToken = getAuthToken();
      this.initialized = true;
    }
  }

  private boolean isUiThread()
  {
    return Looper.getMainLooper().getThread().equals(Thread.currentThread());
  }

  private static void removeGoogleAuthHeaders(HttpUriRequest paramHttpUriRequest)
  {
    for (Header localHeader : paramHttpUriRequest.getAllHeaders())
      if ((localHeader.getName().equalsIgnoreCase("Authorization")) && (localHeader.getValue().startsWith("GoogleLogin auth=")))
      {
        Log.i("ClientLoginHelper", "Removing header:" + localHeader);
        paramHttpUriRequest.removeHeader(localHeader);
      }
  }

  public HttpResponse execute(HttpUriRequest paramHttpUriRequest)
    throws ClientProtocolException, IOException
  {
    initialize();
    addGoogleAuthHeader(paramHttpUriRequest, this.authToken);
    HttpResponse localHttpResponse = this.client.execute(paramHttpUriRequest);
    if (localHttpResponse.getStatusLine().getStatusCode() == 401)
    {
      Log.i("ClientLoginHelper", "Invalid token: " + this.authToken);
      this.accountManager.invalidateAuthToken("com.google", this.authToken);
      this.authToken = getAuthToken();
      removeGoogleAuthHeaders(paramHttpUriRequest);
      addGoogleAuthHeader(paramHttpUriRequest, this.authToken);
      Log.i("ClientLoginHelper", "new token: " + this.authToken);
      localHttpResponse = this.client.execute(paramHttpUriRequest);
    }
    return localHttpResponse;
  }

  public void forgetAccountName()
  {
    this.accountChooser.forgetAccountName();
  }

  public String getAuthToken()
    throws ClientProtocolException
  {
    Account localAccount = this.accountChooser.findAccount();
    AccountManagerFuture localAccountManagerFuture;
    if (localAccount != null)
    {
      localAccountManagerFuture = this.accountManager.getAuthToken(localAccount, this.service, null, this.activity, null, null);
      Log.i("ClientLoginHelper", "Have account, auth token: " + localAccountManagerFuture);
    }
    try
    {
      String str = ((Bundle)localAccountManagerFuture.getResult()).getString("authtoken");
      return str;
    }
    catch (AuthenticatorException localAuthenticatorException)
    {
      localAuthenticatorException.printStackTrace();
      throw new ClientProtocolException("Can't get valid authentication token");
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
    catch (OperationCanceledException localOperationCanceledException)
    {
      while (true)
        localOperationCanceledException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.ClientLoginHelper
 * JD-Core Version:    0.6.2
 */