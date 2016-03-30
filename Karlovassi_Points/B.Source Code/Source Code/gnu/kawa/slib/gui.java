package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.Format;
import gnu.kawa.models.Box;
import gnu.kawa.models.Button;
import gnu.kawa.models.Display;
import gnu.kawa.models.Label;
import gnu.kawa.models.Model;
import gnu.kawa.models.Text;
import gnu.kawa.models.Window;
import gnu.kawa.reflect.SlotGet;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class gui extends ModuleBody
{
  public static final gui $instance;
  public static final ModuleMethod Button;
  public static final ModuleMethod Column;
  public static final Macro Image;
  public static final ModuleMethod Label;
  static final Class Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SyntaxRules Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SyntaxRules Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final SimpleSymbol Lit33;
  static final SimpleSymbol Lit34;
  static final SimpleSymbol Lit35;
  static final SimpleSymbol Lit36;
  static final SimpleSymbol Lit37;
  static final SimpleSymbol Lit38;
  static final SimpleSymbol Lit39;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final IntNum Lit42 = IntNum.make(1);
  static final SimpleSymbol Lit5;
  static final SyntaxRules Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod Row;
  public static final ModuleMethod Text;
  public static final ModuleMethod Window;
  public static final ModuleMethod as$Mncolor;
  public static final ModuleMethod button;
  public static final ModuleMethod image$Mnheight;
  public static final ModuleMethod image$Mnread;
  public static final ModuleMethod image$Mnwidth;
  static final Location loc$$St$DtgetHeight;
  static final Location loc$$St$DtgetWidth;
  public static final Macro process$Mnkeywords;
  public static final Macro run$Mnapplication;
  public static final ModuleMethod set$Mncontent;

  static
  {
    Lit41 = (SimpleSymbol)new SimpleSymbol("value").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("name").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("invoke").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("getName").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("attr").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("<gnu.kawa.xml.KAttr>").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("instance?").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("+").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("loop").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("<object>").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("primitive-array-get").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("quasiquote").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("$lookup$").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("arg").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("num-args").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("i").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("<int>").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("::").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("run-application").readResolve();
    Lit21 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject2 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = Lit28;
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("gnu.kawa.models.Window").readResolve();
    SimpleSymbol localSimpleSymbol4 = Lit29;
    SimpleSymbol localSimpleSymbol5 = new SimpleSymbol("open");
    arrayOfObject2[0] = PairWithPosition.make(localSimpleSymbol2, Pair.make(localSimpleSymbol3, Pair.make(Pair.make(localSimpleSymbol4, Pair.make((SimpleSymbol)localSimpleSymbol5.readResolve(), LList.Empty)), LList.Empty)), "gui.scm", 749575);
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001", "\021\030\004\b\003", arrayOfObject2, 0);
    Lit22 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 1);
    Lit20 = (SimpleSymbol)new SimpleSymbol("Window").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("set-content").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("Column").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("Row").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("Text").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("Label").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("image-height").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("image-width").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("image-read").readResolve();
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = ((SimpleSymbol)new SimpleSymbol("text-field").readResolve());
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\003", new Object[0], 1);
    Object[] arrayOfObject4 = new Object[2];
    arrayOfObject4[0] = ((SimpleSymbol)new SimpleSymbol("make").readResolve());
    arrayOfObject4[1] = ((SimpleSymbol)new SimpleSymbol("<gnu.kawa.models.DrawImage>").readResolve());
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "", "\021\030\004\021\030\f\002", arrayOfObject4, 0);
    Lit11 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 1);
    Lit10 = (SimpleSymbol)new SimpleSymbol("Image").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("Button").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("button").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("as-color").readResolve();
    Object[] arrayOfObject5 = new Object[1];
    SimpleSymbol localSimpleSymbol6 = (SimpleSymbol)new SimpleSymbol("process-keywords").readResolve();
    Lit5 = localSimpleSymbol6;
    arrayOfObject5[0] = localSimpleSymbol6;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037\b", new Object[0], 4);
    Object[] arrayOfObject6 = new Object[27];
    arrayOfObject6[0] = ((SimpleSymbol)new SimpleSymbol("let").readResolve());
    arrayOfObject6[1] = Lit26;
    arrayOfObject6[2] = Lit23;
    arrayOfObject6[3] = Lit24;
    arrayOfObject6[4] = ((SimpleSymbol)new SimpleSymbol("field").readResolve());
    SimpleSymbol localSimpleSymbol7 = Lit37;
    SimpleSymbol localSimpleSymbol8 = new SimpleSymbol("length");
    arrayOfObject6[5] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol7, PairWithPosition.make((SimpleSymbol)localSimpleSymbol8.readResolve(), LList.Empty, "gui.scm", 16426), "gui.scm", 16426), LList.Empty, "gui.scm", 16425);
    arrayOfObject6[6] = Lit32;
    arrayOfObject6[7] = PairWithPosition.make(PairWithPosition.make(Lit25, PairWithPosition.make(Lit23, PairWithPosition.make(Lit24, PairWithPosition.make(IntNum.make(0), LList.Empty, "gui.scm", 20509), "gui.scm", 20503), "gui.scm", 20500), "gui.scm", 20497), LList.Empty, "gui.scm", 20496);
    arrayOfObject6[8] = ((SimpleSymbol)new SimpleSymbol("if").readResolve());
    arrayOfObject6[9] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("<").readResolve(), PairWithPosition.make(Lit25, PairWithPosition.make(Lit26, LList.Empty, "gui.scm", 24593), "gui.scm", 24591), "gui.scm", 24588);
    arrayOfObject6[10] = Lit27;
    arrayOfObject6[11] = PairWithPosition.make(Lit30, PairWithPosition.make(Lit31, LList.Empty, "gui.scm", 28710), "gui.scm", 28689);
    arrayOfObject6[12] = PairWithPosition.make(Lit25, LList.Empty, "gui.scm", 28725);
    arrayOfObject6[13] = ((SimpleSymbol)new SimpleSymbol("cond").readResolve());
    SimpleSymbol localSimpleSymbol9 = Lit34;
    SimpleSymbol localSimpleSymbol10 = Lit27;
    SimpleSymbol localSimpleSymbol11 = new SimpleSymbol("<gnu.expr.Keyword>");
    arrayOfObject6[14] = PairWithPosition.make(localSimpleSymbol9, PairWithPosition.make(localSimpleSymbol10, PairWithPosition.make((SimpleSymbol)localSimpleSymbol11.readResolve(), LList.Empty, "gui.scm", 32797), "gui.scm", 32793), "gui.scm", 32782);
    SimpleSymbol localSimpleSymbol12 = Lit28;
    SimpleSymbol localSimpleSymbol13 = new SimpleSymbol("gnu.expr.Keyword");
    arrayOfObject6[15] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol12, Pair.make((SimpleSymbol)localSimpleSymbol13.readResolve(), Pair.make(Pair.make(Lit29, Pair.make(Lit38, LList.Empty)), LList.Empty)), "gui.scm", 40970), PairWithPosition.make(Lit27, LList.Empty, "gui.scm", 40995), "gui.scm", 40969);
    arrayOfObject6[16] = PairWithPosition.make(Lit30, PairWithPosition.make(Lit31, LList.Empty, "gui.scm", 45087), "gui.scm", 45066);
    arrayOfObject6[17] = PairWithPosition.make(PairWithPosition.make(Lit33, PairWithPosition.make(Lit25, PairWithPosition.make(Lit42, LList.Empty, "gui.scm", 45107), "gui.scm", 45105), "gui.scm", 45102), LList.Empty, "gui.scm", 45102);
    arrayOfObject6[18] = PairWithPosition.make(PairWithPosition.make(Lit32, PairWithPosition.make(PairWithPosition.make(Lit33, PairWithPosition.make(Lit25, PairWithPosition.make(IntNum.make(2), LList.Empty, "gui.scm", 49170), "gui.scm", 49168), "gui.scm", 49165), LList.Empty, "gui.scm", 49165), "gui.scm", 49159), LList.Empty, "gui.scm", 49159);
    arrayOfObject6[19] = PairWithPosition.make(Lit34, PairWithPosition.make(Lit27, PairWithPosition.make(Lit35, LList.Empty, "gui.scm", 53270), "gui.scm", 53266), "gui.scm", 53255);
    arrayOfObject6[20] = ((SimpleSymbol)new SimpleSymbol("let*").readResolve());
    PairWithPosition localPairWithPosition1 = PairWithPosition.make(Lit36, PairWithPosition.make(Lit23, PairWithPosition.make(Lit35, PairWithPosition.make(Lit27, LList.Empty, "gui.scm", 57388), "gui.scm", 57367), "gui.scm", 57364), "gui.scm", 57358);
    SimpleSymbol localSimpleSymbol14 = Lit40;
    SimpleSymbol localSimpleSymbol15 = Lit23;
    SimpleSymbol localSimpleSymbol16 = new SimpleSymbol("<java.lang.String>");
    PairWithPosition localPairWithPosition2 = PairWithPosition.make(localSimpleSymbol14, PairWithPosition.make(localSimpleSymbol15, PairWithPosition.make((SimpleSymbol)localSimpleSymbol16.readResolve(), PairWithPosition.make(PairWithPosition.make(Lit39, PairWithPosition.make(Lit36, PairWithPosition.make(PairWithPosition.make(Lit37, PairWithPosition.make(Lit38, LList.Empty, "gui.scm", 61489), "gui.scm", 61489), LList.Empty, "gui.scm", 61488), "gui.scm", 61483), "gui.scm", 61475), LList.Empty, "gui.scm", 61475), "gui.scm", 61456), "gui.scm", 61453), "gui.scm", 61447);
    SimpleSymbol localSimpleSymbol17 = Lit41;
    SimpleSymbol localSimpleSymbol18 = Lit39;
    SimpleSymbol localSimpleSymbol19 = Lit36;
    SimpleSymbol localSimpleSymbol20 = Lit37;
    SimpleSymbol localSimpleSymbol21 = new SimpleSymbol("getObjectValue");
    arrayOfObject6[21] = PairWithPosition.make(localPairWithPosition1, PairWithPosition.make(localPairWithPosition2, PairWithPosition.make(PairWithPosition.make(localSimpleSymbol17, PairWithPosition.make(PairWithPosition.make(localSimpleSymbol18, PairWithPosition.make(localSimpleSymbol19, PairWithPosition.make(PairWithPosition.make(localSimpleSymbol20, PairWithPosition.make((SimpleSymbol)localSimpleSymbol21.readResolve(), LList.Empty, "gui.scm", 65564), "gui.scm", 65564), LList.Empty, "gui.scm", 65563), "gui.scm", 65558), "gui.scm", 65550), LList.Empty, "gui.scm", 65550), "gui.scm", 65543), LList.Empty, "gui.scm", 65543), "gui.scm", 61447), "gui.scm", 57357);
    arrayOfObject6[22] = PairWithPosition.make(Lit40, PairWithPosition.make(Lit41, LList.Empty, "gui.scm", 69666), "gui.scm", 69661);
    arrayOfObject6[23] = PairWithPosition.make(PairWithPosition.make(Lit32, PairWithPosition.make(PairWithPosition.make(Lit33, PairWithPosition.make(Lit25, PairWithPosition.make(Lit42, LList.Empty, "gui.scm", 73746), "gui.scm", 73744), "gui.scm", 73741), LList.Empty, "gui.scm", 73741), "gui.scm", 73735), LList.Empty, "gui.scm", 73735);
    arrayOfObject6[24] = ((SimpleSymbol)new SimpleSymbol("else").readResolve());
    arrayOfObject6[25] = PairWithPosition.make(Lit27, LList.Empty, "gui.scm", 81951);
    arrayOfObject6[26] = PairWithPosition.make(PairWithPosition.make(Lit32, PairWithPosition.make(PairWithPosition.make(Lit33, PairWithPosition.make(Lit25, PairWithPosition.make(Lit42, LList.Empty, "gui.scm", 86034), "gui.scm", 86032), "gui.scm", 86029), LList.Empty, "gui.scm", 86029), "gui.scm", 86023), LList.Empty, "gui.scm", 86023);
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "\001\001\001\001", "\021\030\004\b\021\030\f\021\030\024\021\030\034\b\021\030$\t\013\030,\b\021\030\004\021\0304\021\030<\b\021\030D\021\030L\b\021\030\004a\b\021\030T\b\021\030\\\t\013\030d\b\021\030l©\021\030ty\t\023\t\003\021\030|\b\021\030\t\013\030\030\021\030i\021\030¤\021\030¬\b\t\023\t\003\030´\030¼\b\021\030Ä1\t\033\t\003\030Ì\030Ô", arrayOfObject6, 0);
    Lit6 = new SyntaxRules(arrayOfObject5, arrayOfSyntaxRule3, 4);
    Lit4 = (SimpleSymbol)new SimpleSymbol("*.getHeight").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("*.getWidth").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("cell-spacing").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("text").readResolve();
    Lit0 = Color.class;
    $instance = new gui();
    loc$$St$DtgetWidth = ThreadLocation.getInstance(Lit3, null);
    loc$$St$DtgetHeight = ThreadLocation.getInstance(Lit4, null);
    process$Mnkeywords = Macro.make(Lit5, Lit6, $instance);
    gui localgui = $instance;
    as$Mncolor = new ModuleMethod(localgui, 1, Lit7, 4097);
    button = new ModuleMethod(localgui, 2, Lit8, -4096);
    Button = new ModuleMethod(localgui, 3, Lit9, -4096);
    Image = Macro.make(Lit10, Lit11, $instance);
    image$Mnread = new ModuleMethod(localgui, 4, Lit12, 4097);
    image$Mnwidth = new ModuleMethod(localgui, 5, Lit13, 4097);
    image$Mnheight = new ModuleMethod(localgui, 6, Lit14, 4097);
    Label = new ModuleMethod(localgui, 7, Lit15, -4096);
    Text = new ModuleMethod(localgui, 8, Lit16, -4096);
    Row = new ModuleMethod(localgui, 9, Lit17, -4096);
    Column = new ModuleMethod(localgui, 10, Lit18, -4096);
    set$Mncontent = new ModuleMethod(localgui, 11, Lit19, 8194);
    Window = new ModuleMethod(localgui, 12, Lit20, -4096);
    run$Mnapplication = Macro.make(Lit21, Lit22, $instance);
    $instance.run();
  }

  public gui()
  {
    ModuleInfo.register(this);
  }

  // ERROR //
  public static Button Button(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 449	gnu/kawa/models/Button
    //   3: dup
    //   4: invokespecial 450	gnu/kawa/models/Button:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_3
    //   14: iload_2
    //   15: if_icmpge +129 -> 144
    //   18: aload_0
    //   19: iload_3
    //   20: aaload
    //   21: astore 4
    //   23: aload 4
    //   25: instanceof 452
    //   28: ifeq +31 -> 59
    //   31: aload 4
    //   33: checkcast 452	gnu/expr/Keyword
    //   36: astore 10
    //   38: aload_1
    //   39: aload 10
    //   41: invokevirtual 455	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   44: aload_0
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: aaload
    //   49: invokestatic 459	gnu/kawa/slib/gui:buttonKeyword	(Lgnu/kawa/models/Button;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: iinc 3 2
    //   56: goto -43 -> 13
    //   59: aload 4
    //   61: instanceof 461
    //   64: ifeq +31 -> 95
    //   67: aload 4
    //   69: checkcast 461	gnu/kawa/xml/KAttr
    //   72: astore 7
    //   74: aload_1
    //   75: aload 7
    //   77: invokevirtual 462	gnu/kawa/xml/KAttr:getName	()Ljava/lang/String;
    //   80: aload 7
    //   82: invokevirtual 464	gnu/kawa/xml/KAttr:getObjectValue	()Ljava/lang/Object;
    //   85: invokestatic 459	gnu/kawa/slib/gui:buttonKeyword	(Lgnu/kawa/models/Button;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: iinc 3 1
    //   92: goto -79 -> 13
    //   95: aload_1
    //   96: aload 4
    //   98: invokestatic 468	gnu/kawa/slib/gui:buttonNonKeyword	(Lgnu/kawa/models/Button;Ljava/lang/Object;)Ljava/lang/Boolean;
    //   101: pop
    //   102: iinc 3 1
    //   105: goto -92 -> 13
    //   108: astore 9
    //   110: new 470	gnu/mapping/WrongType
    //   113: dup
    //   114: aload 9
    //   116: ldc_w 472
    //   119: iconst_1
    //   120: aload 4
    //   122: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   125: athrow
    //   126: astore 6
    //   128: new 470	gnu/mapping/WrongType
    //   131: dup
    //   132: aload 6
    //   134: ldc 115
    //   136: bipush 254
    //   138: aload 4
    //   140: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   143: athrow
    //   144: aload_1
    //   145: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   31	38	108	java/lang/ClassCastException
    //   67	74	126	java/lang/ClassCastException
  }

  // ERROR //
  public static gnu.kawa.models.Column Column(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 478	gnu/kawa/models/Column
    //   3: dup
    //   4: invokespecial 479	gnu/kawa/models/Column:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_3
    //   14: iload_2
    //   15: if_icmpge +128 -> 143
    //   18: aload_0
    //   19: iload_3
    //   20: aaload
    //   21: astore 4
    //   23: aload 4
    //   25: instanceof 452
    //   28: ifeq +31 -> 59
    //   31: aload 4
    //   33: checkcast 452	gnu/expr/Keyword
    //   36: astore 9
    //   38: aload_1
    //   39: aload 9
    //   41: invokevirtual 455	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   44: aload_0
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: aaload
    //   49: invokestatic 483	gnu/kawa/slib/gui:boxKeyword	(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: iinc 3 2
    //   56: goto -43 -> 13
    //   59: aload 4
    //   61: instanceof 461
    //   64: ifeq +31 -> 95
    //   67: aload 4
    //   69: checkcast 461	gnu/kawa/xml/KAttr
    //   72: astore 6
    //   74: aload_1
    //   75: aload 6
    //   77: invokevirtual 462	gnu/kawa/xml/KAttr:getName	()Ljava/lang/String;
    //   80: aload 6
    //   82: invokevirtual 464	gnu/kawa/xml/KAttr:getObjectValue	()Ljava/lang/Object;
    //   85: invokestatic 483	gnu/kawa/slib/gui:boxKeyword	(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: iinc 3 1
    //   92: goto -79 -> 13
    //   95: aload_1
    //   96: aload 4
    //   98: invokestatic 487	gnu/kawa/slib/gui:boxNonKeyword	(Lgnu/kawa/models/Box;Ljava/lang/Object;)V
    //   101: iinc 3 1
    //   104: goto -91 -> 13
    //   107: astore 8
    //   109: new 470	gnu/mapping/WrongType
    //   112: dup
    //   113: aload 8
    //   115: ldc_w 472
    //   118: iconst_1
    //   119: aload 4
    //   121: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   124: athrow
    //   125: astore 5
    //   127: new 470	gnu/mapping/WrongType
    //   130: dup
    //   131: aload 5
    //   133: ldc 115
    //   135: bipush 254
    //   137: aload 4
    //   139: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   142: athrow
    //   143: aload_1
    //   144: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   31	38	107	java/lang/ClassCastException
    //   67	74	125	java/lang/ClassCastException
  }

  // ERROR //
  public static Label Label(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 490	gnu/kawa/models/Label
    //   3: dup
    //   4: invokespecial 491	gnu/kawa/models/Label:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_3
    //   14: iload_2
    //   15: if_icmpge +128 -> 143
    //   18: aload_0
    //   19: iload_3
    //   20: aaload
    //   21: astore 4
    //   23: aload 4
    //   25: instanceof 452
    //   28: ifeq +31 -> 59
    //   31: aload 4
    //   33: checkcast 452	gnu/expr/Keyword
    //   36: astore 9
    //   38: aload_1
    //   39: aload 9
    //   41: invokevirtual 455	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   44: aload_0
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: aaload
    //   49: invokestatic 495	gnu/kawa/slib/gui:labelKeyword	(Lgnu/kawa/models/Label;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: iinc 3 2
    //   56: goto -43 -> 13
    //   59: aload 4
    //   61: instanceof 461
    //   64: ifeq +31 -> 95
    //   67: aload 4
    //   69: checkcast 461	gnu/kawa/xml/KAttr
    //   72: astore 6
    //   74: aload_1
    //   75: aload 6
    //   77: invokevirtual 462	gnu/kawa/xml/KAttr:getName	()Ljava/lang/String;
    //   80: aload 6
    //   82: invokevirtual 464	gnu/kawa/xml/KAttr:getObjectValue	()Ljava/lang/Object;
    //   85: invokestatic 495	gnu/kawa/slib/gui:labelKeyword	(Lgnu/kawa/models/Label;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: iinc 3 1
    //   92: goto -79 -> 13
    //   95: aload_1
    //   96: aload 4
    //   98: invokestatic 499	gnu/kawa/slib/gui:labelNonKeyword	(Lgnu/kawa/models/Label;Ljava/lang/Object;)V
    //   101: iinc 3 1
    //   104: goto -91 -> 13
    //   107: astore 8
    //   109: new 470	gnu/mapping/WrongType
    //   112: dup
    //   113: aload 8
    //   115: ldc_w 472
    //   118: iconst_1
    //   119: aload 4
    //   121: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   124: athrow
    //   125: astore 5
    //   127: new 470	gnu/mapping/WrongType
    //   130: dup
    //   131: aload 5
    //   133: ldc 115
    //   135: bipush 254
    //   137: aload 4
    //   139: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   142: athrow
    //   143: aload_1
    //   144: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   31	38	107	java/lang/ClassCastException
    //   67	74	125	java/lang/ClassCastException
  }

  // ERROR //
  public static gnu.kawa.models.Row Row(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 502	gnu/kawa/models/Row
    //   3: dup
    //   4: invokespecial 503	gnu/kawa/models/Row:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_3
    //   14: iload_2
    //   15: if_icmpge +128 -> 143
    //   18: aload_0
    //   19: iload_3
    //   20: aaload
    //   21: astore 4
    //   23: aload 4
    //   25: instanceof 452
    //   28: ifeq +31 -> 59
    //   31: aload 4
    //   33: checkcast 452	gnu/expr/Keyword
    //   36: astore 9
    //   38: aload_1
    //   39: aload 9
    //   41: invokevirtual 455	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   44: aload_0
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: aaload
    //   49: invokestatic 483	gnu/kawa/slib/gui:boxKeyword	(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: iinc 3 2
    //   56: goto -43 -> 13
    //   59: aload 4
    //   61: instanceof 461
    //   64: ifeq +31 -> 95
    //   67: aload 4
    //   69: checkcast 461	gnu/kawa/xml/KAttr
    //   72: astore 6
    //   74: aload_1
    //   75: aload 6
    //   77: invokevirtual 462	gnu/kawa/xml/KAttr:getName	()Ljava/lang/String;
    //   80: aload 6
    //   82: invokevirtual 464	gnu/kawa/xml/KAttr:getObjectValue	()Ljava/lang/Object;
    //   85: invokestatic 483	gnu/kawa/slib/gui:boxKeyword	(Lgnu/kawa/models/Box;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: iinc 3 1
    //   92: goto -79 -> 13
    //   95: aload_1
    //   96: aload 4
    //   98: invokestatic 487	gnu/kawa/slib/gui:boxNonKeyword	(Lgnu/kawa/models/Box;Ljava/lang/Object;)V
    //   101: iinc 3 1
    //   104: goto -91 -> 13
    //   107: astore 8
    //   109: new 470	gnu/mapping/WrongType
    //   112: dup
    //   113: aload 8
    //   115: ldc_w 472
    //   118: iconst_1
    //   119: aload 4
    //   121: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   124: athrow
    //   125: astore 5
    //   127: new 470	gnu/mapping/WrongType
    //   130: dup
    //   131: aload 5
    //   133: ldc 115
    //   135: bipush 254
    //   137: aload 4
    //   139: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   142: athrow
    //   143: aload_1
    //   144: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   31	38	107	java/lang/ClassCastException
    //   67	74	125	java/lang/ClassCastException
  }

  // ERROR //
  public static Text Text(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 506	gnu/kawa/models/Text
    //   3: dup
    //   4: invokespecial 507	gnu/kawa/models/Text:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_3
    //   14: iload_2
    //   15: if_icmpge +128 -> 143
    //   18: aload_0
    //   19: iload_3
    //   20: aaload
    //   21: astore 4
    //   23: aload 4
    //   25: instanceof 452
    //   28: ifeq +31 -> 59
    //   31: aload 4
    //   33: checkcast 452	gnu/expr/Keyword
    //   36: astore 9
    //   38: aload_1
    //   39: aload 9
    //   41: invokevirtual 455	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   44: aload_0
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: aaload
    //   49: invokestatic 511	gnu/kawa/slib/gui:textKeyword	(Lgnu/kawa/models/Text;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: iinc 3 2
    //   56: goto -43 -> 13
    //   59: aload 4
    //   61: instanceof 461
    //   64: ifeq +31 -> 95
    //   67: aload 4
    //   69: checkcast 461	gnu/kawa/xml/KAttr
    //   72: astore 6
    //   74: aload_1
    //   75: aload 6
    //   77: invokevirtual 462	gnu/kawa/xml/KAttr:getName	()Ljava/lang/String;
    //   80: aload 6
    //   82: invokevirtual 464	gnu/kawa/xml/KAttr:getObjectValue	()Ljava/lang/Object;
    //   85: invokestatic 511	gnu/kawa/slib/gui:textKeyword	(Lgnu/kawa/models/Text;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: iinc 3 1
    //   92: goto -79 -> 13
    //   95: aload_1
    //   96: aload 4
    //   98: invokestatic 515	gnu/kawa/slib/gui:textNonKeyword	(Lgnu/kawa/models/Text;Ljava/lang/Object;)V
    //   101: iinc 3 1
    //   104: goto -91 -> 13
    //   107: astore 8
    //   109: new 470	gnu/mapping/WrongType
    //   112: dup
    //   113: aload 8
    //   115: ldc_w 472
    //   118: iconst_1
    //   119: aload 4
    //   121: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   124: athrow
    //   125: astore 5
    //   127: new 470	gnu/mapping/WrongType
    //   130: dup
    //   131: aload 5
    //   133: ldc 115
    //   135: bipush 254
    //   137: aload 4
    //   139: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   142: athrow
    //   143: aload_1
    //   144: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   31	38	107	java/lang/ClassCastException
    //   67	74	125	java/lang/ClassCastException
  }

  // ERROR //
  public static Window Window(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: invokestatic 521	gnu/kawa/models/Display:getInstance	()Lgnu/kawa/models/Display;
    //   3: invokevirtual 525	gnu/kawa/models/Display:makeWindow	()Lgnu/kawa/models/Window;
    //   6: astore_1
    //   7: aload_0
    //   8: arraylength
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_3
    //   12: iload_3
    //   13: iload_2
    //   14: if_icmpge +128 -> 142
    //   17: aload_0
    //   18: iload_3
    //   19: aaload
    //   20: astore 4
    //   22: aload 4
    //   24: instanceof 452
    //   27: ifeq +31 -> 58
    //   30: aload 4
    //   32: checkcast 452	gnu/expr/Keyword
    //   35: astore 9
    //   37: aload_1
    //   38: aload 9
    //   40: invokevirtual 455	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   43: aload_0
    //   44: iload_3
    //   45: iconst_1
    //   46: iadd
    //   47: aaload
    //   48: invokestatic 529	gnu/kawa/slib/gui:windowKeyword	(Lgnu/kawa/models/Window;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: iinc 3 2
    //   55: goto -43 -> 12
    //   58: aload 4
    //   60: instanceof 461
    //   63: ifeq +31 -> 94
    //   66: aload 4
    //   68: checkcast 461	gnu/kawa/xml/KAttr
    //   71: astore 6
    //   73: aload_1
    //   74: aload 6
    //   76: invokevirtual 462	gnu/kawa/xml/KAttr:getName	()Ljava/lang/String;
    //   79: aload 6
    //   81: invokevirtual 464	gnu/kawa/xml/KAttr:getObjectValue	()Ljava/lang/Object;
    //   84: invokestatic 529	gnu/kawa/slib/gui:windowKeyword	(Lgnu/kawa/models/Window;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: iinc 3 1
    //   91: goto -79 -> 12
    //   94: aload_1
    //   95: aload 4
    //   97: invokestatic 533	gnu/kawa/slib/gui:windowNonKeyword	(Lgnu/kawa/models/Window;Ljava/lang/Object;)V
    //   100: iinc 3 1
    //   103: goto -91 -> 12
    //   106: astore 8
    //   108: new 470	gnu/mapping/WrongType
    //   111: dup
    //   112: aload 8
    //   114: ldc_w 472
    //   117: iconst_1
    //   118: aload 4
    //   120: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   123: athrow
    //   124: astore 5
    //   126: new 470	gnu/mapping/WrongType
    //   129: dup
    //   130: aload 5
    //   132: ldc 115
    //   134: bipush 254
    //   136: aload 4
    //   138: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   141: athrow
    //   142: aload_1
    //   143: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   30	37	106	java/lang/ClassCastException
    //   66	73	124	java/lang/ClassCastException
  }

  public static Color asColor(Object paramObject)
  {
    if ((paramObject instanceof Color))
      return (Color)paramObject;
    if ((paramObject instanceof Integer));
    try
    {
      Integer localInteger = (Integer)paramObject;
      return new Color(localInteger.intValue());
      if ((paramObject instanceof IntNum))
        return new Color(IntNum.intValue(paramObject));
      return (Color)SlotGet.staticField.apply2(Lit0, paramObject.toString());
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "java.lang.Integer.intValue()", 1, paramObject);
    }
  }

  static Model asModel(Object paramObject)
  {
    return Display.getInstance().coerceToModel(paramObject);
  }

  static Object boxKeyword(Box paramBox, String paramString, Object paramObject)
  {
    if (paramString == Lit2)
    {
      paramBox.setCellSpacing(paramObject);
      return Values.empty;
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown box attribute ~s", paramString }), new Object[0]);
  }

  static void boxNonKeyword(Box paramBox, Object paramObject)
  {
    paramBox.add(asModel(paramObject));
  }

  // ERROR //
  public static Button button(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 449	gnu/kawa/models/Button
    //   3: dup
    //   4: invokespecial 450	gnu/kawa/models/Button:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_3
    //   14: iload_2
    //   15: if_icmpge +129 -> 144
    //   18: aload_0
    //   19: iload_3
    //   20: aaload
    //   21: astore 4
    //   23: aload 4
    //   25: instanceof 452
    //   28: ifeq +31 -> 59
    //   31: aload 4
    //   33: checkcast 452	gnu/expr/Keyword
    //   36: astore 10
    //   38: aload_1
    //   39: aload 10
    //   41: invokevirtual 455	gnu/expr/Keyword:getName	()Ljava/lang/String;
    //   44: aload_0
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: aaload
    //   49: invokestatic 459	gnu/kawa/slib/gui:buttonKeyword	(Lgnu/kawa/models/Button;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: iinc 3 2
    //   56: goto -43 -> 13
    //   59: aload 4
    //   61: instanceof 461
    //   64: ifeq +31 -> 95
    //   67: aload 4
    //   69: checkcast 461	gnu/kawa/xml/KAttr
    //   72: astore 7
    //   74: aload_1
    //   75: aload 7
    //   77: invokevirtual 462	gnu/kawa/xml/KAttr:getName	()Ljava/lang/String;
    //   80: aload 7
    //   82: invokevirtual 464	gnu/kawa/xml/KAttr:getObjectValue	()Ljava/lang/Object;
    //   85: invokestatic 459	gnu/kawa/slib/gui:buttonKeyword	(Lgnu/kawa/models/Button;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: iinc 3 1
    //   92: goto -79 -> 13
    //   95: aload_1
    //   96: aload 4
    //   98: invokestatic 468	gnu/kawa/slib/gui:buttonNonKeyword	(Lgnu/kawa/models/Button;Ljava/lang/Object;)Ljava/lang/Boolean;
    //   101: pop
    //   102: iinc 3 1
    //   105: goto -92 -> 13
    //   108: astore 9
    //   110: new 470	gnu/mapping/WrongType
    //   113: dup
    //   114: aload 9
    //   116: ldc_w 472
    //   119: iconst_1
    //   120: aload 4
    //   122: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   125: athrow
    //   126: astore 6
    //   128: new 470	gnu/mapping/WrongType
    //   131: dup
    //   132: aload 6
    //   134: ldc 115
    //   136: bipush 254
    //   138: aload 4
    //   140: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   143: athrow
    //   144: aload_1
    //   145: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   31	38	108	java/lang/ClassCastException
    //   67	74	126	java/lang/ClassCastException
  }

  static Object buttonKeyword(Button paramButton, String paramString, Object paramObject)
  {
    if (paramString == "foreground")
    {
      paramButton.setForeground(asColor(paramObject));
      return Values.empty;
    }
    if (paramString == "background")
    {
      paramButton.setBackground(asColor(paramObject));
      return Values.empty;
    }
    if (paramString == "action")
    {
      paramButton.setAction(paramObject);
      return Values.empty;
    }
    if (paramString == "text")
    {
      if (paramObject == null);
      for (String str = null; ; str = paramObject.toString())
      {
        paramButton.setText(str);
        return Values.empty;
      }
    }
    if (paramString == "disabled");
    try
    {
      Boolean localBoolean = Boolean.FALSE;
      if (paramObject != localBoolean);
      for (boolean bool = true; ; bool = false)
      {
        paramButton.setDisabled(bool);
        return Values.empty;
      }
      return misc.error$V(Format.formatToString(0, new Object[] { "unknown button attribute ~s", paramString }), new Object[0]);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.kawa.models.Button.setDisabled(boolean)", 2, paramObject);
    }
  }

  static Boolean buttonNonKeyword(Button paramButton, Object paramObject)
  {
    return Boolean.TRUE;
  }

  public static int imageHeight(BufferedImage paramBufferedImage)
  {
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$$St$DtgetHeight;
    try
    {
      Object localObject = localLocation.get();
      return ((Number)localApplyToArgs.apply2(localObject, paramBufferedImage)).intValue();
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("gui.scm", 77, 3);
      throw localUnboundLocationException;
    }
  }

  public static BufferedImage imageRead(Path paramPath)
  {
    return ImageIO.read(paramPath.openInputStream());
  }

  public static int imageWidth(BufferedImage paramBufferedImage)
  {
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    Location localLocation = loc$$St$DtgetWidth;
    try
    {
      Object localObject = localLocation.get();
      return ((Number)localApplyToArgs.apply2(localObject, paramBufferedImage)).intValue();
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      localUnboundLocationException.setLine("gui.scm", 74, 3);
      throw localUnboundLocationException;
    }
  }

  static Object labelKeyword(Label paramLabel, String paramString, Object paramObject)
  {
    if (paramString == Lit1)
    {
      if (paramObject == null);
      for (String str = null; ; str = paramObject.toString())
      {
        paramLabel.setText(str);
        return Values.empty;
      }
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown label attribute ~s", paramString }), new Object[0]);
  }

  static void labelNonKeyword(Label paramLabel, Object paramObject)
  {
    if (paramObject == null);
    for (String str = null; ; str = paramObject.toString())
    {
      paramLabel.setText(str);
      return;
    }
  }

  public static void setContent(Window paramWindow, Object paramObject)
  {
    paramWindow.setContent(paramObject);
  }

  static Object textKeyword(Text paramText, String paramString, Object paramObject)
  {
    if (paramString == Lit1)
    {
      if (paramObject == null);
      for (String str = null; ; str = paramObject.toString())
      {
        paramText.setText(str);
        return Values.empty;
      }
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown text attribute ~s", paramString }), new Object[0]);
  }

  static void textNonKeyword(Text paramText, Object paramObject)
  {
    if (paramObject == null);
    for (String str = null; ; str = paramObject.toString())
    {
      paramText.setText(str);
      return;
    }
  }

  static Object windowKeyword(Window paramWindow, String paramString, Object paramObject)
  {
    if (paramString == "title")
    {
      if (paramObject == null);
      for (String str = null; ; str = paramObject.toString())
      {
        paramWindow.setTitle(str);
        return Values.empty;
      }
    }
    if (paramString == "content")
    {
      paramWindow.setContent(paramObject);
      return Values.empty;
    }
    if (paramString == "menubar")
    {
      paramWindow.setMenuBar(paramObject);
      return Values.empty;
    }
    return misc.error$V(Format.formatToString(0, new Object[] { "unknown window attribute ~s", paramString }), new Object[0]);
  }

  static void windowNonKeyword(Window paramWindow, Object paramObject)
  {
    paramWindow.setContent(paramObject);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 708	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+40 -> 44, 1:+47->51, 2:+40->44, 3:+40->44, 4:+52->56, 5:+64->68, 6:+79->83
    //   45: aload_1
    //   46: aload_2
    //   47: invokespecial 710	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: areturn
    //   51: aload_2
    //   52: invokestatic 604	gnu/kawa/slib/gui:asColor	(Ljava/lang/Object;)Ljava/awt/Color;
    //   55: areturn
    //   56: aload_2
    //   57: invokestatic 714	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   60: astore 8
    //   62: aload 8
    //   64: invokestatic 716	gnu/kawa/slib/gui:imageRead	(Lgnu/text/Path;)Ljava/awt/image/BufferedImage;
    //   67: areturn
    //   68: aload_2
    //   69: checkcast 718	java/awt/image/BufferedImage
    //   72: astore 6
    //   74: aload 6
    //   76: invokestatic 720	gnu/kawa/slib/gui:imageWidth	(Ljava/awt/image/BufferedImage;)I
    //   79: invokestatic 723	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: areturn
    //   83: aload_2
    //   84: checkcast 718	java/awt/image/BufferedImage
    //   87: astore 4
    //   89: aload 4
    //   91: invokestatic 725	gnu/kawa/slib/gui:imageHeight	(Ljava/awt/image/BufferedImage;)I
    //   94: invokestatic 723	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: areturn
    //   98: astore 7
    //   100: new 470	gnu/mapping/WrongType
    //   103: dup
    //   104: aload 7
    //   106: ldc 250
    //   108: iconst_1
    //   109: aload_2
    //   110: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   113: athrow
    //   114: astore 5
    //   116: new 470	gnu/mapping/WrongType
    //   119: dup
    //   120: aload 5
    //   122: ldc 246
    //   124: iconst_1
    //   125: aload_2
    //   126: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   129: athrow
    //   130: astore_3
    //   131: new 470	gnu/mapping/WrongType
    //   134: dup
    //   135: aload_3
    //   136: ldc 242
    //   138: iconst_1
    //   139: aload_2
    //   140: invokespecial 475	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   143: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   56	62	98	java/lang/ClassCastException
    //   68	74	114	java/lang/ClassCastException
    //   83	89	130	java/lang/ClassCastException
  }

  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 11);
    try
    {
      Window localWindow = (Window)paramObject1;
      setContent(localWindow, paramObject2);
      return Values.empty;
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-content", 1, paramObject1);
    }
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    case 4:
    case 5:
    case 6:
    case 11:
    default:
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 2:
      return button(paramArrayOfObject);
    case 3:
      return Button(paramArrayOfObject);
    case 7:
      return Label(paramArrayOfObject);
    case 8:
      return Text(paramArrayOfObject);
    case 9:
      return Row(paramArrayOfObject);
    case 10:
      return Column(paramArrayOfObject);
    case 12:
    }
    return Window(paramArrayOfObject);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 2:
    case 3:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 6:
      if (!(paramObject instanceof BufferedImage))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5:
      if (!(paramObject instanceof BufferedImage))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 4:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 1:
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 11)
    {
      if (!(paramObject1 instanceof Window))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4:
    case 5:
    case 6:
    case 11:
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 12:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 10:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 9:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 8:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 7:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 3:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 2:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.gui
 * JD-Core Version:    0.6.2
 */