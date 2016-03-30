package com.google.appinventor.components.runtime;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.appinventor.components.runtime.util.AnimationUtil;

public class ListPickerActivity extends ListActivity
{
  private String closeAnim = "";

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    if (localIntent.hasExtra(ListPicker.LIST_ACTIVITY_ANIM_TYPE))
      this.closeAnim = localIntent.getStringExtra(ListPicker.LIST_ACTIVITY_ANIM_TYPE);
    if (localIntent.hasExtra(ListPicker.LIST_ACTIVITY_ARG_NAME))
    {
      setListAdapter(new ArrayAdapter(this, 17367043, getIntent().getStringArrayExtra(ListPicker.LIST_ACTIVITY_ARG_NAME)));
      getListView().setTextFilterEnabled(true);
      return;
    }
    setResult(0);
    finish();
    AnimationUtil.ApplyCloseScreenAnimation(this, this.closeAnim);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
      AnimationUtil.ApplyCloseScreenAnimation(this, this.closeAnim);
      return bool;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent();
    String str = (String)getListView().getItemAtPosition(paramInt);
    localIntent.putExtra(ListPicker.LIST_ACTIVITY_RESULT_NAME, str);
    localIntent.putExtra(ListPicker.LIST_ACTIVITY_RESULT_INDEX, paramInt + 1);
    this.closeAnim = str;
    setResult(-1, localIntent);
    finish();
    AnimationUtil.ApplyCloseScreenAnimation(this, this.closeAnim);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.ListPickerActivity
 * JD-Core Version:    0.6.2
 */