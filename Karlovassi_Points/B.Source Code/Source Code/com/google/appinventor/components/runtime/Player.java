package com.google.appinventor.components.runtime;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
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
import com.google.appinventor.components.runtime.errors.IllegalArgumentError;
import com.google.appinventor.components.runtime.util.MediaUtil;
import java.io.IOException;

@DesignerComponent(category=ComponentCategory.MEDIA, description="<p>Multimedia component that plays audio or video and controls phone vibration.  The name of a multimedia field is specified in the <code>Source</code> property, which can be set in the Designer or in the Blocks Editor.  The length of time for a vibration is specified in the Blocks Editor in milliseconds (thousandths of a second).</p><p>For legal sound and video formats, see <a href=\"http://developer.android.com/guide/appendix/media-formats.html\" target=\"_blank\">Android Supported Media Formats</a>.</p><p>If you will only be playing sound files and vibrating, not using video, this component is best for long sound files, such as songs, while the <code>Sound</code> component is more efficient for short files, such as sound effects.</p>", iconName="images/player.png", nonVisible=true, version=4)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.VIBRATE, android.permission.INTERNET")
public final class Player extends AndroidNonvisibleComponent
  implements Component, MediaPlayer.OnCompletionListener, OnDestroyListener, Deleteable
{
  private MediaPlayer mp;
  private int playerState;
  private String sourcePath = "";
  private final Vibrator vibe = (Vibrator)this.form.getSystemService("vibrator");

  public Player(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.form.registerForOnDestroy(this);
    this.form.setVolumeControlStream(3);
  }

  private void prepare()
  {
    try
    {
      this.mp.prepare();
      this.playerState = 1;
      Log.i("Player", "Successfully prepared");
      return;
    }
    catch (IOException localIOException)
    {
      this.mp.release();
      this.mp = null;
      this.playerState = 0;
      Form localForm = this.form;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.sourcePath;
      localForm.dispatchErrorOccurredEvent(this, "Source", 702, arrayOfObject);
    }
  }

  private void prepareToDie()
  {
    if ((this.playerState == 1) || (this.playerState == 2))
      this.mp.stop();
    this.playerState = 0;
    if (this.mp != null)
    {
      this.mp.release();
      this.mp = null;
    }
    this.vibe.cancel();
  }

  @SimpleEvent
  public void Completed()
  {
    Log.i("Player", "Calling Completed -- State=" + this.playerState);
    EventDispatcher.dispatchEvent(this, "Completed", new Object[0]);
  }

  @DesignerProperty(defaultValue="False", editorType="boolean")
  @SimpleProperty
  public void IsLooping(boolean paramBoolean)
  {
    if ((this.playerState == 1) || (this.playerState == 2))
    {
      this.mp.setLooping(paramBoolean);
      Log.i("Player", "Looping is " + String.valueOf(paramBoolean));
    }
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the media is looping")
  public boolean IsLooping()
  {
    if ((this.playerState == 1) || (this.playerState == 2))
      return this.mp.isLooping();
    return false;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Whether the media is playing")
  public boolean IsPlaying()
  {
    if ((this.playerState == 1) || (this.playerState == 2))
      return this.mp.isPlaying();
    return false;
  }

  @SimpleFunction
  public void Pause()
  {
    Log.i("Player", "Calling Pause -- State=" + this.playerState);
    if (this.playerState == 2)
    {
      this.mp.pause();
      this.playerState = 2;
    }
  }

  @SimpleEvent(description="The PlayerError event is no longer used. Please use the Screen.ErrorOccurred event instead.", userVisible=false)
  public void PlayerError(String paramString)
  {
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String Source()
  {
    return this.sourcePath;
  }

  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty
  public void Source(String paramString)
  {
    String str;
    if (paramString == null)
      str = "";
    while (true)
    {
      this.sourcePath = str;
      if ((this.playerState == 1) || (this.playerState == 2))
        this.mp.stop();
      this.playerState = 0;
      if (this.mp != null)
      {
        this.mp.release();
        this.mp = null;
      }
      if (this.sourcePath.length() > 0)
      {
        Log.i("Player", "Source path is " + this.sourcePath);
        this.mp = new MediaPlayer();
        this.mp.setOnCompletionListener(this);
      }
      try
      {
        MediaUtil.loadMediaPlayer(this.mp, this.form, this.sourcePath);
        this.mp.setAudioStreamType(3);
        Log.i("Player", "Successfully loaded source path " + this.sourcePath);
        prepare();
        return;
        str = paramString;
      }
      catch (IOException localIOException)
      {
        this.mp.release();
        this.mp = null;
        Form localForm = this.form;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.sourcePath;
        localForm.dispatchErrorOccurredEvent(this, "Source", 701, arrayOfObject);
      }
    }
  }

  @SimpleFunction
  public void Start()
  {
    Log.i("Player", "Calling Start -- State=" + this.playerState);
    if ((this.playerState == 1) || (this.playerState == 2))
    {
      this.mp.start();
      this.playerState = 2;
    }
  }

  @SimpleFunction
  public void Stop()
  {
    Log.i("Player", "Calling Stop -- State=" + this.playerState);
    if ((this.playerState == 1) || (this.playerState == 2))
    {
      this.mp.stop();
      prepare();
      this.mp.seekTo(0);
    }
  }

  @SimpleFunction
  public void Vibrate(long paramLong)
  {
    this.vibe.vibrate(paramLong);
  }

  @DesignerProperty(defaultValue="50", editorType="non_negative_float")
  @SimpleProperty(description="Sets the volume to a number between 0 and 100")
  public void Volume(int paramInt)
  {
    if ((this.playerState == 1) || (this.playerState == 2))
    {
      if ((paramInt > 100) || (paramInt < 0))
        throw new IllegalArgumentError("Volume must be set to a number between 0 and 100");
      this.mp.setVolume(paramInt / 100.0F, paramInt / 100.0F);
      Log.i("Player", "Volume is " + String.valueOf(paramInt));
    }
  }

  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    Completed();
  }

  public void onDelete()
  {
    prepareToDie();
  }

  public void onDestroy()
  {
    prepareToDie();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Player
 * JD-Core Version:    0.6.2
 */