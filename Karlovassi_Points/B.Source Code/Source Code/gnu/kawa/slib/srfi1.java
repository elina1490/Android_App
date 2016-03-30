package gnu.kawa.slib;

import gnu.expr.GenericProc;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Map;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.Numeric;
import kawa.lang.Continuation;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.standard.Scheme;
import kawa.standard.append;
import kawa.standard.call_with_values;

public class srfi1 extends ModuleBody
{
  public static final Macro $Pcevery;
  public static final int $Pcprovide$Pclist$Mnlib = 123;
  public static final int $Pcprovide$Pcsrfi$Mn1 = 123;
  public static final srfi1 $instance;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit100;
  static final SimpleSymbol Lit101;
  static final SimpleSymbol Lit102;
  static final SimpleSymbol Lit103;
  static final SimpleSymbol Lit104 = (SimpleSymbol)new SimpleSymbol("cdr").readResolve();
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
  static final SimpleSymbol Lit71;
  static final SimpleSymbol Lit72;
  static final SimpleSymbol Lit73;
  static final SimpleSymbol Lit74;
  static final SimpleSymbol Lit75;
  static final SimpleSymbol Lit76;
  static final SimpleSymbol Lit77;
  static final SimpleSymbol Lit78;
  static final SimpleSymbol Lit79;
  static final SimpleSymbol Lit8;
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
  static final SimpleSymbol Lit90;
  static final SimpleSymbol Lit91;
  static final SimpleSymbol Lit92;
  static final SimpleSymbol Lit93;
  static final SimpleSymbol Lit94;
  static final SimpleSymbol Lit95;
  static final SimpleSymbol Lit96;
  static final SimpleSymbol Lit97;
  static final SimpleSymbol Lit98;
  static final SimpleSymbol Lit99;
  public static final ModuleMethod alist$Mncons;
  public static final ModuleMethod alist$Mncopy;
  public static final ModuleMethod alist$Mndelete;
  public static final ModuleMethod alist$Mndelete$Ex;
  public static final ModuleMethod any;
  public static final ModuleMethod append$Ex;
  public static final ModuleMethod append$Mnmap;
  public static final ModuleMethod append$Mnmap$Ex;
  public static final ModuleMethod append$Mnreverse;
  public static final ModuleMethod append$Mnreverse$Ex;
  public static final ModuleMethod jdField_break;
  public static final ModuleMethod break$Ex;
  public static final ModuleMethod car$Plcdr;
  public static final ModuleMethod circular$Mnlist;
  public static final ModuleMethod circular$Mnlist$Qu;
  public static final ModuleMethod concatenate;
  public static final ModuleMethod concatenate$Ex;
  public static final ModuleMethod cons$St;
  public static final ModuleMethod count;
  public static final ModuleMethod delete;
  public static final ModuleMethod delete$Ex;
  public static final ModuleMethod delete$Mnduplicates;
  public static final ModuleMethod delete$Mnduplicates$Ex;
  public static final ModuleMethod dotted$Mnlist$Qu;
  public static final ModuleMethod drop;
  public static final ModuleMethod drop$Mnright;
  public static final ModuleMethod drop$Mnright$Ex;
  public static final ModuleMethod drop$Mnwhile;
  public static final ModuleMethod eighth;
  public static final ModuleMethod every;
  public static final ModuleMethod fifth;
  public static final ModuleMethod filter;
  public static final ModuleMethod filter$Ex;
  public static final ModuleMethod filter$Mnmap;
  public static final ModuleMethod find;
  public static final ModuleMethod find$Mntail;
  public static GenericProc first;
  public static final ModuleMethod fold;
  public static final ModuleMethod fold$Mnright;
  public static GenericProc fourth;
  public static final ModuleMethod iota;
  static final ModuleMethod lambda$Fn64;
  static final ModuleMethod lambda$Fn78;
  public static final ModuleMethod last;
  public static final ModuleMethod last$Mnpair;
  public static final ModuleMethod length$Pl;
  public static final ModuleMethod list$Eq;
  public static final ModuleMethod list$Mncopy;
  public static final ModuleMethod list$Mnindex;
  public static final ModuleMethod list$Mntabulate;
  public static final ModuleMethod lset$Eq;
  public static final ModuleMethod lset$Ls$Eq;
  public static final ModuleMethod lset$Mnadjoin;
  public static final ModuleMethod lset$Mndiff$Plintersection;
  public static final ModuleMethod lset$Mndiff$Plintersection$Ex;
  public static final ModuleMethod lset$Mndifference;
  public static final ModuleMethod lset$Mndifference$Ex;
  public static final ModuleMethod lset$Mnintersection;
  public static final ModuleMethod lset$Mnintersection$Ex;
  public static final ModuleMethod lset$Mnunion;
  public static final ModuleMethod lset$Mnunion$Ex;
  public static final ModuleMethod lset$Mnxor;
  public static final ModuleMethod lset$Mnxor$Ex;
  public static final ModuleMethod make$Mnlist;
  public static final ModuleMethod map$Ex;
  public static Map map$Mnin$Mnorder;
  public static final ModuleMethod ninth;
  public static final ModuleMethod not$Mnpair$Qu;
  public static final ModuleMethod null$Mnlist$Qu;
  public static final ModuleMethod pair$Mnfold;
  public static final ModuleMethod pair$Mnfold$Mnright;
  public static final ModuleMethod pair$Mnfor$Mneach;
  public static final ModuleMethod partition;
  public static final ModuleMethod partition$Ex;
  public static final ModuleMethod proper$Mnlist$Qu;
  public static final ModuleMethod reduce;
  public static final ModuleMethod reduce$Mnright;
  public static final ModuleMethod remove;
  public static final ModuleMethod remove$Ex;
  public static GenericProc second;
  public static final ModuleMethod seventh;
  public static final ModuleMethod sixth;
  public static final ModuleMethod span;
  public static final ModuleMethod span$Ex;
  public static final ModuleMethod split$Mnat;
  public static final ModuleMethod split$Mnat$Ex;
  public static final ModuleMethod take;
  public static final ModuleMethod take$Ex;
  public static final ModuleMethod take$Mnright;
  public static final ModuleMethod take$Mnwhile;
  public static final ModuleMethod take$Mnwhile$Ex;
  public static final ModuleMethod tenth;
  public static GenericProc third;
  public static final ModuleMethod unfold;
  public static final ModuleMethod unfold$Mnright;
  public static final ModuleMethod unzip1;
  public static final ModuleMethod unzip2;
  public static final ModuleMethod unzip3;
  public static final ModuleMethod unzip4;
  public static final ModuleMethod unzip5;
  public static final ModuleMethod xcons;
  public static final ModuleMethod zip;

  static Object $PcCars$Pl(Object paramObject1, Object paramObject2)
  {
    frame56 localframe56 = new frame56();
    localframe56.last$Mnelt = paramObject2;
    return localframe56.lambda75recur(paramObject1);
  }

  static Object $PcCars$PlCdrs(Object paramObject)
  {
    Continuation localContinuation = new Continuation(CallContext.getInstance());
    try
    {
      frame57 localframe57 = new frame57();
      localframe57.abort = localContinuation;
      localObject = localframe57.lambda76recur(paramObject);
      localContinuation.invoked = true;
    }
    finally
    {
      Object localObject;
      return Continuation.handleException(localThrowable, localContinuation);
    }
  }

  static Object $PcCars$PlCdrs$Pl(Object paramObject1, Object paramObject2)
  {
    frame62 localframe62 = new frame62();
    localframe62.cars$Mnfinal = paramObject2;
    Continuation localContinuation = new Continuation(CallContext.getInstance());
    try
    {
      frame63 localframe63 = new frame63();
      localframe63.staticLink = localframe62;
      localframe63.abort = localContinuation;
      localObject = localframe63.lambda85recur(paramObject1);
      localContinuation.invoked = true;
    }
    finally
    {
      Object localObject;
      return Continuation.handleException(localThrowable, localContinuation);
    }
  }

  static Object $PcCars$PlCdrs$SlNoTest(Object paramObject)
  {
    new frame67();
    return frame67.lambda92recur(paramObject);
  }

  static Object $PcCars$PlCdrs$SlNoTest$SlPair(Object paramObject)
  {
    frame71 localframe71 = new frame71();
    localframe71.lists = paramObject;
    return call_with_values.callWithValues(localframe71.lambda$Fn77, lambda$Fn78);
  }

  static Object $PcCars$PlCdrs$SlPair(Object paramObject)
  {
    frame61 localframe61 = new frame61();
    localframe61.lists = paramObject;
    return call_with_values.callWithValues(localframe61.lambda$Fn63, lambda$Fn64);
  }

  static Object $PcCdrs(Object paramObject)
  {
    Continuation localContinuation = new Continuation(CallContext.getInstance());
    try
    {
      frame55 localframe55 = new frame55();
      localframe55.abort = localContinuation;
      localObject = localframe55.lambda74recur(paramObject);
      localContinuation.invoked = true;
    }
    finally
    {
      Object localObject;
      return Continuation.handleException(localThrowable, localContinuation);
    }
  }

  static Object $PcLset2$Ls$Eq(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame72 localframe72 = new frame72();
    localframe72.$Eq = paramObject1;
    localframe72.lis2 = paramObject3;
    return every$V(localframe72.lambda$Fn79, paramObject2, new Object[0]);
  }

  static
  {
    Lit103 = (SimpleSymbol)new SimpleSymbol("car").readResolve();
    Lit102 = (SimpleSymbol)new SimpleSymbol("lp").readResolve();
    Lit101 = (SimpleSymbol)new SimpleSymbol("head").readResolve();
    Lit100 = (SimpleSymbol)new SimpleSymbol("tail").readResolve();
    Lit99 = (SimpleSymbol)new SimpleSymbol("lset-diff+intersection!").readResolve();
    Lit98 = (SimpleSymbol)new SimpleSymbol("lset-diff+intersection").readResolve();
    Lit97 = (SimpleSymbol)new SimpleSymbol("lset-xor!").readResolve();
    Lit96 = (SimpleSymbol)new SimpleSymbol("lset-xor").readResolve();
    Lit95 = (SimpleSymbol)new SimpleSymbol("lset-difference!").readResolve();
    Lit94 = (SimpleSymbol)new SimpleSymbol("lset-difference").readResolve();
    Lit93 = (SimpleSymbol)new SimpleSymbol("lset-intersection!").readResolve();
    Lit92 = (SimpleSymbol)new SimpleSymbol("lset-intersection").readResolve();
    Lit91 = (SimpleSymbol)new SimpleSymbol("lset-union!").readResolve();
    Lit90 = (SimpleSymbol)new SimpleSymbol("lset-union").readResolve();
    Lit89 = (SimpleSymbol)new SimpleSymbol("lset-adjoin").readResolve();
    Lit88 = (SimpleSymbol)new SimpleSymbol("lset=").readResolve();
    Lit87 = (SimpleSymbol)new SimpleSymbol("lset<=").readResolve();
    Lit86 = (SimpleSymbol)new SimpleSymbol("list-index").readResolve();
    Object[] arrayOfObject1 = new Object[1];
    SimpleSymbol localSimpleSymbol1 = (SimpleSymbol)new SimpleSymbol("%every").readResolve();
    Lit84 = localSimpleSymbol1;
    arrayOfObject1[0] = localSimpleSymbol1;
    SyntaxRule[] arrayOfSyntaxRule = new SyntaxRule[1];
    SyntaxPattern localSyntaxPattern = new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2);
    Object[] arrayOfObject2 = new Object[10];
    arrayOfObject2[0] = ((SimpleSymbol)new SimpleSymbol("let").readResolve());
    arrayOfObject2[1] = Lit102;
    arrayOfObject2[2] = Lit101;
    arrayOfObject2[3] = Lit103;
    arrayOfObject2[4] = Lit100;
    arrayOfObject2[5] = Lit104;
    arrayOfObject2[6] = ((SimpleSymbol)new SimpleSymbol("and").readResolve());
    SimpleSymbol localSimpleSymbol2 = (SimpleSymbol)new SimpleSymbol("null-list?").readResolve();
    Lit14 = localSimpleSymbol2;
    arrayOfObject2[7] = PairWithPosition.make(localSimpleSymbol2, PairWithPosition.make(Lit100, LList.Empty, "srfi1.scm", 5722136), "srfi1.scm", 5722124);
    arrayOfObject2[8] = PairWithPosition.make(Lit101, LList.Empty, "srfi1.scm", 5722148);
    arrayOfObject2[9] = PairWithPosition.make(PairWithPosition.make(Lit102, PairWithPosition.make(PairWithPosition.make(Lit103, PairWithPosition.make(Lit100, LList.Empty, "srfi1.scm", 5722163), "srfi1.scm", 5722158), PairWithPosition.make(PairWithPosition.make(Lit104, PairWithPosition.make(Lit100, LList.Empty, "srfi1.scm", 5722174), "srfi1.scm", 5722169), LList.Empty, "srfi1.scm", 5722169), "srfi1.scm", 5722158), "srfi1.scm", 5722154), LList.Empty, "srfi1.scm", 5722154);
    arrayOfSyntaxRule[0] = new SyntaxRule(localSyntaxPattern, "\001\001", "\021\030\004\021\030\f¡I\021\030\024\b\021\030\034\b\013\b\021\030$\b\021\030,\b\013\b\021\0304\021\030<!\t\003\030D\030L", arrayOfObject2, 0);
    Lit85 = new SyntaxRules(arrayOfObject1, arrayOfSyntaxRule, 2);
    Lit83 = (SimpleSymbol)new SimpleSymbol("every").readResolve();
    Lit82 = (SimpleSymbol)new SimpleSymbol("any").readResolve();
    Lit81 = (SimpleSymbol)new SimpleSymbol("break!").readResolve();
    Lit80 = (SimpleSymbol)new SimpleSymbol("jdField_break").readResolve();
    Lit79 = (SimpleSymbol)new SimpleSymbol("span!").readResolve();
    Lit78 = (SimpleSymbol)new SimpleSymbol("span").readResolve();
    Lit77 = (SimpleSymbol)new SimpleSymbol("take-while!").readResolve();
    Lit76 = (SimpleSymbol)new SimpleSymbol("drop-while").readResolve();
    Lit75 = (SimpleSymbol)new SimpleSymbol("take-while").readResolve();
    Lit74 = (SimpleSymbol)new SimpleSymbol("find-tail").readResolve();
    Lit73 = (SimpleSymbol)new SimpleSymbol("find").readResolve();
    Lit72 = (SimpleSymbol)new SimpleSymbol("alist-delete!").readResolve();
    Lit71 = (SimpleSymbol)new SimpleSymbol("alist-delete").readResolve();
    Lit70 = (SimpleSymbol)new SimpleSymbol("alist-copy").readResolve();
    Lit69 = (SimpleSymbol)new SimpleSymbol("alist-cons").readResolve();
    Lit68 = (SimpleSymbol)new SimpleSymbol("delete-duplicates!").readResolve();
    Lit67 = (SimpleSymbol)new SimpleSymbol("delete-duplicates").readResolve();
    Lit66 = (SimpleSymbol)new SimpleSymbol("delete!").readResolve();
    Lit65 = (SimpleSymbol)new SimpleSymbol("delete").readResolve();
    Lit64 = (SimpleSymbol)new SimpleSymbol("remove!").readResolve();
    Lit63 = (SimpleSymbol)new SimpleSymbol("remove").readResolve();
    Lit62 = (SimpleSymbol)new SimpleSymbol("partition!").readResolve();
    Lit61 = (SimpleSymbol)new SimpleSymbol("partition").readResolve();
    Lit60 = (SimpleSymbol)new SimpleSymbol("filter!").readResolve();
    Lit59 = (SimpleSymbol)new SimpleSymbol("filter").readResolve();
    Lit58 = (SimpleSymbol)new SimpleSymbol("filter-map").readResolve();
    Lit57 = (SimpleSymbol)new SimpleSymbol("map!").readResolve();
    Lit56 = (SimpleSymbol)new SimpleSymbol("pair-for-each").readResolve();
    Lit55 = (SimpleSymbol)new SimpleSymbol("append-map!").readResolve();
    Lit54 = (SimpleSymbol)new SimpleSymbol("append-map").readResolve();
    Lit53 = (SimpleSymbol)new SimpleSymbol("reduce-right").readResolve();
    Lit52 = (SimpleSymbol)new SimpleSymbol("reduce").readResolve();
    Lit51 = (SimpleSymbol)new SimpleSymbol("pair-fold").readResolve();
    Lit50 = (SimpleSymbol)new SimpleSymbol("pair-fold-right").readResolve();
    Lit49 = (SimpleSymbol)new SimpleSymbol("fold-right").readResolve();
    Lit48 = (SimpleSymbol)new SimpleSymbol("fold").readResolve();
    Lit47 = (SimpleSymbol)new SimpleSymbol("unfold").readResolve();
    Lit46 = (SimpleSymbol)new SimpleSymbol("unfold-right").readResolve();
    Lit45 = (SimpleSymbol)new SimpleSymbol("count").readResolve();
    Lit44 = (SimpleSymbol)new SimpleSymbol("concatenate!").readResolve();
    Lit43 = (SimpleSymbol)new SimpleSymbol("concatenate").readResolve();
    Lit42 = (SimpleSymbol)new SimpleSymbol("append-reverse!").readResolve();
    Lit41 = (SimpleSymbol)new SimpleSymbol("append-reverse").readResolve();
    Lit40 = (SimpleSymbol)new SimpleSymbol("append!").readResolve();
    Lit39 = (SimpleSymbol)new SimpleSymbol("unzip5").readResolve();
    Lit38 = (SimpleSymbol)new SimpleSymbol("unzip4").readResolve();
    Lit37 = (SimpleSymbol)new SimpleSymbol("unzip3").readResolve();
    Lit36 = (SimpleSymbol)new SimpleSymbol("unzip2").readResolve();
    Lit35 = (SimpleSymbol)new SimpleSymbol("unzip1").readResolve();
    Lit34 = (SimpleSymbol)new SimpleSymbol("last-pair").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("last").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("split-at!").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("split-at").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("drop-right!").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("drop-right").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("take-right").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("take!").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("drop").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("take").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("car+cdr").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("tenth").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("ninth").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("eighth").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("seventh").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("sixth").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("fifth").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("zip").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("length+").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("list=").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("not-pair?").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("circular-list?").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("dotted-list?").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("proper-list?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("circular-list").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("iota").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("list-copy").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("cons*").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("list-tabulate").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("make-list").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("xcons").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("tmp").readResolve();
    Lit1 = IntNum.make(1);
    Lit0 = IntNum.make(0);
    $instance = new srfi1();
    $Pcprovide$Pcsrfi$Mn1 = 123;
    $Pcprovide$Pclist$Mnlib = 123;
    srfi1 localsrfi1 = $instance;
    xcons = new ModuleMethod(localsrfi1, 78, Lit3, 8194);
    make$Mnlist = new ModuleMethod(localsrfi1, 79, Lit4, -4095);
    list$Mntabulate = new ModuleMethod(localsrfi1, 80, Lit5, 8194);
    cons$St = new ModuleMethod(localsrfi1, 81, Lit6, -4096);
    list$Mncopy = new ModuleMethod(localsrfi1, 82, Lit7, 4097);
    iota = new ModuleMethod(localsrfi1, 83, Lit8, 12289);
    circular$Mnlist = new ModuleMethod(localsrfi1, 86, Lit9, -4095);
    proper$Mnlist$Qu = new ModuleMethod(localsrfi1, 87, Lit10, 4097);
    dotted$Mnlist$Qu = new ModuleMethod(localsrfi1, 88, Lit11, 4097);
    circular$Mnlist$Qu = new ModuleMethod(localsrfi1, 89, Lit12, 4097);
    not$Mnpair$Qu = new ModuleMethod(localsrfi1, 90, Lit13, 4097);
    null$Mnlist$Qu = new ModuleMethod(localsrfi1, 91, Lit14, 4097);
    list$Eq = new ModuleMethod(localsrfi1, 92, Lit15, -4095);
    length$Pl = new ModuleMethod(localsrfi1, 93, Lit16, 4097);
    zip = new ModuleMethod(localsrfi1, 94, Lit17, -4095);
    fifth = new ModuleMethod(localsrfi1, 95, Lit18, 4097);
    sixth = new ModuleMethod(localsrfi1, 96, Lit19, 4097);
    seventh = new ModuleMethod(localsrfi1, 97, Lit20, 4097);
    eighth = new ModuleMethod(localsrfi1, 98, Lit21, 4097);
    ninth = new ModuleMethod(localsrfi1, 99, Lit22, 4097);
    tenth = new ModuleMethod(localsrfi1, 100, Lit23, 4097);
    car$Plcdr = new ModuleMethod(localsrfi1, 101, Lit24, 4097);
    take = new ModuleMethod(localsrfi1, 102, Lit25, 8194);
    drop = new ModuleMethod(localsrfi1, 103, Lit26, 8194);
    take$Ex = new ModuleMethod(localsrfi1, 104, Lit27, 8194);
    take$Mnright = new ModuleMethod(localsrfi1, 105, Lit28, 8194);
    drop$Mnright = new ModuleMethod(localsrfi1, 106, Lit29, 8194);
    drop$Mnright$Ex = new ModuleMethod(localsrfi1, 107, Lit30, 8194);
    split$Mnat = new ModuleMethod(localsrfi1, 108, Lit31, 8194);
    split$Mnat$Ex = new ModuleMethod(localsrfi1, 109, Lit32, 8194);
    last = new ModuleMethod(localsrfi1, 110, Lit33, 4097);
    last$Mnpair = new ModuleMethod(localsrfi1, 111, Lit34, 4097);
    unzip1 = new ModuleMethod(localsrfi1, 112, Lit35, 4097);
    unzip2 = new ModuleMethod(localsrfi1, 113, Lit36, 4097);
    unzip3 = new ModuleMethod(localsrfi1, 114, Lit37, 4097);
    unzip4 = new ModuleMethod(localsrfi1, 115, Lit38, 4097);
    unzip5 = new ModuleMethod(localsrfi1, 116, Lit39, 4097);
    append$Ex = new ModuleMethod(localsrfi1, 117, Lit40, -4096);
    append$Mnreverse = new ModuleMethod(localsrfi1, 118, Lit41, 8194);
    append$Mnreverse$Ex = new ModuleMethod(localsrfi1, 119, Lit42, 8194);
    concatenate = new ModuleMethod(localsrfi1, 120, Lit43, 4097);
    concatenate$Ex = new ModuleMethod(localsrfi1, 121, Lit44, 4097);
    count = new ModuleMethod(localsrfi1, 122, Lit45, -4094);
    unfold$Mnright = new ModuleMethod(localsrfi1, 123, Lit46, 20484);
    unfold = new ModuleMethod(localsrfi1, 125, Lit47, -4092);
    fold = new ModuleMethod(localsrfi1, 126, Lit48, -4093);
    fold$Mnright = new ModuleMethod(localsrfi1, 127, Lit49, -4093);
    pair$Mnfold$Mnright = new ModuleMethod(localsrfi1, 128, Lit50, -4093);
    pair$Mnfold = new ModuleMethod(localsrfi1, 129, Lit51, -4093);
    reduce = new ModuleMethod(localsrfi1, 130, Lit52, 12291);
    reduce$Mnright = new ModuleMethod(localsrfi1, 131, Lit53, 12291);
    append$Mnmap = new ModuleMethod(localsrfi1, 132, Lit54, -4094);
    append$Mnmap$Ex = new ModuleMethod(localsrfi1, 133, Lit55, -4094);
    pair$Mnfor$Mneach = new ModuleMethod(localsrfi1, 134, Lit56, -4094);
    map$Ex = new ModuleMethod(localsrfi1, 135, Lit57, -4094);
    filter$Mnmap = new ModuleMethod(localsrfi1, 136, Lit58, -4094);
    filter = new ModuleMethod(localsrfi1, 137, Lit59, 8194);
    filter$Ex = new ModuleMethod(localsrfi1, 138, Lit60, 8194);
    partition = new ModuleMethod(localsrfi1, 139, Lit61, 8194);
    partition$Ex = new ModuleMethod(localsrfi1, 140, Lit62, 8194);
    remove = new ModuleMethod(localsrfi1, 141, Lit63, 8194);
    remove$Ex = new ModuleMethod(localsrfi1, 142, Lit64, 8194);
    delete = new ModuleMethod(localsrfi1, 143, Lit65, 12290);
    delete$Ex = new ModuleMethod(localsrfi1, 145, Lit66, 12290);
    delete$Mnduplicates = new ModuleMethod(localsrfi1, 147, Lit67, 8193);
    delete$Mnduplicates$Ex = new ModuleMethod(localsrfi1, 149, Lit68, 8193);
    alist$Mncons = new ModuleMethod(localsrfi1, 151, Lit69, 12291);
    alist$Mncopy = new ModuleMethod(localsrfi1, 152, Lit70, 4097);
    alist$Mndelete = new ModuleMethod(localsrfi1, 153, Lit71, 12290);
    alist$Mndelete$Ex = new ModuleMethod(localsrfi1, 155, Lit72, 12290);
    find = new ModuleMethod(localsrfi1, 157, Lit73, 8194);
    find$Mntail = new ModuleMethod(localsrfi1, 158, Lit74, 8194);
    take$Mnwhile = new ModuleMethod(localsrfi1, 159, Lit75, 8194);
    drop$Mnwhile = new ModuleMethod(localsrfi1, 160, Lit76, 8194);
    take$Mnwhile$Ex = new ModuleMethod(localsrfi1, 161, Lit77, 8194);
    span = new ModuleMethod(localsrfi1, 162, Lit78, 8194);
    span$Ex = new ModuleMethod(localsrfi1, 163, Lit79, 8194);
    jdField_break = new ModuleMethod(localsrfi1, 164, Lit80, 8194);
    break$Ex = new ModuleMethod(localsrfi1, 165, Lit81, 8194);
    any = new ModuleMethod(localsrfi1, 166, Lit82, -4094);
    every = new ModuleMethod(localsrfi1, 167, Lit83, -4094);
    $Pcevery = Macro.make(Lit84, Lit85, $instance);
    list$Mnindex = new ModuleMethod(localsrfi1, 168, Lit86, -4094);
    lset$Ls$Eq = new ModuleMethod(localsrfi1, 169, Lit87, -4095);
    lset$Eq = new ModuleMethod(localsrfi1, 170, Lit88, -4095);
    lset$Mnadjoin = new ModuleMethod(localsrfi1, 171, Lit89, -4094);
    lset$Mnunion = new ModuleMethod(localsrfi1, 172, Lit90, -4095);
    lset$Mnunion$Ex = new ModuleMethod(localsrfi1, 173, Lit91, -4095);
    lset$Mnintersection = new ModuleMethod(localsrfi1, 174, Lit92, -4094);
    lset$Mnintersection$Ex = new ModuleMethod(localsrfi1, 175, Lit93, -4094);
    lset$Mndifference = new ModuleMethod(localsrfi1, 176, Lit94, -4094);
    lset$Mndifference$Ex = new ModuleMethod(localsrfi1, 177, Lit95, -4094);
    lset$Mnxor = new ModuleMethod(localsrfi1, 178, Lit96, -4095);
    lset$Mnxor$Ex = new ModuleMethod(localsrfi1, 179, Lit97, -4095);
    lset$Mndiff$Plintersection = new ModuleMethod(localsrfi1, 180, Lit98, -4094);
    lset$Mndiff$Plintersection$Ex = new ModuleMethod(localsrfi1, 181, Lit99, -4094);
    lambda$Fn64 = new ModuleMethod(localsrfi1, 182, null, 8194);
    lambda$Fn78 = new ModuleMethod(localsrfi1, 183, null, 8194);
    $instance.run();
  }

