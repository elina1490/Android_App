package com.google.appinventor.components.runtime;

import android.media.SoundPool;
import android.os.Vibrator;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.MediaUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@DesignerComponent(category=ComponentCategory.MEDIA, description="<p>A multimedia component that plays sound files and optionally vibrates for the number of milliseconds (thousandths of a second) specified in the Blocks Editor.  The name of the sound file to play can be specified either in the Designer or in the Blocks Editor.</p> <p>For legal sound and video formats, see <a href=\"http://developer.android.com/guide/appendix/media-formats.html\" target=\"_blank\">Android Supported Media Formats</a>.</p><p>This component is best for short sound files, such as sound effects, while the <code>Player</code> component is more efficient for longer sounds, such as songs.</p>", iconName="images/soundEffect.png", nonVisible=true, version=3)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.VIBRATE, android.permission.INTERNET")
public class Sound extends AndroidNonvisibleComponent
  implements Component, OnResumeListener, OnStopListener, OnDestroyListener, Deleteable
{
  private static final int LOOP_MODE_NO_LOOP = 0;
  private static final int MAX_STREAMS = 10;
  private static final float PLAYBACK_RATE_NORMAL = 1.0F;
  private static final float VOLUME_FULL = 1.0F;
  private int minimumInterval;
  private int soundId;
  private final Map<String, Integer> soundMap = new HashMap();
  private SoundPool soundPool = new SoundPool(10, 3, 0);
  private String sourcePath = "";
  private int streamId;
  private long timeLastPlayed;
  private final Vibrator vibe = (Vibrator)this.form.getSystemService("vibrator");

  public Sound(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.form.registerForOnResume(this);
    this.form.registerForOnStop(this);
    this.form.registerForOnDestroy(this);
    this.form.setVolumeControlStream(3);
    MinimumInterval(500);
  }

  private void prepareToDie()
  {
    if (this.streamId != 0)
    {
      this.soundPool.stop(this.streamId);
      this.soundPool.unload(this.streamId);
    }
    this.soundPool.release();
    this.vibe.cancel();
    this.soundPool = null;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The minimum interval...")
  public int MinimumInterval()
  {
    return this.minimumInterval;
  }

  @DesignerProperty(defaultValue="500", editorType="non_negative_integer")
  @SimpleProperty
  public void MinimumInterval(int paramInt)
  {
    this.minimumInterval = paramInt;
  }

  @SimpleFunction
  public void Pause()
  {
    if (this.streamId != 0)
    {
      this.soundPool.pause(this.streamId);
      return;
    }
    Log.i("Sound", "Unable to pause. Did you remember to call the Play function?");
  }

  @SimpleFunction
  public void Play()
  {
    if (this.soundId != 0)
    {
      long l = System.currentTimeMillis();
      if ((this.timeLastPlayed == 0L) || (l >= this.timeLastPlayed + this.minimumInterval))
      {
        this.timeLastPlayed = l;
        this.streamId = this.soundPool.play(this.soundId, 1.0F, 1.0F, 0, 0, 1.0F);
        Log.i("Sound", "SoundPool.play returned stream id " + this.streamId);
        if (this.streamId == 0)
        {
          Form localForm = this.form;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = this.sourcePath;
          localForm.dispatchErrorOccurredEvent(this, "Play", 703, arrayOfObject);
        }
        return;
      }
      Log.i("Sound", "Unable to play because MinimumInterval has not elapsed since last play.");
      return;
    }
    Log.i("Sound", "Unable to play. Did you remember to set the Source property?");
  }

  @SimpleFunction
  public void Resume()
  {
    if (this.streamId != 0)
    {
      this.soundPool.resume(this.streamId);
      return;
    }
    Log.i("Sound", "Unable to resume. Did you remember to call the Play function?");
  }

  @SimpleEvent(description="The SoundError event is no longer used. Please use the Screen.ErrorOccurred event instead.", userVisible=false)
  public void SoundError(String paramString)
  {
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The name of the sound file.  Only <a href=\"http://developer.android.com/guide/appendix/media-formats.html\">certain formats</a> are supported.")
  public String Source()
  {
    return this.sourcePath;
  }

  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty
  public void Source(String paramString)
  {
    if (paramString == null);
    for (String str = ""; ; str = paramString)
    {
      this.sourcePath = str;
      if (this.streamId != 0)
      {
        this.soundPool.stop(this.streamId);
        this.streamId = 0;
      }
      this.soundId = 0;
      if (this.sourcePath.length() != 0)
      {
        Integer localInteger = (Integer)this.soundMap.get(this.sourcePath);
        if (localInteger == null)
          break;
        this.soundId = localInteger.intValue();
      }
      return;
    }
    Log.i("Sound", "No existing sound with path " + this.sourcePath + ".");
    try
    {
      int i = MediaUtil.loadSoundPool(this.soundPool, this.form, this.sourcePath);
      if (i != 0)
      {
        this.soundMap.put(this.sourcePath, Integer.valueOf(i));
        Log.i("Sound", "Successfully loaded sound: setting soundId to " + i + ".");
        this.soundId = i;
        return;
      }
    }
    catch (IOException localIOException)
    {
      Form localForm1 = this.form;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.sourcePath;
      localForm1.dispatchErrorOccurredEvent(this, "Source", 701, arrayOfObject1);
      return;
    }
    Form localForm2 = this.form;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = this.sourcePath;
    localForm2.dispatchErrorOccurredEvent(this, "Source", 701, arrayOfObject2);
  }

  @SimpleFunction
  public void Stop()
  {
    if (this.streamId != 0)
    {
      this.soundPool.stop(this.streamId);
      this.streamId = 0;
      return;
    }
    Log.i("Sound", "Unable to stop. Did you remember to call the Play function?");
  }

  @SimpleFunction
  public void Vibrate(int paramInt)
  {
    this.vibe.vibrate(paramInt);
  }

  public void onDelete()
  {
    prepareToDie();
  }

  public void onDestroy()
  {
    prepareToDie();
  }

  public void onResume()
  {
    Log.i("Sound", "Got onResume");
    if (this.streamId != 0)
      this.soundPool.resume(this.streamId);
  }

  public void onStop()
  {
    Log.i("Sound", "Got onStop");
    if (this.streamId != 0)
      this.soundPool.pause(this.streamId);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Sound
 * JD-Core Version:    0.6.2
 */