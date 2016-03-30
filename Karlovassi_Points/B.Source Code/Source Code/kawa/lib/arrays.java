package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Arrays;
import gnu.lists.Array;
import gnu.lists.FVector;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;

public class arrays extends ModuleBody
{
  public static final Class $Lsarray$Gr;
  public static final arrays $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7 = (SimpleSymbol)new SimpleSymbol("share-array").readResolve();
  public static final ModuleMethod array;
  public static final ModuleMethod array$Mnend;
  public static final ModuleMethod array$Mnrank;
  public static final ModuleMethod array$Mnstart;
  public static final ModuleMethod array$Qu;
  public static final ModuleMethod make$Mnarray;
  public static final ModuleMethod shape;
  public static final ModuleMethod share$Mnarray;

  static
  {
    Lit6 = (SimpleSymbol)new SimpleSymbol("array-end").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("array-start").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("array-rank").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("array").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("make-array").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("shape").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("array?").readResolve();
    $Lsarray$Gr = Array.class;
    $instance = new arrays();
    arrays localarrays = $instance;
    array$Qu = new ModuleMethod(localarrays, 1, Lit0, 4097);
    shape = new ModuleMethod(localarrays, 2, Lit1, -4096);
    make$Mnarray = new ModuleMethod(localarrays, 3, Lit2, 8193);
    array = new ModuleMethod(localarrays, 5, Lit3, -4095);
    array$Mnrank = new ModuleMethod(localarrays, 6, Lit4, 4097);
    array$Mnstart = new ModuleMethod(localarrays, 7, Lit5, 8194);
    array$Mnend = new ModuleMethod(localarrays, 8, Lit6, 8194);
    share$Mnarray = new ModuleMethod(localarrays, 9, Lit7, 12291);
    $instance.run();
  }

  public arrays()
  {
    ModuleInfo.register(this);
  }

  public static Array array(Array paramArray, Object[] paramArrayOfObject)
  {
    return Arrays.makeSimple(paramArray, new FVector(paramArrayOfObject));
  }

  public static int arrayEnd(Array paramArray, int paramInt)
  {
    return paramArray.getLowBound(paramInt) + paramArray.getSize(paramInt);
  }

  public static int arrayRank(Array paramArray)
  {
    return paramArray.rank();
  }

  public static int arrayStart(Array paramArray, int paramInt)
  {
    return paramArray.getLowBound(paramInt);
  }

  public static boolean isArray(Object paramObject)
  {
    return paramObject instanceof Array;
  }

  public static Array makeArray(Array paramArray)
  {
    return makeArray(paramArray, null);
  }

  public static Array makeArray(Array paramArray, Object paramObject)
  {
    return Arrays.make(paramArray, paramObject);
  }

  public static Array shape(Object[] paramArrayOfObject)
  {
    return Arrays.shape(paramArrayOfObject);
  }

