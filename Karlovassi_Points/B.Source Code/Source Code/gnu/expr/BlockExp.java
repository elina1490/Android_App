package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Label;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;

public class BlockExp extends Expression
{
  Expression body;
  Expression exitBody;
  Target exitTarget;
  ExitableBlock exitableBlock;
  Declaration label;

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    try
    {
      Object localObject2 = this.body.eval(paramCallContext);
      localObject1 = localObject2;
      paramCallContext.writeValue(localObject1);
      return;
    }
    catch (BlockExitException localBlockExitException)
    {
      while (true)
      {
        if (localBlockExitException.exit.block != this)
          throw localBlockExitException;
        Object localObject1 = localBlockExitException.exit.result;
        if (this.exitBody != null)
          localObject1 = this.exitBody.eval(paramCallContext);
      }
    }
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Type localType;
    Target localTarget;
    if ((this.exitBody == null) && ((paramTarget instanceof StackTarget)))
    {
      localType = paramTarget.getType();
      this.exitableBlock = localCodeAttr.startExitableBlock(localType, true);
      if (this.exitBody != null)
        break label115;
      localTarget = paramTarget;
      label46: this.exitTarget = localTarget;
      this.body.compileWithPosition(paramCompilation, paramTarget);
      if (this.exitBody == null)
        break label123;
      Label localLabel = new Label(localCodeAttr);
      localCodeAttr.emitGoto(localLabel);
      localCodeAttr.endExitableBlock();
      this.exitBody.compileWithPosition(paramCompilation, paramTarget);
      localLabel.define(localCodeAttr);
    }
    while (true)
    {
      this.exitableBlock = null;
      return;
      localType = null;
      break;
      label115: localTarget = Target.Ignore;
      break label46;
      label123: localCodeAttr.endExitableBlock();
    }
  }

  protected boolean mustCompile()
  {
    return false;
  }

  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(Block", ")", 2);
    if (this.label != null)
    {
      paramOutPort.print(' ');
      paramOutPort.print(this.label.getName());
    }
    paramOutPort.writeSpaceLinear();
    this.body.print(paramOutPort);
    if (this.exitBody != null)
    {
      paramOutPort.writeSpaceLinear();
      paramOutPort.print("else ");
      this.exitBody.print(paramOutPort);
    }
    paramOutPort.endLogicalBlock(")");
  }

  public void setBody(Expression paramExpression)
  {
    this.body = paramExpression;
  }

  public void setBody(Expression paramExpression1, Expression paramExpression2)
  {
    this.body = paramExpression1;
    this.exitBody = paramExpression2;
  }

  public void setLabel(Declaration paramDeclaration)
  {
    this.label = paramDeclaration;
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitBlockExp(this, paramD);
  }

  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    this.body = paramExpVisitor.visitAndUpdate(this.body, paramD);
    if ((paramExpVisitor.exitValue == null) && (this.exitBody != null))
      this.exitBody = paramExpVisitor.visitAndUpdate(this.exitBody, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.BlockExp
 * JD-Core Version:    0.6.2
 */