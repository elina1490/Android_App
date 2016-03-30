package com.google.appinventor.components.runtime.util;

import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.collect.Lists;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

public class ReplCommController
{
  public static final int BLOCKS_EDITOR_PORT = 9987;
  private static final String LOG_TAG = "REPL Controller";
  private REPLServerController blocksEditorReplController;
  private boolean everStarted = false;
  private Form form;
  private final Handler handler;

  public ReplCommController(Form paramForm)
  {
    this.form = paramForm;
    this.handler = new Handler();
    this.blocksEditorReplController = new REPLServerController(9987);
  }

  public void destroy()
  {
    this.blocksEditorReplController.StopServer();
  }

  public void startListening(boolean paramBoolean)
  {
    if (this.everStarted);
    do
    {
      do
        return;
      while (this.blocksEditorReplController.ServerRunning());
      this.blocksEditorReplController.StartServer();
      this.everStarted = true;
    }
    while (!paramBoolean);
    new Notifier(this.form).ShowAlert("Listening to App Inventor. Your App should display shortly.");
  }

  public void stopListening(boolean paramBoolean)
  {
  }

  private class REPLServerController
  {
    private final Object lock = new Object();
    private List<Socket> openClientSockets;
    private int port;
    private Thread serverThread;
    private ServerSocket socket;

    public REPLServerController(int arg2)
    {
      int i;
      this.port = i;
      this.socket = null;
      this.serverThread = null;
      this.openClientSockets = Lists.newArrayList();
    }

    private void closeSockets()
    {
      synchronized (this.lock)
      {
        if (this.socket == null)
          break label448;
        Log.d("REPL Controller", "Trying to close server sockets for port " + this.port);
      }
      try
      {
        this.socket.close();
        this.socket = null;
        Iterator localIterator3 = this.openClientSockets.iterator();
        while (true)
          if (localIterator3.hasNext())
          {
            Socket localSocket3 = (Socket)localIterator3.next();
            try
            {
              localSocket3.close();
              this.openClientSockets = Lists.newArrayList();
              continue;
              localObject2 = finally;
              throw localObject2;
            }
            catch (IOException localIOException4)
            {
              Log.d("REPL Controller", "IOException closing client socket on port " + this.port);
              Log.d("REPL Controller", Log.getStackTraceString(localIOException4));
              this.openClientSockets = Lists.newArrayList();
            }
            finally
            {
              this.openClientSockets = Lists.newArrayList();
            }
          }
      }
      catch (IOException localIOException2)
      {
        Log.d("REPL Controller", "IOException closing server socket on port " + this.port);
        Log.d("REPL Controller", Log.getStackTraceString(localIOException2));
      }
      finally
      {
        Iterator localIterator2;
        Socket localSocket2;
        this.socket = null;
        Iterator localIterator1 = this.openClientSockets.iterator();
        while (localIterator1.hasNext())
        {
          Socket localSocket1 = (Socket)localIterator1.next();
          try
          {
            localSocket1.close();
            this.openClientSockets = Lists.newArrayList();
          }
          catch (IOException localIOException1)
          {
            Log.d("REPL Controller", "IOException closing client socket on port " + this.port);
            Log.d("REPL Controller", Log.getStackTraceString(localIOException1));
            this.openClientSockets = Lists.newArrayList();
          }
          finally
          {
            this.openClientSockets = Lists.newArrayList();
          }
        }
      }
      label448:
    }

