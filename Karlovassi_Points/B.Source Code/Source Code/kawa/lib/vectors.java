package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;

public class vectors extends ModuleBody
{
  public static final vectors $instance;
  static final Keyword Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8 = (SimpleSymbol)new SimpleSymbol("vector-fill!").readResolve();
  public static final ModuleMethod list$Mn$Grvector;
  public static final ModuleMethod make$Mnvector;
  public static final ModuleMethod vector$Mn$Grlist;
  public static final ModuleMethod vector$Mnfill$Ex;
  public static final ModuleMethod vector$Mnlength;
  public static final GenericProc vector$Mnref;
  static final ModuleMethod vector$Mnref$Fn1;
  public static final ModuleMethod vector$Mnset$Ex;
  public static final ModuleMethod vector$Qu;

  static
  {
    Lit7 = (SimpleSymbol)new SimpleSymbol("list->vector").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("vector->list").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("vector-ref").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("vector-set!").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("vector-length").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("make-vector").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("vector?").readResolve();
    Lit0 = Keyword.make("setter");
    $instance = new vectors();
    vectors localvectors = $instance;
    vector$Qu = new ModuleMethod(localvectors, 1, Lit1, 4097);
    make$Mnvector = new ModuleMethod(localvectors, 2, Lit2, 8193);
    vector$Mnlength = new ModuleMethod(localvectors, 4, Lit3, 4097);
    vector$Mnset$Ex = new ModuleMethod(localvectors, 5, Lit4, 12291);
    vector$Mnref$Fn1 = new ModuleMethod(localvectors, 6, Lit5, 8194);
    vector$Mn$Grlist = new ModuleMethod(localvectors, 7, Lit6, 4097);
    list$Mn$Grvector = new ModuleMethod(localvectors, 8, Lit7, 4097);
    vector$Mnfill$Ex = new ModuleMethod(localvectors, 9, Lit8, 8194);
    $instance.run();
  }

  public vectors()
  {
    ModuleInfo.register(this);
  }

  public static boolean isVector(Object paramObject)
  {
    return paramObject instanceof FVector;
  }

  public static FVector list$To$Vector(LList paramLList)
  {
    return new FVector(paramLList);
  }

  public static FVector makeVector(int paramInt)
  {
    return makeVector(paramInt, Special.undefined);
  }

  public static FVector makeVector(int paramInt, Object paramObject)
  {
    return new FVector(paramInt, paramObject);
  }

  public static LList vector$To$List(FVector paramFVector)
  {
    Object localObject = LList.Empty;
    int j;
    for (int i = vectorLength(paramFVector); ; i = j)
    {
      j = i - 1;
      if (j < 0)
        return localObject;
      localObject = lists.cons(vector$Mnref.apply2(paramFVector, Integer.valueOf(j)), localObject);
    }
  }

  public static void vectorFill$Ex(FVector paramFVector, Object paramObject)
  {
    paramFVector.setAll(paramObject);
  }

  public static int vectorLength(FVector paramFVector)
  {
    return paramFVector.size();
  }

  public static Object vectorRef(FVector paramFVector, int paramInt)
  {
    return paramFVector.get(paramInt);
  }

