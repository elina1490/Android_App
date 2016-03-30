package gnu.expr;

public class ChainLambdas extends ExpExpVisitor<ScopeExp>
{
  public static void chainLambdas(Expression paramExpression, Compilation paramCompilation)
  {
    ChainLambdas localChainLambdas = new ChainLambdas();
    localChainLambdas.setContext(paramCompilation);
    localChainLambdas.visit(paramExpression, null);
  }

  protected Expression visitClassExp(ClassExp paramClassExp, ScopeExp paramScopeExp)
  {
    LambdaExp localLambdaExp = this.currentLambda;
    if ((localLambdaExp != null) && (!(localLambdaExp instanceof ClassExp)))
    {
      paramClassExp.nextSibling = localLambdaExp.firstChild;
      localLambdaExp.firstChild = paramClassExp;
    }
    visitScopeExp(paramClassExp, paramScopeExp);
    return paramClassExp;
  }

  protected Expression visitLambdaExp(LambdaExp paramLambdaExp, ScopeExp paramScopeExp)
  {
    LambdaExp localLambdaExp1 = this.currentLambda;
    if ((localLambdaExp1 != null) && (!(localLambdaExp1 instanceof ClassExp)))
    {
      paramLambdaExp.nextSibling = localLambdaExp1.firstChild;
      localLambdaExp1.firstChild = paramLambdaExp;
    }
    paramLambdaExp.outer = paramScopeExp;
    paramLambdaExp.firstChild = null;
    paramLambdaExp.visitChildrenOnly(this, paramLambdaExp);
    paramLambdaExp.visitProperties(this, paramLambdaExp);
    Object localObject1 = null;
    LambdaExp localLambdaExp2;
    for (Object localObject2 = paramLambdaExp.firstChild; localObject2 != null; localObject2 = localLambdaExp2)
    {
      localLambdaExp2 = ((LambdaExp)localObject2).nextSibling;
      ((LambdaExp)localObject2).nextSibling = localObject1;
      localObject1 = localObject2;
    }
    paramLambdaExp.firstChild = localObject1;
    if ((paramLambdaExp.getName() == null) && (paramLambdaExp.nameDecl != null))
      paramLambdaExp.setName(paramLambdaExp.nameDecl.getName());
    paramLambdaExp.setIndexes();
    if (paramLambdaExp.mustCompile())
      this.comp.mustCompileHere();
    return paramLambdaExp;
  }

  protected Expression visitScopeExp(ScopeExp paramScopeExp1, ScopeExp paramScopeExp2)
  {
    paramScopeExp1.outer = paramScopeExp2;
    paramScopeExp1.visitChildren(this, paramScopeExp1);
    paramScopeExp1.setIndexes();
    if (paramScopeExp1.mustCompile())
      this.comp.mustCompileHere();
    return paramScopeExp1;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ChainLambdas
 * JD-Core Version:    0.6.2
 */