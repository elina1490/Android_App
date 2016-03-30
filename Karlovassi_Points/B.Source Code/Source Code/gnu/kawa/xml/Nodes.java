package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.SeqPosition;
import gnu.lists.Sequence;
import gnu.lists.TreeList;
import gnu.mapping.Values;
import gnu.xml.NodeTree;
import gnu.xml.XMLFilter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Nodes extends Values
  implements NodeList
{
  static final int POS_SIZE = 5;
  int count;
  XMLFilter curFragment;
  NodeTree curNode;
  boolean inAttribute;
  int nesting = 0;

  private void maybeEndNonTextNode()
  {
    int i = this.nesting - 1;
    this.nesting = i;
    if (i == 0)
      finishFragment();
  }

  private void maybeStartNonTextNode()
  {
    if ((this.curFragment != null) && (this.nesting == 0))
      finishFragment();
    if (this.curFragment == null)
      startFragment();
    this.nesting = (1 + this.nesting);
  }

  public static KNode root(NodeTree paramNodeTree, int paramInt)
  {
    if ((paramNodeTree.gapStart > 5) && (paramNodeTree.data[0] == 61714));
    for (int i = 10; ; i = 0)
      return KNode.make(paramNodeTree, i);
  }

  public Consumer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    maybeStartTextNode();
    this.curFragment.write(paramCharSequence, paramInt1, paramInt2);
    return this;
  }

  public void beginEntity(Object paramObject)
  {
    maybeStartNonTextNode();
    this.curFragment.beginEntity(paramObject);
  }

  public void endAttribute()
  {
    if (!this.inAttribute)
      return;
    this.inAttribute = false;
    this.curFragment.endAttribute();
    maybeEndNonTextNode();
  }

  public void endDocument()
  {
    this.curFragment.endDocument();
    maybeEndNonTextNode();
  }

  public void endElement()
  {
    this.curFragment.endElement();
    maybeEndNonTextNode();
  }

  public void endEntity()
  {
    this.curFragment.endEntity();
    maybeEndNonTextNode();
  }

  public int find(Object paramObject)
  {
    if (this.gapStart > 0)
    {
      int j = getIntN(1 + (this.gapStart - 5));
      if (this.objects[j] == paramObject)
        return j;
    }
    if (this.gapEnd < this.data.length)
    {
      int i = getIntN(1 + this.gapEnd);
      if (this.objects[i] == paramObject)
        return i;
    }
    return super.find(paramObject);
  }

  void finishFragment()
  {
    this.curNode = null;
    this.curFragment = null;
  }

  public Object get(int paramInt)
  {
    int i = paramInt * 5;
    if (i >= this.gapStart)
      i += this.gapEnd - this.gapStart;
    if ((i < 0) || (i >= this.data.length))
      throw new IndexOutOfBoundsException();
    if (this.data[i] != 61711)
      throw new RuntimeException("internal error - unexpected data");
    return KNode.make((NodeTree)this.objects[getIntN(i + 1)], getIntN(i + 3));
  }

  public int getLength()
  {
    return this.count;
  }

  public int getPos(int paramInt)
  {
    int i = paramInt * 5;
    if (i >= this.gapStart)
      i += this.gapEnd - this.gapStart;
    if (this.data[i] != 61711)
      throw new RuntimeException("internal error - unexpected data");
    return getIntN(i + 3);
  }

  public Object getPosNext(int paramInt)
  {
    int i = posToDataIndex(paramInt);
    if (i == this.data.length)
      return Sequence.eofValue;
    if (this.data[i] != 61711)
      throw new RuntimeException("internal error - unexpected data");
    return KNode.make((NodeTree)this.objects[getIntN(i + 1)], getIntN(i + 3));
  }

  public AbstractSequence getSeq(int paramInt)
  {
    int i = paramInt * 5;
    if (i >= this.gapStart)
      i += this.gapEnd - this.gapStart;
    if ((i < 0) || (i >= this.data.length))
      return null;
    if (this.data[i] != 61711)
      throw new RuntimeException("internal error - unexpected data");
    return (AbstractSequence)this.objects[getIntN(i + 1)];
  }

  void handleNonNode()
  {
    if (this.curFragment == null)
      throw new ClassCastException("atomic value where node is required");
  }

  public Node item(int paramInt)
  {
    if (paramInt >= this.count)
      return null;
    return (Node)get(paramInt);
  }

  void maybeStartTextNode()
  {
    if (this.curFragment == null)
      throw new IllegalArgumentException("non-node where node required");
  }

  public int size()
  {
    return this.count;
  }

  public void startAttribute(Object paramObject)
  {
    maybeStartNonTextNode();
    this.curFragment.startAttribute(paramObject);
    this.inAttribute = true;
  }

  public void startDocument()
  {
    maybeStartNonTextNode();
    this.curFragment.startDocument();
  }

  public void startElement(Object paramObject)
  {
    maybeStartNonTextNode();
    this.curFragment.startElement(paramObject);
  }

  void startFragment()
  {
    this.curNode = new NodeTree();
    this.curFragment = new XMLFilter(this.curNode);
    writePosition(this.curNode, 0);
  }

  public void write(int paramInt)
  {
    maybeStartTextNode();
    this.curFragment.write(paramInt);
  }

  public void write(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    maybeStartTextNode();
    this.curFragment.write(paramCharSequence, paramInt1, paramInt2);
  }

  public void write(String paramString)
  {
    maybeStartTextNode();
    this.curFragment.write(paramString);
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    maybeStartTextNode();
    this.curFragment.write(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void writeBoolean(boolean paramBoolean)
  {
    handleNonNode();
    this.curFragment.writeBoolean(paramBoolean);
  }

  public void writeCDATA(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    maybeStartNonTextNode();
    this.curFragment.writeCDATA(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void writeComment(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    maybeStartNonTextNode();
    this.curFragment.writeComment(paramArrayOfChar, paramInt1, paramInt2);
    maybeEndNonTextNode();
  }

  public void writeDouble(double paramDouble)
  {
    handleNonNode();
    this.curFragment.writeDouble(paramDouble);
  }

  public void writeFloat(float paramFloat)
  {
    handleNonNode();
    this.curFragment.writeFloat(paramFloat);
  }

  public void writeInt(int paramInt)
  {
    handleNonNode();
    this.curFragment.writeInt(paramInt);
  }

  public void writeLong(long paramLong)
  {
    handleNonNode();
    this.curFragment.writeLong(paramLong);
  }

  public void writeObject(Object paramObject)
  {
    if (this.curFragment != null)
    {
      if ((this.nesting == 0) && (((paramObject instanceof SeqPosition)) || ((paramObject instanceof TreeList))))
        finishFragment();
    }
    else
    {
      if (!(paramObject instanceof SeqPosition))
        break label66;
      SeqPosition localSeqPosition = (SeqPosition)paramObject;
      writePosition(localSeqPosition.sequence, localSeqPosition.ipos);
      return;
    }
    this.curFragment.writeObject(paramObject);
    return;
    label66: if ((paramObject instanceof TreeList))
    {
      writePosition((TreeList)paramObject, 0);
      return;
    }
    handleNonNode();
    this.curFragment.writeObject(paramObject);
  }

  public void writePosition(AbstractSequence paramAbstractSequence, int paramInt)
  {
    this.count = (1 + this.count);
    super.writePosition(paramAbstractSequence, paramInt);
  }

  public void writeProcessingInstruction(String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    maybeStartNonTextNode();
    this.curFragment.writeProcessingInstruction(paramString, paramArrayOfChar, paramInt1, paramInt2);
    maybeEndNonTextNode();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.Nodes
 * JD-Core Version:    0.6.2
 */