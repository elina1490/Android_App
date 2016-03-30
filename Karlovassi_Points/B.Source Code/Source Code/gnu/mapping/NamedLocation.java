package gnu.mapping;

import java.util.Map.Entry;

public abstract class NamedLocation extends IndirectableLocation
  implements Map.Entry, EnvironmentKey
{
  final Symbol name;
  NamedLocation next;
  final Object property;

  public NamedLocation(NamedLocation paramNamedLocation)
  {
    this.name = paramNamedLocation.name;
    this.property = paramNamedLocation.property;
  }

  public NamedLocation(Symbol paramSymbol, Object paramObject)
  {
    this.name = paramSymbol;
    this.property = paramObject;
  }

  public boolean entered()
  {
    return this.next != null;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof NamedLocation))
      return false;
    NamedLocation localNamedLocation = (NamedLocation)paramObject;
    if (this.name == null)
    {
      if (localNamedLocation.name == null);
    }
    else
      while (!this.name.equals(localNamedLocation.name))
        return false;
    if (this.property != localNamedLocation.property)
      return false;
    Object localObject1 = getValue();
    Object localObject2 = localNamedLocation.getValue();
    if (localObject1 == localObject2)
      return true;
    if ((localObject1 == null) || (localObject2 == null))
      return false;
    return localObject1.equals(localObject2);
  }

  public Environment getEnvironment()
  {
    for (NamedLocation localNamedLocation = this; localNamedLocation != null; localNamedLocation = localNamedLocation.next)
      if (localNamedLocation.name == null)
      {
        Environment localEnvironment = (Environment)localNamedLocation.value;
        if (localEnvironment != null)
          return localEnvironment;
      }
    return super.getEnvironment();
  }

  public final Object getKey()
  {
    if (this.property == null)
      return this.name;
    return this;
  }

  public final Object getKeyProperty()
  {
    return this.property;
  }

  public final Symbol getKeySymbol()
  {
    return this.name;
  }

  public int hashCode()
  {
    int i = this.name.hashCode() ^ System.identityHashCode(this.property);
    Object localObject = getValue();
    if (localObject != null)
      i ^= localObject.hashCode();
    return i;
  }

  public final boolean matches(EnvironmentKey paramEnvironmentKey)
  {
    return (Symbol.equals(paramEnvironmentKey.getKeySymbol(), this.name)) && (paramEnvironmentKey.getKeyProperty() == this.property);
  }

  public final boolean matches(Symbol paramSymbol, Object paramObject)
  {
    return (Symbol.equals(paramSymbol, this.name)) && (paramObject == this.property);
  }

  public void setRestore(Object paramObject)
  {
    while (true)
    {
      try
      {
        if (this.value == INDIRECT_FLUIDS)
        {
          this.base.setRestore(paramObject);
          return;
        }
        if ((paramObject instanceof Location))
        {
          this.value = null;
          this.base = ((Location)paramObject);
          continue;
        }
      }
      finally
      {
      }
      this.value = paramObject;
      this.base = null;
    }
  }

  public Object setWithSave(Object paramObject)
  {
    try
    {
      Object localObject3;
      if (this.value == INDIRECT_FLUIDS)
        localObject3 = this.base.setWithSave(paramObject);
      ThreadLocation localThreadLocation;
      for (Object localObject2 = localObject3; ; localObject2 = localThreadLocation.global)
      {
        return localObject2;
        localThreadLocation = ThreadLocation.makeAnonymous(this.name);
        localThreadLocation.global.base = this.base;
        localThreadLocation.global.value = this.value;
        setAlias(localThreadLocation);
        NamedLocation localNamedLocation = localThreadLocation.getLocation();
        localNamedLocation.value = paramObject;
        localNamedLocation.base = null;
      }
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.NamedLocation
 * JD-Core Version:    0.6.2
 */