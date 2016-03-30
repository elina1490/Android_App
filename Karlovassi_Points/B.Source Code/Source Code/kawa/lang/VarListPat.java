package kawa.lang;

import gnu.lists.Consumer;
import gnu.lists.Pair;

public class VarListPat extends Pattern
{
  int min_length;

  public VarListPat(int paramInt)
  {
    this.min_length = paramInt;
  }

  public boolean match(Object paramObject, Object[] paramArrayOfObject, int paramInt)
  {
    int i = 0;
    while (i < this.min_length)
      if ((paramObject instanceof Pair))
      {
        Pair localPair = (Pair)paramObject;
        paramArrayOfObject[(paramInt + i)] = localPair.getCar();
        paramObject = localPair.getCdr();
        i++;
      }
      else
      {
        return false;
      }
    paramArrayOfObject[(paramInt + i)] = paramObject;
    return true;
  }

  public void print(Consumer paramConsumer)
  {
    paramConsumer.write("#<varlist-pattern min:");
    paramConsumer.writeInt(this.min_length);
    paramConsumer.write(62);
  }

  public int varCount()
  {
    return 1 + this.min_length;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.VarListPat
 * JD-Core Version:    0.6.2
 */