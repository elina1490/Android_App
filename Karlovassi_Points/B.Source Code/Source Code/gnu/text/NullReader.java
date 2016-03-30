package gnu.text;

import java.io.Reader;

public class NullReader extends Reader
{
  public static final NullReader nullReader = new NullReader();

  public void close()
  {
  }

  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return -1;
  }

  public boolean ready()
  {
    return true;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.NullReader
 * JD-Core Version:    0.6.2
 */