package kawa.standard;

import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRules;
import kawa.lang.Translator;

public class syntax_rules extends Syntax
{
  public static final syntax_rules syntax_rules = new syntax_rules();

  static
  {
    syntax_rules.setName("syntax-rules");
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Pair localPair = (Pair)paramPair.getCdr();
    return new QuoteExp(new SyntaxRules(SyntaxPattern.getLiteralsList(localPair.getCar(), null, paramTranslator), localPair.getCdr(), paramTranslator));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.syntax_rules
 * JD-Core Version:    0.6.2
 */