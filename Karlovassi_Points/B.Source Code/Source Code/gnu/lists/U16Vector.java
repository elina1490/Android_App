package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class U16Vector extends SimpleVector
  implements Externalizable, Comparable
{
  short[] data;

  public U16Vector()
  {
    this.data = S16Vector.empty;
  }

  public U16Vector(int paramInt)
  {
    this.data = new short[paramInt];
    this.size = paramInt;
  }

  public U16Vector(int paramInt, short paramShort)
  {
    short[] arrayOfShort = new short[paramInt];
    this.data = arrayOfShort;
    this.size = paramInt;
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      arrayOfShort[paramInt] = paramShort;
    }
  }

  public U16Vector(Sequence paramSequence)
  {
    this.data = new short[paramSequence.size()];
    addAll(paramSequence);
  }

  public U16Vector(short[] paramArrayOfShort)
  {
    this.data = paramArrayOfShort;
    this.size = paramArrayOfShort.length;
  }

  protected void clearBuffer(int paramInt1, int paramInt2)
  {
    int j;
    for (int i = paramInt1; ; i = j)
    {
      paramInt2--;
      if (paramInt2 < 0)
        break;
      short[] arrayOfShort = this.data;
      j = i + 1;
      arrayOfShort[i] = 0;
    }
  }

  public int compareTo(Object paramObject)
  {
    return compareToInt(this, (U16Vector)paramObject);
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    int i = paramInt >>> 1;
    if (i >= this.size)
      return false;
    paramConsumer.writeInt(0xFFFF & this.data[i]);
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
        paramConsumer.writeInt(0xFFFF & this.data[i]);
        i++;
      }
    }
  }

  public final Object get(int paramInt)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    return Convert.toObjectUnsigned(this.data[paramInt]);
  }

  protected Object getBuffer()
  {
    return this.data;
  }

  public final Object getBuffer(int paramInt)
  {
    return Convert.toObjectUnsigned(this.data[paramInt]);
  }

  public int getBufferLength()
  {
    return this.data.length;
  }

  public int getElementKind()
  {
    return 19;
  }

  public String getTag()
  {
    return "u16";
  }

  public final int intAtBuffer(int paramInt)
  {
    return 0xFFFF & this.data[paramInt];
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    short[] arrayOfShort = new short[i];
    for (int j = 0; j < i; j++)
      arrayOfShort[j] = paramObjectInput.readShort();
    this.data = arrayOfShort;
    this.size = i;
  }

  public Object setBuffer(int paramInt, Object paramObject)
  {
    short s = this.data[paramInt];
    this.data[paramInt] = Convert.toShortUnsigned(paramObject);
    return Convert.toObjectUnsigned(s);
  }

  public void setBufferLength(int paramInt)
  {
    int i = this.data.length;
    short[] arrayOfShort1;
    short[] arrayOfShort2;
    if (i != paramInt)
    {
      arrayOfShort1 = new short[paramInt];
      arrayOfShort2 = this.data;
      if (i >= paramInt)
        break label45;
    }
    label45: for (int j = i; ; j = paramInt)
    {
      System.arraycopy(arrayOfShort2, 0, arrayOfShort1, 0, j);
      this.data = arrayOfShort1;
      return;
    }
  }

  public final void setShortAt(int paramInt, short paramShort)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    this.data[paramInt] = paramShort;
  }

  public final void setShortAtBuffer(int paramInt, short paramShort)
  {
    this.data[paramInt] = paramShort;
  }

  public final short shortAt(int paramInt)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    return this.data[paramInt];
  }

  public final short shortAtBuffer(int paramInt)
  {
    return this.data[paramInt];
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i = this.size;
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++)
      paramObjectOutput.writeShort(this.data[j]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.U16Vector
 * JD-Core Version:    0.6.2
 */