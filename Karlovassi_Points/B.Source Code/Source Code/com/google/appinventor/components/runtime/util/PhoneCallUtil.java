package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class PhoneCallUtil
{
  public static void makePhoneCall(Context paramContext, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
      paramContext.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + paramString)));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.PhoneCallUtil
 * JD-Core Version:    0.6.2
 */