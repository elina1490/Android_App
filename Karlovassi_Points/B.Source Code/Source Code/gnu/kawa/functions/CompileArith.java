package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.InlineCalls;
import gnu.expr.Inlineable;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.Procedure;
import gnu.math.IntNum;

public class CompileArith
  implements Inlineable
{
  public static CompileArith $Mn = new CompileArith(AddOp.$Mn, 2);
  public static CompileArith $Pl = new CompileArith(AddOp.$Pl, 1);
  int op;
  Procedure proc;

  CompileArith(Object paramObject, int paramInt)
  {
    this.proc = ((Procedure)paramObject);
    this.op = paramInt;
  }

  static int adjustReturnKind(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 4) && (paramInt2 <= 7) && (paramInt1 > 0))
      switch (paramInt2)
      {
      case 6:
      default:
      case 4:
      case 5:
      case 7:
      }
    do
    {
      do
      {
        do
          return paramInt1;
        while (paramInt1 > 4);
        return 6;
      }
      while ((paramInt1 > 10) || (paramInt1 == 7));
      return 8;
    }
    while (paramInt1 > 10);
    return 4;
  }

  public static boolean appropriateIntConstant(Expression[] paramArrayOfExpression, int paramInt, InlineCalls paramInlineCalls)
  {
    QuoteExp localQuoteExp = paramInlineCalls.fixIntValue(paramArrayOfExpression[paramInt]);
    if (localQuoteExp != null)
    {
      paramArrayOfExpression[paramInt] = localQuoteExp;
      return true;
    }
    return false;
  }

  public static boolean appropriateLongConstant(Expression[] paramArrayOfExpression, int paramInt, InlineCalls paramInlineCalls)
  {
    QuoteExp localQuoteExp = paramInlineCalls.fixLongValue(paramArrayOfExpression[paramInt]);
    if (localQuoteExp != null)
    {
      paramArrayOfExpression[paramInt] = localQuoteExp;
      return true;
    }
    return false;
  }

  public static CompileArith forBitwise(Object paramObject)
  {
    return new CompileArith(paramObject, ((BitwiseOp)paramObject).op);
  }

  public static CompileArith forDiv(Object paramObject)
  {
    return new CompileArith(paramObject, ((DivideOp)paramObject).op);
  }

  public static CompileArith forMul(Object paramObject)
  {
    return new CompileArith(paramObject, 3);
  }

  public static int getReturnKind(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 >= 9) && (paramInt3 <= 12))
      return paramInt1;
    if ((paramInt1 <= 0) || ((paramInt1 > paramInt2) && (paramInt2 > 0)))
      return paramInt1;
    return paramInt2;
  }

  public static Expression pairwise(Procedure paramProcedure, Expression paramExpression, Expression[] paramArrayOfExpression, InlineCalls paramInlineCalls)
  {
    int i = paramArrayOfExpression.length;
    Object localObject = paramArrayOfExpression[0];
    int j = 1;
    if (j < i)
    {
      Expression[] arrayOfExpression = new Expression[2];
      arrayOfExpression[0] = localObject;
      arrayOfExpression[1] = paramArrayOfExpression[j];
      ApplyExp localApplyExp = new ApplyExp(paramExpression, arrayOfExpression);
      Expression localExpression = paramInlineCalls.maybeInline(localApplyExp, null, paramProcedure);
      if (localExpression != null);
      for (localObject = localExpression; ; localObject = localApplyExp)
      {
        j++;
        break;
      }
    }
    return localObject;
  }

  public static Expression validateApplyAdd(AddOp paramAddOp, ApplyExp paramApplyExp, InlineCalls paramInlineCalls)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if ((arrayOfExpression.length == 1) && (paramAddOp.plusOrMinus < 0))
    {
      Type localType = arrayOfExpression[0].getType();
      if ((localType instanceof PrimType))
      {
        int i = localType.getSignature().charAt(0);
        int j = 0;
        Object localObject = null;
        if (i != 86)
        {
          j = 0;
          localObject = null;
          if (i != 90)
          {
            j = 0;
            localObject = null;
            if (i != 67)
              break label105;
          }
        }
        while (localObject != null)
        {
          return new ApplyExp(PrimProcedure.makeBuiltinUnary(j, (Type)localObject), arrayOfExpression);
          label105: if (i == 68)
          {
            j = 119;
            localObject = LangPrimType.doubleType;
          }
          else if (i == 70)
          {
            j = 118;
            localObject = LangPrimType.floatType;
          }
          else if (i == 74)
          {
            j = 117;
            localObject = LangPrimType.longType;
          }
          else
          {
            j = 116;
            localObject = LangPrimType.intType;
          }
        }
      }
    }
    return paramApplyExp;
  }

  public static Expression validateApplyArithOp(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    int i = ((ArithOp)paramProcedure).op;
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if (arrayOfExpression.length > 2)
      return pairwise(paramProcedure, paramApplyExp.getFunction(), arrayOfExpression, paramInlineCalls);
    Expression localExpression = paramApplyExp.inlineIfConstant(paramProcedure, paramInlineCalls);
    if (localExpression != paramApplyExp)
      return localExpression;
    int m;
    int j;
    int n;
    int k;
    if (arrayOfExpression.length != 2)
    {
      int i1 = arrayOfExpression.length;
      m = 0;
      if (i1 != 1);
    }
    else
    {
      j = Arithmetic.classifyType(arrayOfExpression[0].getType());
      if ((arrayOfExpression.length != 2) || ((i >= 9) && (i <= 12)))
        break label254;
      n = Arithmetic.classifyType(arrayOfExpression[1].getType());
      k = getReturnKind(j, n, i);
      if (k == 4)
      {
        if ((j != 1) || (!appropriateIntConstant(arrayOfExpression, 1, paramInlineCalls)))
          break label188;
        k = 1;
      }
    }
    while (true)
    {
      m = adjustReturnKind(k, i);
      paramApplyExp.setType(Arithmetic.kindType(m));
      if (paramInlineCalls.getCompilation().mustCompile)
        break;
      return paramApplyExp;
      label188: if ((n == 1) && (appropriateIntConstant(arrayOfExpression, 0, paramInlineCalls)))
      {
        k = 1;
      }
      else if ((j == 2) && (appropriateLongConstant(arrayOfExpression, 1, paramInlineCalls)))
      {
        k = 2;
      }
      else if ((n == 2) && (appropriateLongConstant(arrayOfExpression, 0, paramInlineCalls)))
      {
        k = 2;
        continue;
        label254: k = j;
      }
    }
    switch (i)
    {
    case 3:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    default:
    case 1:
    case 2:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 16:
    }
    do
    {
      return paramApplyExp;
      return validateApplyAdd((AddOp)paramProcedure, paramApplyExp, paramInlineCalls);
      return validateApplyDiv((DivideOp)paramProcedure, paramApplyExp, paramInlineCalls);
    }
    while (m <= 0);
    return validateApplyNot(paramApplyExp, m, paramInlineCalls);
  }

  public static Expression validateApplyDiv(DivideOp paramDivideOp, ApplyExp paramApplyExp, InlineCalls paramInlineCalls)
  {
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    if (arrayOfExpression1.length == 1)
    {
      Expression[] arrayOfExpression2 = new Expression[2];
      arrayOfExpression2[0] = QuoteExp.getInstance(IntNum.one());
      arrayOfExpression2[1] = arrayOfExpression1[0];
      paramApplyExp = new ApplyExp(paramApplyExp.getFunction(), arrayOfExpression2);
    }
    return paramApplyExp;
  }

  public static Expression validateApplyNot(ApplyExp paramApplyExp, int paramInt, InlineCalls paramInlineCalls)
  {
    if (paramApplyExp.getArgCount() == 1)
    {
      Expression localExpression = paramApplyExp.getArg(0);
      if ((paramInt == 1) || (paramInt == 2))
      {
        Expression[] arrayOfExpression = new Expression[2];
        arrayOfExpression[0] = localExpression;
        arrayOfExpression[1] = QuoteExp.getInstance(IntNum.minusOne());
        return paramInlineCalls.visitApplyOnly(new ApplyExp(BitwiseOp.xor, arrayOfExpression), null);
      }
      String str;
      if (paramInt == 4)
        str = "gnu.math.BitOps";
      while (str != null)
      {
        return new ApplyExp(ClassType.make(str).getDeclaredMethod("not", 1), paramApplyExp.getArgs());
        if (paramInt == 3)
          str = "java.meth.BigInteger";
        else
          str = null;
      }
    }
    return paramApplyExp;
  }

  public static Expression validateApplyNumberCompare(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression localExpression = paramApplyExp.inlineIfConstant(paramProcedure, paramInlineCalls);
    if (localExpression != paramApplyExp)
      return localExpression;
    return paramApplyExp;
  }

  public static Expression validateApplyNumberPredicate(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    arrayOfExpression[0] = paramInlineCalls.visit(arrayOfExpression[0], LangObjType.integerType);
    paramApplyExp.setType(Type.booleanType);
    return paramApplyExp;
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    int i = arrayOfExpression.length;
    if (i == 0)
    {
      paramCompilation.compileConstant(((ArithOp)this.proc).defaultResult(), paramTarget);
      return;
    }
    if ((i == 1) || ((paramTarget instanceof IgnoreTarget)))
    {
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    int j = Arithmetic.classifyType(arrayOfExpression[0].getType());
    int k = Arithmetic.classifyType(arrayOfExpression[1].getType());
    int m = getReturnKind(j, k, this.op);
    Type localType = Arithmetic.kindType(m);
    if ((m == 0) || (i != 2))
    {
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    int n = Arithmetic.classifyType(paramTarget.getType());
    Object localObject;
    DivideOp localDivideOp;
    label217: LangObjType localLangObjType;
    label271: Method localMethod;
    if (((n == 1) || (n == 2)) && (m >= 1) && (m <= 4))
    {
      m = n;
      if (n == 1)
      {
        localObject = LangPrimType.intType;
        if ((this.op >= 4) && (this.op <= 8))
        {
          localDivideOp = (DivideOp)this.proc;
          if ((localDivideOp.op != 4) || ((m > 4) && (m < 6) && (m > 9)))
            break label440;
        }
        if ((this.op != 4) || (m > 10) || (m == 8) || (m == 7))
          break label601;
        if ((m != 6) && (m <= 4))
          break label581;
        if (m != 6)
          break label573;
        localLangObjType = Arithmetic.typeRatNum;
        localObject = localLangObjType;
        localMethod = localLangObjType.getDeclaredMethod("divide", 2);
        label286: Target localTarget2 = StackTarget.getInstance((Type)localObject);
        arrayOfExpression[0].compile(paramCompilation, localTarget2);
        arrayOfExpression[1].compile(paramCompilation, localTarget2);
        paramCompilation.getCode().emitInvokeStatic(localMethod);
      }
    }
    while (true)
    {
      paramTarget.compileFromStack(paramCompilation, (Type)localObject);
      return;
      localObject = LangPrimType.longType;
      break;
      if (((n == 8) || (n == 7)) && (m > 2) && (m <= 10))
      {
        m = n;
        if (n == 7);
        for (localObject = LangPrimType.floatType; ; localObject = LangPrimType.doubleType)
          break;
      }
      if (m == 7)
      {
        localObject = LangPrimType.floatType;
        break;
      }
      if ((m == 8) || (m == 9))
      {
        m = 8;
        localObject = LangPrimType.doubleType;
        break;
      }
      localObject = localType;
      break;
      label440: if (((localDivideOp.op == 5) && (m <= 10) && (m != 7)) || ((localDivideOp.op == 4) && (m == 10)))
      {
        m = 8;
        break label217;
      }
      if (((localDivideOp.op == 7) || ((localDivideOp.op == 6) && (m <= 4))) && ((localDivideOp.getRoundingMode() == 3) || (m == 4) || (m == 7) || (m == 8) || ((localDivideOp.op == 8) && ((localDivideOp.getRoundingMode() == 3) || (m == 4)))))
        break label217;
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
      label573: localLangObjType = Arithmetic.typeRealNum;
      break label271;
      label581: localObject = Arithmetic.typeIntNum;
      localMethod = Arithmetic.typeRatNum.getDeclaredMethod("make", 2);
      break label286;
      label601: if ((m != 4) || ((this.op != 1) && (this.op != 3) && (this.op != 2) && (this.op != 13) && (this.op != 14) && (this.op != 15) && (this.op != 7) && (this.op != 8) && ((this.op < 9) || (this.op > 11))))
        break label715;
      compileIntNum(arrayOfExpression[0], arrayOfExpression[1], j, k, paramCompilation);
    }
    label715: if ((m == 1) || (m == 2) || (((m == 7) || (m == 8)) && ((this.op <= 8) || (this.op >= 13))))
    {
      Target localTarget1 = StackTarget.getInstance((Type)localObject);
      CodeAttr localCodeAttr = paramCompilation.getCode();
      int i1 = 0;
      if (i1 < i)
      {
        if ((i1 == 1) && (this.op >= 9) && (this.op <= 12))
          localTarget1 = StackTarget.getInstance(Type.intType);
        arrayOfExpression[i1].compile(paramCompilation, localTarget1);
        if (i1 != 0)
          break label836;
      }
      while (true)
      {
        i1++;
        break label775;
        break;
        switch (m)
        {
        case 3:
        case 4:
        case 5:
        case 6:
        default:
          break;
        case 1:
        case 2:
        case 7:
        case 8:
          if (this.op == 9)
          {
            Type[] arrayOfType = new Type[2];
            arrayOfType[0] = localObject;
            arrayOfType[1] = Type.intType;
            localCodeAttr.emitInvokeStatic(ClassType.make("gnu.math.IntNum").getDeclaredMethod("shift", arrayOfType));
          }
          else
          {
            localCodeAttr.emitBinop(primitiveOpcode(), (PrimType)((Type)localObject).getImplementationType());
          }
          break;
        }
      }
    }
    label775: label836: ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }

  public boolean compileIntNum(Expression paramExpression1, Expression paramExpression2, int paramInt1, int paramInt2, Compilation paramCompilation)
  {
    if ((this.op == 2) && ((paramExpression2 instanceof QuoteExp)))
    {
      Object localObject4 = paramExpression2.valueIfConstant();
      long l;
      boolean bool;
      if (paramInt2 <= 2)
      {
        l = ((Number)localObject4).longValue();
        if ((l > -2147483648L) && (l <= 2147483647L))
          bool = true;
      }
      while (bool)
      {
        return $Pl.compileIntNum(paramExpression1, QuoteExp.getInstance(Integer.valueOf((int)-l)), paramInt1, 1, paramCompilation);
        bool = false;
        continue;
        if ((localObject4 instanceof IntNum))
        {
          IntNum localIntNum = (IntNum)localObject4;
          l = localIntNum.longValue();
          bool = localIntNum.inRange(-2147483647L, 2147483647L);
        }
        else
        {
          l = 0L;
          bool = false;
        }
      }
    }
    int i;
    if ((this.op == 1) || (this.op == 3))
    {
      i = 1;
      if (i == 0)
        break label420;
      if (InlineCalls.checkIntValue(paramExpression1) != null)
        paramInt1 = 1;
      if (InlineCalls.checkIntValue(paramExpression2) != null)
        paramInt2 = 1;
      if ((paramInt1 != 1) || (paramInt2 == 1))
        break label232;
    }
    label232: for (int j = 1; ; j = 0)
    {
      if ((j == 0) || ((paramExpression1.side_effects()) && (paramExpression2.side_effects())))
        break label238;
      return compileIntNum(paramExpression2, paramExpression1, paramInt2, paramInt1, paramCompilation);
      i = 0;
      break;
    }
    label238: Object localObject2;
    label248: Object localObject1;
    if (paramInt1 == 1)
    {
      localObject2 = Type.intType;
      if (paramInt2 != 1)
        break label412;
      localObject1 = Type.intType;
    }
    CodeAttr localCodeAttr;
    Type[] arrayOfType;
    Object localObject3;
    while (true)
    {
      paramExpression1.compile(paramCompilation, (Type)localObject2);
      paramExpression2.compile(paramCompilation, (Type)localObject1);
      localCodeAttr = paramCompilation.getCode();
      if (j != 0)
      {
        localCodeAttr.emitSwap();
        localObject2 = Arithmetic.typeIntNum;
        localObject1 = LangPrimType.intType;
      }
      arrayOfType = null;
      localObject3 = Arithmetic.typeIntNum;
      int k = this.op;
      str = null;
      switch (k)
      {
      case 12:
      default:
        throw new Error();
        localObject2 = Arithmetic.typeIntNum;
        break label248;
        label412: localObject1 = Arithmetic.typeIntNum;
        continue;
        label420: if ((this.op >= 9) && (this.op <= 12))
        {
          localObject2 = Arithmetic.typeIntNum;
          localObject1 = Type.intType;
          j = 0;
        }
        else
        {
          localObject1 = Arithmetic.typeIntNum;
          localObject2 = localObject1;
          j = 0;
        }
        break;
      case 1:
      case 2:
      case 3:
      case 13:
      case 14:
      case 15:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 10:
      case 11:
      case 9:
      }
    }
    String str = "add";
    while (true)
    {
      if (arrayOfType == null)
        arrayOfType = new Type[] { localObject2, localObject1 };
      localCodeAttr.emitInvokeStatic(((ObjectType)localObject3).getMethod(str, arrayOfType));
      return true;
      str = "sub";
      arrayOfType = null;
      continue;
      str = "times";
      arrayOfType = null;
      continue;
      str = "and";
      if (str == null)
        str = "ior";
      if (str == null)
        str = "xor";
      localObject3 = ClassType.make("gnu.math.BitOps");
      arrayOfType = null;
      continue;
      if (this.op == 8);
      DivideOp localDivideOp;
      for (str = "remainder"; ; str = "quotient")
      {
        localDivideOp = (DivideOp)this.proc;
        if ((this.op != 8) || (localDivideOp.rounding_mode != 1))
          break label631;
        str = "modulo";
        arrayOfType = null;
        break;
      }
      label631: int m = localDivideOp.rounding_mode;
      arrayOfType = null;
      if (m != 3)
      {
        localCodeAttr.emitPushInt(localDivideOp.rounding_mode);
        arrayOfType = new Type[3];
        arrayOfType[0] = localObject2;
        arrayOfType[1] = localObject1;
        arrayOfType[2] = Type.intType;
        continue;
        if (this.op == 10);
        for (str = "shiftLeft"; ; str = "shiftRight")
        {
          localObject3 = ClassType.make("gnu.kawa.functions.BitwiseOp");
          arrayOfType = null;
          break;
        }
        str = "shift";
        arrayOfType = null;
      }
    }
  }

  public int getReturnKind(Expression[] paramArrayOfExpression)
  {
    int i = paramArrayOfExpression.length;
    if (i == 0)
      return 4;
    int j = 0;
    for (int k = 0; k < i; k++)
    {
      int m = Arithmetic.classifyType(paramArrayOfExpression[k].getType());
      if ((k == 0) || (m == 0) || (m > j))
        j = m;
    }
    return j;
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Arithmetic.kindType(adjustReturnKind(getReturnKind(paramArrayOfExpression), this.op));
  }

  public int primitiveOpcode()
  {
    switch (this.op)
    {
    case 9:
    default:
      return -1;
    case 1:
      return 96;
    case 2:
      return 100;
    case 3:
      return 104;
    case 4:
    case 5:
    case 6:
    case 7:
      return 108;
    case 8:
      return 112;
    case 10:
      return 120;
    case 11:
      return 122;
    case 12:
      return 124;
    case 13:
      return 126;
    case 14:
      return 128;
    case 15:
    }
    return 130;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.CompileArith
 * JD-Core Version:    0.6.2
 */