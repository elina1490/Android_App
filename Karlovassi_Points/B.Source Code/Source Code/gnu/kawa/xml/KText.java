package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

public class KText extends KCharacterData
  implements Text
{
  public KText(NodeTree paramNodeTree, int paramInt)
  {
    super(paramNodeTree, paramInt);
  }

  public static KText make(String paramString)
  {
    NodeTree localNodeTree = new NodeTree();
    localNodeTree.append(paramString);
    return new KText(localNodeTree, 0);
  }

  public String getNodeName()
  {
    return "#text";
  }

  public short getNodeType()
  {
    return 3;
  }

  public String getWholeText()
  {
    throw new UnsupportedOperationException("getWholeText not implemented yet");
  }

  public boolean hasAttributes()
  {
    return false;
  }

  public boolean isElementContentWhitespace()
  {
    return false;
  }

  public Text replaceWholeText(String paramString)
    throws DOMException
  {
    throw new DOMException((short)7, "splitText not supported");
  }

  public Text splitText(int paramInt)
    throws DOMException
  {
    throw new DOMException((short)7, "splitText not supported");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.KText
 * JD-Core Version:    0.6.2
 */