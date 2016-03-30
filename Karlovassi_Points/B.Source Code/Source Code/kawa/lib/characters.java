package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.text.Char;

public class characters extends ModuleBody
{
  public static final characters $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7 = (SimpleSymbol)new SimpleSymbol("char>=?").readResolve();
  public static final ModuleMethod char$Eq$Qu;
  public static final ModuleMethod char$Gr$Eq$Qu;
  public static final ModuleMethod char$Gr$Qu;
  public static final ModuleMethod char$Ls$Eq$Qu;
  public static final ModuleMethod char$Ls$Qu;
  public static final ModuleMethod char$Mn$Grinteger;
  public static final ModuleMethod char$Qu;
  public static final ModuleMethod integer$Mn$Grchar;

  static
  {
    Lit6 = (SimpleSymbol)new SimpleSymbol("char<=?").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("char>?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("char<?").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("char=?").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("integer->char").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("char->integer").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("char?").readResolve();
    $instance = new characters();
    characters localcharacters = $instance;
    char$Qu = new ModuleMethod(localcharacters, 1, Lit0, 4097);
    char$Mn$Grinteger = new ModuleMethod(localcharacters, 2, Lit1, 4097);
    integer$Mn$Grchar = new ModuleMethod(localcharacters, 3, Lit2, 4097);
    char$Eq$Qu = new ModuleMethod(localcharacters, 4, Lit3, 8194);
    char$Ls$Qu = new ModuleMethod(localcharacters, 5, Lit4, 8194);
    char$Gr$Qu = new ModuleMethod(localcharacters, 6, Lit5, 8194);
    char$Ls$Eq$Qu = new ModuleMethod(localcharacters, 7, Lit6, 8194);
    char$Gr$Eq$Qu = new ModuleMethod(localcharacters, 8, Lit7, 8194);
    $instance.run();
  }

  public characters()
  {
    ModuleInfo.register(this);
  }

  public static int char$To$Integer(Char paramChar)
  {
    return paramChar.intValue();
  }

  public static Char integer$To$Char(int paramInt)
  {
    return Char.make(paramInt);
  }

  public static boolean isChar(Object paramObject)
  {
    return paramObject instanceof Char;
  }

  public static boolean isChar$Eq(Char paramChar1, Char paramChar2)
  {
    return paramChar1.intValue() == paramChar2.intValue();
  }

  public static boolean isChar$Gr(Char paramChar1, Char paramChar2)
  {
    return paramChar1.intValue() > paramChar2.intValue();
  }

  public static boolean isChar$Gr$Eq(Char paramChar1, Char paramChar2)
  {
    return paramChar1.intValue() >= paramChar2.intValue();
  }

  public static boolean isChar$Ls(Char paramChar1, Char paramChar2)
  {
    return paramChar1.intValue() < paramChar2.intValue();
  }

  public static boolean isChar$Ls$Eq(Char paramChar1, Char paramChar2)
  {
    return paramChar1.intValue() <= paramChar2.intValue();
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 132	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+28 -> 32, 1:+35->39, 2:+50->54, 3:+65->69
    //   33: aload_1
    //   34: aload_2
    //   35: invokespecial 134	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: areturn
    //   39: aload_2
    //   40: invokestatic 136	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   43: ifeq +7 -> 50
    //   46: getstatic 142	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   49: areturn
    //   50: getstatic 145	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   53: areturn
    //   54: aload_2
    //   55: checkcast 107	gnu/text/Char
    //   58: astore 6
    //   60: aload 6
    //   62: invokestatic 147	kawa/lib/characters:char$To$Integer	(Lgnu/text/Char;)I
    //   65: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: areturn
    //   69: aload_2
    //   70: checkcast 155	java/lang/Number
    //   73: invokevirtual 156	java/lang/Number:intValue	()I
    //   76: istore 4
    //   78: iload 4
    //   80: invokestatic 158	kawa/lib/characters:integer$To$Char	(I)Lgnu/text/Char;
    //   83: areturn
    //   84: astore 5
    //   86: new 160	gnu/mapping/WrongType
    //   89: dup
    //   90: aload 5
    //   92: ldc 62
    //   94: iconst_1
    //   95: aload_2
    //   96: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   99: athrow
    //   100: astore_3
    //   101: new 160	gnu/mapping/WrongType
    //   104: dup
    //   105: aload_3
    //   106: ldc 58
    //   108: iconst_1
    //   109: aload_2
    //   110: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   113: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   54	60	84	java/lang/ClassCastException
    //   69	78	100	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 132	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+36 -> 40, 4:+44->48, 5:+74->78, 6:+104->108, 7:+134->138, 8:+164->168
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: invokespecial 167	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: areturn
    //   48: aload_2
    //   49: checkcast 107	gnu/text/Char
    //   52: astore 21
    //   54: aload_3
    //   55: checkcast 107	gnu/text/Char
    //   58: astore 23
    //   60: aload 21
    //   62: aload 23
    //   64: invokestatic 169	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   67: ifeq +7 -> 74
    //   70: getstatic 142	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   73: areturn
    //   74: getstatic 145	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   77: areturn
    //   78: aload_2
    //   79: checkcast 107	gnu/text/Char
    //   82: astore 17
    //   84: aload_3
    //   85: checkcast 107	gnu/text/Char
    //   88: astore 19
    //   90: aload 17
    //   92: aload 19
    //   94: invokestatic 171	kawa/lib/characters:isChar$Ls	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   97: ifeq +7 -> 104
    //   100: getstatic 142	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   103: areturn
    //   104: getstatic 145	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   107: areturn
    //   108: aload_2
    //   109: checkcast 107	gnu/text/Char
    //   112: astore 13
    //   114: aload_3
    //   115: checkcast 107	gnu/text/Char
    //   118: astore 15
    //   120: aload 13
    //   122: aload 15
    //   124: invokestatic 173	kawa/lib/characters:isChar$Gr	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   127: ifeq +7 -> 134
    //   130: getstatic 142	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   133: areturn
    //   134: getstatic 145	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   137: areturn
    //   138: aload_2
    //   139: checkcast 107	gnu/text/Char
    //   142: astore 9
    //   144: aload_3
    //   145: checkcast 107	gnu/text/Char
    //   148: astore 11
    //   150: aload 9
    //   152: aload 11
    //   154: invokestatic 175	kawa/lib/characters:isChar$Ls$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   157: ifeq +7 -> 164
    //   160: getstatic 142	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   163: areturn
    //   164: getstatic 145	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   167: areturn
    //   168: aload_2
    //   169: checkcast 107	gnu/text/Char
    //   172: astore 5
    //   174: aload_3
    //   175: checkcast 107	gnu/text/Char
    //   178: astore 7
    //   180: aload 5
    //   182: aload 7
    //   184: invokestatic 177	kawa/lib/characters:isChar$Gr$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   187: ifeq +7 -> 194
    //   190: getstatic 142	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   193: areturn
    //   194: getstatic 145	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   197: areturn
    //   198: astore 20
    //   200: new 160	gnu/mapping/WrongType
    //   203: dup
    //   204: aload 20
    //   206: ldc 54
    //   208: iconst_1
    //   209: aload_2
    //   210: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   213: athrow
    //   214: astore 22
    //   216: new 160	gnu/mapping/WrongType
    //   219: dup
    //   220: aload 22
    //   222: ldc 54
    //   224: iconst_2
    //   225: aload_3
    //   226: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: astore 16
    //   232: new 160	gnu/mapping/WrongType
    //   235: dup
    //   236: aload 16
    //   238: ldc 50
    //   240: iconst_1
    //   241: aload_2
    //   242: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   245: athrow
    //   246: astore 18
    //   248: new 160	gnu/mapping/WrongType
    //   251: dup
    //   252: aload 18
    //   254: ldc 50
    //   256: iconst_2
    //   257: aload_3
    //   258: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   261: athrow
    //   262: astore 12
    //   264: new 160	gnu/mapping/WrongType
    //   267: dup
    //   268: aload 12
    //   270: ldc 46
    //   272: iconst_1
    //   273: aload_2
    //   274: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   277: athrow
    //   278: astore 14
    //   280: new 160	gnu/mapping/WrongType
    //   283: dup
    //   284: aload 14
    //   286: ldc 46
    //   288: iconst_2
    //   289: aload_3
    //   290: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   293: athrow
    //   294: astore 8
    //   296: new 160	gnu/mapping/WrongType
    //   299: dup
    //   300: aload 8
    //   302: ldc 42
    //   304: iconst_1
    //   305: aload_2
    //   306: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   309: athrow
    //   310: astore 10
    //   312: new 160	gnu/mapping/WrongType
    //   315: dup
    //   316: aload 10
    //   318: ldc 42
    //   320: iconst_2
    //   321: aload_3
    //   322: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   325: athrow
    //   326: astore 4
    //   328: new 160	gnu/mapping/WrongType
    //   331: dup
    //   332: aload 4
    //   334: ldc 30
    //   336: iconst_1
    //   337: aload_2
    //   338: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   341: athrow
    //   342: astore 6
    //   344: new 160	gnu/mapping/WrongType
    //   347: dup
    //   348: aload 6
    //   350: ldc 30
    //   352: iconst_2
    //   353: aload_3
    //   354: invokespecial 163	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   48	54	198	java/lang/ClassCastException
    //   54	60	214	java/lang/ClassCastException
    //   78	84	230	java/lang/ClassCastException
    //   84	90	246	java/lang/ClassCastException
    //   108	114	262	java/lang/ClassCastException
    //   114	120	278	java/lang/ClassCastException
    //   138	144	294	java/lang/ClassCastException
    //   144	150	310	java/lang/ClassCastException
    //   168	174	326	java/lang/ClassCastException
    //   174	180	342	java/lang/ClassCastException
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 3:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
      if (!(paramObject instanceof Char))
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
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 8:
      if (!(paramObject1 instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 7:
      if (!(paramObject1 instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 6:
      if (!(paramObject1 instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 5:
      if (!(paramObject1 instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 4:
    }
    if (!(paramObject1 instanceof Char))
      return -786431;
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof Char))
      return -786430;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.characters
 * JD-Core Version:    0.6.2
 */