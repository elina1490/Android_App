package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolClass extends CpoolEntry
{
  ObjectType clas;
  CpoolUtf8 name;

  CpoolClass()
  {
  }

  CpoolClass(ConstantPool paramConstantPool, int paramInt, CpoolUtf8 paramCpoolUtf8)
  {
    super(paramConstantPool, paramInt);
    this.name = paramCpoolUtf8;
  }

  static final int hashCode(CpoolUtf8 paramCpoolUtf8)
  {
    return 0xF0F ^ paramCpoolUtf8.hashCode();
  }

  public final String getClassName()
  {
    return this.name.string.replace('/', '.');
  }

  public final ObjectType getClassType()
  {
    ObjectType localObjectType = this.clas;
    if (localObjectType != null)
      return localObjectType;
    String str = this.name.string;
    if (str.charAt(0) == '[');
    for (Object localObject = (ObjectType)Type.signatureToType(str); ; localObject = ClassType.make(str.replace('/', '.')))
    {
      this.clas = ((ObjectType)localObject);
      return localObject;
    }
  }

  public final CpoolUtf8 getName()
  {
    return this.name;
  }

  public final String getStringName()
  {
    return this.name.string;
  }

  public int getTag()
  {
    return 7;
  }

  public int hashCode()
  {
    if (this.hash == 0)
      this.hash = hashCode(this.name);
    return this.hash;
  }

  public void print(ClassTypeWriter paramClassTypeWriter, int paramInt)
  {
    if (paramInt == 1)
      paramClassTypeWriter.print("Class ");
    String str;
    while (true)
    {
      str = this.name.string;
      int i = str.length();
      if ((i <= 1) || (str.charAt(0) != '['))
        break;
      Type.printSignature(str, 0, i, paramClassTypeWriter);
      return;
      if (paramInt > 1)
      {
        paramClassTypeWriter.print("Class name: ");
        paramClassTypeWriter.printOptionalIndex(this.name);
      }
    }
    paramClassTypeWriter.print(str.replace('/', '.'));
  }

  void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeByte(7);
    paramDataOutputStream.writeShort(this.name.index);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.CpoolClass
 * JD-Core Version:    0.6.2
 */