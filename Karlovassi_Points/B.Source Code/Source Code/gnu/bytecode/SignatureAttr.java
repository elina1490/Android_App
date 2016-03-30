package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class SignatureAttr extends Attribute
{
  String signature;
  int signature_index;

  public SignatureAttr(int paramInt, Member paramMember)
  {
    super("Signature");
    if ((paramMember instanceof ClassType));
    for (ClassType localClassType = (ClassType)paramMember; ; localClassType = paramMember.getDeclaringClass())
    {
      this.signature = ((CpoolUtf8)localClassType.constants.getForced(paramInt, 1)).string;
      this.signature_index = paramInt;
      return;
    }
  }

  public SignatureAttr(String paramString)
  {
    super("Signature");
    this.signature = paramString;
  }

  public void assignConstants(ClassType paramClassType)
  {
    super.assignConstants(paramClassType);
    if (this.signature_index == 0)
      this.signature_index = paramClassType.getConstants().addUtf8(this.signature).getIndex();
  }

  public final int getLength()
  {
    return 2;
  }

  public final String getSignature()
  {
    return this.signature;
  }

  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    super.print(paramClassTypeWriter);
    paramClassTypeWriter.print("  ");
    paramClassTypeWriter.printOptionalIndex(this.signature_index);
    paramClassTypeWriter.print('"');
    paramClassTypeWriter.print(getSignature());
    paramClassTypeWriter.println('"');
  }

  protected void setSignature(String paramString)
  {
    this.signature = paramString;
    this.signature_index = 0;
  }

  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeShort(this.signature_index);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.SignatureAttr
 * JD-Core Version:    0.6.2
 */