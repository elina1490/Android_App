package gnu.kawa.models;

import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class WithComposite
  implements Paintable
{
  Composite[] composite;
  Paintable[] paintable;

  public static WithComposite make(Paintable paramPaintable, Composite paramComposite)
  {
    WithComposite localWithComposite = new WithComposite();
    localWithComposite.paintable = new Paintable[] { paramPaintable };
    localWithComposite.composite = new Composite[] { paramComposite };
    return localWithComposite;
  }

  public static WithComposite make(Paintable[] paramArrayOfPaintable, Composite[] paramArrayOfComposite)
  {
    WithComposite localWithComposite = new WithComposite();
    localWithComposite.paintable = paramArrayOfPaintable;
    localWithComposite.composite = paramArrayOfComposite;
    return localWithComposite;
  }

  public static WithComposite make(Object[] paramArrayOfObject)
  {
    int i = 0;
    int j = paramArrayOfObject.length;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      if ((paramArrayOfObject[j] instanceof Paintable))
        i++;
    }
    Paintable[] arrayOfPaintable = new Paintable[i];
    Composite[] arrayOfComposite = new Composite[i];
    Composite localComposite = null;
    int k = 0;
    int m = 0;
    if (m < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[m];
      if ((localObject instanceof Paintable))
      {
        arrayOfPaintable[k] = ((Paintable)paramArrayOfObject[m]);
        arrayOfComposite[k] = localComposite;
        k++;
      }
      while (true)
      {
        m++;
        break;
        localComposite = (Composite)localObject;
      }
    }
    return make(arrayOfPaintable, arrayOfComposite);
  }

  public Rectangle2D getBounds2D()
  {
    int i = this.paintable.length;
    if (i == 0)
      return null;
    Rectangle2D localRectangle2D = this.paintable[0].getBounds2D();
    for (int j = 1; j < i; j++)
      localRectangle2D = localRectangle2D.createUnion(this.paintable[j].getBounds2D());
    return localRectangle2D;
  }

  public void paint(Graphics2D paramGraphics2D)
  {
    Composite localComposite1 = paramGraphics2D.getComposite();
    Object localObject1 = localComposite1;
    try
    {
      int i = this.paintable.length;
      for (int j = 0; j < i; j++)
      {
        Composite localComposite2 = this.composite[j];
        if ((localComposite2 != null) && (localComposite2 != localObject1))
        {
          paramGraphics2D.setComposite(localComposite2);
          localObject1 = localComposite2;
        }
        this.paintable[j].paint(paramGraphics2D);
      }
      return;
    }
    finally
    {
      if (localObject1 != localComposite1)
        paramGraphics2D.setComposite(localComposite1);
    }
  }

  public Paintable transform(AffineTransform paramAffineTransform)
  {
    int i = this.paintable.length;
    Paintable[] arrayOfPaintable = new Paintable[i];
    for (int j = 0; j < i; j++)
      arrayOfPaintable[j] = this.paintable[j].transform(paramAffineTransform);
    return make(arrayOfPaintable, this.composite);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.WithComposite
 * JD-Core Version:    0.6.2
 */