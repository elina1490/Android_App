package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BlockExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExitExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.math.IntNum;
import java.util.Vector;
import kawa.lang.Pattern;
import kawa.lang.PatternScope;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxPattern;
import kawa.lang.Translator;

public class syntax_case extends Syntax
{
  public static final syntax_case syntax_case = new syntax_case();
  PrimProcedure call_error;

  static
  {
    syntax_case.setName("syntax-case");
  }

  public static Object error(String paramString, Object paramObject)
  {
    Translator localTranslator = (Translator)Compilation.getCurrent();
    if (localTranslator == null)
      throw new RuntimeException("no match in syntax-case");
    Syntax localSyntax = localTranslator.getCurrentSyntax();
    if (localSyntax == null);
    for (String str = "some syntax"; ; str = localSyntax.getName())
      return localTranslator.syntaxError("no matching case while expanding " + str);
  }

  Expression rewriteClauses(Object paramObject, syntax_case_work paramsyntax_case_work, Translator paramTranslator)
  {
    Language localLanguage = paramTranslator.getLanguage();
    if (paramObject == LList.Empty)
    {
      Expression[] arrayOfExpression3 = new Expression[2];
      arrayOfExpression3[0] = new QuoteExp("syntax-case");
      arrayOfExpression3[1] = new ReferenceExp(paramsyntax_case_work.inputExpression);
      if (this.call_error == null)
      {
        ClassType localClassType = ClassType.make("kawa.standard.syntax_case");
        Type[] arrayOfType = new Type[2];
        arrayOfType[0] = Compilation.javaStringType;
        arrayOfType[1] = Type.objectType;
        Method localMethod = localClassType.addMethod("error", arrayOfType, Type.objectType, 9);
        PrimProcedure localPrimProcedure2 = new PrimProcedure(localMethod, localLanguage);
        this.call_error = localPrimProcedure2;
      }
      ApplyExp localApplyExp2 = new ApplyExp(this.call_error, arrayOfExpression3);
      return localApplyExp2;
    }
    Object localObject1 = paramTranslator.pushPositionOf(paramObject);
    PatternScope localPatternScope;
    SyntaxForm localSyntaxForm;
    Object localObject4;
    BlockExp localBlockExp;
    ApplyExp localApplyExp1;
    Expression[] arrayOfExpression2;
    try
    {
      Object localObject3;
      if ((paramObject instanceof Pair))
      {
        localObject3 = ((Pair)paramObject).getCar();
        if ((localObject3 instanceof Pair));
      }
      else
      {
        Expression localExpression1 = paramTranslator.syntaxError("syntax-case:  bad clause list");
        return localExpression1;
      }
      Pair localPair1 = (Pair)localObject3;
      localPatternScope = PatternScope.push(paramTranslator);
      localPatternScope.matchArray = paramTranslator.matchArray;
      paramTranslator.push(localPatternScope);
      localSyntaxForm = null;
      for (localObject4 = localPair1.getCdr(); (localObject4 instanceof SyntaxForm); localObject4 = localSyntaxForm.getDatum())
        localSyntaxForm = (SyntaxForm)localObject4;
      if (!(localObject4 instanceof Pair))
      {
        Expression localExpression5 = paramTranslator.syntaxError("missing syntax-case output expression");
        return localExpression5;
      }
      int i = localPatternScope.pattern_names.size();
      SyntaxPattern localSyntaxPattern = new SyntaxPattern(localPair1.getCar(), paramsyntax_case_work.literal_identifiers, paramTranslator);
      int j = localSyntaxPattern.varCount();
      if (j > paramsyntax_case_work.maxVars)
        paramsyntax_case_work.maxVars = j;
      localBlockExp = new BlockExp();
      Expression[] arrayOfExpression1 = new Expression[4];
      QuoteExp localQuoteExp = new QuoteExp(localSyntaxPattern);
      arrayOfExpression1[0] = localQuoteExp;
      arrayOfExpression1[1] = new ReferenceExp(paramsyntax_case_work.inputExpression);
      arrayOfExpression1[2] = new ReferenceExp(paramTranslator.matchArray);
      arrayOfExpression1[3] = new QuoteExp(IntNum.zero());
      PrimProcedure localPrimProcedure1 = new PrimProcedure(Pattern.matchPatternMethod, localLanguage);
      localApplyExp1 = new ApplyExp(localPrimProcedure1, arrayOfExpression1);
      int k = j - i;
      arrayOfExpression2 = new Expression[k];
      int m = k;
      while (true)
      {
        m--;
        if (m < 0)
          break;
        arrayOfExpression2[m] = QuoteExp.undefined_exp;
      }
    }
    finally
    {
      paramTranslator.popPositionOf(localObject1);
    }
    localPatternScope.inits = arrayOfExpression2;
    Pair localPair2 = (Pair)localObject4;
    if (localPair2.getCdr() == LList.Empty);
    Expression localExpression2;
    Expression localExpression4;
    ExitExp localExitExp1;
    for (Object localObject5 = paramTranslator.rewrite_car(localPair2, localSyntaxForm); ; localObject5 = new IfExp(localExpression2, localExpression4, localExitExp1))
    {
      localPatternScope.setBody((Expression)localObject5);
      paramTranslator.pop(localPatternScope);
      PatternScope.pop(paramTranslator);
      ExitExp localExitExp2 = new ExitExp(localBlockExp);
      IfExp localIfExp = new IfExp(localApplyExp1, localPatternScope, localExitExp2);
      localBlockExp.setBody(localIfExp, rewriteClauses(((Pair)paramObject).getCdr(), paramsyntax_case_work, paramTranslator));
      paramTranslator.popPositionOf(localObject1);
      return localBlockExp;
      localExpression2 = paramTranslator.rewrite_car(localPair2, localSyntaxForm);
      Pair localPair3;
      if ((localPair2.getCdr() instanceof Pair))
      {
        localPair3 = (Pair)localPair2.getCdr();
        if (localPair3.getCdr() == LList.Empty);
      }
      else
      {
        Expression localExpression3 = paramTranslator.syntaxError("syntax-case:  bad clause");
        paramTranslator.popPositionOf(localObject1);
        return localExpression3;
      }
      localExpression4 = paramTranslator.rewrite_car(localPair3, localSyntaxForm);
      localExitExp1 = new ExitExp(localBlockExp);
    }
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    syntax_case_work localsyntax_case_work = new syntax_case_work();
    Object localObject = paramPair.getCdr();
    if (((localObject instanceof Pair)) && ((((Pair)localObject).getCdr() instanceof Pair)))
    {
      Expression[] arrayOfExpression1 = new Expression[2];
      LetExp localLetExp = new LetExp(arrayOfExpression1);
      localsyntax_case_work.inputExpression = localLetExp.addDeclaration((String)null);
      Declaration localDeclaration1 = paramTranslator.matchArray;
      Declaration localDeclaration2 = localLetExp.addDeclaration((String)null);
      localDeclaration2.setType(Compilation.objArrayType);
      localDeclaration2.setCanRead(true);
      paramTranslator.matchArray = localDeclaration2;
      localsyntax_case_work.inputExpression.setCanRead(true);
      paramTranslator.push(localLetExp);
      Pair localPair1 = (Pair)localObject;
      arrayOfExpression1[0] = paramTranslator.rewrite(localPair1.getCar());
      localsyntax_case_work.inputExpression.noteValue(arrayOfExpression1[0]);
      Pair localPair2 = (Pair)localPair1.getCdr();
      localsyntax_case_work.literal_identifiers = SyntaxPattern.getLiteralsList(localPair2.getCar(), null, paramTranslator);
      localLetExp.body = rewriteClauses(localPair2.getCdr(), localsyntax_case_work, paramTranslator);
      paramTranslator.pop(localLetExp);
      Method localMethod = ClassType.make("kawa.lang.SyntaxPattern").getDeclaredMethod("allocVars", 2);
      Expression[] arrayOfExpression2 = new Expression[2];
      arrayOfExpression2[0] = new QuoteExp(IntNum.make(localsyntax_case_work.maxVars));
      if (localDeclaration1 == null)
        arrayOfExpression2[1] = QuoteExp.nullExp;
      while (true)
      {
        arrayOfExpression1[1] = new ApplyExp(localMethod, arrayOfExpression2);
        localDeclaration2.noteValue(arrayOfExpression1[1]);
        paramTranslator.matchArray = localDeclaration1;
        return localLetExp;
        arrayOfExpression2[1] = new ReferenceExp(localDeclaration1);
      }
    }
    return paramTranslator.syntaxError("insufficiant arguments to syntax-case");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.syntax_case
 * JD-Core Version:    0.6.2
 */