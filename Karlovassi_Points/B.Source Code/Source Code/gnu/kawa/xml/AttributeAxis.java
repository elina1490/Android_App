package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class AttributeAxis extends TreeScanner
{
  public static AttributeAxis make(NodePredicate paramNodePredicate)
  {
    AttributeAxis localAttributeAxis = new AttributeAxis();
    localAttributeAxis.type = paramNodePredicate;
    return localAttributeAxis;
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    int i = paramAbstractSequence.firstAttributePos(paramInt);
    if ((i != 0) && (paramAbstractSequence.getNextKind(i) == 35))
    {
      if (this.type.isInstancePos(paramAbstractSequence, i))
        paramPositionConsumer.writePosition(paramAbstractSequence, i);
      while (paramAbstractSequence.getNextKind(i) == 35)
      {
        i = paramAbstractSequence.nextPos(i);
        break;
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.AttributeAxis
 * JD-Core Version:    0.6.2
 */