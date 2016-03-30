package gnu.commonlisp.lang;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class defun extends Syntax
{
  Lambda lambdaSyntax;

  public defun(Lambda paramLambda)
  {
    this.lambdaSyntax = paramLambda;
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    Declaration localDeclaration = null;
    if ((localObject1 instanceof Pair))
    {
      Pair localPair1 = (Pair)localObject1;
      Object localObject2 = localPair1.getCar();
      Object localObject3;
      if (((localObject2 instanceof Symbol)) || ((localObject2 instanceof String)))
        localObject3 = localObject2.toString();
      while ((localObject3 != null) && ((localPair1.getCdr() instanceof Pair)))
      {
        Pair localPair2 = (Pair)localPair1.getCdr();
        LambdaExp localLambdaExp1 = new LambdaExp();
        this.lambdaSyntax.rewrite(localLambdaExp1, localPair2.getCar(), localPair2.getCdr(), paramTranslator, null);
        localLambdaExp1.setSymbol(localObject3);
        if ((localPair2 instanceof PairWithPosition))
          localLambdaExp1.setLocation((PairWithPosition)localPair2);
        LambdaExp localLambdaExp2 = localLambdaExp1;
        SetExp localSetExp = new SetExp(localObject3, localLambdaExp2);
        localSetExp.setDefining(true);
        localSetExp.setFuncDef(true);
        if (localDeclaration != null)
        {
          localSetExp.setBinding(localDeclaration);
          if (((localDeclaration.context instanceof ModuleExp)) && (localDeclaration.getCanWrite()))
            localLambdaExp2 = null;
          localDeclaration.noteValue(localLambdaExp2);
        }
        return localSetExp;
        boolean bool = localObject2 instanceof Declaration;
        localDeclaration = null;
        localObject3 = null;
        if (bool)
        {
          localDeclaration = (Declaration)localObject2;
          localObject3 = localDeclaration.getSymbol();
        }
      }
    }
    return paramTranslator.syntaxError("invalid syntax for " + getName());
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Pair localPair;
    if ((paramPair.getCdr() instanceof Pair))
    {
      localPair = (Pair)paramPair.getCdr();
      if (((localPair.getCar() instanceof String)) || ((localPair.getCar() instanceof Symbol)));
    }
    else
    {
      return super.scanForDefinitions(paramPair, paramVector, paramScopeExp, paramTranslator);
    }
    Object localObject = localPair.getCar();
    Declaration localDeclaration = paramScopeExp.lookup(localObject);
    if (localDeclaration == null)
    {
      localDeclaration = new Declaration(localObject);
      localDeclaration.setProcedureDecl(true);
      paramScopeExp.addDeclaration(localDeclaration);
    }
    while (true)
    {
      if ((paramScopeExp instanceof ModuleExp))
        localDeclaration.setCanRead(true);
      paramVector.addElement(Translator.makePair(paramPair, this, Translator.makePair(localPair, localDeclaration, localPair.getCdr())));
      return true;
      paramTranslator.error('w', "duplicate declaration for `" + localObject + "'");
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.commonlisp.lang.defun
 * JD-Core Version:    0.6.2
 */