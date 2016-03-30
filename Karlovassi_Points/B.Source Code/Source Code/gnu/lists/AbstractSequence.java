package gnu.lists;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class AbstractSequence
{
  public static int compare(AbstractSequence paramAbstractSequence1, int paramInt1, AbstractSequence paramAbstractSequence2, int paramInt2)
  {
    if (paramAbstractSequence1 == paramAbstractSequence2)
      return paramAbstractSequence1.compare(paramInt1, paramInt2);
    return paramAbstractSequence1.stableCompare(paramAbstractSequence2);
  }

  public static RuntimeException unsupportedException(String paramString)
  {
    return new UnsupportedOperationException(paramString);
  }

  public void add(int paramInt, Object paramObject)
  {
    int i = createPos(paramInt, false);
    addPos(i, paramObject);
    releasePos(i);
  }

  public boolean add(Object paramObject)
  {
    addPos(endPos(), paramObject);
    return true;
  }

  public boolean addAll(int paramInt, Collection paramCollection)
  {
    boolean bool = false;
    int i = createPos(paramInt, false);
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      i = addPos(i, localIterator.next());
      bool = true;
    }
    releasePos(i);
    return bool;
  }

  public boolean addAll(Collection paramCollection)
  {
    return addAll(size(), paramCollection);
  }

  protected int addPos(int paramInt, Object paramObject)
  {
    throw unsupported("addPos");
  }

  public void clear()
  {
    removePos(startPos(), endPos());
  }

  public int compare(int paramInt1, int paramInt2)
  {
    int i = nextIndex(paramInt1);
    int j = nextIndex(paramInt2);
    if (i < j)
      return -1;
    if (i > j)
      return 1;
    return 0;
  }

  public final int compare(SeqPosition paramSeqPosition1, SeqPosition paramSeqPosition2)
  {
    return compare(paramSeqPosition1.ipos, paramSeqPosition2.ipos);
  }

  public void consume(Consumer paramConsumer)
  {
    boolean bool = this instanceof Sequence;
    if (bool)
      paramConsumer.startElement("#sequence");
    consumePosRange(startPos(), endPos(), paramConsumer);
    if (bool)
      paramConsumer.endElement();
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    int i = nextPos(paramInt);
    if (i == 0)
      return false;
    consumePosRange(paramInt, i, paramConsumer);
    return true;
  }

  public void consumePosRange(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    if (paramConsumer.ignoring())
      return;
    for (int i = copyPos(paramInt1); !equals(i, paramInt2); i = nextPos(i))
    {
      if (!hasNext(i))
        throw new RuntimeException();
      paramConsumer.writeObject(getPosNext(i));
    }
    releasePos(i);
  }

  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }

  public boolean containsAll(Collection paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      if (!contains(localIterator.next()))
        return false;
    return true;
  }

  public int copyPos(int paramInt)
  {
    return paramInt;
  }

  public abstract int createPos(int paramInt, boolean paramBoolean);

  public int createRelativePos(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return createPos(paramInt2 + nextIndex(paramInt1), paramBoolean);
  }

  public final Enumeration elements()
  {
    return getIterator();
  }

  public int endPos()
  {
    return -1;
  }

  public boolean equals(int paramInt1, int paramInt2)
  {
    return compare(paramInt1, paramInt2) == 0;
  }

  public boolean equals(Object paramObject)
  {
    if ((!(this instanceof List)) || (!(paramObject instanceof List)))
      return this == paramObject;
    Iterator localIterator1 = iterator();
    Iterator localIterator2 = ((List)paramObject).iterator();
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        boolean bool = localIterator1.hasNext();
        if (bool != localIterator2.hasNext())
          return false;
        if (!bool)
          return true;
        localObject1 = localIterator1.next();
        localObject2 = localIterator2.next();
        if (localObject1 != null)
          break;
      }
      while (localObject2 == null);
      return false;
    }
    while (localObject1.equals(localObject2));
    return false;
  }

  public void fill(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = createPos(paramInt1, false);
    int j = createPos(paramInt2, true);
    while (compare(i, j) < 0)
    {
      setPosNext(i, paramObject);
      i = nextPos(i);
    }
    releasePos(i);
    releasePos(j);
  }

  public void fill(Object paramObject)
  {
    int i = startPos();
    while (true)
    {
      i = nextPos(i);
      if (i == 0)
        break;
      setPosPrevious(i, paramObject);
    }
  }

  public void fillPosRange(int paramInt1, int paramInt2, Object paramObject)
  {
    for (int i = copyPos(paramInt1); compare(i, paramInt2) < 0; i = nextPos(i))
      setPosNext(i, paramObject);
    releasePos(i);
  }

  public int firstAttributePos(int paramInt)
  {
    return 0;
  }

  public int firstChildPos(int paramInt)
  {
    return 0;
  }

  public int firstChildPos(int paramInt, ItemPredicate paramItemPredicate)
  {
    int i = firstChildPos(paramInt);
    if (i == 0)
      return 0;
    if (paramItemPredicate.isInstancePos(this, i))
      return i;
    return nextMatching(i, paramItemPredicate, endPos(), false);
  }

  protected int fromEndIndex(int paramInt)
  {
    return size() - nextIndex(paramInt);
  }

  public abstract Object get(int paramInt);

  public Object get(int[] paramArrayOfInt)
  {
    return get(paramArrayOfInt[0]);
  }

  public Object getAttribute(int paramInt)
  {
    return null;
  }

  public int getAttributeLength()
  {
    return 0;
  }

  protected int getContainingSequenceSize(int paramInt)
  {
    return size();
  }

  public int getEffectiveIndex(int[] paramArrayOfInt)
  {
    return paramArrayOfInt[0];
  }

  protected int getIndexDifference(int paramInt1, int paramInt2)
  {
    return nextIndex(paramInt1) - nextIndex(paramInt2);
  }

  public final SeqPosition getIterator()
  {
    return getIterator(0);
  }

  public SeqPosition getIterator(int paramInt)
  {
    return new SeqPosition(this, paramInt, false);
  }

  public SeqPosition getIteratorAtPos(int paramInt)
  {
    return new SeqPosition(this, copyPos(paramInt));
  }

  public int getLowBound(int paramInt)
  {
    return 0;
  }

  public int getNextKind(int paramInt)
  {
    if (hasNext(paramInt))
      return 32;
    return 0;
  }

  public String getNextTypeName(int paramInt)
  {
    return null;
  }

  public Object getNextTypeObject(int paramInt)
  {
    return null;
  }

  public Object getPosNext(int paramInt)
  {
    if (!hasNext(paramInt))
      return Sequence.eofValue;
    return get(nextIndex(paramInt));
  }

  public Object getPosPrevious(int paramInt)
  {
    int i = nextIndex(paramInt);
    if (i <= 0)
      return Sequence.eofValue;
    return get(i - 1);
  }

  public int getSize(int paramInt)
  {
    if (paramInt == 0)
      return size();
    return 1;
  }

  protected boolean gotoAttributesStart(TreePosition paramTreePosition)
  {
    return false;
  }

  public final boolean gotoChildrenStart(TreePosition paramTreePosition)
  {
    int i = firstChildPos(paramTreePosition.getPos());
    if (i == 0)
      return false;
    paramTreePosition.push(this, i);
    return true;
  }

  protected boolean gotoParent(TreePosition paramTreePosition)
  {
    if (paramTreePosition.depth < 0)
      return false;
    paramTreePosition.pop();
    return true;
  }

  public boolean hasNext(int paramInt)
  {
    return nextIndex(paramInt) != size();
  }

  protected boolean hasPrevious(int paramInt)
  {
    return nextIndex(paramInt) != 0;
  }

  public int hashCode()
  {
    int i = 1;
    int j = startPos();
    j = nextPos(j);
    if (j != 0)
    {
      Object localObject = getPosPrevious(j);
      int k = i * 31;
      if (localObject == null);
      for (int m = 0; ; m = localObject.hashCode())
      {
        i = k + m;
        break;
      }
    }
    return i;
  }

  public int indexOf(Object paramObject)
  {
    int i = 0;
    int j = startPos();
    while (true)
    {
      j = nextPos(j);
      if (j == 0)
        break;
      Object localObject = getPosPrevious(j);
      if (paramObject == null)
      {
        if (localObject != null);
      }
      else
        while (paramObject.equals(localObject))
        {
          releasePos(j);
          return i;
        }
      i++;
    }
    return -1;
  }

  protected boolean isAfterPos(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }

  public boolean isEmpty()
  {
    return size() == 0;
  }

  public final Iterator iterator()
  {
    return getIterator();
  }

  public int lastIndexOf(Object paramObject)
  {
    int i = size();
    Object localObject;
    do
    {
      i--;
      if (i < 0)
        break label39;
      localObject = get(i);
      if (paramObject != null)
        break;
    }
    while (localObject != null);
    while (true)
    {
      return i;
      if (!paramObject.equals(localObject))
        break;
    }
    label39: return -1;
  }

  public final ListIterator listIterator()
  {
    return getIterator(0);
  }

  public final ListIterator listIterator(int paramInt)
  {
    return getIterator(paramInt);
  }

  protected int nextIndex(int paramInt)
  {
    return getIndexDifference(paramInt, startPos());
  }

  public final int nextIndex(SeqPosition paramSeqPosition)
  {
    return nextIndex(paramSeqPosition.ipos);
  }

  public int nextMatching(int paramInt1, ItemPredicate paramItemPredicate, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
      throw unsupported("nextMatching with descend");
    int i = paramInt1;
    do
    {
      if (compare(i, paramInt2) >= 0)
        return 0;
      i = nextPos(i);
    }
    while (!paramItemPredicate.isInstancePos(this, i));
    return i;
  }

  public int nextPos(int paramInt)
  {
    if (!hasNext(paramInt))
      return 0;
    int i = createRelativePos(paramInt, 1, true);
    releasePos(paramInt);
    return i;
  }

  public int parentPos(int paramInt)
  {
    return endPos();
  }

  public int previousPos(int paramInt)
  {
    if (!hasPrevious(paramInt))
      return 0;
    int i = createRelativePos(paramInt, -1, false);
    releasePos(paramInt);
    return i;
  }

  public int rank()
  {
    return 1;
  }

  protected void releasePos(int paramInt)
  {
  }

  public Object remove(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= size()))
      throw new IndexOutOfBoundsException();
    int i = createPos(paramInt, false);
    Object localObject = getPosNext(i);
    removePos(i, 1);
    releasePos(i);
    return localObject;
  }

  public boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i < 0)
      return false;
    int j = createPos(i, false);
    removePos(j, 1);
    releasePos(j);
    return true;
  }

  public boolean removeAll(Collection paramCollection)
  {
    boolean bool = false;
    int i = startPos();
    while (true)
    {
      i = nextPos(i);
      if (i == 0)
        break;
      if (paramCollection.contains(getPosPrevious(i)))
      {
        removePos(i, -1);
        bool = true;
      }
    }
    return bool;
  }

  public void removePos(int paramInt1, int paramInt2)
  {
    int i = createRelativePos(paramInt1, paramInt2, false);
    if (paramInt2 >= 0)
      removePosRange(paramInt1, i);
    while (true)
    {
      releasePos(i);
      return;
      removePosRange(i, paramInt1);
    }
  }

  protected void removePosRange(int paramInt1, int paramInt2)
  {
    throw unsupported("removePosRange");
  }

  public boolean retainAll(Collection paramCollection)
  {
    boolean bool = false;
    int i = startPos();
    while (true)
    {
      i = nextPos(i);
      if (i == 0)
        break;
      if (!paramCollection.contains(getPosPrevious(i)))
      {
        removePos(i, -1);
        bool = true;
      }
    }
    return bool;
  }

  public Object set(int paramInt, Object paramObject)
  {
    throw unsupported("set");
  }

  public Object set(int[] paramArrayOfInt, Object paramObject)
  {
    return set(paramArrayOfInt[0], paramObject);
  }

  protected void setPosNext(int paramInt, Object paramObject)
  {
    int i = nextIndex(paramInt);
    if (i >= size())
      throw new IndexOutOfBoundsException();
    set(i, paramObject);
  }

  protected void setPosPrevious(int paramInt, Object paramObject)
  {
    int i = nextIndex(paramInt);
    if (i == 0)
      throw new IndexOutOfBoundsException();
    set(i - 1, paramObject);
  }

  public abstract int size();

  public int stableCompare(AbstractSequence paramAbstractSequence)
  {
    int i = System.identityHashCode(this);
    int j = System.identityHashCode(paramAbstractSequence);
    if (i < j)
      return -1;
    if (i > j)
      return 1;
    return 0;
  }

  public int startPos()
  {
    return 0;
  }

  public List subList(int paramInt1, int paramInt2)
  {
    return subSequencePos(createPos(paramInt1, false), createPos(paramInt2, true));
  }

  public Sequence subSequence(SeqPosition paramSeqPosition1, SeqPosition paramSeqPosition2)
  {
    return subSequencePos(paramSeqPosition1.ipos, paramSeqPosition2.ipos);
  }

  protected Sequence subSequencePos(int paramInt1, int paramInt2)
  {
    return new SubSequence(this, paramInt1, paramInt2);
  }

  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[size()];
    int i = startPos();
    int k;
    for (int j = 0; ; j = k)
    {
      i = nextPos(i);
      if (i == 0)
        break;
      k = j + 1;
      arrayOfObject[j] = getPosPrevious(i);
    }
    return arrayOfObject;
  }

  public Object[] toArray(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    int j = size();
    if (j > i)
    {
      paramArrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), j);
      i = j;
    }
    int k = startPos();
    for (int m = 0; ; m++)
    {
      k = nextPos(k);
      if (k == 0)
        break;
      paramArrayOfObject[m] = getPosPrevious(k);
    }
    if (j < i)
      paramArrayOfObject[j] = null;
    return paramArrayOfObject;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    if ((this instanceof Sequence))
      localStringBuffer.append('[');
    toString(", ", localStringBuffer);
    if ((this instanceof Sequence))
      localStringBuffer.append(']');
    return localStringBuffer.toString();
  }

  public void toString(String paramString, StringBuffer paramStringBuffer)
  {
    int i = 0;
    int j = startPos();
    j = nextPos(j);
    if (j != 0)
    {
      if (i != 0)
        paramStringBuffer.append(paramString);
      while (true)
      {
        paramStringBuffer.append(getPosPrevious(j));
        break;
        i = 1;
      }
    }
  }

  protected RuntimeException unsupported(String paramString)
  {
    return unsupportedException(getClass().getName() + " does not implement " + paramString);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.AbstractSequence
 * JD-Core Version:    0.6.2
 */