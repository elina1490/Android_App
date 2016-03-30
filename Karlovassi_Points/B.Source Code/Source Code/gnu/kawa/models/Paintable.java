package gnu.kawa.models;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public abstract interface Paintable
{
  public abstract Rectangle2D getBounds2D();

  public abstract void paint(Graphics2D paramGraphics2D);

  public abstract Paintable transform(AffineTransform paramAffineTransform);
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.Paintable
 * JD-Core Version:    0.6.2
 */