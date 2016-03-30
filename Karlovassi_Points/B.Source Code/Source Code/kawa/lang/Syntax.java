package kawa.lang;

import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.mapping.Named;
import gnu.mapping.Symbol;
import gnu.text.Printable;
import java.util.Stack;
import java.util.Vector;

public abstract class Syntax
  implements Printable, Named
{
  Object name;

  public Syntax()
  {
  }

  public Syntax(Object paramObject)
  {
    setName(paramObject);
  }

  public final String getName()
  {
    if (this.name == null)
      return null;
    if ((this.name instanceof Symbol))
      return ((Symbol)this.name).getName();
    return this.name.toString();
  }

  public Object getSymbol()
  {
    return this.name;
  }

  public void print(Consumer paramConsumer)
  {
    paramConsumer.write("#<syntax ");
    String str1 = getName();
    if (str1 == null);
    for (String str2 = "<unnamed>"; ; str2 = str1)
    {
      paramConsumer.write(str2);
      paramConsumer.write(62);
      return;
    }
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    throw new InternalError("rewrite method not defined");
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    return rewrite(paramPair.getCdr(), paramTranslator);
  }

  public Expression rewriteForm(Object paramObject, Translator paramTranslator)
  {
    if ((paramObject instanceof Pair))
      return rewriteForm((Pair)paramObject, paramTranslator);
    return paramTranslator.syntaxError("non-list form for " + this);
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    paramVector.addElement(paramPair);
    return true;
  }

  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    if (!scanForDefinitions(paramPair, paramTranslator.formStack, paramScopeExp, paramTranslator))
      paramTranslator.formStack.add(new ErrorExp("syntax error expanding " + this));
  }

  public void setName(Object paramObject)
  {
    this.name = paramObject;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Syntax
 * JD-Core Version:    0.6.2
 */