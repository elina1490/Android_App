package gnu.bytecode;

public class Location
{
  protected String name;
  int name_index;
  int signature_index;
  protected Type type;

  public final String getName()
  {
    return this.name;
  }

  public final String getSignature()
  {
    return this.type.getSignature();
  }

  public final Type getType()
  {
    return this.type;
  }

  public final void setName(int paramInt, ConstantPool paramConstantPool)
  {
    if (paramInt <= 0);
    for (this.name = null; ; this.name = ((CpoolUtf8)paramConstantPool.getForced(paramInt, 1)).string)
    {
      this.name_index = paramInt;
      return;
    }
  }

  public final void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setSignature(int paramInt, ConstantPool paramConstantPool)
  {
    CpoolUtf8 localCpoolUtf8 = (CpoolUtf8)paramConstantPool.getForced(paramInt, 1);
    this.signature_index = paramInt;
    this.type = Type.signatureToType(localCpoolUtf8.string);
  }

  public final void setType(Type paramType)
  {
    this.type = paramType;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.Location
 * JD-Core Version:    0.6.2
 */