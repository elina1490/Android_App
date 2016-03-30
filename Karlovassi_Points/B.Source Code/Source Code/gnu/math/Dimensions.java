package gnu.math;

public class Dimensions
{
  public static Dimensions Empty = new Dimensions();
  private static Dimensions[] hashTable = new Dimensions[100];
  BaseUnit[] bases;
  private Dimensions chain;
  int hash_code;
  short[] powers;

  private Dimensions()
  {
    this.bases = new BaseUnit[1];
    this.bases[0] = Unit.Empty;
    enterHash(0);
  }

  Dimensions(BaseUnit paramBaseUnit)
  {
    this.bases = new BaseUnit[2];
    this.powers = new short[1];
    this.bases[0] = paramBaseUnit;
    this.bases[1] = Unit.Empty;
    this.powers[0] = 1;
    enterHash(paramBaseUnit.index);
  }

  private Dimensions(Dimensions paramDimensions1, int paramInt1, Dimensions paramDimensions2, int paramInt2, int paramInt3)
  {
    this.hash_code = paramInt3;
    for (int i = 0; paramDimensions1.bases[i] != Unit.Empty; i++);
    for (int j = 0; paramDimensions2.bases[j] != Unit.Empty; j++);
    int k = 1 + (i + j);
    this.bases = new BaseUnit[k];
    this.powers = new short[k];
    int m = 0;
    int n = 0;
    int i1 = 0;
    while (true)
    {
      Object localObject = paramDimensions1.bases[i1];
      BaseUnit localBaseUnit = paramDimensions2.bases[n];
      int i2;
      if (((BaseUnit)localObject).index < localBaseUnit.index)
      {
        i2 = paramInt1 * paramDimensions1.powers[i1];
        i1++;
      }
      while (true)
      {
        short[] arrayOfShort;
        int i3;
        if ((short)i2 != i2)
        {
          throw new ArithmeticException("overflow in dimensions");
          if (localBaseUnit.index < ((BaseUnit)localObject).index)
          {
            localObject = localBaseUnit;
            i2 = paramInt2 * paramDimensions2.powers[n];
            n++;
          }
          else
          {
            if (localBaseUnit == Unit.Empty)
            {
              this.bases[m] = Unit.Empty;
              enterHash(paramInt3);
              return;
            }
            i2 = paramInt1 * paramDimensions1.powers[i1] + paramInt2 * paramDimensions2.powers[n];
            i1++;
            n++;
            if (i2 == 0)
              break;
          }
        }
      }
      this.bases[m] = localObject;
      arrayOfShort = this.powers;
      i3 = m + 1;
      arrayOfShort[m] = ((short)i2);
      m = i3;
    }
  }

  private void enterHash(int paramInt)
  {
    this.hash_code = paramInt;
    int i = (0x7FFFFFFF & paramInt) % hashTable.length;
    this.chain = hashTable[i];
    hashTable[i] = this;
  }

  private boolean matchesProduct(Dimensions paramDimensions1, int paramInt1, Dimensions paramDimensions2, int paramInt2)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      Object localObject = paramDimensions1.bases[i];
      BaseUnit localBaseUnit = paramDimensions2.bases[j];
      int m;
      if (((BaseUnit)localObject).index < localBaseUnit.index)
      {
        m = paramInt1 * paramDimensions1.powers[i];
        i++;
      }
      while (true)
        if ((this.bases[k] != localObject) || (this.powers[k] != m))
        {
          return false;
          if (localBaseUnit.index < ((BaseUnit)localObject).index)
          {
            localObject = localBaseUnit;
            m = paramInt2 * paramDimensions2.powers[j];
            j++;
          }
          else
          {
            if (localBaseUnit == Unit.Empty)
              return this.bases[k] == localBaseUnit;
            m = paramInt1 * paramDimensions1.powers[i] + paramInt2 * paramDimensions2.powers[j];
            i++;
            j++;
            if (m == 0)
              break;
          }
        }
      k++;
    }
  }

  public static Dimensions product(Dimensions paramDimensions1, int paramInt1, Dimensions paramDimensions2, int paramInt2)
  {
    int i = paramInt1 * paramDimensions1.hashCode() + paramInt2 * paramDimensions2.hashCode();
    int j = (0x7FFFFFFF & i) % hashTable.length;
    for (Dimensions localDimensions = hashTable[j]; localDimensions != null; localDimensions = localDimensions.chain)
      if ((localDimensions.hash_code == i) && (localDimensions.matchesProduct(paramDimensions1, paramInt1, paramDimensions2, paramInt2)))
        return localDimensions;
    return new Dimensions(paramDimensions1, paramInt1, paramDimensions2, paramInt2, i);
  }

  public int getPower(BaseUnit paramBaseUnit)
  {
    for (int i = 0; this.bases[i].index <= paramBaseUnit.index; i++)
      if (this.bases[i] == paramBaseUnit)
        return this.powers[i];
    return 0;
  }

  public final int hashCode()
  {
    return this.hash_code;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; this.bases[i] != Unit.Empty; i++)
    {
      if (i > 0)
        localStringBuffer.append('*');
      localStringBuffer.append(this.bases[i]);
      int j = this.powers[i];
      if (j != 1)
      {
        localStringBuffer.append('^');
        localStringBuffer.append(j);
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.Dimensions
 * JD-Core Version:    0.6.2
 */