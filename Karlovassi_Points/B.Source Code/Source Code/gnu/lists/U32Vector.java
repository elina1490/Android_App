package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class U32Vector extends SimpleVector
  implements Externalizable, Comparable
{
  int[] data;

  public U32Vector()
  {
    this.data = S32Vector.empty;
  }

  public U32Vector(int paramInt)
  {
    this.data = new int[paramInt];
    this.size = paramInt;
  }

  public U32Vector(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt1];
    this.data = arrayOfInt;
    this.size = paramInt1;
    while (true)
    {
      paramInt1--;
      if (paramInt1 < 0)
        break;
      arrayOfInt[paramInt1] = paramInt2;
    }
  }

  public U32Vector(Sequence paramSequence)
  {
    this.data = new int[paramSequence.size()];
    addAll(paramSequence);
  }

  public U32Vector(int[] paramArrayOfInt)
  {
    this.data = paramArrayOfInt;
    this.size = paramArrayOfInt.length;
  }

  protected void clearBuffer(int paramInt1, int paramInt2)
  {
    int j;
    for (int i = paramInt1; ; i = j)
    {
      paramInt2--;
      if (paramInt2 < 0)
        break;
      int[] arrayOfInt = this.data;
      j = i + 1;
      arrayOfInt[i] = 0;
    }
  }

  public int compareTo(Object paramObject)
  {
    return compareToLong(this, (U32Vector)paramObject);
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    int i = paramInt >>> 1;
    if (i >= this.size)
      return false;
    paramConsumer.writeInt(this.data[i]);
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
        paramConsumer.writeInt(this.data[i]);
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
    return "u32";
  }

  public final int intAtBuffer(int paramInt)
  {
    return this.data[paramInt];
  }

  public final long longAt(int paramInt)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    return longAtBuffer(paramInt);
  }

  public final long longAtBuffer(int paramInt)
  {
    return 0xFFFFFFFF & this.data[paramInt];
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++)
      arrayOfInt[j] = paramObjectInput.readInt();
    this.data = arrayOfInt;
    this.size = i;
  }

  public Object setBuffer(int paramInt, Object paramObject)
  {
    int i = this.data[paramInt];
    this.data[paramInt] = Convert.toIntUnsigned(paramObject);
    return Convert.toObjectUnsigned(i);
  }

  public void setBufferLength(int paramInt)
  {
    int i = this.data.length;
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    if (i != paramInt)
    {
      arrayOfInt1 = new int[paramInt];
      arrayOfInt2 = this.data;
      if (i >= paramInt)
        break label45;
    }
    label45: for (int j = i; ; j = paramInt)
    {
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, j);
      this.data = arrayOfInt1;
      return;
    }
  }

  public final void setIntAt(int paramInt1, int paramInt2)
  {
    if (paramInt1 > this.size)
      throw new IndexOutOfBoundsException();
    this.data[paramInt1] = paramInt2;
  }

  public final void setIntAtBuffer(int paramInt1, int paramInt2)
  {
    this.data[paramInt1] = paramInt2;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i = this.size;
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++)
      paramObjectOutput.writeInt(this.data[j]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.U32Vector
 * JD-Core Version:    0.6.2
 */