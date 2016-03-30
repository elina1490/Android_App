package com.google.appinventor.components.runtime;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.provider.Contacts.ContactMethods;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EmailAddressAdapter extends ResourceCursorAdapter
{
  public static final int DATA_INDEX = 2;
  public static final int NAME_INDEX = 1;
  private static final String[] PROJECTION = { "_id", "name", "data" };
  private static final String SORT_ORDER = "times_contacted DESC, name";
  private ContentResolver contentResolver;

  public EmailAddressAdapter(Context paramContext)
  {
    super(paramContext, 17367050, null);
    this.contentResolver = paramContext.getContentResolver();
  }

  private final String makeDisplayString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = paramCursor.getString(1);
    String str2 = paramCursor.getString(2);
    boolean bool = TextUtils.isEmpty(str1);
    int i = 0;
    if (!bool)
    {
      localStringBuilder.append(str1);
      i = 1;
    }
    if (i != 0)
      localStringBuilder.append(" <");
    localStringBuilder.append(str2);
    if (i != 0)
      localStringBuilder.append(">");
    return localStringBuilder.toString();
  }

  public final void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ((TextView)paramView).setText(makeDisplayString(paramCursor));
  }

  public final String convertToString(Cursor paramCursor)
  {
    return new Rfc822Token(paramCursor.getString(1), paramCursor.getString(2), null).toString();
  }

  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    String str1 = null;
    if (paramCharSequence != null)
    {
      String str2 = DatabaseUtils.sqlEscapeString(paramCharSequence.toString() + '%');
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(people.name LIKE ");
      localStringBuilder.append(str2);
      localStringBuilder.append(") OR (contact_methods.data LIKE ");
      localStringBuilder.append(str2);
      localStringBuilder.append(")");
      str1 = localStringBuilder.toString();
    }
    return this.contentResolver.query(Contacts.ContactMethods.CONTENT_EMAIL_URI, PROJECTION, str1, null, "times_contacted DESC, name");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.EmailAddressAdapter
 * JD-Core Version:    0.6.2
 */