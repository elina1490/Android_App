package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.MediaUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;

@DesignerComponent(category=ComponentCategory.MEDIA, description="A special-purpose button. When the user taps an image picker, the device's image gallery appears, and the user can choose an image. After an image is picked, it is saved on the SD card and the <code>ImageFile</code> property will be the name of the file where the image is stored. In order to not fill up storage, a maximum of 10 images will be stored.  Picking more images will delete previous images, in order from oldest to newest.", version=5)
@SimpleObject
public class ImagePicker extends Picker
  implements ActivityResultListener
{
  private static final String FILE_PREFIX = "picked_image";
  private static final String LOG_TAG = "ImagePicker";
  private static final String imagePickerDirectoryName = "/Pictures/_app_inventor_image_picker";
  private static int maxSavedFiles = 10;
  private String selectionSavedImage = "";
  private String selectionURI;

  public ImagePicker(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer);
  }

  private void copyToExternalStorageAndDeleteSource(File paramFile, String paramString)
  {
    File localFile1 = null;
    File localFile2 = new File(Environment.getExternalStorageDirectory() + "/Pictures/_app_inventor_image_picker");
    try
    {
      localFile2.mkdirs();
      localFile1 = File.createTempFile("picked_image", paramString, localFile2);
      this.selectionSavedImage = localFile1.getPath();
      Log.i("ImagePicker", "saved file path is: " + this.selectionSavedImage);
      localFileInputStream = new FileInputStream(paramFile);
    }
    catch (IOException localIOException1)
    {
      try
      {
        FileInputStream localFileInputStream;
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile1);
        try
        {
          byte[] arrayOfByte = new byte[1024];
          while (true)
          {
            int i = localFileInputStream.read(arrayOfByte);
            if (i <= 0)
              break;
            localFileOutputStream.write(arrayOfByte, 0, i);
          }
        }
        catch (IOException localIOException2)
        {
          localObject = localIOException2;
        }
        while (true)
        {
          String str = "destination is " + this.selectionSavedImage + ": " + "error is " + ((IOException)localObject).getMessage();
          Log.i("ImagePicker", "copyFile failed. " + str);
          this.container.$form().dispatchErrorOccurredEvent(this, "SaveImage", 1601, new Object[] { str });
          this.selectionSavedImage = "";
          localFile1.delete();
          while (true)
          {
            paramFile.delete();
            trimDirectory(maxSavedFiles, localFile2);
            return;
            localFileInputStream.close();
            localFileOutputStream.close();
            Log.i("ImagePicker", "Image was copied to " + this.selectionSavedImage);
          }
          localIOException1 = localIOException1;
          localObject = localIOException1;
        }
      }
      catch (IOException localIOException3)
      {
        while (true)
          Object localObject = localIOException3;
      }
    }
  }

  private void saveSelectedImageToExternalStorage(String paramString)
  {
    this.selectionSavedImage = "";
    try
    {
      File localFile = MediaUtil.copyMediaToTempFile(this.container.$form(), this.selectionURI);
      Log.i("ImagePicker", "temp file path is: " + localFile.getPath());
      copyToExternalStorageAndDeleteSource(localFile, paramString);
      return;
    }
    catch (IOException localIOException)
    {
      Log.i("ImagePicker", "copyMediaToTempFile failed: " + localIOException.getMessage());
      Form localForm = this.container.$form();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localIOException.getMessage();
      localForm.dispatchErrorOccurredEvent(this, "ImagePicker", 1602, arrayOfObject);
    }
  }

  private void trimDirectory(int paramInt, File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    Arrays.sort(arrayOfFile, new Comparator()
    {
      public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        return Long.valueOf(paramAnonymousFile1.lastModified()).compareTo(Long.valueOf(paramAnonymousFile2.lastModified()));
      }
    });
    int i = arrayOfFile.length - paramInt;
    for (int j = 0; j < i; j++)
      arrayOfFile[j].delete();
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR, description="Path to the file containing the image that was selected.")
  public String Selection()
  {
    return this.selectionSavedImage;
  }

  protected Intent getIntent()
  {
    return new Intent("android.intent.action.PICK", MediaStore.Images.Media.INTERNAL_CONTENT_URI);
  }

  public void resultReturned(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == this.requestCode) && (paramInt2 == -1))
    {
      Uri localUri = paramIntent.getData();
      this.selectionURI = localUri.toString();
      Log.i("ImagePicker", "selectionURI = " + this.selectionURI);
      ContentResolver localContentResolver = this.container.$context().getContentResolver();
      MimeTypeMap localMimeTypeMap = MimeTypeMap.getSingleton();
      String str = "." + localMimeTypeMap.getExtensionFromMimeType(localContentResolver.getType(localUri));
      Log.i("ImagePicker", "extension = " + str);
      saveSelectedImageToExternalStorage(str);
      AfterPicking();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.ImagePicker
 * JD-Core Version:    0.6.2
 */