  public static Array shareArray(Array paramArray1, Array paramArray2, Procedure paramProcedure)
  {
    return Arrays.shareArray(paramArray1, paramArray2, paramProcedure);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 160	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+40 -> 44, 1:+47->51, 2:+40->44, 3:+62->66, 4:+40->44, 5:+40->44, 6:+74->78
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 162	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: areturn
    //   51: aload_2
    //   52: invokestatic 164	kawa/lib/arrays:isArray	(Ljava/lang/Object;)Z
    //   55: ifeq +7 -> 62
    //   58: getstatic 170	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   61: areturn
    //   62: getstatic 173	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   65: areturn
    //   66: aload_2
    //   67: checkcast 70	gnu/lists/Array
    //   70: astore 6
    //   72: aload 6
    //   74: invokestatic 175	kawa/lib/arrays:makeArray	(Lgnu/lists/Array;)Lgnu/lists/Array;
    //   77: areturn
    //   78: aload_2
    //   79: checkcast 70	gnu/lists/Array
    //   82: astore 4
    //   84: aload 4
    //   86: invokestatic 177	kawa/lib/arrays:arrayRank	(Lgnu/lists/Array;)I
    //   89: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: areturn
    //   93: astore 5
    //   95: new 185	gnu/mapping/WrongType
    //   98: dup
    //   99: aload 5
    //   101: ldc 59
    //   103: iconst_1
    //   104: aload_2
    //   105: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   108: athrow
    //   109: astore_3
    //   110: new 185	gnu/mapping/WrongType
    //   113: dup
    //   114: aload_3
    //   115: ldc 52
    //   117: iconst_1
    //   118: aload_2
    //   119: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   122: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   66	72	93	java/lang/ClassCastException
    //   78	84	109	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 160	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+40 -> 44, 3:+48->52, 4:+40->44, 5:+40->44, 6:+40->44, 7:+61->65, 8:+87->91
    //   45: aload_1
    //   46: aload_2
    //   47: aload_3
    //   48: invokespecial 192	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: areturn
    //   52: aload_2
    //   53: checkcast 70	gnu/lists/Array
    //   56: astore 13
    //   58: aload 13
    //   60: aload_3
    //   61: invokestatic 142	kawa/lib/arrays:makeArray	(Lgnu/lists/Array;Ljava/lang/Object;)Lgnu/lists/Array;
    //   64: areturn
    //   65: aload_2
    //   66: checkcast 70	gnu/lists/Array
    //   69: astore 9
    //   71: aload_3
    //   72: checkcast 194	java/lang/Number
    //   75: invokevirtual 197	java/lang/Number:intValue	()I
    //   78: istore 11
    //   80: aload 9
    //   82: iload 11
    //   84: invokestatic 199	kawa/lib/arrays:arrayStart	(Lgnu/lists/Array;I)I
    //   87: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: areturn
    //   91: aload_2
    //   92: checkcast 70	gnu/lists/Array
    //   95: astore 5
    //   97: aload_3
    //   98: checkcast 194	java/lang/Number
    //   101: invokevirtual 197	java/lang/Number:intValue	()I
    //   104: istore 7
    //   106: aload 5
    //   108: iload 7
    //   110: invokestatic 201	kawa/lib/arrays:arrayEnd	(Lgnu/lists/Array;I)I
    //   113: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: areturn
    //   117: astore 12
    //   119: new 185	gnu/mapping/WrongType
    //   122: dup
    //   123: aload 12
    //   125: ldc 59
    //   127: iconst_1
    //   128: aload_2
    //   129: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   132: athrow
    //   133: astore 8
    //   135: new 185	gnu/mapping/WrongType
    //   138: dup
    //   139: aload 8
    //   141: ldc 48
    //   143: iconst_1
    //   144: aload_2
    //   145: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   148: athrow
    //   149: astore 10
    //   151: new 185	gnu/mapping/WrongType
    //   154: dup
    //   155: aload 10
    //   157: ldc 48
    //   159: iconst_2
    //   160: aload_3
    //   161: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   164: athrow
    //   165: astore 4
    //   167: new 185	gnu/mapping/WrongType
    //   170: dup
    //   171: aload 4
    //   173: ldc 44
    //   175: iconst_1
    //   176: aload_2
    //   177: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   180: athrow
    //   181: astore 6
    //   183: new 185	gnu/mapping/WrongType
    //   186: dup
    //   187: aload 6
    //   189: ldc 44
    //   191: iconst_2
    //   192: aload_3
    //   193: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   52	58	117	java/lang/ClassCastException
    //   65	71	133	java/lang/ClassCastException
    //   71	80	149	java/lang/ClassCastException
    //   91	97	165	java/lang/ClassCastException
    //   97	106	181	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 160	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 9
    //   6: if_icmpne +32 -> 38
    //   9: aload_2
    //   10: checkcast 70	gnu/lists/Array
    //   13: astore 6
    //   15: aload_3
    //   16: checkcast 70	gnu/lists/Array
    //   19: astore 8
    //   21: aload 4
    //   23: checkcast 205	gnu/mapping/Procedure
    //   26: astore 10
    //   28: aload 6
    //   30: aload 8
    //   32: aload 10
    //   34: invokestatic 206	kawa/lib/arrays:shareArray	(Lgnu/lists/Array;Lgnu/lists/Array;Lgnu/mapping/Procedure;)Lgnu/lists/Array;
    //   37: areturn
    //   38: aload_0
    //   39: aload_1
    //   40: aload_2
    //   41: aload_3
    //   42: aload 4
    //   44: invokespecial 208	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: areturn
    //   48: astore 5
    //   50: new 185	gnu/mapping/WrongType
    //   53: dup
    //   54: aload 5
    //   56: ldc 32
    //   58: iconst_1
    //   59: aload_2
    //   60: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   63: athrow
    //   64: astore 7
    //   66: new 185	gnu/mapping/WrongType
    //   69: dup
    //   70: aload 7
    //   72: ldc 32
    //   74: iconst_2
    //   75: aload_3
    //   76: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   79: athrow
    //   80: astore 9
    //   82: new 185	gnu/mapping/WrongType
    //   85: dup
    //   86: aload 9
    //   88: ldc 32
    //   90: iconst_3
    //   91: aload 4
    //   93: invokespecial 188	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   96: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	48	java/lang/ClassCastException
    //   15	21	64	java/lang/ClassCastException
    //   21	28	80	java/lang/ClassCastException
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 3:
    case 4:
    default:
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 2:
      return shape(paramArrayOfObject);
    case 5:
    }
    Object localObject = paramArrayOfObject[0];
    try
    {
      Array localArray = (Array)localObject;
      int i = paramArrayOfObject.length - 1;
      Object[] arrayOfObject = new Object[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          return array(localArray, arrayOfObject);
        arrayOfObject[j] = paramArrayOfObject[(j + 1)];
      }
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "array", 1, localObject);
    }
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 2:
    case 4:
    case 5:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 6:
      if (!(paramObject instanceof Array))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3:
      if (!(paramObject instanceof Array))
        return -786431;
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
    case 4:
    case 5:
    case 6:
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 8:
      if (!(paramObject1 instanceof Array))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 7:
      if (!(paramObject1 instanceof Array))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 3:
    }
    if (!(paramObject1 instanceof Array))
      return -786431;
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 9)
    {
      if (!(paramObject1 instanceof Array))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Array))
        return -786430;
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof Procedure))
        return -786429;
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
    case 3:
    case 4:
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 5:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 2:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.arrays
 * JD-Core Version:    0.6.2
 */