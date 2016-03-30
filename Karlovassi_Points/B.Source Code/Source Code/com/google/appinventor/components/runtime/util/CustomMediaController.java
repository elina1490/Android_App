package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.MediaController;

public class CustomMediaController extends MediaController
  implements View.OnTouchListener
{
  private View mAnchorView;
  private int mShowTime = 3000;

  public CustomMediaController(Context paramContext)
  {
    super(paramContext);
  }

  public boolean addTo(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      ((ViewGroup)localViewParent).removeView(this);
      paramViewGroup.addView(this, paramLayoutParams);
      return true;
    }
    Log.e("CustomMediaController.addTo", "MediaController not available in fullscreen.");
    return false;
  }

  public void hide()
  {
    super.hide();
    setVisibility(4);
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this.mAnchorView)
      show(this.mShowTime);
    return false;
  }

  public void setAnchorView(View paramView)
  {
    this.mAnchorView = paramView;
    this.mAnchorView.setOnTouchListener(this);
    super.setAnchorView(paramView);
  }

  public void show()
  {
    setVisibility(0);
    super.show();
  }

  public void show(int paramInt)
  {
    setVisibility(0);
    super.show(paramInt);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.CustomMediaController
 * JD-Core Version:    0.6.2
 */