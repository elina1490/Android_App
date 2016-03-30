package com.google.appinventor.components.runtime;

import android.widget.AutoCompleteTextView;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.SdkLevel;

@DesignerComponent(category=ComponentCategory.SOCIAL, description="<p>A text box in which a user can begin entering an email address of a contact and be offered auto-completion.  The initial value of the box and the value after user entry is in the <code>Text</code> property.  If the <code>Text</code> property is initially empty, the contents of the <code>Hint</code> property will be faintly shown in the text box as a hint to the user.</p> <p>Other properties affect the appearance of the text box (<code>TextAlignment</code>, <code>BackgroundColor</code>, etc.) and whether it can be used (<code>Enabled</code>).</p><p>Text boxes are usually used with the <code>Button</code> component, with the user clicking on the button when text entry is complete.</p>", version=2)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.READ_CONTACTS")
public class EmailPicker extends TextBoxBase
{
  private final EmailAddressAdapter addressAdapter;

  public EmailPicker(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, new AutoCompleteTextView(paramComponentContainer.$context()));
    this.addressAdapter = new EmailAddressAdapter(paramComponentContainer.$context());
    ((AutoCompleteTextView)this.view).setAdapter(this.addressAdapter);
  }

  @SimpleEvent
  public void GotFocus()
  {
    if (SdkLevel.getLevel() > 4)
      this.container.$form().dispatchErrorOccurredEvent(this, "GotFocus", 2, new Object[0]);
    EventDispatcher.dispatchEvent(this, "GotFocus", new Object[0]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.EmailPicker
 * JD-Core Version:    0.6.2
 */