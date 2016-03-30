package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class ExceptionsAttr extends Attribute
{
  short[] exception_table;
  ClassType[] exceptions;

  public ExceptionsAttr(Method paramMethod)
  {
    super("Exceptions");
    addToFrontOf(paramMethod);
  }

  public void assignConstants(ClassType paramClassType)
  {
    super.assignConstants(paramClassType);
    ConstantPool localConstantPool = paramClassType.getConstants();
    int i = this.exceptions.length;
    this.exception_table = new short[i];
    for (int j = i - 1; j >= 0; j--)
      this.exception_table[j] = ((short)localConstantPool.addClass(this.exceptions[j]).index);
  }

  public final ClassType[] getExceptions()
  {
    return this.exceptions;
  }

  public final int getLength()
  {
    if (this.exceptions == null);
    for (int i = 0; ; i = this.exceptions.length)
      return 2 + i * 2;
  }

  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    paramClassTypeWriter.print("Attribute \"");
    paramClassTypeWriter.print(getName());
    paramClassTypeWriter.print("\", length:");
    paramClassTypeWriter.print(getLength());
    paramClassTypeWriter.print(", count: ");
    int i = this.exceptions.length;
    paramClassTypeWriter.println(i);
    for (int j = 0; j < i; j++)
    {
      int k = 0xFFFF & this.exception_table[j];
      paramClassTypeWriter.print("  ");
      paramClassTypeWriter.printOptionalIndex(k);
      paramClassTypeWriter.printConstantTersely(k, 7);
      paramClassTypeWriter.println();
    }
  }

  public void setExceptions(ClassType[] paramArrayOfClassType)
  {
    this.exceptions = paramArrayOfClassType;
  }

  public void setExceptions(short[] paramArrayOfShort, ClassType paramClassType)
  {
    this.exception_table = paramArrayOfShort;
    this.exceptions = new ClassType[paramArrayOfShort.length];
    ConstantPool localConstantPool = paramClassType.getConstants();
    for (int i = paramArrayOfShort.length - 1; i >= 0; i--)
      this.exceptions[i] = ((ClassType)((CpoolClass)localConstantPool.getPoolEntry(paramArrayOfShort[i])).getClassType());
  }

  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    int i = this.exceptions.length;
    paramDataOutputStream.writeShort(i);
    for (int j = 0; j < i; j++)
      paramDataOutputStream.writeShort(this.exception_table[j]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ExceptionsAttr
 * JD-Core Version:    0.6.2
 */