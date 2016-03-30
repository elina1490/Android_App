package gnu.kawa.xml;

public class HexBinary extends BinaryObject
{
  public HexBinary(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }

  static char forHexDigit(int paramInt)
  {
    if (paramInt < 10)
      return (char)(paramInt + 48);
    return (char)(65 + (paramInt - 10));
  }

  static byte[] parseHexBinary(String paramString)
  {
    String str = paramString.trim();
    int i = str.length();
    if ((i & 0x1) != 0)
      throw new IllegalArgumentException("hexBinary string length not a multiple of 2");
    int j = i >> 1;
    byte[] arrayOfByte = new byte[j];
    for (int k = 0; k < j; k++)
    {
      int m = Character.digit(str.charAt(k * 2), 16);
      int n = Character.digit(str.charAt(1 + k * 2), 16);
      int i1 = -1;
      if (m < 0)
        i1 = k * 2;
      while (i1 >= 0)
      {
        throw new IllegalArgumentException("invalid hexBinary character at position " + i1);
        if (n < 0)
          i1 = 1 + k * 2;
      }
      arrayOfByte[k] = ((byte)(n + m * 16));
    }
    return arrayOfByte;
  }

  static HexBinary valueOf(String paramString)
  {
    return new HexBinary(parseHexBinary(paramString));
  }

  public String toString()
  {
    return toString(new StringBuffer()).toString();
  }

  public StringBuffer toString(StringBuffer paramStringBuffer)
  {
    for (int k : this.data)
    {
      paramStringBuffer.append(forHexDigit(0xF & k >> 4));
      paramStringBuffer.append(forHexDigit(k & 0xF));
    }
    return paramStringBuffer;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.HexBinary
 * JD-Core Version:    0.6.2
 */