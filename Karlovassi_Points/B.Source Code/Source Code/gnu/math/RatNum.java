package gnu.math;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class RatNum extends RealNum
{
  public static final IntNum ten_exp_9 = IntNum.make(1000000000);

  public static RatNum add(RatNum paramRatNum1, RatNum paramRatNum2, int paramInt)
  {
    IntNum localIntNum1 = paramRatNum1.numerator();
    IntNum localIntNum2 = paramRatNum1.denominator();
    IntNum localIntNum3 = paramRatNum2.numerator();
    IntNum localIntNum4 = paramRatNum2.denominator();
    if (IntNum.equals(localIntNum2, localIntNum4))
      return make(IntNum.add(localIntNum1, localIntNum3, paramInt), localIntNum2);
    return make(IntNum.add(IntNum.times(localIntNum4, localIntNum1), IntNum.times(localIntNum3, localIntNum2), paramInt), IntNum.times(localIntNum2, localIntNum4));
  }

  public static RatNum asRatNumOrNull(Object paramObject)
  {
    if ((paramObject instanceof RatNum))
      return (RatNum)paramObject;
    if ((paramObject instanceof BigDecimal))
      return valueOf((BigDecimal)paramObject);
    return IntNum.asIntNumOrNull(paramObject);
  }

  public static int compare(RatNum paramRatNum1, RatNum paramRatNum2)
  {
    return IntNum.compare(IntNum.times(paramRatNum1.numerator(), paramRatNum2.denominator()), IntNum.times(paramRatNum2.numerator(), paramRatNum1.denominator()));
  }

  public static RatNum divide(RatNum paramRatNum1, RatNum paramRatNum2)
  {
    return make(IntNum.times(paramRatNum1.numerator(), paramRatNum2.denominator()), IntNum.times(paramRatNum1.denominator(), paramRatNum2.numerator()));
  }

  public static boolean equals(RatNum paramRatNum1, RatNum paramRatNum2)
  {
    return (IntNum.equals(paramRatNum1.numerator(), paramRatNum2.numerator())) && (IntNum.equals(paramRatNum1.denominator(), paramRatNum2.denominator()));
  }

  public static RatNum infinity(int paramInt)
  {
    return new IntFraction(IntNum.make(paramInt), IntNum.zero());
  }

  public static RatNum make(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    IntNum localIntNum = IntNum.gcd(paramIntNum1, paramIntNum2);
    if (paramIntNum2.isNegative())
      localIntNum = IntNum.neg(localIntNum);
    if (!localIntNum.isOne())
    {
      paramIntNum1 = IntNum.quotient(paramIntNum1, localIntNum);
      paramIntNum2 = IntNum.quotient(paramIntNum2, localIntNum);
    }
    if (paramIntNum2.isOne())
      return paramIntNum1;
    return new IntFraction(paramIntNum1, paramIntNum2);
  }

  public static RatNum neg(RatNum paramRatNum)
  {
    IntNum localIntNum1 = paramRatNum.numerator();
    IntNum localIntNum2 = paramRatNum.denominator();
    return make(IntNum.neg(localIntNum1), localIntNum2);
  }

  public static RealNum rationalize(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    if (paramRealNum1.grt(paramRealNum2))
      return simplest_rational2(paramRealNum2, paramRealNum1);
    if (!paramRealNum2.grt(paramRealNum1))
      return paramRealNum1;
    if (paramRealNum1.sign() > 0)
      return simplest_rational2(paramRealNum1, paramRealNum2);
    if (paramRealNum2.isNegative())
      return (RealNum)simplest_rational2((RealNum)paramRealNum2.neg(), (RealNum)paramRealNum1.neg()).neg();
    return IntNum.zero();
  }

  private static RealNum simplest_rational2(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    RealNum localRealNum1 = paramRealNum1.toInt(1);
    RealNum localRealNum2 = paramRealNum2.toInt(1);
    if (!paramRealNum1.grt(localRealNum1))
      return localRealNum1;
    if (localRealNum1.equals(localRealNum2))
    {
      RealNum localRealNum3 = (RealNum)IntNum.one().div(paramRealNum2.sub(localRealNum2));
      RealNum localRealNum4 = (RealNum)IntNum.one().div(paramRealNum1.sub(localRealNum1));
      return (RealNum)localRealNum1.add(IntNum.one().div(simplest_rational2(localRealNum3, localRealNum4)), 1);
    }
    return (RealNum)localRealNum1.add(IntNum.one(), 1);
  }

  public static RatNum times(RatNum paramRatNum1, RatNum paramRatNum2)
  {
    return make(IntNum.times(paramRatNum1.numerator(), paramRatNum2.numerator()), IntNum.times(paramRatNum1.denominator(), paramRatNum2.denominator()));
  }

  public static RatNum valueOf(BigDecimal paramBigDecimal)
  {
    Object localObject = IntNum.valueOf(paramBigDecimal.unscaledValue().toString(), 10);
    for (int i = paramBigDecimal.scale(); i >= 9; i -= 9)
      localObject = divide((RatNum)localObject, ten_exp_9);
    while (i <= -9)
    {
      localObject = times((RatNum)localObject, ten_exp_9);
      i += 9;
    }
    if (i > 0);
    for (int j = i; ; j = -i)
      switch (j)
      {
      default:
        return localObject;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      }
    IntNum localIntNum = IntNum.make(10);
    while (i > 0)
    {
      return divide((RatNum)localObject, localIntNum);
      localIntNum = IntNum.make(100);
      continue;
      localIntNum = IntNum.make(1000);
      continue;
      localIntNum = IntNum.make(10000);
      continue;
      localIntNum = IntNum.make(100000);
      continue;
      localIntNum = IntNum.make(1000000);
      continue;
      localIntNum = IntNum.make(10000000);
      continue;
      localIntNum = IntNum.make(100000000);
    }
    return times((RatNum)localObject, localIntNum);
  }

  public abstract IntNum denominator();

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof RatNum)))
      return false;
    return equals(this, (RatNum)paramObject);
  }

  public boolean isExact()
  {
    return true;
  }

  public boolean isZero()
  {
    return numerator().isZero();
  }

  public abstract IntNum numerator();

  public Numeric power(IntNum paramIntNum)
  {
    int i;
    if (paramIntNum.isNegative())
    {
      i = 1;
      paramIntNum = IntNum.neg(paramIntNum);
    }
    while (paramIntNum.words == null)
    {
      IntNum localIntNum1 = IntNum.power(numerator(), paramIntNum.ival);
      IntNum localIntNum2 = IntNum.power(denominator(), paramIntNum.ival);
      if (i != 0)
      {
        return make(localIntNum2, localIntNum1);
        i = 0;
      }
      else
      {
        return make(localIntNum1, localIntNum2);
      }
    }
    double d1 = doubleValue();
    int j;
    double d2;
    if ((d1 < 0.0D) && (paramIntNum.isOdd()))
    {
      j = 1;
      d2 = Math.pow(d1, paramIntNum.doubleValue());
      if (i != 0)
        d2 = 1.0D / d2;
      if (j == 0)
        break label139;
    }
    label139: for (double d3 = -d2; ; d3 = d2)
    {
      return new DFloNum(d3);
      j = 0;
      break;
    }
  }

  public final RatNum rneg()
  {
    return neg(this);
  }

  public final RatNum toExact()
  {
    return this;
  }

  public IntNum toExactInt(int paramInt)
  {
    return IntNum.quotient(numerator(), denominator(), paramInt);
  }

  public RealNum toInt(int paramInt)
  {
    return IntNum.quotient(numerator(), denominator(), paramInt);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.RatNum
 * JD-Core Version:    0.6.2
 */