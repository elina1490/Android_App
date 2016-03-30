package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.kawa.reflect.ArraySet;
import gnu.kawa.reflect.Invoke;

class SetArrayExp extends ApplyExp
{
  public static final ClassType typeSetArray = ClassType.make("gnu.kawa.functions.SetArray");
  Type elementType;

  public SetArrayExp(Expression paramExpression, ArrayType paramArrayType)
  {
    super(localInvoke, arrayOfExpression);
    this.elementType = paramArrayType.getComponentType();
  }

  public Expression validateApply(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Declaration paramDeclaration)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    if (arrayOfExpression1.length == 2)
    {
      Expression localExpression = getArgs()[1];
      Expression[] arrayOfExpression2 = new Expression[3];
      arrayOfExpression2[0] = localExpression;
      arrayOfExpression2[1] = arrayOfExpression1[0];
      arrayOfExpression2[2] = arrayOfExpression1[1];
      return paramInlineCalls.visitApplyOnly(new ApplyExp(new ArraySet(this.elementType), arrayOfExpression2), paramType);
    }
    return paramApplyExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.SetArrayExp
 * JD-Core Version:    0.6.2
 */