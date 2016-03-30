package gnu.commonlisp.lang;

import gnu.expr.BeginExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class prog1 extends Syntax
{
  public static final prog1 prog1 = new prog1("prog1", 1);
  public static final prog1 prog2 = new prog1("prog2", 2);
  int index;

  public prog1(String paramString, int paramInt)
  {
    this.index = paramInt;
    setName(paramString);
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    int i = LList.length(paramObject);
    if (i < this.index)
      return paramTranslator.syntaxError("too few expressions in " + getName());
    if (this.index == 2)
    {
      Pair localPair3 = (Pair)paramObject;
      return new BeginExp(paramTranslator.rewrite(localPair3.getCar()), prog1.rewrite(localPair3.getCdr(), paramTranslator));
    }
    Expression[] arrayOfExpression1 = new Expression[1];
    LetExp localLetExp = new LetExp(arrayOfExpression1);
    Expression[] arrayOfExpression2 = new Expression[i];
    Pair localPair1 = (Pair)paramObject;
    arrayOfExpression1[0] = paramTranslator.rewrite(localPair1.getCar());
    Object localObject = localPair1.getCdr();
    for (int j = 0; j < i - 1; j++)
    {
      Pair localPair2 = (Pair)localObject;
      arrayOfExpression2[j] = paramTranslator.rewrite(localPair2.getCar());
      localObject = localPair2.getCdr();
    }
    Declaration localDeclaration = localLetExp.addDeclaration((Object)null);
    arrayOfExpression2[(i - 1)] = new ReferenceExp(localDeclaration);
    localLetExp.body = BeginExp.canonicalize(arrayOfExpression2);
    paramTranslator.mustCompileHere();
    return localLetExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lang.prog1
 * JD-Core Version:    0.6.2
 */