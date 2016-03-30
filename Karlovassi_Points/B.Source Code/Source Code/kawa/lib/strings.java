package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.CharSeq;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Strings;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.text.Char;

public class strings extends ModuleBody
{
  public static final strings $instance;
  public static final ModuleMethod $make$string$;
  static final Char Lit0;
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
  static final SimpleSymbol Lit22 = (SimpleSymbol)new SimpleSymbol("string-append/shared").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod list$Mn$Grstring;
  public static final ModuleMethod make$Mnstring;
  public static final ModuleMethod string$Eq$Qu;
  public static final ModuleMethod string$Gr$Eq$Qu;
  public static final ModuleMethod string$Gr$Qu;
  public static final ModuleMethod string$Ls$Eq$Qu;
  public static final ModuleMethod string$Ls$Qu;
  public static final ModuleMethod string$Mn$Grlist;
  public static final ModuleMethod string$Mnappend;
  public static final ModuleMethod string$Mnappend$Slshared;
  public static final ModuleMethod string$Mncapitalize;
  public static final ModuleMethod string$Mncapitalize$Ex;
  public static final ModuleMethod string$Mncopy;
  public static final ModuleMethod string$Mndowncase$Ex;
  public static final ModuleMethod string$Mnfill$Ex;
  public static final ModuleMethod string$Mnlength;
  public static final ModuleMethod string$Mnref;
  public static final ModuleMethod string$Mnset$Ex;
  public static final ModuleMethod string$Mnupcase$Ex;
  public static final ModuleMethod string$Qu;
  public static final ModuleMethod substring;

  public static CharSequence $make$string$(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    FString localFString = new FString(i);
    for (int j = 0; j < i; j++)
      localFString.setCharAt(j, ((Char)paramArrayOfObject[j]).charValue());
    return localFString;
  }

