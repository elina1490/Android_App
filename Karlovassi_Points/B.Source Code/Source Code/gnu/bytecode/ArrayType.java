package gnu.bytecode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.List;

public class ArrayType extends ObjectType
  implements Externalizable
{
  public Type elements;

  public ArrayType(Type paramType)
  {
    this(paramType, paramType.getName() + "[]");
  }

  ArrayType(Type paramType, String paramString)
  {
    this.this_name = paramString;
    this.elements = paramType;
  }

  public static ArrayType make(Type paramType)
  {
    ArrayType localArrayType = paramType.array_type;
    if (localArrayType == null)
    {
      localArrayType = new ArrayType(paramType, paramType.getName() + "[]");
      paramType.array_type = localArrayType;
    }
    return localArrayType;
  }

  static ArrayType make(String paramString)
  {
    Type localType = Type.getType(paramString.substring(0, paramString.length() - 2));
    ArrayType localArrayType = localType.array_type;
    if (localArrayType == null)
    {
      localArrayType = new ArrayType(localType, paramString);
      localType.array_type = localArrayType;
    }
    return localArrayType;
  }

  public int compare(Type paramType)
  {
    if (paramType == nullType)
      return 1;
    if ((paramType instanceof ArrayType))
      return this.elements.compare(((ArrayType)paramType).elements);
    if ((paramType.getName().equals("java.lang.Object")) || (paramType == toStringType))
      return -1;
    return -3;
  }

  public Type getComponentType()
  {
    return this.elements;
  }

  public Type getImplementationType()
  {
    Type localType = this.elements.getImplementationType();
    if (this.elements == localType)
      return this;
    return make(localType);
  }

  public String getInternalName()
  {
    return getSignature();
  }

  public int getMethods(Filter paramFilter, int paramInt, List<Method> paramList)
  {
    if (paramInt > 0)
    {
      int i = Type.objectType.getMethods(paramFilter, 0, paramList);
      if ((paramInt > 1) && (paramFilter.select(Type.clone_method)))
      {
        if (paramList != null)
          paramList.add(Type.clone_method);
        i++;
      }
      return i;
    }
    return 0;
  }

  public Class getReflectClass()
  {
    try
    {
      if (this.reflectClass == null)
        this.reflectClass = Class.forName(getInternalName().replace('/', '.'), false, this.elements.getReflectClass().getClassLoader());
      this.flags = (0x10 | this.flags);
      return this.reflectClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while ((0x10 & this.flags) == 0);
      RuntimeException localRuntimeException = new RuntimeException("no such array class: " + getName());
      localRuntimeException.initCause(localClassNotFoundException);
      throw localRuntimeException;
    }
  }

  public String getSignature()
  {
    if (this.signature == null)
      setSignature("[" + this.elements.getSignature());
    return this.signature;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.elements = ((Type)paramObjectInput.readObject());
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    ArrayType localArrayType = this.elements.array_type;
    if (localArrayType != null)
      return localArrayType;
    this.elements.array_type = this;
    return this;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.elements);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ArrayType
 * JD-Core Version:    0.6.2
 */