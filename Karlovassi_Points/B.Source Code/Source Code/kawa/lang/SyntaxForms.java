package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.NameLookup;
import gnu.lists.ImmutablePair;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;

public class SyntaxForms
{
  public static final boolean DEBUGGING = true;

  public static boolean freeIdentifierEquals(SyntaxForm paramSyntaxForm1, SyntaxForm paramSyntaxForm2)
  {
    Translator localTranslator = (Translator)Compilation.getCurrent();
    return localTranslator.lexical.lookup(paramSyntaxForm1.getDatum(), -1) == localTranslator.lexical.lookup(paramSyntaxForm2.getDatum(), -1);
  }

  public static Object fromDatum(Object paramObject, SyntaxForm paramSyntaxForm)
  {
    return makeForm(paramObject, paramSyntaxForm.getScope());
  }

  public static Object fromDatumIfNeeded(Object paramObject, SyntaxForm paramSyntaxForm)
  {
    if (paramObject == paramSyntaxForm.getDatum())
      return paramSyntaxForm;
    if ((paramObject instanceof SyntaxForm))
      return (SyntaxForm)paramObject;
    return fromDatum(paramObject, paramSyntaxForm);
  }

  public static boolean isIdentifier(SyntaxForm paramSyntaxForm)
  {
    return paramSyntaxForm.getDatum() instanceof Symbol;
  }

  public static Object makeForm(Object paramObject, TemplateScope paramTemplateScope)
  {
    if ((paramObject instanceof Pair))
      return new PairSyntaxForm((Pair)paramObject, paramTemplateScope);
    if (paramObject == LList.Empty)
      return paramObject;
    return new SimpleSyntaxForm(paramObject, paramTemplateScope);
  }

  public static Object makeWithTemplate(Object paramObject1, Object paramObject2)
  {
    if ((paramObject2 instanceof SyntaxForm))
      return (SyntaxForm)paramObject2;
    if ((paramObject1 instanceof SyntaxForm))
    {
      SyntaxForm localSyntaxForm = (SyntaxForm)paramObject1;
      if (paramObject2 == localSyntaxForm.getDatum())
        return localSyntaxForm;
      return fromDatum(paramObject2, localSyntaxForm);
    }
    return paramObject2;
  }

  public static Expression rewrite(Object paramObject)
  {
    return ((Translator)Compilation.getCurrent()).rewrite(paramObject);
  }

  public static Expression rewriteBody(Object paramObject)
  {
    return ((Translator)Compilation.getCurrent()).rewrite_body(paramObject);
  }

  public static String toString(SyntaxForm paramSyntaxForm, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("#<syntax");
    if (paramString != null)
    {
      localStringBuilder.append('#');
      localStringBuilder.append(paramString);
    }
    localStringBuilder.append(' ');
    localStringBuilder.append(paramSyntaxForm.getDatum());
    TemplateScope localTemplateScope = paramSyntaxForm.getScope();
    if (localTemplateScope == null)
      localStringBuilder.append(" in null");
    while (true)
    {
      localStringBuilder.append(">");
      return localStringBuilder.toString();
      localStringBuilder.append(" in #");
      localStringBuilder.append(localTemplateScope.id);
    }
  }

  static class PairSyntaxForm extends ImmutablePair
    implements SyntaxForm
  {
    private Pair datum;
    private TemplateScope scope;

    public PairSyntaxForm(Pair paramPair, TemplateScope paramTemplateScope)
    {
      this.datum = paramPair;
      this.scope = paramTemplateScope;
    }

    public Object getCar()
    {
      if (this.car == null)
        this.car = SyntaxForms.makeForm(this.datum.getCar(), this.scope);
      return this.car;
    }

    public Object getCdr()
    {
      if (this.cdr == null)
        this.cdr = SyntaxForms.makeForm(this.datum.getCdr(), this.scope);
      return this.cdr;
    }

    public Object getDatum()
    {
      return this.datum;
    }

    public TemplateScope getScope()
    {
      return this.scope;
    }

    public String toString()
    {
      return SyntaxForms.toString(this, null);
    }
  }

  static class SimpleSyntaxForm
    implements SyntaxForm
  {
    static int counter;
    private Object datum;
    int id;
    private TemplateScope scope;

    SimpleSyntaxForm(Object paramObject, TemplateScope paramTemplateScope)
    {
      int i = 1 + counter;
      counter = i;
      this.id = i;
      this.datum = paramObject;
      this.scope = paramTemplateScope;
    }

    public Object getDatum()
    {
      return this.datum;
    }

    public TemplateScope getScope()
    {
      return this.scope;
    }

    public String toString()
    {
      return SyntaxForms.toString(this, Integer.toString(this.id));
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.SyntaxForms
 * JD-Core Version:    0.6.2
 */