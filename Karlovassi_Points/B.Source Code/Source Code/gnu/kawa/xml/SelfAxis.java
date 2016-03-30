package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;

public class SelfAxis extends TreeScanner
{
  public static SelfAxis make(NodePredicate paramNodePredicate)
  {
    SelfAxis localSelfAxis = new SelfAxis();
    localSelfAxis.type = paramNodePredicate;
    return localSelfAxis;
  }

  public void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer)
  {
    if (this.type.isInstancePos(paramAbstractSequence, paramInt))
      paramPositionConsumer.writePosition(paramAbstractSequence, paramInt);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.SelfAxis
 * JD-Core Version:    0.6.2
 */