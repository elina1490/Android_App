package gnu.kawa.lispexpr;

import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.util.RangeTable;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;

public class ReadTable extends RangeTable
{
  public static final int CONSTITUENT = 2;
  public static final int ILLEGAL = 0;
  public static final int MULTIPLE_ESCAPE = 4;
  public static final int NON_TERMINATING_MACRO = 6;
  public static final int SINGLE_ESCAPE = 3;
  public static final int TERMINATING_MACRO = 5;
  public static final int WHITESPACE = 1;
  static final ThreadLocation current = new ThreadLocation("read-table");
  public static int defaultBracketMode = -1;
  Environment ctorTable = null;
  protected boolean finalColonIsKeyword;
  protected boolean hexEscapeAfterBackslash = true;
  protected boolean initialColonIsKeyword;
  public char postfixLookupOperator = 65535;

  public static ReadTable createInitial()
  {
    ReadTable localReadTable = new ReadTable();
    localReadTable.initialize();
    return localReadTable;
  }

  public static ReadTable getCurrent()
  {
    ReadTable localReadTable = (ReadTable)current.get(null);
    Language localLanguage;
    if (localReadTable == null)
    {
      localLanguage = Language.getDefaultLanguage();
      if (!(localLanguage instanceof LispLanguage))
        break label43;
    }
    label43: for (localReadTable = ((LispLanguage)localLanguage).defaultReadTable; ; localReadTable = createInitial())
    {
      current.set(localReadTable);
      return localReadTable;
    }
  }

  public static void setCurrent(ReadTable paramReadTable)
  {
    current.set(paramReadTable);
  }

  public Object getReaderCtor(String paramString)
  {
    try
    {
      initCtorTable();
      Object localObject2 = this.ctorTable.get(paramString, null);
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }

  void initCtorTable()
  {
    if (this.ctorTable == null)
      this.ctorTable = Environment.make();
  }

  public void initialize()
  {
    ReadTableEntry localReadTableEntry1 = ReadTableEntry.getWhitespaceInstance();
    set(32, localReadTableEntry1);
    set(9, localReadTableEntry1);
    set(10, localReadTableEntry1);
    set(13, localReadTableEntry1);
    set(12, localReadTableEntry1);
    set(124, ReadTableEntry.getMultipleEscapeInstance());
    set(92, ReadTableEntry.getSingleEscapeInstance());
    set(48, 57, ReadTableEntry.getDigitInstance());
    ReadTableEntry localReadTableEntry2 = ReadTableEntry.getConstituentInstance();
    set(97, 122, localReadTableEntry2);
    set(65, 90, localReadTableEntry2);
    set(33, localReadTableEntry2);
    set(36, localReadTableEntry2);
    set(37, localReadTableEntry2);
    set(38, localReadTableEntry2);
    set(42, localReadTableEntry2);
    set(43, localReadTableEntry2);
    set(45, localReadTableEntry2);
    set(46, localReadTableEntry2);
    set(47, localReadTableEntry2);
    set(61, localReadTableEntry2);
    set(62, localReadTableEntry2);
    set(63, localReadTableEntry2);
    set(64, localReadTableEntry2);
    set(94, localReadTableEntry2);
    set(95, localReadTableEntry2);
    set(123, ReadTableEntry.brace);
    set(126, localReadTableEntry2);
    set(127, localReadTableEntry2);
    set(8, localReadTableEntry2);
    set(58, new ReaderColon());
    set(34, new ReaderString());
    set(35, ReaderDispatch.create(this));
    set(59, ReaderIgnoreRestOfLine.getInstance());
    set(40, ReaderParens.getInstance('(', ')'));
    set(39, new ReaderQuote(makeSymbol("quote")));
    set(96, new ReaderQuote(makeSymbol("quasiquote")));
    set(44, new ReaderQuote(makeSymbol("unquote"), '@', makeSymbol("unquote-splicing")));
    setBracketMode();
  }

  public ReadTableEntry lookup(int paramInt)
  {
    ReadTableEntry localReadTableEntry = (ReadTableEntry)lookup(paramInt, null);
    if ((localReadTableEntry == null) && (paramInt >= 0) && (paramInt < 65536))
    {
      if (!Character.isDigit((char)paramInt))
        break label68;
      localReadTableEntry = (ReadTableEntry)lookup(48, null);
    }
    while (true)
    {
      if ((localReadTableEntry == null) && (paramInt >= 128))
        localReadTableEntry = ReadTableEntry.getConstituentInstance();
      if (localReadTableEntry == null)
        localReadTableEntry = ReadTableEntry.getIllegalInstance();
      return localReadTableEntry;
      label68: if (Character.isLowerCase((char)paramInt))
        localReadTableEntry = (ReadTableEntry)lookup(97, null);
      else if (Character.isLetter((char)paramInt))
        localReadTableEntry = (ReadTableEntry)lookup(65, null);
      else if (Character.isWhitespace((char)paramInt))
        localReadTableEntry = (ReadTableEntry)lookup(32, null);
    }
  }

  protected Object makeSymbol(String paramString)
  {
    return Namespace.EmptyNamespace.getSymbol(paramString.intern());
  }

  public void putReaderCtor(String paramString, Type paramType)
  {
    try
    {
      initCtorTable();
      this.ctorTable.put(paramString, paramType);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void putReaderCtor(String paramString, Procedure paramProcedure)
  {
    try
    {
      initCtorTable();
      this.ctorTable.put(paramString, paramProcedure);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void putReaderCtorFld(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      initCtorTable();
      Symbol localSymbol = this.ctorTable.getSymbol(paramString1);
      StaticFieldLocation.define(this.ctorTable, localSymbol, null, paramString2, paramString3);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setBracketMode()
  {
    setBracketMode(defaultBracketMode);
  }

  public void setBracketMode(int paramInt)
  {
    if (paramInt <= 0)
    {
      ReadTableEntry localReadTableEntry = ReadTableEntry.getConstituentInstance();
      set(60, localReadTableEntry);
      if (paramInt < 0)
      {
        set(91, localReadTableEntry);
        set(93, localReadTableEntry);
      }
    }
    while (true)
    {
      if (paramInt >= 0)
      {
        set(91, ReaderParens.getInstance('[', ']'));
        remove(93);
      }
      return;
      set(60, new ReaderTypespec());
    }
  }

  public void setFinalColonIsKeyword(boolean paramBoolean)
  {
    this.finalColonIsKeyword = paramBoolean;
  }

  public void setInitialColonIsKeyword(boolean paramBoolean)
  {
    this.initialColonIsKeyword = paramBoolean;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReadTable
 * JD-Core Version:    0.6.2
 */