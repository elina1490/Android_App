package kawa.lib;

import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.QuoteExp;
import gnu.expr.Symbols;
import gnu.kawa.functions.AddOp;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Eval;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;
import kawa.standard.Scheme;
import kawa.standard.syntax_case;

public class std_syntax extends ModuleBody
{
  public static final Macro $Prvt$$Pccase;
  public static final Macro $Prvt$$Pccase$Mnmatch;
  public static final Macro $Prvt$$Pcdo$Mninit;
  public static final Macro $Prvt$$Pcdo$Mnlambda1;
  public static final Macro $Prvt$$Pcdo$Mnlambda2;
  public static final Macro $Prvt$$Pcdo$Mnstep;
  public static final Macro $Prvt$$Pclet$Mninit;
  public static final Macro $Prvt$$Pclet$Mnlambda1;
  public static final Macro $Prvt$$Pclet$Mnlambda2;
  public static final Location $Prvt$define;
  public static final Location $Prvt$define$Mnconstant;
  public static final Location $Prvt$if;
  public static final Location $Prvt$letrec;
  public static final std_syntax $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final SimpleSymbol Lit10;
  static final SyntaxPattern Lit11;
  static final SyntaxPattern Lit12;
  static final SyntaxTemplate Lit13;
  static final SyntaxPattern Lit14;
  static final SyntaxTemplate Lit15;
  static final SimpleSymbol Lit16;
  static final SyntaxPattern Lit17;
  static final SyntaxPattern Lit18;
  static final SyntaxTemplate Lit19;
  static final SimpleSymbol Lit2;
  static final SyntaxPattern Lit20;
  static final SyntaxTemplate Lit21;
  static final SimpleSymbol Lit22;
  static final SyntaxRules Lit23;
  static final SimpleSymbol Lit24;
  static final SyntaxRules Lit25;
  static final SimpleSymbol Lit26;
  static final SyntaxRules Lit27;
  static final SimpleSymbol Lit28;
  static final SyntaxRules Lit29;
  static final SyntaxRules Lit3;
  static final SimpleSymbol Lit30;
  static final SyntaxRules Lit31;
  static final SimpleSymbol Lit32;
  static final SyntaxRules Lit33;
  static final SimpleSymbol Lit34;
  static final SyntaxRules Lit35;
  static final SimpleSymbol Lit36;
  static final SyntaxRules Lit37;
  static final SimpleSymbol Lit38;
  static final SyntaxRules Lit39;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit40;
  static final SyntaxRules Lit41;
  static final SimpleSymbol Lit42;
  static final SyntaxRules Lit43;
  static final SimpleSymbol Lit44;
  static final SyntaxRules Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final SyntaxRules Lit5;
  static final SimpleSymbol Lit50;
  static final SimpleSymbol Lit51;
  static final SimpleSymbol Lit52;
  static final SimpleSymbol Lit53;
  static final SimpleSymbol Lit54;
  static final SyntaxPattern Lit55;
  static final SimpleSymbol Lit56;
  static final SyntaxTemplate Lit57;
  static final SyntaxTemplate Lit58;
  static final SimpleSymbol Lit59;
  static final SimpleSymbol Lit6;
  static final SyntaxRules Lit60;
  static final SimpleSymbol Lit61;
  static final SyntaxRules Lit62;
  static final SimpleSymbol Lit63;
  static final SimpleSymbol Lit64;
  static final SimpleSymbol Lit65;
  static final SimpleSymbol Lit66;
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final SyntaxRules Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final SimpleSymbol Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final SimpleSymbol Lit77 = (SimpleSymbol)new SimpleSymbol("temp").readResolve();
  static final SimpleSymbol Lit8;
  static final SyntaxRules Lit9;
  public static final Macro and;
  public static final Macro begin$Mnfor$Mnsyntax;
  public static final Macro jdField_case;
  public static final Macro cond;
  public static final ModuleMethod datum$Mn$Grsyntax$Mnobject;
  public static final Macro define$Mnfor$Mnsyntax;
  public static final Macro define$Mnprocedure;
  public static final Macro delay;
  public static final Macro jdField_do;
  public static final ModuleMethod free$Mnidentifier$Eq$Qu;
  public static final ModuleMethod generate$Mntemporaries;
  public static final ModuleMethod identifier$Qu;
  public static final Macro let;
  public static final Macro let$St;
  public static final Macro or;
  public static final ModuleMethod syntax$Mncolumn;
  public static final ModuleMethod syntax$Mnline;
  public static final ModuleMethod syntax$Mnobject$Mn$Grdatum;
  public static final ModuleMethod syntax$Mnsource;
  public static final Macro with$Mnsyntax;

