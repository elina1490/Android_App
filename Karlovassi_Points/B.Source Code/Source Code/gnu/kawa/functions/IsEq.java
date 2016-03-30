package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.Target;
import gnu.mapping.Procedure2;

public class IsEq extends Procedure2
  implements Inlineable
{
  Language language;

  public IsEq(Language paramLanguage, String paramString)
  {
    this.language = paramLanguage;
    setName(paramString);
  }

  public static void compile(Expression[] paramArrayOfExpression, Compilation paramCompilation, Target paramTarget, Language paramLanguage)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    paramArrayOfExpression[0].compile(paramCompilation, Target.pushObject);
    paramArrayOfExpression[1].compile(paramCompilation, Target.pushObject);
    if ((paramTarget instanceof ConditionalTarget))
    {
      ConditionalTarget localConditionalTarget = (ConditionalTarget)paramTarget;
      if (localConditionalTarget.trueBranchComesFirst)
        localCodeAttr.emitGotoIfNE(localConditionalTarget.ifFalse);
      while (true)
      {
        localConditionalTarget.emitGotoFirstBranch(localCodeAttr);
        return;
        localCodeAttr.emitGotoIfEq(localConditionalTarget.ifTrue);
      }
    }
    localCodeAttr.emitIfEq();
    Object localObject1;
    if ((paramTarget.getType() instanceof ClassType))
    {
      Object localObject2 = paramLanguage.booleanObject(true);
      Object localObject3 = paramLanguage.booleanObject(false);
      paramCompilation.compileConstant(localObject2, Target.pushObject);
      localCodeAttr.emitElse();
      paramCompilation.compileConstant(localObject3, Target.pushObject);
      if (((localObject2 instanceof Boolean)) && ((localObject3 instanceof Boolean)))
        localObject1 = Compilation.scmBooleanType;
    }
    while (true)
    {
      localCodeAttr.emitFi();
      paramTarget.compileFromStack(paramCompilation, (Type)localObject1);
      return;
      localObject1 = Type.pointer_type;
      continue;
      localCodeAttr.emitPushInt(1);
      localCodeAttr.emitElse();
      localCodeAttr.emitPushInt(0);
      localObject1 = paramLanguage.getTypeFor(Boolean.TYPE);
    }
  }

  public boolean apply(Object paramObject1, Object paramObject2)
  {
    return paramObject1 == paramObject2;
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    Language localLanguage = this.language;
    if (paramObject1 == paramObject2);
    for (boolean bool = true; ; bool = false)
      return localLanguage.booleanObject(bool);
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    compile(paramApplyExp.getArgs(), paramCompilation, paramTarget, this.language);
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return this.language.getTypeFor(Boolean.TYPE);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.IsEq
 * JD-Core Version:    0.6.2
 */