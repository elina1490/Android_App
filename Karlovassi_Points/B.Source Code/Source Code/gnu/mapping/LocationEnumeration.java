package gnu.mapping;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LocationEnumeration
  implements Iterator<Location>, Enumeration<Location>
{
  NamedLocation[] bindings;
  SimpleEnvironment env;
  int index;
  LocationEnumeration inherited;
  NamedLocation nextLoc;
  NamedLocation prevLoc;

  public LocationEnumeration(SimpleEnvironment paramSimpleEnvironment)
  {
    this(paramSimpleEnvironment.table, 1 << paramSimpleEnvironment.log2Size);
  }

  public LocationEnumeration(NamedLocation[] paramArrayOfNamedLocation, int paramInt)
  {
    this.bindings = paramArrayOfNamedLocation;
    this.index = paramInt;
  }

  public boolean hasMoreElements()
  {
    return this.env.hasMoreElements(this);
  }

  public boolean hasNext()
  {
    return hasMoreElements();
  }

  public Location next()
  {
    return nextElement();
  }

  public Location nextElement()
  {
    return nextLocation();
  }

  public Location nextLocation()
  {
    if ((this.nextLoc == null) && (!hasMoreElements()))
      throw new NoSuchElementException();
    NamedLocation localNamedLocation2;
    if (this.prevLoc == null)
    {
      localNamedLocation2 = this.bindings[this.index];
      if (this.nextLoc == localNamedLocation2);
    }
    for (this.prevLoc = localNamedLocation2; (this.prevLoc != null) && (this.prevLoc.next != this.nextLoc); this.prevLoc = this.prevLoc.next);
    NamedLocation localNamedLocation1 = this.nextLoc;
    this.nextLoc = this.nextLoc.next;
    return localNamedLocation1;
  }

  public void remove()
  {
    if (this.prevLoc != null);
    for (NamedLocation localNamedLocation = this.prevLoc.next; (localNamedLocation == null) || (localNamedLocation.next != this.nextLoc); localNamedLocation = this.bindings[this.index])
      throw new IllegalStateException();
    localNamedLocation.next = null;
    if (this.prevLoc != null)
      this.prevLoc.next = this.nextLoc;
    while (true)
    {
      SimpleEnvironment localSimpleEnvironment = this.env;
      localSimpleEnvironment.num_bindings -= 1;
      return;
      this.bindings[this.index] = this.nextLoc;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.LocationEnumeration
 * JD-Core Version:    0.6.2
 */