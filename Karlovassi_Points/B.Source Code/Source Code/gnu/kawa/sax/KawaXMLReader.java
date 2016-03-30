package gnu.kawa.sax;

import gnu.text.LineBufferedReader;
import gnu.text.SourceMessages;
import gnu.xml.XMLFilter;
import gnu.xml.XMLParser;
import java.io.IOException;
import java.io.Reader;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class KawaXMLReader extends ContentConsumer
  implements XMLReader
{
  ErrorHandler errorHandler;

  public DTDHandler getDTDHandler()
  {
    return null;
  }

  public EntityResolver getEntityResolver()
  {
    return null;
  }

  public ErrorHandler getErrorHandler()
  {
    return this.errorHandler;
  }

  public boolean getFeature(String paramString)
  {
    return false;
  }

  public Object getProperty(String paramString)
  {
    return null;
  }

  public void parse(String paramString)
  {
  }

  public void parse(InputSource paramInputSource)
    throws IOException, SAXException
  {
    Object localObject = paramInputSource.getCharacterStream();
    if (localObject == null)
      localObject = XMLParser.XMLStreamReader(paramInputSource.getByteStream());
    SourceMessages localSourceMessages = new SourceMessages();
    XMLFilter localXMLFilter = new XMLFilter(this);
    LineBufferedReader localLineBufferedReader = new LineBufferedReader((Reader)localObject);
    localXMLFilter.setSourceLocator(localLineBufferedReader);
    getContentHandler().setDocumentLocator(localXMLFilter);
    XMLParser.parse(localLineBufferedReader, localSourceMessages, localXMLFilter);
    String str = localSourceMessages.toString(20);
    if (str != null)
      throw new SAXParseException(str, localXMLFilter);
  }

  public void setDTDHandler(DTDHandler paramDTDHandler)
  {
  }

  public void setEntityResolver(EntityResolver paramEntityResolver)
  {
  }

  public void setErrorHandler(ErrorHandler paramErrorHandler)
  {
    this.errorHandler = paramErrorHandler;
  }

  public void setFeature(String paramString, boolean paramBoolean)
  {
  }

  public void setProperty(String paramString, Object paramObject)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.sax.KawaXMLReader
 * JD-Core Version:    0.6.2
 */