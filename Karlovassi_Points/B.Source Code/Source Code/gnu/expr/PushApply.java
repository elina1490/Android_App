package gnu.expr;

public class PushApply extends ExpVisitor<Expression, Void>
{
  public static void pushApply(Expression paramExpression)
  {
    new PushApply().visit(paramExpression, null);
  }

  protected Expression defaultValue(Expression paramExpression, Void paramVoid)
  {
    return paramExpression;
  }

  protected Expression update(Expression paramExpression1, Expression paramExpression2)
  {
    return paramExpression2;
  }

  protected Expression visitApplyExp(ApplyExp paramApplyExp, Void paramVoid)
  {
    Expression localExpression1 = paramApplyExp.func;
    if (((localExpression1 instanceof LetExp)) && (!(localExpression1 instanceof FluidLetExp)))
    {
      LetExp localLetExp = (LetExp)localExpression1;
      Expression localExpression2 = localLetExp.body;
      localLetExp.body = paramApplyExp;
      paramApplyExp.func = localExpression2;
      return (Expression)visit(localLetExp, paramVoid);
    }
    if ((localExpression1 instanceof BeginExp))
    {
      BeginExp localBeginExp = (BeginExp)localExpression1;
      Expression[] arrayOfExpression = localBeginExp.exps;
      int i = localBeginExp.exps.length - 1;
      paramApplyExp.func = arrayOfExpression[i];
      arrayOfExpression[i] = paramApplyExp;
      return (Expression)visit(localBeginExp, paramVoid);
    }
    paramApplyExp.visitChildren(this, paramVoid);
    return paramApplyExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.PushApply
 * JD-Core Version:    0.6.2
 */