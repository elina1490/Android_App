package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.IsEqual;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;
import kawa.standard.call_with_values;

public class srfi37 extends ModuleBody
{
  public static final srfi37 $instance;
  static final IntNum Lit0;
  static final Char Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11 = (SimpleSymbol)new SimpleSymbol("args-fold").readResolve();
  static final Char Lit2;
  static final IntNum Lit3;
  static final IntNum Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod args$Mnfold;
  public static final ModuleMethod option;
  public static final ModuleMethod option$Mnnames;
  public static final ModuleMethod option$Mnoptional$Mnarg$Qu;
  public static final ModuleMethod option$Mnprocessor;
  public static final ModuleMethod option$Mnrequired$Mnarg$Qu;
  static final Class option$Mntype;
  public static final ModuleMethod option$Qu;

  static
  {
    Lit10 = (SimpleSymbol)new SimpleSymbol("option-processor").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("option-optional-arg?").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("option-required-arg?").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("option-names").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("option").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("option?").readResolve();
    Lit4 = IntNum.make(0);
    Lit3 = IntNum.make(3);
    Lit2 = Char.make(61);
    Lit1 = Char.make(45);
    Lit0 = IntNum.make(1);
    $instance = new srfi37();
    option$Mntype = option.Mntype.class;
    srfi37 localsrfi37 = $instance;
    option$Qu = new ModuleMethod(localsrfi37, 25, Lit5, 4097);
    option = new ModuleMethod(localsrfi37, 26, Lit6, 16388);
    option$Mnnames = new ModuleMethod(localsrfi37, 27, Lit7, 4097);
    option$Mnrequired$Mnarg$Qu = new ModuleMethod(localsrfi37, 28, Lit8, 4097);
    option$Mnoptional$Mnarg$Qu = new ModuleMethod(localsrfi37, 29, Lit9, 4097);
    option$Mnprocessor = new ModuleMethod(localsrfi37, 30, Lit10, 4097);
    args$Mnfold = new ModuleMethod(localsrfi37, 31, Lit11, -4092);
    $instance.run();
  }

  public srfi37()
  {
    ModuleInfo.register(this);
  }

  public static Object argsFold$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
  {
    frame localframe = new frame();
    localframe.options = paramObject2;
    localframe.unrecognized$Mnoption$Mnproc = paramObject3;
    localframe.operand$Mnproc = paramObject4;
    return localframe.lambda5scanArgs(paramObject1, LList.makeList(paramArrayOfObject, 0));
  }

  public static boolean isOption(Object paramObject)
  {
    return paramObject instanceof option.Mntype;
  }

  public static Object isOptionOptionalArg(option.Mntype paramMntype)
  {
    return paramMntype.optional$Mnarg$Qu;
  }

  public static Object isOptionRequiredArg(option.Mntype paramMntype)
  {
    return paramMntype.required$Mnarg$Qu;
  }

  public static option.Mntype option(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    option.Mntype localMntype = new option.Mntype();
    localMntype.names = paramObject1;
    localMntype.required$Mnarg$Qu = paramObject2;
    localMntype.optional$Mnarg$Qu = paramObject3;
    localMntype.processor = paramObject4;
    return localMntype;
  }

  public static Object optionNames(option.Mntype paramMntype)
  {
    return paramMntype.names;
  }

