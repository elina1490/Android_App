package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;

public class SetFieldProc extends Procedure2
  implements Inlineable
{
  ClassType ctype;
  gnu.bytecode.Field field;

  public SetFieldProc(ClassType paramClassType, String paramString)
  {
    this.ctype = paramClassType;
    this.field = gnu.bytecode.Field.searchField(paramClassType.getFields(), paramString);
  }

  public SetFieldProc(ClassType paramClassType, String paramString, Type paramType, int paramInt)
  {
    this.ctype = paramClassType;
    this.field = paramClassType.getField(paramString);
    if (this.field == null)
      this.field = paramClassType.addField(paramString, paramType, paramInt);
  }

  public SetFieldProc(Class paramClass, String paramString)
  {
    this((ClassType)Type.make(paramClass), paramString);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    try
    {
      this.field.getReflectField().set(paramObject1, this.field.getType().coerceFromObject(paramObject2));
      return Values.empty;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException("no such field " + this.field.getSourceName() + " in " + this.ctype.getName());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    throw new RuntimeException("illegal access for field " + this.field.getSourceName());
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    if ((this.ctype.getReflectClass().getClassLoader() instanceof ArrayClassLoader))
    {
      ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
      return;
    }
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    arrayOfExpression[0].compile(paramCompilation, this.ctype);
    arrayOfExpression[1].compile(paramCompilation, this.field.getType());
    paramCompilation.getCode().emitPutField(this.field);
    paramCompilation.compileConstant(Values.empty, paramTarget);
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Type.voidType;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.SetFieldProc
 * JD-Core Version:    0.6.2
 */