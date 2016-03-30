package kawa.lib;

import gnu.expr.Expression;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SynchronizedExp;
import gnu.expr.TryExp;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
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
import kawa.lang.Translator;
import kawa.standard.IfFeature;
import kawa.standard.Scheme;
import kawa.standard.syntax_case;

public class syntax extends ModuleBody
{
  public static final Macro $Pccond$Mnexpand;
  public static final Macro $Pcimport;
  public static final Location $Prvt$and;
  public static final Location $Prvt$define$Mnconstant;
  public static final Location $Prvt$define$Mnsyntax;
  public static final Location $Prvt$if;
  public static final Location $Prvt$let;
  public static final Location $Prvt$or;
  public static final Location $Prvt$try$Mncatch;
  public static final syntax $instance;
  static final SyntaxPattern Lit0;
  static final SyntaxTemplate Lit1;
  static final SyntaxPattern Lit10;
  static final SimpleSymbol Lit100;
  static final SyntaxRules Lit101;
  static final SimpleSymbol Lit102;
  static final SimpleSymbol Lit103;
  static final SimpleSymbol Lit104;
  static final SimpleSymbol Lit105;
  static final SimpleSymbol Lit106;
  static final SimpleSymbol Lit107;
  static final SimpleSymbol Lit108;
  static final SimpleSymbol Lit109;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit110;
  static final SimpleSymbol Lit111;
  static final SimpleSymbol Lit112;
  static final SimpleSymbol Lit113;
  static final SimpleSymbol Lit114;
  static final SimpleSymbol Lit115;
  static final SimpleSymbol Lit116;
  static final SimpleSymbol Lit117;
  static final SimpleSymbol Lit118;
  static final SimpleSymbol Lit119;
  static final SyntaxRules Lit12;
  static final SimpleSymbol Lit120;
  static final SimpleSymbol Lit121;
  static final SimpleSymbol Lit122;
  static final SimpleSymbol Lit123 = (SimpleSymbol)new SimpleSymbol("%define-macro").readResolve();
  static final SimpleSymbol Lit13;
  static final SyntaxRules Lit14;
  static final SimpleSymbol Lit15;
  static final SyntaxRules Lit16;
  static final SimpleSymbol Lit17;
  static final SyntaxRules Lit18;
  static final SimpleSymbol Lit19;
  static final SyntaxTemplate Lit2;
  static final SyntaxRules Lit20;
  static final SimpleSymbol Lit21;
  static final SyntaxPattern Lit22;
  static final SyntaxTemplate Lit23;
  static final SyntaxTemplate Lit24;
  static final SimpleSymbol Lit25;
  static final SyntaxPattern Lit26;
  static final SyntaxTemplate Lit27;
  static final SyntaxTemplate Lit28;
  static final SimpleSymbol Lit29;
  static final SyntaxPattern Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final SimpleSymbol Lit33;
  static final SimpleSymbol Lit34;
  static final SimpleSymbol Lit35;
  static final SimpleSymbol Lit36;
  static final SyntaxRules Lit37;
  static final SimpleSymbol Lit38;
  static final SyntaxPattern Lit39;
  static final SyntaxPattern Lit4;
  static final SyntaxTemplate Lit40;
  static final SyntaxTemplate Lit41;
  static final SyntaxTemplate Lit42;
  static final SyntaxTemplate Lit43;
  static final SyntaxTemplate Lit44;
  static final SyntaxTemplate Lit45;
  static final SyntaxPattern Lit46;
  static final SyntaxTemplate Lit47;
  static final SyntaxTemplate Lit48;
  static final SyntaxTemplate Lit49;
  static final SyntaxPattern Lit5;
  static final SyntaxTemplate Lit50;
  static final SyntaxTemplate Lit51;
  static final SyntaxTemplate Lit52;
  static final SyntaxPattern Lit53;
  static final SyntaxTemplate Lit54;
  static final SyntaxTemplate Lit55;
  static final SyntaxTemplate Lit56;
  static final SyntaxTemplate Lit57;
  static final SyntaxTemplate Lit58;
  static final SyntaxTemplate Lit59;
  static final SyntaxTemplate Lit6;
  static final SyntaxPattern Lit60;
  static final SyntaxTemplate Lit61;
  static final SyntaxTemplate Lit62;
  static final SyntaxTemplate Lit63;
  static final SyntaxTemplate Lit64;
  static final SyntaxPattern Lit65;
  static final SyntaxTemplate Lit66;
  static final SyntaxPattern Lit67;
  static final SyntaxTemplate Lit68;
  static final SyntaxTemplate Lit69;
  static final SyntaxTemplate Lit7;
  static final SyntaxTemplate Lit70;
  static final SyntaxTemplate Lit71;
  static final SyntaxPattern Lit72;
  static final SyntaxTemplate Lit73;
  static final SyntaxTemplate Lit74;
  static final SyntaxTemplate Lit75;
  static final SyntaxTemplate Lit76;
  static final SimpleSymbol Lit77;
  static final SyntaxRules Lit78;
  static final SimpleSymbol Lit79;
  static final SyntaxTemplate Lit8;
  static final SyntaxRules Lit80;
  static final SimpleSymbol Lit81;
  static final SyntaxPattern Lit82;
  static final SyntaxTemplate Lit83;
  static final SyntaxTemplate Lit84;
  static final SyntaxPattern Lit85;
  static final SyntaxTemplate Lit86;
  static final SyntaxTemplate Lit87;
  static final SyntaxPattern Lit88;
  static final SyntaxPattern Lit89;
  static final SyntaxPattern Lit9;
  static final SyntaxTemplate Lit90;
  static final SimpleSymbol Lit91;
  static final SyntaxRules Lit92;
  static final SimpleSymbol Lit93;
  static final SyntaxPattern Lit94;
  static final SyntaxTemplate Lit95;
  static final SyntaxTemplate Lit96;
  static final SyntaxTemplate Lit97;
  static final SimpleSymbol Lit98;
  static final SyntaxRules Lit99;
  public static final Macro case$Mnlambda;
  public static final Macro cond$Mnexpand;
  public static final Macro define$Mnalias$Mnparameter;
  public static final Macro define$Mnmacro;
  public static final Macro define$Mnsyntax$Mncase;
  public static final Macro defmacro;
  public static final ModuleMethod identifier$Mnlist$Qu;
  public static final ModuleMethod identifier$Mnpair$Mnlist$Qu;
  public static final Macro jdField_import;
  public static final ModuleMethod import$Mnhandle$Mnexcept;
  public static final ModuleMethod import$Mnhandle$Mnonly;
  public static final ModuleMethod import$Mnhandle$Mnprefix;
  public static final ModuleMethod import$Mnhandle$Mnrename;
  public static final ModuleMethod import$Mnmapper;
  public static final Macro let$Mnvalues;
  public static final Macro let$St$Mnvalues;
  public static final Macro receive;
  public static final Macro jdField_synchronized;
  public static final Macro try$Mnfinally;
  public static final Macro unless;
  public static final Macro when;

