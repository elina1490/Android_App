package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import java.util.Iterator;
import java.util.List;

public class ListItems extends MethodProc
{
  public static ListItems listItems = new ListItems();

  public void apply(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    Object localObject = paramCallContext.getNextArg();
    paramCallContext.lastArg();
    List localList = (List)localObject;
    if ((localObject instanceof AbstractSequence))
      ((AbstractSequence)localObject).consumePosRange(0, -1, localConsumer);
    while (true)
    {
      return;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        Values.writeValues(localIterator.next(), localConsumer);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.ListItems
 * JD-Core Version:    0.6.2
 */