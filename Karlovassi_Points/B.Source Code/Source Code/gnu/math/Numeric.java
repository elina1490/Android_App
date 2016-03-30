package gnu.math;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class Numeric extends Number
{
  public static final int CEILING = 2;
  public static final int FLOOR = 1;
  public static final int NONNEG_MOD = 5;
  public static final int ROUND = 4;
  public static final int TRUNCATE = 3;

  public static Numeric asNumericOrNull(Object paramObject)
  {
    if ((paramObject instanceof Numeric))
      return (Numeric)paramObject;
    if (((paramObject instanceof BigInteger)) || ((paramObject instanceof Long)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Integer)))
      return IntNum.asIntNumOrNull(paramObject);
    if ((paramObject instanceof BigDecimal))
      return RatNum.asRatNumOrNull(paramObject);
    if (((paramObject instanceof Float)) || ((paramObject instanceof Double)))
      return new DFloNum(((Number)paramObject).doubleValue());
    return null;
  }

  public abstract Numeric abs();

  public final Numeric add(Object paramObject)
  {
    return add(paramObject, 1);
  }

  public abstract Numeric add(Object paramObject, int paramInt);

  public Numeric addReversed(Numeric paramNumeric, int paramInt)
  {
    throw new IllegalArgumentException();
  }

  public int compare(Object paramObject)
  {
    return -3;
  }

  public int compareReversed(Numeric paramNumeric)
  {
    throw new IllegalArgumentException();
  }

  public abstract Numeric div(Object paramObject);

  public Numeric divReversed(Numeric paramNumeric)
  {
    throw new IllegalArgumentException();
  }

  public Numeric div_inv()
  {
    return IntNum.one().div(this);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Numeric)))
      return false;
    return compare(paramObject) == 0;
  }

  public float floatValue()
  {
    return (float)doubleValue();
  }

  public boolean geq(Object paramObject)
  {
    return compare(paramObject) >= 0;
  }

  public boolean grt(Object paramObject)
  {
    return compare(paramObject) > 0;
  }

  public int intValue()
  {
    return (int)longValue();
  }

  public abstract boolean isExact();

  public abstract boolean isZero();

  public long longValue()
  {
    return ()doubleValue();
  }

  public abstract Numeric mul(Object paramObject);

  public Numeric mulReversed(Numeric paramNumeric)
  {
    throw new IllegalArgumentException();
  }

  public Numeric mul_ident()
  {
    return IntNum.one();
  }

  public abstract Numeric neg();

  public Numeric power(IntNum paramIntNum)
  {
    if (paramIntNum.isNegative())
      return power(IntNum.neg(paramIntNum)).div_inv();
    Numeric localNumeric1 = this;
    Numeric localNumeric2 = null;
    while (true)
    {
      if (paramIntNum.isOdd())
        if (localNumeric2 != null)
          break label58;
      label58: for (localNumeric2 = localNumeric1; ; localNumeric2 = localNumeric2.mul(localNumeric1))
      {
        paramIntNum = IntNum.shift(paramIntNum, -1);
        if (!paramIntNum.isZero())
          break;
        if (localNumeric2 != null)
          break label76;
        return mul_ident();
      }
      localNumeric1 = localNumeric1.mul(localNumeric1);
    }
    label76: return localNumeric2;
  }

  public final Numeric sub(Object paramObject)
  {
    return add(paramObject, -1);
  }

  public Numeric toExact()
  {
    return this;
  }

  public Numeric toInexact()
  {
    return this;
  }

  public String toString()
  {
    return toString(10);
  }

  public abstract String toString(int paramInt);
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.Numeric
 * JD-Core Version:    0.6.2
 */