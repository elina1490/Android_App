package gnu.bytecode;

import java.util.List;
import java.util.Vector;

public class ObjectType extends Type
{
  static final int ADD_ENCLOSING_DONE = 8;
  static final int ADD_FIELDS_DONE = 1;
  static final int ADD_MEMBERCLASSES_DONE = 4;
  static final int ADD_METHODS_DONE = 2;
  static final int EXISTING_CLASS = 16;
  static final int HAS_OUTER_LINK = 32;
  public int flags;

  protected ObjectType()
  {
    this.size = 4;
  }

  public ObjectType(String paramString)
  {
    this.this_name = paramString;
    this.size = 4;
  }

  public static Class getContextClass(String paramString)
    throws ClassNotFoundException
  {
    try
    {
      Class localClass = Class.forName(paramString, false, ObjectType.class.getClassLoader());
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return Class.forName(paramString, false, getContextClassLoader());
  }

  public static ClassLoader getContextClassLoader()
  {
    try
    {
      ClassLoader localClassLoader = ClassLoader.getSystemClassLoader();
      return localClassLoader;
    }
    catch (SecurityException localSecurityException)
    {
    }
    return ObjectType.class.getClassLoader();
  }

  public Object coerceFromObject(Object paramObject)
  {
    if (paramObject != null)
    {
      if (this == Type.toStringType)
        return paramObject.toString();
      Class localClass1 = getReflectClass();
      Class localClass2 = paramObject.getClass();
      if (!localClass1.isAssignableFrom(localClass2))
        throw new ClassCastException("don't know how to coerce " + localClass2.getName() + " to " + getName());
    }
    return paramObject;
  }

  public int compare(Type paramType)
  {
    if (paramType == nullType)
      return 0;
    return -1;
  }

  public void emitCoerceFromObject(CodeAttr paramCodeAttr)
  {
    if (this == Type.toStringType)
    {
      paramCodeAttr.emitDup();
      paramCodeAttr.emitIfNull();
      paramCodeAttr.emitPop(1);
      paramCodeAttr.emitPushNull();
      paramCodeAttr.emitElse();
      paramCodeAttr.emitInvokeVirtual(Type.toString_method);
      paramCodeAttr.emitFi();
    }
    while (this == Type.objectType)
      return;
    paramCodeAttr.emitCheckcast(this);
  }

  public Field getField(String paramString, int paramInt)
  {
    return null;
  }

  public Type getImplementationType()
  {
    if (this == nullType)
      return objectType;
    if (this == toStringType)
      return javalangStringType;
    return this;
  }

  public String getInternalName()
  {
    return getName().replace('.', '/');
  }

  public Method getMethod(String paramString, Type[] paramArrayOfType)
  {
    return Type.objectType.getMethod(paramString, paramArrayOfType);
  }

  public int getMethods(Filter paramFilter, int paramInt, List<Method> paramList)
  {
    return Type.objectType.getMethods(paramFilter, paramInt, paramList);
  }

  public final int getMethods(Filter paramFilter, int paramInt, Vector paramVector, String paramString)
  {
    return Type.objectType.getMethods(paramFilter, paramInt, paramVector, paramString);
  }

  public Class getReflectClass()
  {
    try
    {
      if (this.reflectClass == null)
        this.reflectClass = getContextClass(getInternalName().replace('/', '.'));
      this.flags = (0x10 | this.flags);
      return this.reflectClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while ((0x10 & this.flags) == 0);
      RuntimeException localRuntimeException = new RuntimeException("no such class: " + getName());
      localRuntimeException.initCause(localClassNotFoundException);
      throw localRuntimeException;
    }
  }

  public final boolean isExisting()
  {
    Type localType = getImplementationType();
    if ((localType instanceof ArrayType))
      localType = ((ArrayType)localType).getComponentType();
    if (localType == this)
      return (0x10 & this.flags) != 0;
    return (!(localType instanceof ObjectType)) || (((ObjectType)localType).isExisting());
  }

  public boolean isInstance(Object paramObject)
  {
    if (this == nullType)
      return paramObject == null;
    return super.isInstance(paramObject);
  }

  public Type promote()
  {
    if (this == nullType)
      return objectType;
    return this;
  }

  public final void setExisting(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x10 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFEF & this.flags);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ObjectType
 * JD-Core Version:    0.6.2
 */