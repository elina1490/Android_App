package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.InlineCalls;
import gnu.expr.Inlineable;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.expr.TryExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.lists.LList;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;
import kawa.standard.Scheme;

public class CompileMisc
  implements Inlineable
{
  static final int CONVERT = 2;
  static final int NOT = 3;
  static Method coerceMethod;
  public static final ClassType typeContinuation = ClassType.make("kawa.lang.Continuation");
  static ClassType typeType;
  int code;
  Procedure proc;

  public CompileMisc(Procedure paramProcedure, int paramInt)
  {
    this.proc = paramProcedure;
    this.code = paramInt;
  }

  private static LambdaExp canInlineCallCC(ApplyExp paramApplyExp)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if (arrayOfExpression.length == 1)
    {
      Expression localExpression = arrayOfExpression[0];
      if ((localExpression instanceof LambdaExp))
      {
        LambdaExp localLambdaExp = (LambdaExp)localExpression;
        if ((localLambdaExp.min_args == 1) && (localLambdaExp.max_args == 1) && (!localLambdaExp.firstDecl().getCanWrite()))
          return localLambdaExp;
      }
    }
    return null;
  }

  public static void compileCallCC(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget, Procedure paramProcedure)
  {
    LambdaExp localLambdaExp = canInlineCallCC(paramApplyExp);
    if (localLambdaExp == null)
    {
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Declaration localDeclaration1 = localLambdaExp.firstDecl();
    if ((localDeclaration1.isSimple()) && (!localDeclaration1.getCanRead()) && (!localDeclaration1.getCanWrite()))
    {
      CompileTimeContinuation localCompileTimeContinuation = new CompileTimeContinuation();
      if ((paramTarget instanceof StackTarget));
      for (Type localType = paramTarget.getType(); ; localType = null)
      {
        localCompileTimeContinuation.exitableBlock = localCodeAttr.startExitableBlock(localType, ExitThroughFinallyChecker.check(localDeclaration1, localLambdaExp.body));
        localCompileTimeContinuation.blockTarget = paramTarget;
        localDeclaration1.setValue(new QuoteExp(localCompileTimeContinuation));
        localLambdaExp.body.compile(paramCompilation, paramTarget);
        localCodeAttr.endExitableBlock();
        return;
      }
    }
    Variable localVariable = localCodeAttr.pushScope().addVariable(localCodeAttr, typeContinuation, null);
    Declaration localDeclaration2 = new Declaration(localVariable);
    localCodeAttr.emitNew(typeContinuation);
    localCodeAttr.emitDup(typeContinuation);
    paramCompilation.loadCallContext();
    localCodeAttr.emitInvokeSpecial(typeContinuation.getDeclaredMethod("<init>", 1));
    localCodeAttr.emitStore(localVariable);
    Object localObject;
    if (((paramTarget instanceof IgnoreTarget)) || ((paramTarget instanceof ConsumerTarget)))
    {
      localObject = null;
      localCodeAttr.emitTryStart(false, (Type)localObject);
      Expression[] arrayOfExpression = new Expression[1];
      arrayOfExpression[0] = new ReferenceExp(localDeclaration2);
      new ApplyExp(localLambdaExp, arrayOfExpression).compile(paramCompilation, paramTarget);
      if (localCodeAttr.reachableHere())
      {
        localCodeAttr.emitLoad(localVariable);
        localCodeAttr.emitPushInt(1);
        localCodeAttr.emitPutField(typeContinuation.getField("invoked"));
      }
      localCodeAttr.emitTryEnd();
      localCodeAttr.emitCatchStart(null);
      localCodeAttr.emitLoad(localVariable);
      if (!(paramTarget instanceof ConsumerTarget))
        break label371;
      paramCompilation.loadCallContext();
      localCodeAttr.emitInvokeStatic(typeContinuation.getDeclaredMethod("handleException$X", 3));
    }
    while (true)
    {
      localCodeAttr.emitCatchEnd();
      localCodeAttr.emitTryCatchEnd();
      localCodeAttr.popScope();
      return;
      localObject = Type.objectType;
      break;
      label371: localCodeAttr.emitInvokeStatic(typeContinuation.getDeclaredMethod("handleException", 2));
      paramTarget.compileFromStack(paramCompilation, Type.objectType);
    }
  }

  public static void compileConvert(Convert paramConvert, ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if (arrayOfExpression.length != 2)
      throw new Error("wrong number of arguments to " + paramConvert.getName());
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Type localType = Scheme.getTypeValue(arrayOfExpression[0]);
    if (localType != null)
    {
      arrayOfExpression[1].compile(paramCompilation, Target.pushValue(localType));
      if (localCodeAttr.reachableHere())
        paramTarget.compileFromStack(paramCompilation, localType);
      return;
    }
    if (typeType == null)
      typeType = ClassType.make("gnu.bytecode.Type");
    if (coerceMethod == null)
      coerceMethod = typeType.addMethod("coerceFromObject", Compilation.apply1args, Type.pointer_type, 1);
    arrayOfExpression[0].compile(paramCompilation, LangObjType.typeClassType);
    arrayOfExpression[1].compile(paramCompilation, Target.pushObject);
    localCodeAttr.emitInvokeVirtual(coerceMethod);
    paramTarget.compileFromStack(paramCompilation, Type.pointer_type);
  }

  public static CompileMisc forConvert(Object paramObject)
  {
    return new CompileMisc((Procedure)paramObject, 2);
  }

  public static CompileMisc forNot(Object paramObject)
  {
    return new CompileMisc((Procedure)paramObject, 3);
  }

  public static Expression validateApplyAppendValues(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if (arrayOfExpression.length == 1)
      return arrayOfExpression[0];
    if (arrayOfExpression.length == 0)
      return QuoteExp.voidExp;
    Expression localExpression = paramApplyExp.inlineIfConstant(paramProcedure, paramInlineCalls);
    if (localExpression != paramApplyExp)
      return localExpression;
    return paramApplyExp;
  }

  public static Expression validateApplyCallCC(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    LambdaExp localLambdaExp = canInlineCallCC(paramApplyExp);
    if (localLambdaExp != null)
    {
      localLambdaExp.setInlineOnly(true);
      localLambdaExp.returnContinuation = paramApplyExp;
      localLambdaExp.inlineHome = paramInlineCalls.getCurrentLambda();
      Declaration localDeclaration = localLambdaExp.firstDecl();
      if (!localDeclaration.getFlag(8192L))
        localDeclaration.setType(typeContinuation);
    }
    paramApplyExp.visitArgs(paramInlineCalls);
    return paramApplyExp;
  }

  public static Expression validateApplyConstantFunction0(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    int i = paramApplyExp.getArgCount();
    if ((i != 0) && (paramInlineCalls != null))
      return paramInlineCalls.noteError(WrongArguments.checkArgCount(paramProcedure, i));
    return ((ConstantFunction0)paramProcedure).constant;
  }

  public static Expression validateApplyConvert(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    Compilation localCompilation = paramInlineCalls.getCompilation();
    Language localLanguage = localCompilation.getLanguage();
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if (arrayOfExpression.length == 2)
    {
      arrayOfExpression[0] = paramInlineCalls.visit(arrayOfExpression[0], null);
      Type localType = localLanguage.getTypeFor(arrayOfExpression[0]);
      if ((localType instanceof Type))
      {
        arrayOfExpression[0] = new QuoteExp(localType);
        arrayOfExpression[1] = paramInlineCalls.visit(arrayOfExpression[1], localType);
        CompileReflect.checkKnownClass(localType, localCompilation);
        paramApplyExp.setType(localType);
        return paramApplyExp;
      }
    }
    paramApplyExp.visitArgs(paramInlineCalls);
    return paramApplyExp;
  }

  public static Expression validateApplyFormat(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    ClassType localClassType1 = Type.objectType;
    Object localObject1 = paramApplyExp.getArgs();
    if (localObject1.length > 0)
    {
      ClassType localClassType2 = ClassType.make("gnu.kawa.functions.Format");
      Object localObject3 = localObject1[0].valueIfConstant();
      Type localType = localObject1[0].getType();
      if ((localObject3 == Boolean.FALSE) || (localType.isSubtype(LangObjType.stringType)))
      {
        if (localObject3 == Boolean.FALSE);
        for (int i = 1; ; i = 0)
        {
          Expression[] arrayOfExpression1 = new Expression[1 + localObject1.length - i];
          arrayOfExpression1[0] = new QuoteExp(Integer.valueOf(0), Type.intType);
          System.arraycopy(localObject1, i, arrayOfExpression1, 1, arrayOfExpression1.length - 1);
          ApplyExp localApplyExp1 = new ApplyExp(localClassType2.getDeclaredMethod("formatToString", 2), arrayOfExpression1);
          localApplyExp1.setType(Type.javalangStringType);
          return localApplyExp1;
        }
      }
      if ((localObject3 == Boolean.TRUE) || (localType.isSubtype(ClassType.make("java.io.Writer"))))
      {
        if (localObject3 == Boolean.TRUE)
        {
          Expression[] arrayOfExpression2 = new Expression[localObject1.length];
          arrayOfExpression2[0] = QuoteExp.nullExp;
          System.arraycopy(localObject1, 1, arrayOfExpression2, 1, localObject1.length - 1);
          localObject1 = arrayOfExpression2;
        }
        ApplyExp localApplyExp2 = new ApplyExp(localClassType2.getDeclaredMethod("formatToWriter", 3), (Expression[])localObject1);
        localApplyExp2.setType(Type.voidType);
        return localApplyExp2;
      }
      if (!localType.isSubtype(ClassType.make("java.io.OutputStream")));
    }
    for (Object localObject2 = Type.voidType; ; localObject2 = localClassType1)
    {
      paramApplyExp.setType((Type)localObject2);
      return null;
    }
  }

  public static Expression validateApplyMakeProcedure(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    int i = arrayOfExpression.length;
    Object localObject1 = null;
    int j = 0;
    String str1 = null;
    int k = 0;
    if (k < i)
    {
      Expression localExpression3 = arrayOfExpression[k];
      String str3;
      Expression localExpression4;
      if ((localExpression3 instanceof QuoteExp))
      {
        Object localObject3 = ((QuoteExp)localExpression3).getValue();
        if ((localObject3 instanceof Keyword))
        {
          str3 = ((Keyword)localObject3).getName();
          k++;
          localExpression4 = arrayOfExpression[k];
          if (str3 == "name")
            if ((localExpression4 instanceof QuoteExp))
              str1 = ((QuoteExp)localExpression4).getValue().toString();
        }
      }
      while (true)
      {
        k++;
        break;
        if (str3 == "method")
        {
          j++;
          localObject1 = localExpression4;
          continue;
          j++;
          localObject1 = localExpression3;
        }
      }
    }
    if ((j == 1) && ((localObject1 instanceof LambdaExp)))
    {
      LambdaExp localLambdaExp = (LambdaExp)localObject1;
      int m = 0;
      if (m < i)
      {
        Expression localExpression1 = arrayOfExpression[m];
        String str2;
        Expression localExpression2;
        if ((localExpression1 instanceof QuoteExp))
        {
          Object localObject2 = ((QuoteExp)localExpression1).getValue();
          if ((localObject2 instanceof Keyword))
          {
            str2 = ((Keyword)localObject2).getName();
            m++;
            localExpression2 = arrayOfExpression[m];
            if (str2 != "name")
              break label256;
            localLambdaExp.setName(str1);
          }
        }
        while (true)
        {
          m++;
          break;
          label256: if (str2 != "method")
            localLambdaExp.setProperty(Namespace.EmptyNamespace.getSymbol(str2), localExpression2);
        }
      }
      return localObject1;
    }
    return paramApplyExp;
  }

  public static Expression validateApplyMap(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    Map localMap = (Map)paramProcedure;
    boolean bool = localMap.collect;
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    int i = arrayOfExpression1.length;
    if (i < 2)
      return paramApplyExp;
    int j = i - 1;
    Expression localExpression1 = arrayOfExpression1[0];
    int k;
    LetExp localLetExp1;
    Declaration localDeclaration1;
    Expression[] arrayOfExpression3;
    LetExp localLetExp2;
    if (!localExpression1.side_effects())
    {
      k = 1;
      Expression[] arrayOfExpression2 = { localExpression1 };
      localLetExp1 = new LetExp(arrayOfExpression2);
      localDeclaration1 = localLetExp1.addDeclaration("%proc", Compilation.typeProcedure);
      localDeclaration1.noteValue(arrayOfExpression1[0]);
      arrayOfExpression3 = new Expression[1];
      localLetExp2 = new LetExp(arrayOfExpression3);
      localLetExp1.setBody(localLetExp2);
      if (!bool)
        break label311;
    }
    LambdaExp localLambdaExp;
    Declaration localDeclaration2;
    LetExp localLetExp3;
    Declaration[] arrayOfDeclaration1;
    Declaration[] arrayOfDeclaration2;
    label311: for (int m = j + 1; ; m = j)
    {
      localLambdaExp = new LambdaExp(m);
      arrayOfExpression3[0] = localLambdaExp;
      localDeclaration2 = localLetExp2.addDeclaration("%loop");
      localDeclaration2.noteValue(localLambdaExp);
      Expression[] arrayOfExpression4 = new Expression[j];
      localLetExp3 = new LetExp(arrayOfExpression4);
      arrayOfDeclaration1 = new Declaration[j];
      arrayOfDeclaration2 = new Declaration[j];
      for (int n = 0; n < j; n++)
      {
        String str = "arg" + n;
        arrayOfDeclaration1[n] = localLambdaExp.addDeclaration(str);
        arrayOfDeclaration2[n] = localLetExp3.addDeclaration(str, Compilation.typePair);
        ReferenceExp localReferenceExp3 = new ReferenceExp(arrayOfDeclaration1[n]);
        arrayOfExpression4[n] = localReferenceExp3;
        arrayOfDeclaration2[n].noteValue(arrayOfExpression4[n]);
      }
      k = 0;
      break;
    }
    Declaration localDeclaration3;
    Expression[] arrayOfExpression5;
    if (bool)
    {
      localDeclaration3 = localLambdaExp.addDeclaration("result");
      arrayOfExpression5 = new Expression[j + 1];
      if (!bool)
        break label440;
    }
    Expression[] arrayOfExpression6;
    label440: for (int i1 = j + 1; ; i1 = j)
    {
      arrayOfExpression6 = new Expression[i1];
      for (int i2 = 0; i2 < j; i2++)
      {
        arrayOfExpression5[(i2 + 1)] = paramInlineCalls.visitApplyOnly(SlotGet.makeGetField(new ReferenceExp(arrayOfDeclaration2[i2]), "car"), null);
        arrayOfExpression6[i2] = paramInlineCalls.visitApplyOnly(SlotGet.makeGetField(new ReferenceExp(arrayOfDeclaration2[i2]), "cdr"), null);
      }
      localDeclaration3 = null;
      break;
    }
    if (k == 0);
    for (Object localObject1 = new ReferenceExp(localDeclaration1); ; localObject1 = localExpression1)
    {
      arrayOfExpression5[0] = localObject1;
      ApplyExp localApplyExp1 = new ApplyExp(new ReferenceExp(localMap.applyFieldDecl), arrayOfExpression5);
      Expression localExpression2 = paramInlineCalls.visitApplyOnly(localApplyExp1, null);
      if (bool)
      {
        Expression[] arrayOfExpression10 = new Expression[2];
        arrayOfExpression10[0] = localExpression2;
        ReferenceExp localReferenceExp2 = new ReferenceExp(localDeclaration3);
        arrayOfExpression10[1] = localReferenceExp2;
        arrayOfExpression6[j] = Invoke.makeInvokeStatic(Compilation.typePair, "make", arrayOfExpression10);
      }
      ApplyExp localApplyExp2 = new ApplyExp(new ReferenceExp(localDeclaration2), arrayOfExpression6);
      Object localObject2 = paramInlineCalls.visitApplyOnly(localApplyExp2, null);
      int i3;
      label620: Expression[] arrayOfExpression7;
      QuoteExp localQuoteExp;
      int i4;
      label643: int i5;
      Expression[] arrayOfExpression9;
      if (bool)
      {
        localLambdaExp.body = ((Expression)localObject2);
        localLetExp3.setBody(localLambdaExp.body);
        localLambdaExp.body = localLetExp3;
        if (!bool)
          break label791;
        i3 = j + 1;
        arrayOfExpression7 = new Expression[i3];
        localQuoteExp = new QuoteExp(LList.Empty);
        i4 = j;
        i5 = i4 - 1;
        if (i5 < 0)
          break label806;
        arrayOfExpression9 = new Expression[2];
        arrayOfExpression9[0] = new ReferenceExp(arrayOfDeclaration1[i5]);
        arrayOfExpression9[1] = localQuoteExp;
        if (!bool)
          break label798;
      }
      label791: label798: for (Object localObject4 = new ReferenceExp(localDeclaration3); ; localObject4 = QuoteExp.voidExp)
      {
        ApplyExp localApplyExp4 = new ApplyExp(localMap.isEq, arrayOfExpression9);
        Expression localExpression3 = paramInlineCalls.visitApplyOnly(localApplyExp4, null);
        Expression localExpression4 = localLambdaExp.body;
        IfExp localIfExp = new IfExp(localExpression3, (Expression)localObject4, localExpression4);
        localLambdaExp.body = localIfExp;
        arrayOfExpression7[i5] = arrayOfExpression1[(i5 + 1)];
        i4 = i5;
        break label643;
        BeginExp localBeginExp = new BeginExp(localExpression2, (Expression)localObject2);
        localObject2 = localBeginExp;
        break;
        i3 = j;
        break label620;
      }
      label806: if (bool)
        arrayOfExpression7[j] = localQuoteExp;
      ReferenceExp localReferenceExp1 = new ReferenceExp(localDeclaration2);
      ApplyExp localApplyExp3 = new ApplyExp(localReferenceExp1, arrayOfExpression7);
      Object localObject3 = paramInlineCalls.visitApplyOnly(localApplyExp3, null);
      if (bool)
      {
        Expression[] arrayOfExpression8 = { localObject3 };
        localObject3 = Invoke.makeInvokeStatic(Compilation.scmListType, "reverseInPlace", arrayOfExpression8);
      }
      localLetExp2.setBody((Expression)localObject3);
      if (k != 0)
        return localLetExp2;
      return localLetExp1;
    }
  }

  public static Expression validateApplyNot(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramApplyExp.setType(paramInlineCalls.getCompilation().getLanguage().getTypeFor(Boolean.TYPE));
    return paramApplyExp.inlineIfConstant(paramProcedure, paramInlineCalls);
  }

  public static Expression validateApplyValuesMap(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    LambdaExp localLambdaExp = ValuesMap.canInline(paramApplyExp, (ValuesMap)paramProcedure);
    if (localLambdaExp != null)
    {
      localLambdaExp.setInlineOnly(true);
      localLambdaExp.returnContinuation = paramApplyExp;
      localLambdaExp.inlineHome = paramInlineCalls.getCurrentLambda();
    }
    return paramApplyExp;
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    switch (this.code)
    {
    default:
      throw new Error();
    case 2:
      compileConvert((Convert)this.proc, paramApplyExp, paramCompilation, paramTarget);
      return;
    case 3:
    }
    compileNot((Not)this.proc, paramApplyExp, paramCompilation, paramTarget);
  }

  public void compileNot(Not paramNot, ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression localExpression = paramApplyExp.getArgs()[0];
    Language localLanguage = paramNot.language;
    if ((paramTarget instanceof ConditionalTarget))
    {
      ConditionalTarget localConditionalTarget1 = (ConditionalTarget)paramTarget;
      ConditionalTarget localConditionalTarget2 = new ConditionalTarget(localConditionalTarget1.ifFalse, localConditionalTarget1.ifTrue, localLanguage);
      if (!localConditionalTarget1.trueBranchComesFirst);
      for (boolean bool = true; ; bool = false)
      {
        localConditionalTarget2.trueBranchComesFirst = bool;
        localExpression.compile(paramCompilation, localConditionalTarget2);
        return;
      }
    }
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Type localType = paramTarget.getType();
    if (((paramTarget instanceof StackTarget)) && (localType.getSignature().charAt(0) == 'Z'))
    {
      localExpression.compile(paramCompilation, paramTarget);
      localCodeAttr.emitNot(paramTarget.getType());
      return;
    }
    QuoteExp localQuoteExp = QuoteExp.getInstance(localLanguage.booleanObject(true));
    IfExp.compile(localExpression, QuoteExp.getInstance(localLanguage.booleanObject(false)), localQuoteExp, paramCompilation, paramTarget);
  }

  static class ExitThroughFinallyChecker extends ExpVisitor<Expression, TryExp>
  {
    Declaration decl;

    public static boolean check(Declaration paramDeclaration, Expression paramExpression)
    {
      ExitThroughFinallyChecker localExitThroughFinallyChecker = new ExitThroughFinallyChecker();
      localExitThroughFinallyChecker.decl = paramDeclaration;
      localExitThroughFinallyChecker.visit(paramExpression, null);
      return localExitThroughFinallyChecker.exitValue != null;
    }

    protected Expression defaultValue(Expression paramExpression, TryExp paramTryExp)
    {
      return paramExpression;
    }

    protected Expression visitReferenceExp(ReferenceExp paramReferenceExp, TryExp paramTryExp)
    {
      if ((this.decl == paramReferenceExp.getBinding()) && (paramTryExp != null))
        this.exitValue = Boolean.TRUE;
      return paramReferenceExp;
    }

    protected Expression visitTryExp(TryExp paramTryExp1, TryExp paramTryExp2)
    {
      if (paramTryExp1.getFinallyClause() != null);
      for (TryExp localTryExp = paramTryExp1; ; localTryExp = paramTryExp2)
      {
        visitExpression(paramTryExp1, localTryExp);
        return paramTryExp1;
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.CompileMisc
 * JD-Core Version:    0.6.2
 */