package com.google.appinventor.components.runtime.util;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;

public class GingerbreadUtil
{
  public static boolean clearCookies(CookieHandler paramCookieHandler)
  {
    if ((paramCookieHandler instanceof CookieManager))
    {
      CookieStore localCookieStore = ((CookieManager)paramCookieHandler).getCookieStore();
      if (localCookieStore != null)
      {
        localCookieStore.removeAll();
        return true;
      }
    }
    return false;
  }

  public static CookieHandler newCookieManager()
  {
    return new CookieManager();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.GingerbreadUtil
 * JD-Core Version:    0.6.2
 */