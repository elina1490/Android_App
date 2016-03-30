package com.bugsense.trace;

import android.util.Log;
import com.bugsense.trace.models.Crash;
import java.io.PrintWriter;
import java.io.StringWriter;

public class DefaultExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private Thread.UncaughtExceptionHandler defaultExceptionHandler;

  public DefaultExceptionHandler(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.defaultExceptionHandler = paramUncaughtExceptionHandler;
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    long l1 = 0L;
    try
    {
      long l2 = System.currentTimeMillis();
      long l3 = G.TIMESTAMP;
      l1 = l2 - l3;
      label40: Crash localCrash = new Crash();
      localCrash.setHandled(1);
      localCrash.setAndroidVersion(G.ANDROID_VERSION);
      localCrash.setAppPackage(G.APP_PACKAGE);
      localCrash.setAppVerCode(G.APP_VERSIONCODE);
      localCrash.setAppVersion(G.APP_VERSION);
      if (G.SEND_LOG)
        localCrash.setConsoleLogs(BugSense.readLogs());
      localCrash.setDate(String.valueOf(System.currentTimeMillis()));
      localCrash.setExtraData(BugSenseHandler.getCrashExtraData());
      localCrash.setIsGPSOn(Utils.isGPSOn(BugSenseHandler.gContext));
      localCrash.setIsMobileNetworkOn(Utils.isMobileNetworkOn(BugSenseHandler.gContext));
      localCrash.setIsWifiOn(Utils.isWifiOn(BugSenseHandler.gContext));
      localCrash.setMs_from_start(String.valueOf(l1));
      localCrash.setPhoneModel(G.PHONE_MODEL);
      localCrash.setPhoneBrand(G.PHONE_BRAND);
      localCrash.setRooted(String.valueOf(G.HAS_ROOT));
      localCrash.setScreenProperties(Utils.ScreenProperties(BugSenseHandler.gContext));
      localCrash.setStacktrace(localStringWriter.toString());
      Crash.sendCrash(BugSenseHandler.gContext, localCrash);
      if (BugSenseHandler.I_WANT_TO_DEBUG)
        Log.d(G.TAG, localStringWriter.toString());
      try
      {
        Thread.sleep(3000L);
        this.defaultExceptionHandler.uncaughtException(paramThread, paramThrowable);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          localInterruptedException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      break label40;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.bugsense.trace.DefaultExceptionHandler
 * JD-Core Version:    0.6.2
 */