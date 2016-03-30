package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.IsEq;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;
import kawa.standard.append;

public class conditions extends ModuleBody
{
  public static Object $Amcondition;
  public static Object $Amerror;
  public static Object $Ammessage;
  public static Object $Amserious;
  static final Class $Lscondition$Mntype$Gr;
  public static final Class $Prvt$$Lscondition$Gr;
  public static final ModuleMethod $Prvt$type$Mnfield$Mnalist$Mn$Grcondition;
  public static final conditions $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SyntaxRules Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SyntaxRules Lit19;
  static final PairWithPosition Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22 = (SimpleSymbol)new SimpleSymbol("thing").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SyntaxRules Lit9;
  public static final Macro condition;
  public static final ModuleMethod condition$Mnhas$Mntype$Qu;
  public static final ModuleMethod condition$Mnref;
  static final Macro condition$Mntype$Mnfield$Mnalist;
  public static final ModuleMethod condition$Mntype$Qu;
  public static final ModuleMethod condition$Qu;
  public static final Macro define$Mncondition$Mntype;
  public static final ModuleMethod extract$Mncondition;
  public static final ModuleMethod make$Mncompound$Mncondition;
  public static final ModuleMethod make$Mncondition;
  public static final ModuleMethod make$Mncondition$Mntype;

  static
  {
    Lit21 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("type-field-alist->condition").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("condition").readResolve();
    Lit18 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("", new Object[0], 3);
    Object[] arrayOfObject2 = new Object[4];
    arrayOfObject2[0] = Lit20;
    arrayOfObject2[1] = ((SimpleSymbol)new SimpleSymbol("list").readResolve());
    arrayOfObject2[2] = ((SimpleSymbol)new SimpleSymbol("cons").readResolve());
    arrayOfObject2[3] = Lit21;
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\003\005\005", "\021\030\004\b\021\030\f\b\005\021\030\024\t\003\b\021\030\f\b\r\021\030\024)\021\030\034\b\013\b\023", arrayOfObject2, 2);
    Lit19 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 3);
    Lit17 = (SimpleSymbol)new SimpleSymbol("extract-condition").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("make-compound-condition").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("condition-ref").readResolve();
    Object[] arrayOfObject3 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("condition-type-field-alist").readResolve();
    Lit13 = localSimpleSymbol2;
    arrayOfObject3[0] = localSimpleSymbol2;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject4 = new Object[3];
    arrayOfObject4[0] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("$lookup$").readResolve(), Pair.make((SimpleSymbol)new SimpleSymbol("*").readResolve(), Pair.make(Pair.make((SimpleSymbol)new SimpleSymbol("quasiquote").readResolve(), Pair.make((SimpleSymbol)new SimpleSymbol(".type-field-alist").readResolve(), LList.Empty)), LList.Empty)), "conditions.scm", 581639);
    arrayOfObject4[1] = ((SimpleSymbol)new SimpleSymbol("as").readResolve());
    arrayOfObject4[2] = ((SimpleSymbol)new SimpleSymbol("<condition>").readResolve());
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\001", "\021\030\004\b\021\030\f\021\030\024\b\003", arrayOfObject4, 0);
    Lit14 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 1);
    Lit12 = (SimpleSymbol)new SimpleSymbol("condition-has-type?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("make-condition").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("condition?").readResolve();
    Object[] arrayOfObject5 = new Object[1];
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("define-condition-type").readResolve();
    Lit8 = localSimpleSymbol3;
    arrayOfObject5[0] = localSimpleSymbol3;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007\f\017\f\027-\f\037\f'\b\030\020\b", new Object[0], 5);
    Object[] arrayOfObject6 = new Object[13];
    arrayOfObject6[0] = ((SimpleSymbol)new SimpleSymbol("begin").readResolve());
    arrayOfObject6[1] = ((SimpleSymbol)new SimpleSymbol("define").readResolve());
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol("make-condition-type").readResolve();
    Lit7 = localSimpleSymbol4;
    arrayOfObject6[2] = localSimpleSymbol4;
    arrayOfObject6[3] = Lit21;
    arrayOfObject6[4] = PairWithPosition.make(Lit22, LList.Empty, "conditions.scm", 327708);
    arrayOfObject6[5] = ((SimpleSymbol)new SimpleSymbol("and").readResolve());
    arrayOfObject6[6] = PairWithPosition.make(Lit10, PairWithPosition.make(Lit22, LList.Empty, "conditions.scm", 331803), "conditions.scm", 331791);
    arrayOfObject6[7] = Lit12;
    arrayOfObject6[8] = Lit22;
    arrayOfObject6[9] = PairWithPosition.make(Lit18, LList.Empty, "conditions.scm", 339996);
    arrayOfObject6[10] = Lit15;
    arrayOfObject6[11] = Lit17;
    arrayOfObject6[12] = Lit18;
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "\001\001\001\003\003", "\021\030\004É\021\030\f\t\003\b\021\030\024)\021\030\034\b\003\t\013\b\021\030\034\b\b\035\033Á\021\030\f!\t\023\030$\b\021\030,\021\0304\b\021\030<\021\030D\b\003\b%\021\030\f!\t#\030L\b\021\030TA\021\030\\\021\030d\b\003\b\021\030\034\b\033", arrayOfObject6, 1);
    Lit9 = new SyntaxRules(arrayOfObject5, arrayOfSyntaxRule3, 5);
    Lit6 = (SimpleSymbol)new SimpleSymbol("condition-type?").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("message").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("&error").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("&serious").readResolve();
    Lit2 = PairWithPosition.make(Lit5, LList.Empty, "conditions.scm", 925699);
    Lit1 = (SimpleSymbol)new SimpleSymbol("&message").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("&condition").readResolve();
    $instance = new conditions();
    $Lscondition$Mntype$Gr = condition.Mntype.class;
    conditions localconditions = $instance;
    condition$Mntype$Qu = new ModuleMethod(localconditions, 2, Lit6, 4097);
    make$Mncondition$Mntype = new ModuleMethod(localconditions, 3, Lit7, 12291);
    define$Mncondition$Mntype = Macro.make(Lit8, Lit9, $instance);
    $Prvt$$Lscondition$Gr = condition.class;
    condition$Qu = new ModuleMethod(localconditions, 4, Lit10, 4097);
    make$Mncondition = new ModuleMethod(localconditions, 5, Lit11, -4095);
    condition$Mnhas$Mntype$Qu = new ModuleMethod(localconditions, 6, Lit12, 8194);
    condition$Mntype$Mnfield$Mnalist = Macro.make(Lit13, Lit14, $instance);
    condition$Mnref = new ModuleMethod(localconditions, 7, Lit15, 8194);
    make$Mncompound$Mncondition = new ModuleMethod(localconditions, 8, Lit16, -4095);
    extract$Mncondition = new ModuleMethod(localconditions, 9, Lit17, 8194);
    condition = Macro.make(Lit18, Lit19, $instance);
    $Prvt$type$Mnfield$Mnalist$Mn$Grcondition = new ModuleMethod(localconditions, 10, Lit20, 4097);
    $instance.run();
  }

  public conditions()
  {
    ModuleInfo.register(this);
  }

  // ERROR //
  static Object checkConditionTypeFieldAlist(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore_1
    //   2: aload_1
    //   3: invokestatic 297	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   6: ifne +265 -> 271
    //   9: getstatic 301	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   12: aload_1
    //   13: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: astore_2
    //   17: getstatic 301	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   20: aload_2
    //   21: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: astore_3
    //   25: aload_3
    //   26: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   29: astore 5
    //   31: getstatic 309	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   34: aload_2
    //   35: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: astore 6
    //   40: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   43: astore 7
    //   45: aload 6
    //   47: astore 8
    //   49: aload 7
    //   51: astore 9
    //   53: aload 8
    //   55: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   58: if_acmpne +55 -> 113
    //   61: aload 9
    //   63: invokestatic 313	gnu/lists/LList:reverseInPlace	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   66: astore 13
    //   68: aload 5
    //   70: getfield 316	gnu/kawa/slib/condition$Mntype:all$Mnfields	Ljava/lang/Object;
    //   73: astore 14
    //   75: getstatic 322	kawa/standard/Scheme:isEq	Lgnu/kawa/functions/IsEq;
    //   78: aload 14
    //   80: iconst_1
    //   81: anewarray 80	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload 13
    //   88: aastore
    //   89: invokestatic 328	gnu/kawa/slib/srfi1:lsetDifference$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore 15
    //   94: aload 15
    //   96: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   99: if_acmpne +53 -> 152
    //   102: getstatic 309	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   105: aload_1
    //   106: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: astore_1
    //   110: goto -108 -> 2
    //   113: aload 8
    //   115: checkcast 144	gnu/lists/Pair
    //   118: astore 11
    //   120: aload 11
    //   122: invokevirtual 331	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   125: astore 12
    //   127: getstatic 301	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   130: aload 11
    //   132: invokevirtual 334	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   135: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: aload 9
    //   140: invokestatic 148	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   143: astore 9
    //   145: aload 12
    //   147: astore 8
    //   149: goto -96 -> 53
    //   152: aload 15
    //   154: checkcast 144	gnu/lists/Pair
    //   157: astore 17
    //   159: aload 17
    //   161: invokevirtual 334	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   164: astore 18
    //   166: aload 5
    //   168: aload 18
    //   170: invokestatic 338	gnu/kawa/slib/conditions:conditionTypeFieldSupertype	(Lgnu/kawa/slib/condition$Mntype;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: astore 19
    //   175: aload_0
    //   176: astore 20
    //   178: getstatic 301	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   181: getstatic 301	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   184: aload 20
    //   186: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   189: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   192: astore 21
    //   194: aload 21
    //   196: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   199: astore 23
    //   201: aload 19
    //   203: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   206: astore 25
    //   208: aload 23
    //   210: aload 25
    //   212: invokestatic 342	gnu/kawa/slib/conditions:isConditionSubtype	(Lgnu/kawa/slib/condition$Mntype;Lgnu/kawa/slib/condition$Mntype;)Z
    //   215: istore 26
    //   217: iload 26
    //   219: ifeq +39 -> 258
    //   222: iload 26
    //   224: ifne +24 -> 248
    //   227: ldc_w 344
    //   230: iconst_2
    //   231: anewarray 80	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 5
    //   238: aastore
    //   239: dup
    //   240: iconst_1
    //   241: aload 18
    //   243: aastore
    //   244: invokestatic 350	kawa/lib/misc:error$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   247: pop
    //   248: aload 17
    //   250: invokevirtual 331	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   253: astore 15
    //   255: goto -161 -> 94
    //   258: getstatic 309	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   261: aload 20
    //   263: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   266: astore 20
    //   268: goto -90 -> 178
    //   271: getstatic 356	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   274: areturn
    //   275: astore 4
    //   277: new 358	gnu/mapping/WrongType
    //   280: dup
    //   281: aload 4
    //   283: ldc_w 360
    //   286: bipush 254
    //   288: aload_3
    //   289: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   292: athrow
    //   293: astore 10
    //   295: new 358	gnu/mapping/WrongType
    //   298: dup
    //   299: aload 10
    //   301: ldc_w 365
    //   304: bipush 254
    //   306: aload 8
    //   308: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    //   312: astore 16
    //   314: new 358	gnu/mapping/WrongType
    //   317: dup
    //   318: aload 16
    //   320: ldc_w 365
    //   323: bipush 254
    //   325: aload 15
    //   327: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   330: athrow
    //   331: astore 22
    //   333: new 358	gnu/mapping/WrongType
    //   336: dup
    //   337: aload 22
    //   339: ldc_w 367
    //   342: iconst_0
    //   343: aload 21
    //   345: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   348: athrow
    //   349: astore 24
    //   351: new 358	gnu/mapping/WrongType
    //   354: dup
    //   355: aload 24
    //   357: ldc_w 367
    //   360: iconst_1
    //   361: aload 19
    //   363: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   366: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   25	31	275	java/lang/ClassCastException
    //   113	120	293	java/lang/ClassCastException
    //   152	159	312	java/lang/ClassCastException
    //   194	201	331	java/lang/ClassCastException
    //   201	208	349	java/lang/ClassCastException
  }

  // ERROR //
  static Object conditionMessage(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 257	gnu/kawa/slib/condition
    //   4: astore_2
    //   5: getstatic 370	gnu/kawa/slib/conditions:$Ammessage	Ljava/lang/Object;
    //   8: astore_3
    //   9: aload_3
    //   10: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   13: astore 5
    //   15: aload_2
    //   16: aload 5
    //   18: invokestatic 374	gnu/kawa/slib/conditions:extractCondition	(Lgnu/kawa/slib/condition;Lgnu/kawa/slib/condition$Mntype;)Lgnu/kawa/slib/condition;
    //   21: getstatic 212	gnu/kawa/slib/conditions:Lit5	Lgnu/mapping/SimpleSymbol;
    //   24: invokestatic 378	gnu/kawa/slib/conditions:conditionRef	(Lgnu/kawa/slib/condition;Ljava/lang/Object;)Ljava/lang/Object;
    //   27: areturn
    //   28: astore_1
    //   29: new 358	gnu/mapping/WrongType
    //   32: dup
    //   33: aload_1
    //   34: ldc 112
    //   36: iconst_0
    //   37: aload_0
    //   38: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   41: athrow
    //   42: astore 4
    //   44: new 358	gnu/mapping/WrongType
    //   47: dup
    //   48: aload 4
    //   50: ldc 112
    //   52: iconst_1
    //   53: aload_3
    //   54: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   57: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	28	java/lang/ClassCastException
    //   9	15	42	java/lang/ClassCastException
  }

  public static Object conditionRef(condition paramcondition, Object paramObject)
  {
    return typeFieldAlistRef(paramcondition.type$Mnfield$Mnalist, paramObject);
  }

  static Object conditionTypeFieldSupertype(condition.Mntype paramMntype, Object paramObject)
  {
    while (true)
    {
      if (paramMntype == Boolean.FALSE)
        return Boolean.FALSE;
      if (lists.memq(paramObject, paramMntype.fields) != Boolean.FALSE)
        return paramMntype;
      paramMntype = (condition.Mntype)paramMntype.supertype;
    }
  }

  static Object conditionTypes(Object paramObject)
  {
    Object localObject1 = ((condition)paramObject).type$Mnfield$Mnalist;
    Object localObject2 = LList.Empty;
    while (true)
    {
      if (localObject1 == LList.Empty)
        return LList.reverseInPlace(localObject2);
      try
      {
        Pair localPair = (Pair)localObject1;
        Object localObject3 = localPair.getCdr();
        localObject2 = Pair.make(lists.car.apply1(localPair.getCar()), localObject2);
        localObject1 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject1);
      }
    }
  }

  public static condition extractCondition(condition paramcondition, condition.Mntype paramMntype)
  {
    frame localframe = new frame();
    localframe.type = paramMntype;
    Object localObject1 = srfi1.find(localframe.lambda$Fn1, paramcondition.type$Mnfield$Mnalist);
    if (localObject1 == Boolean.FALSE)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramcondition;
      arrayOfObject[1] = localframe.type;
      misc.error$V("extract-condition: invalid condition type", arrayOfObject);
    }
    condition.Mntype localMntype = localframe.type;
    Object localObject2 = localframe.type.all$Mnfields;
    Object localObject3 = LList.Empty;
    while (true)
    {
      if (localObject2 == LList.Empty)
        return new condition(LList.list1(lists.cons(localMntype, LList.reverseInPlace(localObject3))));
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject4 = localPair.getCdr();
        localObject3 = Pair.make(lists.assq(localPair.getCar(), lists.cdr.apply1(localObject1)), localObject3);
        localObject2 = localObject4;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }

  public static boolean isCondition(Object paramObject)
  {
    return paramObject instanceof condition;
  }

  public static boolean isConditionHasType(Object paramObject, condition.Mntype paramMntype)
  {
    Object localObject1 = conditionTypes(paramObject);
    while (true)
    {
      Object localObject2 = lists.car.apply1(localObject1);
      try
      {
        condition.Mntype localMntype = (condition.Mntype)localObject2;
        boolean bool = isConditionSubtype(localMntype, paramMntype);
        if (bool)
          return bool;
        localObject1 = lists.cdr.apply1(localObject1);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "condition-subtype?", 0, localObject2);
      }
    }
  }

  static boolean isConditionSubtype(condition.Mntype paramMntype1, condition.Mntype paramMntype2)
  {
    while (true)
    {
      if (paramMntype1 == Boolean.FALSE)
        return false;
      if (paramMntype1 == paramMntype2)
        return true;
      paramMntype1 = (condition.Mntype)paramMntype1.supertype;
    }
  }

  public static boolean isConditionType(Object paramObject)
  {
    return paramObject instanceof condition.Mntype;
  }

  static boolean isError(Object paramObject)
  {
    boolean bool = isCondition(paramObject);
    Object localObject;
    if (bool)
      localObject = $Amerror;
    try
    {
      condition.Mntype localMntype = (condition.Mntype)localObject;
      return isConditionHasType(paramObject, localMntype);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "condition-has-type?", 1, localObject);
    }
  }

  static boolean isMessageCondition(Object paramObject)
  {
    boolean bool = isCondition(paramObject);
    Object localObject;
    if (bool)
      localObject = $Ammessage;
    try
    {
      condition.Mntype localMntype = (condition.Mntype)localObject;
      return isConditionHasType(paramObject, localMntype);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "condition-has-type?", 1, localObject);
    }
  }

  static boolean isSeriousCondition(Object paramObject)
  {
    boolean bool = isCondition(paramObject);
    Object localObject;
    if (bool)
      localObject = $Amserious;
    try
    {
      condition.Mntype localMntype = (condition.Mntype)localObject;
      return isConditionHasType(paramObject, localMntype);
      return bool;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "condition-has-type?", 1, localObject);
    }
  }

  public static Object lambda1label(Object paramObject)
  {
    if (lists.isNull(paramObject))
      return LList.Empty;
    return lists.cons(lists.cons(lists.car.apply1(paramObject), lists.cadr.apply1(paramObject)), lambda1label(lists.cddr.apply1(paramObject)));
  }

  public static condition makeCompoundCondition$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    Apply localApply = Scheme.apply;
    append localappend = append.append;
    Object localObject1 = lists.cons(paramObject, localLList);
    Object localObject2 = LList.Empty;
    while (true)
    {
      if (localObject1 == LList.Empty)
        return new condition(localApply.apply2(localappend, LList.reverseInPlace(localObject2)));
      try
      {
        Pair localPair = (Pair)localObject1;
        Object localObject3 = localPair.getCdr();
        localObject2 = Pair.make(Scheme.applyToArgs.apply2(condition$Mntype$Mnfield$Mnalist, localPair.getCar()), localObject2);
        localObject1 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject1);
      }
    }
  }

  public static condition makeCondition$V(condition.Mntype paramMntype, Object[] paramArrayOfObject)
  {
    Object localObject1 = lambda1label(LList.makeList(paramArrayOfObject, 0));
    IsEq localIsEq = Scheme.isEq;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramMntype.all$Mnfields;
    Object localObject2 = LList.Empty;
    Object localObject3 = localObject1;
    while (true)
    {
      if (localObject3 == LList.Empty)
      {
        arrayOfObject[1] = LList.reverseInPlace(localObject2);
        if (srfi1.lset$Eq$V(localIsEq, arrayOfObject) == Boolean.FALSE)
          misc.error$V("condition fields don't match condition type", new Object[0]);
        return new condition(LList.list1(lists.cons(paramMntype, localObject1)));
      }
      try
      {
        Pair localPair = (Pair)localObject3;
        Object localObject4 = localPair.getCdr();
        localObject2 = Pair.make(lists.car.apply1(localPair.getCar()), localObject2);
        localObject3 = localObject4;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject3);
      }
    }
  }

  public static condition.Mntype makeConditionType(Symbol paramSymbol, condition.Mntype paramMntype, Object paramObject)
  {
    if (!lists.isNull(srfi1.lsetIntersection$V(Scheme.isEq, paramMntype.all$Mnfields, new Object[] { paramObject })))
      misc.error$V("duplicate field name", new Object[0]);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramMntype.all$Mnfields;
    arrayOfObject[1] = paramObject;
    return new condition.Mntype(paramSymbol, paramMntype, paramObject, append.append$V(arrayOfObject));
  }

  // ERROR //
  public static condition typeFieldAlist$To$Condition(Object paramObject)
  {
    // Byte code:
    //   0: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   3: astore_1
    //   4: aload_0
    //   5: astore_2
    //   6: aload_1
    //   7: astore_3
    //   8: aload_2
    //   9: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   12: if_acmpne +15 -> 27
    //   15: new 257	gnu/kawa/slib/condition
    //   18: dup
    //   19: aload_3
    //   20: invokestatic 313	gnu/lists/LList:reverseInPlace	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   23: invokespecial 423	gnu/kawa/slib/condition:<init>	(Ljava/lang/Object;)V
    //   26: areturn
    //   27: aload_2
    //   28: checkcast 144	gnu/lists/Pair
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 331	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   38: astore 6
    //   40: aload 5
    //   42: invokevirtual 334	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   45: astore 7
    //   47: getstatic 301	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   50: aload 7
    //   52: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: astore 8
    //   57: getstatic 301	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   60: aload 7
    //   62: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   68: getfield 316	gnu/kawa/slib/condition$Mntype:all$Mnfields	Ljava/lang/Object;
    //   71: astore 9
    //   73: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   76: astore 10
    //   78: aload 9
    //   80: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   83: if_acmpne +24 -> 107
    //   86: aload 8
    //   88: aload 10
    //   90: invokestatic 313	gnu/lists/LList:reverseInPlace	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   93: invokestatic 417	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   96: aload_3
    //   97: invokestatic 148	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   100: astore_3
    //   101: aload 6
    //   103: astore_2
    //   104: goto -96 -> 8
    //   107: aload 9
    //   109: checkcast 144	gnu/lists/Pair
    //   112: astore 12
    //   114: aload 12
    //   116: invokevirtual 331	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   119: astore 13
    //   121: aload 12
    //   123: invokevirtual 334	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   126: astore 14
    //   128: aload 14
    //   130: getstatic 309	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   133: aload 7
    //   135: invokevirtual 306	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: invokestatic 426	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   141: astore 15
    //   143: aload 15
    //   145: getstatic 391	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   148: if_acmpeq +23 -> 171
    //   151: aload 15
    //   153: astore 16
    //   155: aload 16
    //   157: aload 10
    //   159: invokestatic 148	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   162: astore 10
    //   164: aload 13
    //   166: astore 9
    //   168: goto -90 -> 78
    //   171: aload 14
    //   173: aload_0
    //   174: aload 14
    //   176: invokestatic 385	gnu/kawa/slib/conditions:typeFieldAlistRef	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: invokestatic 417	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   182: astore 16
    //   184: goto -29 -> 155
    //   187: astore 4
    //   189: new 358	gnu/mapping/WrongType
    //   192: dup
    //   193: aload 4
    //   195: ldc_w 365
    //   198: bipush 254
    //   200: aload_2
    //   201: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   204: athrow
    //   205: astore 11
    //   207: new 358	gnu/mapping/WrongType
    //   210: dup
    //   211: aload 11
    //   213: ldc_w 365
    //   216: bipush 254
    //   218: aload 9
    //   220: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   223: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   27	33	187	java/lang/ClassCastException
    //   107	114	205	java/lang/ClassCastException
  }

  static Object typeFieldAlistRef(Object paramObject1, Object paramObject2)
  {
    while (true)
    {
      if (lists.isNull(paramObject1))
        return misc.error$V("type-field-alist-ref: field not found", new Object[] { paramObject1, paramObject2 });
      Object localObject = lists.assq(paramObject2, lists.cdr.apply1(lists.car.apply1(paramObject1)));
      if (localObject != Boolean.FALSE)
        return lists.cdr.apply1(localObject);
      paramObject1 = lists.cdr.apply1(paramObject1);
    }
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply1(paramModuleMethod, paramObject);
    case 2:
      if (isConditionType(paramObject))
        return Boolean.TRUE;
      return Boolean.FALSE;
    case 4:
      if (isCondition(paramObject))
        return Boolean.TRUE;
      return Boolean.FALSE;
    case 10:
    }
    return typeFieldAlist$To$Condition(paramObject);
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 506	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+32 -> 36, 6:+40->44, 7:+63->67, 8:+32->36, 9:+76->80
    //   37: aload_1
    //   38: aload_2
    //   39: aload_3
    //   40: invokespecial 518	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: areturn
    //   44: aload_3
    //   45: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   48: astore 11
    //   50: aload_2
    //   51: aload 11
    //   53: invokestatic 439	gnu/kawa/slib/conditions:isConditionHasType	(Ljava/lang/Object;Lgnu/kawa/slib/condition$Mntype;)Z
    //   56: ifeq +7 -> 63
    //   59: getstatic 513	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   62: areturn
    //   63: getstatic 391	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   66: areturn
    //   67: aload_2
    //   68: checkcast 257	gnu/kawa/slib/condition
    //   71: astore 9
    //   73: aload 9
    //   75: aload_3
    //   76: invokestatic 378	gnu/kawa/slib/conditions:conditionRef	(Lgnu/kawa/slib/condition;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: areturn
    //   80: aload_2
    //   81: checkcast 257	gnu/kawa/slib/condition
    //   84: astore 5
    //   86: aload_3
    //   87: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   90: astore 7
    //   92: aload 5
    //   94: aload 7
    //   96: invokestatic 374	gnu/kawa/slib/conditions:extractCondition	(Lgnu/kawa/slib/condition;Lgnu/kawa/slib/condition$Mntype;)Lgnu/kawa/slib/condition;
    //   99: areturn
    //   100: astore 10
    //   102: new 358	gnu/mapping/WrongType
    //   105: dup
    //   106: aload 10
    //   108: ldc 168
    //   110: iconst_2
    //   111: aload_3
    //   112: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   115: athrow
    //   116: astore 8
    //   118: new 358	gnu/mapping/WrongType
    //   121: dup
    //   122: aload 8
    //   124: ldc 120
    //   126: iconst_1
    //   127: aload_2
    //   128: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   131: athrow
    //   132: astore 4
    //   134: new 358	gnu/mapping/WrongType
    //   137: dup
    //   138: aload 4
    //   140: ldc 112
    //   142: iconst_1
    //   143: aload_2
    //   144: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   147: athrow
    //   148: astore 6
    //   150: new 358	gnu/mapping/WrongType
    //   153: dup
    //   154: aload 6
    //   156: ldc 112
    //   158: iconst_2
    //   159: aload_3
    //   160: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   163: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   44	50	100	java/lang/ClassCastException
    //   67	73	116	java/lang/ClassCastException
    //   80	86	132	java/lang/ClassCastException
    //   86	92	148	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 506	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_3
    //   5: if_icmpne +25 -> 30
    //   8: aload_2
    //   9: checkcast 522	gnu/mapping/Symbol
    //   12: astore 6
    //   14: aload_3
    //   15: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   18: astore 8
    //   20: aload 6
    //   22: aload 8
    //   24: aload 4
    //   26: invokestatic 524	gnu/kawa/slib/conditions:makeConditionType	(Lgnu/mapping/Symbol;Lgnu/kawa/slib/condition$Mntype;Ljava/lang/Object;)Lgnu/kawa/slib/condition$Mntype;
    //   29: areturn
    //   30: aload_0
    //   31: aload_1
    //   32: aload_2
    //   33: aload_3
    //   34: aload 4
    //   36: invokespecial 526	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: areturn
    //   40: astore 5
    //   42: new 358	gnu/mapping/WrongType
    //   45: dup
    //   46: aload 5
    //   48: ldc 190
    //   50: iconst_1
    //   51: aload_2
    //   52: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   55: athrow
    //   56: astore 7
    //   58: new 358	gnu/mapping/WrongType
    //   61: dup
    //   62: aload 7
    //   64: ldc 190
    //   66: iconst_2
    //   67: aload_3
    //   68: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   71: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   8	14	40	java/lang/ClassCastException
    //   14	20	56	java/lang/ClassCastException
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    Object localObject2;
    switch (paramModuleMethod.selector)
    {
    case 6:
    case 7:
    default:
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 5:
      localObject2 = paramArrayOfObject[0];
    case 8:
    }
    try
    {
      condition.Mntype localMntype = (condition.Mntype)localObject2;
      int k = paramArrayOfObject.length - 1;
      Object[] arrayOfObject2 = new Object[k];
      int m = k;
      while (true)
      {
        m--;
        if (m < 0)
          return makeCondition$V(localMntype, arrayOfObject2);
        arrayOfObject2[m] = paramArrayOfObject[(m + 1)];
      }
      Object localObject1 = paramArrayOfObject[0];
      int i = paramArrayOfObject.length - 1;
      Object[] arrayOfObject1 = new Object[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          return makeCompoundCondition$V(localObject1, arrayOfObject1);
        arrayOfObject1[j] = paramArrayOfObject[(j + 1)];
      }
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "make-condition", 1, localObject2);
    }
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 10:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 4:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
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
    case 8:
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 9:
      if (!(paramObject1 instanceof condition))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof condition.Mntype))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 7:
      if (!(paramObject1 instanceof condition))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 6:
    }
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof condition.Mntype))
      return -786430;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 3)
    {
      if (!(paramObject1 instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof condition.Mntype))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 6:
    case 7:
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 8:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 5:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  // ERROR //
  public final void run(CallContext paramCallContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 579	gnu/mapping/CallContext:consumer	Lgnu/lists/Consumer;
    //   4: pop
    //   5: new 237	gnu/kawa/slib/condition$Mntype
    //   8: dup
    //   9: getstatic 231	gnu/kawa/slib/conditions:Lit0	Lgnu/mapping/SimpleSymbol;
    //   12: getstatic 391	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   15: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   18: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   21: invokespecial 497	gnu/kawa/slib/condition$Mntype:<init>	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   24: putstatic 581	gnu/kawa/slib/conditions:$Amcondition	Ljava/lang/Object;
    //   27: getstatic 227	gnu/kawa/slib/conditions:Lit1	Lgnu/mapping/SimpleSymbol;
    //   30: astore_3
    //   31: getstatic 581	gnu/kawa/slib/conditions:$Amcondition	Ljava/lang/Object;
    //   34: astore 4
    //   36: aload 4
    //   38: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   41: astore 6
    //   43: aload_3
    //   44: aload 6
    //   46: getstatic 223	gnu/kawa/slib/conditions:Lit2	Lgnu/lists/PairWithPosition;
    //   49: invokestatic 524	gnu/kawa/slib/conditions:makeConditionType	(Lgnu/mapping/Symbol;Lgnu/kawa/slib/condition$Mntype;Ljava/lang/Object;)Lgnu/kawa/slib/condition$Mntype;
    //   52: putstatic 370	gnu/kawa/slib/conditions:$Ammessage	Ljava/lang/Object;
    //   55: getstatic 220	gnu/kawa/slib/conditions:Lit3	Lgnu/mapping/SimpleSymbol;
    //   58: astore 7
    //   60: getstatic 581	gnu/kawa/slib/conditions:$Amcondition	Ljava/lang/Object;
    //   63: astore 8
    //   65: aload 8
    //   67: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   70: astore 10
    //   72: aload 7
    //   74: aload 10
    //   76: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   79: invokestatic 524	gnu/kawa/slib/conditions:makeConditionType	(Lgnu/mapping/Symbol;Lgnu/kawa/slib/condition$Mntype;Ljava/lang/Object;)Lgnu/kawa/slib/condition$Mntype;
    //   82: putstatic 443	gnu/kawa/slib/conditions:$Amserious	Ljava/lang/Object;
    //   85: getstatic 216	gnu/kawa/slib/conditions:Lit4	Lgnu/mapping/SimpleSymbol;
    //   88: astore 11
    //   90: getstatic 443	gnu/kawa/slib/conditions:$Amserious	Ljava/lang/Object;
    //   93: astore 12
    //   95: aload 12
    //   97: checkcast 237	gnu/kawa/slib/condition$Mntype
    //   100: astore 14
    //   102: aload 11
    //   104: aload 14
    //   106: getstatic 142	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   109: invokestatic 524	gnu/kawa/slib/conditions:makeConditionType	(Lgnu/mapping/Symbol;Lgnu/kawa/slib/condition$Mntype;Ljava/lang/Object;)Lgnu/kawa/slib/condition$Mntype;
    //   112: putstatic 437	gnu/kawa/slib/conditions:$Amerror	Ljava/lang/Object;
    //   115: return
    //   116: astore 5
    //   118: new 358	gnu/mapping/WrongType
    //   121: dup
    //   122: aload 5
    //   124: ldc 190
    //   126: iconst_1
    //   127: aload 4
    //   129: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   132: athrow
    //   133: astore 9
    //   135: new 358	gnu/mapping/WrongType
    //   138: dup
    //   139: aload 9
    //   141: ldc 190
    //   143: iconst_1
    //   144: aload 8
    //   146: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   149: athrow
    //   150: astore 13
    //   152: new 358	gnu/mapping/WrongType
    //   155: dup
    //   156: aload 13
    //   158: ldc 190
    //   160: iconst_1
    //   161: aload 12
    //   163: invokespecial 363	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   166: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   36	43	116	java/lang/ClassCastException
    //   65	72	133	java/lang/ClassCastException
    //   95	102	150	java/lang/ClassCastException
  }

  public class frame extends ModuleBody
  {
    final ModuleMethod lambda$Fn1;
    condition.Mntype type;

    public frame()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "conditions.scm:166");
      this.lambda$Fn1 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 1)
      {
        if (lambda2(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda2(Object paramObject)
    {
      Object localObject = lists.car.apply1(paramObject);
      try
      {
        condition.Mntype localMntype = (condition.Mntype)localObject;
        return conditions.isConditionSubtype(localMntype, this.type);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "condition-subtype?", 0, localObject);
      }
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
 * Qualified Name:     gnu.kawa.slib.conditions
 * JD-Core Version:    0.6.2
 */