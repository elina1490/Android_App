package gnu.lists;

public class GeneralArray extends AbstractSequence
  implements Array
{
  static final int[] zeros = new int[8];
  SimpleVector base;
  int[] dimensions;
  int[] lowBounds;
  int offset;
  boolean simple = true;
  int[] strides;

  public GeneralArray()
  {
  }

  public GeneralArray(int[] paramArrayOfInt)
  {
    int i = 1;
    int j = paramArrayOfInt.length;
    if (j <= zeros.length);
    for (this.lowBounds = zeros; ; this.lowBounds = new int[j])
    {
      int[] arrayOfInt = new int[j];
      int k = j;
      while (true)
      {
        k--;
        if (k < 0)
          break;
        arrayOfInt[k] = i;
        i *= paramArrayOfInt[k];
      }
    }
    this.base = new FVector(i);
    this.dimensions = paramArrayOfInt;
    this.offset = 0;
  }

  public static Array makeSimple(int[] paramArrayOfInt1, int[] paramArrayOfInt2, SimpleVector paramSimpleVector)
  {
    int i = paramArrayOfInt2.length;
    if (paramArrayOfInt1 == null)
    {
      paramArrayOfInt1 = zeros;
      if (i > paramArrayOfInt1.length)
        paramArrayOfInt1 = new int[i];
    }
    if ((i == 1) && (paramArrayOfInt1[0] == 0))
      return paramSimpleVector;
    GeneralArray localGeneralArray = new GeneralArray();
    int[] arrayOfInt = new int[i];
    int j = 1;
    int k = i;
    while (true)
    {
      k--;
      if (k < 0)
        break;
      arrayOfInt[k] = j;
      j *= paramArrayOfInt2[k];
    }
    localGeneralArray.strides = arrayOfInt;
    localGeneralArray.dimensions = paramArrayOfInt2;
    localGeneralArray.lowBounds = paramArrayOfInt1;
    localGeneralArray.base = paramSimpleVector;
    return localGeneralArray;
  }

  public static void toString(Array paramArray, StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append("#<array");
    int i = paramArray.rank();
    for (int j = 0; j < i; j++)
    {
      paramStringBuffer.append(' ');
      int k = paramArray.getLowBound(j);
      int m = paramArray.getSize(j);
      if (k != 0)
      {
        paramStringBuffer.append(k);
        paramStringBuffer.append(':');
      }
      paramStringBuffer.append(k + m);
    }
    paramStringBuffer.append('>');
  }

  public int createPos(int paramInt, boolean paramBoolean)
  {
    int i = this.offset;
    int j = this.dimensions.length;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      int n = this.dimensions[j];
      int i1 = paramInt % n;
      paramInt /= n;
      i += i1 * this.strides[j];
    }
    int k = i << 1;
    if (paramBoolean);
    for (int m = 1; ; m = 0)
      return k | m;
  }

  public Object get(int paramInt)
  {
    return getRowMajor(paramInt);
  }

  public Object get(int[] paramArrayOfInt)
  {
    return this.base.get(getEffectiveIndex(paramArrayOfInt));
  }

  public int getEffectiveIndex(int[] paramArrayOfInt)
  {
    int i = this.offset;
    int j = this.dimensions.length;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      int k = paramArrayOfInt[j];
      int m = this.lowBounds[j];
      int n;
      if (k >= m)
      {
        n = k - m;
        if (n < this.dimensions[j]);
      }
      else
      {
        throw new IndexOutOfBoundsException();
      }
      i += n * this.strides[j];
    }
    return i;
  }

  public int getLowBound(int paramInt)
  {
    return this.lowBounds[paramInt];
  }

  public Object getRowMajor(int paramInt)
  {
    if (this.simple)
      return this.base.get(paramInt);
    int i = this.offset;
    int j = this.dimensions.length;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      int k = this.dimensions[j];
      int m = paramInt % k;
      paramInt /= k;
      i += m * this.strides[j];
    }
    return this.base.get(i);
  }

  public int getSize(int paramInt)
  {
    return this.dimensions[paramInt];
  }

  public int rank()
  {
    return this.dimensions.length;
  }

  public Object set(int[] paramArrayOfInt, Object paramObject)
  {
    return this.base.set(getEffectiveIndex(paramArrayOfInt), paramObject);
  }

  public int size()
  {
    int i = 1;
    int j = this.dimensions.length;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      i *= this.dimensions[j];
    }
    return i;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    toString(this, localStringBuffer);
    return localStringBuffer.toString();
  }

  public Array transpose(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, int[] paramArrayOfInt3)
  {
    if ((paramArrayOfInt2.length == 1) && (paramArrayOfInt1[0] == 0));
    for (Object localObject = new GeneralArray1(); ; localObject = new GeneralArray())
    {
      ((GeneralArray)localObject).offset = paramInt;
      ((GeneralArray)localObject).strides = paramArrayOfInt3;
      ((GeneralArray)localObject).dimensions = paramArrayOfInt2;
      ((GeneralArray)localObject).lowBounds = paramArrayOfInt1;
      ((GeneralArray)localObject).base = this.base;
      ((GeneralArray)localObject).simple = false;
      return localObject;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.GeneralArray
 * JD-Core Version:    0.6.2
 */