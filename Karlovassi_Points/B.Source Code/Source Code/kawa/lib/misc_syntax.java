package kawa.lib;

import gnu.expr.Compilation;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.GetModuleClass;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.Location;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Path;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.standard.syntax_case;

public class misc_syntax extends ModuleBody
{
  public static final Location $Prvt$define$Mnconstant;
  public static final misc_syntax $instance;
  static final SimpleSymbol Lit0;
  static final SyntaxPattern Lit1;
  static final SimpleSymbol Lit10;
  static final SyntaxRules Lit11;
  static final SimpleSymbol Lit12;
  static final SyntaxPattern Lit13;
  static final SyntaxTemplate Lit14;
  static final SyntaxTemplate Lit15;
  static final SyntaxPattern Lit16;
  static final SyntaxTemplate Lit17;
  static final SimpleSymbol Lit18;
  static final SyntaxPattern Lit19;
  static final SyntaxTemplate Lit2;
  static final SyntaxTemplate Lit20;
  static final SyntaxTemplate Lit21;
  static final SyntaxTemplate Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29;
  static final SyntaxTemplate Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31 = (SimpleSymbol)new SimpleSymbol("%test-begin").readResolve();
  static final SyntaxTemplate Lit4;
  static final SyntaxPattern Lit5;
  static final SimpleSymbol Lit6;
  static final SyntaxRules Lit7;
  static final SimpleSymbol Lit8;
  static final SyntaxPattern Lit9;
  public static final Macro include;
  public static final Macro include$Mnrelative;
  public static final Macro module$Mnuri;
  public static final Macro provide;
  public static final Macro resource$Mnurl;
  public static final Macro test$Mnbegin;

