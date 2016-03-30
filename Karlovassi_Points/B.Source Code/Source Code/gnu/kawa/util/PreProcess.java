package gnu.kawa.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class PreProcess
{
  static final String JAVA4_FEATURES = "+JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio";
  static final String JAVA5_FEATURES = "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName";
  static final String NO_JAVA4_FEATURES = "-JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android";
  static final String NO_JAVA6_FEATURES = "-JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer";
  static String[] version_features = { "java1", "-JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java2", "+JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java4", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java4x", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 +use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java6compat5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6 -JAVA7 +JAVA6COMPAT5 +use:java.text.Normalizer -use:java.dyn -Android", "java6", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 -JAVA7 -JAVA6COMPAT5 +use:java.text.Normalizer -use:java.dyn -Android", "java7", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 +JAVA7 -JAVA6COMPAT5 +use:java.text.Normalizer +use:java.dyn -Android", "android", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 -JAXP-QName -use:javax.xml.transform -JAVA6 -JAVA6COMPAT5 +Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer" };
  String filename;
  Hashtable keywords = new Hashtable();
  int lineno;
  byte[] resultBuffer;
  int resultLength;

  public static void main(String[] paramArrayOfString)
  {
    PreProcess localPreProcess = new PreProcess();
    localPreProcess.keywords.put("true", Boolean.TRUE);
    localPreProcess.keywords.put("false", Boolean.FALSE);
    for (int i = 0; i < paramArrayOfString.length; i++)
      localPreProcess.handleArg(paramArrayOfString[i]);
  }

  void error(String paramString)
  {
    System.err.println(this.filename + ':' + this.lineno + ": " + paramString);
    System.exit(-1);
  }

  public void filter(String paramString)
    throws Throwable
  {
    if (filter(paramString, new BufferedInputStream(new FileInputStream(paramString))))
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      localFileOutputStream.write(this.resultBuffer, 0, this.resultLength);
      localFileOutputStream.close();
      System.err.println("Pre-processed " + paramString);
    }
  }

  public boolean filter(String paramString, BufferedInputStream paramBufferedInputStream)
    throws Throwable
  {
    this.filename = paramString;
    byte[] arrayOfByte1 = new byte[2000];
    this.lineno = 1;
    boolean bool1 = false;
    int i = 0;
    int j = 0;
    int k = 0;
    int m = -1;
    int n = 0;
    int i1 = -1;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    Object localObject1 = null;
    Object localObject2 = arrayOfByte1;
    int i5;
    int i30;
    Object localObject7;
    boolean bool3;
    while (true)
    {
      i5 = paramBufferedInputStream.read();
      if (i5 < 0)
      {
        i30 = j;
        localObject7 = localObject2;
        bool3 = bool1;
        if (i3 != 0)
        {
          this.lineno = i2;
          error("unterminated " + (String)localObject1);
        }
        this.resultBuffer = localObject7;
        this.resultLength = i30;
        return bool3;
      }
      if (j + 10 >= localObject2.length)
      {
        byte[] arrayOfByte2 = new byte[j * 2];
        System.arraycopy(localObject2, 0, arrayOfByte2, 0, j);
        localObject2 = arrayOfByte2;
      }
      if ((i5 != 10) || (j <= 0) || (localObject2[(j - 1)] != 13))
        break;
      int i38 = j + 1;
      localObject2[j] = ((byte)i5);
      j = i38;
    }
    int i36;
    int i32;
    if ((i1 >= 0) && (m < 0) && (i <= 0) && (i5 != 13) && (i5 != 10) && ((i1 == n) || ((i5 != 32) && (i5 != 9))))
    {
      if (i5 != 47)
        break label457;
      paramBufferedInputStream.mark(100);
      i36 = paramBufferedInputStream.read();
      if (i36 != 47)
        break label405;
      i32 = 0;
      label283: paramBufferedInputStream.reset();
    }
    int i29;
    while (true)
    {
      if (i32 != 0)
      {
        int i33 = j + 1;
        localObject2[j] = 47;
        int i34 = i33 + 1;
        localObject2[i33] = 47;
        int i35 = i34 + 1;
        localObject2[i34] = 32;
        bool1 = true;
        j = i35;
        i = 1;
      }
      if ((i5 == 32) || (i5 == 9) || (m >= 0))
        break label1482;
      if ((i3 <= 0) || (i1 == n) || (i5 != 47))
        break label1463;
      i29 = paramBufferedInputStream.read();
      if (i29 >= 0)
        break label463;
      i30 = j;
      localObject7 = localObject2;
      bool3 = bool1;
      break;
      label405: if (i36 == 42)
      {
        int i37;
        do
          i37 = paramBufferedInputStream.read();
        while ((i37 == 32) || (i37 == 9));
        if (i37 != 35)
        {
          i32 = 1;
          break label283;
        }
        i32 = 0;
        break label283;
      }
      i32 = 1;
      break label283;
      label457: i32 = 1;
    }
    label463: int i7;
    int i8;
    boolean bool2;
    int i6;
    if (i29 != 47)
    {
      int i31 = j + 1;
      localObject2[j] = 47;
      i7 = i;
      i8 = i29;
      bool2 = bool1;
      i6 = i31;
    }
    int i9;
    int i10;
    int i12;
    int i13;
    while (true)
    {
      localObject2[i6] = ((byte)i8);
      i9 = i6 + 1;
      if ((i8 != 13) && (i8 != 10))
        break label1366;
      i10 = 0;
      int i11 = i4;
      i12 = -1;
      label583: for (i13 = i11; i13 < i9 - 1; i13++)
        if ((localObject2[i13] != 32) && (localObject2[i13] != 9))
        {
          if (i12 >= 0)
            break label1446;
          i10 = i13;
          i12 = i13;
        }
      i8 = paramBufferedInputStream.read();
      if (i8 < 0)
      {
        i30 = j;
        localObject7 = localObject2;
        bool3 = bool1;
        break;
      }
      i7 = -1;
      if (i8 != 32)
        break label1453;
      i8 = paramBufferedInputStream.read();
      if ((i8 != 32) && (i8 != 9))
        break label1453;
      bool2 = true;
      i6 = j;
      j = -1;
    }
    String str1;
    int i21;
    String str2;
    String str3;
    Object localObject5;
    label866: int i15;
    Object localObject3;
    int i17;
    int i14;
    int i16;
    if ((i10 - i12 >= 4) && (localObject2[i12] == 47) && (localObject2[(i12 + 1)] == 42) && (localObject2[(i10 - 1)] == 42) && (localObject2[i10] == 47))
    {
      for (int i18 = i12 + 2; (i18 < i10) && (localObject2[i18] == 32); i18++);
      for (int i19 = i10 - 2; (i19 > i18) && (localObject2[i19] == 32); i19--);
      if (localObject2[i18] == 35)
      {
        str1 = new String((byte[])localObject2, i18, 1 + (i19 - i18), "ISO-8859-1");
        int i20 = str1.indexOf(' ');
        i21 = this.lineno;
        if (i20 > 0)
        {
          String str4 = str1.substring(0, i20);
          String str5 = str1.substring(i20).trim();
          Object localObject6 = this.keywords.get(str5);
          str2 = str4;
          str3 = str5;
          localObject5 = localObject6;
          if ((!"#ifdef".equals(str2)) && (!"#ifndef".equals(str2)))
            break label1108;
          if (localObject5 == null)
          {
            System.err.println(paramString + ":" + this.lineno + ": warning - undefined keyword: " + str3);
            localObject5 = Boolean.FALSE;
          }
          i15 = i3 + 1;
          if (k <= 0)
            break label1045;
          localObject3 = str2;
          i17 = n;
          i14 = i21;
          int i25 = k;
          i16 = i15;
          i15 = i25;
        }
      }
    }
    while (true)
    {
      label973: this.lineno = (1 + this.lineno);
      i4 = i9;
      Object localObject4 = localObject3;
      i = 0;
      m = -1;
      i1 = i17;
      i3 = i16;
      k = i15;
      localObject1 = localObject4;
      i2 = i14;
      n = 0;
      label1020: j = i9;
      bool1 = bool2;
      break;
      str2 = str1;
      str3 = "";
      localObject5 = null;
      break label866;
      label1045: int i22;
      label1059: int i23;
      if (str2.charAt(3) == 'n')
      {
        i22 = 1;
        if (localObject5 != Boolean.FALSE)
          break label1102;
        i23 = 1;
      }
      while (true)
        if (i22 != i23)
        {
          localObject3 = str2;
          i16 = i15;
          i17 = n;
          i14 = i21;
          break;
          i22 = 0;
          break label1059;
          label1102: i23 = 0;
          continue;
          label1108: if ("#else".equals(str2))
          {
            if (i3 == 0)
            {
              error("unexpected " + str2);
              localObject3 = str2;
              i15 = k;
              i14 = i21;
              i16 = i3;
              i17 = i1;
              break;
            }
            if (i3 == k)
            {
              i16 = i3;
              i14 = i21;
              i17 = -1;
              localObject3 = str2;
              i15 = 0;
              break;
            }
            if (k != 0)
              break label1516;
            localObject3 = str2;
            i15 = i3;
            i16 = i3;
            i17 = n;
            i14 = i21;
            break;
          }
          int i26;
          int i27;
          if ("#endif".equals(str2))
          {
            if (i3 == 0)
              error("unexpected " + str2);
            if (i3 == k)
            {
              i26 = 0;
              i27 = -1;
            }
          }
          while (true)
          {
            i16 = i3 - 1;
            i17 = i27;
            i14 = i21;
            i15 = i26;
            localObject3 = str2;
            break label973;
            if (k > 0)
            {
              i26 = k;
              i27 = n;
              continue;
              error("unknown command: " + str1);
              localObject3 = str2;
              i15 = k;
              i14 = i21;
              i16 = i3;
              i17 = i1;
              break label973;
              label1366: if (j < 0)
              {
                if (i8 == 9);
                for (int i28 = 0xFFFFFFF8 & n + 8; ; i28 = n + 1)
                {
                  n = i28;
                  i = i7;
                  m = j;
                  break;
                }
              }
              i = i7;
              m = j;
              break label1020;
              localObject3 = localObject1;
              i14 = i2;
              i15 = k;
              i16 = i3;
              i17 = i1;
              break label973;
              label1446: i10 = i13;
              break label583;
              label1453: bool2 = true;
              i6 = j;
              break;
              label1463: i7 = i;
              i8 = i5;
              bool2 = bool1;
              i6 = j;
              break;
              label1482: bool2 = bool1;
              i6 = j;
              j = m;
              i7 = i;
              i8 = i5;
              break;
            }
            i26 = k;
            i27 = i1;
          }
          label1516: localObject3 = str2;
          i15 = k;
          i16 = i3;
          i17 = n;
          i14 = i21;
          break;
        }
      localObject3 = str2;
      i17 = i1;
      i14 = i21;
      int i24 = k;
      i16 = i15;
      i15 = i24;
    }
  }

  void handleArg(String paramString)
  {
    if (paramString.charAt(0) == '%')
    {
      String str3 = paramString.substring(1);
      for (int k = 0; ; k += 2)
      {
        if (k >= version_features.length)
        {
          System.err.println("Unknown version: " + str3);
          System.exit(-1);
        }
        if (str3.equals(version_features[k]))
        {
          String str4 = version_features[(k + 1)];
          System.err.println("(variant " + str3 + " maps to: " + str4 + ")");
          StringTokenizer localStringTokenizer = new StringTokenizer(str4);
          while (localStringTokenizer.hasMoreTokens())
            handleArg(localStringTokenizer.nextToken());
        }
      }
    }
    if (paramString.charAt(0) == '+')
    {
      this.keywords.put(paramString.substring(1), Boolean.TRUE);
      return;
    }
    if (paramString.charAt(0) == '-')
    {
      int i = paramString.indexOf('=');
      if (i > 1)
      {
        int j;
        String str1;
        String str2;
        Boolean localBoolean1;
        if (paramString.charAt(1) == '-')
        {
          j = 2;
          str1 = paramString.substring(j, i);
          str2 = paramString.substring(i + 1);
          localBoolean1 = Boolean.FALSE;
          if (!str2.equalsIgnoreCase("true"))
            break label280;
        }
        for (Boolean localBoolean2 = Boolean.TRUE; ; localBoolean2 = localBoolean1)
        {
          this.keywords.put(str1, localBoolean2);
          return;
          j = 1;
          break;
          label280: if (!str2.equalsIgnoreCase("false"))
          {
            System.err.println("invalid value " + str2 + " for " + str1);
            System.exit(-1);
          }
        }
      }
      this.keywords.put(paramString.substring(1), Boolean.FALSE);
      return;
    }
    try
    {
      filter(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      System.err.println("caught " + localThrowable);
      localThrowable.printStackTrace();
      System.exit(-1);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.PreProcess
 * JD-Core Version:    0.6.2
 */