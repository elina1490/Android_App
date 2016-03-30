package gnu.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class ListCodeSize
{
  public static final void main(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length == 0)
      usage();
    String str = paramArrayOfString[0];
    while (true)
    {
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(str);
        ClassType localClassType = new ClassType();
        new ClassFileInput(localClassType, localFileInputStream);
        if (paramArrayOfString.length == 1)
        {
          Method localMethod2 = localClassType.getMethods();
          int i;
          if (localMethod2 != null)
          {
            print(localMethod2);
            localMethod2 = localMethod2.getNext();
            continue;
            if (i < paramArrayOfString.length)
            {
              Object localObject = localClassType.getMethods();
              if (localObject != null)
              {
                StringBuffer localStringBuffer = new StringBuffer();
                localStringBuffer.append(((Method)localObject).getName());
                ((Method)localObject).listParameters(localStringBuffer);
                localStringBuffer.append(((Method)localObject).getReturnType().getName());
                if (localStringBuffer.toString().startsWith(paramArrayOfString[i]))
                  print((Method)localObject);
                Method localMethod1 = ((Method)localObject).getNext();
                localObject = localMethod1;
                continue;
              }
              i++;
              continue;
            }
          }
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        System.err.println("File " + str + " not found");
        System.exit(-1);
        return;
      }
      catch (IOException localIOException)
      {
        System.err.println(localIOException);
        localIOException.printStackTrace();
        System.exit(-1);
        return;
      }
      i = 1;
    }
  }

  static void print(Method paramMethod)
  {
    System.out.print(paramMethod);
    CodeAttr localCodeAttr = paramMethod.getCode();
    if (localCodeAttr == null)
      System.out.print(": no code");
    while (true)
    {
      System.out.println();
      return;
      System.out.print(": ");
      System.out.print(localCodeAttr.getPC());
      System.out.print(" bytes");
    }
  }

  public static void usage()
  {
    System.err.println("Usage: class methodname ...");
    System.exit(-1);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ListCodeSize
 * JD-Core Version:    0.6.2
 */