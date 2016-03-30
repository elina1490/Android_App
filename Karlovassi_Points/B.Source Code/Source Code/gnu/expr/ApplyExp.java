package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.text.SourceMessages;

public class ApplyExp extends Expression
{
  public static final int INLINE_IF_CONSTANT = 4;
  public static final int MAY_CONTAIN_BACK_JUMP = 8;
  public static final int TAILCALL = 2;
  Expression[] args;
  LambdaExp context;
  Expression func;
  public ApplyExp nextCall;
  protected Type type;

  public ApplyExp(Method paramMethod, Expression[] paramArrayOfExpression)
  {
    this.func = new QuoteExp(new PrimProcedure(paramMethod));
    this.args = paramArrayOfExpression;
  }

  public ApplyExp(Expression paramExpression, Expression[] paramArrayOfExpression)
  {
    this.func = paramExpression;
    this.args = paramArrayOfExpression;
  }

  public ApplyExp(Procedure paramProcedure, Expression[] paramArrayOfExpression)
  {
    this.func = new QuoteExp(paramProcedure);
    this.args = paramArrayOfExpression;
  }

  public static Inlineable asInlineable(Procedure paramProcedure)
  {
    if ((paramProcedure instanceof Inlineable))
      return (Inlineable)paramProcedure;
    return (Inlineable)Procedure.compilerKey.get(paramProcedure);
  }

