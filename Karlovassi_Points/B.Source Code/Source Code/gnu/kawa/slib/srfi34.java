package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.standard.Scheme;

public class srfi34 extends ModuleBody
{
  public static final Class $Prvt$$Lsraise$Mnobject$Mnexception$Gr;
  public static final Macro $Prvt$guard$Mnaux;
  public static final srfi34 $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13 = (SimpleSymbol)new SimpleSymbol("<raise-object-exception>").readResolve();
  static final SimpleSymbol Lit2;
  static final SyntaxRules Lit3;
  static final SimpleSymbol Lit4;
  static final SyntaxRules Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final Macro guard;
  public static final ModuleMethod raise;
  public static final ModuleMethod with$Mnexception$Mnhandler;

  static
  {
    Lit12 = (SimpleSymbol)new SimpleSymbol("ex").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("begin").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("if").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("temp").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("=>").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("else").readResolve();
    Object[] arrayOfObject1 = new Object[3];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("guard-aux").readResolve();
    Lit4 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    arrayOfObject1[1] = Lit6;
    arrayOfObject1[2] = Lit7;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[7];
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Lit6;
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\007L\f\002\f\017\r\027\020\b\b\b", arrayOfObject2, 3);
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = Lit11;
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001\001\003", "\021\030\004\t\013\b\025\023", arrayOfObject3, 1);
    Object[] arrayOfObject4 = new Object[1];
    arrayOfObject4[0] = Lit7;
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\f\007<\f\017\f\002\f\027\b\b", arrayOfObject4, 3);
    Object[] arrayOfObject5 = new Object[4];
    arrayOfObject5[0] = Lit9;
    arrayOfObject5[1] = Lit8;
    arrayOfObject5[2] = Lit10;
    arrayOfObject5[3] = PairWithPosition.make(Lit8, LList.Empty, "srfi34.scm", 274452);
    arrayOfSyntaxRule1[1] = new SyntaxRule(localSyntaxPattern2, "\001\001\001", "\021\030\0041\b\021\030\f\b\013\b\021\030\024\021\030\f!\t\023\030\034\b\003", arrayOfObject5, 0);
    Object[] arrayOfObject6 = new Object[1];
    arrayOfObject6[0] = Lit7;
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007<\f\017\f\002\f\027\b\f\037\r' \b\b", arrayOfObject6, 5);
    Object[] arrayOfObject7 = new Object[5];
    arrayOfObject7[0] = Lit9;
    arrayOfObject7[1] = Lit8;
    arrayOfObject7[2] = Lit10;
    arrayOfObject7[3] = PairWithPosition.make(Lit8, LList.Empty, "srfi34.scm", 294932);
    arrayOfObject7[4] = Lit4;
    arrayOfSyntaxRule1[2] = new SyntaxRule(localSyntaxPattern3, "\001\001\001\001\003", "\021\030\0041\b\021\030\f\b\013\b\021\030\024\021\030\f!\t\023\030\034\b\021\030$\t\003\t\033\b%#", arrayOfObject7, 1);
    arrayOfSyntaxRule1[3] = new SyntaxRule(new SyntaxPattern("\f\030\f\007\034\f\017\b\b", new Object[0], 2), "\001\001", "\013", new Object[0], 0);
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("\f\030\f\007\034\f\017\b\f\027\r\037\030\b\b", new Object[0], 4);
    Object[] arrayOfObject8 = new Object[4];
    arrayOfObject8[0] = Lit9;
    arrayOfObject8[1] = Lit8;
    arrayOfObject8[2] = Lit10;
    arrayOfObject8[3] = Lit4;
    arrayOfSyntaxRule1[4] = new SyntaxRule(localSyntaxPattern4, "\001\001\001\003", "\021\030\0041\b\021\030\f\b\013\b\021\030\024\021\030\f\021\030\f\b\021\030\034\t\003\t\023\b\035\033", arrayOfObject8, 1);
    SyntaxPattern localSyntaxPattern5 = new SyntaxPattern("\f\030\f\007L\f\017\f\027\r\037\030\b\b\b", new Object[0], 4);
    Object[] arrayOfObject9 = new Object[2];
    arrayOfObject9[0] = Lit10;
    arrayOfObject9[1] = Lit11;
    arrayOfSyntaxRule1[5] = new SyntaxRule(localSyntaxPattern5, "\001\001\001\003", "\021\030\004\t\013A\021\030\f\t\023\b\035\033\b\003", arrayOfObject9, 1);
    SyntaxPattern localSyntaxPattern6 = new SyntaxPattern("\f\030\f\007L\f\017\f\027\r\037\030\b\b\f'\r/(\b\b", new Object[0], 6);
    Object[] arrayOfObject10 = new Object[3];
    arrayOfObject10[0] = Lit10;
    arrayOfObject10[1] = Lit11;
    arrayOfObject10[2] = Lit4;
    arrayOfSyntaxRule1[6] = new SyntaxRule(localSyntaxPattern6, "\001\001\001\003\001\003", "\021\030\004\t\013A\021\030\f\t\023\b\035\033\b\021\030\024\t\003\t#\b-+", arrayOfObject10, 1);
    Lit5 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 6);
    Object[] arrayOfObject11 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("guard").readResolve();
    Lit2 = localSimpleSymbol2;
    arrayOfObject11[0] = localSimpleSymbol2;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern7 = new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3);
    Object[] arrayOfObject12 = new Object[8];
    arrayOfObject12[0] = ((SimpleSymbol)new SimpleSymbol("try-catch").readResolve());
    arrayOfObject12[1] = Lit11;
    arrayOfObject12[2] = Lit12;
    arrayOfObject12[3] = ((SimpleSymbol)new SimpleSymbol("<java.lang.Throwable>").readResolve());
    arrayOfObject12[4] = Lit9;
    SimpleSymbol localSimpleSymbol3 = Lit10;
    PairWithPosition localPairWithPosition1 = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("instance?").readResolve(), PairWithPosition.make(Lit12, PairWithPosition.make(Lit13, LList.Empty, "srfi34.scm", 110614), "srfi34.scm", 110611), "srfi34.scm", 110600);
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol("field").readResolve();
    PairWithPosition localPairWithPosition2 = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("as").readResolve(), PairWithPosition.make(Lit13, PairWithPosition.make(Lit12, LList.Empty, "srfi34.scm", 114732), "srfi34.scm", 114707), "srfi34.scm", 114703);
    SimpleSymbol localSimpleSymbol5 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    SimpleSymbol localSimpleSymbol6 = new SimpleSymbol("value");
    arrayOfObject12[5] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol3, PairWithPosition.make(localPairWithPosition1, PairWithPosition.make(PairWithPosition.make(localSimpleSymbol4, PairWithPosition.make(localPairWithPosition2, PairWithPosition.make(PairWithPosition.make(localSimpleSymbol5, PairWithPosition.make((SimpleSymbol)localSimpleSymbol6.readResolve(), LList.Empty, "srfi34.scm", 114737), "srfi34.scm", 114737), LList.Empty, "srfi34.scm", 114736), "srfi34.scm", 114703), "srfi34.scm", 114696), PairWithPosition.make(Lit12, LList.Empty, "srfi34.scm", 118792), "srfi34.scm", 114696), "srfi34.scm", 110600), "srfi34.scm", 110596), LList.Empty, "srfi34.scm", 110596);
    arrayOfObject12[6] = Lit4;
    arrayOfObject12[7] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("primitive-throw").readResolve(), PairWithPosition.make(Lit12, LList.Empty, "srfi34.scm", 122914), "srfi34.scm", 122897);
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern7, "", "\021\030\004!\021\030\f\022\b\021\030\024\021\030\034\b\021\030$)\b\t\003\030,\b\021\0304\021\030<\n", arrayOfObject12, 0);
    Lit3 = new SyntaxRules(arrayOfObject11, arrayOfSyntaxRule2, 3);
    Lit1 = (SimpleSymbol)new SimpleSymbol("raise").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("with-exception-handler").readResolve();
    $instance = new srfi34();
    $Prvt$$Lsraise$Mnobject$Mnexception$Gr = raise.Mnobject.Mnexception.class;
    srfi34 localsrfi34 = $instance;
    with$Mnexception$Mnhandler = new ModuleMethod(localsrfi34, 1, Lit0, 8194);
    raise = new ModuleMethod(localsrfi34, 2, Lit1, 4097);
    guard = Macro.make(Lit2, Lit3, $instance);
    $Prvt$guard$Mnaux = Macro.make(Lit4, Lit5, $instance);
    $instance.run();
  }

  public srfi34()
  {
    ModuleInfo.register(this);
  }

  public static void raise(Object paramObject)
  {
    throw ((Throwable)new raise.Mnobject.Mnexception(paramObject));
  }

  public static Object withExceptionHandler(Object paramObject1, Object paramObject2)
  {
    try
    {
      Object localObject = Scheme.applyToArgs.apply1(paramObject2);
      return localObject;
    }
    catch (raise.Mnobject.Mnexception localMnexception)
    {
      return Scheme.applyToArgs.apply2(paramObject1, localMnexception.value);
    }
    catch (Throwable localThrowable)
    {
      return Scheme.applyToArgs.apply2(paramObject1, localThrowable);
    }
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 2)
    {
      raise(paramObject);
      return Values.empty;
    }
    return super.apply1(paramModuleMethod, paramObject);
  }

  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 1)
      return withExceptionHandler(paramObject1, paramObject2);
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
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
 * Qualified Name:     gnu.kawa.slib.srfi34
 * JD-Core Version:    0.6.2
 */