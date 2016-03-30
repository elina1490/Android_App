package gnu.math;

class MPN
{
  public static int add_1(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    long l1 = 0xFFFFFFFF & paramInt2;
    for (int i = 0; i < paramInt1; i++)
    {
      long l2 = l1 + (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt1[i] = ((int)l2);
      l1 = l2 >> 32;
    }
    return (int)l1;
  }

  public static int add_n(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int paramInt)
  {
    long l1 = 0L;
    for (int i = 0; i < paramInt; i++)
    {
      long l2 = l1 + ((0xFFFFFFFF & paramArrayOfInt2[i]) + (0xFFFFFFFF & paramArrayOfInt3[i]));
      paramArrayOfInt1[i] = ((int)l2);
      l1 = l2 >>> 32;
    }
    return (int)l1;
  }

  public static int chars_per_word(int paramInt)
  {
    int i = 10;
    if (paramInt < i)
    {
      if (paramInt < 8)
      {
        if (paramInt <= 2)
          i = 32;
      }
      else
        return i;
      if (paramInt == 3)
        return 20;
      if (paramInt == 4)
        return 16;
      return 18 - paramInt;
    }
    if (paramInt < 12)
      return 9;
    if (paramInt <= 16)
      return 8;
    if (paramInt <= 23)
      return 7;
    if (paramInt <= 40)
      return 6;
    if (paramInt <= 256)
      return 4;
    return 1;
  }

  public static int cmp(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    if (paramInt1 > paramInt2)
      return 1;
    if (paramInt1 < paramInt2)
      return -1;
    return cmp(paramArrayOfInt1, paramArrayOfInt2, paramInt1);
  }

  public static int cmp(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i;
    int j;
    do
    {
      paramInt--;
      if (paramInt < 0)
        break;
      i = paramArrayOfInt1[paramInt];
      j = paramArrayOfInt2[paramInt];
    }
    while (i == j);
    if ((i ^ 0x80000000) > (0x80000000 ^ j))
      return 1;
    return -1;
    return 0;
  }

  public static int count_leading_zeros(int paramInt)
  {
    if (paramInt == 0)
      return 32;
    int i = 0;
    int j = 16;
    if (j > 0)
    {
      int k = paramInt >>> j;
      if (k == 0)
        i += j;
      while (true)
      {
        j >>= 1;
        break;
        paramInt = k;
      }
    }
    return i;
  }

  public static void divide(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    label203: int m;
    for (int i = paramInt1; ; i = m)
    {
      int j;
      long l1;
      if (paramArrayOfInt1[i] == paramArrayOfInt2[(paramInt2 - 1)])
      {
        j = -1;
        if (j != 0)
        {
          int n = submul_1(paramArrayOfInt1, i - paramInt2, paramArrayOfInt2, paramInt2, j);
          l1 = (0xFFFFFFFF & paramArrayOfInt1[i]) - (0xFFFFFFFF & n);
        }
      }
      else
      {
        int i1;
        for (k = j; ; k = i1)
        {
          if (l1 == 0L)
            break label203;
          i1 = k - 1;
          long l2 = 0L;
          int i2 = 0;
          while (true)
            if (i2 < paramInt2)
            {
              long l3 = l2 + ((0xFFFFFFFF & paramArrayOfInt1[(i2 + (i - paramInt2))]) + (0xFFFFFFFF & paramArrayOfInt2[i2]));
              paramArrayOfInt1[(i2 + (i - paramInt2))] = ((int)l3);
              l2 = l3 >>> 32;
              i2++;
              continue;
              j = (int)udiv_qrnnd((paramArrayOfInt1[i] << 32) + (0xFFFFFFFF & paramArrayOfInt1[(i - 1)]), paramArrayOfInt2[(paramInt2 - 1)]);
              break;
            }
          paramArrayOfInt1[i] = ((int)(l2 + paramArrayOfInt1[i]));
          l1 = l2 - 1L;
        }
      }
      int k = j;
      paramArrayOfInt1[i] = k;
      m = i - 1;
      if (m < paramInt2)
        return;
    }
  }

  public static int divmod_1(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    int i = paramInt1 - 1;
    long l1 = paramArrayOfInt2[i];
    long l2;
    if ((l1 & 0xFFFFFFFF) >= (0xFFFFFFFF & paramInt2))
      l2 = 0L;
    while (i >= 0)
    {
      int k = paramArrayOfInt2[i];
      l2 = udiv_qrnnd(0x0 & l2 | 0xFFFFFFFF & k, paramInt2);
      paramArrayOfInt1[i] = ((int)l2);
      i--;
      continue;
      int j = i - 1;
      paramArrayOfInt1[i] = 0;
      l2 = l1 << 32;
      i = j;
    }
    return (int)(l2 >> 32);
  }

  static int findLowestBit(int paramInt)
  {
    for (int i = 0; (paramInt & 0xF) == 0; i += 4)
      paramInt >>= 4;
    if ((paramInt & 0x3) == 0)
    {
      paramInt >>= 2;
      i += 2;
    }
    if ((paramInt & 0x1) == 0)
      i++;
    return i;
  }

  static int findLowestBit(int[] paramArrayOfInt)
  {
    for (int i = 0; ; i++)
      if (paramArrayOfInt[i] != 0)
        return i * 32 + findLowestBit(paramArrayOfInt[i]);
  }

  public static int gcd(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfInt1[i] | paramArrayOfInt2[i];
    int k;
    int m;
    int n;
    Object localObject2;
    Object localObject1;
    if (j != 0)
    {
      k = i;
      m = findLowestBit(j);
      n = paramInt - k;
      rshift0(paramArrayOfInt1, paramArrayOfInt1, k, n, m);
      rshift0(paramArrayOfInt2, paramArrayOfInt2, k, n, m);
      if ((0x1 & paramArrayOfInt1[0]) == 0)
        break label93;
      localObject2 = paramArrayOfInt1;
      localObject1 = paramArrayOfInt2;
    }
    int i1;
    while (true)
    {
      for (i1 = 0; localObject1[i1] == 0; i1++);
      i++;
      break;
      label93: localObject1 = paramArrayOfInt1;
      localObject2 = paramArrayOfInt2;
    }
    int i9;
    if (i1 > 0)
      for (i9 = 0; i9 < n - i1; i9++)
        localObject1[i9] = localObject1[(i9 + i1)];
    while (true)
    {
      int i10;
      if (i10 < n)
      {
        localObject1[i10] = 0;
        i10++;
      }
      else
      {
        int i2 = findLowestBit(localObject1[0]);
        if (i2 > 0)
          rshift((int[])localObject1, (int[])localObject1, 0, n, i2);
        int i3 = cmp((int[])localObject2, (int[])localObject1, n);
        if (i3 == 0)
        {
          if (k + m <= 0)
            break label390;
          if (m <= 0)
            break label351;
          int i7 = lshift(paramArrayOfInt1, k, paramArrayOfInt1, n, m);
          if (i7 != 0)
          {
            int i8 = n + 1;
            paramArrayOfInt1[(n + k)] = i7;
            n = i8;
          }
        }
        int i5;
        Object localObject3;
        Object localObject4;
        while (true)
        {
          i5 = k;
          while (true)
          {
            i5--;
            if (i5 < 0)
              break;
            paramArrayOfInt1[i5] = 0;
          }
          if (i3 > 0)
          {
            sub_n((int[])localObject2, (int[])localObject2, (int[])localObject1, n);
            Object localObject5 = localObject2;
            localObject3 = localObject1;
            localObject4 = localObject5;
          }
          while ((localObject3[(n - 1)] == 0) && (localObject4[(n - 1)] == 0))
          {
            n--;
            continue;
            sub_n((int[])localObject1, (int[])localObject1, (int[])localObject2, n);
            localObject3 = localObject2;
            localObject4 = localObject1;
          }
          label351: int i4 = n;
          while (true)
          {
            i4--;
            if (i4 < 0)
              break;
            paramArrayOfInt1[(i4 + k)] = paramArrayOfInt1[i4];
          }
        }
        int i6 = n + k;
        return i6;
        label390: return n;
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        i10 = i9;
      }
    }
  }

  public static int intLength(int paramInt)
  {
    if (paramInt < 0);
    for (int i = paramInt ^ 0xFFFFFFFF; ; i = paramInt)
      return 32 - count_leading_zeros(i);
  }

  public static int intLength(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramInt - 1;
    return intLength(paramArrayOfInt[i]) + i * 32;
  }

  public static int lshift(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3)
  {
    int i = 32 - paramInt3;
    int j = paramInt2 - 1;
    int k = paramArrayOfInt2[j];
    int m = k >>> i;
    int n = paramInt1 + 1;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      int i1 = paramArrayOfInt2[j];
      paramArrayOfInt1[(n + j)] = (k << paramInt3 | i1 >>> i);
      k = i1;
    }
    paramArrayOfInt1[(n + j)] = (k << paramInt3);
    return m;
  }

