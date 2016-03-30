package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.FileUtils;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.IsEqual;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.text.FilePath;
import gnu.text.Path;
import gnu.text.URIPath;
import java.io.File;
import java.io.IOException;
import kawa.standard.readchar;

public class files extends ModuleBody
{
  public static final ModuleMethod $Mn$Grpathname;
  public static final ModuleMethod $Pcfile$Mnseparator;
  public static final files $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29 = (SimpleSymbol)new SimpleSymbol("make-temporary-file").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod URI$Qu;
  public static final ModuleMethod absolute$Mnpath$Qu;
  public static final ModuleMethod copy$Mnfile;
  public static final ModuleMethod create$Mndirectory;
  public static final ModuleMethod delete$Mnfile;
  public static final ModuleMethod directory$Mnfiles;
  public static final ModuleMethod file$Mndirectory$Qu;
  public static final ModuleMethod file$Mnexists$Qu;
  public static final ModuleMethod file$Mnreadable$Qu;
  public static final ModuleMethod file$Mnwritable$Qu;
  public static final ModuleMethod filepath$Qu;
  public static final ModuleMethod make$Mntemporary$Mnfile;
  public static final ModuleMethod path$Mnauthority;
  public static final ModuleMethod path$Mndirectory;
  public static final ModuleMethod path$Mnextension;
  public static final ModuleMethod path$Mnfile;
  public static final ModuleMethod path$Mnfragment;
  public static final ModuleMethod path$Mnhost;
  public static final ModuleMethod path$Mnlast;
  public static final ModuleMethod path$Mnparent;
  public static final ModuleMethod path$Mnport;
  public static final ModuleMethod path$Mnquery;
  public static final ModuleMethod path$Mnscheme;
  public static final ModuleMethod path$Mnuser$Mninfo;
  public static final ModuleMethod path$Qu;
  public static final ModuleMethod rename$Mnfile;
  public static final ModuleMethod resolve$Mnuri;
  public static final ModuleMethod system$Mntmpdir;

  public static String $PcFileSeparator()
  {
    return System.getProperty("file.separator");
  }

  public static Path $To$Pathname(Object paramObject)
  {
    return Path.valueOf(paramObject);
  }

  static
  {
    Lit28 = (SimpleSymbol)new SimpleSymbol("resolve-uri").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("system-tmpdir").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("%file-separator").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("->pathname").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("directory-files").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("create-directory").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("copy-file").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("rename-file").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("delete-file").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("file-writable?").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("file-readable?").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("file-directory?").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("file-exists?").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("path-fragment").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("path-query").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("path-port").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("path-extension").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("path-last").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("path-parent").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("path-directory").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("path-file").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("path-host").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("path-user-info").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("path-authority").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("path-scheme").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("absolute-path?").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("URI?").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("filepath?").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("path?").readResolve();
    $instance = new files();
    files localfiles = $instance;
    path$Qu = new ModuleMethod(localfiles, 1, Lit0, 4097);
    filepath$Qu = new ModuleMethod(localfiles, 2, Lit1, 4097);
    URI$Qu = new ModuleMethod(localfiles, 3, Lit2, 4097);
    absolute$Mnpath$Qu = new ModuleMethod(localfiles, 4, Lit3, 4097);
    path$Mnscheme = new ModuleMethod(localfiles, 5, Lit4, 4097);
    path$Mnauthority = new ModuleMethod(localfiles, 6, Lit5, 4097);
    path$Mnuser$Mninfo = new ModuleMethod(localfiles, 7, Lit6, 4097);
    path$Mnhost = new ModuleMethod(localfiles, 8, Lit7, 4097);
    path$Mnfile = new ModuleMethod(localfiles, 9, Lit8, 4097);
    path$Mndirectory = new ModuleMethod(localfiles, 10, Lit9, 4097);
    path$Mnparent = new ModuleMethod(localfiles, 11, Lit10, 4097);
    path$Mnlast = new ModuleMethod(localfiles, 12, Lit11, 4097);
    path$Mnextension = new ModuleMethod(localfiles, 13, Lit12, 4097);
    path$Mnport = new ModuleMethod(localfiles, 14, Lit13, 4097);
    path$Mnquery = new ModuleMethod(localfiles, 15, Lit14, 4097);
    path$Mnfragment = new ModuleMethod(localfiles, 16, Lit15, 4097);
    file$Mnexists$Qu = new ModuleMethod(localfiles, 17, Lit16, 4097);
    file$Mndirectory$Qu = new ModuleMethod(localfiles, 18, Lit17, 4097);
    file$Mnreadable$Qu = new ModuleMethod(localfiles, 19, Lit18, 4097);
    file$Mnwritable$Qu = new ModuleMethod(localfiles, 20, Lit19, 4097);
    delete$Mnfile = new ModuleMethod(localfiles, 21, Lit20, 4097);
    rename$Mnfile = new ModuleMethod(localfiles, 22, Lit21, 8194);
    copy$Mnfile = new ModuleMethod(localfiles, 23, Lit22, 8194);
    create$Mndirectory = new ModuleMethod(localfiles, 24, Lit23, 4097);
    directory$Mnfiles = new ModuleMethod(localfiles, 25, Lit24, 4097);
    $Mn$Grpathname = new ModuleMethod(localfiles, 26, Lit25, 4097);
    $Pcfile$Mnseparator = new ModuleMethod(localfiles, 27, Lit26, 0);
    system$Mntmpdir = new ModuleMethod(localfiles, 28, Lit27, 0);
    resolve$Mnuri = new ModuleMethod(localfiles, 29, Lit28, 8194);
    make$Mntemporary$Mnfile = new ModuleMethod(localfiles, 30, Lit29, 4096);
    $instance.run();
  }

