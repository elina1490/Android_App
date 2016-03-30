package com.google.appinventor.components.runtime.util;

import android.content.Intent;
import android.net.Uri;
import com.google.appinventor.components.runtime.ReplForm;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Properties;
import kawa.standard.Scheme;

public class AppInvHTTPD extends NanoHTTPD
{
  private static final int YAV_SKEW = 1;
  private ReplForm form;
  private File rootDir;
  private Language scheme;

  public AppInvHTTPD(int paramInt, File paramFile, ReplForm paramReplForm)
    throws IOException
  {
    super(paramInt, paramFile);
    this.rootDir = paramFile;
    this.scheme = Scheme.getInstance("scheme");
    this.form = paramReplForm;
    ModuleExp.mustNeverCompile();
    try
    {
      this.scheme.eval("(begin (require com.google.youngandroid.runtime)  (setup-repl-environment \"<<\" \":\" \"@@\" \"Success\" \"Failure\" \"==\" \">>\" '((\">>\" \"&2\")(\"<<\" \"&1\")(\"&\" \"&0\"))))");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }

  private void copyFile(File paramFile1, File paramFile2)
  {
    FileInputStream localFileInputStream;
    FileOutputStream localFileOutputStream;
    try
    {
      localFileInputStream = new FileInputStream(paramFile1);
      localFileOutputStream = new FileOutputStream(paramFile2);
      byte[] arrayOfByte = new byte[32768];
      while (true)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i <= 0)
          break;
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    localFileInputStream.close();
    localFileOutputStream.close();
  }

  public NanoHTTPD.Response serve(String paramString1, String paramString2, Properties paramProperties1, Properties paramProperties2, Properties paramProperties3)
  {
    myOut.println(paramString2 + " '" + paramString1 + "' ");
    NanoHTTPD.Response localResponse3;
    if (paramString1.equals("/_version"))
    {
      try
      {
        String str8 = paramProperties2.getProperty("version", "0");
        Integer localInteger = new Integer(str8);
        int i = localInteger.intValue();
        if ((i > 70) || (i < 68))
          this.scheme.eval("(begin (require com.google.youngandroid.runtime) (process-repl-input ((get-var badversion)) \"foo\"))");
        while (true)
        {
          localResponse3 = new NanoHTTPD.Response(this, "200 OK", "text/plain", "OK");
          break;
          this.scheme.eval("(begin (require com.google.youngandroid.runtime) (process-repl-input ((get-var *start-repl*)) \"foo\"))");
        }
      }
      catch (Throwable localThrowable)
      {
        String str7 = localThrowable.toString();
        localResponse3 = new NanoHTTPD.Response(this, "200 OK", "text/plain", str7);
        localThrowable.printStackTrace();
      }
    }
    else
    {
      if (paramString1.equals("/_package"))
      {
        String str6 = paramProperties2.getProperty("package", null);
        if (str6 == null)
        {
          NanoHTTPD.Response localResponse1 = new NanoHTTPD.Response(this, "200 OK", "text/plain", "NOT OK");
          return localResponse1;
        }
        myOut.println(this.rootDir + "/" + str6);
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(Uri.fromFile(new File(this.rootDir + "/" + str6)), "application/vnd.android.package-archive");
        this.form.startActivity(localIntent);
        NanoHTTPD.Response localResponse2 = new NanoHTTPD.Response(this, "200 OK", "text/plain", "OK");
        return localResponse2;
      }
      Enumeration localEnumeration1 = paramProperties1.propertyNames();
      while (localEnumeration1.hasMoreElements())
      {
        String str5 = (String)localEnumeration1.nextElement();
        myOut.println("  HDR: '" + str5 + "' = '" + paramProperties1.getProperty(str5) + "'");
      }
      Enumeration localEnumeration2 = paramProperties2.propertyNames();
      while (localEnumeration2.hasMoreElements())
      {
        String str4 = (String)localEnumeration2.nextElement();
        myOut.println("  PRM: '" + str4 + "' = '" + paramProperties2.getProperty(str4) + "'");
      }
      Enumeration localEnumeration3 = paramProperties3.propertyNames();
      if (localEnumeration3.hasMoreElements())
      {
        String str1 = (String)localEnumeration3.nextElement();
        String str2 = paramProperties3.getProperty(str1);
        String str3 = paramProperties2.getProperty(str1);
        if ((str3.startsWith("..")) || (str3.endsWith("..")) || (str3.indexOf("../") >= 0))
        {
          myOut.println(" Ignoring invalid filename: " + str3);
          str3 = null;
        }
        File localFile1 = new File(str2);
        if (str3 == null)
          localFile1.delete();
        while (true)
        {
          myOut.println(" UPLOADED: '" + str3 + "' was at '" + str2 + "'");
          break;
          File localFile2 = new File(this.rootDir + "/" + str3);
          if (!localFile1.renameTo(localFile2))
          {
            copyFile(localFile1, localFile2);
            localFile1.delete();
          }
        }
      }
      return serveFile(paramString1, paramProperties1, this.rootDir, true);
    }
    return localResponse3;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.AppInvHTTPD
 * JD-Core Version:    0.6.2
 */