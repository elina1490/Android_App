package gnu.expr;

public class ResolveNames extends ExpExpVisitor<Void>
{
  protected NameLookup lookup;

  public ResolveNames()
  {
  }

  public ResolveNames(Compilation paramCompilation)
  {
    setContext(paramCompilation);
    this.lookup = paramCompilation.lexical;
  }

  public Declaration lookup(Expression paramExpression, Object paramObject, boolean paramBoolean)
  {
    return this.lookup.lookup(paramObject, paramBoolean);
  }

  protected void push(ScopeExp paramScopeExp)
  {
    this.lookup.push(paramScopeExp);
  }

  public void resolveModule(ModuleExp paramModuleExp)
  {
    Compilation localCompilation = Compilation.setSaveCurrent(this.comp);
    try
    {
      push(paramModuleExp);
      paramModuleExp.visitChildren(this, null);
      return;
    }
    finally
    {
      Compilation.restoreCurrent(localCompilation);
    }
  }

  protected Expression visitLetExp(LetExp paramLetExp, Void paramVoid)
  {
    visitDeclarationTypes(paramLetExp);
    paramLetExp.visitInitializers(this, paramVoid);
    push(paramLetExp);
    paramLetExp.body = ((Expression)visit(paramLetExp.body, paramVoid));
    this.lookup.pop(paramLetExp);
    return paramLetExp;
  }

  protected Expression visitReferenceExp(ReferenceExp paramReferenceExp, Void paramVoid)
  {
    if (paramReferenceExp.getBinding() == null)
    {
      Declaration localDeclaration = lookup(paramReferenceExp, paramReferenceExp.getSymbol(), paramReferenceExp.isProcedureName());
      if (localDeclaration != null)
        paramReferenceExp.setBinding(localDeclaration);
    }
    return paramReferenceExp;
  }

  protected Expression visitScopeExp(ScopeExp paramScopeExp, Void paramVoid)
  {
    visitDeclarationTypes(paramScopeExp);
    push(paramScopeExp);
    paramScopeExp.visitChildren(this, paramVoid);
    this.lookup.pop(paramScopeExp);
    return paramScopeExp;
  }

  protected Expression visitSetExp(SetExp paramSetExp, Void paramVoid)
  {
    if (paramSetExp.binding == null)
    {
      Declaration localDeclaration = lookup(paramSetExp, paramSetExp.getSymbol(), paramSetExp.isFuncDef());
      if (localDeclaration != null)
        localDeclaration.setCanWrite(true);
      paramSetExp.binding = localDeclaration;
    }
    return (Expression)super.visitSetExp(paramSetExp, paramVoid);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ResolveNames
 * JD-Core Version:    0.6.2
 */