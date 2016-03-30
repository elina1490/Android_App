package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;

public class ReferenceExp extends AccessExp
{
  public static final int DONT_DEREFERENCE = 2;
  public static final int PREFER_BINDING2 = 8;
  public static final int PROCEDURE_NAME = 4;
  public static final int TYPE_NAME = 16;
  static int counter;
  int id;

  public ReferenceExp(Declaration paramDeclaration)
  {
    this(paramDeclaration.getSymbol(), paramDeclaration);
  }

  public ReferenceExp(Object paramObject)
  {
    int i = 1 + counter;
    counter = i;
    this.id = i;
    this.symbol = paramObject;
  }

  public ReferenceExp(Object paramObject, Declaration paramDeclaration)
  {
    int i = 1 + counter;
    counter = i;
    this.id = i;
    this.symbol = paramObject;
    this.binding = paramDeclaration;
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object localObject3;
    if ((this.binding != null) && (this.binding.isAlias()) && (!getDontDereference()) && ((this.binding.value instanceof ReferenceExp)))
    {
      ReferenceExp localReferenceExp = (ReferenceExp)this.binding.value;
      if ((localReferenceExp.getDontDereference()) && (localReferenceExp.binding != null))
      {
        Expression localExpression = localReferenceExp.binding.getValue();
        if (((localExpression instanceof QuoteExp)) || ((localExpression instanceof ReferenceExp)) || ((localExpression instanceof LambdaExp)))
        {
          localExpression.apply(paramCallContext);
          return;
        }
      }
      localObject3 = this.binding.value.eval(paramCallContext);
    }
    while (true)
    {
      if ((!getDontDereference()) && (this.binding.isIndirectBinding()))
        localObject3 = ((Location)localObject3).get();
      paramCallContext.writeValue(localObject3);
      return;
      if ((this.binding != null) && (this.binding.field != null) && (this.binding.field.getDeclaringClass().isExisting()) && ((!getDontDereference()) || (this.binding.isIndirectBinding())))
      {
        try
        {
          if (this.binding.field.getStaticFlag());
          Object localObject5;
          for (Object localObject4 = null; ; localObject4 = localObject5)
          {
            localObject3 = this.binding.field.getReflectField().get(localObject4);
            break;
            localObject5 = contextDecl().getValue().eval(paramCallContext);
          }
        }
        catch (Exception localException)
        {
          throw new UnboundLocationException("exception evaluating " + this.symbol + " from " + this.binding.field + " - " + localException, this);
        }
      }
      else if ((this.binding != null) && (((this.binding.value instanceof QuoteExp)) || ((this.binding.value instanceof LambdaExp))) && (this.binding.value != QuoteExp.undefined_exp) && ((!getDontDereference()) || (this.binding.isIndirectBinding())))
      {
        localObject3 = this.binding.value.eval(paramCallContext);
      }
      else
      {
        if ((this.binding == null) || (((this.binding.context instanceof ModuleExp)) && (!this.binding.isPrivate())))
        {
          Environment localEnvironment = Environment.getCurrent();
          Symbol localSymbol;
          Object localObject1;
          label469: Object localObject2;
          if ((this.symbol instanceof Symbol))
          {
            localSymbol = (Symbol)this.symbol;
            if ((!getFlag(8)) || (!isProcedureName()))
              break label507;
            localObject1 = EnvironmentKey.FUNCTION;
            if (!getDontDereference())
              break label513;
            localObject2 = localEnvironment.getLocation(localSymbol, localObject1);
          }
          label507: String str;
          label513: 
          do
          {
            paramCallContext.writeValue(localObject2);
            return;
            localSymbol = localEnvironment.getSymbol(this.symbol.toString());
            break;
            localObject1 = null;
            break label469;
            str = Location.UNBOUND;
            localObject2 = localEnvironment.get(localSymbol, localObject1, str);
          }
          while (localObject2 != str);
          throw new UnboundLocationException(localSymbol, this);
        }
        localObject3 = paramCallContext.evalFrames[ScopeExp.nesting(this.binding.context)][this.binding.evalIndex];
      }
    }
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    if ((!(paramTarget instanceof ConsumerTarget)) || (!((ConsumerTarget)paramTarget).compileWrite(this, paramCompilation)))
      this.binding.load(this, this.flags, paramCompilation, paramTarget);
  }

