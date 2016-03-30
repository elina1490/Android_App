package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolValue2 extends CpoolEntry
{
  int tag;
  long value;

  CpoolValue2(int paramInt)
  {
    this.tag = paramInt;
  }

  CpoolValue2(ConstantPool paramConstantPool, int paramInt1, int paramInt2, long paramLong)
  {
    super(paramConstantPool, paramInt2);
    this.tag = paramInt1;
    this.value = paramLong;
    paramConstantPool.count = (1 + paramConstantPool.count);
  }

  static int hashCode(long paramLong)
  {
    return (int)paramLong;
  }

  public int getTag()
  {
    return this.tag;
  }

  public final long getValue()
  {
    return this.value;
  }

  public int hashCode()
  {
    if (this.hash == 0)
      this.hash = hashCode(this.value);
    return this.hash;
  }

  public void print(ClassTypeWriter paramClassTypeWriter, int paramInt)
  {
    if (this.tag == 5)
    {
      if (paramInt > 0)
        paramClassTypeWriter.print("Long ");
      paramClassTypeWriter.print(this.value);
      if ((paramInt > 1) && (this.value != 0L))
      {
        paramClassTypeWriter.print("=0x");
        paramClassTypeWriter.print(Long.toHexString(this.value));
      }
    }
    do
    {
      return;
      if (paramInt > 0)
        paramClassTypeWriter.print("Double ");
      paramClassTypeWriter.print(Double.longBitsToDouble(this.value));
    }
    while (paramInt <= 1);
    paramClassTypeWriter.print("=0x");
    paramClassTypeWriter.print(Long.toHexString(this.value));
  }

  void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeByte(this.tag);
    paramDataOutputStream.writeLong(this.value);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.CpoolValue2
 * JD-Core Version:    0.6.2
 */