package kawa;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ZipLoader;
import gnu.expr.Compilation;
import gnu.expr.CompiledModule;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleManager;
import gnu.lists.AbstractFormat;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.TtyInPort;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.text.FilePath;
import gnu.text.Lexer;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.URL;

public class Shell
{
  private static Class[] boolClasses;
  public static ThreadLocal currentLoadPath = new ThreadLocal();
  public static Object[] defaultFormatInfo;
  public static Method defaultFormatMethod;
  public static String defaultFormatName;
  static Object[][] formats = arrayOfObject;;
  private static Class[] httpPrinterClasses;
  private static Class[] noClasses = new Class[0];
  private static Object portArg;
  private static Class[] xmlPrinterClasses;

  static
  {
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = Boolean.TYPE;
    boolClasses = arrayOfClass;
    xmlPrinterClasses = new Class[] { OutPort.class, Object.class };
    httpPrinterClasses = new Class[] { OutPort.class };
    portArg = "(port)";
    Object[][] arrayOfObject; = new Object[14][];
    Object[] arrayOfObject1 = new Object[5];
    arrayOfObject1[0] = "scheme";
    arrayOfObject1[1] = "gnu.kawa.functions.DisplayFormat";
    arrayOfObject1[2] = "getSchemeFormat";
    arrayOfObject1[3] = boolClasses;
    arrayOfObject1[4] = Boolean.FALSE;
    arrayOfObject;[0] = arrayOfObject1;
    Object[] arrayOfObject2 = new Object[5];
    arrayOfObject2[0] = "readable-scheme";
    arrayOfObject2[1] = "gnu.kawa.functions.DisplayFormat";
    arrayOfObject2[2] = "getSchemeFormat";
    arrayOfObject2[3] = boolClasses;
    arrayOfObject2[4] = Boolean.TRUE;
    arrayOfObject;[1] = arrayOfObject2;
    Object[] arrayOfObject3 = new Object[5];
    arrayOfObject3[0] = "elisp";
    arrayOfObject3[1] = "gnu.kawa.functions.DisplayFormat";
    arrayOfObject3[2] = "getEmacsLispFormat";
    arrayOfObject3[3] = boolClasses;
    arrayOfObject3[4] = Boolean.FALSE;
    arrayOfObject;[2] = arrayOfObject3;
    Object[] arrayOfObject4 = new Object[5];
    arrayOfObject4[0] = "readable-elisp";
    arrayOfObject4[1] = "gnu.kawa.functions.DisplayFormat";
    arrayOfObject4[2] = "getEmacsLispFormat";
    arrayOfObject4[3] = boolClasses;
    arrayOfObject4[4] = Boolean.TRUE;
    arrayOfObject;[3] = arrayOfObject4;
    Object[] arrayOfObject5 = new Object[5];
    arrayOfObject5[0] = "clisp";
    arrayOfObject5[1] = "gnu.kawa.functions.DisplayFormat";
    arrayOfObject5[2] = "getCommonLispFormat";
    arrayOfObject5[3] = boolClasses;
    arrayOfObject5[4] = Boolean.FALSE;
    arrayOfObject;[4] = arrayOfObject5;
    Object[] arrayOfObject6 = new Object[5];
    arrayOfObject6[0] = "readable-clisp";
    arrayOfObject6[1] = "gnu.kawa.functions.DisplayFormat";
    arrayOfObject6[2] = "getCommonLispFormat";
    arrayOfObject6[3] = boolClasses;
    arrayOfObject6[4] = Boolean.TRUE;
    arrayOfObject;[5] = arrayOfObject6;
    Object[] arrayOfObject7 = new Object[5];
    arrayOfObject7[0] = "commonlisp";
    arrayOfObject7[1] = "gnu.kawa.functions.DisplayFormat";
    arrayOfObject7[2] = "getCommonLispFormat";
    arrayOfObject7[3] = boolClasses;
    arrayOfObject7[4] = Boolean.FALSE;
    arrayOfObject;[6] = arrayOfObject7;
    Object[] arrayOfObject8 = new Object[5];
    arrayOfObject8[0] = "readable-commonlisp";
    arrayOfObject8[1] = "gnu.kawa.functions.DisplayFormat";
    arrayOfObject8[2] = "getCommonLispFormat";
    arrayOfObject8[3] = boolClasses;
    arrayOfObject8[4] = Boolean.TRUE;
    arrayOfObject;[7] = arrayOfObject8;
    Object[] arrayOfObject9 = new Object[6];
    arrayOfObject9[0] = "xml";
    arrayOfObject9[1] = "gnu.xml.XMLPrinter";
    arrayOfObject9[2] = "make";
    arrayOfObject9[3] = xmlPrinterClasses;
    arrayOfObject9[4] = portArg;
    arrayOfObject9[5] = null;
    arrayOfObject;[8] = arrayOfObject9;
    Object[] arrayOfObject10 = new Object[6];
    arrayOfObject10[0] = "html";
    arrayOfObject10[1] = "gnu.xml.XMLPrinter";
    arrayOfObject10[2] = "make";
    arrayOfObject10[3] = xmlPrinterClasses;
    arrayOfObject10[4] = portArg;
    arrayOfObject10[5] = "html";
    arrayOfObject;[9] = arrayOfObject10;
    Object[] arrayOfObject11 = new Object[6];
    arrayOfObject11[0] = "xhtml";
    arrayOfObject11[1] = "gnu.xml.XMLPrinter";
    arrayOfObject11[2] = "make";
    arrayOfObject11[3] = xmlPrinterClasses;
    arrayOfObject11[4] = portArg;
    arrayOfObject11[5] = "xhtml";
    arrayOfObject;[10] = arrayOfObject11;
    Object[] arrayOfObject12 = new Object[5];
    arrayOfObject12[0] = "cgi";
    arrayOfObject12[1] = "gnu.kawa.xml.HttpPrinter";
    arrayOfObject12[2] = "make";
    arrayOfObject12[3] = httpPrinterClasses;
    arrayOfObject12[4] = portArg;
    arrayOfObject;[11] = arrayOfObject12;
    Object[] arrayOfObject13 = new Object[4];
    arrayOfObject13[0] = "ignore";
    arrayOfObject13[1] = "gnu.lists.VoidConsumer";
    arrayOfObject13[2] = "getInstance";
    arrayOfObject13[3] = noClasses;
    arrayOfObject;[12] = arrayOfObject13;
    arrayOfObject;[13] = { null };
  }

