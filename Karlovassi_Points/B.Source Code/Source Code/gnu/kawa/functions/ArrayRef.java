package gnu.kawa.functions;

import gnu.lists.Array;
import gnu.lists.Sequence;
import gnu.mapping.ProcedureN;

public class ArrayRef extends ProcedureN
{
  public static final ArrayRef arrayRef = new ArrayRef();

  public static Object arrayRef(Array paramArray, Sequence paramSequence)
  {
    int i = paramSequence.size();
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++)
      arrayOfInt[j] = ((Number)paramSequence.get(j)).intValue();
    return paramArray.get(arrayOfInt);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    if ((paramObject2 instanceof Sequence))
      return arrayRef((Array)paramObject1, (Sequence)paramObject2);
    return super.apply2(paramObject1, paramObject2);
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    Array localArray = (Array)paramArrayOfObject[0];
    if (paramArrayOfObject.length == 2)
    {
      Object localObject = paramArrayOfObject[1];
      if ((localObject instanceof Sequence))
        return arrayRef(localArray, (Sequence)localObject);
    }
    int[] arrayOfInt = new int[paramArrayOfObject.length - 1];
    int i = paramArrayOfObject.length - 1;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      arrayOfInt[i] = ((Number)paramArrayOfObject[(i + 1)]).intValue();
    }
    return localArray.get(arrayOfInt);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.ArrayRef
 * JD-Core Version:    0.6.2
 */