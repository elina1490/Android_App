package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class PrecedingSiblingAxis extends TreeScanner
{
  public static PrecedingSiblingAxis make(NodePredicate paramNodePredicate)
  {
    PrecedingSiblingAxis localPrecedingSiblingAxis = new PrecedingSiblingAxis();
    localPrecedingSiblingAxis.type = paramNodePredicate;
    return localPrecedingSiblingAxis;
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    int i = paramAbstractSequence.endPos();
    int j = paramAbstractSequence.parentPos(paramInt);
    if (j == i);
    int k;
    do
    {
      return;
      k = paramAbstractSequence.firstChildPos(j);
    }
    while (k == 0);
    if (this.type.isInstancePos(paramAbstractSequence, k))
      paramPositionConsumer.writePosition(paramAbstractSequence, k);
    while (true)
    {
      k = paramAbstractSequence.nextMatching(k, this.type, paramInt, false);
      if (k == 0)
        break;
      paramPositionConsumer.writePosition(paramAbstractSequence, k);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.PrecedingSiblingAxis
 * JD-Core Version:    0.6.2
 */