package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.SimpleObject;

@SimpleObject
public abstract class AndroidNonvisibleComponent
  implements Component
{
  protected final Form form;

  protected AndroidNonvisibleComponent(Form paramForm)
  {
    this.form = paramForm;
  }

  public HandlesEventDispatching getDispatchDelegate()
  {
    return this.form;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.AndroidNonvisibleComponent
 * JD-Core Version:    0.6.2
 */