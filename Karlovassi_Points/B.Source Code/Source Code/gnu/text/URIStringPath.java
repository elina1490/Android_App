package gnu.text;

import java.net.URI;

class URIStringPath extends URIPath
{
  String uriString;

  public URIStringPath(URI paramURI, String paramString)
  {
    super(paramURI);
    this.uriString = paramString;
  }

  public String toURIString()
  {
    return this.uriString;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.URIStringPath
 * JD-Core Version:    0.6.2
 */