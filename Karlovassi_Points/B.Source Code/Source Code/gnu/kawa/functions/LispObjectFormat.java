package gnu.kawa.functions;

import gnu.text.PadFormat;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispObjectFormat extends ReportFormat
{
  ReportFormat base;
  int colInc;
  int minPad;
  int minWidth;
  int padChar;
  int where;

  public LispObjectFormat(ReportFormat paramReportFormat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.base = paramReportFormat;
    this.minWidth = paramInt1;
    this.colInc = paramInt2;
    this.minPad = paramInt3;
    this.padChar = paramInt4;
    this.where = paramInt5;
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int i = getParam(this.minWidth, 0, paramArrayOfObject, paramInt);
    if (this.minWidth == -1610612736)
      paramInt++;
    int j = getParam(this.colInc, 1, paramArrayOfObject, paramInt);
    if (this.colInc == -1610612736)
      paramInt++;
    int k = getParam(this.minPad, 0, paramArrayOfObject, paramInt);
    if (this.minPad == -1610612736)
      paramInt++;
    char c = getParam(this.padChar, ' ', paramArrayOfObject, paramInt);
    if (this.padChar == -1610612736)
      paramInt++;
    ReportFormat localReportFormat = this.base;
    int m = this.where;
    return PadFormat.format(localReportFormat, paramArrayOfObject, paramInt, paramWriter, c, i, j, k, m, paramFieldPosition);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispObjectFormat
 * JD-Core Version:    0.6.2
 */