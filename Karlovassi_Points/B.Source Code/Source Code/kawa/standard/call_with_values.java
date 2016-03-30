package kawa.standard;

import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;

public class call_with_values extends Procedure2
{
  public static final call_with_values callWithValues = new call_with_values();

  static
  {
    callWithValues.setName("call-with-values");
  }

  public static Object callWithValues(Procedure paramProcedure1, Procedure paramProcedure2)
    throws Throwable
  {
    Object localObject = paramProcedure1.apply0();
    if ((localObject instanceof Values))
      return ((Values)localObject).call_with(paramProcedure2);
    return paramProcedure2.apply1(localObject);
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Procedure.checkArgCount(this, 2);
    Object[] arrayOfObject = paramCallContext.getArgs();
    Object localObject = ((Procedure)arrayOfObject[0]).apply0();
    Procedure localProcedure = (Procedure)arrayOfObject[1];
    if ((localObject instanceof Values))
    {
      localProcedure.checkN(((Values)localObject).getValues(), paramCallContext);
      return;
    }
    localProcedure.check1(localObject, paramCallContext);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    return callWithValues((Procedure)paramObject1, (Procedure)paramObject2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.call_with_values
 * JD-Core Version:    0.6.2
 */