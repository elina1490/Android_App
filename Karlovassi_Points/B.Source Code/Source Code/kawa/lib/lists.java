package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.SlotSet;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import kawa.standard.Scheme;

public class lists extends ModuleBody
{
  public static final Location $Prvt$define$Mnprocedure;
  public static final lists $instance;
  static final Keyword Lit0;
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
  static final SimpleSymbol Lit19 = (SimpleSymbol)new SimpleSymbol("assoc").readResolve();
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod assoc;
  public static final ModuleMethod assq;
  public static final ModuleMethod assv;
  public static final GenericProc caaaar;
  static final ModuleMethod caaaar$Fn28;
  public static final GenericProc caaadr;
  static final ModuleMethod caaadr$Fn30;
  public static final GenericProc caaar;
  static final ModuleMethod caaar$Fn12;
  public static final GenericProc caadar;
  static final ModuleMethod caadar$Fn32;
  public static final GenericProc caaddr;
  static final ModuleMethod caaddr$Fn34;
  public static final GenericProc caadr;
  static final ModuleMethod caadr$Fn14;
  public static final GenericProc caar;
  static final ModuleMethod caar$Fn4;
  public static final GenericProc cadaar;
  static final ModuleMethod cadaar$Fn36;
  public static final GenericProc cadadr;
  static final ModuleMethod cadadr$Fn38;
  public static final GenericProc cadar;
  static final ModuleMethod cadar$Fn16;
  public static final GenericProc caddar;
  static final ModuleMethod caddar$Fn40;
  public static final GenericProc cadddr;
  static final ModuleMethod cadddr$Fn42;
  public static final GenericProc caddr;
  static final ModuleMethod caddr$Fn18;
  public static final GenericProc cadr;
  static final ModuleMethod cadr$Fn6;
  public static final GenericProc car;
  static final ModuleMethod car$Fn1;
  public static final GenericProc cdaaar;
  static final ModuleMethod cdaaar$Fn44;
  public static final GenericProc cdaadr;
  static final ModuleMethod cdaadr$Fn46;
  public static final GenericProc cdaar;
  static final ModuleMethod cdaar$Fn20;
  public static final GenericProc cdadar;
  static final ModuleMethod cdadar$Fn48;
  public static final GenericProc cdaddr;
  static final ModuleMethod cdaddr$Fn50;
  public static final GenericProc cdadr;
  static final ModuleMethod cdadr$Fn22;
  public static final GenericProc cdar;
  static final ModuleMethod cdar$Fn8;
  public static final GenericProc cddaar;
  static final ModuleMethod cddaar$Fn52;
  public static final GenericProc cddadr;
  static final ModuleMethod cddadr$Fn54;
  public static final GenericProc cddar;
  static final ModuleMethod cddar$Fn24;
  public static final GenericProc cdddar;
  static final ModuleMethod cdddar$Fn56;
  public static final GenericProc cddddr;
  static final ModuleMethod cddddr$Fn58;
  public static final GenericProc cdddr;
  static final ModuleMethod cdddr$Fn26;
  public static final GenericProc cddr;
  static final ModuleMethod cddr$Fn10;
  public static final GenericProc cdr;
  static final ModuleMethod cdr$Fn2;
  public static final ModuleMethod cons;
  static final ModuleMethod lambda$Fn11;
  static final ModuleMethod lambda$Fn13;
  static final ModuleMethod lambda$Fn15;
  static final ModuleMethod lambda$Fn17;
  static final ModuleMethod lambda$Fn19;
  static final ModuleMethod lambda$Fn21;
  static final ModuleMethod lambda$Fn23;
  static final ModuleMethod lambda$Fn25;
  static final ModuleMethod lambda$Fn27;
  static final ModuleMethod lambda$Fn29;
  static final ModuleMethod lambda$Fn3;
  static final ModuleMethod lambda$Fn31;
  static final ModuleMethod lambda$Fn33;
  static final ModuleMethod lambda$Fn35;
  static final ModuleMethod lambda$Fn37;
  static final ModuleMethod lambda$Fn39;
  static final ModuleMethod lambda$Fn41;
  static final ModuleMethod lambda$Fn43;
  static final ModuleMethod lambda$Fn45;
  static final ModuleMethod lambda$Fn47;
  static final ModuleMethod lambda$Fn49;
  static final ModuleMethod lambda$Fn5;
  static final ModuleMethod lambda$Fn51;
  static final ModuleMethod lambda$Fn53;
  static final ModuleMethod lambda$Fn55;
  static final ModuleMethod lambda$Fn57;
  static final ModuleMethod lambda$Fn7;
  static final ModuleMethod lambda$Fn9;
  public static final ModuleMethod length;
  public static final ModuleMethod list$Mnref;
  public static final ModuleMethod list$Mntail;
  public static final ModuleMethod list$Qu;
  public static final ModuleMethod member;
  public static final ModuleMethod memq;
  public static final ModuleMethod memv;
  public static final ModuleMethod null$Qu;
  public static final ModuleMethod pair$Qu;
  public static final ModuleMethod reverse;
  public static final ModuleMethod reverse$Ex;
  public static final ModuleMethod set$Mncar$Ex;
  public static final ModuleMethod set$Mncdr$Ex;

