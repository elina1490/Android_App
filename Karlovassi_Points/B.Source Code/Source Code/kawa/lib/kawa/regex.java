package kawa.lib.kawa;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class regex extends ModuleBody
{
  public static final regex $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7 = (SimpleSymbol)new SimpleSymbol("regex-replace*").readResolve();
  public static final ModuleMethod regex$Mnmatch;
  public static final ModuleMethod regex$Mnmatch$Mnpositions;
  public static final ModuleMethod regex$Mnmatch$Qu;
  public static final ModuleMethod regex$Mnquote;
  public static final ModuleMethod regex$Mnreplace;
  public static final ModuleMethod regex$Mnreplace$St;
  public static final ModuleMethod regex$Mnsplit;

  static
  {
    Lit6 = (SimpleSymbol)new SimpleSymbol("regex-replace").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("regex-split").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("regex-match-positions").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("regex-match").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("regex-match?").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("regex-quote").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("loop").readResolve();
    $instance = new regex();
    regex localregex = $instance;
    regex$Mnquote = new ModuleMethod(localregex, 2, Lit1, 4097);
    regex$Mnmatch$Qu = new ModuleMethod(localregex, 3, Lit2, 16386);
    regex$Mnmatch = new ModuleMethod(localregex, 6, Lit3, 16386);
    regex$Mnmatch$Mnpositions = new ModuleMethod(localregex, 9, Lit4, 16386);
    regex$Mnsplit = new ModuleMethod(localregex, 12, Lit5, 8194);
    regex$Mnreplace = new ModuleMethod(localregex, 13, Lit6, 12291);
    regex$Mnreplace$St = new ModuleMethod(localregex, 14, Lit7, 12291);
    $instance.run();
  }

  public regex()
  {
    ModuleInfo.register(this);
  }

  public static boolean isRegexMatch(Object paramObject, CharSequence paramCharSequence)
  {
    return isRegexMatch(paramObject, paramCharSequence, 0);
  }

  public static boolean isRegexMatch(Object paramObject, CharSequence paramCharSequence, int paramInt)
  {
    return isRegexMatch(paramObject, paramCharSequence, paramInt, paramCharSequence.length());
  }

  public static boolean isRegexMatch(Object paramObject, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramObject instanceof Pattern));
    try
    {
      Pattern localPattern2 = (Pattern)paramObject;
      for (Pattern localPattern1 = localPattern2; ; localPattern1 = Pattern.compile(paramObject.toString()))
      {
        Matcher localMatcher = localPattern1.matcher(paramCharSequence);
        localMatcher.region(paramInt1, paramInt2);
        return localMatcher.find();
      }
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "rex", -2, paramObject);
    }
  }

  public static Object regexMatch(Object paramObject, CharSequence paramCharSequence)
  {
    return regexMatch(paramObject, paramCharSequence, 0);
  }

  public static Object regexMatch(Object paramObject, CharSequence paramCharSequence, int paramInt)
  {
    return regexMatch(paramObject, paramCharSequence, paramInt, paramCharSequence.length());
  }

  public static Object regexMatch(Object paramObject, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramObject instanceof Pattern));
    try
    {
      Pattern localPattern2 = (Pattern)paramObject;
      Matcher localMatcher;
      int i;
      Object localObject1;
      for (Pattern localPattern1 = localPattern2; ; localPattern1 = Pattern.compile(paramObject.toString()))
      {
        localMatcher = localPattern1.matcher(paramCharSequence);
        localMatcher.region(paramInt1, paramInt2);
        if (!localMatcher.find())
          break label131;
        i = localMatcher.groupCount();
        localObject1 = LList.Empty;
        if (i >= 0)
          break;
        return localObject1;
      }
      int j = localMatcher.start(i);
      if (j < 0);
      for (Object localObject2 = Boolean.FALSE; ; localObject2 = paramCharSequence.subSequence(j, localMatcher.end(i)))
      {
        Pair localPair = lists.cons(localObject2, localObject1);
        i--;
        localObject1 = localPair;
        break;
      }
      label131: return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "rex", -2, paramObject);
    }
  }

  public static Object regexMatchPositions(Object paramObject, CharSequence paramCharSequence)
  {
    return regexMatchPositions(paramObject, paramCharSequence, 0);
  }

  public static Object regexMatchPositions(Object paramObject, CharSequence paramCharSequence, int paramInt)
  {
    return regexMatchPositions(paramObject, paramCharSequence, paramInt, paramCharSequence.length());
  }

  public static Object regexMatchPositions(Object paramObject, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramObject instanceof Pattern));
    try
    {
      Pattern localPattern2 = (Pattern)paramObject;
      Matcher localMatcher;
      int i;
      Object localObject1;
      for (Pattern localPattern1 = localPattern2; ; localPattern1 = Pattern.compile(paramObject.toString()))
      {
        localMatcher = localPattern1.matcher(paramCharSequence);
        localMatcher.region(paramInt1, paramInt2);
        if (!localMatcher.find())
          break label134;
        i = localMatcher.groupCount();
        localObject1 = LList.Empty;
        if (i >= 0)
          break;
        return localObject1;
      }
      int j = localMatcher.start(i);
      if (j < 0);
      for (Object localObject2 = Boolean.FALSE; ; localObject2 = lists.cons(Integer.valueOf(j), Integer.valueOf(localMatcher.end(i))))
      {
        Pair localPair = lists.cons(localObject2, localObject1);
        i--;
        localObject1 = localPair;
        break;
      }
      label134: return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "rex", -2, paramObject);
    }
  }

  public static String regexQuote(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null);
    for (String str = null; ; str = paramCharSequence.toString())
      return Pattern.quote(str);
  }

  public static CharSequence regexReplace(Object paramObject1, CharSequence paramCharSequence, Object paramObject2)
  {
    if ((paramObject1 instanceof Pattern));
    try
    {
      Pattern localPattern2 = (Pattern)paramObject1;
      Pattern localPattern1 = localPattern2;
      Matcher localMatcher = localPattern1.matcher(paramCharSequence);
      if (localMatcher.find())
      {
        StringBuffer localStringBuffer = new StringBuffer();
        Object localObject;
        String str2;
        label69: String str1;
        if (misc.isProcedure(paramObject2))
        {
          localObject = Scheme.applyToArgs.apply2(paramObject2, localMatcher.group());
          if (localObject == null)
          {
            str2 = null;
            str1 = Matcher.quoteReplacement(str2);
          }
        }
        while (true)
        {
          localMatcher.appendReplacement(localStringBuffer, str1);
          localMatcher.appendTail(localStringBuffer);
          return localStringBuffer.toString();
          localPattern1 = Pattern.compile(paramObject1.toString());
          break;
          str2 = localObject.toString();
          break label69;
          if (paramObject2 == null)
            str1 = null;
          else
            str1 = paramObject2.toString();
        }
      }
      return paramCharSequence;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "rex", -2, paramObject1);
    }
  }

  public static CharSequence regexReplace$St(Object paramObject1, CharSequence paramCharSequence, Object paramObject2)
  {
    frame localframe = new frame();
    localframe.repl = paramObject2;
    if ((paramObject1 instanceof Pattern));
    try
    {
      Pattern localPattern2 = (Pattern)paramObject1;
      for (Pattern localPattern1 = localPattern2; ; localPattern1 = Pattern.compile(paramObject1.toString()))
      {
        localframe.matcher = localPattern1.matcher(paramCharSequence);
        localframe.sbuf = new StringBuffer();
        if (!misc.isProcedure(localframe.repl))
          break;
        localframe.loop = localframe.loop;
        return localframe.lambda1loop();
      }
      Matcher localMatcher = localframe.matcher;
      Object localObject = localframe.repl;
      if (localObject == null);
      for (String str = null; ; str = localObject.toString())
        return localMatcher.replaceAll(str);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "rex", -2, paramObject1);
    }
  }

  public static LList regexSplit(Object paramObject, CharSequence paramCharSequence)
  {
    if ((paramObject instanceof Pattern));
    try
    {
      Pattern localPattern2 = (Pattern)paramObject;
      for (Pattern localPattern1 = localPattern2; ; localPattern1 = Pattern.compile(paramObject.toString()))
        return LList.makeList(localPattern1.split(paramCharSequence, -1), 0);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "rex", -2, paramObject);
    }
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 2);
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject;
      return regexQuote(localCharSequence);
      return super.apply1(paramModuleMethod, paramObject);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "regex-quote", 1, paramObject);
    }
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 283	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+44->48, 3:+52->56, 6:+75->79, 9:+88->92, 12:+101->105
    //   49: aload_1
    //   50: aload_2
    //   51: aload_3
    //   52: invokespecial 290	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: areturn
    //   56: aload_3
    //   57: checkcast 107	java/lang/CharSequence
    //   60: astore 11
    //   62: aload_2
    //   63: aload 11
    //   65: invokestatic 292	kawa/lib/kawa/regex:isRegexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;)Z
    //   68: ifeq +7 -> 75
    //   71: getstatic 295	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   74: areturn
    //   75: getstatic 176	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   78: areturn
    //   79: aload_3
    //   80: checkcast 107	java/lang/CharSequence
    //   83: astore 9
    //   85: aload_2
    //   86: aload 9
    //   88: invokestatic 297	kawa/lib/kawa/regex:regexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   91: areturn
    //   92: aload_3
    //   93: checkcast 107	java/lang/CharSequence
    //   96: astore 7
    //   98: aload_2
    //   99: aload 7
    //   101: invokestatic 299	kawa/lib/kawa/regex:regexMatchPositions	(Ljava/lang/Object;Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   104: areturn
    //   105: aload_3
    //   106: checkcast 107	java/lang/CharSequence
    //   109: astore 5
    //   111: aload_2
    //   112: aload 5
    //   114: invokestatic 301	kawa/lib/kawa/regex:regexSplit	(Ljava/lang/Object;Ljava/lang/CharSequence;)Lgnu/lists/LList;
    //   117: areturn
    //   118: astore 10
    //   120: new 144	gnu/mapping/WrongType
    //   123: dup
    //   124: aload 10
    //   126: ldc 57
    //   128: iconst_2
    //   129: aload_3
    //   130: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   133: athrow
    //   134: astore 8
    //   136: new 144	gnu/mapping/WrongType
    //   139: dup
    //   140: aload 8
    //   142: ldc 53
    //   144: iconst_2
    //   145: aload_3
    //   146: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   149: athrow
    //   150: astore 6
    //   152: new 144	gnu/mapping/WrongType
    //   155: dup
    //   156: aload 6
    //   158: ldc 49
    //   160: iconst_2
    //   161: aload_3
    //   162: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   165: athrow
    //   166: astore 4
    //   168: new 144	gnu/mapping/WrongType
    //   171: dup
    //   172: aload 4
    //   174: ldc 45
    //   176: iconst_2
    //   177: aload_3
    //   178: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   181: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   56	62	118	java/lang/ClassCastException
    //   79	85	134	java/lang/ClassCastException
    //   92	98	150	java/lang/ClassCastException
    //   105	111	166	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 283	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+52->56, 3:+62->66, 6:+97->101, 9:+122->126, 13:+147->151, 14:+162->166
    //   57: aload_1
    //   58: aload_2
    //   59: aload_3
    //   60: aload 4
    //   62: invokespecial 305	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: areturn
    //   66: aload_3
    //   67: checkcast 107	java/lang/CharSequence
    //   70: astore 18
    //   72: aload 4
    //   74: checkcast 307	java/lang/Number
    //   77: invokevirtual 310	java/lang/Number:intValue	()I
    //   80: istore 20
    //   82: aload_2
    //   83: aload 18
    //   85: iload 20
    //   87: invokestatic 105	kawa/lib/kawa/regex:isRegexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;I)Z
    //   90: ifeq +7 -> 97
    //   93: getstatic 295	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   96: areturn
    //   97: getstatic 176	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   100: areturn
    //   101: aload_3
    //   102: checkcast 107	java/lang/CharSequence
    //   105: astore 14
    //   107: aload 4
    //   109: checkcast 307	java/lang/Number
    //   112: invokevirtual 310	java/lang/Number:intValue	()I
    //   115: istore 16
    //   117: aload_2
    //   118: aload 14
    //   120: iload 16
    //   122: invokestatic 154	kawa/lib/kawa/regex:regexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;
    //   125: areturn
    //   126: aload_3
    //   127: checkcast 107	java/lang/CharSequence
    //   130: astore 10
    //   132: aload 4
    //   134: checkcast 307	java/lang/Number
    //   137: invokevirtual 310	java/lang/Number:intValue	()I
    //   140: istore 12
    //   142: aload_2
    //   143: aload 10
    //   145: iload 12
    //   147: invokestatic 192	kawa/lib/kawa/regex:regexMatchPositions	(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;
    //   150: areturn
    //   151: aload_3
    //   152: checkcast 107	java/lang/CharSequence
    //   155: astore 8
    //   157: aload_2
    //   158: aload 8
    //   160: aload 4
    //   162: invokestatic 312	kawa/lib/kawa/regex:regexReplace	(Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   165: areturn
    //   166: aload_3
    //   167: checkcast 107	java/lang/CharSequence
    //   170: astore 6
    //   172: aload_2
    //   173: aload 6
    //   175: aload 4
    //   177: invokestatic 314	kawa/lib/kawa/regex:regexReplace$St	(Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   180: areturn
    //   181: astore 17
    //   183: new 144	gnu/mapping/WrongType
    //   186: dup
    //   187: aload 17
    //   189: ldc 57
    //   191: iconst_2
    //   192: aload_3
    //   193: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    //   197: astore 19
    //   199: new 144	gnu/mapping/WrongType
    //   202: dup
    //   203: aload 19
    //   205: ldc 57
    //   207: iconst_3
    //   208: aload 4
    //   210: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   213: athrow
    //   214: astore 13
    //   216: new 144	gnu/mapping/WrongType
    //   219: dup
    //   220: aload 13
    //   222: ldc 53
    //   224: iconst_2
    //   225: aload_3
    //   226: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: astore 15
    //   232: new 144	gnu/mapping/WrongType
    //   235: dup
    //   236: aload 15
    //   238: ldc 53
    //   240: iconst_3
    //   241: aload 4
    //   243: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: astore 9
    //   249: new 144	gnu/mapping/WrongType
    //   252: dup
    //   253: aload 9
    //   255: ldc 49
    //   257: iconst_2
    //   258: aload_3
    //   259: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   262: athrow
    //   263: astore 11
    //   265: new 144	gnu/mapping/WrongType
    //   268: dup
    //   269: aload 11
    //   271: ldc 49
    //   273: iconst_3
    //   274: aload 4
    //   276: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: astore 7
    //   282: new 144	gnu/mapping/WrongType
    //   285: dup
    //   286: aload 7
    //   288: ldc 41
    //   290: iconst_2
    //   291: aload_3
    //   292: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    //   296: astore 5
    //   298: new 144	gnu/mapping/WrongType
    //   301: dup
    //   302: aload 5
    //   304: ldc 29
    //   306: iconst_2
    //   307: aload_3
    //   308: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   66	72	181	java/lang/ClassCastException
    //   72	82	197	java/lang/ClassCastException
    //   101	107	214	java/lang/ClassCastException
    //   107	117	230	java/lang/ClassCastException
    //   126	132	247	java/lang/ClassCastException
    //   132	142	263	java/lang/ClassCastException
    //   151	157	280	java/lang/ClassCastException
    //   166	172	296	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 283	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+36->40, 3:+48->52, 6:+95->99, 9:+132->136
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: aload 4
    //   46: aload 5
    //   48: invokespecial 318	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: areturn
    //   52: aload_3
    //   53: checkcast 107	java/lang/CharSequence
    //   56: astore 19
    //   58: aload 4
    //   60: checkcast 307	java/lang/Number
    //   63: invokevirtual 310	java/lang/Number:intValue	()I
    //   66: istore 21
    //   68: aload 5
    //   70: checkcast 307	java/lang/Number
    //   73: invokevirtual 310	java/lang/Number:intValue	()I
    //   76: istore 23
    //   78: aload_2
    //   79: aload 19
    //   81: iload 21
    //   83: iload 23
    //   85: invokestatic 114	kawa/lib/kawa/regex:isRegexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Z
    //   88: ifeq +7 -> 95
    //   91: getstatic 295	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   94: areturn
    //   95: getstatic 176	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   98: areturn
    //   99: aload_3
    //   100: checkcast 107	java/lang/CharSequence
    //   103: astore 13
    //   105: aload 4
    //   107: checkcast 307	java/lang/Number
    //   110: invokevirtual 310	java/lang/Number:intValue	()I
    //   113: istore 15
    //   115: aload 5
    //   117: checkcast 307	java/lang/Number
    //   120: invokevirtual 310	java/lang/Number:intValue	()I
    //   123: istore 17
    //   125: aload_2
    //   126: aload 13
    //   128: iload 15
    //   130: iload 17
    //   132: invokestatic 157	kawa/lib/kawa/regex:regexMatch	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   135: areturn
    //   136: aload_3
    //   137: checkcast 107	java/lang/CharSequence
    //   140: astore 7
    //   142: aload 4
    //   144: checkcast 307	java/lang/Number
    //   147: invokevirtual 310	java/lang/Number:intValue	()I
    //   150: istore 9
    //   152: aload 5
    //   154: checkcast 307	java/lang/Number
    //   157: invokevirtual 310	java/lang/Number:intValue	()I
    //   160: istore 11
    //   162: aload_2
    //   163: aload 7
    //   165: iload 9
    //   167: iload 11
    //   169: invokestatic 194	kawa/lib/kawa/regex:regexMatchPositions	(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
    //   172: areturn
    //   173: astore 18
    //   175: new 144	gnu/mapping/WrongType
    //   178: dup
    //   179: aload 18
    //   181: ldc 57
    //   183: iconst_2
    //   184: aload_3
    //   185: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   188: athrow
    //   189: astore 20
    //   191: new 144	gnu/mapping/WrongType
    //   194: dup
    //   195: aload 20
    //   197: ldc 57
    //   199: iconst_3
    //   200: aload 4
    //   202: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   205: athrow
    //   206: astore 22
    //   208: new 144	gnu/mapping/WrongType
    //   211: dup
    //   212: aload 22
    //   214: ldc 57
    //   216: iconst_4
    //   217: aload 5
    //   219: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   222: athrow
    //   223: astore 12
    //   225: new 144	gnu/mapping/WrongType
    //   228: dup
    //   229: aload 12
    //   231: ldc 53
    //   233: iconst_2
    //   234: aload_3
    //   235: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //   239: astore 14
    //   241: new 144	gnu/mapping/WrongType
    //   244: dup
    //   245: aload 14
    //   247: ldc 53
    //   249: iconst_3
    //   250: aload 4
    //   252: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    //   256: astore 16
    //   258: new 144	gnu/mapping/WrongType
    //   261: dup
    //   262: aload 16
    //   264: ldc 53
    //   266: iconst_4
    //   267: aload 5
    //   269: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   272: athrow
    //   273: astore 6
    //   275: new 144	gnu/mapping/WrongType
    //   278: dup
    //   279: aload 6
    //   281: ldc 49
    //   283: iconst_2
    //   284: aload_3
    //   285: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   288: athrow
    //   289: astore 8
    //   291: new 144	gnu/mapping/WrongType
    //   294: dup
    //   295: aload 8
    //   297: ldc 49
    //   299: iconst_3
    //   300: aload 4
    //   302: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   305: athrow
    //   306: astore 10
    //   308: new 144	gnu/mapping/WrongType
    //   311: dup
    //   312: aload 10
    //   314: ldc 49
    //   316: iconst_4
    //   317: aload 5
    //   319: invokespecial 149	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   322: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   52	58	173	java/lang/ClassCastException
    //   58	68	189	java/lang/ClassCastException
    //   68	78	206	java/lang/ClassCastException
    //   99	105	223	java/lang/ClassCastException
    //   105	115	239	java/lang/ClassCastException
    //   115	125	256	java/lang/ClassCastException
    //   136	142	273	java/lang/ClassCastException
    //   142	152	289	java/lang/ClassCastException
    //   152	162	306	java/lang/ClassCastException
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 2)
    {
      if ((paramObject instanceof CharSequence))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    }
    return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 12:
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 9:
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 6:
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 3:
    }
    paramCallContext.value1 = paramObject1;
    if ((paramObject2 instanceof CharSequence))
    {
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return -786430;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 14:
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786430;
    case 13:
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786430;
    case 9:
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786430;
    case 6:
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return -786430;
    case 3:
    }
    paramCallContext.value1 = paramObject1;
    if ((paramObject2 instanceof CharSequence))
    {
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
    return -786430;
  }

  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 9:
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return -786430;
    case 6:
      paramCallContext.value1 = paramObject1;
      if ((paramObject2 instanceof CharSequence))
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return -786430;
    case 3:
    }
    paramCallContext.value1 = paramObject1;
    if ((paramObject2 instanceof CharSequence))
    {
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    return -786430;
  }

  public final void run(CallContext paramCallContext)
  {
  }

  public class frame extends ModuleBody
  {
    Object loop = new ModuleMethod(this, 1, regex.Lit0, 0);
    Matcher matcher;
    Object repl;
    StringBuffer sbuf;

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 1)
        return lambda1loop();
      return super.apply0(paramModuleMethod);
    }

    public String lambda1loop()
    {
      Matcher localMatcher;
      StringBuffer localStringBuffer;
      Object localObject;
      if (this.matcher.find())
      {
        localMatcher = this.matcher;
        localStringBuffer = this.sbuf;
        localObject = Scheme.applyToArgs.apply2(this.repl, this.matcher.group());
        if (localObject != null)
          break label78;
      }
      label78: for (String str = null; ; str = localObject.toString())
      {
        localMatcher.appendReplacement(localStringBuffer, Matcher.quoteReplacement(str));
        this.matcher.appendTail(this.sbuf);
        return this.sbuf.toString();
      }
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
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.kawa.regex
 * JD-Core Version:    0.6.2
 */