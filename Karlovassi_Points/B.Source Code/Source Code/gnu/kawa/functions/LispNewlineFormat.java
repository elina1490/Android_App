package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.FieldPosition;

class LispNewlineFormat extends ReportFormat
{
  static final String line_separator = System.getProperty("line.separator", "\n");
  int count;
  int kind;

  public static LispNewlineFormat getInstance(int paramInt1, int paramInt2)
  {
    LispNewlineFormat localLispNewlineFormat = new LispNewlineFormat();
    localLispNewlineFormat.count = paramInt1;
    localLispNewlineFormat.kind = paramInt2;
    return localLispNewlineFormat;
  }

  public static void printNewline(int paramInt, Writer paramWriter)
    throws IOException
  {
    if (((paramWriter instanceof OutPort)) && (paramInt != 76))
    {
      ((OutPort)paramWriter).writeBreak(paramInt);
      return;
    }
    if ((paramWriter instanceof PrintWriter))
    {
      ((PrintWriter)paramWriter).println();
      return;
    }
    paramWriter.write(line_separator);
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int i = getParam(this.count, 1, paramArrayOfObject, paramInt);
    if (this.count == -1610612736)
      paramInt++;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      printNewline(this.kind, paramWriter);
    }
    return paramInt;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispNewlineFormat
 * JD-Core Version:    0.6.2
 */