  public static void vectorSet$Ex(FVector paramFVector, int paramInt, Object paramObject)
  {
    paramFVector.set(paramInt, paramObject);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 201	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+48 -> 52, 1:+55->59, 2:+70->74, 3:+48->52, 4:+85->89, 5:+48->52, 6:+48->52, 7:+100->104, 8:+112->116
    //   53: aload_1
    //   54: aload_2
    //   55: invokespecial 203	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: areturn
    //   59: aload_2
    //   60: invokestatic 205	kawa/lib/vectors:isVector	(Ljava/lang/Object;)Z
    //   63: ifeq +7 -> 70
    //   66: getstatic 211	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   69: areturn
    //   70: getstatic 214	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   73: areturn
    //   74: aload_2
    //   75: checkcast 216	java/lang/Number
    //   78: invokevirtual 219	java/lang/Number:intValue	()I
    //   81: istore 10
    //   83: iload 10
    //   85: invokestatic 221	kawa/lib/vectors:makeVector	(I)Lgnu/lists/FVector;
    //   88: areturn
    //   89: aload_2
    //   90: checkcast 121	gnu/lists/FVector
    //   93: astore 8
    //   95: aload 8
    //   97: invokestatic 152	kawa/lib/vectors:vectorLength	(Lgnu/lists/FVector;)I
    //   100: invokestatic 160	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: areturn
    //   104: aload_2
    //   105: checkcast 121	gnu/lists/FVector
    //   108: astore 6
    //   110: aload 6
    //   112: invokestatic 223	kawa/lib/vectors:vector$To$List	(Lgnu/lists/FVector;)Lgnu/lists/LList;
    //   115: areturn
    //   116: aload_2
    //   117: checkcast 144	gnu/lists/LList
    //   120: astore 4
    //   122: aload 4
    //   124: invokestatic 225	kawa/lib/vectors:list$To$Vector	(Lgnu/lists/LList;)Lgnu/lists/FVector;
    //   127: areturn
    //   128: astore 9
    //   130: new 227	gnu/mapping/WrongType
    //   133: dup
    //   134: aload 9
    //   136: ldc 66
    //   138: iconst_1
    //   139: aload_2
    //   140: invokespecial 230	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   143: athrow
    //   144: astore 7
    //   146: new 227	gnu/mapping/WrongType
    //   149: dup
    //   150: aload 7
    //   152: ldc 62
    //   154: iconst_1
    //   155: aload_2
    //   156: invokespecial 230	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    //   160: astore 5
    //   162: new 227	gnu/mapping/WrongType
    //   165: dup
    //   166: aload 5
    //   168: ldc 50
    //   170: iconst_1
    //   171: aload_2
    //   172: invokespecial 230	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   175: athrow
    //   176: astore_3
    //   177: new 227	gnu/mapping/WrongType
    //   180: dup
    //   181: aload_3
    //   182: ldc 46
    //   184: iconst_1
    //   185: aload_2
    //   186: invokespecial 230	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   189: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   74	83	128	java/lang/ClassCastException
    //   89	95	144	java/lang/ClassCastException
    //   104	110	160	java/lang/ClassCastException
    //   116	122	176	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 201	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+36->40, 2:+44->48, 6:+60->64, 9:+83->87
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: invokespecial 233	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: areturn
    //   48: aload_2
    //   49: checkcast 216	java/lang/Number
    //   52: invokevirtual 219	java/lang/Number:intValue	()I
    //   55: istore 11
    //   57: iload 11
    //   59: aload_3
    //   60: invokestatic 137	kawa/lib/vectors:makeVector	(ILjava/lang/Object;)Lgnu/lists/FVector;
    //   63: areturn
    //   64: aload_2
    //   65: checkcast 121	gnu/lists/FVector
    //   68: astore 7
    //   70: aload_3
    //   71: checkcast 216	java/lang/Number
    //   74: invokevirtual 219	java/lang/Number:intValue	()I
    //   77: istore 9
    //   79: aload 7
    //   81: iload 9
    //   83: invokestatic 235	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
    //   86: areturn
    //   87: aload_2
    //   88: checkcast 121	gnu/lists/FVector
    //   91: astore 5
    //   93: aload 5
    //   95: aload_3
    //   96: invokestatic 237	kawa/lib/vectors:vectorFill$Ex	(Lgnu/lists/FVector;Ljava/lang/Object;)V
    //   99: getstatic 243	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   102: areturn
    //   103: astore 10
    //   105: new 227	gnu/mapping/WrongType
    //   108: dup
    //   109: aload 10
    //   111: ldc 66
    //   113: iconst_1
    //   114: aload_2
    //   115: invokespecial 230	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   118: athrow
    //   119: astore 6
    //   121: new 227	gnu/mapping/WrongType
    //   124: dup
    //   125: aload 6
    //   127: ldc 54
    //   129: iconst_1
    //   130: aload_2
    //   131: invokespecial 230	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   134: athrow
    //   135: astore 8
    //   137: new 227	gnu/mapping/WrongType
    //   140: dup
    //   141: aload 8
    //   143: ldc 54
    //   145: iconst_2
    //   146: aload_3
    //   147: invokespecial 230	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   150: athrow
    //   151: astore 4
    //   153: new 227	gnu/mapping/WrongType
    //   156: dup
    //   157: aload 4
    //   159: ldc 34
    //   161: iconst_1
    //   162: aload_2
    //   163: invokespecial 230	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   166: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   48	57	103	java/lang/ClassCastException
    //   64	70	119	java/lang/ClassCastException
    //   70	79	135	java/lang/ClassCastException
    //   87	93	151	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 201	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_5
    //   5: if_icmpne +31 -> 36
    //   8: aload_2
    //   9: checkcast 121	gnu/lists/FVector
    //   12: astore 6
    //   14: aload_3
    //   15: checkcast 216	java/lang/Number
    //   18: invokevirtual 219	java/lang/Number:intValue	()I
    //   21: istore 8
    //   23: aload 6
    //   25: iload 8
    //   27: aload 4
    //   29: invokestatic 247	kawa/lib/vectors:vectorSet$Ex	(Lgnu/lists/FVector;ILjava/lang/Object;)V
    //   32: getstatic 243	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   35: areturn
    //   36: aload_0
    //   37: aload_1
    //   38: aload_2
    //   39: aload_3
    //   40: aload 4
    //   42: invokespecial 249	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   45: areturn
    //   46: astore 5
    //   48: new 227	gnu/mapping/WrongType
    //   51: dup
    //   52: aload 5
    //   54: ldc 58
    //   56: iconst_1
    //   57: aload_2
    //   58: invokespecial 230	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   61: athrow
    //   62: astore 7
    //   64: new 227	gnu/mapping/WrongType
    //   67: dup
    //   68: aload 7
    //   70: ldc 58
    //   72: iconst_2
    //   73: aload_3
    //   74: invokespecial 230	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   77: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   8	14	46	java/lang/ClassCastException
    //   14	23	62	java/lang/ClassCastException
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 3:
    case 5:
    case 6:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 8:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 7:
      if ((paramObject instanceof FVector))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 4:
      if ((paramObject instanceof FVector))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
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
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 9:
      if ((paramObject1 instanceof FVector))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 6:
      if ((paramObject1 instanceof FVector))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
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
    if (paramModuleMethod.selector == 5)
    {
      if ((paramObject1 instanceof FVector))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    }
    return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }

  public final void run(CallContext paramCallContext)
  {
    vector$Mnref = new GenericProc("vector-ref");
    GenericProc localGenericProc = vector$Mnref;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Lit0;
    arrayOfObject[1] = vector$Mnset$Ex;
    arrayOfObject[2] = vector$Mnref$Fn1;
    localGenericProc.setProperties(arrayOfObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.vectors
 * JD-Core Version:    0.6.2
 */