  public static final CompiledModule checkCompiledZip(InputStream paramInputStream, Path paramPath, Environment paramEnvironment, Language paramLanguage)
    throws IOException
  {
    Object localObject2;
    Environment localEnvironment;
    do
    {
      try
      {
        paramInputStream.mark(5);
        if ((paramInputStream.read() == 80) && (paramInputStream.read() == 75) && (paramInputStream.read() == 3) && (paramInputStream.read() == 4));
        for (int i = 1; ; i = 0)
        {
          paramInputStream.reset();
          if (i != 0)
            break;
          localObject2 = null;
          return localObject2;
        }
      }
      catch (IOException localIOException1)
      {
        return null;
      }
      paramInputStream.close();
      localEnvironment = Environment.getCurrent();
      String str = paramPath.toString();
      if (paramEnvironment != localEnvironment);
      try
      {
        Environment.setCurrent(paramEnvironment);
        if (!(paramPath instanceof FilePath))
          throw new RuntimeException("load: " + str + " - not a file path");
      }
      catch (IOException localIOException2)
      {
        throw new WrappedException("load: " + str + " - " + localIOException2.toString(), localIOException2);
      }
      finally
      {
        if (paramEnvironment != localEnvironment)
          Environment.setCurrent(localEnvironment);
      }
      File localFile = ((FilePath)paramPath).toFile();
      if (!localFile.exists())
        throw new RuntimeException("load: " + str + " - not found");
      if (!localFile.canRead())
        throw new RuntimeException("load: " + str + " - not readable");
      CompiledModule localCompiledModule = CompiledModule.make(new ZipLoader(str).loadAllClasses(), paramLanguage);
      localObject2 = localCompiledModule;
    }
    while (paramEnvironment == localEnvironment);
    Environment.setCurrent(localEnvironment);
    return localObject2;
  }

