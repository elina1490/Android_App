package gnu.kawa.util;

import java.io.File;
import java.io.PrintStream;

public class FixupHtmlToc
{
  static FileInfo[] argFiles;

  public static void main(String[] paramArrayOfString)
  {
    while (true)
    {
      try
      {
        argFiles = new FileInfo[paramArrayOfString.length];
        int i = 0;
        if (i >= paramArrayOfString.length)
          break label109;
        FileInfo localFileInfo = FileInfo.find(new File(paramArrayOfString[i]));
        localFileInfo.writeNeeded = true;
        argFiles[i] = localFileInfo;
        i++;
        continue;
        if (j < paramArrayOfString.length)
        {
          argFiles[j].scan();
          argFiles[j].write();
          j++;
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        System.err.println("caught " + localThrowable);
        localThrowable.printStackTrace();
      }
      return;
      label109: int j = 0;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.FixupHtmlToc
 * JD-Core Version:    0.6.2
 */