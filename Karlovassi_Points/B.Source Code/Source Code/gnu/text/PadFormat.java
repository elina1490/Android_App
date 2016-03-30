package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;

public class PadFormat extends ReportFormat
{
  Format fmt;
  int minWidth;
  char padChar;
  int where;

  public PadFormat(Format paramFormat, int paramInt)
  {
    this(paramFormat, paramInt, ' ', 100);
  }

  public PadFormat(Format paramFormat, int paramInt1, char paramChar, int paramInt2)
  {
    this.fmt = paramFormat;
    this.minWidth = paramInt1;
    this.padChar = paramChar;
    this.where = paramInt2;
  }

  public static int format(Format paramFormat, Object[] paramArrayOfObject, int paramInt1, Writer paramWriter, char paramChar, int paramInt2, int paramInt3, int paramInt4, int paramInt5, FieldPosition paramFieldPosition)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    int i;
    int k;
    Object localObject1;
    int m;
    int i4;
    int i5;
    label181: int i2;
    Object localObject2;
    if ((paramFormat instanceof ReportFormat))
    {
      i = ((ReportFormat)paramFormat).format(paramArrayOfObject, paramInt1, localStringBuffer, paramFieldPosition);
      int j = localStringBuffer.length();
      k = padNeeded(j, paramInt2, paramInt3, paramInt4);
      localObject1 = localStringBuffer.toString();
      if (k <= 0)
        break label324;
      m = 0;
      if (paramInt5 == -1)
      {
        if (j <= 0)
          break label354;
        int i3 = ((String)localObject1).charAt(0);
        if (i3 != 45)
        {
          i4 = 0;
          if (i3 != 43);
        }
        else
        {
          i4 = 0 + 1;
          paramWriter.write(i3);
        }
        if ((j - i4 <= 2) || (((String)localObject1).charAt(i4) != '0'))
          break label347;
        paramWriter.write(48);
        i5 = i4 + 1;
        int i6 = ((String)localObject1).charAt(i5);
        if ((i6 == 120) || (i6 == 88))
        {
          i5++;
          paramWriter.write(i6);
        }
        if (i5 <= 0)
          break label336;
        String str = ((String)localObject1).substring(i5);
        i2 = i5;
        localObject2 = str;
      }
    }
    while (true)
    {
      paramInt5 = 0;
      localObject1 = localObject2;
      m = i2;
      int n = k * paramInt5 / 100;
      int i1 = k - n;
      while (true)
      {
        i1--;
        if (i1 < 0)
          break;
        paramWriter.write(paramChar);
      }
      if ((paramFormat instanceof MessageFormat))
      {
        paramFormat.format(paramArrayOfObject, localStringBuffer, paramFieldPosition);
        i = paramArrayOfObject.length;
        break;
      }
      paramFormat.format(paramArrayOfObject[paramInt1], localStringBuffer, paramFieldPosition);
      i = paramInt1 + 1;
      break;
      paramWriter.write((String)localObject1);
      while (true)
      {
        n--;
        if (n < 0)
          break;
        paramWriter.write(paramChar);
      }
      return i;
      label324: paramWriter.write((String)localObject1);
      return i;
      label336: i2 = i5;
      localObject2 = localObject1;
      continue;
      label347: i5 = i4;
      break label181;
      label354: localObject2 = localObject1;
      i2 = 0;
    }
  }

  public static int padNeeded(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1 + paramInt4;
    if (paramInt3 <= 1)
      paramInt3 = paramInt2 - i;
    while (i < paramInt2)
      i += paramInt3;
    return i - paramInt1;
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    return format(this.fmt, paramArrayOfObject, paramInt, paramWriter, this.padChar, this.minWidth, 1, 0, this.where, paramFieldPosition);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.PadFormat
 * JD-Core Version:    0.6.2
 */