package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

public enum ComponentCategory
{
  private static final Map<String, String> DOC_MAP;
  private String name;

  static
  {
    ANIMATION = new ComponentCategory("ANIMATION", 2, "Animation");
    SOCIAL = new ComponentCategory("SOCIAL", 3, "Social");
    SENSORS = new ComponentCategory("SENSORS", 4, "Sensors");
    ARRANGEMENTS = new ComponentCategory("ARRANGEMENTS", 5, "Screen Arrangement");
    LEGOMINDSTORMS = new ComponentCategory("LEGOMINDSTORMS", 6, "LEGO® MINDSTORMS®");
    MISC = new ComponentCategory("MISC", 7, "Other stuff");
    EXPERIMENTAL = new ComponentCategory("EXPERIMENTAL", 8, "Not ready for prime time");
    INTERNAL = new ComponentCategory("INTERNAL", 9, "For internal use only");
    UNINITIALIZED = new ComponentCategory("UNINITIALIZED", 10, "Uninitialized");
    ComponentCategory[] arrayOfComponentCategory = new ComponentCategory[11];
    arrayOfComponentCategory[0] = BASIC;
    arrayOfComponentCategory[1] = MEDIA;
    arrayOfComponentCategory[2] = ANIMATION;
    arrayOfComponentCategory[3] = SOCIAL;
    arrayOfComponentCategory[4] = SENSORS;
    arrayOfComponentCategory[5] = ARRANGEMENTS;
    arrayOfComponentCategory[6] = LEGOMINDSTORMS;
    arrayOfComponentCategory[7] = MISC;
    arrayOfComponentCategory[8] = EXPERIMENTAL;
    arrayOfComponentCategory[9] = INTERNAL;
    arrayOfComponentCategory[10] = UNINITIALIZED;
    $VALUES = arrayOfComponentCategory;
    DOC_MAP = new HashMap();
    DOC_MAP.put("Basic", "basic");
    DOC_MAP.put("Media", "media");
    DOC_MAP.put("Animation", "animation");
    DOC_MAP.put("Social", "social");
    DOC_MAP.put("Sensors", "sensors");
    DOC_MAP.put("Screen Arrangement", "screenarrangement");
    DOC_MAP.put("LEGO® MINDSTORMS®", "legomindstorms");
    DOC_MAP.put("Other stuff", "other");
    DOC_MAP.put("Not ready for prime time", "notready");
  }

  private ComponentCategory(String paramString)
  {
    this.name = paramString;
  }

  public String getDocName()
  {
    return (String)DOC_MAP.get(this.name);
  }

  public String getName()
  {
    return this.name;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.common.ComponentCategory
 * JD-Core Version:    0.6.2
 */