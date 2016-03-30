package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.Procedure;
import gnu.mapping.Values;

public class CompileArrays
  implements Inlineable
{
  public char code;
  Procedure proc;

  public CompileArrays(Procedure paramProcedure, char paramChar)
  {
    this.proc = paramProcedure;
    this.code = paramChar;
  }

  public static void compileArrayGet(ArrayGet paramArrayGet, ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Type localType = paramArrayGet.element_type;
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    arrayOfExpression[0].compile(paramCompilation, ArrayType.make(localType));
    arrayOfExpression[1].compile(paramCompilation, Type.int_type);
    paramCompilation.getCode().emitArrayLoad(localType);
    paramTarget.compileFromStack(paramCompilation, localType);
  }

  public static void compileArrayLength(ArrayLength paramArrayLength, ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Type localType = paramArrayLength.element_type;
    paramApplyExp.getArgs()[0].compile(paramCompilation, ArrayType.make(localType));
    paramCompilation.getCode().emitArrayLength();
    paramTarget.compileFromStack(paramCompilation, LangPrimType.intType);
  }

  public static void compileArrayNew(ArrayNew paramArrayNew, ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Type localType = paramArrayNew.element_type;
    paramApplyExp.getArgs()[0].compile(paramCompilation, Type.intType);
    paramCompilation.getCode().emitNewArray(localType.getImplementationType());
    paramTarget.compileFromStack(paramCompilation, ArrayType.make(localType));
  }

  public static void compileArraySet(ArraySet paramArraySet, ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Type localType = paramArraySet.element_type;
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    arrayOfExpression[0].compile(paramCompilation, ArrayType.make(localType));
    arrayOfExpression[1].compile(paramCompilation, Type.int_type);
    arrayOfExpression[2].compile(paramCompilation, localType);
    paramCompilation.getCode().emitArrayStore(localType);
    paramCompilation.compileConstant(Values.empty, paramTarget);
  }

  public static CompileArrays getForArrayGet(Object paramObject)
  {
    return new CompileArrays((Procedure)paramObject, 'G');
  }

  public static CompileArrays getForArrayLength(Object paramObject)
  {
    return new CompileArrays((Procedure)paramObject, 'L');
  }

  public static CompileArrays getForArrayNew(Object paramObject)
  {
    return new CompileArrays((Procedure)paramObject, 'N');
  }

  public static CompileArrays getForArraySet(Object paramObject)
  {
    return new CompileArrays((Procedure)paramObject, 'S');
  }

  public static Expression validateArrayGet(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramApplyExp.setType(((ArrayGet)paramProcedure).element_type);
    return paramApplyExp;
  }

  public static Expression validateArrayLength(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramApplyExp.setType(LangPrimType.intType);
    return paramApplyExp;
  }

  public static Expression validateArrayNew(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramApplyExp.setType(ArrayType.make(((ArrayNew)paramProcedure).element_type));
    return paramApplyExp;
  }

  public static Expression validateArraySet(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    paramApplyExp.setType(Type.void_type);
    return paramApplyExp;
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    switch (this.code)
    {
    default:
      compileArrayLength((ArrayLength)this.proc, paramApplyExp, paramCompilation, paramTarget);
      return;
    case 'N':
      compileArrayNew((ArrayNew)this.proc, paramApplyExp, paramCompilation, paramTarget);
      return;
    case 'G':
      compileArrayGet((ArrayGet)this.proc, paramApplyExp, paramCompilation, paramTarget);
      return;
    case 'S':
    }
    compileArraySet((ArraySet)this.proc, paramApplyExp, paramCompilation, paramTarget);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.CompileArrays
 * JD-Core Version:    0.6.2
 */