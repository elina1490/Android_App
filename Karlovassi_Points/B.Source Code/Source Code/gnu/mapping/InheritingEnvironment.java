package gnu.mapping;

public class InheritingEnvironment extends SimpleEnvironment
{
  int baseTimestamp;
  Environment[] inherited;
  Namespace[] namespaceMap;
  int numInherited;
  Object[] propertyMap;

  public InheritingEnvironment(String paramString, Environment paramEnvironment)
  {
    super(paramString);
    addParent(paramEnvironment);
    if ((paramEnvironment instanceof SimpleEnvironment))
    {
      SimpleEnvironment localSimpleEnvironment = (SimpleEnvironment)paramEnvironment;
      int i = 1 + localSimpleEnvironment.currentTimestamp;
      localSimpleEnvironment.currentTimestamp = i;
      this.baseTimestamp = i;
      this.currentTimestamp = i;
    }
  }

  public void addParent(Environment paramEnvironment)
  {
    if (this.numInherited == 0)
      this.inherited = new Environment[4];
    while (true)
    {
      this.inherited[this.numInherited] = paramEnvironment;
      this.numInherited = (1 + this.numInherited);
      return;
      if (this.numInherited <= this.inherited.length)
      {
        Environment[] arrayOfEnvironment = new Environment[2 * this.numInherited];
        System.arraycopy(this.inherited, 0, arrayOfEnvironment, 0, this.numInherited);
        this.inherited = arrayOfEnvironment;
      }
    }
  }

  public LocationEnumeration enumerateAllLocations()
  {
    LocationEnumeration localLocationEnumeration = new LocationEnumeration(this.table, 1 << this.log2Size);
    localLocationEnumeration.env = this;
    if ((this.inherited != null) && (this.inherited.length > 0))
    {
      localLocationEnumeration.inherited = this.inherited[0].enumerateAllLocations();
      localLocationEnumeration.index = 0;
    }
    return localLocationEnumeration;
  }

  public NamedLocation getLocation(Symbol paramSymbol, Object paramObject, int paramInt, boolean paramBoolean)
  {
    while (true)
    {
      Object localObject2;
      NamedLocation localNamedLocation2;
      NamedLocation localNamedLocation4;
      try
      {
        NamedLocation localNamedLocation1 = lookupDirect(paramSymbol, paramObject, paramInt);
        if (localNamedLocation1 != null)
          if (!paramBoolean)
          {
            boolean bool = localNamedLocation1.isBound();
            if (!bool);
          }
          else
          {
            localObject2 = localNamedLocation1;
            return localObject2;
          }
        if (((0x20 & this.flags) != 0) && (paramBoolean))
        {
          localNamedLocation2 = this.inherited[0].getLocation(paramSymbol, paramObject, paramInt, true);
          if (localNamedLocation2 == null)
            break label216;
          if (!paramBoolean)
            break label250;
          localNamedLocation4 = addUnboundLocation(paramSymbol, paramObject, paramInt);
          if (((0x1 & this.flags) == 0) && (localNamedLocation2.isBound()))
            redefineError(paramSymbol, paramObject, localNamedLocation4);
          localNamedLocation4.base = localNamedLocation2;
          if (localNamedLocation2.value == IndirectableLocation.INDIRECT_FLUIDS)
          {
            localNamedLocation4.value = localNamedLocation2.value;
            if (!(localNamedLocation4 instanceof SharedLocation))
              break label243;
            ((SharedLocation)localNamedLocation4).timestamp = this.baseTimestamp;
            break label243;
          }
        }
        else
        {
          localNamedLocation2 = lookupInherited(paramSymbol, paramObject, paramInt);
          continue;
        }
        if ((0x10 & this.flags) != 0)
        {
          localNamedLocation4.value = IndirectableLocation.DIRECT_ON_SET;
          continue;
        }
      }
      finally
      {
      }
      localNamedLocation4.value = null;
      continue;
      label216: if (paramBoolean)
      {
        NamedLocation localNamedLocation3 = addUnboundLocation(paramSymbol, paramObject, paramInt);
        localObject2 = localNamedLocation3;
      }
      else
      {
        localObject2 = null;
        continue;
        label243: localObject2 = localNamedLocation4;
        continue;
        label250: localObject2 = localNamedLocation2;
      }
    }
  }

