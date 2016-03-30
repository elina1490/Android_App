package gnu.kawa.models;

public abstract interface Window
{
  public abstract Display getDisplay();

  public abstract String getTitle();

  public abstract void open();

  public abstract void setContent(Object paramObject);

  public abstract void setMenuBar(Object paramObject);

  public abstract void setTitle(String paramString);
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.Window
 * JD-Core Version:    0.6.2
 */