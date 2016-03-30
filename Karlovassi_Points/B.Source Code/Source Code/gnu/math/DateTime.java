package gnu.math;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTime extends Quantity
  implements Cloneable
{
  public static final int DATE_MASK = 14;
  static final int DAY_COMPONENT = 3;
  public static final int DAY_MASK = 8;
  public static TimeZone GMT = TimeZone.getTimeZone("GMT");
  static final int HOURS_COMPONENT = 4;
  public static final int HOURS_MASK = 16;
  static final int MINUTES_COMPONENT = 5;
  public static final int MINUTES_MASK = 32;
  static final int MONTH_COMPONENT = 2;
  public static final int MONTH_MASK = 4;
  static final int SECONDS_COMPONENT = 6;
  public static final int SECONDS_MASK = 64;
  static final int TIMEZONE_COMPONENT = 7;
  public static final int TIMEZONE_MASK = 128;
  public static final int TIME_MASK = 112;
  static final int YEAR_COMPONENT = 1;
  public static final int YEAR_MASK = 2;
  private static final Date minDate = new Date(-9223372036854775808L);
  GregorianCalendar calendar;
  int mask;
  int nanoSeconds;
  Unit unit = Unit.date;

  public DateTime(int paramInt)
  {
    this.calendar = new GregorianCalendar();
    this.calendar.setGregorianChange(minDate);
    this.calendar.clear();
    this.mask = paramInt;
  }

  public DateTime(int paramInt, GregorianCalendar paramGregorianCalendar)
  {
    this.calendar = paramGregorianCalendar;
    this.mask = paramInt;
  }

  public static DateTime add(DateTime paramDateTime, Duration paramDuration, int paramInt)
  {
    if ((paramDuration.unit == Unit.duration) || ((paramDuration.unit == Unit.month) && ((0xE & paramDateTime.mask) != 14)))
      throw new IllegalArgumentException("invalid date/time +/- duration combinatuion");
    DateTime localDateTime = new DateTime(paramDateTime.mask, (GregorianCalendar)paramDateTime.calendar.clone());
    int i;
    int j;
    int m;
    int n;
    if (paramDuration.months != 0)
    {
      i = 12 * localDateTime.getYear() + localDateTime.calendar.get(2) + paramInt * paramDuration.months;
      j = localDateTime.calendar.get(5);
      if (i < 12)
        break label286;
      m = i / 12;
      n = i % 12;
      localDateTime.calendar.set(0, 1);
    }
    for (int i1 = daysInMonth(n, m); ; i1 = daysInMonth(n, 1))
    {
      if (j > i1)
        j = i1;
      localDateTime.calendar.set(m, n, j);
      long l1 = paramDateTime.nanoSeconds + paramInt * (1000000000L * paramDuration.seconds + paramDuration.nanos);
      if (l1 != 0L)
      {
        if ((0x70 & paramDateTime.mask) == 0)
        {
          long l3 = l1 % 86400000000000L;
          if (l3 < 0L)
            l3 += 86400000000000L;
          l1 -= l3;
        }
        long l2 = localDateTime.calendar.getTimeInMillis() + 1000L * (l1 / 1000000000L);
        localDateTime.calendar.setTimeInMillis(l2);
        localDateTime.nanoSeconds = ((int)(l1 % 1000000000L));
      }
      return localDateTime;
      label286: int k = 11 - i;
      localDateTime.calendar.set(0, 0);
      m = 1 + k / 12;
      n = 11 - k % 12;
    }
  }

  public static DateTime addMinutes(DateTime paramDateTime, int paramInt)
  {
    return addSeconds(paramDateTime, paramInt * 60);
  }

  public static DateTime addSeconds(DateTime paramDateTime, int paramInt)
  {
    DateTime localDateTime = new DateTime(paramDateTime.mask, (GregorianCalendar)paramDateTime.calendar.clone());
    long l1 = 1000000000L * paramInt;
    if (l1 != 0L)
    {
      long l2 = l1 + paramDateTime.nanoSeconds;
      long l3 = paramDateTime.calendar.getTimeInMillis() + l2 / 1000000L;
      localDateTime.calendar.setTimeInMillis(l3);
      localDateTime.nanoSeconds = ((int)(l2 % 1000000L));
    }
    return localDateTime;
  }

  private static void append(int paramInt1, StringBuffer paramStringBuffer, int paramInt2)
  {
    int i = paramStringBuffer.length();
    paramStringBuffer.append(paramInt1);
    int j = i + paramInt2 - paramStringBuffer.length();
    while (true)
    {
      j--;
      if (j < 0)
        break;
      paramStringBuffer.insert(i, '0');
    }
  }

  public static int compare(DateTime paramDateTime1, DateTime paramDateTime2)
  {
    long l1 = paramDateTime1.calendar.getTimeInMillis();
    long l2 = paramDateTime2.calendar.getTimeInMillis();
    if ((0xE & (paramDateTime1.mask | paramDateTime2.mask)) == 0)
    {
      if (l1 < 0L)
        l1 += 86400000L;
      if (l2 < 0L)
        l2 += 86400000L;
    }
    int i = paramDateTime1.nanoSeconds;
    int j = paramDateTime2.nanoSeconds;
    long l3 = l1 + i / 1000000;
    long l4 = l2 + j / 1000000;
    int k = i % 1000000;
    int m = j % 1000000;
    if (l3 < l4)
      return -1;
    if (l3 > l4)
      return 1;
    if (k < m)
      return -1;
    if (k > m)
      return 1;
    return 0;
  }

  public static int daysInMonth(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2:
    case 4:
    case 6:
    case 7:
    case 9:
    default:
      return 31;
    case 3:
    case 5:
    case 8:
    case 10:
      return 30;
    case 1:
    }
    if (isLeapYear(paramInt2))
      return 29;
    return 28;
  }

  public static boolean isLeapYear(int paramInt)
  {
    return (paramInt % 4 == 0) && ((paramInt % 100 != 0) || (paramInt % 400 == 0));
  }

  public static TimeZone minutesToTimeZone(int paramInt)
  {
    if (paramInt == 0)
      return GMT;
    StringBuffer localStringBuffer = new StringBuffer("GMT");
    toStringZone(paramInt, localStringBuffer);
    return TimeZone.getTimeZone(localStringBuffer.toString());
  }

  public static DateTime parse(String paramString, int paramInt)
  {
    DateTime localDateTime = new DateTime(paramInt);
    String str = paramString.trim();
    int i = str.length();
    int j;
    int k;
    if ((paramInt & 0xE) != 0)
    {
      j = 1;
      if ((paramInt & 0x70) == 0)
        break label152;
      k = 1;
      label40: m = 0;
      if (j != 0)
      {
        m = localDateTime.parseDate(str, 0, paramInt);
        if (k != 0)
          if ((m >= 0) && (m < i) && (str.charAt(m) == 'T'))
            break label158;
      }
    }
    label152: label158: for (int m = -1; ; m++)
    {
      if (k != 0)
        m = localDateTime.parseTime(str, m);
      if (localDateTime.parseZone(str, m) == i)
        break label164;
      throw new NumberFormatException("Unrecognized date/time '" + str + '\'');
      j = 0;
      break;
      k = 0;
      break label40;
    }
    label164: return localDateTime;
  }

  private static int parseDigits(String paramString, int paramInt)
  {
    int i = paramInt;
    int j = -1;
    int k = paramString.length();
    int m;
    if (i < k)
    {
      m = Character.digit(paramString.charAt(i), 10);
      if (m >= 0);
    }
    else
    {
      if (j >= 0)
        break label72;
      return i;
    }
    if (j > 20000)
      return 0;
    if (j < 0);
    for (j = m; ; j = m + j * 10)
    {
      i++;
      break;
    }
    label72: return i | j << 16;
  }

  public static Duration sub(DateTime paramDateTime1, DateTime paramDateTime2)
  {
    long l1 = paramDateTime1.calendar.getTimeInMillis();
    long l2 = paramDateTime2.calendar.getTimeInMillis();
    int i = paramDateTime1.nanoSeconds;
    int j = paramDateTime2.nanoSeconds;
    long l3 = l1 + i / 1000000;
    long l4 = l2 + j / 1000000;
    (i % 1000000);
    int k = j % 1000000;
    long l5 = l3 - l4;
    long l6 = l5 / 1000L;
    int m = (int)(1000000L * (l5 % 1000L) + k - k);
    return Duration.make(0, l6 + m / 1000000000, m % 1000000000, Unit.second);
  }

  public static void toStringZone(int paramInt, StringBuffer paramStringBuffer)
  {
    if (paramInt == 0)
    {
      paramStringBuffer.append('Z');
      return;
    }
    if (paramInt < 0)
    {
      paramStringBuffer.append('-');
      paramInt = -paramInt;
    }
    while (true)
    {
      append(paramInt / 60, paramStringBuffer, 2);
      paramStringBuffer.append(':');
      append(paramInt % 60, paramStringBuffer, 2);
      return;
      paramStringBuffer.append('+');
    }
  }

  public Numeric add(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Duration))
      return add(this, (Duration)paramObject, paramInt);
    if (((paramObject instanceof DateTime)) && (paramInt == -1))
      return sub(this, (DateTime)paramObject);
    throw new IllegalArgumentException();
  }

  public Numeric addReversed(Numeric paramNumeric, int paramInt)
  {
    if (((paramNumeric instanceof Duration)) && (paramInt == 1))
      return add(this, (Duration)paramNumeric, paramInt);
    throw new IllegalArgumentException();
  }

  public DateTime adjustTimezone(int paramInt)
  {
    DateTime localDateTime = new DateTime(this.mask, (GregorianCalendar)this.calendar.clone());
    if (paramInt == 0);
    StringBuffer localStringBuffer;
    for (TimeZone localTimeZone = GMT; ; localTimeZone = TimeZone.getTimeZone(localStringBuffer.toString()))
    {
      localDateTime.calendar.setTimeZone(localTimeZone);
      if ((0x80 & localDateTime.mask) == 0)
        break;
      long l = this.calendar.getTimeInMillis();
      localDateTime.calendar.setTimeInMillis(l);
      if ((0x70 & this.mask) == 0)
      {
        localDateTime.calendar.set(11, 0);
        localDateTime.calendar.set(12, 0);
        localDateTime.calendar.set(13, 0);
        localDateTime.nanoSeconds = 0;
      }
      return localDateTime;
      localStringBuffer = new StringBuffer("GMT");
      toStringZone(paramInt, localStringBuffer);
    }
    localDateTime.mask = (0x80 | localDateTime.mask);
    return localDateTime;
  }

  public DateTime cast(int paramInt)
  {
    int i = 0xFFFFFF7F & this.mask;
    if (paramInt == i)
      return this;
    DateTime localDateTime = new DateTime(paramInt, (GregorianCalendar)this.calendar.clone());
    if (((paramInt & (i ^ 0xFFFFFFFF)) != 0) && ((i != 14) || (paramInt != 126)))
      throw new ClassCastException("cannot cast DateTime - missing conponents");
    int j;
    if (isZoneUnspecified())
    {
      localDateTime.mask = (0xFFFFFF7F & localDateTime.mask);
      j = i & (paramInt ^ 0xFFFFFFFF);
      if ((j & 0x70) == 0)
        break label198;
      localDateTime.calendar.clear(11);
      localDateTime.calendar.clear(12);
      localDateTime.calendar.clear(13);
    }
    while (true)
    {
      if ((j & 0x2) != 0)
      {
        localDateTime.calendar.clear(1);
        localDateTime.calendar.clear(0);
      }
      if ((j & 0x4) != 0)
        localDateTime.calendar.clear(2);
      if ((j & 0x8) != 0)
        localDateTime.calendar.clear(5);
      return localDateTime;
      localDateTime.mask = (0x80 | localDateTime.mask);
      break;
      label198: localDateTime.nanoSeconds = this.nanoSeconds;
    }
  }

  public int compare(Object paramObject)
  {
    if ((paramObject instanceof DateTime))
      return compare(this, (DateTime)paramObject);
    return ((Numeric)paramObject).compareReversed(this);
  }

  public int components()
  {
    return 0xFFFFFF7F & this.mask;
  }

  public int getDay()
  {
    return this.calendar.get(5);
  }

  public int getHours()
  {
    return this.calendar.get(11);
  }

  public int getMinutes()
  {
    return this.calendar.get(12);
  }

  public int getMonth()
  {
    return 1 + this.calendar.get(2);
  }

  public int getNanoSecondsOnly()
  {
    return this.nanoSeconds;
  }

  public int getSecondsOnly()
  {
    return this.calendar.get(13);
  }

  public int getWholeSeconds()
  {
    return this.calendar.get(13);
  }

  public int getYear()
  {
    int i = this.calendar.get(1);
    if (this.calendar.get(0) == 0)
      i = 1 - i;
    return i;
  }

  public int getZoneMinutes()
  {
    return this.calendar.getTimeZone().getRawOffset() / 60000;
  }

  public boolean isExact()
  {
    return (0x70 & this.mask) == 0;
  }

  public boolean isZero()
  {
    throw new Error("DateTime.isZero not meaningful!");
  }

  public boolean isZoneUnspecified()
  {
    return (0x80 & this.mask) == 0;
  }

  public Complex number()
  {
    throw new Error("number needs to be implemented!");
  }

  int parseDate(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      return paramInt1;
    int i = paramString.length();
    int j = 0;
    if (paramInt1 < i)
    {
      int i12 = paramString.charAt(paramInt1);
      j = 0;
      if (i12 == 45)
      {
        paramInt1++;
        j = 1;
      }
    }
    int k = paramInt1;
    int n;
    if ((paramInt2 & 0x2) == 0)
    {
      if (j == 0)
        return -1;
      n = -1;
    }
    while ((paramInt2 & 0xC) == 0)
    {
      return k;
      int m = parseDigits(paramString, k);
      n = m >> 16;
      k = m & 0xFFFF;
      if ((k != paramInt1 + 4) && ((k <= paramInt1 + 4) || (paramString.charAt(paramInt1) == '0')))
        return -1;
      if ((j != 0) || (n == 0))
      {
        this.calendar.set(0, 0);
        this.calendar.set(1, n + 1);
      }
      else
      {
        this.calendar.set(1, n);
      }
    }
    if ((k >= i) || (paramString.charAt(k) != '-'))
      return -1;
    int i1 = k + 1;
    int i2 = i1;
    int i3;
    if ((paramInt2 & 0x4) != 0)
    {
      int i11 = parseDigits(paramString, i2);
      i3 = i11 >> 16;
      i1 = i11 & 0xFFFF;
      if ((i3 <= 0) || (i3 > 12) || (i1 != i2 + 2))
        return -1;
      this.calendar.set(2, i3 - 1);
      if ((paramInt2 & 0x8) == 0)
        return i1;
    }
    else
    {
      i3 = -1;
    }
    if ((i1 >= i) || (paramString.charAt(i1) != '-'))
      return -1;
    int i4 = i1 + 1;
    int i5 = parseDigits(paramString, i4);
    int i6 = i5 >> 16;
    int i7 = i5 & 0xFFFF;
    if ((i6 > 0) && (i7 == i4 + 2))
    {
      int i10;
      if ((paramInt2 & 0x4) == 0)
      {
        i10 = 31;
        if (i6 <= i10)
        {
          this.calendar.set(5, i6);
          return i7;
        }
      }
      else
      {
        int i8 = i3 - 1;
        if ((paramInt2 & 0x2) != 0);
        for (int i9 = n; ; i9 = 2000)
        {
          i10 = daysInMonth(i8, i9);
          break;
        }
      }
    }
    return -1;
  }

  int parseTime(String paramString, int paramInt)
  {
    if (paramInt < 0)
      return paramInt;
    int i = paramString.length();
    int j = parseDigits(paramString, paramInt);
    int k = j >> 16;
    int m = j & 0xFFFF;
    int i2;
    int i6;
    int i7;
    int i8;
    int i9;
    int i12;
    int i10;
    if ((k <= 24) && (m == paramInt + 2) && (m != i) && (paramString.charAt(m) == ':'))
    {
      int n = m + 1;
      int i1 = parseDigits(paramString, n);
      i2 = i1 >> 16;
      int i3 = i1 & 0xFFFF;
      if ((i2 < 60) && (i3 == n + 2) && (i3 != i) && (paramString.charAt(i3) == ':'))
      {
        int i4 = i3 + 1;
        int i5 = parseDigits(paramString, i4);
        i6 = i5 >> 16;
        i7 = i5 & 0xFFFF;
        if ((i6 < 60) && (i7 == i4 + 2))
          if ((i7 + 1 < i) && (paramString.charAt(i7) == '.') && (Character.digit(paramString.charAt(i7 + 1), 10) >= 0))
          {
            i7++;
            i8 = 0;
            i9 = 0;
            if (i7 >= i)
              break label386;
            i12 = Character.digit(paramString.charAt(i7), 10);
            if (i12 < 0)
              i10 = i9;
          }
      }
    }
    while (true)
    {
      int i11 = i10 + 1;
      if (i10 < 9)
      {
        i8 *= 10;
        i10 = i11;
        continue;
        if (i9 < 9);
        for (i8 = i12 + i8 * 10; ; i8++)
          do
          {
            i9++;
            i7++;
            break;
          }
          while ((i9 != 9) || (i12 < 5));
      }
      else
      {
        this.nanoSeconds = i8;
        if ((k == 24) && ((i2 != 0) || (i6 != 0) || (this.nanoSeconds != 0)))
          return -1;
        this.calendar.set(11, k);
        this.calendar.set(12, i2);
        this.calendar.set(13, i6);
        return i7;
        return -1;
        label386: i10 = i9;
      }
    }
  }

  int parseZone(String paramString, int paramInt)
  {
    if (paramInt < 0)
      return paramInt;
    int i = parseZoneMinutes(paramString, paramInt);
    if (i == 0)
      return -1;
    if (i == paramInt)
      return paramInt;
    int j = i >> 16;
    int k = i & 0xFFFF;
    if (j == 0);
    for (TimeZone localTimeZone = GMT; ; localTimeZone = TimeZone.getTimeZone("GMT" + paramString.substring(paramInt, k)))
    {
      this.calendar.setTimeZone(localTimeZone);
      this.mask = (0x80 | this.mask);
      return k;
    }
  }

  int parseZoneMinutes(String paramString, int paramInt)
  {
    int i = paramString.length();
    if ((paramInt == i) || (paramInt < 0))
      return paramInt;
    int j = paramString.charAt(paramInt);
    if (j == 90)
      return paramInt + 1;
    if ((j != 43) && (j != 45))
      return paramInt;
    int k = paramInt + 1;
    int m = parseDigits(paramString, k);
    int n = m >> 16;
    if (n > 14)
      return 0;
    int i1 = n * 60;
    int i2 = m & 0xFFFF;
    if (i2 != k + 2)
      return 0;
    if (i2 < i)
    {
      if (paramString.charAt(i2) == ':')
      {
        int i3 = i2 + 1;
        int i4 = parseDigits(paramString, i3);
        i2 = i4 & 0xFFFF;
        int i5 = i4 >> 16;
        if ((i5 > 0) && ((i5 >= 60) || (n == 14)))
          return 0;
        i1 += i5;
        if (i2 != i3 + 2)
          return 0;
      }
    }
    else
      return 0;
    if (i1 > 840)
      return 0;
    if (j == 45)
      i1 = -i1;
    return i2 | i1 << 16;
  }

  public void setTimeZone(TimeZone paramTimeZone)
  {
    this.calendar.setTimeZone(paramTimeZone);
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    toString(localStringBuffer);
    return localStringBuffer.toString();
  }

  public void toString(StringBuffer paramStringBuffer)
  {
    int i = components();
    int j;
    if ((i & 0xE) != 0)
    {
      j = 1;
      if ((i & 0x70) == 0)
        break label66;
    }
    label66: for (int k = 1; ; k = 0)
    {
      if (j != 0)
      {
        toStringDate(paramStringBuffer);
        if (k != 0)
          paramStringBuffer.append('T');
      }
      if (k != 0)
        toStringTime(paramStringBuffer);
      toStringZone(paramStringBuffer);
      return;
      j = 0;
      break;
    }
  }

  public void toStringDate(StringBuffer paramStringBuffer)
  {
    int i = components();
    if ((i & 0x2) != 0)
    {
      int j = this.calendar.get(1);
      if (this.calendar.get(0) == 0)
      {
        j--;
        if (j != 0)
          paramStringBuffer.append('-');
      }
      append(j, paramStringBuffer, 4);
    }
    while (true)
    {
      if ((i & 0xC) != 0)
      {
        paramStringBuffer.append('-');
        if ((i & 0x4) != 0)
          append(getMonth(), paramStringBuffer, 2);
        if ((i & 0x8) != 0)
        {
          paramStringBuffer.append('-');
          append(getDay(), paramStringBuffer, 2);
        }
      }
      return;
      paramStringBuffer.append('-');
    }
  }

  public void toStringTime(StringBuffer paramStringBuffer)
  {
    append(getHours(), paramStringBuffer, 2);
    paramStringBuffer.append(':');
    append(getMinutes(), paramStringBuffer, 2);
    paramStringBuffer.append(':');
    append(getWholeSeconds(), paramStringBuffer, 2);
    Duration.appendNanoSeconds(this.nanoSeconds, paramStringBuffer);
  }

  public void toStringZone(StringBuffer paramStringBuffer)
  {
    if (isZoneUnspecified())
      return;
    toStringZone(getZoneMinutes(), paramStringBuffer);
  }

  public Unit unit()
  {
    return this.unit;
  }

  public DateTime withZoneUnspecified()
  {
    if (isZoneUnspecified())
      return this;
    DateTime localDateTime = new DateTime(this.mask, (GregorianCalendar)this.calendar.clone());
    localDateTime.calendar.setTimeZone(TimeZone.getDefault());
    localDateTime.mask = (0xFFFFFF7F & localDateTime.mask);
    return localDateTime;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.DateTime
 * JD-Core Version:    0.6.2
 */