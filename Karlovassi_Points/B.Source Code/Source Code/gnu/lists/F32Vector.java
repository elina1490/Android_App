package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class F32Vector extends SimpleVector
  implements Externalizable, Comparable
{
  protected static float[] empty = new float[0];
  float[] data;

  public F32Vector()
  {
    this.data = empty;
  }

  public F32Vector(int paramInt)
  {
    this.data = new float[paramInt];
    this.size = paramInt;
  }

  public F32Vector(int paramInt, float paramFloat)
  {
    float[] arrayOfFloat = new float[paramInt];
    this.data = arrayOfFloat;
    this.size = paramInt;
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      arrayOfFloat[paramInt] = paramFloat;
    }
  }

  public F32Vector(Sequence paramSequence)
  {
    this.data = new float[paramSequence.size()];
    addAll(paramSequence);
  }

  public F32Vector(float[] paramArrayOfFloat)
  {
    this.data = paramArrayOfFloat;
    this.size = paramArrayOfFloat.length;
  }

  protected void clearBuffer(int paramInt1, int paramInt2)
  {
    int j;
    for (int i = paramInt1; ; i = j)
    {
      paramInt2--;
      if (paramInt2 < 0)
        break;
      float[] arrayOfFloat = this.data;
      j = i + 1;
      arrayOfFloat[i] = 0.0F;
    }
  }

  public int compareTo(Object paramObject)
  {
    F32Vector localF32Vector = (F32Vector)paramObject;
    float[] arrayOfFloat1 = this.data;
    float[] arrayOfFloat2 = localF32Vector.data;
    int i = this.size;
    int j = localF32Vector.size;
    int k;
    if (i > j)
      k = j;
    for (int m = 0; ; m++)
    {
      if (m >= k)
        break label95;
      float f1 = arrayOfFloat1[m];
      float f2 = arrayOfFloat2[m];
      if (f1 != f2)
      {
        if (f1 > f2)
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
    paramConsumer.writeFloat(this.data[i]);
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
        paramConsumer.writeFloat(this.data[i]);
        i++;
      }
    }
  }

  public final float floatAt(int paramInt)
  {
    if (paramInt >= this.size)
      throw new ArrayIndexOutOfBoundsException();
    return this.data[paramInt];
  }

  public final float floatAtBuffer(int paramInt)
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
    return 25;
  }

  public String getTag()
  {
    return "f32";
  }

  public final int intAtBuffer(int paramInt)
  {
    return (int)this.data[paramInt];
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    float[] arrayOfFloat = new float[i];
    for (int j = 0; j < i; j++)
      arrayOfFloat[j] = paramObjectInput.readFloat();
    this.data = arrayOfFloat;
    this.size = i;
  }

  public final Object setBuffer(int paramInt, Object paramObject)
  {
    Object localObject = Convert.toObject(this.data[paramInt]);
    this.data[paramInt] = Convert.toFloat(paramObject);
    return localObject;
  }

  public void setBufferLength(int paramInt)
  {
    int i = this.data.length;
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    if (i != paramInt)
    {
      arrayOfFloat1 = new float[paramInt];
      arrayOfFloat2 = this.data;
      if (i >= paramInt)
        break label45;
    }
    label45: for (int j = i; ; j = paramInt)
    {
      System.arraycopy(arrayOfFloat2, 0, arrayOfFloat1, 0, j);
      this.data = arrayOfFloat1;
      return;
    }
  }

  public final void setFloatAt(int paramInt, float paramFloat)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    this.data[paramInt] = paramFloat;
  }

  public final void setFloatAtBuffer(int paramInt, float paramFloat)
  {
    this.data[paramInt] = paramFloat;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i = this.size;
    paramObjectOutput.writeInt(i);
    for (int j = 0; j < i; j++)
      paramObjectOutput.writeFloat(this.data[j]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.F32Vector
 * JD-Core Version:    0.6.2
 */