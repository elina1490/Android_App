package gnu.expr;

import gnu.lists.FString;
import gnu.lists.FVector;
import gnu.mapping.Environment;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class ApplicationMainSupport
{
  public static String[] commandLineArgArray;
  public static FVector commandLineArguments;
  public static boolean processCommandLinePropertyAssignments;
  static String[][] propertyFields = { { "out:doctype-system", "gnu.xml.XMLPrinter", "doctypeSystem" }, { "out:doctype-public", "gnu.xml.XMLPrinter", "doctypePublic" }, { "out:base", "gnu.kawa.functions.DisplayFormat", "outBase" }, { "out:radix", "gnu.kawa.functions.DisplayFormat", "outRadix" }, { "out:line-length", "gnu.text.PrettyWriter", "lineLengthLoc" }, { "out:right-margin", "gnu.text.PrettyWriter", "lineLengthLoc" }, { "out:miser-width", "gnu.text.PrettyWriter", "miserWidthLoc" }, { "out:xml-indent", "gnu.xml.XMLPrinter", "indentLoc" }, { "display:toolkit", "gnu.kawa.models.Display", "myDisplay" }, null };

  public static void processArgs(String[] paramArrayOfString)
  {
    boolean bool = processCommandLinePropertyAssignments;
    int i = 0;
    if (bool)
      while ((i < paramArrayOfString.length) && (processSetProperty(paramArrayOfString[i])))
        i++;
    setArgs(paramArrayOfString, i);
  }

  public static void processSetProperties()
  {
    String[] arrayOfString = commandLineArgArray;
    if (arrayOfString == null)
      processCommandLinePropertyAssignments = true;
    int i;
    do
    {
      return;
      for (i = 0; (i < arrayOfString.length) && (processSetProperty(arrayOfString[i])); i++);
    }
    while (i == 0);
    setArgs(arrayOfString, i);
  }

  public static boolean processSetProperty(String paramString)
  {
    int i = paramString.indexOf('=');
    if (i <= 0)
      return false;
    String str1 = paramString.substring(0, i);
    String str2 = paramString.substring(i + 1);
    for (int j = 0; ; j++)
    {
      String[] arrayOfString = propertyFields[j];
      if (arrayOfString == null);
      while (true)
      {
        Symbol localSymbol = Symbol.parse(str1);
        Language.getDefaultLanguage();
        Environment.getCurrent().define(localSymbol, null, str2);
        return true;
        if (str1.equals(arrayOfString[0]))
        {
          String str3 = arrayOfString[1];
          String str4 = arrayOfString[2];
          try
          {
            ((ThreadLocation)Class.forName(str3).getDeclaredField(str4).get(null)).setGlobal(str2);
          }
          catch (Throwable localThrowable)
          {
            System.err.println("error setting property " + str1 + " field " + str3 + '.' + str4 + ": " + localThrowable);
            System.exit(-1);
          }
        }
      }
    }
  }

  public static void setArgs(String[] paramArrayOfString, int paramInt)
  {
    int i = paramArrayOfString.length - paramInt;
    Object[] arrayOfObject = new Object[i];
    if (paramInt == 0);
    String[] arrayOfString;
    for (commandLineArgArray = paramArrayOfString; ; commandLineArgArray = arrayOfString)
    {
      int k = i;
      while (true)
      {
        k--;
        if (k < 0)
          break;
        arrayOfObject[k] = new FString(paramArrayOfString[(k + paramInt)]);
      }
      arrayOfString = new String[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          break;
        arrayOfString[j] = paramArrayOfString[(j + paramInt)];
      }
    }
    commandLineArguments = new FVector(arrayOfObject);
    Environment.getCurrent().put("command-line-arguments", commandLineArguments);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ApplicationMainSupport
 * JD-Core Version:    0.6.2
 */