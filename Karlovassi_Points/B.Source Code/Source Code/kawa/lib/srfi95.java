package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.standard.Scheme;
import kawa.standard.append;

public class srfi95 extends ModuleBody
{
  public static final ModuleMethod $Pcsort$Mnlist;
  public static final ModuleMethod $Pcsort$Mnvector;
  public static final ModuleMethod $Pcvector$Mnsort$Ex;
  public static final srfi95 $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12 = (SimpleSymbol)new SimpleSymbol("sort").readResolve();
  static final IntNum Lit2;
  static final IntNum Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  static final ModuleMethod identity;
  public static final ModuleMethod merge;
  public static final ModuleMethod merge$Ex;
  public static final ModuleMethod sort;
  public static final ModuleMethod sort$Ex;
  public static final ModuleMethod sorted$Qu;

  // ERROR //
  public static Object $PcSortList(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: new 37	kawa/lib/srfi95$frame0
    //   3: dup
    //   4: invokespecial 41	kawa/lib/srfi95$frame0:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 45	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   13: aload_3
    //   14: aload_1
    //   15: putfield 48	kawa/lib/srfi95$frame0:less$Qu	Ljava/lang/Object;
    //   18: aload_3
    //   19: getstatic 54	gnu/expr/Special:undefined	Lgnu/expr/Special;
    //   22: putfield 57	kawa/lib/srfi95$frame0:keyer	Ljava/lang/Object;
    //   25: aload_2
    //   26: getstatic 63	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   29: if_acmpeq +83 -> 112
    //   32: getstatic 69	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   35: astore 4
    //   37: aload_3
    //   38: aload 4
    //   40: putfield 57	kawa/lib/srfi95$frame0:keyer	Ljava/lang/Object;
    //   43: aload_2
    //   44: getstatic 63	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   47: if_acmpeq +157 -> 204
    //   50: aload_3
    //   51: getfield 45	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   54: astore 8
    //   56: aload 8
    //   58: invokestatic 73	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   61: ifeq +59 -> 120
    //   64: aload_3
    //   65: getfield 45	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   68: astore 11
    //   70: aload 11
    //   72: checkcast 75	gnu/lists/LList
    //   75: astore 13
    //   77: aload_3
    //   78: aload_3
    //   79: aload 13
    //   81: invokestatic 79	kawa/lib/lists:length	(Lgnu/lists/LList;)I
    //   84: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: invokevirtual 89	kawa/lib/srfi95$frame0:lambda2step	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: putfield 45	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   93: aload_3
    //   94: getfield 45	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   97: astore 14
    //   99: aload 14
    //   101: invokestatic 73	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   104: ifeq +67 -> 171
    //   107: aload_3
    //   108: getfield 45	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   111: areturn
    //   112: getstatic 91	kawa/lib/srfi95:identity	Lgnu/expr/ModuleMethod;
    //   115: astore 4
    //   117: goto -80 -> 37
    //   120: aload 8
    //   122: checkcast 93	gnu/lists/Pair
    //   125: astore 10
    //   127: aload 10
    //   129: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   132: aload_2
    //   133: getstatic 69	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   136: aload 8
    //   138: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   141: invokevirtual 108	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: getstatic 69	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   147: aload 8
    //   149: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   152: invokestatic 112	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   155: invokestatic 116	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   158: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   161: aload 8
    //   163: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   166: astore 8
    //   168: goto -112 -> 56
    //   171: aload 14
    //   173: checkcast 93	gnu/lists/Pair
    //   176: astore 16
    //   178: aload 16
    //   180: getstatic 122	kawa/lib/lists:cdar	Lgnu/expr/GenericProc;
    //   183: aload 14
    //   185: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   188: invokestatic 116	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   191: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   194: aload 14
    //   196: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: astore 14
    //   201: goto -102 -> 99
    //   204: aload_3
    //   205: getfield 45	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   208: astore 5
    //   210: aload 5
    //   212: checkcast 75	gnu/lists/LList
    //   215: astore 7
    //   217: aload_3
    //   218: aload 7
    //   220: invokestatic 79	kawa/lib/lists:length	(Lgnu/lists/LList;)I
    //   223: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   226: invokevirtual 89	kawa/lib/srfi95$frame0:lambda2step	(Ljava/lang/Object;)Ljava/lang/Object;
    //   229: areturn
    //   230: astore 9
    //   232: new 124	gnu/mapping/WrongType
    //   235: dup
    //   236: aload 9
    //   238: ldc 126
    //   240: iconst_1
    //   241: aload 8
    //   243: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: astore 12
    //   249: new 124	gnu/mapping/WrongType
    //   252: dup
    //   253: aload 12
    //   255: ldc 130
    //   257: iconst_1
    //   258: aload 11
    //   260: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   263: athrow
    //   264: astore 15
    //   266: new 124	gnu/mapping/WrongType
    //   269: dup
    //   270: aload 15
    //   272: ldc 126
    //   274: iconst_1
    //   275: aload 14
    //   277: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: astore 6
    //   283: new 124	gnu/mapping/WrongType
    //   286: dup
    //   287: aload 6
    //   289: ldc 130
    //   291: iconst_1
    //   292: aload 5
    //   294: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   297: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   120	127	230	java/lang/ClassCastException
    //   70	77	247	java/lang/ClassCastException
    //   171	178	264	java/lang/ClassCastException
    //   210	217	281	java/lang/ClassCastException
  }

