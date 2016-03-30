package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class MiscAttr extends Attribute
{
  byte[] data;
  int dataLength;
  int offset;

  public MiscAttr(String paramString, byte[] paramArrayOfByte)
  {
    this(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public MiscAttr(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.data = paramArrayOfByte;
    this.offset = paramInt1;
    this.dataLength = paramInt2;
  }

  public int getLength()
  {
    return this.dataLength;
  }

  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    super.print(paramClassTypeWriter);
    int i = getLength();
    int j = 0;
    while (j < i)
    {
      int k = this.data[j];
      if (j % 20 == 0)
        paramClassTypeWriter.print(' ');
      paramClassTypeWriter.print(' ');
      paramClassTypeWriter.print(Character.forDigit(0xF & k >> 4, 16));
      paramClassTypeWriter.print(Character.forDigit(k & 0xF, 16));
      j++;
      if ((j % 20 == 0) || (j == i))
        paramClassTypeWriter.println();
    }
  }

  protected void put1(int paramInt)
  {
    if (this.data == null)
      this.data = new byte[20];
    while (true)
    {
      byte[] arrayOfByte2 = this.data;
      int i = this.dataLength;
      this.dataLength = (i + 1);
      arrayOfByte2[i] = ((byte)paramInt);
      return;
      if (this.dataLength >= this.data.length)
      {
        byte[] arrayOfByte1 = new byte[2 * this.data.length];
        System.arraycopy(this.data, 0, arrayOfByte1, 0, this.dataLength);
        this.data = arrayOfByte1;
      }
    }
  }

  protected void put2(int paramInt)
  {
    put1((byte)(paramInt >> 8));
    put1((byte)paramInt);
  }

  protected void put2(int paramInt1, int paramInt2)
  {
    this.data[paramInt1] = ((byte)(paramInt2 >> 8));
    this.data[(paramInt1 + 1)] = ((byte)paramInt2);
  }

  protected int u1()
  {
    int i = this.offset;
    this.offset = (i + 1);
    return u1(i);
  }

  protected int u1(int paramInt)
  {
    return 0xFF & this.data[paramInt];
  }

  protected int u2()
  {
    int i = u2(this.offset);
    this.offset = (2 + this.offset);
    return i;
  }

  protected int u2(int paramInt)
  {
    return ((0xFF & this.data[paramInt]) << 8) + (0xFF & this.data[(paramInt + 1)]);
  }

  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.write(this.data, this.offset, this.dataLength);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.MiscAttr
 * JD-Core Version:    0.6.2
 */