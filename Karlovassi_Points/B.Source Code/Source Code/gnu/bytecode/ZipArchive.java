package gnu.bytecode;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipArchive
{
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int i;
    for (long l = 0L; ; l += i)
    {
      i = paramInputStream.read(paramArrayOfByte);
      if (i <= 0)
        return l;
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
  }

  public static void copy(InputStream paramInputStream, String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    File localFile1 = new File(paramString);
    String str = localFile1.getParent();
    if (str != null)
    {
      File localFile2 = new File(str);
      if (!localFile2.exists())
        System.err.println("mkdirs:" + localFile2.mkdirs());
    }
    if (paramString.charAt(paramString.length() - 1) != '/')
    {
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile1));
      copy(paramInputStream, localBufferedOutputStream, paramArrayOfByte);
      localBufferedOutputStream.close();
    }
  }

  public static void main(String[] paramArrayOfString)
    throws IOException
  {
    if (paramArrayOfString.length < 2)
      usage();
    String str1 = paramArrayOfString[0];
    String str2 = paramArrayOfString[1];
    PrintStream localPrintStream;
    byte[] arrayOfByte1;
    ZipInputStream localZipInputStream;
    String str3;
    try
    {
      if ((str1.equals("t")) || (str1.equals("p")) || (str1.equals("x")))
      {
        localPrintStream = System.out;
        arrayOfByte1 = new byte[1024];
        if (paramArrayOfString.length == 2)
        {
          localZipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str2)));
          while (true)
          {
            ZipEntry localZipEntry1 = localZipInputStream.getNextEntry();
            if (localZipEntry1 == null)
              break;
            str3 = localZipEntry1.getName();
            if (!str1.equals("t"))
              break label168;
            localPrintStream.print(str3);
            localPrintStream.print(" size: ");
            localPrintStream.println(localZipEntry1.getSize());
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      System.err.println("I/O Exception:  " + localIOException);
    }
    while (true)
    {
      return;
      label168: if (str1.equals("p"))
      {
        copy(localZipInputStream, localPrintStream, arrayOfByte1);
        break;
      }
      copy(localZipInputStream, str3, arrayOfByte1);
      break;
      ZipFile localZipFile = new ZipFile(str2);
      for (int i = 2; i < paramArrayOfString.length; i++)
      {
        String str4 = paramArrayOfString[i];
        ZipEntry localZipEntry2 = localZipFile.getEntry(str4);
        if (localZipEntry2 == null)
        {
          System.err.println("zipfile " + str2 + ":" + paramArrayOfString[i] + " - not found");
          System.exit(-1);
        }
        else if (str1.equals("t"))
        {
          localPrintStream.print(str4);
          localPrintStream.print(" size: ");
          localPrintStream.println(localZipEntry2.getSize());
        }
        else if (str1.equals("p"))
        {
          copy(localZipFile.getInputStream(localZipEntry2), localPrintStream, arrayOfByte1);
        }
        else
        {
          copy(localZipFile.getInputStream(localZipEntry2), str4, arrayOfByte1);
          continue;
          if (str1.equals("q"))
          {
            ZipOutputStream localZipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
            for (int j = 2; j < paramArrayOfString.length; j++)
            {
              File localFile = new File(paramArrayOfString[j]);
              if (!localFile.exists())
                throw new IOException(paramArrayOfString[j] + " - not found");
              if (!localFile.canRead())
                throw new IOException(paramArrayOfString[j] + " - not readable");
              int k = (int)localFile.length();
              FileInputStream localFileInputStream = new FileInputStream(localFile);
              byte[] arrayOfByte2 = new byte[k];
              if (localFileInputStream.read(arrayOfByte2) != k)
                throw new IOException(paramArrayOfString[j] + " - read error");
              localFileInputStream.close();
              ZipEntry localZipEntry3 = new ZipEntry(paramArrayOfString[j]);
              localZipEntry3.setSize(k);
              localZipEntry3.setTime(localFile.lastModified());
              localZipOutputStream.putNextEntry(localZipEntry3);
              localZipOutputStream.write(arrayOfByte2, 0, k);
            }
            localZipOutputStream.close();
            return;
          }
          usage();
          return;
        }
      }
    }
  }

  private static void usage()
  {
    System.err.println("zipfile [ptxq] archive [file ...]");
    System.exit(-1);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ZipArchive
 * JD-Core Version:    0.6.2
 */