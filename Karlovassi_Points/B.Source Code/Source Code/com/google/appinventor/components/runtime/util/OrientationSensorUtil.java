package com.google.appinventor.components.runtime.util;

public class OrientationSensorUtil
{
  static float mod(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1 % paramFloat2;
    if ((f == 0.0F) || (Math.signum(paramFloat1) == Math.signum(paramFloat2)))
      return f;
    return f + paramFloat2;
  }

  public static float normalizeAzimuth(float paramFloat)
  {
    return mod(paramFloat, 360.0F);
  }

  public static float normalizePitch(float paramFloat)
  {
    return mod(paramFloat + 180.0F, 360.0F) - 180.0F;
  }

  public static float normalizeRoll(float paramFloat)
  {
    float f = Math.max(Math.min(paramFloat, 180.0F), -180.0F);
    if ((f >= -90.0F) && (f <= 90.0F));
    do
    {
      return f;
      f = 180.0F - f;
    }
    while (f < 270.0F);
    return f - 360.0F;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.OrientationSensorUtil
 * JD-Core Version:    0.6.2
 */