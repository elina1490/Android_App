package gnu.kawa.util;

public class IdentityHashTable<K, V> extends GeneralHashTable<K, V>
{
  public IdentityHashTable()
  {
  }

  public IdentityHashTable(int paramInt)
  {
    super(paramInt);
  }

  public int hash(Object paramObject)
  {
    return System.identityHashCode(paramObject);
  }

  public boolean matches(K paramK, Object paramObject)
  {
    return paramK == paramObject;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.IdentityHashTable
 * JD-Core Version:    0.6.2
 */