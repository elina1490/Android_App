package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import java.util.Iterator;

public class IteratorItems extends MethodProc
{
  public static IteratorItems iteratorItems = new IteratorItems();

  public void apply(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    Object localObject = paramCallContext.getNextArg();
    paramCallContext.lastArg();
    Iterator localIterator = (Iterator)localObject;
    while (localIterator.hasNext())
      Values.writeValues(localIterator.next(), localConsumer);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.IteratorItems
 * JD-Core Version:    0.6.2
 */