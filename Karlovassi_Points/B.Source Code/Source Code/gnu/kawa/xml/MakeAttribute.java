package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.Special;
import gnu.expr.Target;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.xml.XMLFilter;

public class MakeAttribute extends NodeConstructor
{
  static final Method endAttributeMethod = Compilation.typeConsumer.getDeclaredMethod("endAttribute", 0);
  public static final MakeAttribute makeAttribute = new MakeAttribute();
  public static final QuoteExp makeAttributeExp = new QuoteExp(makeAttribute);
  static final Method startAttributeMethod;
  static final ClassType typeMakeAttribute = ClassType.make("gnu.kawa.xml.MakeAttribute");

  static
  {
    startAttributeMethod = typeMakeAttribute.getDeclaredMethod("startAttribute", 2);
  }

  public static void startAttribute(Consumer paramConsumer, Object paramObject)
  {
    paramConsumer.startAttribute(paramObject);
  }

  public void apply(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    XMLFilter localXMLFilter = pushNodeContext(paramCallContext);
    while (true)
    {
      Object localObject2;
      try
      {
        startAttribute(localXMLFilter, paramCallContext.getNextArg());
        Special localSpecial = Special.dfault;
        localObject2 = paramCallContext.getNextArg(localSpecial);
        if (localObject2 == localSpecial)
        {
          localXMLFilter.endAttribute();
          return;
        }
        if ((localObject2 instanceof Consumable))
        {
          ((Consumable)localObject2).consume(localXMLFilter);
          continue;
        }
      }
      finally
      {
        popNodeContext(localConsumer, paramCallContext);
      }
      paramCallContext.writeValue(localObject2);
    }
  }

  public void compileToNode(ApplyExp paramApplyExp, Compilation paramCompilation, ConsumerTarget paramConsumerTarget)
  {
    Variable localVariable = paramConsumerTarget.getConsumerVariable();
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    int i = arrayOfExpression.length;
    CodeAttr localCodeAttr = paramCompilation.getCode();
    localCodeAttr.emitLoad(localVariable);
    localCodeAttr.emitDup();
    arrayOfExpression[0].compile(paramCompilation, Target.pushObject);
    localCodeAttr.emitInvokeStatic(startAttributeMethod);
    for (int j = 1; j < i; j++)
      compileChild(arrayOfExpression[j], paramCompilation, paramConsumerTarget);
    localCodeAttr.emitInvokeInterface(endAttributeMethod);
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return Compilation.typeObject;
  }

  public int numArgs()
  {
    return -4095;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.MakeAttribute
 * JD-Core Version:    0.6.2
 */