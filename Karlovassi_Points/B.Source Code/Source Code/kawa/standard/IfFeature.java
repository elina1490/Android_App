package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleContext;
import gnu.mapping.SimpleSymbol;
import kawa.lang.SyntaxForm;

public class IfFeature
{
  public static boolean hasFeature(String paramString)
  {
    if (paramString == "kawa")
      return true;
    if (paramString == "srfi-0")
      return true;
    if (paramString == "srfi-4")
      return true;
    if (paramString == "srfi-6")
      return true;
    if (paramString == "srfi-8")
      return true;
    if (paramString == "srfi-9")
      return true;
    if (paramString == "srfi-11")
      return true;
    if (paramString == "srfi-16")
      return true;
    if (paramString == "srfi-17")
      return true;
    if (paramString == "srfi-23")
      return true;
    if (paramString == "srfi-25")
      return true;
    if (paramString == "srfi-26")
      return true;
    if (paramString == "srfi-28")
      return true;
    if (paramString == "srfi-30")
      return true;
    if (paramString == "srfi-39")
      return true;
    if ((paramString == "in-http-server") || (paramString == "in-servlet"))
    {
      int i = ModuleContext.getContext().getFlags();
      if (paramString == "in-http-server")
        return (i & ModuleContext.IN_HTTP_SERVER) != 0;
      if (paramString == "in-servlet")
        return (i & ModuleContext.IN_SERVLET) != 0;
    }
    String str = ("%provide%" + paramString).intern();
    Declaration localDeclaration = Compilation.getCurrent().lookup(str, -1);
    return (localDeclaration != null) && (!localDeclaration.getFlag(65536L));
  }

  public static boolean testFeature(Object paramObject)
  {
    if ((paramObject instanceof SyntaxForm))
      paramObject = ((SyntaxForm)paramObject).getDatum();
    if (((paramObject instanceof String)) || ((paramObject instanceof SimpleSymbol)))
      return hasFeature(paramObject.toString());
    return false;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.IfFeature
 * JD-Core Version:    0.6.2
 */