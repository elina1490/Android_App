package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Format;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;

public class genwrite extends ModuleBody
{
  public static final genwrite $instance;
  static final Char Lit0;
  static final IntNum Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final IntNum Lit15;
  static final IntNum Lit16;
  static final IntNum Lit17;
  static final IntNum Lit18;
  static final IntNum Lit19;
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
  static final SimpleSymbol Lit35 = (SimpleSymbol)new SimpleSymbol("reverse-string-append").readResolve();
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod generic$Mnwrite;
  public static final ModuleMethod reverse$Mnstring$Mnappend;

  static
  {
    Lit34 = (SimpleSymbol)new SimpleSymbol("generic-write").readResolve();
    Lit33 = (SimpleSymbol)new SimpleSymbol("unquote-splicing").readResolve();
    Lit32 = (SimpleSymbol)new SimpleSymbol("unquote").readResolve();
    Lit31 = (SimpleSymbol)new SimpleSymbol("quasiquote").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("quote").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("pp-DO").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("pp-BEGIN").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("pp-LET").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("pp-AND").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("pp-CASE").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("pp-COND").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("pp-IF").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("pp-LAMBDA").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("pp-expr-list").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("pp-expr").readResolve();
    Lit19 = IntNum.make(2);
    Lit18 = IntNum.make(50);
    Lit17 = IntNum.make(1);
    Lit16 = IntNum.make(8);
    Lit15 = IntNum.make(7);
    Lit14 = (SimpleSymbol)new SimpleSymbol("do").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("begin").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("let").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("or").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("and").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("case").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("cond").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("set!").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("if").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("define").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("letrec").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("let*").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("lambda").readResolve();
    Lit1 = IntNum.make(0);
    Lit0 = Char.make(10);
    $instance = new genwrite();
    genwrite localgenwrite = $instance;
    generic$Mnwrite = new ModuleMethod(localgenwrite, 12, Lit34, 16388);
    reverse$Mnstring$Mnappend = new ModuleMethod(localgenwrite, 13, Lit35, 4097);
    $instance.run();
  }

  public genwrite()
  {
    ModuleInfo.register(this);
  }

  public static Object genericWrite(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    frame localframe = new frame();
    localframe.display$Qu = paramObject2;
    localframe.width = paramObject3;
    localframe.output = paramObject4;
    if (localframe.width != Boolean.FALSE)
    {
      CharSequence localCharSequence = strings.makeString(1, Lit0);
      IntNum localIntNum = Lit1;
      frame0 localframe0 = new frame0();
      localframe0.staticLink = localframe;
      Procedure localProcedure1 = localframe0.pp$Mnexpr;
      Procedure localProcedure2 = localframe0.pp$Mnexpr$Mnlist;
      Procedure localProcedure3 = localframe0.pp$MnLAMBDA;
      Procedure localProcedure4 = localframe0.pp$MnIF;
      Procedure localProcedure5 = localframe0.pp$MnCOND;
      Procedure localProcedure6 = localframe0.pp$MnCASE;
      Procedure localProcedure7 = localframe0.pp$MnAND;
      Procedure localProcedure8 = localframe0.pp$MnLET;
      Procedure localProcedure9 = localframe0.pp$MnBEGIN;
      localframe0.pp$MnDO = localframe0.pp$MnDO;
      localframe0.pp$MnBEGIN = localProcedure9;
      localframe0.pp$MnLET = localProcedure8;
      localframe0.pp$MnAND = localProcedure7;
      localframe0.pp$MnCASE = localProcedure6;
      localframe0.pp$MnCOND = localProcedure5;
      localframe0.pp$MnIF = localProcedure4;
      localframe0.pp$MnLAMBDA = localProcedure3;
      localframe0.pp$Mnexpr$Mnlist = localProcedure2;
      localframe0.pp$Mnexpr = localProcedure1;
      return localframe.lambda4out(localCharSequence, localframe0.lambda7pr(paramObject1, localIntNum, Lit1, localframe0.pp$Mnexpr));
    }
    return localframe.lambda5wr(paramObject1, Lit1);
  }

