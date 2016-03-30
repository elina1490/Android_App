package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.xml.TextUtils;
import gnu.xml.XMLFilter;

public class MakeProcInst extends NodeConstructor
{
  public static final MakeProcInst makeProcInst = new MakeProcInst();

  public static void procInst$C(Object paramObject1, Object paramObject2, Consumer paramConsumer)
  {
    Object localObject = KNode.atomicValue(paramObject1);
    if ((!(localObject instanceof String)) && (!(localObject instanceof UntypedAtomic)))
      throw new ClassCastException("invalid type of processing-instruction target [XPTY0004]");
    if (!(paramConsumer instanceof XConsumer))
      return;
    StringBuffer localStringBuffer = new StringBuffer();
    if ((paramObject2 instanceof Values))
    {
      Object[] arrayOfObject = ((Values)paramObject2).getValues();
      for (int k = 0; k < arrayOfObject.length; k++)
      {
        if (k > 0)
          localStringBuffer.append(' ');
        TextUtils.stringValue(arrayOfObject[k], localStringBuffer);
      }
    }
    TextUtils.stringValue(paramObject2, localStringBuffer);
    int i = localStringBuffer.length();
    for (int j = 0; (j < i) && (Character.isWhitespace(localStringBuffer.charAt(j))); j++);
    char[] arrayOfChar = new char[i - j];
    localStringBuffer.getChars(j, i, arrayOfChar, 0);
    ((XConsumer)paramConsumer).writeProcessingInstruction(localObject.toString(), arrayOfChar, 0, arrayOfChar.length);
  }

  public static void procInst$X(Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    XMLFilter localXMLFilter = NodeConstructor.pushNodeContext(paramCallContext);
    try
    {
      procInst$C(paramObject1, paramObject2, localXMLFilter);
      return;
    }
    finally
    {
      NodeConstructor.popNodeContext(localConsumer, paramCallContext);
    }
  }

  public void apply(CallContext paramCallContext)
  {
    procInst$X(paramCallContext.getNextArg(null), paramCallContext.getNextArg(null), paramCallContext);
  }

  public void compileToNode(ApplyExp paramApplyExp, Compilation paramCompilation, ConsumerTarget paramConsumerTarget)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    arrayOfExpression[0].compile(paramCompilation, Target.pushObject);
    arrayOfExpression[1].compile(paramCompilation, Target.pushObject);
    localCodeAttr.emitLoad(paramConsumerTarget.getConsumerVariable());
    localCodeAttr.emitInvokeStatic(ClassType.make("gnu.kawa.xml.MakeProcInst").getDeclaredMethod("procInst$C", 3));
  }

  public int numArgs()
  {
    return 8194;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.MakeProcInst
 * JD-Core Version:    0.6.2
 */