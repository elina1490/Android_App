package gnu.kawa.models;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class DrawShape
  implements Paintable
{
  Shape shape;

  public DrawShape(Shape paramShape)
  {
    this.shape = paramShape;
  }

  public Rectangle2D getBounds2D()
  {
    return this.shape.getBounds2D();
  }

  public void paint(Graphics2D paramGraphics2D)
  {
    paramGraphics2D.draw(this.shape);
  }

  public Paintable transform(AffineTransform paramAffineTransform)
  {
    return new DrawShape(paramAffineTransform.createTransformedShape(this.shape));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.DrawShape
 * JD-Core Version:    0.6.2
 */