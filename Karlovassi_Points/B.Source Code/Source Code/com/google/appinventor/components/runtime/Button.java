package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;

@DesignerComponent(category=ComponentCategory.BASIC, description="Button with the ability to detect clicks.  Many aspects of its appearance can be changed, as well as whether it is clickable (<code>Enabled</code>), can be changed in the Designer or in the Blocks Editor.", version=4)
@SimpleObject
public final class Button extends ButtonBase
{
  public Button(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer);
  }

  @SimpleEvent
  public void Click()
  {
    EventDispatcher.dispatchEvent(this, "Click", new Object[0]);
  }

  @SimpleEvent
  public boolean LongClick()
  {
    return EventDispatcher.dispatchEvent(this, "LongClick", new Object[0]);
  }

  public void click()
  {
    Click();
  }

  public boolean longClick()
  {
    return LongClick();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Button
 * JD-Core Version:    0.6.2
 */