  public files()
  {
    ModuleInfo.register(this);
  }

  public static boolean URI$Qu(Object paramObject)
  {
    return paramObject instanceof URIPath;
  }

  public static void copyFile(Path paramPath1, Path paramPath2)
  {
    InPort localInPort = ports.openInputFile(paramPath1);
    OutPort localOutPort = ports.openOutputFile(paramPath2);
    for (Object localObject = readchar.readChar.apply1(localInPort); !ports.isEofObject(localObject); localObject = readchar.readChar.apply1(localInPort))
      ports.writeChar(localObject, localOutPort);
    ports.closeOutputPort(localOutPort);
    ports.closeInputPort(localInPort);
  }

  public static boolean createDirectory(FilePath paramFilePath)
  {
    return paramFilePath.toFile().mkdir();
  }

  public static void deleteFile(FilePath paramFilePath)
  {
    if (!paramFilePath.delete())
      throw ((Throwable)new IOException(Format.formatToString(0, new Object[] { "cannot delete ~a", paramFilePath }).toString()));
  }

  public static Object directoryFiles(FilePath paramFilePath)
  {
    File localFile = paramFilePath.toFile();
    if (localFile == null);
    String[] arrayOfString;
    for (String str = null; ; str = localFile.toString())
    {
      arrayOfString = new File(str).list();
      if (arrayOfString != null)
        break;
      return Boolean.FALSE;
    }
    return LList.makeList(arrayOfString, 0);
  }

  public static boolean isAbsolutePath(Path paramPath)
  {
    return paramPath.isAbsolute();
  }

  public static boolean isFileDirectory(Path paramPath)
  {
    return paramPath.isDirectory();
  }

  public static boolean isFileExists(Path paramPath)
  {
    return paramPath.exists();
  }

  public static boolean isFileReadable(FilePath paramFilePath)
  {
    return paramFilePath.toFile().canRead();
  }

  public static boolean isFileWritable(FilePath paramFilePath)
  {
    return paramFilePath.toFile().canWrite();
  }

  public static boolean isFilepath(Object paramObject)
  {
    return paramObject instanceof FilePath;
  }

  public static boolean isPath(Object paramObject)
  {
    return paramObject instanceof Path;
  }

  public static FilePath makeTemporaryFile()
  {
    return makeTemporaryFile("kawa~d.tmp");
  }

  public static FilePath makeTemporaryFile(CharSequence paramCharSequence)
  {
    return FilePath.makeFilePath(FileUtils.createTempFile(paramCharSequence.toString()));
  }

