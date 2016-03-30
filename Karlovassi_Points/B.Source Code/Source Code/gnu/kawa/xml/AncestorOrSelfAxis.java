package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class AncestorOrSelfAxis extends TreeScanner
{
  public static AncestorOrSelfAxis make(NodePredicate paramNodePredicate)
  {
    AncestorOrSelfAxis localAncestorOrSelfAxis = new AncestorOrSelfAxis();
    localAncestorOrSelfAxis.type = paramNodePredicate;
    return localAncestorOrSelfAxis;
  }

  private static void scan(AbstractSequence paramAbstractSequence, int paramInt1, int paramInt2, NodePredicate paramNodePredicate, PositionConsumer paramPositionConsumer)
  {
    if (paramInt1 != paramInt2)
    {
      scan(paramAbstractSequence, paramAbstractSequence.parentPos(paramInt1), paramInt2, paramNodePredicate, paramPositionConsumer);
      if (paramNodePredicate.isInstancePos(paramAbstractSequence, paramInt1))
        paramPositionConsumer.writePosition(paramAbstractSequence, paramInt1);
    }
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    scan(paramAbstractSequence, paramInt, paramAbstractSequence.endPos(), this.type, paramPositionConsumer);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.AncestorOrSelfAxis
 * JD-Core Version:    0.6.2
 */