  // ERROR //
  public static Object lambda23revStringAppend(Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 308	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   4: ifeq +197 -> 201
    //   7: getstatic 312	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   10: aload_0
    //   11: invokevirtual 318	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore 4
    //   16: aload 4
    //   18: checkcast 320	java/lang/CharSequence
    //   21: astore 6
    //   23: aload 6
    //   25: invokestatic 324	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   28: istore 7
    //   30: getstatic 327	kawa/lib/lists:cdr	Lgnu/expr/GenericProc;
    //   33: aload_0
    //   34: invokevirtual 318	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: getstatic 333	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   40: aload_1
    //   41: iload 7
    //   43: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokevirtual 342	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: invokestatic 344	gnu/kawa/slib/genwrite:lambda23revStringAppend	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: astore 8
    //   54: getstatic 194	gnu/kawa/slib/genwrite:Lit1	Lgnu/math/IntNum;
    //   57: astore 9
    //   59: getstatic 347	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   62: astore 10
    //   64: getstatic 347	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   67: astore 11
    //   69: aload 8
    //   71: checkcast 320	java/lang/CharSequence
    //   74: astore 13
    //   76: aload 10
    //   78: aload 11
    //   80: aload 13
    //   82: invokestatic 324	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   85: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aload_1
    //   89: invokevirtual 342	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: iload 7
    //   94: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: invokevirtual 342	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: astore 14
    //   102: getstatic 353	kawa/standard/Scheme:numLss	Lgnu/kawa/functions/NumberCompare;
    //   105: aload 9
    //   107: iload 7
    //   109: invokestatic 339	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: invokevirtual 342	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: getstatic 245	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   118: if_acmpeq +80 -> 198
    //   121: aload 8
    //   123: checkcast 355	gnu/lists/CharSeq
    //   126: astore 16
    //   128: aload 14
    //   130: checkcast 357	java/lang/Number
    //   133: invokevirtual 361	java/lang/Number:intValue	()I
    //   136: istore 18
    //   138: aload 4
    //   140: checkcast 320	java/lang/CharSequence
    //   143: astore 20
    //   145: aload 9
    //   147: checkcast 357	java/lang/Number
    //   150: invokevirtual 361	java/lang/Number:intValue	()I
    //   153: istore 22
    //   155: aload 16
    //   157: iload 18
    //   159: aload 20
    //   161: iload 22
    //   163: invokestatic 365	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)C
    //   166: invokestatic 369	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;IC)V
    //   169: getstatic 333	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   172: aload 9
    //   174: getstatic 136	gnu/kawa/slib/genwrite:Lit17	Lgnu/math/IntNum;
    //   177: invokevirtual 342	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: astore 9
    //   182: getstatic 333	gnu/kawa/functions/AddOp:$Pl	Lgnu/kawa/functions/AddOp;
    //   185: aload 14
    //   187: getstatic 136	gnu/kawa/slib/genwrite:Lit17	Lgnu/math/IntNum;
    //   190: invokevirtual 342	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   193: astore 14
    //   195: goto -93 -> 102
    //   198: aload 8
    //   200: areturn
    //   201: aload_1
    //   202: checkcast 357	java/lang/Number
    //   205: invokevirtual 361	java/lang/Number:intValue	()I
    //   208: istore_3
    //   209: iload_3
    //   210: invokestatic 372	kawa/lib/strings:makeString	(I)Ljava/lang/CharSequence;
    //   213: areturn
    //   214: astore 5
    //   216: new 374	gnu/mapping/WrongType
    //   219: dup
    //   220: aload 5
    //   222: ldc_w 376
    //   225: iconst_1
    //   226: aload 4
    //   228: invokespecial 379	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   231: athrow
    //   232: astore 12
    //   234: new 374	gnu/mapping/WrongType
    //   237: dup
    //   238: aload 12
    //   240: ldc_w 376
    //   243: iconst_1
    //   244: aload 8
    //   246: invokespecial 379	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   249: athrow
    //   250: astore 15
    //   252: new 374	gnu/mapping/WrongType
    //   255: dup
    //   256: aload 15
    //   258: ldc_w 381
    //   261: iconst_1
    //   262: aload 8
    //   264: invokespecial 379	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   267: athrow
    //   268: astore 17
    //   270: new 374	gnu/mapping/WrongType
    //   273: dup
    //   274: aload 17
    //   276: ldc_w 381
    //   279: iconst_2
    //   280: aload 14
    //   282: invokespecial 379	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   285: athrow
    //   286: astore 19
    //   288: new 374	gnu/mapping/WrongType
    //   291: dup
    //   292: aload 19
    //   294: ldc_w 383
    //   297: iconst_1
    //   298: aload 4
    //   300: invokespecial 379	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   303: athrow
    //   304: astore 21
    //   306: new 374	gnu/mapping/WrongType
    //   309: dup
    //   310: aload 21
    //   312: ldc_w 383
    //   315: iconst_2
    //   316: aload 9
    //   318: invokespecial 379	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   321: athrow
    //   322: astore_2
    //   323: new 374	gnu/mapping/WrongType
    //   326: dup
    //   327: aload_2
    //   328: ldc_w 385
    //   331: iconst_1
    //   332: aload_1
    //   333: invokespecial 379	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   336: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   16	23	214	java/lang/ClassCastException
    //   69	76	232	java/lang/ClassCastException
    //   121	128	250	java/lang/ClassCastException
    //   128	138	268	java/lang/ClassCastException
    //   138	145	286	java/lang/ClassCastException
    //   145	155	304	java/lang/ClassCastException
    //   201	209	322	java/lang/ClassCastException
  }

