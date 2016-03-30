package kawa.lib.rnrs;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.util.HashNode;
import gnu.lists.FVector;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import kawa.lib.kawa.hashtable;
import kawa.lib.kawa.hashtable.HashTable;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class hashtables extends ModuleBody
{
  public static final hashtables $instance;
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
  static final SimpleSymbol Lit22 = (SimpleSymbol)new SimpleSymbol("symbol-hash").readResolve();
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod equal$Mnhash;
  static final ModuleMethod hash$Mnby$Mnidentity;
  static final ModuleMethod hash$Mnfor$Mneqv;
  public static final ModuleMethod hashtable$Mnclear$Ex;
  public static final ModuleMethod hashtable$Mncontains$Qu;
  public static final ModuleMethod hashtable$Mncopy;
  public static final ModuleMethod hashtable$Mndelete$Ex;
  public static final ModuleMethod hashtable$Mnentries;
  public static final ModuleMethod hashtable$Mnequivalence$Mnfunction;
  public static final ModuleMethod hashtable$Mnhash$Mnfunction;
  public static final ModuleMethod hashtable$Mnkeys;
  public static final ModuleMethod hashtable$Mnmutable$Qu;
  public static final ModuleMethod hashtable$Mnref;
  public static final ModuleMethod hashtable$Mnset$Ex;
  public static final ModuleMethod hashtable$Mnsize;
  public static final ModuleMethod hashtable$Mnupdate$Ex;
  public static final ModuleMethod hashtable$Qu;
  public static final ModuleMethod make$Mneq$Mnhashtable;
  public static final ModuleMethod make$Mneqv$Mnhashtable;
  public static final ModuleMethod make$Mnhashtable;
  public static final ModuleMethod string$Mnci$Mnhash;
  public static final ModuleMethod string$Mnhash;
  public static final ModuleMethod symbol$Mnhash;

  static
  {
    Lit21 = (SimpleSymbol)new SimpleSymbol("string-ci-hash").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("string-hash").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("equal-hash").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("hashtable-mutable?").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("hashtable-hash-function").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("hashtable-equivalence-function").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("hashtable-entries").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("hashtable-keys").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("hashtable-clear!").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("hashtable-copy").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("hashtable-update!").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("hashtable-contains?").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("hashtable-delete!").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("hashtable-set!").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("hashtable-ref").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("hashtable-size").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("hashtable?").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("make-hashtable").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("make-eqv-hashtable").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("make-eq-hashtable").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("hash-for-eqv").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("hash-by-identity").readResolve();
    $instance = new hashtables();
    hashtables localhashtables = $instance;
    hash$Mnby$Mnidentity = new ModuleMethod(localhashtables, 1, Lit0, 4097);
    hash$Mnfor$Mneqv = new ModuleMethod(localhashtables, 2, Lit1, 4097);
    make$Mneq$Mnhashtable = new ModuleMethod(localhashtables, 3, Lit2, 4096);
    make$Mneqv$Mnhashtable = new ModuleMethod(localhashtables, 5, Lit3, 4096);
    make$Mnhashtable = new ModuleMethod(localhashtables, 7, Lit4, 12290);
    hashtable$Qu = new ModuleMethod(localhashtables, 9, Lit5, 4097);
    hashtable$Mnsize = new ModuleMethod(localhashtables, 10, Lit6, 4097);
    hashtable$Mnref = new ModuleMethod(localhashtables, 11, Lit7, 12291);
    hashtable$Mnset$Ex = new ModuleMethod(localhashtables, 12, Lit8, 12291);
    hashtable$Mndelete$Ex = new ModuleMethod(localhashtables, 13, Lit9, 8194);
    hashtable$Mncontains$Qu = new ModuleMethod(localhashtables, 14, Lit10, 8194);
    hashtable$Mnupdate$Ex = new ModuleMethod(localhashtables, 15, Lit11, 16388);
    hashtable$Mncopy = new ModuleMethod(localhashtables, 16, Lit12, 8193);
    hashtable$Mnclear$Ex = new ModuleMethod(localhashtables, 18, Lit13, 8193);
    hashtable$Mnkeys = new ModuleMethod(localhashtables, 20, Lit14, 4097);
    hashtable$Mnentries = new ModuleMethod(localhashtables, 21, Lit15, 4097);
    hashtable$Mnequivalence$Mnfunction = new ModuleMethod(localhashtables, 22, Lit16, 4097);
    hashtable$Mnhash$Mnfunction = new ModuleMethod(localhashtables, 23, Lit17, 4097);
    hashtable$Mnmutable$Qu = new ModuleMethod(localhashtables, 24, Lit18, 4097);
    equal$Mnhash = new ModuleMethod(localhashtables, 25, Lit19, 4097);
    string$Mnhash = new ModuleMethod(localhashtables, 26, Lit20, 4097);
    string$Mnci$Mnhash = new ModuleMethod(localhashtables, 27, Lit21, 4097);
    symbol$Mnhash = new ModuleMethod(localhashtables, 28, Lit22, 4097);
    $instance.run();
  }

  public hashtables()
  {
    ModuleInfo.register(this);
  }

  public static int equalHash(Object paramObject)
  {
    return paramObject.hashCode();
  }

  static int hashByIdentity(Object paramObject)
  {
    return System.identityHashCode(paramObject);
  }

  static int hashForEqv(Object paramObject)
  {
    return paramObject.hashCode();
  }

  public static void hashtableClear$Ex(hashtable.HashTable paramHashTable)
  {
    hashtableClear$Ex(paramHashTable, 64);
  }

  public static void hashtableClear$Ex(hashtable.HashTable paramHashTable, int paramInt)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    paramHashTable.clear();
  }

  public static hashtable.HashTable hashtableCopy(hashtable.HashTable paramHashTable)
  {
    return hashtableCopy(paramHashTable, false);
  }

  public static hashtable.HashTable hashtableCopy(hashtable.HashTable paramHashTable, boolean paramBoolean)
  {
    return new hashtable.HashTable(paramHashTable, paramBoolean);
  }

  public static void hashtableDelete$Ex(hashtable.HashTable paramHashTable, Object paramObject)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    paramHashTable.remove(paramObject);
  }

  public static Object hashtableEntries(hashtable.HashTable paramHashTable)
  {
    Pair localPair = paramHashTable.entriesVectorPair();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = lists.car.apply1(localPair);
    arrayOfObject[1] = lists.cdr.apply1(localPair);
    return misc.values(arrayOfObject);
  }

  public static Procedure hashtableEquivalenceFunction(hashtable.HashTable paramHashTable)
  {
    return (Procedure)paramHashTable.equivalenceFunction.apply1(paramHashTable);
  }

  public static Object hashtableHashFunction(hashtable.HashTable paramHashTable)
  {
    Object localObject1 = paramHashTable.hashFunction.apply1(paramHashTable);
    Object localObject2 = Scheme.isEqv.apply2(localObject1, hash$Mnby$Mnidentity);
    if (localObject2 != Boolean.FALSE)
    {
      if (localObject2 == Boolean.FALSE);
    }
    else
      while (Scheme.isEqv.apply2(localObject1, hash$Mnfor$Mneqv) != Boolean.FALSE)
        return Boolean.FALSE;
    return localObject1;
  }

  public static FVector hashtableKeys(hashtable.HashTable paramHashTable)
  {
    return paramHashTable.keysVector();
  }

  public static Object hashtableRef(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    HashNode localHashNode = paramHashTable.getNode(paramObject1);
    if (localHashNode == null)
      return paramObject2;
    return localHashNode.getValue();
  }

  public static void hashtableSet$Ex(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    paramHashTable.put(paramObject1, paramObject2);
  }

  public static int hashtableSize(hashtable.HashTable paramHashTable)
  {
    return paramHashTable.size();
  }

  public static Object hashtableUpdate$Ex(hashtable.HashTable paramHashTable, Object paramObject1, Procedure paramProcedure, Object paramObject2)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    HashNode localHashNode = paramHashTable.getNode(paramObject1);
    if (localHashNode == null)
    {
      hashtableSet$Ex(paramHashTable, paramObject1, paramProcedure.apply1(paramObject2));
      return Values.empty;
    }
    return localHashNode.setValue(paramProcedure.apply1(localHashNode.getValue()));
  }

  public static boolean isHashtable(Object paramObject)
  {
    return paramObject instanceof hashtable.HashTable;
  }

  public static boolean isHashtableContains(hashtable.HashTable paramHashTable, Object paramObject)
  {
    if (paramHashTable.getNode(paramObject) == null);
    for (int i = 1; ; i = 0)
      return 0x1 & i + 1;
  }

  public static Object isHashtableMutable(hashtable.HashTable paramHashTable)
  {
    ApplyToArgs localApplyToArgs = Scheme.applyToArgs;
    if (paramHashTable.mutable);
    for (Boolean localBoolean = Boolean.TRUE; ; localBoolean = Boolean.FALSE)
      return localApplyToArgs.apply1(localBoolean);
  }

  public static hashtable.HashTable makeEqHashtable()
  {
    return makeEqHashtable(AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }

  public static hashtable.HashTable makeEqHashtable(int paramInt)
  {
    return new hashtable.HashTable(Scheme.isEq, hash$Mnby$Mnidentity, AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }

  public static hashtable.HashTable makeEqvHashtable()
  {
    return makeEqvHashtable(AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }

  public static hashtable.HashTable makeEqvHashtable(int paramInt)
  {
    return new hashtable.HashTable(Scheme.isEqv, hash$Mnfor$Mneqv, AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }

  public static hashtable.HashTable makeHashtable(Procedure paramProcedure1, Procedure paramProcedure2)
  {
    return makeHashtable(paramProcedure1, paramProcedure2, AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }

  public static hashtable.HashTable makeHashtable(Procedure paramProcedure1, Procedure paramProcedure2, int paramInt)
  {
    return new hashtable.HashTable(paramProcedure1, paramProcedure2, paramInt);
  }

  public static int stringCiHash(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString().toLowerCase().hashCode();
  }

  public static int stringHash(CharSequence paramCharSequence)
  {
    return paramCharSequence.hashCode();
  }

  public static int symbolHash(Symbol paramSymbol)
  {
    return paramSymbol.hashCode();
  }

  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    case 4:
    default:
      return super.apply0(paramModuleMethod);
    case 3:
      return makeEqHashtable();
    case 5:
    }
    return makeEqvHashtable();
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+128 -> 132, 1:+135->139, 2:+143->147, 3:+151->155, 4:+128->132, 5:+166->170, 6:+128->132, 7:+128->132, 8:+128->132, 9:+181->185, 10:+196->200, 11:+128->132, 12:+128->132, 13:+128->132, 14:+128->132, 15:+128->132, 16:+211->215, 17:+128->132, 18:+223->227, 19:+128->132, 20:+238->242, 21:+250->254, 22:+262->266, 23:+274->278, 24:+286->290, 25:+298->302, 26:+306->310, 27:+321->325, 28:+336->340
    //   133: aload_1
    //   134: aload_2
    //   135: invokespecial 438	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   138: areturn
    //   139: aload_2
    //   140: invokestatic 440	kawa/lib/rnrs/hashtables:hashByIdentity	(Ljava/lang/Object;)I
    //   143: invokestatic 446	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: areturn
    //   147: aload_2
    //   148: invokestatic 448	kawa/lib/rnrs/hashtables:hashForEqv	(Ljava/lang/Object;)I
    //   151: invokestatic 446	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: areturn
    //   155: aload_2
    //   156: checkcast 450	java/lang/Number
    //   159: invokevirtual 453	java/lang/Number:intValue	()I
    //   162: istore 28
    //   164: iload 28
    //   166: invokestatic 386	kawa/lib/rnrs/hashtables:makeEqHashtable	(I)Lkawa/lib/kawa/hashtable$HashTable;
    //   169: areturn
    //   170: aload_2
    //   171: checkcast 450	java/lang/Number
    //   174: invokevirtual 453	java/lang/Number:intValue	()I
    //   177: istore 26
    //   179: iload 26
    //   181: invokestatic 396	kawa/lib/rnrs/hashtables:makeEqvHashtable	(I)Lkawa/lib/kawa/hashtable$HashTable;
    //   184: areturn
    //   185: aload_2
    //   186: invokestatic 455	kawa/lib/rnrs/hashtables:isHashtable	(Ljava/lang/Object;)Z
    //   189: ifeq +7 -> 196
    //   192: getstatic 375	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   195: areturn
    //   196: getstatic 319	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   199: areturn
    //   200: aload_2
    //   201: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   204: astore 24
    //   206: aload 24
    //   208: invokestatic 457	kawa/lib/rnrs/hashtables:hashtableSize	(Lkawa/lib/kawa/hashtable$HashTable;)I
    //   211: invokestatic 446	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: areturn
    //   215: aload_2
    //   216: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   219: astore 22
    //   221: aload 22
    //   223: invokestatic 459	kawa/lib/rnrs/hashtables:hashtableCopy	(Lkawa/lib/kawa/hashtable$HashTable;)Lkawa/lib/kawa/hashtable$HashTable;
    //   226: areturn
    //   227: aload_2
    //   228: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   231: astore 20
    //   233: aload 20
    //   235: invokestatic 461	kawa/lib/rnrs/hashtables:hashtableClear$Ex	(Lkawa/lib/kawa/hashtable$HashTable;)V
    //   238: getstatic 356	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   241: areturn
    //   242: aload_2
    //   243: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   246: astore 18
    //   248: aload 18
    //   250: invokestatic 463	kawa/lib/rnrs/hashtables:hashtableKeys	(Lkawa/lib/kawa/hashtable$HashTable;)Lgnu/lists/FVector;
    //   253: areturn
    //   254: aload_2
    //   255: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   258: astore 16
    //   260: aload 16
    //   262: invokestatic 465	kawa/lib/rnrs/hashtables:hashtableEntries	(Lkawa/lib/kawa/hashtable$HashTable;)Ljava/lang/Object;
    //   265: areturn
    //   266: aload_2
    //   267: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   270: astore 14
    //   272: aload 14
    //   274: invokestatic 467	kawa/lib/rnrs/hashtables:hashtableEquivalenceFunction	(Lkawa/lib/kawa/hashtable$HashTable;)Lgnu/mapping/Procedure;
    //   277: areturn
    //   278: aload_2
    //   279: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   282: astore 12
    //   284: aload 12
    //   286: invokestatic 469	kawa/lib/rnrs/hashtables:hashtableHashFunction	(Lkawa/lib/kawa/hashtable$HashTable;)Ljava/lang/Object;
    //   289: areturn
    //   290: aload_2
    //   291: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   294: astore 10
    //   296: aload 10
    //   298: invokestatic 471	kawa/lib/rnrs/hashtables:isHashtableMutable	(Lkawa/lib/kawa/hashtable$HashTable;)Ljava/lang/Object;
    //   301: areturn
    //   302: aload_2
    //   303: invokestatic 473	kawa/lib/rnrs/hashtables:equalHash	(Ljava/lang/Object;)I
    //   306: invokestatic 446	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: areturn
    //   310: aload_2
    //   311: checkcast 405	java/lang/CharSequence
    //   314: astore 8
    //   316: aload 8
    //   318: invokestatic 475	kawa/lib/rnrs/hashtables:stringHash	(Ljava/lang/CharSequence;)I
    //   321: invokestatic 446	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: areturn
    //   325: aload_2
    //   326: checkcast 405	java/lang/CharSequence
    //   329: astore 6
    //   331: aload 6
    //   333: invokestatic 477	kawa/lib/rnrs/hashtables:stringCiHash	(Ljava/lang/CharSequence;)I
    //   336: invokestatic 446	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: areturn
    //   340: aload_2
    //   341: checkcast 421	gnu/mapping/Symbol
    //   344: astore 4
    //   346: aload 4
    //   348: invokestatic 479	kawa/lib/rnrs/hashtables:symbolHash	(Lgnu/mapping/Symbol;)I
    //   351: invokestatic 446	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   354: areturn
    //   355: astore 27
    //   357: new 481	gnu/mapping/WrongType
    //   360: dup
    //   361: aload 27
    //   363: ldc 148
    //   365: iconst_1
    //   366: aload_2
    //   367: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   370: athrow
    //   371: astore 25
    //   373: new 481	gnu/mapping/WrongType
    //   376: dup
    //   377: aload 25
    //   379: ldc 144
    //   381: iconst_1
    //   382: aload_2
    //   383: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   386: athrow
    //   387: astore 23
    //   389: new 481	gnu/mapping/WrongType
    //   392: dup
    //   393: aload 23
    //   395: ldc 132
    //   397: iconst_1
    //   398: aload_2
    //   399: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   402: athrow
    //   403: astore 21
    //   405: new 481	gnu/mapping/WrongType
    //   408: dup
    //   409: aload 21
    //   411: ldc 108
    //   413: iconst_1
    //   414: aload_2
    //   415: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   418: athrow
    //   419: astore 19
    //   421: new 481	gnu/mapping/WrongType
    //   424: dup
    //   425: aload 19
    //   427: ldc 104
    //   429: iconst_1
    //   430: aload_2
    //   431: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   434: athrow
    //   435: astore 17
    //   437: new 481	gnu/mapping/WrongType
    //   440: dup
    //   441: aload 17
    //   443: ldc 100
    //   445: iconst_1
    //   446: aload_2
    //   447: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   450: athrow
    //   451: astore 15
    //   453: new 481	gnu/mapping/WrongType
    //   456: dup
    //   457: aload 15
    //   459: ldc 96
    //   461: iconst_1
    //   462: aload_2
    //   463: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   466: athrow
    //   467: astore 13
    //   469: new 481	gnu/mapping/WrongType
    //   472: dup
    //   473: aload 13
    //   475: ldc 92
    //   477: iconst_1
    //   478: aload_2
    //   479: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   482: athrow
    //   483: astore 11
    //   485: new 481	gnu/mapping/WrongType
    //   488: dup
    //   489: aload 11
    //   491: ldc 88
    //   493: iconst_1
    //   494: aload_2
    //   495: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   498: athrow
    //   499: astore 9
    //   501: new 481	gnu/mapping/WrongType
    //   504: dup
    //   505: aload 9
    //   507: ldc 84
    //   509: iconst_1
    //   510: aload_2
    //   511: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   514: athrow
    //   515: astore 7
    //   517: new 481	gnu/mapping/WrongType
    //   520: dup
    //   521: aload 7
    //   523: ldc 76
    //   525: iconst_1
    //   526: aload_2
    //   527: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   530: athrow
    //   531: astore 5
    //   533: new 481	gnu/mapping/WrongType
    //   536: dup
    //   537: aload 5
    //   539: ldc 72
    //   541: iconst_1
    //   542: aload_2
    //   543: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   546: athrow
    //   547: astore_3
    //   548: new 481	gnu/mapping/WrongType
    //   551: dup
    //   552: aload_3
    //   553: ldc 60
    //   555: iconst_1
    //   556: aload_2
    //   557: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   560: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   155	164	355	java/lang/ClassCastException
    //   170	179	371	java/lang/ClassCastException
    //   200	206	387	java/lang/ClassCastException
    //   215	221	403	java/lang/ClassCastException
    //   227	233	419	java/lang/ClassCastException
    //   242	248	435	java/lang/ClassCastException
    //   254	260	451	java/lang/ClassCastException
    //   266	272	467	java/lang/ClassCastException
    //   278	284	483	java/lang/ClassCastException
    //   290	296	499	java/lang/ClassCastException
    //   310	316	515	java/lang/ClassCastException
    //   325	331	531	java/lang/ClassCastException
    //   340	346	547	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+52->56, 7:+60->64, 13:+80->84, 14:+96->100, 16:+119->123, 18:+153->157
    //   57: aload_1
    //   58: aload_2
    //   59: aload_3
    //   60: invokespecial 487	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: areturn
    //   64: aload_2
    //   65: checkcast 281	gnu/mapping/Procedure
    //   68: astore 18
    //   70: aload_3
    //   71: checkcast 281	gnu/mapping/Procedure
    //   74: astore 20
    //   76: aload 18
    //   78: aload 20
    //   80: invokestatic 489	kawa/lib/rnrs/hashtables:makeHashtable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Lkawa/lib/kawa/hashtable$HashTable;
    //   83: areturn
    //   84: aload_2
    //   85: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   88: astore 16
    //   90: aload 16
    //   92: aload_3
    //   93: invokestatic 491	kawa/lib/rnrs/hashtables:hashtableDelete$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)V
    //   96: getstatic 356	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   99: areturn
    //   100: aload_2
    //   101: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   104: astore 14
    //   106: aload 14
    //   108: aload_3
    //   109: invokestatic 493	kawa/lib/rnrs/hashtables:isHashtableContains	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Z
    //   112: ifeq +7 -> 119
    //   115: getstatic 375	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   118: areturn
    //   119: getstatic 319	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   122: areturn
    //   123: aload_2
    //   124: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   127: astore 9
    //   129: getstatic 319	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   132: astore 11
    //   134: aload_3
    //   135: aload 11
    //   137: if_acmpeq +14 -> 151
    //   140: iconst_1
    //   141: istore 12
    //   143: aload 9
    //   145: iload 12
    //   147: invokestatic 258	kawa/lib/rnrs/hashtables:hashtableCopy	(Lkawa/lib/kawa/hashtable$HashTable;Z)Lkawa/lib/kawa/hashtable$HashTable;
    //   150: areturn
    //   151: iconst_0
    //   152: istore 12
    //   154: goto -11 -> 143
    //   157: aload_2
    //   158: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   161: astore 5
    //   163: aload_3
    //   164: checkcast 450	java/lang/Number
    //   167: invokevirtual 453	java/lang/Number:intValue	()I
    //   170: istore 7
    //   172: aload 5
    //   174: iload 7
    //   176: invokestatic 243	kawa/lib/rnrs/hashtables:hashtableClear$Ex	(Lkawa/lib/kawa/hashtable$HashTable;I)V
    //   179: getstatic 356	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   182: areturn
    //   183: astore 17
    //   185: new 481	gnu/mapping/WrongType
    //   188: dup
    //   189: aload 17
    //   191: ldc 140
    //   193: iconst_1
    //   194: aload_2
    //   195: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   198: athrow
    //   199: astore 19
    //   201: new 481	gnu/mapping/WrongType
    //   204: dup
    //   205: aload 19
    //   207: ldc 140
    //   209: iconst_2
    //   210: aload_3
    //   211: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   214: athrow
    //   215: astore 15
    //   217: new 481	gnu/mapping/WrongType
    //   220: dup
    //   221: aload 15
    //   223: ldc 120
    //   225: iconst_1
    //   226: aload_2
    //   227: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   230: athrow
    //   231: astore 13
    //   233: new 481	gnu/mapping/WrongType
    //   236: dup
    //   237: aload 13
    //   239: ldc 116
    //   241: iconst_1
    //   242: aload_2
    //   243: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   246: athrow
    //   247: astore 8
    //   249: new 481	gnu/mapping/WrongType
    //   252: dup
    //   253: aload 8
    //   255: ldc 108
    //   257: iconst_1
    //   258: aload_2
    //   259: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   262: athrow
    //   263: astore 10
    //   265: new 481	gnu/mapping/WrongType
    //   268: dup
    //   269: aload 10
    //   271: ldc 108
    //   273: iconst_2
    //   274: aload_3
    //   275: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   278: athrow
    //   279: astore 4
    //   281: new 481	gnu/mapping/WrongType
    //   284: dup
    //   285: aload 4
    //   287: ldc 104
    //   289: iconst_1
    //   290: aload_2
    //   291: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   294: athrow
    //   295: astore 6
    //   297: new 481	gnu/mapping/WrongType
    //   300: dup
    //   301: aload 6
    //   303: ldc 104
    //   305: iconst_2
    //   306: aload_3
    //   307: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   310: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   64	70	183	java/lang/ClassCastException
    //   70	76	199	java/lang/ClassCastException
    //   84	90	215	java/lang/ClassCastException
    //   100	106	231	java/lang/ClassCastException
    //   123	129	247	java/lang/ClassCastException
    //   129	134	263	java/lang/ClassCastException
    //   157	163	279	java/lang/ClassCastException
    //   163	172	295	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+40 -> 44, 7:+50->54, 8:+40->44, 9:+40->44, 10:+40->44, 11:+82->86, 12:+97->101
    //   45: aload_1
    //   46: aload_2
    //   47: aload_3
    //   48: aload 4
    //   50: invokespecial 497	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: areturn
    //   54: aload_2
    //   55: checkcast 281	gnu/mapping/Procedure
    //   58: astore 10
    //   60: aload_3
    //   61: checkcast 281	gnu/mapping/Procedure
    //   64: astore 12
    //   66: aload 4
    //   68: checkcast 450	java/lang/Number
    //   71: invokevirtual 453	java/lang/Number:intValue	()I
    //   74: istore 14
    //   76: aload 10
    //   78: aload 12
    //   80: iload 14
    //   82: invokestatic 401	kawa/lib/rnrs/hashtables:makeHashtable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
    //   85: areturn
    //   86: aload_2
    //   87: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   90: astore 8
    //   92: aload 8
    //   94: aload_3
    //   95: aload 4
    //   97: invokestatic 499	kawa/lib/rnrs/hashtables:hashtableRef	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: areturn
    //   101: aload_2
    //   102: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   105: astore 6
    //   107: aload 6
    //   109: aload_3
    //   110: aload 4
    //   112: invokestatic 350	kawa/lib/rnrs/hashtables:hashtableSet$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)V
    //   115: getstatic 356	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   118: areturn
    //   119: astore 9
    //   121: new 481	gnu/mapping/WrongType
    //   124: dup
    //   125: aload 9
    //   127: ldc 140
    //   129: iconst_1
    //   130: aload_2
    //   131: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   134: athrow
    //   135: astore 11
    //   137: new 481	gnu/mapping/WrongType
    //   140: dup
    //   141: aload 11
    //   143: ldc 140
    //   145: iconst_2
    //   146: aload_3
    //   147: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   150: athrow
    //   151: astore 13
    //   153: new 481	gnu/mapping/WrongType
    //   156: dup
    //   157: aload 13
    //   159: ldc 140
    //   161: iconst_3
    //   162: aload 4
    //   164: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   167: athrow
    //   168: astore 7
    //   170: new 481	gnu/mapping/WrongType
    //   173: dup
    //   174: aload 7
    //   176: ldc 128
    //   178: iconst_1
    //   179: aload_2
    //   180: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   183: athrow
    //   184: astore 5
    //   186: new 481	gnu/mapping/WrongType
    //   189: dup
    //   190: aload 5
    //   192: ldc 124
    //   194: iconst_1
    //   195: aload_2
    //   196: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   199: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   54	60	119	java/lang/ClassCastException
    //   60	66	135	java/lang/ClassCastException
    //   66	76	151	java/lang/ClassCastException
    //   86	92	168	java/lang/ClassCastException
    //   101	107	184	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 15
    //   6: if_icmpne +27 -> 33
    //   9: aload_2
    //   10: checkcast 250	kawa/lib/kawa/hashtable$HashTable
    //   13: astore 7
    //   15: aload 4
    //   17: checkcast 281	gnu/mapping/Procedure
    //   20: astore 9
    //   22: aload 7
    //   24: aload_3
    //   25: aload 9
    //   27: aload 5
    //   29: invokestatic 503	kawa/lib/rnrs/hashtables:hashtableUpdate$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: areturn
    //   33: aload_0
    //   34: aload_1
    //   35: aload_2
    //   36: aload_3
    //   37: aload 4
    //   39: aload 5
    //   41: invokespecial 505	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: areturn
    //   45: astore 6
    //   47: new 481	gnu/mapping/WrongType
    //   50: dup
    //   51: aload 6
    //   53: ldc 112
    //   55: iconst_1
    //   56: aload_2
    //   57: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   60: athrow
    //   61: astore 8
    //   63: new 481	gnu/mapping/WrongType
    //   66: dup
    //   67: aload 8
    //   69: ldc 112
    //   71: iconst_3
    //   72: aload 4
    //   74: invokespecial 484	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   77: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	15	45	java/lang/ClassCastException
    //   15	22	61	java/lang/ClassCastException
  }

  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4:
    default:
      return super.match0(paramModuleMethod, paramCallContext);
    case 5:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 3:
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 4:
    case 6:
    case 7:
    case 8:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 17:
    case 19:
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 28:
      if (!(paramObject instanceof Symbol))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
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
    case 25:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 24:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 23:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 22:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 21:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 20:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 18:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 16:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 10:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 9:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5:
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

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 18:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 16:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (1 != 0)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 14:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 13:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 7:
    }
    if (!(paramObject1 instanceof Procedure))
      return -786431;
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof Procedure))
      return -786430;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 8:
    case 9:
    case 10:
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 12:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 11:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 7:
    }
    if (!(paramObject1 instanceof Procedure))
      return -786431;
    paramCallContext.value1 = paramObject1;
    if (!(paramObject2 instanceof Procedure))
      return -786430;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 3;
    return 0;
  }

  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 15)
    {
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
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

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.rnrs.hashtables
 * JD-Core Version:    0.6.2
 */