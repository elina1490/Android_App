package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public final class WebViewActivity extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    WebView localWebView = new WebView(this);
    localWebView.getSettings().setJavaScriptEnabled(true);
    localWebView.setWebViewClient(new WebViewClient()
    {
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        Log.i("WebView", "Handling url " + paramAnonymousString);
        Uri localUri = Uri.parse(paramAnonymousString);
        if (localUri.getScheme().equals("appinventor"))
        {
          Intent localIntent = new Intent();
          localIntent.setData(localUri);
          WebViewActivity.this.setResult(-1, localIntent);
          WebViewActivity.this.finish();
        }
        while (true)
        {
          return true;
          paramAnonymousWebView.loadUrl(paramAnonymousString);
        }
      }
    });
    setContentView(localWebView);
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getData() != null))
    {
      Uri localUri = localIntent.getData();
      String str1 = localUri.getScheme();
      String str2 = localUri.getHost();
      Log.i("WebView", "Got intent with URI: " + localUri + ", scheme=" + str1 + ", host=" + str2);
      localWebView.loadUrl(localUri.toString());
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.WebViewActivity
 * JD-Core Version:    0.6.2
 */