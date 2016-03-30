package gnu.mapping;

import java.util.Hashtable;

public abstract class Environment extends PropertySet
{
  static final int CAN_DEFINE = 1;
  static final int CAN_IMPLICITLY_DEFINE = 4;
  static final int CAN_REDEFINE = 2;
  static final int DIRECT_INHERITED_ON_SET = 16;
  public static final int INDIRECT_DEFINES = 32;
  static final int THREAD_SAFE = 8;
  protected static final InheritedLocal curEnvironment = new InheritedLocal();
  static final Hashtable envTable = new Hashtable(50);
  static Environment global;
  int flags = 23;

  public static Environment current()
  {
    return getCurrent();
  }

  public static Environment getCurrent()
  {
    Object localObject = (Environment)curEnvironment.get();
    if (localObject == null)
    {
      localObject = make(Thread.currentThread().getName(), global);
      ((Environment)localObject).flags = (0x8 | ((Environment)localObject).flags);
      curEnvironment.set(localObject);
    }
    return localObject;
  }

  public static Environment getGlobal()
  {
    return global;
  }

  public static Environment getInstance(String paramString)
  {
    if (paramString == null)
      paramString = "";
    synchronized (envTable)
    {
      Environment localEnvironment = (Environment)envTable.get(paramString);
      if (localEnvironment != null)
        return localEnvironment;
      SimpleEnvironment localSimpleEnvironment = new SimpleEnvironment();
      localSimpleEnvironment.setName(paramString);
      envTable.put(paramString, localSimpleEnvironment);
      return localSimpleEnvironment;
    }
  }

  public static InheritingEnvironment make(String paramString, Environment paramEnvironment)
  {
    return new InheritingEnvironment(paramString, paramEnvironment);
  }

  public static SimpleEnvironment make()
  {
    return new SimpleEnvironment();
  }

  public static SimpleEnvironment make(String paramString)
  {
    return new SimpleEnvironment(paramString);
  }

  public static void restoreCurrent(Environment paramEnvironment)
  {
    curEnvironment.set(paramEnvironment);
  }

  public static void setCurrent(Environment paramEnvironment)
  {
    curEnvironment.set(paramEnvironment);
  }

  public static void setGlobal(Environment paramEnvironment)
  {
    global = paramEnvironment;
  }

  public static Environment setSaveCurrent(Environment paramEnvironment)
  {
    Environment localEnvironment = (Environment)curEnvironment.get();
    curEnvironment.set(paramEnvironment);
    return localEnvironment;
  }

  public static Environment user()
  {
    return getCurrent();
  }

  public abstract NamedLocation addLocation(Symbol paramSymbol, Object paramObject, Location paramLocation);

  public final void addLocation(EnvironmentKey paramEnvironmentKey, Location paramLocation)
  {
    addLocation(paramEnvironmentKey.getKeySymbol(), paramEnvironmentKey.getKeyProperty(), paramLocation);
  }

  public final void addLocation(NamedLocation paramNamedLocation)
  {
    addLocation(paramNamedLocation.getKeySymbol(), paramNamedLocation.getKeyProperty(), paramNamedLocation);
  }

  SimpleEnvironment cloneForThread()
  {
    InheritingEnvironment localInheritingEnvironment1 = new InheritingEnvironment(null, this);
    if ((this instanceof InheritingEnvironment))
    {
      InheritingEnvironment localInheritingEnvironment2 = (InheritingEnvironment)this;
      int i = localInheritingEnvironment2.numInherited;
      localInheritingEnvironment1.numInherited = i;
      localInheritingEnvironment1.inherited = new Environment[i];
      for (int j = 0; j < i; j++)
        localInheritingEnvironment1.inherited[j] = localInheritingEnvironment2.inherited[j];
    }
    LocationEnumeration localLocationEnumeration = enumerateLocations();
    while (localLocationEnumeration.hasMoreElements())
    {
      Location localLocation = localLocationEnumeration.nextLocation();
      Symbol localSymbol = localLocation.getKeySymbol();
      Object localObject1 = localLocation.getKeyProperty();
      if ((localSymbol != null) && ((localLocation instanceof NamedLocation)))
      {
        Object localObject2 = (NamedLocation)localLocation;
        if (((NamedLocation)localObject2).base == null)
        {
          SharedLocation localSharedLocation = new SharedLocation(localSymbol, localObject1, 0);
          localSharedLocation.value = ((NamedLocation)localObject2).value;
          ((NamedLocation)localObject2).base = localSharedLocation;
          ((NamedLocation)localObject2).value = null;
          localObject2 = localSharedLocation;
        }
        localInheritingEnvironment1.addUnboundLocation(localSymbol, localObject1, localSymbol.hashCode() ^ System.identityHashCode(localObject1)).base = ((Location)localObject2);
      }
    }
    return localInheritingEnvironment1;
  }

