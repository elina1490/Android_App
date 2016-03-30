package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.SdkLevel;

@DesignerComponent(category=ComponentCategory.MISC, description="Component that creates alert messages, popup dialogs, and log entries.", iconName="images/notifier.png", nonVisible=true, version=1)
@SimpleObject
public final class Notifier extends AndroidNonvisibleComponent
  implements Component
{
  private static final String LOG_TAG = "Notifier";
  private final Activity activity;
  private final Handler handler;

  public Notifier(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.activity = paramComponentContainer.$context();
    this.handler = new Handler();
  }

  private void oneButtonAlert(String paramString1, String paramString2, String paramString3)
  {
    Log.i("Notifier", "One button alert " + paramString1);
    AlertDialog localAlertDialog = new AlertDialog.Builder(this.activity).create();
    localAlertDialog.setTitle(paramString2);
    localAlertDialog.setCancelable(false);
    localAlertDialog.setMessage(paramString1);
    localAlertDialog.setButton(paramString3, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
      }
    });
    localAlertDialog.show();
  }

  private void textInputAlert(String paramString1, String paramString2)
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this.activity).create();
    localAlertDialog.setTitle(paramString2);
    localAlertDialog.setMessage(paramString1);
    final EditText localEditText = new EditText(this.activity);
    localAlertDialog.setView(localEditText);
    localAlertDialog.setCancelable(false);
    localAlertDialog.setButton("OK", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Notifier.this.AfterTextInput(localEditText.getText().toString());
      }
    });
    localAlertDialog.show();
  }

  private void toastNow(String paramString)
  {
    if (SdkLevel.getLevel() >= 14);
    for (int i = 22; ; i = 15)
    {
      Toast localToast = Toast.makeText(this.activity, paramString, 1);
      localToast.setGravity(17, localToast.getXOffset() / 2, localToast.getYOffset() / 2);
      TextView localTextView = new TextView(this.activity);
      localTextView.setBackgroundColor(-12303292);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(i);
      localTextView.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
      localTextView.setPadding(10, 10, 10, 10);
      localTextView.setText(paramString);
      localToast.setView(localTextView);
      localToast.show();
      return;
    }
  }

  private void twoButtonAlert(String paramString1, String paramString2, final String paramString3, final String paramString4)
  {
    Log.i("Notifier", "ShowChooseDialog: " + paramString1);
    AlertDialog localAlertDialog = new AlertDialog.Builder(this.activity).create();
    localAlertDialog.setTitle(paramString2);
    localAlertDialog.setCancelable(false);
    localAlertDialog.setMessage(paramString1);
    localAlertDialog.setButton(paramString3, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Notifier.this.AfterChoosing(paramString3);
      }
    });
    localAlertDialog.setButton2(paramString4, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Notifier.this.AfterChoosing(paramString4);
      }
    });
    localAlertDialog.show();
  }

  @SimpleEvent
  public void AfterChoosing(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "AfterChoosing", new Object[] { paramString });
  }

  @SimpleEvent
  public void AfterTextInput(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "AfterTextInput", new Object[] { paramString });
  }

  @SimpleFunction
  public void LogError(String paramString)
  {
    Log.e("Notifier", paramString);
  }

  @SimpleFunction
  public void LogInfo(String paramString)
  {
    Log.i("Notifier", paramString);
  }

  @SimpleFunction
  public void LogWarning(String paramString)
  {
    Log.w("Notifier", paramString);
  }

  @SimpleFunction
  public void ShowAlert(final String paramString)
  {
    this.handler.post(new Runnable()
    {
      public void run()
      {
        Notifier.this.toastNow(paramString);
      }
    });
  }

  @SimpleFunction
  public void ShowChooseDialog(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    twoButtonAlert(paramString1, paramString2, paramString3, paramString4);
  }

  @SimpleFunction
  public void ShowMessageDialog(String paramString1, String paramString2, String paramString3)
  {
    oneButtonAlert(paramString1, paramString2, paramString3);
  }

  @SimpleFunction
  public void ShowTextDialog(String paramString1, String paramString2)
  {
    textInputAlert(paramString1, paramString2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Notifier
 * JD-Core Version:    0.6.2
 */