package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Keyword;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;
import kawa.lang.Record;

public class make extends ProcedureN
{
  public Object applyN(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i == 0)
      throw new WrongArguments(this, i);
    Object localObject1 = paramArrayOfObject[0];
    Class localClass;
    if ((localObject1 instanceof Class))
      localClass = (Class)localObject1;
    while (localClass == null)
    {
      throw new WrongType(this, 1, localObject1, "class");
      if ((localObject1 instanceof ClassType))
        localClass = ((ClassType)localObject1).getReflectClass();
      else
        localClass = null;
    }
    Object localObject2;
    try
    {
      localObject2 = localClass.newInstance();
      int j = 1;
      while (j < i)
      {
        int k = j + 1;
        Keyword localKeyword = (Keyword)paramArrayOfObject[j];
        j = k + 1;
        Record.set1(paramArrayOfObject[k], localKeyword.getName(), localObject2);
      }
    }
    catch (Exception localException)
    {
      throw new WrappedException(localException);
    }
    return localObject2;
  }

  public int numArgs()
  {
    return -4095;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.make
 * JD-Core Version:    0.6.2
 */