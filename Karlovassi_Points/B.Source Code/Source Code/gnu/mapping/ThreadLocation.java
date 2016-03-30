package gnu.mapping;

public class ThreadLocation extends NamedLocation
  implements Named
{
  public static final String ANONYMOUS = new String("(dynamic)");
  static int counter;
  static SimpleEnvironment env;
  SharedLocation global;
  private int hash;
  private ThreadLocal<NamedLocation> thLocal;

  public ThreadLocation()
  {
    this("param#" + nextCounter());
  }

  private ThreadLocation(Symbol paramSymbol)
  {
    super(paramSymbol, ANONYMOUS);
    this.thLocal = new InheritingLocation();
    if (paramSymbol == null);
    for (String str = null; ; str = paramSymbol.toString())
    {
      this.global = new SharedLocation(Symbol.makeUninterned(str), null, 0);
      return;
    }
  }

  public ThreadLocation(Symbol paramSymbol, Object paramObject, SharedLocation paramSharedLocation)
  {
    super(paramSymbol, paramObject);
    this.hash = (paramSymbol.hashCode() ^ System.identityHashCode(paramObject));
    this.global = paramSharedLocation;
  }

  public ThreadLocation(String paramString)
  {
    super(Symbol.makeUninterned(paramString), ANONYMOUS);
    this.thLocal = new InheritingLocation();
    this.global = new SharedLocation(this.name, null, 0);
  }

  public static ThreadLocation getInstance(Symbol paramSymbol, Object paramObject)
  {
    try
    {
      if (env == null)
        env = new SimpleEnvironment("[thread-locations]");
      IndirectableLocation localIndirectableLocation = (IndirectableLocation)env.getLocation(paramSymbol, paramObject);
      ThreadLocation localThreadLocation2;
      if (localIndirectableLocation.base != null)
        localThreadLocation2 = (ThreadLocation)localIndirectableLocation.base;
      ThreadLocation localThreadLocation1;
      for (Object localObject2 = localThreadLocation2; ; localObject2 = localThreadLocation1)
      {
        return localObject2;
        localThreadLocation1 = new ThreadLocation(paramSymbol, paramObject, null);
        localIndirectableLocation.base = localThreadLocation1;
      }
    }
    finally
    {
    }
  }

  public static ThreadLocation makeAnonymous(Symbol paramSymbol)
  {
    return new ThreadLocation(paramSymbol);
  }

  public static ThreadLocation makeAnonymous(String paramString)
  {
    return new ThreadLocation(paramString);
  }

  private static int nextCounter()
  {
    try
    {
      int i = 1 + counter;
      counter = i;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Object get(Object paramObject)
  {
    return getLocation().get(paramObject);
  }

  public NamedLocation getLocation()
  {
    if (this.property != ANONYMOUS)
      return Environment.getCurrent().getLocation(this.name, this.property, this.hash, true);
    Object localObject = (NamedLocation)this.thLocal.get();
    if (localObject == null)
    {
      localObject = new SharedLocation(this.name, this.property, 0);
      if (this.global != null)
        ((NamedLocation)localObject).setBase(this.global);
      this.thLocal.set(localObject);
    }
    return localObject;
  }

  public String getName()
  {
    if (this.name == null)
      return null;
    return this.name.toString();
  }

  public Object getSymbol()
  {
    if ((this.name != null) && (this.property == ANONYMOUS) && (this.global.getKeySymbol() == this.name))
      return this.name.toString();
    return this.name;
  }

  public void set(Object paramObject)
  {
    getLocation().set(paramObject);
  }

  public void setGlobal(Object paramObject)
  {
    try
    {
      if (this.global == null)
        this.global = new SharedLocation(this.name, null, 0);
      this.global.set(paramObject);
      return;
    }
    finally
    {
    }
  }

  public void setName(String paramString)
  {
    throw new RuntimeException("setName not allowed");
  }

  public void setRestore(Object paramObject)
  {
    getLocation().setRestore(paramObject);
  }

  public Object setWithSave(Object paramObject)
  {
    return getLocation().setWithSave(paramObject);
  }

  public class InheritingLocation extends InheritableThreadLocal<NamedLocation>
  {
    public InheritingLocation()
    {
    }

    protected SharedLocation childValue(NamedLocation paramNamedLocation)
    {
      if (ThreadLocation.this.property != ThreadLocation.ANONYMOUS)
        throw new Error();
      if (paramNamedLocation == null)
        paramNamedLocation = (SharedLocation)ThreadLocation.this.getLocation();
      Object localObject = paramNamedLocation;
      if (((NamedLocation)localObject).base == null)
      {
        SharedLocation localSharedLocation1 = new SharedLocation(ThreadLocation.this.name, ThreadLocation.this.property, 0);
        localSharedLocation1.value = ((NamedLocation)localObject).value;
        ((NamedLocation)localObject).base = localSharedLocation1;
        ((NamedLocation)localObject).value = null;
        localObject = localSharedLocation1;
      }
      SharedLocation localSharedLocation2 = new SharedLocation(ThreadLocation.this.name, ThreadLocation.this.property, 0);
      localSharedLocation2.value = null;
      localSharedLocation2.base = ((Location)localObject);
      return localSharedLocation2;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.ThreadLocation
 * JD-Core Version:    0.6.2
 */