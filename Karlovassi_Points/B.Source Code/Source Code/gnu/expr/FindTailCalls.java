package gnu.expr;

import gnu.bytecode.Type;
import gnu.kawa.functions.AppendValues;
import java.util.HashSet;
import java.util.Set;

public class FindTailCalls extends ExpExpVisitor<Expression>
{
  public static void findTailCalls(Expression paramExpression, Compilation paramCompilation)
  {
    FindTailCalls localFindTailCalls = new FindTailCalls();
    localFindTailCalls.setContext(paramCompilation);
    localFindTailCalls.visit(paramExpression, paramExpression);
  }

  public void postVisitDecls(ScopeExp paramScopeExp)
  {
    for (Declaration localDeclaration1 = paramScopeExp.firstDecl(); localDeclaration1 != null; localDeclaration1 = localDeclaration1.nextDecl())
    {
      Expression localExpression = localDeclaration1.getValue();
      if ((localExpression instanceof LambdaExp))
      {
        LambdaExp localLambdaExp = (LambdaExp)localExpression;
        if (localDeclaration1.getCanRead())
          localLambdaExp.setCanRead(true);
        if (localDeclaration1.getCanCall())
          localLambdaExp.setCanCall(true);
      }
      if ((localDeclaration1.getFlag(1024L)) && ((localExpression instanceof ReferenceExp)))
      {
        Declaration localDeclaration2 = ((ReferenceExp)localExpression).contextDecl();
        if ((localDeclaration2 != null) && (localDeclaration2.isPrivate()))
          localDeclaration2.setFlag(524288L);
      }
    }
  }

  protected Expression visitApplyExp(ApplyExp paramApplyExp, Expression paramExpression)
  {
    int i;
    LambdaExp localLambdaExp;
    if (paramExpression == this.currentLambda.body)
    {
      i = 1;
      if (i != 0)
        paramApplyExp.setTailCall(true);
      paramApplyExp.context = this.currentLambda;
      if (!(paramApplyExp.func instanceof ReferenceExp))
        break label175;
      Declaration localDeclaration = Declaration.followAliases(((ReferenceExp)paramApplyExp.func).binding);
      localLambdaExp = null;
      if (localDeclaration != null)
      {
        if (!localDeclaration.getFlag(2048L))
        {
          paramApplyExp.nextCall = localDeclaration.firstCall;
          localDeclaration.firstCall = paramApplyExp;
        }
        Compilation localCompilation = getCompilation();
        localDeclaration.setCanCall();
        if (!localCompilation.mustCompile)
          localDeclaration.setCanRead();
        Expression localExpression = localDeclaration.getValue();
        boolean bool = localExpression instanceof LambdaExp;
        localLambdaExp = null;
        if (bool)
          localLambdaExp = (LambdaExp)localExpression;
      }
      label142: if ((localLambdaExp != null) && (localLambdaExp.returnContinuation != paramExpression))
        break label274;
    }
    while (true)
    {
      paramApplyExp.args = visitExps(paramApplyExp.args);
      return paramApplyExp;
      i = 0;
      break;
      label175: if (((paramApplyExp.func instanceof LambdaExp)) && (!(paramApplyExp.func instanceof ClassExp)))
      {
        localLambdaExp = (LambdaExp)paramApplyExp.func;
        visitLambdaExp(localLambdaExp, false);
        localLambdaExp.setCanCall(true);
        break label142;
      }
      if (((paramApplyExp.func instanceof QuoteExp)) && (((QuoteExp)paramApplyExp.func).getValue() == AppendValues.appendValues))
      {
        localLambdaExp = null;
        break label142;
      }
      paramApplyExp.func = visitExpression(paramApplyExp.func, paramApplyExp.func);
      localLambdaExp = null;
      break label142;
      label274: if ((localLambdaExp != this.currentLambda) || (i == 0))
        if (i != 0)
        {
          if (localLambdaExp.tailCallers == null)
            localLambdaExp.tailCallers = new HashSet();
          localLambdaExp.tailCallers.add(this.currentLambda);
        }
        else if (localLambdaExp.returnContinuation == null)
        {
          localLambdaExp.returnContinuation = paramExpression;
          localLambdaExp.inlineHome = this.currentLambda;
        }
        else
        {
          localLambdaExp.returnContinuation = LambdaExp.unknownContinuation;
          localLambdaExp.inlineHome = null;
        }
    }
  }

