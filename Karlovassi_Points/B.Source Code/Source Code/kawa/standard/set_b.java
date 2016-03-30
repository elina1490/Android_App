package kawa.standard;

import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.CompilationHelpers;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class set_b extends Syntax
{
  public static final set_b set = new set_b();

  static
  {
    set.setName("set!");
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    SyntaxForm localSyntaxForm = null;
    while ((localObject1 instanceof SyntaxForm))
    {
      localSyntaxForm = (SyntaxForm)localObject1;
      localObject1 = localSyntaxForm.getDatum();
    }
    if (!(localObject1 instanceof Pair))
      return paramTranslator.syntaxError("missing name");
    Pair localPair1 = (Pair)localObject1;
    Expression localExpression1 = paramTranslator.rewrite_car(localPair1, localSyntaxForm);
    for (Object localObject2 = localPair1.getCdr(); (localObject2 instanceof SyntaxForm); localObject2 = localSyntaxForm.getDatum())
      localSyntaxForm = (SyntaxForm)localObject2;
    Pair localPair2;
    if ((localObject2 instanceof Pair))
    {
      localPair2 = (Pair)localObject2;
      if (localPair2.getCdr() == LList.Empty);
    }
    else
    {
      return paramTranslator.syntaxError("missing or extra arguments to set!");
    }
    Expression localExpression2 = paramTranslator.rewrite_car(localPair2, localSyntaxForm);
    if ((localExpression1 instanceof ApplyExp))
    {
      ApplyExp localApplyExp1 = (ApplyExp)localExpression1;
      Expression[] arrayOfExpression1 = localApplyExp1.getArgs();
      int i = arrayOfExpression1.length;
      Expression localExpression3 = localApplyExp1.getFunction();
      int j = arrayOfExpression1.length;
      int k = 0;
      if (j > 0)
      {
        boolean bool = localExpression3 instanceof ReferenceExp;
        k = 0;
        if (bool)
        {
          Declaration localDeclaration4 = ((ReferenceExp)localExpression3).getBinding();
          Declaration localDeclaration5 = Scheme.applyFieldDecl;
          k = 0;
          if (localDeclaration4 == localDeclaration5)
          {
            k = 1;
            i--;
            localExpression3 = arrayOfExpression1[0];
          }
        }
      }
      Expression[] arrayOfExpression2 = { localExpression3 };
      Expression[] arrayOfExpression3 = new Expression[i + 1];
      System.arraycopy(arrayOfExpression1, k, arrayOfExpression3, 0, i);
      arrayOfExpression3[i] = localExpression2;
      Declaration localDeclaration3 = CompilationHelpers.setterDecl;
      ReferenceExp localReferenceExp2 = new ReferenceExp(localDeclaration3);
      ApplyExp localApplyExp2 = new ApplyExp(localReferenceExp2, arrayOfExpression2);
      ApplyExp localApplyExp3 = new ApplyExp(localApplyExp2, arrayOfExpression3);
      return localApplyExp3;
    }
    if (!(localExpression1 instanceof ReferenceExp))
      return paramTranslator.syntaxError("first set! argument is not a variable name");
    ReferenceExp localReferenceExp1 = (ReferenceExp)localExpression1;
    Declaration localDeclaration1 = localReferenceExp1.getBinding();
    SetExp localSetExp = new SetExp(localReferenceExp1.getSymbol(), localExpression2);
    localSetExp.setContextDecl(localReferenceExp1.contextDecl());
    if (localDeclaration1 != null)
    {
      localDeclaration1.setCanWrite(true);
      localSetExp.setBinding(localDeclaration1);
      Declaration localDeclaration2 = Declaration.followAliases(localDeclaration1);
      if (localDeclaration2 != null)
        localDeclaration2.noteValue(localExpression2);
      if (localDeclaration2.getFlag(16384L))
        return paramTranslator.syntaxError("constant variable " + localDeclaration2.getName() + " is set!");
      if ((localDeclaration2.context != paramTranslator.mainLambda) && ((localDeclaration2.context instanceof ModuleExp)) && (!localDeclaration2.getFlag(268435456L)) && (!localDeclaration2.context.getFlag(1048576)))
        paramTranslator.error('w', localDeclaration2, "imported variable ", " is set!");
    }
    return localSetExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.set_b
 * JD-Core Version:    0.6.2
 */