package gnu.math;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class FixedRealFormat extends Format
{
  private int d;
  private int i;
  public boolean internalPad;
  public char overflowChar;
  public char padChar;
  public int scale;
  public boolean showPlus;
  public int width;

  private void format(StringBuffer paramStringBuffer, FieldPosition paramFieldPosition, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    (paramInt2 + paramInt3);
    int j = getMinimumIntegerDigits();
    if ((paramInt2 >= 0) && (paramInt2 > j));
    int n;
    for (int k = 0; ; k = j - paramInt2)
    {
      if ((paramInt2 + k <= 0) && ((this.width <= 0) || (this.width > paramInt4 + (paramInt3 + 1))))
        k++;
      int m = 1 + (k + (paramInt4 + paramInt1));
      n = this.width - m;
      int i1 = k;
      while (true)
      {
        i1--;
        if (i1 < 0)
          break;
        paramStringBuffer.insert(paramInt5 + paramInt4, '0');
      }
    }
    if (n >= 0)
    {
      int i3 = paramInt5;
      if ((this.internalPad) && (paramInt4 > 0))
        i3++;
      while (true)
      {
        n--;
        if (n < 0)
          break;
        paramStringBuffer.insert(i3, this.padChar);
      }
    }
    if (this.overflowChar != 0)
    {
      paramStringBuffer.setLength(paramInt5);
      this.i = this.width;
      while (true)
      {
        int i2 = this.i - 1;
        this.i = i2;
        if (i2 < 0)
          break;
        paramStringBuffer.append(this.overflowChar);
      }
    }
    paramStringBuffer.insert(paramStringBuffer.length() - paramInt3, '.');
  }

  public StringBuffer format(double paramDouble, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)))
      return paramStringBuffer.append(paramDouble);
    if (getMaximumFractionDigits() >= 0)
    {
      format(DFloNum.toExact(paramDouble), paramStringBuffer, paramFieldPosition);
      return paramStringBuffer;
    }
    int j;
    int k;
    int m;
    if (paramDouble < 0.0D)
    {
      j = 1;
      paramDouble = -paramDouble;
      k = paramStringBuffer.length();
      m = 1;
      if (j == 0)
        break label273;
      paramStringBuffer.append('-');
    }
    String str;
    int n;
    int i4;
    int i5;
    while (true)
    {
      str = Double.toString(paramDouble);
      n = this.scale;
      int i1 = str.indexOf('E');
      if (i1 >= 0)
      {
        int i20 = i1 + 1;
        if (str.charAt(i20) == '+')
          i20++;
        n += Integer.parseInt(str.substring(i20));
        str = str.substring(0, i1);
      }
      int i2 = str.indexOf('.');
      int i3 = str.length();
      if (i2 >= 0)
      {
        n -= i3 - i2 - 1;
        (i3 - 1);
        StringBuilder localStringBuilder = new StringBuilder().append(str.substring(0, i2));
        int i19 = i2 + 1;
        str = str.substring(i19);
      }
      i4 = str.length();
      for (i5 = 0; ; i5++)
      {
        int i6 = i4 - 1;
        if ((i5 >= i6) || (str.charAt(i5) != '0'))
          break;
      }
      j = 0;
      break;
      label273: if (this.showPlus)
        paramStringBuffer.append('+');
      else
        m = 0;
    }
    if (i5 > 0)
    {
      str = str.substring(i5);
      i4 -= i5;
    }
    int i7 = i4 + n;
    int i9;
    if (this.width > 0)
    {
      while (i7 < 0)
      {
        paramStringBuffer.append('0');
        i7++;
        i4++;
      }
      i9 = this.width - m - 1 - i7;
      if (i9 < 0)
        i9 = 0;
      paramStringBuffer.append(str);
      while (n > 0)
      {
        paramStringBuffer.append('0');
        n--;
        i4++;
      }
    }
    if (i4 > 16);
    for (int i8 = 16; ; i8 = i4)
    {
      i9 = i8 - i7;
      break;
    }
    int i10 = k + m;
    int i11 = i9 + (i10 + i7);
    int i12 = paramStringBuffer.length();
    int i13;
    int i14;
    label478: int i15;
    if (i11 >= i12)
    {
      i11 = i12;
      i13 = 48;
      if (i13 < 53)
        break label527;
      i14 = 1;
      if (i14 == 0)
        break label533;
      i15 = 57;
    }
    while (true)
    {
      if ((i11 <= i10 + i7) || (paramStringBuffer.charAt(i11 - 1) != i15))
        break label540;
      i11--;
      continue;
      i13 = paramStringBuffer.charAt(i11);
      break;
      label527: i14 = 0;
      break label478;
      label533: i15 = 48;
    }
    label540: int i16 = i11 - i10;
    int i17 = i16 - i7;
    if ((i14 != 0) && (ExponentialFormat.addOne(paramStringBuffer, i10, i11)))
    {
      i7++;
      i17 = 0;
      i16 = i7;
    }
    if ((i17 == 0) && ((this.width <= 0) || (1 + (m + i7) < this.width)))
    {
      i17 = 1;
      i16++;
      paramStringBuffer.insert(i10 + i7, '0');
    }
    paramStringBuffer.setLength(i10 + i16);
    if (j != 0);
    for (int i18 = 1; ; i18 = 0)
    {
      format(paramStringBuffer, paramFieldPosition, i16, i7, i17, i18, k);
      break;
    }
  }

  public StringBuffer format(long paramLong, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    format(IntNum.make(paramLong), paramStringBuffer, paramFieldPosition);
    return paramStringBuffer;
  }

  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    RealNum localRealNum = RealNum.asRealNumOrNull(paramObject);
    if (localRealNum == null)
    {
      if ((paramObject instanceof Complex))
      {
        String str = paramObject.toString();
        int j = this.width - str.length();
        while (true)
        {
          j--;
          if (j < 0)
            break;
          paramStringBuffer.append(' ');
        }
        paramStringBuffer.append(str);
        return paramStringBuffer;
      }
      localRealNum = (RealNum)paramObject;
    }
    return format(localRealNum.doubleValue(), paramStringBuffer, paramFieldPosition);
  }

  public void format(RealNum paramRealNum, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    if ((paramRealNum instanceof RatNum))
    {
      int j = getMaximumFractionDigits();
      if (j >= 0)
      {
        RatNum localRatNum = (RatNum)paramRealNum;
        boolean bool = localRatNum.isNegative();
        if (bool)
          localRatNum = localRatNum.rneg();
        int k = paramStringBuffer.length();
        int m = 1;
        if (bool)
          paramStringBuffer.append('-');
        while (true)
        {
          String str = RealNum.toScaledInt(localRatNum, j + this.scale).toString();
          paramStringBuffer.append(str);
          int n = str.length();
          format(paramStringBuffer, paramFieldPosition, n, n - j, j, m, k);
          return;
          if (this.showPlus)
            paramStringBuffer.append('+');
          else
            m = 0;
        }
      }
    }
    format(paramRealNum.doubleValue(), paramStringBuffer, paramFieldPosition);
  }

  public int getMaximumFractionDigits()
  {
    return this.d;
  }

  public int getMinimumIntegerDigits()
  {
    return this.i;
  }

  public Number parse(String paramString, ParsePosition paramParsePosition)
  {
    throw new Error("RealFixedFormat.parse - not implemented");
  }

  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    throw new Error("RealFixedFormat.parseObject - not implemented");
  }

  public void setMaximumFractionDigits(int paramInt)
  {
    this.d = paramInt;
  }

  public void setMinimumIntegerDigits(int paramInt)
  {
    this.i = paramInt;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.FixedRealFormat
 * JD-Core Version:    0.6.2
 */