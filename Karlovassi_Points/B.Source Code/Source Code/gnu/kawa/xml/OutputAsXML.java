package gnu.kawa.xml;

import gnu.lists.FString;
import gnu.mapping.CharArrayOutPort;
import gnu.mapping.Procedure1;
import gnu.xml.XMLPrinter;

public class OutputAsXML extends Procedure1
{
  public Object apply1(Object paramObject)
  {
    CharArrayOutPort localCharArrayOutPort = new CharArrayOutPort();
    XMLPrinter localXMLPrinter = new XMLPrinter(localCharArrayOutPort);
    localXMLPrinter.writeObject(paramObject);
    localXMLPrinter.flush();
    return new FString(localCharArrayOutPort.toCharArray());
  }

  public int numArgs()
  {
    return 4097;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.OutputAsXML
 * JD-Core Version:    0.6.2
 */