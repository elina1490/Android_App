package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;

public class ClassInitializer extends Initializer
{
  ClassExp cexp;

  public ClassInitializer(ClassExp paramClassExp, Compilation paramCompilation)
  {
    this.field = paramClassExp.allocFieldFor(paramCompilation);
    paramClassExp.compileMembers(paramCompilation);
    this.cexp = paramClassExp;
    if (this.field.getStaticFlag())
    {
      this.next = paramCompilation.clinitChain;
      paramCompilation.clinitChain = this;
      return;
    }
    LambdaExp localLambdaExp = paramClassExp.getOwningLambda();
    this.next = localLambdaExp.initChain;
    localLambdaExp.initChain = this;
  }

  public void emit(Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (!this.field.getStaticFlag())
      localCodeAttr.emitPushThis();
    this.cexp.compilePushClass(paramCompilation, Target.pushValue(Compilation.typeClassType));
    if (this.field.getStaticFlag())
    {
      localCodeAttr.emitPutStatic(this.field);
      return;
    }
    localCodeAttr.emitPutField(this.field);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ClassInitializer
 * JD-Core Version:    0.6.2
 */