package gnu.xml;

import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class XName extends Symbol
  implements Externalizable
{
  NamespaceBinding namespaceNodes;

  public XName()
  {
  }

  public XName(Symbol paramSymbol, NamespaceBinding paramNamespaceBinding)
  {
    super(paramSymbol.getNamespace(), paramSymbol.getName());
    this.namespaceNodes = paramNamespaceBinding;
  }

  public static int checkName(String paramString)
  {
    int i = paramString.length();
    if (i == 0)
      return -1;
    int j = 2;
    int k = 0;
    if (k < i)
    {
      int m;
      label27: int n;
      int i1;
      if (k == 0)
      {
        m = 1;
        n = k + 1;
        i1 = paramString.charAt(k);
        if ((i1 >= 55296) && (i1 < 56320) && (n < i))
        {
          int i2 = 1024 * (i1 - 55296);
          int i3 = n + 1;
          i1 = 65536 + (i2 + (paramString.charAt(n) - 56320));
          n = i3;
        }
        if (i1 != 58)
          break label123;
        if (j != 2);
      }
      for (j = 1; ; j = 0)
        label123: 
        do
        {
          k = n;
          break;
          m = 0;
          break label27;
          if (!isNamePart(i1))
            return -1;
        }
        while ((m == 0) || (isNameStart(i1)));
    }
    return j;
  }

  public static boolean isNCName(String paramString)
  {
    return checkName(paramString) > 1;
  }

  public static boolean isName(String paramString)
  {
    return checkName(paramString) > 0;
  }

  public static boolean isNamePart(int paramInt)
  {
    return (Character.isUnicodeIdentifierPart(paramInt)) || (paramInt == 45) || (paramInt == 46);
  }

  public static boolean isNameStart(int paramInt)
  {
    return (Character.isUnicodeIdentifierStart(paramInt)) || (paramInt == 95);
  }

  public static boolean isNmToken(String paramString)
  {
    return checkName(paramString) >= 0;
  }

  public final NamespaceBinding getNamespaceNodes()
  {
    return this.namespaceNodes;
  }

  String lookupNamespaceURI(String paramString)
  {
    for (NamespaceBinding localNamespaceBinding = this.namespaceNodes; localNamespaceBinding != null; localNamespaceBinding = localNamespaceBinding.next)
      if (paramString == localNamespaceBinding.prefix)
        return localNamespaceBinding.uri;
    return null;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    super.readExternal(paramObjectInput);
    this.namespaceNodes = ((NamespaceBinding)paramObjectInput.readObject());
  }

  public final void setNamespaceNodes(NamespaceBinding paramNamespaceBinding)
  {
    this.namespaceNodes = paramNamespaceBinding;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeObject(this.namespaceNodes);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.xml.XName
 * JD-Core Version:    0.6.2
 */