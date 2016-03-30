package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class syntax_error extends Syntax
{
  public static final syntax_error syntax_error = new syntax_error();

  static
  {
    syntax_error.setName("%syntax-error");
  }

  public static Expression error(Object paramObject, Object[] paramArrayOfObject)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayOfObject.length;
    if ((paramArrayOfObject == null) || (i == 0))
      localStringBuffer.append("invalid syntax");
    Translator localTranslator;
    while (true)
    {
      localTranslator = (Translator)Compilation.getCurrent();
      if (localTranslator != null)
        break;
      throw new RuntimeException(localStringBuffer.toString());
      for (int j = 0; j < i; j++)
        localStringBuffer.append(paramArrayOfObject[j]);
    }
    Object localObject1 = localTranslator.pushPositionOf(paramObject);
    try
    {
      Expression localExpression = localTranslator.syntaxError(localStringBuffer.toString());
      return localExpression;
    }
    finally
    {
      localTranslator.popPositionOf(localObject1);
    }
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; (paramObject instanceof Pair); i++)
    {
      Pair localPair = (Pair)paramObject;
      if (i > 0)
        localStringBuffer.append(' ');
      localStringBuffer.append(localPair.getCar());
      paramObject = localPair.getCdr();
    }
    if (paramObject != LList.Empty)
    {
      if (i > 0)
        localStringBuffer.append(' ');
      localStringBuffer.append(paramObject);
    }
    return paramTranslator.syntaxError(localStringBuffer.toString());
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.syntax_error
 * JD-Core Version:    0.6.2
 */