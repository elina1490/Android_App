package com.google.appinventor.components.runtime.util;

import java.util.Locale;

public abstract interface ITextToSpeech
{
  public abstract void onResume();

  public abstract void onStop();

  public abstract void speak(String paramString, Locale paramLocale);

  public static abstract interface TextToSpeechCallback
  {
    public abstract void onFailure();

    public abstract void onSuccess();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.ITextToSpeech
 * JD-Core Version:    0.6.2
 */