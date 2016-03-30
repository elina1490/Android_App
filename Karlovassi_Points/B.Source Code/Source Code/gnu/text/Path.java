package gnu.text;

import gnu.lists.FString;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class Path
{
  public static Path defaultPath = userDirPath;
  private static ThreadLocal<Path> pathLocation = new ThreadLocal();
  public static final FilePath userDirPath = FilePath.valueOf(new File("."));

  public static Path coerceToPathOrNull(Object paramObject)
  {
    if ((paramObject instanceof Path))
      return (Path)paramObject;
    if ((paramObject instanceof URL))
      return URLPath.valueOf((URL)paramObject);
    if ((paramObject instanceof URI))
      return URIPath.valueOf((URI)paramObject);
    if ((paramObject instanceof File))
      return FilePath.valueOf((File)paramObject);
    if ((paramObject instanceof FString));
    for (String str = paramObject.toString(); uriSchemeSpecified(str); str = (String)paramObject)
    {
      return URIPath.valueOf(str);
      if (!(paramObject instanceof String))
        return null;
    }
    return FilePath.valueOf(str);
  }

  public static Path currentPath()
  {
    Path localPath = (Path)pathLocation.get();
    if (localPath != null)
      return localPath;
    return defaultPath;
  }

  public static InputStream openInputStream(Object paramObject)
    throws IOException
  {
    return valueOf(paramObject).openInputStream();
  }

  public static String relativize(String paramString1, String paramString2)
    throws URISyntaxException, IOException
  {
    String str1 = new URI(paramString2).normalize().toString();
    String str2 = URLPath.valueOf(paramString1).toURI().normalize().toString();
    int i = str1.length();
    int j = str2.length();
    int k = 0;
    int m = 0;
    int n = 0;
    String str4;
    StringBuilder localStringBuilder;
    while (true)
    {
      int i2;
      if ((k < i) && (k < j))
      {
        i2 = str1.charAt(k);
        if (i2 == str2.charAt(k));
      }
      else
      {
        if ((n <= 0) || ((m <= n + 2) && (i > n + 2) && (str1.charAt(n + 2) == '/')))
          break;
        String str3 = str1.substring(m + 1);
        str4 = str2.substring(m + 1);
        localStringBuilder = new StringBuilder();
        int i1 = str3.length();
        while (true)
        {
          i1--;
          if (i1 < 0)
            break;
          if (str3.charAt(i1) == '/')
            localStringBuilder.append("../");
        }
      }
      if (i2 == 47)
        m = k;
      if (i2 == 58)
        n = k;
      k++;
    }
    return paramString1;
    localStringBuilder.append(str4);
    return localStringBuilder.toString();
  }

  public static void setCurrentPath(Path paramPath)
  {
    pathLocation.set(paramPath);
  }

  public static URL toURL(String paramString)
  {
    try
    {
      if (!uriSchemeSpecified(paramString))
      {
        Path localPath = currentPath().resolve(paramString);
        if (localPath.isAbsolute())
          return localPath.toURL();
        paramString = localPath.toString();
      }
      URL localURL = new URL(paramString);
      return localURL;
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }

  public static int uriSchemeLength(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      char c = paramString.charAt(j);
      if (c == ':')
        return j;
      if (j == 0)
      {
        if (Character.isLetter(c));
      }
      else
        while ((!Character.isLetterOrDigit(c)) && (c != '+') && (c != '-') && (c != '.'))
          return -1;
    }
    return -1;
  }

  public static boolean uriSchemeSpecified(String paramString)
  {
    int i = uriSchemeLength(paramString);
    if ((i == 1) && (File.separatorChar == '\\'))
    {
      int j = paramString.charAt(0);
      return ((j < 97) || (j > 122)) && ((j < 65) || (j > 90));
    }
    return i > 0;
  }

  public static Path valueOf(Object paramObject)
  {
    Path localPath = coerceToPathOrNull(paramObject);
    if (localPath == null)
      throw new WrongType((String)null, -4, paramObject, "path");
    return localPath;
  }

  public boolean delete()
  {
    return false;
  }

  public boolean exists()
  {
    return getLastModified() != 0L;
  }

  public Path getAbsolute()
  {
    if (this == userDirPath)
      return resolve("");
    return currentPath().resolve(this);
  }

  public String getAuthority()
  {
    return null;
  }

  public Path getCanonical()
  {
    return getAbsolute();
  }

  public CharSequence getCharContent(boolean paramBoolean)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }

  public long getContentLength()
  {
    return -1L;
  }

  public Path getDirectory()
  {
    if (isDirectory())
      return this;
    return resolve("");
  }

  public String getExtension()
  {
    String str = getPath();
    if (str == null)
      return null;
    int i = str.length();
    int k;
    do
    {
      i--;
      if (i <= 0)
        return null;
      int j = str.charAt(i);
      k = 0;
      if (j == 46)
      {
        j = str.charAt(i - 1);
        k = 1;
      }
      if ((j == 47) || (((this instanceof FilePath)) && (j == File.separatorChar)))
        return null;
    }
    while (k == 0);
    return str.substring(i + 1);
  }

  public String getFragment()
  {
    return null;
  }

  public String getHost()
  {
    return null;
  }

  public String getLast()
  {
    String str = getPath();
    if (str == null)
      return null;
    int i = str.length();
    int j = i;
    int k = i;
    while (true)
    {
      k--;
      if (k <= 0)
        return "";
      int m = str.charAt(k);
      if ((m == 47) || (((this instanceof FilePath)) && (m == File.separatorChar)))
      {
        if (k + 1 != i)
          break;
        j = k;
      }
    }
    return str.substring(k + 1, j);
  }

  public abstract long getLastModified();

  public String getName()
  {
    return toString();
  }

  public Path getParent()
  {
    if (isDirectory());
    for (String str = ".."; ; str = "")
      return resolve(str);
  }

  public abstract String getPath();

  public int getPort()
  {
    return -1;
  }

  public String getQuery()
  {
    return null;
  }

  public abstract String getScheme();

  public String getUserInfo()
  {
    return null;
  }

  public abstract boolean isAbsolute();

  public boolean isDirectory()
  {
    String str = toString();
    int i = str.length();
    if (i > 0)
    {
      int j = str.charAt(i - 1);
      if ((j == 47) || (j == File.separatorChar))
        return true;
    }
    return false;
  }

  public abstract InputStream openInputStream()
    throws IOException;

  public abstract OutputStream openOutputStream()
    throws IOException;

  public Reader openReader(boolean paramBoolean)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }

  public Writer openWriter()
    throws IOException
  {
    return new OutputStreamWriter(openOutputStream());
  }

  public Path resolve(Path paramPath)
  {
    if (paramPath.isAbsolute())
      return paramPath;
    return resolve(paramPath.toString());
  }

  public abstract Path resolve(String paramString);

  public final URI toURI()
  {
    return toUri();
  }

  public String toURIString()
  {
    return toUri().toString();
  }

  public abstract URL toURL();

  public abstract URI toUri();
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.Path
 * JD-Core Version:    0.6.2
 */