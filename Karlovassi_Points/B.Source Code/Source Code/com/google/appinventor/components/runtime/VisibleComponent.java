package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;

@SimpleObject
public abstract class VisibleComponent
  implements Component
{
  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public abstract int Height();

  @SimpleProperty
  public abstract void Height(int paramInt);

  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public abstract int Width();

  @SimpleProperty
  public abstract void Width(int paramInt);
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.VisibleComponent
 * JD-Core Version:    0.6.2
 */