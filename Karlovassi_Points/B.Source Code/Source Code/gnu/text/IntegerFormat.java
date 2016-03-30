package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.text.FieldPosition;

public class IntegerFormat extends ReportFormat
{
  public static final int MIN_DIGITS = 64;
  public static final int PAD_RIGHT = 16;
  public static final int SHOW_BASE = 8;
  public static final int SHOW_GROUPS = 1;
  public static final int SHOW_PLUS = 2;
  public static final int SHOW_SPACE = 4;
  public static final int UPPERCASE = 32;
  public int base = 10;
  public int commaChar = 44;
  public int commaInterval = 3;
  public int flags = 0;
  public int minWidth = 1;
  public int padChar = 32;

  public String convertToIntegerString(Object paramObject, int paramInt)
  {
    if (!(paramObject instanceof Number))
      return null;
    if ((paramObject instanceof BigInteger))
      return ((BigInteger)paramObject).toString(paramInt);
    return Long.toString(((Number)paramObject).longValue(), paramInt);
  }

  public int format(Object paramObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    Object[] arrayOfObject;
    int i;
    int j;
    int k;
    int m;
    int n;
    label130: int i1;
    label143: int i2;
    if ((paramObject instanceof Object[]))
    {
      arrayOfObject = (Object[])paramObject;
      i = getParam(this.minWidth, 1, arrayOfObject, paramInt);
      if (this.minWidth == -1610612736)
        paramInt++;
      j = getParam(this.padChar, ' ', arrayOfObject, paramInt);
      if (this.padChar == -1610612736)
        paramInt++;
      k = getParam(this.commaChar, ',', arrayOfObject, paramInt);
      if (this.commaChar == -1610612736)
        paramInt++;
      m = getParam(this.commaInterval, 3, arrayOfObject, paramInt);
      if (this.commaInterval == -1610612736)
        paramInt++;
      if ((0x1 & this.flags) == 0)
        break label183;
      n = 1;
      if ((0x10 & this.flags) == 0)
        break label189;
      i1 = 1;
      if (j != 48)
        break label195;
      i2 = 1;
    }
    while (true)
      if (arrayOfObject != null)
      {
        int i16 = arrayOfObject.length;
        if (paramInt >= i16)
        {
          paramWriter.write("#<missing format argument>");
          return paramInt;
          arrayOfObject = null;
          break;
          label183: n = 0;
          break label130;
          label189: i1 = 0;
          break label143;
          label195: i2 = 0;
          continue;
        }
        paramObject = arrayOfObject[paramInt];
      }
    int i3 = this.base;
    String str = convertToIntegerString(paramObject, i3);
    int i6;
    label262: label276: int i9;
    label393: label400: label406: label428: int i11;
    int i12;
    if (str != null)
    {
      int i4 = str.charAt(0);
      int i5;
      int i7;
      int i8;
      if (i4 == 45)
      {
        i5 = 1;
        i6 = str.length();
        if (i5 == 0)
          break label393;
        i7 = i6 - 1;
        if (n == 0)
          break label400;
        i8 = (i7 - 1) / m;
        i9 = i7 + i8;
        if ((i5 != 0) || ((0x6 & this.flags) != 0))
          i9++;
        if ((0x8 & this.flags) != 0)
        {
          if (this.base != 16)
            break label406;
          i9 += 2;
        }
      }
      while (true)
      {
        if ((0x40 & this.flags) != 0)
        {
          i9 = i7;
          if ((i6 == 1) && (i4 == 48) && (i == 0))
            i6 = 0;
        }
        if ((i1 != 0) || (i2 != 0))
          break label428;
        while (i > i9)
        {
          paramWriter.write(j);
          i--;
        }
        i5 = 0;
        break;
        i7 = i6;
        break label262;
        i8 = 0;
        break label276;
        if ((this.base == 8) && (i4 != 48))
          i9++;
      }
      label469: int i15;
      if (i5 != 0)
      {
        paramWriter.write(45);
        i11 = 0 + 1;
        i6--;
        if ((this.base <= 10) || ((0x20 & this.flags) == 0))
          break label582;
        i12 = 1;
        if ((0x8 & this.flags) != 0)
        {
          if (this.base != 16)
            break label595;
          paramWriter.write(48);
          if (i12 == 0)
            break label588;
          i15 = 88;
          label503: paramWriter.write(i15);
        }
      }
      while (true)
      {
        if (i2 == 0)
          break label725;
        while (i > i9)
        {
          paramWriter.write(j);
          i--;
        }
        if ((0x2 & this.flags) != 0)
        {
          paramWriter.write(43);
          i11 = 0;
          break;
        }
        int i10 = 0x4 & this.flags;
        i11 = 0;
        if (i10 == 0)
          break;
        paramWriter.write(32);
        i11 = 0;
        break;
        label582: i12 = 0;
        break label469;
        label588: i15 = 120;
        break label503;
        label595: if ((this.base == 8) && (i4 != 48))
          paramWriter.write(48);
      }
    }
    while (true)
    {
      int i14 = i13 + 1;
      char c = str.charAt(i13);
      if (i12 != 0)
        c = Character.toUpperCase(c);
      paramWriter.write(c);
      i6--;
      if ((n != 0) && (i6 > 0) && (i6 % m == 0))
        paramWriter.write(k);
      label725: for (int i13 = i14; i6 == 0; i13 = i11)
      {
        if (i1 != 0)
          while (i > i9)
          {
            paramWriter.write(j);
            i--;
            continue;
            print(paramWriter, paramObject.toString());
          }
        return paramInt + 1;
      }
    }
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    return format(paramArrayOfObject, paramInt, paramWriter, paramFieldPosition);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.IntegerFormat
 * JD-Core Version:    0.6.2
 */