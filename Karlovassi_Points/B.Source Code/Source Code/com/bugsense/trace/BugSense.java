package com.bugsense.trace;

import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BugSense
{
  private static ActivityAsyncTask<Processor, Object, Object, Object> sTask;

  protected static String readLogs()
  {
    int i = G.LOG_LINES;
    if (i < 0)
      i = 100;
    String str1 = G.LOG_FILTER;
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d " + str1).getInputStream()));
      localArrayList = new ArrayList();
      while (true)
      {
        String str2 = localBufferedReader.readLine();
        if (str2 == null)
          break;
        localArrayList.add(str2);
      }
    }
    catch (Exception localException)
    {
      Log.e(G.TAG, "Error reading logcat output!");
      if (BugSenseHandler.I_WANT_TO_DEBUG)
        localException.printStackTrace();
      return localException.getMessage();
    }
    if (localArrayList.size() == 0)
      return "You must add the android.permission.READ_LOGS permission to your manifest file!";
    int j = localArrayList.size() - i;
    if (j < 0)
      j = 0;
    while (true)
    {
      int k;
      if (k < localArrayList.size())
      {
        localStringBuilder.append((String)localArrayList.get(k) + "\n");
        k++;
      }
      else
      {
        String str3 = localStringBuilder.toString();
        return str3;
        k = j;
      }
    }
  }

  public static abstract interface Processor
  {
    public abstract boolean beginSubmit();

    public abstract void handlerInstalled();

    public abstract void submitDone();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.bugsense.trace.BugSense
 * JD-Core Version:    0.6.2
 */