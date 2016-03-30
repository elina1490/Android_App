package com.bugsense.trace;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;

public abstract class ActivityAsyncTask<Connect, Params, Progress, Result> extends AsyncTask<Params, Progress, Result>
{
  private volatile boolean mPostProcessingDone = false;
  private Result mResult;
  protected volatile Connect mWrapped;

  public ActivityAsyncTask(Connect paramConnect)
  {
    connectTo(paramConnect);
  }

  public void connectTo(Connect paramConnect)
  {
    if ((this.mWrapped != null) && (paramConnect != null))
      throw new IllegalStateException();
    this.mWrapped = paramConnect;
    if (this.mWrapped != null)
    {
      if (getStatus() != AsyncTask.Status.RUNNING)
        break label46;
      onPreExecute();
    }
    label46: 
    while ((getStatus() != AsyncTask.Status.FINISHED) || (this.mPostProcessingDone))
      return;
    this.mPostProcessingDone = true;
    processPostExecute(this.mResult);
    this.mResult = null;
  }

  protected void onPostExecute(Result paramResult)
  {
    super.onPostExecute(paramResult);
    if (this.mWrapped != null)
    {
      this.mPostProcessingDone = true;
      processPostExecute(paramResult);
      return;
    }
    this.mResult = paramResult;
  }

  public boolean postProcessingDone()
  {
    return this.mPostProcessingDone;
  }

  protected abstract void processPostExecute(Result paramResult);
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.bugsense.trace.ActivityAsyncTask
 * JD-Core Version:    0.6.2
 */