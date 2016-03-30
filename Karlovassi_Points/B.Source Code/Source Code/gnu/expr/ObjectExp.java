package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;

public class ObjectExp extends ClassExp
{
  public ObjectExp()
  {
    super(true);
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    compileMembers(paramCompilation);
    CodeAttr localCodeAttr = paramCompilation.getCode();
    localCodeAttr.emitNew(this.type);
    localCodeAttr.emitDup(1);
    Method localMethod = Compilation.getConstructor(this.type, this);
    LambdaExp localLambdaExp;
    Variable localVariable;
    if (this.closureEnvField != null)
    {
      localLambdaExp = outerLambda();
      if (Compilation.defaultCallConvention >= 2)
        break label94;
      localVariable = getOwningLambda().heapFrame;
      if (localVariable != null)
        break label122;
      localCodeAttr.emitPushThis();
    }
    while (true)
    {
      localCodeAttr.emitInvokeSpecial(localMethod);
      paramTarget.compileFromStack(paramCompilation, getCompiledClassType(paramCompilation));
      return;
      label94: if (localLambdaExp.heapFrame != null)
      {
        localVariable = localLambdaExp.heapFrame;
        break;
      }
      localVariable = localLambdaExp.closureEnv;
      break;
      label122: localCodeAttr.emitLoad(localVariable);
    }
  }

  public Type getType()
  {
    return this.type;
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitObjectExp(this, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ObjectExp
 * JD-Core Version:    0.6.2
 */