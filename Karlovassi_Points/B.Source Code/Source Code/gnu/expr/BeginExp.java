package gnu.expr;

import gnu.bytecode.Type;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;
import gnu.text.Options;
import java.util.Vector;

public class BeginExp extends Expression
{
  Vector compileOptions;
  Expression[] exps;
  int length;

  public BeginExp()
  {
  }

  public BeginExp(Expression paramExpression1, Expression paramExpression2)
  {
    this.exps = new Expression[2];
    this.exps[0] = paramExpression1;
    this.exps[1] = paramExpression2;
    this.length = 2;
  }

  public BeginExp(Expression[] paramArrayOfExpression)
  {
    this.exps = paramArrayOfExpression;
    this.length = paramArrayOfExpression.length;
  }

  public static final Expression canonicalize(Expression paramExpression)
  {
    if ((paramExpression instanceof BeginExp))
    {
      BeginExp localBeginExp = (BeginExp)paramExpression;
      if (localBeginExp.compileOptions != null)
        return paramExpression;
      int i = localBeginExp.length;
      if (i == 0)
        return QuoteExp.voidExp;
      if (i == 1)
        return canonicalize(localBeginExp.exps[0]);
    }
    return paramExpression;
  }

  public static final Expression canonicalize(Expression[] paramArrayOfExpression)
  {
    int i = paramArrayOfExpression.length;
    if (i == 0)
      return QuoteExp.voidExp;
    if (i == 1)
      return canonicalize(paramArrayOfExpression[0]);
    return new BeginExp(paramArrayOfExpression);
  }

  public final void add(Expression paramExpression)
  {
    if (this.exps == null)
      this.exps = new Expression[8];
    if (this.length == this.exps.length)
    {
      Expression[] arrayOfExpression2 = new Expression[2 * this.length];
      System.arraycopy(this.exps, 0, arrayOfExpression2, 0, this.length);
      this.exps = arrayOfExpression2;
    }
    Expression[] arrayOfExpression1 = this.exps;
    int i = this.length;
    this.length = (i + 1);
    arrayOfExpression1[i] = paramExpression;
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    int i = this.length;
    Consumer localConsumer = paramCallContext.consumer;
    paramCallContext.consumer = VoidConsumer.instance;
    int j = 0;
    while (true)
    {
      if (j < i - 1);
      try
      {
        this.exps[j].eval(paramCallContext);
        j++;
        continue;
        paramCallContext.consumer = localConsumer;
        this.exps[j].apply(paramCallContext);
        return;
      }
      finally
      {
        paramCallContext.consumer = localConsumer;
      }
    }
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    pushOptions(paramCompilation);
    try
    {
      int i = this.length;
      for (int j = 0; j < i - 1; j++)
        this.exps[j].compileWithPosition(paramCompilation, Target.Ignore);
      this.exps[j].compileWithPosition(paramCompilation, paramTarget);
      return;
    }
    finally
    {
      popOptions(paramCompilation);
    }
  }

  public final int getExpressionCount()
  {
    return this.length;
  }

  public final Expression[] getExpressions()
  {
    return this.exps;
  }

  public Type getType()
  {
    return this.exps[(this.length - 1)].getType();
  }

  protected boolean mustCompile()
  {
    return false;
  }

  public void popOptions(Compilation paramCompilation)
  {
    if ((this.compileOptions != null) && (paramCompilation != null))
      paramCompilation.currentOptions.popOptionValues(this.compileOptions);
  }

  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(Begin", ")", 2);
    paramOutPort.writeSpaceFill();
    printLineColumn(paramOutPort);
    if (this.compileOptions != null)
    {
      paramOutPort.writeSpaceFill();
      paramOutPort.startLogicalBlock("(CompileOptions", ")", 2);
      int k = this.compileOptions.size();
      for (int m = 0; m < k; m += 3)
      {
        Object localObject1 = this.compileOptions.elementAt(m);
        Object localObject2 = this.compileOptions.elementAt(m + 2);
        paramOutPort.writeSpaceFill();
        paramOutPort.startLogicalBlock("", "", 2);
        paramOutPort.print(localObject1);
        paramOutPort.print(':');
        paramOutPort.writeSpaceLinear();
        paramOutPort.print(localObject2);
        paramOutPort.endLogicalBlock("");
      }
      paramOutPort.endLogicalBlock(")");
    }
    int i = this.length;
    for (int j = 0; j < i; j++)
    {
      paramOutPort.writeSpaceLinear();
      this.exps[j].print(paramOutPort);
    }
    paramOutPort.endLogicalBlock(")");
  }

  public void pushOptions(Compilation paramCompilation)
  {
    if ((this.compileOptions != null) && (paramCompilation != null))
      paramCompilation.currentOptions.pushOptionValues(this.compileOptions);
  }

  public void setCompileOptions(Vector paramVector)
  {
    this.compileOptions = paramVector;
  }

  public final void setExpressions(Expression[] paramArrayOfExpression)
  {
    this.exps = paramArrayOfExpression;
    this.length = paramArrayOfExpression.length;
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    pushOptions(paramExpVisitor.comp);
    try
    {
      Object localObject2 = paramExpVisitor.visitBeginExp(this, paramD);
      return localObject2;
    }
    finally
    {
      popOptions(paramExpVisitor.comp);
    }
  }

  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    this.exps = paramExpVisitor.visitExps(this.exps, this.length, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.BeginExp
 * JD-Core Version:    0.6.2
 */