package com.google.appinventor.components.runtime.util;

import java.text.DecimalFormat;

public final class YailNumberToString
{
  private static final double BIGBOUND = 1000000.0D;
  private static final double SMALLBOUND = 1.0E-006D;
  private static final String decPattern = "#####0.0####";
  private static final DecimalFormat formatterDec = new DecimalFormat("#####0.0####");
  private static final DecimalFormat formatterSci = new DecimalFormat("0.####E0");
  private static final String sciPattern = "0.####E0";

  public static String format(double paramDouble)
  {
    double d = Math.abs(paramDouble);
    if ((d < 1000000.0D) && (d > 1.0E-006D))
      return formatterDec.format(paramDouble);
    return formatterSci.format(paramDouble);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.YailNumberToString
 * JD-Core Version:    0.6.2
 */