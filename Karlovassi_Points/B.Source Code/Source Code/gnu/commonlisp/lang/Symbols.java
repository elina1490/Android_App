package gnu.commonlisp.lang;

import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;

public class Symbols
{
  public static Object getFunctionBinding(Environment paramEnvironment, Object paramObject)
  {
    return paramEnvironment.getFunction(getSymbol(paramObject));
  }

  public static Object getFunctionBinding(Object paramObject)
  {
    return Environment.getCurrent().getFunction(getSymbol(paramObject));
  }

  public static Object getPrintName(Object paramObject)
  {
    if (paramObject == Lisp2.FALSE)
      return "nil";
    return Lisp2.getString(((Symbol)paramObject).getName());
  }

  public static Symbol getSymbol(Environment paramEnvironment, Object paramObject)
  {
    if (paramObject == Lisp2.FALSE)
      paramObject = "nil";
    if ((paramObject instanceof Symbol))
      return (Symbol)paramObject;
    return paramEnvironment.defaultNamespace().getSymbol((String)paramObject);
  }

  public static Symbol getSymbol(Object paramObject)
  {
    if (paramObject == Lisp2.FALSE)
      paramObject = "nil";
    if ((paramObject instanceof Symbol))
      return (Symbol)paramObject;
    return Namespace.getDefaultSymbol((String)paramObject);
  }

  public static boolean isBound(Object paramObject)
  {
    if (paramObject == Lisp2.FALSE)
      return true;
    Environment localEnvironment = Environment.getCurrent();
    if ((paramObject instanceof Symbol));
    for (Symbol localSymbol = (Symbol)paramObject; (localSymbol != null) && (localEnvironment.isBound(localSymbol)); localSymbol = localEnvironment.defaultNamespace().lookup((String)paramObject))
      return true;
    return false;
  }

  public static boolean isSymbol(Object paramObject)
  {
    return ((paramObject instanceof String)) || (paramObject == Lisp2.FALSE) || ((paramObject instanceof Symbol));
  }

  public static void setFunctionBinding(Environment paramEnvironment, Object paramObject1, Object paramObject2)
  {
    paramEnvironment.put(getSymbol(paramObject1), EnvironmentKey.FUNCTION, paramObject2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lang.Symbols
 * JD-Core Version:    0.6.2
 */