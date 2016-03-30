package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.SlotGet;
import gnu.mapping.HasNamedParts;
import gnu.mapping.HasSetter;
import gnu.mapping.MethodProc;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.mapping.Values;

public class GetNamedPart extends Procedure2
  implements HasSetter
{
  public static final String CAST_METHOD_NAME = "@";
  public static final String CLASSTYPE_FOR = "<>";
  public static final String INSTANCEOF_METHOD_NAME = "instance?";
  public static final GetNamedPart getNamedPart = new GetNamedPart();

  static
  {
    getNamedPart.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateGetNamedPart");
  }

  public static Object getMemberPart(Object paramObject, String paramString)
    throws Throwable
  {
    try
    {
      Object localObject = SlotGet.field(paramObject, paramString);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      MethodProc localMethodProc = ClassMethods.apply((ClassType)ClassType.make(paramObject.getClass()), Compilation.mangleName(paramString), '\000', Language.getDefaultLanguage());
      if (localMethodProc != null)
        return new NamedPart(paramObject, paramString, 'M', localMethodProc);
    }
    throw new RuntimeException("no part '" + paramString + "' in " + paramObject);
  }

  public static Object getNamedPart(Object paramObject, Symbol paramSymbol)
    throws Throwable
  {
    String str1 = paramSymbol.getName();
    if ((paramObject instanceof HasNamedParts))
      return ((HasNamedParts)paramObject).get(str1);
    if ((paramObject instanceof Class))
      paramObject = Type.make((Class)paramObject);
    if ((paramObject instanceof Package))
      try
      {
        String str2 = ((Package)paramObject).getName();
        Class localClass = ClassType.getContextClass(str2 + '.' + str1);
        return localClass;
      }
      catch (Throwable localThrowable)
      {
      }
    if ((paramObject instanceof Type))
      return getTypePart((Type)paramObject, str1);
    return getMemberPart(paramObject, paramSymbol.toString());
  }

  public static Object getTypePart(Type paramType, String paramString)
    throws Throwable
  {
    if (paramString.equals("<>"))
      return paramType;
    if ((paramType instanceof ObjectType))
    {
      if (paramString.equals("instance?"))
        return new NamedPart(paramType, paramString, 'I');
      if (paramString.equals("@"))
        return new NamedPart(paramType, paramString, 'C');
      if (paramString.equals("new"))
        return new NamedPart(paramType, paramString, 'N');
      if ((paramString.equals(".length")) || ((paramString.length() > 1) && (paramString.charAt(0) == '.') && ((paramType instanceof ClassType))))
        return new NamedPart(paramType, paramString, 'D');
    }
    if ((paramType instanceof ClassType))
      try
      {
        Object localObject = SlotGet.staticField(paramType, paramString);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        return ClassMethods.apply(ClassMethods.classMethods, paramType, paramString);
      }
    return getMemberPart(paramType, paramString);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    if ((paramObject1 instanceof Values))
    {
      Object[] arrayOfObject = ((Values)paramObject1).getValues();
      Values localValues = new Values();
      for (int i = 0; i < arrayOfObject.length; i++)
        Values.writeValues(apply2(arrayOfObject[i], paramObject2), localValues);
      return localValues.canonicalize();
    }
    if ((paramObject2 instanceof Symbol));
    for (Symbol localSymbol = (Symbol)paramObject2; ; localSymbol = Namespace.EmptyNamespace.getSymbol(paramObject2.toString().intern()))
      return getNamedPart(paramObject1, localSymbol);
  }

  public Procedure getSetter()
  {
    return SetNamedPart.setNamedPart;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.GetNamedPart
 * JD-Core Version:    0.6.2
 */