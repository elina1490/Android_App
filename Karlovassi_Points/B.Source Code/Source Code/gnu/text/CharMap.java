package gnu.text;

import gnu.kawa.util.AbstractWeakHashTable;
import gnu.kawa.util.AbstractWeakHashTable.WEntry;

class CharMap extends AbstractWeakHashTable<Char, Char>
{
  public Char get(int paramInt)
  {
    cleanup();
    int i = hashToIndex(paramInt);
    for (AbstractWeakHashTable.WEntry localWEntry = ((AbstractWeakHashTable.WEntry[])this.table)[i]; localWEntry != null; localWEntry = localWEntry.next)
    {
      Char localChar2 = (Char)localWEntry.getValue();
      if (localChar2.intValue() == paramInt)
        return localChar2;
    }
    Char localChar1 = new Char(paramInt);
    super.put(localChar1, localChar1);
    return localChar1;
  }

  protected Char getKeyFromValue(Char paramChar)
  {
    return paramChar;
  }

  protected boolean matches(Char paramChar1, Char paramChar2)
  {
    return paramChar1.intValue() == paramChar2.intValue();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.CharMap
 * JD-Core Version:    0.6.2
 */