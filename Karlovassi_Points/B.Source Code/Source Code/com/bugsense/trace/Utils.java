package com.bugsense.trace;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

public class Utils
{
  private static final char[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final int STATE_DONT_KNOW = 2;
  public static final int STATE_OFF = 0;
  public static final int STATE_ON = 1;

  private static int CheckNetworkConnection(Context paramContext, String paramString)
  {
    int i = 0;
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", G.APP_PACKAGE) == 0)
    {
      for (NetworkInfo localNetworkInfo : ((ConnectivityManager)paramContext.getSystemService("connectivity")).getAllNetworkInfo())
        if ((localNetworkInfo.getTypeName().equalsIgnoreCase(paramString)) && (localNetworkInfo.isConnected()))
          i = 1;
      return i;
    }
    return 2;
  }

  public static String MD5(String paramString)
    throws Exception
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    localMessageDigest.update(paramString.getBytes(), 0, paramString.length());
    return new BigInteger(1, localMessageDigest.digest()).toString(16);
  }

  protected static String[] ScreenProperties(Context paramContext)
  {
    String[] arrayOfString = { "Not available", "Not available", "Not available", "Not available", "Not available" };
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    int k = localDisplay.getOrientation();
    arrayOfString[0] = Integer.toString(i);
    arrayOfString[1] = Integer.toString(j);
    String str = "";
    switch (k)
    {
    default:
    case 0:
    case 2:
    case 3:
    case 1:
    }
    while (true)
    {
      arrayOfString[2] = str;
      localDisplay.getMetrics(localDisplayMetrics);
      arrayOfString[3] = Float.toString(localDisplayMetrics.xdpi);
      arrayOfString[4] = Float.toString(localDisplayMetrics.ydpi);
      return arrayOfString;
      str = "normal";
      continue;
      str = "180";
      continue;
      str = "270";
      continue;
      str = "90";
    }
  }

  protected static boolean checkForRoot()
  {
    for (String str : new String[] { "/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/" })
      if (new File(str + "su").exists())
        return true;
    return false;
  }

