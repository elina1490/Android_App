package gnu.lists;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.Writer;

public class CharBuffer extends StableVector
  implements CharSeq, Serializable
{
  private FString string;

  protected CharBuffer()
  {
  }

  public CharBuffer(int paramInt)
  {
    this(new FString(paramInt));
  }

  public CharBuffer(FString paramFString)
  {
    super(paramFString);
    this.string = paramFString;
  }

  public char charAt(int paramInt)
  {
    if (paramInt >= this.gapStart)
      paramInt += this.gapEnd - this.gapStart;
    return this.string.charAt(paramInt);
  }

  public void consume(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    char[] arrayOfChar = this.string.data;
    if (paramInt1 < this.gapStart)
    {
      int i = this.gapStart - paramInt1;
      if (i > paramInt2)
        i = paramInt2;
      paramConsumer.write(arrayOfChar, paramInt1, i);
      paramInt2 -= i;
      paramInt1 += paramInt2;
    }
    if (paramInt2 > 0)
      paramConsumer.write(arrayOfChar, paramInt1 + (this.gapEnd - this.gapStart), paramInt2);
  }

  public void delete(int paramInt1, int paramInt2)
  {
    int i = createPos(paramInt1, false);
    removePos(i, paramInt2);
    releasePos(i);
  }

  public void dump()
  {
    System.err.println("Buffer Content dump.  size:" + size() + "  buffer:" + getArray().length);
    System.err.print("before gap: \"");
    System.err.print(new String(getArray(), 0, this.gapStart));
    System.err.println("\" (gapStart:" + this.gapStart + " gapEnd:" + this.gapEnd + ')');
    System.err.print("after gap: \"");
    System.err.print(new String(getArray(), this.gapEnd, getArray().length - this.gapEnd));
    System.err.println("\"");
    if (this.positions == null);
    boolean[] arrayOfBoolean;
    for (int i = 0; ; i = this.positions.length)
    {
      System.err.println("Positions (size: " + i + " free:" + this.free + "):");
      int j = this.free;
      arrayOfBoolean = null;
      if (j == -2)
        break;
      arrayOfBoolean = new boolean[this.positions.length];
      for (int n = this.free; n >= 0; n = this.positions[n])
        arrayOfBoolean[n] = true;
    }
    int k = 0;
    if (k < i)
    {
      int m = this.positions[k];
      if (this.free == -2)
        if (m == -2);
      while (true)
      {
        System.err.println("position#" + k + ": " + (m >> 1) + " isAfter:" + (m & 0x1));
        do
        {
          k++;
          break;
        }
        while (arrayOfBoolean[k] != 0);
      }
    }
  }

  public final void fill(char paramChar)
  {
    char[] arrayOfChar = this.string.data;
    int i = arrayOfChar.length;
    while (true)
    {
      i--;
      if (i < this.gapEnd)
        break;
      arrayOfChar[i] = paramChar;
    }
    int j = this.gapStart;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      arrayOfChar[j] = paramChar;
    }
  }

  public void fill(int paramInt1, int paramInt2, char paramChar)
  {
    char[] arrayOfChar = this.string.data;
    int i = paramInt1;
    int j;
    if (this.gapStart < paramInt2)
      j = this.gapStart;
    while (i < j)
    {
      arrayOfChar[i] = paramChar;
      i++;
      continue;
      j = paramInt2;
    }
    int k = j + (this.gapEnd - this.gapStart);
    int m = j + paramInt2;
    while (k < m)
    {
      arrayOfChar[k] = paramChar;
      k++;
    }
  }

  public char[] getArray()
  {
    return (char[])this.base.getBuffer();
  }

  public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    char[] arrayOfChar = this.string.data;
    if (paramInt1 < this.gapStart)
      if (paramInt2 >= this.gapStart)
        break label106;
    label106: for (int m = paramInt2; ; m = this.gapStart)
    {
      int n = m - paramInt1;
      if (n > 0)
      {
        System.arraycopy(arrayOfChar, paramInt1, paramArrayOfChar, paramInt3, n);
        paramInt1 += n;
        paramInt3 += n;
      }
      int i = this.gapEnd - this.gapStart;
      int j = paramInt1 + i;
      int k = paramInt2 + i - j;
      if (k > 0)
        System.arraycopy(arrayOfChar, j, paramArrayOfChar, paramInt3, k);
      return;
    }
  }

  public int indexOf(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    char[] arrayOfChar;
    int k;
    int m;
    if (paramInt1 >= 65536)
    {
      i = (char)(55296 + (paramInt1 - 65536 >> 10));
      j = (char)(56320 + (paramInt1 & 0x3FF));
      arrayOfChar = getArray();
      k = paramInt2;
      m = this.gapStart;
      if (k >= m)
      {
        k += this.gapEnd - this.gapStart;
        m = arrayOfChar.length;
      }
    }
    while (true)
    {
      if (k == m)
      {
        m = arrayOfChar.length;
        if (k >= m)
          break label192;
        k = this.gapEnd;
      }
      if (arrayOfChar[k] == i)
      {
        if (j != 0)
        {
          if (k + 1 >= m)
            break label161;
          if (arrayOfChar[(k + 1)] != j)
            break label183;
        }
        label161: 
        while ((this.gapEnd < arrayOfChar.length) && (arrayOfChar[this.gapEnd] == j))
        {
          if (k <= this.gapStart)
            break label189;
          return k - (this.gapEnd - this.gapStart);
          i = (char)paramInt1;
          j = 0;
          break;
        }
      }
      label183: k++;
    }
    label189: return k;
    label192: return -1;
  }

  public void insert(int paramInt, String paramString, boolean paramBoolean)
  {
    int i = paramString.length();
    gapReserve(paramInt, i);
    paramString.getChars(0, i, this.string.data, paramInt);
    this.gapStart = (i + this.gapStart);
  }

  public int lastIndexOf(int paramInt1, int paramInt2)
  {
    int j;
    int i;
    int k;
    if (paramInt1 >= 65536)
    {
      j = (char)(55296 + (paramInt1 - 65536 >> 10));
      i = (char)(56320 + (paramInt1 & 0x3FF));
      k = paramInt2;
    }
    do
    {
      do
      {
        k--;
        if (k < 0)
          break;
      }
      while (charAt(k) != i);
      if (j == 0)
      {
        return k;
        i = (char)paramInt1;
        j = 0;
        break;
      }
    }
    while ((k <= 0) || (charAt(k - 1) != j));
    return k - 1;
    return -1;
  }

  public int length()
  {
    return size();
  }

  public void setCharAt(int paramInt, char paramChar)
  {
    if (paramInt >= this.gapStart)
      paramInt += this.gapEnd - this.gapStart;
    this.string.setCharAt(paramInt, paramChar);
  }

  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    int i = size();
    if ((paramInt1 < 0) || (paramInt2 < paramInt1) || (paramInt2 > i))
      throw new IndexOutOfBoundsException();
    return new SubCharSeq(this, this.base.createPos(paramInt1, false), this.base.createPos(paramInt2, true));
  }

  public String substring(int paramInt1, int paramInt2)
  {
    int i = size();
    if ((paramInt1 < 0) || (paramInt2 < paramInt1) || (paramInt2 > i))
      throw new IndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = getSegment(paramInt1, j);
    return new String(getArray(), k, j);
  }

  public String toString()
  {
    int i = size();
    int j = getSegment(0, i);
    return new String(getArray(), j, i);
  }

  public void writeTo(int paramInt1, int paramInt2, Writer paramWriter)
    throws IOException
  {
    char[] arrayOfChar = this.string.data;
    if (paramInt1 < this.gapStart)
    {
      int i = this.gapStart - paramInt1;
      if (i > paramInt2)
        i = paramInt2;
      paramWriter.write(arrayOfChar, paramInt1, i);
      paramInt2 -= i;
      paramInt1 += paramInt2;
    }
    if (paramInt2 > 0)
      paramWriter.write(arrayOfChar, paramInt1 + (this.gapEnd - this.gapStart), paramInt2);
  }

  public void writeTo(int paramInt1, int paramInt2, Appendable paramAppendable)
    throws IOException
  {
    if ((paramAppendable instanceof Writer))
    {
      writeTo(paramInt1, paramInt2, (Writer)paramAppendable);
      return;
    }
    paramAppendable.append(this, paramInt1, paramInt1 + paramInt2);
  }

  public void writeTo(Writer paramWriter)
    throws IOException
  {
    char[] arrayOfChar = this.string.data;
    paramWriter.write(arrayOfChar, 0, this.gapStart);
    paramWriter.write(arrayOfChar, this.gapEnd, arrayOfChar.length - this.gapEnd);
  }

  public void writeTo(Appendable paramAppendable)
    throws IOException
  {
    writeTo(0, size(), paramAppendable);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.CharBuffer
 * JD-Core Version:    0.6.2
 */