package gnu.kawa.servlet;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Format;
import gnu.kawa.xml.MakeResponseHeader;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.URIPath;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

public class HTTP extends ModuleBody
{
  public static final HTTP $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final SimpleSymbol Lit14;
  static final SimpleSymbol Lit15;
  static final SimpleSymbol Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final SimpleSymbol Lit19;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit20;
  static final SimpleSymbol Lit21;
  static final SimpleSymbol Lit22;
  static final SimpleSymbol Lit23;
  static final SimpleSymbol Lit24;
  static final SimpleSymbol Lit25;
  static final SimpleSymbol Lit26;
  static final SimpleSymbol Lit27;
  static final SimpleSymbol Lit28;
  static final SimpleSymbol Lit29;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit30;
  static final SimpleSymbol Lit31;
  static final SimpleSymbol Lit32 = (SimpleSymbol)new SimpleSymbol("request-input-port").readResolve();
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9;
  public static final ModuleMethod error$Mnresponse;
  public static final ModuleMethod request$MnURI;
  public static final ModuleMethod request$Mnbody$Mnstring;
  public static final ModuleMethod request$Mncontext$Mnpath;
  public static final ModuleMethod request$Mnheader;
  public static final ModuleMethod request$Mnheader$Mnmap;
  public static final ModuleMethod request$Mninput$Mnport;
  public static final ModuleMethod request$Mninput$Mnstream;
  public static final ModuleMethod request$Mnlocal$MnIP$Mnaddress;
  public static final ModuleMethod request$Mnlocal$Mnhost;
  public static final ModuleMethod request$Mnlocal$Mnpath;
  public static final ModuleMethod request$Mnlocal$Mnport;
  public static final ModuleMethod request$Mnlocal$Mnsocket$Mnaddress;
  public static final ModuleMethod request$Mnmethod;
  public static final ModuleMethod request$Mnparameter;
  public static final ModuleMethod request$Mnparameter$Mnmap;
  public static final ModuleMethod request$Mnparameters;
  public static final ModuleMethod request$Mnpath;
  public static final ModuleMethod request$Mnpath$Mntranslated;
  public static final ModuleMethod request$Mnquery$Mnstring;
  public static final ModuleMethod request$Mnremote$MnIP$Mnaddress;
  public static final ModuleMethod request$Mnremote$Mnhost;
  public static final ModuleMethod request$Mnremote$Mnport;
  public static final ModuleMethod request$Mnremote$Mnsocket$Mnaddress;
  public static final ModuleMethod request$Mnscheme;
  public static final ModuleMethod request$Mnscript$Mnpath;
  public static final ModuleMethod request$Mnuri;
  public static final ModuleMethod request$Mnurl;
  public static final ModuleMethod response$Mncontent$Mntype;
  public static final ModuleMethod response$Mnheader;
  public static final ModuleMethod response$Mnstatus;

