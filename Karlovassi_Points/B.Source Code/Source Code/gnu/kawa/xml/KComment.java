package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.Comment;

public class KComment extends KCharacterData
  implements Comment
{
  public KComment(NodeTree paramNodeTree, int paramInt)
  {
    super(paramNodeTree, paramInt);
  }

  public static KComment valueOf(String paramString)
  {
    NodeTree localNodeTree = new NodeTree();
    localNodeTree.writeComment(paramString, 0, paramString.length());
    return new KComment(localNodeTree, 0);
  }

  public String getNodeName()
  {
    return "#comment";
  }

  public short getNodeType()
  {
    return 8;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.KComment
 * JD-Core Version:    0.6.2
 */