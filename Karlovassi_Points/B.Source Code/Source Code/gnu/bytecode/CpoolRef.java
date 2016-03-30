package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class CpoolRef extends CpoolEntry
{
  CpoolClass clas;
  CpoolNameAndType nameAndType;
  int tag;

  CpoolRef(int paramInt)
  {
    this.tag = paramInt;
  }

  CpoolRef(ConstantPool paramConstantPool, int paramInt1, int paramInt2, CpoolClass paramCpoolClass, CpoolNameAndType paramCpoolNameAndType)
  {
    super(paramConstantPool, paramInt1);
    this.tag = paramInt2;
    this.clas = paramCpoolClass;
    this.nameAndType = paramCpoolNameAndType;
  }

  static final int hashCode(CpoolClass paramCpoolClass, CpoolNameAndType paramCpoolNameAndType)
  {
    return paramCpoolClass.hashCode() ^ paramCpoolNameAndType.hashCode();
  }

  public final CpoolClass getCpoolClass()
  {
    return this.clas;
  }

  public final CpoolNameAndType getNameAndType()
  {
    return this.nameAndType;
  }

  public int getTag()
  {
    return this.tag;
  }

  public int hashCode()
  {
    if (this.hash == 0)
      this.hash = hashCode(this.clas, this.nameAndType);
    return this.hash;
  }

  public void print(ClassTypeWriter paramClassTypeWriter, int paramInt)
  {
    String str;
    switch (this.tag)
    {
    default:
      str = "<Unknown>Ref";
      if (paramInt > 0)
      {
        paramClassTypeWriter.print(str);
        if (paramInt == 2)
        {
          paramClassTypeWriter.print(" class: ");
          paramClassTypeWriter.printOptionalIndex(this.clas);
        }
      }
      else
      {
        label63: this.clas.print(paramClassTypeWriter, 0);
        if (paramInt >= 2)
          break label131;
        paramClassTypeWriter.print('.');
      }
      break;
    case 9:
    case 10:
    case 11:
    }
    while (true)
    {
      this.nameAndType.print(paramClassTypeWriter, 0);
      if (paramInt == 2)
        paramClassTypeWriter.print('>');
      return;
      str = "Field";
      break;
      str = "Method";
      break;
      str = "InterfaceMethod";
      break;
      paramClassTypeWriter.print(' ');
      break label63;
      label131: paramClassTypeWriter.print(" name_and_type: ");
      paramClassTypeWriter.printOptionalIndex(this.nameAndType);
      paramClassTypeWriter.print('<');
    }
  }

  void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeByte(this.tag);
    paramDataOutputStream.writeShort(this.clas.index);
    paramDataOutputStream.writeShort(this.nameAndType.index);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.CpoolRef
 * JD-Core Version:    0.6.2
 */