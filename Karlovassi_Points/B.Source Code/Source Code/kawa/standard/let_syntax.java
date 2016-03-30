package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Macro;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class let_syntax extends Syntax
{
  public static final let_syntax let_syntax = new let_syntax(false, "let-syntax");
  public static final let_syntax letrec_syntax = new let_syntax(true, "letrec-syntax");
  boolean recursive;

  public let_syntax(boolean paramBoolean, String paramString)
  {
    super(paramString);
    this.recursive = paramBoolean;
  }

  private void push(LetExp paramLetExp, Translator paramTranslator, Stack paramStack)
  {
    paramTranslator.push(paramLetExp);
    if (paramStack != null)
    {
      int i = paramStack.size();
      while (true)
      {
        i--;
        if (i < 0)
          break;
        paramTranslator.pushRenamedAlias((Declaration)paramStack.pop());
      }
    }
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    if (!(paramObject instanceof Pair))
      return paramTranslator.syntaxError("missing let-syntax arguments");
    Pair localPair1 = (Pair)paramObject;
    Object localObject1 = localPair1.getCar();
    Object localObject2 = localPair1.getCdr();
    int i = Translator.listLength(localObject1);
    if (i < 0)
      return paramTranslator.syntaxError("bindings not a proper list");
    Stack localStack = null;
    int j = 0;
    Expression[] arrayOfExpression = new Expression[i];
    Declaration[] arrayOfDeclaration = new Declaration[i];
    Macro[] arrayOfMacro = new Macro[i];
    Pair[] arrayOfPair = new Pair[i];
    SyntaxForm[] arrayOfSyntaxForm = new SyntaxForm[i];
    LetExp localLetExp = new LetExp(arrayOfExpression);
    SyntaxForm localSyntaxForm1 = null;
    int k = 0;
    if (k < i)
    {
      while ((localObject1 instanceof SyntaxForm))
      {
        localSyntaxForm1 = (SyntaxForm)localObject1;
        localObject1 = localSyntaxForm1.getDatum();
      }
      SyntaxForm localSyntaxForm2 = localSyntaxForm1;
      Pair localPair2 = (Pair)localObject1;
      Object localObject3 = localPair2.getCar();
      if ((localObject3 instanceof SyntaxForm))
      {
        localSyntaxForm2 = (SyntaxForm)localObject3;
        localObject3 = localSyntaxForm2.getDatum();
      }
      if (!(localObject3 instanceof Pair))
        return paramTranslator.syntaxError(getName() + " binding is not a pair");
      Pair localPair3 = (Pair)localObject3;
      Object localObject4 = localPair3.getCar();
      SyntaxForm localSyntaxForm3 = localSyntaxForm2;
      while ((localObject4 instanceof SyntaxForm))
      {
        localSyntaxForm3 = (SyntaxForm)localObject4;
        localObject4 = localSyntaxForm3.getDatum();
      }
      if ((!(localObject4 instanceof String)) && (!(localObject4 instanceof Symbol)))
        return paramTranslator.syntaxError("variable in " + getName() + " binding is not a symbol");
      for (Object localObject5 = localPair3.getCdr(); (localObject5 instanceof SyntaxForm); localObject5 = localSyntaxForm2.getDatum())
        localSyntaxForm2 = (SyntaxForm)localObject5;
      if (!(localObject5 instanceof Pair))
        return paramTranslator.syntaxError(getName() + " has no value for '" + localObject4 + "'");
      Pair localPair4 = (Pair)localObject5;
      if (localPair4.getCdr() != LList.Empty)
        return paramTranslator.syntaxError("let binding for '" + localObject4 + "' is improper list");
      Declaration localDeclaration2 = new Declaration(localObject4);
      Macro localMacro3 = Macro.make(localDeclaration2);
      arrayOfMacro[k] = localMacro3;
      arrayOfPair[k] = localPair4;
      arrayOfSyntaxForm[k] = localSyntaxForm2;
      localLetExp.addDeclaration(localDeclaration2);
      Object localObject6;
      label493: Object localObject7;
      if (localSyntaxForm3 == null)
      {
        localObject6 = null;
        if (localObject6 != null)
        {
          Declaration localDeclaration3 = paramTranslator.makeRenamedAlias(localDeclaration2, (ScopeExp)localObject6);
          if (localStack == null)
            localStack = new Stack();
          localStack.push(localDeclaration3);
          j++;
        }
        if (localSyntaxForm2 == null)
          break label594;
        localObject7 = localSyntaxForm2.getScope();
      }
      while (true)
      {
        localMacro3.setCapturedScope((ScopeExp)localObject7);
        arrayOfDeclaration[k] = localDeclaration2;
        arrayOfExpression[k] = QuoteExp.nullExp;
        localObject1 = localPair2.getCdr();
        k++;
        break;
        localObject6 = localSyntaxForm3.getScope();
        break label493;
        label594: if (this.recursive)
          localObject7 = localLetExp;
        else
          localObject7 = paramTranslator.currentScope();
      }
    }
    if (this.recursive)
      push(localLetExp, paramTranslator, localStack);
    Macro localMacro1 = paramTranslator.currentMacroDefinition;
    for (int m = 0; m < i; m++)
    {
      Macro localMacro2 = arrayOfMacro[m];
      paramTranslator.currentMacroDefinition = localMacro2;
      Expression localExpression2 = paramTranslator.rewrite_car(arrayOfPair[m], arrayOfSyntaxForm[m]);
      arrayOfExpression[m] = localExpression2;
      Declaration localDeclaration1 = arrayOfDeclaration[m];
      localMacro2.expander = localExpression2;
      QuoteExp localQuoteExp = new QuoteExp(localMacro2);
      localDeclaration1.noteValue(localQuoteExp);
      if ((localExpression2 instanceof LambdaExp))
      {
        LambdaExp localLambdaExp = (LambdaExp)localExpression2;
        localLambdaExp.nameDecl = localDeclaration1;
        localLambdaExp.setSymbol(localDeclaration1.getSymbol());
      }
    }
    paramTranslator.currentMacroDefinition = localMacro1;
    if (!this.recursive)
      push(localLetExp, paramTranslator, localStack);
    Expression localExpression1 = paramTranslator.rewrite_body(localObject2);
    paramTranslator.pop(localLetExp);
    paramTranslator.popRenamedAlias(j);
    return localExpression1;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.let_syntax
 * JD-Core Version:    0.6.2
 */