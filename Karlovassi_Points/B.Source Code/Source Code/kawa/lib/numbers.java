package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Arithmetic;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.BitOps;
import gnu.math.Complex;
import gnu.math.DComplex;
import gnu.math.DFloNum;
import gnu.math.Duration;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.Quantity;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.math.BigDecimal;
import java.math.BigInteger;
import kawa.standard.Scheme;

public class numbers extends ModuleBody
{
  public static final numbers $instance;
  static final IntNum Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final IntNum Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
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
  static final SimpleSymbol Lit42;
  static final SimpleSymbol Lit43;
  static final SimpleSymbol Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit50;
  static final SimpleSymbol Lit51;
  static final SimpleSymbol Lit52;
  static final SimpleSymbol Lit53;
  static final SimpleSymbol Lit54;
  static final SimpleSymbol Lit55;
  static final SimpleSymbol Lit56;
  static final SimpleSymbol Lit57;
  static final SimpleSymbol Lit58;
  static final SimpleSymbol Lit59;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit60;
  static final SimpleSymbol Lit61;
  static final SimpleSymbol Lit62;
  static final SimpleSymbol Lit63 = (SimpleSymbol)new SimpleSymbol("duration").readResolve();
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod abs;
  public static final ModuleMethod acos;
  public static final ModuleMethod angle;
  public static final ModuleMethod asin;
  public static final GenericProc atan;
  public static final ModuleMethod bitwise$Mnbit$Mncount;
  public static final ModuleMethod bitwise$Mnbit$Mnfield;
  public static final ModuleMethod bitwise$Mnbit$Mnset$Qu;
  public static final ModuleMethod bitwise$Mncopy$Mnbit;
  public static final ModuleMethod bitwise$Mncopy$Mnbit$Mnfield;
  public static final ModuleMethod bitwise$Mnfirst$Mnbit$Mnset;
  public static final ModuleMethod bitwise$Mnif;
  public static final ModuleMethod bitwise$Mnlength;
  public static final ModuleMethod bitwise$Mnreverse$Mnbit$Mnfield;
  public static final ModuleMethod bitwise$Mnrotate$Mnbit$Mnfield;
  public static final ModuleMethod ceiling;
  public static final ModuleMethod complex$Qu;
  public static final ModuleMethod cos;
  public static final ModuleMethod denominator;
  public static final ModuleMethod div$Mnand$Mnmod;
  public static final ModuleMethod div0$Mnand$Mnmod0;
  public static final ModuleMethod duration;
  public static final ModuleMethod exact;
  public static final ModuleMethod exact$Mn$Grinexact;
  public static final ModuleMethod exact$Qu;
  public static final ModuleMethod exp;
  public static final ModuleMethod floor;
  public static final ModuleMethod gcd;
  public static final ModuleMethod imag$Mnpart;
  public static final ModuleMethod inexact;
  public static final ModuleMethod inexact$Mn$Grexact;
  public static final ModuleMethod inexact$Qu;
  public static final ModuleMethod integer$Qu;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn2;
  static final ModuleMethod lambda$Fn3;
  static final ModuleMethod lambda$Fn4;
  public static final ModuleMethod lcm;
  public static final ModuleMethod log;
  public static final ModuleMethod logcount;
  public static final ModuleMethod logop;
  public static final ModuleMethod logtest;
  public static final ModuleMethod magnitude;
  public static final ModuleMethod make$Mnpolar;
  public static final ModuleMethod make$Mnquantity;
  public static final ModuleMethod make$Mnrectangular;
  public static final ModuleMethod max;
  public static final ModuleMethod min;
  public static final ModuleMethod negative$Qu;
  public static final ModuleMethod number$Mn$Grstring;
  public static final ModuleMethod number$Qu;
  public static final ModuleMethod numerator;
  public static final ModuleMethod positive$Qu;
  public static final ModuleMethod quantity$Mn$Grnumber;
  public static final ModuleMethod quantity$Mn$Grunit;
  public static final ModuleMethod quantity$Qu;
  public static final ModuleMethod rational$Qu;
  public static final ModuleMethod rationalize;
  public static final ModuleMethod real$Mnpart;
  public static final ModuleMethod real$Qu;
  public static final ModuleMethod round;
  public static final ModuleMethod sin;
  public static final GenericProc sqrt;
  public static final ModuleMethod string$Mn$Grnumber;
  public static final ModuleMethod tan;
  public static final ModuleMethod truncate;
  public static final ModuleMethod zero$Qu;

