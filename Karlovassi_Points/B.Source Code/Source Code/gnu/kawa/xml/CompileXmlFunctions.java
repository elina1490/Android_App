package gnu.kawa.xml;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.QuoteExp;
import gnu.lists.NodePredicate;
import gnu.mapping.Procedure;

public class CompileXmlFunctions
{
  public static Expression validateApplyMakeUnescapedData(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if ((arrayOfExpression.length == 1) && ((arrayOfExpression[0] instanceof QuoteExp)))
      return new QuoteExp(((MakeUnescapedData)paramProcedure).apply1(((QuoteExp)arrayOfExpression[0]).getValue()));
    return paramApplyExp;
  }

  public static Expression validateApplyTreeScanner(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    NodePredicate localNodePredicate = ((TreeScanner)paramProcedure).type;
    if ((paramApplyExp.getTypeRaw() == null) && ((localNodePredicate instanceof Type)))
      paramApplyExp.setType(NodeSetType.getInstance((Type)localNodePredicate));
    return paramApplyExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.CompileXmlFunctions
 * JD-Core Version:    0.6.2
 */