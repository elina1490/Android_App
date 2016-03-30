package com.google.appinventor.components.runtime;

import android.content.Context;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.PhoneCallUtil;

@DesignerComponent(category=ComponentCategory.SOCIAL, description="<p>A non-visible component that makes a phone call to the number specified in the <code>PhoneNumber</code> property, which can be set either in the Designer or Blocks Editor. The component has a <code>MakePhoneCall</code> method, enabling the program to launch a phone call.</p><p>Often, this component is used with the <code>ContactPicker</code> component, which lets the user select a contact from the ones stored on the phone and sets the <code>PhoneNumber</code> property to the contact's phone number.</p><p>To directly specify the phone number (e.g., 650-555-1212), set the <code>PhoneNumber</code> property to a Text with the specified digits (e.g., \"6505551212\").  Dashes, dots, and parentheses may be included (e.g., \"(650)-555-1212\") but will be ignored; spaces may not be included.</p>", iconName="images/phoneCall.png", nonVisible=true, version=1)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.CALL_PHONE")
public class PhoneCall extends AndroidNonvisibleComponent
  implements Component
{
  private final Context context;
  private String phoneNumber;

  public PhoneCall(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.context = paramComponentContainer.$context();
    PhoneNumber("");
  }

  @SimpleFunction
  public void MakePhoneCall()
  {
    PhoneCallUtil.makePhoneCall(this.context, this.phoneNumber);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String PhoneNumber()
  {
    return this.phoneNumber;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void PhoneNumber(String paramString)
  {
    this.phoneNumber = paramString;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.PhoneCall
 * JD-Core Version:    0.6.2
 */