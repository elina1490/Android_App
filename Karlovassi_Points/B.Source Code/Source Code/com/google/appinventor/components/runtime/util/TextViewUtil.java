package com.google.appinventor.components.runtime.util;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.widget.TextView;

public class TextViewUtil
{
  public static float getFontSize(TextView paramTextView)
  {
    return paramTextView.getTextSize();
  }

  public static String getText(TextView paramTextView)
  {
    return paramTextView.getText().toString();
  }

  public static boolean isEnabled(TextView paramTextView)
  {
    return paramTextView.isEnabled();
  }

  public static void setAlignment(TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    int i;
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException();
    case 0:
      i = 3;
      if (!paramBoolean)
        break;
    case 1:
    case 2:
    }
    for (int j = 16; ; j = 48)
    {
      paramTextView.setGravity(i | j);
      paramTextView.invalidate();
      return;
      i = 1;
      break;
      i = 5;
      break;
    }
  }

  public static void setBackgroundColor(TextView paramTextView, int paramInt)
  {
    paramTextView.setBackgroundColor(paramInt);
    paramTextView.invalidate();
  }

  public static void setEnabled(TextView paramTextView, boolean paramBoolean)
  {
    paramTextView.setEnabled(paramBoolean);
    paramTextView.invalidate();
  }

  public static void setFontSize(TextView paramTextView, float paramFloat)
  {
    paramTextView.setTextSize(paramFloat);
    paramTextView.requestLayout();
  }

  public static void setFontTypeface(TextView paramTextView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Typeface localTypeface;
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException();
    case 0:
      localTypeface = Typeface.DEFAULT;
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      int i = 0;
      if (paramBoolean1)
        i = 0x0 | 0x1;
      if (paramBoolean2)
        i |= 2;
      paramTextView.setTypeface(Typeface.create(localTypeface, i));
      paramTextView.requestLayout();
      return;
      localTypeface = Typeface.SERIF;
      continue;
      localTypeface = Typeface.SANS_SERIF;
      continue;
      localTypeface = Typeface.MONOSPACE;
    }
  }

  public static void setText(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString);
    paramTextView.requestLayout();
  }

  public static void setTextColor(TextView paramTextView, int paramInt)
  {
    paramTextView.setTextColor(paramInt);
    paramTextView.invalidate();
  }

  public static void setTextColors(TextView paramTextView, ColorStateList paramColorStateList)
  {
    paramTextView.setTextColor(paramColorStateList);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.TextViewUtil
 * JD-Core Version:    0.6.2
 */