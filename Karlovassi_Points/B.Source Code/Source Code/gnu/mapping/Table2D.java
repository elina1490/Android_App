package gnu.mapping;

import java.lang.ref.WeakReference;

public class Table2D
{
  private static Table2D instance = new Table2D();
  int log2Size;
  int mask;
  int num_bindings;
  Entry[] table;

  public Table2D()
  {
    this(64);
  }

  public Table2D(int paramInt)
  {
    for (this.log2Size = 4; paramInt > 1 << this.log2Size; this.log2Size = (1 + this.log2Size));
    int i = 1 << this.log2Size;
    this.table = new Entry[i];
    this.mask = (i - 1);
  }

  public static final Table2D getInstance()
  {
    return instance;
  }

  public Object get(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Entry localEntry = lookup(paramObject1, paramObject2, System.identityHashCode(paramObject1), System.identityHashCode(paramObject2), false);
    if ((localEntry == null) || (localEntry.value == localEntry))
      return paramObject3;
    return localEntry.value;
  }

  public boolean isBound(Object paramObject1, Object paramObject2)
  {
    Entry localEntry = lookup(paramObject1, paramObject2, System.identityHashCode(paramObject1), System.identityHashCode(paramObject2), false);
    return (localEntry != null) && (localEntry.value != localEntry);
  }

  protected Entry lookup(Object paramObject1, Object paramObject2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = (paramInt1 ^ paramInt2) & this.mask;
    Object localObject1 = null;
    Entry localEntry1 = this.table[i];
    Object localObject2 = localEntry1;
    if (localObject2 != null)
    {
      Object localObject5 = ((Entry)localObject2).key1;
      Object localObject6 = ((Entry)localObject2).key2;
      boolean bool = localObject5 instanceof WeakReference;
      int j = 0;
      label79: label102: Entry localEntry3;
      if (bool)
      {
        localObject5 = ((WeakReference)localObject5).get();
        if (localObject5 == null)
          j = 1;
      }
      else
      {
        if ((localObject6 instanceof WeakReference))
        {
          localObject6 = ((WeakReference)localObject6).get();
          if (localObject6 != null)
            break label161;
          j = 1;
        }
        localEntry3 = ((Entry)localObject2).chain;
        if (j == 0)
          break label174;
        if (localObject1 != null)
          break label164;
        this.table[i] = localEntry3;
        label131: this.num_bindings -= 1;
        ((Entry)localObject2).value = localObject2;
      }
      while (true)
      {
        localObject2 = localEntry3;
        break;
        j = 0;
        break label79;
        label161: break label102;
        label164: localObject1.chain = localEntry3;
        break label131;
        label174: if ((localObject5 == paramObject1) && (localObject6 == paramObject2))
          return localObject2;
        localObject1 = localObject2;
      }
    }
    if (paramBoolean)
    {
      Entry localEntry2 = new Entry();
      Object localObject3 = wrapReference(paramObject1);
      Object localObject4 = wrapReference(paramObject2);
      localEntry2.key1 = localObject3;
      localEntry2.key2 = localObject4;
      this.num_bindings = (1 + this.num_bindings);
      localEntry2.chain = localEntry1;
      this.table[i] = localEntry2;
      localEntry2.value = localEntry2;
      return localEntry2;
    }
    return null;
  }

  public Object put(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Entry localEntry = lookup(paramObject1, paramObject2, System.identityHashCode(paramObject1), System.identityHashCode(paramObject2), true);
    Object localObject = localEntry.getValue();
    localEntry.value = paramObject3;
    return localObject;
  }

  void rehash()
  {
    Entry[] arrayOfEntry1 = this.table;
    int i = arrayOfEntry1.length;
    int j = i * 2;
    Entry[] arrayOfEntry2 = new Entry[j];
    int k = j - 1;
    this.num_bindings = 0;
    int m = i;
    m--;
    if (m >= 0)
    {
      Object localObject1 = arrayOfEntry1[m];
      label45: Object localObject2;
      Object localObject3;
      int n;
      label97: label123: Entry localEntry1;
      if (localObject1 != null)
      {
        localObject2 = ((Entry)localObject1).key1;
        localObject3 = ((Entry)localObject1).key2;
        boolean bool = localObject2 instanceof WeakReference;
        n = 0;
        if (bool)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if (localObject2 != null)
            break label149;
          n = 1;
        }
        if ((localObject3 instanceof WeakReference))
        {
          localObject3 = ((WeakReference)localObject3).get();
          if (localObject3 != null)
            break label155;
          n = 1;
        }
        localEntry1 = ((Entry)localObject1).chain;
        if (n == 0)
          break label161;
        ((Entry)localObject1).value = localObject1;
      }
      while (true)
      {
        localObject1 = localEntry1;
        break label45;
        break;
        label149: n = 0;
        break label97;
        label155: n = 0;
        break label123;
        label161: int i1 = k & (System.identityHashCode(localObject2) ^ System.identityHashCode(localObject3));
        Entry localEntry2 = arrayOfEntry2[i1];
        ((Entry)localObject1).chain = localEntry2;
        arrayOfEntry2[i1] = localObject1;
        this.num_bindings = (1 + this.num_bindings);
      }
    }
    this.table = arrayOfEntry2;
    this.log2Size = (1 + this.log2Size);
    this.mask = k;
  }

  public Object remove(Object paramObject1, Object paramObject2)
  {
    return remove(paramObject1, paramObject2, System.identityHashCode(paramObject1) ^ System.identityHashCode(paramObject2));
  }

  public Object remove(Object paramObject1, Object paramObject2, int paramInt)
  {
    return remove(paramObject1, paramObject2, paramInt);
  }

  public Object remove(Object paramObject1, Object paramObject2, int paramInt1, int paramInt2)
  {
    int i = (paramInt1 ^ paramInt2) & this.mask;
    Object localObject1 = null;
    Object localObject2 = this.table[i];
    if (localObject2 != null)
    {
      Object localObject3 = ((Entry)localObject2).key1;
      Object localObject4 = ((Entry)localObject2).key2;
      boolean bool = localObject3 instanceof WeakReference;
      int j = 0;
      label75: label101: Entry localEntry;
      Object localObject5;
      int k;
      if (bool)
      {
        localObject3 = ((WeakReference)localObject3).get();
        if (localObject3 == null)
          j = 1;
      }
      else
      {
        if ((localObject4 instanceof WeakReference))
        {
          localObject4 = ((WeakReference)localObject4).get();
          if (localObject4 != null)
            break label184;
          j = 1;
        }
        localEntry = ((Entry)localObject2).chain;
        localObject5 = ((Entry)localObject2).value;
        if ((localObject3 != paramObject1) || (localObject4 != paramObject2))
          break label190;
        k = 1;
        label130: if ((j == 0) && (k == 0))
          break label206;
        if (localObject1 != null)
          break label196;
        this.table[i] = localEntry;
        label154: this.num_bindings -= 1;
        ((Entry)localObject2).value = localObject2;
      }
      while (true)
      {
        localObject2 = localEntry;
        break;
        j = 0;
        break label75;
        label184: j = 0;
        break label101;
        label190: k = 0;
        break label130;
        label196: localObject1.chain = localEntry;
        break label154;
        label206: if (k != 0)
          return localObject5;
        localObject1 = localObject2;
      }
    }
    return null;
  }

  protected Object wrapReference(Object paramObject)
  {
    if ((paramObject == null) || ((paramObject instanceof Symbol)))
      return paramObject;
    return new WeakReference(paramObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Table2D
 * JD-Core Version:    0.6.2
 */