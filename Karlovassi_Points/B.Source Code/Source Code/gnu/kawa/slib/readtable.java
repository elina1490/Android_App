package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderDispatch;
import gnu.kawa.lispexpr.ReaderMacro;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Char;

public class readtable extends ModuleBody
{
  public static final readtable $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6 = (SimpleSymbol)new SimpleSymbol("define-reader-ctor").readResolve();
  public static final ModuleMethod current$Mnreadtable;
  public static final ModuleMethod define$Mnreader$Mnctor;
  public static final ModuleMethod get$Mndispatch$Mnmacro$Mntable;
  public static final ModuleMethod make$Mndispatch$Mnmacro$Mncharacter;
  public static final ModuleMethod readtable$Qu;
  public static final ModuleMethod set$Mndispatch$Mnmacro$Mncharacter;
  public static final ModuleMethod set$Mnmacro$Mncharacter;

  static
  {
    Lit5 = (SimpleSymbol)new SimpleSymbol("get-dispatch-macro-table").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("set-dispatch-macro-character").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("make-dispatch-macro-character").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("set-macro-character").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("readtable?").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("current-readtable").readResolve();
    $instance = new readtable();
    readtable localreadtable = $instance;
    current$Mnreadtable = new ModuleMethod(localreadtable, 1, Lit0, 0);
    readtable$Qu = new ModuleMethod(localreadtable, 2, Lit1, 4097);
    set$Mnmacro$Mncharacter = new ModuleMethod(localreadtable, 3, Lit2, 16386);
    make$Mndispatch$Mnmacro$Mncharacter = new ModuleMethod(localreadtable, 6, Lit3, 12289);
    set$Mndispatch$Mnmacro$Mncharacter = new ModuleMethod(localreadtable, 9, Lit4, 16387);
    get$Mndispatch$Mnmacro$Mntable = new ModuleMethod(localreadtable, 11, Lit5, 12290);
    define$Mnreader$Mnctor = new ModuleMethod(localreadtable, 13, Lit6, 12290);
    $instance.run();
  }

  public readtable()
  {
    ModuleInfo.register(this);
  }

  public static ReadTable currentReadtable()
  {
    return ReadTable.getCurrent();
  }

  public static void defineReaderCtor(Symbol paramSymbol, Procedure paramProcedure)
  {
    defineReaderCtor(paramSymbol, paramProcedure, currentReadtable());
  }

  public static void defineReaderCtor(Symbol paramSymbol, Procedure paramProcedure, ReadTable paramReadTable)
  {
    if (paramSymbol == null);
    for (String str = null; ; str = paramSymbol.toString())
    {
      paramReadTable.putReaderCtor(str, paramProcedure);
      return;
    }
  }

  public static Object getDispatchMacroTable(char paramChar1, char paramChar2)
  {
    return getDispatchMacroTable(paramChar1, paramChar2, currentReadtable());
  }

