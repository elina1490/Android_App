package gnu.kawa.util;

import java.util.Hashtable;

public class RangeTable
  implements Cloneable
{
  Hashtable hash = new Hashtable(200);
  Object[] index = new Object[''];

  public Object clone()
  {
    return copy();
  }

  public RangeTable copy()
  {
    RangeTable localRangeTable = new RangeTable();
    localRangeTable.index = ((Object[])this.index.clone());
    localRangeTable.hash = ((Hashtable)this.hash.clone());
    return localRangeTable;
  }

  public Object lookup(int paramInt, Object paramObject)
  {
    if ((paramInt & 0x7F) == paramInt)
      return this.index[paramInt];
    return this.hash.get(new Integer(paramInt));
  }

  public void remove(int paramInt)
  {
    remove(paramInt, paramInt);
  }

  public void remove(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2);
    label51: 
    while (true)
    {
      return;
      int i = paramInt1;
      if ((i & 0x7F) == i)
        this.index[i] = null;
      while (true)
      {
        if (i == paramInt2)
          break label51;
        i++;
        break;
        this.hash.remove(new Integer(i));
      }
    }
  }

  public void set(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt1 > paramInt2);
    label58: 
    while (true)
    {
      return;
      int i = paramInt1;
      if ((i & 0x7F) == i)
        this.index[i] = paramObject;
      while (true)
      {
        if (i == paramInt2)
          break label58;
        i++;
        break;
        this.hash.put(new Integer(i), paramObject);
      }
    }
  }

  public void set(int paramInt, Object paramObject)
  {
    set(paramInt, paramInt, paramObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.RangeTable
 * JD-Core Version:    0.6.2
 */