package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class BaseUnit extends NamedUnit
  implements Externalizable
{
  static int base_count = 0;
  private static final String unitName = "(name)";
  String dimension;
  int index;

  public BaseUnit()
  {
    this.name = "(name)";
    this.index = 2147483647;
    this.dims = Dimensions.Empty;
  }

  public BaseUnit(String paramString)
  {
    this.name = paramString;
    init();
  }

  public BaseUnit(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.dimension = paramString2;
    init();
  }

  public static int compare(BaseUnit paramBaseUnit1, BaseUnit paramBaseUnit2)
  {
    int i = paramBaseUnit1.name.compareTo(paramBaseUnit2.name);
    if (i != 0)
      return i;
    String str1 = paramBaseUnit1.dimension;
    String str2 = paramBaseUnit2.dimension;
    if (str1 == str2)
      return 0;
    if (str1 == null)
      return -1;
    if (str2 == null)
      return 1;
    return str1.compareTo(str2);
  }

  public static BaseUnit lookup(String paramString1, String paramString2)
  {
    String str = paramString1.intern();
    if ((str == "(name)") && (paramString2 == null))
      return Unit.Empty;
    int i = (0x7FFFFFFF & str.hashCode()) % table.length;
    for (NamedUnit localNamedUnit = table[i]; localNamedUnit != null; localNamedUnit = localNamedUnit.chain)
      if ((localNamedUnit.name == str) && ((localNamedUnit instanceof BaseUnit)))
      {
        BaseUnit localBaseUnit = (BaseUnit)localNamedUnit;
        if (localBaseUnit.dimension == paramString2)
          return localBaseUnit;
      }
    return null;
  }

  public static BaseUnit make(String paramString1, String paramString2)
  {
    BaseUnit localBaseUnit = lookup(paramString1, paramString2);
    if (localBaseUnit == null)
      return new BaseUnit(paramString1, paramString2);
    return localBaseUnit;
  }

  public String getDimension()
  {
    return this.dimension;
  }

  public int hashCode()
  {
    return this.name.hashCode();
  }

  protected void init()
  {
    this.base = this;
    this.scale = 1.0D;
    this.dims = new Dimensions(this);
    super.init();
    int i = base_count;
    base_count = i + 1;
    this.index = i;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.name = paramObjectInput.readUTF();
    this.dimension = ((String)paramObjectInput.readObject());
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    BaseUnit localBaseUnit = lookup(this.name, this.dimension);
    if (localBaseUnit != null)
      return localBaseUnit;
    init();
    return this;
  }

  public Unit unit()
  {
    return this;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeUTF(this.name);
    paramObjectOutput.writeObject(this.dimension);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.BaseUnit
 * JD-Core Version:    0.6.2
 */