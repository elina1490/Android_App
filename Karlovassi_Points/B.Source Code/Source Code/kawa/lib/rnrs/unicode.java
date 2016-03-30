package kawa.lib.rnrs;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.UnicodeUtils;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.Char;
import java.util.Locale;
import kawa.lib.misc;

public class unicode extends ModuleBody
{
  public static final unicode $instance;
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
  static final SimpleSymbol Lit28 = (SimpleSymbol)new SimpleSymbol("string-normalize-nfkc").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod char$Mnalphabetic$Qu;
  public static final ModuleMethod char$Mnci$Eq$Qu;
  public static final ModuleMethod char$Mnci$Gr$Eq$Qu;
  public static final ModuleMethod char$Mnci$Gr$Qu;
  public static final ModuleMethod char$Mnci$Ls$Eq$Qu;
  public static final ModuleMethod char$Mnci$Ls$Qu;
  public static final ModuleMethod char$Mndowncase;
  public static final ModuleMethod char$Mnfoldcase;
  public static final ModuleMethod char$Mngeneral$Mncategory;
  public static final ModuleMethod char$Mnlower$Mncase$Qu;
  public static final ModuleMethod char$Mnnumeric$Qu;
  public static final ModuleMethod char$Mntitle$Mncase$Qu;
  public static final ModuleMethod char$Mntitlecase;
  public static final ModuleMethod char$Mnupcase;
  public static final ModuleMethod char$Mnupper$Mncase$Qu;
  public static final ModuleMethod char$Mnwhitespace$Qu;
  public static final ModuleMethod string$Mnci$Eq$Qu;
  public static final ModuleMethod string$Mnci$Gr$Eq$Qu;
  public static final ModuleMethod string$Mnci$Gr$Qu;
  public static final ModuleMethod string$Mnci$Ls$Eq$Qu;
  public static final ModuleMethod string$Mnci$Ls$Qu;
  public static final ModuleMethod string$Mndowncase;
  public static final ModuleMethod string$Mnfoldcase;
  public static final ModuleMethod string$Mnnormalize$Mnnfc;
  public static final ModuleMethod string$Mnnormalize$Mnnfd;
  public static final ModuleMethod string$Mnnormalize$Mnnfkc;
  public static final ModuleMethod string$Mnnormalize$Mnnfkd;
  public static final ModuleMethod string$Mntitlecase;
  public static final ModuleMethod string$Mnupcase;

