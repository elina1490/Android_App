package gnu.mapping;

public class ReadOnlyLocation extends ConstrainedLocation
{
  public static ReadOnlyLocation make(Location paramLocation)
  {
    ReadOnlyLocation localReadOnlyLocation = new ReadOnlyLocation();
    localReadOnlyLocation.base = paramLocation;
    return localReadOnlyLocation;
  }

  protected Object coerce(Object paramObject)
  {
    StringBuffer localStringBuffer = new StringBuffer("attempt to modify read-only location");
    Symbol localSymbol = getKeySymbol();
    if (localSymbol != null)
    {
      localStringBuffer.append(": ");
      localStringBuffer.append(localSymbol);
    }
    throw new IllegalStateException(localStringBuffer.toString());
  }

  public boolean isConstant()
  {
    return true;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.ReadOnlyLocation
 * JD-Core Version:    0.6.2
 */