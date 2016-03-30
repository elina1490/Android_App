package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.ThisExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Macro;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class define_syntax extends Syntax
{
  public static final define_syntax define_macro = new define_syntax("%define-macro", false);
  public static final define_syntax define_syntax = new define_syntax("%define-syntax", true);
  static PrimProcedure makeHygienic;
  static PrimProcedure makeNonHygienic;
  static PrimProcedure setCapturedScope;
  static ClassType typeMacro = ClassType.make("kawa.lang.Macro");
  boolean hygienic;

  static
  {
    makeHygienic = new PrimProcedure(typeMacro.getDeclaredMethod("make", 3));
    makeNonHygienic = new PrimProcedure(typeMacro.getDeclaredMethod("makeNonHygienic", 3));
    setCapturedScope = new PrimProcedure(typeMacro.getDeclaredMethod("setCapturedScope", 1));
    makeHygienic.setSideEffectFree();
    makeNonHygienic.setSideEffectFree();
  }

  public define_syntax()
  {
    this.hygienic = true;
  }

  public define_syntax(Object paramObject, boolean paramBoolean)
  {
    super(paramObject);
    this.hygienic = paramBoolean;
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    return paramTranslator.syntaxError("define-syntax not in a body");
  }

  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    SyntaxForm localSyntaxForm1 = null;
    for (Object localObject1 = paramPair.getCdr(); (localObject1 instanceof SyntaxForm); localObject1 = localSyntaxForm1.getDatum())
      localSyntaxForm1 = (SyntaxForm)localObject1;
    Object localObject2 = localObject1;
    Object localObject3;
    if ((localObject2 instanceof Pair))
    {
      Pair localPair = (Pair)localObject2;
      localObject3 = localPair.getCar();
      localObject2 = localPair.getCdr();
    }
    SyntaxForm localSyntaxForm2;
    Object localObject4;
    while (true)
    {
      localSyntaxForm2 = localSyntaxForm1;
      for (localObject4 = localObject3; (localObject4 instanceof SyntaxForm); localObject4 = localSyntaxForm2.getDatum())
        localSyntaxForm2 = (SyntaxForm)localObject4;
      localObject3 = null;
    }
    Object localObject5 = paramTranslator.namespaceResolve(localObject4);
    if (!(localObject5 instanceof Symbol))
    {
      paramTranslator.formStack.addElement(paramTranslator.syntaxError("missing macro name for " + Translator.safeCar(paramPair)));
      return;
    }
    if ((localObject2 == null) || (Translator.safeCdr(localObject2) != LList.Empty))
    {
      paramTranslator.formStack.addElement(paramTranslator.syntaxError("invalid syntax for " + getName()));
      return;
    }
    Declaration localDeclaration = paramTranslator.define(localObject5, localSyntaxForm2, paramScopeExp);
    localDeclaration.setType(typeMacro);
    paramTranslator.push(localDeclaration);
    Macro localMacro1 = paramTranslator.currentMacroDefinition;
    Macro localMacro2 = Macro.make(localDeclaration);
    localMacro2.setHygienic(this.hygienic);
    paramTranslator.currentMacroDefinition = localMacro2;
    Expression localExpression = paramTranslator.rewrite_car((Pair)localObject2, localSyntaxForm1);
    paramTranslator.currentMacroDefinition = localMacro1;
    localMacro2.expander = localExpression;
    if ((localExpression instanceof LambdaExp))
      ((LambdaExp)localExpression).setFlag(256);
    Expression[] arrayOfExpression1 = new Expression[3];
    QuoteExp localQuoteExp1 = new QuoteExp(localObject5);
    arrayOfExpression1[0] = localQuoteExp1;
    arrayOfExpression1[1] = localExpression;
    arrayOfExpression1[2] = ThisExp.makeGivingContext(paramScopeExp);
    if (this.hygienic);
    for (PrimProcedure localPrimProcedure = makeHygienic; ; localPrimProcedure = makeNonHygienic)
    {
      ApplyExp localApplyExp1 = new ApplyExp(localPrimProcedure, arrayOfExpression1);
      localDeclaration.noteValue(localApplyExp1);
      localDeclaration.setProcedureDecl(true);
      if (!(localDeclaration.context instanceof ModuleExp))
        break;
      SetExp localSetExp = new SetExp(localDeclaration, localApplyExp1);
      localSetExp.setDefining(true);
      if (paramTranslator.getLanguage().hasSeparateFunctionNamespace())
        localSetExp.setFuncDef(true);
      paramTranslator.formStack.addElement(localSetExp);
      if (!paramTranslator.immediate)
        break;
      Expression[] arrayOfExpression2 = new Expression[2];
      ReferenceExp localReferenceExp = new ReferenceExp(localDeclaration);
      arrayOfExpression2[0] = localReferenceExp;
      QuoteExp localQuoteExp2 = new QuoteExp(paramScopeExp);
      arrayOfExpression2[1] = localQuoteExp2;
      Stack localStack = paramTranslator.formStack;
      ApplyExp localApplyExp2 = new ApplyExp(setCapturedScope, arrayOfExpression2);
      localStack.addElement(localApplyExp2);
      return;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.define_syntax
 * JD-Core Version:    0.6.2
 */