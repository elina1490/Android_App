package gnu.text;

import java.io.Writer;
import java.lang.reflect.Method;

public class WriterManager
  implements Runnable
{
  public static final WriterManager instance = new WriterManager();
  WriterRef first;

  public WriterRef register(Writer paramWriter)
  {
    try
    {
      WriterRef localWriterRef1 = new WriterRef(paramWriter);
      WriterRef localWriterRef2 = this.first;
      if (localWriterRef2 != null)
      {
        localWriterRef1.next = localWriterRef2.next;
        localWriterRef2.prev = localWriterRef1;
      }
      this.first = localWriterRef1;
      return localWriterRef1;
    }
    finally
    {
    }
  }

  public boolean registerShutdownHook()
  {
    try
    {
      Runtime localRuntime = Runtime.getRuntime();
      Method localMethod = localRuntime.getClass().getDeclaredMethod("addShutdownHook", new Class[] { Thread.class });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = new Thread(this);
      localMethod.invoke(localRuntime, arrayOfObject);
      return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	gnu/text/WriterManager:first	Lgnu/text/WriterRef;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +27 -> 35
    //   11: aload_2
    //   12: invokevirtual 73	gnu/text/WriterRef:get	()Ljava/lang/Object;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +10 -> 27
    //   20: aload_3
    //   21: checkcast 75	java/io/Writer
    //   24: invokevirtual 78	java/io/Writer:close	()V
    //   27: aload_2
    //   28: getfield 30	gnu/text/WriterRef:next	Lgnu/text/WriterRef;
    //   31: astore_2
    //   32: goto -25 -> 7
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 27	gnu/text/WriterManager:first	Lgnu/text/WriterRef;
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore 4
    //   50: goto -23 -> 27
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	43	finally
    //   11	16	43	finally
    //   20	27	43	finally
    //   27	32	43	finally
    //   35	40	43	finally
    //   20	27	48	java/lang/Exception
  }

  public void unregister(Object paramObject)
  {
    if (paramObject == null);
    while (true)
    {
      return;
      try
      {
        WriterRef localWriterRef1 = (WriterRef)paramObject;
        WriterRef localWriterRef2 = localWriterRef1.next;
        WriterRef localWriterRef3 = localWriterRef1.prev;
        if (localWriterRef2 != null)
          localWriterRef2.prev = localWriterRef3;
        if (localWriterRef3 != null)
          localWriterRef3.next = localWriterRef2;
        if (localWriterRef1 != this.first)
          continue;
        this.first = localWriterRef2;
      }
      finally
      {
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.WriterManager
 * JD-Core Version:    0.6.2
 */