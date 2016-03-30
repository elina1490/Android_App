package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolString extends CpoolEntry
{
  CpoolUtf8 str;

  CpoolString()
  {
  }

  CpoolString(ConstantPool paramConstantPool, int paramInt, CpoolUtf8 paramCpoolUtf8)
  {
    super(paramConstantPool, paramInt);
    this.str = paramCpoolUtf8;
  }

  static final int hashCode(CpoolUtf8 paramCpoolUtf8)
  {
    return 0xF30F ^ paramCpoolUtf8.hashCode();
  }

  public final CpoolUtf8 getString()
  {
    return this.str;
  }

  public int getTag()
  {
    return 8;
  }

  public int hashCode()
  {
    if (this.hash == 0)
      this.hash = hashCode(this.str);
    return this.hash;
  }

  public void print(ClassTypeWriter paramClassTypeWriter, int paramInt)
  {
    if (paramInt > 0)
    {
      paramClassTypeWriter.print("String ");
      if (paramInt == 2)
        paramClassTypeWriter.printOptionalIndex(this.str);
    }
    paramClassTypeWriter.printConstantTersely(this.str.index, 1);
  }

  void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeByte(8);
    paramDataOutputStream.writeShort(this.str.index);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.CpoolString
 * JD-Core Version:    0.6.2
 */