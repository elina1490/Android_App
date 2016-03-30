package gnu.commonlisp.lang;

import gnu.expr.Expression;
import gnu.expr.TryExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class UnwindProtect extends Syntax
{
  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    if (!(paramObject instanceof Pair))
      return paramTranslator.syntaxError("invalid syntax for unwind-protect");
    Pair localPair = (Pair)paramObject;
    return new TryExp(paramTranslator.rewrite(localPair.getCar()), paramTranslator.rewrite_body(localPair.getCdr()));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lang.UnwindProtect
 * JD-Core Version:    0.6.2
 */