  static
  {
    Lit30 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("require").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("else").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("cond-expand").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("srfi-64").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("begin").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("quasiquote").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("$lookup$").readResolve();
    Lit22 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    Lit21 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    Lit20 = new SyntaxTemplate("\001\001", "\b\013", new Object[0], 0);
    Lit19 = new SyntaxPattern("\f\007\f\017\b", new Object[0], 2);
    Lit18 = (SimpleSymbol)new SimpleSymbol("include-relative").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Lit25;
    Lit17 = new SyntaxTemplate("\001\001\003", "\021\030\004\b\025\023", arrayOfObject1, 1);
    Lit16 = new SyntaxPattern("\r\027\020\b\b", new Object[0], 3);
    Lit15 = new SyntaxTemplate("\001\001", "\003", new Object[0], 0);
    Lit14 = new SyntaxTemplate("\001\001", "\013", new Object[0], 0);
    Lit13 = new SyntaxPattern("\f\007\f\017\b", new Object[0], 2);
    Lit12 = (SimpleSymbol)new SimpleSymbol("include").readResolve();
    Object[] arrayOfObject2 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("resource-url").readResolve();
    Lit10 = localSimpleSymbol1;
    arrayOfObject2[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule1 = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern1 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject3 = new Object[6];
    arrayOfObject3[0] = PairWithPosition.make(Lit23, Pair.make((SimpleSymbol)new SimpleSymbol("gnu.text.URLPath").readResolve(), Pair.make(Pair.make(Lit24, Pair.make((SimpleSymbol)new SimpleSymbol("valueOf").readResolve(), LList.Empty)), LList.Empty)), "misc_syntax.scm", 155655);
    arrayOfObject3[1] = Lit23;
    SimpleSymbol localSimpleSymbol2 = Lit23;
    SimpleSymbol localSimpleSymbol3 = (SimpleSymbol)new SimpleSymbol("module-uri").readResolve();
    Lit8 = localSimpleSymbol3;
    arrayOfObject3[2] = PairWithPosition.make(localSimpleSymbol2, Pair.make(PairWithPosition.make(localSimpleSymbol3, LList.Empty, "misc_syntax.scm", 159755), Pair.make(Pair.make(Lit24, Pair.make((SimpleSymbol)new SimpleSymbol("resolve").readResolve(), LList.Empty)), LList.Empty)), "misc_syntax.scm", 159755);
    arrayOfObject3[3] = Pair.make(Pair.make(Lit24, Pair.make((SimpleSymbol)new SimpleSymbol("toURL").readResolve(), LList.Empty)), LList.Empty);
    arrayOfObject3[4] = Pair.make(Pair.make(Lit24, Pair.make((SimpleSymbol)new SimpleSymbol("openConnection").readResolve(), LList.Empty)), LList.Empty);
    arrayOfObject3[5] = Pair.make(Pair.make(Lit24, Pair.make((SimpleSymbol)new SimpleSymbol("getURL").readResolve(), LList.Empty)), LList.Empty);
    arrayOfSyntaxRule1[0] = new SyntaxRule(localSyntaxPattern1, "\001", "\021\030\004\b\b\021\030\f\b\021\030\fa\b\021\030\f)\021\030\024\b\003\030\034\030$\030,", arrayOfObject3, 0);
    Lit11 = new SyntaxRules(arrayOfObject2, arrayOfSyntaxRule1, 1);
    Lit9 = new SyntaxPattern("\f\007\b", new Object[0], 1);
    Object[] arrayOfObject4 = new Object[1];
    SimpleSymbol localSimpleSymbol4 = (SimpleSymbol)new SimpleSymbol("test-begin").readResolve();
    Lit6 = localSimpleSymbol4;
    arrayOfObject4[0] = localSimpleSymbol4;
    SyntaxRule[] arrayOfSyntaxRule2 = new SyntaxRule[2];
    SyntaxPattern localSyntaxPattern2 = new SyntaxPattern("\f\030\f\007\b", new Object[0], 1);
    Object[] arrayOfObject5 = new Object[4];
    arrayOfObject5[0] = Lit25;
    arrayOfObject5[1] = PairWithPosition.make(Lit27, PairWithPosition.make(PairWithPosition.make(Lit26, PairWithPosition.make(Values.empty, LList.Empty, "misc_syntax.scm", 86046), "misc_syntax.scm", 86037), PairWithPosition.make(PairWithPosition.make(Lit28, PairWithPosition.make(PairWithPosition.make(Lit29, PairWithPosition.make(PairWithPosition.make(Lit30, PairWithPosition.make(Lit26, LList.Empty, "misc_syntax.scm", 86070), "misc_syntax.scm", 86070), LList.Empty, "misc_syntax.scm", 86069), "misc_syntax.scm", 86060), LList.Empty, "misc_syntax.scm", 86060), "misc_syntax.scm", 86054), LList.Empty, "misc_syntax.scm", 86054), "misc_syntax.scm", 86037), "misc_syntax.scm", 86024);
    arrayOfObject5[2] = Lit31;
    arrayOfObject5[3] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "misc_syntax.scm", 90144);
    arrayOfSyntaxRule2[0] = new SyntaxRule(localSyntaxPattern2, "\001", "\021\030\004\021\030\f\b\021\030\024\t\003\030\034", arrayOfObject5, 0);
    SyntaxPattern localSyntaxPattern3 = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject6 = new Object[3];
    arrayOfObject6[0] = Lit25;
    arrayOfObject6[1] = PairWithPosition.make(Lit27, PairWithPosition.make(PairWithPosition.make(Lit26, PairWithPosition.make(Values.empty, LList.Empty, "misc_syntax.scm", 102430), "misc_syntax.scm", 102421), PairWithPosition.make(PairWithPosition.make(Lit28, PairWithPosition.make(PairWithPosition.make(Lit29, PairWithPosition.make(PairWithPosition.make(Lit30, PairWithPosition.make(Lit26, LList.Empty, "misc_syntax.scm", 102454), "misc_syntax.scm", 102454), LList.Empty, "misc_syntax.scm", 102453), "misc_syntax.scm", 102444), LList.Empty, "misc_syntax.scm", 102444), "misc_syntax.scm", 102438), LList.Empty, "misc_syntax.scm", 102438), "misc_syntax.scm", 102421), "misc_syntax.scm", 102408);
    arrayOfObject6[2] = Lit31;
    arrayOfSyntaxRule2[1] = new SyntaxRule(localSyntaxPattern3, "\001\001", "\021\030\004\021\030\f\b\021\030\024\t\003\b\013", arrayOfObject6, 0);
    Lit7 = new SyntaxRules(arrayOfObject4, arrayOfSyntaxRule2, 2);
    Lit5 = new SyntaxPattern("\f\007\013", new Object[0], 2);
    Object[] arrayOfObject7 = new Object[1];
    arrayOfObject7[0] = PairWithPosition.make((SimpleSymbol)new SimpleSymbol("::").readResolve(), PairWithPosition.make((SimpleSymbol)new SimpleSymbol("<int>").readResolve(), PairWithPosition.make(IntNum.make(123), LList.Empty, "misc_syntax.scm", 53270), "misc_syntax.scm", 53264), "misc_syntax.scm", 53260);
    Lit4 = new SyntaxTemplate("\001\001\001", "\030\004", arrayOfObject7, 0);
    Lit3 = new SyntaxTemplate("\001\001\001", "\023", new Object[0], 0);
    Object[] arrayOfObject8 = new Object[1];
    arrayOfObject8[0] = ((SimpleSymbol)new SimpleSymbol("define-constant").readResolve());
    Lit2 = new SyntaxTemplate("\001\001\001", "\030\004", arrayOfObject8, 0);
    Lit1 = new SyntaxPattern("\f\007,\f\017\f\027\b\b", new Object[0], 3);
    Lit0 = (SimpleSymbol)new SimpleSymbol("provide").readResolve();
    $instance = new misc_syntax();
    $Prvt$define$Mnconstant = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnconstant");
    SimpleSymbol localSimpleSymbol5 = Lit0;
    misc_syntax localmisc_syntax = $instance;
    provide = Macro.make(localSimpleSymbol5, new ModuleMethod(localmisc_syntax, 1, null, 4097), $instance);
    test$Mnbegin = Macro.make(Lit6, Lit7, $instance);
    SimpleSymbol localSimpleSymbol6 = Lit8;
    ModuleMethod localModuleMethod1 = new ModuleMethod(localmisc_syntax, 2, null, 4097);
    localModuleMethod1.setProperty("source-location", "misc_syntax.scm:29");
    module$Mnuri = Macro.make(localSimpleSymbol6, localModuleMethod1, $instance);
    resource$Mnurl = Macro.make(Lit10, Lit11, $instance);
    SimpleSymbol localSimpleSymbol7 = Lit12;
    ModuleMethod localModuleMethod2 = new ModuleMethod(localmisc_syntax, 3, null, 4097);
    localModuleMethod2.setProperty("source-location", "misc_syntax.scm:54");
    include = Macro.make(localSimpleSymbol7, localModuleMethod2, $instance);
    include$Mnrelative = Macro.make(Lit18, new ModuleMethod(localmisc_syntax, 4, null, 4097), $instance);
    $instance.run();
  }

