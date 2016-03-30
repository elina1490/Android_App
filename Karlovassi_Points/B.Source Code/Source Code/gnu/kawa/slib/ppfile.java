package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.text.Char;
import gnu.text.Path;
import kawa.lib.lists;
import kawa.lib.ports;

public class ppfile extends ModuleBody
{
  public static final ppfile $instance;
  static final Char Lit0;
  static final Char Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3 = (SimpleSymbol)new SimpleSymbol("pprint-file").readResolve();
  static final ModuleMethod lambda$Fn3;
  public static final ModuleMethod pprint$Mnfile;
  public static final ModuleMethod pprint$Mnfilter$Mnfile;

  static
  {
    Lit2 = (SimpleSymbol)new SimpleSymbol("pprint-filter-file").readResolve();
    Lit1 = Char.make(10);
    Lit0 = Char.make(59);
    $instance = new ppfile();
    ppfile localppfile = $instance;
    pprint$Mnfilter$Mnfile = new ModuleMethod(localppfile, 3, Lit2, -4094);
    ModuleMethod localModuleMethod = new ModuleMethod(localppfile, 4, null, 4097);
    localModuleMethod.setProperty("source-location", "ppfile.scm:70");
    lambda$Fn3 = localModuleMethod;
    pprint$Mnfile = new ModuleMethod(localppfile, 5, Lit3, 8193);
    $instance.run();
  }

  public ppfile()
  {
    ModuleInfo.register(this);
  }

  static Object lambda3(Object paramObject)
  {
    return paramObject;
  }

  public static Object pprintFile(Object paramObject)
  {
    return pprintFile(paramObject, ports.current$Mnoutput$Mnport.apply0());
  }

  public static Object pprintFile(Object paramObject1, Object paramObject2)
  {
    return pprintFilterFile$V(paramObject1, lambda$Fn3, new Object[] { paramObject2 });
  }

