package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.TreeList;

public class DescendantAxis extends TreeScanner
{
  public static DescendantAxis make(NodePredicate paramNodePredicate)
  {
    DescendantAxis localDescendantAxis = new DescendantAxis();
    localDescendantAxis.type = paramNodePredicate;
    return localDescendantAxis;
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    if (!(paramAbstractSequence instanceof TreeList))
      for (int k = paramAbstractSequence.firstChildPos(paramInt); k != 0; k = paramAbstractSequence.nextPos(k))
      {
        if (this.type.isInstancePos(paramAbstractSequence, k))
          paramPositionConsumer.writePosition(paramAbstractSequence, k);
        scan(paramAbstractSequence, k, paramPositionConsumer);
      }
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
 * Qualified Name:     gnu.kawa.xml.DescendantAxis
 * JD-Core Version:    0.6.2
 */