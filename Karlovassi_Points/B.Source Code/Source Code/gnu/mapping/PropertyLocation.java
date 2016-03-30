package gnu.mapping;

import gnu.lists.LList;
import gnu.lists.Pair;

public class PropertyLocation extends Location
{
  Pair pair;

  public static Object getProperty(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return getProperty(paramObject1, paramObject2, paramObject3, Environment.getCurrent());
  }

  public static Object getProperty(Object paramObject1, Object paramObject2, Object paramObject3, Environment paramEnvironment)
  {
    if (!(paramObject1 instanceof Symbol))
    {
      if ((paramObject1 instanceof String))
        paramObject1 = Namespace.getDefaultSymbol((String)paramObject1);
    }
    else
      return paramEnvironment.get((Symbol)paramObject1, paramObject2, paramObject3);
    return plistGet(paramEnvironment.get(Symbol.PLIST, paramObject1, LList.Empty), paramObject2, paramObject3);
  }

  public static Object getPropertyList(Object paramObject)
  {
    return Environment.getCurrent().get(Symbol.PLIST, paramObject, LList.Empty);
  }

  public static Object getPropertyList(Object paramObject, Environment paramEnvironment)
  {
    return paramEnvironment.get(Symbol.PLIST, paramObject, LList.Empty);
  }

  public static Object plistGet(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    while ((paramObject1 instanceof Pair))
    {
      Pair localPair = (Pair)paramObject1;
      if (localPair.getCar() == paramObject2)
        return ((Pair)localPair.getCdr()).getCar();
    }
    return paramObject3;
  }

  public static Object plistPut(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Pair localPair2;
    for (Object localObject = paramObject1; (localObject instanceof Pair); localObject = localPair2.getCdr())
    {
      Pair localPair1 = (Pair)localObject;
      localPair2 = (Pair)localPair1.getCdr();
      if (localPair1.getCar() == paramObject2)
      {
        localPair2.setCar(paramObject3);
        return paramObject1;
      }
    }
    return new Pair(paramObject2, new Pair(paramObject3, paramObject1));
  }

  public static Object plistRemove(Object paramObject1, Object paramObject2)
  {
    Object localObject1 = null;
    Object localObject2 = paramObject1;
    while ((localObject2 instanceof Pair))
    {
      Pair localPair1 = (Pair)localObject2;
      Pair localPair2 = (Pair)localPair1.getCdr();
      localObject2 = localPair2.getCdr();
      if (localPair1.getCar() == paramObject2)
      {
        if (localObject1 == null)
          return localObject2;
        localObject1.setCdr(localObject2);
        return paramObject1;
      }
      localObject1 = localPair2;
    }
    return paramObject1;
  }

  public static void putProperty(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    putProperty(paramObject1, paramObject2, paramObject3, Environment.getCurrent());
  }

  public static void putProperty(Object paramObject1, Object paramObject2, Object paramObject3, Environment paramEnvironment)
  {
    if (!(paramObject1 instanceof Symbol))
    {
      if ((paramObject1 instanceof String))
        paramObject1 = Namespace.getDefaultSymbol((String)paramObject1);
    }
    else
    {
      Location localLocation1 = paramEnvironment.lookup((Symbol)paramObject1, paramObject2);
      if (localLocation1 == null)
        break label92;
      Location localLocation3 = localLocation1.getBase();
      if (!(localLocation3 instanceof PropertyLocation))
        break label92;
      ((PropertyLocation)localLocation3).set(paramObject3);
      return;
    }
    Location localLocation4 = paramEnvironment.getLocation(Symbol.PLIST, paramObject1);
    localLocation4.set(plistPut(localLocation4.get(LList.Empty), paramObject2, paramObject3));
    return;
    label92: Location localLocation2 = paramEnvironment.getLocation(Symbol.PLIST, paramObject1);
    Pair localPair = new Pair(paramObject3, localLocation2.get(LList.Empty));
    localLocation2.set(new Pair(paramObject2, localPair));
    PropertyLocation localPropertyLocation = new PropertyLocation();
    localPropertyLocation.pair = localPair;
    paramEnvironment.addLocation((Symbol)paramObject1, paramObject2, localPropertyLocation);
  }