  public final boolean containsKey(Object paramObject)
  {
    boolean bool = paramObject instanceof EnvironmentKey;
    Object localObject = null;
    if (bool)
    {
      EnvironmentKey localEnvironmentKey = (EnvironmentKey)paramObject;
      paramObject = localEnvironmentKey.getKeySymbol();
      localObject = localEnvironmentKey.getKeyProperty();
    }
    if ((paramObject instanceof Symbol));
    for (Symbol localSymbol = (Symbol)paramObject; ; localSymbol = getSymbol((String)paramObject))
      return isBound(localSymbol, localObject);
  }

  public Namespace defaultNamespace()
  {
    return Namespace.getDefault();
  }

  public abstract void define(Symbol paramSymbol, Object paramObject1, Object paramObject2);

  public abstract LocationEnumeration enumerateAllLocations();

  public abstract LocationEnumeration enumerateLocations();

  public final Object get(EnvironmentKey paramEnvironmentKey, Object paramObject)
  {
    return get(paramEnvironmentKey.getKeySymbol(), paramEnvironmentKey.getKeyProperty(), paramObject);
  }

  public Object get(Symbol paramSymbol)
  {
    String str = Location.UNBOUND;
    Object localObject = get(paramSymbol, null, str);
    if (localObject == str)
      throw new UnboundLocationException(paramSymbol);
    return localObject;
  }

  public Object get(Symbol paramSymbol, Object paramObject1, Object paramObject2)
  {
    Location localLocation = lookup(paramSymbol, paramObject1);
    if (localLocation == null)
      return paramObject2;
    return localLocation.get(paramObject2);
  }

  public final Object get(Object paramObject)
  {
    boolean bool = paramObject instanceof EnvironmentKey;
    Object localObject = null;
    if (bool)
    {
      EnvironmentKey localEnvironmentKey = (EnvironmentKey)paramObject;
      paramObject = localEnvironmentKey.getKeySymbol();
      localObject = localEnvironmentKey.getKeyProperty();
    }
    if ((paramObject instanceof Symbol));
    for (Symbol localSymbol = (Symbol)paramObject; ; localSymbol = getSymbol((String)paramObject))
      return get(localSymbol, localObject, null);
  }

  public final Object get(String paramString, Object paramObject)
  {
    return get(getSymbol(paramString), null, paramObject);
  }

  public boolean getCanDefine()
  {
    return (0x1 & this.flags) != 0;
  }

  public boolean getCanRedefine()
  {
    return (0x2 & this.flags) != 0;
  }

  public final Object getChecked(String paramString)
  {
    Object localObject = get(paramString, Location.UNBOUND);
    if (localObject == Location.UNBOUND)
      throw new UnboundLocationException(paramString + " in " + this);
    return localObject;
  }

  public int getFlags()
  {
    return this.flags;
  }

  public final Object getFunction(Symbol paramSymbol)
  {
    String str = Location.UNBOUND;
    Object localObject = get(paramSymbol, EnvironmentKey.FUNCTION, str);
    if (localObject == str)
      throw new UnboundLocationException(paramSymbol);
    return localObject;
  }

  public final Object getFunction(Symbol paramSymbol, Object paramObject)
  {
    return get(paramSymbol, EnvironmentKey.FUNCTION, paramObject);
  }

  public final Location getLocation(Symbol paramSymbol)
  {
    return getLocation(paramSymbol, null, true);
  }

  public final Location getLocation(Symbol paramSymbol, Object paramObject)
  {
    return getLocation(paramSymbol, paramObject, true);
  }

  public final Location getLocation(Object paramObject, boolean paramBoolean)
  {
    boolean bool = paramObject instanceof EnvironmentKey;
    Object localObject = null;
    if (bool)
    {
      EnvironmentKey localEnvironmentKey = (EnvironmentKey)paramObject;
      paramObject = localEnvironmentKey.getKeySymbol();
      localObject = localEnvironmentKey.getKeyProperty();
    }
    if ((paramObject instanceof Symbol));
    for (Symbol localSymbol = (Symbol)paramObject; ; localSymbol = getSymbol((String)paramObject))
      return getLocation(localSymbol, localObject, paramBoolean);
  }

  public abstract NamedLocation getLocation(Symbol paramSymbol, Object paramObject, int paramInt, boolean paramBoolean);

  public final NamedLocation getLocation(Symbol paramSymbol, Object paramObject, boolean paramBoolean)
  {
    return getLocation(paramSymbol, paramObject, paramSymbol.hashCode() ^ System.identityHashCode(paramObject), paramBoolean);
  }

  public Symbol getSymbol(String paramString)
  {
    return defaultNamespace().getSymbol(paramString);
  }

  protected abstract boolean hasMoreElements(LocationEnumeration paramLocationEnumeration);

