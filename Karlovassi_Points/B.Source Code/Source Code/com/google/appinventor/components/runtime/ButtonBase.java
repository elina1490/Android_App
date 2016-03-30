package com.google.appinventor.components.runtime;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.TextViewUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;

@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET")
public abstract class ButtonBase extends AndroidViewComponent
  implements View.OnClickListener, View.OnFocusChangeListener, View.OnLongClickListener
{
  private static final String LOG_TAG = "ButtonBase";
  private static final float[] ROUNDED_CORNERS_ARRAY = { 10.0F, 10.0F, 10.0F, 10.0F, 10.0F, 10.0F, 10.0F, 10.0F };
  private static final float ROUNDED_CORNERS_RADIUS = 10.0F;
  private static final int SHAPED_DEFAULT_BACKGROUND_COLOR = -3355444;
  private int backgroundColor;
  private Drawable backgroundImageDrawable;
  private boolean bold;
  private Drawable defaultButtonDrawable;
  private ColorStateList defaultColorStateList;
  private int fontTypeface;
  private String imagePath = "";
  private boolean italic;
  private int shape;
  private int textAlignment;
  private int textColor;
  private final Button view;

  public ButtonBase(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer);
    this.view = new Button(paramComponentContainer.$context());
    this.defaultButtonDrawable = this.view.getBackground();
    this.defaultColorStateList = this.view.getTextColors();
    paramComponentContainer.$add(this);
    this.view.setOnClickListener(this);
    this.view.setOnFocusChangeListener(this);
    this.view.setOnLongClickListener(this);
    TextAlignment(1);
    BackgroundColor(0);
    Image("");
    Enabled(true);
    this.fontTypeface = 0;
    TextViewUtil.setFontTypeface(this.view, this.fontTypeface, this.bold, this.italic);
    FontSize(14.0F);
    Text("");
    TextColor(0);
    Shape(0);
  }

  private void setShape()
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    Paint localPaint = localShapeDrawable.getPaint();
    if (this.backgroundColor == 0);
    for (int i = -3355444; ; i = this.backgroundColor)
    {
      localPaint.setColor(i);
      switch (this.shape)
      {
      default:
        throw new IllegalArgumentException();
      case 1:
      case 2:
      case 3:
      }
    }
    localShapeDrawable.setShape(new RoundRectShape(ROUNDED_CORNERS_ARRAY, null, null));
    while (true)
    {
      this.view.setBackgroundDrawable(localShapeDrawable);
      this.view.invalidate();
      return;
      localShapeDrawable.setShape(new RectShape());
      continue;
      localShapeDrawable.setShape(new OvalShape());
    }
  }

  private void updateAppearance()
  {
    if (this.backgroundImageDrawable == null)
    {
      if (this.shape == 0)
      {
        if (this.backgroundColor == 0)
        {
          ViewUtil.setBackgroundDrawable(this.view, this.defaultButtonDrawable);
          return;
        }
        ViewUtil.setBackgroundDrawable(this.view, null);
        TextViewUtil.setBackgroundColor(this.view, this.backgroundColor);
        return;
      }
      setShape();
      return;
    }
    ViewUtil.setBackgroundImage(this.view, this.backgroundImageDrawable);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, description="Returns the button's background color")
  public int BackgroundColor()
  {
    return this.backgroundColor;
  }

  @DesignerProperty(defaultValue="&H00000000", editorType="color")
  @SimpleProperty(description="Specifies the button's background color. The background color will not be visible if an Image is being displayed.")
  public void BackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
    updateAppearance();
  }

  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty
  public void Enabled(boolean paramBoolean)
  {
    TextViewUtil.setEnabled(this.view, paramBoolean);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public boolean Enabled()
  {
    return TextViewUtil.isEnabled(this.view);
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty(userVisible=false)
  public void FontBold(boolean paramBoolean)
  {
    this.bold = paramBoolean;
    TextViewUtil.setFontTypeface(this.view, this.fontTypeface, paramBoolean, this.italic);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, userVisible=false)
  public boolean FontBold()
  {
    return this.bold;
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty(userVisible=false)
  public void FontItalic(boolean paramBoolean)
  {
    this.italic = paramBoolean;
    TextViewUtil.setFontTypeface(this.view, this.fontTypeface, this.bold, paramBoolean);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, userVisible=false)
  public boolean FontItalic()
  {
    return this.italic;
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, userVisible=false)
  public float FontSize()
  {
    return TextViewUtil.getFontSize(this.view);
  }

  @DesignerProperty(defaultValue="14.0", editorType="non_negative_float")
  @SimpleProperty(userVisible=false)
  public void FontSize(float paramFloat)
  {
    TextViewUtil.setFontSize(this.view, paramFloat);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, userVisible=false)
  public int FontTypeface()
  {
    return this.fontTypeface;
  }

  @DesignerProperty(defaultValue="0", editorType="typeface")
  @SimpleProperty(userVisible=false)
  public void FontTypeface(int paramInt)
  {
    this.fontTypeface = paramInt;
    TextViewUtil.setFontTypeface(this.view, this.fontTypeface, this.bold, this.italic);
  }

  @SimpleEvent
  public void GotFocus()
  {
    EventDispatcher.dispatchEvent(this, "GotFocus", new Object[0]);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public String Image()
  {
    return this.imagePath;
  }

  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty(description="Specifies the path of the button's image.  If there is both an Image and a BackgroundColor, only the Image will be visible.")
  public void Image(String paramString)
  {
    if ((paramString.equals(this.imagePath)) && (this.backgroundImageDrawable != null))
      return;
    String str;
    if (paramString == null)
      str = "";
    while (true)
    {
      this.imagePath = str;
      this.backgroundImageDrawable = null;
      if (this.imagePath.length() > 0);
      try
      {
        this.backgroundImageDrawable = MediaUtil.getBitmapDrawable(this.container.$form(), this.imagePath);
        updateAppearance();
        return;
        str = paramString;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.e("ButtonBase", "Unable to load " + this.imagePath);
      }
    }
  }

  @SimpleEvent
  public void LostFocus()
  {
    EventDispatcher.dispatchEvent(this, "LostFocus", new Object[0]);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, userVisible=false)
  public int Shape()
  {
    return this.shape;
  }

  @DesignerProperty(defaultValue="0", editorType="button_shape")
  @SimpleProperty(description="Specifies the button's shape (default, rounded, rectangular, oval). The shape will not be visible if an Image is being displayed.", userVisible=false)
  public void Shape(int paramInt)
  {
    this.shape = paramInt;
    updateAppearance();
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public String Text()
  {
    return TextViewUtil.getText(this.view);
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void Text(String paramString)
  {
    TextViewUtil.setText(this.view, paramString);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE, userVisible=false)
  public int TextAlignment()
  {
    return this.textAlignment;
  }

  @DesignerProperty(defaultValue="1", editorType="textalignment")
  @SimpleProperty(userVisible=false)
  public void TextAlignment(int paramInt)
  {
    this.textAlignment = paramInt;
    TextViewUtil.setAlignment(this.view, paramInt, true);
  }

  @SimpleProperty(category=PropertyCategory.APPEARANCE)
  public int TextColor()
  {
    return this.textColor;
  }

  @DesignerProperty(defaultValue="&H00000000", editorType="color")
  @SimpleProperty
  public void TextColor(int paramInt)
  {
    this.textColor = paramInt;
    if (paramInt != 0)
    {
      TextViewUtil.setTextColor(this.view, paramInt);
      return;
    }
    TextViewUtil.setTextColors(this.view, this.defaultColorStateList);
  }

  public abstract void click();

  public View getView()
  {
    return this.view;
  }

  public boolean longClick()
  {
    return false;
  }

  public void onClick(View paramView)
  {
    click();
  }

  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GotFocus();
      return;
    }
    LostFocus();
  }

  public boolean onLongClick(View paramView)
  {
    return longClick();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.ButtonBase
 * JD-Core Version:    0.6.2
 */