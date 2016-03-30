package gnu.kawa.slib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.ports;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.append;

public class pregexp extends ModuleBody
{
  public static Char $Stpregexp$Mncomment$Mnchar$St;
  public static Object $Stpregexp$Mnnul$Mnchar$Mnint$St;
  public static Object $Stpregexp$Mnreturn$Mnchar$St;
  public static Object $Stpregexp$Mnspace$Mnsensitive$Qu$St;
  public static Object $Stpregexp$Mntab$Mnchar$St;
  public static IntNum $Stpregexp$Mnversion$St;
  public static final pregexp $instance;
  static final IntNum Lit0;
  static final Char Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit100;
  static final SimpleSymbol Lit101;
  static final SimpleSymbol Lit102;
  static final SimpleSymbol Lit103;
  static final SimpleSymbol Lit104;
  static final SimpleSymbol Lit105;
  static final PairWithPosition Lit106;
  static final SimpleSymbol Lit107;
  static final PairWithPosition Lit108;
  static final SimpleSymbol Lit109;
  static final Char Lit11;
  static final SimpleSymbol Lit110;
  static final SimpleSymbol Lit111;
  static final SimpleSymbol Lit112;
  static final Char Lit113;
  static final SimpleSymbol Lit114;
  static final SimpleSymbol Lit115;
  static final PairWithPosition Lit116;
  static final SimpleSymbol Lit117;
  static final SimpleSymbol Lit118;
  static final SimpleSymbol Lit119;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit120;
  static final SimpleSymbol Lit121;
  static final SimpleSymbol Lit122;
  static final SimpleSymbol Lit123;
  static final SimpleSymbol Lit124;
  static final SimpleSymbol Lit125;
  static final SimpleSymbol Lit126;
  static final SimpleSymbol Lit127;
  static final SimpleSymbol Lit128;
  static final SimpleSymbol Lit129;
  static final Char Lit13;
  static final SimpleSymbol Lit130;
  static final SimpleSymbol Lit131;
  static final SimpleSymbol Lit132;
  static final SimpleSymbol Lit133;
  static final SimpleSymbol Lit134;
  static final SimpleSymbol Lit135 = (SimpleSymbol)new SimpleSymbol("pregexp-quote").readResolve();
  static final SimpleSymbol Lit14;
  static final Char Lit15;
  static final IntNum Lit16;
  static final SimpleSymbol Lit17;
  static final Char Lit18;
  static final Char Lit19;
  static final Char Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final Char Lit24;
  static final Char Lit25;
  static final SimpleSymbol Lit26;
  static final Char Lit27;
  static final SimpleSymbol Lit28;
  static final Char Lit29;
  static final Char Lit3;
  static final SimpleSymbol Lit30;
  static final Char Lit31;
  static final PairWithPosition Lit32;
  static final Char Lit33;
  static final Char Lit34;
  static final Char Lit35;
  static final SimpleSymbol Lit36;
  static final Char Lit37;
  static final PairWithPosition Lit38;
  static final Char Lit39;
  static final SimpleSymbol Lit4;
  static final Char Lit40;
  static final SimpleSymbol Lit41;
  static final Char Lit42;
  static final PairWithPosition Lit43;
  static final Char Lit44;
  static final SimpleSymbol Lit45;
  static final Char Lit46;
  static final Char Lit47;
  static final Char Lit48;
  static final PairWithPosition Lit49;
  static final SimpleSymbol Lit5;
  static final Char Lit50;
  static final PairWithPosition Lit51;
  static final Char Lit52;
  static final PairWithPosition Lit53;
  static final Char Lit54;
  static final PairWithPosition Lit55;
  static final PairWithPosition Lit56;
  static final SimpleSymbol Lit57;
  static final Char Lit58;
  static final Char Lit59;
  static final Char Lit6;
  static final SimpleSymbol Lit60;
  static final SimpleSymbol Lit61;
  static final Char Lit62;
  static final PairWithPosition Lit63;
  static final SimpleSymbol Lit64;
  static final Char Lit65;
  static final Char Lit66;
  static final Char Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final Char Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final IntNum Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final Char Lit77;
  static final Char Lit78;
  static final SimpleSymbol Lit79;
  static final IntNum Lit8;
  static final SimpleSymbol Lit80;
  static final SimpleSymbol Lit81;
  static final SimpleSymbol Lit82;
  static final SimpleSymbol Lit83;
  static final Char Lit84;
  static final SimpleSymbol Lit85;
  static final SimpleSymbol Lit86;
  static final SimpleSymbol Lit87;
  static final SimpleSymbol Lit88;
  static final SimpleSymbol Lit89;
  static final Char Lit9;
  static final SimpleSymbol Lit90;
  static final SimpleSymbol Lit91;
  static final SimpleSymbol Lit92;
  static final SimpleSymbol Lit93;
  static final SimpleSymbol Lit94;
  static final SimpleSymbol Lit95;
  static final Char Lit96;
  static final Char Lit97;
  static final Char Lit98;
  static final SimpleSymbol Lit99;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn10;
  static final ModuleMethod lambda$Fn6;
  static final ModuleMethod lambda$Fn7;
  static final ModuleMethod lambda$Fn8;
  static final ModuleMethod lambda$Fn9;
  public static final ModuleMethod pregexp;
  public static final ModuleMethod pregexp$Mnat$Mnword$Mnboundary$Qu;
  public static final ModuleMethod pregexp$Mnchar$Mnword$Qu;
  public static final ModuleMethod pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu;
  public static final ModuleMethod pregexp$Mnerror;
  public static final ModuleMethod pregexp$Mninvert$Mnchar$Mnlist;
  public static final ModuleMethod pregexp$Mnlist$Mnref;
  public static final ModuleMethod pregexp$Mnmake$Mnbackref$Mnlist;
  public static final ModuleMethod pregexp$Mnmatch;
  public static final ModuleMethod pregexp$Mnmatch$Mnpositions;
  public static final ModuleMethod pregexp$Mnmatch$Mnpositions$Mnaux;
  public static final ModuleMethod pregexp$Mnquote;
  public static final ModuleMethod pregexp$Mnread$Mnbranch;
  public static final ModuleMethod pregexp$Mnread$Mnchar$Mnlist;
  public static final ModuleMethod pregexp$Mnread$Mncluster$Mntype;
  public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnchar;
  public static final ModuleMethod pregexp$Mnread$Mnescaped$Mnnumber;
  public static final ModuleMethod pregexp$Mnread$Mnnums;
  public static final ModuleMethod pregexp$Mnread$Mnpattern;
  public static final ModuleMethod pregexp$Mnread$Mnpiece;
  public static final ModuleMethod pregexp$Mnread$Mnposix$Mnchar$Mnclass;
  public static final ModuleMethod pregexp$Mnread$Mnsubpattern;
  public static final ModuleMethod pregexp$Mnreplace;
  public static final ModuleMethod pregexp$Mnreplace$Mnaux;
  public static final ModuleMethod pregexp$Mnreplace$St;
  public static final ModuleMethod pregexp$Mnreverse$Ex;
  public static final ModuleMethod pregexp$Mnsplit;
  public static final ModuleMethod pregexp$Mnstring$Mnmatch;
  public static final ModuleMethod pregexp$Mnwrap$Mnquantifier$Mnif$Mnany;

