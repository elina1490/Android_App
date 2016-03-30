package gnu.kawa.models;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class WithPaint
  implements Paintable
{
  Paint paint;
  Paintable paintable;

  public WithPaint(Paintable paramPaintable, Paint paramPaint)
  {
    this.paintable = paramPaintable;
    this.paint = paramPaint;
  }

  public Rectangle2D getBounds2D()
  {
    return this.paintable.getBounds2D();
  }

  public void paint(Graphics2D paramGraphics2D)
  {
    Paint localPaint = paramGraphics2D.getPaint();
    try
    {
      paramGraphics2D.setPaint(this.paint);
      this.paintable.paint(paramGraphics2D);
      return;
    }
    finally
    {
      paramGraphics2D.setPaint(localPaint);
    }
  }

  public Paintable transform(AffineTransform paramAffineTransform)
  {
    return new WithPaint(this.paintable.transform(paramAffineTransform), this.paint);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.WithPaint
 * JD-Core Version:    0.6.2
 */