package gnu.kawa.lispexpr;

import gnu.lists.Sequence;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderIgnoreRestOfLine extends ReadTableEntry
{
  static ReaderIgnoreRestOfLine instance = new ReaderIgnoreRestOfLine();

  public static ReaderIgnoreRestOfLine getInstance()
  {
    return instance;
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    int i;
    do
    {
      i = paramLexer.read();
      if (i < 0)
        return Sequence.eofValue;
    }
    while ((i != 10) && (i != 13));
    return Values.empty;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderIgnoreRestOfLine
 * JD-Core Version:    0.6.2
 */