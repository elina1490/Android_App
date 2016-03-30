package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.util.Log;
import com.google.api.client.extensions.android2.AndroidHttp;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.services.GoogleKeyInitializer;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.fusiontables.Fusiontables;
import com.google.api.services.fusiontables.Fusiontables.Builder;
import com.google.api.services.fusiontables.Fusiontables.Query;
import com.google.api.services.fusiontables.Fusiontables.Query.Sql;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.ClientLoginHelper;
import com.google.appinventor.components.runtime.util.IClientLoginHelper;
import com.google.appinventor.components.runtime.util.OAuth2Helper;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;

@DesignerComponent(category=ComponentCategory.EXPERIMENTAL, description="<p>A non-visible component that communicates with Google Fusion Tables. Fusion Tables let you store, share, query and visualize data tables; this component lets you query, create, and modify these tables.</p> <p>This component uses the <a href=\"https://developers.google.com/fusiontables/docs/v1/getting_started\" target=\"_blank\">Fusion Tables API V1.0</a>. <p>In order to develop apps that use Fusiontables, you must obtain an API Key.<p>To get an API key, follow these instructions.</p> <ol><li>Go to your <a href=\"https://code.google.com/apis/console/\" target=\"_blank\">Google APIs Console</a> and login if necessary.</li><li>Select the <i>Services</i> item from the menu on the left.</li><li>Choose the <i>Fusiontables</i> service from the list provided and turn it on.</li><li>Go back to the main menu and select the <i>API Access</i> item. </li></ol><p>Your API Key will be near the bottom of that pane in the section called \"Simple API Access\".You will have to provide that key as the value for the <i>ApiKey</i> property in your Fusiontables app.</p><p>Once you have an API key, set the value of the <i>Query</i> property to a valid Fusiontables SQL query and call <i>SendQuery</i> to execute the query.  App Inventor will send the query to the Fusion Tables server and the <i>GotResult</i> block will fire when a result is returned from the server.Query results will be returned in CSV format, and can be converted to list format using the \"list from csv table\" or \"list from csv row\" blocks.</p><p>Note that you do not need to worry about UTF-encoding the query. But you do need to make sure the query follows the syntax described in <a href=\"https://developers.google.com/fusiontables/docs/v1/getting_started\" target=\"_blank\">the reference manual</a>, which means that things like capitalization for names of columns matters, and that single quotes must be used around column names if there are spaces in them.</p>", iconName="images/fusiontables.png", nonVisible=true, version=2)
@SimpleObject
@UsesLibraries(libraries="fusiontables.jar,google-api-client-beta.jar,google-api-client-android2-beta.jar,google-http-client-beta.jar,google-http-client-android2-beta.jar,google-http-client-android3-beta.jar,google-oauth-client-beta.jar,guava-11.0.1.jar")
@UsesPermissions(permissionNames="android.permission.INTERNET,android.permission.ACCOUNT_MANAGER,android.permission.MANAGE_ACCOUNTS,android.permission.GET_ACCOUNTS,android.permission.USE_CREDENTIALS")
public class FusiontablesControl extends AndroidNonvisibleComponent
  implements Component
{
  public static final String APP_NAME = "App Inventor";
  public static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";
  public static final String AUTH_TOKEN_TYPE_FUSIONTABLES = "oauth2:https://www.googleapis.com/auth/fusiontables";
  private static final String DEFAULT_QUERY = "show tables";
  private static final String DIALOG_TEXT = "Choose an account to access FusionTables";
  public static final String FUSIONTABLES_POST = "https://www.googleapis.com/fusiontables/v1/tables";
  private static final String FUSIONTABLES_SERVICE = "fusiontables";
  public static final String FUSIONTABLES_URL = "https://www.googleapis.com/fusiontables/v1/query";
  private static final String FUSION_QUERY_URL = "http://www.google.com/fusiontables/api/query";
  private static final String LOG_TAG = "fusion";
  private static final int SERVER_TIMEOUT_MS = 30000;
  private final Activity activity;
  private String apiKey;
  private String authTokenType = "oauth2:https://www.googleapis.com/auth/fusiontables";
  private String errorMessage = "Error on Fusiontables query";
  private String query;
  private String queryResultStr;
  private final IClientLoginHelper requestHelper;

  public FusiontablesControl(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.activity = paramComponentContainer.$context();
    this.requestHelper = createClientLoginHelper("Choose an account to access FusionTables", "fusiontables");
    this.query = "show tables";
    if (SdkLevel.getLevel() < 5)
      showNoticeAndDie("Sorry. The Fusiontables component is not compatible with this phone.", "This application must exit.", "Rats!");
  }

  private IClientLoginHelper createClientLoginHelper(String paramString1, String paramString2)
  {
    if (SdkLevel.getLevel() >= 5)
    {
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      HttpConnectionParams.setSoTimeout(localDefaultHttpClient.getParams(), 30000);
      HttpConnectionParams.setConnectionTimeout(localDefaultHttpClient.getParams(), 30000);
      return new ClientLoginHelper(this.activity, paramString2, paramString1, localDefaultHttpClient);
    }
    return null;
  }

  // ERROR //
  private String doPostRequest(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 185	java/lang/String:trim	()Ljava/lang/String;
    //   4: ldc 187
    //   6: invokevirtual 190	java/lang/String:length	()I
    //   9: invokevirtual 194	java/lang/String:substring	(I)Ljava/lang/String;
    //   12: astore_3
    //   13: ldc 56
    //   15: new 196	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   22: ldc 199
    //   24: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_3
    //   28: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 212	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   37: pop
    //   38: new 214	org/apache/http/client/methods/HttpPost
    //   41: dup
    //   42: new 196	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   49: ldc 216
    //   51: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: invokevirtual 219	com/google/appinventor/components/runtime/FusiontablesControl:ApiKey	()Ljava/lang/String;
    //   58: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 222	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   67: astore 5
    //   69: new 224	org/apache/http/entity/StringEntity
    //   72: dup
    //   73: aload_3
    //   74: invokespecial 225	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
    //   77: astore 6
    //   79: aload 6
    //   81: ldc 227
    //   83: invokevirtual 230	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
    //   86: aload 5
    //   88: ldc 232
    //   90: new 196	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   97: ldc 32
    //   99: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokevirtual 236	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload 5
    //   114: aload 6
    //   116: invokevirtual 240	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   119: new 148	org/apache/http/impl/client/DefaultHttpClient
    //   122: dup
    //   123: invokespecial 151	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   126: astore 7
    //   128: aload 7
    //   130: aload 5
    //   132: invokeinterface 244 2 0
    //   137: astore 10
    //   139: aload 10
    //   141: invokeinterface 250 1 0
    //   146: invokeinterface 255 1 0
    //   151: istore 11
    //   153: aload 10
    //   155: ifnull +316 -> 471
    //   158: iload 11
    //   160: sipush 200
    //   163: if_icmpne +308 -> 471
    //   166: aload 10
    //   168: invokestatic 259	com/google/appinventor/components/runtime/FusiontablesControl:httpApacheResponseToString	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   171: astore 15
    //   173: new 261	org/json/JSONObject
    //   176: dup
    //   177: aload 15
    //   179: invokespecial 262	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   182: astore 16
    //   184: aload 16
    //   186: ldc_w 264
    //   189: invokevirtual 268	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   192: ifeq +206 -> 398
    //   195: aload_0
    //   196: new 196	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 270
    //   206: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 16
    //   211: ldc_w 264
    //   214: invokevirtual 274	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   217: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: putfield 131	com/google/appinventor/components/runtime/FusiontablesControl:queryResultStr	Ljava/lang/String;
    //   226: ldc 56
    //   228: new 196	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 279
    //   238: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 10
    //   243: invokeinterface 250 1 0
    //   248: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 212	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: ldc 56
    //   260: new 196	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   267: ldc_w 281
    //   270: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_1
    //   274: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc_w 283
    //   280: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_0
    //   284: getfield 131	com/google/appinventor/components/runtime/FusiontablesControl:queryResultStr	Ljava/lang/String;
    //   287: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 212	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   296: pop
    //   297: aload_0
    //   298: getfield 131	com/google/appinventor/components/runtime/FusiontablesControl:queryResultStr	Ljava/lang/String;
    //   301: areturn
    //   302: astore 19
    //   304: aload 19
    //   306: invokevirtual 286	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   309: new 196	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 288
    //   319: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 19
    //   324: invokevirtual 291	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   327: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: areturn
    //   334: astore 9
    //   336: aload 9
    //   338: invokevirtual 292	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   341: new 196	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 288
    //   351: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload 9
    //   356: invokevirtual 293	org/apache/http/client/ClientProtocolException:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: areturn
    //   366: astore 8
    //   368: aload 8
    //   370: invokevirtual 294	java/io/IOException:printStackTrace	()V
    //   373: new 196	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 288
    //   383: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 8
    //   388: invokevirtual 295	java/io/IOException:getMessage	()Ljava/lang/String;
    //   391: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: areturn
    //   398: aload_0
    //   399: aload 15
    //   401: putfield 131	com/google/appinventor/components/runtime/FusiontablesControl:queryResultStr	Ljava/lang/String;
    //   404: goto -178 -> 226
    //   407: astore 14
    //   409: aload 14
    //   411: invokevirtual 296	java/lang/IllegalStateException:printStackTrace	()V
    //   414: new 196	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 288
    //   424: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 14
    //   429: invokevirtual 297	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   432: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: areturn
    //   439: astore 13
    //   441: aload 13
    //   443: invokevirtual 298	org/json/JSONException:printStackTrace	()V
    //   446: new 196	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 288
    //   456: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 13
    //   461: invokevirtual 299	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   464: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: areturn
    //   471: ldc 56
    //   473: new 196	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   480: ldc_w 288
    //   483: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: aload 10
    //   488: invokeinterface 250 1 0
    //   493: invokevirtual 302	java/lang/Object:toString	()Ljava/lang/String;
    //   496: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 212	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   505: pop
    //   506: aload_0
    //   507: aload 10
    //   509: invokeinterface 250 1 0
    //   514: invokevirtual 302	java/lang/Object:toString	()Ljava/lang/String;
    //   517: putfield 131	com/google/appinventor/components/runtime/FusiontablesControl:queryResultStr	Ljava/lang/String;
    //   520: goto -223 -> 297
    //
    // Exception table:
    //   from	to	target	type
    //   69	79	302	java/io/UnsupportedEncodingException
    //   128	139	334	org/apache/http/client/ClientProtocolException
    //   128	139	366	java/io/IOException
    //   166	226	407	java/lang/IllegalStateException
    //   398	404	407	java/lang/IllegalStateException
    //   166	226	439	org/json/JSONException
    //   398	404	439	org/json/JSONException
  }

  private HttpUriRequest genFusiontablesQuery(String paramString)
    throws IOException
  {
    HttpPost localHttpPost = new HttpPost("http://www.google.com/fusiontables/api/query");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new BasicNameValuePair("sql", paramString));
    UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(localArrayList, "UTF-8");
    localUrlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
    localHttpPost.setEntity(localUrlEncodedFormEntity);
    return localHttpPost;
  }

  public static String httpApacheResponseToString(org.apache.http.HttpResponse paramHttpResponse)
  {
    String str1 = "";
    if (paramHttpResponse != null)
    {
      if (paramHttpResponse.getStatusLine().getStatusCode() != 200)
        str1 = paramHttpResponse.getStatusLine().getStatusCode() + " " + paramHttpResponse.getStatusLine().getReasonPhrase();
    }
    else
      return str1;
    try
    {
      String str2 = parseResponse(paramHttpResponse.getEntity().getContent());
      return str2;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return str1;
  }

  public static String httpResponseToString(com.google.api.client.http.HttpResponse paramHttpResponse)
  {
    String str1 = "";
    if (paramHttpResponse != null)
    {
      if (paramHttpResponse.getStatusCode() != 200)
        str1 = paramHttpResponse.getStatusCode() + " " + paramHttpResponse.getStatusMessage();
    }
    else
      return str1;
    try
    {
      String str2 = parseResponse(paramHttpResponse.getContent());
      return str2;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return str1;
  }

  public static String parseResponse(InputStream paramInputStream)
  {
    String str1 = "";
    BufferedReader localBufferedReader;
    StringBuilder localStringBuilder;
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      localStringBuilder = new StringBuilder();
      while (true)
      {
        String str2 = localBufferedReader.readLine();
        if (str2 == null)
          break;
        localStringBuilder.append(str2 + "\n");
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return str1;
    }
    str1 = localStringBuilder.toString();
    Log.i("fusion", "resultStr = " + str1);
    localBufferedReader.close();
    return str1;
  }

  private String parseSqlCreateQueryToJson(String paramString)
  {
    Log.i("fusion", "parsetoJSonSqlCreate :" + paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = paramString.trim();
    String str2 = str1.substring("create table".length(), str1.indexOf('(')).trim();
    String[] arrayOfString1 = str1.substring(1 + str1.indexOf('('), str1.indexOf(')')).split(",");
    localStringBuilder.append("{'columns':[");
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      String[] arrayOfString2 = arrayOfString1[i].split(":");
      localStringBuilder.append("{'name': '" + arrayOfString2[0].trim() + "', 'type': '" + arrayOfString2[1].trim() + "'}");
      if (i < arrayOfString1.length - 1)
        localStringBuilder.append(",");
    }
    localStringBuilder.append("],");
    localStringBuilder.append("'isExportable':'true',");
    localStringBuilder.append("'name': '" + str2 + "'");
    localStringBuilder.append("}");
    localStringBuilder.insert(0, "CREATE TABLE ");
    Log.i("fusion", "result = " + localStringBuilder.toString());
    return localStringBuilder.toString();
  }

  private void showNoticeAndDie(String paramString1, String paramString2, String paramString3)
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this.activity).create();
    localAlertDialog.setTitle(paramString2);
    localAlertDialog.setCancelable(false);
    localAlertDialog.setMessage(paramString1);
    localAlertDialog.setButton(paramString3, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        FusiontablesControl.this.activity.finish();
      }
    });
    localAlertDialog.show();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Your Google API Key. For help, click on the questionmark (?) next to the FusiontablesControl component in the Palette. ")
  public String ApiKey()
  {
    return this.apiKey;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void ApiKey(String paramString)
  {
    this.apiKey = paramString;
  }

  @SimpleFunction(description="DEPRECATED. This block will be deprecated by the end of 2012.  Use SendQuery.")
  public void DoQuery()
  {
    if (this.requestHelper != null)
    {
      QueryProcessor localQueryProcessor = new QueryProcessor(null);
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.query;
      localQueryProcessor.execute(arrayOfString);
      return;
    }
    this.form.dispatchErrorOccurredEvent(this, "DoQuery", 3, new Object[0]);
  }

  @SimpleFunction
  public void ForgetLogin()
  {
    OAuth2Helper.resetAccountCredential(this.activity);
  }

  @SimpleEvent(description="Indicates that the Fusion Tables query has finished processing, with a result.  The result of the query will generally be returned in CSV format, and can be converted to list format using the \"list from csv table\" or \"list from csv row\" blocks.")
  public void GotResult(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "GotResult", new Object[] { paramString });
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The query to send to the Fusion Tables API. <p>For legal query formats and examples, see the <a href=\"https://developers.google.com/fusiontables/docs/v1/getting_started\" target=\"_blank\">Fusion Tables API v1.0 reference manual</a>.</p> <p>Note that you do not need to worry about UTF-encoding the query. But you do need to make sure it follows the syntax described in the reference manual, which means that things like capitalization for names of columns matters, and that single quotes need to be used around column names if there are spaces in them.</p> ")
  public String Query()
  {
    return this.query;
  }

  @DesignerProperty(defaultValue="show tables", editorType="string")
  @SimpleProperty
  public void Query(String paramString)
  {
    this.query = paramString;
  }

  @SimpleFunction(description="Send the query to the Fusiontables server.")
  public void SendQuery()
  {
    QueryProcessorV1 localQueryProcessorV1 = new QueryProcessorV1(this.activity);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.query;
    localQueryProcessorV1.execute(arrayOfString);
  }

  public void handleOAuthError(String paramString)
  {
    Log.i("fusion", "handleOAuthError: " + paramString);
    this.errorMessage = paramString;
  }

  public com.google.api.client.http.HttpResponse sendQuery(String paramString1, String paramString2)
  {
    Log.i("fusion", "executing " + paramString1);
    Fusiontables localFusiontables = new Fusiontables.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), new GoogleCredential()).setApplicationName("App Inventor Fusiontables/v1.0").setJsonHttpRequestInitializer(new GoogleKeyInitializer(ApiKey())).build();
    try
    {
      Fusiontables.Query.Sql localSql = localFusiontables.query().sql(paramString1);
      localSql.put("alt", "csv");
      localSql.setOauthToken(paramString2);
      com.google.api.client.http.HttpResponse localHttpResponse = localSql.executeUnparsed();
      return localHttpResponse;
    }
    catch (GoogleJsonResponseException localGoogleJsonResponseException)
    {
      localGoogleJsonResponseException.printStackTrace();
      this.errorMessage = localGoogleJsonResponseException.getMessage();
      return null;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      this.errorMessage = localIOException.getMessage();
    }
    return null;
  }

  private class QueryProcessor extends AsyncTask<String, Void, String>
  {
    private ProgressDialog progress = null;

    private QueryProcessor()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      try
      {
        HttpUriRequest localHttpUriRequest = FusiontablesControl.this.genFusiontablesQuery(paramArrayOfString[0]);
        Log.d("fusion", "Fetching: " + paramArrayOfString[0]);
        org.apache.http.HttpResponse localHttpResponse = FusiontablesControl.this.requestHelper.execute(localHttpUriRequest);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localHttpResponse.getEntity().writeTo(localByteArrayOutputStream);
        Log.d("fusion", "Response: " + localHttpResponse.getStatusLine().toString());
        String str = localByteArrayOutputStream.toString();
        return str;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return localIOException.getMessage();
      }
    }

    protected void onPostExecute(String paramString)
    {
      this.progress.dismiss();
      FusiontablesControl.this.GotResult(paramString);
    }

    protected void onPreExecute()
    {
      this.progress = ProgressDialog.show(FusiontablesControl.this.activity, "Fusiontables", "processing query...", true);
    }
  }

  private class QueryProcessorV1 extends AsyncTask<String, Void, String>
  {
    private static final String TAG = "QueryProcessorV1";
    private final Activity activity;
    private final ProgressDialog dialog;

    QueryProcessorV1(Activity arg2)
    {
      Log.i("QueryProcessorV1", "Creating AsyncFusiontablesQuery");
      Context localContext;
      this.activity = localContext;
      this.dialog = new ProgressDialog(localContext);
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      Log.i("QueryProcessorV1", "Starting doInBackground " + paramArrayOfString[0]);
      String str1 = paramArrayOfString[0];
      FusiontablesControl.access$402(FusiontablesControl.this, "");
      String str2 = new OAuth2Helper().getRefreshedAuthToken(this.activity, FusiontablesControl.this.authTokenType);
      if (str2 != null)
      {
        if (str1.toLowerCase().contains("create table"))
        {
          FusiontablesControl.access$402(FusiontablesControl.this, FusiontablesControl.this.doPostRequest(FusiontablesControl.access$600(FusiontablesControl.this, str1), str2));
          return FusiontablesControl.this.queryResultStr;
        }
        com.google.api.client.http.HttpResponse localHttpResponse = FusiontablesControl.this.sendQuery(str1, str2);
        if (localHttpResponse != null)
        {
          FusiontablesControl.access$402(FusiontablesControl.this, FusiontablesControl.httpResponseToString(localHttpResponse));
          Log.i("QueryProcessorV1", "Query = " + str1 + "\nResultStr = " + FusiontablesControl.this.queryResultStr);
        }
        while (true)
        {
          return FusiontablesControl.this.queryResultStr;
          FusiontablesControl.access$402(FusiontablesControl.this, FusiontablesControl.this.errorMessage);
          Log.i("QueryProcessorV1", "Error:  " + FusiontablesControl.this.errorMessage);
        }
      }
      return OAuth2Helper.getErrorMessage();
    }

    protected void onPostExecute(String paramString)
    {
      Log.i("fusion", "Query result " + paramString);
      if (paramString == null)
        paramString = "Error";
      this.dialog.dismiss();
      FusiontablesControl.this.GotResult(paramString);
    }

    protected void onPreExecute()
    {
      this.dialog.setMessage("Fusiontables...");
      this.dialog.show();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.FusiontablesControl
 * JD-Core Version:    0.6.2
 */