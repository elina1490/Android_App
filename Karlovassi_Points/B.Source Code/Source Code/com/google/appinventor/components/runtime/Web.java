package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.HtmlEntities;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.FileUtil;
import com.google.appinventor.components.runtime.util.FileUtil.FileException;
import com.google.appinventor.components.runtime.util.GingerbreadUtil;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;

@DesignerComponent(category=ComponentCategory.MISC, description="Non-visible component that provides functions for HTTP GET and POST requests.", iconName="images/web.png", nonVisible=true, version=2)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET")
public class Web extends AndroidNonvisibleComponent
  implements Component
{
  private static final String LOG_TAG = "Web";
  private static final Map<String, String> mimeTypeToExtension = Maps.newHashMap();
  private final Activity activity;
  private boolean allowCookies;
  private final CookieHandler cookieHandler;
  private YailList requestHeaders = new YailList();
  private String responseFileName = "";
  private boolean saveResponse;
  private String urlString = "";

  static
  {
    mimeTypeToExtension.put("application/pdf", "pdf");
    mimeTypeToExtension.put("application/zip", "zip");
    mimeTypeToExtension.put("audio/mpeg", "mpeg");
    mimeTypeToExtension.put("audio/mp3", "mp3");
    mimeTypeToExtension.put("audio/mp4", "mp4");
    mimeTypeToExtension.put("image/gif", "gif");
    mimeTypeToExtension.put("image/jpeg", "jpg");
    mimeTypeToExtension.put("image/png", "png");
    mimeTypeToExtension.put("image/tiff", "tiff");
    mimeTypeToExtension.put("text/plain", "txt");
    mimeTypeToExtension.put("text/html", "html");
    mimeTypeToExtension.put("text/xml", "xml");
  }

  protected Web()
  {
    super(null);
    this.activity = null;
    this.cookieHandler = null;
  }

  public Web(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.activity = paramComponentContainer.$context();
    if (SdkLevel.getLevel() >= 9);
    for (CookieHandler localCookieHandler = GingerbreadUtil.newCookieManager(); ; localCookieHandler = null)
    {
      this.cookieHandler = localCookieHandler;
      return;
    }
  }

  private CapturedProperties capturePropertyValues(String paramString)
  {
    try
    {
      CapturedProperties localCapturedProperties = new CapturedProperties(this);
      return localCapturedProperties;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Form localForm2 = this.form;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.urlString;
      localForm2.dispatchErrorOccurredEvent(this, paramString, 1109, arrayOfObject2);
      return null;
    }
    catch (InvalidRequestHeadersException localInvalidRequestHeadersException)
    {
      while (true)
      {
        Form localForm1 = this.form;
        int i = localInvalidRequestHeadersException.errorNumber;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(localInvalidRequestHeadersException.index);
        localForm1.dispatchErrorOccurredEvent(this, paramString, i, arrayOfObject1);
      }
    }
  }

  private static File createFile(String paramString1, String paramString2)
    throws IOException, FileUtil.FileException
  {
    if (!TextUtils.isEmpty(paramString1))
      return FileUtil.getExternalFile(paramString1);
    int i = paramString2.indexOf(';');
    if (i != -1)
      paramString2 = paramString2.substring(0, i);
    String str = (String)mimeTypeToExtension.get(paramString2);
    if (str == null)
      str = "tmp";
    return FileUtil.getDownloadFile(str);
  }

  static Object decodeJsonText(String paramString)
    throws IllegalArgumentException
  {
    try
    {
      Object localObject = JsonUtil.getObjectFromJson(paramString);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
    }
    throw new IllegalArgumentException("jsonText is not a legal JSON value");
  }

  private static InputStream getConnectionStream(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      InputStream localInputStream = paramHttpURLConnection.getInputStream();
      return localInputStream;
    }
    catch (IOException localIOException)
    {
    }
    return paramHttpURLConnection.getErrorStream();
  }

  private static String getResponseContent(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    String str1 = paramHttpURLConnection.getContentEncoding();
    if (str1 == null)
      str1 = "UTF-8";
    InputStreamReader localInputStreamReader = new InputStreamReader(getConnectionStream(paramHttpURLConnection), str1);
    StringBuilder localStringBuilder;
    while (true)
    {
      try
      {
        int i = paramHttpURLConnection.getContentLength();
        if (i != -1)
        {
          localStringBuilder = new StringBuilder(i);
          char[] arrayOfChar = new char[1024];
          int j = localInputStreamReader.read(arrayOfChar);
          if (j == -1)
            break;
          localStringBuilder.append(arrayOfChar, 0, j);
          continue;
        }
      }
      finally
      {
        localInputStreamReader.close();
      }
      localStringBuilder = new StringBuilder();
    }
    String str2 = localStringBuilder.toString();
    localInputStreamReader.close();
    return str2;
  }

  private static String getResponseType(HttpURLConnection paramHttpURLConnection)
  {
    String str = paramHttpURLConnection.getContentType();
    if (str != null)
      return str;
    return "";
  }

  private static HttpURLConnection openConnection(CapturedProperties paramCapturedProperties)
    throws IOException, ClassCastException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramCapturedProperties.url.openConnection();
    Iterator localIterator1 = paramCapturedProperties.requestHeaders.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      String str2 = (String)localEntry2.getKey();
      Iterator localIterator4 = ((List)localEntry2.getValue()).iterator();
      while (localIterator4.hasNext())
        localHttpURLConnection.addRequestProperty(str2, (String)localIterator4.next());
    }
    if (paramCapturedProperties.cookies != null)
    {
      Iterator localIterator2 = paramCapturedProperties.cookies.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
        String str1 = (String)localEntry1.getKey();
        Iterator localIterator3 = ((List)localEntry1.getValue()).iterator();
        while (localIterator3.hasNext())
          localHttpURLConnection.addRequestProperty(str1, (String)localIterator3.next());
      }
    }
    return localHttpURLConnection;
  }

  private void performRequest(final CapturedProperties paramCapturedProperties, byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = openConnection(paramCapturedProperties);
    if ((localHttpURLConnection == null) || (paramArrayOfByte != null));
    while (true)
    {
      final int i;
      final String str1;
      try
      {
        writePostData(localHttpURLConnection, paramArrayOfByte);
        i = localHttpURLConnection.getResponseCode();
        str1 = getResponseType(localHttpURLConnection);
        processResponseCookies(localHttpURLConnection);
        if (this.saveResponse)
        {
          final String str3 = saveResponseContent(localHttpURLConnection, paramCapturedProperties.responseFileName, str1);
          this.activity.runOnUiThread(new Runnable()
          {
            public void run()
            {
              Web.this.GotFile(paramCapturedProperties.urlString, i, str1, str3);
            }
          });
          return;
          if (paramString == null)
            continue;
          writePostFile(localHttpURLConnection, paramString);
          continue;
        }
      }
      finally
      {
        localHttpURLConnection.disconnect();
      }
      final String str2 = getResponseContent(localHttpURLConnection);
      this.activity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Web.this.GotText(paramCapturedProperties.urlString, i, str1, str2);
        }
      });
    }
  }

  private void postTextImpl(final String paramString1, final String paramString2, final String paramString3)
  {
    final CapturedProperties localCapturedProperties = capturePropertyValues(paramString3);
    if (localCapturedProperties == null)
      return;
    AsynchUtil.runAsynchronously(new Runnable()
    {
      // ERROR //
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 25	com/google/appinventor/components/runtime/Web$2:val$encoding	Ljava/lang/String;
        //   4: ifnull +13 -> 17
        //   7: aload_0
        //   8: getfield 25	com/google/appinventor/components/runtime/Web$2:val$encoding	Ljava/lang/String;
        //   11: invokevirtual 47	java/lang/String:length	()I
        //   14: ifne +33 -> 47
        //   17: aload_0
        //   18: getfield 27	com/google/appinventor/components/runtime/Web$2:val$text	Ljava/lang/String;
        //   21: ldc 49
        //   23: invokevirtual 53	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   26: astore 6
        //   28: aload 6
        //   30: astore 7
        //   32: aload_0
        //   33: getfield 23	com/google/appinventor/components/runtime/Web$2:this$0	Lcom/google/appinventor/components/runtime/Web;
        //   36: aload_0
        //   37: getfield 31	com/google/appinventor/components/runtime/Web$2:val$webProps	Lcom/google/appinventor/components/runtime/Web$CapturedProperties;
        //   40: aload 7
        //   42: aconst_null
        //   43: invokestatic 57	com/google/appinventor/components/runtime/Web:access$700	(Lcom/google/appinventor/components/runtime/Web;Lcom/google/appinventor/components/runtime/Web$CapturedProperties;[BLjava/lang/String;)V
        //   46: return
        //   47: aload_0
        //   48: getfield 27	com/google/appinventor/components/runtime/Web$2:val$text	Ljava/lang/String;
        //   51: aload_0
        //   52: getfield 25	com/google/appinventor/components/runtime/Web$2:val$encoding	Ljava/lang/String;
        //   55: invokevirtual 53	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   58: astore 14
        //   60: aload 14
        //   62: astore 7
        //   64: goto -32 -> 32
        //   67: astore_1
        //   68: aload_0
        //   69: getfield 23	com/google/appinventor/components/runtime/Web$2:this$0	Lcom/google/appinventor/components/runtime/Web;
        //   72: getfield 61	com/google/appinventor/components/runtime/Web:form	Lcom/google/appinventor/components/runtime/Form;
        //   75: astore_2
        //   76: aload_0
        //   77: getfield 23	com/google/appinventor/components/runtime/Web$2:this$0	Lcom/google/appinventor/components/runtime/Web;
        //   80: astore_3
        //   81: aload_0
        //   82: getfield 29	com/google/appinventor/components/runtime/Web$2:val$functionName	Ljava/lang/String;
        //   85: astore 4
        //   87: iconst_1
        //   88: anewarray 4	java/lang/Object
        //   91: astore 5
        //   93: aload 5
        //   95: iconst_0
        //   96: aload_0
        //   97: getfield 25	com/google/appinventor/components/runtime/Web$2:val$encoding	Ljava/lang/String;
        //   100: aastore
        //   101: aload_2
        //   102: aload_3
        //   103: aload 4
        //   105: sipush 1102
        //   108: aload 5
        //   110: invokevirtual 67	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
        //   113: return
        //   114: astore 13
        //   116: aload_0
        //   117: getfield 23	com/google/appinventor/components/runtime/Web$2:this$0	Lcom/google/appinventor/components/runtime/Web;
        //   120: getfield 61	com/google/appinventor/components/runtime/Web:form	Lcom/google/appinventor/components/runtime/Form;
        //   123: aload_0
        //   124: getfield 23	com/google/appinventor/components/runtime/Web$2:this$0	Lcom/google/appinventor/components/runtime/Web;
        //   127: aload_0
        //   128: getfield 29	com/google/appinventor/components/runtime/Web$2:val$functionName	Ljava/lang/String;
        //   131: aload 13
        //   133: invokevirtual 70	com/google/appinventor/components/runtime/util/FileUtil$FileException:getErrorMessageNumber	()I
        //   136: iconst_0
        //   137: anewarray 4	java/lang/Object
        //   140: invokevirtual 67	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
        //   143: return
        //   144: astore 8
        //   146: aload_0
        //   147: getfield 23	com/google/appinventor/components/runtime/Web$2:this$0	Lcom/google/appinventor/components/runtime/Web;
        //   150: getfield 61	com/google/appinventor/components/runtime/Web:form	Lcom/google/appinventor/components/runtime/Form;
        //   153: astore 9
        //   155: aload_0
        //   156: getfield 23	com/google/appinventor/components/runtime/Web$2:this$0	Lcom/google/appinventor/components/runtime/Web;
        //   159: astore 10
        //   161: aload_0
        //   162: getfield 29	com/google/appinventor/components/runtime/Web$2:val$functionName	Ljava/lang/String;
        //   165: astore 11
        //   167: iconst_2
        //   168: anewarray 4	java/lang/Object
        //   171: astore 12
        //   173: aload 12
        //   175: iconst_0
        //   176: aload_0
        //   177: getfield 27	com/google/appinventor/components/runtime/Web$2:val$text	Ljava/lang/String;
        //   180: aastore
        //   181: aload 12
        //   183: iconst_1
        //   184: aload_0
        //   185: getfield 31	com/google/appinventor/components/runtime/Web$2:val$webProps	Lcom/google/appinventor/components/runtime/Web$CapturedProperties;
        //   188: getfield 75	com/google/appinventor/components/runtime/Web$CapturedProperties:urlString	Ljava/lang/String;
        //   191: aastore
        //   192: aload 9
        //   194: aload 10
        //   196: aload 11
        //   198: sipush 1103
        //   201: aload 12
        //   203: invokevirtual 67	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
        //   206: return
        //
        // Exception table:
        //   from	to	target	type
        //   0	17	67	java/io/UnsupportedEncodingException
        //   17	28	67	java/io/UnsupportedEncodingException
        //   47	60	67	java/io/UnsupportedEncodingException
        //   32	46	114	com/google/appinventor/components/runtime/util/FileUtil$FileException
        //   32	46	144	java/lang/Exception
      }
    });
  }

  private static Map<String, List<String>> processRequestHeaders(YailList paramYailList)
    throws Web.InvalidRequestHeadersException
  {
    HashMap localHashMap = Maps.newHashMap();
    int i = 0;
    while (i < paramYailList.size())
    {
      Object localObject1 = paramYailList.getObject(i);
      if ((localObject1 instanceof YailList))
      {
        YailList localYailList1 = (YailList)localObject1;
        if (localYailList1.size() == 2)
        {
          String str = localYailList1.getObject(0).toString();
          Object localObject2 = localYailList1.getObject(1);
          ArrayList localArrayList = Lists.newArrayList();
          if ((localObject2 instanceof YailList))
          {
            YailList localYailList2 = (YailList)localObject2;
            for (int j = 0; j < localYailList2.size(); j++)
              localArrayList.add(localYailList2.getObject(j).toString());
          }
          localArrayList.add(localObject2.toString());
          localHashMap.put(str, localArrayList);
          i++;
        }
        else
        {
          throw new InvalidRequestHeadersException(1111, i + 1);
        }
      }
      else
      {
        throw new InvalidRequestHeadersException(1110, i + 1);
      }
    }
    return localHashMap;
  }

  private void processResponseCookies(HttpURLConnection paramHttpURLConnection)
  {
    if ((this.allowCookies) && (this.cookieHandler != null));
    try
    {
      Map localMap = paramHttpURLConnection.getHeaderFields();
      this.cookieHandler.put(paramHttpURLConnection.getURL().toURI(), localMap);
      return;
    }
    catch (IOException localIOException)
    {
    }
    catch (URISyntaxException localURISyntaxException)
    {
    }
  }

  private static String saveResponseContent(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2)
    throws IOException
  {
    File localFile = createFile(paramString1, paramString2);
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(getConnectionStream(paramHttpURLConnection), 4096);
    try
    {
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile), 4096);
      try
      {
        while (true)
        {
          int i = localBufferedInputStream.read();
          if (i == -1)
          {
            localBufferedOutputStream.flush();
            return localFile.getAbsolutePath();
          }
          localBufferedOutputStream.write(i);
        }
      }
      finally
      {
      }
    }
    finally
    {
      localBufferedInputStream.close();
    }
  }

  private static void writePostData(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte)
    throws IOException
  {
    paramHttpURLConnection.setDoOutput(true);
    paramHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramHttpURLConnection.getOutputStream());
    try
    {
      localBufferedOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      localBufferedOutputStream.flush();
      return;
    }
    finally
    {
      localBufferedOutputStream.close();
    }
  }

  private void writePostFile(HttpURLConnection paramHttpURLConnection, String paramString)
    throws IOException
  {
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(MediaUtil.openMedia(this.form, paramString));
    try
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.setChunkedStreamingMode(0);
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(paramHttpURLConnection.getOutputStream());
      try
      {
        while (true)
        {
          int i = localBufferedInputStream.read();
          if (i == -1)
          {
            localBufferedOutputStream.flush();
            return;
          }
          localBufferedOutputStream.write(i);
        }
      }
      finally
      {
      }
    }
    finally
    {
      localBufferedInputStream.close();
    }
  }

  @DesignerProperty(defaultValue="false", editorType="boolean")
  @SimpleProperty
  public void AllowCookies(boolean paramBoolean)
  {
    this.allowCookies = paramBoolean;
    if ((paramBoolean) && (this.cookieHandler == null))
      this.form.dispatchErrorOccurredEvent(this, "AllowCookies", 4, new Object[0]);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the cookies from a response should be saved and used in subsequent requests. Cookies are only supported on Android version 2.3 or greater.")
  public boolean AllowCookies()
  {
    return this.allowCookies;
  }

  @SimpleFunction
  public String BuildPostData(YailList paramYailList)
  {
    try
    {
      String str = buildPostData(paramYailList);
      return str;
    }
    catch (BuildPostDataException localBuildPostDataException)
    {
      Form localForm = this.form;
      int i = localBuildPostDataException.errorNumber;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(localBuildPostDataException.index);
      localForm.dispatchErrorOccurredEvent(this, "BuildPostData", i, arrayOfObject);
    }
    return "";
  }

  @SimpleFunction(description="Clears all cookies for this Web component.")
  public void ClearCookies()
  {
    if (this.cookieHandler != null)
    {
      GingerbreadUtil.clearCookies(this.cookieHandler);
      return;
    }
    this.form.dispatchErrorOccurredEvent(this, "ClearCookies", 4, new Object[0]);
  }

  @SimpleFunction
  public void Get()
  {
    final CapturedProperties localCapturedProperties = capturePropertyValues("Get");
    if (localCapturedProperties == null)
      return;
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        try
        {
          Web.this.performRequest(localCapturedProperties, null, null);
          return;
        }
        catch (FileUtil.FileException localFileException)
        {
          Web.this.form.dispatchErrorOccurredEvent(Web.this, "Get", localFileException.getErrorMessageNumber(), new Object[0]);
          return;
        }
        catch (Exception localException)
        {
          Form localForm = Web.this.form;
          Web localWeb = Web.this;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localCapturedProperties.urlString;
          localForm.dispatchErrorOccurredEvent(localWeb, "Get", 1101, arrayOfObject);
        }
      }
    });
  }

  @SimpleEvent
  public void GotFile(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    arrayOfObject[2] = paramString2;
    arrayOfObject[3] = paramString3;
    EventDispatcher.dispatchEvent(this, "GotFile", arrayOfObject);
  }

  @SimpleEvent
  public void GotText(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramString1;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    arrayOfObject[2] = paramString2;
    arrayOfObject[3] = paramString3;
    EventDispatcher.dispatchEvent(this, "GotText", arrayOfObject);
  }

  @SimpleFunction(description="Decodes the given HTML text value. HTML character entities such as &amp;amp;, &amp;lt;, &amp;gt;, &amp;apos;, and &amp;quot; are changed to &amp;, &lt;, &gt;, &#39;, and &quot;. Entities such as &amp;#xhhhh, and &amp;#nnnn are changed to the appropriate characters.")
  public String HtmlTextDecode(String paramString)
  {
    try
    {
      String str = HtmlEntities.decodeHtmlText(paramString);
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "HtmlTextDecode", 1106, new Object[] { paramString });
    }
    return "";
  }

  @SimpleFunction
  public Object JsonTextDecode(String paramString)
  {
    try
    {
      Object localObject = decodeJsonText(paramString);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.form.dispatchErrorOccurredEvent(this, "JsonTextDecode", 1105, new Object[] { paramString });
    }
    return "";
  }

  @SimpleFunction(description="Performs an HTTP POST request using the Url property and data from the specified file.<br>If the SaveResponse property is true, the response will be saved in a file and the GotFile event will be triggered. The ResponseFileName property can be used to specify the name of the file.<br>If the SaveResponse property is false, the GotText event will be triggered.")
  public void PostFile(final String paramString)
  {
    final CapturedProperties localCapturedProperties = capturePropertyValues("PostFile");
    if (localCapturedProperties == null)
      return;
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        try
        {
          Web.this.performRequest(localCapturedProperties, null, paramString);
          return;
        }
        catch (FileUtil.FileException localFileException)
        {
          Web.this.form.dispatchErrorOccurredEvent(Web.this, "PostFile", localFileException.getErrorMessageNumber(), new Object[0]);
          return;
        }
        catch (Exception localException)
        {
          Form localForm = Web.this.form;
          Web localWeb = Web.this;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramString;
          arrayOfObject[1] = localCapturedProperties.urlString;
          localForm.dispatchErrorOccurredEvent(localWeb, "PostFile", 1104, arrayOfObject);
        }
      }
    });
  }

  @SimpleFunction(description="Performs an HTTP POST request using the Url property and the specified text.<br>The characters of the text are encoded using UTF-8 encoding.<br>If the SaveResponse property is true, the response will be saved in a file and the GotFile event will be triggered. The responseFileName property can be used to specify the name of the file.<br>If the SaveResponse property is false, the GotText event will be triggered.")
  public void PostText(String paramString)
  {
    postTextImpl(paramString, "UTF-8", "PostText");
  }

  @SimpleFunction(description="Performs an HTTP POST request using the Url property and the specified text.<br>The characters of the text are encoded using the given encoding.<br>If the SaveResponse property is true, the response will be saved in a file and the GotFile event will be triggered. The ResponseFileName property can be used to specify the name of the file.<br>If the SaveResponse property is false, the GotText event will be triggered.")
  public void PostTextWithEncoding(String paramString1, String paramString2)
  {
    postTextImpl(paramString1, paramString2, "PostTextWithEncoding");
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The request headers, as a list of two-element sublists. The first element of each sublist represents the request header field name. The second element of each sublist represents the request header field values, either a single value or a list containing multiple values.")
  public YailList RequestHeaders()
  {
    return this.requestHeaders;
  }

  @SimpleProperty
  public void RequestHeaders(YailList paramYailList)
  {
    try
    {
      processRequestHeaders(paramYailList);
      this.requestHeaders = paramYailList;
      return;
    }
    catch (InvalidRequestHeadersException localInvalidRequestHeadersException)
    {
      Form localForm = this.form;
      int i = localInvalidRequestHeadersException.errorNumber;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(localInvalidRequestHeadersException.index);
      localForm.dispatchErrorOccurredEvent(this, "RequestHeaders", i, arrayOfObject);
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The name of the file where the response should be saved. If SaveResponse is true and ResponseFileName is empty, then a new file name will be generated.")
  public String ResponseFileName()
  {
    return this.responseFileName;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void ResponseFileName(String paramString)
  {
    this.responseFileName = paramString;
  }

  @DesignerProperty(defaultValue="false", editorType="boolean")
  @SimpleProperty
  public void SaveResponse(boolean paramBoolean)
  {
    this.saveResponse = paramBoolean;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the response should be saved in a file.")
  public boolean SaveResponse()
  {
    return this.saveResponse;
  }

  @SimpleFunction
  public String UriEncode(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.e("Web", "UTF-8 is unsupported?", localUnsupportedEncodingException);
    }
    return "";
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The URL for the web request.")
  public String Url()
  {
    return this.urlString;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void Url(String paramString)
  {
    this.urlString = paramString;
  }

  String buildPostData(YailList paramYailList)
    throws Web.BuildPostDataException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = "";
    int i = 0;
    while (i < paramYailList.size())
    {
      Object localObject = paramYailList.getObject(i);
      if ((localObject instanceof YailList))
      {
        YailList localYailList = (YailList)localObject;
        if (localYailList.size() == 2)
        {
          String str2 = localYailList.getObject(0).toString();
          String str3 = localYailList.getObject(1).toString();
          localStringBuilder.append(str1).append(UriEncode(str2)).append('=').append(UriEncode(str3));
          str1 = "&";
          i++;
        }
        else
        {
          throw new BuildPostDataException(1113, i + 1);
        }
      }
      else
      {
        throw new BuildPostDataException(1112, i + 1);
      }
    }
    return localStringBuilder.toString();
  }

  static class BuildPostDataException extends Exception
  {
    final int errorNumber;
    final int index;

    BuildPostDataException(int paramInt1, int paramInt2)
    {
      this.errorNumber = paramInt1;
      this.index = paramInt2;
    }
  }

  private static class CapturedProperties
  {
    final boolean allowCookies;
    final Map<String, List<String>> cookies;
    final Map<String, List<String>> requestHeaders;
    final String responseFileName;
    final boolean saveResponse;
    final URL url;
    final String urlString;

    CapturedProperties(Web paramWeb)
      throws MalformedURLException, Web.InvalidRequestHeadersException
    {
      this.urlString = paramWeb.urlString;
      this.url = new URL(this.urlString);
      this.allowCookies = paramWeb.allowCookies;
      this.saveResponse = paramWeb.saveResponse;
      this.responseFileName = paramWeb.responseFileName;
      this.requestHeaders = Web.processRequestHeaders(paramWeb.requestHeaders);
      boolean bool = this.allowCookies;
      Object localObject = null;
      if (bool)
      {
        CookieHandler localCookieHandler = paramWeb.cookieHandler;
        localObject = null;
        if (localCookieHandler == null);
      }
      try
      {
        Map localMap = paramWeb.cookieHandler.get(this.url.toURI(), this.requestHeaders);
        localObject = localMap;
        this.cookies = localObject;
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          localObject = null;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        while (true)
          localObject = null;
      }
    }
  }

  private static class InvalidRequestHeadersException extends Exception
  {
    final int errorNumber;
    final int index;

    InvalidRequestHeadersException(int paramInt1, int paramInt2)
    {
      this.errorNumber = paramInt1;
      this.index = paramInt2;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Web
 * JD-Core Version:    0.6.2
 */