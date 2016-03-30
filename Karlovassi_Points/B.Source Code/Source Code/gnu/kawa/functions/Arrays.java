package gnu.kawa.functions;

import gnu.lists.Array;
import gnu.lists.FVector;
import gnu.lists.GeneralArray;
import gnu.lists.SimpleVector;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class Arrays
{
  static final int[] shapeStrides = { 2, 1 };
  static final int[] zeros2 = new int[2];

  public static int effectiveIndex(Array paramArray, Procedure paramProcedure, Object[] paramArrayOfObject, int[] paramArrayOfInt)
    throws Throwable
  {
    Object localObject = paramProcedure.applyN(paramArrayOfObject);
    if ((localObject instanceof Values))
    {
      Values localValues = (Values)localObject;
      int i = 0;
      for (int j = 0; ; j++)
      {
        i = localValues.nextPos(i);
        if (i == 0)
          break;
        paramArrayOfInt[j] = ((Number)localValues.getPosPrevious(i)).intValue();
      }
    }
    paramArrayOfInt[0] = ((Number)localObject).intValue();
    return paramArray.getEffectiveIndex(paramArrayOfInt);
  }

  public static Array make(Array paramArray, Object paramObject)
  {
    int i = paramArray.getSize(0);
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = null;
    int j = 1;
    int k = i;
    while (true)
    {
      k--;
      if (k < 0)
        break;
      int m = ((Number)paramArray.getRowMajor(k * 2)).intValue();
      int n = ((Number)paramArray.getRowMajor(1 + k * 2)).intValue() - m;
      arrayOfInt1[k] = n;
      if (m != 0)
      {
        if (arrayOfInt2 == null)
          arrayOfInt2 = new int[i];
        arrayOfInt2[k] = m;
      }
      j *= n;
    }
    return GeneralArray.makeSimple(arrayOfInt2, arrayOfInt1, new FVector(j, paramObject));
  }

  public static Array makeSimple(Array paramArray, SimpleVector paramSimpleVector)
  {
    int i = paramArray.getSize(0);
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = null;
    int j = i;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      int k = ((Number)paramArray.getRowMajor(j * 2)).intValue();
      arrayOfInt1[j] = (((Number)paramArray.getRowMajor(1 + j * 2)).intValue() - k);
      if (k != 0)
      {
        if (arrayOfInt2 == null)
          arrayOfInt2 = new int[i];
        arrayOfInt2[j] = k;
      }
    }
    return GeneralArray.makeSimple(arrayOfInt2, arrayOfInt1, paramSimpleVector);
  }

  public static Array shape(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if ((i & 0x1) != 0)
      throw new RuntimeException("shape: not an even number of arguments");
    int[] arrayOfInt = { i >> 1, 2 };
    return new FVector(paramArrayOfObject).transpose(zeros2, arrayOfInt, 0, shapeStrides);
  }

  public static Array shareArray(Array paramArray1, Array paramArray2, Procedure paramProcedure)
    throws Throwable
  {
    int i = paramArray2.getSize(0);
    Object[] arrayOfObject = new Object[i];
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = new int[i];
    int j = 0;
    int m;
    for (int k = i; ; k = m)
    {
      m = k - 1;
      if (m < 0)
        break;
      Object localObject2 = paramArray2.getRowMajor(m * 2);
      arrayOfObject[m] = localObject2;
      int i6 = ((Number)localObject2).intValue();
      arrayOfInt2[m] = i6;
      int i7 = ((Number)paramArray2.getRowMajor(1 + m * 2)).intValue() - i6;
      arrayOfInt1[m] = i7;
      if (i7 <= 0)
        j = 1;
    }
    int n = paramArray1.rank();
    int[] arrayOfInt3 = new int[i];
    if (j != 0);
    int i1;
    for (int i3 = 0; ; i3 = i1)
    {
      return paramArray1.transpose(arrayOfInt2, arrayOfInt1, i3, arrayOfInt3);
      int[] arrayOfInt4 = new int[n];
      i1 = effectiveIndex(paramArray1, paramProcedure, arrayOfObject, arrayOfInt4);
      int i2 = i;
      while (true)
      {
        i2--;
        if (i2 < 0)
          break;
        int i4 = arrayOfInt1[i2];
        int i5 = arrayOfInt2[i2];
        if (i4 <= 1)
        {
          arrayOfInt3[i2] = 0;
        }
        else
        {
          Object localObject1 = arrayOfObject[i2];
          arrayOfObject[i2] = IntNum.make(i5 + 1);
          arrayOfInt3[i2] = (effectiveIndex(paramArray1, paramProcedure, arrayOfObject, arrayOfInt4) - i1);
          arrayOfObject[i2] = localObject1;
        }
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.Arrays
 * JD-Core Version:    0.6.2
 */