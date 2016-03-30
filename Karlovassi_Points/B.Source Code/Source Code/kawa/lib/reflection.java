package kawa.lib;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.GetFieldProc;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Record;
import kawa.lang.RecordConstructor;
import kawa.lang.SetFieldProc;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.standard.syntax_case;

public class reflection extends ModuleBody
{
  public static final reflection $instance;
  static final SimpleSymbol Lit0;
  static final SyntaxPattern Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SyntaxRules Lit15;
  static final SimpleSymbol Lit16;
  static final SyntaxRules Lit17;
  static final SimpleSymbol Lit18;
  static final SyntaxRules Lit19;
  static final SyntaxTemplate Lit2;
  static final SimpleSymbol Lit20;
  static final SyntaxRules Lit21;
  static final SimpleSymbol Lit22;
  static final SyntaxRules Lit23;
  static final SimpleSymbol Lit24;
  static final SyntaxRules Lit25;
  static final SimpleSymbol Lit26;
  static final SyntaxRules Lit27;
  static final SimpleSymbol Lit28;
  static final SyntaxRules Lit29;
  static final SyntaxPattern Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32;
  static final IntNum Lit33;
  static final IntNum Lit34 = IntNum.make(1);
  static final SyntaxTemplate Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod make$Mnrecord$Mntype;
  public static final Macro primitive$Mnarray$Mnget;
  public static final Macro primitive$Mnarray$Mnlength;
  public static final Macro primitive$Mnarray$Mnnew;
  public static final Macro primitive$Mnarray$Mnset;
  public static final Macro primitive$Mnconstructor;
  public static final Macro primitive$Mnget$Mnfield;
  public static final Macro primitive$Mnget$Mnstatic;
  public static final Macro primitive$Mnset$Mnfield;
  public static final Macro primitive$Mnset$Mnstatic;
  public static final ModuleMethod record$Mnaccessor;
  public static final ModuleMethod record$Mnconstructor;
  public static final ModuleMethod record$Mnmodifier;
  public static final ModuleMethod record$Mnpredicate;
  public static final ModuleMethod record$Mntype$Mndescriptor;
  public static final ModuleMethod record$Mntype$Mnfield$Mnnames;
  public static final ModuleMethod record$Mntype$Mnname;
  public static final ModuleMethod record$Qu;
  public static final ModuleMethod subtype$Qu;

