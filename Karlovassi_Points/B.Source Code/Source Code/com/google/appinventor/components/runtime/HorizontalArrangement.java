package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;

@DesignerComponent(category=ComponentCategory.ARRANGEMENTS, description="<p>A formatting element in which to place components that should be displayed from left to right.  If you wish to have components displayed one over another, use <code>VerticalArrangement</code> instead.</p>", version=2)
@SimpleObject
public class HorizontalArrangement extends HVArrangement
{
  public HorizontalArrangement(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, 0);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.HorizontalArrangement
 * JD-Core Version:    0.6.2
 */