package com.google.appinventor.components.runtime.util;

import android.os.Handler;

public class AsynchUtil
{
  public static void runAsynchronously(final Handler paramHandler, Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        this.val$call.run();
        if (paramRunnable2 != null)
          paramHandler.post(new Runnable()
          {
            public void run()
            {
              AsynchUtil.1.this.val$callback.run();
            }
          });
      }
    }).start();
  }

  public static void runAsynchronously(Runnable paramRunnable)
  {
    new Thread(paramRunnable).start();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.AsynchUtil
 * JD-Core Version:    0.6.2
 */