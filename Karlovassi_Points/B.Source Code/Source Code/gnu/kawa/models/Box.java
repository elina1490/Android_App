package gnu.kawa.models;

import gnu.math.IntNum;
import java.awt.Dimension;
import java.io.Serializable;

public abstract class Box extends Model
  implements Viewable, Serializable
{
  Viewable cellSpacing;
  Viewable[] components;
  int numComponents;

  public void add(Viewable paramViewable)
  {
    Viewable[] arrayOfViewable = this.components;
    int i = this.numComponents;
    if (i == 0)
      this.components = new Serializable[4];
    while (true)
    {
      this.components[i] = paramViewable;
      this.numComponents = (i + 1);
      return;
      if (arrayOfViewable.length <= i)
      {
        this.components = new Serializable[i * 2];
        System.arraycopy(arrayOfViewable, 0, this.components, 0, i);
      }
    }
  }

  public abstract int getAxis();

  public Viewable getCellSpacing()
  {
    return this.cellSpacing;
  }

  public final Viewable getComponent(int paramInt)
  {
    return this.components[paramInt];
  }

  public final int getComponentCount()
  {
    return this.numComponents;
  }

  public void makeView(Display paramDisplay, Object paramObject)
  {
    paramDisplay.addBox(this, paramObject);
  }

  public void setCellSpacing(Object paramObject)
  {
    if (((paramObject instanceof IntNum)) || ((paramObject instanceof Integer)))
    {
      int i = ((Number)paramObject).intValue();
      if (getAxis() == 0);
      for (Dimension localDimension = new Dimension(i, 0); ; localDimension = new Dimension(0, i))
      {
        this.cellSpacing = Spacer.rigidArea(localDimension);
        return;
      }
    }
    this.cellSpacing = ((Serializable)paramObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.Box
 * JD-Core Version:    0.6.2
 */