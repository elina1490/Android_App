package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.OutPort;

public class LetExp extends ScopeExp
{
  public Expression body;
  public Expression[] inits;

  public LetExp(Expression[] paramArrayOfExpression)
  {
    this.inits = paramArrayOfExpression;
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    setIndexes();
    int i = ScopeExp.nesting(this);
    Object[] arrayOfObject = new Object[this.frameSize];
    Object localObject1 = paramCallContext.evalFrames;
    if (localObject1 == null)
    {
      localObject1 = new Object[i + 10][];
      paramCallContext.evalFrames = ((Object[][])localObject1);
    }
    Object localObject2;
    while (true)
    {
      localObject2 = localObject1[i];
      localObject1[i] = arrayOfObject;
      int j = 0;
      try
      {
        Object localObject4 = firstDecl();
        label63: if (localObject4 != null)
        {
          if (this.inits[j] == QuoteExp.undefined_exp);
          while (true)
          {
            Declaration localDeclaration = ((Declaration)localObject4).nextDecl();
            localObject4 = localDeclaration;
            j++;
            break label63;
            if (i < localObject1.length)
              break;
            Object[][] arrayOfObject; = new Object[i + 10][];
            System.arraycopy(localObject1, 0, arrayOfObject;, 0, localObject1.length);
            localObject1 = arrayOfObject;;
            paramCallContext.evalFrames = arrayOfObject;;
            break;
            Object localObject5 = evalVariable(j, paramCallContext);
            Type localType = ((Declaration)localObject4).type;
            if ((localType != null) && (localType != Type.pointer_type))
              localObject5 = localType.coerceFromObject(localObject5);
            if (((Declaration)localObject4).isIndirectBinding())
            {
              Location localLocation = ((Declaration)localObject4).makeIndirectLocationFor();
              localLocation.set(localObject5);
              localObject5 = localLocation;
            }
            arrayOfObject[j] = localObject5;
          }
        }
      }
      finally
      {
        localObject1[i] = localObject2;
      }
    }
    this.body.apply(paramCallContext);
    localObject1[i] = localObject2;
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Declaration localDeclaration = firstDecl();
    int i = 0;
    if (i < this.inits.length)
    {
      Object localObject = this.inits[i];
      boolean bool = localDeclaration.needsInit();
      if ((bool) && (localDeclaration.isSimple()))
        localDeclaration.allocateVariable(localCodeAttr);
      Target localTarget;
      if ((!bool) || ((localDeclaration.isIndirectBinding()) && (localObject == QuoteExp.undefined_exp)))
        localTarget = Target.Ignore;
      while (true)
      {
        ((Expression)localObject).compileWithPosition(paramCompilation, localTarget);
        i++;
        localDeclaration = localDeclaration.nextDecl();
        break;
        Type localType = localDeclaration.getType();
        localTarget = CheckedTarget.getInstance(localDeclaration);
        if (localObject == QuoteExp.undefined_exp)
          if ((localType instanceof PrimType))
            localObject = new QuoteExp(new Byte((byte)0));
          else if ((localType != null) && (localType != Type.pointer_type))
            localObject = QuoteExp.nullExp;
      }
    }
    localCodeAttr.enterScope(getVarScope());
    store_rest(paramCompilation, 0, firstDecl());
    this.body.compileWithPosition(paramCompilation, paramTarget);
    popScope(localCodeAttr);
  }

  protected Object evalVariable(int paramInt, CallContext paramCallContext)
    throws Throwable
  {
    return this.inits[paramInt].eval(paramCallContext);
  }

  public Expression getBody()
  {
    return this.body;
  }

  public final Type getType()
  {
    return this.body.getType();
  }

  protected boolean mustCompile()
  {
    return false;
  }

  public void print(OutPort paramOutPort)
  {
    print(paramOutPort, "(Let", ")");
  }

  public void print(OutPort paramOutPort, String paramString1, String paramString2)
  {
    paramOutPort.startLogicalBlock(paramString1 + "#" + this.id, paramString2, 2);
    paramOutPort.writeSpaceFill();
    printLineColumn(paramOutPort);
    paramOutPort.startLogicalBlock("(", false, ")");
    Declaration localDeclaration = firstDecl();
    int i = 0;
    if (localDeclaration != null)
    {
      if (i > 0)
        paramOutPort.writeSpaceFill();
      paramOutPort.startLogicalBlock("(", false, ")");
      localDeclaration.printInfo(paramOutPort);
      if (this.inits != null)
      {
        paramOutPort.writeSpaceFill();
        paramOutPort.print('=');
        paramOutPort.writeSpaceFill();
        if (i < this.inits.length)
          break label144;
        paramOutPort.print("<missing init>");
      }
      while (true)
      {
        i++;
        paramOutPort.endLogicalBlock(")");
        localDeclaration = localDeclaration.nextDecl();
        break;
        label144: if (this.inits[i] == null)
          paramOutPort.print("<null>");
        else
          this.inits[i].print(paramOutPort);
      }
    }
    paramOutPort.endLogicalBlock(")");
    paramOutPort.writeSpaceLinear();
    if (this.body == null)
      paramOutPort.print("<null body>");
    while (true)
    {
      paramOutPort.endLogicalBlock(paramString2);
      return;
      this.body.print(paramOutPort);
    }
  }

  public void setBody(Expression paramExpression)
  {
    this.body = paramExpression;
  }

  void store_rest(Compilation paramCompilation, int paramInt, Declaration paramDeclaration)
  {
    if (paramDeclaration != null)
    {
      store_rest(paramCompilation, paramInt + 1, paramDeclaration.nextDecl());
      if (paramDeclaration.needsInit())
        if (paramDeclaration.isIndirectBinding())
        {
          CodeAttr localCodeAttr = paramCompilation.getCode();
          if (this.inits[paramInt] != QuoteExp.undefined_exp)
            break label79;
          Object localObject = paramDeclaration.getSymbol();
          paramCompilation.compileConstant(localObject, Target.pushObject);
          localCodeAttr.emitInvokeStatic(BindingInitializer.makeLocationMethod(localObject));
        }
    }
    while (true)
    {
      paramDeclaration.compileStore(paramCompilation);
      return;
      label79: paramDeclaration.pushIndirectBinding(paramCompilation);
    }
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitLetExp(this, paramD);
  }

  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    visitInitializers(paramExpVisitor, paramD);
    if (paramExpVisitor.exitValue == null)
      this.body = paramExpVisitor.visitAndUpdate(this.body, paramD);
  }

  public <R, D> void visitInitializers(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    Declaration localDeclaration = firstDecl();
    int i = 0;
    while (i < this.inits.length)
    {
      Expression localExpression1 = this.inits[i];
      if (localExpression1 == null)
        throw new Error("null1 init for " + this + " i:" + i + " d:" + localDeclaration);
      Expression localExpression2 = paramExpVisitor.visitAndUpdate(localExpression1, paramD);
      if (localExpression2 == null)
        throw new Error("null2 init for " + this + " was:" + localExpression1);
      this.inits[i] = localExpression2;
      if (localDeclaration.value == localExpression1)
        localDeclaration.value = localExpression2;
      i++;
      localDeclaration = localDeclaration.nextDecl();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.LetExp
 * JD-Core Version:    0.6.2
 */