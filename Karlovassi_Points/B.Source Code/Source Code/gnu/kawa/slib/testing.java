package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.IsEqual;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Eval;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.parameters;
import kawa.lib.ports;
import kawa.lib.std_syntax;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.readchar;
import kawa.standard.syntax_case;

public class testing extends ModuleBody
{
  public static final ModuleMethod $Pctest$Mnbegin;
  static final ModuleMethod $Pctest$Mnnull$Mncallback;
  public static final ModuleMethod $Prvt$$Pctest$Mnapproximimate$Eq;
  public static final ModuleMethod $Prvt$$Pctest$Mnas$Mnspecifier;
  public static final Macro $Prvt$$Pctest$Mncomp1body;
  public static final Macro $Prvt$$Pctest$Mncomp2body;
  public static final ModuleMethod $Prvt$$Pctest$Mnend;
  public static final Macro $Prvt$$Pctest$Mnerror;
  public static final Macro $Prvt$$Pctest$Mnevaluate$Mnwith$Mncatch;
  public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnall;
  public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnany;
  public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnnth;
  public static final ModuleMethod $Prvt$$Pctest$Mnon$Mntest$Mnbegin;
  public static final ModuleMethod $Prvt$$Pctest$Mnon$Mntest$Mnend;
  public static final ModuleMethod $Prvt$$Pctest$Mnreport$Mnresult;
  public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist;
  public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist$Ex;
  public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist;
  public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist$Ex;
  public static final ModuleMethod $Prvt$$Pctest$Mnshould$Mnexecute;
  public static final Macro $Prvt$test$Mngroup;
  public static final testing $instance;
  static final IntNum Lit0;
  static final SimpleSymbol Lit1;
  static final PairWithPosition Lit10;
  static final SyntaxPattern Lit100;
  static final SyntaxTemplate Lit101;
  static final SyntaxPattern Lit102;
  static final SyntaxTemplate Lit103;
  static final SimpleSymbol Lit104;
  static final SyntaxTemplate Lit105;
  static final SimpleSymbol Lit106;
  static final SyntaxTemplate Lit107;
  static final SimpleSymbol Lit108;
  static final SyntaxTemplate Lit109;
  static final PairWithPosition Lit11;
  static final SimpleSymbol Lit110;
  static final SyntaxPattern Lit111;
  static final SyntaxTemplate Lit112;
  static final SyntaxPattern Lit113;
  static final SyntaxTemplate Lit114;
  static final SimpleSymbol Lit115;
  static final SyntaxRules Lit116;
  static final SimpleSymbol Lit117;
  static final SyntaxPattern Lit118;
  static final SyntaxTemplate Lit119;
  static final SimpleSymbol Lit12;
  static final SyntaxPattern Lit120;
  static final SyntaxTemplate Lit121;
  static final SyntaxPattern Lit122;
  static final SyntaxTemplate Lit123;
  static final SimpleSymbol Lit124;
  static final SimpleSymbol Lit125;
  static final SyntaxRules Lit126;
  static final SimpleSymbol Lit127;
  static final SimpleSymbol Lit128;
  static final SyntaxRules Lit129;
  static final IntNum Lit13;
  static final SimpleSymbol Lit130;
  static final SimpleSymbol Lit131;
  static final SyntaxRules Lit132;
  static final SimpleSymbol Lit133;
  static final SimpleSymbol Lit134;
  static final SyntaxRules Lit135;
  static final SimpleSymbol Lit136;
  static final SimpleSymbol Lit137;
  static final SyntaxRules Lit138;
  static final SimpleSymbol Lit139;
  static final SimpleSymbol Lit14;
  static final SyntaxRules Lit140;
  static final SimpleSymbol Lit141;
  static final SimpleSymbol Lit142;
  static final SimpleSymbol Lit143;
  static final SimpleSymbol Lit144;
  static final SimpleSymbol Lit145;
  static final SimpleSymbol Lit146;
  static final SimpleSymbol Lit147;
  static final SimpleSymbol Lit148;
  static final SimpleSymbol Lit149;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit150;
  static final SimpleSymbol Lit151;
  static final SimpleSymbol Lit152;
  static final SimpleSymbol Lit153;
  static final SimpleSymbol Lit154;
  static final SimpleSymbol Lit155;
  static final SimpleSymbol Lit156;
  static final SimpleSymbol Lit157;
  static final SimpleSymbol Lit158;
  static final SimpleSymbol Lit159;
  static final SyntaxPattern Lit16;
  static final SimpleSymbol Lit160;
  static final SimpleSymbol Lit161;
  static final SimpleSymbol Lit162;
  static final SimpleSymbol Lit163;
  static final SimpleSymbol Lit164;
  static final SimpleSymbol Lit165 = (SimpleSymbol)new SimpleSymbol("dynamic-wind").readResolve();
  static final SyntaxTemplate Lit17;
  static final SyntaxPattern Lit18;
  static final SyntaxTemplate Lit19;
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
  static final SimpleSymbol Lit29;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final SimpleSymbol Lit33;
  static final SimpleSymbol Lit34;
  static final SimpleSymbol Lit35;
  static final SimpleSymbol Lit36;
  static final SimpleSymbol Lit37;
  static final SimpleSymbol Lit38;
  static final SimpleSymbol Lit39;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit40;
  static final SimpleSymbol Lit41;
  static final SimpleSymbol Lit42;
  static final SimpleSymbol Lit43;
  static final SimpleSymbol Lit44;
  static final SimpleSymbol Lit45;
  static final SimpleSymbol Lit46;
  static final SimpleSymbol Lit47;
  static final SimpleSymbol Lit48;
  static final SimpleSymbol Lit49;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit50;
  static final SimpleSymbol Lit51;
  static final SimpleSymbol Lit52;
  static final SimpleSymbol Lit53;
  static final SimpleSymbol Lit54;
  static final SimpleSymbol Lit55;
  static final SimpleSymbol Lit56;
  static final SimpleSymbol Lit57;
  static final SimpleSymbol Lit58;
  static final SimpleSymbol Lit59;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit60;
  static final SimpleSymbol Lit61;
  static final SimpleSymbol Lit62;
  static final SimpleSymbol Lit63;
  static final SimpleSymbol Lit64;
  static final SimpleSymbol Lit65;
  static final SimpleSymbol Lit66;
  static final SimpleSymbol Lit67;
  static final SimpleSymbol Lit68;
  static final SimpleSymbol Lit69;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit70;
  static final SyntaxRules Lit71;
  static final SimpleSymbol Lit72;
  static final SyntaxRules Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SyntaxRules Lit76;
  static final SimpleSymbol Lit77;
  static final SimpleSymbol Lit78;
  static final SimpleSymbol Lit79;
  static final PairWithPosition Lit8;
  static final SimpleSymbol Lit80;
  static final SimpleSymbol Lit81;
  static final SimpleSymbol Lit82;
  static final SimpleSymbol Lit83;
  static final SimpleSymbol Lit84;
  static final SyntaxRules Lit85;
  static final SimpleSymbol Lit86;
  static final SimpleSymbol Lit87;
  static final SimpleSymbol Lit88;
  static final SimpleSymbol Lit89;
  static final SimpleSymbol Lit9;
  static final SyntaxRules Lit90;
  static final SimpleSymbol Lit91;
  static final SimpleSymbol Lit92;
  static final SyntaxRules Lit93;
  static final SimpleSymbol Lit94;
  static final SyntaxPattern Lit95;
  static final SyntaxTemplate Lit96;
  static final SyntaxPattern Lit97;
  static final SyntaxTemplate Lit98;
  static final SimpleSymbol Lit99;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn2;
  static final ModuleMethod lambda$Fn3;
  public static final ModuleMethod test$Mnapply;
  public static final Macro test$Mnapproximate;
  public static final Macro test$Mnassert;
  public static final Macro test$Mnend;
  public static final Macro test$Mneq;
  public static final Macro test$Mnequal;
  public static final Macro test$Mneqv;
  public static final Macro test$Mnerror;
  public static final Macro test$Mnexpect$Mnfail;
  public static final Macro test$Mngroup$Mnwith$Mncleanup;
  public static Boolean test$Mnlog$Mnto$Mnfile;
  public static final Macro test$Mnmatch$Mnall;
  public static final Macro test$Mnmatch$Mnany;
  public static final ModuleMethod test$Mnmatch$Mnname;
  public static final Macro test$Mnmatch$Mnnth;
  public static final ModuleMethod test$Mnon$Mnbad$Mncount$Mnsimple;
  public static final ModuleMethod test$Mnon$Mnbad$Mnend$Mnname$Mnsimple;
  public static final ModuleMethod test$Mnon$Mnfinal$Mnsimple;
  public static final ModuleMethod test$Mnon$Mngroup$Mnbegin$Mnsimple;
  public static final ModuleMethod test$Mnon$Mngroup$Mnend$Mnsimple;
  static final ModuleMethod test$Mnon$Mntest$Mnbegin$Mnsimple;
  public static final ModuleMethod test$Mnon$Mntest$Mnend$Mnsimple;
  public static final ModuleMethod test$Mnpassed$Qu;
  public static final ModuleMethod test$Mnread$Mneval$Mnstring;
  public static final ModuleMethod test$Mnresult$Mnalist;
  public static final ModuleMethod test$Mnresult$Mnalist$Ex;
  public static final ModuleMethod test$Mnresult$Mnclear;
  public static final ModuleMethod test$Mnresult$Mnkind;
  public static final Macro test$Mnresult$Mnref;
  public static final ModuleMethod test$Mnresult$Mnremove;
  public static final ModuleMethod test$Mnresult$Mnset$Ex;
  static final Class test$Mnrunner;
  public static final ModuleMethod test$Mnrunner$Mnaux$Mnvalue;
  public static final ModuleMethod test$Mnrunner$Mnaux$Mnvalue$Ex;
  public static final ModuleMethod test$Mnrunner$Mncreate;
  public static Object test$Mnrunner$Mncurrent;
  public static Object test$Mnrunner$Mnfactory;
  public static final ModuleMethod test$Mnrunner$Mnfail$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnfail$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Mnget;
  public static final ModuleMethod test$Mnrunner$Mngroup$Mnpath;
  public static final ModuleMethod test$Mnrunner$Mngroup$Mnstack;
  public static final ModuleMethod test$Mnrunner$Mngroup$Mnstack$Ex;
  public static final ModuleMethod test$Mnrunner$Mnnull;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mnend$Mnname;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mnend$Mnname$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnfinal;
  public static final ModuleMethod test$Mnrunner$Mnon$Mnfinal$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnbegin;
  public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnbegin$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnend;
  public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnend$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnbegin;
  public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnbegin$Ex;
  public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnend;
  public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnend$Ex;
  public static final ModuleMethod test$Mnrunner$Mnpass$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnpass$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Mnreset;
  public static final ModuleMethod test$Mnrunner$Mnsimple;
  public static final ModuleMethod test$Mnrunner$Mnskip$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnskip$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Mntest$Mnname;
  public static final ModuleMethod test$Mnrunner$Mnxfail$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnxfail$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Mnxpass$Mncount;
  public static final ModuleMethod test$Mnrunner$Mnxpass$Mncount$Ex;
  public static final ModuleMethod test$Mnrunner$Qu;
  public static final Macro test$Mnskip;
  public static final Macro test$Mnwith$Mnrunner;

  static Object $PcTestAnySpecifierMatches(Object paramObject1, Object paramObject2)
  {
    Boolean localBoolean = Boolean.FALSE;
    for (Object localObject = paramObject1; ; localObject = lists.cdr.apply1(localObject))
    {
      if (lists.isNull(localObject))
        return localBoolean;
      if ($PcTestSpecificierMatches(lists.car.apply1(localObject), paramObject2) != Boolean.FALSE)
        localBoolean = Boolean.TRUE;
    }
  }

  public static Procedure $PcTestApproximimate$Eq(Object paramObject)
  {
    frame0 localframe0 = new frame0();
    localframe0.error = paramObject;
    return localframe0.lambda$Fn4;
  }

  public static Object $PcTestAsSpecifier(Object paramObject)
  {
    if (misc.isProcedure(paramObject))
      return paramObject;
    if (numbers.isInteger(paramObject))
      return $PcTestMatchNth(Lit13, paramObject);
    if (strings.isString(paramObject))
      return testMatchName(paramObject);
    return misc.error$V("not a valid test specifier", new Object[0]);
  }

  // ERROR //
  public static void $PcTestBegin(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: getstatic 364	gnu/kawa/slib/testing:test$Mnrunner$Mncurrent	Ljava/lang/Object;
    //   3: checkcast 298	gnu/mapping/Procedure
    //   6: invokevirtual 368	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   9: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   12: if_acmpne +16 -> 28
    //   15: getstatic 364	gnu/kawa/slib/testing:test$Mnrunner$Mncurrent	Ljava/lang/Object;
    //   18: checkcast 298	gnu/mapping/Procedure
    //   21: invokestatic 371	gnu/kawa/slib/testing:testRunnerCreate	()Ljava/lang/Object;
    //   24: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: pop
    //   28: getstatic 364	gnu/kawa/slib/testing:test$Mnrunner$Mncurrent	Ljava/lang/Object;
    //   31: checkcast 298	gnu/mapping/Procedure
    //   34: invokevirtual 368	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   37: astore_2
    //   38: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   41: astore_3
    //   42: aload_2
    //   43: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   46: astore 5
    //   48: aload_3
    //   49: aload 5
    //   51: invokestatic 383	gnu/kawa/slib/testing:testRunnerOnGroupBegin	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   54: aload_2
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 387	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   60: pop
    //   61: aload_2
    //   62: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   65: astore 8
    //   67: aload_2
    //   68: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   71: astore 10
    //   73: aload 10
    //   75: invokestatic 390	gnu/kawa/slib/testing:$PcTestRunnerSkipList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   78: astore 11
    //   80: aload_2
    //   81: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   84: astore 13
    //   86: aload 8
    //   88: aload 11
    //   90: aload 13
    //   92: invokestatic 393	gnu/kawa/slib/testing:$PcTestRunnerSkipSave	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   95: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   98: invokestatic 401	gnu/kawa/slib/testing:$PcTestRunnerSkipSave$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   101: aload_2
    //   102: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   105: astore 15
    //   107: aload_2
    //   108: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   111: astore 17
    //   113: aload 17
    //   115: invokestatic 404	gnu/kawa/slib/testing:$PcTestRunnerFailList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   118: astore 18
    //   120: aload_2
    //   121: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   124: astore 20
    //   126: aload 15
    //   128: aload 18
    //   130: aload 20
    //   132: invokestatic 407	gnu/kawa/slib/testing:$PcTestRunnerFailSave	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   135: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   138: invokestatic 410	gnu/kawa/slib/testing:$PcTestRunnerFailSave$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   141: aload_2
    //   142: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   145: astore 22
    //   147: aload_2
    //   148: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   151: astore 24
    //   153: aload 24
    //   155: invokestatic 413	gnu/kawa/slib/testing:$PcTestRunnerTotalCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   158: aload_1
    //   159: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   162: astore 25
    //   164: aload_2
    //   165: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   168: astore 27
    //   170: aload 22
    //   172: aload 25
    //   174: aload 27
    //   176: invokestatic 416	gnu/kawa/slib/testing:$PcTestRunnerCountList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   179: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   182: invokestatic 419	gnu/kawa/slib/testing:$PcTestRunnerCountList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   185: aload_2
    //   186: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   189: astore 29
    //   191: aload_2
    //   192: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   195: astore 31
    //   197: aload 29
    //   199: aload_0
    //   200: aload 31
    //   202: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   205: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   208: invokestatic 425	gnu/kawa/slib/testing:testRunnerGroupStack$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   211: return
    //   212: astore 4
    //   214: new 427	gnu/mapping/WrongType
    //   217: dup
    //   218: aload 4
    //   220: ldc_w 429
    //   223: iconst_0
    //   224: aload_2
    //   225: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   228: athrow
    //   229: astore 7
    //   231: new 427	gnu/mapping/WrongType
    //   234: dup
    //   235: aload 7
    //   237: ldc_w 434
    //   240: iconst_0
    //   241: aload_2
    //   242: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   245: athrow
    //   246: astore 9
    //   248: new 427	gnu/mapping/WrongType
    //   251: dup
    //   252: aload 9
    //   254: ldc_w 436
    //   257: iconst_0
    //   258: aload_2
    //   259: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   262: athrow
    //   263: astore 12
    //   265: new 427	gnu/mapping/WrongType
    //   268: dup
    //   269: aload 12
    //   271: ldc_w 438
    //   274: iconst_0
    //   275: aload_2
    //   276: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: astore 14
    //   282: new 427	gnu/mapping/WrongType
    //   285: dup
    //   286: aload 14
    //   288: ldc_w 440
    //   291: iconst_0
    //   292: aload_2
    //   293: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: astore 16
    //   299: new 427	gnu/mapping/WrongType
    //   302: dup
    //   303: aload 16
    //   305: ldc_w 442
    //   308: iconst_0
    //   309: aload_2
    //   310: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   313: athrow
    //   314: astore 19
    //   316: new 427	gnu/mapping/WrongType
    //   319: dup
    //   320: aload 19
    //   322: ldc_w 444
    //   325: iconst_0
    //   326: aload_2
    //   327: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   330: athrow
    //   331: astore 21
    //   333: new 427	gnu/mapping/WrongType
    //   336: dup
    //   337: aload 21
    //   339: ldc_w 446
    //   342: iconst_0
    //   343: aload_2
    //   344: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   347: athrow
    //   348: astore 23
    //   350: new 427	gnu/mapping/WrongType
    //   353: dup
    //   354: aload 23
    //   356: ldc_w 448
    //   359: iconst_0
    //   360: aload_2
    //   361: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   364: athrow
    //   365: astore 26
    //   367: new 427	gnu/mapping/WrongType
    //   370: dup
    //   371: aload 26
    //   373: ldc_w 450
    //   376: iconst_0
    //   377: aload_2
    //   378: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   381: athrow
    //   382: astore 28
    //   384: new 427	gnu/mapping/WrongType
    //   387: dup
    //   388: aload 28
    //   390: ldc_w 452
    //   393: iconst_0
    //   394: aload_2
    //   395: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   398: athrow
    //   399: astore 30
    //   401: new 427	gnu/mapping/WrongType
    //   404: dup
    //   405: aload 30
    //   407: ldc_w 454
    //   410: iconst_0
    //   411: aload_2
    //   412: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   415: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   42	48	212	java/lang/ClassCastException
    //   61	67	229	java/lang/ClassCastException
    //   67	73	246	java/lang/ClassCastException
    //   80	86	263	java/lang/ClassCastException
    //   101	107	280	java/lang/ClassCastException
    //   107	113	297	java/lang/ClassCastException
    //   120	126	314	java/lang/ClassCastException
    //   141	147	331	java/lang/ClassCastException
    //   147	153	348	java/lang/ClassCastException
    //   164	170	365	java/lang/ClassCastException
    //   185	191	382	java/lang/ClassCastException
    //   191	197	399	java/lang/ClassCastException
  }

