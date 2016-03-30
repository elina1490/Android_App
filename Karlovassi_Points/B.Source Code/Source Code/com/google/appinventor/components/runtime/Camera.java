package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import java.io.File;
import java.util.Date;

@DesignerComponent(category=ComponentCategory.MEDIA, description="A component to take a picture using the device's camera. After the picture is taken, the name of the file on the phone containing the picture is available as an argument to the AfterPicture event. The file name can be used, for example, to set the Picture property of an Image component.", iconName="images/camera.png", nonVisible=true, version=1)
@SimpleObject
public class Camera extends AndroidNonvisibleComponent
  implements ActivityResultListener, Component
{
  private static final String CAMERA_INTENT = "android.media.action.IMAGE_CAPTURE";
  private static final String CAMERA_OUTPUT = "output";
  private final ComponentContainer container;
  private Uri imageFile;
  private int requestCode;

  public Camera(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer.$form());
    this.container = paramComponentContainer;
  }

  private void deleteFile(Uri paramUri)
  {
    File localFile = new File(paramUri.getPath());
    try
    {
      if (localFile.delete())
      {
        Log.i("CameraComponent", "Deleted file " + paramUri.toString());
        return;
      }
      Log.i("CameraComponent", "Could not delete file " + paramUri.toString());
      return;
    }
    catch (SecurityException localSecurityException)
    {
      Log.i("CameraComponent", "Got security exception trying to delete file " + paramUri.toString());
    }
  }

  @SimpleEvent
  public void AfterPicture(String paramString)
  {
    EventDispatcher.dispatchEvent(this, "AfterPicture", new Object[] { paramString });
  }

  @SimpleFunction
  public void TakePicture()
  {
    Date localDate = new Date();
    String str = Environment.getExternalStorageState();
    if ("mounted".equals(str))
    {
      Log.i("CameraComponent", "External storage is available and writable");
      this.imageFile = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "/Pictures/app_inventor_" + localDate.getTime() + ".jpg"));
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("_data", this.imageFile.getPath());
      localContentValues.put("mime_type", "image/jpeg");
      localContentValues.put("title", this.imageFile.getLastPathSegment());
      if (this.requestCode == 0)
        this.requestCode = this.form.registerForActivityResult(this);
      Uri localUri = this.container.$context().getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, localContentValues);
      Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      localIntent.putExtra("output", localUri);
      this.container.$context().startActivityForResult(localIntent, this.requestCode);
      return;
    }
    if ("mounted_ro".equals(str))
    {
      this.form.dispatchErrorOccurredEvent(this, "TakePicture", 704, new Object[0]);
      return;
    }
    this.form.dispatchErrorOccurredEvent(this, "TakePicture", 705, new Object[0]);
  }

  public void resultReturned(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.i("CameraComponent", "Returning result. Request code = " + paramInt1 + ", result code = " + paramInt2);
    if ((paramInt1 == this.requestCode) && (paramInt2 == -1))
    {
      if (new File(this.imageFile.getPath()).length() != 0L)
      {
        AfterPicture(this.imageFile.toString());
        return;
      }
      deleteFile(this.imageFile);
      if ((paramIntent != null) && (paramIntent.getData() != null))
      {
        Uri localUri = paramIntent.getData();
        Log.i("CameraComponent", "Calling Camera.AfterPicture with image path " + localUri.toString());
        AfterPicture(localUri.toString());
        return;
      }
      Log.i("CameraComponent", "Couldn't find an image file from the Camera result");
      this.form.dispatchErrorOccurredEvent(this, "TakePicture", 201, new Object[0]);
      return;
    }
    deleteFile(this.imageFile);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.Camera
 * JD-Core Version:    0.6.2
 */