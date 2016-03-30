package kawa.standard;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class char_ready_p
{
  public static boolean ready(Object paramObject)
  {
    try
    {
      if ((paramObject instanceof InputStream))
      {
        if (((InputStream)paramObject).available() > 0)
          return true;
      }
      else
      {
        if ((paramObject instanceof Reader))
          return ((Reader)paramObject).ready();
        throw new ClassCastException("invalid argument to char-ready?");
      }
    }
    catch (IOException localIOException)
    {
      return false;
    }
    return false;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.char_ready_p
 * JD-Core Version:    0.6.2
 */