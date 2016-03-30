package gnu.commonlisp.lang;

import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class function extends Syntax
{
  Syntax lambda;

  public function(Syntax paramSyntax)
  {
    this.lambda = paramSyntax;
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    if ((localObject1 instanceof Pair))
    {
      Pair localPair1 = (Pair)localObject1;
      if (localPair1.getCdr() != LList.Empty)
        return paramTranslator.syntaxError("too many forms after 'function'");
      Object localObject2 = localPair1.getCar();
      if (((localObject2 instanceof String)) || ((localObject2 instanceof Symbol)))
      {
        ReferenceExp localReferenceExp = new ReferenceExp(localObject2);
        localReferenceExp.setProcedureName(true);
        localReferenceExp.setFlag(8);
        return localReferenceExp;
      }
      if ((localObject2 instanceof Pair))
      {
        Pair localPair2 = (Pair)localObject2;
        Object localObject3 = localPair2.getCar();
        if ((localObject3 instanceof String))
        {
          if (!"lambda".equals(localObject3));
        }
        else
          while (((localObject3 instanceof Symbol)) && ("lambda".equals(((Symbol)localObject3).getName())))
            return this.lambda.rewriteForm(localPair2, paramTranslator);
      }
    }
    return paramTranslator.syntaxError("function must be followed by name or lambda expression");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lang.function
 * JD-Core Version:    0.6.2
 */