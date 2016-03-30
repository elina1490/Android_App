package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class cut extends ModuleBody
{
  public static final Macro $Prvt$srfi$Mn26$Mninternal$Mncut;
  public static final Macro $Prvt$srfi$Mn26$Mninternal$Mncute;
  public static final cut $instance;
  static final SimpleSymbol Lit0;
  static final SyntaxRules Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14 = (SimpleSymbol)new SimpleSymbol("rest-slot").readResolve();
  static final SimpleSymbol Lit2;
  static final SyntaxRules Lit3;
  static final SimpleSymbol Lit4;
  static final SyntaxRules Lit5;
  static final SimpleSymbol Lit6;
  static final SyntaxRules Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final Macro cut;
  public static final Macro cute;

  static
  {
    Lit13 = (SimpleSymbol)new SimpleSymbol("apply").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("<>").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("x").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("lambda").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("<...>").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("cute").readResolve();
    Lit6 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\003", new Object[0], 1);
    Object[] arrayOfObject2 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("srfi-26-internal-cute").readResolve();
    Lit2 = localSimpleSymbol2;
    arrayOfObject2[0] = localSimpleSymbol2;
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "", "\021\030\004\t\020\t\020\t\020\002", arrayOfObject2, 0);
    Lit7 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 1);
    Object[] arrayOfObject3 = new Object[1];
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("cut").readResolve();
    Lit4 = localSimpleSymbol3;
    arrayOfObject3[0] = localSimpleSymbol3;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\003", new Object[0], 1);
    Object[] arrayOfObject4 = new Object[1];
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol("srfi-26-internal-cut").readResolve();
    Lit0 = localSimpleSymbol4;
    arrayOfObject4[0] = localSimpleSymbol4;
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "", "\021\030\004\t\020\t\020\002", arrayOfObject4, 0);
    Lit5 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 1);
    Object[] arrayOfObject5 = new Object[3];
    arrayOfObject5[0] = Lit2;
    arrayOfObject5[1] = Lit12;
    arrayOfObject5[2] = Lit8;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[4];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("", new Object[0], 4);
    Object[] arrayOfObject6 = new Object[2];
    arrayOfObject6[0] = Lit9;
    arrayOfObject6[1] = Lit10;
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "\003\001\001\003", "\021\030\004\t\013\b\021\030\f\031\b\005\003\b\t\023\b\035\033", arrayOfObject6, 1);
    Object[] arrayOfObject7 = new Object[1];
    arrayOfObject7[0] = Lit8;
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("", arrayOfObject7, 4);
    Object[] arrayOfObject8 = new Object[5];
    arrayOfObject8[0] = Lit9;
    arrayOfObject8[1] = Lit10;
    arrayOfObject8[2] = Lit11;
    arrayOfObject8[3] = Lit13;
    arrayOfObject8[4] = PairWithPosition.make(Lit11, LList.Empty, "cut.scm", 356424);
    arrayOfSyntaxRule3[1] = new SyntaxRule(localSyntaxPattern4, "\003\001\001\003", "\021\030\004\t\013\b\021\030\f)\021\005\003\030\024\b\021\030\034\t\023\021\035\033\030$", arrayOfObject8, 1);
    Object[] arrayOfObject9 = new Object[1];
    arrayOfObject9[0] = Lit12;
    SyntaxPattern localSyntaxPattern5 = new SyntaxPattern("", arrayOfObject9, 4);
    Object[] arrayOfObject10 = new Object[3];
    arrayOfObject10[0] = Lit2;
    arrayOfObject10[1] = PairWithPosition.make(Lit11, LList.Empty, "cut.scm", 380950);
    arrayOfObject10[2] = PairWithPosition.make(Lit11, LList.Empty, "cut.scm", 380987);
    arrayOfSyntaxRule3[2] = new SyntaxRule(localSyntaxPattern5, "", "\021\030\004)\021\005\003\030\f\t\013)\021\025\023\030\024\032", arrayOfObject10, 1);
    SyntaxPattern localSyntaxPattern6 = new SyntaxPattern("\f\030\f\007\f\017,\r\027\020\b\b\f\037#", new Object[0], 5);
    Object[] arrayOfObject11 = new Object[3];
    arrayOfObject11[0] = Lit2;
    arrayOfObject11[1] = Lit11;
    arrayOfObject11[2] = PairWithPosition.make(Lit11, LList.Empty, "cut.scm", 401465);
    arrayOfSyntaxRule3[3] = new SyntaxRule(localSyntaxPattern6, "", "\021\030\004\t\0039)\021\030\f\b\033\013)\021\025\023\030\024\"", arrayOfObject11, 1);
    Lit3 = new SyntaxRules(arrayOfObject5, arrayOfSyntaxRule3, 5);
    Object[] arrayOfObject12 = new Object[3];
    arrayOfObject12[0] = Lit0;
    arrayOfObject12[1] = Lit12;
    arrayOfObject12[2] = Lit8;
    SyntaxRule[] arrayOfSyntaxRule4 = new SyntaxRule[4];
    SyntaxPattern localSyntaxPattern7 = new SyntaxPattern("", new Object[0], 3);
    Object[] arrayOfObject13 = new Object[2];
    arrayOfObject13[0] = Lit10;
    arrayOfObject13[1] = ((SimpleSymbol)new SimpleSymbol("begin").readResolve());
    arrayOfSyntaxRule4[0] = new SyntaxRule(localSyntaxPattern7, "\003\001\003", "\021\030\004\031\b\005\003\b)\021\030\f\b\013\b\025\023", arrayOfObject13, 1);
    Object[] arrayOfObject14 = new Object[1];
    arrayOfObject14[0] = Lit8;
    SyntaxPattern localSyntaxPattern8 = new SyntaxPattern("", arrayOfObject14, 3);
    Object[] arrayOfObject15 = new Object[4];
    arrayOfObject15[0] = Lit10;
    arrayOfObject15[1] = Lit14;
    arrayOfObject15[2] = Lit13;
    arrayOfObject15[3] = PairWithPosition.make(Lit14, LList.Empty, "cut.scm", 249918);
    arrayOfSyntaxRule4[1] = new SyntaxRule(localSyntaxPattern8, "\003\001\003", "\021\030\004)\021\005\003\030\f\b\021\030\024\t\013\021\025\023\030\034", arrayOfObject15, 1);
    Object[] arrayOfObject16 = new Object[1];
    arrayOfObject16[0] = Lit12;
    SyntaxPattern localSyntaxPattern9 = new SyntaxPattern("", arrayOfObject16, 3);
    Object[] arrayOfObject17 = new Object[3];
    arrayOfObject17[0] = Lit0;
    arrayOfObject17[1] = PairWithPosition.make(Lit11, LList.Empty, "cut.scm", 266283);
    arrayOfObject17[2] = PairWithPosition.make(Lit11, LList.Empty, "cut.scm", 266300);
    arrayOfSyntaxRule4[2] = new SyntaxRule(localSyntaxPattern9, "", "\021\030\004)\021\005\003\030\f)\021\r\013\030\024\022", arrayOfObject17, 1);
    SyntaxPattern localSyntaxPattern10 = new SyntaxPattern("", new Object[0], 4);
    Object[] arrayOfObject18 = new Object[1];
    arrayOfObject18[0] = Lit0;
    arrayOfSyntaxRule4[3] = new SyntaxRule(localSyntaxPattern10, "", "\021\030\004\031\b\005\003)\021\r\013\b\023\032", arrayOfObject18, 1);
    Lit1 = new SyntaxRules(arrayOfObject12, arrayOfSyntaxRule4, 4);
    $instance = new cut();
    $Prvt$srfi$Mn26$Mninternal$Mncut = Macro.make(Lit0, Lit1, $instance);
    $Prvt$srfi$Mn26$Mninternal$Mncute = Macro.make(Lit2, Lit3, $instance);
    cut = Macro.make(Lit4, Lit5, $instance);
    cute = Macro.make(Lit6, Lit7, $instance);
    $instance.run();
  }

  public cut()
  {
    ModuleInfo.register(this);
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.cut
 * JD-Core Version:    0.6.2
 */