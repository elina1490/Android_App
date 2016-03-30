package gnu.q2.lang;

import gnu.kawa.lispexpr.ReaderDispatchMisc;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

class Q2ReaderParens extends ReaderDispatchMisc
{
  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    Q2Read localQ2Read = (Q2Read)paramLexer;
    char c = localQ2Read.pushNesting('(');
    try
    {
      Object localObject2 = localQ2Read.readCommand(true);
      if (localQ2Read.getPort().read() != 41)
        localQ2Read.error("missing ')'");
      return localObject2;
    }
    finally
    {
      localQ2Read.popNesting(c);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.q2.lang.Q2ReaderParens
 * JD-Core Version:    0.6.2
 */