package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.functions.AddOp;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class SetExp extends AccessExp
{
  public static final int BAD_SHORT = 65536;
  public static final int DEFINING_FLAG = 2;
  public static final int GLOBAL_FLAG = 4;
  public static final int HAS_VALUE = 64;
  public static final int PREFER_BINDING2 = 8;
  public static final int PROCEDURE = 16;
  public static final int SET_IF_UNBOUND = 32;
  Expression new_value;

  public SetExp(Declaration paramDeclaration, Expression paramExpression)
  {
    this.binding = paramDeclaration;
    this.symbol = paramDeclaration.getSymbol();
    this.new_value = paramExpression;
  }

  public SetExp(Object paramObject, Expression paramExpression)
  {
    this.symbol = paramObject;
    this.new_value = paramExpression;
  }

  public static int canUseInc(Expression paramExpression, Declaration paramDeclaration)
  {
    Variable localVariable = paramDeclaration.getVariable();
    Object localObject1;
    int i;
    Expression localExpression1;
    Expression localExpression2;
    Expression localExpression4;
    Expression localExpression3;
    if ((paramDeclaration.isSimple()) && (localVariable.getType().getImplementationType().promote() == Type.intType) && ((paramExpression instanceof ApplyExp)))
    {
      ApplyExp localApplyExp = (ApplyExp)paramExpression;
      if (localApplyExp.getArgCount() == 2)
      {
        localObject1 = localApplyExp.getFunction().valueIfConstant();
        if (localObject1 != AddOp.$Pl)
          break label138;
        i = 1;
        localExpression1 = localApplyExp.getArg(0);
        localExpression2 = localApplyExp.getArg(1);
        if ((!(localExpression1 instanceof QuoteExp)) || (i <= 0))
          break label268;
        localExpression4 = localExpression1;
        localExpression3 = localExpression2;
      }
    }
    while (true)
    {
      if ((localExpression3 instanceof ReferenceExp))
      {
        ReferenceExp localReferenceExp = (ReferenceExp)localExpression3;
        if ((localReferenceExp.getBinding() == paramDeclaration) && (!localReferenceExp.getDontDereference()))
          break label152;
      }
      while (true)
      {
        return 65536;
        label138: if (localObject1 == AddOp.$Mn)
        {
          i = -1;
          break;
          label152: Object localObject2 = localExpression4.valueIfConstant();
          if ((localObject2 instanceof Integer))
          {
            int m = ((Integer)localObject2).intValue();
            if (i < 0)
              m = -m;
            if ((short)m == m)
              return m;
          }
          else if ((localObject2 instanceof IntNum))
          {
            IntNum localIntNum = (IntNum)localObject2;
            int j = 32767;
            int k = -j;
            if (i > 0)
              k--;
            while ((IntNum.compare(localIntNum, k) >= 0) && (IntNum.compare(localIntNum, j) <= 0))
            {
              return i * localIntNum.intValue();
              j++;
            }
          }
        }
      }
      label268: localExpression3 = localExpression1;
      localExpression4 = localExpression2;
    }
  }

  public static SetExp makeDefinition(Declaration paramDeclaration, Expression paramExpression)
  {
    SetExp localSetExp = new SetExp(paramDeclaration, paramExpression);
    localSetExp.setDefining(true);
    return localSetExp;
  }

  public static SetExp makeDefinition(Object paramObject, Expression paramExpression)
  {
    SetExp localSetExp = new SetExp(paramObject, paramExpression);
    localSetExp.setDefining(true);
    return localSetExp;
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Environment localEnvironment = Environment.getCurrent();
    Symbol localSymbol;
    Object localObject1;
    if ((this.symbol instanceof Symbol))
    {
      localSymbol = (Symbol)this.symbol;
      Language localLanguage = Language.getDefaultLanguage();
      boolean bool1 = isFuncDef();
      localObject1 = null;
      if (bool1)
      {
        boolean bool2 = localLanguage.hasSeparateFunctionNamespace();
        localObject1 = null;
        if (bool2)
          localObject1 = EnvironmentKey.FUNCTION;
      }
      if (!isSetIfUnbound())
        break label127;
      Location localLocation = localEnvironment.getLocation(localSymbol, localObject1);
      if (!localLocation.isBound())
        localLocation.set(this.new_value.eval(localEnvironment));
      if (getHasValue())
        paramCallContext.writeValue(localLocation);
    }
    while (true)
    {
      return;
      localSymbol = localEnvironment.getSymbol(this.symbol.toString());
      break;
      label127: Object localObject2 = this.new_value.eval(localEnvironment);
      Object[] arrayOfObject;
      if ((this.binding != null) && (!(this.binding.context instanceof ModuleExp)))
      {
        arrayOfObject = paramCallContext.evalFrames[ScopeExp.nesting(this.binding.context)];
        if (this.binding.isIndirectBinding())
        {
          if (isDefining())
            arrayOfObject[this.binding.evalIndex] = Location.make(localSymbol);
          ((Location)arrayOfObject[this.binding.evalIndex]).set(this.new_value);
        }
      }
      while (getHasValue())
      {
        paramCallContext.writeValue(localObject2);
        return;
        arrayOfObject[this.binding.evalIndex] = localObject2;
        continue;
        if (isDefining())
          localEnvironment.define(localSymbol, localObject1, localObject2);
        else
          localEnvironment.put(localSymbol, localObject1, localObject2);
      }
    }
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    if (((this.new_value instanceof LambdaExp)) && ((paramTarget instanceof IgnoreTarget)) && (((LambdaExp)this.new_value).getInlineOnly()))
      return;
    CodeAttr localCodeAttr1 = paramCompilation.getCode();
    int i;
    int j;
    Object localObject1;
    if ((getHasValue()) && (!(paramTarget instanceof IgnoreTarget)))
    {
      i = 1;
      j = 0;
      localObject1 = this.binding;
      Expression localExpression1 = ((Declaration)localObject1).getValue();
      if ((!(localExpression1 instanceof LambdaExp)) || (!(((Declaration)localObject1).context instanceof ModuleExp)) || (((Declaration)localObject1).ignorable()) || (((LambdaExp)localExpression1).getName() == null) || (localExpression1 != this.new_value))
        break label155;
      ((LambdaExp)this.new_value).compileSetField(paramCompilation);
    }
    while (true)
    {
      if ((i == 0) || (j != 0))
        break label959;
      throw new Error("SetExp.compile: not implemented - return value");
      i = 0;
      break;
      label155: if (((((Declaration)localObject1).shouldEarlyInit()) || (((Declaration)localObject1).isAlias())) && ((((Declaration)localObject1).context instanceof ModuleExp)) && (isDefining()) && (!((Declaration)localObject1).ignorable()))
      {
        if (((Declaration)localObject1).shouldEarlyInit())
        {
          Expression localExpression3 = this.new_value;
          BindingInitializer.create((Declaration)localObject1, localExpression3, paramCompilation);
        }
        j = 0;
        if (i != 0)
        {
          Target localTarget3 = Target.pushObject;
          ((Declaration)localObject1).load(this, 0, paramCompilation, localTarget3);
          j = 1;
        }
      }
      else
      {
        Object localObject2 = this;
        Declaration localDeclaration1 = contextDecl();
        if (!isDefining());
        while (true)
        {
          Expression localExpression2;
          if ((localObject1 != null) && (((Declaration)localObject1).isAlias()))
          {
            localExpression2 = ((Declaration)localObject1).getValue();
            if ((localExpression2 instanceof ReferenceExp))
              break label317;
          }
          label317: ReferenceExp localReferenceExp;
          Declaration localDeclaration2;
          do
          {
            if (!((Declaration)localObject1).ignorable())
              break label367;
            this.new_value.compile(paramCompilation, Target.Ignore);
            j = 0;
            break;
            localReferenceExp = (ReferenceExp)localExpression2;
            localDeclaration2 = localReferenceExp.binding;
          }
          while ((localDeclaration2 == null) || ((localDeclaration1 != null) && (localDeclaration2.needsContext())));
          localDeclaration1 = localReferenceExp.contextDecl();
          localObject2 = localReferenceExp;
          localObject1 = localDeclaration2;
        }
        label367: if ((((Declaration)localObject1).isAlias()) && (isDefining()))
        {
          Target localTarget2 = Target.pushObject;
          ((Declaration)localObject1).load(this, 2, paramCompilation, localTarget2);
          ClassType localClassType = ClassType.make("gnu.mapping.IndirectableLocation");
          localCodeAttr1.emitCheckcast(localClassType);
          this.new_value.compile(paramCompilation, Target.pushObject);
          localCodeAttr1.emitInvokeVirtual(localClassType.getDeclaredMethod("setAlias", 1));
          j = 0;
        }
        else if (((Declaration)localObject1).isIndirectBinding())
        {
          Target localTarget1 = Target.pushObject;
          ((Declaration)localObject1).load((AccessExp)localObject2, 2, paramCompilation, localTarget1);
          boolean bool = isSetIfUnbound();
          j = 0;
          if (bool)
          {
            j = 0;
            if (i != 0)
            {
              localCodeAttr1.emitDup();
              j = 1;
            }
            localCodeAttr1.pushScope();
            localCodeAttr1.emitDup();
            Variable localVariable2 = localCodeAttr1.addLocal(Compilation.typeLocation);
            localCodeAttr1.emitStore(localVariable2);
            localCodeAttr1.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("isBound", 0));
            localCodeAttr1.emitIfIntEqZero();
            localCodeAttr1.emitLoad(localVariable2);
          }
          this.new_value.compile(paramCompilation, Target.pushObject);
          if ((i != 0) && (!isSetIfUnbound()))
          {
            localCodeAttr1.emitDupX();
            j = 1;
          }
          localCodeAttr1.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("set", 1));
          if (isSetIfUnbound())
          {
            localCodeAttr1.emitFi();
            localCodeAttr1.popScope();
          }
        }
        else if (((Declaration)localObject1).isSimple())
        {
          Type localType2 = ((Declaration)localObject1).getType();
          Variable localVariable1 = ((Declaration)localObject1).getVariable();
          if (localVariable1 == null)
            localVariable1 = ((Declaration)localObject1).allocateVariable(localCodeAttr1);
          int k = canUseInc(this.new_value, (Declaration)localObject1);
          if (k != 65536)
          {
            CodeAttr localCodeAttr2 = paramCompilation.getCode();
            short s = (short)k;
            localCodeAttr2.emitInc(localVariable1, s);
            j = 0;
            if (i != 0)
            {
              localCodeAttr1.emitLoad(localVariable1);
              j = 1;
            }
          }
          else
          {
            this.new_value.compile(paramCompilation, (Declaration)localObject1);
            j = 0;
            if (i != 0)
            {
              localCodeAttr1.emitDup(localType2);
              j = 1;
            }
            localCodeAttr1.emitStore(localVariable1);
          }
        }
        else if (((((Declaration)localObject1).context instanceof ClassExp)) && (((Declaration)localObject1).field == null) && (!getFlag(16)) && (((ClassExp)((Declaration)localObject1).context).isMakingClassPair()))
        {
          String str = ClassExp.slotToMethodName("set", ((Declaration)localObject1).getName());
          ClassExp localClassExp = (ClassExp)((Declaration)localObject1).context;
          Method localMethod = localClassExp.type.getDeclaredMethod(str, 1);
          localClassExp.loadHeapFrame(paramCompilation);
          this.new_value.compile(paramCompilation, (Declaration)localObject1);
          j = 0;
          if (i != 0)
          {
            localCodeAttr1.emitDupX();
            j = 1;
          }
          localCodeAttr1.emitInvoke(localMethod);
        }
        else
        {
          Field localField = ((Declaration)localObject1).field;
          if (!localField.getStaticFlag())
            ((Declaration)localObject1).loadOwningObject(localDeclaration1, paramCompilation);
          Type localType1 = localField.getType();
          this.new_value.compile(paramCompilation, (Declaration)localObject1);
          paramCompilation.usedClass(localField.getDeclaringClass());
          if (localField.getStaticFlag())
          {
            j = 0;
            if (i != 0)
            {
              localCodeAttr1.emitDup(localType1);
              j = 1;
            }
            localCodeAttr1.emitPutStatic(localField);
          }
          else
          {
            j = 0;
            if (i != 0)
            {
              localCodeAttr1.emitDupX();
              j = 1;
            }
            localCodeAttr1.emitPutField(localField);
          }
        }
      }
    }
    label959: if (i != 0)
    {
      paramTarget.compileFromStack(paramCompilation, getType());
      return;
    }
    paramCompilation.compileConstant(Values.empty, paramTarget);
  }

  public final boolean getHasValue()
  {
    return (0x40 & this.flags) != 0;
  }

  public final Expression getNewValue()
  {
    return this.new_value;
  }

  public final Type getType()
  {
    if (!getHasValue())
      return Type.voidType;
    if (this.binding == null)
      return Type.pointer_type;
    return this.binding.getType();
  }

  public final boolean isDefining()
  {
    return (0x2 & this.flags) != 0;
  }

  public final boolean isFuncDef()
  {
    return (0x10 & this.flags) != 0;
  }

  public final boolean isSetIfUnbound()
  {
    return (0x20 & this.flags) != 0;
  }

  protected boolean mustCompile()
  {
    return false;
  }

  public void print(OutPort paramOutPort)
  {
    if (isDefining());
    for (String str = "(Define"; ; str = "(Set")
    {
      paramOutPort.startLogicalBlock(str, ")", 2);
      paramOutPort.writeSpaceFill();
      printLineColumn(paramOutPort);
      if ((this.binding == null) || (this.symbol.toString() != this.binding.getName()))
      {
        paramOutPort.print('/');
        paramOutPort.print(this.symbol);
      }
      if (this.binding != null)
      {
        paramOutPort.print('/');
        paramOutPort.print(this.binding);
      }
      paramOutPort.writeSpaceLinear();
      this.new_value.print(paramOutPort);
      paramOutPort.endLogicalBlock(")");
      return;
    }
  }

  public final void setDefining(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x2 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFFD & this.flags);
  }

  public final void setFuncDef(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x10 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFEF & this.flags);
  }

  public final void setHasValue(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x40 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFBF & this.flags);
  }

  public final void setSetIfUnbound(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x20 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFDF & this.flags);
  }

  public String toString()
  {
    return "SetExp[" + this.symbol + ":=" + this.new_value + ']';
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitSetExp(this, paramD);
  }

  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    this.new_value = paramExpVisitor.visitAndUpdate(this.new_value, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.SetExp
 * JD-Core Version:    0.6.2
 */