  static Object $PcTestComp2(Object paramObject1, Object paramObject2)
  {
    Pair localPair = LList.list3(paramObject2, LList.list2(Lit15, $PcTestSourceLine2(paramObject2)), paramObject1);
    Object[] arrayOfObject = SyntaxPattern.allocVars(6, null);
    if (Lit16.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit17.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit18.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit19.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", localPair);
  }

  // ERROR //
  public static Object $PcTestEnd(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: invokestatic 513	gnu/kawa/slib/testing:testRunnerGet	()Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   8: astore 4
    //   10: aload 4
    //   12: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   15: astore 5
    //   17: aload_2
    //   18: invokestatic 516	gnu/kawa/slib/testing:$PcTestFormatLine	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: astore 6
    //   23: aload_2
    //   24: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   27: astore 8
    //   29: aload 8
    //   31: aload_1
    //   32: invokestatic 519	gnu/kawa/slib/testing:testResultAlist$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   35: aload 5
    //   37: invokestatic 292	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   40: ifeq +29 -> 69
    //   43: iconst_2
    //   44: anewarray 354	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload 6
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: ldc_w 521
    //   57: aastore
    //   58: invokestatic 525	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   61: iconst_0
    //   62: anewarray 354	java/lang/Object
    //   65: invokestatic 358	kawa/lib/misc:error$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   68: pop
    //   69: aload_0
    //   70: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   73: if_acmpeq +401 -> 474
    //   76: aload_0
    //   77: getstatic 296	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   80: aload 5
    //   82: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: invokestatic 531	gnu/kawa/functions/IsEqual:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   88: ifne +35 -> 123
    //   91: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   94: astore 9
    //   96: aload_2
    //   97: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   100: astore 11
    //   102: aload 9
    //   104: aload 11
    //   106: invokestatic 534	gnu/kawa/slib/testing:testRunnerOnBadEndName	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   109: aload_2
    //   110: aload_0
    //   111: getstatic 296	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   114: aload 5
    //   116: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: invokevirtual 387	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: aload_2
    //   124: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   127: astore 14
    //   129: aload 14
    //   131: invokestatic 416	gnu/kawa/slib/testing:$PcTestRunnerCountList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   134: astore 15
    //   136: getstatic 537	kawa/lib/lists:cdar	Lgnu/expr/GenericProc;
    //   139: aload 15
    //   141: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   144: astore 16
    //   146: getstatic 540	kawa/lib/lists:caar	Lgnu/expr/GenericProc;
    //   149: aload 15
    //   151: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   154: astore 17
    //   156: getstatic 546	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   159: astore 18
    //   161: aload_2
    //   162: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   165: astore 20
    //   167: aload 18
    //   169: aload 20
    //   171: invokestatic 413	gnu/kawa/slib/testing:$PcTestRunnerTotalCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   174: aload 17
    //   176: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: astore 21
    //   181: aload 16
    //   183: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   186: if_acmpeq +298 -> 484
    //   189: getstatic 553	kawa/standard/Scheme:numEqu	Lgnu/kawa/functions/NumberCompare;
    //   192: aload 16
    //   194: aload 21
    //   196: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   202: if_acmpne +30 -> 232
    //   205: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   208: astore 22
    //   210: aload_2
    //   211: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   214: astore 24
    //   216: aload 22
    //   218: aload 24
    //   220: invokestatic 556	gnu/kawa/slib/testing:testRunnerOnBadCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   223: aload_2
    //   224: aload 21
    //   226: aload 16
    //   228: invokevirtual 387	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   231: pop
    //   232: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   235: astore 26
    //   237: aload_2
    //   238: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   241: astore 28
    //   243: aload 26
    //   245: aload 28
    //   247: invokestatic 559	gnu/kawa/slib/testing:testRunnerOnGroupEnd	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   250: aload_2
    //   251: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: pop
    //   255: aload_2
    //   256: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   259: astore 31
    //   261: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   264: astore 32
    //   266: aload_2
    //   267: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   270: astore 34
    //   272: aload 31
    //   274: aload 32
    //   276: aload 34
    //   278: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   281: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   284: invokestatic 425	gnu/kawa/slib/testing:testRunnerGroupStack$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   287: aload_2
    //   288: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   291: astore 36
    //   293: getstatic 296	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   296: astore 37
    //   298: aload_2
    //   299: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   302: astore 39
    //   304: aload 36
    //   306: aload 37
    //   308: aload 39
    //   310: invokestatic 393	gnu/kawa/slib/testing:$PcTestRunnerSkipSave	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   313: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   316: invokestatic 562	gnu/kawa/slib/testing:$PcTestRunnerSkipList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   319: aload_2
    //   320: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   323: astore 41
    //   325: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   328: astore 42
    //   330: aload_2
    //   331: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   334: astore 44
    //   336: aload 41
    //   338: aload 42
    //   340: aload 44
    //   342: invokestatic 393	gnu/kawa/slib/testing:$PcTestRunnerSkipSave	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   345: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   348: invokestatic 401	gnu/kawa/slib/testing:$PcTestRunnerSkipSave$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   351: aload_2
    //   352: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   355: astore 46
    //   357: getstatic 296	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   360: astore 47
    //   362: aload_2
    //   363: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   366: astore 49
    //   368: aload 46
    //   370: aload 47
    //   372: aload 49
    //   374: invokestatic 407	gnu/kawa/slib/testing:$PcTestRunnerFailSave	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   377: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   380: invokestatic 565	gnu/kawa/slib/testing:$PcTestRunnerFailList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   383: aload_2
    //   384: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   387: astore 51
    //   389: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   392: astore 52
    //   394: aload_2
    //   395: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   398: astore 54
    //   400: aload 51
    //   402: aload 52
    //   404: aload 54
    //   406: invokestatic 407	gnu/kawa/slib/testing:$PcTestRunnerFailSave	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   409: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   412: invokestatic 410	gnu/kawa/slib/testing:$PcTestRunnerFailSave$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   415: aload_2
    //   416: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   419: astore 56
    //   421: aload 56
    //   423: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   426: aload 15
    //   428: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   431: invokestatic 419	gnu/kawa/slib/testing:$PcTestRunnerCountList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   434: aload_2
    //   435: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   438: astore 58
    //   440: aload 58
    //   442: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   445: invokestatic 292	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   448: ifeq +47 -> 495
    //   451: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   454: astore 59
    //   456: aload_2
    //   457: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   460: astore 61
    //   462: aload 59
    //   464: aload 61
    //   466: invokestatic 568	gnu/kawa/slib/testing:testRunnerOnFinal	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   469: aload_2
    //   470: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   473: areturn
    //   474: aload_0
    //   475: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   478: if_acmpeq -355 -> 123
    //   481: goto -390 -> 91
    //   484: aload 16
    //   486: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   489: if_acmpeq -257 -> 232
    //   492: goto -287 -> 205
    //   495: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   498: areturn
    //   499: astore_3
    //   500: new 427	gnu/mapping/WrongType
    //   503: dup
    //   504: aload_3
    //   505: ldc_w 454
    //   508: iconst_0
    //   509: aload_2
    //   510: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   513: athrow
    //   514: astore 7
    //   516: new 427	gnu/mapping/WrongType
    //   519: dup
    //   520: aload 7
    //   522: ldc_w 576
    //   525: iconst_0
    //   526: aload_2
    //   527: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   530: athrow
    //   531: astore 10
    //   533: new 427	gnu/mapping/WrongType
    //   536: dup
    //   537: aload 10
    //   539: ldc_w 578
    //   542: iconst_0
    //   543: aload_2
    //   544: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   547: athrow
    //   548: astore 13
    //   550: new 427	gnu/mapping/WrongType
    //   553: dup
    //   554: aload 13
    //   556: ldc_w 450
    //   559: iconst_0
    //   560: aload_2
    //   561: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   564: athrow
    //   565: astore 19
    //   567: new 427	gnu/mapping/WrongType
    //   570: dup
    //   571: aload 19
    //   573: ldc_w 448
    //   576: iconst_0
    //   577: aload_2
    //   578: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   581: athrow
    //   582: astore 23
    //   584: new 427	gnu/mapping/WrongType
    //   587: dup
    //   588: aload 23
    //   590: ldc_w 580
    //   593: iconst_0
    //   594: aload_2
    //   595: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   598: athrow
    //   599: astore 27
    //   601: new 427	gnu/mapping/WrongType
    //   604: dup
    //   605: aload 27
    //   607: ldc_w 582
    //   610: iconst_0
    //   611: aload_2
    //   612: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   615: athrow
    //   616: astore 30
    //   618: new 427	gnu/mapping/WrongType
    //   621: dup
    //   622: aload 30
    //   624: ldc_w 452
    //   627: iconst_0
    //   628: aload_2
    //   629: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   632: athrow
    //   633: astore 33
    //   635: new 427	gnu/mapping/WrongType
    //   638: dup
    //   639: aload 33
    //   641: ldc_w 454
    //   644: iconst_0
    //   645: aload_2
    //   646: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   649: athrow
    //   650: astore 35
    //   652: new 427	gnu/mapping/WrongType
    //   655: dup
    //   656: aload 35
    //   658: ldc_w 584
    //   661: iconst_0
    //   662: aload_2
    //   663: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   666: athrow
    //   667: astore 38
    //   669: new 427	gnu/mapping/WrongType
    //   672: dup
    //   673: aload 38
    //   675: ldc_w 438
    //   678: iconst_0
    //   679: aload_2
    //   680: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   683: athrow
    //   684: astore 40
    //   686: new 427	gnu/mapping/WrongType
    //   689: dup
    //   690: aload 40
    //   692: ldc_w 434
    //   695: iconst_0
    //   696: aload_2
    //   697: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   700: athrow
    //   701: astore 43
    //   703: new 427	gnu/mapping/WrongType
    //   706: dup
    //   707: aload 43
    //   709: ldc_w 438
    //   712: iconst_0
    //   713: aload_2
    //   714: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   717: athrow
    //   718: astore 45
    //   720: new 427	gnu/mapping/WrongType
    //   723: dup
    //   724: aload 45
    //   726: ldc_w 586
    //   729: iconst_0
    //   730: aload_2
    //   731: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   734: athrow
    //   735: astore 48
    //   737: new 427	gnu/mapping/WrongType
    //   740: dup
    //   741: aload 48
    //   743: ldc_w 444
    //   746: iconst_0
    //   747: aload_2
    //   748: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   751: athrow
    //   752: astore 50
    //   754: new 427	gnu/mapping/WrongType
    //   757: dup
    //   758: aload 50
    //   760: ldc_w 440
    //   763: iconst_0
    //   764: aload_2
    //   765: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   768: athrow
    //   769: astore 53
    //   771: new 427	gnu/mapping/WrongType
    //   774: dup
    //   775: aload 53
    //   777: ldc_w 444
    //   780: iconst_0
    //   781: aload_2
    //   782: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   785: athrow
    //   786: astore 55
    //   788: new 427	gnu/mapping/WrongType
    //   791: dup
    //   792: aload 55
    //   794: ldc_w 446
    //   797: iconst_0
    //   798: aload_2
    //   799: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   802: athrow
    //   803: astore 57
    //   805: new 427	gnu/mapping/WrongType
    //   808: dup
    //   809: aload 57
    //   811: ldc_w 454
    //   814: iconst_0
    //   815: aload_2
    //   816: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   819: athrow
    //   820: astore 60
    //   822: new 427	gnu/mapping/WrongType
    //   825: dup
    //   826: aload 60
    //   828: ldc_w 588
    //   831: iconst_0
    //   832: aload_2
    //   833: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   836: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   4	10	499	java/lang/ClassCastException
    //   23	29	514	java/lang/ClassCastException
    //   96	102	531	java/lang/ClassCastException
    //   123	129	548	java/lang/ClassCastException
    //   161	167	565	java/lang/ClassCastException
    //   210	216	582	java/lang/ClassCastException
    //   237	243	599	java/lang/ClassCastException
    //   255	261	616	java/lang/ClassCastException
    //   266	272	633	java/lang/ClassCastException
    //   287	293	650	java/lang/ClassCastException
    //   298	304	667	java/lang/ClassCastException
    //   319	325	684	java/lang/ClassCastException
    //   330	336	701	java/lang/ClassCastException
    //   351	357	718	java/lang/ClassCastException
    //   362	368	735	java/lang/ClassCastException
    //   383	389	752	java/lang/ClassCastException
    //   394	400	769	java/lang/ClassCastException
    //   415	421	786	java/lang/ClassCastException
    //   434	440	803	java/lang/ClassCastException
    //   456	462	820	java/lang/ClassCastException
  }

  static void $PcTestFinalReport1(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if (Scheme.numGrt.apply2(paramObject1, Lit0) != Boolean.FALSE)
    {
      ports.display(paramObject2, paramObject3);
      ports.display(paramObject1, paramObject3);
      ports.newline(paramObject3);
    }
  }

  // ERROR //
  static void $PcTestFinalReportSimple(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 608	gnu/kawa/slib/testing:testRunnerPassCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   9: ldc_w 610
    //   12: aload_1
    //   13: invokestatic 612	gnu/kawa/slib/testing:$PcTestFinalReport1	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   16: aload_0
    //   17: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   20: astore 5
    //   22: aload 5
    //   24: invokestatic 615	gnu/kawa/slib/testing:testRunnerXfailCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   27: ldc_w 617
    //   30: aload_1
    //   31: invokestatic 612	gnu/kawa/slib/testing:$PcTestFinalReport1	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   34: aload_0
    //   35: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   38: astore 7
    //   40: aload 7
    //   42: invokestatic 620	gnu/kawa/slib/testing:testRunnerXpassCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   45: ldc_w 622
    //   48: aload_1
    //   49: invokestatic 612	gnu/kawa/slib/testing:$PcTestFinalReport1	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   52: aload_0
    //   53: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   56: astore 9
    //   58: aload 9
    //   60: invokestatic 625	gnu/kawa/slib/testing:testRunnerFailCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   63: ldc_w 627
    //   66: aload_1
    //   67: invokestatic 612	gnu/kawa/slib/testing:$PcTestFinalReport1	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   70: aload_0
    //   71: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   74: astore 11
    //   76: aload 11
    //   78: invokestatic 630	gnu/kawa/slib/testing:testRunnerSkipCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   81: ldc_w 632
    //   84: aload_1
    //   85: invokestatic 612	gnu/kawa/slib/testing:$PcTestFinalReport1	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   88: return
    //   89: astore_2
    //   90: new 427	gnu/mapping/WrongType
    //   93: dup
    //   94: aload_2
    //   95: ldc_w 634
    //   98: iconst_0
    //   99: aload_0
    //   100: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   103: athrow
    //   104: astore 4
    //   106: new 427	gnu/mapping/WrongType
    //   109: dup
    //   110: aload 4
    //   112: ldc_w 636
    //   115: iconst_0
    //   116: aload_0
    //   117: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   120: athrow
    //   121: astore 6
    //   123: new 427	gnu/mapping/WrongType
    //   126: dup
    //   127: aload 6
    //   129: ldc_w 638
    //   132: iconst_0
    //   133: aload_0
    //   134: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   137: athrow
    //   138: astore 8
    //   140: new 427	gnu/mapping/WrongType
    //   143: dup
    //   144: aload 8
    //   146: ldc_w 640
    //   149: iconst_0
    //   150: aload_0
    //   151: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   154: athrow
    //   155: astore 10
    //   157: new 427	gnu/mapping/WrongType
    //   160: dup
    //   161: aload 10
    //   163: ldc_w 642
    //   166: iconst_0
    //   167: aload_0
    //   168: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	89	java/lang/ClassCastException
    //   16	22	104	java/lang/ClassCastException
    //   34	40	121	java/lang/ClassCastException
    //   52	58	138	java/lang/ClassCastException
    //   70	76	155	java/lang/ClassCastException
  }

  // ERROR //
  static Object $PcTestFormatLine(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   9: astore_3
    //   10: getstatic 647	gnu/kawa/slib/testing:Lit4	Lgnu/mapping/SimpleSymbol;
    //   13: aload_3
    //   14: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore 4
    //   19: getstatic 652	gnu/kawa/slib/testing:Lit5	Lgnu/mapping/SimpleSymbol;
    //   22: aload_3
    //   23: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: astore 5
    //   28: aload 4
    //   30: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   33: if_acmpeq +79 -> 112
    //   36: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   39: aload 4
    //   41: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore 6
    //   46: aload 5
    //   48: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   51: if_acmpeq +69 -> 120
    //   54: iconst_4
    //   55: anewarray 354	java/lang/Object
    //   58: astore 7
    //   60: aload 7
    //   62: iconst_0
    //   63: aload 6
    //   65: aastore
    //   66: aload 7
    //   68: iconst_1
    //   69: ldc_w 654
    //   72: aastore
    //   73: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   76: aload 5
    //   78: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: astore 8
    //   83: aload 8
    //   85: checkcast 656	java/lang/Number
    //   88: astore 10
    //   90: aload 7
    //   92: iconst_2
    //   93: aload 10
    //   95: invokestatic 660	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   98: aastore
    //   99: aload 7
    //   101: iconst_3
    //   102: ldc_w 662
    //   105: aastore
    //   106: aload 7
    //   108: invokestatic 525	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   111: areturn
    //   112: ldc_w 664
    //   115: astore 6
    //   117: goto -71 -> 46
    //   120: ldc_w 664
    //   123: areturn
    //   124: astore_1
    //   125: new 427	gnu/mapping/WrongType
    //   128: dup
    //   129: aload_1
    //   130: ldc_w 666
    //   133: iconst_0
    //   134: aload_0
    //   135: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   138: athrow
    //   139: astore 9
    //   141: new 427	gnu/mapping/WrongType
    //   144: dup
    //   145: aload 9
    //   147: ldc_w 668
    //   150: iconst_1
    //   151: aload 8
    //   153: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   156: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	124	java/lang/ClassCastException
    //   83	90	139	java/lang/ClassCastException
  }

  public static Procedure $PcTestMatchAll$V(Object[] paramArrayOfObject)
  {
    frame3 localframe3 = new frame3();
    localframe3.pred$Mnlist = LList.makeList(paramArrayOfObject, 0);
    return localframe3.lambda$Fn12;
  }

  public static Procedure $PcTestMatchAny$V(Object[] paramArrayOfObject)
  {
    frame4 localframe4 = new frame4();
    localframe4.pred$Mnlist = LList.makeList(paramArrayOfObject, 0);
    return localframe4.lambda$Fn13;
  }

  public static Procedure $PcTestMatchNth(Object paramObject1, Object paramObject2)
  {
    frame2 localframe2 = new frame2();
    localframe2.n = paramObject1;
    localframe2.count = paramObject2;
    localframe2.i = Lit0;
    return localframe2.lambda$Fn11;
  }

  static Boolean $PcTestNullCallback(Object paramObject)
  {
    return Boolean.FALSE;
  }

  static void $PcTestOnBadCountWrite(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    ports.display("*** Total number of tests was ", paramObject4);
    ports.display(paramObject2, paramObject4);
    ports.display(" but should be ", paramObject4);
    ports.display(paramObject3, paramObject4);
    ports.display(". ***", paramObject4);
    ports.newline(paramObject4);
    ports.display("*** Discrepancy indicates testsuite error or exceptions. ***", paramObject4);
    ports.newline(paramObject4);
  }

  // ERROR //
  public static boolean $PcTestOnTestBegin(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 723	gnu/kawa/slib/testing:$PcTestShouldExecute	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   8: astore_2
    //   9: aload_0
    //   10: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   13: astore 4
    //   15: aload_2
    //   16: aload 4
    //   18: invokestatic 726	gnu/kawa/slib/testing:testRunnerOnTestBegin	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   21: aload_0
    //   22: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: pop
    //   26: getstatic 728	gnu/kawa/slib/testing:Lit2	Lgnu/mapping/SimpleSymbol;
    //   29: astore 6
    //   31: getstatic 730	gnu/kawa/slib/testing:Lit1	Lgnu/mapping/SimpleSymbol;
    //   34: astore 7
    //   36: aload_0
    //   37: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   40: astore 9
    //   42: aload 7
    //   44: aload 9
    //   46: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   49: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: astore 10
    //   54: aload 10
    //   56: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   59: if_acmpeq +30 -> 89
    //   62: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   65: aload 10
    //   67: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: astore 11
    //   72: aload 6
    //   74: aload 11
    //   76: if_acmpne +21 -> 97
    //   79: iconst_1
    //   80: istore 12
    //   82: iconst_1
    //   83: iload 12
    //   85: iconst_1
    //   86: iadd
    //   87: iand
    //   88: ireturn
    //   89: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   92: astore 11
    //   94: goto -22 -> 72
    //   97: iconst_0
    //   98: istore 12
    //   100: goto -18 -> 82
    //   103: astore_3
    //   104: new 427	gnu/mapping/WrongType
    //   107: dup
    //   108: aload_3
    //   109: ldc_w 732
    //   112: iconst_0
    //   113: aload_0
    //   114: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   117: athrow
    //   118: astore 8
    //   120: new 427	gnu/mapping/WrongType
    //   123: dup
    //   124: aload 8
    //   126: ldc_w 666
    //   129: iconst_0
    //   130: aload_0
    //   131: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   134: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	103	java/lang/ClassCastException
    //   36	42	118	java/lang/ClassCastException
  }

  public static Object $PcTestOnTestEnd(Object paramObject1, Object paramObject2)
  {
    SimpleSymbol localSimpleSymbol1 = Lit1;
    SimpleSymbol localSimpleSymbol2 = Lit1;
    try
    {
      test.Mnrunner localMnrunner = (test.Mnrunner)paramObject1;
      Object localObject1 = lists.assq(localSimpleSymbol2, testResultAlist(localMnrunner));
      Object localObject2;
      SimpleSymbol localSimpleSymbol3;
      if (localObject1 != Boolean.FALSE)
      {
        localObject2 = lists.cdr.apply1(localObject1);
        if (localObject2 != Lit3)
          break label87;
        if (paramObject2 == Boolean.FALSE)
          break label79;
        localSimpleSymbol3 = Lit9;
      }
      while (true)
      {
        return testResultSet$Ex(paramObject1, localSimpleSymbol1, localSimpleSymbol3);
        localObject2 = Boolean.FALSE;
        break;
        label79: localSimpleSymbol3 = Lit3;
        continue;
        label87: if (paramObject2 != Boolean.FALSE)
          localSimpleSymbol3 = Lit12;
        else
          localSimpleSymbol3 = Lit14;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "test-result-alist", 0, paramObject1);
    }
  }

  // ERROR //
  public static Object $PcTestReportResult()
  {
    // Byte code:
    //   0: invokestatic 513	gnu/kawa/slib/testing:testRunnerGet	()Ljava/lang/Object;
    //   3: astore_0
    //   4: iconst_1
    //   5: anewarray 354	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: invokestatic 750	gnu/kawa/slib/testing:testResultKind$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   15: astore_1
    //   16: getstatic 754	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   19: aload_1
    //   20: getstatic 743	gnu/kawa/slib/testing:Lit12	Lgnu/mapping/SimpleSymbol;
    //   23: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   26: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   29: if_acmpeq +104 -> 133
    //   32: aload_0
    //   33: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   36: astore 36
    //   38: getstatic 757	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   41: astore 37
    //   43: getstatic 338	gnu/kawa/slib/testing:Lit13	Lgnu/math/IntNum;
    //   46: astore 38
    //   48: aload_0
    //   49: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   52: astore 40
    //   54: aload 36
    //   56: aload 37
    //   58: aload 38
    //   60: aload 40
    //   62: invokestatic 608	gnu/kawa/slib/testing:testRunnerPassCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   65: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   68: invokestatic 760	gnu/kawa/slib/testing:testRunnerPassCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   71: aload_0
    //   72: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   75: astore 9
    //   77: getstatic 757	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   80: astore 10
    //   82: getstatic 338	gnu/kawa/slib/testing:Lit13	Lgnu/math/IntNum;
    //   85: astore 11
    //   87: aload_0
    //   88: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   91: astore 13
    //   93: aload 9
    //   95: aload 10
    //   97: aload 11
    //   99: aload 13
    //   101: invokestatic 413	gnu/kawa/slib/testing:$PcTestRunnerTotalCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   104: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: invokestatic 763	gnu/kawa/slib/testing:$PcTestRunnerTotalCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   110: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   113: astore 14
    //   115: aload_0
    //   116: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   119: astore 16
    //   121: aload 14
    //   123: aload 16
    //   125: invokestatic 766	gnu/kawa/slib/testing:testRunnerOnTestEnd	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   128: aload_0
    //   129: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: areturn
    //   133: getstatic 754	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   136: aload_1
    //   137: getstatic 745	gnu/kawa/slib/testing:Lit14	Lgnu/mapping/SimpleSymbol;
    //   140: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   146: if_acmpeq +45 -> 191
    //   149: aload_0
    //   150: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   153: astore 30
    //   155: getstatic 757	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   158: astore 31
    //   160: getstatic 338	gnu/kawa/slib/testing:Lit13	Lgnu/math/IntNum;
    //   163: astore 32
    //   165: aload_0
    //   166: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   169: astore 34
    //   171: aload 30
    //   173: aload 31
    //   175: aload 32
    //   177: aload 34
    //   179: invokestatic 625	gnu/kawa/slib/testing:testRunnerFailCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   182: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: invokestatic 769	gnu/kawa/slib/testing:testRunnerFailCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   188: goto -117 -> 71
    //   191: getstatic 754	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   194: aload_1
    //   195: getstatic 737	gnu/kawa/slib/testing:Lit9	Lgnu/mapping/SimpleSymbol;
    //   198: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   201: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   204: if_acmpeq +45 -> 249
    //   207: aload_0
    //   208: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   211: astore 24
    //   213: getstatic 757	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   216: astore 25
    //   218: getstatic 338	gnu/kawa/slib/testing:Lit13	Lgnu/math/IntNum;
    //   221: astore 26
    //   223: aload_0
    //   224: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   227: astore 28
    //   229: aload 24
    //   231: aload 25
    //   233: aload 26
    //   235: aload 28
    //   237: invokestatic 620	gnu/kawa/slib/testing:testRunnerXpassCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   240: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   243: invokestatic 772	gnu/kawa/slib/testing:testRunnerXpassCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   246: goto -175 -> 71
    //   249: getstatic 754	kawa/standard/Scheme:isEqv	Lgnu/kawa/functions/IsEqv;
    //   252: aload_1
    //   253: getstatic 735	gnu/kawa/slib/testing:Lit3	Lgnu/mapping/SimpleSymbol;
    //   256: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   262: if_acmpeq +45 -> 307
    //   265: aload_0
    //   266: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   269: astore 18
    //   271: getstatic 757	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   274: astore 19
    //   276: getstatic 338	gnu/kawa/slib/testing:Lit13	Lgnu/math/IntNum;
    //   279: astore 20
    //   281: aload_0
    //   282: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   285: astore 22
    //   287: aload 18
    //   289: aload 19
    //   291: aload 20
    //   293: aload 22
    //   295: invokestatic 615	gnu/kawa/slib/testing:testRunnerXfailCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   298: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   301: invokestatic 775	gnu/kawa/slib/testing:testRunnerXfailCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   304: goto -233 -> 71
    //   307: aload_0
    //   308: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   311: astore_3
    //   312: getstatic 757	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   315: astore 4
    //   317: getstatic 338	gnu/kawa/slib/testing:Lit13	Lgnu/math/IntNum;
    //   320: astore 5
    //   322: aload_0
    //   323: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   326: astore 7
    //   328: aload_3
    //   329: aload 4
    //   331: aload 5
    //   333: aload 7
    //   335: invokestatic 630	gnu/kawa/slib/testing:testRunnerSkipCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   338: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   341: invokestatic 778	gnu/kawa/slib/testing:testRunnerSkipCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   344: goto -273 -> 71
    //   347: astore 35
    //   349: new 427	gnu/mapping/WrongType
    //   352: dup
    //   353: aload 35
    //   355: ldc_w 780
    //   358: iconst_0
    //   359: aload_0
    //   360: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   363: athrow
    //   364: astore 39
    //   366: new 427	gnu/mapping/WrongType
    //   369: dup
    //   370: aload 39
    //   372: ldc_w 634
    //   375: iconst_0
    //   376: aload_0
    //   377: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   380: athrow
    //   381: astore 29
    //   383: new 427	gnu/mapping/WrongType
    //   386: dup
    //   387: aload 29
    //   389: ldc_w 782
    //   392: iconst_0
    //   393: aload_0
    //   394: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   397: athrow
    //   398: astore 33
    //   400: new 427	gnu/mapping/WrongType
    //   403: dup
    //   404: aload 33
    //   406: ldc_w 640
    //   409: iconst_0
    //   410: aload_0
    //   411: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   414: athrow
    //   415: astore 23
    //   417: new 427	gnu/mapping/WrongType
    //   420: dup
    //   421: aload 23
    //   423: ldc_w 784
    //   426: iconst_0
    //   427: aload_0
    //   428: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   431: athrow
    //   432: astore 27
    //   434: new 427	gnu/mapping/WrongType
    //   437: dup
    //   438: aload 27
    //   440: ldc_w 638
    //   443: iconst_0
    //   444: aload_0
    //   445: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   448: athrow
    //   449: astore 17
    //   451: new 427	gnu/mapping/WrongType
    //   454: dup
    //   455: aload 17
    //   457: ldc_w 786
    //   460: iconst_0
    //   461: aload_0
    //   462: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   465: athrow
    //   466: astore 21
    //   468: new 427	gnu/mapping/WrongType
    //   471: dup
    //   472: aload 21
    //   474: ldc_w 636
    //   477: iconst_0
    //   478: aload_0
    //   479: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   482: athrow
    //   483: astore_2
    //   484: new 427	gnu/mapping/WrongType
    //   487: dup
    //   488: aload_2
    //   489: ldc_w 788
    //   492: iconst_0
    //   493: aload_0
    //   494: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   497: athrow
    //   498: astore 6
    //   500: new 427	gnu/mapping/WrongType
    //   503: dup
    //   504: aload 6
    //   506: ldc_w 642
    //   509: iconst_0
    //   510: aload_0
    //   511: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   514: athrow
    //   515: astore 8
    //   517: new 427	gnu/mapping/WrongType
    //   520: dup
    //   521: aload 8
    //   523: ldc_w 790
    //   526: iconst_0
    //   527: aload_0
    //   528: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   531: athrow
    //   532: astore 12
    //   534: new 427	gnu/mapping/WrongType
    //   537: dup
    //   538: aload 12
    //   540: ldc_w 448
    //   543: iconst_0
    //   544: aload_0
    //   545: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   548: athrow
    //   549: astore 15
    //   551: new 427	gnu/mapping/WrongType
    //   554: dup
    //   555: aload 15
    //   557: ldc_w 792
    //   560: iconst_0
    //   561: aload_0
    //   562: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   565: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   32	38	347	java/lang/ClassCastException
    //   48	54	364	java/lang/ClassCastException
    //   149	155	381	java/lang/ClassCastException
    //   165	171	398	java/lang/ClassCastException
    //   207	213	415	java/lang/ClassCastException
    //   223	229	432	java/lang/ClassCastException
    //   265	271	449	java/lang/ClassCastException
    //   281	287	466	java/lang/ClassCastException
    //   307	312	483	java/lang/ClassCastException
    //   322	328	498	java/lang/ClassCastException
    //   71	77	515	java/lang/ClassCastException
    //   87	93	532	java/lang/ClassCastException
    //   115	121	549	java/lang/ClassCastException
  }

  static test.Mnrunner $PcTestRunnerAlloc()
  {
    return new test.Mnrunner();
  }

  static Object $PcTestRunnerCountList(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.count$Mnlist;
  }

  static void $PcTestRunnerCountList$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.count$Mnlist = paramObject;
  }

