package gnu.text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class ResourceStreamHandler extends URLStreamHandler
{
  public static final String CLASS_RESOURCE_URI_PREFIX = "class-resource:/";
  public static final int CLASS_RESOURCE_URI_PREFIX_LENGTH = 16;
  ClassLoader cloader;

  public ResourceStreamHandler(ClassLoader paramClassLoader)
  {
    this.cloader = paramClassLoader;
  }

  public static URL makeURL(Class paramClass)
    throws MalformedURLException
  {
    String str = paramClass.getName();
    int i = str.lastIndexOf('.');
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class-resource:/");
    if (i >= 0)
    {
      localStringBuilder.append(str.substring(0, i));
      localStringBuilder.append('/');
      str = str.substring(i + 1);
    }
    localStringBuilder.append(str);
    return new URL(null, localStringBuilder.toString(), new ResourceStreamHandler(paramClass.getClassLoader()));
  }

  public URLConnection openConnection(URL paramURL)
    throws IOException
  {
    String str1 = paramURL.toString();
    String str2 = str1.substring(16);
    int i = str2.indexOf('/');
    if (i > 0)
      str2 = str2.substring(0, i).replace('.', '/') + str2.substring(i);
    URL localURL = this.cloader.getResource(str2);
    if (localURL == null)
      throw new FileNotFoundException(str1);
    return localURL.openConnection();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.ResourceStreamHandler
 * JD-Core Version:    0.6.2
 */