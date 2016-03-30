package gnu.kawa.sax;

import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.SeqPosition;
import gnu.mapping.Symbol;
import gnu.text.Char;
import gnu.xml.XName;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class ContentConsumer
  implements Consumer
{
  String attrLocalName;
  String attrQName;
  String attrURI;
  AttributesImpl attributes = new AttributesImpl();
  char[] chBuffer;
  int inStartTag;
  String[] names = new String[15];
  int nesting = 0;
  ContentHandler out;
  StringBuilder strBuffer = new StringBuilder(200);

  public ContentConsumer()
  {
  }

  public ContentConsumer(ContentHandler paramContentHandler)
  {
    this.out = paramContentHandler;
  }

  public ContentConsumer append(char paramChar)
  {
    write(paramChar);
    return this;
  }

  public ContentConsumer append(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    write(paramCharSequence, 0, paramCharSequence.length());
    return this;
  }

  public ContentConsumer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null)
      paramCharSequence = "null";
    write(paramCharSequence, paramInt1, paramInt2);
    return this;
  }

  public void endAttribute()
  {
    this.attributes.addAttribute(this.attrURI, this.attrLocalName, this.attrQName, "CDATA", this.strBuffer.toString());
    this.strBuffer.setLength(0);
    this.inStartTag = 1;
  }

  public void endDocument()
  {
    try
    {
      this.out.endDocument();
      return;
    }
    catch (SAXException localSAXException)
    {
      error("endDocument", localSAXException);
    }
  }

  public void endElement()
  {
    endStartTag();
    flushStrBuffer();
    this.nesting -= 1;
    int i = 3 * this.nesting;
    try
    {
      this.out.endElement(this.names[i], this.names[(i + 1)], this.names[(i + 2)]);
      this.names[i] = null;
      this.names[(i + 1)] = null;
      this.names[(i + 2)] = null;
      return;
    }
    catch (SAXException localSAXException)
    {
      while (true)
        error("endElement", localSAXException);
    }
  }

  public void endStartTag()
  {
    if (this.inStartTag != 1)
      return;
    int i = 3 * (this.nesting - 1);
    try
    {
      this.out.startElement(this.names[i], this.names[(i + 1)], this.names[(i + 2)], this.attributes);
      this.attributes.clear();
      this.inStartTag = 0;
      return;
    }
    catch (SAXException localSAXException)
    {
      while (true)
        error("startElement", localSAXException);
    }
  }

  public void error(String paramString, SAXException paramSAXException)
  {
    throw new RuntimeException("caught " + paramSAXException + " in " + paramString);
  }

  public void finalize()
  {
    flushStrBuffer();
  }

  void flushStrBuffer()
  {
    if (this.strBuffer.length() > 0)
    {
      if (this.chBuffer == null)
        this.chBuffer = new char['È'];
      try
      {
        int i = this.strBuffer.length();
        int j = 0;
        while (true)
        {
          int k = i - j;
          if (k <= 0)
          {
            this.strBuffer.setLength(0);
            return;
          }
          if (k > this.chBuffer.length)
            k = this.chBuffer.length;
          this.strBuffer.getChars(j, j + k, this.chBuffer, j);
          this.out.characters(this.chBuffer, 0, k);
          j += k;
        }
      }
      catch (SAXException localSAXException)
      {
        error("characters", localSAXException);
      }
    }
  }

  public ContentHandler getContentHandler()
  {
    return this.out;
  }

  public boolean ignoring()
  {
    return false;
  }

  public void setContentHandler(ContentHandler paramContentHandler)
  {
    this.out = paramContentHandler;
  }

  public void startAttribute(Object paramObject)
  {
    this.attrURI = ((Symbol)paramObject).getNamespaceURI();
    this.attrLocalName = ((Symbol)paramObject).getLocalName();
    this.attrQName = paramObject.toString();
    this.inStartTag = 2;
  }

  public void startDocument()
  {
    try
    {
      this.out.startDocument();
      return;
    }
    catch (SAXException localSAXException)
    {
      error("startDocument", localSAXException);
    }
  }

  public void startElement(Object paramObject)
  {
    if (this.inStartTag == 1)
      endStartTag();
    flushStrBuffer();
    int i = 3 * this.nesting;
    if (i >= this.names.length)
    {
      String[] arrayOfString = new String[i * 2];
      System.arraycopy(this.names, 0, arrayOfString, 0, i);
      this.names = arrayOfString;
    }
    String str1;
    String str2;
    if ((paramObject instanceof Symbol))
    {
      Symbol localSymbol = (Symbol)paramObject;
      str1 = localSymbol.getNamespaceURI();
      str2 = localSymbol.getLocalName();
    }
    while (true)
    {
      this.names[i] = str1;
      this.names[(i + 1)] = str2;
      this.names[(i + 2)] = paramObject.toString();
      this.inStartTag = 1;
      this.nesting = (1 + this.nesting);
      return;
      if ((paramObject instanceof XName))
      {
        XName localXName = (XName)paramObject;
        str1 = localXName.getNamespaceURI();
        str2 = localXName.getLocalName();
      }
      else
      {
        str1 = "";
        str2 = paramObject.toString();
      }
    }
  }

  public void write(int paramInt)
  {
    if (this.inStartTag == 1)
      endStartTag();
    if (paramInt >= 65536)
    {
      this.strBuffer.append((char)(55296 + (paramInt - 65536 >> 10)));
      paramInt = 56320 + (paramInt & 0x3FF);
    }
    this.strBuffer.append((char)paramInt);
  }

  public void write(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (this.inStartTag == 1)
      endStartTag();
    this.strBuffer.append(paramCharSequence, paramInt1, paramInt2);
  }

  public void write(String paramString)
  {
    if (this.inStartTag == 1)
      endStartTag();
    this.strBuffer.append(paramString);
  }

  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.inStartTag == 1)
      endStartTag();
    if (this.inStartTag == 2)
    {
      this.strBuffer.append(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    flushStrBuffer();
    try
    {
      this.out.characters(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    catch (SAXException localSAXException)
    {
      error("characters", localSAXException);
    }
  }

  public void writeBoolean(boolean paramBoolean)
  {
    if (this.inStartTag == 1)
      endStartTag();
    this.strBuffer.append(paramBoolean);
  }

  public void writeDouble(double paramDouble)
  {
    if (this.inStartTag == 1)
      endStartTag();
    this.strBuffer.append(paramDouble);
  }

  public void writeFloat(float paramFloat)
  {
    if (this.inStartTag == 1)
      endStartTag();
    this.strBuffer.append(paramFloat);
  }

  public void writeInt(int paramInt)
  {
    if (this.inStartTag == 1)
      endStartTag();
    this.strBuffer.append(paramInt);
  }

  public void writeLong(long paramLong)
  {
    if (this.inStartTag == 1)
      endStartTag();
    this.strBuffer.append(paramLong);
  }

  public void writeObject(Object paramObject)
  {
    if ((paramObject instanceof Consumable))
    {
      ((Consumable)paramObject).consume(this);
      return;
    }
    if ((paramObject instanceof SeqPosition))
    {
      SeqPosition localSeqPosition = (SeqPosition)paramObject;
      localSeqPosition.sequence.consumeNext(localSeqPosition.ipos, this);
      return;
    }
    if ((paramObject instanceof Char))
    {
      ((Char)paramObject).print(this);
      return;
    }
    if (paramObject == null);
    for (String str = "(null)"; ; str = paramObject.toString())
    {
      write(str);
      return;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.sax.ContentConsumer
 * JD-Core Version:    0.6.2
 */