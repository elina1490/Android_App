package gnu.kawa.reflect;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;

public class TypeSwitch extends MethodProc
  implements Inlineable
{
  public static final TypeSwitch typeSwitch = new TypeSwitch("typeswitch");

  public TypeSwitch(String paramString)
  {
    setName(paramString);
    setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplyTypeSwitch");
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object[] arrayOfObject = paramCallContext.getArgs();
    Object localObject = arrayOfObject[0];
    int i = arrayOfObject.length - 1;
    for (int j = 1; j < i; j++)
      if (((MethodProc)arrayOfObject[j]).match1(localObject, paramCallContext) >= 0)
        return;
    ((Procedure)arrayOfObject[i]).check1(localObject, paramCallContext);
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    CodeAttr localCodeAttr = paramCompilation.getCode();
    localCodeAttr.pushScope();
    Variable localVariable = localCodeAttr.addLocal(Type.pointer_type);
    arrayOfExpression[0].compile(paramCompilation, Target.pushObject);
    localCodeAttr.emitStore(localVariable);
    int i = 1;
    if (i < arrayOfExpression.length)
    {
      if (i > 1)
        localCodeAttr.emitElse();
      int k = i + 1;
      Expression localExpression = arrayOfExpression[i];
      if ((localExpression instanceof LambdaExp))
      {
        LambdaExp localLambdaExp = (LambdaExp)localExpression;
        Declaration localDeclaration = localLambdaExp.firstDecl();
        Type localType = localDeclaration.getType();
        if (!localDeclaration.getCanRead())
        {
          localDeclaration = null;
          label121: if (!(localType instanceof TypeValue))
            break label178;
          ((TypeValue)localType).emitTestIf(localVariable, localDeclaration, paramCompilation);
        }
        while (true)
        {
          localLambdaExp.allocChildClasses(paramCompilation);
          localLambdaExp.body.compileWithPosition(paramCompilation, paramTarget);
          i = k;
          break;
          localDeclaration.allocateVariable(localCodeAttr);
          break label121;
          label178: if (k < arrayOfExpression.length)
          {
            localCodeAttr.emitLoad(localVariable);
            localType.emitIsInstance(localCodeAttr);
            localCodeAttr.emitIfIntNotZero();
          }
          if (localDeclaration != null)
          {
            localCodeAttr.emitLoad(localVariable);
            localDeclaration.compileStore(paramCompilation);
          }
        }
      }
      throw new Error("not implemented: typeswitch arg not LambdaExp");
    }
    int j = arrayOfExpression.length - 2;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      localCodeAttr.emitFi();
    }
    localCodeAttr.popScope();
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Type.pointer_type;
  }

  public int numArgs()
  {
    return -4094;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.TypeSwitch
 * JD-Core Version:    0.6.2
 */