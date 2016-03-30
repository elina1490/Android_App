package gnu.mapping;

public class PlainLocation extends NamedLocation
{
  public PlainLocation(Symbol paramSymbol, Object paramObject)
  {
    super(paramSymbol, paramObject);
  }

  public PlainLocation(Symbol paramSymbol, Object paramObject1, Object paramObject2)
  {
    super(paramSymbol, paramObject1);
    this.value = paramObject2;
  }

  public final Object get(Object paramObject)
  {
    if (this.base != null)
      return this.base.get(paramObject);
    if (this.value == Location.UNBOUND)
      return paramObject;
    return this.value;
  }

  public boolean isBound()
  {
    if (this.base != null)
      return this.base.isBound();
    return this.value != Location.UNBOUND;
  }

  public final void set(Object paramObject)
  {
    if (this.base == null)
    {
      this.value = paramObject;
      return;
    }
    if (this.value == DIRECT_ON_SET)
    {
      this.base = null;
      this.value = paramObject;
      return;
    }
    if (this.base.isConstant())
    {
      getEnvironment().put(getKeySymbol(), getKeyProperty(), paramObject);
      return;
    }
    this.base.set(paramObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.PlainLocation
 * JD-Core Version:    0.6.2
 */