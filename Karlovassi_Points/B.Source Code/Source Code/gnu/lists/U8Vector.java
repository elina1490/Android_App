package gnu.lists;

public class U8Vector extends ByteVector
{
  public U8Vector()
  {
    this.data = ByteVector.empty;
  }

  public U8Vector(int paramInt)
  {
    this.data = new byte[paramInt];
    this.size = paramInt;
  }

  public U8Vector(int paramInt, byte paramByte)
  {
    byte[] arrayOfByte = new byte[paramInt];
    this.data = arrayOfByte;
    this.size = paramInt;
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      arrayOfByte[paramInt] = paramByte;
    }
  }

  public U8Vector(Sequence paramSequence)
  {
    this.data = new byte[paramSequence.size()];
    addAll(paramSequence);
  }

  public U8Vector(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    this.size = paramArrayOfByte.length;
  }

  public int compareTo(Object paramObject)
  {
    return compareToInt(this, (U8Vector)paramObject);
  }

  public final Object get(int paramInt)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException();
    return Convert.toObjectUnsigned(this.data[paramInt]);
  }

  public final Object getBuffer(int paramInt)
  {
    return Convert.toObjectUnsigned(this.data[paramInt]);
  }

  public int getElementKind()
  {
    return 17;
  }

  public String getTag()
  {
    return "u8";
  }

  public final int intAtBuffer(int paramInt)
  {
    return 0xFF & this.data[paramInt];
  }

  public Object setBuffer(int paramInt, Object paramObject)
  {
    byte b = this.data[paramInt];
    this.data[paramInt] = Convert.toByteUnsigned(paramObject);
    return Convert.toObjectUnsigned(b);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.U8Vector
 * JD-Core Version:    0.6.2
 */