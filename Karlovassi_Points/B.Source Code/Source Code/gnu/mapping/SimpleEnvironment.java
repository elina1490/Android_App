package gnu.mapping;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;
import java.util.Set;

public class SimpleEnvironment extends Environment
{
  int currentTimestamp;
  int log2Size;
  private int mask;
  int num_bindings;
  NamedLocation sharedTail;
  NamedLocation[] table;

  public SimpleEnvironment()
  {
    this(64);
  }

  public SimpleEnvironment(int paramInt)
  {
    for (this.log2Size = 4; paramInt > 1 << this.log2Size; this.log2Size = (1 + this.log2Size));
    int i = 1 << this.log2Size;
    this.table = new NamedLocation[i];
    this.mask = (i - 1);
    this.sharedTail = new PlainLocation(null, null, this);
  }

  public SimpleEnvironment(String paramString)
  {
    this();
    setName(paramString);
  }

  public static Location getCurrentLocation(String paramString)
  {
    return getCurrent().getLocation(paramString, true);
  }

  public static Object lookup_global(Symbol paramSymbol)
    throws UnboundLocationException
  {
    Location localLocation = getCurrent().lookup(paramSymbol);
    if (localLocation == null)
      throw new UnboundLocationException(paramSymbol);
    return localLocation.get();
  }

  NamedLocation addLocation(Symbol paramSymbol, Object paramObject, int paramInt, Location paramLocation)
  {
    if (((paramLocation instanceof ThreadLocation)) && (((ThreadLocation)paramLocation).property == paramObject))
      paramLocation = ((ThreadLocation)paramLocation).getLocation();
    NamedLocation localNamedLocation = lookupDirect(paramSymbol, paramObject, paramInt);
    if (paramLocation == localNamedLocation)
      return localNamedLocation;
    boolean bool;
    if (localNamedLocation != null)
    {
      bool = true;
      if (!bool)
        localNamedLocation = addUnboundLocation(paramSymbol, paramObject, paramInt);
      if ((0x3 & this.flags) != 3)
      {
        if (bool)
          bool = localNamedLocation.isBound();
        if (!bool)
          break label166;
        if ((0x2 & this.flags) == 0)
          label107: redefineError(paramSymbol, paramObject, localNamedLocation);
      }
      label115: if ((0x20 & this.flags) == 0)
        break label186;
    }
    label166: label186: for (localNamedLocation.base = ((SimpleEnvironment)((InheritingEnvironment)this).getParent(0)).addLocation(paramSymbol, paramObject, paramInt, paramLocation); ; localNamedLocation.base = paramLocation)
    {
      localNamedLocation.value = IndirectableLocation.INDIRECT_FLUIDS;
      return localNamedLocation;
      bool = false;
      break;
      if (((0x1 & this.flags) != 0) || (!paramLocation.isBound()))
        break label115;
      break label107;
    }
  }

  public NamedLocation addLocation(Symbol paramSymbol, Object paramObject, Location paramLocation)
  {
    return addLocation(paramSymbol, paramObject, paramSymbol.hashCode() ^ System.identityHashCode(paramObject), paramLocation);
  }

  protected NamedLocation addUnboundLocation(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    NamedLocation localNamedLocation = newEntry(paramSymbol, paramObject, paramInt & this.mask);
    localNamedLocation.base = null;
    localNamedLocation.value = Location.UNBOUND;
    return localNamedLocation;
  }

  public NamedLocation define(Symbol paramSymbol, Object paramObject1, int paramInt, Object paramObject2)
  {
    int i = paramInt & this.mask;
    for (NamedLocation localNamedLocation1 = this.table[i]; ; localNamedLocation1 = localNamedLocation1.next)
    {
      if (localNamedLocation1 == null)
      {
        NamedLocation localNamedLocation2 = newEntry(paramSymbol, paramObject1, i);
        localNamedLocation2.set(paramObject2);
        return localNamedLocation2;
      }
      if (localNamedLocation1.matches(paramSymbol, paramObject1))
      {
        if (localNamedLocation1.isBound())
          if (!getCanDefine())
            break label90;
        while (true)
        {
          localNamedLocation1.base = null;
          localNamedLocation1.value = paramObject2;
          return localNamedLocation1;
          if (!getCanRedefine())
            label90: redefineError(paramSymbol, paramObject1, localNamedLocation1);
        }
      }
    }
  }

  public void define(Symbol paramSymbol, Object paramObject1, Object paramObject2)
  {
    define(paramSymbol, paramObject1, paramSymbol.hashCode() ^ System.identityHashCode(paramObject1), paramObject2);
  }

  public Set entrySet()
  {
    return new EnvironmentMappings(this);
  }

  public LocationEnumeration enumerateAllLocations()
  {
    return enumerateLocations();
  }

  public LocationEnumeration enumerateLocations()
  {
    LocationEnumeration localLocationEnumeration = new LocationEnumeration(this.table, 1 << this.log2Size);
    localLocationEnumeration.env = this;
    return localLocationEnumeration;
  }

  public NamedLocation getLocation(Symbol paramSymbol, Object paramObject, int paramInt, boolean paramBoolean)
  {
    try
    {
      NamedLocation localNamedLocation1 = lookup(paramSymbol, paramObject, paramInt);
      Object localObject2;
      if (localNamedLocation1 != null)
        localObject2 = localNamedLocation1;
      while (true)
      {
        return localObject2;
        if (!paramBoolean)
        {
          localObject2 = null;
        }
        else
        {
          NamedLocation localNamedLocation2 = addUnboundLocation(paramSymbol, paramObject, paramInt);
          localObject2 = localNamedLocation2;
        }
      }
    }
    finally
    {
    }
  }

