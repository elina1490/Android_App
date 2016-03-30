package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import java.lang.reflect.Array;

class SetArray extends Procedure2
{
  Object array;
  Type elementType;

  public SetArray(Object paramObject, Language paramLanguage)
  {
    this.elementType = paramLanguage.getTypeFor(paramObject.getClass().getComponentType());
    this.array = paramObject;
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    Object localObject = this.elementType.coerceFromObject(paramObject2);
    Array.set(this.array, ((Number)paramObject1).intValue(), localObject);
    return Values.empty;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.SetArray
 * JD-Core Version:    0.6.2
 */