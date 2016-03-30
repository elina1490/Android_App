package com.google.appinventor.components.runtime;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.MediaController;
import android.widget.VideoView;
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
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.IOException;

@DesignerComponent(category=ComponentCategory.MEDIA, description="A multimedia component capable of playing videos. When the application is run, the VideoPlayer will be displayed as a rectangle on-screen.  If the user touches the rectangle, controls will appear to play/pause, skip ahead, and skip backward within the video.  The application can also control behavior by calling the <code>Start</code>, <code>Pause</code>, and <code>SeekTo</code> methods.  <p>Video files should be in Windows Media Video (.wmv) format, 3GPP (.3gp), or MPEG-4 (.mp4).  For more details about legal formats, see <a href=\"http://developer.android.com/guide/appendix/media-formats.html\" target=\"_blank\">Android Supported Media Formats</a>.</p><p>App Inventor for Android only permits video files under 1 MB and limits the total size of an application to 5 MB, not all of which is available for media (video, audio, and sound) files.  If your media files are too large, you may get errors when packaging or installing your application, in which case you should reduce the number of media files or their sizes.  Most video editing software, such as Windows Movie Maker and Apple iMovie, can help you decrease the size of videos by shortening them or re-encoding the video into a more compact format.</p>", version=4)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.INTERNET")
public final class VideoPlayer extends AndroidViewComponent
  implements OnDestroyListener, Deleteable, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private boolean delayedStart = false;
  private boolean inFullScreen = false;
  private boolean mediaReady = false;
  private String sourcePath;
  private final ResizableVideoView videoView;

  public VideoPlayer(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer);
    paramComponentContainer.$form().registerForOnDestroy(this);
    this.videoView = new ResizableVideoView(paramComponentContainer.$context());
    this.videoView.setMediaController(new MediaController(paramComponentContainer.$context()));
    this.videoView.setOnCompletionListener(this);
    this.videoView.setOnErrorListener(this);
    this.videoView.setOnPreparedListener(this);
    paramComponentContainer.$add(this);
    paramComponentContainer.setChildWidth(this, 176);
    paramComponentContainer.setChildHeight(this, 144);
    paramComponentContainer.$form().setVolumeControlStream(3);
    this.sourcePath = "";
  }

  private void prepareToDie()
  {
    if (this.videoView.isPlaying())
      this.videoView.stopPlayback();
    this.videoView.setVideoURI(null);
    this.videoView.clearAnimation();
    this.delayedStart = false;
    this.mediaReady = false;
    if (this.inFullScreen)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("FullScreenKey", false);
      this.container.$form().fullScreenVideoAction(195, this, localBundle);
    }
  }

  @SimpleEvent
  public void Completed()
  {
    EventDispatcher.dispatchEvent(this, "Completed", new Object[0]);
  }

  @SimpleProperty(userVisible=true)
  public void FullScreen(boolean paramBoolean)
  {
    if ((paramBoolean) && (SdkLevel.getLevel() <= 4))
      this.container.$form().dispatchErrorOccurredEvent(this, "FullScreen(true)", 1303, new Object[0]);
    while (paramBoolean == this.inFullScreen)
      return;
    if (paramBoolean)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putInt("PositionKey", this.videoView.getCurrentPosition());
      localBundle1.putBoolean("PlayingKey", this.videoView.isPlaying());
      this.videoView.pause();
      localBundle1.putBoolean("FullScreenKey", true);
      localBundle1.putString("SourceKey", this.sourcePath);
      if (this.container.$form().fullScreenVideoAction(195, this, localBundle1).getBoolean("ActionSuccess"))
      {
        this.inFullScreen = true;
        return;
      }
      this.inFullScreen = false;
      this.container.$form().dispatchErrorOccurredEvent(this, "FullScreen", 1301, new Object[] { "" });
      return;
    }
    Bundle localBundle2 = new Bundle();
    localBundle2.putBoolean("FullScreenKey", false);
    Bundle localBundle3 = this.container.$form().fullScreenVideoAction(195, this, localBundle2);
    if (localBundle3.getBoolean("ActionSuccess"))
    {
      fullScreenKilled(localBundle3);
      return;
    }
    this.inFullScreen = true;
    this.container.$form().dispatchErrorOccurredEvent(this, "FullScreen", 1302, new Object[] { "" });
  }

  @SimpleProperty
  public boolean FullScreen()
  {
    return this.inFullScreen;
  }

  @SimpleFunction(description="Returns duration of the video in milliseconds.")
  public int GetDuration()
  {
    Log.i("VideoPlayer", "Calling GetDuration");
    if (this.inFullScreen)
    {
      Bundle localBundle = this.container.$form().fullScreenVideoAction(196, this, null);
      if (localBundle.getBoolean("ActionSuccess"))
        return localBundle.getInt("ActionData");
      return 0;
    }
    return this.videoView.getDuration();
  }

  @SimpleProperty
  public int Height()
  {
    return super.Height();
  }

  @SimpleProperty(userVisible=true)
  public void Height(int paramInt)
  {
    super.Height(paramInt);
    this.videoView.changeVideoSize(this.videoView.forcedWidth, paramInt);
  }

  @SimpleFunction(description="Pauses playback of the video.  Playback can be resumed at the same location by calling the <code>Start</code> method.")
  public void Pause()
  {
    Log.i("VideoPlayer", "Calling Pause");
    if (this.inFullScreen)
    {
      this.container.$form().fullScreenVideoAction(192, this, null);
      this.delayedStart = false;
      return;
    }
    this.delayedStart = false;
    this.videoView.pause();
  }

  @SimpleFunction(description="Seeks to the requested time (specified in milliseconds) in the video. Note that if the video is paused, the frame shown will not be updated by the seek. ")
  public void SeekTo(int paramInt)
  {
    Log.i("VideoPlayer", "Calling SeekTo");
    if (paramInt < 0)
      paramInt = 0;
    if (this.inFullScreen)
    {
      this.container.$form().fullScreenVideoAction(190, this, Integer.valueOf(paramInt));
      return;
    }
    this.videoView.seekTo(paramInt);
  }

  @DesignerProperty(defaultValue="", editorType="asset")
  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="The \"path\" to the video.  Usually, this will be the name of the video file, which should be added in the Designer.")
  public void Source(String paramString)
  {
    if (this.inFullScreen)
    {
      this.container.$form().fullScreenVideoAction(194, this, paramString);
      return;
    }
    String str;
    if (paramString == null)
      str = "";
    while (true)
    {
      this.sourcePath = str;
      this.videoView.invalidateMediaPlayer(true);
      if (this.videoView.isPlaying())
        this.videoView.stopPlayback();
      this.videoView.setVideoURI(null);
      this.videoView.clearAnimation();
      if (this.sourcePath.length() <= 0)
        break;
      Log.i("VideoPlayer", "Source path is " + this.sourcePath);
      try
      {
        this.mediaReady = false;
        MediaUtil.loadVideoView(this.videoView, this.container.$form(), this.sourcePath);
        Log.i("VideoPlayer", "loading video succeeded");
        return;
        str = paramString;
      }
      catch (IOException localIOException)
      {
        Form localForm = this.container.$form();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.sourcePath;
        localForm.dispatchErrorOccurredEvent(this, "Source", 701, arrayOfObject);
      }
    }
  }

  @SimpleFunction(description="Starts playback of the video.")
  public void Start()
  {
    Log.i("VideoPlayer", "Calling Start");
    if (this.inFullScreen)
    {
      this.container.$form().fullScreenVideoAction(191, this, null);
      return;
    }
    if (this.mediaReady)
    {
      this.videoView.start();
      return;
    }
    this.delayedStart = true;
  }

  @SimpleEvent(description="The VideoPlayerError event is no longer used. Please use the Screen.ErrorOccurred event instead.", userVisible=false)
  public void VideoPlayerError(String paramString)
  {
  }

  @SimpleProperty
  public int Width()
  {
    return super.Width();
  }

  @SimpleProperty(userVisible=true)
  public void Width(int paramInt)
  {
    super.Width(paramInt);
    this.videoView.changeVideoSize(paramInt, this.videoView.forcedHeight);
  }

  public void delayedStart()
  {
    this.delayedStart = true;
    Start();
  }

  public void fullScreenKilled(Bundle paramBundle)
  {
    this.inFullScreen = false;
    String str = paramBundle.getString("SourceKey");
    if (!str.equals(this.sourcePath))
      Source(str);
    this.videoView.setVisibility(0);
    this.videoView.requestLayout();
    SeekTo(paramBundle.getInt("PositionKey"));
    if (paramBundle.getBoolean("PlayingKey"))
      Start();
  }

  public int getPassedHeight()
  {
    return this.videoView.forcedHeight;
  }

  public int getPassedWidth()
  {
    return this.videoView.forcedWidth;
  }

  public View getView()
  {
    return this.videoView;
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

  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.videoView.invalidateMediaPlayer(true);
    this.delayedStart = false;
    this.mediaReady = false;
    Log.e("VideoPlayer", "onError: what is " + paramInt1 + " 0x" + Integer.toHexString(paramInt1) + ", extra is " + paramInt2 + " 0x" + Integer.toHexString(paramInt2));
    Form localForm = this.container.$form();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.sourcePath;
    localForm.dispatchErrorOccurredEvent(this, "Source", 701, arrayOfObject);
    return true;
  }

  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.mediaReady = true;
    this.delayedStart = false;
    this.videoView.setMediaPlayer(paramMediaPlayer, true);
    if (this.delayedStart)
      Start();
  }

  class ResizableVideoView extends VideoView
  {
    public int forcedHeight = -1;
    public int forcedWidth = -1;
    private Boolean mFoundMediaPlayer = Boolean.valueOf(false);
    private MediaPlayer mVideoPlayer;

    public ResizableVideoView(Context arg2)
    {
      super();
    }

    public void changeVideoSize(int paramInt1, int paramInt2)
    {
      this.forcedWidth = paramInt1;
      this.forcedHeight = paramInt2;
      forceLayout();
      invalidate();
    }

    public void invalidateMediaPlayer(boolean paramBoolean)
    {
      this.mFoundMediaPlayer = Boolean.valueOf(false);
      this.mVideoPlayer = null;
      if (paramBoolean)
      {
        forceLayout();
        invalidate();
      }
    }

    public void onMeasure(int paramInt1, int paramInt2)
    {
      Log.i("VideoPlayer..onMeasure", "AI setting dimensions as:" + this.forcedWidth + ":" + this.forcedHeight);
      Log.i("VideoPlayer..onMeasure", "Dimenions from super>>" + View.MeasureSpec.getSize(paramInt1) + ":" + View.MeasureSpec.getSize(paramInt2));
      int i = 176;
      int j = 144;
      switch (this.forcedWidth)
      {
      default:
        i = this.forcedWidth;
        switch (this.forcedHeight)
        {
        default:
          j = this.forcedHeight;
        case -2:
        case -1:
        }
        break;
      case -2:
      case -1:
      }
      while (true)
      {
        while (true)
        {
          while (true)
          {
            Log.i("VideoPlayer.onMeasure", "Setting dimensions to:" + i + "x" + j);
            getHolder().setFixedSize(i, j);
            setMeasuredDimension(i, j);
            return;
            switch (View.MeasureSpec.getMode(paramInt1))
            {
            default:
              break;
            case 1073741824:
            case -2147483648:
              i = View.MeasureSpec.getSize(paramInt1);
              break;
            case 0:
              try
              {
                int k = ((View)getParent()).getMeasuredWidth();
                i = k;
              }
              catch (ClassCastException localClassCastException)
              {
                i = 176;
              }
              catch (NullPointerException localNullPointerException3)
              {
                i = 176;
              }
            }
          }
          break;
          if (!this.mFoundMediaPlayer.booleanValue())
            break;
          try
          {
            i = this.mVideoPlayer.getVideoWidth();
            Log.i("VideoPlayer.onMeasure", "Got width from MediaPlayer>" + i);
          }
          catch (NullPointerException localNullPointerException1)
          {
            Log.e("VideoPlayer..onMeasure", "Failed to get MediaPlayer for width:\n" + localNullPointerException1.getMessage());
            i = 176;
          }
        }
        break;
        switch (View.MeasureSpec.getMode(paramInt2))
        {
        default:
          break;
        case 1073741824:
        case -2147483648:
          j = View.MeasureSpec.getSize(paramInt2);
          continue;
          if (this.mFoundMediaPlayer.booleanValue())
            try
            {
              j = this.mVideoPlayer.getVideoHeight();
              Log.i("VideoPlayer.onMeasure", "Got height from MediaPlayer>" + j);
            }
            catch (NullPointerException localNullPointerException2)
            {
              Log.e("VideoPlayer..onMeasure", "Failed to get MediaPlayer for height:\n" + localNullPointerException2.getMessage());
              j = 144;
            }
          break;
        }
      }
    }

    public void setMediaPlayer(MediaPlayer paramMediaPlayer, boolean paramBoolean)
    {
      this.mVideoPlayer = paramMediaPlayer;
      this.mFoundMediaPlayer = Boolean.valueOf(true);
      if (paramBoolean)
      {
        forceLayout();
        invalidate();
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.VideoPlayer
 * JD-Core Version:    0.6.2
 */