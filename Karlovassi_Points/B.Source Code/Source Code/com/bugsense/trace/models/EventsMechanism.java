package com.bugsense.trace.models;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Log;
import com.bugsense.trace.BugSenseHandler;
import com.bugsense.trace.G;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public final class EventsMechanism
{
  private static final int MAX_LIST_SIZE = 12;
  private static final String fileName = "bevents";
  private static EventsMechanism instance;
  private Context ctx;

  public static EventsMechanism getInstance(Context paramContext)
  {
    if (instance == null)
      instance = new EventsMechanism();
    instance.ctx = paramContext;
    return instance;
  }

  public void clearList()
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG)
      Log.d(G.TAG, "clearing events list");
    saveList(new ArrayList(0));
  }

  // ERROR //
  public ArrayList<Event> getList()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 63	java/io/ObjectInputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 23	com/bugsense/trace/models/EventsMechanism:ctx	Landroid/content/Context;
    //   10: ldc 11
    //   12: invokevirtual 69	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   15: invokespecial 72	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: invokevirtual 76	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   23: checkcast 50	java/util/ArrayList
    //   26: astore 6
    //   28: aload_2
    //   29: invokevirtual 79	java/io/ObjectInputStream:close	()V
    //   32: aload 6
    //   34: astore_1
    //   35: aload_1
    //   36: ifnonnull +11 -> 47
    //   39: new 50	java/util/ArrayList
    //   42: dup
    //   43: invokespecial 80	java/util/ArrayList:<init>	()V
    //   46: astore_1
    //   47: getstatic 35	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   50: ifeq +37 -> 87
    //   53: getstatic 40	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   56: new 82	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   63: ldc 85
    //   65: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 93	java/util/ArrayList:size	()I
    //   72: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: ldc 98
    //   77: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 48	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: aload_1
    //   88: areturn
    //   89: astore_3
    //   90: getstatic 35	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   93: ifeq -58 -> 35
    //   96: getstatic 40	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   99: ldc 104
    //   101: invokestatic 48	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   104: pop
    //   105: goto -70 -> 35
    //   108: astore 7
    //   110: aload 6
    //   112: astore_1
    //   113: goto -23 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   2	28	89	java/lang/Exception
    //   28	32	108	java/lang/Exception
  }

  public void saveEvent(Event paramEvent)
  {
    ArrayList localArrayList = getList();
    localArrayList.add(paramEvent);
    saveList(localArrayList);
  }

  public void saveList(ArrayList<Event> paramArrayList)
  {
    if (paramArrayList.size() > 12)
      paramArrayList.remove(0);
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(this.ctx.openFileOutput("bevents", 0));
      localObjectOutputStream.writeObject(paramArrayList);
      localObjectOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      do
        Log.d(G.TAG, "Could not save events list");
      while (!BugSenseHandler.I_WANT_TO_DEBUG);
      localException.printStackTrace();
    }
  }

  public void sendSavedEventsREMOVED()
  {
    final ArrayList localArrayList = getList();
    AsyncTask local1;
    if (localArrayList.size() > 0)
    {
      local1 = new AsyncTask()
      {
        protected Object doInBackground(Object[] paramAnonymousArrayOfObject)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(localArrayList);
          EventsMechanism.this.clearList();
          for (int i = 0; ; i++)
            if (i < localArrayList.size())
            {
              Event localEvent = (Event)localArrayList.get(i);
              if (!Event.transmitEvent(EventsMechanism.this.ctx, localEvent))
              {
                int j = localArrayList.size();
                if (j > 12)
                  j -= j - 12;
                if (BugSenseHandler.I_WANT_TO_DEBUG)
                  Log.d(G.TAG, "Could not send event, saving the rest: " + String.valueOf(j) + " items");
                localArrayList.clear();
                localArrayList.addAll(localArrayList.subList(i, j));
                EventsMechanism.this.saveList(localArrayList);
              }
            }
            else
            {
              return null;
            }
        }

        protected void onPostExecute(Object paramAnonymousObject)
        {
          super.onPostExecute(paramAnonymousObject);
        }

        protected void onPreExecute()
        {
          super.onPreExecute();
        }
      };
      if (Build.VERSION.SDK_INT >= 11)
        local1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }
    else
    {
      return;
    }
    local1.execute(new Object[0]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.bugsense.trace.models.EventsMechanism
 * JD-Core Version:    0.6.2
 */