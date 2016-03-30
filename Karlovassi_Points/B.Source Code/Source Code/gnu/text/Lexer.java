package gnu.text;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class Lexer extends Reader
{
  protected boolean interactive;
  SourceMessages messages = null;
  protected int nesting;
  protected LineBufferedReader port;
  private int saveTokenBufferLength = -1;
  public char[] tokenBuffer = new char[100];
  public int tokenBufferLength = 0;

  public Lexer(LineBufferedReader paramLineBufferedReader)
  {
    this.port = paramLineBufferedReader;
  }

  public Lexer(LineBufferedReader paramLineBufferedReader, SourceMessages paramSourceMessages)
  {
    this.port = paramLineBufferedReader;
    this.messages = paramSourceMessages;
  }

  public static long readDigitsInBuffer(LineBufferedReader paramLineBufferedReader, int paramInt)
  {
    long l1 = 0L;
    long l2 = 9223372036854775807L / paramInt;
    int i = paramLineBufferedReader.pos;
    int j = paramLineBufferedReader.limit;
    int k = 0;
    if (i >= j)
      return 0L;
    int m = Character.digit(paramLineBufferedReader.buffer[i], paramInt);
    if (m < 0)
    {
      label52: paramLineBufferedReader.pos = i;
      if (k != 0)
        return -1L;
    }
    else
    {
      if (l1 > l2)
        k = 1;
      while (true)
      {
        if (l1 < 0L)
          k = 1;
        i++;
        if (i < paramLineBufferedReader.limit)
          break;
        break label52;
        l1 = l1 * paramInt + m;
      }
    }
    return l1;
  }

  public boolean checkErrors(PrintWriter paramPrintWriter, int paramInt)
  {
    return (this.messages != null) && (this.messages.checkErrors(paramPrintWriter, paramInt));
  }

  public boolean checkNext(char paramChar)
    throws IOException
  {
    char c = this.port.read();
    if (c == paramChar)
      return true;
    if (c >= 0)
      this.port.unread_quick();
    return false;
  }

  public void clearErrors()
  {
    if (this.messages != null)
      this.messages.clearErrors();
  }

  public void close()
    throws IOException
  {
    this.port.close();
  }

  public void eofError(String paramString)
    throws SyntaxException
  {
    fatal(paramString);
  }

  public void eofError(String paramString, int paramInt1, int paramInt2)
    throws SyntaxException
  {
    error('f', this.port.getName(), paramInt1, paramInt2, paramString);
    throw new SyntaxException(this.messages);
  }

  public void error(char paramChar, String paramString)
  {
    int i = this.port.getLineNumber();
    int j = this.port.getColumnNumber();
    String str = this.port.getName();
    int k = i + 1;
    if (j >= 0);
    for (int m = j + 1; ; m = 0)
    {
      error(paramChar, str, k, m, paramString);
      return;
    }
  }

  public void error(char paramChar, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.messages == null)
      this.messages = new SourceMessages();
    this.messages.error(paramChar, paramString1, paramInt1, paramInt2, paramString2);
  }

  public void error(String paramString)
  {
    error('e', paramString);
  }

  public void fatal(String paramString)
    throws SyntaxException
  {
    error('f', paramString);
    throw new SyntaxException(this.messages);
  }

  public int getColumnNumber()
  {
    return this.port.getColumnNumber();
  }

  public SourceError getErrors()
  {
    if (this.messages == null)
      return null;
    return this.messages.getErrors();
  }

  public int getLineNumber()
  {
    return this.port.getLineNumber();
  }

  public SourceMessages getMessages()
  {
    return this.messages;
  }

  public String getName()
  {
    return this.port.getName();
  }

  public final LineBufferedReader getPort()
  {
    return this.port;
  }

  public boolean isInteractive()
  {
    return this.interactive;
  }

  public void mark()
    throws IOException
  {
    if (this.saveTokenBufferLength >= 0)
      throw new Error("internal error: recursive call to mark not allowed");
    this.port.mark(2147483647);
    this.saveTokenBufferLength = this.tokenBufferLength;
  }

  public int peek()
    throws IOException
  {
    return this.port.peek();
  }

  public void popNesting(char paramChar)
  {
    getPort().readState = paramChar;
    this.nesting -= 1;
  }

  public char pushNesting(char paramChar)
  {
    this.nesting = (1 + this.nesting);
    LineBufferedReader localLineBufferedReader = getPort();
    char c = localLineBufferedReader.readState;
    localLineBufferedReader.readState = paramChar;
    return c;
  }

  public int read()
    throws IOException
  {
    return this.port.read();
  }

  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.port.read(paramArrayOfChar, paramInt1, paramInt2);
  }

  public boolean readDelimited(String paramString)
    throws IOException, SyntaxException
  {
    this.tokenBufferLength = 0;
    int i = paramString.length();
    int j = paramString.charAt(i - 1);
    while (true)
    {
      int k = read();
      if (k < 0)
        return false;
      if (k == j)
      {
        int m = this.tokenBufferLength;
        int n = i - 1;
        int i1 = m - n;
        if (i1 >= 0)
          do
          {
            if (n == 0)
            {
              this.tokenBufferLength = i1;
              return true;
            }
            n--;
          }
          while (this.tokenBuffer[(i1 + n)] == paramString.charAt(n));
      }
      tokenBufferAppend((char)k);
    }
  }

  public int readOptionalExponent()
    throws IOException
  {
    int i = read();
    int j = 0;
    int k;
    if ((i == 43) || (i == 45))
      k = read();
    int m;
    while (true)
    {
      if (k >= 0)
      {
        m = Character.digit((char)k, 10);
        if (m >= 0)
          break;
      }
      if (i != 0)
        error("exponent sign not followed by digit");
      m = 1;
      if (k >= 0)
        unread(k);
      if (i == 45)
        m = -m;
      if (j == 0)
        break label139;
      if (i != 45)
        break label136;
      return -2147483648;
      k = i;
      i = 0;
    }
    while (true)
    {
      k = read();
      int n = Character.digit((char)k, 10);
      if (n < 0)
        break;
      if (m > 214748363)
        j = 1;
      m = n + m * 10;
    }
    label136: return 2147483647;
    label139: return m;
  }

  public int readUnicodeChar()
    throws IOException
  {
    int i = this.port.read();
    if ((i >= 55296) && (i < 56319))
    {
      int j = this.port.read();
      if ((j >= 56320) && (j <= 57343))
        i = 65536 + ((i - 55296 << 10) + (i - 56320));
    }
    return i;
  }

  public void reset()
    throws IOException
  {
    if (this.saveTokenBufferLength < 0)
      throw new Error("internal error: reset called without prior mark");
    this.port.reset();
    this.saveTokenBufferLength = -1;
  }

  public boolean seenErrors()
  {
    return (this.messages != null) && (this.messages.seenErrors());
  }

  public void setInteractive(boolean paramBoolean)
  {
    this.interactive = paramBoolean;
  }

  public void setMessages(SourceMessages paramSourceMessages)
  {
    this.messages = paramSourceMessages;
  }

  public void skip()
    throws IOException
  {
    this.port.skip();
  }

  protected void skip_quick()
    throws IOException
  {
    this.port.skip_quick();
  }

  public void tokenBufferAppend(int paramInt)
  {
    if (paramInt >= 65536)
    {
      tokenBufferAppend(55296 + (paramInt - 65536 >> 10));
      paramInt = 56320 + (paramInt & 0x3FF);
    }
    int i = this.tokenBufferLength;
    char[] arrayOfChar = this.tokenBuffer;
    if (i == this.tokenBuffer.length)
    {
      this.tokenBuffer = new char[i * 2];
      System.arraycopy(arrayOfChar, 0, this.tokenBuffer, 0, i);
      arrayOfChar = this.tokenBuffer;
    }
    arrayOfChar[i] = ((char)paramInt);
    this.tokenBufferLength = (i + 1);
  }

  public String tokenBufferString()
  {
    return new String(this.tokenBuffer, 0, this.tokenBufferLength);
  }

  protected void unread()
    throws IOException
  {
    this.port.unread();
  }

  public void unread(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
      this.port.unread();
  }

  protected void unread_quick()
    throws IOException
  {
    this.port.unread_quick();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.Lexer
 * JD-Core Version:    0.6.2
 */