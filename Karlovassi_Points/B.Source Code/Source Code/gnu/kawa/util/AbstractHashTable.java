package gnu.kawa.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AbstractHashTable<Entry extends Map.Entry<K, V>, K, V> extends AbstractMap<K, V>
{
  public static final int DEFAULT_INITIAL_SIZE = 64;
  protected int mask;
  protected int num_bindings;
  protected Entry[] table;

  public AbstractHashTable()
  {
    this(64);
  }

  public AbstractHashTable(int paramInt)
  {
    for (int i = 4; paramInt > 1 << i; i++);
    int j = 1 << i;
    this.table = allocEntries(j);
    this.mask = (j - 1);
  }

  protected abstract Entry[] allocEntries(int paramInt);

  public void clear()
  {
    Map.Entry[] arrayOfEntry = this.table;
    int i = arrayOfEntry.length;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      Map.Entry localEntry;
      for (Object localObject = arrayOfEntry[i]; localObject != null; localObject = localEntry)
      {
        localEntry = getEntryNext((Map.Entry)localObject);
        setEntryNext((Map.Entry)localObject, null);
      }
      arrayOfEntry[i] = null;
    }
    this.num_bindings = 0;
  }

  public Set<Map.Entry<K, V>> entrySet()
  {
    return new AbstractEntrySet(this);
  }

  public V get(Object paramObject)
  {
    return get(paramObject, null);
  }

  public V get(Object paramObject, V paramV)
  {
    Map.Entry localEntry = getNode(paramObject);
    if (localEntry == null)
      return paramV;
    return localEntry.getValue();
  }

  protected abstract int getEntryHashCode(Entry paramEntry);

  protected abstract Entry getEntryNext(Entry paramEntry);

  public Entry getNode(Object paramObject)
  {
    int i = hash(paramObject);
    int j = hashToIndex(i);
    for (Map.Entry localEntry = this.table[j]; localEntry != null; localEntry = getEntryNext(localEntry))
      if (matches(paramObject, i, localEntry))
        return localEntry;
    return null;
  }

  public int hash(Object paramObject)
  {
    if (paramObject == null)
      return 0;
    return paramObject.hashCode();
  }

  protected int hashToIndex(int paramInt)
  {
    return (paramInt ^ paramInt >>> 15) & this.mask;
  }

  protected abstract Entry makeEntry(K paramK, int paramInt, V paramV);

  protected boolean matches(Object paramObject, int paramInt, Entry paramEntry)
  {
    return (getEntryHashCode(paramEntry) == paramInt) && (matches(paramEntry.getKey(), paramObject));
  }

  protected boolean matches(K paramK, Object paramObject)
  {
    return (paramK == paramObject) || ((paramK != null) && (paramK.equals(paramObject)));
  }

  public V put(K paramK, int paramInt, V paramV)
  {
    int i = hashToIndex(paramInt);
    Map.Entry localEntry1 = this.table[i];
    for (Map.Entry localEntry2 = localEntry1; ; localEntry2 = getEntryNext(localEntry2))
    {
      if (localEntry2 == null)
      {
        int j = 1 + this.num_bindings;
        this.num_bindings = j;
        if (j >= this.table.length)
        {
          rehash();
          i = hashToIndex(paramInt);
          localEntry1 = this.table[i];
        }
        Map.Entry localEntry3 = makeEntry(paramK, paramInt, paramV);
        setEntryNext(localEntry3, localEntry1);
        this.table[i] = localEntry3;
        return null;
      }
      if (matches(paramK, paramInt, localEntry2))
      {
        Object localObject = localEntry2.getValue();
        localEntry2.setValue(paramV);
        return localObject;
      }
    }
  }

  public V put(K paramK, V paramV)
  {
    return put(paramK, hash(paramK), paramV);
  }

  protected void rehash()
  {
    Map.Entry[] arrayOfEntry1 = this.table;
    int i = arrayOfEntry1.length;
    int j = i * 2;
    Map.Entry[] arrayOfEntry2 = allocEntries(j);
    int k = j - 1;
    this.table = arrayOfEntry2;
    this.mask = k;
    int m = i;
    while (true)
    {
      m--;
      if (m < 0)
        break;
      Object localObject1 = arrayOfEntry1[m];
      if ((localObject1 != null) && (getEntryNext((Map.Entry)localObject1) != null))
      {
        Object localObject3 = null;
        do
        {
          Object localObject4 = localObject1;
          localObject1 = getEntryNext(localObject4);
          setEntryNext(localObject4, (Map.Entry)localObject3);
          localObject3 = localObject4;
        }
        while (localObject1 != null);
        localObject1 = localObject3;
      }
      Map.Entry localEntry;
      for (Object localObject2 = localObject1; localObject2 != null; localObject2 = localEntry)
      {
        localEntry = getEntryNext(localObject2);
        int n = hashToIndex(getEntryHashCode(localObject2));
        setEntryNext(localObject2, arrayOfEntry2[n]);
        arrayOfEntry2[n] = localObject2;
      }
    }
  }

  public V remove(Object paramObject)
  {
    int i = hash(paramObject);
    int j = hashToIndex(i);
    Object localObject1 = null;
    Map.Entry localEntry;
    for (Object localObject2 = this.table[j]; localObject2 != null; localObject2 = localEntry)
    {
      localEntry = getEntryNext((Map.Entry)localObject2);
      if (matches(paramObject, i, (Map.Entry)localObject2))
      {
        if (localObject1 == null)
          this.table[j] = localEntry;
        while (true)
        {
          this.num_bindings -= 1;
          return ((Map.Entry)localObject2).getValue();
          setEntryNext((Map.Entry)localObject1, localEntry);
        }
      }
      localObject1 = localObject2;
    }
    return null;
  }

  protected abstract void setEntryNext(Entry paramEntry1, Entry paramEntry2);

  public int size()
  {
    return this.num_bindings;
  }

  static class AbstractEntrySet<Entry extends Map.Entry<K, V>, K, V> extends AbstractSet<Entry>
  {
    AbstractHashTable<Entry, K, V> htable;

    public AbstractEntrySet(AbstractHashTable<Entry, K, V> paramAbstractHashTable)
    {
      this.htable = paramAbstractHashTable;
    }

    public Iterator<Entry> iterator()
    {
      return new Iterator()
      {
        int curIndex = -1;
        Entry currentEntry;
        Entry nextEntry;
        int nextIndex;
        Entry previousEntry;

        private void advance()
        {
          while (this.nextEntry == null)
          {
            int i = this.nextIndex - 1;
            this.nextIndex = i;
            if (i < 0)
              break;
            this.nextEntry = AbstractHashTable.AbstractEntrySet.this.htable.table[this.nextIndex];
          }
        }

        public boolean hasNext()
        {
          if (this.curIndex < 0)
          {
            this.nextIndex = AbstractHashTable.AbstractEntrySet.this.htable.table.length;
            this.curIndex = this.nextIndex;
            advance();
          }
          return this.nextEntry != null;
        }

        public Entry next()
        {
          if (this.nextEntry == null)
            throw new NoSuchElementException();
          this.previousEntry = this.currentEntry;
          this.currentEntry = this.nextEntry;
          this.curIndex = this.nextIndex;
          this.nextEntry = AbstractHashTable.AbstractEntrySet.this.htable.getEntryNext(this.currentEntry);
          advance();
          return this.currentEntry;
        }

        public void remove()
        {
          if (this.previousEntry == this.currentEntry)
            throw new IllegalStateException();
          if (this.previousEntry == null)
            AbstractHashTable.AbstractEntrySet.this.htable.table[this.curIndex] = this.nextEntry;
          while (true)
          {
            AbstractHashTable localAbstractHashTable = AbstractHashTable.AbstractEntrySet.this.htable;
            localAbstractHashTable.num_bindings -= 1;
            this.previousEntry = this.currentEntry;
            return;
            AbstractHashTable.AbstractEntrySet.this.htable.setEntryNext(this.previousEntry, this.nextEntry);
          }
        }
      };
    }

    public int size()
    {
      return this.htable.size();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.AbstractHashTable
 * JD-Core Version:    0.6.2
 */