  public static void $PcSortVector(Sequence paramSequence, Object paramObject)
  {
    $PcSortVector(paramSequence, paramObject, Boolean.FALSE);
  }

  public static void $PcSortVector(Sequence paramSequence, Object paramObject1, Object paramObject2)
  {
    FVector localFVector = vectors.makeVector(paramSequence.size());
    Object localObject1 = $PcSortList(rank$Mn1Array$To$List(paramSequence), paramObject1, paramObject2);
    Object localObject2 = Lit3;
    while (!lists.isNull(localObject1))
      try
      {
        int i = ((Number)localObject2).intValue();
        vectors.vectorSet$Ex(localFVector, i, lists.car.apply1(localObject1));
        localObject1 = lists.cdr.apply1(localObject1);
        localObject2 = AddOp.$Pl.apply2(localObject2, Lit2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "vector-set!", 2, localObject2);
      }
  }

  public static Object $PcVectorSort$Ex(Sequence paramSequence, Object paramObject1, Object paramObject2)
  {
    Object localObject1 = $PcSortList(rank$Mn1Array$To$List(paramSequence), paramObject1, paramObject2);
    for (Object localObject2 = Lit3; !lists.isNull(localObject1); localObject2 = AddOp.$Pl.apply2(localObject2, Lit2))
    {
      paramSequence.set(((Number)localObject2).intValue(), lists.car.apply1(localObject1));
      localObject1 = lists.cdr.apply1(localObject1);
    }
    return paramSequence;
  }

