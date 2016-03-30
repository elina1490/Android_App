package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class IntNum extends RatNum
  implements Externalizable
{
  static final int maxFixNum = 1024;
  static final int minFixNum = -100;
  static final int numFixNum = 1125;
  static final IntNum[] smallFixNums = new IntNum[1125];
  public int ival;
  public int[] words;

  static
  {
    int i = 1125;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      smallFixNums[i] = new IntNum(i - 100);
    }
  }

  public IntNum()
  {
  }

  public IntNum(int paramInt)
  {
    this.ival = paramInt;
  }

  public static IntNum abs(IntNum paramIntNum)
  {
    if (paramIntNum.isNegative())
      return neg(paramIntNum);
    return paramIntNum;
  }

  public static final IntNum add(int paramInt1, int paramInt2)
  {
    return make(paramInt1 + paramInt2);
  }

  public static IntNum add(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null)
      return add(paramIntNum.ival, paramInt);
    IntNum localIntNum = new IntNum(0);
    localIntNum.setAdd(paramIntNum, paramInt);
    return localIntNum.canonicalize();
  }

  public static IntNum add(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return add(paramIntNum1, paramIntNum2, 1);
  }

  public static IntNum add(IntNum paramIntNum1, IntNum paramIntNum2, int paramInt)
  {
    if ((paramIntNum1.words == null) && (paramIntNum2.words == null))
      return make(paramInt * paramIntNum2.ival + paramIntNum1.ival);
    if (paramInt != 1)
      if (paramInt != -1)
        break label63;
    label63: for (paramIntNum2 = neg(paramIntNum2); paramIntNum1.words == null; paramIntNum2 = times(paramIntNum2, make(paramInt)))
      return add(paramIntNum2, paramIntNum1.ival);
    if (paramIntNum2.words == null)
      return add(paramIntNum1, paramIntNum2.ival);
    if (paramIntNum2.ival > paramIntNum1.ival)
    {
      IntNum localIntNum2 = paramIntNum1;
      paramIntNum1 = paramIntNum2;
      paramIntNum2 = localIntNum2;
    }
    IntNum localIntNum1 = alloc(1 + paramIntNum1.ival);
    int i = paramIntNum2.ival;
    long l1 = MPN.add_n(localIntNum1.words, paramIntNum1.words, paramIntNum2.words, i);
    long l2;
    if (paramIntNum2.words[(i - 1)] < 0)
      l2 = 4294967295L;
    while (i < paramIntNum1.ival)
    {
      long l3 = l1 + (l2 + (0xFFFFFFFF & paramIntNum1.words[i]));
      localIntNum1.words[i] = ((int)l3);
      l1 = l3 >>> 32;
      i++;
      continue;
      l2 = 0L;
    }
    if (paramIntNum1.words[(i - 1)] < 0)
      l2 -= 1L;
    localIntNum1.words[i] = ((int)(l1 + l2));
    localIntNum1.ival = (i + 1);
    return localIntNum1.canonicalize();
  }

  public static IntNum alloc(int paramInt)
  {
    if (paramInt <= 1)
      return new IntNum();
    IntNum localIntNum = new IntNum();
    localIntNum.words = new int[paramInt];
    return localIntNum;
  }

  public static IntNum asIntNumOrNull(Object paramObject)
  {
    if ((paramObject instanceof IntNum))
      return (IntNum)paramObject;
    if ((paramObject instanceof BigInteger))
      return valueOf(paramObject.toString(), 10);
    if (((paramObject instanceof Number)) && (((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte))))
      return make(((Number)paramObject).longValue());
    return null;
  }

  public static int compare(IntNum paramIntNum, long paramLong)
  {
    long l;
    if (paramIntNum.words == null)
      l = paramIntNum.ival;
    while (l < paramLong)
    {
      return -1;
      boolean bool1 = paramIntNum.isNegative();
      boolean bool2;
      if (paramLong < 0L)
        bool2 = true;
      while (bool1 != bool2)
        if (bool1)
        {
          return -1;
          bool2 = false;
        }
        else
        {
          return 1;
        }
      if (paramIntNum.words == null);
      for (int i = 1; ; i = paramIntNum.ival)
      {
        if (i != 1)
          break label94;
        l = paramIntNum.words[0];
        break;
      }
      label94: if (i == 2)
      {
        l = paramIntNum.longValue();
      }
      else
      {
        if (bool1)
          return -1;
        return 1;
      }
    }
    if (l > paramLong)
      return 1;
    return 0;
  }

  public static int compare(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if ((paramIntNum1.words == null) && (paramIntNum2.words == null))
    {
      if (paramIntNum1.ival < paramIntNum2.ival)
        return -1;
      if (paramIntNum1.ival > paramIntNum2.ival)
        return 1;
      return 0;
    }
    boolean bool1 = paramIntNum1.isNegative();
    if (bool1 != paramIntNum2.isNegative())
    {
      if (bool1)
        return -1;
      return 1;
    }
    int i;
    int j;
    if (paramIntNum1.words == null)
    {
      i = 1;
      if (paramIntNum2.words != null)
        break label113;
      j = 1;
      label82: if (i == j)
        break label130;
      if (i <= j)
        break label122;
    }
    label113: label122: for (boolean bool2 = true; ; bool2 = false)
    {
      if (bool2 == bool1)
        break label128;
      return 1;
      i = paramIntNum1.ival;
      break;
      j = paramIntNum2.ival;
      break label82;
    }
    label128: return -1;
    label130: return MPN.cmp(paramIntNum1.words, paramIntNum2.words, i);
  }

  public static void divide(long paramLong1, long paramLong2, IntNum paramIntNum1, IntNum paramIntNum2, int paramInt)
  {
    if (paramInt == 5)
    {
      if (paramLong2 >= 0L)
        break label47;
      paramInt = 2;
    }
    label47: int i;
    int j;
    while (true)
      if (paramLong1 < 0L)
        if (paramLong1 == -9223372036854775808L)
        {
          divide(make(paramLong1), make(paramLong2), paramIntNum1, paramIntNum2, paramInt);
          return;
          paramInt = 1;
        }
        else
        {
          paramLong1 = -paramLong1;
          i = 1;
          if (paramLong2 >= 0L)
            break label280;
          j = 1;
          if (paramLong2 != -9223372036854775808L)
            break label134;
          if (paramInt != 3)
            break label114;
          if (paramIntNum1 != null)
            paramIntNum1.set(0);
          if (paramIntNum2 != null)
            paramIntNum2.set(paramLong1);
        }
    while (true)
    {
      return;
      i = 0;
      break;
      label114: divide(make(paramLong1), make(paramLong2), paramIntNum1, paramIntNum2, paramInt);
    }
    label134: paramLong2 = -paramLong2;
    long l1 = paramLong1 / paramLong2;
    long l2 = paramLong1 % paramLong2;
    int k = i ^ j;
    if (l2 != 0L);
    int m;
    label195: long l4;
    switch (paramInt)
    {
    default:
      m = 0;
      if (paramIntNum1 != null)
        if (m != 0)
        {
          l4 = l1 + 1L;
          label211: if (k != 0)
            l4 = -l4;
          paramIntNum1.set(l4);
        }
      break;
    case 3:
    case 1:
    case 2:
    case 4:
    }
    while (true)
    {
      long l3;
      int i1;
      if (paramIntNum2 != null)
        if (m != 0)
        {
          l3 = paramLong2 - l2;
          if (i == 0)
          {
            i1 = 1;
            label252: if (i1 != 0)
              l3 = -l3;
            paramIntNum2.set(l3);
          }
        }
      for (int n = i1; ; n = i)
      {
        return;
        label280: j = 0;
        break;
        m = 0;
        break label195;
        if (paramInt == 1);
        for (int i2 = 1; k == i2; i2 = 0)
        {
          m = 1;
          break label195;
        }
        if (l2 > paramLong2 - (1L & l1) >> 1);
        for (m = 1; ; m = 0)
          break;
        i1 = 0;
        break label252;
        l3 = l2;
        i1 = i;
        break label252;
      }
      l4 = l1;
      break label211;
    }
  }

  public static void divide(IntNum paramIntNum1, IntNum paramIntNum2, IntNum paramIntNum3, IntNum paramIntNum4, int paramInt)
  {
    if (((paramIntNum1.words == null) || (paramIntNum1.ival <= 2)) && ((paramIntNum2.words == null) || (paramIntNum2.ival <= 2)))
    {
      long l1 = paramIntNum1.longValue();
      long l2 = paramIntNum2.longValue();
      if ((l1 != -9223372036854775808L) && (l2 != -9223372036854775808L))
      {
        divide(l1, l2, paramIntNum3, paramIntNum4, paramInt);
        return;
      }
    }
    boolean bool1 = paramIntNum1.isNegative();
    boolean bool2 = paramIntNum2.isNegative();
    int i = bool1 ^ bool2;
    if (paramIntNum2.words == null);
    int[] arrayOfInt1;
    int k;
    for (int j = 1; ; j = paramIntNum2.ival)
    {
      arrayOfInt1 = new int[j];
      paramIntNum2.getAbsolute(arrayOfInt1);
      for (k = j; (k > 1) && (arrayOfInt1[(k - 1)] == 0); k--);
    }
    if (paramIntNum1.words == null);
    int[] arrayOfInt2;
    int n;
    for (int m = 1; ; m = paramIntNum1.ival)
    {
      arrayOfInt2 = new int[m + 2];
      paramIntNum1.getAbsolute(arrayOfInt2);
      for (n = m; (n > 1) && (arrayOfInt2[(n - 1)] == 0); n--);
    }
    int i1 = MPN.cmp(arrayOfInt2, n, arrayOfInt1, k);
    int[] arrayOfInt4;
    int i6;
    int i7;
    int[] arrayOfInt3;
    if (i1 < 0)
    {
      arrayOfInt4 = arrayOfInt2;
      int i19 = n;
      arrayOfInt1[0] = 0;
      i6 = 1;
      i7 = i19;
      arrayOfInt3 = arrayOfInt1;
    }
    label252: int i2;
    int i3;
    while ((i7 > 1) && (arrayOfInt4[(i7 - 1)] == 0))
    {
      i7--;
      continue;
      if (i1 == 0)
      {
        arrayOfInt2[0] = 1;
        arrayOfInt1[0] = 0;
        arrayOfInt3 = arrayOfInt2;
        arrayOfInt4 = arrayOfInt1;
        i6 = 1;
        i7 = 1;
      }
      else if (k == 1)
      {
        int i18 = n;
        arrayOfInt1[0] = MPN.divmod_1(arrayOfInt2, arrayOfInt2, n, arrayOfInt1[0]);
        arrayOfInt3 = arrayOfInt2;
        arrayOfInt4 = arrayOfInt1;
        i6 = i18;
        i7 = 1;
      }
      else
      {
        i2 = MPN.count_leading_zeros(arrayOfInt1[(k - 1)]);
        if (i2 == 0)
          break label954;
        MPN.lshift(arrayOfInt1, 0, arrayOfInt1, k, i2);
        int i17 = MPN.lshift(arrayOfInt2, 0, arrayOfInt2, n, i2);
        i3 = n + 1;
        arrayOfInt2[n] = i17;
      }
    }
    while (true)
    {
      int i16;
      if (i3 == k)
      {
        i16 = i3 + 1;
        arrayOfInt2[i3] = 0;
      }
      for (int i4 = i16; ; i4 = i3)
      {
        MPN.divide(arrayOfInt2, i4, arrayOfInt1, k);
        int i5 = k;
        MPN.rshift0(arrayOfInt1, arrayOfInt2, 0, i5, i2);
        i6 = i4 + 1 - k;
        if (paramIntNum3 != null)
        {
          int i15 = 0;
          while (true)
            if (i15 < i6)
            {
              arrayOfInt2[i15] = arrayOfInt2[(i15 + k)];
              i15++;
              continue;
              if (arrayOfInt4[(i7 - 1)] < 0)
                arrayOfInt4[i7] = 0;
              for (int i8 = i7 + 1; ; i8 = i7)
              {
                int i9;
                if (i8 <= 1)
                {
                  int i14 = arrayOfInt4[0];
                  i9 = 0;
                  if (i14 == 0);
                }
                else
                {
                  if (paramInt == 5)
                  {
                    if (!bool2)
                      break label706;
                    paramInt = 2;
                  }
                  i9 = 0;
                }
                label644: IntNum localIntNum3;
                switch (paramInt)
                {
                case 3:
                default:
                  if (paramIntNum3 != null)
                  {
                    if (arrayOfInt3[(i6 - 1)] < 0)
                    {
                      arrayOfInt3[i6] = 0;
                      i6++;
                    }
                    paramIntNum3.set(arrayOfInt3, i6);
                    if (i != 0)
                      if (i9 != 0)
                      {
                        paramIntNum3.setInvert();
                        if (paramIntNum4 == null)
                          break;
                        paramIntNum4.set(arrayOfInt4, i8);
                        if (i9 == 0)
                          break label912;
                        if (paramIntNum2.words != null)
                          break label879;
                        localIntNum3 = paramIntNum4;
                        if (!bool2)
                          break label865;
                      }
                  }
                  break;
                case 1:
                case 2:
                case 4:
                }
                label706: label865: for (int i12 = arrayOfInt4[0] + paramIntNum2.ival; ; i12 = arrayOfInt4[0] - paramIntNum2.ival)
                {
                  localIntNum3.set(i12);
                  if (!bool1)
                    break label905;
                  paramIntNum4.setNegative(localIntNum3);
                  return;
                  paramInt = 1;
                  break;
                  if (paramInt == 1);
                  for (int i13 = 1; ; i13 = 0)
                  {
                    i9 = 0;
                    if (i != i13)
                      break;
                    i9 = 1;
                    break;
                  }
                  IntNum localIntNum1;
                  if (paramIntNum4 == null)
                  {
                    localIntNum1 = new IntNum();
                    label756: localIntNum1.set(arrayOfInt4, i8);
                    IntNum localIntNum2 = shift(localIntNum1, 1);
                    if (bool2)
                      localIntNum2.setNegative();
                    int i10 = compare(localIntNum2, paramIntNum2);
                    if (bool2)
                      i10 = -i10;
                    if ((i10 != 1) && ((i10 != 0) || ((0x1 & arrayOfInt3[0]) == 0)))
                      break label833;
                  }
                  for (i9 = 1; ; i9 = 0)
                  {
                    break;
                    localIntNum1 = paramIntNum4;
                    break label756;
                  }
                  paramIntNum3.setNegative();
                  break label644;
                  if (i9 != 0)
                    paramIntNum3.setAdd(1);
                  break label644;
                }
                label833: label879: if (bool2);
                for (int i11 = 1; ; i11 = -1)
                {
                  localIntNum3 = add(paramIntNum4, paramIntNum2, i11);
                  break;
                }
                label905: paramIntNum4.set(localIntNum3);
                return;
                label912: if (!bool1)
                  break;
                paramIntNum4.setNegative();
                return;
              }
            }
        }
        i7 = i5;
        arrayOfInt3 = arrayOfInt2;
        arrayOfInt4 = arrayOfInt1;
        break label252;
      }
      label954: i3 = n;
    }
  }

  public static boolean equals(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if ((paramIntNum1.words == null) && (paramIntNum2.words == null))
      return paramIntNum1.ival == paramIntNum2.ival;
    if ((paramIntNum1.words == null) || (paramIntNum2.words == null) || (paramIntNum1.ival != paramIntNum2.ival))
      return false;
    int i = paramIntNum1.ival;
    do
    {
      i--;
      if (i < 0)
        break;
    }
    while (paramIntNum1.words[i] == paramIntNum2.words[i]);
    return false;
    return true;
  }

  public static final int gcd(int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1)
    {
      int j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
    while (true)
    {
      if (paramInt2 == 0)
        return paramInt1;
      if (paramInt2 == 1)
        return paramInt2;
      int i = paramInt2;
      paramInt2 = paramInt1 % paramInt2;
      paramInt1 = i;
    }
  }

  public static IntNum gcd(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    int i = paramIntNum1.ival;
    int j = paramIntNum2.ival;
    if (paramIntNum1.words == null)
    {
      if (i == 0)
        return abs(paramIntNum2);
      if ((paramIntNum2.words == null) && (i != -2147483648) && (j != -2147483648))
      {
        if (i < 0)
          i = -i;
        if (j < 0)
          j = -j;
        return make(gcd(i, j));
      }
      i = 1;
    }
    if (paramIntNum2.words == null)
    {
      if (j == 0)
        return abs(paramIntNum1);
      j = 1;
    }
    if (i > j);
    for (int k = i; ; k = j)
    {
      int[] arrayOfInt1 = new int[k];
      int[] arrayOfInt2 = new int[k];
      paramIntNum1.getAbsolute(arrayOfInt1);
      paramIntNum2.getAbsolute(arrayOfInt2);
      int m = MPN.gcd(arrayOfInt1, arrayOfInt2, k);
      IntNum localIntNum = new IntNum(0);
      if (arrayOfInt1[(m - 1)] < 0)
      {
        int n = m + 1;
        arrayOfInt1[m] = 0;
        m = n;
      }
      localIntNum.ival = m;
      localIntNum.words = arrayOfInt1;
      return localIntNum.canonicalize();
    }
  }

  public static int intValue(Object paramObject)
  {
    IntNum localIntNum = (IntNum)paramObject;
    if (localIntNum.words != null)
      throw new ClassCastException("integer too large");
    return localIntNum.ival;
  }

  public static IntNum lcm(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if ((paramIntNum1.isZero()) || (paramIntNum2.isZero()))
      return zero();
    IntNum localIntNum1 = abs(paramIntNum1);
    IntNum localIntNum2 = abs(paramIntNum2);
    IntNum localIntNum3 = new IntNum();
    divide(times(localIntNum1, localIntNum2), gcd(localIntNum1, localIntNum2), localIntNum3, null, 3);
    return localIntNum3.canonicalize();
  }

  public static IntNum make(int paramInt)
  {
    if ((paramInt >= -100) && (paramInt <= 1024))
      return smallFixNums[(paramInt + 100)];
    return new IntNum(paramInt);
  }

  public static IntNum make(long paramLong)
  {
    if ((paramLong >= -100L) && (paramLong <= 1024L))
      return smallFixNums[((int)paramLong + 100)];
    int i = (int)paramLong;
    if (i == paramLong)
      return new IntNum(i);
    IntNum localIntNum = alloc(2);
    localIntNum.ival = 2;
    localIntNum.words[0] = i;
    localIntNum.words[1] = ((int)(paramLong >> 32));
    return localIntNum;
  }

  public static IntNum make(int[] paramArrayOfInt)
  {
    return make(paramArrayOfInt, paramArrayOfInt.length);
  }

  public static IntNum make(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null)
      return make(paramInt);
    int i = wordsNeeded(paramArrayOfInt, paramInt);
    if (i <= 1)
    {
      if (i == 0)
        return zero();
      return make(paramArrayOfInt[0]);
    }
    IntNum localIntNum = new IntNum();
    localIntNum.words = paramArrayOfInt;
    localIntNum.ival = i;
    return localIntNum;
  }

  public static IntNum makeU(long paramLong)
  {
    if (paramLong >= 0L)
      return make(paramLong);
    IntNum localIntNum = alloc(3);
    localIntNum.ival = 3;
    localIntNum.words[0] = ((int)paramLong);
    localIntNum.words[1] = ((int)(paramLong >> 32));
    localIntNum.words[2] = 0;
    return localIntNum;
  }

  public static IntNum minusOne()
  {
    return smallFixNums[99];
  }

  public static IntNum modulo(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return remainder(paramIntNum1, paramIntNum2, 1);
  }

  public static IntNum neg(IntNum paramIntNum)
  {
    if ((paramIntNum.words == null) && (paramIntNum.ival != -2147483648))
      return make(-paramIntNum.ival);
    IntNum localIntNum = new IntNum(0);
    localIntNum.setNegative(paramIntNum);
    return localIntNum.canonicalize();
  }

  public static boolean negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    long l1 = 1L;
    if (paramArrayOfInt2[(paramInt - 1)] < 0);
    for (int i = 1; ; i = 0)
      for (int j = 0; j < paramInt; j++)
      {
        long l2 = l1 + (0xFFFFFFFF & (0xFFFFFFFF ^ paramArrayOfInt2[j]));
        paramArrayOfInt1[j] = ((int)l2);
        l1 = l2 >> 32;
      }
    return (i != 0) && (paramArrayOfInt1[(paramInt - 1)] < 0);
  }

  public static final IntNum one()
  {
    return smallFixNums[101];
  }

  public static IntNum power(IntNum paramIntNum, int paramInt)
  {
    if (paramInt <= 0)
    {
      if (paramInt == 0)
        return one();
      throw new Error("negative exponent");
    }
    if (paramIntNum.isZero())
      return paramIntNum;
    int i;
    int k;
    label69: Object localObject1;
    Object localObject2;
    Object localObject3;
    int m;
    if (paramIntNum.words == null)
    {
      i = 1;
      int j = (paramInt * paramIntNum.intLength() >> 5) + i * 2;
      if ((!paramIntNum.isNegative()) || ((paramInt & 0x1) == 0))
        break label158;
      k = 1;
      localObject1 = new int[j];
      localObject2 = new int[j];
      localObject3 = new int[j];
      paramIntNum.getAbsolute((int[])localObject1);
      m = 1;
      localObject2[0] = 1;
    }
    while (true)
    {
      if ((paramInt & 0x1) != 0)
      {
        MPN.mul((int[])localObject3, (int[])localObject1, i, (int[])localObject2, m);
        Object localObject5 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject5;
        m += i;
        while (true)
          if (localObject2[(m - 1)] == 0)
          {
            m--;
            continue;
            i = paramIntNum.ival;
            break;
            label158: k = 0;
            break label69;
          }
      }
      paramInt >>= 1;
      if (paramInt == 0)
      {
        if (localObject2[(m - 1)] < 0)
          m++;
        if (k != 0)
          negate((int[])localObject2, (int[])localObject2, m);
        return make((int[])localObject2, m);
      }
      MPN.mul((int[])localObject3, (int[])localObject1, i, (int[])localObject1, i);
      Object localObject4 = localObject3;
      localObject3 = localObject1;
      localObject1 = localObject4;
      i *= 2;
      while (localObject1[(i - 1)] == 0)
        i--;
    }
  }

  public static IntNum quotient(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return quotient(paramIntNum1, paramIntNum2, 3);
  }

  public static IntNum quotient(IntNum paramIntNum1, IntNum paramIntNum2, int paramInt)
  {
    IntNum localIntNum = new IntNum();
    divide(paramIntNum1, paramIntNum2, localIntNum, null, paramInt);
    return localIntNum.canonicalize();
  }

  public static IntNum remainder(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return remainder(paramIntNum1, paramIntNum2, 3);
  }

  public static IntNum remainder(IntNum paramIntNum1, IntNum paramIntNum2, int paramInt)
  {
    if (paramIntNum2.isZero())
      return paramIntNum1;
    IntNum localIntNum = new IntNum();
    divide(paramIntNum1, paramIntNum2, null, localIntNum, paramInt);
    return localIntNum.canonicalize();
  }

  public static int shift(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 32);
    int i;
    do
    {
      return 0;
      if (paramInt2 >= 0)
        return paramInt1 << paramInt2;
      i = -paramInt2;
      if (i < 32)
        break;
    }
    while (paramInt1 >= 0);
    return -1;
    return paramInt1 >> i;
  }

  public static long shift(long paramLong, int paramInt)
  {
    if (paramInt >= 32)
      return 0L;
    if (paramInt >= 0)
      return paramLong << paramInt;
    int i = -paramInt;
    if (i >= 32)
    {
      if (paramLong < 0L)
        return -1L;
      return 0L;
    }
    return paramLong >> i;
  }

  public static IntNum shift(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null)
    {
      if (paramInt <= 0)
      {
        int i;
        if (paramInt > -32)
          i = paramIntNum.ival >> -paramInt;
        while (true)
        {
          return make(i);
          if (paramIntNum.ival < 0)
            i = -1;
          else
            i = 0;
        }
      }
      if (paramInt < 32)
        return make(paramIntNum.ival << paramInt);
    }
    if (paramInt == 0)
      return paramIntNum;
    IntNum localIntNum = new IntNum(0);
    localIntNum.setShift(paramIntNum, paramInt);
    return localIntNum.canonicalize();
  }

  public static IntNum sub(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return add(paramIntNum1, paramIntNum2, -1);
  }

  public static final IntNum ten()
  {
    return smallFixNums[110];
  }

  public static final IntNum times(int paramInt1, int paramInt2)
  {
    return make(paramInt1 * paramInt2);
  }

  public static final IntNum times(IntNum paramIntNum, int paramInt)
  {
    if (paramInt == 0)
      return zero();
    if (paramInt == 1)
      return paramIntNum;
    int[] arrayOfInt = paramIntNum.words;
    int i = paramIntNum.ival;
    if (arrayOfInt == null)
      return make(i * paramInt);
    IntNum localIntNum = alloc(i + 1);
    if (arrayOfInt[(i - 1)] < 0)
    {
      j = 1;
      negate(localIntNum.words, arrayOfInt, i);
      arrayOfInt = localIntNum.words;
      if (paramInt < 0)
        if (j != 0)
          break label137;
    }
    label137: for (int j = 1; ; j = 0)
    {
      paramInt = -paramInt;
      localIntNum.words[i] = MPN.mul_1(localIntNum.words, arrayOfInt, i, paramInt);
      localIntNum.ival = (i + 1);
      if (j != 0)
        localIntNum.setNegative();
      return localIntNum.canonicalize();
      j = 0;
      break;
    }
  }

  public static final IntNum times(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if (paramIntNum2.words == null)
      return times(paramIntNum1, paramIntNum2.ival);
    if (paramIntNum1.words == null)
      return times(paramIntNum2, paramIntNum1.ival);
    int i = paramIntNum1.ival;
    int j = paramIntNum2.ival;
    int k;
    Object localObject1;
    label83: Object localObject2;
    if (paramIntNum1.isNegative())
    {
      k = 1;
      localObject1 = new int[i];
      negate((int[])localObject1, paramIntNum1.words, i);
      if (!paramIntNum2.isNegative())
        break label188;
      if (k != 0)
        break label182;
      k = 1;
      localObject2 = new int[j];
      negate((int[])localObject2, paramIntNum2.words, j);
    }
    while (true)
    {
      if (i < j)
      {
        Object localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        int m = i;
        i = j;
        j = m;
      }
      IntNum localIntNum = alloc(i + j);
      MPN.mul(localIntNum.words, (int[])localObject1, i, (int[])localObject2, j);
      localIntNum.ival = (i + j);
      if (k != 0)
        localIntNum.setNegative();
      return localIntNum.canonicalize();
      localObject1 = paramIntNum1.words;
      k = 0;
      break;
      label182: k = 0;
      break label83;
      label188: localObject2 = paramIntNum2.words;
    }
  }

  public static IntNum valueOf(String paramString)
    throws NumberFormatException
  {
    return valueOf(paramString, 10);
  }

  public static IntNum valueOf(String paramString, int paramInt)
    throws NumberFormatException
  {
    int i = paramString.length();
    if (i + paramInt <= 28)
    {
      if ((i > 1) && (paramString.charAt(0) == '+') && (Character.digit(paramString.charAt(1), paramInt) >= 0))
        paramString = paramString.substring(1);
      return make(Long.parseLong(paramString, paramInt));
    }
    byte[] arrayOfByte = new byte[i];
    boolean bool = false;
    int j = 0;
    int k = 0;
    char c;
    int m;
    if (j < i)
    {
      c = paramString.charAt(j);
      if ((c == '-') && (j == 0))
      {
        bool = true;
        m = k;
      }
    }
    while (true)
    {
      j++;
      k = m;
      break;
      if ((c == '+') && (j == 0))
        m = k;
      else if (c != '_')
      {
        if (k == 0)
        {
          if (c != ' ')
            if (c == '\t')
              m = k;
        }
        else
        {
          int n = Character.digit(c, paramInt);
          if (n < 0)
            throw new NumberFormatException("For input string: \"" + paramString + '"');
          m = k + 1;
          arrayOfByte[k] = ((byte)n);
          continue;
          return valueOf(arrayOfByte, k, bool, paramInt);
        }
      }
      else
        m = k;
    }
  }

  public static IntNum valueOf(byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int[] arrayOfInt = new int[1 + paramInt1 / MPN.chars_per_word(paramInt2)];
    int i = MPN.set_str(arrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
    if (i == 0)
      return zero();
    if (arrayOfInt[(i - 1)] < 0)
    {
      int j = i + 1;
      arrayOfInt[i] = 0;
      i = j;
    }
    if (paramBoolean)
      negate(arrayOfInt, arrayOfInt, i);
    return make(arrayOfInt, i);
  }

  public static IntNum valueOf(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    int i = 0;
    int j = 0;
    char c;
    int k;
    if (i < paramInt2)
    {
      c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '-')
      {
        paramBoolean = true;
        k = j;
      }
    }
    while (true)
    {
      i++;
      j = k;
      break;
      if (c != '_')
      {
        if (j == 0)
        {
          if (c != ' ')
            if (c == '\t')
              k = j;
        }
        else
        {
          int m = Character.digit(c, paramInt3);
          if (m < 0)
            return valueOf(arrayOfByte, j, paramBoolean, paramInt3);
          k = j + 1;
          arrayOfByte[j] = ((byte)m);
        }
      }
      else
        k = j;
    }
  }

  public static int wordsNeeded(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramInt;
    int j;
    if (i > 0)
    {
      i--;
      j = paramArrayOfInt[i];
      if (j != -1)
        break label47;
      int k;
      do
      {
        if (i <= 0)
          break;
        k = paramArrayOfInt[(i - 1)];
        if (k >= 0)
          break;
        i--;
      }
      while (k == -1);
    }
    label47: label69: 
    while (true)
    {
      return i + 1;
      while (true)
      {
        if ((j != 0) || (i <= 0))
          break label69;
        j = paramArrayOfInt[(i - 1)];
        if (j < 0)
          break;
        i--;
      }
    }
  }

  public static final IntNum zero()
  {
    return smallFixNums[100];
  }

  public Numeric add(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof IntNum))
      return add(this, (IntNum)paramObject, paramInt);
    if (!(paramObject instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)paramObject).addReversed(this, paramInt);
  }

  public BigDecimal asBigDecimal()
  {
    if (this.words == null)
      return new BigDecimal(this.ival);
    if (this.ival <= 2)
      return BigDecimal.valueOf(longValue());
    return new BigDecimal(toString());
  }

  public BigInteger asBigInteger()
  {
    if ((this.words == null) || (this.ival <= 2))
      return BigInteger.valueOf(longValue());
    return new BigInteger(toString());
  }

  public IntNum canonicalize()
  {
    if (this.words != null)
    {
      int i = wordsNeeded(this.words, this.ival);
      this.ival = i;
      if (i <= 1)
      {
        if (this.ival == 1)
          this.ival = this.words[0];
        this.words = null;
      }
    }
    if ((this.words == null) && (this.ival >= -100) && (this.ival <= 1024))
      return smallFixNums[(this.ival + 100)];
    return this;
  }

  boolean checkBits(int paramInt)
  {
    if (paramInt <= 0)
      return false;
    if (this.words == null)
      return (paramInt > 31) || ((this.ival & (1 << paramInt) - 1) != 0);
    for (int i = 0; i < paramInt >> 5; i++)
      if (this.words[i] != 0)
        return true;
    return ((paramInt & 0x1F) != 0) && ((this.words[i] & (1 << (paramInt & 0x1F)) - 1) != 0);
  }

  public int compare(Object paramObject)
  {
    if ((paramObject instanceof IntNum))
      return compare(this, (IntNum)paramObject);
    return ((RealNum)paramObject).compareReversed(this);
  }

  public final IntNum denominator()
  {
    return one();
  }

  public Numeric div(Object paramObject)
  {
    if ((paramObject instanceof RatNum))
    {
      RatNum localRatNum = (RatNum)paramObject;
      return RatNum.make(times(this, localRatNum.denominator()), localRatNum.numerator());
    }
    if (!(paramObject instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)paramObject).divReversed(this);
  }

  public double doubleValue()
  {
    if (this.words == null)
      return this.ival;
    if (this.ival <= 2)
      return longValue();
    if (isNegative())
      return neg(this).roundToDouble(0, true, false);
    return roundToDouble(0, false, false);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof IntNum)))
      return false;
    return equals(this, (IntNum)paramObject);
  }

  public void format(int paramInt, StringBuffer paramStringBuffer)
  {
    if (paramInt == 10)
    {
      if (this.words == null)
      {
        paramStringBuffer.append(this.ival);
        return;
      }
      if (this.ival <= 2)
      {
        paramStringBuffer.append(longValue());
        return;
      }
    }
    paramStringBuffer.append(toString(paramInt));
  }

  public void format(int paramInt, StringBuilder paramStringBuilder)
  {
    if (this.words == null)
      if (paramInt == 10)
        paramStringBuilder.append(this.ival);
    label216: int i1;
    while (true)
    {
      return;
      paramStringBuilder.append(Integer.toString(this.ival, paramInt));
      return;
      if (this.ival <= 2)
      {
        long l = longValue();
        if (paramInt == 10)
        {
          paramStringBuilder.append(l);
          return;
        }
        paramStringBuilder.append(Long.toString(l, paramInt));
        return;
      }
      boolean bool = isNegative();
      int[] arrayOfInt;
      if ((bool) || (paramInt != 16))
      {
        arrayOfInt = new int[this.ival];
        getAbsolute(arrayOfInt);
      }
      int i;
      while (true)
      {
        i = this.ival;
        if (paramInt != 16)
          break label216;
        if (bool)
          paramStringBuilder.append('-');
        int i5 = paramStringBuilder.length();
        int i6 = i;
        while (true)
        {
          i6--;
          if (i6 < 0)
            break;
          int i7 = arrayOfInt[i6];
          int i8 = 8;
          while (true)
          {
            i8--;
            if (i8 < 0)
              break;
            int i9 = 0xF & i7 >> i8 * 4;
            if ((i9 > 0) || (paramStringBuilder.length() > i5))
              paramStringBuilder.append(Character.forDigit(i9, 16));
          }
        }
        break;
        arrayOfInt = this.words;
      }
      int j = MPN.chars_per_word(paramInt);
      int k = paramInt;
      int m = j;
      while (true)
      {
        m--;
        if (m <= 0)
          break;
        k *= paramInt;
      }
      int n = paramStringBuilder.length();
      do
      {
        i1 = MPN.divmod_1(arrayOfInt, arrayOfInt, i, k);
        while ((i > 0) && (arrayOfInt[(i - 1)] == 0))
          i--;
        int i2 = j;
        i2--;
        if ((i2 >= 0) && ((i != 0) || (i1 != 0)))
          break;
      }
      while (i != 0);
      if (bool)
        paramStringBuilder.append('-');
      for (int i3 = paramStringBuilder.length() - 1; n < i3; i3--)
      {
        char c1 = paramStringBuilder.charAt(n);
        char c2 = paramStringBuilder.charAt(i3);
        paramStringBuilder.setCharAt(n, c2);
        paramStringBuilder.setCharAt(i3, c1);
        n++;
      }
    }
    int i4;
    if (i1 < 0)
    {
      i4 = (int)((0xFFFFFFFF & i1) % paramInt);
      i1 /= paramInt;
    }
    while (true)
    {
      paramStringBuilder.append(Character.forDigit(i4, paramInt));
      break;
      i4 = i1 % paramInt;
      i1 /= paramInt;
    }
  }

  public void getAbsolute(int[] paramArrayOfInt)
  {
    int i;
    if (this.words == null)
    {
      i = 1;
      paramArrayOfInt[0] = this.ival;
    }
    while (true)
    {
      if (paramArrayOfInt[(i - 1)] < 0)
        negate(paramArrayOfInt, paramArrayOfInt, i);
      int k = paramArrayOfInt.length;
      while (true)
      {
        k--;
        if (k <= i)
          break;
        paramArrayOfInt[k] = 0;
      }
      i = this.ival;
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          break;
        paramArrayOfInt[j] = this.words[j];
      }
    }
  }

  public int hashCode()
  {
    if (this.words == null)
      return this.ival;
    return this.words[0] + this.words[(this.ival - 1)];
  }

  public boolean inIntRange()
  {
    return inRange(-2147483648L, 2147483647L);
  }

  public boolean inLongRange()
  {
    return inRange(-9223372036854775808L, 9223372036854775807L);
  }

  public boolean inRange(long paramLong1, long paramLong2)
  {
    return (compare(this, paramLong1) >= 0) && (compare(this, paramLong2) <= 0);
  }

  public int intLength()
  {
    if (this.words == null)
      return MPN.intLength(this.ival);
    return MPN.intLength(this.words, this.ival);
  }

  public int intValue()
  {
    if (this.words == null)
      return this.ival;
    return this.words[0];
  }

  public final boolean isMinusOne()
  {
    return (this.words == null) && (this.ival == -1);
  }

  public final boolean isNegative()
  {
    if (this.words == null);
    for (int i = this.ival; i < 0; i = this.words[(this.ival - 1)])
      return true;
    return false;
  }

  public final boolean isOdd()
  {
    if (this.words == null);
    for (int i = this.ival; (i & 0x1) != 0; i = this.words[0])
      return true;
    return false;
  }

  public final boolean isOne()
  {
    return (this.words == null) && (this.ival == 1);
  }

  public final boolean isZero()
  {
    return (this.words == null) && (this.ival == 0);
  }

  public long longValue()
  {
    if (this.words == null)
      return this.ival;
    if (this.ival == 1)
      return this.words[0];
    return (this.words[1] << 32) + (0xFFFFFFFF & this.words[0]);
  }

  public Numeric mul(Object paramObject)
  {
    if ((paramObject instanceof IntNum))
      return times(this, (IntNum)paramObject);
    if (!(paramObject instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)paramObject).mulReversed(this);
  }

  public Numeric neg()
  {
    return neg(this);
  }

  public final IntNum numerator()
  {
    return this;
  }

  public Numeric power(IntNum paramIntNum)
  {
    if (isOne())
      return this;
    if (isMinusOne())
    {
      if (paramIntNum.isOdd())
        return this;
      return one();
    }
    if ((paramIntNum.words == null) && (paramIntNum.ival >= 0))
      return power(this, paramIntNum.ival);
    if (isZero())
    {
      if (paramIntNum.isNegative())
        return RatNum.infinity(-1);
      return this;
    }
    return super.power(paramIntNum);
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    if (i <= -1073741824)
    {
      i &= 2147483647;
      if (i != 1)
        break label38;
      i = paramObjectInput.readInt();
    }
    while (true)
    {
      this.ival = i;
      return;
      label38: int[] arrayOfInt = new int[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          break;
        arrayOfInt[j] = paramObjectInput.readInt();
      }
      this.words = arrayOfInt;
    }
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    return canonicalize();
  }

  public void realloc(int paramInt)
  {
    if (paramInt == 0)
      if (this.words != null)
      {
        if (this.ival > 0)
          this.ival = this.words[0];
        this.words = null;
      }
    while ((this.words != null) && (this.words.length >= paramInt) && (this.words.length <= paramInt + 2))
      return;
    int[] arrayOfInt = new int[paramInt];
    if (this.words == null)
    {
      arrayOfInt[0] = this.ival;
      this.ival = 1;
    }
    while (true)
    {
      this.words = arrayOfInt;
      return;
      if (paramInt < this.ival)
        this.ival = paramInt;
      System.arraycopy(this.words, 0, arrayOfInt, 0, this.ival);
    }
  }

  public double roundToDouble(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = intLength();
    int j = paramInt + (i - 1);
    if (j < -1075)
    {
      if (paramBoolean1)
        return 0.0D;
      return 0.0D;
    }
    if (j > 1023)
    {
      if (paramBoolean1)
        return (-1.0D / 0.0D);
      return (1.0D / 0.0D);
    }
    int k;
    int m;
    long l1;
    if (j >= -1022)
    {
      k = 53;
      m = i - (k + 1);
      if (m <= 0)
        break label168;
      if (this.words != null)
        break label150;
      l1 = this.ival >> m;
    }
    while (true)
      if ((j == 1023) && (l1 >> 1 == 9007199254740991L))
      {
        if ((paramBoolean2) || (checkBits(i - k)))
        {
          if (paramBoolean1)
          {
            return (-1.0D / 0.0D);
            k = 1022 + (j + 53);
            break;
            label150: l1 = MPN.rshift_long(this.words, this.ival, m);
            continue;
            label168: l1 = longValue() << -m;
            continue;
          }
          return (1.0D / 0.0D);
        }
        if (paramBoolean1)
          return -1.797693134862316E+308D;
        return 1.7976931348623157E+308D;
      }
    long l2;
    long l3;
    label275: int n;
    if (((1L & l1) == 1L) && (((0x2 & l1) == 2L) || (paramBoolean2) || (checkBits(m))))
    {
      l1 += 2L;
      if ((0x0 & l1) != 0L)
      {
        j++;
        l1 >>= 1;
      }
    }
    else
    {
      l2 = l1 >> 1;
      if (!paramBoolean1)
        break label331;
      l3 = -9223372036854775808L;
      n = 1023 + j;
      if (n > 0)
        break label337;
    }
    label331: label337: for (long l4 = 0L; ; l4 = n << 52)
    {
      return Double.longBitsToDouble(l2 & 0xFFFFFFFF | (l3 | l4));
      if ((k != 52) || ((0x0 & l1) == 0L))
        break;
      j++;
      break;
      l3 = 0L;
      break label275;
    }
  }

  public final void set(int paramInt)
  {
    this.words = null;
    this.ival = paramInt;
  }

  public final void set(long paramLong)
  {
    int i = (int)paramLong;
    if (i == paramLong)
    {
      this.ival = i;
      this.words = null;
      return;
    }
    realloc(2);
    this.words[0] = i;
    this.words[1] = ((int)(paramLong >> 32));
    this.ival = 2;
  }

  public final void set(IntNum paramIntNum)
  {
    if (paramIntNum.words == null)
      set(paramIntNum.ival);
    while (this == paramIntNum)
      return;
    realloc(paramIntNum.ival);
    System.arraycopy(paramIntNum.words, 0, this.words, 0, paramIntNum.ival);
    this.ival = paramIntNum.ival;
  }

  public final void set(int[] paramArrayOfInt, int paramInt)
  {
    this.ival = paramInt;
    this.words = paramArrayOfInt;
  }

  public final void setAdd(int paramInt)
  {
    setAdd(this, paramInt);
  }

  public void setAdd(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null)
    {
      set(paramIntNum.ival + paramInt);
      return;
    }
    int i = paramIntNum.ival;
    realloc(i + 1);
    long l1 = paramInt;
    for (int j = 0; j < i; j++)
    {
      long l2 = l1 + (0xFFFFFFFF & paramIntNum.words[j]);
      this.words[j] = ((int)l2);
      l1 = l2 >> 32;
    }
    if (paramIntNum.words[(i - 1)] < 0)
      l1 -= 1L;
    this.words[i] = ((int)l1);
    this.ival = wordsNeeded(this.words, i + 1);
  }

  void setInvert()
  {
    if (this.words == null)
      this.ival = (0xFFFFFFFF ^ this.ival);
    while (true)
    {
      return;
      int i = this.ival;
      while (true)
      {
        i--;
        if (i < 0)
          break;
        this.words[i] = (0xFFFFFFFF ^ this.words[i]);
      }
    }
  }

  public final void setNegative()
  {
    setNegative(this);
  }

  public void setNegative(IntNum paramIntNum)
  {
    int i = paramIntNum.ival;
    if (paramIntNum.words == null)
    {
      if (i == -2147483648)
      {
        set(-i);
        return;
      }
      set(-i);
      return;
    }
    realloc(i + 1);
    if (negate(this.words, paramIntNum.words, i))
    {
      int[] arrayOfInt = this.words;
      int j = i + 1;
      arrayOfInt[i] = 0;
      i = j;
    }
    this.ival = i;
  }

  void setShift(IntNum paramIntNum, int paramInt)
  {
    if (paramInt > 0)
    {
      setShiftLeft(paramIntNum, paramInt);
      return;
    }
    setShiftRight(paramIntNum, -paramInt);
  }

  void setShiftLeft(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null)
      if (paramInt < 32)
        set(paramIntNum.ival << paramInt);
    while (true)
    {
      return;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = paramIntNum.ival;
      int j;
      int k;
      int m;
      for (int i = 1; ; i = paramIntNum.ival)
      {
        j = paramInt >> 5;
        k = paramInt & 0x1F;
        m = i + j;
        if (k != 0)
          break;
        realloc(m);
        int i3 = i;
        while (true)
        {
          i3--;
          if (i3 < 0)
            break;
          this.words[(i3 + j)] = arrayOfInt[i3];
        }
        arrayOfInt = paramIntNum.words;
      }
      m++;
      realloc(m);
      int n = MPN.lshift(this.words, j, arrayOfInt, i, k);
      int i1 = 32 - k;
      this.words[(m - 1)] = (n << i1 >> i1);
      this.ival = m;
      int i2 = j;
      while (true)
      {
        i2--;
        if (i2 < 0)
          break;
        this.words[i2] = 0;
      }
    }
  }

  void setShiftRight(IntNum paramIntNum, int paramInt)
  {
    int i1;
    if (paramIntNum.words == null)
      if (paramInt < 32)
      {
        i1 = paramIntNum.ival >> paramInt;
        set(i1);
      }
    boolean bool;
    int j;
    int k;
    do
    {
      return;
      if (paramIntNum.ival < 0)
      {
        i1 = -1;
        break;
      }
      i1 = 0;
      break;
      if (paramInt == 0)
      {
        set(paramIntNum);
        return;
      }
      bool = paramIntNum.isNegative();
      int i = paramInt >> 5;
      j = paramInt & 0x1F;
      k = paramIntNum.ival - i;
      if (k <= 0)
      {
        if (bool);
        for (int n = -1; ; n = 0)
        {
          set(n);
          return;
        }
      }
      if ((this.words == null) || (this.words.length < k))
        realloc(k);
      MPN.rshift0(this.words, paramIntNum.words, i, k, j);
      this.ival = k;
    }
    while (!bool);
    int[] arrayOfInt = this.words;
    int m = k - 1;
    arrayOfInt[m] |= -2 << 31 - j;
  }

  public int sign()
  {
    int i = -1;
    int j = this.ival;
    int[] arrayOfInt = this.words;
    if (arrayOfInt == null)
      if (j > 0)
        i = 1;
    int k;
    int m;
    do
    {
      do
        return i;
      while (j < 0);
      return 0;
      k = j - 1;
      m = arrayOfInt[k];
      if (m > 0)
        return 1;
    }
    while (m < 0);
    do
    {
      if (k == 0)
        return 0;
      k--;
    }
    while (arrayOfInt[k] == 0);
    return 1;
  }

  public IntNum toExactInt(int paramInt)
  {
    return this;
  }

  public RealNum toInt(int paramInt)
  {
    return this;
  }

  public String toString(int paramInt)
  {
    if (this.words == null)
      return Integer.toString(this.ival, paramInt);
    if (this.ival <= 2)
      return Long.toString(longValue(), paramInt);
    StringBuilder localStringBuilder = new StringBuilder(this.ival * (1 + MPN.chars_per_word(paramInt)));
    format(paramInt, localStringBuilder);
    return localStringBuilder.toString();
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int i;
    int j;
    if (this.words == null)
    {
      i = 1;
      if (i > 1)
        break label96;
      if (this.words != null)
        break label56;
      j = this.ival;
      label26: if (j < -1073741824)
        break label79;
      paramObjectOutput.writeInt(j);
    }
    while (true)
    {
      return;
      i = wordsNeeded(this.words, this.ival);
      break;
      label56: if (this.words.length == 0)
      {
        j = 0;
        break label26;
      }
      j = this.words[0];
      break label26;
      label79: paramObjectOutput.writeInt(-2147483647);
      paramObjectOutput.writeInt(j);
      return;
      label96: paramObjectOutput.writeInt(0x80000000 | i);
      while (true)
      {
        i--;
        if (i < 0)
          break;
        paramObjectOutput.writeInt(this.words[i]);
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.IntNum
 * JD-Core Version:    0.6.2
 */