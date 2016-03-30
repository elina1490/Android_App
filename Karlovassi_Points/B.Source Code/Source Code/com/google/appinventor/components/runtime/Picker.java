package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Intent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.util.AnimationUtil;

@SimpleObject
public abstract class Picker extends ButtonBase
  implements ActivityResultListener
{
  protected final ComponentContainer container;
  protected int requestCode;

  public Picker(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer);
    this.container = paramComponentContainer;
  }

  @SimpleEvent
  public void AfterPicking()
  {
    EventDispatcher.dispatchEvent(this, "AfterPicking", new Object[0]);
  }

  @SimpleEvent
  public void BeforePicking()
  {
    EventDispatcher.dispatchEvent(this, "BeforePicking", new Object[0]);
  }

  @SimpleFunction
  public void Open()
  {
    click();
  }

  public void click()
  {
    BeforePicking();
    if (this.requestCode == 0)
      this.requestCode = this.container.$form().registerForActivityResult(this);
    this.container.$context().startActivityForResult(getIntent(), this.requestCode);
    String str = this.container.$form().getOpenAnimType();
    AnimationUtil.ApplyOpenScreenAnimation(this.container.$context(), str);
  }

  protected abstract Intent getIntent();
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Picker
 * JD-Core Version:    0.6.2
 */