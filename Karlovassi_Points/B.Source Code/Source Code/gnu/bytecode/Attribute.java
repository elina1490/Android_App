package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Attribute
{
  AttrContainer container;
  String name;
  int name_index;
  Attribute next;

  public Attribute(String paramString)
  {
    this.name = paramString;
  }

  public static void assignConstants(AttrContainer paramAttrContainer, ClassType paramClassType)
  {
    for (Attribute localAttribute = paramAttrContainer.getAttributes(); localAttribute != null; localAttribute = localAttribute.next)
      if (!localAttribute.isSkipped())
        localAttribute.assignConstants(paramClassType);
  }

  public static int count(AttrContainer paramAttrContainer)
  {
    int i = 0;
    for (Attribute localAttribute = paramAttrContainer.getAttributes(); localAttribute != null; localAttribute = localAttribute.next)
      if (!localAttribute.isSkipped())
        i++;
    return i;
  }

  public static Attribute get(AttrContainer paramAttrContainer, String paramString)
  {
    for (Attribute localAttribute = paramAttrContainer.getAttributes(); localAttribute != null; localAttribute = localAttribute.next)
      if (localAttribute.getName() == paramString)
        return localAttribute;
    return null;
  }

  public static int getLengthAll(AttrContainer paramAttrContainer)
  {
    int i = 0;
    for (Attribute localAttribute = paramAttrContainer.getAttributes(); localAttribute != null; localAttribute = localAttribute.next)
      if (!localAttribute.isSkipped())
        i += 6 + localAttribute.getLength();
    return i;
  }

  public static void writeAll(AttrContainer paramAttrContainer, DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeShort(count(paramAttrContainer));
    Attribute localAttribute = paramAttrContainer.getAttributes();
    if (localAttribute != null)
    {
      if (localAttribute.isSkipped());
      while (true)
      {
        localAttribute = localAttribute.next;
        break;
        if (localAttribute.name_index == 0)
          throw new Error("Attribute.writeAll called without assignConstants");
        paramDataOutputStream.writeShort(localAttribute.name_index);
        paramDataOutputStream.writeInt(localAttribute.getLength());
        localAttribute.write(paramDataOutputStream);
      }
    }
  }

  public void addToFrontOf(AttrContainer paramAttrContainer)
  {
    setContainer(paramAttrContainer);
    setNext(paramAttrContainer.getAttributes());
    paramAttrContainer.setAttributes(this);
  }

  public void assignConstants(ClassType paramClassType)
  {
    if (this.name_index == 0)
      this.name_index = paramClassType.getConstants().addUtf8(this.name).getIndex();
  }

  public final AttrContainer getContainer()
  {
    return this.container;
  }

  public abstract int getLength();

  public final String getName()
  {
    return this.name;
  }

  public final int getNameIndex()
  {
    return this.name_index;
  }

  public final Attribute getNext()
  {
    return this.next;
  }

  public final boolean isSkipped()
  {
    return this.name_index < 0;
  }

  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    paramClassTypeWriter.print("Attribute \"");
    paramClassTypeWriter.print(getName());
    paramClassTypeWriter.print("\", length:");
    paramClassTypeWriter.println(getLength());
  }

  public final void setContainer(AttrContainer paramAttrContainer)
  {
    this.container = paramAttrContainer;
  }

  public final void setName(String paramString)
  {
    this.name = paramString.intern();
  }

  public final void setNameIndex(int paramInt)
  {
    this.name_index = paramInt;
  }

  public final void setNext(Attribute paramAttribute)
  {
    this.next = paramAttribute;
  }

  public final void setSkipped()
  {
    this.name_index = -1;
  }

  public final void setSkipped(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = -1; ; i = 0)
    {
      this.name_index = i;
      return;
    }
  }

  public abstract void write(DataOutputStream paramDataOutputStream)
    throws IOException;
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.Attribute
 * JD-Core Version:    0.6.2
 */