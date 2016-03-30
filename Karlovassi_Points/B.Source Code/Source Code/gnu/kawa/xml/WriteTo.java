package gnu.kawa.xml;

import gnu.mapping.OutPort;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import gnu.text.Path;
import gnu.xml.XMLPrinter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteTo extends Procedure2
{
  public static final WriteTo writeTo = new WriteTo();
  public static final WriteTo writeToIfChanged = new WriteTo();
  boolean ifChanged;

  static
  {
    writeToIfChanged.ifChanged = true;
  }

  public static void writeTo(Object paramObject, Path paramPath, OutputStream paramOutputStream)
    throws Throwable
  {
    OutPort localOutPort = new OutPort(paramOutputStream, paramPath);
    XMLPrinter localXMLPrinter = new XMLPrinter(localOutPort, false);
    if ("html".equals(paramPath.getExtension()))
      localXMLPrinter.setStyle("html");
    Values.writeValues(paramObject, localXMLPrinter);
    localOutPort.close();
  }

  public static void writeTo(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    Path localPath = Path.valueOf(paramObject2);
    writeTo(paramObject1, localPath, localPath.openOutputStream());
  }

  public static void writeToIfChanged(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    Path localPath = Path.valueOf(paramObject2);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    writeTo(paramObject1, localPath, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(localPath.openInputStream());
      int i = 0;
      int j = localBufferedInputStream.read();
      int k;
      if (i == arrayOfByte.length)
        k = 1;
      while (true)
      {
        label62: localBufferedInputStream.close();
        label67: BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localPath.openOutputStream());
        localBufferedOutputStream.write(arrayOfByte);
        localBufferedOutputStream.close();
        return;
        k = 0;
        do
        {
          localBufferedInputStream.close();
          return;
          do
          {
            if (k == 0)
            {
              int m = i + 1;
              int n = arrayOfByte[i];
              if (n != j)
                break label62;
              i = m;
              break;
            }
            break label62;
          }
          while (j >= 0);
        }
        while (k != 0);
      }
    }
    catch (Throwable localThrowable)
    {
      break label67;
    }
  }

  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    if (this.ifChanged)
      writeToIfChanged(paramObject1, paramObject2.toString());
    while (true)
    {
      return Values.empty;
      writeTo(paramObject1, paramObject2.toString());
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.WriteTo
 * JD-Core Version:    0.6.2
 */