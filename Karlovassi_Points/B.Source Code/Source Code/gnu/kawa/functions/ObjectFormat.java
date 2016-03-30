package gnu.kawa.functions;

import gnu.lists.AbstractFormat;
import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.ParsePosition;
import kawa.standard.Scheme;

public class ObjectFormat extends ReportFormat
{
  private static ObjectFormat plainFormat;
  private static ObjectFormat readableFormat;
  int maxChars;
  boolean readable;

  public ObjectFormat(boolean paramBoolean)
  {
    this.readable = paramBoolean;
    this.maxChars = -1073741824;
  }

  public ObjectFormat(boolean paramBoolean, int paramInt)
  {
    this.readable = paramBoolean;
    this.maxChars = paramInt;
  }

  public static int format(Object[] paramArrayOfObject, int paramInt1, Writer paramWriter, int paramInt2, boolean paramBoolean)
    throws IOException
  {
    Object localObject;
    if (paramInt1 >= paramArrayOfObject.length)
    {
      localObject = "#<missing format argument>";
      paramInt1--;
      paramBoolean = false;
      paramInt2 = -1;
    }
    while (true)
    {
      format(localObject, paramWriter, paramInt2, paramBoolean);
      return paramInt1 + 1;
      localObject = paramArrayOfObject[paramInt1];
    }
  }

  public static boolean format(Object paramObject, Writer paramWriter, int paramInt, boolean paramBoolean)
    throws IOException
  {
    if ((paramInt < 0) && ((paramWriter instanceof OutPort)))
    {
      print(paramObject, (OutPort)paramWriter, paramBoolean);
      return true;
    }
    if ((paramInt < 0) && ((paramWriter instanceof CharArrayWriter)))
    {
      OutPort localOutPort2 = new OutPort(paramWriter);
      print(paramObject, localOutPort2, paramBoolean);
      localOutPort2.close();
      return true;
    }
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    OutPort localOutPort1 = new OutPort(localCharArrayWriter);
    print(paramObject, localOutPort1, paramBoolean);
    localOutPort1.close();
    int i = localCharArrayWriter.size();
    if ((paramInt < 0) || (i <= paramInt))
    {
      localCharArrayWriter.writeTo(paramWriter);
      return true;
    }
    paramWriter.write(localCharArrayWriter.toCharArray(), 0, paramInt);
    return false;
  }

  public static ObjectFormat getInstance(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (readableFormat == null)
        readableFormat = new ObjectFormat(true);
      return readableFormat;
    }
    if (plainFormat == null)
      plainFormat = new ObjectFormat(false);
    return plainFormat;
  }

  private static void print(Object paramObject, OutPort paramOutPort, boolean paramBoolean)
  {
    boolean bool = paramOutPort.printReadable;
    AbstractFormat localAbstractFormat1 = paramOutPort.objectFormat;
    try
    {
      paramOutPort.printReadable = paramBoolean;
      if (paramBoolean);
      AbstractFormat localAbstractFormat2;
      for (Object localObject2 = Scheme.writeFormat; ; localObject2 = localAbstractFormat2)
      {
        paramOutPort.objectFormat = ((AbstractFormat)localObject2);
        ((AbstractFormat)localObject2).writeObject(paramObject, paramOutPort);
        return;
        localAbstractFormat2 = Scheme.displayFormat;
      }
    }
    finally
    {
      paramOutPort.printReadable = bool;
      paramOutPort.objectFormat = localAbstractFormat1;
    }
  }

  public int format(Object[] paramArrayOfObject, int paramInt, Writer paramWriter, FieldPosition paramFieldPosition)
    throws IOException
  {
    int i = getParam(this.maxChars, -1, paramArrayOfObject, paramInt);
    if (this.maxChars == -1610612736)
      paramInt++;
    return format(paramArrayOfObject, paramInt, paramWriter, i, this.readable);
  }

  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    throw new RuntimeException("ObjectFormat.parseObject - not implemented");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.ObjectFormat
 * JD-Core Version:    0.6.2
 */