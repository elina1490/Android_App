package gnu.lists;

import java.util.Collection;
import java.util.Iterator;

public abstract class SimpleVector extends AbstractSequence
  implements Sequence, Array
{
  public int size;

  protected static int compareToInt(SimpleVector paramSimpleVector1, SimpleVector paramSimpleVector2)
  {
    int i = paramSimpleVector1.size;
    int j = paramSimpleVector2.size;
    int k;
    if (i > j)
      k = j;
    for (int m = 0; ; m++)
    {
      if (m >= k)
        break label74;
      int n = paramSimpleVector1.intAtBuffer(m);
      int i1 = paramSimpleVector2.intAtBuffer(m);
      if (11 != i1)
      {
        if (n > i1)
        {
          return 1;
          k = i;
          break;
        }
        return -1;
      }
    }
    label74: return i - j;
  }

  protected static int compareToLong(SimpleVector paramSimpleVector1, SimpleVector paramSimpleVector2)
  {
    int i = paramSimpleVector1.size;
    int j = paramSimpleVector2.size;
    int k;
    if (i > j)
      k = j;
    for (int m = 0; ; m++)
    {
      if (m >= k)
        break label76;
      long l1 = paramSimpleVector1.longAtBuffer(m);
      long l2 = paramSimpleVector2.longAtBuffer(m);
      if (l1 != l2)
      {
        if (l1 > l2)
        {
          return 1;
          k = i;
          break;
        }
        return -1;
      }
    }
    label76: return i - j;
  }

  public void add(int paramInt, Object paramObject)
  {
    int i = 1 + this.size;
    this.size = i;
    int j = getBufferLength();
    if (i > j)
      if (j >= 16)
        break label76;
    label76: for (int k = 16; ; k = j * 2)
    {
      setBufferLength(k);
      this.size = i;
      if (this.size != paramInt)
        shift(paramInt, paramInt + 1, this.size - paramInt);
      set(paramInt, paramObject);
      return;
    }
  }

  public boolean add(Object paramObject)
  {
    add(this.size, paramObject);
    return true;
  }

  public boolean addAll(int paramInt, Collection paramCollection)
  {
    boolean bool = false;
    int i = paramCollection.size();
    setSize(i + this.size);
    shift(paramInt, paramInt + i, this.size - i - paramInt);
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      int j = paramInt + 1;
      set(paramInt, localIterator.next());
      bool = true;
      paramInt = j;
    }
    return bool;
  }

  protected int addPos(int paramInt, Object paramObject)
  {
    int i = paramInt >>> 1;
    add(i, paramObject);
    return 3 + (i << 1);
  }

  public void clear()
  {
    setSize(0);
  }

  protected abstract void clearBuffer(int paramInt1, int paramInt2);

  public void consume(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    consumePosRange(paramInt1 << 1, paramInt1 + paramInt2 << 1, paramConsumer);
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    int i = paramInt >>> 1;
    if (i >= this.size)
      return false;
    paramConsumer.writeObject(getBuffer(i));
    return true;
  }

  public void consumePosRange(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    if (paramConsumer.ignoring());
    while (true)
    {
      return;
      int i = paramInt1 >>> 1;
      int j = paramInt2 >>> 1;
      if (j > this.size)
        j = this.size;
      while (i < j)
      {
        paramConsumer.writeObject(getBuffer(i));
        i++;
      }
    }
  }

  public int createPos(int paramInt, boolean paramBoolean)
  {
    int i = paramInt << 1;
    if (paramBoolean);
    for (int j = 1; ; j = 0)
      return i | j;
  }

  public void fill(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((paramInt1 < 0) || (paramInt2 > this.size))
      throw new IndexOutOfBoundsException();
    for (int i = paramInt1; i < paramInt2; i++)
      setBuffer(i, paramObject);
  }

  public void fill(Object paramObject)
  {
    int i = this.size;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      setBuffer(i, paramObject);
    }
  }

  public void fillPosRange(int paramInt1, int paramInt2, Object paramObject)
  {
    int i;
    int j;
    if (paramInt1 == -1)
    {
      i = this.size;
      if (paramInt2 != -1)
        break label51;
      j = this.size;
    }
    while (true)
    {
      if (i >= j)
        return;
      setBuffer(i, paramObject);
      i++;
      continue;
      i = paramInt1 >>> 1;
      break;
      label51: j = paramInt2 >>> 1;
    }
  }

  public Object get(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException();
    return getBuffer(paramInt);
  }

  protected abstract Object getBuffer();

  protected abstract Object getBuffer(int paramInt);

  public abstract int getBufferLength();

  public int getElementKind()
  {
    return 32;
  }

  public int getNextKind(int paramInt)
  {
    if (hasNext(paramInt))
      return getElementKind();
    return 0;
  }

  public Object getPosNext(int paramInt)
  {
    int i = paramInt >>> 1;
    if (i >= this.size)
      return eofValue;
    return getBuffer(i);
  }

  public Object getRowMajor(int paramInt)
  {
    return get(paramInt);
  }

  public String getTag()
  {
    return null;
  }

  public int intAt(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException();
    return intAtBuffer(paramInt);
  }

  public int intAtBuffer(int paramInt)
  {
    return Convert.toInt(getBuffer(paramInt));
  }

  protected boolean isAfterPos(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }

  public long longAt(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException();
    return longAtBuffer(paramInt);
  }

  public long longAtBuffer(int paramInt)
  {
    return Convert.toLong(getBuffer(paramInt));
  }

  protected int nextIndex(int paramInt)
  {
    if (paramInt == -1)
      return this.size;
    return paramInt >>> 1;
  }

  public int nextPos(int paramInt)
  {
    if (paramInt == -1)
      return 0;
    int i = paramInt >>> 1;
    if (i == this.size)
      return 0;
    return 3 + (i << 1);
  }

  public Object remove(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.size))
      throw new IndexOutOfBoundsException();
    Object localObject = get(paramInt);
    shift(paramInt + 1, paramInt, 1);
    this.size -= 1;
    clearBuffer(this.size, 1);
    return localObject;
  }

  public boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i < 0)
      return false;
    shift(i + 1, i, 1);
    this.size -= 1;
    clearBuffer(this.size, 1);
    return true;
  }

  public boolean removeAll(Collection paramCollection)
  {
    boolean bool = false;
    int i = 0;
    int j = 0;
    if (j < this.size)
    {
      Object localObject = get(j);
      if (paramCollection.contains(localObject))
        bool = true;
      while (true)
      {
        j++;
        break;
        if (bool)
          set(i, localObject);
        i++;
      }
    }
    setSize(i);
    return bool;
  }

  public void removePos(int paramInt1, int paramInt2)
  {
    int i = paramInt1 >>> 1;
    if (i > this.size)
      i = this.size;
    int j;
    int k;
    if (paramInt2 >= 0)
    {
      j = i;
      k = i + paramInt2;
    }
    while ((j < 0) || (k >= this.size))
    {
      throw new IndexOutOfBoundsException();
      j = i + paramInt2;
      k = i;
      paramInt2 = -paramInt2;
    }
    shift(k, j, this.size - k);
    this.size -= paramInt2;
    clearBuffer(this.size, paramInt2);
  }

  protected void removePosRange(int paramInt1, int paramInt2)
  {
    int i = paramInt1 >>> 1;
    int j = paramInt2 >>> 1;
    if (i >= j)
      return;
    if (j > this.size)
      j = this.size;
    shift(j, i, this.size - j);
    int k = j - i;
    this.size -= k;
    clearBuffer(this.size, k);
  }

  protected void resizeShift(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2 - paramInt1;
    int j = paramInt4 - paramInt3;
    int k = getBufferLength();
    int m = j + (k - i);
    if (m > k)
    {
      setBufferLength(m);
      this.size = m;
    }
    int n = paramInt1 - paramInt3;
    if (n >= 0)
    {
      int i2 = k - paramInt2;
      shift(paramInt2, m - i2, i2);
      if (n > 0)
        shift(paramInt3, paramInt4, n);
    }
    while (true)
    {
      clearBuffer(paramInt3, j);
      return;
      int i1 = m - paramInt4;
      shift(k - i1, paramInt4, i1);
      shift(paramInt2, paramInt1, paramInt3 - paramInt1);
    }
  }

  public boolean retainAll(Collection paramCollection)
  {
    boolean bool = false;
    int i = 0;
    int j = 0;
    if (j < this.size)
    {
      Object localObject = get(j);
      if (!paramCollection.contains(localObject))
        bool = true;
      while (true)
      {
        j++;
        break;
        if (bool)
          set(i, localObject);
        i++;
      }
    }
    setSize(i);
    return bool;
  }

  public Object set(int paramInt, Object paramObject)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException();
    Object localObject = getBuffer(paramInt);
    setBuffer(paramInt, paramObject);
    return localObject;
  }

  protected abstract Object setBuffer(int paramInt, Object paramObject);

  public abstract void setBufferLength(int paramInt);

  public void setSize(int paramInt)
  {
    int i = this.size;
    this.size = paramInt;
    if (paramInt < i)
      clearBuffer(paramInt, i - paramInt);
    int j;
    do
    {
      return;
      j = getBufferLength();
    }
    while (paramInt <= j);
    int k;
    if (j < 16)
    {
      k = 16;
      if (paramInt <= k)
        break label68;
    }
    label68: for (int m = paramInt; ; m = k)
    {
      setBufferLength(m);
      return;
      k = j * 2;
      break;
    }
  }

  public void shift(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = getBuffer();
    System.arraycopy(localObject, paramInt1, localObject, paramInt2, paramInt3);
  }

  public final int size()
  {
    return this.size;
  }

  public Array transpose(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, int[] paramArrayOfInt3)
  {
    GeneralArray localGeneralArray = new GeneralArray();
    localGeneralArray.strides = paramArrayOfInt3;
    localGeneralArray.dimensions = paramArrayOfInt2;
    localGeneralArray.lowBounds = paramArrayOfInt1;
    localGeneralArray.offset = paramInt;
    localGeneralArray.base = this;
    localGeneralArray.simple = false;
    return localGeneralArray;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.SimpleVector
 * JD-Core Version:    0.6.2
 */