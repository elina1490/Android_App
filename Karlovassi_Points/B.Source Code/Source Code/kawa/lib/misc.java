package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Symbols;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.xml.KNode;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import kawa.Version;
import kawa.lang.Promise;
import kawa.standard.Scheme;
import kawa.standard.throw_name;

public class misc extends ModuleBody
{
  public static final misc $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
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
  static final Keyword Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28 = (SimpleSymbol)new SimpleSymbol("add-procedure-properties").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod add$Mnprocedure$Mnproperties;
  public static final ModuleMethod base$Mnuri;
  public static final ModuleMethod boolean$Qu;
  public static final ModuleMethod dynamic$Mnwind;
  public static final ModuleMethod environment$Mnbound$Qu;
  public static final ModuleMethod error;
  public static final ModuleMethod force;
  public static final ModuleMethod gentemp;
  public static final ModuleMethod interaction$Mnenvironment;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn2;
  public static final ModuleMethod namespace$Mnprefix;
  public static final ModuleMethod namespace$Mnuri;
  public static final ModuleMethod null$Mnenvironment;
  public static final GenericProc procedure$Mnproperty;
  static final ModuleMethod procedure$Mnproperty$Fn3;
  public static final ModuleMethod procedure$Qu;
  public static final ModuleMethod scheme$Mnimplementation$Mnversion;
  public static final ModuleMethod scheme$Mnreport$Mnenvironment;
  public static final ModuleMethod set$Mnprocedure$Mnproperty$Ex;
  public static final ModuleMethod string$Mn$Grsymbol;
  public static final GenericProc symbol$Eq$Qu;
  public static final ModuleMethod symbol$Mn$Grstring;
  public static final ModuleMethod symbol$Mnlocal$Mnname;
  public static final ModuleMethod symbol$Mnnamespace;
  public static final ModuleMethod symbol$Mnnamespace$Mnuri;
  public static final ModuleMethod symbol$Mnprefix;
  public static final ModuleMethod symbol$Qu;
  public static final ModuleMethod values;

