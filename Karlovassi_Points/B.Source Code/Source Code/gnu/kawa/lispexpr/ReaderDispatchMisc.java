package gnu.kawa.lispexpr;

import gnu.bytecode.Type;
import gnu.expr.Keyword;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.util.GeneralHashTable;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.regex.Pattern;

public class ReaderDispatchMisc extends ReadTableEntry
{
  private static ReaderDispatchMisc instance = new ReaderDispatchMisc();
  protected int code;

  public ReaderDispatchMisc()
  {
    this.code = -1;
  }

  public ReaderDispatchMisc(int paramInt)
  {
    this.code = paramInt;
  }

  public static ReaderDispatchMisc getInstance()
  {
    return instance;
  }

  public static Pattern readRegex(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    int i = paramLexer.tokenBufferLength;
    LineBufferedReader localLineBufferedReader = paramLexer.getPort();
    int j = 0;
    boolean bool = localLineBufferedReader instanceof InPort;
    char c = '\000';
    if (bool)
    {
      c = ((InPort)localLineBufferedReader).readState;
      ((InPort)localLineBufferedReader).readState = '/';
    }
    while (true)
    {
      int k;
      String str;
      int m;
      try
      {
        k = localLineBufferedReader.read();
        if (k < 0)
          paramLexer.eofError("unexpected EOF in regex literal");
        if (k == paramInt1)
        {
          str = new String(paramLexer.tokenBuffer, i, paramLexer.tokenBufferLength - i);
          m = paramLexer.peek();
          if (m == 105)
            break label326;
          if (m != 73)
            break label336;
          break label326;
          paramLexer.skip();
          continue;
        }
      }
      finally
      {
        paramLexer.tokenBufferLength = i;
        if ((localLineBufferedReader instanceof InPort))
          ((InPort)localLineBufferedReader).readState = c;
      }
      if (k == 92)
      {
        k = localLineBufferedReader.read();
        if (((k == 32) || (k == 9) || (k == 13) || (k == 10)) && ((paramLexer instanceof LispReader)))
        {
          k = ((LispReader)paramLexer).readEscape(k);
          if (k == -2);
        }
        else
        {
          if (k < 0)
            paramLexer.eofError("unexpected EOF in regex literal");
          if (k != paramInt1)
            paramLexer.tokenBufferAppend(92);
        }
      }
      else
      {
        paramLexer.tokenBufferAppend(k);
        continue;
        label326: label336: 
        do
        {
          if (Character.isLetter(m))
          {
            paramLexer.error("unrecognized regex option '" + (char)m + '\'');
            break;
          }
          Pattern localPattern = Pattern.compile(str, j);
          paramLexer.tokenBufferLength = i;
          if ((localLineBufferedReader instanceof InPort))
            ((InPort)localLineBufferedReader).readState = c;
          return localPattern;
          j |= 66;
          break;
          if ((m == 115) || (m == 83))
          {
            j |= 32;
            break;
          }
        }
        while ((m != 109) && (m != 77));
        j |= 8;
      }
    }
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    LispReader localLispReader1 = (LispReader)paramLexer;
    if (this.code >= 0)
      paramInt1 = this.code;
    switch (paramInt1)
    {
    default:
      paramLexer.error("An invalid #-construct was read.");
      return Values.empty;
    case 58:
      int n = localLispReader1.tokenBufferLength;
      localLispReader1.readToken(localLispReader1.read(), 'P', ReadTable.getCurrent());
      int i1 = localLispReader1.tokenBufferLength - n;
      String str2 = new String(localLispReader1.tokenBuffer, n, i1);
      localLispReader1.tokenBufferLength = n;
      return Keyword.make(str2.intern());
    case 92:
      return LispReader.readCharacter(localLispReader1);
    case 33:
      return LispReader.readSpecial(localLispReader1);
    case 84:
      return Boolean.TRUE;
    case 70:
      if (Character.isDigit((char)paramLexer.peek()))
        return LispReader.readSimpleVector(localLispReader1, 'F');
      return Boolean.FALSE;
    case 83:
    case 85:
      return LispReader.readSimpleVector(localLispReader1, (char)paramInt1);
    case 82:
      if (paramInt2 > 36)
      {
        paramLexer.error("the radix " + paramInt2 + " is too big (max is 36)");
        paramInt2 = 36;
      }
      return LispReader.readNumberWithRadix(0, localLispReader1, paramInt2);
    case 88:
      return LispReader.readNumberWithRadix(0, localLispReader1, 16);
    case 68:
      return LispReader.readNumberWithRadix(0, localLispReader1, 10);
    case 79:
      return LispReader.readNumberWithRadix(0, localLispReader1, 8);
    case 66:
      return LispReader.readNumberWithRadix(0, localLispReader1, 2);
    case 69:
    case 73:
      localLispReader1.tokenBufferAppend(35);
      localLispReader1.tokenBufferAppend(paramInt1);
      return LispReader.readNumberWithRadix(2, localLispReader1, 0);
    case 47:
      return readRegex(paramLexer, paramInt1, paramInt2);
    case 124:
      LineBufferedReader localLineBufferedReader2 = localLispReader1.getPort();
      boolean bool2 = localLineBufferedReader2 instanceof InPort;
      char c2 = '\000';
      if (bool2)
      {
        c2 = ((InPort)localLineBufferedReader2).readState;
        ((InPort)localLineBufferedReader2).readState = '|';
      }
      try
      {
        localLispReader1.readNestedComment('#', '|');
        return Values.empty;
      }
      finally
      {
        if ((localLineBufferedReader2 instanceof InPort))
          ((InPort)localLineBufferedReader2).readState = c2;
      }
    case 59:
      LineBufferedReader localLineBufferedReader1 = localLispReader1.getPort();
      boolean bool1 = localLineBufferedReader1 instanceof InPort;
      char c1 = '\000';
      if (bool1)
      {
        c1 = ((InPort)localLineBufferedReader1).readState;
        ((InPort)localLineBufferedReader1).readState = ';';
      }
      try
      {
        localLispReader1.readObject();
        return Values.empty;
      }
      finally
      {
        if ((localLineBufferedReader1 instanceof InPort))
          ((InPort)localLineBufferedReader1).readState = c1;
      }
    case 44:
      Object localObject3;
      int i;
      String str1;
      Object localObject4;
      if (localLispReader1.getPort().peek() == 40)
      {
        localObject3 = localLispReader1.readObject();
        i = LList.listLength(localObject3, false);
        if ((i > 0) && ((((Pair)localObject3).getCar() instanceof Symbol)))
        {
          str1 = ((Pair)localObject3).getCar().toString();
          localObject4 = ReadTable.getCurrent().getReaderCtor(str1);
          if (localObject4 == null)
            paramLexer.error("unknown reader constructor " + str1);
        }
      }
      while (true)
      {
        return Boolean.FALSE;
        if ((!(localObject4 instanceof Procedure)) && (!(localObject4 instanceof Type)))
        {
          paramLexer.error("reader constructor must be procedure or type name");
        }
        else
        {
          int j = i - 1;
          if ((localObject4 instanceof Type));
          Object[] arrayOfObject;
          for (int k = 1; ; k = 0)
          {
            arrayOfObject = new Object[k + j];
            Object localObject5 = ((Pair)localObject3).getCdr();
            for (int m = 0; m < j; m++)
            {
              Pair localPair = (Pair)localObject5;
              arrayOfObject[(k + m)] = localPair.getCar();
              localObject5 = localPair.getCdr();
            }
          }
          if (k > 0);
          try
          {
            arrayOfObject[0] = localObject4;
            return Invoke.make.applyN(arrayOfObject);
            Object localObject6 = ((Procedure)localObject4).applyN(arrayOfObject);
            return localObject6;
          }
          catch (Throwable localThrowable)
          {
            paramLexer.error("caught " + localThrowable + " applying reader constructor " + str1);
          }
          continue;
          paramLexer.error("a non-empty list starting with a symbol must follow #,");
        }
      }
    case 61:
      Object localObject2 = localLispReader1.readObject();
      if ((paramLexer instanceof LispReader))
      {
        LispReader localLispReader2 = (LispReader)paramLexer;
        GeneralHashTable localGeneralHashTable2 = localLispReader2.sharedStructureTable;
        if (localGeneralHashTable2 == null)
        {
          localGeneralHashTable2 = new GeneralHashTable();
          localLispReader2.sharedStructureTable = localGeneralHashTable2;
        }
        Integer localInteger = Integer.valueOf(paramInt2);
        localGeneralHashTable2.put(localInteger, localObject2);
      }
      return localObject2;
    case 35:
    }
    if ((paramLexer instanceof LispReader))
    {
      GeneralHashTable localGeneralHashTable1 = ((LispReader)paramLexer).sharedStructureTable;
      if (localGeneralHashTable1 != null)
      {
        Object localObject1 = localGeneralHashTable1.get(Integer.valueOf(paramInt2), paramLexer);
        if (localObject1 != paramLexer)
          return localObject1;
      }
    }
    paramLexer.error("an unrecognized #n# back-reference was read");
    return Values.empty;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderDispatchMisc
 * JD-Core Version:    0.6.2
 */