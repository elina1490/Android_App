package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;

public class SortNodes extends Procedure1
  implements Inlineable
{
  public static final Method canonicalizeMethod = Compilation.typeValues.getDeclaredMethod("canonicalize", 0);
  public static final Method makeSortedNodesMethod;
  public static final SortNodes sortNodes = new SortNodes();
  public static final ClassType typeSortedNodes = ClassType.make("gnu.kawa.xml.SortedNodes");

  static
  {
    makeSortedNodesMethod = typeSortedNodes.getDeclaredMethod("<init>", 0);
  }

  public Object apply1(Object paramObject)
  {
    SortedNodes localSortedNodes = new SortedNodes();
    Values.writeValues(paramObject, localSortedNodes);
    if (localSortedNodes.count > 1)
      return localSortedNodes;
    if (localSortedNodes.count == 0)
      return Values.empty;
    return localSortedNodes.get(0);
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if ((arrayOfExpression.length != 1) || (!paramCompilation.mustCompile))
    {
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    if (((paramTarget instanceof ConsumerTarget)) || (((paramTarget instanceof StackTarget)) && (paramTarget.getType().isSubtype(Compilation.typeValues))));
    for (Method localMethod = null; ; localMethod = canonicalizeMethod)
    {
      ConsumerTarget.compileUsingConsumer(arrayOfExpression[0], paramCompilation, paramTarget, makeSortedNodesMethod, localMethod);
      return;
    }
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Compilation.typeObject;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.SortNodes
 * JD-Core Version:    0.6.2
 */