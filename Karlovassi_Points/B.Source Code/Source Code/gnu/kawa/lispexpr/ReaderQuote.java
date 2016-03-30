package gnu.kawa.lispexpr;

import gnu.lists.PairWithPosition;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderQuote extends ReadTableEntry
{
  Object magicSymbol;
  Object magicSymbol2;
  char next;

  public ReaderQuote(Object paramObject)
  {
    this.magicSymbol = paramObject;
  }

  public ReaderQuote(Object paramObject1, char paramChar, Object paramObject2)
  {
    this.next = paramChar;
    this.magicSymbol = paramObject1;
    this.magicSymbol2 = paramObject2;
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    LispReader localLispReader = (LispReader)paramLexer;
    String str = localLispReader.getName();
    int i = 1 + localLispReader.getLineNumber();
    int j = 1 + localLispReader.getColumnNumber();
    Object localObject = this.magicSymbol;
    int n;
    if (this.next != 0)
    {
      n = localLispReader.read();
      if (n != this.next)
        break label115;
      localObject = this.magicSymbol2;
    }
    while (true)
    {
      int k = 1 + localLispReader.getLineNumber();
      int m = 1 + localLispReader.getColumnNumber();
      return PairWithPosition.make(localObject, PairWithPosition.make(localLispReader.readObject(), localLispReader.makeNil(), str, k, m), str, i, j);
      label115: if (n >= 0)
        localLispReader.unread(n);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderQuote
 * JD-Core Version:    0.6.2
 */