  static
  {
    Lit18 = (SimpleSymbol)new SimpleSymbol("assv").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("assq").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("member").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("memv").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("memq").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("reverse!").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("list?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("list-ref").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("list-tail").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("reverse").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("length").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("set-cdr!").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("set-car!").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("null?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("cons").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("pair?").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("cdr").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("car").readResolve();
    Lit0 = Keyword.make("setter");
    $instance = new lists();
    $Prvt$define$Mnprocedure = StaticFieldLocation.make("kawa.lib.std_syntax", "define$Mnprocedure");
    lists locallists = $instance;
    pair$Qu = new ModuleMethod(locallists, 1, Lit3, 4097);
    cons = new ModuleMethod(locallists, 2, Lit4, 8194);
    null$Qu = new ModuleMethod(locallists, 3, Lit5, 4097);
    set$Mncar$Ex = new ModuleMethod(locallists, 4, Lit6, 8194);
    set$Mncdr$Ex = new ModuleMethod(locallists, 5, Lit7, 8194);
    ModuleMethod localModuleMethod1 = new ModuleMethod(locallists, 6, "car", 4097);
    localModuleMethod1.setProperty("source-location", "lists.scm:31");
    car$Fn1 = localModuleMethod1;
    ModuleMethod localModuleMethod2 = new ModuleMethod(locallists, 7, "cdr", 4097);
    localModuleMethod2.setProperty("source-location", "lists.scm:36");
    cdr$Fn2 = localModuleMethod2;
    lambda$Fn3 = new ModuleMethod(locallists, 8, null, 8194);
    caar$Fn4 = new ModuleMethod(locallists, 9, "caar", 4097);
    lambda$Fn5 = new ModuleMethod(locallists, 10, null, 8194);
    cadr$Fn6 = new ModuleMethod(locallists, 11, "cadr", 4097);
    lambda$Fn7 = new ModuleMethod(locallists, 12, null, 8194);
    cdar$Fn8 = new ModuleMethod(locallists, 13, "cdar", 4097);
    lambda$Fn9 = new ModuleMethod(locallists, 14, null, 8194);
    cddr$Fn10 = new ModuleMethod(locallists, 15, "cddr", 4097);
    lambda$Fn11 = new ModuleMethod(locallists, 16, null, 8194);
    caaar$Fn12 = new ModuleMethod(locallists, 17, "caaar", 4097);
    lambda$Fn13 = new ModuleMethod(locallists, 18, null, 8194);
    caadr$Fn14 = new ModuleMethod(locallists, 19, "caadr", 4097);
    lambda$Fn15 = new ModuleMethod(locallists, 20, null, 8194);
    cadar$Fn16 = new ModuleMethod(locallists, 21, "cadar", 4097);
    lambda$Fn17 = new ModuleMethod(locallists, 22, null, 8194);
    caddr$Fn18 = new ModuleMethod(locallists, 23, "caddr", 4097);
    lambda$Fn19 = new ModuleMethod(locallists, 24, null, 8194);
    cdaar$Fn20 = new ModuleMethod(locallists, 25, "cdaar", 4097);
    lambda$Fn21 = new ModuleMethod(locallists, 26, null, 8194);
    cdadr$Fn22 = new ModuleMethod(locallists, 27, "cdadr", 4097);
    lambda$Fn23 = new ModuleMethod(locallists, 28, null, 8194);
    cddar$Fn24 = new ModuleMethod(locallists, 29, "cddar", 4097);
    lambda$Fn25 = new ModuleMethod(locallists, 30, null, 8194);
    cdddr$Fn26 = new ModuleMethod(locallists, 31, "cdddr", 4097);
    lambda$Fn27 = new ModuleMethod(locallists, 32, null, 8194);
    caaaar$Fn28 = new ModuleMethod(locallists, 33, "caaaar", 4097);
    lambda$Fn29 = new ModuleMethod(locallists, 34, null, 8194);
    caaadr$Fn30 = new ModuleMethod(locallists, 35, "caaadr", 4097);
    lambda$Fn31 = new ModuleMethod(locallists, 36, null, 8194);
    caadar$Fn32 = new ModuleMethod(locallists, 37, "caadar", 4097);
    lambda$Fn33 = new ModuleMethod(locallists, 38, null, 8194);
    caaddr$Fn34 = new ModuleMethod(locallists, 39, "caaddr", 4097);
    lambda$Fn35 = new ModuleMethod(locallists, 40, null, 8194);
    cadaar$Fn36 = new ModuleMethod(locallists, 41, "cadaar", 4097);
    lambda$Fn37 = new ModuleMethod(locallists, 42, null, 8194);
    cadadr$Fn38 = new ModuleMethod(locallists, 43, "cadadr", 4097);
    lambda$Fn39 = new ModuleMethod(locallists, 44, null, 8194);
    caddar$Fn40 = new ModuleMethod(locallists, 45, "caddar", 4097);
    lambda$Fn41 = new ModuleMethod(locallists, 46, null, 8194);
    cadddr$Fn42 = new ModuleMethod(locallists, 47, "cadddr", 4097);
    lambda$Fn43 = new ModuleMethod(locallists, 48, null, 8194);
    cdaaar$Fn44 = new ModuleMethod(locallists, 49, "cdaaar", 4097);
    lambda$Fn45 = new ModuleMethod(locallists, 50, null, 8194);
    cdaadr$Fn46 = new ModuleMethod(locallists, 51, "cdaadr", 4097);
    lambda$Fn47 = new ModuleMethod(locallists, 52, null, 8194);
    cdadar$Fn48 = new ModuleMethod(locallists, 53, "cdadar", 4097);
    lambda$Fn49 = new ModuleMethod(locallists, 54, null, 8194);
    cdaddr$Fn50 = new ModuleMethod(locallists, 55, "cdaddr", 4097);
    lambda$Fn51 = new ModuleMethod(locallists, 56, null, 8194);
    cddaar$Fn52 = new ModuleMethod(locallists, 57, "cddaar", 4097);
    lambda$Fn53 = new ModuleMethod(locallists, 58, null, 8194);
    cddadr$Fn54 = new ModuleMethod(locallists, 59, "cddadr", 4097);
    lambda$Fn55 = new ModuleMethod(locallists, 60, null, 8194);
    cdddar$Fn56 = new ModuleMethod(locallists, 61, "cdddar", 4097);
    lambda$Fn57 = new ModuleMethod(locallists, 62, null, 8194);
    cddddr$Fn58 = new ModuleMethod(locallists, 63, "cddddr", 4097);
    length = new ModuleMethod(locallists, 64, Lit8, 4097);
    reverse = new ModuleMethod(locallists, 65, Lit9, 4097);
    list$Mntail = new ModuleMethod(locallists, 66, Lit10, 8194);
    list$Mnref = new ModuleMethod(locallists, 67, Lit11, 8194);
    list$Qu = new ModuleMethod(locallists, 68, Lit12, 4097);
    reverse$Ex = new ModuleMethod(locallists, 69, Lit13, 4097);
    memq = new ModuleMethod(locallists, 70, Lit14, 8194);
    memv = new ModuleMethod(locallists, 71, Lit15, 8194);
    member = new ModuleMethod(locallists, 72, Lit16, 12290);
    assq = new ModuleMethod(locallists, 74, Lit17, 8194);
    assv = new ModuleMethod(locallists, 75, Lit18, 8194);
    assoc = new ModuleMethod(locallists, 76, Lit19, 12290);
    $instance.run();
  }

  public lists()
  {
    ModuleInfo.register(this);
  }

  public static Object assoc(Object paramObject1, Object paramObject2)
  {
    return assoc(paramObject1, paramObject2, Scheme.isEqual);
  }

  public static Object assoc(Object paramObject1, Object paramObject2, Procedure paramProcedure)
  {
    while (true)
    {
      if (paramObject2 == LList.Empty)
        return Boolean.FALSE;
      Object localObject = car.apply1(paramObject2);
      try
      {
        Pair localPair = (Pair)localObject;
        if (paramProcedure.apply2(localPair.getCar(), paramObject1) != Boolean.FALSE)
          return localPair;
        paramObject2 = cdr.apply1(paramObject2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "pair", -2, localObject);
      }
    }
  }

  public static Object assq(Object paramObject1, Object paramObject2)
  {
    while (true)
    {
      if (paramObject2 == LList.Empty)
        return Boolean.FALSE;
      Object localObject = car.apply1(paramObject2);
      try
      {
        Pair localPair = (Pair)localObject;
        if (localPair.getCar() == paramObject1)
          return localPair;
        paramObject2 = cdr.apply1(paramObject2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "pair", -2, localObject);
      }
    }
  }

  public static Object assv(Object paramObject1, Object paramObject2)
  {
    while (true)
    {
      if (paramObject2 == LList.Empty)
        return Boolean.FALSE;
      Object localObject = car.apply1(paramObject2);
      try
      {
        Pair localPair = (Pair)localObject;
        if (Scheme.isEqv.apply2(localPair.getCar(), paramObject1) != Boolean.FALSE)
          return localPair;
        paramObject2 = cdr.apply1(paramObject2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "pair", -2, localObject);
      }
    }
  }

  static Object caaaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCar()).getCar();
  }

  static Object caaadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCar()).getCar();
  }

  static Object caaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCar();
  }

  static Object caadar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCar()).getCar();
  }

  static Object caaddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCar()).getCar();
  }

  static Object caadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCar();
  }

  static Object caar(Object paramObject)
  {
    return ((Pair)((Pair)paramObject).getCar()).getCar();
  }

  static Object cadaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCdr()).getCar();
  }

  static Object cadadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCdr()).getCar();
  }

  static Object cadar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCar();
  }

  static Object caddar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCdr()).getCar();
  }

  static Object cadddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCdr()).getCar();
  }

  static Object caddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCar();
  }

  static Object cadr(Object paramObject)
  {
    return ((Pair)((Pair)paramObject).getCdr()).getCar();
  }

  static Object car(Pair paramPair)
  {
    return paramPair.getCar();
  }

  static Object cdaaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCar()).getCdr();
  }

  static Object cdaadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCar()).getCdr();
  }

  static Object cdaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCdr();
  }

  static Object cdadar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCar()).getCdr();
  }

  static Object cdaddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCar()).getCdr();
  }

  static Object cdadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCdr();
  }

  static Object cdar(Object paramObject)
  {
    return ((Pair)((Pair)paramObject).getCar()).getCdr();
  }

  static Object cddaar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCar()).getCdr()).getCdr();
  }

  static Object cddadr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCar()).getCdr()).getCdr();
  }

  static Object cddar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCdr();
  }

  static Object cdddar(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCar()).getCdr()).getCdr()).getCdr();
  }

  static Object cddddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCdr()).getCdr();
  }

  static Object cdddr(Object paramObject)
  {
    return ((Pair)((Pair)((Pair)paramObject).getCdr()).getCdr()).getCdr();
  }

  static Object cddr(Object paramObject)
  {
    return ((Pair)((Pair)paramObject).getCdr()).getCdr();
  }

  static Object cdr(Pair paramPair)
  {
    return paramPair.getCdr();
  }

  public static Pair cons(Object paramObject1, Object paramObject2)
  {
    return new Pair(paramObject1, paramObject2);
  }

  public static boolean isList(Object paramObject)
  {
    return LList.listLength(paramObject, false) >= 0;
  }

  public static boolean isNull(Object paramObject)
  {
    return paramObject == LList.Empty;
  }

  public static boolean isPair(Object paramObject)
  {
    return paramObject instanceof Pair;
  }

  static void lambda1(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)paramObject1).getCar(), Lit1, paramObject2);
  }

  static void lambda10(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCdr()).getCar(), Lit2, paramObject2);
  }

  static void lambda11(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCar()).getCdr(), Lit2, paramObject2);
  }

  static void lambda12(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCdr()).getCdr(), Lit2, paramObject2);
  }

  static void lambda13(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCar()).getCar(), Lit1, paramObject2);
  }

  static void lambda14(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCar()).getCar(), Lit1, paramObject2);
  }

  static void lambda15(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCdr()).getCar(), Lit1, paramObject2);
  }

  static void lambda16(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCdr()).getCar(), Lit1, paramObject2);
  }

  static void lambda17(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCar()).getCdr(), Lit1, paramObject2);
  }

  static void lambda18(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCar()).getCdr(), Lit1, paramObject2);
  }

  static void lambda19(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCdr()).getCdr(), Lit1, paramObject2);
  }

  static void lambda2(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)paramObject1).getCdr(), Lit1, paramObject2);
  }

  static void lambda20(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCdr()).getCdr(), Lit1, paramObject2);
  }

  static void lambda21(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCar()).getCar(), Lit2, paramObject2);
  }

  static void lambda22(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCar()).getCar(), Lit2, paramObject2);
  }

  static void lambda23(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCdr()).getCar(), Lit2, paramObject2);
  }

  static void lambda24(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCdr()).getCar(), Lit2, paramObject2);
  }

  static void lambda25(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCar()).getCdr(), Lit2, paramObject2);
  }

  static void lambda26(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCar()).getCdr(), Lit2, paramObject2);
  }

  static void lambda27(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCar()).getCdr()).getCdr(), Lit2, paramObject2);
  }

  static void lambda28(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)paramObject1).getCdr()).getCdr()).getCdr(), Lit2, paramObject2);
  }

  static void lambda3(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)paramObject1).getCar(), Lit2, paramObject2);
  }

  static void lambda4(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)paramObject1).getCdr(), Lit2, paramObject2);
  }

  static void lambda5(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCar()).getCar(), Lit1, paramObject2);
  }

  static void lambda6(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCdr()).getCar(), Lit1, paramObject2);
  }

  static void lambda7(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCar()).getCdr(), Lit1, paramObject2);
  }

  static void lambda8(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCdr()).getCdr(), Lit1, paramObject2);
  }

  static void lambda9(Object paramObject1, Object paramObject2)
  {
    SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)paramObject1).getCar()).getCar(), Lit2, paramObject2);
  }

  public static int length(LList paramLList)
  {
    return LList.length(paramLList);
  }

  public static Object listRef(Object paramObject, int paramInt)
  {
    return car.apply1(listTail(paramObject, paramInt));
  }

  public static Object listTail(Object paramObject, int paramInt)
  {
    return LList.listTail(paramObject, paramInt);
  }

  public static Object member(Object paramObject1, Object paramObject2)
  {
    return member(paramObject1, paramObject2, Scheme.isEqual);
  }

  public static Object member(Object paramObject1, Object paramObject2, Procedure paramProcedure)
  {
    Object localObject = paramObject2;
    while (true)
    {
      boolean bool = localObject instanceof Pair;
      if (bool);
      try
      {
        Pair localPair = (Pair)localObject;
        if (paramProcedure.apply2(paramObject1, localPair.getCar()) != Boolean.FALSE)
          return localObject;
        localObject = localPair.getCdr();
        continue;
        if (bool)
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "p", -2, localObject);
      }
    }
  }

  public static Object memq(Object paramObject1, Object paramObject2)
  {
    Object localObject = paramObject2;
    while (true)
    {
      boolean bool = localObject instanceof Pair;
      if (bool);
      try
      {
        Pair localPair = (Pair)localObject;
        if (paramObject1 == localPair.getCar())
          return localObject;
        localObject = localPair.getCdr();
        continue;
        if (bool)
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "p", -2, localObject);
      }
    }
  }

  public static Object memv(Object paramObject1, Object paramObject2)
  {
    Object localObject = paramObject2;
    while (true)
    {
      boolean bool = localObject instanceof Pair;
      if (bool);
      try
      {
        Pair localPair = (Pair)localObject;
        if (Scheme.isEqv.apply2(paramObject1, localPair.getCar()) != Boolean.FALSE)
          return localObject;
        localObject = localPair.getCdr();
        continue;
        if (bool)
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "p", -2, localObject);
      }
    }
  }

  public static LList reverse(LList paramLList)
  {
    LList localLList = LList.Empty;
    Object localObject1 = paramLList;
    Object localObject2 = localLList;
    while (true)
    {
      if (isNull(localObject1))
        return (LList)localObject2;
      try
      {
        Pair localPair = (Pair)localObject1;
        localObject1 = cdr.apply1(localPair);
        localObject2 = cons(car.apply1(localPair), localObject2);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "pair", -2, localObject1);
      }
    }
  }

  public static LList reverse$Ex(LList paramLList)
  {
    return LList.reverseInPlace(paramLList);
  }

  public static void setCar$Ex(Pair paramPair, Object paramObject)
  {
    paramPair.setCar(paramObject);
  }

  public static void setCdr$Ex(Pair paramPair, Object paramObject)
  {
    paramPair.setCdr(paramObject);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 590	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+292 -> 296, 1:+299->303, 2:+292->296, 3:+314->318, 4:+292->296, 5:+292->296, 6:+329->333, 7:+341->345, 8:+292->296, 9:+353->357, 10:+292->296, 11:+358->362, 12:+292->296, 13:+363->367, 14:+292->296, 15:+368->372, 16:+292->296, 17:+373->377, 18:+292->296, 19:+378->382, 20:+292->296, 21:+383->387, 22:+292->296, 23:+388->392, 24:+292->296, 25:+393->397, 26:+292->296, 27:+398->402, 28:+292->296, 29:+403->407, 30:+292->296, 31:+408->412, 32:+292->296, 33:+413->417, 34:+292->296, 35:+418->422, 36:+292->296, 37:+423->427, 38:+292->296, 39:+428->432, 40:+292->296, 41:+433->437, 42:+292->296, 43:+438->442, 44:+292->296, 45:+443->447, 46:+292->296, 47:+448->452, 48:+292->296, 49:+453->457, 50:+292->296, 51:+458->462, 52:+292->296, 53:+463->467, 54:+292->296, 55:+468->472, 56:+292->296, 57:+473->477, 58:+292->296, 59:+478->482, 60:+292->296, 61:+483->487, 62:+292->296, 63:+488->492, 64:+493->497, 65:+508->512, 66:+292->296, 67:+292->296, 68:+520->524, 69:+535->539
    //   297: aload_1
    //   298: aload_2
    //   299: invokespecial 592	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   302: areturn
    //   303: aload_2
    //   304: invokestatic 594	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   307: ifeq +7 -> 314
    //   310: getstatic 565	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   313: areturn
    //   314: getstatic 468	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   317: areturn
    //   318: aload_2
    //   319: invokestatic 570	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   322: ifeq +7 -> 329
    //   325: getstatic 565	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   328: areturn
    //   329: getstatic 468	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   332: areturn
    //   333: aload_2
    //   334: checkcast 478	gnu/lists/Pair
    //   337: astore 12
    //   339: aload 12
    //   341: invokestatic 596	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   344: areturn
    //   345: aload_2
    //   346: checkcast 478	gnu/lists/Pair
    //   349: astore 10
    //   351: aload 10
    //   353: invokestatic 598	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   356: areturn
    //   357: aload_2
    //   358: invokestatic 600	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   361: areturn
    //   362: aload_2
    //   363: invokestatic 602	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   366: areturn
    //   367: aload_2
    //   368: invokestatic 604	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   371: areturn
    //   372: aload_2
    //   373: invokestatic 606	kawa/lib/lists:cddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   376: areturn
    //   377: aload_2
    //   378: invokestatic 608	kawa/lib/lists:caaar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   381: areturn
    //   382: aload_2
    //   383: invokestatic 610	kawa/lib/lists:caadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   386: areturn
    //   387: aload_2
    //   388: invokestatic 612	kawa/lib/lists:cadar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   391: areturn
    //   392: aload_2
    //   393: invokestatic 614	kawa/lib/lists:caddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   396: areturn
    //   397: aload_2
    //   398: invokestatic 616	kawa/lib/lists:cdaar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   401: areturn
    //   402: aload_2
    //   403: invokestatic 618	kawa/lib/lists:cdadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   406: areturn
    //   407: aload_2
    //   408: invokestatic 620	kawa/lib/lists:cddar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   411: areturn
    //   412: aload_2
    //   413: invokestatic 622	kawa/lib/lists:cdddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   416: areturn
    //   417: aload_2
    //   418: invokestatic 624	kawa/lib/lists:caaaar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   421: areturn
    //   422: aload_2
    //   423: invokestatic 626	kawa/lib/lists:caaadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   426: areturn
    //   427: aload_2
    //   428: invokestatic 628	kawa/lib/lists:caadar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   431: areturn
    //   432: aload_2
    //   433: invokestatic 630	kawa/lib/lists:caaddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   436: areturn
    //   437: aload_2
    //   438: invokestatic 632	kawa/lib/lists:cadaar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   441: areturn
    //   442: aload_2
    //   443: invokestatic 634	kawa/lib/lists:cadadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   446: areturn
    //   447: aload_2
    //   448: invokestatic 636	kawa/lib/lists:caddar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   451: areturn
    //   452: aload_2
    //   453: invokestatic 638	kawa/lib/lists:cadddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   456: areturn
    //   457: aload_2
    //   458: invokestatic 640	kawa/lib/lists:cdaaar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   461: areturn
    //   462: aload_2
    //   463: invokestatic 642	kawa/lib/lists:cdaadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   466: areturn
    //   467: aload_2
    //   468: invokestatic 644	kawa/lib/lists:cdadar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   471: areturn
    //   472: aload_2
    //   473: invokestatic 646	kawa/lib/lists:cdaddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   476: areturn
    //   477: aload_2
    //   478: invokestatic 648	kawa/lib/lists:cddaar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   481: areturn
    //   482: aload_2
    //   483: invokestatic 650	kawa/lib/lists:cddadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   486: areturn
    //   487: aload_2
    //   488: invokestatic 652	kawa/lib/lists:cdddar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   491: areturn
    //   492: aload_2
    //   493: invokestatic 654	kawa/lib/lists:cddddr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   496: areturn
    //   497: aload_2
    //   498: checkcast 458	gnu/lists/LList
    //   501: astore 8
    //   503: aload 8
    //   505: invokestatic 656	kawa/lib/lists:length	(Lgnu/lists/LList;)I
    //   508: invokestatic 662	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: areturn
    //   512: aload_2
    //   513: checkcast 458	gnu/lists/LList
    //   516: astore 6
    //   518: aload 6
    //   520: invokestatic 664	kawa/lib/lists:reverse	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   523: areturn
    //   524: aload_2
    //   525: invokestatic 666	kawa/lib/lists:isList	(Ljava/lang/Object;)Z
    //   528: ifeq +7 -> 535
    //   531: getstatic 565	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   534: areturn
    //   535: getstatic 468	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   538: areturn
    //   539: aload_2
    //   540: checkcast 458	gnu/lists/LList
    //   543: astore 4
    //   545: aload 4
    //   547: invokestatic 668	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   550: areturn
    //   551: astore 11
    //   553: new 488	gnu/mapping/WrongType
    //   556: dup
    //   557: aload 11
    //   559: ldc 212
    //   561: iconst_1
    //   562: aload_2
    //   563: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   566: athrow
    //   567: astore 9
    //   569: new 488	gnu/mapping/WrongType
    //   572: dup
    //   573: aload 9
    //   575: ldc 209
    //   577: iconst_1
    //   578: aload_2
    //   579: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   582: athrow
    //   583: astore 7
    //   585: new 488	gnu/mapping/WrongType
    //   588: dup
    //   589: aload 7
    //   591: ldc 187
    //   593: iconst_1
    //   594: aload_2
    //   595: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   598: athrow
    //   599: astore 5
    //   601: new 488	gnu/mapping/WrongType
    //   604: dup
    //   605: aload 5
    //   607: ldc 184
    //   609: iconst_1
    //   610: aload_2
    //   611: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   614: athrow
    //   615: astore_3
    //   616: new 488	gnu/mapping/WrongType
    //   619: dup
    //   620: aload_3
    //   621: ldc 169
    //   623: iconst_1
    //   624: aload_2
    //   625: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   628: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   333	339	551	java/lang/ClassCastException
    //   345	351	567	java/lang/ClassCastException
    //   497	503	583	java/lang/ClassCastException
    //   512	518	599	java/lang/ClassCastException
    //   539	545	615	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 590	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+316 -> 320, 2:+324->328, 3:+316->320, 4:+330->334, 5:+346->350, 6:+316->320, 7:+316->320, 8:+362->366, 9:+316->320, 10:+371->375, 11:+316->320, 12:+380->384, 13:+316->320, 14:+389->393, 15:+316->320, 16:+398->402, 17:+316->320, 18:+407->411, 19:+316->320, 20:+416->420, 21:+316->320, 22:+425->429, 23:+316->320, 24:+434->438, 25:+316->320, 26:+443->447, 27:+316->320, 28:+452->456, 29:+316->320, 30:+461->465, 31:+316->320, 32:+470->474, 33:+316->320, 34:+479->483, 35:+316->320, 36:+488->492, 37:+316->320, 38:+497->501, 39:+316->320, 40:+506->510, 41:+316->320, 42:+515->519, 43:+316->320, 44:+524->528, 45:+316->320, 46:+533->537, 47:+316->320, 48:+542->546, 49:+316->320, 50:+551->555, 51:+316->320, 52:+560->564, 53:+316->320, 54:+569->573, 55:+316->320, 56:+578->582, 57:+316->320, 58:+587->591, 59:+316->320, 60:+596->600, 61:+316->320, 62:+605->609, 63:+316->320, 64:+316->320, 65:+316->320, 66:+614->618, 67:+630->634, 68:+316->320, 69:+316->320, 70:+646->650, 71:+652->656, 72:+658->662, 73:+316->320, 74:+664->668, 75:+670->674, 76:+676->680
    //   321: aload_1
    //   322: aload_2
    //   323: aload_3
    //   324: invokespecial 671	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   327: areturn
    //   328: aload_2
    //   329: aload_3
    //   330: invokestatic 572	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   333: areturn
    //   334: aload_2
    //   335: checkcast 478	gnu/lists/Pair
    //   338: astore 11
    //   340: aload 11
    //   342: aload_3
    //   343: invokestatic 673	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   346: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   349: areturn
    //   350: aload_2
    //   351: checkcast 478	gnu/lists/Pair
    //   354: astore 9
    //   356: aload 9
    //   358: aload_3
    //   359: invokestatic 681	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   362: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   365: areturn
    //   366: aload_2
    //   367: aload_3
    //   368: invokestatic 683	kawa/lib/lists:lambda1	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   371: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   374: areturn
    //   375: aload_2
    //   376: aload_3
    //   377: invokestatic 685	kawa/lib/lists:lambda2	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   380: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   383: areturn
    //   384: aload_2
    //   385: aload_3
    //   386: invokestatic 687	kawa/lib/lists:lambda3	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   389: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   392: areturn
    //   393: aload_2
    //   394: aload_3
    //   395: invokestatic 689	kawa/lib/lists:lambda4	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   398: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   401: areturn
    //   402: aload_2
    //   403: aload_3
    //   404: invokestatic 691	kawa/lib/lists:lambda5	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   407: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   410: areturn
    //   411: aload_2
    //   412: aload_3
    //   413: invokestatic 693	kawa/lib/lists:lambda6	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   416: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   419: areturn
    //   420: aload_2
    //   421: aload_3
    //   422: invokestatic 695	kawa/lib/lists:lambda7	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   425: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   428: areturn
    //   429: aload_2
    //   430: aload_3
    //   431: invokestatic 697	kawa/lib/lists:lambda8	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   434: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   437: areturn
    //   438: aload_2
    //   439: aload_3
    //   440: invokestatic 699	kawa/lib/lists:lambda9	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   443: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   446: areturn
    //   447: aload_2
    //   448: aload_3
    //   449: invokestatic 701	kawa/lib/lists:lambda10	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   452: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   455: areturn
    //   456: aload_2
    //   457: aload_3
    //   458: invokestatic 703	kawa/lib/lists:lambda11	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   461: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   464: areturn
    //   465: aload_2
    //   466: aload_3
    //   467: invokestatic 705	kawa/lib/lists:lambda12	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   470: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   473: areturn
    //   474: aload_2
    //   475: aload_3
    //   476: invokestatic 707	kawa/lib/lists:lambda13	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   479: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   482: areturn
    //   483: aload_2
    //   484: aload_3
    //   485: invokestatic 709	kawa/lib/lists:lambda14	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   488: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   491: areturn
    //   492: aload_2
    //   493: aload_3
    //   494: invokestatic 711	kawa/lib/lists:lambda15	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   497: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   500: areturn
    //   501: aload_2
    //   502: aload_3
    //   503: invokestatic 713	kawa/lib/lists:lambda16	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   506: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   509: areturn
    //   510: aload_2
    //   511: aload_3
    //   512: invokestatic 715	kawa/lib/lists:lambda17	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   515: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   518: areturn
    //   519: aload_2
    //   520: aload_3
    //   521: invokestatic 717	kawa/lib/lists:lambda18	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   524: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   527: areturn
    //   528: aload_2
    //   529: aload_3
    //   530: invokestatic 719	kawa/lib/lists:lambda19	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   533: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   536: areturn
    //   537: aload_2
    //   538: aload_3
    //   539: invokestatic 721	kawa/lib/lists:lambda20	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   542: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   545: areturn
    //   546: aload_2
    //   547: aload_3
    //   548: invokestatic 723	kawa/lib/lists:lambda21	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   551: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   554: areturn
    //   555: aload_2
    //   556: aload_3
    //   557: invokestatic 725	kawa/lib/lists:lambda22	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   560: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   563: areturn
    //   564: aload_2
    //   565: aload_3
    //   566: invokestatic 727	kawa/lib/lists:lambda23	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   569: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   572: areturn
    //   573: aload_2
    //   574: aload_3
    //   575: invokestatic 729	kawa/lib/lists:lambda24	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   578: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   581: areturn
    //   582: aload_2
    //   583: aload_3
    //   584: invokestatic 731	kawa/lib/lists:lambda25	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   587: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   590: areturn
    //   591: aload_2
    //   592: aload_3
    //   593: invokestatic 733	kawa/lib/lists:lambda26	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   596: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   599: areturn
    //   600: aload_2
    //   601: aload_3
    //   602: invokestatic 735	kawa/lib/lists:lambda27	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   605: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   608: areturn
    //   609: aload_2
    //   610: aload_3
    //   611: invokestatic 737	kawa/lib/lists:lambda28	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   614: getstatic 679	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   617: areturn
    //   618: aload_3
    //   619: checkcast 739	java/lang/Number
    //   622: invokevirtual 743	java/lang/Number:intValue	()I
    //   625: istore 7
    //   627: aload_2
    //   628: iload 7
    //   630: invokestatic 559	kawa/lib/lists:listTail	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   633: areturn
    //   634: aload_3
    //   635: checkcast 739	java/lang/Number
    //   638: invokevirtual 743	java/lang/Number:intValue	()I
    //   641: istore 5
    //   643: aload_2
    //   644: iload 5
    //   646: invokestatic 745	kawa/lib/lists:listRef	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   649: areturn
    //   650: aload_2
    //   651: aload_3
    //   652: invokestatic 747	kawa/lib/lists:memq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   655: areturn
    //   656: aload_2
    //   657: aload_3
    //   658: invokestatic 749	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   661: areturn
    //   662: aload_2
    //   663: aload_3
    //   664: invokestatic 751	kawa/lib/lists:member	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   667: areturn
    //   668: aload_2
    //   669: aload_3
    //   670: invokestatic 753	kawa/lib/lists:assq	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   673: areturn
    //   674: aload_2
    //   675: aload_3
    //   676: invokestatic 755	kawa/lib/lists:assv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   679: areturn
    //   680: aload_2
    //   681: aload_3
    //   682: invokestatic 757	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   685: areturn
    //   686: astore 10
    //   688: new 488	gnu/mapping/WrongType
    //   691: dup
    //   692: aload 10
    //   694: ldc 195
    //   696: iconst_1
    //   697: aload_2
    //   698: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   701: athrow
    //   702: astore 8
    //   704: new 488	gnu/mapping/WrongType
    //   707: dup
    //   708: aload 8
    //   710: ldc 191
    //   712: iconst_1
    //   713: aload_2
    //   714: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   717: athrow
    //   718: astore 6
    //   720: new 488	gnu/mapping/WrongType
    //   723: dup
    //   724: aload 6
    //   726: ldc 181
    //   728: iconst_2
    //   729: aload_3
    //   730: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   733: athrow
    //   734: astore 4
    //   736: new 488	gnu/mapping/WrongType
    //   739: dup
    //   740: aload 4
    //   742: ldc 177
    //   744: iconst_2
    //   745: aload_3
    //   746: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   749: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   334	340	686	java/lang/ClassCastException
    //   350	356	702	java/lang/ClassCastException
    //   618	627	718	java/lang/ClassCastException
    //   634	643	734	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 590	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+28->32, 72:+38->42, 76:+53->57
    //   33: aload_1
    //   34: aload_2
    //   35: aload_3
    //   36: aload 4
    //   38: invokespecial 760	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: areturn
    //   42: aload 4
    //   44: checkcast 472	gnu/mapping/Procedure
    //   47: astore 8
    //   49: aload_2
    //   50: aload_3
    //   51: aload 8
    //   53: invokestatic 562	kawa/lib/lists:member	(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   56: areturn
    //   57: aload 4
    //   59: checkcast 472	gnu/mapping/Procedure
    //   62: astore 6
    //   64: aload_2
    //   65: aload_3
    //   66: aload 6
    //   68: invokestatic 454	kawa/lib/lists:assoc	(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   71: areturn
    //   72: astore 7
    //   74: new 488	gnu/mapping/WrongType
    //   77: dup
    //   78: aload 7
    //   80: ldc 159
    //   82: iconst_3
    //   83: aload 4
    //   85: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   88: athrow
    //   89: astore 5
    //   91: new 488	gnu/mapping/WrongType
    //   94: dup
    //   95: aload 5
    //   97: ldc 142
    //   99: iconst_3
    //   100: aload 4
    //   102: invokespecial 493	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   105: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   42	49	72	java/lang/ClassCastException
    //   57	64	89	java/lang/ClassCastException
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 2:
    case 4:
    case 5:
    case 8:
    case 10:
    case 12:
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
    case 48:
    case 50:
    case 52:
    case 54:
    case 56:
    case 58:
    case 60:
    case 62:
    case 66:
    case 67:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 69:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 68:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 65:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 64:
      if ((paramObject instanceof LList))
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 63:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 61:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 59:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 57:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 55:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 53:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 51:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 49:
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
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 43:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 41:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 39:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 37:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 35:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 33:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 31:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 29:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 27:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 25:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 23:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 21:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 19:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 17:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 15:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 13:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 7:
      if (!(paramObject instanceof Pair))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 6:
      if (!(paramObject instanceof Pair))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3:
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
    case 6:
    case 7:
    case 9:
    case 11:
    case 13:
    case 15:
    case 17:
    case 19:
    case 21:
    case 23:
    case 25:
    case 27:
    case 29:
    case 31:
    case 33:
    case 35:
    case 37:
    case 39:
    case 41:
    case 43:
    case 45:
    case 47:
    case 49:
    case 51:
    case 53:
    case 55:
    case 57:
    case 59:
    case 61:
    case 63:
    case 64:
    case 65:
    case 68:
    case 69:
    case 73:
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 76:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 75:
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
    case 72:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 71:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 70:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 67:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 66:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 62:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 60:
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
    case 56:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 54:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 52:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 50:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 48:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 46:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 44:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 42:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 40:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 38:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 36:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 34:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 32:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 30:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 28:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 26:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 24:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 22:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 20:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 18:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 16:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 14:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 12:
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
    case 8:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 5:
      if (!(paramObject1 instanceof Pair))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 4:
      if (!(paramObject1 instanceof Pair))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
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
    case 76:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof Procedure))
        return -786429;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 72:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    if (!(paramObject3 instanceof Procedure))
      return -786429;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
    car = new GenericProc("car");
    GenericProc localGenericProc1 = car;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = Lit0;
    arrayOfObject1[1] = set$Mncar$Ex;
    arrayOfObject1[2] = car$Fn1;
    localGenericProc1.setProperties(arrayOfObject1);
    cdr = new GenericProc("cdr");
    GenericProc localGenericProc2 = cdr;
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = Lit0;
    arrayOfObject2[1] = set$Mncdr$Ex;
    arrayOfObject2[2] = cdr$Fn2;
    localGenericProc2.setProperties(arrayOfObject2);
    caar = new GenericProc("caar");
    GenericProc localGenericProc3 = caar;
    Object[] arrayOfObject3 = new Object[3];
    arrayOfObject3[0] = Lit0;
    arrayOfObject3[1] = lambda$Fn3;
    arrayOfObject3[2] = caar$Fn4;
    localGenericProc3.setProperties(arrayOfObject3);
    cadr = new GenericProc("cadr");
    GenericProc localGenericProc4 = cadr;
    Object[] arrayOfObject4 = new Object[3];
    arrayOfObject4[0] = Lit0;
    arrayOfObject4[1] = lambda$Fn5;
    arrayOfObject4[2] = cadr$Fn6;
    localGenericProc4.setProperties(arrayOfObject4);
    cdar = new GenericProc("cdar");
    GenericProc localGenericProc5 = cdar;
    Object[] arrayOfObject5 = new Object[3];
    arrayOfObject5[0] = Lit0;
    arrayOfObject5[1] = lambda$Fn7;
    arrayOfObject5[2] = cdar$Fn8;
    localGenericProc5.setProperties(arrayOfObject5);
    cddr = new GenericProc("cddr");
    GenericProc localGenericProc6 = cddr;
    Object[] arrayOfObject6 = new Object[3];
    arrayOfObject6[0] = Lit0;
    arrayOfObject6[1] = lambda$Fn9;
    arrayOfObject6[2] = cddr$Fn10;
    localGenericProc6.setProperties(arrayOfObject6);
    caaar = new GenericProc("caaar");
    GenericProc localGenericProc7 = caaar;
    Object[] arrayOfObject7 = new Object[3];
    arrayOfObject7[0] = Lit0;
    arrayOfObject7[1] = lambda$Fn11;
    arrayOfObject7[2] = caaar$Fn12;
    localGenericProc7.setProperties(arrayOfObject7);
    caadr = new GenericProc("caadr");
    GenericProc localGenericProc8 = caadr;
    Object[] arrayOfObject8 = new Object[3];
    arrayOfObject8[0] = Lit0;
    arrayOfObject8[1] = lambda$Fn13;
    arrayOfObject8[2] = caadr$Fn14;
    localGenericProc8.setProperties(arrayOfObject8);
    cadar = new GenericProc("cadar");
    GenericProc localGenericProc9 = cadar;
    Object[] arrayOfObject9 = new Object[3];
    arrayOfObject9[0] = Lit0;
    arrayOfObject9[1] = lambda$Fn15;
    arrayOfObject9[2] = cadar$Fn16;
    localGenericProc9.setProperties(arrayOfObject9);
    caddr = new GenericProc("caddr");
    GenericProc localGenericProc10 = caddr;
    Object[] arrayOfObject10 = new Object[3];
    arrayOfObject10[0] = Lit0;
    arrayOfObject10[1] = lambda$Fn17;
    arrayOfObject10[2] = caddr$Fn18;
    localGenericProc10.setProperties(arrayOfObject10);
    cdaar = new GenericProc("cdaar");
    GenericProc localGenericProc11 = cdaar;
    Object[] arrayOfObject11 = new Object[3];
    arrayOfObject11[0] = Lit0;
    arrayOfObject11[1] = lambda$Fn19;
    arrayOfObject11[2] = cdaar$Fn20;
    localGenericProc11.setProperties(arrayOfObject11);
    cdadr = new GenericProc("cdadr");
    GenericProc localGenericProc12 = cdadr;
    Object[] arrayOfObject12 = new Object[3];
    arrayOfObject12[0] = Lit0;
    arrayOfObject12[1] = lambda$Fn21;
    arrayOfObject12[2] = cdadr$Fn22;
    localGenericProc12.setProperties(arrayOfObject12);
    cddar = new GenericProc("cddar");
    GenericProc localGenericProc13 = cddar;
    Object[] arrayOfObject13 = new Object[3];
    arrayOfObject13[0] = Lit0;
    arrayOfObject13[1] = lambda$Fn23;
    arrayOfObject13[2] = cddar$Fn24;
    localGenericProc13.setProperties(arrayOfObject13);
    cdddr = new GenericProc("cdddr");
    GenericProc localGenericProc14 = cdddr;
    Object[] arrayOfObject14 = new Object[3];
    arrayOfObject14[0] = Lit0;
    arrayOfObject14[1] = lambda$Fn25;
    arrayOfObject14[2] = cdddr$Fn26;
    localGenericProc14.setProperties(arrayOfObject14);
    caaaar = new GenericProc("caaaar");
    GenericProc localGenericProc15 = caaaar;
    Object[] arrayOfObject15 = new Object[3];
    arrayOfObject15[0] = Lit0;
    arrayOfObject15[1] = lambda$Fn27;
    arrayOfObject15[2] = caaaar$Fn28;
    localGenericProc15.setProperties(arrayOfObject15);
    caaadr = new GenericProc("caaadr");
    GenericProc localGenericProc16 = caaadr;
    Object[] arrayOfObject16 = new Object[3];
    arrayOfObject16[0] = Lit0;
    arrayOfObject16[1] = lambda$Fn29;
    arrayOfObject16[2] = caaadr$Fn30;
    localGenericProc16.setProperties(arrayOfObject16);
    caadar = new GenericProc("caadar");
    GenericProc localGenericProc17 = caadar;
    Object[] arrayOfObject17 = new Object[3];
    arrayOfObject17[0] = Lit0;
    arrayOfObject17[1] = lambda$Fn31;
    arrayOfObject17[2] = caadar$Fn32;
    localGenericProc17.setProperties(arrayOfObject17);
    caaddr = new GenericProc("caaddr");
    GenericProc localGenericProc18 = caaddr;
    Object[] arrayOfObject18 = new Object[3];
    arrayOfObject18[0] = Lit0;
    arrayOfObject18[1] = lambda$Fn33;
    arrayOfObject18[2] = caaddr$Fn34;
    localGenericProc18.setProperties(arrayOfObject18);
    cadaar = new GenericProc("cadaar");
    GenericProc localGenericProc19 = cadaar;
    Object[] arrayOfObject19 = new Object[3];
    arrayOfObject19[0] = Lit0;
    arrayOfObject19[1] = lambda$Fn35;
    arrayOfObject19[2] = cadaar$Fn36;
    localGenericProc19.setProperties(arrayOfObject19);
    cadadr = new GenericProc("cadadr");
    GenericProc localGenericProc20 = cadadr;
    Object[] arrayOfObject20 = new Object[3];
    arrayOfObject20[0] = Lit0;
    arrayOfObject20[1] = lambda$Fn37;
    arrayOfObject20[2] = cadadr$Fn38;
    localGenericProc20.setProperties(arrayOfObject20);
    caddar = new GenericProc("caddar");
    GenericProc localGenericProc21 = caddar;
    Object[] arrayOfObject21 = new Object[3];
    arrayOfObject21[0] = Lit0;
    arrayOfObject21[1] = lambda$Fn39;
    arrayOfObject21[2] = caddar$Fn40;
    localGenericProc21.setProperties(arrayOfObject21);
    cadddr = new GenericProc("cadddr");
    GenericProc localGenericProc22 = cadddr;
    Object[] arrayOfObject22 = new Object[3];
    arrayOfObject22[0] = Lit0;
    arrayOfObject22[1] = lambda$Fn41;
    arrayOfObject22[2] = cadddr$Fn42;
    localGenericProc22.setProperties(arrayOfObject22);
    cdaaar = new GenericProc("cdaaar");
    GenericProc localGenericProc23 = cdaaar;
    Object[] arrayOfObject23 = new Object[3];
    arrayOfObject23[0] = Lit0;
    arrayOfObject23[1] = lambda$Fn43;
    arrayOfObject23[2] = cdaaar$Fn44;
    localGenericProc23.setProperties(arrayOfObject23);
    cdaadr = new GenericProc("cdaadr");
    GenericProc localGenericProc24 = cdaadr;
    Object[] arrayOfObject24 = new Object[3];
    arrayOfObject24[0] = Lit0;
    arrayOfObject24[1] = lambda$Fn45;
    arrayOfObject24[2] = cdaadr$Fn46;
    localGenericProc24.setProperties(arrayOfObject24);
    cdadar = new GenericProc("cdadar");
    GenericProc localGenericProc25 = cdadar;
    Object[] arrayOfObject25 = new Object[3];
    arrayOfObject25[0] = Lit0;
    arrayOfObject25[1] = lambda$Fn47;
    arrayOfObject25[2] = cdadar$Fn48;
    localGenericProc25.setProperties(arrayOfObject25);
    cdaddr = new GenericProc("cdaddr");
    GenericProc localGenericProc26 = cdaddr;
    Object[] arrayOfObject26 = new Object[3];
    arrayOfObject26[0] = Lit0;
    arrayOfObject26[1] = lambda$Fn49;
    arrayOfObject26[2] = cdaddr$Fn50;
    localGenericProc26.setProperties(arrayOfObject26);
    cddaar = new GenericProc("cddaar");
    GenericProc localGenericProc27 = cddaar;
    Object[] arrayOfObject27 = new Object[3];
    arrayOfObject27[0] = Lit0;
    arrayOfObject27[1] = lambda$Fn51;
    arrayOfObject27[2] = cddaar$Fn52;
    localGenericProc27.setProperties(arrayOfObject27);
    cddadr = new GenericProc("cddadr");
    GenericProc localGenericProc28 = cddadr;
    Object[] arrayOfObject28 = new Object[3];
    arrayOfObject28[0] = Lit0;
    arrayOfObject28[1] = lambda$Fn53;
    arrayOfObject28[2] = cddadr$Fn54;
    localGenericProc28.setProperties(arrayOfObject28);
    cdddar = new GenericProc("cdddar");
    GenericProc localGenericProc29 = cdddar;
    Object[] arrayOfObject29 = new Object[3];
    arrayOfObject29[0] = Lit0;
    arrayOfObject29[1] = lambda$Fn55;
    arrayOfObject29[2] = cdddar$Fn56;
    localGenericProc29.setProperties(arrayOfObject29);
    cddddr = new GenericProc("cddddr");
    GenericProc localGenericProc30 = cddddr;
    Object[] arrayOfObject30 = new Object[3];
    arrayOfObject30[0] = Lit0;
    arrayOfObject30[1] = lambda$Fn57;
    arrayOfObject30[2] = cddddr$Fn58;
    localGenericProc30.setProperties(arrayOfObject30);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.lists
 * JD-Core Version:    0.6.2
 */