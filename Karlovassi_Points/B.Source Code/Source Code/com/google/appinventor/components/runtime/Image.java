package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;

@DesignerComponent(category=ComponentCategory.BASIC, description="Component for displaying images.  The picture to display, and other aspects of the Image's appearance, can be specified in the Designer or in the Blocks Editor.", version=1)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET")
public final class Image extends AndroidViewComponent
{
  private String picturePath = "";
  private final ImageView view;

  public Image(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer);
    this.view = new ImageView(paramComponentContainer.$context())
    {
      public boolean verifyDrawable(Drawable paramAnonymousDrawable)
      {
        super.verifyDrawable(paramAnonymousDrawable);
        return true;
      }
    };
    paramComponentContainer.$add(this);
    this.view.setFocusable(true);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public void Animation(String paramString)
  {
    AnimationUtil.ApplyAnimation(this.view, paramString);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public String Picture()
  {
    return this.picturePath;
  }

  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty
  public void Picture(String paramString)
  {
    String str;
    if (paramString == null)
      str = "";
    while (true)
    {
      this.picturePath = str;
      try
      {
        BitmapDrawable localBitmapDrawable2 = MediaUtil.getBitmapDrawable(this.container.$form(), this.picturePath);
        localBitmapDrawable1 = localBitmapDrawable2;
        ViewUtil.setImage(this.view, localBitmapDrawable1);
        return;
        str = paramString;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          Log.e("Image", "Unable to load " + this.picturePath);
          BitmapDrawable localBitmapDrawable1 = null;
        }
      }
    }
  }

  public View getView()
  {
    return this.view;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Image
 * JD-Core Version:    0.6.2
 */