  static
  {
    Lit76 = (SimpleSymbol)new SimpleSymbol("=>").readResolve();
    Lit75 = (SimpleSymbol)new SimpleSymbol("else").readResolve();
    Lit74 = (SimpleSymbol)new SimpleSymbol("eqv?").readResolve();
    Lit73 = (SimpleSymbol)new SimpleSymbol("x").readResolve();
    Lit72 = (SimpleSymbol)new SimpleSymbol("if").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("letrec").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("%let").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("%syntax-error").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("lambda").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("make").readResolve();
    Lit66 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit65 = (SimpleSymbol)new SimpleSymbol("<gnu.expr.GenericProc>").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("::").readResolve();
    Lit63 = (SimpleSymbol)new SimpleSymbol("syntax-case").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("with-syntax").readResolve();
    Lit61 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[3];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\b\f\007\r\017\b\b\b", new Object[0], 2);
    Object[] arrayOfObject2 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("begin").readResolve();
    Lit56 = localSimpleSymbol2;
    arrayOfObject2[0] = localSimpleSymbol2;
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001\003", "\021\030\004\t\003\b\r\013", arrayOfObject2, 1);
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030<,\f\007\f\017\b\b\f\027\r\037\030\b\b", new Object[0], 4);
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = Lit63;
    arrayOfObject3[1] = Lit56;
    arrayOfSyntaxRule1[1] = new SyntaxRule(localSyntaxPattern2, "\001\001\001\003", "\021\030\004\t\013\t\020\b\t\003\b\021\030\f\t\023\b\035\033", arrayOfObject3, 1);
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("", new Object[0], 4);
    Object[] arrayOfObject4 = new Object[3];
    arrayOfObject4[0] = Lit63;
    arrayOfObject4[1] = ((SimpleSymbol)new SimpleSymbol("list").readResolve());
    arrayOfObject4[2] = Lit56;
    arrayOfSyntaxRule1[2] = new SyntaxRule(localSyntaxPattern3, "\003\003\001\003", "\021\030\0041\021\030\f\b\r\013\t\020\b\031\b\005\003\b\021\030\024\t\023\b\035\033", arrayOfObject4, 1);
    Lit62 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 4);
    Object[] arrayOfObject5 = new Object[1];
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("define-for-syntax").readResolve();
    Lit59 = localSimpleSymbol3;
    arrayOfObject5[0] = localSimpleSymbol3;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("\f\030\003", new Object[0], 1);
    Object[] arrayOfObject6 = new Object[2];
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol("begin-for-syntax").readResolve();
    Lit54 = localSimpleSymbol4;
    arrayOfObject6[0] = localSimpleSymbol4;
    arrayOfObject6[1] = ((SimpleSymbol)new SimpleSymbol("define").readResolve());
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern4, "", "\021\030\004\b\021\030\f\002", arrayOfObject6, 0);
    Lit60 = new SyntaxRules(arrayOfObject5, arrayOfSyntaxRule2, 1);
    Object[] arrayOfObject7 = new Object[1];
    arrayOfObject7[0] = Values.empty;
    Lit58 = new SyntaxTemplate("", "\030\004", arrayOfObject7, 0);
    Lit57 = new SyntaxTemplate("", "\n", new Object[0], 0);
    Lit55 = new SyntaxPattern("\f\007\013", new Object[0], 2);
    Lit53 = (SimpleSymbol)new SimpleSymbol("syntax-column").readResolve();
    Lit52 = (SimpleSymbol)new SimpleSymbol("syntax-line").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("syntax-source").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("free-identifier=?").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("identifier?").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("generate-temporaries").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("datum->syntax-object").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("syntax-object->datum").readResolve();
    Object[] arrayOfObject8 = new Object[3];
    SimpleSymbol localSimpleSymbol5 = (SimpleSymbol)new SimpleSymbol("define-procedure").readResolve();
    Lit44 = localSimpleSymbol5;
    arrayOfObject8[0] = localSimpleSymbol5;
    arrayOfObject8[1] = Lit64;
    arrayOfObject8[2] = Lit65;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern5 = new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2);
    Object[] arrayOfObject9 = new Object[9];
    arrayOfObject9[0] = Lit56;
    arrayOfObject9[1] = ((SimpleSymbol)new SimpleSymbol("define-constant").readResolve());
    arrayOfObject9[2] = Lit64;
    arrayOfObject9[3] = Lit65;
    arrayOfObject9[4] = Lit67;
    arrayOfObject9[5] = Lit66;
    arrayOfObject9[6] = ((SimpleSymbol)new SimpleSymbol("invoke").readResolve());
    arrayOfObject9[7] = PairWithPosition.make(Lit66, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("setProperties").readResolve(), LList.Empty, "std_syntax.scm", 1024020), "std_syntax.scm", 1024020);
    arrayOfObject9[8] = ((SimpleSymbol)new SimpleSymbol("java.lang.Object[]").readResolve());
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern5, "\001\003", "\021\030\004Á\021\030\f\t\003\021\030\024\021\030\034\b\021\030$\021\030\034\b\021\030,\b\003\b\021\0304\t\003\021\030<\b\021\030D\b\r\013", arrayOfObject9, 1);
    Lit45 = new SyntaxRules(arrayOfObject8, arrayOfSyntaxRule3, 2);
    Object[] arrayOfObject10 = new Object[1];
    SimpleSymbol localSimpleSymbol6 = (SimpleSymbol)new SimpleSymbol("delay").readResolve();
    Lit42 = localSimpleSymbol6;
    arrayOfObject10[0] = localSimpleSymbol6;
    SyntaxRule[] arrayOfSyntaxRule4 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern6 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject11 = new Object[3];
    arrayOfObject11[0] = Lit67;
    arrayOfObject11[1] = ((SimpleSymbol)new SimpleSymbol("<kawa.lang.Promise>").readResolve());
    arrayOfObject11[2] = Lit68;
    arrayOfSyntaxRule4[0] = new SyntaxRule(localSyntaxPattern6, "\001", "\021\030\004\021\030\f\b\021\030\024\t\020\b\003", arrayOfObject11, 0);
    Lit43 = new SyntaxRules(arrayOfObject10, arrayOfSyntaxRule4, 1);
    Object[] arrayOfObject12 = new Object[2];
    SimpleSymbol localSimpleSymbol7 = (SimpleSymbol)new SimpleSymbol("jdField_do").readResolve();
    Lit40 = localSimpleSymbol7;
    arrayOfObject12[0] = localSimpleSymbol7;
    arrayOfObject12[1] = Lit64;
    SyntaxRule[] arrayOfSyntaxRule5 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern7 = new SyntaxPattern("", new Object[0], 4);
    Object[] arrayOfObject13 = new Object[9];
    arrayOfObject13[0] = Lit71;
    arrayOfObject13[1] = ((SimpleSymbol)new SimpleSymbol("%do%loop").readResolve());
    SimpleSymbol localSimpleSymbol8 = (SimpleSymbol)new SimpleSymbol("%do-lambda1").readResolve();
    Lit36 = localSimpleSymbol8;
    arrayOfObject13[2] = localSimpleSymbol8;
    arrayOfObject13[3] = Lit72;
    arrayOfObject13[4] = ((SimpleSymbol)new SimpleSymbol("not").readResolve());
    arrayOfObject13[5] = Lit56;
    SimpleSymbol localSimpleSymbol9 = (SimpleSymbol)new SimpleSymbol("%do-step").readResolve();
    Lit32 = localSimpleSymbol9;
    arrayOfObject13[6] = localSimpleSymbol9;
    arrayOfObject13[7] = Values.empty;
    SimpleSymbol localSimpleSymbol10 = (SimpleSymbol)new SimpleSymbol("%do-init").readResolve();
    Lit34 = localSimpleSymbol10;
    arrayOfObject13[8] = localSimpleSymbol10;
    arrayOfSyntaxRule5[0] = new SyntaxRule(localSyntaxPattern7, "", "\021\030\004Ɖ\b\021\030\f\b\021\030\024\031\b\005\003\t\020\b\021\030\034)\021\030$\b\013\021\030,\021\035\033\b\021\030\f\b\005\021\0304\003\b\021\030,\021\030<\022\b\021\030\f\b\005\021\030D\b\003", arrayOfObject13, 1);
    Lit41 = new SyntaxRules(arrayOfObject12, arrayOfSyntaxRule5, 4);
    Object[] arrayOfObject14 = new Object[1];
    SimpleSymbol localSimpleSymbol11 = (SimpleSymbol)new SimpleSymbol("%do-lambda2").readResolve();
    Lit38 = localSimpleSymbol11;
    arrayOfObject14[0] = localSimpleSymbol11;
    SyntaxRule[] arrayOfSyntaxRule6 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern8 = new SyntaxPattern("\f\030\034\f\007\013\f\027\f\037\b", new Object[0], 4);
    Object[] arrayOfObject15 = new Object[1];
    arrayOfObject15[0] = Lit38;
    arrayOfSyntaxRule6[0] = new SyntaxRule(localSyntaxPattern8, "", "\021\030\004\t\n\031\t\003\023\b\033", arrayOfObject15, 0);
    SyntaxPattern localSyntaxPattern9 = new SyntaxPattern("\f\030\f\b\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject16 = new Object[1];
    arrayOfObject16[0] = Lit68;
    arrayOfSyntaxRule6[1] = new SyntaxRule(localSyntaxPattern9, "\001\001", "\021\030\004\t\003\b\013", arrayOfObject16, 0);
    Lit39 = new SyntaxRules(arrayOfObject14, arrayOfSyntaxRule6, 4);
    Object[] arrayOfObject17 = new Object[2];
    arrayOfObject17[0] = Lit36;
    arrayOfObject17[1] = Lit64;
    SyntaxRule[] arrayOfSyntaxRule7 = new SyntaxRule[5];
    Object[] arrayOfObject18 = new Object[1];
    arrayOfObject18[0] = Lit64;
    SyntaxPattern localSyntaxPattern10 = new SyntaxPattern("\f\030l\\\f\007\f\002\f\017\f\027\f\037\b#\f/\f7\b", arrayOfObject18, 7);
    Object[] arrayOfObject19 = new Object[2];
    arrayOfObject19[0] = Lit36;
    arrayOfObject19[1] = Lit64;
    arrayOfSyntaxRule7[0] = new SyntaxRule(localSyntaxPattern10, "", "\021\030\004\t\"I9\t\003\021\030\f\b\013+\b3", arrayOfObject19, 0);
    Object[] arrayOfObject20 = new Object[1];
    arrayOfObject20[0] = Lit64;
    SyntaxPattern localSyntaxPattern11 = new SyntaxPattern("\f\030\\L\f\007\f\002\f\017\f\027\b\033\f'\f/\b", arrayOfObject20, 6);
    Object[] arrayOfObject21 = new Object[2];
    arrayOfObject21[0] = Lit36;
    arrayOfObject21[1] = Lit64;
    arrayOfSyntaxRule7[1] = new SyntaxRule(localSyntaxPattern11, "", "\021\030\004\t\032I9\t\003\021\030\f\b\013#\b+", arrayOfObject21, 0);
    SyntaxPattern localSyntaxPattern12 = new SyntaxPattern("\f\030L<\f\007\f\017\f\027\b\033\f'\f/\b", new Object[0], 6);
    Object[] arrayOfObject22 = new Object[1];
    arrayOfObject22[0] = Lit36;
    arrayOfSyntaxRule7[2] = new SyntaxRule(localSyntaxPattern12, "", "\021\030\004\t\032\031\t\003#\b+", arrayOfObject22, 0);
    SyntaxPattern localSyntaxPattern13 = new SyntaxPattern("\f\030<,\f\007\f\017\b\023\f\037\f'\b", new Object[0], 5);
    Object[] arrayOfObject23 = new Object[1];
    arrayOfObject23[0] = Lit36;
    arrayOfSyntaxRule7[3] = new SyntaxRule(localSyntaxPattern13, "", "\021\030\004\t\022\031\t\003\033\b#", arrayOfObject23, 0);
    SyntaxPattern localSyntaxPattern14 = new SyntaxPattern("\f\030\f\b\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject24 = new Object[1];
    arrayOfObject24[0] = Lit38;
    arrayOfSyntaxRule7[4] = new SyntaxRule(localSyntaxPattern14, "\001\001", "\021\030\004\t\003\t\020\b\013", arrayOfObject24, 0);
    Lit37 = new SyntaxRules(arrayOfObject17, arrayOfSyntaxRule7, 7);
    Object[] arrayOfObject25 = new Object[2];
    arrayOfObject25[0] = Lit34;
    arrayOfObject25[1] = Lit64;
    SyntaxRule[] arrayOfSyntaxRule8 = new SyntaxRule[7];
    Object[] arrayOfObject26 = new Object[1];
    arrayOfObject26[0] = Lit64;
    arrayOfSyntaxRule8[0] = new SyntaxRule(new SyntaxPattern("\f\030\\\f\007\f\002\f\017\f\027\f\037\b\b", arrayOfObject26, 4), "\001\001\001\001", "\023", new Object[0], 0);
    Object[] arrayOfObject27 = new Object[1];
    arrayOfObject27[0] = Lit64;
    arrayOfSyntaxRule8[1] = new SyntaxRule(new SyntaxPattern("\f\030L\f\007\f\002\f\017\f\027\b\b", arrayOfObject27, 3), "\001\001\001", "\023", new Object[0], 0);
    arrayOfSyntaxRule8[2] = new SyntaxRule(new SyntaxPattern("\f\030<\f\007\f\017\f\027\b\b", new Object[0], 3), "\001\001\001", "\013", new Object[0], 0);
    arrayOfSyntaxRule8[3] = new SyntaxRule(new SyntaxPattern("\f\030,\f\007\f\017\b\b", new Object[0], 2), "\001\001", "\013", new Object[0], 0);
    arrayOfSyntaxRule8[4] = new SyntaxRule(new SyntaxPattern("\f\030<\f\007\f\017\f\027\b\b", new Object[0], 3), "\001\001\001", "\023", new Object[0], 0);
    SyntaxPattern localSyntaxPattern15 = new SyntaxPattern("\f\030\034\f\007\b\b", new Object[0], 1);
    Object[] arrayOfObject28 = new Object[1];
    arrayOfObject28[0] = PairWithPosition.make(Lit69, PairWithPosition.make("do binding with no value", LList.Empty, "std_syntax.scm", 794643), "std_syntax.scm", 794628);
    arrayOfSyntaxRule8[5] = new SyntaxRule(localSyntaxPattern15, "\001", "\030\004", arrayOfObject28, 0);
    SyntaxPattern localSyntaxPattern16 = new SyntaxPattern("\f\030L\f\007\f\017\f\027\f\037\b\b", new Object[0], 4);
    Object[] arrayOfObject29 = new Object[1];
    arrayOfObject29[0] = PairWithPosition.make(Lit69, PairWithPosition.make("do binding must have syntax: (var [:: type] init [step])", LList.Empty, "std_syntax.scm", 806917), "std_syntax.scm", 802820);
    arrayOfSyntaxRule8[6] = new SyntaxRule(localSyntaxPattern16, "\001\001\001\001", "\030\004", arrayOfObject29, 0);
    Lit35 = new SyntaxRules(arrayOfObject25, arrayOfSyntaxRule8, 4);
    Object[] arrayOfObject30 = new Object[2];
    arrayOfObject30[0] = Lit32;
    arrayOfObject30[1] = Lit64;
    SyntaxRule[] arrayOfSyntaxRule9 = new SyntaxRule[4];
    Object[] arrayOfObject31 = new Object[1];
    arrayOfObject31[0] = Lit64;
    arrayOfSyntaxRule9[0] = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\f\037\b", arrayOfObject31, 4), "\001\001\001\001", "\033", new Object[0], 0);
    Object[] arrayOfObject32 = new Object[1];
    arrayOfObject32[0] = Lit64;
    arrayOfSyntaxRule9[1] = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\002\f\017\f\027\b", arrayOfObject32, 3), "\001\001\001", "\003", new Object[0], 0);
    arrayOfSyntaxRule9[2] = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3), "\001\001\001", "\023", new Object[0], 0);
    arrayOfSyntaxRule9[3] = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2), "\001\001", "\003", new Object[0], 0);
    Lit33 = new SyntaxRules(arrayOfObject30, arrayOfSyntaxRule9, 4);
    Object[] arrayOfObject33 = new Object[1];
    SimpleSymbol localSimpleSymbol12 = (SimpleSymbol)new SimpleSymbol("let*").readResolve();
    Lit30 = localSimpleSymbol12;
    arrayOfObject33[0] = localSimpleSymbol12;
    SyntaxRule[] arrayOfSyntaxRule10 = new SyntaxRule[5];
    SyntaxPattern localSyntaxPattern17 = new SyntaxPattern("\f\030\f\b\003", new Object[0], 1);
    Object[] arrayOfObject34 = new Object[1];
    arrayOfObject34[0] = Lit70;
    arrayOfSyntaxRule10[0] = new SyntaxRule(localSyntaxPattern17, "", "\021\030\004\t\020\002", arrayOfObject34, 0);
    SyntaxPattern localSyntaxPattern18 = new SyntaxPattern("\f\030\034\f\007\b\013", new Object[0], 2);
    Object[] arrayOfObject35 = new Object[1];
    arrayOfObject35[0] = Lit70;
    arrayOfSyntaxRule10[1] = new SyntaxRule(localSyntaxPattern18, "", "\021\030\004\021\b\003\n", arrayOfObject35, 0);
    SyntaxPattern localSyntaxPattern19 = new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3);
    Object[] arrayOfObject36 = new Object[2];
    arrayOfObject36[0] = Lit70;
    arrayOfObject36[1] = Lit30;
    arrayOfSyntaxRule10[2] = new SyntaxRule(localSyntaxPattern19, "", "\021\030\004\021\b\003\b\021\030\f\t\n\022", arrayOfObject36, 0);
    SyntaxPattern localSyntaxPattern20 = new SyntaxPattern("\f\030\f\007\013", new Object[0], 2);
    Object[] arrayOfObject37 = new Object[1];
    arrayOfObject37[0] = PairWithPosition.make(Lit69, PairWithPosition.make("invalid bindings list in let*", LList.Empty, "std_syntax.scm", 679943), "std_syntax.scm", 675846);
    arrayOfSyntaxRule10[3] = new SyntaxRule(localSyntaxPattern20, "", "\030\004", arrayOfObject37, 0);
    SyntaxPattern localSyntaxPattern21 = new SyntaxPattern("\f\030\003", new Object[0], 1);
    Object[] arrayOfObject38 = new Object[1];
    arrayOfObject38[0] = PairWithPosition.make(Lit69, PairWithPosition.make("missing bindings list in let*", LList.Empty, "std_syntax.scm", 692231), "std_syntax.scm", 688134);
    arrayOfSyntaxRule10[4] = new SyntaxRule(localSyntaxPattern21, "", "\030\004", arrayOfObject38, 0);
    Lit31 = new SyntaxRules(arrayOfObject33, arrayOfSyntaxRule10, 3);
    Object[] arrayOfObject39 = new Object[1];
    SimpleSymbol localSimpleSymbol13 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    Lit28 = localSimpleSymbol13;
    arrayOfObject39[0] = localSimpleSymbol13;
    SyntaxRule[] arrayOfSyntaxRule11 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern22 = new SyntaxPattern("", new Object[0], 2);
    Object[] arrayOfObject40 = new Object[1];
    arrayOfObject40[0] = Lit70;
    arrayOfSyntaxRule11[0] = new SyntaxRule(localSyntaxPattern22, "", "\021\030\004\031\b\005\003\n", arrayOfObject40, 1);
    SyntaxPattern localSyntaxPattern23 = new SyntaxPattern("\f\030\f\007,\r\017\b\b\b\023", new Object[0], 3);
    Object[] arrayOfObject41 = new Object[3];
    arrayOfObject41[0] = Lit71;
    SimpleSymbol localSimpleSymbol14 = (SimpleSymbol)new SimpleSymbol("%let-lambda1").readResolve();
    Lit22 = localSimpleSymbol14;
    arrayOfObject41[1] = localSimpleSymbol14;
    SimpleSymbol localSimpleSymbol15 = (SimpleSymbol)new SimpleSymbol("%let-init").readResolve();
    Lit26 = localSimpleSymbol15;
    arrayOfObject41[2] = localSimpleSymbol15;
    arrayOfSyntaxRule11[1] = new SyntaxRule(localSyntaxPattern23, "", "©\021\030\004y\b\t\003\b\021\030\f\031\b\r\013\t\020\b\022\b\003\b\r\021\030\024\b\013", arrayOfObject41, 1);
    Lit29 = new SyntaxRules(arrayOfObject39, arrayOfSyntaxRule11, 3);
    Object[] arrayOfObject42 = new Object[2];
    arrayOfObject42[0] = Lit26;
    arrayOfObject42[1] = Lit64;
    SyntaxRule[] arrayOfSyntaxRule12 = new SyntaxRule[5];
    arrayOfSyntaxRule12[0] = new SyntaxRule(new SyntaxPattern("\f\030,\f\007\f\017\b\b", new Object[0], 2), "\001\001", "\013", new Object[0], 0);
    Object[] arrayOfObject43 = new Object[1];
    arrayOfObject43[0] = Lit64;
    arrayOfSyntaxRule12[1] = new SyntaxRule(new SyntaxPattern("\f\030L\f\007\f\002\f\017\f\027\b\b", arrayOfObject43, 3), "\001\001\001", "\023", new Object[0], 0);
    arrayOfSyntaxRule12[2] = new SyntaxRule(new SyntaxPattern("\f\030<\f\007\f\017\f\027\b\b", new Object[0], 3), "\001\001\001", "\023", new Object[0], 0);
    SyntaxPattern localSyntaxPattern24 = new SyntaxPattern("\f\030\034\f\007\b\b", new Object[0], 1);
    Object[] arrayOfObject44 = new Object[1];
    arrayOfObject44[0] = PairWithPosition.make(Lit69, PairWithPosition.make("let binding with no value", LList.Empty, "std_syntax.scm", 552979), "std_syntax.scm", 552964);
    arrayOfSyntaxRule12[3] = new SyntaxRule(localSyntaxPattern24, "\001", "\030\004", arrayOfObject44, 0);
    SyntaxPattern localSyntaxPattern25 = new SyntaxPattern("\f\030L\f\007\f\017\f\027\f\037\b\b", new Object[0], 4);
    Object[] arrayOfObject45 = new Object[1];
    arrayOfObject45[0] = PairWithPosition.make(Lit69, PairWithPosition.make("let binding must have syntax: (var [type] init)", LList.Empty, "std_syntax.scm", 565253), "std_syntax.scm", 561156);
    arrayOfSyntaxRule12[4] = new SyntaxRule(localSyntaxPattern25, "\001\001\001\001", "\030\004", arrayOfObject45, 0);
    Lit27 = new SyntaxRules(arrayOfObject42, arrayOfSyntaxRule12, 4);
    Object[] arrayOfObject46 = new Object[1];
    SimpleSymbol localSimpleSymbol16 = (SimpleSymbol)new SimpleSymbol("%let-lambda2").readResolve();
    Lit24 = localSimpleSymbol16;
    arrayOfObject46[0] = localSimpleSymbol16;
    SyntaxRule[] arrayOfSyntaxRule13 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern26 = new SyntaxPattern("\f\030\034\f\007\013\f\027\f\037\b", new Object[0], 4);
    Object[] arrayOfObject47 = new Object[1];
    arrayOfObject47[0] = Lit24;
    arrayOfSyntaxRule13[0] = new SyntaxRule(localSyntaxPattern26, "", "\021\030\004\t\n\031\t\003\023\b\033", arrayOfObject47, 0);
    SyntaxPattern localSyntaxPattern27 = new SyntaxPattern("\f\030\f\b\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject48 = new Object[1];
    arrayOfObject48[0] = Lit68;
    arrayOfSyntaxRule13[1] = new SyntaxRule(localSyntaxPattern27, "\001\001", "\021\030\004\t\003\013", arrayOfObject48, 0);
    Lit25 = new SyntaxRules(arrayOfObject46, arrayOfSyntaxRule13, 4);
    Object[] arrayOfObject49 = new Object[2];
    arrayOfObject49[0] = Lit22;
    arrayOfObject49[1] = Lit64;
    SyntaxRule[] arrayOfSyntaxRule14 = new SyntaxRule[4];
    SyntaxPattern localSyntaxPattern28 = new SyntaxPattern("\f\030L<\f\007\f\017\f\027\b\033\f'\f/\b", new Object[0], 6);
    Object[] arrayOfObject50 = new Object[1];
    arrayOfObject50[0] = Lit22;
    arrayOfSyntaxRule14[0] = new SyntaxRule(localSyntaxPattern28, "", "\021\030\004\t\0321!\t\003\b\013#\b+", arrayOfObject50, 0);
    Object[] arrayOfObject51 = new Object[1];
    arrayOfObject51[0] = Lit64;
    SyntaxPattern localSyntaxPattern29 = new SyntaxPattern("\f\030\\L\f\007\f\002\f\017\f\027\b\033\f'\f/\b", arrayOfObject51, 6);
    Object[] arrayOfObject52 = new Object[1];
    arrayOfObject52[0] = Lit22;
    arrayOfSyntaxRule14[1] = new SyntaxRule(localSyntaxPattern29, "", "\021\030\004\t\0321!\t\003\b\013#\b+", arrayOfObject52, 0);
    SyntaxPattern localSyntaxPattern30 = new SyntaxPattern("\f\030<,\f\007\f\017\b\023\f\037\f'\b", new Object[0], 5);
    Object[] arrayOfObject53 = new Object[1];
    arrayOfObject53[0] = Lit22;
    arrayOfSyntaxRule14[2] = new SyntaxRule(localSyntaxPattern30, "", "\021\030\004\t\022\031\t\003\033\b#", arrayOfObject53, 0);
    SyntaxPattern localSyntaxPattern31 = new SyntaxPattern("\f\030\f\b\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject54 = new Object[1];
    arrayOfObject54[0] = Lit24;
    arrayOfSyntaxRule14[3] = new SyntaxRule(localSyntaxPattern31, "\001\001", "\021\030\004\t\003\t\020\b\013", arrayOfObject54, 0);
    Lit23 = new SyntaxRules(arrayOfObject49, arrayOfSyntaxRule14, 6);
    Object[] arrayOfObject55 = new Object[3];
    arrayOfObject55[0] = Lit70;
    arrayOfObject55[1] = Lit73;
    arrayOfObject55[2] = Lit72;
    Lit21 = new SyntaxTemplate("\001\001\003", "\021\030\0041\b\021\030\f\b\013\b\021\030\024\021\030\f\021\030\f\b\t\003\b\025\023", arrayOfObject55, 1);
    Lit20 = new SyntaxPattern("\f\007\f\017\r\027\020\b\b", new Object[0], 3);
    Lit19 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    Lit18 = new SyntaxPattern("\f\007\f\017\b", new Object[0], 2);
    Lit17 = new SyntaxPattern("\f\007\b", new Object[0], 1);
    Lit16 = (SimpleSymbol)new SimpleSymbol("or").readResolve();
    Object[] arrayOfObject56 = new Object[4];
    arrayOfObject56[0] = Lit70;
    arrayOfObject56[1] = Lit73;
    arrayOfObject56[2] = Lit72;
    arrayOfObject56[3] = PairWithPosition.make(Lit73, LList.Empty, "std_syntax.scm", 385052);
    Lit15 = new SyntaxTemplate("\001\001\003", "\021\030\0041\b\021\030\f\b\013\b\021\030\024\021\030\f)\t\003\b\025\023\030\034", arrayOfObject56, 1);
    Lit14 = new SyntaxPattern("\f\007\f\017\r\027\020\b\b", new Object[0], 3);
    Lit13 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    Lit12 = new SyntaxPattern("\f\007\f\017\b", new Object[0], 2);
    Lit11 = new SyntaxPattern("\f\007\b", new Object[0], 1);
    Lit10 = (SimpleSymbol)new SimpleSymbol("and").readResolve();
    Object[] arrayOfObject57 = new Object[1];
    SimpleSymbol localSimpleSymbol17 = (SimpleSymbol)new SimpleSymbol("%case-match").readResolve();
    Lit8 = localSimpleSymbol17;
    arrayOfObject57[0] = localSimpleSymbol17;
    SyntaxRule[] arrayOfSyntaxRule15 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern32 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject58 = new Object[2];
    arrayOfObject58[0] = Lit74;
    arrayOfObject58[1] = Lit66;
    arrayOfSyntaxRule15[0] = new SyntaxRule(localSyntaxPattern32, "\001\001", "\021\030\004\t\003\b\021\030\f\b\013", arrayOfObject58, 0);
    SyntaxPattern localSyntaxPattern33 = new SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", new Object[0], 3);
    Object[] arrayOfObject59 = new Object[4];
    arrayOfObject59[0] = Lit16;
    arrayOfObject59[1] = Lit74;
    arrayOfObject59[2] = Lit66;
    arrayOfObject59[3] = Lit8;
    arrayOfSyntaxRule15[1] = new SyntaxRule(localSyntaxPattern33, "\001\001\003", "\021\030\004Y\021\030\f\t\003\b\021\030\024\b\013\b\021\030\034\t\003\b\025\023", arrayOfObject59, 1);
    Lit9 = new SyntaxRules(arrayOfObject57, arrayOfSyntaxRule15, 3);
    Object[] arrayOfObject60 = new Object[2];
    SimpleSymbol localSimpleSymbol18 = (SimpleSymbol)new SimpleSymbol("%case").readResolve();
    Lit6 = localSimpleSymbol18;
    arrayOfObject60[0] = localSimpleSymbol18;
    arrayOfObject60[1] = Lit75;
    SyntaxRule[] arrayOfSyntaxRule16 = new SyntaxRule[4];
    Object[] arrayOfObject61 = new Object[1];
    arrayOfObject61[0] = Lit75;
    SyntaxPattern localSyntaxPattern34 = new SyntaxPattern("\f\030\f\007<\f\002\r\017\b\b\b\b", arrayOfObject61, 2);
    Object[] arrayOfObject62 = new Object[1];
    arrayOfObject62[0] = Lit56;
    arrayOfSyntaxRule16[0] = new SyntaxRule(localSyntaxPattern34, "\001\003", "\021\030\004\b\r\013", arrayOfObject62, 1);
    Object[] arrayOfObject63 = new Object[1];
    arrayOfObject63[0] = Lit75;
    SyntaxPattern localSyntaxPattern35 = new SyntaxPattern("\f\030\f\007<\f\002\r\017\b\b\b\023", arrayOfObject63, 3);
    Object[] arrayOfObject64 = new Object[1];
    arrayOfObject64[0] = PairWithPosition.make(Lit69, PairWithPosition.make("junk following else (in case)", LList.Empty, "std_syntax.scm", 241674), "std_syntax.scm", 237577);
    arrayOfSyntaxRule16[1] = new SyntaxRule(localSyntaxPattern35, "", "\030\004", arrayOfObject64, 0);
    SyntaxPattern localSyntaxPattern36 = new SyntaxPattern("\f\030\f\007\\,\r\017\b\b\b\r\027\020\b\b\b", new Object[0], 3);
    Object[] arrayOfObject65 = new Object[3];
    arrayOfObject65[0] = Lit72;
    arrayOfObject65[1] = Lit8;
    arrayOfObject65[2] = Lit56;
    arrayOfSyntaxRule16[2] = new SyntaxRule(localSyntaxPattern36, "\001\003\003", "\021\030\004A\021\030\f\t\003\b\r\013\b\021\030\024\b\025\023", arrayOfObject65, 1);
    SyntaxPattern localSyntaxPattern37 = new SyntaxPattern("\f\030\f\007\\,\r\017\b\b\b\r\027\020\b\b\f\037\r' \b\b", new Object[0], 5);
    Object[] arrayOfObject66 = new Object[4];
    arrayOfObject66[0] = Lit72;
    arrayOfObject66[1] = Lit8;
    arrayOfObject66[2] = Lit56;
    arrayOfObject66[3] = Lit6;
    arrayOfSyntaxRule16[3] = new SyntaxRule(localSyntaxPattern37, "\001\003\003\001\003", "\021\030\004A\021\030\f\t\003\b\r\0131\021\030\024\b\025\023\b\021\030\034\t\003\t\033\b%#", arrayOfObject66, 1);
    Lit7 = new SyntaxRules(arrayOfObject60, arrayOfSyntaxRule16, 5);
    Object[] arrayOfObject67 = new Object[1];
    SimpleSymbol localSimpleSymbol19 = (SimpleSymbol)new SimpleSymbol("jdField_case").readResolve();
    Lit4 = localSimpleSymbol19;
    arrayOfObject67[0] = localSimpleSymbol19;
    SyntaxRule[] arrayOfSyntaxRule17 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern38 = new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2);
    Object[] arrayOfObject68 = new Object[3];
    arrayOfObject68[0] = Lit70;
    arrayOfObject68[1] = ((SimpleSymbol)new SimpleSymbol("tmp").readResolve());
    arrayOfObject68[2] = Lit6;
    arrayOfSyntaxRule17[0] = new SyntaxRule(localSyntaxPattern38, "\001\003", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\f\b\r\013", arrayOfObject68, 1);
    Lit5 = new SyntaxRules(arrayOfObject67, arrayOfSyntaxRule17, 2);
    Object[] arrayOfObject69 = new Object[3];
    SimpleSymbol localSimpleSymbol20 = (SimpleSymbol)new SimpleSymbol("cond").readResolve();
    Lit2 = localSimpleSymbol20;
    arrayOfObject69[0] = localSimpleSymbol20;
    arrayOfObject69[1] = Lit75;
    arrayOfObject69[2] = Lit76;
    SyntaxRule[] arrayOfSyntaxRule18 = new SyntaxRule[8];
    Object[] arrayOfObject70 = new Object[1];
    arrayOfObject70[0] = Lit75;
    SyntaxPattern localSyntaxPattern39 = new SyntaxPattern("\f\030L\f\002\f\007\r\017\b\b\b\b", arrayOfObject70, 2);
    Object[] arrayOfObject71 = new Object[1];
    arrayOfObject71[0] = Lit56;
    arrayOfSyntaxRule18[0] = new SyntaxRule(localSyntaxPattern39, "\001\003", "\021\030\004\t\003\b\r\013", arrayOfObject71, 1);
    Object[] arrayOfObject72 = new Object[1];
    arrayOfObject72[0] = Lit75;
    SyntaxPattern localSyntaxPattern40 = new SyntaxPattern("\f\030L\f\002\f\007\r\017\b\b\b\r\027\020\b\b", arrayOfObject72, 3);
    Object[] arrayOfObject73 = new Object[1];
    arrayOfObject73[0] = PairWithPosition.make(Lit69, PairWithPosition.make("else clause must be last clause of cond", LList.Empty, "std_syntax.scm", 86035), "std_syntax.scm", 86020);
    arrayOfSyntaxRule18[1] = new SyntaxRule(localSyntaxPattern40, "\001\003\003", "\030\004", arrayOfObject73, 0);
    Object[] arrayOfObject74 = new Object[1];
    arrayOfObject74[0] = Lit76;
    SyntaxPattern localSyntaxPattern41 = new SyntaxPattern("\f\030<\f\007\f\002\f\017\b\b", arrayOfObject74, 2);
    Object[] arrayOfObject75 = new Object[4];
    arrayOfObject75[0] = Lit70;
    arrayOfObject75[1] = Lit77;
    arrayOfObject75[2] = Lit72;
    arrayOfObject75[3] = PairWithPosition.make(Lit77, LList.Empty, "std_syntax.scm", 102423);
    arrayOfSyntaxRule18[2] = new SyntaxRule(localSyntaxPattern41, "\001\001", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\f\b\t\013\030\034", arrayOfObject75, 0);
    Object[] arrayOfObject76 = new Object[1];
    arrayOfObject76[0] = Lit76;
    SyntaxPattern localSyntaxPattern42 = new SyntaxPattern("\f\030<\f\007\f\002\f\017\b\f\027\r\037\030\b\b", arrayOfObject76, 4);
    Object[] arrayOfObject77 = new Object[5];
    arrayOfObject77[0] = Lit70;
    arrayOfObject77[1] = Lit77;
    arrayOfObject77[2] = Lit72;
    arrayOfObject77[3] = PairWithPosition.make(Lit77, LList.Empty, "std_syntax.scm", 122898);
    arrayOfObject77[4] = Lit2;
    arrayOfSyntaxRule18[3] = new SyntaxRule(localSyntaxPattern42, "\001\001\001\003", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\f!\t\013\030\034\b\021\030$\t\023\b\035\033", arrayOfObject77, 1);
    arrayOfSyntaxRule18[4] = new SyntaxRule(new SyntaxPattern("\f\030\034\f\007\b\b", new Object[0], 1), "\001", "\003", new Object[0], 0);
    SyntaxPattern localSyntaxPattern43 = new SyntaxPattern("\f\030\034\f\007\b\f\017\r\027\020\b\b", new Object[0], 3);
    Object[] arrayOfObject78 = new Object[2];
    arrayOfObject78[0] = Lit16;
    arrayOfObject78[1] = Lit2;
    arrayOfSyntaxRule18[5] = new SyntaxRule(localSyntaxPattern43, "\001\001\003", "\021\030\004\t\003\b\021\030\f\t\013\b\025\023", arrayOfObject78, 1);
    SyntaxPattern localSyntaxPattern44 = new SyntaxPattern("\f\030L\f\007\f\017\r\027\020\b\b\b", new Object[0], 3);
    Object[] arrayOfObject79 = new Object[2];
    arrayOfObject79[0] = Lit72;
    arrayOfObject79[1] = Lit56;
    arrayOfSyntaxRule18[6] = new SyntaxRule(localSyntaxPattern44, "\001\001\003", "\021\030\004\t\003\b\021\030\f\t\013\b\025\023", arrayOfObject79, 1);
    SyntaxPattern localSyntaxPattern45 = new SyntaxPattern("\f\030L\f\007\f\017\r\027\020\b\b\f\037\r' \b\b", new Object[0], 5);
    Object[] arrayOfObject80 = new Object[3];
    arrayOfObject80[0] = Lit72;
    arrayOfObject80[1] = Lit56;
    arrayOfObject80[2] = Lit2;
    arrayOfSyntaxRule18[7] = new SyntaxRule(localSyntaxPattern45, "\001\001\003\001\003", "\021\030\004\t\003A\021\030\f\t\013\b\025\023\b\021\030\024\t\033\b%#", arrayOfObject80, 1);
    Lit3 = new SyntaxRules(arrayOfObject69, arrayOfSyntaxRule18, 5);
    Lit1 = IntNum.make(1);
    Lit0 = IntNum.make(0);
    $instance = new std_syntax();
    $Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
    $Prvt$define$Mnconstant = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnconstant");
    $Prvt$if = StaticFieldLocation.make("kawa.lib.prim_syntax", "if");
    $Prvt$letrec = StaticFieldLocation.make("kawa.lib.prim_syntax", "letrec");
    cond = Macro.make(Lit2, Lit3, $instance);
    jdField_case = Macro.make(Lit4, Lit5, $instance);
    $Prvt$$Pccase = Macro.make(Lit6, Lit7, $instance);
    $Prvt$$Pccase$Mnmatch = Macro.make(Lit8, Lit9, $instance);
    SimpleSymbol localSimpleSymbol21 = Lit10;
    std_syntax localstd_syntax = $instance;
    and = Macro.make(localSimpleSymbol21, new ModuleMethod(localstd_syntax, 1, null, 4097), $instance);
    or = Macro.make(Lit16, new ModuleMethod(localstd_syntax, 2, null, 4097), $instance);
    $Prvt$$Pclet$Mnlambda1 = Macro.make(Lit22, Lit23, $instance);
    $Prvt$$Pclet$Mnlambda2 = Macro.make(Lit24, Lit25, $instance);
    $Prvt$$Pclet$Mninit = Macro.make(Lit26, Lit27, $instance);
    let = Macro.make(Lit28, Lit29, $instance);
    let$St = Macro.make(Lit30, Lit31, $instance);
    $Prvt$$Pcdo$Mnstep = Macro.make(Lit32, Lit33, $instance);
    $Prvt$$Pcdo$Mninit = Macro.make(Lit34, Lit35, $instance);
    $Prvt$$Pcdo$Mnlambda1 = Macro.make(Lit36, Lit37, $instance);
    $Prvt$$Pcdo$Mnlambda2 = Macro.make(Lit38, Lit39, $instance);
    jdField_do = Macro.make(Lit40, Lit41, $instance);
    delay = Macro.make(Lit42, Lit43, $instance);
    define$Mnprocedure = Macro.make(Lit44, Lit45, $instance);
    syntax$Mnobject$Mn$Grdatum = new ModuleMethod(localstd_syntax, 3, Lit46, 4097);
    datum$Mn$Grsyntax$Mnobject = new ModuleMethod(localstd_syntax, 4, Lit47, 8194);
    generate$Mntemporaries = new ModuleMethod(localstd_syntax, 5, Lit48, 4097);
    identifier$Qu = new ModuleMethod(localstd_syntax, 6, Lit49, 4097);
    free$Mnidentifier$Eq$Qu = new ModuleMethod(localstd_syntax, 7, Lit50, 8194);
    syntax$Mnsource = new ModuleMethod(localstd_syntax, 8, Lit51, 4097);
    syntax$Mnline = new ModuleMethod(localstd_syntax, 9, Lit52, 4097);
    syntax$Mncolumn = new ModuleMethod(localstd_syntax, 10, Lit53, 4097);
    SimpleSymbol localSimpleSymbol22 = Lit54;
    ModuleMethod localModuleMethod = new ModuleMethod(localstd_syntax, 11, null, 4097);
    localModuleMethod.setProperty("source-location", "std_syntax.scm:298");
    begin$Mnfor$Mnsyntax = Macro.make(localSimpleSymbol22, localModuleMethod, $instance);
    define$Mnfor$Mnsyntax = Macro.make(Lit59, Lit60, $instance);
    with$Mnsyntax = Macro.make(Lit61, Lit62, $instance);
    $instance.run();
  }

  public std_syntax()
  {
    ModuleInfo.register(this);
  }

  public static Object datum$To$SyntaxObject(Object paramObject1, Object paramObject2)
  {
    return SyntaxForms.makeWithTemplate(paramObject1, paramObject2);
  }

  public static Object generateTemporaries(Object paramObject)
  {
    Object localObject1 = Integer.valueOf(Translator.listLength(paramObject));
    for (Object localObject2 = LList.Empty; ; localObject2 = new Pair(datum$To$SyntaxObject(paramObject, Symbols.gentemp()), localObject2))
    {
      if (Scheme.numEqu.apply2(localObject1, Lit0) != Boolean.FALSE)
        return localObject2;
      localObject1 = AddOp.$Mn.apply2(localObject1, Lit1);
    }
  }

  // ERROR //
  public static boolean isFreeIdentifier$Eq(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 859	kawa/lang/SyntaxForm
    //   4: astore_3
    //   5: aload_1
    //   6: checkcast 859	kawa/lang/SyntaxForm
    //   9: astore 5
    //   11: aload_3
    //   12: aload 5
    //   14: invokestatic 863	kawa/lang/SyntaxForms:freeIdentifierEquals	(Lkawa/lang/SyntaxForm;Lkawa/lang/SyntaxForm;)Z
    //   17: ireturn
    //   18: astore_2
    //   19: new 865	gnu/mapping/WrongType
    //   22: dup
    //   23: aload_2
    //   24: ldc_w 867
    //   27: iconst_1
    //   28: aload_0
    //   29: invokespecial 870	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   32: athrow
    //   33: astore 4
    //   35: new 865	gnu/mapping/WrongType
    //   38: dup
    //   39: aload 4
    //   41: ldc_w 867
    //   44: iconst_2
    //   45: aload_1
    //   46: invokespecial 870	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   49: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	18	java/lang/ClassCastException
    //   5	11	33	java/lang/ClassCastException
  }

  public static boolean isIdentifier(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Symbol;
    if (bool1)
      return bool1;
    boolean bool2 = paramObject instanceof SyntaxForm;
    if (bool2);
    try
    {
      SyntaxForm localSyntaxForm = (SyntaxForm)paramObject;
      return SyntaxForms.isIdentifier(localSyntaxForm);
      return bool2;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "kawa.lang.SyntaxForms.isIdentifier(kawa.lang.SyntaxForm)", 1, paramObject);
    }
  }

  static Object lambda1(Object paramObject)
  {
    Object[] arrayOfObject = SyntaxPattern.allocVars(3, null);
    if (Lit11.match(paramObject, arrayOfObject, 0))
      return new QuoteExp(Language.getDefaultLanguage().booleanObject(true));
    if (Lit12.match(paramObject, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit13.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit14.match(paramObject, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit15.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  static Object lambda2(Object paramObject)
  {
    Object[] arrayOfObject = SyntaxPattern.allocVars(3, null);
    if (Lit17.match(paramObject, arrayOfObject, 0))
      return new QuoteExp(Language.getDefaultLanguage().booleanObject(false));
    if (Lit18.match(paramObject, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit19.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit20.match(paramObject, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit21.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  static Object lambda3(Object paramObject)
  {
    Object[] arrayOfObject = SyntaxPattern.allocVars(2, null);
    if (Lit55.match(paramObject, arrayOfObject, 0))
    {
      Eval localEval = Eval.eval;
      SimpleSymbol localSimpleSymbol = Lit56;
      TemplateScope localTemplateScope1 = TemplateScope.make();
      if (localEval.apply1(syntaxObject$To$Datum(new Pair(localSimpleSymbol, Lit57.execute(arrayOfObject, localTemplateScope1)))) != Boolean.FALSE)
      {
        TemplateScope localTemplateScope2 = TemplateScope.make();
        return Lit58.execute(arrayOfObject, localTemplateScope2);
      }
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  public static Object syntaxColumn(Object paramObject)
  {
    if ((paramObject instanceof SyntaxForm))
      return syntaxLine(((SyntaxForm)paramObject).getDatum());
    if ((paramObject instanceof PairWithPosition))
      return Integer.valueOf(((PairWithPosition)paramObject).getColumnNumber() - 0);
    return Boolean.FALSE;
  }

  public static Object syntaxLine(Object paramObject)
  {
    if ((paramObject instanceof SyntaxForm))
      return syntaxLine(((SyntaxForm)paramObject).getDatum());
    if ((paramObject instanceof PairWithPosition))
      return Integer.valueOf(((PairWithPosition)paramObject).getLineNumber());
    return Boolean.FALSE;
  }

  public static Object syntaxObject$To$Datum(Object paramObject)
  {
    return Quote.quote(paramObject);
  }

  public static Object syntaxSource(Object paramObject)
  {
    if ((paramObject instanceof SyntaxForm))
      return syntaxSource(((SyntaxForm)paramObject).getDatum());
    if ((paramObject instanceof PairWithPosition))
    {
      String str = ((PairWithPosition)paramObject).getFileName();
      if (str == null)
        return Boolean.FALSE;
      return str;
    }
    return Boolean.FALSE;
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 4:
    case 7:
    default:
      return super.apply1(paramModuleMethod, paramObject);
    case 3:
      return syntaxObject$To$Datum(paramObject);
    case 5:
      return generateTemporaries(paramObject);
    case 6:
      if (isIdentifier(paramObject))
        return Boolean.TRUE;
      return Boolean.FALSE;
    case 8:
      return syntaxSource(paramObject);
    case 9:
      return syntaxLine(paramObject);
    case 10:
      return syntaxColumn(paramObject);
    case 1:
      return lambda1(paramObject);
    case 2:
      return lambda2(paramObject);
    case 11:
    }
    return lambda3(paramObject);
  }

  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    case 5:
    case 6:
    default:
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 4:
      return datum$To$SyntaxObject(paramObject1, paramObject2);
    case 7:
    }
    if (isFreeIdentifier$Eq(paramObject1, paramObject2))
      return Boolean.TRUE;
    return Boolean.FALSE;
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4:
    case 7:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 11:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 1:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 8:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 6:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3:
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
    case 5:
    case 6:
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 7:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 4:
    }
    paramCallContext.value1 = paramObject1;
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
 * Qualified Name:     kawa.lib.std_syntax
 * JD-Core Version:    0.6.2
 */