package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;

public class TryExp extends Expression
{
  CatchClause catch_clauses;
  Expression finally_clause;
  Expression try_clause;

  public TryExp(Expression paramExpression1, Expression paramExpression2)
  {
    this.try_clause = paramExpression1;
    this.finally_clause = paramExpression2;
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    try
    {
      this.try_clause.apply(paramCallContext);
      paramCallContext.runUntilDone();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (CatchClause localCatchClause = this.catch_clauses; localCatchClause != null; localCatchClause = localCatchClause.next)
        if (((ClassType)localCatchClause.firstDecl().getTypeExp().eval(paramCallContext)).isInstance(localThrowable))
        {
          paramCallContext.value1 = localThrowable;
          localCatchClause.apply(paramCallContext);
          return;
        }
      throw localThrowable;
    }
    finally
    {
      if (this.finally_clause != null)
        this.finally_clause.eval(paramCallContext);
    }
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    boolean bool;
    Target localTarget;
    if (this.finally_clause != null)
    {
      bool = true;
      if ((!(paramTarget instanceof StackTarget)) && (!(paramTarget instanceof ConsumerTarget)) && (!(paramTarget instanceof IgnoreTarget)) && ((!(paramTarget instanceof ConditionalTarget)) || (this.finally_clause != null)))
        break label121;
      localTarget = paramTarget;
      label53: if (!(localTarget instanceof StackTarget))
        break label133;
    }
    label133: for (Type localType = localTarget.getType(); ; localType = null)
    {
      localCodeAttr.emitTryStart(bool, localType);
      this.try_clause.compileWithPosition(paramCompilation, localTarget);
      for (CatchClause localCatchClause = this.catch_clauses; localCatchClause != null; localCatchClause = localCatchClause.getNext())
        localCatchClause.compile(paramCompilation, localTarget);
      bool = false;
      break;
      label121: localTarget = Target.pushValue(paramTarget.getType());
      break label53;
    }
    if (this.finally_clause != null)
    {
      localCodeAttr.emitFinallyStart();
      this.finally_clause.compileWithPosition(paramCompilation, Target.Ignore);
      localCodeAttr.emitFinallyEnd();
    }
    localCodeAttr.emitTryCatchEnd();
    if (localTarget != paramTarget)
      paramTarget.compileFromStack(paramCompilation, paramTarget.getType());
  }

  public final CatchClause getCatchClauses()
  {
    return this.catch_clauses;
  }

  public final Expression getFinallyClause()
  {
    return this.finally_clause;
  }

  public Type getType()
  {
    if (this.catch_clauses == null)
      return this.try_clause.getType();
    return super.getType();
  }

  protected boolean mustCompile()
  {
    return false;
  }

  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(Try", ")", 2);
    paramOutPort.writeSpaceFill();
    this.try_clause.print(paramOutPort);
    for (CatchClause localCatchClause = this.catch_clauses; localCatchClause != null; localCatchClause = localCatchClause.getNext())
      localCatchClause.print(paramOutPort);
    if (this.finally_clause != null)
    {
      paramOutPort.writeSpaceLinear();
      paramOutPort.print(" finally: ");
      this.finally_clause.print(paramOutPort);
    }
    paramOutPort.endLogicalBlock(")");
  }

  public final void setCatchClauses(CatchClause paramCatchClause)
  {
    this.catch_clauses = paramCatchClause;
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitTryExp(this, paramD);
  }

  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    this.try_clause = paramExpVisitor.visitAndUpdate(this.try_clause, paramD);
    for (CatchClause localCatchClause = this.catch_clauses; (paramExpVisitor.exitValue == null) && (localCatchClause != null); localCatchClause = localCatchClause.getNext())
      paramExpVisitor.visit(localCatchClause, paramD);
    if ((paramExpVisitor.exitValue == null) && (this.finally_clause != null))
      this.finally_clause = paramExpVisitor.visitAndUpdate(this.finally_clause, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.TryExp
 * JD-Core Version:    0.6.2
 */