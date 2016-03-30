package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;

@DesignerComponent(category=ComponentCategory.INTERNAL, description="Component that returns information about the phone.", iconName="images/phoneip.png", nonVisible=true, version=1)
@SimpleObject
public class PhoneStatus extends AndroidNonvisibleComponent
  implements Component
{
  private static Activity activity;

  public PhoneStatus(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    activity = paramComponentContainer.$context();
  }

  @SimpleFunction(description="Returns the IP address of the phone in the form of a String")
  public static String GetWifiIpAddress()
  {
    int i = ((WifiManager)activity.getSystemService("wifi")).getDhcpInfo().ipAddress;
    if (isConnected())
      return intToIp(i);
    return "Error: No Wifi Connection";
  }

  public static String intToIp(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (0xFF & paramInt >> 8) + "." + (0xFF & paramInt >> 16) + "." + (0xFF & paramInt >> 24);
  }

  @SimpleFunction(description="Returns TRUE if the phone is on Wifi, FALSE otherwise")
  public static boolean isConnected()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)activity.getSystemService("connectivity");
    NetworkInfo localNetworkInfo = null;
    if (localConnectivityManager != null)
      localNetworkInfo = localConnectivityManager.getNetworkInfo(1);
    if (localNetworkInfo == null)
      return false;
    return localNetworkInfo.isConnected();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.PhoneStatus
 * JD-Core Version:    0.6.2
 */