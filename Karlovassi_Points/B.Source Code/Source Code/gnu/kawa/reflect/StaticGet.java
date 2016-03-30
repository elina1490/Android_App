package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.Procedure0;

public class StaticGet extends Procedure0
  implements Inlineable
{
  ClassType ctype;
  gnu.bytecode.Field field;
  String fname;
  java.lang.reflect.Field reflectField;

  public StaticGet(ClassType paramClassType, String paramString, Type paramType, int paramInt)
  {
    this.ctype = paramClassType;
    this.fname = paramString;
    this.field = paramClassType.getField(paramString);
    if (this.field == null)
      this.field = paramClassType.addField(paramString, paramType, paramInt);
  }

  StaticGet(Class paramClass, String paramString)
  {
    this.ctype = ((ClassType)Type.make(paramClass));
    this.fname = paramString;
  }

  private gnu.bytecode.Field getField()
  {
    if (this.field == null)
    {
      this.field = this.ctype.getField(this.fname);
      if (this.field == null)
        this.field = this.ctype.addField(this.fname, Type.make(this.reflectField.getType()), this.reflectField.getModifiers());
    }
    return this.field;
  }

  // ERROR //
  public java.lang.Object apply0()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	gnu/kawa/reflect/StaticGet:reflectField	Ljava/lang/reflect/Field;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: getfield 21	gnu/kawa/reflect/StaticGet:ctype	Lgnu/bytecode/ClassType;
    //   11: invokevirtual 64	gnu/bytecode/ClassType:getReflectClass	()Ljava/lang/Class;
    //   14: astore_3
    //   15: aload_0
    //   16: aload_3
    //   17: aload_0
    //   18: getfield 23	gnu/kawa/reflect/StaticGet:fname	Ljava/lang/String;
    //   21: invokevirtual 69	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   24: putfield 45	gnu/kawa/reflect/StaticGet:reflectField	Ljava/lang/reflect/Field;
    //   27: aload_0
    //   28: getfield 45	gnu/kawa/reflect/StaticGet:reflectField	Ljava/lang/reflect/Field;
    //   31: aconst_null
    //   32: invokevirtual 73	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: astore_2
    //   36: aload_2
    //   37: areturn
    //   38: astore 4
    //   40: new 75	java/lang/RuntimeException
    //   43: dup
    //   44: new 77	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   51: ldc 80
    //   53: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 23	gnu/kawa/reflect/StaticGet:fname	Ljava/lang/String;
    //   60: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 86
    //   65: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_3
    //   69: invokevirtual 90	java/lang/Class:getName	()Ljava/lang/String;
    //   72: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 96	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   81: athrow
    //   82: astore_1
    //   83: new 75	java/lang/RuntimeException
    //   86: dup
    //   87: new 77	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   94: ldc 98
    //   96: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: getfield 23	gnu/kawa/reflect/StaticGet:fname	Ljava/lang/String;
    //   103: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokespecial 96	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   112: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   15	27	38	java/lang/NoSuchFieldException
    //   27	36	82	java/lang/IllegalAccessException
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    getField();
    paramCompilation.getCode().emitGetStatic(this.field);
    paramTarget.compileFromStack(paramCompilation, this.field.getType());
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return getField().getType();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.StaticGet
 * JD-Core Version:    0.6.2
 */