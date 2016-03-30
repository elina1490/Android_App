package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.PrimProcedure;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class trace extends ModuleBody
{
  public static final Macro $Pcdo$Mntrace;
  public static final trace $instance;
  static final SimpleSymbol Lit0;
  static final SyntaxRules Lit1;
  static final SimpleSymbol Lit2;
  static final SyntaxRules Lit3;
  static final SimpleSymbol Lit4;
  static final SyntaxRules Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7 = (SimpleSymbol)new SimpleSymbol("begin").readResolve();
  public static final ModuleMethod disassemble;
  public static final Macro trace;
  public static final Macro untrace;

  static
  {
    Lit6 = (SimpleSymbol)new SimpleSymbol("disassemble").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("untrace").readResolve();
    Lit4 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = Lit7;
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("%do-trace").readResolve();
    Lit0 = localSimpleSymbol2;
    arrayOfObject2[1] = localSimpleSymbol2;
    arrayOfObject2[2] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "trace.scm", 77851);
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\003", "\021\030\004\b\005\021\030\f\t\003\030\024", arrayOfObject2, 1);
    Lit5 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 1);
    Object[] arrayOfObject3 = new Object[1];
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("trace").readResolve();
    Lit2 = localSimpleSymbol3;
    arrayOfObject3[0] = localSimpleSymbol3;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject4 = new Object[3];
    arrayOfObject4[0] = Lit7;
    arrayOfObject4[1] = Lit0;
    arrayOfObject4[2] = PairWithPosition.make(Boolean.TRUE, LList.Empty, "trace.scm", 57371);
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\003", "\021\030\004\b\005\021\030\f\t\003\030\024", arrayOfObject4, 1);
    Lit3 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 1);
    Object[] arrayOfObject5 = new Object[1];
    arrayOfObject5[0] = Lit0;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject6 = new Object[4];
    arrayOfObject6[0] = ((SimpleSymbol)new SimpleSymbol("set!").readResolve());
    arrayOfObject6[1] = ((SimpleSymbol)new SimpleSymbol("invoke-static").readResolve());
    arrayOfObject6[2] = ((SimpleSymbol)new SimpleSymbol("<kawa.standard.TracedProcedure>").readResolve());
    arrayOfObject6[3] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("quote").readResolve(), PairWithPosition.make((SimpleSymbol)new SimpleSymbol("doTrace").readResolve(), LList.Empty, "trace.scm", 32806), "trace.scm", 32806);
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "\001\001", "\021\030\004\t\003\b\021\030\f\021\030\024\021\030\034\t\003\b\013", arrayOfObject6, 0);
    Lit1 = new SyntaxRules(arrayOfObject5, arrayOfSyntaxRule3, 2);
    $instance = new trace();
    $Pcdo$Mntrace = Macro.make(Lit0, Lit1, $instance);
    trace = Macro.make(Lit2, Lit3, $instance);
    untrace = Macro.make(Lit4, Lit5, $instance);
    disassemble = new ModuleMethod($instance, 1, Lit6, 4097);
    $instance.run();
  }

  public trace()
  {
    ModuleInfo.register(this);
  }

  public static Object disassemble(Procedure paramProcedure)
  {
    CallContext localCallContext = CallContext.getInstance();
    int i = localCallContext.startFromContext();
    try
    {
      PrimProcedure.disassemble$X(paramProcedure, localCallContext);
      return localCallContext.getFromContext(i);
    }
    finally
    {
      localCallContext.cleanupFromContext(i);
    }
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 1);
    try
    {
      Procedure localProcedure = (Procedure)paramObject;
      return disassemble(localProcedure);
      return super.apply1(paramModuleMethod, paramObject);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "disassemble", 1, paramObject);
    }
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
    {
      if (!(paramObject instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.trace
 * JD-Core Version:    0.6.2
 */