  public static void mul(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int[] paramArrayOfInt3, int paramInt2)
  {
    paramArrayOfInt1[paramInt1] = mul_1(paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramArrayOfInt3[0]);
    for (int i = 1; i < paramInt2; i++)
    {
      long l1 = 0xFFFFFFFF & paramArrayOfInt3[i];
      long l2 = 0L;
      for (int j = 0; j < paramInt1; j++)
      {
        long l3 = l2 + (l1 * (0xFFFFFFFF & paramArrayOfInt2[j]) + (0xFFFFFFFF & paramArrayOfInt1[(i + j)]));
        paramArrayOfInt1[(i + j)] = ((int)l3);
        l2 = l3 >>> 32;
      }
      paramArrayOfInt1[(i + paramInt1)] = ((int)l2);
    }
  }

  public static int mul_1(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2)
  {
    long l1 = 0xFFFFFFFF & paramInt2;
    long l2 = 0L;
    for (int i = 0; i < paramInt1; i++)
    {
      long l3 = l2 + l1 * (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt1[i] = ((int)l3);
      l2 = l3 >>> 32;
    }
    return (int)l2;
  }

  public static int rshift(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 32 - paramInt3;
    int j = paramArrayOfInt2[paramInt1];
    int k = j << i;
    for (int m = 1; m < paramInt2; m++)
    {
      int n = paramArrayOfInt2[(paramInt1 + m)];
      paramArrayOfInt1[(m - 1)] = (j >>> paramInt3 | n << i);
      j = n;
    }
    paramArrayOfInt1[(m - 1)] = (j >>> paramInt3);
    return k;
  }

  public static void rshift0(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
      rshift(paramArrayOfInt1, paramArrayOfInt2, paramInt1, paramInt2, paramInt3);
    while (true)
    {
      return;
      for (int i = 0; i < paramInt2; i++)
        paramArrayOfInt1[i] = paramArrayOfInt2[(i + paramInt1)];
    }
  }

  public static long rshift_long(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramInt2 >> 5;
    int j = paramInt2 & 0x1F;
    int k;
    int m;
    label30: int n;
    int i1;
    label45: int i2;
    if (paramArrayOfInt[(paramInt1 - 1)] < 0)
    {
      k = -1;
      if (i < paramInt1)
        break label119;
      m = k;
      n = i + 1;
      if (n < paramInt1)
        break label127;
      i1 = k;
      if (j != 0)
      {
        i2 = n + 1;
        if (i2 < paramInt1)
          break label136;
      }
    }
    label136: for (int i3 = k; ; i3 = paramArrayOfInt[i2])
    {
      m = m >>> j | i1 << 32 - j;
      i1 = i1 >>> j | i3 << 32 - j;
      return i1 << 32 | 0xFFFFFFFF & m;
      k = 0;
      break;
      label119: m = paramArrayOfInt[i];
      break label30;
      label127: i1 = paramArrayOfInt[n];
      break label45;
    }
  }

  public static int set_str(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i10;
    int i14;
    int j;
    int i17;
    int i18;
    int i21;
    int i20;
    int i19;
    if ((paramInt2 & paramInt2 - 1) == 0)
    {
      i10 = 0;
      int i11 = 0;
      int i12 = paramInt2;
      while (true)
      {
        i12 >>= 1;
        if (i12 == 0)
          break;
        i11++;
      }
      int i13 = paramInt1;
      i14 = 0;
      j = 0;
      i13--;
      if (i13 >= 0)
      {
        int i16 = paramArrayOfByte[i13];
        i17 = i14 | i16 << i10;
        i18 = i10 + i11;
        if (i18 < 32)
          break label335;
        int i22 = j + 1;
        paramArrayOfInt[j] = i17;
        int i23 = i18 - 32;
        int i24 = i16 >> i11 - i23;
        i21 = i22;
        i20 = i24;
        i19 = i23;
      }
    }
    while (true)
    {
      j = i21;
      i14 = i20;
      i10 = i19;
      break;
      if (i14 != 0)
      {
        int i15 = j + 1;
        paramArrayOfInt[j] = i14;
        return i15;
        int i = chars_per_word(paramInt2);
        j = 0;
        int k = 0;
        if (k < paramInt1)
        {
          int m = paramInt1 - k;
          if (m > i);
          for (int n = i; ; n = m)
          {
            int i1 = k + 1;
            int i2 = paramArrayOfByte[k];
            int i3 = paramInt2;
            int i9;
            for (int i4 = i1; ; i4 = i9)
            {
              n--;
              if (n <= 0)
                break;
              int i8 = i2 * paramInt2;
              i9 = i4 + 1;
              i2 = i8 + paramArrayOfByte[i4];
              i3 *= paramInt2;
            }
            int i5;
            label262: int i7;
            if (j == 0)
            {
              i5 = i2;
              if (i5 == 0)
                break label318;
              i7 = j + 1;
              paramArrayOfInt[j] = i5;
            }
            label318: for (int i6 = i7; ; i6 = j)
            {
              k = i4;
              j = i6;
              break;
              i5 = mul_1(paramArrayOfInt, paramArrayOfInt, j, i3) + add_1(paramArrayOfInt, paramArrayOfInt, j, i2);
              break label262;
            }
          }
        }
      }
      return j;
      label335: i19 = i18;
      i20 = i17;
      i21 = j;
    }
  }

  public static int sub_n(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int paramInt)
  {
    int i = 0;
    int j = 0;
    if (j < paramInt)
    {
      int k = paramArrayOfInt3[j];
      int m = paramArrayOfInt2[j];
      int n = k + i;
      int i1;
      label47: int i2;
      if ((n ^ 0x80000000) < (i ^ 0x80000000))
      {
        i1 = 1;
        i2 = m - n;
        if ((i2 ^ 0x80000000) <= (m ^ 0x80000000))
          break label95;
      }
      label95: for (int i3 = 1; ; i3 = 0)
      {
        i = i1 + i3;
        paramArrayOfInt1[j] = i2;
        j++;
        break;
        i1 = 0;
        break label47;
      }
    }
    return i;
  }

  public static int submul_1(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3)
  {
    long l1 = 0xFFFFFFFF & paramInt3;
    int i = 0;
    int j = 0;
    long l2 = l1 * (0xFFFFFFFF & paramArrayOfInt2[j]);
    int k = (int)l2;
    int m = (int)(l2 >> 32);
    int n = k + i;
    if ((0x80000000 ^ n) < (i ^ 0x80000000));
    for (int i1 = 1; ; i1 = 0)
    {
      i = i1 + m;
      int i2 = paramArrayOfInt1[(paramInt1 + j)];
      int i3 = i2 - n;
      if ((0x80000000 ^ i3) > (i2 ^ 0x80000000))
        i++;
      paramArrayOfInt1[(paramInt1 + j)] = i3;
      j++;
      if (j < paramInt2)
        break;
      return i;
    }
  }

  public static long udiv_qrnnd(long paramLong, int paramInt)
  {
    long l1 = paramLong >>> 32;
    long l2 = 0xFFFFFFFF & paramLong;
    long l12;
    long l11;
    if (paramInt >= 0)
      if (l1 < (0xFFFFFFFF & paramInt - l1 - (l2 >>> 31)))
      {
        long l16 = paramLong / paramInt;
        long l17 = paramLong % paramInt;
        l12 = l16;
        l11 = l17;
      }
    while (true)
    {
      return l11 << 32 | l12 & 0xFFFFFFFF;
      long l13 = paramLong - (paramInt << 31);
      long l14 = l13 / paramInt;
      long l15 = l13 % paramInt;
      l12 = -2147483648L + l14;
      l11 = l15;
      continue;
      long l3 = paramInt >>> 1;
      long l4 = paramLong >>> 1;
      long l8;
      long l10;
      if ((l1 < l3) || (l1 >> 1 < l3))
      {
        if (l1 < l3)
          l8 = l4 / l3;
        long l7;
        for (long l9 = l4 % l3; ; l9 = l3 - 1L - l7)
        {
          l10 = 2L * l9 + (l2 & 1L);
          if ((paramInt & 0x1) == 0)
            break label351;
          if (l10 < l8)
            break label247;
          l11 = l10 - l8;
          l12 = l8;
          break;
          long l5 = 0xFFFFFFFF ^ l4 - (l3 << 32);
          long l6 = l5 / l3;
          l7 = l5 % l3;
          l8 = 0xFFFFFFFF & (l6 ^ 0xFFFFFFFF);
        }
        label247: if (l8 - l10 <= (0xFFFFFFFF & paramInt))
        {
          l11 = l10 - l8 + paramInt;
          l12 = l8 - 1L;
        }
        else
        {
          l11 = l10 - l8 + paramInt + paramInt;
          l12 = l8 - 2L;
        }
      }
      else if (l2 >= (0xFFFFFFFF & -paramInt))
      {
        l12 = -1L;
        l11 = l2 + paramInt;
      }
      else
      {
        l12 = -2L;
        l11 = l2 + paramInt + paramInt;
        continue;
        label351: l11 = l10;
        l12 = l8;
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.MPN
 * JD-Core Version:    0.6.2
 */