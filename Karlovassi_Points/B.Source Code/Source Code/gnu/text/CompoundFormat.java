package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class CompoundFormat extends ReportFormat
{
  protected Format[] formats;
  protected int length;

  public CompoundFormat(Format[] paramArrayOfFormat)
  {
    this.formats = paramArrayOfFormat;
    this.length = paramArrayOfFormat.length;
  }

  public CompoundFormat(Format[] paramArrayOfFormat, int paramInt)
  {
    this.formats = paramArrayOfFormat;
    this.length = paramInt;
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int i = 0;
    if (i < this.length)
    {
      Format localFormat = this.formats[i];
      if ((localFormat instanceof ReportFormat))
      {
        paramInt = ((ReportFormat)localFormat).format(paramArrayOfObject, paramInt, paramWriter, paramFieldPosition);
        if (paramInt < 0)
          return paramInt;
      }
      else
      {
        if (paramInt < paramArrayOfObject.length)
          break label67;
        paramWriter.write("#<missing format argument>");
      }
      while (true)
      {
        i++;
        break;
        label67: StringBuffer localStringBuffer = new StringBuffer();
        localFormat.format(paramArrayOfObject[paramInt], localStringBuffer, paramFieldPosition);
        paramWriter.write(localStringBuffer.toString());
        paramInt++;
      }
    }
    return paramInt;
  }

  public final int format(Object[] paramArrayOfObject, int paramInt, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    for (int i = 0; i < this.length; i++)
    {
      Format localFormat = this.formats[i];
      if ((localFormat instanceof ReportFormat))
      {
        paramInt = ((ReportFormat)localFormat).format(paramArrayOfObject, paramInt, paramStringBuffer, paramFieldPosition);
        if (paramInt < 0)
          return paramInt;
      }
      else
      {
        localFormat.format(paramArrayOfObject[paramInt], paramStringBuffer, paramFieldPosition);
        paramInt++;
      }
    }
    return paramInt;
  }

  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    throw new Error("CompoundFormat.parseObject - not implemented");
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CompoundFormat[");
    for (int i = 0; i < this.length; i++)
    {
      if (i > 0)
        localStringBuffer.append(", ");
      localStringBuffer.append(this.formats[i]);
    }
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.CompoundFormat
 * JD-Core Version:    0.6.2
 */