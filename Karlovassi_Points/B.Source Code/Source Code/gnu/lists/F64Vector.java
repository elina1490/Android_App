package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class F64Vector extends SimpleVector
  implements Externalizable, Comparable
{
  protected static double[] empty = new double[0];
  double[] data;

  public F64Vector()
  {
    this.data = empty;
  }

  public F64Vector(int paramInt)
  {
    this.data = new double[paramInt];
    this.size = paramInt;
  }

  public F64Vector(int paramInt, double paramDouble)
  {
    double[] arrayOfDouble = new double[paramInt];
    this.data = arrayOfDouble;
    this.size = paramInt;
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      arrayOfDouble[paramInt] = paramDouble;
    }
  }

  public F64Vector(Sequence paramSequence)
  {
    this.data = new double[paramSequence.size()];
    addAll(paramSequence);
  }

  public F64Vector(double[] paramArrayOfDouble)
  {
    this.data = paramArrayOfDouble;
    this.size = paramArrayOfDouble.length;
  }

  protected void clearBuffer(int paramInt1, int paramInt2)
  {
    int j;
    for (int i = paramInt1; ; i = j)
    {
      paramInt2--;
      if (paramInt2 < 0)
        break;
      double[] arrayOfDouble = this.data;
      j = i + 1;
      arrayOfDouble[i] = 0.0D;
    }
  }

  public int compareTo(Object paramObject)
  {
    F64Vector localF64Vector = (F64Vector)paramObject;
    double[] arrayOfDouble1 = this.data;
    double[] arrayOfDouble2 = localF64Vector.data;
    int i = this.size;
    int j = localF64Vector.size;
    int k;
    if (i > j)
      k = j;
    for (int m = 0; ; m++)
    {
      if (m >= k)
        break label95;
      double d1 = arrayOfDouble1[m];
      double d2 = arrayOfDouble2[m];
      if (d1 != d2)
      {
        if (d1 > d2)
        {
          return 1;
          k = i;
          break;
        }
        return -1;
      }
    }
    label95: return i - j;
  }

  public boolean consumeNext(int paramInt, Consumer paramConsumer)
  {
    int i = paramInt >>> 1;
    if (i >= this.size)
      return false;
    paramConsumer.writeDouble(this.data[i]);
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
      while (i < j)
      {
        paramConsumer.writeDouble(this.data[i]);
        i++;
      }
    }
  }

  public final double doubleAt(int paramInt)
  {
    if (paramInt >= this.size)
      throw new ArrayIndexOutOfBoundsException();
    return this.data[paramInt];
  }

  public final double doubleAtBuffer(int paramInt)
  {
    return this.data[paramInt];
  }

  public final Object get(int paramInt)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    return Convert.toObject(this.data[paramInt]);
  }

  protected Object getBuffer()
  {
    return this.data;
  }

  public final Object getBuffer(int paramInt)
  {
    return Convert.toObject(this.data[paramInt]);
  }

  public int getBufferLength()
  {
    return this.data.length;
  }

  public int getElementKind()
  {
    return 26;
  }

  public String getTag()
  {
    return "f64";
  }

  public final int intAtBuffer(int paramInt)
  {
    return (int)this.data[paramInt];
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    double[] arrayOfDouble = new double[i];
    for (int j = 0; j < i; j++)
      arrayOfDouble[j] = paramObjectInput.readDouble();
    this.data = arrayOfDouble;
    this.size = i;
  }

  public final Object setBuffer(int paramInt, Object paramObject)
  {
    Object localObject = Convert.toObject(this.data[paramInt]);
    this.data[paramInt] = Convert.toDouble(paramObject);
    return localObject;
  }

  public void setBufferLength(int paramInt)
  {
    int i = this.data.length;
    double[] arrayOfDouble1;
    double[] arrayOfDouble2;
    if (i != paramInt)
    {
      arrayOfDouble1 = new double[paramInt];
      arrayOfDouble2 = this.data;
      if (i >= paramInt)
        break label45;
    }
    label45: for (int j = i; ; j = paramInt)
    {
      System.arraycopy(arrayOfDouble2, 0, arrayOfDouble1, 0, j);
      this.data = arrayOfDouble1;
      return;
    }
  }

  public final void setDoubleAt(int paramInt, double paramDouble)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    this.data[paramInt] = paramDouble;
  }

  public final void setDoubleAtBuffer(int paramInt, double paramDouble)
  {
    this.data[paramInt] = paramDouble;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i = this.size;
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++)
      paramObjectOutput.writeDouble(this.data[j]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.F64Vector
 * JD-Core Version:    0.6.2
 */