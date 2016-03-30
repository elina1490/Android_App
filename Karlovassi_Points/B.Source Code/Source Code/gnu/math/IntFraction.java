package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class IntFraction extends RatNum
  implements Externalizable
{
  IntNum den;
  IntNum num;

  IntFraction()
  {
  }

  public IntFraction(IntNum paramIntNum1, IntNum paramIntNum2)
  {
    this.num = paramIntNum1;
    this.den = paramIntNum2;
  }

  public static IntFraction neg(IntFraction paramIntFraction)
  {
    return new IntFraction(IntNum.neg(paramIntFraction.numerator()), paramIntFraction.denominator());
  }

  public Numeric add(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof RatNum))
      return RatNum.add(this, (RatNum)paramObject, paramInt);
    if (!(paramObject instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)paramObject).addReversed(this, paramInt);
  }

  public Numeric addReversed(Numeric paramNumeric, int paramInt)
  {
    if (!(paramNumeric instanceof RatNum))
      throw new IllegalArgumentException();
    return RatNum.add((RatNum)paramNumeric, this, paramInt);
  }

  public final int compare(Object paramObject)
  {
    if ((paramObject instanceof RatNum))
      return RatNum.compare(this, (RatNum)paramObject);
    return ((RealNum)paramObject).compareReversed(this);
  }

  public int compareReversed(Numeric paramNumeric)
  {
    return RatNum.compare((RatNum)paramNumeric, this);
  }

  public final IntNum denominator()
  {
    return this.den;
  }

  public Numeric div(Object paramObject)
  {
    if ((paramObject instanceof RatNum))
      return RatNum.divide(this, (RatNum)paramObject);
    if (!(paramObject instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)paramObject).divReversed(this);
  }

  public Numeric divReversed(Numeric paramNumeric)
  {
    if (!(paramNumeric instanceof RatNum))
      throw new IllegalArgumentException();
    return RatNum.divide((RatNum)paramNumeric, this);
  }

  public double doubleValue()
  {
    boolean bool1 = this.num.isNegative();
    if (this.den.isZero())
    {
      if (bool1)
        return (-1.0D / 0.0D);
      if (this.num.isZero())
        return (0.0D / 0.0D);
      return (1.0D / 0.0D);
    }
    IntNum localIntNum1 = this.num;
    if (bool1)
      localIntNum1 = IntNum.neg(localIntNum1);
    int i = localIntNum1.intLength();
    int j = this.den.intLength();
    int k = j + 54;
    int m = 0;
    if (i < k)
    {
      int n = j + 54 - i;
      localIntNum1 = IntNum.shift(localIntNum1, n);
      m = -n;
    }
    IntNum localIntNum2 = new IntNum();
    IntNum localIntNum3 = new IntNum();
    IntNum.divide(localIntNum1, this.den, localIntNum2, localIntNum3, 3);
    IntNum localIntNum4 = localIntNum2.canonicalize();
    if (!localIntNum3.canonicalize().isZero());
    for (boolean bool2 = true; ; bool2 = false)
      return localIntNum4.roundToDouble(m, bool1, bool2);
  }

  public final boolean isNegative()
  {
    return this.num.isNegative();
  }

  public long longValue()
  {
    return toExactInt(4).longValue();
  }

  public Numeric mul(Object paramObject)
  {
    if ((paramObject instanceof RatNum))
      return RatNum.times(this, (RatNum)paramObject);
    if (!(paramObject instanceof Numeric))
      throw new IllegalArgumentException();
    return ((Numeric)paramObject).mulReversed(this);
  }

  public Numeric mulReversed(Numeric paramNumeric)
  {
    if (!(paramNumeric instanceof RatNum))
      throw new IllegalArgumentException();
    return RatNum.times((RatNum)paramNumeric, this);
  }

  public Numeric neg()
  {
    return neg(this);
  }

  public final IntNum numerator()
  {
    return this.num;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.num = ((IntNum)paramObjectInput.readObject());
    this.den = ((IntNum)paramObjectInput.readObject());
  }

  public final int sign()
  {
    return this.num.sign();
  }

  public String toString(int paramInt)
  {
    return this.num.toString(paramInt) + '/' + this.den.toString(paramInt);
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.num);
    paramObjectOutput.writeObject(this.den);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.IntFraction
 * JD-Core Version:    0.6.2
 */