package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.Invoke;

class SetListExp extends ApplyExp
{
  public SetListExp(Expression paramExpression, Expression[] paramArrayOfExpression)
  {
    super(paramExpression, paramArrayOfExpression);
  }

  public Expression validateApply(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Declaration paramDeclaration)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    if (arrayOfExpression1.length == 2)
    {
      Expression[] arrayOfExpression2 = new Expression[4];
      arrayOfExpression2[0] = getArgs()[0];
      arrayOfExpression2[1] = QuoteExp.getInstance("set");
      arrayOfExpression2[2] = Compilation.makeCoercion(arrayOfExpression1[0], Type.intType);
      arrayOfExpression2[3] = arrayOfExpression1[1];
      return Compilation.makeCoercion(paramInlineCalls.visitApplyOnly(new ApplyExp(Invoke.invoke, arrayOfExpression2), paramType), Type.voidType);
    }
    return paramApplyExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.SetListExp
 * JD-Core Version:    0.6.2
 */