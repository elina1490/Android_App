package com.google.appinventor.components.runtime;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.google.appinventor.components.annotations.SimpleObject;

@SimpleObject
public final class LinearLayout
  implements Layout
{
  private final android.widget.LinearLayout layoutManager;

  LinearLayout(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, null, null);
  }

  LinearLayout(Context paramContext, int paramInt, final Integer paramInteger1, final Integer paramInteger2)
  {
    if (((paramInteger1 == null) && (paramInteger2 != null)) || ((paramInteger1 != null) && (paramInteger2 == null)))
      throw new IllegalArgumentException("LinearLayout - preferredEmptyWidth and preferredEmptyHeight must be either both null or both not null");
    this.layoutManager = new android.widget.LinearLayout(paramContext)
    {
      private int getSize(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int i = View.MeasureSpec.getMode(paramAnonymousInt1);
        int j = View.MeasureSpec.getSize(paramAnonymousInt1);
        int k;
        if (i == 1073741824)
          k = j;
        do
        {
          return k;
          k = paramAnonymousInt2;
        }
        while (i != -2147483648);
        return Math.min(k, j);
      }

      protected void onMeasure(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if ((paramInteger1 == null) || (paramInteger2 == null))
        {
          super.onMeasure(paramAnonymousInt1, paramAnonymousInt2);
          return;
        }
        if (getChildCount() != 0)
        {
          super.onMeasure(paramAnonymousInt1, paramAnonymousInt2);
          return;
        }
        setMeasuredDimension(getSize(paramAnonymousInt1, paramInteger1.intValue()), getSize(paramAnonymousInt2, paramInteger2.intValue()));
      }
    };
    android.widget.LinearLayout localLinearLayout = this.layoutManager;
    if (paramInt == 0);
    for (int i = 0; ; i = 1)
    {
      localLinearLayout.setOrientation(i);
      return;
    }
  }

  public void add(AndroidViewComponent paramAndroidViewComponent)
  {
    this.layoutManager.addView(paramAndroidViewComponent.getView(), new LinearLayout.LayoutParams(-2, -2, 0.0F));
  }

  public ViewGroup getLayoutManager()
  {
    return this.layoutManager;
  }

  public void setHorizontalGravity(int paramInt)
  {
    this.layoutManager.setHorizontalGravity(paramInt);
  }

  public void setVerticalGravity(int paramInt)
  {
    this.layoutManager.setVerticalGravity(paramInt);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.LinearLayout
 * JD-Core Version:    0.6.2
 */