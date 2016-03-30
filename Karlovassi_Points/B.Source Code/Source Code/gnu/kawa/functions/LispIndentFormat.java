package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispIndentFormat extends ReportFormat
{
  int columns;
  boolean current;

  public static LispIndentFormat getInstance(int paramInt, boolean paramBoolean)
  {
    LispIndentFormat localLispIndentFormat = new LispIndentFormat();
    localLispIndentFormat.columns = paramInt;
    localLispIndentFormat.current = paramBoolean;
    return localLispIndentFormat;
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int i = getParam(this.columns, 0, paramArrayOfObject, paramInt);
    if (this.columns == -1610612736)
      paramInt++;
    if ((paramWriter instanceof OutPort))
      ((OutPort)paramWriter).setIndentation(i, this.current);
    return paramInt;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispIndentFormat
 * JD-Core Version:    0.6.2
 */