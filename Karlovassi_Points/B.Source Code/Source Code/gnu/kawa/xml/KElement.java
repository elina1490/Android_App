package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.xml.NodeTree;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

public class KElement extends KNode
  implements Element
{
  public KElement(NodeTree paramNodeTree, int paramInt)
  {
    super(paramNodeTree, paramInt);
  }

  public String getAttribute(String paramString)
  {
    if (paramString == null)
      paramString = "";
    NodeTree localNodeTree = (NodeTree)this.sequence;
    int i = localNodeTree.getAttribute(this.ipos, null, paramString);
    if (i == 0)
      return "";
    return KNode.getNodeValue(localNodeTree, i);
  }

  public String getAttributeNS(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      paramString1 = "";
    if (paramString2 == null)
      paramString2 = "";
    NodeTree localNodeTree = (NodeTree)this.sequence;
    int i = localNodeTree.getAttribute(this.ipos, paramString1, paramString2);
    if (i == 0)
      return "";
    return getNodeValue(localNodeTree, i);
  }

  public KAttr getAttributeNode(String paramString)
  {
    if (paramString == null)
      paramString = "";
    NodeTree localNodeTree = (NodeTree)this.sequence;
    int i = localNodeTree.getAttribute(this.ipos, null, paramString);
    if (i == 0)
      return null;
    return new KAttr(localNodeTree, i);
  }

  public KAttr getAttributeNodeNS(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      paramString1 = "";
    if (paramString2 == null)
      paramString2 = "";
    NodeTree localNodeTree = (NodeTree)this.sequence;
    int i = localNodeTree.getAttribute(this.ipos, paramString1, paramString2);
    if (i == 0)
      return null;
    return new KAttr(localNodeTree, i);
  }

  public NodeList getElementsByTagNameNS(String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException("getElementsByTagNameNS not implemented yet");
  }

  public short getNodeType()
  {
    return 1;
  }

  public String getNodeValue()
  {
    return null;
  }

  public TypeInfo getSchemaTypeInfo()
  {
    return null;
  }

  public String getTagName()
  {
    return this.sequence.getNextTypeName(this.ipos);
  }

  public boolean hasAttribute(String paramString)
  {
    NodeTree localNodeTree = (NodeTree)this.sequence;
    int i = this.ipos;
    if (paramString == null);
    for (String str = ""; localNodeTree.getAttribute(i, null, str) != 0; str = paramString)
      return true;
    return false;
  }

  public boolean hasAttributeNS(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      paramString1 = "";
    if (paramString2 == null)
      paramString2 = "";
    return ((NodeTree)this.sequence).getAttribute(this.ipos, paramString1, paramString2) != 0;
  }

  public boolean hasAttributes()
  {
    return ((NodeTree)this.sequence).posHasAttributes(this.ipos);
  }

  public void removeAttribute(String paramString)
    throws DOMException
  {
    throw new DOMException((short)7, "removeAttribute not supported");
  }

  public void removeAttributeNS(String paramString1, String paramString2)
    throws DOMException
  {
    throw new DOMException((short)7, "removeAttributeNS not supported");
  }

  public Attr removeAttributeNode(Attr paramAttr)
    throws DOMException
  {
    throw new DOMException((short)7, "removeAttributeNode not supported");
  }

  public void setAttribute(String paramString1, String paramString2)
    throws DOMException
  {
    throw new DOMException((short)7, "setAttribute not supported");
  }

  public void setAttributeNS(String paramString1, String paramString2, String paramString3)
    throws DOMException
  {
    throw new DOMException((short)7, "setAttributeNS not supported");
  }

  public Attr setAttributeNode(Attr paramAttr)
    throws DOMException
  {
    throw new DOMException((short)7, "setAttributeNode not supported");
  }

  public Attr setAttributeNodeNS(Attr paramAttr)
    throws DOMException
  {
    throw new DOMException((short)7, "setAttributeNodeNS not supported");
  }

  public void setIdAttribute(String paramString, boolean paramBoolean)
    throws DOMException
  {
    throw new DOMException((short)7, "setIdAttribute not supported");
  }

  public void setIdAttributeNS(String paramString1, String paramString2, boolean paramBoolean)
    throws DOMException
  {
    throw new DOMException((short)7, "setIdAttributeNS not supported");
  }

  public void setIdAttributeNode(Attr paramAttr, boolean paramBoolean)
    throws DOMException
  {
    throw new DOMException((short)7, "setIdAttributeNode not supported");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.KElement
 * JD-Core Version:    0.6.2
 */