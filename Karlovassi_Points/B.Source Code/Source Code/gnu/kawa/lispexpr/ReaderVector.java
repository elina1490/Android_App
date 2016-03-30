package gnu.kawa.lispexpr;

import gnu.expr.QuoteExp;
import gnu.lists.FVector;
import gnu.mapping.InPort;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.Vector;

public class ReaderVector extends ReadTableEntry
{
  char close;

  public ReaderVector(char paramChar)
  {
    this.close = paramChar;
  }

  public static FVector readVector(LispReader paramLispReader, LineBufferedReader paramLineBufferedReader, int paramInt, char paramChar)
    throws IOException, SyntaxException
  {
    char c1 = ' ';
    InPort localInPort;
    char c3;
    if ((paramLineBufferedReader instanceof InPort))
    {
      c1 = ((InPort)paramLineBufferedReader).readState;
      localInPort = (InPort)paramLineBufferedReader;
      if (paramChar != ']')
        break label127;
      c3 = '[';
    }
    while (true)
    {
      localInPort.readState = c3;
      try
      {
        Vector localVector = new Vector();
        ReadTable localReadTable = ReadTable.getCurrent();
        while (true)
        {
          char c2 = paramLispReader.read();
          if (c2 < 0)
            paramLispReader.eofError("unexpected EOF in vector");
          if (c2 == paramChar)
          {
            Object[] arrayOfObject1 = new Object[localVector.size()];
            localVector.copyInto(arrayOfObject1);
            FVector localFVector = new FVector(arrayOfObject1);
            return localFVector;
            label127: c3 = '(';
            break;
          }
          Object localObject2 = paramLispReader.readValues(c2, localReadTable);
          if ((localObject2 instanceof Values))
          {
            Object[] arrayOfObject2 = ((Values)localObject2).getValues();
            int i = arrayOfObject2.length;
            for (int j = 0; j < i; j++)
              localVector.addElement(arrayOfObject2[j]);
          }
          else
          {
            if (localObject2 == QuoteExp.voidExp)
              localObject2 = Values.empty;
            localVector.addElement(localObject2);
          }
        }
      }
      finally
      {
        if ((paramLineBufferedReader instanceof InPort))
          ((InPort)paramLineBufferedReader).readState = c1;
      }
    }
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    return readVector((LispReader)paramLexer, paramLexer.getPort(), paramInt2, this.close);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderVector
 * JD-Core Version:    0.6.2
 */