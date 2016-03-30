package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrappedException;
import java.io.PrintWriter;
import java.util.Vector;

public class Record
{
  static java.lang.reflect.Field getField(Class paramClass, String paramString)
    throws NoSuchFieldException
  {
    gnu.bytecode.Field localField = ((ClassType)Type.make(paramClass)).getFields();
    if (localField != null)
    {
      if ((0x9 & localField.getModifiers()) != 1);
      while (!localField.getSourceName().equals(paramString))
      {
        localField = localField.getNext();
        break;
      }
      return localField.getReflectField();
    }
    throw new NoSuchFieldException();
  }

  public static boolean isRecord(Object paramObject)
  {
    return paramObject instanceof Record;
  }

  public static ClassType makeRecordType(String paramString, LList paramLList)
  {
    ClassType localClassType1 = ClassType.make("kawa.lang.Record");
    String str1 = Compilation.mangleNameIfNeeded(paramString);
    ClassType localClassType2 = new ClassType(str1);
    localClassType2.setSuper(localClassType1);
    localClassType2.setModifiers(33);
    Method localMethod1 = localClassType2.addMethod("<init>", Type.typeArray0, Type.voidType, 1);
    Method localMethod2 = localClassType1.addMethod("<init>", Type.typeArray0, Type.voidType, 1);
    CodeAttr localCodeAttr = localMethod1.startCode();
    localCodeAttr.emitPushThis();
    localCodeAttr.emitInvokeSpecial(localMethod2);
    localCodeAttr.emitReturn();
    if (!paramString.equals(str1))
    {
      localCodeAttr = localClassType2.addMethod("getTypeName", Type.typeArray0, Compilation.typeString, 1).startCode();
      localCodeAttr.emitPushString(paramString);
      localCodeAttr.emitReturn();
    }
    while (paramLList != LList.Empty)
    {
      Pair localPair = (Pair)paramLList;
      String str2 = localPair.getCar().toString();
      localClassType2.addField(Compilation.mangleNameIfNeeded(str2), Type.pointer_type, 1).setSourceName(str2.intern());
      paramLList = (LList)localPair.getCdr();
    }
    byte[][] arrayOfByte = new byte[1][];
    String[] arrayOfString = { str1 };
    arrayOfByte[0] = localClassType2.writeToArray();
    ArrayClassLoader localArrayClassLoader = new ArrayClassLoader(arrayOfString, arrayOfByte);
    try
    {
      Type.registerTypeForClass(localArrayClassLoader.loadClass(str1), localClassType2);
      return localClassType2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new InternalError(localClassNotFoundException.toString());
    }
  }

  public static Object set1(Object paramObject1, String paramString, Object paramObject2)
  {
    Class localClass = paramObject1.getClass();
    try
    {
      java.lang.reflect.Field localField = getField(localClass, paramString);
      Object localObject = localField.get(paramObject1);
      localField.set(paramObject1, paramObject2);
      return localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new GenericError("no such field " + paramString + " in " + localClass.getName());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new GenericError("illegal access for field " + paramString);
  }

  public static LList typeFieldNames(ClassType paramClassType)
  {
    return typeFieldNames(paramClassType.getReflectClass());
  }

  public static LList typeFieldNames(Class paramClass)
  {
    LList localLList = LList.Empty;
    gnu.bytecode.Field localField = ((ClassType)Type.make(paramClass)).getFields();
    Vector localVector = new Vector(100);
    while (localField != null)
    {
      if ((0x9 & localField.getModifiers()) == 1)
        localVector.addElement(SimpleSymbol.valueOf(localField.getSourceName()));
      localField = localField.getNext();
    }
    int i = localVector.size();
    for (Object localObject = localLList; ; localObject = new Pair(localVector.elementAt(i), localObject))
    {
      i--;
      if (i < 0)
        break;
    }
    return localObject;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    Class localClass = getClass();
    if ((paramObject == null) || (paramObject.getClass() != localClass))
      return false;
    gnu.bytecode.Field localField = ((ClassType)Type.make(localClass)).getFields();
    if (localField != null)
    {
      if ((0x9 & localField.getModifiers()) != 1);
      while (true)
      {
        localField = localField.getNext();
        break;
        try
        {
          java.lang.reflect.Field localField1 = localField.getReflectField();
          Object localObject1 = localField1.get(this);
          Object localObject2 = localField1.get(paramObject);
          if (!localObject1.equals(localObject2))
            return false;
        }
        catch (Exception localException)
        {
          throw new WrappedException(localException);
        }
      }
    }
    return true;
  }

  public Object get(String paramString, Object paramObject)
  {
    Class localClass = getClass();
    try
    {
      Object localObject = getField(localClass, paramString).get(this);
      return localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new GenericError("no such field " + paramString + " in " + localClass.getName());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new GenericError("illegal access for field " + paramString);
  }

  public String getTypeName()
  {
    return getClass().getName();
  }

  public int hashCode()
  {
    java.lang.reflect.Field[] arrayOfField = getClass().getFields();
    int i = 12345;
    int j = 0;
    while (true)
      if (j < arrayOfField.length)
      {
        java.lang.reflect.Field localField = arrayOfField[j];
        try
        {
          Object localObject = localField.get(this);
          if (localObject != null)
            i ^= localObject.hashCode();
          label46: j++;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          break label46;
        }
      }
    return i;
  }

  public void print(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print(toString());
  }

  public Object put(String paramString, Object paramObject)
  {
    return set1(this, paramString, paramObject);
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    localStringBuffer.append("#<");
    localStringBuffer.append(getTypeName());
    gnu.bytecode.Field localField = ((ClassType)Type.make(getClass())).getFields();
    if (localField != null)
    {
      if ((0x9 & localField.getModifiers()) != 1);
      while (true)
      {
        localField = localField.getNext();
        break;
        try
        {
          Object localObject2 = localField.getReflectField().get(this);
          localObject1 = localObject2;
          localStringBuffer.append(' ');
          localStringBuffer.append(localField.getSourceName());
          localStringBuffer.append(": ");
          localStringBuffer.append(localObject1);
        }
        catch (Exception localException)
        {
          while (true)
            Object localObject1 = "#<illegal-access>";
        }
      }
    }
    localStringBuffer.append(">");
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Record
 * JD-Core Version:    0.6.2
 */