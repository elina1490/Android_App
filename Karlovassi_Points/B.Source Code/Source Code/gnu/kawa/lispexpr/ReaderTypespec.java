package gnu.kawa.lispexpr;

import gnu.mapping.InPort;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderTypespec extends ReadTableEntry
{
  public int getKind()
  {
    return 6;
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    int i = paramLexer.tokenBufferLength;
    LineBufferedReader localLineBufferedReader = paramLexer.getPort();
    ReadTable localReadTable = ReadTable.getCurrent();
    paramLexer.tokenBufferAppend(paramInt1);
    int j = paramInt1;
    boolean bool = localLineBufferedReader instanceof InPort;
    char c = '\000';
    if (bool)
    {
      c = ((InPort)localLineBufferedReader).readState;
      ((InPort)localLineBufferedReader).readState = ((char)paramInt1);
    }
    int k = 0;
    int m = j;
    while (true)
    {
      try
      {
        if ((localLineBufferedReader.pos < localLineBufferedReader.limit) && (m != 10))
        {
          char[] arrayOfChar = localLineBufferedReader.buffer;
          int n = localLineBufferedReader.pos;
          localLineBufferedReader.pos = (n + 1);
          j = arrayOfChar[n];
          if (j != 92)
            break label273;
          if (!(paramLexer instanceof LispReader))
            continue;
          j = ((LispReader)paramLexer).readEscape();
          break;
        }
        j = localLineBufferedReader.read();
        continue;
        j = localLineBufferedReader.read();
        break;
        if (localReadTable.lookup(j).getKind() == 2)
        {
          paramLexer.tokenBufferAppend(j);
          break;
        }
      }
      finally
      {
        paramLexer.tokenBufferLength = i;
        if ((localLineBufferedReader instanceof InPort))
          ((InPort)localLineBufferedReader).readState = c;
      }
      paramLexer.unread(j);
      String str = new String(paramLexer.tokenBuffer, i, paramLexer.tokenBufferLength - i).intern();
      paramLexer.tokenBufferLength = i;
      if ((localLineBufferedReader instanceof InPort))
        ((InPort)localLineBufferedReader).readState = c;
      return str;
      label273: if ((k == 0) && (j == 91))
      {
        k = 1;
        if (1 == k);
      }
      else if ((k != 0) && (j == 93))
      {
        k = 0;
        if (0 != 0)
          k = 0;
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderTypespec
 * JD-Core Version:    0.6.2
 */