package gnu.bytecode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class dump extends ClassFileInput
{
  ClassTypeWriter writer;

  dump(InputStream paramInputStream, ClassTypeWriter paramClassTypeWriter)
    throws IOException, ClassFormatError
  {
    super(paramInputStream);
    this.ctype = new ClassType();
    readFormatVersion();
    readConstants();
    readClassInfo();
    readFields();
    readMethods();
    readAttributes(this.ctype);
    paramClassTypeWriter.print(this.ctype);
    paramClassTypeWriter.flush();
  }

  // ERROR //
  public static void main(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: istore_1
    //   3: new 46	gnu/bytecode/ClassTypeWriter
    //   6: dup
    //   7: aconst_null
    //   8: getstatic 69	java/lang/System:out	Ljava/io/PrintStream;
    //   11: iconst_0
    //   12: invokespecial 72	gnu/bytecode/ClassTypeWriter:<init>	(Lgnu/bytecode/ClassType;Ljava/io/OutputStream;I)V
    //   15: astore_2
    //   16: iload_1
    //   17: ifne +9 -> 26
    //   20: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   23: invokestatic 79	gnu/bytecode/dump:usage	(Ljava/io/PrintStream;)V
    //   26: iconst_0
    //   27: istore_3
    //   28: iload_3
    //   29: iload_1
    //   30: if_icmpge +735 -> 765
    //   33: aload_0
    //   34: iload_3
    //   35: aaload
    //   36: astore 4
    //   38: aload 4
    //   40: ldc 81
    //   42: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifne +13 -> 58
    //   48: aload 4
    //   50: ldc 89
    //   52: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifeq +18 -> 73
    //   58: aload_2
    //   59: bipush 15
    //   61: invokevirtual 93	gnu/bytecode/ClassTypeWriter:setFlags	(I)V
    //   64: aload 4
    //   66: pop
    //   67: iinc 3 1
    //   70: goto -42 -> 28
    //   73: aload 4
    //   75: invokestatic 97	gnu/bytecode/dump:uriSchemeSpecified	(Ljava/lang/String;)Z
    //   78: ifeq +489 -> 567
    //   81: aload 4
    //   83: ldc 99
    //   85: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   88: istore 22
    //   90: iload 22
    //   92: ifeq +695 -> 787
    //   95: aload 4
    //   97: iconst_4
    //   98: invokevirtual 106	java/lang/String:substring	(I)Ljava/lang/String;
    //   101: astore 23
    //   103: aload 23
    //   105: invokestatic 97	gnu/bytecode/dump:uriSchemeSpecified	(Ljava/lang/String;)Z
    //   108: ifne +75 -> 183
    //   111: aload 23
    //   113: bipush 33
    //   115: invokevirtual 110	java/lang/String:indexOf	(I)I
    //   118: istore 41
    //   120: iload 41
    //   122: iflt +61 -> 183
    //   125: new 112	java/io/File
    //   128: dup
    //   129: aload 23
    //   131: iconst_0
    //   132: iload 41
    //   134: invokevirtual 115	java/lang/String:substring	(II)Ljava/lang/String;
    //   137: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   140: invokevirtual 122	java/io/File:toURI	()Ljava/net/URI;
    //   143: invokevirtual 128	java/net/URI:toURL	()Ljava/net/URL;
    //   146: invokevirtual 134	java/net/URL:toString	()Ljava/lang/String;
    //   149: astore 42
    //   151: new 136	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   158: ldc 99
    //   160: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 42
    //   165: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 23
    //   170: iload 41
    //   172: invokevirtual 106	java/lang/String:substring	(I)Ljava/lang/String;
    //   175: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: astore 4
    //   183: aload 23
    //   185: ldc 144
    //   187: invokevirtual 147	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   190: ifge +597 -> 787
    //   193: aload 4
    //   195: bipush 33
    //   197: invokevirtual 150	java/lang/String:lastIndexOf	(I)I
    //   200: istore 38
    //   202: iload 38
    //   204: ifgt +95 -> 299
    //   207: aload 4
    //   209: astore 24
    //   211: iconst_0
    //   212: istore 25
    //   214: new 130	java/net/URL
    //   217: dup
    //   218: aload 24
    //   220: invokespecial 151	java/net/URL:<init>	(Ljava/lang/String;)V
    //   223: astore 26
    //   225: aload 26
    //   227: invokevirtual 155	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   230: invokevirtual 161	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   233: astore 37
    //   235: aload 37
    //   237: astore 28
    //   239: aload 28
    //   241: astore 8
    //   243: aload 24
    //   245: astore 7
    //   247: aload 8
    //   249: aload 7
    //   251: aload_2
    //   252: invokestatic 165	gnu/bytecode/dump:process	(Ljava/io/InputStream;Ljava/lang/String;Lgnu/bytecode/ClassTypeWriter;)V
    //   255: goto -188 -> 67
    //   258: astore 9
    //   260: aload 7
    //   262: astore 4
    //   264: aload 9
    //   266: astore 10
    //   268: aload 10
    //   270: invokevirtual 168	java/io/IOException:printStackTrace	()V
    //   273: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   276: ldc 170
    //   278: invokevirtual 175	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   281: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   284: aload 10
    //   286: invokevirtual 178	java/io/PrintStream:print	(Ljava/lang/Object;)V
    //   289: iconst_m1
    //   290: invokestatic 181	java/lang/System:exit	(I)V
    //   293: aload 4
    //   295: pop
    //   296: goto -229 -> 67
    //   299: aload 4
    //   301: bipush 47
    //   303: iload 38
    //   305: invokevirtual 184	java/lang/String:indexOf	(II)I
    //   308: ifge +479 -> 787
    //   311: aload 4
    //   313: iload 38
    //   315: iconst_1
    //   316: iadd
    //   317: invokevirtual 106	java/lang/String:substring	(I)Ljava/lang/String;
    //   320: bipush 46
    //   322: bipush 47
    //   324: invokevirtual 188	java/lang/String:replace	(CC)Ljava/lang/String;
    //   327: astore 39
    //   329: new 136	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   336: aload 4
    //   338: iconst_0
    //   339: iload 38
    //   341: iconst_1
    //   342: iadd
    //   343: invokevirtual 115	java/lang/String:substring	(II)Ljava/lang/String;
    //   346: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: bipush 47
    //   351: invokevirtual 191	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   354: aload 39
    //   356: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc 193
    //   361: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: astore 40
    //   369: iload 22
    //   371: istore 25
    //   373: aload 40
    //   375: astore 24
    //   377: goto -163 -> 214
    //   380: astore 29
    //   382: iload 25
    //   384: ifeq +54 -> 438
    //   387: aload 26
    //   389: invokevirtual 196	java/net/URL:getFile	()Ljava/lang/String;
    //   392: astore 31
    //   394: aload 31
    //   396: bipush 33
    //   398: invokevirtual 150	java/lang/String:lastIndexOf	(I)I
    //   401: istore 32
    //   403: iload 32
    //   405: ifle +375 -> 780
    //   408: aload 31
    //   410: iconst_0
    //   411: iload 32
    //   413: invokevirtual 115	java/lang/String:substring	(II)Ljava/lang/String;
    //   416: astore 33
    //   418: aload 33
    //   420: astore 34
    //   422: new 130	java/net/URL
    //   425: dup
    //   426: aload 34
    //   428: invokespecial 151	java/net/URL:<init>	(Ljava/lang/String;)V
    //   431: invokevirtual 155	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   434: invokevirtual 161	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   437: pop
    //   438: aload 29
    //   440: athrow
    //   441: astore 27
    //   443: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   446: ldc 198
    //   448: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   451: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   454: aload 24
    //   456: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   459: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   462: ldc 202
    //   464: invokevirtual 175	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   467: iconst_m1
    //   468: invokestatic 181	java/lang/System:exit	(I)V
    //   471: aconst_null
    //   472: astore 28
    //   474: goto -235 -> 239
    //   477: astore 35
    //   479: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   482: ldc 204
    //   484: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   487: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   490: aload 34
    //   492: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   495: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   498: ldc 202
    //   500: invokevirtual 175	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   503: iconst_m1
    //   504: invokestatic 181	java/lang/System:exit	(I)V
    //   507: goto -69 -> 438
    //   510: astore 30
    //   512: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   515: ldc 206
    //   517: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   520: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   523: aload 24
    //   525: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   528: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   531: ldc 202
    //   533: invokevirtual 175	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   536: aload 30
    //   538: invokevirtual 207	java/util/zip/ZipException:printStackTrace	()V
    //   541: aload 30
    //   543: invokevirtual 211	java/util/zip/ZipException:getCause	()Ljava/lang/Throwable;
    //   546: ifnull +11 -> 557
    //   549: aload 30
    //   551: invokevirtual 211	java/util/zip/ZipException:getCause	()Ljava/lang/Throwable;
    //   554: invokevirtual 212	java/lang/Throwable:printStackTrace	()V
    //   557: iconst_m1
    //   558: invokestatic 181	java/lang/System:exit	(I)V
    //   561: aconst_null
    //   562: astore 28
    //   564: goto -325 -> 239
    //   567: new 214	java/io/FileInputStream
    //   570: dup
    //   571: aload 4
    //   573: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   576: astore 6
    //   578: aload 4
    //   580: astore 7
    //   582: aload 6
    //   584: astore 8
    //   586: goto -339 -> 247
    //   589: astore 12
    //   591: aload 4
    //   593: invokestatic 221	gnu/bytecode/ObjectType:getContextClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   596: invokevirtual 227	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   599: astore 21
    //   601: aload 21
    //   603: astore 14
    //   605: new 136	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   612: aload 4
    //   614: bipush 46
    //   616: bipush 47
    //   618: invokevirtual 188	java/lang/String:replace	(CC)Ljava/lang/String;
    //   621: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: ldc 193
    //   626: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: astore 15
    //   634: aload 14
    //   636: aload 15
    //   638: invokevirtual 233	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   641: astore 17
    //   643: aload 17
    //   645: invokevirtual 155	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   648: invokevirtual 161	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   651: astore 18
    //   653: aload 17
    //   655: invokevirtual 134	java/net/URL:toString	()Ljava/lang/String;
    //   658: astore 19
    //   660: aload 19
    //   662: astore 7
    //   664: aload 18
    //   666: astore 8
    //   668: goto -421 -> 247
    //   671: astore 20
    //   673: invokestatic 236	gnu/bytecode/ObjectType:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   676: astore 14
    //   678: goto -73 -> 605
    //   681: astore 13
    //   683: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   686: ldc 238
    //   688: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   691: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   694: aload 4
    //   696: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   699: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   702: ldc 202
    //   704: invokevirtual 175	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   707: iconst_m1
    //   708: invokestatic 181	java/lang/System:exit	(I)V
    //   711: aconst_null
    //   712: astore 14
    //   714: goto -109 -> 605
    //   717: astore 16
    //   719: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   722: ldc 240
    //   724: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   727: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   730: aload 4
    //   732: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   735: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   738: ldc 242
    //   740: invokevirtual 200	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   743: getstatic 75	java/lang/System:err	Ljava/io/PrintStream;
    //   746: aload 16
    //   748: invokevirtual 244	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   751: iconst_m1
    //   752: invokestatic 181	java/lang/System:exit	(I)V
    //   755: aload 4
    //   757: astore 7
    //   759: aconst_null
    //   760: astore 8
    //   762: goto -515 -> 247
    //   765: return
    //   766: astore 10
    //   768: goto -500 -> 268
    //   771: astore 10
    //   773: aload 24
    //   775: astore 4
    //   777: goto -509 -> 268
    //   780: aload 31
    //   782: astore 34
    //   784: goto -362 -> 422
    //   787: aload 4
    //   789: astore 24
    //   791: iload 22
    //   793: istore 25
    //   795: goto -581 -> 214
    //
    // Exception table:
    //   from	to	target	type
    //   247	255	258	java/io/IOException
    //   225	235	380	java/util/zip/ZipException
    //   214	225	441	java/io/FileNotFoundException
    //   225	235	441	java/io/FileNotFoundException
    //   387	403	441	java/io/FileNotFoundException
    //   408	418	441	java/io/FileNotFoundException
    //   438	441	441	java/io/FileNotFoundException
    //   479	507	441	java/io/FileNotFoundException
    //   422	438	477	java/io/FileNotFoundException
    //   214	225	510	java/util/zip/ZipException
    //   387	403	510	java/util/zip/ZipException
    //   408	418	510	java/util/zip/ZipException
    //   422	438	510	java/util/zip/ZipException
    //   438	441	510	java/util/zip/ZipException
    //   479	507	510	java/util/zip/ZipException
    //   567	578	589	java/io/FileNotFoundException
    //   591	601	671	java/lang/NoClassDefFoundError
    //   591	601	681	java/lang/Throwable
    //   634	660	717	java/lang/Throwable
    //   81	90	766	java/io/IOException
    //   95	120	766	java/io/IOException
    //   125	183	766	java/io/IOException
    //   183	202	766	java/io/IOException
    //   299	369	766	java/io/IOException
    //   567	578	766	java/io/IOException
    //   591	601	766	java/io/IOException
    //   605	634	766	java/io/IOException
    //   634	660	766	java/io/IOException
    //   673	678	766	java/io/IOException
    //   683	711	766	java/io/IOException
    //   719	755	766	java/io/IOException
    //   214	225	771	java/io/IOException
    //   225	235	771	java/io/IOException
    //   387	403	771	java/io/IOException
    //   408	418	771	java/io/IOException
    //   422	438	771	java/io/IOException
    //   438	441	771	java/io/IOException
    //   443	471	771	java/io/IOException
    //   479	507	771	java/io/IOException
    //   512	557	771	java/io/IOException
    //   557	561	771	java/io/IOException
  }

  public static void process(InputStream paramInputStream, String paramString, ClassTypeWriter paramClassTypeWriter)
    throws IOException
  {
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(paramInputStream);
    localBufferedInputStream.mark(5);
    int i = readMagic(localBufferedInputStream);
    if (i == -889275714)
    {
      paramClassTypeWriter.print("Reading .class from ");
      paramClassTypeWriter.print(paramString);
      paramClassTypeWriter.println('.');
      new dump(localBufferedInputStream, paramClassTypeWriter);
      return;
    }
    if (i == 1347093252)
    {
      localBufferedInputStream.reset();
      paramClassTypeWriter.print("Reading classes from archive ");
      paramClassTypeWriter.print(paramString);
      paramClassTypeWriter.println('.');
      ZipInputStream localZipInputStream = new ZipInputStream(localBufferedInputStream);
      while (true)
      {
        ZipEntry localZipEntry = localZipInputStream.getNextEntry();
        if (localZipEntry == null)
          break;
        String str = localZipEntry.getName();
        if (localZipEntry.isDirectory())
        {
          paramClassTypeWriter.print("Archive directory: ");
          paramClassTypeWriter.print(str);
          paramClassTypeWriter.println('.');
        }
        else
        {
          paramClassTypeWriter.println();
          if (readMagic(localZipInputStream) == -889275714)
          {
            paramClassTypeWriter.print("Reading class member: ");
            paramClassTypeWriter.print(str);
            paramClassTypeWriter.println('.');
            new dump(localZipInputStream, paramClassTypeWriter);
          }
          else
          {
            paramClassTypeWriter.print("Skipping non-class member: ");
            paramClassTypeWriter.print(str);
            paramClassTypeWriter.println('.');
          }
        }
      }
      System.exit(-1);
      return;
    }
    System.err.println("File " + paramString + " is not a valid .class file");
    System.exit(-1);
  }

  public static void process(InputStream paramInputStream, String paramString, OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    process(paramInputStream, paramString, new ClassTypeWriter(null, paramOutputStream, paramInt));
  }

  public static void process(InputStream paramInputStream, String paramString, Writer paramWriter, int paramInt)
    throws IOException
  {
    process(paramInputStream, paramString, new ClassTypeWriter(null, paramWriter, paramInt));
  }

  static int readMagic(InputStream paramInputStream)
    throws IOException
  {
    int i = 0;
    for (int j = 0; ; j++)
    {
      int k;
      if (j < 4)
      {
        k = paramInputStream.read();
        if (k >= 0);
      }
      else
      {
        return i;
      }
      i = i << 8 | k & 0xFF;
    }
  }

  static int uriSchemeLength(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      char c = paramString.charAt(j);
      if (c == ':')
        return j;
      if (j == 0)
      {
        if (Character.isLetter(c));
      }
      else
        while ((!Character.isLetterOrDigit(c)) && (c != '+') && (c != '-') && (c != '.'))
          return -1;
    }
    return -1;
  }

  static boolean uriSchemeSpecified(String paramString)
  {
    int i = uriSchemeLength(paramString);
    if ((i == 1) && (File.separatorChar == '\\'))
    {
      int j = paramString.charAt(0);
      return ((j < 97) || (j > 122)) && ((j < 65) || (j > 90));
    }
    return i > 0;
  }

  public static void usage(PrintStream paramPrintStream)
  {
    paramPrintStream.println("Prints and dis-assembles the contents of JVM .class files.");
    paramPrintStream.println("Usage: [--verbose] class-or-jar ...");
    paramPrintStream.println("where a class-or-jar can be one of:");
    paramPrintStream.println("- a fully-qualified class name; or");
    paramPrintStream.println("- the name of a .class file, or a URL reference to one; or");
    paramPrintStream.println("- the name of a .jar or .zip archive file, or a URL reference to one.");
    paramPrintStream.println("If a .jar/.zip archive is named, all its.class file members are printed.");
    paramPrintStream.println();
    paramPrintStream.println("You can name a single .class member of an archive with a jar: URL,");
    paramPrintStream.println("which looks like: jar:jar-spec!/p1/p2/cl.class");
    paramPrintStream.println("The jar-spec can be a URL or the name of the .jar file.");
    paramPrintStream.println("You can also use the shorthand syntax: jar:jar-spec!p1.p2.cl");
    System.exit(-1);
  }

  public Attribute readAttribute(String paramString, int paramInt, AttrContainer paramAttrContainer)
    throws IOException
  {
    return super.readAttribute(paramString, paramInt, paramAttrContainer);
  }

  public ConstantPool readConstants()
    throws IOException
  {
    this.ctype.constants = super.readConstants();
    return this.ctype.constants;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.dump
 * JD-Core Version:    0.6.2
 */