  static CompiledModule compileSource(InPort paramInPort, Environment paramEnvironment, URL paramURL, Language paramLanguage, SourceMessages paramSourceMessages)
    throws SyntaxException, IOException
  {
    Compilation localCompilation = paramLanguage.parse(paramInPort, paramSourceMessages, 1, ModuleManager.getInstance().findWithSourcePath(paramInPort.getName()));
    CallContext.getInstance().values = Values.noArgs;
    Object localObject = ModuleExp.evalModule1(paramEnvironment, localCompilation, paramURL, null);
    if ((localObject == null) || (paramSourceMessages.seenErrors()))
      return null;
    return new CompiledModule(localCompilation.getModule(), localObject, paramLanguage);
  }

  public static Consumer getOutputConsumer(OutPort paramOutPort)
  {
    Object[] arrayOfObject1 = defaultFormatInfo;
    if (paramOutPort == null)
      return VoidConsumer.getInstance();
    if (arrayOfObject1 == null)
      return Language.getDefaultLanguage().getOutputConsumer(paramOutPort);
    Object[] arrayOfObject2;
    try
    {
      arrayOfObject2 = new Object[arrayOfObject1.length - 4];
      System.arraycopy(arrayOfObject1, 4, arrayOfObject2, 0, arrayOfObject2.length);
      int i = arrayOfObject2.length;
      while (true)
      {
        i--;
        if (i < 0)
          break;
        if (arrayOfObject2[i] == portArg)
          arrayOfObject2[i] = paramOutPort;
      }
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException("cannot get output-format '" + defaultFormatName + "' - caught " + localThrowable);
    }
    Object localObject = defaultFormatMethod.invoke(null, arrayOfObject2);
    if ((localObject instanceof AbstractFormat))
    {
      paramOutPort.objectFormat = ((AbstractFormat)localObject);
      return paramOutPort;
    }
    Consumer localConsumer = (Consumer)localObject;
    return localConsumer;
  }

  public static void printError(Throwable paramThrowable, SourceMessages paramSourceMessages, OutPort paramOutPort)
  {
    if ((paramThrowable instanceof WrongArguments))
    {
      WrongArguments localWrongArguments = (WrongArguments)paramThrowable;
      paramSourceMessages.printAll(paramOutPort, 20);
      if (localWrongArguments.usage != null)
        paramOutPort.println("usage: " + localWrongArguments.usage);
      localWrongArguments.printStackTrace(paramOutPort);
      return;
    }
    if ((paramThrowable instanceof ClassCastException))
    {
      paramSourceMessages.printAll(paramOutPort, 20);
      paramOutPort.println("Invalid parameter, was: " + paramThrowable.getMessage());
      paramThrowable.printStackTrace(paramOutPort);
      return;
    }
    if ((paramThrowable instanceof SyntaxException))
    {
      SyntaxException localSyntaxException = (SyntaxException)paramThrowable;
      if (localSyntaxException.getMessages() == paramSourceMessages)
      {
        localSyntaxException.printAll(paramOutPort, 20);
        localSyntaxException.clear();
        return;
      }
    }
    paramSourceMessages.printAll(paramOutPort, 20);
    paramThrowable.printStackTrace(paramOutPort);
  }

