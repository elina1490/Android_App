package gnu.text;

import gnu.lists.Consumer;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;

public abstract class ReportFormat extends Format
{
  public static final int PARAM_FROM_COUNT = -1342177280;
  public static final int PARAM_FROM_LIST = -1610612736;
  public static final int PARAM_UNSPECIFIED = -1073741824;

  public static int format(Format paramFormat, Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    if ((paramFormat instanceof ReportFormat))
      return ((ReportFormat)paramFormat).format(paramArrayOfObject, paramInt, paramWriter, paramFieldPosition);
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramFormat instanceof MessageFormat));
    int i;
    for (int j = format(paramFormat, paramArrayOfObject, paramInt, localStringBuffer, paramFieldPosition); ; j = i)
    {
      int k = localStringBuffer.length();
      char[] arrayOfChar = new char[k];
      localStringBuffer.getChars(0, k, arrayOfChar, 0);
      paramWriter.write(arrayOfChar);
      return j;
      i = paramInt + 1;
      paramFormat.format(paramArrayOfObject[paramInt], localStringBuffer, paramFieldPosition);
    }
  }

  public static int format(Format paramFormat, Object[] paramArrayOfObject, int paramInt, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    if ((paramFormat instanceof ReportFormat))
      return ((ReportFormat)paramFormat).format(paramArrayOfObject, paramInt, paramStringBuffer, paramFieldPosition);
    int i;
    Object localObject;
    if ((paramFormat instanceof MessageFormat))
    {
      i = paramArrayOfObject.length - paramInt;
      if (paramInt > 0)
      {
        Object[] arrayOfObject = new Object[paramArrayOfObject.length - paramInt];
        System.arraycopy(paramArrayOfObject, paramInt, arrayOfObject, 0, arrayOfObject.length);
        localObject = arrayOfObject;
      }
    }
    while (true)
    {
      paramFormat.format(localObject, paramStringBuffer, paramFieldPosition);
      return paramInt + i;
      localObject = paramArrayOfObject;
      continue;
      localObject = paramArrayOfObject[paramInt];
      i = 1;
    }
  }

  protected static char getParam(int paramInt1, char paramChar, Object[] paramArrayOfObject, int paramInt2)
  {
    return (char)getParam(paramInt1, paramChar, paramArrayOfObject, paramInt2);
  }

  protected static int getParam(int paramInt1, int paramInt2, Object[] paramArrayOfObject, int paramInt3)
  {
    if (paramInt1 == -1342177280)
      return paramArrayOfObject.length - paramInt3;
    if (paramInt1 == -1610612736)
    {
      if (paramArrayOfObject == null)
        return paramInt2;
      return getParam(paramArrayOfObject[paramInt3], paramInt2);
    }
    if (paramInt1 == -1073741824)
      return paramInt2;
    return paramInt1;
  }

  public static int getParam(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Number))
      return ((Number)paramObject).intValue();
    if ((paramObject instanceof Character))
      return ((Character)paramObject).charValue();
    if ((paramObject instanceof Char))
      return ((Char)paramObject).charValue();
    return paramInt;
  }

  public static int nextArg(int paramInt)
  {
    return 0xFFFFFF & paramInt;
  }

  public static void print(Writer paramWriter, String paramString)
    throws IOException
  {
    if ((paramWriter instanceof PrintWriter))
    {
      ((PrintWriter)paramWriter).print(paramString);
      return;
    }
    paramWriter.write(paramString.toCharArray());
  }

  public static void print(Object paramObject, Consumer paramConsumer)
  {
    if ((paramObject instanceof Printable))
    {
      ((Printable)paramObject).print(paramConsumer);
      return;
    }
    if (paramObject == null);
    for (String str = "null"; ; str = paramObject.toString())
    {
      paramConsumer.write(str);
      return;
    }
  }

  public static int result(int paramInt1, int paramInt2)
  {
    return paramInt2 | paramInt1 << 24;
  }

  public static int resultCode(int paramInt)
  {
    return paramInt >>> 24;
  }

  public int format(Object paramObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    if ((paramObject instanceof Object[]))
      return format((Object[])paramObject, paramInt, paramWriter, paramFieldPosition);
    return format(new Object[] { paramObject }, paramInt, paramWriter, paramFieldPosition);
  }

  public abstract int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException;

  public int format(Object[] paramArrayOfObject, int paramInt, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    int i;
    try
    {
      i = format(paramArrayOfObject, paramInt, localCharArrayWriter, paramFieldPosition);
      if (i < 0)
        return i;
    }
    catch (IOException localIOException)
    {
      throw new Error("unexpected exception: " + localIOException);
    }
    paramStringBuffer.append(localCharArrayWriter.toCharArray());
    return i;
  }

  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    format((Object[])paramObject, 0, paramStringBuffer, paramFieldPosition);
    return paramStringBuffer;
  }

  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    throw new Error("ReportFormat.parseObject - not implemented");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.ReportFormat
 * JD-Core Version:    0.6.2
 */