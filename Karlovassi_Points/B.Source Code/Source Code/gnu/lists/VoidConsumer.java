package gnu.lists;

public class VoidConsumer extends FilterConsumer
{
  public static VoidConsumer instance = new VoidConsumer();

  public VoidConsumer()
  {
    super(null);
    this.skipping = true;
  }

  public static VoidConsumer getInstance()
  {
    return instance;
  }

  public boolean ignoring()
  {
    return true;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.VoidConsumer
 * JD-Core Version:    0.6.2
 */