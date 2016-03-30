package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Label;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;
import gnu.mapping.Values;

public class IfExp extends Expression
{
  Expression else_clause;
  Expression test;
  Expression then_clause;

  public IfExp(Expression paramExpression1, Expression paramExpression2, Expression paramExpression3)
  {
    this.test = paramExpression1;
    this.then_clause = paramExpression2;
    this.else_clause = paramExpression3;
  }

  public static void compile(Expression paramExpression1, Expression paramExpression2, Expression paramExpression3, Compilation paramCompilation, Target paramTarget)
  {
    Language localLanguage = paramCompilation.getLanguage();
    CodeAttr localCodeAttr = paramCompilation.getCode();
    int i;
    Label localLabel1;
    int j;
    Label localLabel2;
    if (((paramTarget instanceof ConditionalTarget)) && ((paramExpression3 instanceof QuoteExp)))
    {
      i = 1;
      if (localLanguage.isTrue(((QuoteExp)paramExpression3).getValue()))
      {
        localLabel1 = ((ConditionalTarget)paramTarget).ifTrue;
        if (localLabel1 == null)
          localLabel1 = new Label(localCodeAttr);
        if ((paramExpression1 != paramExpression2) || (!(paramTarget instanceof ConditionalTarget)) || (!(paramExpression2 instanceof ReferenceExp)))
          break label322;
        j = 1;
        localLabel2 = ((ConditionalTarget)paramTarget).ifTrue;
        label104: ConditionalTarget localConditionalTarget = new ConditionalTarget(localLabel2, localLabel1, localLanguage);
        if (j != 0)
          localConditionalTarget.trueBranchComesFirst = false;
        paramExpression1.compile(paramCompilation, localConditionalTarget);
        localCodeAttr.emitIfThen();
        if (j == 0)
        {
          localLabel2.define(localCodeAttr);
          Variable localVariable2 = paramCompilation.callContextVar;
          paramExpression2.compileWithPosition(paramCompilation, paramTarget);
          paramCompilation.callContextVar = localVariable2;
        }
        if (i != 0)
          break label349;
        localCodeAttr.emitElse();
        localLabel1.define(localCodeAttr);
        Variable localVariable1 = paramCompilation.callContextVar;
        if (paramExpression3 != null)
          break label339;
        paramCompilation.compileConstant(Values.empty, paramTarget);
        label209: paramCompilation.callContextVar = localVariable1;
      }
    }
    while (true)
    {
      localCodeAttr.emitFi();
      return;
      localLabel1 = ((ConditionalTarget)paramTarget).ifFalse;
      break;
      boolean bool1 = paramExpression3 instanceof ExitExp;
      localLabel1 = null;
      if (bool1)
      {
        boolean bool2 = ((ExitExp)paramExpression3).result instanceof QuoteExp;
        localLabel1 = null;
        if (bool2)
        {
          BlockExp localBlockExp = ((ExitExp)paramExpression3).block;
          boolean bool3 = localBlockExp.exitTarget instanceof IgnoreTarget;
          localLabel1 = null;
          if (bool3)
          {
            localLabel1 = localBlockExp.exitableBlock.exitIsGoto();
            if (localLabel1 != null)
            {
              i = 1;
              break;
            }
          }
        }
      }
      i = 0;
      break;
      label322: localLabel2 = new Label(localCodeAttr);
      j = 0;
      break label104;
      label339: paramExpression3.compileWithPosition(paramCompilation, paramTarget);
      break label209;
      label349: localCodeAttr.setUnreachable();
    }
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    if (getLanguage().isTrue(this.test.eval(paramCallContext)))
      this.then_clause.apply(paramCallContext);
    while (this.else_clause == null)
      return;
    this.else_clause.apply(paramCallContext);
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    Expression localExpression1 = this.test;
    Expression localExpression2 = this.then_clause;
    if (this.else_clause == null);
    for (Object localObject = QuoteExp.voidExp; ; localObject = this.else_clause)
    {
      compile(localExpression1, localExpression2, (Expression)localObject, paramCompilation, paramTarget);
      return;
    }
  }

  public Expression getElseClause()
  {
    return this.else_clause;
  }

  protected final Language getLanguage()
  {
    return Language.getDefaultLanguage();
  }

  public Expression getTest()
  {
    return this.test;
  }

  public Expression getThenClause()
  {
    return this.then_clause;
  }

  public Type getType()
  {
    Type localType = this.then_clause.getType();
    if (this.else_clause == null);
    for (Object localObject = Type.voidType; ; localObject = this.else_clause.getType())
      return Language.unionType(localType, (Type)localObject);
  }

  protected boolean mustCompile()
  {
    return false;
  }

  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(If ", false, ")");
    paramOutPort.setIndentation(-2, false);
    this.test.print(paramOutPort);
    paramOutPort.writeSpaceLinear();
    this.then_clause.print(paramOutPort);
    if (this.else_clause != null)
    {
      paramOutPort.writeSpaceLinear();
      this.else_clause.print(paramOutPort);
    }
    paramOutPort.endLogicalBlock(")");
  }

  Expression select(boolean paramBoolean)
  {
    if (paramBoolean)
      return this.then_clause;
    if (this.else_clause == null)
      return QuoteExp.voidExp;
    return this.else_clause;
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitIfExp(this, paramD);
  }

  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    this.test = paramExpVisitor.visitAndUpdate(this.test, paramD);
    if (paramExpVisitor.exitValue == null)
      this.then_clause = paramExpVisitor.visitAndUpdate(this.then_clause, paramD);
    if ((paramExpVisitor.exitValue == null) && (this.else_clause != null))
      this.else_clause = paramExpVisitor.visitAndUpdate(this.else_clause, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.IfExp
 * JD-Core Version:    0.6.2
 */