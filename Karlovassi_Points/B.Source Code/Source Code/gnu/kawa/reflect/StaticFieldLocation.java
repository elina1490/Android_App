package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.mapping.Environment;
import gnu.mapping.Symbol;
import kawa.lang.Macro;

public class StaticFieldLocation extends FieldLocation
{
  public StaticFieldLocation(ClassType paramClassType, String paramString)
  {
    super(null, paramClassType, paramString);
  }

  public StaticFieldLocation(String paramString1, String paramString2)
  {
    super(null, ClassType.make(paramString1), paramString2);
  }

  public StaticFieldLocation(java.lang.reflect.Field paramField)
  {
    super(null, paramField);
  }

  public static StaticFieldLocation define(Environment paramEnvironment, Symbol paramSymbol, Object paramObject, String paramString1, String paramString2)
  {
    StaticFieldLocation localStaticFieldLocation = new StaticFieldLocation(paramString1, paramString2);
    paramEnvironment.addLocation(paramSymbol, paramObject, localStaticFieldLocation);
    return localStaticFieldLocation;
  }

  public static StaticFieldLocation make(Declaration paramDeclaration)
  {
    gnu.bytecode.Field localField = paramDeclaration.field;
    StaticFieldLocation localStaticFieldLocation = new StaticFieldLocation(localField.getDeclaringClass(), localField.getName());
    localStaticFieldLocation.setDeclaration(paramDeclaration);
    return localStaticFieldLocation;
  }

  public static StaticFieldLocation make(String paramString1, String paramString2)
  {
    return new StaticFieldLocation(paramString1, paramString2);
  }

  public Object get(Object paramObject)
  {
    Object localObject = super.get(paramObject);
    if ((localObject instanceof Macro))
      getDeclaration();
    return localObject;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.StaticFieldLocation
 * JD-Core Version:    0.6.2
 */