  static
  {
    Lit21 = (SimpleSymbol)new SimpleSymbol("string-append").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("string-capitalize").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("string-capitalize!").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("string-downcase!").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("string-upcase!").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("string-fill!").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("string-copy").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("list->string").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("string->list").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("substring").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("string>=?").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("string<=?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("string>?").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("string<?").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("string=?").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("string-set!").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("string-ref").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("string-length").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("$make$string$").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("make-string").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("string?").readResolve();
    Lit0 = Char.make(32);
    $instance = new strings();
    strings localstrings = $instance;
    string$Qu = new ModuleMethod(localstrings, 1, Lit1, 4097);
    make$Mnstring = new ModuleMethod(localstrings, 2, Lit2, 8193);
    $make$string$ = new ModuleMethod(localstrings, 4, Lit3, -4096);
    string$Mnlength = new ModuleMethod(localstrings, 5, Lit4, 4097);
    string$Mnref = new ModuleMethod(localstrings, 6, Lit5, 8194);
    string$Mnset$Ex = new ModuleMethod(localstrings, 7, Lit6, 12291);
    string$Eq$Qu = new ModuleMethod(localstrings, 8, Lit7, 8194);
    string$Ls$Qu = new ModuleMethod(localstrings, 9, Lit8, 8194);
    string$Gr$Qu = new ModuleMethod(localstrings, 10, Lit9, 8194);
    string$Ls$Eq$Qu = new ModuleMethod(localstrings, 11, Lit10, 8194);
    string$Gr$Eq$Qu = new ModuleMethod(localstrings, 12, Lit11, 8194);
    substring = new ModuleMethod(localstrings, 13, Lit12, 12291);
    string$Mn$Grlist = new ModuleMethod(localstrings, 14, Lit13, 4097);
    list$Mn$Grstring = new ModuleMethod(localstrings, 15, Lit14, 4097);
    string$Mncopy = new ModuleMethod(localstrings, 16, Lit15, 4097);
    string$Mnfill$Ex = new ModuleMethod(localstrings, 17, Lit16, 8194);
    string$Mnupcase$Ex = new ModuleMethod(localstrings, 18, Lit17, 4097);
    string$Mndowncase$Ex = new ModuleMethod(localstrings, 19, Lit18, 4097);
    string$Mncapitalize$Ex = new ModuleMethod(localstrings, 20, Lit19, 4097);
    string$Mncapitalize = new ModuleMethod(localstrings, 21, Lit20, 4097);
    string$Mnappend = new ModuleMethod(localstrings, 22, Lit21, -4096);
    string$Mnappend$Slshared = new ModuleMethod(localstrings, 23, Lit22, -4096);
    $instance.run();
  }

  public strings()
  {
    ModuleInfo.register(this);
  }

  public static boolean isString(Object paramObject)
  {
    return paramObject instanceof CharSequence;
  }

  public static boolean isString$Eq(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().equals(paramObject2.toString());
  }

  public static boolean isString$Gr(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().compareTo(paramObject2.toString()) > 0;
  }

  public static boolean isString$Gr$Eq(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().compareTo(paramObject2.toString()) >= 0;
  }

  public static boolean isString$Ls(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().compareTo(paramObject2.toString()) < 0;
  }

  public static boolean isString$Ls$Eq(Object paramObject1, Object paramObject2)
  {
    return paramObject1.toString().compareTo(paramObject2.toString()) <= 0;
  }

  // ERROR //
  public static CharSequence list$To$String(LList paramLList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 272	kawa/lib/lists:length	(Lgnu/lists/LList;)I
    //   4: istore_1
    //   5: new 57	gnu/lists/FString
    //   8: dup
    //   9: iload_1
    //   10: invokespecial 61	gnu/lists/FString:<init>	(I)V
    //   13: astore_2
    //   14: iconst_0
    //   15: istore_3
    //   16: iload_3
    //   17: iload_1
    //   18: if_icmpge +129 -> 147
    //   21: aload_0
    //   22: checkcast 274	gnu/lists/Pair
    //   25: astore 5
    //   27: aload_2
    //   28: checkcast 276	gnu/lists/CharSeq
    //   31: astore 7
    //   33: aload 5
    //   35: invokevirtual 279	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   38: astore 8
    //   40: aload 8
    //   42: checkcast 63	gnu/text/Char
    //   45: invokevirtual 67	gnu/text/Char:charValue	()C
    //   48: istore 10
    //   50: aload 7
    //   52: iload_3
    //   53: iload 10
    //   55: invokestatic 283	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   58: aload 5
    //   60: invokevirtual 286	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   63: astore 11
    //   65: aload 11
    //   67: checkcast 288	gnu/lists/LList
    //   70: astore_0
    //   71: iinc 3 1
    //   74: goto -58 -> 16
    //   77: astore 4
    //   79: new 290	gnu/mapping/WrongType
    //   82: dup
    //   83: aload 4
    //   85: ldc_w 292
    //   88: bipush 254
    //   90: aload_0
    //   91: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   94: athrow
    //   95: astore 6
    //   97: new 290	gnu/mapping/WrongType
    //   100: dup
    //   101: aload 6
    //   103: ldc 147
    //   105: iconst_0
    //   106: aload_2
    //   107: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   110: athrow
    //   111: astore 9
    //   113: new 290	gnu/mapping/WrongType
    //   116: dup
    //   117: aload 9
    //   119: ldc 147
    //   121: iconst_2
    //   122: aload 8
    //   124: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   127: athrow
    //   128: astore 12
    //   130: new 290	gnu/mapping/WrongType
    //   133: dup
    //   134: aload 12
    //   136: ldc_w 297
    //   139: bipush 254
    //   141: aload 11
    //   143: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   146: athrow
    //   147: aload_2
    //   148: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   21	27	77	java/lang/ClassCastException
    //   27	33	95	java/lang/ClassCastException
    //   40	50	111	java/lang/ClassCastException
    //   65	71	128	java/lang/ClassCastException
  }

  public static CharSequence makeString(int paramInt)
  {
    return makeString(paramInt, Lit0);
  }

  public static CharSequence makeString(int paramInt, Object paramObject)
  {
    try
    {
      char c = ((Char)paramObject).charValue();
      return new FString(paramInt, c);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.lists.FString.<init>(int,char)", 2, paramObject);
    }
  }

  public static LList string$To$List(CharSequence paramCharSequence)
  {
    LList localLList = LList.Empty;
    int i = stringLength(paramCharSequence);
    Pair localPair;
    for (Object localObject = localLList; ; localObject = localPair)
    {
      int j = i - 1;
      if (j < 0)
        return localObject;
      localPair = new Pair(Char.make(stringRef(paramCharSequence, j)), localObject);
      i = j;
    }
  }

  public static FString stringAppend(Object[] paramArrayOfObject)
  {
    FString localFString = new FString();
    localFString.addAllStrings(paramArrayOfObject, 0);
    return localFString;
  }

  // ERROR //
  public static CharSequence stringAppend$SlShared(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: ifne +11 -> 13
    //   5: new 57	gnu/lists/FString
    //   8: dup
    //   9: invokespecial 326	gnu/lists/FString:<init>	()V
    //   12: areturn
    //   13: aload_0
    //   14: iconst_0
    //   15: aaload
    //   16: astore_1
    //   17: aload_1
    //   18: instanceof 57
    //   21: ifeq +23 -> 44
    //   24: aload_1
    //   25: checkcast 57	gnu/lists/FString
    //   28: astore 6
    //   30: aload 6
    //   32: astore 4
    //   34: aload 4
    //   36: aload_0
    //   37: iconst_1
    //   38: invokevirtual 330	gnu/lists/FString:addAllStrings	([Ljava/lang/Object;I)V
    //   41: aload 4
    //   43: areturn
    //   44: aload_1
    //   45: checkcast 241	java/lang/CharSequence
    //   48: astore_3
    //   49: aload_3
    //   50: invokestatic 335	kawa/lib/strings:stringCopy	(Ljava/lang/CharSequence;)Lgnu/lists/FString;
    //   53: astore 4
    //   55: goto -21 -> 34
    //   58: astore 5
    //   60: new 290	gnu/mapping/WrongType
    //   63: dup
    //   64: aload 5
    //   66: ldc_w 337
    //   69: bipush 254
    //   71: aload_1
    //   72: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   75: athrow
    //   76: astore_2
    //   77: new 290	gnu/mapping/WrongType
    //   80: dup
    //   81: aload_2
    //   82: ldc 112
    //   84: iconst_0
    //   85: aload_1
    //   86: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   89: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   24	30	58	java/lang/ClassCastException
    //   44	49	76	java/lang/ClassCastException
  }

  public static CharSequence stringCapitalize(CharSequence paramCharSequence)
  {
    FString localFString = stringCopy(paramCharSequence);
    Strings.makeCapitalize(localFString);
    return localFString;
  }

  public static CharSequence stringCapitalize$Ex(CharSeq paramCharSeq)
  {
    Strings.makeCapitalize(paramCharSeq);
    return paramCharSeq;
  }

  public static FString stringCopy(CharSequence paramCharSequence)
  {
    return new FString(paramCharSequence);
  }

  public static CharSequence stringDowncase$Ex(CharSeq paramCharSeq)
  {
    Strings.makeLowerCase(paramCharSeq);
    return paramCharSeq;
  }

  public static void stringFill$Ex(CharSeq paramCharSeq, char paramChar)
  {
    paramCharSeq.fill(paramChar);
  }

  public static int stringLength(CharSequence paramCharSequence)
  {
    return paramCharSequence.length();
  }

  public static char stringRef(CharSequence paramCharSequence, int paramInt)
  {
    return paramCharSequence.charAt(paramInt);
  }

  public static void stringSet$Ex(CharSeq paramCharSeq, int paramInt, char paramChar)
  {
    paramCharSeq.setCharAt(paramInt, paramChar);
  }

  public static CharSequence stringUpcase$Ex(CharSeq paramCharSeq)
  {
    Strings.makeUpperCase(paramCharSeq);
    return paramCharSeq;
  }

  public static CharSequence substring(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return new FString(paramCharSequence, paramInt1, paramInt2 - paramInt1);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 382	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+100 -> 104, 1:+107->111, 2:+122->126, 3:+100->104, 4:+100->104, 5:+137->141, 6:+100->104, 7:+100->104, 8:+100->104, 9:+100->104, 10:+100->104, 11:+100->104, 12:+100->104, 13:+100->104, 14:+152->156, 15:+164->168, 16:+176->180, 17:+100->104, 18:+188->192, 19:+200->204, 20:+212->216, 21:+224->228
    //   105: aload_1
    //   106: aload_2
    //   107: invokespecial 384	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: areturn
    //   111: aload_2
    //   112: invokestatic 386	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   115: ifeq +7 -> 122
    //   118: getstatic 392	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   121: areturn
    //   122: getstatic 395	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   125: areturn
    //   126: aload_2
    //   127: checkcast 397	java/lang/Number
    //   130: invokevirtual 400	java/lang/Number:intValue	()I
    //   133: istore 20
    //   135: iload 20
    //   137: invokestatic 402	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   140: areturn
    //   141: aload_2
    //   142: checkcast 241	java/lang/CharSequence
    //   145: astore 18
    //   147: aload 18
    //   149: invokestatic 316	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   152: invokestatic 408	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: areturn
    //   156: aload_2
    //   157: checkcast 241	java/lang/CharSequence
    //   160: astore 16
    //   162: aload 16
    //   164: invokestatic 410	kawa/lib/strings:string$To$List	(Ljava/lang/CharSequence;)Lgnu/lists/LList;
    //   167: areturn
    //   168: aload_2
    //   169: checkcast 288	gnu/lists/LList
    //   172: astore 14
    //   174: aload 14
    //   176: invokestatic 412	kawa/lib/strings:list$To$String	(Lgnu/lists/LList;)Ljava/lang/CharSequence;
    //   179: areturn
    //   180: aload_2
    //   181: checkcast 241	java/lang/CharSequence
    //   184: astore 12
    //   186: aload 12
    //   188: invokestatic 335	kawa/lib/strings:stringCopy	(Ljava/lang/CharSequence;)Lgnu/lists/FString;
    //   191: areturn
    //   192: aload_2
    //   193: checkcast 276	gnu/lists/CharSeq
    //   196: astore 10
    //   198: aload 10
    //   200: invokestatic 414	kawa/lib/strings:stringUpcase$Ex	(Lgnu/lists/CharSeq;)Ljava/lang/CharSequence;
    //   203: areturn
    //   204: aload_2
    //   205: checkcast 276	gnu/lists/CharSeq
    //   208: astore 8
    //   210: aload 8
    //   212: invokestatic 416	kawa/lib/strings:stringDowncase$Ex	(Lgnu/lists/CharSeq;)Ljava/lang/CharSequence;
    //   215: areturn
    //   216: aload_2
    //   217: checkcast 276	gnu/lists/CharSeq
    //   220: astore 6
    //   222: aload 6
    //   224: invokestatic 418	kawa/lib/strings:stringCapitalize$Ex	(Lgnu/lists/CharSeq;)Ljava/lang/CharSequence;
    //   227: areturn
    //   228: aload_2
    //   229: checkcast 241	java/lang/CharSequence
    //   232: astore 4
    //   234: aload 4
    //   236: invokestatic 420	kawa/lib/strings:stringCapitalize	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   239: areturn
    //   240: astore 19
    //   242: new 290	gnu/mapping/WrongType
    //   245: dup
    //   246: aload 19
    //   248: ldc 162
    //   250: iconst_1
    //   251: aload_2
    //   252: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    //   256: astore 17
    //   258: new 290	gnu/mapping/WrongType
    //   261: dup
    //   262: aload 17
    //   264: ldc 155
    //   266: iconst_1
    //   267: aload_2
    //   268: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   271: athrow
    //   272: astore 15
    //   274: new 290	gnu/mapping/WrongType
    //   277: dup
    //   278: aload 15
    //   280: ldc 120
    //   282: iconst_1
    //   283: aload_2
    //   284: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   287: athrow
    //   288: astore 13
    //   290: new 290	gnu/mapping/WrongType
    //   293: dup
    //   294: aload 13
    //   296: ldc 116
    //   298: iconst_1
    //   299: aload_2
    //   300: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   303: athrow
    //   304: astore 11
    //   306: new 290	gnu/mapping/WrongType
    //   309: dup
    //   310: aload 11
    //   312: ldc 112
    //   314: iconst_1
    //   315: aload_2
    //   316: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   319: athrow
    //   320: astore 9
    //   322: new 290	gnu/mapping/WrongType
    //   325: dup
    //   326: aload 9
    //   328: ldc 104
    //   330: iconst_1
    //   331: aload_2
    //   332: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   335: athrow
    //   336: astore 7
    //   338: new 290	gnu/mapping/WrongType
    //   341: dup
    //   342: aload 7
    //   344: ldc 100
    //   346: iconst_1
    //   347: aload_2
    //   348: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   351: athrow
    //   352: astore 5
    //   354: new 290	gnu/mapping/WrongType
    //   357: dup
    //   358: aload 5
    //   360: ldc 96
    //   362: iconst_1
    //   363: aload_2
    //   364: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   367: athrow
    //   368: astore_3
    //   369: new 290	gnu/mapping/WrongType
    //   372: dup
    //   373: aload_3
    //   374: ldc 92
    //   376: iconst_1
    //   377: aload_2
    //   378: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   381: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   126	135	240	java/lang/ClassCastException
    //   141	147	256	java/lang/ClassCastException
    //   156	162	272	java/lang/ClassCastException
    //   168	174	288	java/lang/ClassCastException
    //   180	186	304	java/lang/ClassCastException
    //   192	198	320	java/lang/ClassCastException
    //   204	210	336	java/lang/ClassCastException
    //   216	222	352	java/lang/ClassCastException
    //   228	234	368	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 382	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+80 -> 84, 2:+88->92, 3:+80->84, 4:+80->84, 5:+80->84, 6:+104->108, 7:+80->84, 8:+130->134, 9:+146->150, 10:+162->166, 11:+178->182, 12:+194->198, 13:+80->84, 14:+80->84, 15:+80->84, 16:+80->84, 17:+210->214
    //   85: aload_1
    //   86: aload_2
    //   87: aload_3
    //   88: invokespecial 424	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: areturn
    //   92: aload_2
    //   93: checkcast 397	java/lang/Number
    //   96: invokevirtual 400	java/lang/Number:intValue	()I
    //   99: istore 13
    //   101: iload 13
    //   103: aload_3
    //   104: invokestatic 302	kawa/lib/strings:makeString	(ILjava/lang/Object;)Ljava/lang/CharSequence;
    //   107: areturn
    //   108: aload_2
    //   109: checkcast 241	java/lang/CharSequence
    //   112: astore 9
    //   114: aload_3
    //   115: checkcast 397	java/lang/Number
    //   118: invokevirtual 400	java/lang/Number:intValue	()I
    //   121: istore 11
    //   123: aload 9
    //   125: iload 11
    //   127: invokestatic 320	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   130: invokestatic 172	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   133: areturn
    //   134: aload_2
    //   135: aload_3
    //   136: invokestatic 426	kawa/lib/strings:isString$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   139: ifeq +7 -> 146
    //   142: getstatic 392	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   145: areturn
    //   146: getstatic 395	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   149: areturn
    //   150: aload_2
    //   151: aload_3
    //   152: invokestatic 428	kawa/lib/strings:isString$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   155: ifeq +7 -> 162
    //   158: getstatic 392	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   161: areturn
    //   162: getstatic 395	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   165: areturn
    //   166: aload_2
    //   167: aload_3
    //   168: invokestatic 430	kawa/lib/strings:isString$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   171: ifeq +7 -> 178
    //   174: getstatic 392	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   177: areturn
    //   178: getstatic 395	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   181: areturn
    //   182: aload_2
    //   183: aload_3
    //   184: invokestatic 432	kawa/lib/strings:isString$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   187: ifeq +7 -> 194
    //   190: getstatic 392	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   193: areturn
    //   194: getstatic 395	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   197: areturn
    //   198: aload_2
    //   199: aload_3
    //   200: invokestatic 434	kawa/lib/strings:isString$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   203: ifeq +7 -> 210
    //   206: getstatic 392	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   209: areturn
    //   210: getstatic 395	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   213: areturn
    //   214: aload_2
    //   215: checkcast 276	gnu/lists/CharSeq
    //   218: astore 5
    //   220: aload_3
    //   221: checkcast 63	gnu/text/Char
    //   224: invokevirtual 67	gnu/text/Char:charValue	()C
    //   227: istore 7
    //   229: aload 5
    //   231: iload 7
    //   233: invokestatic 436	kawa/lib/strings:stringFill$Ex	(Lgnu/lists/CharSeq;C)V
    //   236: getstatic 442	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   239: areturn
    //   240: astore 12
    //   242: new 290	gnu/mapping/WrongType
    //   245: dup
    //   246: aload 12
    //   248: ldc 162
    //   250: iconst_1
    //   251: aload_2
    //   252: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    //   256: astore 8
    //   258: new 290	gnu/mapping/WrongType
    //   261: dup
    //   262: aload 8
    //   264: ldc 151
    //   266: iconst_1
    //   267: aload_2
    //   268: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   271: athrow
    //   272: astore 10
    //   274: new 290	gnu/mapping/WrongType
    //   277: dup
    //   278: aload 10
    //   280: ldc 151
    //   282: iconst_2
    //   283: aload_3
    //   284: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   287: athrow
    //   288: astore 4
    //   290: new 290	gnu/mapping/WrongType
    //   293: dup
    //   294: aload 4
    //   296: ldc 108
    //   298: iconst_1
    //   299: aload_2
    //   300: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   303: athrow
    //   304: astore 6
    //   306: new 290	gnu/mapping/WrongType
    //   309: dup
    //   310: aload 6
    //   312: ldc 108
    //   314: iconst_2
    //   315: aload_3
    //   316: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   319: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   92	101	240	java/lang/ClassCastException
    //   108	114	256	java/lang/ClassCastException
    //   114	123	272	java/lang/ClassCastException
    //   214	220	288	java/lang/ClassCastException
    //   220	229	304	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 382	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 7:+38->42, 13:+76->80
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: aload 4
    //   38: invokespecial 446	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: areturn
    //   42: aload_2
    //   43: checkcast 276	gnu/lists/CharSeq
    //   46: astore 12
    //   48: aload_3
    //   49: checkcast 397	java/lang/Number
    //   52: invokevirtual 400	java/lang/Number:intValue	()I
    //   55: istore 14
    //   57: aload 4
    //   59: checkcast 63	gnu/text/Char
    //   62: invokevirtual 67	gnu/text/Char:charValue	()C
    //   65: istore 16
    //   67: aload 12
    //   69: iload 14
    //   71: iload 16
    //   73: invokestatic 283	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   76: getstatic 442	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   79: areturn
    //   80: aload_2
    //   81: checkcast 241	java/lang/CharSequence
    //   84: astore 6
    //   86: aload_3
    //   87: checkcast 397	java/lang/Number
    //   90: invokevirtual 400	java/lang/Number:intValue	()I
    //   93: istore 8
    //   95: aload 4
    //   97: checkcast 397	java/lang/Number
    //   100: invokevirtual 400	java/lang/Number:intValue	()I
    //   103: istore 10
    //   105: aload 6
    //   107: iload 8
    //   109: iload 10
    //   111: invokestatic 448	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   114: areturn
    //   115: astore 11
    //   117: new 290	gnu/mapping/WrongType
    //   120: dup
    //   121: aload 11
    //   123: ldc 147
    //   125: iconst_1
    //   126: aload_2
    //   127: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   130: athrow
    //   131: astore 13
    //   133: new 290	gnu/mapping/WrongType
    //   136: dup
    //   137: aload 13
    //   139: ldc 147
    //   141: iconst_2
    //   142: aload_3
    //   143: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   146: athrow
    //   147: astore 15
    //   149: new 290	gnu/mapping/WrongType
    //   152: dup
    //   153: aload 15
    //   155: ldc 147
    //   157: iconst_3
    //   158: aload 4
    //   160: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   163: athrow
    //   164: astore 5
    //   166: new 290	gnu/mapping/WrongType
    //   169: dup
    //   170: aload 5
    //   172: ldc 123
    //   174: iconst_1
    //   175: aload_2
    //   176: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   179: athrow
    //   180: astore 7
    //   182: new 290	gnu/mapping/WrongType
    //   185: dup
    //   186: aload 7
    //   188: ldc 123
    //   190: iconst_2
    //   191: aload_3
    //   192: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   195: athrow
    //   196: astore 9
    //   198: new 290	gnu/mapping/WrongType
    //   201: dup
    //   202: aload 9
    //   204: ldc 123
    //   206: iconst_3
    //   207: aload 4
    //   209: invokespecial 295	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   212: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   42	48	115	java/lang/ClassCastException
    //   48	57	131	java/lang/ClassCastException
    //   57	67	147	java/lang/ClassCastException
    //   80	86	164	java/lang/ClassCastException
    //   86	95	180	java/lang/ClassCastException
    //   95	105	196	java/lang/ClassCastException
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 4:
      return $make$string$(paramArrayOfObject);
    case 22:
      return stringAppend(paramArrayOfObject);
    case 23:
    }
    return stringAppend$SlShared(paramArrayOfObject);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 3:
    case 4:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 17:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 21:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 20:
      if (!(paramObject instanceof CharSeq))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 19:
      if (!(paramObject instanceof CharSeq))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 18:
      if (!(paramObject instanceof CharSeq))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 16:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 15:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 14:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 5:
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
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
    case 3:
    case 4:
    case 5:
    case 7:
    case 13:
    case 14:
    case 15:
    case 16:
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 17:
      if (!(paramObject1 instanceof CharSeq))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof Char))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 12:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 11:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 10:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 9:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 8:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 6:
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 2:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 13:
      if ((paramObject1 instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786431;
    case 7:
    }
    if (!(paramObject1 instanceof CharSeq))
      return -786431;
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    if ((paramObject3 instanceof Char))
    {
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    return -786429;
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 23:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 22:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 4:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.strings
 * JD-Core Version:    0.6.2
 */