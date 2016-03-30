package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.util.HashNode;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.kawa.hashtable;
import kawa.lib.kawa.hashtable.HashTable;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.rnrs.hashtables;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class srfi69 extends ModuleBody
{
  public static final srfi69 $instance;
  static final IntNum Lit0;
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
  static final SimpleSymbol Lit19 = (SimpleSymbol)new SimpleSymbol("hash-table-values").readResolve();
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod alist$Mn$Grhash$Mntable;
  public static final ModuleMethod hash;
  public static final ModuleMethod hash$Mnby$Mnidentity;
  public static final ModuleMethod hash$Mntable$Mn$Gralist;
  public static final ModuleMethod hash$Mntable$Mncopy;
  public static final Location hash$Mntable$Mndelete$Ex;
  public static final ModuleMethod hash$Mntable$Mnequivalence$Mnfunction;
  public static final Location hash$Mntable$Mnexists$Qu;
  public static final ModuleMethod hash$Mntable$Mnfold;
  public static final ModuleMethod hash$Mntable$Mnhash$Mnfunction;
  public static final ModuleMethod hash$Mntable$Mnkeys;
  public static final ModuleMethod hash$Mntable$Mnmerge$Ex;
  public static final ModuleMethod hash$Mntable$Mnref;
  public static final ModuleMethod hash$Mntable$Mnref$Sldefault;
  public static final Location hash$Mntable$Mnset$Ex;
  public static final Location hash$Mntable$Mnsize;
  public static final ModuleMethod hash$Mntable$Mnupdate$Ex;
  public static final ModuleMethod hash$Mntable$Mnupdate$Ex$Sldefault;
  public static final ModuleMethod hash$Mntable$Mnvalues;
  public static final ModuleMethod hash$Mntable$Mnwalk;
  public static final Location hash$Mntable$Qu;
  static final ModuleMethod lambda$Fn1;
  static final ModuleMethod lambda$Fn2;
  static final ModuleMethod lambda$Fn3;
  public static final ModuleMethod make$Mnhash$Mntable;
  public static final ModuleMethod string$Mnci$Mnhash;
  public static final ModuleMethod string$Mnhash;

  static
  {
    Lit18 = (SimpleSymbol)new SimpleSymbol("hash-table-keys").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("hash-table-merge!").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("hash-table-copy").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("hash-table->alist").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("alist->hash-table").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("hash-table-fold").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("hash-table-walk").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("hash-table-update!/default").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("hash-table-update!").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("hash-table-ref/default").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("hash-table-ref").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("make-hash-table").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("hash-table-hash-function").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("hash-table-equivalence-function").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("hash-by-identity").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("hash").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("string-ci-hash").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("string-hash").readResolve();
    Lit0 = IntNum.make(64);
    $instance = new srfi69();
    hash$Mntable$Qu = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Qu");
    hash$Mntable$Mnsize = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnsize");
    hash$Mntable$Mnset$Ex = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnset$Ex");
    hash$Mntable$Mndelete$Ex = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mndelete$Ex");
    hash$Mntable$Mnexists$Qu = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mncontains$Qu");
    srfi69 localsrfi69 = $instance;
    string$Mnhash = new ModuleMethod(localsrfi69, 1, Lit1, 8193);
    string$Mnci$Mnhash = new ModuleMethod(localsrfi69, 3, Lit2, 8193);
    hash = new ModuleMethod(localsrfi69, 5, Lit3, 8193);
    hash$Mnby$Mnidentity = new ModuleMethod(localsrfi69, 7, Lit4, 8193);
    hash$Mntable$Mnequivalence$Mnfunction = new ModuleMethod(localsrfi69, 9, Lit5, 4097);
    hash$Mntable$Mnhash$Mnfunction = new ModuleMethod(localsrfi69, 10, Lit6, 4097);
    make$Mnhash$Mntable = new ModuleMethod(localsrfi69, 11, Lit7, 12288);
    hash$Mntable$Mnref = new ModuleMethod(localsrfi69, 15, Lit8, 12290);
    hash$Mntable$Mnref$Sldefault = new ModuleMethod(localsrfi69, 17, Lit9, 12291);
    hash$Mntable$Mnupdate$Ex = new ModuleMethod(localsrfi69, 18, Lit10, 16387);
    hash$Mntable$Mnupdate$Ex$Sldefault = new ModuleMethod(localsrfi69, 20, Lit11, 16388);
    hash$Mntable$Mnwalk = new ModuleMethod(localsrfi69, 21, Lit12, 8194);
    hash$Mntable$Mnfold = new ModuleMethod(localsrfi69, 22, Lit13, 12291);
    ModuleMethod localModuleMethod1 = new ModuleMethod(localsrfi69, 23, null, 4097);
    localModuleMethod1.setProperty("source-location", "srfi69.scm:166");
    lambda$Fn1 = localModuleMethod1;
    alist$Mn$Grhash$Mntable = new ModuleMethod(localsrfi69, 24, Lit14, 16385);
    hash$Mntable$Mn$Gralist = new ModuleMethod(localsrfi69, 28, Lit15, 4097);
    hash$Mntable$Mncopy = new ModuleMethod(localsrfi69, 29, Lit16, 4097);
    hash$Mntable$Mnmerge$Ex = new ModuleMethod(localsrfi69, 30, Lit17, 8194);
    ModuleMethod localModuleMethod2 = new ModuleMethod(localsrfi69, 31, null, 12291);
    localModuleMethod2.setProperty("source-location", "srfi69.scm:183");
    lambda$Fn2 = localModuleMethod2;
    hash$Mntable$Mnkeys = new ModuleMethod(localsrfi69, 32, Lit18, 4097);
    ModuleMethod localModuleMethod3 = new ModuleMethod(localsrfi69, 33, null, 12291);
    localModuleMethod3.setProperty("source-location", "srfi69.scm:186");
    lambda$Fn3 = localModuleMethod3;
    hash$Mntable$Mnvalues = new ModuleMethod(localsrfi69, 34, Lit19, 4097);
    $instance.run();
  }

  public srfi69()
  {
    ModuleInfo.register(this);
  }

  public static hashtable.HashTable alist$To$HashTable(Object paramObject)
  {
    return alist$To$HashTable(paramObject, Scheme.isEqual);
  }

  public static hashtable.HashTable alist$To$HashTable(Object paramObject1, Object paramObject2)
  {
    return alist$To$HashTable(paramObject1, paramObject2, appropriateHashFunctionFor(paramObject2));
  }

  public static hashtable.HashTable alist$To$HashTable(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Lit0;
    try
    {
      LList localLList = (LList)paramObject1;
      arrayOfObject[1] = Integer.valueOf(2 * lists.length(localLList));
      return alist$To$HashTable(paramObject1, paramObject2, paramObject3, numbers.max(arrayOfObject));
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "length", 1, paramObject1);
    }
  }

  // ERROR //
  public static hashtable.HashTable alist$To$HashTable(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 309	gnu/mapping/Procedure
    //   4: astore 5
    //   6: aload_2
    //   7: checkcast 309	gnu/mapping/Procedure
    //   10: astore 7
    //   12: aload_3
    //   13: checkcast 311	java/lang/Number
    //   16: invokevirtual 315	java/lang/Number:intValue	()I
    //   19: istore 9
    //   21: aload 5
    //   23: aload 7
    //   25: iload 9
    //   27: invokestatic 319	gnu/kawa/slib/srfi69:makeHashTable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
    //   30: astore 10
    //   32: aload_0
    //   33: astore 11
    //   35: aload 11
    //   37: getstatic 323	gnu/lists/LList:Empty	Lgnu/lists/LList;
    //   40: if_acmpne +6 -> 46
    //   43: aload 10
    //   45: areturn
    //   46: aload 11
    //   48: checkcast 325	gnu/lists/Pair
    //   51: astore 13
    //   53: aload 13
    //   55: invokevirtual 328	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   58: astore 14
    //   60: aload 10
    //   62: getstatic 332	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   65: aload 14
    //   67: invokevirtual 336	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: getstatic 226	gnu/kawa/slib/srfi69:lambda$Fn1	Lgnu/expr/ModuleMethod;
    //   73: getstatic 339	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   76: aload 14
    //   78: invokevirtual 336	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: invokestatic 343	gnu/kawa/slib/srfi69:hashTableUpdate$Ex$SlDefault	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   84: aload 13
    //   86: invokevirtual 346	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   89: astore 11
    //   91: goto -56 -> 35
    //   94: astore 4
    //   96: new 303	gnu/mapping/WrongType
    //   99: dup
    //   100: aload 4
    //   102: ldc 119
    //   104: iconst_0
    //   105: aload_1
    //   106: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   109: athrow
    //   110: astore 6
    //   112: new 303	gnu/mapping/WrongType
    //   115: dup
    //   116: aload 6
    //   118: ldc 119
    //   120: iconst_1
    //   121: aload_2
    //   122: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   125: athrow
    //   126: astore 8
    //   128: new 303	gnu/mapping/WrongType
    //   131: dup
    //   132: aload 8
    //   134: ldc 119
    //   136: iconst_2
    //   137: aload_3
    //   138: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   141: athrow
    //   142: astore 12
    //   144: new 303	gnu/mapping/WrongType
    //   147: dup
    //   148: aload 12
    //   150: ldc_w 348
    //   153: bipush 254
    //   155: aload 11
    //   157: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   160: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	94	java/lang/ClassCastException
    //   6	12	110	java/lang/ClassCastException
    //   12	21	126	java/lang/ClassCastException
    //   46	53	142	java/lang/ClassCastException
  }

  static Procedure appropriateHashFunctionFor(Object paramObject)
  {
    int i;
    Object localObject1;
    if (paramObject == Scheme.isEq)
    {
      i = 1;
      if (i == 0)
        break label34;
      localObject1 = hash$Mnby$Mnidentity;
    }
    while (true)
    {
      if (localObject1 == Boolean.FALSE)
        break label52;
      return (Procedure)localObject1;
      i = 0;
      break;
      label34: if (i != 0)
        localObject1 = Boolean.TRUE;
      else
        localObject1 = Boolean.FALSE;
    }
    label52: int j;
    Object localObject2;
    if (paramObject == strings.string$Eq$Qu)
    {
      j = 1;
      if (j == 0)
        break label89;
      localObject2 = string$Mnhash;
    }
    while (true)
    {
      if (localObject2 == Boolean.FALSE)
        break label109;
      return (Procedure)localObject2;
      j = 0;
      break;
      label89: if (j != 0)
        localObject2 = Boolean.TRUE;
      else
        localObject2 = Boolean.FALSE;
    }
    label109: int k;
    Object localObject3;
    if (paramObject == unicode.string$Mnci$Eq$Qu)
    {
      k = 1;
      if (k == 0)
        break label149;
      localObject3 = string$Mnci$Mnhash;
    }
    while (true)
    {
      if (localObject3 == Boolean.FALSE)
        break label170;
      return (Procedure)localObject3;
      k = 0;
      break;
      label149: if (k != 0)
        localObject3 = Boolean.TRUE;
      else
        localObject3 = Boolean.FALSE;
    }
    label170: return hash;
  }

  public static Object hash(Object paramObject)
  {
    return hash(paramObject, null);
  }

  public static Object hash(Object paramObject, IntNum paramIntNum)
  {
    if (paramObject == null);
    for (int i = 0; paramIntNum == null; i = paramObject.hashCode())
      return Integer.valueOf(i);
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }

  public static Object hashByIdentity(Object paramObject)
  {
    return hashByIdentity(paramObject, null);
  }

  public static Object hashByIdentity(Object paramObject, IntNum paramIntNum)
  {
    int i = System.identityHashCode(paramObject);
    if (paramIntNum == null)
      return Integer.valueOf(i);
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }

  public static Object hashTable$To$Alist(hashtable.HashTable paramHashTable)
  {
    return paramHashTable.toAlist();
  }

  public static hashtable.HashTable hashTableCopy(hashtable.HashTable paramHashTable)
  {
    return new hashtable.HashTable(paramHashTable, true);
  }

  public static Procedure hashTableEquivalenceFunction(hashtable.HashTable paramHashTable)
  {
    return paramHashTable.equivalenceFunction;
  }

  public static Object hashTableFold(hashtable.HashTable paramHashTable, Procedure paramProcedure, Object paramObject)
  {
    return paramHashTable.fold(paramProcedure, paramObject);
  }

  public static Procedure hashTableHashFunction(hashtable.HashTable paramHashTable)
  {
    return paramHashTable.hashFunction;
  }

  public static Object hashTableKeys(hashtable.HashTable paramHashTable)
  {
    return hashTableFold(paramHashTable, lambda$Fn2, LList.Empty);
  }

  public static void hashTableMerge$Ex(hashtable.HashTable paramHashTable1, hashtable.HashTable paramHashTable2)
  {
    paramHashTable1.putAll(paramHashTable2);
  }

  public static Object hashTableRef(hashtable.HashTable paramHashTable, Object paramObject)
  {
    return hashTableRef(paramHashTable, paramObject, Boolean.FALSE);
  }

  public static Object hashTableRef(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    HashNode localHashNode = paramHashTable.getNode(paramObject1);
    if (localHashNode == null)
    {
      if (paramObject2 != Boolean.FALSE)
        return Scheme.applyToArgs.apply1(paramObject2);
      return misc.error$V("hash-table-ref: no value associated with", new Object[] { paramObject1 });
    }
    return localHashNode.getValue();
  }

  public static Object hashTableRef$SlDefault(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    return paramHashTable.get(paramObject1, paramObject2);
  }

  public static void hashTableUpdate$Ex(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    hashTableUpdate$Ex(paramHashTable, paramObject1, paramObject2, Boolean.FALSE);
  }

  public static void hashTableUpdate$Ex(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    HashNode localHashNode = paramHashTable.getNode(paramObject1);
    if (localHashNode == null)
    {
      if (paramObject3 != Boolean.FALSE)
      {
        hashtables.hashtableSet$Ex(paramHashTable, paramObject1, Scheme.applyToArgs.apply2(paramObject2, Scheme.applyToArgs.apply1(paramObject3)));
        return;
      }
      misc.error$V("hash-table-update!: no value exists for key", new Object[] { paramObject1 });
      return;
    }
    localHashNode.setValue(Scheme.applyToArgs.apply2(paramObject2, localHashNode.getValue()));
  }

  public static void hashTableUpdate$Ex$SlDefault(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    hashtable.hashtableCheckMutable(paramHashTable);
    HashNode localHashNode = paramHashTable.getNode(paramObject1);
    if (localHashNode == null)
    {
      hashtables.hashtableSet$Ex(paramHashTable, paramObject1, Scheme.applyToArgs.apply2(paramObject2, paramObject3));
      return;
    }
    localHashNode.setValue(Scheme.applyToArgs.apply2(paramObject2, localHashNode.getValue()));
  }

  public static Object hashTableValues(hashtable.HashTable paramHashTable)
  {
    return hashTableFold(paramHashTable, lambda$Fn3, LList.Empty);
  }

  public static void hashTableWalk(hashtable.HashTable paramHashTable, Procedure paramProcedure)
  {
    paramHashTable.walk(paramProcedure);
  }

  static Object lambda1(Object paramObject)
  {
    return paramObject;
  }

  static Pair lambda2(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return lists.cons(paramObject1, paramObject3);
  }

  static Pair lambda3(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return lists.cons(paramObject2, paramObject3);
  }

  public static hashtable.HashTable makeHashTable()
  {
    return makeHashTable(Scheme.isEqual);
  }

  public static hashtable.HashTable makeHashTable(Procedure paramProcedure)
  {
    return makeHashTable(paramProcedure, appropriateHashFunctionFor(paramProcedure), 64);
  }

  public static hashtable.HashTable makeHashTable(Procedure paramProcedure1, Procedure paramProcedure2)
  {
    return makeHashTable(paramProcedure1, paramProcedure2, 64);
  }

  public static hashtable.HashTable makeHashTable(Procedure paramProcedure1, Procedure paramProcedure2, int paramInt)
  {
    return new hashtable.HashTable(paramProcedure1, paramProcedure2, paramInt);
  }

  public static Object stringCiHash(Object paramObject)
  {
    return stringCiHash(paramObject, null);
  }

  public static Object stringCiHash(Object paramObject, IntNum paramIntNum)
  {
    int i = paramObject.toString().toLowerCase().hashCode();
    if (paramIntNum == null)
      return Integer.valueOf(i);
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }

  public static Object stringHash(CharSequence paramCharSequence)
  {
    return stringHash(paramCharSequence, null);
  }

  public static Object stringHash(CharSequence paramCharSequence, IntNum paramIntNum)
  {
    int i = paramCharSequence.hashCode();
    if (paramIntNum == null)
      return Integer.valueOf(i);
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }

  static Object symbolHash(Symbol paramSymbol)
  {
    return symbolHash(paramSymbol, null);
  }

  static Object symbolHash(Symbol paramSymbol, IntNum paramIntNum)
  {
    int i = paramSymbol.hashCode();
    if (paramIntNum == null)
      return Integer.valueOf(i);
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }

  static Object vectorHash(Object paramObject)
  {
    return vectorHash(paramObject, null);
  }

  static Object vectorHash(Object paramObject, IntNum paramIntNum)
  {
    int i = paramObject.hashCode();
    if (paramIntNum == null)
      return Integer.valueOf(i);
    return IntNum.modulo(IntNum.make(i), paramIntNum);
  }

  public Object apply0(ModuleMethod paramModuleMethod)
  {
    if (paramModuleMethod.selector == 11)
      return makeHashTable();
    return super.apply0(paramModuleMethod);
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 541	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+116->120, 1:+123->127, 3:+135->139, 5:+140->144, 7:+145->149, 9:+150->154, 10:+162->166, 11:+174->178, 23:+186->190, 24:+191->195, 28:+196->200, 29:+208->212, 32:+220->224, 34:+232->236
    //   121: aload_1
    //   122: aload_2
    //   123: invokespecial 548	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: areturn
    //   127: aload_2
    //   128: checkcast 523	java/lang/CharSequence
    //   131: astore 18
    //   133: aload 18
    //   135: invokestatic 550	gnu/kawa/slib/srfi69:stringHash	(Ljava/lang/CharSequence;)Ljava/lang/Object;
    //   138: areturn
    //   139: aload_2
    //   140: invokestatic 552	gnu/kawa/slib/srfi69:stringCiHash	(Ljava/lang/Object;)Ljava/lang/Object;
    //   143: areturn
    //   144: aload_2
    //   145: invokestatic 554	gnu/kawa/slib/srfi69:hash	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: areturn
    //   149: aload_2
    //   150: invokestatic 556	gnu/kawa/slib/srfi69:hashByIdentity	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: areturn
    //   154: aload_2
    //   155: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   158: astore 16
    //   160: aload 16
    //   162: invokestatic 558	gnu/kawa/slib/srfi69:hashTableEquivalenceFunction	(Lkawa/lib/kawa/hashtable$HashTable;)Lgnu/mapping/Procedure;
    //   165: areturn
    //   166: aload_2
    //   167: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   170: astore 14
    //   172: aload 14
    //   174: invokestatic 560	gnu/kawa/slib/srfi69:hashTableHashFunction	(Lkawa/lib/kawa/hashtable$HashTable;)Lgnu/mapping/Procedure;
    //   177: areturn
    //   178: aload_2
    //   179: checkcast 309	gnu/mapping/Procedure
    //   182: astore 12
    //   184: aload 12
    //   186: invokestatic 499	gnu/kawa/slib/srfi69:makeHashTable	(Lgnu/mapping/Procedure;)Lkawa/lib/kawa/hashtable$HashTable;
    //   189: areturn
    //   190: aload_2
    //   191: invokestatic 562	gnu/kawa/slib/srfi69:lambda1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   194: areturn
    //   195: aload_2
    //   196: invokestatic 564	gnu/kawa/slib/srfi69:alist$To$HashTable	(Ljava/lang/Object;)Lkawa/lib/kawa/hashtable$HashTable;
    //   199: areturn
    //   200: aload_2
    //   201: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   204: astore 10
    //   206: aload 10
    //   208: invokestatic 566	gnu/kawa/slib/srfi69:hashTable$To$Alist	(Lkawa/lib/kawa/hashtable$HashTable;)Ljava/lang/Object;
    //   211: areturn
    //   212: aload_2
    //   213: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   216: astore 8
    //   218: aload 8
    //   220: invokestatic 568	gnu/kawa/slib/srfi69:hashTableCopy	(Lkawa/lib/kawa/hashtable$HashTable;)Lkawa/lib/kawa/hashtable$HashTable;
    //   223: areturn
    //   224: aload_2
    //   225: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   228: astore 6
    //   230: aload 6
    //   232: invokestatic 570	gnu/kawa/slib/srfi69:hashTableKeys	(Lkawa/lib/kawa/hashtable$HashTable;)Ljava/lang/Object;
    //   235: areturn
    //   236: aload_2
    //   237: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   240: astore 4
    //   242: aload 4
    //   244: invokestatic 572	gnu/kawa/slib/srfi69:hashTableValues	(Lkawa/lib/kawa/hashtable$HashTable;)Ljava/lang/Object;
    //   247: areturn
    //   248: astore 17
    //   250: new 303	gnu/mapping/WrongType
    //   253: dup
    //   254: aload 17
    //   256: ldc 142
    //   258: iconst_1
    //   259: aload_2
    //   260: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   263: athrow
    //   264: astore 15
    //   266: new 303	gnu/mapping/WrongType
    //   269: dup
    //   270: aload 15
    //   272: ldc 127
    //   274: iconst_1
    //   275: aload_2
    //   276: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: astore 13
    //   282: new 303	gnu/mapping/WrongType
    //   285: dup
    //   286: aload 13
    //   288: ldc 123
    //   290: iconst_1
    //   291: aload_2
    //   292: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    //   296: astore 11
    //   298: new 303	gnu/mapping/WrongType
    //   301: dup
    //   302: aload 11
    //   304: ldc 119
    //   306: iconst_1
    //   307: aload_2
    //   308: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    //   312: astore 9
    //   314: new 303	gnu/mapping/WrongType
    //   317: dup
    //   318: aload 9
    //   320: ldc 87
    //   322: iconst_1
    //   323: aload_2
    //   324: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   327: athrow
    //   328: astore 7
    //   330: new 303	gnu/mapping/WrongType
    //   333: dup
    //   334: aload 7
    //   336: ldc 83
    //   338: iconst_1
    //   339: aload_2
    //   340: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   343: athrow
    //   344: astore 5
    //   346: new 303	gnu/mapping/WrongType
    //   349: dup
    //   350: aload 5
    //   352: ldc 75
    //   354: iconst_1
    //   355: aload_2
    //   356: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   359: athrow
    //   360: astore_3
    //   361: new 303	gnu/mapping/WrongType
    //   364: dup
    //   365: aload_3
    //   366: ldc 63
    //   368: iconst_1
    //   369: aload_2
    //   370: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   373: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   127	133	248	java/lang/ClassCastException
    //   154	160	264	java/lang/ClassCastException
    //   166	172	280	java/lang/ClassCastException
    //   178	184	296	java/lang/ClassCastException
    //   200	206	312	java/lang/ClassCastException
    //   212	218	328	java/lang/ClassCastException
    //   224	230	344	java/lang/ClassCastException
    //   236	242	360	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 541	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+84->88, 1:+92->96, 3:+112->116, 5:+125->129, 7:+138->142, 11:+151->155, 15:+171->175, 21:+184->188, 24:+207->211, 30:+213->217
    //   89: aload_1
    //   90: aload_2
    //   91: aload_3
    //   92: invokespecial 575	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: areturn
    //   96: aload_2
    //   97: checkcast 523	java/lang/CharSequence
    //   100: astore 25
    //   102: aload_3
    //   103: invokestatic 581	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   106: astore 27
    //   108: aload 25
    //   110: aload 27
    //   112: invokestatic 521	gnu/kawa/slib/srfi69:stringHash	(Ljava/lang/CharSequence;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   115: areturn
    //   116: aload_3
    //   117: invokestatic 581	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   120: astore 23
    //   122: aload_2
    //   123: aload 23
    //   125: invokestatic 506	gnu/kawa/slib/srfi69:stringCiHash	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   128: areturn
    //   129: aload_3
    //   130: invokestatic 581	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   133: astore 21
    //   135: aload_2
    //   136: aload 21
    //   138: invokestatic 374	gnu/kawa/slib/srfi69:hash	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   141: areturn
    //   142: aload_3
    //   143: invokestatic 581	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   146: astore 19
    //   148: aload_2
    //   149: aload 19
    //   151: invokestatic 384	gnu/kawa/slib/srfi69:hashByIdentity	(Ljava/lang/Object;Lgnu/math/IntNum;)Ljava/lang/Object;
    //   154: areturn
    //   155: aload_2
    //   156: checkcast 309	gnu/mapping/Procedure
    //   159: astore 15
    //   161: aload_3
    //   162: checkcast 309	gnu/mapping/Procedure
    //   165: astore 17
    //   167: aload 15
    //   169: aload 17
    //   171: invokestatic 583	gnu/kawa/slib/srfi69:makeHashTable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Lkawa/lib/kawa/hashtable$HashTable;
    //   174: areturn
    //   175: aload_2
    //   176: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   179: astore 13
    //   181: aload 13
    //   183: aload_3
    //   184: invokestatic 585	gnu/kawa/slib/srfi69:hashTableRef	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: areturn
    //   188: aload_2
    //   189: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   192: astore 9
    //   194: aload_3
    //   195: checkcast 309	gnu/mapping/Procedure
    //   198: astore 11
    //   200: aload 9
    //   202: aload 11
    //   204: invokestatic 587	gnu/kawa/slib/srfi69:hashTableWalk	(Lkawa/lib/kawa/hashtable$HashTable;Lgnu/mapping/Procedure;)V
    //   207: getstatic 593	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   210: areturn
    //   211: aload_2
    //   212: aload_3
    //   213: invokestatic 267	gnu/kawa/slib/srfi69:alist$To$HashTable	(Ljava/lang/Object;Ljava/lang/Object;)Lkawa/lib/kawa/hashtable$HashTable;
    //   216: areturn
    //   217: aload_2
    //   218: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   221: astore 5
    //   223: aload_3
    //   224: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   227: astore 7
    //   229: aload 5
    //   231: aload 7
    //   233: invokestatic 595	gnu/kawa/slib/srfi69:hashTableMerge$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Lkawa/lib/kawa/hashtable$HashTable;)V
    //   236: getstatic 593	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   239: areturn
    //   240: astore 24
    //   242: new 303	gnu/mapping/WrongType
    //   245: dup
    //   246: aload 24
    //   248: ldc 142
    //   250: iconst_1
    //   251: aload_2
    //   252: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   255: athrow
    //   256: astore 26
    //   258: new 303	gnu/mapping/WrongType
    //   261: dup
    //   262: aload 26
    //   264: ldc 142
    //   266: iconst_2
    //   267: aload_3
    //   268: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   271: athrow
    //   272: astore 22
    //   274: new 303	gnu/mapping/WrongType
    //   277: dup
    //   278: aload 22
    //   280: ldc 138
    //   282: iconst_2
    //   283: aload_3
    //   284: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   287: athrow
    //   288: astore 20
    //   290: new 303	gnu/mapping/WrongType
    //   293: dup
    //   294: aload 20
    //   296: ldc 134
    //   298: iconst_2
    //   299: aload_3
    //   300: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   303: athrow
    //   304: astore 18
    //   306: new 303	gnu/mapping/WrongType
    //   309: dup
    //   310: aload 18
    //   312: ldc 131
    //   314: iconst_2
    //   315: aload_3
    //   316: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   319: athrow
    //   320: astore 14
    //   322: new 303	gnu/mapping/WrongType
    //   325: dup
    //   326: aload 14
    //   328: ldc 119
    //   330: iconst_1
    //   331: aload_2
    //   332: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   335: athrow
    //   336: astore 16
    //   338: new 303	gnu/mapping/WrongType
    //   341: dup
    //   342: aload 16
    //   344: ldc 119
    //   346: iconst_2
    //   347: aload_3
    //   348: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   351: athrow
    //   352: astore 12
    //   354: new 303	gnu/mapping/WrongType
    //   357: dup
    //   358: aload 12
    //   360: ldc 115
    //   362: iconst_1
    //   363: aload_2
    //   364: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   367: athrow
    //   368: astore 8
    //   370: new 303	gnu/mapping/WrongType
    //   373: dup
    //   374: aload 8
    //   376: ldc 99
    //   378: iconst_1
    //   379: aload_2
    //   380: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   383: athrow
    //   384: astore 10
    //   386: new 303	gnu/mapping/WrongType
    //   389: dup
    //   390: aload 10
    //   392: ldc 99
    //   394: iconst_2
    //   395: aload_3
    //   396: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   399: athrow
    //   400: astore 4
    //   402: new 303	gnu/mapping/WrongType
    //   405: dup
    //   406: aload 4
    //   408: ldc 79
    //   410: iconst_1
    //   411: aload_2
    //   412: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   415: athrow
    //   416: astore 6
    //   418: new 303	gnu/mapping/WrongType
    //   421: dup
    //   422: aload 6
    //   424: ldc 79
    //   426: iconst_2
    //   427: aload_3
    //   428: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   431: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   96	102	240	java/lang/ClassCastException
    //   102	108	256	java/lang/ClassCastException
    //   116	122	272	java/lang/ClassCastException
    //   129	135	288	java/lang/ClassCastException
    //   142	148	304	java/lang/ClassCastException
    //   155	161	320	java/lang/ClassCastException
    //   161	167	336	java/lang/ClassCastException
    //   175	181	352	java/lang/ClassCastException
    //   188	194	368	java/lang/ClassCastException
    //   194	200	384	java/lang/ClassCastException
    //   217	223	400	java/lang/ClassCastException
    //   223	229	416	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 541	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+76->80, 11:+86->90, 15:+118->122, 17:+133->137, 18:+148->152, 22:+166->170, 24:+188->192, 31:+196->200, 33:+204->208
    //   81: aload_1
    //   82: aload_2
    //   83: aload_3
    //   84: aload 4
    //   86: invokespecial 599	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: areturn
    //   90: aload_2
    //   91: checkcast 309	gnu/mapping/Procedure
    //   94: astore 16
    //   96: aload_3
    //   97: checkcast 309	gnu/mapping/Procedure
    //   100: astore 18
    //   102: aload 4
    //   104: checkcast 311	java/lang/Number
    //   107: invokevirtual 315	java/lang/Number:intValue	()I
    //   110: istore 20
    //   112: aload 16
    //   114: aload 18
    //   116: iload 20
    //   118: invokestatic 319	gnu/kawa/slib/srfi69:makeHashTable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
    //   121: areturn
    //   122: aload_2
    //   123: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   126: astore 14
    //   128: aload 14
    //   130: aload_3
    //   131: aload 4
    //   133: invokestatic 432	gnu/kawa/slib/srfi69:hashTableRef	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: areturn
    //   137: aload_2
    //   138: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   141: astore 12
    //   143: aload 12
    //   145: aload_3
    //   146: aload 4
    //   148: invokestatic 601	gnu/kawa/slib/srfi69:hashTableRef$SlDefault	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: areturn
    //   152: aload_2
    //   153: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   156: astore 10
    //   158: aload 10
    //   160: aload_3
    //   161: aload 4
    //   163: invokestatic 603	gnu/kawa/slib/srfi69:hashTableUpdate$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)V
    //   166: getstatic 593	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   169: areturn
    //   170: aload_2
    //   171: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   174: astore 6
    //   176: aload_3
    //   177: checkcast 309	gnu/mapping/Procedure
    //   180: astore 8
    //   182: aload 6
    //   184: aload 8
    //   186: aload 4
    //   188: invokestatic 421	gnu/kawa/slib/srfi69:hashTableFold	(Lkawa/lib/kawa/hashtable$HashTable;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: areturn
    //   192: aload_2
    //   193: aload_3
    //   194: aload 4
    //   196: invokestatic 274	gnu/kawa/slib/srfi69:alist$To$HashTable	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkawa/lib/kawa/hashtable$HashTable;
    //   199: areturn
    //   200: aload_2
    //   201: aload_3
    //   202: aload 4
    //   204: invokestatic 605	gnu/kawa/slib/srfi69:lambda2	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   207: areturn
    //   208: aload_2
    //   209: aload_3
    //   210: aload 4
    //   212: invokestatic 607	gnu/kawa/slib/srfi69:lambda3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   215: areturn
    //   216: astore 15
    //   218: new 303	gnu/mapping/WrongType
    //   221: dup
    //   222: aload 15
    //   224: ldc 119
    //   226: iconst_1
    //   227: aload_2
    //   228: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   231: athrow
    //   232: astore 17
    //   234: new 303	gnu/mapping/WrongType
    //   237: dup
    //   238: aload 17
    //   240: ldc 119
    //   242: iconst_2
    //   243: aload_3
    //   244: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   247: athrow
    //   248: astore 19
    //   250: new 303	gnu/mapping/WrongType
    //   253: dup
    //   254: aload 19
    //   256: ldc 119
    //   258: iconst_3
    //   259: aload 4
    //   261: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   264: athrow
    //   265: astore 13
    //   267: new 303	gnu/mapping/WrongType
    //   270: dup
    //   271: aload 13
    //   273: ldc 115
    //   275: iconst_1
    //   276: aload_2
    //   277: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: astore 11
    //   283: new 303	gnu/mapping/WrongType
    //   286: dup
    //   287: aload 11
    //   289: ldc 111
    //   291: iconst_1
    //   292: aload_2
    //   293: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: astore 9
    //   299: new 303	gnu/mapping/WrongType
    //   302: dup
    //   303: aload 9
    //   305: ldc 107
    //   307: iconst_1
    //   308: aload_2
    //   309: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   312: athrow
    //   313: astore 5
    //   315: new 303	gnu/mapping/WrongType
    //   318: dup
    //   319: aload 5
    //   321: ldc 95
    //   323: iconst_1
    //   324: aload_2
    //   325: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   328: athrow
    //   329: astore 7
    //   331: new 303	gnu/mapping/WrongType
    //   334: dup
    //   335: aload 7
    //   337: ldc 95
    //   339: iconst_2
    //   340: aload_3
    //   341: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   344: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   90	96	216	java/lang/ClassCastException
    //   96	102	232	java/lang/ClassCastException
    //   102	112	248	java/lang/ClassCastException
    //   122	128	265	java/lang/ClassCastException
    //   137	143	281	java/lang/ClassCastException
    //   152	158	297	java/lang/ClassCastException
    //   170	176	313	java/lang/ClassCastException
    //   176	182	329	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 541	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+36->40, 18:+48->52, 20:+68->72, 24:+88->92
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: aload 4
    //   46: aload 5
    //   48: invokespecial 611	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: areturn
    //   52: aload_2
    //   53: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   56: astore 9
    //   58: aload 9
    //   60: aload_3
    //   61: aload 4
    //   63: aload 5
    //   65: invokestatic 462	gnu/kawa/slib/srfi69:hashTableUpdate$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   68: getstatic 593	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   71: areturn
    //   72: aload_2
    //   73: checkcast 394	kawa/lib/kawa/hashtable$HashTable
    //   76: astore 7
    //   78: aload 7
    //   80: aload_3
    //   81: aload 4
    //   83: aload 5
    //   85: invokestatic 343	gnu/kawa/slib/srfi69:hashTableUpdate$Ex$SlDefault	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   88: getstatic 593	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   91: areturn
    //   92: aload_2
    //   93: aload_3
    //   94: aload 4
    //   96: aload 5
    //   98: invokestatic 301	gnu/kawa/slib/srfi69:alist$To$HashTable	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkawa/lib/kawa/hashtable$HashTable;
    //   101: areturn
    //   102: astore 8
    //   104: new 303	gnu/mapping/WrongType
    //   107: dup
    //   108: aload 8
    //   110: ldc 107
    //   112: iconst_1
    //   113: aload_2
    //   114: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   117: athrow
    //   118: astore 6
    //   120: new 303	gnu/mapping/WrongType
    //   123: dup
    //   124: aload 6
    //   126: ldc 103
    //   128: iconst_1
    //   129: aload_2
    //   130: invokespecial 307	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   133: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   52	58	102	java/lang/ClassCastException
    //   72	78	118	java/lang/ClassCastException
  }

  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 11)
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
    case 34:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 32:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 29:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28:
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 24:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 23:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 11:
      if (!(paramObject instanceof Procedure))
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
      if (!(paramObject instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 7:
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
    case 1:
    }
    if ((paramObject instanceof CharSequence))
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
    case 30:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof hashtable.HashTable))
        return -786430;
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
    case 21:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 15:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 11:
      if (!(paramObject1 instanceof Procedure))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 7:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 5:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 3:
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
      {
        paramCallContext.value2 = paramObject2;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 2;
        return 0;
      }
      return -786430;
    case 1:
    }
    if ((paramObject1 instanceof CharSequence))
    {
      paramCallContext.value1 = paramObject1;
      if (IntNum.asIntNumOrNull(paramObject2) != null)
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
  }

  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    case 33:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 31:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 24:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 22:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      if (!(paramObject2 instanceof Procedure))
        return -786430;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 18:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 17:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 15:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    case 11:
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
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    case 24:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 20:
      if (!(paramObject1 instanceof hashtable.HashTable))
        return -786431;
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.value4 = paramObject4;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 4;
      return 0;
    case 18:
    }
    if (!(paramObject1 instanceof hashtable.HashTable))
      return -786431;
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.value3 = paramObject3;
    paramCallContext.value4 = paramObject4;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 4;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.srfi69
 * JD-Core Version:    0.6.2
 */