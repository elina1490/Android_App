package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.xml.XMLFilter;

public class DocumentConstructor extends NodeConstructor
{
  public static final DocumentConstructor documentConstructor = new DocumentConstructor();
  static final Method endDocumentMethod = Compilation.typeConsumer.getDeclaredMethod("endDocument", 0);
  static final Method startDocumentMethod = Compilation.typeConsumer.getDeclaredMethod("startDocument", 0);

  public void apply(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    XMLFilter localXMLFilter = pushNodeContext(paramCallContext);
    while (true)
    {
      Object localObject2;
      try
      {
        String str = Location.UNBOUND;
        localXMLFilter.startDocument();
        localObject2 = paramCallContext.getNextArg(str);
        if (localObject2 == str)
        {
          localXMLFilter.endDocument();
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
      localXMLFilter.writeObject(localObject2);
    }
  }

  public void compileToNode(ApplyExp paramApplyExp, Compilation paramCompilation, ConsumerTarget paramConsumerTarget)
  {
    Variable localVariable = paramConsumerTarget.getConsumerVariable();
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    int i = arrayOfExpression.length;
    CodeAttr localCodeAttr = paramCompilation.getCode();
    localCodeAttr.emitLoad(localVariable);
    localCodeAttr.emitInvokeInterface(startDocumentMethod);
    for (int j = 0; j < i; j++)
      compileChild(arrayOfExpression[j], paramCompilation, paramConsumerTarget);
    localCodeAttr.emitLoad(localVariable);
    localCodeAttr.emitInvokeInterface(endDocumentMethod);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.DocumentConstructor
 * JD-Core Version:    0.6.2
 */