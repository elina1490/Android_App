package com.google.appinventor.components.runtime.util;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;

public abstract interface IClientLoginHelper
{
  public abstract HttpResponse execute(HttpUriRequest paramHttpUriRequest)
    throws ClientProtocolException, IOException;

  public abstract void forgetAccountName();

  public abstract String getAuthToken()
    throws ClientProtocolException;
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.IClientLoginHelper
 * JD-Core Version:    0.6.2
 */