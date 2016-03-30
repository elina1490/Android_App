package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Future;
import gnu.mapping.Procedure;
import gnu.mapping.RunnableClosure;
import gnu.mapping.SimpleSymbol;
import gnu.math.Quantity;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.standard.sleep;

public class thread extends ModuleBody
{
  public static final ModuleMethod $Prvt$$Pcmake$Mnfuture;
  public static final thread $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SyntaxRules Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4 = (SimpleSymbol)new SimpleSymbol("runnable").readResolve();
  public static final Macro future;
  public static final ModuleMethod runnable;
  public static final ModuleMethod sleep;

  public static Future $PcMakeFuture(Procedure paramProcedure)
  {
    Future localFuture = new Future(paramProcedure);
    localFuture.start();
    return localFuture;
  }

  static
  {
    Lit3 = (SimpleSymbol)new SimpleSymbol("%make-future").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol = (SimpleSymbol)new SimpleSymbol("future").readResolve();
    Lit1 = localSimpleSymbol;
    arrayOfObject1[0] = localSimpleSymbol;
    SyntaxRule[] arrayOfSyntaxRule = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Lit3;
    arrayOfObject2[1] = ((SimpleSymbol)new SimpleSymbol("lambda").readResolve());
    arrayOfSyntaxRule[0] = new SyntaxRule(localSyntaxPattern, "\001", "\021\030\004\b\021\030\f\t\020\b\003", arrayOfObject2, 0);
    Lit2 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule, 1);
    Lit0 = (SimpleSymbol)new SimpleSymbol("sleep").readResolve();
    $instance = new thread();
    thread localthread = $instance;
    sleep = new ModuleMethod(localthread, 1, Lit0, 4097);
    future = Macro.make(Lit1, Lit2, $instance);
    $Prvt$$Pcmake$Mnfuture = new ModuleMethod(localthread, 2, Lit3, 4097);
    runnable = new ModuleMethod(localthread, 3, Lit4, 4097);
    $instance.run();
  }

  public thread()
  {
    ModuleInfo.register(this);
  }

  public static RunnableClosure runnable(Procedure paramProcedure)
  {
    return new RunnableClosure(paramProcedure);
  }

  public static void sleep(Quantity paramQuantity)
  {
    sleep.sleep(paramQuantity);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 131	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+28 -> 32, 1:+35->39, 2:+50->54, 3:+62->66
    //   33: aload_1
    //   34: aload_2
    //   35: invokespecial 133	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: areturn
    //   39: aload_2
    //   40: checkcast 135	gnu/math/Quantity
    //   43: astore 8
    //   45: aload 8
    //   47: invokestatic 136	kawa/lib/thread:sleep	(Lgnu/math/Quantity;)V
    //   50: getstatic 142	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   53: areturn
    //   54: aload_2
    //   55: checkcast 144	gnu/mapping/Procedure
    //   58: astore 6
    //   60: aload 6
    //   62: invokestatic 146	kawa/lib/thread:$PcMakeFuture	(Lgnu/mapping/Procedure;)Lgnu/mapping/Future;
    //   65: areturn
    //   66: aload_2
    //   67: checkcast 144	gnu/mapping/Procedure
    //   70: astore 4
    //   72: aload 4
    //   74: invokestatic 148	kawa/lib/thread:runnable	(Lgnu/mapping/Procedure;)Lgnu/mapping/RunnableClosure;
    //   77: areturn
    //   78: astore 7
    //   80: new 150	gnu/mapping/WrongType
    //   83: dup
    //   84: aload 7
    //   86: ldc 79
    //   88: iconst_1
    //   89: aload_2
    //   90: invokespecial 153	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   93: athrow
    //   94: astore 5
    //   96: new 150	gnu/mapping/WrongType
    //   99: dup
    //   100: aload 5
    //   102: ldc 46
    //   104: iconst_1
    //   105: aload_2
    //   106: invokespecial 153	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   109: athrow
    //   110: astore_3
    //   111: new 150	gnu/mapping/WrongType
    //   114: dup
    //   115: aload_3
    //   116: ldc 35
    //   118: iconst_1
    //   119: aload_2
    //   120: invokespecial 153	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   123: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   39	45	78	java/lang/ClassCastException
    //   54	60	94	java/lang/ClassCastException
    //   66	72	110	java/lang/ClassCastException
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 3:
      if (!(paramObject instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
      if (!(paramObject instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 1:
    }
    if (!(paramObject instanceof Quantity))
      return -786431;
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.thread
 * JD-Core Version:    0.6.2
 */