  protected Expression visitBeginExp(BeginExp paramBeginExp, Expression paramExpression)
  {
    int i = paramBeginExp.length - 1;
    int j = 0;
    if (j <= i)
    {
      Expression[] arrayOfExpression = paramBeginExp.exps;
      Expression localExpression1 = paramBeginExp.exps[j];
      if (j == i);
      for (Expression localExpression2 = paramExpression; ; localExpression2 = paramBeginExp.exps[j])
      {
        arrayOfExpression[j] = ((Expression)localExpression1.visit(this, localExpression2));
        j++;
        break;
      }
    }
    return paramBeginExp;
  }

  protected Expression visitBlockExp(BlockExp paramBlockExp, Expression paramExpression)
  {
    paramBlockExp.body = ((Expression)paramBlockExp.body.visit(this, paramExpression));
    if (paramBlockExp.exitBody != null)
      paramBlockExp.exitBody = ((Expression)paramBlockExp.exitBody.visit(this, paramBlockExp.exitBody));
    return paramBlockExp;
  }

  protected Expression visitClassExp(ClassExp paramClassExp, Expression paramExpression)
  {
    LambdaExp localLambdaExp1 = this.currentLambda;
    this.currentLambda = paramClassExp;
    try
    {
      for (LambdaExp localLambdaExp2 = paramClassExp.firstChild; (localLambdaExp2 != null) && (this.exitValue == null); localLambdaExp2 = localLambdaExp2.nextSibling)
        visitLambdaExp(localLambdaExp2, false);
      return paramClassExp;
    }
    finally
    {
      this.currentLambda = localLambdaExp1;
    }
  }

  protected Expression visitExpression(Expression paramExpression1, Expression paramExpression2)
  {
    return (Expression)super.visitExpression(paramExpression1, paramExpression1);
  }

  public Expression[] visitExps(Expression[] paramArrayOfExpression)
  {
    int i = paramArrayOfExpression.length;
    for (int j = 0; j < i; j++)
    {
      Expression localExpression = paramArrayOfExpression[j];
      paramArrayOfExpression[j] = ((Expression)visit(localExpression, localExpression));
    }
    return paramArrayOfExpression;
  }