  public static boolean removeProperty(Object paramObject1, Object paramObject2)
  {
    return removeProperty(paramObject1, paramObject2, Environment.getCurrent());
  }

  public static boolean removeProperty(Object paramObject1, Object paramObject2, Environment paramEnvironment)
  {
    Location localLocation = paramEnvironment.lookup(Symbol.PLIST, paramObject1);
    if (localLocation == null)
      return false;
    Object localObject1 = localLocation.get(LList.Empty);
    if (!(localObject1 instanceof Pair))
      return false;
    Pair localPair1 = (Pair)localObject1;
    Pair localPair2 = null;
    Object localObject3;
    if (localPair1.getCar() == paramObject2)
    {
      localObject3 = ((Pair)localPair1.getCdr()).getCdr();
      if (localPair2 != null)
        break label127;
      localLocation.set(localObject3);
    }
    while (true)
    {
      if ((paramObject1 instanceof Symbol))
        paramEnvironment.remove((Symbol)paramObject1, paramObject2);
      return true;
      Object localObject2 = localPair1.getCdr();
      if (!(localObject2 instanceof Pair))
        return false;
      localPair2 = localPair1;
      localPair1 = (Pair)localObject2;
      break;
      label127: localPair2.setCdr(localObject3);
    }
  }

  public static void setPropertyList(Object paramObject1, Object paramObject2)
  {
    setPropertyList(paramObject1, paramObject2, Environment.getCurrent());
  }

  public static void setPropertyList(Object paramObject1, Object paramObject2, Environment paramEnvironment)
  {
    try
    {
      Location localLocation1 = paramEnvironment.lookup(Symbol.PLIST, paramObject1);
      Symbol localSymbol;
      if ((paramObject1 instanceof Symbol))
        localSymbol = (Symbol)paramObject1;
      Object localObject3;
      Pair localPair3;
      for (Object localObject2 = localLocation1.get(LList.Empty); ; localObject2 = ((Pair)localPair3.getCdr()).getCdr())
      {
        if (!(localObject2 instanceof Pair))
        {
          localObject3 = paramObject2;
          if ((localObject3 instanceof Pair))
            break;
          localLocation1.set(paramObject2);
          return;
        }
        localPair3 = (Pair)localObject2;
        Object localObject5 = localPair3.getCar();
        if (plistGet(paramObject2, localObject5, null) != null)
          paramEnvironment.remove(localSymbol, localObject5);
      }
      Pair localPair1 = (Pair)localObject3;
      Object localObject4 = localPair1.getCar();
      Location localLocation2 = paramEnvironment.lookup(localSymbol, localObject4);
      PropertyLocation localPropertyLocation;
      if (localLocation2 != null)
      {
        Location localLocation3 = localLocation2.getBase();
        if ((localLocation3 instanceof PropertyLocation))
          localPropertyLocation = (PropertyLocation)localLocation3;
      }
      while (true)
      {
        Pair localPair2 = (Pair)localPair1.getCdr();
        localPropertyLocation.pair = localPair2;
        localObject3 = localPair2.getCdr();
        break;
        localPropertyLocation = new PropertyLocation();
        paramEnvironment.addLocation(localSymbol, localObject4, localPropertyLocation);
      }
    }
    finally
    {
    }
  }

  public final Object get(Object paramObject)
  {
    return this.pair.getCar();
  }

  public boolean isBound()
  {
    return true;
  }

  public final void set(Object paramObject)
  {
    this.pair.setCar(paramObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.PropertyLocation
 * JD-Core Version:    0.6.2
 */