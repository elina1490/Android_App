package gnu.kawa.lispexpr;

import gnu.lists.Pair;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderParens extends ReadTableEntry
{
  private static ReaderParens instance;
  char close;
  Object command;
  int kind;
  char open;

  public ReaderParens(char paramChar1, char paramChar2, int paramInt, Object paramObject)
  {
    this.open = paramChar1;
    this.close = paramChar2;
    this.kind = paramInt;
    this.command = paramObject;
  }

  public static ReaderParens getInstance(char paramChar1, char paramChar2)
  {
    return getInstance(paramChar1, paramChar2, 5);
  }

  public static ReaderParens getInstance(char paramChar1, char paramChar2, int paramInt)
  {
    if ((paramChar1 == '(') && (paramChar2 == ')') && (paramInt == 5))
    {
      if (instance == null)
        instance = new ReaderParens(paramChar1, paramChar2, paramInt, null);
      return instance;
    }
    return new ReaderParens(paramChar1, paramChar2, paramInt, null);
  }

  public static ReaderParens getInstance(char paramChar1, char paramChar2, int paramInt, Object paramObject)
  {
    if (paramObject == null)
      return getInstance(paramChar1, paramChar2, paramInt);
    return new ReaderParens(paramChar1, paramChar2, paramInt, paramObject);
  }

  public static Object readList(LispReader paramLispReader, int paramInt1, int paramInt2, int paramInt3)
    throws IOException, SyntaxException
  {
    LineBufferedReader localLineBufferedReader = paramLispReader.getPort();
    char c1;
    char c2;
    int i;
    int j;
    if (paramInt3 == 93)
    {
      c1 = '[';
      c2 = paramLispReader.pushNesting(c1);
      i = localLineBufferedReader.getLineNumber();
      j = localLineBufferedReader.getColumnNumber();
    }
    int k;
    int m;
    Object localObject3;
    Object localObject4;
    int n;
    int i1;
    Object localObject5;
    int i5;
    Object localObject6;
    label273: int i8;
    label300: int i6;
    label328: label344: Object localObject8;
    while (true)
    {
      ReadTable localReadTable;
      int i3;
      ReadTableEntry localReadTableEntry;
      try
      {
        Object localObject2 = paramLispReader.makeNil();
        localReadTable = ReadTable.getCurrent();
        k = 0;
        m = 0;
        localObject3 = localObject2;
        localObject4 = null;
        n = localLineBufferedReader.getLineNumber();
        i1 = localLineBufferedReader.getColumnNumber();
        int i2 = localLineBufferedReader.read();
        i3 = i2;
        if (i3 == paramInt3)
        {
          return localObject3;
          c1 = '(';
          break;
        }
        if (i3 < 0)
          paramLispReader.eofError("unexpected EOF in list starting here", i + 1, j);
        if (i3 != 46)
          break label328;
        i3 = localLineBufferedReader.peek();
        localReadTableEntry = localReadTable.lookup(i3);
        int i4 = localReadTableEntry.getKind();
        if ((i4 != 1) && (i4 != 5) && (i4 != 0))
          break label300;
        localLineBufferedReader.skip();
        i1++;
        if (i3 == paramInt3)
        {
          paramLispReader.error("unexpected '" + (char)paramInt3 + "' after '.'");
          continue;
        }
      }
      finally
      {
        paramLispReader.popNesting(c2);
      }
      if (i3 < 0)
        paramLispReader.eofError("unexpected EOF in list starting here", i + 1, j);
      if (m == 0)
        break label429;
      paramLispReader.error("multiple '.' in list");
      localObject5 = paramLispReader.makeNil();
      i5 = 0;
      localObject6 = null;
      break label441;
      Object localObject7;
      while (true)
      {
        localObject7 = paramLispReader.readValues(i3, localReadTableEntry, localReadTable);
        if (localObject7 != Values.empty)
          break label344;
        k = i8;
        break;
        i3 = 46;
        localReadTableEntry = ReadTableEntry.getConstituentInstance();
        localObject5 = localObject3;
        i6 = m;
        i5 = k;
        localObject6 = localObject4;
        break label444;
        localReadTableEntry = localReadTable.lookup(i3);
        i8 = k;
      }
      localObject8 = paramLispReader.handlePostfix(localObject7, localReadTable, n, i1);
      if (i8 == 0)
        break label467;
      paramLispReader.error("multiple values after '.'");
      localObject3 = paramLispReader.makeNil();
      k = 0;
      localObject4 = null;
    }
    while (true)
    {
      label384: Pair localPair = paramLispReader.makePair(localObject8, i9, i1);
      int i10 = i8;
      Object localObject9 = localPair;
      break label479;
      label407: paramLispReader.setCdr(localObject4, localObject9);
      Object localObject10 = localObject3;
      label429: label441: label444: label467: label479: 
      do
      {
        i9 = n;
        break label384;
        i5 = k;
        localObject5 = localObject3;
        localObject6 = localObject4;
        i6 = 1;
        localObject4 = localObject6;
        int i7 = i6;
        localObject3 = localObject5;
        i8 = i5;
        m = i7;
        break label273;
        if (m != 0)
        {
          localObject9 = localObject8;
          i10 = 1;
          if (localObject4 != null)
            break label407;
          localObject10 = localObject9;
          Object localObject11 = localObject9;
          k = i10;
          localObject3 = localObject10;
          localObject4 = localObject11;
          break;
        }
      }
      while (localObject4 != null);
      int i9 = i;
      i1 = j - 1;
    }
  }

  public int getKind()
  {
    return this.kind;
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    Object localObject = readList((LispReader)paramLexer, paramInt1, paramInt2, this.close);
    if (this.command != null)
    {
      LineBufferedReader localLineBufferedReader = paramLexer.getPort();
      int i = localLineBufferedReader.getLineNumber();
      int j = localLineBufferedReader.getColumnNumber();
      Pair localPair = ((LispReader)paramLexer).makePair(this.command, i, j);
      ((LispReader)paramLexer).setCdr(localPair, localObject);
      localObject = localPair;
    }
    return localObject;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderParens
 * JD-Core Version:    0.6.2
 */