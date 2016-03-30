package com.google.appinventor.components.runtime;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;

@DesignerComponent(category=ComponentCategory.EXPERIMENTAL, description="Component for viewing Web pages.  The Home URL can be specified in the Designer or in the Blocks Editor.  The view can be set to follow links when they are tapped, and users can fill in Web forms. Warning: This is not a full browser.  For example, pressing the phone's hardware Back key will exit the app, rather than move back in the browser history.", version=2)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET")
public final class WebViewer extends AndroidViewComponent
{
  private boolean followLinks;
  private String homeUrl;
  private final WebView webview;

  public WebViewer(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer);
    this.webview = new WebView(paramComponentContainer.$context());
    this.webview.setWebViewClient(new WebViewerClient(null));
    this.webview.getSettings().setJavaScriptEnabled(true);
    this.webview.setFocusable(true);
    this.webview.getSettings().setBuiltInZoomControls(true);
    paramComponentContainer.$add(this);
    this.webview.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        switch (paramAnonymousMotionEvent.getAction())
        {
        default:
        case 0:
        case 1:
        }
        while (true)
        {
          return false;
          if (!paramAnonymousView.hasFocus())
            paramAnonymousView.requestFocus();
        }
      }
    });
    this.followLinks = true;
    HomeUrl("");
    Width(-2);
    Height(-2);
  }

  @SimpleFunction(description="Returns true if the WebViewer can go back in the history list.")
  public boolean CanGoBack()
  {
    return this.webview.canGoBack();
  }

  @SimpleFunction(description="Returns true if the WebViewer can go forward in the history list.")
  public boolean CanGoForward()
  {
    return this.webview.canGoForward();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Title of the page currently viewed")
  public String CurrentPageTitle()
  {
    if (this.webview.getTitle() == null)
      return "";
    return this.webview.getTitle();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="URL of the page currently viewed.   This could be different from the Home URL if new pages were visited by following links.")
  public String CurrentUrl()
  {
    if (this.webview.getUrl() == null)
      return "";
    return this.webview.getUrl();
  }

  @DesignerProperty(defaultValue="True", editorType="boolean")
  @SimpleProperty
  public void FollowLinks(boolean paramBoolean)
  {
    this.followLinks = paramBoolean;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Determines whether to follow links when they are tapped in the WebViewer.  If you follow links, you can use GoBack and GoForward to navigate the browser history. ")
  public boolean FollowLinks()
  {
    return this.followLinks;
  }

  @SimpleFunction(description="Go back to the previous page in the history list.  Does nothing if there is no previous page.")
  public void GoBack()
  {
    if (this.webview.canGoBack())
      this.webview.goBack();
  }

  @SimpleFunction(description="Go forward to the next page in the history list.   Does nothing if there is no next page.")
  public void GoForward()
  {
    if (this.webview.canGoForward())
      this.webview.goForward();
  }

  @SimpleFunction(description="Loads the home URL page.  This happens automatically when the home URL is changed.")
  public void GoHome()
  {
    this.webview.loadUrl(this.homeUrl);
  }

  @SimpleFunction(description="Load the page at the given URL.")
  public void GoToUrl(String paramString)
  {
    this.webview.loadUrl(paramString);
  }

  @SimpleProperty
  public void Height(int paramInt)
  {
    if (paramInt == -1)
      paramInt = -2;
    super.Height(paramInt);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="URL of the page the WebViewer should initially open to.  Setting this will load the page.")
  public String HomeUrl()
  {
    return this.homeUrl;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty
  public void HomeUrl(String paramString)
  {
    this.homeUrl = paramString;
    this.webview.clearHistory();
    this.webview.loadUrl(this.homeUrl);
  }

  @SimpleProperty
  public void Width(int paramInt)
  {
    if (paramInt == -1)
      paramInt = -2;
    super.Width(paramInt);
  }

  public View getView()
  {
    return this.webview;
  }

  private class WebViewerClient extends WebViewClient
  {
    private WebViewerClient()
    {
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      return !WebViewer.this.followLinks;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.WebViewer
 * JD-Core Version:    0.6.2
 */