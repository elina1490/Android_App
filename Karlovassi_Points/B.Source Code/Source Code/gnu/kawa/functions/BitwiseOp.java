package gnu.kawa.functions;

import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import gnu.math.BitOps;
import gnu.math.IntNum;
import java.math.BigInteger;

public class BitwiseOp extends ArithOp
{
  public static final BitwiseOp and = new BitwiseOp("bitwise-and", 13);
  public static final BitwiseOp ashift = new BitwiseOp("bitwise-arithmetic-shift", 9);
  public static final BitwiseOp ashiftl = new BitwiseOp("bitwise-arithmetic-shift-left", 10);
  public static final BitwiseOp ashiftr = new BitwiseOp("bitwise-arithmetic-shift-right", 11);
  public static final BitwiseOp ior = new BitwiseOp("bitwise-ior", 14);
  public static final BitwiseOp not = new BitwiseOp("bitwise-not", 16);
  public static final BitwiseOp xor = new BitwiseOp("bitwise-xor", 15);

  public BitwiseOp(String paramString, int paramInt)
  {
    super(paramString, paramInt);
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
    Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forBitwise");
  }

  public static int checkNonNegativeShift(Procedure paramProcedure, int paramInt)
  {
    if (paramInt < 0)
      throw new WrongType(paramProcedure, 2, Integer.valueOf(paramInt), "non-negative integer");
    return paramInt;
  }

  public static IntNum shiftLeft(IntNum paramIntNum, int paramInt)
  {
    return IntNum.shift(paramIntNum, checkNonNegativeShift(ashiftl, paramInt));
  }

  public static IntNum shiftRight(IntNum paramIntNum, int paramInt)
  {
    return IntNum.shift(paramIntNum, -checkNonNegativeShift(ashiftr, paramInt));
  }

  public Object adjustResult(IntNum paramIntNum, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return paramIntNum;
    case 1:
      return Integer.valueOf(paramIntNum.intValue());
    case 2:
      return Long.valueOf(paramIntNum.longValue());
    case 3:
    }
    return new BigInteger(paramIntNum.toString());
  }

  public Object apply1(Object paramObject)
  {
    if (this.op == 16)
    {
      int i = Arithmetic.classifyValue(paramObject);
      return adjustResult(BitOps.not(LangObjType.coerceIntNum(paramObject)), i);
    }
    return apply2(defaultResult(), paramObject);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    int i = Arithmetic.classifyValue(paramObject1);
    int j = Arithmetic.classifyValue(paramObject2);
    if (((this.op >= 9) && (this.op <= 12)) || (i <= 0) || ((i > j) && (j > 0)));
    IntNum localIntNum1;
    IntNum localIntNum2;
    for (int k = i; ; k = j)
    {
      localIntNum1 = LangObjType.coerceIntNum(paramObject1);
      localIntNum2 = LangObjType.coerceIntNum(paramObject2);
      switch (this.op)
      {
      case 12:
      default:
        throw new Error();
      case 13:
      case 14:
      case 15:
      case 9:
      case 10:
      case 11:
      }
    }
    IntNum localIntNum3 = BitOps.and(localIntNum1, localIntNum2);
    while (true)
    {
      return adjustResult(localIntNum3, k);
      localIntNum3 = BitOps.ior(localIntNum1, localIntNum2);
      continue;
      localIntNum3 = BitOps.xor(localIntNum1, localIntNum2);
      continue;
      int m = localIntNum2.intValue();
      if ((this.op == 11) || (this.op == 10))
      {
        checkNonNegativeShift(this, m);
        if (this.op == 11)
          m = -m;
      }
      localIntNum3 = IntNum.shift(localIntNum1, m);
    }
  }

  public Object applyN(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i == 0)
      return defaultResult();
    if (i == 1)
      return apply1(paramArrayOfObject[0]);
    Object localObject = paramArrayOfObject[0];
    for (int j = 1; j < i; j++)
      localObject = apply2(localObject, paramArrayOfObject[j]);
    return localObject;
  }

  public Object defaultResult()
  {
    if (this.op == 13)
      return IntNum.minusOne();
    return IntNum.zero();
  }

  public int numArgs()
  {
    if ((this.op >= 9) && (this.op <= 12))
      return 8194;
    if (this.op == 16)
      return 4097;
    return -4096;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.BitwiseOp
 * JD-Core Version:    0.6.2
 */