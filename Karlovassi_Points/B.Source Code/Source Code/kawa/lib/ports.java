package kawa.lib;

import gnu.bytecode.ClassType;
import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.AbstractFormat;
import gnu.lists.Consumer;
import gnu.lists.EofClass;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.CharArrayOutPort;
import gnu.mapping.InPort;
import gnu.mapping.LocationProc;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.TtyInPort;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.LineBufferedReader;
import gnu.text.Path;
import gnu.text.SyntaxException;
import java.io.Writer;
import kawa.standard.Scheme;
import kawa.standard.char_ready_p;
import kawa.standard.read_line;

public class ports extends ModuleBody
{
  public static final ports $instance;
  static final SimpleSymbol Lit0;
  static final ClassType Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29;
  static final ClassType Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final SimpleSymbol Lit33;
  static final SimpleSymbol Lit34;
  static final SimpleSymbol Lit35;
  static final SimpleSymbol Lit36;
  static final SimpleSymbol Lit37;
  static final SimpleSymbol Lit38;
  static final SimpleSymbol Lit39;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final SimpleSymbol Lit42;
  static final SimpleSymbol Lit43;
  static final SimpleSymbol Lit44;
  static final SimpleSymbol Lit45 = (SimpleSymbol)new SimpleSymbol("transcript-off").readResolve();
  static final Keyword Lit5;
  static final IntNum Lit6;
  static final Char Lit7;
  static final Char Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod call$Mnwith$Mninput$Mnfile;
  public static final ModuleMethod call$Mnwith$Mninput$Mnstring;
  public static final ModuleMethod call$Mnwith$Mnoutput$Mnfile;
  public static final ModuleMethod call$Mnwith$Mnoutput$Mnstring;
  public static final ModuleMethod char$Mnready$Qu;
  public static final ModuleMethod close$Mninput$Mnport;
  public static final ModuleMethod close$Mnoutput$Mnport;
  public static final LocationProc current$Mnerror$Mnport;
  public static final LocationProc current$Mninput$Mnport;
  public static final LocationProc current$Mnoutput$Mnport;
  public static final ModuleMethod default$Mnprompter;
  public static final ModuleMethod display;
  public static final ModuleMethod eof$Mnobject$Qu;
  public static final ModuleMethod force$Mnoutput;
  public static final ModuleMethod get$Mnoutput$Mnstring;
  public static final ModuleMethod input$Mnport$Mncolumn$Mnnumber;
  public static final GenericProc input$Mnport$Mnline$Mnnumber;
  static final ModuleMethod input$Mnport$Mnline$Mnnumber$Fn5;
  public static final GenericProc input$Mnport$Mnprompter;
  static final ModuleMethod input$Mnport$Mnprompter$Fn6;
  public static final ModuleMethod input$Mnport$Mnread$Mnstate;
  public static final ModuleMethod input$Mnport$Qu;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn2;
  static final ModuleMethod lambda$Fn3;
  public static final ModuleMethod newline;
  public static final ModuleMethod open$Mninput$Mnfile;
  public static final ModuleMethod open$Mninput$Mnstring;
  public static final ModuleMethod open$Mnoutput$Mnfile;
  public static final ModuleMethod open$Mnoutput$Mnstring;
  public static final ModuleMethod output$Mnport$Qu;
  public static final ModuleMethod port$Mncolumn;
  public static final GenericProc port$Mnline;
  static final ModuleMethod port$Mnline$Fn4;
  public static final ModuleMethod read;
  public static final ModuleMethod read$Mnline;
  public static final ModuleMethod set$Mninput$Mnport$Mnline$Mnnumber$Ex;
  public static final ModuleMethod set$Mninput$Mnport$Mnprompter$Ex;
  public static final ModuleMethod set$Mnport$Mnline$Ex;
  public static final ModuleMethod transcript$Mnoff;
  public static final ModuleMethod transcript$Mnon;
  public static final ModuleMethod with$Mninput$Mnfrom$Mnfile;
  public static final ModuleMethod with$Mnoutput$Mnto$Mnfile;
  public static final ModuleMethod write;
  public static final ModuleMethod write$Mnchar;

