package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.TreeList;

public class DescendantOrSelfAxis extends TreeScanner
{
  public static final DescendantOrSelfAxis anyNode = new DescendantOrSelfAxis(NodeType.anyNodeTest);

  private DescendantOrSelfAxis(NodePredicate paramNodePredicate)
  {
    this.type = paramNodePredicate;
  }

  public static DescendantOrSelfAxis make(NodePredicate paramNodePredicate)
  {
    if (paramNodePredicate == NodeType.anyNodeTest)
      return anyNode;
    return new DescendantOrSelfAxis(paramNodePredicate);
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    if (this.type.isInstancePos(paramAbstractSequence, paramInt))
      paramPositionConsumer.writePosition(paramAbstractSequence, paramInt);
    if (!(paramAbstractSequence instanceof TreeList))
      for (int k = paramAbstractSequence.firstChildPos(paramInt); k != 0; k = paramAbstractSequence.nextPos(k))
        scan(paramAbstractSequence, k, paramPositionConsumer);
    int i = paramAbstractSequence.nextPos(paramInt);
    int j = paramInt;
    while (true)
    {
      j = paramAbstractSequence.nextMatching(j, this.type, i, true);
      if (j == 0)
        return;
      paramPositionConsumer.writePosition(paramAbstractSequence, j);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.DescendantOrSelfAxis
 * JD-Core Version:    0.6.2
 */