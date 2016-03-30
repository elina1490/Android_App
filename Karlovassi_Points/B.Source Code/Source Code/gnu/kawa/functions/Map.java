package gnu.kawa.functions;

import gnu.expr.Declaration;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;

public class Map extends ProcedureN
{
  final Declaration applyFieldDecl;
  final ApplyToArgs applyToArgs;
  boolean collect;
  final IsEq isEq;

  public Map(boolean paramBoolean, ApplyToArgs paramApplyToArgs, Declaration paramDeclaration, IsEq paramIsEq)
  {
  }

  public static void forEach1(Procedure paramProcedure, Object paramObject)
    throws Throwable
  {
    while (paramObject != LList.Empty)
    {
      Pair localPair = (Pair)paramObject;
      paramProcedure.apply1(localPair.getCar());
      paramObject = localPair.getCdr();
    }
  }

  public static Object map1(Procedure paramProcedure, Object paramObject)
    throws Throwable
  {
    LList localLList = LList.Empty;
    Object localObject1 = null;
    Object localObject2 = localLList;
    if (paramObject != LList.Empty)
    {
      Pair localPair1 = (Pair)paramObject;
      Pair localPair2 = new Pair(paramProcedure.apply1(localPair1.getCar()), LList.Empty);
      if (localObject1 == null)
        localObject2 = localPair2;
      while (true)
      {
        localObject1 = localPair2;
        paramObject = localPair1.getCdr();
        break;
        localObject1.setCdr(localPair2);
      }
    }
    return localObject2;
  }

  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    if ((paramObject1 instanceof Procedure))
    {
      Procedure localProcedure = (Procedure)paramObject1;
      if (this.collect)
        return map1(localProcedure, paramObject2);
      forEach1(localProcedure, paramObject2);
      return Values.empty;
    }
    return applyN(new Object[] { paramObject1, paramObject2 });
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    int i = paramArrayOfObject.length - 1;
    Object localObject4;
    if ((i == 1) && ((paramArrayOfObject[0] instanceof Procedure)))
    {
      Procedure localProcedure = (Procedure)paramArrayOfObject[0];
      if (this.collect)
      {
        localObject4 = map1(localProcedure, paramArrayOfObject[1]);
        return localObject4;
      }
      forEach1(localProcedure, paramArrayOfObject[1]);
      return Values.empty;
    }
    Object localObject1 = null;
    Object localObject2;
    label76: Object[] arrayOfObject1;
    int j;
    Object[] arrayOfObject2;
    Object localObject3;
    if (this.collect)
    {
      localObject2 = LList.Empty;
      arrayOfObject1 = new Object[i];
      System.arraycopy(paramArrayOfObject, 1, arrayOfObject1, 0, i);
      if (!(paramArrayOfObject[0] instanceof Procedure))
        break label189;
      j = 0;
      arrayOfObject2 = new Object[i];
      localObject3 = (Procedure)paramArrayOfObject[0];
      localObject4 = localObject2;
    }
    label189: label222: Object localObject5;
    do
    {
      while (true)
      {
        for (int k = 0; ; k++)
        {
          if (k >= i)
            break label222;
          Object localObject6 = arrayOfObject1[k];
          if (localObject6 == LList.Empty)
            break;
          Pair localPair2 = (Pair)localObject6;
          arrayOfObject2[(j + k)] = localPair2.getCar();
          arrayOfObject1[k] = localPair2.getCdr();
        }
        localObject2 = Values.empty;
        break label76;
        j = 1;
        arrayOfObject2 = new Object[i + 1];
        arrayOfObject2[0] = paramArrayOfObject[0];
        localObject3 = this.applyToArgs;
        localObject4 = localObject2;
        localObject1 = null;
      }
      localObject5 = ((Procedure)localObject3).applyN(arrayOfObject2);
    }
    while (!this.collect);
    Pair localPair1 = new Pair(localObject5, LList.Empty);
    if (localObject1 == null)
      localObject4 = localPair1;
    while (true)
    {
      localObject1 = localPair1;
      break;
      localObject1.setCdr(localPair1);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.Map
 * JD-Core Version:    0.6.2
 */