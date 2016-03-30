package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public abstract class ByteVector extends SimpleVector
  implements Externalizable, Comparable
{
  protected static byte[] empty = new byte[0];
  byte[] data;

  public final byte byteAt(int paramInt)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    return this.data[paramInt];
  }

  public final byte byteAtBuffer(int paramInt)
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
      byte[] arrayOfByte = this.data;
      j = i + 1;
      arrayOfByte[i] = 0;
    }
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    int i = paramInt >>> 1;
    if (i >= this.size)
      return false;
    paramConsumer.writeInt(intAtBuffer(i));
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
        paramConsumer.writeInt(intAtBuffer(i));
        i++;
      }
    }
  }

  protected Object getBuffer()
  {
    return this.data;
  }

  public int getBufferLength()
  {
    return this.data.length;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j < i; j++)
      arrayOfByte[j] = paramObjectInput.readByte();
    this.data = arrayOfByte;
    this.size = i;
  }

  public void setBufferLength(int paramInt)
  {
    int i = this.data.length;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    if (i != paramInt)
    {
      arrayOfByte1 = new byte[paramInt];
      arrayOfByte2 = this.data;
      if (i >= paramInt)
        break label45;
    }
    label45: for (int j = i; ; j = paramInt)
    {
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, j);
      this.data = arrayOfByte1;
      return;
    }
  }

  public final void setByteAt(int paramInt, byte paramByte)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    this.data[paramInt] = paramByte;
  }

  public final void setByteAtBuffer(int paramInt, byte paramByte)
  {
    this.data[paramInt] = paramByte;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i = this.size;
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++)
      paramObjectOutput.writeByte(this.data[j]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.ByteVector
 * JD-Core Version:    0.6.2
 */