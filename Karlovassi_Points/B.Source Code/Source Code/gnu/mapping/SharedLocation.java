package gnu.mapping;

public class SharedLocation extends NamedLocation
{
  int timestamp;

  public SharedLocation(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    super(paramSymbol, paramObject);
    this.timestamp = paramInt;
  }

  public final Object get(Object paramObject)
  {
    try
    {
      Object localObject2;
      if (this.base != null)
      {
        Object localObject3 = this.base.get(paramObject);
        localObject2 = localObject3;
      }
      while (true)
      {
        return localObject2;
        if (this.value == Location.UNBOUND)
          localObject2 = paramObject;
        else
          localObject2 = this.value;
      }
    }
    finally
    {
    }
  }

  public boolean isBound()
  {
    try
    {
      boolean bool1;
      if (this.base != null)
      {
        boolean bool2 = this.base.isBound();
        bool1 = bool2;
      }
      while (true)
      {
        return bool1;
        Object localObject2 = this.value;
        String str = Location.UNBOUND;
        if (localObject2 != str)
          bool1 = true;
        else
          bool1 = false;
      }
    }
    finally
    {
    }
  }

  public final void set(Object paramObject)
  {
    while (true)
    {
      try
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
          continue;
        }
      }
      finally
      {
      }
      if (this.base.isConstant())
        getEnvironment().put(getKeySymbol(), getKeyProperty(), paramObject);
      else
        this.base.set(paramObject);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.SharedLocation
 * JD-Core Version:    0.6.2
 */