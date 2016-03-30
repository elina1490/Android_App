package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;

public class StaticSet extends Procedure1
  implements Inlineable
{
  ClassType ctype;
  gnu.bytecode.Field field;
  String fname;
  java.lang.reflect.Field reflectField;

  public StaticSet(ClassType paramClassType, String paramString, Type paramType, int paramInt)
  {
    this.ctype = paramClassType;
    this.fname = paramString;
    this.field = paramClassType.getField(paramString);
    if (this.field == null)
      this.field = paramClassType.addField(paramString, paramType, paramInt);
  }

  StaticSet(Class paramClass, String paramString)
  {
    this.ctype = ((ClassType)Type.make(paramClass));
    this.fname = paramString;
  }

  // ERROR //
  public java.lang.Object apply1(java.lang.Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	gnu/kawa/reflect/StaticSet:reflectField	Ljava/lang/reflect/Field;
    //   4: ifnonnull +25 -> 29
    //   7: aload_0
    //   8: getfield 21	gnu/kawa/reflect/StaticSet:ctype	Lgnu/bytecode/ClassType;
    //   11: invokevirtual 54	gnu/bytecode/ClassType:getReflectClass	()Ljava/lang/Class;
    //   14: astore 4
    //   16: aload_0
    //   17: aload 4
    //   19: aload_0
    //   20: getfield 23	gnu/kawa/reflect/StaticSet:fname	Ljava/lang/String;
    //   23: invokevirtual 59	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   26: putfield 50	gnu/kawa/reflect/StaticSet:reflectField	Ljava/lang/reflect/Field;
    //   29: aload_0
    //   30: getfield 50	gnu/kawa/reflect/StaticSet:reflectField	Ljava/lang/reflect/Field;
    //   33: aconst_null
    //   34: aload_1
    //   35: invokevirtual 65	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   38: getstatic 71	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   41: astore_3
    //   42: aload_3
    //   43: areturn
    //   44: astore 5
    //   46: new 73	java/lang/RuntimeException
    //   49: dup
    //   50: new 75	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   57: ldc 78
    //   59: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 23	gnu/kawa/reflect/StaticSet:fname	Ljava/lang/String;
    //   66: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 84
    //   71: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 4
    //   76: invokevirtual 88	java/lang/Class:getName	()Ljava/lang/String;
    //   79: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokespecial 94	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   88: athrow
    //   89: astore_2
    //   90: new 73	java/lang/RuntimeException
    //   93: dup
    //   94: new 75	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   101: ldc 96
    //   103: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_0
    //   107: getfield 23	gnu/kawa/reflect/StaticSet:fname	Ljava/lang/String;
    //   110: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokespecial 94	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   119: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   16	29	44	java/lang/NoSuchFieldException
    //   29	42	89	java/lang/IllegalAccessException
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    if (this.field == null)
    {
      this.field = this.ctype.getField(this.fname);
      if (this.field == null)
        this.field = this.ctype.addField(this.fname, Type.make(this.reflectField.getType()), this.reflectField.getModifiers());
    }
    paramApplyExp.getArgs()[0].compile(paramCompilation, this.field.getType());
    paramCompilation.getCode().emitPutStatic(this.field);
    paramCompilation.compileConstant(Values.empty, paramTarget);
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Type.voidType;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.StaticSet
 * JD-Core Version:    0.6.2
 */