  public srfi1()
  {
    ModuleInfo.register(this);
  }

  public static Pair alistCons(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return lists.cons(lists.cons(paramObject1, paramObject2), paramObject3);
  }

  public static LList alistCopy(Object paramObject)
  {
    Object localObject1 = LList.Empty;
    Object localObject2 = paramObject;
    while (true)
    {
      if (localObject2 == LList.Empty)
        return LList.reverseInPlace(localObject1);
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject3 = localPair.getCdr();
        Object localObject4 = localPair.getCar();
        localObject1 = Pair.make(lists.cons(lists.car.apply1(localObject4), lists.cdr.apply1(localObject4)), localObject1);
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }

  public static Object alistDelete(Object paramObject1, Object paramObject2)
  {
    return alistDelete(paramObject1, paramObject2, Scheme.isEqual);
  }

  public static Object alistDelete(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame21 localframe21 = new frame21();
    localframe21.key = paramObject1;
    localframe21.maybe$Mn$Eq = paramObject3;
    return filter(localframe21.lambda$Fn18, paramObject2);
  }

  public static Object alistDelete$Ex(Object paramObject1, Object paramObject2)
  {
    return alistDelete$Ex(paramObject1, paramObject2, Scheme.isEqual);
  }

  public static Object alistDelete$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame22 localframe22 = new frame22();
    localframe22.key = paramObject1;
    localframe22.maybe$Mn$Eq = paramObject3;
    return filter$Ex(localframe22.lambda$Fn19, paramObject2);
  }

