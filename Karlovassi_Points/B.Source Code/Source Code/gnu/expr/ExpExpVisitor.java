package gnu.expr;

public abstract class ExpExpVisitor<D> extends ExpVisitor<Expression, D>
{
  protected Expression defaultValue(Expression paramExpression, D paramD)
  {
    return paramExpression;
  }

  protected Expression update(Expression paramExpression1, Expression paramExpression2)
  {
    return paramExpression2;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ExpExpVisitor
 * JD-Core Version:    0.6.2
 */