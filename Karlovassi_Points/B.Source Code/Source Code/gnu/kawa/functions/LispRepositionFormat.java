package gnu.kawa.functions;

import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispRepositionFormat extends ReportFormat
{
  boolean absolute;
  boolean backwards;
  int count;

  public LispRepositionFormat(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.count = paramInt;
    this.backwards = paramBoolean1;
    this.absolute = paramBoolean2;
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int i = this.count;
    if (this.absolute);
    int k;
    for (int j = 0; ; j = 1)
    {
      k = getParam(i, j, paramArrayOfObject, paramInt);
      if (!this.absolute)
      {
        if (this.backwards)
          k = -k;
        k += paramInt;
      }
      if (k >= 0)
        break;
      return 0;
    }
    if (k > paramArrayOfObject.length)
      return paramArrayOfObject.length;
    return k;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispRepositionFormat
 * JD-Core Version:    0.6.2
 */