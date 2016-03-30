package gnu.kawa.models;

import gnu.lists.FString;
import gnu.mapping.ThreadLocation;
import gnu.mapping.WrappedException;
import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.lang.reflect.Method;

public abstract class Display
{
  public static ThreadLocation myDisplay = new ThreadLocation("my-display");

  public static Dimension asDimension(Dimension2D paramDimension2D)
  {
    if (((paramDimension2D instanceof Dimension)) || (paramDimension2D == null))
      return (Dimension)paramDimension2D;
    return new Dimension((int)(0.5D + paramDimension2D.getWidth()), (int)(0.5D + paramDimension2D.getHeight()));
  }

  public static Display getInstance()
  {
    Object localObject1 = myDisplay.get(null);
    if ((localObject1 instanceof Display))
      return (Display)localObject1;
    Object localObject2;
    if (localObject1 == null)
      localObject2 = "swing";
    while (true)
    {
      Class[] arrayOfClass = new Class[0];
      int i = ((String)localObject2).indexOf(',');
      String str = null;
      if (i >= 0)
      {
        str = ((String)localObject2).substring(i + 1);
        localObject2 = ((String)localObject2).substring(0, i);
      }
      if (((String)localObject2).equals("swing"))
        localObject2 = "gnu.kawa.swingviews.SwingDisplay";
      try
      {
        while (true)
        {
          Display localDisplay = (Display)Class.forName((String)localObject2).getDeclaredMethod("getInstance", arrayOfClass).invoke(null, new Object[0]);
          return localDisplay;
          localObject2 = localObject1.toString();
          break;
          if (((String)localObject2).equals("swt"))
            localObject2 = "gnu.kawa.swtviews.SwtDisplay";
          else if (((String)localObject2).equals("echo2"))
            localObject2 = "gnu.kawa.echo2.Echo2Display";
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        if (str == null)
          throw new RuntimeException("no display toolkit: " + localObject1);
        localObject2 = str;
      }
      catch (Throwable localThrowable)
      {
        throw WrappedException.wrapIfNeeded(localThrowable);
      }
    }
  }

  public abstract void addBox(Box paramBox, Object paramObject);

  public abstract void addButton(Button paramButton, Object paramObject);

  public abstract void addImage(DrawImage paramDrawImage, Object paramObject);

  public abstract void addLabel(Label paramLabel, Object paramObject);

  public void addSpacer(Spacer paramSpacer, Object paramObject)
  {
    throw new Error("makeView called on Spacer");
  }

  public void addText(Text paramText, Object paramObject)
  {
    throw new Error("makeView called on Text");
  }

  public abstract void addView(Object paramObject1, Object paramObject2);

  public Model coerceToModel(Object paramObject)
  {
    if (((paramObject instanceof FString)) || ((paramObject instanceof String)))
      return new Label(paramObject.toString());
    return (Model)paramObject;
  }

  public abstract Window makeWindow();
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.Display
 * JD-Core Version:    0.6.2
 */