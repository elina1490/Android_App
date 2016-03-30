package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class FollowingAxis extends TreeScanner
{
  public static FollowingAxis make(NodePredicate paramNodePredicate)
  {
    FollowingAxis localFollowingAxis = new FollowingAxis();
    localFollowingAxis.type = paramNodePredicate;
    return localFollowingAxis;
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    int i = paramAbstractSequence.endPos();
    int j = paramAbstractSequence.nextPos(paramInt);
    if ((j != 0) && (this.type.isInstancePos(paramAbstractSequence, j)))
      paramPositionConsumer.writePosition(paramAbstractSequence, j);
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
 * Qualified Name:     gnu.kawa.xml.FollowingAxis
 * JD-Core Version:    0.6.2
 */