  static
  {
    Lit31 = (SimpleSymbol)new SimpleSymbol("request-input-stream").readResolve();
    Lit30 = (SimpleSymbol)new SimpleSymbol("request-body-string").readResolve();
    Lit29 = (SimpleSymbol)new SimpleSymbol("request-parameter-map").readResolve();
    Lit28 = (SimpleSymbol)new SimpleSymbol("request-parameters").readResolve();
    Lit27 = (SimpleSymbol)new SimpleSymbol("request-parameter").readResolve();
    Lit26 = (SimpleSymbol)new SimpleSymbol("request-query-string").readResolve();
    Lit25 = (SimpleSymbol)new SimpleSymbol("request-path-translated").readResolve();
    Lit24 = (SimpleSymbol)new SimpleSymbol("request-url").readResolve();
    Lit23 = (SimpleSymbol)new SimpleSymbol("request-uri").readResolve();
    Lit22 = (SimpleSymbol)new SimpleSymbol("request-path").readResolve();
    Lit21 = (SimpleSymbol)new SimpleSymbol("request-local-path").readResolve();
    Lit20 = (SimpleSymbol)new SimpleSymbol("request-script-path").readResolve();
    Lit19 = (SimpleSymbol)new SimpleSymbol("request-context-path").readResolve();
    Lit18 = (SimpleSymbol)new SimpleSymbol("request-URI").readResolve();
    Lit17 = (SimpleSymbol)new SimpleSymbol("request-header-map").readResolve();
    Lit16 = (SimpleSymbol)new SimpleSymbol("request-header").readResolve();
    Lit15 = (SimpleSymbol)new SimpleSymbol("request-remote-host").readResolve();
    Lit14 = (SimpleSymbol)new SimpleSymbol("request-remote-port").readResolve();
    Lit13 = (SimpleSymbol)new SimpleSymbol("request-remote-IP-address").readResolve();
    Lit12 = (SimpleSymbol)new SimpleSymbol("request-remote-socket-address").readResolve();
    Lit11 = (SimpleSymbol)new SimpleSymbol("request-local-host").readResolve();
    Lit10 = (SimpleSymbol)new SimpleSymbol("request-local-port").readResolve();
    Lit9 = (SimpleSymbol)new SimpleSymbol("request-local-IP-address").readResolve();
    Lit8 = (SimpleSymbol)new SimpleSymbol("request-local-socket-address").readResolve();
    Lit7 = (SimpleSymbol)new SimpleSymbol("request-scheme").readResolve();
    Lit6 = (SimpleSymbol)new SimpleSymbol("request-method").readResolve();
    Lit5 = (SimpleSymbol)new SimpleSymbol("error-response").readResolve();
    Lit4 = (SimpleSymbol)new SimpleSymbol("response-status").readResolve();
    Lit3 = (SimpleSymbol)new SimpleSymbol("response-content-type").readResolve();
    Lit2 = (SimpleSymbol)new SimpleSymbol("response-header").readResolve();
    Lit1 = (SimpleSymbol)new SimpleSymbol("Status").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("Content-Type").readResolve();
    $instance = new HTTP();
    HTTP localHTTP = $instance;
    response$Mnheader = new ModuleMethod(localHTTP, 1, Lit2, 8194);
    response$Mncontent$Mntype = new ModuleMethod(localHTTP, 2, Lit3, 4097);
    response$Mnstatus = new ModuleMethod(localHTTP, 3, Lit4, 8193);
    error$Mnresponse = new ModuleMethod(localHTTP, 5, Lit5, 8193);
    request$Mnmethod = new ModuleMethod(localHTTP, 7, Lit6, 0);
    request$Mnscheme = new ModuleMethod(localHTTP, 8, Lit7, 0);
    request$Mnlocal$Mnsocket$Mnaddress = new ModuleMethod(localHTTP, 9, Lit8, 0);
    request$Mnlocal$MnIP$Mnaddress = new ModuleMethod(localHTTP, 10, Lit9, 0);
    request$Mnlocal$Mnport = new ModuleMethod(localHTTP, 11, Lit10, 0);
    request$Mnlocal$Mnhost = new ModuleMethod(localHTTP, 12, Lit11, 0);
    request$Mnremote$Mnsocket$Mnaddress = new ModuleMethod(localHTTP, 13, Lit12, 0);
    request$Mnremote$MnIP$Mnaddress = new ModuleMethod(localHTTP, 14, Lit13, 0);
    request$Mnremote$Mnport = new ModuleMethod(localHTTP, 15, Lit14, 0);
    request$Mnremote$Mnhost = new ModuleMethod(localHTTP, 16, Lit15, 0);
    request$Mnheader = new ModuleMethod(localHTTP, 17, Lit16, 4097);
    request$Mnheader$Mnmap = new ModuleMethod(localHTTP, 18, Lit17, 0);
    request$MnURI = new ModuleMethod(localHTTP, 19, Lit18, 0);
    request$Mncontext$Mnpath = new ModuleMethod(localHTTP, 20, Lit19, 0);
    request$Mnscript$Mnpath = new ModuleMethod(localHTTP, 21, Lit20, 0);
    request$Mnlocal$Mnpath = new ModuleMethod(localHTTP, 22, Lit21, 0);
    request$Mnpath = new ModuleMethod(localHTTP, 23, Lit22, 0);
    request$Mnuri = new ModuleMethod(localHTTP, 24, Lit23, 0);
    request$Mnurl = new ModuleMethod(localHTTP, 25, Lit24, 0);
    request$Mnpath$Mntranslated = new ModuleMethod(localHTTP, 26, Lit25, 0);
    request$Mnquery$Mnstring = new ModuleMethod(localHTTP, 27, Lit26, 0);
    request$Mnparameter = new ModuleMethod(localHTTP, 28, Lit27, 8193);
    request$Mnparameters = new ModuleMethod(localHTTP, 30, Lit28, 4097);
    request$Mnparameter$Mnmap = new ModuleMethod(localHTTP, 31, Lit29, 0);
    request$Mnbody$Mnstring = new ModuleMethod(localHTTP, 32, Lit30, 0);
    request$Mninput$Mnstream = new ModuleMethod(localHTTP, 33, Lit31, 0);
    request$Mninput$Mnport = new ModuleMethod(localHTTP, 34, Lit32, 0);
    $instance.run();
  }

