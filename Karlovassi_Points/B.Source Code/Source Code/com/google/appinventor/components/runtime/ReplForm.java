package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.appinventor.components.runtime.util.AppInvHTTPD;
import com.google.appinventor.components.runtime.util.EclairUtil;
import com.google.appinventor.components.runtime.util.ReplCommController;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.File;
import java.io.IOException;

public class ReplForm extends Form
{
  private static final String BUGSENSE_API_KEY = "195de24b";
  private static final String REPL_ASSET_DIR = "/sdcard/AppInventor/assets/";
  public static ReplForm topform;
  private boolean IsUSBRepl = false;
  private AppInvHTTPD assetServer = null;
  private ReplCommController formReplCommController = null;

  public ReplForm()
  {
    topform = this;
  }

  private void checkAssetDir()
  {
    File localFile = new File("/sdcard/AppInventor/assets/");
    if (!localFile.exists())
      localFile.mkdirs();
  }

  protected void closeApplicationFromBlocks()
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(ReplForm.this, "Closing forms is not currently supported during development.", 1).show();
      }
    });
  }

  protected void closeForm(Intent paramIntent)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(ReplForm.this, "Closing forms is not currently supported during development.", 1).show();
      }
    });
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (SdkLevel.getLevel() > 4)
      EclairUtil.setupBugSense(this, "195de24b");
    if (this.IsUSBRepl)
    {
      $context().getPackageManager().setComponentEnabledSetting(new ComponentName(getPackageName(), getClass().getName()), 2, 1);
      this.formReplCommController = new ReplCommController(this);
      this.formReplCommController.startListening(true);
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.formReplCommController != null)
      this.formReplCommController.destroy();
    if (this.assetServer != null)
    {
      this.assetServer.stop();
      this.assetServer = null;
    }
    finish();
    System.exit(0);
  }

  protected void onResume()
  {
    super.onResume();
    if (this.formReplCommController != null)
      this.formReplCommController.startListening(true);
  }

  protected void onStop()
  {
    super.onStop();
    if (this.formReplCommController != null)
      this.formReplCommController.stopListening(false);
  }

  public void setIsUSBrepl()
  {
    this.IsUSBRepl = true;
  }

  public void startHTTPD()
  {
    try
    {
      if (this.assetServer == null)
      {
        checkAssetDir();
        this.assetServer = new AppInvHTTPD(8000, new File("/sdcard/AppInventor/assets/"), this);
        Log.i("ReplForm", "started AppInvHTTPD");
      }
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("ReplForm", "Setting up NanoHTTPD: " + localIOException.toString());
    }
  }

  protected void startNewForm(String paramString, Object paramObject)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(ReplForm.this, "Switching forms is not currently supported during development.", 1).show();
      }
    });
  }

  public void startRepl()
  {
    Log.i("ReplForm", "startRepl()");
    this.formReplCommController = new ReplCommController(this);
    this.formReplCommController.startListening(true);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.ReplForm
 * JD-Core Version:    0.6.2
 */