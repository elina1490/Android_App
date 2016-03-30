package com.google.appinventor.components.runtime.errors;

import com.google.appinventor.components.annotations.SimpleObject;

@SimpleObject
public class AssertionFailure extends RuntimeError
{
  public AssertionFailure()
  {
  }

  public AssertionFailure(String paramString)
  {
    super(paramString);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.errors.AssertionFailure
 * JD-Core Version:    0.6.2
 */