package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

class MulUnit extends Unit
  implements Externalizable
{
  MulUnit next;
  int power1;
  int power2;
  Unit unit1;
  Unit unit2;

  MulUnit(Unit paramUnit1, int paramInt1, Unit paramUnit2, int paramInt2)
  {
    this.unit1 = paramUnit1;
    this.unit2 = paramUnit2;
    this.power1 = paramInt1;
    this.power2 = paramInt2;
    this.dims = Dimensions.product(paramUnit1.dims, paramInt1, paramUnit2.dims, paramInt2);
    if (paramInt1 == 1);
    for (this.factor = paramUnit1.factor; paramInt2 < 0; this.factor = Math.pow(paramUnit1.factor, paramInt1))
    {
      int j = -paramInt2;
      while (true)
      {
        j--;
        if (j < 0)
          break;
        this.factor /= paramUnit2.factor;
      }
    }
    int i = paramInt2;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      this.factor *= paramUnit2.factor;
    }
    this.next = paramUnit1.products;
    paramUnit1.products = this;
  }

  MulUnit(Unit paramUnit1, Unit paramUnit2, int paramInt)
  {
    this(paramUnit1, 1, paramUnit2, paramInt);
  }

  static MulUnit lookup(Unit paramUnit1, int paramInt1, Unit paramUnit2, int paramInt2)
  {
    for (MulUnit localMulUnit = paramUnit1.products; localMulUnit != null; localMulUnit = localMulUnit.next)
      if ((localMulUnit.unit1 == paramUnit1) && (localMulUnit.unit2 == paramUnit2) && (localMulUnit.power1 == paramInt1) && (localMulUnit.power2 == paramInt2))
        return localMulUnit;
    return null;
  }

  public static MulUnit make(Unit paramUnit1, int paramInt1, Unit paramUnit2, int paramInt2)
  {
    MulUnit localMulUnit = lookup(paramUnit1, paramInt1, paramUnit2, paramInt2);
    if (localMulUnit != null)
      return localMulUnit;
    return new MulUnit(paramUnit1, paramInt1, paramUnit2, paramInt2);
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.unit1 = ((Unit)paramObjectInput.readObject());
    this.power1 = paramObjectInput.readInt();
    this.unit2 = ((Unit)paramObjectInput.readObject());
    this.power2 = paramObjectInput.readInt();
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    MulUnit localMulUnit = lookup(this.unit1, this.power1, this.unit2, this.power2);
    if (localMulUnit != null)
      return localMulUnit;
    return this;
  }

  public Unit sqrt()
  {
    if (((0x1 & this.power1) == 0) && ((0x1 & this.power2) == 0))
      return times(this.unit1, this.power1 >> 1, this.unit2, this.power2 >> 1);
    return super.sqrt();
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(60);
    localStringBuffer.append(this.unit1);
    if (this.power1 != 1)
    {
      localStringBuffer.append('^');
      localStringBuffer.append(this.power1);
    }
    if (this.power2 != 0)
    {
      localStringBuffer.append('*');
      localStringBuffer.append(this.unit2);
      if (this.power2 != 1)
      {
        localStringBuffer.append('^');
        localStringBuffer.append(this.power2);
      }
    }
    return localStringBuffer.toString();
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.unit1);
    paramObjectOutput.writeInt(this.power1);
    paramObjectOutput.writeObject(this.unit2);
    paramObjectOutput.writeInt(this.power2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.MulUnit
 * JD-Core Version:    0.6.2
 */