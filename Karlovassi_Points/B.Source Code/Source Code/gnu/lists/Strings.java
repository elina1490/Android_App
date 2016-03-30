package gnu.lists;

import java.io.PrintWriter;

public class Strings
{
  public static void makeCapitalize(CharSeq paramCharSeq)
  {
    char c1 = ' ';
    int i = paramCharSeq.length();
    int j = 0;
    if (j < i)
    {
      char c2 = paramCharSeq.charAt(j);
      if (!Character.isLetterOrDigit(c1));
      for (char c3 = Character.toTitleCase(c2); ; c3 = Character.toLowerCase(c2))
      {
        paramCharSeq.setCharAt(j, c3);
        c1 = c3;
        j++;
        break;
      }
    }
  }

  public static void makeLowerCase(CharSeq paramCharSeq)
  {
    int i = paramCharSeq.length();
    while (true)
    {
      i--;
      if (i < 0)
        break;
      paramCharSeq.setCharAt(i, Character.toLowerCase(paramCharSeq.charAt(i)));
    }
  }

  public static void makeUpperCase(CharSeq paramCharSeq)
  {
    int i = paramCharSeq.length();
    while (true)
    {
      i--;
      if (i < 0)
        break;
      paramCharSeq.setCharAt(i, Character.toUpperCase(paramCharSeq.charAt(i)));
    }
  }

  public static void printQuoted(CharSequence paramCharSequence, PrintWriter paramPrintWriter, int paramInt)
  {
    int i = paramCharSequence.length();
    paramPrintWriter.print('"');
    int j = 0;
    if (j < i)
    {
      char c = paramCharSequence.charAt(j);
      if ((c == '\\') || (c == '"'))
      {
        paramPrintWriter.print('\\');
        label52: paramPrintWriter.print(c);
      }
      while (true)
      {
        j++;
        break;
        if (paramInt <= 0)
          break label52;
        if (c == '\n')
        {
          paramPrintWriter.print("\\n");
        }
        else if (c == '\r')
        {
          paramPrintWriter.print("\\r");
        }
        else if (c == '\t')
        {
          paramPrintWriter.print("\\t");
        }
        else if (c == '\007')
        {
          paramPrintWriter.print("\\a");
        }
        else if (c == '\b')
        {
          paramPrintWriter.print("\\b");
        }
        else if (c == '\013')
        {
          paramPrintWriter.print("\\v");
        }
        else
        {
          if (c != '\f')
            break label52;
          paramPrintWriter.print("\\f");
        }
      }
    }
    paramPrintWriter.print('"');
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.Strings
 * JD-Core Version:    0.6.2
 */