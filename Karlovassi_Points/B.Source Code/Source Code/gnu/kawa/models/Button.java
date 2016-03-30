package gnu.kawa.models;

import java.awt.Color;

public class Button extends Model
{
  Object action;
  Color background;
  boolean disabled;
  Color foreground;
  String text;
  Object width;

  public Object getAction()
  {
    return this.action;
  }

  public Color getBackground()
  {
    return this.background;
  }

  public Color getForeground()
  {
    return this.foreground;
  }

  public String getText()
  {
    return this.text;
  }

  public boolean isDisabled()
  {
    return this.disabled;
  }

  public void makeView(Display paramDisplay, Object paramObject)
  {
    paramDisplay.addButton(this, paramObject);
  }

  public void setAction(Object paramObject)
  {
    this.action = paramObject;
  }

  public void setBackground(Color paramColor)
  {
    this.background = paramColor;
    notifyListeners("background");
  }

  public void setDisabled(boolean paramBoolean)
  {
    this.disabled = paramBoolean;
  }

  public void setForeground(Color paramColor)
  {
    this.foreground = paramColor;
    notifyListeners("foreground");
  }

  public void setText(String paramString)
  {
    this.text = paramString;
    notifyListeners("text");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.Button
 * JD-Core Version:    0.6.2
 */