  public HTTP()
  {
    ModuleInfo.register(this);
  }

  public static Object errorResponse(int paramInt)
  {
    return errorResponse(paramInt, "Error");
  }

  public static Object errorResponse(int paramInt, String paramString)
  {
    SimpleSymbol localSimpleSymbol = Lit1;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = "~d ~a";
    arrayOfObject[1] = Integer.valueOf(paramInt);
    arrayOfObject[2] = paramString;
    return responseHeader(localSimpleSymbol, Format.formatToString(0, arrayOfObject));
  }

  public static URIPath request$MnURI()
  {
    return URIPath.makeURI(HttpRequestContext.getInstance("request-URI").getRequestURI());
  }

  public static CharSequence requestBodyString()
  {
    return HttpRequestContext.getInstance("request-body-string").getRequestBodyChars();
  }

  public static URIPath requestContextPath()
  {
    return URIPath.makeURI(HttpRequestContext.getInstance("request-context-path").getContextPath());
  }

  public static String requestHeader(Object paramObject)
  {
    HttpRequestContext localHttpRequestContext = HttpRequestContext.getInstance("request-header");
    if (paramObject == null);
    for (String str = null; ; str = paramObject.toString())
      return localHttpRequestContext.getRequestHeader(str);
  }

  public static Map requestHeaderMap()
  {
    return HttpRequestContext.getInstance("request-header-map").getRequestHeaders();
  }

  public static InPort requestInputPort()
  {
    return HttpRequestContext.getInstance("request-input-port").getRequestPort();
  }

  public static InputStream requestInputStream()
  {
    return HttpRequestContext.getInstance("request-input-stream").getRequestStream();
  }

  public static String requestLocal$MnIPAddress()
  {
    return HttpRequestContext.getInstance("request-local-IP-address").getLocalIPAddress();
  }

  public static InetAddress requestLocalHost()
  {
    return HttpRequestContext.getInstance("request-local-host").getLocalHost();
  }

  public static URIPath requestLocalPath()
  {
    return URIPath.makeURI(HttpRequestContext.getInstance("request-local-path").getLocalPath());
  }

  public static int requestLocalPort()
  {
    return HttpRequestContext.getInstance("request-local-port").getLocalPort();
  }

  public static InetSocketAddress requestLocalSocketAddress()
  {
    return HttpRequestContext.getInstance("request-local-socket-address").getLocalSocketAddress();
  }

  public static String requestMethod()
  {
    return HttpRequestContext.getInstance("request-method").getRequestMethod();
  }

  public static String requestParameter(String paramString)
  {
    return requestParameter(paramString, null);
  }

  public static String requestParameter(String paramString, Object paramObject)
  {
    String str = HttpRequestContext.getInstance("request-parameter").getRequestParameter(paramString);
    if (str == null)
    {
      if (paramObject == null)
        return null;
      return paramObject.toString();
    }
    return str;
  }

  public static Map requestParameterMap()
  {
    return HttpRequestContext.getInstance("request-parameter-map").getRequestParameters();
  }

