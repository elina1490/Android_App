package gnu.kawa.functions;

import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;

public class Apply extends ProcedureN
{
  ApplyToArgs applyToArgs;

  public Apply(String paramString, ApplyToArgs paramApplyToArgs)
  {
    super(paramString);
    this.applyToArgs = paramApplyToArgs;
  }

  public static Object[] getArguments(Object[] paramArrayOfObject, int paramInt, Procedure paramProcedure)
  {
    int i = paramArrayOfObject.length;
    if (i < paramInt + 1)
      throw new WrongArguments("apply", 2, "(apply proc [args] args) [count:" + i + " skip:" + paramInt + "]");
    Object localObject1 = paramArrayOfObject[(i - 1)];
    int j;
    if ((localObject1 instanceof Object[]))
    {
      Object[] arrayOfObject2 = (Object[])localObject1;
      if (i == 2)
        return arrayOfObject2;
      j = arrayOfObject2.length;
    }
    while (j < 0)
    {
      throw new WrongType(paramProcedure, i, localObject1, "sequence or array");
      if ((localObject1 instanceof Sequence))
        j = ((Sequence)localObject1).size();
      else
        j = -1;
    }
    Object[] arrayOfObject1 = new Object[j + (i - paramInt - 1)];
    for (int k = 0; k < i - paramInt - 1; k++)
      arrayOfObject1[k] = paramArrayOfObject[(k + paramInt)];
    Object localObject3;
    if ((localObject1 instanceof Object[]))
    {
      System.arraycopy((Object[])localObject1, 0, arrayOfObject1, k, j);
      localObject3 = localObject1;
      return arrayOfObject1;
    }
    while (true)
    {
      Object localObject2;
      int m;
      int n;
      if ((localObject2 instanceof Pair))
      {
        Pair localPair = (Pair)localObject2;
        int i4 = m + 1;
        arrayOfObject1[m] = localPair.getCar();
        Object localObject4 = localPair.getCdr();
        n--;
        localObject2 = localObject4;
        m = i4;
      }
      else
      {
        if (n > 0)
        {
          Sequence localSequence = (Sequence)localObject2;
          int i1 = 0;
          int i3;
          for (int i2 = m; i1 < n; i2 = i3)
          {
            i3 = i2 + 1;
            arrayOfObject1[i2] = localSequence.get(i1);
            i1++;
          }
          localObject3 = localObject2;
          break;
        }
        localObject3 = localObject2;
        break;
        m = k;
        localObject2 = localObject1;
        n = j;
      }
    }
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object[] arrayOfObject = paramCallContext.getArgs();
    this.applyToArgs.checkN(getArguments(arrayOfObject, 0, this), paramCallContext);
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    return this.applyToArgs.applyN(getArguments(paramArrayOfObject, 0, this));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.Apply
 * JD-Core Version:    0.6.2
 */