  static
  {
    Lit122 = (SimpleSymbol)new SimpleSymbol("form").readResolve();
    Lit121 = (SimpleSymbol)new SimpleSymbol("if").readResolve();
    Lit120 = (SimpleSymbol)new SimpleSymbol("prefix").readResolve();
    Lit119 = (SimpleSymbol)new SimpleSymbol("instance").readResolve();
    Lit118 = (SimpleSymbol)new SimpleSymbol("kawa.standard.ImportFromLibrary").readResolve();
    Lit117 = (SimpleSymbol)new SimpleSymbol("x").readResolve();
    Lit116 = (SimpleSymbol)new SimpleSymbol("call-with-values").readResolve();
    Lit115 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    Lit114 = (SimpleSymbol)new SimpleSymbol("not").readResolve();
    Lit113 = (SimpleSymbol)new SimpleSymbol("or").readResolve();
    Lit112 = (SimpleSymbol)new SimpleSymbol("and").readResolve();
    Lit111 = (SimpleSymbol)new SimpleSymbol("else").readResolve();
    Lit110 = (SimpleSymbol)new SimpleSymbol("begin").readResolve();
    Lit109 = (SimpleSymbol)new SimpleSymbol("lambda").readResolve();
    Lit108 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit107 = (SimpleSymbol)new SimpleSymbol("wt").readResolve();
    Lit106 = (SimpleSymbol)new SimpleSymbol("as").readResolve();
    Lit105 = (SimpleSymbol)new SimpleSymbol("arg").readResolve();
    Lit104 = (SimpleSymbol)new SimpleSymbol("quasiquote").readResolve();
    Lit103 = (SimpleSymbol)new SimpleSymbol("gnu.mapping.LocationProc").readResolve();
    Lit102 = (SimpleSymbol)new SimpleSymbol("$lookup$").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("define-alias-parameter").readResolve();
    Lit100 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject2 = new Object[21];
    arrayOfObject2[0] = Lit110;
    arrayOfObject2[1] = ((SimpleSymbol)new SimpleSymbol("define-constant").readResolve());
    arrayOfObject2[2] = ((SimpleSymbol)new SimpleSymbol("::").readResolve());
    arrayOfObject2[3] = ((SimpleSymbol)new SimpleSymbol("<gnu.mapping.LocationProc>").readResolve());
    SimpleSymbol localSimpleSymbol2 = Lit102;
    SimpleSymbol localSimpleSymbol3 = Lit103;
    SimpleSymbol localSimpleSymbol4 = Lit104;
    SimpleSymbol localSimpleSymbol5 = new SimpleSymbol("makeNamed");
    arrayOfObject2[4] = PairWithPosition.make(localSimpleSymbol2, Pair.make(localSimpleSymbol3, Pair.make(Pair.make(localSimpleSymbol4, Pair.make((SimpleSymbol)localSimpleSymbol5.readResolve(), LList.Empty)), LList.Empty)), "syntax.scm", 1069060);
    arrayOfObject2[5] = Lit108;
    SimpleSymbol localSimpleSymbol6 = Lit102;
    SimpleSymbol localSimpleSymbol7 = Lit103;
    SimpleSymbol localSimpleSymbol8 = Lit104;
    SimpleSymbol localSimpleSymbol9 = new SimpleSymbol("pushConverter");
    arrayOfObject2[6] = PairWithPosition.make(localSimpleSymbol6, Pair.make(localSimpleSymbol7, Pair.make(Pair.make(localSimpleSymbol8, Pair.make((SimpleSymbol)localSimpleSymbol9.readResolve(), LList.Empty)), LList.Empty)), "syntax.scm", 1073161);
    arrayOfObject2[7] = Lit109;
    arrayOfObject2[8] = PairWithPosition.make(Lit105, LList.Empty, "syntax.scm", 1081354);
    arrayOfObject2[9] = ((SimpleSymbol)new SimpleSymbol("try-catch").readResolve());
    arrayOfObject2[10] = Lit106;
    arrayOfObject2[11] = PairWithPosition.make(Lit105, LList.Empty, "syntax.scm", 1089550);
    arrayOfObject2[12] = ((SimpleSymbol)new SimpleSymbol("ex").readResolve());
    arrayOfObject2[13] = ((SimpleSymbol)new SimpleSymbol("<java.lang.ClassCastException>").readResolve());
    arrayOfObject2[14] = Lit115;
    arrayOfObject2[15] = Lit107;
    SimpleSymbol localSimpleSymbol10 = Lit102;
    SimpleSymbol localSimpleSymbol11 = (SimpleSymbol)new SimpleSymbol("gnu.mapping.WrongType").readResolve();
    SimpleSymbol localSimpleSymbol12 = Lit104;
    SimpleSymbol localSimpleSymbol13 = new SimpleSymbol("make");
    arrayOfObject2[16] = PairWithPosition.make(localSimpleSymbol10, Pair.make(localSimpleSymbol11, Pair.make(Pair.make(localSimpleSymbol12, Pair.make((SimpleSymbol)localSimpleSymbol13.readResolve(), LList.Empty)), LList.Empty)), "syntax.scm", 1097748);
    SimpleSymbol localSimpleSymbol14 = Lit106;
    SimpleSymbol localSimpleSymbol15 = new SimpleSymbol("<int>");
    arrayOfObject2[17] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol14, PairWithPosition.make((SimpleSymbol)localSimpleSymbol15.readResolve(), PairWithPosition.make(IntNum.make(1), LList.Empty, "syntax.scm", 1101846), "syntax.scm", 1101840), "syntax.scm", 1101836), PairWithPosition.make(Lit105, LList.Empty, "syntax.scm", 1101849), "syntax.scm", 1101836);
    arrayOfObject2[18] = ((SimpleSymbol)new SimpleSymbol("set!").readResolve());
    SimpleSymbol localSimpleSymbol16 = (SimpleSymbol)new SimpleSymbol("field").readResolve();
    SimpleSymbol localSimpleSymbol17 = Lit107;
    SimpleSymbol localSimpleSymbol18 = Lit108;
    SimpleSymbol localSimpleSymbol19 = new SimpleSymbol("expectedType");
    arrayOfObject2[19] = PairWithPosition.make(localSimpleSymbol16, PairWithPosition.make(localSimpleSymbol17, PairWithPosition.make(PairWithPosition.make(localSimpleSymbol18, PairWithPosition.make((SimpleSymbol)localSimpleSymbol19.readResolve(), LList.Empty, "syntax.scm", 1105941), "syntax.scm", 1105941), LList.Empty, "syntax.scm", 1105940), "syntax.scm", 1105937), "syntax.scm", 1105930);
    arrayOfObject2[20] = PairWithPosition.make(PairWithPosition.make((SimpleSymbol)new SimpleSymbol("primitive-throw").readResolve(), PairWithPosition.make(Lit107, LList.Empty, "syntax.scm", 1110037), "syntax.scm", 1110020), LList.Empty, "syntax.scm", 1110020);
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001\001\001", "\021\030\004¹\021\030\f\t\003\021\030\024\021\030\034\b\021\030$)\021\030,\b\003\b\023\b\021\0304\t\003\b\021\030<\021\030D\b\021\030L9\021\030T\t\013\030\\\b\021\030d\021\030l\b\021\030ty\b\021\030|\b\021\030\021\030d\t\003\030A\021\030\021\030\b\013\030¤", arrayOfObject2, 0);
    Lit101 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 3);
    Object[] arrayOfObject3 = new Object[1];
    SimpleSymbol localSimpleSymbol20 = (SimpleSymbol)new SimpleSymbol("receive").readResolve();
    Lit98 = localSimpleSymbol20;
    arrayOfObject3[0] = localSimpleSymbol20;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", new Object[0], 3);
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = Lit116;
    arrayOfObject4[1] = Lit109;
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\001\001\003", "\021\030\0049\021\030\f\t\020\b\013\b\021\030\f\t\003\b\025\023", arrayOfObject4, 1);
    Lit99 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 3);
    Object[] arrayOfObject5 = new Object[1];
    SimpleSymbol localSimpleSymbol21 = (SimpleSymbol)new SimpleSymbol("cond-expand").readResolve();
    Lit91 = localSimpleSymbol21;
    arrayOfObject5[0] = localSimpleSymbol21;
    Lit97 = new SyntaxTemplate("", "\021\030\004\032", arrayOfObject5, 0);
    Object[] arrayOfObject6 = new Object[1];
    arrayOfObject6[0] = Lit110;
    Lit96 = new SyntaxTemplate("", "\021\030\004\022", arrayOfObject6, 0);
    Lit95 = new SyntaxTemplate("", "\013", new Object[0], 0);
    Lit94 = new SyntaxPattern("\f\007\034\f\017\023\033", new Object[0], 4);
    Lit93 = (SimpleSymbol)new SimpleSymbol("%cond-expand").readResolve();
    Object[] arrayOfObject7 = new Object[5];
    arrayOfObject7[0] = Lit91;
    arrayOfObject7[1] = Lit112;
    arrayOfObject7[2] = Lit113;
    arrayOfObject7[3] = Lit114;
    arrayOfObject7[4] = Lit111;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[8];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\b", new Object[0], 0);
    Object[] arrayOfObject8 = new Object[1];
    arrayOfObject8[0] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("%syntax-error").readResolve(), PairWithPosition.make("Unfulfilled cond-expand", LList.Empty, "syntax.scm", 802851), "syntax.scm", 802836);
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "", "\030\004", arrayOfObject8, 0);
    Object[] arrayOfObject9 = new Object[1];
    arrayOfObject9[0] = Lit111;
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("", arrayOfObject9, 1);
    Object[] arrayOfObject10 = new Object[1];
    arrayOfObject10[0] = Lit110;
    arrayOfSyntaxRule3[1] = new SyntaxRule(localSyntaxPattern4, "\003", "\021\030\004\b\005\003", arrayOfObject10, 1);
    Object[] arrayOfObject11 = new Object[1];
    arrayOfObject11[0] = Lit112;
    SyntaxPattern localSyntaxPattern5 = new SyntaxPattern("", arrayOfObject11, 2);
    Object[] arrayOfObject12 = new Object[1];
    arrayOfObject12[0] = Lit110;
    arrayOfSyntaxRule3[2] = new SyntaxRule(localSyntaxPattern5, "\003\003", "\021\030\004\b\005\003", arrayOfObject12, 1);
    Object[] arrayOfObject13 = new Object[1];
    arrayOfObject13[0] = Lit112;
    SyntaxPattern localSyntaxPattern6 = new SyntaxPattern("\f\030|L\f\002\f\007\r\017\b\b\b\r\027\020\b\b\r\037\030\b\b", arrayOfObject13, 4);
    Object[] arrayOfObject14 = new Object[2];
    arrayOfObject14[0] = Lit91;
    arrayOfObject14[1] = Lit112;
    arrayOfSyntaxRule3[3] = new SyntaxRule(localSyntaxPattern6, "\001\003\003\003", "\021\030\004¡\t\003\b\021\030\004Q1\021\030\f\b\r\013\b\025\023\b\035\033\b\035\033", arrayOfObject14, 1);
    Object[] arrayOfObject15 = new Object[1];
    arrayOfObject15[0] = Lit113;
    SyntaxPattern localSyntaxPattern7 = new SyntaxPattern("", arrayOfObject15, 2);
    Object[] arrayOfObject16 = new Object[1];
    arrayOfObject16[0] = Lit91;
    arrayOfSyntaxRule3[4] = new SyntaxRule(localSyntaxPattern7, "\003\003", "\021\030\004\b\r\013", arrayOfObject16, 1);
    Object[] arrayOfObject17 = new Object[1];
    arrayOfObject17[0] = Lit113;
    SyntaxPattern localSyntaxPattern8 = new SyntaxPattern("\f\030|L\f\002\f\007\r\017\b\b\b\r\027\020\b\b\r\037\030\b\b", arrayOfObject17, 4);
    Object[] arrayOfObject18 = new Object[4];
    arrayOfObject18[0] = Lit91;
    arrayOfObject18[1] = Lit110;
    arrayOfObject18[2] = Lit111;
    arrayOfObject18[3] = Lit113;
    arrayOfSyntaxRule3[5] = new SyntaxRule(localSyntaxPattern8, "\001\003\003\003", "\021\030\004I\t\003\b\021\030\f\b\025\023\b\021\030\024\b\021\030\004Q1\021\030\034\b\r\013\b\025\023\b\035\033", arrayOfObject18, 1);
    Object[] arrayOfObject19 = new Object[1];
    arrayOfObject19[0] = Lit114;
    SyntaxPattern localSyntaxPattern9 = new SyntaxPattern("\f\030\\,\f\002\f\007\b\r\017\b\b\b\r\027\020\b\b", arrayOfObject19, 3);
    Object[] arrayOfObject20 = new Object[2];
    arrayOfObject20[0] = Lit91;
    arrayOfObject20[1] = Lit111;
    arrayOfSyntaxRule3[6] = new SyntaxRule(localSyntaxPattern9, "\001\003\003", "\021\030\004I\t\003\b\021\030\004\b\025\023\b\021\030\f\b\r\013", arrayOfObject20, 1);
    SyntaxPattern localSyntaxPattern10 = new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3);
    Object[] arrayOfObject21 = new Object[1];
    arrayOfObject21[0] = Lit93;
    arrayOfSyntaxRule3[7] = new SyntaxRule(localSyntaxPattern10, "", "\021\030\004\031\t\003\n\022", arrayOfObject21, 0);
    Lit92 = new SyntaxRules(arrayOfObject7, arrayOfSyntaxRule3, 4);
    Lit90 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Lit89 = new SyntaxPattern("\023", new Object[0], 3);
    Lit88 = new SyntaxPattern("\b", new Object[0], 2);
    Lit87 = new SyntaxTemplate("", "\"", new Object[0], 0);
    Object[] arrayOfObject22 = new Object[1];
    arrayOfObject22[0] = Lit109;
    Lit86 = new SyntaxTemplate("", "\021\030\004\t\023\032", arrayOfObject22, 0);
    Lit85 = new SyntaxPattern("\034\f\027\033#", new Object[0], 5);
    Lit84 = new SyntaxTemplate("", "\n", new Object[0], 0);
    Object[] arrayOfObject23 = new Object[1];
    arrayOfObject23[0] = PairWithPosition.make(Lit102, Pair.make((SimpleSymbol)new SimpleSymbol("gnu.expr.GenericProc").readResolve(), Pair.make(Pair.make(Lit104, Pair.make((SimpleSymbol)new SimpleSymbol("makeWithoutSorting").readResolve(), LList.Empty)), LList.Empty)), "syntax.scm", 651273);
    Lit83 = new SyntaxTemplate("", "\030\004", arrayOfObject23, 0);
    Lit82 = new SyntaxPattern("\f\007\013", new Object[0], 2);
    Lit81 = (SimpleSymbol)new SimpleSymbol("case-lambda").readResolve();
    Object[] arrayOfObject24 = new Object[1];
    SimpleSymbol localSimpleSymbol22 = (SimpleSymbol)new SimpleSymbol("let*-values").readResolve();
    Lit79 = localSimpleSymbol22;
    arrayOfObject24[0] = localSimpleSymbol22;
    SyntaxRule[] arrayOfSyntaxRule4 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern11 = new SyntaxPattern("\f\030\f\b\f\007\r\017\b\b\b", new Object[0], 2);
    Object[] arrayOfObject25 = new Object[1];
    arrayOfObject25[0] = Lit110;
    arrayOfSyntaxRule4[0] = new SyntaxRule(localSyntaxPattern11, "\001\003", "\021\030\004\t\003\b\r\013", arrayOfObject25, 1);
    SyntaxPattern localSyntaxPattern12 = new SyntaxPattern("\f\030<\f\007\r\017\b\b\b\f\027\r\037\030\b\b", new Object[0], 4);
    Object[] arrayOfObject26 = new Object[2];
    SimpleSymbol localSimpleSymbol23 = (SimpleSymbol)new SimpleSymbol("let-values").readResolve();
    Lit77 = localSimpleSymbol23;
    arrayOfObject26[0] = localSimpleSymbol23;
    arrayOfObject26[1] = Lit79;
    arrayOfSyntaxRule4[1] = new SyntaxRule(localSyntaxPattern12, "\001\003\001\003", "\021\030\004\021\b\003\b\021\030\f\031\b\r\013\t\023\b\035\033", arrayOfObject26, 1);
    Lit80 = new SyntaxRules(arrayOfObject24, arrayOfSyntaxRule4, 4);
    Object[] arrayOfObject27 = new Object[1];
    arrayOfObject27[0] = Lit77;
    SyntaxRule[] arrayOfSyntaxRule5 = new SyntaxRule[6];
    SyntaxPattern localSyntaxPattern13 = new SyntaxPattern("", new Object[0], 3);
    Object[] arrayOfObject28 = new Object[3];
    arrayOfObject28[0] = Lit77;
    arrayOfObject28[1] = "bind";
    arrayOfObject28[2] = Lit110;
    arrayOfSyntaxRule5[0] = new SyntaxRule(localSyntaxPattern13, "\003\001\003", "\021\030\004\021\030\f\031\b\005\003\t\020\b\021\030\024\t\013\b\025\023", arrayOfObject28, 1);
    SyntaxPattern localSyntaxPattern14 = new SyntaxPattern("\f\030\f\002\f\b\f\007\f\017\b", new Object[] { "bind" }, 2);
    Object[] arrayOfObject29 = new Object[1];
    arrayOfObject29[0] = Lit115;
    arrayOfSyntaxRule5[1] = new SyntaxRule(localSyntaxPattern14, "\001\001", "\021\030\004\t\003\b\013", arrayOfObject29, 0);
    SyntaxPattern localSyntaxPattern15 = new SyntaxPattern("\f\030\f\002\\,\f\007\f\017\b\r\027\020\b\b\f\037\f'\b", new Object[] { "bind" }, 5);
    Object[] arrayOfObject30 = new Object[2];
    arrayOfObject30[0] = Lit77;
    arrayOfObject30[1] = "mktmp";
    arrayOfSyntaxRule5[2] = new SyntaxRule(localSyntaxPattern15, "\001\001\003\001\001", "\021\030\004\021\030\f\t\003\t\013\t\020\031\b\025\023\t\033\b#", arrayOfObject30, 1);
    SyntaxPattern localSyntaxPattern16 = new SyntaxPattern("\f\030\f\002\f\b\f\007\f\017\f\027\f\037\f'\b", new Object[] { "mktmp" }, 5);
    Object[] arrayOfObject31 = new Object[4];
    arrayOfObject31[0] = Lit116;
    arrayOfObject31[1] = Lit109;
    arrayOfObject31[2] = Lit77;
    arrayOfObject31[3] = "bind";
    arrayOfSyntaxRule5[3] = new SyntaxRule(localSyntaxPattern16, "\001\001\001\001\001", "\021\030\0049\021\030\f\t\020\b\003\b\021\030\f\t\013\b\021\030\024\021\030\034\t\023\t\033\b#", arrayOfObject31, 0);
    SyntaxPattern localSyntaxPattern17 = new SyntaxPattern("\f\030\f\002\034\f\007\013\f\027,\r\037\030\b\b\f',\r/(\b\b\f7\b", new Object[] { "mktmp" }, 7);
    Object[] arrayOfObject32 = new Object[4];
    arrayOfObject32[0] = Lit77;
    arrayOfObject32[1] = "mktmp";
    arrayOfObject32[2] = PairWithPosition.make(Lit117, LList.Empty, "syntax.scm", 569387);
    arrayOfObject32[3] = PairWithPosition.make(Lit117, LList.Empty, "syntax.scm", 569414);
    arrayOfSyntaxRule5[4] = new SyntaxRule(localSyntaxPattern17, "", "\021\030\004\021\030\f\t\n\t\023)\021\035\033\030\024\t#A\021-+\b\t\003\030\034\b3", arrayOfObject32, 1);
    SyntaxPattern localSyntaxPattern18 = new SyntaxPattern("\f\030\f\002\f\007\f\017,\r\027\020\b\b\f\037,\r' \b\b\f/\b", new Object[] { "mktmp" }, 6);
    Object[] arrayOfObject33 = new Object[6];
    arrayOfObject33[0] = Lit116;
    arrayOfObject33[1] = Lit109;
    arrayOfObject33[2] = Lit117;
    arrayOfObject33[3] = Lit77;
    arrayOfObject33[4] = "bind";
    arrayOfObject33[5] = PairWithPosition.make(Lit117, LList.Empty, "syntax.scm", 593973);
    arrayOfSyntaxRule5[5] = new SyntaxRule(localSyntaxPattern18, "\001\001\003\001\003\001", "\021\030\0049\021\030\f\t\020\b\013\b\021\030\f)\021\025\023\030\024\b\021\030\034\021\030$\t\033A\021%#\b\t\003\030,\b+", arrayOfObject33, 1);
    Lit78 = new SyntaxRules(arrayOfObject27, arrayOfSyntaxRule5, 7);
    Lit76 = new SyntaxTemplate("\001\001\001", "\020", new Object[0], 0);
    Lit75 = new SyntaxTemplate("\001\001\001", "\023", new Object[0], 0);
    Lit74 = new SyntaxTemplate("\001\001\001", "\b\013", new Object[0], 0);
    Object[] arrayOfObject34 = new Object[1];
    arrayOfObject34[0] = PairWithPosition.make(Lit102, Pair.make(Lit118, Pair.make(Pair.make(Lit104, Pair.make(Lit119, LList.Empty)), LList.Empty)), "syntax.scm", 466951);
    Lit73 = new SyntaxTemplate("\001\001\001", "\030\004", arrayOfObject34, 0);
    Lit72 = new SyntaxPattern("\f\007\f\017\f\027\b", new Object[0], 3);
    Lit71 = new SyntaxTemplate("\001\001\001", "\020", new Object[0], 0);
    Lit70 = new SyntaxTemplate("\001\001\001", "\023", new Object[0], 0);
    Lit69 = new SyntaxTemplate("\001\001\001", "\b\013", new Object[0], 0);
    Object[] arrayOfObject35 = new Object[1];
    arrayOfObject35[0] = PairWithPosition.make(Lit102, Pair.make(Lit118, Pair.make(Pair.make(Lit104, Pair.make(Lit119, LList.Empty)), LList.Empty)), "syntax.scm", 458759);
    Lit68 = new SyntaxTemplate("\001\001\001", "\030\004", arrayOfObject35, 0);
    Object[] arrayOfObject36 = new Object[1];
    arrayOfObject36[0] = ((SimpleSymbol)new SimpleSymbol("library").readResolve());
    Lit67 = new SyntaxPattern("\f\007,\f\002\f\017\b\f\027\b", arrayOfObject36, 3);
    Lit66 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Object[] arrayOfObject37 = new Object[1];
    arrayOfObject37[0] = Lit120;
    Lit65 = new SyntaxPattern("\f\007,\f\002\f\017\023\f\037\b", arrayOfObject37, 4);
    Lit64 = new SyntaxTemplate("\001\001\001\001", "\020", new Object[0], 0);
    Lit63 = new SyntaxTemplate("\001\001\001\001", "\033", new Object[0], 0);
    Lit62 = new SyntaxTemplate("\001\001\001\001", "\023", new Object[0], 0);
    Object[] arrayOfObject38 = new Object[1];
    SimpleSymbol localSimpleSymbol24 = (SimpleSymbol)new SimpleSymbol("%import").readResolve();
    Lit38 = localSimpleSymbol24;
    arrayOfObject38[0] = localSimpleSymbol24;
    Lit61 = new SyntaxTemplate("\001\001\001\001", "\021\030\004\b\013", arrayOfObject38, 0);
    Object[] arrayOfObject39 = new Object[1];
    arrayOfObject39[0] = Lit120;
    Lit60 = new SyntaxPattern("\f\007<\f\002\f\017\f\027\b\f\037\b", arrayOfObject39, 4);
    Lit59 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Lit58 = new SyntaxTemplate("", "\020", new Object[0], 0);
    Lit57 = new SyntaxTemplate("", "\033", new Object[0], 0);
    Lit56 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Object[] arrayOfObject40 = new Object[1];
    arrayOfObject40[0] = Lit38;
    Lit55 = new SyntaxTemplate("", "\021\030\004\b\013", arrayOfObject40, 0);
    Lit54 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Object[] arrayOfObject41 = new Object[1];
    arrayOfObject41[0] = ((SimpleSymbol)new SimpleSymbol("except").readResolve());
    Lit53 = new SyntaxPattern("\f\007,\f\002\f\017\023\f\037\b", arrayOfObject41, 4);
    Lit52 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Lit51 = new SyntaxTemplate("", "\020", new Object[0], 0);
    Lit50 = new SyntaxTemplate("", "\033", new Object[0], 0);
    Lit49 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Object[] arrayOfObject42 = new Object[1];
    arrayOfObject42[0] = Lit38;
    Lit48 = new SyntaxTemplate("", "\021\030\004\b\013", arrayOfObject42, 0);
    Lit47 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Object[] arrayOfObject43 = new Object[1];
    arrayOfObject43[0] = ((SimpleSymbol)new SimpleSymbol("only").readResolve());
    Lit46 = new SyntaxPattern("\f\007,\f\002\f\017\023\f\037\b", arrayOfObject43, 4);
    Object[] arrayOfObject44 = new Object[1];
    arrayOfObject44[0] = ((SimpleSymbol)new SimpleSymbol("rest").readResolve());
    Lit45 = new SyntaxTemplate("", "\030\004", arrayOfObject44, 0);
    Lit44 = new SyntaxTemplate("", "\020", new Object[0], 0);
    Lit43 = new SyntaxTemplate("", "\033", new Object[0], 0);
    Lit42 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Object[] arrayOfObject45 = new Object[1];
    arrayOfObject45[0] = Lit38;
    Lit41 = new SyntaxTemplate("", "\021\030\004\b\013", arrayOfObject45, 0);
    Lit40 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Object[] arrayOfObject46 = new Object[1];
    arrayOfObject46[0] = ((SimpleSymbol)new SimpleSymbol("rename").readResolve());
    Lit39 = new SyntaxPattern("\f\007,\f\002\f\017\023\f\037\b", arrayOfObject46, 4);
    Object[] arrayOfObject47 = new Object[1];
    SimpleSymbol localSimpleSymbol25 = (SimpleSymbol)new SimpleSymbol("jdField_import").readResolve();
    Lit36 = localSimpleSymbol25;
    arrayOfObject47[0] = localSimpleSymbol25;
    SyntaxRule[] arrayOfSyntaxRule6 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern19 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject48 = new Object[3];
    arrayOfObject48[0] = Lit110;
    arrayOfObject48[1] = Lit38;
    arrayOfObject48[2] = PairWithPosition.make(LList.Empty, LList.Empty, "syntax.scm", 376866);
    arrayOfSyntaxRule6[0] = new SyntaxRule(localSyntaxPattern19, "\003", "\021\030\004\b\005\021\030\f\t\003\030\024", arrayOfObject48, 1);
    Lit37 = new SyntaxRules(arrayOfObject47, arrayOfSyntaxRule6, 1);
    Lit35 = (SimpleSymbol)new SimpleSymbol("import-mapper").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("import-handle-rename").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("import-handle-prefix").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("import-handle-except").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("import-handle-only").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("identifier-pair-list?").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("identifier-list?").readResolve();
    Lit28 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Lit27 = new SyntaxTemplate("", "\013", new Object[0], 0);
    Lit26 = new SyntaxPattern("\f\007\f\017\023", new Object[0], 3);
    Lit25 = (SimpleSymbol)new SimpleSymbol("jdField_synchronized").readResolve();
    Lit24 = new SyntaxTemplate("\001\001\001", "\023", new Object[0], 0);
    Lit23 = new SyntaxTemplate("\001\001\001", "\013", new Object[0], 0);
    Lit22 = new SyntaxPattern("\f\007\f\017\f\027\b", new Object[0], 3);
    Lit21 = (SimpleSymbol)new SimpleSymbol("try-finally").readResolve();
    Object[] arrayOfObject49 = new Object[1];
    SimpleSymbol localSimpleSymbol26 = (SimpleSymbol)new SimpleSymbol("when").readResolve();
    Lit17 = localSimpleSymbol26;
    arrayOfObject49[0] = localSimpleSymbol26;
    SyntaxRule[] arrayOfSyntaxRule7 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern20 = new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2);
    Object[] arrayOfObject50 = new Object[3];
    arrayOfObject50[0] = Lit121;
    arrayOfObject50[1] = Lit114;
    arrayOfObject50[2] = Lit110;
    arrayOfSyntaxRule7[0] = new SyntaxRule(localSyntaxPattern20, "\001\003", "\021\030\004)\021\030\f\b\003\b\021\030\024\b\r\013", arrayOfObject50, 1);
    Lit20 = new SyntaxRules(arrayOfObject49, arrayOfSyntaxRule7, 2);
    Lit19 = (SimpleSymbol)new SimpleSymbol("unless").readResolve();
    Object[] arrayOfObject51 = new Object[1];
    arrayOfObject51[0] = Lit17;
    SyntaxRule[] arrayOfSyntaxRule8 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern21 = new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2);
    Object[] arrayOfObject52 = new Object[2];
    arrayOfObject52[0] = Lit121;
    arrayOfObject52[1] = Lit110;
    arrayOfSyntaxRule8[0] = new SyntaxRule(localSyntaxPattern21, "\001\003", "\021\030\004\t\003\b\021\030\f\b\r\013", arrayOfObject52, 1);
    Lit18 = new SyntaxRules(arrayOfObject51, arrayOfSyntaxRule8, 2);
    Object[] arrayOfObject53 = new Object[1];
    SimpleSymbol localSimpleSymbol27 = (SimpleSymbol)new SimpleSymbol("define-syntax-case").readResolve();
    Lit15 = localSimpleSymbol27;
    arrayOfObject53[0] = localSimpleSymbol27;
    SyntaxRule[] arrayOfSyntaxRule9 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern22 = new SyntaxPattern("\f\030\f\007\f\017\023", new Object[0], 3);
    Object[] arrayOfObject54 = new Object[5];
    arrayOfObject54[0] = ((SimpleSymbol)new SimpleSymbol("define-syntax").readResolve());
    arrayOfObject54[1] = Lit109;
    arrayOfObject54[2] = PairWithPosition.make(Lit122, LList.Empty, "syntax.scm", 90129);
    arrayOfObject54[3] = ((SimpleSymbol)new SimpleSymbol("syntax-case").readResolve());
    arrayOfObject54[4] = Lit122;
    arrayOfSyntaxRule9[0] = new SyntaxRule(localSyntaxPattern22, "", "\021\030\004\t\003\b\021\030\f\021\030\024\b\021\030\034\021\030$\t\013\022", arrayOfObject54, 0);
    Lit16 = new SyntaxRules(arrayOfObject53, arrayOfSyntaxRule9, 3);
    Object[] arrayOfObject55 = new Object[1];
    SimpleSymbol localSimpleSymbol28 = (SimpleSymbol)new SimpleSymbol("define-macro").readResolve();
    Lit13 = localSimpleSymbol28;
    arrayOfObject55[0] = localSimpleSymbol28;
    SyntaxRule[] arrayOfSyntaxRule10 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern23 = new SyntaxPattern("\f\030\034\f\007\013\023", new Object[0], 3);
    Object[] arrayOfObject56 = new Object[2];
    arrayOfObject56[0] = Lit123;
    arrayOfObject56[1] = Lit109;
    arrayOfSyntaxRule10[0] = new SyntaxRule(localSyntaxPattern23, "", "\021\030\004\t\003\b\021\030\f\t\n\022", arrayOfObject56, 0);
    SyntaxPattern localSyntaxPattern24 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject57 = new Object[1];
    arrayOfObject57[0] = Lit123;
    arrayOfSyntaxRule10[1] = new SyntaxRule(localSyntaxPattern24, "\001\001", "\021\030\004\t\003\b\013", arrayOfObject57, 0);
    Lit14 = new SyntaxRules(arrayOfObject55, arrayOfSyntaxRule10, 3);
    Object[] arrayOfObject58 = new Object[1];
    SimpleSymbol localSimpleSymbol29 = (SimpleSymbol)new SimpleSymbol("defmacro").readResolve();
    Lit11 = localSimpleSymbol29;
    arrayOfObject58[0] = localSimpleSymbol29;
    SyntaxRule[] arrayOfSyntaxRule11 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern25 = new SyntaxPattern("\f\030\f\007\f\017\023", new Object[0], 3);
    Object[] arrayOfObject59 = new Object[2];
    arrayOfObject59[0] = Lit123;
    arrayOfObject59[1] = Lit109;
    arrayOfSyntaxRule11[0] = new SyntaxRule(localSyntaxPattern25, "", "\021\030\004\t\003\b\021\030\f\t\013\022", arrayOfObject59, 0);
    Lit12 = new SyntaxRules(arrayOfObject58, arrayOfSyntaxRule11, 3);
    Lit10 = new SyntaxPattern("\003", new Object[0], 1);
    Lit9 = new SyntaxPattern("\b", new Object[0], 0);
    Lit8 = new SyntaxTemplate("", "\022", new Object[0], 0);
    Lit7 = new SyntaxTemplate("", "\013", new Object[0], 0);
    Lit6 = new SyntaxTemplate("", "\003", new Object[0], 0);
    Lit5 = new SyntaxPattern(",\f\007\f\017\b\023", new Object[0], 3);
    Lit4 = new SyntaxPattern("\003", new Object[0], 1);
    Lit3 = new SyntaxPattern("\b", new Object[0], 0);
    Lit2 = new SyntaxTemplate("", "\n", new Object[0], 0);
    Lit1 = new SyntaxTemplate("", "\003", new Object[0], 0);
    Lit0 = new SyntaxPattern("\f\007\013", new Object[0], 2);
    $instance = new syntax();
    $Prvt$define$Mnsyntax = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnsyntax");
    $Prvt$define$Mnconstant = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnconstant");
    $Prvt$if = StaticFieldLocation.make("kawa.lib.prim_syntax", "if");
    $Prvt$try$Mncatch = StaticFieldLocation.make("kawa.lib.prim_syntax", "try$Mncatch");
    $Prvt$and = StaticFieldLocation.make("kawa.lib.std_syntax", "and");
    $Prvt$or = StaticFieldLocation.make("kawa.lib.std_syntax", "or");
    $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
    defmacro = Macro.make(Lit11, Lit12, $instance);
    define$Mnmacro = Macro.make(Lit13, Lit14, $instance);
    define$Mnsyntax$Mncase = Macro.make(Lit15, Lit16, $instance);
    when = Macro.make(Lit17, Lit18, $instance);
    unless = Macro.make(Lit19, Lit20, $instance);
    SimpleSymbol localSimpleSymbol30 = Lit21;
    syntax localsyntax = $instance;
    try$Mnfinally = Macro.make(localSimpleSymbol30, new ModuleMethod(localsyntax, 2, null, 4097), $instance);
    jdField_synchronized = Macro.make(Lit25, new ModuleMethod(localsyntax, 3, null, 4097), $instance);
    identifier$Mnlist$Qu = new ModuleMethod(localsyntax, 4, Lit29, 4097);
    identifier$Mnpair$Mnlist$Qu = new ModuleMethod(localsyntax, 5, Lit30, 4097);
    import$Mnhandle$Mnonly = new ModuleMethod(localsyntax, 6, Lit31, 8194);
    import$Mnhandle$Mnexcept = new ModuleMethod(localsyntax, 7, Lit32, 8194);
    import$Mnhandle$Mnprefix = new ModuleMethod(localsyntax, 8, Lit33, 8194);
    import$Mnhandle$Mnrename = new ModuleMethod(localsyntax, 9, Lit34, 8194);
    import$Mnmapper = new ModuleMethod(localsyntax, 10, Lit35, 4097);
    jdField_import = Macro.make(Lit36, Lit37, $instance);
    $Pcimport = Macro.make(Lit38, new ModuleMethod(localsyntax, 11, null, 4097), $instance);
    let$Mnvalues = Macro.make(Lit77, Lit78, $instance);
    let$St$Mnvalues = Macro.make(Lit79, Lit80, $instance);
    case$Mnlambda = Macro.make(Lit81, new ModuleMethod(localsyntax, 12, null, 4097), $instance);
    cond$Mnexpand = Macro.make(Lit91, Lit92, $instance);
    SimpleSymbol localSimpleSymbol31 = Lit93;
    ModuleMethod localModuleMethod = new ModuleMethod(localsyntax, 13, null, 4097);
    localModuleMethod.setProperty("source-location", "syntax.scm:227");
    $Pccond$Mnexpand = Macro.make(localSimpleSymbol31, localModuleMethod, $instance);
    receive = Macro.make(Lit98, Lit99, $instance);
    define$Mnalias$Mnparameter = Macro.make(Lit100, Lit101, $instance);
    $instance.run();
  }

  public syntax()
  {
    ModuleInfo.register(this);
  }

  public static Object importHandleExcept(Object paramObject1, Object paramObject2)
  {
    if (lists.memq(paramObject1, paramObject2) != Boolean.FALSE)
      return null;
    return paramObject1;
  }

  public static Object importHandleOnly(Object paramObject1, Object paramObject2)
  {
    if (lists.memq(paramObject1, paramObject2) != Boolean.FALSE)
      return paramObject1;
    return null;
  }

  public static Object importHandlePrefix(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null);
    return null;
  }

  public static Object importHandleRename(Object paramObject1, Object paramObject2)
  {
    if (lists.isPair(paramObject2))
    {
      if (paramObject1 == lists.caar.apply1(paramObject2))
        return lists.cadar.apply1(paramObject2);
      return importHandleRename(paramObject1, lists.cdr.apply1(paramObject2));
    }
    return paramObject1;
  }

  public static Procedure importMapper(Object paramObject)
  {
    frame localframe = new frame();
    localframe.list = paramObject;
    return localframe.lambda$Fn1;
  }

  public static boolean isIdentifierList(Object paramObject)
  {
    boolean bool1;
    if (Translator.listLength(paramObject) >= 0)
      bool1 = true;
    while (bool1)
    {
      Object[] arrayOfObject;
      boolean bool2;
      while (true)
      {
        arrayOfObject = SyntaxPattern.allocVars(2, null);
        if (!Lit0.match(paramObject, arrayOfObject, 0))
          break label79;
        TemplateScope localTemplateScope1 = TemplateScope.make();
        bool2 = std_syntax.isIdentifier(Lit1.execute(arrayOfObject, localTemplateScope1));
        if (!bool2)
          break;
        TemplateScope localTemplateScope2 = TemplateScope.make();
        paramObject = Lit2.execute(arrayOfObject, localTemplateScope2);
      }
      bool1 = false;
      continue;
      return bool2;
      label79: if (Lit3.match(paramObject, arrayOfObject, 0))
        return true;
      if (Lit4.match(paramObject, arrayOfObject, 0))
        return false;
      return syntax_case.error("syntax-case", paramObject) != Boolean.FALSE;
    }
    return bool1;
  }

  public static boolean isIdentifierPairList(Object paramObject)
  {
    boolean bool1;
    if (Translator.listLength(paramObject) >= 0)
      bool1 = true;
    while (bool1)
    {
      Object[] arrayOfObject;
      boolean bool2;
      while (true)
      {
        arrayOfObject = SyntaxPattern.allocVars(3, null);
        if (!Lit5.match(paramObject, arrayOfObject, 0))
          break label103;
        TemplateScope localTemplateScope1 = TemplateScope.make();
        bool2 = std_syntax.isIdentifier(Lit6.execute(arrayOfObject, localTemplateScope1));
        if (!bool2)
          break;
        TemplateScope localTemplateScope2 = TemplateScope.make();
        bool2 = std_syntax.isIdentifier(Lit7.execute(arrayOfObject, localTemplateScope2));
        if (!bool2)
          break;
        TemplateScope localTemplateScope3 = TemplateScope.make();
        paramObject = Lit8.execute(arrayOfObject, localTemplateScope3);
      }
      bool1 = false;
      continue;
      return bool2;
      label103: if (Lit9.match(paramObject, arrayOfObject, 0))
        return true;
      if (Lit10.match(paramObject, arrayOfObject, 0))
        return false;
      return syntax_case.error("syntax-case", paramObject) != Boolean.FALSE;
    }
    return bool1;
  }

  static Object lambda2(Object paramObject)
  {
    Object[] arrayOfObject = SyntaxPattern.allocVars(3, null);
    if (Lit22.match(paramObject, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      Expression localExpression = SyntaxForms.rewrite(Lit23.execute(arrayOfObject, localTemplateScope1));
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return new TryExp(localExpression, SyntaxForms.rewrite(Lit24.execute(arrayOfObject, localTemplateScope2)));
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  static Object lambda3(Object paramObject)
  {
    Object[] arrayOfObject = SyntaxPattern.allocVars(3, null);
    if (Lit26.match(paramObject, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      Expression localExpression = SyntaxForms.rewrite(Lit27.execute(arrayOfObject, localTemplateScope1));
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return new SynchronizedExp(localExpression, SyntaxForms.rewriteBody(Lit28.execute(arrayOfObject, localTemplateScope2)));
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  static Object lambda4(Object paramObject)
  {
    Object[] arrayOfObject1 = SyntaxPattern.allocVars(4, null);
    if (Lit39.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope11 = TemplateScope.make();
      if (isIdentifierPairList(Lit40.execute(arrayOfObject1, localTemplateScope11)))
      {
        TemplateScope localTemplateScope13 = TemplateScope.make();
        Object[] arrayOfObject16 = new Object[2];
        arrayOfObject16[0] = Lit41.execute(arrayOfObject1, localTemplateScope13);
        Object[] arrayOfObject17 = new Object[2];
        arrayOfObject17[0] = lists.cons(lists.cons(import$Mnhandle$Mnrename, Lit42.execute(arrayOfObject1, localTemplateScope13)), Lit43.execute(arrayOfObject1, localTemplateScope13));
        arrayOfObject17[1] = Lit44.execute(arrayOfObject1, localTemplateScope13);
        arrayOfObject16[1] = Quote.consX$V(arrayOfObject17);
        return Quote.append$V(arrayOfObject16);
      }
      TemplateScope localTemplateScope12 = TemplateScope.make();
      Object localObject6 = Lit45.execute(arrayOfObject1, localTemplateScope12);
      if (("invalid 'rename' clause in import" instanceof Object[]));
      for (Object[] arrayOfObject15 = (Object[])"invalid 'rename' clause in import"; ; arrayOfObject15 = new Object[] { "invalid 'rename' clause in import" })
        return prim_syntax.syntaxError(localObject6, arrayOfObject15);
    }
    if (Lit46.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope8 = TemplateScope.make();
      if (isIdentifierList(Lit47.execute(arrayOfObject1, localTemplateScope8)))
      {
        TemplateScope localTemplateScope10 = TemplateScope.make();
        Object[] arrayOfObject13 = new Object[2];
        arrayOfObject13[0] = Lit48.execute(arrayOfObject1, localTemplateScope10);
        Object[] arrayOfObject14 = new Object[2];
        arrayOfObject14[0] = lists.cons(lists.cons(import$Mnhandle$Mnonly, Lit49.execute(arrayOfObject1, localTemplateScope10)), Lit50.execute(arrayOfObject1, localTemplateScope10));
        arrayOfObject14[1] = Lit51.execute(arrayOfObject1, localTemplateScope10);
        arrayOfObject13[1] = Quote.consX$V(arrayOfObject14);
        return Quote.append$V(arrayOfObject13);
      }
      TemplateScope localTemplateScope9 = TemplateScope.make();
      Object localObject5 = Lit52.execute(arrayOfObject1, localTemplateScope9);
      if (("invalid 'only' identifier list" instanceof Object[]));
      for (Object[] arrayOfObject12 = (Object[])"invalid 'only' identifier list"; ; arrayOfObject12 = new Object[] { "invalid 'only' identifier list" })
        return prim_syntax.syntaxError(localObject5, arrayOfObject12);
    }
    if (Lit53.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope5 = TemplateScope.make();
      if (isIdentifierList(Lit54.execute(arrayOfObject1, localTemplateScope5)))
      {
        TemplateScope localTemplateScope7 = TemplateScope.make();
        Object[] arrayOfObject10 = new Object[2];
        arrayOfObject10[0] = Lit55.execute(arrayOfObject1, localTemplateScope7);
        Object[] arrayOfObject11 = new Object[2];
        arrayOfObject11[0] = lists.cons(lists.cons(import$Mnhandle$Mnexcept, Lit56.execute(arrayOfObject1, localTemplateScope7)), Lit57.execute(arrayOfObject1, localTemplateScope7));
        arrayOfObject11[1] = Lit58.execute(arrayOfObject1, localTemplateScope7);
        arrayOfObject10[1] = Quote.consX$V(arrayOfObject11);
        return Quote.append$V(arrayOfObject10);
      }
      TemplateScope localTemplateScope6 = TemplateScope.make();
      Object localObject4 = Lit59.execute(arrayOfObject1, localTemplateScope6);
      if (("invalid 'except' identifier list" instanceof Object[]));
      for (Object[] arrayOfObject9 = (Object[])"invalid 'except' identifier list"; ; arrayOfObject9 = new Object[] { "invalid 'except' identifier list" })
        return prim_syntax.syntaxError(localObject4, arrayOfObject9);
    }
    if (Lit60.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope4 = TemplateScope.make();
      Object[] arrayOfObject7 = new Object[2];
      arrayOfObject7[0] = Lit61.execute(arrayOfObject1, localTemplateScope4);
      Object[] arrayOfObject8 = new Object[2];
      arrayOfObject8[0] = lists.cons(lists.cons(import$Mnhandle$Mnprefix, Lit62.execute(arrayOfObject1, localTemplateScope4)), Lit63.execute(arrayOfObject1, localTemplateScope4));
      arrayOfObject8[1] = Lit64.execute(arrayOfObject1, localTemplateScope4);
      arrayOfObject7[1] = Quote.consX$V(arrayOfObject8);
      return Quote.append$V(arrayOfObject7);
    }
    if (Lit65.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope3 = TemplateScope.make();
      Object localObject3 = Lit66.execute(arrayOfObject1, localTemplateScope3);
      if (("invalid prefix clause in import" instanceof Object[]));
      for (Object[] arrayOfObject6 = (Object[])"invalid prefix clause in import"; ; arrayOfObject6 = new Object[] { "invalid prefix clause in import" })
        return prim_syntax.syntaxError(localObject3, arrayOfObject6);
    }
    if (Lit67.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      Object localObject2 = Lit68.execute(arrayOfObject1, localTemplateScope2);
      Object[] arrayOfObject4 = new Object[2];
      arrayOfObject4[0] = Lit69.execute(arrayOfObject1, localTemplateScope2);
      Object[] arrayOfObject5 = new Object[2];
      arrayOfObject5[0] = importMapper(std_syntax.syntaxObject$To$Datum(Lit70.execute(arrayOfObject1, localTemplateScope2)));
      arrayOfObject5[1] = Lit71.execute(arrayOfObject1, localTemplateScope2);
      arrayOfObject4[1] = Quote.consX$V(arrayOfObject5);
      return Pair.make(localObject2, Quote.append$V(arrayOfObject4));
    }
    if (Lit72.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      Object localObject1 = Lit73.execute(arrayOfObject1, localTemplateScope1);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Lit74.execute(arrayOfObject1, localTemplateScope1);
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = importMapper(std_syntax.syntaxObject$To$Datum(Lit75.execute(arrayOfObject1, localTemplateScope1)));
      arrayOfObject3[1] = Lit76.execute(arrayOfObject1, localTemplateScope1);
      arrayOfObject2[1] = Quote.consX$V(arrayOfObject3);
      return Pair.make(localObject1, Quote.append$V(arrayOfObject2));
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  static Object lambda5(Object paramObject)
  {
    frame0 localframe0 = new frame0();
    localframe0.$unnamed$1 = SyntaxPattern.allocVars(2, null);
    if (Lit82.match(paramObject, localframe0.$unnamed$1, 0))
    {
      localframe0.$unnamed$0 = TemplateScope.make();
      return Pair.make(Lit83.execute(localframe0.$unnamed$1, localframe0.$unnamed$0), localframe0.lambda6loop(Lit84.execute(localframe0.$unnamed$1, localframe0.$unnamed$0)));
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  static Object lambda7(Object paramObject)
  {
    Object[] arrayOfObject = SyntaxPattern.allocVars(4, null);
    if (Lit94.match(paramObject, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      if (IfFeature.testFeature(Lit95.execute(arrayOfObject, localTemplateScope1)))
      {
        TemplateScope localTemplateScope3 = TemplateScope.make();
        return Lit96.execute(arrayOfObject, localTemplateScope3);
      }
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit97.execute(arrayOfObject, localTemplateScope2);
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 6:
    case 7:
    case 8:
    case 9:
    default:
      return super.apply1(paramModuleMethod, paramObject);
    case 4:
      if (isIdentifierList(paramObject))
        return Boolean.TRUE;
      return Boolean.FALSE;
    case 5:
      if (isIdentifierPairList(paramObject))
        return Boolean.TRUE;
      return Boolean.FALSE;
    case 10:
      return importMapper(paramObject);
    case 2:
      return lambda2(paramObject);
    case 3:
      return lambda3(paramObject);
    case 11:
      return lambda4(paramObject);
    case 12:
      return lambda5(paramObject);
    case 13:
    }
    return lambda7(paramObject);
  }

  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 6:
      return importHandleOnly(paramObject1, paramObject2);
    case 7:
      return importHandleExcept(paramObject1, paramObject2);
    case 8:
      return importHandlePrefix(paramObject1, paramObject2);
    case 9:
    }
    return importHandleRename(paramObject1, paramObject2);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 6:
    case 7:
    case 8:
    case 9:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 13:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 12:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11:
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
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
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
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 9:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 8:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 7:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 6:
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

  public class frame extends ModuleBody
  {
    final ModuleMethod lambda$Fn1;
    Object list;

    public frame()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "syntax.scm:83");
      this.lambda$Fn1 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 1)
        return lambda1(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda1(Object paramObject)
    {
      Object localObject1 = this.list;
      Object localObject2 = paramObject;
      label35: label43: Object localObject4;
      for (Object localObject3 = localObject1; ; localObject3 = localObject4)
      {
        int i;
        if (localObject2 == null)
        {
          i = 1;
          if (i == 0)
            break label35;
          if (i == 0)
            break label43;
        }
        while (lists.isNull(localObject3))
        {
          return localObject2;
          i = 0;
          break;
        }
        localObject4 = lists.cdr.apply1(localObject3);
        localObject2 = Scheme.applyToArgs.apply3(lists.caar.apply1(localObject3), localObject2, lists.cdar.apply1(localObject3));
      }
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

  public class frame0 extends ModuleBody
  {
    TemplateScope $unnamed$0;
    Object[] $unnamed$1;

    public Object lambda6loop(Object paramObject)
    {
      Object[] arrayOfObject1 = SyntaxPattern.allocVars(5, this.$unnamed$1);
      if (syntax.Lit85.match(paramObject, arrayOfObject1, 0))
        return Pair.make(syntax.Lit86.execute(arrayOfObject1, this.$unnamed$0), lambda6loop(syntax.Lit87.execute(arrayOfObject1, this.$unnamed$0)));
      if (syntax.Lit88.match(paramObject, arrayOfObject1, 0))
        return LList.Empty;
      if (syntax.Lit89.match(paramObject, arrayOfObject1, 0))
      {
        Object localObject = syntax.Lit90.execute(arrayOfObject1, this.$unnamed$0);
        if (("invalid case-lambda clause" instanceof Object[]));
        for (Object[] arrayOfObject2 = (Object[])"invalid case-lambda clause"; ; arrayOfObject2 = new Object[] { "invalid case-lambda clause" })
          return LList.list1(prim_syntax.syntaxError(localObject, arrayOfObject2));
      }
      return syntax_case.error("syntax-case", paramObject);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.syntax
 * JD-Core Version:    0.6.2
 */