  protected Expression deepCopy(IdentityHashTable paramIdentityHashTable)
  {
    Declaration localDeclaration = (Declaration)paramIdentityHashTable.get(this.binding, this.binding);
    ReferenceExp localReferenceExp = new ReferenceExp(paramIdentityHashTable.get(this.symbol, this.symbol), localDeclaration);
    localReferenceExp.flags = getFlags();
    return localReferenceExp;
  }

  public final boolean getDontDereference()
  {
    return (0x2 & this.flags) != 0;
  }

  public Type getType()
  {
    Declaration localDeclaration1 = this.binding;
    if ((localDeclaration1 == null) || (localDeclaration1.isFluid()))
      return Type.pointer_type;
    if (getDontDereference())
      return Compilation.typeLocation;
    Declaration localDeclaration2 = Declaration.followAliases(localDeclaration1);
    Object localObject = localDeclaration2.getType();
    if ((localObject == null) || (localObject == Type.pointer_type))
    {
      Expression localExpression1 = localDeclaration2.getValue();
      if ((localExpression1 != null) && (localExpression1 != QuoteExp.undefined_exp))
      {
        Expression localExpression2 = localDeclaration2.value;
        localDeclaration2.value = null;
        localObject = localExpression1.getType();
        localDeclaration2.value = localExpression2;
      }
    }
    if (localObject == Type.toStringType)
      localObject = Type.javalangStringType;
    return localObject;
  }

  public final boolean isProcedureName()
  {
    return (0x4 & this.flags) != 0;
  }

  public boolean isSingleValue()
  {
    if ((this.binding != null) && (this.binding.getFlag(262144L)))
      return true;
    return super.isSingleValue();
  }

  public final boolean isUnknown()
  {
    return Declaration.isUnknown(this.binding);
  }

  protected boolean mustCompile()
  {
    return false;
  }

  public void print(OutPort paramOutPort)
  {
    paramOutPort.print("(Ref/");
    paramOutPort.print(this.id);
    if ((this.symbol != null) && ((this.binding == null) || (this.symbol.toString() != this.binding.getName())))
    {
      paramOutPort.print('/');
      paramOutPort.print(this.symbol);
    }
    if (this.binding != null)
    {
      paramOutPort.print('/');
      paramOutPort.print(this.binding);
    }
    paramOutPort.print(")");
  }

  public final void setDontDereference(boolean paramBoolean)
  {
    setFlag(paramBoolean, 2);
  }

  public final void setProcedureName(boolean paramBoolean)
  {
    setFlag(paramBoolean, 4);
  }

  public boolean side_effects()
  {
    return (this.binding == null) || (!this.binding.isLexical());
  }

  public String toString()
  {
    return "RefExp/" + this.symbol + '/' + this.id + '/';
  }

  public Expression validateApply(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Declaration paramDeclaration)
  {
    Declaration localDeclaration1 = this.binding;
    if ((localDeclaration1 != null) && (!localDeclaration1.getFlag(65536L)))
    {
      Declaration localDeclaration2 = Declaration.followAliases(localDeclaration1);
      if (!localDeclaration2.isIndirectBinding())
      {
        Expression localExpression = localDeclaration2.getValue();
        if (localExpression != null)
          return localExpression.validateApply(paramApplyExp, paramInlineCalls, paramType, localDeclaration2);
      }
    }
    else if ((getSymbol() instanceof Symbol))
    {
      Symbol localSymbol = (Symbol)getSymbol();
      Object localObject = Environment.getCurrent().getFunction(localSymbol, null);
      if ((localObject instanceof Procedure))
        return new QuoteExp(localObject).validateApply(paramApplyExp, paramInlineCalls, paramType, null);
    }
    paramApplyExp.visitArgs(paramInlineCalls);
    return paramApplyExp;
  }

  public final Object valueIfConstant()
  {
    if (this.binding != null)
    {
      Expression localExpression = this.binding.getValue();
      if (localExpression != null)
        return localExpression.valueIfConstant();
    }
    return null;
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitReferenceExp(this, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ReferenceExp
 * JD-Core Version:    0.6.2
 */