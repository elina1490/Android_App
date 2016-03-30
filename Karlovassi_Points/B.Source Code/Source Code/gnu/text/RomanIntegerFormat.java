package gnu.text;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class RomanIntegerFormat extends NumberFormat
{
  static final String codes = "IVXLCDM";
  private static RomanIntegerFormat newRoman;
  private static RomanIntegerFormat oldRoman;
  public boolean oldStyle;

  public RomanIntegerFormat()
  {
  }

  public RomanIntegerFormat(boolean paramBoolean)
  {
    this.oldStyle = paramBoolean;
  }

  public static String format(int paramInt)
  {
    return format(paramInt, false);
  }

  public static String format(int paramInt, boolean paramBoolean)
  {
    if ((paramInt <= 0) || (paramInt >= 4999))
      return Integer.toString(paramInt);
    StringBuffer localStringBuffer = new StringBuffer(20);
    int i = 3;
    int j = 1000;
    if (i >= 0)
    {
      int k = paramInt / j;
      paramInt -= k * j;
      if (k == 0);
      while (true)
      {
        j /= 10;
        i--;
        break;
        if ((!paramBoolean) && ((k == 4) || (k == 9)))
        {
          localStringBuffer.append("IVXLCDM".charAt(i * 2));
          localStringBuffer.append("IVXLCDM".charAt(i * 2 + (k + 1) / 5));
        }
        else
        {
          int m = k;
          if (m >= 5)
          {
            localStringBuffer.append("IVXLCDM".charAt(1 + i * 2));
            m -= 5;
          }
          while (true)
          {
            m--;
            if (m < 0)
              break;
            localStringBuffer.append("IVXLCDM".charAt(i * 2));
          }
        }
      }
    }
    return localStringBuffer.toString();
  }

  public static RomanIntegerFormat getInstance(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (oldRoman == null)
        oldRoman = new RomanIntegerFormat(true);
      return oldRoman;
    }
    if (newRoman == null)
      newRoman = new RomanIntegerFormat(false);
    return newRoman;
  }

  public StringBuffer format(double paramDouble, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    long l = ()paramDouble;
    if (l == paramDouble)
      return format(l, paramStringBuffer, paramFieldPosition);
    paramStringBuffer.append(Double.toString(paramDouble));
    return paramStringBuffer;
  }

  public StringBuffer format(long paramLong, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    int k;
    String str;
    if (paramLong > 0L)
      if (this.oldStyle)
      {
        k = 4999;
        if (paramLong >= k)
          break label87;
        str = format((int)paramLong, this.oldStyle);
      }
    while (true)
      if (paramFieldPosition != null)
      {
        long l = 1L;
        int i = str.length();
        int j = i;
        while (true)
        {
          j--;
          if (j <= 0)
            break;
          l = 9L + 10L * l;
        }
        k = 3999;
        break;
        label87: str = Long.toString(paramLong);
        continue;
        StringBuffer localStringBuffer = new StringBuffer(i);
        new DecimalFormat("0").format(l, localStringBuffer, paramFieldPosition);
      }
    paramStringBuffer.append(str);
    return paramStringBuffer;
  }

  public Number parse(String paramString, ParsePosition paramParsePosition)
  {
    throw new Error("RomanIntegerFormat.parseObject - not implemented");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.RomanIntegerFormat
 * JD-Core Version:    0.6.2
 */