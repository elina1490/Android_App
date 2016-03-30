package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class ParentAxis extends TreeScanner
{
  public static ParentAxis make(NodePredicate paramNodePredicate)
  {
    ParentAxis localParentAxis = new ParentAxis();
    localParentAxis.type = paramNodePredicate;
    return localParentAxis;
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    int i = paramAbstractSequence.parentPos(paramInt);
    if ((i != paramAbstractSequence.endPos()) && (this.type.isInstancePos(paramAbstractSequence, i)))
      paramPositionConsumer.writePosition(paramAbstractSequence, i);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.ParentAxis
 * JD-Core Version:    0.6.2
 */