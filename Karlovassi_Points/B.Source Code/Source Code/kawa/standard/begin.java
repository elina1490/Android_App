package kawa.standard;

import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import java.util.Stack;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class begin extends Syntax
{
  public static final begin begin = new begin();

  static
  {
    begin.setName("begin");
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    return paramTranslator.rewrite_body(paramObject);
  }

  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    LList localLList = paramTranslator.scanBody(paramPair.getCdr(), paramScopeExp, true);
    if (localLList != LList.Empty)
      paramTranslator.formStack.add(Translator.makePair(paramPair, paramPair.getCar(), localLList));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.begin
 * JD-Core Version:    0.6.2
 */