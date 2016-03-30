package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.content.Intent;
import com.google.appinventor.components.runtime.ActivityResultListener;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.Form;
import java.util.Locale;

public class ExternalTextToSpeech
  implements ITextToSpeech, ActivityResultListener
{
  private static final String TTS_INTENT = "com.google.tts.makeBagel";
  private final ITextToSpeech.TextToSpeechCallback callback;
  private final ComponentContainer container;
  private int requestCode;

  public ExternalTextToSpeech(ComponentContainer paramComponentContainer, ITextToSpeech.TextToSpeechCallback paramTextToSpeechCallback)
  {
    this.container = paramComponentContainer;
    this.callback = paramTextToSpeechCallback;
  }

  public void onResume()
  {
  }

  public void onStop()
  {
  }

  public void resultReturned(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == this.requestCode) && (paramInt2 == -1));
    for (int i = 1; i != 0; i = 0)
    {
      this.callback.onSuccess();
      return;
    }
    this.callback.onFailure();
  }

  public void speak(String paramString, Locale paramLocale)
  {
    Intent localIntent = new Intent("com.google.tts.makeBagel");
    localIntent.setFlags(131072);
    localIntent.setFlags(8388608);
    localIntent.setFlags(1073741824);
    localIntent.putExtra("message", paramString);
    localIntent.putExtra("language", paramLocale.getISO3Language());
    localIntent.putExtra("country", paramLocale.getISO3Country());
    if (this.requestCode == 0)
      this.requestCode = this.container.$form().registerForActivityResult(this);
    this.container.$context().startActivityForResult(localIntent, this.requestCode);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.ExternalTextToSpeech
 * JD-Core Version:    0.6.2
 */