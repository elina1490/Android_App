package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.xml.NodeTree;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

public class KAttr extends KNode
  implements Attr
{
  public KAttr(NodeTree paramNodeTree, int paramInt)
  {
    super(paramNodeTree, paramInt);
  }

  public static Object getObjectValue(NodeTree paramNodeTree, int paramInt)
  {
    return paramNodeTree.getPosNext(paramInt + 10);
  }

  public String getName()
  {
    return this.sequence.getNextTypeName(this.ipos);
  }

  public short getNodeType()
  {
    return 2;
  }

  public Object getObjectValue()
  {
    return getObjectValue((NodeTree)this.sequence, this.ipos);
  }

  public Element getOwnerElement()
  {
    return (Element)super.getParentNode();
  }

  public Node getParentNode()
  {
    return null;
  }

  public TypeInfo getSchemaTypeInfo()
  {
    return null;
  }

  public boolean getSpecified()
  {
    return true;
  }

  public String getValue()
  {
    return getNodeValue();
  }

  public boolean isId()
  {
    return false;
  }

  public void setValue(String paramString)
    throws DOMException
  {
    throw new DOMException((short)7, "setValue not supported");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.KAttr
 * JD-Core Version:    0.6.2
 */