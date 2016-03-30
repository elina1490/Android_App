package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class ValuesMap extends MethodProc
  implements Inlineable
{
  public static final ValuesMap valuesMap = new ValuesMap(-1);
  public static final ValuesMap valuesMapWithPos = new ValuesMap(1);
  private final int startCounter;

  private ValuesMap(int paramInt)
  {
    this.startCounter = paramInt;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyValuesMap");
  }

  static LambdaExp canInline(ApplyExp paramApplyExp, ValuesMap paramValuesMap)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if (arrayOfExpression.length == 2)
    {
      Expression localExpression = arrayOfExpression[0];
      if ((localExpression instanceof LambdaExp))
      {
        LambdaExp localLambdaExp = (LambdaExp)localExpression;
        if (localLambdaExp.min_args == localLambdaExp.max_args)
        {
          int i = localLambdaExp.min_args;
          if (paramValuesMap.startCounter >= 0);
          for (int j = 2; i == j; j = 1)
            return localLambdaExp;
        }
      }
    }
    return null;
  }

  public static void compileInlined(LambdaExp paramLambdaExp, Expression paramExpression, int paramInt, Method paramMethod, Compilation paramCompilation, Target paramTarget)
  {
    Declaration localDeclaration1 = paramLambdaExp.firstDecl();
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Scope localScope = localCodeAttr.pushScope();
    Type localType = localDeclaration1.getType();
    Declaration localDeclaration2;
    Variable localVariable1;
    label93: Object localObject1;
    label133: ApplyExp localApplyExp1;
    ApplyExp localApplyExp2;
    if (paramInt >= 0)
    {
      Variable localVariable5 = localScope.addVariable(localCodeAttr, Type.intType, "position");
      localCodeAttr.emitPushInt(paramInt);
      localCodeAttr.emitStore(localVariable5);
      localDeclaration2 = new Declaration(localVariable5);
      localVariable1 = localVariable5;
      if ((!localDeclaration1.isSimple()) || (paramMethod != null))
        break label471;
      localDeclaration1.allocateVariable(localCodeAttr);
      if (paramInt < 0)
        break label505;
      Expression[] arrayOfExpression3 = new Expression[2];
      arrayOfExpression3[0] = new ReferenceExp(localDeclaration1);
      arrayOfExpression3[1] = new ReferenceExp(localDeclaration2);
      localObject1 = arrayOfExpression3;
      localApplyExp1 = new ApplyExp(paramLambdaExp, (Expression[])localObject1);
      if (paramMethod == null)
        break label538;
      if (localApplyExp1.getType().getImplementationType() == Type.booleanType)
        break label531;
      Expression[] arrayOfExpression2 = new Expression[2];
      arrayOfExpression2[0] = localApplyExp1;
      arrayOfExpression2[1] = new ReferenceExp(localDeclaration2);
      localApplyExp2 = new ApplyExp(paramMethod, arrayOfExpression2);
    }
    label200: for (Object localObject2 = new IfExp(localApplyExp2, new ReferenceExp(localDeclaration1), QuoteExp.voidExp); ; localObject2 = localApplyExp1)
    {
      Variable localVariable2 = localCodeAttr.addLocal(Type.intType);
      Variable localVariable3 = localCodeAttr.addLocal(Type.pointer_type);
      Variable localVariable4 = localCodeAttr.addLocal(Type.intType);
      paramExpression.compileWithPosition(paramCompilation, Target.pushObject);
      localCodeAttr.emitStore(localVariable3);
      localCodeAttr.emitPushInt(0);
      localCodeAttr.emitStore(localVariable2);
      Label localLabel1 = new Label(localCodeAttr);
      Label localLabel2 = new Label(localCodeAttr);
      localLabel1.define(localCodeAttr);
      localCodeAttr.emitLoad(localVariable3);
      localCodeAttr.emitLoad(localVariable2);
      localCodeAttr.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextIndex", 2));
      localCodeAttr.emitDup(Type.intType);
      localCodeAttr.emitStore(localVariable4);
      localCodeAttr.emitGotoIfIntLtZero(localLabel2);
      localCodeAttr.emitLoad(localVariable3);
      localCodeAttr.emitLoad(localVariable2);
      localCodeAttr.emitInvokeStatic(Compilation.typeValues.getDeclaredMethod("nextValue", 2));
      StackTarget.convert(paramCompilation, Type.objectType, localType);
      localDeclaration1.compileStore(paramCompilation);
      ((Expression)localObject2).compile(paramCompilation, paramTarget);
      if (paramInt >= 0)
        localCodeAttr.emitInc(localVariable1, (short)1);
      localCodeAttr.emitLoad(localVariable4);
      localCodeAttr.emitStore(localVariable2);
      localCodeAttr.emitGoto(localLabel1);
      localLabel2.define(localCodeAttr);
      localCodeAttr.popScope();
      return;
      localVariable1 = null;
      localDeclaration2 = null;
      break;
      label471: String str = Compilation.mangleNameIfNeeded(localDeclaration1.getName());
      localDeclaration1 = new Declaration(localCodeAttr.addLocal(localType.getImplementationType(), str));
      break label93;
      label505: Expression[] arrayOfExpression1 = new Expression[1];
      arrayOfExpression1[0] = new ReferenceExp(localDeclaration1);
      localObject1 = arrayOfExpression1;
      break label133;
      localApplyExp2 = localApplyExp1;
      break label200;
    }
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Procedure localProcedure = (Procedure)paramCallContext.getNextArg();
    Object localObject1 = paramCallContext.getNextArg();
    Procedure.checkArgCount(localProcedure, 1);
    if ((localObject1 instanceof Values))
    {
      int i = 0;
      int j = this.startCounter;
      Values localValues = (Values)localObject1;
      i = localValues.nextPos(i);
      if (i != 0)
      {
        Object localObject2 = localValues.getPosPrevious(i);
        if (this.startCounter >= 0)
        {
          int k = j + 1;
          localProcedure.check2(localObject2, IntNum.make(j), paramCallContext);
          j = k;
        }
        while (true)
        {
          paramCallContext.runUntilDone();
          break;
          localProcedure.check1(localObject2, paramCallContext);
        }
      }
    }
    else
    {
      if (this.startCounter < 0)
        break label143;
      localProcedure.check2(localObject1, IntNum.make(this.startCounter), paramCallContext);
    }
    while (true)
    {
      paramCallContext.runUntilDone();
      return;
      label143: localProcedure.check1(localObject1, paramCallContext);
    }
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    LambdaExp localLambdaExp = canInline(paramApplyExp, this);
    if (localLambdaExp == null)
    {
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if ((!(paramTarget instanceof IgnoreTarget)) && (!(paramTarget instanceof ConsumerTarget)))
    {
      ConsumerTarget.compileUsingConsumer(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    compileInlined(localLambdaExp, arrayOfExpression[1], this.startCounter, null, paramCompilation, paramTarget);
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Type.pointer_type;
  }

  public int numArgs()
  {
    return 8194;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.ValuesMap
 * JD-Core Version:    0.6.2
 */