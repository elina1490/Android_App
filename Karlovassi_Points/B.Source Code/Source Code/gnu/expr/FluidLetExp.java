package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.mapping.OutPort;

public class FluidLetExp extends LetExp
{
  public FluidLetExp(Expression[] paramArrayOfExpression)
  {
    super(paramArrayOfExpression);
  }

  private void doInits(Declaration paramDeclaration, int paramInt, Variable[] paramArrayOfVariable, Compilation paramCompilation, Variable paramVariable)
  {
    if (paramInt >= this.inits.length)
      return;
    CodeAttr localCodeAttr = paramCompilation.getCode();
    paramArrayOfVariable[paramInt] = localCodeAttr.addLocal(Type.pointer_type);
    paramDeclaration.allocateVariable(localCodeAttr);
    paramDeclaration.base.load(null, 2, paramCompilation, Target.pushObject);
    localCodeAttr.emitDup();
    localCodeAttr.emitStore(paramDeclaration.getVariable());
    this.inits[paramInt].compile(paramCompilation, Target.pushObject);
    doInits(paramDeclaration.nextDecl(), paramInt + 1, paramArrayOfVariable, paramCompilation, paramVariable);
    localCodeAttr.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("setWithSave", 1));
    localCodeAttr.emitStore(paramArrayOfVariable[paramInt]);
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Type localType;
    Object localObject;
    if ((paramTarget instanceof IgnoreTarget))
    {
      localType = null;
      if (localType != null)
        break label176;
      localObject = Target.Ignore;
    }
    while (true)
    {
      Scope localScope = getVarScope();
      localCodeAttr.enterScope(localScope);
      Variable localVariable = localScope.addVariable(localCodeAttr, Compilation.typeCallContext, null);
      paramCompilation.loadCallContext();
      localCodeAttr.emitStore(localVariable);
      Variable[] arrayOfVariable = new Variable[this.inits.length];
      Declaration localDeclaration = firstDecl();
      doInits(localDeclaration, 0, arrayOfVariable, paramCompilation, localVariable);
      localCodeAttr.emitTryStart(true, localType);
      this.body.compileWithPosition(paramCompilation, (Target)localObject);
      localCodeAttr.emitFinallyStart();
      int i = 0;
      while (i < this.inits.length)
      {
        localDeclaration.load(null, 2, paramCompilation, Target.pushObject);
        localCodeAttr.emitLoad(arrayOfVariable[i]);
        localCodeAttr.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("setRestore", 1));
        i++;
        localDeclaration = localDeclaration.nextDecl();
      }
      localType = getType();
      break;
      label176: if (localType == Type.pointer_type)
        localObject = Target.pushObject;
      else
        localObject = new StackTarget(localType);
    }
    localCodeAttr.emitTryCatchEnd();
    popScope(localCodeAttr);
    if (localType != null)
      paramTarget.compileFromStack(paramCompilation, localType);
  }

  protected boolean mustCompile()
  {
    return true;
  }

  public void print(OutPort paramOutPort)
  {
    print(paramOutPort, "(FluidLet", ")");
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitFluidLetExp(this, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.FluidLetExp
 * JD-Core Version:    0.6.2
 */