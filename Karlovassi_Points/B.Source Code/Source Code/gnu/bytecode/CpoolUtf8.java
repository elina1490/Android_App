package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolUtf8 extends CpoolEntry
{
  String string;

  CpoolUtf8()
  {
  }

  CpoolUtf8(ConstantPool paramConstantPool, int paramInt, String paramString)
  {
    super(paramConstantPool, paramInt);
    this.string = paramString;
  }

  public final String getString()
  {
    return this.string;
  }

  public int getTag()
  {
    return 1;
  }

  public int hashCode()
  {
    if (this.hash == 0)
      this.hash = this.string.hashCode();
    return this.hash;
  }

  public final void intern()
  {
    this.string = this.string.intern();
  }

  public void print(ClassTypeWriter paramClassTypeWriter, int paramInt)
  {
    if (paramInt > 0)
      paramClassTypeWriter.print("Utf8: ");
    paramClassTypeWriter.printQuotedString(this.string);
  }

  void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeByte(1);
    paramDataOutputStream.writeUTF(this.string);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.CpoolUtf8
 * JD-Core Version:    0.6.2
 */