  static
  {
    Lit44 = (SimpleSymbol)new SimpleSymbol("transcript-on").readResolve();
    Lit43 = (SimpleSymbol)new SimpleSymbol("read-line").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("read").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("close-output-port").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("close-input-port").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("input-port-prompter").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("set-input-port-prompter!").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("default-prompter").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("input-port-column-number").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("port-column").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("input-port-line-number").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("set-input-port-line-number!").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("port-line").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("set-port-line!").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("input-port-read-state").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("display").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("write").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("char-ready?").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("eof-object?").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("newline").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("force-output").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("call-with-output-string").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("call-with-input-string").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("get-output-string").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("open-output-string").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("open-input-string").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("write-char").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("output-port?").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("input-port?").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("with-output-to-file").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("with-input-from-file").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("call-with-output-file").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("call-with-input-file").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("open-output-file").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("open-input-file").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("trim").readResolve();
    Lit8 = Char.make(32);
    Lit7 = Char.make(10);
    Lit6 = IntNum.make(1);
    Lit5 = Keyword.make("setter");
    Lit4 = (SimpleSymbol)new SimpleSymbol("current-error-port").readResolve();
    Lit3 = ClassType.make("gnu.mapping.OutPort");
    Lit2 = (SimpleSymbol)new SimpleSymbol("current-output-port").readResolve();
    Lit1 = ClassType.make("gnu.mapping.InPort");
    Lit0 = (SimpleSymbol)new SimpleSymbol("current-input-port").readResolve();
    $instance = new ports();
    ports localports = $instance;
    open$Mninput$Mnfile = new ModuleMethod(localports, 1, Lit10, 4097);
    open$Mnoutput$Mnfile = new ModuleMethod(localports, 2, Lit11, 4097);
    call$Mnwith$Mninput$Mnfile = new ModuleMethod(localports, 3, Lit12, 8194);
    call$Mnwith$Mnoutput$Mnfile = new ModuleMethod(localports, 4, Lit13, 8194);
    with$Mninput$Mnfrom$Mnfile = new ModuleMethod(localports, 5, Lit14, 8194);
    with$Mnoutput$Mnto$Mnfile = new ModuleMethod(localports, 6, Lit15, 8194);
    input$Mnport$Qu = new ModuleMethod(localports, 7, Lit16, 4097);
    output$Mnport$Qu = new ModuleMethod(localports, 8, Lit17, 4097);
    lambda$Fn1 = new ModuleMethod(localports, 9, null, 4097);
    lambda$Fn2 = new ModuleMethod(localports, 10, null, 4097);
    lambda$Fn3 = new ModuleMethod(localports, 11, null, 4097);
    write$Mnchar = new ModuleMethod(localports, 12, Lit18, 8193);
    open$Mninput$Mnstring = new ModuleMethod(localports, 14, Lit19, 4097);
    open$Mnoutput$Mnstring = new ModuleMethod(localports, 15, Lit20, 0);
    get$Mnoutput$Mnstring = new ModuleMethod(localports, 16, Lit21, 4097);
    call$Mnwith$Mninput$Mnstring = new ModuleMethod(localports, 17, Lit22, 8194);
    call$Mnwith$Mnoutput$Mnstring = new ModuleMethod(localports, 18, Lit23, 4097);
    force$Mnoutput = new ModuleMethod(localports, 19, Lit24, 4096);
    newline = new ModuleMethod(localports, 21, Lit25, 4096);
    eof$Mnobject$Qu = new ModuleMethod(localports, 23, Lit26, 4097);
    char$Mnready$Qu = new ModuleMethod(localports, 24, Lit27, 4096);
    write = new ModuleMethod(localports, 26, Lit28, 8193);
    display = new ModuleMethod(localports, 28, Lit29, 8193);
    input$Mnport$Mnread$Mnstate = new ModuleMethod(localports, 30, Lit30, 4097);
    set$Mnport$Mnline$Ex = new ModuleMethod(localports, 31, Lit31, 8194);
    port$Mnline$Fn4 = new ModuleMethod(localports, 32, Lit32, 4097);
    set$Mninput$Mnport$Mnline$Mnnumber$Ex = new ModuleMethod(localports, 33, Lit33, 8194);
    input$Mnport$Mnline$Mnnumber$Fn5 = new ModuleMethod(localports, 34, Lit34, 4097);
    port$Mncolumn = new ModuleMethod(localports, 35, Lit35, 4097);
    input$Mnport$Mncolumn$Mnnumber = new ModuleMethod(localports, 36, Lit36, 4097);
    default$Mnprompter = new ModuleMethod(localports, 37, Lit37, 4097);
    set$Mninput$Mnport$Mnprompter$Ex = new ModuleMethod(localports, 38, Lit38, 8194);
    input$Mnport$Mnprompter$Fn6 = new ModuleMethod(localports, 39, Lit39, 4097);
    close$Mninput$Mnport = new ModuleMethod(localports, 40, Lit40, 4097);
    close$Mnoutput$Mnport = new ModuleMethod(localports, 41, Lit41, 4097);
    read = new ModuleMethod(localports, 42, Lit42, 4096);
    read$Mnline = new ModuleMethod(localports, 44, Lit43, 8192);
    transcript$Mnon = new ModuleMethod(localports, 47, Lit44, 4097);
    transcript$Mnoff = new ModuleMethod(localports, 48, Lit45, 0);
    $instance.run();
  }

  public ports()
  {
    ModuleInfo.register(this);
  }

  public static Object callWithInputFile(Path paramPath, Procedure paramProcedure)
  {
    InPort localInPort = openInputFile(paramPath);
    try
    {
      Object localObject2 = paramProcedure.apply1(localInPort);
      return localObject2;
    }
    finally
    {
      closeInputPort(localInPort);
    }
  }

  public static Object callWithInputString(CharSequence paramCharSequence, Procedure paramProcedure)
  {
    if (paramCharSequence == null);
    for (String str = null; ; str = paramCharSequence.toString())
    {
      CharArrayInPort localCharArrayInPort = new CharArrayInPort(str);
      Object localObject = paramProcedure.apply1(localCharArrayInPort);
      closeInputPort(localCharArrayInPort);
      return localObject;
    }
  }

  public static Object callWithOutputFile(Path paramPath, Procedure paramProcedure)
  {
    OutPort localOutPort = openOutputFile(paramPath);
    try
    {
      Object localObject2 = paramProcedure.apply1(localOutPort);
      return localObject2;
    }
    finally
    {
      closeOutputPort(localOutPort);
    }
  }

  public static FString callWithOutputString(Procedure paramProcedure)
  {
    CharArrayOutPort localCharArrayOutPort = new CharArrayOutPort();
    paramProcedure.apply1(localCharArrayOutPort);
    char[] arrayOfChar = localCharArrayOutPort.toCharArray();
    localCharArrayOutPort.close();
    return new FString(arrayOfChar);
  }

  public static Object closeInputPort(InPort paramInPort)
  {
    paramInPort.close();
    return Values.empty;
  }

  public static Object closeOutputPort(OutPort paramOutPort)
  {
    paramOutPort.close();
    return Values.empty;
  }

