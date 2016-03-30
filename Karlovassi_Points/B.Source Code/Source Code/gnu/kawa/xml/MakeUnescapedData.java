package gnu.kawa.xml;

import gnu.lists.UnescapedData;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;

public class MakeUnescapedData extends Procedure1
{
  public static final MakeUnescapedData unescapedData = new MakeUnescapedData();

  public MakeUnescapedData()
  {
    setProperty(Procedure.validateApplyKey, "gnu.kawa.xml.CompileXmlFunctions:validateApplyMakeUnescapedData");
  }

  public Object apply1(Object paramObject)
  {
    if (paramObject == null);
    for (String str = ""; ; str = paramObject.toString())
      return new UnescapedData(str);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.MakeUnescapedData
 * JD-Core Version:    0.6.2
 */