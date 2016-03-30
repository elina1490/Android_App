package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;

public class Not extends Procedure1
{
  Language language;

  public Not(Language paramLanguage)
  {
    this.language = paramLanguage;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyNot");
    Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileMisc:forNot");
  }

  public Not(Language paramLanguage, String paramString)
  {
    this(paramLanguage);
    setName(paramString);
  }

  public Object apply1(Object paramObject)
  {
    Language localLanguage = this.language;
    if (!this.language.isTrue(paramObject));
    for (boolean bool = true; ; bool = false)
      return localLanguage.booleanObject(bool);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.Not
 * JD-Core Version:    0.6.2
 */