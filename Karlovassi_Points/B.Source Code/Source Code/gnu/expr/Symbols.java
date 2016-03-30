package gnu.expr;

import gnu.lists.Consumer;
import gnu.mapping.OutPort;
import gnu.mapping.SimpleSymbol;

public class Symbols
{
  private static int gensym_counter;

  static int generateInt()
  {
    try
    {
      int i = 1 + gensym_counter;
      gensym_counter = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static final SimpleSymbol gentemp()
  {
    return SimpleSymbol.valueOf("GS." + Integer.toString(generateInt()));
  }

  public static final String intern(String paramString)
  {
    return make(paramString);
  }

  public static String make(String paramString)
  {
    return paramString.intern();
  }

  public static void print(String paramString, Consumer paramConsumer)
  {
    if (((paramConsumer instanceof OutPort)) && (((OutPort)paramConsumer).printReadable));
    for (int i = 1; i != 0; i = 0)
    {
      int j = paramString.length();
      for (int k = 0; k < j; k++)
      {
        char c = paramString.charAt(k);
        if ((!Character.isLowerCase(c)) && (c != '!') && (c != '$') && (c != '%') && (c != '&') && (c != '*') && (c != '/') && (c != ':') && (c != '<') && (c != '=') && (c != '>') && (c != '?') && (c != '~') && (c != '_') && (c != '^') && (((c != '+') && (c != '-')) || ((k <= 0) && (j != 1) && ((!Character.isDigit(c)) || (k <= 0)) && ((c != '.') || ((k != 0) && (paramString.charAt(k - 1) != '.'))))))
          paramConsumer.write(92);
        paramConsumer.write(c);
      }
    }
    paramConsumer.write(paramString);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.Symbols
 * JD-Core Version:    0.6.2
 */