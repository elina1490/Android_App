package gnu.kawa.functions;

import gnu.lists.Array;
import gnu.lists.Sequence;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;

public class ArraySet extends ProcedureN
{
  public static final ArraySet arraySet = new ArraySet();

  public static void arraySet(Array paramArray, Sequence paramSequence, Object paramObject)
  {
    int i = paramSequence.size();
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++)
      arrayOfInt[j] = ((Number)paramSequence.get(j)).intValue();
    paramArray.set(arrayOfInt, paramObject);
  }

  public Object apply3(Object paramObject1, Object paramObject2, Object paramObject3)
    throws Throwable
  {
    if ((paramObject2 instanceof Sequence))
    {
      arraySet((Array)paramObject1, (Sequence)paramObject2, paramObject3);
      return Values.empty;
    }
    return super.apply3(paramObject1, paramObject2, paramObject3);
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    Array localArray = (Array)paramArrayOfObject[0];
    if (paramArrayOfObject.length == 3)
    {
      Object localObject = paramArrayOfObject[1];
      if ((localObject instanceof Sequence))
      {
        arraySet(localArray, (Sequence)localObject, paramArrayOfObject[2]);
        return Values.empty;
      }
    }
    int i = paramArrayOfObject.length - 2;
    int[] arrayOfInt = new int[i];
    int j = i;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      arrayOfInt[j] = ((Number)paramArrayOfObject[(j + 1)]).intValue();
    }
    localArray.set(arrayOfInt, paramArrayOfObject[(i + 1)]);
    return Values.empty;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.ArraySet
 * JD-Core Version:    0.6.2
 */