  public static Object pprintFilterFile$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame localframe = new frame();
    localframe.filter = paramObject2;
    localframe.optarg = LList.makeList(paramArrayOfObject, 0);
    ModuleMethod localModuleMethod = localframe.lambda$Fn1;
    if (ports.isInputPort(paramObject1))
      return localframe.lambda1(paramObject1);
    try
    {
      Path localPath = Path.valueOf(paramObject1);
      return ports.callWithInputFile(localPath, localModuleMethod);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "call-with-input-file", 1, paramObject1);
    }
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply1(paramModuleMethod, paramObject);
    case 4:
      return lambda3(paramObject);
    case 5:
    }
    return pprintFile(paramObject);
  }

  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 5)
      return pprintFile(paramObject1, paramObject2);
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    if (paramModuleMethod.selector == 3)
    {
      Object localObject1 = paramArrayOfObject[0];
      Object localObject2 = paramArrayOfObject[1];
      int i = paramArrayOfObject.length - 2;
      Object[] arrayOfObject = new Object[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          return pprintFilterFile$V(localObject1, localObject2, arrayOfObject);
        arrayOfObject[j] = paramArrayOfObject[(j + 2)];
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
    case 5:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 4:
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 5)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 3)
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
    Object filter;
    final ModuleMethod lambda$Fn1;
    LList optarg;

    public frame()
    {
      this$1 = new ModuleMethod(this, 2, null, 4097);
      this$1.setProperty("source-location", "ppfile.scm:27");
      this.lambda$Fn1 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 2)
        return lambda1(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda1(Object paramObject)
    {
      ppfile.frame0 localframe0 = new ppfile.frame0();
      localframe0.staticLink = this;
      localframe0.port = paramObject;
      ModuleMethod localModuleMethod = localframe0.lambda$Fn2;
      if (lists.isNull(this.optarg));
      for (Object localObject = ports.current$Mnoutput$Mnport.apply0(); ports.isOutputPort(localObject); localObject = lists.car.apply1(this.optarg))
        return localframe0.lambda2(localObject);
      try
      {
        Path localPath = Path.valueOf(localObject);
        return ports.callWithOutputFile(localPath, localModuleMethod);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "call-with-output-file", 1, localObject);
      }
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
    final ModuleMethod lambda$Fn2;
    Object port;
    ppfile.frame staticLink;

    public frame0()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "ppfile.scm:34");
      this.lambda$Fn2 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 1)
        return lambda2(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    // ERROR //
    Object lambda2(Object paramObject)
    {
      // Byte code:
      //   0: getstatic 51	kawa/standard/readchar:peekChar	Lkawa/standard/readchar;
      //   3: aload_0
      //   4: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   7: invokevirtual 57	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   10: astore_2
      //   11: aload_2
      //   12: invokestatic 63	kawa/lib/ports:isEofObject	(Ljava/lang/Object;)Z
      //   15: istore_3
      //   16: iload_3
      //   17: ifeq +15 -> 32
      //   20: iload_3
      //   21: ifeq +7 -> 28
      //   24: getstatic 69	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   27: areturn
      //   28: getstatic 72	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   31: areturn
      //   32: aload_2
      //   33: checkcast 74	gnu/text/Char
      //   36: astore 5
      //   38: aload 5
      //   40: invokestatic 80	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
      //   43: ifeq +31 -> 74
      //   46: getstatic 83	kawa/standard/readchar:readChar	Lkawa/standard/readchar;
      //   49: aload_0
      //   50: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   53: invokevirtual 57	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   56: aload_1
      //   57: invokestatic 86	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   60: getstatic 51	kawa/standard/readchar:peekChar	Lkawa/standard/readchar;
      //   63: aload_0
      //   64: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   67: invokevirtual 57	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   70: astore_2
      //   71: goto -60 -> 11
      //   74: getstatic 92	gnu/kawa/slib/ppfile:Lit0	Lgnu/text/Char;
      //   77: astore 6
      //   79: aload_2
      //   80: checkcast 74	gnu/text/Char
      //   83: astore 8
      //   85: aload 6
      //   87: aload 8
      //   89: invokestatic 98	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   92: ifeq +104 -> 196
      //   95: aload_2
      //   96: invokestatic 63	kawa/lib/ports:isEofObject	(Ljava/lang/Object;)Z
      //   99: istore 16
      //   101: iload 16
      //   103: ifeq +16 -> 119
      //   106: iload 16
      //   108: ifeq +7 -> 115
      //   111: getstatic 69	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   114: areturn
      //   115: getstatic 72	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   118: areturn
      //   119: getstatic 101	gnu/kawa/slib/ppfile:Lit1	Lgnu/text/Char;
      //   122: astore 17
      //   124: aload_2
      //   125: checkcast 74	gnu/text/Char
      //   128: astore 19
      //   130: aload 17
      //   132: aload 19
      //   134: invokestatic 98	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   137: ifeq +31 -> 168
      //   140: getstatic 83	kawa/standard/readchar:readChar	Lkawa/standard/readchar;
      //   143: aload_0
      //   144: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   147: invokevirtual 57	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   150: aload_1
      //   151: invokestatic 86	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   154: getstatic 51	kawa/standard/readchar:peekChar	Lkawa/standard/readchar;
      //   157: aload_0
      //   158: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   161: invokevirtual 57	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   164: astore_2
      //   165: goto -154 -> 11
      //   168: getstatic 83	kawa/standard/readchar:readChar	Lkawa/standard/readchar;
      //   171: aload_0
      //   172: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   175: invokevirtual 57	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   178: aload_1
      //   179: invokestatic 86	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   182: getstatic 51	kawa/standard/readchar:peekChar	Lkawa/standard/readchar;
      //   185: aload_0
      //   186: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   189: invokevirtual 57	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   192: astore_2
      //   193: goto -98 -> 95
      //   196: aload_0
      //   197: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   200: astore 9
      //   202: aload 9
      //   204: checkcast 103	gnu/mapping/InPort
      //   207: astore 11
      //   209: aload 11
      //   211: invokestatic 107	kawa/lib/ports:read	(Lgnu/mapping/InPort;)Ljava/lang/Object;
      //   214: astore 12
      //   216: aload 12
      //   218: invokestatic 63	kawa/lib/ports:isEofObject	(Ljava/lang/Object;)Z
      //   221: istore 13
      //   223: iload 13
      //   225: ifeq +16 -> 241
      //   228: iload 13
      //   230: ifeq +7 -> 237
      //   233: getstatic 69	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   236: areturn
      //   237: getstatic 72	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   240: areturn
      //   241: getstatic 113	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   244: aload_0
      //   245: getfield 115	gnu/kawa/slib/ppfile$frame0:staticLink	Lgnu/kawa/slib/ppfile$frame;
      //   248: getfield 120	gnu/kawa/slib/ppfile$frame:filter	Ljava/lang/Object;
      //   251: aload 12
      //   253: invokevirtual 124	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   256: aload_1
      //   257: invokestatic 129	gnu/kawa/slib/pp:prettyPrint	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   260: pop
      //   261: getstatic 51	kawa/standard/readchar:peekChar	Lkawa/standard/readchar;
      //   264: aload_0
      //   265: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   268: invokevirtual 57	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   271: astore_2
      //   272: getstatic 133	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   275: getstatic 101	gnu/kawa/slib/ppfile:Lit1	Lgnu/text/Char;
      //   278: aload_2
      //   279: invokevirtual 124	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   282: getstatic 72	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   285: if_acmpeq -274 -> 11
      //   288: getstatic 83	kawa/standard/readchar:readChar	Lkawa/standard/readchar;
      //   291: aload_0
      //   292: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   295: invokevirtual 57	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   298: pop
      //   299: getstatic 51	kawa/standard/readchar:peekChar	Lkawa/standard/readchar;
      //   302: aload_0
      //   303: getfield 53	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   306: invokevirtual 57	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   309: astore_2
      //   310: goto -299 -> 11
      //   313: astore 4
      //   315: new 135	gnu/mapping/WrongType
      //   318: dup
      //   319: aload 4
      //   321: ldc 137
      //   323: iconst_1
      //   324: aload_2
      //   325: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   328: athrow
      //   329: astore 7
      //   331: new 135	gnu/mapping/WrongType
      //   334: dup
      //   335: aload 7
      //   337: ldc 142
      //   339: iconst_2
      //   340: aload_2
      //   341: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   344: athrow
      //   345: astore 18
      //   347: new 135	gnu/mapping/WrongType
      //   350: dup
      //   351: aload 18
      //   353: ldc 142
      //   355: iconst_2
      //   356: aload_2
      //   357: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   360: athrow
      //   361: astore 10
      //   363: new 135	gnu/mapping/WrongType
      //   366: dup
      //   367: aload 10
      //   369: ldc 143
      //   371: iconst_1
      //   372: aload 9
      //   374: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   377: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	313	java/lang/ClassCastException
      //   79	85	329	java/lang/ClassCastException
      //   124	130	345	java/lang/ClassCastException
      //   202	209	361	java/lang/ClassCastException
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
 * Qualified Name:     gnu.kawa.slib.ppfile
 * JD-Core Version:    0.6.2
 */