  public static Object reverseStringAppend(Object paramObject)
  {
    return lambda23revStringAppend(paramObject, Lit1);
  }

  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (paramModuleMethod.selector == 13)
      return reverseStringAppend(paramObject);
    return super.apply1(paramModuleMethod, paramObject);
  }

  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    if (paramModuleMethod.selector == 12)
      return genericWrite(paramObject1, paramObject2, paramObject3, paramObject4);
    return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 13)
    {
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    }
    return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }

  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (paramModuleMethod.selector == 12)
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

  public final void run(CallContext paramCallContext)
  {
  }

  public class frame extends ModuleBody
  {
    Object display$Qu;
    Object output;
    Object width;

    public static Object lambda1isReadMacro(Object paramObject)
    {
      Object localObject1 = lists.car.apply1(paramObject);
      Object localObject2 = lists.cdr.apply1(paramObject);
      Object localObject3 = Scheme.isEqv.apply2(localObject1, genwrite.Lit30);
      if (localObject3 != Boolean.FALSE)
        if (localObject3 == Boolean.FALSE)
          break label97;
      boolean bool;
      while (true)
      {
        bool = lists.isPair(localObject2);
        if (!bool)
          break label155;
        if (!lists.isNull(lists.cdr.apply1(localObject2)))
          break;
        return Boolean.TRUE;
        Object localObject4 = Scheme.isEqv.apply2(localObject1, genwrite.Lit31);
        if (localObject4 != Boolean.FALSE)
        {
          if (localObject4 != Boolean.FALSE);
        }
        else
          label97: 
          do
          {
            Object localObject5;
            do
            {
              return Boolean.FALSE;
              localObject5 = Scheme.isEqv.apply2(localObject1, genwrite.Lit32);
              if (localObject5 == Boolean.FALSE)
                break;
            }
            while (localObject5 == Boolean.FALSE);
            break;
          }
          while (Scheme.isEqv.apply2(localObject1, genwrite.Lit33) == Boolean.FALSE);
      }
      return Boolean.FALSE;
      label155: if (bool)
        return Boolean.TRUE;
      return Boolean.FALSE;
    }

    public static Object lambda2readMacroBody(Object paramObject)
    {
      return lists.cadr.apply1(paramObject);
    }

    public static Object lambda3readMacroPrefix(Object paramObject)
    {
      Object localObject = lists.car.apply1(paramObject);
      lists.cdr.apply1(paramObject);
      if (Scheme.isEqv.apply2(localObject, genwrite.Lit30) != Boolean.FALSE)
        return "'";
      if (Scheme.isEqv.apply2(localObject, genwrite.Lit31) != Boolean.FALSE)
        return "`";
      if (Scheme.isEqv.apply2(localObject, genwrite.Lit32) != Boolean.FALSE)
        return ",";
      if (Scheme.isEqv.apply2(localObject, genwrite.Lit33) != Boolean.FALSE)
        return ",@";
      return Values.empty;
    }

    public Object lambda4out(Object paramObject1, Object paramObject2)
    {
      Object localObject;
      AddOp localAddOp;
      if (paramObject2 != Boolean.FALSE)
      {
        localObject = Scheme.applyToArgs.apply2(this.output, paramObject1);
        if (localObject != Boolean.FALSE)
          localAddOp = AddOp.$Pl;
      }
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject1;
        return localAddOp.apply2(paramObject2, Integer.valueOf(strings.stringLength(localCharSequence)));
        return localObject;
        return paramObject2;
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, paramObject1);
      }
    }

    public Object lambda5wr(Object paramObject1, Object paramObject2)
    {
      Object localObject3;
      Object localObject2;
      if (lists.isPair(paramObject1))
      {
        if (lambda1isReadMacro(paramObject1) != Boolean.FALSE)
        {
          localObject3 = lambda5wr(lambda2readMacroBody(paramObject1), lambda4out(lambda3readMacroPrefix(paramObject1), paramObject2));
          return localObject3;
        }
        localObject3 = paramObject2;
        localObject2 = paramObject1;
      }
      while (true)
      {
        if (lists.isPair(localObject2))
        {
          Object localObject4 = lists.cdr.apply1(localObject2);
          if (localObject3 != Boolean.FALSE)
            localObject3 = lambda5wr(lists.car.apply1(localObject2), lambda4out("(", localObject3));
          while (localObject3 != Boolean.FALSE)
          {
            if (!lists.isPair(localObject4))
              break label148;
            Object localObject5 = lists.cdr.apply1(localObject4);
            localObject3 = lambda5wr(lists.car.apply1(localObject4), lambda4out(" ", localObject3));
            localObject4 = localObject5;
          }
          break;
          label148: if (lists.isNull(localObject4))
            return lambda4out(")", localObject3);
          return lambda4out(")", lambda5wr(localObject4, lambda4out(" . ", localObject3)));
        }
        return lambda4out("()", localObject3);
        if (lists.isNull(paramObject1))
        {
          localObject3 = paramObject2;
          localObject2 = paramObject1;
          continue;
        }
        if (vectors.isVector(paramObject1));
        try
        {
          FVector localFVector = (FVector)paramObject1;
          LList localLList = vectors.vector$To$List(localFVector);
          Object localObject1 = lambda4out("#", paramObject2);
          localObject2 = localLList;
          localObject3 = localObject1;
          continue;
          Object[] arrayOfObject = new Object[2];
          if (this.display$Qu != Boolean.FALSE);
          for (String str = "~a"; ; str = "~s")
          {
            arrayOfObject[0] = str;
            arrayOfObject[1] = paramObject1;
            return lambda4out(Format.formatToString(0, arrayOfObject), paramObject2);
          }
        }
        catch (ClassCastException localClassCastException)
        {
          throw new WrongType(localClassCastException, "vector->list", 1, paramObject1);
        }
      }
    }
  }

  public class frame0 extends ModuleBody
  {
    Procedure pp$MnAND = new ModuleMethod(this, 8, genwrite.Lit26, 12291);
    Procedure pp$MnBEGIN = new ModuleMethod(this, 10, genwrite.Lit28, 12291);
    Procedure pp$MnCASE = new ModuleMethod(this, 7, genwrite.Lit25, 12291);
    Procedure pp$MnCOND = new ModuleMethod(this, 6, genwrite.Lit24, 12291);
    Procedure pp$MnDO = new ModuleMethod(this, 11, genwrite.Lit29, 12291);
    Procedure pp$MnIF = new ModuleMethod(this, 5, genwrite.Lit23, 12291);
    Procedure pp$MnLAMBDA = new ModuleMethod(this, 4, genwrite.Lit22, 12291);
    Procedure pp$MnLET = new ModuleMethod(this, 9, genwrite.Lit27, 12291);
    Procedure pp$Mnexpr = new ModuleMethod(this, 2, genwrite.Lit20, 12291);
    Procedure pp$Mnexpr$Mnlist = new ModuleMethod(this, 3, genwrite.Lit21, 12291);
    genwrite.frame staticLink;

    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
      case 2:
        return lambda8ppExpr(paramObject1, paramObject2, paramObject3);
      case 3:
        return lambda13ppExprList(paramObject1, paramObject2, paramObject3);
      case 4:
        return lambda14pp$MnLAMBDA(paramObject1, paramObject2, paramObject3);
      case 5:
        return lambda15pp$MnIF(paramObject1, paramObject2, paramObject3);
      case 6:
        return lambda16pp$MnCOND(paramObject1, paramObject2, paramObject3);
      case 7:
        return lambda17pp$MnCASE(paramObject1, paramObject2, paramObject3);
      case 8:
        return lambda18pp$MnAND(paramObject1, paramObject2, paramObject3);
      case 9:
        return lambda19pp$MnLET(paramObject1, paramObject2, paramObject3);
      case 10:
        return lambda20pp$MnBEGIN(paramObject1, paramObject2, paramObject3);
      case 11:
      }
      return lambda21pp$MnDO(paramObject1, paramObject2, paramObject3);
    }

    public Object lambda10ppList(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      Object localObject = this.staticLink.lambda4out("(", paramObject2);
      return lambda11ppDown(paramObject1, localObject, localObject, paramObject3, paramObject4);
    }

    public Object lambda11ppDown(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
    {
      Object localObject1 = paramObject2;
      if (localObject1 != Boolean.FALSE)
      {
        if (lists.isPair(paramObject1))
        {
          Object localObject2 = lists.cdr.apply1(paramObject1);
          if (lists.isNull(localObject2));
          for (Object localObject3 = AddOp.$Pl.apply2(paramObject4, genwrite.Lit17); ; localObject3 = genwrite.Lit1)
          {
            Object localObject4 = lambda7pr(lists.car.apply1(paramObject1), lambda6indent(paramObject3, localObject1), localObject3, paramObject5);
            paramObject1 = localObject2;
            localObject1 = localObject4;
            break;
          }
        }
        if (lists.isNull(paramObject1))
          localObject1 = this.staticLink.lambda4out(")", localObject1);
      }
      else
      {
        return localObject1;
      }
      return this.staticLink.lambda4out(")", lambda7pr(paramObject1, lambda6indent(paramObject3, this.staticLink.lambda4out(".", lambda6indent(paramObject3, localObject1))), AddOp.$Pl.apply2(paramObject4, genwrite.Lit17), paramObject5));
    }

    public Object lambda12ppGeneral(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
    {
      Object localObject1 = lists.car.apply1(paramObject1);
      Object localObject2 = lists.cdr.apply1(paramObject1);
      Object localObject3 = this.staticLink.lambda5wr(localObject1, this.staticLink.lambda4out("(", paramObject2));
      Object localObject6;
      Object localObject7;
      Object localObject8;
      label134: label150: Object localObject20;
      label190: Object localObject9;
      label214: label230: Object localObject14;
      Object localObject15;
      if (paramObject4 != Boolean.FALSE)
      {
        if (!lists.isPair(localObject2))
          break label324;
        Object localObject21 = lists.car.apply1(localObject2);
        localObject2 = lists.cdr.apply1(localObject2);
        Object localObject22 = this.staticLink.lambda5wr(localObject21, this.staticLink.lambda4out(" ", localObject3));
        Object localObject23 = AddOp.$Pl.apply2(paramObject2, genwrite.Lit19);
        Object localObject24 = AddOp.$Pl.apply2(localObject22, genwrite.Lit17);
        localObject6 = localObject23;
        localObject7 = localObject24;
        localObject8 = localObject22;
        if (paramObject5 == Boolean.FALSE)
          break label364;
        if (!lists.isPair(localObject2))
          break label372;
        Object localObject18 = lists.car.apply1(localObject2);
        Object localObject19 = lists.cdr.apply1(localObject2);
        if (!lists.isNull(localObject19))
          break label379;
        localObject20 = AddOp.$Pl.apply2(paramObject3, genwrite.Lit17);
        localObject8 = lambda7pr(localObject18, lambda6indent(localObject7, localObject8), localObject20, paramObject5);
        localObject9 = localObject19;
        if (paramObject6 == Boolean.FALSE)
          break label387;
        if (!lists.isPair(localObject9))
          break label395;
        localObject14 = lists.car.apply1(localObject9);
        localObject15 = lists.cdr.apply1(localObject9);
        if (!lists.isNull(localObject15))
          break label414;
      }
      label387: label395: label414: for (Object localObject16 = AddOp.$Pl.apply2(paramObject3, genwrite.Lit17); ; localObject16 = genwrite.Lit1)
      {
        Object localObject17 = lambda7pr(localObject14, lambda6indent(localObject7, localObject8), localObject16, paramObject6);
        Object localObject12 = localObject6;
        Object localObject11 = localObject15;
        label324: label364: label372: label379: Object localObject10;
        for (Object localObject13 = localObject17; ; localObject13 = localObject10)
        {
          return lambda11ppDown(localObject11, localObject13, localObject12, paramObject3, paramObject7);
          if (paramObject4 != Boolean.FALSE)
            break;
          Object localObject4 = AddOp.$Pl.apply2(paramObject2, genwrite.Lit19);
          Object localObject5 = AddOp.$Pl.apply2(localObject3, genwrite.Lit17);
          localObject6 = localObject4;
          localObject7 = localObject5;
          localObject8 = localObject3;
          break label134;
          if (paramObject5 != Boolean.FALSE)
            break label150;
          localObject9 = localObject2;
          break label214;
          localObject20 = genwrite.Lit1;
          break label190;
          if (paramObject6 != Boolean.FALSE)
            break label230;
          localObject10 = localObject8;
          localObject11 = localObject9;
          localObject12 = localObject6;
        }
      }
    }

    public Object lambda13ppExprList(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      return lambda10ppList(paramObject1, paramObject2, paramObject3, this.pp$Mnexpr);
    }

    public Object lambda14pp$MnLAMBDA(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      return lambda12ppGeneral(paramObject1, paramObject2, paramObject3, Boolean.FALSE, this.pp$Mnexpr$Mnlist, Boolean.FALSE, this.pp$Mnexpr);
    }

    public Object lambda15pp$MnIF(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      return lambda12ppGeneral(paramObject1, paramObject2, paramObject3, Boolean.FALSE, this.pp$Mnexpr, Boolean.FALSE, this.pp$Mnexpr);
    }

    public Object lambda16pp$MnCOND(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      return lambda9ppCall(paramObject1, paramObject2, paramObject3, this.pp$Mnexpr$Mnlist);
    }

    public Object lambda17pp$MnCASE(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      return lambda12ppGeneral(paramObject1, paramObject2, paramObject3, Boolean.FALSE, this.pp$Mnexpr, Boolean.FALSE, this.pp$Mnexpr$Mnlist);
    }

    public Object lambda18pp$MnAND(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      return lambda9ppCall(paramObject1, paramObject2, paramObject3, this.pp$Mnexpr);
    }

    public Object lambda19pp$MnLET(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      Object localObject = lists.cdr.apply1(paramObject1);
      boolean bool1 = lists.isPair(localObject);
      boolean bool2;
      if (bool1)
      {
        bool2 = misc.isSymbol(lists.car.apply1(localObject));
        if (!bool2)
          break label72;
      }
      label72: for (Boolean localBoolean = Boolean.TRUE; ; localBoolean = Boolean.FALSE)
      {
        return lambda12ppGeneral(paramObject1, paramObject2, paramObject3, localBoolean, this.pp$Mnexpr$Mnlist, Boolean.FALSE, this.pp$Mnexpr);
        bool2 = bool1;
        break;
      }
    }

    public Object lambda20pp$MnBEGIN(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      return lambda12ppGeneral(paramObject1, paramObject2, paramObject3, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, this.pp$Mnexpr);
    }

    public Object lambda21pp$MnDO(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      return lambda12ppGeneral(paramObject1, paramObject2, paramObject3, Boolean.FALSE, this.pp$Mnexpr$Mnlist, this.pp$Mnexpr$Mnlist, this.pp$Mnexpr);
    }

    public Object lambda6indent(Object paramObject1, Object paramObject2)
    {
      Object localObject4;
      Object localObject2;
      Object localObject1;
      if (paramObject2 != Boolean.FALSE)
        if (Scheme.numLss.apply2(paramObject1, paramObject2) != Boolean.FALSE)
        {
          localObject4 = this.staticLink.lambda4out(strings.makeString(1, genwrite.Lit0), paramObject2);
          if (localObject4 != Boolean.FALSE)
          {
            localObject2 = genwrite.Lit1;
            localObject1 = paramObject1;
          }
        }
      while (true)
      {
        genwrite.frame localframe;
        if (Scheme.numGrt.apply2(localObject1, genwrite.Lit1) != Boolean.FALSE)
        {
          if (Scheme.numGrt.apply2(localObject1, genwrite.Lit15) != Boolean.FALSE)
          {
            Object localObject3 = AddOp.$Mn.apply2(localObject1, genwrite.Lit16);
            localObject2 = this.staticLink.lambda4out("        ", localObject2);
            localObject1 = localObject3;
            continue;
          }
          localframe = this.staticLink;
        }
        try
        {
          int i = ((Number)localObject1).intValue();
          return localframe.lambda4out(strings.substring("        ", 0, i), localObject2);
          return localObject2;
          return localObject4;
          localObject1 = AddOp.$Mn.apply2(paramObject1, paramObject2);
          localObject2 = paramObject2;
          continue;
          return paramObject2;
        }
        catch (ClassCastException localClassCastException)
        {
          throw new WrongType(localClassCastException, "substring", 3, localObject1);
        }
      }
    }

    public Object lambda7pr(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      genwrite.frame1 localframe1 = new genwrite.frame1();
      localframe1.staticLink = this;
      boolean bool = lists.isPair(paramObject1);
      if (bool)
      {
        if (!bool);
      }
      else
        while (vectors.isVector(paramObject1))
        {
          LList localLList = LList.Empty;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = AddOp.$Pl.apply2(AddOp.$Mn.apply2(AddOp.$Mn.apply2(this.staticLink.width, paramObject2), paramObject3), genwrite.Lit17);
          arrayOfObject[1] = genwrite.Lit18;
          localframe1.left = numbers.min(arrayOfObject);
          localframe1.result = localLList;
          genwrite.genericWrite(paramObject1, this.staticLink.display$Qu, Boolean.FALSE, localframe1.lambda$Fn1);
          if (Scheme.numGrt.apply2(localframe1.left, genwrite.Lit1) == Boolean.FALSE)
            break;
          return this.staticLink.lambda4out(genwrite.reverseStringAppend(localframe1.result), paramObject2);
        }
      return this.staticLink.lambda5wr(paramObject1, paramObject2);
      if (lists.isPair(paramObject1))
        return Scheme.applyToArgs.apply4(paramObject4, paramObject1, paramObject2, paramObject3);
      try
      {
        FVector localFVector = (FVector)paramObject1;
        return lambda10ppList(vectors.vector$To$List(localFVector), this.staticLink.lambda4out("#", paramObject2), paramObject3, this.pp$Mnexpr);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "vector->list", 1, paramObject1);
      }
    }

    public Object lambda8ppExpr(Object paramObject1, Object paramObject2, Object paramObject3)
    {
      if (genwrite.frame.lambda1isReadMacro(paramObject1) != Boolean.FALSE)
        return lambda7pr(genwrite.frame.lambda2readMacroBody(paramObject1), this.staticLink.lambda4out(genwrite.frame.lambda3readMacroPrefix(paramObject1), paramObject2), paramObject3, this.pp$Mnexpr);
      Object localObject1 = lists.car.apply1(paramObject1);
      if (misc.isSymbol(localObject1))
      {
        Object localObject2 = Scheme.isEqv.apply2(localObject1, genwrite.Lit2);
        Object localObject5;
        if (localObject2 != Boolean.FALSE)
        {
          if (localObject2 == Boolean.FALSE)
            break label137;
          localObject5 = this.pp$MnLAMBDA;
        }
        while (true)
        {
          label88: if (localObject5 == Boolean.FALSE)
            break label437;
          return Scheme.applyToArgs.apply4(localObject5, paramObject1, paramObject2, paramObject3);
          Object localObject3 = Scheme.isEqv.apply2(localObject1, genwrite.Lit3);
          if (localObject3 != Boolean.FALSE)
          {
            if (localObject3 != Boolean.FALSE)
              break;
            label137: Object localObject6 = Scheme.isEqv.apply2(localObject1, genwrite.Lit6);
            if (localObject6 == Boolean.FALSE)
              break label227;
            if (localObject6 == Boolean.FALSE)
              break label244;
          }
          label227: 
          while (Scheme.isEqv.apply2(localObject1, genwrite.Lit7) != Boolean.FALSE)
          {
            localObject5 = this.pp$MnIF;
            break label88;
            Object localObject4 = Scheme.isEqv.apply2(localObject1, genwrite.Lit4);
            if (localObject4 != Boolean.FALSE)
            {
              if (localObject4 == Boolean.FALSE)
                break label137;
              break;
            }
            if (Scheme.isEqv.apply2(localObject1, genwrite.Lit5) == Boolean.FALSE)
              break label137;
            break;
          }
          label244: if (Scheme.isEqv.apply2(localObject1, genwrite.Lit8) != Boolean.FALSE)
          {
            localObject5 = this.pp$MnCOND;
          }
          else if (Scheme.isEqv.apply2(localObject1, genwrite.Lit9) != Boolean.FALSE)
          {
            localObject5 = this.pp$MnCASE;
          }
          else
          {
            Object localObject7 = Scheme.isEqv.apply2(localObject1, genwrite.Lit10);
            if (localObject7 != Boolean.FALSE)
            {
              if (localObject7 == Boolean.FALSE);
            }
            else
              while (Scheme.isEqv.apply2(localObject1, genwrite.Lit11) != Boolean.FALSE)
              {
                localObject5 = this.pp$MnAND;
                break;
              }
            if (Scheme.isEqv.apply2(localObject1, genwrite.Lit12) != Boolean.FALSE)
              localObject5 = this.pp$MnLET;
            else if (Scheme.isEqv.apply2(localObject1, genwrite.Lit13) != Boolean.FALSE)
              localObject5 = this.pp$MnBEGIN;
            else if (Scheme.isEqv.apply2(localObject1, genwrite.Lit14) != Boolean.FALSE)
              localObject5 = this.pp$MnDO;
            else
              localObject5 = Boolean.FALSE;
          }
        }
      }
      try
      {
        label437: Symbol localSymbol = (Symbol)localObject1;
        if (strings.stringLength(misc.symbol$To$String(localSymbol)) > 5)
          return lambda12ppGeneral(paramObject1, paramObject2, paramObject3, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, this.pp$Mnexpr);
        return lambda9ppCall(paramObject1, paramObject2, paramObject3, this.pp$Mnexpr);
        return lambda10ppList(paramObject1, paramObject2, paramObject3, this.pp$Mnexpr);
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "symbol->string", 1, localObject1);
      }
    }

    public Object lambda9ppCall(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      Object localObject = this.staticLink.lambda5wr(lists.car.apply1(paramObject1), this.staticLink.lambda4out("(", paramObject2));
      if (paramObject2 != Boolean.FALSE)
        return lambda11ppDown(lists.cdr.apply1(paramObject1), localObject, AddOp.$Pl.apply2(localObject, genwrite.Lit17), paramObject3, paramObject4);
      return paramObject2;
    }

    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
    {
      switch (paramModuleMethod.selector)
      {
      default:
        return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
      case 11:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      case 10:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      case 9:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      case 8:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      case 7:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      case 6:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      case 5:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      case 4:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      case 3:
        paramCallContext.value1 = paramObject1;
        paramCallContext.value2 = paramObject2;
        paramCallContext.value3 = paramObject3;
        paramCallContext.proc = paramModuleMethod;
        paramCallContext.pc = 3;
        return 0;
      case 2:
      }
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.value3 = paramObject3;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 3;
      return 0;
    }
  }

  public class frame1 extends ModuleBody
  {
    final ModuleMethod lambda$Fn1;
    Object left;
    Object result;
    genwrite.frame0 staticLink;

    public frame1()
    {
      this$1 = new ModuleMethod(this, 1, null, 4097);
      this$1.setProperty("source-location", "genwrite.scm:72");
      this.lambda$Fn1 = this$1;
    }

    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (paramModuleMethod.selector == 1)
      {
        if (lambda22(paramObject))
          return Boolean.TRUE;
        return Boolean.FALSE;
      }
      return super.apply1(paramModuleMethod, paramObject);
    }

    boolean lambda22(Object paramObject)
    {
      this.result = lists.cons(paramObject, this.result);
      AddOp localAddOp = AddOp.$Mn;
      Object localObject = this.left;
      try
      {
        CharSequence localCharSequence = (CharSequence)paramObject;
        this.left = localAddOp.apply2(localObject, Integer.valueOf(strings.stringLength(localCharSequence)));
        return ((Boolean)Scheme.numGrt.apply2(this.left, genwrite.Lit1)).booleanValue();
      }
      catch (ClassCastException localClassCastException)
      {
        throw new WrongType(localClassCastException, "string-length", 1, paramObject);
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
 * Qualified Name:     gnu.kawa.slib.genwrite
 * JD-Core Version:    0.6.2
 */