package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;

public class CaseConvertFormat extends ReportFormat
{
  Format baseFormat;
  char code;

  public CaseConvertFormat(Format paramFormat, char paramChar)
  {
    this.baseFormat = paramFormat;
    this.code = paramChar;
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    int i = format(this.baseFormat, paramArrayOfObject, paramInt, localStringBuffer, paramFieldPosition);
    int j = localStringBuffer.length();
    char c1 = ' ';
    int k = 0;
    if (k < j)
    {
      char c2 = localStringBuffer.charAt(k);
      char c3;
      if (this.code == 'U')
        c3 = Character.toUpperCase(c2);
      while (true)
      {
        c1 = c3;
        paramWriter.write(c3);
        k++;
        break;
        if (((this.code == 'T') && (k == 0)) || ((this.code == 'C') && (!Character.isLetterOrDigit(c1))))
          c3 = Character.toTitleCase(c2);
        else
          c3 = Character.toLowerCase(c2);
      }
    }
    return i;
  }

  public Format getBaseFormat()
  {
    return this.baseFormat;
  }

  public void setBaseFormat(Format paramFormat)
  {
    this.baseFormat = paramFormat;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.CaseConvertFormat
 * JD-Core Version:    0.6.2
 */