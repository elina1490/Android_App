package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.view.View;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.util.AlignmentUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;

@SimpleObject
public class HVArrangement extends AndroidViewComponent
  implements Component, ComponentContainer
{
  private final AlignmentUtil alignmentSetter;
  private final Activity context;
  private int horizontalAlignment;
  private final int orientation;
  private int verticalAlignment;
  private final LinearLayout viewLayout;

  public HVArrangement(ComponentContainer paramComponentContainer, int paramInt)
  {
    super(paramComponentContainer);
    this.context = paramComponentContainer.$context();
    this.orientation = paramInt;
    this.viewLayout = new LinearLayout(this.context, paramInt, Integer.valueOf(100), Integer.valueOf(100));
    this.alignmentSetter = new AlignmentUtil(this.viewLayout);
    this.horizontalAlignment = 1;
    this.verticalAlignment = 1;
    this.alignmentSetter.setHorizontalAlignment(this.horizontalAlignment);
    this.alignmentSetter.setVerticalAlignment(this.verticalAlignment);
    paramComponentContainer.$add(this);
  }

  public void $add(AndroidViewComponent paramAndroidViewComponent)
  {
    this.viewLayout.add(paramAndroidViewComponent);
  }

  public Activity $context()
  {
    return this.context;
  }

  public Form $form()
  {
    return this.container.$form();
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="A number that encodes how contents of the arrangement are aligned  horizontally. The choices are: 1 = left aligned, 2 = horizontally centered,  3 = right aligned.  Alignment has no effect with the arrangement's width is automatic.")
  public int AlignHorizontal()
  {
    return this.horizontalAlignment;
  }

  @DesignerProperty(defaultValue="1", editorType="horizontal_alignment")
  @SimpleProperty
  public void AlignHorizontal(int paramInt)
  {
    try
    {
      this.alignmentSetter.setHorizontalAlignment(paramInt);
      this.horizontalAlignment = paramInt;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Form localForm = this.container.$form();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localForm.dispatchErrorOccurredEvent(this, "HorizontalAlignment", 1401, arrayOfObject);
    }
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="A number that encodes how the contents of the arrangement are aligned  vertically. The choices are: 1 = aligned at the top, 2 = vertically centered, 3 = aligned at the bottom.  Alignment has no effect if the arrangement's height is automatic.")
  public int AlignVertical()
  {
    return this.verticalAlignment;
  }

  @DesignerProperty(defaultValue="1", editorType="vertical_alignment")
  @SimpleProperty
  public void AlignVertical(int paramInt)
  {
    try
    {
      this.alignmentSetter.setVerticalAlignment(paramInt);
      this.verticalAlignment = paramInt;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Form localForm = this.container.$form();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localForm.dispatchErrorOccurredEvent(this, "VerticalAlignment", 1402, arrayOfObject);
    }
  }

  public View getView()
  {
    return this.viewLayout.getLayoutManager();
  }

  public void setChildHeight(AndroidViewComponent paramAndroidViewComponent, int paramInt)
  {
    if (this.orientation == 0)
    {
      ViewUtil.setChildHeightForHorizontalLayout(paramAndroidViewComponent.getView(), paramInt);
      return;
    }
    ViewUtil.setChildHeightForVerticalLayout(paramAndroidViewComponent.getView(), paramInt);
  }

  public void setChildWidth(AndroidViewComponent paramAndroidViewComponent, int paramInt)
  {
    if (this.orientation == 0)
    {
      ViewUtil.setChildWidthForHorizontalLayout(paramAndroidViewComponent.getView(), paramInt);
      return;
    }
    ViewUtil.setChildWidthForVerticalLayout(paramAndroidViewComponent.getView(), paramInt);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.HVArrangement
 * JD-Core Version:    0.6.2
 */