  public static Object pathAuthority(Path paramPath)
  {
    String str = paramPath.getAuthority();
    if (str == null)
      return Boolean.FALSE;
    return str;
  }

  public static Object pathDirectory(Path paramPath)
  {
    Path localPath = paramPath.getDirectory();
    if (localPath == null)
      return Boolean.FALSE;
    return localPath.toString();
  }

  public static Object pathExtension(Path paramPath)
  {
    String str = paramPath.getExtension();
    if (str == null)
      return Boolean.FALSE;
    return str;
  }

  public static Object pathFile(Path paramPath)
  {
    String str = paramPath.getPath();
    if (str == null)
      return Boolean.FALSE;
    return str;
  }

  public static Object pathFragment(Path paramPath)
  {
    String str = paramPath.getFragment();
    if (str == null)
      return Boolean.FALSE;
    return str;
  }

  public static String pathHost(Path paramPath)
  {
    return paramPath.getHost();
  }

  public static Object pathLast(Path paramPath)
  {
    String str = paramPath.getLast();
    if (str == null)
      return Boolean.FALSE;
    return str;
  }

  public static Object pathParent(Path paramPath)
  {
    Path localPath = paramPath.getParent();
    if (localPath == null)
      return Boolean.FALSE;
    return localPath.toString();
  }

  public static int pathPort(Path paramPath)
  {
    return paramPath.getPort();
  }

  public static Object pathQuery(Path paramPath)
  {
    String str = paramPath.getQuery();
    if (str == null)
      return Boolean.FALSE;
    return str;
  }

  public static Object pathScheme(Path paramPath)
  {
    String str = paramPath.getScheme();
    if (str == null)
      return Boolean.FALSE;
    return str;
  }

  public static Object pathUserInfo(Path paramPath)
  {
    String str = paramPath.getUserInfo();
    if (str == null)
      return Boolean.FALSE;
    return str;
  }

  public static boolean renameFile(FilePath paramFilePath1, FilePath paramFilePath2)
  {
    return paramFilePath1.toFile().renameTo(paramFilePath2.toFile());
  }

  public static Path resolveUri(Path paramPath1, Path paramPath2)
  {
    return paramPath2.resolve(paramPath1);
  }

