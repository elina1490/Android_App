package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;

public class CheckedTarget extends StackTarget
{
  static Method initWrongTypeProcMethod;
  static Method initWrongTypeStringMethod;
  static ClassType typeClassCastException;
  static ClassType typeWrongType;
  int argno;
  LambdaExp proc;
  String procname;

  public CheckedTarget(Type paramType)
  {
    super(paramType);
    this.argno = -4;
  }

  public CheckedTarget(Type paramType, LambdaExp paramLambdaExp, int paramInt)
  {
    super(paramType);
    this.proc = paramLambdaExp;
    this.procname = paramLambdaExp.getName();
    this.argno = paramInt;
  }

  public CheckedTarget(Type paramType, String paramString, int paramInt)
  {
    super(paramType);
    this.procname = paramString;
    this.argno = paramInt;
  }

  public static void emitCheckedCoerce(Compilation paramCompilation, LambdaExp paramLambdaExp, int paramInt, Type paramType)
  {
    emitCheckedCoerce(paramCompilation, paramLambdaExp, paramLambdaExp.getName(), paramInt, paramType, null);
  }

  public static void emitCheckedCoerce(Compilation paramCompilation, LambdaExp paramLambdaExp, int paramInt, Type paramType, Variable paramVariable)
  {
    emitCheckedCoerce(paramCompilation, paramLambdaExp, paramLambdaExp.getName(), paramInt, paramType, paramVariable);
  }

  static void emitCheckedCoerce(Compilation paramCompilation, LambdaExp paramLambdaExp, String paramString, int paramInt, Type paramType, Variable paramVariable)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    boolean bool = localCodeAttr.isInTry();
    initWrongType();
    Label localLabel1 = new Label(localCodeAttr);
    Scope localScope2;
    if ((paramVariable == null) && (paramType != Type.toStringType))
    {
      localScope2 = localCodeAttr.pushScope();
      paramVariable = localCodeAttr.addLocal(Type.objectType);
      localCodeAttr.emitDup(1);
      localCodeAttr.emitStore(paramVariable);
    }
    for (Scope localScope1 = localScope2; ; localScope1 = null)
    {
      int i = localCodeAttr.getPC();
      localLabel1.define(localCodeAttr);
      emitCoerceFromObject(paramType, paramCompilation);
      if ((localCodeAttr.getPC() != i) && (paramType != Type.toStringType))
        break;
      if (localScope1 != null)
        localCodeAttr.popScope();
      return;
    }
    Label localLabel2 = new Label(localCodeAttr);
    localLabel2.define(localCodeAttr);
    Label localLabel3 = new Label(localCodeAttr);
    localLabel3.setTypes(localCodeAttr);
    if (bool)
      localCodeAttr.emitGoto(localLabel3);
    localCodeAttr.setUnreachable();
    int j = 0;
    if (!bool)
      j = localCodeAttr.beginFragment(localLabel3);
    localCodeAttr.addHandler(localLabel1, localLabel2, typeClassCastException);
    if ((paramLambdaExp != null) && (paramLambdaExp.isClassGenerated()) && (!paramCompilation.method.getStaticFlag()) && (paramCompilation.method.getDeclaringClass() == paramLambdaExp.getCompiledClassType(paramCompilation)));
    for (int k = 1; ; k = 0)
    {
      int m = paramCompilation.getLineNumber();
      if (m > 0)
        localCodeAttr.putLineNumber(m);
      localCodeAttr.emitNew(typeWrongType);
      localCodeAttr.emitDupX();
      localCodeAttr.emitSwap();
      if (k != 0)
      {
        localCodeAttr.emitPushThis();
        localCodeAttr.emitPushInt(paramInt);
        localCodeAttr.emitLoad(paramVariable);
        if (k == 0)
          break label386;
      }
      label386: for (Method localMethod = initWrongTypeProcMethod; ; localMethod = initWrongTypeStringMethod)
      {
        localCodeAttr.emitInvokeSpecial(localMethod);
        if (localScope1 != null)
          localCodeAttr.popScope();
        localCodeAttr.emitThrow();
        if (!bool)
          break label394;
        localLabel3.define(localCodeAttr);
        return;
        if ((paramString == null) && (paramInt != -4));
        for (String str = "lambda"; ; str = paramString)
        {
          localCodeAttr.emitPushString(str);
          break;
        }
      }
      label394: localCodeAttr.endFragment(j);
      return;
    }
  }

  public static void emitCheckedCoerce(Compilation paramCompilation, String paramString, int paramInt, Type paramType)
  {
    emitCheckedCoerce(paramCompilation, null, paramString, paramInt, paramType, null);
  }

  public static Target getInstance(Type paramType)
  {
    if (paramType == Type.objectType)
      return Target.pushObject;
    return new CheckedTarget(paramType);
  }

  public static Target getInstance(Type paramType, LambdaExp paramLambdaExp, int paramInt)
  {
    if (paramType == Type.objectType)
      return Target.pushObject;
    return new CheckedTarget(paramType, paramLambdaExp, paramInt);
  }

  public static Target getInstance(Type paramType, String paramString, int paramInt)
  {
    if (paramType == Type.objectType)
      return Target.pushObject;
    return new CheckedTarget(paramType, paramString, paramInt);
  }

  public static Target getInstance(Declaration paramDeclaration)
  {
    return getInstance(paramDeclaration.getType(), paramDeclaration.getName(), -2);
  }

  private static void initWrongType()
  {
    if (typeClassCastException == null)
      typeClassCastException = ClassType.make("java.lang.ClassCastException");
    if (typeWrongType == null)
    {
      typeWrongType = ClassType.make("gnu.mapping.WrongType");
      Type[] arrayOfType1 = new Type[4];
      arrayOfType1[0] = typeClassCastException;
      arrayOfType1[1] = Compilation.javaStringType;
      arrayOfType1[2] = Type.intType;
      arrayOfType1[3] = Type.objectType;
      initWrongTypeStringMethod = typeWrongType.addMethod("<init>", 1, arrayOfType1, Type.voidType);
      Type[] arrayOfType2 = new Type[4];
      arrayOfType2[0] = typeClassCastException;
      arrayOfType2[1] = Compilation.typeProcedure;
      arrayOfType2[2] = Type.intType;
      arrayOfType2[3] = Type.objectType;
      initWrongTypeProcMethod = typeWrongType.addMethod("<init>", 1, arrayOfType2, Type.voidType);
    }
  }

  public void compileFromStack(Compilation paramCompilation, Type paramType)
  {
    if (!compileFromStack0(paramCompilation, paramType))
      emitCheckedCoerce(paramCompilation, this.proc, this.procname, this.argno, this.type, null);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.CheckedTarget
 * JD-Core Version:    0.6.2
 */