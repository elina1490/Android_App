package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.ThisExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class thisRef extends Syntax
{
  public static final thisRef thisSyntax = new thisRef();

  static
  {
    thisSyntax.setName("this");
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    if (paramPair.getCdr() == LList.Empty)
    {
      LambdaExp localLambdaExp = paramTranslator.curMethodLambda;
      Declaration localDeclaration;
      if (localLambdaExp == null)
      {
        localDeclaration = null;
        if ((localDeclaration == null) || (!localDeclaration.isThisParameter()))
        {
          localDeclaration = null;
          if ((localLambdaExp != null) && (localLambdaExp.nameDecl != null))
            break label76;
          paramTranslator.error('e', "use of 'this' not in a named method");
        }
      }
      while (true)
      {
        return new ThisExp(localDeclaration);
        localDeclaration = localLambdaExp.firstDecl();
        break;
        label76: if (localLambdaExp.nameDecl.isStatic())
        {
          paramTranslator.error('e', "use of 'this' in a static method");
          localDeclaration = null;
        }
        else
        {
          localDeclaration = new Declaration(ThisExp.THIS_NAME);
          localLambdaExp.add(null, localDeclaration);
          localLambdaExp.nameDecl.setFlag(4096L);
        }
      }
    }
    return paramTranslator.syntaxError("this with parameter not implemented");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.thisRef
 * JD-Core Version:    0.6.2
 */