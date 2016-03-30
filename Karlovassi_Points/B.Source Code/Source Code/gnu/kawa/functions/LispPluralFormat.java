package gnu.kawa.functions;

import gnu.math.IntNum;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispPluralFormat extends ReportFormat
{
  boolean backup;
  boolean y;

  public static LispPluralFormat getInstance(boolean paramBoolean1, boolean paramBoolean2)
  {
    LispPluralFormat localLispPluralFormat = new LispPluralFormat();
    localLispPluralFormat.backup = paramBoolean1;
    localLispPluralFormat.y = paramBoolean2;
    return localLispPluralFormat;
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    if (this.backup)
      paramInt--;
    int i = paramInt + 1;
    int j;
    if (paramArrayOfObject[paramInt] != IntNum.one())
    {
      j = 1;
      if (!this.y)
        break label65;
      if (j == 0)
        break label58;
      str = "ies";
      print(paramWriter, str);
    }
    label58: label65: 
    while (j == 0)
      while (true)
      {
        return i;
        j = 0;
        break;
        String str = "y";
      }
    paramWriter.write(115);
    return i;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispPluralFormat
 * JD-Core Version:    0.6.2
 */