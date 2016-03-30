package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Iterator;
import java.util.List;

public class LList extends ExtSequence
  implements Sequence, Externalizable, Comparable
{
  public static final LList Empty = new LList();

  public static Pair chain1(Pair paramPair, Object paramObject)
  {
    Pair localPair = new Pair(paramObject, Empty);
    paramPair.cdr = localPair;
    return localPair;
  }

  public static Pair chain4(Pair paramPair, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    Pair localPair = new Pair(paramObject4, Empty);
    paramPair.cdr = new Pair(paramObject1, new Pair(paramObject2, new Pair(paramObject3, localPair)));
    return localPair;
  }

  public static Object checkNonList(Object paramObject)
  {
    if ((paramObject instanceof LList))
      return "#<not a pair>";
    return paramObject;
  }

  public static Object consX(Object[] paramArrayOfObject)
  {
    Object localObject1 = paramArrayOfObject[0];
    int i = paramArrayOfObject.length - 1;
    if (i <= 0)
      return localObject1;
    Pair localPair1 = new Pair(localObject1, null);
    Object localObject2 = localPair1;
    for (int j = 1; j < i; j++)
    {
      Pair localPair2 = new Pair(paramArrayOfObject[j], null);
      ((Pair)localObject2).cdr = localPair2;
      localObject2 = localPair2;
    }
    ((Pair)localObject2).cdr = paramArrayOfObject[i];
    return localPair1;
  }

  public static final int length(Object paramObject)
  {
    int i = 0;
    while ((paramObject instanceof Pair))
    {
      i++;
      paramObject = ((Pair)paramObject).cdr;
    }
    return i;
  }

  public static Pair list1(Object paramObject)
  {
    return new Pair(paramObject, Empty);
  }

  public static Pair list2(Object paramObject1, Object paramObject2)
  {
    return new Pair(paramObject1, new Pair(paramObject2, Empty));
  }

  public static Pair list3(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return new Pair(paramObject1, new Pair(paramObject2, new Pair(paramObject3, Empty)));
  }

  public static Pair list4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return new Pair(paramObject1, new Pair(paramObject2, new Pair(paramObject3, new Pair(paramObject4, Empty))));
  }

  public static int listLength(Object paramObject, boolean paramBoolean)
  {
    int i = 0;
    Object localObject1 = paramObject;
    Object localObject2 = paramObject;
    while (true)
    {
      if (localObject2 == Empty)
        return i;
      if (!(localObject2 instanceof Pair))
      {
        if (((localObject2 instanceof Comparable)) && (paramBoolean))
        {
          int j = ((Comparable)localObject2).size();
          if (j >= 0)
            return i + j;
          return j;
        }
        return -2;
      }
      Pair localPair = (Pair)localObject2;
      if (localPair.cdr == Empty)
        return i + 1;
      if ((localObject2 == localObject1) && (i > 0))
        return -1;
      if (!(localPair.cdr instanceof Pair))
      {
        i++;
        localObject2 = localPair.cdr;
      }
      else
      {
        if (!(localObject1 instanceof Pair))
          return -2;
        localObject1 = ((Pair)localObject1).cdr;
        localObject2 = ((Pair)localPair.cdr).cdr;
        i += 2;
      }
    }
  }

  public static Object listTail(Object paramObject, int paramInt)
  {
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      if (!(paramObject instanceof Pair))
        throw new IndexOutOfBoundsException("List is too short.");
      paramObject = ((Pair)paramObject).cdr;
    }
    return paramObject;
  }

  public static LList makeList(List paramList)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject1 = Empty;
    Object localObject2 = null;
    if (localIterator.hasNext())
    {
      Pair localPair = new Pair(localIterator.next(), Empty);
      if (localObject2 == null)
        localObject1 = localPair;
      while (true)
      {
        localObject2 = localPair;
        break;
        localObject2.cdr = localPair;
      }
    }
    return localObject1;
  }

  public static LList makeList(Object[] paramArrayOfObject, int paramInt)
  {
    LList localLList = Empty;
    int i = paramArrayOfObject.length - paramInt;
    for (Object localObject = localLList; ; localObject = new Pair(paramArrayOfObject[(paramInt + i)], localObject))
    {
      i--;
      if (i < 0)
        break;
    }
    return localObject;
  }

  public static LList makeList(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    LList localLList = Empty;
    int i = paramInt2;
    for (Object localObject = localLList; ; localObject = new Pair(paramArrayOfObject[(paramInt1 + i)], localObject))
    {
      i--;
      if (i < 0)
        break;
    }
    return localObject;
  }

  public static LList reverseInPlace(Object paramObject)
  {
    Pair localPair;
    for (Object localObject = Empty; paramObject != Empty; localObject = localPair)
    {
      localPair = (Pair)paramObject;
      paramObject = localPair.cdr;
      localPair.cdr = localObject;
    }
    return localObject;
  }

  public int compareTo(Object paramObject)
  {
    if (paramObject == Empty)
      return 0;
    return -1;
  }

  public void consume(Consumer paramConsumer)
  {
    Object localObject = this;
    paramConsumer.startElement("list");
    while ((localObject instanceof Pair))
    {
      if (localObject != this)
        paramConsumer.write(32);
      Pair localPair = (Pair)localObject;
      paramConsumer.writeObject(localPair.car);
      localObject = localPair.cdr;
    }
    if (localObject != Empty)
    {
      paramConsumer.write(32);
      paramConsumer.write(". ");
      paramConsumer.writeObject(checkNonList(localObject));
    }
    paramConsumer.endElement();
  }

  public int createPos(int paramInt, boolean paramBoolean)
  {
    LListPosition localLListPosition = new LListPosition(this, paramInt, paramBoolean);
    return PositionManager.manager.register(localLListPosition);
  }

  public int createRelativePos(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = isAfterPos(paramInt1);
    if ((paramInt2 < 0) || (paramInt1 == 0))
      return super.createRelativePos(paramInt1, paramInt2, paramBoolean);
    if (paramInt2 == 0)
    {
      if (paramBoolean == bool)
        return copyPos(paramInt1);
      if ((paramBoolean) && (!bool))
        return super.createRelativePos(paramInt1, paramInt2, paramBoolean);
    }
    if (paramInt1 < 0)
      throw new IndexOutOfBoundsException();
    LListPosition localLListPosition1 = (LListPosition)PositionManager.getPositionObject(paramInt1);
    if (localLListPosition1.xpos == null)
      return super.createRelativePos(paramInt1, paramInt2, paramBoolean);
    LListPosition localLListPosition2 = new LListPosition(localLListPosition1);
    Object localObject = localLListPosition2.xpos;
    int i = localLListPosition2.ipos;
    if ((paramBoolean) && (!bool))
    {
      paramInt2--;
      i += 3;
    }
    if ((!paramBoolean) && (bool))
    {
      paramInt2++;
      i -= 3;
    }
    while (true)
    {
      if (!(localObject instanceof Pair))
        throw new IndexOutOfBoundsException();
      paramInt2--;
      if (paramInt2 < 0)
      {
        localLListPosition2.ipos = i;
        localLListPosition2.xpos = localObject;
        return PositionManager.manager.register(localLListPosition2);
      }
      Pair localPair = (Pair)localObject;
      i += 2;
      localObject = localPair.cdr;
    }
  }

  public boolean equals(Object paramObject)
  {
    return this == paramObject;
  }

  public Object get(int paramInt)
  {
    throw new IndexOutOfBoundsException();
  }

  public SeqPosition getIterator(int paramInt)
  {
    return new LListPosition(this, paramInt, false);
  }

  public Object getPosNext(int paramInt)
  {
    return eofValue;
  }

  public Object getPosPrevious(int paramInt)
  {
    return eofValue;
  }

  public boolean hasNext(int paramInt)
  {
    return false;
  }

  public boolean isEmpty()
  {
    return true;
  }

  public int nextPos(int paramInt)
  {
    return 0;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    return Empty;
  }

  protected void setPosNext(int paramInt, Object paramObject)
  {
    if (paramInt <= 0)
    {
      if ((paramInt == -1) || (!(this instanceof Pair)))
        throw new IndexOutOfBoundsException();
      ((Pair)this).car = paramObject;
      return;
    }
    PositionManager.getPositionObject(paramInt).setNext(paramObject);
  }

  protected void setPosPrevious(int paramInt, Object paramObject)
  {
    if (paramInt <= 0)
    {
      if ((paramInt == 0) || (!(this instanceof Pair)))
        throw new IndexOutOfBoundsException();
      ((Pair)this).lastPair().car = paramObject;
      return;
    }
    PositionManager.getPositionObject(paramInt).setPrevious(paramObject);
  }

  public int size()
  {
    return 0;
  }

  public String toString()
  {
    Object localObject = this;
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append('(');
    if (localObject == Empty);
    while (true)
    {
      localStringBuffer.append(')');
      return localStringBuffer.toString();
      if (i > 0)
        localStringBuffer.append(' ');
      if (i >= 10)
      {
        localStringBuffer.append("...");
      }
      else
      {
        if ((localObject instanceof Pair))
        {
          Pair localPair = (Pair)localObject;
          localStringBuffer.append(localPair.car);
          localObject = localPair.cdr;
          i++;
          break;
        }
        localStringBuffer.append(". ");
        localStringBuffer.append(checkNonList(localObject));
      }
    }
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.LList
 * JD-Core Version:    0.6.2
 */