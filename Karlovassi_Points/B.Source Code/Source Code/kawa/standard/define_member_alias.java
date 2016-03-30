package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.lists.Pair;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class define_member_alias extends Syntax
{
  public static final define_member_alias define_member_alias = new define_member_alias();

  static
  {
    define_member_alias.setName("define-member-alias");
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    Pair localPair1;
    if ((localObject1 instanceof Pair))
    {
      localPair1 = (Pair)localObject1;
      if (((localPair1.getCar() instanceof String)) || ((localPair1.getCar() instanceof Declaration)));
    }
    else
    {
      return paramTranslator.syntaxError("missing name in " + getName());
    }
    if ((localPair1.getCdr() instanceof Pair))
    {
      Object localObject2 = localPair1.getCar();
      String str;
      Expression localExpression;
      Object localObject3;
      Object localObject4;
      if ((localObject2 instanceof Declaration))
      {
        str = ((Declaration)localObject2).getName();
        Pair localPair2 = (Pair)localPair1.getCdr();
        localExpression = paramTranslator.rewrite(localPair2.getCar());
        localObject3 = localPair2.getCdr();
        if (localObject3 != LList.Empty)
          break label216;
        localObject4 = new QuoteExp(Compilation.mangleName(str));
      }
      while (true)
      {
        if (localObject4 == null)
          break label274;
        ClassType localClassType = ClassType.make("gnu.kawa.reflect.ClassMemberConstraint");
        Expression[] arrayOfExpression = new Expression[3];
        arrayOfExpression[0] = new QuoteExp(str);
        arrayOfExpression[1] = localExpression;
        arrayOfExpression[2] = localObject4;
        return Invoke.makeInvokeStatic(localClassType, "define", arrayOfExpression);
        str = (String)localObject2;
        break;
        label216: boolean bool = localObject3 instanceof Pair;
        localObject4 = null;
        if (bool)
        {
          Pair localPair3 = (Pair)localObject3;
          Object localObject5 = localPair3.getCdr();
          LList localLList = LList.Empty;
          localObject4 = null;
          if (localObject5 == localLList)
            localObject4 = paramTranslator.rewrite(localPair3.getCar());
        }
      }
    }
    label274: return paramTranslator.syntaxError("invalid syntax for " + getName());
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Pair localPair;
    if (((paramPair.getCdr() instanceof Pair)) && (!(paramTranslator.currentScope() instanceof ModuleExp)))
    {
      localPair = (Pair)paramPair.getCdr();
      if ((localPair.getCar() instanceof String));
    }
    else
    {
      return super.scanForDefinitions(paramPair, paramVector, paramScopeExp, paramTranslator);
    }
    Declaration localDeclaration = paramScopeExp.addDeclaration((String)localPair.getCar(), Compilation.typeSymbol);
    localDeclaration.setIndirectBinding(true);
    paramVector.addElement(Translator.makePair(paramPair, this, Translator.makePair(localPair, localDeclaration, localPair.getCdr())));
    return true;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.define_member_alias
 * JD-Core Version:    0.6.2
 */