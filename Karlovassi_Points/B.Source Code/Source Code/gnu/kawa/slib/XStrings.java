package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class XStrings extends ModuleBody
{
  public static final XStrings $instance;
  static final IntNum Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2 = (SimpleSymbol)new SimpleSymbol("string-length").readResolve();
  public static final ModuleMethod string$Mnlength;
  public static final ModuleMethod substring;

  static
  {
    Lit1 = (SimpleSymbol)new SimpleSymbol("substring").readResolve();
    Lit0 = IntNum.make(2147483647);
    $instance = new XStrings();
    XStrings localXStrings = $instance;
    substring = new ModuleMethod(localXStrings, 1, Lit1, 12290);
    string$Mnlength = new ModuleMethod(localXStrings, 3, Lit2, 4097);
    $instance.run();
  }

  public XStrings()
  {
    ModuleInfo.register(this);
  }

  public static Object stringLength(Object paramObject)
  {
    if (paramObject == Values.empty)
      return Values.empty;
    return Integer.valueOf(((String)paramObject).length());
  }

  public static Object substring(Object paramObject1, Object paramObject2)
  {
    return substring(paramObject1, paramObject2, Lit0);
  }

  // ERROR //
  public static Object substring(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 73	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   4: if_acmpne +17 -> 21
    //   7: iconst_1
    //   8: istore_3
    //   9: iload_3
    //   10: ifeq +16 -> 26
    //   13: iload_3
    //   14: ifeq +32 -> 46
    //   17: getstatic 73	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   20: areturn
    //   21: iconst_0
    //   22: istore_3
    //   23: goto -14 -> 9
    //   26: aload_1
    //   27: getstatic 73	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   30: if_acmpne +84 -> 114
    //   33: iconst_1
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +82 -> 120
    //   41: iload 4
    //   43: ifne -26 -> 17
    //   46: aload_0
    //   47: checkcast 75	java/lang/String
    //   50: astore 6
    //   52: aload 6
    //   54: invokevirtual 79	java/lang/String:length	()I
    //   57: istore 7
    //   59: aload_1
    //   60: checkcast 93	java/lang/Number
    //   63: invokevirtual 96	java/lang/Number:intValue	()I
    //   66: istore 9
    //   68: iload 9
    //   70: iconst_1
    //   71: isub
    //   72: istore 10
    //   74: aload_2
    //   75: checkcast 93	java/lang/Number
    //   78: invokevirtual 96	java/lang/Number:intValue	()I
    //   81: istore 12
    //   83: iload 7
    //   85: iload 10
    //   87: isub
    //   88: istore 13
    //   90: iload 12
    //   92: iload 13
    //   94: if_icmple +36 -> 130
    //   97: iload 13
    //   99: istore 14
    //   101: aload 6
    //   103: iload 10
    //   105: iload 10
    //   107: iload 14
    //   109: iadd
    //   110: invokevirtual 99	java/lang/String:substring	(II)Ljava/lang/String;
    //   113: areturn
    //   114: iconst_0
    //   115: istore 4
    //   117: goto -81 -> 36
    //   120: aload_2
    //   121: getstatic 73	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   124: if_acmpne -78 -> 46
    //   127: goto -110 -> 17
    //   130: iload 12
    //   132: istore 14
    //   134: goto -33 -> 101
    //   137: astore 5
    //   139: new 101	gnu/mapping/WrongType
    //   142: dup
    //   143: aload 5
    //   145: ldc 103
    //   147: bipush 254
    //   149: aload_0
    //   150: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   153: athrow
    //   154: astore 8
    //   156: new 101	gnu/mapping/WrongType
    //   159: dup
    //   160: aload 8
    //   162: ldc 108
    //   164: bipush 254
    //   166: aload_1
    //   167: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   170: athrow
    //   171: astore 11
    //   173: new 101	gnu/mapping/WrongType
    //   176: dup
    //   177: aload 11
    //   179: ldc 110
    //   181: bipush 254
    //   183: aload_2
    //   184: invokespecial 106	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   187: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   46	52	137	java/lang/ClassCastException
    //   59	68	154	java/lang/ClassCastException
    //   74	83	171	java/lang/ClassCastException
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 3)
      return stringLength(paramObject);
    return super.apply1(paramModuleMethod, paramObject);
  }

  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 1)
      return substring(paramObject1, paramObject2);
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }

  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramModuleMethod.selector == 1)
      return substring(paramObject1, paramObject2, paramObject3);
    return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 3)
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
    if (paramModuleMethod.selector == 1)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.XStrings
 * JD-Core Version:    0.6.2
 */