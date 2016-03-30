package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.lists.TreePosition;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;

public class Children extends MethodProc
{
  public static final Children children = new Children();

  public static void children(TreeList paramTreeList, int paramInt, Consumer paramConsumer)
  {
    int i = paramTreeList.gotoChildrenStart(paramInt);
    if (i < 0);
    int k;
    int m;
    do
    {
      return;
      int j = paramTreeList.nextDataIndex(paramInt);
      k = i << 1;
      m = paramTreeList.nextNodeIndex(i, j);
      if (m == i)
        m = paramTreeList.nextDataIndex(i);
    }
    while (m < 0);
    if ((paramConsumer instanceof PositionConsumer))
      ((PositionConsumer)paramConsumer).writePosition(paramTreeList, k);
    while (true)
    {
      i = m;
      break;
      paramTreeList.consumeIRange(i, m, paramConsumer);
    }
  }

  public static void children(Object paramObject, Consumer paramConsumer)
  {
    if ((paramObject instanceof TreeList))
      children((TreeList)paramObject, 0, paramConsumer);
    SeqPosition localSeqPosition;
    do
    {
      do
        return;
      while ((!(paramObject instanceof SeqPosition)) || ((paramObject instanceof TreePosition)));
      localSeqPosition = (SeqPosition)paramObject;
    }
    while (!(localSeqPosition.sequence instanceof TreeList));
    children((TreeList)localSeqPosition.sequence, localSeqPosition.ipos >> 1, paramConsumer);
  }

  public void apply(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    Object localObject = paramCallContext.getNextArg();
    paramCallContext.lastArg();
    if ((localObject instanceof Values))
    {
      TreeList localTreeList = (TreeList)localObject;
      int i = 0;
      int j = localTreeList.getNextKind(i << 1);
      if (j == 0)
        return;
      if (j == 32)
        children(localTreeList.getPosNext(i << 1), localConsumer);
      while (true)
      {
        i = localTreeList.nextDataIndex(i);
        break;
        children(localTreeList, i, localConsumer);
      }
    }
    children(localObject, localConsumer);
  }

  public int numArgs()
  {
    return 4097;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.Children
 * JD-Core Version:    0.6.2
 */