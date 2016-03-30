package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts.People;
import android.provider.Contacts.Phones;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;

@DesignerComponent(category=ComponentCategory.SOCIAL, description="<p>A button that, when clicked on, displays a list of the contacts' phone numbers to choose among. After the user has made a selection, the following properties will be set to information about the chosen contact: <ul><li> <code>ContactName</code>: the contact's name </li> <li> <code>PhoneNumber</code>: the contact's phone number </li> <li> <code>EmailAddress</code>: the contact's email address </li> <li> <code>Picture</code>: the name of the file containing the contact's image, which can be used as a <code>Picture</code> property value for the <code>Image</code> or <code>ImageSprite</code> component.</li></ul></p><p>Other properties affect the appearance of the button (<code>TextAlignment</code>, <code>BackgroundColor</code>, etc.) and whether it can be clicked on (<code>Enabled</code>).</p><p>Picking is not supported on all phones.  If it fails, this component will show a notification.  This default error behavior can be overridden with the Screen.ErrorOccurred event handler.</p>", version=4)
@SimpleObject
@UsesPermissions(permissionNames="android.permission.READ_CONTACTS")
public class PhoneNumberPicker extends ContactPicker
{
  private static final int EMAIL_INDEX = 3;
  private static final int NAME_INDEX = 0;
  private static final int NUMBER_INDEX = 1;
  private static final int PERSON_INDEX = 2;
  private static final String[] PROJECTION = { "name", "number", "person", "primary_email" };
  private String phoneNumber;

  public PhoneNumberPicker(ComponentContainer paramComponentContainer)
  {
    super(paramComponentContainer, Contacts.Phones.CONTENT_URI);
  }

  @SimpleProperty(category=PropertyCategory.BEHAVIOR)
  public String PhoneNumber()
  {
    return ensureNotNull(this.phoneNumber);
  }

  public void resultReturned(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Uri localUri;
    Cursor localCursor;
    if ((paramInt1 == this.requestCode) && (paramInt2 == -1))
    {
      Log.i("PhoneNumberPicker", "received intent is " + paramIntent);
      localUri = paramIntent.getData();
      if (checkContactUri(localUri, "//contacts/phones"))
        localCursor = null;
    }
    try
    {
      localCursor = this.activityContext.getContentResolver().query(localUri, PROJECTION, null, null, null);
      if (localCursor.moveToFirst())
      {
        this.contactName = guardCursorGetString(localCursor, 0);
        this.phoneNumber = guardCursorGetString(localCursor, 1);
        int i = localCursor.getInt(2);
        this.contactPictureUri = ContentUris.withAppendedId(Contacts.People.CONTENT_URI, i).toString();
        this.emailAddress = getEmailAddress(guardCursorGetString(localCursor, 3));
        Log.i("PhoneNumberPicker", "Contact name = " + this.contactName + ", phone number = " + this.phoneNumber + ", emailAddress = " + this.emailAddress + ", contactPhotoUri = " + this.contactPictureUri);
      }
      if (localCursor != null)
        localCursor.close();
      AfterPicking();
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        puntContactSelection(1107);
        if (localCursor != null)
          localCursor.close();
      }
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.PhoneNumberPicker
 * JD-Core Version:    0.6.2
 */