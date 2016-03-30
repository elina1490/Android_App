package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.ClassExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class define_alias extends Syntax
{
  public static final define_alias define_alias = new define_alias();

  static
  {
    define_alias.setName("define-alias");
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    return paramTranslator.syntaxError("define-alias is only allowed in a <body>");
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    SyntaxForm localSyntaxForm1 = null;
    while ((localObject1 instanceof SyntaxForm))
    {
      localSyntaxForm1 = (SyntaxForm)localObject1;
      localObject1 = localSyntaxForm1.getDatum();
    }
    if ((localObject1 instanceof Pair))
    {
      Pair localPair1 = (Pair)localObject1;
      SyntaxForm localSyntaxForm2 = localSyntaxForm1;
      for (Object localObject2 = localPair1.getCar(); (localObject2 instanceof SyntaxForm); localObject2 = localSyntaxForm2.getDatum())
        localSyntaxForm2 = (SyntaxForm)localObject2;
      for (Object localObject3 = localPair1.getCdr(); (localObject3 instanceof SyntaxForm); localObject3 = localSyntaxForm1.getDatum())
        localSyntaxForm1 = (SyntaxForm)localObject3;
      if ((((localObject2 instanceof String)) || ((localObject2 instanceof Symbol))) && ((localObject3 instanceof Pair)))
      {
        Pair localPair2 = (Pair)localObject3;
        if (localPair2.getCdr() == LList.Empty)
        {
          Declaration localDeclaration1 = paramTranslator.define(localObject2, localSyntaxForm2, paramScopeExp);
          localDeclaration1.setIndirectBinding(true);
          localDeclaration1.setAlias(true);
          Expression localExpression1 = paramTranslator.rewrite_car(localPair2, localSyntaxForm1);
          ReferenceExp localReferenceExp;
          if ((localExpression1 instanceof ReferenceExp))
          {
            localReferenceExp = (ReferenceExp)localExpression1;
            Declaration localDeclaration2 = Declaration.followAliases(localReferenceExp.getBinding());
            if (localDeclaration2 != null)
            {
              Expression localExpression2 = localDeclaration2.getValue();
              if (((localExpression2 instanceof ClassExp)) || ((localExpression2 instanceof ModuleExp)))
              {
                localDeclaration1.setIndirectBinding(false);
                localDeclaration1.setFlag(16384L);
              }
            }
          }
          while (true)
          {
            paramTranslator.mustCompileHere();
            paramTranslator.push(localDeclaration1);
            SetExp localSetExp = new SetExp(localDeclaration1, localExpression1);
            paramTranslator.setLineOf(localSetExp);
            localDeclaration1.noteValue(localExpression1);
            localSetExp.setDefining(true);
            paramVector.addElement(localSetExp);
            return true;
            localReferenceExp.setDontDereference(true);
            continue;
            if ((localExpression1 instanceof QuoteExp))
            {
              localDeclaration1.setIndirectBinding(false);
              localDeclaration1.setFlag(16384L);
            }
            else
            {
              localExpression1 = location.rewrite(localExpression1, paramTranslator);
              localDeclaration1.setType(ClassType.make("gnu.mapping.Location"));
            }
          }
        }
      }
    }
    paramTranslator.error('e', "invalid syntax for define-alias");
    return false;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.define_alias
 * JD-Core Version:    0.6.2
 */