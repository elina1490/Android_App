package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;

public class MakeResponseHeader extends MethodProc
{
  public static MakeResponseHeader makeResponseHeader = new MakeResponseHeader();

  public void apply(CallContext paramCallContext)
  {
    String str = paramCallContext.getNextArg().toString();
    Object localObject = paramCallContext.getNextArg();
    paramCallContext.lastArg();
    Consumer localConsumer = paramCallContext.consumer;
    localConsumer.startAttribute(str);
    localConsumer.write(localObject.toString());
    localConsumer.endAttribute();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.MakeResponseHeader
 * JD-Core Version:    0.6.2
 */