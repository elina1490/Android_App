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

public class DefineRecordType extends ModuleBody
{
  public static final Macro $Prvt$$Pcdefine$Mnrecord$Mnfield;
  public static final DefineRecordType $instance;
  static final SimpleSymbol Lit0;
  static final SyntaxRules Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12 = (SimpleSymbol)new SimpleSymbol("tmp").readResolve();
  static final SimpleSymbol Lit2;
  static final SyntaxRules Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final Macro define$Mnrecord$Mntype;

  static
  {
    Lit11 = (SimpleSymbol)new SimpleSymbol("slot-set!").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("begin").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("value").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("slot-ref").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("::").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("obj").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("define").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("%define-record-field").readResolve();
    Lit2 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject2 = new Object[5];
    arrayOfObject2[0] = Lit4;
    arrayOfObject2[1] = Lit5;
    arrayOfObject2[2] = Lit6;
    arrayOfObject2[3] = Lit7;
    arrayOfObject2[4] = Lit8;
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001\001\001", "\021\030\004Y\t\023\b\021\030\f\021\030\024\b\003\b\021\030\034\021\030\f\b\021\030$\b\013", arrayOfObject2, 0);
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037\b", new Object[0], 4);
    Object[] arrayOfObject3 = new Object[10];
    arrayOfObject3[0] = Lit10;
    arrayOfObject3[1] = Lit4;
    arrayOfObject3[2] = Lit5;
    arrayOfObject3[3] = Lit6;
    arrayOfObject3[4] = Lit7;
    arrayOfObject3[5] = Lit8;
    arrayOfObject3[6] = PairWithPosition.make(Lit9, LList.Empty, "DefineRecordType.scm", 208936);
    arrayOfObject3[7] = ((SimpleSymbol)new SimpleSymbol("<void>").readResolve());
    arrayOfObject3[8] = Lit11;
    arrayOfObject3[9] = PairWithPosition.make(Lit9, LList.Empty, "DefineRecordType.scm", 213021);
    arrayOfSyntaxRule1[1] = new SyntaxRule(localSyntaxPattern2, "\001\001\001\001", "\021\030\004á\021\030\fY\t\023\b\021\030\024\021\030\034\b\003\b\021\030$\021\030\024\b\021\030,\b\013\b\021\030\fi\t\033A\021\030\024\021\030\034\b\003\0304\021\030\034\021\030<\b\021\030D\021\030\024)\021\030,\b\013\030L", arrayOfObject3, 0);
    Lit3 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 4);
    Object[] arrayOfObject4 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("define-record-type").readResolve();
    Lit0 = localSimpleSymbol2;
    arrayOfObject4[0] = localSimpleSymbol2;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007<\f\017\r\027\020\b\b\f\037-\f'\f/3 \030\b", new Object[0], 7);
    Object[] arrayOfObject5 = new Object[15];
    arrayOfObject5[0] = Lit10;
    arrayOfObject5[1] = ((SimpleSymbol)new SimpleSymbol("define-simple-class").readResolve());
    arrayOfObject5[2] = Lit4;
    arrayOfObject5[3] = PairWithPosition.make(Lit5, LList.Empty, "DefineRecordType.scm", 122907);
    arrayOfObject5[4] = Lit6;
    arrayOfObject5[5] = ((SimpleSymbol)new SimpleSymbol("<boolean>").readResolve());
    arrayOfObject5[6] = ((SimpleSymbol)new SimpleSymbol("instance?").readResolve());
    arrayOfObject5[7] = Lit5;
    arrayOfObject5[8] = ((SimpleSymbol)new SimpleSymbol("let").readResolve());
    arrayOfObject5[9] = Lit12;
    arrayOfObject5[10] = ((SimpleSymbol)new SimpleSymbol("make").readResolve());
    arrayOfObject5[11] = Lit11;
    arrayOfObject5[12] = Lit8;
    arrayOfObject5[13] = PairWithPosition.make(Lit12, LList.Empty, "DefineRecordType.scm", 143365);
    arrayOfObject5[14] = Lit2;
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern3, "\001\001\003\001\003\003\002", "\021\030\004Y\021\030\f\t\003\t\020\b%\b#¹\021\030\024!\t\033\030\034\021\030$\021\030,\b\021\0304\021\030<\b\003ǁ\021\030\024)\t\013\b\025\023\021\030$\t\003\b\021\030Dy\b\021\030L\021\030$\t\003\b\021\030T\b\003\021\030\004\b\025\021\030\\\021\030L)\021\030d\b\023\b\023\030l\b%\021\030t\t\003\t#\t+2", arrayOfObject5, 1);
    Lit1 = new SyntaxRules(arrayOfObject4, arrayOfSyntaxRule2, 7);
    $instance = new DefineRecordType();
    define$Mnrecord$Mntype = Macro.make(Lit0, Lit1, $instance);
    $Prvt$$Pcdefine$Mnrecord$Mnfield = Macro.make(Lit2, Lit3, $instance);
    $instance.run();
  }

  public DefineRecordType()
  {
    ModuleInfo.register(this);
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.DefineRecordType
 * JD-Core Version:    0.6.2
 */