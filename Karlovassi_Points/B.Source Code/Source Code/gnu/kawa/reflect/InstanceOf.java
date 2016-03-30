package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;

public class InstanceOf extends Procedure2
  implements Inlineable
{
  static Method instanceMethod;
  static ClassType typeType;
  protected Language language;

  public InstanceOf(Language paramLanguage)
  {
    this.language = paramLanguage;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplyInstanceOf");
  }

  public InstanceOf(Language paramLanguage, String paramString)
  {
    this(paramLanguage);
    setName(paramString);
  }

  public static void emitIsInstance(TypeValue paramTypeValue, Variable paramVariable, Compilation paramCompilation, Target paramTarget)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    paramTypeValue.emitTestIf(null, null, paramCompilation);
    ConditionalTarget localConditionalTarget;
    if ((paramTarget instanceof ConditionalTarget))
    {
      localConditionalTarget = (ConditionalTarget)paramTarget;
      localCodeAttr.emitGoto(localConditionalTarget.ifTrue);
      localCodeAttr.emitElse();
      if (localConditionalTarget == null)
        break label96;
      localCodeAttr.emitGoto(localConditionalTarget.ifFalse);
    }
    while (true)
    {
      localCodeAttr.emitFi();
      if (localConditionalTarget == null)
        paramTarget.compileFromStack(paramCompilation, paramCompilation.getLanguage().getTypeFor(Boolean.TYPE));
      return;
      localCodeAttr.emitPushInt(1);
      localConditionalTarget = null;
      break;
      label96: localCodeAttr.emitPushInt(0);
    }
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    Object localObject = this.language.asType(paramObject2);
    if ((localObject instanceof PrimType))
      localObject = ((PrimType)localObject).boxedType();
    return this.language.booleanObject(((Type)localObject).isInstance(paramObject1));
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Expression localExpression = arrayOfExpression[1];
    if ((localExpression instanceof QuoteExp));
    Object localObject;
    while (true)
    {
      try
      {
        Type localType = this.language.asType(((QuoteExp)localExpression).getValue());
        localObject = localType;
        if (localObject == null)
          break label179;
        if ((localObject instanceof PrimType))
          localObject = ((PrimType)localObject).boxedType();
        arrayOfExpression[0].compile(paramCompilation, Target.pushObject);
        if (!(localObject instanceof TypeValue))
          break;
        ((TypeValue)localObject).emitIsInstance(null, paramCompilation, paramTarget);
        return;
      }
      catch (Exception localException)
      {
        paramCompilation.error('w', "unknown type spec: " + null);
        localObject = null;
        continue;
      }
      localObject = this.language.getTypeFor(localExpression);
    }
    ((Type)localObject).emitIsInstance(localCodeAttr);
    paramCompilation.usedClass((Type)localObject);
    while (true)
    {
      paramTarget.compileFromStack(paramCompilation, this.language.getTypeFor(Boolean.TYPE));
      return;
      label179: if (typeType == null)
      {
        typeType = ClassType.make("gnu.bytecode.Type");
        instanceMethod = typeType.addMethod("isInstance", Compilation.apply1args, Type.boolean_type, 1);
      }
      arrayOfExpression[1].compile(paramCompilation, typeType);
      arrayOfExpression[0].compile(paramCompilation, Target.pushObject);
      localCodeAttr.emitInvokeVirtual(instanceMethod);
    }
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return this.language.getTypeFor(Boolean.TYPE);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.InstanceOf
 * JD-Core Version:    0.6.2
 */