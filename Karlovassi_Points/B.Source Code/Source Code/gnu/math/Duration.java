package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Duration extends Quantity
  implements Externalizable
{
  int months;
  int nanos;
  long seconds;
  public Unit unit;

  public static Duration add(Duration paramDuration1, Duration paramDuration2, int paramInt)
  {
    long l1 = paramDuration1.months + paramInt * paramDuration2.months;
    long l2 = 1000000000L * paramDuration1.seconds + paramDuration1.nanos + paramInt * (1000000000L * paramDuration2.seconds + paramDuration2.nanos);
    Duration localDuration = new Duration();
    localDuration.months = ((int)l1);
    localDuration.seconds = ((int)(l2 / 1000000000L));
    localDuration.nanos = ((int)(l2 % 1000000000L));
    if ((paramDuration1.unit != paramDuration2.unit) || (paramDuration1.unit == Unit.duration))
      throw new ArithmeticException("cannot add these duration types");
    localDuration.unit = paramDuration1.unit;
    return localDuration;
  }

  static void appendNanoSeconds(int paramInt, StringBuffer paramStringBuffer)
  {
    if (paramInt == 0)
      return;
    paramStringBuffer.append('.');
    int i = paramStringBuffer.length();
    paramStringBuffer.append(paramInt);
    int j = paramStringBuffer.length();
    int k = i + 9 - j;
    while (true)
    {
      k--;
      if (k < 0)
        break;
      paramStringBuffer.insert(i, '0');
    }
    int m = i + 9;
    do
      m--;
    while (paramStringBuffer.charAt(m) == '0');
    paramStringBuffer.setLength(m + 1);
  }

  public static int compare(Duration paramDuration1, Duration paramDuration2)
  {
    long l1 = paramDuration1.months - paramDuration2.months;
    long l2 = 1000000000L * paramDuration1.seconds + paramDuration1.nanos - (1000000000L * paramDuration2.seconds + paramDuration2.nanos);
    if ((l1 < 0L) && (l2 <= 0L))
      return -1;
    if ((l1 > 0L) && (l2 >= 0L))
      return 1;
    if (l1 == 0L)
    {
      if (l2 < 0L)
        return -1;
      if (l2 > 0L)
        return 1;
      return 0;
    }
    return -2;
  }

  public static double div(Duration paramDuration1, Duration paramDuration2)
  {
    int i = paramDuration1.months;
    int j = paramDuration2.months;
    double d1 = paramDuration1.seconds + 1.E-009D * paramDuration1.nanos;
    double d2 = paramDuration2.seconds + 1.E-009D * paramDuration1.nanos;
    if ((j == 0) && (d2 == 0.0D))
      throw new ArithmeticException("divide duration by zero");
    if (j == 0)
    {
      if (i == 0)
        return d1 / d2;
    }
    else if ((d2 == 0.0D) && (d1 == 0.0D))
      return i / j;
    throw new ArithmeticException("divide of incompatible durations");
  }

  public static boolean equals(Duration paramDuration1, Duration paramDuration2)
  {
    return (paramDuration1.months == paramDuration2.months) && (paramDuration1.seconds == paramDuration2.seconds) && (paramDuration1.nanos == paramDuration2.nanos);
  }

  public static Duration make(int paramInt1, long paramLong, int paramInt2, Unit paramUnit)
  {
    Duration localDuration = new Duration();
    localDuration.months = paramInt1;
    localDuration.seconds = paramLong;
    localDuration.nanos = paramInt2;
    localDuration.unit = paramUnit;
    return localDuration;
  }

  public static Duration makeMinutes(int paramInt)
  {
    Duration localDuration = new Duration();
    localDuration.unit = Unit.second;
    localDuration.seconds = (paramInt * 60);
    return localDuration;
  }

  public static Duration makeMonths(int paramInt)
  {
    Duration localDuration = new Duration();
    localDuration.unit = Unit.month;
    localDuration.months = paramInt;
    return localDuration;
  }

  public static Duration parse(String paramString, Unit paramUnit)
  {
    Duration localDuration = valueOf(paramString, paramUnit);
    if (localDuration == null)
      throw new IllegalArgumentException("not a valid " + paramUnit.getName() + " duration: '" + paramString + "'");
    return localDuration;
  }

  public static Duration parseDayTimeDuration(String paramString)
  {
    return parse(paramString, Unit.second);
  }

  public static Duration parseDuration(String paramString)
  {
    return parse(paramString, Unit.duration);
  }

  public static Duration parseYearMonthDuration(String paramString)
  {
    return parse(paramString, Unit.month);
  }

  private static long scanPart(String paramString, int paramInt)
  {
    int i = paramInt;
    long l = -1L;
    int j = paramString.length();
    while (i < j)
    {
      char c = paramString.charAt(i);
      i++;
      int k = Character.digit(c, 10);
      if (k < 0)
      {
        if (l < 0L)
          return paramInt << 16;
        return l << 32 | i << 16 | c;
      }
      if (l < 0L);
      for (l = k; l > 2147483647L; l = 10L * l + k)
        return -1L;
    }
    if (l < 0L)
      return paramInt << 16;
    return -1L;
  }

  public static Duration times(Duration paramDuration, double paramDouble)
  {
    if (paramDuration.unit == Unit.duration)
      throw new IllegalArgumentException("cannot multiply general duration");
    double d1 = paramDouble * paramDuration.months;
    if ((Double.isInfinite(d1)) || (Double.isNaN(d1)))
      throw new ArithmeticException("overflow/NaN when multiplying a duration");
    double d2 = paramDouble * (1000000000L * paramDuration.seconds + paramDuration.nanos);
    Duration localDuration = new Duration();
    localDuration.months = ((int)Math.floor(0.5D + d1));
    localDuration.seconds = ((int)(d2 / 1000000000.0D));
    localDuration.nanos = ((int)(d2 % 1000000000.0D));
    localDuration.unit = paramDuration.unit;
    return localDuration;
  }

  public static Duration valueOf(String paramString, Unit paramUnit)
  {
    String str = paramString.trim();
    int i = str.length();
    int k;
    int j;
    if ((i < 0) && (str.charAt(0) == '-'))
    {
      int i22 = 0 + 1;
      k = 1;
      j = i22;
    }
    while ((j + 1 >= i) || (str.charAt(j) != 'P'))
    {
      return null;
      j = 0;
      k = 0;
    }
    int m = j + 1;
    int n = 0;
    long l1 = 0L;
    long l2 = scanPart(str, m);
    int i1 = (int)l2 >> 16;
    int i2 = (char)(int)l2;
    if ((paramUnit == Unit.second) && ((i2 == 89) || (i2 == 77)))
      return null;
    int i3 = 0;
    if (i2 == 89)
    {
      i3 = 12 * (int)(l2 >> 32);
      i1 = (int)l2 >> 16;
      l2 = scanPart(str, i1);
      i2 = (char)(int)l2;
    }
    int i20;
    int i5;
    if (i2 == 77)
    {
      i20 = (int)(i3 + (l2 >> 32));
      int i21 = (int)l2 >> 16;
      l2 = scanPart(str, i21);
      i2 = (char)(int)l2;
      i5 = i21;
    }
    label553: label843: int i4;
    for (int i6 = i20; ; i6 = i4)
    {
      if ((paramUnit == Unit.month) && (i5 != i))
        return null;
      if (i2 == 68)
      {
        if (paramUnit == Unit.month)
          return null;
        l1 = 86400L * (int)(l2 >> 32);
        i5 = (int)l2 >> 16;
        l2 = scanPart(str, i5);
      }
      if (l2 != i5 << 16)
        return null;
      int i8;
      int i9;
      long l3;
      char c1;
      long l11;
      long l5;
      if (i5 == i)
      {
        i8 = i5;
        i9 = 0;
        if (i8 != i)
          return null;
      }
      else
      {
        if (str.charAt(i5) == 'T')
        {
          i5++;
          if (i5 != i);
        }
        else
        {
          return null;
        }
        if (paramUnit == Unit.month)
          return null;
        l3 = scanPart(str, i5);
        c1 = (char)(int)l3;
        if (c1 == 'H')
        {
          l1 += 3600 * (int)(l3 >> 32);
          i5 = (int)l3 >> 16;
          l3 = scanPart(str, i5);
          c1 = (char)(int)l3;
        }
        if (c1 != 'M')
          break label843;
        long l10 = l1 + 60 * (int)(l3 >> 32);
        i5 = (int)l3 >> 16;
        l11 = scanPart(str, i5);
        c1 = (char)(int)l11;
        l5 = l10;
      }
      long l4;
      for (long l6 = l11; ; l6 = l4)
      {
        long l7;
        int i7;
        if ((c1 == 'S') || (c1 == '.'))
        {
          l7 = l5 + (int)(l6 >> 32);
          i7 = (int)l6 >> 16;
        }
        for (long l8 = l7; ; l8 = l5)
        {
          if ((c1 == '.') && (i7 + 1 < i) && (Character.digit(str.charAt(i7), 10) >= 0))
          {
            int i11 = i7;
            int i12 = 0;
            int i17;
            int i18;
            char c2;
            int i13;
            int i14;
            int i15;
            if (i11 < i)
            {
              i17 = i11 + 1;
              c1 = str.charAt(i11);
              i18 = Character.digit(c1, 10);
              if (i18 < 0)
              {
                c2 = c1;
                i13 = n;
                i14 = i12;
                i15 = i17;
              }
            }
            while (true)
            {
              int i16 = i14 + 1;
              int i19;
              if (i14 < 9)
              {
                i13 *= 10;
                i14 = i16;
                continue;
                if (i12 < 9)
                  i19 = i18 + n * 10;
              }
              else
              {
                while (true)
                {
                  i12++;
                  n = i19;
                  i11 = i17;
                  break label553;
                  if ((i12 == 9) && (i18 >= 5))
                  {
                    i19 = n + 1;
                    continue;
                    if (c2 != 'S')
                    {
                      return null;
                      Duration localDuration = new Duration();
                      int i10;
                      long l9;
                      if (k != 0)
                      {
                        i10 = -i6;
                        l9 = -l1;
                        i9 = -i9;
                      }
                      while (true)
                      {
                        localDuration.months = i10;
                        localDuration.seconds = l9;
                        localDuration.nanos = i9;
                        localDuration.unit = paramUnit;
                        return localDuration;
                        i10 = i6;
                        l9 = l1;
                      }
                    }
                    i9 = i13;
                    i8 = i15;
                    l1 = l8;
                    break;
                  }
                  i19 = n;
                }
                c2 = c1;
                i13 = n;
                i14 = i12;
                i15 = i11;
              }
            }
          }
          i8 = i7;
          l1 = l8;
          i9 = 0;
          break;
          i7 = i5;
        }
        l4 = l3;
        l5 = l1;
      }
      i4 = i3;
      i5 = i1;
    }
  }

  public Numeric add(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Duration))
      return add(this, (Duration)paramObject, paramInt);
    if (((paramObject instanceof DateTime)) && (paramInt == 1))
      return DateTime.add((DateTime)paramObject, this, 1);
    throw new IllegalArgumentException();
  }

  public int compare(Object paramObject)
  {
    if ((paramObject instanceof Duration))
      return compare(this, (Duration)paramObject);
    throw new IllegalArgumentException();
  }

  public Numeric div(Object paramObject)
  {
    if ((paramObject instanceof RealNum))
    {
      double d = ((RealNum)paramObject).doubleValue();
      if ((d == 0.0D) || (Double.isNaN(d)))
        throw new ArithmeticException("divide of duration by 0 or NaN");
      return times(this, 1.0D / d);
    }
    if ((paramObject instanceof Duration))
      return new DFloNum(div(this, (Duration)paramObject));
    return ((Numeric)paramObject).divReversed(this);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Duration)))
      return false;
    return equals(this, (Duration)paramObject);
  }

  public int getDays()
  {
    return (int)(this.seconds / 86400L);
  }

  public int getHours()
  {
    return (int)(this.seconds / 3600L % 24L);
  }

  public int getMinutes()
  {
    return (int)(this.seconds / 60L % 60L);
  }

  public int getMonths()
  {
    return this.months % 12;
  }

  public long getNanoSeconds()
  {
    return 1000000000L * this.seconds + this.nanos;
  }

  public int getNanoSecondsOnly()
  {
    return this.nanos;
  }

  public int getSecondsOnly()
  {
    return (int)(this.seconds % 60L);
  }

  public long getTotalMinutes()
  {
    return this.seconds / 60L;
  }

  public int getTotalMonths()
  {
    return this.months;
  }

  public long getTotalSeconds()
  {
    return this.seconds;
  }

  public int getYears()
  {
    return this.months / 12;
  }

  public int hashCode()
  {
    return this.months ^ (int)this.seconds ^ this.nanos;
  }

  public boolean isExact()
  {
    return false;
  }

  public boolean isZero()
  {
    return (this.months == 0) && (this.seconds == 0L) && (this.nanos == 0);
  }

  public Numeric mul(Object paramObject)
  {
    if ((paramObject instanceof RealNum))
      return times(this, ((RealNum)paramObject).doubleValue());
    return ((Numeric)paramObject).mulReversed(this);
  }

  public Numeric mulReversed(Numeric paramNumeric)
  {
    if (!(paramNumeric instanceof RealNum))
      throw new IllegalArgumentException();
    return times(this, ((RealNum)paramNumeric).doubleValue());
  }

  public Complex number()
  {
    throw new Error("number needs to be implemented!");
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.months = paramObjectInput.readInt();
    this.seconds = paramObjectInput.readLong();
    this.nanos = paramObjectInput.readInt();
    this.unit = ((Unit)paramObjectInput.readObject());
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = this.months;
    long l1 = this.seconds;
    int j = this.nanos;
    int k;
    if ((i < 0) || (l1 < 0L) || (j < 0))
    {
      k = 1;
      if (k != 0)
      {
        i = -i;
        l1 = -l1;
        j = -j;
        localStringBuffer.append('-');
      }
      localStringBuffer.append('P');
      int m = i / 12;
      if (m != 0)
      {
        localStringBuffer.append(m);
        localStringBuffer.append('Y');
        i -= m * 12;
      }
      if (i != 0)
      {
        localStringBuffer.append(i);
        localStringBuffer.append('M');
      }
      long l2 = l1 / 86400L;
      if (l2 != 0L)
      {
        localStringBuffer.append(l2);
        localStringBuffer.append('D');
        l1 -= 86400L * l2;
      }
      if ((l1 == 0L) && (j == 0))
        break label292;
      localStringBuffer.append('T');
      l3 = l1 / 3600L;
      if (l3 != 0L)
      {
        localStringBuffer.append(l3);
        localStringBuffer.append('H');
        l1 -= 3600L * l3;
      }
      l4 = l1 / 60L;
      if (l4 != 0L)
      {
        localStringBuffer.append(l4);
        localStringBuffer.append('M');
        l1 -= 60L * l4;
      }
      if ((l1 != 0L) || (j != 0))
      {
        localStringBuffer.append(l1);
        appendNanoSeconds(j, localStringBuffer);
        localStringBuffer.append('S');
      }
    }
    label292: 
    while (localStringBuffer.length() != 1)
    {
      long l3;
      long l4;
      return localStringBuffer.toString();
      k = 0;
      break;
    }
    if (this.unit == Unit.month);
    for (String str = "0M"; ; str = "T0S")
    {
      localStringBuffer.append(str);
      break;
    }
  }

  public Unit unit()
  {
    return this.unit;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeInt(this.months);
    paramObjectOutput.writeLong(this.seconds);
    paramObjectOutput.writeInt(this.nanos);
    paramObjectOutput.writeObject(this.unit);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.Duration
 * JD-Core Version:    0.6.2
 */