  public final int getNumParents()
  {
    return this.numInherited;
  }

  public final Environment getParent(int paramInt)
  {
    return this.inherited[paramInt];
  }

  protected boolean hasMoreElements(LocationEnumeration paramLocationEnumeration)
  {
    if (paramLocationEnumeration.inherited != null);
    while (true)
    {
      NamedLocation localNamedLocation2;
      for (NamedLocation localNamedLocation1 = paramLocationEnumeration.nextLoc; ; localNamedLocation1 = localNamedLocation2.next)
      {
        paramLocationEnumeration.inherited.nextLoc = localNamedLocation1;
        if (!paramLocationEnumeration.inherited.hasMoreElements())
        {
          paramLocationEnumeration.prevLoc = null;
          paramLocationEnumeration.nextLoc = paramLocationEnumeration.inherited.nextLoc;
          int i = 1 + paramLocationEnumeration.index;
          paramLocationEnumeration.index = i;
          if (i != this.numInherited)
            break;
          paramLocationEnumeration.inherited = null;
          paramLocationEnumeration.bindings = this.table;
          paramLocationEnumeration.index = (1 << this.log2Size);
          return super.hasMoreElements(paramLocationEnumeration);
        }
        localNamedLocation2 = paramLocationEnumeration.inherited.nextLoc;
        if (lookup(localNamedLocation2.name, localNamedLocation2.property) == localNamedLocation2)
        {
          paramLocationEnumeration.nextLoc = localNamedLocation2;
          return true;
        }
      }
      paramLocationEnumeration.inherited = this.inherited[paramLocationEnumeration.index].enumerateAllLocations();
    }
  }

  public NamedLocation lookup(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    NamedLocation localNamedLocation = super.lookup(paramSymbol, paramObject, paramInt);
    if ((localNamedLocation != null) && (localNamedLocation.isBound()))
      return localNamedLocation;
    return lookupInherited(paramSymbol, paramObject, paramInt);
  }

  public NamedLocation lookupInherited(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    int i = 0;
    if (i < this.numInherited)
    {
      Symbol localSymbol = paramSymbol;
      Object localObject1 = paramObject;
      Namespace localNamespace1;
      if ((this.namespaceMap != null) && (this.namespaceMap.length > i * 2))
      {
        localNamespace1 = this.namespaceMap[(i * 2)];
        Namespace localNamespace2 = this.namespaceMap[(1 + i * 2)];
        if ((localNamespace1 != null) || (localNamespace2 != null))
          if (paramSymbol.getNamespace() == localNamespace2);
      }
      label160: NamedLocation localNamedLocation;
      do
      {
        Object localObject2;
        Object localObject3;
        do
        {
          i++;
          break;
          localSymbol = Symbol.make(localNamespace1, paramSymbol.getName());
          if ((this.propertyMap == null) || (this.propertyMap.length <= i * 2))
            break label160;
          localObject2 = this.propertyMap[(i * 2)];
          localObject3 = this.propertyMap[(1 + i * 2)];
          if ((localObject2 == null) && (localObject3 == null))
            break label160;
        }
        while (paramObject != localObject3);
        localObject1 = localObject2;
        localNamedLocation = this.inherited[i].lookup(localSymbol, localObject1, paramInt);
      }
      while ((localNamedLocation == null) || (!localNamedLocation.isBound()) || (((localNamedLocation instanceof SharedLocation)) && (((SharedLocation)localNamedLocation).timestamp >= this.baseTimestamp)));
      return localNamedLocation;
    }
    return null;
  }

  protected void toStringBase(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(" baseTs:");
    paramStringBuffer.append(this.baseTimestamp);
    for (int i = 0; i < this.numInherited; i++)
    {
      paramStringBuffer.append(" base:");
      paramStringBuffer.append(this.inherited[i].toStringVerbose());
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.InheritingEnvironment
 * JD-Core Version:    0.6.2
 */