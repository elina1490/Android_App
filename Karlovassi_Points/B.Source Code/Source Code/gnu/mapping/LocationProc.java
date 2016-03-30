package gnu.mapping;

public class LocationProc extends Procedure0or1
  implements HasSetter
{
  Location loc;

  public LocationProc(Location paramLocation)
  {
    this.loc = paramLocation;
  }

  public LocationProc(Location paramLocation, Procedure paramProcedure)
  {
    this.loc = paramLocation;
    if (paramProcedure != null)
      pushConverter(paramProcedure);
  }

  public static LocationProc makeNamed(Symbol paramSymbol, Location paramLocation)
  {
    LocationProc localLocationProc = new LocationProc(paramLocation);
    localLocationProc.setSymbol(paramSymbol);
    return localLocationProc;
  }

  public Object apply0()
    throws Throwable
  {
    return this.loc.get();
  }

  public Object apply1(Object paramObject)
    throws Throwable
  {
    set0(paramObject);
    return Values.empty;
  }

  public final Location getLocation()
  {
    return this.loc;
  }

  public Procedure getSetter()
  {
    return new Setter0(this);
  }

  public void pushConverter(Procedure paramProcedure)
  {
    this.loc = ConstrainedLocation.make(this.loc, paramProcedure);
  }

  public void set0(Object paramObject)
    throws Throwable
  {
    this.loc.set(paramObject);
  }

  public String toString()
  {
    if (getSymbol() != null)
      return super.toString();
    return "#<location-proc " + this.loc + ">";
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.LocationProc
 * JD-Core Version:    0.6.2
 */