  public static void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    compile(paramApplyExp, paramCompilation, paramTarget, false);
  }

  static void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget, boolean paramBoolean)
  {
    int i = paramApplyExp.args.length;
    Expression localExpression1 = paramApplyExp.func;
    LambdaExp localLambdaExp3;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if ((localExpression1 instanceof LambdaExp))
    {
      localLambdaExp3 = (LambdaExp)localExpression1;
      if (localLambdaExp3.getName() != null)
        break label1368;
      localObject2 = null;
      localObject3 = null;
      localObject1 = localLambdaExp3;
    }
    while (true)
    {
      Procedure localProcedure;
      Declaration localDeclaration1;
      Declaration localDeclaration2;
      label137: ReferenceExp localReferenceExp2;
      String str2;
      LambdaExp localLambdaExp2;
      label237: String str1;
      Object localObject5;
      if ((paramBoolean) && ((localObject3 instanceof Procedure)))
      {
        localProcedure = (Procedure)localObject3;
        if (((paramTarget instanceof IgnoreTarget)) && (localProcedure.isSideEffectFree()))
        {
          int i3 = 0;
          while (true)
            if (i3 < i)
            {
              paramApplyExp.args[i3].compile(paramCompilation, paramTarget);
              i3++;
              continue;
              if ((localExpression1 instanceof ReferenceExp))
              {
                ReferenceExp localReferenceExp1 = (ReferenceExp)localExpression1;
                localDeclaration1 = localReferenceExp1.contextDecl();
                localDeclaration2 = localReferenceExp1.binding;
                if ((localDeclaration2 != null) && (localDeclaration2.isAlias()) && ((localDeclaration2.value instanceof ReferenceExp)))
                {
                  localReferenceExp2 = (ReferenceExp)localDeclaration2.value;
                  if ((localDeclaration1 == null) && (!localDeclaration2.needsContext()) && (localReferenceExp2.binding != null))
                    break;
                }
                else
                {
                  if (localDeclaration2.getFlag(65536L))
                    break label1356;
                  Expression localExpression2 = localDeclaration2.getValue();
                  str2 = localDeclaration2.getName();
                  if ((localExpression2 == null) || (!(localExpression2 instanceof LambdaExp)))
                    break label1350;
                  localLambdaExp2 = (LambdaExp)localExpression2;
                  if ((localExpression2 == null) || (!(localExpression2 instanceof QuoteExp)))
                    break label1340;
                  Object localObject6 = ((QuoteExp)localExpression2).getValue();
                  str1 = str2;
                  localObject5 = localObject6;
                }
              }
            }
        }
      }
      while (true)
      {
        localObject3 = localObject5;
        localObject2 = localDeclaration1;
        localObject1 = localLambdaExp2;
        break;
        localDeclaration2 = localReferenceExp2.binding;
        localDeclaration1 = localReferenceExp2.contextDecl();
        break label137;
        if ((localExpression1 instanceof QuoteExp))
        {
          localObject3 = ((QuoteExp)localExpression1).getValue();
          localObject1 = null;
          localObject2 = null;
          break;
          try
          {
            boolean bool3 = inlineCompile(localProcedure, paramApplyExp, paramCompilation, paramTarget);
            if (bool3)
              return;
          }
          catch (Throwable localThrowable)
          {
            paramCompilation.getMessages().error('e', "caught exception in inline-compiler for " + localObject3 + " - " + localThrowable, localThrowable);
            return;
          }
          CodeAttr localCodeAttr = paramCompilation.getCode();
          if (localObject1 != null)
          {
            if (((((LambdaExp)localObject1).max_args >= 0) && (i > ((LambdaExp)localObject1).max_args)) || (i < ((LambdaExp)localObject1).min_args))
              throw new Error("internal error - wrong number of parameters for " + localObject1);
            int n = ((LambdaExp)localObject1).getCallConvention();
            if ((paramCompilation.inlineOk((Expression)localObject1)) && ((n <= 2) || ((n == 3) && (!paramApplyExp.isTailCall()))))
            {
              Method localMethod2 = ((LambdaExp)localObject1).getMethod(i);
              if (localMethod2 != null)
              {
                PrimProcedure localPrimProcedure = new PrimProcedure(localMethod2, (LambdaExp)localObject1);
                boolean bool2 = localMethod2.getStaticFlag();
                int i1;
                Variable localVariable1;
                int i2;
                if (bool2)
                {
                  Variable localVariable2 = ((LambdaExp)localObject1).declareClosureEnv();
                  i1 = 0;
                  if (localVariable2 == null);
                }
                else
                {
                  i1 = 0;
                  if (bool2)
                    i1 = 1;
                  if (paramCompilation.curLambda == localObject1)
                    if (((LambdaExp)localObject1).closureEnv != null)
                    {
                      localVariable1 = ((LambdaExp)localObject1).closureEnv;
                      localCodeAttr.emitLoad(localVariable1);
                      i2 = i1;
                      label592: if (i2 == 0)
                        break label662;
                    }
                }
                label662: for (PrimType localPrimType = Type.voidType; ; localPrimType = null)
                {
                  localPrimProcedure.compile(localPrimType, paramApplyExp, paramCompilation, paramTarget);
                  return;
                  localVariable1 = ((LambdaExp)localObject1).thisVariable;
                  break;
                  if (localObject2 != null)
                  {
                    localObject2.load(null, 0, paramCompilation, Target.pushObject);
                    i2 = i1;
                    break label592;
                  }
                  ((LambdaExp)localObject1).getOwningLambda().loadHeapFrame(paramCompilation);
                  i2 = i1;
                  break label592;
                }
              }
            }
          }
          int j;
          if ((paramApplyExp.isTailCall()) && (localObject1 != null) && (localObject1 == paramCompilation.curLambda))
            j = 1;
          while ((localObject1 != null) && (((LambdaExp)localObject1).getInlineOnly()) && (j == 0) && (((LambdaExp)localObject1).min_args == i))
          {
            pushArgs((LambdaExp)localObject1, paramApplyExp.args, null, paramCompilation);
            if (((LambdaExp)localObject1).getFlag(128))
            {
              popParams(localCodeAttr, (LambdaExp)localObject1, null, false);
              localCodeAttr.emitTailCall(false, ((LambdaExp)localObject1).getVarScope());
              return;
              j = 0;
            }
            else
            {
              ((LambdaExp)localObject1).flags = (0x80 | ((LambdaExp)localObject1).flags);
              LambdaExp localLambdaExp1 = paramCompilation.curLambda;
              paramCompilation.curLambda = ((LambdaExp)localObject1);
              ((LambdaExp)localObject1).allocChildClasses(paramCompilation);
              ((LambdaExp)localObject1).allocParameters(paramCompilation);
              popParams(localCodeAttr, (LambdaExp)localObject1, null, false);
              ((LambdaExp)localObject1).enterFunction(paramCompilation);
              ((LambdaExp)localObject1).body.compileWithPosition(paramCompilation, paramTarget);
              ((LambdaExp)localObject1).compileEnd(paramCompilation);
              ((LambdaExp)localObject1).generateApplyMethods(paramCompilation);
              localCodeAttr.popScope();
              paramCompilation.curLambda = localLambdaExp1;
              return;
            }
          }
          if ((paramCompilation.curLambda.isHandlingTailCalls()) && ((paramApplyExp.isTailCall()) || ((paramTarget instanceof ConsumerTarget))) && (!paramCompilation.curLambda.getInlineOnly()))
          {
            ClassType localClassType = Compilation.typeCallContext;
            localExpression1.compile(paramCompilation, new StackTarget(Compilation.typeProcedure));
            if (i <= 4)
            {
              for (int m = 0; m < i; m++)
                paramApplyExp.args[m].compileWithPosition(paramCompilation, Target.pushObject);
              paramCompilation.loadCallContext();
              localCodeAttr.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("check" + i, i + 1));
            }
            while (paramApplyExp.isTailCall())
            {
              localCodeAttr.emitReturn();
              return;
              compileToArray(paramApplyExp.args, paramCompilation);
              paramCompilation.loadCallContext();
              localCodeAttr.emitInvoke(Compilation.typeProcedure.getDeclaredMethod("checkN", 2));
            }
            if (((ConsumerTarget)paramTarget).isContextTarget())
            {
              paramCompilation.loadCallContext();
              localCodeAttr.emitInvoke(localClassType.getDeclaredMethod("runUntilDone", 0));
              return;
            }
            paramCompilation.loadCallContext();
            localCodeAttr.emitLoad(((ConsumerTarget)paramTarget).getConsumerVariable());
            localCodeAttr.emitInvoke(localClassType.getDeclaredMethod("runUntilValue", 1));
            return;
          }
          if (j == 0)
            localExpression1.compile(paramCompilation, new StackTarget(Compilation.typeProcedure));
          boolean bool1;
          Method localMethod1;
          Object localObject4;
          if (j != 0)
            if (((LambdaExp)localObject1).min_args != ((LambdaExp)localObject1).max_args)
            {
              bool1 = true;
              if (!bool1)
                break label1196;
              compileToArray(paramApplyExp.args, paramCompilation);
              localMethod1 = Compilation.applyNmethod;
              localObject4 = null;
            }
          while (true)
            if (!localCodeAttr.reachableHere())
            {
              paramCompilation.error('e', "unreachable code");
              return;
              bool1 = false;
              break;
              if (i > 4)
              {
                bool1 = true;
                break;
              }
              bool1 = false;
              break;
              label1196: if (j != 0)
              {
                int[] arrayOfInt = new int[paramApplyExp.args.length];
                pushArgs((LambdaExp)localObject1, paramApplyExp.args, arrayOfInt, paramCompilation);
                localObject4 = arrayOfInt;
                localMethod1 = null;
              }
              else
              {
                for (int k = 0; ; k++)
                  if (k < i)
                  {
                    paramApplyExp.args[k].compileWithPosition(paramCompilation, Target.pushObject);
                    if (localCodeAttr.reachableHere());
                  }
                  else
                  {
                    localMethod1 = Compilation.applymethods[i];
                    localObject4 = null;
                    break;
                  }
              }
            }
          if (j != 0)
          {
            popParams(localCodeAttr, (LambdaExp)localObject1, localObject4, bool1);
            localCodeAttr.emitTailCall(false, ((LambdaExp)localObject1).getVarScope());
            return;
          }
          localCodeAttr.emitInvokeVirtual(localMethod1);
          paramTarget.compileFromStack(paramCompilation, Type.pointer_type);
          return;
        }
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        break;
        label1340: str1 = str2;
        localObject5 = null;
        continue;
        label1350: localLambdaExp2 = null;
        break label237;
        label1356: localLambdaExp2 = null;
        str1 = null;
        localObject5 = null;
      }
      label1368: localObject1 = localLambdaExp3;
      localObject2 = null;
      localObject3 = null;
    }
  }

  public static void compileToArray(Expression[] paramArrayOfExpression, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (paramArrayOfExpression.length == 0)
    {
      localCodeAttr.emitGetStatic(Compilation.noArgsField);
      return;
    }
    localCodeAttr.emitPushInt(paramArrayOfExpression.length);
    localCodeAttr.emitNewArray(Type.pointer_type);
    int i = 0;
    label33: Expression localExpression;
    if (i < paramArrayOfExpression.length)
    {
      localExpression = paramArrayOfExpression[i];
      if ((!paramCompilation.usingCPStyle()) || ((localExpression instanceof QuoteExp)) || ((localExpression instanceof ReferenceExp)))
        break label112;
      localExpression.compileWithPosition(paramCompilation, Target.pushObject);
      localCodeAttr.emitSwap();
      localCodeAttr.emitDup(1, 1);
      localCodeAttr.emitSwap();
      localCodeAttr.emitPushInt(i);
      localCodeAttr.emitSwap();
    }
    while (true)
    {
      localCodeAttr.emitArrayStore(Type.pointer_type);
      i++;
      break label33;
      break;
      label112: localCodeAttr.emitDup(Compilation.objArrayType);
      localCodeAttr.emitPushInt(i);
      localExpression.compileWithPosition(paramCompilation, Target.pushObject);
    }
  }

  static Expression derefFunc(Expression paramExpression)
  {
    if ((paramExpression instanceof ReferenceExp))
    {
      Declaration localDeclaration = Declaration.followAliases(((ReferenceExp)paramExpression).binding);
      if ((localDeclaration != null) && (!localDeclaration.getFlag(65536L)))
        paramExpression = localDeclaration.getValue();
    }
    return paramExpression;
  }

  static boolean inlineCompile(Procedure paramProcedure, ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
    throws Throwable
  {
    Inlineable localInlineable = asInlineable(paramProcedure);
    if (localInlineable == null)
      return false;
    localInlineable.compile(paramApplyExp, paramCompilation, paramTarget);
    return true;
  }

  private static void popParams(CodeAttr paramCodeAttr, int paramInt1, int paramInt2, int[] paramArrayOfInt, Declaration paramDeclaration, Variable paramVariable)
  {
    int i;
    int j;
    Declaration localDeclaration;
    if (paramInt2 > 0)
    {
      i = paramInt2 - 1;
      j = paramInt1 + 1;
      localDeclaration = paramDeclaration.nextDecl();
      if (paramDeclaration.getVariable() != null)
        break label78;
    }
    label78: for (Variable localVariable = paramVariable; ; localVariable = paramVariable.nextVar())
    {
      popParams(paramCodeAttr, j, i, paramArrayOfInt, localDeclaration, localVariable);
      if (!paramDeclaration.ignorable())
      {
        if ((paramArrayOfInt == null) || (paramArrayOfInt[paramInt1] == 65536))
          break;
        paramCodeAttr.emitInc(paramVariable, (short)paramArrayOfInt[paramInt1]);
      }
      return;
    }
    paramCodeAttr.emitStore(paramVariable);
  }

  private static void popParams(CodeAttr paramCodeAttr, LambdaExp paramLambdaExp, int[] paramArrayOfInt, boolean paramBoolean)
  {
    Variable localVariable = paramLambdaExp.getVarScope().firstVar();
    Declaration localDeclaration = paramLambdaExp.firstDecl();
    if ((localVariable != null) && (localVariable.getName() == "this"))
      localVariable = localVariable.nextVar();
    if ((localVariable != null) && (localVariable.getName() == "$ctx"))
      localVariable = localVariable.nextVar();
    if ((localVariable != null) && (localVariable.getName() == "argsArray"))
    {
      if (paramBoolean)
      {
        popParams(paramCodeAttr, 0, 1, null, localDeclaration, localVariable);
        return;
      }
      localVariable = localVariable.nextVar();
    }
    popParams(paramCodeAttr, 0, paramLambdaExp.min_args, paramArrayOfInt, localDeclaration, localVariable);
  }

  private static void pushArgs(LambdaExp paramLambdaExp, Expression[] paramArrayOfExpression, int[] paramArrayOfInt, Compilation paramCompilation)
  {
    Declaration localDeclaration = paramLambdaExp.firstDecl();
    int i = paramArrayOfExpression.length;
    int j = 0;
    if (j < i)
    {
      Expression localExpression = paramArrayOfExpression[j];
      if (localDeclaration.ignorable())
        localExpression.compile(paramCompilation, Target.Ignore);
      while (true)
      {
        localDeclaration = localDeclaration.nextDecl();
        j++;
        break;
        if (paramArrayOfInt != null)
        {
          int k = SetExp.canUseInc(localExpression, localDeclaration);
          paramArrayOfInt[j] = k;
          if (k != 65536);
        }
        else
        {
          localExpression.compileWithPosition(paramCompilation, StackTarget.getInstance(localDeclaration.getType()));
        }
      }
    }
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object localObject = this.func.eval(paramCallContext);
    int i = this.args.length;
    Object[] arrayOfObject = new Object[i];
    for (int j = 0; j < i; j++)
      arrayOfObject[j] = this.args[j].eval(paramCallContext);
    ((Procedure)localObject).checkN(arrayOfObject, paramCallContext);
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    compile(this, paramCompilation, paramTarget, true);
  }

  public Expression deepCopy(IdentityHashTable paramIdentityHashTable)
  {
    Expression localExpression = deepCopy(this.func, paramIdentityHashTable);
    Expression[] arrayOfExpression = deepCopy(this.args, paramIdentityHashTable);
    if (((localExpression == null) && (this.func != null)) || ((arrayOfExpression == null) && (this.args != null)))
      return null;
    ApplyExp localApplyExp = new ApplyExp(localExpression, arrayOfExpression);
    localApplyExp.flags = getFlags();
    return localApplyExp;
  }

  public Expression getArg(int paramInt)
  {
    return this.args[paramInt];
  }

  public final int getArgCount()
  {
    return this.args.length;
  }

  public final Expression[] getArgs()
  {
    return this.args;
  }

  public final Expression getFunction()
  {
    return this.func;
  }

  public final Object getFunctionValue()
  {
    if ((this.func instanceof QuoteExp))
      return ((QuoteExp)this.func).getValue();
    return null;
  }

  public final Type getType()
  {
    if (this.type != null)
      return this.type;
    Expression localExpression = derefFunc(this.func);
    this.type = Type.objectType;
    if ((localExpression instanceof QuoteExp))
    {
      Object localObject = ((QuoteExp)localExpression).getValue();
      if ((localObject instanceof Procedure))
        this.type = ((Procedure)localObject).getReturnType(this.args);
    }
    while (true)
    {
      return this.type;
      if ((localExpression instanceof LambdaExp))
        this.type = ((LambdaExp)localExpression).getReturnType();
    }
  }

  public final Type getTypeRaw()
  {
    return this.type;
  }

  public final Expression inlineIfConstant(Procedure paramProcedure, InlineCalls paramInlineCalls)
  {
    return inlineIfConstant(paramProcedure, paramInlineCalls.getMessages());
  }

  public final Expression inlineIfConstant(Procedure paramProcedure, SourceMessages paramSourceMessages)
  {
    int i = this.args.length;
    Object[] arrayOfObject = new Object[i];
    int j = i;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      Expression localExpression = this.args[j];
      if ((localExpression instanceof ReferenceExp))
      {
        Declaration localDeclaration = ((ReferenceExp)localExpression).getBinding();
        if (localDeclaration != null)
        {
          localExpression = localDeclaration.getValue();
          if (localExpression == QuoteExp.undefined_exp)
            return this;
        }
      }
      if (!(localExpression instanceof QuoteExp))
        return this;
      arrayOfObject[j] = ((QuoteExp)localExpression).getValue();
    }
    try
    {
      QuoteExp localQuoteExp = new QuoteExp(paramProcedure.applyN(arrayOfObject), this.type);
      return localQuoteExp;
    }
    catch (Throwable localThrowable)
    {
      if (paramSourceMessages != null)
        paramSourceMessages.error('w', "call to " + paramProcedure + " throws " + localThrowable);
    }
    return this;
  }

  public final boolean isTailCall()
  {
    return getFlag(2);
  }

  protected boolean mustCompile()
  {
    return false;
  }

  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(Apply", ")", 2);
    if (isTailCall())
      paramOutPort.print(" [tailcall]");
    if ((this.type != null) && (this.type != Type.pointer_type))
    {
      paramOutPort.print(" => ");
      paramOutPort.print(this.type);
    }
    paramOutPort.writeSpaceFill();
    printLineColumn(paramOutPort);
    this.func.print(paramOutPort);
    for (int i = 0; i < this.args.length; i++)
    {
      paramOutPort.writeSpaceLinear();
      this.args[i].print(paramOutPort);
    }
    paramOutPort.endLogicalBlock(")");
  }

  public void setArg(int paramInt, Expression paramExpression)
  {
    this.args[paramInt] = paramExpression;
  }

  public void setArgs(Expression[] paramArrayOfExpression)
  {
    this.args = paramArrayOfExpression;
  }

  public void setFunction(Expression paramExpression)
  {
    this.func = paramExpression;
  }

  public final void setTailCall(boolean paramBoolean)
  {
    setFlag(paramBoolean, 2);
  }

  public final void setType(Type paramType)
  {
    this.type = paramType;
  }

  public boolean side_effects()
  {
    Object localObject = derefFunc(this.func).valueIfConstant();
    if (((localObject instanceof Procedure)) && (((Procedure)localObject).isSideEffectFree()))
    {
      Expression[] arrayOfExpression = this.args;
      int i = arrayOfExpression.length;
      for (int j = 0; j < i; j++)
        if (arrayOfExpression[j].side_effects())
          return true;
      return false;
    }
    return true;
  }

  public String toString()
  {
    if (this == LambdaExp.unknownContinuation)
      return "ApplyExp[unknownContinuation]";
    StringBuilder localStringBuilder = new StringBuilder().append("ApplyExp/");
    if (this.args == null);
    for (int i = 0; ; i = this.args.length)
      return i + '[' + this.func + ']';
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitApplyExp(this, paramD);
  }

  public void visitArgs(InlineCalls paramInlineCalls)
  {
    this.args = paramInlineCalls.visitExps(this.args, this.args.length, null);
  }

  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    this.func = paramExpVisitor.visitAndUpdate(this.func, paramD);
    if (paramExpVisitor.exitValue == null)
      this.args = paramExpVisitor.visitExps(this.args, this.args.length, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ApplyExp
 * JD-Core Version:    0.6.2
 */