  public static Object any$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame26 localframe26 = new frame26();
    localframe26.pred = paramProcedure;
    localframe26.lis1 = paramObject;
    localframe26.lists = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localframe26.lists))
      return call_with_values.callWithValues(localframe26.lambda$Fn22, localframe26.lambda$Fn23);
    Object localObject1 = isNullList(localframe26.lis1);
    try
    {
      Boolean localBoolean = Boolean.FALSE;
      int i;
      int j;
      Object localObject2;
      if (localObject1 != localBoolean)
      {
        i = 1;
        j = 0x1 & i + 1;
        if (j != 0)
          localObject2 = lists.car.apply1(localframe26.lis1);
      }
      else
      {
        for (Object localObject3 = lists.cdr.apply1(localframe26.lis1); ; localObject3 = lists.cdr.apply1(localObject3))
        {
          if (isNullList(localObject3) != Boolean.FALSE)
          {
            return localframe26.pred.apply1(localObject2);
            i = 0;
            break;
          }
          Object localObject4 = localframe26.pred.apply1(localObject2);
          if (localObject4 != Boolean.FALSE)
            return localObject4;
          localObject2 = lists.car.apply1(localObject3);
        }
      }
      if (j != 0)
        return Boolean.TRUE;
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "x", -2, localObject1);
    }
  }

  // ERROR //
  public static Object append$Ex$V(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokestatic 1109	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: astore_1
    //   6: getstatic 465	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   9: astore_2
    //   10: aload_1
    //   11: invokestatic 1115	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   14: ifne +5 -> 19
    //   17: aload_2
    //   18: areturn
    //   19: getstatic 1041	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   22: aload_1
    //   23: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: astore_3
    //   27: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   30: aload_1
    //   31: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: astore 4
    //   36: aload_3
    //   37: invokestatic 1115	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   40: ifne +11 -> 51
    //   43: aload 4
    //   45: astore_1
    //   46: aload_3
    //   47: astore_2
    //   48: goto -38 -> 10
    //   51: aload_3
    //   52: checkcast 1033	gnu/lists/Pair
    //   55: astore 6
    //   57: aload 6
    //   59: invokestatic 1141	gnu/kawa/slib/srfi1:lastPair	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   62: astore 7
    //   64: aload 4
    //   66: invokestatic 1115	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   69: ifeq +62 -> 131
    //   72: getstatic 1041	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   75: aload 4
    //   77: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore 8
    //   82: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   85: aload 4
    //   87: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: astore 4
    //   92: aload 7
    //   94: checkcast 1033	gnu/lists/Pair
    //   97: astore 10
    //   99: aload 10
    //   101: aload 8
    //   103: invokestatic 1145	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   106: aload 8
    //   108: invokestatic 1115	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   111: ifeq +17 -> 128
    //   114: aload 8
    //   116: checkcast 1033	gnu/lists/Pair
    //   119: astore 12
    //   121: aload 12
    //   123: invokestatic 1141	gnu/kawa/slib/srfi1:lastPair	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   126: astore 7
    //   128: goto -64 -> 64
    //   131: aload_3
    //   132: areturn
    //   133: astore 5
    //   135: new 1052	gnu/mapping/WrongType
    //   138: dup
    //   139: aload 5
    //   141: ldc_w 674
    //   144: iconst_0
    //   145: aload_3
    //   146: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   149: athrow
    //   150: astore 9
    //   152: new 1052	gnu/mapping/WrongType
    //   155: dup
    //   156: aload 9
    //   158: ldc_w 1147
    //   161: iconst_1
    //   162: aload 7
    //   164: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   167: athrow
    //   168: astore 11
    //   170: new 1052	gnu/mapping/WrongType
    //   173: dup
    //   174: aload 11
    //   176: ldc_w 674
    //   179: iconst_0
    //   180: aload 8
    //   182: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   185: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   51	57	133	java/lang/ClassCastException
    //   92	99	150	java/lang/ClassCastException
    //   114	121	168	java/lang/ClassCastException
  }

  public static Object appendMap$Ex$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList))
      return Scheme.apply.apply2(append$Ex, Scheme.apply.apply4(Scheme.map, paramObject1, paramObject2, localLList));
    Apply localApply = Scheme.apply;
    ModuleMethod localModuleMethod = append$Ex;
    Object localObject1 = LList.Empty;
    Object localObject2 = paramObject2;
    while (true)
    {
      if (localObject2 == LList.Empty)
        return localApply.apply2(localModuleMethod, LList.reverseInPlace(localObject1));
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject3 = localPair.getCdr();
        localObject1 = Pair.make(Scheme.applyToArgs.apply2(paramObject1, localPair.getCar()), localObject1);
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }

  public static Object appendMap$V(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList))
      return Scheme.apply.apply2(append.append, Scheme.apply.apply4(Scheme.map, paramObject1, paramObject2, localLList));
    Apply localApply = Scheme.apply;
    append localappend = append.append;
    Object localObject1 = LList.Empty;
    Object localObject2 = paramObject2;
    while (true)
    {
      if (localObject2 == LList.Empty)
        return localApply.apply2(localappend, LList.reverseInPlace(localObject1));
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject3 = localPair.getCdr();
        localObject1 = Pair.make(Scheme.applyToArgs.apply2(paramObject1, localPair.getCar()), localObject1);
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }

  public static Object appendReverse(Object paramObject1, Object paramObject2)
  {
    while (true)
    {
      if (isNullList(paramObject1) != Boolean.FALSE)
        return paramObject2;
      Object localObject = lists.cdr.apply1(paramObject1);
      paramObject2 = lists.cons(lists.car.apply1(paramObject1), paramObject2);
      paramObject1 = localObject;
    }
  }

  public static Object appendReverse$Ex(Object paramObject1, Object paramObject2)
  {
    while (true)
    {
      if (isNullList(paramObject1) != Boolean.FALSE)
        return paramObject2;
      Object localObject = lists.cdr.apply1(paramObject1);
      try
      {
        Pair localPair = (Pair)paramObject1;
        lists.setCdr$Ex(localPair, paramObject2);
        paramObject2 = paramObject1;
        paramObject1 = localObject;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, paramObject1);
      }
    }
  }

  public static Object jdField_break(Object paramObject1, Object paramObject2)
  {
    frame24 localframe24 = new frame24();
    localframe24.pred = paramObject1;
    return span(localframe24.lambda$Fn20, paramObject2);
  }

  public static Object break$Ex(Object paramObject1, Object paramObject2)
  {
    frame25 localframe25 = new frame25();
    localframe25.pred = paramObject1;
    return span$Ex(localframe25.lambda$Fn21, paramObject2);
  }

  public static Object car$PlCdr(Object paramObject)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = lists.car.apply1(paramObject);
    arrayOfObject[1] = lists.cdr.apply1(paramObject);
    return misc.values(arrayOfObject);
  }

  public static Pair circularList$V(Object paramObject, Object[] paramArrayOfObject)
  {
    Pair localPair1 = lists.cons(paramObject, LList.makeList(paramArrayOfObject, 0));
    Object localObject = lastPair(localPair1);
    try
    {
      Pair localPair2 = (Pair)localObject;
      lists.setCdr$Ex(localPair2, localPair1);
      return localPair1;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-cdr!", 1, localObject);
    }
  }

  public static Object concatenate(Object paramObject)
  {
    return reduceRight(append.append, LList.Empty, paramObject);
  }

  public static Object concatenate$Ex(Object paramObject)
  {
    return reduceRight(append$Ex, LList.Empty, paramObject);
  }

  public static Object cons$St(Object[] paramArrayOfObject)
  {
    return LList.consX(paramArrayOfObject);
  }

  public static Object count$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    Object localObject1 = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localObject1))
    {
      localObject2 = Lit0;
      if (isNullList(paramObject) != Boolean.FALSE);
      Object localObject7;
      Object localObject8;
      do
      {
        return localObject2;
        Object localObject6 = $PcCars$PlCdrs$SlPair(localObject1);
        localObject7 = lists.car.apply1(localObject6);
        localObject8 = lists.cdr.apply1(localObject6);
      }
      while (lists.isNull(localObject7));
      Object localObject9 = lists.cdr.apply1(paramObject);
      if (Scheme.apply.apply3(paramProcedure, lists.car.apply1(paramObject), localObject7) != Boolean.FALSE);
      for (Object localObject10 = AddOp.$Pl.apply2(localObject2, Lit1); ; localObject10 = localObject2)
      {
        localObject1 = localObject8;
        localObject2 = localObject10;
        paramObject = localObject9;
        break;
      }
    }
    Object localObject2 = Lit0;
    Object localObject3 = paramObject;
    label137: Object localObject4;
    if (isNullList(localObject3) == Boolean.FALSE)
    {
      localObject4 = lists.cdr.apply1(localObject3);
      if (paramProcedure.apply1(lists.car.apply1(localObject3)) == Boolean.FALSE)
        break label200;
    }
    label200: for (Object localObject5 = AddOp.$Pl.apply2(localObject2, Lit1); ; localObject5 = localObject2)
    {
      localObject2 = localObject5;
      localObject3 = localObject4;
      break label137;
      break;
    }
  }

  public static Object delete(Object paramObject1, Object paramObject2)
  {
    return delete(paramObject1, paramObject2, Scheme.isEqual);
  }

  public static Object delete(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame17 localframe17 = new frame17();
    localframe17.x = paramObject1;
    localframe17.maybe$Mn$Eq = paramObject3;
    return filter(localframe17.lambda$Fn16, paramObject2);
  }

  public static Object delete$Ex(Object paramObject1, Object paramObject2)
  {
    return delete$Ex(paramObject1, paramObject2, Scheme.isEqual);
  }

  public static Object delete$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    frame18 localframe18 = new frame18();
    localframe18.x = paramObject1;
    localframe18.maybe$Mn$Eq = paramObject3;
    return filter$Ex(localframe18.lambda$Fn17, paramObject2);
  }

  public static Object deleteDuplicates(Object paramObject)
  {
    return deleteDuplicates(paramObject, Scheme.isEqual);
  }

  public static Object deleteDuplicates(Object paramObject, Procedure paramProcedure)
  {
    frame19 localframe19 = new frame19();
    localframe19.maybe$Mn$Eq = paramProcedure;
    return localframe19.lambda30recur(paramObject);
  }

  public static Object deleteDuplicates$Ex(Object paramObject)
  {
    return deleteDuplicates$Ex(paramObject, Scheme.isEqual);
  }

  public static Object deleteDuplicates$Ex(Object paramObject, Procedure paramProcedure)
  {
    frame20 localframe20 = new frame20();
    localframe20.maybe$Mn$Eq = paramProcedure;
    return localframe20.lambda31recur(paramObject);
  }

  public static Object drop(Object paramObject, IntNum paramIntNum)
  {
    try
    {
      while (true)
      {
        Number localNumber = (Number)paramIntNum;
        if (numbers.isZero(localNumber))
          return paramObject;
        paramObject = lists.cdr.apply1(paramObject);
        paramIntNum = AddOp.$Mn.apply2(paramIntNum, Lit1);
      }
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "zero?", 1, paramIntNum);
    }
  }

  public static Object dropRight(Object paramObject, IntNum paramIntNum)
  {
    return lambda1recur(paramObject, drop(paramObject, paramIntNum));
  }

  public static Object dropRight$Ex(Object paramObject, IntNum paramIntNum)
  {
    Object localObject1 = drop(paramObject, paramIntNum);
    Object localObject3;
    if (lists.isPair(localObject1))
    {
      Object localObject2 = lists.cdr.apply1(localObject1);
      localObject3 = paramObject;
      while (lists.isPair(localObject2))
      {
        localObject3 = lists.cdr.apply1(localObject3);
        localObject2 = lists.cdr.apply1(localObject2);
      }
    }
    try
    {
      Pair localPair = (Pair)localObject3;
      lists.setCdr$Ex(localPair, LList.Empty);
      return paramObject;
      return LList.Empty;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-cdr!", 1, localObject3);
    }
  }

  public static Object dropWhile(Procedure paramProcedure, Object paramObject)
  {
    while (true)
    {
      if (isNullList(paramObject) != Boolean.FALSE)
        return LList.Empty;
      if (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE)
        break;
      paramObject = lists.cdr.apply1(paramObject);
    }
    return paramObject;
  }

  public static Object eighth(Object paramObject)
  {
    return lists.cadddr.apply1(lists.cddddr.apply1(paramObject));
  }

  public static Object every$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame27 localframe27 = new frame27();
    localframe27.pred = paramProcedure;
    localframe27.lis1 = paramObject;
    localframe27.lists = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localframe27.lists))
      return call_with_values.callWithValues(localframe27.lambda$Fn24, localframe27.lambda$Fn25);
    Object localObject1 = isNullList(localframe27.lis1);
    if (localObject1 != Boolean.FALSE)
      return localObject1;
    Object localObject2 = lists.car.apply1(localframe27.lis1);
    Object localObject4;
    for (Object localObject3 = lists.cdr.apply1(localframe27.lis1); ; localObject3 = lists.cdr.apply1(localObject3))
    {
      if (isNullList(localObject3) != Boolean.FALSE)
        return localframe27.pred.apply1(localObject2);
      localObject4 = localframe27.pred.apply1(localObject2);
      if (localObject4 == Boolean.FALSE)
        break;
      localObject2 = lists.car.apply1(localObject3);
    }
    return localObject4;
  }

  public static Object fifth(Object paramObject)
  {
    return lists.car.apply1(lists.cddddr.apply1(paramObject));
  }

  public static Object filter(Procedure paramProcedure, Object paramObject)
  {
    Object localObject1 = LList.Empty;
    while (true)
    {
      if (isNullList(paramObject) != Boolean.FALSE);
      try
      {
        LList localLList = (LList)localObject1;
        return lists.reverse$Ex(localLList);
        Object localObject2 = lists.car.apply1(paramObject);
        Object localObject3 = lists.cdr.apply1(paramObject);
        if (paramProcedure.apply1(localObject2) != Boolean.FALSE)
        {
          localObject1 = lists.cons(localObject2, localObject1);
          paramObject = localObject3;
          continue;
        }
        paramObject = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "reverse!", 1, localObject1);
      }
    }
  }

  // ERROR //
  public static Object filter$Ex(Procedure paramProcedure, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_2
    //   3: invokestatic 1124	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: getstatic 1130	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   9: if_acmpeq +5 -> 14
    //   12: aload_2
    //   13: areturn
    //   14: aload_0
    //   15: getstatic 1041	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   18: aload_2
    //   19: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: getstatic 1130	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   28: if_acmpne +14 -> 42
    //   31: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   34: aload_2
    //   35: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: astore_2
    //   39: goto -37 -> 2
    //   42: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   45: aload_2
    //   46: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore_3
    //   50: aload_2
    //   51: astore 4
    //   53: aload_3
    //   54: astore 5
    //   56: aload 5
    //   58: invokestatic 1115	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   61: ifeq -49 -> 12
    //   64: aload_0
    //   65: getstatic 1041	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   68: aload 5
    //   70: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: getstatic 1130	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   79: if_acmpeq +24 -> 103
    //   82: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   85: aload 5
    //   87: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: astore 12
    //   92: aload 5
    //   94: astore 4
    //   96: aload 12
    //   98: astore 5
    //   100: goto -44 -> 56
    //   103: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   106: aload 5
    //   108: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: astore 6
    //   113: aload 6
    //   115: invokestatic 1115	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   118: ifeq +69 -> 187
    //   121: aload_0
    //   122: getstatic 1041	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   125: aload 6
    //   127: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   133: getstatic 1130	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   136: if_acmpeq +38 -> 174
    //   139: aload 4
    //   141: checkcast 1033	gnu/lists/Pair
    //   144: astore 10
    //   146: aload 10
    //   148: aload 6
    //   150: invokestatic 1145	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   153: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   156: aload 6
    //   158: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: astore 11
    //   163: aload 6
    //   165: astore 4
    //   167: aload 11
    //   169: astore 5
    //   171: goto -115 -> 56
    //   174: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   177: aload 6
    //   179: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   182: astore 6
    //   184: goto -71 -> 113
    //   187: aload 4
    //   189: checkcast 1033	gnu/lists/Pair
    //   192: astore 8
    //   194: aload 8
    //   196: aload 6
    //   198: invokestatic 1145	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   201: aload_2
    //   202: areturn
    //   203: astore 9
    //   205: new 1052	gnu/mapping/WrongType
    //   208: dup
    //   209: aload 9
    //   211: ldc_w 1147
    //   214: iconst_1
    //   215: aload 4
    //   217: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   220: athrow
    //   221: astore 7
    //   223: new 1052	gnu/mapping/WrongType
    //   226: dup
    //   227: aload 7
    //   229: ldc_w 1147
    //   232: iconst_1
    //   233: aload 4
    //   235: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   139	146	203	java/lang/ClassCastException
    //   187	194	221	java/lang/ClassCastException
  }

  public static Object filterMap$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame13 localframe13 = new frame13();
    localframe13.f = paramProcedure;
    LList localLList1 = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList1))
      return localframe13.lambda23recur(lists.cons(paramObject, localLList1), LList.Empty);
    LList localLList2 = LList.Empty;
    Object localObject1 = paramObject;
    Object localObject2 = localLList2;
    while (true)
    {
      if (isNullList(localObject1) != Boolean.FALSE);
      try
      {
        LList localLList3 = (LList)localObject2;
        return lists.reverse$Ex(localLList3);
        Object localObject3 = localframe13.f.apply1(lists.car.apply1(localObject1));
        Object localObject4 = lists.cdr.apply1(localObject1);
        if (localObject3 != Boolean.FALSE)
        {
          localObject2 = lists.cons(localObject3, localObject2);
          localObject1 = localObject4;
          continue;
        }
        localObject1 = localObject4;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "reverse!", 1, localObject2);
      }
    }
  }

  public static Object find(Object paramObject1, Object paramObject2)
  {
    try
    {
      Procedure localProcedure = (Procedure)paramObject1;
      Object localObject = findTail(localProcedure, paramObject2);
      if (localObject != Boolean.FALSE)
        return lists.car.apply1(localObject);
      return Boolean.FALSE;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "find-tail", 0, paramObject1);
    }
  }

  public static Object findTail(Procedure paramProcedure, Object paramObject)
  {
    while (true)
    {
      Object localObject = isNullList(paramObject);
      try
      {
        Boolean localBoolean = Boolean.FALSE;
        if (localObject != localBoolean);
        int j;
        for (int i = 1; ; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0)
            break label68;
          if (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE)
            break;
          return paramObject;
        }
        paramObject = lists.cdr.apply1(paramObject);
        continue;
        label68: if (j != 0)
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject);
      }
    }
  }

  public static Object fold$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame7 localframe7 = new frame7();
    localframe7.kons = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList))
      return localframe7.lambda14lp(lists.cons(paramObject2, localLList), paramObject1);
    Object localObject1 = paramObject2;
    Object localObject2 = paramObject1;
    while (true)
    {
      if (isNullList(localObject1) != Boolean.FALSE)
        return localObject2;
      Object localObject3 = lists.cdr.apply1(localObject1);
      localObject2 = localframe7.kons.apply2(lists.car.apply1(localObject1), localObject2);
      localObject1 = localObject3;
    }
  }

  public static Object foldRight$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame9 localframe9 = new frame9();
    localframe9.kons = paramProcedure;
    localframe9.knil = paramObject1;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList))
      return localframe9.lambda17recur(lists.cons(paramObject2, localLList));
    return localframe9.lambda18recur(paramObject2);
  }

  public static Object iota(IntNum paramIntNum)
  {
    return iota(paramIntNum, Lit0, Lit1);
  }

  public static Object iota(IntNum paramIntNum, Numeric paramNumeric)
  {
    return iota(paramIntNum, paramNumeric, Lit1);
  }

  public static Object iota(IntNum paramIntNum, Numeric paramNumeric1, Numeric paramNumeric2)
  {
    if (IntNum.compare(paramIntNum, 0L) < 0)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = iota;
      arrayOfObject[1] = paramIntNum;
      misc.error$V("Negative step count", arrayOfObject);
    }
    Object localObject1 = AddOp.$Pl.apply2(paramNumeric1, MultiplyOp.$St.apply2(IntNum.add(paramIntNum, -1), paramNumeric2));
    Object localObject2;
    try
    {
      Numeric localNumeric = (Numeric)localObject1;
      localObject2 = LList.Empty;
      Object localObject4;
      for (Object localObject3 = localNumeric; Scheme.numLEq.apply2(paramIntNum, Lit0) == Boolean.FALSE; localObject3 = localObject4)
      {
        paramIntNum = AddOp.$Mn.apply2(paramIntNum, Lit1);
        localObject4 = AddOp.$Mn.apply2(localObject3, paramNumeric2);
        localObject2 = lists.cons(localObject3, localObject2);
      }
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "last-val", -2, localObject1);
    }
    return localObject2;
  }

  public static Object isCircularList(Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    Object localObject3;
    for (Object localObject1 = paramObject; ; localObject1 = localObject3)
    {
      bool1 = lists.isPair(paramObject);
      if (!bool1)
        break label99;
      Object localObject2 = lists.cdr.apply1(paramObject);
      bool2 = lists.isPair(localObject2);
      if (!bool2)
        break;
      paramObject = lists.cdr.apply1(localObject2);
      localObject3 = lists.cdr.apply1(localObject1);
      int i;
      if (paramObject == localObject3)
        i = 1;
      while (i != 0)
        if (i != 0)
        {
          return Boolean.TRUE;
          i = 0;
        }
        else
        {
          return Boolean.FALSE;
        }
    }
    if (bool2)
      return Boolean.TRUE;
    return Boolean.FALSE;
    label99: if (bool1)
      return Boolean.TRUE;
    return Boolean.FALSE;
  }

  public static Object isDottedList(Object paramObject)
  {
    Object localObject1 = paramObject;
    if (lists.isPair(paramObject))
    {
      Object localObject2 = lists.cdr.apply1(paramObject);
      if (lists.isPair(localObject2))
      {
        paramObject = lists.cdr.apply1(localObject2);
        Object localObject3 = lists.cdr.apply1(localObject1);
        if (paramObject == localObject3);
        int j;
        for (int i = 1; ; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0)
            break label72;
          localObject1 = localObject3;
          break;
        }
        label72: if (j != 0)
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      if (lists.isNull(localObject2))
        return Boolean.FALSE;
      return Boolean.TRUE;
    }
    if (lists.isNull(paramObject))
      return Boolean.FALSE;
    return Boolean.TRUE;
  }

  public static boolean isNotPair(Object paramObject)
  {
    return 0x1 & true + lists.isPair(paramObject);
  }

  public static Object isNullList(Object paramObject)
  {
    if ((paramObject instanceof Pair))
      return Boolean.FALSE;
    if (paramObject == LList.Empty)
      return Boolean.TRUE;
    return misc.error$V("null-list?: argument out of domain", new Object[] { paramObject });
  }

  public static Object isProperList(Object paramObject)
  {
    Object localObject1 = paramObject;
    if (lists.isPair(paramObject))
    {
      Object localObject2 = lists.cdr.apply1(paramObject);
      if (lists.isPair(localObject2))
      {
        paramObject = lists.cdr.apply1(localObject2);
        Object localObject3 = lists.cdr.apply1(localObject1);
        if (paramObject == localObject3);
        int j;
        for (int i = 1; ; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0)
            break label72;
          localObject1 = localObject3;
          break;
        }
        label72: if (j != 0)
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      if (lists.isNull(localObject2))
        return Boolean.TRUE;
      return Boolean.FALSE;
    }
    if (lists.isNull(paramObject))
      return Boolean.TRUE;
    return Boolean.FALSE;
  }

  public static Object lambda1recur(Object paramObject1, Object paramObject2)
  {
    if (lists.isPair(paramObject2))
      return lists.cons(lists.car.apply1(paramObject1), lambda1recur(lists.cdr.apply1(paramObject1), lists.cdr.apply1(paramObject2)));
    return LList.Empty;
  }

  public static Object last(Object paramObject)
  {
    GenericProc localGenericProc = lists.car;
    try
    {
      Pair localPair = (Pair)paramObject;
      return localGenericProc.apply1(lastPair(localPair));
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "last-pair", 0, paramObject);
    }
  }

  public static Object lastPair(Pair paramPair)
  {
    while (true)
    {
      Object localObject = lists.cdr.apply1(paramPair);
      if (!lists.isPair(localObject))
        break;
      paramPair = localObject;
    }
    return paramPair;
  }

  public static Object length$Pl(Object paramObject)
  {
    Object localObject1 = Lit0;
    Object localObject2 = paramObject;
    Object localObject4;
    if (lists.isPair(paramObject))
    {
      Object localObject3 = lists.cdr.apply1(paramObject);
      localObject4 = AddOp.$Pl.apply2(localObject1, Lit1);
      if (!lists.isPair(localObject3))
        break label122;
      paramObject = lists.cdr.apply1(localObject3);
      Object localObject5 = lists.cdr.apply1(localObject2);
      Object localObject6 = AddOp.$Pl.apply2(localObject4, Lit1);
      if (paramObject == localObject5);
      int j;
      for (int i = 1; ; i = 0)
      {
        j = 0x1 & i + 1;
        if (j == 0)
          break label107;
        localObject1 = localObject6;
        localObject2 = localObject5;
        break;
      }
      label107: if (j != 0)
        localObject1 = Boolean.TRUE;
    }
    else
    {
      return localObject1;
    }
    return Boolean.FALSE;
    label122: return localObject4;
  }

  public static Object list$Eq$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    boolean bool1 = lists.isNull(localLList);
    if (bool1)
    {
      if (bool1)
        return Boolean.TRUE;
      return Boolean.FALSE;
    }
    Object localObject1 = lists.car.apply1(localLList);
    Object localObject3;
    Object localObject4;
    for (Object localObject2 = lists.cdr.apply1(localLList); ; localObject2 = localObject4)
    {
      boolean bool2 = lists.isNull(localObject2);
      if (bool2)
      {
        if (bool2)
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      localObject3 = lists.car.apply1(localObject2);
      localObject4 = lists.cdr.apply1(localObject2);
      if (localObject1 != localObject3)
        break;
      localObject1 = localObject3;
    }
    Object localObject5 = localObject3;
    while (true)
    {
      if (isNullList(localObject1) != Boolean.FALSE)
      {
        Object localObject8 = isNullList(localObject5);
        if (localObject8 != Boolean.FALSE)
        {
          localObject2 = localObject4;
          localObject1 = localObject5;
          break;
        }
        return localObject8;
      }
      Object localObject6 = isNullList(localObject5);
      try
      {
        Boolean localBoolean = Boolean.FALSE;
        if (localObject6 != localBoolean);
        int j;
        Object localObject7;
        for (int i = 1; ; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0)
            break label252;
          localObject7 = Scheme.applyToArgs.apply3(paramObject, lists.car.apply1(localObject1), lists.car.apply1(localObject5));
          if (localObject7 == Boolean.FALSE)
            break label249;
          localObject1 = lists.cdr.apply1(localObject1);
          localObject5 = lists.cdr.apply1(localObject5);
          break;
        }
        label249: return localObject7;
        label252: if (j != 0)
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject6);
      }
    }
  }

  public static LList listCopy(LList paramLList)
  {
    Object localObject1 = LList.Empty;
    Object localObject2 = LList.Empty;
    if (lists.isPair(paramLList))
    {
      Pair localPair1 = lists.cons(lists.car.apply1(paramLList), LList.Empty);
      if (localObject2 == LList.Empty)
        localObject1 = localPair1;
      while (true)
      {
        localObject2 = localPair1;
        paramLList = (LList)lists.cdr.apply1(paramLList);
        break;
        try
        {
          Pair localPair2 = (Pair)localObject2;
          lists.setCdr$Ex(localPair2, localPair1);
        }
        catch (ClassCastException localClassCastException)
        {
          throw new WrongType(localClassCastException, "set-cdr!", 1, localObject2);
        }
      }
    }
    return localObject1;
  }

  public static Object listIndex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame30 localframe30 = new frame30();
    localframe30.pred = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList))
      return localframe30.lambda44lp(lists.cons(paramObject, localLList), Lit0);
    Object localObject1 = Lit0;
    Object localObject2 = paramObject;
    while (true)
    {
      Object localObject3 = isNullList(localObject2);
      try
      {
        Boolean localBoolean = Boolean.FALSE;
        if (localObject3 != localBoolean);
        int j;
        for (int i = 1; ; i = 0)
        {
          j = 0x1 & i + 1;
          if (j == 0)
            break label141;
          if (localframe30.pred.apply1(lists.car.apply1(localObject2)) == Boolean.FALSE)
            break;
          return localObject1;
        }
        localObject2 = lists.cdr.apply1(localObject2);
        localObject1 = AddOp.$Pl.apply2(localObject1, Lit1);
        continue;
        label141: if (j != 0)
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "x", -2, localObject3);
      }
    }
  }

  public static Object listTabulate(Object paramObject, Procedure paramProcedure)
  {
    int i = 0x1 & true + numbers.isInteger(paramObject);
    if (i != 0)
      if (i == 0);
    Object localObject2;
    while (true)
    {
      misc.error$V("list-tabulate arg#1 must be a non-negative integer", new Object[0]);
      do
      {
        Object localObject1 = AddOp.$Mn.apply2(paramObject, Lit1);
        localObject2 = LList.Empty;
        while (Scheme.numLss.apply2(localObject1, Lit0) == Boolean.FALSE)
        {
          Object localObject3 = AddOp.$Mn.apply2(localObject1, Lit1);
          localObject2 = lists.cons(paramProcedure.apply1(localObject1), localObject2);
          localObject1 = localObject3;
        }
      }
      while (Scheme.numLss.apply2(paramObject, Lit0) == Boolean.FALSE);
    }
    return localObject2;
  }

  public static Object lset$Eq$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    int i = 0x1 & true + lists.isPair(localLList);
    if (i != 0)
    {
      if (i != 0)
        return Boolean.TRUE;
      return Boolean.FALSE;
    }
    Object localObject1 = lists.car.apply1(localLList);
    Object localObject2 = lists.cdr.apply1(localLList);
    int j = 0x1 & true + lists.isPair(localObject2);
    if (j != 0)
    {
      if (j != 0)
        return Boolean.TRUE;
      return Boolean.FALSE;
    }
    Object localObject3 = lists.car.apply1(localObject2);
    Object localObject4 = lists.cdr.apply1(localObject2);
    int k;
    label108: Boolean localBoolean;
    label123: Object localObject5;
    if (localObject1 == localObject3)
    {
      k = 1;
      if (k == 0)
        break label160;
      if (k == 0)
        break label152;
      localBoolean = Boolean.TRUE;
      localObject5 = localBoolean;
    }
    while (true)
    {
      if (localObject5 == Boolean.FALSE)
        break label191;
      localObject1 = localObject3;
      localObject2 = localObject4;
      break;
      k = 0;
      break label108;
      label152: localBoolean = Boolean.FALSE;
      break label123;
      label160: localObject5 = $PcLset2$Ls$Eq(paramProcedure, localObject1, localObject3);
      if (localObject5 != Boolean.FALSE)
        localObject5 = $PcLset2$Ls$Eq(paramProcedure, localObject3, localObject1);
    }
    label191: return localObject5;
  }

  public static Object lset$Ls$Eq$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    int i = 0x1 & true + lists.isPair(localLList);
    if (i != 0)
    {
      if (i != 0)
        return Boolean.TRUE;
      return Boolean.FALSE;
    }
    Object localObject1 = lists.car.apply1(localLList);
    Object localObject2 = lists.cdr.apply1(localLList);
    int j = 0x1 & true + lists.isPair(localObject2);
    if (j != 0)
    {
      if (j != 0)
        return Boolean.TRUE;
      return Boolean.FALSE;
    }
    Object localObject3 = lists.car.apply1(localObject2);
    Object localObject4 = lists.cdr.apply1(localObject2);
    int k;
    label108: Boolean localBoolean;
    if (localObject3 == localObject1)
    {
      k = 1;
      if (k == 0)
        break label160;
      if (k == 0)
        break label152;
      localBoolean = Boolean.TRUE;
    }
    label123: for (Object localObject5 = localBoolean; ; localObject5 = $PcLset2$Ls$Eq(paramProcedure, localObject1, localObject3))
    {
      if (localObject5 == Boolean.FALSE)
        break label173;
      localObject1 = localObject3;
      localObject2 = localObject4;
      break;
      k = 0;
      break label108;
      localBoolean = Boolean.FALSE;
      break label123;
    }
    label152: label160: label173: return localObject5;
  }

  public static Object lsetAdjoin$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame32 localframe32 = new frame32();
    localframe32.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return fold$V(localframe32.lambda$Fn30, paramObject, localLList, new Object[0]);
  }

  public static Object lsetDiff$PlIntersection$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame53 localframe53 = new frame53();
    localframe53.$Eq = paramProcedure;
    localframe53.lists = LList.makeList(paramArrayOfObject, 0);
    if (every$V(null$Mnlist$Qu, localframe53.lists, new Object[0]) != Boolean.FALSE)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramObject;
      arrayOfObject2[1] = LList.Empty;
      return misc.values(arrayOfObject2);
    }
    if (lists.memq(paramObject, localframe53.lists) != Boolean.FALSE)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = LList.Empty;
      arrayOfObject1[1] = paramObject;
      return misc.values(arrayOfObject1);
    }
    return partition$Ex(localframe53.lambda$Fn55, paramObject);
  }

  public static Object lsetDiff$PlIntersection$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame51 localframe51 = new frame51();
    localframe51.$Eq = paramProcedure;
    localframe51.lists = LList.makeList(paramArrayOfObject, 0);
    if (every$V(null$Mnlist$Qu, localframe51.lists, new Object[0]) != Boolean.FALSE)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramObject;
      arrayOfObject2[1] = LList.Empty;
      return misc.values(arrayOfObject2);
    }
    if (lists.memq(paramObject, localframe51.lists) != Boolean.FALSE)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = LList.Empty;
      arrayOfObject1[1] = paramObject;
      return misc.values(arrayOfObject1);
    }
    return partition(localframe51.lambda$Fn53, paramObject);
  }

  public static Object lsetDifference$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame43 localframe43 = new frame43();
    localframe43.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    localframe43.lists = filter(lists.pair$Qu, localLList);
    if (lists.isNull(localframe43.lists))
      return paramObject;
    if (lists.memq(paramObject, localframe43.lists) != Boolean.FALSE)
      return LList.Empty;
    return filter$Ex(localframe43.lambda$Fn43, paramObject);
  }

  public static Object lsetDifference$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame41 localframe41 = new frame41();
    localframe41.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    localframe41.lists = filter(lists.pair$Qu, localLList);
    if (lists.isNull(localframe41.lists))
      return paramObject;
    if (lists.memq(paramObject, localframe41.lists) != Boolean.FALSE)
      return LList.Empty;
    return filter(localframe41.lambda$Fn41, paramObject);
  }

  public static Object lsetIntersection$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame39 localframe39 = new frame39();
    localframe39.$Eq = paramProcedure;
    localframe39.lists = delete(paramObject, LList.makeList(paramArrayOfObject, 0), Scheme.isEq);
    if (any$V(null$Mnlist$Qu, localframe39.lists, new Object[0]) != Boolean.FALSE)
      return LList.Empty;
    if (lists.isNull(localframe39.lists))
      return paramObject;
    return filter$Ex(localframe39.lambda$Fn39, paramObject);
  }

  public static Object lsetIntersection$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame37 localframe37 = new frame37();
    localframe37.$Eq = paramProcedure;
    localframe37.lists = delete(paramObject, LList.makeList(paramArrayOfObject, 0), Scheme.isEq);
    if (any$V(null$Mnlist$Qu, localframe37.lists, new Object[0]) != Boolean.FALSE)
      return LList.Empty;
    if (lists.isNull(localframe37.lists))
      return paramObject;
    return filter(localframe37.lambda$Fn37, paramObject);
  }

  public static Object lsetUnion$Ex$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame35 localframe35 = new frame35();
    localframe35.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe35.lambda$Fn34, LList.Empty, localLList);
  }

  public static Object lsetUnion$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame33 localframe33 = new frame33();
    localframe33.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe33.lambda$Fn31, LList.Empty, localLList);
  }

  public static Object lsetXor$Ex$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame48 localframe48 = new frame48();
    localframe48.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe48.lambda$Fn49, LList.Empty, localLList);
  }

  public static Object lsetXor$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    frame45 localframe45 = new frame45();
    localframe45.$Eq = paramProcedure;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return reduce(localframe45.lambda$Fn45, LList.Empty, localLList);
  }

  public static Object makeList$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    int i = 0x1 & true + numbers.isInteger(paramObject);
    label34: Object localObject1;
    if (i != 0)
    {
      if (i != 0)
        misc.error$V("make-list arg#1 must be a non-negative integer", new Object[0]);
      if (!lists.isNull(localLList))
        break label115;
      localObject1 = Boolean.FALSE;
    }
    Object localObject2;
    while (true)
    {
      localObject2 = LList.Empty;
      Object localObject3 = paramObject;
      while (Scheme.numLEq.apply2(localObject3, Lit0) == Boolean.FALSE)
      {
        localObject3 = AddOp.$Mn.apply2(localObject3, Lit1);
        localObject2 = lists.cons(localObject1, localObject2);
      }
      if (Scheme.numLss.apply2(paramObject, Lit0) == Boolean.FALSE)
        break label34;
      break;
      label115: if (lists.isNull(lists.cdr.apply1(localLList)))
      {
        localObject1 = lists.car.apply1(localLList);
      }
      else
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = lists.cons(paramObject, localLList);
        localObject1 = misc.error$V("Too many arguments to MAKE-LIST", arrayOfObject);
      }
    }
    return localObject2;
  }

  public static Object map$Ex$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    frame12 localframe12 = new frame12();
    localframe12.f = paramProcedure;
    Object localObject1 = LList.makeList(paramArrayOfObject, 0);
    Object localObject2;
    if (lists.isPair(localObject1))
      localObject2 = paramObject;
    while (true)
    {
      Object localObject4;
      Object localObject5;
      if (isNullList(localObject2) == Boolean.FALSE)
      {
        Object localObject3 = $PcCars$PlCdrs$SlNoTest$SlPair(localObject1);
        localObject4 = lists.car.apply1(localObject3);
        localObject5 = lists.cdr.apply1(localObject3);
      }
      try
      {
        Pair localPair = (Pair)localObject2;
        lists.setCar$Ex(localPair, Scheme.apply.apply3(localframe12.f, lists.car.apply1(localObject2), localObject4));
        localObject2 = lists.cdr.apply1(localObject2);
        localObject1 = localObject5;
        continue;
        pairForEach$V(localframe12.lambda$Fn11, paramObject, new Object[0]);
        return paramObject;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-car!", 1, localObject2);
      }
    }
  }

  public static Object ninth(Object paramObject)
  {
    return lists.car.apply1(lists.cddddr.apply1(lists.cddddr.apply1(paramObject)));
  }

  public static Object pairFold$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    Object localObject5;
    Object localObject2;
    Object localObject6;
    if (lists.isPair(localLList))
    {
      localObject5 = lists.cons(paramObject2, localLList);
      localObject2 = paramObject1;
      localObject6 = $PcCdrs(localObject5);
      if (!lists.isNull(localObject6));
    }
    while (true)
    {
      return localObject2;
      Apply localApply = Scheme.apply;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localObject5;
      arrayOfObject[1] = LList.list1(localObject2);
      Object localObject7 = localApply.apply2(paramProcedure, append$Ex$V(arrayOfObject));
      localObject5 = localObject6;
      localObject2 = localObject7;
      break;
      Object localObject1 = paramObject2;
      Object localObject4;
      for (localObject2 = paramObject1; isNullList(localObject1) == Boolean.FALSE; localObject2 = localObject4)
      {
        Object localObject3 = lists.cdr.apply1(localObject1);
        localObject4 = paramProcedure.apply2(localObject1, localObject2);
        localObject1 = localObject3;
      }
    }
  }

  public static Object pairFoldRight$V(Procedure paramProcedure, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    frame10 localframe10 = new frame10();
    localframe10.f = paramProcedure;
    localframe10.zero = paramObject1;
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList))
      return localframe10.lambda19recur(lists.cons(paramObject2, localLList));
    return localframe10.lambda20recur(paramObject2);
  }

  public static Object pairForEach$V(Procedure paramProcedure, Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList))
    {
      Object localObject4;
      for (Object localObject3 = lists.cons(paramObject, localLList); ; localObject3 = localObject4)
      {
        localObject4 = $PcCdrs(localObject3);
        if (!lists.isPair(localObject4))
          break;
        Scheme.apply.apply2(paramProcedure, localObject3);
      }
      return Values.empty;
    }
    Object localObject2;
    for (Object localObject1 = paramObject; isNullList(localObject1) == Boolean.FALSE; localObject1 = localObject2)
    {
      localObject2 = lists.cdr.apply1(localObject1);
      paramProcedure.apply1(localObject1);
    }
    return Values.empty;
  }

  // ERROR //
  public static Object partition(Procedure paramProcedure, Object paramObject)
  {
    // Byte code:
    //   0: getstatic 465	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   3: astore_2
    //   4: getstatic 465	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   7: astore_3
    //   8: aload_2
    //   9: astore 4
    //   11: aload_1
    //   12: invokestatic 1124	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: getstatic 1130	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   18: if_acmpeq +46 -> 64
    //   21: iconst_2
    //   22: anewarray 348	java/lang/Object
    //   25: astore 7
    //   27: aload 4
    //   29: checkcast 461	gnu/lists/LList
    //   32: astore 9
    //   34: aload 7
    //   36: iconst_0
    //   37: aload 9
    //   39: invokestatic 1312	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   42: aastore
    //   43: aload_3
    //   44: checkcast 461	gnu/lists/LList
    //   47: astore 11
    //   49: aload 7
    //   51: iconst_1
    //   52: aload 11
    //   54: invokestatic 1312	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   57: aastore
    //   58: aload 7
    //   60: invokestatic 1201	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   63: areturn
    //   64: getstatic 1041	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   67: aload_1
    //   68: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: astore 5
    //   73: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   76: aload_1
    //   77: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore 6
    //   82: aload_0
    //   83: aload 5
    //   85: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: getstatic 1130	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   91: if_acmpeq +18 -> 109
    //   94: aload 5
    //   96: aload 4
    //   98: invokestatic 1024	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   101: astore 4
    //   103: aload 6
    //   105: astore_1
    //   106: goto -95 -> 11
    //   109: aload 5
    //   111: aload_3
    //   112: invokestatic 1024	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   115: astore_3
    //   116: aload 6
    //   118: astore_1
    //   119: goto -108 -> 11
    //   122: astore 8
    //   124: new 1052	gnu/mapping/WrongType
    //   127: dup
    //   128: aload 8
    //   130: ldc_w 1314
    //   133: iconst_1
    //   134: aload 4
    //   136: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   139: athrow
    //   140: astore 10
    //   142: new 1052	gnu/mapping/WrongType
    //   145: dup
    //   146: aload 10
    //   148: ldc_w 1314
    //   151: iconst_1
    //   152: aload_3
    //   153: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   156: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   27	34	122	java/lang/ClassCastException
    //   43	49	140	java/lang/ClassCastException
  }

  // ERROR //
  public static Object partition$Ex(Procedure paramProcedure, Object paramObject)
  {
    // Byte code:
    //   0: getstatic 788	gnu/kawa/slib/srfi1:Lit2	Lgnu/mapping/SimpleSymbol;
    //   3: getstatic 465	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   6: invokestatic 1024	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   9: astore_2
    //   10: getstatic 788	gnu/kawa/slib/srfi1:Lit2	Lgnu/mapping/SimpleSymbol;
    //   13: getstatic 465	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   16: invokestatic 1024	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   19: astore_3
    //   20: aload_2
    //   21: astore 4
    //   23: aload_3
    //   24: astore 5
    //   26: aload_1
    //   27: invokestatic 1584	gnu/kawa/slib/srfi1:isNotPair	(Ljava/lang/Object;)Z
    //   30: ifeq +67 -> 97
    //   33: aload 4
    //   35: checkcast 1033	gnu/lists/Pair
    //   38: astore 13
    //   40: aload 13
    //   42: getstatic 465	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   45: invokestatic 1145	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   48: aload 5
    //   50: checkcast 1033	gnu/lists/Pair
    //   53: astore 15
    //   55: aload 15
    //   57: getstatic 465	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   60: invokestatic 1145	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   63: iconst_2
    //   64: anewarray 348	java/lang/Object
    //   67: astore 16
    //   69: aload 16
    //   71: iconst_0
    //   72: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   75: aload_2
    //   76: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: aastore
    //   80: aload 16
    //   82: iconst_1
    //   83: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   86: aload_3
    //   87: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: aastore
    //   91: aload 16
    //   93: invokestatic 1201	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   96: areturn
    //   97: aload_0
    //   98: getstatic 1041	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   101: aload_1
    //   102: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   105: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   108: getstatic 1130	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   111: if_acmpeq +34 -> 145
    //   114: aload 4
    //   116: checkcast 1033	gnu/lists/Pair
    //   119: astore 10
    //   121: aload 10
    //   123: aload_1
    //   124: invokestatic 1145	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   127: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   130: aload_1
    //   131: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: astore 11
    //   136: aload_1
    //   137: astore 4
    //   139: aload 11
    //   141: astore_1
    //   142: goto -116 -> 26
    //   145: aload 5
    //   147: checkcast 1033	gnu/lists/Pair
    //   150: astore 7
    //   152: aload 7
    //   154: aload_1
    //   155: invokestatic 1145	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   158: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   161: aload_1
    //   162: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: astore 8
    //   167: aload_1
    //   168: astore 5
    //   170: aload 8
    //   172: astore_1
    //   173: goto -147 -> 26
    //   176: astore 12
    //   178: new 1052	gnu/mapping/WrongType
    //   181: dup
    //   182: aload 12
    //   184: ldc_w 1147
    //   187: iconst_1
    //   188: aload 4
    //   190: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   193: athrow
    //   194: astore 14
    //   196: new 1052	gnu/mapping/WrongType
    //   199: dup
    //   200: aload 14
    //   202: ldc_w 1147
    //   205: iconst_1
    //   206: aload 5
    //   208: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   211: athrow
    //   212: astore 9
    //   214: new 1052	gnu/mapping/WrongType
    //   217: dup
    //   218: aload 9
    //   220: ldc_w 1147
    //   223: iconst_1
    //   224: aload 4
    //   226: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: astore 6
    //   232: new 1052	gnu/mapping/WrongType
    //   235: dup
    //   236: aload 6
    //   238: ldc_w 1147
    //   241: iconst_1
    //   242: aload 5
    //   244: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   247: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   33	40	176	java/lang/ClassCastException
    //   48	55	194	java/lang/ClassCastException
    //   114	121	212	java/lang/ClassCastException
    //   145	152	230	java/lang/ClassCastException
  }

  public static Object reduce(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    if (isNullList(paramObject2) != Boolean.FALSE)
      return paramObject1;
    return fold$V(paramProcedure, lists.car.apply1(paramObject2), lists.cdr.apply1(paramObject2), new Object[0]);
  }

  public static Object reduceRight(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    frame11 localframe11 = new frame11();
    localframe11.f = paramProcedure;
    if (isNullList(paramObject2) != Boolean.FALSE)
      return paramObject1;
    return localframe11.lambda21recur(lists.car.apply1(paramObject2), lists.cdr.apply1(paramObject2));
  }

  public static Object remove(Object paramObject1, Object paramObject2)
  {
    frame15 localframe15 = new frame15();
    localframe15.pred = paramObject1;
    return filter(localframe15.lambda$Fn14, paramObject2);
  }

  public static Object remove$Ex(Object paramObject1, Object paramObject2)
  {
    frame16 localframe16 = new frame16();
    localframe16.pred = paramObject1;
    return filter$Ex(localframe16.lambda$Fn15, paramObject2);
  }

  public static Object seventh(Object paramObject)
  {
    return lists.caddr.apply1(lists.cddddr.apply1(paramObject));
  }

  public static Object sixth(Object paramObject)
  {
    return lists.cadr.apply1(lists.cddddr.apply1(paramObject));
  }

  // ERROR //
  public static Object span(Procedure paramProcedure, Object paramObject)
  {
    // Byte code:
    //   0: getstatic 465	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   3: astore_2
    //   4: aload_1
    //   5: invokestatic 1124	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: getstatic 1130	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   11: if_acmpeq +35 -> 46
    //   14: iconst_2
    //   15: anewarray 348	java/lang/Object
    //   18: astore 7
    //   20: aload_2
    //   21: checkcast 461	gnu/lists/LList
    //   24: astore 9
    //   26: aload 7
    //   28: iconst_0
    //   29: aload 9
    //   31: invokestatic 1312	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   34: aastore
    //   35: aload 7
    //   37: iconst_1
    //   38: aload_1
    //   39: aastore
    //   40: aload 7
    //   42: invokestatic 1201	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   45: areturn
    //   46: getstatic 1041	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   49: aload_1
    //   50: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: astore_3
    //   54: aload_0
    //   55: aload_3
    //   56: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: getstatic 1130	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   62: if_acmpeq +20 -> 82
    //   65: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   68: aload_1
    //   69: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: astore_1
    //   73: aload_3
    //   74: aload_2
    //   75: invokestatic 1024	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   78: astore_2
    //   79: goto -75 -> 4
    //   82: iconst_2
    //   83: anewarray 348	java/lang/Object
    //   86: astore 4
    //   88: aload_2
    //   89: checkcast 461	gnu/lists/LList
    //   92: astore 6
    //   94: aload 4
    //   96: iconst_0
    //   97: aload 6
    //   99: invokestatic 1312	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   102: aastore
    //   103: aload 4
    //   105: iconst_1
    //   106: aload_1
    //   107: aastore
    //   108: aload 4
    //   110: invokestatic 1201	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   113: areturn
    //   114: astore 8
    //   116: new 1052	gnu/mapping/WrongType
    //   119: dup
    //   120: aload 8
    //   122: ldc_w 1314
    //   125: iconst_1
    //   126: aload_2
    //   127: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   130: athrow
    //   131: astore 5
    //   133: new 1052	gnu/mapping/WrongType
    //   136: dup
    //   137: aload 5
    //   139: ldc_w 1314
    //   142: iconst_1
    //   143: aload_2
    //   144: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   147: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   20	26	114	java/lang/ClassCastException
    //   88	94	131	java/lang/ClassCastException
  }

  public static Object span$Ex(Procedure paramProcedure, Object paramObject)
  {
    Object localObject1 = isNullList(paramObject);
    if (localObject1 != Boolean.FALSE)
    {
      if (localObject1 == Boolean.FALSE);
    }
    else
      while (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = LList.Empty;
        arrayOfObject[1] = paramObject;
        return misc.values(arrayOfObject);
      }
    Object localObject2 = lists.cdr.apply1(paramObject);
    Object localObject3 = paramObject;
    Object localObject4 = localObject2;
    Object localObject5;
    if (isNullList(localObject4) != Boolean.FALSE)
      localObject5 = localObject4;
    while (true)
    {
      return misc.values(new Object[] { paramObject, localObject5 });
      if (paramProcedure.apply1(lists.car.apply1(localObject4)) != Boolean.FALSE)
      {
        Object localObject6 = lists.cdr.apply1(localObject4);
        localObject3 = localObject4;
        localObject4 = localObject6;
        break;
      }
      try
      {
        Pair localPair = (Pair)localObject3;
        lists.setCdr$Ex(localPair, LList.Empty);
        localObject5 = localObject4;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, localObject3);
      }
    }
  }

  // ERROR //
  public static Object splitAt(Object paramObject, IntNum paramIntNum)
  {
    // Byte code:
    //   0: getstatic 465	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   3: astore_2
    //   4: aload_0
    //   5: astore_3
    //   6: aload_1
    //   7: checkcast 1271	java/lang/Number
    //   10: astore 5
    //   12: aload 5
    //   14: invokestatic 1277	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   17: ifeq +35 -> 52
    //   20: iconst_2
    //   21: anewarray 348	java/lang/Object
    //   24: astore 7
    //   26: aload_2
    //   27: checkcast 461	gnu/lists/LList
    //   30: astore 9
    //   32: aload 7
    //   34: iconst_0
    //   35: aload 9
    //   37: invokestatic 1312	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   40: aastore
    //   41: aload 7
    //   43: iconst_1
    //   44: aload_3
    //   45: aastore
    //   46: aload 7
    //   48: invokestatic 1201	kawa/lib/misc:values	([Ljava/lang/Object;)Ljava/lang/Object;
    //   51: areturn
    //   52: getstatic 1041	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   55: aload_3
    //   56: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: aload_2
    //   60: invokestatic 1024	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   63: astore_2
    //   64: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   67: aload_3
    //   68: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: astore 6
    //   73: getstatic 1280	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   76: aload_1
    //   77: getstatic 795	gnu/kawa/slib/srfi1:Lit1	Lgnu/math/IntNum;
    //   80: invokevirtual 1163	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: astore_1
    //   84: aload 6
    //   86: astore_3
    //   87: goto -81 -> 6
    //   90: astore 4
    //   92: new 1052	gnu/mapping/WrongType
    //   95: dup
    //   96: aload 4
    //   98: ldc_w 1282
    //   101: iconst_1
    //   102: aload_1
    //   103: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   106: athrow
    //   107: astore 8
    //   109: new 1052	gnu/mapping/WrongType
    //   112: dup
    //   113: aload 8
    //   115: ldc_w 1314
    //   118: iconst_1
    //   119: aload_2
    //   120: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   123: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   6	12	90	java/lang/ClassCastException
    //   26	32	107	java/lang/ClassCastException
  }

  public static Object splitAt$Ex(Object paramObject, IntNum paramIntNum)
  {
    if (numbers.isZero(paramIntNum))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = LList.Empty;
      arrayOfObject[1] = paramObject;
      return misc.values(arrayOfObject);
    }
    Object localObject1 = drop(paramObject, IntNum.add(paramIntNum, -1));
    Object localObject2 = lists.cdr.apply1(localObject1);
    try
    {
      Pair localPair = (Pair)localObject1;
      lists.setCdr$Ex(localPair, LList.Empty);
      return misc.values(new Object[] { paramObject, localObject2 });
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-cdr!", 1, localObject1);
    }
  }

  // ERROR //
  public static Object take(Object paramObject, IntNum paramIntNum)
  {
    // Byte code:
    //   0: getstatic 465	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   3: astore_2
    //   4: aload_1
    //   5: checkcast 1271	java/lang/Number
    //   8: astore 4
    //   10: aload 4
    //   12: invokestatic 1277	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   15: ifeq +15 -> 30
    //   18: aload_2
    //   19: checkcast 461	gnu/lists/LList
    //   22: astore 7
    //   24: aload 7
    //   26: invokestatic 1312	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   29: areturn
    //   30: getstatic 1048	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   33: aload_0
    //   34: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: astore 5
    //   39: getstatic 1280	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   42: aload_1
    //   43: getstatic 795	gnu/kawa/slib/srfi1:Lit1	Lgnu/math/IntNum;
    //   46: invokevirtual 1163	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: astore_1
    //   50: getstatic 1041	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   53: aload_0
    //   54: invokevirtual 1046	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: aload_2
    //   58: invokestatic 1024	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   61: astore_2
    //   62: aload 5
    //   64: astore_0
    //   65: goto -61 -> 4
    //   68: astore_3
    //   69: new 1052	gnu/mapping/WrongType
    //   72: dup
    //   73: aload_3
    //   74: ldc_w 1282
    //   77: iconst_1
    //   78: aload_1
    //   79: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   82: athrow
    //   83: astore 6
    //   85: new 1052	gnu/mapping/WrongType
    //   88: dup
    //   89: aload 6
    //   91: ldc_w 1314
    //   94: iconst_1
    //   95: aload_2
    //   96: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   99: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   4	10	68	java/lang/ClassCastException
    //   18	24	83	java/lang/ClassCastException
  }

  public static Object take$Ex(Object paramObject, IntNum paramIntNum)
  {
    if (numbers.isZero(paramIntNum))
      return LList.Empty;
    Object localObject = drop(paramObject, IntNum.add(paramIntNum, -1));
    try
    {
      Pair localPair = (Pair)localObject;
      lists.setCdr$Ex(localPair, LList.Empty);
      return paramObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-cdr!", 1, localObject);
    }
  }

  public static Object takeRight(Object paramObject, IntNum paramIntNum)
  {
    Object localObject1 = drop(paramObject, paramIntNum);
    Object localObject2 = paramObject;
    while (lists.isPair(localObject1))
    {
      localObject2 = lists.cdr.apply1(localObject2);
      localObject1 = lists.cdr.apply1(localObject1);
    }
    return localObject2;
  }

  public static Object takeWhile(Procedure paramProcedure, Object paramObject)
  {
    frame23 localframe23 = new frame23();
    localframe23.pred = paramProcedure;
    return localframe23.lambda34recur(paramObject);
  }

  public static Object takeWhile$Ex(Procedure paramProcedure, Object paramObject)
  {
    Object localObject1 = isNullList(paramObject);
    if (localObject1 != Boolean.FALSE)
    {
      if (localObject1 == Boolean.FALSE);
    }
    else
      while (paramProcedure.apply1(lists.car.apply1(paramObject)) == Boolean.FALSE)
        return LList.Empty;
    Object localObject2 = lists.cdr.apply1(paramObject);
    Object localObject3 = paramObject;
    Object localObject5;
    for (Object localObject4 = localObject2; ; localObject4 = localObject5)
    {
      if (!lists.isPair(localObject4))
        break label116;
      if (paramProcedure.apply1(lists.car.apply1(localObject4)) == Boolean.FALSE)
        break;
      localObject5 = lists.cdr.apply1(localObject4);
      localObject3 = localObject4;
    }
    try
    {
      Pair localPair = (Pair)localObject3;
      lists.setCdr$Ex(localPair, LList.Empty);
      label116: return paramObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "set-cdr!", 1, localObject3);
    }
  }

  public static Object tenth(Object paramObject)
  {
    return lists.cadr.apply1(lists.cddddr.apply1(lists.cddddr.apply1(paramObject)));
  }

  public static Object unfold$V(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList1 = LList.makeList(paramArrayOfObject, 0);
    if (lists.isPair(localLList1))
    {
      Object localObject3 = lists.car.apply1(localLList1);
      if (lists.isPair(lists.cdr.apply1(localLList1)))
      {
        Apply localApply = Scheme.apply;
        Object[] arrayOfObject = new Object[8];
        arrayOfObject[0] = misc.error;
        arrayOfObject[1] = "Too many arguments";
        arrayOfObject[2] = unfold;
        arrayOfObject[3] = paramProcedure1;
        arrayOfObject[4] = paramProcedure2;
        arrayOfObject[5] = paramProcedure3;
        arrayOfObject[6] = paramObject;
        arrayOfObject[7] = localLList1;
        return localApply.applyN(arrayOfObject);
      }
      Object localObject4 = LList.Empty;
      while (true)
      {
        if (paramProcedure1.apply1(paramObject) != Boolean.FALSE)
          return appendReverse$Ex(localObject4, Scheme.applyToArgs.apply2(localObject3, paramObject));
        Object localObject5 = paramProcedure3.apply1(paramObject);
        localObject4 = lists.cons(paramProcedure2.apply1(paramObject), localObject4);
        paramObject = localObject5;
      }
    }
    Object localObject1 = LList.Empty;
    while (true)
    {
      if (paramProcedure1.apply1(paramObject) != Boolean.FALSE);
      try
      {
        LList localLList2 = (LList)localObject1;
        return lists.reverse$Ex(localLList2);
        Object localObject2 = paramProcedure3.apply1(paramObject);
        localObject1 = lists.cons(paramProcedure2.apply1(paramObject), localObject1);
        paramObject = localObject2;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "reverse!", 1, localObject1);
      }
    }
  }

  public static Object unfoldRight(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject)
  {
    return unfoldRight(paramProcedure1, paramProcedure2, paramProcedure3, paramObject, LList.Empty);
  }

  public static Object unfoldRight(Procedure paramProcedure1, Procedure paramProcedure2, Procedure paramProcedure3, Object paramObject1, Object paramObject2)
  {
    Object localObject1 = paramObject2;
    while (true)
    {
      if (paramProcedure1.apply1(paramObject1) != Boolean.FALSE)
        return localObject1;
      Object localObject2 = paramProcedure3.apply1(paramObject1);
      localObject1 = lists.cons(paramProcedure2.apply1(paramObject1), localObject1);
      paramObject1 = localObject2;
    }
  }

  public static LList unzip1(Object paramObject)
  {
    Object localObject1 = LList.Empty;
    Object localObject2 = paramObject;
    while (true)
    {
      if (localObject2 == LList.Empty)
        return LList.reverseInPlace(localObject1);
      try
      {
        Pair localPair = (Pair)localObject2;
        Object localObject3 = localPair.getCdr();
        localObject1 = Pair.make(lists.car.apply1(localPair.getCar()), localObject1);
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "arg0", -2, localObject2);
      }
    }
  }

  public static Object unzip2(Object paramObject)
  {
    new frame();
    return frame.lambda2recur(paramObject);
  }

  public static Object unzip3(Object paramObject)
  {
    new frame1();
    return frame1.lambda5recur(paramObject);
  }

  public static Object unzip4(Object paramObject)
  {
    new frame3();
    return frame3.lambda8recur(paramObject);
  }

  public static Object unzip5(Object paramObject)
  {
    new frame5();
    return frame5.lambda11recur(paramObject);
  }

  public static Pair xcons(Object paramObject1, Object paramObject2)
  {
    return lists.cons(paramObject2, paramObject1);
  }

  public static Object zip$V(Object paramObject, Object[] paramArrayOfObject)
  {
    LList localLList = LList.makeList(paramArrayOfObject, 0);
    return Scheme.apply.apply4(Scheme.map, LangObjType.listType, paramObject, localLList);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+228->232, 82:+235->239, 83:+247->251, 87:+259->263, 88:+264->268, 89:+269->273, 90:+274->278, 91:+289->293, 93:+294->298, 95:+299->303, 96:+304->308, 97:+309->313, 98:+314->318, 99:+319->323, 100:+324->328, 101:+329->333, 110:+334->338, 111:+339->343, 112:+351->355, 113:+356->360, 114:+361->365, 115:+366->370, 116:+371->375, 120:+376->380, 121:+381->385, 147:+386->390, 149:+391->395, 152:+396->400
    //   233: aload_1
    //   234: aload_2
    //   235: invokespecial 1677	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   238: areturn
    //   239: aload_2
    //   240: checkcast 461	gnu/lists/LList
    //   243: astore 8
    //   245: aload 8
    //   247: invokestatic 1679	gnu/kawa/slib/srfi1:listCopy	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   250: areturn
    //   251: aload_2
    //   252: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   255: astore 6
    //   257: aload 6
    //   259: invokestatic 1685	gnu/kawa/slib/srfi1:iota	(Lgnu/math/IntNum;)Ljava/lang/Object;
    //   262: areturn
    //   263: aload_2
    //   264: invokestatic 1687	gnu/kawa/slib/srfi1:isProperList	(Ljava/lang/Object;)Ljava/lang/Object;
    //   267: areturn
    //   268: aload_2
    //   269: invokestatic 1689	gnu/kawa/slib/srfi1:isDottedList	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: areturn
    //   273: aload_2
    //   274: invokestatic 1691	gnu/kawa/slib/srfi1:isCircularList	(Ljava/lang/Object;)Ljava/lang/Object;
    //   277: areturn
    //   278: aload_2
    //   279: invokestatic 1584	gnu/kawa/slib/srfi1:isNotPair	(Ljava/lang/Object;)Z
    //   282: ifeq +7 -> 289
    //   285: getstatic 1133	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   288: areturn
    //   289: getstatic 1130	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   292: areturn
    //   293: aload_2
    //   294: invokestatic 1124	gnu/kawa/slib/srfi1:isNullList	(Ljava/lang/Object;)Ljava/lang/Object;
    //   297: areturn
    //   298: aload_2
    //   299: invokestatic 1693	gnu/kawa/slib/srfi1:length$Pl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: areturn
    //   303: aload_2
    //   304: invokestatic 1695	gnu/kawa/slib/srfi1:fifth	(Ljava/lang/Object;)Ljava/lang/Object;
    //   307: areturn
    //   308: aload_2
    //   309: invokestatic 1697	gnu/kawa/slib/srfi1:sixth	(Ljava/lang/Object;)Ljava/lang/Object;
    //   312: areturn
    //   313: aload_2
    //   314: invokestatic 1699	gnu/kawa/slib/srfi1:seventh	(Ljava/lang/Object;)Ljava/lang/Object;
    //   317: areturn
    //   318: aload_2
    //   319: invokestatic 1701	gnu/kawa/slib/srfi1:eighth	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: areturn
    //   323: aload_2
    //   324: invokestatic 1703	gnu/kawa/slib/srfi1:ninth	(Ljava/lang/Object;)Ljava/lang/Object;
    //   327: areturn
    //   328: aload_2
    //   329: invokestatic 1705	gnu/kawa/slib/srfi1:tenth	(Ljava/lang/Object;)Ljava/lang/Object;
    //   332: areturn
    //   333: aload_2
    //   334: invokestatic 1707	gnu/kawa/slib/srfi1:car$PlCdr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   337: areturn
    //   338: aload_2
    //   339: invokestatic 1709	gnu/kawa/slib/srfi1:last	(Ljava/lang/Object;)Ljava/lang/Object;
    //   342: areturn
    //   343: aload_2
    //   344: checkcast 1033	gnu/lists/Pair
    //   347: astore 4
    //   349: aload 4
    //   351: invokestatic 1141	gnu/kawa/slib/srfi1:lastPair	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   354: areturn
    //   355: aload_2
    //   356: invokestatic 1711	gnu/kawa/slib/srfi1:unzip1	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   359: areturn
    //   360: aload_2
    //   361: invokestatic 1713	gnu/kawa/slib/srfi1:unzip2	(Ljava/lang/Object;)Ljava/lang/Object;
    //   364: areturn
    //   365: aload_2
    //   366: invokestatic 1715	gnu/kawa/slib/srfi1:unzip3	(Ljava/lang/Object;)Ljava/lang/Object;
    //   369: areturn
    //   370: aload_2
    //   371: invokestatic 1717	gnu/kawa/slib/srfi1:unzip4	(Ljava/lang/Object;)Ljava/lang/Object;
    //   374: areturn
    //   375: aload_2
    //   376: invokestatic 1719	gnu/kawa/slib/srfi1:unzip5	(Ljava/lang/Object;)Ljava/lang/Object;
    //   379: areturn
    //   380: aload_2
    //   381: invokestatic 1721	gnu/kawa/slib/srfi1:concatenate	(Ljava/lang/Object;)Ljava/lang/Object;
    //   384: areturn
    //   385: aload_2
    //   386: invokestatic 1723	gnu/kawa/slib/srfi1:concatenate$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   389: areturn
    //   390: aload_2
    //   391: invokestatic 1725	gnu/kawa/slib/srfi1:deleteDuplicates	(Ljava/lang/Object;)Ljava/lang/Object;
    //   394: areturn
    //   395: aload_2
    //   396: invokestatic 1727	gnu/kawa/slib/srfi1:deleteDuplicates$Ex	(Ljava/lang/Object;)Ljava/lang/Object;
    //   399: areturn
    //   400: aload_2
    //   401: invokestatic 1729	gnu/kawa/slib/srfi1:alistCopy	(Ljava/lang/Object;)Lgnu/lists/LList;
    //   404: areturn
    //   405: astore 7
    //   407: new 1052	gnu/mapping/WrongType
    //   410: dup
    //   411: aload 7
    //   413: ldc_w 767
    //   416: iconst_1
    //   417: aload_2
    //   418: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   421: athrow
    //   422: astore 5
    //   424: new 1052	gnu/mapping/WrongType
    //   427: dup
    //   428: aload 5
    //   430: ldc_w 763
    //   433: iconst_1
    //   434: aload_2
    //   435: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   438: athrow
    //   439: astore_3
    //   440: new 1052	gnu/mapping/WrongType
    //   443: dup
    //   444: aload_3
    //   445: ldc_w 674
    //   448: iconst_1
    //   449: aload_2
    //   450: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   453: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   239	245	405	java/lang/ClassCastException
    //   251	257	422	java/lang/ClassCastException
    //   343	349	439	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+300->304, 78:+308->312, 80:+314->318, 83:+327->331, 102:+347->351, 103:+360->364, 104:+373->377, 105:+386->390, 106:+399->403, 107:+412->416, 108:+425->429, 109:+438->442, 118:+451->455, 119:+457->461, 137:+463->467, 138:+476->480, 139:+489->493, 140:+502->506, 141:+515->519, 142:+521->525, 143:+527->531, 145:+533->537, 147:+539->543, 149:+552->556, 153:+565->569, 155:+571->575, 157:+577->581, 158:+583->587, 159:+596->600, 160:+609->613, 161:+622->626, 162:+635->639, 163:+648->652, 164:+661->665, 165:+667->671, 182:+673->677, 183:+679->683
    //   305: aload_1
    //   306: aload_2
    //   307: aload_3
    //   308: invokespecial 1732	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   311: areturn
    //   312: aload_2
    //   313: aload_3
    //   314: invokestatic 1734	gnu/kawa/slib/srfi1:xcons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   317: areturn
    //   318: aload_3
    //   319: checkcast 1043	gnu/mapping/Procedure
    //   322: astore 49
    //   324: aload_2
    //   325: aload 49
    //   327: invokestatic 1736	gnu/kawa/slib/srfi1:listTabulate	(Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   330: areturn
    //   331: aload_2
    //   332: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   335: astore 45
    //   337: aload_3
    //   338: invokestatic 1740	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   341: astore 47
    //   343: aload 45
    //   345: aload 47
    //   347: invokestatic 1742	gnu/kawa/slib/srfi1:iota	(Lgnu/math/IntNum;Lgnu/math/Numeric;)Ljava/lang/Object;
    //   350: areturn
    //   351: aload_3
    //   352: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   355: astore 43
    //   357: aload_2
    //   358: aload 43
    //   360: invokestatic 1744	gnu/kawa/slib/srfi1:take	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   363: areturn
    //   364: aload_3
    //   365: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   368: astore 41
    //   370: aload_2
    //   371: aload 41
    //   373: invokestatic 1285	gnu/kawa/slib/srfi1:drop	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   376: areturn
    //   377: aload_3
    //   378: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   381: astore 39
    //   383: aload_2
    //   384: aload 39
    //   386: invokestatic 1746	gnu/kawa/slib/srfi1:take$Ex	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   389: areturn
    //   390: aload_3
    //   391: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   394: astore 37
    //   396: aload_2
    //   397: aload 37
    //   399: invokestatic 1748	gnu/kawa/slib/srfi1:takeRight	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   402: areturn
    //   403: aload_3
    //   404: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   407: astore 35
    //   409: aload_2
    //   410: aload 35
    //   412: invokestatic 1750	gnu/kawa/slib/srfi1:dropRight	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   415: areturn
    //   416: aload_3
    //   417: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   420: astore 33
    //   422: aload_2
    //   423: aload 33
    //   425: invokestatic 1752	gnu/kawa/slib/srfi1:dropRight$Ex	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   428: areturn
    //   429: aload_3
    //   430: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   433: astore 31
    //   435: aload_2
    //   436: aload 31
    //   438: invokestatic 1754	gnu/kawa/slib/srfi1:splitAt	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   441: areturn
    //   442: aload_3
    //   443: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   446: astore 29
    //   448: aload_2
    //   449: aload 29
    //   451: invokestatic 1756	gnu/kawa/slib/srfi1:splitAt$Ex	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   454: areturn
    //   455: aload_2
    //   456: aload_3
    //   457: invokestatic 1758	gnu/kawa/slib/srfi1:appendReverse	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   460: areturn
    //   461: aload_2
    //   462: aload_3
    //   463: invokestatic 1635	gnu/kawa/slib/srfi1:appendReverse$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   466: areturn
    //   467: aload_2
    //   468: checkcast 1043	gnu/mapping/Procedure
    //   471: astore 27
    //   473: aload 27
    //   475: aload_3
    //   476: invokestatic 1081	gnu/kawa/slib/srfi1:filter	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   479: areturn
    //   480: aload_2
    //   481: checkcast 1043	gnu/mapping/Procedure
    //   484: astore 25
    //   486: aload 25
    //   488: aload_3
    //   489: invokestatic 1094	gnu/kawa/slib/srfi1:filter$Ex	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   492: areturn
    //   493: aload_2
    //   494: checkcast 1043	gnu/mapping/Procedure
    //   497: astore 23
    //   499: aload 23
    //   501: aload_3
    //   502: invokestatic 1451	gnu/kawa/slib/srfi1:partition	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   505: areturn
    //   506: aload_2
    //   507: checkcast 1043	gnu/mapping/Procedure
    //   510: astore 21
    //   512: aload 21
    //   514: aload_3
    //   515: invokestatic 1440	gnu/kawa/slib/srfi1:partition$Ex	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   518: areturn
    //   519: aload_2
    //   520: aload_3
    //   521: invokestatic 1760	gnu/kawa/slib/srfi1:remove	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   524: areturn
    //   525: aload_2
    //   526: aload_3
    //   527: invokestatic 1762	gnu/kawa/slib/srfi1:remove$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   530: areturn
    //   531: aload_2
    //   532: aload_3
    //   533: invokestatic 1764	gnu/kawa/slib/srfi1:delete	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: areturn
    //   537: aload_2
    //   538: aload_3
    //   539: invokestatic 1766	gnu/kawa/slib/srfi1:delete$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   542: areturn
    //   543: aload_3
    //   544: checkcast 1043	gnu/mapping/Procedure
    //   547: astore 19
    //   549: aload_2
    //   550: aload 19
    //   552: invokestatic 1250	gnu/kawa/slib/srfi1:deleteDuplicates	(Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   555: areturn
    //   556: aload_3
    //   557: checkcast 1043	gnu/mapping/Procedure
    //   560: astore 17
    //   562: aload_2
    //   563: aload 17
    //   565: invokestatic 1261	gnu/kawa/slib/srfi1:deleteDuplicates$Ex	(Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
    //   568: areturn
    //   569: aload_2
    //   570: aload_3
    //   571: invokestatic 1768	gnu/kawa/slib/srfi1:alistDelete	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   574: areturn
    //   575: aload_2
    //   576: aload_3
    //   577: invokestatic 1770	gnu/kawa/slib/srfi1:alistDelete$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   580: areturn
    //   581: aload_2
    //   582: aload_3
    //   583: invokestatic 1772	gnu/kawa/slib/srfi1:find	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   586: areturn
    //   587: aload_2
    //   588: checkcast 1043	gnu/mapping/Procedure
    //   591: astore 15
    //   593: aload 15
    //   595: aload_3
    //   596: invokestatic 1327	gnu/kawa/slib/srfi1:findTail	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   599: areturn
    //   600: aload_2
    //   601: checkcast 1043	gnu/mapping/Procedure
    //   604: astore 13
    //   606: aload 13
    //   608: aload_3
    //   609: invokestatic 1774	gnu/kawa/slib/srfi1:takeWhile	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   612: areturn
    //   613: aload_2
    //   614: checkcast 1043	gnu/mapping/Procedure
    //   617: astore 11
    //   619: aload 11
    //   621: aload_3
    //   622: invokestatic 1776	gnu/kawa/slib/srfi1:dropWhile	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   625: areturn
    //   626: aload_2
    //   627: checkcast 1043	gnu/mapping/Procedure
    //   630: astore 9
    //   632: aload 9
    //   634: aload_3
    //   635: invokestatic 1778	gnu/kawa/slib/srfi1:takeWhile$Ex	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   638: areturn
    //   639: aload_2
    //   640: checkcast 1043	gnu/mapping/Procedure
    //   643: astore 7
    //   645: aload 7
    //   647: aload_3
    //   648: invokestatic 1186	gnu/kawa/slib/srfi1:span	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   651: areturn
    //   652: aload_2
    //   653: checkcast 1043	gnu/mapping/Procedure
    //   656: astore 5
    //   658: aload 5
    //   660: aload_3
    //   661: invokestatic 1195	gnu/kawa/slib/srfi1:span$Ex	(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   664: areturn
    //   665: aload_2
    //   666: aload_3
    //   667: invokestatic 1780	gnu/kawa/slib/srfi1:jdField_break	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   670: areturn
    //   671: aload_2
    //   672: aload_3
    //   673: invokestatic 1782	gnu/kawa/slib/srfi1:break$Ex	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   676: areturn
    //   677: aload_2
    //   678: aload_3
    //   679: invokestatic 1785	gnu/kawa/slib/srfi1$frame61:lambda84	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   682: areturn
    //   683: aload_2
    //   684: aload_3
    //   685: invokestatic 1788	gnu/kawa/slib/srfi1$frame71:lambda100	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   688: areturn
    //   689: astore 48
    //   691: new 1052	gnu/mapping/WrongType
    //   694: dup
    //   695: aload 48
    //   697: ldc_w 775
    //   700: iconst_2
    //   701: aload_3
    //   702: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   705: athrow
    //   706: astore 44
    //   708: new 1052	gnu/mapping/WrongType
    //   711: dup
    //   712: aload 44
    //   714: ldc_w 763
    //   717: iconst_1
    //   718: aload_2
    //   719: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   722: athrow
    //   723: astore 46
    //   725: new 1052	gnu/mapping/WrongType
    //   728: dup
    //   729: aload 46
    //   731: ldc_w 763
    //   734: iconst_2
    //   735: aload_3
    //   736: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   739: athrow
    //   740: astore 42
    //   742: new 1052	gnu/mapping/WrongType
    //   745: dup
    //   746: aload 42
    //   748: ldc_w 707
    //   751: iconst_2
    //   752: aload_3
    //   753: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   756: athrow
    //   757: astore 40
    //   759: new 1052	gnu/mapping/WrongType
    //   762: dup
    //   763: aload 40
    //   765: ldc_w 704
    //   768: iconst_2
    //   769: aload_3
    //   770: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   773: athrow
    //   774: astore 38
    //   776: new 1052	gnu/mapping/WrongType
    //   779: dup
    //   780: aload 38
    //   782: ldc_w 701
    //   785: iconst_2
    //   786: aload_3
    //   787: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   790: athrow
    //   791: astore 36
    //   793: new 1052	gnu/mapping/WrongType
    //   796: dup
    //   797: aload 36
    //   799: ldc_w 697
    //   802: iconst_2
    //   803: aload_3
    //   804: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   807: athrow
    //   808: astore 34
    //   810: new 1052	gnu/mapping/WrongType
    //   813: dup
    //   814: aload 34
    //   816: ldc_w 693
    //   819: iconst_2
    //   820: aload_3
    //   821: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   824: athrow
    //   825: astore 32
    //   827: new 1052	gnu/mapping/WrongType
    //   830: dup
    //   831: aload 32
    //   833: ldc_w 689
    //   836: iconst_2
    //   837: aload_3
    //   838: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   841: athrow
    //   842: astore 30
    //   844: new 1052	gnu/mapping/WrongType
    //   847: dup
    //   848: aload 30
    //   850: ldc_w 685
    //   853: iconst_2
    //   854: aload_3
    //   855: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   858: athrow
    //   859: astore 28
    //   861: new 1052	gnu/mapping/WrongType
    //   864: dup
    //   865: aload 28
    //   867: ldc_w 681
    //   870: iconst_2
    //   871: aload_3
    //   872: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   875: athrow
    //   876: astore 26
    //   878: new 1052	gnu/mapping/WrongType
    //   881: dup
    //   882: aload 26
    //   884: ldc_w 584
    //   887: iconst_1
    //   888: aload_2
    //   889: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   892: athrow
    //   893: astore 24
    //   895: new 1052	gnu/mapping/WrongType
    //   898: dup
    //   899: aload 24
    //   901: ldc_w 581
    //   904: iconst_1
    //   905: aload_2
    //   906: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   909: athrow
    //   910: astore 22
    //   912: new 1052	gnu/mapping/WrongType
    //   915: dup
    //   916: aload 22
    //   918: ldc_w 577
    //   921: iconst_1
    //   922: aload_2
    //   923: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   926: athrow
    //   927: astore 20
    //   929: new 1052	gnu/mapping/WrongType
    //   932: dup
    //   933: aload 20
    //   935: ldc_w 574
    //   938: iconst_1
    //   939: aload_2
    //   940: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   943: athrow
    //   944: astore 18
    //   946: new 1052	gnu/mapping/WrongType
    //   949: dup
    //   950: aload 18
    //   952: ldc_w 556
    //   955: iconst_2
    //   956: aload_3
    //   957: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   960: athrow
    //   961: astore 16
    //   963: new 1052	gnu/mapping/WrongType
    //   966: dup
    //   967: aload 16
    //   969: ldc_w 552
    //   972: iconst_2
    //   973: aload_3
    //   974: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   977: athrow
    //   978: astore 14
    //   980: new 1052	gnu/mapping/WrongType
    //   983: dup
    //   984: aload 14
    //   986: ldc_w 529
    //   989: iconst_1
    //   990: aload_2
    //   991: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   994: athrow
    //   995: astore 12
    //   997: new 1052	gnu/mapping/WrongType
    //   1000: dup
    //   1001: aload 12
    //   1003: ldc_w 525
    //   1006: iconst_1
    //   1007: aload_2
    //   1008: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1011: athrow
    //   1012: astore 10
    //   1014: new 1052	gnu/mapping/WrongType
    //   1017: dup
    //   1018: aload 10
    //   1020: ldc_w 521
    //   1023: iconst_1
    //   1024: aload_2
    //   1025: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1028: athrow
    //   1029: astore 8
    //   1031: new 1052	gnu/mapping/WrongType
    //   1034: dup
    //   1035: aload 8
    //   1037: ldc_w 517
    //   1040: iconst_1
    //   1041: aload_2
    //   1042: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1045: athrow
    //   1046: astore 6
    //   1048: new 1052	gnu/mapping/WrongType
    //   1051: dup
    //   1052: aload 6
    //   1054: ldc_w 513
    //   1057: iconst_1
    //   1058: aload_2
    //   1059: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1062: athrow
    //   1063: astore 4
    //   1065: new 1052	gnu/mapping/WrongType
    //   1068: dup
    //   1069: aload 4
    //   1071: ldc_w 510
    //   1074: iconst_1
    //   1075: aload_2
    //   1076: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   1079: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   318	324	689	java/lang/ClassCastException
    //   331	337	706	java/lang/ClassCastException
    //   337	343	723	java/lang/ClassCastException
    //   351	357	740	java/lang/ClassCastException
    //   364	370	757	java/lang/ClassCastException
    //   377	383	774	java/lang/ClassCastException
    //   390	396	791	java/lang/ClassCastException
    //   403	409	808	java/lang/ClassCastException
    //   416	422	825	java/lang/ClassCastException
    //   429	435	842	java/lang/ClassCastException
    //   442	448	859	java/lang/ClassCastException
    //   467	473	876	java/lang/ClassCastException
    //   480	486	893	java/lang/ClassCastException
    //   493	499	910	java/lang/ClassCastException
    //   506	512	927	java/lang/ClassCastException
    //   543	549	944	java/lang/ClassCastException
    //   556	562	961	java/lang/ClassCastException
    //   587	593	978	java/lang/ClassCastException
    //   600	606	995	java/lang/ClassCastException
    //   613	619	1012	java/lang/ClassCastException
    //   626	632	1029	java/lang/ClassCastException
    //   639	645	1046	java/lang/ClassCastException
    //   652	658	1063	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+76->80, 83:+86->90, 130:+115->119, 131:+130->134, 143:+145->149, 145:+153->157, 151:+161->165, 153:+169->173, 155:+177->181
    //   81: aload_1
    //   82: aload_2
    //   83: aload_3
    //   84: aload 4
    //   86: invokespecial 1791	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: areturn
    //   90: aload_2
    //   91: invokestatic 1683	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   94: astore 10
    //   96: aload_3
    //   97: invokestatic 1740	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   100: astore 12
    //   102: aload 4
    //   104: invokestatic 1740	gnu/kawa/lispexpr/LangObjType:coerceNumeric	(Ljava/lang/Object;)Lgnu/math/Numeric;
    //   107: astore 14
    //   109: aload 10
    //   111: aload 12
    //   113: aload 14
    //   115: invokestatic 1356	gnu/kawa/slib/srfi1:iota	(Lgnu/math/IntNum;Lgnu/math/Numeric;Lgnu/math/Numeric;)Ljava/lang/Object;
    //   118: areturn
    //   119: aload_2
    //   120: checkcast 1043	gnu/mapping/Procedure
    //   123: astore 8
    //   125: aload 8
    //   127: aload_3
    //   128: aload 4
    //   130: invokestatic 1506	gnu/kawa/slib/srfi1:reduce	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: areturn
    //   134: aload_2
    //   135: checkcast 1043	gnu/mapping/Procedure
    //   138: astore 6
    //   140: aload 6
    //   142: aload_3
    //   143: aload 4
    //   145: invokestatic 1207	gnu/kawa/slib/srfi1:reduceRight	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: areturn
    //   149: aload_2
    //   150: aload_3
    //   151: aload 4
    //   153: invokestatic 1227	gnu/kawa/slib/srfi1:delete	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: areturn
    //   157: aload_2
    //   158: aload_3
    //   159: aload 4
    //   161: invokestatic 1238	gnu/kawa/slib/srfi1:delete$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   164: areturn
    //   165: aload_2
    //   166: aload_3
    //   167: aload 4
    //   169: invokestatic 1793	gnu/kawa/slib/srfi1:alistCons	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   172: areturn
    //   173: aload_2
    //   174: aload_3
    //   175: aload 4
    //   177: invokestatic 1066	gnu/kawa/slib/srfi1:alistDelete	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: areturn
    //   181: aload_2
    //   182: aload_3
    //   183: aload 4
    //   185: invokestatic 1084	gnu/kawa/slib/srfi1:alistDelete$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: areturn
    //   189: astore 9
    //   191: new 1052	gnu/mapping/WrongType
    //   194: dup
    //   195: aload 9
    //   197: ldc_w 763
    //   200: iconst_1
    //   201: aload_2
    //   202: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   205: athrow
    //   206: astore 11
    //   208: new 1052	gnu/mapping/WrongType
    //   211: dup
    //   212: aload 11
    //   214: ldc_w 763
    //   217: iconst_2
    //   218: aload_3
    //   219: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   222: athrow
    //   223: astore 13
    //   225: new 1052	gnu/mapping/WrongType
    //   228: dup
    //   229: aload 13
    //   231: ldc_w 763
    //   234: iconst_3
    //   235: aload 4
    //   237: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   240: athrow
    //   241: astore 7
    //   243: new 1052	gnu/mapping/WrongType
    //   246: dup
    //   247: aload 7
    //   249: ldc_w 611
    //   252: iconst_1
    //   253: aload_2
    //   254: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   257: athrow
    //   258: astore 5
    //   260: new 1052	gnu/mapping/WrongType
    //   263: dup
    //   264: aload 5
    //   266: ldc_w 608
    //   269: iconst_1
    //   270: aload_2
    //   271: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   274: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   90	96	189	java/lang/ClassCastException
    //   96	102	206	java/lang/ClassCastException
    //   102	109	223	java/lang/ClassCastException
    //   119	125	241	java/lang/ClassCastException
    //   134	140	258	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 123
    //   6: if_icmpne +34 -> 40
    //   9: aload_2
    //   10: checkcast 1043	gnu/mapping/Procedure
    //   13: astore 7
    //   15: aload_3
    //   16: checkcast 1043	gnu/mapping/Procedure
    //   19: astore 9
    //   21: aload 4
    //   23: checkcast 1043	gnu/mapping/Procedure
    //   26: astore 11
    //   28: aload 7
    //   30: aload 9
    //   32: aload 11
    //   34: aload 5
    //   36: invokestatic 1796	gnu/kawa/slib/srfi1:unfoldRight	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: areturn
    //   40: aload_0
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: aload 4
    //   46: aload 5
    //   48: invokespecial 1798	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: areturn
    //   52: astore 6
    //   54: new 1052	gnu/mapping/WrongType
    //   57: dup
    //   58: aload 6
    //   60: ldc_w 633
    //   63: iconst_1
    //   64: aload_2
    //   65: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   68: athrow
    //   69: astore 8
    //   71: new 1052	gnu/mapping/WrongType
    //   74: dup
    //   75: aload 8
    //   77: ldc_w 633
    //   80: iconst_2
    //   81: aload_3
    //   82: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   85: athrow
    //   86: astore 10
    //   88: new 1052	gnu/mapping/WrongType
    //   91: dup
    //   92: aload 10
    //   94: ldc_w 633
    //   97: iconst_3
    //   98: aload 4
    //   100: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   103: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	52	java/lang/ClassCastException
    //   15	21	69	java/lang/ClassCastException
    //   21	28	86	java/lang/ClassCastException
  }

  // ERROR //
  public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1675	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+284->288, 79:+291->295, 81:+343->347, 86:+348->352, 92:+400->404, 94:+452->456, 117:+504->508, 122:+509->513, 123:+575->579, 125:+659->663, 126:+753->757, 127:+826->830, 128:+899->903, 129:+972->976, 132:+1045->1049, 133:+1104->1108, 134:+1163->1167, 135:+1229->1233, 136:+1295->1299, 166:+1361->1365, 167:+1427->1431, 168:+1493->1497, 169:+1559->1563, 170:+1618->1622, 171:+1677->1681, 172:+1743->1747, 173:+1802->1806, 174:+1861->1865, 175:+1927->1931, 176:+1993->1997, 177:+2059->2063, 178:+2125->2129, 179:+2184->2188, 180:+2243->2247, 181:+2309->2313
    //   289: aload_1
    //   290: aload_2
    //   291: invokespecial 1801	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   294: areturn
    //   295: aload_2
    //   296: iconst_0
    //   297: aaload
    //   298: astore 216
    //   300: aload_2
    //   301: arraylength
    //   302: iconst_1
    //   303: isub
    //   304: istore 217
    //   306: iload 217
    //   308: anewarray 348	java/lang/Object
    //   311: astore 218
    //   313: iload 217
    //   315: istore 219
    //   317: iinc 219 255
    //   320: iload 219
    //   322: ifge +11 -> 333
    //   325: aload 216
    //   327: aload 218
    //   329: invokestatic 1803	gnu/kawa/slib/srfi1:makeList$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   332: areturn
    //   333: aload 218
    //   335: iload 219
    //   337: aload_2
    //   338: iload 219
    //   340: iconst_1
    //   341: iadd
    //   342: aaload
    //   343: aastore
    //   344: goto -27 -> 317
    //   347: aload_2
    //   348: invokestatic 1805	gnu/kawa/slib/srfi1:cons$St	([Ljava/lang/Object;)Ljava/lang/Object;
    //   351: areturn
    //   352: aload_2
    //   353: iconst_0
    //   354: aaload
    //   355: astore 212
    //   357: aload_2
    //   358: arraylength
    //   359: iconst_1
    //   360: isub
    //   361: istore 213
    //   363: iload 213
    //   365: anewarray 348	java/lang/Object
    //   368: astore 214
    //   370: iload 213
    //   372: istore 215
    //   374: iinc 215 255
    //   377: iload 215
    //   379: ifge +11 -> 390
    //   382: aload 212
    //   384: aload 214
    //   386: invokestatic 1807	gnu/kawa/slib/srfi1:circularList$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/Pair;
    //   389: areturn
    //   390: aload 214
    //   392: iload 215
    //   394: aload_2
    //   395: iload 215
    //   397: iconst_1
    //   398: iadd
    //   399: aaload
    //   400: aastore
    //   401: goto -27 -> 374
    //   404: aload_2
    //   405: iconst_0
    //   406: aaload
    //   407: astore 208
    //   409: aload_2
    //   410: arraylength
    //   411: iconst_1
    //   412: isub
    //   413: istore 209
    //   415: iload 209
    //   417: anewarray 348	java/lang/Object
    //   420: astore 210
    //   422: iload 209
    //   424: istore 211
    //   426: iinc 211 255
    //   429: iload 211
    //   431: ifge +11 -> 442
    //   434: aload 208
    //   436: aload 210
    //   438: invokestatic 1809	gnu/kawa/slib/srfi1:list$Eq$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   441: areturn
    //   442: aload 210
    //   444: iload 211
    //   446: aload_2
    //   447: iload 211
    //   449: iconst_1
    //   450: iadd
    //   451: aaload
    //   452: aastore
    //   453: goto -27 -> 426
    //   456: aload_2
    //   457: iconst_0
    //   458: aaload
    //   459: astore 204
    //   461: aload_2
    //   462: arraylength
    //   463: iconst_1
    //   464: isub
    //   465: istore 205
    //   467: iload 205
    //   469: anewarray 348	java/lang/Object
    //   472: astore 206
    //   474: iload 205
    //   476: istore 207
    //   478: iinc 207 255
    //   481: iload 207
    //   483: ifge +11 -> 494
    //   486: aload 204
    //   488: aload 206
    //   490: invokestatic 1811	gnu/kawa/slib/srfi1:zip$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   493: areturn
    //   494: aload 206
    //   496: iload 207
    //   498: aload_2
    //   499: iload 207
    //   501: iconst_1
    //   502: iadd
    //   503: aaload
    //   504: aastore
    //   505: goto -27 -> 478
    //   508: aload_2
    //   509: invokestatic 1562	gnu/kawa/slib/srfi1:append$Ex$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   512: areturn
    //   513: aload_2
    //   514: iconst_0
    //   515: aaload
    //   516: astore 197
    //   518: aload 197
    //   520: checkcast 1043	gnu/mapping/Procedure
    //   523: astore 199
    //   525: aload_2
    //   526: iconst_1
    //   527: aaload
    //   528: astore 200
    //   530: aload_2
    //   531: arraylength
    //   532: iconst_2
    //   533: isub
    //   534: istore 201
    //   536: iload 201
    //   538: anewarray 348	java/lang/Object
    //   541: astore 202
    //   543: iload 201
    //   545: istore 203
    //   547: iinc 203 255
    //   550: iload 203
    //   552: ifge +13 -> 565
    //   555: aload 199
    //   557: aload 200
    //   559: aload 202
    //   561: invokestatic 1813	gnu/kawa/slib/srfi1:count$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   564: areturn
    //   565: aload 202
    //   567: iload 203
    //   569: aload_2
    //   570: iload 203
    //   572: iconst_2
    //   573: iadd
    //   574: aaload
    //   575: aastore
    //   576: goto -29 -> 547
    //   579: aload_2
    //   580: arraylength
    //   581: iconst_4
    //   582: isub
    //   583: istore 185
    //   585: aload_2
    //   586: iconst_0
    //   587: aaload
    //   588: astore 186
    //   590: aload 186
    //   592: checkcast 1043	gnu/mapping/Procedure
    //   595: astore 188
    //   597: aload_2
    //   598: iconst_1
    //   599: aaload
    //   600: astore 189
    //   602: aload 189
    //   604: checkcast 1043	gnu/mapping/Procedure
    //   607: astore 191
    //   609: aload_2
    //   610: iconst_2
    //   611: aaload
    //   612: astore 192
    //   614: aload 192
    //   616: checkcast 1043	gnu/mapping/Procedure
    //   619: astore 194
    //   621: aload_2
    //   622: iconst_3
    //   623: aaload
    //   624: astore 195
    //   626: iload 185
    //   628: ifgt +15 -> 643
    //   631: aload 188
    //   633: aload 191
    //   635: aload 194
    //   637: aload 195
    //   639: invokestatic 1796	gnu/kawa/slib/srfi1:unfoldRight	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   642: areturn
    //   643: iload 185
    //   645: iconst_1
    //   646: isub
    //   647: pop
    //   648: aload 188
    //   650: aload 191
    //   652: aload 194
    //   654: aload 195
    //   656: aload_2
    //   657: iconst_4
    //   658: aaload
    //   659: invokestatic 1640	gnu/kawa/slib/srfi1:unfoldRight	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   662: areturn
    //   663: aload_2
    //   664: iconst_0
    //   665: aaload
    //   666: astore 172
    //   668: aload 172
    //   670: checkcast 1043	gnu/mapping/Procedure
    //   673: astore 174
    //   675: aload_2
    //   676: iconst_1
    //   677: aaload
    //   678: astore 175
    //   680: aload 175
    //   682: checkcast 1043	gnu/mapping/Procedure
    //   685: astore 177
    //   687: aload_2
    //   688: iconst_2
    //   689: aaload
    //   690: astore 178
    //   692: aload 178
    //   694: checkcast 1043	gnu/mapping/Procedure
    //   697: astore 180
    //   699: aload_2
    //   700: iconst_3
    //   701: aaload
    //   702: astore 181
    //   704: aload_2
    //   705: arraylength
    //   706: iconst_4
    //   707: isub
    //   708: istore 182
    //   710: iload 182
    //   712: anewarray 348	java/lang/Object
    //   715: astore 183
    //   717: iload 182
    //   719: istore 184
    //   721: iinc 184 255
    //   724: iload 184
    //   726: ifge +17 -> 743
    //   729: aload 174
    //   731: aload 177
    //   733: aload 180
    //   735: aload 181
    //   737: aload 183
    //   739: invokestatic 1815	gnu/kawa/slib/srfi1:unfold$V	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   742: areturn
    //   743: aload 183
    //   745: iload 184
    //   747: aload_2
    //   748: iload 184
    //   750: iconst_4
    //   751: iadd
    //   752: aaload
    //   753: aastore
    //   754: goto -33 -> 721
    //   757: aload_2
    //   758: iconst_0
    //   759: aaload
    //   760: astore 164
    //   762: aload 164
    //   764: checkcast 1043	gnu/mapping/Procedure
    //   767: astore 166
    //   769: aload_2
    //   770: iconst_1
    //   771: aaload
    //   772: astore 167
    //   774: aload_2
    //   775: iconst_2
    //   776: aaload
    //   777: astore 168
    //   779: aload_2
    //   780: arraylength
    //   781: iconst_3
    //   782: isub
    //   783: istore 169
    //   785: iload 169
    //   787: anewarray 348	java/lang/Object
    //   790: astore 170
    //   792: iload 169
    //   794: istore 171
    //   796: iinc 171 255
    //   799: iload 171
    //   801: ifge +15 -> 816
    //   804: aload 166
    //   806: aload 167
    //   808: aload 168
    //   810: aload 170
    //   812: invokestatic 1426	gnu/kawa/slib/srfi1:fold$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   815: areturn
    //   816: aload 170
    //   818: iload 171
    //   820: aload_2
    //   821: iload 171
    //   823: iconst_3
    //   824: iadd
    //   825: aaload
    //   826: aastore
    //   827: goto -31 -> 796
    //   830: aload_2
    //   831: iconst_0
    //   832: aaload
    //   833: astore 156
    //   835: aload 156
    //   837: checkcast 1043	gnu/mapping/Procedure
    //   840: astore 158
    //   842: aload_2
    //   843: iconst_1
    //   844: aaload
    //   845: astore 159
    //   847: aload_2
    //   848: iconst_2
    //   849: aaload
    //   850: astore 160
    //   852: aload_2
    //   853: arraylength
    //   854: iconst_3
    //   855: isub
    //   856: istore 161
    //   858: iload 161
    //   860: anewarray 348	java/lang/Object
    //   863: astore 162
    //   865: iload 161
    //   867: istore 163
    //   869: iinc 163 255
    //   872: iload 163
    //   874: ifge +15 -> 889
    //   877: aload 158
    //   879: aload 159
    //   881: aload 160
    //   883: aload 162
    //   885: invokestatic 1817	gnu/kawa/slib/srfi1:foldRight$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   888: areturn
    //   889: aload 162
    //   891: iload 163
    //   893: aload_2
    //   894: iload 163
    //   896: iconst_3
    //   897: iadd
    //   898: aaload
    //   899: aastore
    //   900: goto -31 -> 869
    //   903: aload_2
    //   904: iconst_0
    //   905: aaload
    //   906: astore 148
    //   908: aload 148
    //   910: checkcast 1043	gnu/mapping/Procedure
    //   913: astore 150
    //   915: aload_2
    //   916: iconst_1
    //   917: aaload
    //   918: astore 151
    //   920: aload_2
    //   921: iconst_2
    //   922: aaload
    //   923: astore 152
    //   925: aload_2
    //   926: arraylength
    //   927: iconst_3
    //   928: isub
    //   929: istore 153
    //   931: iload 153
    //   933: anewarray 348	java/lang/Object
    //   936: astore 154
    //   938: iload 153
    //   940: istore 155
    //   942: iinc 155 255
    //   945: iload 155
    //   947: ifge +15 -> 962
    //   950: aload 150
    //   952: aload 151
    //   954: aload 152
    //   956: aload 154
    //   958: invokestatic 1819	gnu/kawa/slib/srfi1:pairFoldRight$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   961: areturn
    //   962: aload 154
    //   964: iload 155
    //   966: aload_2
    //   967: iload 155
    //   969: iconst_3
    //   970: iadd
    //   971: aaload
    //   972: aastore
    //   973: goto -31 -> 942
    //   976: aload_2
    //   977: iconst_0
    //   978: aaload
    //   979: astore 140
    //   981: aload 140
    //   983: checkcast 1043	gnu/mapping/Procedure
    //   986: astore 142
    //   988: aload_2
    //   989: iconst_1
    //   990: aaload
    //   991: astore 143
    //   993: aload_2
    //   994: iconst_2
    //   995: aaload
    //   996: astore 144
    //   998: aload_2
    //   999: arraylength
    //   1000: iconst_3
    //   1001: isub
    //   1002: istore 145
    //   1004: iload 145
    //   1006: anewarray 348	java/lang/Object
    //   1009: astore 146
    //   1011: iload 145
    //   1013: istore 147
    //   1015: iinc 147 255
    //   1018: iload 147
    //   1020: ifge +15 -> 1035
    //   1023: aload 142
    //   1025: aload 143
    //   1027: aload 144
    //   1029: aload 146
    //   1031: invokestatic 1821	gnu/kawa/slib/srfi1:pairFold$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1034: areturn
    //   1035: aload 146
    //   1037: iload 147
    //   1039: aload_2
    //   1040: iload 147
    //   1042: iconst_3
    //   1043: iadd
    //   1044: aaload
    //   1045: aastore
    //   1046: goto -31 -> 1015
    //   1049: aload_2
    //   1050: iconst_0
    //   1051: aaload
    //   1052: astore 135
    //   1054: aload_2
    //   1055: iconst_1
    //   1056: aaload
    //   1057: astore 136
    //   1059: aload_2
    //   1060: arraylength
    //   1061: iconst_2
    //   1062: isub
    //   1063: istore 137
    //   1065: iload 137
    //   1067: anewarray 348	java/lang/Object
    //   1070: astore 138
    //   1072: iload 137
    //   1074: istore 139
    //   1076: iinc 139 255
    //   1079: iload 139
    //   1081: ifge +13 -> 1094
    //   1084: aload 135
    //   1086: aload 136
    //   1088: aload 138
    //   1090: invokestatic 1823	gnu/kawa/slib/srfi1:appendMap$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1093: areturn
    //   1094: aload 138
    //   1096: iload 139
    //   1098: aload_2
    //   1099: iload 139
    //   1101: iconst_2
    //   1102: iadd
    //   1103: aaload
    //   1104: aastore
    //   1105: goto -29 -> 1076
    //   1108: aload_2
    //   1109: iconst_0
    //   1110: aaload
    //   1111: astore 130
    //   1113: aload_2
    //   1114: iconst_1
    //   1115: aaload
    //   1116: astore 131
    //   1118: aload_2
    //   1119: arraylength
    //   1120: iconst_2
    //   1121: isub
    //   1122: istore 132
    //   1124: iload 132
    //   1126: anewarray 348	java/lang/Object
    //   1129: astore 133
    //   1131: iload 132
    //   1133: istore 134
    //   1135: iinc 134 255
    //   1138: iload 134
    //   1140: ifge +13 -> 1153
    //   1143: aload 130
    //   1145: aload 131
    //   1147: aload 133
    //   1149: invokestatic 1825	gnu/kawa/slib/srfi1:appendMap$Ex$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1152: areturn
    //   1153: aload 133
    //   1155: iload 134
    //   1157: aload_2
    //   1158: iload 134
    //   1160: iconst_2
    //   1161: iadd
    //   1162: aaload
    //   1163: aastore
    //   1164: goto -29 -> 1135
    //   1167: aload_2
    //   1168: iconst_0
    //   1169: aaload
    //   1170: astore 123
    //   1172: aload 123
    //   1174: checkcast 1043	gnu/mapping/Procedure
    //   1177: astore 125
    //   1179: aload_2
    //   1180: iconst_1
    //   1181: aaload
    //   1182: astore 126
    //   1184: aload_2
    //   1185: arraylength
    //   1186: iconst_2
    //   1187: isub
    //   1188: istore 127
    //   1190: iload 127
    //   1192: anewarray 348	java/lang/Object
    //   1195: astore 128
    //   1197: iload 127
    //   1199: istore 129
    //   1201: iinc 129 255
    //   1204: iload 129
    //   1206: ifge +13 -> 1219
    //   1209: aload 125
    //   1211: aload 126
    //   1213: aload 128
    //   1215: invokestatic 1551	gnu/kawa/slib/srfi1:pairForEach$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1218: areturn
    //   1219: aload 128
    //   1221: iload 129
    //   1223: aload_2
    //   1224: iload 129
    //   1226: iconst_2
    //   1227: iadd
    //   1228: aaload
    //   1229: aastore
    //   1230: goto -29 -> 1201
    //   1233: aload_2
    //   1234: iconst_0
    //   1235: aaload
    //   1236: astore 116
    //   1238: aload 116
    //   1240: checkcast 1043	gnu/mapping/Procedure
    //   1243: astore 118
    //   1245: aload_2
    //   1246: iconst_1
    //   1247: aaload
    //   1248: astore 119
    //   1250: aload_2
    //   1251: arraylength
    //   1252: iconst_2
    //   1253: isub
    //   1254: istore 120
    //   1256: iload 120
    //   1258: anewarray 348	java/lang/Object
    //   1261: astore 121
    //   1263: iload 120
    //   1265: istore 122
    //   1267: iinc 122 255
    //   1270: iload 122
    //   1272: ifge +13 -> 1285
    //   1275: aload 118
    //   1277: aload 119
    //   1279: aload 121
    //   1281: invokestatic 1827	gnu/kawa/slib/srfi1:map$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1284: areturn
    //   1285: aload 121
    //   1287: iload 122
    //   1289: aload_2
    //   1290: iload 122
    //   1292: iconst_2
    //   1293: iadd
    //   1294: aaload
    //   1295: aastore
    //   1296: goto -29 -> 1267
    //   1299: aload_2
    //   1300: iconst_0
    //   1301: aaload
    //   1302: astore 109
    //   1304: aload 109
    //   1306: checkcast 1043	gnu/mapping/Procedure
    //   1309: astore 111
    //   1311: aload_2
    //   1312: iconst_1
    //   1313: aaload
    //   1314: astore 112
    //   1316: aload_2
    //   1317: arraylength
    //   1318: iconst_2
    //   1319: isub
    //   1320: istore 113
    //   1322: iload 113
    //   1324: anewarray 348	java/lang/Object
    //   1327: astore 114
    //   1329: iload 113
    //   1331: istore 115
    //   1333: iinc 115 255
    //   1336: iload 115
    //   1338: ifge +13 -> 1351
    //   1341: aload 111
    //   1343: aload 112
    //   1345: aload 114
    //   1347: invokestatic 1829	gnu/kawa/slib/srfi1:filterMap$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1350: areturn
    //   1351: aload 114
    //   1353: iload 115
    //   1355: aload_2
    //   1356: iload 115
    //   1358: iconst_2
    //   1359: iadd
    //   1360: aaload
    //   1361: aastore
    //   1362: goto -29 -> 1333
    //   1365: aload_2
    //   1366: iconst_0
    //   1367: aaload
    //   1368: astore 102
    //   1370: aload 102
    //   1372: checkcast 1043	gnu/mapping/Procedure
    //   1375: astore 104
    //   1377: aload_2
    //   1378: iconst_1
    //   1379: aaload
    //   1380: astore 105
    //   1382: aload_2
    //   1383: arraylength
    //   1384: iconst_2
    //   1385: isub
    //   1386: istore 106
    //   1388: iload 106
    //   1390: anewarray 348	java/lang/Object
    //   1393: astore 107
    //   1395: iload 106
    //   1397: istore 108
    //   1399: iinc 108 255
    //   1402: iload 108
    //   1404: ifge +13 -> 1417
    //   1407: aload 104
    //   1409: aload 105
    //   1411: aload 107
    //   1413: invokestatic 1484	gnu/kawa/slib/srfi1:any$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1416: areturn
    //   1417: aload 107
    //   1419: iload 108
    //   1421: aload_2
    //   1422: iload 108
    //   1424: iconst_2
    //   1425: iadd
    //   1426: aaload
    //   1427: aastore
    //   1428: goto -29 -> 1399
    //   1431: aload_2
    //   1432: iconst_0
    //   1433: aaload
    //   1434: astore 95
    //   1436: aload 95
    //   1438: checkcast 1043	gnu/mapping/Procedure
    //   1441: astore 97
    //   1443: aload_2
    //   1444: iconst_1
    //   1445: aaload
    //   1446: astore 98
    //   1448: aload_2
    //   1449: arraylength
    //   1450: iconst_2
    //   1451: isub
    //   1452: istore 99
    //   1454: iload 99
    //   1456: anewarray 348	java/lang/Object
    //   1459: astore 100
    //   1461: iload 99
    //   1463: istore 101
    //   1465: iinc 101 255
    //   1468: iload 101
    //   1470: ifge +13 -> 1483
    //   1473: aload 97
    //   1475: aload 98
    //   1477: aload 100
    //   1479: invokestatic 352	gnu/kawa/slib/srfi1:every$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1482: areturn
    //   1483: aload 100
    //   1485: iload 101
    //   1487: aload_2
    //   1488: iload 101
    //   1490: iconst_2
    //   1491: iadd
    //   1492: aaload
    //   1493: aastore
    //   1494: goto -29 -> 1465
    //   1497: aload_2
    //   1498: iconst_0
    //   1499: aaload
    //   1500: astore 88
    //   1502: aload 88
    //   1504: checkcast 1043	gnu/mapping/Procedure
    //   1507: astore 90
    //   1509: aload_2
    //   1510: iconst_1
    //   1511: aaload
    //   1512: astore 91
    //   1514: aload_2
    //   1515: arraylength
    //   1516: iconst_2
    //   1517: isub
    //   1518: istore 92
    //   1520: iload 92
    //   1522: anewarray 348	java/lang/Object
    //   1525: astore 93
    //   1527: iload 92
    //   1529: istore 94
    //   1531: iinc 94 255
    //   1534: iload 94
    //   1536: ifge +13 -> 1549
    //   1539: aload 90
    //   1541: aload 91
    //   1543: aload 93
    //   1545: invokestatic 1831	gnu/kawa/slib/srfi1:listIndex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1548: areturn
    //   1549: aload 93
    //   1551: iload 94
    //   1553: aload_2
    //   1554: iload 94
    //   1556: iconst_2
    //   1557: iadd
    //   1558: aaload
    //   1559: aastore
    //   1560: goto -29 -> 1531
    //   1563: aload_2
    //   1564: iconst_0
    //   1565: aaload
    //   1566: astore 82
    //   1568: aload 82
    //   1570: checkcast 1043	gnu/mapping/Procedure
    //   1573: astore 84
    //   1575: aload_2
    //   1576: arraylength
    //   1577: iconst_1
    //   1578: isub
    //   1579: istore 85
    //   1581: iload 85
    //   1583: anewarray 348	java/lang/Object
    //   1586: astore 86
    //   1588: iload 85
    //   1590: istore 87
    //   1592: iinc 87 255
    //   1595: iload 87
    //   1597: ifge +11 -> 1608
    //   1600: aload 84
    //   1602: aload 86
    //   1604: invokestatic 1833	gnu/kawa/slib/srfi1:lset$Ls$Eq$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1607: areturn
    //   1608: aload 86
    //   1610: iload 87
    //   1612: aload_2
    //   1613: iload 87
    //   1615: iconst_1
    //   1616: iadd
    //   1617: aaload
    //   1618: aastore
    //   1619: goto -27 -> 1592
    //   1622: aload_2
    //   1623: iconst_0
    //   1624: aaload
    //   1625: astore 76
    //   1627: aload 76
    //   1629: checkcast 1043	gnu/mapping/Procedure
    //   1632: astore 78
    //   1634: aload_2
    //   1635: arraylength
    //   1636: iconst_1
    //   1637: isub
    //   1638: istore 79
    //   1640: iload 79
    //   1642: anewarray 348	java/lang/Object
    //   1645: astore 80
    //   1647: iload 79
    //   1649: istore 81
    //   1651: iinc 81 255
    //   1654: iload 81
    //   1656: ifge +11 -> 1667
    //   1659: aload 78
    //   1661: aload 80
    //   1663: invokestatic 1835	gnu/kawa/slib/srfi1:lset$Eq$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1666: areturn
    //   1667: aload 80
    //   1669: iload 81
    //   1671: aload_2
    //   1672: iload 81
    //   1674: iconst_1
    //   1675: iadd
    //   1676: aaload
    //   1677: aastore
    //   1678: goto -27 -> 1651
    //   1681: aload_2
    //   1682: iconst_0
    //   1683: aaload
    //   1684: astore 69
    //   1686: aload 69
    //   1688: checkcast 1043	gnu/mapping/Procedure
    //   1691: astore 71
    //   1693: aload_2
    //   1694: iconst_1
    //   1695: aaload
    //   1696: astore 72
    //   1698: aload_2
    //   1699: arraylength
    //   1700: iconst_2
    //   1701: isub
    //   1702: istore 73
    //   1704: iload 73
    //   1706: anewarray 348	java/lang/Object
    //   1709: astore 74
    //   1711: iload 73
    //   1713: istore 75
    //   1715: iinc 75 255
    //   1718: iload 75
    //   1720: ifge +13 -> 1733
    //   1723: aload 71
    //   1725: aload 72
    //   1727: aload 74
    //   1729: invokestatic 1837	gnu/kawa/slib/srfi1:lsetAdjoin$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1732: areturn
    //   1733: aload 74
    //   1735: iload 75
    //   1737: aload_2
    //   1738: iload 75
    //   1740: iconst_2
    //   1741: iadd
    //   1742: aaload
    //   1743: aastore
    //   1744: goto -29 -> 1715
    //   1747: aload_2
    //   1748: iconst_0
    //   1749: aaload
    //   1750: astore 63
    //   1752: aload 63
    //   1754: checkcast 1043	gnu/mapping/Procedure
    //   1757: astore 65
    //   1759: aload_2
    //   1760: arraylength
    //   1761: iconst_1
    //   1762: isub
    //   1763: istore 66
    //   1765: iload 66
    //   1767: anewarray 348	java/lang/Object
    //   1770: astore 67
    //   1772: iload 66
    //   1774: istore 68
    //   1776: iinc 68 255
    //   1779: iload 68
    //   1781: ifge +11 -> 1792
    //   1784: aload 65
    //   1786: aload 67
    //   1788: invokestatic 1839	gnu/kawa/slib/srfi1:lsetUnion$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1791: areturn
    //   1792: aload 67
    //   1794: iload 68
    //   1796: aload_2
    //   1797: iload 68
    //   1799: iconst_1
    //   1800: iadd
    //   1801: aaload
    //   1802: aastore
    //   1803: goto -27 -> 1776
    //   1806: aload_2
    //   1807: iconst_0
    //   1808: aaload
    //   1809: astore 57
    //   1811: aload 57
    //   1813: checkcast 1043	gnu/mapping/Procedure
    //   1816: astore 59
    //   1818: aload_2
    //   1819: arraylength
    //   1820: iconst_1
    //   1821: isub
    //   1822: istore 60
    //   1824: iload 60
    //   1826: anewarray 348	java/lang/Object
    //   1829: astore 61
    //   1831: iload 60
    //   1833: istore 62
    //   1835: iinc 62 255
    //   1838: iload 62
    //   1840: ifge +11 -> 1851
    //   1843: aload 59
    //   1845: aload 61
    //   1847: invokestatic 1841	gnu/kawa/slib/srfi1:lsetUnion$Ex$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1850: areturn
    //   1851: aload 61
    //   1853: iload 62
    //   1855: aload_2
    //   1856: iload 62
    //   1858: iconst_1
    //   1859: iadd
    //   1860: aaload
    //   1861: aastore
    //   1862: goto -27 -> 1835
    //   1865: aload_2
    //   1866: iconst_0
    //   1867: aaload
    //   1868: astore 50
    //   1870: aload 50
    //   1872: checkcast 1043	gnu/mapping/Procedure
    //   1875: astore 52
    //   1877: aload_2
    //   1878: iconst_1
    //   1879: aaload
    //   1880: astore 53
    //   1882: aload_2
    //   1883: arraylength
    //   1884: iconst_2
    //   1885: isub
    //   1886: istore 54
    //   1888: iload 54
    //   1890: anewarray 348	java/lang/Object
    //   1893: astore 55
    //   1895: iload 54
    //   1897: istore 56
    //   1899: iinc 56 255
    //   1902: iload 56
    //   1904: ifge +13 -> 1917
    //   1907: aload 52
    //   1909: aload 53
    //   1911: aload 55
    //   1913: invokestatic 1843	gnu/kawa/slib/srfi1:lsetIntersection$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1916: areturn
    //   1917: aload 55
    //   1919: iload 56
    //   1921: aload_2
    //   1922: iload 56
    //   1924: iconst_2
    //   1925: iadd
    //   1926: aaload
    //   1927: aastore
    //   1928: goto -29 -> 1899
    //   1931: aload_2
    //   1932: iconst_0
    //   1933: aaload
    //   1934: astore 43
    //   1936: aload 43
    //   1938: checkcast 1043	gnu/mapping/Procedure
    //   1941: astore 45
    //   1943: aload_2
    //   1944: iconst_1
    //   1945: aaload
    //   1946: astore 46
    //   1948: aload_2
    //   1949: arraylength
    //   1950: iconst_2
    //   1951: isub
    //   1952: istore 47
    //   1954: iload 47
    //   1956: anewarray 348	java/lang/Object
    //   1959: astore 48
    //   1961: iload 47
    //   1963: istore 49
    //   1965: iinc 49 255
    //   1968: iload 49
    //   1970: ifge +13 -> 1983
    //   1973: aload 45
    //   1975: aload 46
    //   1977: aload 48
    //   1979: invokestatic 1845	gnu/kawa/slib/srfi1:lsetIntersection$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1982: areturn
    //   1983: aload 48
    //   1985: iload 49
    //   1987: aload_2
    //   1988: iload 49
    //   1990: iconst_2
    //   1991: iadd
    //   1992: aaload
    //   1993: aastore
    //   1994: goto -29 -> 1965
    //   1997: aload_2
    //   1998: iconst_0
    //   1999: aaload
    //   2000: astore 36
    //   2002: aload 36
    //   2004: checkcast 1043	gnu/mapping/Procedure
    //   2007: astore 38
    //   2009: aload_2
    //   2010: iconst_1
    //   2011: aaload
    //   2012: astore 39
    //   2014: aload_2
    //   2015: arraylength
    //   2016: iconst_2
    //   2017: isub
    //   2018: istore 40
    //   2020: iload 40
    //   2022: anewarray 348	java/lang/Object
    //   2025: astore 41
    //   2027: iload 40
    //   2029: istore 42
    //   2031: iinc 42 255
    //   2034: iload 42
    //   2036: ifge +13 -> 2049
    //   2039: aload 38
    //   2041: aload 39
    //   2043: aload 41
    //   2045: invokestatic 1847	gnu/kawa/slib/srfi1:lsetDifference$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2048: areturn
    //   2049: aload 41
    //   2051: iload 42
    //   2053: aload_2
    //   2054: iload 42
    //   2056: iconst_2
    //   2057: iadd
    //   2058: aaload
    //   2059: aastore
    //   2060: goto -29 -> 2031
    //   2063: aload_2
    //   2064: iconst_0
    //   2065: aaload
    //   2066: astore 29
    //   2068: aload 29
    //   2070: checkcast 1043	gnu/mapping/Procedure
    //   2073: astore 31
    //   2075: aload_2
    //   2076: iconst_1
    //   2077: aaload
    //   2078: astore 32
    //   2080: aload_2
    //   2081: arraylength
    //   2082: iconst_2
    //   2083: isub
    //   2084: istore 33
    //   2086: iload 33
    //   2088: anewarray 348	java/lang/Object
    //   2091: astore 34
    //   2093: iload 33
    //   2095: istore 35
    //   2097: iinc 35 255
    //   2100: iload 35
    //   2102: ifge +13 -> 2115
    //   2105: aload 31
    //   2107: aload 32
    //   2109: aload 34
    //   2111: invokestatic 1849	gnu/kawa/slib/srfi1:lsetDifference$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2114: areturn
    //   2115: aload 34
    //   2117: iload 35
    //   2119: aload_2
    //   2120: iload 35
    //   2122: iconst_2
    //   2123: iadd
    //   2124: aaload
    //   2125: aastore
    //   2126: goto -29 -> 2097
    //   2129: aload_2
    //   2130: iconst_0
    //   2131: aaload
    //   2132: astore 23
    //   2134: aload 23
    //   2136: checkcast 1043	gnu/mapping/Procedure
    //   2139: astore 25
    //   2141: aload_2
    //   2142: arraylength
    //   2143: iconst_1
    //   2144: isub
    //   2145: istore 26
    //   2147: iload 26
    //   2149: anewarray 348	java/lang/Object
    //   2152: astore 27
    //   2154: iload 26
    //   2156: istore 28
    //   2158: iinc 28 255
    //   2161: iload 28
    //   2163: ifge +11 -> 2174
    //   2166: aload 25
    //   2168: aload 27
    //   2170: invokestatic 1851	gnu/kawa/slib/srfi1:lsetXor$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2173: areturn
    //   2174: aload 27
    //   2176: iload 28
    //   2178: aload_2
    //   2179: iload 28
    //   2181: iconst_1
    //   2182: iadd
    //   2183: aaload
    //   2184: aastore
    //   2185: goto -27 -> 2158
    //   2188: aload_2
    //   2189: iconst_0
    //   2190: aaload
    //   2191: astore 17
    //   2193: aload 17
    //   2195: checkcast 1043	gnu/mapping/Procedure
    //   2198: astore 19
    //   2200: aload_2
    //   2201: arraylength
    //   2202: iconst_1
    //   2203: isub
    //   2204: istore 20
    //   2206: iload 20
    //   2208: anewarray 348	java/lang/Object
    //   2211: astore 21
    //   2213: iload 20
    //   2215: istore 22
    //   2217: iinc 22 255
    //   2220: iload 22
    //   2222: ifge +11 -> 2233
    //   2225: aload 19
    //   2227: aload 21
    //   2229: invokestatic 1853	gnu/kawa/slib/srfi1:lsetXor$Ex$V	(Lgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2232: areturn
    //   2233: aload 21
    //   2235: iload 22
    //   2237: aload_2
    //   2238: iload 22
    //   2240: iconst_1
    //   2241: iadd
    //   2242: aaload
    //   2243: aastore
    //   2244: goto -27 -> 2217
    //   2247: aload_2
    //   2248: iconst_0
    //   2249: aaload
    //   2250: astore 10
    //   2252: aload 10
    //   2254: checkcast 1043	gnu/mapping/Procedure
    //   2257: astore 12
    //   2259: aload_2
    //   2260: iconst_1
    //   2261: aaload
    //   2262: astore 13
    //   2264: aload_2
    //   2265: arraylength
    //   2266: iconst_2
    //   2267: isub
    //   2268: istore 14
    //   2270: iload 14
    //   2272: anewarray 348	java/lang/Object
    //   2275: astore 15
    //   2277: iload 14
    //   2279: istore 16
    //   2281: iinc 16 255
    //   2284: iload 16
    //   2286: ifge +13 -> 2299
    //   2289: aload 12
    //   2291: aload 13
    //   2293: aload 15
    //   2295: invokestatic 1855	gnu/kawa/slib/srfi1:lsetDiff$PlIntersection$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2298: areturn
    //   2299: aload 15
    //   2301: iload 16
    //   2303: aload_2
    //   2304: iload 16
    //   2306: iconst_2
    //   2307: iadd
    //   2308: aaload
    //   2309: aastore
    //   2310: goto -29 -> 2281
    //   2313: aload_2
    //   2314: iconst_0
    //   2315: aaload
    //   2316: astore_3
    //   2317: aload_3
    //   2318: checkcast 1043	gnu/mapping/Procedure
    //   2321: astore 5
    //   2323: aload_2
    //   2324: iconst_1
    //   2325: aaload
    //   2326: astore 6
    //   2328: aload_2
    //   2329: arraylength
    //   2330: iconst_2
    //   2331: isub
    //   2332: istore 7
    //   2334: iload 7
    //   2336: anewarray 348	java/lang/Object
    //   2339: astore 8
    //   2341: iload 7
    //   2343: istore 9
    //   2345: iinc 9 255
    //   2348: iload 9
    //   2350: ifge +13 -> 2363
    //   2353: aload 5
    //   2355: aload 6
    //   2357: aload 8
    //   2359: invokestatic 1857	gnu/kawa/slib/srfi1:lsetDiff$PlIntersection$Ex$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2362: areturn
    //   2363: aload 8
    //   2365: iload 9
    //   2367: aload_2
    //   2368: iload 9
    //   2370: iconst_2
    //   2371: iadd
    //   2372: aaload
    //   2373: aastore
    //   2374: goto -29 -> 2345
    //   2377: astore 198
    //   2379: new 1052	gnu/mapping/WrongType
    //   2382: dup
    //   2383: aload 198
    //   2385: ldc_w 636
    //   2388: iconst_1
    //   2389: aload 197
    //   2391: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2394: athrow
    //   2395: astore 187
    //   2397: new 1052	gnu/mapping/WrongType
    //   2400: dup
    //   2401: aload 187
    //   2403: ldc_w 633
    //   2406: iconst_1
    //   2407: aload 186
    //   2409: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2412: athrow
    //   2413: astore 190
    //   2415: new 1052	gnu/mapping/WrongType
    //   2418: dup
    //   2419: aload 190
    //   2421: ldc_w 633
    //   2424: iconst_2
    //   2425: aload 189
    //   2427: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2430: athrow
    //   2431: astore 193
    //   2433: new 1052	gnu/mapping/WrongType
    //   2436: dup
    //   2437: aload 193
    //   2439: ldc_w 633
    //   2442: iconst_3
    //   2443: aload 192
    //   2445: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2448: athrow
    //   2449: astore 173
    //   2451: new 1052	gnu/mapping/WrongType
    //   2454: dup
    //   2455: aload 173
    //   2457: ldc_w 629
    //   2460: iconst_1
    //   2461: aload 172
    //   2463: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2466: athrow
    //   2467: astore 176
    //   2469: new 1052	gnu/mapping/WrongType
    //   2472: dup
    //   2473: aload 176
    //   2475: ldc_w 629
    //   2478: iconst_2
    //   2479: aload 175
    //   2481: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2484: athrow
    //   2485: astore 179
    //   2487: new 1052	gnu/mapping/WrongType
    //   2490: dup
    //   2491: aload 179
    //   2493: ldc_w 629
    //   2496: iconst_3
    //   2497: aload 178
    //   2499: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2502: athrow
    //   2503: astore 165
    //   2505: new 1052	gnu/mapping/WrongType
    //   2508: dup
    //   2509: aload 165
    //   2511: ldc_w 626
    //   2514: iconst_1
    //   2515: aload 164
    //   2517: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2520: athrow
    //   2521: astore 157
    //   2523: new 1052	gnu/mapping/WrongType
    //   2526: dup
    //   2527: aload 157
    //   2529: ldc_w 623
    //   2532: iconst_1
    //   2533: aload 156
    //   2535: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2538: athrow
    //   2539: astore 149
    //   2541: new 1052	gnu/mapping/WrongType
    //   2544: dup
    //   2545: aload 149
    //   2547: ldc_w 619
    //   2550: iconst_1
    //   2551: aload 148
    //   2553: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2556: athrow
    //   2557: astore 141
    //   2559: new 1052	gnu/mapping/WrongType
    //   2562: dup
    //   2563: aload 141
    //   2565: ldc_w 615
    //   2568: iconst_1
    //   2569: aload 140
    //   2571: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2574: athrow
    //   2575: astore 124
    //   2577: new 1052	gnu/mapping/WrongType
    //   2580: dup
    //   2581: aload 124
    //   2583: ldc_w 596
    //   2586: iconst_1
    //   2587: aload 123
    //   2589: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2592: athrow
    //   2593: astore 117
    //   2595: new 1052	gnu/mapping/WrongType
    //   2598: dup
    //   2599: aload 117
    //   2601: ldc_w 592
    //   2604: iconst_1
    //   2605: aload 116
    //   2607: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2610: athrow
    //   2611: astore 110
    //   2613: new 1052	gnu/mapping/WrongType
    //   2616: dup
    //   2617: aload 110
    //   2619: ldc_w 588
    //   2622: iconst_1
    //   2623: aload 109
    //   2625: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2628: athrow
    //   2629: astore 103
    //   2631: new 1052	gnu/mapping/WrongType
    //   2634: dup
    //   2635: aload 103
    //   2637: ldc_w 499
    //   2640: iconst_1
    //   2641: aload 102
    //   2643: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2646: athrow
    //   2647: astore 96
    //   2649: new 1052	gnu/mapping/WrongType
    //   2652: dup
    //   2653: aload 96
    //   2655: ldc_w 496
    //   2658: iconst_1
    //   2659: aload 95
    //   2661: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2664: athrow
    //   2665: astore 89
    //   2667: new 1052	gnu/mapping/WrongType
    //   2670: dup
    //   2671: aload 89
    //   2673: ldc_w 436
    //   2676: iconst_1
    //   2677: aload 88
    //   2679: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2682: athrow
    //   2683: astore 83
    //   2685: new 1052	gnu/mapping/WrongType
    //   2688: dup
    //   2689: aload 83
    //   2691: ldc_w 432
    //   2694: iconst_1
    //   2695: aload 82
    //   2697: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2700: athrow
    //   2701: astore 77
    //   2703: new 1052	gnu/mapping/WrongType
    //   2706: dup
    //   2707: aload 77
    //   2709: ldc_w 428
    //   2712: iconst_1
    //   2713: aload 76
    //   2715: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2718: athrow
    //   2719: astore 70
    //   2721: new 1052	gnu/mapping/WrongType
    //   2724: dup
    //   2725: aload 70
    //   2727: ldc_w 424
    //   2730: iconst_1
    //   2731: aload 69
    //   2733: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2736: athrow
    //   2737: astore 64
    //   2739: new 1052	gnu/mapping/WrongType
    //   2742: dup
    //   2743: aload 64
    //   2745: ldc_w 420
    //   2748: iconst_1
    //   2749: aload 63
    //   2751: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2754: athrow
    //   2755: astore 58
    //   2757: new 1052	gnu/mapping/WrongType
    //   2760: dup
    //   2761: aload 58
    //   2763: ldc_w 416
    //   2766: iconst_1
    //   2767: aload 57
    //   2769: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2772: athrow
    //   2773: astore 51
    //   2775: new 1052	gnu/mapping/WrongType
    //   2778: dup
    //   2779: aload 51
    //   2781: ldc_w 412
    //   2784: iconst_1
    //   2785: aload 50
    //   2787: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2790: athrow
    //   2791: astore 44
    //   2793: new 1052	gnu/mapping/WrongType
    //   2796: dup
    //   2797: aload 44
    //   2799: ldc_w 408
    //   2802: iconst_1
    //   2803: aload 43
    //   2805: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2808: athrow
    //   2809: astore 37
    //   2811: new 1052	gnu/mapping/WrongType
    //   2814: dup
    //   2815: aload 37
    //   2817: ldc_w 404
    //   2820: iconst_1
    //   2821: aload 36
    //   2823: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2826: athrow
    //   2827: astore 30
    //   2829: new 1052	gnu/mapping/WrongType
    //   2832: dup
    //   2833: aload 30
    //   2835: ldc_w 400
    //   2838: iconst_1
    //   2839: aload 29
    //   2841: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2844: athrow
    //   2845: astore 24
    //   2847: new 1052	gnu/mapping/WrongType
    //   2850: dup
    //   2851: aload 24
    //   2853: ldc_w 396
    //   2856: iconst_1
    //   2857: aload 23
    //   2859: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2862: athrow
    //   2863: astore 18
    //   2865: new 1052	gnu/mapping/WrongType
    //   2868: dup
    //   2869: aload 18
    //   2871: ldc_w 392
    //   2874: iconst_1
    //   2875: aload 17
    //   2877: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2880: athrow
    //   2881: astore 11
    //   2883: new 1052	gnu/mapping/WrongType
    //   2886: dup
    //   2887: aload 11
    //   2889: ldc_w 388
    //   2892: iconst_1
    //   2893: aload 10
    //   2895: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2898: athrow
    //   2899: astore 4
    //   2901: new 1052	gnu/mapping/WrongType
    //   2904: dup
    //   2905: aload 4
    //   2907: ldc_w 384
    //   2910: iconst_1
    //   2911: aload_3
    //   2912: invokespecial 1057	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   2915: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   518	525	2377	java/lang/ClassCastException
    //   590	597	2395	java/lang/ClassCastException
    //   602	609	2413	java/lang/ClassCastException
    //   614	621	2431	java/lang/ClassCastException
    //   668	675	2449	java/lang/ClassCastException
    //   680	687	2467	java/lang/ClassCastException
    //   692	699	2485	java/lang/ClassCastException
    //   762	769	2503	java/lang/ClassCastException
    //   835	842	2521	java/lang/ClassCastException
    //   908	915	2539	java/lang/ClassCastException
    //   981	988	2557	java/lang/ClassCastException
    //   1172	1179	2575	java/lang/ClassCastException
    //   1238	1245	2593	java/lang/ClassCastException
    //   1304	1311	2611	java/lang/ClassCastException
    //   1370	1377	2629	java/lang/ClassCastException
    //   1436	1443	2647	java/lang/ClassCastException
    //   1502	1509	2665	java/lang/ClassCastException
    //   1568	1575	2683	java/lang/ClassCastException
    //   1627	1634	2701	java/lang/ClassCastException
    //   1686	1693	2719	java/lang/ClassCastException
    //   1752	1759	2737	java/lang/ClassCastException
    //   1811	1818	2755	java/lang/ClassCastException
    //   1870	1877	2773	java/lang/ClassCastException
    //   1936	1943	2791	java/lang/ClassCastException
    //   2002	2009	2809	java/lang/ClassCastException
    //   2068	2075	2827	java/lang/ClassCastException
    //   2134	2141	2845	java/lang/ClassCastException
    //   2193	2200	2863	java/lang/ClassCastException
    //   2252	2259	2881	java/lang/ClassCastException
    //   2317	2323	2899	java/lang/ClassCastException
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 152:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 149:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 147:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 121:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 120:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 116:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 115:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 114:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 113:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 112:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 111:
      if (!(paramObject instanceof Pair))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 110:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 101:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 100:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 99:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 98:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 97:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 96:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 95:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 93:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 91:
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
    case 87:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 83:
      if (IntNum.asIntNumOrNull(paramObject) != null)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return -786431;
    case 82:
    }
    if ((paramObject instanceof LList))
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
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 183:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 182:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 165:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 164:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 163:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 162:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 161:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 160:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 159:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 158:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 157:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 155:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 153:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 149:
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 147:
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 145:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 143:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 142:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 141:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 140:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 139:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 138:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 137:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 119:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 118:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 109:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 108:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 107:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 106:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 105:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 104:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 103:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 102:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 83:
      if (IntNum.asIntNumOrNull(paramObject1) != null)
      {
        paramCallContext.value1 = paramObject1;
        if (Numeric.asNumericOrNull(paramObject2) != null)
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
    case 80:
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 78:
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
    case 155:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 153:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 151:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 145:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 143:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 131:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 130:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 83:
    }
    if (IntNum.asIntNumOrNull(paramObject1) != null)
    {
      paramCallContext.value1 = paramObject1;
      if (Numeric.asNumericOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        if (Numeric.asNumericOrNull(paramObject3) == null)
          break label408;
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
    label408: return -786429;
  }

  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 123)
    {
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
      paramCallContext.value2 = paramObject2;
      if (!(paramObject3 instanceof Procedure))
        return -786429;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    }
    return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
  }

  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    case 181:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 180:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 179:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 178:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 177:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 176:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 175:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 174:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 173:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 172:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 171:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 170:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 169:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 168:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 167:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 166:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 136:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 135:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 134:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 133:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 132:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 129:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 128:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 127:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 126:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 125:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 123:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 122:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 117:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 94:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 92:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 86:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 81:
      paramCallContext.values = paramArrayOfObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 5;
      return 0;
    case 79:
    }
    paramCallContext.values = paramArrayOfObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 5;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
    first = lists.car;
    second = lists.cadr;
    third = lists.caddr;
    fourth = lists.cadddr;
    map$Mnin$Mnorder = Scheme.map;
  }

  public class frame extends ModuleBody
  {
    public static Object lambda2recur(Object paramObject)
    {
      srfi1.frame0 localframe0 = new srfi1.frame0();
      localframe0.lis = paramObject;
      if (srfi1.isNullList(localframe0.lis) != Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localframe0.lis;
        arrayOfObject[1] = localframe0.lis;
        return misc.values(arrayOfObject);
      }
      localframe0.elt = lists.car.apply1(localframe0.lis);
      return call_with_values.callWithValues(localframe0.lambda$Fn1, localframe0.lambda$Fn2);
    }
  }

  public class frame0 extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn1 = new ModuleMethod(this, 1, null, 0);
    final ModuleMethod lambda$Fn2;
    Object lis;

    public frame0()
    {
      this$1 = new ModuleMethod(this, 2, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:627");
      this.lambda$Fn2 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 1)
        return lambda3();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 2)
        return lambda4(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda3()
    {
      return srfi1.frame.lambda2recur(lists.cdr.apply1(this.lis));
    }

    Object lambda4(Object paramObject1, Object paramObject2)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = lists.cons(lists.car.apply1(this.elt), paramObject1);
      arrayOfObject[1] = lists.cons(lists.cadr.apply1(this.elt), paramObject2);
      return misc.values(arrayOfObject);
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

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 2)
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
    public static Object lambda5recur(Object paramObject)
    {
      srfi1.frame2 localframe2 = new srfi1.frame2();
      localframe2.lis = paramObject;
      if (srfi1.isNullList(localframe2.lis) != Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = localframe2.lis;
        arrayOfObject[1] = localframe2.lis;
        arrayOfObject[2] = localframe2.lis;
        return misc.values(arrayOfObject);
      }
      localframe2.elt = lists.car.apply1(localframe2.lis);
      return call_with_values.callWithValues(localframe2.lambda$Fn3, localframe2.lambda$Fn4);
    }
  }

  public class frame10 extends ModuleBody
  {
    Procedure f;
    Object zero;

    public Object lambda19recur(Object paramObject)
    {
      Object localObject = srfi1.$PcCdrs(paramObject);
      if (lists.isNull(localObject))
        return this.zero;
      Apply localApply = Scheme.apply;
      Procedure localProcedure = this.f;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramObject;
      arrayOfObject[1] = LList.list1(lambda19recur(localObject));
      return localApply.apply2(localProcedure, srfi1.append$Ex$V(arrayOfObject));
    }

    public Object lambda20recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE)
        return this.zero;
      return this.f.apply2(paramObject, lambda20recur(lists.cdr.apply1(paramObject)));
    }
  }

  public class frame11 extends ModuleBody
  {
    Procedure f;

    public Object lambda21recur(Object paramObject1, Object paramObject2)
    {
      if (lists.isPair(paramObject2))
        return this.f.apply2(paramObject1, lambda21recur(lists.car.apply1(paramObject2), lists.cdr.apply1(paramObject2)));
      return paramObject1;
    }
  }

  public class frame12 extends ModuleBody
  {
    Procedure f;
    final ModuleMethod lambda$Fn11;

    public frame12()
    {
      this$1 = new ModuleMethod(this, 11, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:961");
      this.lambda$Fn11 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 11)
      {
        lambda22(paramObject);
        return Values.empty;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    void lambda22(Object paramObject)
    {
      try
      {
        Pair localPair = (Pair)paramObject;
        lists.setCar$Ex(localPair, this.f.apply1(lists.car.apply1(paramObject)));
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-car!", 1, paramObject);
      }
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

  public class frame13 extends ModuleBody
  {
    Procedure f;

    public Object lambda23recur(Object paramObject1, Object paramObject2)
    {
      srfi1.frame14 localframe14 = new srfi1.frame14();
      localframe14.staticLink = this;
      localframe14.lists = paramObject1;
      localframe14.res = paramObject2;
      return call_with_values.callWithValues(localframe14.lambda$Fn12, localframe14.lambda$Fn13);
    }
  }

  public class frame14 extends ModuleBody
  {
    final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 12, null, 0);
    final ModuleMethod lambda$Fn13;
    Object lists;
    Object res;
    srfi1.frame13 staticLink;

    public frame14()
    {
      this$1 = new ModuleMethod(this, 13, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:969");
      this.lambda$Fn13 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 12)
        return lambda24();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 13)
        return lambda25(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda24()
    {
      return srfi1.$PcCars$PlCdrs(this.lists);
    }

    Object lambda25(Object paramObject1, Object paramObject2)
    {
      Object localObject2;
      if (srfi1.isNotPair(paramObject1))
        localObject2 = this.res;
      try
      {
        LList localLList = (LList)localObject2;
        return lists.reverse$Ex(localLList);
        Object localObject1 = Scheme.apply.apply2(this.staticLink.f, paramObject1);
        if (localObject1 != Boolean.FALSE)
          return this.staticLink.lambda23recur(paramObject2, lists.cons(localObject1, this.res));
        return this.staticLink.lambda23recur(paramObject2, this.res);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "reverse!", 1, localObject2);
      }
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 12)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 13)
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

  public class frame15 extends ModuleBody
  {
    final ModuleMethod lambda$Fn14;
    Object pred;

    public frame15()
    {
      this$1 = new ModuleMethod(this, 14, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1199");
      this.lambda$Fn14 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 14)
      {
        if (lambda26(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda26(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 14)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame16 extends ModuleBody
  {
    final ModuleMethod lambda$Fn15;
    Object pred;

    public frame16()
    {
      this$1 = new ModuleMethod(this, 15, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1200");
      this.lambda$Fn15 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 15)
      {
        if (lambda27(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda27(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 15)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame17 extends ModuleBody
  {
    final ModuleMethod lambda$Fn16;
    Object maybe$Mn$Eq;
    Object x;

    public frame17()
    {
      this$1 = new ModuleMethod(this, 16, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1222");
      this.lambda$Fn16 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 16)
      {
        if (lambda28(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda28(Object paramObject)
    {
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.x, paramObject) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 16)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame18 extends ModuleBody
  {
    final ModuleMethod lambda$Fn17;
    Object maybe$Mn$Eq;
    Object x;

    public frame18()
    {
      this$1 = new ModuleMethod(this, 17, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1225");
      this.lambda$Fn17 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 17)
      {
        if (lambda29(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda29(Object paramObject)
    {
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.x, paramObject) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 17)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame19 extends ModuleBody
  {
    Procedure maybe$Mn$Eq;

    public Object lambda30recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE)
        return paramObject;
      Object localObject1 = lists.car.apply1(paramObject);
      Object localObject2 = lists.cdr.apply1(paramObject);
      Object localObject3 = lambda30recur(srfi1.delete(localObject1, localObject2, this.maybe$Mn$Eq));
      if (localObject2 == localObject3)
        return paramObject;
      return lists.cons(localObject1, localObject3);
    }
  }

  public class frame2 extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn4;
    Object lis;

    public frame2()
    {
      this$1 = new ModuleMethod(this, 4, null, 12291);
      this$1.setProperty("source-location", "srfi1.scm:635");
      this.lambda$Fn4 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 3)
        return lambda6();
      return super.apply0(paramModuleMethod);
    }

    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (paramModuleMethod.selector == 4)
        return lambda7(paramObject1, paramObject2, paramObject3);
      return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
    }

    Object lambda6()
    {
      return srfi1.frame1.lambda5recur(lists.cdr.apply1(this.lis));
    }

    Object lambda7(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = lists.cons(lists.car.apply1(this.elt), paramObject1);
      arrayOfObject[1] = lists.cons(lists.cadr.apply1(this.elt), paramObject2);
      arrayOfObject[2] = lists.cons(lists.caddr.apply1(this.elt), paramObject3);
      return misc.values(arrayOfObject);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 3)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 4)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      }
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
  }

  public class frame20 extends ModuleBody
  {
    Procedure maybe$Mn$Eq;

    public Object lambda31recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE)
        return paramObject;
      Object localObject1 = lists.car.apply1(paramObject);
      Object localObject2 = lists.cdr.apply1(paramObject);
      Object localObject3 = lambda31recur(srfi1.delete$Ex(localObject1, localObject2, this.maybe$Mn$Eq));
      if (localObject2 == localObject3)
        return paramObject;
      return lists.cons(localObject1, localObject3);
    }
  }

  public class frame21 extends ModuleBody
  {
    Object key;
    final ModuleMethod lambda$Fn18;
    Object maybe$Mn$Eq;

    public frame21()
    {
      this$1 = new ModuleMethod(this, 18, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1280");
      this.lambda$Fn18 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 18)
      {
        if (lambda32(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda32(Object paramObject)
    {
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.key, lists.car.apply1(paramObject)) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 18)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame22 extends ModuleBody
  {
    Object key;
    final ModuleMethod lambda$Fn19;
    Object maybe$Mn$Eq;

    public frame22()
    {
      this$1 = new ModuleMethod(this, 19, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1283");
      this.lambda$Fn19 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 19)
      {
        if (lambda33(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda33(Object paramObject)
    {
      if (Scheme.applyToArgs.apply3(this.maybe$Mn$Eq, this.key, lists.car.apply1(paramObject)) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 19)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame23 extends ModuleBody
  {
    Procedure pred;

    public Object lambda34recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE)
        return LList.Empty;
      Object localObject = lists.car.apply1(paramObject);
      if (this.pred.apply1(localObject) != Boolean.FALSE)
        return lists.cons(localObject, lambda34recur(lists.cdr.apply1(paramObject)));
      return LList.Empty;
    }
  }

  public class frame24 extends ModuleBody
  {
    final ModuleMethod lambda$Fn20;
    Object pred;

    public frame24()
    {
      this$1 = new ModuleMethod(this, 20, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1343");
      this.lambda$Fn20 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 20)
      {
        if (lambda35(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda35(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 20)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame25 extends ModuleBody
  {
    final ModuleMethod lambda$Fn21;
    Object pred;

    public frame25()
    {
      this$1 = new ModuleMethod(this, 21, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1344");
      this.lambda$Fn21 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 21)
      {
        if (lambda36(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda36(Object paramObject)
    {
      if (Scheme.applyToArgs.apply2(this.pred, paramObject) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 21)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame26 extends ModuleBody
  {
    final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 22, null, 0);
    final ModuleMethod lambda$Fn23;
    Object lis1;
    LList lists;
    Procedure pred;

    public frame26()
    {
      this$1 = new ModuleMethod(this, 23, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1350");
      this.lambda$Fn23 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 22)
        return lambda37();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 23)
        return lambda38(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda37()
    {
      return srfi1.$PcCars$PlCdrs(lists.cons(this.lis1, this.lists));
    }

    Object lambda38(Object paramObject1, Object paramObject2)
    {
      boolean bool = lists.isPair(paramObject1);
      if (bool)
      {
        while (true)
        {
          Object localObject1 = srfi1.$PcCars$PlCdrs$SlPair(paramObject2);
          Object localObject2 = lists.car.apply1(localObject1);
          Object localObject3 = lists.cdr.apply1(localObject1);
          if (!lists.isPair(localObject2))
            break;
          Object localObject4 = Scheme.apply.apply2(this.pred, paramObject1);
          if (localObject4 != Boolean.FALSE)
            return localObject4;
          paramObject2 = localObject3;
          paramObject1 = localObject2;
        }
        return Scheme.apply.apply2(this.pred, paramObject1);
      }
      if (bool)
        return Boolean.TRUE;
      return Boolean.FALSE;
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 22)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 23)
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

  public class frame27 extends ModuleBody
  {
    final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 26, null, 0);
    final ModuleMethod lambda$Fn25;
    Object lis1;
    LList lists;
    Procedure pred;

    public frame27()
    {
      this$1 = new ModuleMethod(this, 27, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1378");
      this.lambda$Fn25 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 26)
        return lambda39();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 27)
        return lambda40(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda39()
    {
      return srfi1.$PcCars$PlCdrs(lists.cons(this.lis1, this.lists));
    }

    Object lambda40(Object paramObject1, Object paramObject2)
    {
      srfi1.frame28 localframe28 = new srfi1.frame28();
      localframe28.staticLink = this;
      int i = 0x1 & true + lists.isPair(paramObject1);
      if (i != 0)
      {
        if (i != 0)
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return localframe28.lambda41lp(paramObject1, paramObject2);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 26)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 27)
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

  public class frame28 extends ModuleBody
  {
    srfi1.frame27 staticLink;

    public Object lambda41lp(Object paramObject1, Object paramObject2)
    {
      srfi1.frame29 localframe29 = new srfi1.frame29();
      localframe29.staticLink = this;
      localframe29.heads = paramObject1;
      localframe29.tails = paramObject2;
      return call_with_values.callWithValues(localframe29.lambda$Fn26, localframe29.lambda$Fn27);
    }
  }

  public class frame29 extends ModuleBody
  {
    Object heads;
    final ModuleMethod lambda$Fn26 = new ModuleMethod(this, 24, null, 0);
    final ModuleMethod lambda$Fn27;
    srfi1.frame28 staticLink;
    Object tails;

    public frame29()
    {
      this$1 = new ModuleMethod(this, 25, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1381");
      this.lambda$Fn27 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 24)
        return lambda42();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 25)
        return lambda43(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda42()
    {
      return srfi1.$PcCars$PlCdrs(this.tails);
    }

    Object lambda43(Object paramObject1, Object paramObject2)
    {
      if (lists.isPair(paramObject1))
      {
        Object localObject = Scheme.apply.apply2(this.staticLink.staticLink.pred, this.heads);
        if (localObject != Boolean.FALSE)
          return this.staticLink.lambda41lp(paramObject1, paramObject2);
        return localObject;
      }
      return Scheme.apply.apply2(this.staticLink.staticLink.pred, this.heads);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 24)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 25)
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

  public class frame3 extends ModuleBody
  {
    public static Object lambda8recur(Object paramObject)
    {
      srfi1.frame4 localframe4 = new srfi1.frame4();
      localframe4.lis = paramObject;
      if (srfi1.isNullList(localframe4.lis) != Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = localframe4.lis;
        arrayOfObject[1] = localframe4.lis;
        arrayOfObject[2] = localframe4.lis;
        arrayOfObject[3] = localframe4.lis;
        return misc.values(arrayOfObject);
      }
      localframe4.elt = lists.car.apply1(localframe4.lis);
      return call_with_values.callWithValues(localframe4.lambda$Fn5, localframe4.lambda$Fn6);
    }
  }

  public class frame30 extends ModuleBody
  {
    Procedure pred;

    public Object lambda44lp(Object paramObject1, Object paramObject2)
    {
      srfi1.frame31 localframe31 = new srfi1.frame31();
      localframe31.staticLink = this;
      localframe31.lists = paramObject1;
      localframe31.n = paramObject2;
      return call_with_values.callWithValues(localframe31.lambda$Fn28, localframe31.lambda$Fn29);
    }
  }

  public class frame31 extends ModuleBody
  {
    final ModuleMethod lambda$Fn28 = new ModuleMethod(this, 28, null, 0);
    final ModuleMethod lambda$Fn29;
    Object lists;
    Object n;
    srfi1.frame30 staticLink;

    public frame31()
    {
      this$1 = new ModuleMethod(this, 29, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1404");
      this.lambda$Fn29 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 28)
        return lambda45();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 29)
        return lambda46(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda45()
    {
      return srfi1.$PcCars$PlCdrs(this.lists);
    }

    Object lambda46(Object paramObject1, Object paramObject2)
    {
      boolean bool = lists.isPair(paramObject1);
      if (bool)
      {
        if (Scheme.apply.apply2(this.staticLink.pred, paramObject1) != Boolean.FALSE)
          return this.n;
        return this.staticLink.lambda44lp(paramObject2, AddOp.$Pl.apply2(this.n, srfi1.Lit1));
      }
      if (bool)
        return Boolean.TRUE;
      return Boolean.FALSE;
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 28)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 29)
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

  public class frame32 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn30;

    public frame32()
    {
      this$1 = new ModuleMethod(this, 30, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1466");
      this.lambda$Fn30 = this$1;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 30)
        return lambda47(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda47(Object paramObject1, Object paramObject2)
    {
      if (lists.member(paramObject1, paramObject2, this.$Eq) != Boolean.FALSE)
        return paramObject2;
      return lists.cons(paramObject1, paramObject2);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 30)
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

  public class frame33 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn31;
    final ModuleMethod lambda$Fn32;

    public frame33()
    {
      this$1 = new ModuleMethod(this, 32, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1476");
      this.lambda$Fn32 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 33, null, 8194);
      localModuleMethod.setProperty("source-location", "srfi1.scm:1471");
      this.lambda$Fn31 = localModuleMethod;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.apply2(paramModuleMethod, paramObject1, paramObject2);
      case 32:
        return lambda49(paramObject1, paramObject2);
      case 33:
      }
      return lambda48(paramObject1, paramObject2);
    }

    Object lambda48(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1))
        return paramObject2;
      if (lists.isNull(paramObject2))
        return paramObject1;
      if (paramObject1 == paramObject2)
        return paramObject2;
      return srfi1.fold$V(this.lambda$Fn32, paramObject2, paramObject1, new Object[0]);
    }

    Object lambda49(Object paramObject1, Object paramObject2)
    {
      srfi1.frame34 localframe34 = new srfi1.frame34();
      localframe34.staticLink = this;
      localframe34.elt = paramObject1;
      if (srfi1.any$V(localframe34.lambda$Fn33, paramObject2, new Object[0]) != Boolean.FALSE)
        return paramObject2;
      return lists.cons(localframe34.elt, paramObject2);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
      case 33:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      case 32:
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
  }

  public class frame34 extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn33;
    srfi1.frame33 staticLink;

    public frame34()
    {
      this$1 = new ModuleMethod(this, 31, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1476");
      this.lambda$Fn33 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 31)
        return lambda50(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda50(Object paramObject)
    {
      return this.staticLink.$Eq.apply2(paramObject, this.elt);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 31)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame35 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn34;
    final ModuleMethod lambda$Fn35;

    public frame35()
    {
      this$1 = new ModuleMethod(this, 35, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1488");
      this.lambda$Fn35 = this$1;
      ModuleMethod localModuleMethod = new ModuleMethod(this, 36, null, 8194);
      localModuleMethod.setProperty("source-location", "srfi1.scm:1483");
      this.lambda$Fn34 = localModuleMethod;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.apply2(paramModuleMethod, paramObject1, paramObject2);
      case 35:
        return lambda52(paramObject1, paramObject2);
      case 36:
      }
      return lambda51(paramObject1, paramObject2);
    }

    Object lambda51(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1))
        return paramObject2;
      if (lists.isNull(paramObject2))
        return paramObject1;
      if (paramObject1 == paramObject2)
        return paramObject2;
      return srfi1.pairFold$V(this.lambda$Fn35, paramObject2, paramObject1, new Object[0]);
    }

    Object lambda52(Object paramObject1, Object paramObject2)
    {
      srfi1.frame36 localframe36 = new srfi1.frame36();
      localframe36.staticLink = this;
      localframe36.elt = lists.car.apply1(paramObject1);
      if (srfi1.any$V(localframe36.lambda$Fn36, paramObject2, new Object[0]) != Boolean.FALSE)
        return paramObject2;
      try
      {
        Pair localPair = (Pair)paramObject1;
        lists.setCdr$Ex(localPair, paramObject2);
        return paramObject1;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, paramObject1);
      }
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
      case 36:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      case 35:
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    }
  }

  public class frame36 extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn36;
    srfi1.frame35 staticLink;

    public frame36()
    {
      this$1 = new ModuleMethod(this, 34, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1490");
      this.lambda$Fn36 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 34)
        return lambda53(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda53(Object paramObject)
    {
      return this.staticLink.$Eq.apply2(paramObject, this.elt);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 34)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame37 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn37;
    Object lists;

    public frame37()
    {
      this$1 = new ModuleMethod(this, 38, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1501");
      this.lambda$Fn37 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 38)
        return lambda54(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda54(Object paramObject)
    {
      srfi1.frame38 localframe38 = new srfi1.frame38();
      localframe38.staticLink = this;
      localframe38.x = paramObject;
      return srfi1.every$V(localframe38.lambda$Fn38, this.lists, new Object[0]);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 38)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame38 extends ModuleBody
  {
    final ModuleMethod lambda$Fn38;
    srfi1.frame37 staticLink;
    Object x;

    public frame38()
    {
      this$1 = new ModuleMethod(this, 37, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1502");
      this.lambda$Fn38 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 37)
        return lambda55(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda55(Object paramObject)
    {
      return lists.member(this.x, paramObject, this.staticLink.$Eq);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 37)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame39 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn39;
    Object lists;

    public frame39()
    {
      this$1 = new ModuleMethod(this, 40, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1509");
      this.lambda$Fn39 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 40)
        return lambda56(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda56(Object paramObject)
    {
      srfi1.frame40 localframe40 = new srfi1.frame40();
      localframe40.staticLink = this;
      localframe40.x = paramObject;
      return srfi1.every$V(localframe40.lambda$Fn40, this.lists, new Object[0]);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 40)
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
    Object elt;
    final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 5, null, 0);
    final ModuleMethod lambda$Fn6;
    Object lis;

    public frame4()
    {
      this$1 = new ModuleMethod(this, 6, null, 16388);
      this$1.setProperty("source-location", "srfi1.scm:644");
      this.lambda$Fn6 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 5)
        return lambda9();
      return super.apply0(paramModuleMethod);
    }

    public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      if (paramModuleMethod.selector == 6)
        return lambda10(paramObject1, paramObject2, paramObject3, paramObject4);
      return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }

    Object lambda10(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = lists.cons(lists.car.apply1(this.elt), paramObject1);
      arrayOfObject[1] = lists.cons(lists.cadr.apply1(this.elt), paramObject2);
      arrayOfObject[2] = lists.cons(lists.caddr.apply1(this.elt), paramObject3);
      arrayOfObject[3] = lists.cons(lists.cadddr.apply1(this.elt), paramObject4);
      return misc.values(arrayOfObject);
    }

    Object lambda9()
    {
      return srfi1.frame3.lambda8recur(lists.cdr.apply1(this.lis));
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 5)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 6)
      {
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.value4 = paramObject4;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 4;
        return 0;
      }
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    }
  }

  public class frame40 extends ModuleBody
  {
    final ModuleMethod lambda$Fn40;
    srfi1.frame39 staticLink;
    Object x;

    public frame40()
    {
      this$1 = new ModuleMethod(this, 39, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1510");
      this.lambda$Fn40 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 39)
        return lambda57(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda57(Object paramObject)
    {
      return lists.member(this.x, paramObject, this.staticLink.$Eq);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 39)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame41 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn41;
    Object lists;

    public frame41()
    {
      this$1 = new ModuleMethod(this, 42, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1518");
      this.lambda$Fn41 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 42)
        return lambda58(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda58(Object paramObject)
    {
      srfi1.frame42 localframe42 = new srfi1.frame42();
      localframe42.staticLink = this;
      localframe42.x = paramObject;
      return srfi1.every$V(localframe42.lambda$Fn42, this.lists, new Object[0]);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 42)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame42 extends ModuleBody
  {
    final ModuleMethod lambda$Fn42;
    srfi1.frame41 staticLink;
    Object x;

    public frame42()
    {
      this$1 = new ModuleMethod(this, 41, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1519");
      this.lambda$Fn42 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 41)
      {
        if (lambda59(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda59(Object paramObject)
    {
      if (lists.member(this.x, paramObject, this.staticLink.$Eq) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 41)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame43 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn43;
    Object lists;

    public frame43()
    {
      this$1 = new ModuleMethod(this, 44, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1527");
      this.lambda$Fn43 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 44)
        return lambda60(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda60(Object paramObject)
    {
      srfi1.frame44 localframe44 = new srfi1.frame44();
      localframe44.staticLink = this;
      localframe44.x = paramObject;
      return srfi1.every$V(localframe44.lambda$Fn44, this.lists, new Object[0]);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 44)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame44 extends ModuleBody
  {
    final ModuleMethod lambda$Fn44;
    srfi1.frame43 staticLink;
    Object x;

    public frame44()
    {
      this$1 = new ModuleMethod(this, 43, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1528");
      this.lambda$Fn44 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 43)
      {
        if (lambda61(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda61(Object paramObject)
    {
      if (lists.member(this.x, paramObject, this.staticLink.$Eq) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 43)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame45 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn45;

    public frame45()
    {
      this$1 = new ModuleMethod(this, 48, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1534");
      this.lambda$Fn45 = this$1;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 48)
        return lambda62(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda62(Object paramObject1, Object paramObject2)
    {
      srfi1.frame46 localframe46 = new srfi1.frame46();
      localframe46.staticLink = this;
      localframe46.b = paramObject1;
      localframe46.a = paramObject2;
      return call_with_values.callWithValues(localframe46.lambda$Fn46, localframe46.lambda$Fn47);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 48)
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

  public class frame46 extends ModuleBody
  {
    Object a;
    Object b;
    final ModuleMethod lambda$Fn46 = new ModuleMethod(this, 46, null, 0);
    final ModuleMethod lambda$Fn47;
    srfi1.frame45 staticLink;

    public frame46()
    {
      this$1 = new ModuleMethod(this, 47, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1544");
      this.lambda$Fn47 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 46)
        return lambda63();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 47)
        return lambda64(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda63()
    {
      Procedure localProcedure = this.staticLink.$Eq;
      Object localObject = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.b;
      return srfi1.lsetDiff$PlIntersection$V(localProcedure, localObject, arrayOfObject);
    }

    Object lambda64(Object paramObject1, Object paramObject2)
    {
      srfi1.frame47 localframe47 = new srfi1.frame47();
      localframe47.staticLink = this;
      localframe47.a$Mnint$Mnb = paramObject2;
      if (lists.isNull(paramObject1))
      {
        Procedure localProcedure = this.staticLink.$Eq;
        Object localObject = this.b;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.a;
        return srfi1.lsetDifference$V(localProcedure, localObject, arrayOfObject2);
      }
      if (lists.isNull(localframe47.a$Mnint$Mnb))
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = this.b;
        arrayOfObject1[1] = this.a;
        return append.append$V(arrayOfObject1);
      }
      return srfi1.fold$V(localframe47.lambda$Fn48, paramObject1, this.b, new Object[0]);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 46)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 47)
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

  public class frame47 extends ModuleBody
  {
    Object a$Mnint$Mnb;
    final ModuleMethod lambda$Fn48;
    srfi1.frame46 staticLink;

    public frame47()
    {
      this$1 = new ModuleMethod(this, 45, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1547");
      this.lambda$Fn48 = this$1;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 45)
        return lambda65(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda65(Object paramObject1, Object paramObject2)
    {
      if (lists.member(paramObject1, this.a$Mnint$Mnb, this.staticLink.staticLink.$Eq) != Boolean.FALSE)
        return paramObject2;
      return lists.cons(paramObject1, paramObject2);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 45)
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

  public class frame48 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn49;

    public frame48()
    {
      this$1 = new ModuleMethod(this, 52, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1555");
      this.lambda$Fn49 = this$1;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 52)
        return lambda66(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda66(Object paramObject1, Object paramObject2)
    {
      srfi1.frame49 localframe49 = new srfi1.frame49();
      localframe49.staticLink = this;
      localframe49.b = paramObject1;
      localframe49.a = paramObject2;
      return call_with_values.callWithValues(localframe49.lambda$Fn50, localframe49.lambda$Fn51);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 52)
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

  public class frame49 extends ModuleBody
  {
    Object a;
    Object b;
    final ModuleMethod lambda$Fn50 = new ModuleMethod(this, 50, null, 0);
    final ModuleMethod lambda$Fn51;
    srfi1.frame48 staticLink;

    public frame49()
    {
      this$1 = new ModuleMethod(this, 51, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1565");
      this.lambda$Fn51 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 50)
        return lambda67();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 51)
        return lambda68(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda67()
    {
      Procedure localProcedure = this.staticLink.$Eq;
      Object localObject = this.a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.b;
      return srfi1.lsetDiff$PlIntersection$Ex$V(localProcedure, localObject, arrayOfObject);
    }

    Object lambda68(Object paramObject1, Object paramObject2)
    {
      srfi1.frame50 localframe50 = new srfi1.frame50();
      localframe50.staticLink = this;
      localframe50.a$Mnint$Mnb = paramObject2;
      if (lists.isNull(paramObject1))
      {
        Procedure localProcedure = this.staticLink.$Eq;
        Object localObject = this.b;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.a;
        return srfi1.lsetDifference$Ex$V(localProcedure, localObject, arrayOfObject2);
      }
      if (lists.isNull(localframe50.a$Mnint$Mnb))
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = this.b;
        arrayOfObject1[1] = this.a;
        return srfi1.append$Ex$V(arrayOfObject1);
      }
      return srfi1.pairFold$V(localframe50.lambda$Fn52, paramObject1, this.b, new Object[0]);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 50)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 51)
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

  public class frame5 extends ModuleBody
  {
    public static Object lambda11recur(Object paramObject)
    {
      srfi1.frame6 localframe6 = new srfi1.frame6();
      localframe6.lis = paramObject;
      if (srfi1.isNullList(localframe6.lis) != Boolean.FALSE)
      {
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = localframe6.lis;
        arrayOfObject[1] = localframe6.lis;
        arrayOfObject[2] = localframe6.lis;
        arrayOfObject[3] = localframe6.lis;
        arrayOfObject[4] = localframe6.lis;
        return misc.values(arrayOfObject);
      }
      localframe6.elt = lists.car.apply1(localframe6.lis);
      return call_with_values.callWithValues(localframe6.lambda$Fn7, localframe6.lambda$Fn8);
    }
  }

  public class frame50 extends ModuleBody
  {
    Object a$Mnint$Mnb;
    final ModuleMethod lambda$Fn52;
    srfi1.frame49 staticLink;

    public frame50()
    {
      this$1 = new ModuleMethod(this, 49, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:1568");
      this.lambda$Fn52 = this$1;
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 49)
        return lambda69(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda69(Object paramObject1, Object paramObject2)
    {
      if (lists.member(lists.car.apply1(paramObject1), this.a$Mnint$Mnb, this.staticLink.staticLink.$Eq) != Boolean.FALSE)
        return paramObject2;
      try
      {
        Pair localPair = (Pair)paramObject1;
        lists.setCdr$Ex(localPair, paramObject2);
        return paramObject1;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "set-cdr!", 1, paramObject1);
      }
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 49)
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

  public class frame51 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn53;
    LList lists;

    public frame51()
    {
      this$1 = new ModuleMethod(this, 54, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1579");
      this.lambda$Fn53 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 54)
      {
        if (lambda70(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda70(Object paramObject)
    {
      srfi1.frame52 localframe52 = new srfi1.frame52();
      localframe52.staticLink = this;
      localframe52.elt = paramObject;
      if (srfi1.any$V(localframe52.lambda$Fn54, this.lists, new Object[0]) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 54)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame52 extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn54;
    srfi1.frame51 staticLink;

    public frame52()
    {
      this$1 = new ModuleMethod(this, 53, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1580");
      this.lambda$Fn54 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 53)
        return lambda71(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda71(Object paramObject)
    {
      return lists.member(this.elt, paramObject, this.staticLink.$Eq);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 53)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame53 extends ModuleBody
  {
    Procedure $Eq;
    final ModuleMethod lambda$Fn55;
    LList lists;

    public frame53()
    {
      this$1 = new ModuleMethod(this, 56, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1587");
      this.lambda$Fn55 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 56)
      {
        if (lambda72(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda72(Object paramObject)
    {
      srfi1.frame54 localframe54 = new srfi1.frame54();
      localframe54.staticLink = this;
      localframe54.elt = paramObject;
      if (srfi1.any$V(localframe54.lambda$Fn56, this.lists, new Object[0]) != Boolean.FALSE);
      for (int i = 1; ; i = 0)
        return 0x1 & i + 1;
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 56)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame54 extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn56;
    srfi1.frame53 staticLink;

    public frame54()
    {
      this$1 = new ModuleMethod(this, 55, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1588");
      this.lambda$Fn56 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 55)
        return lambda73(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda73(Object paramObject)
    {
      return lists.member(this.elt, paramObject, this.staticLink.$Eq);
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 55)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame55 extends ModuleBody
  {
    Continuation abort;

    public Object lambda74recur(Object paramObject)
    {
      if (lists.isPair(paramObject))
      {
        Object localObject = lists.car.apply1(paramObject);
        if (srfi1.isNullList(localObject) != Boolean.FALSE)
          return this.abort.apply1(LList.Empty);
        return lists.cons(lists.cdr.apply1(localObject), lambda74recur(lists.cdr.apply1(paramObject)));
      }
      return LList.Empty;
    }
  }

  public class frame56 extends ModuleBody
  {
    Object last$Mnelt;

    public Object lambda75recur(Object paramObject)
    {
      if (lists.isPair(paramObject))
        return lists.cons(lists.caar.apply1(paramObject), lambda75recur(lists.cdr.apply1(paramObject)));
      return LList.list1(this.last$Mnelt);
    }
  }

  public class frame57 extends ModuleBody
  {
    Continuation abort;

    public Object lambda76recur(Object paramObject)
    {
      srfi1.frame58 localframe58 = new srfi1.frame58();
      localframe58.staticLink = this;
      localframe58.lists = paramObject;
      if (lists.isPair(localframe58.lists))
        return call_with_values.callWithValues(localframe58.lambda$Fn57, localframe58.lambda$Fn58);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = LList.Empty;
      arrayOfObject[1] = LList.Empty;
      return misc.values(arrayOfObject);
    }
  }

  public class frame58 extends ModuleBody
  {
    final ModuleMethod lambda$Fn57 = new ModuleMethod(this, 61, null, 0);
    final ModuleMethod lambda$Fn58;
    Object lists;
    srfi1.frame57 staticLink;

    public frame58()
    {
      this$1 = new ModuleMethod(this, 62, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:762");
      this.lambda$Fn58 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 61)
        return lambda77();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 62)
        return lambda78(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda77()
    {
      return srfi1.car$PlCdr(this.lists);
    }

    Object lambda78(Object paramObject1, Object paramObject2)
    {
      srfi1.frame59 localframe59 = new srfi1.frame59();
      localframe59.staticLink = this;
      localframe59.list = paramObject1;
      localframe59.other$Mnlists = paramObject2;
      if (srfi1.isNullList(localframe59.list) != Boolean.FALSE)
        return this.staticLink.abort.apply2(LList.Empty, LList.Empty);
      return call_with_values.callWithValues(localframe59.lambda$Fn59, localframe59.lambda$Fn60);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 61)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 62)
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

  public class frame59 extends ModuleBody
  {
    final ModuleMethod lambda$Fn59 = new ModuleMethod(this, 59, null, 0);
    final ModuleMethod lambda$Fn60;
    Object list;
    Object other$Mnlists;
    srfi1.frame58 staticLink;

    public frame59()
    {
      this$1 = new ModuleMethod(this, 60, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:764");
      this.lambda$Fn60 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 59)
        return lambda79();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 60)
        return lambda80(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda79()
    {
      return srfi1.car$PlCdr(this.list);
    }

    Object lambda80(Object paramObject1, Object paramObject2)
    {
      srfi1.frame60 localframe60 = new srfi1.frame60();
      localframe60.staticLink = this;
      localframe60.a = paramObject1;
      localframe60.d = paramObject2;
      return call_with_values.callWithValues(localframe60.lambda$Fn61, localframe60.lambda$Fn62);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 59)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 60)
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

  public class frame6 extends ModuleBody
  {
    Object elt;
    final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 7, null, 0);
    final ModuleMethod lambda$Fn8;
    Object lis;

    public frame6()
    {
      this$1 = new ModuleMethod(this, 8, null, 20485);
      this$1.setProperty("source-location", "srfi1.scm:654");
      this.lambda$Fn8 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 7)
        return lambda12();
      return super.apply0(paramModuleMethod);
    }

    public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    {
      if (paramModuleMethod.selector == 8)
        return lambda13(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3], paramArrayOfObject[4]);
      return super.applyN(paramModuleMethod, paramArrayOfObject);
    }

    Object lambda12()
    {
      return srfi1.frame5.lambda11recur(lists.cdr.apply1(this.lis));
    }

    Object lambda13(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
    {
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = lists.cons(lists.car.apply1(this.elt), paramObject1);
      arrayOfObject[1] = lists.cons(lists.cadr.apply1(this.elt), paramObject2);
      arrayOfObject[2] = lists.cons(lists.caddr.apply1(this.elt), paramObject3);
      arrayOfObject[3] = lists.cons(lists.cadddr.apply1(this.elt), paramObject4);
      arrayOfObject[4] = lists.cons(lists.car.apply1(lists.cddddr.apply1(this.elt)), paramObject5);
      return misc.values(arrayOfObject);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 7)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 8)
      {
        paramCallContext.values = paramArrayOfObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 5;
        return 0;
      }
      return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
  }

  public class frame60 extends ModuleBody
  {
    Object a;
    Object d;
    final ModuleMethod lambda$Fn61 = new ModuleMethod(this, 57, null, 0);
    final ModuleMethod lambda$Fn62;
    srfi1.frame59 staticLink;

    public frame60()
    {
      this$1 = new ModuleMethod(this, 58, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:765");
      this.lambda$Fn62 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 57)
        return lambda81();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 58)
        return lambda82(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda81()
    {
      return this.staticLink.staticLink.staticLink.lambda76recur(this.staticLink.other$Mnlists);
    }

    Object lambda82(Object paramObject1, Object paramObject2)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = lists.cons(this.a, paramObject1);
      arrayOfObject[1] = lists.cons(this.d, paramObject2);
      return misc.values(arrayOfObject);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 57)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 58)
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

  public class frame61 extends ModuleBody
  {
    final ModuleMethod lambda$Fn63 = new ModuleMethod(this, 63, null, 0);
    Object lists;

    static Pair lambda84(Object paramObject1, Object paramObject2)
    {
      return lists.cons(paramObject1, paramObject2);
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 63)
        return lambda83();
      return super.apply0(paramModuleMethod);
    }

    Object lambda83()
    {
      return srfi1.$PcCars$PlCdrs(this.lists);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 63)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
  }

  public class frame62 extends ModuleBody
  {
    Object cars$Mnfinal;
  }

  public class frame63 extends ModuleBody
  {
    Continuation abort;
    srfi1.frame62 staticLink;

    public Object lambda85recur(Object paramObject)
    {
      srfi1.frame64 localframe64 = new srfi1.frame64();
      localframe64.staticLink = this;
      localframe64.lists = paramObject;
      if (lists.isPair(localframe64.lists))
        return call_with_values.callWithValues(localframe64.lambda$Fn65, localframe64.lambda$Fn66);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = LList.list1(this.staticLink.cars$Mnfinal);
      arrayOfObject[1] = LList.Empty;
      return misc.values(arrayOfObject);
    }
  }

  public class frame64 extends ModuleBody
  {
    final ModuleMethod lambda$Fn65 = new ModuleMethod(this, 68, null, 0);
    final ModuleMethod lambda$Fn66;
    Object lists;
    srfi1.frame63 staticLink;

    public frame64()
    {
      this$1 = new ModuleMethod(this, 69, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:783");
      this.lambda$Fn66 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 68)
        return lambda86();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 69)
        return lambda87(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda86()
    {
      return srfi1.car$PlCdr(this.lists);
    }

    Object lambda87(Object paramObject1, Object paramObject2)
    {
      srfi1.frame65 localframe65 = new srfi1.frame65();
      localframe65.staticLink = this;
      localframe65.list = paramObject1;
      localframe65.other$Mnlists = paramObject2;
      if (srfi1.isNullList(localframe65.list) != Boolean.FALSE)
        return this.staticLink.abort.apply2(LList.Empty, LList.Empty);
      return call_with_values.callWithValues(localframe65.lambda$Fn67, localframe65.lambda$Fn68);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 68)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 69)
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

  public class frame65 extends ModuleBody
  {
    final ModuleMethod lambda$Fn67 = new ModuleMethod(this, 66, null, 0);
    final ModuleMethod lambda$Fn68;
    Object list;
    Object other$Mnlists;
    srfi1.frame64 staticLink;

    public frame65()
    {
      this$1 = new ModuleMethod(this, 67, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:785");
      this.lambda$Fn68 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 66)
        return lambda88();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 67)
        return lambda89(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda88()
    {
      return srfi1.car$PlCdr(this.list);
    }

    Object lambda89(Object paramObject1, Object paramObject2)
    {
      srfi1.frame66 localframe66 = new srfi1.frame66();
      localframe66.staticLink = this;
      localframe66.a = paramObject1;
      localframe66.d = paramObject2;
      return call_with_values.callWithValues(localframe66.lambda$Fn69, localframe66.lambda$Fn70);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 66)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 67)
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

  public class frame66 extends ModuleBody
  {
    Object a;
    Object d;
    final ModuleMethod lambda$Fn69 = new ModuleMethod(this, 64, null, 0);
    final ModuleMethod lambda$Fn70;
    srfi1.frame65 staticLink;

    public frame66()
    {
      this$1 = new ModuleMethod(this, 65, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:786");
      this.lambda$Fn70 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 64)
        return lambda90();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 65)
        return lambda91(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda90()
    {
      return this.staticLink.staticLink.staticLink.lambda85recur(this.staticLink.other$Mnlists);
    }

    Object lambda91(Object paramObject1, Object paramObject2)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = lists.cons(this.a, paramObject1);
      arrayOfObject[1] = lists.cons(this.d, paramObject2);
      return misc.values(arrayOfObject);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 64)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 65)
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

  public class frame67 extends ModuleBody
  {
    public static Object lambda92recur(Object paramObject)
    {
      srfi1.frame68 localframe68 = new srfi1.frame68();
      localframe68.lists = paramObject;
      if (lists.isPair(localframe68.lists))
        return call_with_values.callWithValues(localframe68.lambda$Fn71, localframe68.lambda$Fn72);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = LList.Empty;
      arrayOfObject[1] = LList.Empty;
      return misc.values(arrayOfObject);
    }
  }

  public class frame68 extends ModuleBody
  {
    final ModuleMethod lambda$Fn71 = new ModuleMethod(this, 74, null, 0);
    final ModuleMethod lambda$Fn72;
    Object lists;

    public frame68()
    {
      this$1 = new ModuleMethod(this, 75, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:794");
      this.lambda$Fn72 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 74)
        return lambda93();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 75)
        return lambda94(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda93()
    {
      return srfi1.car$PlCdr(this.lists);
    }

    Object lambda94(Object paramObject1, Object paramObject2)
    {
      srfi1.frame69 localframe69 = new srfi1.frame69();
      localframe69.staticLink = this;
      localframe69.list = paramObject1;
      localframe69.other$Mnlists = paramObject2;
      return call_with_values.callWithValues(localframe69.lambda$Fn73, localframe69.lambda$Fn74);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 74)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 75)
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

  public class frame69 extends ModuleBody
  {
    final ModuleMethod lambda$Fn73 = new ModuleMethod(this, 72, null, 0);
    final ModuleMethod lambda$Fn74;
    Object list;
    Object other$Mnlists;
    srfi1.frame68 staticLink;

    public frame69()
    {
      this$1 = new ModuleMethod(this, 73, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:795");
      this.lambda$Fn74 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 72)
        return lambda95();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 73)
        return lambda96(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda95()
    {
      return srfi1.car$PlCdr(this.list);
    }

    Object lambda96(Object paramObject1, Object paramObject2)
    {
      srfi1.frame70 localframe70 = new srfi1.frame70();
      localframe70.staticLink = this;
      localframe70.a = paramObject1;
      localframe70.d = paramObject2;
      return call_with_values.callWithValues(localframe70.lambda$Fn75, localframe70.lambda$Fn76);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 72)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 73)
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

  public class frame7 extends ModuleBody
  {
    Procedure kons;

    public Object lambda14lp(Object paramObject1, Object paramObject2)
    {
      srfi1.frame8 localframe8 = new srfi1.frame8();
      localframe8.staticLink = this;
      localframe8.lists = paramObject1;
      localframe8.ans = paramObject2;
      return call_with_values.callWithValues(localframe8.lambda$Fn9, localframe8.lambda$Fn10);
    }
  }

  public class frame70 extends ModuleBody
  {
    Object a;
    Object d;
    final ModuleMethod lambda$Fn75 = new ModuleMethod(this, 70, null, 0);
    final ModuleMethod lambda$Fn76;
    srfi1.frame69 staticLink;

    public frame70()
    {
      this$1 = new ModuleMethod(this, 71, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:796");
      this.lambda$Fn76 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 70)
        return lambda97();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 71)
        return lambda98(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda97()
    {
      return srfi1.frame67.lambda92recur(this.staticLink.other$Mnlists);
    }

    Object lambda98(Object paramObject1, Object paramObject2)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = lists.cons(this.a, paramObject1);
      arrayOfObject[1] = lists.cons(this.d, paramObject2);
      return misc.values(arrayOfObject);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 70)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 71)
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

  public class frame71 extends ModuleBody
  {
    final ModuleMethod lambda$Fn77 = new ModuleMethod(this, 76, null, 0);
    Object lists;

    static Pair lambda100(Object paramObject1, Object paramObject2)
    {
      return lists.cons(paramObject1, paramObject2);
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 76)
        return lambda99();
      return super.apply0(paramModuleMethod);
    }

    Object lambda99()
    {
      return srfi1.$PcCars$PlCdrs$SlNoTest(this.lists);
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 76)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }
  }

  public class frame72 extends ModuleBody
  {
    Object $Eq;
    final ModuleMethod lambda$Fn79;
    Object lis2;

    public frame72()
    {
      this$1 = new ModuleMethod(this, 77, null, 4097);
      this$1.setProperty("source-location", "srfi1.scm:1443");
      this.lambda$Fn79 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 77)
        return lambda101(paramObject);
      return super.apply1(paramModuleMethod, paramObject);
    }

    Object lambda101(Object paramObject)
    {
      Object localObject1 = this.lis2;
      Object localObject2 = this.$Eq;
      try
      {
        Procedure localProcedure = (Procedure)localObject2;
        return lists.member(paramObject, localObject1, localProcedure);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "member", 3, localObject2);
      }
    }

    public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 77)
      {
        paramCallContext.value1 = paramObject;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 1;
        return 0;
      }
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
  }

  public class frame8 extends ModuleBody
  {
    Object ans;
    final ModuleMethod lambda$Fn10;
    final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 9, null, 0);
    Object lists;
    srfi1.frame7 staticLink;

    public frame8()
    {
      this$1 = new ModuleMethod(this, 10, null, 8194);
      this$1.setProperty("source-location", "srfi1.scm:859");
      this.lambda$Fn10 = this$1;
    }

    public Object apply0(ModuleMethod paramModuleMethod)
    {
      if (paramModuleMethod.selector == 9)
        return lambda15();
      return super.apply0(paramModuleMethod);
    }

    public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    {
      if (paramModuleMethod.selector == 10)
        return lambda16(paramObject1, paramObject2);
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    }

    Object lambda15()
    {
      return srfi1.$PcCars$PlCdrs$Pl(this.lists, this.ans);
    }

    Object lambda16(Object paramObject1, Object paramObject2)
    {
      if (lists.isNull(paramObject1))
        return this.ans;
      return this.staticLink.lambda14lp(paramObject2, Scheme.apply.apply2(this.staticLink.kons, paramObject1));
    }

    public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 9)
      {
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 0;
        return 0;
      }
      return super.match0(paramModuleMethod, paramCallContext);
    }

    public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
    {
      if (paramModuleMethod.selector == 10)
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

  public class frame9 extends ModuleBody
  {
    Object knil;
    Procedure kons;

    public Object lambda17recur(Object paramObject)
    {
      Object localObject = srfi1.$PcCdrs(paramObject);
      if (lists.isNull(localObject))
        return this.knil;
      return Scheme.apply.apply2(this.kons, srfi1.$PcCars$Pl(paramObject, lambda17recur(localObject)));
    }

    public Object lambda18recur(Object paramObject)
    {
      if (srfi1.isNullList(paramObject) != Boolean.FALSE)
        return this.knil;
      Object localObject = lists.car.apply1(paramObject);
      return this.kons.apply2(localObject, lambda18recur(lists.cdr.apply1(paramObject)));
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.srfi1
 * JD-Core Version:    0.6.2
 */