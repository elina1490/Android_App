package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class ChildAxis extends TreeScanner
{
  public static ChildAxis make(NodePredicate paramNodePredicate)
  {
    ChildAxis localChildAxis = new ChildAxis();
    localChildAxis.type = paramNodePredicate;
    return localChildAxis;
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    for (int i = paramAbstractSequence.firstChildPos(paramInt, this.type); i != 0; i = paramAbstractSequence.nextMatching(i, this.type, -1, false))
      paramPositionConsumer.writePosition(paramAbstractSequence, i);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.ChildAxis
 * JD-Core Version:    0.6.2
 */