  protected Expression visitFluidLetExp(FluidLetExp paramFluidLetExp, Expression paramExpression)
  {
    for (Declaration localDeclaration = paramFluidLetExp.firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
    {
      localDeclaration.setCanRead(true);
      if (localDeclaration.base != null)
        localDeclaration.base.setCanRead(true);
    }
    visitLetDecls(paramFluidLetExp);
    paramFluidLetExp.body = ((Expression)paramFluidLetExp.body.visit(this, paramFluidLetExp.body));
    postVisitDecls(paramFluidLetExp);
    return paramFluidLetExp;
  }

  protected Expression visitIfExp(IfExp paramIfExp, Expression paramExpression)
  {
    paramIfExp.test = ((Expression)paramIfExp.test.visit(this, paramIfExp.test));
    paramIfExp.then_clause = ((Expression)paramIfExp.then_clause.visit(this, paramExpression));
    Expression localExpression = paramIfExp.else_clause;
    if (localExpression != null)
      paramIfExp.else_clause = ((Expression)localExpression.visit(this, paramExpression));
    return paramIfExp;
  }

  protected Expression visitLambdaExp(LambdaExp paramLambdaExp, Expression paramExpression)
  {
    visitLambdaExp(paramLambdaExp, true);
    return paramLambdaExp;
  }

  final void visitLambdaExp(LambdaExp paramLambdaExp, boolean paramBoolean)
  {
    LambdaExp localLambdaExp = this.currentLambda;
    this.currentLambda = paramLambdaExp;
    if (paramBoolean)
      paramLambdaExp.setCanRead(true);
    try
    {
      if (paramLambdaExp.defaultArgs != null)
        paramLambdaExp.defaultArgs = visitExps(paramLambdaExp.defaultArgs);
      Expression localExpression;
      if ((this.exitValue == null) && (paramLambdaExp.body != null))
      {
        localExpression = paramLambdaExp.body;
        if (!paramLambdaExp.getInlineOnly())
          break label94;
      }
      label94: for (Object localObject2 = paramLambdaExp; ; localObject2 = paramLambdaExp.body)
      {
        paramLambdaExp.body = ((Expression)localExpression.visit(this, localObject2));
        this.currentLambda = localLambdaExp;
        postVisitDecls(paramLambdaExp);
        return;
      }
    }
    finally
    {
      this.currentLambda = localLambdaExp;
    }
  }

  void visitLetDecls(LetExp paramLetExp)
  {
    Declaration localDeclaration = paramLetExp.firstDecl();
    int i = paramLetExp.inits.length;
    int j = 0;
    while (j < i)
    {
      Object localObject = visitSetExp(localDeclaration, paramLetExp.inits[j]);
      if (localObject == QuoteExp.undefined_exp)
      {
        Expression localExpression = localDeclaration.getValue();
        if (((localExpression instanceof LambdaExp)) || ((localExpression != localObject) && ((localExpression instanceof QuoteExp))))
          localObject = localExpression;
      }
      paramLetExp.inits[j] = localObject;
      j++;
      localDeclaration = localDeclaration.nextDecl();
    }
  }

  protected Expression visitLetExp(LetExp paramLetExp, Expression paramExpression)
  {
    visitLetDecls(paramLetExp);
    paramLetExp.body = ((Expression)paramLetExp.body.visit(this, paramExpression));
    postVisitDecls(paramLetExp);
    return paramLetExp;
  }

  protected Expression visitReferenceExp(ReferenceExp paramReferenceExp, Expression paramExpression)
  {
    Declaration localDeclaration1 = Declaration.followAliases(paramReferenceExp.binding);
    if (localDeclaration1 != null)
    {
      Type localType = localDeclaration1.type;
      if ((localType != null) && (localType.isVoid()))
        return QuoteExp.voidExp;
      localDeclaration1.setCanRead(true);
    }
    Declaration localDeclaration2 = paramReferenceExp.contextDecl();
    if (localDeclaration2 != null)
      localDeclaration2.setCanRead(true);
    return paramReferenceExp;
  }

  final Expression visitSetExp(Declaration paramDeclaration, Expression paramExpression)
  {
    if ((paramDeclaration != null) && (paramDeclaration.getValue() == paramExpression) && ((paramExpression instanceof LambdaExp)) && (!(paramExpression instanceof ClassExp)) && (!paramDeclaration.isPublic()))
    {
      LambdaExp localLambdaExp = (LambdaExp)paramExpression;
      visitLambdaExp(localLambdaExp, false);
      return localLambdaExp;
    }
    return (Expression)paramExpression.visit(this, paramExpression);
  }

  protected Expression visitSetExp(SetExp paramSetExp, Expression paramExpression)
  {
    Declaration localDeclaration1 = paramSetExp.binding;
    if ((localDeclaration1 != null) && (localDeclaration1.isAlias()))
    {
      if (paramSetExp.isDefining())
      {
        paramSetExp.new_value = ((Expression)paramSetExp.new_value.visit(this, paramSetExp.new_value));
        return paramSetExp;
      }
      localDeclaration1 = Declaration.followAliases(localDeclaration1);
    }
    Declaration localDeclaration2 = paramSetExp.contextDecl();
    if (localDeclaration2 != null)
      localDeclaration2.setCanRead(true);
    Expression localExpression = visitSetExp(localDeclaration1, paramSetExp.new_value);
    if ((localDeclaration1 != null) && ((localDeclaration1.context instanceof LetExp)) && (localExpression == localDeclaration1.getValue()) && (((localExpression instanceof LambdaExp)) || ((localExpression instanceof QuoteExp))))
      return QuoteExp.voidExp;
    paramSetExp.new_value = localExpression;
    return paramSetExp;
  }

  protected Expression visitSynchronizedExp(SynchronizedExp paramSynchronizedExp, Expression paramExpression)
  {
    paramSynchronizedExp.object = ((Expression)paramSynchronizedExp.object.visit(this, paramSynchronizedExp.object));
    paramSynchronizedExp.body = ((Expression)paramSynchronizedExp.body.visit(this, paramSynchronizedExp.body));
    return paramSynchronizedExp;
  }

  protected Expression visitTryExp(TryExp paramTryExp, Expression paramExpression)
  {
    Expression localExpression1;
    CatchClause localCatchClause;
    if (paramTryExp.finally_clause == null)
    {
      localExpression1 = paramExpression;
      paramTryExp.try_clause = ((Expression)paramTryExp.try_clause.visit(this, localExpression1));
      localCatchClause = paramTryExp.catch_clauses;
      label31: if ((this.exitValue != null) || (localCatchClause == null))
        break label100;
      if (paramTryExp.finally_clause != null)
        break label90;
    }
    label90: for (Expression localExpression3 = paramExpression; ; localExpression3 = localCatchClause.body)
    {
      localCatchClause.body = ((Expression)localCatchClause.body.visit(this, localExpression3));
      localCatchClause = localCatchClause.getNext();
      break label31;
      localExpression1 = paramTryExp.try_clause;
      break;
    }
    label100: Expression localExpression2 = paramTryExp.finally_clause;
    if (localExpression2 != null)
      paramTryExp.finally_clause = ((Expression)localExpression2.visit(this, localExpression2));
    return paramTryExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.FindTailCalls
 * JD-Core Version:    0.6.2
 */