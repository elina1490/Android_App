package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import java.util.HashMap;
import java.util.Locale;

public class InternalTextToSpeech
  implements ITextToSpeech
{
  private final Activity activity;
  private final ITextToSpeech.TextToSpeechCallback callback;
  private volatile boolean isTtsInitialized;
  private int nextUtteranceId = 1;
  private TextToSpeech tts;

  public InternalTextToSpeech(Activity paramActivity, ITextToSpeech.TextToSpeechCallback paramTextToSpeechCallback)
  {
    this.activity = paramActivity;
    this.callback = paramTextToSpeechCallback;
    initializeTts();
  }

  private void initializeTts()
  {
    if (this.tts == null)
      this.tts = new TextToSpeech(this.activity, new TextToSpeech.OnInitListener()
      {
        public void onInit(int paramAnonymousInt)
        {
          if (paramAnonymousInt == 0)
            InternalTextToSpeech.access$002(InternalTextToSpeech.this, true);
        }
      });
  }

  public void onResume()
  {
    initializeTts();
  }

  public void onStop()
  {
    if (this.tts != null)
    {
      this.tts.shutdown();
      this.isTtsInitialized = false;
      this.tts = null;
    }
  }

  public void speak(String paramString, Locale paramLocale)
  {
    if (this.isTtsInitialized)
    {
      this.tts.setLanguage(paramLocale);
      this.tts.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener()
      {
        public void onUtteranceCompleted(String paramAnonymousString)
        {
          InternalTextToSpeech.this.activity.runOnUiThread(new Runnable()
          {
            public void run()
            {
              InternalTextToSpeech.this.callback.onSuccess();
            }
          });
        }
      });
      HashMap localHashMap = new HashMap();
      int i = this.nextUtteranceId;
      this.nextUtteranceId = (i + 1);
      localHashMap.put("utteranceId", Integer.toString(i));
      TextToSpeech localTextToSpeech = this.tts;
      if (localTextToSpeech.speak(paramString, 0, localHashMap) == -1)
        this.callback.onFailure();
      return;
    }
    this.callback.onFailure();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.InternalTextToSpeech
 * JD-Core Version:    0.6.2
 */