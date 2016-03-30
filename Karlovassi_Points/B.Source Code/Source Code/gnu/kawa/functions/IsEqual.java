package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure2;

public class IsEqual extends Procedure2
{
  Language language;

  public IsEqual(Language paramLanguage, String paramString)
  {
    this.language = paramLanguage;
    setName(paramString);
  }

  public static boolean apply(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2)
      return true;
    if ((paramObject1 == null) || (paramObject2 == null))
      return false;
    if (((paramObject1 instanceof Number)) && ((paramObject2 instanceof Number)))
      return numberEquals((Number)paramObject1, (Number)paramObject2);
    if ((paramObject1 instanceof CharSequence))
    {
      if (!(paramObject2 instanceof CharSequence))
        return false;
      CharSequence localCharSequence1 = (CharSequence)paramObject1;
      CharSequence localCharSequence2 = (CharSequence)paramObject2;
      int k = localCharSequence1.length();
      if (k != localCharSequence2.length())
        return false;
      int m = k;
      do
      {
        m--;
        if (m < 0)
          break;
      }
      while (localCharSequence1.charAt(m) == localCharSequence2.charAt(m));
      return false;
      return true;
    }
    if ((paramObject1 instanceof FVector))
    {
      if (!(paramObject2 instanceof FVector))
        return false;
      FVector localFVector1 = (FVector)paramObject1;
      FVector localFVector2 = (FVector)paramObject2;
      int i = localFVector1.size;
      if ((localFVector2.data == null) || (localFVector2.size != i))
        return false;
      Object[] arrayOfObject1 = localFVector1.data;
      Object[] arrayOfObject2 = localFVector2.data;
      int j = i;
      do
      {
        j--;
        if (j < 0)
          break;
      }
      while (apply(arrayOfObject1[j], arrayOfObject2[j]));
      return false;
      return true;
    }
    if ((paramObject1 instanceof LList))
    {
      if ((!(paramObject1 instanceof Pair)) || (!(paramObject2 instanceof Pair)))
        return false;
      Pair localPair1 = (Pair)paramObject1;
      Object localObject2;
      for (Pair localPair2 = (Pair)paramObject2; ; localPair2 = (Pair)localObject2)
      {
        if (!apply(localPair1.getCar(), localPair2.getCar()))
          return false;
        Object localObject1 = localPair1.getCdr();
        localObject2 = localPair2.getCdr();
        if (localObject1 == localObject2)
          return true;
        if ((localObject1 == null) || (localObject2 == null))
          return false;
        if ((!(localObject1 instanceof Pair)) || (!(localObject2 instanceof Pair)))
          return apply(localObject1, localObject2);
        localPair1 = (Pair)localObject1;
      }
    }
    return paramObject1.equals(paramObject2);
  }

  public static boolean numberEquals(Number paramNumber1, Number paramNumber2)
  {
    boolean bool1 = Arithmetic.isExact(paramNumber1);
    boolean bool2 = Arithmetic.isExact(paramNumber2);
    if ((bool1) && (bool2))
      return NumberCompare.$Eq(paramNumber1, paramNumber2);
    return (bool1 == bool2) && (paramNumber1.equals(paramNumber2));
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    return this.language.booleanObject(apply(paramObject1, paramObject2));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.IsEqual
 * JD-Core Version:    0.6.2
 */