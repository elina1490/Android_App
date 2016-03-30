package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class AncestorAxis extends TreeScanner
{
  public static AncestorAxis make(NodePredicate paramNodePredicate)
  {
    AncestorAxis localAncestorAxis = new AncestorAxis();
    localAncestorAxis.type = paramNodePredicate;
    return localAncestorAxis;
  }

  private static void scan(AbstractSequence paramAbstractSequence, int paramInt1, int paramInt2, NodePredicate paramNodePredicate, PositionConsumer paramPositionConsumer)
  {
    int i = paramAbstractSequence.parentPos(paramInt1);
    if (i != paramInt2)
    {
      scan(paramAbstractSequence, i, paramInt2, paramNodePredicate, paramPositionConsumer);
      if (paramNodePredicate.isInstancePos(paramAbstractSequence, i))
        paramPositionConsumer.writePosition(paramAbstractSequence, i);
    }
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    scan(paramAbstractSequence, paramInt, paramAbstractSequence.endPos(), this.type, paramPositionConsumer);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.AncestorAxis
 * JD-Core Version:    0.6.2
 */