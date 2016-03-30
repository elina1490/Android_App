package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts.People;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;

@DesignerComponent(category=ComponentCategory.SOCIAL, description="<p>A button that, when clicked on, displays a list of the contacts to choose among. After the user has made a selection, the following properties will be set to information about the chosen contact: <ul><li> <code>ContactName</code>: the contact's name </li> <li> <code>EmailAddress</code>: the contact's primary email address </li> <li> <code>Picture</code>: the name of the file containing the contact's image, which can be used as a <code>Picture</code> property value for the <code>Image</code> or <code>ImageSprite</code> component.</li></ul></p><p>Other properties affect the appearance of the button (<code>TextAlignment</code>, <code>BackgroundColor</code>, etc.) and whether it can be clicked on (<code>Enabled</code>).</p><p>Picking is not supported on all phones.  If it fails, this component will show a notification.  The error behavior can be overridden with the Screen.ErrorOccurred event handler.</p>", version=4)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.READ_CONTACTS")
public class ContactPicker extends Picker
  implements ActivityResultListener
{
  private static final int EMAIL_INDEX = 1;
  private static final int NAME_INDEX;
  private static final String[] PROJECTION = { "name", "primary_email" };
  protected final Activity activityContext;
  protected String contactName;
  protected String contactPictureUri;
  protected String emailAddress;
  private final Uri intentUri;

  public ContactPicker(ComponentContainer paramComponentContainer)
  {
    this(paramComponentContainer, Contacts.People.CONTENT_URI);
  }

  protected ContactPicker(ComponentContainer paramComponentContainer, Uri paramUri)
  {
    super(paramComponentContainer);
    this.activityContext = paramComponentContainer.$context();
    this.intentUri = paramUri;
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String ContactName()
  {
    return ensureNotNull(this.contactName);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String EmailAddress()
  {
    return ensureNotNull(this.emailAddress);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String Picture()
  {
    return ensureNotNull(this.contactPictureUri);
  }

  protected boolean checkContactUri(Uri paramUri, String paramString)
  {
    Log.i("ContactPicker", "contactUri is " + paramUri);
    if ((paramUri == null) || (!"content".equals(paramUri.getScheme())))
    {
      Log.i("ContactPicker", "checkContactUri failed: A");
      puntContactSelection(1107);
      return false;
    }
    String str = paramUri.getSchemeSpecificPart();
    if (str.startsWith("//com.android.contacts/contact"))
    {
      Log.i("ContactPicker", "checkContactUri failed: B");
      puntContactSelection(1108);
      return false;
    }
    if (!str.startsWith(paramString))
    {
      Log.i("ContactPicker", "checkContactUri failed: C");
      Log.i("Contact Picker", paramUri.getPath());
      puntContactSelection(1107);
      return false;
    }
    return true;
  }

  protected String ensureNotNull(String paramString)
  {
    if (paramString == null)
      return "";
    return paramString;
  }

  // ERROR //
  protected String getEmailAddress(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 153	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4: istore_3
    //   5: ldc 144
    //   7: astore 4
    //   9: new 87	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   16: ldc 155
    //   18: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_3
    //   22: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 5
    //   30: iconst_1
    //   31: anewarray 36	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc 160
    //   38: aastore
    //   39: astore 6
    //   41: aload_0
    //   42: getfield 62	com/google/appinventor/components/runtime/ContactPicker:activityContext	Landroid/app/Activity;
    //   45: invokevirtual 166	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   48: getstatic 171	android/provider/Contacts$ContactMethods:CONTENT_EMAIL_URI	Landroid/net/Uri;
    //   51: aload 6
    //   53: aload 5
    //   55: aconst_null
    //   56: aconst_null
    //   57: invokevirtual 177	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 7
    //   62: aload 7
    //   64: invokeinterface 183 1 0
    //   69: ifeq +16 -> 85
    //   72: aload_0
    //   73: aload 7
    //   75: iconst_0
    //   76: invokevirtual 187	com/google/appinventor/components/runtime/ContactPicker:guardCursorGetString	(Landroid/database/Cursor;I)Ljava/lang/String;
    //   79: astore 9
    //   81: aload 9
    //   83: astore 4
    //   85: aload 7
    //   87: invokeinterface 190 1 0
    //   92: aload_0
    //   93: aload 4
    //   95: invokevirtual 75	com/google/appinventor/components/runtime/ContactPicker:ensureNotNull	(Ljava/lang/String;)Ljava/lang/String;
    //   98: areturn
    //   99: astore_2
    //   100: ldc 144
    //   102: areturn
    //   103: astore 8
    //   105: aload 7
    //   107: invokeinterface 190 1 0
    //   112: aload 8
    //   114: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	99	java/lang/NumberFormatException
    //   62	81	103	finally
  }

  protected Intent getIntent()
  {
    return new Intent("android.intent.action.PICK", this.intentUri);
  }

  protected String guardCursorGetString(Cursor paramCursor, int paramInt)
  {
    try
    {
      String str2 = paramCursor.getString(paramInt);
      str1 = str2;
      return ensureNotNull(str1);
    }
    catch (Exception localException)
    {
      while (true)
        String str1 = "";
    }
  }

  protected void puntContactSelection(int paramInt)
  {
    this.contactName = "";
    this.emailAddress = "";
    this.contactPictureUri = "";
    this.container.$form().dispatchErrorOccurredEvent(this, "", paramInt, new Object[0]);
  }

  public void resultReturned(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Uri localUri;
    Cursor localCursor;
    if ((paramInt1 == this.requestCode) && (paramInt2 == -1))
    {
      Log.i("ContactPicker", "received intent is " + paramIntent);
      localUri = paramIntent.getData();
      if (checkContactUri(localUri, "//contacts/people"))
        localCursor = null;
    }
    try
    {
      localCursor = this.activityContext.getContentResolver().query(localUri, PROJECTION, null, null, null);
      if (localCursor.moveToFirst())
      {
        this.contactName = guardCursorGetString(localCursor, 0);
        this.emailAddress = getEmailAddress(guardCursorGetString(localCursor, 1));
        this.contactPictureUri = localUri.toString();
        Log.i("ContactPicker", "Contact name = " + this.contactName + ", email address = " + this.emailAddress + ", contactPhotoUri = " + this.contactPictureUri);
      }
      localCursor.close();
      AfterPicking();
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.i("ContactPicker", "checkContactUri failed: D");
        puntContactSelection(1107);
        localCursor.close();
      }
    }
    finally
    {
      localCursor.close();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.ContactPicker
 * JD-Core Version:    0.6.2
 */