  public static Object getDispatchMacroTable(char paramChar1, char paramChar2, ReadTable paramReadTable)
  {
    ReadTableEntry localReadTableEntry1 = paramReadTable.lookup(paramChar1);
    try
    {
      ReaderDispatch localReaderDispatch = (ReaderDispatch)localReadTableEntry1;
      ReadTableEntry localReadTableEntry2 = localReaderDispatch.lookup(paramChar2);
      if (localReadTableEntry2 == null)
        return Boolean.FALSE;
      return localReadTableEntry2;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "disp-entry", -2, localReadTableEntry1);
    }
  }

  public static boolean isReadtable(Object paramObject)
  {
    return paramObject instanceof ReadTable;
  }

  public static void makeDispatchMacroCharacter(char paramChar)
  {
    makeDispatchMacroCharacter(paramChar, false);
  }

  public static void makeDispatchMacroCharacter(char paramChar, boolean paramBoolean)
  {
    makeDispatchMacroCharacter(paramChar, paramBoolean, currentReadtable());
  }

  public static void makeDispatchMacroCharacter(char paramChar, boolean paramBoolean, ReadTable paramReadTable)
  {
    paramReadTable.set(paramChar, new ReaderDispatch(paramBoolean));
  }

  public static void setDispatchMacroCharacter(char paramChar1, char paramChar2, Object paramObject)
  {
    setDispatchMacroCharacter(paramChar1, paramChar2, paramObject, currentReadtable());
  }

  // ERROR //
  public static void setDispatchMacroCharacter(char paramChar1, char paramChar2, Object paramObject, ReadTable paramReadTable)
  {
    // Byte code:
    //   0: aload_3
    //   1: iload_0
    //   2: invokevirtual 130	gnu/kawa/lispexpr/ReadTable:lookup	(I)Lgnu/kawa/lispexpr/ReadTableEntry;
    //   5: astore 4
    //   7: aload 4
    //   9: checkcast 132	gnu/kawa/lispexpr/ReaderDispatch
    //   12: astore 6
    //   14: aload_2
    //   15: checkcast 170	gnu/mapping/Procedure
    //   18: astore 8
    //   20: aload 6
    //   22: iload_1
    //   23: new 172	gnu/kawa/lispexpr/ReaderDispatchMacro
    //   26: dup
    //   27: aload 8
    //   29: invokespecial 175	gnu/kawa/lispexpr/ReaderDispatchMacro:<init>	(Lgnu/mapping/Procedure;)V
    //   32: invokevirtual 176	gnu/kawa/lispexpr/ReaderDispatch:set	(ILjava/lang/Object;)V
    //   35: return
    //   36: astore 5
    //   38: new 141	gnu/mapping/WrongType
    //   41: dup
    //   42: aload 5
    //   44: ldc 178
    //   46: bipush 254
    //   48: aload 4
    //   50: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   53: athrow
    //   54: astore 7
    //   56: new 141	gnu/mapping/WrongType
    //   59: dup
    //   60: aload 7
    //   62: ldc 180
    //   64: iconst_1
    //   65: aload_2
    //   66: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   69: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   7	14	36	java/lang/ClassCastException
    //   14	20	54	java/lang/ClassCastException
  }

  public static void setMacroCharacter(char paramChar, Object paramObject)
  {
    setMacroCharacter(paramChar, paramObject, false);
  }

  public static void setMacroCharacter(char paramChar, Object paramObject, boolean paramBoolean)
  {
    setMacroCharacter(paramChar, paramObject, paramBoolean, currentReadtable());
  }

  public static void setMacroCharacter(char paramChar, Object paramObject, boolean paramBoolean, ReadTable paramReadTable)
  {
    try
    {
      Procedure localProcedure = (Procedure)paramObject;
      paramReadTable.set(paramChar, new ReaderMacro(localProcedure, paramBoolean));
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "gnu.kawa.lispexpr.ReaderMacro.<init>(gnu.mapping.Procedure,boolean)", 1, paramObject);
    }
  }

  public Object apply0(ModuleMethod paramModuleMethod)
  {
    if (paramModuleMethod.selector == 1)
      return currentReadtable();
    return super.apply0(paramModuleMethod);
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply1(paramModuleMethod, paramObject);
    case 2:
      if (isReadtable(paramObject))
        return Boolean.TRUE;
      return Boolean.FALSE;
    case 6:
    }
    try
    {
      char c = ((Char)paramObject).charValue();
      makeDispatchMacroCharacter(c);
      return Values.empty;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "make-dispatch-macro-character", 1, paramObject);
    }
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 201	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+44->48, 3:+52->56, 6:+71->75, 11:+111->115, 13:+137->141
    //   49: aload_1
    //   50: aload_2
    //   51: aload_3
    //   52: invokespecial 230	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: areturn
    //   56: aload_2
    //   57: checkcast 214	gnu/text/Char
    //   60: invokevirtual 218	gnu/text/Char:charValue	()C
    //   63: istore 18
    //   65: iload 18
    //   67: aload_3
    //   68: invokestatic 232	gnu/kawa/slib/readtable:setMacroCharacter	(CLjava/lang/Object;)V
    //   71: getstatic 226	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   74: areturn
    //   75: aload_2
    //   76: checkcast 214	gnu/text/Char
    //   79: invokevirtual 218	gnu/text/Char:charValue	()C
    //   82: istore 13
    //   84: getstatic 139	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   87: astore 15
    //   89: aload_3
    //   90: aload 15
    //   92: if_acmpeq +17 -> 109
    //   95: iconst_1
    //   96: istore 16
    //   98: iload 13
    //   100: iload 16
    //   102: invokestatic 153	gnu/kawa/slib/readtable:makeDispatchMacroCharacter	(CZ)V
    //   105: getstatic 226	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   108: areturn
    //   109: iconst_0
    //   110: istore 16
    //   112: goto -14 -> 98
    //   115: aload_2
    //   116: checkcast 214	gnu/text/Char
    //   119: invokevirtual 218	gnu/text/Char:charValue	()C
    //   122: istore 9
    //   124: aload_3
    //   125: checkcast 214	gnu/text/Char
    //   128: invokevirtual 218	gnu/text/Char:charValue	()C
    //   131: istore 11
    //   133: iload 9
    //   135: iload 11
    //   137: invokestatic 234	gnu/kawa/slib/readtable:getDispatchMacroTable	(CC)Ljava/lang/Object;
    //   140: areturn
    //   141: aload_2
    //   142: checkcast 236	gnu/mapping/Symbol
    //   145: astore 5
    //   147: aload_3
    //   148: checkcast 170	gnu/mapping/Procedure
    //   151: astore 7
    //   153: aload 5
    //   155: aload 7
    //   157: invokestatic 238	gnu/kawa/slib/readtable:defineReaderCtor	(Lgnu/mapping/Symbol;Lgnu/mapping/Procedure;)V
    //   160: getstatic 226	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   163: areturn
    //   164: astore 17
    //   166: new 141	gnu/mapping/WrongType
    //   169: dup
    //   170: aload 17
    //   172: ldc 52
    //   174: iconst_1
    //   175: aload_2
    //   176: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   179: athrow
    //   180: astore 12
    //   182: new 141	gnu/mapping/WrongType
    //   185: dup
    //   186: aload 12
    //   188: ldc 48
    //   190: iconst_1
    //   191: aload_2
    //   192: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   195: athrow
    //   196: astore 14
    //   198: new 141	gnu/mapping/WrongType
    //   201: dup
    //   202: aload 14
    //   204: ldc 48
    //   206: iconst_2
    //   207: aload_3
    //   208: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   211: athrow
    //   212: astore 8
    //   214: new 141	gnu/mapping/WrongType
    //   217: dup
    //   218: aload 8
    //   220: ldc 40
    //   222: iconst_1
    //   223: aload_2
    //   224: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   227: athrow
    //   228: astore 10
    //   230: new 141	gnu/mapping/WrongType
    //   233: dup
    //   234: aload 10
    //   236: ldc 40
    //   238: iconst_2
    //   239: aload_3
    //   240: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   243: athrow
    //   244: astore 4
    //   246: new 141	gnu/mapping/WrongType
    //   249: dup
    //   250: aload 4
    //   252: ldc 28
    //   254: iconst_1
    //   255: aload_2
    //   256: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   259: athrow
    //   260: astore 6
    //   262: new 141	gnu/mapping/WrongType
    //   265: dup
    //   266: aload 6
    //   268: ldc 28
    //   270: iconst_2
    //   271: aload_3
    //   272: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   275: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   56	65	164	java/lang/ClassCastException
    //   75	84	180	java/lang/ClassCastException
    //   84	89	196	java/lang/ClassCastException
    //   115	124	212	java/lang/ClassCastException
    //   124	133	228	java/lang/ClassCastException
    //   141	147	244	java/lang/ClassCastException
    //   147	153	260	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 201	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+60 -> 64, 3:+70->74, 4:+60->64, 5:+60->64, 6:+112->116, 7:+60->64, 8:+60->64, 9:+161->165, 10:+60->64, 11:+192->196, 12:+60->64, 13:+227->231
    //   65: aload_1
    //   66: aload_2
    //   67: aload_3
    //   68: aload 4
    //   70: invokespecial 242	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: areturn
    //   74: aload_2
    //   75: checkcast 214	gnu/text/Char
    //   78: invokevirtual 218	gnu/text/Char:charValue	()C
    //   81: istore 29
    //   83: getstatic 139	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   86: astore 31
    //   88: aload 4
    //   90: aload 31
    //   92: if_acmpeq +18 -> 110
    //   95: iconst_1
    //   96: istore 32
    //   98: iload 29
    //   100: aload_3
    //   101: iload 32
    //   103: invokestatic 185	gnu/kawa/slib/readtable:setMacroCharacter	(CLjava/lang/Object;Z)V
    //   106: getstatic 226	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   109: areturn
    //   110: iconst_0
    //   111: istore 32
    //   113: goto -15 -> 98
    //   116: aload_2
    //   117: checkcast 214	gnu/text/Char
    //   120: invokevirtual 218	gnu/text/Char:charValue	()C
    //   123: istore 22
    //   125: getstatic 139	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   128: astore 24
    //   130: aload_3
    //   131: aload 24
    //   133: if_acmpeq +26 -> 159
    //   136: iconst_1
    //   137: istore 25
    //   139: aload 4
    //   141: checkcast 99	gnu/kawa/lispexpr/ReadTable
    //   144: astore 27
    //   146: iload 22
    //   148: iload 25
    //   150: aload 27
    //   152: invokestatic 156	gnu/kawa/slib/readtable:makeDispatchMacroCharacter	(CZLgnu/kawa/lispexpr/ReadTable;)V
    //   155: getstatic 226	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   158: areturn
    //   159: iconst_0
    //   160: istore 25
    //   162: goto -23 -> 139
    //   165: aload_2
    //   166: checkcast 214	gnu/text/Char
    //   169: invokevirtual 218	gnu/text/Char:charValue	()C
    //   172: istore 18
    //   174: aload_3
    //   175: checkcast 214	gnu/text/Char
    //   178: invokevirtual 218	gnu/text/Char:charValue	()C
    //   181: istore 20
    //   183: iload 18
    //   185: iload 20
    //   187: aload 4
    //   189: invokestatic 244	gnu/kawa/slib/readtable:setDispatchMacroCharacter	(CCLjava/lang/Object;)V
    //   192: getstatic 226	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   195: areturn
    //   196: aload_2
    //   197: checkcast 214	gnu/text/Char
    //   200: invokevirtual 218	gnu/text/Char:charValue	()C
    //   203: istore 12
    //   205: aload_3
    //   206: checkcast 214	gnu/text/Char
    //   209: invokevirtual 218	gnu/text/Char:charValue	()C
    //   212: istore 14
    //   214: aload 4
    //   216: checkcast 99	gnu/kawa/lispexpr/ReadTable
    //   219: astore 16
    //   221: iload 12
    //   223: iload 14
    //   225: aload 16
    //   227: invokestatic 124	gnu/kawa/slib/readtable:getDispatchMacroTable	(CCLgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;
    //   230: areturn
    //   231: aload_2
    //   232: checkcast 236	gnu/mapping/Symbol
    //   235: astore 6
    //   237: aload_3
    //   238: checkcast 170	gnu/mapping/Procedure
    //   241: astore 8
    //   243: aload 4
    //   245: checkcast 99	gnu/kawa/lispexpr/ReadTable
    //   248: astore 10
    //   250: aload 6
    //   252: aload 8
    //   254: aload 10
    //   256: invokestatic 109	gnu/kawa/slib/readtable:defineReaderCtor	(Lgnu/mapping/Symbol;Lgnu/mapping/Procedure;Lgnu/kawa/lispexpr/ReadTable;)V
    //   259: getstatic 226	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   262: areturn
    //   263: astore 28
    //   265: new 141	gnu/mapping/WrongType
    //   268: dup
    //   269: aload 28
    //   271: ldc 52
    //   273: iconst_1
    //   274: aload_2
    //   275: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   278: athrow
    //   279: astore 30
    //   281: new 141	gnu/mapping/WrongType
    //   284: dup
    //   285: aload 30
    //   287: ldc 52
    //   289: iconst_3
    //   290: aload 4
    //   292: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    //   296: astore 21
    //   298: new 141	gnu/mapping/WrongType
    //   301: dup
    //   302: aload 21
    //   304: ldc 48
    //   306: iconst_1
    //   307: aload_2
    //   308: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    //   312: astore 23
    //   314: new 141	gnu/mapping/WrongType
    //   317: dup
    //   318: aload 23
    //   320: ldc 48
    //   322: iconst_2
    //   323: aload_3
    //   324: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   327: athrow
    //   328: astore 26
    //   330: new 141	gnu/mapping/WrongType
    //   333: dup
    //   334: aload 26
    //   336: ldc 48
    //   338: iconst_3
    //   339: aload 4
    //   341: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   344: athrow
    //   345: astore 17
    //   347: new 141	gnu/mapping/WrongType
    //   350: dup
    //   351: aload 17
    //   353: ldc 44
    //   355: iconst_1
    //   356: aload_2
    //   357: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   360: athrow
    //   361: astore 19
    //   363: new 141	gnu/mapping/WrongType
    //   366: dup
    //   367: aload 19
    //   369: ldc 44
    //   371: iconst_2
    //   372: aload_3
    //   373: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   376: athrow
    //   377: astore 11
    //   379: new 141	gnu/mapping/WrongType
    //   382: dup
    //   383: aload 11
    //   385: ldc 40
    //   387: iconst_1
    //   388: aload_2
    //   389: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   392: athrow
    //   393: astore 13
    //   395: new 141	gnu/mapping/WrongType
    //   398: dup
    //   399: aload 13
    //   401: ldc 40
    //   403: iconst_2
    //   404: aload_3
    //   405: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   408: athrow
    //   409: astore 15
    //   411: new 141	gnu/mapping/WrongType
    //   414: dup
    //   415: aload 15
    //   417: ldc 40
    //   419: iconst_3
    //   420: aload 4
    //   422: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   425: athrow
    //   426: astore 5
    //   428: new 141	gnu/mapping/WrongType
    //   431: dup
    //   432: aload 5
    //   434: ldc 28
    //   436: iconst_1
    //   437: aload_2
    //   438: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   441: athrow
    //   442: astore 7
    //   444: new 141	gnu/mapping/WrongType
    //   447: dup
    //   448: aload 7
    //   450: ldc 28
    //   452: iconst_2
    //   453: aload_3
    //   454: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   457: athrow
    //   458: astore 9
    //   460: new 141	gnu/mapping/WrongType
    //   463: dup
    //   464: aload 9
    //   466: ldc 28
    //   468: iconst_3
    //   469: aload 4
    //   471: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   474: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   74	83	263	java/lang/ClassCastException
    //   83	88	279	java/lang/ClassCastException
    //   116	125	296	java/lang/ClassCastException
    //   125	130	312	java/lang/ClassCastException
    //   139	146	328	java/lang/ClassCastException
    //   165	174	345	java/lang/ClassCastException
    //   174	183	361	java/lang/ClassCastException
    //   196	205	377	java/lang/ClassCastException
    //   205	214	393	java/lang/ClassCastException
    //   214	221	409	java/lang/ClassCastException
    //   231	237	426	java/lang/ClassCastException
    //   237	243	442	java/lang/ClassCastException
    //   243	250	458	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 201	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 3:+40->44, 9:+91->95
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: aload 4
    //   38: aload 5
    //   40: invokespecial 248	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: areturn
    //   44: aload_2
    //   45: checkcast 214	gnu/text/Char
    //   48: invokevirtual 218	gnu/text/Char:charValue	()C
    //   51: istore 13
    //   53: getstatic 139	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   56: astore 15
    //   58: aload 4
    //   60: aload 15
    //   62: if_acmpeq +27 -> 89
    //   65: iconst_1
    //   66: istore 16
    //   68: aload 5
    //   70: checkcast 99	gnu/kawa/lispexpr/ReadTable
    //   73: astore 18
    //   75: iload 13
    //   77: aload_3
    //   78: iload 16
    //   80: aload 18
    //   82: invokestatic 188	gnu/kawa/slib/readtable:setMacroCharacter	(CLjava/lang/Object;ZLgnu/kawa/lispexpr/ReadTable;)V
    //   85: getstatic 226	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   88: areturn
    //   89: iconst_0
    //   90: istore 16
    //   92: goto -24 -> 68
    //   95: aload_2
    //   96: checkcast 214	gnu/text/Char
    //   99: invokevirtual 218	gnu/text/Char:charValue	()C
    //   102: istore 7
    //   104: aload_3
    //   105: checkcast 214	gnu/text/Char
    //   108: invokevirtual 218	gnu/text/Char:charValue	()C
    //   111: istore 9
    //   113: aload 5
    //   115: checkcast 99	gnu/kawa/lispexpr/ReadTable
    //   118: astore 11
    //   120: iload 7
    //   122: iload 9
    //   124: aload 4
    //   126: aload 11
    //   128: invokestatic 168	gnu/kawa/slib/readtable:setDispatchMacroCharacter	(CCLjava/lang/Object;Lgnu/kawa/lispexpr/ReadTable;)V
    //   131: getstatic 226	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   134: areturn
    //   135: astore 12
    //   137: new 141	gnu/mapping/WrongType
    //   140: dup
    //   141: aload 12
    //   143: ldc 52
    //   145: iconst_1
    //   146: aload_2
    //   147: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   150: athrow
    //   151: astore 14
    //   153: new 141	gnu/mapping/WrongType
    //   156: dup
    //   157: aload 14
    //   159: ldc 52
    //   161: iconst_3
    //   162: aload 4
    //   164: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   167: athrow
    //   168: astore 17
    //   170: new 141	gnu/mapping/WrongType
    //   173: dup
    //   174: aload 17
    //   176: ldc 52
    //   178: iconst_4
    //   179: aload 5
    //   181: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   184: athrow
    //   185: astore 6
    //   187: new 141	gnu/mapping/WrongType
    //   190: dup
    //   191: aload 6
    //   193: ldc 44
    //   195: iconst_1
    //   196: aload_2
    //   197: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    //   201: astore 8
    //   203: new 141	gnu/mapping/WrongType
    //   206: dup
    //   207: aload 8
    //   209: ldc 44
    //   211: iconst_2
    //   212: aload_3
    //   213: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    //   217: astore 10
    //   219: new 141	gnu/mapping/WrongType
    //   222: dup
    //   223: aload 10
    //   225: ldc 44
    //   227: iconst_4
    //   228: aload 5
    //   230: invokespecial 146	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   233: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   44	53	135	java/lang/ClassCastException
    //   53	58	151	java/lang/ClassCastException
    //   68	75	168	java/lang/ClassCastException
    //   95	104	185	java/lang/ClassCastException
    //   104	113	201	java/lang/ClassCastException
    //   113	120	217	java/lang/ClassCastException
  }

  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
    {
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
    return super.match0(paramModuleMethod, paramCallContext);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 6:
      if ((paramObject instanceof Char))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 2:
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
    case 13:
      if (!(paramObject1 instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 11:
      if ((paramObject1 instanceof Char))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof Char))
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
    case 6:
      if ((paramObject1 instanceof Char))
      {
        paramCallContext.value1 = paramObject1;
        if (1 != 0)
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
    case 3:
    }
    if ((paramObject1 instanceof Char))
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return -786431;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 13:
      if (!(paramObject1 instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof ReadTable))
        return -786429;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 11:
      if ((paramObject1 instanceof Char))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof Char))
        {
          paramCallContext.value2 = paramObject2;
          if ((paramObject3 instanceof ReadTable))
            break label189;
          return -786429;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 9:
      if ((paramObject1 instanceof Char))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof Char))
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.value3 = paramObject3;
          paramCallContext.proc = paramModuleMethod;
          paramCallContext.pc = 3;
          return 0;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
    case 6:
      label189: if ((paramObject1 instanceof Char))
      {
        paramCallContext.value1 = paramObject1;
        if (1 != 0)
        {
          paramCallContext.value2 = paramObject2;
          if ((paramObject3 instanceof ReadTable))
            break label308;
          return -786429;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
      label308: paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 3:
    }
    if ((paramObject1 instanceof Char))
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      if (1 != 0)
      {
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
    }
    else
    {
      return -786431;
    }
    return -786429;
  }

  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 9:
      if ((paramObject1 instanceof Char))
      {
        paramCallContext.value1 = paramObject1;
        if ((paramObject2 instanceof Char))
        {
          paramCallContext.value2 = paramObject2;
          paramCallContext.value3 = paramObject3;
          if ((paramObject4 instanceof ReadTable))
            break label99;
          return -786428;
        }
      }
      else
      {
        return -786431;
      }
      return -786430;
      label99: paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 3:
    }
    if ((paramObject1 instanceof Char))
    {
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      if (1 != 0)
      {
        paramCallContext.value3 = paramObject3;
        if ((paramObject4 instanceof ReadTable))
          break label170;
        return -786428;
      }
    }
    else
    {
      return -786431;
    }
    return -786429;
    label170: paramCallContext.value4 = paramObject4;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 4;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.readtable
 * JD-Core Version:    0.6.2
 */