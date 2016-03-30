package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispFreshlineFormat extends ReportFormat
{
  int count;

  public LispFreshlineFormat(int paramInt)
  {
    this.count = paramInt;
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int i = getParam(this.count, 1, paramArrayOfObject, paramInt);
    if (this.count == -1610612736)
      paramInt++;
    if (i > 0)
    {
      if ((paramWriter instanceof OutPort))
      {
        ((OutPort)paramWriter).freshLine();
        i--;
      }
      while (true)
      {
        i--;
        if (i < 0)
          break;
        paramWriter.write(10);
      }
    }
    return paramInt;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispFreshlineFormat
 * JD-Core Version:    0.6.2
 */