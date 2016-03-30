package gnu.mapping;

import gnu.lists.CharSeq;
import gnu.lists.FString;
import gnu.text.NullReader;
import gnu.text.Path;
import java.io.IOException;

public class CharArrayInPort extends InPort
{
  static final Path stringPath = Path.valueOf("<string>");

  public CharArrayInPort(String paramString)
  {
    this(paramString.toCharArray());
  }

  public CharArrayInPort(char[] paramArrayOfChar)
  {
    this(paramArrayOfChar, paramArrayOfChar.length);
  }

  public CharArrayInPort(char[] paramArrayOfChar, int paramInt)
  {
    super(NullReader.nullReader, stringPath);
    try
    {
      setBuffer(paramArrayOfChar);
      this.limit = paramInt;
      return;
    }
    catch (IOException localIOException)
    {
      throw new Error(localIOException.toString());
    }
  }

  public CharArrayInPort make(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof FString))
    {
      FString localFString = (FString)paramCharSequence;
      return new CharArrayInPort(localFString.data, localFString.size);
    }
    int i = paramCharSequence.length();
    char[] arrayOfChar = new char[i];
    if ((paramCharSequence instanceof String))
      ((String)paramCharSequence).getChars(0, i, arrayOfChar, 0);
    while (true)
    {
      return new CharArrayInPort(arrayOfChar, i);
      if (!(paramCharSequence instanceof CharSeq))
      {
        int j = i;
        while (true)
        {
          j--;
          if (j < 0)
            break;
          arrayOfChar[j] = paramCharSequence.charAt(j);
        }
      }
      else
      {
        ((CharSeq)paramCharSequence).getChars(0, i, arrayOfChar, 0);
      }
    }
  }

  public int read()
    throws IOException
  {
    if (this.pos >= this.limit)
      return -1;
    return super.read();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.CharArrayInPort
 * JD-Core Version:    0.6.2
 */