package gnu.kawa.xml;

import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import gnu.xml.TextUtils;
import gnu.xml.XMLFilter;

public class MakeCDATA extends MethodProc
{
  public static final MakeCDATA makeCDATA = new MakeCDATA();

  public void apply(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    XMLFilter localXMLFilter = NodeConstructor.pushNodeContext(paramCallContext);
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      String str = Location.UNBOUND;
      while (true)
      {
        Object localObject2 = paramCallContext.getNextArg(str);
        if (localObject2 == str)
        {
          int i = localStringBuffer.length();
          char[] arrayOfChar = new char[i];
          localStringBuffer.getChars(0, i, arrayOfChar, 0);
          localXMLFilter.writeCDATA(arrayOfChar, 0, i);
          return;
        }
        TextUtils.stringValue(localObject2, localStringBuffer);
      }
    }
    finally
    {
      NodeConstructor.popNodeContext(localConsumer, paramCallContext);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.MakeCDATA
 * JD-Core Version:    0.6.2
 */