  static
  {
    Lit11 = (SimpleSymbol)new SimpleSymbol("%sort-vector").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("%vector-sort!").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("sort!").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("%sort-list").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("merge!").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("merge").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("sorted?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("identity").readResolve();
    Lit3 = IntNum.make(0);
    Lit2 = IntNum.make(1);
    Lit1 = IntNum.make(2);
    Lit0 = IntNum.make(-1);
    $instance = new srfi95();
    srfi95 localsrfi95 = $instance;
    identity = new ModuleMethod(localsrfi95, 1, Lit4, 4097);
    sorted$Qu = new ModuleMethod(localsrfi95, 2, Lit5, 12290);
    merge = new ModuleMethod(localsrfi95, 4, Lit6, 16387);
    merge$Ex = new ModuleMethod(localsrfi95, 6, Lit7, 16387);
    $Pcsort$Mnlist = new ModuleMethod(localsrfi95, 8, Lit8, 12291);
    sort$Ex = new ModuleMethod(localsrfi95, 9, Lit9, 12290);
    $Pcvector$Mnsort$Ex = new ModuleMethod(localsrfi95, 11, Lit10, 12291);
    $Pcsort$Mnvector = new ModuleMethod(localsrfi95, 12, Lit11, 12290);
    sort = new ModuleMethod(localsrfi95, 14, Lit12, 12290);
    $instance.run();
  }

  public srfi95()
  {
    ModuleInfo.register(this);
  }

  static Object identity(Object paramObject)
  {
    return paramObject;
  }

  public static Object isSorted(Object paramObject1, Object paramObject2)
  {
    return isSorted(paramObject1, paramObject2, identity);
  }

  // ERROR //
  public static Object isSorted(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 73	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +7 -> 11
    //   7: getstatic 273	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   10: areturn
    //   11: aload_0
    //   12: instanceof 137
    //   15: ifeq +188 -> 203
    //   18: aload_0
    //   19: checkcast 137	gnu/lists/Sequence
    //   22: astore 16
    //   24: iconst_m1
    //   25: aload 16
    //   27: invokeinterface 141 1 0
    //   32: iadd
    //   33: istore 17
    //   35: iload 17
    //   37: iconst_1
    //   38: if_icmpgt +20 -> 58
    //   41: iconst_1
    //   42: istore 18
    //   44: iload 18
    //   46: ifeq +22 -> 68
    //   49: iload 18
    //   51: ifeq +13 -> 64
    //   54: getstatic 273	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   57: areturn
    //   58: iconst_0
    //   59: istore 18
    //   61: goto -17 -> 44
    //   64: getstatic 63	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   67: areturn
    //   68: iload 17
    //   70: iconst_1
    //   71: isub
    //   72: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: astore 19
    //   77: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   80: aload_2
    //   81: aload 16
    //   83: iload 17
    //   85: invokeinterface 277 2 0
    //   90: invokevirtual 108	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: astore 20
    //   95: aload 19
    //   97: invokestatic 283	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   100: astore 22
    //   102: aload 22
    //   104: invokestatic 289	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   107: istore 23
    //   109: iload 23
    //   111: ifeq +16 -> 127
    //   114: iload 23
    //   116: ifeq +7 -> 123
    //   119: getstatic 273	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   122: areturn
    //   123: getstatic 63	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   126: areturn
    //   127: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   130: astore 24
    //   132: aload 19
    //   134: checkcast 157	java/lang/Number
    //   137: invokevirtual 160	java/lang/Number:intValue	()I
    //   140: istore 26
    //   142: aload 24
    //   144: aload_2
    //   145: aload 16
    //   147: iload 26
    //   149: invokeinterface 277 2 0
    //   154: invokevirtual 108	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: astore 27
    //   159: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   162: aload_1
    //   163: aload 27
    //   165: aload 20
    //   167: invokevirtual 292	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: astore 28
    //   172: aload 28
    //   174: getstatic 63	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   177: if_acmpeq +23 -> 200
    //   180: getstatic 170	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   183: getstatic 233	kawa/lib/srfi95:Lit0	Lgnu/math/IntNum;
    //   186: aload 19
    //   188: invokevirtual 108	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: astore 19
    //   193: aload 27
    //   195: astore 20
    //   197: goto -102 -> 95
    //   200: aload 28
    //   202: areturn
    //   203: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   206: aload_0
    //   207: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: invokestatic 73	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   213: ifeq +7 -> 220
    //   216: getstatic 273	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   219: areturn
    //   220: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   223: aload_2
    //   224: getstatic 69	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   227: aload_0
    //   228: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: invokevirtual 108	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   234: astore_3
    //   235: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   238: aload_0
    //   239: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   242: astore 4
    //   244: aload 4
    //   246: invokestatic 73	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   249: istore 5
    //   251: iload 5
    //   253: ifeq +16 -> 269
    //   256: iload 5
    //   258: ifeq +7 -> 265
    //   261: getstatic 273	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   264: areturn
    //   265: getstatic 63	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   268: areturn
    //   269: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   272: aload_2
    //   273: getstatic 69	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   276: aload 4
    //   278: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   281: invokevirtual 108	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   284: astore 6
    //   286: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   289: aload_1
    //   290: aload 6
    //   292: aload_3
    //   293: invokevirtual 292	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   296: astore 7
    //   298: getstatic 63	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   301: astore 10
    //   303: aload 7
    //   305: aload 10
    //   307: if_acmpeq +39 -> 346
    //   310: iconst_1
    //   311: istore 11
    //   313: iconst_1
    //   314: iload 11
    //   316: iconst_1
    //   317: iadd
    //   318: iand
    //   319: istore 12
    //   321: iload 12
    //   323: ifeq +29 -> 352
    //   326: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   329: aload 4
    //   331: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   334: astore 13
    //   336: aload 6
    //   338: astore_3
    //   339: aload 13
    //   341: astore 4
    //   343: goto -99 -> 244
    //   346: iconst_0
    //   347: istore 11
    //   349: goto -36 -> 313
    //   352: iload 12
    //   354: ifeq +7 -> 361
    //   357: getstatic 273	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   360: areturn
    //   361: getstatic 63	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   364: areturn
    //   365: astore 14
    //   367: new 124	gnu/mapping/WrongType
    //   370: dup
    //   371: aload 14
    //   373: ldc_w 294
    //   376: bipush 254
    //   378: aload_0
    //   379: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   382: astore 15
    //   384: aload 15
    //   386: athrow
    //   387: astore 21
    //   389: new 124	gnu/mapping/WrongType
    //   392: dup
    //   393: aload 21
    //   395: ldc_w 296
    //   398: iconst_1
    //   399: aload 19
    //   401: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   404: athrow
    //   405: astore 25
    //   407: new 124	gnu/mapping/WrongType
    //   410: dup
    //   411: aload 25
    //   413: ldc_w 298
    //   416: iconst_2
    //   417: aload 19
    //   419: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   422: athrow
    //   423: astore 8
    //   425: new 124	gnu/mapping/WrongType
    //   428: dup
    //   429: aload 8
    //   431: ldc_w 300
    //   434: bipush 254
    //   436: aload 7
    //   438: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   441: astore 9
    //   443: aload 9
    //   445: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   18	24	365	java/lang/ClassCastException
    //   95	102	387	java/lang/ClassCastException
    //   132	142	405	java/lang/ClassCastException
    //   298	303	423	java/lang/ClassCastException
  }

  public static Object merge(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return merge(paramObject1, paramObject2, paramObject3, identity);
  }

  public static Object merge(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    frame localframe = new frame();
    localframe.less$Qu = paramObject3;
    localframe.key = paramObject4;
    if (lists.isNull(paramObject1))
      return paramObject2;
    if (lists.isNull(paramObject2))
      return paramObject1;
    return localframe.lambda1loop(lists.car.apply1(paramObject1), Scheme.applyToArgs.apply2(localframe.key, lists.car.apply1(paramObject1)), lists.cdr.apply1(paramObject1), lists.car.apply1(paramObject2), Scheme.applyToArgs.apply2(localframe.key, lists.car.apply1(paramObject2)), lists.cdr.apply1(paramObject2));
  }

  public static Object merge$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return merge$Ex(paramObject1, paramObject2, paramObject3, identity);
  }

  public static Object merge$Ex(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return sort$ClMerge$Ex(paramObject1, paramObject2, paramObject3, paramObject4);
  }

