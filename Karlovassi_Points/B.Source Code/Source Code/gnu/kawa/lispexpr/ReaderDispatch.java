package gnu.kawa.lispexpr;

import gnu.kawa.util.RangeTable;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderDispatch extends ReadTableEntry
{
  int kind;
  RangeTable table = new RangeTable();

  public ReaderDispatch()
  {
    this.kind = 5;
  }

  public ReaderDispatch(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 6; ; i = 5)
    {
      this.kind = i;
      return;
    }
  }

  public static ReaderDispatch create(ReadTable paramReadTable)
  {
    ReaderDispatch localReaderDispatch = new ReaderDispatch();
    ReaderDispatchMisc localReaderDispatchMisc = ReaderDispatchMisc.getInstance();
    localReaderDispatch.set(58, localReaderDispatchMisc);
    localReaderDispatch.set(66, localReaderDispatchMisc);
    localReaderDispatch.set(68, localReaderDispatchMisc);
    localReaderDispatch.set(69, localReaderDispatchMisc);
    localReaderDispatch.set(70, localReaderDispatchMisc);
    localReaderDispatch.set(73, localReaderDispatchMisc);
    localReaderDispatch.set(79, localReaderDispatchMisc);
    localReaderDispatch.set(82, localReaderDispatchMisc);
    localReaderDispatch.set(83, localReaderDispatchMisc);
    localReaderDispatch.set(84, localReaderDispatchMisc);
    localReaderDispatch.set(85, localReaderDispatchMisc);
    localReaderDispatch.set(88, localReaderDispatchMisc);
    localReaderDispatch.set(124, localReaderDispatchMisc);
    localReaderDispatch.set(59, localReaderDispatchMisc);
    localReaderDispatch.set(33, localReaderDispatchMisc);
    localReaderDispatch.set(92, localReaderDispatchMisc);
    localReaderDispatch.set(61, localReaderDispatchMisc);
    localReaderDispatch.set(35, localReaderDispatchMisc);
    localReaderDispatch.set(47, localReaderDispatchMisc);
    localReaderDispatch.set(39, new ReaderQuote(paramReadTable.makeSymbol("function")));
    localReaderDispatch.set(40, new ReaderVector(')'));
    localReaderDispatch.set(60, new ReaderXmlElement());
    return localReaderDispatch;
  }

  public int getKind()
  {
    return this.kind;
  }

  public ReadTableEntry lookup(int paramInt)
  {
    return (ReadTableEntry)this.table.lookup(paramInt, null);
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    int i = -1;
    int j = paramLexer.read();
    if (j < 0)
      paramLexer.eofError("unexpected EOF after " + (char)j);
    if (j > 65536);
    ReadTableEntry localReadTableEntry;
    int k;
    while (true)
    {
      localReadTableEntry = (ReadTableEntry)this.table.lookup(j, null);
      if (localReadTableEntry != null)
        break label167;
      paramLexer.error('e', paramLexer.getName(), 1 + paramLexer.getLineNumber(), paramLexer.getColumnNumber(), "invalid dispatch character '" + (char)j + '\'');
      return Values.empty;
      k = Character.digit((char)j, 10);
      if (k >= 0)
        break;
      j = Character.toUpperCase((char)j);
    }
    if (i < 0);
    for (i = k; ; i = k + i * 10)
      break;
    label167: return localReadTableEntry.read(paramLexer, j, i);
  }

  public void set(int paramInt, Object paramObject)
  {
    this.table.set(paramInt, paramInt, paramObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderDispatch
 * JD-Core Version:    0.6.2
 */