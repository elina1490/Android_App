package com.google.appinventor.components.annotations;

public enum PropertyCategory
{
  private String name;

  static
  {
    APPEARANCE = new PropertyCategory("APPEARANCE", 1, "Appearance");
    DEPRECATED = new PropertyCategory("DEPRECATED", 2, "Deprecated");
    UNSET = new PropertyCategory("UNSET", 3, "Unspecified");
    PropertyCategory[] arrayOfPropertyCategory = new PropertyCategory[4];
    arrayOfPropertyCategory[0] = BEHAVIOR;
    arrayOfPropertyCategory[1] = APPEARANCE;
    arrayOfPropertyCategory[2] = DEPRECATED;
    arrayOfPropertyCategory[3] = UNSET;
  }

  private PropertyCategory(String paramString)
  {
    this.name = paramString;
  }

  public String getName()
  {
    return this.name;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.annotations.PropertyCategory
 * JD-Core Version:    0.6.2
 */