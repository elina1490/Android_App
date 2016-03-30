package gnu.q2.lang;

import gnu.bytecode.Type;
import gnu.expr.Special;
import gnu.kawa.reflect.Invoke;
import gnu.lists.Consumable;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import java.util.Vector;

public class Q2Apply extends MethodProc
{
  public static Q2Apply q2Apply = new Q2Apply();

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Special localSpecial = Special.dfault;
    Object localObject1 = paramCallContext.getNextArg(localSpecial);
    if (((localObject1 instanceof Procedure)) || ((localObject1 instanceof Type)) || ((localObject1 instanceof Class)))
    {
      Vector localVector = new Vector();
      Object localObject2;
      if ((localObject1 instanceof Procedure))
        localObject2 = (Procedure)localObject1;
      Object localObject4;
      while (true)
      {
        Object localObject3 = paramCallContext.getNextArg(localSpecial);
        if (localObject3 == localSpecial)
        {
          localObject4 = ((Procedure)localObject2).applyN(localVector.toArray());
          if (!(localObject4 instanceof Consumable))
            break;
          ((Consumable)localObject4).consume(paramCallContext.consumer);
          return;
          localVector.add(localObject1);
          localObject2 = Invoke.make;
        }
        else if ((localObject3 instanceof Values))
        {
          Object[] arrayOfObject = ((Values)localObject3).getValues();
          for (int i = 0; i < arrayOfObject.length; i++)
            localVector.add(arrayOfObject[i]);
        }
        else
        {
          localVector.add(localObject3);
        }
      }
      paramCallContext.writeValue(localObject4);
      return;
      if (!(localObject1 instanceof Consumable))
        break label212;
      ((Consumable)localObject1).consume(paramCallContext.consumer);
    }
    while (true)
    {
      localObject1 = paramCallContext.getNextArg(localSpecial);
      if (localObject1 != localSpecial)
        break;
      return;
      label212: paramCallContext.writeValue(localObject1);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.q2.lang.Q2Apply
 * JD-Core Version:    0.6.2
 */