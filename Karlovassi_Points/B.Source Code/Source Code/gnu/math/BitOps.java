package gnu.math;

public class BitOps
{
  static final byte[] bit4_count = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };

  public static IntNum and(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null)
      return IntNum.make(paramInt & paramIntNum.ival);
    if (paramInt >= 0)
      return IntNum.make(paramInt & paramIntNum.words[0]);
    int i = paramIntNum.ival;
    int[] arrayOfInt = new int[i];
    arrayOfInt[0] = (paramInt & paramIntNum.words[0]);
    while (true)
    {
      i--;
      if (i <= 0)
        break;
      arrayOfInt[i] = paramIntNum.words[i];
    }
    return IntNum.make(arrayOfInt, paramIntNum.ival);
  }

  public static IntNum and(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if (paramIntNum2.words == null)
      return and(paramIntNum1, paramIntNum2.ival);
    if (paramIntNum1.words == null)
      return and(paramIntNum2, paramIntNum1.ival);
    if (paramIntNum1.ival < paramIntNum2.ival)
    {
      IntNum localIntNum = paramIntNum1;
      paramIntNum1 = paramIntNum2;
      paramIntNum2 = localIntNum;
    }
    if (paramIntNum2.isNegative());
    int[] arrayOfInt;
    int j;
    for (int i = paramIntNum1.ival; ; i = paramIntNum2.ival)
    {
      arrayOfInt = new int[i];
      for (j = 0; j < paramIntNum2.ival; j++)
        arrayOfInt[j] = (paramIntNum1.words[j] & paramIntNum2.words[j]);
    }
    while (j < i)
    {
      arrayOfInt[j] = paramIntNum1.words[j];
      j++;
    }
    return IntNum.make(arrayOfInt, i);
  }

  public static int bitCount(int paramInt)
  {
    int i = 0;
    while (paramInt != 0)
    {
      i += bit4_count[(paramInt & 0xF)];
      paramInt >>>= 4;
    }
    return i;
  }

  public static int bitCount(IntNum paramIntNum)
  {
    int[] arrayOfInt = paramIntNum.words;
    int i;
    if (arrayOfInt == null)
      i = 1;
    for (int j = bitCount(paramIntNum.ival); paramIntNum.isNegative(); j = bitCount(arrayOfInt, i))
    {
      return i * 32 - j;
      i = paramIntNum.ival;
    }
    return j;
  }

  public static int bitCount(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      i += bitCount(paramArrayOfInt[paramInt]);
    }
    return i;
  }

  public static IntNum bitOp(int paramInt, IntNum paramIntNum1, IntNum paramIntNum2)
  {
    switch (paramInt)
    {
    default:
      IntNum localIntNum = new IntNum();
      setBitOp(localIntNum, paramInt, paramIntNum1, paramIntNum2);
      return localIntNum.canonicalize();
    case 0:
      return IntNum.zero();
    case 1:
      return and(paramIntNum1, paramIntNum2);
    case 3:
      return paramIntNum1;
    case 5:
      return paramIntNum2;
    case 15:
    }
    return IntNum.minusOne();
  }

  public static boolean bitValue(IntNum paramIntNum, int paramInt)
  {
    int i = paramIntNum.ival;
    if (paramIntNum.words == null)
    {
      if (paramInt >= 32)
        return i < 0;
      return (0x1 & i >> paramInt) != 0;
    }
    int j = paramInt >> 5;
    if (j >= i)
      return paramIntNum.words[(i - 1)] < 0;
    return (0x1 & paramIntNum.words[j] >> paramInt) != 0;
  }

  static int[] dataBufferFor(IntNum paramIntNum, int paramInt)
  {
    int i = paramIntNum.ival;
    int j = paramInt + 1 >> 5;
    int[] arrayOfInt;
    if (paramIntNum.words == null)
    {
      if (j == 0)
        j = 1;
      arrayOfInt = new int[j];
      arrayOfInt[0] = i;
      if (i < 0)
        for (int i2 = 1; i2 < j; i2++)
          arrayOfInt[i2] = -1;
    }
    else
    {
      int k = paramInt + 1 >> 5;
      if (k > i);
      for (int m = k; ; m = i)
      {
        arrayOfInt = new int[m];
        int n = i;
        while (true)
        {
          n--;
          if (n < 0)
            break;
          arrayOfInt[n] = paramIntNum.words[n];
        }
      }
      if (arrayOfInt[(i - 1)] < 0)
        for (int i1 = i; i1 < k; i1++)
          arrayOfInt[i1] = -1;
    }
    return arrayOfInt;
  }

  public static IntNum extract(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    int i7;
    if (paramInt2 < 32)
      if (paramIntNum.words == null)
      {
        i7 = paramIntNum.ival;
        paramIntNum = IntNum.make((i7 & (0xFFFFFFFF ^ -1 << paramInt2)) >> paramInt1);
      }
    int i;
    boolean bool;
    do
    {
      return paramIntNum;
      i7 = paramIntNum.words[0];
      break;
      if (paramIntNum.words != null)
        break label179;
      if (paramIntNum.ival >= 0)
      {
        if (paramInt1 >= 31);
        for (int i6 = 0; ; i6 = paramIntNum.ival >> paramInt1)
          return IntNum.make(i6);
      }
      i = 1;
      bool = paramIntNum.isNegative();
      if (paramInt2 <= i * 32)
        break label187;
      paramInt2 = i * 32;
    }
    while ((!bool) && (paramInt1 == 0));
    int j = i;
    label119: int k = paramInt2 - paramInt1;
    if (k < 64)
    {
      int i4;
      int i5;
      if (paramIntNum.words == null)
      {
        i4 = paramIntNum.ival;
        if (paramInt1 >= 32)
          i5 = 31;
      }
      label154: for (long l = i4 >> i5; ; l = MPN.rshift_long(paramIntNum.words, j, paramInt1))
      {
        return IntNum.make(l & (0xFFFFFFFF ^ -1L << k));
        label179: i = paramIntNum.ival;
        break;
        label187: j = paramInt2 + 31 >> 5;
        break label119;
        i5 = paramInt1;
        break label154;
      }
    }
    int m = paramInt1 >> 5;
    int[] arrayOfInt = new int[1 + (paramInt2 >> 5) - m];
    int i3;
    if (paramIntNum.words == null)
      if (paramInt1 >= 32)
      {
        i3 = -1;
        arrayOfInt[0] = i3;
      }
    while (true)
    {
      int i2 = k >> 5;
      arrayOfInt[i2] &= (0xFFFFFFFF ^ -1 << k);
      return IntNum.make(arrayOfInt, i2 + 1);
      i3 = paramIntNum.ival >> paramInt1;
      break;
      int n = j - m;
      int i1 = paramInt1 & 0x1F;
      MPN.rshift0(arrayOfInt, paramIntNum.words, m, n, i1);
    }
  }

  public static IntNum ior(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return bitOp(7, paramIntNum1, paramIntNum2);
  }

  public static int lowestBitSet(int paramInt)
  {
    if (paramInt == 0)
      return -1;
    for (int i = 0; (paramInt & 0xFF) == 0; i += 8)
      paramInt >>>= 8;
    while ((paramInt & 0x3) == 0)
    {
      paramInt >>>= 2;
      i += 2;
    }
    if ((paramInt & 0x1) == 0)
      i++;
    return i;
  }

  public static int lowestBitSet(IntNum paramIntNum)
  {
    int[] arrayOfInt = paramIntNum.words;
    if (arrayOfInt == null)
      return lowestBitSet(paramIntNum.ival);
    int i = paramIntNum.ival;
    while (i < 0)
    {
      int j = lowestBitSet(arrayOfInt[0]);
      if (j >= 0)
      {
        (0 * 32);
        return j + 0;
      }
    }
    return -1;
  }

  public static IntNum not(IntNum paramIntNum)
  {
    return bitOp(12, paramIntNum, IntNum.zero());
  }

  public static IntNum reverseBits(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    int i = paramIntNum.ival;
    if ((paramIntNum.words == null) && (paramInt2 < 63))
    {
      long l1 = i;
      int i11 = paramInt2 - 1;
      int i12 = paramInt1;
      long l5;
      for (long l2 = l1; i12 < i11; l2 = l5)
      {
        long l3 = 1L & l2 >> i12;
        long l4 = 1L & l2 >> i11;
        l5 = l2 & (0xFFFFFFFF ^ (1L << i12 | 1L << i11)) | l3 << i11 | l4 << i12;
        int i13 = i12 + 1;
        i11--;
        i12 = i13;
      }
      return IntNum.make(l2);
    }
    int[] arrayOfInt = dataBufferFor(paramIntNum, paramInt2 - 1);
    int j = paramInt2 - 1;
    int k = paramInt1;
    if (k < j)
    {
      int m = k >> 5;
      int n = j >> 5;
      int i1 = arrayOfInt[m];
      int i2 = 0x1 & i1 >> k;
      int i10;
      if (m == n)
        i10 = 0x1 & i1 >> j;
      int i7;
      for (int i8 = (int)(i1 & (0xFFFFFFFF ^ (1L << k | 1L << j))) | i2 << j | i10 << k; ; i8 = i7)
      {
        arrayOfInt[m] = i8;
        int i9 = k + 1;
        j--;
        k = i9;
        break;
        int i3 = arrayOfInt[n];
        int i4 = 0x1 & i3 >> (j & 0x1F);
        int i5 = i1 & (0xFFFFFFFF ^ 1 << (k & 0x1F));
        int i6 = i3 & (0xFFFFFFFF ^ 1 << (j & 0x1F));
        i7 = i5 | i4 << (k & 0x1F);
        arrayOfInt[n] = (i6 | i2 << (j & 0x1F));
      }
    }
    return IntNum.make(arrayOfInt, arrayOfInt.length);
  }

  public static void setBitOp(IntNum paramIntNum1, int paramInt, IntNum paramIntNum2, IntNum paramIntNum3)
  {
    label7: int j;
    int k;
    label27: int n;
    int i1;
    label47: int[] arrayOfInt;
    if (paramIntNum3.words == null)
    {
      if (paramIntNum3.words != null)
        break label244;
      int i47 = paramIntNum3.ival;
      j = 1;
      k = i47;
      if (paramIntNum2.words != null)
        break label265;
      int i46 = paramIntNum2.ival;
      n = 1;
      i1 = i46;
      if (n > 1)
        paramIntNum1.realloc(n);
      arrayOfInt = paramIntNum1.words;
    }
    int i6;
    int i8;
    int i7;
    int i9;
    label200: label244: int i10;
    label265: label304: int i5;
    int i2;
    int i3;
    switch (paramInt)
    {
    default:
      i6 = 0;
      i8 = 0;
      i7 = -1;
    case 0:
      while (true)
      {
        if (i6 + 1 == n)
          i8 = 0;
        switch (i8)
        {
        default:
          i9 = i6;
          paramIntNum1.ival = i9;
          return;
          if ((paramIntNum2.words != null) && (paramIntNum2.ival >= paramIntNum3.ival))
            break label7;
          IntNum localIntNum = paramIntNum2;
          paramIntNum2 = paramIntNum3;
          paramIntNum3 = localIntNum;
          paramInt = swappedOp(paramInt);
          break label7;
          int i = paramIntNum3.words[0];
          j = paramIntNum3.ival;
          k = i;
          break label27;
          int m = paramIntNum2.words[0];
          n = paramIntNum2.ival;
          i1 = m;
          break label47;
          i7 = 0;
          i8 = 0;
          i6 = 0;
        case 0:
        case 1:
        case 2:
        }
      }
      i10 = i4 + 1;
      arrayOfInt[i4] = i5;
      int i11 = paramIntNum2.words[i10];
      i2 = paramIntNum3.words[i10];
      i3 = i11;
    case 3:
    case 12:
    case 14:
    case 13:
    case 11:
    case 10:
    case 9:
    case 8:
    case 7:
    case 6:
    case 5:
    case 4:
    case 2:
    case 1:
    }
    for (int i4 = i10; ; i4 = 0)
    {
      i5 = i3 & i2;
      if (i4 + 1 < j)
        break label304;
      label384: int i12;
      if (i2 < 0)
      {
        i8 = 1;
        i7 = i5;
        i6 = i4;
        break;
        i12 = i4 + 1;
        arrayOfInt[i4] = i5;
        int i13 = paramIntNum2.words[i12];
        i2 = paramIntNum3.words[i12];
        i3 = i13;
      }
      for (i4 = i12; ; i4 = 0)
      {
        i5 = i3 & (i2 ^ 0xFFFFFFFF);
        if (i4 + 1 < j)
          break label384;
        label489: int i14;
        if (i2 >= 0)
        {
          i8 = 1;
          i7 = i5;
          i6 = i4;
          break;
          int i45 = i1;
          i8 = 1;
          i7 = i45;
          i6 = 0;
          break;
          i14 = i4 + 1;
          arrayOfInt[i4] = i5;
          int i15 = paramIntNum2.words[i14];
          i2 = paramIntNum3.words[i14];
          i3 = i15;
        }
        for (i4 = i14; ; i4 = 0)
        {
          i5 = i2 & (i3 ^ 0xFFFFFFFF);
          if (i4 + 1 < j)
            break label489;
          label571: int i19;
          int i18;
          int i16;
          if (i2 < 0)
          {
            i8 = 2;
            i7 = i5;
            i6 = i4;
            break;
            i19 = i17 + 1;
            arrayOfInt[i17] = i18;
            int i20 = paramIntNum2.words[i19];
            k = paramIntNum3.words[i19];
            i16 = i20;
          }
          for (int i17 = i19; ; i17 = 0)
          {
            i18 = k;
            if (i17 + 1 < j)
              break label571;
            i6 = i17;
            i7 = i18;
            i8 = 0;
            break;
            label643: int i23 = i21 + 1;
            int i22;
            arrayOfInt[i21] = i22;
            int i24 = paramIntNum2.words[i23];
            k = paramIntNum3.words[i23];
            i1 = i24;
            for (int i21 = i23; ; i21 = 0)
            {
              i22 = i1 ^ k;
              if (i21 + 1 < j)
                break label643;
              if (k < 0);
              for (i8 = 2; ; i8 = 1)
              {
                i6 = i21;
                i7 = i22;
                break;
              }
              label729: int i25 = i4 + 1;
              arrayOfInt[i4] = i5;
              int i26 = paramIntNum2.words[i25];
              i2 = paramIntNum3.words[i25];
              i3 = i26;
              for (i4 = i25; ; i4 = 0)
              {
                i5 = i3 | i2;
                if (i4 + 1 < j)
                  break label729;
                label809: int i27;
                if (i2 >= 0)
                {
                  i8 = 1;
                  i7 = i5;
                  i6 = i4;
                  break;
                  i27 = i4 + 1;
                  arrayOfInt[i4] = i5;
                  int i28 = paramIntNum2.words[i27];
                  i2 = paramIntNum3.words[i27];
                  i3 = i28;
                }
                for (i4 = i27; ; i4 = 0)
                {
                  i5 = 0xFFFFFFFF ^ (i3 | i2);
                  if (i4 + 1 < j)
                    break label809;
                  label891: int i31;
                  int i30;
                  if (i2 >= 0)
                  {
                    i8 = 2;
                    i7 = i5;
                    i6 = i4;
                    break;
                    i31 = i29 + 1;
                    arrayOfInt[i29] = i30;
                    int i32 = paramIntNum2.words[i31];
                    k = paramIntNum3.words[i31];
                    i1 = i32;
                  }
                  for (int i29 = i31; ; i29 = 0)
                  {
                    i30 = 0xFFFFFFFF ^ (i1 ^ k);
                    if (i29 + 1 < j)
                      break label891;
                    if (k >= 0);
                    for (i8 = 2; ; i8 = 1)
                    {
                      i6 = i29;
                      i7 = i30;
                      break;
                    }
                    label979: int i36 = i34 + 1;
                    int i35;
                    arrayOfInt[i34] = i35;
                    int i37 = paramIntNum2.words[i36];
                    k = paramIntNum3.words[i36];
                    int i33 = i37;
                    for (int i34 = i36; ; i34 = 0)
                    {
                      i35 = k ^ 0xFFFFFFFF;
                      if (i34 + 1 < j)
                        break label979;
                      i6 = i34;
                      i7 = i35;
                      i8 = 0;
                      break;
                      label1053: int i38 = i4 + 1;
                      arrayOfInt[i4] = i5;
                      int i39 = paramIntNum2.words[i38];
                      i2 = paramIntNum3.words[i38];
                      i3 = i39;
                      for (i4 = i38; ; i4 = 0)
                      {
                        i5 = i3 | i2 ^ 0xFFFFFFFF;
                        if (i4 + 1 < j)
                          break label1053;
                        label1160: int i40;
                        if (i2 < 0)
                        {
                          i8 = 1;
                          i7 = i5;
                          i6 = i4;
                          break;
                          int i44 = i1 ^ 0xFFFFFFFF;
                          i8 = 2;
                          i7 = i44;
                          i6 = 0;
                          break;
                          i40 = i4 + 1;
                          arrayOfInt[i4] = i5;
                          int i41 = paramIntNum2.words[i40];
                          i2 = paramIntNum3.words[i40];
                          i3 = i41;
                        }
                        for (i4 = i40; ; i4 = 0)
                        {
                          i5 = i2 | i3 ^ 0xFFFFFFFF;
                          if (i4 + 1 < j)
                            break label1160;
                          label1242: int i42;
                          if (i2 >= 0)
                          {
                            i8 = 2;
                            i7 = i5;
                            i6 = i4;
                            break;
                            i42 = i4 + 1;
                            arrayOfInt[i4] = i5;
                            int i43 = paramIntNum2.words[i42];
                            i2 = paramIntNum3.words[i42];
                            i3 = i43;
                          }
                          for (i4 = i42; ; i4 = 0)
                          {
                            i5 = 0xFFFFFFFF ^ i3 & i2;
                            if (i4 + 1 < j)
                              break label1242;
                            if (i2 < 0)
                            {
                              i8 = 2;
                              i7 = i5;
                              i6 = i4;
                              break;
                              if ((i6 == 0) && (arrayOfInt == null))
                              {
                                paramIntNum1.ival = i7;
                                return;
                              }
                              i9 = i6 + 1;
                              arrayOfInt[i6] = i7;
                              break label200;
                              arrayOfInt[i6] = i7;
                              i9 = i6;
                              while (true)
                              {
                                i9++;
                                if (i9 >= n)
                                  break;
                                arrayOfInt[i9] = paramIntNum2.words[i9];
                              }
                              arrayOfInt[i6] = i7;
                              i9 = i6;
                              while (true)
                              {
                                i9++;
                                if (i9 >= n)
                                  break;
                                arrayOfInt[i9] = (0xFFFFFFFF ^ paramIntNum2.words[i9]);
                              }
                            }
                            i6 = i4;
                            i7 = i5;
                            i8 = 0;
                            break;
                            i2 = k;
                            i3 = i1;
                          }
                          i2 = k;
                          i3 = i1;
                        }
                        i2 = k;
                        i3 = i1;
                      }
                      i33 = i1;
                    }
                  }
                  i2 = k;
                  i3 = i1;
                }
                i2 = k;
                i3 = i1;
              }
            }
            i16 = i1;
          }
          i2 = k;
          i3 = i1;
        }
        i2 = k;
        i3 = i1;
      }
      i2 = k;
      i3 = i1;
    }
  }

  public static IntNum setBitValue(IntNum paramIntNum, int paramInt1, int paramInt2)
  {
    int i = paramInt2 & 0x1;
    int j = paramIntNum.ival;
    if (paramIntNum.words == null)
    {
      if (paramInt1 < 31);
      for (int i1 = paramInt1; (0x1 & j >> i1) == i; i1 = 31)
        return paramIntNum;
      if (paramInt1 < 63)
        return IntNum.make(j ^ 1 << paramInt1);
    }
    else
    {
      int k = paramInt1 >> 5;
      int m;
      if (k >= j)
        if (paramIntNum.words[(j - 1)] < 0)
          m = 1;
      while (m == i)
      {
        return paramIntNum;
        m = 0;
        continue;
        m = 0x1 & paramIntNum.words[k] >> paramInt1;
      }
    }
    int[] arrayOfInt = dataBufferFor(paramIntNum, paramInt1);
    int n = paramInt1 >> 5;
    arrayOfInt[n] ^= 1 << (paramInt1 & 0x1F);
    return IntNum.make(arrayOfInt, arrayOfInt.length);
  }

  public static int swappedOp(int paramInt)
  {
    return "".charAt(paramInt);
  }

  public static boolean test(IntNum paramIntNum, int paramInt)
  {
    if (paramIntNum.words == null)
      return (paramInt & paramIntNum.ival) != 0;
    return (paramInt < 0) || ((paramInt & paramIntNum.words[0]) != 0);
  }

  public static boolean test(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    if (paramIntNum2.words == null)
      return test(paramIntNum1, paramIntNum2.ival);
    if (paramIntNum1.words == null)
      return test(paramIntNum2, paramIntNum1.ival);
    if (paramIntNum1.ival < paramIntNum2.ival)
    {
      IntNum localIntNum = paramIntNum1;
      paramIntNum1 = paramIntNum2;
      paramIntNum2 = localIntNum;
    }
    for (int i = 0; i < paramIntNum2.ival; i++)
      if ((paramIntNum1.words[i] & paramIntNum2.words[i]) != 0)
        return true;
    return paramIntNum2.isNegative();
  }

  public static IntNum xor(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    return bitOp(6, paramIntNum1, paramIntNum2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.BitOps
 * JD-Core Version:    0.6.2
 */