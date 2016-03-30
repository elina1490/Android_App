package com.google.appinventor.components.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface SimpleProperty
{
  public abstract PropertyCategory category();

  public abstract String description();

  public abstract boolean userVisible();
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.annotations.SimpleProperty
 * JD-Core Version:    0.6.2
 */