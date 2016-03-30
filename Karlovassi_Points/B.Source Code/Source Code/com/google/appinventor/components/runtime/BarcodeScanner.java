package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;

@DesignerComponent(category=ComponentCategory.MISC, description="Component for using the Barcode Scanner to read a barcode", iconName="images/barcodeScanner.png", nonVisible=true, version=1)
@SimpleObject
public class BarcodeScanner extends AndroidNonvisibleComponent
  implements ActivityResultListener, Component
{
  private static final String SCANNER_RESULT_NAME = "SCAN_RESULT";
  private static final String SCAN_INTENT = "com.google.zxing.client.android.SCAN";
  private final ComponentContainer container;
  private int requestCode;
  private String result = "";

  public BarcodeScanner(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.container = paramComponentContainer;
  }

  @SimpleEvent
  public void AfterScan(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "AfterScan", new Object[] { paramString });
  }

  @SimpleFunction
  public void DoScan()
  {
    Intent localIntent = new Intent("com.google.zxing.client.android.SCAN");
    if (this.requestCode == 0)
      this.requestCode = this.form.registerForActivityResult(this);
    try
    {
      this.container.$context().startActivityForResult(localIntent, this.requestCode);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      this.container.$form().dispatchErrorOccurredEvent(this, "BarcodeScanner", 1501, new Object[] { "" });
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String Result()
  {
    return this.result;
  }

  public void resultReturned(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == this.requestCode) && (paramInt2 == -1))
      if (!paramIntent.hasExtra("SCAN_RESULT"))
        break label41;
    label41: for (this.result = paramIntent.getStringExtra("SCAN_RESULT"); ; this.result = "")
    {
      AfterScan(this.result);
      return;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.BarcodeScanner
 * JD-Core Version:    0.6.2
 */