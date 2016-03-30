package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.util.IdentityHashTable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.CharArrayOutPort;
import gnu.mapping.Environment;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0;
import gnu.text.Printable;
import gnu.text.SourceLocator;
import java.io.PrintWriter;

public abstract class Expression extends Procedure0
  implements Printable, SourceLocator
{
  protected static final int NEXT_AVAIL_FLAG = 2;
  public static final int VALIDATED = 1;
  public static final Expression[] noExpressions = new Expression[0];
  String filename;
  protected int flags;
  int position;

  public static void compileButFirst(Expression paramExpression, Compilation paramCompilation)
  {
    BeginExp localBeginExp;
    int i;
    if ((paramExpression instanceof BeginExp))
    {
      localBeginExp = (BeginExp)paramExpression;
      i = localBeginExp.length;
      if (i != 0)
        break label22;
    }
    while (true)
    {
      return;
      label22: Expression[] arrayOfExpression = localBeginExp.exps;
      compileButFirst(arrayOfExpression[0], paramCompilation);
      for (int j = 1; j < i; j++)
        arrayOfExpression[j].compileWithPosition(paramCompilation, Target.Ignore);
    }
  }

  protected static Expression deepCopy(Expression paramExpression)
  {
    return deepCopy(paramExpression, new IdentityHashTable());
  }

  public static Expression deepCopy(Expression paramExpression, IdentityHashTable paramIdentityHashTable)
  {
    if (paramExpression == null)
      return null;
    Object localObject = paramIdentityHashTable.get(paramExpression);
    if (localObject != null)
      return (Expression)localObject;
    Expression localExpression = paramExpression.deepCopy(paramIdentityHashTable);
    paramIdentityHashTable.put(paramExpression, localExpression);
    return localExpression;
  }

  public static Expression[] deepCopy(Expression[] paramArrayOfExpression, IdentityHashTable paramIdentityHashTable)
  {
    if (paramArrayOfExpression == null)
      return null;
    int i = paramArrayOfExpression.length;
    Expression[] arrayOfExpression = new Expression[i];
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label59;
      Expression localExpression1 = paramArrayOfExpression[j];
      Expression localExpression2 = deepCopy(localExpression1, paramIdentityHashTable);
      if ((localExpression2 == null) && (localExpression1 != null))
        break;
      arrayOfExpression[j] = localExpression2;
    }
    label59: return arrayOfExpression;
  }

  public static Expression makeWhile(Object paramObject1, Object paramObject2, Compilation paramCompilation)
  {
    Expression[] arrayOfExpression = new Expression[1];
    LetExp localLetExp = new LetExp(arrayOfExpression);
    Declaration localDeclaration = localLetExp.addDeclaration("%do%loop");
    ApplyExp localApplyExp = new ApplyExp(new ReferenceExp(localDeclaration), noExpressions);
    LambdaExp localLambdaExp = new LambdaExp();
    paramCompilation.push(localLambdaExp);
    localLambdaExp.body = new IfExp(paramCompilation.parse(paramObject1), new BeginExp(paramCompilation.parse(paramObject2), localApplyExp), QuoteExp.voidExp);
    localLambdaExp.setName("%do%loop");
    paramCompilation.pop(localLambdaExp);
    arrayOfExpression[0] = localLambdaExp;
    localDeclaration.noteValue(localLambdaExp);
    localLetExp.setBody(new ApplyExp(new ReferenceExp(localDeclaration), noExpressions));
    return localLetExp;
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    throw new RuntimeException("internal error - " + getClass() + ".eval called");
  }

  public final Object apply0()
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    check0(localCallContext);
    return localCallContext.runUntilValue();
  }

  public final void compile(Compilation paramCompilation, Type paramType)
  {
    compile(paramCompilation, StackTarget.getInstance(paramType));
  }

  public final void compile(Compilation paramCompilation, Declaration paramDeclaration)
  {
    compile(paramCompilation, CheckedTarget.getInstance(paramDeclaration));
  }

  public abstract void compile(Compilation paramCompilation, Target paramTarget);

  public final void compileNotePosition(Compilation paramCompilation, Target paramTarget, Expression paramExpression)
  {
    String str = paramCompilation.getFileName();
    int i = paramCompilation.getLineNumber();
    int j = paramCompilation.getColumnNumber();
    paramCompilation.setLine(paramExpression);
    compile(paramCompilation, paramTarget);
    paramCompilation.setLine(str, i, j);
  }

  public final void compileWithPosition(Compilation paramCompilation, Target paramTarget)
  {
    int i = getLineNumber();
    if (i > 0)
    {
      paramCompilation.getCode().putLineNumber(getFileName(), i);
      compileNotePosition(paramCompilation, paramTarget, this);
      return;
    }
    compile(paramCompilation, paramTarget);
  }

  public final void compileWithPosition(Compilation paramCompilation, Target paramTarget, Expression paramExpression)
  {
    int i = paramExpression.getLineNumber();
    if (i > 0)
    {
      paramCompilation.getCode().putLineNumber(paramExpression.getFileName(), i);
      compileNotePosition(paramCompilation, paramTarget, paramExpression);
      return;
    }
    compile(paramCompilation, paramTarget);
  }

  protected Expression deepCopy(IdentityHashTable paramIdentityHashTable)
  {
    return null;
  }

  public final Object eval(CallContext paramCallContext)
    throws Throwable
  {
    int i = paramCallContext.startFromContext();
    try
    {
      match0(paramCallContext);
      Object localObject = paramCallContext.getFromContext(i);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      paramCallContext.cleanupFromContext(i);
      throw localThrowable;
    }
  }

  public final Object eval(Environment paramEnvironment)
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    Environment localEnvironment = Environment.setSaveCurrent(paramEnvironment);
    try
    {
      Object localObject2 = eval(localCallContext);
      return localObject2;
    }
    finally
    {
      Environment.restoreCurrent(localEnvironment);
    }
  }

  public final int getColumnNumber()
  {
    int i = 0xFFF & this.position;
    if (i == 0)
      return -1;
    return i;
  }

  public final String getFileName()
  {
    return this.filename;
  }

  public boolean getFlag(int paramInt)
  {
    return (paramInt & this.flags) != 0;
  }

  public int getFlags()
  {
    return this.flags;
  }

  public final int getLineNumber()
  {
    int i = this.position >> 12;
    if (i == 0)
      return -1;
    return i;
  }

  public String getPublicId()
  {
    return null;
  }

  public String getSystemId()
  {
    return this.filename;
  }

  public Type getType()
  {
    return Type.pointer_type;
  }

  public boolean isSingleValue()
  {
    return OccurrenceType.itemCountIsOne(getType());
  }

  public boolean isStableSourceLocation()
  {
    return true;
  }

  public final int match0(CallContext paramCallContext)
  {
    paramCallContext.proc = this;
    paramCallContext.pc = 0;
    return 0;
  }

  protected abstract boolean mustCompile();

  public final void print(Consumer paramConsumer)
  {
    if ((paramConsumer instanceof OutPort))
    {
      print((OutPort)paramConsumer);
      return;
    }
    if ((paramConsumer instanceof PrintWriter))
    {
      OutPort localOutPort = new OutPort((PrintWriter)paramConsumer);
      print(localOutPort);
      localOutPort.close();
      return;
    }
    CharArrayOutPort localCharArrayOutPort = new CharArrayOutPort();
    print(localCharArrayOutPort);
    localCharArrayOutPort.close();
    localCharArrayOutPort.writeTo(paramConsumer);
  }

  public abstract void print(OutPort paramOutPort);

  public void printLineColumn(OutPort paramOutPort)
  {
    int i = getLineNumber();
    if (i > 0)
    {
      paramOutPort.print("line:");
      paramOutPort.print(i);
      int j = getColumnNumber();
      if (j > 0)
      {
        paramOutPort.print(':');
        paramOutPort.print(j);
      }
      paramOutPort.writeSpaceFill();
    }
  }

  public final void setFile(String paramString)
  {
    this.filename = paramString;
  }

  public void setFlag(int paramInt)
  {
    this.flags = (paramInt | this.flags);
  }

  public void setFlag(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.flags = (paramInt | this.flags);
      return;
    }
    this.flags &= (paramInt ^ 0xFFFFFFFF);
  }

  public final Expression setLine(Expression paramExpression)
  {
    setLocation(paramExpression);
    return this;
  }

  public final void setLine(int paramInt)
  {
    setLine(paramInt, 0);
  }

  public final void setLine(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 < 0)
      paramInt2 = 0;
    this.position = (paramInt2 + (paramInt1 << 12));
  }

  public void setLine(Compilation paramCompilation)
  {
    int i = paramCompilation.getLineNumber();
    if (i > 0)
    {
      setFile(paramCompilation.getFileName());
      setLine(i, paramCompilation.getColumnNumber());
    }
  }

  public final void setLocation(SourceLocator paramSourceLocator)
  {
    this.filename = paramSourceLocator.getFileName();
    setLine(paramSourceLocator.getLineNumber(), paramSourceLocator.getColumnNumber());
  }

  public boolean side_effects()
  {
    return true;
  }

  public String toString()
  {
    String str = getClass().getName();
    if (str.startsWith("gnu.expr."))
      str = str.substring(9);
    return str + "@" + Integer.toHexString(hashCode());
  }

  public Expression validateApply(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Declaration paramDeclaration)
  {
    paramApplyExp.args = paramInlineCalls.visitExps(paramApplyExp.args, null);
    return paramApplyExp;
  }

  public Object valueIfConstant()
  {
    return null;
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitExpression(this, paramD);
  }

  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.Expression
 * JD-Core Version:    0.6.2
 */