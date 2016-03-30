package gnu.kawa.functions;

import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.ProcedureN;

class CompileTimeContinuation extends ProcedureN
  implements Inlineable
{
  Target blockTarget;
  ExitableBlock exitableBlock;

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    throw new Error("internal error");
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    paramCompilation.getCode();
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    int i = arrayOfExpression.length;
    int j;
    if (((this.blockTarget instanceof IgnoreTarget)) || ((this.blockTarget instanceof ConsumerTarget)))
    {
      j = 1;
      if (j == 0)
        break label90;
    }
    while (true)
    {
      if ((j == 0) && (i != 1))
        break label98;
      for (int k = 0; k < i; k++)
        arrayOfExpression[k].compileWithPosition(paramCompilation, this.blockTarget);
      j = 0;
      break;
      label90: paramTarget.getType();
    }
    label98: AppendValues localAppendValues = AppendValues.appendValues;
    localAppendValues.compile(new ApplyExp(localAppendValues, arrayOfExpression), paramCompilation, this.blockTarget);
    this.exitableBlock.exit();
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Type.neverReturnsType;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.CompileTimeContinuation
 * JD-Core Version:    0.6.2
 */