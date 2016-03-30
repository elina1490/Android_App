package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class S64Vector extends SimpleVector
  implements Externalizable, Comparable
{
  protected static long[] empty = new long[0];
  long[] data;

  public S64Vector()
  {
    this.data = empty;
  }

  public S64Vector(int paramInt)
  {
    this.data = new long[paramInt];
    this.size = paramInt;
  }

  public S64Vector(int paramInt, long paramLong)
  {
    long[] arrayOfLong = new long[paramInt];
    this.data = arrayOfLong;
    this.size = paramInt;
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      arrayOfLong[paramInt] = paramLong;
    }
  }

  public S64Vector(Sequence paramSequence)
  {
    this.data = new long[paramSequence.size()];
    addAll(paramSequence);
  }

  public S64Vector(long[] paramArrayOfLong)
  {
    this.data = paramArrayOfLong;
    this.size = paramArrayOfLong.length;
  }

  protected void clearBuffer(int paramInt1, int paramInt2)
  {
    int j;
    for (int i = paramInt1; ; i = j)
    {
      paramInt2--;
      if (paramInt2 < 0)
        break;
      long[] arrayOfLong = this.data;
      j = i + 1;
      arrayOfLong[i] = 0L;
    }
  }

  public int compareTo(Object paramObject)
  {
    return compareToLong(this, (S64Vector)paramObject);
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    int i = paramInt >>> 1;
    if (i >= this.size)
      return false;
    paramConsumer.writeLong(this.data[i]);
    return true;
  }

  public void consumePosRange(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    if (paramConsumer.ignoring());
    while (true)
    {
      return;
      int i = paramInt1 >>> 1;
      int j = paramInt2 >>> 1;
      if (j > this.size)
        j = this.size;
      while (i < j)
      {
        paramConsumer.writeLong(this.data[i]);
        i++;
      }
    }
  }

  public final Object get(int paramInt)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
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

  public int getElementKind()
  {
    return 24;
  }

  public String getTag()
  {
    return "s64";
  }

  public final int intAtBuffer(int paramInt)
  {
    return (int)this.data[paramInt];
  }

  public final long longAt(int paramInt)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    return this.data[paramInt];
  }

  public final long longAtBuffer(int paramInt)
  {
    return this.data[paramInt];
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    long[] arrayOfLong = new long[i];
    for (int j = 0; j < i; j++)
      arrayOfLong[j] = paramObjectInput.readLong();
    this.data = arrayOfLong;
    this.size = i;
  }

  public Object setBuffer(int paramInt, Object paramObject)
  {
    long l = this.data[paramInt];
    this.data[paramInt] = Convert.toLong(paramObject);
    return Convert.toObject(l);
  }

  public void setBufferLength(int paramInt)
  {
    int i = this.data.length;
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    if (i != paramInt)
    {
      arrayOfLong1 = new long[paramInt];
      arrayOfLong2 = this.data;
      if (i >= paramInt)
        break label45;
    }
    label45: for (int j = i; ; j = paramInt)
    {
      System.arraycopy(arrayOfLong2, 0, arrayOfLong1, 0, j);
      this.data = arrayOfLong1;
      return;
    }
  }

  public final void setLongAt(int paramInt, long paramLong)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    this.data[paramInt] = paramLong;
  }

  public final void setLongAtBuffer(int paramInt, long paramLong)
  {
    this.data[paramInt] = paramLong;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i = this.size;
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++)
      paramObjectOutput.writeLong(this.data[j]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.S64Vector
 * JD-Core Version:    0.6.2
 */