  public misc_syntax()
  {
    ModuleInfo.register(this);
  }

  static Object lambda1(Object paramObject)
  {
    Object[] arrayOfObject1 = SyntaxPattern.allocVars(3, null);
    Object localObject1;
    Object[] arrayOfObject3;
    Object localObject2;
    if (Lit1.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      localObject1 = Lit2.execute(arrayOfObject1, localTemplateScope1);
      arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = "%provide%";
      TemplateScope localTemplateScope2 = TemplateScope.make();
      localObject2 = std_syntax.syntaxObject$To$Datum(Lit3.execute(arrayOfObject1, localTemplateScope2));
    }
    try
    {
      Symbol localSymbol = (Symbol)localObject2;
      arrayOfObject3[1] = misc.symbol$To$String(localSymbol);
      Object localObject3 = std_syntax.datum$To$SyntaxObject(paramObject, misc.string$To$Symbol(strings.stringAppend(arrayOfObject3)));
      TemplateScope localTemplateScope3 = TemplateScope.make();
      return lists.cons(localObject1, lists.cons(localObject3, Lit4.execute(arrayOfObject1, localTemplateScope3)));
      if (Lit5.match(paramObject, arrayOfObject1, 0))
      {
        if (("provide requires a quoted feature-name" instanceof Object[]));
        for (Object[] arrayOfObject2 = (Object[])"provide requires a quoted feature-name"; ; arrayOfObject2 = new Object[] { "provide requires a quoted feature-name" })
          return prim_syntax.syntaxError(paramObject, arrayOfObject2);
      }
      return syntax_case.error("syntax-case", paramObject);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "symbol->string", 1, localObject2);
    }
  }

  static Object lambda2(Object paramObject)
  {
    Object[] arrayOfObject = SyntaxPattern.allocVars(1, null);
    if (Lit9.match(paramObject, arrayOfObject, 0))
      return GetModuleClass.getModuleClassURI(Compilation.getCurrent());
    return syntax_case.error("syntax-case", paramObject);
  }

  static Object lambda3(Object paramObject)
  {
    Object[] arrayOfObject1 = SyntaxPattern.allocVars(2, null);
    Object localObject1;
    frame localframe;
    if (Lit13.match(paramObject, arrayOfObject1, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      localObject1 = std_syntax.syntaxObject$To$Datum(Lit14.execute(arrayOfObject1, localTemplateScope1));
      TemplateScope localTemplateScope2 = TemplateScope.make();
      Object localObject2 = Lit15.execute(arrayOfObject1, localTemplateScope2);
      localframe = new frame();
      localframe.k = localObject2;
    }
    try
    {
      Path localPath = Path.valueOf(localObject1);
      localframe.p = ports.openInputFile(localPath);
      Object localObject3 = localframe.lambda4f();
      Object[] arrayOfObject2 = SyntaxPattern.allocVars(3, arrayOfObject1);
      if (Lit16.match(localObject3, arrayOfObject2, 0))
      {
        TemplateScope localTemplateScope3 = TemplateScope.make();
        return Lit17.execute(arrayOfObject2, localTemplateScope3);
      }
      return syntax_case.error("syntax-case", localObject3);
      return syntax_case.error("syntax-case", paramObject);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "open-input-file", 1, localObject1);
    }
  }

  static Object lambda5(Object paramObject)
  {
    Object[] arrayOfObject = SyntaxPattern.allocVars(2, null);
    Object localObject1;
    if (Lit19.match(paramObject, arrayOfObject, 0))
    {
      TemplateScope localTemplateScope1 = TemplateScope.make();
      localObject1 = std_syntax.syntaxObject$To$Datum(Lit20.execute(arrayOfObject, localTemplateScope1));
    }
    try
    {
      PairWithPosition localPairWithPosition = (PairWithPosition)localObject1;
      Path localPath = Path.valueOf(localPairWithPosition.getFileName());
      String str = localPairWithPosition.getCar().toString();
      TemplateScope localTemplateScope2 = TemplateScope.make();
      Object localObject2 = std_syntax.datum$To$SyntaxObject(Lit21.execute(arrayOfObject, localTemplateScope2), Lit12);
      TemplateScope localTemplateScope3 = TemplateScope.make();
      return LList.list2(localObject2, std_syntax.datum$To$SyntaxObject(Lit22.execute(arrayOfObject, localTemplateScope3), localPath.resolve(str).toString()));
      return syntax_case.error("syntax-case", paramObject);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "path-pair", -2, localObject1);
    }
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply1(paramModuleMethod, paramObject);
    case 1:
      return lambda1(paramObject);
    case 2:
      return lambda2(paramObject);
    case 3:
      return lambda3(paramObject);
    case 4:
    }
    return lambda5(paramObject);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 4:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
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

  public final void run(CallContext paramCallContext)
  {
  }

  public class frame extends ModuleBody
  {
    Object k;
    InPort p;

    public Object lambda4f()
    {
      Object localObject = ports.read(this.p);
      if (ports.isEofObject(localObject))
      {
        ports.closeInputPort(this.p);
        return LList.Empty;
      }
      return new Pair(std_syntax.datum$To$SyntaxObject(this.k, localObject), lambda4f());
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.misc_syntax
 * JD-Core Version:    0.6.2
 */