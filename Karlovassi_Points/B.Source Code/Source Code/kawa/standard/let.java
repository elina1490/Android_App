package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;

public class let extends Syntax
{
  public static final let let = new let();

  static
  {
    let.setName("let");
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    if (!(paramObject instanceof Pair))
      return paramTranslator.syntaxError("missing let arguments");
    Pair localPair1 = (Pair)paramObject;
    Object localObject1 = localPair1.getCar();
    Object localObject2 = localPair1.getCdr();
    int i = Translator.listLength(localObject1);
    if (i < 0)
      return paramTranslator.syntaxError("bindings not a proper list");
    Expression[] arrayOfExpression = new Expression[i];
    LetExp localLetExp = new LetExp(arrayOfExpression);
    Stack localStack = null;
    int j = 0;
    SyntaxForm localSyntaxForm1 = null;
    for (int k = 0; k < i; k++)
    {
      while ((localObject1 instanceof SyntaxForm))
      {
        localSyntaxForm1 = (SyntaxForm)localObject1;
        localObject1 = localSyntaxForm1.getDatum();
      }
      Pair localPair2 = (Pair)localObject1;
      Object localObject3 = localPair2.getCar();
      SyntaxForm localSyntaxForm2 = localSyntaxForm1;
      if ((localObject3 instanceof SyntaxForm))
      {
        localSyntaxForm2 = (SyntaxForm)localObject3;
        localObject3 = localSyntaxForm2.getDatum();
      }
      if (!(localObject3 instanceof Pair))
        return paramTranslator.syntaxError("let binding is not a pair:" + localObject3);
      Pair localPair3 = (Pair)localObject3;
      Object localObject4 = localPair3.getCar();
      TemplateScope localTemplateScope;
      Object localObject5;
      if ((localObject4 instanceof SyntaxForm))
      {
        SyntaxForm localSyntaxForm3 = (SyntaxForm)localObject4;
        localObject4 = localSyntaxForm3.getDatum();
        localTemplateScope = localSyntaxForm3.getScope();
        localObject5 = paramTranslator.namespaceResolve(localObject4);
        if (!(localObject5 instanceof Symbol))
          return paramTranslator.syntaxError("variable " + localObject5 + " in let binding is not a symbol: " + paramObject);
      }
      else
      {
        if (localSyntaxForm2 == null);
        for (localTemplateScope = null; ; localTemplateScope = localSyntaxForm2.getScope())
          break;
      }
      Declaration localDeclaration1 = localLetExp.addDeclaration(localObject5);
      localDeclaration1.setFlag(262144L);
      if (localTemplateScope != null)
      {
        Declaration localDeclaration2 = paramTranslator.makeRenamedAlias(localDeclaration1, localTemplateScope);
        if (localStack == null)
          localStack = new Stack();
        localStack.push(localDeclaration2);
        j++;
      }
      for (Object localObject6 = localPair3.getCdr(); (localObject6 instanceof SyntaxForm); localObject6 = localSyntaxForm2.getDatum())
        localSyntaxForm2 = (SyntaxForm)localObject6;
      if (!(localObject6 instanceof Pair))
        return paramTranslator.syntaxError("let has no value for '" + localObject5 + "'");
      Pair localPair4 = (Pair)localObject6;
      for (Object localObject7 = localPair4.getCdr(); (localObject7 instanceof SyntaxForm); localObject7 = localSyntaxForm2.getDatum())
        localSyntaxForm2 = (SyntaxForm)localObject7;
      if (paramTranslator.matches(localPair4.getCar(), "::"))
      {
        if ((localObject7 instanceof Pair))
        {
          localPair4 = (Pair)localObject7;
          if (localPair4.getCdr() != LList.Empty);
        }
        else
        {
          return paramTranslator.syntaxError("missing type after '::' in let");
        }
        for (localObject7 = localPair4.getCdr(); (localObject7 instanceof SyntaxForm); localObject7 = localSyntaxForm2.getDatum())
          localSyntaxForm2 = (SyntaxForm)localObject7;
      }
      LList localLList = LList.Empty;
      if (localObject7 == localLList);
      for (Pair localPair5 = localPair4; ; localPair5 = (Pair)localObject7)
      {
        arrayOfExpression[k] = paramTranslator.rewrite_car(localPair5, localSyntaxForm2);
        if (localPair5.getCdr() == LList.Empty)
          break label692;
        return paramTranslator.syntaxError("junk after declaration of " + localObject5);
        if (!(localObject7 instanceof Pair))
          break;
        localDeclaration1.setType(paramTranslator.exp2Type(localPair4));
        localDeclaration1.setFlag(8192L);
      }
      return paramTranslator.syntaxError("let binding for '" + localObject5 + "' is improper list");
      label692: localDeclaration1.noteValue(arrayOfExpression[k]);
      localObject1 = localPair2.getCdr();
    }
    int m = j;
    while (true)
    {
      m--;
      if (m < 0)
        break;
      paramTranslator.pushRenamedAlias((Declaration)localStack.pop());
    }
    paramTranslator.push(localLetExp);
    localLetExp.body = paramTranslator.rewrite_body(localObject2);
    paramTranslator.pop(localLetExp);
    paramTranslator.popRenamedAlias(j);
    return localLetExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.let
 * JD-Core Version:    0.6.2
 */