  public static Object optionProcessor(option.Mntype paramMntype)
  {
    return paramMntype.processor;
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 182	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+40 -> 44, 25:+47->51, 26:+40->44, 27:+62->66, 28:+74->78, 29:+86->90, 30:+98->102
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 184	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: areturn
    //   51: aload_2
    //   52: invokestatic 186	gnu/kawa/slib/srfi37:isOption	(Ljava/lang/Object;)Z
    //   55: ifeq +7 -> 62
    //   58: getstatic 192	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   61: areturn
    //   62: getstatic 195	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   65: areturn
    //   66: aload_2
    //   67: checkcast 97	gnu/kawa/slib/option$Mntype
    //   70: astore 10
    //   72: aload 10
    //   74: invokestatic 197	gnu/kawa/slib/srfi37:optionNames	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
    //   77: areturn
    //   78: aload_2
    //   79: checkcast 97	gnu/kawa/slib/option$Mntype
    //   82: astore 8
    //   84: aload 8
    //   86: invokestatic 199	gnu/kawa/slib/srfi37:isOptionRequiredArg	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
    //   89: areturn
    //   90: aload_2
    //   91: checkcast 97	gnu/kawa/slib/option$Mntype
    //   94: astore 6
    //   96: aload 6
    //   98: invokestatic 201	gnu/kawa/slib/srfi37:isOptionOptionalArg	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
    //   101: areturn
    //   102: aload_2
    //   103: checkcast 97	gnu/kawa/slib/option$Mntype
    //   106: astore 4
    //   108: aload 4
    //   110: invokestatic 203	gnu/kawa/slib/srfi37:optionProcessor	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
    //   113: areturn
    //   114: astore 9
    //   116: new 205	gnu/mapping/WrongType
    //   119: dup
    //   120: aload 9
    //   122: ldc 61
    //   124: iconst_1
    //   125: aload_2
    //   126: invokespecial 208	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   129: athrow
    //   130: astore 7
    //   132: new 205	gnu/mapping/WrongType
    //   135: dup
    //   136: aload 7
    //   138: ldc 57
    //   140: iconst_1
    //   141: aload_2
    //   142: invokespecial 208	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   145: athrow
    //   146: astore 5
    //   148: new 205	gnu/mapping/WrongType
    //   151: dup
    //   152: aload 5
    //   154: ldc 53
    //   156: iconst_1
    //   157: aload_2
    //   158: invokespecial 208	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   161: athrow
    //   162: astore_3
    //   163: new 205	gnu/mapping/WrongType
    //   166: dup
    //   167: aload_3
    //   168: ldc 49
    //   170: iconst_1
    //   171: aload_2
    //   172: invokespecial 208	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   175: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   66	72	114	java/lang/ClassCastException
    //   78	84	130	java/lang/ClassCastException
    //   90	96	146	java/lang/ClassCastException
    //   102	108	162	java/lang/ClassCastException
  }

  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramModuleMethod.selector == 26)
      return option(paramObject1, paramObject2, paramObject3, paramObject4);
    return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    if (paramModuleMethod.selector == 31)
    {
      Object localObject1 = paramArrayOfObject[0];
      Object localObject2 = paramArrayOfObject[1];
      Object localObject3 = paramArrayOfObject[2];
      Object localObject4 = paramArrayOfObject[3];
      int i = paramArrayOfObject.length - 4;
      Object[] arrayOfObject = new Object[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          return argsFold$V(localObject1, localObject2, localObject3, localObject4, arrayOfObject);
        arrayOfObject[j] = paramArrayOfObject[(j + 4)];
      }
    }
    return super.applyN(paramModuleMethod, paramArrayOfObject);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 26:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 30:
      if (!(paramObject instanceof option.Mntype))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 29:
      if (!(paramObject instanceof option.Mntype))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28:
      if (!(paramObject instanceof option.Mntype))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 27:
      if (!(paramObject instanceof option.Mntype))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 25:
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 26)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 31)
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

  public class frame extends ModuleBody
  {
    Object operand$Mnproc;
    Object options;
    Object unrecognized$Mnoption$Mnproc;

    public static Object lambda1find(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1))
        return Boolean.FALSE;
      if (Scheme.applyToArgs.apply2(paramObject2, lists.car.apply1(paramObject1)) != Boolean.FALSE)
        return lists.car.apply1(paramObject1);
      return lambda1find(lists.cdr.apply1(paramObject1), paramObject2);
    }

    public Object lambda2findOption(Object paramObject)
    {
      srfi37.frame0 localframe0 = new srfi37.frame0();
      localframe0.staticLink = this;
      localframe0.name = paramObject;
      return lambda1find(this.options, localframe0.lambda$Fn1);
    }

    // ERROR //
    public Object lambda3scanShortOptions(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      // Byte code:
      //   0: new 73	gnu/kawa/slib/srfi37$frame1
      //   3: dup
      //   4: invokespecial 74	gnu/kawa/slib/srfi37$frame1:<init>	()V
      //   7: astore 5
      //   9: aload 5
      //   11: aload_0
      //   12: putfield 75	gnu/kawa/slib/srfi37$frame1:staticLink	Lgnu/kawa/slib/srfi37$frame;
      //   15: aload 5
      //   17: aload_1
      //   18: putfield 78	gnu/kawa/slib/srfi37$frame1:index	Ljava/lang/Object;
      //   21: aload 5
      //   23: aload_2
      //   24: putfield 81	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   27: aload 5
      //   29: aload_3
      //   30: putfield 84	gnu/kawa/slib/srfi37$frame1:args	Ljava/lang/Object;
      //   33: aload 5
      //   35: aload 4
      //   37: putfield 87	gnu/kawa/slib/srfi37$frame1:seeds	Ljava/lang/Object;
      //   40: getstatic 91	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   43: astore 6
      //   45: aload 5
      //   47: getfield 78	gnu/kawa/slib/srfi37$frame1:index	Ljava/lang/Object;
      //   50: astore 7
      //   52: aload 5
      //   54: getfield 81	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   57: astore 8
      //   59: aload 8
      //   61: checkcast 93	java/lang/CharSequence
      //   64: astore 10
      //   66: aload 6
      //   68: aload 7
      //   70: aload 10
      //   72: invokestatic 99	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   75: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   78: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   81: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   84: if_acmpeq +18 -> 102
      //   87: aload_0
      //   88: aload 5
      //   90: getfield 84	gnu/kawa/slib/srfi37$frame1:args	Ljava/lang/Object;
      //   93: aload 5
      //   95: getfield 87	gnu/kawa/slib/srfi37$frame1:seeds	Ljava/lang/Object;
      //   98: invokevirtual 108	gnu/kawa/slib/srfi37$frame:lambda5scanArgs	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   101: areturn
      //   102: aload 5
      //   104: getfield 81	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   107: astore 11
      //   109: aload 11
      //   111: checkcast 93	java/lang/CharSequence
      //   114: astore 13
      //   116: aload 5
      //   118: getfield 78	gnu/kawa/slib/srfi37$frame1:index	Ljava/lang/Object;
      //   121: astore 14
      //   123: aload 14
      //   125: checkcast 110	java/lang/Number
      //   128: invokevirtual 114	java/lang/Number:intValue	()I
      //   131: istore 16
      //   133: aload 5
      //   135: aload 13
      //   137: iload 16
      //   139: invokestatic 118	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   142: putfield 121	gnu/kawa/slib/srfi37$frame1:name	C
      //   145: aload_0
      //   146: aload 5
      //   148: getfield 121	gnu/kawa/slib/srfi37$frame1:name	C
      //   151: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   154: invokevirtual 129	gnu/kawa/slib/srfi37$frame:lambda2findOption	(Ljava/lang/Object;)Ljava/lang/Object;
      //   157: astore 17
      //   159: aload 17
      //   161: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   164: if_acmpeq +132 -> 296
      //   167: aload 17
      //   169: astore 18
      //   171: aload 5
      //   173: aload 18
      //   175: putfield 132	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   178: getstatic 135	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   181: astore 19
      //   183: getstatic 141	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   186: aload 5
      //   188: getfield 78	gnu/kawa/slib/srfi37$frame1:index	Ljava/lang/Object;
      //   191: getstatic 147	gnu/kawa/slib/srfi37:Lit0	Lgnu/math/IntNum;
      //   194: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   197: astore 20
      //   199: aload 5
      //   201: getfield 81	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   204: astore 21
      //   206: aload 21
      //   208: checkcast 93	java/lang/CharSequence
      //   211: astore 23
      //   213: aload 19
      //   215: aload 20
      //   217: aload 23
      //   219: invokestatic 99	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   222: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   225: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   228: astore 24
      //   230: aload 24
      //   232: checkcast 22	java/lang/Boolean
      //   235: invokevirtual 151	java/lang/Boolean:booleanValue	()Z
      //   238: istore 26
      //   240: iload 26
      //   242: ifeq +162 -> 404
      //   245: aload 5
      //   247: getfield 132	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   250: astore 31
      //   252: aload 31
      //   254: checkcast 153	gnu/kawa/slib/option$Mntype
      //   257: astore 33
      //   259: aload 33
      //   261: invokestatic 157	gnu/kawa/slib/srfi37:isOptionRequiredArg	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
      //   264: astore 34
      //   266: aload 34
      //   268: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   271: if_acmpeq +54 -> 325
      //   274: aload 34
      //   276: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   279: if_acmpeq +71 -> 350
      //   282: aload 5
      //   284: getfield 160	gnu/kawa/slib/srfi37$frame1:lambda$Fn3	Lgnu/expr/ModuleMethod;
      //   287: aload 5
      //   289: getfield 163	gnu/kawa/slib/srfi37$frame1:lambda$Fn4	Lgnu/expr/ModuleMethod;
      //   292: invokestatic 169	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   295: areturn
      //   296: aload 5
      //   298: getfield 121	gnu/kawa/slib/srfi37$frame1:name	C
      //   301: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   304: invokestatic 175	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   307: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   310: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   313: aload_0
      //   314: getfield 177	gnu/kawa/slib/srfi37$frame:unrecognized$Mnoption$Mnproc	Ljava/lang/Object;
      //   317: invokestatic 180	gnu/kawa/slib/srfi37:option	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/slib/option$Mntype;
      //   320: astore 18
      //   322: goto -151 -> 171
      //   325: aload 5
      //   327: getfield 132	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   330: astore 35
      //   332: aload 35
      //   334: checkcast 153	gnu/kawa/slib/option$Mntype
      //   337: astore 37
      //   339: aload 37
      //   341: invokestatic 183	gnu/kawa/slib/srfi37:isOptionOptionalArg	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
      //   344: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   347: if_acmpne -65 -> 282
      //   350: aload 5
      //   352: getfield 132	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   355: astore 27
      //   357: aload 27
      //   359: checkcast 153	gnu/kawa/slib/option$Mntype
      //   362: astore 29
      //   364: aload 29
      //   366: invokestatic 157	gnu/kawa/slib/srfi37:isOptionRequiredArg	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
      //   369: astore 30
      //   371: aload 30
      //   373: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   376: if_acmpeq +36 -> 412
      //   379: aload 5
      //   381: getfield 84	gnu/kawa/slib/srfi37$frame1:args	Ljava/lang/Object;
      //   384: invokestatic 186	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   387: ifeq +33 -> 420
      //   390: aload 5
      //   392: getfield 189	gnu/kawa/slib/srfi37$frame1:lambda$Fn5	Lgnu/expr/ModuleMethod;
      //   395: aload 5
      //   397: getfield 192	gnu/kawa/slib/srfi37$frame1:lambda$Fn6	Lgnu/expr/ModuleMethod;
      //   400: invokestatic 169	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   403: areturn
      //   404: iload 26
      //   406: ifeq -56 -> 350
      //   409: goto -127 -> 282
      //   412: aload 30
      //   414: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   417: if_acmpne -27 -> 390
      //   420: aload 5
      //   422: getfield 195	gnu/kawa/slib/srfi37$frame1:lambda$Fn7	Lgnu/expr/ModuleMethod;
      //   425: aload 5
      //   427: getfield 198	gnu/kawa/slib/srfi37$frame1:lambda$Fn8	Lgnu/expr/ModuleMethod;
      //   430: invokestatic 169	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   433: areturn
      //   434: astore 9
      //   436: new 200	gnu/mapping/WrongType
      //   439: dup
      //   440: aload 9
      //   442: ldc 202
      //   444: iconst_1
      //   445: aload 8
      //   447: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   450: athrow
      //   451: astore 12
      //   453: new 200	gnu/mapping/WrongType
      //   456: dup
      //   457: aload 12
      //   459: ldc 207
      //   461: iconst_1
      //   462: aload 11
      //   464: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   467: athrow
      //   468: astore 15
      //   470: new 200	gnu/mapping/WrongType
      //   473: dup
      //   474: aload 15
      //   476: ldc 207
      //   478: iconst_2
      //   479: aload 14
      //   481: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   484: athrow
      //   485: astore 22
      //   487: new 200	gnu/mapping/WrongType
      //   490: dup
      //   491: aload 22
      //   493: ldc 202
      //   495: iconst_1
      //   496: aload 21
      //   498: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   501: athrow
      //   502: astore 25
      //   504: new 200	gnu/mapping/WrongType
      //   507: dup
      //   508: aload 25
      //   510: ldc 209
      //   512: bipush 254
      //   514: aload 24
      //   516: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   519: athrow
      //   520: astore 32
      //   522: new 200	gnu/mapping/WrongType
      //   525: dup
      //   526: aload 32
      //   528: ldc 211
      //   530: iconst_0
      //   531: aload 31
      //   533: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   536: athrow
      //   537: astore 36
      //   539: new 200	gnu/mapping/WrongType
      //   542: dup
      //   543: aload 36
      //   545: ldc 213
      //   547: iconst_0
      //   548: aload 35
      //   550: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   553: athrow
      //   554: astore 28
      //   556: new 200	gnu/mapping/WrongType
      //   559: dup
      //   560: aload 28
      //   562: ldc 211
      //   564: iconst_0
      //   565: aload 27
      //   567: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   570: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   59	66	434	java/lang/ClassCastException
      //   109	116	451	java/lang/ClassCastException
      //   123	133	468	java/lang/ClassCastException
      //   206	213	485	java/lang/ClassCastException
      //   230	240	502	java/lang/ClassCastException
      //   252	259	520	java/lang/ClassCastException
      //   332	339	537	java/lang/ClassCastException
      //   357	364	554	java/lang/ClassCastException
    }

    public Object lambda4scanOperands(Object paramObject1, Object paramObject2)
    {
      srfi37.frame2 localframe2 = new srfi37.frame2();
      localframe2.staticLink = this;
      localframe2.operands = paramObject1;
      localframe2.seeds = paramObject2;
      if (lists.isNull(localframe2.operands))
        return Scheme.apply.apply2(misc.values, localframe2.seeds);
      return call_with_values.callWithValues(localframe2.lambda$Fn9, localframe2.lambda$Fn10);
    }

    // ERROR //
    public Object lambda5scanArgs(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: new 239	gnu/kawa/slib/srfi37$frame3
      //   3: dup
      //   4: invokespecial 240	gnu/kawa/slib/srfi37$frame3:<init>	()V
      //   7: astore_3
      //   8: aload_3
      //   9: aload_0
      //   10: putfield 241	gnu/kawa/slib/srfi37$frame3:staticLink	Lgnu/kawa/slib/srfi37$frame;
      //   13: aload_3
      //   14: aload_2
      //   15: putfield 242	gnu/kawa/slib/srfi37$frame3:seeds	Ljava/lang/Object;
      //   18: aload_1
      //   19: invokestatic 20	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   22: ifeq +17 -> 39
      //   25: getstatic 226	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   28: getstatic 231	kawa/lib/misc:values	Lgnu/expr/ModuleMethod;
      //   31: aload_3
      //   32: getfield 242	gnu/kawa/slib/srfi37$frame3:seeds	Ljava/lang/Object;
      //   35: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   38: areturn
      //   39: getstatic 36	kawa/lib/lists:car	Lgnu/expr/GenericProc;
      //   42: aload_1
      //   43: invokevirtual 42	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   46: astore 4
      //   48: aload_3
      //   49: getstatic 48	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   52: aload_1
      //   53: invokevirtual 42	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   56: putfield 243	gnu/kawa/slib/srfi37$frame3:args	Ljava/lang/Object;
      //   59: aload_3
      //   60: aload 4
      //   62: putfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   65: ldc 248
      //   67: aload_3
      //   68: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   71: invokestatic 252	kawa/lib/strings:isString$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   74: ifeq +16 -> 90
      //   77: aload_0
      //   78: aload_3
      //   79: getfield 243	gnu/kawa/slib/srfi37$frame3:args	Ljava/lang/Object;
      //   82: aload_3
      //   83: getfield 242	gnu/kawa/slib/srfi37$frame3:seeds	Ljava/lang/Object;
      //   86: invokevirtual 254	gnu/kawa/slib/srfi37$frame:lambda4scanOperands	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   89: areturn
      //   90: aload_3
      //   91: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   94: astore 5
      //   96: aload 5
      //   98: checkcast 93	java/lang/CharSequence
      //   101: astore 7
      //   103: aload 7
      //   105: invokestatic 99	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   108: iconst_4
      //   109: if_icmple +209 -> 318
      //   112: iconst_1
      //   113: istore 8
      //   115: iload 8
      //   117: ifeq +339 -> 456
      //   120: getstatic 258	gnu/kawa/slib/srfi37:Lit1	Lgnu/text/Char;
      //   123: astore 50
      //   125: aload_3
      //   126: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   129: astore 51
      //   131: aload 51
      //   133: checkcast 93	java/lang/CharSequence
      //   136: astore 53
      //   138: aload 50
      //   140: aload 53
      //   142: iconst_0
      //   143: invokestatic 118	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   146: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   149: invokestatic 264	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   152: istore 54
      //   154: iload 54
      //   156: ifeq +279 -> 435
      //   159: getstatic 258	gnu/kawa/slib/srfi37:Lit1	Lgnu/text/Char;
      //   162: astore 55
      //   164: aload_3
      //   165: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   168: astore 56
      //   170: aload 56
      //   172: checkcast 93	java/lang/CharSequence
      //   175: astore 58
      //   177: aload 55
      //   179: aload 58
      //   181: iconst_1
      //   182: invokestatic 118	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   185: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   188: invokestatic 264	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   191: istore 59
      //   193: iload 59
      //   195: ifeq +219 -> 414
      //   198: getstatic 267	gnu/kawa/slib/srfi37:Lit2	Lgnu/text/Char;
      //   201: astore 60
      //   203: aload_3
      //   204: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   207: astore 61
      //   209: aload 61
      //   211: checkcast 93	java/lang/CharSequence
      //   214: astore 63
      //   216: iconst_1
      //   217: iconst_1
      //   218: aload 60
      //   220: aload 63
      //   222: iconst_2
      //   223: invokestatic 118	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   226: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   229: invokestatic 264	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   232: iadd
      //   233: iand
      //   234: istore 64
      //   236: iload 64
      //   238: ifeq +155 -> 393
      //   241: getstatic 270	gnu/kawa/slib/srfi37:Lit3	Lgnu/math/IntNum;
      //   244: astore 65
      //   246: getstatic 91	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   249: astore 66
      //   251: aload_3
      //   252: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   255: astore 67
      //   257: aload 67
      //   259: checkcast 93	java/lang/CharSequence
      //   262: astore 69
      //   264: aload 66
      //   266: aload 65
      //   268: aload 69
      //   270: invokestatic 99	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   273: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   276: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   279: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   282: if_acmpeq +42 -> 324
      //   285: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   288: astore 9
      //   290: aload_3
      //   291: aload 9
      //   293: putfield 273	gnu/kawa/slib/srfi37$frame3:temp	Ljava/lang/Object;
      //   296: aload_3
      //   297: getfield 273	gnu/kawa/slib/srfi37$frame3:temp	Ljava/lang/Object;
      //   300: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   303: if_acmpeq +174 -> 477
      //   306: aload_3
      //   307: getfield 276	gnu/kawa/slib/srfi37$frame3:lambda$Fn11	Lgnu/expr/ModuleMethod;
      //   310: aload_3
      //   311: getfield 279	gnu/kawa/slib/srfi37$frame3:lambda$Fn12	Lgnu/expr/ModuleMethod;
      //   314: invokestatic 169	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   317: areturn
      //   318: iconst_0
      //   319: istore 8
      //   321: goto -206 -> 115
      //   324: getstatic 267	gnu/kawa/slib/srfi37:Lit2	Lgnu/text/Char;
      //   327: astore 70
      //   329: aload_3
      //   330: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   333: astore 71
      //   335: aload 71
      //   337: checkcast 93	java/lang/CharSequence
      //   340: astore 73
      //   342: aload 65
      //   344: checkcast 110	java/lang/Number
      //   347: invokevirtual 114	java/lang/Number:intValue	()I
      //   350: istore 75
      //   352: aload 70
      //   354: aload 73
      //   356: iload 75
      //   358: invokestatic 118	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   361: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   364: invokestatic 264	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   367: ifeq +10 -> 377
      //   370: aload 65
      //   372: astore 9
      //   374: goto -84 -> 290
      //   377: getstatic 141	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   380: getstatic 147	gnu/kawa/slib/srfi37:Lit0	Lgnu/math/IntNum;
      //   383: aload 65
      //   385: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   388: astore 65
      //   390: goto -144 -> 246
      //   393: iload 64
      //   395: ifeq +11 -> 406
      //   398: getstatic 282	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   401: astore 9
      //   403: goto -113 -> 290
      //   406: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   409: astore 9
      //   411: goto -121 -> 290
      //   414: iload 59
      //   416: ifeq +11 -> 427
      //   419: getstatic 282	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   422: astore 9
      //   424: goto -134 -> 290
      //   427: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   430: astore 9
      //   432: goto -142 -> 290
      //   435: iload 54
      //   437: ifeq +11 -> 448
      //   440: getstatic 282	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   443: astore 9
      //   445: goto -155 -> 290
      //   448: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   451: astore 9
      //   453: goto -163 -> 290
      //   456: iload 8
      //   458: ifeq +11 -> 469
      //   461: getstatic 282	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   464: astore 9
      //   466: goto -176 -> 290
      //   469: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   472: astore 9
      //   474: goto -184 -> 290
      //   477: aload_3
      //   478: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   481: astore 10
      //   483: aload 10
      //   485: checkcast 93	java/lang/CharSequence
      //   488: astore 12
      //   490: aload 12
      //   492: invokestatic 99	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   495: iconst_3
      //   496: if_icmple +204 -> 700
      //   499: iconst_1
      //   500: istore 13
      //   502: iload 13
      //   504: ifeq +329 -> 833
      //   507: getstatic 258	gnu/kawa/slib/srfi37:Lit1	Lgnu/text/Char;
      //   510: astore 41
      //   512: aload_3
      //   513: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   516: astore 42
      //   518: aload 42
      //   520: checkcast 93	java/lang/CharSequence
      //   523: astore 44
      //   525: aload 41
      //   527: aload 44
      //   529: iconst_0
      //   530: invokestatic 118	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   533: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   536: invokestatic 264	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   539: istore 45
      //   541: iload 45
      //   543: ifeq +163 -> 706
      //   546: getstatic 258	gnu/kawa/slib/srfi37:Lit1	Lgnu/text/Char;
      //   549: astore 46
      //   551: aload_3
      //   552: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   555: astore 47
      //   557: aload 47
      //   559: checkcast 93	java/lang/CharSequence
      //   562: astore 49
      //   564: aload 46
      //   566: aload 49
      //   568: iconst_1
      //   569: invokestatic 118	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   572: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   575: invokestatic 264	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   578: ifeq +133 -> 711
      //   581: aload_3
      //   582: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   585: astore 14
      //   587: aload 14
      //   589: checkcast 93	java/lang/CharSequence
      //   592: astore 16
      //   594: aload_3
      //   595: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   598: astore 17
      //   600: aload 17
      //   602: checkcast 93	java/lang/CharSequence
      //   605: astore 19
      //   607: aload_3
      //   608: aload 16
      //   610: iconst_2
      //   611: aload 19
      //   613: invokestatic 99	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   616: invokestatic 286	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   619: putfield 289	gnu/kawa/slib/srfi37$frame3:name	Ljava/lang/CharSequence;
      //   622: aload_0
      //   623: aload_3
      //   624: getfield 289	gnu/kawa/slib/srfi37$frame3:name	Ljava/lang/CharSequence;
      //   627: invokevirtual 129	gnu/kawa/slib/srfi37$frame:lambda2findOption	(Ljava/lang/Object;)Ljava/lang/Object;
      //   630: astore 20
      //   632: aload 20
      //   634: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   637: if_acmpeq +204 -> 841
      //   640: aload 20
      //   642: astore 21
      //   644: aload_3
      //   645: aload 21
      //   647: putfield 290	gnu/kawa/slib/srfi37$frame3:option	Ljava/lang/Object;
      //   650: aload_3
      //   651: getfield 290	gnu/kawa/slib/srfi37$frame3:option	Ljava/lang/Object;
      //   654: astore 22
      //   656: aload 22
      //   658: checkcast 153	gnu/kawa/slib/option$Mntype
      //   661: astore 24
      //   663: aload 24
      //   665: invokestatic 157	gnu/kawa/slib/srfi37:isOptionRequiredArg	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
      //   668: astore 25
      //   670: aload 25
      //   672: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   675: if_acmpeq +191 -> 866
      //   678: aload_3
      //   679: getfield 243	gnu/kawa/slib/srfi37$frame3:args	Ljava/lang/Object;
      //   682: invokestatic 186	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   685: ifeq +189 -> 874
      //   688: aload_3
      //   689: getfield 293	gnu/kawa/slib/srfi37$frame3:lambda$Fn19	Lgnu/expr/ModuleMethod;
      //   692: aload_3
      //   693: getfield 296	gnu/kawa/slib/srfi37$frame3:lambda$Fn20	Lgnu/expr/ModuleMethod;
      //   696: invokestatic 169	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   699: areturn
      //   700: iconst_0
      //   701: istore 13
      //   703: goto -201 -> 502
      //   706: iload 45
      //   708: ifne -127 -> 581
      //   711: aload_3
      //   712: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   715: astore 26
      //   717: aload 26
      //   719: checkcast 93	java/lang/CharSequence
      //   722: astore 28
      //   724: aload 28
      //   726: invokestatic 99	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   729: iconst_1
      //   730: if_icmple +156 -> 886
      //   733: iconst_1
      //   734: istore 29
      //   736: iload 29
      //   738: ifeq +154 -> 892
      //   741: getstatic 258	gnu/kawa/slib/srfi37:Lit1	Lgnu/text/Char;
      //   744: astore 37
      //   746: aload_3
      //   747: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   750: astore 38
      //   752: aload 38
      //   754: checkcast 93	java/lang/CharSequence
      //   757: astore 40
      //   759: aload 37
      //   761: aload 40
      //   763: iconst_0
      //   764: invokestatic 118	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   767: invokestatic 127	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   770: invokestatic 264	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   773: ifeq +124 -> 897
      //   776: aload_3
      //   777: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   780: astore 30
      //   782: aload 30
      //   784: checkcast 93	java/lang/CharSequence
      //   787: astore 32
      //   789: aload_3
      //   790: getfield 246	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   793: astore 33
      //   795: aload 33
      //   797: checkcast 93	java/lang/CharSequence
      //   800: astore 35
      //   802: aload 32
      //   804: iconst_1
      //   805: aload 35
      //   807: invokestatic 99	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   810: invokestatic 286	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   813: astore 36
      //   815: aload_0
      //   816: getstatic 299	gnu/kawa/slib/srfi37:Lit4	Lgnu/math/IntNum;
      //   819: aload 36
      //   821: aload_3
      //   822: getfield 243	gnu/kawa/slib/srfi37$frame3:args	Ljava/lang/Object;
      //   825: aload_3
      //   826: getfield 242	gnu/kawa/slib/srfi37$frame3:seeds	Ljava/lang/Object;
      //   829: invokevirtual 301	gnu/kawa/slib/srfi37$frame:lambda3scanShortOptions	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   832: areturn
      //   833: iload 13
      //   835: ifeq -124 -> 711
      //   838: goto -257 -> 581
      //   841: aload_3
      //   842: getfield 289	gnu/kawa/slib/srfi37$frame3:name	Ljava/lang/CharSequence;
      //   845: invokestatic 175	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   848: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   851: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   854: aload_0
      //   855: getfield 177	gnu/kawa/slib/srfi37$frame:unrecognized$Mnoption$Mnproc	Ljava/lang/Object;
      //   858: invokestatic 180	gnu/kawa/slib/srfi37:option	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/slib/option$Mntype;
      //   861: astore 21
      //   863: goto -219 -> 644
      //   866: aload 25
      //   868: getstatic 26	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   871: if_acmpne -183 -> 688
      //   874: aload_3
      //   875: getfield 304	gnu/kawa/slib/srfi37$frame3:lambda$Fn21	Lgnu/expr/ModuleMethod;
      //   878: aload_3
      //   879: getfield 307	gnu/kawa/slib/srfi37$frame3:lambda$Fn22	Lgnu/expr/ModuleMethod;
      //   882: invokestatic 169	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   885: areturn
      //   886: iconst_0
      //   887: istore 29
      //   889: goto -153 -> 736
      //   892: iload 29
      //   894: ifne -118 -> 776
      //   897: aload_3
      //   898: getfield 310	gnu/kawa/slib/srfi37$frame3:lambda$Fn23	Lgnu/expr/ModuleMethod;
      //   901: aload_3
      //   902: getfield 313	gnu/kawa/slib/srfi37$frame3:lambda$Fn24	Lgnu/expr/ModuleMethod;
      //   905: invokestatic 169	kawa/standard/call_with_values:callWithValues	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   908: areturn
      //   909: astore 6
      //   911: new 200	gnu/mapping/WrongType
      //   914: dup
      //   915: aload 6
      //   917: ldc 202
      //   919: iconst_1
      //   920: aload 5
      //   922: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   925: athrow
      //   926: astore 52
      //   928: new 200	gnu/mapping/WrongType
      //   931: dup
      //   932: aload 52
      //   934: ldc 207
      //   936: iconst_1
      //   937: aload 51
      //   939: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   942: athrow
      //   943: astore 57
      //   945: new 200	gnu/mapping/WrongType
      //   948: dup
      //   949: aload 57
      //   951: ldc 207
      //   953: iconst_1
      //   954: aload 56
      //   956: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   959: athrow
      //   960: astore 62
      //   962: new 200	gnu/mapping/WrongType
      //   965: dup
      //   966: aload 62
      //   968: ldc 207
      //   970: iconst_1
      //   971: aload 61
      //   973: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   976: athrow
      //   977: astore 68
      //   979: new 200	gnu/mapping/WrongType
      //   982: dup
      //   983: aload 68
      //   985: ldc 202
      //   987: iconst_1
      //   988: aload 67
      //   990: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   993: athrow
      //   994: astore 72
      //   996: new 200	gnu/mapping/WrongType
      //   999: dup
      //   1000: aload 72
      //   1002: ldc 207
      //   1004: iconst_1
      //   1005: aload 71
      //   1007: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1010: athrow
      //   1011: astore 74
      //   1013: new 200	gnu/mapping/WrongType
      //   1016: dup
      //   1017: aload 74
      //   1019: ldc 207
      //   1021: iconst_2
      //   1022: aload 65
      //   1024: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1027: athrow
      //   1028: astore 11
      //   1030: new 200	gnu/mapping/WrongType
      //   1033: dup
      //   1034: aload 11
      //   1036: ldc 202
      //   1038: iconst_1
      //   1039: aload 10
      //   1041: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1044: athrow
      //   1045: astore 43
      //   1047: new 200	gnu/mapping/WrongType
      //   1050: dup
      //   1051: aload 43
      //   1053: ldc 207
      //   1055: iconst_1
      //   1056: aload 42
      //   1058: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1061: athrow
      //   1062: astore 48
      //   1064: new 200	gnu/mapping/WrongType
      //   1067: dup
      //   1068: aload 48
      //   1070: ldc 207
      //   1072: iconst_1
      //   1073: aload 47
      //   1075: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1078: athrow
      //   1079: astore 15
      //   1081: new 200	gnu/mapping/WrongType
      //   1084: dup
      //   1085: aload 15
      //   1087: ldc_w 314
      //   1090: iconst_1
      //   1091: aload 14
      //   1093: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1096: athrow
      //   1097: astore 18
      //   1099: new 200	gnu/mapping/WrongType
      //   1102: dup
      //   1103: aload 18
      //   1105: ldc 202
      //   1107: iconst_1
      //   1108: aload 17
      //   1110: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1113: athrow
      //   1114: astore 23
      //   1116: new 200	gnu/mapping/WrongType
      //   1119: dup
      //   1120: aload 23
      //   1122: ldc 211
      //   1124: iconst_0
      //   1125: aload 22
      //   1127: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1130: athrow
      //   1131: astore 27
      //   1133: new 200	gnu/mapping/WrongType
      //   1136: dup
      //   1137: aload 27
      //   1139: ldc 202
      //   1141: iconst_1
      //   1142: aload 26
      //   1144: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1147: athrow
      //   1148: astore 39
      //   1150: new 200	gnu/mapping/WrongType
      //   1153: dup
      //   1154: aload 39
      //   1156: ldc 207
      //   1158: iconst_1
      //   1159: aload 38
      //   1161: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1164: athrow
      //   1165: astore 31
      //   1167: new 200	gnu/mapping/WrongType
      //   1170: dup
      //   1171: aload 31
      //   1173: ldc_w 314
      //   1176: iconst_1
      //   1177: aload 30
      //   1179: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1182: athrow
      //   1183: astore 34
      //   1185: new 200	gnu/mapping/WrongType
      //   1188: dup
      //   1189: aload 34
      //   1191: ldc 202
      //   1193: iconst_1
      //   1194: aload 33
      //   1196: invokespecial 205	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1199: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   96	103	909	java/lang/ClassCastException
      //   131	138	926	java/lang/ClassCastException
      //   170	177	943	java/lang/ClassCastException
      //   209	216	960	java/lang/ClassCastException
      //   257	264	977	java/lang/ClassCastException
      //   335	342	994	java/lang/ClassCastException
      //   342	352	1011	java/lang/ClassCastException
      //   483	490	1028	java/lang/ClassCastException
      //   518	525	1045	java/lang/ClassCastException
      //   557	564	1062	java/lang/ClassCastException
      //   587	594	1079	java/lang/ClassCastException
      //   600	607	1097	java/lang/ClassCastException
      //   656	663	1114	java/lang/ClassCastException
      //   717	724	1131	java/lang/ClassCastException
      //   752	759	1148	java/lang/ClassCastException
      //   782	789	1165	java/lang/ClassCastException
      //   795	802	1183	java/lang/ClassCastException
    }
  }

  public class frame0 extends ModuleBody
  {
    final ModuleMethod lambda$Fn1;
    final ModuleMethod lambda$Fn2;
    Object name;
    srfi37.frame staticLink;

    public frame0()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "srfi37.scm:75");
      this.lambda$Fn2 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 2, null, 4097);
      localModuleMethod.setProperty("source-location", "srfi37.scm:72");
      this.lambda$Fn1 = localModuleMethod;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.apply1(paramModuleMethod, paramObject);
      case 1:
        if (lambda7(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      case 2:
      }
      return lambda6(paramObject);
    }

    Object lambda6(Object paramObject)
    {
      try
      {
        option.Mntype localMntype = (option.Mntype)paramObject;
        return srfi37.frame.lambda1find(srfi37.optionNames(localMntype), this.lambda$Fn2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-names", 0, paramObject);
      }
    }

    boolean lambda7(Object paramObject)
    {
      return IsEqual.apply(this.name, paramObject);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
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
  }

  public class frame1 extends ModuleBody
  {
    Object args;
    Object index;
    final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn4 = new ModuleMethod(this, 4, null, -4096);
    final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 5, null, 0);
    final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 6, null, -4096);
    final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 7, null, 0);
    final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 8, null, -4096);
    char name;
    Object option;
    Object seeds;
    Object shorts;
    srfi37.frame staticLink;

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      case 4:
      case 6:
      default:
        return super.apply0(paramModuleMethod);
      case 3:
        return lambda8();
      case 5:
        return lambda10();
      case 7:
      }
      return lambda12();
    }

    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      switch (paramModuleMethod.selector)
      {
      case 5:
      case 7:
      default:
        return super.applyN(paramModuleMethod, paramArrayOfObject);
      case 4:
        return lambda9$V(paramArrayOfObject);
      case 6:
        return lambda11$V(paramArrayOfObject);
      case 8:
      }
      return lambda13$V(paramArrayOfObject);
    }

    Object lambda10()
    {
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[5];
      Object localObject = this.option;
      try
      {
        option.Mntype localMntype = (option.Mntype)localObject;
        arrayOfObject[0] = srfi37.optionProcessor(localMntype);
        arrayOfObject[1] = this.option;
        arrayOfObject[2] = Char.make(this.name);
        arrayOfObject[3] = lists.car.apply1(this.args);
        arrayOfObject[4] = this.seeds;
        return localApply.applyN(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-processor", 0, localObject);
      }
    }

    Object lambda11$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda5scanArgs(lists.cdr.apply1(this.args), localLList);
    }

    Object lambda12()
    {
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[5];
      Object localObject = this.option;
      try
      {
        option.Mntype localMntype = (option.Mntype)localObject;
        arrayOfObject[0] = srfi37.optionProcessor(localMntype);
        arrayOfObject[1] = this.option;
        arrayOfObject[2] = Char.make(this.name);
        arrayOfObject[3] = Boolean.FALSE;
        arrayOfObject[4] = this.seeds;
        return localApply.applyN(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-processor", 0, localObject);
      }
    }

    Object lambda13$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda3scanShortOptions(AddOp.$Pl.apply2(this.index, srfi37.Lit0), this.shorts, this.args, localLList);
    }

    // ERROR //
    Object lambda8()
    {
      // Byte code:
      //   0: getstatic 82	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   3: astore_1
      //   4: iconst_5
      //   5: anewarray 84	java/lang/Object
      //   8: astore_2
      //   9: aload_0
      //   10: getfield 86	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   13: astore_3
      //   14: aload_3
      //   15: checkcast 88	gnu/kawa/slib/option$Mntype
      //   18: astore 5
      //   20: aload_2
      //   21: iconst_0
      //   22: aload 5
      //   24: invokestatic 94	gnu/kawa/slib/srfi37:optionProcessor	(Lgnu/kawa/slib/option$Mntype;)Ljava/lang/Object;
      //   27: aastore
      //   28: aload_2
      //   29: iconst_1
      //   30: aload_0
      //   31: getfield 86	gnu/kawa/slib/srfi37$frame1:option	Ljava/lang/Object;
      //   34: aastore
      //   35: aload_2
      //   36: iconst_2
      //   37: aload_0
      //   38: getfield 96	gnu/kawa/slib/srfi37$frame1:name	C
      //   41: invokestatic 102	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   44: aastore
      //   45: aload_0
      //   46: getfield 167	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   49: astore 6
      //   51: aload 6
      //   53: checkcast 173	java/lang/CharSequence
      //   56: astore 8
      //   58: getstatic 156	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   61: aload_0
      //   62: getfield 158	gnu/kawa/slib/srfi37$frame1:index	Ljava/lang/Object;
      //   65: getstatic 162	gnu/kawa/slib/srfi37:Lit0	Lgnu/math/IntNum;
      //   68: invokevirtual 165	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   71: astore 9
      //   73: aload 9
      //   75: checkcast 175	java/lang/Number
      //   78: invokevirtual 179	java/lang/Number:intValue	()I
      //   81: istore 11
      //   83: aload_0
      //   84: getfield 167	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   87: astore 12
      //   89: aload 12
      //   91: checkcast 173	java/lang/CharSequence
      //   94: astore 14
      //   96: aload_2
      //   97: iconst_3
      //   98: aload 8
      //   100: iload 11
      //   102: aload 14
      //   104: invokestatic 185	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   107: invokestatic 189	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   110: aastore
      //   111: aload_2
      //   112: iconst_4
      //   113: aload_0
      //   114: getfield 118	gnu/kawa/slib/srfi37$frame1:seeds	Ljava/lang/Object;
      //   117: aastore
      //   118: aload_1
      //   119: aload_2
      //   120: invokevirtual 120	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   123: areturn
      //   124: astore 4
      //   126: new 122	gnu/mapping/WrongType
      //   129: dup
      //   130: aload 4
      //   132: ldc 124
      //   134: iconst_0
      //   135: aload_3
      //   136: invokespecial 127	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   139: athrow
      //   140: astore 7
      //   142: new 122	gnu/mapping/WrongType
      //   145: dup
      //   146: aload 7
      //   148: ldc 190
      //   150: iconst_1
      //   151: aload 6
      //   153: invokespecial 127	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   156: athrow
      //   157: astore 10
      //   159: new 122	gnu/mapping/WrongType
      //   162: dup
      //   163: aload 10
      //   165: ldc 190
      //   167: iconst_2
      //   168: aload 9
      //   170: invokespecial 127	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   173: athrow
      //   174: astore 13
      //   176: new 122	gnu/mapping/WrongType
      //   179: dup
      //   180: aload 13
      //   182: ldc 192
      //   184: iconst_1
      //   185: aload 12
      //   187: invokespecial 127	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   190: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   14	20	124	java/lang/ClassCastException
      //   51	58	140	java/lang/ClassCastException
      //   73	83	157	java/lang/ClassCastException
      //   89	96	174	java/lang/ClassCastException
    }

    Object lambda9$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda5scanArgs(this.args, localLList);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 4:
      case 6:
      default:
        return super.match0(paramModuleMethod, paramCallContext);
      case 7:
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 5:
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 3:
      }
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }

    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 5:
      case 7:
      default:
        return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
      case 8:
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      case 6:
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      case 4:
      }
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
  }

  public class frame2 extends ModuleBody
  {
    final ModuleMethod lambda$Fn10 = new ModuleMethod(this, 10, null, -4096);
    final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 9, null, 0);
    Object operands;
    Object seeds;
    srfi37.frame staticLink;

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 9)
        return lambda14();
      return super.apply0(paramModuleMethod);
    }

    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      if (paramModuleMethod.selector == 10)
        return lambda15$V(paramArrayOfObject);
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    }

    Object lambda14()
    {
      return Scheme.apply.apply3(this.staticLink.operand$Mnproc, lists.car.apply1(this.operands), this.seeds);
    }

    Object lambda15$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda4scanOperands(lists.cdr.apply1(this.operands), localLList);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 9)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 10)
      {
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      }
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
  }

  public class frame3 extends ModuleBody
  {
    Object arg;
    Object args;
    final ModuleMethod lambda$Fn11 = new ModuleMethod(this, 17, null, 0);
    final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 18, null, 4097);
    final ModuleMethod lambda$Fn19 = new ModuleMethod(this, 19, null, 0);
    final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 20, null, -4096);
    final ModuleMethod lambda$Fn21 = new ModuleMethod(this, 21, null, 0);
    final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 22, null, -4096);
    final ModuleMethod lambda$Fn23 = new ModuleMethod(this, 23, null, 0);
    final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 24, null, -4096);
    CharSequence name;
    Object option;
    Object seeds;
    srfi37.frame staticLink;
    Object temp;

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      case 18:
      case 20:
      case 22:
      default:
        return super.apply0(paramModuleMethod);
      case 17:
        return lambda16();
      case 19:
        return lambda24();
      case 21:
        return lambda26();
      case 23:
      }
      return lambda28();
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 18)
        return lambda17(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      switch (paramModuleMethod.selector)
      {
      case 21:
      case 23:
      default:
        return super.applyN(paramModuleMethod, paramArrayOfObject);
      case 20:
        return lambda25$V(paramArrayOfObject);
      case 22:
        return lambda27$V(paramArrayOfObject);
      case 24:
      }
      return lambda29$V(paramArrayOfObject);
    }

    // ERROR //
    CharSequence lambda16()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 96	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   4: astore_1
      //   5: aload_1
      //   6: checkcast 98	java/lang/CharSequence
      //   9: astore_3
      //   10: aload_0
      //   11: getfield 100	gnu/kawa/slib/srfi37$frame3:temp	Ljava/lang/Object;
      //   14: astore 4
      //   16: aload 4
      //   18: checkcast 102	java/lang/Number
      //   21: invokevirtual 106	java/lang/Number:intValue	()I
      //   24: istore 6
      //   26: aload_3
      //   27: iconst_2
      //   28: iload 6
      //   30: invokestatic 112	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   33: areturn
      //   34: astore_2
      //   35: new 114	gnu/mapping/WrongType
      //   38: dup
      //   39: aload_2
      //   40: ldc 115
      //   42: iconst_1
      //   43: aload_1
      //   44: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   47: athrow
      //   48: astore 5
      //   50: new 114	gnu/mapping/WrongType
      //   53: dup
      //   54: aload 5
      //   56: ldc 115
      //   58: iconst_3
      //   59: aload 4
      //   61: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   64: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   5	10	34	java/lang/ClassCastException
      //   16	26	48	java/lang/ClassCastException
    }

    Object lambda17(Object paramObject)
    {
      srfi37.frame4 localframe4 = new srfi37.frame4();
      localframe4.staticLink = this;
      localframe4.x = paramObject;
      return call_with_values.callWithValues(localframe4.lambda$Fn13, localframe4.lambda$Fn14);
    }

    Object lambda24()
    {
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[5];
      Object localObject = this.option;
      try
      {
        option.Mntype localMntype = (option.Mntype)localObject;
        arrayOfObject[0] = srfi37.optionProcessor(localMntype);
        arrayOfObject[1] = this.option;
        arrayOfObject[2] = this.name;
        arrayOfObject[3] = lists.car.apply1(this.args);
        arrayOfObject[4] = this.seeds;
        return localApply.applyN(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-processor", 0, localObject);
      }
    }

    Object lambda25$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda5scanArgs(lists.cdr.apply1(this.args), localLList);
    }

    Object lambda26()
    {
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[5];
      Object localObject = this.option;
      try
      {
        option.Mntype localMntype = (option.Mntype)localObject;
        arrayOfObject[0] = srfi37.optionProcessor(localMntype);
        arrayOfObject[1] = this.option;
        arrayOfObject[2] = this.name;
        arrayOfObject[3] = Boolean.FALSE;
        arrayOfObject[4] = this.seeds;
        return localApply.applyN(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-processor", 0, localObject);
      }
    }

    Object lambda27$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda5scanArgs(this.args, localLList);
    }

    Object lambda28()
    {
      return Scheme.apply.apply3(this.staticLink.operand$Mnproc, this.arg, this.seeds);
    }

    Object lambda29$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.lambda5scanArgs(this.args, localLList);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 18:
      case 20:
      case 22:
      default:
        return super.match0(paramModuleMethod, paramCallContext);
      case 23:
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
      case 17:
      }
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 18)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }

    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 21:
      case 23:
      default:
        return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
      case 24:
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      case 22:
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      case 20:
      }
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
  }

  public class frame4 extends ModuleBody
  {
    final ModuleMethod lambda$Fn13 = new ModuleMethod(this, 15, null, 0);
    final ModuleMethod lambda$Fn14 = new ModuleMethod(this, 16, null, 4097);
    srfi37.frame3 staticLink;
    Object x;

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 15)
        return lambda18();
      return super.apply0(paramModuleMethod);
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 16)
        return lambda19(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    // ERROR //
    CharSequence lambda18()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 48	gnu/kawa/slib/srfi37$frame4:staticLink	Lgnu/kawa/slib/srfi37$frame3;
      //   4: getfield 53	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   7: astore_1
      //   8: aload_1
      //   9: checkcast 55	java/lang/CharSequence
      //   12: astore_3
      //   13: getstatic 61	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   16: aload_0
      //   17: getfield 48	gnu/kawa/slib/srfi37$frame4:staticLink	Lgnu/kawa/slib/srfi37$frame3;
      //   20: getfield 64	gnu/kawa/slib/srfi37$frame3:temp	Ljava/lang/Object;
      //   23: getstatic 70	gnu/kawa/slib/srfi37:Lit0	Lgnu/math/IntNum;
      //   26: invokevirtual 76	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   29: astore 4
      //   31: aload 4
      //   33: checkcast 78	java/lang/Number
      //   36: invokevirtual 82	java/lang/Number:intValue	()I
      //   39: istore 6
      //   41: aload_0
      //   42: getfield 48	gnu/kawa/slib/srfi37$frame4:staticLink	Lgnu/kawa/slib/srfi37$frame3;
      //   45: getfield 53	gnu/kawa/slib/srfi37$frame3:arg	Ljava/lang/Object;
      //   48: astore 7
      //   50: aload 7
      //   52: checkcast 55	java/lang/CharSequence
      //   55: astore 9
      //   57: aload_3
      //   58: iload 6
      //   60: aload 9
      //   62: invokestatic 88	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   65: invokestatic 92	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   68: areturn
      //   69: astore_2
      //   70: new 94	gnu/mapping/WrongType
      //   73: dup
      //   74: aload_2
      //   75: ldc 95
      //   77: iconst_1
      //   78: aload_1
      //   79: invokespecial 98	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   82: athrow
      //   83: astore 5
      //   85: new 94	gnu/mapping/WrongType
      //   88: dup
      //   89: aload 5
      //   91: ldc 95
      //   93: iconst_2
      //   94: aload 4
      //   96: invokespecial 98	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   99: athrow
      //   100: astore 8
      //   102: new 94	gnu/mapping/WrongType
      //   105: dup
      //   106: aload 8
      //   108: ldc 100
      //   110: iconst_1
      //   111: aload 7
      //   113: invokespecial 98	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   116: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   8	13	69	java/lang/ClassCastException
      //   31	41	83	java/lang/ClassCastException
      //   50	57	100	java/lang/ClassCastException
    }

    Object lambda19(Object paramObject)
    {
      srfi37.frame5 localframe5 = new srfi37.frame5();
      localframe5.staticLink = this;
      localframe5.x = paramObject;
      return call_with_values.callWithValues(localframe5.lambda$Fn15, localframe5.lambda$Fn16);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 16)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame5 extends ModuleBody
  {
    final ModuleMethod lambda$Fn15 = new ModuleMethod(this, 13, null, 0);
    final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 14, null, 4097);
    srfi37.frame4 staticLink;
    Object x;

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 13)
        return lambda20();
      return super.apply0(paramModuleMethod);
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 14)
        return lambda21(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda20()
    {
      Object localObject = this.staticLink.staticLink.staticLink.lambda2findOption(this.staticLink.x);
      if (localObject != Boolean.FALSE)
        return localObject;
      return srfi37.option(LList.list1(this.staticLink.x), Boolean.TRUE, Boolean.FALSE, this.staticLink.staticLink.staticLink.unrecognized$Mnoption$Mnproc);
    }

    Object lambda21(Object paramObject)
    {
      srfi37.frame6 localframe6 = new srfi37.frame6();
      localframe6.staticLink = this;
      localframe6.x = paramObject;
      return call_with_values.callWithValues(localframe6.lambda$Fn17, localframe6.lambda$Fn18);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 13)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 14)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame6 extends ModuleBody
  {
    final ModuleMethod lambda$Fn17 = new ModuleMethod(this, 11, null, 0);
    final ModuleMethod lambda$Fn18 = new ModuleMethod(this, 12, null, -4096);
    srfi37.frame5 staticLink;
    Object x;

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 11)
        return lambda22();
      return super.apply0(paramModuleMethod);
    }

    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      if (paramModuleMethod.selector == 12)
        return lambda23$V(paramArrayOfObject);
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    }

    Object lambda22()
    {
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[5];
      Object localObject = this.x;
      try
      {
        option.Mntype localMntype = (option.Mntype)localObject;
        arrayOfObject[0] = srfi37.optionProcessor(localMntype);
        arrayOfObject[1] = this.x;
        arrayOfObject[2] = this.staticLink.staticLink.x;
        arrayOfObject[3] = this.staticLink.x;
        arrayOfObject[4] = this.staticLink.staticLink.staticLink.seeds;
        return localApply.applyN(arrayOfObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "option-processor", 0, localObject);
      }
    }

    Object lambda23$V(Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      return this.staticLink.staticLink.staticLink.staticLink.lambda5scanArgs(this.staticLink.staticLink.staticLink.args, localLList);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 11)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 12)
      {
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      }
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.srfi37
 * JD-Core Version:    0.6.2
 */