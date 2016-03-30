package gnu.text;

import gnu.lists.FString;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class URIPath extends Path
  implements Comparable<URIPath>
{
  final URI uri;

  URIPath(URI paramURI)
  {
    this.uri = paramURI;
  }

  public static URIPath coerceToURIPathOrNull(Object paramObject)
  {
    if ((paramObject instanceof URIPath))
      return (URIPath)paramObject;
    if ((paramObject instanceof URL))
      return URLPath.valueOf((URL)paramObject);
    if ((paramObject instanceof URI))
      return valueOf((URI)paramObject);
    if (((paramObject instanceof File)) || ((paramObject instanceof Path)) || ((paramObject instanceof FString)));
    for (String str = paramObject.toString(); ; str = (String)paramObject)
    {
      return valueOf(str);
      if (!(paramObject instanceof String))
        break;
    }
    return null;
  }

  public static String encodeForUri(String paramString, char paramChar)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramString.length();
    int j = 0;
    int k;
    int m;
    int i11;
    if (j < i)
    {
      k = j + 1;
      m = paramString.charAt(j);
      if ((m < 55296) || (m >= 56320) || (k >= i))
        break label561;
      int i10 = 1024 * (m - 55296);
      i11 = k + 1;
      m = 65536 + (i10 + (paramString.charAt(k) - 56320));
    }
    label403: label412: label561: for (int n = i11; ; n = k)
    {
      if (paramChar == 'H')
      {
        if ((m < 32) || (m > 126));
      }
      else
        while (((m >= 97) && (m <= 122)) || ((m >= 65) && (m <= 90)) || ((m >= 48) && (m <= 57)) || (m == 45) || (m == 95) || (m == 46) || (m == 126) || ((paramChar == 'I') && ((m == 59) || (m == 47) || (m == 63) || (m == 58) || (m == 42) || (m == 39) || (m == 40) || (m == 41) || (m == 64) || (m == 38) || (m == 61) || (m == 43) || (m == 36) || (m == 44) || (m == 91) || (m == 93) || (m == 35) || (m == 33) || (m == 37))))
        {
          localStringBuffer.append((char)m);
          j = n;
          break;
        }
      int i1 = localStringBuffer.length();
      int i2;
      int i3;
      if (m < 128)
      {
        i2 = 0;
        i3 = m;
      }
      while (true)
      {
        int i4;
        label368: int i5;
        int i6;
        int i7;
        int i8;
        if (i2 == 0)
        {
          i4 = 7;
          if (i3 >= 1 << i4)
            break label495;
          i5 = i3;
          if (i2 > 0)
            i5 |= 0xFF & 65408 >> i2;
          i3 = 0;
          i6 = i2 + 1;
          i7 = 0;
          if (i7 > 1)
            break label529;
          i8 = i5 & 0xF;
          if (i8 > 9)
            break label516;
        }
        for (int i9 = i8 + 48; ; i9 = 65 + (i8 - 10))
        {
          localStringBuffer.insert(i1, (char)i9);
          i5 >>= 4;
          i7++;
          break label412;
          if ((m < 2048) || (m < 65536))
            break;
          break;
          i4 = 6 - i2;
          break label368;
          label495: i5 = 0x80 | i3 & 0x3F;
          i3 >>= 6;
          break label403;
        }
        localStringBuffer.insert(i1, '%');
        if (i3 == 0)
        {
          break;
          return localStringBuffer.toString();
        }
        i2 = i6;
      }
    }
  }

  public static URIPath makeURI(Object paramObject)
  {
    URIPath localURIPath = coerceToURIPathOrNull(paramObject);
    if (localURIPath == null)
      throw new WrongType((String)null, -4, paramObject, "URI");
    return localURIPath;
  }

  public static URIPath valueOf(String paramString)
  {
    try
    {
      URIStringPath localURIStringPath = new URIStringPath(new URI(encodeForUri(paramString, 'I')), paramString);
      return localURIStringPath;
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }

  public static URIPath valueOf(URI paramURI)
  {
    return new URIPath(paramURI);
  }

  public int compareTo(URIPath paramURIPath)
  {
    return this.uri.compareTo(paramURIPath.uri);
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof URIPath)) && (this.uri.equals(((URIPath)paramObject).uri));
  }

  public boolean exists()
  {
    try
    {
      URLConnection localURLConnection = toURL().openConnection();
      if ((localURLConnection instanceof HttpURLConnection))
      {
        if (((HttpURLConnection)localURLConnection).getResponseCode() == 200)
          return true;
      }
      else
      {
        long l = localURLConnection.getLastModified();
        return l != 0L;
      }
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    return false;
  }

  public String getAuthority()
  {
    return this.uri.getAuthority();
  }

  public Path getCanonical()
  {
    if (isAbsolute())
    {
      URI localURI = this.uri.normalize();
      if (localURI == this.uri)
        return this;
      return valueOf(localURI);
    }
    return getAbsolute().getCanonical();
  }

  public long getContentLength()
  {
    return URLPath.getContentLength(toURL());
  }

  public String getFragment()
  {
    return this.uri.getFragment();
  }

  public String getHost()
  {
    return this.uri.getHost();
  }

  public long getLastModified()
  {
    return URLPath.getLastModified(toURL());
  }

  public String getPath()
  {
    return this.uri.getPath();
  }

  public int getPort()
  {
    return this.uri.getPort();
  }

  public String getQuery()
  {
    return this.uri.getQuery();
  }

  public String getScheme()
  {
    return this.uri.getScheme();
  }

  public String getUserInfo()
  {
    return this.uri.getUserInfo();
  }

  public int hashCode()
  {
    return this.uri.hashCode();
  }

  public boolean isAbsolute()
  {
    return this.uri.isAbsolute();
  }

  public InputStream openInputStream()
    throws IOException
  {
    return URLPath.openInputStream(toURL());
  }

  public OutputStream openOutputStream()
    throws IOException
  {
    return URLPath.openOutputStream(toURL());
  }

  public Path resolve(String paramString)
  {
    if (Path.uriSchemeSpecified(paramString))
      return valueOf(paramString);
    char c = File.separatorChar;
    if (c != '/')
    {
      if ((paramString.length() >= 2) && (((paramString.charAt(1) == ':') && (Character.isLetter(paramString.charAt(0)))) || ((paramString.charAt(0) == c) && (paramString.charAt(1) == c))))
        return FilePath.valueOf(new File(paramString));
      paramString = paramString.replace(c, '/');
    }
    try
    {
      URI localURI = this.uri.resolve(new URI(null, paramString, null));
      return valueOf(localURI);
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }

  public String toString()
  {
    return toURIString();
  }

  public String toURIString()
  {
    return this.uri.toString();
  }

  public URL toURL()
  {
    return Path.toURL(this.uri.toString());
  }

  public URI toUri()
  {
    return this.uri;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.URIPath
 * JD-Core Version:    0.6.2
 */