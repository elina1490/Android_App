package com.google.appinventor.components.runtime;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.MediaUtil;
import java.io.IOException;

@DesignerComponent(category=ComponentCategory.ANIMATION, description="<p>A 'sprite' that can be placed on a <code>Canvas</code>, where it can react to touches and drags, interact with other sprites (<code>Ball</code>s and other <code>ImageSprite</code>s) and the edge of the Canvas, and move according to its property values.  Its appearance is that of the image specified in its <code>Picture</code> property (unless its <code>Visible</code> property is <code>False</code>.</p> <p>To have an <code>ImageSprite</code> move 10 pixels to the left every 1000 milliseconds (one second), for example, you would set the <code>Speed</code> property to 10 [pixels], the <code>Interval</code> property to 1000 [milliseconds], the <code>Heading</code> property to 180 [degrees], and the <code>Enabled</code> property to <code>True</code>.  A sprite whose <code>Rotates</code> property is <code>True</code> will rotate its image as the sprite's <code>Heading</code> changes.  Checking for collisions with a rotated sprite currently checks the sprite's unrotated position so that collision checking will be inaccurate for tall narrow or short wide sprites that are rotated.  Any of the sprite properties can be changed at any time under program control.</p> ", version=6)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET")
public class ImageSprite extends Sprite
{
  private double cachedRotationHeading;
  private BitmapDrawable drawable;
  private final Form form;
  private int heightHint = -1;
  private Matrix mat;
  private String picturePath = "";
  private Bitmap rotatedBitmap;
  private BitmapDrawable rotatedDrawable;
  private boolean rotates;
  private boolean rotationCached;
  private Bitmap scaledBitmap;
  private Bitmap unrotatedBitmap;
  private int widthHint = -1;

  public ImageSprite(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer);
    this.form = paramComponentContainer.$form();
    this.mat = new Matrix();
    this.rotates = true;
    this.rotationCached = false;
  }

  @SimpleProperty
  public int Height()
  {
    if ((this.heightHint == -1) || (this.heightHint == -2))
    {
      if (this.drawable == null)
        return 0;
      return this.drawable.getBitmap().getHeight();
    }
    return this.heightHint;
  }

  @SimpleProperty
  public void Height(int paramInt)
  {
    this.heightHint = paramInt;
    registerChange();
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="The picture that determines the sprite's appearence")
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
        this.drawable = MediaUtil.getBitmapDrawable(this.form, this.picturePath);
        if (this.drawable != null)
        {
          this.unrotatedBitmap = this.drawable.getBitmap();
          registerChange();
          return;
          str = paramString;
        }
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          Log.e("ImageSprite", "Unable to load " + this.picturePath);
          this.drawable = null;
          continue;
          this.unrotatedBitmap = null;
        }
      }
    }
  }

  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty
  public void Rotates(boolean paramBoolean)
  {
    this.rotates = paramBoolean;
    registerChange();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="If true, the sprite image rotates to match the sprite's heading. If false, the sprite image does not rotate when the sprite changes heading. The sprite rotates around its centerpoint.")
  public boolean Rotates()
  {
    return this.rotates;
  }

  @SimpleProperty
  public int Width()
  {
    if ((this.widthHint == -1) || (this.widthHint == -2))
    {
      if (this.drawable == null)
        return 0;
      return this.drawable.getBitmap().getWidth();
    }
    return this.widthHint;
  }

  @SimpleProperty
  public void Width(int paramInt)
  {
    this.widthHint = paramInt;
    registerChange();
  }

  public void onDraw(Canvas paramCanvas)
  {
    int i;
    int j;
    int k;
    int m;
    if ((this.unrotatedBitmap != null) && (this.visible))
    {
      i = (int)Math.round(this.xLeft);
      j = (int)Math.round(this.yTop);
      k = Width();
      m = Height();
      if (!this.rotates)
      {
        this.drawable.setBounds(i, j, i + k, j + m);
        this.drawable.draw(paramCanvas);
      }
    }
    else
    {
      return;
    }
    if ((!this.rotationCached) || (this.cachedRotationHeading != Heading()))
    {
      this.mat.setRotate((float)-Heading(), k / 2, m / 2);
      if ((k == this.unrotatedBitmap.getWidth()) && (m == this.unrotatedBitmap.getHeight()))
        break label294;
    }
    label294: for (this.scaledBitmap = Bitmap.createScaledBitmap(this.unrotatedBitmap, k, m, true); ; this.scaledBitmap = this.unrotatedBitmap)
    {
      this.rotatedBitmap = Bitmap.createBitmap(this.scaledBitmap, 0, 0, this.scaledBitmap.getWidth(), this.scaledBitmap.getHeight(), this.mat, true);
      this.rotatedDrawable = new BitmapDrawable(this.rotatedBitmap);
      this.cachedRotationHeading = Heading();
      this.rotatedDrawable.setBounds(i + k / 2 - this.rotatedBitmap.getWidth() / 2, j + m / 2 - this.rotatedBitmap.getHeight() / 2, i + k / 2 + this.rotatedBitmap.getWidth() / 2, j + m / 2 + this.rotatedBitmap.getHeight() / 2);
      this.rotatedDrawable.draw(paramCanvas);
      return;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.ImageSprite
 * JD-Core Version:    0.6.2
 */