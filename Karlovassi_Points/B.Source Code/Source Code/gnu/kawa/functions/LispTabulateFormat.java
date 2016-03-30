package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispTabulateFormat extends ReportFormat
{
  int colinc;
  int colnum;
  int padChar;
  boolean relative;

  public LispTabulateFormat(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.colnum = paramInt1;
    this.colinc = paramInt2;
    this.relative = paramBoolean;
    this.padChar = paramInt3;
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int i = getParam(this.colnum, 1, paramArrayOfObject, paramInt);
    if (this.colnum == -1610612736)
      paramInt++;
    int j = getParam(this.colinc, 1, paramArrayOfObject, paramInt);
    if (this.colinc == -1610612736)
      paramInt++;
    int k = getParam(this.padChar, ' ', paramArrayOfObject, paramInt);
    if (this.padChar == -1610612736)
      paramInt++;
    int m = -1;
    if ((paramWriter instanceof OutPort))
      m = ((OutPort)paramWriter).getColumnNumber();
    if (m >= 0)
    {
      if (!this.relative)
        if (m < i)
          n = i - m;
      while (true)
      {
        n--;
        if (n < 0)
          break;
        paramWriter.write(k);
        continue;
        if (j <= 0)
        {
          n = 0;
        }
        else
        {
          n = j - (m - i) % j;
          continue;
          n = i + j - (m + i) % j;
        }
      }
    }
    if (this.relative);
    for (int n = i; ; n = 2)
      break;
    return paramInt;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispTabulateFormat
 * JD-Core Version:    0.6.2
 */