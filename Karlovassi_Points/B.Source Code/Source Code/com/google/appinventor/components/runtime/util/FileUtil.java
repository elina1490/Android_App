package com.google.appinventor.components.runtime.util;

import android.os.Environment;
import com.google.appinventor.components.runtime.errors.RuntimeError;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

public class FileUtil
{
  private static final String DIRECTORY_DOWNLOADS = "Downloads";
  private static final String DIRECTORY_PICTURES = "Pictures";
  private static final String DIRECTORY_RECORDINGS = "Recordings";
  private static final String DOCUMENT_DIRECTORY = "My Documents/";
  private static final String FILENAME_PREFIX = "app_inventor_";

  private static void checkExternalStorageWriteable()
    throws FileUtil.FileException
  {
    String str = Environment.getExternalStorageState();
    if ("mounted".equals(str))
      return;
    if ("mounted_ro".equals(str))
      throw new FileException(704);
    throw new FileException(705);
  }

  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramOutputStream, 4096);
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream, 4096);
    while (true)
    {
      int i = localBufferedInputStream.read();
      if (i == -1)
      {
        localBufferedOutputStream.flush();
        return;
      }
      localBufferedOutputStream.write(i);
    }
  }

  public static String copyFile(String paramString1, String paramString2)
    throws IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramString1);
    try
    {
      String str = writeStreamToFile(localFileInputStream, paramString2);
      return str;
    }
    finally
    {
      localFileInputStream.close();
    }
  }

  public static String downloadUrlToFile(String paramString1, String paramString2)
    throws IOException
  {
    InputStream localInputStream = new URL(paramString1).openStream();
    try
    {
      String str = writeStreamToFile(localInputStream, paramString2);
      return str;
    }
    finally
    {
      localInputStream.close();
    }
  }

  public static File getDownloadFile(String paramString)
    throws IOException, FileUtil.FileException
  {
    return getFile("Downloads", paramString);
  }

  public static File getExternalFile(String paramString)
    throws IOException, FileUtil.FileException
  {
    checkExternalStorageWriteable();
    File localFile1 = new File(Environment.getExternalStorageDirectory(), paramString);
    File localFile2 = localFile1.getParentFile();
    if ((!localFile2.exists()) && (!localFile2.mkdirs()))
      throw new IOException("Unable to create directory " + localFile2.getAbsolutePath());
    if ((localFile1.exists()) && (!localFile1.delete()))
      throw new IOException("Cannot overwrite existing file " + localFile1.getAbsolutePath());
    return localFile1;
  }

  private static File getFile(String paramString1, String paramString2)
    throws IOException, FileUtil.FileException
  {
    return getExternalFile("My Documents/" + paramString1 + "/" + "app_inventor_" + System.currentTimeMillis() + "." + paramString2);
  }

  public static String getFileUrl(String paramString)
  {
    return new File(paramString).toURI().toString();
  }

  public static File getPictureFile(String paramString)
    throws IOException, FileUtil.FileException
  {
    return getFile("Pictures", paramString);
  }

  public static File getRecordingFile(String paramString)
    throws IOException, FileUtil.FileException
  {
    return getFile("Recordings", paramString);
  }

  public static byte[] readFile(String paramString)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    try
    {
      copy(localFileInputStream, localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    finally
    {
      localFileInputStream.close();
    }
  }

  public static String writeFile(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      String str = writeStreamToFile(localByteArrayInputStream, paramString);
      return str;
    }
    finally
    {
      localByteArrayInputStream.close();
    }
  }

  public static String writeStreamToFile(InputStream paramInputStream, String paramString)
    throws IOException
  {
    File localFile = new File(paramString);
    localFile.getParentFile().mkdirs();
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    try
    {
      copy(paramInputStream, localFileOutputStream);
      String str = localFile.toURI().toString();
      return str;
    }
    finally
    {
      localFileOutputStream.flush();
      localFileOutputStream.close();
    }
  }

  public static class FileException extends RuntimeError
  {
    private final int msgNumber;

    public FileException(int paramInt)
    {
      this.msgNumber = paramInt;
    }

    public int getErrorMessageNumber()
    {
      return this.msgNumber;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.FileUtil
 * JD-Core Version:    0.6.2
 */