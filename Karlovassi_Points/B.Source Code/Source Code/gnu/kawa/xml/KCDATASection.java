package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.CDATASection;

public class KCDATASection extends KText
  implements CDATASection
{
  public KCDATASection(NodeTree paramNodeTree, int paramInt)
  {
    super(paramNodeTree, paramInt);
  }

  public String getData()
  {
    return getNodeValue();
  }

  public int getLength()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    NodeTree localNodeTree = (NodeTree)this.sequence;
    localNodeTree.stringValue(localNodeTree.posToDataIndex(this.ipos), localStringBuffer);
    return localStringBuffer.length();
  }

  public String getNodeName()
  {
    return "#cdata-section";
  }

  public short getNodeType()
  {
    return 4;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.KCDATASection
 * JD-Core Version:    0.6.2
 */