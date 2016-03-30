package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.runtime.collect.Lists;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CsvUtil
{
  public static YailList fromCsvRow(String paramString)
    throws Exception
  {
    CsvParser localCsvParser = new CsvParser(new StringReader(paramString));
    if (localCsvParser.hasNext())
    {
      YailList localYailList = YailList.makeList(localCsvParser.next());
      if (localCsvParser.hasNext())
        throw new IllegalArgumentException("CSV text has multiple rows. Expected just one row.");
      localCsvParser.throwAnyProblem();
      return localYailList;
    }
    throw new IllegalArgumentException("CSV text cannot be parsed as a row.");
  }

  public static YailList fromCsvTable(String paramString)
    throws Exception
  {
    CsvParser localCsvParser = new CsvParser(new StringReader(paramString));
    ArrayList localArrayList = new ArrayList();
    while (localCsvParser.hasNext())
      localArrayList.add(YailList.makeList(localCsvParser.next()));
    localCsvParser.throwAnyProblem();
    return YailList.makeList(localArrayList);
  }

  private static void makeCsvRow(YailList paramYailList, StringBuilder paramStringBuilder)
  {
    String str1 = "";
    Object[] arrayOfObject = paramYailList.toArray();
    int i = arrayOfObject.length;
    for (int j = 0; j < i; j++)
    {
      String str2 = arrayOfObject[j].toString().replaceAll("\"", "\"\"");
      paramStringBuilder.append(str1).append("\"").append(str2).append("\"");
      str1 = ",";
    }
  }

  public static String toCsvRow(YailList paramYailList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    makeCsvRow(paramYailList, localStringBuilder);
    return localStringBuilder.toString();
  }

  public static String toCsvTable(YailList paramYailList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object[] arrayOfObject = paramYailList.toArray();
    int i = arrayOfObject.length;
    for (int j = 0; j < i; j++)
    {
      makeCsvRow((YailList)arrayOfObject[j], localStringBuilder);
      localStringBuilder.append("\r\n");
    }
    return localStringBuilder.toString();
  }

  private static class CsvParser
    implements Iterator<List<String>>
  {
    private final Pattern ESCAPED_QUOTE_PATTERN = Pattern.compile("\"\"");
    private final char[] buf = new char[10240];
    private int cellLength = -1;
    private int delimitedCellLength = -1;
    private final Reader in;
    private Exception lastException;
    private int limit;
    private boolean opened = true;
    private int pos;
    private long previouslyRead;

    public CsvParser(Reader paramReader)
    {
      this.in = paramReader;
    }

    private int checkedIndex(int paramInt)
    {
      if (paramInt < this.limit)
        return paramInt;
      return indexAfterCompactionAndFilling(paramInt);
    }

    private int compact(int paramInt)
    {
      int i = this.pos;
      this.pos = 0;
      int j = this.limit - i;
      if (j > 0)
        System.arraycopy(this.buf, i, this.buf, 0, j);
      this.limit -= i;
      this.previouslyRead += i;
      return paramInt - i;
    }

    private void fill()
    {
      int i = this.buf.length - this.limit;
      while ((this.opened) && (i > 0))
      {
        int j;
        try
        {
          j = this.in.read(this.buf, this.limit, i);
          if (j != -1)
            break label66;
          this.opened = false;
        }
        catch (IOException localIOException)
        {
          this.lastException = localIOException;
          this.opened = false;
        }
        continue;
        label66: this.limit = (j + this.limit);
        i -= j;
      }
    }

    private boolean findDelimOrEnd(int paramInt)
    {
      while (true)
      {
        if (paramInt >= this.limit)
        {
          paramInt = indexAfterCompactionAndFilling(paramInt);
          if (paramInt >= this.limit)
            break;
        }
        switch (this.buf[paramInt])
        {
        default:
          this.lastException = new IOException("Syntax Error: non-whitespace between closing quote and delimiter or end");
          return false;
        case '\r':
          int i = checkedIndex(paramInt + 1);
          if (this.buf[i] == '\n');
          for (int j = checkedIndex(i + 1); ; j = i)
          {
            this.delimitedCellLength = (j - this.pos);
            return true;
          }
        case '\n':
        case ',':
          this.delimitedCellLength = (checkedIndex(paramInt + 1) - this.pos);
          return true;
        case '\t':
        case ' ':
        }
        paramInt++;
      }
      this.delimitedCellLength = (this.limit - this.pos);
      return true;
    }

    private boolean findUnescapedEndQuote(int paramInt)
    {
      while (true)
      {
        if (paramInt >= this.limit)
        {
          paramInt = indexAfterCompactionAndFilling(paramInt);
          if (paramInt >= this.limit)
            break;
        }
        if (this.buf[paramInt] == '"')
        {
          paramInt = checkedIndex(paramInt + 1);
          if ((paramInt == this.limit) || (this.buf[paramInt] != '"'))
          {
            this.cellLength = (paramInt - this.pos);
            return findDelimOrEnd(paramInt);
          }
        }
        paramInt++;
      }
      this.lastException = new IllegalArgumentException("Syntax Error. unclosed quoted cell");
      return false;
    }

    private boolean findUnquotedCellEnd(int paramInt)
    {
      while (true)
      {
        if (paramInt >= this.limit)
        {
          paramInt = indexAfterCompactionAndFilling(paramInt);
          if (paramInt >= this.limit)
            break;
        }
        switch (this.buf[paramInt])
        {
        default:
          paramInt++;
        case '\n':
        case ',':
        case '\r':
        case '"':
        }
      }
      this.cellLength = (paramInt - this.pos);
      this.delimitedCellLength = (1 + this.cellLength);
      return true;
      this.cellLength = (paramInt - this.pos);
      int i = checkedIndex(paramInt + 1);
      if (this.buf[i] == '\n');
      for (int j = checkedIndex(i + 1); ; j = i)
      {
        this.delimitedCellLength = (j - this.pos);
        return true;
      }
      this.lastException = new IllegalArgumentException("Syntax Error: quote in unquoted cell");
      return false;
      int k = this.limit - this.pos;
      this.cellLength = k;
      this.delimitedCellLength = k;
      return true;
    }

    private int indexAfterCompactionAndFilling(int paramInt)
    {
      if (this.pos > 0)
        paramInt = compact(paramInt);
      fill();
      return paramInt;
    }

    private boolean lookingAtCell()
    {
      if (this.buf[this.pos] == '"')
        return findUnescapedEndQuote(1 + this.pos);
      return findUnquotedCellEnd(this.pos);
    }

    public long getCharPosition()
    {
      return this.previouslyRead + this.pos;
    }

    public boolean hasNext()
    {
      if (this.limit == 0)
        fill();
      return ((this.pos < this.limit) || (indexAfterCompactionAndFilling(this.pos) < this.limit)) && (lookingAtCell());
    }

    public ArrayList<String> next()
    {
      ArrayList localArrayList = Lists.newArrayList();
      label189: label195: label199: 
      while (true)
      {
        int i;
        if (this.buf[this.pos] != '"')
        {
          localArrayList.add(new String(this.buf, this.pos, this.cellLength));
          if ((this.delimitedCellLength <= 0) || (this.buf[(this.pos + this.delimitedCellLength - 1)] != ','))
            break label189;
          i = 1;
          label73: this.pos += this.delimitedCellLength;
          this.cellLength = -1;
          this.delimitedCellLength = -1;
          if ((this.pos >= this.limit) && (indexAfterCompactionAndFilling(this.pos) >= this.limit))
            break label195;
        }
        for (int j = 1; ; j = 0)
        {
          if ((i != 0) && (j != 0) && (lookingAtCell()))
            break label199;
          return localArrayList;
          String str = new String(this.buf, 1 + this.pos, this.cellLength - 2);
          localArrayList.add(this.ESCAPED_QUOTE_PATTERN.matcher(str).replaceAll("\""));
          break;
          i = 0;
          break label73;
        }
      }
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }

    public void skip(long paramLong)
      throws IOException
    {
      while (true)
      {
        int i;
        if (paramLong > 0L)
        {
          i = this.in.read(this.buf, 0, Math.min((int)paramLong, this.buf.length));
          if (i >= 0);
        }
        else
        {
          return;
        }
        this.previouslyRead += i;
        paramLong -= i;
      }
    }

    public void throwAnyProblem()
      throws Exception
    {
      if (this.lastException != null)
        throw this.lastException;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.CsvUtil
 * JD-Core Version:    0.6.2
 */