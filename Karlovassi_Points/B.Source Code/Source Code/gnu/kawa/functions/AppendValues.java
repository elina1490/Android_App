package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.Special;
import gnu.expr.Target;
import gnu.lists.Consumable;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;

public class AppendValues extends MethodProc
  implements Inlineable
{
  public static final AppendValues appendValues = new AppendValues();

  public AppendValues()
  {
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyAppendValues");
  }

  public void apply(CallContext paramCallContext)
  {
    Special localSpecial = Special.dfault;
    while (true)
    {
      Object localObject = paramCallContext.getNextArg(localSpecial);
      if (localObject == localSpecial)
        return;
      if ((localObject instanceof Consumable))
        ((Consumable)localObject).consume(paramCallContext.consumer);
      else
        paramCallContext.writeValue(localObject);
    }
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    int i = arrayOfExpression.length;
    int j;
    if (((paramTarget instanceof ConsumerTarget)) || ((paramTarget instanceof IgnoreTarget)))
      j = 0;
    while (j < i)
    {
      arrayOfExpression[j].compileWithPosition(paramCompilation, paramTarget);
      j++;
      continue;
      ConsumerTarget.compileUsingConsumer(paramApplyExp, paramCompilation, paramTarget);
    }
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Compilation.typeObject;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.AppendValues
 * JD-Core Version:    0.6.2
 */