  static
  {
    Lit27 = (SimpleSymbol)new SimpleSymbol("gentemp").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("base-uri").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("error").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("force").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("dynamic-wind").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("procedure-property").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("set-procedure-property!").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("scheme-implementation-version").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("interaction-environment").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("scheme-report-environment").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("null-environment").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("environment-bound?").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("values").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("procedure?").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("string->symbol").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("namespace-prefix").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("namespace-uri").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("symbol-prefix").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("symbol-namespace-uri").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("symbol-namespace").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("symbol-local-name").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("symbol->string").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("symbol?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("boolean?").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("misc-error").readResolve();
    Lit2 = Keyword.make("setter");
    Lit1 = IntNum.make(5);
    Lit0 = IntNum.make(4);
    $instance = new misc();
    misc localmisc = $instance;
    boolean$Qu = new ModuleMethod(localmisc, 3, Lit4, 4097);
    symbol$Qu = new ModuleMethod(localmisc, 4, Lit5, 4097);
    symbol$Mn$Grstring = new ModuleMethod(localmisc, 5, Lit6, 4097);
    ModuleMethod localModuleMethod1 = new ModuleMethod(localmisc, 6, null, 8194);
    localModuleMethod1.setProperty("source-location", "misc.scm:25");
    lambda$Fn1 = localModuleMethod1;
    ModuleMethod localModuleMethod2 = new ModuleMethod(localmisc, 7, null, -4094);
    localModuleMethod2.setProperty("source-location", "misc.scm:27");
    lambda$Fn2 = localModuleMethod2;
    symbol$Mnlocal$Mnname = new ModuleMethod(localmisc, 8, Lit7, 4097);
    symbol$Mnnamespace = new ModuleMethod(localmisc, 9, Lit8, 4097);
    symbol$Mnnamespace$Mnuri = new ModuleMethod(localmisc, 10, Lit9, 4097);
    symbol$Mnprefix = new ModuleMethod(localmisc, 11, Lit10, 4097);
    namespace$Mnuri = new ModuleMethod(localmisc, 12, Lit11, 4097);
    namespace$Mnprefix = new ModuleMethod(localmisc, 13, Lit12, 4097);
    string$Mn$Grsymbol = new ModuleMethod(localmisc, 14, Lit13, 4097);
    procedure$Qu = new ModuleMethod(localmisc, 15, Lit14, 4097);
    values = new ModuleMethod(localmisc, 16, Lit15, -4096);
    environment$Mnbound$Qu = new ModuleMethod(localmisc, 17, Lit16, 8194);
    null$Mnenvironment = new ModuleMethod(localmisc, 18, Lit17, 4096);
    scheme$Mnreport$Mnenvironment = new ModuleMethod(localmisc, 20, Lit18, 4097);
    interaction$Mnenvironment = new ModuleMethod(localmisc, 21, Lit19, 0);
    scheme$Mnimplementation$Mnversion = new ModuleMethod(localmisc, 22, Lit20, 0);
    set$Mnprocedure$Mnproperty$Ex = new ModuleMethod(localmisc, 23, Lit21, 12291);
    procedure$Mnproperty$Fn3 = new ModuleMethod(localmisc, 24, Lit22, 12290);
    dynamic$Mnwind = new ModuleMethod(localmisc, 26, Lit23, 12291);
    force = new ModuleMethod(localmisc, 27, Lit24, 4097);
    error = new ModuleMethod(localmisc, 28, Lit25, -4095);
    base$Mnuri = new ModuleMethod(localmisc, 29, Lit26, 4096);
    gentemp = new ModuleMethod(localmisc, 31, Lit27, 0);
    add$Mnprocedure$Mnproperties = new ModuleMethod(localmisc, 32, Lit28, -4095);
    $instance.run();
  }

  public misc()
  {
    ModuleInfo.register(this);
  }

  public static void addProcedureProperties(GenericProc paramGenericProc, Object[] paramArrayOfObject)
  {
    paramGenericProc.setProperties(paramArrayOfObject);
  }

  public static Object baseUri()
  {
    return baseUri(null);
  }

  public static Object baseUri(Object paramObject)
  {
    if (paramObject == null);
    for (Path localPath = Path.currentPath(); localPath == Values.empty; localPath = ((KNode)paramObject).baseURI())
      return Boolean.FALSE;
    return localPath;
  }

  public static Object dynamicWind(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Scheme.applyToArgs.apply1(paramObject1);
    try
    {
      Object localObject2 = Scheme.applyToArgs.apply1(paramObject2);
      return localObject2;
    }
    finally
    {
      Scheme.applyToArgs.apply1(paramObject3);
    }
  }

  public static Object error$V(Object paramObject, Object[] paramArrayOfObject)
  {
    frame localframe = new frame();
    localframe.msg = paramObject;
    LList localLList1 = LList.makeList(paramArrayOfObject, 0);
    localframe.msg = ports.callWithOutputString(localframe.lambda$Fn4);
    Object localObject1 = LList.Empty;
    Object localObject2 = localLList1;
    while (true)
    {
      if (localObject2 == LList.Empty)
      {
        LList localLList2 = LList.reverseInPlace(localObject1);
        return Scheme.apply.apply4(throw_name.throwName, Lit3, localframe.msg, localLList2);
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject3 = localPair.getCdr();
        Object localObject4 = localPair.getCar();
        frame0 localframe0 = new frame0();
        localframe0.arg = localObject4;
        localObject1 = Pair.make(ports.callWithOutputString(localframe0.lambda$Fn5), localObject1);
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }

  public static Object force(Object paramObject)
  {
    return Promise.force(paramObject);
  }

  public static Symbol gentemp()
  {
    return Symbols.gentemp();
  }

  public static Environment interactionEnvironment()
  {
    return Environment.user();
  }

  public static boolean isBoolean(Object paramObject)
  {
    if (paramObject == Boolean.TRUE);
    for (boolean bool = true; bool; bool = false)
      return bool;
    return paramObject == Boolean.FALSE;
  }

  public static boolean isEnvironmentBound(Environment paramEnvironment, Object paramObject)
  {
    return paramEnvironment.isBound(LispLanguage.langSymbolToSymbol(paramObject));
  }

  public static boolean isProcedure(Object paramObject)
  {
    boolean bool = paramObject instanceof Procedure;
    if (bool)
      return bool;
    return paramObject instanceof LangObjType;
  }

  public static boolean isSymbol(Object paramObject)
  {
    return paramObject instanceof Symbol;
  }

  static boolean lambda1(Symbol paramSymbol1, Symbol paramSymbol2)
  {
    return Symbol.equals(paramSymbol1, paramSymbol2);
  }

  static boolean lambda2$V(Symbol paramSymbol1, Symbol paramSymbol2, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    boolean bool = Symbol.equals(paramSymbol1, paramSymbol2);
    if (bool)
      return Scheme.apply.apply3(symbol$Eq$Qu, paramSymbol2, localLList) != Boolean.FALSE;
    return bool;
  }

  public static CharSequence namespacePrefix(Namespace paramNamespace)
  {
    return paramNamespace.getPrefix();
  }

  public static CharSequence namespaceUri(Namespace paramNamespace)
  {
    return paramNamespace.getName();
  }

  public static Environment nullEnvironment()
  {
    return nullEnvironment(Boolean.FALSE);
  }

  public static Environment nullEnvironment(Object paramObject)
  {
    return Scheme.nullEnvironment;
  }

  public static Object procedureProperty(Procedure paramProcedure, Object paramObject)
  {
    return procedureProperty(paramProcedure, paramObject, Boolean.FALSE);
  }

  public static Object procedureProperty(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    return paramProcedure.getProperty(paramObject1, paramObject2);
  }

  public static String schemeImplementationVersion()
  {
    return Version.getVersion();
  }

  public static Object schemeReportEnvironment(Object paramObject)
  {
    if (Scheme.isEqv.apply2(paramObject, Lit0) != Boolean.FALSE)
      return Scheme.r4Environment;
    if (Scheme.isEqv.apply2(paramObject, Lit1) != Boolean.FALSE)
      return Scheme.r5Environment;
    return error$V("scheme-report-environment version must be 4 or 5", new Object[0]);
  }

  public static void setProcedureProperty$Ex(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    paramProcedure.setProperty(paramObject1, paramObject2);
  }

  public static SimpleSymbol string$To$Symbol(CharSequence paramCharSequence)
  {
    return SimpleSymbol.valueOf(paramCharSequence.toString());
  }

  public static String symbol$To$String(Symbol paramSymbol)
  {
    return paramSymbol.toString();
  }

  public static String symbolLocalName(Symbol paramSymbol)
  {
    return paramSymbol.getLocalPart();
  }

  public static Namespace symbolNamespace(Symbol paramSymbol)
  {
    return paramSymbol.getNamespace();
  }

  public static String symbolNamespaceUri(Symbol paramSymbol)
  {
    return paramSymbol.getNamespaceURI();
  }

  public static String symbolPrefix(Symbol paramSymbol)
  {
    return paramSymbol.getPrefix();
  }

  public static Object values(Object[] paramArrayOfObject)
  {
    return Values.make(paramArrayOfObject);
  }

  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply0(paramModuleMethod);
    case 18:
      return nullEnvironment();
    case 21:
      return interactionEnvironment();
    case 22:
      return schemeImplementationVersion();
    case 29:
      return baseUri();
    case 31:
    }
    return gentemp();
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 556	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+124 -> 128, 3:+131->135, 4:+146->150, 5:+161->165, 6:+124->128, 7:+124->128, 8:+173->177, 9:+185->189, 10:+197->201, 11:+209->213, 12:+221->225, 13:+233->237, 14:+245->249, 15:+257->261, 16:+124->128, 17:+124->128, 18:+272->276, 19:+124->128, 20:+277->281, 21:+124->128, 22:+124->128, 23:+124->128, 24:+124->128, 25:+124->128, 26:+124->128, 27:+282->286, 28:+124->128, 29:+287->291
    //   129: aload_1
    //   130: aload_2
    //   131: invokespecial 571	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: areturn
    //   135: aload_2
    //   136: invokestatic 573	kawa/lib/misc:isBoolean	(Ljava/lang/Object;)Z
    //   139: ifeq +7 -> 146
    //   142: getstatic 430	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   145: areturn
    //   146: getstatic 315	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   149: areturn
    //   150: aload_2
    //   151: invokestatic 575	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
    //   154: ifeq +7 -> 161
    //   157: getstatic 430	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   160: areturn
    //   161: getstatic 315	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   164: areturn
    //   165: aload_2
    //   166: checkcast 448	gnu/mapping/Symbol
    //   169: astore 18
    //   171: aload 18
    //   173: invokestatic 577	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   176: areturn
    //   177: aload_2
    //   178: checkcast 448	gnu/mapping/Symbol
    //   181: astore 16
    //   183: aload 16
    //   185: invokestatic 579	kawa/lib/misc:symbolLocalName	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   188: areturn
    //   189: aload_2
    //   190: checkcast 448	gnu/mapping/Symbol
    //   193: astore 14
    //   195: aload 14
    //   197: invokestatic 581	kawa/lib/misc:symbolNamespace	(Lgnu/mapping/Symbol;)Lgnu/mapping/Namespace;
    //   200: areturn
    //   201: aload_2
    //   202: checkcast 448	gnu/mapping/Symbol
    //   205: astore 12
    //   207: aload 12
    //   209: invokestatic 583	kawa/lib/misc:symbolNamespaceUri	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   212: areturn
    //   213: aload_2
    //   214: checkcast 448	gnu/mapping/Symbol
    //   217: astore 10
    //   219: aload 10
    //   221: invokestatic 585	kawa/lib/misc:symbolPrefix	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   224: areturn
    //   225: aload_2
    //   226: checkcast 464	gnu/mapping/Namespace
    //   229: astore 8
    //   231: aload 8
    //   233: invokestatic 587	kawa/lib/misc:namespaceUri	(Lgnu/mapping/Namespace;)Ljava/lang/CharSequence;
    //   236: areturn
    //   237: aload_2
    //   238: checkcast 464	gnu/mapping/Namespace
    //   241: astore 6
    //   243: aload 6
    //   245: invokestatic 589	kawa/lib/misc:namespacePrefix	(Lgnu/mapping/Namespace;)Ljava/lang/CharSequence;
    //   248: areturn
    //   249: aload_2
    //   250: checkcast 521	java/lang/CharSequence
    //   253: astore 4
    //   255: aload 4
    //   257: invokestatic 591	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   260: areturn
    //   261: aload_2
    //   262: invokestatic 593	kawa/lib/misc:isProcedure	(Ljava/lang/Object;)Z
    //   265: ifeq +7 -> 272
    //   268: getstatic 430	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   271: areturn
    //   272: getstatic 315	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   275: areturn
    //   276: aload_2
    //   277: invokestatic 476	kawa/lib/misc:nullEnvironment	(Ljava/lang/Object;)Lgnu/mapping/Environment;
    //   280: areturn
    //   281: aload_2
    //   282: invokestatic 595	kawa/lib/misc:schemeReportEnvironment	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: areturn
    //   286: aload_2
    //   287: invokestatic 596	kawa/lib/misc:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   290: areturn
    //   291: aload_2
    //   292: invokestatic 297	kawa/lib/misc:baseUri	(Ljava/lang/Object;)Ljava/lang/Object;
    //   295: areturn
    //   296: astore 17
    //   298: new 403	gnu/mapping/WrongType
    //   301: dup
    //   302: aload 17
    //   304: ldc 167
    //   306: iconst_1
    //   307: aload_2
    //   308: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    //   312: astore 15
    //   314: new 403	gnu/mapping/WrongType
    //   317: dup
    //   318: aload 15
    //   320: ldc 163
    //   322: iconst_1
    //   323: aload_2
    //   324: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   327: athrow
    //   328: astore 13
    //   330: new 403	gnu/mapping/WrongType
    //   333: dup
    //   334: aload 13
    //   336: ldc 159
    //   338: iconst_1
    //   339: aload_2
    //   340: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   343: athrow
    //   344: astore 11
    //   346: new 403	gnu/mapping/WrongType
    //   349: dup
    //   350: aload 11
    //   352: ldc 155
    //   354: iconst_1
    //   355: aload_2
    //   356: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   359: athrow
    //   360: astore 9
    //   362: new 403	gnu/mapping/WrongType
    //   365: dup
    //   366: aload 9
    //   368: ldc 151
    //   370: iconst_1
    //   371: aload_2
    //   372: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   375: athrow
    //   376: astore 7
    //   378: new 403	gnu/mapping/WrongType
    //   381: dup
    //   382: aload 7
    //   384: ldc 147
    //   386: iconst_1
    //   387: aload_2
    //   388: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   391: athrow
    //   392: astore 5
    //   394: new 403	gnu/mapping/WrongType
    //   397: dup
    //   398: aload 5
    //   400: ldc 143
    //   402: iconst_1
    //   403: aload_2
    //   404: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   407: athrow
    //   408: astore_3
    //   409: new 403	gnu/mapping/WrongType
    //   412: dup
    //   413: aload_3
    //   414: ldc 139
    //   416: iconst_1
    //   417: aload_2
    //   418: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   421: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   165	171	296	java/lang/ClassCastException
    //   177	183	312	java/lang/ClassCastException
    //   189	195	328	java/lang/ClassCastException
    //   201	207	344	java/lang/ClassCastException
    //   213	219	360	java/lang/ClassCastException
    //   225	231	376	java/lang/ClassCastException
    //   237	243	392	java/lang/ClassCastException
    //   249	255	408	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 556	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+36->40, 6:+44->48, 17:+74->78, 24:+97->101
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: invokespecial 599	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: areturn
    //   48: aload_2
    //   49: checkcast 448	gnu/mapping/Symbol
    //   52: astore 9
    //   54: aload_3
    //   55: checkcast 448	gnu/mapping/Symbol
    //   58: astore 11
    //   60: aload 9
    //   62: aload 11
    //   64: invokestatic 601	kawa/lib/misc:lambda1	(Lgnu/mapping/Symbol;Lgnu/mapping/Symbol;)Z
    //   67: ifeq +7 -> 74
    //   70: getstatic 430	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   73: areturn
    //   74: getstatic 315	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   77: areturn
    //   78: aload_2
    //   79: checkcast 422	gnu/mapping/Environment
    //   82: astore 7
    //   84: aload 7
    //   86: aload_3
    //   87: invokestatic 603	kawa/lib/misc:isEnvironmentBound	(Lgnu/mapping/Environment;Ljava/lang/Object;)Z
    //   90: ifeq +7 -> 97
    //   93: getstatic 430	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   96: areturn
    //   97: getstatic 315	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   100: areturn
    //   101: aload_2
    //   102: checkcast 330	gnu/mapping/Procedure
    //   105: astore 5
    //   107: aload 5
    //   109: aload_3
    //   110: invokestatic 605	kawa/lib/misc:procedureProperty	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: areturn
    //   114: astore 8
    //   116: new 403	gnu/mapping/WrongType
    //   119: dup
    //   120: aload 8
    //   122: ldc_w 607
    //   125: iconst_1
    //   126: aload_2
    //   127: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   130: athrow
    //   131: astore 10
    //   133: new 403	gnu/mapping/WrongType
    //   136: dup
    //   137: aload 10
    //   139: ldc_w 607
    //   142: iconst_2
    //   143: aload_3
    //   144: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   147: athrow
    //   148: astore 6
    //   150: new 403	gnu/mapping/WrongType
    //   153: dup
    //   154: aload 6
    //   156: ldc 128
    //   158: iconst_1
    //   159: aload_2
    //   160: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   163: athrow
    //   164: astore 4
    //   166: new 403	gnu/mapping/WrongType
    //   169: dup
    //   170: aload 4
    //   172: ldc 104
    //   174: iconst_1
    //   175: aload_2
    //   176: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   179: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   48	54	114	java/lang/ClassCastException
    //   54	60	131	java/lang/ClassCastException
    //   78	84	148	java/lang/ClassCastException
    //   101	107	164	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 556	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+32 -> 36, 23:+42->46, 24:+60->64, 25:+32->36, 26:+75->79
    //   37: aload_1
    //   38: aload_2
    //   39: aload_3
    //   40: aload 4
    //   42: invokespecial 610	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: areturn
    //   46: aload_2
    //   47: checkcast 330	gnu/mapping/Procedure
    //   50: astore 8
    //   52: aload 8
    //   54: aload_3
    //   55: aload 4
    //   57: invokestatic 612	kawa/lib/misc:setProcedureProperty$Ex	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)V
    //   60: getstatic 309	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   63: areturn
    //   64: aload_2
    //   65: checkcast 330	gnu/mapping/Procedure
    //   68: astore 6
    //   70: aload 6
    //   72: aload_3
    //   73: aload 4
    //   75: invokestatic 484	kawa/lib/misc:procedureProperty	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   78: areturn
    //   79: aload_2
    //   80: aload_3
    //   81: aload 4
    //   83: invokestatic 614	kawa/lib/misc:dynamicWind	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: areturn
    //   87: astore 7
    //   89: new 403	gnu/mapping/WrongType
    //   92: dup
    //   93: aload 7
    //   95: ldc 108
    //   97: iconst_1
    //   98: aload_2
    //   99: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   102: athrow
    //   103: astore 5
    //   105: new 403	gnu/mapping/WrongType
    //   108: dup
    //   109: aload 5
    //   111: ldc 104
    //   113: iconst_1
    //   114: aload_2
    //   115: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   118: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   46	52	87	java/lang/ClassCastException
    //   64	70	103	java/lang/ClassCastException
  }

  // ERROR //
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 556	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+44->48, 7:+51->55, 16:+134->138, 28:+139->143, 32:+191->195
    //   49: aload_1
    //   50: aload_2
    //   51: invokespecial 618	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: areturn
    //   55: aload_2
    //   56: iconst_0
    //   57: aaload
    //   58: astore 13
    //   60: aload 13
    //   62: checkcast 448	gnu/mapping/Symbol
    //   65: astore 15
    //   67: aload_2
    //   68: iconst_1
    //   69: aaload
    //   70: astore 16
    //   72: aload 16
    //   74: checkcast 448	gnu/mapping/Symbol
    //   77: astore 18
    //   79: aload_2
    //   80: arraylength
    //   81: iconst_2
    //   82: isub
    //   83: istore 19
    //   85: iload 19
    //   87: anewarray 512	java/lang/Object
    //   90: astore 20
    //   92: iload 19
    //   94: istore 21
    //   96: iinc 21 255
    //   99: iload 21
    //   101: ifge +19 -> 120
    //   104: aload 15
    //   106: aload 18
    //   108: aload 20
    //   110: invokestatic 620	kawa/lib/misc:lambda2$V	(Lgnu/mapping/Symbol;Lgnu/mapping/Symbol;[Ljava/lang/Object;)Z
    //   113: ifeq +21 -> 134
    //   116: getstatic 430	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   119: areturn
    //   120: aload 20
    //   122: iload 21
    //   124: aload_2
    //   125: iload 21
    //   127: iconst_2
    //   128: iadd
    //   129: aaload
    //   130: aastore
    //   131: goto -35 -> 96
    //   134: getstatic 315	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   137: areturn
    //   138: aload_2
    //   139: invokestatic 622	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   142: areturn
    //   143: aload_2
    //   144: iconst_0
    //   145: aaload
    //   146: astore 9
    //   148: aload_2
    //   149: arraylength
    //   150: iconst_1
    //   151: isub
    //   152: istore 10
    //   154: iload 10
    //   156: anewarray 512	java/lang/Object
    //   159: astore 11
    //   161: iload 10
    //   163: istore 12
    //   165: iinc 12 255
    //   168: iload 12
    //   170: ifge +11 -> 181
    //   173: aload 9
    //   175: aload 11
    //   177: invokestatic 514	kawa/lib/misc:error$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   180: areturn
    //   181: aload 11
    //   183: iload 12
    //   185: aload_2
    //   186: iload 12
    //   188: iconst_1
    //   189: iadd
    //   190: aaload
    //   191: aastore
    //   192: goto -27 -> 165
    //   195: aload_2
    //   196: iconst_0
    //   197: aaload
    //   198: astore_3
    //   199: aload_3
    //   200: checkcast 289	gnu/expr/GenericProc
    //   203: astore 5
    //   205: aload_2
    //   206: arraylength
    //   207: iconst_1
    //   208: isub
    //   209: istore 6
    //   211: iload 6
    //   213: anewarray 512	java/lang/Object
    //   216: astore 7
    //   218: iload 6
    //   220: istore 8
    //   222: iinc 8 255
    //   225: iload 8
    //   227: ifge +14 -> 241
    //   230: aload 5
    //   232: aload 7
    //   234: invokestatic 624	kawa/lib/misc:addProcedureProperties	(Lgnu/expr/GenericProc;[Ljava/lang/Object;)V
    //   237: getstatic 309	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   240: areturn
    //   241: aload 7
    //   243: iload 8
    //   245: aload_2
    //   246: iload 8
    //   248: iconst_1
    //   249: iadd
    //   250: aaload
    //   251: aastore
    //   252: goto -30 -> 222
    //   255: astore 14
    //   257: new 403	gnu/mapping/WrongType
    //   260: dup
    //   261: aload 14
    //   263: ldc_w 607
    //   266: iconst_1
    //   267: aload 13
    //   269: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   272: athrow
    //   273: astore 17
    //   275: new 403	gnu/mapping/WrongType
    //   278: dup
    //   279: aload 17
    //   281: ldc_w 607
    //   284: iconst_2
    //   285: aload 16
    //   287: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   290: athrow
    //   291: astore 4
    //   293: new 403	gnu/mapping/WrongType
    //   296: dup
    //   297: aload 4
    //   299: ldc 75
    //   301: iconst_1
    //   302: aload_3
    //   303: invokespecial 408	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   306: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   60	67	255	java/lang/ClassCastException
    //   72	79	273	java/lang/ClassCastException
    //   199	205	291	java/lang/ClassCastException
  }

  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match0(paramModuleMethod, paramCallContext);
    case 31:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 29:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 22:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 21:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 18:
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 6:
    case 7:
    case 16:
    case 17:
    case 19:
    case 21:
    case 22:
    case 23:
    case 24:
    case 25:
    case 26:
    case 28:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 29:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 27:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 20:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 18:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 15:
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
    case 13:
      if (!(paramObject instanceof Namespace))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 12:
      if (!(paramObject instanceof Namespace))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11:
      if (!(paramObject instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10:
      if (!(paramObject instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9:
      if (!(paramObject instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 8:
      if (!(paramObject instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5:
      if (!(paramObject instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 4:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3:
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 24:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 17:
      if (!(paramObject1 instanceof Environment))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 6:
    }
    if (!(paramObject1 instanceof Symbol))
      return -786431;
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof Symbol))
      return -786430;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 25:
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 26:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 24:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 23:
    }
    if (!(paramObject1 instanceof Procedure))
      return -786431;
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 32:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 28:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 16:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 7:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
    symbol$Eq$Qu = new GenericProc("symbol=?");
    GenericProc localGenericProc1 = symbol$Eq$Qu;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = lambda$Fn1;
    arrayOfObject1[1] = lambda$Fn2;
    localGenericProc1.setProperties(arrayOfObject1);
    procedure$Mnproperty = new GenericProc("procedure-property");
    GenericProc localGenericProc2 = procedure$Mnproperty;
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = Lit2;
    arrayOfObject2[1] = set$Mnprocedure$Mnproperty$Ex;
    arrayOfObject2[2] = procedure$Mnproperty$Fn3;
    localGenericProc2.setProperties(arrayOfObject2);
  }

  public class frame extends ModuleBody
  {
    final ModuleMethod lambda$Fn4;
    Object msg;

    public frame()
    {
      this$1 = new ModuleMethod(this, 2, null, 4097);
      this$1.setProperty("source-location", "misc.scm:104");
      this.lambda$Fn4 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 2)
      {
        lambda3(paramObject);
        return Values.empty;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    void lambda3(Object paramObject)
    {
      ports.display(this.msg, paramObject);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame0 extends ModuleBody
  {
    Object arg;
    final ModuleMethod lambda$Fn5;

    public frame0()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "misc.scm:107");
      this.lambda$Fn5 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 1)
      {
        lambda4(paramObject);
        return Values.empty;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    void lambda4(Object paramObject)
    {
      ports.write(this.arg, paramObject);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.misc
 * JD-Core Version:    0.6.2
 */