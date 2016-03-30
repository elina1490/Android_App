package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.kawa.functions.GetNamedPart;
import gnu.mapping.Namespace;
import gnu.mapping.WrappedException;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;

public class ClassNamespace extends Namespace
  implements Externalizable
{
  ClassType ctype;

  public ClassNamespace()
  {
  }

  public ClassNamespace(ClassType paramClassType)
  {
    setName("class:" + paramClassType.getName());
    this.ctype = paramClassType;
  }

  public static ClassNamespace getInstance(String paramString, ClassType paramClassType)
  {
    synchronized (nsTable)
    {
      Object localObject2 = nsTable.get(paramString);
      if ((localObject2 instanceof ClassNamespace))
      {
        ClassNamespace localClassNamespace2 = (ClassNamespace)localObject2;
        return localClassNamespace2;
      }
      ClassNamespace localClassNamespace1 = new ClassNamespace(paramClassType);
      nsTable.put(paramString, localClassNamespace1);
      return localClassNamespace1;
    }
  }

  public Object get(String paramString)
  {
    try
    {
      Object localObject = GetNamedPart.getTypePart(this.ctype, paramString);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }

  public ClassType getClassType()
  {
    return this.ctype;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.ctype = ((ClassType)paramObjectInput.readObject());
    setName("class:" + this.ctype.getName());
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    String str = getName();
    if (str != null)
    {
      Namespace localNamespace = (Namespace)nsTable.get(str);
      if ((localNamespace instanceof ClassNamespace))
        return localNamespace;
      nsTable.put(str, this);
    }
    return this;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.ctype);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ClassNamespace
 * JD-Core Version:    0.6.2
 */