package gnu.xml;

import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.mapping.Symbol;

public class NamedChildrenFilter extends FilterConsumer
{
  int level;
  String localName;
  int matchLevel;
  String namespaceURI;

  public NamedChildrenFilter(String paramString1, String paramString2, Consumer paramConsumer)
  {
    super(paramConsumer);
    this.namespaceURI = paramString1;
    this.localName = paramString2;
    this.skipping = true;
  }

  public static NamedChildrenFilter make(String paramString1, String paramString2, Consumer paramConsumer)
  {
    return new NamedChildrenFilter(paramString1, paramString2, paramConsumer);
  }

  public void endDocument()
  {
    this.level -= 1;
    super.endDocument();
  }

  public void endElement()
  {
    this.level -= 1;
    super.endElement();
    if ((!this.skipping) && (this.matchLevel == this.level))
      this.skipping = true;
  }

  public void startDocument()
  {
    this.level = (1 + this.level);
    super.startDocument();
  }

  public void startElement(Object paramObject)
  {
    Symbol localSymbol;
    String str1;
    if ((this.skipping) && (this.level == 1))
    {
      if (!(paramObject instanceof Symbol))
        break label99;
      localSymbol = (Symbol)paramObject;
      str1 = localSymbol.getNamespaceURI();
    }
    for (String str2 = localSymbol.getLocalName(); ; str2 = paramObject.toString().intern())
    {
      if (((this.localName == str2) || (this.localName == null)) && ((this.namespaceURI == str1) || (this.namespaceURI == null)))
      {
        this.skipping = false;
        this.matchLevel = this.level;
      }
      super.startElement(paramObject);
      this.level = (1 + this.level);
      return;
      label99: str1 = "";
    }
  }

  public void writeObject(Object paramObject)
  {
    if ((paramObject instanceof SeqPosition))
    {
      SeqPosition localSeqPosition = (SeqPosition)paramObject;
      if ((localSeqPosition.sequence instanceof TreeList))
      {
        ((TreeList)localSeqPosition.sequence).consumeNext(localSeqPosition.ipos, this);
        return;
      }
    }
    if ((paramObject instanceof Consumable))
    {
      ((Consumable)paramObject).consume(this);
      return;
    }
    super.writeObject(paramObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.xml.NamedChildrenFilter
 * JD-Core Version:    0.6.2
 */