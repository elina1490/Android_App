package com.google.appinventor.components.runtime.util;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;

public class PaintUtil
{
  public static void changePaint(Paint paramPaint, int paramInt)
  {
    paramPaint.setColor(0xFFFFFF & paramInt);
    paramPaint.setAlpha(0xFF & paramInt >> 24);
    paramPaint.setXfermode(null);
  }

  public static void changePaintTransparent(Paint paramPaint)
  {
    paramPaint.setAlpha(0);
    paramPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.PaintUtil
 * JD-Core Version:    0.6.2
 */