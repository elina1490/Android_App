package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.KeyPair;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindCapturedVars extends ExpExpVisitor<Void>
{
  int backJumpPossible = 0;
  ModuleExp currentModule = null;
  Hashtable unknownDecls = null;

  static Expression checkInlineable(LambdaExp paramLambdaExp, Set<LambdaExp> paramSet)
  {
    if (paramLambdaExp.returnContinuation == LambdaExp.unknownContinuation)
      return paramLambdaExp.returnContinuation;
    if (paramSet.contains(paramLambdaExp))
      return paramLambdaExp.returnContinuation;
    if ((paramLambdaExp.getCanRead()) || (paramLambdaExp.isClassMethod()) || (paramLambdaExp.min_args != paramLambdaExp.max_args))
    {
      paramLambdaExp.returnContinuation = LambdaExp.unknownContinuation;
      return LambdaExp.unknownContinuation;
    }
    paramSet.add(paramLambdaExp);
    Object localObject = paramLambdaExp.returnContinuation;
    if (paramLambdaExp.tailCallers != null)
    {
      Iterator localIterator = paramLambdaExp.tailCallers.iterator();
      while (localIterator.hasNext())
      {
        LambdaExp localLambdaExp1 = (LambdaExp)localIterator.next();
        Expression localExpression = checkInlineable(localLambdaExp1, paramSet);
        if (localExpression == LambdaExp.unknownContinuation)
        {
          if ((localObject == null) || (localObject == localLambdaExp1.body))
          {
            localObject = localLambdaExp1.body;
            paramLambdaExp.inlineHome = localLambdaExp1;
          }
          else
          {
            paramLambdaExp.returnContinuation = LambdaExp.unknownContinuation;
            return localExpression;
          }
        }
        else if (localObject == null)
        {
          localObject = localExpression;
          if (paramLambdaExp.inlineHome == null)
          {
            if (paramLambdaExp.nestedIn(localLambdaExp1));
            for (LambdaExp localLambdaExp2 = localLambdaExp1; ; localLambdaExp2 = localLambdaExp1.inlineHome)
            {
              paramLambdaExp.inlineHome = localLambdaExp2;
              break;
            }
          }
        }
        else if (((localExpression != null) && (localObject != localExpression)) || (paramLambdaExp.getFlag(32)))
        {
          paramLambdaExp.returnContinuation = LambdaExp.unknownContinuation;
          return LambdaExp.unknownContinuation;
        }
      }
    }
    return localObject;
  }

  public static void findCapturedVars(Expression paramExpression, Compilation paramCompilation)
  {
    FindCapturedVars localFindCapturedVars = new FindCapturedVars();
    localFindCapturedVars.setContext(paramCompilation);
    paramExpression.visit(localFindCapturedVars, null);
  }

  Declaration allocUnboundDecl(Object paramObject, boolean paramBoolean)
  {
    Object localObject = paramObject;
    if ((paramBoolean) && ((paramObject instanceof Symbol)))
    {
      if (!getCompilation().getLanguage().hasSeparateFunctionNamespace())
        paramBoolean = false;
    }
    else
    {
      if (this.unknownDecls != null)
        break label164;
      this.unknownDecls = new Hashtable(100);
    }
    label164: for (Declaration localDeclaration = null; ; localDeclaration = (Declaration)this.unknownDecls.get(localObject))
    {
      if (localDeclaration == null)
      {
        localDeclaration = this.currentModule.addDeclaration(paramObject);
        localDeclaration.setSimple(false);
        localDeclaration.setPrivate(true);
        if (paramBoolean)
          localDeclaration.setProcedureDecl(true);
        if (this.currentModule.isStatic())
          localDeclaration.setFlag(2048L);
        localDeclaration.setCanRead(true);
        localDeclaration.setCanWrite(true);
        localDeclaration.setFlag(327680L);
        localDeclaration.setIndirectBinding(true);
        this.unknownDecls.put(localObject, localDeclaration);
      }
      return localDeclaration;
      localObject = new KeyPair((Symbol)paramObject, EnvironmentKey.FUNCTION);
      break;
    }
  }

  public void capture(Declaration paramDeclaration)
  {
    if ((!paramDeclaration.getCanRead()) && (!paramDeclaration.getCanCall()));
    label14: LambdaExp localLambdaExp1;
    LambdaExp localLambdaExp2;
    label198: LambdaExp localLambdaExp4;
    label220: label356: 
    do
    {
      do
      {
        break label14;
        do
          return;
        while (((paramDeclaration.field != null) && (paramDeclaration.field.getStaticFlag())) || ((this.comp.immediate) && (paramDeclaration.hasConstantValue())));
        localLambdaExp1 = getCurrentLambda();
        ScopeExp localScopeExp1 = paramDeclaration.getContext();
        if (localScopeExp1 == null)
          throw new Error("null context for " + paramDeclaration + " curL:" + localLambdaExp1);
        localLambdaExp2 = localScopeExp1.currentLambda();
        Object localObject = null;
        for (LambdaExp localLambdaExp3 = null; (localLambdaExp1 != localLambdaExp2) && (localLambdaExp1.getInlineOnly()); localLambdaExp3 = localLambdaExp3.nextSibling)
        {
          LambdaExp localLambdaExp9 = localLambdaExp1.outerLambda();
          if (localLambdaExp9 != localObject)
          {
            localLambdaExp3 = localLambdaExp9.firstChild;
            localObject = localLambdaExp9;
          }
          if ((localLambdaExp3 == null) || (localLambdaExp1.inlineHome == null))
          {
            localLambdaExp1.setCanCall(false);
            return;
          }
          localLambdaExp1 = localLambdaExp1.getCaller();
        }
        if (!this.comp.usingCPStyle())
          break;
      }
      while ((localLambdaExp1 instanceof ModuleExp));
      Expression localExpression = paramDeclaration.getValue();
      if ((localExpression == null) || (!(localExpression instanceof LambdaExp)))
      {
        localLambdaExp4 = null;
        if (!paramDeclaration.getFlag(65536L));
      }
      for (LambdaExp localLambdaExp8 = localLambdaExp1; ; localLambdaExp8 = localLambdaExp8.outerLambda())
      {
        if (localLambdaExp8 == localLambdaExp2);
        while (true)
        {
          if (paramDeclaration.base == null)
            break label356;
          paramDeclaration.base.setCanRead(true);
          capture(paramDeclaration.base);
          return;
          if (localLambdaExp1 != localLambdaExp2)
            break label198;
          return;
          localLambdaExp4 = (LambdaExp)localExpression;
          if (localLambdaExp4.getInlineOnly())
            break;
          if (localLambdaExp4.isHandlingTailCalls())
          {
            localLambdaExp4 = null;
            break label220;
          }
          if ((localLambdaExp4 != localLambdaExp1) || (paramDeclaration.getCanRead()))
            break label220;
          return;
          if ((localLambdaExp8.nameDecl == null) || (!localLambdaExp8.nameDecl.getFlag(2048L)))
            break label346;
          paramDeclaration.setFlag(2048L);
        }
      }
    }
    while ((!paramDeclaration.getCanRead()) && (!paramDeclaration.getCanCall()) && (localLambdaExp4 != null));
    label346: LambdaExp localLambdaExp5;
    if (!paramDeclaration.isStatic())
    {
      localLambdaExp5 = localLambdaExp1;
      if (!paramDeclaration.isFluid())
        localLambdaExp5.setImportsLexVars();
    }
    LambdaExp localLambdaExp7;
    for (LambdaExp localLambdaExp6 = localLambdaExp5.outerLambda(); ; localLambdaExp6 = localLambdaExp7.outerLambda())
    {
      if ((localLambdaExp6 != localLambdaExp2) && (localLambdaExp6 != null))
      {
        localLambdaExp7 = localLambdaExp6;
        if ((paramDeclaration.getCanRead()) || (localLambdaExp4 != localLambdaExp6));
      }
      else
      {
        if (localLambdaExp2 != null)
          break;
        System.err.println("null declLambda for " + paramDeclaration + " curL:" + localLambdaExp1);
        for (ScopeExp localScopeExp2 = paramDeclaration.context; localScopeExp2 != null; localScopeExp2 = localScopeExp2.outer)
          System.err.println("- context:" + localScopeExp2);
      }
      Declaration localDeclaration = localLambdaExp7.nameDecl;
      if ((localDeclaration != null) && (localDeclaration.getFlag(2048L)))
        this.comp.error('e', "static " + localLambdaExp7.getName() + " references non-static " + paramDeclaration.getName());
      if (((localLambdaExp7 instanceof ClassExp)) && (localLambdaExp7.getName() != null) && (((ClassExp)localLambdaExp7).isSimple()))
        this.comp.error('w', localLambdaExp7.nameDecl, "simple class ", " requiring lexical link (because of reference to " + paramDeclaration.getName() + ") - use define-class instead");
      localLambdaExp7.setNeedsStaticLink();
    }
    localLambdaExp2.capture(paramDeclaration);
  }

  void capture(Declaration paramDeclaration1, Declaration paramDeclaration2)
  {
    if ((paramDeclaration2.isAlias()) && ((paramDeclaration2.value instanceof ReferenceExp)))
    {
      ReferenceExp localReferenceExp = (ReferenceExp)paramDeclaration2.value;
      Declaration localDeclaration = localReferenceExp.binding;
      if ((localDeclaration != null) && ((paramDeclaration1 == null) || (!localDeclaration.needsContext())))
      {
        capture(localReferenceExp.contextDecl(), localDeclaration);
        return;
      }
    }
    while ((paramDeclaration2.isFluid()) && ((paramDeclaration2.context instanceof FluidLetExp)))
      paramDeclaration2 = paramDeclaration2.base;
    if ((paramDeclaration1 != null) && (paramDeclaration2.needsContext()))
    {
      capture(paramDeclaration1);
      return;
    }
    capture(paramDeclaration2);
  }

  void maybeWarnNoDeclarationSeen(Object paramObject, Compilation paramCompilation, SourceLocator paramSourceLocator)
  {
    if (paramCompilation.warnUndefinedVariable())
      paramCompilation.error('w', "no declaration seen for " + paramObject, paramSourceLocator);
  }

  protected Expression visitApplyExp(ApplyExp paramApplyExp, Void paramVoid)
  {
    int i = this.backJumpPossible;
    int j;
    int k;
    if (((paramApplyExp.func instanceof ReferenceExp)) && (Compilation.defaultCallConvention <= 1))
    {
      Declaration localDeclaration2 = Declaration.followAliases(((ReferenceExp)paramApplyExp.func).binding);
      j = 0;
      k = 0;
      if (localDeclaration2 != null)
      {
        boolean bool8 = localDeclaration2.context instanceof ModuleExp;
        j = 0;
        k = 0;
        if (bool8)
        {
          boolean bool9 = localDeclaration2.isPublic();
          j = 0;
          k = 0;
          if (!bool9)
          {
            boolean bool10 = localDeclaration2.getFlag(4096L);
            j = 0;
            k = 0;
            if (!bool10)
            {
              Expression localExpression3 = localDeclaration2.getValue();
              boolean bool11 = localExpression3 instanceof LambdaExp;
              j = 0;
              k = 0;
              if (bool11)
              {
                boolean bool12 = ((LambdaExp)localExpression3).getNeedsClosureEnv();
                j = 0;
                k = 0;
                if (!bool12)
                  k = 1;
              }
            }
          }
        }
      }
    }
    while (true)
    {
      if (k == 0)
        paramApplyExp.func = ((Expression)paramApplyExp.func.visit(this, paramVoid));
      if ((this.exitValue == null) && (j == 0))
        paramApplyExp.args = visitExps(paramApplyExp.args, paramVoid);
      if (this.backJumpPossible > i)
        paramApplyExp.setFlag(8);
      return paramApplyExp;
      boolean bool1 = paramApplyExp.func instanceof QuoteExp;
      j = 0;
      k = 0;
      if (bool1)
      {
        int m = paramApplyExp.getArgCount();
        j = 0;
        k = 0;
        if (m > 0)
        {
          Object localObject = ((QuoteExp)paramApplyExp.func).getValue();
          Expression localExpression1 = paramApplyExp.getArg(0);
          boolean bool2 = localObject instanceof PrimProcedure;
          j = 0;
          k = 0;
          if (bool2)
          {
            boolean bool3 = localExpression1 instanceof ReferenceExp;
            j = 0;
            k = 0;
            if (bool3)
            {
              ((PrimProcedure)localObject);
              Declaration localDeclaration1 = Declaration.followAliases(((ReferenceExp)localExpression1).binding);
              j = 0;
              k = 0;
              if (localDeclaration1 != null)
              {
                boolean bool4 = localDeclaration1.context instanceof ModuleExp;
                j = 0;
                k = 0;
                if (bool4)
                {
                  boolean bool5 = localDeclaration1.getFlag(4096L);
                  j = 0;
                  k = 0;
                  if (!bool5)
                  {
                    Expression localExpression2 = localDeclaration1.getValue();
                    boolean bool6 = localExpression2 instanceof ClassExp;
                    j = 0;
                    k = 0;
                    if (bool6)
                    {
                      Expression[] arrayOfExpression = paramApplyExp.getArgs();
                      boolean bool7 = ((LambdaExp)localExpression2).getNeedsClosureEnv();
                      j = 0;
                      k = 0;
                      if (!bool7)
                      {
                        paramApplyExp.nextCall = localDeclaration1.firstCall;
                        localDeclaration1.firstCall = paramApplyExp;
                        for (int n = 1; n < arrayOfExpression.length; n++)
                          arrayOfExpression[n].visit(this, paramVoid);
                        j = 1;
                        k = j;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  protected Expression visitClassExp(ClassExp paramClassExp, Void paramVoid)
  {
    Expression localExpression = (Expression)super.visitClassExp(paramClassExp, paramVoid);
    if ((!paramClassExp.explicitInit) && (!paramClassExp.instanceType.isInterface()))
      Compilation.getConstructor(paramClassExp.instanceType, paramClassExp);
    while (true)
    {
      if ((paramClassExp.isSimple()) && (paramClassExp.getNeedsClosureEnv()) && (paramClassExp.nameDecl != null) && (paramClassExp.nameDecl.getType() == Compilation.typeClass))
        paramClassExp.nameDecl.setType(Compilation.typeClassType);
      return localExpression;
      if (paramClassExp.getNeedsClosureEnv())
        for (LambdaExp localLambdaExp = paramClassExp.firstChild; localLambdaExp != null; localLambdaExp = localLambdaExp.nextSibling)
          if ("*init*".equals(localLambdaExp.getName()))
            localLambdaExp.setNeedsStaticLink(true);
    }
  }

  public void visitDefaultArgs(LambdaExp paramLambdaExp, Void paramVoid)
  {
    if (paramLambdaExp.defaultArgs == null);
    while (true)
    {
      return;
      super.visitDefaultArgs(paramLambdaExp, paramVoid);
      for (Declaration localDeclaration = paramLambdaExp.firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
        if (!localDeclaration.isSimple())
        {
          paramLambdaExp.setFlag(true, 512);
          return;
        }
    }
  }

  protected Expression visitFluidLetExp(FluidLetExp paramFluidLetExp, Void paramVoid)
  {
    for (Declaration localDeclaration1 = paramFluidLetExp.firstDecl(); localDeclaration1 != null; localDeclaration1 = localDeclaration1.nextDecl())
      if (localDeclaration1.base == null)
      {
        Object localObject = localDeclaration1.getSymbol();
        Declaration localDeclaration2 = allocUnboundDecl(localObject, false);
        maybeWarnNoDeclarationSeen(localObject, this.comp, paramFluidLetExp);
        capture(localDeclaration2);
        localDeclaration1.base = localDeclaration2;
      }
    return (Expression)super.visitLetExp(paramFluidLetExp, paramVoid);
  }

  protected Expression visitLambdaExp(LambdaExp paramLambdaExp, Void paramVoid)
  {
    if ((checkInlineable(paramLambdaExp, new LinkedHashSet()) != LambdaExp.unknownContinuation) && ((!(paramLambdaExp.outer instanceof ModuleExp)) || (paramLambdaExp.nameDecl == null)))
    {
      paramLambdaExp.setInlineOnly(true);
      this.backJumpPossible = (1 + this.backJumpPossible);
    }
    return (Expression)super.visitLambdaExp(paramLambdaExp, paramVoid);
  }

  protected Expression visitLetExp(LetExp paramLetExp, Void paramVoid)
  {
    if ((paramLetExp.body instanceof BeginExp))
    {
      Expression[] arrayOfExpression1 = paramLetExp.inits;
      int i = arrayOfExpression1.length;
      Expression[] arrayOfExpression2 = ((BeginExp)paramLetExp.body).exps;
      int j = 0;
      Declaration localDeclaration = paramLetExp.firstDecl();
      for (int k = 0; (k < arrayOfExpression2.length) && (j < i); k++)
      {
        Expression localExpression1 = arrayOfExpression2[k];
        if ((localExpression1 instanceof SetExp))
        {
          SetExp localSetExp = (SetExp)localExpression1;
          if ((localSetExp.binding == localDeclaration) && (arrayOfExpression1[j] == QuoteExp.nullExp) && (localSetExp.isDefining()))
          {
            Expression localExpression2 = localSetExp.new_value;
            if ((((localExpression2 instanceof QuoteExp)) || ((localExpression2 instanceof LambdaExp))) && (localDeclaration.getValue() == localExpression2))
            {
              arrayOfExpression1[j] = localExpression2;
              arrayOfExpression2[k] = QuoteExp.voidExp;
            }
            j++;
            localDeclaration = localDeclaration.nextDecl();
          }
        }
      }
    }
    return (Expression)super.visitLetExp(paramLetExp, paramVoid);
  }

  protected Expression visitModuleExp(ModuleExp paramModuleExp, Void paramVoid)
  {
    ModuleExp localModuleExp = this.currentModule;
    Hashtable localHashtable = this.unknownDecls;
    this.currentModule = paramModuleExp;
    this.unknownDecls = null;
    try
    {
      Expression localExpression = visitLambdaExp(paramModuleExp, paramVoid);
      return localExpression;
    }
    finally
    {
      this.currentModule = localModuleExp;
      this.unknownDecls = localHashtable;
    }
  }

  protected Expression visitReferenceExp(ReferenceExp paramReferenceExp, Void paramVoid)
  {
    Declaration localDeclaration = paramReferenceExp.getBinding();
    if (localDeclaration == null)
    {
      localDeclaration = allocUnboundDecl(paramReferenceExp.getSymbol(), paramReferenceExp.isProcedureName());
      paramReferenceExp.setBinding(localDeclaration);
    }
    if ((localDeclaration.getFlag(65536L)) && (this.comp.resolve(paramReferenceExp.getSymbol(), paramReferenceExp.isProcedureName()) == null))
      maybeWarnNoDeclarationSeen(paramReferenceExp.getSymbol(), this.comp, paramReferenceExp);
    capture(paramReferenceExp.contextDecl(), localDeclaration);
    return paramReferenceExp;
  }

  protected Expression visitSetExp(SetExp paramSetExp, Void paramVoid)
  {
    Declaration localDeclaration = paramSetExp.binding;
    if (localDeclaration == null)
    {
      localDeclaration = allocUnboundDecl(paramSetExp.getSymbol(), paramSetExp.isFuncDef());
      paramSetExp.binding = localDeclaration;
    }
    if (!localDeclaration.ignorable())
    {
      if (!paramSetExp.isDefining())
        localDeclaration = Declaration.followAliases(localDeclaration);
      capture(paramSetExp.contextDecl(), localDeclaration);
    }
    return (Expression)super.visitSetExp(paramSetExp, paramVoid);
  }

  protected Expression visitThisExp(ThisExp paramThisExp, Void paramVoid)
  {
    if (paramThisExp.isForContext())
    {
      getCurrentLambda().setImportsLexVars();
      return paramThisExp;
    }
    return visitReferenceExp(paramThisExp, paramVoid);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.FindCapturedVars
 * JD-Core Version:    0.6.2
 */