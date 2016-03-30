package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class PrecedingAxis extends TreeScanner
{
  public static PrecedingAxis make(NodePredicate paramNodePredicate)
  {
    PrecedingAxis localPrecedingAxis = new PrecedingAxis();
    localPrecedingAxis.type = paramNodePredicate;
    return localPrecedingAxis;
  }

  private static void scan(AbstractSequence paramAbstractSequence, int paramInt1, int paramInt2, NodePredicate paramNodePredicate, PositionConsumer paramPositionConsumer)
  {
    int i = paramAbstractSequence.parentPos(paramInt1);
    if (i == paramInt2);
    int j;
    do
    {
      return;
      scan(paramAbstractSequence, i, paramInt2, paramNodePredicate, paramPositionConsumer);
      j = paramAbstractSequence.firstChildPos(i);
    }
    while (j == 0);
    if (paramNodePredicate.isInstancePos(paramAbstractSequence, j))
      paramPositionConsumer.writePosition(paramAbstractSequence, j);
    while (true)
    {
      j = paramAbstractSequence.nextMatching(j, paramNodePredicate, paramInt1, true);
      if (j == 0)
        break;
      paramPositionConsumer.writePosition(paramAbstractSequence, j);
    }
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    scan(paramAbstractSequence, paramInt, paramAbstractSequence.endPos(), this.type, paramPositionConsumer);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.PrecedingAxis
 * JD-Core Version:    0.6.2
 */