package com.google.appinventor.components.runtime.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.extensions.android2.auth.GoogleAccountManager;
import java.io.IOException;

public class OAuth2Helper
{
  public static final String PREF_ACCOUNT_NAME = "accountName";
  public static final String PREF_AUTH_TOKEN = "authToken";
  public static final String TAG = "OAuthHelper";
  private static String errorMessage = "Error during OAuth";

  private AccountManagerFuture<Bundle> getAccountManagerResult(Activity paramActivity, GoogleCredential paramGoogleCredential, String paramString1, String paramString2)
  {
    GoogleAccountManager localGoogleAccountManager = new GoogleAccountManager(paramActivity);
    localGoogleAccountManager.invalidateAuthToken(paramGoogleCredential.getAccessToken());
    AccountManager.get(paramActivity).invalidateAuthToken(paramString1, null);
    Account localAccount = localGoogleAccountManager.getAccountByName(paramString2);
    if (localAccount != null)
    {
      Log.i("OAuthHelper", "Getting token by account");
      return localGoogleAccountManager.getAccountManager().getAuthToken(localAccount, paramString1, true, null, null);
    }
    Log.i("OAuthHelper", "Getting token by features, possibly prompting user to select an account");
    return localGoogleAccountManager.getAccountManager().getAuthTokenByFeatures("com.google", paramString1, null, paramActivity, null, null, null, null);
  }

  public static String getErrorMessage()
  {
    Log.i("OAuthHelper", "getErrorMessage = " + errorMessage);
    return errorMessage;
  }

  private boolean isUiThread()
  {
    return Looper.getMainLooper().getThread().equals(Thread.currentThread());
  }

  private void persistCredentials(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    Log.i("OAuthHelper", "Persisting credentials, acct =" + paramString1);
    SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
    localEditor.putString("accountName", paramString1);
    localEditor.putString("authToken", paramString2);
    localEditor.commit();
  }

  public static void resetAccountCredential(Activity paramActivity)
  {
    Log.i("OAuthHelper", "Reset credentials");
    SharedPreferences.Editor localEditor = paramActivity.getPreferences(0).edit();
    localEditor.remove("authToken");
    localEditor.remove("accountName");
    localEditor.commit();
  }

  public String getRefreshedAuthToken(Activity paramActivity, String paramString)
  {
    Log.i("OAuthHelper", "getRefreshedAuthToken()");
    if (isUiThread())
      throw new IllegalArgumentException("Can't get authtoken from UI thread");
    SharedPreferences localSharedPreferences = paramActivity.getPreferences(0);
    String str1 = localSharedPreferences.getString("accountName", null);
    String str2 = localSharedPreferences.getString("authToken", null);
    GoogleCredential localGoogleCredential = new GoogleCredential();
    localGoogleCredential.setAccessToken(str2);
    AccountManagerFuture localAccountManagerFuture = getAccountManagerResult(paramActivity, localGoogleCredential, paramString, str1);
    try
    {
      Bundle localBundle = (Bundle)localAccountManagerFuture.getResult();
      str2 = localBundle.get("authtoken").toString();
      persistCredentials(localSharedPreferences, localBundle.getString("authAccount"), str2);
      return str2;
    }
    catch (OperationCanceledException localOperationCanceledException)
    {
      localOperationCanceledException.printStackTrace();
      resetAccountCredential(paramActivity);
      errorMessage = "Error: operation cancelled";
      return str2;
    }
    catch (AuthenticatorException localAuthenticatorException)
    {
      localAuthenticatorException.printStackTrace();
      errorMessage = "Error: Authenticator error";
      return str2;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      errorMessage = "Error: I/O error";
    }
    return str2;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.OAuth2Helper
 * JD-Core Version:    0.6.2
 */