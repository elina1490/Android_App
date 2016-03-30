package com.google.appinventor.components.runtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.JsonUtil;
import org.json.JSONException;

@DesignerComponent(category=ComponentCategory.BASIC, description="Non-visible component that persistently stores values on the phone.", iconName="images/tinyDB.png", nonVisible=true, version=1)
@SimpleObject
public class TinyDB extends AndroidNonvisibleComponent
  implements Component, Deleteable
{
  private SharedPreferences sharedPreferences;

  public TinyDB(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.sharedPreferences = paramComponentContainer.$context().getSharedPreferences("TinyDB", 0);
  }

  @SimpleFunction
  public Object GetValue(String paramString)
  {
    try
    {
      String str = this.sharedPreferences.getString(paramString, "");
      if (str.length() == 0)
        return "";
      Object localObject = JsonUtil.getObjectFromJson(str);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
    }
    throw new YailRuntimeError("Value failed to convert from JSON.", "JSON Creation Error.");
  }

  @SimpleFunction
  public void StoreValue(String paramString, Object paramObject)
  {
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    try
    {
      localEditor.putString(paramString, JsonUtil.getJsonRepresentation(paramObject));
      localEditor.commit();
      return;
    }
    catch (JSONException localJSONException)
    {
    }
    throw new YailRuntimeError("Value failed to convert to JSON.", "JSON Creation Error.");
  }

  public void onDelete()
  {
    SharedPreferences.Editor localEditor = this.sharedPreferences.edit();
    localEditor.clear();
    localEditor.commit();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.TinyDB
 * JD-Core Version:    0.6.2
 */