  private static char[] encodeHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    char[] arrayOfChar = new char[j << 1];
    for (int k = 0; k < j; k++)
    {
      int m = i + 1;
      arrayOfChar[i] = DIGITS[((0xF0 & paramArrayOfByte[k]) >>> 4)];
      i = m + 1;
      arrayOfChar[m] = DIGITS[(0xF & paramArrayOfByte[k])];
    }
    return arrayOfChar;
  }

  private static String generateUid()
  {
    String str1 = new Long(new Date().getTime()).toString();
    String str2 = new Object().toString();
    long l = System.nanoTime();
    try
    {
      Thread.sleep(1100L, 42);
      label44: String str3 = new Long(System.nanoTime() - l).toString();
      String str4 = new Integer((int)(65535.0D * new Random(System.currentTimeMillis()).nextDouble())).toString();
      String str5 = str1 + str2 + str3 + str4 + "android_id";
      try
      {
        byte[] arrayOfByte2 = str5.getBytes("UTF-8");
        byte[] arrayOfByte3 = MessageDigest.getInstance("MD5").digest(arrayOfByte2);
        arrayOfByte1 = arrayOfByte3;
        return new String(encodeHex(arrayOfByte1));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        while (true)
        {
          localUnsupportedEncodingException.printStackTrace();
          arrayOfByte1 = null;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        while (true)
        {
          localNoSuchAlgorithmException.printStackTrace();
          byte[] arrayOfByte1 = null;
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label44;
    }
  }

  // ERROR //
  private static String getCurrentUid(Context paramContext)
  {
    // Byte code:
    //   0: new 195	java/io/File
    //   3: dup
    //   4: new 197	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 293	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   14: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   17: getstatic 299	java/io/File:separator	Ljava/lang/String;
    //   20: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 301
    //   26: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 209	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_0
    //   37: invokestatic 304	com/bugsense/trace/Utils:getFilePath	(Landroid/content/Context;)Ljava/lang/String;
    //   40: astore_2
    //   41: aload_1
    //   42: ifnull +223 -> 265
    //   45: aload_1
    //   46: invokevirtual 212	java/io/File:exists	()Z
    //   49: ifeq +216 -> 265
    //   52: aload_1
    //   53: invokevirtual 307	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   56: astore_3
    //   57: new 309	java/io/BufferedReader
    //   60: dup
    //   61: new 311	java/io/FileReader
    //   64: dup
    //   65: aload_3
    //   66: invokespecial 312	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   69: invokespecial 315	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   72: astore 4
    //   74: aload 4
    //   76: ifnull +182 -> 258
    //   79: aload 4
    //   81: invokevirtual 318	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   84: astore 16
    //   86: aload 16
    //   88: astore 5
    //   90: aload 4
    //   92: ifnull +8 -> 100
    //   95: aload 4
    //   97: invokevirtual 321	java/io/BufferedReader:close	()V
    //   100: aload 5
    //   102: invokevirtual 105	java/lang/String:length	()I
    //   105: ifle +103 -> 208
    //   108: aload 5
    //   110: areturn
    //   111: astore 9
    //   113: aconst_null
    //   114: astore 8
    //   116: getstatic 324	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   119: ldc_w 326
    //   122: invokestatic 331	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   125: pop
    //   126: getstatic 337	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   129: ifeq +35 -> 164
    //   132: getstatic 324	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   135: new 197	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 339
    //   145: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_3
    //   149: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 331	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   158: pop
    //   159: aload 9
    //   161: invokevirtual 340	java/lang/Exception:printStackTrace	()V
    //   164: aload 8
    //   166: ifnull +85 -> 251
    //   169: aload 8
    //   171: invokevirtual 321	java/io/BufferedReader:close	()V
    //   174: ldc 152
    //   176: astore 5
    //   178: goto -78 -> 100
    //   181: astore 14
    //   183: ldc 152
    //   185: astore 5
    //   187: goto -87 -> 100
    //   190: astore 10
    //   192: aconst_null
    //   193: astore 11
    //   195: aload 11
    //   197: ifnull +8 -> 205
    //   200: aload 11
    //   202: invokevirtual 321	java/io/BufferedReader:close	()V
    //   205: aload 10
    //   207: athrow
    //   208: aconst_null
    //   209: areturn
    //   210: astore 6
    //   212: goto -112 -> 100
    //   215: astore 12
    //   217: goto -12 -> 205
    //   220: astore 10
    //   222: aload 4
    //   224: astore 11
    //   226: goto -31 -> 195
    //   229: astore 10
    //   231: aload 8
    //   233: astore 11
    //   235: goto -40 -> 195
    //   238: astore 7
    //   240: aload 4
    //   242: astore 8
    //   244: aload 7
    //   246: astore 9
    //   248: goto -132 -> 116
    //   251: ldc 152
    //   253: astore 5
    //   255: goto -155 -> 100
    //   258: ldc 152
    //   260: astore 5
    //   262: goto -172 -> 90
    //   265: aload_2
    //   266: astore_3
    //   267: goto -210 -> 57
    //
    // Exception table:
    //   from	to	target	type
    //   57	74	111	java/lang/Exception
    //   169	174	181	java/io/IOException
    //   57	74	190	finally
    //   95	100	210	java/io/IOException
    //   200	205	215	java/io/IOException
    //   79	86	220	finally
    //   116	164	229	finally
    //   79	86	238	java/lang/Exception
  }

  private static String getFilePath(Context paramContext)
  {
    if ((hasStorage(true)) && (paramContext.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", G.APP_PACKAGE) == 0))
    {
      File localFile = Environment.getExternalStorageDirectory();
      if (localFile == null)
        return paramContext.getFilesDir().getAbsolutePath() + File.separator + ".bugsense";
      return localFile + File.separator + ".bugsense";
    }
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + ".bugsense";
  }

  public static String getUid(Context paramContext)
  {
    String str1 = getCurrentUid(paramContext);
    if (str1 != null)
      return str1;
    String str2 = generateUid();
    saveUid(paramContext, str2);
    return str2;
  }

  private static boolean hasStorage(boolean paramBoolean)
  {
    String str = Environment.getExternalStorageState();
    if (Environment.getExternalStorageState().equals("mounted"))
      return true;
    return (!paramBoolean) && ("mounted_ro".equals(str));
  }

  protected static int isGPSOn(Context paramContext)
  {
    int i = 1;
    if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", G.APP_PACKAGE) == 0)
    {
      if (!((LocationManager)paramContext.getSystemService("location")).isProviderEnabled("gps"))
        i = 0;
      return i;
    }
    return 2;
  }

  protected static int isMobileNetworkOn(Context paramContext)
  {
    return CheckNetworkConnection(paramContext, "MOBILE");
  }

  public static boolean isOnWifi(Context paramContext)
  {
    return CheckNetworkConnection(paramContext, "WIFI") == 1;
  }

  protected static int isWifiOn(Context paramContext)
  {
    return CheckNetworkConnection(paramContext, "WIFI");
  }

  // ERROR //
  private static boolean saveUid(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 304	com/bugsense/trace/Utils:getFilePath	(Landroid/content/Context;)Ljava/lang/String;
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: new 394	java/io/PrintWriter
    //   10: dup
    //   11: aload_2
    //   12: invokespecial 395	java/io/PrintWriter:<init>	(Ljava/lang/String;)V
    //   15: astore 4
    //   17: aload 4
    //   19: aload_1
    //   20: invokevirtual 398	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   23: aload 4
    //   25: invokevirtual 401	java/io/PrintWriter:flush	()V
    //   28: iconst_1
    //   29: istore 8
    //   31: aload 4
    //   33: ifnull +8 -> 41
    //   36: aload 4
    //   38: invokevirtual 402	java/io/PrintWriter:close	()V
    //   41: iload 8
    //   43: ireturn
    //   44: astore 10
    //   46: aconst_null
    //   47: astore 4
    //   49: aload 10
    //   51: astore 5
    //   53: getstatic 324	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   56: ldc_w 404
    //   59: invokestatic 331	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   62: pop
    //   63: getstatic 337	com/bugsense/trace/BugSenseHandler:I_WANT_TO_DEBUG	Z
    //   66: ifeq +35 -> 101
    //   69: getstatic 324	com/bugsense/trace/G:TAG	Ljava/lang/String;
    //   72: new 197	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 406
    //   82: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 331	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   95: pop
    //   96: aload 5
    //   98: invokevirtual 407	java/io/IOException:printStackTrace	()V
    //   101: iconst_0
    //   102: istore 8
    //   104: aload 4
    //   106: ifnull -65 -> 41
    //   109: aload 4
    //   111: invokevirtual 402	java/io/PrintWriter:close	()V
    //   114: iconst_0
    //   115: ireturn
    //   116: astore 6
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 402	java/io/PrintWriter:close	()V
    //   126: aload 6
    //   128: athrow
    //   129: astore 6
    //   131: aload 4
    //   133: astore_3
    //   134: goto -16 -> 118
    //   137: astore 5
    //   139: goto -86 -> 53
    //
    // Exception table:
    //   from	to	target	type
    //   7	17	44	java/io/IOException
    //   7	17	116	finally
    //   17	28	129	finally
    //   53	101	129	finally
    //   17	28	137	java/io/IOException
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.bugsense.trace.Utils
 * JD-Core Version:    0.6.2
 */