  public static Throwable run(Language paramLanguage, Environment paramEnvironment, InPort paramInPort, Consumer paramConsumer, OutPort paramOutPort, URL paramURL, SourceMessages paramSourceMessages)
  {
    Language localLanguage = Language.setSaveCurrent(paramLanguage);
    Lexer localLexer = paramLanguage.getLexer(paramInPort, paramSourceMessages);
    boolean bool1;
    if (paramOutPort != null)
      bool1 = true;
    while (true)
    {
      localLexer.setInteractive(bool1);
      CallContext localCallContext = CallContext.getInstance();
      Consumer localConsumer1 = null;
      if (paramConsumer != null)
      {
        localConsumer1 = localCallContext.consumer;
        localCallContext.consumer = paramConsumer;
      }
      Consumer localConsumer2 = localConsumer1;
      try
      {
        Thread localThread = Thread.currentThread();
        ClassLoader localClassLoader = localThread.getContextClassLoader();
        if (!(localClassLoader instanceof ArrayClassLoader))
          localThread.setContextClassLoader(new ArrayClassLoader(localClassLoader));
        while (true)
        {
          try
          {
            localCompilation = paramLanguage.parse(localLexer, 7, null);
            if (bool1)
            {
              boolean bool2 = paramSourceMessages.checkErrors(paramOutPort, 20);
              bool3 = bool2;
              if (localCompilation != null)
                continue;
              return null;
              bool1 = false;
              break;
            }
            if (paramSourceMessages.seenErrors())
            {
              SyntaxException localSyntaxException = new SyntaxException(paramSourceMessages);
              throw localSyntaxException;
            }
          }
          catch (Throwable localThrowable)
          {
            Compilation localCompilation;
            boolean bool3;
            if (!bool1)
            {
              return localThrowable;
              bool3 = false;
              continue;
              if (bool3)
                continue;
              ModuleExp localModuleExp = localCompilation.getModule();
              StringBuilder localStringBuilder = new StringBuilder().append("atInteractiveLevel$");
              int i = 1 + ModuleExp.interactiveCounter;
              ModuleExp.interactiveCounter = i;
              localModuleExp.setName(i);
              j = paramInPort.read();
              if ((j < 0) || (j == 13) || (j == 10))
              {
                if (!ModuleExp.evalModule(paramEnvironment, localCallContext, localCompilation, paramURL, paramOutPort))
                  continue;
                if (!(paramConsumer instanceof Writer))
                  break label377;
                ((Writer)paramConsumer).flush();
                break label377;
              }
              if ((j == 32) || (j == 9))
                continue;
              paramInPort.unread();
              continue;
            }
          }
          finally
          {
            if (paramConsumer != null)
              localCallContext.consumer = localConsumer2;
            Language.restoreCurrent(localLanguage);
          }
          printError(localThrowable, paramSourceMessages, paramOutPort);
        }
      }
      catch (SecurityException localSecurityException)
      {
        while (true)
        {
          int j;
          continue;
          label377: if (j >= 0);
        }
      }
    }
  }

  public static Throwable run(Language paramLanguage, Environment paramEnvironment, InPort paramInPort, OutPort paramOutPort1, OutPort paramOutPort2, SourceMessages paramSourceMessages)
  {
    AbstractFormat localAbstractFormat = null;
    if (paramOutPort1 != null)
      localAbstractFormat = paramOutPort1.objectFormat;
    Consumer localConsumer = getOutputConsumer(paramOutPort1);
    try
    {
      Throwable localThrowable = run(paramLanguage, paramEnvironment, paramInPort, localConsumer, paramOutPort2, null, paramSourceMessages);
      return localThrowable;
    }
    finally
    {
      if (paramOutPort1 != null)
        paramOutPort1.objectFormat = localAbstractFormat;
    }
  }

