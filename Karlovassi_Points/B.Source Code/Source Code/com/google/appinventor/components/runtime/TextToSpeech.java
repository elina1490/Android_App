package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.util.ExternalTextToSpeech;
import com.google.appinventor.components.runtime.util.ITextToSpeech;
import com.google.appinventor.components.runtime.util.ITextToSpeech.TextToSpeechCallback;
import com.google.appinventor.components.runtime.util.InternalTextToSpeech;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

@DesignerComponent(category=ComponentCategory.MISC, description="Component for using TextToSpeech to speak a message", iconName="images/textToSpeech.png", nonVisible=true, version=1)
@SimpleObject
public class TextToSpeech extends AndroidNonvisibleComponent
  implements Component, OnStopListener, OnResumeListener
{
  private static final String LOG_TAG = "TextToSpeech";
  private static final Map<String, Locale> iso3CountryToLocaleMap;
  private static final Map<String, Locale> iso3LanguageToLocaleMap = Maps.newHashMap();
  private String country;
  private String iso2Country;
  private String iso2Language;
  private String language;
  private boolean result = false;
  private final ITextToSpeech tts;

  static
  {
    iso3CountryToLocaleMap = Maps.newHashMap();
    initLocaleMaps();
  }

  public TextToSpeech(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    Language("");
    Country("");
    int i;
    String str;
    label57: ITextToSpeech.TextToSpeechCallback local1;
    if (SdkLevel.getLevel() < 4)
    {
      i = 1;
      StringBuilder localStringBuilder = new StringBuilder().append("Using ");
      if (i == 0)
        break label139;
      str = "external";
      Log.v("TextToSpeech", str + " TTS library.");
      local1 = new ITextToSpeech.TextToSpeechCallback()
      {
        public void onFailure()
        {
          TextToSpeech.access$002(TextToSpeech.this, false);
          TextToSpeech.this.AfterSpeaking(false);
        }

        public void onSuccess()
        {
          TextToSpeech.access$002(TextToSpeech.this, true);
          TextToSpeech.this.AfterSpeaking(true);
        }
      };
      if (i == 0)
        break label146;
    }
    label139: label146: for (Object localObject = new ExternalTextToSpeech(paramComponentContainer, local1); ; localObject = new InternalTextToSpeech(paramComponentContainer.$context(), local1))
    {
      this.tts = ((ITextToSpeech)localObject);
      this.form.registerForOnStop(this);
      this.form.registerForOnResume(this);
      this.form.setVolumeControlStream(3);
      return;
      i = 0;
      break;
      str = "internal";
      break label57;
    }
  }

  private static void initLocaleMaps()
  {
    Locale[] arrayOfLocale = Locale.getAvailableLocales();
    int i = arrayOfLocale.length;
    int j = 0;
    while (true)
    {
      Locale localLocale;
      if (j < i)
        localLocale = arrayOfLocale[j];
      try
      {
        String str2 = localLocale.getISO3Country();
        if (str2.length() > 0)
          iso3CountryToLocaleMap.put(str2, localLocale);
        try
        {
          label44: String str1 = localLocale.getISO3Language();
          if (str1.length() > 0)
            iso3LanguageToLocaleMap.put(str1, localLocale);
          label70: j++;
          continue;
          return;
        }
        catch (MissingResourceException localMissingResourceException2)
        {
          break label70;
        }
      }
      catch (MissingResourceException localMissingResourceException1)
      {
        break label44;
      }
    }
  }

  private static Locale iso3CountryToLocale(String paramString)
  {
    Locale localLocale = (Locale)iso3CountryToLocaleMap.get(paramString);
    if (localLocale == null)
      localLocale = (Locale)iso3CountryToLocaleMap.get(paramString.toUpperCase(Locale.ENGLISH));
    if (localLocale == null)
      return Locale.getDefault();
    return localLocale;
  }

  private static Locale iso3LanguageToLocale(String paramString)
  {
    Locale localLocale = (Locale)iso3LanguageToLocaleMap.get(paramString);
    if (localLocale == null)
      localLocale = (Locale)iso3LanguageToLocaleMap.get(paramString.toLowerCase(Locale.ENGLISH));
    if (localLocale == null)
      return Locale.getDefault();
    return localLocale;
  }

  @SimpleEvent
  public void AfterSpeaking(boolean paramBoolean)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Boolean.valueOf(paramBoolean);
    EventDispatcher.dispatchEvent(this, "AfterSpeaking", arrayOfObject);
  }

  @SimpleEvent
  public void BeforeSpeaking()
  {
    EventDispatcher.dispatchEvent(this, "BeforeSpeaking", new Object[0]);
  }

  @SimpleProperty
  public String Country()
  {
    return this.country;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public void Country(String paramString)
  {
    Locale localLocale;
    switch (paramString.length())
    {
    default:
      localLocale = Locale.getDefault();
      this.country = localLocale.getCountry();
    case 3:
    case 2:
    }
    while (true)
    {
      this.iso2Country = localLocale.getCountry();
      return;
      localLocale = iso3CountryToLocale(paramString);
      this.country = localLocale.getISO3Country();
      continue;
      localLocale = new Locale(paramString);
      this.country = localLocale.getCountry();
    }
  }

  @SimpleProperty
  public String Language()
  {
    return this.language;
  }

  @DesignerProperty(defaultValue="", editorType="string")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public void Language(String paramString)
  {
    Locale localLocale;
    switch (paramString.length())
    {
    default:
      localLocale = Locale.getDefault();
      this.language = localLocale.getLanguage();
    case 3:
    case 2:
    }
    while (true)
    {
      this.iso2Language = localLocale.getLanguage();
      return;
      localLocale = iso3LanguageToLocale(paramString);
      this.language = localLocale.getISO3Language();
      continue;
      localLocale = new Locale(paramString);
      this.language = localLocale.getLanguage();
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public boolean Result()
  {
    return this.result;
  }

  @SimpleFunction
  public void Speak(String paramString)
  {
    BeforeSpeaking();
    Locale localLocale = new Locale(this.iso2Language, this.iso2Country);
    this.tts.speak(paramString, localLocale);
  }

  public void onResume()
  {
    this.tts.onResume();
  }

  public void onStop()
  {
    this.tts.onStop();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.TextToSpeech
 * JD-Core Version:    0.6.2
 */