  protected boolean hasMoreElements(LocationEnumeration paramLocationEnumeration)
  {
    while (true)
      if (paramLocationEnumeration.nextLoc == null)
      {
        paramLocationEnumeration.prevLoc = null;
        int i = paramLocationEnumeration.index - 1;
        paramLocationEnumeration.index = i;
        if (i < 0)
          return false;
        paramLocationEnumeration.nextLoc = paramLocationEnumeration.bindings[paramLocationEnumeration.index];
        if (paramLocationEnumeration.nextLoc == null);
      }
      else
      {
        if (paramLocationEnumeration.nextLoc.name != null)
          break;
        paramLocationEnumeration.nextLoc = paramLocationEnumeration.nextLoc.next;
      }
    return true;
  }

  public NamedLocation lookup(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    return lookupDirect(paramSymbol, paramObject, paramInt);
  }

  public NamedLocation lookupDirect(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    int i = paramInt & this.mask;
    for (NamedLocation localNamedLocation = this.table[i]; localNamedLocation != null; localNamedLocation = localNamedLocation.next)
      if (localNamedLocation.matches(paramSymbol, paramObject))
        return localNamedLocation;
    return null;
  }

  NamedLocation newEntry(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    NamedLocation localNamedLocation1 = newLocation(paramSymbol, paramObject);
    NamedLocation localNamedLocation2 = this.table[paramInt];
    if (localNamedLocation2 == null);
    for (NamedLocation localNamedLocation3 = this.sharedTail; ; localNamedLocation3 = localNamedLocation2)
    {
      localNamedLocation1.next = localNamedLocation3;
      this.table[paramInt] = localNamedLocation1;
      this.num_bindings = (1 + this.num_bindings);
      if (this.num_bindings >= this.table.length)
        rehash();
      return localNamedLocation1;
    }
  }

  NamedLocation newLocation(Symbol paramSymbol, Object paramObject)
  {
    if ((0x8 & this.flags) != 0)
      return new SharedLocation(paramSymbol, paramObject, this.currentTimestamp);
    return new PlainLocation(paramSymbol, paramObject);
  }

  public void put(Symbol paramSymbol, Object paramObject1, Object paramObject2)
  {
    if ((0x4 & this.flags) != 0);
    NamedLocation localNamedLocation;
    for (boolean bool = true; ; bool = false)
    {
      localNamedLocation = getLocation(paramSymbol, paramObject1, bool);
      if (localNamedLocation != null)
        break;
      throw new UnboundLocationException(paramSymbol);
    }
    if (localNamedLocation.isConstant())
      throw new IllegalStateException("attempt to modify read-only location: " + paramSymbol + " in " + this + " loc:" + localNamedLocation);
    localNamedLocation.set(paramObject2);
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    setSymbol(paramObjectInput.readObject());
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    String str = getName();
    Environment localEnvironment = (Environment)envTable.get(str);
    if (localEnvironment != null)
      return localEnvironment;
    envTable.put(str, this);
    return this;
  }

  protected void redefineError(Symbol paramSymbol, Object paramObject, Location paramLocation)
  {
    throw new IllegalStateException("prohibited define/redefine of " + paramSymbol + " in " + this);
  }

  void rehash()
  {
    NamedLocation[] arrayOfNamedLocation1 = this.table;
    int i = arrayOfNamedLocation1.length;
    int j = i * 2;
    NamedLocation[] arrayOfNamedLocation2 = new NamedLocation[j];
    int k = j - 1;
    int m = i;
    while (true)
    {
      m--;
      if (m < 0)
        break;
      NamedLocation localNamedLocation1;
      for (Object localObject1 = arrayOfNamedLocation1[m]; (localObject1 != null) && (localObject1 != this.sharedTail); localObject1 = localNamedLocation1)
      {
        localNamedLocation1 = ((NamedLocation)localObject1).next;
        Symbol localSymbol = ((NamedLocation)localObject1).name;
        Object localObject2 = ((NamedLocation)localObject1).property;
        int n = k & (localSymbol.hashCode() ^ System.identityHashCode(localObject2));
        NamedLocation localNamedLocation2 = arrayOfNamedLocation2[n];
        if (localNamedLocation2 == null)
          localNamedLocation2 = this.sharedTail;
        ((NamedLocation)localObject1).next = localNamedLocation2;
        arrayOfNamedLocation2[n] = localObject1;
      }
    }
    this.table = arrayOfNamedLocation2;
    this.log2Size = (1 + this.log2Size);
    this.mask = k;
  }

  public int size()
  {
    return this.num_bindings;
  }

  protected void toStringBase(StringBuffer paramStringBuffer)
  {
  }

  public String toStringVerbose()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    toStringBase(localStringBuffer);
    return "#<environment " + getName() + " num:" + this.num_bindings + " ts:" + this.currentTimestamp + localStringBuffer + '>';
  }

  public Location unlink(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    int i = paramInt & this.mask;
    Object localObject1 = null;
    NamedLocation localNamedLocation;
    for (Object localObject2 = this.table[i]; localObject2 != null; localObject2 = localNamedLocation)
    {
      localNamedLocation = ((NamedLocation)localObject2).next;
      if (((NamedLocation)localObject2).matches(paramSymbol, paramObject))
      {
        if (!getCanRedefine())
          redefineError(paramSymbol, paramObject, (Location)localObject2);
        if (localObject1 == null)
          this.table[i] = localNamedLocation;
        while (true)
        {
          this.num_bindings -= 1;
          return localObject2;
          localObject1.next = ((NamedLocation)localObject2);
        }
      }
      localObject1 = localObject2;
    }
    return null;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(getSymbol());
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.SimpleEnvironment
 * JD-Core Version:    0.6.2
 */