  public static Object defaultPrompter(Object paramObject)
  {
    int i = inputPortReadState(paramObject);
    if (characters.isChar$Eq(Char.make(i), Lit7))
      return "";
    Object[] arrayOfObject1 = new Object[3];
    Object localObject1;
    if (characters.isChar$Eq(Char.make(i), Lit8))
      localObject1 = "#|kawa:";
    while (true)
    {
      arrayOfObject1[0] = localObject1;
      Object localObject2 = input$Mnport$Mnline$Mnnumber.apply1(paramObject);
      try
      {
        Number localNumber = (Number)localObject2;
        arrayOfObject1[1] = numbers.number$To$String(localNumber);
        arrayOfObject1[2] = "|# ";
        return strings.stringAppend(arrayOfObject1);
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = "#|";
        arrayOfObject2[1] = strings.makeString(1, Char.make(i));
        arrayOfObject2[2] = "---:";
        localObject1 = strings.stringAppend(arrayOfObject2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "number->string", 0, localObject2);
      }
    }
  }

  public static void display(Object paramObject)
  {
    display(paramObject, current$Mnoutput$Mnport.apply0());
  }

  public static void display(Object paramObject1, Object paramObject2)
  {
    AbstractFormat localAbstractFormat = Scheme.displayFormat;
    try
    {
      Consumer localConsumer = (Consumer)paramObject2;
      localAbstractFormat.format(paramObject1, localConsumer);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.lists.AbstractFormat.format(java.lang.Object,gnu.lists.Consumer)", 3, paramObject2);
    }
  }

  public static void forceOutput()
  {
    forceOutput(current$Mnoutput$Mnport.apply0());
  }

