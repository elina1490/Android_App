package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class NamedUnit extends Unit
  implements Externalizable
{
  Unit base;
  NamedUnit chain;
  String name;
  double scale;

  public NamedUnit()
  {
  }

  public NamedUnit(String paramString, double paramDouble, Unit paramUnit)
  {
    this.name = paramString;
    this.base = paramUnit;
    this.scale = paramDouble;
    init();
  }

  public NamedUnit(String paramString, DQuantity paramDQuantity)
  {
    this.name = paramString.intern();
    this.scale = paramDQuantity.factor;
    this.base = paramDQuantity.unt;
    init();
  }

  public static NamedUnit lookup(String paramString)
  {
    String str = paramString.intern();
    int i = (0x7FFFFFFF & str.hashCode()) % table.length;
    for (NamedUnit localNamedUnit = table[i]; localNamedUnit != null; localNamedUnit = localNamedUnit.chain)
      if (localNamedUnit.name == str)
        return localNamedUnit;
    return null;
  }

  public static NamedUnit lookup(String paramString, double paramDouble, Unit paramUnit)
  {
    String str = paramString.intern();
    int i = (0x7FFFFFFF & str.hashCode()) % table.length;
    for (NamedUnit localNamedUnit = table[i]; localNamedUnit != null; localNamedUnit = localNamedUnit.chain)
      if ((localNamedUnit.name == str) && (localNamedUnit.scale == paramDouble) && (localNamedUnit.base == paramUnit))
        return localNamedUnit;
    return null;
  }

  public static NamedUnit make(String paramString, double paramDouble, Unit paramUnit)
  {
    NamedUnit localNamedUnit = lookup(paramString, paramDouble, paramUnit);
    if (localNamedUnit == null)
      return new NamedUnit(paramString, paramDouble, paramUnit);
    return localNamedUnit;
  }

  public static NamedUnit make(String paramString, Quantity paramQuantity)
  {
    if ((paramQuantity instanceof DQuantity));
    NamedUnit localNamedUnit;
    for (double d = ((DQuantity)paramQuantity).factor; ; d = paramQuantity.re().doubleValue())
    {
      Unit localUnit = paramQuantity.unit();
      localNamedUnit = lookup(paramString, d, localUnit);
      if (localNamedUnit != null)
        break;
      return new NamedUnit(paramString, d, localUnit);
      if (paramQuantity.imValue() != 0.0D)
        throw new ArithmeticException("defining " + paramString + " using complex value");
    }
    return localNamedUnit;
  }

  public String getName()
  {
    return this.name;
  }

  protected void init()
  {
    this.factor = (this.scale * this.base.factor);
    this.dims = this.base.dims;
    this.name = this.name.intern();
    int i = (0x7FFFFFFF & this.name.hashCode()) % table.length;
    this.chain = table[i];
    table[i] = this;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.name = paramObjectInput.readUTF();
    this.scale = paramObjectInput.readDouble();
    this.base = ((Unit)paramObjectInput.readObject());
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    NamedUnit localNamedUnit = lookup(this.name, this.scale, this.base);
    if (localNamedUnit != null)
      return localNamedUnit;
    init();
    return this;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeUTF(this.name);
    paramObjectOutput.writeDouble(this.scale);
    paramObjectOutput.writeObject(this.base);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.NamedUnit
 * JD-Core Version:    0.6.2
 */