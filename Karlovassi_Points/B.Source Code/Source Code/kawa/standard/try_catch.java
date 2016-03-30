package kawa.standard;

import gnu.expr.CatchClause;
import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.TryExp;
import gnu.lists.FVector;
import kawa.lang.Lambda;
import kawa.lang.Translator;

public class try_catch
{
  public static Expression rewrite(Object paramObject1, Object paramObject2)
  {
    Translator localTranslator = (Translator)Compilation.getCurrent();
    Expression localExpression1 = localTranslator.rewrite(paramObject1);
    Object localObject1 = null;
    Object localObject2 = null;
    FVector localFVector = (FVector)paramObject2;
    int i = localFVector.size();
    int j = 0;
    if (j < i)
    {
      Expression localExpression2 = SchemeCompilation.lambda.rewrite(localFVector.get(j), localTranslator);
      if ((localExpression2 instanceof ErrorExp))
        return localExpression2;
      if (!(localExpression2 instanceof LambdaExp))
        return localTranslator.syntaxError("internal error with try-catch");
      CatchClause localCatchClause = new CatchClause((LambdaExp)localExpression2);
      if (localObject1 == null)
        localObject2 = localCatchClause;
      while (true)
      {
        localObject1 = localCatchClause;
        j++;
        break;
        localObject1.setNext(localCatchClause);
      }
    }
    if ((localExpression1 instanceof ErrorExp))
      return localExpression1;
    TryExp localTryExp = new TryExp(localExpression1, null);
    localTryExp.setCatchClauses(localObject2);
    return localTryExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.try_catch
 * JD-Core Version:    0.6.2
 */