  public static void forceOutput(Object paramObject)
  {
    try
    {
      Writer localWriter = (Writer)paramObject;
      localWriter.flush();
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "java.io.Writer.flush()", 1, paramObject);
    }
  }

  public static FString getOutputString(CharArrayOutPort paramCharArrayOutPort)
  {
    return new FString(paramCharArrayOutPort.toCharArray());
  }

  public static int inputPortColumnNumber(Object paramObject)
  {
    return 1 + portColumn(paramObject);
  }

  public static Object inputPortLineNumber(LineBufferedReader paramLineBufferedReader)
  {
    return AddOp.$Pl.apply2(Lit6, port$Mnline.apply1(paramLineBufferedReader));
  }

  public static Procedure inputPortPrompter(TtyInPort paramTtyInPort)
  {
    return paramTtyInPort.getPrompter();
  }

  public static char inputPortReadState(Object paramObject)
  {
    try
    {
      InPort localInPort = (InPort)paramObject;
      return localInPort.getReadState();
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.mapping.InPort.getReadState()", 1, paramObject);
    }
  }

  public static boolean isCharReady()
  {
    return isCharReady(current$Mninput$Mnport.apply0());
  }

  public static boolean isCharReady(Object paramObject)
  {
    return char_ready_p.ready(paramObject);
  }

  public static boolean isEofObject(Object paramObject)
  {
    return paramObject == EofClass.eofValue;
  }

  public static boolean isInputPort(Object paramObject)
  {
    return paramObject instanceof InPort;
  }

  public static boolean isOutputPort(Object paramObject)
  {
    return paramObject instanceof OutPort;
  }

  static Object lambda1(Object paramObject)
  {
    try
    {
      InPort localInPort = (InPort)paramObject;
      return localInPort;
    }
    catch (ClassCastException localClassCastException)
    {
      WrongType localWrongType = WrongType.make(localClassCastException, current$Mninput$Mnport, 1, paramObject);
      localWrongType.expectedType = Lit1;
      throw ((Throwable)localWrongType);
    }
  }

  static Object lambda2(Object paramObject)
  {
    try
    {
      OutPort localOutPort = (OutPort)paramObject;
      return localOutPort;
    }
    catch (ClassCastException localClassCastException)
    {
      WrongType localWrongType = WrongType.make(localClassCastException, current$Mnoutput$Mnport, 1, paramObject);
      localWrongType.expectedType = Lit3;
      throw ((Throwable)localWrongType);
    }
  }

  static Object lambda3(Object paramObject)
  {
    try
    {
      OutPort localOutPort = (OutPort)paramObject;
      return localOutPort;
    }
    catch (ClassCastException localClassCastException)
    {
      WrongType localWrongType = WrongType.make(localClassCastException, current$Mnerror$Mnport, 1, paramObject);
      localWrongType.expectedType = Lit3;
      throw ((Throwable)localWrongType);
    }
  }

  public static void newline()
  {
    newline(current$Mnoutput$Mnport.apply0());
  }

  public static void newline(Object paramObject)
  {
    try
    {
      OutPort localOutPort = (OutPort)paramObject;
      localOutPort.println();
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.mapping.OutPort.println()", 1, paramObject);
    }
  }

  public static InPort openInputFile(Path paramPath)
  {
    return InPort.openFile(paramPath);
  }

  public static InPort openInputString(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null);
    for (String str = null; ; str = paramCharSequence.toString())
      return new CharArrayInPort(str);
  }

  public static OutPort openOutputFile(Path paramPath)
  {
    return OutPort.openFile(paramPath);
  }

  public static CharArrayOutPort openOutputString()
  {
    return new CharArrayOutPort();
  }

  public static int portColumn(Object paramObject)
  {
    try
    {
      LineBufferedReader localLineBufferedReader = (LineBufferedReader)paramObject;
      return localLineBufferedReader.getColumnNumber();
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.text.LineBufferedReader.getColumnNumber()", 1, paramObject);
    }
  }

  public static int portLine(LineBufferedReader paramLineBufferedReader)
  {
    return paramLineBufferedReader.getLineNumber();
  }

  public static Object read()
  {
    return read((InPort)current$Mninput$Mnport.apply0());
  }

  public static Object read(InPort paramInPort)
  {
    LispReader localLispReader = new LispReader(paramInPort);
    Object localObject;
    try
    {
      localObject = localLispReader.readObject();
      if (localLispReader.seenErrors())
        throw ((Throwable)new SyntaxException(localLispReader.getMessages()));
    }
    catch (SyntaxException localSyntaxException)
    {
      localSyntaxException.setHeader("syntax error in read:");
      throw ((Throwable)localSyntaxException);
    }
    return localObject;
  }

  public static Object readLine()
  {
    return readLine((LineBufferedReader)current$Mninput$Mnport.apply0(), Lit9);
  }

  public static Object readLine(LineBufferedReader paramLineBufferedReader)
  {
    return readLine(paramLineBufferedReader, Lit9);
  }

  public static Object readLine(LineBufferedReader paramLineBufferedReader, Symbol paramSymbol)
  {
    if (paramSymbol == null);
    for (String str = null; ; str = paramSymbol.toString())
      return read_line.apply(paramLineBufferedReader, str);
  }

  public static void setInputPortLineNumber$Ex(Object paramObject1, Object paramObject2)
  {
    setPortLine$Ex(paramObject1, AddOp.$Mn.apply2(paramObject2, Lit6));
  }

  public static void setInputPortPrompter$Ex(TtyInPort paramTtyInPort, Procedure paramProcedure)
  {
    paramTtyInPort.setPrompter(paramProcedure);
  }

  // ERROR //
  public static void setPortLine$Ex(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 648	gnu/text/LineBufferedReader
    //   4: astore_3
    //   5: aload_1
    //   6: checkcast 495	java/lang/Number
    //   9: invokevirtual 712	java/lang/Number:intValue	()I
    //   12: istore 5
    //   14: aload_3
    //   15: iload 5
    //   17: invokevirtual 716	gnu/text/LineBufferedReader:setLineNumber	(I)V
    //   20: return
    //   21: astore_2
    //   22: new 519	gnu/mapping/WrongType
    //   25: dup
    //   26: aload_2
    //   27: ldc_w 718
    //   30: iconst_1
    //   31: aload_0
    //   32: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   35: athrow
    //   36: astore 4
    //   38: new 519	gnu/mapping/WrongType
    //   41: dup
    //   42: aload 4
    //   44: ldc_w 718
    //   47: iconst_2
    //   48: aload_1
    //   49: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   52: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	21	java/lang/ClassCastException
    //   5	14	36	java/lang/ClassCastException
  }

  public static void transcriptOff()
  {
    OutPort.closeLogFile();
  }

  public static void transcriptOn(Object paramObject)
  {
    OutPort.setLogFile(paramObject.toString());
  }

  public static Object withInputFromFile(Path paramPath, Procedure paramProcedure)
  {
    InPort localInPort1 = InPort.openFile(paramPath);
    InPort localInPort2 = InPort.inDefault();
    try
    {
      InPort.setInDefault(localInPort1);
      Object localObject2 = paramProcedure.apply0();
      return localObject2;
    }
    finally
    {
      InPort.setInDefault(localInPort2);
      localInPort1.close();
    }
  }

  public static Object withOutputToFile(Path paramPath, Procedure paramProcedure)
  {
    OutPort localOutPort1 = OutPort.openFile(paramPath);
    OutPort localOutPort2 = OutPort.outDefault();
    try
    {
      OutPort.setOutDefault(localOutPort1);
      Object localObject2 = paramProcedure.apply0();
      return localObject2;
    }
    finally
    {
      OutPort.setOutDefault(localOutPort2);
      localOutPort1.close();
    }
  }

  public static void write(Object paramObject)
  {
    write(paramObject, current$Mnoutput$Mnport.apply0());
  }

  public static void write(Object paramObject1, Object paramObject2)
  {
    AbstractFormat localAbstractFormat = Scheme.writeFormat;
    try
    {
      Consumer localConsumer = (Consumer)paramObject2;
      localAbstractFormat.format(paramObject1, localConsumer);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.lists.AbstractFormat.format(java.lang.Object,gnu.lists.Consumer)", 3, paramObject2);
    }
  }

  public static void writeChar(Object paramObject)
  {
    writeChar(paramObject, OutPort.outDefault());
  }

  public static void writeChar(Object paramObject, OutPort paramOutPort)
  {
    try
    {
      Char localChar = (Char)paramObject;
      Char.print(characters.char$To$Integer(localChar), paramOutPort);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "char->integer", 1, paramObject);
    }
  }

  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply0(paramModuleMethod);
    case 15:
      return openOutputString();
    case 19:
      forceOutput();
      return Values.empty;
    case 21:
      newline();
      return Values.empty;
    case 24:
      if (isCharReady())
        return Boolean.TRUE;
      return Boolean.FALSE;
    case 42:
      return read();
    case 44:
      return readLine();
    case 48:
    }
    transcriptOff();
    return Values.empty;
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 768	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+204 -> 208, 1:+211->215, 2:+223->227, 3:+204->208, 4:+204->208, 5:+204->208, 6:+204->208, 7:+235->239, 8:+250->254, 9:+265->269, 10:+270->274, 11:+275->279, 12:+280->284, 13:+204->208, 14:+288->292, 15:+204->208, 16:+300->304, 17:+204->208, 18:+312->316, 19:+324->328, 20:+204->208, 21:+332->336, 22:+204->208, 23:+340->344, 24:+355->359, 25:+204->208, 26:+370->374, 27:+204->208, 28:+378->382, 29:+204->208, 30:+386->390, 31:+204->208, 32:+394->398, 33:+204->208, 34:+409->413, 35:+421->425, 36:+429->433, 37:+437->441, 38:+204->208, 39:+442->446, 40:+454->458, 41:+466->470, 42:+478->482, 43:+204->208, 44:+490->494, 45:+204->208, 46:+204->208, 47:+502->506
    //   209: aload_1
    //   210: aload_2
    //   211: invokespecial 796	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: areturn
    //   215: aload_2
    //   216: invokestatic 802	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   219: astore 26
    //   221: aload 26
    //   223: invokestatic 415	kawa/lib/ports:openInputFile	(Lgnu/text/Path;)Lgnu/mapping/InPort;
    //   226: areturn
    //   227: aload_2
    //   228: invokestatic 802	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   231: astore 24
    //   233: aload 24
    //   235: invokestatic 441	kawa/lib/ports:openOutputFile	(Lgnu/text/Path;)Lgnu/mapping/OutPort;
    //   238: areturn
    //   239: aload_2
    //   240: invokestatic 804	kawa/lib/ports:isInputPort	(Ljava/lang/Object;)Z
    //   243: ifeq +7 -> 250
    //   246: getstatic 784	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   249: areturn
    //   250: getstatic 787	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   253: areturn
    //   254: aload_2
    //   255: invokestatic 806	kawa/lib/ports:isOutputPort	(Ljava/lang/Object;)Z
    //   258: ifeq +7 -> 265
    //   261: getstatic 784	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   264: areturn
    //   265: getstatic 787	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   268: areturn
    //   269: aload_2
    //   270: invokestatic 808	kawa/lib/ports:lambda1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   273: areturn
    //   274: aload_2
    //   275: invokestatic 810	kawa/lib/ports:lambda2	(Ljava/lang/Object;)Ljava/lang/Object;
    //   278: areturn
    //   279: aload_2
    //   280: invokestatic 812	kawa/lib/ports:lambda3	(Ljava/lang/Object;)Ljava/lang/Object;
    //   283: areturn
    //   284: aload_2
    //   285: invokestatic 814	kawa/lib/ports:writeChar	(Ljava/lang/Object;)V
    //   288: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   291: areturn
    //   292: aload_2
    //   293: checkcast 816	java/lang/CharSequence
    //   296: astore 22
    //   298: aload 22
    //   300: invokestatic 818	kawa/lib/ports:openInputString	(Ljava/lang/CharSequence;)Lgnu/mapping/InPort;
    //   303: areturn
    //   304: aload_2
    //   305: checkcast 449	gnu/mapping/CharArrayOutPort
    //   308: astore 20
    //   310: aload 20
    //   312: invokestatic 820	kawa/lib/ports:getOutputString	(Lgnu/mapping/CharArrayOutPort;)Lgnu/lists/FString;
    //   315: areturn
    //   316: aload_2
    //   317: checkcast 417	gnu/mapping/Procedure
    //   320: astore 18
    //   322: aload 18
    //   324: invokestatic 822	kawa/lib/ports:callWithOutputString	(Lgnu/mapping/Procedure;)Lgnu/lists/FString;
    //   327: areturn
    //   328: aload_2
    //   329: invokestatic 551	kawa/lib/ports:forceOutput	(Ljava/lang/Object;)V
    //   332: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   335: areturn
    //   336: aload_2
    //   337: invokestatic 630	kawa/lib/ports:newline	(Ljava/lang/Object;)V
    //   340: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   343: areturn
    //   344: aload_2
    //   345: invokestatic 824	kawa/lib/ports:isEofObject	(Ljava/lang/Object;)Z
    //   348: ifeq +7 -> 355
    //   351: getstatic 784	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   354: areturn
    //   355: getstatic 787	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   358: areturn
    //   359: aload_2
    //   360: invokestatic 600	kawa/lib/ports:isCharReady	(Ljava/lang/Object;)Z
    //   363: ifeq +7 -> 370
    //   366: getstatic 784	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   369: areturn
    //   370: getstatic 787	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   373: areturn
    //   374: aload_2
    //   375: invokestatic 826	kawa/lib/ports:write	(Ljava/lang/Object;)V
    //   378: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   381: areturn
    //   382: aload_2
    //   383: invokestatic 828	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   386: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   389: areturn
    //   390: aload_2
    //   391: invokestatic 481	kawa/lib/ports:inputPortReadState	(Ljava/lang/Object;)C
    //   394: invokestatic 267	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   397: areturn
    //   398: aload_2
    //   399: checkcast 648	gnu/text/LineBufferedReader
    //   402: astore 16
    //   404: aload 16
    //   406: invokestatic 830	kawa/lib/ports:portLine	(Lgnu/text/LineBufferedReader;)I
    //   409: invokestatic 835	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   412: areturn
    //   413: aload_2
    //   414: checkcast 648	gnu/text/LineBufferedReader
    //   417: astore 14
    //   419: aload 14
    //   421: invokestatic 837	kawa/lib/ports:inputPortLineNumber	(Lgnu/text/LineBufferedReader;)Ljava/lang/Object;
    //   424: areturn
    //   425: aload_2
    //   426: invokestatic 565	kawa/lib/ports:portColumn	(Ljava/lang/Object;)I
    //   429: invokestatic 835	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   432: areturn
    //   433: aload_2
    //   434: invokestatic 839	kawa/lib/ports:inputPortColumnNumber	(Ljava/lang/Object;)I
    //   437: invokestatic 835	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: areturn
    //   441: aload_2
    //   442: invokestatic 841	kawa/lib/ports:defaultPrompter	(Ljava/lang/Object;)Ljava/lang/Object;
    //   445: areturn
    //   446: aload_2
    //   447: checkcast 583	gnu/mapping/TtyInPort
    //   450: astore 12
    //   452: aload 12
    //   454: invokestatic 843	kawa/lib/ports:inputPortPrompter	(Lgnu/mapping/TtyInPort;)Lgnu/mapping/Procedure;
    //   457: areturn
    //   458: aload_2
    //   459: checkcast 464	gnu/mapping/InPort
    //   462: astore 10
    //   464: aload 10
    //   466: invokestatic 425	kawa/lib/ports:closeInputPort	(Lgnu/mapping/InPort;)Ljava/lang/Object;
    //   469: areturn
    //   470: aload_2
    //   471: checkcast 473	gnu/mapping/OutPort
    //   474: astore 8
    //   476: aload 8
    //   478: invokestatic 445	kawa/lib/ports:closeOutputPort	(Lgnu/mapping/OutPort;)Ljava/lang/Object;
    //   481: areturn
    //   482: aload_2
    //   483: checkcast 464	gnu/mapping/InPort
    //   486: astore 6
    //   488: aload 6
    //   490: invokestatic 661	kawa/lib/ports:read	(Lgnu/mapping/InPort;)Ljava/lang/Object;
    //   493: areturn
    //   494: aload_2
    //   495: checkcast 648	gnu/text/LineBufferedReader
    //   498: astore 4
    //   500: aload 4
    //   502: invokestatic 845	kawa/lib/ports:readLine	(Lgnu/text/LineBufferedReader;)Ljava/lang/Object;
    //   505: areturn
    //   506: aload_2
    //   507: invokestatic 847	kawa/lib/ports:transcriptOn	(Ljava/lang/Object;)V
    //   510: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   513: areturn
    //   514: astore 25
    //   516: new 519	gnu/mapping/WrongType
    //   519: dup
    //   520: aload 25
    //   522: ldc 255
    //   524: iconst_1
    //   525: aload_2
    //   526: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   529: athrow
    //   530: astore 23
    //   532: new 519	gnu/mapping/WrongType
    //   535: dup
    //   536: aload 23
    //   538: ldc 251
    //   540: iconst_1
    //   541: aload_2
    //   542: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   545: athrow
    //   546: astore 21
    //   548: new 519	gnu/mapping/WrongType
    //   551: dup
    //   552: aload 21
    //   554: ldc 219
    //   556: iconst_1
    //   557: aload_2
    //   558: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   561: athrow
    //   562: astore 19
    //   564: new 519	gnu/mapping/WrongType
    //   567: dup
    //   568: aload 19
    //   570: ldc 211
    //   572: iconst_1
    //   573: aload_2
    //   574: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   577: athrow
    //   578: astore 17
    //   580: new 519	gnu/mapping/WrongType
    //   583: dup
    //   584: aload 17
    //   586: ldc 203
    //   588: iconst_1
    //   589: aload_2
    //   590: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   593: athrow
    //   594: astore 15
    //   596: new 519	gnu/mapping/WrongType
    //   599: dup
    //   600: aload 15
    //   602: ldc 170
    //   604: iconst_1
    //   605: aload_2
    //   606: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   609: athrow
    //   610: astore 13
    //   612: new 519	gnu/mapping/WrongType
    //   615: dup
    //   616: aload 13
    //   618: ldc 162
    //   620: iconst_1
    //   621: aload_2
    //   622: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   625: athrow
    //   626: astore 11
    //   628: new 519	gnu/mapping/WrongType
    //   631: dup
    //   632: aload 11
    //   634: ldc 142
    //   636: iconst_1
    //   637: aload_2
    //   638: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   641: athrow
    //   642: astore 9
    //   644: new 519	gnu/mapping/WrongType
    //   647: dup
    //   648: aload 9
    //   650: ldc 138
    //   652: iconst_1
    //   653: aload_2
    //   654: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   657: athrow
    //   658: astore 7
    //   660: new 519	gnu/mapping/WrongType
    //   663: dup
    //   664: aload 7
    //   666: ldc 134
    //   668: iconst_1
    //   669: aload_2
    //   670: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   673: athrow
    //   674: astore 5
    //   676: new 519	gnu/mapping/WrongType
    //   679: dup
    //   680: aload 5
    //   682: ldc 130
    //   684: iconst_1
    //   685: aload_2
    //   686: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   689: athrow
    //   690: astore_3
    //   691: new 519	gnu/mapping/WrongType
    //   694: dup
    //   695: aload_3
    //   696: ldc 127
    //   698: iconst_1
    //   699: aload_2
    //   700: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   703: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   215	221	514	java/lang/ClassCastException
    //   227	233	530	java/lang/ClassCastException
    //   292	298	546	java/lang/ClassCastException
    //   304	310	562	java/lang/ClassCastException
    //   316	322	578	java/lang/ClassCastException
    //   398	404	594	java/lang/ClassCastException
    //   413	419	610	java/lang/ClassCastException
    //   446	452	626	java/lang/ClassCastException
    //   458	464	642	java/lang/ClassCastException
    //   470	476	658	java/lang/ClassCastException
    //   482	488	674	java/lang/ClassCastException
    //   494	500	690	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 768	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+108->112, 3:+116->120, 4:+136->140, 5:+156->160, 6:+176->180, 12:+196->200, 17:+212->216, 26:+232->236, 28:+241->245, 31:+250->254, 33:+259->263, 38:+268->272, 44:+291->295
    //   113: aload_1
    //   114: aload_2
    //   115: aload_3
    //   116: invokespecial 850	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: areturn
    //   120: aload_2
    //   121: invokestatic 802	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   124: astore 31
    //   126: aload_3
    //   127: checkcast 417	gnu/mapping/Procedure
    //   130: astore 33
    //   132: aload 31
    //   134: aload 33
    //   136: invokestatic 852	kawa/lib/ports:callWithInputFile	(Lgnu/text/Path;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   139: areturn
    //   140: aload_2
    //   141: invokestatic 802	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   144: astore 27
    //   146: aload_3
    //   147: checkcast 417	gnu/mapping/Procedure
    //   150: astore 29
    //   152: aload 27
    //   154: aload 29
    //   156: invokestatic 854	kawa/lib/ports:callWithOutputFile	(Lgnu/text/Path;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   159: areturn
    //   160: aload_2
    //   161: invokestatic 802	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   164: astore 23
    //   166: aload_3
    //   167: checkcast 417	gnu/mapping/Procedure
    //   170: astore 25
    //   172: aload 23
    //   174: aload 25
    //   176: invokestatic 856	kawa/lib/ports:withInputFromFile	(Lgnu/text/Path;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   179: areturn
    //   180: aload_2
    //   181: invokestatic 802	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   184: astore 19
    //   186: aload_3
    //   187: checkcast 417	gnu/mapping/Procedure
    //   190: astore 21
    //   192: aload 19
    //   194: aload 21
    //   196: invokestatic 858	kawa/lib/ports:withOutputToFile	(Lgnu/text/Path;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   199: areturn
    //   200: aload_3
    //   201: checkcast 473	gnu/mapping/OutPort
    //   204: astore 17
    //   206: aload_2
    //   207: aload 17
    //   209: invokestatic 753	kawa/lib/ports:writeChar	(Ljava/lang/Object;Lgnu/mapping/OutPort;)V
    //   212: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   215: areturn
    //   216: aload_2
    //   217: checkcast 816	java/lang/CharSequence
    //   220: astore 13
    //   222: aload_3
    //   223: checkcast 417	gnu/mapping/Procedure
    //   226: astore 15
    //   228: aload 13
    //   230: aload 15
    //   232: invokestatic 860	kawa/lib/ports:callWithInputString	(Ljava/lang/CharSequence;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   235: areturn
    //   236: aload_2
    //   237: aload_3
    //   238: invokestatic 746	kawa/lib/ports:write	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   241: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   244: areturn
    //   245: aload_2
    //   246: aload_3
    //   247: invokestatic 532	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   250: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   253: areturn
    //   254: aload_2
    //   255: aload_3
    //   256: invokestatic 703	kawa/lib/ports:setPortLine$Ex	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   259: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   262: areturn
    //   263: aload_2
    //   264: aload_3
    //   265: invokestatic 862	kawa/lib/ports:setInputPortLineNumber$Ex	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   268: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   271: areturn
    //   272: aload_2
    //   273: checkcast 583	gnu/mapping/TtyInPort
    //   276: astore 9
    //   278: aload_3
    //   279: checkcast 417	gnu/mapping/Procedure
    //   282: astore 11
    //   284: aload 9
    //   286: aload 11
    //   288: invokestatic 864	kawa/lib/ports:setInputPortPrompter$Ex	(Lgnu/mapping/TtyInPort;Lgnu/mapping/Procedure;)V
    //   291: getstatic 471	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   294: areturn
    //   295: aload_2
    //   296: checkcast 648	gnu/text/LineBufferedReader
    //   299: astore 5
    //   301: aload_3
    //   302: checkcast 866	gnu/mapping/Symbol
    //   305: astore 7
    //   307: aload 5
    //   309: aload 7
    //   311: invokestatic 690	kawa/lib/ports:readLine	(Lgnu/text/LineBufferedReader;Lgnu/mapping/Symbol;)Ljava/lang/Object;
    //   314: areturn
    //   315: astore 30
    //   317: new 519	gnu/mapping/WrongType
    //   320: dup
    //   321: aload 30
    //   323: ldc 247
    //   325: iconst_1
    //   326: aload_2
    //   327: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   330: athrow
    //   331: astore 32
    //   333: new 519	gnu/mapping/WrongType
    //   336: dup
    //   337: aload 32
    //   339: ldc 247
    //   341: iconst_2
    //   342: aload_3
    //   343: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   346: athrow
    //   347: astore 26
    //   349: new 519	gnu/mapping/WrongType
    //   352: dup
    //   353: aload 26
    //   355: ldc 243
    //   357: iconst_1
    //   358: aload_2
    //   359: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   362: athrow
    //   363: astore 28
    //   365: new 519	gnu/mapping/WrongType
    //   368: dup
    //   369: aload 28
    //   371: ldc 243
    //   373: iconst_2
    //   374: aload_3
    //   375: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   378: athrow
    //   379: astore 22
    //   381: new 519	gnu/mapping/WrongType
    //   384: dup
    //   385: aload 22
    //   387: ldc 239
    //   389: iconst_1
    //   390: aload_2
    //   391: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //   395: astore 24
    //   397: new 519	gnu/mapping/WrongType
    //   400: dup
    //   401: aload 24
    //   403: ldc 239
    //   405: iconst_2
    //   406: aload_3
    //   407: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   410: athrow
    //   411: astore 18
    //   413: new 519	gnu/mapping/WrongType
    //   416: dup
    //   417: aload 18
    //   419: ldc 235
    //   421: iconst_1
    //   422: aload_2
    //   423: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   426: athrow
    //   427: astore 20
    //   429: new 519	gnu/mapping/WrongType
    //   432: dup
    //   433: aload 20
    //   435: ldc 235
    //   437: iconst_2
    //   438: aload_3
    //   439: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   442: athrow
    //   443: astore 16
    //   445: new 519	gnu/mapping/WrongType
    //   448: dup
    //   449: aload 16
    //   451: ldc 223
    //   453: iconst_2
    //   454: aload_3
    //   455: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   458: athrow
    //   459: astore 12
    //   461: new 519	gnu/mapping/WrongType
    //   464: dup
    //   465: aload 12
    //   467: ldc 207
    //   469: iconst_1
    //   470: aload_2
    //   471: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   474: athrow
    //   475: astore 14
    //   477: new 519	gnu/mapping/WrongType
    //   480: dup
    //   481: aload 14
    //   483: ldc 207
    //   485: iconst_2
    //   486: aload_3
    //   487: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   490: athrow
    //   491: astore 8
    //   493: new 519	gnu/mapping/WrongType
    //   496: dup
    //   497: aload 8
    //   499: ldc 146
    //   501: iconst_1
    //   502: aload_2
    //   503: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   506: athrow
    //   507: astore 10
    //   509: new 519	gnu/mapping/WrongType
    //   512: dup
    //   513: aload 10
    //   515: ldc 146
    //   517: iconst_2
    //   518: aload_3
    //   519: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   522: athrow
    //   523: astore 4
    //   525: new 519	gnu/mapping/WrongType
    //   528: dup
    //   529: aload 4
    //   531: ldc 127
    //   533: iconst_1
    //   534: aload_2
    //   535: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   538: athrow
    //   539: astore 6
    //   541: new 519	gnu/mapping/WrongType
    //   544: dup
    //   545: aload 6
    //   547: ldc 127
    //   549: iconst_2
    //   550: aload_3
    //   551: invokespecial 524	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   554: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   120	126	315	java/lang/ClassCastException
    //   126	132	331	java/lang/ClassCastException
    //   140	146	347	java/lang/ClassCastException
    //   146	152	363	java/lang/ClassCastException
    //   160	166	379	java/lang/ClassCastException
    //   166	172	395	java/lang/ClassCastException
    //   180	186	411	java/lang/ClassCastException
    //   186	192	427	java/lang/ClassCastException
    //   200	206	443	java/lang/ClassCastException
    //   216	222	459	java/lang/ClassCastException
    //   222	228	475	java/lang/ClassCastException
    //   272	278	491	java/lang/ClassCastException
    //   278	284	507	java/lang/ClassCastException
    //   295	301	523	java/lang/ClassCastException
    //   301	307	539	java/lang/ClassCastException
  }

  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match0(paramModuleMethod, paramCallContext);
    case 48:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 44:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 42:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 24:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 21:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 19:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 15:
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 3:
    case 4:
    case 5:
    case 6:
    case 13:
    case 15:
    case 17:
    case 20:
    case 22:
    case 25:
    case 27:
    case 29:
    case 31:
    case 33:
    case 38:
    case 43:
    case 45:
    case 46:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 47:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 44:
      if (!(paramObject instanceof LineBufferedReader))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 42:
      if (!(paramObject instanceof InPort))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 41:
      if (!(paramObject instanceof OutPort))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 40:
      if (!(paramObject instanceof InPort))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 39:
      if (!(paramObject instanceof TtyInPort))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 37:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 36:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 35:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 34:
      if (!(paramObject instanceof LineBufferedReader))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 32:
      if (!(paramObject instanceof LineBufferedReader))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 30:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 26:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 24:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 23:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 21:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 19:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 18:
      if (!(paramObject instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 16:
      if (!(paramObject instanceof CharArrayOutPort))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 14:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 12:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 8:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 7:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 1:
    }
    if (Path.coerceToPathOrNull(paramObject) != null)
    {
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    return -786431;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 44:
      if (!(paramObject1 instanceof LineBufferedReader))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Symbol))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 38:
      if (!(paramObject1 instanceof TtyInPort))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 33:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 31:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 28:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 26:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 17:
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if (!(paramObject2 instanceof Procedure))
          return -786430;
      }
      else
      {
        return -786431;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 12:
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof OutPort))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 6:
      if (Path.coerceToPathOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (!(paramObject2 instanceof Procedure))
          return -786430;
      }
      else
      {
        return -786431;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 5:
      if (Path.coerceToPathOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (!(paramObject2 instanceof Procedure))
          return -786430;
      }
      else
      {
        return -786431;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 4:
      if (Path.coerceToPathOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (!(paramObject2 instanceof Procedure))
          return -786430;
      }
      else
      {
        return -786431;
      }
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 3:
    }
    if (Path.coerceToPathOrNull(paramObject1) != null)
    {
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
    }
    else
    {
      return -786431;
    }
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
    current$Mninput$Mnport = LocationProc.makeNamed(Lit0, InPort.inLocation);
    current$Mninput$Mnport.pushConverter(lambda$Fn1);
    current$Mnoutput$Mnport = LocationProc.makeNamed(Lit2, OutPort.outLocation);
    current$Mnoutput$Mnport.pushConverter(lambda$Fn2);
    current$Mnerror$Mnport = LocationProc.makeNamed(Lit4, OutPort.errLocation);
    current$Mnerror$Mnport.pushConverter(lambda$Fn3);
    port$Mnline = new GenericProc("port-line");
    GenericProc localGenericProc1 = port$Mnline;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = Lit5;
    arrayOfObject1[1] = set$Mnport$Mnline$Ex;
    arrayOfObject1[2] = port$Mnline$Fn4;
    localGenericProc1.setProperties(arrayOfObject1);
    input$Mnport$Mnline$Mnnumber = new GenericProc("input-port-line-number");
    GenericProc localGenericProc2 = input$Mnport$Mnline$Mnnumber;
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = Lit5;
    arrayOfObject2[1] = set$Mninput$Mnport$Mnline$Mnnumber$Ex;
    arrayOfObject2[2] = input$Mnport$Mnline$Mnnumber$Fn5;
    localGenericProc2.setProperties(arrayOfObject2);
    input$Mnport$Mnprompter = new GenericProc("input-port-prompter");
    GenericProc localGenericProc3 = input$Mnport$Mnprompter;
    Object[] arrayOfObject3 = new Object[3];
    arrayOfObject3[0] = Lit5;
    arrayOfObject3[1] = set$Mninput$Mnport$Mnprompter$Ex;
    arrayOfObject3[2] = input$Mnport$Mnprompter$Fn6;
    localGenericProc3.setProperties(arrayOfObject3);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.ports
 * JD-Core Version:    0.6.2
 */