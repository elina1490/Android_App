package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class BitVector extends SimpleVector
  implements Externalizable
{
  protected static boolean[] empty = new boolean[0];
  boolean[] data;

  public BitVector()
  {
    this.data = empty;
  }

  public BitVector(int paramInt)
  {
    this.data = new boolean[paramInt];
    this.size = paramInt;
  }

  public BitVector(int paramInt, boolean paramBoolean)
  {
    boolean[] arrayOfBoolean = new boolean[paramInt];
    this.data = arrayOfBoolean;
    this.size = paramInt;
    if (paramBoolean)
      while (true)
      {
        paramInt--;
        if (paramInt < 0)
          break;
        arrayOfBoolean[paramInt] = true;
      }
  }

  public BitVector(Sequence paramSequence)
  {
    this.data = new boolean[paramSequence.size()];
    addAll(paramSequence);
  }

  public BitVector(boolean[] paramArrayOfBoolean)
  {
    this.data = paramArrayOfBoolean;
    this.size = paramArrayOfBoolean.length;
  }

  public final boolean booleanAt(int paramInt)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    return this.data[paramInt];
  }

  public final boolean booleanAtBuffer(int paramInt)
  {
    return this.data[paramInt];
  }

  protected void clearBuffer(int paramInt1, int paramInt2)
  {
    int j;
    for (int i = paramInt1; ; i = j)
    {
      paramInt2--;
      if (paramInt2 < 0)
        break;
      boolean[] arrayOfBoolean = this.data;
      j = i + 1;
      arrayOfBoolean[i] = false;
    }
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    int i = paramInt >>> 1;
    if (i >= this.size)
      return false;
    paramConsumer.writeBoolean(this.data[i]);
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
      while (i < j)
      {
        paramConsumer.writeBoolean(this.data[i]);
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
    return 27;
  }

  public String getTag()
  {
    return "b";
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    boolean[] arrayOfBoolean = new boolean[i];
    for (int j = 0; j < i; j++)
      arrayOfBoolean[j] = paramObjectInput.readBoolean();
    this.data = arrayOfBoolean;
    this.size = i;
  }

  public final void setBooleanAt(int paramInt, boolean paramBoolean)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    this.data[paramInt] = paramBoolean;
  }

  public final void setBooleanAtBuffer(int paramInt, boolean paramBoolean)
  {
    this.data[paramInt] = paramBoolean;
  }

  public Object setBuffer(int paramInt, Object paramObject)
  {
    int i = this.data[paramInt];
    this.data[paramInt] = Convert.toBoolean(paramObject);
    return Convert.toObject(i);
  }

  public void setBufferLength(int paramInt)
  {
    int i = this.data.length;
    boolean[] arrayOfBoolean1;
    boolean[] arrayOfBoolean2;
    if (i != paramInt)
    {
      arrayOfBoolean1 = new boolean[paramInt];
      arrayOfBoolean2 = this.data;
      if (i >= paramInt)
        break label45;
    }
    label45: for (int j = i; ; j = paramInt)
    {
      System.arraycopy(arrayOfBoolean2, 0, arrayOfBoolean1, 0, j);
      this.data = arrayOfBoolean1;
      return;
    }
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i = this.size;
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++)
      paramObjectOutput.writeBoolean(this.data[j]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.BitVector
 * JD-Core Version:    0.6.2
 */