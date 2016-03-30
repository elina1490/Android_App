package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.text.Char;

public class IsEqv extends Procedure2
{
  IsEq isEq;
  Language language;

  public IsEqv(Language paramLanguage, String paramString, IsEq paramIsEq)
  {
    this.language = paramLanguage;
    this.isEq = paramIsEq;
    setName(paramString);
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompilationHelpers:validateIsEqv");
  }

  public static boolean apply(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2)
      return true;
    if (((paramObject1 instanceof Number)) && ((paramObject2 instanceof Number)))
      return IsEqual.numberEquals((Number)paramObject1, (Number)paramObject2);
    if (((paramObject1 instanceof Char)) || ((paramObject1 instanceof Symbol)))
      return paramObject1.equals(paramObject2);
    return false;
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    return this.language.booleanObject(apply(paramObject1, paramObject2));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.IsEqv
 * JD-Core Version:    0.6.2
 */