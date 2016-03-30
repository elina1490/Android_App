package gnu.kawa.servlet;

import gnu.mapping.InPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

public abstract class HttpRequestContext
{
  public static final int HTTP_NOT_FOUND = 404;
  public static final int HTTP_OK = 200;
  static final int STATUS_SENT = -999;
  public static int importServletDefinitions;
  protected static final ThreadLocal<HttpRequestContext> instance = new ThreadLocal();
  ServletPrinter consumer;
  String localPath = "";
  String scriptPath = "";
  public int statusCode = 200;
  public String statusReasonPhrase = null;

  public static HttpRequestContext getInstance()
  {
    HttpRequestContext localHttpRequestContext = (HttpRequestContext)instance.get();
    if (localHttpRequestContext == null)
      throw new UnsupportedOperationException("can only be called by http-server");
    return localHttpRequestContext;
  }

  public static HttpRequestContext getInstance(String paramString)
  {
    HttpRequestContext localHttpRequestContext = (HttpRequestContext)instance.get();
    if (localHttpRequestContext == null)
      throw new UnsupportedOperationException(paramString + " can only be called within http-server");
    return localHttpRequestContext;
  }

  public static void setInstance(HttpRequestContext paramHttpRequestContext)
  {
    instance.set(paramHttpRequestContext);
  }

  public abstract Object getAttribute(String paramString);

  public ServletPrinter getConsumer()
    throws IOException
  {
    if (this.consumer == null)
      this.consumer = new ServletPrinter(this, 8192);
    return this.consumer;
  }

  public abstract String getContextPath();

  public InetAddress getLocalHost()
  {
    try
    {
      InetAddress localInetAddress = InetAddress.getLocalHost();
      return localInetAddress;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException(localThrowable);
    }
  }

  public String getLocalIPAddress()
  {
    return getLocalHost().getHostAddress();
  }

  public String getLocalPath()
  {
    return this.localPath;
  }

  public abstract int getLocalPort();

  public InetSocketAddress getLocalSocketAddress()
  {
    return new InetSocketAddress(getLocalHost(), getLocalPort());
  }

  public abstract String getPathTranslated();

  public abstract String getQueryString();

  public abstract InetAddress getRemoteHost();

  public abstract String getRemoteIPAddress();

  public abstract int getRemotePort();

  public InetSocketAddress getRemoteSocketAddress()
  {
    return new InetSocketAddress(getRemoteHost(), getRemotePort());
  }

  public String getRequestBodyChars()
    throws IOException
  {
    InputStreamReader localInputStreamReader = new InputStreamReader(getRequestStream());
    int i = 1024;
    Object localObject = new char[i];
    int j = 0;
    while (true)
    {
      int k = i - j;
      if (k <= 0)
      {
        char[] arrayOfChar = new char[i * 2];
        System.arraycopy(localObject, 0, arrayOfChar, 0, i);
        localObject = arrayOfChar;
        i += i;
      }
      int m = localInputStreamReader.read((char[])localObject, j, k);
      if (m < 0)
      {
        localInputStreamReader.close();
        return new String((char[])localObject, 0, j);
      }
      j += m;
    }
  }

  public abstract String getRequestHeader(String paramString);

  public abstract List<String> getRequestHeaders(String paramString);

  public abstract Map<String, List<String>> getRequestHeaders();

  public abstract String getRequestMethod();

  public String getRequestParameter(String paramString)
  {
    List localList = (List)getRequestParameters().get(paramString);
    if ((localList == null) || (localList.isEmpty()))
      return null;
    return (String)localList.get(0);
  }

  public abstract Map<String, List<String>> getRequestParameters();

  public String getRequestPath()
  {
    return getRequestURI().getPath();
  }

  public InPort getRequestPort()
  {
    return new InPort(getRequestStream());
  }

  public String getRequestScheme()
  {
    return "http";
  }

  public abstract InputStream getRequestStream();

  public abstract URI getRequestURI();

  public StringBuffer getRequestURLBuffer()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(getRequestScheme());
    localStringBuffer.append("://");
    String str = getRequestHeader("Host");
    if (str != null)
      localStringBuffer.append(str);
    while (true)
    {
      localStringBuffer.append(getRequestPath());
      return localStringBuffer;
      localStringBuffer.append(getLocalIPAddress());
      localStringBuffer.append(':');
      localStringBuffer.append(getLocalPort());
    }
  }

  public abstract URL getResourceURL(String paramString);

  public abstract OutputStream getResponseStream();

  public String getScriptPath()
  {
    return this.scriptPath;
  }

  public abstract void log(String paramString);

  public abstract void log(String paramString, Throwable paramThrowable);

  protected String normalizeToContext(String paramString)
  {
    if ((paramString.length() > 0) && (paramString.charAt(0) == '/'));
    for (String str = paramString.substring(1); str.indexOf("..") >= 0; str = getScriptPath() + paramString)
    {
      str = URI.create(str).normalize().toString();
      if (!str.startsWith("../"))
        break;
      return null;
    }
    return str;
  }

  public abstract boolean reset(boolean paramBoolean);

  public void sendNotFound(String paramString)
    throws IOException
  {
    byte[] arrayOfByte = ("The requested URL " + paramString + " was not found on this server.\r\n").getBytes();
    sendResponseHeaders(404, null, arrayOfByte.length);
    OutputStream localOutputStream = getResponseStream();
    try
    {
      localOutputStream.write(arrayOfByte);
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }

  public abstract void sendResponseHeaders(int paramInt, String paramString, long paramLong)
    throws IOException;

  public abstract void setAttribute(String paramString, Object paramObject);

  public void setContentType(String paramString)
  {
    setResponseHeader("Content-Type", paramString);
  }

  public abstract void setResponseHeader(String paramString1, String paramString2);

  public void setScriptAndLocalPath(String paramString1, String paramString2)
  {
    this.scriptPath = paramString1;
    this.localPath = paramString2;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.servlet.HttpRequestContext
 * JD-Core Version:    0.6.2
 */