  static Object rank$Mn1Array$To$List(Sequence paramSequence)
  {
    int i = paramSequence.size() - 1;
    Pair localPair;
    for (Object localObject = LList.Empty; ; localObject = localPair)
    {
      if (i < 0)
        return localObject;
      localPair = lists.cons(paramSequence.get(i), localObject);
      i--;
    }
  }

  public static Object sort(Sequence paramSequence, Object paramObject)
  {
    return sort(paramSequence, paramObject, Boolean.FALSE);
  }

  public static Object sort(Sequence paramSequence, Object paramObject1, Object paramObject2)
  {
    if (lists.isList(paramSequence))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramSequence;
      arrayOfObject[1] = LList.Empty;
      return $PcSortList(append.append$V(arrayOfObject), paramObject1, paramObject2);
    }
    $PcSortVector(paramSequence, paramObject1, paramObject2);
    return Values.empty;
  }

  // ERROR //
  static Object sort$ClMerge$Ex(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: new 345	kawa/lib/srfi95$frame1
    //   3: dup
    //   4: invokespecial 346	kawa/lib/srfi95$frame1:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_2
    //   12: putfield 347	kawa/lib/srfi95$frame1:less$Qu	Ljava/lang/Object;
    //   15: aload 4
    //   17: aload_3
    //   18: putfield 348	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
    //   21: aload_0
    //   22: invokestatic 73	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   25: ifeq +5 -> 30
    //   28: aload_1
    //   29: areturn
    //   30: aload_1
    //   31: invokestatic 73	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   34: ifeq +5 -> 39
    //   37: aload_0
    //   38: areturn
    //   39: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   42: aload 4
    //   44: getfield 348	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
    //   47: getstatic 69	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   50: aload_0
    //   51: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: invokevirtual 108	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: astore 5
    //   59: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   62: aload 4
    //   64: getfield 348	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
    //   67: getstatic 69	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   70: aload_1
    //   71: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: invokevirtual 108	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: astore 6
    //   79: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   82: aload 4
    //   84: getfield 347	kawa/lib/srfi95$frame1:less$Qu	Ljava/lang/Object;
    //   87: aload 6
    //   89: aload 5
    //   91: invokevirtual 292	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: getstatic 63	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   97: if_acmpeq +68 -> 165
    //   100: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   103: aload_1
    //   104: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: invokestatic 73	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   110: ifeq +17 -> 127
    //   113: aload_1
    //   114: checkcast 93	gnu/lists/Pair
    //   117: astore 12
    //   119: aload 12
    //   121: aload_0
    //   122: invokestatic 351	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   125: aload_1
    //   126: areturn
    //   127: aload 4
    //   129: aload_1
    //   130: aload_0
    //   131: aload 5
    //   133: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   136: aload_1
    //   137: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   143: aload 4
    //   145: getfield 348	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
    //   148: getstatic 354	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   151: aload_1
    //   152: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   155: invokevirtual 108	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: invokevirtual 358	kawa/lib/srfi95$frame1:lambda3loop	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: goto -37 -> 125
    //   165: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   168: aload_0
    //   169: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   172: invokestatic 73	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   175: ifeq +17 -> 192
    //   178: aload_0
    //   179: checkcast 93	gnu/lists/Pair
    //   182: astore 9
    //   184: aload 9
    //   186: aload_1
    //   187: invokestatic 351	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   190: aload_0
    //   191: areturn
    //   192: aload 4
    //   194: aload_0
    //   195: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   198: aload_0
    //   199: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   202: getstatic 99	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   205: aload 4
    //   207: getfield 348	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
    //   210: getstatic 354	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   213: aload_0
    //   214: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   217: invokevirtual 108	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   220: aload_1
    //   221: aload 6
    //   223: invokevirtual 358	kawa/lib/srfi95$frame1:lambda3loop	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   226: pop
    //   227: goto -37 -> 190
    //   230: astore 11
    //   232: new 124	gnu/mapping/WrongType
    //   235: dup
    //   236: aload 11
    //   238: ldc_w 360
    //   241: iconst_1
    //   242: aload_1
    //   243: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: astore 8
    //   249: new 124	gnu/mapping/WrongType
    //   252: dup
    //   253: aload 8
    //   255: ldc_w 360
    //   258: iconst_1
    //   259: aload_0
    //   260: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   263: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   113	119	230	java/lang/ClassCastException
    //   178	184	247	java/lang/ClassCastException
  }

  public static Object sort$Ex(Sequence paramSequence, Object paramObject)
  {
    return sort$Ex(paramSequence, paramObject, Boolean.FALSE);
  }

  // ERROR //
  public static Object sort$Ex(Sequence paramSequence, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 329	kawa/lib/lists:isList	(Ljava/lang/Object;)Z
    //   4: ifeq +138 -> 142
    //   7: aload_0
    //   8: aload_1
    //   9: aload_2
    //   10: invokestatic 153	kawa/lib/srfi95:$PcSortList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: astore_3
    //   14: aload_3
    //   15: aload_0
    //   16: if_acmpeq +124 -> 140
    //   19: aload_3
    //   20: astore 4
    //   22: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   25: aload 4
    //   27: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: aload_0
    //   31: if_acmpeq +16 -> 47
    //   34: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   37: aload 4
    //   39: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: astore 4
    //   44: goto -22 -> 22
    //   47: aload 4
    //   49: checkcast 93	gnu/lists/Pair
    //   52: astore 6
    //   54: aload 6
    //   56: aload_3
    //   57: invokestatic 351	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   60: getstatic 69	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   63: aload_0
    //   64: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: astore 7
    //   69: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   72: aload_0
    //   73: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: astore 8
    //   78: aload_0
    //   79: checkcast 93	gnu/lists/Pair
    //   82: astore 10
    //   84: aload 10
    //   86: getstatic 69	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   89: aload_3
    //   90: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: invokestatic 116	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   96: aload_0
    //   97: checkcast 93	gnu/lists/Pair
    //   100: astore 12
    //   102: aload 12
    //   104: getstatic 119	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   107: aload_3
    //   108: invokevirtual 104	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: invokestatic 351	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   114: aload_3
    //   115: checkcast 93	gnu/lists/Pair
    //   118: astore 14
    //   120: aload 14
    //   122: aload 7
    //   124: invokestatic 116	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   127: aload_3
    //   128: checkcast 93	gnu/lists/Pair
    //   131: astore 16
    //   133: aload 16
    //   135: aload 8
    //   137: invokestatic 351	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   140: aload_0
    //   141: areturn
    //   142: aload_0
    //   143: aload_1
    //   144: aload_2
    //   145: invokestatic 364	kawa/lib/srfi95:$PcVectorSort$Ex	(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: areturn
    //   149: astore 5
    //   151: new 124	gnu/mapping/WrongType
    //   154: dup
    //   155: aload 5
    //   157: ldc_w 360
    //   160: iconst_1
    //   161: aload 4
    //   163: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   166: athrow
    //   167: astore 9
    //   169: new 124	gnu/mapping/WrongType
    //   172: dup
    //   173: aload 9
    //   175: ldc 126
    //   177: iconst_1
    //   178: aload_0
    //   179: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    //   183: astore 11
    //   185: new 124	gnu/mapping/WrongType
    //   188: dup
    //   189: aload 11
    //   191: ldc_w 360
    //   194: iconst_1
    //   195: aload_0
    //   196: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   199: athrow
    //   200: astore 13
    //   202: new 124	gnu/mapping/WrongType
    //   205: dup
    //   206: aload 13
    //   208: ldc 126
    //   210: iconst_1
    //   211: aload_3
    //   212: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   215: athrow
    //   216: astore 15
    //   218: new 124	gnu/mapping/WrongType
    //   221: dup
    //   222: aload 15
    //   224: ldc_w 360
    //   227: iconst_1
    //   228: aload_3
    //   229: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   232: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   47	54	149	java/lang/ClassCastException
    //   78	84	167	java/lang/ClassCastException
    //   96	102	183	java/lang/ClassCastException
    //   114	120	200	java/lang/ClassCastException
    //   127	133	216	java/lang/ClassCastException
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 1)
      return identity(paramObject);
    return super.apply1(paramModuleMethod, paramObject);
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 369	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+44->48, 2:+52->56, 9:+58->62, 12:+71->75, 14:+87->91
    //   49: aload_1
    //   50: aload_2
    //   51: aload_3
    //   52: invokespecial 376	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: areturn
    //   56: aload_2
    //   57: aload_3
    //   58: invokestatic 378	kawa/lib/srfi95:isSorted	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: areturn
    //   62: aload_2
    //   63: checkcast 137	gnu/lists/Sequence
    //   66: astore 9
    //   68: aload 9
    //   70: aload_3
    //   71: invokestatic 380	kawa/lib/srfi95:sort$Ex	(Lgnu/lists/Sequence;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: areturn
    //   75: aload_2
    //   76: checkcast 137	gnu/lists/Sequence
    //   79: astore 7
    //   81: aload 7
    //   83: aload_3
    //   84: invokestatic 382	kawa/lib/srfi95:$PcSortVector	(Lgnu/lists/Sequence;Ljava/lang/Object;)V
    //   87: getstatic 343	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   90: areturn
    //   91: aload_2
    //   92: checkcast 137	gnu/lists/Sequence
    //   95: astore 5
    //   97: aload 5
    //   99: aload_3
    //   100: invokestatic 384	kawa/lib/srfi95:sort	(Lgnu/lists/Sequence;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: areturn
    //   104: astore 8
    //   106: new 124	gnu/mapping/WrongType
    //   109: dup
    //   110: aload 8
    //   112: ldc 203
    //   114: iconst_1
    //   115: aload_2
    //   116: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   119: athrow
    //   120: astore 6
    //   122: new 124	gnu/mapping/WrongType
    //   125: dup
    //   126: aload 6
    //   128: ldc 195
    //   130: iconst_1
    //   131: aload_2
    //   132: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   135: athrow
    //   136: astore 4
    //   138: new 124	gnu/mapping/WrongType
    //   141: dup
    //   142: aload 4
    //   144: ldc 184
    //   146: iconst_1
    //   147: aload_2
    //   148: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   151: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   62	68	104	java/lang/ClassCastException
    //   75	81	120	java/lang/ClassCastException
    //   91	97	136	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 369	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+68 -> 72, 2:+78->82, 3:+68->72, 4:+86->90, 5:+68->72, 6:+94->98, 7:+68->72, 8:+102->106, 9:+110->114, 10:+68->72, 11:+125->129, 12:+140->144, 13:+68->72, 14:+158->162
    //   73: aload_1
    //   74: aload_2
    //   75: aload_3
    //   76: aload 4
    //   78: invokespecial 387	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   81: areturn
    //   82: aload_2
    //   83: aload_3
    //   84: aload 4
    //   86: invokestatic 270	kawa/lib/srfi95:isSorted	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: areturn
    //   90: aload_2
    //   91: aload_3
    //   92: aload 4
    //   94: invokestatic 389	kawa/lib/srfi95:merge	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: areturn
    //   98: aload_2
    //   99: aload_3
    //   100: aload 4
    //   102: invokestatic 391	kawa/lib/srfi95:merge$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: areturn
    //   106: aload_2
    //   107: aload_3
    //   108: aload 4
    //   110: invokestatic 153	kawa/lib/srfi95:$PcSortList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast 137	gnu/lists/Sequence
    //   118: astore 12
    //   120: aload 12
    //   122: aload_3
    //   123: aload 4
    //   125: invokestatic 362	kawa/lib/srfi95:sort$Ex	(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: areturn
    //   129: aload_2
    //   130: checkcast 137	gnu/lists/Sequence
    //   133: astore 10
    //   135: aload 10
    //   137: aload_3
    //   138: aload 4
    //   140: invokestatic 364	kawa/lib/srfi95:$PcVectorSort$Ex	(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: areturn
    //   144: aload_2
    //   145: checkcast 137	gnu/lists/Sequence
    //   148: astore 8
    //   150: aload 8
    //   152: aload_3
    //   153: aload 4
    //   155: invokestatic 135	kawa/lib/srfi95:$PcSortVector	(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)V
    //   158: getstatic 343	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   161: areturn
    //   162: aload_2
    //   163: checkcast 137	gnu/lists/Sequence
    //   166: astore 6
    //   168: aload 6
    //   170: aload_3
    //   171: aload 4
    //   173: invokestatic 326	kawa/lib/srfi95:sort	(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: areturn
    //   177: astore 11
    //   179: new 124	gnu/mapping/WrongType
    //   182: dup
    //   183: aload 11
    //   185: ldc 203
    //   187: iconst_1
    //   188: aload_2
    //   189: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   192: athrow
    //   193: astore 9
    //   195: new 124	gnu/mapping/WrongType
    //   198: dup
    //   199: aload 9
    //   201: ldc 199
    //   203: iconst_1
    //   204: aload_2
    //   205: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   208: athrow
    //   209: astore 7
    //   211: new 124	gnu/mapping/WrongType
    //   214: dup
    //   215: aload 7
    //   217: ldc 195
    //   219: iconst_1
    //   220: aload_2
    //   221: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   224: athrow
    //   225: astore 5
    //   227: new 124	gnu/mapping/WrongType
    //   230: dup
    //   231: aload 5
    //   233: ldc 184
    //   235: iconst_1
    //   236: aload_2
    //   237: invokespecial 129	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   240: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   114	120	177	java/lang/ClassCastException
    //   129	135	193	java/lang/ClassCastException
    //   144	150	209	java/lang/ClassCastException
    //   162	168	225	java/lang/ClassCastException
  }

  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    switch (paramModuleMethod.selector)
    {
    case 5:
    default:
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    case 4:
      return merge(paramObject1, paramObject2, paramObject3, paramObject4);
    case 6:
    }
    return merge$Ex(paramObject1, paramObject2, paramObject3, paramObject4);
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

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 14:
      if (!(paramObject1 instanceof Sequence))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 12:
      if (!(paramObject1 instanceof Sequence))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 9:
      if (!(paramObject1 instanceof Sequence))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 2:
    }
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
    case 3:
    case 5:
    case 7:
    case 10:
    case 13:
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 14:
      if (!(paramObject1 instanceof Sequence))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 12:
      if (!(paramObject1 instanceof Sequence))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 11:
      if (!(paramObject1 instanceof Sequence))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 9:
      if (!(paramObject1 instanceof Sequence))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 8:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 6:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 4:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 2:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }

  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 5:
    default:
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 6:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 4:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.value4 = paramObject4;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 4;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }

  public class frame extends ModuleBody
  {
    Object key;
    Object less$Qu;

    public Object lambda1loop(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
    {
      if (Scheme.applyToArgs.apply3(this.less$Qu, paramObject5, paramObject2) != Boolean.FALSE)
      {
        if (lists.isNull(paramObject6))
          return lists.cons(paramObject4, lists.cons(paramObject1, paramObject3));
        return lists.cons(paramObject4, lambda1loop(paramObject1, paramObject2, paramObject3, lists.car.apply1(paramObject6), Scheme.applyToArgs.apply2(this.key, lists.car.apply1(paramObject6)), lists.cdr.apply1(paramObject6)));
      }
      if (lists.isNull(paramObject3))
        return lists.cons(paramObject1, lists.cons(paramObject4, paramObject6));
      return lists.cons(paramObject1, lambda1loop(lists.car.apply1(paramObject3), Scheme.applyToArgs.apply2(this.key, lists.car.apply1(paramObject3)), lists.cdr.apply1(paramObject3), paramObject4, paramObject5, paramObject6));
    }
  }

  public class frame0 extends ModuleBody
  {
    Object keyer;
    Object less$Qu;
    Object seq;

    // ERROR //
    public Object lambda2step(Object paramObject)
    {
      // Byte code:
      //   0: getstatic 22	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
      //   3: aload_1
      //   4: getstatic 28	kawa/lib/srfi95:Lit1	Lgnu/math/IntNum;
      //   7: invokevirtual 34	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   10: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   13: if_acmpeq +46 -> 59
      //   16: getstatic 46	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
      //   19: aload_1
      //   20: getstatic 28	kawa/lib/srfi95:Lit1	Lgnu/math/IntNum;
      //   23: invokevirtual 34	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   26: astore 16
      //   28: aload_0
      //   29: aload 16
      //   31: invokevirtual 48	kawa/lib/srfi95$frame0:lambda2step	(Ljava/lang/Object;)Ljava/lang/Object;
      //   34: aload_0
      //   35: getstatic 54	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   38: aload_1
      //   39: aload 16
      //   41: invokevirtual 34	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   44: invokevirtual 48	kawa/lib/srfi95$frame0:lambda2step	(Ljava/lang/Object;)Ljava/lang/Object;
      //   47: aload_0
      //   48: getfield 56	kawa/lib/srfi95$frame0:less$Qu	Ljava/lang/Object;
      //   51: aload_0
      //   52: getfield 58	kawa/lib/srfi95$frame0:keyer	Ljava/lang/Object;
      //   55: invokestatic 62	kawa/lib/srfi95:sort$ClMerge$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   58: areturn
      //   59: getstatic 65	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   62: aload_1
      //   63: getstatic 28	kawa/lib/srfi95:Lit1	Lgnu/math/IntNum;
      //   66: invokevirtual 34	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   69: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   72: if_acmpeq +153 -> 225
      //   75: getstatic 71	kawa/lib/lists:car	Lgnu/expr/GenericProc;
      //   78: aload_0
      //   79: getfield 73	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   82: invokevirtual 76	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   85: astore 5
      //   87: getstatic 79	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   90: aload_0
      //   91: getfield 73	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   94: invokevirtual 76	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   97: astore 6
      //   99: aload_0
      //   100: getfield 73	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   103: astore 7
      //   105: aload_0
      //   106: getstatic 82	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
      //   109: aload_0
      //   110: getfield 73	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   113: invokevirtual 76	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   116: putfield 73	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   119: getstatic 86	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   122: aload_0
      //   123: getfield 56	kawa/lib/srfi95$frame0:less$Qu	Ljava/lang/Object;
      //   126: getstatic 86	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   129: aload_0
      //   130: getfield 58	kawa/lib/srfi95$frame0:keyer	Ljava/lang/Object;
      //   133: aload 6
      //   135: invokevirtual 34	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   138: getstatic 86	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   141: aload_0
      //   142: getfield 58	kawa/lib/srfi95$frame0:keyer	Ljava/lang/Object;
      //   145: aload 5
      //   147: invokevirtual 34	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   150: invokevirtual 90	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   153: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   156: if_acmpeq +41 -> 197
      //   159: aload 7
      //   161: checkcast 92	gnu/lists/Pair
      //   164: astore 12
      //   166: aload 12
      //   168: aload 6
      //   170: invokestatic 96	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   173: getstatic 99	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   176: aload 7
      //   178: invokevirtual 76	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   181: astore 13
      //   183: aload 13
      //   185: checkcast 92	gnu/lists/Pair
      //   188: astore 15
      //   190: aload 15
      //   192: aload 5
      //   194: invokestatic 96	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   197: getstatic 99	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   200: aload 7
      //   202: invokevirtual 76	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   205: astore 8
      //   207: aload 8
      //   209: checkcast 92	gnu/lists/Pair
      //   212: astore 10
      //   214: aload 10
      //   216: getstatic 105	gnu/lists/LList:Empty	Lgnu/lists/LList;
      //   219: invokestatic 108	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   222: aload 7
      //   224: areturn
      //   225: getstatic 65	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   228: aload_1
      //   229: getstatic 111	kawa/lib/srfi95:Lit2	Lgnu/math/IntNum;
      //   232: invokevirtual 34	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   235: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   238: if_acmpeq +38 -> 276
      //   241: aload_0
      //   242: getfield 73	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   245: astore_2
      //   246: aload_0
      //   247: getstatic 99	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   250: aload_0
      //   251: getfield 73	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   254: invokevirtual 76	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   257: putfield 73	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   260: aload_2
      //   261: checkcast 92	gnu/lists/Pair
      //   264: astore 4
      //   266: aload 4
      //   268: getstatic 105	gnu/lists/LList:Empty	Lgnu/lists/LList;
      //   271: invokestatic 108	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   274: aload_2
      //   275: areturn
      //   276: getstatic 105	gnu/lists/LList:Empty	Lgnu/lists/LList;
      //   279: areturn
      //   280: astore 11
      //   282: new 113	gnu/mapping/WrongType
      //   285: dup
      //   286: aload 11
      //   288: ldc 115
      //   290: iconst_1
      //   291: aload 7
      //   293: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   296: athrow
      //   297: astore 14
      //   299: new 113	gnu/mapping/WrongType
      //   302: dup
      //   303: aload 14
      //   305: ldc 115
      //   307: iconst_1
      //   308: aload 13
      //   310: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   313: athrow
      //   314: astore 9
      //   316: new 113	gnu/mapping/WrongType
      //   319: dup
      //   320: aload 9
      //   322: ldc 120
      //   324: iconst_1
      //   325: aload 8
      //   327: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   330: athrow
      //   331: astore_3
      //   332: new 113	gnu/mapping/WrongType
      //   335: dup
      //   336: aload_3
      //   337: ldc 120
      //   339: iconst_1
      //   340: aload_2
      //   341: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   344: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   159	166	280	java/lang/ClassCastException
      //   183	190	297	java/lang/ClassCastException
      //   207	214	314	java/lang/ClassCastException
      //   260	266	331	java/lang/ClassCastException
    }
  }

  public class frame1 extends ModuleBody
  {
    Object key;
    Object less$Qu;

    // ERROR //
    public Object lambda3loop(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
    {
      // Byte code:
      //   0: getstatic 21	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: aload_0
      //   4: getfield 23	kawa/lib/srfi95$frame1:less$Qu	Ljava/lang/Object;
      //   7: aload 5
      //   9: aload_3
      //   10: invokevirtual 29	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   13: getstatic 35	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   16: if_acmpeq +82 -> 98
      //   19: aload_1
      //   20: checkcast 37	gnu/lists/Pair
      //   23: astore 11
      //   25: aload 11
      //   27: aload 4
      //   29: invokestatic 43	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   32: getstatic 47	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   35: aload 4
      //   37: invokevirtual 51	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   40: invokestatic 55	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   43: ifeq +20 -> 63
      //   46: aload 4
      //   48: checkcast 37	gnu/lists/Pair
      //   51: astore 13
      //   53: aload 13
      //   55: aload_2
      //   56: invokestatic 43	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   59: getstatic 61	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   62: areturn
      //   63: aload_0
      //   64: aload 4
      //   66: aload_2
      //   67: aload_3
      //   68: getstatic 47	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   71: aload 4
      //   73: invokevirtual 51	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   76: getstatic 21	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   79: aload_0
      //   80: getfield 63	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
      //   83: getstatic 66	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   86: aload 4
      //   88: invokevirtual 51	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   91: invokevirtual 70	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   94: invokevirtual 72	kawa/lib/srfi95$frame1:lambda3loop	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   97: areturn
      //   98: aload_1
      //   99: checkcast 37	gnu/lists/Pair
      //   102: astore 7
      //   104: aload 7
      //   106: aload_2
      //   107: invokestatic 43	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   110: getstatic 47	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   113: aload_2
      //   114: invokevirtual 51	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   117: invokestatic 55	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   120: ifeq +20 -> 140
      //   123: aload_2
      //   124: checkcast 37	gnu/lists/Pair
      //   127: astore 9
      //   129: aload 9
      //   131: aload 4
      //   133: invokestatic 43	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   136: getstatic 61	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   139: areturn
      //   140: aload_0
      //   141: aload_2
      //   142: getstatic 47	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   145: aload_2
      //   146: invokevirtual 51	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   149: getstatic 21	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   152: aload_0
      //   153: getfield 63	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
      //   156: getstatic 66	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   159: aload_2
      //   160: invokevirtual 51	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   163: invokevirtual 70	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   166: aload 4
      //   168: aload 5
      //   170: invokevirtual 72	kawa/lib/srfi95$frame1:lambda3loop	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   173: areturn
      //   174: astore 10
      //   176: new 74	gnu/mapping/WrongType
      //   179: dup
      //   180: aload 10
      //   182: ldc 76
      //   184: iconst_1
      //   185: aload_1
      //   186: invokespecial 79	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   189: athrow
      //   190: astore 12
      //   192: new 74	gnu/mapping/WrongType
      //   195: dup
      //   196: aload 12
      //   198: ldc 76
      //   200: iconst_1
      //   201: aload 4
      //   203: invokespecial 79	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   206: athrow
      //   207: astore 6
      //   209: new 74	gnu/mapping/WrongType
      //   212: dup
      //   213: aload 6
      //   215: ldc 76
      //   217: iconst_1
      //   218: aload_1
      //   219: invokespecial 79	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   222: athrow
      //   223: astore 8
      //   225: new 74	gnu/mapping/WrongType
      //   228: dup
      //   229: aload 8
      //   231: ldc 76
      //   233: iconst_1
      //   234: aload_2
      //   235: invokespecial 79	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   238: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   19	25	174	java/lang/ClassCastException
      //   46	53	190	java/lang/ClassCastException
      //   98	104	207	java/lang/ClassCastException
      //   123	129	223	java/lang/ClassCastException
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.srfi95
 * JD-Core Version:    0.6.2
 */