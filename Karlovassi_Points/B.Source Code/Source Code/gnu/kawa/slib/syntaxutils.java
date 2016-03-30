package gnu.kawa.slib;

import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LetExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.ReferenceExp;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Convert;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.reflect.SlotGet;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Macro;
import kawa.lang.Quote;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class syntaxutils extends ModuleBody
{
  public static final Macro $Prvt$$Ex;
  public static final Macro $Prvt$typecase$Pc;
  public static final syntaxutils $instance;
  static final Keyword Lit0;
  static final PairWithPosition Lit1;
  static final PairWithPosition Lit10;
  static final PairWithPosition Lit11;
  static final PairWithPosition Lit12;
  static final SimpleSymbol Lit13;
  static final SyntaxRules Lit14;
  static final SimpleSymbol Lit15;
  static final SyntaxRules Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final Keyword Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26 = (SimpleSymbol)new SimpleSymbol("lambda").readResolve();
  static final PairWithPosition Lit3;
  static final PairWithPosition Lit4;
  static final PairWithPosition Lit5;
  static final PairWithPosition Lit6;
  static final IntNum Lit7;
  static final IntNum Lit8;
  static final PairWithPosition Lit9;
  public static final ModuleMethod expand;

  static
  {
    Lit25 = (SimpleSymbol)new SimpleSymbol("as").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("else").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("cond").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("begin").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("or").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("eql").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("expand").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("!").readResolve();
    Lit15 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", new Object[0], 3);
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = ((SimpleSymbol)new SimpleSymbol("invoke").readResolve());
    arrayOfObject2[1] = Lit19;
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001\001\003", "\021\030\004\t\013)\021\030\f\b\003\b\025\023", arrayOfObject2, 1);
    Lit16 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 3);
    Object[] arrayOfObject3 = new Object[3];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("typecase%").readResolve();
    Lit13 = localSimpleSymbol2;
    arrayOfObject3[0] = localSimpleSymbol2;
    arrayOfObject3[1] = Lit18;
    arrayOfObject3[2] = Lit20;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[6];
    Object[] arrayOfObject4 = new Object[1];
    arrayOfObject4[0] = Boolean.TRUE;
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\f\007<\f\002\r\017\b\b\b\r\027\020\b\b", arrayOfObject4, 3);
    Object[] arrayOfObject5 = new Object[1];
    arrayOfObject5[0] = Lit21;
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\001\003\003", "\021\030\004\b\r\013", arrayOfObject5, 1);
    Object[] arrayOfObject6 = new Object[1];
    arrayOfObject6[0] = Lit18;
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007\\,\f\002\f\017\b\r\027\020\b\b\r\037\030\b\b", arrayOfObject6, 4);
    Object[] arrayOfObject7 = new Object[5];
    arrayOfObject7[0] = Lit22;
    arrayOfObject7[1] = ((SimpleSymbol)new SimpleSymbol("eqv?").readResolve());
    arrayOfObject7[2] = Lit19;
    arrayOfObject7[3] = Lit24;
    arrayOfObject7[4] = Lit13;
    arrayOfSyntaxRule2[1] = new SyntaxRule(localSyntaxPattern3, "\001\001\003\003", "\021\030\004yY\021\030\f\t\003\b\021\030\024\b\013\b\025\023\b\021\030\034\b\021\030$\t\003\b\035\033", arrayOfObject7, 1);
    Object[] arrayOfObject8 = new Object[1];
    arrayOfObject8[0] = Lit20;
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("\f\030\f\007\\,\f\002\f\017\b\r\027\020\b\b\r\037\030\b\b", arrayOfObject8, 4);
    Object[] arrayOfObject9 = new Object[1];
    arrayOfObject9[0] = Lit13;
    arrayOfSyntaxRule2[2] = new SyntaxRule(localSyntaxPattern4, "\001\001\003\003", "\021\030\004\t\003)\t\013\b\025\023\b\035\033", arrayOfObject9, 1);
    Object[] arrayOfObject10 = new Object[1];
    arrayOfObject10[0] = Lit20;
    SyntaxPattern localSyntaxPattern5 = new SyntaxPattern("\f\030\f\007l<\f\002\r\017\b\b\b\r\027\020\b\b\r\037\030\b\b", arrayOfObject10, 4);
    Object[] arrayOfObject11 = new Object[6];
    arrayOfObject11[0] = Lit23;
    arrayOfObject11[1] = ((SimpleSymbol)new SimpleSymbol("f").readResolve());
    arrayOfObject11[2] = Lit26;
    arrayOfObject11[3] = Lit21;
    arrayOfObject11[4] = Lit13;
    arrayOfObject11[5] = Boolean.TRUE;
    arrayOfSyntaxRule2[3] = new SyntaxRule(localSyntaxPattern5, "\001\003\003\003", "\021\030\004\b\021\030\f\b\021\030\024\021\b\003\b\021\030\034\b\025\023\b\021\030$\t\003I\r\t\013\b\021\030\f\b\003\b\021\030,\b\021\030$\t\003\b\035\033", arrayOfObject11, 1);
    SyntaxPattern localSyntaxPattern6 = new SyntaxPattern("\f\030\f\007<\f\017\r\027\020\b\b\r\037\030\b\b", new Object[0], 4);
    Object[] arrayOfObject12 = new Object[7];
    arrayOfObject12[0] = Lit22;
    arrayOfObject12[1] = ((SimpleSymbol)new SimpleSymbol("instance?").readResolve());
    arrayOfObject12[2] = Lit23;
    arrayOfObject12[3] = ((SimpleSymbol)new SimpleSymbol("::").readResolve());
    arrayOfObject12[4] = Lit21;
    arrayOfObject12[5] = Lit24;
    arrayOfObject12[6] = Lit13;
    arrayOfSyntaxRule2[4] = new SyntaxRule(localSyntaxPattern6, "\001\001\003\003", "\021\030\004ñ9\021\030\f\t\003\b\013\b\021\030\024Q\b\t\003\021\030\034\t\013\b\003\b\021\030$\b\025\023\b\021\030,\b\021\0304\t\003\b\035\033", arrayOfObject12, 1);
    SyntaxPattern localSyntaxPattern7 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject13 = new Object[6];
    arrayOfObject13[0] = ((SimpleSymbol)new SimpleSymbol("error").readResolve());
    arrayOfObject13[1] = "typecase% failed";
    arrayOfObject13[2] = Lit15;
    arrayOfObject13[3] = ((SimpleSymbol)new SimpleSymbol("getClass").readResolve());
    arrayOfObject13[4] = Lit25;
    arrayOfObject13[5] = ((SimpleSymbol)new SimpleSymbol("<object>").readResolve());
    arrayOfSyntaxRule2[5] = new SyntaxRule(localSyntaxPattern7, "\001", "\021\030\004\021\030\f\t\003\b\021\030\024\021\030\034\b\021\030$\021\030,\b\003", arrayOfObject13, 0);
    Lit14 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 4);
    Lit12 = PairWithPosition.make((SimpleSymbol)new SimpleSymbol(":").readResolve(), LList.Empty, "syntaxutils.scm", 634896);
    Lit11 = PairWithPosition.make(Lit25, LList.Empty, "syntaxutils.scm", 626704);
    Lit10 = PairWithPosition.make(Lit19, LList.Empty, "syntaxutils.scm", 552972);
    Lit9 = PairWithPosition.make(Lit23, LList.Empty, "syntaxutils.scm", 479236);
    Lit8 = IntNum.make(1);
    Lit7 = IntNum.make(0);
    Lit6 = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("if").readResolve(), LList.Empty, "syntaxutils.scm", 417799);
    Lit5 = PairWithPosition.make(Lit21, LList.Empty, "syntaxutils.scm", 409627);
    Lit4 = PairWithPosition.make(Lit26, LList.Empty, "syntaxutils.scm", 376839);
    Lit3 = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("set").readResolve(), LList.Empty, "syntaxutils.scm", 368647);
    Lit2 = Keyword.make("lang");
    Lit1 = PairWithPosition.make(Lit21, LList.Empty, "syntaxutils.scm", 278557);
    Lit0 = Keyword.make("env");
    $instance = new syntaxutils();
    $Prvt$typecase$Pc = Macro.make(Lit13, Lit14, $instance);
    $Prvt$$Ex = Macro.make(Lit15, Lit16, $instance);
    expand = new ModuleMethod($instance, 1, Lit17, -4095);
    $instance.run();
  }

  public syntaxutils()
  {
    ModuleInfo.register(this);
  }

  public static Object expand$V(Object paramObject, Object[] paramArrayOfObject)
  {
    Object localObject1 = Keyword.searchForKeyword(paramArrayOfObject, 0, Lit0);
    if (localObject1 == Special.dfault);
    for (Object localObject2 = misc.interactionEnvironment(); ; localObject2 = localObject1)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Lit1;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramObject;
      arrayOfObject2[1] = LList.Empty;
      arrayOfObject1[1] = Quote.consX$V(arrayOfObject2);
      Object localObject3 = Quote.append$V(arrayOfObject1);
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = Lit0;
      arrayOfObject3[1] = localObject2;
      return unrewrite(rewriteForm$V(localObject3, arrayOfObject3));
    }
  }

  // ERROR //
  static Expression rewriteForm$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: getstatic 245	gnu/kawa/slib/syntaxutils:Lit2	Lgnu/expr/Keyword;
    //   5: invokestatic 288	gnu/expr/Keyword:searchForKeyword	([Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
    //   8: astore_2
    //   9: aload_2
    //   10: getstatic 294	gnu/expr/Special:dfault	Lgnu/expr/Special;
    //   13: if_acmpne +181 -> 194
    //   16: invokestatic 325	gnu/expr/Language:getDefaultLanguage	()Lgnu/expr/Language;
    //   19: astore_3
    //   20: aload_1
    //   21: iconst_0
    //   22: getstatic 252	gnu/kawa/slib/syntaxutils:Lit0	Lgnu/expr/Keyword;
    //   25: invokestatic 288	gnu/expr/Keyword:searchForKeyword	([Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
    //   28: astore 4
    //   30: aload 4
    //   32: getstatic 294	gnu/expr/Special:dfault	Lgnu/expr/Special;
    //   35: if_acmpne +152 -> 187
    //   38: invokestatic 300	kawa/lib/misc:interactionEnvironment	()Lgnu/mapping/Environment;
    //   41: astore 5
    //   43: aload 5
    //   45: checkcast 327	gnu/mapping/Environment
    //   48: astore 7
    //   50: aload_3
    //   51: checkcast 321	gnu/expr/Language
    //   54: astore 9
    //   56: aload 7
    //   58: aload 9
    //   60: invokestatic 333	gnu/expr/NameLookup:getInstance	(Lgnu/mapping/Environment;Lgnu/expr/Language;)Lgnu/expr/NameLookup;
    //   63: astore 10
    //   65: new 335	gnu/text/SourceMessages
    //   68: dup
    //   69: invokespecial 336	gnu/text/SourceMessages:<init>	()V
    //   72: astore 11
    //   74: aload_3
    //   75: checkcast 321	gnu/expr/Language
    //   78: astore 13
    //   80: new 338	kawa/lang/Translator
    //   83: dup
    //   84: aload 13
    //   86: aload 11
    //   88: aload 10
    //   90: invokespecial 341	kawa/lang/Translator:<init>	(Lgnu/expr/Language;Lgnu/text/SourceMessages;Lgnu/expr/NameLookup;)V
    //   93: astore 14
    //   95: aload 14
    //   97: aconst_null
    //   98: invokevirtual 345	kawa/lang/Translator:pushNewModule	(Ljava/lang/String;)Lgnu/expr/ModuleExp;
    //   101: pop
    //   102: aload 14
    //   104: invokestatic 351	gnu/expr/Compilation:setSaveCurrent	(Lgnu/expr/Compilation;)Lgnu/expr/Compilation;
    //   107: astore 16
    //   109: aload 14
    //   111: aload_0
    //   112: invokevirtual 355	kawa/lang/Translator:rewrite	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   115: astore 18
    //   117: aload 16
    //   119: invokestatic 359	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   122: aload 18
    //   124: areturn
    //   125: astore 17
    //   127: aload 16
    //   129: invokestatic 359	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   132: aload 17
    //   134: athrow
    //   135: astore 6
    //   137: new 361	gnu/mapping/WrongType
    //   140: dup
    //   141: aload 6
    //   143: ldc_w 363
    //   146: iconst_1
    //   147: aload 5
    //   149: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   152: athrow
    //   153: astore 8
    //   155: new 361	gnu/mapping/WrongType
    //   158: dup
    //   159: aload 8
    //   161: ldc_w 363
    //   164: iconst_2
    //   165: aload_3
    //   166: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   169: athrow
    //   170: astore 12
    //   172: new 361	gnu/mapping/WrongType
    //   175: dup
    //   176: aload 12
    //   178: ldc_w 368
    //   181: iconst_1
    //   182: aload_3
    //   183: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    //   187: aload 4
    //   189: astore 5
    //   191: goto -148 -> 43
    //   194: aload_2
    //   195: astore_3
    //   196: goto -176 -> 20
    //
    // Exception table:
    //   from	to	target	type
    //   109	117	125	finally
    //   43	50	135	java/lang/ClassCastException
    //   50	56	153	java/lang/ClassCastException
    //   74	80	170	java/lang/ClassCastException
  }

  // ERROR //
  static Object unrewrite(Expression paramExpression)
  {
    // Byte code:
    //   0: new 370	gnu/kawa/slib/syntaxutils$frame
    //   3: dup
    //   4: invokespecial 371	gnu/kawa/slib/syntaxutils$frame:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: instanceof 373
    //   12: ifeq +15 -> 27
    //   15: aload_0
    //   16: checkcast 373	gnu/expr/LetExp
    //   19: astore 31
    //   21: aload 31
    //   23: invokestatic 377	gnu/kawa/slib/syntaxutils:unrewriteLet	(Lgnu/expr/LetExp;)Ljava/lang/Object;
    //   26: areturn
    //   27: aload_0
    //   28: instanceof 379
    //   31: ifeq +15 -> 46
    //   34: aload_0
    //   35: checkcast 379	gnu/expr/QuoteExp
    //   38: astore 29
    //   40: aload 29
    //   42: invokestatic 383	gnu/kawa/slib/syntaxutils:unrewriteQuote	(Lgnu/expr/QuoteExp;)Ljava/lang/Object;
    //   45: areturn
    //   46: aload_0
    //   47: instanceof 385
    //   50: ifeq +86 -> 136
    //   53: aload_0
    //   54: checkcast 385	gnu/expr/SetExp
    //   57: astore 24
    //   59: iconst_2
    //   60: anewarray 96	java/lang/Object
    //   63: astore 25
    //   65: aload 25
    //   67: iconst_0
    //   68: getstatic 236	gnu/kawa/slib/syntaxutils:Lit3	Lgnu/lists/PairWithPosition;
    //   71: aastore
    //   72: iconst_2
    //   73: anewarray 96	java/lang/Object
    //   76: astore 26
    //   78: aload 26
    //   80: iconst_0
    //   81: aload 24
    //   83: invokevirtual 388	gnu/expr/SetExp:getSymbol	()Ljava/lang/Object;
    //   86: aastore
    //   87: iconst_2
    //   88: anewarray 96	java/lang/Object
    //   91: astore 27
    //   93: aload 27
    //   95: iconst_0
    //   96: aload 24
    //   98: invokevirtual 392	gnu/expr/SetExp:getNewValue	()Lgnu/expr/Expression;
    //   101: invokestatic 317	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   104: aastore
    //   105: aload 27
    //   107: iconst_1
    //   108: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   111: aastore
    //   112: aload 26
    //   114: iconst_1
    //   115: aload 27
    //   117: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   120: aastore
    //   121: aload 25
    //   123: iconst_1
    //   124: aload 26
    //   126: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   129: aastore
    //   130: aload 25
    //   132: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   135: areturn
    //   136: aload_0
    //   137: instanceof 394
    //   140: ifeq +133 -> 273
    //   143: aload_0
    //   144: checkcast 394	gnu/expr/LambdaExp
    //   147: astore 18
    //   149: iconst_2
    //   150: anewarray 96	java/lang/Object
    //   153: astore 19
    //   155: aload 19
    //   157: iconst_0
    //   158: getstatic 231	gnu/kawa/slib/syntaxutils:Lit4	Lgnu/lists/PairWithPosition;
    //   161: aastore
    //   162: iconst_2
    //   163: anewarray 96	java/lang/Object
    //   166: astore 20
    //   168: aload_1
    //   169: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   172: putfield 397	gnu/kawa/slib/syntaxutils$frame:pack	Lgnu/lists/LList;
    //   175: aload 18
    //   177: invokevirtual 401	gnu/expr/LambdaExp:firstDecl	()Lgnu/expr/Declaration;
    //   180: astore 21
    //   182: aload 21
    //   184: ifnull +29 -> 213
    //   187: aload_1
    //   188: aload 21
    //   190: invokevirtual 404	gnu/expr/Declaration:getSymbol	()Ljava/lang/Object;
    //   193: aload_1
    //   194: getfield 397	gnu/kawa/slib/syntaxutils$frame:pack	Lgnu/lists/LList;
    //   197: invokestatic 410	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   200: putfield 397	gnu/kawa/slib/syntaxutils$frame:pack	Lgnu/lists/LList;
    //   203: aload 21
    //   205: invokevirtual 413	gnu/expr/Declaration:nextDecl	()Lgnu/expr/Declaration;
    //   208: astore 21
    //   210: goto -28 -> 182
    //   213: aload 20
    //   215: iconst_0
    //   216: aload_1
    //   217: getfield 397	gnu/kawa/slib/syntaxutils$frame:pack	Lgnu/lists/LList;
    //   220: invokestatic 417	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   223: aastore
    //   224: iconst_2
    //   225: anewarray 96	java/lang/Object
    //   228: astore 22
    //   230: aload 22
    //   232: iconst_0
    //   233: aload 18
    //   235: getfield 421	gnu/expr/LambdaExp:body	Lgnu/expr/Expression;
    //   238: invokestatic 317	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   241: aastore
    //   242: aload 22
    //   244: iconst_1
    //   245: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   248: aastore
    //   249: aload 20
    //   251: iconst_1
    //   252: aload 22
    //   254: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   257: aastore
    //   258: aload 19
    //   260: iconst_1
    //   261: aload 20
    //   263: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   266: aastore
    //   267: aload 19
    //   269: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   272: areturn
    //   273: aload_0
    //   274: instanceof 423
    //   277: ifeq +15 -> 292
    //   280: aload_0
    //   281: checkcast 423	gnu/expr/ReferenceExp
    //   284: astore 16
    //   286: aload 16
    //   288: invokevirtual 424	gnu/expr/ReferenceExp:getSymbol	()Ljava/lang/Object;
    //   291: areturn
    //   292: aload_0
    //   293: instanceof 426
    //   296: ifeq +15 -> 311
    //   299: aload_0
    //   300: checkcast 426	gnu/expr/ApplyExp
    //   303: astore 14
    //   305: aload 14
    //   307: invokestatic 430	gnu/kawa/slib/syntaxutils:unrewriteApply	(Lgnu/expr/ApplyExp;)Ljava/lang/Object;
    //   310: areturn
    //   311: aload_0
    //   312: instanceof 432
    //   315: ifeq +40 -> 355
    //   318: aload_0
    //   319: checkcast 432	gnu/expr/BeginExp
    //   322: astore 11
    //   324: iconst_2
    //   325: anewarray 96	java/lang/Object
    //   328: astore 12
    //   330: aload 12
    //   332: iconst_0
    //   333: getstatic 228	gnu/kawa/slib/syntaxutils:Lit5	Lgnu/lists/PairWithPosition;
    //   336: aastore
    //   337: aload 12
    //   339: iconst_1
    //   340: aload 11
    //   342: invokevirtual 436	gnu/expr/BeginExp:getExpressions	()[Lgnu/expr/Expression;
    //   345: invokestatic 440	gnu/kawa/slib/syntaxutils:unrewrite$St	([Lgnu/expr/Expression;)Ljava/lang/Object;
    //   348: aastore
    //   349: aload 12
    //   351: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   354: areturn
    //   355: aload_0
    //   356: instanceof 442
    //   359: ifeq +136 -> 495
    //   362: aload_0
    //   363: checkcast 442	gnu/expr/IfExp
    //   366: astore_3
    //   367: iconst_2
    //   368: anewarray 96	java/lang/Object
    //   371: astore 4
    //   373: aload 4
    //   375: iconst_0
    //   376: getstatic 225	gnu/kawa/slib/syntaxutils:Lit6	Lgnu/lists/PairWithPosition;
    //   379: aastore
    //   380: iconst_2
    //   381: anewarray 96	java/lang/Object
    //   384: astore 5
    //   386: aload 5
    //   388: iconst_0
    //   389: aload_3
    //   390: invokevirtual 445	gnu/expr/IfExp:getTest	()Lgnu/expr/Expression;
    //   393: invokestatic 317	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   396: aastore
    //   397: iconst_2
    //   398: anewarray 96	java/lang/Object
    //   401: astore 6
    //   403: aload 6
    //   405: iconst_0
    //   406: aload_3
    //   407: invokevirtual 448	gnu/expr/IfExp:getThenClause	()Lgnu/expr/Expression;
    //   410: invokestatic 317	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   413: aastore
    //   414: iconst_2
    //   415: anewarray 96	java/lang/Object
    //   418: astore 7
    //   420: aload_3
    //   421: invokevirtual 451	gnu/expr/IfExp:getElseClause	()Lgnu/expr/Expression;
    //   424: astore 8
    //   426: aload 8
    //   428: ifnonnull +54 -> 482
    //   431: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   434: astore 9
    //   436: aload 7
    //   438: iconst_0
    //   439: aload 9
    //   441: aastore
    //   442: aload 7
    //   444: iconst_1
    //   445: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   448: aastore
    //   449: aload 6
    //   451: iconst_1
    //   452: aload 7
    //   454: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   457: aastore
    //   458: aload 5
    //   460: iconst_1
    //   461: aload 6
    //   463: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   466: aastore
    //   467: aload 4
    //   469: iconst_1
    //   470: aload 5
    //   472: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   475: aastore
    //   476: aload 4
    //   478: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   481: areturn
    //   482: aload 8
    //   484: invokestatic 317	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   487: invokestatic 455	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   490: astore 9
    //   492: goto -56 -> 436
    //   495: aload_0
    //   496: areturn
    //   497: astore 30
    //   499: new 361	gnu/mapping/WrongType
    //   502: dup
    //   503: aload 30
    //   505: ldc_w 457
    //   508: bipush 254
    //   510: aload_0
    //   511: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   514: athrow
    //   515: astore 28
    //   517: new 361	gnu/mapping/WrongType
    //   520: dup
    //   521: aload 28
    //   523: ldc_w 457
    //   526: bipush 254
    //   528: aload_0
    //   529: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   532: athrow
    //   533: astore 23
    //   535: new 361	gnu/mapping/WrongType
    //   538: dup
    //   539: aload 23
    //   541: ldc_w 457
    //   544: bipush 254
    //   546: aload_0
    //   547: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   550: athrow
    //   551: astore 17
    //   553: new 361	gnu/mapping/WrongType
    //   556: dup
    //   557: aload 17
    //   559: ldc_w 457
    //   562: bipush 254
    //   564: aload_0
    //   565: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   568: athrow
    //   569: astore 15
    //   571: new 361	gnu/mapping/WrongType
    //   574: dup
    //   575: aload 15
    //   577: ldc_w 457
    //   580: bipush 254
    //   582: aload_0
    //   583: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   586: athrow
    //   587: astore 13
    //   589: new 361	gnu/mapping/WrongType
    //   592: dup
    //   593: aload 13
    //   595: ldc_w 457
    //   598: bipush 254
    //   600: aload_0
    //   601: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   604: athrow
    //   605: astore 10
    //   607: new 361	gnu/mapping/WrongType
    //   610: dup
    //   611: aload 10
    //   613: ldc_w 457
    //   616: bipush 254
    //   618: aload_0
    //   619: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   622: athrow
    //   623: astore_2
    //   624: new 361	gnu/mapping/WrongType
    //   627: dup
    //   628: aload_2
    //   629: ldc_w 457
    //   632: bipush 254
    //   634: aload_0
    //   635: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   638: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   15	21	497	java/lang/ClassCastException
    //   34	40	515	java/lang/ClassCastException
    //   53	59	533	java/lang/ClassCastException
    //   143	149	551	java/lang/ClassCastException
    //   280	286	569	java/lang/ClassCastException
    //   299	305	587	java/lang/ClassCastException
    //   318	324	605	java/lang/ClassCastException
    //   362	367	623	java/lang/ClassCastException
  }

  static Object unrewrite$St(Expression[] paramArrayOfExpression)
  {
    frame0 localframe0 = new frame0();
    localframe0.pack = LList.Empty;
    Integer localInteger = Integer.valueOf(paramArrayOfExpression.length);
    for (Object localObject = Lit7; Scheme.numEqu.apply2(localObject, localInteger) == Boolean.FALSE; localObject = AddOp.$Pl.apply2(localObject, Lit8))
      localframe0.pack = lists.cons(unrewrite(paramArrayOfExpression[((java.lang.Number)localObject).intValue()]), localframe0.pack);
    return lists.reverse$Ex(localframe0.pack);
  }

  static Object unrewriteApply(ApplyExp paramApplyExp)
  {
    Expression localExpression = paramApplyExp.getFunction();
    Object localObject1 = unrewrite$St(paramApplyExp.getArgs());
    if ((localExpression instanceof ReferenceExp));
    try
    {
      ReferenceExp localReferenceExp = (ReferenceExp)localExpression;
      Declaration localDeclaration1 = localReferenceExp.getBinding();
      Declaration localDeclaration2 = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
      Object localObject2 = paramApplyExp.getFunctionValue();
      int i;
      label56: int j;
      int k;
      label77: int m;
      if (localDeclaration1 == null)
      {
        i = 1;
        j = 0x1 & i + 1;
        if (j == 0)
          break label186;
        if (localDeclaration2 != null)
          break label131;
        k = 1;
        m = 0x1 & k + 1;
        if (m == 0)
          break label137;
        if (SlotGet.getSlotValue(false, localDeclaration1, "field", "field", "getField", "isField", Scheme.instance) != localDeclaration2.field)
          break label142;
      }
      label131: label137: 
      while (m != 0)
      {
        return localObject1;
        localDeclaration1 = null;
        break;
        i = 0;
        break label56;
        k = 0;
        break label77;
      }
      label142: Object localObject3;
      if ((localObject2 instanceof Convert))
      {
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = Lit11;
        arrayOfObject3[1] = localObject1;
        localObject3 = Quote.append$V(arrayOfObject3);
      }
      while (true)
      {
        if (localObject3 == Boolean.FALSE)
          break label238;
        return localObject3;
        label186: if (j == 0)
          break label142;
        break;
        if ((localObject2 instanceof GetNamedPart))
        {
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = Lit12;
          arrayOfObject2[1] = localObject1;
          localObject3 = Quote.append$V(arrayOfObject2);
        }
        else
        {
          localObject3 = Boolean.FALSE;
        }
      }
      label238: Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = unrewrite(localExpression);
      arrayOfObject1[1] = localObject1;
      return Quote.consX$V(arrayOfObject1);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "fun", -2, localExpression);
    }
  }

  static Object unrewriteLet(LetExp paramLetExp)
  {
    frame1 localframe1 = new frame1();
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Lit9;
    Object[] arrayOfObject2 = new Object[2];
    localframe1.pack = LList.Empty;
    Declaration localDeclaration = paramLetExp.firstDecl();
    for (Object localObject = Lit7; localDeclaration != null; localObject = AddOp.$Pl.apply2(localObject, Lit8))
    {
      localframe1.pack = lists.cons(LList.list2(localDeclaration.getSymbol(), unrewrite(paramLetExp.inits[((java.lang.Number)localObject).intValue()])), localframe1.pack);
      localDeclaration = localDeclaration.nextDecl();
    }
    arrayOfObject2[0] = lists.reverse$Ex(localframe1.pack);
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = unrewrite(paramLetExp.body);
    arrayOfObject3[1] = LList.Empty;
    arrayOfObject2[1] = Quote.consX$V(arrayOfObject3);
    arrayOfObject1[1] = Quote.consX$V(arrayOfObject2);
    return Quote.append$V(arrayOfObject1);
  }

  // ERROR //
  static Object unrewriteQuote(gnu.expr.QuoteExp paramQuoteExp)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 555	gnu/expr/QuoteExp:getValue	()Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 561	gnu/math/Numeric:asNumericOrNull	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   9: ifnull +12 -> 21
    //   12: aload_1
    //   13: invokestatic 566	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   16: astore 19
    //   18: aload 19
    //   20: areturn
    //   21: aload_1
    //   22: instanceof 131
    //   25: ifeq +36 -> 61
    //   28: getstatic 482	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   31: astore 16
    //   33: aload_1
    //   34: aload 16
    //   36: if_acmpeq +15 -> 51
    //   39: iconst_1
    //   40: istore 17
    //   42: iload 17
    //   44: ifeq +13 -> 57
    //   47: getstatic 135	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   50: areturn
    //   51: iconst_0
    //   52: istore 17
    //   54: goto -12 -> 42
    //   57: getstatic 482	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   60: areturn
    //   61: aload_1
    //   62: instanceof 568
    //   65: ifeq +12 -> 77
    //   68: aload_1
    //   69: checkcast 568	gnu/text/Char
    //   72: astore 14
    //   74: aload 14
    //   76: areturn
    //   77: aload_1
    //   78: instanceof 240
    //   81: ifeq +12 -> 93
    //   84: aload_1
    //   85: checkcast 240	gnu/expr/Keyword
    //   88: astore 12
    //   90: aload 12
    //   92: areturn
    //   93: aload_1
    //   94: instanceof 570
    //   97: ifeq +12 -> 109
    //   100: aload_1
    //   101: checkcast 570	java/lang/CharSequence
    //   104: astore 10
    //   106: aload 10
    //   108: areturn
    //   109: aload_1
    //   110: getstatic 573	gnu/expr/Special:undefined	Lgnu/expr/Special;
    //   113: if_acmpne +5 -> 118
    //   116: aload_1
    //   117: areturn
    //   118: aload_1
    //   119: getstatic 579	gnu/lists/EofClass:eofValue	Lgnu/lists/EofClass;
    //   122: if_acmpne +5 -> 127
    //   125: aload_1
    //   126: areturn
    //   127: aload_1
    //   128: instanceof 581
    //   131: ifeq +39 -> 170
    //   134: aload_1
    //   135: checkcast 581	gnu/bytecode/Type
    //   138: astore 8
    //   140: aload 8
    //   142: invokevirtual 585	gnu/bytecode/Type:getName	()Ljava/lang/String;
    //   145: astore 6
    //   147: iconst_0
    //   148: iconst_2
    //   149: anewarray 96	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: ldc_w 587
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: aload 6
    //   162: aastore
    //   163: invokestatic 593	gnu/kawa/functions/Format:formatToString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   166: invokestatic 597	kawa/lib/misc:string$To$Symbol	(Ljava/lang/CharSequence;)Lgnu/mapping/SimpleSymbol;
    //   169: areturn
    //   170: aload_1
    //   171: instanceof 599
    //   174: ifeq +19 -> 193
    //   177: aload_1
    //   178: checkcast 599	java/lang/Class
    //   181: astore 5
    //   183: aload 5
    //   185: invokevirtual 600	java/lang/Class:getName	()Ljava/lang/String;
    //   188: astore 6
    //   190: goto -43 -> 147
    //   193: iconst_2
    //   194: anewarray 96	java/lang/Object
    //   197: astore_2
    //   198: aload_2
    //   199: iconst_0
    //   200: getstatic 208	gnu/kawa/slib/syntaxutils:Lit10	Lgnu/lists/PairWithPosition;
    //   203: aastore
    //   204: iconst_2
    //   205: anewarray 96	java/lang/Object
    //   208: astore_3
    //   209: aload_3
    //   210: iconst_0
    //   211: aload_1
    //   212: aastore
    //   213: aload_3
    //   214: iconst_1
    //   215: getstatic 191	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   218: aastore
    //   219: aload_2
    //   220: iconst_1
    //   221: aload_3
    //   222: invokestatic 306	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   225: aastore
    //   226: aload_2
    //   227: invokestatic 309	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   230: areturn
    //   231: astore 18
    //   233: new 361	gnu/mapping/WrongType
    //   236: dup
    //   237: aload 18
    //   239: ldc_w 602
    //   242: bipush 254
    //   244: aload_1
    //   245: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   248: athrow
    //   249: astore 15
    //   251: new 361	gnu/mapping/WrongType
    //   254: dup
    //   255: aload 15
    //   257: ldc_w 602
    //   260: bipush 254
    //   262: aload_1
    //   263: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   266: athrow
    //   267: astore 13
    //   269: new 361	gnu/mapping/WrongType
    //   272: dup
    //   273: aload 13
    //   275: ldc_w 602
    //   278: bipush 254
    //   280: aload_1
    //   281: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   284: athrow
    //   285: astore 11
    //   287: new 361	gnu/mapping/WrongType
    //   290: dup
    //   291: aload 11
    //   293: ldc_w 602
    //   296: bipush 254
    //   298: aload_1
    //   299: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   302: athrow
    //   303: astore 9
    //   305: new 361	gnu/mapping/WrongType
    //   308: dup
    //   309: aload 9
    //   311: ldc_w 602
    //   314: bipush 254
    //   316: aload_1
    //   317: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   320: athrow
    //   321: astore 7
    //   323: new 361	gnu/mapping/WrongType
    //   326: dup
    //   327: aload 7
    //   329: ldc_w 602
    //   332: bipush 254
    //   334: aload_1
    //   335: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   338: athrow
    //   339: astore 4
    //   341: new 361	gnu/mapping/WrongType
    //   344: dup
    //   345: aload 4
    //   347: ldc_w 602
    //   350: bipush 254
    //   352: aload_1
    //   353: invokespecial 366	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   356: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   12	18	231	java/lang/ClassCastException
    //   28	33	249	java/lang/ClassCastException
    //   68	74	267	java/lang/ClassCastException
    //   84	90	285	java/lang/ClassCastException
    //   100	106	303	java/lang/ClassCastException
    //   134	140	321	java/lang/ClassCastException
    //   177	183	339	java/lang/ClassCastException
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    if (paramModuleMethod.selector == 1)
    {
      Object localObject = paramArrayOfObject[0];
      int i = paramArrayOfObject.length - 1;
      Object[] arrayOfObject = new Object[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          return expand$V(localObject, arrayOfObject);
        arrayOfObject[j] = paramArrayOfObject[(j + 1)];
      }
    }
    return super.applyN(paramModuleMethod, paramArrayOfObject);
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 1)
    {
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    }
    return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }

  public final void run(CallContext paramCallContext)
  {
  }

  public class frame extends ModuleBody
  {
    LList pack;
  }

  public class frame0 extends ModuleBody
  {
    LList pack;
  }

  public class frame1 extends ModuleBody
  {
    LList pack;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.syntaxutils
 * JD-Core Version:    0.6.2
 */