  static
  {
    Lit33 = IntNum.make(9);
    Lit32 = (SimpleSymbol)new SimpleSymbol("make").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("constant-fold").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("subtype?").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("primitive-set-static").readResolve();
    Lit28 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject2 = new Object[4];
    arrayOfObject2[0] = Lit31;
    arrayOfObject2[1] = Lit32;
    arrayOfObject2[2] = ((SimpleSymbol)new SimpleSymbol("<gnu.kawa.reflect.StaticSet>").readResolve());
    arrayOfObject2[3] = PairWithPosition.make(Lit33, LList.Empty, "reflection.scm", 454679);
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001\001\001", "\021\030\004\021\030\f\021\030\024\t\003\t\013\t\023\030\034", arrayOfObject2, 0);
    Lit29 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule1, 3);
    Object[] arrayOfObject3 = new Object[1];
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("primitive-get-static").readResolve();
    Lit26 = localSimpleSymbol2;
    arrayOfObject3[0] = localSimpleSymbol2;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject4 = new Object[4];
    arrayOfObject4[0] = Lit31;
    arrayOfObject4[1] = Lit32;
    arrayOfObject4[2] = ((SimpleSymbol)new SimpleSymbol("<gnu.kawa.reflect.StaticGet>").readResolve());
    arrayOfObject4[3] = PairWithPosition.make(Lit33, LList.Empty, "reflection.scm", 430103);
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\001\001\001", "\021\030\004\021\030\f\021\030\024\t\003\t\013\t\023\030\034", arrayOfObject4, 0);
    Lit27 = new SyntaxRules(arrayOfObject3, arrayOfSyntaxRule2, 3);
    Object[] arrayOfObject5 = new Object[1];
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("primitive-set-field").readResolve();
    Lit24 = localSimpleSymbol3;
    arrayOfObject5[0] = localSimpleSymbol3;
    SyntaxRule[] arrayOfSyntaxRule3 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject6 = new Object[4];
    arrayOfObject6[0] = Lit31;
    arrayOfObject6[1] = Lit32;
    arrayOfObject6[2] = ((SimpleSymbol)new SimpleSymbol("<kawa.lang.SetFieldProc>").readResolve());
    arrayOfObject6[3] = PairWithPosition.make(Lit34, LList.Empty, "reflection.scm", 401431);
    arrayOfSyntaxRule3[0] = new SyntaxRule(localSyntaxPattern3, "\001\001\001", "\021\030\004\021\030\f\021\030\024\t\003\t\013\t\023\030\034", arrayOfObject6, 0);
    Lit25 = new SyntaxRules(arrayOfObject5, arrayOfSyntaxRule3, 3);
    Object[] arrayOfObject7 = new Object[1];
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol("primitive-get-field").readResolve();
    Lit22 = localSimpleSymbol4;
    arrayOfObject7[0] = localSimpleSymbol4;
    SyntaxRule[] arrayOfSyntaxRule4 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern4 = new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3);
    Object[] arrayOfObject8 = new Object[4];
    arrayOfObject8[0] = Lit31;
    arrayOfObject8[1] = Lit32;
    arrayOfObject8[2] = ((SimpleSymbol)new SimpleSymbol("<kawa.lang.GetFieldProc>").readResolve());
    arrayOfObject8[3] = PairWithPosition.make(Lit34, LList.Empty, "reflection.scm", 376855);
    arrayOfSyntaxRule4[0] = new SyntaxRule(localSyntaxPattern4, "\001\001\001", "\021\030\004\021\030\f\021\030\024\t\003\t\013\t\023\030\034", arrayOfObject8, 0);
    Lit23 = new SyntaxRules(arrayOfObject7, arrayOfSyntaxRule4, 3);
    Object[] arrayOfObject9 = new Object[1];
    SimpleSymbol localSimpleSymbol5 = (SimpleSymbol)new SimpleSymbol("primitive-array-length").readResolve();
    Lit20 = localSimpleSymbol5;
    arrayOfObject9[0] = localSimpleSymbol5;
    SyntaxRule[] arrayOfSyntaxRule5 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern5 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject10 = new Object[3];
    arrayOfObject10[0] = Lit31;
    arrayOfObject10[1] = Lit32;
    arrayOfObject10[2] = ((SimpleSymbol)new SimpleSymbol("<gnu.kawa.reflect.ArrayLength>").readResolve());
    arrayOfSyntaxRule5[0] = new SyntaxRule(localSyntaxPattern5, "\001", "\021\030\004\021\030\f\021\030\024\b\003", arrayOfObject10, 0);
    Lit21 = new SyntaxRules(arrayOfObject9, arrayOfSyntaxRule5, 1);
    Object[] arrayOfObject11 = new Object[1];
    SimpleSymbol localSimpleSymbol6 = (SimpleSymbol)new SimpleSymbol("primitive-array-get").readResolve();
    Lit18 = localSimpleSymbol6;
    arrayOfObject11[0] = localSimpleSymbol6;
    SyntaxRule[] arrayOfSyntaxRule6 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern6 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject12 = new Object[3];
    arrayOfObject12[0] = Lit31;
    arrayOfObject12[1] = Lit32;
    arrayOfObject12[2] = ((SimpleSymbol)new SimpleSymbol("<gnu.kawa.reflect.ArrayGet>").readResolve());
    arrayOfSyntaxRule6[0] = new SyntaxRule(localSyntaxPattern6, "\001", "\021\030\004\021\030\f\021\030\024\b\003", arrayOfObject12, 0);
    Lit19 = new SyntaxRules(arrayOfObject11, arrayOfSyntaxRule6, 1);
    Object[] arrayOfObject13 = new Object[1];
    SimpleSymbol localSimpleSymbol7 = (SimpleSymbol)new SimpleSymbol("primitive-array-set").readResolve();
    Lit16 = localSimpleSymbol7;
    arrayOfObject13[0] = localSimpleSymbol7;
    SyntaxRule[] arrayOfSyntaxRule7 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern7 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject14 = new Object[3];
    arrayOfObject14[0] = Lit31;
    arrayOfObject14[1] = Lit32;
    arrayOfObject14[2] = ((SimpleSymbol)new SimpleSymbol("<gnu.kawa.reflect.ArraySet>").readResolve());
    arrayOfSyntaxRule7[0] = new SyntaxRule(localSyntaxPattern7, "\001", "\021\030\004\021\030\f\021\030\024\b\003", arrayOfObject14, 0);
    Lit17 = new SyntaxRules(arrayOfObject13, arrayOfSyntaxRule7, 1);
    Object[] arrayOfObject15 = new Object[1];
    SimpleSymbol localSimpleSymbol8 = (SimpleSymbol)new SimpleSymbol("primitive-array-new").readResolve();
    Lit14 = localSimpleSymbol8;
    arrayOfObject15[0] = localSimpleSymbol8;
    SyntaxRule[] arrayOfSyntaxRule8 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern8 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject16 = new Object[3];
    arrayOfObject16[0] = Lit31;
    arrayOfObject16[1] = Lit32;
    arrayOfObject16[2] = ((SimpleSymbol)new SimpleSymbol("<gnu.kawa.reflect.ArrayNew>").readResolve());
    arrayOfSyntaxRule8[0] = new SyntaxRule(localSyntaxPattern8, "\001", "\021\030\004\021\030\f\021\030\024\b\003", arrayOfObject16, 0);
    Lit15 = new SyntaxRules(arrayOfObject15, arrayOfSyntaxRule8, 1);
    Lit13 = (SimpleSymbol)new SimpleSymbol("record-type-field-names").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("record-type-name").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("record-type-descriptor").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("record-predicate").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("record?").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("record-modifier").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("record-accessor").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("record-constructor").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("make-record-type").readResolve();
    Object[] arrayOfObject17 = new Object[4];
    arrayOfObject17[0] = ((SimpleSymbol)new SimpleSymbol("lambda").readResolve());
    arrayOfObject17[1] = ((SimpleSymbol)new SimpleSymbol("::").readResolve());
    arrayOfObject17[2] = Lit32;
    arrayOfObject17[3] = ((SimpleSymbol)new SimpleSymbol("as").readResolve());
    Lit4 = new SyntaxTemplate("\001\001\003\003", "\021\030\004\031\b\035\033\021\030\f\t\013\b\021\030\024\t\013\b\025\021\030\034\t\023\b\033", arrayOfObject17, 1);
    Lit3 = new SyntaxPattern("\r\037\030\b\b", new Object[0], 4);
    Lit2 = new SyntaxTemplate("\001\001\003", "\b\025\023", new Object[0], 1);
    Lit1 = new SyntaxPattern("\f\007\f\017,\r\027\020\b\b\b", new Object[0], 3);
    Lit0 = (SimpleSymbol)new SimpleSymbol("primitive-constructor").readResolve();
    $instance = new reflection();
    SimpleSymbol localSimpleSymbol9 = Lit0;
    reflection localreflection = $instance;
    primitive$Mnconstructor = Macro.make(localSimpleSymbol9, new ModuleMethod(localreflection, 2, null, 4097), $instance);
    make$Mnrecord$Mntype = new ModuleMethod(localreflection, 3, Lit5, 8194);
    record$Mnconstructor = new ModuleMethod(localreflection, 4, Lit6, 8193);
    record$Mnaccessor = new ModuleMethod(localreflection, 6, Lit7, 8194);
    record$Mnmodifier = new ModuleMethod(localreflection, 7, Lit8, 8194);
    record$Qu = new ModuleMethod(localreflection, 8, Lit9, 4097);
    record$Mnpredicate = new ModuleMethod(localreflection, 9, Lit10, 4097);
    record$Mntype$Mndescriptor = new ModuleMethod(localreflection, 10, Lit11, 4097);
    record$Mntype$Mnname = new ModuleMethod(localreflection, 11, Lit12, 4097);
    record$Mntype$Mnfield$Mnnames = new ModuleMethod(localreflection, 12, Lit13, 4097);
    primitive$Mnarray$Mnnew = Macro.make(Lit14, Lit15, $instance);
    primitive$Mnarray$Mnset = Macro.make(Lit16, Lit17, $instance);
    primitive$Mnarray$Mnget = Macro.make(Lit18, Lit19, $instance);
    primitive$Mnarray$Mnlength = Macro.make(Lit20, Lit21, $instance);
    primitive$Mnget$Mnfield = Macro.make(Lit22, Lit23, $instance);
    primitive$Mnset$Mnfield = Macro.make(Lit24, Lit25, $instance);
    primitive$Mnget$Mnstatic = Macro.make(Lit26, Lit27, $instance);
    primitive$Mnset$Mnstatic = Macro.make(Lit28, Lit29, $instance);
    subtype$Qu = new ModuleMethod(localreflection, 13, Lit30, 8194);
    $instance.run();
  }

  public reflection()
  {
    ModuleInfo.register(this);
  }

  public static boolean isRecord(Object paramObject)
  {
    return paramObject instanceof Record;
  }

  public static boolean isSubtype(Type paramType1, Type paramType2)
  {
    return paramType1.isSubtype(paramType2);
  }

  static Object lambda2(Object paramObject)
  {
    Object[] arrayOfObject1 = SyntaxPattern.allocVars(3, null);
    if (Lit1.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      Object localObject = std_syntax.generateTemporaries(Lit2.execute(arrayOfObject1, localTemplateScope1));
      Object[] arrayOfObject2 = SyntaxPattern.allocVars(4, arrayOfObject1);
      if (Lit3.match(localObject, arrayOfObject2, 0))
      {
        TemplateScope localTemplateScope2 = TemplateScope.make();
        return Lit4.execute(arrayOfObject2, localTemplateScope2);
      }
      return syntax_case.error("syntax-case", localObject);
    }
    return syntax_case.error("syntax-case", paramObject);
  }

  public static ClassType makeRecordType(String paramString, LList paramLList)
  {
    return Record.makeRecordType(paramString, paramLList);
  }

  public static GetFieldProc recordAccessor(ClassType paramClassType, String paramString)
  {
    return new GetFieldProc(paramClassType, paramString);
  }

  public static RecordConstructor recordConstructor(ClassType paramClassType)
  {
    return recordConstructor(paramClassType, null);
  }

  public static RecordConstructor recordConstructor(ClassType paramClassType, Object paramObject)
  {
    return new RecordConstructor(paramClassType, paramObject);
  }

  public static SetFieldProc recordModifier(ClassType paramClassType, String paramString)
  {
    return new SetFieldProc(paramClassType, paramString);
  }

  public static Procedure recordPredicate(Object paramObject)
  {
    frame localframe = new frame();
    localframe.rtype = paramObject;
    return localframe.lambda$Fn1;
  }

  public static Type recordTypeDescriptor(Object paramObject)
  {
    return Type.make(paramObject.getClass());
  }

  public static LList recordTypeFieldNames(Object paramObject)
  {
    try
    {
      ClassType localClassType = LangObjType.coerceToClassType(paramObject);
      return Record.typeFieldNames(localClassType);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "kawa.lang.Record.typeFieldNames(class-type)", 1, paramObject);
    }
  }

  public static String recordTypeName(ClassType paramClassType)
  {
    return Compilation.demangleName(paramClassType.getName(), true);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 476	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+60 -> 64, 2:+121->125, 3:+60->64, 4:+67->71, 5:+60->64, 6:+60->64, 7:+60->64, 8:+79->83, 9:+94->98, 10:+99->103, 11:+104->108, 12:+116->120
    //   65: aload_1
    //   66: aload_2
    //   67: invokespecial 478	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: areturn
    //   71: aload_2
    //   72: invokestatic 445	gnu/kawa/lispexpr/LangObjType:coerceToClassType	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   75: astore 6
    //   77: aload 6
    //   79: invokestatic 480	kawa/lib/reflection:recordConstructor	(Lgnu/bytecode/ClassType;)Lkawa/lang/RecordConstructor;
    //   82: areturn
    //   83: aload_2
    //   84: invokestatic 482	kawa/lib/reflection:isRecord	(Ljava/lang/Object;)Z
    //   87: ifeq +7 -> 94
    //   90: getstatic 488	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   93: areturn
    //   94: getstatic 491	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   97: areturn
    //   98: aload_2
    //   99: invokestatic 493	kawa/lib/reflection:recordPredicate	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   102: areturn
    //   103: aload_2
    //   104: invokestatic 495	kawa/lib/reflection:recordTypeDescriptor	(Ljava/lang/Object;)Lgnu/bytecode/Type;
    //   107: areturn
    //   108: aload_2
    //   109: invokestatic 445	gnu/kawa/lispexpr/LangObjType:coerceToClassType	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   112: astore 4
    //   114: aload 4
    //   116: invokestatic 497	kawa/lib/reflection:recordTypeName	(Lgnu/bytecode/ClassType;)Ljava/lang/String;
    //   119: areturn
    //   120: aload_2
    //   121: invokestatic 499	kawa/lib/reflection:recordTypeFieldNames	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   124: areturn
    //   125: aload_2
    //   126: invokestatic 501	kawa/lib/reflection:lambda2	(Ljava/lang/Object;)Ljava/lang/Object;
    //   129: areturn
    //   130: astore 5
    //   132: new 451	gnu/mapping/WrongType
    //   135: dup
    //   136: aload 5
    //   138: ldc 240
    //   140: iconst_1
    //   141: aload_2
    //   142: invokespecial 456	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   145: athrow
    //   146: astore_3
    //   147: new 451	gnu/mapping/WrongType
    //   150: dup
    //   151: aload_3
    //   152: ldc 216
    //   154: iconst_1
    //   155: aload_2
    //   156: invokespecial 456	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   71	77	130	java/lang/ClassCastException
    //   108	114	146	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 476	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+60 -> 64, 3:+68->72, 4:+98->102, 5:+60->64, 6:+111->115, 7:+141->145, 8:+60->64, 9:+60->64, 10:+60->64, 11:+60->64, 12:+60->64, 13:+171->175
    //   65: aload_1
    //   66: aload_2
    //   67: aload_3
    //   68: invokespecial 505	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: areturn
    //   72: aload_2
    //   73: ifnonnull +20 -> 93
    //   76: aconst_null
    //   77: astore 16
    //   79: aload_3
    //   80: checkcast 119	gnu/lists/LList
    //   83: astore 18
    //   85: aload 16
    //   87: aload 18
    //   89: invokestatic 506	kawa/lib/reflection:makeRecordType	(Ljava/lang/String;Lgnu/lists/LList;)Lgnu/bytecode/ClassType;
    //   92: areturn
    //   93: aload_2
    //   94: invokevirtual 509	java/lang/Object:toString	()Ljava/lang/String;
    //   97: astore 16
    //   99: goto -20 -> 79
    //   102: aload_2
    //   103: invokestatic 445	gnu/kawa/lispexpr/LangObjType:coerceToClassType	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   106: astore 15
    //   108: aload 15
    //   110: aload_3
    //   111: invokestatic 404	kawa/lib/reflection:recordConstructor	(Lgnu/bytecode/ClassType;Ljava/lang/Object;)Lkawa/lang/RecordConstructor;
    //   114: areturn
    //   115: aload_2
    //   116: invokestatic 445	gnu/kawa/lispexpr/LangObjType:coerceToClassType	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   119: astore 12
    //   121: aconst_null
    //   122: astore 13
    //   124: aload_3
    //   125: ifnonnull +11 -> 136
    //   128: aload 12
    //   130: aload 13
    //   132: invokestatic 511	kawa/lib/reflection:recordAccessor	(Lgnu/bytecode/ClassType;Ljava/lang/String;)Lkawa/lang/GetFieldProc;
    //   135: areturn
    //   136: aload_3
    //   137: invokevirtual 509	java/lang/Object:toString	()Ljava/lang/String;
    //   140: astore 13
    //   142: goto -14 -> 128
    //   145: aload_2
    //   146: invokestatic 445	gnu/kawa/lispexpr/LangObjType:coerceToClassType	(Ljava/lang/Object;)Lgnu/bytecode/ClassType;
    //   149: astore 9
    //   151: aconst_null
    //   152: astore 10
    //   154: aload_3
    //   155: ifnonnull +11 -> 166
    //   158: aload 9
    //   160: aload 10
    //   162: invokestatic 513	kawa/lib/reflection:recordModifier	(Lgnu/bytecode/ClassType;Ljava/lang/String;)Lkawa/lang/SetFieldProc;
    //   165: areturn
    //   166: aload_3
    //   167: invokevirtual 509	java/lang/Object:toString	()Ljava/lang/String;
    //   170: astore 10
    //   172: goto -14 -> 158
    //   175: aload_2
    //   176: invokestatic 516	gnu/kawa/lispexpr/LangObjType:coerceToType	(Ljava/lang/Object;)Lgnu/bytecode/Type;
    //   179: astore 5
    //   181: aload_3
    //   182: invokestatic 516	gnu/kawa/lispexpr/LangObjType:coerceToType	(Ljava/lang/Object;)Lgnu/bytecode/Type;
    //   185: astore 7
    //   187: aload 5
    //   189: aload 7
    //   191: invokestatic 518	kawa/lib/reflection:isSubtype	(Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Z
    //   194: ifeq +7 -> 201
    //   197: getstatic 488	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   200: areturn
    //   201: getstatic 491	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   204: areturn
    //   205: astore 17
    //   207: new 451	gnu/mapping/WrongType
    //   210: dup
    //   211: aload 17
    //   213: ldc 244
    //   215: iconst_2
    //   216: aload_3
    //   217: invokespecial 456	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   220: athrow
    //   221: astore 14
    //   223: new 451	gnu/mapping/WrongType
    //   226: dup
    //   227: aload 14
    //   229: ldc 240
    //   231: iconst_1
    //   232: aload_2
    //   233: invokespecial 456	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   236: athrow
    //   237: astore 11
    //   239: new 451	gnu/mapping/WrongType
    //   242: dup
    //   243: aload 11
    //   245: ldc 236
    //   247: iconst_1
    //   248: aload_2
    //   249: invokespecial 456	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   252: athrow
    //   253: astore 8
    //   255: new 451	gnu/mapping/WrongType
    //   258: dup
    //   259: aload 8
    //   261: ldc 232
    //   263: iconst_1
    //   264: aload_2
    //   265: invokespecial 456	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   268: athrow
    //   269: astore 4
    //   271: new 451	gnu/mapping/WrongType
    //   274: dup
    //   275: aload 4
    //   277: ldc 98
    //   279: iconst_1
    //   280: aload_2
    //   281: invokespecial 456	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   284: athrow
    //   285: astore 6
    //   287: new 451	gnu/mapping/WrongType
    //   290: dup
    //   291: aload 6
    //   293: ldc 98
    //   295: iconst_2
    //   296: aload_3
    //   297: invokespecial 456	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   300: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   79	85	205	java/lang/ClassCastException
    //   102	108	221	java/lang/ClassCastException
    //   115	121	237	java/lang/ClassCastException
    //   145	151	253	java/lang/ClassCastException
    //   175	181	269	java/lang/ClassCastException
    //   181	187	285	java/lang/ClassCastException
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 3:
    case 5:
    case 6:
    case 7:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 2:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 12:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11:
      if (LangObjType.coerceToClassTypeOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 10:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 8:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 4:
    }
    if (LangObjType.coerceToClassTypeOrNull(paramObject) != null)
    {
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    return -786431;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 5:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 13:
      if (LangObjType.coerceToTypeOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (LangObjType.coerceToTypeOrNull(paramObject2) != null)
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
    case 7:
      if (LangObjType.coerceToClassTypeOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 6:
      if (LangObjType.coerceToClassTypeOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 4:
      if (LangObjType.coerceToClassTypeOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786431;
    case 3:
    }
    paramCallContext.value1 = paramObject1;
    if ((paramObject2 instanceof LList))
    {
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
    return -786430;
  }

  public final void run(CallContext paramCallContext)
  {
  }

  public class frame extends ModuleBody
  {
    final ModuleMethod lambda$Fn1;
    Object rtype;

    public frame()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "reflection.scm:30");
      this.lambda$Fn1 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 1)
      {
        if (lambda1(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda1(Object paramObject)
    {
      Object localObject = this.rtype;
      try
      {
        Type localType = (Type)localObject;
        return localType.isInstance(paramObject);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "gnu.bytecode.Type.isInstance(java.lang.Object)", 1, localObject);
      }
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 1)
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
 * Qualified Name:     kawa.lib.reflection
 * JD-Core Version:    0.6.2
 */