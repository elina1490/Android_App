package gnu.kawa.functions;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.math.IntNum;

public class NumberPredicate extends Procedure1
  implements Inlineable
{
  public static final int EVEN = 2;
  public static final int ODD = 1;
  Language language;
  final int op;

  public NumberPredicate(Language paramLanguage, String paramString, int paramInt)
  {
    super(paramString);
    this.language = paramLanguage;
    this.op = paramInt;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyNumberPredicate");
  }

  public Object apply1(Object paramObject)
  {
    IntNum localIntNum = LangObjType.coerceIntNum(paramObject);
    switch (this.op)
    {
    default:
      throw new Error();
    case 1:
      bool = localIntNum.isOdd();
      return getLanguage().booleanObject(bool);
    case 2:
    }
    if (!localIntNum.isOdd());
    for (boolean bool = true; ; bool = false)
      break;
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if ((arrayOfExpression.length == 1) && ((this.op == 1) || (this.op == 2)))
    {
      Expression localExpression = arrayOfExpression[0];
      if (Arithmetic.classifyType(localExpression.getType()) <= 4)
      {
        Target localTarget = StackTarget.getInstance(Type.intType);
        CodeAttr localCodeAttr = paramCompilation.getCode();
        if (this.op == 2)
          localCodeAttr.emitPushInt(1);
        localExpression.compile(paramCompilation, localTarget);
        localCodeAttr.emitPushInt(1);
        localCodeAttr.emitAnd();
        if (this.op == 2)
          localCodeAttr.emitSub(Type.intType);
        paramTarget.compileFromStack(paramCompilation, Type.booleanType);
        return;
      }
    }
    ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }

  protected final Language getLanguage()
  {
    return this.language;
  }

  public int numArgs()
  {
    return 4097;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.NumberPredicate
 * JD-Core Version:    0.6.2
 */