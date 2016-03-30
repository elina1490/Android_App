package gnu.kawa.lispexpr;

import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class ResolveNamespace extends Syntax
{
  public static final ResolveNamespace resolveNamespace = new ResolveNamespace("$resolve-namespace$", false);
  public static final ResolveNamespace resolveQName = new ResolveNamespace("$resolve-qname", true);
  boolean resolvingQName;

  static
  {
    resolveNamespace.setName("$resolve-namespace$");
  }

  public ResolveNamespace(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.resolvingQName = paramBoolean;
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Pair localPair = (Pair)paramPair.getCdr();
    Namespace localNamespace = paramTranslator.namespaceResolvePrefix(paramTranslator.rewrite_car(localPair, false));
    String str;
    if (localNamespace == null)
    {
      str = localPair.getCar().toString();
      if (str != "[default-element-namespace]")
        break label79;
    }
    for (localNamespace = Namespace.EmptyNamespace; this.resolvingQName; localNamespace = Namespace.valueOf(str, str))
    {
      return new QuoteExp(localNamespace.getSymbol(((Pair)localPair.getCdr()).getCar().toString()));
      label79: Object localObject = paramTranslator.pushPositionOf(localPair);
      paramTranslator.error('e', "unknown namespace prefix " + str);
      paramTranslator.popPositionOf(localObject);
    }
    return new QuoteExp(localNamespace);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ResolveNamespace
 * JD-Core Version:    0.6.2
 */