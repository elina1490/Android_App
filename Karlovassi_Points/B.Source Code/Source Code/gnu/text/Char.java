package gnu.text;

import gnu.lists.Consumer;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class Char
  implements Comparable, Externalizable
{
  static Char[] ascii;
  static char[] charNameValues = { 32, 9, 10, 10, 13, 12, 8, 27, 127, 127, 127, 7, 7, 11, 0 };
  static String[] charNames = { "space", "tab", "newline", "linefeed", "return", "page", "backspace", "esc", "delete", "del", "rubout", "alarm", "bel", "vtab", "nul" };
  static CharMap hashTable = new CharMap();
  int value;

  static
  {
    ascii = new Char[''];
    int i = 128;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      ascii[i] = new Char(i);
    }
  }

  public Char()
  {
  }

  Char(int paramInt)
  {
    this.value = paramInt;
  }

  public static Char make(int paramInt)
  {
    if (paramInt < 128)
      return ascii[paramInt];
    synchronized (hashTable)
    {
      Char localChar = hashTable.get(paramInt);
      return localChar;
    }
  }

  public static int nameToChar(String paramString)
  {
    int i = charNames.length;
    do
    {
      i--;
      if (i < 0)
        break;
    }
    while (!charNames[i].equals(paramString));
    return charNameValues[i];
    int j = charNames.length;
    do
    {
      j--;
      if (j < 0)
        break;
    }
    while (!charNames[j].equalsIgnoreCase(paramString));
    return charNameValues[j];
    int k = paramString.length();
    int n;
    if ((k > 1) && (paramString.charAt(0) == 'u'))
      n = 0;
    for (int i1 = 1; ; i1++)
    {
      if (i1 == k)
        return n;
      int i2 = Character.digit(paramString.charAt(i1), 16);
      if (i2 < 0)
      {
        if ((k != 3) || (paramString.charAt(1) != '-'))
          break;
        int m = paramString.charAt(0);
        if ((m != 99) && (m != 67))
          break;
        return 0x1F & paramString.charAt(2);
      }
      n = i2 + (n << 4);
    }
    return -1;
  }

  public static void print(int paramInt, Consumer paramConsumer)
  {
    if (paramInt >= 65536)
    {
      paramConsumer.write((char)(55296 + (paramInt - 65536 >> 10)));
      paramConsumer.write((char)(56320 + (paramInt & 0x3FF)));
      return;
    }
    paramConsumer.write((char)paramInt);
  }

  public static String toScmReadableString(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(20);
    localStringBuffer.append("#\\");
    for (int i = 0; i < charNameValues.length; i++)
      if ((char)paramInt == charNameValues[i])
      {
        localStringBuffer.append(charNames[i]);
        return localStringBuffer.toString();
      }
    if ((paramInt < 32) || (paramInt > 127))
    {
      localStringBuffer.append('x');
      localStringBuffer.append(Integer.toString(paramInt, 16));
    }
    while (true)
    {
      return localStringBuffer.toString();
      localStringBuffer.append((char)paramInt);
    }
  }

  public final char charValue()
  {
    return (char)this.value;
  }

  public int compareTo(Object paramObject)
  {
    return this.value - ((Char)paramObject).value;
  }

  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof Char)) && (((Char)paramObject).intValue() == this.value);
  }

  public int hashCode()
  {
    return this.value;
  }

  public final int intValue()
  {
    return this.value;
  }

  public void print(Consumer paramConsumer)
  {
    print(this.value, paramConsumer);
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.value = paramObjectInput.readChar();
    if ((this.value >= 55296) && (this.value < 56319))
    {
      int i = paramObjectInput.readChar();
      if ((i >= 56320) && (i <= 57343))
        this.value = (65536 + ((this.value - 55296 << 10) + (i - 56320)));
    }
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    return make(this.value);
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('\'');
    if ((this.value >= 32) && (this.value < 127) && (this.value != 39))
      localStringBuffer.append((char)this.value);
    while (true)
    {
      localStringBuffer.append('\'');
      return localStringBuffer.toString();
      localStringBuffer.append('\\');
      if (this.value == 39)
      {
        localStringBuffer.append('\'');
      }
      else if (this.value == 10)
      {
        localStringBuffer.append('n');
      }
      else if (this.value == 13)
      {
        localStringBuffer.append('r');
      }
      else if (this.value == 9)
      {
        localStringBuffer.append('t');
      }
      else if (this.value < 256)
      {
        String str2 = Integer.toOctalString(this.value);
        int j = 3 - str2.length();
        while (true)
        {
          j--;
          if (j < 0)
            break;
          localStringBuffer.append('0');
        }
        localStringBuffer.append(str2);
      }
      else
      {
        localStringBuffer.append('u');
        String str1 = Integer.toHexString(this.value);
        int i = 4 - str1.length();
        while (true)
        {
          i--;
          if (i < 0)
            break;
          localStringBuffer.append('0');
        }
        localStringBuffer.append(str1);
      }
    }
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    if (this.value > 55296)
    {
      if (this.value <= 65535)
        break label63;
      paramObjectOutput.writeChar(55296 + (this.value - 65536 >> 10));
      this.value = (56320 + (0x3FF & this.value));
    }
    while (true)
    {
      paramObjectOutput.writeChar(this.value);
      return;
      label63: if (this.value <= 56319)
      {
        paramObjectOutput.writeChar(this.value);
        this.value = 0;
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.Char
 * JD-Core Version:    0.6.2
 */