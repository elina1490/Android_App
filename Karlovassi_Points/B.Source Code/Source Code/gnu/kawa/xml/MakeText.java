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
import gnu.expr.Target;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.xml.NodeTree;
import gnu.xml.TextUtils;
import gnu.xml.XMLFilter;

public class MakeText extends NodeConstructor
{
  public static final MakeText makeText = new MakeText();

  public static void text$X(Object paramObject, CallContext paramCallContext)
  {
    if ((paramObject == null) || (((paramObject instanceof Values)) && (((Values)paramObject).isEmpty())))
      return;
    Consumer localConsumer = paramCallContext.consumer;
    XMLFilter localXMLFilter = NodeConstructor.pushNodeContext(paramCallContext);
    try
    {
      TextUtils.textValue(paramObject, localXMLFilter);
      return;
    }
    finally
    {
      NodeConstructor.popNodeContext(localConsumer, paramCallContext);
    }
  }

  public void apply(CallContext paramCallContext)
  {
    text$X(paramCallContext.getNextArg(null), paramCallContext);
  }

  public Object apply1(Object paramObject)
  {
    if ((paramObject == null) || (((paramObject instanceof Values)) && (((Values)paramObject).isEmpty())))
      return paramObject;
    NodeTree localNodeTree = new NodeTree();
    TextUtils.textValue(paramObject, new XMLFilter(localNodeTree));
    return KText.make(localNodeTree);
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }

  public void compileToNode(ApplyExp paramApplyExp, Compilation paramCompilation, ConsumerTarget paramConsumerTarget)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Expression localExpression = paramApplyExp.getArgs()[0];
    Variable localVariable = paramConsumerTarget.getConsumerVariable();
    if ((localExpression instanceof QuoteExp))
    {
      Object localObject = ((QuoteExp)localExpression).getValue();
      if ((localObject instanceof String))
      {
        String str1 = (String)localObject;
        String str2 = CodeAttr.calculateSplit(str1);
        int i = str2.length();
        ClassType localClassType = (ClassType)localVariable.getType();
        Type[] arrayOfType = new Type[1];
        arrayOfType[0] = Type.string_type;
        Method localMethod = localClassType.getMethod("write", arrayOfType);
        int j = 0;
        for (int k = 0; k < i; k++)
        {
          localCodeAttr.emitLoad(localVariable);
          int m = j + str2.charAt(k);
          localCodeAttr.emitPushString(str1.substring(j, m));
          localCodeAttr.emitInvoke(localMethod);
          j = m;
        }
      }
    }
    localExpression.compile(paramCompilation, Target.pushObject);
    localCodeAttr.emitLoad(localVariable);
    localCodeAttr.emitInvokeStatic(ClassType.make("gnu.xml.TextUtils").getDeclaredMethod("textValue", 2));
  }

  public int numArgs()
  {
    return 4097;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.MakeText
 * JD-Core Version:    0.6.2
 */