  public static boolean run(Language paramLanguage, Environment paramEnvironment)
  {
    InPort localInPort = InPort.inDefault();
    SourceMessages localSourceMessages = new SourceMessages();
    if ((localInPort instanceof TtyInPort))
    {
      Procedure localProcedure = paramLanguage.getPrompter();
      if (localProcedure != null)
        ((TtyInPort)localInPort).setPrompter(localProcedure);
    }
    Throwable localThrowable;
    for (OutPort localOutPort = OutPort.errDefault(); ; localOutPort = null)
    {
      localThrowable = run(paramLanguage, paramEnvironment, localInPort, OutPort.outDefault(), localOutPort, localSourceMessages);
      if (localThrowable != null)
        break;
      return true;
    }
    printError(localThrowable, localSourceMessages, OutPort.errDefault());
    return false;
  }

  public static boolean run(Language paramLanguage, Environment paramEnvironment, InPort paramInPort, Consumer paramConsumer, OutPort paramOutPort, URL paramURL)
  {
    SourceMessages localSourceMessages = new SourceMessages();
    Throwable localThrowable = run(paramLanguage, paramEnvironment, paramInPort, paramConsumer, paramOutPort, paramURL, localSourceMessages);
    if (localThrowable != null)
      printError(localThrowable, localSourceMessages, paramOutPort);
    return localThrowable == null;
  }

  public static final boolean runFile(InputStream paramInputStream, Path paramPath, Environment paramEnvironment, boolean paramBoolean, int paramInt)
    throws Throwable
  {
    if (!(paramInputStream instanceof BufferedInputStream))
      paramInputStream = new BufferedInputStream(paramInputStream);
    Language localLanguage = Language.getDefaultLanguage();
    Path localPath = (Path)currentLoadPath.get();
    CompiledModule localCompiledModule1;
    InPort localInPort;
    try
    {
      currentLoadPath.set(paramPath);
      localCompiledModule1 = checkCompiledZip(paramInputStream, paramPath, paramEnvironment, localLanguage);
      if (localCompiledModule1 != null)
        break label264;
      localInPort = InPort.openFile(paramInputStream, paramPath);
      while (true)
      {
        paramInt--;
        if (paramInt < 0)
          break;
        localInPort.skipRestOfLine();
      }
    }
    finally
    {
      currentLoadPath.set(localPath);
    }
    SourceMessages localSourceMessages;
    URL localURL;
    while (true)
    {
      Object localObject3;
      try
      {
        localSourceMessages = new SourceMessages();
        localURL = paramPath.toURL();
        if (!paramBoolean)
          break label211;
        if (!ModuleBody.getMainPrintValues())
          break label162;
        localObject5 = getOutputConsumer(OutPort.outDefault());
        Throwable localThrowable = run(localLanguage, paramEnvironment, localInPort, (Consumer)localObject5, null, localURL, localSourceMessages);
        if (localThrowable == null)
          break;
        throw localThrowable;
      }
      finally
      {
        localObject3 = localObject2;
      }
      localInPort.close();
      throw localObject3;
      label162: VoidConsumer localVoidConsumer = new VoidConsumer();
      Object localObject5 = localVoidConsumer;
    }
    Object localObject6 = localCompiledModule1;
    localInPort.close();
    while (true)
    {
      while (true)
      {
        if (localObject6 != null)
          ((CompiledModule)localObject6).evalModule(paramEnvironment, OutPort.outDefault());
        currentLoadPath.set(localPath);
        return true;
        label211: CompiledModule localCompiledModule2 = compileSource(localInPort, paramEnvironment, localURL, localLanguage, localSourceMessages);
        localObject6 = localCompiledModule2;
        try
        {
          localSourceMessages.printAll(OutPort.errDefault(), 20);
          if (localObject6 != null)
            break;
          localInPort.close();
          currentLoadPath.set(localPath);
          return false;
        }
        finally
        {
        }
      }
      break;
      label264: localObject6 = localCompiledModule1;
    }
  }