  public final boolean isBound(Symbol paramSymbol)
  {
    return isBound(paramSymbol, null);
  }

  public boolean isBound(Symbol paramSymbol, Object paramObject)
  {
    Location localLocation = lookup(paramSymbol, paramObject);
    if (localLocation == null)
      return false;
    return localLocation.isBound();
  }

  public final boolean isLocked()
  {
    return (0x3 & this.flags) == 0;
  }

  public final Location lookup(Symbol paramSymbol)
  {
    return getLocation(paramSymbol, null, false);
  }

  public final Location lookup(Symbol paramSymbol, Object paramObject)
  {
    return getLocation(paramSymbol, paramObject, false);
  }

  public abstract NamedLocation lookup(Symbol paramSymbol, Object paramObject, int paramInt);

  public final Object put(Object paramObject1, Object paramObject2)
  {
    Location localLocation = getLocation(paramObject1, true);
    Object localObject = localLocation.get(null);
    localLocation.set(paramObject2);
    return localObject;
  }

  public final Object put(String paramString, Object paramObject)
  {
    return put(paramString, paramObject);
  }

  public final void put(Symbol paramSymbol, Object paramObject)
  {
    put(paramSymbol, null, paramObject);
  }

  public void put(Symbol paramSymbol, Object paramObject1, Object paramObject2)
  {
    Location localLocation = getLocation(paramSymbol, paramObject1);
    if (localLocation.isConstant())
    {
      define(paramSymbol, paramObject1, paramObject2);
      return;
    }
    localLocation.set(paramObject2);
  }

  public final void putFunction(Symbol paramSymbol, Object paramObject)
  {
    put(paramSymbol, EnvironmentKey.FUNCTION, paramObject);
  }

  public final Object remove(EnvironmentKey paramEnvironmentKey)
  {
    Symbol localSymbol = paramEnvironmentKey.getKeySymbol();
    Object localObject = paramEnvironmentKey.getKeyProperty();
    return remove(localSymbol, localObject, localSymbol.hashCode() ^ System.identityHashCode(localObject));
  }

  public final Object remove(Symbol paramSymbol, Object paramObject)
  {
    return remove(paramSymbol, paramObject, paramSymbol.hashCode() ^ System.identityHashCode(paramObject));
  }

  public Object remove(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    Location localLocation = unlink(paramSymbol, paramObject, paramInt);
    if (localLocation == null)
      return null;
    Object localObject = localLocation.get(null);
    localLocation.undefine();
    return localObject;
  }

  public final Object remove(Object paramObject)
  {
    if ((paramObject instanceof EnvironmentKey))
    {
      EnvironmentKey localEnvironmentKey = (EnvironmentKey)paramObject;
      return remove(localEnvironmentKey.getKeySymbol(), localEnvironmentKey.getKeyProperty());
    }
    if ((paramObject instanceof Symbol));
    for (Symbol localSymbol = (Symbol)paramObject; ; localSymbol = getSymbol((String)paramObject))
      return remove(localSymbol, null, localSymbol.hashCode() ^ System.identityHashCode(null));
  }

  public final void remove(Symbol paramSymbol)
  {
    remove(paramSymbol, null, paramSymbol.hashCode());
  }

  public final void removeFunction(Symbol paramSymbol)
  {
    remove(paramSymbol, EnvironmentKey.FUNCTION);
  }

  public void setCanDefine(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x1 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFFE & this.flags);
  }

  public void setCanRedefine(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x2 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFFD & this.flags);
  }

  public void setFlag(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.flags = (paramInt | this.flags);
      return;
    }
    this.flags &= (paramInt ^ 0xFFFFFFFF);
  }

  public final void setIndirectDefines()
  {
    this.flags = (0x20 | this.flags);
    ((InheritingEnvironment)this).baseTimestamp = 2147483647;
  }

  public void setLocked()
  {
    this.flags = (0xFFFFFFF8 & this.flags);
  }

  public String toString()
  {
    return "#<environment " + getName() + '>';
  }

  public String toStringVerbose()
  {
    return toString();
  }

  public Location unlink(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    throw new RuntimeException("unsupported operation: unlink (aka undefine)");
  }

  static class InheritedLocal extends InheritableThreadLocal<Environment>
  {
    protected Environment childValue(Environment paramEnvironment)
    {
      if (paramEnvironment == null)
        paramEnvironment = Environment.getCurrent();
      SimpleEnvironment localSimpleEnvironment = paramEnvironment.cloneForThread();
      localSimpleEnvironment.flags = (0x8 | localSimpleEnvironment.flags);
      localSimpleEnvironment.flags = (0xFFFFFFEF & localSimpleEnvironment.flags);
      return localSimpleEnvironment;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Environment
 * JD-Core Version:    0.6.2
 */