package kawa.lib;

import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.math.IntNum;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.standard.syntax_case;
import kawa.standard.syntax_error;
import kawa.standard.try_catch;

public class prim_syntax extends ModuleBody
{
  public static final prim_syntax $instance;
  static final SimpleSymbol Lit0;
  static final SyntaxRules Lit1;
  static final SyntaxRules Lit10;
  static final SimpleSymbol Lit11;
  static final SyntaxRules Lit12;
  static final SimpleSymbol Lit13;
  static final SyntaxPattern Lit14;
  static final SyntaxTemplate Lit15;
  static final SyntaxTemplate Lit16;
  static final SyntaxPattern Lit17;
  static final SyntaxTemplate Lit18;
  static final SyntaxTemplate Lit19;
  static final SimpleSymbol Lit2;
  static final SyntaxTemplate Lit20;
  static final SyntaxPattern Lit21;
  static final SyntaxTemplate Lit22;
  static final SyntaxPattern Lit23;
  static final SyntaxTemplate Lit24;
  static final SimpleSymbol Lit25;
  static final SyntaxPattern Lit26;
  static final SyntaxTemplate Lit27;
  static final SyntaxTemplate Lit28;
  static final SimpleSymbol Lit29;
  static final SyntaxRules Lit3;
  static final SyntaxPattern Lit30;
  static final SyntaxTemplate Lit31;
  static final SyntaxTemplate Lit32;
  static final SyntaxTemplate Lit33;
  static final SyntaxPattern Lit34;
  static final SyntaxPattern Lit35;
  static final SyntaxTemplate Lit36;
  static final SyntaxTemplate Lit37;
  static final SyntaxTemplate Lit38;
  static final SyntaxPattern Lit39;
  static final SimpleSymbol Lit4;
  static final SyntaxTemplate Lit40;
  static final SyntaxTemplate Lit41;
  static final SyntaxTemplate Lit42;
  static final SyntaxPattern Lit43;
  static final SyntaxPattern Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final SyntaxRules Lit5;
  static final SimpleSymbol Lit50;
  static final IntNum Lit51;
  static final IntNum Lit52;
  static final IntNum Lit53;
  static final IntNum Lit54;
  static final IntNum Lit55;
  static final IntNum Lit56;
  static final SimpleSymbol Lit57;
  static final SimpleSymbol Lit58 = (SimpleSymbol)new SimpleSymbol("lambda").readResolve();
  static final SimpleSymbol Lit6;
  static final SyntaxRules Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final Macro define;
  public static final Macro define$Mnconstant;
  public static final Macro define$Mnprivate;
  public static final Macro define$Mnsyntax;
  public static final Macro jdField_if;
  public static final Macro letrec;
  public static final Macro syntax$Mn$Grexpression;
  public static final Macro syntax$Mnbody$Mn$Grexpression;
  public static final ModuleMethod syntax$Mnerror;
  public static final Macro try$Mncatch;

