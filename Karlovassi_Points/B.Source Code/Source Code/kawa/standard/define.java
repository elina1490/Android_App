package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class define extends Syntax
{
  public static final define defineRaw = new define(SchemeCompilation.lambda);
  Lambda lambda;

  public define(Lambda paramLambda)
  {
    this.lambda = paramLambda;
  }

  String getName(int paramInt)
  {
    if ((paramInt & 0x4) != 0)
      return "define-private";
    if ((paramInt & 0x8) != 0)
      return "define-constant";
    return "define";
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Pair localPair1 = (Pair)paramPair.getCdr();
    Pair localPair2 = (Pair)localPair1.getCdr();
    Pair localPair3 = (Pair)((Pair)localPair2.getCdr()).getCdr();
    Object localObject1 = Translator.stripSyntax(localPair1.getCar());
    int i = ((Number)Translator.stripSyntax(localPair2.getCar())).intValue();
    if ((i & 0x4) != 0);
    for (int j = 1; !(localObject1 instanceof Declaration); j = 0)
      return paramTranslator.syntaxError(getName(i) + " is only allowed in a <body>");
    Declaration localDeclaration = (Declaration)localObject1;
    if (localDeclaration.getFlag(8192L))
    {
      Expression localExpression = localDeclaration.getTypeExp();
      if ((localExpression instanceof LangExp))
        localDeclaration.setType(paramTranslator.exp2Type((Pair)((LangExp)localExpression).getLangValue()));
    }
    if ((i & 0x2) != 0)
    {
      LambdaExp localLambdaExp = (LambdaExp)localDeclaration.getValue();
      Object localObject4 = localPair3.getCdr();
      this.lambda.rewriteBody(localLambdaExp, localObject4, paramTranslator);
      localObject2 = localLambdaExp;
      if (!Compilation.inlineOk)
        localDeclaration.noteValue(null);
      SetExp localSetExp = new SetExp(localDeclaration, (Expression)localObject2);
      localSetExp.setDefining(true);
      if ((j != 0) && (!(paramTranslator.currentScope() instanceof ModuleExp)))
        paramTranslator.error('w', "define-private not at top level " + paramTranslator.currentScope());
      return localSetExp;
    }
    Object localObject2 = paramTranslator.rewrite(localPair3.getCar());
    if (((localDeclaration.context instanceof ModuleExp)) && (j == 0) && (localDeclaration.getCanWrite()));
    for (Object localObject3 = null; ; localObject3 = localObject2)
    {
      localDeclaration.noteValue((Expression)localObject3);
      break;
    }
  }

  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Pair localPair1 = (Pair)paramPair.getCdr();
    Object localObject1 = (Pair)localPair1.getCdr();
    Pair localPair2 = (Pair)((Pair)localObject1).getCdr();
    Pair localPair3 = (Pair)localPair2.getCdr();
    SyntaxForm localSyntaxForm = null;
    for (Object localObject2 = localPair1.getCar(); (localObject2 instanceof SyntaxForm); localObject2 = localSyntaxForm.getDatum())
      localSyntaxForm = (SyntaxForm)localObject2;
    int i = ((Number)Translator.stripSyntax(((Pair)localObject1).getCar())).intValue();
    int j;
    if ((i & 0x4) != 0)
    {
      j = 1;
      if ((i & 0x8) == 0)
        break label508;
    }
    label508: for (int k = 1; ; k = 0)
    {
      paramTranslator.currentScope();
      Object localObject3 = paramTranslator.namespaceResolve(localObject2);
      if (!(localObject3 instanceof Symbol))
      {
        paramTranslator.error('e', "'" + localObject3 + "' is not a valid identifier");
        localObject3 = null;
      }
      Object localObject4 = paramTranslator.pushPositionOf(localPair1);
      Declaration localDeclaration = paramTranslator.define(localObject3, localSyntaxForm, paramScopeExp);
      paramTranslator.popPositionOf(localObject4);
      Object localObject5 = localDeclaration.getSymbol();
      if (j != 0)
      {
        localDeclaration.setFlag(16777216L);
        localDeclaration.setPrivate(true);
      }
      if (k != 0)
        localDeclaration.setFlag(16384L);
      localDeclaration.setFlag(262144L);
      if ((i & 0x2) != 0)
      {
        LambdaExp localLambdaExp = new LambdaExp();
        localLambdaExp.setSymbol(localObject5);
        if (Compilation.inlineOk)
        {
          localDeclaration.setProcedureDecl(true);
          localDeclaration.setType(Compilation.typeProcedure);
          localLambdaExp.nameDecl = localDeclaration;
        }
        Object localObject6 = localPair3.getCar();
        Object localObject7 = localPair3.getCdr();
        Translator.setLine(localLambdaExp, localPair1);
        this.lambda.rewriteFormals(localLambdaExp, localObject6, paramTranslator, null);
        Object localObject8 = this.lambda.rewriteAttrs(localLambdaExp, localObject7, paramTranslator);
        if (localObject8 != localObject7)
        {
          Object localObject9 = ((Pair)localObject1).getCar();
          Object localObject10 = localPair2.getCar();
          Pair localPair5 = new Pair(localObject6, localObject8);
          Pair localPair6 = new Pair(localObject9, new Pair(localObject10, localPair5));
          localObject1 = localPair6;
        }
        localDeclaration.noteValue(localLambdaExp);
      }
      if (((paramScopeExp instanceof ModuleExp)) && (j == 0) && ((!Compilation.inlineOk) || (paramTranslator.sharedModuleDefs())))
        localDeclaration.setCanWrite(true);
      if ((i & 0x1) != 0)
      {
        LangExp localLangExp = new LangExp(localPair2);
        localDeclaration.setTypeExp(localLangExp);
        localDeclaration.setFlag(8192L);
      }
      Pair localPair4 = Translator.makePair(paramPair, this, Translator.makePair(localPair1, localDeclaration, localObject1));
      Translator.setLine(localDeclaration, localPair1);
      paramTranslator.formStack.addElement(localPair4);
      return;
      j = 0;
      break;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.define
 * JD-Core Version:    0.6.2
 */