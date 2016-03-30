package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;

public abstract class ScopeExp extends Expression
{
  static int counter;
  Declaration decls;
  protected int frameSize;
  public int id;
  Declaration last;
  public ScopeExp outer;
  private Scope scope;

  public ScopeExp()
  {
    int i = 1 + counter;
    counter = i;
    this.id = i;
  }

  public static void duplicateDeclarationError(Declaration paramDeclaration1, Declaration paramDeclaration2, Compilation paramCompilation)
  {
    paramCompilation.error('e', paramDeclaration2, "duplicate declaration of '", "'");
    paramCompilation.error('e', paramDeclaration1, "(this is the previous declaration of '", "')");
  }

  public static int nesting(ScopeExp paramScopeExp)
  {
    for (int i = 0; paramScopeExp != null; i++)
      paramScopeExp = paramScopeExp.outer;
    return i;
  }

  public void add(Declaration paramDeclaration)
  {
    if (this.last == null)
      this.decls = paramDeclaration;
    while (true)
    {
      this.last = paramDeclaration;
      paramDeclaration.context = this;
      return;
      this.last.next = paramDeclaration;
    }
  }

  public void add(Declaration paramDeclaration1, Declaration paramDeclaration2)
  {
    if (paramDeclaration1 == null)
    {
      paramDeclaration2.next = this.decls;
      this.decls = paramDeclaration2;
    }
    while (true)
    {
      if (this.last == paramDeclaration1)
        this.last = paramDeclaration2;
      paramDeclaration2.context = this;
      return;
      paramDeclaration2.next = paramDeclaration1.next;
      paramDeclaration1.next = paramDeclaration2;
    }
  }

  public final Declaration addDeclaration(Object paramObject)
  {
    Declaration localDeclaration = new Declaration(paramObject);
    add(localDeclaration);
    return localDeclaration;
  }

  public final Declaration addDeclaration(Object paramObject, Type paramType)
  {
    Declaration localDeclaration = new Declaration(paramObject, paramType);
    add(localDeclaration);
    return localDeclaration;
  }

  public final void addDeclaration(Declaration paramDeclaration)
  {
    add(paramDeclaration);
  }

  public int countDecls()
  {
    int i = 0;
    for (Declaration localDeclaration = firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
      i++;
    return i;
  }

  public int countNonDynamicDecls()
  {
    int i = 0;
    for (Declaration localDeclaration = firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
      if (!localDeclaration.getFlag(268435456L))
        i++;
    return i;
  }

  public LambdaExp currentLambda()
  {
    for (ScopeExp localScopeExp = this; ; localScopeExp = localScopeExp.outer)
    {
      if (localScopeExp == null)
        return null;
      if ((localScopeExp instanceof LambdaExp))
        return (LambdaExp)localScopeExp;
    }
  }

  public ModuleExp currentModule()
  {
    for (ScopeExp localScopeExp = this; ; localScopeExp = localScopeExp.outer)
    {
      if (localScopeExp == null)
        return null;
      if ((localScopeExp instanceof ModuleExp))
        return (ModuleExp)localScopeExp;
    }
  }

  public Declaration firstDecl()
  {
    return this.decls;
  }

  public Declaration getDefine(Object paramObject, char paramChar, Compilation paramCompilation)
  {
    Declaration localDeclaration1 = lookup(paramObject);
    if (localDeclaration1 == null)
      return addDeclaration(paramObject);
    if ((0x10200 & localDeclaration1.flags) != 0L)
    {
      localDeclaration1.flags = (0xFFFEFDFF & localDeclaration1.flags);
      return localDeclaration1;
    }
    Declaration localDeclaration2 = addDeclaration(paramObject);
    duplicateDeclarationError(localDeclaration1, localDeclaration2, paramCompilation);
    return localDeclaration2;
  }

  public Declaration getNoDefine(Object paramObject)
  {
    Declaration localDeclaration = lookup(paramObject);
    if (localDeclaration == null)
    {
      localDeclaration = addDeclaration(paramObject);
      localDeclaration.flags = (0x10200 | localDeclaration.flags);
    }
    return localDeclaration;
  }

  public Scope getVarScope()
  {
    Scope localScope = this.scope;
    if (localScope == null)
    {
      localScope = new Scope();
      this.scope = localScope;
    }
    return localScope;
  }

  public Declaration lookup(Object paramObject)
  {
    if (paramObject != null)
      for (Declaration localDeclaration = firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
        if (paramObject.equals(localDeclaration.symbol))
          return localDeclaration;
    return null;
  }

  public Declaration lookup(Object paramObject, Language paramLanguage, int paramInt)
  {
    for (Declaration localDeclaration = firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
      if ((paramObject.equals(localDeclaration.symbol)) && (paramLanguage.hasNamespace(localDeclaration, paramInt)))
        return localDeclaration;
    return null;
  }

  public boolean nestedIn(ScopeExp paramScopeExp)
  {
    for (ScopeExp localScopeExp = this; localScopeExp != null; localScopeExp = localScopeExp.outer)
      if (localScopeExp == paramScopeExp)
        return true;
    return false;
  }

  public void popScope(CodeAttr paramCodeAttr)
  {
    for (Declaration localDeclaration = firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
      localDeclaration.var = null;
    paramCodeAttr.popScope();
    this.scope = null;
  }

  public void remove(Declaration paramDeclaration)
  {
    Object localObject = null;
    for (Declaration localDeclaration = firstDecl(); ; localDeclaration = localDeclaration.nextDecl())
    {
      if (localDeclaration != null)
      {
        if (localDeclaration == paramDeclaration)
          remove((Declaration)localObject, paramDeclaration);
      }
      else
        return;
      localObject = localDeclaration;
    }
  }

  public void remove(Declaration paramDeclaration1, Declaration paramDeclaration2)
  {
    if (paramDeclaration1 == null)
      this.decls = paramDeclaration2.next;
    while (true)
    {
      if (this.last == paramDeclaration2)
        this.last = paramDeclaration1;
      return;
      paramDeclaration1.next = paramDeclaration2.next;
    }
  }

  public void replaceFollowing(Declaration paramDeclaration1, Declaration paramDeclaration2)
  {
    Declaration localDeclaration;
    if (paramDeclaration1 == null)
    {
      localDeclaration = this.decls;
      this.decls = paramDeclaration2;
    }
    while (true)
    {
      paramDeclaration2.next = localDeclaration.next;
      if (this.last == localDeclaration)
        this.last = paramDeclaration2;
      localDeclaration.next = null;
      paramDeclaration2.context = this;
      return;
      localDeclaration = paramDeclaration1.next;
      paramDeclaration1.next = paramDeclaration2;
    }
  }

  protected void setIndexes()
  {
    Declaration localDeclaration = firstDecl();
    int j;
    for (int i = 0; localDeclaration != null; i = j)
    {
      j = i + 1;
      localDeclaration.evalIndex = i;
      localDeclaration = localDeclaration.nextDecl();
    }
    this.frameSize = i;
  }

  public String toString()
  {
    return getClass().getName() + "#" + this.id;
  }

  public ScopeExp topLevel()
  {
    ScopeExp localScopeExp;
    for (Object localObject = this; ; localObject = localScopeExp)
    {
      localScopeExp = ((ScopeExp)localObject).outer;
      if ((localScopeExp == null) || ((localScopeExp instanceof ModuleExp)))
        return localObject;
    }
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitScopeExp(this, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ScopeExp
 * JD-Core Version:    0.6.2
 */