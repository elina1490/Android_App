package com.google.appinventor.components.annotations;

import com.google.appinventor.components.common.ComponentCategory;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface DesignerComponent
{
  public abstract ComponentCategory category();

  public abstract String description();

  public abstract String designerHelpDescription();

  public abstract String iconName();

  public abstract boolean nonVisible();

  public abstract boolean showOnPalette();

  public abstract int version();
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.annotations.DesignerComponent
 * JD-Core Version:    0.6.2
 */