package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class Field extends Location
  implements AttrContainer, Member
{
  Attribute attributes;
  int flags;
  Field next;
  ClassType owner;
  java.lang.reflect.Field rfield;
  String sourceName;

  public Field(ClassType paramClassType)
  {
    if (paramClassType.last_field == null)
      paramClassType.fields = this;
    while (true)
    {
      paramClassType.last_field = this;
      paramClassType.fields_count = (1 + paramClassType.fields_count);
      this.owner = paramClassType;
      return;
      paramClassType.last_field.next = this;
    }
  }

  public static Field searchField(Field paramField, String paramString)
  {
    while (paramField != null)
    {
      if (paramField.getSourceName() == paramString)
        return paramField;
      paramField = paramField.next;
    }
    return null;
  }

  void assign_constants(ClassType paramClassType)
  {
    ConstantPool localConstantPool = paramClassType.constants;
    if ((this.name_index == 0) && (this.name != null))
      this.name_index = localConstantPool.addUtf8(this.name).index;
    if ((this.signature_index == 0) && (this.type != null))
      this.signature_index = localConstantPool.addUtf8(this.type.getSignature()).index;
    Attribute.assignConstants(this, paramClassType);
  }

  public final Attribute getAttributes()
  {
    return this.attributes;
  }

  public final ClassType getDeclaringClass()
  {
    return this.owner;
  }

  public final int getFlags()
  {
    return this.flags;
  }

  public final int getModifiers()
  {
    return this.flags;
  }

  public final Field getNext()
  {
    return this.next;
  }

  public java.lang.reflect.Field getReflectField()
    throws NoSuchFieldException
  {
    try
    {
      if (this.rfield == null)
        this.rfield = this.owner.getReflectClass().getDeclaredField(getName());
      java.lang.reflect.Field localField = this.rfield;
      return localField;
    }
    finally
    {
    }
  }

  public String getSourceName()
  {
    if (this.sourceName == null)
      this.sourceName = getName().intern();
    return this.sourceName;
  }

  public final boolean getStaticFlag()
  {
    return (0x8 & this.flags) != 0;
  }

  public final void setAttributes(Attribute paramAttribute)
  {
    this.attributes = paramAttribute;
  }

  public final void setConstantValue(Object paramObject, ClassType paramClassType)
  {
    ConstantPool localConstantPool = paramClassType.constants;
    if (localConstantPool == null)
    {
      localConstantPool = new ConstantPool();
      paramClassType.constants = localConstantPool;
    }
    Object localObject;
    switch (getType().getSignature().charAt(0))
    {
    default:
      localObject = localConstantPool.addString(paramObject.toString());
    case 'Z':
    case 'C':
    case 'B':
    case 'I':
    case 'S':
    case 'J':
    case 'F':
    case 'D':
    }
    while (true)
    {
      new ConstantValueAttr(((CpoolEntry)localObject).getIndex()).addToFrontOf(this);
      return;
      if (PrimType.booleanValue(paramObject));
      for (int i = 1; ; i = 0)
      {
        localObject = localConstantPool.addInt(i);
        break;
      }
      if ((paramObject instanceof Character))
      {
        localObject = localConstantPool.addInt(((Character)paramObject).charValue());
      }
      else
      {
        localObject = localConstantPool.addInt(((Number)paramObject).intValue());
        continue;
        localObject = localConstantPool.addLong(((Number)paramObject).longValue());
        continue;
        localObject = localConstantPool.addFloat(((Number)paramObject).floatValue());
        continue;
        localObject = localConstantPool.addDouble(((Number)paramObject).doubleValue());
      }
    }
  }

  public void setSourceName(String paramString)
  {
    this.sourceName = paramString;
  }

  public final void setStaticFlag(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x8 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFF7 ^ this.flags);
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append("Field:");
    localStringBuffer.append(getDeclaringClass().getName());
    localStringBuffer.append('.');
    localStringBuffer.append(this.name);
    return localStringBuffer.toString();
  }

  void write(DataOutputStream paramDataOutputStream, ClassType paramClassType)
    throws IOException
  {
    paramDataOutputStream.writeShort(this.flags);
    paramDataOutputStream.writeShort(this.name_index);
    paramDataOutputStream.writeShort(this.signature_index);
    Attribute.writeAll(this, paramDataOutputStream);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.Field
 * JD-Core Version:    0.6.2
 */