package gnu.commonlisp.lisp;

import gnu.commonlisp.lang.CommonLisp;
import gnu.commonlisp.lang.Lisp2;
import gnu.commonlisp.lang.Symbols;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.lists.SimpleVector;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.PropertyLocation;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class PrimOps extends ModuleBody
{
  public static final PrimOps $instance;
  static final SimpleSymbol Lit0;
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
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31 = (SimpleSymbol)new SimpleSymbol("functionp").readResolve();
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod apply;
  public static final ModuleMethod aref;
  public static final ModuleMethod arrayp;
  public static final ModuleMethod aset;
  public static final ModuleMethod boundp;
  public static final ModuleMethod car;
  public static final ModuleMethod cdr;
  public static final ModuleMethod char$Mnto$Mnstring;
  public static final ModuleMethod fillarray;
  public static final ModuleMethod fset;
  public static final ModuleMethod functionp;
  public static final ModuleMethod get;
  public static final ModuleMethod length;
  public static final ModuleMethod make$Mnstring;
  public static final ModuleMethod plist$Mnget;
  public static final ModuleMethod plist$Mnmember;
  public static final ModuleMethod plist$Mnput;
  public static final ModuleMethod plist$Mnremprop;
  public static final ModuleMethod put;
  public static final ModuleMethod set;
  public static final ModuleMethod setcar;
  public static final ModuleMethod setcdr;
  public static final ModuleMethod setplist;
  public static final ModuleMethod stringp;
  public static final ModuleMethod substring;
  public static final ModuleMethod symbol$Mnfunction;
  public static final ModuleMethod symbol$Mnname;
  public static final ModuleMethod symbol$Mnplist;
  public static final ModuleMethod symbol$Mnvalue;
  public static final ModuleMethod symbolp;

  static
  {
    Lit30 = (SimpleSymbol)new SimpleSymbol("char-to-string").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("substring").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("make-string").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("stringp").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("fillarray").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("aset").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("aref").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("arrayp").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("length").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("apply").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("fset").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("symbol-function").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("set").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("symbol-value").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("put").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("get").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("plist-member").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("plist-remprop").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("plist-put").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("plist-get").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("setplist").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("symbol-plist").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("symbol-name").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("symbolp").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("boundp").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("setcdr").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("setcar").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("cdr").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("car").readResolve();
    Lit1 = IntNum.make(0);
    Lit0 = (SimpleSymbol)new SimpleSymbol("t").readResolve();
    $instance = new PrimOps();
    PrimOps localPrimOps = $instance;
    car = new ModuleMethod(localPrimOps, 1, Lit2, 4097);
    cdr = new ModuleMethod(localPrimOps, 2, Lit3, 4097);
    setcar = new ModuleMethod(localPrimOps, 3, Lit4, 8194);
    setcdr = new ModuleMethod(localPrimOps, 4, Lit5, 8194);
    boundp = new ModuleMethod(localPrimOps, 5, Lit6, 4097);
    symbolp = new ModuleMethod(localPrimOps, 6, Lit7, 4097);
    symbol$Mnname = new ModuleMethod(localPrimOps, 7, Lit8, 4097);
    symbol$Mnplist = new ModuleMethod(localPrimOps, 8, Lit9, 4097);
    setplist = new ModuleMethod(localPrimOps, 9, Lit10, 8194);
    plist$Mnget = new ModuleMethod(localPrimOps, 10, Lit11, 12290);
    plist$Mnput = new ModuleMethod(localPrimOps, 12, Lit12, 12291);
    plist$Mnremprop = new ModuleMethod(localPrimOps, 13, Lit13, 8194);
    plist$Mnmember = new ModuleMethod(localPrimOps, 14, Lit14, 8194);
    get = new ModuleMethod(localPrimOps, 15, Lit15, 12290);
    put = new ModuleMethod(localPrimOps, 17, Lit16, 12291);
    symbol$Mnvalue = new ModuleMethod(localPrimOps, 18, Lit17, 4097);
    set = new ModuleMethod(localPrimOps, 19, Lit18, 8194);
    symbol$Mnfunction = new ModuleMethod(localPrimOps, 20, Lit19, 4097);
    fset = new ModuleMethod(localPrimOps, 21, Lit20, 8194);
    apply = new ModuleMethod(localPrimOps, 22, Lit21, -4095);
    length = new ModuleMethod(localPrimOps, 23, Lit22, 4097);
    arrayp = new ModuleMethod(localPrimOps, 24, Lit23, 4097);
    aref = new ModuleMethod(localPrimOps, 25, Lit24, 8194);
    aset = new ModuleMethod(localPrimOps, 26, Lit25, 12291);
    fillarray = new ModuleMethod(localPrimOps, 27, Lit26, 8194);
    stringp = new ModuleMethod(localPrimOps, 28, Lit27, 4097);
    make$Mnstring = new ModuleMethod(localPrimOps, 29, Lit28, 8194);
    substring = new ModuleMethod(localPrimOps, 30, Lit29, 12290);
    char$Mnto$Mnstring = new ModuleMethod(localPrimOps, 32, Lit30, 4097);
    functionp = new ModuleMethod(localPrimOps, 33, Lit31, 4097);
    $instance.run();
  }

  public PrimOps()
  {
    ModuleInfo.register(this);
  }

  public static Object apply(Object paramObject, Object[] paramArrayOfObject)
  {
    if (misc.isSymbol(paramObject));
    for (Procedure localProcedure = (Procedure)symbolFunction(paramObject); ; localProcedure = (Procedure)paramObject)
      return localProcedure.applyN(Apply.getArguments(paramArrayOfObject, 0, apply));
  }

  public static Object aref(SimpleVector paramSimpleVector, int paramInt)
  {
    return paramSimpleVector.get(paramInt);
  }

  public static boolean arrayp(Object paramObject)
  {
    return paramObject instanceof SimpleVector;
  }

  public static Object aset(SimpleVector paramSimpleVector, int paramInt, Object paramObject)
  {
    paramSimpleVector.set(paramInt, paramObject);
    return paramObject;
  }

  public static boolean boundp(Object paramObject)
  {
    return Symbols.isBound(paramObject);
  }

  public static Object car(Object paramObject)
  {
    if (paramObject == LList.Empty)
      return paramObject;
    return ((Pair)paramObject).getCar();
  }

  public static Object cdr(Object paramObject)
  {
    if (paramObject == LList.Empty)
      return paramObject;
    return ((Pair)paramObject).getCdr();
  }

  public static FString charToString(Object paramObject)
  {
    return new FString(1, CommonLisp.asChar(paramObject));
  }

  public static Object fillarray(SimpleVector paramSimpleVector, Object paramObject)
  {
    paramSimpleVector.fill(paramObject);
    return paramObject;
  }

  public static void fset(Object paramObject1, Object paramObject2)
  {
    Symbols.setFunctionBinding(Environment.getCurrent(), paramObject1, paramObject2);
  }

  public static boolean functionp(Object paramObject)
  {
    return paramObject instanceof Procedure;
  }

  public static Object get(Symbol paramSymbol, Object paramObject)
  {
    return get(paramSymbol, paramObject, LList.Empty);
  }

  public static Object get(Symbol paramSymbol, Object paramObject1, Object paramObject2)
  {
    return PropertyLocation.getProperty(paramSymbol, paramObject1, paramObject2);
  }

  public static int length(Sequence paramSequence)
  {
    return paramSequence.size();
  }

  public static FString makeString(int paramInt, Object paramObject)
  {
    return new FString(paramInt, CommonLisp.asChar(paramObject));
  }

  public static Object plistGet(Object paramObject1, Object paramObject2)
  {
    return plistGet(paramObject1, paramObject2, Boolean.FALSE);
  }

  public static Object plistGet(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return PropertyLocation.plistGet(paramObject1, paramObject2, paramObject3);
  }

  public static Object plistMember(Object paramObject1, Object paramObject2)
  {
    if (PropertyLocation.plistGet(paramObject1, paramObject2, Values.empty) == Values.empty)
      return LList.Empty;
    return Lit0;
  }

  public static Object plistPut(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return PropertyLocation.plistPut(paramObject1, paramObject2, paramObject3);
  }

  public static Object plistRemprop(Object paramObject1, Object paramObject2)
  {
    return PropertyLocation.plistRemove(paramObject1, paramObject2);
  }

  public static void put(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    PropertyLocation.putProperty(paramObject1, paramObject2, paramObject3);
  }

  public static void set(Object paramObject1, Object paramObject2)
  {
    Environment.getCurrent().put(Symbols.getSymbol(paramObject1), paramObject2);
  }

  public static void setcar(Pair paramPair, Object paramObject)
  {
    lists.setCar$Ex(paramPair, paramObject);
  }

  public static void setcdr(Pair paramPair, Object paramObject)
  {
    lists.setCdr$Ex(paramPair, paramObject);
  }

  public static Object setplist(Object paramObject1, Object paramObject2)
  {
    PropertyLocation.setPropertyList(paramObject1, paramObject2);
    return paramObject2;
  }

  public static boolean stringp(Object paramObject)
  {
    return paramObject instanceof CharSequence;
  }

  public static FString substring(CharSequence paramCharSequence, Object paramObject)
  {
    return substring(paramCharSequence, paramObject, LList.Empty);
  }

  public static FString substring(CharSequence paramCharSequence, Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == LList.Empty)
      paramObject2 = Integer.valueOf(strings.stringLength(paramCharSequence));
    if (Scheme.numLss.apply2(paramObject2, Lit1) != Boolean.FALSE);
    for (Object localObject = AddOp.$Mn.apply2(Integer.valueOf(strings.stringLength(paramCharSequence)), paramObject2); ; localObject = paramObject2)
    {
      if (Scheme.numLss.apply2(paramObject1, Lit1) != Boolean.FALSE)
        paramObject1 = AddOp.$Mn.apply2(Integer.valueOf(strings.stringLength(paramCharSequence)), paramObject1);
      return new FString(paramCharSequence, ((Number)paramObject1).intValue(), ((Number)AddOp.$Mn.apply2(localObject, paramObject1)).intValue());
    }
  }

  public static Object symbolFunction(Object paramObject)
  {
    return Symbols.getFunctionBinding(paramObject);
  }

  public static Object symbolName(Object paramObject)
  {
    return Symbols.getPrintName(paramObject);
  }

  public static Object symbolPlist(Object paramObject)
  {
    return PropertyLocation.getPropertyList(paramObject);
  }

  public static Object symbolValue(Object paramObject)
  {
    return Environment.getCurrent().get(Symbols.getSymbol(paramObject));
  }

  public static boolean symbolp(Object paramObject)
  {
    return Symbols.isSymbol(paramObject);
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply1(paramModuleMethod, paramObject);
    case 1:
      return car(paramObject);
    case 2:
      return cdr(paramObject);
    case 5:
      if (boundp(paramObject))
        return Lisp2.TRUE;
      return LList.Empty;
    case 6:
      if (symbolp(paramObject))
        return Lisp2.TRUE;
      return LList.Empty;
    case 7:
      return symbolName(paramObject);
    case 8:
      return symbolPlist(paramObject);
    case 18:
      return symbolValue(paramObject);
    case 20:
      return symbolFunction(paramObject);
    case 23:
    case 24:
    case 28:
    case 32:
    case 33:
    }
    try
    {
      Sequence localSequence = (Sequence)paramObject;
      return Integer.valueOf(length(localSequence));
      if (arrayp(paramObject))
        return Lisp2.TRUE;
      return LList.Empty;
      if (stringp(paramObject))
        return Lisp2.TRUE;
      return LList.Empty;
      return charToString(paramObject);
      if (functionp(paramObject))
        return Lisp2.TRUE;
      return LList.Empty;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "length", 1, paramObject);
    }
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 486	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+128 -> 132, 3:+136->140, 4:+152->156, 5:+128->132, 6:+128->132, 7:+128->132, 8:+128->132, 9:+168->172, 10:+174->178, 11:+128->132, 12:+128->132, 13:+180->184, 14:+186->190, 15:+192->196, 16:+128->132, 17:+128->132, 18:+128->132, 19:+205->209, 20:+128->132, 21:+214->218, 22:+128->132, 23:+128->132, 24:+128->132, 25:+223->227, 26:+128->132, 27:+246->250, 28:+128->132, 29:+259->263, 30:+275->279
    //   133: aload_1
    //   134: aload_2
    //   135: aload_3
    //   136: invokespecial 526	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: areturn
    //   140: aload_2
    //   141: checkcast 320	gnu/lists/Pair
    //   144: astore 19
    //   146: aload 19
    //   148: aload_3
    //   149: invokestatic 528	gnu/commonlisp/lisp/PrimOps:setcar	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   152: getstatic 391	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   155: areturn
    //   156: aload_2
    //   157: checkcast 320	gnu/lists/Pair
    //   160: astore 17
    //   162: aload 17
    //   164: aload_3
    //   165: invokestatic 530	gnu/commonlisp/lisp/PrimOps:setcdr	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   168: getstatic 391	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   171: areturn
    //   172: aload_2
    //   173: aload_3
    //   174: invokestatic 532	gnu/commonlisp/lisp/PrimOps:setplist	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   177: areturn
    //   178: aload_2
    //   179: aload_3
    //   180: invokestatic 534	gnu/commonlisp/lisp/PrimOps:plistGet	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: areturn
    //   184: aload_2
    //   185: aload_3
    //   186: invokestatic 536	gnu/commonlisp/lisp/PrimOps:plistRemprop	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   189: areturn
    //   190: aload_2
    //   191: aload_3
    //   192: invokestatic 538	gnu/commonlisp/lisp/PrimOps:plistMember	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   195: areturn
    //   196: aload_2
    //   197: checkcast 540	gnu/mapping/Symbol
    //   200: astore 15
    //   202: aload 15
    //   204: aload_3
    //   205: invokestatic 542	gnu/commonlisp/lisp/PrimOps:get	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;
    //   208: areturn
    //   209: aload_2
    //   210: aload_3
    //   211: invokestatic 544	gnu/commonlisp/lisp/PrimOps:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   214: getstatic 391	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   217: areturn
    //   218: aload_2
    //   219: aload_3
    //   220: invokestatic 546	gnu/commonlisp/lisp/PrimOps:fset	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   223: getstatic 391	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   226: areturn
    //   227: aload_2
    //   228: checkcast 300	gnu/lists/SimpleVector
    //   231: astore 11
    //   233: aload_3
    //   234: checkcast 456	java/lang/Number
    //   237: invokevirtual 459	java/lang/Number:intValue	()I
    //   240: istore 13
    //   242: aload 11
    //   244: iload 13
    //   246: invokestatic 548	gnu/commonlisp/lisp/PrimOps:aref	(Lgnu/lists/SimpleVector;I)Ljava/lang/Object;
    //   249: areturn
    //   250: aload_2
    //   251: checkcast 300	gnu/lists/SimpleVector
    //   254: astore 9
    //   256: aload 9
    //   258: aload_3
    //   259: invokestatic 550	gnu/commonlisp/lisp/PrimOps:fillarray	(Lgnu/lists/SimpleVector;Ljava/lang/Object;)Ljava/lang/Object;
    //   262: areturn
    //   263: aload_2
    //   264: checkcast 456	java/lang/Number
    //   267: invokevirtual 459	java/lang/Number:intValue	()I
    //   270: istore 7
    //   272: iload 7
    //   274: aload_3
    //   275: invokestatic 552	gnu/commonlisp/lisp/PrimOps:makeString	(ILjava/lang/Object;)Lgnu/lists/FString;
    //   278: areturn
    //   279: aload_2
    //   280: checkcast 423	java/lang/CharSequence
    //   283: astore 5
    //   285: aload 5
    //   287: aload_3
    //   288: invokestatic 554	gnu/commonlisp/lisp/PrimOps:substring	(Ljava/lang/CharSequence;Ljava/lang/Object;)Lgnu/lists/FString;
    //   291: areturn
    //   292: astore 18
    //   294: new 520	gnu/mapping/WrongType
    //   297: dup
    //   298: aload 18
    //   300: ldc 175
    //   302: iconst_1
    //   303: aload_2
    //   304: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   307: athrow
    //   308: astore 16
    //   310: new 520	gnu/mapping/WrongType
    //   313: dup
    //   314: aload 16
    //   316: ldc 172
    //   318: iconst_1
    //   319: aload_2
    //   320: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   323: athrow
    //   324: astore 14
    //   326: new 520	gnu/mapping/WrongType
    //   329: dup
    //   330: aload 14
    //   332: ldc 136
    //   334: iconst_1
    //   335: aload_2
    //   336: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   339: athrow
    //   340: astore 10
    //   342: new 520	gnu/mapping/WrongType
    //   345: dup
    //   346: aload 10
    //   348: ldc 107
    //   350: iconst_1
    //   351: aload_2
    //   352: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   355: athrow
    //   356: astore 12
    //   358: new 520	gnu/mapping/WrongType
    //   361: dup
    //   362: aload 12
    //   364: ldc 107
    //   366: iconst_2
    //   367: aload_3
    //   368: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   371: athrow
    //   372: astore 8
    //   374: new 520	gnu/mapping/WrongType
    //   377: dup
    //   378: aload 8
    //   380: ldc 101
    //   382: iconst_1
    //   383: aload_2
    //   384: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   387: athrow
    //   388: astore 6
    //   390: new 520	gnu/mapping/WrongType
    //   393: dup
    //   394: aload 6
    //   396: ldc 95
    //   398: iconst_1
    //   399: aload_2
    //   400: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   403: athrow
    //   404: astore 4
    //   406: new 520	gnu/mapping/WrongType
    //   409: dup
    //   410: aload 4
    //   412: ldc 91
    //   414: iconst_1
    //   415: aload_2
    //   416: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   419: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   140	146	292	java/lang/ClassCastException
    //   156	162	308	java/lang/ClassCastException
    //   196	202	324	java/lang/ClassCastException
    //   227	233	340	java/lang/ClassCastException
    //   233	242	356	java/lang/ClassCastException
    //   250	256	372	java/lang/ClassCastException
    //   263	272	388	java/lang/ClassCastException
    //   279	285	404	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 486	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+60->64, 10:+70->74, 12:+78->82, 15:+86->90, 17:+101->105, 26:+112->116, 30:+137->141
    //   65: aload_1
    //   66: aload_2
    //   67: aload_3
    //   68: aload 4
    //   70: invokespecial 558	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: areturn
    //   74: aload_2
    //   75: aload_3
    //   76: aload 4
    //   78: invokestatic 383	gnu/commonlisp/lisp/PrimOps:plistGet	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: areturn
    //   82: aload_2
    //   83: aload_3
    //   84: aload 4
    //   86: invokestatic 559	gnu/commonlisp/lisp/PrimOps:plistPut	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: areturn
    //   90: aload_2
    //   91: checkcast 540	gnu/mapping/Symbol
    //   94: astore 12
    //   96: aload 12
    //   98: aload_3
    //   99: aload 4
    //   101: invokestatic 358	gnu/commonlisp/lisp/PrimOps:get	(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   104: areturn
    //   105: aload_2
    //   106: aload_3
    //   107: aload 4
    //   109: invokestatic 561	gnu/commonlisp/lisp/PrimOps:put	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   112: getstatic 391	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   115: areturn
    //   116: aload_2
    //   117: checkcast 300	gnu/lists/SimpleVector
    //   120: astore 8
    //   122: aload_3
    //   123: checkcast 456	java/lang/Number
    //   126: invokevirtual 459	java/lang/Number:intValue	()I
    //   129: istore 10
    //   131: aload 8
    //   133: iload 10
    //   135: aload 4
    //   137: invokestatic 563	gnu/commonlisp/lisp/PrimOps:aset	(Lgnu/lists/SimpleVector;ILjava/lang/Object;)Ljava/lang/Object;
    //   140: areturn
    //   141: aload_2
    //   142: checkcast 423	java/lang/CharSequence
    //   145: astore 6
    //   147: aload 6
    //   149: aload_3
    //   150: aload 4
    //   152: invokestatic 427	gnu/commonlisp/lisp/PrimOps:substring	(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
    //   155: areturn
    //   156: astore 11
    //   158: new 520	gnu/mapping/WrongType
    //   161: dup
    //   162: aload 11
    //   164: ldc 136
    //   166: iconst_1
    //   167: aload_2
    //   168: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    //   172: astore 7
    //   174: new 520	gnu/mapping/WrongType
    //   177: dup
    //   178: aload 7
    //   180: ldc 104
    //   182: iconst_1
    //   183: aload_2
    //   184: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   187: athrow
    //   188: astore 9
    //   190: new 520	gnu/mapping/WrongType
    //   193: dup
    //   194: aload 9
    //   196: ldc 104
    //   198: iconst_2
    //   199: aload_3
    //   200: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   203: athrow
    //   204: astore 5
    //   206: new 520	gnu/mapping/WrongType
    //   209: dup
    //   210: aload 5
    //   212: ldc 91
    //   214: iconst_1
    //   215: aload_2
    //   216: invokespecial 523	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   219: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   90	96	156	java/lang/ClassCastException
    //   116	122	172	java/lang/ClassCastException
    //   122	131	188	java/lang/ClassCastException
    //   141	147	204	java/lang/ClassCastException
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    if (paramModuleMethod.selector == 22)
    {
      Object localObject = paramArrayOfObject[0];
      int i = paramArrayOfObject.length - 1;
      Object[] arrayOfObject = new Object[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          return apply(localObject, arrayOfObject);
        arrayOfObject[j] = paramArrayOfObject[(j + 1)];
      }
    }
    return super.applyN(paramModuleMethod, paramArrayOfObject);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 33:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 32:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28:
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
      if (!(paramObject instanceof Sequence))
        return -786431;
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
    case 6:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 1:
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
    case 5:
    case 6:
    case 7:
    case 8:
    case 11:
    case 12:
    case 16:
    case 17:
    case 18:
    case 20:
    case 22:
    case 23:
    case 24:
    case 26:
    case 28:
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 30:
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 29:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 27:
      if (!(paramObject1 instanceof SimpleVector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 25:
      if (!(paramObject1 instanceof SimpleVector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 21:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 19:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 15:
      if (!(paramObject1 instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 14:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 13:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 10:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 9:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 4:
      if (!(paramObject1 instanceof Pair))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 3:
    }
    if (!(paramObject1 instanceof Pair))
      return -786431;
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 30:
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    case 26:
      if (!(paramObject1 instanceof SimpleVector))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 17:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 15:
      if (!(paramObject1 instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 12:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 10:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 22)
    {
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
    return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lisp.PrimOps
 * JD-Core Version:    0.6.2
 */