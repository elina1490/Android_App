package gnu.math;

import java.math.BigDecimal;

public abstract class RealNum extends Complex
  implements Comparable
{
  public static RealNum add(RealNum paramRealNum1, RealNum paramRealNum2, int paramInt)
  {
    return (RealNum)paramRealNum1.add(paramRealNum2, paramInt);
  }

  public static RealNum asRealNumOrNull(Object paramObject)
  {
    if ((paramObject instanceof RealNum))
      return (RealNum)paramObject;
    if (((paramObject instanceof Float)) || ((paramObject instanceof Double)))
      return new DFloNum(((Number)paramObject).doubleValue());
    return RatNum.asRatNumOrNull(paramObject);
  }

  public static RealNum divide(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    return (RealNum)paramRealNum1.div(paramRealNum2);
  }

  public static RealNum times(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    return (RealNum)paramRealNum1.mul(paramRealNum2);
  }

  public static IntNum toExactInt(double paramDouble)
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble)))
      throw new ArithmeticException("cannot convert " + paramDouble + " to exact integer");
    long l1 = Double.doubleToLongBits(paramDouble);
    int i;
    int j;
    long l2;
    long l3;
    if (l1 < 0L)
    {
      i = 1;
      j = 0x7FF & (int)(l1 >> 52);
      l2 = l1 & 0xFFFFFFFF;
      if (j != 0)
        break label122;
      l3 = l2 << 1;
    }
    while (true)
      if (j <= 1075)
      {
        int k = 1075 - j;
        if (k > 53)
        {
          return IntNum.zero();
          i = 0;
          break;
          label122: l3 = l2 | 0x0;
          continue;
        }
        long l5 = l3 >> k;
        if (i != 0);
        for (long l6 = -l5; ; l6 = l5)
          return IntNum.make(l6);
      }
    if (i != 0);
    for (long l4 = -l3; ; l4 = l3)
      return IntNum.shift(IntNum.make(l4), j - 1075);
  }

  public static IntNum toExactInt(double paramDouble, int paramInt)
  {
    return toExactInt(toInt(paramDouble, paramInt));
  }

  public static double toInt(double paramDouble, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return paramDouble;
    case 1:
      return Math.floor(paramDouble);
    case 2:
      return Math.ceil(paramDouble);
    case 3:
      if (paramDouble < 0.0D)
        return Math.ceil(paramDouble);
      return Math.floor(paramDouble);
    case 4:
    }
    return Math.rint(paramDouble);
  }

  public static IntNum toScaledInt(double paramDouble, int paramInt)
  {
    return toScaledInt(DFloNum.toExact(paramDouble), paramInt);
  }

  public static IntNum toScaledInt(RatNum paramRatNum, int paramInt)
  {
    int i;
    IntNum localIntNum2;
    IntNum localIntNum3;
    IntNum localIntNum4;
    if (paramInt != 0)
    {
      IntNum localIntNum1 = IntNum.ten();
      if (paramInt >= 0)
        break label61;
      i = -paramInt;
      localIntNum2 = IntNum.power(localIntNum1, i);
      localIntNum3 = paramRatNum.numerator();
      localIntNum4 = paramRatNum.denominator();
      if (paramInt < 0)
        break label66;
      localIntNum3 = IntNum.times(localIntNum3, localIntNum2);
    }
    while (true)
    {
      paramRatNum = RatNum.make(localIntNum3, localIntNum4);
      return paramRatNum.toExactInt(4);
      label61: i = paramInt;
      break;
      label66: localIntNum4 = IntNum.times(localIntNum4, localIntNum2);
    }
  }

  public static String toStringDecimal(String paramString)
  {
    int i = paramString.indexOf('E');
    if (i < 0)
      return paramString;
    int j = paramString.length();
    int k = paramString.charAt(j - 1);
    if ((k == 121) || (k == 78))
      return paramString;
    StringBuffer localStringBuffer = new StringBuffer(j + 10);
    if (paramString.charAt(0) == '-');
    for (int m = 1; paramString.charAt(i + 1) != '-'; m = 0)
      throw new Error("not implemented: toStringDecimal given non-negative exponent: " + paramString);
    int n = i + 2;
    int i1 = 0;
    int i8;
    for (int i2 = n; i2 < j; i2 = i8)
    {
      int i7 = i1 * 10;
      i8 = i2 + 1;
      i1 = i7 + (paramString.charAt(i2) - '0');
    }
    if (m != 0)
      localStringBuffer.append('-');
    localStringBuffer.append("0.");
    while (true)
    {
      i1--;
      if (i1 <= 0)
        break;
      localStringBuffer.append('0');
    }
    int i3 = 0;
    while (true)
    {
      int i4 = i3 + 1;
      char c = paramString.charAt(i3);
      if (c != 'E')
      {
        int i5;
        if (c != '-')
        {
          i5 = 1;
          label237: if (c == '.')
            break label289;
        }
        label289: for (int i6 = 1; ; i6 = 0)
        {
          if (((i5 & i6) == 0) || ((c == '0') && (i4 >= i)))
            break label301;
          localStringBuffer.append(c);
          i3 = i4;
          break;
          i5 = 0;
          break label237;
        }
      }
      return localStringBuffer.toString();
      label301: i3 = i4;
    }
  }

  public static int toStringScientific(String paramString, StringBuffer paramStringBuffer)
  {
    int i;
    if (paramString.charAt(0) == '-')
    {
      i = 1;
      if (i != 0)
        paramStringBuffer.append('-');
      if (i == 0)
        break label125;
    }
    int k;
    int i10;
    int i11;
    int i15;
    label68: int i3;
    label79: int i5;
    int i6;
    int i7;
    label125: for (int j = 1; ; j = 0)
    {
      k = paramString.length();
      if (paramString.charAt(j) != '0')
        break label271;
      i10 = j;
      i11 = j;
      if (i11 != k)
        break label130;
      paramStringBuffer.append("0");
      i15 = 0;
      int i16 = i15;
      i3 = i16;
      int i4 = paramStringBuffer.length();
      i5 = -1;
      while (true)
      {
        i6 = i4 - 1;
        i7 = paramStringBuffer.charAt(i6);
        if (i7 != 48)
          break;
        i5 = i6;
        i4 = i6;
      }
      i = 0;
      break;
    }
    label130: int i12 = i11 + 1;
    char c2 = paramString.charAt(i11);
    int i13;
    if ((c2 >= '0') && (c2 <= '9') && ((c2 != '0') || (i12 == k)))
    {
      paramStringBuffer.append(c2);
      paramStringBuffer.append('.');
      if (c2 == '0');
      for (i13 = 0; ; i13 = 2 + (i10 - i12))
      {
        if (i12 != k)
          break label424;
        paramStringBuffer.append('0');
        i15 = i13;
        i11 = i12;
        break;
      }
    }
    while (true)
    {
      if (i14 < k)
      {
        int i17 = i14 + 1;
        paramStringBuffer.append(paramString.charAt(i14));
        i14 = i17;
        continue;
        i11 = i12;
        break;
        label271: if (i != 0);
        int i1;
        int i2;
        for (int m = 2; ; m = 1)
        {
          int n = k - m;
          i1 = paramString.indexOf('.') + (n - k);
          i2 = j + 1;
          paramStringBuffer.append(paramString.charAt(j));
          paramStringBuffer.append('.');
          while (i2 < k)
          {
            int i9 = i2 + 1;
            char c1 = paramString.charAt(i2);
            if (c1 != '.')
              paramStringBuffer.append(c1);
            i2 = i9;
          }
        }
        if (i7 == 46);
        for (int i8 = i6 + 2; ; i8 = i5)
        {
          if (i8 >= 0)
            paramStringBuffer.setLength(i8);
          return i3;
        }
        i3 = i1;
        break label79;
      }
      i15 = i13;
      i11 = i14;
      break label68;
      label424: int i14 = i12;
    }
  }

  public static String toStringScientific(double paramDouble)
  {
    return toStringScientific(Double.toString(paramDouble));
  }

  public static String toStringScientific(float paramFloat)
  {
    return toStringScientific(Float.toString(paramFloat));
  }

  public static String toStringScientific(String paramString)
  {
    if (paramString.indexOf('E') >= 0)
      return paramString;
    int i = paramString.length();
    int j = paramString.charAt(i - 1);
    if ((j == 121) || (j == 78))
      return paramString;
    StringBuffer localStringBuffer = new StringBuffer(i + 10);
    int k = toStringScientific(paramString, localStringBuffer);
    localStringBuffer.append('E');
    localStringBuffer.append(k);
    return localStringBuffer.toString();
  }

  public Numeric abs()
  {
    if (isNegative())
      return neg();
    return this;
  }

  public abstract Numeric add(Object paramObject, int paramInt);

  public BigDecimal asBigDecimal()
  {
    return new BigDecimal(doubleValue());
  }

  public int compareTo(Object paramObject)
  {
    return compare(paramObject);
  }

  public abstract Numeric div(Object paramObject);

  public Complex exp()
  {
    return new DFloNum(Math.exp(doubleValue()));
  }

  public final RealNum im()
  {
    return IntNum.zero();
  }

  public abstract boolean isNegative();

  public boolean isZero()
  {
    return sign() == 0;
  }

  public Complex log()
  {
    double d = doubleValue();
    if (d < 0.0D)
      return DComplex.log(d, 0.0D);
    return new DFloNum(Math.log(d));
  }

  public RealNum max(RealNum paramRealNum)
  {
    int i;
    if ((isExact()) && (paramRealNum.isExact()))
    {
      i = 1;
      if (!grt(paramRealNum))
        break label56;
    }
    label56: for (Object localObject = this; ; localObject = paramRealNum)
    {
      if ((i == 0) && (((RealNum)localObject).isExact()))
        localObject = new DFloNum(((RealNum)localObject).doubleValue());
      return localObject;
      i = 0;
      break;
    }
  }

  public RealNum min(RealNum paramRealNum)
  {
    int i;
    if ((isExact()) && (paramRealNum.isExact()))
    {
      i = 1;
      if (!grt(paramRealNum))
        break label56;
    }
    label56: for (Object localObject = paramRealNum; ; localObject = this)
    {
      if ((i == 0) && (((RealNum)localObject).isExact()))
        localObject = new DFloNum(((RealNum)localObject).doubleValue());
      return localObject;
      i = 0;
      break;
    }
  }

  public abstract Numeric mul(Object paramObject);

  public final RealNum re()
  {
    return this;
  }

  public RealNum rneg()
  {
    return (RealNum)neg();
  }

  public abstract int sign();

  public final Complex sin()
  {
    return new DFloNum(Math.sin(doubleValue()));
  }

  public final Complex sqrt()
  {
    double d = doubleValue();
    if (d >= 0.0D)
      return new DFloNum(Math.sqrt(d));
    return DComplex.sqrt(d, 0.0D);
  }

  public RatNum toExact()
  {
    return DFloNum.toExact(doubleValue());
  }

  public IntNum toExactInt(int paramInt)
  {
    return toExactInt(doubleValue(), paramInt);
  }

  public RealNum toInexact()
  {
    if (isExact())
      return new DFloNum(doubleValue());
    return this;
  }

  public RealNum toInt(int paramInt)
  {
    return new DFloNum(toInt(doubleValue(), paramInt));
  }

  public IntNum toScaledInt(int paramInt)
  {
    return toScaledInt(toExact(), paramInt);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.RealNum
 * JD-Core Version:    0.6.2
 */