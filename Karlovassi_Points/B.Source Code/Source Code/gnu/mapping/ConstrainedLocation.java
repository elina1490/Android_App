package gnu.mapping;

public class ConstrainedLocation extends Location
{
  protected Location base;
  protected Procedure converter;

  public static ConstrainedLocation make(Location paramLocation, Procedure paramProcedure)
  {
    ConstrainedLocation localConstrainedLocation = new ConstrainedLocation();
    localConstrainedLocation.base = paramLocation;
    localConstrainedLocation.converter = paramProcedure;
    return localConstrainedLocation;
  }

  protected Object coerce(Object paramObject)
  {
    try
    {
      Object localObject = this.converter.apply1(paramObject);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw WrappedException.wrapIfNeeded(localThrowable);
    }
  }

  public final Object get(Object paramObject)
  {
    return this.base.get(paramObject);
  }

  public Object getKeyProperty()
  {
    return this.base.getKeyProperty();
  }

  public Symbol getKeySymbol()
  {
    return this.base.getKeySymbol();
  }

  public boolean isBound()
  {
    return this.base.isBound();
  }

  public boolean isConstant()
  {
    return this.base.isConstant();
  }

  public final void set(Object paramObject)
  {
    this.base.set(coerce(paramObject));
  }

  public void setRestore(Object paramObject)
  {
    this.base.setRestore(paramObject);
  }

  public Object setWithSave(Object paramObject)
  {
    return this.base.setWithSave(coerce(paramObject));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.ConstrainedLocation
 * JD-Core Version:    0.6.2
 */