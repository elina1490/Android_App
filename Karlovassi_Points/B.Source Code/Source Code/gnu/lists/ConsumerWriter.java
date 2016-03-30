package gnu.lists;

import java.io.Writer;

public class ConsumerWriter extends Writer
{
  protected Consumer out;

  public ConsumerWriter(Consumer paramConsumer)
  {
    this.out = paramConsumer;
  }

  public void close()
  {
    flush();
  }

  public void finalize()
  {
    close();
  }

  public void flush()
  {
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.out.write(paramArrayOfChar, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.ConsumerWriter
 * JD-Core Version:    0.6.2
 */