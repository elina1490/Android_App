package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.AnimationUtil;

@DesignerComponent(category=ComponentCategory.MISC, description="<p>A component that can launch an activity using the <code>StartActivity</code> method.</p><p>Activities that can be launched include:<ul> <li> Starting another App Inventor for Android app.  To do so, first      find out the <em>class</em> of the other application by      downloading the source code and using a file explorer or unzip      utility to find a file named      \"youngandroidproject/project.properties\".  The first line of      the file will start with \"main=\" and be followed by the class      name; for example,      <code>main=com.gmail.Bitdiddle.Ben.HelloPurr.Screen1</code>.       (The first components indicate that it was created by      Ben.Bitdiddle@gmail.com.)  To make your      <code>ActivityStarter</code> launch this application, set the      following properties: <ul>      <li> <code>ActivityPackage</code> to the class name, dropping the           last component (for example,           <code>com.gmail.Bitdiddle.Ben.HelloPurr</code>)</li>      <li> <code>ActivityClass</code> to the entire class name (for           example,           <code>com.gmail.Bitdiddle.Ben.HelloPurr.Screen1</code>)</li>      </ul></li><li> Starting the camera application by setting the following      properties:<ul>      <li> <code>Action: android.intent.action.MAIN</code> </li>      <li> <code>ActivityPackage: com.android.camera</code> </li>      <li> <code>ActivityClass: com.android.camera.Camera</code></li>      </ul></li><li> Performing web search.  Assuming the term you want to search      for is \"vampire\" (feel free to substitute your own choice),      set the properties to:<blockquote><code>      Action: android.intent.action.WEB_SEARCH<br/>      ExtraKey: query<br/>      ExtraValue: vampire<br/>      ActivityPackage: com.google.android.providers.enhancedgooglesearch<br/>     ActivityClass: com.google.android.providers.enhancedgooglesearch.Launcher<br/>      </code></blockquote></li> <li> Opening a browser to a specified web page.  Assuming the page you      want to go to is \"www.facebook.com\" (feel free to substitute      your own choice), set the properties to: <blockquote><code>      Action: android.intent.action.VIEW <br/>      DataUri: http://www.facebook.com </code> </blockquote> </li> </ul></p>", designerHelpDescription="<p>A component that can launch an activity using the <code>StartActivity</code> method.</p><p>Activities that can be launched include:<ul> <li> starting other App Inventor for Android apps </li> <li> starting the camera application </li> <li> performing web search </li> <li> opening a browser to a specified web page</li> <li> opening the map application to a specified location</li></ul> You can also launch activities that return text data.  See the documentation on using the Activity Starter for examples.</p>", iconName="images/activityStarter.png", nonVisible=true, version=4)
@SimpleObject
public class ActivityStarter extends AndroidNonvisibleComponent
  implements ActivityResultListener, Component, Deleteable
{
  private String action;
  private String activityClass;
  private String activityPackage;
  private final ComponentContainer container;
  private String dataType;
  private String dataUri;
  private String extraKey;
  private String extraValue;
  private int requestCode;
  private String result;
  private Intent resultIntent;
  private String resultName;

  public ActivityStarter(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.container = paramComponentContainer;
    this.result = "";
    Action("android.intent.action.MAIN");
    ActivityPackage("");
    ActivityClass("");
    DataUri("");
    DataType("");
    ExtraKey("");
    ExtraValue("");
    ResultName("");
  }

  private Intent buildActivityIntent()
  {
    Uri localUri;
    Intent localIntent;
    if (this.dataUri.length() != 0)
    {
      localUri = Uri.parse(this.dataUri);
      if (localUri == null)
        break label139;
      localIntent = new Intent(this.action, localUri);
      label35: if (this.dataType.length() != 0)
      {
        if (localUri == null)
          break label154;
        localIntent.setDataAndType(localUri, this.dataType);
      }
    }
    while (true)
    {
      if ((this.activityPackage.length() != 0) || (this.activityClass.length() != 0))
        localIntent.setComponent(new ComponentName(this.activityPackage, this.activityClass));
      if ((this.extraKey.length() != 0) && (this.extraValue.length() != 0))
        localIntent.putExtra(this.extraKey, this.extraValue);
      return localIntent;
      localUri = null;
      break;
      label139: localIntent = new Intent(this.action);
      break label35;
      label154: localIntent.setType(this.dataType);
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String Action()
  {
    return this.action;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void Action(String paramString)
  {
    this.action = paramString.trim();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ActivityClass()
  {
    return this.activityClass;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void ActivityClass(String paramString)
  {
    this.activityClass = paramString.trim();
  }

  @SimpleEvent(description="The ActivityError event is no longer used. Please use the Screen.ErrorOccurred event instead.", userVisible=false)
  public void ActivityError(String paramString)
  {
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ActivityPackage()
  {
    return this.activityPackage;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void ActivityPackage(String paramString)
  {
    this.activityPackage = paramString.trim();
  }

  @SimpleEvent(description="Event raised after this ActivityStarter returns.")
  public void AfterActivity(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "AfterActivity", new Object[] { paramString });
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String DataType()
  {
    return this.dataType;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void DataType(String paramString)
  {
    this.dataType = paramString.trim();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String DataUri()
  {
    return this.dataUri;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void DataUri(String paramString)
  {
    this.dataUri = paramString.trim();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ExtraKey()
  {
    return this.extraKey;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void ExtraKey(String paramString)
  {
    this.extraKey = paramString.trim();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ExtraValue()
  {
    return this.extraValue;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void ExtraValue(String paramString)
  {
    this.extraValue = paramString.trim();
  }

  @SimpleFunction(description="Returns the name of the activity that corresponds to this ActivityStarer, or an empty string if no corresponding activity can be found.")
  public String ResolveActivity()
  {
    Intent localIntent = buildActivityIntent();
    ResolveInfo localResolveInfo = this.container.$context().getPackageManager().resolveActivity(localIntent, 0);
    if ((localResolveInfo != null) && (localResolveInfo.activityInfo != null))
      return localResolveInfo.activityInfo.name;
    return "";
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String Result()
  {
    return this.result;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ResultName()
  {
    return this.resultName;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void ResultName(String paramString)
  {
    this.resultName = paramString.trim();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ResultType()
  {
    if (this.resultIntent != null)
    {
      String str = this.resultIntent.getType();
      if (str != null)
        return str;
    }
    return "";
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ResultUri()
  {
    if (this.resultIntent != null)
    {
      String str = this.resultIntent.getDataString();
      if (str != null)
        return str;
    }
    return "";
  }

  @SimpleFunction(description="Start the activity corresponding to this ActivityStarter.")
  public void StartActivity()
  {
    this.resultIntent = null;
    this.result = "";
    Intent localIntent = buildActivityIntent();
    if (this.requestCode == 0)
      this.requestCode = this.form.registerForActivityResult(this);
    try
    {
      this.container.$context().startActivityForResult(localIntent, this.requestCode);
      String str = this.container.$form().getOpenAnimType();
      AnimationUtil.ApplyOpenScreenAnimation(this.container.$context(), str);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      this.form.dispatchErrorOccurredEvent(this, "StartActivity", 601, new Object[0]);
    }
  }

  public void onDelete()
  {
    this.form.unregisterForActivityResult(this);
  }

  public void resultReturned(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == this.requestCode)
    {
      Log.i("ActivityStarter", "resultReturned - resultCode = " + paramInt2);
      if (paramInt2 == -1)
      {
        this.resultIntent = paramIntent;
        if ((this.resultName.length() == 0) || (this.resultIntent == null) || (!this.resultIntent.hasExtra(this.resultName)))
          break label100;
      }
    }
    label100: for (this.result = this.resultIntent.getStringExtra(this.resultName); ; this.result = "")
    {
      AfterActivity(this.result);
      return;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.ActivityStarter
 * JD-Core Version:    0.6.2
 */