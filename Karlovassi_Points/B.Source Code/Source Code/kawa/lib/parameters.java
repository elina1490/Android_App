package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.LocationProc;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.standard.Scheme;

public class parameters extends ModuleBody
{
  public static final ModuleMethod $Prvt$as$Mnlocation$Pc;
  public static final Macro $Prvt$parameterize$Pc;
  public static final parameters $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12 = (SimpleSymbol)new SimpleSymbol("save").readResolve();
  static final SimpleSymbol Lit2;
  static final SyntaxRules Lit3;
  static final SimpleSymbol Lit4;
  static final SyntaxRules Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod make$Mnparameter;
  public static final Macro parameterize;

  static
  {
    Lit11 = (SimpleSymbol)new SimpleSymbol("quasiquote").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("gnu.mapping.Location").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("$lookup$").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("v").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("p").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("begin").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("parameterize").readResolve();
    Lit4 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\b\003", new Object[0], 1);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Lit6;
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "", "\021\030\004\002", arrayOfObject2, 0);
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030<,\f\007\f\017\b\023\033", new Object[0], 4);
    Object[] arrayOfObject3 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("parameterize%").readResolve();
    Lit2 = localSimpleSymbol2;
    arrayOfObject3[0] = localSimpleSymbol2;
    arrayOfSyntaxRule1[1] = new SyntaxRule(localSyntaxPattern2, "", "\021\030\0041!\t\003\b\013\022\t\020\032", arrayOfObject3, 0);
    Lit5 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 4);
    Object[] arrayOfObject4 = new Object[1];
    arrayOfObject4[0] = Lit2;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\b\f\007\013", new Object[0], 2);
    Object[] arrayOfObject5 = new Object[2];
    arrayOfObject5[0] = ((SimpleSymbol)new SimpleSymbol("try-finally").readResolve());
    arrayOfObject5[1] = Lit6;
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern3, "", "\021\030\004!\021\030\f\n\b\021\030\f\003", arrayOfObject5, 0);
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("\f\030<,\f\007\f\017\b\023\f\037#", new Object[0], 5);
    Object[] arrayOfObject6 = new Object[9];
    arrayOfObject6[0] = ((SimpleSymbol)new SimpleSymbol("let*").readResolve());
    arrayOfObject6[1] = Lit7;
    arrayOfObject6[2] = ((SimpleSymbol)new SimpleSymbol("::").readResolve());
    arrayOfObject6[3] = ((SimpleSymbol)new SimpleSymbol("<gnu.mapping.Location>").readResolve());
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("as-location%").readResolve();
    Lit1 = localSimpleSymbol3;
    arrayOfObject6[4] = localSimpleSymbol3;
    arrayOfObject6[5] = Lit8;
    arrayOfObject6[6] = PairWithPosition.make(PairWithPosition.make(Lit12, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit9, Pair.make(Lit10, Pair.make(Pair.make(Lit11, Pair.make((SimpleSymbol)new SimpleSymbol("setWithSave").readResolve(), LList.Empty)), LList.Empty)), "parameters.scm", 122893), PairWithPosition.make(Lit7, PairWithPosition.make(Lit8, LList.Empty, "parameters.scm", 122928), "parameters.scm", 122926), "parameters.scm", 122892), LList.Empty, "parameters.scm", 122892), "parameters.scm", 122886), LList.Empty, "parameters.scm", 122886);
    arrayOfObject6[7] = Lit2;
    arrayOfObject6[8] = PairWithPosition.make(PairWithPosition.make(Lit9, Pair.make(Lit10, Pair.make(Pair.make(Lit11, Pair.make((SimpleSymbol)new SimpleSymbol("setRestore").readResolve(), LList.Empty)), LList.Empty)), "parameters.scm", 131083), PairWithPosition.make(Lit7, PairWithPosition.make(Lit12, LList.Empty, "parameters.scm", 131117), "parameters.scm", 131115), "parameters.scm", 131082);
    arrayOfSyntaxRule2[1] = new SyntaxRule(localSyntaxPattern4, "", "\021\030\004Áy\021\030\f\021\030\024\021\030\034\b\021\030$\b\003)\021\030,\b\013\0304\b\021\030<\t\022!\021\030D\033\"", arrayOfObject6, 0);
    Lit3 = new SyntaxRules(arrayOfObject4, arrayOfSyntaxRule2, 5);
    Lit0 = (SimpleSymbol)new SimpleSymbol("make-parameter").readResolve();
    $instance = new parameters();
    parameters localparameters = $instance;
    make$Mnparameter = new ModuleMethod(localparameters, 1, Lit0, 8193);
    $Prvt$as$Mnlocation$Pc = new ModuleMethod(localparameters, 3, Lit1, 4097);
    $Prvt$parameterize$Pc = Macro.make(Lit2, Lit3, $instance);
    parameterize = Macro.make(Lit4, Lit5, $instance);
    $instance.run();
  }

  public parameters()
  {
    ModuleInfo.register(this);
  }

  // ERROR //
  public static gnu.mapping.Location asLocation$Pc(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: instanceof 205
    //   4: ifeq +37 -> 41
    //   7: aload_0
    //   8: checkcast 205	gnu/mapping/LocationProc
    //   11: astore 5
    //   13: aload 5
    //   15: invokevirtual 209	gnu/mapping/LocationProc:getLocation	()Lgnu/mapping/Location;
    //   18: astore_1
    //   19: aload_1
    //   20: instanceof 211
    //   23: ifeq +13 -> 36
    //   26: aload_1
    //   27: checkcast 211	gnu/mapping/ThreadLocation
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 214	gnu/mapping/ThreadLocation:getLocation	()Lgnu/mapping/NamedLocation;
    //   35: astore_1
    //   36: aload_1
    //   37: checkcast 216	gnu/mapping/Location
    //   40: areturn
    //   41: aload_0
    //   42: checkcast 216	gnu/mapping/Location
    //   45: astore_1
    //   46: goto -27 -> 19
    //   49: astore 4
    //   51: new 218	gnu/mapping/WrongType
    //   54: dup
    //   55: aload 4
    //   57: ldc 220
    //   59: iconst_1
    //   60: aload_0
    //   61: invokespecial 223	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   64: athrow
    //   65: astore_2
    //   66: new 218	gnu/mapping/WrongType
    //   69: dup
    //   70: aload_2
    //   71: ldc 225
    //   73: iconst_1
    //   74: aload_1
    //   75: invokespecial 223	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   78: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   7	13	49	java/lang/ClassCastException
    //   26	31	65	java/lang/ClassCastException
  }

  public static LocationProc makeParameter(Object paramObject)
  {
    return makeParameter(paramObject, null);
  }

  public static LocationProc makeParameter(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 != null)
      paramObject1 = Scheme.applyToArgs.apply2(paramObject2, paramObject1);
    ThreadLocation localThreadLocation = new ThreadLocation();
    localThreadLocation.setGlobal(paramObject1);
    try
    {
      Procedure localProcedure = (Procedure)paramObject2;
      return new LocationProc(localThreadLocation, localProcedure);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.mapping.LocationProc.<init>(gnu.mapping.Location,gnu.mapping.Procedure)", 2, paramObject2);
    }
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 2:
    default:
      return super.apply1(paramModuleMethod, paramObject);
    case 1:
      return makeParameter(paramObject);
    case 3:
    }
    return asLocation$Pc(paramObject);
  }

  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 1)
      return makeParameter(paramObject1, paramObject2);
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 2:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 3:
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

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.parameters
 * JD-Core Version:    0.6.2
 */