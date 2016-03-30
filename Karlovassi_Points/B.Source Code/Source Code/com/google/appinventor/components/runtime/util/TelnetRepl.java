package com.google.appinventor.components.runtime.util;

import gnu.expr.Language;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0;
import gnu.mapping.TtyInPort;
import gnu.text.FilePath;
import java.io.IOException;
import java.net.Socket;
import kawa.Telnet;
import kawa.TelnetInputStream;
import kawa.TelnetOutputStream;

public class TelnetRepl extends Procedure0
{
  private static final int REPL_STACK_SIZE = 262144;
  Language language;
  Socket socket;

  public TelnetRepl(Language paramLanguage, Socket paramSocket)
  {
    this.language = paramLanguage;
    this.socket = paramSocket;
  }

  public static Thread serve(Language paramLanguage, Socket paramSocket)
    throws IOException
  {
    Telnet localTelnet = new Telnet(paramSocket, true);
    TelnetOutputStream localTelnetOutputStream = localTelnet.getOutputStream();
    TelnetInputStream localTelnetInputStream = localTelnet.getInputStream();
    OutPort localOutPort = new OutPort(localTelnetOutputStream, FilePath.valueOf("/dev/stdout"));
    TtyInPort localTtyInPort = new TtyInPort(localTelnetInputStream, FilePath.valueOf("/dev/stdin"), localOutPort);
    BiggerFuture localBiggerFuture = new BiggerFuture(new TelnetRepl(paramLanguage, paramSocket), localTtyInPort, localOutPort, localOutPort, "Telnet Repl Thread", 262144L);
    localBiggerFuture.start();
    return localBiggerFuture;
  }

  // ERROR //
  public java.lang.Object apply0()
  {
    // Byte code:
    //   0: invokestatic 81	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: astore_1
    //   4: aload_1
    //   5: invokevirtual 85	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   8: ifnonnull +12 -> 20
    //   11: aload_1
    //   12: ldc 26
    //   14: invokevirtual 90	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   17: invokevirtual 94	java/lang/Thread:setContextClassLoader	(Ljava/lang/ClassLoader;)V
    //   20: aload_0
    //   21: getfield 18	com/google/appinventor/components/runtime/util/TelnetRepl:language	Lgnu/expr/Language;
    //   24: invokestatic 100	gnu/mapping/Environment:getCurrent	()Lgnu/mapping/Environment;
    //   27: invokestatic 106	kawa/Shell:run	(Lgnu/expr/Language;Lgnu/mapping/Environment;)Z
    //   30: pop
    //   31: getstatic 112	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   34: astore 7
    //   36: aload_0
    //   37: getfield 20	com/google/appinventor/components/runtime/util/TelnetRepl:socket	Ljava/net/Socket;
    //   40: invokevirtual 117	java/net/Socket:close	()V
    //   43: aload 7
    //   45: areturn
    //   46: astore 4
    //   48: ldc 119
    //   50: new 121	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   57: ldc 124
    //   59: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: invokevirtual 132	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   67: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 141	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: aload 4
    //   79: invokevirtual 144	java/lang/RuntimeException:printStackTrace	()V
    //   82: aload 4
    //   84: athrow
    //   85: astore_2
    //   86: aload_0
    //   87: getfield 20	com/google/appinventor/components/runtime/util/TelnetRepl:socket	Ljava/net/Socket;
    //   90: invokevirtual 117	java/net/Socket:close	()V
    //   93: aload_2
    //   94: athrow
    //   95: astore_3
    //   96: goto -3 -> 93
    //   99: astore 8
    //   101: aload 7
    //   103: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   20	36	46	java/lang/RuntimeException
    //   20	36	85	finally
    //   48	85	85	finally
    //   86	93	95	java/io/IOException
    //   36	43	99	java/io/IOException
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.TelnetRepl
 * JD-Core Version:    0.6.2
 */