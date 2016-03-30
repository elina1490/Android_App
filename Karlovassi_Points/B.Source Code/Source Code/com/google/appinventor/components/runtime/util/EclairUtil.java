package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.content.Context;
import com.bugsense.trace.BugSenseHandler;

public class EclairUtil
{
  public static void overridePendingTransitions(Activity paramActivity, int paramInt1, int paramInt2)
  {
    paramActivity.overridePendingTransition(paramInt1, paramInt2);
  }

  public static void setupBugSense(Context paramContext, String paramString)
  {
    BugSenseHandler.initAndStartSession(paramContext, paramString);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.EclairUtil
 * JD-Core Version:    0.6.2
 */