  public static Object requestParameters(String paramString)
  {
    Object localObject = HttpRequestContext.getInstance("request-parameters").getRequestParameters().get(paramString);
    try
    {
      List localList = (List)localObject;
      return Values.make(localList);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "plist", -2, localObject);
    }
  }

  public static String requestPath()
  {
    URIPath localURIPath = URIPath.makeURI(HttpRequestContext.getInstance("request-path").getRequestPath());
    if (localURIPath == null)
      return null;
    return localURIPath.toString();
  }

  public static String requestPathTranslated()
  {
    return HttpRequestContext.getInstance("request-path-translated").getPathTranslated();
  }

  public static Object requestQueryString()
  {
    String str = HttpRequestContext.getInstance("request-query-string").getQueryString();
    if (str == null)
      return Boolean.FALSE;
    return str;
  }

  public static String requestRemote$MnIPAddress()
  {
    return HttpRequestContext.getInstance("request-remote-IP-address").getRemoteIPAddress();
  }

  public static InetAddress requestRemoteHost()
  {
    return HttpRequestContext.getInstance("request-remote-host").getRemoteHost();
  }

  public static int requestRemotePort()
  {
    return HttpRequestContext.getInstance("request-remote-port").getRemotePort();
  }

  public static InetSocketAddress requestRemoteSocketAddress()
  {
    return HttpRequestContext.getInstance("request-remote-socket-address").getRemoteSocketAddress();
  }

  public static String requestScheme()
  {
    return HttpRequestContext.getInstance("request-scheme").getRequestScheme();
  }

  public static URIPath requestScriptPath()
  {
    return URIPath.makeURI(HttpRequestContext.getInstance("request-script-path").getScriptPath());
  }

  public static String requestUri()
  {
    return requestPath();
  }

  public static StringBuffer requestUrl()
  {
    return HttpRequestContext.getInstance("request-path").getRequestURLBuffer();
  }

  public static Object responseContentType(Object paramObject)
  {
    return responseHeader(Lit0, paramObject);
  }

  public static Object responseHeader(Object paramObject1, Object paramObject2)
  {
    return MakeResponseHeader.makeResponseHeader.apply2(paramObject1, paramObject2);
  }

  public static Object responseStatus(int paramInt)
  {
    return responseStatus(paramInt, null);
  }

  public static Object responseStatus(int paramInt, String paramString)
  {
    SimpleSymbol localSimpleSymbol = Lit1;
    Object[] arrayOfObject = new Object[3];
    if (paramString == null);
    for (String str = "~d "; ; str = "~d ~a")
    {
      arrayOfObject[0] = str;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      arrayOfObject[2] = paramString;
      return responseHeader(localSimpleSymbol, Format.formatToString(0, arrayOfObject));
    }
  }

  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (paramModuleMethod.selector)
    {
    case 17:
    case 28:
    case 29:
    case 30:
    default:
      return super.apply0(paramModuleMethod);
    case 7:
      return requestMethod();
    case 8:
      return requestScheme();
    case 9:
      return requestLocalSocketAddress();
    case 10:
      return requestLocal$MnIPAddress();
    case 11:
      return Integer.valueOf(requestLocalPort());
    case 12:
      return requestLocalHost();
    case 13:
      return requestRemoteSocketAddress();
    case 14:
      return requestRemote$MnIPAddress();
    case 15:
      return Integer.valueOf(requestRemotePort());
    case 16:
      return requestRemoteHost();
    case 18:
      return requestHeaderMap();
    case 19:
      return request$MnURI();
    case 20:
      return requestContextPath();
    case 21:
      return requestScriptPath();
    case 22:
      return requestLocalPath();
    case 23:
      return requestPath();
    case 24:
      return requestUri();
    case 25:
      return requestUrl();
    case 26:
      return requestPathTranslated();
    case 27:
      return requestQueryString();
    case 31:
      return requestParameterMap();
    case 32:
      return requestBodyString();
    case 33:
      return requestInputStream();
    case 34:
    }
    return requestInputPort();
  }

  // ERROR //
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 511	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+60->64, 2:+67->71, 3:+72->76, 5:+87->91, 17:+102->106, 28:+107->111, 30:+129->133
    //   65: aload_1
    //   66: aload_2
    //   67: invokespecial 563	gnu/expr/ModuleBody:apply1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: areturn
    //   71: aload_2
    //   72: invokestatic 565	gnu/kawa/servlet/HTTP:responseContentType	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: areturn
    //   76: aload_2
    //   77: checkcast 567	java/lang/Number
    //   80: invokevirtual 570	java/lang/Number:intValue	()I
    //   83: istore 8
    //   85: iload 8
    //   87: invokestatic 572	gnu/kawa/servlet/HTTP:responseStatus	(I)Ljava/lang/Object;
    //   90: areturn
    //   91: aload_2
    //   92: checkcast 567	java/lang/Number
    //   95: invokevirtual 570	java/lang/Number:intValue	()I
    //   98: istore 6
    //   100: iload 6
    //   102: invokestatic 574	gnu/kawa/servlet/HTTP:errorResponse	(I)Ljava/lang/Object;
    //   105: areturn
    //   106: aload_2
    //   107: invokestatic 576	gnu/kawa/servlet/HTTP:requestHeader	(Ljava/lang/Object;)Ljava/lang/String;
    //   110: areturn
    //   111: aload_2
    //   112: ifnonnull +12 -> 124
    //   115: aconst_null
    //   116: astore 4
    //   118: aload 4
    //   120: invokestatic 578	gnu/kawa/servlet/HTTP:requestParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   123: areturn
    //   124: aload_2
    //   125: invokevirtual 360	java/lang/Object:toString	()Ljava/lang/String;
    //   128: astore 4
    //   130: goto -12 -> 118
    //   133: aload_2
    //   134: ifnonnull +10 -> 144
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_3
    //   140: invokestatic 580	gnu/kawa/servlet/HTTP:requestParameters	(Ljava/lang/String;)Ljava/lang/Object;
    //   143: areturn
    //   144: aload_2
    //   145: invokevirtual 360	java/lang/Object:toString	()Ljava/lang/String;
    //   148: astore_3
    //   149: goto -10 -> 139
    //   152: astore 7
    //   154: new 433	gnu/mapping/WrongType
    //   157: dup
    //   158: aload 7
    //   160: ldc 198
    //   162: iconst_1
    //   163: aload_2
    //   164: invokespecial 438	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   167: athrow
    //   168: astore 5
    //   170: new 433	gnu/mapping/WrongType
    //   173: dup
    //   174: aload 5
    //   176: ldc 194
    //   178: iconst_1
    //   179: aload_2
    //   180: invokespecial 438	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   183: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   76	85	152	java/lang/ClassCastException
    //   91	100	168	java/lang/ClassCastException
  }

  // ERROR //
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 511	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+44->48, 1:+52->56, 3:+58->62, 5:+91->95, 28:+124->128
    //   49: aload_1
    //   50: aload_2
    //   51: aload_3
    //   52: invokespecial 583	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: areturn
    //   56: aload_2
    //   57: aload_3
    //   58: invokestatic 324	gnu/kawa/servlet/HTTP:responseHeader	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: areturn
    //   62: aload_2
    //   63: checkcast 567	java/lang/Number
    //   66: invokevirtual 570	java/lang/Number:intValue	()I
    //   69: istore 9
    //   71: aconst_null
    //   72: astore 10
    //   74: aload_3
    //   75: ifnonnull +11 -> 86
    //   78: iload 9
    //   80: aload 10
    //   82: invokestatic 503	gnu/kawa/servlet/HTTP:responseStatus	(ILjava/lang/String;)Ljava/lang/Object;
    //   85: areturn
    //   86: aload_3
    //   87: invokevirtual 360	java/lang/Object:toString	()Ljava/lang/String;
    //   90: astore 10
    //   92: goto -14 -> 78
    //   95: aload_2
    //   96: checkcast 567	java/lang/Number
    //   99: invokevirtual 570	java/lang/Number:intValue	()I
    //   102: istore 6
    //   104: aconst_null
    //   105: astore 7
    //   107: aload_3
    //   108: ifnonnull +11 -> 119
    //   111: iload 6
    //   113: aload 7
    //   115: invokestatic 304	gnu/kawa/servlet/HTTP:errorResponse	(ILjava/lang/String;)Ljava/lang/Object;
    //   118: areturn
    //   119: aload_3
    //   120: invokevirtual 360	java/lang/Object:toString	()Ljava/lang/String;
    //   123: astore 7
    //   125: goto -14 -> 111
    //   128: aload_2
    //   129: ifnonnull +13 -> 142
    //   132: aconst_null
    //   133: astore 4
    //   135: aload 4
    //   137: aload_3
    //   138: invokestatic 406	gnu/kawa/servlet/HTTP:requestParameter	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   141: areturn
    //   142: aload_2
    //   143: invokevirtual 360	java/lang/Object:toString	()Ljava/lang/String;
    //   146: astore 4
    //   148: goto -13 -> 135
    //   151: astore 8
    //   153: new 433	gnu/mapping/WrongType
    //   156: dup
    //   157: aload 8
    //   159: ldc 198
    //   161: iconst_1
    //   162: aload_2
    //   163: invokespecial 438	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   166: athrow
    //   167: astore 5
    //   169: new 433	gnu/mapping/WrongType
    //   172: dup
    //   173: aload 5
    //   175: ldc 194
    //   177: iconst_1
    //   178: aload_2
    //   179: invokespecial 438	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   62	71	151	java/lang/ClassCastException
    //   95	104	167	java/lang/ClassCastException
  }

  public int match0(ModuleMethod paramModuleMethod, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    case 17:
    case 28:
    case 29:
    case 30:
    default:
      return super.match0(paramModuleMethod, paramCallContext);
    case 34:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 33:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 32:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 31:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 27:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 26:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 25:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 24:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 23:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 22:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 21:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 20:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 19:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 18:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 16:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 15:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 14:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 13:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 12:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 11:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 10:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 9:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 8:
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 0;
      return 0;
    case 7:
    }
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 0;
    return 0;
  }

  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match1(paramModuleMethod, paramObject, paramCallContext);
    case 30:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 28:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 17:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 5:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 3:
      paramCallContext.value1 = paramObject;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 1;
      return 0;
    case 2:
    }
    paramCallContext.value1 = paramObject;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 1;
    return 0;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 28:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 5:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 3:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 1:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.servlet.HTTP
 * JD-Core Version:    0.6.2
 */