  static
  {
    Lit57 = (SimpleSymbol)new SimpleSymbol("%define-syntax").readResolve();
    Lit56 = IntNum.make(0);
    Lit55 = IntNum.make(1);
    Lit54 = IntNum.make(4);
    Lit53 = IntNum.make(5);
    Lit52 = IntNum.make(8);
    Lit51 = IntNum.make(9);
    Lit50 = (SimpleSymbol)new SimpleSymbol("%define").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("::").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("quasiquote").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("kawa.lang.SyntaxForms").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("$lookup$").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("set!").readResolve();
    Lit44 = new SyntaxPattern("\033", new Object[0], 4);
    Lit43 = new SyntaxPattern("\034\f\037\b#", new Object[0], 5);
    Lit42 = new SyntaxTemplate("", ":", new Object[0], 0);
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Lit45;
    Lit41 = new SyntaxTemplate("", "\021\030\004\t\033\b3", arrayOfObject1, 0);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = PairWithPosition.make(Special.undefined, LList.Empty, "prim_syntax.scm", 471102);
    Lit40 = new SyntaxTemplate("", "\t\033\t#\t+\030\004", arrayOfObject2, 0);
    Lit39 = new SyntaxPattern("L\f\037\f'\f/\f7\b;", new Object[0], 8);
    Lit38 = new SyntaxTemplate("", "*", new Object[0], 0);
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = Lit45;
    Lit37 = new SyntaxTemplate("", "\021\030\004\t\033\b#", arrayOfObject3, 0);
    Object[] arrayOfObject4 = new Object[1];
    arrayOfObject4[0] = PairWithPosition.make(Special.undefined, LList.Empty, "prim_syntax.scm", 450594);
    Lit36 = new SyntaxTemplate("", "\t\033\030\004", arrayOfObject4, 0);
    Lit35 = new SyntaxPattern(",\f\037\f'\b+", new Object[0], 6);
    Lit34 = new SyntaxPattern("\b", new Object[0], 3);
    Lit33 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Object[] arrayOfObject5 = new Object[1];
    arrayOfObject5[0] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("%let").readResolve(), LList.Empty, "prim_syntax.scm", 512011);
    Lit32 = new SyntaxTemplate("", "\030\004", arrayOfObject5, 0);
    Lit31 = new SyntaxTemplate("", "\013", new Object[0], 0);
    Lit30 = new SyntaxPattern("\f\007\f\017\023", new Object[0], 3);
    Lit29 = (SimpleSymbol)new SimpleSymbol("letrec").readResolve();
    Object[] arrayOfObject6 = new Object[1];
    arrayOfObject6[0] = Lit49;
    Lit28 = new SyntaxTemplate("\001\001\003\003\002", "(\b\025A\b\t\023\021\030\004\b\033\"", arrayOfObject6, 1);
    Lit27 = new SyntaxTemplate("\001\001\003\003\002", "\013", new Object[0], 0);
    Lit26 = new SyntaxPattern("\f\007\f\017-\f\027\f\037#\020\030\b", new Object[0], 5);
    Lit25 = (SimpleSymbol)new SimpleSymbol("try-catch").readResolve();
    Lit24 = new SyntaxTemplate("", "\n", new Object[0], 0);
    Lit23 = new SyntaxPattern("\f\007\013", new Object[0], 2);
    Lit22 = new SyntaxTemplate("", "#", new Object[0], 0);
    Lit21 = new SyntaxPattern("\f\007\f\017\f\027\f\037\f'+", new Object[0], 6);
    Lit20 = new SyntaxTemplate("\001\001\001\001", "\033", new Object[0], 0);
    Lit19 = new SyntaxTemplate("\001\001\001\001", "\023", new Object[0], 0);
    Lit18 = new SyntaxTemplate("\001\001\001\001", "\013", new Object[0], 0);
    Lit17 = new SyntaxPattern("\f\007\f\017\f\027\f\037\b", new Object[0], 4);
    Lit16 = new SyntaxTemplate("\001\001\001", "\023", new Object[0], 0);
    Lit15 = new SyntaxTemplate("\001\001\001", "\013", new Object[0], 0);
    Lit14 = new SyntaxPattern("\f\007\f\017\f\027\b", new Object[0], 3);
    Lit13 = (SimpleSymbol)new SimpleSymbol("jdField_if").readResolve();
    Object[] arrayOfObject7 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("syntax-body->expression").readResolve();
    Lit11 = localSimpleSymbol1;
    arrayOfObject7[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject8 = new Object[1];
    arrayOfObject8[0] = PairWithPosition.make(Lit46, Pair.make(Lit47, Pair.make(Pair.make(Lit48, Pair.make((SimpleSymbol)new SimpleSymbol("rewriteBody").readResolve(), LList.Empty)), LList.Empty)), "prim_syntax.scm", 270343);
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001", "\021\030\004\b\003", arrayOfObject8, 0);
    Lit12 = new SyntaxRules(arrayOfObject7, arrayOfSyntaxRule1, 1);
    Object[] arrayOfObject9 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("syntax->expression").readResolve();
    Lit9 = localSimpleSymbol2;
    arrayOfObject9[0] = localSimpleSymbol2;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject10 = new Object[1];
    arrayOfObject10[0] = PairWithPosition.make(Lit46, Pair.make(Lit47, Pair.make(Pair.make(Lit48, Pair.make((SimpleSymbol)new SimpleSymbol("rewrite").readResolve(), LList.Empty)), LList.Empty)), "prim_syntax.scm", 249863);
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\001", "\021\030\004\b\003", arrayOfObject10, 0);
    Lit10 = new SyntaxRules(arrayOfObject9, arrayOfSyntaxRule2, 1);
    Lit8 = (SimpleSymbol)new SimpleSymbol("syntax-error").readResolve();
    Object[] arrayOfObject11 = new Object[3];
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("define-constant").readResolve();
    Lit6 = localSimpleSymbol3;
    arrayOfObject11[0] = localSimpleSymbol3;
    arrayOfObject11[1] = Lit49;
    arrayOfObject11[2] = Lit46;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[5];
    Object[] arrayOfObject12 = new Object[2];
    arrayOfObject12[0] = Lit46;
    arrayOfObject12[1] = Lit49;
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", arrayOfObject12, 5);
    Object[] arrayOfObject13 = new Object[3];
    arrayOfObject13[0] = Lit50;
    arrayOfObject13[1] = Lit46;
    arrayOfObject13[2] = Lit51;
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\t\033\b#", arrayOfObject13, 0);
    Object[] arrayOfObject14 = new Object[1];
    arrayOfObject14[0] = Lit46;
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", arrayOfObject14, 4);
    Object[] arrayOfObject15 = new Object[4];
    arrayOfObject15[0] = Lit50;
    arrayOfObject15[1] = Lit46;
    arrayOfObject15[2] = Lit52;
    arrayOfSyntaxRule3[1] = new SyntaxRule(localSyntaxPattern4, "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\021\030\034\b\033", arrayOfObject15, 0);
    SyntaxPattern localSyntaxPattern5 = new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3);
    Object[] arrayOfObject16 = new Object[3];
    arrayOfObject16[0] = Lit50;
    arrayOfObject16[1] = IntNum.make(10);
    arrayOfObject16[2] = Boolean.TRUE;
    arrayOfSyntaxRule3[2] = new SyntaxRule(localSyntaxPattern5, "", "\021\030\004\t\003\021\030\f\021\030\024\t\n\022", arrayOfObject16, 0);
    Object[] arrayOfObject17 = new Object[1];
    arrayOfObject17[0] = Lit49;
    SyntaxPattern localSyntaxPattern6 = new SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", arrayOfObject17, 3);
    Object[] arrayOfObject18 = new Object[2];
    arrayOfObject18[0] = Lit50;
    arrayOfObject18[1] = Lit51;
    arrayOfSyntaxRule3[3] = new SyntaxRule(localSyntaxPattern6, "\001\001\001", "\021\030\004\t\003\021\030\f\t\013\b\023", arrayOfObject18, 0);
    SyntaxPattern localSyntaxPattern7 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject19 = new Object[3];
    arrayOfObject19[0] = Lit50;
    arrayOfObject19[1] = Lit52;
    arrayOfSyntaxRule3[4] = new SyntaxRule(localSyntaxPattern7, "\001\001", "\021\030\004\t\003\021\030\f\021\030\024\b\013", arrayOfObject19, 0);
    Lit7 = new SyntaxRules(arrayOfObject11, arrayOfSyntaxRule3, 5);
    Object[] arrayOfObject20 = new Object[3];
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol("define-private").readResolve();
    Lit4 = localSimpleSymbol4;
    arrayOfObject20[0] = localSimpleSymbol4;
    arrayOfObject20[1] = Lit49;
    arrayOfObject20[2] = Lit46;
    SyntaxRule[] arrayOfSyntaxRule4 = new SyntaxRule[5];
    Object[] arrayOfObject21 = new Object[2];
    arrayOfObject21[0] = Lit46;
    arrayOfObject21[1] = Lit49;
    SyntaxPattern localSyntaxPattern8 = new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", arrayOfObject21, 5);
    Object[] arrayOfObject22 = new Object[3];
    arrayOfObject22[0] = Lit50;
    arrayOfObject22[1] = Lit46;
    arrayOfObject22[2] = Lit53;
    arrayOfSyntaxRule4[0] = new SyntaxRule(localSyntaxPattern8, "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\t\033\b#", arrayOfObject22, 0);
    Object[] arrayOfObject23 = new Object[1];
    arrayOfObject23[0] = Lit46;
    SyntaxPattern localSyntaxPattern9 = new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", arrayOfObject23, 4);
    Object[] arrayOfObject24 = new Object[4];
    arrayOfObject24[0] = Lit50;
    arrayOfObject24[1] = Lit46;
    arrayOfObject24[2] = Lit54;
    arrayOfSyntaxRule4[1] = new SyntaxRule(localSyntaxPattern9, "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\021\030\034\b\033", arrayOfObject24, 0);
    SyntaxPattern localSyntaxPattern10 = new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3);
    Object[] arrayOfObject25 = new Object[3];
    arrayOfObject25[0] = Lit50;
    arrayOfObject25[1] = IntNum.make(6);
    arrayOfObject25[2] = Boolean.TRUE;
    arrayOfSyntaxRule4[2] = new SyntaxRule(localSyntaxPattern10, "", "\021\030\004\t\003\021\030\f\021\030\024\t\n\022", arrayOfObject25, 0);
    Object[] arrayOfObject26 = new Object[1];
    arrayOfObject26[0] = Lit49;
    SyntaxPattern localSyntaxPattern11 = new SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", arrayOfObject26, 3);
    Object[] arrayOfObject27 = new Object[2];
    arrayOfObject27[0] = Lit50;
    arrayOfObject27[1] = Lit53;
    arrayOfSyntaxRule4[3] = new SyntaxRule(localSyntaxPattern11, "\001\001\001", "\021\030\004\t\003\021\030\f\t\013\b\023", arrayOfObject27, 0);
    SyntaxPattern localSyntaxPattern12 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject28 = new Object[3];
    arrayOfObject28[0] = Lit50;
    arrayOfObject28[1] = Lit54;
    arrayOfSyntaxRule4[4] = new SyntaxRule(localSyntaxPattern12, "\001\001", "\021\030\004\t\003\021\030\f\021\030\024\b\013", arrayOfObject28, 0);
    Lit5 = new SyntaxRules(arrayOfObject20, arrayOfSyntaxRule4, 5);
    Object[] arrayOfObject29 = new Object[3];
    SimpleSymbol localSimpleSymbol5 = (SimpleSymbol)new SimpleSymbol("define").readResolve();
    Lit2 = localSimpleSymbol5;
    arrayOfObject29[0] = localSimpleSymbol5;
    arrayOfObject29[1] = Lit49;
    arrayOfObject29[2] = Lit46;
    SyntaxRule[] arrayOfSyntaxRule5 = new SyntaxRule[5];
    Object[] arrayOfObject30 = new Object[2];
    arrayOfObject30[0] = Lit46;
    arrayOfObject30[1] = Lit49;
    SyntaxPattern localSyntaxPattern13 = new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\n\f\037\f'\b", arrayOfObject30, 5);
    Object[] arrayOfObject31 = new Object[3];
    arrayOfObject31[0] = Lit50;
    arrayOfObject31[1] = Lit46;
    arrayOfObject31[2] = Lit55;
    arrayOfSyntaxRule5[0] = new SyntaxRule(localSyntaxPattern13, "\001\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\t\033\b#", arrayOfObject31, 0);
    Object[] arrayOfObject32 = new Object[1];
    arrayOfObject32[0] = Lit46;
    SyntaxPattern localSyntaxPattern14 = new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", arrayOfObject32, 4);
    Object[] arrayOfObject33 = new Object[4];
    arrayOfObject33[0] = Lit50;
    arrayOfObject33[1] = Lit46;
    arrayOfObject33[2] = Lit56;
    arrayOfSyntaxRule5[1] = new SyntaxRule(localSyntaxPattern14, "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\021\030\024\021\030\034\b\033", arrayOfObject33, 0);
    SyntaxPattern localSyntaxPattern15 = new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3);
    Object[] arrayOfObject34 = new Object[3];
    arrayOfObject34[0] = Lit50;
    arrayOfObject34[1] = IntNum.make(2);
    arrayOfObject34[2] = Boolean.TRUE;
    arrayOfSyntaxRule5[2] = new SyntaxRule(localSyntaxPattern15, "", "\021\030\004\t\003\021\030\f\021\030\024\t\n\022", arrayOfObject34, 0);
    Object[] arrayOfObject35 = new Object[1];
    arrayOfObject35[0] = Lit49;
    SyntaxPattern localSyntaxPattern16 = new SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", arrayOfObject35, 3);
    Object[] arrayOfObject36 = new Object[2];
    arrayOfObject36[0] = Lit50;
    arrayOfObject36[1] = Lit55;
    arrayOfSyntaxRule5[3] = new SyntaxRule(localSyntaxPattern16, "\001\001\001", "\021\030\004\t\003\021\030\f\t\013\b\023", arrayOfObject36, 0);
    SyntaxPattern localSyntaxPattern17 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject37 = new Object[3];
    arrayOfObject37[0] = Lit50;
    arrayOfObject37[1] = Lit56;
    arrayOfSyntaxRule5[4] = new SyntaxRule(localSyntaxPattern17, "\001\001", "\021\030\004\t\003\021\030\f\021\030\024\b\013", arrayOfObject37, 0);
    Lit3 = new SyntaxRules(arrayOfObject29, arrayOfSyntaxRule5, 5);
    Object[] arrayOfObject38 = new Object[2];
    SimpleSymbol localSimpleSymbol6 = (SimpleSymbol)new SimpleSymbol("define-syntax").readResolve();
    Lit0 = localSimpleSymbol6;
    arrayOfObject38[0] = localSimpleSymbol6;
    arrayOfObject38[1] = Lit46;
    SyntaxRule[] arrayOfSyntaxRule6 = new SyntaxRule[4];
    Object[] arrayOfObject39 = new Object[1];
    arrayOfObject39[0] = Lit46;
    SyntaxPattern localSyntaxPattern18 = new SyntaxPattern("\f\030l\\\f\002\f\007,\f\017\f\027\b\b\033#", arrayOfObject39, 5);
    Object[] arrayOfObject40 = new Object[3];
    arrayOfObject40[0] = Lit57;
    arrayOfObject40[1] = Lit46;
    arrayOfObject40[2] = Lit58;
    arrayOfSyntaxRule6[0] = new SyntaxRule(localSyntaxPattern18, "", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\b\021\030\024\t\032\"", arrayOfObject40, 0);
    Object[] arrayOfObject41 = new Object[1];
    arrayOfObject41[0] = Lit46;
    SyntaxPattern localSyntaxPattern19 = new SyntaxPattern("\f\030\\\f\002\f\007,\f\017\f\027\b\b\f\037\b", arrayOfObject41, 4);
    Object[] arrayOfObject42 = new Object[2];
    arrayOfObject42[0] = Lit57;
    arrayOfObject42[1] = Lit46;
    arrayOfSyntaxRule6[1] = new SyntaxRule(localSyntaxPattern19, "\001\001\001\001", "\021\030\004Q\021\030\f\t\003\b\t\013\b\023\b\033", arrayOfObject42, 0);
    SyntaxPattern localSyntaxPattern20 = new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3);
    Object[] arrayOfObject43 = new Object[2];
    arrayOfObject43[0] = Lit57;
    arrayOfObject43[1] = Lit58;
    arrayOfSyntaxRule6[2] = new SyntaxRule(localSyntaxPattern20, "", "\021\030\004\t\003\b\021\030\f\t\n\022", arrayOfObject43, 0);
    SyntaxPattern localSyntaxPattern21 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject44 = new Object[1];
    arrayOfObject44[0] = Lit57;
    arrayOfSyntaxRule6[3] = new SyntaxRule(localSyntaxPattern21, "\001\001", "\021\030\004\t\003\b\013", arrayOfObject44, 0);
    Lit1 = new SyntaxRules(arrayOfObject38, arrayOfSyntaxRule6, 5);
    $instance = new prim_syntax();
    define$Mnsyntax = Macro.make(Lit0, Lit1, $instance);
    define = Macro.make(Lit2, Lit3, $instance);
    define$Mnprivate = Macro.make(Lit4, Lit5, $instance);
    define$Mnconstant = Macro.make(Lit6, Lit7, $instance);
    prim_syntax localprim_syntax = $instance;
    syntax$Mnerror = new ModuleMethod(localprim_syntax, 1, Lit8, -4095);
    syntax$Mn$Grexpression = Macro.make(Lit9, Lit10, $instance);
    syntax$Mnbody$Mn$Grexpression = Macro.make(Lit11, Lit12, $instance);
    SimpleSymbol localSimpleSymbol7 = Lit13;
    ModuleMethod localModuleMethod1 = new ModuleMethod(localprim_syntax, 2, null, 4097);
    localModuleMethod1.setProperty("source-location", "prim_syntax.scm:69");
    jdField_if = Macro.make(localSimpleSymbol7, localModuleMethod1, $instance);
    SimpleSymbol localSimpleSymbol8 = Lit25;
    ModuleMethod localModuleMethod2 = new ModuleMethod(localprim_syntax, 3, null, 4097);
    localModuleMethod2.setProperty("source-location", "prim_syntax.scm:89");
    try$Mncatch = Macro.make(localSimpleSymbol8, localModuleMethod2, $instance);
    SimpleSymbol localSimpleSymbol9 = Lit29;
    ModuleMethod localModuleMethod3 = new ModuleMethod(localprim_syntax, 4, null, 4097);
    localModuleMethod3.setProperty("source-location", "prim_syntax.scm:98");
    letrec = Macro.make(localSimpleSymbol9, localModuleMethod3, $instance);
    $instance.run();
  }

  public prim_syntax()
  {
    ModuleInfo.register(this);
  }

  static Object lambda1(Object paramObject)
  {
    Object[] arrayOfObject1 = SyntaxPattern.allocVars(6, null);
    if (Lit14.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope6 = TemplateScope.make();
      Expression localExpression3 = SyntaxForms.rewrite(Lit15.execute(arrayOfObject1, localTemplateScope6));
      TemplateScope localTemplateScope7 = TemplateScope.make();
      return new IfExp(localExpression3, SyntaxForms.rewrite(Lit16.execute(arrayOfObject1, localTemplateScope7)), null);
    }
    if (Lit17.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope3 = TemplateScope.make();
      Expression localExpression1 = SyntaxForms.rewrite(Lit18.execute(arrayOfObject1, localTemplateScope3));
      TemplateScope localTemplateScope4 = TemplateScope.make();
      Expression localExpression2 = SyntaxForms.rewrite(Lit19.execute(arrayOfObject1, localTemplateScope4));
      TemplateScope localTemplateScope5 = TemplateScope.make();
      return new IfExp(localExpression1, localExpression2, SyntaxForms.rewrite(Lit20.execute(arrayOfObject1, localTemplateScope5)));
    }
    if (Lit21.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      Object localObject2 = Lit22.execute(arrayOfObject1, localTemplateScope2);
      if (("too many expressions for 'if'" instanceof Object[]));
      for (Object[] arrayOfObject3 = (Object[])"too many expressions for 'if'"; ; arrayOfObject3 = new Object[] { "too many expressions for 'if'" })
        return syntaxError(localObject2, arrayOfObject3);
    }
    if (Lit23.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      Object localObject1 = Lit24.execute(arrayOfObject1, localTemplateScope1);
      if (("too few expressions for 'if'" instanceof Object[]));
      for (Object[] arrayOfObject2 = (Object[])"too few expressions for 'if'"; ; arrayOfObject2 = new Object[] { "too few expressions for 'if'" })
        return syntaxError(localObject1, arrayOfObject2);
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  static Object lambda2(Object paramObject)
  {
    Object[] arrayOfObject = SyntaxPattern.allocVars(5, null);
    if (Lit26.match(paramObject, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      Object localObject = Lit27.execute(arrayOfObject, localTemplateScope1);
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return try_catch.rewrite(localObject, Lit28.execute(arrayOfObject, localTemplateScope2));
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  static Object lambda3(Object paramObject)
  {
    frame localframe = new frame();
    LList localLList = LList.Empty;
    localframe.out$Mninits = LList.Empty;
    localframe.out$Mnbindings = localLList;
    localframe.$unnamed$0 = SyntaxPattern.allocVars(3, null);
    if (Lit30.match(paramObject, localframe.$unnamed$0, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      localframe.lambda4processBinding(Lit31.execute(localframe.$unnamed$0, localTemplateScope1));
      localframe.out$Mnbindings = LList.reverseInPlace(localframe.out$Mnbindings);
      localframe.out$Mninits = LList.reverseInPlace(localframe.out$Mninits);
      TemplateScope localTemplateScope2 = TemplateScope.make();
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Lit32.execute(localframe.$unnamed$0, localTemplateScope2);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = localframe.out$Mnbindings;
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = localframe.out$Mninits;
      arrayOfObject3[1] = Lit33.execute(localframe.$unnamed$0, localTemplateScope2);
      arrayOfObject2[1] = Quote.append$V(arrayOfObject3);
      arrayOfObject1[1] = Quote.consX$V(arrayOfObject2);
      return Quote.append$V(arrayOfObject1);
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  public static Expression syntaxError(Object paramObject, Object[] paramArrayOfObject)
  {
    return syntax_error.error(paramObject, paramArrayOfObject);
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply1(paramModuleMethod, paramObject);
    case 2:
      return lambda1(paramObject);
    case 3:
      return lambda2(paramObject);
    case 4:
    }
    return lambda3(paramObject);
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    if (paramModuleMethod.selector == 1)
    {
      Object localObject = paramArrayOfObject[0];
      int i = paramArrayOfObject.length - 1;
      Object[] arrayOfObject = new Object[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          return syntaxError(localObject, arrayOfObject);
        arrayOfObject[j] = paramArrayOfObject[(j + 1)];
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
    case 4:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
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
    Object[] $unnamed$0;
    Object out$Mnbindings;
    Object out$Mninits;

    public Object lambda4processBinding(Object paramObject)
    {
      Object[] arrayOfObject1 = SyntaxPattern.allocVars(8, this.$unnamed$0);
      if (prim_syntax.Lit34.match(paramObject, arrayOfObject1, 0))
        return Values.empty;
      if (prim_syntax.Lit35.match(paramObject, arrayOfObject1, 0))
      {
        TemplateScope localTemplateScope4 = TemplateScope.make();
        this.out$Mnbindings = new Pair(prim_syntax.Lit36.execute(arrayOfObject1, localTemplateScope4), this.out$Mnbindings);
        TemplateScope localTemplateScope5 = TemplateScope.make();
        this.out$Mninits = new Pair(prim_syntax.Lit37.execute(arrayOfObject1, localTemplateScope5), this.out$Mninits);
        TemplateScope localTemplateScope6 = TemplateScope.make();
        return lambda4processBinding(prim_syntax.Lit38.execute(arrayOfObject1, localTemplateScope6));
      }
      if (prim_syntax.Lit39.match(paramObject, arrayOfObject1, 0))
      {
        TemplateScope localTemplateScope1 = TemplateScope.make();
        this.out$Mnbindings = new Pair(prim_syntax.Lit40.execute(arrayOfObject1, localTemplateScope1), this.out$Mnbindings);
        TemplateScope localTemplateScope2 = TemplateScope.make();
        this.out$Mninits = new Pair(prim_syntax.Lit41.execute(arrayOfObject1, localTemplateScope2), this.out$Mninits);
        TemplateScope localTemplateScope3 = TemplateScope.make();
        return lambda4processBinding(prim_syntax.Lit42.execute(arrayOfObject1, localTemplateScope3));
      }
      if (prim_syntax.Lit43.match(paramObject, arrayOfObject1, 0))
      {
        if (("missing initializion in letrec" instanceof Object[]));
        for (Object[] arrayOfObject3 = (Object[])"missing initializion in letrec"; ; arrayOfObject3 = new Object[] { "missing initializion in letrec" })
          return prim_syntax.syntaxError(paramObject, arrayOfObject3);
      }
      if (prim_syntax.Lit44.match(paramObject, arrayOfObject1, 0))
      {
        if (("invalid bindings syntax in letrec" instanceof Object[]));
        for (Object[] arrayOfObject2 = (Object[])"invalid bindings syntax in letrec"; ; arrayOfObject2 = new Object[] { "invalid bindings syntax in letrec" })
          return prim_syntax.syntaxError(paramObject, arrayOfObject2);
      }
      return syntax_case.error("syntax-case", paramObject);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.prim_syntax
 * JD-Core Version:    0.6.2
 */