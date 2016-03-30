package gnu.kawa.functions;

import java.io.File;
import java.io.IOException;

public class FileUtils
{
  public static File createTempFile(String paramString)
    throws IOException
  {
    if (paramString == null)
      paramString = "kawa~d.tmp";
    int i = paramString.indexOf('~');
    String str1;
    if (i < 0)
      str1 = paramString;
    for (String str2 = ".tmp"; ; str2 = paramString.substring(i + 2))
    {
      int j = str1.indexOf(File.separatorChar);
      File localFile = null;
      if (j >= 0)
      {
        localFile = new File(str1.substring(0, j));
        str1 = str1.substring(j + 1);
      }
      return File.createTempFile(str1, str2, localFile);
      str1 = paramString.substring(0, i);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.FileUtils
 * JD-Core Version:    0.6.2
 */