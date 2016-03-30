package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Writer;

public class FString extends SimpleVector
  implements Comparable, Appendable, CharSeq, Externalizable, Consumable
{
  protected static char[] empty = new char[0];
  public char[] data;

  public FString()
  {
    this.data = empty;
  }

  public FString(int paramInt)
  {
    this.size = paramInt;
    this.data = new char[paramInt];
  }

  public FString(int paramInt, char paramChar)
  {
    char[] arrayOfChar = new char[paramInt];
    this.data = arrayOfChar;
    this.size = paramInt;
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      arrayOfChar[paramInt] = paramChar;
    }
  }

  public FString(CharSeq paramCharSeq)
  {
    this(paramCharSeq, 0, paramCharSeq.size());
  }

  public FString(CharSeq paramCharSeq, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    paramCharSeq.getChars(paramInt1, paramInt1 + paramInt2, arrayOfChar, 0);
    this.data = arrayOfChar;
    this.size = paramInt2;
  }

  public FString(Sequence paramSequence)
  {
    this.data = new char[paramSequence.size()];
    addAll(paramSequence);
  }

  public FString(CharSequence paramCharSequence)
  {
    this(paramCharSequence, 0, paramCharSequence.length());
  }

  public FString(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    int i = paramInt2;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      arrayOfChar[i] = paramCharSequence.charAt(paramInt1 + i);
    }
    this.data = arrayOfChar;
    this.size = paramInt2;
  }

  public FString(String paramString)
  {
    this.data = paramString.toCharArray();
    this.size = this.data.length;
  }

  public FString(StringBuffer paramStringBuffer)
  {
    this(paramStringBuffer, 0, paramStringBuffer.length());
  }

  public FString(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    this.size = paramInt2;
    this.data = new char[paramInt2];
    if (paramInt2 > 0)
      paramStringBuffer.getChars(paramInt1, paramInt1 + paramInt2, this.data, 0);
  }

  public FString(char[] paramArrayOfChar)
  {
    this.size = paramArrayOfChar.length;
    this.data = paramArrayOfChar;
  }

  public FString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.size = paramInt2;
    this.data = new char[paramInt2];
    System.arraycopy(paramArrayOfChar, paramInt1, this.data, 0, paramInt2);
  }

  public boolean addAll(FString paramFString)
  {
    int i = this.size + paramFString.size;
    if (this.data.length < i)
      setBufferLength(i);
    System.arraycopy(paramFString.data, 0, this.data, this.size, paramFString.size);
    this.size = i;
    return paramFString.size > 0;
  }

  public boolean addAll(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    int j = i + this.size;
    if (this.data.length < j)
      setBufferLength(j);
    if ((paramCharSequence instanceof FString))
      System.arraycopy(((FString)paramCharSequence).data, 0, this.data, this.size, i);
    while (true)
    {
      this.size = j;
      if (i <= 0)
        break;
      return true;
      if ((paramCharSequence instanceof String))
      {
        ((String)paramCharSequence).getChars(0, i, this.data, this.size);
      }
      else if ((paramCharSequence instanceof CharSeq))
      {
        ((CharSeq)paramCharSequence).getChars(0, i, this.data, this.size);
      }
      else
      {
        int k = i;
        while (true)
        {
          k--;
          if (k < 0)
            break;
          this.data[(k + this.size)] = paramCharSequence.charAt(k);
        }
      }
    }
    return false;
  }

  public void addAllStrings(Object[] paramArrayOfObject, int paramInt)
  {
    int i = this.size;
    for (int j = paramInt; j < paramArrayOfObject.length; j++)
      i += ((CharSequence)paramArrayOfObject[j]).length();
    if (this.data.length < i)
      setBufferLength(i);
    for (int k = paramInt; k < paramArrayOfObject.length; k++)
      addAll((CharSequence)paramArrayOfObject[k]);
  }

  public FString append(char paramChar)
  {
    int i = this.size;
    if (i >= this.data.length)
      ensureBufferLength(i + 1);
    this.data[i] = paramChar;
    this.size = (i + 1);
    return this;
  }

  public FString append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    return append(paramCharSequence, 0, paramCharSequence.length());
  }

  public FString append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    int i = paramInt2 - paramInt1;
    int j = this.size;
    if (j + i > this.data.length)
      ensureBufferLength(j + i);
    char[] arrayOfChar = this.data;
    if ((paramCharSequence instanceof String))
      ((String)paramCharSequence).getChars(paramInt1, paramInt2, arrayOfChar, j);
    while (true)
    {
      this.size = j;
      return this;
      if ((paramCharSequence instanceof CharSeq))
      {
        ((CharSeq)paramCharSequence).getChars(paramInt1, paramInt2, arrayOfChar, j);
      }
      else
      {
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
  }

  public final char charAt(int paramInt)
  {
    if (paramInt >= this.size)
      throw new StringIndexOutOfBoundsException(paramInt);
    return this.data[paramInt];
  }

  public final char charAtBuffer(int paramInt)
  {
    return this.data[paramInt];
  }

  protected void clearBuffer(int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = this.data;
    int j;
    for (int i = paramInt1; ; i = j)
    {
      paramInt2--;
      if (paramInt2 < 0)
        break;
      j = i + 1;
      arrayOfChar[i] = '\000';
    }
  }

  public int compareTo(Object paramObject)
  {
    FString localFString = (FString)paramObject;
    char[] arrayOfChar1 = this.data;
    char[] arrayOfChar2 = localFString.data;
    int i = this.size;
    int j = localFString.size;
    int k;
    if (i > j)
      k = j;
    for (int m = 0; ; m++)
    {
      if (m >= k)
        break label82;
      int n = arrayOfChar1[m] - arrayOfChar2[m];
      if (n != 0)
      {
        return n;
        k = i;
        break;
      }
    }
    label82: return i - j;
  }

  public void consume(Consumer paramConsumer)
  {
    paramConsumer.write(this.data, 0, this.data.length);
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    int i = paramInt >>> 1;
    if (i >= this.size)
      return false;
    paramConsumer.write(this.data[i]);
    return true;
  }

  public void consumePosRange(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    if (paramConsumer.ignoring());
    int i;
    int j;
    do
    {
      return;
      i = paramInt1 >>> 1;
      j = paramInt2 >>> 1;
      if (j > this.size)
        j = this.size;
    }
    while (j <= i);
    paramConsumer.write(this.data, i, j - i);
  }

  public FString copy(int paramInt1, int paramInt2)
  {
    char[] arrayOfChar1 = new char[paramInt2 - paramInt1];
    char[] arrayOfChar2 = this.data;
    for (int i = paramInt1; i < paramInt2; i++)
      arrayOfChar1[(i - paramInt1)] = arrayOfChar2[i];
    return new FString(arrayOfChar1);
  }

  public void ensureBufferLength(int paramInt)
  {
    if (paramInt > this.data.length)
      if (paramInt >= 60)
        break label39;
    label39: for (int i = 120; ; i = paramInt * 2)
    {
      char[] arrayOfChar = new char[i];
      System.arraycopy(this.data, 0, arrayOfChar, 0, paramInt);
      this.data = arrayOfChar;
      return;
    }
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof FString)))
      return false;
    char[] arrayOfChar1 = ((FString)paramObject).data;
    int i = this.size;
    if ((arrayOfChar1 == null) || (arrayOfChar1.length != i))
      return false;
    char[] arrayOfChar2 = this.data;
    int j = i;
    do
    {
      j--;
      if (j < 0)
        break;
    }
    while (arrayOfChar2[j] == arrayOfChar1[j]);
    return false;
    return true;
  }

  public final void fill(char paramChar)
  {
    char[] arrayOfChar = this.data;
    int i = this.size;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      arrayOfChar[i] = paramChar;
    }
  }

  public void fill(int paramInt1, int paramInt2, char paramChar)
  {
    if ((paramInt1 < 0) || (paramInt2 > this.size))
      throw new IndexOutOfBoundsException();
    char[] arrayOfChar = this.data;
    for (int i = paramInt1; i < paramInt2; i++)
      arrayOfChar[i] = paramChar;
  }

  public final Object get(int paramInt)
  {
    if (paramInt >= this.size)
      throw new ArrayIndexOutOfBoundsException();
    return Convert.toObject(this.data[paramInt]);
  }

  protected Object getBuffer()
  {
    return this.data;
  }

  public final Object getBuffer(int paramInt)
  {
    return Convert.toObject(this.data[paramInt]);
  }

  public int getBufferLength()
  {
    return this.data.length;
  }

  public void getChars(int paramInt1, int paramInt2, StringBuffer paramStringBuffer)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt2))
      throw new StringIndexOutOfBoundsException(paramInt1);
    if (paramInt2 > this.size)
      throw new StringIndexOutOfBoundsException(paramInt2);
    if (paramInt1 < paramInt2)
      paramStringBuffer.append(this.data, paramInt1, paramInt2 - paramInt1);
  }

  public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramInt2))
      throw new StringIndexOutOfBoundsException(paramInt1);
    if (paramInt2 > this.size)
      throw new StringIndexOutOfBoundsException(paramInt2);
    if (paramInt3 + paramInt2 - paramInt1 > paramArrayOfChar.length)
      throw new StringIndexOutOfBoundsException(paramInt3);
    if (paramInt1 < paramInt2)
      System.arraycopy(this.data, paramInt1, paramArrayOfChar, paramInt3, paramInt2 - paramInt1);
  }

  public void getChars(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.data, 0, this.size);
  }

  public int getElementKind()
  {
    return 29;
  }

  public int hashCode()
  {
    char[] arrayOfChar = this.data;
    int i = this.size;
    int j = 0;
    for (int k = 0; k < i; k++)
      j = j * 31 + arrayOfChar[k];
    return j;
  }

  public int length()
  {
    return this.size;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    char[] arrayOfChar = new char[i];
    for (int j = 0; j < i; j++)
      arrayOfChar[j] = paramObjectInput.readChar();
    this.data = arrayOfChar;
    this.size = i;
  }

  public void replace(int paramInt, String paramString)
  {
    paramString.getChars(0, paramString.length(), this.data, paramInt);
  }

  public void replace(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfChar, paramInt2, this.data, paramInt1, paramInt3);
  }

  public final Object setBuffer(int paramInt, Object paramObject)
  {
    Object localObject = Convert.toObject(this.data[paramInt]);
    this.data[paramInt] = Convert.toChar(paramObject);
    return localObject;
  }

  public void setBufferLength(int paramInt)
  {
    int i = this.data.length;
    char[] arrayOfChar1;
    char[] arrayOfChar2;
    if (i != paramInt)
    {
      arrayOfChar1 = new char[paramInt];
      arrayOfChar2 = this.data;
      if (i >= paramInt)
        break label45;
    }
    label45: for (int j = i; ; j = paramInt)
    {
      System.arraycopy(arrayOfChar2, 0, arrayOfChar1, 0, j);
      this.data = arrayOfChar1;
      return;
    }
  }

  public void setCharAt(int paramInt, char paramChar)
  {
    if ((paramInt < 0) || (paramInt >= this.size))
      throw new StringIndexOutOfBoundsException(paramInt);
    this.data[paramInt] = paramChar;
  }

  public void setCharAtBuffer(int paramInt, char paramChar)
  {
    this.data[paramInt] = paramChar;
  }

  public void shift(int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.data, paramInt1, this.data, paramInt2, paramInt3);
  }

  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return new FString(this.data, paramInt1, paramInt2 - paramInt1);
  }

  public String substring(int paramInt1, int paramInt2)
  {
    return new String(this.data, paramInt1, paramInt2 - paramInt1);
  }

  public char[] toCharArray()
  {
    int i = this.data.length;
    int j = this.size;
    if (j == i)
      return this.data;
    char[] arrayOfChar = new char[j];
    System.arraycopy(this.data, 0, arrayOfChar, 0, j);
    return arrayOfChar;
  }

  public String toString()
  {
    return new String(this.data, 0, this.size);
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i = this.size;
    paramObjectOutput.writeInt(i);
    char[] arrayOfChar = this.data;
    for (int j = 0; j < i; j++)
      paramObjectOutput.writeChar(arrayOfChar[j]);
  }

  public void writeTo(int paramInt1, int paramInt2, Appendable paramAppendable)
    throws IOException
  {
    if ((paramAppendable instanceof Writer))
      try
      {
        ((Writer)paramAppendable).write(this.data, paramInt1, paramInt2);
        return;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
    paramAppendable.append(this, paramInt1, paramInt1 + paramInt2);
  }

  public void writeTo(Appendable paramAppendable)
    throws IOException
  {
    writeTo(0, this.size, paramAppendable);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.FString
 * JD-Core Version:    0.6.2
 */