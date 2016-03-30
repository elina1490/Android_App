package kawa;

import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleManager;
import gnu.lists.FString;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0or1;
import gnu.mapping.Values;
import gnu.text.Options;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.text.WriterManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class repl extends Procedure0or1
{
  public static String compilationTopname = null;
  static int defaultParseOptions = 72;
  public static String homeDirectory;
  public static boolean noConsole;
  static Language previousLanguage;
  static boolean shutdownRegistered = WriterManager.instance.registerShutdownHook();
  Language language;

  public repl(Language paramLanguage)
  {
    this.language = paramLanguage;
  }

  static void bad_option(String paramString)
  {
    System.err.println("kawa: bad option '" + paramString + "'");
    printOptions(System.err);
    System.exit(-1);
  }

  static void checkInitFile()
  {
    Object localObject;
    String str;
    if (homeDirectory == null)
    {
      homeDirectory = System.getProperty("user.home");
      if (homeDirectory == null)
        break label103;
      localObject = new FString(homeDirectory);
      if (!"/".equals(System.getProperty("file.separator")))
        break label97;
      str = ".kawarc.scm";
    }
    for (File localFile = new File(homeDirectory, str); ; localFile = null)
    {
      Environment.getCurrent().put("home-directory", localObject);
      if ((localFile != null) && (localFile.exists()) && (!Shell.runFileOrClass(localFile.getPath(), true, 0)))
        System.exit(-1);
      return;
      label97: str = "kawarc.scm";
      break;
      label103: localObject = Boolean.FALSE;
    }
  }

  // ERROR //
  public static void compileFiles(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 149	gnu/expr/ModuleManager:getInstance	()Lgnu/expr/ModuleManager;
    //   3: astore_3
    //   4: iload_2
    //   5: iload_1
    //   6: isub
    //   7: anewarray 151	gnu/expr/Compilation
    //   10: astore 4
    //   12: iload_2
    //   13: iload_1
    //   14: isub
    //   15: anewarray 153	gnu/expr/ModuleInfo
    //   18: astore 5
    //   20: new 155	gnu/text/SourceMessages
    //   23: dup
    //   24: invokespecial 156	gnu/text/SourceMessages:<init>	()V
    //   27: astore 6
    //   29: iload_1
    //   30: istore 7
    //   32: iload 7
    //   34: iload_2
    //   35: if_icmpge +191 -> 226
    //   38: aload_0
    //   39: iload 7
    //   41: aaload
    //   42: astore 16
    //   44: aload 16
    //   46: invokestatic 159	kawa/repl:getLanguageFromFilenameExtension	(Ljava/lang/String;)V
    //   49: invokestatic 165	gnu/expr/Language:getDefaultLanguage	()Lgnu/expr/Language;
    //   52: astore 17
    //   54: aconst_null
    //   55: astore 18
    //   57: aload 16
    //   59: invokestatic 171	gnu/mapping/InPort:openFile	(Ljava/lang/Object;)Lgnu/mapping/InPort;
    //   62: astore 21
    //   64: aload 17
    //   66: aload 21
    //   68: aload 6
    //   70: getstatic 21	kawa/repl:defaultParseOptions	I
    //   73: invokevirtual 175	gnu/expr/Language:parse	(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;I)Lgnu/expr/Compilation;
    //   76: astore 22
    //   78: getstatic 19	kawa/repl:compilationTopname	Ljava/lang/String;
    //   81: ifnull +47 -> 128
    //   84: new 177	gnu/bytecode/ClassType
    //   87: dup
    //   88: getstatic 19	kawa/repl:compilationTopname	Ljava/lang/String;
    //   91: invokestatic 180	gnu/expr/Compilation:mangleNameIfNeeded	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokespecial 181	gnu/bytecode/ClassType:<init>	(Ljava/lang/String;)V
    //   97: astore 24
    //   99: aload 22
    //   101: invokevirtual 185	gnu/expr/Compilation:getModule	()Lgnu/expr/ModuleExp;
    //   104: astore 25
    //   106: aload 25
    //   108: aload 24
    //   110: invokevirtual 191	gnu/expr/ModuleExp:setType	(Lgnu/bytecode/ClassType;)V
    //   113: aload 25
    //   115: getstatic 19	kawa/repl:compilationTopname	Ljava/lang/String;
    //   118: invokevirtual 194	gnu/expr/ModuleExp:setName	(Ljava/lang/String;)V
    //   121: aload 22
    //   123: aload 24
    //   125: putfield 198	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   128: aload 5
    //   130: iload 7
    //   132: iload_1
    //   133: isub
    //   134: aload_3
    //   135: aload 22
    //   137: invokevirtual 202	gnu/expr/ModuleManager:find	(Lgnu/expr/Compilation;)Lgnu/expr/ModuleInfo;
    //   140: aastore
    //   141: aload 4
    //   143: iload 7
    //   145: iload_1
    //   146: isub
    //   147: aload 22
    //   149: aastore
    //   150: aload 6
    //   152: invokevirtual 205	gnu/text/SourceMessages:seenErrorsOrWarnings	()Z
    //   155: ifeq +51 -> 206
    //   158: getstatic 47	java/lang/System:err	Ljava/io/PrintStream;
    //   161: new 49	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   168: ldc 207
    //   170: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload 16
    //   175: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: bipush 41
    //   180: invokevirtual 210	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   183: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokevirtual 67	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   189: aload 6
    //   191: getstatic 47	java/lang/System:err	Ljava/io/PrintStream;
    //   194: bipush 20
    //   196: invokevirtual 214	gnu/text/SourceMessages:checkErrors	(Ljava/io/PrintStream;I)Z
    //   199: ifeq +7 -> 206
    //   202: iconst_1
    //   203: invokestatic 75	java/lang/System:exit	(I)V
    //   206: iinc 7 1
    //   209: goto -177 -> 32
    //   212: astore 20
    //   214: getstatic 47	java/lang/System:err	Ljava/io/PrintStream;
    //   217: aload 20
    //   219: invokevirtual 217	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   222: iconst_m1
    //   223: invokestatic 75	java/lang/System:exit	(I)V
    //   226: iload_1
    //   227: istore 8
    //   229: iload 8
    //   231: iload_2
    //   232: if_icmpge +195 -> 427
    //   235: aload_0
    //   236: iload 8
    //   238: aaload
    //   239: astore 9
    //   241: aload 4
    //   243: iload 8
    //   245: iload_1
    //   246: isub
    //   247: aaload
    //   248: astore 10
    //   250: getstatic 47	java/lang/System:err	Ljava/io/PrintStream;
    //   253: new 49	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   260: ldc 207
    //   262: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 9
    //   267: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 219
    //   272: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 10
    //   277: getfield 198	gnu/expr/Compilation:mainClass	Lgnu/bytecode/ClassType;
    //   280: invokevirtual 222	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   283: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: bipush 41
    //   288: invokevirtual 210	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   291: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokevirtual 67	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   297: aload 5
    //   299: iload 8
    //   301: iload_1
    //   302: isub
    //   303: aaload
    //   304: bipush 14
    //   306: invokevirtual 225	gnu/expr/ModuleInfo:loadByStages	(I)V
    //   309: aload 6
    //   311: invokevirtual 228	gnu/text/SourceMessages:seenErrors	()Z
    //   314: istore 12
    //   316: aload 6
    //   318: getstatic 47	java/lang/System:err	Ljava/io/PrintStream;
    //   321: bipush 50
    //   323: invokevirtual 214	gnu/text/SourceMessages:checkErrors	(Ljava/io/PrintStream;I)Z
    //   326: pop
    //   327: iload 12
    //   329: ifeq +7 -> 336
    //   332: iconst_m1
    //   333: invokestatic 75	java/lang/System:exit	(I)V
    //   336: aload 4
    //   338: iload 8
    //   340: iload_1
    //   341: isub
    //   342: aload 10
    //   344: aastore
    //   345: aload 6
    //   347: invokevirtual 228	gnu/text/SourceMessages:seenErrors	()Z
    //   350: istore 14
    //   352: aload 6
    //   354: getstatic 47	java/lang/System:err	Ljava/io/PrintStream;
    //   357: bipush 50
    //   359: invokevirtual 214	gnu/text/SourceMessages:checkErrors	(Ljava/io/PrintStream;I)Z
    //   362: pop
    //   363: iload 14
    //   365: ifeq +7 -> 372
    //   368: iconst_m1
    //   369: invokestatic 75	java/lang/System:exit	(I)V
    //   372: iinc 8 1
    //   375: goto -146 -> 229
    //   378: astore 19
    //   380: aload 19
    //   382: instanceof 230
    //   385: ifeq +16 -> 401
    //   388: aload 19
    //   390: checkcast 230	gnu/text/SyntaxException
    //   393: invokevirtual 234	gnu/text/SyntaxException:getMessages	()Lgnu/text/SourceMessages;
    //   396: aload 6
    //   398: if_acmpeq -248 -> 150
    //   401: aload 19
    //   403: aload 18
    //   405: aload 16
    //   407: invokestatic 238	kawa/repl:internalError	(Ljava/lang/Throwable;Lgnu/expr/Compilation;Ljava/lang/Object;)V
    //   410: goto -260 -> 150
    //   413: astore 11
    //   415: aload 11
    //   417: aload 10
    //   419: aload 9
    //   421: invokestatic 238	kawa/repl:internalError	(Ljava/lang/Throwable;Lgnu/expr/Compilation;Ljava/lang/Object;)V
    //   424: goto -52 -> 372
    //   427: return
    //   428: astore 23
    //   430: aload 22
    //   432: astore 18
    //   434: aload 23
    //   436: astore 19
    //   438: goto -58 -> 380
    //
    // Exception table:
    //   from	to	target	type
    //   57	64	212	java/io/FileNotFoundException
    //   57	64	378	java/lang/Throwable
    //   64	78	378	java/lang/Throwable
    //   214	226	378	java/lang/Throwable
    //   250	327	413	java/lang/Throwable
    //   332	336	413	java/lang/Throwable
    //   336	363	413	java/lang/Throwable
    //   368	372	413	java/lang/Throwable
    //   78	128	428	java/lang/Throwable
    //   128	150	428	java/lang/Throwable
  }

  public static void getLanguage()
  {
    if (previousLanguage == null)
    {
      previousLanguage = Language.getInstance(null);
      Language.setDefaults(previousLanguage);
    }
  }

  public static void getLanguageFromFilenameExtension(String paramString)
  {
    if (previousLanguage == null)
    {
      previousLanguage = Language.getInstanceFromFilenameExtension(paramString);
      if (previousLanguage != null)
      {
        Language.setDefaults(previousLanguage);
        return;
      }
    }
    getLanguage();
  }

  static void internalError(Throwable paramThrowable, Compilation paramCompilation, Object paramObject)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramCompilation != null)
    {
      String str = paramCompilation.getFileName();
      int i = paramCompilation.getLineNumber();
      if ((str != null) && (i > 0))
      {
        localStringBuffer.append(str);
        localStringBuffer.append(':');
        localStringBuffer.append(i);
        localStringBuffer.append(": ");
      }
    }
    localStringBuffer.append("internal error while compiling ");
    localStringBuffer.append(paramObject);
    System.err.println(localStringBuffer.toString());
    paramThrowable.printStackTrace(System.err);
    System.exit(-1);
  }

  public static void main(String[] paramArrayOfString)
  {
    while (true)
    {
      try
      {
        int i = processArgs(paramArrayOfString, 0, paramArrayOfString.length);
        if (i < 0)
          return;
        if (i < paramArrayOfString.length)
        {
          String str = paramArrayOfString[i];
          getLanguageFromFilenameExtension(str);
          setArgs(paramArrayOfString, i + 1);
          checkInitFile();
          Shell.runFileOrClass(str, false, 0);
          return;
        }
        getLanguage();
        setArgs(paramArrayOfString, i);
        checkInitFile();
        if (shouldUseGuiConsole())
        {
          startGuiConsole();
          continue;
        }
      }
      finally
      {
        if (!shutdownRegistered)
          OutPort.runCleanups();
        ModuleBody.exitDecrement();
      }
      if (!Shell.run(Language.getDefaultLanguage(), Environment.getCurrent()))
        System.exit(-1);
    }
  }

  public static void printOption(PrintStream paramPrintStream, String paramString1, String paramString2)
  {
    paramPrintStream.print(" ");
    paramPrintStream.print(paramString1);
    int i = 1 + paramString1.length();
    for (int j = 0; j < 30 - i; j++)
      paramPrintStream.print(" ");
    paramPrintStream.print(" ");
    paramPrintStream.println(paramString2);
  }

  public static void printOptions(PrintStream paramPrintStream)
  {
    paramPrintStream.println("Usage: [java kawa.repl | kawa] [options ...]");
    paramPrintStream.println();
    paramPrintStream.println(" Generic options:");
    printOption(paramPrintStream, "--help", "Show help about options");
    printOption(paramPrintStream, "--author", "Show author information");
    printOption(paramPrintStream, "--version", "Show version information");
    paramPrintStream.println();
    paramPrintStream.println(" Options");
    printOption(paramPrintStream, "-e <expr>", "Evaluate expression <expr>");
    printOption(paramPrintStream, "-c <expr>", "Same as -e, but make sure ~/.kawarc.scm is run first");
    printOption(paramPrintStream, "-f <filename>", "File to interpret");
    printOption(paramPrintStream, "-s| --", "Start reading commands interactively from console");
    printOption(paramPrintStream, "-w", "Launch the interpreter in a GUI window");
    printOption(paramPrintStream, "--server <port>", "Start a server accepting telnet connections on <port>");
    printOption(paramPrintStream, "--debug-dump-zip", "Compiled interactive expressions to a zip archive");
    printOption(paramPrintStream, "--debug-print-expr", "Print generated internal expressions");
    printOption(paramPrintStream, "--debug-print-final-expr", "Print expression after any optimizations");
    printOption(paramPrintStream, "--debug-error-prints-stack-trace", "Print stack trace with errors");
    printOption(paramPrintStream, "--debug-warning-prints-stack-trace", "Print stack trace with warnings");
    printOption(paramPrintStream, "--[no-]full-tailcalls", "(Don't) use full tail-calls");
    printOption(paramPrintStream, "-C <filename> ...", "Compile named files to Java class files");
    printOption(paramPrintStream, "--output-format <format>", "Use <format> when printing top-level output");
    printOption(paramPrintStream, "--<language>", "Select source language, one of:");
    String[][] arrayOfString = Language.getLanguages();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      paramPrintStream.print("   ");
      String[] arrayOfString1 = arrayOfString[i];
      int k = arrayOfString1.length - 1;
      for (int m = 0; m < k; m++)
        paramPrintStream.print(arrayOfString1[m] + " ");
      if (i == 0)
        paramPrintStream.print("[default]");
      paramPrintStream.println();
    }
    paramPrintStream.println(" Compilation options, must be specified before -C");
    printOption(paramPrintStream, "-d <dirname>", "Directory to place .class files in");
    printOption(paramPrintStream, "-P <prefix>", "Prefix to prepand to class names");
    printOption(paramPrintStream, "-T <topname>", "name to give to top-level class");
    printOption(paramPrintStream, "--main", "Generate an application, with a main method");
    printOption(paramPrintStream, "--applet", "Generate an applet");
    printOption(paramPrintStream, "--servlet", "Generate a servlet");
    printOption(paramPrintStream, "--module-static", "Top-level definitions are by default static");
    ArrayList localArrayList = Compilation.options.keys();
    for (int j = 0; j < localArrayList.size(); j++)
    {
      String str = (String)localArrayList.get(j);
      printOption(paramPrintStream, "--" + str, Compilation.options.getDoc(str));
    }
    paramPrintStream.println();
    paramPrintStream.println("For more information go to:  http://www.gnu.org/software/kawa/");
  }

  public static int processArgs(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    int i = 0;
    String str1;
    int j;
    label206: int i18;
    label250: StringBuffer localStringBuffer;
    int i12;
    label457: int i13;
    if (paramInt1 < paramInt2)
    {
      str1 = paramArrayOfString[paramInt1];
      if ((str1.equals("-c")) || (str1.equals("-e")))
      {
        paramInt1++;
        if (paramInt1 == paramInt2)
          bad_option(str1);
        getLanguage();
        setArgs(paramArrayOfString, paramInt1 + 1);
        if (str1.equals("-c"))
          checkInitFile();
        Language localLanguage1 = Language.getDefaultLanguage();
        SourceMessages localSourceMessages1 = new SourceMessages();
        Throwable localThrowable1 = Shell.run(localLanguage1, Environment.getCurrent(), new CharArrayInPort(paramArrayOfString[paramInt1]), OutPort.outDefault(), null, localSourceMessages1);
        if (localThrowable1 != null)
        {
          Shell.printError(localThrowable1, localSourceMessages1, OutPort.errDefault());
          System.exit(-1);
        }
      }
      for (j = 1; ; j = 1)
      {
        paramInt1++;
        i = j;
        break;
        if (!str1.equals("-f"))
          break label206;
        paramInt1++;
        if (paramInt1 == paramInt2)
          bad_option(str1);
        String str12 = paramArrayOfString[paramInt1];
        getLanguageFromFilenameExtension(str12);
        setArgs(paramArrayOfString, paramInt1 + 1);
        checkInitFile();
        if (!Shell.runFileOrClass(str12, true, 0))
          System.exit(-1);
      }
      if (str1.startsWith("--script"))
      {
        String str10 = str1.substring(8);
        int i17 = paramInt1 + 1;
        if (str10.length() <= 0)
          break label2676;
        try
        {
          int i19 = Integer.parseInt(str10);
          i18 = i19;
          if (i17 == paramInt2)
            bad_option(str1);
          String str11 = paramArrayOfString[i17];
          getLanguageFromFilenameExtension(str11);
          setArgs(paramArrayOfString, i17 + 1);
          checkInitFile();
          if (!Shell.runFileOrClass(str11, true, i18))
            System.exit(-1);
          return -1;
        }
        catch (Throwable localThrowable4)
        {
          while (true)
          {
            i17 = paramInt2;
            i18 = 0;
          }
        }
      }
      if (str1.equals("\\"))
      {
        int i9 = paramInt1 + 1;
        if (i9 == paramInt2)
          bad_option(str1);
        String str9 = paramArrayOfString[i9];
        SourceMessages localSourceMessages2 = new SourceMessages();
        while (true)
        {
          Vector localVector;
          try
          {
            FileInputStream localFileInputStream = new FileInputStream(str9);
            BufferedInputStream localBufferedInputStream = new BufferedInputStream(localFileInputStream);
            int i10 = localBufferedInputStream.read();
            if (i10 == 35)
            {
              localStringBuffer = new StringBuffer(100);
              localVector = new Vector(10);
              int i11 = i10;
              i12 = 0;
              if (i11 != 10)
              {
                int i16 = i10;
                i12 = 0;
                if (i16 != 13)
                {
                  i12 = 0;
                  if (i10 >= 0)
                  {
                    i10 = localBufferedInputStream.read();
                    continue;
                  }
                }
              }
              i13 = localBufferedInputStream.read();
              if (i13 >= 0)
                break label2682;
              System.err.println("unexpected end-of-file processing argument line for: '" + str9 + '\'');
              System.exit(-1);
              break label2682;
              label508: if (localStringBuffer.length() > 0)
                localVector.addElement(localStringBuffer.toString());
              int i14 = localVector.size();
              if (i14 > 0)
              {
                String[] arrayOfString = new String[i14];
                localVector.copyInto(arrayOfString);
                int i15 = processArgs(arrayOfString, 0, i14);
                if ((i15 >= 0) && (i15 < i14))
                  System.err.println("" + (i14 - i15) + " unused meta args");
              }
            }
            getLanguageFromFilenameExtension(str9);
            InPort localInPort = InPort.openFile(localBufferedInputStream, str9);
            setArgs(paramArrayOfString, i9 + 1);
            checkInitFile();
            OutPort localOutPort = OutPort.errDefault();
            Throwable localThrowable3 = Shell.run(Language.getDefaultLanguage(), Environment.getCurrent(), localInPort, OutPort.outDefault(), null, localSourceMessages2);
            localSourceMessages2.printAll(localOutPort, 20);
            if (localThrowable3 != null)
            {
              if (((localThrowable3 instanceof SyntaxException)) && (((SyntaxException)localThrowable3).getMessages() == localSourceMessages2))
                System.exit(1);
              throw localThrowable3;
            }
          }
          catch (Throwable localThrowable2)
          {
            Shell.printError(localThrowable2, localSourceMessages2, OutPort.errDefault());
            System.exit(1);
          }
          return -1;
          label719: if ((i13 == 32) || (i13 == 9))
          {
            if (localStringBuffer.length() <= 0)
              continue;
            localVector.addElement(localStringBuffer.toString());
            localStringBuffer.setLength(0);
            continue;
            label759: break label772;
          }
        }
      }
    }
    while (true)
    {
      while (true)
      {
        localStringBuffer.append((char)i13);
        break label457;
        label772: if (i13 == i12)
        {
          i12 = 0;
          break label457;
          if ((str1.equals("-s")) || (str1.equals("--")))
          {
            int k = paramInt1 + 1;
            getLanguage();
            setArgs(paramArrayOfString, k);
            checkInitFile();
            Shell.run(Language.getDefaultLanguage(), Environment.getCurrent());
            return -1;
          }
          if (str1.equals("-w"))
          {
            paramInt1++;
            getLanguage();
            setArgs(paramArrayOfString, paramInt1);
            checkInitFile();
            startGuiConsole();
            j = 1;
            break;
          }
          if (str1.equals("-d"))
          {
            paramInt1++;
            if (paramInt1 == paramInt2)
              bad_option(str1);
            ModuleManager.getInstance().setCompilationDirectory(paramArrayOfString[paramInt1]);
            j = i;
            break;
          }
          if ((str1.equals("--target")) || (str1.equals("target")))
          {
            paramInt1++;
            if (paramInt1 == paramInt2)
              bad_option(str1);
            String str2 = paramArrayOfString[paramInt1];
            if (str2.equals("7"))
              Compilation.defaultClassFileVersion = 3342336;
            if ((str2.equals("6")) || (str2.equals("1.6")))
            {
              Compilation.defaultClassFileVersion = 3276800;
              j = i;
              break;
            }
            if ((str2.equals("5")) || (str2.equals("1.5")))
            {
              Compilation.defaultClassFileVersion = 3211264;
              j = i;
              break;
            }
            if (str2.equals("1.4"))
            {
              Compilation.defaultClassFileVersion = 3145728;
              j = i;
              break;
            }
            if (str2.equals("1.3"))
            {
              Compilation.defaultClassFileVersion = 3080192;
              j = i;
              break;
            }
            if (str2.equals("1.2"))
            {
              Compilation.defaultClassFileVersion = 3014656;
              j = i;
              break;
            }
            if (str2.equals("1.1"))
            {
              Compilation.defaultClassFileVersion = 2949123;
              j = i;
              break;
            }
            bad_option(str2);
            j = i;
            break;
          }
          if (str1.equals("-P"))
          {
            paramInt1++;
            if (paramInt1 == paramInt2)
              bad_option(str1);
            Compilation.classPrefixDefault = paramArrayOfString[paramInt1];
            j = i;
            break;
          }
          if (str1.equals("-T"))
          {
            paramInt1++;
            if (paramInt1 == paramInt2)
              bad_option(str1);
            compilationTopname = paramArrayOfString[paramInt1];
            j = i;
            break;
          }
          if (str1.equals("-C"))
          {
            int i8 = paramInt1 + 1;
            if (i8 == paramInt2)
              bad_option(str1);
            compileFiles(paramArrayOfString, i8, paramInt2);
            return -1;
          }
          if ((str1.equals("--output-format")) || (str1.equals("--format")))
          {
            paramInt1++;
            if (paramInt1 == paramInt2)
              bad_option(str1);
            Shell.setDefaultFormat(paramArrayOfString[paramInt1]);
            j = i;
            break;
          }
          if (str1.equals("--connect"))
          {
            paramInt1++;
            if (paramInt1 == paramInt2)
              bad_option(str1);
            int i6;
            if (paramArrayOfString[paramInt1].equals("-"))
              i6 = 0;
            try
            {
              while (true)
              {
                Telnet localTelnet = new Telnet(new Socket(InetAddress.getByName(null), i6), true);
                TelnetInputStream localTelnetInputStream = localTelnet.getInputStream();
                PrintStream localPrintStream = new PrintStream(localTelnet.getOutputStream(), true);
                System.setIn(localTelnetInputStream);
                System.setOut(localPrintStream);
                System.setErr(localPrintStream);
                j = i;
                break;
                try
                {
                  int i7 = Integer.parseInt(paramArrayOfString[paramInt1]);
                  i6 = i7;
                }
                catch (NumberFormatException localNumberFormatException2)
                {
                  bad_option("--connect port#");
                  i6 = -1;
                }
              }
            }
            catch (IOException localIOException3)
            {
              localIOException3.printStackTrace(System.err);
              Error localError2 = new Error(localIOException3.toString());
              throw localError2;
            }
          }
        }
      }
      int i2;
      int i3;
      if (str1.equals("--server"))
      {
        getLanguage();
        i2 = paramInt1 + 1;
        if (i2 == paramInt2)
          bad_option(str1);
        if (paramArrayOfString[i2].equals("-"))
          i3 = 0;
      }
      while (true)
      {
        String str5;
        Object localObject1;
        try
        {
          ServerSocket localServerSocket = new ServerSocket(i3);
          int i4 = localServerSocket.getLocalPort();
          try
          {
            System.err.println("Listening on port " + i4);
            System.err.print("waiting ... ");
            System.err.flush();
            Socket localSocket = localServerSocket.accept();
            System.err.println("got connection from " + localSocket.getInetAddress() + " port:" + localSocket.getPort());
            TelnetRepl.serve(Language.getDefaultLanguage(), localSocket);
            continue;
          }
          catch (IOException localIOException2)
          {
          }
          Error localError1 = new Error(localIOException2.toString());
          throw localError1;
          try
          {
            int i5 = Integer.parseInt(paramArrayOfString[i2]);
            i3 = i5;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            bad_option("--server port#");
            i3 = -1;
          }
          continue;
          if (str1.equals("--http-auto-handler"))
          {
            paramInt1 += 2;
            if (paramInt1 >= paramInt2)
              bad_option(str1);
            System.err.println("kawa: HttpServer classes not found");
            System.exit(-1);
            j = i;
            break;
          }
          if (str1.equals("--http-start"))
          {
            paramInt1++;
            if (paramInt1 >= paramInt2)
              bad_option("missing httpd port argument");
            System.err.println("kawa: HttpServer classes not found");
            System.exit(-1);
            j = i;
            break;
          }
          if (str1.equals("--main"))
          {
            Compilation.generateMainDefault = true;
            j = i;
            break;
          }
          if (str1.equals("--applet"))
          {
            defaultParseOptions = 0x10 | defaultParseOptions;
            j = i;
            break;
          }
          if (str1.equals("--servlet"))
          {
            defaultParseOptions = 0x20 | defaultParseOptions;
            gnu.kawa.servlet.HttpRequestContext.importServletDefinitions = 2;
            j = i;
            break;
          }
          if (str1.equals("--debug-dump-zip"))
          {
            gnu.expr.ModuleExp.dumpZipPrefix = "kawa-zip-dump-";
            j = i;
            break;
          }
          if (str1.equals("--debug-print-expr"))
          {
            Compilation.debugPrintExpr = true;
            j = i;
            break;
          }
          if (str1.equals("--debug-print-final-expr"))
          {
            Compilation.debugPrintFinalExpr = true;
            j = i;
            break;
          }
          if (str1.equals("--debug-error-prints-stack-trace"))
          {
            SourceMessages.debugStackTraceOnError = true;
            j = i;
            break;
          }
          if (str1.equals("--debug-warning-prints-stack-trace"))
          {
            SourceMessages.debugStackTraceOnWarning = true;
            j = i;
            break;
          }
          if ((str1.equals("--module-nonstatic")) || (str1.equals("--no-module-static")))
          {
            Compilation.moduleStatic = -1;
            j = i;
            break;
          }
          if (str1.equals("--module-static"))
          {
            Compilation.moduleStatic = 1;
            j = i;
            break;
          }
          if (str1.equals("--module-static-run"))
          {
            Compilation.moduleStatic = 2;
            j = i;
            break;
          }
          if ((str1.equals("--no-inline")) || (str1.equals("--inline=none")))
          {
            Compilation.inlineOk = false;
            j = i;
            break;
          }
          if (str1.equals("--no-console"))
          {
            noConsole = true;
            j = i;
            break;
          }
          if (str1.equals("--inline"))
          {
            Compilation.inlineOk = true;
            j = i;
            break;
          }
          if (str1.equals("--cps"))
          {
            Compilation.defaultCallConvention = 4;
            j = i;
            break;
          }
          if (str1.equals("--full-tailcalls"))
          {
            Compilation.defaultCallConvention = 3;
            j = i;
            break;
          }
          if (str1.equals("--no-full-tailcalls"))
          {
            Compilation.defaultCallConvention = 1;
            j = i;
            break;
          }
          if (str1.equals("--pedantic"))
          {
            Language.requirePedantic = true;
            j = i;
            break;
          }
          if (str1.equals("--help"))
          {
            printOptions(System.out);
            System.exit(0);
            j = i;
            break;
          }
          if (str1.equals("--author"))
          {
            System.out.println("Per Bothner <per@bothner.com>");
            System.exit(0);
            j = i;
            break;
          }
          if (str1.equals("--version"))
          {
            System.out.print("Kawa ");
            System.out.print(Version.getVersion());
            System.out.println();
            System.out.println("Copyright (C) 2009 Per Bothner");
            j = 1;
            break;
          }
          if ((str1.length() > 0) && (str1.charAt(0) == '-'))
          {
            if ((str1.length() <= 2) || (str1.charAt(0) != '-'))
              break label2669;
            Language localLanguage2;
            if (str1.charAt(1) == '-')
            {
              i1 = 2;
              str3 = str1.substring(i1);
              localLanguage2 = Language.getInstance(str3);
              if (localLanguage2 == null)
                continue;
              if (previousLanguage != null)
                continue;
              Language.setDefaults(localLanguage2);
              previousLanguage = localLanguage2;
              j = i;
              break;
            }
            int i1 = 1;
            continue;
            Language.setCurrentLanguage(localLanguage2);
            continue;
            int m = str3.indexOf("=");
            String str7;
            if (m < 0)
            {
              str5 = str3;
              localObject1 = null;
              if ((!str5.startsWith("no-")) || (str5.length() <= 3))
                continue;
              n = 1;
              if ((localObject1 != null) || (n == 0))
                break label2658;
              String str8 = str5.substring(3);
              localObject2 = "no";
              str6 = str8;
              str7 = Compilation.options.set(str6, (String)localObject2);
              if (str7 == null)
                continue;
              if ((n != 0) && (str7 == "unknown option name"))
                str7 = "both '--no-' prefix and '=" + (String)localObject2 + "' specified";
              if (str7 != "unknown option name")
                continue;
              bad_option(str1);
              continue;
            }
            String str4 = str3.substring(m + 1);
            str5 = str3.substring(0, m);
            localObject1 = str4;
            continue;
            int n = 0;
            continue;
            System.err.println("kawa: bad option '" + str1 + "': " + str7);
            System.exit(-1);
            continue;
          }
          if (!ApplicationMainSupport.processSetProperty(str1))
          {
            if (i != 0)
              return -1;
            return paramInt1;
          }
        }
        catch (IOException localIOException1)
        {
          Object localObject3 = localIOException1;
          continue;
          j = i;
        }
        break;
        label2658: Object localObject2 = localObject1;
        String str6 = str5;
        continue;
        label2669: String str3 = str1;
      }
      label2676: i18 = 0;
      break label250;
      label2682: if (i12 == 0)
      {
        if ((i13 == 92) || (i13 == 39) || (i13 == 34))
        {
          i12 = i13;
          break label457;
        }
        if (i13 == 10)
          break label508;
        if (i13 != 13)
          break label719;
        break label508;
      }
      if (i12 != 92)
        break label759;
      i12 = 0;
    }
  }

  public static void setArgs(String[] paramArrayOfString, int paramInt)
  {
    ApplicationMainSupport.setArgs(paramArrayOfString, paramInt);
  }

  public static boolean shouldUseGuiConsole()
  {
    if (noConsole)
      return true;
    try
    {
      Object localObject = Class.forName("java.lang.System").getMethod("console", new Class[0]).invoke(new Object[0], new Object[0]);
      if (localObject == null)
        return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  private static void startGuiConsole()
  {
    try
    {
      Class.forName("kawa.GuiConsole").newInstance();
      return;
    }
    catch (Exception localException)
    {
      System.err.println("failed to create Kawa window: " + localException);
      System.exit(-1);
    }
  }

  public Object apply0()
  {
    Shell.run(this.language, Environment.getCurrent());
    return Values.empty;
  }

  public Object apply1(Object paramObject)
  {
    Shell.run(this.language, (Environment)paramObject);
    return Values.empty;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.repl
 * JD-Core Version:    0.6.2
 */