  // ERROR //
  public static boolean runFileOrClass(String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 269	gnu/expr/Language:getDefaultLanguage	()Lgnu/expr/Language;
    //   3: astore_3
    //   4: aload_0
    //   5: ldc_w 497
    //   8: invokevirtual 503	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: ifeq +33 -> 44
    //   14: ldc_w 505
    //   17: invokestatic 509	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   20: astore 8
    //   22: getstatic 513	java/lang/System:in	Ljava/io/InputStream;
    //   25: astore 9
    //   27: aload 9
    //   29: aload 8
    //   31: invokestatic 133	gnu/mapping/Environment:getCurrent	()Lgnu/mapping/Environment;
    //   34: iload_1
    //   35: iload_2
    //   36: invokestatic 515	kawa/Shell:runFile	(Ljava/io/InputStream;Lgnu/text/Path;Lgnu/mapping/Environment;ZI)Z
    //   39: istore 11
    //   41: iload 11
    //   43: ireturn
    //   44: aload_0
    //   45: invokestatic 509	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   48: astore 8
    //   50: aload 8
    //   52: invokevirtual 519	gnu/text/Path:openInputStream	()Ljava/io/InputStream;
    //   55: astore 9
    //   57: goto -30 -> 27
    //   60: astore 10
    //   62: aload 10
    //   64: getstatic 523	java/lang/System:err	Ljava/io/PrintStream;
    //   67: invokevirtual 526	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   70: iconst_0
    //   71: ireturn
    //   72: astore 4
    //   74: aload_0
    //   75: invokestatic 530	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   78: astore 6
    //   80: aload 6
    //   82: aload_3
    //   83: invokestatic 197	gnu/expr/CompiledModule:make	(Ljava/lang/Class;Lgnu/expr/Language;)Lgnu/expr/CompiledModule;
    //   86: invokestatic 133	gnu/mapping/Environment:getCurrent	()Lgnu/mapping/Environment;
    //   89: invokestatic 448	gnu/mapping/OutPort:outDefault	()Lgnu/mapping/OutPort;
    //   92: invokevirtual 491	gnu/expr/CompiledModule:evalModule	(Lgnu/mapping/Environment;Lgnu/mapping/OutPort;)V
    //   95: iconst_1
    //   96: ireturn
    //   97: astore 5
    //   99: getstatic 523	java/lang/System:err	Ljava/io/PrintStream;
    //   102: new 147	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 532
    //   112: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 4
    //   117: invokevirtual 330	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 535	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore 7
    //   133: aload 7
    //   135: invokevirtual 537	java/lang/Throwable:printStackTrace	()V
    //   138: iconst_0
    //   139: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   27	41	60	java/lang/Throwable
    //   4	27	72	java/lang/Throwable
    //   44	57	72	java/lang/Throwable
    //   62	70	72	java/lang/Throwable
    //   74	80	97	java/lang/Throwable
    //   80	95	131	java/lang/Throwable
  }

  public static void setDefaultFormat(String paramString)
  {
    String str = paramString.intern();
    defaultFormatName = str;
    int i = 0;
    Object[] arrayOfObject = formats[i];
    Object localObject = arrayOfObject[0];
    if (localObject == null)
    {
      System.err.println("kawa: unknown output format '" + str + "'");
      System.exit(-1);
    }
    while (localObject != str)
    {
      i++;
      break;
    }
    defaultFormatInfo = arrayOfObject;
    try
    {
      defaultFormatMethod = Class.forName((String)arrayOfObject[1]).getMethod((String)arrayOfObject[2], (Class[])arrayOfObject[3]);
      if (!defaultFormatInfo[1].equals("gnu.lists.VoidConsumer"))
        ModuleBody.setMainPrintValues(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        System.err.println("kawa:  caught " + localThrowable + " while looking for format '" + str + "'");
        System.exit(-1);
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.Shell
 * JD-Core Version:    0.6.2
 */