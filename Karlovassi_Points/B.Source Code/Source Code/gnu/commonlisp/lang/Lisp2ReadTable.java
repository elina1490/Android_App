package gnu.commonlisp.lang;

import gnu.kawa.lispexpr.ReadTable;

class Lisp2ReadTable extends ReadTable
{
  protected Object makeSymbol(String paramString)
  {
    return Lisp2.asSymbol(paramString.intern());
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lang.Lisp2ReadTable
 * JD-Core Version:    0.6.2
 */