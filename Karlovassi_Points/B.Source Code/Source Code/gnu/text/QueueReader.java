package gnu.text;

import gnu.lists.CharSeq;
import java.io.Reader;

public class QueueReader extends Reader
  implements Appendable
{
  boolean EOFseen;
  char[] buffer;
  int limit;
  int mark;
  int pos;
  int readAheadLimit;

  public QueueReader append(char paramChar)
  {
    try
    {
      reserveSpace(1);
      char[] arrayOfChar = this.buffer;
      int i = this.limit;
      this.limit = (i + 1);
      arrayOfChar[i] = paramChar;
      notifyAll();
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public QueueReader append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    return append(paramCharSequence, 0, paramCharSequence.length());
  }

  public QueueReader append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    int i = paramInt2 - paramInt1;
    while (true)
    {
      int j;
      char[] arrayOfChar;
      try
      {
        reserveSpace(i);
        j = this.limit;
        arrayOfChar = this.buffer;
        if ((paramCharSequence instanceof String))
        {
          ((String)paramCharSequence).getChars(paramInt1, paramInt2, arrayOfChar, j);
          this.limit = (j + i);
          notifyAll();
          return this;
        }
        if ((paramCharSequence instanceof CharSeq))
        {
          ((CharSeq)paramCharSequence).getChars(paramInt1, paramInt2, arrayOfChar, j);
          continue;
        }
      }
      finally
      {
      }
      int k = paramInt1;
      int n;
      for (int m = j; k < paramInt2; m = n)
      {
        n = m + 1;
        arrayOfChar[m] = paramCharSequence.charAt(k);
        k++;
      }
    }
  }

  public void append(char[] paramArrayOfChar)
  {
    append(paramArrayOfChar, 0, paramArrayOfChar.length);
  }

  public void append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    try
    {
      reserveSpace(paramInt2);
      System.arraycopy(paramArrayOfChar, paramInt1, this.buffer, this.limit, paramInt2);
      this.limit = (paramInt2 + this.limit);
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void appendEOF()
  {
    try
    {
      this.EOFseen = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void checkAvailable()
  {
  }

  public void close()
  {
    try
    {
      this.pos = 0;
      this.limit = 0;
      this.mark = 0;
      this.EOFseen = true;
      this.buffer = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void mark(int paramInt)
  {
    try
    {
      this.readAheadLimit = paramInt;
      this.mark = this.pos;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean markSupported()
  {
    return true;
  }

  public int read()
  {
    try
    {
      if (this.pos >= this.limit)
      {
        boolean bool = this.EOFseen;
        if (!bool);
      }
      int j;
      for (int k = -1; ; k = j)
      {
        while (true)
        {
          return k;
          checkAvailable();
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
          }
        }
        break;
        char[] arrayOfChar = this.buffer;
        int i = this.pos;
        this.pos = (i + 1);
        j = arrayOfChar[i];
      }
    }
    finally
    {
    }
  }

  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int j;
    if (paramInt2 == 0)
      j = 0;
    while (true)
    {
      return j;
      try
      {
        label14: checkAvailable();
        try
        {
          wait();
          label22: if (this.pos >= this.limit)
          {
            if (!this.EOFseen)
              break label14;
            j = -1;
            continue;
          }
          int i = this.limit - this.pos;
          if (paramInt2 > i)
            paramInt2 = i;
          System.arraycopy(this.buffer, this.pos, paramArrayOfChar, paramInt1, paramInt2);
          this.pos = (paramInt2 + this.pos);
          j = paramInt2;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label22;
        }
      }
      finally
      {
      }
    }
  }

  public boolean ready()
  {
    try
    {
      if (this.pos >= this.limit)
      {
        boolean bool2 = this.EOFseen;
        if (!bool2);
      }
      else
      {
        bool1 = true;
        return bool1;
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  protected void reserveSpace(int paramInt)
  {
    if (this.buffer == null)
      this.buffer = new char[paramInt + 100];
    while (this.buffer.length >= paramInt + this.limit)
      return;
    resize(paramInt);
  }

  public void reset()
  {
    try
    {
      if (this.readAheadLimit > 0)
        this.pos = this.mark;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void resize(int paramInt)
  {
    int i = this.limit - this.pos;
    if ((this.readAheadLimit > 0) && (this.pos - this.mark <= this.readAheadLimit))
    {
      i = this.limit - this.mark;
      if (this.buffer.length >= i + paramInt)
        break label116;
    }
    label116: for (char[] arrayOfChar = new char[paramInt + i * 2]; ; arrayOfChar = this.buffer)
    {
      System.arraycopy(this.buffer, this.mark, arrayOfChar, 0, i);
      this.buffer = arrayOfChar;
      this.pos -= this.mark;
      this.mark = 0;
      this.limit = i;
      return;
      this.mark = this.pos;
      break;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.QueueReader
 * JD-Core Version:    0.6.2
 */