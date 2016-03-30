package gnu.text;

import gnu.mapping.WrappedException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class URLPath extends URIPath
{
  final URL url;

  URLPath(URL paramURL)
  {
    super(toUri(paramURL));
    this.url = paramURL;
  }

  public static URLPath classResourcePath(Class paramClass)
  {
    try
    {
      URL localURL2 = ResourceStreamHandler.makeURL(paramClass);
      localObject = localURL2;
      return valueOf((URL)localObject);
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
      {
        String str = paramClass.getName().replace('.', '/') + ".class";
        URL localURL1 = paramClass.getClassLoader().getResource(str);
        Object localObject = localURL1;
      }
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }

  public static int getContentLength(URL paramURL)
  {
    try
    {
      int i = paramURL.openConnection().getContentLength();
      return i;
    }
    catch (Throwable localThrowable)
    {
    }
    return -1;
  }

  public static long getLastModified(URL paramURL)
  {
    try
    {
      long l = paramURL.openConnection().getLastModified();
      return l;
    }
    catch (Throwable localThrowable)
    {
    }
    return 0L;
  }

  public static InputStream openInputStream(URL paramURL)
    throws IOException
  {
    return paramURL.openConnection().getInputStream();
  }

  public static OutputStream openOutputStream(URL paramURL)
    throws IOException
  {
    String str = paramURL.toString();
    if (str.startsWith("file:"))
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(new File(new URI(str)));
        return localFileOutputStream;
      }
      catch (Throwable localThrowable)
      {
      }
    URLConnection localURLConnection = paramURL.openConnection();
    localURLConnection.setDoInput(false);
    localURLConnection.setDoOutput(true);
    return localURLConnection.getOutputStream();
  }

  public static URI toUri(URL paramURL)
  {
    try
    {
      URI localURI = paramURL.toURI();
      return localURI;
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }

  public static URLPath valueOf(URL paramURL)
  {
    return new URLPath(paramURL);
  }

  public long getContentLength()
  {
    return getContentLength(this.url);
  }

  public long getLastModified()
  {
    return getLastModified(this.url);
  }

  public boolean isAbsolute()
  {
    return true;
  }

  public InputStream openInputStream()
    throws IOException
  {
    return openInputStream(this.url);
  }

  public OutputStream openOutputStream()
    throws IOException
  {
    return openOutputStream(this.url);
  }

  public Path resolve(String paramString)
  {
    try
    {
      URLPath localURLPath = valueOf(new URL(this.url, paramString));
      return localURLPath;
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }

  public String toURIString()
  {
    return this.url.toString();
  }

  public URL toURL()
  {
    return this.url;
  }

  public URI toUri()
  {
    return toUri(this.url);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.URLPath
 * JD-Core Version:    0.6.2
 */