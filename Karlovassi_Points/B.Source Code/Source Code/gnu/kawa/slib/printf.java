package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.MultiplyOp;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.Complex;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class printf extends ModuleBody
{
  public static final printf $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final PairWithPosition Lit10;
  static final Char Lit11;
  static final Char Lit12;
  static final Char Lit13;
  static final IntNum Lit14;
  static final IntNum Lit15;
  static final IntNum Lit16;
  static final IntNum Lit17;
  static final Char Lit18;
  static final Char Lit19;
  static final PairWithPosition Lit2;
  static final Char Lit20;
  static final Char Lit21;
  static final Char Lit22;
  static final Char Lit23;
  static final Char Lit24;
  static final Char Lit25;
  static final Char Lit26;
  static final Char Lit27;
  static final Char Lit28;
  static final Char Lit29;
  static final Char Lit3;
  static final Char Lit30;
  static final Char Lit31;
  static final Char Lit32;
  static final PairWithPosition Lit33;
  static final SimpleSymbol Lit34;
  static final Char Lit35;
  static final Char Lit36;
  static final Char Lit37;
  static final Char Lit38;
  static final Char Lit39;
  static final Char Lit4;
  static final Char Lit40;
  static final Char Lit41;
  static final Char Lit42;
  static final Char Lit43;
  static final Char Lit44;
  static final IntNum Lit45;
  static final Char Lit46;
  static final Char Lit47;
  static final IntNum Lit48;
  static final Char Lit49;
  static final Char Lit5;
  static final IntNum Lit50;
  static final Char Lit51;
  static final Char Lit52;
  static final Char Lit53;
  static final Char Lit54;
  static final Char Lit55;
  static final Char Lit56;
  static final Char Lit57;
  static final Char Lit58;
  static final IntNum Lit59;
  static final Char Lit6;
  static final IntNum Lit60;
  static final IntNum Lit61;
  static final FVector Lit62;
  static final PairWithPosition Lit63;
  static final SimpleSymbol Lit64;
  static final Char Lit65;
  static final Char Lit66;
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final IntNum Lit7;
  static final SimpleSymbol Lit70;
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72 = (SimpleSymbol)new SimpleSymbol("fprintf").readResolve();
  static final Char Lit8;
  static final Char Lit9;
  public static final ModuleMethod fprintf;
  public static final ModuleMethod printf;
  public static final ModuleMethod sprintf;
  public static final boolean stdio$Clhex$Mnupper$Mncase$Qu;
  public static final ModuleMethod stdio$Cliprintf;
  public static final ModuleMethod stdio$Clparse$Mnfloat;
  public static final ModuleMethod stdio$Clround$Mnstring;

  static
  {
    Lit71 = (SimpleSymbol)new SimpleSymbol("stdio:iprintf").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("stdio:round-string").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("stdio:parse-float").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("sprintf").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("pad").readResolve();
    Lit66 = Char.make(42);
    Lit65 = Char.make(63);
    Lit64 = (SimpleSymbol)new SimpleSymbol("format-real").readResolve();
    Lit63 = PairWithPosition.make("i", LList.Empty, "printf.scm", 1634315);
    Lit62 = FVector.make(new Object[] { "y", "z", "a", "f", "p", "n", "u", "m", "", "k", "M", "G", "T", "P", "E", "Z", "Y" });
    Lit61 = IntNum.make(3);
    Lit60 = IntNum.make(-10);
    Lit59 = IntNum.make(6);
    Lit58 = Char.make(75);
    Lit57 = Char.make(107);
    Lit56 = Char.make(71);
    Lit55 = Char.make(103);
    Lit54 = Char.make(69);
    Lit53 = Char.make(66);
    Lit52 = Char.make(98);
    Lit51 = Char.make(88);
    Lit50 = IntNum.make(16);
    Lit49 = Char.make(120);
    Lit48 = IntNum.make(8);
    Lit47 = Char.make(79);
    Lit46 = Char.make(111);
    Lit45 = IntNum.make(10);
    Lit44 = Char.make(85);
    Lit43 = Char.make(117);
    Lit42 = Char.make(73);
    Lit41 = Char.make(68);
    Lit40 = Char.make(65);
    Lit39 = Char.make(97);
    Lit38 = Char.make(83);
    Lit37 = Char.make(115);
    Lit36 = Char.make(67);
    Lit35 = Char.make(99);
    Lit34 = (SimpleSymbol)new SimpleSymbol("printf").readResolve();
    Char localChar1 = Lit35;
    Char localChar2 = Lit37;
    Char localChar3 = Lit39;
    Char localChar4 = Char.make(100);
    Lit12 = localChar4;
    Char localChar5 = Char.make(105);
    Lit3 = localChar5;
    Char localChar6 = Lit43;
    Char localChar7 = Lit46;
    Char localChar8 = Lit49;
    Char localChar9 = Lit52;
    Char localChar10 = Char.make(102);
    Lit25 = localChar10;
    Char localChar11 = Char.make(101);
    Lit13 = localChar11;
    Lit33 = PairWithPosition.make(localChar1, PairWithPosition.make(localChar2, PairWithPosition.make(localChar3, PairWithPosition.make(localChar4, PairWithPosition.make(localChar5, PairWithPosition.make(localChar6, PairWithPosition.make(localChar7, PairWithPosition.make(localChar8, PairWithPosition.make(localChar9, PairWithPosition.make(localChar10, PairWithPosition.make(localChar11, PairWithPosition.make(Lit55, PairWithPosition.make(Lit57, LList.Empty, "printf.scm", 1781780), "printf.scm", 1781776), "printf.scm", 1781772), "printf.scm", 1781768), "printf.scm", 1777704), "printf.scm", 1777700), "printf.scm", 1777696), "printf.scm", 1777692), "printf.scm", 1777688), "printf.scm", 1777684), "printf.scm", 1777680), "printf.scm", 1777676), "printf.scm", 1777671);
    Lit32 = Char.make(104);
    Lit31 = Char.make(76);
    Lit30 = Char.make(108);
    Lit29 = Char.make(32);
    Lit28 = Char.make(37);
    Lit27 = Char.make(12);
    Lit26 = Char.make(70);
    Lit24 = Char.make(9);
    Lit23 = Char.make(84);
    Lit22 = Char.make(116);
    Lit21 = Char.make(10);
    Lit20 = Char.make(78);
    Lit19 = Char.make(110);
    Lit18 = Char.make(92);
    Lit17 = IntNum.make(-1);
    Lit16 = IntNum.make(9);
    Lit15 = IntNum.make(5);
    Lit14 = IntNum.make(2);
    Lit11 = Char.make(46);
    Lit10 = PairWithPosition.make(Lit13, PairWithPosition.make(Lit37, PairWithPosition.make(Lit25, PairWithPosition.make(Lit12, PairWithPosition.make(Lit30, PairWithPosition.make(Lit54, PairWithPosition.make(Lit38, PairWithPosition.make(Lit26, PairWithPosition.make(Lit41, PairWithPosition.make(Lit31, LList.Empty, "printf.scm", 266284), "printf.scm", 266280), "printf.scm", 266276), "printf.scm", 266272), "printf.scm", 266268), "printf.scm", 266264), "printf.scm", 266260), "printf.scm", 266256), "printf.scm", 266252), "printf.scm", 266247);
    Lit9 = Char.make(48);
    Lit8 = Char.make(35);
    Lit7 = IntNum.make(1);
    Lit6 = Char.make(43);
    Lit5 = Char.make(45);
    Lit4 = Char.make(64);
    Lit2 = PairWithPosition.make(Lit6, PairWithPosition.make(Lit5, LList.Empty, "printf.scm", 446503), "printf.scm", 446498);
    Lit1 = IntNum.make(0);
    Lit0 = IntNum.make(-15);
    $instance = new printf();
    printf localprintf = $instance;
    stdio$Clparse$Mnfloat = new ModuleMethod(localprintf, 22, Lit69, 8194);
    stdio$Clround$Mnstring = new ModuleMethod(localprintf, 23, Lit70, 12291);
    stdio$Cliprintf = new ModuleMethod(localprintf, 24, Lit71, -4094);
    fprintf = new ModuleMethod(localprintf, 25, Lit72, -4094);
    printf = new ModuleMethod(localprintf, 26, Lit34, -4095);
    sprintf = new ModuleMethod(localprintf, 27, Lit68, -4094);
    $instance.run();
  }

  public printf()
  {
    ModuleInfo.register(this);
  }

  public static Object fprintf$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame12 localframe12 = new frame12();
    localframe12.port = paramObject1;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    localframe12.cnt = Lit1;
    Scheme.apply.apply4(stdio$Cliprintf, localframe12.lambda$Fn18, paramObject2, localLList);
    return localframe12.cnt;
  }

  public static Object printf$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return Scheme.apply.apply4(fprintf, ports.current$Mnoutput$Mnport.apply0(), paramObject, localLList);
  }

  // ERROR //
  public static Object sprintf$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 434	gnu/kawa/slib/printf$frame13
    //   3: dup
    //   4: invokespecial 435	gnu/kawa/slib/printf$frame13:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   13: aload_2
    //   14: iconst_0
    //   15: invokestatic 400	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   18: astore 4
    //   20: aload_3
    //   21: getstatic 354	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   24: putfield 439	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   27: aload_3
    //   28: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   31: invokestatic 445	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   34: ifeq +72 -> 106
    //   37: aload_3
    //   38: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   41: astore 7
    //   43: aload_3
    //   44: aload 7
    //   46: putfield 448	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   49: aload_3
    //   50: getfield 448	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   53: astore 8
    //   55: aload 8
    //   57: checkcast 450	java/lang/CharSequence
    //   60: astore 10
    //   62: aload_3
    //   63: aload 10
    //   65: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   68: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: putfield 463	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
    //   74: getstatic 409	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   77: getstatic 371	gnu/kawa/slib/printf:stdio$Cliprintf	Lgnu/expr/ModuleMethod;
    //   80: aload_3
    //   81: getfield 466	gnu/kawa/slib/printf$frame13:lambda$Fn19	Lgnu/expr/ModuleMethod;
    //   84: aload_1
    //   85: aload 4
    //   87: invokevirtual 418	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload_3
    //   92: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   95: invokestatic 445	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   98: ifeq +102 -> 200
    //   101: aload_3
    //   102: getfield 439	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   105: areturn
    //   106: aload_3
    //   107: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   110: invokestatic 471	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
    //   113: ifeq +29 -> 142
    //   116: aload_3
    //   117: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   120: astore 18
    //   122: aload 18
    //   124: checkcast 473	java/lang/Number
    //   127: invokevirtual 477	java/lang/Number:intValue	()I
    //   130: istore 20
    //   132: iload 20
    //   134: invokestatic 481	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   137: astore 7
    //   139: goto -96 -> 43
    //   142: aload_3
    //   143: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   146: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   149: if_acmpne +13 -> 162
    //   152: bipush 100
    //   154: invokestatic 481	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   157: astore 7
    //   159: goto -116 -> 43
    //   162: getstatic 123	gnu/kawa/slib/printf:Lit68	Lgnu/mapping/SimpleSymbol;
    //   165: astore 5
    //   167: iconst_2
    //   168: anewarray 161	java/lang/Object
    //   171: astore 6
    //   173: aload 6
    //   175: iconst_0
    //   176: ldc_w 489
    //   179: aastore
    //   180: aload 6
    //   182: iconst_1
    //   183: aload_3
    //   184: getfield 438	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
    //   187: aastore
    //   188: aload 5
    //   190: aload 6
    //   192: invokestatic 494	kawa/lib/misc:error$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   195: astore 7
    //   197: goto -154 -> 43
    //   200: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   203: aload_3
    //   204: getfield 463	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
    //   207: aload_3
    //   208: getfield 439	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   211: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   217: if_acmpeq +8 -> 225
    //   220: aload_3
    //   221: getfield 448	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   224: areturn
    //   225: aload_3
    //   226: getfield 448	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
    //   229: astore 12
    //   231: aload 12
    //   233: checkcast 450	java/lang/CharSequence
    //   236: astore 14
    //   238: aload_3
    //   239: getfield 439	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
    //   242: astore 15
    //   244: aload 15
    //   246: checkcast 473	java/lang/Number
    //   249: invokevirtual 477	java/lang/Number:intValue	()I
    //   252: istore 17
    //   254: aload 14
    //   256: iconst_0
    //   257: iload 17
    //   259: invokestatic 506	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   262: areturn
    //   263: astore 19
    //   265: new 508	gnu/mapping/WrongType
    //   268: dup
    //   269: aload 19
    //   271: ldc_w 510
    //   274: iconst_1
    //   275: aload 18
    //   277: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: astore 9
    //   283: new 508	gnu/mapping/WrongType
    //   286: dup
    //   287: aload 9
    //   289: ldc_w 515
    //   292: iconst_1
    //   293: aload 8
    //   295: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   298: athrow
    //   299: astore 13
    //   301: new 508	gnu/mapping/WrongType
    //   304: dup
    //   305: aload 13
    //   307: ldc_w 516
    //   310: iconst_1
    //   311: aload 12
    //   313: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   316: athrow
    //   317: astore 16
    //   319: new 508	gnu/mapping/WrongType
    //   322: dup
    //   323: aload 16
    //   325: ldc_w 516
    //   328: iconst_3
    //   329: aload 15
    //   331: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   334: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   122	132	263	java/lang/ClassCastException
    //   55	62	281	java/lang/ClassCastException
    //   231	238	299	java/lang/ClassCastException
    //   244	254	317	java/lang/ClassCastException
  }

  // ERROR //
  public static Object stdio$ClIprintf$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 519	gnu/kawa/slib/printf$frame9
    //   3: dup
    //   4: invokespecial 520	gnu/kawa/slib/printf$frame9:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   13: aload_3
    //   14: aload_1
    //   15: putfield 526	gnu/kawa/slib/printf$frame9:format$Mnstring	Ljava/lang/Object;
    //   18: aload_3
    //   19: aload_2
    //   20: iconst_0
    //   21: invokestatic 400	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   24: putfield 529	gnu/kawa/slib/printf$frame9:args	Lgnu/lists/LList;
    //   27: ldc 179
    //   29: aload_3
    //   30: getfield 526	gnu/kawa/slib/printf$frame9:format$Mnstring	Ljava/lang/Object;
    //   33: invokestatic 534	gnu/kawa/functions/IsEqual:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   36: ifne +3710 -> 3746
    //   39: getstatic 316	gnu/kawa/slib/printf:Lit17	Lgnu/math/IntNum;
    //   42: astore 4
    //   44: aload_3
    //   45: getfield 526	gnu/kawa/slib/printf$frame9:format$Mnstring	Ljava/lang/Object;
    //   48: astore 5
    //   50: aload 5
    //   52: checkcast 450	java/lang/CharSequence
    //   55: astore 7
    //   57: aload 7
    //   59: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   62: istore 8
    //   64: aload_3
    //   65: getfield 526	gnu/kawa/slib/printf$frame9:format$Mnstring	Ljava/lang/Object;
    //   68: astore 9
    //   70: aload 9
    //   72: checkcast 450	java/lang/CharSequence
    //   75: astore 11
    //   77: aload_3
    //   78: aload 11
    //   80: iconst_0
    //   81: invokestatic 538	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   84: invokestatic 133	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   87: putfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   90: aload_3
    //   91: iload 8
    //   93: putfield 545	gnu/kawa/slib/printf$frame9:fl	I
    //   96: aload_3
    //   97: aload 4
    //   99: putfield 548	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
    //   102: aload_3
    //   103: getfield 529	gnu/kawa/slib/printf$frame9:args	Lgnu/lists/LList;
    //   106: astore 12
    //   108: new 550	gnu/kawa/slib/printf$frame10
    //   111: dup
    //   112: invokespecial 551	gnu/kawa/slib/printf$frame10:<init>	()V
    //   115: astore 13
    //   117: aload 13
    //   119: aload_3
    //   120: putfield 555	gnu/kawa/slib/printf$frame10:staticLink	Lgnu/kawa/slib/printf$frame9;
    //   123: aload 13
    //   125: aload 12
    //   127: putfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   130: aload_3
    //   131: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   134: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   137: aload_3
    //   138: getfield 548	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
    //   141: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: putfield 548	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
    //   147: getstatic 567	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   150: aload_3
    //   151: getfield 548	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
    //   154: aload_3
    //   155: getfield 545	gnu/kawa/slib/printf$frame9:fl	I
    //   158: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   164: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   167: if_acmpeq +34 -> 201
    //   170: aload_3
    //   171: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   174: putfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   177: aload_3
    //   178: invokevirtual 571	gnu/kawa/slib/printf$frame9:lambda19isEndOfFormat	()Z
    //   181: istore 20
    //   183: iload 20
    //   185: ifeq +66 -> 251
    //   188: iload 20
    //   190: ifeq +57 -> 247
    //   193: getstatic 574	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   196: astore 21
    //   198: aload 21
    //   200: areturn
    //   201: aload_3
    //   202: getfield 526	gnu/kawa/slib/printf$frame9:format$Mnstring	Ljava/lang/Object;
    //   205: astore 14
    //   207: aload 14
    //   209: checkcast 450	java/lang/CharSequence
    //   212: astore 16
    //   214: aload_3
    //   215: getfield 548	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
    //   218: astore 17
    //   220: aload 17
    //   222: checkcast 473	java/lang/Number
    //   225: invokevirtual 477	java/lang/Number:intValue	()I
    //   228: istore 19
    //   230: aload_3
    //   231: aload 16
    //   233: iload 19
    //   235: invokestatic 538	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   238: invokestatic 133	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   241: putfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   244: goto -67 -> 177
    //   247: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   250: areturn
    //   251: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   254: getstatic 314	gnu/kawa/slib/printf:Lit18	Lgnu/text/Char;
    //   257: aload_3
    //   258: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   261: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   264: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   267: if_acmpeq +268 -> 535
    //   270: aload_3
    //   271: invokevirtual 577	gnu/kawa/slib/printf$frame9:lambda18mustAdvance	()Ljava/lang/Object;
    //   274: pop
    //   275: aload_3
    //   276: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   279: astore 177
    //   281: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   284: aload 177
    //   286: getstatic 312	gnu/kawa/slib/printf:Lit19	Lgnu/text/Char;
    //   289: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   292: astore 178
    //   294: aload 178
    //   296: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   299: if_acmpeq +44 -> 343
    //   302: aload 178
    //   304: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   307: if_acmpeq +53 -> 360
    //   310: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   313: aload_3
    //   314: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   317: getstatic 308	gnu/kawa/slib/printf:Lit21	Lgnu/text/Char;
    //   320: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   323: astore 181
    //   325: aload 181
    //   327: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   330: if_acmpeq +202 -> 532
    //   333: aload 13
    //   335: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   338: astore 12
    //   340: goto -232 -> 108
    //   343: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   346: aload 177
    //   348: getstatic 310	gnu/kawa/slib/printf:Lit20	Lgnu/text/Char;
    //   351: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   354: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   357: if_acmpne -47 -> 310
    //   360: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   363: aload 177
    //   365: getstatic 306	gnu/kawa/slib/printf:Lit22	Lgnu/text/Char;
    //   368: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   371: astore 179
    //   373: aload 179
    //   375: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   378: if_acmpeq +29 -> 407
    //   381: aload 179
    //   383: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   386: if_acmpeq +38 -> 424
    //   389: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   392: aload_3
    //   393: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   396: getstatic 302	gnu/kawa/slib/printf:Lit24	Lgnu/text/Char;
    //   399: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   402: astore 181
    //   404: goto -79 -> 325
    //   407: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   410: aload 177
    //   412: getstatic 304	gnu/kawa/slib/printf:Lit23	Lgnu/text/Char;
    //   415: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   418: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   421: if_acmpne -32 -> 389
    //   424: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   427: aload 177
    //   429: getstatic 269	gnu/kawa/slib/printf:Lit25	Lgnu/text/Char;
    //   432: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   435: astore 180
    //   437: aload 180
    //   439: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   442: if_acmpeq +29 -> 471
    //   445: aload 180
    //   447: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   450: if_acmpeq +38 -> 488
    //   453: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   456: aload_3
    //   457: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   460: getstatic 298	gnu/kawa/slib/printf:Lit27	Lgnu/text/Char;
    //   463: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   466: astore 181
    //   468: goto -143 -> 325
    //   471: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   474: aload 177
    //   476: getstatic 300	gnu/kawa/slib/printf:Lit26	Lgnu/text/Char;
    //   479: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   482: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   485: if_acmpne -32 -> 453
    //   488: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   491: aload 177
    //   493: getstatic 308	gnu/kawa/slib/printf:Lit21	Lgnu/text/Char;
    //   496: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   502: if_acmpeq +11 -> 513
    //   505: getstatic 574	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   508: astore 181
    //   510: goto -185 -> 325
    //   513: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   516: aload_3
    //   517: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   520: aload_3
    //   521: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   524: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   527: astore 181
    //   529: goto -204 -> 325
    //   532: aload 181
    //   534: areturn
    //   535: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   538: getstatic 296	gnu/kawa/slib/printf:Lit28	Lgnu/text/Char;
    //   541: aload_3
    //   542: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   545: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   548: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   551: if_acmpeq +3161 -> 3712
    //   554: aload_3
    //   555: invokevirtual 577	gnu/kawa/slib/printf$frame9:lambda18mustAdvance	()Ljava/lang/Object;
    //   558: pop
    //   559: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   562: astore 23
    //   564: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   567: astore 24
    //   569: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   572: astore 25
    //   574: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   577: astore 26
    //   579: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   582: astore 27
    //   584: getstatic 354	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   587: astore 28
    //   589: aload 13
    //   591: getstatic 316	gnu/kawa/slib/printf:Lit17	Lgnu/math/IntNum;
    //   594: putfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   597: aload 13
    //   599: aload 28
    //   601: putfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   604: aload 13
    //   606: aload 27
    //   608: putfield 590	gnu/kawa/slib/printf$frame10:leading$Mn0s	Ljava/lang/Object;
    //   611: aload 13
    //   613: aload 26
    //   615: putfield 593	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
    //   618: aload 13
    //   620: aload 25
    //   622: putfield 596	gnu/kawa/slib/printf$frame10:blank	Ljava/lang/Object;
    //   625: aload 13
    //   627: aload 24
    //   629: putfield 599	gnu/kawa/slib/printf$frame10:signed	Ljava/lang/Object;
    //   632: aload 13
    //   634: aload 23
    //   636: putfield 602	gnu/kawa/slib/printf$frame10:left$Mnadjust	Ljava/lang/Object;
    //   639: aload 13
    //   641: aload 13
    //   643: getfield 605	gnu/kawa/slib/printf$frame10:pad	Lgnu/mapping/Procedure;
    //   646: putfield 605	gnu/kawa/slib/printf$frame10:pad	Lgnu/mapping/Procedure;
    //   649: aload_3
    //   650: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   653: astore 29
    //   655: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   658: aload 29
    //   660: getstatic 346	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
    //   663: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   666: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   669: if_acmpeq +19 -> 688
    //   672: aload 13
    //   674: getstatic 574	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   677: putfield 602	gnu/kawa/slib/printf$frame10:left$Mnadjust	Ljava/lang/Object;
    //   680: aload_3
    //   681: invokevirtual 577	gnu/kawa/slib/printf$frame9:lambda18mustAdvance	()Ljava/lang/Object;
    //   684: pop
    //   685: goto -36 -> 649
    //   688: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   691: aload 29
    //   693: getstatic 344	gnu/kawa/slib/printf:Lit6	Lgnu/text/Char;
    //   696: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   699: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   702: if_acmpeq +14 -> 716
    //   705: aload 13
    //   707: getstatic 574	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   710: putfield 599	gnu/kawa/slib/printf$frame10:signed	Ljava/lang/Object;
    //   713: goto -33 -> 680
    //   716: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   719: aload 29
    //   721: getstatic 294	gnu/kawa/slib/printf:Lit29	Lgnu/text/Char;
    //   724: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   727: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   730: if_acmpeq +14 -> 744
    //   733: aload 13
    //   735: getstatic 574	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   738: putfield 596	gnu/kawa/slib/printf$frame10:blank	Ljava/lang/Object;
    //   741: goto -61 -> 680
    //   744: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   747: aload 29
    //   749: getstatic 340	gnu/kawa/slib/printf:Lit8	Lgnu/text/Char;
    //   752: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   755: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   758: if_acmpeq +14 -> 772
    //   761: aload 13
    //   763: getstatic 574	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   766: putfield 593	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
    //   769: goto -89 -> 680
    //   772: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   775: aload 29
    //   777: getstatic 338	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
    //   780: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   783: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   786: if_acmpeq +14 -> 800
    //   789: aload 13
    //   791: getstatic 574	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   794: putfield 590	gnu/kawa/slib/printf$frame10:leading$Mn0s	Ljava/lang/Object;
    //   797: goto -117 -> 680
    //   800: aload 13
    //   802: getfield 602	gnu/kawa/slib/printf$frame10:left$Mnadjust	Ljava/lang/Object;
    //   805: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   808: if_acmpeq +11 -> 819
    //   811: aload 13
    //   813: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   816: putfield 590	gnu/kawa/slib/printf$frame10:leading$Mn0s	Ljava/lang/Object;
    //   819: aload 13
    //   821: getfield 599	gnu/kawa/slib/printf$frame10:signed	Ljava/lang/Object;
    //   824: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   827: if_acmpeq +11 -> 838
    //   830: aload 13
    //   832: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   835: putfield 596	gnu/kawa/slib/printf$frame10:blank	Ljava/lang/Object;
    //   838: aload 13
    //   840: aload 13
    //   842: invokevirtual 608	gnu/kawa/slib/printf$frame10:lambda22readFormatNumber	()Ljava/lang/Object;
    //   845: putfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   848: aload 13
    //   850: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   853: astore 30
    //   855: aload 30
    //   857: invokestatic 614	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   860: astore 32
    //   862: aload 32
    //   864: invokestatic 618	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   867: ifeq +27 -> 894
    //   870: aload 13
    //   872: getstatic 574	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   875: putfield 602	gnu/kawa/slib/printf$frame10:left$Mnadjust	Ljava/lang/Object;
    //   878: aload 13
    //   880: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   883: aload 13
    //   885: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   888: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   891: putfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   894: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   897: getstatic 324	gnu/kawa/slib/printf:Lit11	Lgnu/text/Char;
    //   900: aload_3
    //   901: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   904: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   907: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   910: if_acmpeq +18 -> 928
    //   913: aload_3
    //   914: invokevirtual 577	gnu/kawa/slib/printf$frame9:lambda18mustAdvance	()Ljava/lang/Object;
    //   917: pop
    //   918: aload 13
    //   920: aload 13
    //   922: invokevirtual 608	gnu/kawa/slib/printf$frame10:lambda22readFormatNumber	()Ljava/lang/Object;
    //   925: putfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   928: aload_3
    //   929: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   932: astore 33
    //   934: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   937: aload 33
    //   939: getstatic 292	gnu/kawa/slib/printf:Lit30	Lgnu/text/Char;
    //   942: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   945: astore 34
    //   947: aload 34
    //   949: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   952: if_acmpeq +217 -> 1169
    //   955: aload 34
    //   957: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   960: if_acmpeq +8 -> 968
    //   963: aload_3
    //   964: invokevirtual 577	gnu/kawa/slib/printf$frame9:lambda18mustAdvance	()Ljava/lang/Object;
    //   967: pop
    //   968: aload 13
    //   970: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   973: invokestatic 630	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   976: ifeq +81 -> 1057
    //   979: aload_3
    //   980: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   983: astore 168
    //   985: aload 168
    //   987: checkcast 129	gnu/text/Char
    //   990: astore 170
    //   992: aload 170
    //   994: invokestatic 636	kawa/lib/rnrs/unicode:charDowncase	(Lgnu/text/Char;)Lgnu/text/Char;
    //   997: getstatic 286	gnu/kawa/slib/printf:Lit33	Lgnu/lists/PairWithPosition;
    //   1000: invokestatic 639	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1003: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1006: if_acmpeq +51 -> 1057
    //   1009: getstatic 263	gnu/kawa/slib/printf:Lit34	Lgnu/mapping/SimpleSymbol;
    //   1012: astore 171
    //   1014: iconst_3
    //   1015: anewarray 161	java/lang/Object
    //   1018: astore 172
    //   1020: aload 172
    //   1022: iconst_0
    //   1023: ldc_w 641
    //   1026: aastore
    //   1027: aload 172
    //   1029: iconst_1
    //   1030: aload_3
    //   1031: getfield 529	gnu/kawa/slib/printf$frame9:args	Lgnu/lists/LList;
    //   1034: invokestatic 645	kawa/lib/lists:length	(Lgnu/lists/LList;)I
    //   1037: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1040: aastore
    //   1041: aload 172
    //   1043: iconst_2
    //   1044: aload_3
    //   1045: getfield 526	gnu/kawa/slib/printf$frame9:format$Mnstring	Ljava/lang/Object;
    //   1048: aastore
    //   1049: aload 171
    //   1051: aload 172
    //   1053: invokestatic 494	kawa/lib/misc:error$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1056: pop
    //   1057: aload_3
    //   1058: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   1061: astore 37
    //   1063: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   1066: aload 37
    //   1068: getstatic 260	gnu/kawa/slib/printf:Lit35	Lgnu/text/Char;
    //   1071: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1074: astore 38
    //   1076: aload 38
    //   1078: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1081: if_acmpeq +140 -> 1221
    //   1084: aload 38
    //   1086: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1089: if_acmpeq +149 -> 1238
    //   1092: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   1095: astore 164
    //   1097: aload_3
    //   1098: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   1101: astore 165
    //   1103: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   1106: aload 13
    //   1108: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   1111: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1114: astore 166
    //   1116: aload 166
    //   1118: instanceof 651
    //   1121: ifeq +327 -> 1448
    //   1124: aload 166
    //   1126: checkcast 651	[Ljava/lang/Object;
    //   1129: astore 167
    //   1131: aload 164
    //   1133: aload 165
    //   1135: aload 167
    //   1137: invokestatic 655	kawa/lib/strings:$make$string$	([Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   1140: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1143: astore 21
    //   1145: aload 21
    //   1147: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1150: if_acmpeq -952 -> 198
    //   1153: getstatic 658	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   1156: aload 13
    //   1158: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   1161: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1164: astore 12
    //   1166: goto -1058 -> 108
    //   1169: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   1172: aload 33
    //   1174: getstatic 290	gnu/kawa/slib/printf:Lit31	Lgnu/text/Char;
    //   1177: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1180: astore 35
    //   1182: aload 35
    //   1184: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1187: if_acmpeq +14 -> 1201
    //   1190: aload 35
    //   1192: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1195: if_acmpeq -227 -> 968
    //   1198: goto -235 -> 963
    //   1201: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   1204: aload 33
    //   1206: getstatic 288	gnu/kawa/slib/printf:Lit32	Lgnu/text/Char;
    //   1209: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1212: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1215: if_acmpeq -247 -> 968
    //   1218: goto -255 -> 963
    //   1221: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   1224: aload 37
    //   1226: getstatic 258	gnu/kawa/slib/printf:Lit36	Lgnu/text/Char;
    //   1229: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1232: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1235: if_acmpne -143 -> 1092
    //   1238: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   1241: aload 37
    //   1243: getstatic 256	gnu/kawa/slib/printf:Lit37	Lgnu/text/Char;
    //   1246: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1249: astore 39
    //   1251: aload 39
    //   1253: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1256: if_acmpeq +206 -> 1462
    //   1259: aload 39
    //   1261: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1264: if_acmpeq +215 -> 1479
    //   1267: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   1270: aload 13
    //   1272: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   1275: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1278: invokestatic 661	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
    //   1281: ifeq +472 -> 1753
    //   1284: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   1287: aload 13
    //   1289: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   1292: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1295: astore 161
    //   1297: aload 161
    //   1299: checkcast 663	gnu/mapping/Symbol
    //   1302: astore 163
    //   1304: aload 163
    //   1306: invokestatic 667	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   1309: astore 128
    //   1311: aload 13
    //   1313: getfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   1316: astore 129
    //   1318: aload 129
    //   1320: invokestatic 614	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1323: astore 131
    //   1325: aload 131
    //   1327: invokestatic 618	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   1330: istore 132
    //   1332: iload 132
    //   1334: ifeq +460 -> 1794
    //   1337: iload 132
    //   1339: ifne +37 -> 1376
    //   1342: aload 128
    //   1344: checkcast 450	java/lang/CharSequence
    //   1347: astore 138
    //   1349: aload 13
    //   1351: getfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   1354: astore 139
    //   1356: aload 139
    //   1358: checkcast 473	java/lang/Number
    //   1361: invokevirtual 477	java/lang/Number:intValue	()I
    //   1364: istore 141
    //   1366: aload 138
    //   1368: iconst_0
    //   1369: iload 141
    //   1371: invokestatic 506	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   1374: astore 128
    //   1376: getstatic 670	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   1379: astore 142
    //   1381: aload 13
    //   1383: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   1386: astore 143
    //   1388: aload 128
    //   1390: checkcast 450	java/lang/CharSequence
    //   1393: astore 145
    //   1395: aload 142
    //   1397: aload 143
    //   1399: aload 145
    //   1401: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   1404: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1407: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1410: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1413: if_acmpeq +424 -> 1837
    //   1416: aload_3
    //   1417: aload 128
    //   1419: invokevirtual 673	gnu/kawa/slib/printf$frame9:lambda21out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1422: astore 21
    //   1424: aload 21
    //   1426: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1429: if_acmpeq -1231 -> 198
    //   1432: getstatic 658	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   1435: aload 13
    //   1437: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   1440: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1443: astore 12
    //   1445: goto -1337 -> 108
    //   1448: iconst_1
    //   1449: anewarray 161	java/lang/Object
    //   1452: dup
    //   1453: iconst_0
    //   1454: aload 166
    //   1456: aastore
    //   1457: astore 167
    //   1459: goto -328 -> 1131
    //   1462: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   1465: aload 37
    //   1467: getstatic 254	gnu/kawa/slib/printf:Lit38	Lgnu/text/Char;
    //   1470: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1473: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1476: if_acmpne -209 -> 1267
    //   1479: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   1482: aload 37
    //   1484: getstatic 252	gnu/kawa/slib/printf:Lit39	Lgnu/text/Char;
    //   1487: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1490: astore 40
    //   1492: aload 40
    //   1494: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1497: if_acmpeq +502 -> 1999
    //   1500: aload 40
    //   1502: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1505: if_acmpeq +511 -> 2016
    //   1508: aload 13
    //   1510: aload 13
    //   1512: getfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   1515: putfield 676	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
    //   1518: aload 13
    //   1520: ldc 179
    //   1522: putfield 679	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
    //   1525: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   1528: aload 13
    //   1530: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   1533: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1536: astore 79
    //   1538: aload 13
    //   1540: getfield 593	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
    //   1543: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1546: if_acmpeq +551 -> 2097
    //   1549: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1552: astore 80
    //   1554: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1557: astore 81
    //   1559: aload 13
    //   1561: getfield 602	gnu/kawa/slib/printf$frame10:left$Mnadjust	Ljava/lang/Object;
    //   1564: astore 82
    //   1566: aload 82
    //   1568: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1571: if_acmpeq +534 -> 2105
    //   1574: aload 13
    //   1576: getfield 676	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
    //   1579: astore 125
    //   1581: aload 125
    //   1583: invokestatic 614	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1586: astore 127
    //   1588: aload 127
    //   1590: invokestatic 618	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   1593: ifeq +520 -> 2113
    //   1596: aload 13
    //   1598: getstatic 354	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   1601: putfield 676	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
    //   1604: aload 13
    //   1606: getfield 682	gnu/kawa/slib/printf$frame10:lambda$Fn13	Lgnu/expr/ModuleMethod;
    //   1609: astore 86
    //   1611: aload 79
    //   1613: aload 80
    //   1615: aload 81
    //   1617: aload 86
    //   1619: invokestatic 687	gnu/kawa/slib/genwrite:genericWrite	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1622: pop
    //   1623: aload 13
    //   1625: getfield 602	gnu/kawa/slib/printf$frame10:left$Mnadjust	Ljava/lang/Object;
    //   1628: astore 88
    //   1630: aload 88
    //   1632: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1635: if_acmpeq +551 -> 2186
    //   1638: aload 13
    //   1640: getfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   1643: astore 122
    //   1645: aload 122
    //   1647: invokestatic 614	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1650: astore 124
    //   1652: aload 124
    //   1654: invokestatic 618	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   1657: ifeq +537 -> 2194
    //   1660: getstatic 690	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
    //   1663: aload 13
    //   1665: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   1668: aload 13
    //   1670: getfield 676	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
    //   1673: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1676: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1679: if_acmpeq +58 -> 1737
    //   1682: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   1685: astore 116
    //   1687: aload_3
    //   1688: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   1691: astore 117
    //   1693: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   1696: aload 13
    //   1698: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   1701: aload 13
    //   1703: getfield 676	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
    //   1706: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1709: astore 118
    //   1711: aload 118
    //   1713: checkcast 473	java/lang/Number
    //   1716: invokevirtual 477	java/lang/Number:intValue	()I
    //   1719: istore 120
    //   1721: aload 116
    //   1723: aload 117
    //   1725: iload 120
    //   1727: getstatic 294	gnu/kawa/slib/printf:Lit29	Lgnu/text/Char;
    //   1730: invokestatic 693	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
    //   1733: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1736: pop
    //   1737: getstatic 658	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   1740: aload 13
    //   1742: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   1745: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1748: astore 12
    //   1750: goto -1642 -> 108
    //   1753: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   1756: aload 13
    //   1758: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   1761: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1764: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1767: if_acmpne +11 -> 1778
    //   1770: ldc_w 695
    //   1773: astore 128
    //   1775: goto -464 -> 1311
    //   1778: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   1781: aload 13
    //   1783: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   1786: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1789: astore 128
    //   1791: goto -480 -> 1311
    //   1794: getstatic 567	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
    //   1797: astore 133
    //   1799: aload 13
    //   1801: getfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   1804: astore 134
    //   1806: aload 128
    //   1808: checkcast 450	java/lang/CharSequence
    //   1811: astore 136
    //   1813: aload 133
    //   1815: aload 134
    //   1817: aload 136
    //   1819: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   1822: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1825: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1828: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1831: if_acmpne -455 -> 1376
    //   1834: goto -492 -> 1342
    //   1837: aload 13
    //   1839: getfield 602	gnu/kawa/slib/printf$frame10:left$Mnadjust	Ljava/lang/Object;
    //   1842: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1845: if_acmpeq +67 -> 1912
    //   1848: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   1851: astore 154
    //   1853: aload 13
    //   1855: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   1858: astore 155
    //   1860: aload 128
    //   1862: checkcast 450	java/lang/CharSequence
    //   1865: astore 157
    //   1867: aload 154
    //   1869: aload 155
    //   1871: aload 157
    //   1873: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   1876: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1879: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1882: astore 158
    //   1884: aload 158
    //   1886: checkcast 473	java/lang/Number
    //   1889: invokevirtual 477	java/lang/Number:intValue	()I
    //   1892: istore 160
    //   1894: aload 128
    //   1896: iload 160
    //   1898: getstatic 294	gnu/kawa/slib/printf:Lit29	Lgnu/text/Char;
    //   1901: invokestatic 693	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
    //   1904: invokestatic 699	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1907: astore 128
    //   1909: goto -493 -> 1416
    //   1912: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   1915: astore 146
    //   1917: aload 13
    //   1919: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   1922: astore 147
    //   1924: aload 128
    //   1926: checkcast 450	java/lang/CharSequence
    //   1929: astore 149
    //   1931: aload 146
    //   1933: aload 147
    //   1935: aload 149
    //   1937: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   1940: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1943: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1946: astore 150
    //   1948: aload 150
    //   1950: checkcast 473	java/lang/Number
    //   1953: invokevirtual 477	java/lang/Number:intValue	()I
    //   1956: istore 152
    //   1958: aload 13
    //   1960: getfield 590	gnu/kawa/slib/printf$frame10:leading$Mn0s	Ljava/lang/Object;
    //   1963: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1966: if_acmpeq +25 -> 1991
    //   1969: getstatic 338	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
    //   1972: astore 153
    //   1974: iload 152
    //   1976: aload 153
    //   1978: invokestatic 693	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
    //   1981: aload 128
    //   1983: invokestatic 699	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   1986: astore 128
    //   1988: goto -572 -> 1416
    //   1991: getstatic 294	gnu/kawa/slib/printf:Lit29	Lgnu/text/Char;
    //   1994: astore 153
    //   1996: goto -22 -> 1974
    //   1999: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2002: aload 37
    //   2004: getstatic 250	gnu/kawa/slib/printf:Lit40	Lgnu/text/Char;
    //   2007: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2010: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2013: if_acmpne -505 -> 1508
    //   2016: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2019: aload 37
    //   2021: getstatic 265	gnu/kawa/slib/printf:Lit12	Lgnu/text/Char;
    //   2024: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2027: astore 41
    //   2029: aload 41
    //   2031: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2034: if_acmpeq +480 -> 2514
    //   2037: aload 41
    //   2039: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2042: if_acmpeq +501 -> 2543
    //   2045: aload_3
    //   2046: aload 13
    //   2048: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   2051: aload 13
    //   2053: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   2056: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2059: getstatic 240	gnu/kawa/slib/printf:Lit45	Lgnu/math/IntNum;
    //   2062: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2065: invokevirtual 703	gnu/kawa/slib/printf$frame10:lambda24integerConvert	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2068: invokevirtual 673	gnu/kawa/slib/printf$frame9:lambda21out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2071: astore 21
    //   2073: aload 21
    //   2075: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2078: if_acmpeq -1880 -> 198
    //   2081: getstatic 658	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   2084: aload 13
    //   2086: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   2089: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2092: astore 12
    //   2094: goto -1986 -> 108
    //   2097: getstatic 574	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   2100: astore 80
    //   2102: goto -548 -> 1554
    //   2105: aload 82
    //   2107: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2110: if_acmpne -514 -> 1596
    //   2113: aload 13
    //   2115: getfield 602	gnu/kawa/slib/printf$frame10:left$Mnadjust	Ljava/lang/Object;
    //   2118: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2121: if_acmpeq +13 -> 2134
    //   2124: aload 13
    //   2126: getfield 706	gnu/kawa/slib/printf$frame10:lambda$Fn14	Lgnu/expr/ModuleMethod;
    //   2129: astore 86
    //   2131: goto -520 -> 1611
    //   2134: aload 13
    //   2136: getfield 676	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
    //   2139: astore 83
    //   2141: aload 83
    //   2143: invokestatic 614	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2146: astore 85
    //   2148: aload 85
    //   2150: invokestatic 618	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   2153: ifeq +23 -> 2176
    //   2156: aload 13
    //   2158: aload 13
    //   2160: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   2163: putfield 676	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
    //   2166: aload 13
    //   2168: getfield 709	gnu/kawa/slib/printf$frame10:lambda$Fn15	Lgnu/expr/ModuleMethod;
    //   2171: astore 86
    //   2173: goto -562 -> 1611
    //   2176: aload 13
    //   2178: getfield 712	gnu/kawa/slib/printf$frame10:lambda$Fn16	Lgnu/expr/ModuleMethod;
    //   2181: astore 86
    //   2183: goto -572 -> 1611
    //   2186: aload 88
    //   2188: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2191: if_acmpne -531 -> 1660
    //   2194: aload 13
    //   2196: getfield 602	gnu/kawa/slib/printf$frame10:left$Mnadjust	Ljava/lang/Object;
    //   2199: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2202: if_acmpeq +105 -> 2307
    //   2205: getstatic 690	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
    //   2208: aload 13
    //   2210: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   2213: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   2216: aload 13
    //   2218: getfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   2221: aload 13
    //   2223: getfield 676	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
    //   2226: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2229: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2232: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2235: if_acmpeq -498 -> 1737
    //   2238: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   2241: astore 110
    //   2243: aload_3
    //   2244: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   2247: astore 111
    //   2249: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   2252: aload 13
    //   2254: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   2257: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   2260: aload 13
    //   2262: getfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   2265: aload 13
    //   2267: getfield 676	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
    //   2270: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2273: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2276: astore 112
    //   2278: aload 112
    //   2280: checkcast 473	java/lang/Number
    //   2283: invokevirtual 477	java/lang/Number:intValue	()I
    //   2286: istore 114
    //   2288: aload 110
    //   2290: aload 111
    //   2292: iload 114
    //   2294: getstatic 294	gnu/kawa/slib/printf:Lit29	Lgnu/text/Char;
    //   2297: invokestatic 693	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
    //   2300: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2303: pop
    //   2304: goto -567 -> 1737
    //   2307: aload 13
    //   2309: getfield 679	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
    //   2312: astore 89
    //   2314: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2317: astore 91
    //   2319: aload 89
    //   2321: aload 91
    //   2323: if_acmpeq +81 -> 2404
    //   2326: iconst_1
    //   2327: istore 92
    //   2329: iconst_1
    //   2330: iload 92
    //   2332: iconst_1
    //   2333: iadd
    //   2334: iand
    //   2335: ifne -598 -> 1737
    //   2338: getstatic 670	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   2341: astore 93
    //   2343: aload 13
    //   2345: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   2348: astore 94
    //   2350: aload 13
    //   2352: getfield 679	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
    //   2355: astore 95
    //   2357: aload 95
    //   2359: checkcast 450	java/lang/CharSequence
    //   2362: astore 97
    //   2364: aload 93
    //   2366: aload 94
    //   2368: aload 97
    //   2370: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   2373: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2376: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2379: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2382: if_acmpeq +28 -> 2410
    //   2385: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   2388: aload_3
    //   2389: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   2392: aload 13
    //   2394: getfield 679	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
    //   2397: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2400: pop
    //   2401: goto -664 -> 1737
    //   2404: iconst_0
    //   2405: istore 92
    //   2407: goto -78 -> 2329
    //   2410: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   2413: astore 98
    //   2415: aload_3
    //   2416: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   2419: astore 99
    //   2421: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   2424: astore 100
    //   2426: aload 13
    //   2428: getfield 587	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
    //   2431: astore 101
    //   2433: aload 13
    //   2435: getfield 679	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
    //   2438: astore 102
    //   2440: aload 102
    //   2442: checkcast 450	java/lang/CharSequence
    //   2445: astore 104
    //   2447: aload 100
    //   2449: aload 101
    //   2451: aload 104
    //   2453: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   2456: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2459: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2462: astore 105
    //   2464: aload 105
    //   2466: checkcast 473	java/lang/Number
    //   2469: invokevirtual 477	java/lang/Number:intValue	()I
    //   2472: istore 107
    //   2474: aload 98
    //   2476: aload 99
    //   2478: iload 107
    //   2480: getstatic 294	gnu/kawa/slib/printf:Lit29	Lgnu/text/Char;
    //   2483: invokestatic 693	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
    //   2486: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2489: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2492: if_acmpeq -755 -> 1737
    //   2495: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   2498: aload_3
    //   2499: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   2502: aload 13
    //   2504: getfield 679	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
    //   2507: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2510: pop
    //   2511: goto -774 -> 1737
    //   2514: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2517: aload 37
    //   2519: getstatic 248	gnu/kawa/slib/printf:Lit41	Lgnu/text/Char;
    //   2522: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2525: astore 42
    //   2527: aload 42
    //   2529: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2532: if_acmpeq +92 -> 2624
    //   2535: aload 42
    //   2537: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2540: if_acmpne -495 -> 2045
    //   2543: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2546: aload 37
    //   2548: getstatic 238	gnu/kawa/slib/printf:Lit46	Lgnu/text/Char;
    //   2551: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2554: astore 46
    //   2556: aload 46
    //   2558: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2561: if_acmpeq +179 -> 2740
    //   2564: aload 46
    //   2566: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2569: if_acmpeq +188 -> 2757
    //   2572: aload_3
    //   2573: aload 13
    //   2575: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   2578: aload 13
    //   2580: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   2583: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2586: getstatic 234	gnu/kawa/slib/printf:Lit48	Lgnu/math/IntNum;
    //   2589: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2592: invokevirtual 703	gnu/kawa/slib/printf$frame10:lambda24integerConvert	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2595: invokevirtual 673	gnu/kawa/slib/printf$frame9:lambda21out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2598: astore 21
    //   2600: aload 21
    //   2602: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2605: if_acmpeq -2407 -> 198
    //   2608: getstatic 658	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   2611: aload 13
    //   2613: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   2616: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2619: astore 12
    //   2621: goto -2513 -> 108
    //   2624: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2627: aload 37
    //   2629: getstatic 267	gnu/kawa/slib/printf:Lit3	Lgnu/text/Char;
    //   2632: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2635: astore 43
    //   2637: aload 43
    //   2639: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2642: if_acmpeq +14 -> 2656
    //   2645: aload 43
    //   2647: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2650: if_acmpeq -107 -> 2543
    //   2653: goto -608 -> 2045
    //   2656: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2659: aload 37
    //   2661: getstatic 246	gnu/kawa/slib/printf:Lit42	Lgnu/text/Char;
    //   2664: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2667: astore 44
    //   2669: aload 44
    //   2671: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2674: if_acmpeq +14 -> 2688
    //   2677: aload 44
    //   2679: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2682: if_acmpeq -139 -> 2543
    //   2685: goto -640 -> 2045
    //   2688: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2691: aload 37
    //   2693: getstatic 244	gnu/kawa/slib/printf:Lit43	Lgnu/text/Char;
    //   2696: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2699: astore 45
    //   2701: aload 45
    //   2703: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2706: if_acmpeq +14 -> 2720
    //   2709: aload 45
    //   2711: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2714: if_acmpeq -171 -> 2543
    //   2717: goto -672 -> 2045
    //   2720: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2723: aload 37
    //   2725: getstatic 242	gnu/kawa/slib/printf:Lit44	Lgnu/text/Char;
    //   2728: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2731: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2734: if_acmpeq -191 -> 2543
    //   2737: goto -692 -> 2045
    //   2740: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2743: aload 37
    //   2745: getstatic 236	gnu/kawa/slib/printf:Lit47	Lgnu/text/Char;
    //   2748: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2751: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2754: if_acmpne -182 -> 2572
    //   2757: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2760: aload 37
    //   2762: getstatic 232	gnu/kawa/slib/printf:Lit49	Lgnu/text/Char;
    //   2765: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2768: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2771: if_acmpeq +81 -> 2852
    //   2774: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   2777: aload 13
    //   2779: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   2782: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2785: astore 76
    //   2787: getstatic 230	gnu/kawa/slib/printf:Lit50	Lgnu/math/IntNum;
    //   2790: astore 77
    //   2792: getstatic 714	gnu/kawa/slib/printf:stdio$Clhex$Mnupper$Mncase$Qu	Z
    //   2795: ifeq +49 -> 2844
    //   2798: getstatic 717	kawa/lib/rnrs/unicode:string$Mndowncase	Lgnu/expr/ModuleMethod;
    //   2801: astore 78
    //   2803: aload_3
    //   2804: aload 13
    //   2806: aload 76
    //   2808: aload 77
    //   2810: aload 78
    //   2812: invokevirtual 703	gnu/kawa/slib/printf$frame10:lambda24integerConvert	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2815: invokevirtual 673	gnu/kawa/slib/printf$frame9:lambda21out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2818: astore 21
    //   2820: aload 21
    //   2822: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2825: if_acmpeq -2627 -> 198
    //   2828: getstatic 658	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   2831: aload 13
    //   2833: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   2836: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2839: astore 12
    //   2841: goto -2733 -> 108
    //   2844: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2847: astore 78
    //   2849: goto -46 -> 2803
    //   2852: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2855: aload 37
    //   2857: getstatic 228	gnu/kawa/slib/printf:Lit51	Lgnu/text/Char;
    //   2860: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2863: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2866: if_acmpeq +81 -> 2947
    //   2869: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   2872: aload 13
    //   2874: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   2877: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2880: astore 73
    //   2882: getstatic 230	gnu/kawa/slib/printf:Lit50	Lgnu/math/IntNum;
    //   2885: astore 74
    //   2887: getstatic 714	gnu/kawa/slib/printf:stdio$Clhex$Mnupper$Mncase$Qu	Z
    //   2890: ifeq +49 -> 2939
    //   2893: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2896: astore 75
    //   2898: aload_3
    //   2899: aload 13
    //   2901: aload 73
    //   2903: aload 74
    //   2905: aload 75
    //   2907: invokevirtual 703	gnu/kawa/slib/printf$frame10:lambda24integerConvert	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2910: invokevirtual 673	gnu/kawa/slib/printf$frame9:lambda21out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2913: astore 21
    //   2915: aload 21
    //   2917: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2920: if_acmpeq -2722 -> 198
    //   2923: getstatic 658	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   2926: aload 13
    //   2928: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   2931: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2934: astore 12
    //   2936: goto -2828 -> 108
    //   2939: getstatic 720	kawa/lib/rnrs/unicode:string$Mnupcase	Lgnu/expr/ModuleMethod;
    //   2942: astore 75
    //   2944: goto -46 -> 2898
    //   2947: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   2950: aload 37
    //   2952: getstatic 226	gnu/kawa/slib/printf:Lit52	Lgnu/text/Char;
    //   2955: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2958: astore 47
    //   2960: aload 47
    //   2962: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2965: if_acmpeq +63 -> 3028
    //   2968: aload 47
    //   2970: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2973: if_acmpeq +72 -> 3045
    //   2976: aload_3
    //   2977: aload 13
    //   2979: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   2982: aload 13
    //   2984: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   2987: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2990: getstatic 322	gnu/kawa/slib/printf:Lit14	Lgnu/math/IntNum;
    //   2993: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2996: invokevirtual 703	gnu/kawa/slib/printf$frame10:lambda24integerConvert	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2999: invokevirtual 673	gnu/kawa/slib/printf$frame9:lambda21out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3002: astore 21
    //   3004: aload 21
    //   3006: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3009: if_acmpeq -2811 -> 198
    //   3012: getstatic 658	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   3015: aload 13
    //   3017: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   3020: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3023: astore 12
    //   3025: goto -2917 -> 108
    //   3028: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3031: aload 37
    //   3033: getstatic 224	gnu/kawa/slib/printf:Lit53	Lgnu/text/Char;
    //   3036: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3039: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3042: if_acmpne -66 -> 2976
    //   3045: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3048: aload 37
    //   3050: getstatic 296	gnu/kawa/slib/printf:Lit28	Lgnu/text/Char;
    //   3053: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3056: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3059: if_acmpeq +36 -> 3095
    //   3062: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3065: aload_3
    //   3066: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   3069: getstatic 296	gnu/kawa/slib/printf:Lit28	Lgnu/text/Char;
    //   3072: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3075: astore 21
    //   3077: aload 21
    //   3079: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3082: if_acmpeq -2884 -> 198
    //   3085: aload 13
    //   3087: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   3090: astore 12
    //   3092: goto -2984 -> 108
    //   3095: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3098: aload 37
    //   3100: getstatic 269	gnu/kawa/slib/printf:Lit25	Lgnu/text/Char;
    //   3103: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3106: astore 48
    //   3108: aload 48
    //   3110: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3113: if_acmpeq +170 -> 3283
    //   3116: aload 48
    //   3118: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3121: if_acmpeq +191 -> 3312
    //   3124: getstatic 649	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   3127: aload 13
    //   3129: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   3132: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3135: astore 55
    //   3137: aload_3
    //   3138: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   3141: astore 56
    //   3143: new 722	gnu/kawa/slib/printf$frame11
    //   3146: dup
    //   3147: invokespecial 723	gnu/kawa/slib/printf$frame11:<init>	()V
    //   3150: astore 57
    //   3152: aload 57
    //   3154: aload 13
    //   3156: putfield 726	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
    //   3159: aload 57
    //   3161: aload 56
    //   3163: putfield 727	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
    //   3166: aload 13
    //   3168: getfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   3171: astore 58
    //   3173: aload 58
    //   3175: invokestatic 614	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   3178: astore 60
    //   3180: aload 60
    //   3182: invokestatic 618	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   3185: ifeq +319 -> 3504
    //   3188: aload 13
    //   3190: getstatic 212	gnu/kawa/slib/printf:Lit59	Lgnu/math/IntNum;
    //   3193: putfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   3196: aload 55
    //   3198: invokestatic 471	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
    //   3201: ifeq +373 -> 3574
    //   3204: aload 55
    //   3206: checkcast 473	java/lang/Number
    //   3209: astore 69
    //   3211: aload 69
    //   3213: invokestatic 731	kawa/lib/numbers:exact$To$Inexact	(Ljava/lang/Number;)Ljava/lang/Number;
    //   3216: invokestatic 735	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   3219: astore 55
    //   3221: aload 57
    //   3223: aload 57
    //   3225: getfield 738	gnu/kawa/slib/printf$frame11:format$Mnreal	Lgnu/mapping/Procedure;
    //   3228: putfield 738	gnu/kawa/slib/printf$frame11:format$Mnreal	Lgnu/mapping/Procedure;
    //   3231: aload 55
    //   3233: aload 57
    //   3235: getfield 741	gnu/kawa/slib/printf$frame11:lambda$Fn17	Lgnu/expr/ModuleMethod;
    //   3238: invokestatic 744	gnu/kawa/slib/printf:stdio$ClParseFloat	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3241: astore 65
    //   3243: aload 65
    //   3245: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3248: if_acmpeq +367 -> 3615
    //   3251: aload_3
    //   3252: aload 65
    //   3254: invokevirtual 673	gnu/kawa/slib/printf$frame9:lambda21out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3257: astore 21
    //   3259: aload 21
    //   3261: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3264: if_acmpeq -3066 -> 198
    //   3267: getstatic 658	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   3270: aload 13
    //   3272: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   3275: invokevirtual 625	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3278: astore 12
    //   3280: goto -3172 -> 108
    //   3283: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3286: aload 37
    //   3288: getstatic 300	gnu/kawa/slib/printf:Lit26	Lgnu/text/Char;
    //   3291: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3294: astore 49
    //   3296: aload 49
    //   3298: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3301: if_acmpeq +23 -> 3324
    //   3304: aload 49
    //   3306: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3309: if_acmpne -185 -> 3124
    //   3312: aload_3
    //   3313: invokevirtual 571	gnu/kawa/slib/printf$frame9:lambda19isEndOfFormat	()Z
    //   3316: ifeq +316 -> 3632
    //   3319: aload_3
    //   3320: invokevirtual 747	gnu/kawa/slib/printf$frame9:lambda20incomplete	()Ljava/lang/Object;
    //   3323: areturn
    //   3324: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3327: aload 37
    //   3329: getstatic 271	gnu/kawa/slib/printf:Lit13	Lgnu/text/Char;
    //   3332: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3335: astore 50
    //   3337: aload 50
    //   3339: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3342: if_acmpeq +14 -> 3356
    //   3345: aload 50
    //   3347: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3350: if_acmpeq -38 -> 3312
    //   3353: goto -229 -> 3124
    //   3356: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3359: aload 37
    //   3361: getstatic 222	gnu/kawa/slib/printf:Lit54	Lgnu/text/Char;
    //   3364: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3367: astore 51
    //   3369: aload 51
    //   3371: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3374: if_acmpeq +14 -> 3388
    //   3377: aload 51
    //   3379: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3382: if_acmpeq -70 -> 3312
    //   3385: goto -261 -> 3124
    //   3388: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3391: aload 37
    //   3393: getstatic 220	gnu/kawa/slib/printf:Lit55	Lgnu/text/Char;
    //   3396: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3399: astore 52
    //   3401: aload 52
    //   3403: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3406: if_acmpeq +14 -> 3420
    //   3409: aload 52
    //   3411: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3414: if_acmpeq -102 -> 3312
    //   3417: goto -293 -> 3124
    //   3420: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3423: aload 37
    //   3425: getstatic 218	gnu/kawa/slib/printf:Lit56	Lgnu/text/Char;
    //   3428: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3431: astore 53
    //   3433: aload 53
    //   3435: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3438: if_acmpeq +14 -> 3452
    //   3441: aload 53
    //   3443: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3446: if_acmpeq -134 -> 3312
    //   3449: goto -325 -> 3124
    //   3452: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3455: aload 37
    //   3457: getstatic 216	gnu/kawa/slib/printf:Lit57	Lgnu/text/Char;
    //   3460: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3463: astore 54
    //   3465: aload 54
    //   3467: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3470: if_acmpeq +14 -> 3484
    //   3473: aload 54
    //   3475: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3478: if_acmpeq -166 -> 3312
    //   3481: goto -357 -> 3124
    //   3484: getstatic 498	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   3487: aload 37
    //   3489: getstatic 214	gnu/kawa/slib/printf:Lit58	Lgnu/text/Char;
    //   3492: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3495: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3498: if_acmpeq -186 -> 3312
    //   3501: goto -377 -> 3124
    //   3504: aload 13
    //   3506: getfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   3509: astore 61
    //   3511: aload 61
    //   3513: checkcast 473	java/lang/Number
    //   3516: astore 63
    //   3518: aload 63
    //   3520: invokestatic 751	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   3523: istore 64
    //   3525: iload 64
    //   3527: ifeq +39 -> 3566
    //   3530: aload 57
    //   3532: getfield 727	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
    //   3535: astore 70
    //   3537: aload 70
    //   3539: checkcast 129	gnu/text/Char
    //   3542: astore 72
    //   3544: aload 72
    //   3546: getstatic 220	gnu/kawa/slib/printf:Lit55	Lgnu/text/Char;
    //   3549: invokestatic 755	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   3552: ifeq -356 -> 3196
    //   3555: aload 13
    //   3557: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   3560: putfield 584	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
    //   3563: goto -367 -> 3196
    //   3566: iload 64
    //   3568: ifeq -372 -> 3196
    //   3571: goto -16 -> 3555
    //   3574: aload 55
    //   3576: invokestatic 445	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   3579: ifne -358 -> 3221
    //   3582: aload 55
    //   3584: invokestatic 661	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
    //   3587: ifeq +20 -> 3607
    //   3590: aload 55
    //   3592: checkcast 663	gnu/mapping/Symbol
    //   3595: astore 67
    //   3597: aload 67
    //   3599: invokestatic 667	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   3602: astore 55
    //   3604: goto -383 -> 3221
    //   3607: ldc_w 757
    //   3610: astore 55
    //   3612: goto -391 -> 3221
    //   3615: aload 13
    //   3617: ldc_w 757
    //   3620: iconst_0
    //   3621: anewarray 161	java/lang/Object
    //   3624: invokevirtual 760	gnu/kawa/slib/printf$frame10:lambda23pad$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   3627: astore 65
    //   3629: goto -378 -> 3251
    //   3632: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3635: aload_3
    //   3636: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   3639: getstatic 296	gnu/kawa/slib/printf:Lit28	Lgnu/text/Char;
    //   3642: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3645: astore 21
    //   3647: aload 21
    //   3649: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3652: if_acmpeq -3454 -> 198
    //   3655: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3658: aload_3
    //   3659: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   3662: aload_3
    //   3663: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   3666: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3669: astore 21
    //   3671: aload 21
    //   3673: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3676: if_acmpeq -3478 -> 198
    //   3679: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3682: aload_3
    //   3683: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   3686: getstatic 137	gnu/kawa/slib/printf:Lit65	Lgnu/text/Char;
    //   3689: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3692: astore 21
    //   3694: aload 21
    //   3696: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3699: if_acmpeq -3501 -> 198
    //   3702: aload 13
    //   3704: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   3707: astore 12
    //   3709: goto -3601 -> 108
    //   3712: getstatic 581	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3715: aload_3
    //   3716: getfield 523	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
    //   3719: aload_3
    //   3720: getfield 541	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
    //   3723: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3726: astore 21
    //   3728: aload 21
    //   3730: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3733: if_acmpeq -3535 -> 198
    //   3736: aload 13
    //   3738: getfield 557	gnu/kawa/slib/printf$frame10:args	Ljava/lang/Object;
    //   3741: astore 12
    //   3743: goto -3635 -> 108
    //   3746: getstatic 766	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   3749: areturn
    //   3750: astore 6
    //   3752: new 508	gnu/mapping/WrongType
    //   3755: dup
    //   3756: aload 6
    //   3758: ldc_w 515
    //   3761: iconst_1
    //   3762: aload 5
    //   3764: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3767: athrow
    //   3768: astore 10
    //   3770: new 508	gnu/mapping/WrongType
    //   3773: dup
    //   3774: aload 10
    //   3776: ldc_w 768
    //   3779: iconst_1
    //   3780: aload 9
    //   3782: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3785: athrow
    //   3786: astore 15
    //   3788: new 508	gnu/mapping/WrongType
    //   3791: dup
    //   3792: aload 15
    //   3794: ldc_w 768
    //   3797: iconst_1
    //   3798: aload 14
    //   3800: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3803: athrow
    //   3804: astore 18
    //   3806: new 508	gnu/mapping/WrongType
    //   3809: dup
    //   3810: aload 18
    //   3812: ldc_w 768
    //   3815: iconst_2
    //   3816: aload 17
    //   3818: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3821: athrow
    //   3822: astore 31
    //   3824: new 508	gnu/mapping/WrongType
    //   3827: dup
    //   3828: aload 31
    //   3830: ldc_w 770
    //   3833: iconst_1
    //   3834: aload 30
    //   3836: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3839: athrow
    //   3840: astore 169
    //   3842: new 508	gnu/mapping/WrongType
    //   3845: dup
    //   3846: aload 169
    //   3848: ldc_w 772
    //   3851: iconst_1
    //   3852: aload 168
    //   3854: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3857: athrow
    //   3858: astore 162
    //   3860: new 508	gnu/mapping/WrongType
    //   3863: dup
    //   3864: aload 162
    //   3866: ldc_w 774
    //   3869: iconst_1
    //   3870: aload 161
    //   3872: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3875: athrow
    //   3876: astore 130
    //   3878: new 508	gnu/mapping/WrongType
    //   3881: dup
    //   3882: aload 130
    //   3884: ldc_w 770
    //   3887: iconst_1
    //   3888: aload 129
    //   3890: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3893: athrow
    //   3894: astore 135
    //   3896: new 508	gnu/mapping/WrongType
    //   3899: dup
    //   3900: aload 135
    //   3902: ldc_w 515
    //   3905: iconst_1
    //   3906: aload 128
    //   3908: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3911: athrow
    //   3912: astore 137
    //   3914: new 508	gnu/mapping/WrongType
    //   3917: dup
    //   3918: aload 137
    //   3920: ldc_w 516
    //   3923: iconst_1
    //   3924: aload 128
    //   3926: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3929: athrow
    //   3930: astore 140
    //   3932: new 508	gnu/mapping/WrongType
    //   3935: dup
    //   3936: aload 140
    //   3938: ldc_w 516
    //   3941: iconst_3
    //   3942: aload 139
    //   3944: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3947: athrow
    //   3948: astore 144
    //   3950: new 508	gnu/mapping/WrongType
    //   3953: dup
    //   3954: aload 144
    //   3956: ldc_w 515
    //   3959: iconst_1
    //   3960: aload 128
    //   3962: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3965: athrow
    //   3966: astore 156
    //   3968: new 508	gnu/mapping/WrongType
    //   3971: dup
    //   3972: aload 156
    //   3974: ldc_w 515
    //   3977: iconst_1
    //   3978: aload 128
    //   3980: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3983: athrow
    //   3984: astore 159
    //   3986: new 508	gnu/mapping/WrongType
    //   3989: dup
    //   3990: aload 159
    //   3992: ldc_w 510
    //   3995: iconst_1
    //   3996: aload 158
    //   3998: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4001: athrow
    //   4002: astore 148
    //   4004: new 508	gnu/mapping/WrongType
    //   4007: dup
    //   4008: aload 148
    //   4010: ldc_w 515
    //   4013: iconst_1
    //   4014: aload 128
    //   4016: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4019: athrow
    //   4020: astore 151
    //   4022: new 508	gnu/mapping/WrongType
    //   4025: dup
    //   4026: aload 151
    //   4028: ldc_w 510
    //   4031: iconst_1
    //   4032: aload 150
    //   4034: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4037: athrow
    //   4038: astore 126
    //   4040: new 508	gnu/mapping/WrongType
    //   4043: dup
    //   4044: aload 126
    //   4046: ldc_w 770
    //   4049: iconst_1
    //   4050: aload 125
    //   4052: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4055: athrow
    //   4056: astore 84
    //   4058: new 508	gnu/mapping/WrongType
    //   4061: dup
    //   4062: aload 84
    //   4064: ldc_w 770
    //   4067: iconst_1
    //   4068: aload 83
    //   4070: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4073: athrow
    //   4074: astore 123
    //   4076: new 508	gnu/mapping/WrongType
    //   4079: dup
    //   4080: aload 123
    //   4082: ldc_w 770
    //   4085: iconst_1
    //   4086: aload 122
    //   4088: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4091: athrow
    //   4092: astore 119
    //   4094: new 508	gnu/mapping/WrongType
    //   4097: dup
    //   4098: aload 119
    //   4100: ldc_w 510
    //   4103: iconst_1
    //   4104: aload 118
    //   4106: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4109: athrow
    //   4110: astore 113
    //   4112: new 508	gnu/mapping/WrongType
    //   4115: dup
    //   4116: aload 113
    //   4118: ldc_w 510
    //   4121: iconst_1
    //   4122: aload 112
    //   4124: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4127: athrow
    //   4128: astore 90
    //   4130: new 508	gnu/mapping/WrongType
    //   4133: dup
    //   4134: aload 90
    //   4136: ldc_w 776
    //   4139: bipush 254
    //   4141: aload 89
    //   4143: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4146: athrow
    //   4147: astore 96
    //   4149: new 508	gnu/mapping/WrongType
    //   4152: dup
    //   4153: aload 96
    //   4155: ldc_w 515
    //   4158: iconst_1
    //   4159: aload 95
    //   4161: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4164: athrow
    //   4165: astore 103
    //   4167: new 508	gnu/mapping/WrongType
    //   4170: dup
    //   4171: aload 103
    //   4173: ldc_w 515
    //   4176: iconst_1
    //   4177: aload 102
    //   4179: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4182: athrow
    //   4183: astore 106
    //   4185: new 508	gnu/mapping/WrongType
    //   4188: dup
    //   4189: aload 106
    //   4191: ldc_w 510
    //   4194: iconst_1
    //   4195: aload 105
    //   4197: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4200: athrow
    //   4201: astore 59
    //   4203: new 508	gnu/mapping/WrongType
    //   4206: dup
    //   4207: aload 59
    //   4209: ldc_w 770
    //   4212: iconst_1
    //   4213: aload 58
    //   4215: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4218: athrow
    //   4219: astore 62
    //   4221: new 508	gnu/mapping/WrongType
    //   4224: dup
    //   4225: aload 62
    //   4227: ldc_w 778
    //   4230: iconst_1
    //   4231: aload 61
    //   4233: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4236: athrow
    //   4237: astore 71
    //   4239: new 508	gnu/mapping/WrongType
    //   4242: dup
    //   4243: aload 71
    //   4245: ldc_w 780
    //   4248: iconst_1
    //   4249: aload 70
    //   4251: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4254: athrow
    //   4255: astore 68
    //   4257: new 508	gnu/mapping/WrongType
    //   4260: dup
    //   4261: aload 68
    //   4263: ldc_w 782
    //   4266: iconst_1
    //   4267: aload 55
    //   4269: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4272: athrow
    //   4273: astore 66
    //   4275: new 508	gnu/mapping/WrongType
    //   4278: dup
    //   4279: aload 66
    //   4281: ldc_w 774
    //   4284: iconst_1
    //   4285: aload 55
    //   4287: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4290: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   50	57	3750	java/lang/ClassCastException
    //   70	77	3768	java/lang/ClassCastException
    //   207	214	3786	java/lang/ClassCastException
    //   220	230	3804	java/lang/ClassCastException
    //   855	862	3822	java/lang/ClassCastException
    //   985	992	3840	java/lang/ClassCastException
    //   1297	1304	3858	java/lang/ClassCastException
    //   1318	1325	3876	java/lang/ClassCastException
    //   1806	1813	3894	java/lang/ClassCastException
    //   1342	1349	3912	java/lang/ClassCastException
    //   1356	1366	3930	java/lang/ClassCastException
    //   1388	1395	3948	java/lang/ClassCastException
    //   1860	1867	3966	java/lang/ClassCastException
    //   1884	1894	3984	java/lang/ClassCastException
    //   1924	1931	4002	java/lang/ClassCastException
    //   1948	1958	4020	java/lang/ClassCastException
    //   1581	1588	4038	java/lang/ClassCastException
    //   2141	2148	4056	java/lang/ClassCastException
    //   1645	1652	4074	java/lang/ClassCastException
    //   1711	1721	4092	java/lang/ClassCastException
    //   2278	2288	4110	java/lang/ClassCastException
    //   2314	2319	4128	java/lang/ClassCastException
    //   2357	2364	4147	java/lang/ClassCastException
    //   2440	2447	4165	java/lang/ClassCastException
    //   2464	2474	4183	java/lang/ClassCastException
    //   3173	3180	4201	java/lang/ClassCastException
    //   3511	3518	4219	java/lang/ClassCastException
    //   3537	3544	4237	java/lang/ClassCastException
    //   3204	3211	4255	java/lang/ClassCastException
    //   3590	3597	4273	java/lang/ClassCastException
  }

  public static Object stdio$ClParseFloat(Object paramObject1, Object paramObject2)
  {
    frame localframe = new frame();
    localframe.str = paramObject1;
    localframe.proc = paramObject2;
    Object localObject = localframe.str;
    try
    {
      CharSequence localCharSequence = (CharSequence)localObject;
      localframe.n = strings.stringLength(localCharSequence);
      return localframe.lambda4real(Lit1, localframe.lambda$Fn1);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "string-length", 1, localObject);
    }
  }

  // ERROR //
  public static Object stdio$ClRoundString(CharSequence paramCharSequence, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: new 801	gnu/kawa/slib/printf$frame8
    //   3: dup
    //   4: invokespecial 802	gnu/kawa/slib/printf$frame8:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   13: aload_3
    //   14: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   17: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   20: iconst_1
    //   21: isub
    //   22: istore 4
    //   24: getstatic 808	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   27: aload_1
    //   28: getstatic 354	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   31: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   34: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   37: if_acmpeq +103 -> 140
    //   40: ldc 179
    //   42: astore 30
    //   44: aload_2
    //   45: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   48: if_acmpeq +688 -> 736
    //   51: aload 30
    //   53: checkcast 450	java/lang/CharSequence
    //   56: astore 32
    //   58: aload 32
    //   60: invokestatic 454	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   63: iconst_1
    //   64: isub
    //   65: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: astore 33
    //   70: getstatic 670	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
    //   73: aload 33
    //   75: aload_2
    //   76: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: astore 34
    //   81: aload 34
    //   83: checkcast 483	java/lang/Boolean
    //   86: invokevirtual 811	java/lang/Boolean:booleanValue	()Z
    //   89: istore 36
    //   91: iload 36
    //   93: ifeq +587 -> 680
    //   96: iload 36
    //   98: ifeq +622 -> 720
    //   101: aload 30
    //   103: checkcast 450	java/lang/CharSequence
    //   106: astore 43
    //   108: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   111: aload 33
    //   113: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   116: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: astore 44
    //   121: aload 44
    //   123: checkcast 473	java/lang/Number
    //   126: invokevirtual 477	java/lang/Number:intValue	()I
    //   129: istore 46
    //   131: aload 43
    //   133: iconst_0
    //   134: iload 46
    //   136: invokestatic 506	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   139: areturn
    //   140: getstatic 814	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   143: iload 4
    //   145: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aload_1
    //   149: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   152: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   155: if_acmpeq +12 -> 167
    //   158: aload_3
    //   159: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   162: astore 30
    //   164: goto -120 -> 44
    //   167: getstatic 808	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   170: iload 4
    //   172: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aload_1
    //   176: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   182: if_acmpeq +156 -> 338
    //   185: iconst_2
    //   186: anewarray 161	java/lang/Object
    //   189: astore 51
    //   191: aload 51
    //   193: iconst_0
    //   194: getstatic 354	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   197: aastore
    //   198: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   201: astore 52
    //   203: aload_2
    //   204: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   207: if_acmpeq +5 -> 212
    //   210: aload_2
    //   211: astore_1
    //   212: aload 51
    //   214: iconst_1
    //   215: aload 52
    //   217: aload_1
    //   218: iload 4
    //   220: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   226: aastore
    //   227: aload 51
    //   229: invokestatic 818	kawa/lib/numbers:max	([Ljava/lang/Object;)Ljava/lang/Object;
    //   232: astore 53
    //   234: aload 53
    //   236: checkcast 473	java/lang/Number
    //   239: astore 55
    //   241: aload 55
    //   243: invokestatic 751	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   246: ifeq +16 -> 262
    //   249: aload_3
    //   250: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   253: astore 60
    //   255: aload 60
    //   257: astore 30
    //   259: goto -215 -> 44
    //   262: iconst_2
    //   263: anewarray 161	java/lang/Object
    //   266: astore 56
    //   268: aload 56
    //   270: iconst_0
    //   271: aload_3
    //   272: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   275: aastore
    //   276: aload 53
    //   278: checkcast 473	java/lang/Number
    //   281: invokevirtual 477	java/lang/Number:intValue	()I
    //   284: istore 58
    //   286: aload_3
    //   287: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   290: iload 4
    //   292: invokestatic 538	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   295: invokestatic 133	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   298: invokestatic 822	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   301: ifeq +29 -> 330
    //   304: getstatic 338	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
    //   307: astore 59
    //   309: aload 56
    //   311: iconst_1
    //   312: iload 58
    //   314: aload 59
    //   316: invokestatic 693	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
    //   319: aastore
    //   320: aload 56
    //   322: invokestatic 826	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   325: astore 60
    //   327: goto -72 -> 255
    //   330: getstatic 340	gnu/kawa/slib/printf:Lit8	Lgnu/text/Char;
    //   333: astore 59
    //   335: goto -26 -> 309
    //   338: aload_3
    //   339: getfield 805	gnu/kawa/slib/printf$frame8:str	Ljava/lang/CharSequence;
    //   342: astore 5
    //   344: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   347: aload_1
    //   348: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   351: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   354: astore 6
    //   356: aload 6
    //   358: checkcast 473	java/lang/Number
    //   361: invokevirtual 477	java/lang/Number:intValue	()I
    //   364: istore 8
    //   366: aload 5
    //   368: iconst_0
    //   369: iload 8
    //   371: invokestatic 506	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   374: astore 9
    //   376: aload_3
    //   377: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   380: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   383: aload_1
    //   384: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   387: invokevirtual 829	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   390: astore 10
    //   392: getstatic 690	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
    //   395: aload 10
    //   397: getstatic 320	gnu/kawa/slib/printf:Lit15	Lgnu/math/IntNum;
    //   400: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   403: astore 11
    //   405: aload 11
    //   407: checkcast 483	java/lang/Boolean
    //   410: invokevirtual 811	java/lang/Boolean:booleanValue	()Z
    //   413: istore 13
    //   415: iload 13
    //   417: ifeq +96 -> 513
    //   420: iload 13
    //   422: ifeq +84 -> 506
    //   425: aload_1
    //   426: astore 17
    //   428: aload_3
    //   429: aload 17
    //   431: invokevirtual 829	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   434: astore 18
    //   436: getstatic 808	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   439: aload 18
    //   441: getstatic 318	gnu/kawa/slib/printf:Lit16	Lgnu/math/IntNum;
    //   444: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   447: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   450: if_acmpeq +188 -> 638
    //   453: aload 9
    //   455: checkcast 831	gnu/lists/CharSeq
    //   458: astore 24
    //   460: aload 17
    //   462: checkcast 473	java/lang/Number
    //   465: invokevirtual 477	java/lang/Number:intValue	()I
    //   468: istore 26
    //   470: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   473: aload 18
    //   475: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   478: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   481: astore 27
    //   483: aload 27
    //   485: checkcast 473	java/lang/Number
    //   488: astore 29
    //   490: aload 24
    //   492: iload 26
    //   494: aload 29
    //   496: invokestatic 735	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   499: iconst_0
    //   500: invokestatic 538	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   503: invokestatic 835	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   506: aload 9
    //   508: astore 30
    //   510: goto -466 -> 44
    //   513: getstatic 814	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   516: aload 10
    //   518: getstatic 320	gnu/kawa/slib/printf:Lit15	Lgnu/math/IntNum;
    //   521: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   524: astore 14
    //   526: aload 14
    //   528: checkcast 483	java/lang/Boolean
    //   531: invokevirtual 811	java/lang/Boolean:booleanValue	()Z
    //   534: istore 16
    //   536: iload 16
    //   538: ifeq +92 -> 630
    //   541: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   544: getstatic 322	gnu/kawa/slib/printf:Lit14	Lgnu/math/IntNum;
    //   547: aload_1
    //   548: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   551: astore 47
    //   553: getstatic 690	kawa/standard/Scheme:numGrt	Lgnu/kawa/functions/NumberCompare;
    //   556: aload 47
    //   558: iload 4
    //   560: invokestatic 460	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   566: getstatic 487	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   569: if_acmpeq +22 -> 591
    //   572: iconst_1
    //   573: aload_3
    //   574: aload_1
    //   575: invokevirtual 829	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   578: checkcast 473	java/lang/Number
    //   581: invokevirtual 477	java/lang/Number:intValue	()I
    //   584: iand
    //   585: ifeq -79 -> 506
    //   588: goto -163 -> 425
    //   591: aload_3
    //   592: aload 47
    //   594: invokevirtual 829	gnu/kawa/slib/printf$frame8:lambda17dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   597: astore 48
    //   599: aload 48
    //   601: checkcast 473	java/lang/Number
    //   604: astore 50
    //   606: aload 50
    //   608: invokestatic 751	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   611: ifeq -186 -> 425
    //   614: getstatic 563	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   617: aload 47
    //   619: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   622: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   625: astore 47
    //   627: goto -74 -> 553
    //   630: iload 16
    //   632: ifeq -126 -> 506
    //   635: goto -210 -> 425
    //   638: aload 9
    //   640: checkcast 831	gnu/lists/CharSeq
    //   643: astore 20
    //   645: aload 17
    //   647: checkcast 473	java/lang/Number
    //   650: invokevirtual 477	java/lang/Number:intValue	()I
    //   653: istore 22
    //   655: aload 20
    //   657: iload 22
    //   659: bipush 48
    //   661: invokestatic 835	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   664: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   667: aload 17
    //   669: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   672: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   675: astore 17
    //   677: goto -249 -> 428
    //   680: getstatic 338	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
    //   683: astore 37
    //   685: aload 30
    //   687: checkcast 450	java/lang/CharSequence
    //   690: astore 39
    //   692: aload 33
    //   694: checkcast 473	java/lang/Number
    //   697: invokevirtual 477	java/lang/Number:intValue	()I
    //   700: istore 41
    //   702: aload 37
    //   704: aload 39
    //   706: iload 41
    //   708: invokestatic 538	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   711: invokestatic 133	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   714: invokestatic 840	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   717: ifeq -616 -> 101
    //   720: getstatic 621	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   723: aload 33
    //   725: getstatic 342	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
    //   728: invokevirtual 502	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   731: astore 33
    //   733: goto -663 -> 70
    //   736: aload 30
    //   738: areturn
    //   739: astore 54
    //   741: new 508	gnu/mapping/WrongType
    //   744: dup
    //   745: aload 54
    //   747: ldc_w 778
    //   750: iconst_1
    //   751: aload 53
    //   753: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   756: athrow
    //   757: astore 57
    //   759: new 508	gnu/mapping/WrongType
    //   762: dup
    //   763: aload 57
    //   765: ldc_w 510
    //   768: iconst_1
    //   769: aload 53
    //   771: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   774: athrow
    //   775: astore 7
    //   777: new 508	gnu/mapping/WrongType
    //   780: dup
    //   781: aload 7
    //   783: ldc_w 516
    //   786: iconst_3
    //   787: aload 6
    //   789: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   792: athrow
    //   793: astore 12
    //   795: new 508	gnu/mapping/WrongType
    //   798: dup
    //   799: aload 12
    //   801: ldc_w 776
    //   804: bipush 254
    //   806: aload 11
    //   808: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   811: athrow
    //   812: astore 15
    //   814: new 508	gnu/mapping/WrongType
    //   817: dup
    //   818: aload 15
    //   820: ldc_w 776
    //   823: bipush 254
    //   825: aload 14
    //   827: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   830: athrow
    //   831: astore 49
    //   833: new 508	gnu/mapping/WrongType
    //   836: dup
    //   837: aload 49
    //   839: ldc_w 778
    //   842: iconst_1
    //   843: aload 48
    //   845: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   848: athrow
    //   849: astore 23
    //   851: new 508	gnu/mapping/WrongType
    //   854: dup
    //   855: aload 23
    //   857: ldc_w 842
    //   860: iconst_1
    //   861: aload 9
    //   863: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   866: athrow
    //   867: astore 25
    //   869: new 508	gnu/mapping/WrongType
    //   872: dup
    //   873: aload 25
    //   875: ldc_w 842
    //   878: iconst_2
    //   879: aload 17
    //   881: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   884: athrow
    //   885: astore 28
    //   887: new 508	gnu/mapping/WrongType
    //   890: dup
    //   891: aload 28
    //   893: ldc_w 844
    //   896: iconst_1
    //   897: aload 27
    //   899: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   902: athrow
    //   903: astore 19
    //   905: new 508	gnu/mapping/WrongType
    //   908: dup
    //   909: aload 19
    //   911: ldc_w 842
    //   914: iconst_1
    //   915: aload 9
    //   917: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   920: athrow
    //   921: astore 21
    //   923: new 508	gnu/mapping/WrongType
    //   926: dup
    //   927: aload 21
    //   929: ldc_w 842
    //   932: iconst_2
    //   933: aload 17
    //   935: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   938: athrow
    //   939: astore 31
    //   941: new 508	gnu/mapping/WrongType
    //   944: dup
    //   945: aload 31
    //   947: ldc_w 515
    //   950: iconst_1
    //   951: aload 30
    //   953: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   956: athrow
    //   957: astore 35
    //   959: new 508	gnu/mapping/WrongType
    //   962: dup
    //   963: aload 35
    //   965: ldc_w 776
    //   968: bipush 254
    //   970: aload 34
    //   972: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   975: athrow
    //   976: astore 38
    //   978: new 508	gnu/mapping/WrongType
    //   981: dup
    //   982: aload 38
    //   984: ldc_w 768
    //   987: iconst_1
    //   988: aload 30
    //   990: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   993: athrow
    //   994: astore 40
    //   996: new 508	gnu/mapping/WrongType
    //   999: dup
    //   1000: aload 40
    //   1002: ldc_w 768
    //   1005: iconst_2
    //   1006: aload 33
    //   1008: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1011: athrow
    //   1012: astore 42
    //   1014: new 508	gnu/mapping/WrongType
    //   1017: dup
    //   1018: aload 42
    //   1020: ldc_w 516
    //   1023: iconst_1
    //   1024: aload 30
    //   1026: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1029: athrow
    //   1030: astore 45
    //   1032: new 508	gnu/mapping/WrongType
    //   1035: dup
    //   1036: aload 45
    //   1038: ldc_w 516
    //   1041: iconst_3
    //   1042: aload 44
    //   1044: invokespecial 513	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1047: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   234	241	739	java/lang/ClassCastException
    //   276	286	757	java/lang/ClassCastException
    //   356	366	775	java/lang/ClassCastException
    //   405	415	793	java/lang/ClassCastException
    //   526	536	812	java/lang/ClassCastException
    //   599	606	831	java/lang/ClassCastException
    //   453	460	849	java/lang/ClassCastException
    //   460	470	867	java/lang/ClassCastException
    //   483	490	885	java/lang/ClassCastException
    //   638	645	903	java/lang/ClassCastException
    //   645	655	921	java/lang/ClassCastException
    //   51	58	939	java/lang/ClassCastException
    //   81	91	957	java/lang/ClassCastException
    //   685	692	976	java/lang/ClassCastException
    //   692	702	994	java/lang/ClassCastException
    //   101	108	1012	java/lang/ClassCastException
    //   121	131	1030	java/lang/ClassCastException
  }

  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    if (paramModuleMethod.selector == 22)
      return stdio$ClParseFloat(paramObject1, paramObject2);
    return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }

  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (paramModuleMethod.selector == 23);
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject1;
      return stdio$ClRoundString(localCharSequence, paramObject2, paramObject3);
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "stdio:round-string", 1, paramObject1);
    }
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 24:
      Object localObject6 = paramArrayOfObject[0];
      Object localObject7 = paramArrayOfObject[1];
      int i2 = paramArrayOfObject.length - 2;
      Object[] arrayOfObject4 = new Object[i2];
      int i3 = i2;
      while (true)
      {
        i3--;
        if (i3 < 0)
          return stdio$ClIprintf$V(localObject6, localObject7, arrayOfObject4);
        arrayOfObject4[i3] = paramArrayOfObject[(i3 + 2)];
      }
    case 25:
      Object localObject4 = paramArrayOfObject[0];
      Object localObject5 = paramArrayOfObject[1];
      int n = paramArrayOfObject.length - 2;
      Object[] arrayOfObject3 = new Object[n];
      int i1 = n;
      while (true)
      {
        i1--;
        if (i1 < 0)
          return fprintf$V(localObject4, localObject5, arrayOfObject3);
        arrayOfObject3[i1] = paramArrayOfObject[(i1 + 2)];
      }
    case 26:
      Object localObject3 = paramArrayOfObject[0];
      int k = paramArrayOfObject.length - 1;
      Object[] arrayOfObject2 = new Object[k];
      int m = k;
      while (true)
      {
        m--;
        if (m < 0)
          return printf$V(localObject3, arrayOfObject2);
        arrayOfObject2[m] = paramArrayOfObject[(m + 1)];
      }
    case 27:
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
        return sprintf$V(localObject1, localObject2, arrayOfObject1);
      arrayOfObject1[j] = paramArrayOfObject[(j + 2)];
    }
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 22)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 23)
    {
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    }
    return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 27:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 26:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 25:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 24:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
    stdio$Clhex$Mnupper$Mncase$Qu = strings.isString$Eq("-F", numbers.number$To$String(Lit0, 16));
  }

  public class frame extends ModuleBody
  {
    final ModuleMethod lambda$Fn1;
    int n;
    Object proc;
    Object str;

    public frame()
    {
      this$1 = new ModuleMethod(this, 12, null, 16388);
      this$1.setProperty("source-location", "printf.scm:106");
      this.lambda$Fn1 = this$1;
    }

    public static Boolean lambda1parseError()
    {
      return Boolean.FALSE;
    }

    public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      if (paramModuleMethod.selector == 12)
        return lambda5(paramObject1, paramObject2, paramObject3, paramObject4);
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }

    // ERROR //
    public Object lambda2sign(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 61	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   3: aload_1
      //   4: aload_0
      //   5: getfield 63	gnu/kawa/slib/printf$frame:n	I
      //   8: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   11: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   14: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   17: if_acmpeq +119 -> 136
      //   20: aload_0
      //   21: getfield 76	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   24: astore_3
      //   25: aload_3
      //   26: checkcast 78	java/lang/CharSequence
      //   29: astore 5
      //   31: aload_1
      //   32: checkcast 80	java/lang/Number
      //   35: invokevirtual 84	java/lang/Number:intValue	()I
      //   38: istore 7
      //   40: aload 5
      //   42: iload 7
      //   44: invokestatic 90	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   47: istore 8
      //   49: getstatic 94	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   52: iload 8
      //   54: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   57: getstatic 106	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
      //   60: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   63: astore 9
      //   65: aload 9
      //   67: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   70: if_acmpeq +34 -> 104
      //   73: aload 9
      //   75: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   78: if_acmpeq +46 -> 124
      //   81: getstatic 110	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   84: aload_2
      //   85: getstatic 116	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   88: aload_1
      //   89: getstatic 120	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   92: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   95: iload 8
      //   97: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   100: invokevirtual 124	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   103: areturn
      //   104: getstatic 94	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   107: iload 8
      //   109: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   112: getstatic 127	gnu/kawa/slib/printf:Lit6	Lgnu/text/Char;
      //   115: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   118: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   121: if_acmpne -40 -> 81
      //   124: getstatic 110	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   127: aload_2
      //   128: aload_1
      //   129: getstatic 127	gnu/kawa/slib/printf:Lit6	Lgnu/text/Char;
      //   132: invokevirtual 124	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   135: areturn
      //   136: getstatic 133	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   139: areturn
      //   140: astore 4
      //   142: new 135	gnu/mapping/WrongType
      //   145: dup
      //   146: aload 4
      //   148: ldc 137
      //   150: iconst_1
      //   151: aload_3
      //   152: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   155: athrow
      //   156: astore 6
      //   158: new 135	gnu/mapping/WrongType
      //   161: dup
      //   162: aload 6
      //   164: ldc 137
      //   166: iconst_2
      //   167: aload_1
      //   168: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   171: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   25	31	140	java/lang/ClassCastException
      //   31	40	156	java/lang/ClassCastException
    }

    // ERROR //
    public Object lambda3digits(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: aload_1
      //   1: astore_3
      //   2: getstatic 144	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   5: aload_3
      //   6: aload_0
      //   7: getfield 63	gnu/kawa/slib/printf$frame:n	I
      //   10: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   13: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   16: astore 4
      //   18: aload 4
      //   20: checkcast 36	java/lang/Boolean
      //   23: invokevirtual 148	java/lang/Boolean:booleanValue	()Z
      //   26: istore 6
      //   28: iload 6
      //   30: ifeq +22 -> 52
      //   33: iload 6
      //   35: ifne +64 -> 99
      //   38: getstatic 116	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   41: aload_3
      //   42: getstatic 120	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   45: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   48: astore_3
      //   49: goto -47 -> 2
      //   52: aload_0
      //   53: getfield 76	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   56: astore 7
      //   58: aload 7
      //   60: checkcast 78	java/lang/CharSequence
      //   63: astore 9
      //   65: aload_3
      //   66: checkcast 80	java/lang/Number
      //   69: invokevirtual 84	java/lang/Number:intValue	()I
      //   72: istore 11
      //   74: aload 9
      //   76: iload 11
      //   78: invokestatic 90	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   81: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   84: invokestatic 154	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
      //   87: istore 12
      //   89: iload 12
      //   91: ifeq +41 -> 132
      //   94: iload 12
      //   96: ifne -58 -> 38
      //   99: getstatic 110	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   102: astore 19
      //   104: getstatic 157	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   107: aload_1
      //   108: aload_3
      //   109: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   112: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   115: if_acmpeq +65 -> 180
      //   118: ldc 159
      //   120: astore 27
      //   122: aload 19
      //   124: aload_2
      //   125: aload_3
      //   126: aload 27
      //   128: invokevirtual 124	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   131: areturn
      //   132: getstatic 162	gnu/kawa/slib/printf:Lit8	Lgnu/text/Char;
      //   135: astore 13
      //   137: aload_0
      //   138: getfield 76	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   141: astore 14
      //   143: aload 14
      //   145: checkcast 78	java/lang/CharSequence
      //   148: astore 16
      //   150: aload_3
      //   151: checkcast 80	java/lang/Number
      //   154: invokevirtual 84	java/lang/Number:intValue	()I
      //   157: istore 18
      //   159: aload 13
      //   161: aload 16
      //   163: iload 18
      //   165: invokestatic 90	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   168: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   171: invokestatic 168	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   174: ifeq -75 -> 99
      //   177: goto -139 -> 38
      //   180: aload_0
      //   181: getfield 76	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   184: astore 20
      //   186: aload 20
      //   188: checkcast 78	java/lang/CharSequence
      //   191: astore 22
      //   193: aload_1
      //   194: checkcast 80	java/lang/Number
      //   197: invokevirtual 84	java/lang/Number:intValue	()I
      //   200: istore 24
      //   202: aload_3
      //   203: checkcast 80	java/lang/Number
      //   206: invokevirtual 84	java/lang/Number:intValue	()I
      //   209: istore 26
      //   211: aload 22
      //   213: iload 24
      //   215: iload 26
      //   217: invokestatic 172	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   220: astore 27
      //   222: goto -100 -> 122
      //   225: astore 5
      //   227: new 135	gnu/mapping/WrongType
      //   230: dup
      //   231: aload 5
      //   233: ldc 174
      //   235: bipush 254
      //   237: aload 4
      //   239: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   242: athrow
      //   243: astore 8
      //   245: new 135	gnu/mapping/WrongType
      //   248: dup
      //   249: aload 8
      //   251: ldc 137
      //   253: iconst_1
      //   254: aload 7
      //   256: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   259: athrow
      //   260: astore 10
      //   262: new 135	gnu/mapping/WrongType
      //   265: dup
      //   266: aload 10
      //   268: ldc 137
      //   270: iconst_2
      //   271: aload_3
      //   272: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   275: athrow
      //   276: astore 15
      //   278: new 135	gnu/mapping/WrongType
      //   281: dup
      //   282: aload 15
      //   284: ldc 137
      //   286: iconst_1
      //   287: aload 14
      //   289: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   292: athrow
      //   293: astore 17
      //   295: new 135	gnu/mapping/WrongType
      //   298: dup
      //   299: aload 17
      //   301: ldc 137
      //   303: iconst_2
      //   304: aload_3
      //   305: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   308: athrow
      //   309: astore 21
      //   311: new 135	gnu/mapping/WrongType
      //   314: dup
      //   315: aload 21
      //   317: ldc 175
      //   319: iconst_1
      //   320: aload 20
      //   322: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   325: athrow
      //   326: astore 23
      //   328: new 135	gnu/mapping/WrongType
      //   331: dup
      //   332: aload 23
      //   334: ldc 175
      //   336: iconst_2
      //   337: aload_1
      //   338: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   341: athrow
      //   342: astore 25
      //   344: new 135	gnu/mapping/WrongType
      //   347: dup
      //   348: aload 25
      //   350: ldc 175
      //   352: iconst_3
      //   353: aload_3
      //   354: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   357: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   18	28	225	java/lang/ClassCastException
      //   58	65	243	java/lang/ClassCastException
      //   65	74	260	java/lang/ClassCastException
      //   143	150	276	java/lang/ClassCastException
      //   150	159	293	java/lang/ClassCastException
      //   186	193	309	java/lang/ClassCastException
      //   193	202	326	java/lang/ClassCastException
      //   202	211	342	java/lang/ClassCastException
    }

    // ERROR //
    public Object lambda4real(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: new 178	gnu/kawa/slib/printf$frame2
      //   3: dup
      //   4: invokespecial 179	gnu/kawa/slib/printf$frame2:<init>	()V
      //   7: astore_3
      //   8: aload_3
      //   9: aload_0
      //   10: putfield 183	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   13: aload_3
      //   14: aload_2
      //   15: putfield 186	gnu/kawa/slib/printf$frame2:cont	Ljava/lang/Object;
      //   18: aload_3
      //   19: getfield 189	gnu/kawa/slib/printf$frame2:lambda$Fn5	Lgnu/expr/ModuleMethod;
      //   22: astore 4
      //   24: getstatic 61	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   27: aload_1
      //   28: aload_0
      //   29: getfield 63	gnu/kawa/slib/printf$frame:n	I
      //   32: iconst_1
      //   33: isub
      //   34: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   37: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   40: astore 5
      //   42: aload 5
      //   44: checkcast 36	java/lang/Boolean
      //   47: invokevirtual 148	java/lang/Boolean:booleanValue	()Z
      //   50: istore 7
      //   52: iload 7
      //   54: ifeq +138 -> 192
      //   57: getstatic 162	gnu/kawa/slib/printf:Lit8	Lgnu/text/Char;
      //   60: astore 17
      //   62: aload_0
      //   63: getfield 76	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   66: astore 18
      //   68: aload 18
      //   70: checkcast 78	java/lang/CharSequence
      //   73: astore 20
      //   75: aload_1
      //   76: checkcast 80	java/lang/Number
      //   79: invokevirtual 84	java/lang/Number:intValue	()I
      //   82: istore 22
      //   84: aload 17
      //   86: aload 20
      //   88: iload 22
      //   90: invokestatic 90	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   93: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   96: invokestatic 168	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   99: ifeq +98 -> 197
      //   102: aload_0
      //   103: getfield 76	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   106: astore 8
      //   108: aload 8
      //   110: checkcast 78	java/lang/CharSequence
      //   113: astore 10
      //   115: getstatic 116	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   118: aload_1
      //   119: getstatic 120	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   122: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   125: astore 11
      //   127: aload 11
      //   129: checkcast 80	java/lang/Number
      //   132: invokevirtual 84	java/lang/Number:intValue	()I
      //   135: istore 13
      //   137: aload 10
      //   139: iload 13
      //   141: invokestatic 90	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   144: istore 14
      //   146: getstatic 94	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   149: iload 14
      //   151: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   154: getstatic 192	gnu/kawa/slib/printf:Lit12	Lgnu/text/Char;
      //   157: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   160: astore 15
      //   162: aload 15
      //   164: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   167: if_acmpeq +40 -> 207
      //   170: aload 15
      //   172: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   175: if_acmpeq +64 -> 239
      //   178: getstatic 116	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   181: aload_1
      //   182: getstatic 195	gnu/kawa/slib/printf:Lit14	Lgnu/math/IntNum;
      //   185: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   188: astore_1
      //   189: goto -165 -> 24
      //   192: iload 7
      //   194: ifne -92 -> 102
      //   197: getstatic 110	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   200: aload 4
      //   202: aload_1
      //   203: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   206: areturn
      //   207: getstatic 94	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   210: iload 14
      //   212: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   215: getstatic 198	gnu/kawa/slib/printf:Lit3	Lgnu/text/Char;
      //   218: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   221: astore 16
      //   223: aload 16
      //   225: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   228: if_acmpeq +41 -> 269
      //   231: aload 16
      //   233: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   236: if_acmpne -58 -> 178
      //   239: getstatic 94	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   242: iload 14
      //   244: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   247: getstatic 201	gnu/kawa/slib/printf:Lit11	Lgnu/text/Char;
      //   250: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   253: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   256: if_acmpeq +36 -> 292
      //   259: getstatic 110	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   262: aload 4
      //   264: aload_1
      //   265: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   268: areturn
      //   269: getstatic 94	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   272: iload 14
      //   274: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   277: getstatic 204	gnu/kawa/slib/printf:Lit13	Lgnu/text/Char;
      //   280: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   283: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   286: if_acmpeq -47 -> 239
      //   289: goto -111 -> 178
      //   292: invokestatic 206	gnu/kawa/slib/printf$frame:lambda1parseError	()Ljava/lang/Boolean;
      //   295: areturn
      //   296: astore 6
      //   298: new 135	gnu/mapping/WrongType
      //   301: dup
      //   302: aload 6
      //   304: ldc 174
      //   306: bipush 254
      //   308: aload 5
      //   310: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   313: athrow
      //   314: astore 19
      //   316: new 135	gnu/mapping/WrongType
      //   319: dup
      //   320: aload 19
      //   322: ldc 137
      //   324: iconst_1
      //   325: aload 18
      //   327: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   330: athrow
      //   331: astore 21
      //   333: new 135	gnu/mapping/WrongType
      //   336: dup
      //   337: aload 21
      //   339: ldc 137
      //   341: iconst_2
      //   342: aload_1
      //   343: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   346: athrow
      //   347: astore 9
      //   349: new 135	gnu/mapping/WrongType
      //   352: dup
      //   353: aload 9
      //   355: ldc 137
      //   357: iconst_1
      //   358: aload 8
      //   360: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   363: athrow
      //   364: astore 12
      //   366: new 135	gnu/mapping/WrongType
      //   369: dup
      //   370: aload 12
      //   372: ldc 137
      //   374: iconst_2
      //   375: aload 11
      //   377: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   380: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   42	52	296	java/lang/ClassCastException
      //   68	75	314	java/lang/ClassCastException
      //   75	84	331	java/lang/ClassCastException
      //   108	115	347	java/lang/ClassCastException
      //   127	137	364	java/lang/ClassCastException
    }

    // ERROR //
    Object lambda5(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      // Byte code:
      //   0: new 208	gnu/kawa/slib/printf$frame0
      //   3: dup
      //   4: invokespecial 209	gnu/kawa/slib/printf$frame0:<init>	()V
      //   7: astore 5
      //   9: aload 5
      //   11: aload_0
      //   12: putfield 210	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   15: aload 5
      //   17: aload_2
      //   18: putfield 213	gnu/kawa/slib/printf$frame0:sgn	Ljava/lang/Object;
      //   21: aload 5
      //   23: aload_3
      //   24: putfield 216	gnu/kawa/slib/printf$frame0:digs	Ljava/lang/Object;
      //   27: aload 5
      //   29: aload 4
      //   31: putfield 219	gnu/kawa/slib/printf$frame0:ex	Ljava/lang/Object;
      //   34: getstatic 157	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   37: aload_1
      //   38: aload_0
      //   39: getfield 63	gnu/kawa/slib/printf$frame:n	I
      //   42: invokestatic 69	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   45: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   48: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   51: if_acmpeq +29 -> 80
      //   54: getstatic 110	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   57: aload_0
      //   58: getfield 221	gnu/kawa/slib/printf$frame:proc	Ljava/lang/Object;
      //   61: aload 5
      //   63: getfield 213	gnu/kawa/slib/printf$frame0:sgn	Ljava/lang/Object;
      //   66: aload 5
      //   68: getfield 216	gnu/kawa/slib/printf$frame0:digs	Ljava/lang/Object;
      //   71: aload 5
      //   73: getfield 219	gnu/kawa/slib/printf$frame0:ex	Ljava/lang/Object;
      //   76: invokevirtual 223	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   79: areturn
      //   80: aload_0
      //   81: getfield 76	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   84: astore 6
      //   86: aload 6
      //   88: checkcast 78	java/lang/CharSequence
      //   91: astore 8
      //   93: aload_1
      //   94: checkcast 80	java/lang/Number
      //   97: invokevirtual 84	java/lang/Number:intValue	()I
      //   100: istore 10
      //   102: aload 8
      //   104: iload 10
      //   106: invokestatic 90	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   109: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   112: getstatic 227	gnu/kawa/slib/printf:Lit2	Lgnu/lists/PairWithPosition;
      //   115: invokestatic 232	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   118: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   121: if_acmpeq +14 -> 135
      //   124: aload_0
      //   125: aload_1
      //   126: aload 5
      //   128: getfield 235	gnu/kawa/slib/printf$frame0:lambda$Fn2	Lgnu/expr/ModuleMethod;
      //   131: invokevirtual 237	gnu/kawa/slib/printf$frame:lambda4real	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   134: areturn
      //   135: getstatic 94	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   138: astore 11
      //   140: aload_0
      //   141: getfield 76	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   144: astore 12
      //   146: aload 12
      //   148: checkcast 78	java/lang/CharSequence
      //   151: astore 14
      //   153: aload_1
      //   154: checkcast 80	java/lang/Number
      //   157: invokevirtual 84	java/lang/Number:intValue	()I
      //   160: istore 16
      //   162: aload 11
      //   164: aload 14
      //   166: iload 16
      //   168: invokestatic 90	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   171: invokestatic 100	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   174: getstatic 240	gnu/kawa/slib/printf:Lit4	Lgnu/text/Char;
      //   177: invokevirtual 74	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   180: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   183: if_acmpeq +72 -> 255
      //   186: aload_0
      //   187: getfield 76	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   190: astore 17
      //   192: aload 17
      //   194: checkcast 78	java/lang/CharSequence
      //   197: astore 19
      //   199: aload 5
      //   201: aload 19
      //   203: invokestatic 246	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
      //   206: putfield 249	gnu/kawa/slib/printf$frame0:num	Ljava/lang/Object;
      //   209: aload 5
      //   211: getfield 249	gnu/kawa/slib/printf$frame0:num	Ljava/lang/Object;
      //   214: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   217: if_acmpeq +34 -> 251
      //   220: aload 5
      //   222: getfield 249	gnu/kawa/slib/printf$frame0:num	Ljava/lang/Object;
      //   225: astore 20
      //   227: aload 20
      //   229: checkcast 251	gnu/math/Complex
      //   232: astore 22
      //   234: aload 22
      //   236: invokestatic 255	kawa/lib/numbers:realPart	(Lgnu/math/Complex;)Lgnu/math/RealNum;
      //   239: invokestatic 259	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
      //   242: aload 5
      //   244: getfield 262	gnu/kawa/slib/printf$frame0:lambda$Fn3	Lgnu/expr/ModuleMethod;
      //   247: invokestatic 265	gnu/kawa/slib/printf:stdio$ClParseFloat	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   250: areturn
      //   251: invokestatic 206	gnu/kawa/slib/printf$frame:lambda1parseError	()Ljava/lang/Boolean;
      //   254: areturn
      //   255: getstatic 40	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   258: areturn
      //   259: astore 7
      //   261: new 135	gnu/mapping/WrongType
      //   264: dup
      //   265: aload 7
      //   267: ldc 137
      //   269: iconst_1
      //   270: aload 6
      //   272: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   275: athrow
      //   276: astore 9
      //   278: new 135	gnu/mapping/WrongType
      //   281: dup
      //   282: aload 9
      //   284: ldc 137
      //   286: iconst_2
      //   287: aload_1
      //   288: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   291: athrow
      //   292: astore 13
      //   294: new 135	gnu/mapping/WrongType
      //   297: dup
      //   298: aload 13
      //   300: ldc 137
      //   302: iconst_1
      //   303: aload 12
      //   305: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   308: athrow
      //   309: astore 15
      //   311: new 135	gnu/mapping/WrongType
      //   314: dup
      //   315: aload 15
      //   317: ldc 137
      //   319: iconst_2
      //   320: aload_1
      //   321: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   324: athrow
      //   325: astore 18
      //   327: new 135	gnu/mapping/WrongType
      //   330: dup
      //   331: aload 18
      //   333: ldc_w 267
      //   336: iconst_1
      //   337: aload 17
      //   339: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   342: athrow
      //   343: astore 21
      //   345: new 135	gnu/mapping/WrongType
      //   348: dup
      //   349: aload 21
      //   351: ldc_w 269
      //   354: iconst_1
      //   355: aload 20
      //   357: invokespecial 140	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   360: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   86	93	259	java/lang/ClassCastException
      //   93	102	276	java/lang/ClassCastException
      //   146	153	292	java/lang/ClassCastException
      //   153	162	309	java/lang/ClassCastException
      //   192	199	325	java/lang/ClassCastException
      //   227	234	343	java/lang/ClassCastException
    }

    public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 12)
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
  }

  public class frame0 extends ModuleBody
  {
    Object digs;
    Object ex;
    final ModuleMethod lambda$Fn2;
    final ModuleMethod lambda$Fn3;
    Object num;
    Object sgn;
    printf.frame staticLink;

    public frame0()
    {
      this$1 = new ModuleMethod(this, 2, null, 16388);
      this$1.setProperty("source-location", "printf.scm:111");
      this.lambda$Fn2 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 3, null, 12291);
      localModuleMethod.setProperty("source-location", "printf.scm:123");
      this.lambda$Fn3 = localModuleMethod;
    }

    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 3)
        return lambda7(paramObject1, paramObject2, paramObject3);
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }

    public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      if (paramModuleMethod.selector == 2)
        return lambda6(paramObject1, paramObject2, paramObject3, paramObject4);
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }

    // ERROR //
    Object lambda6(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      // Byte code:
      //   0: getstatic 67	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
      //   3: aload_1
      //   4: aload_0
      //   5: getfield 69	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   8: getfield 74	gnu/kawa/slib/printf$frame:n	I
      //   11: iconst_1
      //   12: isub
      //   13: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   16: invokevirtual 86	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   19: astore 5
      //   21: aload 5
      //   23: checkcast 88	java/lang/Boolean
      //   26: invokevirtual 92	java/lang/Boolean:booleanValue	()Z
      //   29: istore 7
      //   31: iload 7
      //   33: ifeq +123 -> 156
      //   36: getstatic 98	gnu/kawa/slib/printf:Lit3	Lgnu/text/Char;
      //   39: astore 10
      //   41: aload_0
      //   42: getfield 69	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   45: getfield 101	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   48: astore 11
      //   50: aload 11
      //   52: checkcast 103	java/lang/CharSequence
      //   55: astore 13
      //   57: aload_1
      //   58: checkcast 105	java/lang/Number
      //   61: invokevirtual 109	java/lang/Number:intValue	()I
      //   64: istore 15
      //   66: aload 10
      //   68: aload 13
      //   70: iload 15
      //   72: invokestatic 115	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   75: invokestatic 121	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   78: invokestatic 127	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   81: ifeq +80 -> 161
      //   84: getstatic 131	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   87: astore 8
      //   89: bipush 7
      //   91: anewarray 133	java/lang/Object
      //   94: astore 9
      //   96: aload 9
      //   98: iconst_0
      //   99: aload_0
      //   100: getfield 69	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   103: getfield 136	gnu/kawa/slib/printf$frame:proc	Ljava/lang/Object;
      //   106: aastore
      //   107: aload 9
      //   109: iconst_1
      //   110: aload_0
      //   111: getfield 138	gnu/kawa/slib/printf$frame0:sgn	Ljava/lang/Object;
      //   114: aastore
      //   115: aload 9
      //   117: iconst_2
      //   118: aload_0
      //   119: getfield 140	gnu/kawa/slib/printf$frame0:digs	Ljava/lang/Object;
      //   122: aastore
      //   123: aload 9
      //   125: iconst_3
      //   126: aload_0
      //   127: getfield 142	gnu/kawa/slib/printf$frame0:ex	Ljava/lang/Object;
      //   130: aastore
      //   131: aload 9
      //   133: iconst_4
      //   134: aload_2
      //   135: aastore
      //   136: aload 9
      //   138: iconst_5
      //   139: aload_3
      //   140: aastore
      //   141: aload 9
      //   143: bipush 6
      //   145: aload 4
      //   147: aastore
      //   148: aload 8
      //   150: aload 9
      //   152: invokevirtual 146	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   155: areturn
      //   156: iload 7
      //   158: ifne -74 -> 84
      //   161: invokestatic 150	gnu/kawa/slib/printf$frame:lambda1parseError	()Ljava/lang/Boolean;
      //   164: areturn
      //   165: astore 6
      //   167: new 152	gnu/mapping/WrongType
      //   170: dup
      //   171: aload 6
      //   173: ldc 154
      //   175: bipush 254
      //   177: aload 5
      //   179: invokespecial 157	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   182: athrow
      //   183: astore 12
      //   185: new 152	gnu/mapping/WrongType
      //   188: dup
      //   189: aload 12
      //   191: ldc 159
      //   193: iconst_1
      //   194: aload 11
      //   196: invokespecial 157	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   199: athrow
      //   200: astore 14
      //   202: new 152	gnu/mapping/WrongType
      //   205: dup
      //   206: aload 14
      //   208: ldc 159
      //   210: iconst_2
      //   211: aload_1
      //   212: invokespecial 157	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   215: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   21	31	165	java/lang/ClassCastException
      //   50	57	183	java/lang/ClassCastException
      //   57	66	200	java/lang/ClassCastException
    }

    Object lambda7(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      printf.frame1 localframe1 = new printf.frame1();
      localframe1.staticLink = this;
      localframe1.sgn = paramObject1;
      localframe1.digs = paramObject2;
      localframe1.ex = paramObject3;
      Object localObject = this.num;
      try
      {
        Complex localComplex = (Complex)localObject;
        return printf.stdio$ClParseFloat(numbers.number$To$String(numbers.imagPart(localComplex)), localframe1.lambda$Fn4);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "imag-part", 1, localObject);
      }
    }

    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 3)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }

    public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
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
  }

  public class frame1 extends ModuleBody
  {
    Object digs;
    Object ex;
    final ModuleMethod lambda$Fn4;
    Object sgn;
    printf.frame0 staticLink;

    public frame1()
    {
      this$1 = new ModuleMethod(this, 1, null, 12291);
      this$1.setProperty("source-location", "printf.scm:126");
      this.lambda$Fn4 = this$1;
    }

    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 1)
        return lambda8(paramObject1, paramObject2, paramObject3);
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }

    Object lambda8(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
      Object[] arrayOfObject = new Object[7];
      arrayOfObject[0] = this.staticLink.staticLink.proc;
      arrayOfObject[1] = this.sgn;
      arrayOfObject[2] = this.digs;
      arrayOfObject[3] = this.ex;
      arrayOfObject[4] = paramObject1;
      arrayOfObject[5] = paramObject2;
      arrayOfObject[6] = paramObject3;
      return localApplyToArgs.applyN(arrayOfObject);
    }

    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }

  public class frame10 extends ModuleBody
  {
    Object alternate$Mnform;
    Object args;
    Object blank;
    final ModuleMethod lambda$Fn13;
    final ModuleMethod lambda$Fn14;
    final ModuleMethod lambda$Fn15;
    final ModuleMethod lambda$Fn16;
    Object leading$Mn0s;
    Object left$Mnadjust;
    Object os;
    Procedure pad = new ModuleMethod(this, 15, printf.Lit67, -4095);
    Object pr;
    Object precision;
    Object signed;
    printf.frame9 staticLink;
    Object width;

    public frame10()
    {
      this$1 = new ModuleMethod(this, 16, null, 4097);
      this$1.setProperty("source-location", "printf.scm:472");
      this.lambda$Fn13 = this$1;
      ModuleMethod localModuleMethod1 = new ModuleMethod(this, 17, null, 4097);
      localModuleMethod1.setProperty("source-location", "printf.scm:476");
      this.lambda$Fn14 = localModuleMethod1;
      ModuleMethod localModuleMethod2 = new ModuleMethod(this, 18, null, 4097);
      localModuleMethod2.setProperty("source-location", "printf.scm:484");
      this.lambda$Fn15 = localModuleMethod2;
      ModuleMethod localModuleMethod3 = new ModuleMethod(this, 19, null, 4097);
      localModuleMethod3.setProperty("source-location", "printf.scm:494");
      this.lambda$Fn16 = localModuleMethod3;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.apply1(paramModuleMethod, paramObject);
      case 16:
        return lambda25(paramObject);
      case 17:
        if (lambda26(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      case 18:
        return lambda27(paramObject);
      case 19:
      }
      if (lambda28(paramObject))
        return Boolean.TRUE;
      return Boolean.FALSE;
    }

    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      if (paramModuleMethod.selector == 15)
      {
        Object localObject = paramArrayOfObject[0];
        int i = paramArrayOfObject.length - 1;
        Object[] arrayOfObject = new Object[i];
        int j = i;
        while (true)
        {
          j--;
          if (j < 0)
            return lambda23pad$V(localObject, arrayOfObject);
          arrayOfObject[j] = paramArrayOfObject[(j + 1)];
        }
      }
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    }

    public Object lambda22readFormatNumber()
    {
      if (Scheme.isEqv.apply2(printf.Lit66, this.staticLink.fc) != Boolean.FALSE)
      {
        this.staticLink.lambda18mustAdvance();
        Object localObject6 = lists.car.apply1(this.args);
        this.args = lists.cdr.apply1(this.args);
        return localObject6;
      }
      Object localObject1 = this.staticLink.fc;
      Object localObject2 = printf.Lit1;
      while (true)
      {
        Object localObject3 = this.staticLink.fc;
        try
        {
          Char localChar = (Char)localObject3;
          if (unicode.isCharNumeric(localChar))
          {
            this.staticLink.lambda18mustAdvance();
            Object localObject4 = this.staticLink.fc;
            AddOp localAddOp = AddOp.$Pl;
            Object localObject5 = MultiplyOp.$St.apply2(localObject2, printf.Lit45);
            if ((localObject1 instanceof Object[]));
            for (Object[] arrayOfObject = (Object[])localObject1; ; arrayOfObject = new Object[] { localObject1 })
            {
              localObject2 = localAddOp.apply2(localObject5, numbers.string$To$Number(strings.$make$string$(arrayOfObject)));
              localObject1 = localObject4;
              break;
            }
          }
          return localObject2;
        }
        catch (ClassCastException localClassCastException)
        {
          throw new WrongType(localClassCastException, "char-numeric?", 1, localObject3);
        }
      }
    }

    // ERROR //
    public Object lambda23pad$V(Object paramObject, Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: aload_2
      //   1: iconst_0
      //   2: invokestatic 204	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
      //   5: astore_3
      //   6: aload_1
      //   7: checkcast 206	java/lang/CharSequence
      //   10: astore 5
      //   12: aload 5
      //   14: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   17: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   20: astore 6
      //   22: aload_3
      //   23: astore 7
      //   25: getstatic 220	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   28: aload 6
      //   30: aload_0
      //   31: getfield 222	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
      //   34: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   37: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   40: if_acmpeq +9 -> 49
      //   43: aload_1
      //   44: aload_3
      //   45: invokestatic 226	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   48: areturn
      //   49: aload 7
      //   51: invokestatic 229	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   54: ifeq +165 -> 219
      //   57: aload_0
      //   58: getfield 231	gnu/kawa/slib/printf$frame10:left$Mnadjust	Ljava/lang/Object;
      //   61: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   64: if_acmpeq +63 -> 127
      //   67: iconst_2
      //   68: anewarray 101	java/lang/Object
      //   71: astore 18
      //   73: aload 18
      //   75: iconst_0
      //   76: aload_3
      //   77: aastore
      //   78: getstatic 234	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   81: aload_0
      //   82: getfield 222	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
      //   85: aload 6
      //   87: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   90: astore 19
      //   92: aload 19
      //   94: checkcast 236	java/lang/Number
      //   97: invokevirtual 240	java/lang/Number:intValue	()I
      //   100: istore 21
      //   102: aload 18
      //   104: iconst_1
      //   105: iload 21
      //   107: getstatic 243	gnu/kawa/slib/printf:Lit29	Lgnu/text/Char;
      //   110: invokestatic 247	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
      //   113: invokestatic 251	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   116: aastore
      //   117: aload_1
      //   118: aload 18
      //   120: invokestatic 257	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   123: invokestatic 226	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   126: areturn
      //   127: aload_0
      //   128: getfield 259	gnu/kawa/slib/printf$frame10:leading$Mn0s	Ljava/lang/Object;
      //   131: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   134: if_acmpeq +44 -> 178
      //   137: getstatic 234	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   140: aload_0
      //   141: getfield 222	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
      //   144: aload 6
      //   146: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   149: astore 15
      //   151: aload 15
      //   153: checkcast 236	java/lang/Number
      //   156: invokevirtual 240	java/lang/Number:intValue	()I
      //   159: istore 17
      //   161: aload_1
      //   162: iload 17
      //   164: getstatic 262	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
      //   167: invokestatic 247	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
      //   170: aload_3
      //   171: invokestatic 226	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   174: invokestatic 226	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   177: areturn
      //   178: getstatic 234	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   181: aload_0
      //   182: getfield 222	gnu/kawa/slib/printf$frame10:width	Ljava/lang/Object;
      //   185: aload 6
      //   187: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   190: astore 12
      //   192: aload 12
      //   194: checkcast 236	java/lang/Number
      //   197: invokevirtual 240	java/lang/Number:intValue	()I
      //   200: istore 14
      //   202: iload 14
      //   204: getstatic 243	gnu/kawa/slib/printf:Lit29	Lgnu/text/Char;
      //   207: invokestatic 247	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
      //   210: aload_1
      //   211: aload_3
      //   212: invokestatic 226	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   215: invokestatic 226	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   218: areturn
      //   219: getstatic 168	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   222: astore 8
      //   224: getstatic 143	kawa/lib/lists:car	Lgnu/expr/GenericProc;
      //   227: aload 7
      //   229: invokevirtual 147	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   232: astore 9
      //   234: aload 9
      //   236: checkcast 206	java/lang/CharSequence
      //   239: astore 11
      //   241: aload 8
      //   243: aload 6
      //   245: aload 11
      //   247: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   250: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   253: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   256: astore 6
      //   258: getstatic 150	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
      //   261: aload 7
      //   263: invokevirtual 147	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   266: astore 7
      //   268: goto -243 -> 25
      //   271: astore 4
      //   273: new 193	gnu/mapping/WrongType
      //   276: dup
      //   277: aload 4
      //   279: ldc_w 264
      //   282: iconst_1
      //   283: aload_1
      //   284: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   287: athrow
      //   288: astore 20
      //   290: new 193	gnu/mapping/WrongType
      //   293: dup
      //   294: aload 20
      //   296: ldc_w 266
      //   299: iconst_1
      //   300: aload 19
      //   302: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   305: athrow
      //   306: astore 16
      //   308: new 193	gnu/mapping/WrongType
      //   311: dup
      //   312: aload 16
      //   314: ldc_w 266
      //   317: iconst_1
      //   318: aload 15
      //   320: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   323: athrow
      //   324: astore 13
      //   326: new 193	gnu/mapping/WrongType
      //   329: dup
      //   330: aload 13
      //   332: ldc_w 266
      //   335: iconst_1
      //   336: aload 12
      //   338: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   341: athrow
      //   342: astore 10
      //   344: new 193	gnu/mapping/WrongType
      //   347: dup
      //   348: aload 10
      //   350: ldc_w 264
      //   353: iconst_1
      //   354: aload 9
      //   356: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   359: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   6	12	271	java/lang/ClassCastException
      //   92	102	288	java/lang/ClassCastException
      //   151	161	306	java/lang/ClassCastException
      //   192	202	324	java/lang/ClassCastException
      //   234	241	342	java/lang/ClassCastException
    }

    // ERROR //
    public Object lambda24integerConvert(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 270	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   4: astore 4
      //   6: aload 4
      //   8: invokestatic 276	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   11: astore 6
      //   13: aload 6
      //   15: invokestatic 280	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   18: ifne +765 -> 783
      //   21: aload_0
      //   22: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   25: putfield 259	gnu/kawa/slib/printf$frame10:leading$Mn0s	Ljava/lang/Object;
      //   28: aload_0
      //   29: getfield 270	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   32: astore 41
      //   34: aload 41
      //   36: checkcast 236	java/lang/Number
      //   39: astore 43
      //   41: aload 43
      //   43: invokestatic 284	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
      //   46: istore 44
      //   48: iload 44
      //   50: ifeq +199 -> 249
      //   53: getstatic 117	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   56: getstatic 154	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   59: aload_1
      //   60: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   63: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   66: if_acmpeq +7 -> 73
      //   69: ldc_w 286
      //   72: astore_1
      //   73: aload_1
      //   74: astore 7
      //   76: aload 7
      //   78: invokestatic 291	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
      //   81: ifeq +176 -> 257
      //   84: aload 7
      //   86: checkcast 293	gnu/mapping/Symbol
      //   89: astore 40
      //   91: aload 40
      //   93: invokestatic 297	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
      //   96: astore 12
      //   98: aload_3
      //   99: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   102: if_acmpeq +14 -> 116
      //   105: getstatic 301	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   108: aload_3
      //   109: aload 12
      //   111: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   114: astore 12
      //   116: ldc_w 286
      //   119: aload 12
      //   121: invokestatic 307	gnu/kawa/functions/IsEqual:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   124: ifeq +247 -> 371
      //   127: ldc_w 286
      //   130: astore 17
      //   132: iconst_2
      //   133: anewarray 101	java/lang/Object
      //   136: astore 18
      //   138: getstatic 310	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   141: astore 19
      //   143: aload 12
      //   145: checkcast 206	java/lang/CharSequence
      //   148: astore 21
      //   150: aload 19
      //   152: aload 21
      //   154: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   157: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   160: aload_0
      //   161: getfield 270	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   164: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   167: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   170: if_acmpeq +389 -> 559
      //   173: getstatic 234	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   176: astore 23
      //   178: aload_0
      //   179: getfield 270	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   182: astore 24
      //   184: aload 12
      //   186: checkcast 206	java/lang/CharSequence
      //   189: astore 26
      //   191: aload 23
      //   193: aload 24
      //   195: aload 26
      //   197: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   200: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   203: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   206: astore 27
      //   208: aload 27
      //   210: checkcast 236	java/lang/Number
      //   213: invokevirtual 240	java/lang/Number:intValue	()I
      //   216: istore 29
      //   218: iload 29
      //   220: getstatic 262	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
      //   223: invokestatic 247	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
      //   226: astore 22
      //   228: aload 18
      //   230: iconst_0
      //   231: aload 22
      //   233: aastore
      //   234: aload 18
      //   236: iconst_1
      //   237: aload 12
      //   239: aastore
      //   240: aload_0
      //   241: aload 17
      //   243: aload 18
      //   245: invokevirtual 105	gnu/kawa/slib/printf$frame10:lambda23pad$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   248: areturn
      //   249: iload 44
      //   251: ifeq -178 -> 73
      //   254: goto -185 -> 69
      //   257: aload 7
      //   259: invokestatic 313	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
      //   262: ifeq +31 -> 293
      //   265: aload 7
      //   267: checkcast 236	java/lang/Number
      //   270: astore 36
      //   272: aload_2
      //   273: checkcast 236	java/lang/Number
      //   276: invokevirtual 240	java/lang/Number:intValue	()I
      //   279: istore 38
      //   281: aload 36
      //   283: iload 38
      //   285: invokestatic 317	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
      //   288: astore 12
      //   290: goto -192 -> 98
      //   293: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   296: astore 9
      //   298: aload 7
      //   300: aload 9
      //   302: if_acmpeq +32 -> 334
      //   305: iconst_1
      //   306: istore 10
      //   308: iconst_1
      //   309: iload 10
      //   311: iconst_1
      //   312: iadd
      //   313: iand
      //   314: istore 11
      //   316: iload 11
      //   318: ifeq +22 -> 340
      //   321: iload 11
      //   323: ifeq +25 -> 348
      //   326: ldc_w 319
      //   329: astore 12
      //   331: goto -233 -> 98
      //   334: iconst_0
      //   335: istore 10
      //   337: goto -29 -> 308
      //   340: aload 7
      //   342: invokestatic 229	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   345: ifne -19 -> 326
      //   348: aload 7
      //   350: invokestatic 322	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
      //   353: ifeq +10 -> 363
      //   356: aload 7
      //   358: astore 12
      //   360: goto -262 -> 98
      //   363: ldc_w 324
      //   366: astore 12
      //   368: goto -270 -> 98
      //   371: getstatic 117	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   374: astore 13
      //   376: getstatic 327	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
      //   379: astore 14
      //   381: aload 12
      //   383: checkcast 206	java/lang/CharSequence
      //   386: astore 16
      //   388: aload 13
      //   390: aload 14
      //   392: aload 16
      //   394: iconst_0
      //   395: invokestatic 331	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   398: invokestatic 335	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   401: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   404: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   407: if_acmpeq +38 -> 445
      //   410: aload 12
      //   412: checkcast 206	java/lang/CharSequence
      //   415: astore 32
      //   417: aload 12
      //   419: checkcast 206	java/lang/CharSequence
      //   422: astore 34
      //   424: aload 32
      //   426: iconst_1
      //   427: aload 34
      //   429: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   432: invokestatic 339	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   435: astore 12
      //   437: ldc_w 341
      //   440: astore 17
      //   442: goto -310 -> 132
      //   445: aload_0
      //   446: getfield 343	gnu/kawa/slib/printf$frame10:signed	Ljava/lang/Object;
      //   449: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   452: if_acmpeq +11 -> 463
      //   455: ldc_w 345
      //   458: astore 17
      //   460: goto -328 -> 132
      //   463: aload_0
      //   464: getfield 347	gnu/kawa/slib/printf$frame10:blank	Ljava/lang/Object;
      //   467: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   470: if_acmpeq +11 -> 481
      //   473: ldc_w 349
      //   476: astore 17
      //   478: goto -346 -> 132
      //   481: aload_0
      //   482: getfield 351	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
      //   485: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   488: if_acmpeq +63 -> 551
      //   491: getstatic 117	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   494: aload_2
      //   495: getstatic 354	gnu/kawa/slib/printf:Lit48	Lgnu/math/IntNum;
      //   498: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   501: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   504: if_acmpeq +15 -> 519
      //   507: ldc_w 319
      //   510: astore 30
      //   512: aload 30
      //   514: astore 17
      //   516: goto -384 -> 132
      //   519: getstatic 117	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   522: aload_2
      //   523: getstatic 357	gnu/kawa/slib/printf:Lit50	Lgnu/math/IntNum;
      //   526: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   529: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   532: if_acmpeq +11 -> 543
      //   535: ldc_w 359
      //   538: astore 30
      //   540: goto -28 -> 512
      //   543: ldc_w 286
      //   546: astore 30
      //   548: goto -36 -> 512
      //   551: ldc_w 286
      //   554: astore 17
      //   556: goto -424 -> 132
      //   559: ldc_w 286
      //   562: astore 22
      //   564: goto -336 -> 228
      //   567: astore 5
      //   569: new 193	gnu/mapping/WrongType
      //   572: dup
      //   573: aload 5
      //   575: ldc_w 361
      //   578: iconst_1
      //   579: aload 4
      //   581: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   584: athrow
      //   585: astore 42
      //   587: new 193	gnu/mapping/WrongType
      //   590: dup
      //   591: aload 42
      //   593: ldc_w 363
      //   596: iconst_1
      //   597: aload 41
      //   599: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   602: athrow
      //   603: astore 39
      //   605: new 193	gnu/mapping/WrongType
      //   608: dup
      //   609: aload 39
      //   611: ldc_w 365
      //   614: iconst_1
      //   615: aload 7
      //   617: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   620: athrow
      //   621: astore 35
      //   623: new 193	gnu/mapping/WrongType
      //   626: dup
      //   627: aload 35
      //   629: ldc_w 367
      //   632: iconst_1
      //   633: aload 7
      //   635: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   638: athrow
      //   639: astore 37
      //   641: new 193	gnu/mapping/WrongType
      //   644: dup
      //   645: aload 37
      //   647: ldc_w 367
      //   650: iconst_2
      //   651: aload_2
      //   652: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   655: athrow
      //   656: astore 8
      //   658: new 193	gnu/mapping/WrongType
      //   661: dup
      //   662: aload 8
      //   664: ldc_w 369
      //   667: bipush 254
      //   669: aload 7
      //   671: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   674: athrow
      //   675: astore 15
      //   677: new 193	gnu/mapping/WrongType
      //   680: dup
      //   681: aload 15
      //   683: ldc_w 371
      //   686: iconst_1
      //   687: aload 12
      //   689: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   692: athrow
      //   693: astore 31
      //   695: new 193	gnu/mapping/WrongType
      //   698: dup
      //   699: aload 31
      //   701: ldc_w 372
      //   704: iconst_1
      //   705: aload 12
      //   707: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   710: athrow
      //   711: astore 33
      //   713: new 193	gnu/mapping/WrongType
      //   716: dup
      //   717: aload 33
      //   719: ldc_w 264
      //   722: iconst_1
      //   723: aload 12
      //   725: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   728: athrow
      //   729: astore 20
      //   731: new 193	gnu/mapping/WrongType
      //   734: dup
      //   735: aload 20
      //   737: ldc_w 264
      //   740: iconst_1
      //   741: aload 12
      //   743: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   746: athrow
      //   747: astore 25
      //   749: new 193	gnu/mapping/WrongType
      //   752: dup
      //   753: aload 25
      //   755: ldc_w 264
      //   758: iconst_1
      //   759: aload 12
      //   761: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   764: athrow
      //   765: astore 28
      //   767: new 193	gnu/mapping/WrongType
      //   770: dup
      //   771: aload 28
      //   773: ldc_w 266
      //   776: iconst_1
      //   777: aload 27
      //   779: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   782: athrow
      //   783: aload_1
      //   784: astore 7
      //   786: goto -710 -> 76
      //
      // Exception table:
      //   from	to	target	type
      //   6	13	567	java/lang/ClassCastException
      //   34	41	585	java/lang/ClassCastException
      //   84	91	603	java/lang/ClassCastException
      //   265	272	621	java/lang/ClassCastException
      //   272	281	639	java/lang/ClassCastException
      //   293	298	656	java/lang/ClassCastException
      //   381	388	675	java/lang/ClassCastException
      //   410	417	693	java/lang/ClassCastException
      //   417	424	711	java/lang/ClassCastException
      //   143	150	729	java/lang/ClassCastException
      //   184	191	747	java/lang/ClassCastException
      //   208	218	765	java/lang/ClassCastException
    }

    Object lambda25(Object paramObject)
    {
      AddOp localAddOp = AddOp.$Pl;
      Object localObject = this.pr;
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject;
        this.pr = localAddOp.apply2(localObject, Integer.valueOf(strings.stringLength(localCharSequence)));
        return Scheme.applyToArgs.apply2(this.staticLink.out, paramObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, paramObject);
      }
    }

    // ERROR //
    boolean lambda26(Object paramObject)
    {
      // Byte code:
      //   0: getstatic 383	gnu/expr/Special:undefined	Lgnu/expr/Special;
      //   3: pop
      //   4: getstatic 234	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   7: astore_3
      //   8: aload_0
      //   9: getfield 374	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
      //   12: astore 4
      //   14: aload_1
      //   15: checkcast 206	java/lang/CharSequence
      //   18: astore 6
      //   20: aload_3
      //   21: aload 4
      //   23: aload 6
      //   25: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   28: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   31: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   34: astore 7
      //   36: aload 7
      //   38: invokestatic 276	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   41: astore 9
      //   43: aload 9
      //   45: invokestatic 280	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   48: ifeq +79 -> 127
      //   51: getstatic 301	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   54: astore 14
      //   56: aload_0
      //   57: getfield 123	gnu/kawa/slib/printf$frame10:staticLink	Lgnu/kawa/slib/printf$frame9;
      //   60: getfield 377	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
      //   63: astore 15
      //   65: aload_1
      //   66: checkcast 206	java/lang/CharSequence
      //   69: astore 17
      //   71: aload_0
      //   72: getfield 374	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
      //   75: astore 18
      //   77: aload 18
      //   79: checkcast 236	java/lang/Number
      //   82: invokevirtual 240	java/lang/Number:intValue	()I
      //   85: istore 20
      //   87: aload 14
      //   89: aload 15
      //   91: aload 17
      //   93: iconst_0
      //   94: iload 20
      //   96: invokestatic 339	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   99: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   102: pop
      //   103: getstatic 154	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   106: astore 11
      //   108: aload_0
      //   109: aload 11
      //   111: putfield 374	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
      //   114: aload 7
      //   116: invokestatic 276	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   119: astore 13
      //   121: aload 13
      //   123: invokestatic 386	kawa/lib/numbers:isPositive	(Lgnu/math/RealNum;)Z
      //   126: ireturn
      //   127: getstatic 301	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   130: aload_0
      //   131: getfield 123	gnu/kawa/slib/printf$frame10:staticLink	Lgnu/kawa/slib/printf$frame9;
      //   134: getfield 377	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
      //   137: aload_1
      //   138: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   141: pop
      //   142: aload 7
      //   144: astore 11
      //   146: goto -38 -> 108
      //   149: astore 5
      //   151: new 193	gnu/mapping/WrongType
      //   154: dup
      //   155: aload 5
      //   157: ldc_w 264
      //   160: iconst_1
      //   161: aload_1
      //   162: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   165: athrow
      //   166: astore 8
      //   168: new 193	gnu/mapping/WrongType
      //   171: dup
      //   172: aload 8
      //   174: ldc_w 361
      //   177: iconst_1
      //   178: aload 7
      //   180: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   183: athrow
      //   184: astore 16
      //   186: new 193	gnu/mapping/WrongType
      //   189: dup
      //   190: aload 16
      //   192: ldc_w 372
      //   195: iconst_1
      //   196: aload_1
      //   197: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   200: athrow
      //   201: astore 19
      //   203: new 193	gnu/mapping/WrongType
      //   206: dup
      //   207: aload 19
      //   209: ldc_w 372
      //   212: iconst_3
      //   213: aload 18
      //   215: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   218: athrow
      //   219: astore 12
      //   221: new 193	gnu/mapping/WrongType
      //   224: dup
      //   225: aload 12
      //   227: ldc_w 388
      //   230: iconst_1
      //   231: aload 7
      //   233: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   236: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   14	20	149	java/lang/ClassCastException
      //   36	43	166	java/lang/ClassCastException
      //   65	71	184	java/lang/ClassCastException
      //   77	87	201	java/lang/ClassCastException
      //   114	121	219	java/lang/ClassCastException
    }

    // ERROR //
    Boolean lambda27(Object paramObject)
    {
      // Byte code:
      //   0: getstatic 234	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   3: astore_2
      //   4: aload_0
      //   5: getfield 374	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
      //   8: astore_3
      //   9: aload_1
      //   10: checkcast 206	java/lang/CharSequence
      //   13: astore 5
      //   15: aload_0
      //   16: aload_2
      //   17: aload_3
      //   18: aload 5
      //   20: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   23: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   26: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   29: putfield 374	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
      //   32: aload_0
      //   33: getfield 390	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
      //   36: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   39: if_acmpne +22 -> 61
      //   42: getstatic 301	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   45: aload_0
      //   46: getfield 123	gnu/kawa/slib/printf$frame10:staticLink	Lgnu/kawa/slib/printf$frame9;
      //   49: getfield 377	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
      //   52: aload_1
      //   53: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   56: pop
      //   57: getstatic 87	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   60: areturn
      //   61: aload_0
      //   62: getfield 374	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
      //   65: astore 6
      //   67: aload 6
      //   69: invokestatic 276	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   72: astore 8
      //   74: aload 8
      //   76: invokestatic 280	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   79: ifeq +46 -> 125
      //   82: getstatic 301	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   85: aload_0
      //   86: getfield 123	gnu/kawa/slib/printf$frame10:staticLink	Lgnu/kawa/slib/printf$frame9;
      //   89: getfield 377	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
      //   92: aload_0
      //   93: getfield 390	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
      //   96: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   99: pop
      //   100: aload_0
      //   101: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   104: putfield 390	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
      //   107: getstatic 301	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   110: aload_0
      //   111: getfield 123	gnu/kawa/slib/printf$frame10:staticLink	Lgnu/kawa/slib/printf$frame9;
      //   114: getfield 377	gnu/kawa/slib/printf$frame9:out	Ljava/lang/Object;
      //   117: aload_1
      //   118: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   121: pop
      //   122: goto -65 -> 57
      //   125: iconst_2
      //   126: anewarray 101	java/lang/Object
      //   129: astore 9
      //   131: aload 9
      //   133: iconst_0
      //   134: aload_0
      //   135: getfield 390	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
      //   138: aastore
      //   139: aload 9
      //   141: iconst_1
      //   142: aload_1
      //   143: aastore
      //   144: aload_0
      //   145: aload 9
      //   147: invokestatic 394	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   150: putfield 390	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
      //   153: goto -96 -> 57
      //   156: astore 4
      //   158: new 193	gnu/mapping/WrongType
      //   161: dup
      //   162: aload 4
      //   164: ldc_w 264
      //   167: iconst_1
      //   168: aload_1
      //   169: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   172: athrow
      //   173: astore 7
      //   175: new 193	gnu/mapping/WrongType
      //   178: dup
      //   179: aload 7
      //   181: ldc_w 361
      //   184: iconst_1
      //   185: aload 6
      //   187: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   190: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   9	15	156	java/lang/ClassCastException
      //   67	74	173	java/lang/ClassCastException
    }

    // ERROR //
    boolean lambda28(Object paramObject)
    {
      // Byte code:
      //   0: getstatic 383	gnu/expr/Special:undefined	Lgnu/expr/Special;
      //   3: pop
      //   4: getstatic 234	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   7: astore_3
      //   8: aload_0
      //   9: getfield 374	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
      //   12: astore 4
      //   14: aload_1
      //   15: checkcast 206	java/lang/CharSequence
      //   18: astore 6
      //   20: aload_3
      //   21: aload 4
      //   23: aload 6
      //   25: invokestatic 210	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   28: invokestatic 216	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   31: invokevirtual 134	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   34: astore 7
      //   36: aload 7
      //   38: invokestatic 276	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   41: astore 9
      //   43: aload 9
      //   45: invokestatic 280	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   48: ifeq +79 -> 127
      //   51: iconst_2
      //   52: anewarray 101	java/lang/Object
      //   55: astore 13
      //   57: aload 13
      //   59: iconst_0
      //   60: aload_0
      //   61: getfield 390	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
      //   64: aastore
      //   65: aload_1
      //   66: checkcast 206	java/lang/CharSequence
      //   69: astore 15
      //   71: aload_0
      //   72: getfield 374	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
      //   75: astore 16
      //   77: aload 16
      //   79: checkcast 236	java/lang/Number
      //   82: invokevirtual 240	java/lang/Number:intValue	()I
      //   85: istore 18
      //   87: aload 13
      //   89: iconst_1
      //   90: aload 15
      //   92: iconst_0
      //   93: iload 18
      //   95: invokestatic 339	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   98: aastore
      //   99: aload_0
      //   100: aload 13
      //   102: invokestatic 394	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   105: putfield 390	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
      //   108: aload_0
      //   109: aload 7
      //   111: putfield 374	gnu/kawa/slib/printf$frame10:pr	Ljava/lang/Object;
      //   114: aload 7
      //   116: invokestatic 276	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   119: astore 12
      //   121: aload 12
      //   123: invokestatic 386	kawa/lib/numbers:isPositive	(Lgnu/math/RealNum;)Z
      //   126: ireturn
      //   127: iconst_2
      //   128: anewarray 101	java/lang/Object
      //   131: astore 10
      //   133: aload 10
      //   135: iconst_0
      //   136: aload_0
      //   137: getfield 390	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
      //   140: aastore
      //   141: aload 10
      //   143: iconst_1
      //   144: aload_1
      //   145: aastore
      //   146: aload_0
      //   147: aload 10
      //   149: invokestatic 394	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   152: putfield 390	gnu/kawa/slib/printf$frame10:os	Ljava/lang/Object;
      //   155: goto -47 -> 108
      //   158: astore 5
      //   160: new 193	gnu/mapping/WrongType
      //   163: dup
      //   164: aload 5
      //   166: ldc_w 264
      //   169: iconst_1
      //   170: aload_1
      //   171: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   174: athrow
      //   175: astore 8
      //   177: new 193	gnu/mapping/WrongType
      //   180: dup
      //   181: aload 8
      //   183: ldc_w 361
      //   186: iconst_1
      //   187: aload 7
      //   189: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   192: athrow
      //   193: astore 14
      //   195: new 193	gnu/mapping/WrongType
      //   198: dup
      //   199: aload 14
      //   201: ldc_w 372
      //   204: iconst_1
      //   205: aload_1
      //   206: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   209: athrow
      //   210: astore 17
      //   212: new 193	gnu/mapping/WrongType
      //   215: dup
      //   216: aload 17
      //   218: ldc_w 372
      //   221: iconst_3
      //   222: aload 16
      //   224: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   227: athrow
      //   228: astore 11
      //   230: new 193	gnu/mapping/WrongType
      //   233: dup
      //   234: aload 11
      //   236: ldc_w 388
      //   239: iconst_1
      //   240: aload 7
      //   242: invokespecial 198	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   245: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   14	20	158	java/lang/ClassCastException
      //   36	43	175	java/lang/ClassCastException
      //   65	71	193	java/lang/ClassCastException
      //   77	87	210	java/lang/ClassCastException
      //   114	121	228	java/lang/ClassCastException
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.match1(paramModuleMethod, paramObject, paramCallContext);
      case 19:
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 18:
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      case 17:
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

    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
      {
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      }
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
  }

  public class frame11 extends ModuleBody
  {
    Object fc;
    Procedure format$Mnreal = new ModuleMethod(this, 13, printf.Lit64, -4092);
    final ModuleMethod lambda$Fn17;
    printf.frame10 staticLink;

    public frame11()
    {
      this$1 = new ModuleMethod(this, 14, null, -4093);
      this$1.setProperty("source-location", "printf.scm:401");
      this.lambda$Fn17 = this$1;
    }

    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.applyN(paramModuleMethod, paramArrayOfObject);
      case 13:
        Object localObject4 = paramArrayOfObject[0];
        Object localObject5 = paramArrayOfObject[1];
        Object localObject6 = paramArrayOfObject[2];
        Object localObject7 = paramArrayOfObject[3];
        int k = paramArrayOfObject.length - 4;
        Object[] arrayOfObject2 = new Object[k];
        while (true)
        {
          k--;
          if (k < 0)
            return lambda30formatReal$V(localObject4, localObject5, localObject6, localObject7, arrayOfObject2);
          arrayOfObject2[k] = paramArrayOfObject[(k + 4)];
        }
      case 14:
      }
      Object localObject1 = paramArrayOfObject[0];
      Object localObject2 = paramArrayOfObject[1];
      Object localObject3 = paramArrayOfObject[2];
      int i = paramArrayOfObject.length - 3;
      Object[] arrayOfObject1 = new Object[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          return lambda31$V(localObject1, localObject2, localObject3, arrayOfObject1);
        arrayOfObject1[j] = paramArrayOfObject[(j + 3)];
      }
    }

    // ERROR //
    public Object lambda29f(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      // Byte code:
      //   0: aload_1
      //   1: checkcast 65	java/lang/CharSequence
      //   4: astore 5
      //   6: getstatic 71	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   9: aload_2
      //   10: aload_0
      //   11: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   14: getfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   17: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   20: astore 6
      //   22: aload_3
      //   23: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   26: if_acmpeq +199 -> 225
      //   29: aload_2
      //   30: astore 7
      //   32: aload 5
      //   34: aload 6
      //   36: aload 7
      //   38: invokestatic 94	gnu/kawa/slib/printf:stdio$ClRoundString	(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   41: astore 8
      //   43: getstatic 100	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   46: aload_2
      //   47: getstatic 104	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   50: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   53: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   56: if_acmpeq +237 -> 293
      //   59: aload_2
      //   60: checkcast 106	java/lang/Number
      //   63: astore 21
      //   65: aload 21
      //   67: invokestatic 112	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
      //   70: ifeq +161 -> 231
      //   73: getstatic 104	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   76: astore 25
      //   78: iconst_2
      //   79: anewarray 51	java/lang/Object
      //   82: astore 26
      //   84: aload 26
      //   86: iconst_0
      //   87: getstatic 115	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   90: aastore
      //   91: aload 26
      //   93: iconst_1
      //   94: getstatic 71	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   97: getstatic 115	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   100: aload_2
      //   101: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   104: aastore
      //   105: aload 26
      //   107: invokestatic 119	kawa/lib/numbers:max	([Ljava/lang/Object;)Ljava/lang/Object;
      //   110: astore 27
      //   112: aload 8
      //   114: checkcast 65	java/lang/CharSequence
      //   117: astore 29
      //   119: aload 25
      //   121: invokevirtual 123	java/lang/Number:intValue	()I
      //   124: istore 31
      //   126: aload 27
      //   128: checkcast 106	java/lang/Number
      //   131: invokevirtual 123	java/lang/Number:intValue	()I
      //   134: istore 33
      //   136: aload 29
      //   138: iload 31
      //   140: iload 33
      //   142: invokestatic 129	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   145: astore 34
      //   147: aload 8
      //   149: checkcast 65	java/lang/CharSequence
      //   152: astore 36
      //   154: aload 27
      //   156: checkcast 106	java/lang/Number
      //   159: invokevirtual 123	java/lang/Number:intValue	()I
      //   162: istore 38
      //   164: aload 8
      //   166: checkcast 65	java/lang/CharSequence
      //   169: astore 40
      //   171: aload 36
      //   173: iload 38
      //   175: aload 40
      //   177: invokestatic 133	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   180: invokestatic 129	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   183: astore 41
      //   185: aload 41
      //   187: ldc 135
      //   189: invokestatic 139	kawa/lib/strings:isString$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   192: istore 42
      //   194: iload 42
      //   196: ifeq +80 -> 276
      //   199: aload_0
      //   200: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   203: getfield 142	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
      //   206: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   209: if_acmpne +72 -> 281
      //   212: getstatic 148	gnu/lists/LList:Empty	Lgnu/lists/LList;
      //   215: astore 43
      //   217: aload 34
      //   219: aload 43
      //   221: invokestatic 154	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   224: areturn
      //   225: aload_3
      //   226: astore 7
      //   228: goto -196 -> 32
      //   231: getstatic 158	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
      //   234: astore 22
      //   236: aload 8
      //   238: checkcast 65	java/lang/CharSequence
      //   241: astore 24
      //   243: aload 22
      //   245: aload 24
      //   247: iconst_0
      //   248: invokestatic 162	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   251: invokestatic 168	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   254: invokestatic 174	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   257: ifeq +11 -> 268
      //   260: getstatic 115	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   263: astore 25
      //   265: goto -187 -> 78
      //   268: getstatic 104	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   271: astore 25
      //   273: goto -195 -> 78
      //   276: iload 42
      //   278: ifne -66 -> 212
      //   281: ldc 176
      //   283: aload 41
      //   285: invokestatic 179	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   288: astore 43
      //   290: goto -73 -> 217
      //   293: aload_0
      //   294: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   297: getfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   300: astore 9
      //   302: aload 9
      //   304: checkcast 106	java/lang/Number
      //   307: astore 11
      //   309: aload 11
      //   311: invokestatic 112	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
      //   314: ifeq +33 -> 347
      //   317: aload_0
      //   318: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   321: getfield 142	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
      //   324: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   327: if_acmpeq +13 -> 340
      //   330: ldc 181
      //   332: astore 19
      //   334: aload 19
      //   336: invokestatic 185	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   339: areturn
      //   340: ldc 187
      //   342: astore 19
      //   344: goto -10 -> 334
      //   347: aload_3
      //   348: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   351: if_acmpeq +60 -> 411
      //   354: aload 8
      //   356: ldc 135
      //   358: invokestatic 139	kawa/lib/strings:isString$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   361: istore 17
      //   363: iload 17
      //   365: ifeq +25 -> 390
      //   368: ldc 187
      //   370: invokestatic 185	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   373: astore 18
      //   375: aload 18
      //   377: astore 12
      //   379: aload 12
      //   381: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   384: if_acmpeq +33 -> 417
      //   387: aload 12
      //   389: areturn
      //   390: iload 17
      //   392: ifeq +11 -> 403
      //   395: getstatic 190	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   398: astore 18
      //   400: goto -25 -> 375
      //   403: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   406: astore 18
      //   408: goto -33 -> 375
      //   411: aload_3
      //   412: astore 12
      //   414: goto -35 -> 379
      //   417: iconst_2
      //   418: anewarray 51	java/lang/Object
      //   421: astore 13
      //   423: aload 13
      //   425: iconst_0
      //   426: aload_0
      //   427: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   430: getfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   433: aastore
      //   434: aload 13
      //   436: iconst_1
      //   437: getstatic 193	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   440: getstatic 196	gnu/kawa/slib/printf:Lit17	Lgnu/math/IntNum;
      //   443: aload_2
      //   444: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   447: aastore
      //   448: aload 13
      //   450: invokestatic 199	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
      //   453: astore 14
      //   455: aload 14
      //   457: checkcast 106	java/lang/Number
      //   460: invokevirtual 123	java/lang/Number:intValue	()I
      //   463: istore 16
      //   465: ldc 181
      //   467: iload 16
      //   469: getstatic 158	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
      //   472: invokestatic 203	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
      //   475: aload 8
      //   477: invokestatic 207	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   480: areturn
      //   481: astore 4
      //   483: new 209	gnu/mapping/WrongType
      //   486: dup
      //   487: aload 4
      //   489: ldc 211
      //   491: iconst_0
      //   492: aload_1
      //   493: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   496: athrow
      //   497: astore 20
      //   499: new 209	gnu/mapping/WrongType
      //   502: dup
      //   503: aload 20
      //   505: ldc 216
      //   507: iconst_1
      //   508: aload_2
      //   509: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   512: athrow
      //   513: astore 23
      //   515: new 209	gnu/mapping/WrongType
      //   518: dup
      //   519: aload 23
      //   521: ldc 218
      //   523: iconst_1
      //   524: aload 8
      //   526: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   529: athrow
      //   530: astore 28
      //   532: new 209	gnu/mapping/WrongType
      //   535: dup
      //   536: aload 28
      //   538: ldc 219
      //   540: iconst_1
      //   541: aload 8
      //   543: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   546: athrow
      //   547: astore 30
      //   549: new 209	gnu/mapping/WrongType
      //   552: dup
      //   553: aload 30
      //   555: ldc 219
      //   557: iconst_2
      //   558: aload 25
      //   560: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   563: athrow
      //   564: astore 32
      //   566: new 209	gnu/mapping/WrongType
      //   569: dup
      //   570: aload 32
      //   572: ldc 219
      //   574: iconst_3
      //   575: aload 27
      //   577: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   580: athrow
      //   581: astore 35
      //   583: new 209	gnu/mapping/WrongType
      //   586: dup
      //   587: aload 35
      //   589: ldc 219
      //   591: iconst_1
      //   592: aload 8
      //   594: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   597: athrow
      //   598: astore 37
      //   600: new 209	gnu/mapping/WrongType
      //   603: dup
      //   604: aload 37
      //   606: ldc 219
      //   608: iconst_2
      //   609: aload 27
      //   611: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   614: athrow
      //   615: astore 39
      //   617: new 209	gnu/mapping/WrongType
      //   620: dup
      //   621: aload 39
      //   623: ldc 221
      //   625: iconst_1
      //   626: aload 8
      //   628: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   631: athrow
      //   632: astore 10
      //   634: new 209	gnu/mapping/WrongType
      //   637: dup
      //   638: aload 10
      //   640: ldc 216
      //   642: iconst_1
      //   643: aload 9
      //   645: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   648: athrow
      //   649: astore 15
      //   651: new 209	gnu/mapping/WrongType
      //   654: dup
      //   655: aload 15
      //   657: ldc 223
      //   659: iconst_1
      //   660: aload 14
      //   662: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   665: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   0	6	481	java/lang/ClassCastException
      //   59	65	497	java/lang/ClassCastException
      //   236	243	513	java/lang/ClassCastException
      //   112	119	530	java/lang/ClassCastException
      //   119	126	547	java/lang/ClassCastException
      //   126	136	564	java/lang/ClassCastException
      //   147	154	581	java/lang/ClassCastException
      //   154	164	598	java/lang/ClassCastException
      //   164	171	615	java/lang/ClassCastException
      //   302	309	632	java/lang/ClassCastException
      //   455	465	649	java/lang/ClassCastException
    }

    // ERROR //
    public Object lambda30formatReal$V(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: aload 5
      //   2: iconst_0
      //   3: invokestatic 227	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
      //   6: astore 6
      //   8: aload 6
      //   10: invokestatic 231	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   13: ifeq +1224 -> 1237
      //   16: getstatic 234	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
      //   19: astore 9
      //   21: aload_2
      //   22: checkcast 164	gnu/text/Char
      //   25: astore 12
      //   27: aload 9
      //   29: aload 12
      //   31: invokestatic 174	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   34: ifeq +367 -> 401
      //   37: ldc 236
      //   39: astore 13
      //   41: getstatic 240	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   44: aload_0
      //   45: getfield 242	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
      //   48: getstatic 245	gnu/kawa/slib/printf:Lit13	Lgnu/text/Char;
      //   51: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   54: astore 14
      //   56: aload 14
      //   58: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   61: if_acmpeq +383 -> 444
      //   64: aload 14
      //   66: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   69: if_acmpeq +394 -> 463
      //   72: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   75: astore 41
      //   77: aload_3
      //   78: checkcast 65	java/lang/CharSequence
      //   81: astore 44
      //   83: getstatic 71	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   86: getstatic 115	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   89: aload_0
      //   90: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   93: getfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   96: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   99: astore 45
      //   101: aload 41
      //   103: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   106: if_acmpeq +8 -> 114
      //   109: getstatic 104	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   112: astore 41
      //   114: aload 44
      //   116: aload 45
      //   118: aload 41
      //   120: invokestatic 94	gnu/kawa/slib/printf:stdio$ClRoundString	(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   123: astore 46
      //   125: getstatic 158	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
      //   128: astore 47
      //   130: aload 46
      //   132: checkcast 65	java/lang/CharSequence
      //   135: astore 50
      //   137: aload 47
      //   139: aload 50
      //   141: iconst_0
      //   142: invokestatic 162	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   145: invokestatic 168	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   148: invokestatic 174	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   151: ifeq +362 -> 513
      //   154: getstatic 115	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   157: astore 51
      //   159: aload 46
      //   161: checkcast 65	java/lang/CharSequence
      //   164: astore 54
      //   166: iconst_1
      //   167: aload 51
      //   169: invokevirtual 123	java/lang/Number:intValue	()I
      //   172: iadd
      //   173: istore 55
      //   175: aload 46
      //   177: checkcast 65	java/lang/CharSequence
      //   180: astore 58
      //   182: aload 54
      //   184: iload 55
      //   186: aload 58
      //   188: invokestatic 133	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   191: invokestatic 129	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   194: astore 59
      //   196: aload 51
      //   198: invokestatic 112	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
      //   201: ifeq +320 -> 521
      //   204: aload 46
      //   206: checkcast 65	java/lang/CharSequence
      //   209: astore 64
      //   211: aload 51
      //   213: invokevirtual 123	java/lang/Number:intValue	()I
      //   216: istore 66
      //   218: aload 64
      //   220: iload 66
      //   222: iconst_1
      //   223: aload 51
      //   225: invokevirtual 123	java/lang/Number:intValue	()I
      //   228: iadd
      //   229: invokestatic 129	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   232: invokestatic 185	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   235: astore 17
      //   237: aload 59
      //   239: ldc 135
      //   241: invokestatic 139	kawa/lib/strings:isString$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   244: istore 67
      //   246: iload 67
      //   248: ifeq +297 -> 545
      //   251: aload_0
      //   252: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   255: getfield 142	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
      //   258: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   261: if_acmpne +289 -> 550
      //   264: ldc 135
      //   266: astore 68
      //   268: aload_0
      //   269: getfield 242	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
      //   272: astore 69
      //   274: aload 69
      //   276: checkcast 164	gnu/text/Char
      //   279: astore 72
      //   281: aload 72
      //   283: invokestatic 251	kawa/lib/rnrs/unicode:isCharUpperCase	(Lgnu/text/Char;)Z
      //   286: ifeq +271 -> 557
      //   289: ldc 253
      //   291: astore 73
      //   293: aload 4
      //   295: invokestatic 259	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   298: astore 76
      //   300: aload 76
      //   302: invokestatic 263	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   305: ifeq +260 -> 565
      //   308: ldc 236
      //   310: astore 77
      //   312: aload 17
      //   314: aload 68
      //   316: aload 59
      //   318: aload 73
      //   320: aload 77
      //   322: invokestatic 267	gnu/lists/LList:chain4	(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   325: astore 78
      //   327: getstatic 270	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   330: astore 79
      //   332: getstatic 273	gnu/kawa/slib/printf:Lit60	Lgnu/math/IntNum;
      //   335: astore 80
      //   337: getstatic 276	gnu/kawa/slib/printf:Lit45	Lgnu/math/IntNum;
      //   340: astore 81
      //   342: aload 79
      //   344: aload 80
      //   346: aload 4
      //   348: aload 81
      //   350: invokevirtual 279	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   353: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   356: if_acmpeq +217 -> 573
      //   359: ldc 187
      //   361: astore 82
      //   363: aload 78
      //   365: aload 82
      //   367: invokestatic 283	gnu/lists/LList:chain1	(Lgnu/lists/Pair;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   370: astore 83
      //   372: aload 4
      //   374: checkcast 106	java/lang/Number
      //   377: astore 86
      //   379: aload 83
      //   381: aload 86
      //   383: invokestatic 287	kawa/lib/numbers:abs	(Ljava/lang/Number;)Ljava/lang/Number;
      //   386: invokestatic 291	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
      //   389: invokestatic 283	gnu/lists/LList:chain1	(Lgnu/lists/Pair;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   392: pop
      //   393: aload 13
      //   395: aload 17
      //   397: invokestatic 154	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   400: areturn
      //   401: aload_1
      //   402: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   405: if_acmpeq +11 -> 416
      //   408: ldc_w 293
      //   411: astore 13
      //   413: goto -372 -> 41
      //   416: aload_0
      //   417: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   420: getfield 296	gnu/kawa/slib/printf$frame10:blank	Ljava/lang/Object;
      //   423: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   426: if_acmpeq +11 -> 437
      //   429: ldc_w 298
      //   432: astore 13
      //   434: goto -393 -> 41
      //   437: ldc 135
      //   439: astore 13
      //   441: goto -400 -> 41
      //   444: getstatic 240	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   447: aload_0
      //   448: getfield 242	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
      //   451: getstatic 301	gnu/kawa/slib/printf:Lit54	Lgnu/text/Char;
      //   454: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   457: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   460: if_acmpne -388 -> 72
      //   463: getstatic 240	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   466: aload_0
      //   467: getfield 242	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
      //   470: getstatic 304	gnu/kawa/slib/printf:Lit25	Lgnu/text/Char;
      //   473: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   476: astore 15
      //   478: aload 15
      //   480: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   483: if_acmpeq +97 -> 580
      //   486: aload 15
      //   488: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   491: if_acmpeq +108 -> 599
      //   494: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   497: astore 105
      //   499: aload_0
      //   500: aload_3
      //   501: aload 4
      //   503: aload 105
      //   505: invokevirtual 306	gnu/kawa/slib/printf$frame11:lambda29f	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   508: astore 17
      //   510: goto -117 -> 393
      //   513: getstatic 104	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   516: astore 51
      //   518: goto -359 -> 159
      //   521: getstatic 193	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   524: astore 60
      //   526: getstatic 115	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   529: astore 61
      //   531: aload 60
      //   533: aload 4
      //   535: aload 61
      //   537: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   540: astore 4
      //   542: goto -338 -> 204
      //   545: iload 67
      //   547: ifne -283 -> 264
      //   550: ldc 176
      //   552: astore 68
      //   554: goto -286 -> 268
      //   557: ldc_w 308
      //   560: astore 73
      //   562: goto -269 -> 293
      //   565: ldc_w 293
      //   568: astore 77
      //   570: goto -258 -> 312
      //   573: ldc 135
      //   575: astore 82
      //   577: goto -214 -> 363
      //   580: getstatic 240	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   583: aload_0
      //   584: getfield 242	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
      //   587: getstatic 311	gnu/kawa/slib/printf:Lit26	Lgnu/text/Char;
      //   590: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   593: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   596: if_acmpne -102 -> 494
      //   599: getstatic 240	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   602: aload_0
      //   603: getfield 242	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
      //   606: getstatic 314	gnu/kawa/slib/printf:Lit55	Lgnu/text/Char;
      //   609: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   612: astore 16
      //   614: aload 16
      //   616: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   619: if_acmpeq +148 -> 767
      //   622: aload 16
      //   624: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   627: if_acmpeq +159 -> 786
      //   630: aload_0
      //   631: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   634: getfield 142	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
      //   637: astore 32
      //   639: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   642: astore 34
      //   644: aload 32
      //   646: aload 34
      //   648: if_acmpeq +431 -> 1079
      //   651: iconst_1
      //   652: istore 35
      //   654: iconst_1
      //   655: iload 35
      //   657: iconst_1
      //   658: iadd
      //   659: iand
      //   660: istore 36
      //   662: aload_0
      //   663: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   666: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   669: putfield 142	gnu/kawa/slib/printf$frame10:alternate$Mnform	Ljava/lang/Object;
      //   672: getstatic 317	kawa/standard/Scheme:numLEq	Lgnu/kawa/functions/NumberCompare;
      //   675: astore 37
      //   677: getstatic 193	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   680: getstatic 115	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   683: aload_0
      //   684: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   687: getfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   690: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   693: astore 38
      //   695: aload_0
      //   696: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   699: getfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   702: astore 39
      //   704: aload 37
      //   706: aload 38
      //   708: aload 4
      //   710: aload 39
      //   712: invokevirtual 279	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   715: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   718: if_acmpeq +375 -> 1093
      //   721: aload_0
      //   722: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   725: getstatic 193	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   728: aload_0
      //   729: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   732: getfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   735: aload 4
      //   737: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   740: putfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   743: iload 36
      //   745: ifeq +340 -> 1085
      //   748: getstatic 190	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   751: astore 88
      //   753: aload_0
      //   754: aload_3
      //   755: aload 4
      //   757: aload 88
      //   759: invokevirtual 306	gnu/kawa/slib/printf$frame11:lambda29f	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   762: astore 17
      //   764: goto -371 -> 393
      //   767: getstatic 240	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   770: aload_0
      //   771: getfield 242	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
      //   774: getstatic 320	gnu/kawa/slib/printf:Lit56	Lgnu/text/Char;
      //   777: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   780: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   783: if_acmpne -153 -> 630
      //   786: getstatic 240	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   789: aload_0
      //   790: getfield 242	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
      //   793: getstatic 323	gnu/kawa/slib/printf:Lit57	Lgnu/text/Char;
      //   796: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   799: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   802: if_acmpeq +400 -> 1202
      //   805: ldc 135
      //   807: astore 18
      //   809: aload 4
      //   811: invokestatic 259	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   814: astore 21
      //   816: aload 21
      //   818: invokestatic 263	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   821: ifeq +320 -> 1141
      //   824: getstatic 329	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
      //   827: astore 102
      //   829: getstatic 193	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   832: astore 103
      //   834: getstatic 332	gnu/kawa/slib/printf:Lit61	Lgnu/math/IntNum;
      //   837: astore 104
      //   839: aload 102
      //   841: aload 103
      //   843: aload 4
      //   845: aload 104
      //   847: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   850: getstatic 332	gnu/kawa/slib/printf:Lit61	Lgnu/math/IntNum;
      //   853: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   856: astore 25
      //   858: getstatic 270	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   861: getstatic 196	gnu/kawa/slib/printf:Lit17	Lgnu/math/IntNum;
      //   864: getstatic 71	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   867: aload 25
      //   869: getstatic 335	gnu/kawa/slib/printf:Lit48	Lgnu/math/IntNum;
      //   872: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   875: getstatic 339	gnu/kawa/slib/printf:Lit62	Lgnu/lists/FVector;
      //   878: invokestatic 345	kawa/lib/vectors:vectorLength	(Lgnu/lists/FVector;)I
      //   881: invokestatic 351	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   884: invokevirtual 279	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   887: astore 26
      //   889: aload 26
      //   891: checkcast 86	java/lang/Boolean
      //   894: invokevirtual 355	java/lang/Boolean:booleanValue	()Z
      //   897: istore 29
      //   899: iload 29
      //   901: ifeq +277 -> 1178
      //   904: aload 25
      //   906: astore 30
      //   908: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   911: astore 31
      //   913: aload 30
      //   915: aload 31
      //   917: if_acmpeq +282 -> 1199
      //   920: getstatic 193	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   923: astore 89
      //   925: getstatic 361	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
      //   928: getstatic 332	gnu/kawa/slib/printf:Lit61	Lgnu/math/IntNum;
      //   931: aload 30
      //   933: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   936: astore 90
      //   938: aload 89
      //   940: aload 4
      //   942: aload 90
      //   944: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   947: astore 91
      //   949: aload_0
      //   950: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   953: astore 92
      //   955: iconst_2
      //   956: anewarray 51	java/lang/Object
      //   959: astore 93
      //   961: aload 93
      //   963: iconst_0
      //   964: getstatic 104	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   967: aastore
      //   968: aload 93
      //   970: iconst_1
      //   971: getstatic 193	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   974: aload_0
      //   975: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   978: getfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   981: aload 91
      //   983: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   986: aastore
      //   987: aload 92
      //   989: aload 93
      //   991: invokestatic 119	kawa/lib/numbers:max	([Ljava/lang/Object;)Ljava/lang/Object;
      //   994: putfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   997: iconst_2
      //   998: anewarray 51	java/lang/Object
      //   1001: astore 94
      //   1003: aload 94
      //   1005: iconst_0
      //   1006: aload_0
      //   1007: aload_3
      //   1008: aload 91
      //   1010: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1013: invokevirtual 306	gnu/kawa/slib/printf$frame11:lambda29f	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1016: aastore
      //   1017: getstatic 339	gnu/kawa/slib/printf:Lit62	Lgnu/lists/FVector;
      //   1020: astore 95
      //   1022: getstatic 71	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   1025: astore 96
      //   1027: getstatic 335	gnu/kawa/slib/printf:Lit48	Lgnu/math/IntNum;
      //   1030: astore 97
      //   1032: aload 96
      //   1034: aload 30
      //   1036: aload 97
      //   1038: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1041: astore 98
      //   1043: aload 98
      //   1045: checkcast 106	java/lang/Number
      //   1048: invokevirtual 123	java/lang/Number:intValue	()I
      //   1051: istore 101
      //   1053: aload 94
      //   1055: iconst_1
      //   1056: aload 18
      //   1058: aload 95
      //   1060: iload 101
      //   1062: invokestatic 365	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
      //   1065: invokestatic 179	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   1068: aastore
      //   1069: aload 94
      //   1071: invokestatic 370	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   1074: astore 17
      //   1076: goto -683 -> 393
      //   1079: iconst_0
      //   1080: istore 35
      //   1082: goto -428 -> 654
      //   1085: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1088: astore 88
      //   1090: goto -337 -> 753
      //   1093: aload_0
      //   1094: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   1097: getstatic 193	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   1100: aload_0
      //   1101: getfield 73	gnu/kawa/slib/printf$frame11:staticLink	Lgnu/kawa/slib/printf$frame10;
      //   1104: getfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   1107: getstatic 115	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   1110: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1113: putfield 78	gnu/kawa/slib/printf$frame10:precision	Ljava/lang/Object;
      //   1116: iload 36
      //   1118: ifeq +15 -> 1133
      //   1121: getstatic 190	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   1124: astore 40
      //   1126: aload 40
      //   1128: astore 41
      //   1130: goto -1053 -> 77
      //   1133: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1136: astore 40
      //   1138: goto -12 -> 1126
      //   1141: getstatic 329	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
      //   1144: astore 22
      //   1146: getstatic 193	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   1149: astore 23
      //   1151: getstatic 115	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   1154: astore 24
      //   1156: aload 22
      //   1158: aload 23
      //   1160: aload 4
      //   1162: aload 24
      //   1164: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1167: getstatic 332	gnu/kawa/slib/printf:Lit61	Lgnu/math/IntNum;
      //   1170: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1173: astore 25
      //   1175: goto -317 -> 858
      //   1178: iload 29
      //   1180: ifeq +11 -> 1191
      //   1183: getstatic 190	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   1186: astore 30
      //   1188: goto -280 -> 908
      //   1191: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1194: astore 30
      //   1196: goto -288 -> 908
      //   1199: goto -569 -> 630
      //   1202: getstatic 240	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
      //   1205: aload_0
      //   1206: getfield 242	gnu/kawa/slib/printf$frame11:fc	Ljava/lang/Object;
      //   1209: getstatic 373	gnu/kawa/slib/printf:Lit58	Lgnu/text/Char;
      //   1212: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1215: getstatic 90	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1218: if_acmpeq +11 -> 1229
      //   1221: ldc_w 298
      //   1224: astore 18
      //   1226: goto -417 -> 809
      //   1229: getstatic 379	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   1232: astore 17
      //   1234: goto -841 -> 393
      //   1237: iconst_3
      //   1238: anewarray 51	java/lang/Object
      //   1241: astore 7
      //   1243: iconst_0
      //   1244: anewarray 51	java/lang/Object
      //   1247: astore 8
      //   1249: aload 7
      //   1251: iconst_0
      //   1252: aload_0
      //   1253: aload_1
      //   1254: aload_2
      //   1255: aload_3
      //   1256: aload 4
      //   1258: aload 8
      //   1260: invokevirtual 55	gnu/kawa/slib/printf$frame11:lambda30formatReal$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   1263: aastore
      //   1264: aload 7
      //   1266: iconst_1
      //   1267: getstatic 383	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   1270: aload_0
      //   1271: getfield 29	gnu/kawa/slib/printf$frame11:format$Mnreal	Lgnu/mapping/Procedure;
      //   1274: getstatic 190	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   1277: aload 6
      //   1279: invokevirtual 279	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1282: aastore
      //   1283: aload 7
      //   1285: iconst_2
      //   1286: getstatic 387	gnu/kawa/slib/printf:Lit63	Lgnu/lists/PairWithPosition;
      //   1289: aastore
      //   1290: aload 7
      //   1292: invokestatic 370	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   1295: areturn
      //   1296: astore 10
      //   1298: new 209	gnu/mapping/WrongType
      //   1301: dup
      //   1302: aload 10
      //   1304: ldc_w 389
      //   1307: iconst_2
      //   1308: aload_2
      //   1309: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1312: astore 11
      //   1314: aload 11
      //   1316: athrow
      //   1317: astore 42
      //   1319: new 209	gnu/mapping/WrongType
      //   1322: dup
      //   1323: aload 42
      //   1325: ldc 211
      //   1327: iconst_0
      //   1328: aload_3
      //   1329: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1332: astore 43
      //   1334: aload 43
      //   1336: athrow
      //   1337: astore 48
      //   1339: new 209	gnu/mapping/WrongType
      //   1342: dup
      //   1343: aload 48
      //   1345: ldc 218
      //   1347: iconst_1
      //   1348: aload 46
      //   1350: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1353: astore 49
      //   1355: aload 49
      //   1357: athrow
      //   1358: astore 52
      //   1360: new 209	gnu/mapping/WrongType
      //   1363: dup
      //   1364: aload 52
      //   1366: ldc 219
      //   1368: iconst_1
      //   1369: aload 46
      //   1371: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1374: astore 53
      //   1376: aload 53
      //   1378: athrow
      //   1379: astore 56
      //   1381: new 209	gnu/mapping/WrongType
      //   1384: dup
      //   1385: aload 56
      //   1387: ldc 221
      //   1389: iconst_1
      //   1390: aload 46
      //   1392: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1395: astore 57
      //   1397: aload 57
      //   1399: athrow
      //   1400: astore 62
      //   1402: new 209	gnu/mapping/WrongType
      //   1405: dup
      //   1406: aload 62
      //   1408: ldc 219
      //   1410: iconst_1
      //   1411: aload 46
      //   1413: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1416: astore 63
      //   1418: aload 63
      //   1420: athrow
      //   1421: astore 65
      //   1423: new 209	gnu/mapping/WrongType
      //   1426: dup
      //   1427: aload 65
      //   1429: ldc 219
      //   1431: iconst_2
      //   1432: aload 51
      //   1434: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1437: athrow
      //   1438: astore 70
      //   1440: new 209	gnu/mapping/WrongType
      //   1443: dup
      //   1444: aload 70
      //   1446: ldc_w 391
      //   1449: iconst_1
      //   1450: aload 69
      //   1452: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1455: astore 71
      //   1457: aload 71
      //   1459: athrow
      //   1460: astore 74
      //   1462: new 209	gnu/mapping/WrongType
      //   1465: dup
      //   1466: aload 74
      //   1468: ldc_w 393
      //   1471: iconst_1
      //   1472: aload 4
      //   1474: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1477: astore 75
      //   1479: aload 75
      //   1481: athrow
      //   1482: astore 84
      //   1484: new 209	gnu/mapping/WrongType
      //   1487: dup
      //   1488: aload 84
      //   1490: ldc_w 394
      //   1493: iconst_1
      //   1494: aload 4
      //   1496: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1499: astore 85
      //   1501: aload 85
      //   1503: athrow
      //   1504: astore 33
      //   1506: new 209	gnu/mapping/WrongType
      //   1509: dup
      //   1510: aload 33
      //   1512: ldc_w 396
      //   1515: bipush 254
      //   1517: aload 32
      //   1519: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1522: athrow
      //   1523: astore 19
      //   1525: new 209	gnu/mapping/WrongType
      //   1528: dup
      //   1529: aload 19
      //   1531: ldc_w 393
      //   1534: iconst_1
      //   1535: aload 4
      //   1537: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1540: astore 20
      //   1542: aload 20
      //   1544: athrow
      //   1545: astore 27
      //   1547: new 209	gnu/mapping/WrongType
      //   1550: dup
      //   1551: aload 27
      //   1553: ldc_w 398
      //   1556: bipush 254
      //   1558: aload 26
      //   1560: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1563: astore 28
      //   1565: aload 28
      //   1567: athrow
      //   1568: astore 99
      //   1570: new 209	gnu/mapping/WrongType
      //   1573: dup
      //   1574: aload 99
      //   1576: ldc_w 400
      //   1579: iconst_2
      //   1580: aload 98
      //   1582: invokespecial 214	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1585: astore 100
      //   1587: aload 100
      //   1589: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   21	27	1296	java/lang/ClassCastException
      //   77	83	1317	java/lang/ClassCastException
      //   130	137	1337	java/lang/ClassCastException
      //   159	166	1358	java/lang/ClassCastException
      //   175	182	1379	java/lang/ClassCastException
      //   204	211	1400	java/lang/ClassCastException
      //   211	218	1421	java/lang/ClassCastException
      //   274	281	1438	java/lang/ClassCastException
      //   293	300	1460	java/lang/ClassCastException
      //   372	379	1482	java/lang/ClassCastException
      //   639	644	1504	java/lang/ClassCastException
      //   809	816	1523	java/lang/ClassCastException
      //   889	899	1545	java/lang/ClassCastException
      //   1043	1053	1568	java/lang/ClassCastException
    }

    Object lambda31$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
    {
      LList localLList = LList.makeList(paramArrayOfObject, 0);
      Apply localApply1 = Scheme.apply;
      Procedure localProcedure = this.staticLink.pad;
      Apply localApply2 = Scheme.apply;
      Object[] arrayOfObject = new Object[6];
      arrayOfObject[0] = this.format$Mnreal;
      arrayOfObject[1] = this.staticLink.signed;
      arrayOfObject[2] = paramObject1;
      arrayOfObject[3] = paramObject2;
      arrayOfObject[4] = paramObject3;
      arrayOfObject[5] = localLList;
      return localApply1.apply2(localProcedure, localApply2.applyN(arrayOfObject));
    }

    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
      case 14:
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      case 13:
      }
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
  }

  public class frame12 extends ModuleBody
  {
    Object cnt;
    final ModuleMethod lambda$Fn18;
    Object port;

    public frame12()
    {
      this$1 = new ModuleMethod(this, 20, null, 4097);
      this$1.setProperty("source-location", "printf.scm:546");
      this.lambda$Fn18 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 20)
        return lambda32(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Boolean lambda32(Object paramObject)
    {
      AddOp localAddOp;
      if (strings.isString(paramObject))
        localAddOp = AddOp.$Pl;
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject;
        this.cnt = localAddOp.apply2(Integer.valueOf(strings.stringLength(localCharSequence)), this.cnt);
        ports.display(paramObject, this.port);
        return Boolean.TRUE;
        this.cnt = AddOp.$Pl.apply2(printf.Lit7, this.cnt);
        ports.display(paramObject, this.port);
        return Boolean.TRUE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, paramObject);
      }
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 20)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame13 extends ModuleBody
  {
    Object cnt;
    Object end;
    final ModuleMethod lambda$Fn19;
    Object s;
    Object str;

    public frame13()
    {
      this$1 = new ModuleMethod(this, 21, null, 4097);
      this$1.setProperty("source-location", "printf.scm:564");
      this.lambda$Fn19 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 21)
      {
        if (lambda33(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    // ERROR //
    boolean lambda33(Object paramObject)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 60	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
      //   4: ifeq +357 -> 361
      //   7: aload_0
      //   8: getfield 62	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
      //   11: getstatic 51	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   14: if_acmpne +51 -> 65
      //   17: getstatic 68	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   20: astore 37
      //   22: getstatic 74	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   25: aload_0
      //   26: getfield 76	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
      //   29: aload_0
      //   30: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   33: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   36: astore 38
      //   38: aload_1
      //   39: checkcast 86	java/lang/CharSequence
      //   42: astore 40
      //   44: aload 37
      //   46: aload 38
      //   48: aload 40
      //   50: invokestatic 90	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   53: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   56: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   59: getstatic 51	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   62: if_acmpeq +165 -> 227
      //   65: iconst_2
      //   66: anewarray 98	java/lang/Object
      //   69: astore 22
      //   71: aload_1
      //   72: checkcast 86	java/lang/CharSequence
      //   75: astore 24
      //   77: aload 22
      //   79: iconst_0
      //   80: aload 24
      //   82: invokestatic 90	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   85: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   88: aastore
      //   89: aload 22
      //   91: iconst_1
      //   92: getstatic 74	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   95: aload_0
      //   96: getfield 76	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
      //   99: aload_0
      //   100: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   103: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   106: aastore
      //   107: aload 22
      //   109: invokestatic 104	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
      //   112: astore 25
      //   114: getstatic 110	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   117: astore 26
      //   119: getstatic 68	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   122: aload 26
      //   124: aload 25
      //   126: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   129: getstatic 51	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   132: if_acmpne +189 -> 321
      //   135: aload_0
      //   136: getfield 112	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
      //   139: astore 27
      //   141: aload 27
      //   143: checkcast 114	gnu/lists/CharSeq
      //   146: astore 29
      //   148: aload_0
      //   149: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   152: astore 30
      //   154: aload 30
      //   156: checkcast 116	java/lang/Number
      //   159: invokevirtual 120	java/lang/Number:intValue	()I
      //   162: istore 32
      //   164: aload_1
      //   165: checkcast 86	java/lang/CharSequence
      //   168: astore 34
      //   170: aload 26
      //   172: checkcast 116	java/lang/Number
      //   175: invokevirtual 120	java/lang/Number:intValue	()I
      //   178: istore 36
      //   180: aload 29
      //   182: iload 32
      //   184: aload 34
      //   186: iload 36
      //   188: invokestatic 124	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   191: invokestatic 128	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   194: aload_0
      //   195: getstatic 131	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   198: aload_0
      //   199: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   202: getstatic 134	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   205: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   208: putfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   211: getstatic 131	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   214: aload 26
      //   216: getstatic 134	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   219: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   222: astore 26
      //   224: goto -105 -> 119
      //   227: iconst_2
      //   228: anewarray 98	java/lang/Object
      //   231: astore 41
      //   233: aload_0
      //   234: getfield 112	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
      //   237: astore 42
      //   239: aload 42
      //   241: checkcast 86	java/lang/CharSequence
      //   244: astore 44
      //   246: aload_0
      //   247: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   250: astore 45
      //   252: aload 45
      //   254: checkcast 116	java/lang/Number
      //   257: invokevirtual 120	java/lang/Number:intValue	()I
      //   260: istore 47
      //   262: aload 41
      //   264: iconst_0
      //   265: aload 44
      //   267: iconst_0
      //   268: iload 47
      //   270: invokestatic 138	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   273: aastore
      //   274: aload 41
      //   276: iconst_1
      //   277: aload_1
      //   278: aastore
      //   279: aload_0
      //   280: aload 41
      //   282: invokestatic 142	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   285: putfield 112	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
      //   288: aload_0
      //   289: getfield 112	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
      //   292: astore 48
      //   294: aload 48
      //   296: checkcast 86	java/lang/CharSequence
      //   299: astore 50
      //   301: aload_0
      //   302: aload 50
      //   304: invokestatic 90	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   307: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   310: putfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   313: aload_0
      //   314: aload_0
      //   315: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   318: putfield 76	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
      //   321: aload_0
      //   322: getfield 62	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
      //   325: getstatic 51	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   328: if_acmpeq +287 -> 615
      //   331: getstatic 68	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   334: aload_0
      //   335: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   338: aload_0
      //   339: getfield 76	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
      //   342: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   345: getstatic 51	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   348: if_acmpeq +261 -> 609
      //   351: iconst_1
      //   352: istore 19
      //   354: iconst_1
      //   355: iload 19
      //   357: iconst_1
      //   358: iadd
      //   359: iand
      //   360: ireturn
      //   361: aload_0
      //   362: getfield 62	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
      //   365: getstatic 51	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   368: if_acmpeq +212 -> 580
      //   371: getstatic 68	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   374: aload_0
      //   375: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   378: aload_0
      //   379: getfield 76	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
      //   382: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   385: astore_2
      //   386: aload_2
      //   387: getstatic 51	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   390: if_acmpne -69 -> 321
      //   393: aload_0
      //   394: getfield 62	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
      //   397: astore_3
      //   398: getstatic 51	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   401: astore 5
      //   403: aload_3
      //   404: aload 5
      //   406: if_acmpeq +182 -> 588
      //   409: iconst_1
      //   410: istore 6
      //   412: iconst_1
      //   413: iload 6
      //   415: iconst_1
      //   416: iadd
      //   417: iand
      //   418: istore 7
      //   420: iload 7
      //   422: ifeq +172 -> 594
      //   425: getstatic 68	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   428: aload_0
      //   429: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   432: aload_0
      //   433: getfield 76	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
      //   436: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   439: getstatic 51	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   442: if_acmpeq +60 -> 502
      //   445: iconst_2
      //   446: anewarray 98	java/lang/Object
      //   449: astore 8
      //   451: aload 8
      //   453: iconst_0
      //   454: aload_0
      //   455: getfield 112	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
      //   458: aastore
      //   459: aload 8
      //   461: iconst_1
      //   462: bipush 100
      //   464: invokestatic 146	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
      //   467: aastore
      //   468: aload_0
      //   469: aload 8
      //   471: invokestatic 142	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   474: putfield 112	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
      //   477: aload_0
      //   478: getfield 112	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
      //   481: astore 9
      //   483: aload 9
      //   485: checkcast 86	java/lang/CharSequence
      //   488: astore 11
      //   490: aload_0
      //   491: aload 11
      //   493: invokestatic 90	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   496: invokestatic 96	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   499: putfield 76	gnu/kawa/slib/printf$frame13:end	Ljava/lang/Object;
      //   502: aload_0
      //   503: getfield 112	gnu/kawa/slib/printf$frame13:s	Ljava/lang/Object;
      //   506: astore 12
      //   508: aload 12
      //   510: checkcast 114	gnu/lists/CharSeq
      //   513: astore 14
      //   515: aload_0
      //   516: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   519: astore 15
      //   521: aload 15
      //   523: checkcast 116	java/lang/Number
      //   526: invokevirtual 120	java/lang/Number:intValue	()I
      //   529: istore 17
      //   531: aload_1
      //   532: invokestatic 151	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
      //   535: ifeq +67 -> 602
      //   538: aload_1
      //   539: checkcast 153	gnu/text/Char
      //   542: invokevirtual 157	gnu/text/Char:charValue	()C
      //   545: istore 21
      //   547: iload 21
      //   549: istore 18
      //   551: aload 14
      //   553: iload 17
      //   555: iload 18
      //   557: invokestatic 128	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
      //   560: aload_0
      //   561: getstatic 131	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   564: aload_0
      //   565: getfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   568: getstatic 134	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   571: invokevirtual 84	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   574: putfield 78	gnu/kawa/slib/printf$frame13:cnt	Ljava/lang/Object;
      //   577: goto -256 -> 321
      //   580: aload_0
      //   581: getfield 62	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
      //   584: astore_2
      //   585: goto -199 -> 386
      //   588: iconst_0
      //   589: istore 6
      //   591: goto -179 -> 412
      //   594: iload 7
      //   596: ifeq -94 -> 502
      //   599: goto -154 -> 445
      //   602: bipush 63
      //   604: istore 18
      //   606: goto -55 -> 551
      //   609: iconst_0
      //   610: istore 19
      //   612: goto -258 -> 354
      //   615: aload_0
      //   616: getfield 62	gnu/kawa/slib/printf$frame13:str	Ljava/lang/Object;
      //   619: getstatic 51	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   622: if_acmpeq +9 -> 631
      //   625: iconst_1
      //   626: istore 19
      //   628: goto -274 -> 354
      //   631: iconst_0
      //   632: istore 19
      //   634: goto -280 -> 354
      //   637: astore 39
      //   639: new 159	gnu/mapping/WrongType
      //   642: dup
      //   643: aload 39
      //   645: ldc 161
      //   647: iconst_1
      //   648: aload_1
      //   649: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   652: athrow
      //   653: astore 23
      //   655: new 159	gnu/mapping/WrongType
      //   658: dup
      //   659: aload 23
      //   661: ldc 161
      //   663: iconst_1
      //   664: aload_1
      //   665: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   668: athrow
      //   669: astore 28
      //   671: new 159	gnu/mapping/WrongType
      //   674: dup
      //   675: aload 28
      //   677: ldc 166
      //   679: iconst_1
      //   680: aload 27
      //   682: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   685: athrow
      //   686: astore 31
      //   688: new 159	gnu/mapping/WrongType
      //   691: dup
      //   692: aload 31
      //   694: ldc 166
      //   696: iconst_2
      //   697: aload 30
      //   699: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   702: athrow
      //   703: astore 33
      //   705: new 159	gnu/mapping/WrongType
      //   708: dup
      //   709: aload 33
      //   711: ldc 168
      //   713: iconst_1
      //   714: aload_1
      //   715: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   718: athrow
      //   719: astore 35
      //   721: new 159	gnu/mapping/WrongType
      //   724: dup
      //   725: aload 35
      //   727: ldc 168
      //   729: iconst_2
      //   730: aload 26
      //   732: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   735: athrow
      //   736: astore 43
      //   738: new 159	gnu/mapping/WrongType
      //   741: dup
      //   742: aload 43
      //   744: ldc 169
      //   746: iconst_1
      //   747: aload 42
      //   749: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   752: athrow
      //   753: astore 46
      //   755: new 159	gnu/mapping/WrongType
      //   758: dup
      //   759: aload 46
      //   761: ldc 169
      //   763: iconst_3
      //   764: aload 45
      //   766: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   769: athrow
      //   770: astore 49
      //   772: new 159	gnu/mapping/WrongType
      //   775: dup
      //   776: aload 49
      //   778: ldc 161
      //   780: iconst_1
      //   781: aload 48
      //   783: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   786: athrow
      //   787: astore 4
      //   789: new 159	gnu/mapping/WrongType
      //   792: dup
      //   793: aload 4
      //   795: ldc 171
      //   797: bipush 254
      //   799: aload_3
      //   800: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   803: athrow
      //   804: astore 10
      //   806: new 159	gnu/mapping/WrongType
      //   809: dup
      //   810: aload 10
      //   812: ldc 161
      //   814: iconst_1
      //   815: aload 9
      //   817: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   820: athrow
      //   821: astore 13
      //   823: new 159	gnu/mapping/WrongType
      //   826: dup
      //   827: aload 13
      //   829: ldc 166
      //   831: iconst_1
      //   832: aload 12
      //   834: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   837: athrow
      //   838: astore 16
      //   840: new 159	gnu/mapping/WrongType
      //   843: dup
      //   844: aload 16
      //   846: ldc 166
      //   848: iconst_2
      //   849: aload 15
      //   851: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   854: athrow
      //   855: astore 20
      //   857: new 159	gnu/mapping/WrongType
      //   860: dup
      //   861: aload 20
      //   863: ldc 166
      //   865: iconst_3
      //   866: aload_1
      //   867: invokespecial 164	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   870: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   38	44	637	java/lang/ClassCastException
      //   71	77	653	java/lang/ClassCastException
      //   141	148	669	java/lang/ClassCastException
      //   154	164	686	java/lang/ClassCastException
      //   164	170	703	java/lang/ClassCastException
      //   170	180	719	java/lang/ClassCastException
      //   239	246	736	java/lang/ClassCastException
      //   252	262	753	java/lang/ClassCastException
      //   294	301	770	java/lang/ClassCastException
      //   398	403	787	java/lang/ClassCastException
      //   483	490	804	java/lang/ClassCastException
      //   508	515	821	java/lang/ClassCastException
      //   521	531	838	java/lang/ClassCastException
      //   538	547	855	java/lang/ClassCastException
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 21)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame2 extends ModuleBody
  {
    Object cont;
    final ModuleMethod lambda$Fn5;
    final ModuleMethod lambda$Fn6;
    printf.frame staticLink;

    public frame2()
    {
      this$1 = new ModuleMethod(this, 10, null, 8194);
      this$1.setProperty("source-location", "printf.scm:81");
      this.lambda$Fn6 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 11, null, 4097);
      localModuleMethod.setProperty("source-location", "printf.scm:78");
      this.lambda$Fn5 = localModuleMethod;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 11)
        return lambda9(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 10)
        return lambda10(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda10(Object paramObject1, Object paramObject2)
    {
      printf.frame3 localframe3 = new printf.frame3();
      localframe3.staticLink = this;
      localframe3.sgn = paramObject2;
      return this.staticLink.lambda3digits(paramObject1, localframe3.lambda$Fn7);
    }

    Object lambda9(Object paramObject)
    {
      return this.staticLink.lambda2sign(paramObject, this.lambda$Fn6);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 11)
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
      if (paramModuleMethod.selector == 10)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }

  public class frame3 extends ModuleBody
  {
    final ModuleMethod lambda$Fn7;
    Object sgn;
    printf.frame2 staticLink;

    public frame3()
    {
      this$1 = new ModuleMethod(this, 9, null, 8194);
      this$1.setProperty("source-location", "printf.scm:84");
      this.lambda$Fn7 = this$1;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 9)
        return lambda11(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    // ERROR //
    Object lambda11(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: new 47	gnu/kawa/slib/printf$frame4
      //   3: dup
      //   4: invokespecial 48	gnu/kawa/slib/printf$frame4:<init>	()V
      //   7: astore_3
      //   8: aload_3
      //   9: aload_0
      //   10: putfield 51	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   13: aload_3
      //   14: aload_2
      //   15: putfield 54	gnu/kawa/slib/printf$frame4:idigs	Ljava/lang/Object;
      //   18: aload_3
      //   19: getfield 57	gnu/kawa/slib/printf$frame4:lambda$Fn8	Lgnu/expr/ModuleMethod;
      //   22: astore 4
      //   24: getstatic 63	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
      //   27: aload_1
      //   28: aload_0
      //   29: getfield 65	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   32: getfield 70	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   35: getfield 75	gnu/kawa/slib/printf$frame:n	I
      //   38: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   41: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   44: astore 5
      //   46: aload 5
      //   48: checkcast 87	java/lang/Boolean
      //   51: invokevirtual 91	java/lang/Boolean:booleanValue	()Z
      //   54: istore 7
      //   56: iload 7
      //   58: ifeq +73 -> 131
      //   61: getstatic 97	gnu/kawa/slib/printf:Lit11	Lgnu/text/Char;
      //   64: astore 8
      //   66: aload_0
      //   67: getfield 65	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   70: getfield 70	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   73: getfield 100	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   76: astore 9
      //   78: aload 9
      //   80: checkcast 102	java/lang/CharSequence
      //   83: astore 11
      //   85: aload_1
      //   86: checkcast 104	java/lang/Number
      //   89: invokevirtual 108	java/lang/Number:intValue	()I
      //   92: istore 13
      //   94: aload 8
      //   96: aload 11
      //   98: iload 13
      //   100: invokestatic 114	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   103: invokestatic 120	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   106: invokestatic 126	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   109: ifeq +27 -> 136
      //   112: getstatic 130	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   115: aload 4
      //   117: getstatic 136	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   120: aload_1
      //   121: getstatic 140	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   124: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   127: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   130: areturn
      //   131: iload 7
      //   133: ifne -21 -> 112
      //   136: getstatic 130	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   139: aload 4
      //   141: aload_1
      //   142: invokevirtual 85	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   145: areturn
      //   146: astore 6
      //   148: new 142	gnu/mapping/WrongType
      //   151: dup
      //   152: aload 6
      //   154: ldc 144
      //   156: bipush 254
      //   158: aload 5
      //   160: invokespecial 147	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   163: athrow
      //   164: astore 10
      //   166: new 142	gnu/mapping/WrongType
      //   169: dup
      //   170: aload 10
      //   172: ldc 149
      //   174: iconst_1
      //   175: aload 9
      //   177: invokespecial 147	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   180: athrow
      //   181: astore 12
      //   183: new 142	gnu/mapping/WrongType
      //   186: dup
      //   187: aload 12
      //   189: ldc 149
      //   191: iconst_2
      //   192: aload_1
      //   193: invokespecial 147	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   196: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   46	56	146	java/lang/ClassCastException
      //   78	85	164	java/lang/ClassCastException
      //   85	94	181	java/lang/ClassCastException
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 9)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }

  public class frame4 extends ModuleBody
  {
    Object idigs;
    final ModuleMethod lambda$Fn8;
    final ModuleMethod lambda$Fn9;
    printf.frame3 staticLink;

    public frame4()
    {
      this$1 = new ModuleMethod(this, 7, null, 8194);
      this$1.setProperty("source-location", "printf.scm:90");
      this.lambda$Fn9 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 8, null, 4097);
      localModuleMethod.setProperty("source-location", "printf.scm:87");
      this.lambda$Fn8 = localModuleMethod;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 8)
        return lambda12(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 7)
        return lambda13(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda12(Object paramObject)
    {
      return this.staticLink.staticLink.staticLink.lambda3digits(paramObject, this.lambda$Fn9);
    }

    // ERROR //
    Object lambda13(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: new 77	gnu/kawa/slib/printf$frame5
      //   3: dup
      //   4: invokespecial 78	gnu/kawa/slib/printf$frame5:<init>	()V
      //   7: astore_3
      //   8: aload_3
      //   9: aload_0
      //   10: putfield 81	gnu/kawa/slib/printf$frame5:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   13: aload_3
      //   14: aload_2
      //   15: putfield 84	gnu/kawa/slib/printf$frame5:fdigs	Ljava/lang/Object;
      //   18: aload_3
      //   19: getfield 87	gnu/kawa/slib/printf$frame5:lambda$Fn10	Lgnu/expr/ModuleMethod;
      //   22: astore 4
      //   24: aload_0
      //   25: getfield 58	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   28: getfield 63	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   31: getfield 68	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   34: astore 5
      //   36: new 89	gnu/kawa/slib/printf$frame6
      //   39: dup
      //   40: invokespecial 90	gnu/kawa/slib/printf$frame6:<init>	()V
      //   43: astore 6
      //   45: aload 6
      //   47: aload 5
      //   49: putfield 91	gnu/kawa/slib/printf$frame6:staticLink	Lgnu/kawa/slib/printf$frame;
      //   52: aload 6
      //   54: aload 4
      //   56: putfield 94	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   59: getstatic 100	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   62: aload_1
      //   63: aload_0
      //   64: getfield 58	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   67: getfield 63	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   70: getfield 68	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   73: getfield 103	gnu/kawa/slib/printf$frame:n	I
      //   76: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   79: invokevirtual 113	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   82: getstatic 119	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   85: if_acmpeq +19 -> 104
      //   88: getstatic 123	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   91: aload 6
      //   93: getfield 94	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   96: aload_1
      //   97: getstatic 129	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   100: invokevirtual 133	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   103: areturn
      //   104: aload_0
      //   105: getfield 58	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   108: getfield 63	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   111: getfield 68	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   114: getfield 136	gnu/kawa/slib/printf$frame:str	Ljava/lang/Object;
      //   117: astore 7
      //   119: aload 7
      //   121: checkcast 138	java/lang/CharSequence
      //   124: astore 9
      //   126: aload_1
      //   127: checkcast 140	java/lang/Number
      //   130: invokevirtual 144	java/lang/Number:intValue	()I
      //   133: istore 11
      //   135: aload 9
      //   137: iload 11
      //   139: invokestatic 150	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   142: invokestatic 156	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   145: getstatic 160	gnu/kawa/slib/printf:Lit10	Lgnu/lists/PairWithPosition;
      //   148: invokestatic 165	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   151: getstatic 119	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   154: if_acmpeq +32 -> 186
      //   157: aload_0
      //   158: getfield 58	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   161: getfield 63	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   164: getfield 68	gnu/kawa/slib/printf$frame2:staticLink	Lgnu/kawa/slib/printf$frame;
      //   167: getstatic 171	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   170: aload_1
      //   171: getstatic 174	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   174: invokevirtual 113	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   177: aload 6
      //   179: getfield 177	gnu/kawa/slib/printf$frame6:lambda$Fn11	Lgnu/expr/ModuleMethod;
      //   182: invokevirtual 180	gnu/kawa/slib/printf$frame:lambda2sign	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   185: areturn
      //   186: getstatic 123	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   189: aload 6
      //   191: getfield 94	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   194: aload_1
      //   195: getstatic 129	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   198: invokevirtual 133	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   201: areturn
      //   202: astore 8
      //   204: new 182	gnu/mapping/WrongType
      //   207: dup
      //   208: aload 8
      //   210: ldc 184
      //   212: iconst_1
      //   213: aload 7
      //   215: invokespecial 187	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   218: athrow
      //   219: astore 10
      //   221: new 182	gnu/mapping/WrongType
      //   224: dup
      //   225: aload 10
      //   227: ldc 184
      //   229: iconst_2
      //   230: aload_1
      //   231: invokespecial 187	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   234: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   119	126	202	java/lang/ClassCastException
      //   126	135	219	java/lang/ClassCastException
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

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 7)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }

  public class frame5 extends ModuleBody
  {
    Object fdigs;
    final ModuleMethod lambda$Fn10;
    printf.frame4 staticLink;

    public frame5()
    {
      this$1 = new ModuleMethod(this, 6, null, 8194);
      this$1.setProperty("source-location", "printf.scm:92");
      this.lambda$Fn10 = this$1;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 6)
        return lambda14(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    // ERROR //
    Object lambda14(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: iconst_3
      //   1: anewarray 47	java/lang/Object
      //   4: astore_3
      //   5: aload_3
      //   6: iconst_0
      //   7: ldc 49
      //   9: aastore
      //   10: aload_3
      //   11: iconst_1
      //   12: aload_0
      //   13: getfield 51	gnu/kawa/slib/printf$frame5:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   16: getfield 56	gnu/kawa/slib/printf$frame4:idigs	Ljava/lang/Object;
      //   19: aastore
      //   20: aload_3
      //   21: iconst_2
      //   22: aload_0
      //   23: getfield 58	gnu/kawa/slib/printf$frame5:fdigs	Ljava/lang/Object;
      //   26: aastore
      //   27: aload_3
      //   28: invokestatic 64	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   31: astore 4
      //   33: aload 4
      //   35: invokestatic 68	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   38: istore 5
      //   40: getstatic 74	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   43: astore 6
      //   45: getstatic 80	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   48: astore 7
      //   50: aload_0
      //   51: getfield 51	gnu/kawa/slib/printf$frame5:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   54: getfield 56	gnu/kawa/slib/printf$frame4:idigs	Ljava/lang/Object;
      //   57: astore 8
      //   59: aload 8
      //   61: checkcast 82	java/lang/CharSequence
      //   64: astore 10
      //   66: aload 7
      //   68: aload_2
      //   69: aload 10
      //   71: invokestatic 68	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   74: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   77: invokevirtual 92	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   80: astore 11
      //   82: getstatic 98	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   85: aload 6
      //   87: iload 5
      //   89: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   92: invokevirtual 92	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   95: getstatic 104	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   98: if_acmpeq +71 -> 169
      //   101: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   104: astore 20
      //   106: iconst_5
      //   107: anewarray 47	java/lang/Object
      //   110: astore 21
      //   112: aload 21
      //   114: iconst_0
      //   115: aload_0
      //   116: getfield 51	gnu/kawa/slib/printf$frame5:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   119: getfield 111	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   122: getfield 116	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   125: getfield 121	gnu/kawa/slib/printf$frame2:cont	Ljava/lang/Object;
      //   128: aastore
      //   129: aload 21
      //   131: iconst_1
      //   132: aload_1
      //   133: aastore
      //   134: aload 21
      //   136: iconst_2
      //   137: aload_0
      //   138: getfield 51	gnu/kawa/slib/printf$frame5:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   141: getfield 111	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   144: getfield 124	gnu/kawa/slib/printf$frame3:sgn	Ljava/lang/Object;
      //   147: aastore
      //   148: aload 21
      //   150: iconst_3
      //   151: ldc 49
      //   153: aastore
      //   154: aload 21
      //   156: iconst_4
      //   157: getstatic 74	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   160: aastore
      //   161: aload 20
      //   163: aload 21
      //   165: invokevirtual 128	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   168: areturn
      //   169: getstatic 132	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
      //   172: astore 12
      //   174: aload 6
      //   176: checkcast 134	java/lang/Number
      //   179: invokevirtual 138	java/lang/Number:intValue	()I
      //   182: istore 14
      //   184: aload 12
      //   186: aload 4
      //   188: iload 14
      //   190: invokestatic 142	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   193: invokestatic 148	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   196: invokestatic 154	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   199: ifeq +32 -> 231
      //   202: getstatic 80	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   205: aload 6
      //   207: getstatic 74	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   210: invokevirtual 92	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   213: astore 6
      //   215: getstatic 157	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   218: aload 11
      //   220: getstatic 74	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   223: invokevirtual 92	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   226: astore 11
      //   228: goto -146 -> 82
      //   231: getstatic 108	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   234: astore 15
      //   236: iconst_5
      //   237: anewarray 47	java/lang/Object
      //   240: astore 16
      //   242: aload 16
      //   244: iconst_0
      //   245: aload_0
      //   246: getfield 51	gnu/kawa/slib/printf$frame5:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   249: getfield 111	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   252: getfield 116	gnu/kawa/slib/printf$frame3:staticLink	Lgnu/kawa/slib/printf$frame2;
      //   255: getfield 121	gnu/kawa/slib/printf$frame2:cont	Ljava/lang/Object;
      //   258: aastore
      //   259: aload 16
      //   261: iconst_1
      //   262: aload_1
      //   263: aastore
      //   264: aload 16
      //   266: iconst_2
      //   267: aload_0
      //   268: getfield 51	gnu/kawa/slib/printf$frame5:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   271: getfield 111	gnu/kawa/slib/printf$frame4:staticLink	Lgnu/kawa/slib/printf$frame3;
      //   274: getfield 124	gnu/kawa/slib/printf$frame3:sgn	Ljava/lang/Object;
      //   277: aastore
      //   278: getstatic 157	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   281: aload 6
      //   283: getstatic 74	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   286: invokevirtual 92	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   289: astore 17
      //   291: aload 17
      //   293: checkcast 134	java/lang/Number
      //   296: invokevirtual 138	java/lang/Number:intValue	()I
      //   299: istore 19
      //   301: aload 16
      //   303: iconst_3
      //   304: aload 4
      //   306: iload 19
      //   308: iload 5
      //   310: invokestatic 161	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   313: aastore
      //   314: aload 16
      //   316: iconst_4
      //   317: aload 11
      //   319: aastore
      //   320: aload 15
      //   322: aload 16
      //   324: invokevirtual 128	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   327: areturn
      //   328: astore 9
      //   330: new 163	gnu/mapping/WrongType
      //   333: dup
      //   334: aload 9
      //   336: ldc 165
      //   338: iconst_1
      //   339: aload 8
      //   341: invokespecial 168	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   344: athrow
      //   345: astore 13
      //   347: new 163	gnu/mapping/WrongType
      //   350: dup
      //   351: aload 13
      //   353: ldc 170
      //   355: iconst_2
      //   356: aload 6
      //   358: invokespecial 168	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   361: athrow
      //   362: astore 18
      //   364: new 163	gnu/mapping/WrongType
      //   367: dup
      //   368: aload 18
      //   370: ldc 171
      //   372: iconst_2
      //   373: aload 17
      //   375: invokespecial 168	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   378: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   59	66	328	java/lang/ClassCastException
      //   174	184	345	java/lang/ClassCastException
      //   291	301	362	java/lang/ClassCastException
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 6)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }

  public class frame6 extends ModuleBody
  {
    Object cont;
    final ModuleMethod lambda$Fn11;
    printf.frame staticLink;

    public frame6()
    {
      this$1 = new ModuleMethod(this, 5, null, 8194);
      this$1.setProperty("source-location", "printf.scm:67");
      this.lambda$Fn11 = this$1;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 5)
        return lambda15(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda15(Object paramObject1, Object paramObject2)
    {
      printf.frame7 localframe7 = new printf.frame7();
      localframe7.staticLink = this;
      localframe7.sgn = paramObject2;
      return this.staticLink.lambda3digits(paramObject1, localframe7.lambda$Fn12);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 5)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }

  public class frame7 extends ModuleBody
  {
    final ModuleMethod lambda$Fn12;
    Object sgn;
    printf.frame6 staticLink;

    public frame7()
    {
      this$1 = new ModuleMethod(this, 4, null, 8194);
      this$1.setProperty("source-location", "printf.scm:69");
      this.lambda$Fn12 = this$1;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 4)
        return lambda16(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    // ERROR //
    Object lambda16(Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: getstatic 51	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: astore_3
      //   4: aload_0
      //   5: getfield 53	gnu/kawa/slib/printf$frame7:staticLink	Lgnu/kawa/slib/printf$frame6;
      //   8: getfield 58	gnu/kawa/slib/printf$frame6:cont	Ljava/lang/Object;
      //   11: astore 4
      //   13: getstatic 64	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
      //   16: astore 5
      //   18: aload_0
      //   19: getfield 66	gnu/kawa/slib/printf$frame7:sgn	Ljava/lang/Object;
      //   22: astore 6
      //   24: aload 6
      //   26: checkcast 68	gnu/text/Char
      //   29: astore 8
      //   31: aload 5
      //   33: aload 8
      //   35: invokestatic 74	kawa/lib/characters:isChar$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
      //   38: ifeq +36 -> 74
      //   41: getstatic 80	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
      //   44: astore 12
      //   46: aload_2
      //   47: checkcast 82	java/lang/CharSequence
      //   50: astore 14
      //   52: aload 12
      //   54: aload 14
      //   56: invokestatic 88	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
      //   59: invokevirtual 94	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   62: astore 11
      //   64: aload_3
      //   65: aload 4
      //   67: aload_1
      //   68: aload 11
      //   70: invokevirtual 98	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   73: areturn
      //   74: aload_2
      //   75: checkcast 82	java/lang/CharSequence
      //   78: astore 10
      //   80: aload 10
      //   82: invokestatic 88	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
      //   85: astore 11
      //   87: goto -23 -> 64
      //   90: astore 7
      //   92: new 100	gnu/mapping/WrongType
      //   95: dup
      //   96: aload 7
      //   98: ldc 102
      //   100: iconst_2
      //   101: aload 6
      //   103: invokespecial 105	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   106: athrow
      //   107: astore 13
      //   109: new 100	gnu/mapping/WrongType
      //   112: dup
      //   113: aload 13
      //   115: ldc 107
      //   117: iconst_1
      //   118: aload_2
      //   119: invokespecial 105	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   122: athrow
      //   123: astore 9
      //   125: new 100	gnu/mapping/WrongType
      //   128: dup
      //   129: aload 9
      //   131: ldc 107
      //   133: iconst_1
      //   134: aload_2
      //   135: invokespecial 105	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   138: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   24	31	90	java/lang/ClassCastException
      //   46	52	107	java/lang/ClassCastException
      //   74	80	123	java/lang/ClassCastException
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 4)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }

  public class frame8 extends ModuleBody
  {
    CharSequence str;

    public Object lambda17dig(Object paramObject)
    {
      CharSequence localCharSequence = this.str;
      try
      {
        int i = ((Number)paramObject).intValue();
        int j = strings.stringRef(localCharSequence, i);
        if (unicode.isCharNumeric(Char.make(j)))
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Char.make(j);
          return numbers.string$To$Number(strings.$make$string$(arrayOfObject));
        }
        return printf.Lit1;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-ref", 2, paramObject);
      }
    }
  }

  public class frame9 extends ModuleBody
  {
    LList args;
    Object fc;
    int fl;
    Object format$Mnstring;
    Object out;
    Object pos;

    // ERROR //
    public Object lambda18mustAdvance()
    {
      // Byte code:
      //   0: aload_0
      //   1: getstatic 27	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
      //   4: getstatic 33	gnu/kawa/slib/printf:Lit7	Lgnu/math/IntNum;
      //   7: aload_0
      //   8: getfield 35	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   11: invokevirtual 41	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   14: putfield 35	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   17: getstatic 47	kawa/standard/Scheme:numGEq	Lgnu/kawa/functions/NumberCompare;
      //   20: aload_0
      //   21: getfield 35	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   24: aload_0
      //   25: getfield 49	gnu/kawa/slib/printf$frame9:fl	I
      //   28: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   31: invokevirtual 41	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   34: getstatic 61	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   37: if_acmpeq +8 -> 45
      //   40: aload_0
      //   41: invokevirtual 64	gnu/kawa/slib/printf$frame9:lambda20incomplete	()Ljava/lang/Object;
      //   44: areturn
      //   45: aload_0
      //   46: getfield 66	gnu/kawa/slib/printf$frame9:format$Mnstring	Ljava/lang/Object;
      //   49: astore_1
      //   50: aload_1
      //   51: checkcast 68	java/lang/CharSequence
      //   54: astore_3
      //   55: aload_0
      //   56: getfield 35	gnu/kawa/slib/printf$frame9:pos	Ljava/lang/Object;
      //   59: astore 4
      //   61: aload 4
      //   63: checkcast 70	java/lang/Number
      //   66: invokevirtual 74	java/lang/Number:intValue	()I
      //   69: istore 6
      //   71: aload_0
      //   72: aload_3
      //   73: iload 6
      //   75: invokestatic 80	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
      //   78: invokestatic 86	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   81: putfield 88	gnu/kawa/slib/printf$frame9:fc	Ljava/lang/Object;
      //   84: getstatic 94	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   87: areturn
      //   88: astore_2
      //   89: new 96	gnu/mapping/WrongType
      //   92: dup
      //   93: aload_2
      //   94: ldc 98
      //   96: iconst_1
      //   97: aload_1
      //   98: invokespecial 101	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   101: athrow
      //   102: astore 5
      //   104: new 96	gnu/mapping/WrongType
      //   107: dup
      //   108: aload 5
      //   110: ldc 98
      //   112: iconst_2
      //   113: aload 4
      //   115: invokespecial 101	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   118: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   50	55	88	java/lang/ClassCastException
      //   61	71	102	java/lang/ClassCastException
    }

    public boolean lambda19isEndOfFormat()
    {
      return ((Boolean)Scheme.numGEq.apply2(this.pos, Integer.valueOf(this.fl))).booleanValue();
    }

    public Object lambda20incomplete()
    {
      SimpleSymbol localSimpleSymbol = printf.Lit34;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "conversion specification incomplete";
      arrayOfObject[1] = this.format$Mnstring;
      return misc.error$V(localSimpleSymbol, arrayOfObject);
    }

    public Object lambda21out$St(Object paramObject)
    {
      if (strings.isString(paramObject))
        return Scheme.applyToArgs.apply2(this.out, paramObject);
      Object localObject;
      boolean bool;
      do
      {
        localObject = Scheme.applyToArgs.apply2(this.out, lists.car.apply1(paramObject));
        if (localObject == Boolean.FALSE)
          break;
        paramObject = lists.cdr.apply1(paramObject);
        bool = lists.isNull(paramObject);
      }
      while (!bool);
      if (bool)
        return Boolean.TRUE;
      return Boolean.FALSE;
      return localObject;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.printf
 * JD-Core Version:    0.6.2
 */