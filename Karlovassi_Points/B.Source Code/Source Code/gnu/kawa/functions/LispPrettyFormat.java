package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;

class LispPrettyFormat extends ReportFormat
{
  Format body;
  boolean perLine;
  String prefix;
  boolean seenAt;
  Format[] segments;
  String suffix;

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    Object localObject1 = this.prefix;
    String str = this.suffix;
    OutPort localOutPort;
    if ((paramWriter instanceof OutPort))
      localOutPort = (OutPort)paramWriter;
    while (true)
    {
      try
      {
        if (this.seenAt)
        {
          if (localOutPort != null)
            localOutPort.startLogicalBlock((String)localObject1, this.perLine, this.suffix);
          int i = ReportFormat.format(this.body, paramArrayOfObject, paramInt, paramWriter, paramFieldPosition);
          j = i;
          return j;
          localOutPort = null;
          continue;
        }
        Object localObject3 = paramArrayOfObject[paramInt];
        Object[] arrayOfObject = LispFormat.asArray(localObject3);
        if (arrayOfObject == null)
        {
          str = "";
          localObject1 = str;
        }
        if (localOutPort != null)
          localOutPort.startLogicalBlock((String)localObject1, this.perLine, this.suffix);
        if (arrayOfObject == null)
          ObjectFormat.format(localObject3, paramWriter, -1, true);
        else
          ReportFormat.format(this.body, arrayOfObject, 0, paramWriter, paramFieldPosition);
      }
      finally
      {
        if (localOutPort != null)
          localOutPort.endLogicalBlock(str);
      }
      int j = paramInt + 1;
    }
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("LispPrettyFormat[");
    localStringBuffer.append("prefix: \"");
    localStringBuffer.append(this.prefix);
    localStringBuffer.append("\", suffix: \"");
    localStringBuffer.append(this.suffix);
    localStringBuffer.append("\", body: ");
    localStringBuffer.append(this.body);
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.LispPrettyFormat
 * JD-Core Version:    0.6.2
 */