  static
  {
    Lit134 = (SimpleSymbol)new SimpleSymbol("pregexp-replace*").readResolve();
    Lit133 = (SimpleSymbol)new SimpleSymbol("pregexp-replace").readResolve();
    Lit132 = (SimpleSymbol)new SimpleSymbol("pregexp-split").readResolve();
    Lit131 = (SimpleSymbol)new SimpleSymbol("pregexp-match").readResolve();
    Lit130 = (SimpleSymbol)new SimpleSymbol("pregexp").readResolve();
    Lit129 = (SimpleSymbol)new SimpleSymbol("pregexp-replace-aux").readResolve();
    Lit128 = (SimpleSymbol)new SimpleSymbol("pregexp-make-backref-list").readResolve();
    Lit127 = (SimpleSymbol)new SimpleSymbol("pregexp-list-ref").readResolve();
    Lit126 = (SimpleSymbol)new SimpleSymbol("pregexp-at-word-boundary?").readResolve();
    Lit125 = (SimpleSymbol)new SimpleSymbol("pregexp-char-word?").readResolve();
    Lit124 = (SimpleSymbol)new SimpleSymbol("pregexp-string-match").readResolve();
    Lit123 = (SimpleSymbol)new SimpleSymbol("pregexp-invert-char-list").readResolve();
    Lit122 = (SimpleSymbol)new SimpleSymbol("pregexp-read-escaped-char").readResolve();
    Lit121 = (SimpleSymbol)new SimpleSymbol("pregexp-read-escaped-number").readResolve();
    Lit120 = (SimpleSymbol)new SimpleSymbol("pregexp-read-branch").readResolve();
    Lit119 = (SimpleSymbol)new SimpleSymbol("pregexp-read-pattern").readResolve();
    Lit118 = (SimpleSymbol)new SimpleSymbol("pregexp-error").readResolve();
    Lit117 = (SimpleSymbol)new SimpleSymbol("pregexp-reverse!").readResolve();
    Char localChar1 = Char.make(92);
    Lit19 = localChar1;
    Char localChar2 = Char.make(46);
    Lit13 = localChar2;
    Char localChar3 = Char.make(63);
    Lit47 = localChar3;
    Char localChar4 = Char.make(42);
    Lit65 = localChar4;
    Char localChar5 = Char.make(43);
    Lit66 = localChar5;
    Char localChar6 = Char.make(124);
    Lit7 = localChar6;
    Char localChar7 = Char.make(94);
    Lit9 = localChar7;
    Char localChar8 = Char.make(36);
    Lit11 = localChar8;
    Char localChar9 = Char.make(91);
    Lit15 = localChar9;
    Char localChar10 = Char.make(93);
    Lit46 = localChar10;
    Char localChar11 = Char.make(123);
    Lit67 = localChar11;
    Char localChar12 = Char.make(125);
    Lit78 = localChar12;
    Char localChar13 = Char.make(40);
    Lit18 = localChar13;
    Char localChar14 = Char.make(41);
    Lit6 = localChar14;
    Lit116 = PairWithPosition.make(localChar1, PairWithPosition.make(localChar2, PairWithPosition.make(localChar3, PairWithPosition.make(localChar4, PairWithPosition.make(localChar5, PairWithPosition.make(localChar6, PairWithPosition.make(localChar7, PairWithPosition.make(localChar8, PairWithPosition.make(localChar9, PairWithPosition.make(localChar10, PairWithPosition.make(localChar11, PairWithPosition.make(localChar12, PairWithPosition.make(localChar13, PairWithPosition.make(localChar14, LList.Empty, "pregexp.scm", 3153977), "pregexp.scm", 3153973), "pregexp.scm", 3153969), "pregexp.scm", 3153965), "pregexp.scm", 3153961), "pregexp.scm", 3153957), "pregexp.scm", 3149885), "pregexp.scm", 3149881), "pregexp.scm", 3149877), "pregexp.scm", 3149873), "pregexp.scm", 3149869), "pregexp.scm", 3149865), "pregexp.scm", 3149861), "pregexp.scm", 3149856);
    Lit115 = (SimpleSymbol)new SimpleSymbol("pattern-must-be-compiled-or-string-regexp").readResolve();
    Lit114 = (SimpleSymbol)new SimpleSymbol("pregexp-match-positions").readResolve();
    Lit113 = Char.make(38);
    Lit112 = (SimpleSymbol)new SimpleSymbol("identity").readResolve();
    Lit111 = (SimpleSymbol)new SimpleSymbol("fk").readResolve();
    Lit110 = (SimpleSymbol)new SimpleSymbol("greedy-quantifier-operand-could-be-empty").readResolve();
    Lit109 = (SimpleSymbol)new SimpleSymbol(":no-backtrack").readResolve();
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol(":between").readResolve();
    Lit68 = localSimpleSymbol1;
    Boolean localBoolean1 = Boolean.FALSE;
    IntNum localIntNum = IntNum.make(0);
    Lit73 = localIntNum;
    Boolean localBoolean2 = Boolean.FALSE;
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol(":any").readResolve();
    Lit14 = localSimpleSymbol2;
    Lit108 = PairWithPosition.make(localSimpleSymbol1, PairWithPosition.make(localBoolean1, PairWithPosition.make(localIntNum, PairWithPosition.make(localBoolean2, PairWithPosition.make(localSimpleSymbol2, LList.Empty, "pregexp.scm", 2338881), "pregexp.scm", 2338878), "pregexp.scm", 2338876), "pregexp.scm", 2338873), "pregexp.scm", 2338863);
    Lit107 = (SimpleSymbol)new SimpleSymbol(":neg-lookbehind").readResolve();
    Lit106 = PairWithPosition.make(Lit68, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit73, PairWithPosition.make(Boolean.FALSE, PairWithPosition.make(Lit14, LList.Empty, "pregexp.scm", 2302017), "pregexp.scm", 2302014), "pregexp.scm", 2302012), "pregexp.scm", 2302009), "pregexp.scm", 2301999);
    Lit105 = (SimpleSymbol)new SimpleSymbol(":lookbehind").readResolve();
    Lit104 = (SimpleSymbol)new SimpleSymbol(":neg-lookahead").readResolve();
    Lit103 = (SimpleSymbol)new SimpleSymbol(":lookahead").readResolve();
    Lit102 = (SimpleSymbol)new SimpleSymbol("non-existent-backref").readResolve();
    Lit101 = (SimpleSymbol)new SimpleSymbol("pregexp-match-positions-aux").readResolve();
    Lit100 = (SimpleSymbol)new SimpleSymbol(":sub").readResolve();
    Lit99 = (SimpleSymbol)new SimpleSymbol("pregexp-check-if-in-char-class?").readResolve();
    Lit98 = Char.make(102);
    Lit97 = Char.make(101);
    Lit96 = Char.make(99);
    Lit95 = (SimpleSymbol)new SimpleSymbol(":xdigit").readResolve();
    Lit94 = (SimpleSymbol)new SimpleSymbol(":upper").readResolve();
    Lit93 = (SimpleSymbol)new SimpleSymbol(":punct").readResolve();
    Lit92 = (SimpleSymbol)new SimpleSymbol(":print").readResolve();
    Lit91 = (SimpleSymbol)new SimpleSymbol(":lower").readResolve();
    Lit90 = (SimpleSymbol)new SimpleSymbol(":graph").readResolve();
    Lit89 = (SimpleSymbol)new SimpleSymbol(":cntrl").readResolve();
    Lit88 = (SimpleSymbol)new SimpleSymbol(":blank").readResolve();
    Lit87 = (SimpleSymbol)new SimpleSymbol(":ascii").readResolve();
    Lit86 = (SimpleSymbol)new SimpleSymbol(":alpha").readResolve();
    Lit85 = (SimpleSymbol)new SimpleSymbol(":alnum").readResolve();
    Lit84 = Char.make(95);
    Lit83 = (SimpleSymbol)new SimpleSymbol(":char-range").readResolve();
    Lit82 = (SimpleSymbol)new SimpleSymbol(":one-of-chars").readResolve();
    Lit81 = (SimpleSymbol)new SimpleSymbol("character-class-ended-too-soon").readResolve();
    Lit80 = (SimpleSymbol)new SimpleSymbol("pregexp-read-char-list").readResolve();
    Lit79 = (SimpleSymbol)new SimpleSymbol(":none-of-chars").readResolve();
    Lit77 = Char.make(44);
    Lit76 = (SimpleSymbol)new SimpleSymbol("pregexp-read-nums").readResolve();
    Lit75 = (SimpleSymbol)new SimpleSymbol("left-brace-must-be-followed-by-number").readResolve();
    Lit74 = (SimpleSymbol)new SimpleSymbol("pregexp-wrap-quantifier-if-any").readResolve();
    Lit72 = (SimpleSymbol)new SimpleSymbol("next-i").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("at-most").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("at-least").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("minimal?").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("pregexp-read-subpattern").readResolve();
    Lit63 = PairWithPosition.make(Lit100, LList.Empty, "pregexp.scm", 942102);
    Lit62 = Char.make(120);
    Lit61 = (SimpleSymbol)new SimpleSymbol(":case-insensitive").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol(":case-sensitive").readResolve();
    Lit59 = Char.make(105);
    Lit58 = Char.make(45);
    Lit57 = (SimpleSymbol)new SimpleSymbol("pregexp-read-cluster-type").readResolve();
    Lit56 = PairWithPosition.make(Lit107, LList.Empty, "pregexp.scm", 876575);
    Lit55 = PairWithPosition.make(Lit105, LList.Empty, "pregexp.scm", 872479);
    Lit54 = Char.make(60);
    Lit53 = PairWithPosition.make(Lit109, LList.Empty, "pregexp.scm", 860188);
    Lit52 = Char.make(62);
    Lit51 = PairWithPosition.make(Lit104, LList.Empty, "pregexp.scm", 856092);
    Lit50 = Char.make(33);
    Lit49 = PairWithPosition.make(Lit103, LList.Empty, "pregexp.scm", 851996);
    Lit48 = Char.make(61);
    Lit45 = (SimpleSymbol)new SimpleSymbol("pregexp-read-posix-char-class").readResolve();
    Lit44 = Char.make(58);
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol(":neg-char").readResolve();
    Lit17 = localSimpleSymbol3;
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol(":word").readResolve();
    Lit41 = localSimpleSymbol4;
    Lit43 = PairWithPosition.make(localSimpleSymbol3, PairWithPosition.make(localSimpleSymbol4, LList.Empty, "pregexp.scm", 696359), "pregexp.scm", 696348);
    Lit42 = Char.make(87);
    Lit40 = Char.make(119);
    Lit39 = Char.make(116);
    SimpleSymbol localSimpleSymbol5 = Lit17;
    SimpleSymbol localSimpleSymbol6 = (SimpleSymbol)new SimpleSymbol(":space").readResolve();
    Lit36 = localSimpleSymbol6;
    Lit38 = PairWithPosition.make(localSimpleSymbol5, PairWithPosition.make(localSimpleSymbol6, LList.Empty, "pregexp.scm", 684071), "pregexp.scm", 684060);
    Lit37 = Char.make(83);
    Lit35 = Char.make(115);
    Lit34 = Char.make(114);
    Lit33 = Char.make(110);
    SimpleSymbol localSimpleSymbol7 = Lit17;
    SimpleSymbol localSimpleSymbol8 = (SimpleSymbol)new SimpleSymbol(":digit").readResolve();
    Lit30 = localSimpleSymbol8;
    Lit32 = PairWithPosition.make(localSimpleSymbol7, PairWithPosition.make(localSimpleSymbol8, LList.Empty, "pregexp.scm", 667687), "pregexp.scm", 667676);
    Lit31 = Char.make(68);
    Lit29 = Char.make(100);
    Lit28 = (SimpleSymbol)new SimpleSymbol(":not-wbdry").readResolve();
    Lit27 = Char.make(66);
    Lit26 = (SimpleSymbol)new SimpleSymbol(":wbdry").readResolve();
    Lit25 = Char.make(98);
    Lit24 = Char.make(10);
    Lit23 = (SimpleSymbol)new SimpleSymbol(":empty").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("backslash").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("pregexp-read-piece").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol(":backref").readResolve();
    Lit16 = IntNum.make(2);
    Lit12 = (SimpleSymbol)new SimpleSymbol(":eos").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol(":bos").readResolve();
    Lit8 = IntNum.make(1);
    Lit5 = (SimpleSymbol)new SimpleSymbol(":seq").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol(":or").readResolve();
    Lit3 = Char.make(32);
    Lit2 = Char.make(97);
    Lit1 = Char.make(59);
    Lit0 = IntNum.make(20050502);
    $instance = new pregexp();
    pregexp localpregexp = $instance;
    ModuleMethod localModuleMethod1 = new ModuleMethod(localpregexp, 16, Lit117, 4097);
    localModuleMethod1.setProperty("source-location", "pregexp.scm:47");
    pregexp$Mnreverse$Ex = localModuleMethod1;
    ModuleMethod localModuleMethod2 = new ModuleMethod(localpregexp, 17, Lit118, -4096);
    localModuleMethod2.setProperty("source-location", "pregexp.scm:57");
    pregexp$Mnerror = localModuleMethod2;
    ModuleMethod localModuleMethod3 = new ModuleMethod(localpregexp, 18, Lit119, 12291);
    localModuleMethod3.setProperty("source-location", "pregexp.scm:65");
    pregexp$Mnread$Mnpattern = localModuleMethod3;
    ModuleMethod localModuleMethod4 = new ModuleMethod(localpregexp, 19, Lit120, 12291);
    localModuleMethod4.setProperty("source-location", "pregexp.scm:79");
    pregexp$Mnread$Mnbranch = localModuleMethod4;
    ModuleMethod localModuleMethod5 = new ModuleMethod(localpregexp, 20, Lit21, 12291);
    localModuleMethod5.setProperty("source-location", "pregexp.scm:91");
    pregexp$Mnread$Mnpiece = localModuleMethod5;
    ModuleMethod localModuleMethod6 = new ModuleMethod(localpregexp, 21, Lit121, 12291);
    localModuleMethod6.setProperty("source-location", "pregexp.scm:138");
    pregexp$Mnread$Mnescaped$Mnnumber = localModuleMethod6;
    ModuleMethod localModuleMethod7 = new ModuleMethod(localpregexp, 22, Lit122, 12291);
    localModuleMethod7.setProperty("source-location", "pregexp.scm:155");
    pregexp$Mnread$Mnescaped$Mnchar = localModuleMethod7;
    ModuleMethod localModuleMethod8 = new ModuleMethod(localpregexp, 23, Lit45, 12291);
    localModuleMethod8.setProperty("source-location", "pregexp.scm:174");
    pregexp$Mnread$Mnposix$Mnchar$Mnclass = localModuleMethod8;
    ModuleMethod localModuleMethod9 = new ModuleMethod(localpregexp, 24, Lit57, 12291);
    localModuleMethod9.setProperty("source-location", "pregexp.scm:200");
    pregexp$Mnread$Mncluster$Mntype = localModuleMethod9;
    ModuleMethod localModuleMethod10 = new ModuleMethod(localpregexp, 25, Lit64, 12291);
    localModuleMethod10.setProperty("source-location", "pregexp.scm:233");
    pregexp$Mnread$Mnsubpattern = localModuleMethod10;
    ModuleMethod localModuleMethod11 = new ModuleMethod(localpregexp, 26, Lit74, 12291);
    localModuleMethod11.setProperty("source-location", "pregexp.scm:254");
    pregexp$Mnwrap$Mnquantifier$Mnif$Mnany = localModuleMethod11;
    ModuleMethod localModuleMethod12 = new ModuleMethod(localpregexp, 27, Lit76, 12291);
    localModuleMethod12.setProperty("source-location", "pregexp.scm:300");
    pregexp$Mnread$Mnnums = localModuleMethod12;
    ModuleMethod localModuleMethod13 = new ModuleMethod(localpregexp, 28, Lit123, 4097);
    localModuleMethod13.setProperty("source-location", "pregexp.scm:323");
    pregexp$Mninvert$Mnchar$Mnlist = localModuleMethod13;
    ModuleMethod localModuleMethod14 = new ModuleMethod(localpregexp, 29, Lit80, 12291);
    localModuleMethod14.setProperty("source-location", "pregexp.scm:330");
    pregexp$Mnread$Mnchar$Mnlist = localModuleMethod14;
    ModuleMethod localModuleMethod15 = new ModuleMethod(localpregexp, 30, Lit124, 24582);
    localModuleMethod15.setProperty("source-location", "pregexp.scm:368");
    pregexp$Mnstring$Mnmatch = localModuleMethod15;
    ModuleMethod localModuleMethod16 = new ModuleMethod(localpregexp, 31, Lit125, 4097);
    localModuleMethod16.setProperty("source-location", "pregexp.scm:379");
    pregexp$Mnchar$Mnword$Qu = localModuleMethod16;
    ModuleMethod localModuleMethod17 = new ModuleMethod(localpregexp, 32, Lit126, 12291);
    localModuleMethod17.setProperty("source-location", "pregexp.scm:387");
    pregexp$Mnat$Mnword$Mnboundary$Qu = localModuleMethod17;
    ModuleMethod localModuleMethod18 = new ModuleMethod(localpregexp, 33, Lit99, 8194);
    localModuleMethod18.setProperty("source-location", "pregexp.scm:399");
    pregexp$Mncheck$Mnif$Mnin$Mnchar$Mnclass$Qu = localModuleMethod18;
    ModuleMethod localModuleMethod19 = new ModuleMethod(localpregexp, 34, Lit127, 8194);
    localModuleMethod19.setProperty("source-location", "pregexp.scm:429");
    pregexp$Mnlist$Mnref = localModuleMethod19;
    ModuleMethod localModuleMethod20 = new ModuleMethod(localpregexp, 35, Lit128, 4097);
    localModuleMethod20.setProperty("source-location", "pregexp.scm:448");
    pregexp$Mnmake$Mnbackref$Mnlist = localModuleMethod20;
    ModuleMethod localModuleMethod21 = new ModuleMethod(localpregexp, 36, null, 0);
    localModuleMethod21.setProperty("source-location", "pregexp.scm:463");
    lambda$Fn1 = localModuleMethod21;
    ModuleMethod localModuleMethod22 = new ModuleMethod(localpregexp, 37, null, 0);
    localModuleMethod22.setProperty("source-location", "pregexp.scm:551");
    lambda$Fn6 = localModuleMethod22;
    ModuleMethod localModuleMethod23 = new ModuleMethod(localpregexp, 38, null, 0);
    localModuleMethod23.setProperty("source-location", "pregexp.scm:556");
    lambda$Fn7 = localModuleMethod23;
    ModuleMethod localModuleMethod24 = new ModuleMethod(localpregexp, 39, null, 0);
    localModuleMethod24.setProperty("source-location", "pregexp.scm:564");
    lambda$Fn8 = localModuleMethod24;
    ModuleMethod localModuleMethod25 = new ModuleMethod(localpregexp, 40, null, 0);
    localModuleMethod25.setProperty("source-location", "pregexp.scm:573");
    lambda$Fn9 = localModuleMethod25;
    ModuleMethod localModuleMethod26 = new ModuleMethod(localpregexp, 41, null, 0);
    localModuleMethod26.setProperty("source-location", "pregexp.scm:578");
    lambda$Fn10 = localModuleMethod26;
    ModuleMethod localModuleMethod27 = new ModuleMethod(localpregexp, 42, Lit101, 24582);
    localModuleMethod27.setProperty("source-location", "pregexp.scm:459");
    pregexp$Mnmatch$Mnpositions$Mnaux = localModuleMethod27;
    ModuleMethod localModuleMethod28 = new ModuleMethod(localpregexp, 43, Lit129, 16388);
    localModuleMethod28.setProperty("source-location", "pregexp.scm:639");
    pregexp$Mnreplace$Mnaux = localModuleMethod28;
    ModuleMethod localModuleMethod29 = new ModuleMethod(localpregexp, 44, Lit130, 4097);
    localModuleMethod29.setProperty("source-location", "pregexp.scm:665");
    pregexp = localModuleMethod29;
    ModuleMethod localModuleMethod30 = new ModuleMethod(localpregexp, 45, Lit114, -4094);
    localModuleMethod30.setProperty("source-location", "pregexp.scm:670");
    pregexp$Mnmatch$Mnpositions = localModuleMethod30;
    ModuleMethod localModuleMethod31 = new ModuleMethod(localpregexp, 46, Lit131, -4094);
    localModuleMethod31.setProperty("source-location", "pregexp.scm:690");
    pregexp$Mnmatch = localModuleMethod31;
    ModuleMethod localModuleMethod32 = new ModuleMethod(localpregexp, 47, Lit132, 8194);
    localModuleMethod32.setProperty("source-location", "pregexp.scm:700");
    pregexp$Mnsplit = localModuleMethod32;
    ModuleMethod localModuleMethod33 = new ModuleMethod(localpregexp, 48, Lit133, 12291);
    localModuleMethod33.setProperty("source-location", "pregexp.scm:723");
    pregexp$Mnreplace = localModuleMethod33;
    ModuleMethod localModuleMethod34 = new ModuleMethod(localpregexp, 49, Lit134, 12291);
    localModuleMethod34.setProperty("source-location", "pregexp.scm:736");
    pregexp$Mnreplace$St = localModuleMethod34;
    ModuleMethod localModuleMethod35 = new ModuleMethod(localpregexp, 50, Lit135, 4097);
    localModuleMethod35.setProperty("source-location", "pregexp.scm:764");
    pregexp$Mnquote = localModuleMethod35;
    $instance.run();
  }

  public pregexp()
  {
    ModuleInfo.register(this);
  }

  // ERROR //
  public static Object isPregexpAtWordBoundary(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 870	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   3: aload_1
    //   4: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   7: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore_3
    //   11: aload_3
    //   12: checkcast 371	java/lang/Boolean
    //   15: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   18: istore 5
    //   20: iload 5
    //   22: ifeq +16 -> 38
    //   25: iload 5
    //   27: ifeq +7 -> 34
    //   30: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   33: areturn
    //   34: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   37: areturn
    //   38: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: astore 6
    //   48: aload 6
    //   50: checkcast 371	java/lang/Boolean
    //   53: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   56: istore 8
    //   58: iload 8
    //   60: ifeq +16 -> 76
    //   63: iload 8
    //   65: ifeq +7 -> 72
    //   68: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   71: areturn
    //   72: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   75: areturn
    //   76: aload_0
    //   77: checkcast 888	java/lang/CharSequence
    //   80: astore 10
    //   82: aload_1
    //   83: checkcast 890	java/lang/Number
    //   86: invokevirtual 894	java/lang/Number:intValue	()I
    //   89: istore 12
    //   91: aload 10
    //   93: iload 12
    //   95: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   98: istore 13
    //   100: aload_0
    //   101: checkcast 888	java/lang/CharSequence
    //   104: astore 15
    //   106: getstatic 906	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   109: aload_1
    //   110: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   113: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: astore 16
    //   118: aload 16
    //   120: checkcast 890	java/lang/Number
    //   123: invokevirtual 894	java/lang/Number:intValue	()I
    //   126: istore 18
    //   128: aload 15
    //   130: iload 18
    //   132: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   135: istore 19
    //   137: iload 13
    //   139: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   142: getstatic 596	gnu/kawa/slib/pregexp:Lit41	Lgnu/mapping/SimpleSymbol;
    //   145: invokestatic 909	gnu/kawa/slib/pregexp:isPregexpCheckIfInCharClass	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: astore 20
    //   150: iload 19
    //   152: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   155: getstatic 596	gnu/kawa/slib/pregexp:Lit41	Lgnu/mapping/SimpleSymbol;
    //   158: invokestatic 909	gnu/kawa/slib/pregexp:isPregexpCheckIfInCharClass	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: astore 21
    //   163: aload 20
    //   165: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   168: if_acmpeq +39 -> 207
    //   171: aload 21
    //   173: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   176: if_acmpeq +23 -> 199
    //   179: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   182: astore 27
    //   184: aload 27
    //   186: astore 22
    //   188: aload 22
    //   190: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   193: if_acmpeq +21 -> 214
    //   196: aload 22
    //   198: areturn
    //   199: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   202: astore 27
    //   204: goto -20 -> 184
    //   207: aload 20
    //   209: astore 22
    //   211: goto -23 -> 188
    //   214: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   217: astore 24
    //   219: aload 20
    //   221: aload 24
    //   223: if_acmpeq +22 -> 245
    //   226: iconst_1
    //   227: istore 25
    //   229: iconst_1
    //   230: iload 25
    //   232: iconst_1
    //   233: iadd
    //   234: iand
    //   235: istore 26
    //   237: iload 26
    //   239: ifeq +12 -> 251
    //   242: aload 21
    //   244: areturn
    //   245: iconst_0
    //   246: istore 25
    //   248: goto -19 -> 229
    //   251: iload 26
    //   253: ifeq +7 -> 260
    //   256: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   259: areturn
    //   260: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   263: areturn
    //   264: astore 4
    //   266: new 911	gnu/mapping/WrongType
    //   269: dup
    //   270: aload 4
    //   272: ldc_w 913
    //   275: bipush 254
    //   277: aload_3
    //   278: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   281: athrow
    //   282: astore 7
    //   284: new 911	gnu/mapping/WrongType
    //   287: dup
    //   288: aload 7
    //   290: ldc_w 913
    //   293: bipush 254
    //   295: aload 6
    //   297: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   300: athrow
    //   301: astore 9
    //   303: new 911	gnu/mapping/WrongType
    //   306: dup
    //   307: aload 9
    //   309: ldc_w 918
    //   312: iconst_1
    //   313: aload_0
    //   314: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   317: athrow
    //   318: astore 11
    //   320: new 911	gnu/mapping/WrongType
    //   323: dup
    //   324: aload 11
    //   326: ldc_w 918
    //   329: iconst_2
    //   330: aload_1
    //   331: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   334: athrow
    //   335: astore 14
    //   337: new 911	gnu/mapping/WrongType
    //   340: dup
    //   341: aload 14
    //   343: ldc_w 918
    //   346: iconst_1
    //   347: aload_0
    //   348: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   351: athrow
    //   352: astore 17
    //   354: new 911	gnu/mapping/WrongType
    //   357: dup
    //   358: aload 17
    //   360: ldc_w 918
    //   363: iconst_2
    //   364: aload 16
    //   366: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   369: athrow
    //   370: astore 23
    //   372: new 911	gnu/mapping/WrongType
    //   375: dup
    //   376: aload 23
    //   378: ldc_w 913
    //   381: bipush 254
    //   383: aload 20
    //   385: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   388: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   11	20	264	java/lang/ClassCastException
    //   48	58	282	java/lang/ClassCastException
    //   76	82	301	java/lang/ClassCastException
    //   82	91	318	java/lang/ClassCastException
    //   100	106	335	java/lang/ClassCastException
    //   118	128	352	java/lang/ClassCastException
    //   214	219	370	java/lang/ClassCastException
  }

  // ERROR //
  public static boolean isPregexpCharWord(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 278	gnu/text/Char
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 926	kawa/lib/rnrs/unicode:isCharAlphabetic	(Lgnu/text/Char;)Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifeq +5 -> 16
    //   14: iload_3
    //   15: ireturn
    //   16: aload_0
    //   17: checkcast 278	gnu/text/Char
    //   20: astore 5
    //   22: aload 5
    //   24: invokestatic 929	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   27: istore 6
    //   29: iload 6
    //   31: ifeq +6 -> 37
    //   34: iload 6
    //   36: ireturn
    //   37: aload_0
    //   38: checkcast 278	gnu/text/Char
    //   41: astore 8
    //   43: aload 8
    //   45: getstatic 484	gnu/kawa/slib/pregexp:Lit84	Lgnu/text/Char;
    //   48: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   51: ireturn
    //   52: astore_1
    //   53: new 911	gnu/mapping/WrongType
    //   56: dup
    //   57: aload_1
    //   58: ldc_w 937
    //   61: iconst_1
    //   62: aload_0
    //   63: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   66: athrow
    //   67: astore 4
    //   69: new 911	gnu/mapping/WrongType
    //   72: dup
    //   73: aload 4
    //   75: ldc_w 939
    //   78: iconst_1
    //   79: aload_0
    //   80: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   83: athrow
    //   84: astore 7
    //   86: new 911	gnu/mapping/WrongType
    //   89: dup
    //   90: aload 7
    //   92: ldc_w 941
    //   95: iconst_1
    //   96: aload_0
    //   97: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   100: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	52	java/lang/ClassCastException
    //   16	22	67	java/lang/ClassCastException
    //   37	43	84	java/lang/ClassCastException
  }

  // ERROR //
  public static Object isPregexpCheckIfInCharClass(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3: aload_1
    //   4: getstatic 386	gnu/kawa/slib/pregexp:Lit14	Lgnu/mapping/SimpleSymbol;
    //   7: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   13: if_acmpeq +28 -> 41
    //   16: aload_0
    //   17: checkcast 278	gnu/text/Char
    //   20: astore 77
    //   22: aload 77
    //   24: getstatic 648	gnu/kawa/slib/pregexp:Lit24	Lgnu/text/Char;
    //   27: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   30: ifeq +7 -> 37
    //   33: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   36: areturn
    //   37: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   40: areturn
    //   41: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   44: aload_1
    //   45: getstatic 482	gnu/kawa/slib/pregexp:Lit85	Lgnu/mapping/SimpleSymbol;
    //   48: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   54: if_acmpeq +56 -> 110
    //   57: aload_0
    //   58: checkcast 278	gnu/text/Char
    //   61: astore 72
    //   63: aload 72
    //   65: invokestatic 926	kawa/lib/rnrs/unicode:isCharAlphabetic	(Lgnu/text/Char;)Z
    //   68: istore 73
    //   70: iload 73
    //   72: ifeq +16 -> 88
    //   75: iload 73
    //   77: ifeq +7 -> 84
    //   80: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   83: areturn
    //   84: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   87: areturn
    //   88: aload_0
    //   89: checkcast 278	gnu/text/Char
    //   92: astore 75
    //   94: aload 75
    //   96: invokestatic 929	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   99: ifeq +7 -> 106
    //   102: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   105: areturn
    //   106: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   109: areturn
    //   110: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   113: aload_1
    //   114: getstatic 478	gnu/kawa/slib/pregexp:Lit86	Lgnu/mapping/SimpleSymbol;
    //   117: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   123: if_acmpeq +25 -> 148
    //   126: aload_0
    //   127: checkcast 278	gnu/text/Char
    //   130: astore 70
    //   132: aload 70
    //   134: invokestatic 926	kawa/lib/rnrs/unicode:isCharAlphabetic	(Lgnu/text/Char;)Z
    //   137: ifeq +7 -> 144
    //   140: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   143: areturn
    //   144: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   147: areturn
    //   148: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   151: aload_1
    //   152: getstatic 474	gnu/kawa/slib/pregexp:Lit87	Lgnu/mapping/SimpleSymbol;
    //   155: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   161: if_acmpeq +28 -> 189
    //   164: aload_0
    //   165: checkcast 278	gnu/text/Char
    //   168: astore 68
    //   170: aload 68
    //   172: invokestatic 949	kawa/lib/characters:char$To$Integer	(Lgnu/text/Char;)I
    //   175: sipush 128
    //   178: if_icmpge +7 -> 185
    //   181: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   184: areturn
    //   185: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   188: areturn
    //   189: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   192: aload_1
    //   193: getstatic 470	gnu/kawa/slib/pregexp:Lit88	Lgnu/mapping/SimpleSymbol;
    //   196: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   202: if_acmpeq +73 -> 275
    //   205: aload_0
    //   206: checkcast 278	gnu/text/Char
    //   209: astore 60
    //   211: aload 60
    //   213: getstatic 686	gnu/kawa/slib/pregexp:Lit3	Lgnu/text/Char;
    //   216: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   219: istore 61
    //   221: iload 61
    //   223: ifeq +16 -> 239
    //   226: iload 61
    //   228: ifeq +7 -> 235
    //   231: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   234: areturn
    //   235: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   238: areturn
    //   239: aload_0
    //   240: checkcast 278	gnu/text/Char
    //   243: astore 63
    //   245: getstatic 951	gnu/kawa/slib/pregexp:$Stpregexp$Mntab$Mnchar$St	Ljava/lang/Object;
    //   248: astore 64
    //   250: aload 64
    //   252: checkcast 278	gnu/text/Char
    //   255: astore 66
    //   257: aload 63
    //   259: aload 66
    //   261: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   264: ifeq +7 -> 271
    //   267: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   270: areturn
    //   271: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   274: areturn
    //   275: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   278: aload_1
    //   279: getstatic 466	gnu/kawa/slib/pregexp:Lit89	Lgnu/mapping/SimpleSymbol;
    //   282: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   288: if_acmpeq +27 -> 315
    //   291: aload_0
    //   292: checkcast 278	gnu/text/Char
    //   295: astore 58
    //   297: aload 58
    //   299: invokestatic 949	kawa/lib/characters:char$To$Integer	(Lgnu/text/Char;)I
    //   302: bipush 32
    //   304: if_icmpge +7 -> 311
    //   307: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   310: areturn
    //   311: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   314: areturn
    //   315: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   318: aload_1
    //   319: getstatic 626	gnu/kawa/slib/pregexp:Lit30	Lgnu/mapping/SimpleSymbol;
    //   322: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   328: if_acmpeq +25 -> 353
    //   331: aload_0
    //   332: checkcast 278	gnu/text/Char
    //   335: astore 56
    //   337: aload 56
    //   339: invokestatic 929	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   342: ifeq +7 -> 349
    //   345: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   348: areturn
    //   349: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   352: areturn
    //   353: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   356: aload_1
    //   357: getstatic 462	gnu/kawa/slib/pregexp:Lit90	Lgnu/mapping/SimpleSymbol;
    //   360: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   366: if_acmpeq +68 -> 434
    //   369: aload_0
    //   370: checkcast 278	gnu/text/Char
    //   373: astore 51
    //   375: aload 51
    //   377: invokestatic 949	kawa/lib/characters:char$To$Integer	(Lgnu/text/Char;)I
    //   380: bipush 32
    //   382: if_icmplt +29 -> 411
    //   385: iconst_1
    //   386: istore 52
    //   388: iload 52
    //   390: ifeq +31 -> 421
    //   393: aload_0
    //   394: checkcast 278	gnu/text/Char
    //   397: astore 54
    //   399: aload 54
    //   401: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   404: ifeq +13 -> 417
    //   407: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   410: areturn
    //   411: iconst_0
    //   412: istore 52
    //   414: goto -26 -> 388
    //   417: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   420: areturn
    //   421: iload 52
    //   423: ifeq +7 -> 430
    //   426: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   429: areturn
    //   430: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   433: areturn
    //   434: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   437: aload_1
    //   438: getstatic 458	gnu/kawa/slib/pregexp:Lit91	Lgnu/mapping/SimpleSymbol;
    //   441: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   444: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   447: if_acmpeq +25 -> 472
    //   450: aload_0
    //   451: checkcast 278	gnu/text/Char
    //   454: astore 49
    //   456: aload 49
    //   458: invokestatic 957	kawa/lib/rnrs/unicode:isCharLowerCase	(Lgnu/text/Char;)Z
    //   461: ifeq +7 -> 468
    //   464: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   467: areturn
    //   468: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   471: areturn
    //   472: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   475: aload_1
    //   476: getstatic 454	gnu/kawa/slib/pregexp:Lit92	Lgnu/mapping/SimpleSymbol;
    //   479: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   482: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   485: if_acmpeq +27 -> 512
    //   488: aload_0
    //   489: checkcast 278	gnu/text/Char
    //   492: astore 47
    //   494: aload 47
    //   496: invokestatic 949	kawa/lib/characters:char$To$Integer	(Lgnu/text/Char;)I
    //   499: bipush 32
    //   501: if_icmplt +7 -> 508
    //   504: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   507: areturn
    //   508: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   511: areturn
    //   512: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   515: aload_1
    //   516: getstatic 450	gnu/kawa/slib/pregexp:Lit93	Lgnu/mapping/SimpleSymbol;
    //   519: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   522: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   525: if_acmpeq +138 -> 663
    //   528: aload_0
    //   529: checkcast 278	gnu/text/Char
    //   532: astore 36
    //   534: aload 36
    //   536: invokestatic 949	kawa/lib/characters:char$To$Integer	(Lgnu/text/Char;)I
    //   539: bipush 32
    //   541: if_icmplt +73 -> 614
    //   544: iconst_1
    //   545: istore 37
    //   547: iload 37
    //   549: ifeq +101 -> 650
    //   552: aload_0
    //   553: checkcast 278	gnu/text/Char
    //   556: astore 39
    //   558: iconst_1
    //   559: iconst_1
    //   560: aload 39
    //   562: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   565: iadd
    //   566: iand
    //   567: istore 40
    //   569: iload 40
    //   571: ifeq +66 -> 637
    //   574: aload_0
    //   575: checkcast 278	gnu/text/Char
    //   578: astore 42
    //   580: iconst_1
    //   581: iconst_1
    //   582: aload 42
    //   584: invokestatic 926	kawa/lib/rnrs/unicode:isCharAlphabetic	(Lgnu/text/Char;)Z
    //   587: iadd
    //   588: iand
    //   589: istore 43
    //   591: iload 43
    //   593: ifeq +31 -> 624
    //   596: aload_0
    //   597: checkcast 278	gnu/text/Char
    //   600: astore 45
    //   602: aload 45
    //   604: invokestatic 929	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   607: ifeq +13 -> 620
    //   610: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   613: areturn
    //   614: iconst_0
    //   615: istore 37
    //   617: goto -70 -> 547
    //   620: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   623: areturn
    //   624: iload 43
    //   626: ifeq +7 -> 633
    //   629: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   632: areturn
    //   633: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   636: areturn
    //   637: iload 40
    //   639: ifeq +7 -> 646
    //   642: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   645: areturn
    //   646: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   649: areturn
    //   650: iload 37
    //   652: ifeq +7 -> 659
    //   655: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   658: areturn
    //   659: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   662: areturn
    //   663: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   666: aload_1
    //   667: getstatic 610	gnu/kawa/slib/pregexp:Lit36	Lgnu/mapping/SimpleSymbol;
    //   670: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   673: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   676: if_acmpeq +25 -> 701
    //   679: aload_0
    //   680: checkcast 278	gnu/text/Char
    //   683: astore 34
    //   685: aload 34
    //   687: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   690: ifeq +7 -> 697
    //   693: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   696: areturn
    //   697: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   700: areturn
    //   701: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   704: aload_1
    //   705: getstatic 446	gnu/kawa/slib/pregexp:Lit94	Lgnu/mapping/SimpleSymbol;
    //   708: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   711: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   714: if_acmpeq +25 -> 739
    //   717: aload_0
    //   718: checkcast 278	gnu/text/Char
    //   721: astore 32
    //   723: aload 32
    //   725: invokestatic 960	kawa/lib/rnrs/unicode:isCharUpperCase	(Lgnu/text/Char;)Z
    //   728: ifeq +7 -> 735
    //   731: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   734: areturn
    //   735: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   738: areturn
    //   739: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   742: aload_1
    //   743: getstatic 596	gnu/kawa/slib/pregexp:Lit41	Lgnu/mapping/SimpleSymbol;
    //   746: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   749: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   752: if_acmpeq +90 -> 842
    //   755: aload_0
    //   756: checkcast 278	gnu/text/Char
    //   759: astore 24
    //   761: aload 24
    //   763: invokestatic 926	kawa/lib/rnrs/unicode:isCharAlphabetic	(Lgnu/text/Char;)Z
    //   766: istore 25
    //   768: iload 25
    //   770: ifeq +16 -> 786
    //   773: iload 25
    //   775: ifeq +7 -> 782
    //   778: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   781: areturn
    //   782: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   785: areturn
    //   786: aload_0
    //   787: checkcast 278	gnu/text/Char
    //   790: astore 27
    //   792: aload 27
    //   794: invokestatic 929	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   797: istore 28
    //   799: iload 28
    //   801: ifeq +16 -> 817
    //   804: iload 28
    //   806: ifeq +7 -> 813
    //   809: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   812: areturn
    //   813: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   816: areturn
    //   817: aload_0
    //   818: checkcast 278	gnu/text/Char
    //   821: astore 30
    //   823: aload 30
    //   825: getstatic 484	gnu/kawa/slib/pregexp:Lit84	Lgnu/text/Char;
    //   828: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   831: ifeq +7 -> 838
    //   834: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   837: areturn
    //   838: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   841: areturn
    //   842: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   845: aload_1
    //   846: getstatic 442	gnu/kawa/slib/pregexp:Lit95	Lgnu/mapping/SimpleSymbol;
    //   849: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   852: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   855: if_acmpeq +229 -> 1084
    //   858: aload_0
    //   859: checkcast 278	gnu/text/Char
    //   862: astore 4
    //   864: aload 4
    //   866: invokestatic 929	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   869: istore 5
    //   871: iload 5
    //   873: ifeq +16 -> 889
    //   876: iload 5
    //   878: ifeq +7 -> 885
    //   881: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   884: areturn
    //   885: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   888: areturn
    //   889: aload_0
    //   890: checkcast 278	gnu/text/Char
    //   893: astore 7
    //   895: aload 7
    //   897: getstatic 688	gnu/kawa/slib/pregexp:Lit2	Lgnu/text/Char;
    //   900: invokestatic 963	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   903: istore 8
    //   905: iload 8
    //   907: ifeq +16 -> 923
    //   910: iload 8
    //   912: ifeq +7 -> 919
    //   915: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   918: areturn
    //   919: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   922: areturn
    //   923: aload_0
    //   924: checkcast 278	gnu/text/Char
    //   927: astore 10
    //   929: aload 10
    //   931: getstatic 646	gnu/kawa/slib/pregexp:Lit25	Lgnu/text/Char;
    //   934: invokestatic 963	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   937: istore 11
    //   939: iload 11
    //   941: ifeq +16 -> 957
    //   944: iload 11
    //   946: ifeq +7 -> 953
    //   949: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   952: areturn
    //   953: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   956: areturn
    //   957: aload_0
    //   958: checkcast 278	gnu/text/Char
    //   961: astore 13
    //   963: aload 13
    //   965: getstatic 438	gnu/kawa/slib/pregexp:Lit96	Lgnu/text/Char;
    //   968: invokestatic 963	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   971: istore 14
    //   973: iload 14
    //   975: ifeq +16 -> 991
    //   978: iload 14
    //   980: ifeq +7 -> 987
    //   983: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   986: areturn
    //   987: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   990: areturn
    //   991: aload_0
    //   992: checkcast 278	gnu/text/Char
    //   995: astore 16
    //   997: aload 16
    //   999: getstatic 634	gnu/kawa/slib/pregexp:Lit29	Lgnu/text/Char;
    //   1002: invokestatic 963	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   1005: istore 17
    //   1007: iload 17
    //   1009: ifeq +16 -> 1025
    //   1012: iload 17
    //   1014: ifeq +7 -> 1021
    //   1017: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1020: areturn
    //   1021: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1024: areturn
    //   1025: aload_0
    //   1026: checkcast 278	gnu/text/Char
    //   1029: astore 19
    //   1031: aload 19
    //   1033: getstatic 436	gnu/kawa/slib/pregexp:Lit97	Lgnu/text/Char;
    //   1036: invokestatic 963	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   1039: istore 20
    //   1041: iload 20
    //   1043: ifeq +16 -> 1059
    //   1046: iload 20
    //   1048: ifeq +7 -> 1055
    //   1051: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1054: areturn
    //   1055: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1058: areturn
    //   1059: aload_0
    //   1060: checkcast 278	gnu/text/Char
    //   1063: astore 22
    //   1065: aload 22
    //   1067: getstatic 434	gnu/kawa/slib/pregexp:Lit98	Lgnu/text/Char;
    //   1070: invokestatic 963	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   1073: ifeq +7 -> 1080
    //   1076: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1079: areturn
    //   1080: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1083: areturn
    //   1084: iconst_1
    //   1085: anewarray 965	java/lang/Object
    //   1088: astore_2
    //   1089: aload_2
    //   1090: iconst_0
    //   1091: getstatic 432	gnu/kawa/slib/pregexp:Lit99	Lgnu/mapping/SimpleSymbol;
    //   1094: aastore
    //   1095: aload_2
    //   1096: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   1099: areturn
    //   1100: astore 76
    //   1102: new 911	gnu/mapping/WrongType
    //   1105: dup
    //   1106: aload 76
    //   1108: ldc_w 941
    //   1111: iconst_1
    //   1112: aload_0
    //   1113: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1116: athrow
    //   1117: astore 71
    //   1119: new 911	gnu/mapping/WrongType
    //   1122: dup
    //   1123: aload 71
    //   1125: ldc_w 937
    //   1128: iconst_1
    //   1129: aload_0
    //   1130: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1133: athrow
    //   1134: astore 74
    //   1136: new 911	gnu/mapping/WrongType
    //   1139: dup
    //   1140: aload 74
    //   1142: ldc_w 939
    //   1145: iconst_1
    //   1146: aload_0
    //   1147: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1150: athrow
    //   1151: astore 69
    //   1153: new 911	gnu/mapping/WrongType
    //   1156: dup
    //   1157: aload 69
    //   1159: ldc_w 937
    //   1162: iconst_1
    //   1163: aload_0
    //   1164: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1167: athrow
    //   1168: astore 67
    //   1170: new 911	gnu/mapping/WrongType
    //   1173: dup
    //   1174: aload 67
    //   1176: ldc_w 971
    //   1179: iconst_1
    //   1180: aload_0
    //   1181: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1184: athrow
    //   1185: astore 59
    //   1187: new 911	gnu/mapping/WrongType
    //   1190: dup
    //   1191: aload 59
    //   1193: ldc_w 941
    //   1196: iconst_1
    //   1197: aload_0
    //   1198: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1201: athrow
    //   1202: astore 62
    //   1204: new 911	gnu/mapping/WrongType
    //   1207: dup
    //   1208: aload 62
    //   1210: ldc_w 941
    //   1213: iconst_1
    //   1214: aload_0
    //   1215: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1218: athrow
    //   1219: astore 65
    //   1221: new 911	gnu/mapping/WrongType
    //   1224: dup
    //   1225: aload 65
    //   1227: ldc_w 941
    //   1230: iconst_2
    //   1231: aload 64
    //   1233: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1236: athrow
    //   1237: astore 57
    //   1239: new 911	gnu/mapping/WrongType
    //   1242: dup
    //   1243: aload 57
    //   1245: ldc_w 971
    //   1248: iconst_1
    //   1249: aload_0
    //   1250: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1253: athrow
    //   1254: astore 55
    //   1256: new 911	gnu/mapping/WrongType
    //   1259: dup
    //   1260: aload 55
    //   1262: ldc_w 939
    //   1265: iconst_1
    //   1266: aload_0
    //   1267: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1270: athrow
    //   1271: astore 50
    //   1273: new 911	gnu/mapping/WrongType
    //   1276: dup
    //   1277: aload 50
    //   1279: ldc_w 971
    //   1282: iconst_1
    //   1283: aload_0
    //   1284: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1287: athrow
    //   1288: astore 53
    //   1290: new 911	gnu/mapping/WrongType
    //   1293: dup
    //   1294: aload 53
    //   1296: ldc_w 973
    //   1299: iconst_1
    //   1300: aload_0
    //   1301: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1304: athrow
    //   1305: astore 48
    //   1307: new 911	gnu/mapping/WrongType
    //   1310: dup
    //   1311: aload 48
    //   1313: ldc_w 975
    //   1316: iconst_1
    //   1317: aload_0
    //   1318: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1321: athrow
    //   1322: astore 46
    //   1324: new 911	gnu/mapping/WrongType
    //   1327: dup
    //   1328: aload 46
    //   1330: ldc_w 971
    //   1333: iconst_1
    //   1334: aload_0
    //   1335: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1338: athrow
    //   1339: astore 35
    //   1341: new 911	gnu/mapping/WrongType
    //   1344: dup
    //   1345: aload 35
    //   1347: ldc_w 971
    //   1350: iconst_1
    //   1351: aload_0
    //   1352: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1355: athrow
    //   1356: astore 38
    //   1358: new 911	gnu/mapping/WrongType
    //   1361: dup
    //   1362: aload 38
    //   1364: ldc_w 973
    //   1367: iconst_1
    //   1368: aload_0
    //   1369: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1372: athrow
    //   1373: astore 41
    //   1375: new 911	gnu/mapping/WrongType
    //   1378: dup
    //   1379: aload 41
    //   1381: ldc_w 937
    //   1384: iconst_1
    //   1385: aload_0
    //   1386: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1389: athrow
    //   1390: astore 44
    //   1392: new 911	gnu/mapping/WrongType
    //   1395: dup
    //   1396: aload 44
    //   1398: ldc_w 939
    //   1401: iconst_1
    //   1402: aload_0
    //   1403: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1406: athrow
    //   1407: astore 33
    //   1409: new 911	gnu/mapping/WrongType
    //   1412: dup
    //   1413: aload 33
    //   1415: ldc_w 973
    //   1418: iconst_1
    //   1419: aload_0
    //   1420: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1423: athrow
    //   1424: astore 31
    //   1426: new 911	gnu/mapping/WrongType
    //   1429: dup
    //   1430: aload 31
    //   1432: ldc_w 977
    //   1435: iconst_1
    //   1436: aload_0
    //   1437: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1440: athrow
    //   1441: astore 23
    //   1443: new 911	gnu/mapping/WrongType
    //   1446: dup
    //   1447: aload 23
    //   1449: ldc_w 937
    //   1452: iconst_1
    //   1453: aload_0
    //   1454: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1457: athrow
    //   1458: astore 26
    //   1460: new 911	gnu/mapping/WrongType
    //   1463: dup
    //   1464: aload 26
    //   1466: ldc_w 939
    //   1469: iconst_1
    //   1470: aload_0
    //   1471: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1474: athrow
    //   1475: astore 29
    //   1477: new 911	gnu/mapping/WrongType
    //   1480: dup
    //   1481: aload 29
    //   1483: ldc_w 941
    //   1486: iconst_1
    //   1487: aload_0
    //   1488: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1491: athrow
    //   1492: astore_3
    //   1493: new 911	gnu/mapping/WrongType
    //   1496: dup
    //   1497: aload_3
    //   1498: ldc_w 939
    //   1501: iconst_1
    //   1502: aload_0
    //   1503: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1506: athrow
    //   1507: astore 6
    //   1509: new 911	gnu/mapping/WrongType
    //   1512: dup
    //   1513: aload 6
    //   1515: ldc_w 979
    //   1518: iconst_1
    //   1519: aload_0
    //   1520: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1523: athrow
    //   1524: astore 9
    //   1526: new 911	gnu/mapping/WrongType
    //   1529: dup
    //   1530: aload 9
    //   1532: ldc_w 979
    //   1535: iconst_1
    //   1536: aload_0
    //   1537: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1540: athrow
    //   1541: astore 12
    //   1543: new 911	gnu/mapping/WrongType
    //   1546: dup
    //   1547: aload 12
    //   1549: ldc_w 979
    //   1552: iconst_1
    //   1553: aload_0
    //   1554: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1557: athrow
    //   1558: astore 15
    //   1560: new 911	gnu/mapping/WrongType
    //   1563: dup
    //   1564: aload 15
    //   1566: ldc_w 979
    //   1569: iconst_1
    //   1570: aload_0
    //   1571: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1574: athrow
    //   1575: astore 18
    //   1577: new 911	gnu/mapping/WrongType
    //   1580: dup
    //   1581: aload 18
    //   1583: ldc_w 979
    //   1586: iconst_1
    //   1587: aload_0
    //   1588: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1591: athrow
    //   1592: astore 21
    //   1594: new 911	gnu/mapping/WrongType
    //   1597: dup
    //   1598: aload 21
    //   1600: ldc_w 979
    //   1603: iconst_1
    //   1604: aload_0
    //   1605: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1608: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   16	22	1100	java/lang/ClassCastException
    //   57	63	1117	java/lang/ClassCastException
    //   88	94	1134	java/lang/ClassCastException
    //   126	132	1151	java/lang/ClassCastException
    //   164	170	1168	java/lang/ClassCastException
    //   205	211	1185	java/lang/ClassCastException
    //   239	245	1202	java/lang/ClassCastException
    //   250	257	1219	java/lang/ClassCastException
    //   291	297	1237	java/lang/ClassCastException
    //   331	337	1254	java/lang/ClassCastException
    //   369	375	1271	java/lang/ClassCastException
    //   393	399	1288	java/lang/ClassCastException
    //   450	456	1305	java/lang/ClassCastException
    //   488	494	1322	java/lang/ClassCastException
    //   528	534	1339	java/lang/ClassCastException
    //   552	558	1356	java/lang/ClassCastException
    //   574	580	1373	java/lang/ClassCastException
    //   596	602	1390	java/lang/ClassCastException
    //   679	685	1407	java/lang/ClassCastException
    //   717	723	1424	java/lang/ClassCastException
    //   755	761	1441	java/lang/ClassCastException
    //   786	792	1458	java/lang/ClassCastException
    //   817	823	1475	java/lang/ClassCastException
    //   858	864	1492	java/lang/ClassCastException
    //   889	895	1507	java/lang/ClassCastException
    //   923	929	1524	java/lang/ClassCastException
    //   957	963	1541	java/lang/ClassCastException
    //   991	997	1558	java/lang/ClassCastException
    //   1025	1031	1575	java/lang/ClassCastException
    //   1059	1065	1592	java/lang/ClassCastException
  }

  public static Object lambda1sub(Object paramObject)
  {
    if (lists.isPair(paramObject))
    {
      Object localObject1 = lists.car.apply1(paramObject);
      Object localObject2 = lambda1sub(lists.cdr.apply1(paramObject));
      if (Scheme.isEqv.apply2(localObject1, Lit100) != Boolean.FALSE)
        return lists.cons(lists.cons(paramObject, Boolean.FALSE), localObject2);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = lambda1sub(localObject1);
      arrayOfObject[1] = localObject2;
      return append.append$V(arrayOfObject);
    }
    return LList.Empty;
  }

  public static Pair pregexp(Object paramObject)
  {
    $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
    SimpleSymbol localSimpleSymbol = Lit100;
    GenericProc localGenericProc = lists.car;
    IntNum localIntNum = Lit73;
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject;
      return LList.list2(localSimpleSymbol, localGenericProc.apply1(pregexpReadPattern(paramObject, localIntNum, Integer.valueOf(strings.stringLength(localCharSequence)))));
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "string-length", 1, paramObject);
    }
  }

  public static Object pregexpError$V(Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    ports.display("Error:");
    Object localObject1 = localLList;
    while (true)
    {
      if (localObject1 == LList.Empty)
      {
        ports.newline();
        return misc.error$V("pregexp-error", new Object[0]);
      }
      try
      {
        Pair localPair = (Pair)localObject1;
        Object localObject2 = localPair.getCar();
        ports.display(Lit3);
        ports.write(localObject2);
        localObject1 = localPair.getCdr();
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject1);
      }
    }
  }

  public static Object pregexpInvertCharList(Object paramObject)
  {
    Object localObject = lists.car.apply1(paramObject);
    try
    {
      Pair localPair = (Pair)localObject;
      lists.setCar$Ex(localPair, Lit79);
      return paramObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-car!", 1, localObject);
    }
  }

  public static Object pregexpListRef(Object paramObject1, Object paramObject2)
  {
    for (Object localObject = Lit73; ; localObject = AddOp.$Pl.apply2(localObject, Lit8))
    {
      if (lists.isNull(paramObject1))
        return Boolean.FALSE;
      if (Scheme.numEqu.apply2(localObject, paramObject2) != Boolean.FALSE)
        return lists.car.apply1(paramObject1);
      paramObject1 = lists.cdr.apply1(paramObject1);
    }
  }

  public static Object pregexpMakeBackrefList(Object paramObject)
  {
    return lambda1sub(paramObject);
  }

  // ERROR //
  public static Object pregexpMatch$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 1032	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: astore_3
    //   6: getstatic 1082	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   9: getstatic 830	gnu/kawa/slib/pregexp:pregexp$Mnmatch$Mnpositions	Lgnu/expr/ModuleMethod;
    //   12: aload_0
    //   13: aload_1
    //   14: aload_3
    //   15: invokevirtual 1086	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   18: astore 4
    //   20: aload 4
    //   22: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   25: if_acmpeq +139 -> 164
    //   28: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   31: astore 5
    //   33: aload 4
    //   35: astore 6
    //   37: aload 5
    //   39: astore 7
    //   41: aload 6
    //   43: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   46: if_acmpne +9 -> 55
    //   49: aload 7
    //   51: invokestatic 1090	gnu/lists/LList:reverseInPlace	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   54: areturn
    //   55: aload 6
    //   57: checkcast 1050	gnu/lists/Pair
    //   60: astore 9
    //   62: aload 9
    //   64: invokevirtual 1059	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   67: astore 10
    //   69: aload 9
    //   71: invokevirtual 1053	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   74: astore 11
    //   76: aload 11
    //   78: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   81: if_acmpeq +76 -> 157
    //   84: aload_1
    //   85: checkcast 888	java/lang/CharSequence
    //   88: astore 14
    //   90: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   93: aload 11
    //   95: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   98: astore 15
    //   100: aload 15
    //   102: checkcast 890	java/lang/Number
    //   105: invokevirtual 894	java/lang/Number:intValue	()I
    //   108: istore 17
    //   110: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   113: aload 11
    //   115: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: astore 18
    //   120: aload 18
    //   122: checkcast 890	java/lang/Number
    //   125: invokevirtual 894	java/lang/Number:intValue	()I
    //   128: istore 20
    //   130: aload 14
    //   132: iload 17
    //   134: iload 20
    //   136: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   139: astore 12
    //   141: aload 12
    //   143: aload 7
    //   145: invokestatic 1096	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   148: astore 7
    //   150: aload 10
    //   152: astore 6
    //   154: goto -113 -> 41
    //   157: aload 11
    //   159: astore 12
    //   161: goto -20 -> 141
    //   164: aload 4
    //   166: areturn
    //   167: astore 8
    //   169: new 911	gnu/mapping/WrongType
    //   172: dup
    //   173: aload 8
    //   175: ldc_w 1061
    //   178: bipush 254
    //   180: aload 6
    //   182: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   185: athrow
    //   186: astore 13
    //   188: new 911	gnu/mapping/WrongType
    //   191: dup
    //   192: aload 13
    //   194: ldc_w 1097
    //   197: iconst_1
    //   198: aload_1
    //   199: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   202: athrow
    //   203: astore 16
    //   205: new 911	gnu/mapping/WrongType
    //   208: dup
    //   209: aload 16
    //   211: ldc_w 1097
    //   214: iconst_2
    //   215: aload 15
    //   217: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   220: athrow
    //   221: astore 19
    //   223: new 911	gnu/mapping/WrongType
    //   226: dup
    //   227: aload 19
    //   229: ldc_w 1097
    //   232: iconst_3
    //   233: aload 18
    //   235: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   55	62	167	java/lang/ClassCastException
    //   84	90	186	java/lang/ClassCastException
    //   100	110	203	java/lang/ClassCastException
    //   120	130	221	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpMatchPositions$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 1032	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: astore_3
    //   6: aload_0
    //   7: invokestatic 1101	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   10: ifeq +111 -> 121
    //   13: aload_0
    //   14: invokestatic 1103	gnu/kawa/slib/pregexp:pregexp	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   17: astore_0
    //   18: aload_1
    //   19: checkcast 888	java/lang/CharSequence
    //   22: astore 7
    //   24: aload 7
    //   26: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   29: istore 8
    //   31: aload_3
    //   32: invokestatic 1072	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   35: ifeq +127 -> 162
    //   38: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   41: astore 9
    //   43: aload_3
    //   44: invokestatic 1072	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   47: ifeq +142 -> 189
    //   50: iload 8
    //   52: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: astore 12
    //   57: aload 9
    //   59: astore 13
    //   61: getstatic 1106	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   64: aload 13
    //   66: aload 12
    //   68: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: astore 14
    //   73: aload 14
    //   75: checkcast 371	java/lang/Boolean
    //   78: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   81: istore 16
    //   83: iload 16
    //   85: ifeq +132 -> 217
    //   88: iload 8
    //   90: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: astore 17
    //   95: aload_0
    //   96: aload_1
    //   97: aload 17
    //   99: aload 9
    //   101: aload 12
    //   103: aload 13
    //   105: invokestatic 1110	gnu/kawa/slib/pregexp:pregexpMatchPositionsAux	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: astore 18
    //   110: aload 18
    //   112: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   115: if_acmpeq +86 -> 201
    //   118: aload 18
    //   120: areturn
    //   121: aload_0
    //   122: invokestatic 986	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   125: ifne -107 -> 18
    //   128: iconst_3
    //   129: anewarray 965	java/lang/Object
    //   132: astore 4
    //   134: aload 4
    //   136: iconst_0
    //   137: getstatic 347	gnu/kawa/slib/pregexp:Lit114	Lgnu/mapping/SimpleSymbol;
    //   140: aastore
    //   141: aload 4
    //   143: iconst_1
    //   144: getstatic 343	gnu/kawa/slib/pregexp:Lit115	Lgnu/mapping/SimpleSymbol;
    //   147: aastore
    //   148: aload 4
    //   150: iconst_2
    //   151: aload_0
    //   152: aastore
    //   153: aload 4
    //   155: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   158: pop
    //   159: goto -141 -> 18
    //   162: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   165: aload_3
    //   166: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   169: astore 9
    //   171: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   174: aload_3
    //   175: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   178: astore 10
    //   180: aload 10
    //   182: checkcast 312	gnu/lists/LList
    //   185: astore_3
    //   186: goto -143 -> 43
    //   189: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   192: aload_3
    //   193: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   196: astore 12
    //   198: goto -141 -> 57
    //   201: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   204: aload 13
    //   206: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   209: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: astore 13
    //   214: goto -153 -> 61
    //   217: iload 16
    //   219: ifeq +7 -> 226
    //   222: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   225: areturn
    //   226: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   229: areturn
    //   230: astore 6
    //   232: new 911	gnu/mapping/WrongType
    //   235: dup
    //   236: aload 6
    //   238: ldc_w 1028
    //   241: iconst_1
    //   242: aload_1
    //   243: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: astore 11
    //   249: new 911	gnu/mapping/WrongType
    //   252: dup
    //   253: aload 11
    //   255: ldc_w 1112
    //   258: bipush 254
    //   260: aload 10
    //   262: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   265: athrow
    //   266: astore 15
    //   268: new 911	gnu/mapping/WrongType
    //   271: dup
    //   272: aload 15
    //   274: ldc_w 913
    //   277: bipush 254
    //   279: aload 14
    //   281: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   284: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   18	24	230	java/lang/ClassCastException
    //   180	186	247	java/lang/ClassCastException
    //   73	83	266	java/lang/ClassCastException
  }

  public static Object pregexpMatchPositionsAux(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    frame localframe = new frame();
    localframe.s = paramObject2;
    localframe.sn = paramObject3;
    localframe.start = paramObject4;
    localframe.n = paramObject5;
    Procedure localProcedure = localframe.identity;
    Object localObject1 = pregexpMakeBackrefList(paramObject1);
    localframe.case$Mnsensitive$Qu = Boolean.TRUE;
    localframe.backrefs = localObject1;
    localframe.identity = localProcedure;
    localframe.lambda3sub(paramObject1, paramObject6, localframe.identity, lambda$Fn1);
    Object localObject2 = localframe.backrefs;
    Object localObject3 = LList.Empty;
    while (true)
    {
      Object localObject5;
      if (localObject2 == LList.Empty)
      {
        LList localLList = LList.reverseInPlace(localObject3);
        localObject5 = lists.car.apply1(localLList);
        if (localObject5 == Boolean.FALSE)
          break label173;
        return localLList;
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject4 = localPair.getCdr();
        localObject3 = Pair.make(lists.cdr.apply1(localPair.getCar()), localObject3);
        localObject2 = localObject4;
        continue;
        label173: return localObject5;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }

  // ERROR //
  public static Object pregexpQuote(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 888	java/lang/CharSequence
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   9: iconst_1
    //   10: isub
    //   11: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   14: astore_3
    //   15: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   18: astore 4
    //   20: getstatic 1145	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   23: aload_3
    //   24: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   27: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   33: if_acmpeq +16 -> 49
    //   36: aload 4
    //   38: checkcast 312	gnu/lists/LList
    //   41: astore 13
    //   43: aload 13
    //   45: invokestatic 1149	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   48: areturn
    //   49: getstatic 906	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   52: aload_3
    //   53: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   56: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore 5
    //   61: aload_0
    //   62: checkcast 888	java/lang/CharSequence
    //   65: astore 7
    //   67: aload_3
    //   68: checkcast 890	java/lang/Number
    //   71: invokevirtual 894	java/lang/Number:intValue	()I
    //   74: istore 9
    //   76: aload 7
    //   78: iload 9
    //   80: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   83: istore 10
    //   85: iload 10
    //   87: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   90: getstatic 339	gnu/kawa/slib/pregexp:Lit116	Lgnu/lists/PairWithPosition;
    //   93: invokestatic 1152	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   96: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   99: if_acmpeq +31 -> 130
    //   102: getstatic 284	gnu/kawa/slib/pregexp:Lit19	Lgnu/text/Char;
    //   105: iload 10
    //   107: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   110: aload 4
    //   112: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   115: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   118: astore 11
    //   120: aload 11
    //   122: astore 4
    //   124: aload 5
    //   126: astore_3
    //   127: goto -107 -> 20
    //   130: iload 10
    //   132: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   135: aload 4
    //   137: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   140: astore 11
    //   142: goto -22 -> 120
    //   145: astore_1
    //   146: new 911	gnu/mapping/WrongType
    //   149: dup
    //   150: aload_1
    //   151: ldc_w 1028
    //   154: iconst_1
    //   155: aload_0
    //   156: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    //   160: astore 12
    //   162: new 911	gnu/mapping/WrongType
    //   165: dup
    //   166: aload 12
    //   168: ldc_w 1154
    //   171: iconst_1
    //   172: aload 4
    //   174: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   177: athrow
    //   178: astore 6
    //   180: new 911	gnu/mapping/WrongType
    //   183: dup
    //   184: aload 6
    //   186: ldc_w 918
    //   189: iconst_1
    //   190: aload_0
    //   191: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   194: athrow
    //   195: astore 8
    //   197: new 911	gnu/mapping/WrongType
    //   200: dup
    //   201: aload 8
    //   203: ldc_w 918
    //   206: iconst_2
    //   207: aload_3
    //   208: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   211: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	145	java/lang/ClassCastException
    //   36	43	160	java/lang/ClassCastException
    //   61	67	178	java/lang/ClassCastException
    //   67	76	195	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReadBranch(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   3: astore_3
    //   4: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   7: aload_1
    //   8: aload_2
    //   9: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   12: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   15: if_acmpeq +18 -> 33
    //   18: getstatic 680	gnu/kawa/slib/pregexp:Lit5	Lgnu/mapping/SimpleSymbol;
    //   21: aload_3
    //   22: invokestatic 1158	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   28: aload_1
    //   29: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   32: areturn
    //   33: aload_0
    //   34: checkcast 888	java/lang/CharSequence
    //   37: astore 5
    //   39: aload_1
    //   40: checkcast 890	java/lang/Number
    //   43: invokevirtual 894	java/lang/Number:intValue	()I
    //   46: istore 7
    //   48: aload 5
    //   50: iload 7
    //   52: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   55: istore 8
    //   57: iload 8
    //   59: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   62: getstatic 294	gnu/kawa/slib/pregexp:Lit7	Lgnu/text/Char;
    //   65: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   68: istore 9
    //   70: iload 9
    //   72: ifeq +23 -> 95
    //   75: iload 9
    //   77: ifeq +32 -> 109
    //   80: getstatic 680	gnu/kawa/slib/pregexp:Lit5	Lgnu/mapping/SimpleSymbol;
    //   83: aload_3
    //   84: invokestatic 1158	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   90: aload_1
    //   91: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   94: areturn
    //   95: iload 8
    //   97: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   100: getstatic 310	gnu/kawa/slib/pregexp:Lit6	Lgnu/text/Char;
    //   103: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   106: ifne -26 -> 80
    //   109: aload_0
    //   110: aload_1
    //   111: aload_2
    //   112: invokestatic 1161	gnu/kawa/slib/pregexp:pregexpReadPiece	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: astore 10
    //   117: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   120: aload 10
    //   122: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   125: aload_3
    //   126: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   129: astore_3
    //   130: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   133: aload 10
    //   135: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: astore_1
    //   139: goto -135 -> 4
    //   142: astore 4
    //   144: new 911	gnu/mapping/WrongType
    //   147: dup
    //   148: aload 4
    //   150: ldc_w 918
    //   153: iconst_1
    //   154: aload_0
    //   155: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   158: athrow
    //   159: astore 6
    //   161: new 911	gnu/mapping/WrongType
    //   164: dup
    //   165: aload 6
    //   167: ldc_w 918
    //   170: iconst_2
    //   171: aload_1
    //   172: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   175: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   33	39	142	java/lang/ClassCastException
    //   39	48	159	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReadCharList(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   3: astore_3
    //   4: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   7: aload_1
    //   8: aload_2
    //   9: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   12: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   15: if_acmpeq +29 -> 44
    //   18: iconst_2
    //   19: anewarray 965	java/lang/Object
    //   22: astore 41
    //   24: aload 41
    //   26: iconst_0
    //   27: getstatic 500	gnu/kawa/slib/pregexp:Lit80	Lgnu/mapping/SimpleSymbol;
    //   30: aastore
    //   31: aload 41
    //   33: iconst_1
    //   34: getstatic 496	gnu/kawa/slib/pregexp:Lit81	Lgnu/mapping/SimpleSymbol;
    //   37: aastore
    //   38: aload 41
    //   40: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   43: areturn
    //   44: aload_0
    //   45: checkcast 888	java/lang/CharSequence
    //   48: astore 5
    //   50: aload_1
    //   51: checkcast 890	java/lang/Number
    //   54: invokevirtual 894	java/lang/Number:intValue	()I
    //   57: istore 7
    //   59: aload 5
    //   61: iload 7
    //   63: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   66: istore 8
    //   68: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   71: iload 8
    //   73: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   76: getstatic 302	gnu/kawa/slib/pregexp:Lit46	Lgnu/text/Char;
    //   79: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   82: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   85: if_acmpeq +62 -> 147
    //   88: aload_3
    //   89: invokestatic 1072	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   92: ifeq +31 -> 123
    //   95: iload 8
    //   97: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   100: aload_3
    //   101: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   104: astore 40
    //   106: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   109: aload_1
    //   110: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   113: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   116: astore_1
    //   117: aload 40
    //   119: astore_3
    //   120: goto -116 -> 4
    //   123: getstatic 492	gnu/kawa/slib/pregexp:Lit82	Lgnu/mapping/SimpleSymbol;
    //   126: aload_3
    //   127: invokestatic 1158	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   133: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   136: aload_1
    //   137: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   140: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   146: areturn
    //   147: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   150: iload 8
    //   152: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   155: getstatic 284	gnu/kawa/slib/pregexp:Lit19	Lgnu/text/Char;
    //   158: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   164: if_acmpeq +74 -> 238
    //   167: aload_0
    //   168: aload_1
    //   169: aload_2
    //   170: invokestatic 1168	gnu/kawa/slib/pregexp:pregexpReadEscapedChar	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: astore 37
    //   175: aload 37
    //   177: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   180: if_acmpeq +32 -> 212
    //   183: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   186: aload 37
    //   188: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   191: aload_3
    //   192: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   195: astore 39
    //   197: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   200: aload 37
    //   202: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   205: astore_1
    //   206: aload 39
    //   208: astore_3
    //   209: goto -205 -> 4
    //   212: iconst_2
    //   213: anewarray 965	java/lang/Object
    //   216: astore 38
    //   218: aload 38
    //   220: iconst_0
    //   221: getstatic 500	gnu/kawa/slib/pregexp:Lit80	Lgnu/mapping/SimpleSymbol;
    //   224: aastore
    //   225: aload 38
    //   227: iconst_1
    //   228: getstatic 656	gnu/kawa/slib/pregexp:Lit22	Lgnu/mapping/SimpleSymbol;
    //   231: aastore
    //   232: aload 38
    //   234: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   237: areturn
    //   238: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   241: iload 8
    //   243: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   246: getstatic 555	gnu/kawa/slib/pregexp:Lit58	Lgnu/text/Char;
    //   249: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   255: if_acmpeq +252 -> 507
    //   258: aload_3
    //   259: invokestatic 1072	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   262: istore 18
    //   264: iload 18
    //   266: ifeq +36 -> 302
    //   269: iload 18
    //   271: ifeq +104 -> 375
    //   274: iload 8
    //   276: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   279: aload_3
    //   280: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   283: astore 23
    //   285: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   288: aload_1
    //   289: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   292: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   295: astore_1
    //   296: aload 23
    //   298: astore_3
    //   299: goto -295 -> 4
    //   302: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   305: aload_1
    //   306: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   309: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   312: astore 19
    //   314: getstatic 1145	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   317: aload 19
    //   319: aload_2
    //   320: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   323: astore 20
    //   325: aload 20
    //   327: checkcast 371	java/lang/Boolean
    //   330: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   333: istore 22
    //   335: iload 22
    //   337: ifeq +134 -> 471
    //   340: aload_0
    //   341: checkcast 888	java/lang/CharSequence
    //   344: astore 34
    //   346: aload 19
    //   348: checkcast 890	java/lang/Number
    //   351: invokevirtual 894	java/lang/Number:intValue	()I
    //   354: istore 36
    //   356: aload 34
    //   358: iload 36
    //   360: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   363: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   366: getstatic 302	gnu/kawa/slib/pregexp:Lit46	Lgnu/text/Char;
    //   369: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   372: ifne -98 -> 274
    //   375: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   378: aload_3
    //   379: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   382: astore 24
    //   384: aload 24
    //   386: invokestatic 1171	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
    //   389: ifeq +90 -> 479
    //   392: getstatic 488	gnu/kawa/slib/pregexp:Lit83	Lgnu/mapping/SimpleSymbol;
    //   395: astore 26
    //   397: aload_0
    //   398: checkcast 888	java/lang/CharSequence
    //   401: astore 28
    //   403: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   406: aload_1
    //   407: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   410: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   413: astore 29
    //   415: aload 29
    //   417: checkcast 890	java/lang/Number
    //   420: invokevirtual 894	java/lang/Number:intValue	()I
    //   423: istore 31
    //   425: aload 26
    //   427: aload 24
    //   429: aload 28
    //   431: iload 31
    //   433: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   436: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   439: invokestatic 1175	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   442: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   445: aload_3
    //   446: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   449: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   452: astore 32
    //   454: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   457: aload_1
    //   458: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   461: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   464: astore_1
    //   465: aload 32
    //   467: astore_3
    //   468: goto -464 -> 4
    //   471: iload 22
    //   473: ifeq -98 -> 375
    //   476: goto -202 -> 274
    //   479: iload 8
    //   481: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   484: aload_3
    //   485: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   488: astore 25
    //   490: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   493: aload_1
    //   494: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   497: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   500: astore_1
    //   501: aload 25
    //   503: astore_3
    //   504: goto -500 -> 4
    //   507: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   510: iload 8
    //   512: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   515: getstatic 300	gnu/kawa/slib/pregexp:Lit15	Lgnu/text/Char;
    //   518: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   521: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   524: if_acmpeq +124 -> 648
    //   527: aload_0
    //   528: checkcast 888	java/lang/CharSequence
    //   531: astore 11
    //   533: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   536: aload_1
    //   537: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   540: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   543: astore 12
    //   545: aload 12
    //   547: checkcast 890	java/lang/Number
    //   550: invokevirtual 894	java/lang/Number:intValue	()I
    //   553: istore 14
    //   555: aload 11
    //   557: iload 14
    //   559: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   562: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   565: getstatic 588	gnu/kawa/slib/pregexp:Lit44	Lgnu/text/Char;
    //   568: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   571: ifeq +49 -> 620
    //   574: aload_0
    //   575: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   578: aload_1
    //   579: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   582: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   585: aload_2
    //   586: invokestatic 1178	gnu/kawa/slib/pregexp:pregexpReadPosixCharClass	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   589: astore 16
    //   591: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   594: aload 16
    //   596: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   599: aload_3
    //   600: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   603: astore 17
    //   605: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   608: aload 16
    //   610: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   613: astore_1
    //   614: aload 17
    //   616: astore_3
    //   617: goto -613 -> 4
    //   620: iload 8
    //   622: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   625: aload_3
    //   626: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   629: astore 15
    //   631: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   634: aload_1
    //   635: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   638: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   641: astore_1
    //   642: aload 15
    //   644: astore_3
    //   645: goto -641 -> 4
    //   648: iload 8
    //   650: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   653: aload_3
    //   654: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   657: astore 9
    //   659: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   662: aload_1
    //   663: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   666: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   669: astore_1
    //   670: aload 9
    //   672: astore_3
    //   673: goto -669 -> 4
    //   676: astore 4
    //   678: new 911	gnu/mapping/WrongType
    //   681: dup
    //   682: aload 4
    //   684: ldc_w 918
    //   687: iconst_1
    //   688: aload_0
    //   689: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   692: athrow
    //   693: astore 6
    //   695: new 911	gnu/mapping/WrongType
    //   698: dup
    //   699: aload 6
    //   701: ldc_w 918
    //   704: iconst_2
    //   705: aload_1
    //   706: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   709: athrow
    //   710: astore 21
    //   712: new 911	gnu/mapping/WrongType
    //   715: dup
    //   716: aload 21
    //   718: ldc_w 913
    //   721: bipush 254
    //   723: aload 20
    //   725: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   728: athrow
    //   729: astore 33
    //   731: new 911	gnu/mapping/WrongType
    //   734: dup
    //   735: aload 33
    //   737: ldc_w 918
    //   740: iconst_1
    //   741: aload_0
    //   742: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   745: athrow
    //   746: astore 35
    //   748: new 911	gnu/mapping/WrongType
    //   751: dup
    //   752: aload 35
    //   754: ldc_w 918
    //   757: iconst_2
    //   758: aload 19
    //   760: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   763: athrow
    //   764: astore 27
    //   766: new 911	gnu/mapping/WrongType
    //   769: dup
    //   770: aload 27
    //   772: ldc_w 918
    //   775: iconst_1
    //   776: aload_0
    //   777: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   780: athrow
    //   781: astore 30
    //   783: new 911	gnu/mapping/WrongType
    //   786: dup
    //   787: aload 30
    //   789: ldc_w 918
    //   792: iconst_2
    //   793: aload 29
    //   795: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   798: athrow
    //   799: astore 10
    //   801: new 911	gnu/mapping/WrongType
    //   804: dup
    //   805: aload 10
    //   807: ldc_w 918
    //   810: iconst_1
    //   811: aload_0
    //   812: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   815: athrow
    //   816: astore 13
    //   818: new 911	gnu/mapping/WrongType
    //   821: dup
    //   822: aload 13
    //   824: ldc_w 918
    //   827: iconst_2
    //   828: aload 12
    //   830: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   833: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   44	50	676	java/lang/ClassCastException
    //   50	59	693	java/lang/ClassCastException
    //   325	335	710	java/lang/ClassCastException
    //   340	346	729	java/lang/ClassCastException
    //   346	356	746	java/lang/ClassCastException
    //   397	403	764	java/lang/ClassCastException
    //   415	425	781	java/lang/ClassCastException
    //   527	533	799	java/lang/ClassCastException
    //   545	555	816	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReadClusterType(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 888	java/lang/CharSequence
    //   4: astore 4
    //   6: aload_1
    //   7: checkcast 890	java/lang/Number
    //   10: invokevirtual 894	java/lang/Number:intValue	()I
    //   13: istore 6
    //   15: aload 4
    //   17: iload 6
    //   19: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   22: istore 7
    //   24: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   27: iload 7
    //   29: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   32: getstatic 288	gnu/kawa/slib/pregexp:Lit47	Lgnu/text/Char;
    //   35: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   41: if_acmpeq +596 -> 637
    //   44: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   47: aload_1
    //   48: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   51: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: astore 8
    //   56: aload_0
    //   57: checkcast 888	java/lang/CharSequence
    //   60: astore 10
    //   62: aload 8
    //   64: checkcast 890	java/lang/Number
    //   67: invokevirtual 894	java/lang/Number:intValue	()I
    //   70: istore 12
    //   72: aload 10
    //   74: iload 12
    //   76: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   79: istore 13
    //   81: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   84: iload 13
    //   86: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   89: getstatic 588	gnu/kawa/slib/pregexp:Lit44	Lgnu/text/Char;
    //   92: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   98: if_acmpeq +21 -> 119
    //   101: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   104: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   107: aload 8
    //   109: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   112: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   118: areturn
    //   119: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   122: iload 13
    //   124: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   127: getstatic 582	gnu/kawa/slib/pregexp:Lit48	Lgnu/text/Char;
    //   130: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   136: if_acmpeq +21 -> 157
    //   139: getstatic 580	gnu/kawa/slib/pregexp:Lit49	Lgnu/lists/PairWithPosition;
    //   142: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   145: aload 8
    //   147: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   150: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   153: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   156: areturn
    //   157: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   160: iload 13
    //   162: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   165: getstatic 577	gnu/kawa/slib/pregexp:Lit50	Lgnu/text/Char;
    //   168: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   174: if_acmpeq +21 -> 195
    //   177: getstatic 575	gnu/kawa/slib/pregexp:Lit51	Lgnu/lists/PairWithPosition;
    //   180: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   183: aload 8
    //   185: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   188: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   194: areturn
    //   195: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   198: iload 13
    //   200: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   203: getstatic 572	gnu/kawa/slib/pregexp:Lit52	Lgnu/text/Char;
    //   206: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   209: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   212: if_acmpeq +21 -> 233
    //   215: getstatic 570	gnu/kawa/slib/pregexp:Lit53	Lgnu/lists/PairWithPosition;
    //   218: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   221: aload 8
    //   223: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   226: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   232: areturn
    //   233: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   236: iload 13
    //   238: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   241: getstatic 567	gnu/kawa/slib/pregexp:Lit54	Lgnu/text/Char;
    //   244: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   247: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   250: if_acmpeq +134 -> 384
    //   253: aload_0
    //   254: checkcast 888	java/lang/CharSequence
    //   257: astore 25
    //   259: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   262: aload 8
    //   264: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   267: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   270: astore 26
    //   272: aload 26
    //   274: checkcast 890	java/lang/Number
    //   277: invokevirtual 894	java/lang/Number:intValue	()I
    //   280: istore 28
    //   282: aload 25
    //   284: iload 28
    //   286: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   289: istore 29
    //   291: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   294: iload 29
    //   296: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   299: getstatic 582	gnu/kawa/slib/pregexp:Lit48	Lgnu/text/Char;
    //   302: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   308: if_acmpeq +25 -> 333
    //   311: getstatic 565	gnu/kawa/slib/pregexp:Lit55	Lgnu/lists/PairWithPosition;
    //   314: astore 31
    //   316: aload 31
    //   318: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   321: aload 8
    //   323: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   326: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   329: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   332: areturn
    //   333: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   336: iload 29
    //   338: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   341: getstatic 577	gnu/kawa/slib/pregexp:Lit50	Lgnu/text/Char;
    //   344: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   350: if_acmpeq +11 -> 361
    //   353: getstatic 562	gnu/kawa/slib/pregexp:Lit56	Lgnu/lists/PairWithPosition;
    //   356: astore 31
    //   358: goto -42 -> 316
    //   361: iconst_1
    //   362: anewarray 965	java/lang/Object
    //   365: astore 30
    //   367: aload 30
    //   369: iconst_0
    //   370: getstatic 559	gnu/kawa/slib/pregexp:Lit57	Lgnu/mapping/SimpleSymbol;
    //   373: aastore
    //   374: aload 30
    //   376: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   379: astore 31
    //   381: goto -65 -> 316
    //   384: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   387: astore 14
    //   389: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   392: astore 15
    //   394: aload 14
    //   396: astore 16
    //   398: aload_0
    //   399: checkcast 888	java/lang/CharSequence
    //   402: astore 18
    //   404: aload 8
    //   406: checkcast 890	java/lang/Number
    //   409: invokevirtual 894	java/lang/Number:intValue	()I
    //   412: istore 20
    //   414: aload 18
    //   416: iload 20
    //   418: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   421: istore 21
    //   423: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   426: iload 21
    //   428: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   431: getstatic 555	gnu/kawa/slib/pregexp:Lit58	Lgnu/text/Char;
    //   434: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   437: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   440: if_acmpeq +24 -> 464
    //   443: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   446: aload 8
    //   448: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   451: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   454: astore 8
    //   456: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   459: astore 15
    //   461: goto -63 -> 398
    //   464: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   467: iload 21
    //   469: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   472: getstatic 553	gnu/kawa/slib/pregexp:Lit59	Lgnu/text/Char;
    //   475: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   478: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   481: if_acmpeq +54 -> 535
    //   484: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   487: aload 8
    //   489: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   492: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   495: astore 8
    //   497: aload 15
    //   499: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   502: if_acmpeq +25 -> 527
    //   505: getstatic 551	gnu/kawa/slib/pregexp:Lit60	Lgnu/mapping/SimpleSymbol;
    //   508: astore 23
    //   510: aload 23
    //   512: aload 16
    //   514: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   517: astore 16
    //   519: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   522: astore 15
    //   524: goto -126 -> 398
    //   527: getstatic 547	gnu/kawa/slib/pregexp:Lit61	Lgnu/mapping/SimpleSymbol;
    //   530: astore 23
    //   532: goto -22 -> 510
    //   535: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   538: iload 21
    //   540: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   543: getstatic 543	gnu/kawa/slib/pregexp:Lit62	Lgnu/text/Char;
    //   546: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   549: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   552: if_acmpeq +29 -> 581
    //   555: aload 15
    //   557: putstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   560: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   563: aload 8
    //   565: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   568: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   571: astore 8
    //   573: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   576: astore 15
    //   578: goto -180 -> 398
    //   581: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   584: iload 21
    //   586: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   589: getstatic 588	gnu/kawa/slib/pregexp:Lit44	Lgnu/text/Char;
    //   592: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   595: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   598: if_acmpeq +20 -> 618
    //   601: aload 16
    //   603: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   606: aload 8
    //   608: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   611: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   614: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   617: areturn
    //   618: iconst_1
    //   619: anewarray 965	java/lang/Object
    //   622: astore 22
    //   624: aload 22
    //   626: iconst_0
    //   627: getstatic 559	gnu/kawa/slib/pregexp:Lit57	Lgnu/mapping/SimpleSymbol;
    //   630: aastore
    //   631: aload 22
    //   633: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   636: areturn
    //   637: getstatic 541	gnu/kawa/slib/pregexp:Lit63	Lgnu/lists/PairWithPosition;
    //   640: aload_1
    //   641: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   644: areturn
    //   645: astore_3
    //   646: new 911	gnu/mapping/WrongType
    //   649: dup
    //   650: aload_3
    //   651: ldc_w 918
    //   654: iconst_1
    //   655: aload_0
    //   656: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   659: athrow
    //   660: astore 5
    //   662: new 911	gnu/mapping/WrongType
    //   665: dup
    //   666: aload 5
    //   668: ldc_w 918
    //   671: iconst_2
    //   672: aload_1
    //   673: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   676: athrow
    //   677: astore 9
    //   679: new 911	gnu/mapping/WrongType
    //   682: dup
    //   683: aload 9
    //   685: ldc_w 918
    //   688: iconst_1
    //   689: aload_0
    //   690: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   693: athrow
    //   694: astore 11
    //   696: new 911	gnu/mapping/WrongType
    //   699: dup
    //   700: aload 11
    //   702: ldc_w 918
    //   705: iconst_2
    //   706: aload 8
    //   708: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   711: athrow
    //   712: astore 24
    //   714: new 911	gnu/mapping/WrongType
    //   717: dup
    //   718: aload 24
    //   720: ldc_w 918
    //   723: iconst_1
    //   724: aload_0
    //   725: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   728: athrow
    //   729: astore 27
    //   731: new 911	gnu/mapping/WrongType
    //   734: dup
    //   735: aload 27
    //   737: ldc_w 918
    //   740: iconst_2
    //   741: aload 26
    //   743: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   746: athrow
    //   747: astore 17
    //   749: new 911	gnu/mapping/WrongType
    //   752: dup
    //   753: aload 17
    //   755: ldc_w 918
    //   758: iconst_1
    //   759: aload_0
    //   760: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   763: athrow
    //   764: astore 19
    //   766: new 911	gnu/mapping/WrongType
    //   769: dup
    //   770: aload 19
    //   772: ldc_w 918
    //   775: iconst_2
    //   776: aload 8
    //   778: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   781: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	645	java/lang/ClassCastException
    //   6	15	660	java/lang/ClassCastException
    //   56	62	677	java/lang/ClassCastException
    //   62	72	694	java/lang/ClassCastException
    //   253	259	712	java/lang/ClassCastException
    //   272	282	729	java/lang/ClassCastException
    //   398	404	747	java/lang/ClassCastException
    //   404	414	764	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReadEscapedChar(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 1145	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   3: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   6: aload_1
    //   7: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   10: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: aload_2
    //   14: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore_3
    //   18: aload_3
    //   19: checkcast 371	java/lang/Boolean
    //   22: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   25: istore 5
    //   27: iload 5
    //   29: ifeq +466 -> 495
    //   32: aload_0
    //   33: checkcast 888	java/lang/CharSequence
    //   36: astore 7
    //   38: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   41: aload_1
    //   42: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   45: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   48: astore 8
    //   50: aload 8
    //   52: checkcast 890	java/lang/Number
    //   55: invokevirtual 894	java/lang/Number:intValue	()I
    //   58: istore 10
    //   60: aload 7
    //   62: iload 10
    //   64: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   67: istore 11
    //   69: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   72: iload 11
    //   74: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   77: getstatic 646	gnu/kawa/slib/pregexp:Lit25	Lgnu/text/Char;
    //   80: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   86: if_acmpeq +20 -> 106
    //   89: getstatic 644	gnu/kawa/slib/pregexp:Lit26	Lgnu/mapping/SimpleSymbol;
    //   92: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   95: aload_1
    //   96: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   99: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   105: areturn
    //   106: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   109: iload 11
    //   111: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   114: getstatic 640	gnu/kawa/slib/pregexp:Lit27	Lgnu/text/Char;
    //   117: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   123: if_acmpeq +20 -> 143
    //   126: getstatic 638	gnu/kawa/slib/pregexp:Lit28	Lgnu/mapping/SimpleSymbol;
    //   129: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   132: aload_1
    //   133: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   136: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   142: areturn
    //   143: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   146: iload 11
    //   148: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   151: getstatic 634	gnu/kawa/slib/pregexp:Lit29	Lgnu/text/Char;
    //   154: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   160: if_acmpeq +20 -> 180
    //   163: getstatic 626	gnu/kawa/slib/pregexp:Lit30	Lgnu/mapping/SimpleSymbol;
    //   166: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   169: aload_1
    //   170: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   173: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   176: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   179: areturn
    //   180: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   183: iload 11
    //   185: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   188: getstatic 632	gnu/kawa/slib/pregexp:Lit31	Lgnu/text/Char;
    //   191: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   197: if_acmpeq +20 -> 217
    //   200: getstatic 630	gnu/kawa/slib/pregexp:Lit32	Lgnu/lists/PairWithPosition;
    //   203: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   206: aload_1
    //   207: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   210: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   213: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   216: areturn
    //   217: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   220: iload 11
    //   222: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   225: getstatic 622	gnu/kawa/slib/pregexp:Lit33	Lgnu/text/Char;
    //   228: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   234: if_acmpeq +20 -> 254
    //   237: getstatic 648	gnu/kawa/slib/pregexp:Lit24	Lgnu/text/Char;
    //   240: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   243: aload_1
    //   244: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   247: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   253: areturn
    //   254: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   257: iload 11
    //   259: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   262: getstatic 620	gnu/kawa/slib/pregexp:Lit34	Lgnu/text/Char;
    //   265: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   268: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   271: if_acmpeq +20 -> 291
    //   274: getstatic 1181	gnu/kawa/slib/pregexp:$Stpregexp$Mnreturn$Mnchar$St	Ljava/lang/Object;
    //   277: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   280: aload_1
    //   281: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   284: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   287: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   290: areturn
    //   291: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   294: iload 11
    //   296: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   299: getstatic 618	gnu/kawa/slib/pregexp:Lit35	Lgnu/text/Char;
    //   302: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   308: if_acmpeq +20 -> 328
    //   311: getstatic 610	gnu/kawa/slib/pregexp:Lit36	Lgnu/mapping/SimpleSymbol;
    //   314: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   317: aload_1
    //   318: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   321: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   324: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   327: areturn
    //   328: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   331: iload 11
    //   333: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   336: getstatic 616	gnu/kawa/slib/pregexp:Lit37	Lgnu/text/Char;
    //   339: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   342: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   345: if_acmpeq +20 -> 365
    //   348: getstatic 614	gnu/kawa/slib/pregexp:Lit38	Lgnu/lists/PairWithPosition;
    //   351: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   354: aload_1
    //   355: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   358: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   361: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   364: areturn
    //   365: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   368: iload 11
    //   370: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   373: getstatic 606	gnu/kawa/slib/pregexp:Lit39	Lgnu/text/Char;
    //   376: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   379: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   382: if_acmpeq +20 -> 402
    //   385: getstatic 951	gnu/kawa/slib/pregexp:$Stpregexp$Mntab$Mnchar$St	Ljava/lang/Object;
    //   388: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   391: aload_1
    //   392: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   395: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   398: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   401: areturn
    //   402: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   405: iload 11
    //   407: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   410: getstatic 604	gnu/kawa/slib/pregexp:Lit40	Lgnu/text/Char;
    //   413: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   416: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   419: if_acmpeq +20 -> 439
    //   422: getstatic 596	gnu/kawa/slib/pregexp:Lit41	Lgnu/mapping/SimpleSymbol;
    //   425: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   428: aload_1
    //   429: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   432: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   435: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   438: areturn
    //   439: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   442: iload 11
    //   444: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   447: getstatic 602	gnu/kawa/slib/pregexp:Lit42	Lgnu/text/Char;
    //   450: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   453: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   456: if_acmpeq +20 -> 476
    //   459: getstatic 600	gnu/kawa/slib/pregexp:Lit43	Lgnu/lists/PairWithPosition;
    //   462: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   465: aload_1
    //   466: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   469: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   472: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   475: areturn
    //   476: iload 11
    //   478: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   481: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   484: aload_1
    //   485: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   488: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   491: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   494: areturn
    //   495: iload 5
    //   497: ifeq +7 -> 504
    //   500: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   503: areturn
    //   504: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   507: areturn
    //   508: astore 4
    //   510: new 911	gnu/mapping/WrongType
    //   513: dup
    //   514: aload 4
    //   516: ldc_w 913
    //   519: bipush 254
    //   521: aload_3
    //   522: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   525: athrow
    //   526: astore 6
    //   528: new 911	gnu/mapping/WrongType
    //   531: dup
    //   532: aload 6
    //   534: ldc_w 918
    //   537: iconst_1
    //   538: aload_0
    //   539: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   542: athrow
    //   543: astore 9
    //   545: new 911	gnu/mapping/WrongType
    //   548: dup
    //   549: aload 9
    //   551: ldc_w 918
    //   554: iconst_2
    //   555: aload 8
    //   557: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   560: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   18	27	508	java/lang/ClassCastException
    //   32	38	526	java/lang/ClassCastException
    //   50	60	543	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReadEscapedNumber(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 1145	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   3: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   6: aload_1
    //   7: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   10: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: aload_2
    //   14: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore_3
    //   18: aload_3
    //   19: checkcast 371	java/lang/Boolean
    //   22: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   25: istore 5
    //   27: iload 5
    //   29: ifeq +225 -> 254
    //   32: aload_0
    //   33: checkcast 888	java/lang/CharSequence
    //   36: astore 7
    //   38: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   41: aload_1
    //   42: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   45: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   48: astore 8
    //   50: aload 8
    //   52: checkcast 890	java/lang/Number
    //   55: invokevirtual 894	java/lang/Number:intValue	()I
    //   58: istore 10
    //   60: aload 7
    //   62: iload 10
    //   64: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   67: istore 11
    //   69: iload 11
    //   71: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   74: invokestatic 929	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   77: istore 12
    //   79: iload 12
    //   81: ifeq +160 -> 241
    //   84: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   87: aload_1
    //   88: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   91: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: astore 13
    //   96: iload 11
    //   98: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   101: invokestatic 1185	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   104: astore 14
    //   106: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   109: aload 13
    //   111: aload_2
    //   112: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   118: if_acmpeq +31 -> 149
    //   121: aload 14
    //   123: invokestatic 1158	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: astore 23
    //   128: aload 23
    //   130: checkcast 312	gnu/lists/LList
    //   133: astore 25
    //   135: aload 25
    //   137: invokestatic 1149	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   140: invokestatic 1191	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   143: aload 13
    //   145: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   148: areturn
    //   149: aload_0
    //   150: checkcast 888	java/lang/CharSequence
    //   153: astore 16
    //   155: aload 13
    //   157: checkcast 890	java/lang/Number
    //   160: invokevirtual 894	java/lang/Number:intValue	()I
    //   163: istore 18
    //   165: aload 16
    //   167: iload 18
    //   169: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   172: istore 19
    //   174: iload 19
    //   176: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   179: invokestatic 929	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   182: ifeq +31 -> 213
    //   185: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   188: aload 13
    //   190: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   193: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   196: astore 13
    //   198: iload 19
    //   200: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   203: aload 14
    //   205: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   208: astore 14
    //   210: goto -104 -> 106
    //   213: aload 14
    //   215: invokestatic 1158	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   218: astore 20
    //   220: aload 20
    //   222: checkcast 312	gnu/lists/LList
    //   225: astore 22
    //   227: aload 22
    //   229: invokestatic 1149	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   232: invokestatic 1191	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   235: aload 13
    //   237: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   240: areturn
    //   241: iload 12
    //   243: ifeq +7 -> 250
    //   246: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   249: areturn
    //   250: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   253: areturn
    //   254: iload 5
    //   256: ifeq +7 -> 263
    //   259: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   262: areturn
    //   263: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   266: areturn
    //   267: astore 4
    //   269: new 911	gnu/mapping/WrongType
    //   272: dup
    //   273: aload 4
    //   275: ldc_w 913
    //   278: bipush 254
    //   280: aload_3
    //   281: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   284: athrow
    //   285: astore 6
    //   287: new 911	gnu/mapping/WrongType
    //   290: dup
    //   291: aload 6
    //   293: ldc_w 918
    //   296: iconst_1
    //   297: aload_0
    //   298: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   301: athrow
    //   302: astore 9
    //   304: new 911	gnu/mapping/WrongType
    //   307: dup
    //   308: aload 9
    //   310: ldc_w 918
    //   313: iconst_2
    //   314: aload 8
    //   316: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   319: athrow
    //   320: astore 24
    //   322: new 911	gnu/mapping/WrongType
    //   325: dup
    //   326: aload 24
    //   328: ldc_w 1154
    //   331: iconst_1
    //   332: aload 23
    //   334: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   337: athrow
    //   338: astore 15
    //   340: new 911	gnu/mapping/WrongType
    //   343: dup
    //   344: aload 15
    //   346: ldc_w 918
    //   349: iconst_1
    //   350: aload_0
    //   351: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   354: athrow
    //   355: astore 17
    //   357: new 911	gnu/mapping/WrongType
    //   360: dup
    //   361: aload 17
    //   363: ldc_w 918
    //   366: iconst_2
    //   367: aload 13
    //   369: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   372: athrow
    //   373: astore 21
    //   375: new 911	gnu/mapping/WrongType
    //   378: dup
    //   379: aload 21
    //   381: ldc_w 1154
    //   384: iconst_1
    //   385: aload 20
    //   387: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   390: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   18	27	267	java/lang/ClassCastException
    //   32	38	285	java/lang/ClassCastException
    //   50	60	302	java/lang/ClassCastException
    //   128	135	320	java/lang/ClassCastException
    //   149	155	338	java/lang/ClassCastException
    //   155	165	355	java/lang/ClassCastException
    //   220	227	373	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReadNums(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   3: astore_3
    //   4: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   7: astore 4
    //   9: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   12: astore 5
    //   14: aload_1
    //   15: astore 6
    //   17: aload 4
    //   19: astore 7
    //   21: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   24: aload 6
    //   26: aload_2
    //   27: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   33: if_acmpeq +22 -> 55
    //   36: iconst_1
    //   37: anewarray 965	java/lang/Object
    //   40: astore 30
    //   42: aload 30
    //   44: iconst_0
    //   45: getstatic 510	gnu/kawa/slib/pregexp:Lit76	Lgnu/mapping/SimpleSymbol;
    //   48: aastore
    //   49: aload 30
    //   51: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: aload_0
    //   56: checkcast 888	java/lang/CharSequence
    //   59: astore 9
    //   61: aload 6
    //   63: checkcast 890	java/lang/Number
    //   66: invokevirtual 894	java/lang/Number:intValue	()I
    //   69: istore 11
    //   71: aload 9
    //   73: iload 11
    //   75: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   78: istore 12
    //   80: iload 12
    //   82: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   85: invokestatic 929	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   88: ifeq +92 -> 180
    //   91: getstatic 870	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   94: aload 5
    //   96: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   99: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   105: if_acmpeq +38 -> 143
    //   108: iload 12
    //   110: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   113: aload_3
    //   114: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   117: astore_3
    //   118: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   121: aload 6
    //   123: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   126: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: astore 29
    //   131: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   134: astore 5
    //   136: aload 29
    //   138: astore 6
    //   140: goto -119 -> 21
    //   143: iload 12
    //   145: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   148: aload 7
    //   150: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   153: astore 7
    //   155: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   158: aload 6
    //   160: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   163: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   166: astore 28
    //   168: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   171: astore 5
    //   173: aload 28
    //   175: astore 6
    //   177: goto -156 -> 21
    //   180: iload 12
    //   182: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   185: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   188: istore 13
    //   190: iload 13
    //   192: ifeq +28 -> 220
    //   195: getstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   198: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   201: if_acmpne +24 -> 225
    //   204: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   207: aload 6
    //   209: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   212: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   215: astore 6
    //   217: goto -196 -> 21
    //   220: iload 13
    //   222: ifne -18 -> 204
    //   225: iload 12
    //   227: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   230: getstatic 506	gnu/kawa/slib/pregexp:Lit77	Lgnu/text/Char;
    //   233: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   236: istore 14
    //   238: iload 14
    //   240: ifeq +45 -> 285
    //   243: getstatic 870	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   246: aload 5
    //   248: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   251: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   257: if_acmpeq +33 -> 290
    //   260: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   263: aload 6
    //   265: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   268: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   271: astore 27
    //   273: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   276: astore 5
    //   278: aload 27
    //   280: astore 6
    //   282: goto -261 -> 21
    //   285: iload 14
    //   287: ifne -27 -> 260
    //   290: iload 12
    //   292: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   295: getstatic 306	gnu/kawa/slib/pregexp:Lit78	Lgnu/text/Char;
    //   298: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   301: ifeq +155 -> 456
    //   304: aload_3
    //   305: invokestatic 1158	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   308: astore 15
    //   310: aload 15
    //   312: checkcast 312	gnu/lists/LList
    //   315: astore 17
    //   317: aload 17
    //   319: invokestatic 1149	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   322: invokestatic 1191	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   325: astore 18
    //   327: aload 7
    //   329: invokestatic 1158	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   332: astore 19
    //   334: aload 19
    //   336: checkcast 312	gnu/lists/LList
    //   339: astore 21
    //   341: aload 21
    //   343: invokestatic 1149	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   346: invokestatic 1191	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   349: astore 22
    //   351: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   354: astore 24
    //   356: aload 18
    //   358: aload 24
    //   360: if_acmpeq +48 -> 408
    //   363: iconst_1
    //   364: istore 25
    //   366: iconst_1
    //   367: iload 25
    //   369: iconst_1
    //   370: iadd
    //   371: iand
    //   372: istore 26
    //   374: iload 26
    //   376: ifeq +38 -> 414
    //   379: getstatic 870	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   382: aload 5
    //   384: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   387: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   390: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   393: if_acmpeq +26 -> 419
    //   396: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   399: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   402: aload 6
    //   404: invokestatic 1175	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   407: areturn
    //   408: iconst_0
    //   409: istore 25
    //   411: goto -45 -> 366
    //   414: iload 26
    //   416: ifne -20 -> 396
    //   419: getstatic 870	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   422: aload 5
    //   424: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   427: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   430: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   433: if_acmpeq +13 -> 446
    //   436: aload 18
    //   438: aload 18
    //   440: aload 6
    //   442: invokestatic 1175	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   445: areturn
    //   446: aload 18
    //   448: aload 22
    //   450: aload 6
    //   452: invokestatic 1175	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   455: areturn
    //   456: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   459: areturn
    //   460: astore 8
    //   462: new 911	gnu/mapping/WrongType
    //   465: dup
    //   466: aload 8
    //   468: ldc_w 918
    //   471: iconst_1
    //   472: aload_0
    //   473: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   476: athrow
    //   477: astore 10
    //   479: new 911	gnu/mapping/WrongType
    //   482: dup
    //   483: aload 10
    //   485: ldc_w 918
    //   488: iconst_2
    //   489: aload 6
    //   491: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   494: athrow
    //   495: astore 16
    //   497: new 911	gnu/mapping/WrongType
    //   500: dup
    //   501: aload 16
    //   503: ldc_w 1154
    //   506: iconst_1
    //   507: aload 15
    //   509: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   512: athrow
    //   513: astore 20
    //   515: new 911	gnu/mapping/WrongType
    //   518: dup
    //   519: aload 20
    //   521: ldc_w 1154
    //   524: iconst_1
    //   525: aload 19
    //   527: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   530: athrow
    //   531: astore 23
    //   533: new 911	gnu/mapping/WrongType
    //   536: dup
    //   537: aload 23
    //   539: ldc_w 913
    //   542: bipush 254
    //   544: aload 18
    //   546: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   549: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   55	61	460	java/lang/ClassCastException
    //   61	71	477	java/lang/ClassCastException
    //   310	317	495	java/lang/ClassCastException
    //   334	341	513	java/lang/ClassCastException
    //   351	356	531	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReadPattern(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   3: aload_1
    //   4: aload_2
    //   5: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   11: if_acmpeq +20 -> 31
    //   14: getstatic 684	gnu/kawa/slib/pregexp:Lit4	Lgnu/mapping/SimpleSymbol;
    //   17: getstatic 680	gnu/kawa/slib/pregexp:Lit5	Lgnu/mapping/SimpleSymbol;
    //   20: invokestatic 1185	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   23: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   26: aload_1
    //   27: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   30: areturn
    //   31: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   34: astore_3
    //   35: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   38: aload_1
    //   39: aload_2
    //   40: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: astore 4
    //   45: aload 4
    //   47: checkcast 371	java/lang/Boolean
    //   50: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   53: istore 6
    //   55: iload 6
    //   57: ifeq +23 -> 80
    //   60: iload 6
    //   62: ifeq +52 -> 114
    //   65: getstatic 684	gnu/kawa/slib/pregexp:Lit4	Lgnu/mapping/SimpleSymbol;
    //   68: aload_3
    //   69: invokestatic 1158	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   75: aload_1
    //   76: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   79: areturn
    //   80: aload_0
    //   81: checkcast 888	java/lang/CharSequence
    //   84: astore 8
    //   86: aload_1
    //   87: checkcast 890	java/lang/Number
    //   90: invokevirtual 894	java/lang/Number:intValue	()I
    //   93: istore 10
    //   95: aload 8
    //   97: iload 10
    //   99: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   102: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   105: getstatic 310	gnu/kawa/slib/pregexp:Lit6	Lgnu/text/Char;
    //   108: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   111: ifne -46 -> 65
    //   114: aload_0
    //   115: checkcast 888	java/lang/CharSequence
    //   118: astore 12
    //   120: aload_1
    //   121: checkcast 890	java/lang/Number
    //   124: invokevirtual 894	java/lang/Number:intValue	()I
    //   127: istore 14
    //   129: aload 12
    //   131: iload 14
    //   133: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   136: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   139: getstatic 294	gnu/kawa/slib/pregexp:Lit7	Lgnu/text/Char;
    //   142: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   145: ifeq +49 -> 194
    //   148: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   151: aload_1
    //   152: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   155: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: astore 15
    //   160: aload_0
    //   161: aload 15
    //   163: aload_2
    //   164: invokestatic 1194	gnu/kawa/slib/pregexp:pregexpReadBranch	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   167: astore 16
    //   169: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   172: aload 16
    //   174: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   177: aload_3
    //   178: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   181: astore_3
    //   182: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   185: aload 16
    //   187: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   190: astore_1
    //   191: goto -156 -> 35
    //   194: aload_1
    //   195: astore 15
    //   197: goto -37 -> 160
    //   200: astore 5
    //   202: new 911	gnu/mapping/WrongType
    //   205: dup
    //   206: aload 5
    //   208: ldc_w 913
    //   211: bipush 254
    //   213: aload 4
    //   215: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   218: athrow
    //   219: astore 7
    //   221: new 911	gnu/mapping/WrongType
    //   224: dup
    //   225: aload 7
    //   227: ldc_w 918
    //   230: iconst_1
    //   231: aload_0
    //   232: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   235: athrow
    //   236: astore 9
    //   238: new 911	gnu/mapping/WrongType
    //   241: dup
    //   242: aload 9
    //   244: ldc_w 918
    //   247: iconst_2
    //   248: aload_1
    //   249: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   252: athrow
    //   253: astore 11
    //   255: new 911	gnu/mapping/WrongType
    //   258: dup
    //   259: aload 11
    //   261: ldc_w 918
    //   264: iconst_1
    //   265: aload_0
    //   266: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   269: athrow
    //   270: astore 13
    //   272: new 911	gnu/mapping/WrongType
    //   275: dup
    //   276: aload 13
    //   278: ldc_w 918
    //   281: iconst_2
    //   282: aload_1
    //   283: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   286: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   45	55	200	java/lang/ClassCastException
    //   80	86	219	java/lang/ClassCastException
    //   86	95	236	java/lang/ClassCastException
    //   114	120	253	java/lang/ClassCastException
    //   120	129	270	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReadPiece(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 888	java/lang/CharSequence
    //   4: astore 4
    //   6: aload_1
    //   7: checkcast 890	java/lang/Number
    //   10: invokevirtual 894	java/lang/Number:intValue	()I
    //   13: istore 6
    //   15: aload 4
    //   17: iload 6
    //   19: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   22: istore 7
    //   24: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   27: iload 7
    //   29: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   32: getstatic 296	gnu/kawa/slib/pregexp:Lit9	Lgnu/text/Char;
    //   35: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   41: if_acmpeq +20 -> 61
    //   44: getstatic 674	gnu/kawa/slib/pregexp:Lit10	Lgnu/mapping/SimpleSymbol;
    //   47: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   50: aload_1
    //   51: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   54: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   60: areturn
    //   61: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   64: iload 7
    //   66: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   69: getstatic 298	gnu/kawa/slib/pregexp:Lit11	Lgnu/text/Char;
    //   72: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   78: if_acmpeq +20 -> 98
    //   81: getstatic 670	gnu/kawa/slib/pregexp:Lit12	Lgnu/mapping/SimpleSymbol;
    //   84: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   87: aload_1
    //   88: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   91: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   97: areturn
    //   98: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   101: iload 7
    //   103: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   106: getstatic 286	gnu/kawa/slib/pregexp:Lit13	Lgnu/text/Char;
    //   109: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   115: if_acmpeq +25 -> 140
    //   118: getstatic 386	gnu/kawa/slib/pregexp:Lit14	Lgnu/mapping/SimpleSymbol;
    //   121: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   124: aload_1
    //   125: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   128: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   134: aload_0
    //   135: aload_2
    //   136: invokestatic 1197	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: areturn
    //   140: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   143: iload 7
    //   145: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   148: getstatic 300	gnu/kawa/slib/pregexp:Lit15	Lgnu/text/Char;
    //   151: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   157: if_acmpeq +171 -> 328
    //   160: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   163: aload_1
    //   164: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   167: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: astore 21
    //   172: getstatic 1145	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   175: aload 21
    //   177: aload_2
    //   178: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   181: astore 22
    //   183: aload 22
    //   185: checkcast 371	java/lang/Boolean
    //   188: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   191: istore 24
    //   193: iload 24
    //   195: ifeq +100 -> 295
    //   198: aload_0
    //   199: checkcast 888	java/lang/CharSequence
    //   202: astore 29
    //   204: aload 21
    //   206: checkcast 890	java/lang/Number
    //   209: invokevirtual 894	java/lang/Number:intValue	()I
    //   212: istore 31
    //   214: aload 29
    //   216: iload 31
    //   218: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   221: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   224: astore 25
    //   226: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   229: aload 25
    //   231: getstatic 296	gnu/kawa/slib/pregexp:Lit9	Lgnu/text/Char;
    //   234: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   240: if_acmpeq +76 -> 316
    //   243: aload_0
    //   244: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   247: aload_1
    //   248: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   251: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: aload_2
    //   255: invokestatic 1199	gnu/kawa/slib/pregexp:pregexpReadCharList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   258: astore 27
    //   260: getstatic 592	gnu/kawa/slib/pregexp:Lit17	Lgnu/mapping/SimpleSymbol;
    //   263: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   266: aload 27
    //   268: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   271: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   274: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   277: aload 27
    //   279: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   282: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   285: astore 26
    //   287: aload 26
    //   289: aload_0
    //   290: aload_2
    //   291: invokestatic 1197	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: areturn
    //   295: iload 24
    //   297: ifeq +11 -> 308
    //   300: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   303: astore 25
    //   305: goto -79 -> 226
    //   308: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   311: astore 25
    //   313: goto -87 -> 226
    //   316: aload_0
    //   317: aload 21
    //   319: aload_2
    //   320: invokestatic 1199	gnu/kawa/slib/pregexp:pregexpReadCharList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   323: astore 26
    //   325: goto -38 -> 287
    //   328: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   331: iload 7
    //   333: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   336: getstatic 308	gnu/kawa/slib/pregexp:Lit18	Lgnu/text/Char;
    //   339: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   342: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   345: if_acmpeq +24 -> 369
    //   348: aload_0
    //   349: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   352: aload_1
    //   353: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   356: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   359: aload_2
    //   360: invokestatic 1202	gnu/kawa/slib/pregexp:pregexpReadSubpattern	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: aload_0
    //   364: aload_2
    //   365: invokestatic 1197	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   368: areturn
    //   369: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   372: iload 7
    //   374: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   377: getstatic 284	gnu/kawa/slib/pregexp:Lit19	Lgnu/text/Char;
    //   380: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   386: if_acmpeq +124 -> 510
    //   389: aload_0
    //   390: aload_1
    //   391: aload_2
    //   392: invokestatic 1204	gnu/kawa/slib/pregexp:pregexpReadEscapedNumber	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   395: astore 17
    //   397: aload 17
    //   399: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   402: if_acmpeq +38 -> 440
    //   405: getstatic 664	gnu/kawa/slib/pregexp:Lit20	Lgnu/mapping/SimpleSymbol;
    //   408: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   411: aload 17
    //   413: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   416: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   419: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   422: aload 17
    //   424: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   427: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   430: astore 20
    //   432: aload 20
    //   434: aload_0
    //   435: aload_2
    //   436: invokestatic 1197	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   439: areturn
    //   440: aload_0
    //   441: aload_1
    //   442: aload_2
    //   443: invokestatic 1168	gnu/kawa/slib/pregexp:pregexpReadEscapedChar	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   446: astore 18
    //   448: aload 18
    //   450: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   453: if_acmpeq +27 -> 480
    //   456: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   459: aload 18
    //   461: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   464: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   467: aload 18
    //   469: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   472: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   475: astore 20
    //   477: goto -45 -> 432
    //   480: iconst_2
    //   481: anewarray 965	java/lang/Object
    //   484: astore 19
    //   486: aload 19
    //   488: iconst_0
    //   489: getstatic 660	gnu/kawa/slib/pregexp:Lit21	Lgnu/mapping/SimpleSymbol;
    //   492: aastore
    //   493: aload 19
    //   495: iconst_1
    //   496: getstatic 656	gnu/kawa/slib/pregexp:Lit22	Lgnu/mapping/SimpleSymbol;
    //   499: aastore
    //   500: aload 19
    //   502: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   505: astore 20
    //   507: goto -75 -> 432
    //   510: getstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   513: astore 8
    //   515: aload 8
    //   517: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   520: if_acmpeq +35 -> 555
    //   523: aload 8
    //   525: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   528: if_acmpeq +60 -> 588
    //   531: iload 7
    //   533: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   536: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   539: aload_1
    //   540: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   543: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   546: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   549: aload_0
    //   550: aload_2
    //   551: invokestatic 1197	gnu/kawa/slib/pregexp:pregexpWrapQuantifierIfAny	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   554: areturn
    //   555: iconst_1
    //   556: iconst_1
    //   557: iload 7
    //   559: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   562: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   565: iadd
    //   566: iand
    //   567: istore 9
    //   569: iload 9
    //   571: ifeq +44 -> 615
    //   574: iload 7
    //   576: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   579: getstatic 690	gnu/kawa/slib/pregexp:Lit1	Lgnu/text/Char;
    //   582: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   585: ifeq -54 -> 531
    //   588: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   591: astore 10
    //   593: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   596: aload_1
    //   597: aload_2
    //   598: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   601: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   604: if_acmpeq +19 -> 623
    //   607: getstatic 652	gnu/kawa/slib/pregexp:Lit23	Lgnu/mapping/SimpleSymbol;
    //   610: aload_1
    //   611: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   614: areturn
    //   615: iload 9
    //   617: ifeq -29 -> 588
    //   620: goto -89 -> 531
    //   623: aload_0
    //   624: checkcast 888	java/lang/CharSequence
    //   627: astore 12
    //   629: aload_1
    //   630: checkcast 890	java/lang/Number
    //   633: invokevirtual 894	java/lang/Number:intValue	()I
    //   636: istore 14
    //   638: aload 12
    //   640: iload 14
    //   642: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   645: istore 15
    //   647: aload 10
    //   649: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   652: if_acmpeq +48 -> 700
    //   655: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   658: aload_1
    //   659: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   662: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   665: astore_1
    //   666: iload 15
    //   668: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   671: getstatic 648	gnu/kawa/slib/pregexp:Lit24	Lgnu/text/Char;
    //   674: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   677: ifeq +15 -> 692
    //   680: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   683: astore 16
    //   685: aload 16
    //   687: astore 10
    //   689: goto -96 -> 593
    //   692: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   695: astore 16
    //   697: goto -12 -> 685
    //   700: iload 15
    //   702: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   705: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   708: ifeq +22 -> 730
    //   711: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   714: aload_1
    //   715: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   718: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   721: astore_1
    //   722: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   725: astore 10
    //   727: goto -134 -> 593
    //   730: iload 15
    //   732: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   735: getstatic 690	gnu/kawa/slib/pregexp:Lit1	Lgnu/text/Char;
    //   738: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   741: ifeq +22 -> 763
    //   744: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   747: aload_1
    //   748: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   751: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   754: astore_1
    //   755: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   758: astore 10
    //   760: goto -167 -> 593
    //   763: getstatic 652	gnu/kawa/slib/pregexp:Lit23	Lgnu/mapping/SimpleSymbol;
    //   766: aload_1
    //   767: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   770: areturn
    //   771: astore_3
    //   772: new 911	gnu/mapping/WrongType
    //   775: dup
    //   776: aload_3
    //   777: ldc_w 918
    //   780: iconst_1
    //   781: aload_0
    //   782: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   785: athrow
    //   786: astore 5
    //   788: new 911	gnu/mapping/WrongType
    //   791: dup
    //   792: aload 5
    //   794: ldc_w 918
    //   797: iconst_2
    //   798: aload_1
    //   799: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   802: athrow
    //   803: astore 23
    //   805: new 911	gnu/mapping/WrongType
    //   808: dup
    //   809: aload 23
    //   811: ldc_w 913
    //   814: bipush 254
    //   816: aload 22
    //   818: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   821: athrow
    //   822: astore 28
    //   824: new 911	gnu/mapping/WrongType
    //   827: dup
    //   828: aload 28
    //   830: ldc_w 918
    //   833: iconst_1
    //   834: aload_0
    //   835: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   838: athrow
    //   839: astore 30
    //   841: new 911	gnu/mapping/WrongType
    //   844: dup
    //   845: aload 30
    //   847: ldc_w 918
    //   850: iconst_2
    //   851: aload 21
    //   853: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   856: athrow
    //   857: astore 11
    //   859: new 911	gnu/mapping/WrongType
    //   862: dup
    //   863: aload 11
    //   865: ldc_w 918
    //   868: iconst_1
    //   869: aload_0
    //   870: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   873: athrow
    //   874: astore 13
    //   876: new 911	gnu/mapping/WrongType
    //   879: dup
    //   880: aload 13
    //   882: ldc_w 918
    //   885: iconst_2
    //   886: aload_1
    //   887: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   890: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	771	java/lang/ClassCastException
    //   6	15	786	java/lang/ClassCastException
    //   183	193	803	java/lang/ClassCastException
    //   198	204	822	java/lang/ClassCastException
    //   204	214	839	java/lang/ClassCastException
    //   623	629	857	java/lang/ClassCastException
    //   629	638	874	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReadPosixCharClass(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3: astore_3
    //   4: getstatic 588	gnu/kawa/slib/pregexp:Lit44	Lgnu/text/Char;
    //   7: invokestatic 1185	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   10: astore 4
    //   12: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   15: aload_1
    //   16: aload_2
    //   17: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   20: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   23: if_acmpeq +22 -> 45
    //   26: iconst_1
    //   27: anewarray 965	java/lang/Object
    //   30: astore 25
    //   32: aload 25
    //   34: iconst_0
    //   35: getstatic 586	gnu/kawa/slib/pregexp:Lit45	Lgnu/mapping/SimpleSymbol;
    //   38: aastore
    //   39: aload 25
    //   41: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   44: areturn
    //   45: aload_0
    //   46: checkcast 888	java/lang/CharSequence
    //   49: astore 6
    //   51: aload_1
    //   52: checkcast 890	java/lang/Number
    //   55: invokevirtual 894	java/lang/Number:intValue	()I
    //   58: istore 8
    //   60: aload 6
    //   62: iload 8
    //   64: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   67: istore 9
    //   69: iload 9
    //   71: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   74: getstatic 296	gnu/kawa/slib/pregexp:Lit9	Lgnu/text/Char;
    //   77: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   80: ifeq +21 -> 101
    //   83: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   86: astore_3
    //   87: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   90: aload_1
    //   91: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   94: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: astore_1
    //   98: goto -86 -> 12
    //   101: iload 9
    //   103: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   106: invokestatic 926	kawa/lib/rnrs/unicode:isCharAlphabetic	(Lgnu/text/Char;)Z
    //   109: ifeq +29 -> 138
    //   112: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   115: aload_1
    //   116: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   119: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: astore_1
    //   123: iload 9
    //   125: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   128: aload 4
    //   130: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   133: astore 4
    //   135: goto -123 -> 12
    //   138: iload 9
    //   140: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   143: getstatic 588	gnu/kawa/slib/pregexp:Lit44	Lgnu/text/Char;
    //   146: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   149: ifeq +172 -> 321
    //   152: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   155: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   158: aload_1
    //   159: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   162: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: aload_2
    //   166: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: astore 11
    //   171: aload 11
    //   173: checkcast 371	java/lang/Boolean
    //   176: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   179: istore 13
    //   181: iload 13
    //   183: ifeq +27 -> 210
    //   186: iload 13
    //   188: ifeq +69 -> 257
    //   191: iconst_1
    //   192: anewarray 965	java/lang/Object
    //   195: astore 24
    //   197: aload 24
    //   199: iconst_0
    //   200: getstatic 586	gnu/kawa/slib/pregexp:Lit45	Lgnu/mapping/SimpleSymbol;
    //   203: aastore
    //   204: aload 24
    //   206: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   209: areturn
    //   210: aload_0
    //   211: checkcast 888	java/lang/CharSequence
    //   214: astore 15
    //   216: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   219: aload_1
    //   220: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   223: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   226: astore 16
    //   228: aload 16
    //   230: checkcast 890	java/lang/Number
    //   233: invokevirtual 894	java/lang/Number:intValue	()I
    //   236: istore 18
    //   238: aload 15
    //   240: iload 18
    //   242: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   245: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   248: getstatic 302	gnu/kawa/slib/pregexp:Lit46	Lgnu/text/Char;
    //   251: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   254: ifeq -63 -> 191
    //   257: aload 4
    //   259: invokestatic 1158	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   262: astore 19
    //   264: aload 19
    //   266: checkcast 312	gnu/lists/LList
    //   269: astore 21
    //   271: aload 21
    //   273: invokestatic 1149	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   276: invokestatic 1208	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   279: astore 22
    //   281: aload_3
    //   282: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   285: if_acmpeq +29 -> 314
    //   288: getstatic 592	gnu/kawa/slib/pregexp:Lit17	Lgnu/mapping/SimpleSymbol;
    //   291: aload 22
    //   293: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   296: astore 23
    //   298: aload 23
    //   300: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   303: aload_1
    //   304: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   307: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   310: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   313: areturn
    //   314: aload 22
    //   316: astore 23
    //   318: goto -20 -> 298
    //   321: iconst_1
    //   322: anewarray 965	java/lang/Object
    //   325: astore 10
    //   327: aload 10
    //   329: iconst_0
    //   330: getstatic 586	gnu/kawa/slib/pregexp:Lit45	Lgnu/mapping/SimpleSymbol;
    //   333: aastore
    //   334: aload 10
    //   336: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   339: areturn
    //   340: astore 5
    //   342: new 911	gnu/mapping/WrongType
    //   345: dup
    //   346: aload 5
    //   348: ldc_w 918
    //   351: iconst_1
    //   352: aload_0
    //   353: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   356: athrow
    //   357: astore 7
    //   359: new 911	gnu/mapping/WrongType
    //   362: dup
    //   363: aload 7
    //   365: ldc_w 918
    //   368: iconst_2
    //   369: aload_1
    //   370: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   373: athrow
    //   374: astore 12
    //   376: new 911	gnu/mapping/WrongType
    //   379: dup
    //   380: aload 12
    //   382: ldc_w 913
    //   385: bipush 254
    //   387: aload 11
    //   389: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   392: athrow
    //   393: astore 14
    //   395: new 911	gnu/mapping/WrongType
    //   398: dup
    //   399: aload 14
    //   401: ldc_w 918
    //   404: iconst_1
    //   405: aload_0
    //   406: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   409: athrow
    //   410: astore 17
    //   412: new 911	gnu/mapping/WrongType
    //   415: dup
    //   416: aload 17
    //   418: ldc_w 918
    //   421: iconst_2
    //   422: aload 16
    //   424: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   427: athrow
    //   428: astore 20
    //   430: new 911	gnu/mapping/WrongType
    //   433: dup
    //   434: aload 20
    //   436: ldc_w 1154
    //   439: iconst_1
    //   440: aload 19
    //   442: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   445: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   45	51	340	java/lang/ClassCastException
    //   51	60	357	java/lang/ClassCastException
    //   171	181	374	java/lang/ClassCastException
    //   210	216	393	java/lang/ClassCastException
    //   228	238	410	java/lang/ClassCastException
    //   264	271	428	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReadSubpattern(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_0
    //   5: aload_1
    //   6: aload_2
    //   7: invokestatic 1210	gnu/kawa/slib/pregexp:pregexpReadClusterType	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: astore 4
    //   12: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   15: aload 4
    //   17: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: astore 5
    //   22: aload_0
    //   23: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   26: aload 4
    //   28: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: aload_2
    //   32: invokestatic 1023	gnu/kawa/slib/pregexp:pregexpReadPattern	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: astore 6
    //   37: aload_3
    //   38: putstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   41: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   44: aload 6
    //   46: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore 7
    //   51: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   54: aload 6
    //   56: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore 8
    //   61: getstatic 1145	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   64: aload 8
    //   66: aload_2
    //   67: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: astore 9
    //   72: aload 9
    //   74: checkcast 371	java/lang/Boolean
    //   77: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   80: istore 11
    //   82: iload 11
    //   84: ifeq +71 -> 155
    //   87: aload_0
    //   88: checkcast 888	java/lang/CharSequence
    //   91: astore 17
    //   93: aload 8
    //   95: checkcast 890	java/lang/Number
    //   98: invokevirtual 894	java/lang/Number:intValue	()I
    //   101: istore 19
    //   103: aload 17
    //   105: iload 19
    //   107: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   110: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   113: getstatic 310	gnu/kawa/slib/pregexp:Lit6	Lgnu/text/Char;
    //   116: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   119: ifeq +41 -> 160
    //   122: aload 7
    //   124: astore 13
    //   126: aload 5
    //   128: astore 14
    //   130: aload 14
    //   132: invokestatic 1072	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   135: ifeq +44 -> 179
    //   138: aload 13
    //   140: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   143: aload 8
    //   145: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   148: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   154: areturn
    //   155: iload 11
    //   157: ifne -35 -> 122
    //   160: iconst_1
    //   161: anewarray 965	java/lang/Object
    //   164: astore 12
    //   166: aload 12
    //   168: iconst_0
    //   169: getstatic 538	gnu/kawa/slib/pregexp:Lit64	Lgnu/mapping/SimpleSymbol;
    //   172: aastore
    //   173: aload 12
    //   175: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   178: areturn
    //   179: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   182: aload 14
    //   184: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: astore 15
    //   189: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   192: aload 14
    //   194: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   197: aload 13
    //   199: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   202: astore 13
    //   204: aload 15
    //   206: astore 14
    //   208: goto -78 -> 130
    //   211: astore 10
    //   213: new 911	gnu/mapping/WrongType
    //   216: dup
    //   217: aload 10
    //   219: ldc_w 913
    //   222: bipush 254
    //   224: aload 9
    //   226: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: astore 16
    //   232: new 911	gnu/mapping/WrongType
    //   235: dup
    //   236: aload 16
    //   238: ldc_w 918
    //   241: iconst_1
    //   242: aload_0
    //   243: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: astore 18
    //   249: new 911	gnu/mapping/WrongType
    //   252: dup
    //   253: aload 18
    //   255: ldc_w 918
    //   258: iconst_2
    //   259: aload 8
    //   261: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   264: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   72	82	211	java/lang/ClassCastException
    //   87	93	230	java/lang/ClassCastException
    //   93	103	247	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReplace(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 888	java/lang/CharSequence
    //   4: astore 4
    //   6: aload 4
    //   8: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   11: istore 5
    //   13: iconst_2
    //   14: anewarray 965	java/lang/Object
    //   17: astore 6
    //   19: aload 6
    //   21: iconst_0
    //   22: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   25: aastore
    //   26: aload 6
    //   28: iconst_1
    //   29: iload 5
    //   31: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: aload_0
    //   36: aload_1
    //   37: aload 6
    //   39: invokestatic 1213	gnu/kawa/slib/pregexp:pregexpMatchPositions$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   42: astore 7
    //   44: aload 7
    //   46: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   49: if_acmpne +5 -> 54
    //   52: aload_1
    //   53: areturn
    //   54: aload_2
    //   55: checkcast 888	java/lang/CharSequence
    //   58: astore 9
    //   60: aload 9
    //   62: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   65: istore 10
    //   67: getstatic 1216	kawa/lib/lists:caar	Lgnu/expr/GenericProc;
    //   70: aload 7
    //   72: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: astore 11
    //   77: getstatic 1219	kawa/lib/lists:cdar	Lgnu/expr/GenericProc;
    //   80: aload 7
    //   82: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: astore 12
    //   87: iconst_3
    //   88: anewarray 965	java/lang/Object
    //   91: astore 13
    //   93: aload_1
    //   94: checkcast 888	java/lang/CharSequence
    //   97: astore 15
    //   99: aload 11
    //   101: checkcast 890	java/lang/Number
    //   104: invokevirtual 894	java/lang/Number:intValue	()I
    //   107: istore 17
    //   109: aload 13
    //   111: iconst_0
    //   112: aload 15
    //   114: iconst_0
    //   115: iload 17
    //   117: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   120: aastore
    //   121: aload 13
    //   123: iconst_1
    //   124: aload_1
    //   125: aload_2
    //   126: iload 10
    //   128: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: aload 7
    //   133: invokestatic 1222	gnu/kawa/slib/pregexp:pregexpReplaceAux	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: aastore
    //   137: aload_1
    //   138: checkcast 888	java/lang/CharSequence
    //   141: astore 19
    //   143: aload 12
    //   145: checkcast 890	java/lang/Number
    //   148: invokevirtual 894	java/lang/Number:intValue	()I
    //   151: istore 21
    //   153: aload 13
    //   155: iconst_2
    //   156: aload 19
    //   158: iload 21
    //   160: iload 5
    //   162: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   165: aastore
    //   166: aload 13
    //   168: invokestatic 1226	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   171: areturn
    //   172: astore_3
    //   173: new 911	gnu/mapping/WrongType
    //   176: dup
    //   177: aload_3
    //   178: ldc_w 1028
    //   181: iconst_1
    //   182: aload_1
    //   183: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    //   187: astore 8
    //   189: new 911	gnu/mapping/WrongType
    //   192: dup
    //   193: aload 8
    //   195: ldc_w 1028
    //   198: iconst_1
    //   199: aload_2
    //   200: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   203: athrow
    //   204: astore 14
    //   206: new 911	gnu/mapping/WrongType
    //   209: dup
    //   210: aload 14
    //   212: ldc_w 1097
    //   215: iconst_1
    //   216: aload_1
    //   217: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   220: athrow
    //   221: astore 16
    //   223: new 911	gnu/mapping/WrongType
    //   226: dup
    //   227: aload 16
    //   229: ldc_w 1097
    //   232: iconst_3
    //   233: aload 11
    //   235: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //   239: astore 18
    //   241: new 911	gnu/mapping/WrongType
    //   244: dup
    //   245: aload 18
    //   247: ldc_w 1097
    //   250: iconst_1
    //   251: aload_1
    //   252: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    //   256: astore 20
    //   258: new 911	gnu/mapping/WrongType
    //   261: dup
    //   262: aload 20
    //   264: ldc_w 1097
    //   267: iconst_2
    //   268: aload 12
    //   270: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   273: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	172	java/lang/ClassCastException
    //   54	60	187	java/lang/ClassCastException
    //   93	99	204	java/lang/ClassCastException
    //   99	109	221	java/lang/ClassCastException
    //   137	143	239	java/lang/ClassCastException
    //   143	153	256	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReplace$St(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 1101	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   4: ifeq +8 -> 12
    //   7: aload_0
    //   8: invokestatic 1103	gnu/kawa/slib/pregexp:pregexp	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   11: astore_0
    //   12: aload_1
    //   13: checkcast 888	java/lang/CharSequence
    //   16: astore 4
    //   18: aload 4
    //   20: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   23: istore 5
    //   25: aload_2
    //   26: checkcast 888	java/lang/CharSequence
    //   29: astore 7
    //   31: aload 7
    //   33: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   36: istore 8
    //   38: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   41: astore 9
    //   43: ldc_w 1229
    //   46: astore 10
    //   48: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   51: aload 9
    //   53: iload 5
    //   55: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   64: if_acmpeq +6 -> 70
    //   67: aload 10
    //   69: areturn
    //   70: iconst_2
    //   71: anewarray 965	java/lang/Object
    //   74: astore 11
    //   76: aload 11
    //   78: iconst_0
    //   79: aload 9
    //   81: aastore
    //   82: aload 11
    //   84: iconst_1
    //   85: iload 5
    //   87: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: aload_0
    //   92: aload_1
    //   93: aload 11
    //   95: invokestatic 1213	gnu/kawa/slib/pregexp:pregexpMatchPositions$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   98: astore 12
    //   100: aload 12
    //   102: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   105: if_acmpne +69 -> 174
    //   108: getstatic 870	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   111: aload 9
    //   113: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   116: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   122: if_acmpeq +5 -> 127
    //   125: aload_1
    //   126: areturn
    //   127: iconst_2
    //   128: anewarray 965	java/lang/Object
    //   131: astore 22
    //   133: aload 22
    //   135: iconst_0
    //   136: aload 10
    //   138: aastore
    //   139: aload_1
    //   140: checkcast 888	java/lang/CharSequence
    //   143: astore 24
    //   145: aload 9
    //   147: checkcast 890	java/lang/Number
    //   150: invokevirtual 894	java/lang/Number:intValue	()I
    //   153: istore 26
    //   155: aload 22
    //   157: iconst_1
    //   158: aload 24
    //   160: iload 26
    //   162: iload 5
    //   164: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   167: aastore
    //   168: aload 22
    //   170: invokestatic 1226	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   173: areturn
    //   174: getstatic 1219	kawa/lib/lists:cdar	Lgnu/expr/GenericProc;
    //   177: aload 12
    //   179: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   182: astore 13
    //   184: iconst_3
    //   185: anewarray 965	java/lang/Object
    //   188: astore 14
    //   190: aload 14
    //   192: iconst_0
    //   193: aload 10
    //   195: aastore
    //   196: aload_1
    //   197: checkcast 888	java/lang/CharSequence
    //   200: astore 16
    //   202: aload 9
    //   204: checkcast 890	java/lang/Number
    //   207: invokevirtual 894	java/lang/Number:intValue	()I
    //   210: istore 18
    //   212: getstatic 1216	kawa/lib/lists:caar	Lgnu/expr/GenericProc;
    //   215: aload 12
    //   217: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   220: astore 19
    //   222: aload 19
    //   224: checkcast 890	java/lang/Number
    //   227: invokevirtual 894	java/lang/Number:intValue	()I
    //   230: istore 21
    //   232: aload 14
    //   234: iconst_1
    //   235: aload 16
    //   237: iload 18
    //   239: iload 21
    //   241: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   244: aastore
    //   245: aload 14
    //   247: iconst_2
    //   248: aload_1
    //   249: aload_2
    //   250: iload 8
    //   252: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: aload 12
    //   257: invokestatic 1222	gnu/kawa/slib/pregexp:pregexpReplaceAux	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: aastore
    //   261: aload 14
    //   263: invokestatic 1226	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   266: astore 10
    //   268: aload 13
    //   270: astore 9
    //   272: goto -224 -> 48
    //   275: astore_3
    //   276: new 911	gnu/mapping/WrongType
    //   279: dup
    //   280: aload_3
    //   281: ldc_w 1028
    //   284: iconst_1
    //   285: aload_1
    //   286: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   289: athrow
    //   290: astore 6
    //   292: new 911	gnu/mapping/WrongType
    //   295: dup
    //   296: aload 6
    //   298: ldc_w 1028
    //   301: iconst_1
    //   302: aload_2
    //   303: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   306: athrow
    //   307: astore 23
    //   309: new 911	gnu/mapping/WrongType
    //   312: dup
    //   313: aload 23
    //   315: ldc_w 1097
    //   318: iconst_1
    //   319: aload_1
    //   320: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   323: athrow
    //   324: astore 25
    //   326: new 911	gnu/mapping/WrongType
    //   329: dup
    //   330: aload 25
    //   332: ldc_w 1097
    //   335: iconst_2
    //   336: aload 9
    //   338: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   341: athrow
    //   342: astore 15
    //   344: new 911	gnu/mapping/WrongType
    //   347: dup
    //   348: aload 15
    //   350: ldc_w 1097
    //   353: iconst_1
    //   354: aload_1
    //   355: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   358: athrow
    //   359: astore 17
    //   361: new 911	gnu/mapping/WrongType
    //   364: dup
    //   365: aload 17
    //   367: ldc_w 1097
    //   370: iconst_2
    //   371: aload 9
    //   373: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   376: athrow
    //   377: astore 20
    //   379: new 911	gnu/mapping/WrongType
    //   382: dup
    //   383: aload 20
    //   385: ldc_w 1097
    //   388: iconst_3
    //   389: aload 19
    //   391: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   12	18	275	java/lang/ClassCastException
    //   25	31	290	java/lang/ClassCastException
    //   139	145	307	java/lang/ClassCastException
    //   145	155	324	java/lang/ClassCastException
    //   196	202	342	java/lang/ClassCastException
    //   202	212	359	java/lang/ClassCastException
    //   222	232	377	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpReplaceAux(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   3: astore 4
    //   5: ldc_w 1229
    //   8: astore 5
    //   10: aload 4
    //   12: astore 6
    //   14: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   17: aload 6
    //   19: aload_2
    //   20: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   23: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   26: if_acmpeq +6 -> 32
    //   29: aload 5
    //   31: areturn
    //   32: aload_1
    //   33: checkcast 888	java/lang/CharSequence
    //   36: astore 8
    //   38: aload 6
    //   40: checkcast 890	java/lang/Number
    //   43: invokevirtual 894	java/lang/Number:intValue	()I
    //   46: istore 10
    //   48: aload 8
    //   50: iload 10
    //   52: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   55: istore 11
    //   57: iload 11
    //   59: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   62: getstatic 284	gnu/kawa/slib/pregexp:Lit19	Lgnu/text/Char;
    //   65: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   68: ifeq +385 -> 453
    //   71: aload_1
    //   72: aload 6
    //   74: aload_2
    //   75: invokestatic 1204	gnu/kawa/slib/pregexp:pregexpReadEscapedNumber	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   78: astore 15
    //   80: aload 15
    //   82: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   85: if_acmpeq +106 -> 191
    //   88: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   91: aload 15
    //   93: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: astore 21
    //   98: aload 15
    //   100: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   103: if_acmpeq +152 -> 255
    //   106: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   109: aload 15
    //   111: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: astore 22
    //   116: aload 21
    //   118: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   121: if_acmpne +220 -> 341
    //   124: aload_1
    //   125: checkcast 888	java/lang/CharSequence
    //   128: astore 35
    //   130: aload 22
    //   132: checkcast 890	java/lang/Number
    //   135: invokevirtual 894	java/lang/Number:intValue	()I
    //   138: istore 37
    //   140: aload 35
    //   142: iload 37
    //   144: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   147: istore 38
    //   149: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   152: aload 22
    //   154: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   157: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: astore 39
    //   162: iload 38
    //   164: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   167: getstatic 298	gnu/kawa/slib/pregexp:Lit11	Lgnu/text/Char;
    //   170: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   173: ifeq +122 -> 295
    //   176: aload 5
    //   178: astore 42
    //   180: aload 42
    //   182: astore 5
    //   184: aload 39
    //   186: astore 6
    //   188: goto -174 -> 14
    //   191: aload_1
    //   192: checkcast 888	java/lang/CharSequence
    //   195: astore 17
    //   197: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   200: aload 6
    //   202: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   205: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   208: astore 18
    //   210: aload 18
    //   212: checkcast 890	java/lang/Number
    //   215: invokevirtual 894	java/lang/Number:intValue	()I
    //   218: istore 20
    //   220: aload 17
    //   222: iload 20
    //   224: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   227: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   230: getstatic 349	gnu/kawa/slib/pregexp:Lit113	Lgnu/text/Char;
    //   233: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   236: ifeq +11 -> 247
    //   239: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   242: astore 21
    //   244: goto -146 -> 98
    //   247: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   250: astore 21
    //   252: goto -154 -> 98
    //   255: aload 21
    //   257: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   260: if_acmpeq +19 -> 279
    //   263: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   266: aload 6
    //   268: getstatic 666	gnu/kawa/slib/pregexp:Lit16	Lgnu/math/IntNum;
    //   271: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   274: astore 22
    //   276: goto -160 -> 116
    //   279: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   282: aload 6
    //   284: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   287: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   290: astore 22
    //   292: goto -176 -> 116
    //   295: iconst_2
    //   296: anewarray 965	java/lang/Object
    //   299: astore 40
    //   301: aload 40
    //   303: iconst_0
    //   304: aload 5
    //   306: aastore
    //   307: iconst_1
    //   308: anewarray 965	java/lang/Object
    //   311: astore 41
    //   313: aload 41
    //   315: iconst_0
    //   316: iload 38
    //   318: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   321: aastore
    //   322: aload 40
    //   324: iconst_1
    //   325: aload 41
    //   327: invokestatic 1233	kawa/lib/strings:$make$string$	([Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   330: aastore
    //   331: aload 40
    //   333: invokestatic 1226	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   336: astore 42
    //   338: goto -158 -> 180
    //   341: aload_3
    //   342: aload 21
    //   344: invokestatic 1235	gnu/kawa/slib/pregexp:pregexpListRef	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: astore 23
    //   349: aload 23
    //   351: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   354: if_acmpeq +92 -> 446
    //   357: iconst_2
    //   358: anewarray 965	java/lang/Object
    //   361: astore 25
    //   363: aload 25
    //   365: iconst_0
    //   366: aload 5
    //   368: aastore
    //   369: aload_0
    //   370: checkcast 888	java/lang/CharSequence
    //   373: astore 27
    //   375: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   378: aload 23
    //   380: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   383: astore 28
    //   385: aload 28
    //   387: checkcast 890	java/lang/Number
    //   390: invokevirtual 894	java/lang/Number:intValue	()I
    //   393: istore 30
    //   395: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   398: aload 23
    //   400: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   403: astore 31
    //   405: aload 31
    //   407: checkcast 890	java/lang/Number
    //   410: invokevirtual 894	java/lang/Number:intValue	()I
    //   413: istore 33
    //   415: aload 25
    //   417: iconst_1
    //   418: aload 27
    //   420: iload 30
    //   422: iload 33
    //   424: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   427: aastore
    //   428: aload 25
    //   430: invokestatic 1226	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   433: astore 24
    //   435: aload 24
    //   437: astore 5
    //   439: aload 22
    //   441: astore 6
    //   443: goto -429 -> 14
    //   446: aload 5
    //   448: astore 24
    //   450: goto -15 -> 435
    //   453: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   456: aload 6
    //   458: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   461: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   464: astore 12
    //   466: iconst_2
    //   467: anewarray 965	java/lang/Object
    //   470: astore 13
    //   472: aload 13
    //   474: iconst_0
    //   475: aload 5
    //   477: aastore
    //   478: iconst_1
    //   479: anewarray 965	java/lang/Object
    //   482: astore 14
    //   484: aload 14
    //   486: iconst_0
    //   487: iload 11
    //   489: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   492: aastore
    //   493: aload 13
    //   495: iconst_1
    //   496: aload 14
    //   498: invokestatic 1233	kawa/lib/strings:$make$string$	([Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   501: aastore
    //   502: aload 13
    //   504: invokestatic 1226	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   507: astore 5
    //   509: aload 12
    //   511: astore 6
    //   513: goto -499 -> 14
    //   516: astore 7
    //   518: new 911	gnu/mapping/WrongType
    //   521: dup
    //   522: aload 7
    //   524: ldc_w 918
    //   527: iconst_1
    //   528: aload_1
    //   529: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   532: athrow
    //   533: astore 9
    //   535: new 911	gnu/mapping/WrongType
    //   538: dup
    //   539: aload 9
    //   541: ldc_w 918
    //   544: iconst_2
    //   545: aload 6
    //   547: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   550: athrow
    //   551: astore 16
    //   553: new 911	gnu/mapping/WrongType
    //   556: dup
    //   557: aload 16
    //   559: ldc_w 918
    //   562: iconst_1
    //   563: aload_1
    //   564: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   567: athrow
    //   568: astore 19
    //   570: new 911	gnu/mapping/WrongType
    //   573: dup
    //   574: aload 19
    //   576: ldc_w 918
    //   579: iconst_2
    //   580: aload 18
    //   582: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   585: athrow
    //   586: astore 34
    //   588: new 911	gnu/mapping/WrongType
    //   591: dup
    //   592: aload 34
    //   594: ldc_w 918
    //   597: iconst_1
    //   598: aload_1
    //   599: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   602: athrow
    //   603: astore 36
    //   605: new 911	gnu/mapping/WrongType
    //   608: dup
    //   609: aload 36
    //   611: ldc_w 918
    //   614: iconst_2
    //   615: aload 22
    //   617: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   620: athrow
    //   621: astore 26
    //   623: new 911	gnu/mapping/WrongType
    //   626: dup
    //   627: aload 26
    //   629: ldc_w 1097
    //   632: iconst_1
    //   633: aload_0
    //   634: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   637: athrow
    //   638: astore 29
    //   640: new 911	gnu/mapping/WrongType
    //   643: dup
    //   644: aload 29
    //   646: ldc_w 1097
    //   649: iconst_2
    //   650: aload 28
    //   652: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   655: athrow
    //   656: astore 32
    //   658: new 911	gnu/mapping/WrongType
    //   661: dup
    //   662: aload 32
    //   664: ldc_w 1097
    //   667: iconst_3
    //   668: aload 31
    //   670: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   673: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   32	38	516	java/lang/ClassCastException
    //   38	48	533	java/lang/ClassCastException
    //   191	197	551	java/lang/ClassCastException
    //   210	220	568	java/lang/ClassCastException
    //   124	130	586	java/lang/ClassCastException
    //   130	140	603	java/lang/ClassCastException
    //   369	375	621	java/lang/ClassCastException
    //   385	395	638	java/lang/ClassCastException
    //   405	415	656	java/lang/ClassCastException
  }

  public static Object pregexpReverse$Ex(Object paramObject)
  {
    Object localObject1 = LList.Empty;
    while (true)
    {
      if (lists.isNull(paramObject))
        return localObject1;
      Object localObject2 = lists.cdr.apply1(paramObject);
      try
      {
        Pair localPair = (Pair)paramObject;
        lists.setCdr$Ex(localPair, localObject1);
        Object localObject3 = paramObject;
        paramObject = localObject2;
        localObject1 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, paramObject);
      }
    }
  }

  // ERROR //
  public static Object pregexpSplit(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 888	java/lang/CharSequence
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   9: istore 4
    //   11: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   14: astore 5
    //   16: getstatic 316	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   19: astore 6
    //   21: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   24: astore 7
    //   26: aload 6
    //   28: astore 8
    //   30: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   33: aload 5
    //   35: iload 4
    //   37: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   46: if_acmpeq +9 -> 55
    //   49: aload 8
    //   51: invokestatic 1158	gnu/kawa/slib/pregexp:pregexpReverse$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: areturn
    //   55: iconst_2
    //   56: anewarray 965	java/lang/Object
    //   59: astore 9
    //   61: aload 9
    //   63: iconst_0
    //   64: aload 5
    //   66: aastore
    //   67: aload 9
    //   69: iconst_1
    //   70: iload 4
    //   72: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aastore
    //   76: aload_0
    //   77: aload_1
    //   78: aload 9
    //   80: invokestatic 1213	gnu/kawa/slib/pregexp:pregexpMatchPositions$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: astore 10
    //   85: aload 10
    //   87: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   90: if_acmpeq +247 -> 337
    //   93: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   96: aload 10
    //   98: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: astore 17
    //   103: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   106: aload 17
    //   108: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: astore 18
    //   113: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   116: aload 17
    //   118: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: astore 19
    //   123: getstatic 870	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   126: aload 18
    //   128: aload 19
    //   130: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   136: if_acmpeq +87 -> 223
    //   139: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   142: aload 19
    //   144: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   147: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: astore 31
    //   152: aload_1
    //   153: checkcast 888	java/lang/CharSequence
    //   156: astore 33
    //   158: aload 5
    //   160: checkcast 890	java/lang/Number
    //   163: invokevirtual 894	java/lang/Number:intValue	()I
    //   166: istore 35
    //   168: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   171: aload 18
    //   173: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   176: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: astore 36
    //   181: aload 36
    //   183: checkcast 890	java/lang/Number
    //   186: invokevirtual 894	java/lang/Number:intValue	()I
    //   189: istore 38
    //   191: aload 33
    //   193: iload 35
    //   195: iload 38
    //   197: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   200: aload 8
    //   202: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   205: astore 39
    //   207: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   210: astore 7
    //   212: aload 39
    //   214: astore 8
    //   216: aload 31
    //   218: astore 5
    //   220: goto -190 -> 30
    //   223: getstatic 870	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   226: aload 18
    //   228: aload 5
    //   230: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: astore 20
    //   235: aload 20
    //   237: checkcast 371	java/lang/Boolean
    //   240: invokevirtual 880	java/lang/Boolean:booleanValue	()Z
    //   243: istore 22
    //   245: iload 22
    //   247: ifeq +27 -> 274
    //   250: aload 7
    //   252: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   255: if_acmpeq +24 -> 279
    //   258: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   261: astore 30
    //   263: aload 19
    //   265: astore 5
    //   267: aload 30
    //   269: astore 7
    //   271: goto -241 -> 30
    //   274: iload 22
    //   276: ifne -18 -> 258
    //   279: aload_1
    //   280: checkcast 888	java/lang/CharSequence
    //   283: astore 24
    //   285: aload 5
    //   287: checkcast 890	java/lang/Number
    //   290: invokevirtual 894	java/lang/Number:intValue	()I
    //   293: istore 26
    //   295: aload 18
    //   297: checkcast 890	java/lang/Number
    //   300: invokevirtual 894	java/lang/Number:intValue	()I
    //   303: istore 28
    //   305: aload 24
    //   307: iload 26
    //   309: iload 28
    //   311: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   314: aload 8
    //   316: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   319: astore 8
    //   321: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   324: astore 29
    //   326: aload 19
    //   328: astore 5
    //   330: aload 29
    //   332: astore 7
    //   334: goto -304 -> 30
    //   337: iload 4
    //   339: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: astore 11
    //   344: aload_1
    //   345: checkcast 888	java/lang/CharSequence
    //   348: astore 13
    //   350: aload 5
    //   352: checkcast 890	java/lang/Number
    //   355: invokevirtual 894	java/lang/Number:intValue	()I
    //   358: istore 15
    //   360: aload 13
    //   362: iload 15
    //   364: iload 4
    //   366: invokestatic 1094	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   369: aload 8
    //   371: invokestatic 1002	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   374: astore 16
    //   376: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   379: astore 7
    //   381: aload 16
    //   383: astore 8
    //   385: aload 11
    //   387: astore 5
    //   389: goto -359 -> 30
    //   392: astore_2
    //   393: new 911	gnu/mapping/WrongType
    //   396: dup
    //   397: aload_2
    //   398: ldc_w 1028
    //   401: iconst_1
    //   402: aload_1
    //   403: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   406: athrow
    //   407: astore 32
    //   409: new 911	gnu/mapping/WrongType
    //   412: dup
    //   413: aload 32
    //   415: ldc_w 1097
    //   418: iconst_1
    //   419: aload_1
    //   420: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   423: athrow
    //   424: astore 34
    //   426: new 911	gnu/mapping/WrongType
    //   429: dup
    //   430: aload 34
    //   432: ldc_w 1097
    //   435: iconst_2
    //   436: aload 5
    //   438: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   441: athrow
    //   442: astore 37
    //   444: new 911	gnu/mapping/WrongType
    //   447: dup
    //   448: aload 37
    //   450: ldc_w 1097
    //   453: iconst_3
    //   454: aload 36
    //   456: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   459: athrow
    //   460: astore 21
    //   462: new 911	gnu/mapping/WrongType
    //   465: dup
    //   466: aload 21
    //   468: ldc_w 913
    //   471: bipush 254
    //   473: aload 20
    //   475: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   478: athrow
    //   479: astore 23
    //   481: new 911	gnu/mapping/WrongType
    //   484: dup
    //   485: aload 23
    //   487: ldc_w 1097
    //   490: iconst_1
    //   491: aload_1
    //   492: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   495: athrow
    //   496: astore 25
    //   498: new 911	gnu/mapping/WrongType
    //   501: dup
    //   502: aload 25
    //   504: ldc_w 1097
    //   507: iconst_2
    //   508: aload 5
    //   510: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   513: athrow
    //   514: astore 27
    //   516: new 911	gnu/mapping/WrongType
    //   519: dup
    //   520: aload 27
    //   522: ldc_w 1097
    //   525: iconst_3
    //   526: aload 18
    //   528: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   531: athrow
    //   532: astore 12
    //   534: new 911	gnu/mapping/WrongType
    //   537: dup
    //   538: aload 12
    //   540: ldc_w 1097
    //   543: iconst_1
    //   544: aload_1
    //   545: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   548: athrow
    //   549: astore 14
    //   551: new 911	gnu/mapping/WrongType
    //   554: dup
    //   555: aload 14
    //   557: ldc_w 1097
    //   560: iconst_2
    //   561: aload 5
    //   563: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   566: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	392	java/lang/ClassCastException
    //   152	158	407	java/lang/ClassCastException
    //   158	168	424	java/lang/ClassCastException
    //   181	191	442	java/lang/ClassCastException
    //   235	245	460	java/lang/ClassCastException
    //   279	285	479	java/lang/ClassCastException
    //   285	295	496	java/lang/ClassCastException
    //   295	305	514	java/lang/ClassCastException
    //   344	350	532	java/lang/ClassCastException
    //   350	360	549	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpStringMatch(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 888	java/lang/CharSequence
    //   4: astore 7
    //   6: aload 7
    //   8: invokestatic 1014	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   11: istore 8
    //   13: getstatic 1245	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
    //   16: iload 8
    //   18: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aload_3
    //   22: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   28: if_acmpeq +12 -> 40
    //   31: getstatic 1249	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   34: aload 5
    //   36: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: areturn
    //   40: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   43: astore 9
    //   45: aload_2
    //   46: astore 10
    //   48: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   51: aload 9
    //   53: iload 8
    //   55: invokestatic 1020	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   64: if_acmpeq +14 -> 78
    //   67: getstatic 1249	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   70: aload 4
    //   72: aload 10
    //   74: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: areturn
    //   78: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   81: aload 10
    //   83: aload_3
    //   84: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   90: if_acmpeq +12 -> 102
    //   93: getstatic 1249	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   96: aload 5
    //   98: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   101: areturn
    //   102: aload_0
    //   103: checkcast 888	java/lang/CharSequence
    //   106: astore 12
    //   108: aload 9
    //   110: checkcast 890	java/lang/Number
    //   113: invokevirtual 894	java/lang/Number:intValue	()I
    //   116: istore 14
    //   118: aload 12
    //   120: iload 14
    //   122: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   125: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   128: astore 15
    //   130: aload_1
    //   131: checkcast 888	java/lang/CharSequence
    //   134: astore 17
    //   136: aload 10
    //   138: checkcast 890	java/lang/Number
    //   141: invokevirtual 894	java/lang/Number:intValue	()I
    //   144: istore 19
    //   146: aload 15
    //   148: aload 17
    //   150: iload 19
    //   152: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   155: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   158: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   161: ifeq +32 -> 193
    //   164: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   167: aload 9
    //   169: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   172: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: astore 9
    //   177: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   180: aload 10
    //   182: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   185: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: astore 10
    //   190: goto -142 -> 48
    //   193: getstatic 1249	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   196: aload 5
    //   198: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   201: areturn
    //   202: astore 6
    //   204: new 911	gnu/mapping/WrongType
    //   207: dup
    //   208: aload 6
    //   210: ldc_w 1028
    //   213: iconst_1
    //   214: aload_0
    //   215: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   218: athrow
    //   219: astore 11
    //   221: new 911	gnu/mapping/WrongType
    //   224: dup
    //   225: aload 11
    //   227: ldc_w 918
    //   230: iconst_1
    //   231: aload_0
    //   232: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   235: athrow
    //   236: astore 13
    //   238: new 911	gnu/mapping/WrongType
    //   241: dup
    //   242: aload 13
    //   244: ldc_w 918
    //   247: iconst_2
    //   248: aload 9
    //   250: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   253: athrow
    //   254: astore 16
    //   256: new 911	gnu/mapping/WrongType
    //   259: dup
    //   260: aload 16
    //   262: ldc_w 918
    //   265: iconst_1
    //   266: aload_1
    //   267: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   270: athrow
    //   271: astore 18
    //   273: new 911	gnu/mapping/WrongType
    //   276: dup
    //   277: aload 18
    //   279: ldc_w 918
    //   282: iconst_2
    //   283: aload 10
    //   285: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   288: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	202	java/lang/ClassCastException
    //   102	108	219	java/lang/ClassCastException
    //   108	118	236	java/lang/ClassCastException
    //   130	136	254	java/lang/ClassCastException
    //   136	146	271	java/lang/ClassCastException
  }

  // ERROR //
  public static Object pregexpWrapQuantifierIfAny(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   3: aload_0
    //   4: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: astore_3
    //   8: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   11: aload_0
    //   12: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: astore 4
    //   17: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   20: aload 4
    //   22: aload_2
    //   23: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   29: if_acmpeq +5 -> 34
    //   32: aload_0
    //   33: areturn
    //   34: aload_1
    //   35: checkcast 888	java/lang/CharSequence
    //   38: astore 6
    //   40: aload 4
    //   42: checkcast 890	java/lang/Number
    //   45: invokevirtual 894	java/lang/Number:intValue	()I
    //   48: istore 8
    //   50: aload 6
    //   52: iload 8
    //   54: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   57: istore 9
    //   59: iload 9
    //   61: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   64: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   67: istore 10
    //   69: iload 10
    //   71: ifeq +28 -> 99
    //   74: getstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   77: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   80: if_acmpne +24 -> 104
    //   83: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   86: aload 4
    //   88: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   91: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: astore 4
    //   96: goto -79 -> 17
    //   99: iload 10
    //   101: ifne -18 -> 83
    //   104: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   107: iload 9
    //   109: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   112: getstatic 290	gnu/kawa/slib/pregexp:Lit65	Lgnu/text/Char;
    //   115: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: astore 11
    //   120: aload 11
    //   122: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   125: if_acmpeq +195 -> 320
    //   128: aload 11
    //   130: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   133: if_acmpeq +219 -> 352
    //   136: getstatic 369	gnu/kawa/slib/pregexp:Lit68	Lgnu/mapping/SimpleSymbol;
    //   139: invokestatic 1185	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   142: astore 14
    //   144: aload 14
    //   146: getstatic 534	gnu/kawa/slib/pregexp:Lit69	Lgnu/mapping/SimpleSymbol;
    //   149: getstatic 530	gnu/kawa/slib/pregexp:Lit70	Lgnu/mapping/SimpleSymbol;
    //   152: getstatic 526	gnu/kawa/slib/pregexp:Lit71	Lgnu/mapping/SimpleSymbol;
    //   155: aload_3
    //   156: invokestatic 1253	gnu/lists/LList:chain4	(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   159: pop
    //   160: aload 14
    //   162: getstatic 522	gnu/kawa/slib/pregexp:Lit72	Lgnu/mapping/SimpleSymbol;
    //   165: invokestatic 1026	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   168: astore 16
    //   170: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   173: iload 9
    //   175: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   178: getstatic 290	gnu/kawa/slib/pregexp:Lit65	Lgnu/text/Char;
    //   181: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   187: if_acmpeq +225 -> 412
    //   190: getstatic 1256	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   193: aload 14
    //   195: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: astore 63
    //   200: aload 63
    //   202: checkcast 1050	gnu/lists/Pair
    //   205: astore 65
    //   207: aload 65
    //   209: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   212: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   215: getstatic 1259	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   218: aload 14
    //   220: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   223: astore 66
    //   225: aload 66
    //   227: checkcast 1050	gnu/lists/Pair
    //   230: astore 68
    //   232: aload 68
    //   234: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   237: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   240: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   243: aload 4
    //   245: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   248: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   251: astore 24
    //   253: getstatic 886	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   256: aload 24
    //   258: aload_2
    //   259: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   262: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   265: if_acmpeq +438 -> 703
    //   268: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   271: aload 14
    //   273: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   276: astore 43
    //   278: aload 43
    //   280: checkcast 1050	gnu/lists/Pair
    //   283: astore 45
    //   285: aload 45
    //   287: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   290: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   293: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   296: aload 16
    //   298: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   301: astore 46
    //   303: aload 46
    //   305: checkcast 1050	gnu/lists/Pair
    //   308: astore 48
    //   310: aload 48
    //   312: aload 24
    //   314: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   317: aload 16
    //   319: areturn
    //   320: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   323: iload 9
    //   325: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   328: getstatic 292	gnu/kawa/slib/pregexp:Lit66	Lgnu/text/Char;
    //   331: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   334: astore 12
    //   336: aload 12
    //   338: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   341: if_acmpeq +13 -> 354
    //   344: aload 12
    //   346: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   349: if_acmpne -213 -> 136
    //   352: aload_0
    //   353: areturn
    //   354: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   357: iload 9
    //   359: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   362: getstatic 288	gnu/kawa/slib/pregexp:Lit47	Lgnu/text/Char;
    //   365: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   368: astore 13
    //   370: aload 13
    //   372: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   375: if_acmpeq +14 -> 389
    //   378: aload 13
    //   380: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   383: if_acmpeq -31 -> 352
    //   386: goto -250 -> 136
    //   389: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   392: iload 9
    //   394: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   397: getstatic 304	gnu/kawa/slib/pregexp:Lit67	Lgnu/text/Char;
    //   400: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   403: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   406: if_acmpeq -54 -> 352
    //   409: goto -273 -> 136
    //   412: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   415: iload 9
    //   417: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   420: getstatic 292	gnu/kawa/slib/pregexp:Lit66	Lgnu/text/Char;
    //   423: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   426: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   429: if_acmpeq +56 -> 485
    //   432: getstatic 1256	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   435: aload 14
    //   437: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   440: astore 57
    //   442: aload 57
    //   444: checkcast 1050	gnu/lists/Pair
    //   447: astore 59
    //   449: aload 59
    //   451: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   454: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   457: getstatic 1259	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   460: aload 14
    //   462: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   465: astore 60
    //   467: aload 60
    //   469: checkcast 1050	gnu/lists/Pair
    //   472: astore 62
    //   474: aload 62
    //   476: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   479: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   482: goto -242 -> 240
    //   485: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   488: iload 9
    //   490: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   493: getstatic 288	gnu/kawa/slib/pregexp:Lit47	Lgnu/text/Char;
    //   496: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   502: if_acmpeq +56 -> 558
    //   505: getstatic 1256	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   508: aload 14
    //   510: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   513: astore 51
    //   515: aload 51
    //   517: checkcast 1050	gnu/lists/Pair
    //   520: astore 53
    //   522: aload 53
    //   524: getstatic 382	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
    //   527: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   530: getstatic 1259	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   533: aload 14
    //   535: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   538: astore 54
    //   540: aload 54
    //   542: checkcast 1050	gnu/lists/Pair
    //   545: astore 56
    //   547: aload 56
    //   549: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   552: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   555: goto -315 -> 240
    //   558: getstatic 945	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   561: iload 9
    //   563: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   566: getstatic 304	gnu/kawa/slib/pregexp:Lit67	Lgnu/text/Char;
    //   569: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   572: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   575: if_acmpeq -335 -> 240
    //   578: aload_1
    //   579: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   582: aload 4
    //   584: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   587: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   590: aload_2
    //   591: invokestatic 1261	gnu/kawa/slib/pregexp:pregexpReadNums	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   594: astore 17
    //   596: aload 17
    //   598: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   601: if_acmpne +29 -> 630
    //   604: iconst_2
    //   605: anewarray 965	java/lang/Object
    //   608: astore 49
    //   610: aload 49
    //   612: iconst_0
    //   613: getstatic 518	gnu/kawa/slib/pregexp:Lit74	Lgnu/mapping/SimpleSymbol;
    //   616: aastore
    //   617: aload 49
    //   619: iconst_1
    //   620: getstatic 514	gnu/kawa/slib/pregexp:Lit75	Lgnu/mapping/SimpleSymbol;
    //   623: aastore
    //   624: aload 49
    //   626: invokestatic 969	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   629: pop
    //   630: getstatic 1256	kawa/lib/lists:cddr	Lgnu/expr/GenericProc;
    //   633: aload 14
    //   635: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   638: astore 18
    //   640: aload 18
    //   642: checkcast 1050	gnu/lists/Pair
    //   645: astore 20
    //   647: aload 20
    //   649: getstatic 990	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   652: aload 17
    //   654: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   657: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   660: getstatic 1259	kawa/lib/lists:cdddr	Lgnu/expr/GenericProc;
    //   663: aload 14
    //   665: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   668: astore 21
    //   670: aload 21
    //   672: checkcast 1050	gnu/lists/Pair
    //   675: astore 23
    //   677: aload 23
    //   679: getstatic 1164	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
    //   682: aload 17
    //   684: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   687: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   690: getstatic 1264	kawa/lib/lists:caddr	Lgnu/expr/GenericProc;
    //   693: aload 17
    //   695: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   698: astore 4
    //   700: goto -460 -> 240
    //   703: aload_1
    //   704: checkcast 888	java/lang/CharSequence
    //   707: astore 26
    //   709: aload 24
    //   711: checkcast 890	java/lang/Number
    //   714: invokevirtual 894	java/lang/Number:intValue	()I
    //   717: istore 28
    //   719: aload 26
    //   721: iload 28
    //   723: invokestatic 900	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   726: istore 29
    //   728: iload 29
    //   730: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   733: invokestatic 954	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   736: istore 30
    //   738: iload 30
    //   740: ifeq +28 -> 768
    //   743: getstatic 1010	gnu/kawa/slib/pregexp:$Stpregexp$Mnspace$Mnsensitive$Qu$St	Ljava/lang/Object;
    //   746: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   749: if_acmpne +24 -> 773
    //   752: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   755: aload 24
    //   757: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   760: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   763: astore 24
    //   765: goto -512 -> 253
    //   768: iload 30
    //   770: ifne -18 -> 752
    //   773: iload 29
    //   775: invokestatic 282	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   778: getstatic 288	gnu/kawa/slib/pregexp:Lit47	Lgnu/text/Char;
    //   781: invokestatic 935	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   784: ifeq +64 -> 848
    //   787: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   790: aload 14
    //   792: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   795: astore 37
    //   797: aload 37
    //   799: checkcast 1050	gnu/lists/Pair
    //   802: astore 39
    //   804: aload 39
    //   806: getstatic 883	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   809: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   812: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   815: aload 16
    //   817: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   820: astore 40
    //   822: aload 40
    //   824: checkcast 1050	gnu/lists/Pair
    //   827: astore 42
    //   829: aload 42
    //   831: getstatic 1075	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   834: aload 24
    //   836: getstatic 676	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
    //   839: invokevirtual 876	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   842: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   845: goto -528 -> 317
    //   848: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   851: aload 14
    //   853: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   856: astore 31
    //   858: aload 31
    //   860: checkcast 1050	gnu/lists/Pair
    //   863: astore 33
    //   865: aload 33
    //   867: getstatic 375	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   870: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   873: getstatic 996	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   876: aload 16
    //   878: invokevirtual 993	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   881: astore 34
    //   883: aload 34
    //   885: checkcast 1050	gnu/lists/Pair
    //   888: astore 36
    //   890: aload 36
    //   892: aload 24
    //   894: invokestatic 1066	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   897: goto -580 -> 317
    //   900: astore 5
    //   902: new 911	gnu/mapping/WrongType
    //   905: dup
    //   906: aload 5
    //   908: ldc_w 918
    //   911: iconst_1
    //   912: aload_1
    //   913: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   916: athrow
    //   917: astore 7
    //   919: new 911	gnu/mapping/WrongType
    //   922: dup
    //   923: aload 7
    //   925: ldc_w 918
    //   928: iconst_2
    //   929: aload 4
    //   931: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   934: athrow
    //   935: astore 64
    //   937: new 911	gnu/mapping/WrongType
    //   940: dup
    //   941: aload 64
    //   943: ldc_w 1068
    //   946: iconst_1
    //   947: aload 63
    //   949: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   952: athrow
    //   953: astore 67
    //   955: new 911	gnu/mapping/WrongType
    //   958: dup
    //   959: aload 67
    //   961: ldc_w 1068
    //   964: iconst_1
    //   965: aload 66
    //   967: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   970: athrow
    //   971: astore 58
    //   973: new 911	gnu/mapping/WrongType
    //   976: dup
    //   977: aload 58
    //   979: ldc_w 1068
    //   982: iconst_1
    //   983: aload 57
    //   985: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   988: athrow
    //   989: astore 61
    //   991: new 911	gnu/mapping/WrongType
    //   994: dup
    //   995: aload 61
    //   997: ldc_w 1068
    //   1000: iconst_1
    //   1001: aload 60
    //   1003: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1006: athrow
    //   1007: astore 52
    //   1009: new 911	gnu/mapping/WrongType
    //   1012: dup
    //   1013: aload 52
    //   1015: ldc_w 1068
    //   1018: iconst_1
    //   1019: aload 51
    //   1021: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1024: athrow
    //   1025: astore 55
    //   1027: new 911	gnu/mapping/WrongType
    //   1030: dup
    //   1031: aload 55
    //   1033: ldc_w 1068
    //   1036: iconst_1
    //   1037: aload 54
    //   1039: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1042: athrow
    //   1043: astore 19
    //   1045: new 911	gnu/mapping/WrongType
    //   1048: dup
    //   1049: aload 19
    //   1051: ldc_w 1068
    //   1054: iconst_1
    //   1055: aload 18
    //   1057: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1060: athrow
    //   1061: astore 22
    //   1063: new 911	gnu/mapping/WrongType
    //   1066: dup
    //   1067: aload 22
    //   1069: ldc_w 1068
    //   1072: iconst_1
    //   1073: aload 21
    //   1075: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1078: athrow
    //   1079: astore 44
    //   1081: new 911	gnu/mapping/WrongType
    //   1084: dup
    //   1085: aload 44
    //   1087: ldc_w 1068
    //   1090: iconst_1
    //   1091: aload 43
    //   1093: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1096: athrow
    //   1097: astore 47
    //   1099: new 911	gnu/mapping/WrongType
    //   1102: dup
    //   1103: aload 47
    //   1105: ldc_w 1068
    //   1108: iconst_1
    //   1109: aload 46
    //   1111: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1114: athrow
    //   1115: astore 25
    //   1117: new 911	gnu/mapping/WrongType
    //   1120: dup
    //   1121: aload 25
    //   1123: ldc_w 918
    //   1126: iconst_1
    //   1127: aload_1
    //   1128: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1131: athrow
    //   1132: astore 27
    //   1134: new 911	gnu/mapping/WrongType
    //   1137: dup
    //   1138: aload 27
    //   1140: ldc_w 918
    //   1143: iconst_2
    //   1144: aload 24
    //   1146: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1149: athrow
    //   1150: astore 38
    //   1152: new 911	gnu/mapping/WrongType
    //   1155: dup
    //   1156: aload 38
    //   1158: ldc_w 1068
    //   1161: iconst_1
    //   1162: aload 37
    //   1164: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1167: athrow
    //   1168: astore 41
    //   1170: new 911	gnu/mapping/WrongType
    //   1173: dup
    //   1174: aload 41
    //   1176: ldc_w 1068
    //   1179: iconst_1
    //   1180: aload 40
    //   1182: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1185: athrow
    //   1186: astore 32
    //   1188: new 911	gnu/mapping/WrongType
    //   1191: dup
    //   1192: aload 32
    //   1194: ldc_w 1068
    //   1197: iconst_1
    //   1198: aload 31
    //   1200: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1203: athrow
    //   1204: astore 35
    //   1206: new 911	gnu/mapping/WrongType
    //   1209: dup
    //   1210: aload 35
    //   1212: ldc_w 1068
    //   1215: iconst_1
    //   1216: aload 34
    //   1218: invokespecial 916	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1221: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   34	40	900	java/lang/ClassCastException
    //   40	50	917	java/lang/ClassCastException
    //   200	207	935	java/lang/ClassCastException
    //   225	232	953	java/lang/ClassCastException
    //   442	449	971	java/lang/ClassCastException
    //   467	474	989	java/lang/ClassCastException
    //   515	522	1007	java/lang/ClassCastException
    //   540	547	1025	java/lang/ClassCastException
    //   640	647	1043	java/lang/ClassCastException
    //   670	677	1061	java/lang/ClassCastException
    //   278	285	1079	java/lang/ClassCastException
    //   303	310	1097	java/lang/ClassCastException
    //   703	709	1115	java/lang/ClassCastException
    //   709	719	1132	java/lang/ClassCastException
    //   797	804	1150	java/lang/ClassCastException
    //   822	829	1168	java/lang/ClassCastException
    //   858	865	1186	java/lang/ClassCastException
    //   883	890	1204	java/lang/ClassCastException
  }

  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply0(paramModuleMethod);
    case 36:
      return frame.lambda4();
    case 37:
      return frame0.lambda13();
    case 38:
      return frame0.lambda14();
    case 39:
      return frame0.lambda15();
    case 40:
      return frame0.lambda16();
    case 41:
    }
    return frame0.lambda17();
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply1(paramModuleMethod, paramObject);
    case 16:
      return pregexpReverse$Ex(paramObject);
    case 28:
      return pregexpInvertCharList(paramObject);
    case 31:
      if (isPregexpCharWord(paramObject))
        return Boolean.TRUE;
      return Boolean.FALSE;
    case 35:
      return pregexpMakeBackrefList(paramObject);
    case 44:
      return pregexp(paramObject);
    case 50:
    }
    return pregexpQuote(paramObject);
  }

  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 33:
      return isPregexpCheckIfInCharClass(paramObject1, paramObject2);
    case 34:
      return pregexpListRef(paramObject1, paramObject2);
    case 47:
    }
    return pregexpSplit(paramObject1, paramObject2);
  }

  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    case 28:
    case 30:
    case 31:
    case 33:
    case 34:
    case 35:
    case 36:
    case 37:
    case 38:
    case 39:
    case 40:
    case 41:
    case 42:
    case 43:
    case 44:
    case 45:
    case 46:
    case 47:
    default:
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    case 18:
      return pregexpReadPattern(paramObject1, paramObject2, paramObject3);
    case 19:
      return pregexpReadBranch(paramObject1, paramObject2, paramObject3);
    case 20:
      return pregexpReadPiece(paramObject1, paramObject2, paramObject3);
    case 21:
      return pregexpReadEscapedNumber(paramObject1, paramObject2, paramObject3);
    case 22:
      return pregexpReadEscapedChar(paramObject1, paramObject2, paramObject3);
    case 23:
      return pregexpReadPosixCharClass(paramObject1, paramObject2, paramObject3);
    case 24:
      return pregexpReadClusterType(paramObject1, paramObject2, paramObject3);
    case 25:
      return pregexpReadSubpattern(paramObject1, paramObject2, paramObject3);
    case 26:
      return pregexpWrapQuantifierIfAny(paramObject1, paramObject2, paramObject3);
    case 27:
      return pregexpReadNums(paramObject1, paramObject2, paramObject3);
    case 29:
      return pregexpReadCharList(paramObject1, paramObject2, paramObject3);
    case 32:
      return isPregexpAtWordBoundary(paramObject1, paramObject2, paramObject3);
    case 48:
      return pregexpReplace(paramObject1, paramObject2, paramObject3);
    case 49:
    }
    return pregexpReplace$St(paramObject1, paramObject2, paramObject3);
  }

  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramModuleMethod.selector == 43)
      return pregexpReplaceAux(paramObject1, paramObject2, paramObject3, paramObject4);
    return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 17:
      return pregexpError$V(paramArrayOfObject);
    case 30:
      return pregexpStringMatch(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    case 42:
      return pregexpMatchPositionsAux(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4], paramArrayOfObject[5]);
    case 45:
      Object localObject3 = paramArrayOfObject[0];
      Object localObject4 = paramArrayOfObject[1];
      int k = paramArrayOfObject.length - 2;
      Object[] arrayOfObject2 = new Object[k];
      int m = k;
      while (true)
      {
        m--;
        if (m < 0)
          return pregexpMatchPositions$V(localObject3, localObject4, arrayOfObject2);
        arrayOfObject2[m] = paramArrayOfObject[(m + 2)];
      }
    case 46:
    }
    Object localObject1 = paramArrayOfObject[0];
    Object localObject2 = paramArrayOfObject[1];
    int i = paramArrayOfObject.length - 2;
    Object[] arrayOfObject1 = new Object[i];
    int j = i;
    while (true)
    {
      j--;
      if (j < 0)
        return pregexpMatch$V(localObject1, localObject2, arrayOfObject1);
      arrayOfObject1[j] = paramArrayOfObject[(j + 2)];
    }
  }

  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match0(paramModuleMethod, paramCallContext);
    case 41:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 40:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 39:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 38:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 37:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 36:
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 50:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 44:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 35:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 31:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 16:
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
    case 47:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 34:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 33:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 28:
    case 30:
    case 31:
    case 33:
    case 34:
    case 35:
    case 36:
    case 37:
    case 38:
    case 39:
    case 40:
    case 41:
    case 42:
    case 43:
    case 44:
    case 45:
    case 46:
    case 47:
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 49:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 48:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 32:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 29:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 27:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 26:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 25:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 24:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 23:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 22:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 21:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 20:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 19:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 18:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }

  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 43)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 46:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 45:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 42:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 30:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 17:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
    $Stpregexp$Mnversion$St = Lit0;
    $Stpregexp$Mncomment$Mnchar$St = Lit1;
    $Stpregexp$Mnnul$Mnchar$Mnint$St = Integer.valueOf(characters.char$To$Integer(Lit2) - 97);
    $Stpregexp$Mnreturn$Mnchar$St = characters.integer$To$Char(13 + ((Number)$Stpregexp$Mnnul$Mnchar$Mnint$St).intValue());
    $Stpregexp$Mntab$Mnchar$St = characters.integer$To$Char(9 + ((Number)$Stpregexp$Mnnul$Mnchar$Mnint$St).intValue());
    $Stpregexp$Mnspace$Mnsensitive$Qu$St = Boolean.TRUE;
  }

  public class frame extends ModuleBody
  {
    Object backrefs;
    Object case$Mnsensitive$Qu;
    Procedure identity;
    Object n;
    Object s;
    Object sn;
    Object start;

    public frame()
    {
      this$1 = new ModuleMethod(this, 15, pregexp.Lit112, 4097);
      this$1.setProperty("source-location", "pregexp.scm:460");
      this.identity = this$1;
    }

    public static Object lambda2identity(Object paramObject)
    {
      return paramObject;
    }

    static Boolean lambda4()
    {
      return Boolean.FALSE;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 15)
        return lambda2identity(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    // ERROR //
    public Object lambda3sub(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      // Byte code:
      //   0: new 66	gnu/kawa/slib/pregexp$frame0
      //   3: dup
      //   4: invokespecial 67	gnu/kawa/slib/pregexp$frame0:<init>	()V
      //   7: astore 5
      //   9: aload 5
      //   11: aload_0
      //   12: putfield 71	gnu/kawa/slib/pregexp$frame0:staticLink	Lgnu/kawa/slib/pregexp$frame;
      //   15: aload 5
      //   17: aload_1
      //   18: putfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   21: aload 5
      //   23: aload_2
      //   24: putfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   27: aload 5
      //   29: aload_3
      //   30: putfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   33: aload 5
      //   35: aload 4
      //   37: putfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   40: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   43: aload 5
      //   45: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   48: getstatic 92	gnu/kawa/slib/pregexp:Lit10	Lgnu/mapping/SimpleSymbol;
      //   51: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   54: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   57: if_acmpeq +53 -> 110
      //   60: getstatic 102	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   63: aload 5
      //   65: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   68: aload_0
      //   69: getfield 104	gnu/kawa/slib/pregexp$frame:start	Ljava/lang/Object;
      //   72: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   75: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   78: if_acmpeq +20 -> 98
      //   81: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   84: aload 5
      //   86: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   89: aload 5
      //   91: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   94: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   97: areturn
      //   98: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   101: aload 5
      //   103: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   106: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   109: areturn
      //   110: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   113: aload 5
      //   115: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   118: getstatic 113	gnu/kawa/slib/pregexp:Lit12	Lgnu/mapping/SimpleSymbol;
      //   121: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   124: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   127: if_acmpeq +53 -> 180
      //   130: getstatic 116	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   133: aload 5
      //   135: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   138: aload_0
      //   139: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   142: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   145: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   148: if_acmpeq +20 -> 168
      //   151: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   154: aload 5
      //   156: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   159: aload 5
      //   161: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   164: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   167: areturn
      //   168: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   171: aload 5
      //   173: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   176: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   179: areturn
      //   180: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   183: aload 5
      //   185: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   188: getstatic 121	gnu/kawa/slib/pregexp:Lit23	Lgnu/mapping/SimpleSymbol;
      //   191: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   194: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   197: if_acmpeq +20 -> 217
      //   200: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   203: aload 5
      //   205: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   208: aload 5
      //   210: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   213: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   216: areturn
      //   217: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   220: aload 5
      //   222: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   225: getstatic 124	gnu/kawa/slib/pregexp:Lit26	Lgnu/mapping/SimpleSymbol;
      //   228: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   231: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   234: if_acmpeq +54 -> 288
      //   237: aload_0
      //   238: getfield 126	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   241: aload 5
      //   243: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   246: aload_0
      //   247: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   250: invokestatic 130	gnu/kawa/slib/pregexp:isPregexpAtWordBoundary	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   253: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   256: if_acmpeq +20 -> 276
      //   259: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   262: aload 5
      //   264: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   267: aload 5
      //   269: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   272: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   275: areturn
      //   276: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   279: aload 5
      //   281: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   284: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   287: areturn
      //   288: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   291: aload 5
      //   293: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   296: getstatic 133	gnu/kawa/slib/pregexp:Lit28	Lgnu/mapping/SimpleSymbol;
      //   299: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   302: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   305: if_acmpeq +54 -> 359
      //   308: aload_0
      //   309: getfield 126	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   312: aload 5
      //   314: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   317: aload_0
      //   318: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   321: invokestatic 130	gnu/kawa/slib/pregexp:isPregexpAtWordBoundary	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   324: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   327: if_acmpeq +15 -> 342
      //   330: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   333: aload 5
      //   335: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   338: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   341: areturn
      //   342: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   345: aload 5
      //   347: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   350: aload 5
      //   352: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   355: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   358: areturn
      //   359: aload 5
      //   361: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   364: invokestatic 139	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
      //   367: istore 6
      //   369: iload 6
      //   371: ifeq +121 -> 492
      //   374: getstatic 142	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   377: aload 5
      //   379: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   382: aload_0
      //   383: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   386: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   389: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   392: if_acmpeq +105 -> 497
      //   395: aload_0
      //   396: getfield 144	gnu/kawa/slib/pregexp$frame:case$Mnsensitive$Qu	Ljava/lang/Object;
      //   399: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   402: if_acmpeq +215 -> 617
      //   405: getstatic 148	kawa/lib/characters:char$Eq$Qu	Lgnu/expr/ModuleMethod;
      //   408: astore 66
      //   410: aload_0
      //   411: getfield 126	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   414: astore 67
      //   416: aload 67
      //   418: checkcast 150	java/lang/CharSequence
      //   421: astore 70
      //   423: aload 5
      //   425: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   428: astore 71
      //   430: aload 71
      //   432: checkcast 152	java/lang/Number
      //   435: invokevirtual 156	java/lang/Number:intValue	()I
      //   438: istore 74
      //   440: aload 66
      //   442: aload 70
      //   444: iload 74
      //   446: invokestatic 162	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   449: invokestatic 168	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   452: aload 5
      //   454: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   457: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   460: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   463: if_acmpeq +162 -> 625
      //   466: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   469: aload 5
      //   471: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   474: getstatic 174	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   477: aload 5
      //   479: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   482: getstatic 178	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
      //   485: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   488: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   491: areturn
      //   492: iload 6
      //   494: ifne -99 -> 395
      //   497: iconst_1
      //   498: iconst_1
      //   499: aload 5
      //   501: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   504: invokestatic 183	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   507: iadd
      //   508: iand
      //   509: istore 7
      //   511: iload 7
      //   513: ifeq +124 -> 637
      //   516: getstatic 142	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   519: aload 5
      //   521: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   524: aload_0
      //   525: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   528: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   531: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   534: if_acmpeq +108 -> 642
      //   537: aload_0
      //   538: getfield 126	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   541: astore 58
      //   543: aload 58
      //   545: checkcast 150	java/lang/CharSequence
      //   548: astore 61
      //   550: aload 5
      //   552: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   555: astore 62
      //   557: aload 62
      //   559: checkcast 152	java/lang/Number
      //   562: invokevirtual 156	java/lang/Number:intValue	()I
      //   565: istore 65
      //   567: aload 61
      //   569: iload 65
      //   571: invokestatic 162	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   574: invokestatic 168	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   577: aload 5
      //   579: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   582: invokestatic 186	gnu/kawa/slib/pregexp:isPregexpCheckIfInCharClass	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   585: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   588: if_acmpeq +258 -> 846
      //   591: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   594: aload 5
      //   596: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   599: getstatic 174	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   602: aload 5
      //   604: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   607: getstatic 178	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
      //   610: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   613: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   616: areturn
      //   617: getstatic 191	kawa/lib/rnrs/unicode:char$Mnci$Eq$Qu	Lgnu/expr/ModuleMethod;
      //   620: astore 66
      //   622: goto -212 -> 410
      //   625: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   628: aload 5
      //   630: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   633: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   636: areturn
      //   637: iload 7
      //   639: ifne -102 -> 537
      //   642: aload 5
      //   644: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   647: invokestatic 183	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   650: istore 8
      //   652: iload 8
      //   654: ifeq +286 -> 940
      //   657: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   660: getstatic 195	kawa/lib/lists:car	Lgnu/expr/GenericProc;
      //   663: aload 5
      //   665: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   668: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   671: getstatic 198	gnu/kawa/slib/pregexp:Lit83	Lgnu/mapping/SimpleSymbol;
      //   674: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   677: astore 57
      //   679: aload 57
      //   681: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   684: if_acmpeq +174 -> 858
      //   687: getstatic 142	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   690: aload 5
      //   692: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   695: aload_0
      //   696: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   699: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   702: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   705: if_acmpeq +161 -> 866
      //   708: aload_0
      //   709: getfield 126	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   712: astore 9
      //   714: aload 9
      //   716: checkcast 150	java/lang/CharSequence
      //   719: astore 12
      //   721: aload 5
      //   723: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   726: astore 13
      //   728: aload 13
      //   730: checkcast 152	java/lang/Number
      //   733: invokevirtual 156	java/lang/Number:intValue	()I
      //   736: istore 16
      //   738: aload 12
      //   740: iload 16
      //   742: invokestatic 162	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   745: istore 17
      //   747: aload_0
      //   748: getfield 144	gnu/kawa/slib/pregexp$frame:case$Mnsensitive$Qu	Ljava/lang/Object;
      //   751: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   754: if_acmpeq +194 -> 948
      //   757: getstatic 201	kawa/lib/characters:char$Ls$Eq$Qu	Lgnu/expr/ModuleMethod;
      //   760: astore 18
      //   762: aload 18
      //   764: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   767: aload 5
      //   769: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   772: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   775: iload 17
      //   777: invokestatic 168	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   780: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   783: astore 19
      //   785: aload 19
      //   787: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   790: if_acmpeq +166 -> 956
      //   793: aload 18
      //   795: iload 17
      //   797: invokestatic 168	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   800: getstatic 207	kawa/lib/lists:caddr	Lgnu/expr/GenericProc;
      //   803: aload 5
      //   805: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   808: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   811: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   814: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   817: if_acmpeq +147 -> 964
      //   820: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   823: aload 5
      //   825: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   828: getstatic 174	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   831: aload 5
      //   833: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   836: getstatic 178	gnu/kawa/slib/pregexp:Lit8	Lgnu/math/IntNum;
      //   839: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   842: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   845: areturn
      //   846: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   849: aload 5
      //   851: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   854: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   857: areturn
      //   858: aload 57
      //   860: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   863: if_acmpne -155 -> 708
      //   866: aload 5
      //   868: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   871: invokestatic 183	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   874: ifeq +1430 -> 2304
      //   877: getstatic 195	kawa/lib/lists:car	Lgnu/expr/GenericProc;
      //   880: aload 5
      //   882: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   885: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   888: astore 21
      //   890: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   893: aload 21
      //   895: getstatic 198	gnu/kawa/slib/pregexp:Lit83	Lgnu/mapping/SimpleSymbol;
      //   898: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   901: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   904: if_acmpeq +91 -> 995
      //   907: getstatic 116	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   910: aload 5
      //   912: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   915: aload_0
      //   916: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   919: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   922: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   925: if_acmpeq +51 -> 976
      //   928: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   931: aload 5
      //   933: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   936: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   939: areturn
      //   940: iload 8
      //   942: ifeq -76 -> 866
      //   945: goto -237 -> 708
      //   948: getstatic 210	kawa/lib/rnrs/unicode:char$Mnci$Ls$Eq$Qu	Lgnu/expr/ModuleMethod;
      //   951: astore 18
      //   953: goto -191 -> 762
      //   956: aload 19
      //   958: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   961: if_acmpne -141 -> 820
      //   964: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   967: aload 5
      //   969: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   972: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   975: areturn
      //   976: iconst_1
      //   977: anewarray 212	java/lang/Object
      //   980: astore 56
      //   982: aload 56
      //   984: iconst_0
      //   985: getstatic 215	gnu/kawa/slib/pregexp:Lit101	Lgnu/mapping/SimpleSymbol;
      //   988: aastore
      //   989: aload 56
      //   991: invokestatic 219	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   994: areturn
      //   995: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   998: aload 21
      //   1000: getstatic 222	gnu/kawa/slib/pregexp:Lit82	Lgnu/mapping/SimpleSymbol;
      //   1003: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1006: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1009: if_acmpeq +53 -> 1062
      //   1012: getstatic 116	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   1015: aload 5
      //   1017: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1020: aload_0
      //   1021: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1024: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1027: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1030: if_acmpeq +15 -> 1045
      //   1033: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1036: aload 5
      //   1038: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1041: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1044: areturn
      //   1045: aload 5
      //   1047: getstatic 225	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   1050: aload 5
      //   1052: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1055: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1058: invokevirtual 228	gnu/kawa/slib/pregexp$frame0:lambda5loupOneOfChars	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1061: areturn
      //   1062: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1065: aload 21
      //   1067: getstatic 231	gnu/kawa/slib/pregexp:Lit17	Lgnu/mapping/SimpleSymbol;
      //   1070: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1073: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1076: if_acmpeq +67 -> 1143
      //   1079: getstatic 116	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   1082: aload 5
      //   1084: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1087: aload_0
      //   1088: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1091: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1094: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1097: if_acmpeq +15 -> 1112
      //   1100: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1103: aload 5
      //   1105: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1108: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1111: areturn
      //   1112: aload_0
      //   1113: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   1116: aload 5
      //   1118: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1121: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1124: aload 5
      //   1126: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1129: aload 5
      //   1131: getfield 234	gnu/kawa/slib/pregexp$frame0:lambda$Fn2	Lgnu/expr/ModuleMethod;
      //   1134: aload 5
      //   1136: getfield 237	gnu/kawa/slib/pregexp$frame0:lambda$Fn3	Lgnu/expr/ModuleMethod;
      //   1139: invokevirtual 239	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1142: areturn
      //   1143: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1146: aload 21
      //   1148: getstatic 242	gnu/kawa/slib/pregexp:Lit5	Lgnu/mapping/SimpleSymbol;
      //   1151: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1154: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1157: if_acmpeq +25 -> 1182
      //   1160: aload 5
      //   1162: getstatic 225	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   1165: aload 5
      //   1167: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1170: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1173: aload 5
      //   1175: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1178: invokevirtual 245	gnu/kawa/slib/pregexp$frame0:lambda6loupSeq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1181: areturn
      //   1182: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1185: aload 21
      //   1187: getstatic 248	gnu/kawa/slib/pregexp:Lit4	Lgnu/mapping/SimpleSymbol;
      //   1190: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1193: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1196: if_acmpeq +20 -> 1216
      //   1199: aload 5
      //   1201: getstatic 225	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   1204: aload 5
      //   1206: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1209: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1212: invokevirtual 251	gnu/kawa/slib/pregexp$frame0:lambda7loupOr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1215: areturn
      //   1216: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1219: aload 21
      //   1221: getstatic 254	gnu/kawa/slib/pregexp:Lit20	Lgnu/mapping/SimpleSymbol;
      //   1224: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1227: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1230: if_acmpeq +198 -> 1428
      //   1233: aload_0
      //   1234: getfield 256	gnu/kawa/slib/pregexp$frame:backrefs	Ljava/lang/Object;
      //   1237: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   1240: aload 5
      //   1242: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1245: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1248: invokestatic 259	gnu/kawa/slib/pregexp:pregexpListRef	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1251: astore 40
      //   1253: aload 40
      //   1255: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1258: if_acmpeq +110 -> 1368
      //   1261: getstatic 225	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   1264: aload 40
      //   1266: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1269: astore 43
      //   1271: aload 43
      //   1273: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1276: if_acmpeq +135 -> 1411
      //   1279: aload_0
      //   1280: getfield 126	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   1283: astore 44
      //   1285: aload 44
      //   1287: checkcast 150	java/lang/CharSequence
      //   1290: astore 47
      //   1292: getstatic 195	kawa/lib/lists:car	Lgnu/expr/GenericProc;
      //   1295: aload 43
      //   1297: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1300: astore 48
      //   1302: aload 48
      //   1304: checkcast 152	java/lang/Number
      //   1307: invokevirtual 156	java/lang/Number:intValue	()I
      //   1310: istore 51
      //   1312: getstatic 225	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   1315: aload 43
      //   1317: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1320: astore 52
      //   1322: aload 52
      //   1324: checkcast 152	java/lang/Number
      //   1327: invokevirtual 156	java/lang/Number:intValue	()I
      //   1330: istore 55
      //   1332: aload 47
      //   1334: iload 51
      //   1336: iload 55
      //   1338: invokestatic 263	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   1341: aload_0
      //   1342: getfield 126	gnu/kawa/slib/pregexp$frame:s	Ljava/lang/Object;
      //   1345: aload 5
      //   1347: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1350: aload_0
      //   1351: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1354: aload 5
      //   1356: getfield 266	gnu/kawa/slib/pregexp$frame0:lambda$Fn4	Lgnu/expr/ModuleMethod;
      //   1359: aload 5
      //   1361: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1364: invokestatic 270	gnu/kawa/slib/pregexp:pregexpStringMatch	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1367: areturn
      //   1368: iconst_3
      //   1369: anewarray 212	java/lang/Object
      //   1372: astore 41
      //   1374: aload 41
      //   1376: iconst_0
      //   1377: getstatic 215	gnu/kawa/slib/pregexp:Lit101	Lgnu/mapping/SimpleSymbol;
      //   1380: aastore
      //   1381: aload 41
      //   1383: iconst_1
      //   1384: getstatic 273	gnu/kawa/slib/pregexp:Lit102	Lgnu/mapping/SimpleSymbol;
      //   1387: aastore
      //   1388: aload 41
      //   1390: iconst_2
      //   1391: aload 5
      //   1393: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1396: aastore
      //   1397: aload 41
      //   1399: invokestatic 219	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   1402: pop
      //   1403: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1406: astore 43
      //   1408: goto -137 -> 1271
      //   1411: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1414: aload 5
      //   1416: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   1419: aload 5
      //   1421: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1424: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1427: areturn
      //   1428: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1431: aload 21
      //   1433: getstatic 276	gnu/kawa/slib/pregexp:Lit100	Lgnu/mapping/SimpleSymbol;
      //   1436: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1439: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1442: if_acmpeq +34 -> 1476
      //   1445: aload_0
      //   1446: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   1449: aload 5
      //   1451: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1454: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1457: aload 5
      //   1459: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1462: aload 5
      //   1464: getfield 279	gnu/kawa/slib/pregexp$frame0:lambda$Fn5	Lgnu/expr/ModuleMethod;
      //   1467: aload 5
      //   1469: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1472: invokevirtual 239	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1475: areturn
      //   1476: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1479: aload 21
      //   1481: getstatic 282	gnu/kawa/slib/pregexp:Lit103	Lgnu/mapping/SimpleSymbol;
      //   1484: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1487: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1490: if_acmpeq +65 -> 1555
      //   1493: aload_0
      //   1494: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   1497: aload 5
      //   1499: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1502: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1505: aload 5
      //   1507: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1510: aload_0
      //   1511: getfield 40	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
      //   1514: getstatic 285	gnu/kawa/slib/pregexp:lambda$Fn6	Lgnu/expr/ModuleMethod;
      //   1517: invokevirtual 239	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1520: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1523: if_acmpeq +20 -> 1543
      //   1526: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1529: aload 5
      //   1531: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   1534: aload 5
      //   1536: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1539: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1542: areturn
      //   1543: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1546: aload 5
      //   1548: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1551: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1554: areturn
      //   1555: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1558: aload 21
      //   1560: getstatic 288	gnu/kawa/slib/pregexp:Lit104	Lgnu/mapping/SimpleSymbol;
      //   1563: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1566: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1569: if_acmpeq +65 -> 1634
      //   1572: aload_0
      //   1573: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   1576: aload 5
      //   1578: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1581: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1584: aload 5
      //   1586: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1589: aload_0
      //   1590: getfield 40	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
      //   1593: getstatic 291	gnu/kawa/slib/pregexp:lambda$Fn7	Lgnu/expr/ModuleMethod;
      //   1596: invokevirtual 239	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1599: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1602: if_acmpeq +15 -> 1617
      //   1605: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1608: aload 5
      //   1610: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1613: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1616: areturn
      //   1617: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1620: aload 5
      //   1622: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   1625: aload 5
      //   1627: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1630: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1633: areturn
      //   1634: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1637: aload 21
      //   1639: getstatic 294	gnu/kawa/slib/pregexp:Lit105	Lgnu/mapping/SimpleSymbol;
      //   1642: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1645: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1648: if_acmpeq +121 -> 1769
      //   1651: aload_0
      //   1652: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1655: astore 37
      //   1657: aload_0
      //   1658: getfield 296	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1661: astore 38
      //   1663: aload_0
      //   1664: aload 5
      //   1666: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1669: putfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1672: aload_0
      //   1673: aload 5
      //   1675: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1678: putfield 296	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1681: aload_0
      //   1682: getstatic 242	gnu/kawa/slib/pregexp:Lit5	Lgnu/mapping/SimpleSymbol;
      //   1685: getstatic 300	gnu/kawa/slib/pregexp:Lit106	Lgnu/lists/PairWithPosition;
      //   1688: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   1691: aload 5
      //   1693: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1696: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1699: getstatic 113	gnu/kawa/slib/pregexp:Lit12	Lgnu/mapping/SimpleSymbol;
      //   1702: invokestatic 306	gnu/lists/LList:list4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   1705: getstatic 309	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
      //   1708: aload_0
      //   1709: getfield 40	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
      //   1712: getstatic 312	gnu/kawa/slib/pregexp:lambda$Fn8	Lgnu/expr/ModuleMethod;
      //   1715: invokevirtual 239	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1718: astore 39
      //   1720: aload_0
      //   1721: aload 37
      //   1723: putfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1726: aload_0
      //   1727: aload 38
      //   1729: putfield 296	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1732: aload 39
      //   1734: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1737: if_acmpeq +20 -> 1757
      //   1740: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1743: aload 5
      //   1745: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   1748: aload 5
      //   1750: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1753: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1756: areturn
      //   1757: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1760: aload 5
      //   1762: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1765: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1768: areturn
      //   1769: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1772: aload 21
      //   1774: getstatic 315	gnu/kawa/slib/pregexp:Lit107	Lgnu/mapping/SimpleSymbol;
      //   1777: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1780: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1783: if_acmpeq +121 -> 1904
      //   1786: aload_0
      //   1787: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1790: astore 34
      //   1792: aload_0
      //   1793: getfield 296	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1796: astore 35
      //   1798: aload_0
      //   1799: aload 5
      //   1801: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1804: putfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1807: aload_0
      //   1808: aload 5
      //   1810: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1813: putfield 296	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1816: aload_0
      //   1817: getstatic 242	gnu/kawa/slib/pregexp:Lit5	Lgnu/mapping/SimpleSymbol;
      //   1820: getstatic 318	gnu/kawa/slib/pregexp:Lit108	Lgnu/lists/PairWithPosition;
      //   1823: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   1826: aload 5
      //   1828: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1831: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1834: getstatic 113	gnu/kawa/slib/pregexp:Lit12	Lgnu/mapping/SimpleSymbol;
      //   1837: invokestatic 306	gnu/lists/LList:list4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   1840: getstatic 309	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
      //   1843: aload_0
      //   1844: getfield 40	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
      //   1847: getstatic 321	gnu/kawa/slib/pregexp:lambda$Fn9	Lgnu/expr/ModuleMethod;
      //   1850: invokevirtual 239	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1853: astore 36
      //   1855: aload_0
      //   1856: aload 34
      //   1858: putfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   1861: aload_0
      //   1862: aload 35
      //   1864: putfield 296	gnu/kawa/slib/pregexp$frame:sn	Ljava/lang/Object;
      //   1867: aload 36
      //   1869: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1872: if_acmpeq +15 -> 1887
      //   1875: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1878: aload 5
      //   1880: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1883: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1886: areturn
      //   1887: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1890: aload 5
      //   1892: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   1895: aload 5
      //   1897: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1900: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1903: areturn
      //   1904: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1907: aload 21
      //   1909: getstatic 324	gnu/kawa/slib/pregexp:Lit109	Lgnu/mapping/SimpleSymbol;
      //   1912: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1915: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1918: if_acmpeq +66 -> 1984
      //   1921: aload_0
      //   1922: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   1925: aload 5
      //   1927: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   1930: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1933: aload 5
      //   1935: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   1938: aload_0
      //   1939: getfield 40	gnu/kawa/slib/pregexp$frame:identity	Lgnu/mapping/Procedure;
      //   1942: getstatic 327	gnu/kawa/slib/pregexp:lambda$Fn10	Lgnu/expr/ModuleMethod;
      //   1945: invokevirtual 239	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1948: astore 33
      //   1950: aload 33
      //   1952: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1955: if_acmpeq +17 -> 1972
      //   1958: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1961: aload 5
      //   1963: getfield 80	gnu/kawa/slib/pregexp$frame0:sk	Ljava/lang/Object;
      //   1966: aload 33
      //   1968: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1971: areturn
      //   1972: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   1975: aload 5
      //   1977: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   1980: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   1983: areturn
      //   1984: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1987: aload 21
      //   1989: getstatic 330	gnu/kawa/slib/pregexp:Lit60	Lgnu/mapping/SimpleSymbol;
      //   1992: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1995: astore 22
      //   1997: aload 22
      //   1999: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   2002: if_acmpeq +75 -> 2077
      //   2005: aload 22
      //   2007: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   2010: if_acmpeq +84 -> 2094
      //   2013: aload 5
      //   2015: aload_0
      //   2016: getfield 144	gnu/kawa/slib/pregexp$frame:case$Mnsensitive$Qu	Ljava/lang/Object;
      //   2019: putfield 333	gnu/kawa/slib/pregexp$frame0:old	Ljava/lang/Object;
      //   2022: aload_0
      //   2023: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   2026: getstatic 195	kawa/lib/lists:car	Lgnu/expr/GenericProc;
      //   2029: aload 5
      //   2031: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   2034: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2037: getstatic 330	gnu/kawa/slib/pregexp:Lit60	Lgnu/mapping/SimpleSymbol;
      //   2040: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2043: putfield 144	gnu/kawa/slib/pregexp$frame:case$Mnsensitive$Qu	Ljava/lang/Object;
      //   2046: aload_0
      //   2047: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   2050: aload 5
      //   2052: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   2055: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2058: aload 5
      //   2060: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   2063: aload 5
      //   2065: getfield 336	gnu/kawa/slib/pregexp$frame0:lambda$Fn11	Lgnu/expr/ModuleMethod;
      //   2068: aload 5
      //   2070: getfield 339	gnu/kawa/slib/pregexp$frame0:lambda$Fn12	Lgnu/expr/ModuleMethod;
      //   2073: invokevirtual 239	gnu/kawa/slib/pregexp$frame:lambda3sub	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2076: areturn
      //   2077: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   2080: aload 21
      //   2082: getstatic 342	gnu/kawa/slib/pregexp:Lit61	Lgnu/mapping/SimpleSymbol;
      //   2085: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2088: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   2091: if_acmpne -78 -> 2013
      //   2094: getstatic 89	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   2097: aload 21
      //   2099: getstatic 345	gnu/kawa/slib/pregexp:Lit68	Lgnu/mapping/SimpleSymbol;
      //   2102: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2105: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   2108: if_acmpeq +177 -> 2285
      //   2111: getstatic 204	kawa/lib/lists:cadr	Lgnu/expr/GenericProc;
      //   2114: aload 5
      //   2116: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   2119: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2122: astore 24
      //   2124: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   2127: astore 26
      //   2129: aload 24
      //   2131: aload 26
      //   2133: if_acmpeq +130 -> 2263
      //   2136: iconst_1
      //   2137: istore 27
      //   2139: aload 5
      //   2141: iconst_1
      //   2142: iload 27
      //   2144: iconst_1
      //   2145: iadd
      //   2146: iand
      //   2147: putfield 349	gnu/kawa/slib/pregexp$frame0:maximal$Qu	Z
      //   2150: aload 5
      //   2152: getstatic 207	kawa/lib/lists:caddr	Lgnu/expr/GenericProc;
      //   2155: aload 5
      //   2157: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   2160: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2163: putfield 352	gnu/kawa/slib/pregexp$frame0:p	Ljava/lang/Object;
      //   2166: aload 5
      //   2168: getstatic 355	kawa/lib/lists:cadddr	Lgnu/expr/GenericProc;
      //   2171: aload 5
      //   2173: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   2176: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2179: putfield 358	gnu/kawa/slib/pregexp$frame0:q	Ljava/lang/Object;
      //   2182: aload 5
      //   2184: getfield 349	gnu/kawa/slib/pregexp$frame0:maximal$Qu	Z
      //   2187: ifeq +88 -> 2275
      //   2190: aload 5
      //   2192: getfield 358	gnu/kawa/slib/pregexp$frame0:q	Ljava/lang/Object;
      //   2195: astore 29
      //   2197: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   2200: astore 31
      //   2202: aload 29
      //   2204: aload 31
      //   2206: if_acmpeq +63 -> 2269
      //   2209: iconst_1
      //   2210: istore 32
      //   2212: iconst_1
      //   2213: iload 32
      //   2215: iconst_1
      //   2216: iadd
      //   2217: iand
      //   2218: istore 28
      //   2220: aload 5
      //   2222: iload 28
      //   2224: putfield 361	gnu/kawa/slib/pregexp$frame0:could$Mnloop$Mninfinitely$Qu	Z
      //   2227: aload 5
      //   2229: getstatic 195	kawa/lib/lists:car	Lgnu/expr/GenericProc;
      //   2232: getstatic 364	kawa/lib/lists:cddddr	Lgnu/expr/GenericProc;
      //   2235: aload 5
      //   2237: getfield 74	gnu/kawa/slib/pregexp$frame0:re$1	Ljava/lang/Object;
      //   2240: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2243: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2246: putfield 367	gnu/kawa/slib/pregexp$frame0:re	Ljava/lang/Object;
      //   2249: aload 5
      //   2251: getstatic 309	gnu/kawa/slib/pregexp:Lit73	Lgnu/math/IntNum;
      //   2254: aload 5
      //   2256: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   2259: invokevirtual 370	gnu/kawa/slib/pregexp$frame0:lambda8loupP	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2262: areturn
      //   2263: iconst_0
      //   2264: istore 27
      //   2266: goto -127 -> 2139
      //   2269: iconst_0
      //   2270: istore 32
      //   2272: goto -60 -> 2212
      //   2275: aload 5
      //   2277: getfield 349	gnu/kawa/slib/pregexp$frame0:maximal$Qu	Z
      //   2280: istore 28
      //   2282: goto -62 -> 2220
      //   2285: iconst_1
      //   2286: anewarray 212	java/lang/Object
      //   2289: astore 23
      //   2291: aload 23
      //   2293: iconst_0
      //   2294: getstatic 215	gnu/kawa/slib/pregexp:Lit101	Lgnu/mapping/SimpleSymbol;
      //   2297: aastore
      //   2298: aload 23
      //   2300: invokestatic 219	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   2303: areturn
      //   2304: getstatic 116	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   2307: aload 5
      //   2309: getfield 77	gnu/kawa/slib/pregexp$frame0:i	Ljava/lang/Object;
      //   2312: aload_0
      //   2313: getfield 118	gnu/kawa/slib/pregexp$frame:n	Ljava/lang/Object;
      //   2316: invokevirtual 98	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2319: getstatic 50	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   2322: if_acmpeq +15 -> 2337
      //   2325: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   2328: aload 5
      //   2330: getfield 83	gnu/kawa/slib/pregexp$frame0:fk	Ljava/lang/Object;
      //   2333: invokevirtual 110	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2336: areturn
      //   2337: iconst_1
      //   2338: anewarray 212	java/lang/Object
      //   2341: astore 20
      //   2343: aload 20
      //   2345: iconst_0
      //   2346: getstatic 215	gnu/kawa/slib/pregexp:Lit101	Lgnu/mapping/SimpleSymbol;
      //   2349: aastore
      //   2350: aload 20
      //   2352: invokestatic 219	gnu/kawa/slib/pregexp:pregexpError$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   2355: areturn
      //   2356: astore 68
      //   2358: new 372	gnu/mapping/WrongType
      //   2361: dup
      //   2362: aload 68
      //   2364: ldc_w 374
      //   2367: iconst_1
      //   2368: aload 67
      //   2370: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2373: astore 69
      //   2375: aload 69
      //   2377: athrow
      //   2378: astore 72
      //   2380: new 372	gnu/mapping/WrongType
      //   2383: dup
      //   2384: aload 72
      //   2386: ldc_w 374
      //   2389: iconst_2
      //   2390: aload 71
      //   2392: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2395: astore 73
      //   2397: aload 73
      //   2399: athrow
      //   2400: astore 59
      //   2402: new 372	gnu/mapping/WrongType
      //   2405: dup
      //   2406: aload 59
      //   2408: ldc_w 374
      //   2411: iconst_1
      //   2412: aload 58
      //   2414: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2417: astore 60
      //   2419: aload 60
      //   2421: athrow
      //   2422: astore 63
      //   2424: new 372	gnu/mapping/WrongType
      //   2427: dup
      //   2428: aload 63
      //   2430: ldc_w 374
      //   2433: iconst_2
      //   2434: aload 62
      //   2436: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2439: astore 64
      //   2441: aload 64
      //   2443: athrow
      //   2444: astore 10
      //   2446: new 372	gnu/mapping/WrongType
      //   2449: dup
      //   2450: aload 10
      //   2452: ldc_w 374
      //   2455: iconst_1
      //   2456: aload 9
      //   2458: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2461: astore 11
      //   2463: aload 11
      //   2465: athrow
      //   2466: astore 14
      //   2468: new 372	gnu/mapping/WrongType
      //   2471: dup
      //   2472: aload 14
      //   2474: ldc_w 374
      //   2477: iconst_2
      //   2478: aload 13
      //   2480: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2483: astore 15
      //   2485: aload 15
      //   2487: athrow
      //   2488: astore 45
      //   2490: new 372	gnu/mapping/WrongType
      //   2493: dup
      //   2494: aload 45
      //   2496: ldc_w 378
      //   2499: iconst_1
      //   2500: aload 44
      //   2502: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2505: astore 46
      //   2507: aload 46
      //   2509: athrow
      //   2510: astore 49
      //   2512: new 372	gnu/mapping/WrongType
      //   2515: dup
      //   2516: aload 49
      //   2518: ldc_w 378
      //   2521: iconst_2
      //   2522: aload 48
      //   2524: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2527: astore 50
      //   2529: aload 50
      //   2531: athrow
      //   2532: astore 53
      //   2534: new 372	gnu/mapping/WrongType
      //   2537: dup
      //   2538: aload 53
      //   2540: ldc_w 378
      //   2543: iconst_3
      //   2544: aload 52
      //   2546: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2549: astore 54
      //   2551: aload 54
      //   2553: athrow
      //   2554: astore 25
      //   2556: new 372	gnu/mapping/WrongType
      //   2559: dup
      //   2560: aload 25
      //   2562: ldc_w 380
      //   2565: bipush 254
      //   2567: aload 24
      //   2569: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2572: athrow
      //   2573: astore 30
      //   2575: new 372	gnu/mapping/WrongType
      //   2578: dup
      //   2579: aload 30
      //   2581: ldc_w 382
      //   2584: bipush 254
      //   2586: aload 29
      //   2588: invokespecial 377	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   2591: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   416	423	2356	java/lang/ClassCastException
      //   430	440	2378	java/lang/ClassCastException
      //   543	550	2400	java/lang/ClassCastException
      //   557	567	2422	java/lang/ClassCastException
      //   714	721	2444	java/lang/ClassCastException
      //   728	738	2466	java/lang/ClassCastException
      //   1285	1292	2488	java/lang/ClassCastException
      //   1302	1312	2510	java/lang/ClassCastException
      //   1322	1332	2532	java/lang/ClassCastException
      //   2124	2129	2554	java/lang/ClassCastException
      //   2197	2202	2573	java/lang/ClassCastException
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
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
    boolean could$Mnloop$Mninfinitely$Qu;
    Object fk;
    Object i;
    final ModuleMethod lambda$Fn11;
    final ModuleMethod lambda$Fn12;
    final ModuleMethod lambda$Fn2;
    final ModuleMethod lambda$Fn3;
    final ModuleMethod lambda$Fn4;
    final ModuleMethod lambda$Fn5;
    boolean maximal$Qu;
    Object old;
    Object p;
    Object q;
    Object re;
    Object re$1;
    Object sk;
    pregexp.frame staticLink;

    public frame0()
    {
      this$1 = new ModuleMethod(this, 9, null, 4097);
      this$1.setProperty("source-location", "pregexp.scm:513");
      this.lambda$Fn2 = this$1;
      ModuleMethod localModuleMethod1 = new ModuleMethod(this, 10, null, 0);
      localModuleMethod1.setProperty("source-location", "pregexp.scm:514");
      this.lambda$Fn3 = localModuleMethod1;
      ModuleMethod localModuleMethod2 = new ModuleMethod(this, 11, null, 4097);
      localModuleMethod2.setProperty("source-location", "pregexp.scm:541");
      this.lambda$Fn4 = localModuleMethod2;
      ModuleMethod localModuleMethod3 = new ModuleMethod(this, 12, null, 4097);
      localModuleMethod3.setProperty("source-location", "pregexp.scm:545");
      this.lambda$Fn5 = localModuleMethod3;
      ModuleMethod localModuleMethod4 = new ModuleMethod(this, 13, null, 4097);
      localModuleMethod4.setProperty("source-location", "pregexp.scm:587");
      this.lambda$Fn11 = localModuleMethod4;
      ModuleMethod localModuleMethod5 = new ModuleMethod(this, 14, null, 0);
      localModuleMethod5.setProperty("source-location", "pregexp.scm:590");
      this.lambda$Fn12 = localModuleMethod5;
    }

    static Boolean lambda13()
    {
      return Boolean.FALSE;
    }

    static Boolean lambda14()
    {
      return Boolean.FALSE;
    }

    static Boolean lambda15()
    {
      return Boolean.FALSE;
    }

    static Boolean lambda16()
    {
      return Boolean.FALSE;
    }

    static Boolean lambda17()
    {
      return Boolean.FALSE;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.apply0(paramModuleMethod);
      case 10:
        return lambda10();
      case 14:
      }
      return lambda19();
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      case 10:
      default:
        return super.apply1(paramModuleMethod, paramObject);
      case 9:
        return lambda9(paramObject);
      case 11:
        return lambda11(paramObject);
      case 12:
        return lambda12(paramObject);
      case 13:
      }
      return lambda18(paramObject);
    }

    Object lambda10()
    {
      return Scheme.applyToArgs.apply2(this.sk, AddOp.$Pl.apply2(this.i, pregexp.Lit8));
    }

    Object lambda11(Object paramObject)
    {
      return Scheme.applyToArgs.apply2(this.sk, paramObject);
    }

    Object lambda12(Object paramObject)
    {
      Object localObject = lists.assv(this.re$1, this.staticLink.backrefs);
      try
      {
        Pair localPair = (Pair)localObject;
        lists.setCdr$Ex(localPair, lists.cons(this.i, paramObject));
        return Scheme.applyToArgs.apply2(this.sk, paramObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, localObject);
      }
    }

    Object lambda18(Object paramObject)
    {
      this.staticLink.case$Mnsensitive$Qu = this.old;
      return Scheme.applyToArgs.apply2(this.sk, paramObject);
    }

    Object lambda19()
    {
      this.staticLink.case$Mnsensitive$Qu = this.old;
      return Scheme.applyToArgs.apply1(this.fk);
    }

    public Object lambda5loupOneOfChars(Object paramObject)
    {
      pregexp.frame1 localframe1 = new pregexp.frame1();
      localframe1.staticLink = this;
      localframe1.chars = paramObject;
      if (lists.isNull(localframe1.chars))
        return Scheme.applyToArgs.apply1(this.fk);
      return this.staticLink.lambda3sub(lists.car.apply1(localframe1.chars), this.i, this.sk, localframe1.lambda$Fn13);
    }

    public Object lambda6loupSeq(Object paramObject1, Object paramObject2)
    {
      pregexp.frame2 localframe2 = new pregexp.frame2();
      localframe2.staticLink = this;
      localframe2.res = paramObject1;
      if (lists.isNull(localframe2.res))
        return Scheme.applyToArgs.apply2(this.sk, paramObject2);
      return this.staticLink.lambda3sub(lists.car.apply1(localframe2.res), paramObject2, localframe2.lambda$Fn14, this.fk);
    }

    public Object lambda7loupOr(Object paramObject)
    {
      pregexp.frame3 localframe3 = new pregexp.frame3();
      localframe3.staticLink = this;
      localframe3.res = paramObject;
      if (lists.isNull(localframe3.res))
        return Scheme.applyToArgs.apply1(this.fk);
      return this.staticLink.lambda3sub(lists.car.apply1(localframe3.res), this.i, localframe3.lambda$Fn15, localframe3.lambda$Fn16);
    }

    public Object lambda8loupP(Object paramObject1, Object paramObject2)
    {
      pregexp.frame4 localframe4 = new pregexp.frame4();
      localframe4.staticLink = this;
      localframe4.k = paramObject1;
      localframe4.i = paramObject2;
      if (Scheme.numLss.apply2(localframe4.k, this.p) != Boolean.FALSE)
        return this.staticLink.lambda3sub(this.re, localframe4.i, localframe4.lambda$Fn17, this.fk);
      if (this.q != Boolean.FALSE);
      for (Object localObject = AddOp.$Mn.apply2(this.q, this.p); ; localObject = this.q)
      {
        localframe4.q = localObject;
        return localframe4.lambda24loupQ(pregexp.Lit73, localframe4.i);
      }
    }

    Object lambda9(Object paramObject)
    {
      return Scheme.applyToArgs.apply1(this.fk);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.match0(paramModuleMethod, paramCallContext);
      case 14:
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 10:
      }
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      case 10:
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
      case 9:
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
  }

  public class frame1 extends ModuleBody
  {
    Object chars;
    final ModuleMethod lambda$Fn13;
    pregexp.frame0 staticLink;

    public frame1()
    {
      this$1 = new ModuleMethod(this, 1, null, 0);
      this$1.setProperty("source-location", "pregexp.scm:508");
      this.lambda$Fn13 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 1)
        return lambda20();
      return super.apply0(paramModuleMethod);
    }

    Object lambda20()
    {
      return this.staticLink.lambda5loupOneOfChars(lists.cdr.apply1(this.chars));
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
  }

  public class frame2 extends ModuleBody
  {
    final ModuleMethod lambda$Fn14;
    Object res;
    pregexp.frame0 staticLink;

    public frame2()
    {
      this$1 = new ModuleMethod(this, 2, null, 4097);
      this$1.setProperty("source-location", "pregexp.scm:519");
      this.lambda$Fn14 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 2)
        return lambda21(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda21(Object paramObject)
    {
      return this.staticLink.lambda6loupSeq(lists.cdr.apply1(this.res), paramObject);
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

  public class frame3 extends ModuleBody
  {
    final ModuleMethod lambda$Fn15;
    final ModuleMethod lambda$Fn16;
    Object res;
    pregexp.frame0 staticLink;

    public frame3()
    {
      this$1 = new ModuleMethod(this, 3, null, 4097);
      this$1.setProperty("source-location", "pregexp.scm:526");
      this.lambda$Fn15 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 4, null, 0);
      localModuleMethod.setProperty("source-location", "pregexp.scm:529");
      this.lambda$Fn16 = localModuleMethod;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 4)
        return lambda23();
      return super.apply0(paramModuleMethod);
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 3)
        return lambda22(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda22(Object paramObject)
    {
      Object localObject = Scheme.applyToArgs.apply2(this.staticLink.sk, paramObject);
      if (localObject != Boolean.FALSE)
        return localObject;
      return this.staticLink.lambda7loupOr(lists.cdr.apply1(this.res));
    }

    Object lambda23()
    {
      return this.staticLink.lambda7loupOr(lists.cdr.apply1(this.res));
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 4)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 3)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame4 extends ModuleBody
  {
    Object i;
    Object k;
    final ModuleMethod lambda$Fn17;
    Object q;
    pregexp.frame0 staticLink;

    public frame4()
    {
      this$1 = new ModuleMethod(this, 8, null, 4097);
      this$1.setProperty("source-location", "pregexp.scm:602");
      this.lambda$Fn17 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 8)
        return lambda25(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    public Object lambda24loupQ(Object paramObject1, Object paramObject2)
    {
      pregexp.frame5 localframe5 = new pregexp.frame5();
      localframe5.staticLink = this;
      localframe5.k = paramObject1;
      localframe5.i = paramObject2;
      localframe5.fk = localframe5.fk;
      if (this.q != Boolean.FALSE)
      {
        if (Scheme.numGEq.apply2(localframe5.k, this.q) == Boolean.FALSE);
      }
      else
        while (this.q != Boolean.FALSE)
          return localframe5.lambda26fk();
      if (this.staticLink.maximal$Qu)
        return this.staticLink.staticLink.lambda3sub(this.staticLink.re, localframe5.i, localframe5.lambda$Fn18, localframe5.fk);
      Object localObject = localframe5.lambda26fk();
      if (localObject != Boolean.FALSE)
        return localObject;
      return this.staticLink.staticLink.lambda3sub(this.staticLink.re, localframe5.i, localframe5.lambda$Fn19, localframe5.fk);
    }

    Object lambda25(Object paramObject)
    {
      if (this.staticLink.could$Mnloop$Mninfinitely$Qu)
        if (Scheme.numEqu.apply2(paramObject, this.i) == Boolean.FALSE);
      while (true)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = pregexp.Lit101;
        arrayOfObject[1] = pregexp.Lit110;
        pregexp.pregexpError$V(arrayOfObject);
        do
          return this.staticLink.lambda8loupP(AddOp.$Pl.apply2(this.k, pregexp.Lit8), paramObject);
        while (!this.staticLink.could$Mnloop$Mninfinitely$Qu);
      }
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 8)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame5 extends ModuleBody
  {
    Procedure fk;
    Object i;
    Object k;
    final ModuleMethod lambda$Fn18;
    final ModuleMethod lambda$Fn19;
    pregexp.frame4 staticLink;

    public frame5()
    {
      this$1 = new ModuleMethod(this, 5, pregexp.Lit111, 0);
      this$1.setProperty("source-location", "pregexp.scm:612");
      this.fk = this$1;
      ModuleMethod localModuleMethod1 = new ModuleMethod(this, 6, null, 4097);
      localModuleMethod1.setProperty("source-location", "pregexp.scm:617");
      this.lambda$Fn18 = localModuleMethod1;
      ModuleMethod localModuleMethod2 = new ModuleMethod(this, 7, null, 4097);
      localModuleMethod2.setProperty("source-location", "pregexp.scm:628");
      this.lambda$Fn19 = localModuleMethod2;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 5)
        return lambda26fk();
      return super.apply0(paramModuleMethod);
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.apply1(paramModuleMethod, paramObject);
      case 6:
        return lambda27(paramObject);
      case 7:
      }
      return lambda28(paramObject);
    }

    public Object lambda26fk()
    {
      return Scheme.applyToArgs.apply2(this.staticLink.staticLink.sk, this.i);
    }

    Object lambda27(Object paramObject)
    {
      if (this.staticLink.staticLink.could$Mnloop$Mninfinitely$Qu)
        if (Scheme.numEqu.apply2(paramObject, this.i) == Boolean.FALSE);
      while (true)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = pregexp.Lit101;
        arrayOfObject[1] = pregexp.Lit110;
        pregexp.pregexpError$V(arrayOfObject);
        do
        {
          Object localObject = this.staticLink.lambda24loupQ(AddOp.$Pl.apply2(this.k, pregexp.Lit8), paramObject);
          if (localObject == Boolean.FALSE)
            break;
          return localObject;
        }
        while (!this.staticLink.staticLink.could$Mnloop$Mninfinitely$Qu);
      }
      return lambda26fk();
    }

    Object lambda28(Object paramObject)
    {
      return this.staticLink.lambda24loupQ(AddOp.$Pl.apply2(this.k, pregexp.Lit8), paramObject);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 5)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
      case 7:
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 6:
      }
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.pregexp
 * JD-Core Version:    0.6.2
 */