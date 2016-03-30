package gnu.lists;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class PrintConsumer extends PrintWriter
  implements Appendable, Consumer
{
  public PrintConsumer(Consumer paramConsumer, boolean paramBoolean)
  {
  }

  public PrintConsumer(OutputStream paramOutputStream, boolean paramBoolean)
  {
    super(paramOutputStream, paramBoolean);
  }

  public PrintConsumer(Writer paramWriter)
  {
    super(paramWriter);
  }

  public PrintConsumer(Writer paramWriter, boolean paramBoolean)
  {
    super(paramWriter, paramBoolean);
  }

  public PrintConsumer append(char paramChar)
  {
    print(paramChar);
    return this;
  }

  public PrintConsumer append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    append(paramCharSequence, 0, paramCharSequence.length());
    return this;
  }

  public PrintConsumer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    for (int i = paramInt1; i < paramInt2; i++)
      append(paramCharSequence.charAt(i));
    return this;
  }

  public void endAttribute()
  {
  }

  public void endDocument()
  {
  }

  public void endElement()
  {
  }

  protected void endNumber()
  {
  }

  public boolean ignoring()
  {
    return false;
  }

  public void startAttribute(Object paramObject)
  {
  }

  public void startDocument()
  {
  }

  public void startElement(Object paramObject)
  {
  }

  protected void startNumber()
  {
  }

  public void write(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence instanceof String))
      write((String)paramCharSequence, paramInt1, paramInt2);
    while (true)
    {
      return;
      for (int i = paramInt1; i < paramInt2; i++)
        write(paramCharSequence.charAt(i));
    }
  }

  public void writeBoolean(boolean paramBoolean)
  {
    print(paramBoolean);
  }

  public void writeDouble(double paramDouble)
  {
    startNumber();
    print(paramDouble);
    endNumber();
  }

  public void writeFloat(float paramFloat)
  {
    startNumber();
    print(paramFloat);
    endNumber();
  }

  public void writeInt(int paramInt)
  {
    startNumber();
    print(paramInt);
    endNumber();
  }

  public void writeLong(long paramLong)
  {
    startNumber();
    print(paramLong);
    endNumber();
  }

  public void writeObject(Object paramObject)
  {
    print(paramObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.PrintConsumer
 * JD-Core Version:    0.6.2
 */