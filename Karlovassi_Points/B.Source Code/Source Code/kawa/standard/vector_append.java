package kawa.standard;

import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongType;

public class vector_append extends ProcedureN
{
  public static final vector_append vectorAppend = new vector_append("vector-append");

  public vector_append(String paramString)
  {
    super(paramString);
  }

  public static FVector apply$V(Object[] paramArrayOfObject)
  {
    int i = 0;
    int j = paramArrayOfObject.length;
    int k = j;
    while (true)
    {
      k--;
      if (k < 0)
        break;
      Object localObject2 = paramArrayOfObject[k];
      if ((localObject2 instanceof FVector))
      {
        i += ((FVector)localObject2).size();
      }
      else
      {
        int i6 = LList.listLength(localObject2, false);
        if (i6 < 0)
          throw new WrongType(vectorAppend, k, localObject2, "list or vector");
        i += i6;
      }
    }
    Object[] arrayOfObject = new Object[i];
    int m = 0;
    int n = 0;
    if (n < j)
    {
      Object localObject1 = paramArrayOfObject[n];
      if ((localObject1 instanceof FVector))
      {
        FVector localFVector = (FVector)localObject1;
        int i2 = localFVector.size();
        int i3 = 0;
        int i5;
        for (int i4 = m; i3 < i2; i4 = i5)
        {
          i5 = i4 + 1;
          arrayOfObject[i4] = localFVector.get(i3);
          i3++;
        }
        m = i4;
      }
      while (true)
      {
        n++;
        break;
        if ((localObject1 instanceof Pair))
          while (localObject1 != LList.Empty)
          {
            Pair localPair = (Pair)localObject1;
            int i1 = m + 1;
            arrayOfObject[m] = localPair.getCar();
            localObject1 = localPair.getCdr();
            m = i1;
          }
      }
    }
    return new FVector(arrayOfObject);
  }

  public Object applyN(Object[] paramArrayOfObject)
  {
    return apply$V(paramArrayOfObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.vector_append
 * JD-Core Version:    0.6.2
 */