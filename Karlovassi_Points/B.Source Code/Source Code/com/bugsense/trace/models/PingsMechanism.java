package com.bugsense.trace.models;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Log;
import com.bugsense.trace.BugSenseHandler;
import com.bugsense.trace.G;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public final class PingsMechanism
{
  private static final int MAX_GNIPS_SIZE = 2;
  private static final int MAX_PINGS_SIZE = 2;
  private static final String fileName = "bpings";
  private static PingsMechanism instance;
  private Context ctx;

  public static PingsMechanism getInstance(Context paramContext)
  {
    if (instance == null)
      instance = new PingsMechanism();
    instance.ctx = paramContext;
    return instance;
  }

  public static void sendPing(Context paramContext)
  {
    Ping.submitPing(paramContext);
  }

  public void clearList()
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG)
      Log.d(G.TAG, "clearing pings list");
    saveList(new ArrayList(0));
  }

  // ERROR //
  public ArrayList<Ping> getList()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 71	java/io/ObjectInputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 24	com/bugsense/trace/models/PingsMechanism:ctx	Landroid/content/Context;
    //   10: ldc 12
    //   12: invokevirtual 77	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   15: invokespecial 80	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: invokevirtual 84	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   23: checkcast 58	java/util/ArrayList
    //   26: astore 6
    //   28: aload_2
    //   29: invokevirtual 87	java/io/ObjectInputStream:close	()V
    //   32: aload 6
    //   34: astore_1
    //   35: aload_1
    //   36: ifnonnull +11 -> 47
    //   39: new 58	java/util/ArrayList
    //   42: dup
    //   43: invokespecial 88	java/util/ArrayList:<init>	()V
    //   46: astore_1
    //   47: getstatic 43	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   50: ifeq +37 -> 87
    //   53: getstatic 48	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   56: new 90	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   63: ldc 93
    //   65: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 101	java/util/ArrayList:size	()I
    //   72: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: ldc 106
    //   77: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: aload_1
    //   88: areturn
    //   89: astore_3
    //   90: getstatic 43	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   93: ifeq -58 -> 35
    //   96: getstatic 48	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   99: ldc 112
    //   101: invokestatic 56	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
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

  public void saveList(ArrayList<Ping> paramArrayList)
  {
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(this.ctx.openFileOutput("bpings", 0));
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

  public void savePing(Ping paramPing)
  {
    ArrayList localArrayList = getList();
    int i = 0;
    int j = 0;
    int k = 0;
    if (i < localArrayList.size())
    {
      int i2;
      int i1;
      if (((Ping)localArrayList.get(i)).getTag().equals("_ping"))
      {
        int i3 = k + 1;
        int i4 = j;
        i2 = i3;
        i1 = i4;
      }
      while (true)
      {
        i++;
        k = i2;
        j = i1;
        break;
        i1 = j + 1;
        i2 = k;
      }
    }
    localArrayList.add(paramPing);
    int n;
    if (paramPing.getTag().equals("_ping"))
      if (k > 2)
      {
        n = 0;
        if (n < localArrayList.size())
        {
          if (!((Ping)localArrayList.get(n)).getTag().equals("_ping"))
            break label154;
          localArrayList.remove(n);
        }
      }
    label154: label212: 
    while (true)
    {
      saveList(localArrayList);
      return;
      n++;
      break;
      if (j > 2)
        for (int m = 0; ; m++)
        {
          if (m >= localArrayList.size())
            break label212;
          if (((Ping)localArrayList.get(m)).getTag().equals("_gnip"))
          {
            localArrayList.remove(m);
            break;
          }
        }
    }
  }

  public void sendSavedPings()
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
          PingsMechanism.this.clearList();
          for (int i = 0; ; i++)
            if (i < localArrayList.size())
            {
              Ping localPing = (Ping)localArrayList.get(i);
              if (!Ping.transmitPing(PingsMechanism.this.ctx, localPing))
              {
                int j = localArrayList.size();
                if (j > 4)
                  j -= j - 4;
                if (BugSenseHandler.I_WANT_TO_DEBUG)
                  Log.d(G.TAG, "Could not send ping, saving the rest: " + String.valueOf(j) + " items");
                localArrayList.clear();
                localArrayList.addAll(localArrayList.subList(i, j));
                PingsMechanism.this.saveList(localArrayList);
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
 * Qualified Name:     com.bugsense.trace.models.PingsMechanism
 * JD-Core Version:    0.6.2
 */