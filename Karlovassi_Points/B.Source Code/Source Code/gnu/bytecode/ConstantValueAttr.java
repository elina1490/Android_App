package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantValueAttr extends Attribute
{
  Object value;
  int value_index;

  public ConstantValueAttr(int paramInt)
  {
    super("ConstantValue");
    this.value_index = paramInt;
  }

  public ConstantValueAttr(Object paramObject)
  {
    super("ConstantValue");
    this.value = paramObject;
  }

  public void assignConstants(ClassType paramClassType)
  {
    super.assignConstants(paramClassType);
    ConstantPool localConstantPool;
    Object localObject;
    if (this.value_index == 0)
    {
      localConstantPool = paramClassType.getConstants();
      if (!(this.value instanceof String))
        break label50;
      localObject = localConstantPool.addString((String)this.value);
    }
    while (true)
    {
      this.value_index = ((CpoolEntry)localObject).getIndex();
      return;
      label50: if ((this.value instanceof Integer))
      {
        localObject = localConstantPool.addInt(((Integer)this.value).intValue());
      }
      else if ((this.value instanceof Long))
      {
        localObject = localConstantPool.addLong(((Long)this.value).longValue());
      }
      else if ((this.value instanceof Float))
      {
        localObject = localConstantPool.addFloat(((Float)this.value).floatValue());
      }
      else
      {
        boolean bool = this.value instanceof Long;
        localObject = null;
        if (bool)
          localObject = localConstantPool.addDouble(((Double)this.value).doubleValue());
      }
    }
  }

  public final int getLength()
  {
    return 2;
  }

  public Object getValue(ConstantPool paramConstantPool)
  {
    if (this.value != null)
      return this.value;
    CpoolEntry localCpoolEntry = paramConstantPool.getPoolEntry(this.value_index);
    switch (localCpoolEntry.getTag())
    {
    case 7:
    default:
    case 8:
    case 3:
    case 5:
    case 4:
    case 6:
    }
    while (true)
    {
      return this.value;
      this.value = ((CpoolString)localCpoolEntry).getString().getString();
      continue;
      this.value = new Integer(((CpoolValue1)localCpoolEntry).value);
      continue;
      this.value = new Long(((CpoolValue2)localCpoolEntry).value);
      continue;
      this.value = new Float(Float.intBitsToFloat(((CpoolValue1)localCpoolEntry).value));
      continue;
      this.value = new Double(Double.longBitsToDouble(((CpoolValue2)localCpoolEntry).value));
    }
  }

  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    paramClassTypeWriter.print("Attribute \"");
    paramClassTypeWriter.print(getName());
    paramClassTypeWriter.print("\", length:");
    paramClassTypeWriter.print(getLength());
    paramClassTypeWriter.print(", value: ");
    Object localObject;
    if (this.value_index == 0)
    {
      localObject = getValue(paramClassTypeWriter.ctype.constants);
      if ((localObject instanceof String))
        paramClassTypeWriter.printQuotedString((String)localObject);
    }
    while (true)
    {
      paramClassTypeWriter.println();
      return;
      paramClassTypeWriter.print(localObject);
      continue;
      paramClassTypeWriter.printOptionalIndex(this.value_index);
      paramClassTypeWriter.ctype.constants.getPoolEntry(this.value_index).print(paramClassTypeWriter, 1);
    }
  }

  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeShort(this.value_index);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ConstantValueAttr
 * JD-Core Version:    0.6.2
 */