    private Thread createServerThread()
    {
      return new Thread(new Runnable()
      {
        // ERROR //
        public void run()
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_1
          //   2: new 27	java/net/ServerSocket
          //   5: dup
          //   6: invokespecial 28	java/net/ServerSocket:<init>	()V
          //   9: astore_2
          //   10: aload_2
          //   11: iconst_1
          //   12: invokevirtual 32	java/net/ServerSocket:setReuseAddress	(Z)V
          //   15: aload_2
          //   16: new 34	java/net/InetSocketAddress
          //   19: dup
          //   20: aconst_null
          //   21: checkcast 36	java/net/InetAddress
          //   24: aload_0
          //   25: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   28: invokestatic 40	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$000	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)I
          //   31: invokespecial 43	java/net/InetSocketAddress:<init>	(Ljava/net/InetAddress;I)V
          //   34: invokevirtual 47	java/net/ServerSocket:bind	(Ljava/net/SocketAddress;)V
          //   37: aload_0
          //   38: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   41: invokestatic 51	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$100	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)Ljava/lang/Object;
          //   44: astore 13
          //   46: aload 13
          //   48: monitorenter
          //   49: aload_0
          //   50: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   53: aload_2
          //   54: invokestatic 55	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$202	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;Ljava/net/ServerSocket;)Ljava/net/ServerSocket;
          //   57: pop
          //   58: aload 13
          //   60: monitorexit
          //   61: ldc 57
          //   63: new 59	java/lang/StringBuilder
          //   66: dup
          //   67: invokespecial 60	java/lang/StringBuilder:<init>	()V
          //   70: ldc 62
          //   72: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   75: aload_0
          //   76: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   79: invokestatic 40	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$000	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)I
          //   82: invokevirtual 69	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   85: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   88: invokestatic 79	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
          //   91: pop
          //   92: invokestatic 84	java/lang/Thread:currentThread	()Ljava/lang/Thread;
          //   95: astore_1
          //   96: aload_0
          //   97: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   100: invokestatic 88	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$300	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)Ljava/lang/Thread;
          //   103: aload_1
          //   104: if_acmpne +55 -> 159
          //   107: invokestatic 93	gnu/expr/ModuleExp:mustNeverCompile	()V
          //   110: aload_2
          //   111: invokevirtual 97	java/net/ServerSocket:accept	()Ljava/net/Socket;
          //   114: astore 17
          //   116: aload_0
          //   117: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   120: invokestatic 51	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$100	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)Ljava/lang/Object;
          //   123: astore 18
          //   125: aload 18
          //   127: monitorenter
          //   128: aload_0
          //   129: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   132: invokestatic 101	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$400	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)Ljava/util/List;
          //   135: aload 17
          //   137: invokeinterface 107 2 0
          //   142: pop
          //   143: aload 18
          //   145: monitorexit
          //   146: ldc 109
          //   148: invokestatic 115	kawa/standard/Scheme:getInstance	(Ljava/lang/String;)Lgnu/expr/Language;
          //   151: aload 17
          //   153: invokestatic 121	com/google/appinventor/components/runtime/util/TelnetRepl:serve	(Lgnu/expr/Language;Ljava/net/Socket;)Ljava/lang/Thread;
          //   156: invokevirtual 124	java/lang/Thread:join	()V
          //   159: aload_0
          //   160: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   163: getfield 128	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:this$0	Lcom/google/appinventor/components/runtime/util/ReplCommController;
          //   166: invokestatic 134	com/google/appinventor/components/runtime/util/ReplCommController:access$600	(Lcom/google/appinventor/components/runtime/util/ReplCommController;)Lcom/google/appinventor/components/runtime/Form;
          //   169: invokevirtual 139	com/google/appinventor/components/runtime/Form:finish	()V
          //   172: iconst_0
          //   173: invokestatic 145	java/lang/System:exit	(I)V
          //   176: return
          //   177: astore 14
          //   179: aload 13
          //   181: monitorexit
          //   182: aload 14
          //   184: athrow
          //   185: astore 12
          //   187: aload_0
          //   188: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   191: getfield 128	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:this$0	Lcom/google/appinventor/components/runtime/util/ReplCommController;
          //   194: invokestatic 134	com/google/appinventor/components/runtime/util/ReplCommController:access$600	(Lcom/google/appinventor/components/runtime/util/ReplCommController;)Lcom/google/appinventor/components/runtime/Form;
          //   197: invokevirtual 139	com/google/appinventor/components/runtime/Form:finish	()V
          //   200: iconst_0
          //   201: invokestatic 145	java/lang/System:exit	(I)V
          //   204: return
          //   205: astore 19
          //   207: aload 18
          //   209: monitorexit
          //   210: aload 19
          //   212: athrow
          //   213: astore 4
          //   215: aload 4
          //   217: astore 5
          //   219: aload_2
          //   220: astore 6
          //   222: aload_0
          //   223: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   226: invokestatic 51	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$100	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)Ljava/lang/Object;
          //   229: astore 7
          //   231: aload 7
          //   233: monitorenter
          //   234: aload_0
          //   235: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   238: invokestatic 149	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$200	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)Ljava/net/ServerSocket;
          //   241: ifnull +89 -> 330
          //   244: aload_0
          //   245: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   248: invokestatic 149	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$200	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)Ljava/net/ServerSocket;
          //   251: aload 6
          //   253: if_acmpne +77 -> 330
          //   256: ldc 57
          //   258: new 59	java/lang/StringBuilder
          //   261: dup
          //   262: invokespecial 60	java/lang/StringBuilder:<init>	()V
          //   265: ldc 151
          //   267: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   270: aload_0
          //   271: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   274: invokestatic 40	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$000	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)I
          //   277: invokevirtual 69	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   280: ldc 153
          //   282: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   285: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   288: invokestatic 79	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
          //   291: pop
          //   292: ldc 57
          //   294: aload 5
          //   296: invokestatic 157	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
          //   299: invokestatic 79	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
          //   302: pop
          //   303: aload_0
          //   304: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   307: invokestatic 160	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$500	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)V
          //   310: aload_0
          //   311: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   314: invokestatic 88	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$300	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;)Ljava/lang/Thread;
          //   317: aload_1
          //   318: if_acmpne +12 -> 330
          //   321: aload_0
          //   322: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   325: aconst_null
          //   326: invokestatic 164	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:access$302	(Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;Ljava/lang/Thread;)Ljava/lang/Thread;
          //   329: pop
          //   330: aload 7
          //   332: monitorexit
          //   333: aload_0
          //   334: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   337: getfield 128	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:this$0	Lcom/google/appinventor/components/runtime/util/ReplCommController;
          //   340: invokestatic 134	com/google/appinventor/components/runtime/util/ReplCommController:access$600	(Lcom/google/appinventor/components/runtime/util/ReplCommController;)Lcom/google/appinventor/components/runtime/Form;
          //   343: invokevirtual 139	com/google/appinventor/components/runtime/Form:finish	()V
          //   346: iconst_0
          //   347: invokestatic 145	java/lang/System:exit	(I)V
          //   350: return
          //   351: astore 8
          //   353: aload 7
          //   355: monitorexit
          //   356: aload 8
          //   358: athrow
          //   359: astore_3
          //   360: aload_0
          //   361: getfield 17	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController$1:this$1	Lcom/google/appinventor/components/runtime/util/ReplCommController$REPLServerController;
          //   364: getfield 128	com/google/appinventor/components/runtime/util/ReplCommController$REPLServerController:this$0	Lcom/google/appinventor/components/runtime/util/ReplCommController;
          //   367: invokestatic 134	com/google/appinventor/components/runtime/util/ReplCommController:access$600	(Lcom/google/appinventor/components/runtime/util/ReplCommController;)Lcom/google/appinventor/components/runtime/Form;
          //   370: invokevirtual 139	com/google/appinventor/components/runtime/Form:finish	()V
          //   373: iconst_0
          //   374: invokestatic 145	java/lang/System:exit	(I)V
          //   377: aload_3
          //   378: athrow
          //   379: astore_3
          //   380: goto -20 -> 360
          //   383: astore 22
          //   385: aload 22
          //   387: astore 5
          //   389: aconst_null
          //   390: astore 6
          //   392: aconst_null
          //   393: astore_1
          //   394: goto -172 -> 222
          //   397: astore 21
          //   399: goto -212 -> 187
          //
          // Exception table:
          //   from	to	target	type
          //   49	61	177	finally
          //   179	182	177	finally
          //   10	49	185	java/lang/InterruptedException
          //   61	128	185	java/lang/InterruptedException
          //   146	159	185	java/lang/InterruptedException
          //   182	185	185	java/lang/InterruptedException
          //   210	213	185	java/lang/InterruptedException
          //   128	146	205	finally
          //   207	210	205	finally
          //   10	49	213	java/io/IOException
          //   61	128	213	java/io/IOException
          //   146	159	213	java/io/IOException
          //   182	185	213	java/io/IOException
          //   210	213	213	java/io/IOException
          //   234	330	351	finally
          //   330	333	351	finally
          //   353	356	351	finally
          //   2	10	359	finally
          //   222	234	359	finally
          //   356	359	359	finally
          //   10	49	379	finally
          //   61	128	379	finally
          //   146	159	379	finally
          //   182	185	379	finally
          //   210	213	379	finally
          //   2	10	383	java/io/IOException
          //   2	10	397	java/lang/InterruptedException
        }
      });
    }

    public boolean ServerRunning()
    {
      return (this.serverThread != null) && (this.serverThread.isAlive());
    }

    public void StartServer()
    {
      closeSockets();
      this.serverThread = createServerThread();
      if (this.serverThread != null)
        this.serverThread.start();
    }

    public void StopServer()
    {
      Log.d("REPL Controller", "Stopping server on port " + this.port);
      this.serverThread = null;
      closeSockets();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.ReplCommController
 * JD-Core Version:    0.6.2
 */