  public static Object $PcTestRunnerFailList(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.fail$Mnlist;
  }

  public static void $PcTestRunnerFailList$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.fail$Mnlist = paramObject;
  }

  static Object $PcTestRunnerFailSave(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.fail$Mnsave;
  }

  static void $PcTestRunnerFailSave$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.fail$Mnsave = paramObject;
  }

  static Object $PcTestRunnerRunList(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.run$Mnlist;
  }

  static void $PcTestRunnerRunList$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.run$Mnlist = paramObject;
  }

  public static Object $PcTestRunnerSkipList(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.skip$Mnlist;
  }

  public static void $PcTestRunnerSkipList$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.skip$Mnlist = paramObject;
  }

  static Object $PcTestRunnerSkipSave(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.skip$Mnsave;
  }

  static void $PcTestRunnerSkipSave$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.skip$Mnsave = paramObject;
  }

  static Object $PcTestRunnerTotalCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.total$Mncount;
  }

  static void $PcTestRunnerTotalCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.total$Mncount = paramObject;
  }

  // ERROR //
  public static Object $PcTestShouldExecute(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 820	gnu/kawa/slib/testing:$PcTestRunnerRunList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_3
    //   11: getstatic 308	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   14: if_acmpne +48 -> 62
    //   17: iconst_1
    //   18: istore 4
    //   20: iload 4
    //   22: ifeq +46 -> 68
    //   25: iload 4
    //   27: istore 8
    //   29: iconst_1
    //   30: iload 8
    //   32: iconst_1
    //   33: iadd
    //   34: iand
    //   35: istore 9
    //   37: iload 9
    //   39: ifeq +60 -> 99
    //   42: iload 9
    //   44: ifeq +76 -> 120
    //   47: aload_0
    //   48: getstatic 730	gnu/kawa/slib/testing:Lit1	Lgnu/mapping/SimpleSymbol;
    //   51: getstatic 728	gnu/kawa/slib/testing:Lit2	Lgnu/mapping/SimpleSymbol;
    //   54: invokestatic 741	gnu/kawa/slib/testing:testResultSet$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: pop
    //   58: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   61: areturn
    //   62: iconst_0
    //   63: istore 4
    //   65: goto -45 -> 20
    //   68: aload_3
    //   69: aload_0
    //   70: invokestatic 822	gnu/kawa/slib/testing:$PcTestAnySpecifierMatches	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   73: astore 5
    //   75: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   78: astore 7
    //   80: aload 5
    //   82: aload 7
    //   84: if_acmpeq +9 -> 93
    //   87: iconst_1
    //   88: istore 8
    //   90: goto -61 -> 29
    //   93: iconst_0
    //   94: istore 8
    //   96: goto -67 -> 29
    //   99: aload_0
    //   100: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   103: astore 11
    //   105: aload 11
    //   107: invokestatic 390	gnu/kawa/slib/testing:$PcTestRunnerSkipList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   110: aload_0
    //   111: invokestatic 822	gnu/kawa/slib/testing:$PcTestAnySpecifierMatches	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   117: if_acmpne -70 -> 47
    //   120: aload_0
    //   121: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   124: astore 13
    //   126: aload 13
    //   128: invokestatic 404	gnu/kawa/slib/testing:$PcTestRunnerFailList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   131: aload_0
    //   132: invokestatic 822	gnu/kawa/slib/testing:$PcTestAnySpecifierMatches	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   138: if_acmpeq +18 -> 156
    //   141: aload_0
    //   142: getstatic 730	gnu/kawa/slib/testing:Lit1	Lgnu/mapping/SimpleSymbol;
    //   145: getstatic 735	gnu/kawa/slib/testing:Lit3	Lgnu/mapping/SimpleSymbol;
    //   148: invokestatic 741	gnu/kawa/slib/testing:testResultSet$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: getstatic 735	gnu/kawa/slib/testing:Lit3	Lgnu/mapping/SimpleSymbol;
    //   155: areturn
    //   156: getstatic 308	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   159: areturn
    //   160: astore_1
    //   161: new 427	gnu/mapping/WrongType
    //   164: dup
    //   165: aload_1
    //   166: ldc_w 824
    //   169: iconst_0
    //   170: aload_0
    //   171: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   174: athrow
    //   175: astore 6
    //   177: new 427	gnu/mapping/WrongType
    //   180: dup
    //   181: aload 6
    //   183: ldc_w 826
    //   186: bipush 254
    //   188: aload 5
    //   190: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   193: athrow
    //   194: astore 10
    //   196: new 427	gnu/mapping/WrongType
    //   199: dup
    //   200: aload 10
    //   202: ldc_w 436
    //   205: iconst_0
    //   206: aload_0
    //   207: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   210: athrow
    //   211: astore 12
    //   213: new 427	gnu/mapping/WrongType
    //   216: dup
    //   217: aload 12
    //   219: ldc_w 442
    //   222: iconst_0
    //   223: aload_0
    //   224: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   227: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	160	java/lang/ClassCastException
    //   75	80	175	java/lang/ClassCastException
    //   99	105	194	java/lang/ClassCastException
    //   120	126	211	java/lang/ClassCastException
  }

  static Pair $PcTestSourceLine2(Object paramObject)
  {
    Object localObject1 = std_syntax.syntaxLine(paramObject);
    Object localObject2 = $PcTestSyntaxFile(paramObject);
    Object localObject3;
    Pair localPair;
    if (localObject1 != Boolean.FALSE)
    {
      localObject3 = LList.list1(lists.cons(Lit5, localObject1));
      localPair = lists.cons(Lit6, std_syntax.syntaxObject$To$Datum(paramObject));
      if (localObject2 == Boolean.FALSE)
        break label75;
    }
    label75: for (Object localObject4 = lists.cons(lists.cons(Lit4, localObject2), localObject3); ; localObject4 = localObject3)
    {
      return lists.cons(localPair, localObject4);
      localObject3 = LList.Empty;
      break;
    }
  }

  static Object $PcTestSpecificierMatches(Object paramObject1, Object paramObject2)
  {
    return Scheme.applyToArgs.apply2(paramObject1, paramObject2);
  }

  static Object $PcTestSyntaxFile(Object paramObject)
  {
    return std_syntax.syntaxSource(paramObject);
  }

  static Object $PcTestWriteResult1(Object paramObject1, Object paramObject2)
  {
    ports.display("  ", paramObject2);
    ports.display(lists.car.apply1(paramObject1), paramObject2);
    ports.display(": ", paramObject2);
    ports.write(lists.cdr.apply1(paramObject1), paramObject2);
    ports.newline(paramObject2);
    return Values.empty;
  }

  static
  {
    Lit164 = (SimpleSymbol)new SimpleSymbol("p").readResolve();
    Lit163 = (SimpleSymbol)new SimpleSymbol("exp").readResolve();
    Lit162 = (SimpleSymbol)new SimpleSymbol("res").readResolve();
    Lit161 = (SimpleSymbol)new SimpleSymbol("if").readResolve();
    Lit160 = (SimpleSymbol)new SimpleSymbol("name").readResolve();
    Lit159 = (SimpleSymbol)new SimpleSymbol("instance?").readResolve();
    Lit158 = (SimpleSymbol)new SimpleSymbol("cond").readResolve();
    Lit157 = (SimpleSymbol)new SimpleSymbol("actual-error").readResolve();
    Lit156 = (SimpleSymbol)new SimpleSymbol("<java.lang.Throwable>").readResolve();
    Lit155 = (SimpleSymbol)new SimpleSymbol("actual-value").readResolve();
    Lit154 = (SimpleSymbol)new SimpleSymbol("try-catch").readResolve();
    Lit153 = (SimpleSymbol)new SimpleSymbol("et").readResolve();
    Lit152 = (SimpleSymbol)new SimpleSymbol("expected-error").readResolve();
    Lit151 = (SimpleSymbol)new SimpleSymbol("ex").readResolve();
    Lit150 = (SimpleSymbol)new SimpleSymbol("let*").readResolve();
    Lit149 = (SimpleSymbol)new SimpleSymbol("r").readResolve();
    Lit148 = (SimpleSymbol)new SimpleSymbol("saved-runner").readResolve();
    Lit147 = (SimpleSymbol)new SimpleSymbol("lambda").readResolve();
    Lit146 = (SimpleSymbol)new SimpleSymbol("test-runner-current").readResolve();
    Lit145 = (SimpleSymbol)new SimpleSymbol("cons").readResolve();
    Lit144 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    Lit143 = (SimpleSymbol)new SimpleSymbol("runner").readResolve();
    Lit142 = (SimpleSymbol)new SimpleSymbol("test-read-eval-string").readResolve();
    Lit141 = (SimpleSymbol)new SimpleSymbol("test-match-name").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("test-expect-fail").readResolve();
    Lit139 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject2 = new Object[8];
    arrayOfObject2[0] = Lit144;
    SimpleSymbol localSimpleSymbol2 = Lit143;
    SimpleSymbol localSimpleSymbol3 = new SimpleSymbol("test-runner-get");
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)localSimpleSymbol3.readResolve();
    Lit60 = localSimpleSymbol4;
    arrayOfObject2[1] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol2, PairWithPosition.make(PairWithPosition.make(localSimpleSymbol4, LList.Empty, "testing.scm", 3952660), LList.Empty, "testing.scm", 3952660), "testing.scm", 3952652), LList.Empty, "testing.scm", 3952651);
    SimpleSymbol localSimpleSymbol5 = (SimpleSymbol)new SimpleSymbol("%test-runner-fail-list!").readResolve();
    Lit34 = localSimpleSymbol5;
    arrayOfObject2[2] = localSimpleSymbol5;
    arrayOfObject2[3] = Lit143;
    arrayOfObject2[4] = Lit145;
    SimpleSymbol localSimpleSymbol6 = (SimpleSymbol)new SimpleSymbol("test-match-all").readResolve();
    Lit131 = localSimpleSymbol6;
    arrayOfObject2[5] = localSimpleSymbol6;
    SimpleSymbol localSimpleSymbol7 = (SimpleSymbol)new SimpleSymbol("%test-as-specifier").readResolve();
    Lit136 = localSimpleSymbol7;
    arrayOfObject2[6] = localSimpleSymbol7;
    SimpleSymbol localSimpleSymbol8 = (SimpleSymbol)new SimpleSymbol("%test-runner-fail-list").readResolve();
    Lit33 = localSimpleSymbol8;
    arrayOfObject2[7] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol8, PairWithPosition.make(Lit143, LList.Empty, "testing.scm", 3964958), "testing.scm", 3964934), LList.Empty, "testing.scm", 3964934);
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\003", "\021\030\004\021\030\f\b\021\030\024\021\030\034\b\021\030$Q\021\030,\b\005\021\0304\b\003\030<", arrayOfObject2, 1);
    Lit140 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 1);
    Object[] arrayOfObject3 = new Object[1];
    SimpleSymbol localSimpleSymbol9 = (SimpleSymbol)new SimpleSymbol("test-skip").readResolve();
    Lit137 = localSimpleSymbol9;
    arrayOfObject3[0] = localSimpleSymbol9;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject4 = new Object[8];
    arrayOfObject4[0] = Lit144;
    arrayOfObject4[1] = PairWithPosition.make(PairWithPosition.make(Lit143, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 3919892), LList.Empty, "testing.scm", 3919892), "testing.scm", 3919884), LList.Empty, "testing.scm", 3919883);
    SimpleSymbol localSimpleSymbol10 = (SimpleSymbol)new SimpleSymbol("%test-runner-skip-list!").readResolve();
    Lit32 = localSimpleSymbol10;
    arrayOfObject4[2] = localSimpleSymbol10;
    arrayOfObject4[3] = Lit143;
    arrayOfObject4[4] = Lit145;
    arrayOfObject4[5] = Lit131;
    arrayOfObject4[6] = Lit136;
    SimpleSymbol localSimpleSymbol11 = (SimpleSymbol)new SimpleSymbol("%test-runner-skip-list").readResolve();
    Lit31 = localSimpleSymbol11;
    arrayOfObject4[7] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol11, PairWithPosition.make(Lit143, LList.Empty, "testing.scm", 3932190), "testing.scm", 3932166), LList.Empty, "testing.scm", 3932166);
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\003", "\021\030\004\021\030\f\b\021\030\024\021\030\034\b\021\030$Q\021\030,\b\005\021\0304\b\003\030<", arrayOfObject4, 1);
    Lit138 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 1);
    Object[] arrayOfObject5 = new Object[1];
    SimpleSymbol localSimpleSymbol12 = (SimpleSymbol)new SimpleSymbol("test-match-any").readResolve();
    Lit134 = localSimpleSymbol12;
    arrayOfObject5[0] = localSimpleSymbol12;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject6 = new Object[2];
    SimpleSymbol localSimpleSymbol13 = (SimpleSymbol)new SimpleSymbol("%test-match-any").readResolve();
    Lit133 = localSimpleSymbol13;
    arrayOfObject6[0] = localSimpleSymbol13;
    arrayOfObject6[1] = Lit136;
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "\003", "\021\030\004\b\005\021\030\f\b\003", arrayOfObject6, 1);
    Lit135 = new SyntaxRules(arrayOfObject5, arrayOfSyntaxRule3, 1);
    Object[] arrayOfObject7 = new Object[1];
    arrayOfObject7[0] = Lit131;
    SyntaxRule[] arrayOfSyntaxRule4 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("", new Object[0], 1);
    Object[] arrayOfObject8 = new Object[2];
    SimpleSymbol localSimpleSymbol14 = (SimpleSymbol)new SimpleSymbol("%test-match-all").readResolve();
    Lit130 = localSimpleSymbol14;
    arrayOfObject8[0] = localSimpleSymbol14;
    arrayOfObject8[1] = Lit136;
    arrayOfSyntaxRule4[0] = new SyntaxRule(localSyntaxPattern4, "\003", "\021\030\004\b\005\021\030\f\b\003", arrayOfObject8, 1);
    Lit132 = new SyntaxRules(arrayOfObject7, arrayOfSyntaxRule4, 1);
    Object[] arrayOfObject9 = new Object[1];
    SimpleSymbol localSimpleSymbol15 = (SimpleSymbol)new SimpleSymbol("test-match-nth").readResolve();
    Lit128 = localSimpleSymbol15;
    arrayOfObject9[0] = localSimpleSymbol15;
    SyntaxRule[] arrayOfSyntaxRule5 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern5 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject10 = new Object[2];
    arrayOfObject10[0] = Lit128;
    IntNum localIntNum = IntNum.make(1);
    Lit13 = localIntNum;
    arrayOfObject10[1] = PairWithPosition.make(localIntNum, LList.Empty, "testing.scm", 3727384);
    arrayOfSyntaxRule5[0] = new SyntaxRule(localSyntaxPattern5, "\001", "\021\030\004\t\003\030\f", arrayOfObject10, 0);
    SyntaxPattern localSyntaxPattern6 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject11 = new Object[1];
    SimpleSymbol localSimpleSymbol16 = (SimpleSymbol)new SimpleSymbol("%test-match-nth").readResolve();
    Lit127 = localSimpleSymbol16;
    arrayOfObject11[0] = localSimpleSymbol16;
    arrayOfSyntaxRule5[1] = new SyntaxRule(localSyntaxPattern6, "\001\001", "\021\030\004\t\003\b\013", arrayOfObject11, 0);
    Lit129 = new SyntaxRules(arrayOfObject9, arrayOfSyntaxRule5, 2);
    Object[] arrayOfObject12 = new Object[1];
    SimpleSymbol localSimpleSymbol17 = (SimpleSymbol)new SimpleSymbol("test-with-runner").readResolve();
    Lit125 = localSimpleSymbol17;
    arrayOfObject12[0] = localSimpleSymbol17;
    SyntaxRule[] arrayOfSyntaxRule6 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern7 = new SyntaxPattern("\f\030\f\007\r\017\b\b\b", new Object[0], 2);
    Object[] arrayOfObject13 = new Object[6];
    arrayOfObject13[0] = Lit144;
    arrayOfObject13[1] = PairWithPosition.make(PairWithPosition.make(Lit148, PairWithPosition.make(PairWithPosition.make(Lit146, LList.Empty, "testing.scm", 3657754), LList.Empty, "testing.scm", 3657754), "testing.scm", 3657740), LList.Empty, "testing.scm", 3657739);
    arrayOfObject13[2] = Lit165;
    arrayOfObject13[3] = Lit147;
    arrayOfObject13[4] = Lit146;
    arrayOfObject13[5] = PairWithPosition.make(PairWithPosition.make(Lit147, PairWithPosition.make(LList.Empty, PairWithPosition.make(PairWithPosition.make(Lit146, PairWithPosition.make(Lit148, LList.Empty, "testing.scm", 3674156), "testing.scm", 3674135), LList.Empty, "testing.scm", 3674135), "testing.scm", 3674132), "testing.scm", 3674124), LList.Empty, "testing.scm", 3674124);
    arrayOfSyntaxRule6[0] = new SyntaxRule(localSyntaxPattern7, "\001\003", "\021\030\004\021\030\f\b\021\030\024Y\021\030\034\t\020\b\021\030$\b\003A\021\030\034\t\020\b\r\013\030,", arrayOfObject13, 1);
    Lit126 = new SyntaxRules(arrayOfObject12, arrayOfSyntaxRule6, 2);
    Lit124 = (SimpleSymbol)new SimpleSymbol("test-apply").readResolve();
    Object[] arrayOfObject14 = new Object[6];
    arrayOfObject14[0] = Lit150;
    arrayOfObject14[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 3514382), LList.Empty, "testing.scm", 3514382), "testing.scm", 3514379), LList.Empty, "testing.scm", 3514378);
    SimpleSymbol localSimpleSymbol18 = (SimpleSymbol)new SimpleSymbol("test-result-alist!").readResolve();
    Lit52 = localSimpleSymbol18;
    arrayOfObject14[2] = localSimpleSymbol18;
    arrayOfObject14[3] = Lit149;
    SimpleSymbol localSimpleSymbol19 = (SimpleSymbol)new SimpleSymbol("%test-error").readResolve();
    Lit115 = localSimpleSymbol19;
    arrayOfObject14[4] = localSimpleSymbol19;
    arrayOfObject14[5] = Boolean.TRUE;
    Lit123 = new SyntaxTemplate("\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\023\b\021\030$\021\030\034\021\030,\b\013", arrayOfObject14, 0);
    Lit122 = new SyntaxPattern(",\f\007\f\017\b\f\027\b", new Object[0], 3);
    Object[] arrayOfObject15 = new Object[5];
    arrayOfObject15[0] = Lit150;
    arrayOfObject15[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 3493902), LList.Empty, "testing.scm", 3493902), "testing.scm", 3493899), LList.Empty, "testing.scm", 3493898);
    arrayOfObject15[2] = Lit52;
    arrayOfObject15[3] = Lit149;
    arrayOfObject15[4] = Lit115;
    Lit121 = new SyntaxTemplate("\001\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\033\b\021\030$\021\030\034\t\013\b\023", arrayOfObject15, 0);
    Lit120 = new SyntaxPattern("<\f\007\f\017\f\027\b\f\037\b", new Object[0], 4);
    Object[] arrayOfObject16 = new Object[8];
    arrayOfObject16[0] = Lit150;
    arrayOfObject16[1] = PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 3469326), LList.Empty, "testing.scm", 3469326), "testing.scm", 3469323);
    arrayOfObject16[2] = Lit160;
    arrayOfObject16[3] = Lit52;
    arrayOfObject16[4] = Lit149;
    arrayOfObject16[5] = Lit145;
    SimpleSymbol localSimpleSymbol20 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit15 = localSimpleSymbol20;
    SimpleSymbol localSimpleSymbol21 = (SimpleSymbol)new SimpleSymbol("test-name").readResolve();
    Lit7 = localSimpleSymbol21;
    arrayOfObject16[6] = PairWithPosition.make(localSimpleSymbol20, PairWithPosition.make(localSimpleSymbol21, LList.Empty, "testing.scm", 3477545), "testing.scm", 3477545);
    arrayOfObject16[7] = Lit115;
    Lit119 = new SyntaxTemplate("\001\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013©\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b#\b\021\030<\021\030$\t\023\b\033", arrayOfObject16, 0);
    Lit118 = new SyntaxPattern("L\f\007\f\017\f\027\f\037\b\f'\b", new Object[0], 5);
    Lit117 = (SimpleSymbol)new SimpleSymbol("test-error").readResolve();
    Object[] arrayOfObject17 = new Object[1];
    arrayOfObject17[0] = Lit115;
    SyntaxRule[] arrayOfSyntaxRule7 = new SyntaxRule[2];
    Object[] arrayOfObject18 = new Object[1];
    arrayOfObject18[0] = Boolean.TRUE;
    SyntaxPattern localSyntaxPattern8 = new SyntaxPattern("\f\030\f\007\f\002\f\017\b", arrayOfObject18, 2);
    Object[] arrayOfObject19 = new Object[14];
    arrayOfObject19[0] = Lit158;
    SimpleSymbol localSimpleSymbol22 = (SimpleSymbol)new SimpleSymbol("%test-on-test-begin").readResolve();
    Lit86 = localSimpleSymbol22;
    arrayOfObject19[1] = localSimpleSymbol22;
    SimpleSymbol localSimpleSymbol23 = (SimpleSymbol)new SimpleSymbol("test-result-set!").readResolve();
    Lit78 = localSimpleSymbol23;
    arrayOfObject19[2] = localSimpleSymbol23;
    arrayOfObject19[3] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit152, LList.Empty, "testing.scm", 3223581), "testing.scm", 3223581), PairWithPosition.make(Boolean.TRUE, LList.Empty, "testing.scm", 3223596), "testing.scm", 3223580);
    SimpleSymbol localSimpleSymbol24 = (SimpleSymbol)new SimpleSymbol("%test-on-test-end").readResolve();
    Lit87 = localSimpleSymbol24;
    arrayOfObject19[4] = localSimpleSymbol24;
    arrayOfObject19[5] = Lit154;
    arrayOfObject19[6] = Lit144;
    arrayOfObject19[7] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 3239966), "testing.scm", 3239966);
    arrayOfObject19[8] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 3244041);
    arrayOfObject19[9] = Lit151;
    arrayOfObject19[10] = Lit156;
    arrayOfObject19[11] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit157, LList.Empty, "testing.scm", 3252256), "testing.scm", 3252256), PairWithPosition.make(Lit151, LList.Empty, "testing.scm", 3252269), "testing.scm", 3252255);
    arrayOfObject19[12] = PairWithPosition.make(Boolean.TRUE, LList.Empty, "testing.scm", 3256331);
    SimpleSymbol localSimpleSymbol25 = (SimpleSymbol)new SimpleSymbol("%test-report-result").readResolve();
    Lit83 = localSimpleSymbol25;
    arrayOfObject19[13] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol25, LList.Empty, "testing.scm", 3260424), LList.Empty, "testing.scm", 3260424);
    arrayOfSyntaxRule7[0] = new SyntaxRule(localSyntaxPattern8, "\001\001", "\021\030\004\b)\021\030\f\b\0039\021\030\024\t\003\030\034ũ\021\030$\t\003\b\021\030,\021\0304\t\020Q\021\030\024\t\003\021\030<\b\013\030D\b\021\030L\021\030T9\021\030\024\t\003\030\\\030d\030l", arrayOfObject19, 0);
    SyntaxPattern localSyntaxPattern9 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject20 = new Object[15];
    arrayOfObject20[0] = Lit161;
    arrayOfObject20[1] = Lit86;
    arrayOfObject20[2] = Lit144;
    arrayOfObject20[3] = Lit153;
    arrayOfObject20[4] = Lit78;
    arrayOfObject20[5] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit152, LList.Empty, "testing.scm", 3276828), "testing.scm", 3276828), PairWithPosition.make(Lit153, LList.Empty, "testing.scm", 3276843), "testing.scm", 3276827);
    arrayOfObject20[6] = Lit87;
    arrayOfObject20[7] = Lit154;
    arrayOfObject20[8] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 3293213), "testing.scm", 3293213);
    arrayOfObject20[9] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 3297288);
    arrayOfObject20[10] = Lit151;
    arrayOfObject20[11] = Lit156;
    arrayOfObject20[12] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit157, LList.Empty, "testing.scm", 3305503), "testing.scm", 3305503), PairWithPosition.make(Lit151, LList.Empty, "testing.scm", 3305516), "testing.scm", 3305502);
    SimpleSymbol localSimpleSymbol26 = Lit158;
    SimpleSymbol localSimpleSymbol27 = (SimpleSymbol)new SimpleSymbol("and").readResolve();
    PairWithPosition localPairWithPosition = PairWithPosition.make(Lit159, PairWithPosition.make(Lit153, PairWithPosition.make((SimpleSymbol)new SimpleSymbol("<gnu.bytecode.ClassType>").readResolve(), LList.Empty, "testing.scm", 3309604), "testing.scm", 3309601), "testing.scm", 3309590);
    SimpleSymbol localSimpleSymbol28 = (SimpleSymbol)new SimpleSymbol("$lookup$").readResolve();
    SimpleSymbol localSimpleSymbol29 = (SimpleSymbol)new SimpleSymbol("gnu.bytecode.ClassType").readResolve();
    SimpleSymbol localSimpleSymbol30 = (SimpleSymbol)new SimpleSymbol("quasiquote").readResolve();
    SimpleSymbol localSimpleSymbol31 = new SimpleSymbol("isSubclass");
    arrayOfObject20[13] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol26, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(localSimpleSymbol27, PairWithPosition.make(localPairWithPosition, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(localSimpleSymbol28, Pair.make(localSimpleSymbol29, Pair.make(Pair.make(localSimpleSymbol30, Pair.make((SimpleSymbol)localSimpleSymbol31.readResolve(), LList.Empty)), LList.Empty)), "testing.scm", 3313673), PairWithPosition.make(Lit153, PairWithPosition.make(Lit156, LList.Empty, "testing.scm", 3313710), "testing.scm", 3313707), "testing.scm", 3313672), LList.Empty, "testing.scm", 3313672), "testing.scm", 3309590), "testing.scm", 3309585), PairWithPosition.make(PairWithPosition.make(Lit159, PairWithPosition.make(Lit151, PairWithPosition.make(Lit153, LList.Empty, "testing.scm", 3317784), "testing.scm", 3317781), "testing.scm", 3317770), LList.Empty, "testing.scm", 3317770), "testing.scm", 3309584), PairWithPosition.make(PairWithPosition.make((SimpleSymbol)new SimpleSymbol("else").readResolve(), PairWithPosition.make(Boolean.TRUE, LList.Empty, "testing.scm", 3321871), "testing.scm", 3321865), LList.Empty, "testing.scm", 3321865), "testing.scm", 3309584), "testing.scm", 3309578), LList.Empty, "testing.scm", 3309578);
    arrayOfObject20[14] = PairWithPosition.make(PairWithPosition.make(Lit83, LList.Empty, "testing.scm", 3325959), LList.Empty, "testing.scm", 3325959);
    arrayOfSyntaxRule7[1] = new SyntaxRule(localSyntaxPattern9, "\001\001\001", "\021\030\004)\021\030\f\b\003\b\021\030\0241\b\021\030\034\b\0139\021\030$\t\003\030,ũ\021\0304\t\003\b\021\030<\021\030\024\t\020Q\021\030$\t\003\021\030D\b\023\030L\b\021\030T\021\030\\9\021\030$\t\003\030d\030l\030t", arrayOfObject20, 0);
    SyntaxRules localSyntaxRules = new SyntaxRules(arrayOfObject17, arrayOfSyntaxRule7, 3);
    Lit116 = localSyntaxRules;
    Object[] arrayOfObject21 = new Object[6];
    arrayOfObject21[0] = Lit150;
    arrayOfObject21[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2916364), LList.Empty, "testing.scm", 2916364), "testing.scm", 2916361), LList.Empty, "testing.scm", 2916360);
    arrayOfObject21[2] = Lit52;
    arrayOfObject21[3] = Lit149;
    SimpleSymbol localSimpleSymbol32 = (SimpleSymbol)new SimpleSymbol("%test-comp2body").readResolve();
    Lit89 = localSimpleSymbol32;
    arrayOfObject21[4] = localSimpleSymbol32;
    SimpleSymbol localSimpleSymbol33 = (SimpleSymbol)new SimpleSymbol("%test-approximimate=").readResolve();
    Lit91 = localSimpleSymbol33;
    arrayOfObject21[5] = localSimpleSymbol33;
    Lit114 = new SyntaxTemplate("\001\001\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b#\b\021\030$\021\030\034)\021\030,\b\033\t\013\b\023", arrayOfObject21, 0);
    Lit113 = new SyntaxPattern("L\f\007\f\017\f\027\f\037\b\f'\b", new Object[0], 5);
    Object[] arrayOfObject22 = new Object[9];
    arrayOfObject22[0] = Lit150;
    arrayOfObject22[1] = PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2891788), LList.Empty, "testing.scm", 2891788), "testing.scm", 2891785);
    arrayOfObject22[2] = Lit160;
    arrayOfObject22[3] = Lit52;
    arrayOfObject22[4] = Lit149;
    arrayOfObject22[5] = Lit145;
    arrayOfObject22[6] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 2900007), "testing.scm", 2900007);
    arrayOfObject22[7] = Lit89;
    arrayOfObject22[8] = Lit91;
    Lit112 = new SyntaxTemplate("\001\001\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013©\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b+\b\021\030<\021\030$)\021\030D\b#\t\023\b\033", arrayOfObject22, 0);
    Lit111 = new SyntaxPattern("\\\f\007\f\017\f\027\f\037\f'\b\f/\b", new Object[0], 6);
    Lit110 = (SimpleSymbol)new SimpleSymbol("test-approximate").readResolve();
    Object[] arrayOfObject23 = new Object[1];
    arrayOfObject23[0] = ((SimpleSymbol)new SimpleSymbol("equal?").readResolve());
    Lit109 = new SyntaxTemplate("", "\030\004", arrayOfObject23, 0);
    Lit108 = (SimpleSymbol)new SimpleSymbol("test-equal").readResolve();
    Object[] arrayOfObject24 = new Object[1];
    arrayOfObject24[0] = ((SimpleSymbol)new SimpleSymbol("eq?").readResolve());
    Lit107 = new SyntaxTemplate("", "\030\004", arrayOfObject24, 0);
    Lit106 = (SimpleSymbol)new SimpleSymbol("test-eq").readResolve();
    Object[] arrayOfObject25 = new Object[1];
    arrayOfObject25[0] = ((SimpleSymbol)new SimpleSymbol("eqv?").readResolve());
    Lit105 = new SyntaxTemplate("", "\030\004", arrayOfObject25, 0);
    Lit104 = (SimpleSymbol)new SimpleSymbol("test-eqv").readResolve();
    Object[] arrayOfObject26 = new Object[5];
    arrayOfObject26[0] = Lit150;
    arrayOfObject26[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2781198), LList.Empty, "testing.scm", 2781198), "testing.scm", 2781195), LList.Empty, "testing.scm", 2781194);
    arrayOfObject26[2] = Lit52;
    arrayOfObject26[3] = Lit149;
    SimpleSymbol localSimpleSymbol34 = (SimpleSymbol)new SimpleSymbol("%test-comp1body").readResolve();
    Lit92 = localSimpleSymbol34;
    arrayOfObject26[4] = localSimpleSymbol34;
    Lit103 = new SyntaxTemplate("\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\023\b\021\030$\021\030\034\b\013", arrayOfObject26, 0);
    Lit102 = new SyntaxPattern(",\f\007\f\017\b\f\027\b", new Object[0], 3);
    Object[] arrayOfObject27 = new Object[8];
    arrayOfObject27[0] = Lit150;
    arrayOfObject27[1] = PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2756622), LList.Empty, "testing.scm", 2756622), "testing.scm", 2756619);
    arrayOfObject27[2] = Lit160;
    arrayOfObject27[3] = Lit52;
    arrayOfObject27[4] = Lit149;
    arrayOfObject27[5] = Lit145;
    arrayOfObject27[6] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 2764841), "testing.scm", 2764841);
    arrayOfObject27[7] = Lit92;
    Lit101 = new SyntaxTemplate("\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013©\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b\033\b\021\030<\021\030$\b\023", arrayOfObject27, 0);
    Lit100 = new SyntaxPattern("<\f\007\f\017\f\027\b\f\037\b", new Object[0], 4);
    Lit99 = (SimpleSymbol)new SimpleSymbol("test-assert").readResolve();
    Object[] arrayOfObject28 = new Object[2];
    SimpleSymbol localSimpleSymbol35 = (SimpleSymbol)new SimpleSymbol("%test-end").readResolve();
    Lit69 = localSimpleSymbol35;
    arrayOfObject28[0] = localSimpleSymbol35;
    arrayOfObject28[1] = Boolean.FALSE;
    Lit98 = new SyntaxTemplate("\001\001", "\021\030\004\021\030\f\b\013", arrayOfObject28, 0);
    Lit97 = new SyntaxPattern("\034\f\007\b\f\017\b", new Object[0], 2);
    Object[] arrayOfObject29 = new Object[1];
    arrayOfObject29[0] = Lit69;
    Lit96 = new SyntaxTemplate("\001\001\001", "\021\030\004\t\013\b\023", arrayOfObject29, 0);
    Lit95 = new SyntaxPattern(",\f\007\f\017\b\f\027\b", new Object[0], 3);
    Lit94 = (SimpleSymbol)new SimpleSymbol("test-end").readResolve();
    Object[] arrayOfObject30 = new Object[1];
    arrayOfObject30[0] = Lit92;
    SyntaxRule[] arrayOfSyntaxRule8 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern10 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject31 = new Object[10];
    arrayOfObject31[0] = Lit144;
    arrayOfObject31[1] = Lit161;
    arrayOfObject31[2] = Lit86;
    arrayOfObject31[3] = Lit162;
    SimpleSymbol localSimpleSymbol36 = (SimpleSymbol)new SimpleSymbol("%test-evaluate-with-catch").readResolve();
    Lit84 = localSimpleSymbol36;
    arrayOfObject31[4] = localSimpleSymbol36;
    arrayOfObject31[5] = Lit78;
    arrayOfObject31[6] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 2666526), "testing.scm", 2666526), PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 2666539), "testing.scm", 2666525);
    arrayOfObject31[7] = Lit87;
    arrayOfObject31[8] = PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 2670622);
    arrayOfObject31[9] = PairWithPosition.make(PairWithPosition.make(Lit83, LList.Empty, "testing.scm", 2674696), LList.Empty, "testing.scm", 2674696);
    arrayOfSyntaxRule8[0] = new SyntaxRule(localSyntaxPattern10, "\001\001", "\021\030\004\t\020ű\021\030\f)\021\030\024\b\003\b\021\030\004\t\020\b\021\030\004Q\b\021\030\034\b\021\030$\b\0139\021\030,\t\003\0304\b\021\030<\t\003\030D\030L", arrayOfObject31, 0);
    Lit93 = new SyntaxRules(arrayOfObject30, arrayOfSyntaxRule8, 2);
    Object[] arrayOfObject32 = new Object[1];
    arrayOfObject32[0] = Lit89;
    SyntaxRule[] arrayOfSyntaxRule9 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern11 = new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037\b", new Object[0], 4);
    Object[] arrayOfObject33 = new Object[12];
    arrayOfObject33[0] = Lit144;
    arrayOfObject33[1] = Lit161;
    arrayOfObject33[2] = Lit86;
    arrayOfObject33[3] = Lit163;
    arrayOfObject33[4] = Lit78;
    SimpleSymbol localSimpleSymbol37 = Lit15;
    SimpleSymbol localSimpleSymbol38 = new SimpleSymbol("expected-value");
    arrayOfObject33[5] = PairWithPosition.make(PairWithPosition.make(localSimpleSymbol37, PairWithPosition.make((SimpleSymbol)localSimpleSymbol38.readResolve(), LList.Empty, "testing.scm", 2592794), "testing.scm", 2592794), PairWithPosition.make(Lit163, LList.Empty, "testing.scm", 2592809), "testing.scm", 2592793);
    arrayOfObject33[6] = Lit162;
    arrayOfObject33[7] = Lit84;
    arrayOfObject33[8] = PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit155, LList.Empty, "testing.scm", 2600988), "testing.scm", 2600988), PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 2601001), "testing.scm", 2600987);
    arrayOfObject33[9] = Lit87;
    arrayOfObject33[10] = PairWithPosition.make(Lit163, PairWithPosition.make(Lit162, LList.Empty, "testing.scm", 2605094), "testing.scm", 2605090);
    arrayOfObject33[11] = PairWithPosition.make(PairWithPosition.make(Lit83, LList.Empty, "testing.scm", 2609158), LList.Empty, "testing.scm", 2609158);
    arrayOfSyntaxRule9[0] = new SyntaxRule(localSyntaxPattern11, "\001\001\001\001", "\021\030\004\t\020Ǳ\021\030\f)\021\030\024\b\003\b\021\030\0041\b\021\030\034\b\0239\021\030$\t\003\030,\b\021\030\004Q\b\021\0304\b\021\030<\b\0339\021\030$\t\003\030D\b\021\030L\t\003\b\t\013\030T\030\\", arrayOfObject33, 0);
    Lit90 = new SyntaxRules(arrayOfObject32, arrayOfSyntaxRule9, 4);
    Lit88 = (SimpleSymbol)new SimpleSymbol("test-runner-test-name").readResolve();
    Object[] arrayOfObject34 = new Object[1];
    arrayOfObject34[0] = Lit84;
    SyntaxRule[] arrayOfSyntaxRule10 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern12 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject35 = new Object[2];
    arrayOfObject35[0] = Lit154;
    arrayOfObject35[1] = PairWithPosition.make(PairWithPosition.make(Lit151, PairWithPosition.make(Lit156, PairWithPosition.make(PairWithPosition.make(Lit78, PairWithPosition.make(PairWithPosition.make(Lit146, LList.Empty, "testing.scm", 2347035), PairWithPosition.make(PairWithPosition.make(Lit15, PairWithPosition.make(Lit157, LList.Empty, "testing.scm", 2347058), "testing.scm", 2347058), PairWithPosition.make(Lit151, LList.Empty, "testing.scm", 2347071), "testing.scm", 2347057), "testing.scm", 2347035), "testing.scm", 2347017), PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 2351113), "testing.scm", 2347017), "testing.scm", 2342921), "testing.scm", 2342917), LList.Empty, "testing.scm", 2342917);
    arrayOfSyntaxRule10[0] = new SyntaxRule(localSyntaxPattern12, "\001", "\021\030\004\t\003\030\f", arrayOfObject35, 0);
    Lit85 = new SyntaxRules(arrayOfObject34, arrayOfSyntaxRule10, 1);
    Lit82 = (SimpleSymbol)new SimpleSymbol("test-passed?").readResolve();
    Lit81 = (SimpleSymbol)new SimpleSymbol("test-result-kind").readResolve();
    Lit80 = (SimpleSymbol)new SimpleSymbol("test-result-remove").readResolve();
    Lit79 = (SimpleSymbol)new SimpleSymbol("test-result-clear").readResolve();
    Lit77 = (SimpleSymbol)new SimpleSymbol("test-on-test-end-simple").readResolve();
    Object[] arrayOfObject36 = new Object[1];
    SimpleSymbol localSimpleSymbol39 = (SimpleSymbol)new SimpleSymbol("test-result-ref").readResolve();
    Lit75 = localSimpleSymbol39;
    arrayOfObject36[0] = localSimpleSymbol39;
    SyntaxRule[] arrayOfSyntaxRule11 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern13 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject37 = new Object[2];
    arrayOfObject37[0] = Lit75;
    arrayOfObject37[1] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 1933348);
    arrayOfSyntaxRule11[0] = new SyntaxRule(localSyntaxPattern13, "\001\001", "\021\030\004\t\003\t\013\030\f", arrayOfObject37, 0);
    SyntaxPattern localSyntaxPattern14 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject38 = new Object[6];
    arrayOfObject38[0] = Lit144;
    arrayOfObject38[1] = Lit164;
    arrayOfObject38[2] = ((SimpleSymbol)new SimpleSymbol("assq").readResolve());
    SimpleSymbol localSimpleSymbol40 = (SimpleSymbol)new SimpleSymbol("test-result-alist").readResolve();
    Lit51 = localSimpleSymbol40;
    arrayOfObject38[3] = localSimpleSymbol40;
    arrayOfObject38[4] = Lit161;
    arrayOfObject38[5] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("cdr").readResolve(), PairWithPosition.make(Lit164, LList.Empty, "testing.scm", 1945619), "testing.scm", 1945614);
    arrayOfSyntaxRule11[1] = new SyntaxRule(localSyntaxPattern14, "\001\001\001", "\021\030\004\b\021\030\f\b\021\030\024\t\013\b\021\030\034\b\003\b\021\030$\021\030\f\021\030,\b\023", arrayOfObject38, 0);
    Lit76 = new SyntaxRules(arrayOfObject36, arrayOfSyntaxRule11, 3);
    Lit74 = (SimpleSymbol)new SimpleSymbol("test-on-test-begin-simple").readResolve();
    Object[] arrayOfObject39 = new Object[1];
    SimpleSymbol localSimpleSymbol41 = (SimpleSymbol)new SimpleSymbol("test-group-with-cleanup").readResolve();
    Lit72 = localSimpleSymbol41;
    arrayOfObject39[0] = localSimpleSymbol41;
    SyntaxRule[] arrayOfSyntaxRule12 = new SyntaxRule[3];
    SyntaxPattern localSyntaxPattern15 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject40 = new Object[4];
    SimpleSymbol localSimpleSymbol42 = (SimpleSymbol)new SimpleSymbol("test-group").readResolve();
    Lit70 = localSimpleSymbol42;
    arrayOfObject40[0] = localSimpleSymbol42;
    arrayOfObject40[1] = Lit165;
    arrayOfObject40[2] = PairWithPosition.make(Lit147, PairWithPosition.make(LList.Empty, PairWithPosition.make(Boolean.FALSE, LList.Empty, "testing.scm", 1826831), "testing.scm", 1826828), "testing.scm", 1826820);
    arrayOfObject40[3] = Lit147;
    arrayOfSyntaxRule12[0] = new SyntaxRule(localSyntaxPattern15, "\001\001\001", "\021\030\004\t\003\b\021\030\f\021\030\0249\021\030\034\t\020\b\013\b\021\030\034\t\020\b\023", arrayOfObject40, 0);
    SyntaxPattern localSyntaxPattern16 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject41 = new Object[2];
    arrayOfObject41[0] = Lit72;
    arrayOfObject41[1] = Boolean.FALSE;
    arrayOfSyntaxRule12[1] = new SyntaxRule(localSyntaxPattern16, "\001\001", "\021\030\004\t\003\021\030\f\b\013", arrayOfObject41, 0);
    SyntaxPattern localSyntaxPattern17 = new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037#", new Object[0], 5);
    Object[] arrayOfObject42 = new Object[2];
    arrayOfObject42[0] = Lit72;
    arrayOfObject42[1] = ((SimpleSymbol)new SimpleSymbol("begin").readResolve());
    arrayOfSyntaxRule12[2] = new SyntaxRule(localSyntaxPattern17, "", "\021\030\004\t\0039\021\030\f\t\013\b\023\t\033\"", arrayOfObject42, 0);
    Lit73 = new SyntaxRules(arrayOfObject39, arrayOfSyntaxRule12, 5);
    Object[] arrayOfObject43 = new Object[1];
    arrayOfObject43[0] = Lit70;
    SyntaxRule[] arrayOfSyntaxRule13 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern18 = new SyntaxPattern("\f\030\f\007\013", new Object[0], 2);
    Object[] arrayOfObject44 = new Object[13];
    arrayOfObject44[0] = Lit144;
    arrayOfObject44[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit146, LList.Empty, "testing.scm", 1769487), LList.Empty, "testing.scm", 1769487), "testing.scm", 1769484), LList.Empty, "testing.scm", 1769483);
    arrayOfObject44[2] = Lit52;
    arrayOfObject44[3] = Lit149;
    arrayOfObject44[4] = ((SimpleSymbol)new SimpleSymbol("list").readResolve());
    arrayOfObject44[5] = Lit145;
    arrayOfObject44[6] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 1777707), "testing.scm", 1777707);
    arrayOfObject44[7] = Lit161;
    SimpleSymbol localSimpleSymbol43 = (SimpleSymbol)new SimpleSymbol("%test-should-execute").readResolve();
    Lit62 = localSimpleSymbol43;
    arrayOfObject44[8] = PairWithPosition.make(localSimpleSymbol43, PairWithPosition.make(Lit149, LList.Empty, "testing.scm", 1781794), "testing.scm", 1781772);
    arrayOfObject44[9] = Lit165;
    arrayOfObject44[10] = Lit147;
    arrayOfObject44[11] = ((SimpleSymbol)new SimpleSymbol("test-begin").readResolve());
    arrayOfObject44[12] = Lit94;
    arrayOfSyntaxRule13[0] = new SyntaxRule(localSyntaxPattern18, "", "\021\030\004\021\030\f\021\030\024\021\030\034\b\021\030$\b\021\030,\021\0304\b\003\b\021\030<\021\030D\b\021\030LY\021\030T\t\020\b\021\030\\\b\0031\021\030T\t\020\n\b\021\030T\t\020\b\021\030d\b\003", arrayOfObject44, 0);
    Lit71 = new SyntaxRules(arrayOfObject43, arrayOfSyntaxRule13, 2);
    Lit68 = (SimpleSymbol)new SimpleSymbol("test-on-final-simple").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("test-on-bad-end-name-simple").readResolve();
    Lit66 = (SimpleSymbol)new SimpleSymbol("test-on-bad-count-simple").readResolve();
    Lit65 = (SimpleSymbol)new SimpleSymbol("test-on-group-end-simple").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("test-on-group-begin-simple").readResolve();
    Lit63 = (SimpleSymbol)new SimpleSymbol("%test-begin").readResolve();
    Lit61 = (SimpleSymbol)new SimpleSymbol("test-runner-create").readResolve();
    Lit59 = (SimpleSymbol)new SimpleSymbol("test-runner-simple").readResolve();
    Lit58 = (SimpleSymbol)new SimpleSymbol("test-runner-null").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("%test-null-callback").readResolve();
    Lit56 = (SimpleSymbol)new SimpleSymbol("test-runner-group-path").readResolve();
    Lit55 = (SimpleSymbol)new SimpleSymbol("test-runner-reset").readResolve();
    Lit54 = (SimpleSymbol)new SimpleSymbol("test-runner-aux-value!").readResolve();
    Lit53 = (SimpleSymbol)new SimpleSymbol("test-runner-aux-value").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("test-runner-on-bad-end-name!").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("test-runner-on-bad-end-name").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("test-runner-on-bad-count!").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("test-runner-on-bad-count").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("test-runner-on-final!").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("test-runner-on-final").readResolve();
    Lit44 = (SimpleSymbol)new SimpleSymbol("test-runner-on-group-end!").readResolve();
    Lit43 = (SimpleSymbol)new SimpleSymbol("test-runner-on-group-end").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("test-runner-on-group-begin!").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("test-runner-on-group-begin").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("test-runner-on-test-end!").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("test-runner-on-test-end").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("test-runner-on-test-begin!").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("test-runner-on-test-begin").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("test-runner-group-stack!").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("test-runner-group-stack").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("test-runner-skip-count!").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("test-runner-skip-count").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("test-runner-xfail-count!").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("test-runner-xfail-count").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("test-runner-xpass-count!").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("test-runner-xpass-count").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("test-runner-fail-count!").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("test-runner-fail-count").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("test-runner-pass-count!").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("test-runner-pass-count").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("test-runner?").readResolve();
    Object[] arrayOfObject45 = new Object[5];
    arrayOfObject45[0] = Lit150;
    arrayOfObject45[1] = PairWithPosition.make(PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2834444), LList.Empty, "testing.scm", 2834444), "testing.scm", 2834441), LList.Empty, "testing.scm", 2834440);
    arrayOfObject45[2] = Lit52;
    arrayOfObject45[3] = Lit149;
    arrayOfObject45[4] = Lit89;
    Lit19 = new SyntaxTemplate("\001\001\001\001\001", "\021\030\004\021\030\fA\021\030\024\021\030\034\b\033\b\021\030$\021\030\034\t#\t\013\b\023", arrayOfObject45, 0);
    Lit18 = new SyntaxPattern("<\f\007\f\017\f\027\b\f\037\f'\b", new Object[0], 5);
    Object[] arrayOfObject46 = new Object[8];
    arrayOfObject46[0] = Lit150;
    arrayOfObject46[1] = PairWithPosition.make(Lit149, PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "testing.scm", 2809868), LList.Empty, "testing.scm", 2809868), "testing.scm", 2809865);
    arrayOfObject46[2] = Lit160;
    arrayOfObject46[3] = Lit52;
    arrayOfObject46[4] = Lit149;
    arrayOfObject46[5] = Lit145;
    arrayOfObject46[6] = PairWithPosition.make(Lit15, PairWithPosition.make(Lit7, LList.Empty, "testing.scm", 2818087), "testing.scm", 2818087);
    arrayOfObject46[7] = Lit89;
    Lit17 = new SyntaxTemplate("\001\001\001\001\001\001", "\021\030\004I\021\030\f\b\021\030\024\b\013©\021\030\034\021\030$\b\021\030,A\021\030,\021\0304\b\013\b#\b\021\030<\021\030$\t+\t\023\b\033", arrayOfObject46, 0);
    Lit16 = new SyntaxPattern("L\f\007\f\017\f\027\f\037\b\f'\f/\b", new Object[0], 6);
    Lit14 = (SimpleSymbol)new SimpleSymbol("fail").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("pass").readResolve();
    SimpleSymbol localSimpleSymbol44 = Lit12;
    SimpleSymbol localSimpleSymbol45 = (SimpleSymbol)new SimpleSymbol("xpass").readResolve();
    Lit9 = localSimpleSymbol45;
    Lit11 = PairWithPosition.make(localSimpleSymbol44, PairWithPosition.make(localSimpleSymbol45, LList.Empty, "testing.scm", 2220088), "testing.scm", 2220082);
    SimpleSymbol localSimpleSymbol46 = Lit7;
    SimpleSymbol localSimpleSymbol47 = (SimpleSymbol)new SimpleSymbol("source-file").readResolve();
    Lit4 = localSimpleSymbol47;
    SimpleSymbol localSimpleSymbol48 = (SimpleSymbol)new SimpleSymbol("source-line").readResolve();
    Lit5 = localSimpleSymbol48;
    SimpleSymbol localSimpleSymbol49 = (SimpleSymbol)new SimpleSymbol("source-form").readResolve();
    Lit6 = localSimpleSymbol49;
    Lit10 = PairWithPosition.make(localSimpleSymbol46, PairWithPosition.make(localSimpleSymbol47, PairWithPosition.make(localSimpleSymbol48, PairWithPosition.make(localSimpleSymbol49, LList.Empty, "testing.scm", 2072618), "testing.scm", 2072606), "testing.scm", 2072594), "testing.scm", 2072583);
    Lit8 = PairWithPosition.make(Lit14, PairWithPosition.make(Lit9, LList.Empty, "testing.scm", 1966107), "testing.scm", 1966101);
    Lit3 = (SimpleSymbol)new SimpleSymbol("xfail").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("skip").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("result-kind").readResolve();
    Lit0 = IntNum.make(0);
    $instance = new testing();
    test$Mnrunner = test.Mnrunner.class;
    testing localtesting = $instance;
    test$Mnrunner$Qu = new ModuleMethod(localtesting, 12, Lit20, 4097);
    test$Mnrunner$Mnpass$Mncount = new ModuleMethod(localtesting, 13, Lit21, 4097);
    test$Mnrunner$Mnpass$Mncount$Ex = new ModuleMethod(localtesting, 14, Lit22, 8194);
    test$Mnrunner$Mnfail$Mncount = new ModuleMethod(localtesting, 15, Lit23, 4097);
    test$Mnrunner$Mnfail$Mncount$Ex = new ModuleMethod(localtesting, 16, Lit24, 8194);
    test$Mnrunner$Mnxpass$Mncount = new ModuleMethod(localtesting, 17, Lit25, 4097);
    test$Mnrunner$Mnxpass$Mncount$Ex = new ModuleMethod(localtesting, 18, Lit26, 8194);
    test$Mnrunner$Mnxfail$Mncount = new ModuleMethod(localtesting, 19, Lit27, 4097);
    test$Mnrunner$Mnxfail$Mncount$Ex = new ModuleMethod(localtesting, 20, Lit28, 8194);
    test$Mnrunner$Mnskip$Mncount = new ModuleMethod(localtesting, 21, Lit29, 4097);
    test$Mnrunner$Mnskip$Mncount$Ex = new ModuleMethod(localtesting, 22, Lit30, 8194);
    $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist = new ModuleMethod(localtesting, 23, Lit31, 4097);
    $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist$Ex = new ModuleMethod(localtesting, 24, Lit32, 8194);
    $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist = new ModuleMethod(localtesting, 25, Lit33, 4097);
    $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist$Ex = new ModuleMethod(localtesting, 26, Lit34, 8194);
    test$Mnrunner$Mngroup$Mnstack = new ModuleMethod(localtesting, 27, Lit35, 4097);
    test$Mnrunner$Mngroup$Mnstack$Ex = new ModuleMethod(localtesting, 28, Lit36, 8194);
    test$Mnrunner$Mnon$Mntest$Mnbegin = new ModuleMethod(localtesting, 29, Lit37, 4097);
    test$Mnrunner$Mnon$Mntest$Mnbegin$Ex = new ModuleMethod(localtesting, 30, Lit38, 8194);
    test$Mnrunner$Mnon$Mntest$Mnend = new ModuleMethod(localtesting, 31, Lit39, 4097);
    test$Mnrunner$Mnon$Mntest$Mnend$Ex = new ModuleMethod(localtesting, 32, Lit40, 8194);
    test$Mnrunner$Mnon$Mngroup$Mnbegin = new ModuleMethod(localtesting, 33, Lit41, 4097);
    test$Mnrunner$Mnon$Mngroup$Mnbegin$Ex = new ModuleMethod(localtesting, 34, Lit42, 8194);
    test$Mnrunner$Mnon$Mngroup$Mnend = new ModuleMethod(localtesting, 35, Lit43, 4097);
    test$Mnrunner$Mnon$Mngroup$Mnend$Ex = new ModuleMethod(localtesting, 36, Lit44, 8194);
    test$Mnrunner$Mnon$Mnfinal = new ModuleMethod(localtesting, 37, Lit45, 4097);
    test$Mnrunner$Mnon$Mnfinal$Ex = new ModuleMethod(localtesting, 38, Lit46, 8194);
    test$Mnrunner$Mnon$Mnbad$Mncount = new ModuleMethod(localtesting, 39, Lit47, 4097);
    test$Mnrunner$Mnon$Mnbad$Mncount$Ex = new ModuleMethod(localtesting, 40, Lit48, 8194);
    test$Mnrunner$Mnon$Mnbad$Mnend$Mnname = new ModuleMethod(localtesting, 41, Lit49, 4097);
    test$Mnrunner$Mnon$Mnbad$Mnend$Mnname$Ex = new ModuleMethod(localtesting, 42, Lit50, 8194);
    test$Mnresult$Mnalist = new ModuleMethod(localtesting, 43, Lit51, 4097);
    test$Mnresult$Mnalist$Ex = new ModuleMethod(localtesting, 44, Lit52, 8194);
    test$Mnrunner$Mnaux$Mnvalue = new ModuleMethod(localtesting, 45, Lit53, 4097);
    test$Mnrunner$Mnaux$Mnvalue$Ex = new ModuleMethod(localtesting, 46, Lit54, 8194);
    test$Mnrunner$Mnreset = new ModuleMethod(localtesting, 47, Lit55, 4097);
    test$Mnrunner$Mngroup$Mnpath = new ModuleMethod(localtesting, 48, Lit56, 4097);
    $Pctest$Mnnull$Mncallback = new ModuleMethod(localtesting, 49, Lit57, 4097);
    ModuleMethod localModuleMethod1 = new ModuleMethod(localtesting, 50, null, 12291);
    localModuleMethod1.setProperty("source-location", "testing.scm:182");
    lambda$Fn1 = localModuleMethod1;
    ModuleMethod localModuleMethod2 = new ModuleMethod(localtesting, 51, null, 12291);
    localModuleMethod2.setProperty("source-location", "testing.scm:187");
    lambda$Fn2 = localModuleMethod2;
    ModuleMethod localModuleMethod3 = new ModuleMethod(localtesting, 52, null, 12291);
    localModuleMethod3.setProperty("source-location", "testing.scm:188");
    lambda$Fn3 = localModuleMethod3;
    test$Mnrunner$Mnnull = new ModuleMethod(localtesting, 53, Lit58, 0);
    test$Mnrunner$Mnsimple = new ModuleMethod(localtesting, 54, Lit59, 0);
    test$Mnrunner$Mnget = new ModuleMethod(localtesting, 55, Lit60, 0);
    test$Mnrunner$Mncreate = new ModuleMethod(localtesting, 56, Lit61, 0);
    $Prvt$$Pctest$Mnshould$Mnexecute = new ModuleMethod(localtesting, 57, Lit62, 4097);
    $Pctest$Mnbegin = new ModuleMethod(localtesting, 58, Lit63, 8194);
    test$Mnon$Mngroup$Mnbegin$Mnsimple = new ModuleMethod(localtesting, 59, Lit64, 12291);
    test$Mnon$Mngroup$Mnend$Mnsimple = new ModuleMethod(localtesting, 60, Lit65, 4097);
    test$Mnon$Mnbad$Mncount$Mnsimple = new ModuleMethod(localtesting, 61, Lit66, 12291);
    test$Mnon$Mnbad$Mnend$Mnname$Mnsimple = new ModuleMethod(localtesting, 62, Lit67, 12291);
    test$Mnon$Mnfinal$Mnsimple = new ModuleMethod(localtesting, 63, Lit68, 4097);
    $Prvt$$Pctest$Mnend = new ModuleMethod(localtesting, 64, Lit69, 8194);
    $Prvt$test$Mngroup = Macro.make(Lit70, Lit71, $instance);
    test$Mngroup$Mnwith$Mncleanup = Macro.make(Lit72, Lit73, $instance);
    test$Mnon$Mntest$Mnbegin$Mnsimple = new ModuleMethod(localtesting, 65, Lit74, 4097);
    test$Mnresult$Mnref = Macro.make(Lit75, Lit76, $instance);
    test$Mnon$Mntest$Mnend$Mnsimple = new ModuleMethod(localtesting, 66, Lit77, 4097);
    test$Mnresult$Mnset$Ex = new ModuleMethod(localtesting, 67, Lit78, 12291);
    test$Mnresult$Mnclear = new ModuleMethod(localtesting, 68, Lit79, 4097);
    test$Mnresult$Mnremove = new ModuleMethod(localtesting, 69, Lit80, 8194);
    test$Mnresult$Mnkind = new ModuleMethod(localtesting, 70, Lit81, -4096);
    test$Mnpassed$Qu = new ModuleMethod(localtesting, 71, Lit82, -4096);
    $Prvt$$Pctest$Mnreport$Mnresult = new ModuleMethod(localtesting, 72, Lit83, 0);
    $Prvt$$Pctest$Mnevaluate$Mnwith$Mncatch = Macro.make(Lit84, Lit85, $instance);
    $Prvt$$Pctest$Mnon$Mntest$Mnbegin = new ModuleMethod(localtesting, 73, Lit86, 4097);
    $Prvt$$Pctest$Mnon$Mntest$Mnend = new ModuleMethod(localtesting, 74, Lit87, 8194);
    test$Mnrunner$Mntest$Mnname = new ModuleMethod(localtesting, 75, Lit88, 4097);
    $Prvt$$Pctest$Mncomp2body = Macro.make(Lit89, Lit90, $instance);
    $Prvt$$Pctest$Mnapproximimate$Eq = new ModuleMethod(localtesting, 76, Lit91, 4097);
    $Prvt$$Pctest$Mncomp1body = Macro.make(Lit92, Lit93, $instance);
    SimpleSymbol localSimpleSymbol50 = Lit94;
    ModuleMethod localModuleMethod4 = new ModuleMethod(localtesting, 77, null, 4097);
    localModuleMethod4.setProperty("source-location", "testing.scm:660");
    test$Mnend = Macro.make(localSimpleSymbol50, localModuleMethod4, $instance);
    SimpleSymbol localSimpleSymbol51 = Lit99;
    ModuleMethod localModuleMethod5 = new ModuleMethod(localtesting, 78, null, 4097);
    localModuleMethod5.setProperty("source-location", "testing.scm:669");
    test$Mnassert = Macro.make(localSimpleSymbol51, localModuleMethod5, $instance);
    SimpleSymbol localSimpleSymbol52 = Lit104;
    ModuleMethod localModuleMethod6 = new ModuleMethod(localtesting, 79, null, 4097);
    localModuleMethod6.setProperty("source-location", "testing.scm:696");
    test$Mneqv = Macro.make(localSimpleSymbol52, localModuleMethod6, $instance);
    SimpleSymbol localSimpleSymbol53 = Lit106;
    ModuleMethod localModuleMethod7 = new ModuleMethod(localtesting, 80, null, 4097);
    localModuleMethod7.setProperty("source-location", "testing.scm:698");
    test$Mneq = Macro.make(localSimpleSymbol53, localModuleMethod7, $instance);
    SimpleSymbol localSimpleSymbol54 = Lit108;
    ModuleMethod localModuleMethod8 = new ModuleMethod(localtesting, 81, null, 4097);
    localModuleMethod8.setProperty("source-location", "testing.scm:700");
    test$Mnequal = Macro.make(localSimpleSymbol54, localModuleMethod8, $instance);
    SimpleSymbol localSimpleSymbol55 = Lit110;
    ModuleMethod localModuleMethod9 = new ModuleMethod(localtesting, 82, null, 4097);
    localModuleMethod9.setProperty("source-location", "testing.scm:702");
    test$Mnapproximate = Macro.make(localSimpleSymbol55, localModuleMethod9, $instance);
    $Prvt$$Pctest$Mnerror = Macro.make(Lit115, Lit116, $instance);
    SimpleSymbol localSimpleSymbol56 = Lit117;
    ModuleMethod localModuleMethod10 = new ModuleMethod(localtesting, 83, null, 4097);
    localModuleMethod10.setProperty("source-location", "testing.scm:843");
    test$Mnerror = Macro.make(localSimpleSymbol56, localModuleMethod10, $instance);
    test$Mnapply = new ModuleMethod(localtesting, 84, Lit124, -4095);
    test$Mnwith$Mnrunner = Macro.make(Lit125, Lit126, $instance);
    $Prvt$$Pctest$Mnmatch$Mnnth = new ModuleMethod(localtesting, 85, Lit127, 8194);
    test$Mnmatch$Mnnth = Macro.make(Lit128, Lit129, $instance);
    $Prvt$$Pctest$Mnmatch$Mnall = new ModuleMethod(localtesting, 86, Lit130, -4096);
    test$Mnmatch$Mnall = Macro.make(Lit131, Lit132, $instance);
    $Prvt$$Pctest$Mnmatch$Mnany = new ModuleMethod(localtesting, 87, Lit133, -4096);
    test$Mnmatch$Mnany = Macro.make(Lit134, Lit135, $instance);
    $Prvt$$Pctest$Mnas$Mnspecifier = new ModuleMethod(localtesting, 88, Lit136, 4097);
    test$Mnskip = Macro.make(Lit137, Lit138, $instance);
    test$Mnexpect$Mnfail = Macro.make(Lit139, Lit140, $instance);
    test$Mnmatch$Mnname = new ModuleMethod(localtesting, 89, Lit141, 4097);
    test$Mnread$Mneval$Mnstring = new ModuleMethod(localtesting, 90, Lit142, 4097);
    $instance.run();
  }

  public testing()
  {
    ModuleInfo.register(this);
  }

  public static Object isTestPassed$V(Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    Object localObject1;
    if (lists.isPair(localLList))
      localObject1 = lists.car.apply1(localLList);
    while (true)
    {
      SimpleSymbol localSimpleSymbol = Lit1;
      try
      {
        test.Mnrunner localMnrunner = (test.Mnrunner)localObject1;
        Object localObject2 = lists.assq(localSimpleSymbol, testResultAlist(localMnrunner));
        if (localObject2 != Boolean.FALSE);
        for (Object localObject3 = lists.cdr.apply1(localObject2); ; localObject3 = Boolean.FALSE)
        {
          return lists.memq(localObject3, Lit11);
          localObject1 = testRunnerGet();
          break;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "test-result-alist", 0, localObject1);
      }
    }
  }

  public static boolean isTestRunner(Object paramObject)
  {
    return paramObject instanceof test.Mnrunner;
  }

  static Boolean lambda1(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return Boolean.FALSE;
  }

  static Object lambda16(Object paramObject)
  {
    Pair localPair = LList.list2(paramObject, LList.list2(Lit15, $PcTestSourceLine2(paramObject)));
    Object[] arrayOfObject = SyntaxPattern.allocVars(3, null);
    if (Lit95.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit96.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit97.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit98.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", localPair);
  }

  static Object lambda17(Object paramObject)
  {
    Pair localPair = LList.list2(paramObject, LList.list2(Lit15, $PcTestSourceLine2(paramObject)));
    Object[] arrayOfObject = SyntaxPattern.allocVars(4, null);
    if (Lit100.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit101.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit102.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit103.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", localPair);
  }

  static Object lambda18(Object paramObject)
  {
    TemplateScope localTemplateScope = TemplateScope.make();
    return $PcTestComp2(Lit105.execute(null, localTemplateScope), paramObject);
  }

  static Object lambda19(Object paramObject)
  {
    TemplateScope localTemplateScope = TemplateScope.make();
    return $PcTestComp2(Lit107.execute(null, localTemplateScope), paramObject);
  }

  static Boolean lambda2(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return Boolean.FALSE;
  }

  static Object lambda20(Object paramObject)
  {
    TemplateScope localTemplateScope = TemplateScope.make();
    return $PcTestComp2(Lit109.execute(null, localTemplateScope), paramObject);
  }

  static Object lambda21(Object paramObject)
  {
    Pair localPair = LList.list2(paramObject, LList.list2(Lit15, $PcTestSourceLine2(paramObject)));
    Object[] arrayOfObject = SyntaxPattern.allocVars(6, null);
    if (Lit111.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit112.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit113.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit114.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", localPair);
  }

  static Object lambda22(Object paramObject)
  {
    Pair localPair = LList.list2(paramObject, LList.list2(Lit15, $PcTestSourceLine2(paramObject)));
    Object[] arrayOfObject = SyntaxPattern.allocVars(5, null);
    if (Lit118.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope3 = TemplateScope.make();
      return Lit119.execute(arrayOfObject, localTemplateScope3);
    }
    if (Lit120.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope2 = TemplateScope.make();
      return Lit121.execute(arrayOfObject, localTemplateScope2);
    }
    if (Lit122.match(localPair, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      return Lit123.execute(arrayOfObject, localTemplateScope1);
    }
    return syntax_case.error("syntax-case", localPair);
  }

  static Boolean lambda3(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return Boolean.FALSE;
  }

  // ERROR //
  public static Object testApply$V(Object paramObject, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: new 1906	gnu/kawa/slib/testing$frame1
    //   3: dup
    //   4: invokespecial 1907	gnu/kawa/slib/testing$frame1:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: putfield 1910	gnu/kawa/slib/testing$frame1:first	Ljava/lang/Object;
    //   13: aload_2
    //   14: aload_1
    //   15: iconst_0
    //   16: invokestatic 677	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   19: putfield 1913	gnu/kawa/slib/testing$frame1:rest	Lgnu/lists/LList;
    //   22: aload_2
    //   23: getfield 1910	gnu/kawa/slib/testing$frame1:first	Ljava/lang/Object;
    //   26: invokestatic 1915	gnu/kawa/slib/testing:isTestRunner	(Ljava/lang/Object;)Z
    //   29: ifeq +32 -> 61
    //   32: aload_2
    //   33: getstatic 364	gnu/kawa/slib/testing:test$Mnrunner$Mncurrent	Ljava/lang/Object;
    //   36: checkcast 298	gnu/mapping/Procedure
    //   39: invokevirtual 368	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   42: putfield 1918	gnu/kawa/slib/testing$frame1:saved$Mnrunner$1	Ljava/lang/Object;
    //   45: aload_2
    //   46: getfield 1921	gnu/kawa/slib/testing$frame1:lambda$Fn5	Lgnu/expr/ModuleMethod;
    //   49: aload_2
    //   50: getfield 1924	gnu/kawa/slib/testing$frame1:lambda$Fn6	Lgnu/expr/ModuleMethod;
    //   53: aload_2
    //   54: getfield 1927	gnu/kawa/slib/testing$frame1:lambda$Fn7	Lgnu/expr/ModuleMethod;
    //   57: invokestatic 1930	kawa/lib/misc:dynamicWind	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   60: areturn
    //   61: getstatic 364	gnu/kawa/slib/testing:test$Mnrunner$Mncurrent	Ljava/lang/Object;
    //   64: checkcast 298	gnu/mapping/Procedure
    //   67: invokevirtual 368	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   70: astore_3
    //   71: aload_3
    //   72: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   75: if_acmpeq +135 -> 210
    //   78: aload_3
    //   79: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   82: astore 10
    //   84: aload 10
    //   86: invokestatic 820	gnu/kawa/slib/testing:$PcTestRunnerRunList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   89: astore 11
    //   91: aload_2
    //   92: getfield 1913	gnu/kawa/slib/testing$frame1:rest	Lgnu/lists/LList;
    //   95: invokestatic 292	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   98: ifeq +37 -> 135
    //   101: aload_3
    //   102: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   105: astore 19
    //   107: aload 11
    //   109: checkcast 463	gnu/lists/LList
    //   112: astore 21
    //   114: aload 19
    //   116: aload 21
    //   118: invokestatic 1934	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   121: invokestatic 1936	gnu/kawa/slib/testing:$PcTestRunnerRunList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   124: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   127: aload_2
    //   128: getfield 1910	gnu/kawa/slib/testing$frame1:first	Ljava/lang/Object;
    //   131: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: areturn
    //   135: aload_3
    //   136: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   139: astore 13
    //   141: aload 11
    //   143: getstatic 308	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   146: if_acmpne +50 -> 196
    //   149: aload_2
    //   150: getfield 1910	gnu/kawa/slib/testing$frame1:first	Ljava/lang/Object;
    //   153: invokestatic 837	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   156: astore 14
    //   158: aload 13
    //   160: aload 14
    //   162: invokestatic 1936	gnu/kawa/slib/testing:$PcTestRunnerRunList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   165: getstatic 1939	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   168: getstatic 1849	gnu/kawa/slib/testing:test$Mnapply	Lgnu/expr/ModuleMethod;
    //   171: aload_2
    //   172: getfield 1913	gnu/kawa/slib/testing$frame1:rest	Lgnu/lists/LList;
    //   175: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   178: pop
    //   179: aload_3
    //   180: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   183: astore 17
    //   185: aload 17
    //   187: aload 11
    //   189: invokestatic 1936	gnu/kawa/slib/testing:$PcTestRunnerRunList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   192: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   195: areturn
    //   196: aload_2
    //   197: getfield 1910	gnu/kawa/slib/testing$frame1:first	Ljava/lang/Object;
    //   200: aload 11
    //   202: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   205: astore 14
    //   207: goto -49 -> 158
    //   210: aload_2
    //   211: invokestatic 371	gnu/kawa/slib/testing:testRunnerCreate	()Ljava/lang/Object;
    //   214: putfield 1941	gnu/kawa/slib/testing$frame1:r	Ljava/lang/Object;
    //   217: aload_2
    //   218: getstatic 364	gnu/kawa/slib/testing:test$Mnrunner$Mncurrent	Ljava/lang/Object;
    //   221: checkcast 298	gnu/mapping/Procedure
    //   224: invokevirtual 368	gnu/mapping/Procedure:apply0	()Ljava/lang/Object;
    //   227: putfield 1944	gnu/kawa/slib/testing$frame1:saved$Mnrunner	Ljava/lang/Object;
    //   230: aload_2
    //   231: getfield 1947	gnu/kawa/slib/testing$frame1:lambda$Fn8	Lgnu/expr/ModuleMethod;
    //   234: aload_2
    //   235: getfield 1950	gnu/kawa/slib/testing$frame1:lambda$Fn9	Lgnu/expr/ModuleMethod;
    //   238: aload_2
    //   239: getfield 1953	gnu/kawa/slib/testing$frame1:lambda$Fn10	Lgnu/expr/ModuleMethod;
    //   242: invokestatic 1930	kawa/lib/misc:dynamicWind	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: getstatic 377	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   249: astore 5
    //   251: aload_2
    //   252: getfield 1941	gnu/kawa/slib/testing$frame1:r	Ljava/lang/Object;
    //   255: astore 6
    //   257: aload 6
    //   259: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   262: astore 8
    //   264: aload 5
    //   266: aload 8
    //   268: invokestatic 568	gnu/kawa/slib/testing:testRunnerOnFinal	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   271: aload_2
    //   272: getfield 1941	gnu/kawa/slib/testing$frame1:r	Ljava/lang/Object;
    //   275: invokevirtual 549	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   278: areturn
    //   279: astore 9
    //   281: new 427	gnu/mapping/WrongType
    //   284: dup
    //   285: aload 9
    //   287: ldc_w 824
    //   290: iconst_0
    //   291: aload_3
    //   292: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    //   296: astore 18
    //   298: new 427	gnu/mapping/WrongType
    //   301: dup
    //   302: aload 18
    //   304: ldc_w 1955
    //   307: iconst_0
    //   308: aload_3
    //   309: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   312: athrow
    //   313: astore 20
    //   315: new 427	gnu/mapping/WrongType
    //   318: dup
    //   319: aload 20
    //   321: ldc_w 1957
    //   324: iconst_1
    //   325: aload 11
    //   327: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   330: athrow
    //   331: astore 12
    //   333: new 427	gnu/mapping/WrongType
    //   336: dup
    //   337: aload 12
    //   339: ldc_w 1955
    //   342: iconst_0
    //   343: aload_3
    //   344: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   347: athrow
    //   348: astore 16
    //   350: new 427	gnu/mapping/WrongType
    //   353: dup
    //   354: aload 16
    //   356: ldc_w 1955
    //   359: iconst_0
    //   360: aload_3
    //   361: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   364: athrow
    //   365: astore 7
    //   367: new 427	gnu/mapping/WrongType
    //   370: dup
    //   371: aload 7
    //   373: ldc_w 588
    //   376: iconst_0
    //   377: aload 6
    //   379: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   382: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   78	84	279	java/lang/ClassCastException
    //   101	107	296	java/lang/ClassCastException
    //   107	114	313	java/lang/ClassCastException
    //   135	141	331	java/lang/ClassCastException
    //   179	185	348	java/lang/ClassCastException
    //   257	264	365	java/lang/ClassCastException
  }

  public static Procedure testMatchName(Object paramObject)
  {
    frame5 localframe5 = new frame5();
    localframe5.name = paramObject;
    return localframe5.lambda$Fn14;
  }

  public static void testOnBadCountSimple(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    $PcTestOnBadCountWrite(paramObject1, paramObject2, paramObject3, ports.current$Mnoutput$Mnport.apply0());
    try
    {
      test.Mnrunner localMnrunner = (test.Mnrunner)paramObject1;
      Object localObject = testRunnerAuxValue(localMnrunner);
      if (ports.isOutputPort(localObject))
        $PcTestOnBadCountWrite(paramObject1, paramObject2, paramObject3, localObject);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "test-runner-aux-value", 0, paramObject1);
    }
  }

  public static Object testOnBadEndNameSimple(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = $PcTestFormatLine(paramObject1);
    arrayOfObject[1] = "test-end ";
    arrayOfObject[2] = paramObject2;
    arrayOfObject[3] = " does not match test-begin ";
    arrayOfObject[4] = paramObject3;
    return misc.error$V(strings.stringAppend(arrayOfObject), new Object[0]);
  }

  public static void testOnFinalSimple(Object paramObject)
  {
    $PcTestFinalReportSimple(paramObject, ports.current$Mnoutput$Mnport.apply0());
    try
    {
      test.Mnrunner localMnrunner = (test.Mnrunner)paramObject;
      Object localObject = testRunnerAuxValue(localMnrunner);
      if (ports.isOutputPort(localObject))
        $PcTestFinalReportSimple(paramObject, localObject);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "test-runner-aux-value", 0, paramObject);
    }
  }

  // ERROR //
  public static Boolean testOnGroupBeginSimple(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore 4
    //   6: aload 4
    //   8: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   11: invokestatic 292	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   14: ifeq +93 -> 107
    //   17: ldc_w 1989
    //   20: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   23: aload_1
    //   24: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   27: getstatic 308	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   30: invokestatic 347	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   33: ifeq +118 -> 151
    //   36: getstatic 308	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   39: astore 8
    //   41: aload 8
    //   43: invokestatic 1997	gnu/text/Path:valueOf	(Ljava/lang/Object;)Lgnu/text/Path;
    //   46: astore 10
    //   48: aload 10
    //   50: invokestatic 2001	kawa/lib/ports:openOutputFile	(Lgnu/text/Path;)Lgnu/mapping/OutPort;
    //   53: astore 11
    //   55: ldc_w 1989
    //   58: aload 11
    //   60: invokestatic 600	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   63: aload_1
    //   64: aload 11
    //   66: invokestatic 600	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   69: aload 11
    //   71: invokestatic 604	kawa/lib/ports:newline	(Ljava/lang/Object;)V
    //   74: aload_0
    //   75: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   78: astore 13
    //   80: aload 13
    //   82: aload 11
    //   84: invokestatic 2004	gnu/kawa/slib/testing:testRunnerAuxValue$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   87: ldc_w 2006
    //   90: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   93: aload 8
    //   95: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   98: ldc_w 2008
    //   101: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   104: invokestatic 2010	kawa/lib/ports:newline	()V
    //   107: aload_0
    //   108: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   111: astore 6
    //   113: aload 6
    //   115: invokestatic 1975	gnu/kawa/slib/testing:testRunnerAuxValue	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   118: astore 7
    //   120: aload 7
    //   122: invokestatic 1978	kawa/lib/ports:isOutputPort	(Ljava/lang/Object;)Z
    //   125: ifeq +22 -> 147
    //   128: ldc_w 2012
    //   131: aload 7
    //   133: invokestatic 600	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   136: aload_1
    //   137: aload 7
    //   139: invokestatic 600	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   142: aload 7
    //   144: invokestatic 604	kawa/lib/ports:newline	(Ljava/lang/Object;)V
    //   147: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   150: areturn
    //   151: iconst_2
    //   152: anewarray 354	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_1
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: ldc_w 2014
    //   164: aastore
    //   165: invokestatic 525	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   168: astore 8
    //   170: goto -129 -> 41
    //   173: astore_3
    //   174: new 427	gnu/mapping/WrongType
    //   177: dup
    //   178: aload_3
    //   179: ldc_w 454
    //   182: iconst_0
    //   183: aload_0
    //   184: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   187: athrow
    //   188: astore 9
    //   190: new 427	gnu/mapping/WrongType
    //   193: dup
    //   194: aload 9
    //   196: ldc_w 2016
    //   199: iconst_1
    //   200: aload 8
    //   202: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   205: athrow
    //   206: astore 12
    //   208: new 427	gnu/mapping/WrongType
    //   211: dup
    //   212: aload 12
    //   214: ldc_w 1525
    //   217: iconst_0
    //   218: aload_0
    //   219: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   222: athrow
    //   223: astore 5
    //   225: new 427	gnu/mapping/WrongType
    //   228: dup
    //   229: aload 5
    //   231: ldc_w 1529
    //   234: iconst_0
    //   235: aload_0
    //   236: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   239: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	173	java/lang/ClassCastException
    //   41	48	188	java/lang/ClassCastException
    //   74	80	206	java/lang/ClassCastException
    //   107	113	223	java/lang/ClassCastException
  }

  // ERROR //
  public static Boolean testOnGroupEndSimple(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 1975	gnu/kawa/slib/testing:testRunnerAuxValue	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_3
    //   11: invokestatic 1978	kawa/lib/ports:isOutputPort	(Ljava/lang/Object;)Z
    //   14: ifeq +39 -> 53
    //   17: ldc_w 2019
    //   20: aload_3
    //   21: invokestatic 600	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   24: getstatic 296	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   27: astore 4
    //   29: aload_0
    //   30: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   33: astore 6
    //   35: aload 4
    //   37: aload 6
    //   39: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   42: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: aload_3
    //   46: invokestatic 600	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   49: aload_3
    //   50: invokestatic 604	kawa/lib/ports:newline	(Ljava/lang/Object;)V
    //   53: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   56: areturn
    //   57: astore_1
    //   58: new 427	gnu/mapping/WrongType
    //   61: dup
    //   62: aload_1
    //   63: ldc_w 1529
    //   66: iconst_0
    //   67: aload_0
    //   68: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   71: athrow
    //   72: astore 5
    //   74: new 427	gnu/mapping/WrongType
    //   77: dup
    //   78: aload 5
    //   80: ldc_w 454
    //   83: iconst_0
    //   84: aload_0
    //   85: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	57	java/lang/ClassCastException
    //   29	35	72	java/lang/ClassCastException
  }

  // ERROR //
  static Object testOnTestBeginSimple(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 1975	gnu/kawa/slib/testing:testRunnerAuxValue	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_3
    //   11: invokestatic 1978	kawa/lib/ports:isOutputPort	(Ljava/lang/Object;)Z
    //   14: ifeq +131 -> 145
    //   17: aload_0
    //   18: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   21: astore 5
    //   23: aload 5
    //   25: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   28: astore 6
    //   30: getstatic 647	gnu/kawa/slib/testing:Lit4	Lgnu/mapping/SimpleSymbol;
    //   33: aload 6
    //   35: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   38: astore 7
    //   40: getstatic 652	gnu/kawa/slib/testing:Lit5	Lgnu/mapping/SimpleSymbol;
    //   43: aload 6
    //   45: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   48: astore 8
    //   50: getstatic 839	gnu/kawa/slib/testing:Lit6	Lgnu/mapping/SimpleSymbol;
    //   53: aload 6
    //   55: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: astore 9
    //   60: getstatic 1142	gnu/kawa/slib/testing:Lit7	Lgnu/mapping/SimpleSymbol;
    //   63: aload 6
    //   65: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   68: astore 10
    //   70: ldc_w 2022
    //   73: aload_3
    //   74: invokestatic 600	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   77: aload_3
    //   78: invokestatic 604	kawa/lib/ports:newline	(Ljava/lang/Object;)V
    //   81: aload 10
    //   83: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   86: if_acmpeq +10 -> 96
    //   89: aload 10
    //   91: aload_3
    //   92: invokestatic 2024	gnu/kawa/slib/testing:$PcTestWriteResult1	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: aload 7
    //   98: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   101: if_acmpeq +10 -> 111
    //   104: aload 7
    //   106: aload_3
    //   107: invokestatic 2024	gnu/kawa/slib/testing:$PcTestWriteResult1	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: aload 8
    //   113: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   116: if_acmpeq +10 -> 126
    //   119: aload 8
    //   121: aload_3
    //   122: invokestatic 2024	gnu/kawa/slib/testing:$PcTestWriteResult1	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   125: pop
    //   126: aload 7
    //   128: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   131: if_acmpeq +10 -> 141
    //   134: aload 9
    //   136: aload_3
    //   137: invokestatic 2024	gnu/kawa/slib/testing:$PcTestWriteResult1	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: areturn
    //   141: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   144: areturn
    //   145: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   148: areturn
    //   149: astore_1
    //   150: new 427	gnu/mapping/WrongType
    //   153: dup
    //   154: aload_1
    //   155: ldc_w 1529
    //   158: iconst_0
    //   159: aload_0
    //   160: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   163: athrow
    //   164: astore 4
    //   166: new 427	gnu/mapping/WrongType
    //   169: dup
    //   170: aload 4
    //   172: ldc_w 666
    //   175: iconst_0
    //   176: aload_0
    //   177: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   180: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	149	java/lang/ClassCastException
    //   17	23	164	java/lang/ClassCastException
  }

  // ERROR //
  public static Object testOnTestEndSimple(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 1975	gnu/kawa/slib/testing:testRunnerAuxValue	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   9: astore_3
    //   10: getstatic 730	gnu/kawa/slib/testing:Lit1	Lgnu/mapping/SimpleSymbol;
    //   13: astore 4
    //   15: aload_0
    //   16: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   19: astore 6
    //   21: aload 4
    //   23: aload 6
    //   25: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   28: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: astore 7
    //   33: aload 7
    //   35: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   38: if_acmpeq +271 -> 309
    //   41: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   44: aload 7
    //   46: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore 8
    //   51: aload 8
    //   53: getstatic 1641	gnu/kawa/slib/testing:Lit8	Lgnu/lists/PairWithPosition;
    //   56: invokestatic 1889	kawa/lib/lists:memq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   62: if_acmpeq +158 -> 220
    //   65: aload_0
    //   66: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   69: astore 15
    //   71: aload 15
    //   73: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   76: astore 16
    //   78: getstatic 647	gnu/kawa/slib/testing:Lit4	Lgnu/mapping/SimpleSymbol;
    //   81: aload 16
    //   83: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: astore 17
    //   88: getstatic 652	gnu/kawa/slib/testing:Lit5	Lgnu/mapping/SimpleSymbol;
    //   91: aload 16
    //   93: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   96: astore 18
    //   98: getstatic 1142	gnu/kawa/slib/testing:Lit7	Lgnu/mapping/SimpleSymbol;
    //   101: aload 16
    //   103: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: astore 19
    //   108: aload 17
    //   110: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   113: if_acmpne +11 -> 124
    //   116: aload 18
    //   118: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   121: if_acmpeq +53 -> 174
    //   124: aload 17
    //   126: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   129: if_acmpeq +14 -> 143
    //   132: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   135: aload 17
    //   137: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   143: ldc_w 654
    //   146: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   149: aload 18
    //   151: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   154: if_acmpeq +14 -> 168
    //   157: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   160: aload 18
    //   162: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   168: ldc_w 662
    //   171: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   174: aload 8
    //   176: getstatic 737	gnu/kawa/slib/testing:Lit9	Lgnu/mapping/SimpleSymbol;
    //   179: if_acmpne +138 -> 317
    //   182: ldc_w 2027
    //   185: astore 20
    //   187: aload 20
    //   189: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   192: aload 19
    //   194: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   197: if_acmpeq +20 -> 217
    //   200: ldc_w 2029
    //   203: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   206: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   209: aload 19
    //   211: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   214: invokestatic 1991	kawa/lib/ports:display	(Ljava/lang/Object;)V
    //   217: invokestatic 2010	kawa/lib/ports:newline	()V
    //   220: aload_3
    //   221: invokestatic 1978	kawa/lib/ports:isOutputPort	(Ljava/lang/Object;)Z
    //   224: ifeq +105 -> 329
    //   227: ldc_w 2031
    //   230: aload_3
    //   231: invokestatic 600	kawa/lib/ports:display	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   234: aload_3
    //   235: invokestatic 604	kawa/lib/ports:newline	(Ljava/lang/Object;)V
    //   238: aload_0
    //   239: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   242: astore 10
    //   244: aload 10
    //   246: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   249: astore 11
    //   251: aload 11
    //   253: invokestatic 1886	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   256: ifeq +69 -> 325
    //   259: getstatic 296	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   262: aload 11
    //   264: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   267: astore 12
    //   269: getstatic 296	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   272: aload 12
    //   274: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   277: getstatic 1637	gnu/kawa/slib/testing:Lit10	Lgnu/lists/PairWithPosition;
    //   280: invokestatic 1889	kawa/lib/lists:memq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   286: if_acmpne +10 -> 296
    //   289: aload 12
    //   291: aload_3
    //   292: invokestatic 2024	gnu/kawa/slib/testing:$PcTestWriteResult1	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   295: pop
    //   296: getstatic 311	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   299: aload 11
    //   301: invokevirtual 302	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   304: astore 11
    //   306: goto -55 -> 251
    //   309: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   312: astore 8
    //   314: goto -263 -> 51
    //   317: ldc_w 2033
    //   320: astore 20
    //   322: goto -135 -> 187
    //   325: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   328: areturn
    //   329: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   332: areturn
    //   333: astore_1
    //   334: new 427	gnu/mapping/WrongType
    //   337: dup
    //   338: aload_1
    //   339: ldc_w 1529
    //   342: iconst_0
    //   343: aload_0
    //   344: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   347: athrow
    //   348: astore 5
    //   350: new 427	gnu/mapping/WrongType
    //   353: dup
    //   354: aload 5
    //   356: ldc_w 666
    //   359: iconst_0
    //   360: aload_0
    //   361: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   364: athrow
    //   365: astore 14
    //   367: new 427	gnu/mapping/WrongType
    //   370: dup
    //   371: aload 14
    //   373: ldc_w 666
    //   376: iconst_0
    //   377: aload_0
    //   378: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   381: athrow
    //   382: astore 9
    //   384: new 427	gnu/mapping/WrongType
    //   387: dup
    //   388: aload 9
    //   390: ldc_w 666
    //   393: iconst_0
    //   394: aload_0
    //   395: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   398: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	333	java/lang/ClassCastException
    //   15	21	348	java/lang/ClassCastException
    //   65	71	365	java/lang/ClassCastException
    //   238	244	382	java/lang/ClassCastException
  }

  public static Object testReadEvalString(Object paramObject)
  {
    try
    {
      CharSequence localCharSequence = (CharSequence)paramObject;
      InPort localInPort = ports.openInputString(localCharSequence);
      Object localObject = ports.read(localInPort);
      if (ports.isEofObject(readchar.readChar.apply1(localInPort)))
        return Eval.eval.apply1(localObject);
      return misc.error$V("(not at eof)", new Object[0]);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "open-input-string", 1, paramObject);
    }
  }

  public static Object testResultAlist(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.result$Mnalist;
  }

  public static void testResultAlist$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.result$Mnalist = paramObject;
  }

  public static void testResultClear(Object paramObject)
  {
    try
    {
      test.Mnrunner localMnrunner = (test.Mnrunner)paramObject;
      testResultAlist$Ex(localMnrunner, LList.Empty);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "test-result-alist!", 0, paramObject);
    }
  }

  public static Object testResultKind$V(Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    Object localObject1;
    if (lists.isPair(localLList))
      localObject1 = lists.car.apply1(localLList);
    while (true)
    {
      SimpleSymbol localSimpleSymbol = Lit1;
      try
      {
        test.Mnrunner localMnrunner = (test.Mnrunner)localObject1;
        Object localObject2 = lists.assq(localSimpleSymbol, testResultAlist(localMnrunner));
        if (localObject2 != Boolean.FALSE)
        {
          return lists.cdr.apply1(localObject2);
          localObject1 = ((Procedure)test$Mnrunner$Mncurrent).apply0();
          continue;
        }
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "test-result-alist", 0, localObject1);
      }
    }
  }

  // ERROR //
  public static void testResultRemove(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: new 2070	gnu/kawa/slib/testing$frame
    //   3: dup
    //   4: invokespecial 2071	gnu/kawa/slib/testing$frame:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   12: astore 4
    //   14: aload 4
    //   16: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   19: astore 5
    //   21: aload_2
    //   22: aload_1
    //   23: aload 5
    //   25: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: putfield 2073	gnu/kawa/slib/testing$frame:p	Ljava/lang/Object;
    //   31: aload_2
    //   32: getfield 2073	gnu/kawa/slib/testing$frame:p	Ljava/lang/Object;
    //   35: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   38: if_acmpeq +20 -> 58
    //   41: aload_0
    //   42: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   45: astore 7
    //   47: aload 7
    //   49: aload_2
    //   50: aload 5
    //   52: invokevirtual 2076	gnu/kawa/slib/testing$frame:lambda4loop	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: invokestatic 519	gnu/kawa/slib/testing:testResultAlist$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   58: return
    //   59: astore_3
    //   60: new 427	gnu/mapping/WrongType
    //   63: dup
    //   64: aload_3
    //   65: ldc_w 666
    //   68: iconst_0
    //   69: aload_0
    //   70: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: astore 6
    //   76: new 427	gnu/mapping/WrongType
    //   79: dup
    //   80: aload 6
    //   82: ldc_w 576
    //   85: iconst_0
    //   86: aload_0
    //   87: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   90: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   8	14	59	java/lang/ClassCastException
    //   41	47	74	java/lang/ClassCastException
  }

  // ERROR //
  public static Object testResultSet$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore 4
    //   6: aload 4
    //   8: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   11: astore 5
    //   13: aload_1
    //   14: aload 5
    //   16: invokestatic 650	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   19: astore 6
    //   21: aload 6
    //   23: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   26: if_acmpeq +20 -> 46
    //   29: aload 6
    //   31: checkcast 1214	gnu/lists/Pair
    //   34: astore 10
    //   36: aload 10
    //   38: aload_2
    //   39: invokestatic 2080	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   42: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   45: areturn
    //   46: aload_0
    //   47: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   50: astore 8
    //   52: aload 8
    //   54: aload_1
    //   55: aload_2
    //   56: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   59: aload 5
    //   61: invokestatic 397	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   64: invokestatic 519	gnu/kawa/slib/testing:testResultAlist$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   67: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   70: areturn
    //   71: astore_3
    //   72: new 427	gnu/mapping/WrongType
    //   75: dup
    //   76: aload_3
    //   77: ldc_w 666
    //   80: iconst_0
    //   81: aload_0
    //   82: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   85: athrow
    //   86: astore 9
    //   88: new 427	gnu/mapping/WrongType
    //   91: dup
    //   92: aload 9
    //   94: ldc_w 2082
    //   97: iconst_1
    //   98: aload 6
    //   100: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   103: athrow
    //   104: astore 7
    //   106: new 427	gnu/mapping/WrongType
    //   109: dup
    //   110: aload 7
    //   112: ldc_w 576
    //   115: iconst_0
    //   116: aload_0
    //   117: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   120: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	71	java/lang/ClassCastException
    //   29	36	86	java/lang/ClassCastException
    //   46	52	104	java/lang/ClassCastException
  }

  public static Object testRunnerAuxValue(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.aux$Mnvalue;
  }

  public static void testRunnerAuxValue$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.aux$Mnvalue = paramObject;
  }

  public static Object testRunnerCreate()
  {
    return Scheme.applyToArgs.apply1(((Procedure)test$Mnrunner$Mnfactory).apply0());
  }

  public static Object testRunnerFailCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.fail$Mncount;
  }

  public static void testRunnerFailCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.fail$Mncount = paramObject;
  }

  public static Object testRunnerGet()
  {
    Object localObject = ((Procedure)test$Mnrunner$Mncurrent).apply0();
    if (localObject == Boolean.FALSE)
      misc.error$V("test-runner not initialized - test-begin missing?", new Object[0]);
    return localObject;
  }

  // ERROR //
  public static LList testRunnerGroupPath(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_3
    //   11: checkcast 463	gnu/lists/LList
    //   14: astore 5
    //   16: aload 5
    //   18: invokestatic 2097	kawa/lib/lists:reverse	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   21: areturn
    //   22: astore_1
    //   23: new 427	gnu/mapping/WrongType
    //   26: dup
    //   27: aload_1
    //   28: ldc_w 454
    //   31: iconst_0
    //   32: aload_0
    //   33: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   36: athrow
    //   37: astore 4
    //   39: new 427	gnu/mapping/WrongType
    //   42: dup
    //   43: aload 4
    //   45: ldc_w 2098
    //   48: iconst_1
    //   49: aload_3
    //   50: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   53: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	22	java/lang/ClassCastException
    //   10	16	37	java/lang/ClassCastException
  }

  public static Object testRunnerGroupStack(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.group$Mnstack;
  }

  public static void testRunnerGroupStack$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.group$Mnstack = paramObject;
  }

  public static test.Mnrunner testRunnerNull()
  {
    test.Mnrunner localMnrunner = $PcTestRunnerAlloc();
    testRunnerReset(localMnrunner);
    testRunnerOnGroupBegin$Ex(localMnrunner, lambda$Fn1);
    testRunnerOnGroupEnd$Ex(localMnrunner, $Pctest$Mnnull$Mncallback);
    testRunnerOnFinal$Ex(localMnrunner, $Pctest$Mnnull$Mncallback);
    testRunnerOnTestBegin$Ex(localMnrunner, $Pctest$Mnnull$Mncallback);
    testRunnerOnTestEnd$Ex(localMnrunner, $Pctest$Mnnull$Mncallback);
    testRunnerOnBadCount$Ex(localMnrunner, lambda$Fn2);
    testRunnerOnBadEndName$Ex(localMnrunner, lambda$Fn3);
    return localMnrunner;
  }

  public static Object testRunnerOnBadCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mnbad$Mncount;
  }

  public static void testRunnerOnBadCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mnbad$Mncount = paramObject;
  }

  public static Object testRunnerOnBadEndName(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mnbad$Mnend$Mnname;
  }

  public static void testRunnerOnBadEndName$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mnbad$Mnend$Mnname = paramObject;
  }

  public static Object testRunnerOnFinal(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mnfinal;
  }

  public static void testRunnerOnFinal$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mnfinal = paramObject;
  }

  public static Object testRunnerOnGroupBegin(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mngroup$Mnbegin;
  }

  public static void testRunnerOnGroupBegin$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mngroup$Mnbegin = paramObject;
  }

  public static Object testRunnerOnGroupEnd(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mngroup$Mnend;
  }

  public static void testRunnerOnGroupEnd$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mngroup$Mnend = paramObject;
  }

  public static Object testRunnerOnTestBegin(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mntest$Mnbegin;
  }

  public static void testRunnerOnTestBegin$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mntest$Mnbegin = paramObject;
  }

  public static Object testRunnerOnTestEnd(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.on$Mntest$Mnend;
  }

  public static void testRunnerOnTestEnd$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.on$Mntest$Mnend = paramObject;
  }

  public static Object testRunnerPassCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.pass$Mncount;
  }

  public static void testRunnerPassCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.pass$Mncount = paramObject;
  }

  // ERROR //
  public static void testRunnerReset(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   4: astore_2
    //   5: aload_2
    //   6: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   9: invokestatic 519	gnu/kawa/slib/testing:testResultAlist$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   12: aload_0
    //   13: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   16: astore 4
    //   18: aload 4
    //   20: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   23: invokestatic 760	gnu/kawa/slib/testing:testRunnerPassCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   26: aload_0
    //   27: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   30: astore 6
    //   32: aload 6
    //   34: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   37: invokestatic 769	gnu/kawa/slib/testing:testRunnerFailCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   40: aload_0
    //   41: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   44: astore 8
    //   46: aload 8
    //   48: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   51: invokestatic 772	gnu/kawa/slib/testing:testRunnerXpassCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   54: aload_0
    //   55: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   58: astore 10
    //   60: aload 10
    //   62: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   65: invokestatic 775	gnu/kawa/slib/testing:testRunnerXfailCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   68: aload_0
    //   69: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   72: astore 12
    //   74: aload 12
    //   76: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   79: invokestatic 778	gnu/kawa/slib/testing:testRunnerSkipCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   82: aload_0
    //   83: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   86: astore 14
    //   88: aload 14
    //   90: getstatic 595	gnu/kawa/slib/testing:Lit0	Lgnu/math/IntNum;
    //   93: invokestatic 763	gnu/kawa/slib/testing:$PcTestRunnerTotalCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   96: aload_0
    //   97: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   100: astore 16
    //   102: aload 16
    //   104: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   107: invokestatic 419	gnu/kawa/slib/testing:$PcTestRunnerCountList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   110: aload_0
    //   111: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   114: astore 18
    //   116: aload 18
    //   118: getstatic 308	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   121: invokestatic 1936	gnu/kawa/slib/testing:$PcTestRunnerRunList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   124: aload_0
    //   125: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   128: astore 20
    //   130: aload 20
    //   132: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   135: invokestatic 562	gnu/kawa/slib/testing:$PcTestRunnerSkipList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   138: aload_0
    //   139: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   142: astore 22
    //   144: aload 22
    //   146: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   149: invokestatic 565	gnu/kawa/slib/testing:$PcTestRunnerFailList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   152: aload_0
    //   153: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   156: astore 24
    //   158: aload 24
    //   160: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   163: invokestatic 401	gnu/kawa/slib/testing:$PcTestRunnerSkipSave$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   166: aload_0
    //   167: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   170: astore 26
    //   172: aload 26
    //   174: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   177: invokestatic 410	gnu/kawa/slib/testing:$PcTestRunnerFailSave$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   180: aload_0
    //   181: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   184: astore 28
    //   186: aload 28
    //   188: getstatic 845	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   191: invokestatic 425	gnu/kawa/slib/testing:testRunnerGroupStack$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   194: return
    //   195: astore_1
    //   196: new 427	gnu/mapping/WrongType
    //   199: dup
    //   200: aload_1
    //   201: ldc_w 576
    //   204: iconst_0
    //   205: aload_0
    //   206: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   209: athrow
    //   210: astore_3
    //   211: new 427	gnu/mapping/WrongType
    //   214: dup
    //   215: aload_3
    //   216: ldc_w 780
    //   219: iconst_0
    //   220: aload_0
    //   221: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   224: athrow
    //   225: astore 5
    //   227: new 427	gnu/mapping/WrongType
    //   230: dup
    //   231: aload 5
    //   233: ldc_w 782
    //   236: iconst_0
    //   237: aload_0
    //   238: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   241: athrow
    //   242: astore 7
    //   244: new 427	gnu/mapping/WrongType
    //   247: dup
    //   248: aload 7
    //   250: ldc_w 784
    //   253: iconst_0
    //   254: aload_0
    //   255: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   258: athrow
    //   259: astore 9
    //   261: new 427	gnu/mapping/WrongType
    //   264: dup
    //   265: aload 9
    //   267: ldc_w 786
    //   270: iconst_0
    //   271: aload_0
    //   272: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   275: athrow
    //   276: astore 11
    //   278: new 427	gnu/mapping/WrongType
    //   281: dup
    //   282: aload 11
    //   284: ldc_w 788
    //   287: iconst_0
    //   288: aload_0
    //   289: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   292: athrow
    //   293: astore 13
    //   295: new 427	gnu/mapping/WrongType
    //   298: dup
    //   299: aload 13
    //   301: ldc_w 790
    //   304: iconst_0
    //   305: aload_0
    //   306: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   309: athrow
    //   310: astore 15
    //   312: new 427	gnu/mapping/WrongType
    //   315: dup
    //   316: aload 15
    //   318: ldc_w 446
    //   321: iconst_0
    //   322: aload_0
    //   323: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   326: athrow
    //   327: astore 17
    //   329: new 427	gnu/mapping/WrongType
    //   332: dup
    //   333: aload 17
    //   335: ldc_w 1955
    //   338: iconst_0
    //   339: aload_0
    //   340: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   343: athrow
    //   344: astore 19
    //   346: new 427	gnu/mapping/WrongType
    //   349: dup
    //   350: aload 19
    //   352: ldc_w 584
    //   355: iconst_0
    //   356: aload_0
    //   357: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   360: athrow
    //   361: astore 21
    //   363: new 427	gnu/mapping/WrongType
    //   366: dup
    //   367: aload 21
    //   369: ldc_w 586
    //   372: iconst_0
    //   373: aload_0
    //   374: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   377: athrow
    //   378: astore 23
    //   380: new 427	gnu/mapping/WrongType
    //   383: dup
    //   384: aload 23
    //   386: ldc_w 434
    //   389: iconst_0
    //   390: aload_0
    //   391: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //   395: astore 25
    //   397: new 427	gnu/mapping/WrongType
    //   400: dup
    //   401: aload 25
    //   403: ldc_w 440
    //   406: iconst_0
    //   407: aload_0
    //   408: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   411: athrow
    //   412: astore 27
    //   414: new 427	gnu/mapping/WrongType
    //   417: dup
    //   418: aload 27
    //   420: ldc_w 452
    //   423: iconst_0
    //   424: aload_0
    //   425: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   428: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	195	java/lang/ClassCastException
    //   12	18	210	java/lang/ClassCastException
    //   26	32	225	java/lang/ClassCastException
    //   40	46	242	java/lang/ClassCastException
    //   54	60	259	java/lang/ClassCastException
    //   68	74	276	java/lang/ClassCastException
    //   82	88	293	java/lang/ClassCastException
    //   96	102	310	java/lang/ClassCastException
    //   110	116	327	java/lang/ClassCastException
    //   124	130	344	java/lang/ClassCastException
    //   138	144	361	java/lang/ClassCastException
    //   152	158	378	java/lang/ClassCastException
    //   166	172	395	java/lang/ClassCastException
    //   180	186	412	java/lang/ClassCastException
  }

  public static test.Mnrunner testRunnerSimple()
  {
    test.Mnrunner localMnrunner = $PcTestRunnerAlloc();
    testRunnerReset(localMnrunner);
    testRunnerOnGroupBegin$Ex(localMnrunner, test$Mnon$Mngroup$Mnbegin$Mnsimple);
    testRunnerOnGroupEnd$Ex(localMnrunner, test$Mnon$Mngroup$Mnend$Mnsimple);
    testRunnerOnFinal$Ex(localMnrunner, test$Mnon$Mnfinal$Mnsimple);
    testRunnerOnTestBegin$Ex(localMnrunner, test$Mnon$Mntest$Mnbegin$Mnsimple);
    testRunnerOnTestEnd$Ex(localMnrunner, test$Mnon$Mntest$Mnend$Mnsimple);
    testRunnerOnBadCount$Ex(localMnrunner, test$Mnon$Mnbad$Mncount$Mnsimple);
    testRunnerOnBadEndName$Ex(localMnrunner, test$Mnon$Mnbad$Mnend$Mnname$Mnsimple);
    return localMnrunner;
  }

  public static Object testRunnerSkipCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.skip$Mncount;
  }

  public static void testRunnerSkipCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.skip$Mncount = paramObject;
  }

  public static Object testRunnerTestName(Object paramObject)
  {
    SimpleSymbol localSimpleSymbol = Lit7;
    try
    {
      test.Mnrunner localMnrunner = (test.Mnrunner)paramObject;
      Object localObject = lists.assq(localSimpleSymbol, testResultAlist(localMnrunner));
      if (localObject != Boolean.FALSE)
        return lists.cdr.apply1(localObject);
      return "";
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "test-result-alist", 0, paramObject);
    }
  }

  public static Object testRunnerXfailCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.xfail$Mncount;
  }

  public static void testRunnerXfailCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.xfail$Mncount = paramObject;
  }

  public static Object testRunnerXpassCount(test.Mnrunner paramMnrunner)
  {
    return paramMnrunner.xpass$Mncount;
  }

  public static void testRunnerXpassCount$Ex(test.Mnrunner paramMnrunner, Object paramObject)
  {
    paramMnrunner.xpass$Mncount = paramObject;
  }

  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply0(paramModuleMethod);
    case 53:
      return testRunnerNull();
    case 54:
      return testRunnerSimple();
    case 55:
      return testRunnerGet();
    case 56:
      return testRunnerCreate();
    case 72:
    }
    return $PcTestReportResult();
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 2168	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+332 -> 336, 12:+339->343, 13:+354->358, 14:+332->336, 15:+366->370, 16:+332->336, 17:+378->382, 18:+332->336, 19:+390->394, 20:+332->336, 21:+402->406, 22:+332->336, 23:+414->418, 24:+332->336, 25:+426->430, 26:+332->336, 27:+438->442, 28:+332->336, 29:+450->454, 30:+332->336, 31:+462->466, 32:+332->336, 33:+474->478, 34:+332->336, 35:+486->490, 36:+332->336, 37:+498->502, 38:+332->336, 39:+510->514, 40:+332->336, 41:+522->526, 42:+332->336, 43:+534->538, 44:+332->336, 45:+546->550, 46:+332->336, 47:+558->562, 48:+566->570, 49:+571->575, 50:+332->336, 51:+332->336, 52:+332->336, 53:+332->336, 54:+332->336, 55:+332->336, 56:+332->336, 57:+576->580, 58:+332->336, 59:+332->336, 60:+581->585, 61:+332->336, 62:+332->336, 63:+586->590, 64:+332->336, 65:+594->598, 66:+599->603, 67:+332->336, 68:+604->608, 69:+332->336, 70:+332->336, 71:+332->336, 72:+332->336, 73:+612->616, 74:+332->336, 75:+627->631, 76:+632->636, 77:+652->656, 78:+657->661, 79:+662->666, 80:+667->671, 81:+672->676, 82:+677->681, 83:+682->686, 84:+332->336, 85:+332->336, 86:+332->336, 87:+332->336, 88:+637->641, 89:+642->646, 90:+647->651
    //   337: aload_1
    //   338: aload_2
    //   339: invokespecial 2179	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   342: areturn
    //   343: aload_2
    //   344: invokestatic 1915	gnu/kawa/slib/testing:isTestRunner	(Ljava/lang/Object;)Z
    //   347: ifeq +7 -> 354
    //   350: getstatic 308	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   353: areturn
    //   354: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   357: areturn
    //   358: aload_2
    //   359: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   362: astore 36
    //   364: aload 36
    //   366: invokestatic 608	gnu/kawa/slib/testing:testRunnerPassCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   369: areturn
    //   370: aload_2
    //   371: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   374: astore 34
    //   376: aload 34
    //   378: invokestatic 625	gnu/kawa/slib/testing:testRunnerFailCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   381: areturn
    //   382: aload_2
    //   383: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   386: astore 32
    //   388: aload 32
    //   390: invokestatic 620	gnu/kawa/slib/testing:testRunnerXpassCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   393: areturn
    //   394: aload_2
    //   395: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   398: astore 30
    //   400: aload 30
    //   402: invokestatic 615	gnu/kawa/slib/testing:testRunnerXfailCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   405: areturn
    //   406: aload_2
    //   407: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   410: astore 28
    //   412: aload 28
    //   414: invokestatic 630	gnu/kawa/slib/testing:testRunnerSkipCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   417: areturn
    //   418: aload_2
    //   419: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   422: astore 26
    //   424: aload 26
    //   426: invokestatic 390	gnu/kawa/slib/testing:$PcTestRunnerSkipList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   429: areturn
    //   430: aload_2
    //   431: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   434: astore 24
    //   436: aload 24
    //   438: invokestatic 404	gnu/kawa/slib/testing:$PcTestRunnerFailList	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   441: areturn
    //   442: aload_2
    //   443: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   446: astore 22
    //   448: aload 22
    //   450: invokestatic 422	gnu/kawa/slib/testing:testRunnerGroupStack	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   453: areturn
    //   454: aload_2
    //   455: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   458: astore 20
    //   460: aload 20
    //   462: invokestatic 726	gnu/kawa/slib/testing:testRunnerOnTestBegin	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   465: areturn
    //   466: aload_2
    //   467: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   470: astore 18
    //   472: aload 18
    //   474: invokestatic 766	gnu/kawa/slib/testing:testRunnerOnTestEnd	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   477: areturn
    //   478: aload_2
    //   479: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   482: astore 16
    //   484: aload 16
    //   486: invokestatic 383	gnu/kawa/slib/testing:testRunnerOnGroupBegin	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   489: areturn
    //   490: aload_2
    //   491: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   494: astore 14
    //   496: aload 14
    //   498: invokestatic 559	gnu/kawa/slib/testing:testRunnerOnGroupEnd	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   501: areturn
    //   502: aload_2
    //   503: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   506: astore 12
    //   508: aload 12
    //   510: invokestatic 568	gnu/kawa/slib/testing:testRunnerOnFinal	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   513: areturn
    //   514: aload_2
    //   515: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   518: astore 10
    //   520: aload 10
    //   522: invokestatic 556	gnu/kawa/slib/testing:testRunnerOnBadCount	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   525: areturn
    //   526: aload_2
    //   527: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   530: astore 8
    //   532: aload 8
    //   534: invokestatic 534	gnu/kawa/slib/testing:testRunnerOnBadEndName	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   537: areturn
    //   538: aload_2
    //   539: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   542: astore 6
    //   544: aload 6
    //   546: invokestatic 645	gnu/kawa/slib/testing:testResultAlist	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   549: areturn
    //   550: aload_2
    //   551: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   554: astore 4
    //   556: aload 4
    //   558: invokestatic 1975	gnu/kawa/slib/testing:testRunnerAuxValue	(Lgnu/kawa/slib/test$Mnrunner;)Ljava/lang/Object;
    //   561: areturn
    //   562: aload_2
    //   563: invokestatic 2107	gnu/kawa/slib/testing:testRunnerReset	(Ljava/lang/Object;)V
    //   566: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   569: areturn
    //   570: aload_2
    //   571: invokestatic 2181	gnu/kawa/slib/testing:testRunnerGroupPath	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   574: areturn
    //   575: aload_2
    //   576: invokestatic 2183	gnu/kawa/slib/testing:$PcTestNullCallback	(Ljava/lang/Object;)Ljava/lang/Boolean;
    //   579: areturn
    //   580: aload_2
    //   581: invokestatic 723	gnu/kawa/slib/testing:$PcTestShouldExecute	(Ljava/lang/Object;)Ljava/lang/Object;
    //   584: areturn
    //   585: aload_2
    //   586: invokestatic 2185	gnu/kawa/slib/testing:testOnGroupEndSimple	(Ljava/lang/Object;)Ljava/lang/Boolean;
    //   589: areturn
    //   590: aload_2
    //   591: invokestatic 2187	gnu/kawa/slib/testing:testOnFinalSimple	(Ljava/lang/Object;)V
    //   594: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   597: areturn
    //   598: aload_2
    //   599: invokestatic 2189	gnu/kawa/slib/testing:testOnTestBeginSimple	(Ljava/lang/Object;)Ljava/lang/Object;
    //   602: areturn
    //   603: aload_2
    //   604: invokestatic 2191	gnu/kawa/slib/testing:testOnTestEndSimple	(Ljava/lang/Object;)Ljava/lang/Object;
    //   607: areturn
    //   608: aload_2
    //   609: invokestatic 2193	gnu/kawa/slib/testing:testResultClear	(Ljava/lang/Object;)V
    //   612: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   615: areturn
    //   616: aload_2
    //   617: invokestatic 2195	gnu/kawa/slib/testing:$PcTestOnTestBegin	(Ljava/lang/Object;)Z
    //   620: ifeq +7 -> 627
    //   623: getstatic 308	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   626: areturn
    //   627: getstatic 286	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   630: areturn
    //   631: aload_2
    //   632: invokestatic 2197	gnu/kawa/slib/testing:testRunnerTestName	(Ljava/lang/Object;)Ljava/lang/Object;
    //   635: areturn
    //   636: aload_2
    //   637: invokestatic 2199	gnu/kawa/slib/testing:$PcTestApproximimate$Eq	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   640: areturn
    //   641: aload_2
    //   642: invokestatic 2201	gnu/kawa/slib/testing:$PcTestAsSpecifier	(Ljava/lang/Object;)Ljava/lang/Object;
    //   645: areturn
    //   646: aload_2
    //   647: invokestatic 350	gnu/kawa/slib/testing:testMatchName	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   650: areturn
    //   651: aload_2
    //   652: invokestatic 2203	gnu/kawa/slib/testing:testReadEvalString	(Ljava/lang/Object;)Ljava/lang/Object;
    //   655: areturn
    //   656: aload_2
    //   657: invokestatic 2205	gnu/kawa/slib/testing:lambda16	(Ljava/lang/Object;)Ljava/lang/Object;
    //   660: areturn
    //   661: aload_2
    //   662: invokestatic 2207	gnu/kawa/slib/testing:lambda17	(Ljava/lang/Object;)Ljava/lang/Object;
    //   665: areturn
    //   666: aload_2
    //   667: invokestatic 2209	gnu/kawa/slib/testing:lambda18	(Ljava/lang/Object;)Ljava/lang/Object;
    //   670: areturn
    //   671: aload_2
    //   672: invokestatic 2211	gnu/kawa/slib/testing:lambda19	(Ljava/lang/Object;)Ljava/lang/Object;
    //   675: areturn
    //   676: aload_2
    //   677: invokestatic 2213	gnu/kawa/slib/testing:lambda20	(Ljava/lang/Object;)Ljava/lang/Object;
    //   680: areturn
    //   681: aload_2
    //   682: invokestatic 2215	gnu/kawa/slib/testing:lambda21	(Ljava/lang/Object;)Ljava/lang/Object;
    //   685: areturn
    //   686: aload_2
    //   687: invokestatic 2217	gnu/kawa/slib/testing:lambda22	(Ljava/lang/Object;)Ljava/lang/Object;
    //   690: areturn
    //   691: astore 35
    //   693: new 427	gnu/mapping/WrongType
    //   696: dup
    //   697: aload 35
    //   699: ldc_w 634
    //   702: iconst_1
    //   703: aload_2
    //   704: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   707: athrow
    //   708: astore 33
    //   710: new 427	gnu/mapping/WrongType
    //   713: dup
    //   714: aload 33
    //   716: ldc_w 640
    //   719: iconst_1
    //   720: aload_2
    //   721: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   724: athrow
    //   725: astore 31
    //   727: new 427	gnu/mapping/WrongType
    //   730: dup
    //   731: aload 31
    //   733: ldc_w 638
    //   736: iconst_1
    //   737: aload_2
    //   738: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   741: athrow
    //   742: astore 29
    //   744: new 427	gnu/mapping/WrongType
    //   747: dup
    //   748: aload 29
    //   750: ldc_w 636
    //   753: iconst_1
    //   754: aload_2
    //   755: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   758: athrow
    //   759: astore 27
    //   761: new 427	gnu/mapping/WrongType
    //   764: dup
    //   765: aload 27
    //   767: ldc_w 642
    //   770: iconst_1
    //   771: aload_2
    //   772: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   775: athrow
    //   776: astore 25
    //   778: new 427	gnu/mapping/WrongType
    //   781: dup
    //   782: aload 25
    //   784: ldc_w 436
    //   787: iconst_1
    //   788: aload_2
    //   789: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   792: athrow
    //   793: astore 23
    //   795: new 427	gnu/mapping/WrongType
    //   798: dup
    //   799: aload 23
    //   801: ldc_w 442
    //   804: iconst_1
    //   805: aload_2
    //   806: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   809: athrow
    //   810: astore 21
    //   812: new 427	gnu/mapping/WrongType
    //   815: dup
    //   816: aload 21
    //   818: ldc_w 454
    //   821: iconst_1
    //   822: aload_2
    //   823: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   826: athrow
    //   827: astore 19
    //   829: new 427	gnu/mapping/WrongType
    //   832: dup
    //   833: aload 19
    //   835: ldc_w 732
    //   838: iconst_1
    //   839: aload_2
    //   840: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   843: athrow
    //   844: astore 17
    //   846: new 427	gnu/mapping/WrongType
    //   849: dup
    //   850: aload 17
    //   852: ldc_w 792
    //   855: iconst_1
    //   856: aload_2
    //   857: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   860: athrow
    //   861: astore 15
    //   863: new 427	gnu/mapping/WrongType
    //   866: dup
    //   867: aload 15
    //   869: ldc_w 429
    //   872: iconst_1
    //   873: aload_2
    //   874: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   877: athrow
    //   878: astore 13
    //   880: new 427	gnu/mapping/WrongType
    //   883: dup
    //   884: aload 13
    //   886: ldc_w 582
    //   889: iconst_1
    //   890: aload_2
    //   891: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   894: athrow
    //   895: astore 11
    //   897: new 427	gnu/mapping/WrongType
    //   900: dup
    //   901: aload 11
    //   903: ldc_w 588
    //   906: iconst_1
    //   907: aload_2
    //   908: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   911: athrow
    //   912: astore 9
    //   914: new 427	gnu/mapping/WrongType
    //   917: dup
    //   918: aload 9
    //   920: ldc_w 580
    //   923: iconst_1
    //   924: aload_2
    //   925: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   928: athrow
    //   929: astore 7
    //   931: new 427	gnu/mapping/WrongType
    //   934: dup
    //   935: aload 7
    //   937: ldc_w 578
    //   940: iconst_1
    //   941: aload_2
    //   942: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   945: athrow
    //   946: astore 5
    //   948: new 427	gnu/mapping/WrongType
    //   951: dup
    //   952: aload 5
    //   954: ldc_w 666
    //   957: iconst_1
    //   958: aload_2
    //   959: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   962: athrow
    //   963: astore_3
    //   964: new 427	gnu/mapping/WrongType
    //   967: dup
    //   968: aload_3
    //   969: ldc_w 1529
    //   972: iconst_1
    //   973: aload_2
    //   974: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   977: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   358	364	691	java/lang/ClassCastException
    //   370	376	708	java/lang/ClassCastException
    //   382	388	725	java/lang/ClassCastException
    //   394	400	742	java/lang/ClassCastException
    //   406	412	759	java/lang/ClassCastException
    //   418	424	776	java/lang/ClassCastException
    //   430	436	793	java/lang/ClassCastException
    //   442	448	810	java/lang/ClassCastException
    //   454	460	827	java/lang/ClassCastException
    //   466	472	844	java/lang/ClassCastException
    //   478	484	861	java/lang/ClassCastException
    //   490	496	878	java/lang/ClassCastException
    //   502	508	895	java/lang/ClassCastException
    //   514	520	912	java/lang/ClassCastException
    //   526	532	929	java/lang/ClassCastException
    //   538	544	946	java/lang/ClassCastException
    //   550	556	963	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 2168	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+188->192, 14:+196->200, 16:+212->216, 18:+228->232, 20:+244->248, 22:+260->264, 24:+276->280, 26:+292->296, 28:+308->312, 30:+324->328, 32:+340->344, 34:+356->360, 36:+372->376, 38:+388->392, 40:+404->408, 42:+420->424, 44:+436->440, 46:+452->456, 58:+468->472, 64:+477->481, 69:+483->487, 74:+492->496, 85:+498->502
    //   193: aload_1
    //   194: aload_2
    //   195: aload_3
    //   196: invokespecial 2220	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: areturn
    //   200: aload_2
    //   201: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   204: astore 37
    //   206: aload 37
    //   208: aload_3
    //   209: invokestatic 760	gnu/kawa/slib/testing:testRunnerPassCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   212: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   215: areturn
    //   216: aload_2
    //   217: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   220: astore 35
    //   222: aload 35
    //   224: aload_3
    //   225: invokestatic 769	gnu/kawa/slib/testing:testRunnerFailCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   228: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   231: areturn
    //   232: aload_2
    //   233: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   236: astore 33
    //   238: aload 33
    //   240: aload_3
    //   241: invokestatic 772	gnu/kawa/slib/testing:testRunnerXpassCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   244: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   247: areturn
    //   248: aload_2
    //   249: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   252: astore 31
    //   254: aload 31
    //   256: aload_3
    //   257: invokestatic 775	gnu/kawa/slib/testing:testRunnerXfailCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   260: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   263: areturn
    //   264: aload_2
    //   265: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   268: astore 29
    //   270: aload 29
    //   272: aload_3
    //   273: invokestatic 778	gnu/kawa/slib/testing:testRunnerSkipCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   276: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   279: areturn
    //   280: aload_2
    //   281: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   284: astore 27
    //   286: aload 27
    //   288: aload_3
    //   289: invokestatic 562	gnu/kawa/slib/testing:$PcTestRunnerSkipList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   292: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   295: areturn
    //   296: aload_2
    //   297: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   300: astore 25
    //   302: aload 25
    //   304: aload_3
    //   305: invokestatic 565	gnu/kawa/slib/testing:$PcTestRunnerFailList$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   308: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   311: areturn
    //   312: aload_2
    //   313: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   316: astore 23
    //   318: aload 23
    //   320: aload_3
    //   321: invokestatic 425	gnu/kawa/slib/testing:testRunnerGroupStack$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   324: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   327: areturn
    //   328: aload_2
    //   329: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   332: astore 21
    //   334: aload 21
    //   336: aload_3
    //   337: invokestatic 2119	gnu/kawa/slib/testing:testRunnerOnTestBegin$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   340: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   343: areturn
    //   344: aload_2
    //   345: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   348: astore 19
    //   350: aload 19
    //   352: aload_3
    //   353: invokestatic 2122	gnu/kawa/slib/testing:testRunnerOnTestEnd$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   356: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   359: areturn
    //   360: aload_2
    //   361: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   364: astore 17
    //   366: aload 17
    //   368: aload_3
    //   369: invokestatic 2110	gnu/kawa/slib/testing:testRunnerOnGroupBegin$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   372: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   375: areturn
    //   376: aload_2
    //   377: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   380: astore 15
    //   382: aload 15
    //   384: aload_3
    //   385: invokestatic 2113	gnu/kawa/slib/testing:testRunnerOnGroupEnd$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   388: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   391: areturn
    //   392: aload_2
    //   393: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   396: astore 13
    //   398: aload 13
    //   400: aload_3
    //   401: invokestatic 2116	gnu/kawa/slib/testing:testRunnerOnFinal$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   404: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   407: areturn
    //   408: aload_2
    //   409: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   412: astore 11
    //   414: aload 11
    //   416: aload_3
    //   417: invokestatic 2125	gnu/kawa/slib/testing:testRunnerOnBadCount$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   420: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   423: areturn
    //   424: aload_2
    //   425: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   428: astore 9
    //   430: aload 9
    //   432: aload_3
    //   433: invokestatic 2128	gnu/kawa/slib/testing:testRunnerOnBadEndName$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   436: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   439: areturn
    //   440: aload_2
    //   441: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   444: astore 7
    //   446: aload 7
    //   448: aload_3
    //   449: invokestatic 519	gnu/kawa/slib/testing:testResultAlist$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   452: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   455: areturn
    //   456: aload_2
    //   457: checkcast 379	gnu/kawa/slib/test$Mnrunner
    //   460: astore 5
    //   462: aload 5
    //   464: aload_3
    //   465: invokestatic 2004	gnu/kawa/slib/testing:testRunnerAuxValue$Ex	(Lgnu/kawa/slib/test$Mnrunner;Ljava/lang/Object;)V
    //   468: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   471: areturn
    //   472: aload_2
    //   473: aload_3
    //   474: invokestatic 2222	gnu/kawa/slib/testing:$PcTestBegin	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   477: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   480: areturn
    //   481: aload_2
    //   482: aload_3
    //   483: invokestatic 2224	gnu/kawa/slib/testing:$PcTestEnd	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   486: areturn
    //   487: aload_2
    //   488: aload_3
    //   489: invokestatic 2226	gnu/kawa/slib/testing:testResultRemove	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   492: getstatic 574	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   495: areturn
    //   496: aload_2
    //   497: aload_3
    //   498: invokestatic 2228	gnu/kawa/slib/testing:$PcTestOnTestEnd	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   501: areturn
    //   502: aload_2
    //   503: aload_3
    //   504: invokestatic 342	gnu/kawa/slib/testing:$PcTestMatchNth	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   507: areturn
    //   508: astore 36
    //   510: new 427	gnu/mapping/WrongType
    //   513: dup
    //   514: aload 36
    //   516: ldc_w 780
    //   519: iconst_1
    //   520: aload_2
    //   521: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   524: athrow
    //   525: astore 34
    //   527: new 427	gnu/mapping/WrongType
    //   530: dup
    //   531: aload 34
    //   533: ldc_w 782
    //   536: iconst_1
    //   537: aload_2
    //   538: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   541: athrow
    //   542: astore 32
    //   544: new 427	gnu/mapping/WrongType
    //   547: dup
    //   548: aload 32
    //   550: ldc_w 784
    //   553: iconst_1
    //   554: aload_2
    //   555: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   558: athrow
    //   559: astore 30
    //   561: new 427	gnu/mapping/WrongType
    //   564: dup
    //   565: aload 30
    //   567: ldc_w 786
    //   570: iconst_1
    //   571: aload_2
    //   572: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   575: athrow
    //   576: astore 28
    //   578: new 427	gnu/mapping/WrongType
    //   581: dup
    //   582: aload 28
    //   584: ldc_w 788
    //   587: iconst_1
    //   588: aload_2
    //   589: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   592: athrow
    //   593: astore 26
    //   595: new 427	gnu/mapping/WrongType
    //   598: dup
    //   599: aload 26
    //   601: ldc_w 584
    //   604: iconst_1
    //   605: aload_2
    //   606: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   609: athrow
    //   610: astore 24
    //   612: new 427	gnu/mapping/WrongType
    //   615: dup
    //   616: aload 24
    //   618: ldc_w 586
    //   621: iconst_1
    //   622: aload_2
    //   623: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   626: athrow
    //   627: astore 22
    //   629: new 427	gnu/mapping/WrongType
    //   632: dup
    //   633: aload 22
    //   635: ldc_w 452
    //   638: iconst_1
    //   639: aload_2
    //   640: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   643: athrow
    //   644: astore 20
    //   646: new 427	gnu/mapping/WrongType
    //   649: dup
    //   650: aload 20
    //   652: ldc_w 1569
    //   655: iconst_1
    //   656: aload_2
    //   657: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   660: athrow
    //   661: astore 18
    //   663: new 427	gnu/mapping/WrongType
    //   666: dup
    //   667: aload 18
    //   669: ldc_w 1563
    //   672: iconst_1
    //   673: aload_2
    //   674: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   677: athrow
    //   678: astore 16
    //   680: new 427	gnu/mapping/WrongType
    //   683: dup
    //   684: aload 16
    //   686: ldc_w 1557
    //   689: iconst_1
    //   690: aload_2
    //   691: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   694: athrow
    //   695: astore 14
    //   697: new 427	gnu/mapping/WrongType
    //   700: dup
    //   701: aload 14
    //   703: ldc_w 1551
    //   706: iconst_1
    //   707: aload_2
    //   708: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   711: athrow
    //   712: astore 12
    //   714: new 427	gnu/mapping/WrongType
    //   717: dup
    //   718: aload 12
    //   720: ldc_w 1545
    //   723: iconst_1
    //   724: aload_2
    //   725: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   728: athrow
    //   729: astore 10
    //   731: new 427	gnu/mapping/WrongType
    //   734: dup
    //   735: aload 10
    //   737: ldc_w 1539
    //   740: iconst_1
    //   741: aload_2
    //   742: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   745: athrow
    //   746: astore 8
    //   748: new 427	gnu/mapping/WrongType
    //   751: dup
    //   752: aload 8
    //   754: ldc_w 1533
    //   757: iconst_1
    //   758: aload_2
    //   759: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   762: athrow
    //   763: astore 6
    //   765: new 427	gnu/mapping/WrongType
    //   768: dup
    //   769: aload 6
    //   771: ldc_w 576
    //   774: iconst_1
    //   775: aload_2
    //   776: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   779: athrow
    //   780: astore 4
    //   782: new 427	gnu/mapping/WrongType
    //   785: dup
    //   786: aload 4
    //   788: ldc_w 1525
    //   791: iconst_1
    //   792: aload_2
    //   793: invokespecial 432	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   796: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   200	206	508	java/lang/ClassCastException
    //   216	222	525	java/lang/ClassCastException
    //   232	238	542	java/lang/ClassCastException
    //   248	254	559	java/lang/ClassCastException
    //   264	270	576	java/lang/ClassCastException
    //   280	286	593	java/lang/ClassCastException
    //   296	302	610	java/lang/ClassCastException
    //   312	318	627	java/lang/ClassCastException
    //   328	334	644	java/lang/ClassCastException
    //   344	350	661	java/lang/ClassCastException
    //   360	366	678	java/lang/ClassCastException
    //   376	382	695	java/lang/ClassCastException
    //   392	398	712	java/lang/ClassCastException
    //   408	414	729	java/lang/ClassCastException
    //   424	430	746	java/lang/ClassCastException
    //   440	446	763	java/lang/ClassCastException
    //   456	462	780	java/lang/ClassCastException
  }

  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    case 50:
      return lambda1(paramObject1, paramObject2, paramObject3);
    case 51:
      return lambda2(paramObject1, paramObject2, paramObject3);
    case 52:
      return lambda3(paramObject1, paramObject2, paramObject3);
    case 59:
      return testOnGroupBeginSimple(paramObject1, paramObject2, paramObject3);
    case 61:
      testOnBadCountSimple(paramObject1, paramObject2, paramObject3);
      return Values.empty;
    case 62:
      return testOnBadEndNameSimple(paramObject1, paramObject2, paramObject3);
    case 67:
    }
    return testResultSet$Ex(paramObject1, paramObject2, paramObject3);
  }

  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    case 70:
      return testResultKind$V(paramArrayOfObject);
    case 71:
      return isTestPassed$V(paramArrayOfObject);
    case 84:
      Object localObject = paramArrayOfObject[0];
      int i = paramArrayOfObject.length - 1;
      Object[] arrayOfObject = new Object[i];
      int j = i;
      while (true)
      {
        j--;
        if (j < 0)
          return testApply$V(localObject, arrayOfObject);
        arrayOfObject[j] = paramArrayOfObject[(j + 1)];
      }
    case 86:
      return $PcTestMatchAll$V(paramArrayOfObject);
    case 87:
    }
    return $PcTestMatchAny$V(paramArrayOfObject);
  }

  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match0(paramModuleMethod, paramCallContext);
    case 72:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 56:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 55:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 54:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 53:
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 14:
    case 16:
    case 18:
    case 20:
    case 22:
    case 24:
    case 26:
    case 28:
    case 30:
    case 32:
    case 34:
    case 36:
    case 38:
    case 40:
    case 42:
    case 44:
    case 46:
    case 50:
    case 51:
    case 52:
    case 53:
    case 54:
    case 55:
    case 56:
    case 58:
    case 59:
    case 61:
    case 62:
    case 64:
    case 67:
    case 69:
    case 70:
    case 71:
    case 72:
    case 74:
    case 84:
    case 85:
    case 86:
    case 87:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 83:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 82:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 81:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 80:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 79:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 78:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 77:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 90:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 89:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 88:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 76:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 75:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 73:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 68:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 66:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 65:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 63:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 60:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 57:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 49:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 48:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 47:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 45:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 43:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 41:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 39:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 37:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 35:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 33:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 31:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 29:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 27:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 25:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 23:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 21:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 19:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 17:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 15:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 13:
      if (!(paramObject instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 12:
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
    case 85:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 74:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 69:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 64:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 58:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 46:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 44:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 42:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 40:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 38:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 36:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 34:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 32:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 30:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 28:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 26:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 24:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 22:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 20:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 18:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 16:
      if (!(paramObject1 instanceof test.Mnrunner))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 14:
    }
    if (!(paramObject1 instanceof test.Mnrunner))
      return -786431;
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
    case 67:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 62:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 61:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 59:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 52:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 51:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 50:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 87:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 86:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 84:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 71:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 70:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
    test$Mnlog$Mnto$Mnfile = Boolean.TRUE;
    test$Mnrunner$Mncurrent = parameters.makeParameter(Boolean.FALSE);
    test$Mnrunner$Mnfactory = parameters.makeParameter(test$Mnrunner$Mnsimple);
  }

  public class frame extends ModuleBody
  {
    Object p;

    public Object lambda4loop(Object paramObject)
    {
      if (paramObject == this.p)
        return lists.cdr.apply1(paramObject);
      return lists.cons(lists.car.apply1(paramObject), lambda4loop(lists.cdr.apply1(paramObject)));
    }
  }

  public class frame0 extends ModuleBody
  {
    Object error;
    final ModuleMethod lambda$Fn4;

    public frame0()
    {
      this$1 = new ModuleMethod(this, 1, null, 8194);
      this$1.setProperty("source-location", "testing.scm:640");
      this.lambda$Fn4 = this$1;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 1)
      {
        if (lambda5(paramObject1, paramObject2))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    boolean lambda5(Object paramObject1, Object paramObject2)
    {
      Object localObject = Scheme.numGEq.apply2(paramObject1, AddOp.$Mn.apply2(paramObject2, this.error));
      try
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        if (bool)
          return ((Boolean)Scheme.numLEq.apply2(paramObject1, AddOp.$Pl.apply2(paramObject2, this.error))).booleanValue();
        return bool;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject);
      }
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    }
  }

  public class frame1 extends ModuleBody
  {
    Object first;
    final ModuleMethod lambda$Fn10;
    final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 2, null, 0);
    final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn7;
    final ModuleMethod lambda$Fn8;
    final ModuleMethod lambda$Fn9;
    Object r;
    LList rest;
    Object saved$Mnrunner;
    Object saved$Mnrunner$1;

    public frame1()
    {
      this$1 = new ModuleMethod(this, 4, null, 0);
      this$1.setProperty("source-location", "testing.scm:897");
      this.lambda$Fn7 = this$1;
      this.lambda$Fn8 = new ModuleMethod(this, 5, null, 0);
      this.lambda$Fn9 = new ModuleMethod(this, 6, null, 0);
      ModuleMethod localModuleMethod = new ModuleMethod(this, 7, null, 0);
      localModuleMethod.setProperty("source-location", "testing.scm:897");
      this.lambda$Fn10 = localModuleMethod;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.apply0(paramModuleMethod);
      case 2:
        return lambda6();
      case 3:
        return lambda7();
      case 4:
        return lambda8();
      case 5:
        return lambda9();
      case 6:
        return lambda10();
      case 7:
      }
      return lambda11();
    }

    Object lambda10()
    {
      return Scheme.apply.apply3(testing.test$Mnapply, this.first, this.rest);
    }

    Object lambda11()
    {
      return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(this.saved$Mnrunner);
    }

    Object lambda6()
    {
      return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(this.first);
    }

    Object lambda7()
    {
      return Scheme.apply.apply2(testing.test$Mnapply, this.rest);
    }

    Object lambda8()
    {
      return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(this.saved$Mnrunner$1);
    }

    Object lambda9()
    {
      return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(this.r);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.match0(paramModuleMethod, paramCallContext);
      case 7:
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 6:
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 5:
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 4:
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 3:
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      case 2:
      }
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    }
  }

  public class frame2 extends ModuleBody
  {
    Object count;
    Object i;
    final ModuleMethod lambda$Fn11;
    Object n;

    public frame2()
    {
      this$1 = new ModuleMethod(this, 8, null, 4097);
      this$1.setProperty("source-location", "testing.scm:903");
      this.lambda$Fn11 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 8)
      {
        if (lambda12(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda12(Object paramObject)
    {
      this.i = AddOp.$Pl.apply2(this.i, testing.Lit13);
      Object localObject = Scheme.numGEq.apply2(this.i, this.n);
      try
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        if (bool)
          return ((Boolean)Scheme.numLss.apply2(this.i, AddOp.$Pl.apply2(this.n, this.count))).booleanValue();
        return bool;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject);
      }
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 8)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame3 extends ModuleBody
  {
    final ModuleMethod lambda$Fn12;
    LList pred$Mnlist;

    public frame3()
    {
      this$1 = new ModuleMethod(this, 9, null, 4097);
      this$1.setProperty("source-location", "testing.scm:915");
      this.lambda$Fn12 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 9)
        return lambda13(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda13(Object paramObject)
    {
      Boolean localBoolean = Boolean.TRUE;
      for (Object localObject = this.pred$Mnlist; ; localObject = lists.cdr.apply1(localObject))
      {
        if (lists.isNull(localObject))
          return localBoolean;
        if (Scheme.applyToArgs.apply2(lists.car.apply1(localObject), paramObject) == Boolean.FALSE)
          localBoolean = Boolean.FALSE;
      }
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 9)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame4 extends ModuleBody
  {
    final ModuleMethod lambda$Fn13;
    LList pred$Mnlist;

    public frame4()
    {
      this$1 = new ModuleMethod(this, 10, null, 4097);
      this$1.setProperty("source-location", "testing.scm:931");
      this.lambda$Fn13 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 10)
        return lambda14(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda14(Object paramObject)
    {
      Boolean localBoolean = Boolean.FALSE;
      for (Object localObject = this.pred$Mnlist; ; localObject = lists.cdr.apply1(localObject))
      {
        if (lists.isNull(localObject))
          return localBoolean;
        if (Scheme.applyToArgs.apply2(lists.car.apply1(localObject), paramObject) != Boolean.FALSE)
          localBoolean = Boolean.TRUE;
      }
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 10)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame5 extends ModuleBody
  {
    final ModuleMethod lambda$Fn14;
    Object name;

    public frame5()
    {
      this$1 = new ModuleMethod(this, 11, null, 4097);
      this$1.setProperty("source-location", "testing.scm:971");
      this.lambda$Fn14 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 11)
      {
        if (lambda15(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda15(Object paramObject)
    {
      return IsEqual.apply(this.name, testing.testRunnerTestName(paramObject));
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 11)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.testing
 * JD-Core Version:    0.6.2
 */