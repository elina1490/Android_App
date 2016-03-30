package gnu.text;

import gnu.lists.Consumer;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class EnglishIntegerFormat extends NumberFormat
{
  private static EnglishIntegerFormat cardinalEnglish;
  public static final String[] ones = { null, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
  public static final String[] onesth = { null, "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelveth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth" };
  private static EnglishIntegerFormat ordinalEnglish;
  public static final String[] power1000s = { null, " thousand", " million", " billion", " trillion", " quadrillion", " quintillion", " sextillion", " septillion", " octillion", " nonillion", " decillion", " undecillion", " duodecillion", " tredecillion", " quattuordecillion", " quindecillion", " sexdecillion", " septendecillion", " octodecillion", " novemdecillion", " vigintillion" };
  public static final String[] tens = { null, null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
  public static final String[] tensth = { null, null, "twentieth", "thirtieth", "fortieth", "fiftieth", "sixtieth", "seventieth", "eightieth", "ninetieth" };
  public boolean ordinal;

  public EnglishIntegerFormat(boolean paramBoolean)
  {
    this.ordinal = paramBoolean;
  }

  public static EnglishIntegerFormat getInstance(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (ordinalEnglish == null)
        ordinalEnglish = new EnglishIntegerFormat(true);
      return ordinalEnglish;
    }
    if (cardinalEnglish == null)
      cardinalEnglish = new EnglishIntegerFormat(false);
    return cardinalEnglish;
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
    String str;
    if (paramLong == 0L)
      if (this.ordinal)
      {
        str = "zeroth";
        paramStringBuffer.append(str);
      }
    while (true)
    {
      if (paramFieldPosition != null);
      return paramStringBuffer;
      str = "zero";
      break;
      if (paramLong < 0L)
      {
        paramStringBuffer.append("minus ");
        paramLong = -paramLong;
      }
      boolean bool = this.ordinal;
      format(paramStringBuffer, paramLong, 0, bool);
    }
  }

  void format(StringBuffer paramStringBuffer, long paramLong, int paramInt, boolean paramBoolean)
  {
    if (paramLong >= 1000L)
    {
      format(paramStringBuffer, paramLong / 1000L, paramInt + 1, false);
      paramLong %= 1000L;
      if (paramLong <= 0L)
        break label110;
    }
    label109: label110: label125: 
    do
    {
      paramStringBuffer.append(", ");
      break label109;
      int i;
      if (paramLong > 0L)
      {
        i = (int)paramLong;
        if ((!paramBoolean) || (paramInt != 0))
          break label125;
      }
      for (boolean bool = true; ; bool = false)
      {
        format999(paramStringBuffer, i, bool);
        if (paramInt < power1000s.length)
          break label131;
        paramStringBuffer.append(" times ten to the ");
        format(paramStringBuffer, paramInt * 3, 0, true);
        paramStringBuffer.append(" power");
        return;
        if (!paramBoolean)
          break;
        paramStringBuffer.append("th");
        break;
      }
    }
    while (paramInt <= 0);
    label131: paramStringBuffer.append(power1000s[paramInt]);
  }

  void format999(StringBuffer paramStringBuffer, int paramInt, boolean paramBoolean)
  {
    String[] arrayOfString2;
    if (paramInt >= 100)
    {
      int j = paramInt / 100;
      paramInt %= 100;
      if (j > 1)
      {
        paramStringBuffer.append(ones[j]);
        paramStringBuffer.append(' ');
      }
      paramStringBuffer.append("hundred");
      if (paramInt > 0)
        paramStringBuffer.append(' ');
    }
    else
    {
      if (paramInt >= 20)
      {
        int i = paramInt / 10;
        paramInt %= 10;
        if ((!paramBoolean) || (paramInt != 0))
          break label147;
        arrayOfString2 = tensth;
        label89: paramStringBuffer.append(arrayOfString2[i]);
        if (paramInt > 0)
          paramStringBuffer.append('-');
      }
      if (paramInt > 0)
        if (!paramBoolean)
          break label155;
    }
    label147: label155: for (String[] arrayOfString1 = onesth; ; arrayOfString1 = ones)
    {
      paramStringBuffer.append(arrayOfString1[paramInt]);
      return;
      if (!paramBoolean)
        break;
      paramStringBuffer.append("th");
      break;
      arrayOfString2 = tens;
      break label89;
    }
  }

  public Number parse(String paramString, ParsePosition paramParsePosition)
  {
    throw new Error("EnglishIntegerFormat.parseObject - not implemented");
  }

  public void writeBoolean(boolean paramBoolean, Consumer paramConsumer)
  {
    if (paramBoolean);
    for (long l = 1L; ; l = 0L)
    {
      writeLong(l, paramConsumer);
      return;
    }
  }

  public void writeInt(int paramInt, Consumer paramConsumer)
  {
    writeLong(paramInt, paramConsumer);
  }

  public void writeLong(long paramLong, Consumer paramConsumer)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    format(paramLong, localStringBuffer, null);
    paramConsumer.write(localStringBuffer, 0, localStringBuffer.length());
  }

  public void writeObject(Object paramObject, Consumer paramConsumer)
  {
    writeLong(((Number)paramObject).longValue(), paramConsumer);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.EnglishIntegerFormat
 * JD-Core Version:    0.6.2
 */