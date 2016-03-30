package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class Pair extends LList
  implements Externalizable
{
  protected Object car;
  protected Object cdr;

  public Pair()
  {
  }

  public Pair(Object paramObject1, Object paramObject2)
  {
    this.car = paramObject1;
    this.cdr = paramObject2;
  }

  public static int compareTo(Pair paramPair1, Pair paramPair2)
  {
    if (paramPair1 == paramPair2)
      return 0;
    if (paramPair1 == null)
      return -1;
    if (paramPair2 == null)
      return 1;
    Object localObject3;
    Object localObject4;
    do
    {
      paramPair1 = (Pair)localObject3;
      paramPair2 = (Pair)localObject4;
      Object localObject1 = paramPair1.car;
      Object localObject2 = paramPair2.car;
      int i = ((Comparable)localObject1).compareTo((Comparable)localObject2);
      if (i != 0)
        return i;
      localObject3 = paramPair1.cdr;
      localObject4 = paramPair2.cdr;
      if (localObject3 == localObject4)
        return 0;
      if (localObject3 == null)
        return -1;
      if (localObject4 == null)
        return 1;
    }
    while (((localObject3 instanceof Pair)) && ((localObject4 instanceof Pair)));
    return ((Comparable)localObject3).compareTo((Comparable)localObject4);
  }

  public static boolean equals(Pair paramPair1, Pair paramPair2)
  {
    if (paramPair1 == paramPair2)
      return true;
    if ((paramPair1 == null) || (paramPair2 == null))
      return false;
    Object localObject3;
    Object localObject4;
    do
    {
      paramPair1 = (Pair)localObject3;
      paramPair2 = (Pair)localObject4;
      Object localObject1 = paramPair1.car;
      Object localObject2 = paramPair2.car;
      if ((localObject1 != localObject2) && ((localObject1 == null) || (!localObject1.equals(localObject2))))
        return false;
      localObject3 = paramPair1.cdr;
      localObject4 = paramPair2.cdr;
      if (localObject3 == localObject4)
        return true;
      if ((localObject3 == null) || (localObject4 == null))
        return false;
    }
    while (((localObject3 instanceof Pair)) && ((localObject4 instanceof Pair)));
    return localObject3.equals(localObject4);
  }

  public static Pair make(Object paramObject1, Object paramObject2)
  {
    return new Pair(paramObject1, paramObject2);
  }

  public int compareTo(Object paramObject)
  {
    if (paramObject == Empty)
      return 1;
    return compareTo(this, (Pair)paramObject);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Pair)))
      return equals(this, (Pair)paramObject);
    return false;
  }

  public Object get(int paramInt)
  {
    Pair localPair = this;
    int i = paramInt;
    while (i > 0)
    {
      i--;
      if ((localPair.cdr instanceof Pair))
        localPair = (Pair)localPair.cdr;
      else if ((localPair.cdr instanceof Sequence))
        return ((Sequence)localPair.cdr).get(i);
    }
    if (i == 0)
      return localPair.car;
    throw new IndexOutOfBoundsException();
  }

  public Object getCar()
  {
    return this.car;
  }

  public Object getCdr()
  {
    return this.cdr;
  }

  public Object getPosNext(int paramInt)
  {
    if (paramInt <= 0)
    {
      if (paramInt == 0)
        return this.car;
      return eofValue;
    }
    return PositionManager.getPositionObject(paramInt).getNext();
  }

  public Object getPosPrevious(int paramInt)
  {
    if (paramInt <= 0)
    {
      if (paramInt == 0)
        return eofValue;
      return lastPair().car;
    }
    return PositionManager.getPositionObject(paramInt).getPrevious();
  }

  public boolean hasNext(int paramInt)
  {
    if (paramInt <= 0)
      return paramInt == 0;
    return PositionManager.getPositionObject(paramInt).hasNext();
  }

  public int hashCode()
  {
    int i = 1;
    Object localObject1 = this;
    if ((localObject1 instanceof Pair))
    {
      Pair localPair = (Pair)localObject1;
      Object localObject2 = localPair.car;
      int j = i * 31;
      if (localObject2 == null);
      for (int k = 0; ; k = localObject2.hashCode())
      {
        i = j + k;
        localObject1 = localPair.cdr;
        break;
      }
    }
    if ((localObject1 != LList.Empty) && (localObject1 != null))
      i ^= localObject1.hashCode();
    return i;
  }

  public boolean isEmpty()
  {
    return false;
  }

  public final Pair lastPair()
  {
    Object localObject;
    for (Pair localPair = this; ; localPair = (Pair)localObject)
    {
      localObject = localPair.cdr;
      if (!(localObject instanceof Pair))
        break;
    }
    return localPair;
  }

  public int length()
  {
    int i = 0;
    Object localObject1 = this;
    Object localObject2 = this;
    while (true)
    {
      if (localObject1 == Empty)
        return i;
      if (!(localObject1 instanceof Pair))
      {
        if ((localObject1 instanceof Sequence))
        {
          int j = ((Sequence)localObject1).size();
          if (j >= 0)
            return i + j;
          return j;
        }
        return -2;
      }
      Pair localPair = (Pair)localObject1;
      if (localPair.cdr == Empty)
        return i + 1;
      if ((localObject1 == localObject2) && (i > 0))
        return -1;
      if (!(localPair.cdr instanceof Pair))
      {
        i++;
        localObject1 = localPair.cdr;
      }
      else
      {
        if (!(localObject2 instanceof Pair))
          return -2;
        Object localObject3 = ((Pair)localObject2).cdr;
        localObject1 = ((Pair)localPair.cdr).cdr;
        i += 2;
        localObject2 = localObject3;
      }
    }
  }

  public int nextPos(int paramInt)
  {
    if (paramInt <= 0)
    {
      if (paramInt < 0)
        return 0;
      return PositionManager.manager.register(new LListPosition(this, 1, true));
    }
    if (((LListPosition)PositionManager.getPositionObject(paramInt)).gotoNext())
      return paramInt;
    return 0;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.car = paramObjectInput.readObject();
    this.cdr = paramObjectInput.readObject();
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    return this;
  }

  public void setCar(Object paramObject)
  {
    this.car = paramObject;
  }

  public void setCdr(Object paramObject)
  {
    this.cdr = paramObject;
  }

  public void setCdrBackdoor(Object paramObject)
  {
    this.cdr = paramObject;
  }

  public int size()
  {
    int i = listLength(this, true);
    if (i >= 0)
      return i;
    if (i == -1)
      return 2147483647;
    throw new RuntimeException("not a true list");
  }

  public Object[] toArray()
  {
    int i = size();
    Object[] arrayOfObject = new Object[i];
    int j = 0;
    Object localObject = this;
    while ((j < i) && ((localObject instanceof Pair)))
    {
      Pair localPair = (Pair)localObject;
      arrayOfObject[j] = localPair.car;
      localObject = (Sequence)localPair.cdr;
      j++;
    }
    int k = j;
    while (j < i)
    {
      arrayOfObject[j] = ((Sequence)localObject).get(j - k);
      j++;
    }
    return arrayOfObject;
  }

  public Object[] toArray(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    int j = length();
    if (j > i)
    {
      paramArrayOfObject = new Object[j];
      i = j;
    }
    int k = 0;
    Object localObject = this;
    while ((k < j) && ((localObject instanceof Pair)))
    {
      Pair localPair = (Pair)localObject;
      paramArrayOfObject[k] = localPair.car;
      localObject = (Sequence)localPair.cdr;
      k++;
    }
    int m = k;
    while (k < j)
    {
      paramArrayOfObject[k] = ((Sequence)localObject).get(k - m);
      k++;
    }
    if (j < i)
      paramArrayOfObject[j] = null;
    return paramArrayOfObject;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.car);
    paramObjectOutput.writeObject(this.cdr);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.Pair
 * JD-Core Version:    0.6.2
 */