  static
  {
    Lit62 = (SimpleSymbol)new SimpleSymbol("make-quantity").readResolve();
    Lit61 = (SimpleSymbol)new SimpleSymbol("quantity->unit").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol("quantity->number").readResolve();
    Lit59 = (SimpleSymbol)new SimpleSymbol("string->number").readResolve();
    Lit58 = (SimpleSymbol)new SimpleSymbol("number->string").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("bitwise-reverse-bit-field").readResolve();
    Lit56 = (SimpleSymbol)new SimpleSymbol("bitwise-rotate-bit-field").readResolve();
    Lit55 = (SimpleSymbol)new SimpleSymbol("bitwise-first-bit-set").readResolve();
    Lit54 = (SimpleSymbol)new SimpleSymbol("bitwise-length").readResolve();
    Lit53 = (SimpleSymbol)new SimpleSymbol("bitwise-bit-count").readResolve();
    Lit52 = (SimpleSymbol)new SimpleSymbol("logcount").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("logtest").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("bitwise-if").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("bitwise-bit-field").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("bitwise-copy-bit-field").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("bitwise-copy-bit").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("bitwise-bit-set?").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("logop").readResolve();
    Lit44 = (SimpleSymbol)new SimpleSymbol("inexact->exact").readResolve();
    Lit43 = (SimpleSymbol)new SimpleSymbol("exact->inexact").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("exact").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("inexact").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("angle").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("magnitude").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("imag-part").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("real-part").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("make-polar").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("make-rectangular").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("acos").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("asin").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("tan").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("cos").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("sin").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("log").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("exp").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("rationalize").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("round").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("truncate").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("ceiling").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("floor").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("denominator").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("numerator").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("lcm").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("gcd").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("div0-and-mod0").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("div-and-mod").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("abs").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("min").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("max").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("negative?").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("positive?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("zero?").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("inexact?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("exact?").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("integer?").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("rational?").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("real?").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("complex?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("quantity?").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("number?").readResolve();
    Lit2 = IntNum.make(1);
    Lit1 = (SimpleSymbol)new SimpleSymbol("signum").readResolve();
    Lit0 = IntNum.make(0);
    $instance = new numbers();
    numbers localnumbers = $instance;
    number$Qu = new ModuleMethod(localnumbers, 1, Lit3, 4097);
    quantity$Qu = new ModuleMethod(localnumbers, 2, Lit4, 4097);
    complex$Qu = new ModuleMethod(localnumbers, 3, Lit5, 4097);
    real$Qu = new ModuleMethod(localnumbers, 4, Lit6, 4097);
    rational$Qu = new ModuleMethod(localnumbers, 5, Lit7, 4097);
    integer$Qu = new ModuleMethod(localnumbers, 6, Lit8, 4097);
    exact$Qu = new ModuleMethod(localnumbers, 7, Lit9, 4097);
    inexact$Qu = new ModuleMethod(localnumbers, 8, Lit10, 4097);
    zero$Qu = new ModuleMethod(localnumbers, 9, Lit11, 4097);
    positive$Qu = new ModuleMethod(localnumbers, 10, Lit12, 4097);
    negative$Qu = new ModuleMethod(localnumbers, 11, Lit13, 4097);
    max = new ModuleMethod(localnumbers, 12, Lit14, -4096);
    min = new ModuleMethod(localnumbers, 13, Lit15, -4096);
    abs = new ModuleMethod(localnumbers, 14, Lit16, 4097);
    div$Mnand$Mnmod = new ModuleMethod(localnumbers, 15, Lit17, 8194);
    div0$Mnand$Mnmod0 = new ModuleMethod(localnumbers, 16, Lit18, 8194);
    gcd = new ModuleMethod(localnumbers, 17, Lit19, -4096);
    lcm = new ModuleMethod(localnumbers, 18, Lit20, -4096);
    numerator = new ModuleMethod(localnumbers, 19, Lit21, 4097);
    denominator = new ModuleMethod(localnumbers, 20, Lit22, 4097);
    floor = new ModuleMethod(localnumbers, 21, Lit23, 4097);
    ceiling = new ModuleMethod(localnumbers, 22, Lit24, 4097);
    truncate = new ModuleMethod(localnumbers, 23, Lit25, 4097);
    round = new ModuleMethod(localnumbers, 24, Lit26, 4097);
    rationalize = new ModuleMethod(localnumbers, 25, Lit27, 8194);
    exp = new ModuleMethod(localnumbers, 26, Lit28, 4097);
    log = new ModuleMethod(localnumbers, 27, Lit29, 4097);
    sin = new ModuleMethod(localnumbers, 28, Lit30, 4097);
    cos = new ModuleMethod(localnumbers, 29, Lit31, 4097);
    tan = new ModuleMethod(localnumbers, 30, Lit32, 4097);
    asin = new ModuleMethod(localnumbers, 31, Lit33, 4097);
    acos = new ModuleMethod(localnumbers, 32, Lit34, 4097);
    ModuleMethod localModuleMethod1 = new ModuleMethod(localnumbers, 33, null, 8194);
    localModuleMethod1.setProperty("source-location", "numbers.scm:146");
    lambda$Fn1 = localModuleMethod1;
    ModuleMethod localModuleMethod2 = new ModuleMethod(localnumbers, 34, null, 4097);
    localModuleMethod2.setProperty("source-location", "numbers.scm:148");
    lambda$Fn2 = localModuleMethod2;
    ModuleMethod localModuleMethod3 = new ModuleMethod(localnumbers, 35, null, 4097);
    localModuleMethod3.setProperty("source-location", "numbers.scm:152");
    lambda$Fn3 = localModuleMethod3;
    ModuleMethod localModuleMethod4 = new ModuleMethod(localnumbers, 36, null, 4097);
    localModuleMethod4.setProperty("source-location", "numbers.scm:156");
    lambda$Fn4 = localModuleMethod4;
    make$Mnrectangular = new ModuleMethod(localnumbers, 37, Lit35, 8194);
    make$Mnpolar = new ModuleMethod(localnumbers, 38, Lit36, 8194);
    real$Mnpart = new ModuleMethod(localnumbers, 39, Lit37, 4097);
    imag$Mnpart = new ModuleMethod(localnumbers, 40, Lit38, 4097);
    magnitude = new ModuleMethod(localnumbers, 41, Lit39, 4097);
    angle = new ModuleMethod(localnumbers, 42, Lit40, 4097);
    inexact = new ModuleMethod(localnumbers, 43, Lit41, 4097);
    exact = new ModuleMethod(localnumbers, 44, Lit42, 4097);
    exact$Mn$Grinexact = new ModuleMethod(localnumbers, 45, Lit43, 4097);
    inexact$Mn$Grexact = new ModuleMethod(localnumbers, 46, Lit44, 4097);
    logop = new ModuleMethod(localnumbers, 47, Lit45, 12291);
    bitwise$Mnbit$Mnset$Qu = new ModuleMethod(localnumbers, 48, Lit46, 8194);
    bitwise$Mncopy$Mnbit = new ModuleMethod(localnumbers, 49, Lit47, 12291);
    bitwise$Mncopy$Mnbit$Mnfield = new ModuleMethod(localnumbers, 50, Lit48, 16388);
    bitwise$Mnbit$Mnfield = new ModuleMethod(localnumbers, 51, Lit49, 12291);
    bitwise$Mnif = new ModuleMethod(localnumbers, 52, Lit50, 12291);
    logtest = new ModuleMethod(localnumbers, 53, Lit51, 8194);
    logcount = new ModuleMethod(localnumbers, 54, Lit52, 4097);
    bitwise$Mnbit$Mncount = new ModuleMethod(localnumbers, 55, Lit53, 4097);
    bitwise$Mnlength = new ModuleMethod(localnumbers, 56, Lit54, 4097);
    bitwise$Mnfirst$Mnbit$Mnset = new ModuleMethod(localnumbers, 57, Lit55, 4097);
    bitwise$Mnrotate$Mnbit$Mnfield = new ModuleMethod(localnumbers, 58, Lit56, 16388);
    bitwise$Mnreverse$Mnbit$Mnfield = new ModuleMethod(localnumbers, 59, Lit57, 12291);
    number$Mn$Grstring = new ModuleMethod(localnumbers, 60, Lit58, 8193);
    string$Mn$Grnumber = new ModuleMethod(localnumbers, 62, Lit59, 8193);
    quantity$Mn$Grnumber = new ModuleMethod(localnumbers, 64, Lit60, 4097);
    quantity$Mn$Grunit = new ModuleMethod(localnumbers, 65, Lit61, 4097);
    make$Mnquantity = new ModuleMethod(localnumbers, 66, Lit62, 8194);
    duration = new ModuleMethod(localnumbers, 67, Lit63, 4097);
    $instance.run();
  }

  public numbers()
  {
    ModuleInfo.register(this);
  }

  public static Number abs(Number paramNumber)
  {
    if ((paramNumber instanceof Numeric))
      return ((Numeric)paramNumber).abs();
    if (Scheme.numGEq.apply2(paramNumber, Lit0) != Boolean.FALSE)
      return paramNumber;
    return (Number)AddOp.$Mn.apply1(paramNumber);
  }

  public static double acos(double paramDouble)
  {
    return Math.acos(paramDouble);
  }

  public static RealNum angle(Complex paramComplex)
  {
    return paramComplex.angle();
  }

  public static double asin(double paramDouble)
  {
    return Math.asin(paramDouble);
  }

  public static int bitwiseBitCount(IntNum paramIntNum)
  {
    if (IntNum.compare(paramIntNum, 0L) >= 0)
      return BitOps.bitCount(paramIntNum);
    return -1 - BitOps.bitCount(BitOps.not(paramIntNum));
  }

  public static IntNum bitwiseBitField(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    return BitOps.extract(paramIntNum, paramInt1, paramInt2);
  }

  public static IntNum bitwiseCopyBit(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    return BitOps.setBitValue(paramIntNum, paramInt1, paramInt2);
  }

  public static IntNum bitwiseCopyBitField(IntNum paramIntNum1, int paramInt1, int paramInt2, IntNum paramIntNum2)
  {
    int i = IntNum.shift(-1, paramInt1);
    IntNum localIntNum = BitOps.not(IntNum.make(IntNum.shift(-1, paramInt2)));
    return bitwiseIf(BitOps.and(IntNum.make(i), localIntNum), IntNum.shift(paramIntNum2, paramInt1), paramIntNum1);
  }

  public static int bitwiseFirstBitSet(IntNum paramIntNum)
  {
    return BitOps.lowestBitSet(paramIntNum);
  }

  public static IntNum bitwiseIf(IntNum paramIntNum1, IntNum paramIntNum2, IntNum paramIntNum3)
  {
    return BitOps.ior(BitOps.and(paramIntNum1, paramIntNum2), BitOps.and(BitOps.not(paramIntNum1), paramIntNum3));
  }

  public static int bitwiseLength(IntNum paramIntNum)
  {
    return paramIntNum.intLength();
  }

  public static IntNum bitwiseReverseBitField(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    return BitOps.reverseBits(paramIntNum, paramInt1, paramInt2);
  }

  public static IntNum bitwiseRotateBitField(IntNum paramIntNum, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if (i > 0)
    {
      int j = paramInt3 % i;
      if (j < 0);
      for (int k = j + i; ; k = j)
      {
        IntNum localIntNum = bitwiseBitField(paramIntNum, paramInt1, paramInt2);
        return bitwiseCopyBitField(paramIntNum, paramInt1, paramInt2, BitOps.ior(IntNum.shift(localIntNum, k), IntNum.shift(localIntNum, k - i)));
      }
    }
    return paramIntNum;
  }

  public static RealNum ceiling(RealNum paramRealNum)
  {
    return paramRealNum.toInt(Numeric.CEILING);
  }

  public static double cos(double paramDouble)
  {
    return Math.cos(paramDouble);
  }

  public static IntNum denominator(RatNum paramRatNum)
  {
    return paramRatNum.denominator();
  }

  // ERROR //
  public static Object div0AndMod0(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    // Byte code:
    //   0: getstatic 690	gnu/kawa/functions/DivideOp:div0	Lgnu/kawa/functions/DivideOp;
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   13: astore 4
    //   15: getstatic 579	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   18: aload_0
    //   19: getstatic 702	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: astore 5
    //   33: aload 5
    //   35: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   38: astore 7
    //   40: iconst_2
    //   41: anewarray 704	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload 4
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload 7
    //   53: aastore
    //   54: invokestatic 710	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   57: areturn
    //   58: astore_3
    //   59: new 712	gnu/mapping/WrongType
    //   62: dup
    //   63: aload_3
    //   64: ldc_w 714
    //   67: bipush 254
    //   69: aload_2
    //   70: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: astore 6
    //   76: new 712	gnu/mapping/WrongType
    //   79: dup
    //   80: aload 6
    //   82: ldc_w 719
    //   85: bipush 254
    //   87: aload 5
    //   89: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   92: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	58	java/lang/ClassCastException
    //   33	40	74	java/lang/ClassCastException
  }

  // ERROR //
  public static Object divAndMod(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    // Byte code:
    //   0: getstatic 723	gnu/kawa/functions/DivideOp:div	Lgnu/kawa/functions/DivideOp;
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   13: astore 4
    //   15: getstatic 579	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   18: aload_0
    //   19: getstatic 702	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
    //   22: aload 4
    //   24: aload_1
    //   25: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: invokevirtual 567	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: astore 5
    //   33: aload 5
    //   35: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   38: astore 7
    //   40: iconst_2
    //   41: anewarray 704	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload 4
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload 7
    //   53: aastore
    //   54: invokestatic 710	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   57: areturn
    //   58: astore_3
    //   59: new 712	gnu/mapping/WrongType
    //   62: dup
    //   63: aload_3
    //   64: ldc_w 714
    //   67: bipush 254
    //   69: aload_2
    //   70: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: astore 6
    //   76: new 712	gnu/mapping/WrongType
    //   79: dup
    //   80: aload 6
    //   82: ldc_w 719
    //   85: bipush 254
    //   87: aload 5
    //   89: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   92: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	58	java/lang/ClassCastException
    //   33	40	74	java/lang/ClassCastException
  }

  public static Duration duration(Object paramObject)
  {
    if (paramObject == null);
    for (String str = null; ; str = paramObject.toString())
      return Duration.parseDuration(str);
  }

  public static Number exact(Number paramNumber)
  {
    return Arithmetic.toExact(paramNumber);
  }

  public static Number exact$To$Inexact(Number paramNumber)
  {
    return Arithmetic.toInexact(paramNumber);
  }

  public static Complex exp(Complex paramComplex)
  {
    return paramComplex.exp();
  }

  public static RealNum floor(RealNum paramRealNum)
  {
    return paramRealNum.toInt(Numeric.FLOOR);
  }

  public static IntNum gcd(IntNum[] paramArrayOfIntNum)
  {
    int i = paramArrayOfIntNum.length;
    if (i == 0)
      return Lit0;
    IntNum localIntNum = paramArrayOfIntNum[0];
    for (int j = 1; j < i; j++)
      localIntNum = IntNum.gcd(localIntNum, paramArrayOfIntNum[j]);
    return localIntNum;
  }

  public static RealNum imagPart(Complex paramComplex)
  {
    return paramComplex.im();
  }

  public static Number inexact(Number paramNumber)
  {
    return Arithmetic.toInexact(paramNumber);
  }

  public static Number inexact$To$Exact(Number paramNumber)
  {
    return Arithmetic.toExact(paramNumber);
  }

  public static boolean isBitwiseBitSet(IntNum paramIntNum, int paramInt)
  {
    return BitOps.bitValue(paramIntNum, paramInt);
  }

  public static boolean isComplex(Object paramObject)
  {
    return paramObject instanceof Complex;
  }

  public static boolean isExact(Object paramObject)
  {
    boolean bool = paramObject instanceof Number;
    if (bool)
      return Arithmetic.isExact((Number)paramObject);
    return bool;
  }

  public static boolean isInexact(Object paramObject)
  {
    boolean bool = paramObject instanceof Number;
    if (bool)
      return 0x1 & true + Arithmetic.isExact((Number)paramObject);
    return bool;
  }

  public static boolean isInteger(Object paramObject)
  {
    boolean bool1 = paramObject instanceof IntNum;
    if (bool1)
      return bool1;
    boolean bool2 = paramObject instanceof DFloNum;
    if (bool2);
    try
    {
      DFloNum localDFloNum = (DFloNum)paramObject;
      if (Math.IEEEremainder(localDFloNum.doubleValue(), 1.0D) == 0.0D);
      for (boolean bool7 = true; ; bool7 = false)
      {
        bool2 = bool7;
        if (!bool2)
          break;
        return bool2;
      }
      boolean bool3 = paramObject instanceof Number;
      if (bool3)
      {
        boolean bool4 = paramObject instanceof Long;
        if (bool4)
          return bool4;
        boolean bool5 = paramObject instanceof Integer;
        if (bool5)
          return bool5;
        boolean bool6 = paramObject instanceof Short;
        if (bool6)
          return bool6;
        return paramObject instanceof BigInteger;
      }
      return bool3;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.math.DFloNum.doubleValue()", 1, paramObject);
    }
  }

  public static boolean isNegative(RealNum paramRealNum)
  {
    return paramRealNum.isNegative();
  }

  public static boolean isNumber(Object paramObject)
  {
    return paramObject instanceof Number;
  }

  public static boolean isPositive(RealNum paramRealNum)
  {
    return paramRealNum.sign() > 0;
  }

  public static boolean isQuantity(Object paramObject)
  {
    return paramObject instanceof Quantity;
  }

  public static boolean isRational(Object paramObject)
  {
    return RatNum.asRatNumOrNull(paramObject) != null;
  }

  public static boolean isReal(Object paramObject)
  {
    return RealNum.asRealNumOrNull(paramObject) != null;
  }

  public static boolean isZero(Number paramNumber)
  {
    if ((paramNumber instanceof Numeric))
      return ((Numeric)paramNumber).isZero();
    if ((paramNumber instanceof BigInteger))
      return Scheme.numEqu.apply2(Lit0, GetNamedPart.getNamedPart.apply2((BigInteger)paramNumber, Lit1)) != Boolean.FALSE;
    if ((paramNumber instanceof BigDecimal))
      return Scheme.numEqu.apply2(Lit0, GetNamedPart.getNamedPart.apply2((BigDecimal)paramNumber, Lit1)) != Boolean.FALSE;
    return paramNumber.doubleValue() == 0.0D;
  }

  static double lambda1(double paramDouble1, double paramDouble2)
  {
    return Math.atan2(paramDouble1, paramDouble2);
  }

  static double lambda2(double paramDouble)
  {
    return Math.atan(paramDouble);
  }

  static Quantity lambda3(Quantity paramQuantity)
  {
    return Quantity.make(paramQuantity.number().sqrt(), paramQuantity.unit().sqrt());
  }

  static double lambda4(double paramDouble)
  {
    return Math.sqrt(paramDouble);
  }

  public static IntNum lcm(IntNum[] paramArrayOfIntNum)
  {
    int i = paramArrayOfIntNum.length;
    if (i == 0)
      return Lit2;
    IntNum localIntNum = IntNum.abs(paramArrayOfIntNum[0]);
    for (int j = 1; j < i; j++)
      localIntNum = IntNum.lcm(localIntNum, paramArrayOfIntNum[j]);
    return localIntNum;
  }

  public static Complex log(Complex paramComplex)
  {
    return paramComplex.log();
  }

  public static int logcount(IntNum paramIntNum)
  {
    if (IntNum.compare(paramIntNum, 0L) >= 0);
    for (IntNum localIntNum = paramIntNum; ; localIntNum = BitOps.not(paramIntNum))
      return BitOps.bitCount(localIntNum);
  }

  public static IntNum logop(int paramInt, IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return BitOps.bitOp(paramInt, paramIntNum1, paramIntNum2);
  }

  public static boolean logtest(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return BitOps.test(paramIntNum1, paramIntNum2);
  }

  public static Number magnitude(Number paramNumber)
  {
    return abs(paramNumber);
  }

  public static DComplex makePolar(double paramDouble1, double paramDouble2)
  {
    return Complex.polar(paramDouble1, paramDouble2);
  }

  // ERROR //
  public static Quantity makeQuantity(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 848
    //   4: ifeq +48 -> 52
    //   7: aload_1
    //   8: checkcast 848	gnu/math/Unit
    //   11: astore 7
    //   13: aload 7
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +57 -> 74
    //   20: new 881	java/lang/IllegalArgumentException
    //   23: dup
    //   24: iconst_0
    //   25: iconst_2
    //   26: anewarray 704	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: ldc_w 883
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload_1
    //   38: aastore
    //   39: invokestatic 889	gnu/kawa/functions/Format:formatToString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   42: invokevirtual 892	java/lang/String:toString	()Ljava/lang/String;
    //   45: invokespecial 893	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   48: checkcast 895	java/lang/Throwable
    //   51: athrow
    //   52: aload_1
    //   53: ifnonnull +13 -> 66
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: invokestatic 899	gnu/math/Unit:lookup	(Ljava/lang/String;)Lgnu/math/NamedUnit;
    //   62: astore_3
    //   63: goto -47 -> 16
    //   66: aload_1
    //   67: invokevirtual 734	java/lang/Object:toString	()Ljava/lang/String;
    //   70: astore_2
    //   71: goto -13 -> 58
    //   74: aload_0
    //   75: checkcast 593	gnu/math/Complex
    //   78: astore 5
    //   80: aload 5
    //   82: aload_3
    //   83: invokestatic 853	gnu/math/Quantity:make	(Lgnu/math/Complex;Lgnu/math/Unit;)Lgnu/math/Quantity;
    //   86: areturn
    //   87: astore 6
    //   89: new 712	gnu/mapping/WrongType
    //   92: dup
    //   93: aload 6
    //   95: ldc_w 901
    //   98: bipush 254
    //   100: aload_1
    //   101: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   104: athrow
    //   105: astore 4
    //   107: new 712	gnu/mapping/WrongType
    //   110: dup
    //   111: aload 4
    //   113: ldc_w 903
    //   116: iconst_1
    //   117: aload_0
    //   118: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   121: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   7	13	87	java/lang/ClassCastException
    //   74	80	105	java/lang/ClassCastException
  }

  public static Complex makeRectangular(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    return Complex.make(paramRealNum1, paramRealNum2);
  }

  // ERROR //
  public static Object max(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: istore_1
    //   3: aload_0
    //   4: iconst_0
    //   5: aaload
    //   6: astore_2
    //   7: aload_2
    //   8: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   11: astore 4
    //   13: aload 4
    //   15: astore 5
    //   17: iconst_1
    //   18: istore 6
    //   20: iload 6
    //   22: iload_1
    //   23: if_icmpge +65 -> 88
    //   26: aload_0
    //   27: iload 6
    //   29: aaload
    //   30: astore 7
    //   32: aload 7
    //   34: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   37: astore 9
    //   39: aload 5
    //   41: aload 9
    //   43: invokevirtual 909	gnu/math/RealNum:max	(Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   46: astore 5
    //   48: iinc 6 1
    //   51: goto -31 -> 20
    //   54: astore_3
    //   55: new 712	gnu/mapping/WrongType
    //   58: dup
    //   59: aload_3
    //   60: ldc_w 911
    //   63: bipush 254
    //   65: aload_2
    //   66: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   69: athrow
    //   70: astore 8
    //   72: new 712	gnu/mapping/WrongType
    //   75: dup
    //   76: aload 8
    //   78: ldc_w 913
    //   81: iconst_2
    //   82: aload 7
    //   84: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   87: athrow
    //   88: aload 5
    //   90: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   7	13	54	java/lang/ClassCastException
    //   32	39	70	java/lang/ClassCastException
  }

  // ERROR //
  public static Object min(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: istore_1
    //   3: aload_0
    //   4: iconst_0
    //   5: aaload
    //   6: astore_2
    //   7: aload_2
    //   8: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   11: astore 4
    //   13: aload 4
    //   15: astore 5
    //   17: iconst_0
    //   18: istore 6
    //   20: iload 6
    //   22: iload_1
    //   23: if_icmpge +65 -> 88
    //   26: aload_0
    //   27: iload 6
    //   29: aaload
    //   30: astore 7
    //   32: aload 7
    //   34: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   37: astore 9
    //   39: aload 5
    //   41: aload 9
    //   43: invokevirtual 915	gnu/math/RealNum:min	(Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   46: astore 5
    //   48: iinc 6 1
    //   51: goto -31 -> 20
    //   54: astore_3
    //   55: new 712	gnu/mapping/WrongType
    //   58: dup
    //   59: aload_3
    //   60: ldc_w 911
    //   63: bipush 254
    //   65: aload_2
    //   66: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   69: athrow
    //   70: astore 8
    //   72: new 712	gnu/mapping/WrongType
    //   75: dup
    //   76: aload 8
    //   78: ldc_w 917
    //   81: iconst_2
    //   82: aload 7
    //   84: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   87: athrow
    //   88: aload 5
    //   90: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   7	13	54	java/lang/ClassCastException
    //   32	39	70	java/lang/ClassCastException
  }

  public static CharSequence number$To$String(Number paramNumber)
  {
    return number$To$String(paramNumber, 10);
  }

  public static CharSequence number$To$String(Number paramNumber, int paramInt)
  {
    return new FString(Arithmetic.toString(paramNumber, paramInt));
  }

  public static IntNum numerator(RatNum paramRatNum)
  {
    return paramRatNum.numerator();
  }

  public static Complex quantity$To$Number(Quantity paramQuantity)
  {
    paramQuantity.unit();
    if (paramQuantity.doubleValue() == 1.0D)
      return paramQuantity.number();
    return Complex.make(paramQuantity.reValue(), paramQuantity.imValue());
  }

  public static Unit quantity$To$Unit(Quantity paramQuantity)
  {
    return paramQuantity.unit();
  }

  public static RealNum rationalize(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    return RatNum.rationalize(LangObjType.coerceRealNum(paramRealNum1.sub(paramRealNum2)), LangObjType.coerceRealNum(paramRealNum1.add(paramRealNum2)));
  }

  public static RealNum realPart(Complex paramComplex)
  {
    return paramComplex.re();
  }

  public static RealNum round(RealNum paramRealNum)
  {
    return paramRealNum.toInt(Numeric.ROUND);
  }

  public static double sin(double paramDouble)
  {
    return Math.sin(paramDouble);
  }

  public static Object string$To$Number(CharSequence paramCharSequence)
  {
    return string$To$Number(paramCharSequence, 10);
  }

  public static Object string$To$Number(CharSequence paramCharSequence, int paramInt)
  {
    Object localObject = LispReader.parseNumber(paramCharSequence, paramInt);
    if ((localObject instanceof Numeric))
      return localObject;
    return Boolean.FALSE;
  }

  public static double tan(double paramDouble)
  {
    return Math.tan(paramDouble);
  }

  public static RealNum truncate(RealNum paramRealNum)
  {
    return paramRealNum.toInt(Numeric.TRUNCATE);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 984	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+284 -> 288, 1:+291->295, 2:+306->310, 3:+321->325, 4:+336->340, 5:+351->355, 6:+366->370, 7:+381->385, 8:+396->400, 9:+411->415, 10:+433->437, 11:+455->459, 12:+284->288, 13:+284->288, 14:+477->481, 15:+284->288, 16:+284->288, 17:+284->288, 18:+284->288, 19:+489->493, 20:+501->505, 21:+513->517, 22:+525->529, 23:+537->541, 24:+549->553, 25:+284->288, 26:+561->565, 27:+573->577, 28:+585->589, 29:+603->607, 30:+621->625, 31:+639->643, 32:+657->661, 33:+284->288, 34:+675->679, 35:+693->697, 36:+705->709, 37:+284->288, 38:+284->288, 39:+723->727, 40:+735->739, 41:+747->751, 42:+759->763, 43:+771->775, 44:+783->787, 45:+795->799, 46:+807->811, 47:+284->288, 48:+284->288, 49:+284->288, 50:+284->288, 51:+284->288, 52:+284->288, 53:+284->288, 54:+819->823, 55:+834->838, 56:+849->853, 57:+864->868, 58:+284->288, 59:+284->288, 60:+879->883, 61:+284->288, 62:+891->895, 63:+284->288, 64:+903->907, 65:+915->919, 66:+284->288, 67:+927->931
    //   289: aload_1
    //   290: aload_2
    //   291: invokespecial 986	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   294: areturn
    //   295: aload_2
    //   296: invokestatic 988	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
    //   299: ifeq +7 -> 306
    //   302: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   305: areturn
    //   306: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   309: areturn
    //   310: aload_2
    //   311: invokestatic 993	kawa/lib/numbers:isQuantity	(Ljava/lang/Object;)Z
    //   314: ifeq +7 -> 321
    //   317: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   320: areturn
    //   321: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   324: areturn
    //   325: aload_2
    //   326: invokestatic 995	kawa/lib/numbers:isComplex	(Ljava/lang/Object;)Z
    //   329: ifeq +7 -> 336
    //   332: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   335: areturn
    //   336: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   339: areturn
    //   340: aload_2
    //   341: invokestatic 997	kawa/lib/numbers:isReal	(Ljava/lang/Object;)Z
    //   344: ifeq +7 -> 351
    //   347: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   350: areturn
    //   351: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   354: areturn
    //   355: aload_2
    //   356: invokestatic 999	kawa/lib/numbers:isRational	(Ljava/lang/Object;)Z
    //   359: ifeq +7 -> 366
    //   362: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   365: areturn
    //   366: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   369: areturn
    //   370: aload_2
    //   371: invokestatic 1001	kawa/lib/numbers:isInteger	(Ljava/lang/Object;)Z
    //   374: ifeq +7 -> 381
    //   377: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   380: areturn
    //   381: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   384: areturn
    //   385: aload_2
    //   386: invokestatic 1003	kawa/lib/numbers:isExact	(Ljava/lang/Object;)Z
    //   389: ifeq +7 -> 396
    //   392: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   395: areturn
    //   396: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   399: areturn
    //   400: aload_2
    //   401: invokestatic 1005	kawa/lib/numbers:isInexact	(Ljava/lang/Object;)Z
    //   404: ifeq +7 -> 411
    //   407: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   410: areturn
    //   411: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   414: areturn
    //   415: aload_2
    //   416: checkcast 585	java/lang/Number
    //   419: astore 81
    //   421: aload 81
    //   423: invokestatic 1007	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   426: ifeq +7 -> 433
    //   429: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   432: areturn
    //   433: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   436: areturn
    //   437: aload_2
    //   438: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   441: astore 79
    //   443: aload 79
    //   445: invokestatic 1009	kawa/lib/numbers:isPositive	(Lgnu/math/RealNum;)Z
    //   448: ifeq +7 -> 455
    //   451: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   454: areturn
    //   455: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   458: areturn
    //   459: aload_2
    //   460: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   463: astore 77
    //   465: aload 77
    //   467: invokestatic 1011	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   470: ifeq +7 -> 477
    //   473: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   476: areturn
    //   477: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   480: areturn
    //   481: aload_2
    //   482: checkcast 585	java/lang/Number
    //   485: astore 75
    //   487: aload 75
    //   489: invokestatic 872	kawa/lib/numbers:abs	(Ljava/lang/Number;)Ljava/lang/Number;
    //   492: areturn
    //   493: aload_2
    //   494: invokestatic 1014	gnu/kawa/lispexpr/LangObjType:coerceRatNum	(Ljava/lang/Object;)Lgnu/math/RatNum;
    //   497: astore 73
    //   499: aload 73
    //   501: invokestatic 1016	kawa/lib/numbers:numerator	(Lgnu/math/RatNum;)Lgnu/math/IntNum;
    //   504: areturn
    //   505: aload_2
    //   506: invokestatic 1014	gnu/kawa/lispexpr/LangObjType:coerceRatNum	(Ljava/lang/Object;)Lgnu/math/RatNum;
    //   509: astore 71
    //   511: aload 71
    //   513: invokestatic 1018	kawa/lib/numbers:denominator	(Lgnu/math/RatNum;)Lgnu/math/IntNum;
    //   516: areturn
    //   517: aload_2
    //   518: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   521: astore 69
    //   523: aload 69
    //   525: invokestatic 1020	kawa/lib/numbers:floor	(Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   528: areturn
    //   529: aload_2
    //   530: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   533: astore 67
    //   535: aload 67
    //   537: invokestatic 1022	kawa/lib/numbers:ceiling	(Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   540: areturn
    //   541: aload_2
    //   542: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   545: astore 65
    //   547: aload 65
    //   549: invokestatic 1024	kawa/lib/numbers:truncate	(Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   552: areturn
    //   553: aload_2
    //   554: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   557: astore 63
    //   559: aload 63
    //   561: invokestatic 1026	kawa/lib/numbers:round	(Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   564: areturn
    //   565: aload_2
    //   566: checkcast 593	gnu/math/Complex
    //   569: astore 61
    //   571: aload 61
    //   573: invokestatic 1028	kawa/lib/numbers:exp	(Lgnu/math/Complex;)Lgnu/math/Complex;
    //   576: areturn
    //   577: aload_2
    //   578: checkcast 593	gnu/math/Complex
    //   581: astore 59
    //   583: aload 59
    //   585: invokestatic 1030	kawa/lib/numbers:log	(Lgnu/math/Complex;)Lgnu/math/Complex;
    //   588: areturn
    //   589: aload_2
    //   590: checkcast 585	java/lang/Number
    //   593: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   596: dstore 56
    //   598: dload 56
    //   600: invokestatic 1031	kawa/lib/numbers:sin	(D)D
    //   603: invokestatic 1037	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   606: areturn
    //   607: aload_2
    //   608: checkcast 585	java/lang/Number
    //   611: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   614: dstore 53
    //   616: dload 53
    //   618: invokestatic 1038	kawa/lib/numbers:cos	(D)D
    //   621: invokestatic 1037	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   624: areturn
    //   625: aload_2
    //   626: checkcast 585	java/lang/Number
    //   629: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   632: dstore 50
    //   634: dload 50
    //   636: invokestatic 1039	kawa/lib/numbers:tan	(D)D
    //   639: invokestatic 1037	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   642: areturn
    //   643: aload_2
    //   644: checkcast 585	java/lang/Number
    //   647: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   650: dstore 47
    //   652: dload 47
    //   654: invokestatic 1040	kawa/lib/numbers:asin	(D)D
    //   657: invokestatic 1037	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   660: areturn
    //   661: aload_2
    //   662: checkcast 585	java/lang/Number
    //   665: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   668: dstore 44
    //   670: dload 44
    //   672: invokestatic 1041	kawa/lib/numbers:acos	(D)D
    //   675: invokestatic 1037	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   678: areturn
    //   679: aload_2
    //   680: checkcast 585	java/lang/Number
    //   683: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   686: dstore 41
    //   688: dload 41
    //   690: invokestatic 1043	kawa/lib/numbers:lambda2	(D)D
    //   693: invokestatic 1037	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   696: areturn
    //   697: aload_2
    //   698: checkcast 804	gnu/math/Quantity
    //   701: astore 39
    //   703: aload 39
    //   705: invokestatic 1045	kawa/lib/numbers:lambda3	(Lgnu/math/Quantity;)Lgnu/math/Quantity;
    //   708: areturn
    //   709: aload_2
    //   710: checkcast 585	java/lang/Number
    //   713: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   716: dstore 36
    //   718: dload 36
    //   720: invokestatic 1047	kawa/lib/numbers:lambda4	(D)D
    //   723: invokestatic 1037	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   726: areturn
    //   727: aload_2
    //   728: checkcast 593	gnu/math/Complex
    //   731: astore 34
    //   733: aload 34
    //   735: invokestatic 1049	kawa/lib/numbers:realPart	(Lgnu/math/Complex;)Lgnu/math/RealNum;
    //   738: areturn
    //   739: aload_2
    //   740: checkcast 593	gnu/math/Complex
    //   743: astore 32
    //   745: aload 32
    //   747: invokestatic 1051	kawa/lib/numbers:imagPart	(Lgnu/math/Complex;)Lgnu/math/RealNum;
    //   750: areturn
    //   751: aload_2
    //   752: checkcast 585	java/lang/Number
    //   755: astore 30
    //   757: aload 30
    //   759: invokestatic 1053	kawa/lib/numbers:magnitude	(Ljava/lang/Number;)Ljava/lang/Number;
    //   762: areturn
    //   763: aload_2
    //   764: checkcast 593	gnu/math/Complex
    //   767: astore 28
    //   769: aload 28
    //   771: invokestatic 1055	kawa/lib/numbers:angle	(Lgnu/math/Complex;)Lgnu/math/RealNum;
    //   774: areturn
    //   775: aload_2
    //   776: checkcast 585	java/lang/Number
    //   779: astore 26
    //   781: aload 26
    //   783: invokestatic 1057	kawa/lib/numbers:inexact	(Ljava/lang/Number;)Ljava/lang/Number;
    //   786: areturn
    //   787: aload_2
    //   788: checkcast 585	java/lang/Number
    //   791: astore 24
    //   793: aload 24
    //   795: invokestatic 1059	kawa/lib/numbers:exact	(Ljava/lang/Number;)Ljava/lang/Number;
    //   798: areturn
    //   799: aload_2
    //   800: checkcast 585	java/lang/Number
    //   803: astore 22
    //   805: aload 22
    //   807: invokestatic 1061	kawa/lib/numbers:exact$To$Inexact	(Ljava/lang/Number;)Ljava/lang/Number;
    //   810: areturn
    //   811: aload_2
    //   812: checkcast 585	java/lang/Number
    //   815: astore 20
    //   817: aload 20
    //   819: invokestatic 1063	kawa/lib/numbers:inexact$To$Exact	(Ljava/lang/Number;)Ljava/lang/Number;
    //   822: areturn
    //   823: aload_2
    //   824: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   827: astore 18
    //   829: aload 18
    //   831: invokestatic 1069	kawa/lib/numbers:logcount	(Lgnu/math/IntNum;)I
    //   834: invokestatic 1072	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   837: areturn
    //   838: aload_2
    //   839: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   842: astore 16
    //   844: aload 16
    //   846: invokestatic 1074	kawa/lib/numbers:bitwiseBitCount	(Lgnu/math/IntNum;)I
    //   849: invokestatic 1072	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   852: areturn
    //   853: aload_2
    //   854: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   857: astore 14
    //   859: aload 14
    //   861: invokestatic 1076	kawa/lib/numbers:bitwiseLength	(Lgnu/math/IntNum;)I
    //   864: invokestatic 1072	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   867: areturn
    //   868: aload_2
    //   869: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   872: astore 12
    //   874: aload 12
    //   876: invokestatic 1078	kawa/lib/numbers:bitwiseFirstBitSet	(Lgnu/math/IntNum;)I
    //   879: invokestatic 1072	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   882: areturn
    //   883: aload_2
    //   884: checkcast 585	java/lang/Number
    //   887: astore 10
    //   889: aload 10
    //   891: invokestatic 1080	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   894: areturn
    //   895: aload_2
    //   896: checkcast 1082	java/lang/CharSequence
    //   899: astore 8
    //   901: aload 8
    //   903: invokestatic 1084	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   906: areturn
    //   907: aload_2
    //   908: checkcast 804	gnu/math/Quantity
    //   911: astore 6
    //   913: aload 6
    //   915: invokestatic 1086	kawa/lib/numbers:quantity$To$Number	(Lgnu/math/Quantity;)Lgnu/math/Complex;
    //   918: areturn
    //   919: aload_2
    //   920: checkcast 804	gnu/math/Quantity
    //   923: astore 4
    //   925: aload 4
    //   927: invokestatic 1088	kawa/lib/numbers:quantity$To$Unit	(Lgnu/math/Quantity;)Lgnu/math/Unit;
    //   930: areturn
    //   931: aload_2
    //   932: invokestatic 1090	kawa/lib/numbers:duration	(Ljava/lang/Object;)Lgnu/math/Duration;
    //   935: areturn
    //   936: astore 80
    //   938: new 712	gnu/mapping/WrongType
    //   941: dup
    //   942: aload 80
    //   944: ldc_w 336
    //   947: iconst_1
    //   948: aload_2
    //   949: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   952: athrow
    //   953: astore 78
    //   955: new 712	gnu/mapping/WrongType
    //   958: dup
    //   959: aload 78
    //   961: ldc_w 332
    //   964: iconst_1
    //   965: aload_2
    //   966: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   969: athrow
    //   970: astore 76
    //   972: new 712	gnu/mapping/WrongType
    //   975: dup
    //   976: aload 76
    //   978: ldc_w 328
    //   981: iconst_1
    //   982: aload_2
    //   983: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   986: athrow
    //   987: astore 74
    //   989: new 712	gnu/mapping/WrongType
    //   992: dup
    //   993: aload 74
    //   995: ldc_w 318
    //   998: iconst_1
    //   999: aload_2
    //   1000: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1003: athrow
    //   1004: astore 72
    //   1006: new 712	gnu/mapping/WrongType
    //   1009: dup
    //   1010: aload 72
    //   1012: ldc_w 301
    //   1015: iconst_1
    //   1016: aload_2
    //   1017: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1020: athrow
    //   1021: astore 70
    //   1023: new 712	gnu/mapping/WrongType
    //   1026: dup
    //   1027: aload 70
    //   1029: ldc_w 298
    //   1032: iconst_1
    //   1033: aload_2
    //   1034: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1037: athrow
    //   1038: astore 68
    //   1040: new 712	gnu/mapping/WrongType
    //   1043: dup
    //   1044: aload 68
    //   1046: ldc_w 295
    //   1049: iconst_1
    //   1050: aload_2
    //   1051: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1054: athrow
    //   1055: astore 66
    //   1057: new 712	gnu/mapping/WrongType
    //   1060: dup
    //   1061: aload 66
    //   1063: ldc_w 292
    //   1066: iconst_1
    //   1067: aload_2
    //   1068: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1071: athrow
    //   1072: astore 64
    //   1074: new 712	gnu/mapping/WrongType
    //   1077: dup
    //   1078: aload 64
    //   1080: ldc_w 289
    //   1083: iconst_1
    //   1084: aload_2
    //   1085: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1088: athrow
    //   1089: astore 62
    //   1091: new 712	gnu/mapping/WrongType
    //   1094: dup
    //   1095: aload 62
    //   1097: ldc_w 286
    //   1100: iconst_1
    //   1101: aload_2
    //   1102: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1105: athrow
    //   1106: astore 60
    //   1108: new 712	gnu/mapping/WrongType
    //   1111: dup
    //   1112: aload 60
    //   1114: ldc_w 280
    //   1117: iconst_1
    //   1118: aload_2
    //   1119: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1122: athrow
    //   1123: astore 58
    //   1125: new 712	gnu/mapping/WrongType
    //   1128: dup
    //   1129: aload 58
    //   1131: ldc_w 277
    //   1134: iconst_1
    //   1135: aload_2
    //   1136: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1139: athrow
    //   1140: astore 55
    //   1142: new 712	gnu/mapping/WrongType
    //   1145: dup
    //   1146: aload 55
    //   1148: ldc_w 274
    //   1151: iconst_1
    //   1152: aload_2
    //   1153: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1156: athrow
    //   1157: astore 52
    //   1159: new 712	gnu/mapping/WrongType
    //   1162: dup
    //   1163: aload 52
    //   1165: ldc_w 271
    //   1168: iconst_1
    //   1169: aload_2
    //   1170: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1173: athrow
    //   1174: astore 49
    //   1176: new 712	gnu/mapping/WrongType
    //   1179: dup
    //   1180: aload 49
    //   1182: ldc_w 268
    //   1185: iconst_1
    //   1186: aload_2
    //   1187: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1190: athrow
    //   1191: astore 46
    //   1193: new 712	gnu/mapping/WrongType
    //   1196: dup
    //   1197: aload 46
    //   1199: ldc_w 265
    //   1202: iconst_1
    //   1203: aload_2
    //   1204: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1207: athrow
    //   1208: astore 43
    //   1210: new 712	gnu/mapping/WrongType
    //   1213: dup
    //   1214: aload 43
    //   1216: ldc_w 262
    //   1219: iconst_1
    //   1220: aload_2
    //   1221: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1224: athrow
    //   1225: astore 40
    //   1227: new 712	gnu/mapping/WrongType
    //   1230: dup
    //   1231: aload 40
    //   1233: ldc_w 1092
    //   1236: iconst_1
    //   1237: aload_2
    //   1238: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1241: athrow
    //   1242: astore 38
    //   1244: new 712	gnu/mapping/WrongType
    //   1247: dup
    //   1248: aload 38
    //   1250: ldc_w 1092
    //   1253: iconst_1
    //   1254: aload_2
    //   1255: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1258: athrow
    //   1259: astore 35
    //   1261: new 712	gnu/mapping/WrongType
    //   1264: dup
    //   1265: aload 35
    //   1267: ldc_w 1092
    //   1270: iconst_1
    //   1271: aload_2
    //   1272: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1275: athrow
    //   1276: astore 33
    //   1278: new 712	gnu/mapping/WrongType
    //   1281: dup
    //   1282: aload 33
    //   1284: ldc 251
    //   1286: iconst_1
    //   1287: aload_2
    //   1288: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1291: athrow
    //   1292: astore 31
    //   1294: new 712	gnu/mapping/WrongType
    //   1297: dup
    //   1298: aload 31
    //   1300: ldc 247
    //   1302: iconst_1
    //   1303: aload_2
    //   1304: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1307: athrow
    //   1308: astore 29
    //   1310: new 712	gnu/mapping/WrongType
    //   1313: dup
    //   1314: aload 29
    //   1316: ldc 243
    //   1318: iconst_1
    //   1319: aload_2
    //   1320: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1323: athrow
    //   1324: astore 27
    //   1326: new 712	gnu/mapping/WrongType
    //   1329: dup
    //   1330: aload 27
    //   1332: ldc 240
    //   1334: iconst_1
    //   1335: aload_2
    //   1336: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1339: athrow
    //   1340: astore 25
    //   1342: new 712	gnu/mapping/WrongType
    //   1345: dup
    //   1346: aload 25
    //   1348: ldc 237
    //   1350: iconst_1
    //   1351: aload_2
    //   1352: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1355: athrow
    //   1356: astore 23
    //   1358: new 712	gnu/mapping/WrongType
    //   1361: dup
    //   1362: aload 23
    //   1364: ldc 234
    //   1366: iconst_1
    //   1367: aload_2
    //   1368: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1371: athrow
    //   1372: astore 21
    //   1374: new 712	gnu/mapping/WrongType
    //   1377: dup
    //   1378: aload 21
    //   1380: ldc 231
    //   1382: iconst_1
    //   1383: aload_2
    //   1384: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1387: athrow
    //   1388: astore 19
    //   1390: new 712	gnu/mapping/WrongType
    //   1393: dup
    //   1394: aload 19
    //   1396: ldc 227
    //   1398: iconst_1
    //   1399: aload_2
    //   1400: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1403: athrow
    //   1404: astore 17
    //   1406: new 712	gnu/mapping/WrongType
    //   1409: dup
    //   1410: aload 17
    //   1412: ldc 197
    //   1414: iconst_1
    //   1415: aload_2
    //   1416: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1419: athrow
    //   1420: astore 15
    //   1422: new 712	gnu/mapping/WrongType
    //   1425: dup
    //   1426: aload 15
    //   1428: ldc 194
    //   1430: iconst_1
    //   1431: aload_2
    //   1432: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1435: athrow
    //   1436: astore 13
    //   1438: new 712	gnu/mapping/WrongType
    //   1441: dup
    //   1442: aload 13
    //   1444: ldc 190
    //   1446: iconst_1
    //   1447: aload_2
    //   1448: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1451: athrow
    //   1452: astore 11
    //   1454: new 712	gnu/mapping/WrongType
    //   1457: dup
    //   1458: aload 11
    //   1460: ldc 186
    //   1462: iconst_1
    //   1463: aload_2
    //   1464: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1467: athrow
    //   1468: astore 9
    //   1470: new 712	gnu/mapping/WrongType
    //   1473: dup
    //   1474: aload 9
    //   1476: ldc 174
    //   1478: iconst_1
    //   1479: aload_2
    //   1480: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1483: athrow
    //   1484: astore 7
    //   1486: new 712	gnu/mapping/WrongType
    //   1489: dup
    //   1490: aload 7
    //   1492: ldc 170
    //   1494: iconst_1
    //   1495: aload_2
    //   1496: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1499: athrow
    //   1500: astore 5
    //   1502: new 712	gnu/mapping/WrongType
    //   1505: dup
    //   1506: aload 5
    //   1508: ldc 166
    //   1510: iconst_1
    //   1511: aload_2
    //   1512: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1515: athrow
    //   1516: astore_3
    //   1517: new 712	gnu/mapping/WrongType
    //   1520: dup
    //   1521: aload_3
    //   1522: ldc 162
    //   1524: iconst_1
    //   1525: aload_2
    //   1526: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1529: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   415	421	936	java/lang/ClassCastException
    //   437	443	953	java/lang/ClassCastException
    //   459	465	970	java/lang/ClassCastException
    //   481	487	987	java/lang/ClassCastException
    //   493	499	1004	java/lang/ClassCastException
    //   505	511	1021	java/lang/ClassCastException
    //   517	523	1038	java/lang/ClassCastException
    //   529	535	1055	java/lang/ClassCastException
    //   541	547	1072	java/lang/ClassCastException
    //   553	559	1089	java/lang/ClassCastException
    //   565	571	1106	java/lang/ClassCastException
    //   577	583	1123	java/lang/ClassCastException
    //   589	598	1140	java/lang/ClassCastException
    //   607	616	1157	java/lang/ClassCastException
    //   625	634	1174	java/lang/ClassCastException
    //   643	652	1191	java/lang/ClassCastException
    //   661	670	1208	java/lang/ClassCastException
    //   679	688	1225	java/lang/ClassCastException
    //   697	703	1242	java/lang/ClassCastException
    //   709	718	1259	java/lang/ClassCastException
    //   727	733	1276	java/lang/ClassCastException
    //   739	745	1292	java/lang/ClassCastException
    //   751	757	1308	java/lang/ClassCastException
    //   763	769	1324	java/lang/ClassCastException
    //   775	781	1340	java/lang/ClassCastException
    //   787	793	1356	java/lang/ClassCastException
    //   799	805	1372	java/lang/ClassCastException
    //   811	817	1388	java/lang/ClassCastException
    //   823	829	1404	java/lang/ClassCastException
    //   838	844	1420	java/lang/ClassCastException
    //   853	859	1436	java/lang/ClassCastException
    //   868	874	1452	java/lang/ClassCastException
    //   883	889	1468	java/lang/ClassCastException
    //   895	901	1484	java/lang/ClassCastException
    //   907	913	1500	java/lang/ClassCastException
    //   919	925	1516	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 984	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+100->104, 15:+108->112, 16:+128->132, 25:+148->152, 33:+168->172, 37:+197->201, 38:+217->221, 48:+243->247, 53:+276->280, 60:+306->310, 62:+329->333, 66:+352->356
    //   105: aload_1
    //   106: aload_2
    //   107: aload_3
    //   108: invokespecial 1095	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: areturn
    //   112: aload_2
    //   113: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   116: astore 45
    //   118: aload_3
    //   119: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   122: astore 47
    //   124: aload 45
    //   126: aload 47
    //   128: invokestatic 1097	kawa/lib/numbers:divAndMod	(Lgnu/math/RealNum;Lgnu/math/RealNum;)Ljava/lang/Object;
    //   131: areturn
    //   132: aload_2
    //   133: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   136: astore 41
    //   138: aload_3
    //   139: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   142: astore 43
    //   144: aload 41
    //   146: aload 43
    //   148: invokestatic 1099	kawa/lib/numbers:div0AndMod0	(Lgnu/math/RealNum;Lgnu/math/RealNum;)Ljava/lang/Object;
    //   151: areturn
    //   152: aload_2
    //   153: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   156: astore 37
    //   158: aload_3
    //   159: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   162: astore 39
    //   164: aload 37
    //   166: aload 39
    //   168: invokestatic 1100	kawa/lib/numbers:rationalize	(Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/RealNum;
    //   171: areturn
    //   172: aload_2
    //   173: checkcast 585	java/lang/Number
    //   176: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   179: dstore 31
    //   181: aload_3
    //   182: checkcast 585	java/lang/Number
    //   185: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   188: dstore 34
    //   190: dload 31
    //   192: dload 34
    //   194: invokestatic 1102	kawa/lib/numbers:lambda1	(DD)D
    //   197: invokestatic 1037	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   200: areturn
    //   201: aload_2
    //   202: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   205: astore 27
    //   207: aload_3
    //   208: invokestatic 696	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   211: astore 29
    //   213: aload 27
    //   215: aload 29
    //   217: invokestatic 1104	kawa/lib/numbers:makeRectangular	(Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Complex;
    //   220: areturn
    //   221: aload_2
    //   222: checkcast 585	java/lang/Number
    //   225: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   228: dstore 21
    //   230: aload_3
    //   231: checkcast 585	java/lang/Number
    //   234: invokevirtual 828	java/lang/Number:doubleValue	()D
    //   237: dstore 24
    //   239: dload 21
    //   241: dload 24
    //   243: invokestatic 1106	kawa/lib/numbers:makePolar	(DD)Lgnu/math/DComplex;
    //   246: areturn
    //   247: aload_2
    //   248: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   251: astore 17
    //   253: aload_3
    //   254: checkcast 585	java/lang/Number
    //   257: invokevirtual 1109	java/lang/Number:intValue	()I
    //   260: istore 19
    //   262: aload 17
    //   264: iload 19
    //   266: invokestatic 1111	kawa/lib/numbers:isBitwiseBitSet	(Lgnu/math/IntNum;I)Z
    //   269: ifeq +7 -> 276
    //   272: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   275: areturn
    //   276: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   279: areturn
    //   280: aload_2
    //   281: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   284: astore 13
    //   286: aload_3
    //   287: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   290: astore 15
    //   292: aload 13
    //   294: aload 15
    //   296: invokestatic 1113	kawa/lib/numbers:logtest	(Lgnu/math/IntNum;Lgnu/math/IntNum;)Z
    //   299: ifeq +7 -> 306
    //   302: getstatic 991	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   305: areturn
    //   306: getstatic 573	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   309: areturn
    //   310: aload_2
    //   311: checkcast 585	java/lang/Number
    //   314: astore 9
    //   316: aload_3
    //   317: checkcast 585	java/lang/Number
    //   320: invokevirtual 1109	java/lang/Number:intValue	()I
    //   323: istore 11
    //   325: aload 9
    //   327: iload 11
    //   329: invokestatic 922	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
    //   332: areturn
    //   333: aload_2
    //   334: checkcast 1082	java/lang/CharSequence
    //   337: astore 5
    //   339: aload_3
    //   340: checkcast 585	java/lang/Number
    //   343: invokevirtual 1109	java/lang/Number:intValue	()I
    //   346: istore 7
    //   348: aload 5
    //   350: iload 7
    //   352: invokestatic 970	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;I)Ljava/lang/Object;
    //   355: areturn
    //   356: aload_2
    //   357: aload_3
    //   358: invokestatic 1115	kawa/lib/numbers:makeQuantity	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/math/Quantity;
    //   361: areturn
    //   362: astore 44
    //   364: new 712	gnu/mapping/WrongType
    //   367: dup
    //   368: aload 44
    //   370: ldc_w 315
    //   373: iconst_1
    //   374: aload_2
    //   375: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   378: athrow
    //   379: astore 46
    //   381: new 712	gnu/mapping/WrongType
    //   384: dup
    //   385: aload 46
    //   387: ldc_w 315
    //   390: iconst_2
    //   391: aload_3
    //   392: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   395: athrow
    //   396: astore 40
    //   398: new 712	gnu/mapping/WrongType
    //   401: dup
    //   402: aload 40
    //   404: ldc_w 311
    //   407: iconst_1
    //   408: aload_2
    //   409: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   412: athrow
    //   413: astore 42
    //   415: new 712	gnu/mapping/WrongType
    //   418: dup
    //   419: aload 42
    //   421: ldc_w 311
    //   424: iconst_2
    //   425: aload_3
    //   426: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   429: athrow
    //   430: astore 36
    //   432: new 712	gnu/mapping/WrongType
    //   435: dup
    //   436: aload 36
    //   438: ldc_w 283
    //   441: iconst_1
    //   442: aload_2
    //   443: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   446: athrow
    //   447: astore 38
    //   449: new 712	gnu/mapping/WrongType
    //   452: dup
    //   453: aload 38
    //   455: ldc_w 283
    //   458: iconst_2
    //   459: aload_3
    //   460: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   463: athrow
    //   464: astore 30
    //   466: new 712	gnu/mapping/WrongType
    //   469: dup
    //   470: aload 30
    //   472: ldc_w 1092
    //   475: iconst_1
    //   476: aload_2
    //   477: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   480: athrow
    //   481: astore 33
    //   483: new 712	gnu/mapping/WrongType
    //   486: dup
    //   487: aload 33
    //   489: ldc_w 1092
    //   492: iconst_2
    //   493: aload_3
    //   494: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   497: athrow
    //   498: astore 26
    //   500: new 712	gnu/mapping/WrongType
    //   503: dup
    //   504: aload 26
    //   506: ldc_w 259
    //   509: iconst_1
    //   510: aload_2
    //   511: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   514: athrow
    //   515: astore 28
    //   517: new 712	gnu/mapping/WrongType
    //   520: dup
    //   521: aload 28
    //   523: ldc_w 259
    //   526: iconst_2
    //   527: aload_3
    //   528: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   531: athrow
    //   532: astore 20
    //   534: new 712	gnu/mapping/WrongType
    //   537: dup
    //   538: aload 20
    //   540: ldc 255
    //   542: iconst_1
    //   543: aload_2
    //   544: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   547: athrow
    //   548: astore 23
    //   550: new 712	gnu/mapping/WrongType
    //   553: dup
    //   554: aload 23
    //   556: ldc 255
    //   558: iconst_2
    //   559: aload_3
    //   560: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   563: athrow
    //   564: astore 16
    //   566: new 712	gnu/mapping/WrongType
    //   569: dup
    //   570: aload 16
    //   572: ldc 220
    //   574: iconst_1
    //   575: aload_2
    //   576: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   579: athrow
    //   580: astore 18
    //   582: new 712	gnu/mapping/WrongType
    //   585: dup
    //   586: aload 18
    //   588: ldc 220
    //   590: iconst_2
    //   591: aload_3
    //   592: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   595: athrow
    //   596: astore 12
    //   598: new 712	gnu/mapping/WrongType
    //   601: dup
    //   602: aload 12
    //   604: ldc 200
    //   606: iconst_1
    //   607: aload_2
    //   608: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   611: athrow
    //   612: astore 14
    //   614: new 712	gnu/mapping/WrongType
    //   617: dup
    //   618: aload 14
    //   620: ldc 200
    //   622: iconst_2
    //   623: aload_3
    //   624: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   627: athrow
    //   628: astore 8
    //   630: new 712	gnu/mapping/WrongType
    //   633: dup
    //   634: aload 8
    //   636: ldc 174
    //   638: iconst_1
    //   639: aload_2
    //   640: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   643: athrow
    //   644: astore 10
    //   646: new 712	gnu/mapping/WrongType
    //   649: dup
    //   650: aload 10
    //   652: ldc 174
    //   654: iconst_2
    //   655: aload_3
    //   656: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   659: athrow
    //   660: astore 4
    //   662: new 712	gnu/mapping/WrongType
    //   665: dup
    //   666: aload 4
    //   668: ldc 170
    //   670: iconst_1
    //   671: aload_2
    //   672: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   675: athrow
    //   676: astore 6
    //   678: new 712	gnu/mapping/WrongType
    //   681: dup
    //   682: aload 6
    //   684: ldc 170
    //   686: iconst_2
    //   687: aload_3
    //   688: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   691: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   112	118	362	java/lang/ClassCastException
    //   118	124	379	java/lang/ClassCastException
    //   132	138	396	java/lang/ClassCastException
    //   138	144	413	java/lang/ClassCastException
    //   152	158	430	java/lang/ClassCastException
    //   158	164	447	java/lang/ClassCastException
    //   172	181	464	java/lang/ClassCastException
    //   181	190	481	java/lang/ClassCastException
    //   201	207	498	java/lang/ClassCastException
    //   207	213	515	java/lang/ClassCastException
    //   221	230	532	java/lang/ClassCastException
    //   230	239	548	java/lang/ClassCastException
    //   247	253	564	java/lang/ClassCastException
    //   253	262	580	java/lang/ClassCastException
    //   280	286	596	java/lang/ClassCastException
    //   286	292	612	java/lang/ClassCastException
    //   310	316	628	java/lang/ClassCastException
    //   316	325	644	java/lang/ClassCastException
    //   333	339	660	java/lang/ClassCastException
    //   339	348	676	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 984	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+52->56, 47:+62->66, 49:+94->98, 51:+129->133, 52:+164->168, 59:+193->197
    //   57: aload_1
    //   58: aload_2
    //   59: aload_3
    //   60: aload 4
    //   62: invokespecial 1119	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: areturn
    //   66: aload_2
    //   67: checkcast 585	java/lang/Number
    //   70: invokevirtual 1109	java/lang/Number:intValue	()I
    //   73: istore 30
    //   75: aload_3
    //   76: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   79: astore 32
    //   81: aload 4
    //   83: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   86: astore 34
    //   88: iload 30
    //   90: aload 32
    //   92: aload 34
    //   94: invokestatic 1121	kawa/lib/numbers:logop	(ILgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   97: areturn
    //   98: aload_2
    //   99: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   102: astore 24
    //   104: aload_3
    //   105: checkcast 585	java/lang/Number
    //   108: invokevirtual 1109	java/lang/Number:intValue	()I
    //   111: istore 26
    //   113: aload 4
    //   115: checkcast 585	java/lang/Number
    //   118: invokevirtual 1109	java/lang/Number:intValue	()I
    //   121: istore 28
    //   123: aload 24
    //   125: iload 26
    //   127: iload 28
    //   129: invokestatic 1123	kawa/lib/numbers:bitwiseCopyBit	(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    //   132: areturn
    //   133: aload_2
    //   134: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   137: astore 18
    //   139: aload_3
    //   140: checkcast 585	java/lang/Number
    //   143: invokevirtual 1109	java/lang/Number:intValue	()I
    //   146: istore 20
    //   148: aload 4
    //   150: checkcast 585	java/lang/Number
    //   153: invokevirtual 1109	java/lang/Number:intValue	()I
    //   156: istore 22
    //   158: aload 18
    //   160: iload 20
    //   162: iload 22
    //   164: invokestatic 659	kawa/lib/numbers:bitwiseBitField	(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    //   167: areturn
    //   168: aload_2
    //   169: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   172: astore 12
    //   174: aload_3
    //   175: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   178: astore 14
    //   180: aload 4
    //   182: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   185: astore 16
    //   187: aload 12
    //   189: aload 14
    //   191: aload 16
    //   193: invokestatic 639	kawa/lib/numbers:bitwiseIf	(Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   196: areturn
    //   197: aload_2
    //   198: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   201: astore 6
    //   203: aload_3
    //   204: checkcast 585	java/lang/Number
    //   207: invokevirtual 1109	java/lang/Number:intValue	()I
    //   210: istore 8
    //   212: aload 4
    //   214: checkcast 585	java/lang/Number
    //   217: invokevirtual 1109	java/lang/Number:intValue	()I
    //   220: istore 10
    //   222: aload 6
    //   224: iload 8
    //   226: iload 10
    //   228: invokestatic 1125	kawa/lib/numbers:bitwiseReverseBitField	(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    //   231: areturn
    //   232: astore 29
    //   234: new 712	gnu/mapping/WrongType
    //   237: dup
    //   238: aload 29
    //   240: ldc 223
    //   242: iconst_1
    //   243: aload_2
    //   244: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   247: athrow
    //   248: astore 31
    //   250: new 712	gnu/mapping/WrongType
    //   253: dup
    //   254: aload 31
    //   256: ldc 223
    //   258: iconst_2
    //   259: aload_3
    //   260: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   263: athrow
    //   264: astore 33
    //   266: new 712	gnu/mapping/WrongType
    //   269: dup
    //   270: aload 33
    //   272: ldc 223
    //   274: iconst_3
    //   275: aload 4
    //   277: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: astore 23
    //   283: new 712	gnu/mapping/WrongType
    //   286: dup
    //   287: aload 23
    //   289: ldc 216
    //   291: iconst_1
    //   292: aload_2
    //   293: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: astore 25
    //   299: new 712	gnu/mapping/WrongType
    //   302: dup
    //   303: aload 25
    //   305: ldc 216
    //   307: iconst_2
    //   308: aload_3
    //   309: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   312: athrow
    //   313: astore 27
    //   315: new 712	gnu/mapping/WrongType
    //   318: dup
    //   319: aload 27
    //   321: ldc 216
    //   323: iconst_3
    //   324: aload 4
    //   326: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   329: athrow
    //   330: astore 17
    //   332: new 712	gnu/mapping/WrongType
    //   335: dup
    //   336: aload 17
    //   338: ldc 208
    //   340: iconst_1
    //   341: aload_2
    //   342: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   345: athrow
    //   346: astore 19
    //   348: new 712	gnu/mapping/WrongType
    //   351: dup
    //   352: aload 19
    //   354: ldc 208
    //   356: iconst_2
    //   357: aload_3
    //   358: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   361: athrow
    //   362: astore 21
    //   364: new 712	gnu/mapping/WrongType
    //   367: dup
    //   368: aload 21
    //   370: ldc 208
    //   372: iconst_3
    //   373: aload 4
    //   375: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   378: athrow
    //   379: astore 11
    //   381: new 712	gnu/mapping/WrongType
    //   384: dup
    //   385: aload 11
    //   387: ldc 204
    //   389: iconst_1
    //   390: aload_2
    //   391: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //   395: astore 13
    //   397: new 712	gnu/mapping/WrongType
    //   400: dup
    //   401: aload 13
    //   403: ldc 204
    //   405: iconst_2
    //   406: aload_3
    //   407: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   410: athrow
    //   411: astore 15
    //   413: new 712	gnu/mapping/WrongType
    //   416: dup
    //   417: aload 15
    //   419: ldc 204
    //   421: iconst_3
    //   422: aload 4
    //   424: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   427: athrow
    //   428: astore 5
    //   430: new 712	gnu/mapping/WrongType
    //   433: dup
    //   434: aload 5
    //   436: ldc 178
    //   438: iconst_1
    //   439: aload_2
    //   440: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   443: athrow
    //   444: astore 7
    //   446: new 712	gnu/mapping/WrongType
    //   449: dup
    //   450: aload 7
    //   452: ldc 178
    //   454: iconst_2
    //   455: aload_3
    //   456: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   459: athrow
    //   460: astore 9
    //   462: new 712	gnu/mapping/WrongType
    //   465: dup
    //   466: aload 9
    //   468: ldc 178
    //   470: iconst_3
    //   471: aload 4
    //   473: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   476: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   66	75	232	java/lang/ClassCastException
    //   75	81	248	java/lang/ClassCastException
    //   81	88	264	java/lang/ClassCastException
    //   98	104	281	java/lang/ClassCastException
    //   104	113	297	java/lang/ClassCastException
    //   113	123	313	java/lang/ClassCastException
    //   133	139	330	java/lang/ClassCastException
    //   139	148	346	java/lang/ClassCastException
    //   148	158	362	java/lang/ClassCastException
    //   168	174	379	java/lang/ClassCastException
    //   174	180	395	java/lang/ClassCastException
    //   180	187	411	java/lang/ClassCastException
    //   197	203	428	java/lang/ClassCastException
    //   203	212	444	java/lang/ClassCastException
    //   212	222	460	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 984	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 50:+40->44, 58:+84->88
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: aload 4
    //   38: aload 5
    //   40: invokespecial 1129	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: areturn
    //   44: aload_2
    //   45: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   48: astore 15
    //   50: aload_3
    //   51: checkcast 585	java/lang/Number
    //   54: invokevirtual 1109	java/lang/Number:intValue	()I
    //   57: istore 17
    //   59: aload 4
    //   61: checkcast 585	java/lang/Number
    //   64: invokevirtual 1109	java/lang/Number:intValue	()I
    //   67: istore 19
    //   69: aload 5
    //   71: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   74: astore 21
    //   76: aload 15
    //   78: iload 17
    //   80: iload 19
    //   82: aload 21
    //   84: invokestatic 661	kawa/lib/numbers:bitwiseCopyBitField	(Lgnu/math/IntNum;IILgnu/math/IntNum;)Lgnu/math/IntNum;
    //   87: areturn
    //   88: aload_2
    //   89: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   92: astore 7
    //   94: aload_3
    //   95: checkcast 585	java/lang/Number
    //   98: invokevirtual 1109	java/lang/Number:intValue	()I
    //   101: istore 9
    //   103: aload 4
    //   105: checkcast 585	java/lang/Number
    //   108: invokevirtual 1109	java/lang/Number:intValue	()I
    //   111: istore 11
    //   113: aload 5
    //   115: checkcast 585	java/lang/Number
    //   118: invokevirtual 1109	java/lang/Number:intValue	()I
    //   121: istore 13
    //   123: aload 7
    //   125: iload 9
    //   127: iload 11
    //   129: iload 13
    //   131: invokestatic 1131	kawa/lib/numbers:bitwiseRotateBitField	(Lgnu/math/IntNum;III)Lgnu/math/IntNum;
    //   134: areturn
    //   135: astore 14
    //   137: new 712	gnu/mapping/WrongType
    //   140: dup
    //   141: aload 14
    //   143: ldc 212
    //   145: iconst_1
    //   146: aload_2
    //   147: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   150: athrow
    //   151: astore 16
    //   153: new 712	gnu/mapping/WrongType
    //   156: dup
    //   157: aload 16
    //   159: ldc 212
    //   161: iconst_2
    //   162: aload_3
    //   163: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   166: athrow
    //   167: astore 18
    //   169: new 712	gnu/mapping/WrongType
    //   172: dup
    //   173: aload 18
    //   175: ldc 212
    //   177: iconst_3
    //   178: aload 4
    //   180: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   183: athrow
    //   184: astore 20
    //   186: new 712	gnu/mapping/WrongType
    //   189: dup
    //   190: aload 20
    //   192: ldc 212
    //   194: iconst_4
    //   195: aload 5
    //   197: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    //   201: astore 6
    //   203: new 712	gnu/mapping/WrongType
    //   206: dup
    //   207: aload 6
    //   209: ldc 182
    //   211: iconst_1
    //   212: aload_2
    //   213: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    //   217: astore 8
    //   219: new 712	gnu/mapping/WrongType
    //   222: dup
    //   223: aload 8
    //   225: ldc 182
    //   227: iconst_2
    //   228: aload_3
    //   229: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   232: athrow
    //   233: astore 10
    //   235: new 712	gnu/mapping/WrongType
    //   238: dup
    //   239: aload 10
    //   241: ldc 182
    //   243: iconst_3
    //   244: aload 4
    //   246: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   249: athrow
    //   250: astore 12
    //   252: new 712	gnu/mapping/WrongType
    //   255: dup
    //   256: aload 12
    //   258: ldc 182
    //   260: iconst_4
    //   261: aload 5
    //   263: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   266: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   44	50	135	java/lang/ClassCastException
    //   50	59	151	java/lang/ClassCastException
    //   59	69	167	java/lang/ClassCastException
    //   69	76	184	java/lang/ClassCastException
    //   88	94	201	java/lang/ClassCastException
    //   94	103	217	java/lang/ClassCastException
    //   103	113	233	java/lang/ClassCastException
    //   113	123	250	java/lang/ClassCastException
  }

  // ERROR //
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 984	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+44 -> 48, 12:+51->55, 13:+56->60, 14:+44->48, 15:+44->48, 16:+44->48, 17:+61->65, 18:+113->117
    //   49: aload_1
    //   50: aload_2
    //   51: invokespecial 1135	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: areturn
    //   55: aload_2
    //   56: invokestatic 1137	kawa/lib/numbers:max	([Ljava/lang/Object;)Ljava/lang/Object;
    //   59: areturn
    //   60: aload_2
    //   61: invokestatic 1139	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
    //   64: areturn
    //   65: aload_2
    //   66: arraylength
    //   67: istore 9
    //   69: iload 9
    //   71: anewarray 372	gnu/math/IntNum
    //   74: astore 10
    //   76: iload 9
    //   78: istore 11
    //   80: iinc 11 255
    //   83: iload 11
    //   85: ifge +9 -> 94
    //   88: aload 10
    //   90: invokestatic 1141	kawa/lib/numbers:gcd	([Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   93: areturn
    //   94: aload_2
    //   95: iload 11
    //   97: aaload
    //   98: astore 12
    //   100: aload 12
    //   102: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   105: astore 14
    //   107: aload 10
    //   109: iload 11
    //   111: aload 14
    //   113: aastore
    //   114: goto -34 -> 80
    //   117: aload_2
    //   118: arraylength
    //   119: istore_3
    //   120: iload_3
    //   121: anewarray 372	gnu/math/IntNum
    //   124: astore 4
    //   126: iload_3
    //   127: istore 5
    //   129: iinc 5 255
    //   132: iload 5
    //   134: ifge +9 -> 143
    //   137: aload 4
    //   139: invokestatic 1143	kawa/lib/numbers:lcm	([Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   142: areturn
    //   143: aload_2
    //   144: iload 5
    //   146: aaload
    //   147: astore 6
    //   149: aload 6
    //   151: invokestatic 1067	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   154: astore 8
    //   156: aload 4
    //   158: iload 5
    //   160: aload 8
    //   162: aastore
    //   163: goto -34 -> 129
    //   166: astore 13
    //   168: new 712	gnu/mapping/WrongType
    //   171: dup
    //   172: aload 13
    //   174: ldc_w 307
    //   177: iconst_0
    //   178: aload 12
    //   180: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   183: athrow
    //   184: astore 7
    //   186: new 712	gnu/mapping/WrongType
    //   189: dup
    //   190: aload 7
    //   192: ldc_w 304
    //   195: iconst_0
    //   196: aload 6
    //   198: invokespecial 717	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   201: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   100	107	166	java/lang/ClassCastException
    //   149	156	184	java/lang/ClassCastException
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 12:
    case 13:
    case 15:
    case 16:
    case 17:
    case 18:
    case 25:
    case 33:
    case 37:
    case 38:
    case 47:
    case 48:
    case 49:
    case 50:
    case 51:
    case 52:
    case 53:
    case 58:
    case 59:
    case 61:
    case 63:
    case 66:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 67:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 65:
      if (!(paramObject instanceof Quantity))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 64:
      if (!(paramObject instanceof Quantity))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 62:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 60:
      if (!(paramObject instanceof Number))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 57:
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 56:
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 55:
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 54:
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 46:
      if (!(paramObject instanceof Number))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 45:
      if (!(paramObject instanceof Number))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 44:
      if (!(paramObject instanceof Number))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 43:
      if (!(paramObject instanceof Number))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 42:
      if (!(paramObject instanceof Complex))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 41:
      if (!(paramObject instanceof Number))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 40:
      if (!(paramObject instanceof Complex))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 39:
      if (!(paramObject instanceof Complex))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 36:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 35:
      if (!(paramObject instanceof Quantity))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 34:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 32:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 31:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 30:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 29:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 27:
      if (!(paramObject instanceof Complex))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 26:
      if (!(paramObject instanceof Complex))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 24:
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 23:
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 22:
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 21:
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 20:
      if (RatNum.asRatNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 19:
      if (RatNum.asRatNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 14:
      if (!(paramObject instanceof Number))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11:
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 10:
      if (RealNum.asRealNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 9:
      if (!(paramObject instanceof Number))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 8:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 7:
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
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 1:
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
    case 66:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 62:
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 60:
      if (!(paramObject1 instanceof Number))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 53:
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (IntNum.asIntNumOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 48:
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 38:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 37:
      if (RealNum.asRealNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (RealNum.asRealNumOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 33:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 25:
      if (RealNum.asRealNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (RealNum.asRealNumOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 16:
      if (RealNum.asRealNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (RealNum.asRealNumOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 15:
    }
    if (RealNum.asRealNumOrNull(paramObject1) != null)
    {
      paramCallContext.value1 = paramObject1;
      if (RealNum.asRealNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
    }
    else
    {
      return -786431;
    }
    return -786430;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 59:
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    case 52:
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (IntNum.asIntNumOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          if (IntNum.asIntNumOrNull(paramObject3) == null)
            break label175;
          paramCallContext.value3 = paramObject3;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 3;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
      return -786429;
    case 51:
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    case 49:
      label175: if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    case 47:
    }
    paramCallContext.value1 = paramObject1;
    if (IntNum.asIntNumOrNull(paramObject2) != null)
    {
      paramCallContext.value2 = paramObject2;
      if (IntNum.asIntNumOrNull(paramObject3) != null)
      {
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
    }
    else
    {
      return -786430;
    }
    return -786429;
  }

  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 58:
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return -786431;
    case 50:
    }
    if (IntNum.asIntNumOrNull(paramObject1) != null)
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      if (IntNum.asIntNumOrNull(paramObject4) != null)
      {
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
    }
    else
    {
      return -786431;
    }
    return -786428;
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 14:
    case 15:
    case 16:
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 18:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 17:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 13:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 12:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
    atan = new GenericProc("atan");
    GenericProc localGenericProc1 = atan;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = lambda$Fn1;
    arrayOfObject1[1] = lambda$Fn2;
    localGenericProc1.setProperties(arrayOfObject1);
    sqrt = new GenericProc("sqrt");
    GenericProc localGenericProc2 = sqrt;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = lambda$Fn3;
    arrayOfObject2[1] = lambda$Fn4;
    localGenericProc2.setProperties(arrayOfObject2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.numbers
 * JD-Core Version:    0.6.2
 */