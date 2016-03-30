package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.lists.TreePosition;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import java.io.PrintStream;

public class Attributes extends MethodProc
{
  public static final Attributes attributes = new Attributes();

  public static void attributes(TreeList paramTreeList, int paramInt, Consumer paramConsumer)
  {
    int i = paramTreeList.gotoAttributesStart(paramInt);
    System.out.print("Attributes called, at:" + i + " ");
    paramTreeList.dump();
    int j;
    if (i >= 0)
    {
      j = i << 1;
      if (paramTreeList.getNextKind(j) == 35);
    }
    else
    {
      return;
    }
    int k = paramTreeList.nextDataIndex(i);
    if ((paramConsumer instanceof PositionConsumer))
      ((PositionConsumer)paramConsumer).writePosition(paramTreeList, j);
    while (true)
    {
      i = k;
      break;
      paramTreeList.consumeIRange(i, k, paramConsumer);
    }
  }

  public static void attributes(Object paramObject, Consumer paramConsumer)
  {
    if ((paramObject instanceof TreeList))
      attributes((TreeList)paramObject, 0, paramConsumer);
    SeqPosition localSeqPosition;
    do
    {
      do
        return;
      while ((!(paramObject instanceof SeqPosition)) || ((paramObject instanceof TreePosition)));
      localSeqPosition = (SeqPosition)paramObject;
    }
    while (!(localSeqPosition.sequence instanceof TreeList));
    attributes((TreeList)localSeqPosition.sequence, localSeqPosition.ipos >> 1, paramConsumer);
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
        attributes(localTreeList.getPosNext(i << 1), localConsumer);
      while (true)
      {
        i = localTreeList.nextDataIndex(i);
        break;
        attributes(localTreeList, i, localConsumer);
      }
    }
    attributes(localObject, localConsumer);
  }

  public int numArgs()
  {
    return 4097;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.Attributes
 * JD-Core Version:    0.6.2
 */