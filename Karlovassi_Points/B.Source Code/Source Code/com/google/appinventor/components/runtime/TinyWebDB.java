package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.WebServiceUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

@DesignerComponent(category=ComponentCategory.MISC, description="Non-visible component that communicates with a Web service to store and retrieve information.", iconName="images/tinyWebDB.png", nonVisible=true, version=2)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET")
public class TinyWebDB extends AndroidNonvisibleComponent
  implements Component
{
  private static final String GETVALUE_COMMAND = "getvalue";
  private static final String LOG_TAG = "TinyWebDB";
  private static final String STOREAVALUE_COMMAND = "storeavalue";
  private static final String TAG_PARAMETER = "tag";
  private static final String VALUE_PARAMETER = "value";
  private Handler androidUIHandler = new Handler();
  private String serviceURL = "http://appinvtinywebdb.appspot.com/";

  public TinyWebDB(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
  }

  private void postGetValue(final String paramString)
  {
    AsyncCallbackPair local4 = new AsyncCallbackPair()
    {
      public void onFailure(final String paramAnonymousString)
      {
        TinyWebDB.this.androidUIHandler.post(new Runnable()
        {
          public void run()
          {
            TinyWebDB.this.WebServiceError(paramAnonymousString);
          }
        });
      }

      public void onSuccess(JSONArray paramAnonymousJSONArray)
      {
        if (paramAnonymousJSONArray == null)
        {
          TinyWebDB.this.androidUIHandler.post(new Runnable()
          {
            public void run()
            {
              TinyWebDB.this.WebServiceError("The Web server did not respond to the get value request for the tag " + TinyWebDB.4.this.val$tag + ".");
            }
          });
          return;
        }
        while (true)
        {
          String str2;
          try
          {
            final String str1 = paramAnonymousJSONArray.getString(1);
            str2 = paramAnonymousJSONArray.getString(2);
            if (str2.length() == 0)
            {
              localObject1 = "";
              TinyWebDB.this.androidUIHandler.post(new Runnable()
              {
                public void run()
                {
                  TinyWebDB.this.GotValue(str1, localObject1);
                }
              });
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            TinyWebDB.this.androidUIHandler.post(new Runnable()
            {
              public void run()
              {
                TinyWebDB.this.WebServiceError("The Web server returned a garbled value for the tag " + TinyWebDB.4.this.val$tag + ".");
              }
            });
            return;
          }
          Object localObject2 = JsonUtil.getObjectFromJson(str2);
          final Object localObject1 = localObject2;
        }
      }
    };
    WebServiceUtil localWebServiceUtil = WebServiceUtil.getInstance();
    String str = this.serviceURL;
    NameValuePair[] arrayOfNameValuePair = new NameValuePair[1];
    arrayOfNameValuePair[0] = new BasicNameValuePair("tag", paramString);
    localWebServiceUtil.postCommandReturningArray(str, "getvalue", Lists.newArrayList(arrayOfNameValuePair), local4);
  }

  private void postStoreValue(String paramString, Object paramObject)
  {
    AsyncCallbackPair local2 = new AsyncCallbackPair()
    {
      public void onFailure(final String paramAnonymousString)
      {
        TinyWebDB.this.androidUIHandler.post(new Runnable()
        {
          public void run()
          {
            TinyWebDB.this.WebServiceError(paramAnonymousString);
          }
        });
      }

      public void onSuccess(String paramAnonymousString)
      {
        TinyWebDB.this.androidUIHandler.post(new Runnable()
        {
          public void run()
          {
            TinyWebDB.this.ValueStored();
          }
        });
      }
    };
    try
    {
      WebServiceUtil localWebServiceUtil = WebServiceUtil.getInstance();
      String str = this.serviceURL;
      NameValuePair[] arrayOfNameValuePair = new NameValuePair[2];
      arrayOfNameValuePair[0] = new BasicNameValuePair("tag", paramString);
      arrayOfNameValuePair[1] = new BasicNameValuePair("value", JsonUtil.getJsonRepresentation(paramObject));
      localWebServiceUtil.postCommand(str, "storeavalue", Lists.newArrayList(arrayOfNameValuePair), local2);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
    throw new YailRuntimeError("Value failed to convert to JSON.", "JSON Creation Error.");
  }

  @SimpleFunction
  public void GetValue(final String paramString)
  {
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        TinyWebDB.this.postGetValue(paramString);
      }
    });
  }

  @SimpleEvent
  public void GotValue(String paramString, Object paramObject)
  {
    EventDispatcher.dispatchEvent(this, "GotValue", new Object[] { paramString, paramObject });
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ServiceURL()
  {
    return this.serviceURL;
  }

  @DesignerProperty(defaultValue="http://appinvtinywebdb.appspot.com", editorType="string")
  @SimpleProperty
  public void ServiceURL(String paramString)
  {
    this.serviceURL = paramString;
  }

  @SimpleFunction
  public void StoreValue(final String paramString, final Object paramObject)
  {
    AsynchUtil.runAsynchronously(new Runnable()
    {
      public void run()
      {
        TinyWebDB.this.postStoreValue(paramString, paramObject);
      }
    });
  }

  @SimpleEvent
  public void ValueStored()
  {
    EventDispatcher.dispatchEvent(this, "ValueStored", new Object[0]);
  }

  @SimpleEvent
  public void WebServiceError(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "WebServiceError", new Object[] { paramString });
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.TinyWebDB
 * JD-Core Version:    0.6.2
 */