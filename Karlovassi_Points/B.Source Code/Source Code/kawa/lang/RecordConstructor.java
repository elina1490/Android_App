package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;

public class RecordConstructor extends ProcedureN
{
  gnu.bytecode.Field[] fields;
  ClassType type;

  public RecordConstructor(ClassType paramClassType)
  {
    init(paramClassType);
  }

  public RecordConstructor(ClassType paramClassType, Object paramObject)
  {
    this.type = paramClassType;
    if (paramObject == null)
    {
      init(paramClassType);
      return;
    }
    int i = LList.listLength(paramObject, false);
    this.fields = new gnu.bytecode.Field[i];
    gnu.bytecode.Field localField1 = paramClassType.getFields();
    int j = 0;
    label42: Pair localPair;
    String str;
    if (j < i)
    {
      localPair = (Pair)paramObject;
      str = localPair.getCar().toString();
    }
    for (gnu.bytecode.Field localField2 = localField1; ; localField2 = localField2.getNext())
    {
      if (localField2 == null)
        throw new RuntimeException("no such field " + str + " in " + paramClassType.getName());
      if (localField2.getSourceName() == str)
      {
        this.fields[j] = localField2;
        paramObject = localPair.getCdr();
        j++;
        break label42;
        break;
      }
    }
  }

  public RecordConstructor(ClassType paramClassType, gnu.bytecode.Field[] paramArrayOfField)
  {
    this.type = paramClassType;
    this.fields = paramArrayOfField;
  }

  public RecordConstructor(Class paramClass)
  {
    init((ClassType)Type.make(paramClass));
  }

  public RecordConstructor(Class paramClass, Object paramObject)
  {
    this((ClassType)Type.make(paramClass), paramObject);
  }

  public RecordConstructor(Class paramClass, gnu.bytecode.Field[] paramArrayOfField)
  {
    this((ClassType)Type.make(paramClass), paramArrayOfField);
  }

  private void init(ClassType paramClassType)
  {
    this.type = paramClassType;
    gnu.bytecode.Field localField1 = paramClassType.getFields();
    int i = 0;
    for (gnu.bytecode.Field localField2 = localField1; localField2 != null; localField2 = localField2.getNext())
      if ((0x9 & localField2.getModifiers()) == 1)
        i++;
    this.fields = new gnu.bytecode.Field[i];
    gnu.bytecode.Field localField3 = localField1;
    int j = 0;
    int k;
    if (localField3 != null)
    {
      if ((0x9 & localField3.getModifiers()) != 1)
        break label110;
      gnu.bytecode.Field[] arrayOfField = this.fields;
      k = j + 1;
      arrayOfField[j] = localField3;
    }
    while (true)
    {
      localField3 = localField3.getNext();
      j = k;
      break;
      return;
      label110: k = j;
    }
  }

  public Object applyN(Object[] paramArrayOfObject)
  {
    Object localObject;
    try
    {
      localObject = this.type.getReflectClass().newInstance();
      if (paramArrayOfObject.length != this.fields.length)
        throw new WrongArguments(this, paramArrayOfObject.length);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new GenericError(localInstantiationException.toString());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new GenericError(localIllegalAccessException.toString());
    }
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      gnu.bytecode.Field localField = this.fields[i];
      try
      {
        localField.getReflectField().set(localObject, paramArrayOfObject[i]);
        i++;
      }
      catch (Exception localException)
      {
        throw new WrappedException("illegal access for field " + localField.getName(), localException);
      }
    }
    return localObject;
  }

  public String getName()
  {
    return this.type.getName() + " constructor";
  }

  public int numArgs()
  {
    int i = this.fields.length;
    return i | i << 12;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.RecordConstructor
 * JD-Core Version:    0.6.2
 */