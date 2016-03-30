package com.google.appinventor.components.runtime.errors;

public class YailRuntimeError extends RuntimeError
{
  private String errorType;

  public YailRuntimeError(String paramString1, String paramString2)
  {
    super(paramString1);
    this.errorType = paramString2;
  }

  public String getErrorType()
  {
    return this.errorType;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.errors.YailRuntimeError
 * JD-Core Version:    0.6.2
 */