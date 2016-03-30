package gnu.kawa.xml;

public class Base64Binary extends BinaryObject
{
  public static final String ENCODING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

  public Base64Binary(String paramString)
  {
    int i = paramString.length();
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      char c2 = paramString.charAt(k);
      if ((!Character.isWhitespace(c2)) && (c2 != '='))
        j++;
    }
    byte[] arrayOfByte = new byte[j * 3 / 4];
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    char c1;
    int i5;
    label111: int i6;
    if (i2 < i)
    {
      c1 = paramString.charAt(i2);
      if ((c1 >= 'A') && (c1 <= 'Z'))
        i5 = c1 - 'A';
      while (true)
        if ((i5 < 0) || (i1 > 0))
        {
          throw new IllegalArgumentException("illegal character in base64Binary string at position " + i2);
          if ((c1 >= 'a') && (c1 <= 'z'))
            i5 = 26 + (c1 - 'a');
          else if ((c1 >= '0') && (c1 <= '9'))
            i5 = 52 + (c1 - '0');
          else if (c1 == '+')
            i5 = 62;
          else if (c1 == '/')
            i5 = 63;
          else if (Character.isWhitespace(c1))
            i6 = i3;
        }
    }
    while (true)
    {
      i2++;
      i3 = i6;
      break;
      if (c1 == '=')
      {
        i1++;
        i6 = i3;
      }
      else
      {
        i5 = -1;
        break label111;
        m = i5 + (m << 6);
        n++;
        if (n == 4)
        {
          int i7 = i3 + 1;
          arrayOfByte[i3] = ((byte)(m >> 16));
          int i8 = i7 + 1;
          arrayOfByte[i7] = ((byte)(m >> 8));
          i6 = i8 + 1;
          arrayOfByte[i8] = ((byte)m);
          n = 0;
          continue;
          if (n + i1 > 0)
          {
            if ((n + i1 == 4) && ((m & (1 << i1) - 1) == 0) && (i3 + 3 - i1 == arrayOfByte.length));
          }
          else
            while (i3 != arrayOfByte.length)
              throw new IllegalArgumentException();
          switch (i1)
          {
          default:
          case 1:
          case 2:
          }
          while (true)
          {
            this.data = arrayOfByte;
            return;
            int i4 = i3 + 1;
            arrayOfByte[i3] = ((byte)(m << 10));
            (i4 + 1);
            arrayOfByte[i4] = ((byte)(m >> 2));
            continue;
            (i3 + 1);
            arrayOfByte[i3] = ((byte)(m >> 4));
          }
        }
        else
        {
          i6 = i3;
        }
      }
    }
  }

  public Base64Binary(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }

  public static Base64Binary valueOf(String paramString)
  {
    return new Base64Binary(paramString);
  }

  public String toString()
  {
    return toString(new StringBuffer()).toString();
  }

  public StringBuffer toString(StringBuffer paramStringBuffer)
  {
    byte[] arrayOfByte = this.data;
    int i = arrayOfByte.length;
    int j = 0;
    int k = 0;
    while (k < i)
    {
      int m = arrayOfByte[k];
      j = j << 8 | m & 0xFF;
      k++;
      if (k % 3 == 0)
      {
        paramStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(0x3F & j >> 18));
        paramStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(0x3F & j >> 12));
        paramStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(0x3F & j >> 6));
        paramStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(j & 0x3F));
      }
    }
    switch (i % 3)
    {
    default:
      return paramStringBuffer;
    case 1:
      paramStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(0x3F & j >> 2));
      paramStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(0x3F & j << 4));
      paramStringBuffer.append("==");
      return paramStringBuffer;
    case 2:
    }
    paramStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(0x3F & j >> 10));
    paramStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(0x3F & j >> 4));
    paramStringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(0x3F & j << 2));
    paramStringBuffer.append('=');
    return paramStringBuffer;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.Base64Binary
 * JD-Core Version:    0.6.2
 */