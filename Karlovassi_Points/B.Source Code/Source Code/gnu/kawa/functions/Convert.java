package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;

public class Convert extends Procedure2
{
  public static final Convert as = new Convert();

  static
  {
    as.setName("as");
    as.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConvert");
    Procedure.compilerKey.set(as, "*gnu.kawa.functions.CompileMisc:forConvert");
  }

  public static Convert getInstance()
  {
    return as;
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof Class));
    for (Type localType = Type.make((Class)paramObject1); ; localType = (Type)paramObject1)
      return localType.coerceFromObject(paramObject2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.Convert
 * JD-Core Version:    0.6.2
 */