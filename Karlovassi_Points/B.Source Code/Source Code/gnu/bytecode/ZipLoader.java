package gnu.bytecode;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipLoader extends ClassLoader
{
  private Vector<Object> loadedClasses;
  int size;
  ZipFile zar;
  private String zipname;

  public ZipLoader(String paramString)
    throws IOException
  {
    this.zipname = paramString;
    this.zar = new ZipFile(paramString);
    this.size = 0;
    Enumeration localEnumeration = this.zar.entries();
    while (localEnumeration.hasMoreElements())
      if (!((ZipEntry)localEnumeration.nextElement()).isDirectory())
        this.size = (1 + this.size);
    this.loadedClasses = new Vector(this.size);
  }

  public void close()
    throws IOException
  {
    if (this.zar != null)
      this.zar.close();
    this.zar = null;
  }

  public Class loadAllClasses()
    throws IOException
  {
    Enumeration localEnumeration = this.zar.entries();
    Object localObject = null;
    while (localEnumeration.hasMoreElements())
    {
      ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
      String str1 = localZipEntry.getName().replace('/', '.');
      String str2 = str1.substring(0, str1.length() - "/class".length());
      int i = (int)localZipEntry.getSize();
      InputStream localInputStream = this.zar.getInputStream(localZipEntry);
      byte[] arrayOfByte = new byte[i];
      new DataInputStream(localInputStream).readFully(arrayOfByte);
      Class localClass = defineClass(str2, arrayOfByte, 0, i);
      if (localObject == null)
        localObject = localClass;
      this.loadedClasses.addElement(str2);
      this.loadedClasses.addElement(localClass);
    }
    close();
    return localObject;
  }

  // ERROR //
  public Class loadClass(String paramString, boolean paramBoolean)
    throws java.lang.ClassNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	gnu/bytecode/ZipLoader:loadedClasses	Ljava/util/Vector;
    //   4: aload_1
    //   5: invokevirtual 115	java/util/Vector:indexOf	(Ljava/lang/Object;)I
    //   8: istore_3
    //   9: iload_3
    //   10: iflt +31 -> 41
    //   13: aload_0
    //   14: getfield 56	gnu/bytecode/ZipLoader:loadedClasses	Ljava/util/Vector;
    //   17: iload_3
    //   18: iconst_1
    //   19: iadd
    //   20: invokevirtual 119	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   23: checkcast 121	java/lang/Class
    //   26: astore 12
    //   28: iload_2
    //   29: ifeq +9 -> 38
    //   32: aload_0
    //   33: aload 12
    //   35: invokevirtual 125	gnu/bytecode/ZipLoader:resolveClass	(Ljava/lang/Class;)V
    //   38: aload 12
    //   40: areturn
    //   41: aload_0
    //   42: getfield 28	gnu/bytecode/ZipLoader:zar	Ljava/util/zip/ZipFile;
    //   45: ifnonnull +28 -> 73
    //   48: aload_0
    //   49: getfield 56	gnu/bytecode/ZipLoader:loadedClasses	Ljava/util/Vector;
    //   52: invokevirtual 127	java/util/Vector:size	()I
    //   55: iconst_2
    //   56: aload_0
    //   57: getfield 30	gnu/bytecode/ZipLoader:size	I
    //   60: imul
    //   61: if_icmpne +12 -> 73
    //   64: aload_1
    //   65: invokestatic 131	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   68: astore 12
    //   70: goto -42 -> 28
    //   73: new 133	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   80: aload_1
    //   81: bipush 46
    //   83: bipush 47
    //   85: invokevirtual 71	java/lang/String:replace	(CC)Ljava/lang/String;
    //   88: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 140
    //   93: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 4
    //   101: aload_0
    //   102: getfield 28	gnu/bytecode/ZipLoader:zar	Ljava/util/zip/ZipFile;
    //   105: astore 5
    //   107: iconst_0
    //   108: istore 6
    //   110: aload 5
    //   112: ifnonnull +21 -> 133
    //   115: aload_0
    //   116: new 24	java/util/zip/ZipFile
    //   119: dup
    //   120: aload_0
    //   121: getfield 22	gnu/bytecode/ZipLoader:zipname	Ljava/lang/String;
    //   124: invokespecial 26	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   127: putfield 28	gnu/bytecode/ZipLoader:zar	Ljava/util/zip/ZipFile;
    //   130: iconst_1
    //   131: istore 6
    //   133: aload_0
    //   134: getfield 28	gnu/bytecode/ZipLoader:zar	Ljava/util/zip/ZipFile;
    //   137: aload 4
    //   139: invokevirtual 147	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   142: astore 7
    //   144: aload 7
    //   146: ifnonnull +110 -> 256
    //   149: iload 6
    //   151: ifeq +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 107	gnu/bytecode/ZipLoader:close	()V
    //   158: aload_1
    //   159: invokestatic 131	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   162: astore 12
    //   164: goto -136 -> 28
    //   167: astore 14
    //   169: new 111	java/lang/ClassNotFoundException
    //   172: dup
    //   173: new 133	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   180: ldc 149
    //   182: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 4
    //   187: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 151
    //   192: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_1
    //   196: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 153
    //   201: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 14
    //   206: invokevirtual 154	java/io/IOException:toString	()Ljava/lang/String;
    //   209: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokespecial 155	java/lang/ClassNotFoundException:<init>	(Ljava/lang/String;)V
    //   218: athrow
    //   219: astore 13
    //   221: new 157	java/lang/RuntimeException
    //   224: dup
    //   225: new 133	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   232: ldc 159
    //   234: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 22	gnu/bytecode/ZipLoader:zipname	Ljava/lang/String;
    //   241: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc 161
    //   246: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokespecial 162	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   255: athrow
    //   256: aload 7
    //   258: invokevirtual 85	java/util/zip/ZipEntry:getSize	()J
    //   261: l2i
    //   262: istore 9
    //   264: aload_0
    //   265: getfield 28	gnu/bytecode/ZipLoader:zar	Ljava/util/zip/ZipFile;
    //   268: aload 7
    //   270: invokevirtual 89	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   273: astore 10
    //   275: iload 9
    //   277: newarray byte
    //   279: astore 11
    //   281: new 91	java/io/DataInputStream
    //   284: dup
    //   285: aload 10
    //   287: invokespecial 94	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   290: aload 11
    //   292: invokevirtual 98	java/io/DataInputStream:readFully	([B)V
    //   295: aload_0
    //   296: aload_1
    //   297: aload 11
    //   299: iconst_0
    //   300: iload 9
    //   302: invokevirtual 102	gnu/bytecode/ZipLoader:defineClass	(Ljava/lang/String;[BII)Ljava/lang/Class;
    //   305: astore 12
    //   307: aload_0
    //   308: getfield 56	gnu/bytecode/ZipLoader:loadedClasses	Ljava/util/Vector;
    //   311: aload_1
    //   312: invokevirtual 106	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   315: aload_0
    //   316: getfield 56	gnu/bytecode/ZipLoader:loadedClasses	Ljava/util/Vector;
    //   319: aload 12
    //   321: invokevirtual 106	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   324: iconst_2
    //   325: aload_0
    //   326: getfield 30	gnu/bytecode/ZipLoader:size	I
    //   329: imul
    //   330: aload_0
    //   331: getfield 56	gnu/bytecode/ZipLoader:loadedClasses	Ljava/util/Vector;
    //   334: invokevirtual 127	java/util/Vector:size	()I
    //   337: if_icmpne -309 -> 28
    //   340: aload_0
    //   341: invokevirtual 107	gnu/bytecode/ZipLoader:close	()V
    //   344: goto -316 -> 28
    //   347: astore 8
    //   349: new 111	java/lang/ClassNotFoundException
    //   352: dup
    //   353: new 133	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   360: ldc 149
    //   362: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 4
    //   367: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: ldc 151
    //   372: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_1
    //   376: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: ldc 153
    //   381: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 8
    //   386: invokevirtual 154	java/io/IOException:toString	()Ljava/lang/String;
    //   389: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokespecial 155	java/lang/ClassNotFoundException:<init>	(Ljava/lang/String;)V
    //   398: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   115	130	167	java/io/IOException
    //   154	158	219	java/io/IOException
    //   256	344	347	java/io/IOException
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ZipLoader
 * JD-Core Version:    0.6.2
 */