  static
  {
    Lit27 = (SimpleSymbol)new SimpleSymbol("string-normalize-nfc").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("string-normalize-nfkd").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("string-normalize-nfd").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("string-ci>=?").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("string-ci<=?").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("string-ci>?").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("string-ci<?").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("string-ci=?").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("string-foldcase").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("string-titlecase").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("string-downcase").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("string-upcase").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("char-general-category").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("char-ci>=?").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("char-ci<=?").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("char-ci>?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("char-ci<?").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("char-ci=?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("char-foldcase").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("char-title-case?").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("char-lower-case?").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("char-upper-case?").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("char-whitespace?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("char-numeric?").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("char-alphabetic?").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("char-titlecase").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("char-downcase").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("char-upcase").readResolve();
    $instance = new unicode();
    unicode localunicode = $instance;
    char$Mnupcase = new ModuleMethod(localunicode, 1, Lit0, 4097);
    char$Mndowncase = new ModuleMethod(localunicode, 2, Lit1, 4097);
    char$Mntitlecase = new ModuleMethod(localunicode, 3, Lit2, 4097);
    char$Mnalphabetic$Qu = new ModuleMethod(localunicode, 4, Lit3, 4097);
    char$Mnnumeric$Qu = new ModuleMethod(localunicode, 5, Lit4, 4097);
    char$Mnwhitespace$Qu = new ModuleMethod(localunicode, 6, Lit5, 4097);
    char$Mnupper$Mncase$Qu = new ModuleMethod(localunicode, 7, Lit6, 4097);
    char$Mnlower$Mncase$Qu = new ModuleMethod(localunicode, 8, Lit7, 4097);
    char$Mntitle$Mncase$Qu = new ModuleMethod(localunicode, 9, Lit8, 4097);
    char$Mnfoldcase = new ModuleMethod(localunicode, 10, Lit9, 4097);
    char$Mnci$Eq$Qu = new ModuleMethod(localunicode, 11, Lit10, 8194);
    char$Mnci$Ls$Qu = new ModuleMethod(localunicode, 12, Lit11, 8194);
    char$Mnci$Gr$Qu = new ModuleMethod(localunicode, 13, Lit12, 8194);
    char$Mnci$Ls$Eq$Qu = new ModuleMethod(localunicode, 14, Lit13, 8194);
    char$Mnci$Gr$Eq$Qu = new ModuleMethod(localunicode, 15, Lit14, 8194);
    char$Mngeneral$Mncategory = new ModuleMethod(localunicode, 16, Lit15, 4097);
    string$Mnupcase = new ModuleMethod(localunicode, 17, Lit16, 4097);
    string$Mndowncase = new ModuleMethod(localunicode, 18, Lit17, 4097);
    string$Mntitlecase = new ModuleMethod(localunicode, 19, Lit18, 4097);
    string$Mnfoldcase = new ModuleMethod(localunicode, 20, Lit19, 4097);
    string$Mnci$Eq$Qu = new ModuleMethod(localunicode, 21, Lit20, 8194);
    string$Mnci$Ls$Qu = new ModuleMethod(localunicode, 22, Lit21, 8194);
    string$Mnci$Gr$Qu = new ModuleMethod(localunicode, 23, Lit22, 8194);
    string$Mnci$Ls$Eq$Qu = new ModuleMethod(localunicode, 24, Lit23, 8194);
    string$Mnci$Gr$Eq$Qu = new ModuleMethod(localunicode, 25, Lit24, 8194);
    string$Mnnormalize$Mnnfd = new ModuleMethod(localunicode, 26, Lit25, 4097);
    string$Mnnormalize$Mnnfkd = new ModuleMethod(localunicode, 27, Lit26, 4097);
    string$Mnnormalize$Mnnfc = new ModuleMethod(localunicode, 28, Lit27, 4097);
    string$Mnnormalize$Mnnfkc = new ModuleMethod(localunicode, 29, Lit28, 4097);
    $instance.run();
  }

  public unicode()
  {
    ModuleInfo.register(this);
  }

  public static Char charDowncase(Char paramChar)
  {
    return Char.make(Character.toLowerCase(paramChar.intValue()));
  }

  public static Char charFoldcase(Char paramChar)
  {
    int i = paramChar.intValue();
    int j;
    if (i == 304)
    {
      j = 1;
      if (j == 0)
        break label29;
      if (j == 0)
        break label36;
    }
    label29: 
    while (i == 305)
    {
      return paramChar;
      j = 0;
      break;
    }
    label36: return Char.make(Character.toLowerCase(Character.toUpperCase(i)));
  }

  public static Symbol charGeneralCategory(Char paramChar)
  {
    return UnicodeUtils.generalCategory(paramChar.intValue());
  }

  public static Char charTitlecase(Char paramChar)
  {
    return Char.make(Character.toTitleCase(paramChar.intValue()));
  }

  public static Char charUpcase(Char paramChar)
  {
    return Char.make(Character.toUpperCase(paramChar.intValue()));
  }

  public static boolean isCharAlphabetic(Char paramChar)
  {
    return Character.isLetter(paramChar.intValue());
  }

  public static boolean isCharCi$Eq(Char paramChar1, Char paramChar2)
  {
    return Character.toUpperCase(paramChar1.intValue()) == Character.toUpperCase(paramChar2.intValue());
  }

  public static boolean isCharCi$Gr(Char paramChar1, Char paramChar2)
  {
    return Character.toUpperCase(paramChar1.intValue()) > Character.toUpperCase(paramChar2.intValue());
  }

  public static boolean isCharCi$Gr$Eq(Char paramChar1, Char paramChar2)
  {
    return Character.toUpperCase(paramChar1.intValue()) >= Character.toUpperCase(paramChar2.intValue());
  }

  public static boolean isCharCi$Ls(Char paramChar1, Char paramChar2)
  {
    return Character.toUpperCase(paramChar1.intValue()) < Character.toUpperCase(paramChar2.intValue());
  }

  public static boolean isCharCi$Ls$Eq(Char paramChar1, Char paramChar2)
  {
    return Character.toUpperCase(paramChar1.intValue()) <= Character.toUpperCase(paramChar2.intValue());
  }

  public static boolean isCharLowerCase(Char paramChar)
  {
    return Character.isLowerCase(paramChar.intValue());
  }

  public static boolean isCharNumeric(Char paramChar)
  {
    return Character.isDigit(paramChar.intValue());
  }

  public static boolean isCharTitleCase(Char paramChar)
  {
    return Character.isTitleCase(paramChar.intValue());
  }

  public static boolean isCharUpperCase(Char paramChar)
  {
    return Character.isUpperCase(paramChar.intValue());
  }

  public static boolean isCharWhitespace(Char paramChar)
  {
    return UnicodeUtils.isWhitespace(paramChar.intValue());
  }

  public static boolean isStringCi$Eq(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return UnicodeUtils.foldCase(paramCharSequence1).equals(UnicodeUtils.foldCase(paramCharSequence2));
  }

  public static boolean isStringCi$Gr(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return UnicodeUtils.foldCase(paramCharSequence1).compareTo(UnicodeUtils.foldCase(paramCharSequence2)) > 0;
  }

  public static boolean isStringCi$Gr$Eq(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return UnicodeUtils.foldCase(paramCharSequence1).compareTo(UnicodeUtils.foldCase(paramCharSequence2)) >= 0;
  }

  public static boolean isStringCi$Ls(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return UnicodeUtils.foldCase(paramCharSequence1).compareTo(UnicodeUtils.foldCase(paramCharSequence2)) < 0;
  }

  public static boolean isStringCi$Ls$Eq(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return UnicodeUtils.foldCase(paramCharSequence1).compareTo(UnicodeUtils.foldCase(paramCharSequence2)) <= 0;
  }

  public static CharSequence stringDowncase(CharSequence paramCharSequence)
  {
    return new FString(paramCharSequence.toString().toLowerCase(Locale.ENGLISH));
  }

  public static CharSequence stringFoldcase(CharSequence paramCharSequence)
  {
    return new FString(UnicodeUtils.foldCase(paramCharSequence));
  }

  public static CharSequence stringNormalizeNfc(CharSequence paramCharSequence)
  {
    return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
  }

  public static CharSequence stringNormalizeNfd(CharSequence paramCharSequence)
  {
    return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
  }

  public static CharSequence stringNormalizeNfkc(CharSequence paramCharSequence)
  {
    return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
  }

  public static CharSequence stringNormalizeNfkd(CharSequence paramCharSequence)
  {
    return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
  }

  public static CharSequence stringTitlecase(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null);
    for (String str = null; ; str = paramCharSequence.toString())
      return new FString(UnicodeUtils.capitalize(str));
  }

  public static CharSequence stringUpcase(CharSequence paramCharSequence)
  {
    return new FString(paramCharSequence.toString().toUpperCase(Locale.ENGLISH));
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 412	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+132 -> 136, 1:+139->143, 2:+151->155, 3:+163->167, 4:+175->179, 5:+197->201, 6:+219->223, 7:+241->245, 8:+263->267, 9:+285->289, 10:+307->311, 11:+132->136, 12:+132->136, 13:+132->136, 14:+132->136, 15:+132->136, 16:+319->323, 17:+331->335, 18:+343->347, 19:+355->359, 20:+367->371, 21:+132->136, 22:+132->136, 23:+132->136, 24:+132->136, 25:+132->136, 26:+379->383, 27:+391->395, 28:+403->407, 29:+415->419
    //   137: aload_1
    //   138: aload_2
    //   139: invokespecial 414	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: areturn
    //   143: aload_2
    //   144: checkcast 275	gnu/text/Char
    //   147: astore 40
    //   149: aload 40
    //   151: invokestatic 416	kawa/lib/rnrs/unicode:charUpcase	(Lgnu/text/Char;)Lgnu/text/Char;
    //   154: areturn
    //   155: aload_2
    //   156: checkcast 275	gnu/text/Char
    //   159: astore 38
    //   161: aload 38
    //   163: invokestatic 418	kawa/lib/rnrs/unicode:charDowncase	(Lgnu/text/Char;)Lgnu/text/Char;
    //   166: areturn
    //   167: aload_2
    //   168: checkcast 275	gnu/text/Char
    //   171: astore 36
    //   173: aload 36
    //   175: invokestatic 420	kawa/lib/rnrs/unicode:charTitlecase	(Lgnu/text/Char;)Lgnu/text/Char;
    //   178: areturn
    //   179: aload_2
    //   180: checkcast 275	gnu/text/Char
    //   183: astore 34
    //   185: aload 34
    //   187: invokestatic 422	kawa/lib/rnrs/unicode:isCharAlphabetic	(Lgnu/text/Char;)Z
    //   190: ifeq +7 -> 197
    //   193: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   196: areturn
    //   197: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   200: areturn
    //   201: aload_2
    //   202: checkcast 275	gnu/text/Char
    //   205: astore 32
    //   207: aload 32
    //   209: invokestatic 433	kawa/lib/rnrs/unicode:isCharNumeric	(Lgnu/text/Char;)Z
    //   212: ifeq +7 -> 219
    //   215: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   218: areturn
    //   219: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   222: areturn
    //   223: aload_2
    //   224: checkcast 275	gnu/text/Char
    //   227: astore 30
    //   229: aload 30
    //   231: invokestatic 435	kawa/lib/rnrs/unicode:isCharWhitespace	(Lgnu/text/Char;)Z
    //   234: ifeq +7 -> 241
    //   237: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   240: areturn
    //   241: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   244: areturn
    //   245: aload_2
    //   246: checkcast 275	gnu/text/Char
    //   249: astore 28
    //   251: aload 28
    //   253: invokestatic 437	kawa/lib/rnrs/unicode:isCharUpperCase	(Lgnu/text/Char;)Z
    //   256: ifeq +7 -> 263
    //   259: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   262: areturn
    //   263: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   266: areturn
    //   267: aload_2
    //   268: checkcast 275	gnu/text/Char
    //   271: astore 26
    //   273: aload 26
    //   275: invokestatic 439	kawa/lib/rnrs/unicode:isCharLowerCase	(Lgnu/text/Char;)Z
    //   278: ifeq +7 -> 285
    //   281: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   284: areturn
    //   285: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   288: areturn
    //   289: aload_2
    //   290: checkcast 275	gnu/text/Char
    //   293: astore 24
    //   295: aload 24
    //   297: invokestatic 441	kawa/lib/rnrs/unicode:isCharTitleCase	(Lgnu/text/Char;)Z
    //   300: ifeq +7 -> 307
    //   303: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   306: areturn
    //   307: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   310: areturn
    //   311: aload_2
    //   312: checkcast 275	gnu/text/Char
    //   315: astore 22
    //   317: aload 22
    //   319: invokestatic 443	kawa/lib/rnrs/unicode:charFoldcase	(Lgnu/text/Char;)Lgnu/text/Char;
    //   322: areturn
    //   323: aload_2
    //   324: checkcast 275	gnu/text/Char
    //   327: astore 20
    //   329: aload 20
    //   331: invokestatic 445	kawa/lib/rnrs/unicode:charGeneralCategory	(Lgnu/text/Char;)Lgnu/mapping/Symbol;
    //   334: areturn
    //   335: aload_2
    //   336: checkcast 364	java/lang/CharSequence
    //   339: astore 18
    //   341: aload 18
    //   343: invokestatic 447	kawa/lib/rnrs/unicode:stringUpcase	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   346: areturn
    //   347: aload_2
    //   348: checkcast 364	java/lang/CharSequence
    //   351: astore 16
    //   353: aload 16
    //   355: invokestatic 449	kawa/lib/rnrs/unicode:stringDowncase	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   358: areturn
    //   359: aload_2
    //   360: checkcast 364	java/lang/CharSequence
    //   363: astore 14
    //   365: aload 14
    //   367: invokestatic 451	kawa/lib/rnrs/unicode:stringTitlecase	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   370: areturn
    //   371: aload_2
    //   372: checkcast 364	java/lang/CharSequence
    //   375: astore 12
    //   377: aload 12
    //   379: invokestatic 453	kawa/lib/rnrs/unicode:stringFoldcase	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   382: areturn
    //   383: aload_2
    //   384: checkcast 364	java/lang/CharSequence
    //   387: astore 10
    //   389: aload 10
    //   391: invokestatic 455	kawa/lib/rnrs/unicode:stringNormalizeNfd	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   394: areturn
    //   395: aload_2
    //   396: checkcast 364	java/lang/CharSequence
    //   399: astore 8
    //   401: aload 8
    //   403: invokestatic 457	kawa/lib/rnrs/unicode:stringNormalizeNfkd	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   406: areturn
    //   407: aload_2
    //   408: checkcast 364	java/lang/CharSequence
    //   411: astore 6
    //   413: aload 6
    //   415: invokestatic 459	kawa/lib/rnrs/unicode:stringNormalizeNfc	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   418: areturn
    //   419: aload_2
    //   420: checkcast 364	java/lang/CharSequence
    //   423: astore 4
    //   425: aload 4
    //   427: invokestatic 461	kawa/lib/rnrs/unicode:stringNormalizeNfkc	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   430: areturn
    //   431: astore 39
    //   433: new 463	gnu/mapping/WrongType
    //   436: dup
    //   437: aload 39
    //   439: ldc 192
    //   441: iconst_1
    //   442: aload_2
    //   443: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   446: athrow
    //   447: astore 37
    //   449: new 463	gnu/mapping/WrongType
    //   452: dup
    //   453: aload 37
    //   455: ldc 188
    //   457: iconst_1
    //   458: aload_2
    //   459: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   462: athrow
    //   463: astore 35
    //   465: new 463	gnu/mapping/WrongType
    //   468: dup
    //   469: aload 35
    //   471: ldc 184
    //   473: iconst_1
    //   474: aload_2
    //   475: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   478: athrow
    //   479: astore 33
    //   481: new 463	gnu/mapping/WrongType
    //   484: dup
    //   485: aload 33
    //   487: ldc 180
    //   489: iconst_1
    //   490: aload_2
    //   491: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   494: athrow
    //   495: astore 31
    //   497: new 463	gnu/mapping/WrongType
    //   500: dup
    //   501: aload 31
    //   503: ldc 176
    //   505: iconst_1
    //   506: aload_2
    //   507: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   510: athrow
    //   511: astore 29
    //   513: new 463	gnu/mapping/WrongType
    //   516: dup
    //   517: aload 29
    //   519: ldc 172
    //   521: iconst_1
    //   522: aload_2
    //   523: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   526: athrow
    //   527: astore 27
    //   529: new 463	gnu/mapping/WrongType
    //   532: dup
    //   533: aload 27
    //   535: ldc 168
    //   537: iconst_1
    //   538: aload_2
    //   539: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   542: athrow
    //   543: astore 25
    //   545: new 463	gnu/mapping/WrongType
    //   548: dup
    //   549: aload 25
    //   551: ldc 164
    //   553: iconst_1
    //   554: aload_2
    //   555: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   558: athrow
    //   559: astore 23
    //   561: new 463	gnu/mapping/WrongType
    //   564: dup
    //   565: aload 23
    //   567: ldc 160
    //   569: iconst_1
    //   570: aload_2
    //   571: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   574: athrow
    //   575: astore 21
    //   577: new 463	gnu/mapping/WrongType
    //   580: dup
    //   581: aload 21
    //   583: ldc 156
    //   585: iconst_1
    //   586: aload_2
    //   587: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   590: athrow
    //   591: astore 19
    //   593: new 463	gnu/mapping/WrongType
    //   596: dup
    //   597: aload 19
    //   599: ldc 132
    //   601: iconst_1
    //   602: aload_2
    //   603: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   606: athrow
    //   607: astore 17
    //   609: new 463	gnu/mapping/WrongType
    //   612: dup
    //   613: aload 17
    //   615: ldc 128
    //   617: iconst_1
    //   618: aload_2
    //   619: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   622: athrow
    //   623: astore 15
    //   625: new 463	gnu/mapping/WrongType
    //   628: dup
    //   629: aload 15
    //   631: ldc 124
    //   633: iconst_1
    //   634: aload_2
    //   635: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   638: athrow
    //   639: astore 13
    //   641: new 463	gnu/mapping/WrongType
    //   644: dup
    //   645: aload 13
    //   647: ldc 120
    //   649: iconst_1
    //   650: aload_2
    //   651: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   654: athrow
    //   655: astore 11
    //   657: new 463	gnu/mapping/WrongType
    //   660: dup
    //   661: aload 11
    //   663: ldc 116
    //   665: iconst_1
    //   666: aload_2
    //   667: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   670: athrow
    //   671: astore 9
    //   673: new 463	gnu/mapping/WrongType
    //   676: dup
    //   677: aload 9
    //   679: ldc 92
    //   681: iconst_1
    //   682: aload_2
    //   683: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   686: athrow
    //   687: astore 7
    //   689: new 463	gnu/mapping/WrongType
    //   692: dup
    //   693: aload 7
    //   695: ldc 88
    //   697: iconst_1
    //   698: aload_2
    //   699: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   702: athrow
    //   703: astore 5
    //   705: new 463	gnu/mapping/WrongType
    //   708: dup
    //   709: aload 5
    //   711: ldc 84
    //   713: iconst_1
    //   714: aload_2
    //   715: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   718: athrow
    //   719: astore_3
    //   720: new 463	gnu/mapping/WrongType
    //   723: dup
    //   724: aload_3
    //   725: ldc 72
    //   727: iconst_1
    //   728: aload_2
    //   729: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   732: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   143	149	431	java/lang/ClassCastException
    //   155	161	447	java/lang/ClassCastException
    //   167	173	463	java/lang/ClassCastException
    //   179	185	479	java/lang/ClassCastException
    //   201	207	495	java/lang/ClassCastException
    //   223	229	511	java/lang/ClassCastException
    //   245	251	527	java/lang/ClassCastException
    //   267	273	543	java/lang/ClassCastException
    //   289	295	559	java/lang/ClassCastException
    //   311	317	575	java/lang/ClassCastException
    //   323	329	591	java/lang/ClassCastException
    //   335	341	607	java/lang/ClassCastException
    //   347	353	623	java/lang/ClassCastException
    //   359	365	639	java/lang/ClassCastException
    //   371	377	655	java/lang/ClassCastException
    //   383	389	671	java/lang/ClassCastException
    //   395	401	687	java/lang/ClassCastException
    //   407	413	703	java/lang/ClassCastException
    //   419	425	719	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 412	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+76 -> 80, 11:+84->88, 12:+114->118, 13:+144->148, 14:+174->178, 15:+204->208, 16:+76->80, 17:+76->80, 18:+76->80, 19:+76->80, 20:+76->80, 21:+234->238, 22:+264->268, 23:+294->298, 24:+324->328, 25:+354->358
    //   81: aload_1
    //   82: aload_2
    //   83: aload_3
    //   84: invokespecial 470	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: areturn
    //   88: aload_2
    //   89: checkcast 275	gnu/text/Char
    //   92: astore 41
    //   94: aload_3
    //   95: checkcast 275	gnu/text/Char
    //   98: astore 43
    //   100: aload 41
    //   102: aload 43
    //   104: invokestatic 472	kawa/lib/rnrs/unicode:isCharCi$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   107: ifeq +7 -> 114
    //   110: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   113: areturn
    //   114: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast 275	gnu/text/Char
    //   122: astore 37
    //   124: aload_3
    //   125: checkcast 275	gnu/text/Char
    //   128: astore 39
    //   130: aload 37
    //   132: aload 39
    //   134: invokestatic 474	kawa/lib/rnrs/unicode:isCharCi$Ls	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   137: ifeq +7 -> 144
    //   140: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   143: areturn
    //   144: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   147: areturn
    //   148: aload_2
    //   149: checkcast 275	gnu/text/Char
    //   152: astore 33
    //   154: aload_3
    //   155: checkcast 275	gnu/text/Char
    //   158: astore 35
    //   160: aload 33
    //   162: aload 35
    //   164: invokestatic 476	kawa/lib/rnrs/unicode:isCharCi$Gr	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   167: ifeq +7 -> 174
    //   170: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   173: areturn
    //   174: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   177: areturn
    //   178: aload_2
    //   179: checkcast 275	gnu/text/Char
    //   182: astore 29
    //   184: aload_3
    //   185: checkcast 275	gnu/text/Char
    //   188: astore 31
    //   190: aload 29
    //   192: aload 31
    //   194: invokestatic 478	kawa/lib/rnrs/unicode:isCharCi$Ls$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   197: ifeq +7 -> 204
    //   200: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   203: areturn
    //   204: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   207: areturn
    //   208: aload_2
    //   209: checkcast 275	gnu/text/Char
    //   212: astore 25
    //   214: aload_3
    //   215: checkcast 275	gnu/text/Char
    //   218: astore 27
    //   220: aload 25
    //   222: aload 27
    //   224: invokestatic 480	kawa/lib/rnrs/unicode:isCharCi$Gr$Eq	(Lgnu/text/Char;Lgnu/text/Char;)Z
    //   227: ifeq +7 -> 234
    //   230: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   233: areturn
    //   234: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   237: areturn
    //   238: aload_2
    //   239: checkcast 364	java/lang/CharSequence
    //   242: astore 21
    //   244: aload_3
    //   245: checkcast 364	java/lang/CharSequence
    //   248: astore 23
    //   250: aload 21
    //   252: aload 23
    //   254: invokestatic 482	kawa/lib/rnrs/unicode:isStringCi$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   257: ifeq +7 -> 264
    //   260: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   263: areturn
    //   264: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast 364	java/lang/CharSequence
    //   272: astore 17
    //   274: aload_3
    //   275: checkcast 364	java/lang/CharSequence
    //   278: astore 19
    //   280: aload 17
    //   282: aload 19
    //   284: invokestatic 484	kawa/lib/rnrs/unicode:isStringCi$Ls	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   287: ifeq +7 -> 294
    //   290: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   293: areturn
    //   294: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   297: areturn
    //   298: aload_2
    //   299: checkcast 364	java/lang/CharSequence
    //   302: astore 13
    //   304: aload_3
    //   305: checkcast 364	java/lang/CharSequence
    //   308: astore 15
    //   310: aload 13
    //   312: aload 15
    //   314: invokestatic 486	kawa/lib/rnrs/unicode:isStringCi$Gr	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   317: ifeq +7 -> 324
    //   320: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   323: areturn
    //   324: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   327: areturn
    //   328: aload_2
    //   329: checkcast 364	java/lang/CharSequence
    //   332: astore 9
    //   334: aload_3
    //   335: checkcast 364	java/lang/CharSequence
    //   338: astore 11
    //   340: aload 9
    //   342: aload 11
    //   344: invokestatic 488	kawa/lib/rnrs/unicode:isStringCi$Ls$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   347: ifeq +7 -> 354
    //   350: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   353: areturn
    //   354: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   357: areturn
    //   358: aload_2
    //   359: checkcast 364	java/lang/CharSequence
    //   362: astore 5
    //   364: aload_3
    //   365: checkcast 364	java/lang/CharSequence
    //   368: astore 7
    //   370: aload 5
    //   372: aload 7
    //   374: invokestatic 490	kawa/lib/rnrs/unicode:isStringCi$Gr$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   377: ifeq +7 -> 384
    //   380: getstatic 428	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   383: areturn
    //   384: getstatic 431	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   387: areturn
    //   388: astore 40
    //   390: new 463	gnu/mapping/WrongType
    //   393: dup
    //   394: aload 40
    //   396: ldc 152
    //   398: iconst_1
    //   399: aload_2
    //   400: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   403: athrow
    //   404: astore 42
    //   406: new 463	gnu/mapping/WrongType
    //   409: dup
    //   410: aload 42
    //   412: ldc 152
    //   414: iconst_2
    //   415: aload_3
    //   416: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   419: athrow
    //   420: astore 36
    //   422: new 463	gnu/mapping/WrongType
    //   425: dup
    //   426: aload 36
    //   428: ldc 148
    //   430: iconst_1
    //   431: aload_2
    //   432: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   435: athrow
    //   436: astore 38
    //   438: new 463	gnu/mapping/WrongType
    //   441: dup
    //   442: aload 38
    //   444: ldc 148
    //   446: iconst_2
    //   447: aload_3
    //   448: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   451: athrow
    //   452: astore 32
    //   454: new 463	gnu/mapping/WrongType
    //   457: dup
    //   458: aload 32
    //   460: ldc 144
    //   462: iconst_1
    //   463: aload_2
    //   464: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   467: athrow
    //   468: astore 34
    //   470: new 463	gnu/mapping/WrongType
    //   473: dup
    //   474: aload 34
    //   476: ldc 144
    //   478: iconst_2
    //   479: aload_3
    //   480: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   483: athrow
    //   484: astore 28
    //   486: new 463	gnu/mapping/WrongType
    //   489: dup
    //   490: aload 28
    //   492: ldc 140
    //   494: iconst_1
    //   495: aload_2
    //   496: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   499: athrow
    //   500: astore 30
    //   502: new 463	gnu/mapping/WrongType
    //   505: dup
    //   506: aload 30
    //   508: ldc 140
    //   510: iconst_2
    //   511: aload_3
    //   512: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   515: athrow
    //   516: astore 24
    //   518: new 463	gnu/mapping/WrongType
    //   521: dup
    //   522: aload 24
    //   524: ldc 136
    //   526: iconst_1
    //   527: aload_2
    //   528: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   531: athrow
    //   532: astore 26
    //   534: new 463	gnu/mapping/WrongType
    //   537: dup
    //   538: aload 26
    //   540: ldc 136
    //   542: iconst_2
    //   543: aload_3
    //   544: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   547: athrow
    //   548: astore 20
    //   550: new 463	gnu/mapping/WrongType
    //   553: dup
    //   554: aload 20
    //   556: ldc 112
    //   558: iconst_1
    //   559: aload_2
    //   560: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   563: athrow
    //   564: astore 22
    //   566: new 463	gnu/mapping/WrongType
    //   569: dup
    //   570: aload 22
    //   572: ldc 112
    //   574: iconst_2
    //   575: aload_3
    //   576: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   579: athrow
    //   580: astore 16
    //   582: new 463	gnu/mapping/WrongType
    //   585: dup
    //   586: aload 16
    //   588: ldc 108
    //   590: iconst_1
    //   591: aload_2
    //   592: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   595: athrow
    //   596: astore 18
    //   598: new 463	gnu/mapping/WrongType
    //   601: dup
    //   602: aload 18
    //   604: ldc 108
    //   606: iconst_2
    //   607: aload_3
    //   608: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   611: athrow
    //   612: astore 12
    //   614: new 463	gnu/mapping/WrongType
    //   617: dup
    //   618: aload 12
    //   620: ldc 104
    //   622: iconst_1
    //   623: aload_2
    //   624: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   627: athrow
    //   628: astore 14
    //   630: new 463	gnu/mapping/WrongType
    //   633: dup
    //   634: aload 14
    //   636: ldc 104
    //   638: iconst_2
    //   639: aload_3
    //   640: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   643: athrow
    //   644: astore 8
    //   646: new 463	gnu/mapping/WrongType
    //   649: dup
    //   650: aload 8
    //   652: ldc 100
    //   654: iconst_1
    //   655: aload_2
    //   656: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   659: athrow
    //   660: astore 10
    //   662: new 463	gnu/mapping/WrongType
    //   665: dup
    //   666: aload 10
    //   668: ldc 100
    //   670: iconst_2
    //   671: aload_3
    //   672: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   675: athrow
    //   676: astore 4
    //   678: new 463	gnu/mapping/WrongType
    //   681: dup
    //   682: aload 4
    //   684: ldc 96
    //   686: iconst_1
    //   687: aload_2
    //   688: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   691: athrow
    //   692: astore 6
    //   694: new 463	gnu/mapping/WrongType
    //   697: dup
    //   698: aload 6
    //   700: ldc 96
    //   702: iconst_2
    //   703: aload_3
    //   704: invokespecial 466	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   707: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   88	94	388	java/lang/ClassCastException
    //   94	100	404	java/lang/ClassCastException
    //   118	124	420	java/lang/ClassCastException
    //   124	130	436	java/lang/ClassCastException
    //   148	154	452	java/lang/ClassCastException
    //   154	160	468	java/lang/ClassCastException
    //   178	184	484	java/lang/ClassCastException
    //   184	190	500	java/lang/ClassCastException
    //   208	214	516	java/lang/ClassCastException
    //   214	220	532	java/lang/ClassCastException
    //   238	244	548	java/lang/ClassCastException
    //   244	250	564	java/lang/ClassCastException
    //   268	274	580	java/lang/ClassCastException
    //   274	280	596	java/lang/ClassCastException
    //   298	304	612	java/lang/ClassCastException
    //   304	310	628	java/lang/ClassCastException
    //   328	334	644	java/lang/ClassCastException
    //   334	340	660	java/lang/ClassCastException
    //   358	364	676	java/lang/ClassCastException
    //   364	370	692	java/lang/ClassCastException
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 21:
    case 22:
    case 23:
    case 24:
    case 25:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 29:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 28:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 27:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 26:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 20:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 19:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 18:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 17:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 16:
      if (!(paramObject instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10:
      if (!(paramObject instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9:
      if (!(paramObject instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 8:
      if (!(paramObject instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 7:
      if (!(paramObject instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 6:
      if (!(paramObject instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5:
      if (!(paramObject instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 4:
      if (!(paramObject instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3:
      if (!(paramObject instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
      if (!(paramObject instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 1:
    }
    if (!(paramObject instanceof Char))
      return -786431;
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 16:
    case 17:
    case 18:
    case 19:
    case 20:
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 25:
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof CharSequence))
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
    case 24:
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof CharSequence))
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
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof CharSequence))
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
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof CharSequence))
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
    case 21:
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof CharSequence))
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
    case 15:
      if (!(paramObject1 instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 14:
      if (!(paramObject1 instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 13:
      if (!(paramObject1 instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 12:
      if (!(paramObject1 instanceof Char))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Char))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 11:
    }
    if (!(paramObject1 instanceof Char))
      return -786431;
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof Char))
      return -786430;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.rnrs.unicode
 * JD-Core Version:    0.6.2
 */