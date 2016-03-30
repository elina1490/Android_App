package com.google.appinventor.components.runtime;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import com.google.appinventor.components.annotations.SimpleObject;

@SimpleObject
public class TableLayout
  implements Layout
{
  private final Handler handler;
  private final android.widget.TableLayout layoutManager;
  private int numColumns;
  private int numRows;

  TableLayout(Context paramContext, int paramInt1, int paramInt2)
  {
    this.layoutManager = new android.widget.TableLayout(paramContext);
    this.numColumns = paramInt1;
    this.numRows = paramInt2;
    this.handler = new Handler();
    for (int i = 0; i < paramInt2; i++)
    {
      TableRow localTableRow = new TableRow(paramContext);
      for (int j = 0; j < paramInt1; j++)
        localTableRow.addView(newEmptyCellView(), j, newEmptyCellLayoutParams());
      this.layoutManager.addView(localTableRow, i, new TableLayout.LayoutParams());
    }
  }

  private void addChild(AndroidViewComponent paramAndroidViewComponent)
  {
    int i = paramAndroidViewComponent.Row();
    int j = paramAndroidViewComponent.Column();
    if ((i == -1) || (j == -1))
    {
      addChildLater(paramAndroidViewComponent);
      return;
    }
    if ((i >= 0) && (i < this.numRows))
    {
      if ((j >= 0) && (j < this.numColumns))
      {
        TableRow localTableRow = (TableRow)this.layoutManager.getChildAt(i);
        localTableRow.removeViewAt(j);
        View localView = paramAndroidViewComponent.getView();
        localTableRow.addView(localView, j, localView.getLayoutParams());
        return;
      }
      Log.e("TableLayout", "Child has illegal Column property: " + paramAndroidViewComponent);
      return;
    }
    Log.e("TableLayout", "Child has illegal Row property: " + paramAndroidViewComponent);
  }

  private void addChildLater(final AndroidViewComponent paramAndroidViewComponent)
  {
    this.handler.post(new Runnable()
    {
      public void run()
      {
        TableLayout.this.addChild(paramAndroidViewComponent);
      }
    });
  }

  private static TableRow.LayoutParams newCellLayoutParams()
  {
    return new TableRow.LayoutParams();
  }

  private static TableRow.LayoutParams newEmptyCellLayoutParams()
  {
    return new TableRow.LayoutParams(0, 0);
  }

  private View newEmptyCellView()
  {
    return new TextView(this.layoutManager.getContext());
  }

  public void add(AndroidViewComponent paramAndroidViewComponent)
  {
    paramAndroidViewComponent.getView().setLayoutParams(newCellLayoutParams());
    addChildLater(paramAndroidViewComponent);
  }

  public ViewGroup getLayoutManager()
  {
    return this.layoutManager;
  }

  int getNumColumns()
  {
    return this.numColumns;
  }

  int getNumRows()
  {
    return this.numRows;
  }

  void setNumColumns(int paramInt)
  {
    if (paramInt > this.numColumns)
    {
      this.layoutManager.getContext();
      for (j = 0; j < this.numRows; j++)
      {
        localTableRow = (TableRow)this.layoutManager.getChildAt(j);
        for (k = this.numColumns; k < paramInt; k++)
          localTableRow.addView(newEmptyCellView(), k, newEmptyCellLayoutParams());
      }
      this.numColumns = paramInt;
    }
    while (paramInt >= this.numColumns)
    {
      int j;
      TableRow localTableRow;
      int k;
      return;
    }
    for (int i = 0; i < this.numRows; i++)
      ((TableRow)this.layoutManager.getChildAt(i)).removeViews(paramInt, this.numColumns - paramInt);
    this.numColumns = paramInt;
  }

  void setNumRows(int paramInt)
  {
    if (paramInt > this.numRows)
    {
      localContext = this.layoutManager.getContext();
      for (i = this.numRows; i < paramInt; i++)
      {
        localTableRow = new TableRow(localContext);
        for (j = 0; j < this.numColumns; j++)
          localTableRow.addView(newEmptyCellView(), j, newEmptyCellLayoutParams());
        this.layoutManager.addView(localTableRow, i, new TableLayout.LayoutParams());
      }
      this.numRows = paramInt;
    }
    while (paramInt >= this.numRows)
    {
      Context localContext;
      int i;
      TableRow localTableRow;
      int j;
      return;
    }
    this.layoutManager.removeViews(paramInt, this.numRows - paramInt);
    this.numRows = paramInt;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.TableLayout
 * JD-Core Version:    0.6.2
 */