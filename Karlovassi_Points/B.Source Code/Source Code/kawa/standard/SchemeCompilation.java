package kawa.standard;

import gnu.expr.Special;
import kawa.lang.Lambda;
import kawa.repl;

public class SchemeCompilation
{
  public static final Lambda lambda = new Lambda();
  public static final repl repl = new repl(Scheme.instance);

  static
  {
    lambda.setKeywords(Special.optional, Special.rest, Special.key);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.SchemeCompilation
 * JD-Core Version:    0.6.2
 */