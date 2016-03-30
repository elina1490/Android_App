package com.google.appinventor.components.runtime;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.FileUtil;
import java.io.File;
import java.io.IOException;

@DesignerComponent(category=ComponentCategory.EXPERIMENTAL, description="<p>Multimedia component that records audio.</p>", iconName="images/soundRecorder.png", nonVisible=true, version=1)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.RECORD_AUDIO")
public final class SoundRecorder extends AndroidNonvisibleComponent
  implements Component, MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener
{
  private static final String TAG = "SoundRecorder";
  private RecordingController controller;

  public SoundRecorder(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
  }

  @SimpleEvent(description="Provides the location of the newly created sound.")
  public void AfterSoundRecorded(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "AfterSoundRecorded", new Object[] { paramString });
  }

  // ERROR //
  @SimpleFunction
  public void Start()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	com/google/appinventor/components/runtime/SoundRecorder:controller	Lcom/google/appinventor/components/runtime/SoundRecorder$RecordingController;
    //   4: ifnull +35 -> 39
    //   7: ldc 29
    //   9: new 64	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   16: ldc 68
    //   18: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: getfield 62	com/google/appinventor/components/runtime/SoundRecorder:controller	Lcom/google/appinventor/components/runtime/SoundRecorder$RecordingController;
    //   25: getfield 77	com/google/appinventor/components/runtime/SoundRecorder$RecordingController:file	Ljava/lang/String;
    //   28: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 87	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   37: pop
    //   38: return
    //   39: ldc 29
    //   41: ldc 89
    //   43: invokestatic 87	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   46: pop
    //   47: invokestatic 94	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   50: ldc 96
    //   52: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   55: ifne +21 -> 76
    //   58: aload_0
    //   59: getfield 106	com/google/appinventor/components/runtime/SoundRecorder:form	Lcom/google/appinventor/components/runtime/Form;
    //   62: aload_0
    //   63: ldc 107
    //   65: sipush 705
    //   68: iconst_0
    //   69: anewarray 49	java/lang/Object
    //   72: invokevirtual 113	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   75: return
    //   76: aload_0
    //   77: new 74	com/google/appinventor/components/runtime/SoundRecorder$RecordingController
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 116	com/google/appinventor/components/runtime/SoundRecorder$RecordingController:<init>	(Lcom/google/appinventor/components/runtime/SoundRecorder;)V
    //   85: putfield 62	com/google/appinventor/components/runtime/SoundRecorder:controller	Lcom/google/appinventor/components/runtime/SoundRecorder$RecordingController;
    //   88: aload_0
    //   89: getfield 62	com/google/appinventor/components/runtime/SoundRecorder:controller	Lcom/google/appinventor/components/runtime/SoundRecorder$RecordingController;
    //   92: invokevirtual 119	com/google/appinventor/components/runtime/SoundRecorder$RecordingController:start	()V
    //   95: aload_0
    //   96: invokevirtual 122	com/google/appinventor/components/runtime/SoundRecorder:StartedRecording	()V
    //   99: return
    //   100: astore_2
    //   101: aload_0
    //   102: getfield 106	com/google/appinventor/components/runtime/SoundRecorder:form	Lcom/google/appinventor/components/runtime/Form;
    //   105: astore_3
    //   106: iconst_1
    //   107: anewarray 49	java/lang/Object
    //   110: astore 4
    //   112: aload 4
    //   114: iconst_0
    //   115: aload_2
    //   116: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   119: aastore
    //   120: aload_3
    //   121: aload_0
    //   122: ldc 107
    //   124: sipush 802
    //   127: aload 4
    //   129: invokevirtual 113	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   132: return
    //   133: astore 5
    //   135: aload_0
    //   136: getfield 62	com/google/appinventor/components/runtime/SoundRecorder:controller	Lcom/google/appinventor/components/runtime/SoundRecorder$RecordingController;
    //   139: invokevirtual 128	com/google/appinventor/components/runtime/SoundRecorder$RecordingController:stop	()V
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 62	com/google/appinventor/components/runtime/SoundRecorder:controller	Lcom/google/appinventor/components/runtime/SoundRecorder$RecordingController;
    //   147: aload_0
    //   148: getfield 106	com/google/appinventor/components/runtime/SoundRecorder:form	Lcom/google/appinventor/components/runtime/Form;
    //   151: astore 6
    //   153: iconst_1
    //   154: anewarray 49	java/lang/Object
    //   157: astore 7
    //   159: aload 7
    //   161: iconst_0
    //   162: aload 5
    //   164: invokevirtual 125	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   167: aastore
    //   168: aload 6
    //   170: aload_0
    //   171: ldc 107
    //   173: sipush 802
    //   176: aload 7
    //   178: invokevirtual 113	com/google/appinventor/components/runtime/Form:dispatchErrorOccurredEvent	(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V
    //   181: return
    //
    // Exception table:
    //   from	to	target	type
    //   76	88	100	java/lang/Throwable
    //   88	95	133	java/lang/Throwable
  }

  @SimpleEvent(description="Indicates that the recorder has started, and can be stopped.")
  public void StartedRecording()
  {
    EventDispatcher.dispatchEvent(this, "StartedRecording", new Object[0]);
  }

  @SimpleFunction
  public void Stop()
  {
    if (this.controller == null)
    {
      Log.i("SoundRecorder", "Stop() called, but already stopped.");
      return;
    }
    try
    {
      Log.i("SoundRecorder", "Stop() called");
      Log.i("SoundRecorder", "stopping");
      this.controller.stop();
      Log.i("SoundRecorder", "Firing AfterSoundRecorded with " + this.controller.file);
      AfterSoundRecorded(this.controller.file);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.form.dispatchErrorOccurredEvent(this, "Stop", 801, new Object[0]);
      return;
    }
    finally
    {
      this.controller = null;
      StoppedRecording();
    }
  }

  @SimpleEvent(description="Indicates that the recorder has stopped, and can be started again.")
  public void StoppedRecording()
  {
    EventDispatcher.dispatchEvent(this, "StoppedRecording", new Object[0]);
  }

  public void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    if ((this.controller == null) || (paramMediaRecorder != this.controller.recorder))
    {
      Log.w("SoundRecorder", "onError called with wrong recorder. Ignoring.");
      return;
    }
    this.form.dispatchErrorOccurredEvent(this, "onError", 801, new Object[0]);
    try
    {
      this.controller.stop();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("SoundRecorder", localThrowable.getMessage());
      return;
    }
    finally
    {
      this.controller = null;
      StoppedRecording();
    }
  }

  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    if ((this.controller == null) || (paramMediaRecorder != this.controller.recorder))
    {
      Log.w("SoundRecorder", "onInfo called with wrong recorder. Ignoring.");
      return;
    }
    Log.i("SoundRecorder", "Recoverable condition while recording. Will attempt to stop normally.");
    this.controller.recorder.stop();
  }

  private class RecordingController
  {
    final String file = FileUtil.getRecordingFile("3gp").getAbsolutePath();
    final MediaRecorder recorder = new MediaRecorder();

    RecordingController()
      throws IOException
    {
      this.recorder.setAudioSource(1);
      this.recorder.setOutputFormat(1);
      this.recorder.setAudioEncoder(1);
      Log.i("SoundRecorder", "Setting output file to " + this.file);
      this.recorder.setOutputFile(this.file);
      Log.i("SoundRecorder", "preparing");
      this.recorder.prepare();
      this.recorder.setOnErrorListener(SoundRecorder.this);
      this.recorder.setOnInfoListener(SoundRecorder.this);
    }

    void start()
    {
      Log.i("SoundRecorder", "starting");
      this.recorder.start();
    }

    void stop()
    {
      this.recorder.setOnErrorListener(null);
      this.recorder.setOnInfoListener(null);
      this.recorder.stop();
      this.recorder.reset();
      this.recorder.release();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.SoundRecorder
 * JD-Core Version:    0.6.2
 */