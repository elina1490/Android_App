package gnu.kawa.functions;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberCompare extends ProcedureN
  implements Inlineable
{
  static final int RESULT_EQU = 0;
  static final int RESULT_GRT = 1;
  static final int RESULT_LSS = -1;
  static final int RESULT_NAN = -2;
  static final int RESULT_NEQ = -3;
  public static final int TRUE_IF_EQU = 8;
  public static final int TRUE_IF_GRT = 16;
  public static final int TRUE_IF_LSS = 4;
  public static final int TRUE_IF_NAN = 2;
  public static final int TRUE_IF_NEQ = 1;
  int flags;
  Language language;

  public static boolean $Eq(Object paramObject1, Object paramObject2)
  {
    return apply2(8, paramObject1, paramObject2);
  }

  public static boolean $Eq$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    return ($Eq(paramObject1, paramObject2)) && ($Eq(paramObject2, paramObject3)) && ((paramArrayOfObject.length == 0) || (($Eq(paramObject3, paramArrayOfObject[0])) && (applyN(8, paramArrayOfObject))));
  }

  public static boolean $Gr(Object paramObject1, Object paramObject2)
  {
    return apply2(16, paramObject1, paramObject2);
  }

  public static boolean $Gr$Eq(Object paramObject1, Object paramObject2)
  {
    return apply2(24, paramObject1, paramObject2);
  }

  public static boolean $Gr$Eq$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    return ($Gr$Eq(paramObject1, paramObject2)) && ($Gr$Eq(paramObject2, paramObject3)) && ((paramArrayOfObject.length == 0) || (($Gr$Eq(paramObject3, paramArrayOfObject[0])) && (applyN(24, paramArrayOfObject))));
  }

  public static boolean $Gr$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    return ($Gr(paramObject1, paramObject2)) && ($Gr(paramObject2, paramObject3)) && ((paramArrayOfObject.length == 0) || (($Gr(paramObject3, paramArrayOfObject[0])) && (applyN(16, paramArrayOfObject))));
  }

  public static boolean $Ls(Object paramObject1, Object paramObject2)
  {
    return apply2(4, paramObject1, paramObject2);
  }

  public static boolean $Ls$Eq(Object paramObject1, Object paramObject2)
  {
    return apply2(12, paramObject1, paramObject2);
  }

  public static boolean $Ls$Eq$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    return ($Ls$Eq(paramObject1, paramObject2)) && ($Ls$Eq(paramObject2, paramObject3)) && ((paramArrayOfObject.length == 0) || (($Ls$Eq(paramObject3, paramArrayOfObject[0])) && (applyN(12, paramArrayOfObject))));
  }

  public static boolean $Ls$V(Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    return ($Ls(paramObject1, paramObject2)) && ($Ls(paramObject2, paramObject3)) && ((paramArrayOfObject.length == 0) || (($Ls(paramObject3, paramArrayOfObject[0])) && (applyN(4, paramArrayOfObject))));
  }

  public static boolean apply2(int paramInt, Object paramObject1, Object paramObject2)
  {
    return (paramInt & 1 << 3 + compare(paramObject1, paramObject2, true)) != 0;
  }

  static boolean applyN(int paramInt, Object[] paramArrayOfObject)
  {
    for (int i = 0; i < paramArrayOfObject.length - 1; i++)
      if (!apply2(paramInt, paramArrayOfObject[i], paramArrayOfObject[(i + 1)]))
        return false;
    return true;
  }

  public static boolean applyWithPromotion(int paramInt, Object paramObject1, Object paramObject2)
  {
    return checkCompareCode(compare(paramObject1, paramObject2, false), paramInt);
  }

  public static boolean checkCompareCode(int paramInt1, int paramInt2)
  {
    return (paramInt2 & 1 << paramInt1 + 3) != 0;
  }

  static int classify(Expression paramExpression)
  {
    int i = Arithmetic.classifyType(paramExpression.getType());
    if ((i == 4) && ((paramExpression instanceof QuoteExp)))
    {
      Object localObject = ((QuoteExp)paramExpression).getValue();
      if ((localObject instanceof IntNum))
      {
        int j = ((IntNum)localObject).intLength();
        if (j < 32)
          return 1;
        if (j < 64)
          return 2;
      }
    }
    return i;
  }

  public static int compare(Object paramObject1, int paramInt1, Object paramObject2, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0))
      return -3;
    int i;
    if (paramInt1 < paramInt2)
    {
      i = paramInt2;
      switch (i)
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      }
    }
    do
    {
      return Arithmetic.asNumeric(paramObject1).compare(Arithmetic.asNumeric(paramObject2));
      i = paramInt1;
      break;
      int j = Arithmetic.asInt(paramObject1);
      int k = Arithmetic.asInt(paramObject2);
      if (j < k)
        return -1;
      if (j > k)
        return 1;
      return 0;
      long l1 = Arithmetic.asLong(paramObject1);
      long l2 = Arithmetic.asLong(paramObject2);
      if (l1 < l2)
        return -1;
      if (l1 > l2)
        return 1;
      return 0;
      return Arithmetic.asBigInteger(paramObject1).compareTo(Arithmetic.asBigInteger(paramObject2));
      return IntNum.compare(Arithmetic.asIntNum(paramObject1), Arithmetic.asIntNum(paramObject2));
      return Arithmetic.asBigDecimal(paramObject1).compareTo(Arithmetic.asBigDecimal(paramObject2));
      return RatNum.compare(Arithmetic.asRatNum(paramObject1), Arithmetic.asRatNum(paramObject2));
      if ((!paramBoolean) || ((paramInt1 > 6) && (paramInt2 > 6)))
      {
        float f1 = Arithmetic.asFloat(paramObject1);
        float f2 = Arithmetic.asFloat(paramObject2);
        if (f1 > f2)
          return 1;
        if (f1 < f2)
          return -1;
        if (f1 == f2)
          return 0;
        return -2;
      }
    }
    while ((paramBoolean) && ((paramInt1 <= 6) || (paramInt2 <= 6)));
    double d1 = Arithmetic.asDouble(paramObject1);
    double d2 = Arithmetic.asDouble(paramObject2);
    if (d1 > d2)
      return 1;
    if (d1 < d2)
      return -1;
    if (d1 == d2)
      return 0;
    return -2;
  }

  public static int compare(Object paramObject1, Object paramObject2, boolean paramBoolean)
  {
    return compare(paramObject1, Arithmetic.classifyValue(paramObject1), paramObject2, Arithmetic.classifyValue(paramObject2), paramBoolean);
  }

  public static NumberCompare make(Language paramLanguage, String paramString, int paramInt)
  {
    NumberCompare localNumberCompare = new NumberCompare();
    localNumberCompare.language = paramLanguage;
    localNumberCompare.setName(paramString);
    localNumberCompare.flags = paramInt;
    localNumberCompare.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyNumberCompare");
    return localNumberCompare;
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    return getLanguage().booleanObject(apply2(this.flags, paramObject1, paramObject2));
  }

  public Object applyN(Object[] paramArrayOfObject)
  {
    return getLanguage().booleanObject(applyN(this.flags, paramArrayOfObject));
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if (arrayOfExpression.length == 2)
    {
      Object localObject1 = arrayOfExpression[0];
      Object localObject2 = arrayOfExpression[1];
      int i = classify((Expression)localObject1);
      int j = classify((Expression)localObject2);
      CodeAttr localCodeAttr = paramCompilation.getCode();
      if ((i > 0) && (j > 0) && (i <= 10) && (j <= 10) && ((i != 6) || (j != 6)))
      {
        if (!(paramTarget instanceof ConditionalTarget))
        {
          IfExp.compile(paramApplyExp, QuoteExp.trueExp, QuoteExp.falseExp, paramCompilation, paramTarget);
          return;
        }
        int k = this.flags;
        if (k == 1)
          k = 20;
        Type[] arrayOfType;
        PrimType localPrimType;
        label237: StackTarget localStackTarget;
        ConditionalTarget localConditionalTarget;
        Label localLabel;
        label318: int m;
        if ((i <= 4) && (j <= 4) && ((i > 2) || (j > 2)))
        {
          arrayOfType = new Type[2];
          arrayOfType[0] = Arithmetic.typeIntNum;
          if (j <= 2)
          {
            arrayOfType[1] = Type.longType;
            localObject1 = new ApplyExp(new PrimProcedure(Arithmetic.typeIntNum.getMethod("compare", arrayOfType)), arrayOfExpression);
            IntNum localIntNum = IntNum.zero();
            localObject2 = new QuoteExp(localIntNum);
            j = 1;
            i = j;
          }
        }
        else
        {
          if ((i > 1) || (j > 1))
            break label566;
          localPrimType = Type.intType;
          localStackTarget = new StackTarget(localPrimType);
          localConditionalTarget = (ConditionalTarget)paramTarget;
          if (((localObject1 instanceof QuoteExp)) && (!(localObject2 instanceof QuoteExp)))
          {
            Object localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
            if ((k != 8) && (k != 20))
              k ^= 20;
          }
          if (!localConditionalTarget.trueBranchComesFirst)
            break label594;
          localLabel = localConditionalTarget.ifFalse;
          if (localConditionalTarget.trueBranchComesFirst)
            k ^= 28;
          switch (k)
          {
          default:
            m = 0;
            label395: ((Expression)localObject1).compile(paramCompilation, localStackTarget);
            if ((i <= 1) && (j <= 1) && ((localObject2 instanceof QuoteExp)))
            {
              Object localObject3 = ((QuoteExp)localObject2).getValue();
              if (((localObject3 instanceof IntNum)) && (((IntNum)localObject3).isZero()))
                localCodeAttr.emitGotoIfCompare1(localLabel, m);
            }
            break;
          case 16:
          case 8:
          case 4:
          case 20:
          case 24:
          case 12:
          }
        }
        while (true)
        {
          localConditionalTarget.emitGotoFirstBranch(localCodeAttr);
          return;
          if ((i <= 2) && (((localObject1 instanceof QuoteExp)) || ((localObject2 instanceof QuoteExp)) || ((localObject1 instanceof ReferenceExp)) || ((localObject2 instanceof ReferenceExp))))
          {
            arrayOfType[1] = Type.longType;
            arrayOfExpression = new Expression[2];
            arrayOfExpression[0] = localObject2;
            arrayOfExpression[1] = localObject1;
            if ((k == 8) || (k == 20))
              break;
            k ^= 20;
            break;
          }
          arrayOfType[1] = Arithmetic.typeIntNum;
          break;
          label566: if ((i <= 2) && (j <= 2))
          {
            localPrimType = Type.longType;
            break label237;
          }
          localPrimType = Type.doubleType;
          break label237;
          label594: localLabel = localConditionalTarget.ifTrue;
          break label318;
          m = 157;
          break label395;
          m = 153;
          break label395;
          m = 155;
          break label395;
          m = 154;
          break label395;
          m = 156;
          break label395;
          m = 158;
          break label395;
          ((Expression)localObject2).compile(paramCompilation, localStackTarget);
          localCodeAttr.emitGotoIfCompare2(localLabel, m);
        }
      }
    }
    ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }

  protected final Language getLanguage()
  {
    return this.language;
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Type.booleanType;
  }

  public int numArgs()
  {
    return -4094;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.NumberCompare
 * JD-Core Version:    0.6.2
 */