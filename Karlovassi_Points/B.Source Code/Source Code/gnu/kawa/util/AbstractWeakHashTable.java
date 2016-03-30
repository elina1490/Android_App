package gnu.kawa.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map.Entry;

public abstract class AbstractWeakHashTable<K, V> extends AbstractHashTable<WEntry<K, V>, K, V>
{
  ReferenceQueue<V> rqueue = new ReferenceQueue();

  public AbstractWeakHashTable()
  {
    super(64);
  }

  public AbstractWeakHashTable(int paramInt)
  {
    super(paramInt);
  }

  static <Entry extends Map.Entry<K, V>, K, V> void cleanup(AbstractHashTable<Entry, ?, ?> paramAbstractHashTable, ReferenceQueue<?> paramReferenceQueue)
  {
    Map.Entry localEntry1 = (Map.Entry)paramReferenceQueue.poll();
    if (localEntry1 == null)
      return;
    int i = paramAbstractHashTable.hashToIndex(paramAbstractHashTable.getEntryHashCode(localEntry1));
    Object localObject1 = null;
    Map.Entry localEntry2;
    for (Object localObject2 = paramAbstractHashTable.table[i]; ; localObject2 = localEntry2)
    {
      if (localObject2 != null)
      {
        localEntry2 = paramAbstractHashTable.getEntryNext((Map.Entry)localObject2);
        if (localObject2 != localEntry1)
          break label90;
        if (localObject1 != null)
          break label79;
        paramAbstractHashTable.table[i] = localEntry2;
      }
      while (true)
      {
        paramAbstractHashTable.num_bindings -= 1;
        break;
        label79: paramAbstractHashTable.setEntryNext((Map.Entry)localObject1, localEntry2);
      }
      label90: localObject1 = localObject2;
    }
  }

  protected WEntry<K, V>[] allocEntries(int paramInt)
  {
    return (WEntry[])new WEntry[paramInt];
  }

  protected void cleanup()
  {
    cleanup(this, this.rqueue);
  }

  public V get(Object paramObject, V paramV)
  {
    cleanup();
    return super.get(paramObject, paramV);
  }

  protected int getEntryHashCode(WEntry<K, V> paramWEntry)
  {
    return paramWEntry.hash;
  }

  protected WEntry<K, V> getEntryNext(WEntry<K, V> paramWEntry)
  {
    return paramWEntry.next;
  }

  protected abstract K getKeyFromValue(V paramV);

  protected V getValueIfMatching(WEntry<K, V> paramWEntry, Object paramObject)
  {
    Object localObject = paramWEntry.getValue();
    if ((localObject != null) && (matches(getKeyFromValue(localObject), paramObject)))
      return localObject;
    return null;
  }

  public int hash(Object paramObject)
  {
    return System.identityHashCode(paramObject);
  }

  protected WEntry<K, V> makeEntry(K paramK, int paramInt, V paramV)
  {
    return new WEntry(paramV, this, paramInt);
  }

  public V put(K paramK, V paramV)
  {
    cleanup();
    int i = hash(paramK);
    int j = hashToIndex(i);
    WEntry localWEntry1 = ((WEntry[])this.table)[j];
    Object localObject1 = localWEntry1;
    Object localObject2 = null;
    Object localObject3 = null;
    if (localObject1 == null)
    {
      int k = 1 + this.num_bindings;
      this.num_bindings = k;
      if (k >= ((WEntry[])this.table).length)
      {
        rehash();
        j = hashToIndex(i);
        localWEntry1 = ((WEntry[])this.table)[j];
      }
      WEntry localWEntry3 = makeEntry(null, i, paramV);
      localWEntry3.next = localWEntry1;
      ((WEntry[])this.table)[j] = localWEntry3;
      return localObject3;
    }
    Object localObject4 = ((WEntry)localObject1).getValue();
    if (localObject4 == paramV)
      return localObject4;
    WEntry localWEntry2 = ((WEntry)localObject1).next;
    if ((localObject4 != null) && (valuesEqual(localObject4, paramV)))
      if (localObject2 == null)
        ((WEntry[])this.table)[j] = localWEntry2;
    label180: for (Object localObject5 = localObject4; ; localObject5 = localObject3)
    {
      localObject1 = localWEntry2;
      localObject3 = localObject5;
      break;
      localObject2.next = localWEntry2;
      break label180;
      localObject2 = localObject1;
    }
  }

  protected void setEntryNext(WEntry<K, V> paramWEntry1, WEntry<K, V> paramWEntry2)
  {
    paramWEntry1.next = paramWEntry2;
  }

  protected boolean valuesEqual(V paramV1, V paramV2)
  {
    return paramV1 == paramV2;
  }

  public static class WEntry<K, V> extends WeakReference<V>
    implements Map.Entry<K, V>
  {
    public int hash;
    AbstractWeakHashTable<K, V> htable;
    public WEntry next;

    public WEntry(V paramV, AbstractWeakHashTable<K, V> paramAbstractWeakHashTable, int paramInt)
    {
      super(paramAbstractWeakHashTable.rqueue);
      this.htable = paramAbstractWeakHashTable;
      this.hash = paramInt;
    }

    public K getKey()
    {
      Object localObject = get();
      if (localObject == null)
        return null;
      return this.htable.getKeyFromValue(localObject);
    }

    public V getValue()
    {
      return get();
    }

    public V setValue(V paramV)
    {
      throw new UnsupportedOperationException();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.AbstractWeakHashTable
 * JD-Core Version:    0.6.2
 */