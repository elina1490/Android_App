package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.text.Printable;

public abstract class Pattern
  implements Printable
{
  private static Type[] matchArgs = arrayOfType;
  public static final Method matchPatternMethod = typePattern.addMethod("match", matchArgs, Type.booleanType, 1);
  public static ClassType typePattern = ClassType.make("kawa.lang.Pattern");

  static
  {
    Type[] arrayOfType = new Type[3];
    arrayOfType[0] = Type.pointer_type;
    arrayOfType[1] = Compilation.objArrayType;
    arrayOfType[2] = Type.intType;
  }

  public abstract boolean match(Object paramObject, Object[] paramArrayOfObject, int paramInt);

  public Object[] match(Object paramObject)
  {
    Object[] arrayOfObject = new Object[varCount()];
    if (match(paramObject, arrayOfObject, 0))
      return arrayOfObject;
    return null;
  }

  public abstract int varCount();
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Pattern
 * JD-Core Version:    0.6.2
 */