package com.google.appinventor.components.runtime.util;

public abstract interface AsyncCallbackPair<T>
{
  public abstract void onFailure(String paramString);

  public abstract void onSuccess(T paramT);
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.AsyncCallbackPair
 * JD-Core Version:    0.6.2
 */