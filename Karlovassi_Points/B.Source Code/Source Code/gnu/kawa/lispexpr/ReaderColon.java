package gnu.kawa.lispexpr;

import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderColon extends ReadTableEntry
{
  public int getKind()
  {
    return 6;
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    LispReader localLispReader = (LispReader)paramLexer;
    ReadTable localReadTable = ReadTable.getCurrent();
    int i = localLispReader.tokenBufferLength;
    if (paramInt1 == localReadTable.postfixLookupOperator)
    {
      int j = localLispReader.read();
      if (j == 58)
        return localReadTable.makeSymbol("::");
      localLispReader.tokenBufferAppend(paramInt1);
      paramInt1 = j;
    }
    return localLispReader.readAndHandleToken(paramInt1, i, localReadTable);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderColon
 * JD-Core Version:    0.6.2
 */