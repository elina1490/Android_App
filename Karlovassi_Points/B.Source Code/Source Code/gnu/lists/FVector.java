package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class FVector extends SimpleVector
  implements Externalizable, Consumable, Comparable
{
  protected static Object[] empty = new Object[0];
  public Object[] data;

  public FVector()
  {
    this.data = empty;
  }

  public FVector(int paramInt)
  {
    this.size = paramInt;
    this.data = new Object[paramInt];
  }

  public FVector(int paramInt, Object paramObject)
  {
    Object[] arrayOfObject = new Object[paramInt];
    if (paramObject != null)
      for (int i = 0; i < paramInt; i++)
        arrayOfObject[i] = paramObject;
    this.data = arrayOfObject;
    this.size = paramInt;
  }

  public FVector(List paramList)
  {
    this.data = new Object[paramList.size()];
    addAll(paramList);
  }

  public FVector(Object[] paramArrayOfObject)
  {
    this.size = paramArrayOfObject.length;
    this.data = paramArrayOfObject;
  }

  public static FVector make(Object[] paramArrayOfObject)
  {
    return new FVector(paramArrayOfObject);
  }

  protected void clearBuffer(int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject = this.data;
    int j;
    for (int i = paramInt1; ; i = j)
    {
      paramInt2--;
      if (paramInt2 < 0)
        break;
      j = i + 1;
      arrayOfObject[i] = null;
    }
  }

  public int compareTo(Object paramObject)
  {
    FVector localFVector = (FVector)paramObject;
    Object[] arrayOfObject1 = this.data;
    Object[] arrayOfObject2 = localFVector.data;
    int i = this.size;
    int j = localFVector.size;
    int k;
    if (i > j)
      k = j;
    for (int m = 0; ; m++)
    {
      if (m >= k)
        break label92;
      int n = ((Comparable)arrayOfObject1[m]).compareTo((Comparable)arrayOfObject2[m]);
      if (n != 0)
      {
        return n;
        k = i;
        break;
      }
    }
    label92: return i - j;
  }

  public void consume(Consumer paramConsumer)
  {
    paramConsumer.startElement("#vector");
    int i = this.size;
    for (int j = 0; j < i; j++)
      paramConsumer.writeObject(this.data[j]);
    paramConsumer.endElement();
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    int i = paramInt >>> 1;
    if (i >= this.size)
      return false;
    paramConsumer.writeObject(this.data[i]);
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
        paramConsumer.writeObject(this.data[i]);
        i++;
      }
    }
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof FVector)))
      return false;
    FVector localFVector = (FVector)paramObject;
    int i = this.size;
    if ((localFVector.data == null) || (localFVector.size != i))
      return false;
    Object[] arrayOfObject1 = this.data;
    Object[] arrayOfObject2 = localFVector.data;
    for (int j = 0; j < i; j++)
      if (!arrayOfObject1[j].equals(arrayOfObject2[j]))
        return false;
    return true;
  }

  public final Object get(int paramInt)
  {
    if (paramInt >= this.size)
      throw new ArrayIndexOutOfBoundsException();
    return this.data[paramInt];
  }

  protected Object getBuffer()
  {
    return this.data;
  }

  public final Object getBuffer(int paramInt)
  {
    return this.data[paramInt];
  }

  public int getBufferLength()
  {
    return this.data.length;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    Object[] arrayOfObject = new Object[i];
    for (int j = 0; j < i; j++)
      arrayOfObject[j] = paramObjectInput.readObject();
    this.size = i;
    this.data = arrayOfObject;
  }

  public final void setAll(Object paramObject)
  {
    Object[] arrayOfObject = this.data;
    int i = this.size;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      arrayOfObject[i] = paramObject;
    }
  }

  public final Object setBuffer(int paramInt, Object paramObject)
  {
    Object localObject = this.data[paramInt];
    this.data[paramInt] = paramObject;
    return localObject;
  }

  public void setBufferLength(int paramInt)
  {
    int i = this.data.length;
    Object[] arrayOfObject1;
    Object[] arrayOfObject2;
    if (i != paramInt)
    {
      arrayOfObject1 = new Object[paramInt];
      arrayOfObject2 = this.data;
      if (i >= paramInt)
        break label46;
    }
    label46: for (int j = i; ; j = paramInt)
    {
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, j);
      this.data = arrayOfObject1;
      return;
    }
  }

  public void shift(int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.data, paramInt1, this.data, paramInt2, paramInt3);
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i = this.size;
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++)
      paramObjectOutput.writeObject(this.data[j]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.FVector
 * JD-Core Version:    0.6.2
 */