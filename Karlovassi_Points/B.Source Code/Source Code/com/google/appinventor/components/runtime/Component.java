package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.SimpleObject;

@SimpleObject
public abstract interface Component
{
  public static final int ALIGNMENT_CENTER = 1;
  public static final int ALIGNMENT_NORMAL = 0;
  public static final int ALIGNMENT_OPPOSITE = 2;
  public static final int BUTTON_SHAPE_DEFAULT = 0;
  public static final int BUTTON_SHAPE_OVAL = 3;
  public static final int BUTTON_SHAPE_RECT = 2;
  public static final int BUTTON_SHAPE_ROUNDED = 1;
  public static final int COLOR_BLACK = -16777216;
  public static final int COLOR_BLUE = -16776961;
  public static final int COLOR_CYAN = -16711681;
  public static final int COLOR_DEFAULT = 0;
  public static final int COLOR_DKGRAY = -12303292;
  public static final int COLOR_GRAY = -7829368;
  public static final int COLOR_GREEN = -16711936;
  public static final int COLOR_LTGRAY = -3355444;
  public static final int COLOR_MAGENTA = -65281;
  public static final int COLOR_NONE = 16777215;
  public static final int COLOR_ORANGE = -14336;
  public static final int COLOR_PINK = -20561;
  public static final int COLOR_RED = -65536;
  public static final int COLOR_WHITE = -1;
  public static final int COLOR_YELLOW = -256;
  public static final String DEFAULT_VALUE_COLOR_BLACK = "&HFF000000";
  public static final String DEFAULT_VALUE_COLOR_BLUE = "&HFF0000FF";
  public static final String DEFAULT_VALUE_COLOR_CYAN = "&HFF00FFFF";
  public static final String DEFAULT_VALUE_COLOR_DEFAULT = "&H00000000";
  public static final String DEFAULT_VALUE_COLOR_DKGRAY = "&HFF444444";
  public static final String DEFAULT_VALUE_COLOR_GRAY = "&HFF888888";
  public static final String DEFAULT_VALUE_COLOR_GREEN = "&HFF00FF00";
  public static final String DEFAULT_VALUE_COLOR_LTGRAY = "&HFFCCCCCC";
  public static final String DEFAULT_VALUE_COLOR_MAGENTA = "&HFFFF00FF";
  public static final String DEFAULT_VALUE_COLOR_NONE = "&H00FFFFFF";
  public static final String DEFAULT_VALUE_COLOR_ORANGE = "&HFFFFC800";
  public static final String DEFAULT_VALUE_COLOR_PINK = "&HFFFFAFAF";
  public static final String DEFAULT_VALUE_COLOR_RED = "&HFFFF0000";
  public static final String DEFAULT_VALUE_COLOR_WHITE = "&HFFFFFFFF";
  public static final String DEFAULT_VALUE_COLOR_YELLOW = "&HFFFFFF00";
  public static final int DIRECTION_EAST = 3;
  public static final int DIRECTION_MAX = 4;
  public static final int DIRECTION_MIN = -4;
  public static final int DIRECTION_NONE = 0;
  public static final int DIRECTION_NORTH = 1;
  public static final int DIRECTION_NORTHEAST = 2;
  public static final int DIRECTION_NORTHWEST = -4;
  public static final int DIRECTION_SOUTH = -1;
  public static final int DIRECTION_SOUTHEAST = 4;
  public static final int DIRECTION_SOUTHWEST = -2;
  public static final int DIRECTION_WEST = -3;
  public static final float FONT_DEFAULT_SIZE = 14.0F;
  public static final int LAYOUT_ORIENTATION_HORIZONTAL = 0;
  public static final int LAYOUT_ORIENTATION_VERTICAL = 1;
  public static final int LENGTH_FILL_PARENT = -2;
  public static final int LENGTH_PREFERRED = -1;
  public static final int LENGTH_UNKNOWN = -3;
  public static final int TYPEFACE_DEFAULT = 0;
  public static final int TYPEFACE_MONOSPACE = 3;
  public static final int TYPEFACE_SANSSERIF = 1;
  public static final int TYPEFACE_SERIF = 2;

  public abstract HandlesEventDispatching getDispatchDelegate();
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Component
 * JD-Core Version:    0.6.2
 */