  public static String systemTmpdir()
  {
    String str = System.getProperty("java.io.tmpdir");
    if (str != null)
      return str;
    if (IsEqual.apply($PcFileSeparator(), "\\"))
      return "C:\\temp";
    return "/tmp";
  }

  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    case 29:
    default:
      return super.apply0(paramModuleMethod);
    case 27:
      return $PcFileSeparator();
    case 28:
      return systemTmpdir();
    case 30:
    }
    return makeTemporaryFile();
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 529	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+136 -> 140, 1:+143->147, 2:+158->162, 3:+173->177, 4:+188->192, 5:+210->214, 6:+222->226, 7:+234->238, 8:+246->250, 9:+258->262, 10:+270->274, 11:+282->286, 12:+294->298, 13:+306->310, 14:+318->322, 15:+333->337, 16:+345->349, 17:+357->361, 18:+379->383, 19:+401->405, 20:+423->427, 21:+445->449, 22:+136->140, 23:+136->140, 24:+460->464, 25:+482->486, 26:+494->498, 27:+136->140, 28:+136->140, 29:+136->140, 30:+499->503
    //   141: aload_1
    //   142: aload_2
    //   143: invokespecial 540	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: areturn
    //   147: aload_2
    //   148: invokestatic 542	kawa/lib/files:isPath	(Ljava/lang/Object;)Z
    //   151: ifeq +7 -> 158
    //   154: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   157: areturn
    //   158: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   161: areturn
    //   162: aload_2
    //   163: invokestatic 547	kawa/lib/files:isFilepath	(Ljava/lang/Object;)Z
    //   166: ifeq +7 -> 173
    //   169: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   172: areturn
    //   173: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   176: areturn
    //   177: aload_2
    //   178: invokestatic 549	kawa/lib/files:URI$Qu	(Ljava/lang/Object;)Z
    //   181: ifeq +7 -> 188
    //   184: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   187: areturn
    //   188: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   191: areturn
    //   192: aload_2
    //   193: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   196: astore 44
    //   198: aload 44
    //   200: invokestatic 551	kawa/lib/files:isAbsolutePath	(Lgnu/text/Path;)Z
    //   203: ifeq +7 -> 210
    //   206: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   209: areturn
    //   210: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   213: areturn
    //   214: aload_2
    //   215: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   218: astore 42
    //   220: aload 42
    //   222: invokestatic 553	kawa/lib/files:pathScheme	(Lgnu/text/Path;)Ljava/lang/Object;
    //   225: areturn
    //   226: aload_2
    //   227: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   230: astore 40
    //   232: aload 40
    //   234: invokestatic 555	kawa/lib/files:pathAuthority	(Lgnu/text/Path;)Ljava/lang/Object;
    //   237: areturn
    //   238: aload_2
    //   239: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   242: astore 38
    //   244: aload 38
    //   246: invokestatic 557	kawa/lib/files:pathUserInfo	(Lgnu/text/Path;)Ljava/lang/Object;
    //   249: areturn
    //   250: aload_2
    //   251: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   254: astore 36
    //   256: aload 36
    //   258: invokestatic 559	kawa/lib/files:pathHost	(Lgnu/text/Path;)Ljava/lang/String;
    //   261: areturn
    //   262: aload_2
    //   263: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   266: astore 34
    //   268: aload 34
    //   270: invokestatic 561	kawa/lib/files:pathFile	(Lgnu/text/Path;)Ljava/lang/Object;
    //   273: areturn
    //   274: aload_2
    //   275: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   278: astore 32
    //   280: aload 32
    //   282: invokestatic 563	kawa/lib/files:pathDirectory	(Lgnu/text/Path;)Ljava/lang/Object;
    //   285: areturn
    //   286: aload_2
    //   287: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   290: astore 30
    //   292: aload 30
    //   294: invokestatic 565	kawa/lib/files:pathParent	(Lgnu/text/Path;)Ljava/lang/Object;
    //   297: areturn
    //   298: aload_2
    //   299: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   302: astore 28
    //   304: aload 28
    //   306: invokestatic 567	kawa/lib/files:pathLast	(Lgnu/text/Path;)Ljava/lang/Object;
    //   309: areturn
    //   310: aload_2
    //   311: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   314: astore 26
    //   316: aload 26
    //   318: invokestatic 569	kawa/lib/files:pathExtension	(Lgnu/text/Path;)Ljava/lang/Object;
    //   321: areturn
    //   322: aload_2
    //   323: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   326: astore 24
    //   328: aload 24
    //   330: invokestatic 571	kawa/lib/files:pathPort	(Lgnu/text/Path;)I
    //   333: invokestatic 576	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: areturn
    //   337: aload_2
    //   338: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   341: astore 22
    //   343: aload 22
    //   345: invokestatic 578	kawa/lib/files:pathQuery	(Lgnu/text/Path;)Ljava/lang/Object;
    //   348: areturn
    //   349: aload_2
    //   350: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   353: astore 20
    //   355: aload 20
    //   357: invokestatic 580	kawa/lib/files:pathFragment	(Lgnu/text/Path;)Ljava/lang/Object;
    //   360: areturn
    //   361: aload_2
    //   362: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   365: astore 18
    //   367: aload 18
    //   369: invokestatic 582	kawa/lib/files:isFileExists	(Lgnu/text/Path;)Z
    //   372: ifeq +7 -> 379
    //   375: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   378: areturn
    //   379: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   382: areturn
    //   383: aload_2
    //   384: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   387: astore 16
    //   389: aload 16
    //   391: invokestatic 584	kawa/lib/files:isFileDirectory	(Lgnu/text/Path;)Z
    //   394: ifeq +7 -> 401
    //   397: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   400: areturn
    //   401: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   404: areturn
    //   405: aload_2
    //   406: invokestatic 440	gnu/text/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/text/FilePath;
    //   409: astore 14
    //   411: aload 14
    //   413: invokestatic 586	kawa/lib/files:isFileReadable	(Lgnu/text/FilePath;)Z
    //   416: ifeq +7 -> 423
    //   419: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   422: areturn
    //   423: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   426: areturn
    //   427: aload_2
    //   428: invokestatic 440	gnu/text/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/text/FilePath;
    //   431: astore 12
    //   433: aload 12
    //   435: invokestatic 588	kawa/lib/files:isFileWritable	(Lgnu/text/FilePath;)Z
    //   438: ifeq +7 -> 445
    //   441: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   444: areturn
    //   445: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   448: areturn
    //   449: aload_2
    //   450: invokestatic 440	gnu/text/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/text/FilePath;
    //   453: astore 10
    //   455: aload 10
    //   457: invokestatic 590	kawa/lib/files:deleteFile	(Lgnu/text/FilePath;)V
    //   460: getstatic 596	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   463: areturn
    //   464: aload_2
    //   465: invokestatic 440	gnu/text/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/text/FilePath;
    //   468: astore 8
    //   470: aload 8
    //   472: invokestatic 598	kawa/lib/files:createDirectory	(Lgnu/text/FilePath;)Z
    //   475: ifeq +7 -> 482
    //   478: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   481: areturn
    //   482: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   485: areturn
    //   486: aload_2
    //   487: invokestatic 440	gnu/text/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/text/FilePath;
    //   490: astore 6
    //   492: aload 6
    //   494: invokestatic 600	kawa/lib/files:directoryFiles	(Lgnu/text/FilePath;)Ljava/lang/Object;
    //   497: areturn
    //   498: aload_2
    //   499: invokestatic 602	kawa/lib/files:$To$Pathname	(Ljava/lang/Object;)Lgnu/text/Path;
    //   502: areturn
    //   503: aload_2
    //   504: checkcast 429	java/lang/CharSequence
    //   507: astore 4
    //   509: aload 4
    //   511: invokestatic 427	kawa/lib/files:makeTemporaryFile	(Ljava/lang/CharSequence;)Lgnu/text/FilePath;
    //   514: areturn
    //   515: astore 43
    //   517: new 604	gnu/mapping/WrongType
    //   520: dup
    //   521: aload 43
    //   523: ldc 203
    //   525: iconst_1
    //   526: aload_2
    //   527: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   530: athrow
    //   531: astore 41
    //   533: new 604	gnu/mapping/WrongType
    //   536: dup
    //   537: aload 41
    //   539: ldc 199
    //   541: iconst_1
    //   542: aload_2
    //   543: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   546: athrow
    //   547: astore 39
    //   549: new 604	gnu/mapping/WrongType
    //   552: dup
    //   553: aload 39
    //   555: ldc 195
    //   557: iconst_1
    //   558: aload_2
    //   559: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   562: athrow
    //   563: astore 37
    //   565: new 604	gnu/mapping/WrongType
    //   568: dup
    //   569: aload 37
    //   571: ldc 191
    //   573: iconst_1
    //   574: aload_2
    //   575: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   578: athrow
    //   579: astore 35
    //   581: new 604	gnu/mapping/WrongType
    //   584: dup
    //   585: aload 35
    //   587: ldc 187
    //   589: iconst_1
    //   590: aload_2
    //   591: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   594: athrow
    //   595: astore 33
    //   597: new 604	gnu/mapping/WrongType
    //   600: dup
    //   601: aload 33
    //   603: ldc 183
    //   605: iconst_1
    //   606: aload_2
    //   607: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   610: athrow
    //   611: astore 31
    //   613: new 604	gnu/mapping/WrongType
    //   616: dup
    //   617: aload 31
    //   619: ldc 179
    //   621: iconst_1
    //   622: aload_2
    //   623: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   626: athrow
    //   627: astore 29
    //   629: new 604	gnu/mapping/WrongType
    //   632: dup
    //   633: aload 29
    //   635: ldc 175
    //   637: iconst_1
    //   638: aload_2
    //   639: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   642: athrow
    //   643: astore 27
    //   645: new 604	gnu/mapping/WrongType
    //   648: dup
    //   649: aload 27
    //   651: ldc 171
    //   653: iconst_1
    //   654: aload_2
    //   655: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   658: athrow
    //   659: astore 25
    //   661: new 604	gnu/mapping/WrongType
    //   664: dup
    //   665: aload 25
    //   667: ldc 167
    //   669: iconst_1
    //   670: aload_2
    //   671: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   674: athrow
    //   675: astore 23
    //   677: new 604	gnu/mapping/WrongType
    //   680: dup
    //   681: aload 23
    //   683: ldc 163
    //   685: iconst_1
    //   686: aload_2
    //   687: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   690: athrow
    //   691: astore 21
    //   693: new 604	gnu/mapping/WrongType
    //   696: dup
    //   697: aload 21
    //   699: ldc 159
    //   701: iconst_1
    //   702: aload_2
    //   703: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   706: athrow
    //   707: astore 19
    //   709: new 604	gnu/mapping/WrongType
    //   712: dup
    //   713: aload 19
    //   715: ldc 155
    //   717: iconst_1
    //   718: aload_2
    //   719: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   722: athrow
    //   723: astore 17
    //   725: new 604	gnu/mapping/WrongType
    //   728: dup
    //   729: aload 17
    //   731: ldc 151
    //   733: iconst_1
    //   734: aload_2
    //   735: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   738: athrow
    //   739: astore 15
    //   741: new 604	gnu/mapping/WrongType
    //   744: dup
    //   745: aload 15
    //   747: ldc 147
    //   749: iconst_1
    //   750: aload_2
    //   751: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   754: athrow
    //   755: astore 13
    //   757: new 604	gnu/mapping/WrongType
    //   760: dup
    //   761: aload 13
    //   763: ldc 143
    //   765: iconst_1
    //   766: aload_2
    //   767: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   770: athrow
    //   771: astore 11
    //   773: new 604	gnu/mapping/WrongType
    //   776: dup
    //   777: aload 11
    //   779: ldc 139
    //   781: iconst_1
    //   782: aload_2
    //   783: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   786: athrow
    //   787: astore 9
    //   789: new 604	gnu/mapping/WrongType
    //   792: dup
    //   793: aload 9
    //   795: ldc 135
    //   797: iconst_1
    //   798: aload_2
    //   799: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   802: athrow
    //   803: astore 7
    //   805: new 604	gnu/mapping/WrongType
    //   808: dup
    //   809: aload 7
    //   811: ldc 123
    //   813: iconst_1
    //   814: aload_2
    //   815: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   818: athrow
    //   819: astore 5
    //   821: new 604	gnu/mapping/WrongType
    //   824: dup
    //   825: aload 5
    //   827: ldc 119
    //   829: iconst_1
    //   830: aload_2
    //   831: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   834: athrow
    //   835: astore_3
    //   836: new 604	gnu/mapping/WrongType
    //   839: dup
    //   840: aload_3
    //   841: ldc 91
    //   843: iconst_1
    //   844: aload_2
    //   845: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   848: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   192	198	515	java/lang/ClassCastException
    //   214	220	531	java/lang/ClassCastException
    //   226	232	547	java/lang/ClassCastException
    //   238	244	563	java/lang/ClassCastException
    //   250	256	579	java/lang/ClassCastException
    //   262	268	595	java/lang/ClassCastException
    //   274	280	611	java/lang/ClassCastException
    //   286	292	627	java/lang/ClassCastException
    //   298	304	643	java/lang/ClassCastException
    //   310	316	659	java/lang/ClassCastException
    //   322	328	675	java/lang/ClassCastException
    //   337	343	691	java/lang/ClassCastException
    //   349	355	707	java/lang/ClassCastException
    //   361	367	723	java/lang/ClassCastException
    //   383	389	739	java/lang/ClassCastException
    //   405	411	755	java/lang/ClassCastException
    //   427	433	771	java/lang/ClassCastException
    //   449	455	787	java/lang/ClassCastException
    //   464	470	803	java/lang/ClassCastException
    //   486	492	819	java/lang/ClassCastException
    //   503	509	835	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 529	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+36->40, 22:+44->48, 23:+74->78, 29:+97->101
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: invokespecial 611	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: areturn
    //   48: aload_2
    //   49: invokestatic 440	gnu/text/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/text/FilePath;
    //   52: astore 13
    //   54: aload_3
    //   55: invokestatic 440	gnu/text/FilePath:makeFilePath	(Ljava/lang/Object;)Lgnu/text/FilePath;
    //   58: astore 15
    //   60: aload 13
    //   62: aload 15
    //   64: invokestatic 613	kawa/lib/files:renameFile	(Lgnu/text/FilePath;Lgnu/text/FilePath;)Z
    //   67: ifeq +7 -> 74
    //   70: getstatic 545	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   73: areturn
    //   74: getstatic 390	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   77: areturn
    //   78: aload_2
    //   79: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   82: astore 9
    //   84: aload_3
    //   85: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   88: astore 11
    //   90: aload 9
    //   92: aload 11
    //   94: invokestatic 615	kawa/lib/files:copyFile	(Lgnu/text/Path;Lgnu/text/Path;)V
    //   97: getstatic 596	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   100: areturn
    //   101: aload_2
    //   102: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   105: astore 5
    //   107: aload_3
    //   108: invokestatic 85	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   111: astore 7
    //   113: aload 5
    //   115: aload 7
    //   117: invokestatic 617	kawa/lib/files:resolveUri	(Lgnu/text/Path;Lgnu/text/Path;)Lgnu/text/Path;
    //   120: areturn
    //   121: astore 12
    //   123: new 604	gnu/mapping/WrongType
    //   126: dup
    //   127: aload 12
    //   129: ldc 131
    //   131: iconst_1
    //   132: aload_2
    //   133: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   136: athrow
    //   137: astore 14
    //   139: new 604	gnu/mapping/WrongType
    //   142: dup
    //   143: aload 14
    //   145: ldc 131
    //   147: iconst_2
    //   148: aload_3
    //   149: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   152: athrow
    //   153: astore 8
    //   155: new 604	gnu/mapping/WrongType
    //   158: dup
    //   159: aload 8
    //   161: ldc 127
    //   163: iconst_1
    //   164: aload_2
    //   165: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    //   169: astore 10
    //   171: new 604	gnu/mapping/WrongType
    //   174: dup
    //   175: aload 10
    //   177: ldc 127
    //   179: iconst_2
    //   180: aload_3
    //   181: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   184: athrow
    //   185: astore 4
    //   187: new 604	gnu/mapping/WrongType
    //   190: dup
    //   191: aload 4
    //   193: ldc 103
    //   195: iconst_1
    //   196: aload_2
    //   197: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    //   201: astore 6
    //   203: new 604	gnu/mapping/WrongType
    //   206: dup
    //   207: aload 6
    //   209: ldc 103
    //   211: iconst_2
    //   212: aload_3
    //   213: invokespecial 607	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   48	54	121	java/lang/ClassCastException
    //   54	60	137	java/lang/ClassCastException
    //   78	84	153	java/lang/ClassCastException
    //   84	90	169	java/lang/ClassCastException
    //   101	107	185	java/lang/ClassCastException
    //   107	113	201	java/lang/ClassCastException
  }

  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 29:
    default:
      return super.match0(paramModuleMethod, paramCallContext);
    case 30:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 28:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 27:
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 22:
    case 23:
    case 27:
    case 28:
    case 29:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 30:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 26:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 25:
      if (FilePath.coerceToFilePathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 24:
      if (FilePath.coerceToFilePathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 21:
      if (FilePath.coerceToFilePathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 20:
      if (FilePath.coerceToFilePathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 19:
      if (FilePath.coerceToFilePathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 18:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 17:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 16:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 15:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 14:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 13:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 12:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 11:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 10:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 9:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 8:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 7:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 6:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 5:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 4:
      if (Path.coerceToPathOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 3:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 1:
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 29:
      if (Path.coerceToPathOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (Path.coerceToPathOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 23:
      if (Path.coerceToPathOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (Path.coerceToPathOrNull(paramObject2) != null)
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 2;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 22:
    }
    if (FilePath.coerceToFilePathOrNull(paramObject1) != null)
    {
      paramCallContext.value1 = paramObject1;
      if (FilePath.coerceToFilePathOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
    }
    else
    {
      return -786431;
    }
    return -786430;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.files
 * JD-Core Version:    0.6.2
 */