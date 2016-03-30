package com.bugsense.trace.models;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Log;
import com.bugsense.trace.BugSenseHandler;
import com.bugsense.trace.G;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public final class CrashMechanism
{
  private static final int MAX_CRASHES = 5;
  private static final int MAX_EXCEPTIONS = 8;
  private static final int MAX_LOG_LINES = 100;
  private static final String fileName = "bcrashes";
  private static CrashMechanism instance;
  private Context ctx;

  public static CrashMechanism getInstance(Context paramContext)
  {
    if (instance == null)
      instance = new CrashMechanism();
    instance.ctx = paramContext;
    return instance;
  }

  public void clearList()
  {
    if (BugSenseHandler.I_WANT_TO_DEBUG)
      Log.d(G.TAG, "clearing pings list");
    saveList(new ArrayList(0));
  }

  // ERROR //
  public ArrayList<Crash> getList()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 67	java/io/ObjectInputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 27	com/bugsense/trace/models/CrashMechanism:ctx	Landroid/content/Context;
    //   10: ldc 15
    //   12: invokevirtual 73	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   15: invokespecial 76	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: invokevirtual 80	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   23: checkcast 54	java/util/ArrayList
    //   26: astore 6
    //   28: aload_2
    //   29: invokevirtual 83	java/io/ObjectInputStream:close	()V
    //   32: aload 6
    //   34: astore_1
    //   35: aload_1
    //   36: ifnonnull +11 -> 47
    //   39: new 54	java/util/ArrayList
    //   42: dup
    //   43: invokespecial 84	java/util/ArrayList:<init>	()V
    //   46: astore_1
    //   47: getstatic 39	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   50: ifeq +37 -> 87
    //   53: getstatic 44	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   56: new 86	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   63: ldc 89
    //   65: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 97	java/util/ArrayList:size	()I
    //   72: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: ldc 102
    //   77: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: aload_1
    //   88: areturn
    //   89: astore_3
    //   90: getstatic 39	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   93: ifeq -58 -> 35
    //   96: getstatic 44	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   99: ldc 108
    //   101: invokestatic 52	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
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

  public void saveCrash(Crash paramCrash)
  {
    ArrayList localArrayList = getList();
    int i = 0;
    if (i < localArrayList.size())
      if (!((Crash)localArrayList.get(i)).getStacktrace().equals(paramCrash.getStacktrace()));
    for (int j = 1; ; j = 0)
    {
      int m;
      int i2;
      if (j == 0)
      {
        String[] arrayOfString = paramCrash.getStacktrace().split("[\\r\\n]+");
        if ((arrayOfString != null) && (arrayOfString.length > 100))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          int i7 = arrayOfString.length - 100;
          if (i7 < 0)
            i7 = 0;
          while (true)
            if (i7 < arrayOfString.length)
            {
              localStringBuilder.append(arrayOfString[i7]);
              i7++;
              continue;
              i++;
              break;
            }
          paramCrash.setStacktrace(localStringBuilder.toString());
        }
        localArrayList.add(paramCrash);
        int k = 0;
        m = 0;
        int n = 0;
        if (k < localArrayList.size())
        {
          int i4;
          int i3;
          if (((Crash)localArrayList.get(k)).getType() == 1)
          {
            int i5 = n + 1;
            int i6 = m;
            i4 = i5;
            i3 = i6;
          }
          while (true)
          {
            k++;
            n = i4;
            m = i3;
            break;
            i3 = m + 1;
            i4 = n;
          }
        }
        if (paramCrash.getType() != 1)
          break label279;
        if (n > 5)
        {
          i2 = 0;
          if (i2 < localArrayList.size())
          {
            if (((Crash)localArrayList.get(i2)).getType() != 1)
              break label273;
            localArrayList.remove(i2);
          }
        }
      }
      label273: label279: label327: 
      while (true)
      {
        saveList(localArrayList);
        return;
        i2++;
        break;
        if (m > 8)
          for (int i1 = 0; ; i1++)
          {
            if (i1 >= localArrayList.size())
              break label327;
            if (((Crash)localArrayList.get(i1)).getType() == 0)
            {
              localArrayList.remove(i1);
              break;
            }
          }
      }
    }
  }

  public void saveList(ArrayList<Crash> paramArrayList)
  {
    if (paramArrayList != null);
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(this.ctx.openFileOutput("bcrashes", 0));
      localObjectOutputStream.writeObject(paramArrayList);
      localObjectOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      do
        Log.d(G.TAG, "Could not save crash list");
      while (!BugSenseHandler.I_WANT_TO_DEBUG);
      localException.printStackTrace();
    }
  }

  public void sendSavedCrashes()
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
          CrashMechanism.this.clearList();
          for (int i = 0; ; i++)
            if (i < localArrayList.size())
            {
              Crash localCrash = (Crash)localArrayList.get(i);
              if (!Crash.transmitCrash(CrashMechanism.this.ctx, localCrash))
              {
                int j = localArrayList.size();
                if (j > 13)
                  j -= j - 13;
                if (BugSenseHandler.I_WANT_TO_DEBUG)
                  Log.d(G.TAG, "Could not send crash, saving the rest: " + String.valueOf(j) + " items");
                localArrayList.clear();
                localArrayList.addAll(localArrayList.subList(i, j));
                CrashMechanism.this.saveList(localArrayList);
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
 * Qualified Name:     com.bugsense.trace.models.CrashMechanism
 * JD-Core Version:    0.6.2
 */