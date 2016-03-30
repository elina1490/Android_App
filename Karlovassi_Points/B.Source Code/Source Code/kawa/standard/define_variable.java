package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class define_variable extends Syntax
{
  public static final define_variable define_variable = new define_variable();

  static
  {
    define_variable.setName("define-variable");
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    boolean bool1 = localObject1 instanceof Pair;
    Declaration localDeclaration = null;
    Expression localExpression = null;
    Object localObject3;
    if (bool1)
    {
      Pair localPair1 = (Pair)localObject1;
      Object localObject2 = localPair1.getCar();
      if (((localObject2 instanceof String)) || ((localObject2 instanceof Symbol)))
        return paramTranslator.syntaxError(getName() + " is only allowed in a <body>");
      boolean bool2 = localObject2 instanceof Declaration;
      localDeclaration = null;
      localExpression = null;
      if (bool2)
      {
        localDeclaration = (Declaration)localPair1.getCar();
        localObject3 = localPair1.getCdr();
        if (!(localObject3 instanceof Pair))
          break label182;
        Pair localPair2 = (Pair)localObject3;
        if (localPair2.getCdr() != LList.Empty)
          break label182;
        localExpression = paramTranslator.rewrite(localPair2.getCar());
      }
    }
    while (localDeclaration == null)
    {
      return paramTranslator.syntaxError("invalid syntax for " + getName());
      label182: LList localLList = LList.Empty;
      localExpression = null;
      if (localObject3 != localLList)
      {
        localDeclaration = null;
        localExpression = null;
      }
    }
    if (localExpression == null)
      return QuoteExp.voidExp;
    SetExp localSetExp = new SetExp(localDeclaration, localExpression);
    localSetExp.setDefining(true);
    localSetExp.setSetIfUnbound(true);
    if (localDeclaration != null)
    {
      localSetExp.setBinding(localDeclaration);
      if (((localDeclaration.context instanceof ModuleExp)) && (localDeclaration.getCanWrite()))
        localExpression = null;
      localDeclaration.noteValue(localExpression);
    }
    return localSetExp;
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    if (!(paramPair.getCdr() instanceof Pair))
      return super.scanForDefinitions(paramPair, paramVector, paramScopeExp, paramTranslator);
    Pair localPair = (Pair)paramPair.getCdr();
    Object localObject = localPair.getCar();
    if (((localObject instanceof String)) || ((localObject instanceof Symbol)))
    {
      if (paramScopeExp.lookup(localObject) != null)
        paramTranslator.error('e', "duplicate declaration for '" + localObject + "'");
      Declaration localDeclaration = paramScopeExp.addDeclaration(localObject);
      paramTranslator.push(localDeclaration);
      localDeclaration.setSimple(false);
      localDeclaration.setPrivate(true);
      localDeclaration.setFlag(268697600L);
      localDeclaration.setCanRead(true);
      localDeclaration.setCanWrite(true);
      localDeclaration.setIndirectBinding(true);
      paramPair = Translator.makePair(paramPair, this, Translator.makePair(localPair, localDeclaration, localPair.getCdr()));
    }
    paramVector.addElement(paramPair);
    return true;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.define_variable
 * JD-Core Version:    0.6.2
 */