package gnu.kawa.lispexpr;

import gnu.mapping.InPort;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderString extends ReadTableEntry
{
  public static String readString(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    int i = paramLexer.tokenBufferLength;
    LineBufferedReader localLineBufferedReader = paramLexer.getPort();
    int j = paramInt1;
    boolean bool = localLineBufferedReader instanceof InPort;
    char c = '\000';
    if (bool)
    {
      c = ((InPort)localLineBufferedReader).readState;
      ((InPort)localLineBufferedReader).readState = ((char)paramInt1);
    }
    while (true)
    {
      int k = j;
      if (k == 13);
      label335: 
      do
      {
        try
        {
          j = localLineBufferedReader.read();
          if (j == 10)
            break;
          while (j == paramInt1)
          {
            String str = new String(paramLexer.tokenBuffer, i, paramLexer.tokenBufferLength - i).intern();
            return str;
            if ((localLineBufferedReader.pos < localLineBufferedReader.limit) && (k != 10))
            {
              char[] arrayOfChar = localLineBufferedReader.buffer;
              int m = localLineBufferedReader.pos;
              localLineBufferedReader.pos = (m + 1);
              j = arrayOfChar[m];
            }
            else
            {
              j = localLineBufferedReader.read();
            }
          }
          if (j < 0)
            paramLexer.eofError("unexpected EOF in string literal");
          paramLexer.tokenBufferAppend(j);
          break;
        }
        finally
        {
          paramLexer.tokenBufferLength = i;
          if ((localLineBufferedReader instanceof InPort))
            ((InPort)localLineBufferedReader).readState = c;
        }
        int i1;
        if (localLineBufferedReader.getConvertCR())
          i1 = 10;
        while (true)
        {
          paramLexer.tokenBufferAppend(i1);
          break;
          if ((paramLexer instanceof LispReader))
          {
            j = ((LispReader)paramLexer).readEscape();
            break label335;
          }
          int n = localLineBufferedReader.read();
          j = n;
          break label335;
          switch (j)
          {
          default:
          case 13:
          case 92:
          }
          i1 = 13;
          j = 32;
        }
      }
      while (j != -2);
      j = 10;
    }
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    return readString(paramLexer, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderString
 * JD-Core Version:    0.6.2
 */