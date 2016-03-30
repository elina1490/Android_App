package com.google.appinventor.components.runtime.util;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow.LayoutParams;

public final class ViewUtil
{
  public static void setBackgroundDrawable(View paramView, Drawable paramDrawable)
  {
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.invalidate();
  }

  public static void setBackgroundImage(View paramView, Drawable paramDrawable)
  {
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.requestLayout();
  }

  public static void setChildHeightForHorizontalLayout(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
    {
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localLayoutParams;
      switch (paramInt)
      {
      default:
        localLayoutParams1.height = paramInt;
      case -1:
      case -2:
      }
      while (true)
      {
        paramView.requestLayout();
        return;
        localLayoutParams1.height = -2;
        continue;
        localLayoutParams1.height = -1;
      }
    }
    Log.e("ViewUtil", "The view does not have linear layout parameters");
  }

  public static void setChildHeightForTableLayout(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof TableRow.LayoutParams))
    {
      TableRow.LayoutParams localLayoutParams1 = (TableRow.LayoutParams)localLayoutParams;
      switch (paramInt)
      {
      default:
        localLayoutParams1.height = paramInt;
      case -1:
      case -2:
      }
      while (true)
      {
        paramView.requestLayout();
        return;
        localLayoutParams1.height = -2;
        continue;
        localLayoutParams1.height = -1;
      }
    }
    Log.e("ViewUtil", "The view does not have table layout parameters");
  }

  public static void setChildHeightForVerticalLayout(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
    {
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localLayoutParams;
      switch (paramInt)
      {
      default:
        localLayoutParams1.height = paramInt;
        localLayoutParams1.weight = 0.0F;
      case -1:
      case -2:
      }
      while (true)
      {
        paramView.requestLayout();
        return;
        localLayoutParams1.height = -2;
        localLayoutParams1.weight = 0.0F;
        continue;
        localLayoutParams1.height = 0;
        localLayoutParams1.weight = 1.0F;
      }
    }
    Log.e("ViewUtil", "The view does not have linear layout parameters");
  }

  public static void setChildWidthForHorizontalLayout(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
    {
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localLayoutParams;
      switch (paramInt)
      {
      default:
        localLayoutParams1.width = paramInt;
        localLayoutParams1.weight = 0.0F;
      case -1:
      case -2:
      }
      while (true)
      {
        paramView.requestLayout();
        return;
        localLayoutParams1.width = -2;
        localLayoutParams1.weight = 0.0F;
        continue;
        localLayoutParams1.width = 0;
        localLayoutParams1.weight = 1.0F;
      }
    }
    Log.e("ViewUtil", "The view does not have linear layout parameters");
  }

  public static void setChildWidthForTableLayout(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof TableRow.LayoutParams))
    {
      TableRow.LayoutParams localLayoutParams1 = (TableRow.LayoutParams)localLayoutParams;
      switch (paramInt)
      {
      default:
        localLayoutParams1.width = paramInt;
      case -1:
      case -2:
      }
      while (true)
      {
        paramView.requestLayout();
        return;
        localLayoutParams1.width = -2;
        continue;
        localLayoutParams1.width = -1;
      }
    }
    Log.e("ViewUtil", "The view does not have table layout parameters");
  }

  public static void setChildWidthForVerticalLayout(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
    {
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)localLayoutParams;
      switch (paramInt)
      {
      default:
        localLayoutParams1.width = paramInt;
      case -1:
      case -2:
      }
      while (true)
      {
        paramView.requestLayout();
        return;
        localLayoutParams1.width = -2;
        continue;
        localLayoutParams1.width = -1;
      }
    }
    Log.e("ViewUtil", "The view does not have linear layout parameters");
  }

  public static void setImage(ImageView paramImageView, Drawable paramDrawable)
  {
    paramImageView.setImageDrawable(paramDrawable);
    if (paramDrawable != null)
      paramImageView.setAdjustViewBounds(true);
    paramImageView.requestLayout();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.ViewUtil
 * JD-Core Version:    0.6.2
 */