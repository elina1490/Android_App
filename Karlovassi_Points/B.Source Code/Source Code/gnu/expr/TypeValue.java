package gnu.expr;

import gnu.bytecode.Variable;
import gnu.mapping.Procedure;

public abstract interface TypeValue extends java.lang.reflect.Type
{
  public abstract Expression convertValue(Expression paramExpression);

  public abstract void emitIsInstance(Variable paramVariable, Compilation paramCompilation, Target paramTarget);

  public abstract void emitTestIf(Variable paramVariable, Declaration paramDeclaration, Compilation paramCompilation);

  public abstract Procedure getConstructor();

  public abstract gnu.bytecode.Type getImplementationType();
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.TypeValue
 * JD-Core Version:    0.6.2
 */