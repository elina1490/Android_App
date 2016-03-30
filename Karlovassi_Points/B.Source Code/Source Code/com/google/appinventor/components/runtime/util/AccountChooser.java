package com.google.appinventor.components.runtime.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.SynchronousQueue;

public class AccountChooser
{
  private static final String ACCOUNT_PREFERENCE = "account";
  private static final String ACCOUNT_TYPE = "com.google";
  private static final String LOG_TAG = "AccountChooser";
  private static final String NO_ACCOUNT = "";
  private AccountManager accountManager;
  private Activity activity;
  private String chooseAccountPrompt;
  private String preferencesKey;
  private String service;

  public AccountChooser(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    this.activity = paramActivity;
    this.service = paramString1;
    this.chooseAccountPrompt = paramString2;
    this.preferencesKey = paramString3;
    this.accountManager = AccountManager.get(paramActivity);
  }

  private Account chooseAccount(String paramString, Account[] paramArrayOfAccount)
  {
    int i = paramArrayOfAccount.length;
    for (int j = 0; j < i; j++)
    {
      Account localAccount = paramArrayOfAccount[j];
      if (localAccount.name.equals(paramString))
      {
        Log.i("AccountChooser", "chose account: " + paramString);
        return localAccount;
      }
    }
    return null;
  }

  private String createAccount()
  {
    Log.i("AccountChooser", "Adding auth token account ...");
    AccountManagerFuture localAccountManagerFuture = this.accountManager.addAccount("com.google", this.service, null, null, this.activity, null, null);
    try
    {
      String str = ((Bundle)localAccountManagerFuture.getResult()).getString("authAccount");
      Log.i("AccountChooser", "created: " + str);
      return str;
    }
    catch (OperationCanceledException localOperationCanceledException)
    {
      localOperationCanceledException.printStackTrace();
      return null;
    }
    catch (AuthenticatorException localAuthenticatorException)
    {
      while (true)
        localAuthenticatorException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  private String getPersistedAccountName()
  {
    return getPreferences().getString("account", null);
  }

  private SharedPreferences getPreferences()
  {
    return this.activity.getSharedPreferences(this.preferencesKey, 0);
  }

  private void persistAccountName(String paramString)
  {
    Log.i("AccountChooser", "persisting account: " + paramString);
    getPreferences().edit().putString("account", paramString).commit();
  }

  private String selectAccount(Account[] paramArrayOfAccount)
  {
    SynchronousQueue localSynchronousQueue = new SynchronousQueue();
    new SelectAccount(paramArrayOfAccount, localSynchronousQueue).start();
    Log.i("AccountChooser", "Select: waiting for user...");
    String str;
    try
    {
      str = (String)localSynchronousQueue.take();
      Log.i("AccountChooser", "Selected: " + str);
      if (str == "")
        return null;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
      {
        localInterruptedException.printStackTrace();
        str = null;
      }
    }
    return str;
  }

  public Account findAccount()
  {
    Account[] arrayOfAccount = this.accountManager.getAccountsByType("com.google");
    if (arrayOfAccount.length == 1)
    {
      persistAccountName(arrayOfAccount[0].name);
      return arrayOfAccount[0];
    }
    if (arrayOfAccount.length == 0)
    {
      String str3 = createAccount();
      if (str3 != null)
      {
        persistAccountName(str3);
        return this.accountManager.getAccountsByType("com.google")[0];
      }
      Log.i("AccountChooser", "User failed to create a valid account");
      return null;
    }
    String str1 = getPersistedAccountName();
    if (str1 != null)
    {
      Account localAccount = chooseAccount(str1, arrayOfAccount);
      if (localAccount != null)
        return localAccount;
    }
    String str2 = selectAccount(arrayOfAccount);
    if (str2 != null)
    {
      persistAccountName(str2);
      return chooseAccount(str2, arrayOfAccount);
    }
    Log.i("AccountChooser", "User failed to choose an account");
    return null;
  }

  public void forgetAccountName()
  {
    getPreferences().edit().remove("account").commit();
  }

  class SelectAccount extends Thread
    implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener
  {
    private String[] accountNames;
    private SynchronousQueue<String> queue;

    SelectAccount(SynchronousQueue<String> arg2)
    {
      Object localObject2;
      this.queue = localObject2;
      Object localObject1;
      this.accountNames = new String[localObject1.length];
      for (int i = 0; i < localObject1.length; i++)
        this.accountNames[i] = localObject1[i].name;
    }

    public void onCancel(DialogInterface paramDialogInterface)
    {
      Log.i("AccountChooser", "Chose: canceled");
      onClick(paramDialogInterface, -1);
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      if (paramInt >= 0);
      try
      {
        String str = this.accountNames[paramInt];
        Log.i("AccountChooser", "Chose: " + str);
        this.queue.put(str);
        while (true)
        {
          label47: paramDialogInterface.dismiss();
          return;
          this.queue.put("");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label47;
      }
    }

    public void run()
    {
      AccountChooser.this.activity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          new AlertDialog.Builder(AccountChooser.this.activity).setTitle(Html.fromHtml(AccountChooser.this.chooseAccountPrompt)).setOnCancelListener(AccountChooser.SelectAccount.this).setSingleChoiceItems(AccountChooser.SelectAccount.this.accountNames, -1, AccountChooser.SelectAccount.this).show();
          Log.i("AccountChooser", "Dialog showing!");
        }
      });
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.AccountChooser
 * JD-Core Version:    0.6.2
 */