package gnu.mapping;

import java.io.PrintWriter;

public abstract class Location
{
  public static final String UNBOUND = new String("(unbound)");

  public static IndirectableLocation make(Symbol paramSymbol)
  {
    PlainLocation localPlainLocation = new PlainLocation(paramSymbol, null);
    localPlainLocation.base = null;
    localPlainLocation.value = UNBOUND;
    return localPlainLocation;
  }

  public static IndirectableLocation make(String paramString)
  {
    PlainLocation localPlainLocation = new PlainLocation(Namespace.EmptyNamespace.getSymbol(paramString.intern()), null);
    localPlainLocation.base = null;
    localPlainLocation.value = UNBOUND;
    return localPlainLocation;
  }

  public static Location make(Object paramObject, String paramString)
  {
    ThreadLocation localThreadLocation = new ThreadLocation(paramString);
    localThreadLocation.setGlobal(paramObject);
    return localThreadLocation;
  }

  public boolean entered()
  {
    return false;
  }

  public final Object get()
  {
    String str = UNBOUND;
    Object localObject = get(str);
    if (localObject == str)
      throw new UnboundLocationException(this);
    return localObject;
  }

  public abstract Object get(Object paramObject);

  public Location getBase()
  {
    return this;
  }

  public Object getKeyProperty()
  {
    return null;
  }

  public Symbol getKeySymbol()
  {
    return null;
  }

  public final Object getValue()
  {
    return get(null);
  }

  public boolean isBound()
  {
    String str = UNBOUND;
    return get(str) != str;
  }

  public boolean isConstant()
  {
    return false;
  }

  public void print(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print("#<location ");
    Symbol localSymbol = getKeySymbol();
    if (localSymbol != null)
      paramPrintWriter.print(localSymbol);
    String str = UNBOUND;
    Object localObject = get(str);
    if (localObject != str)
    {
      paramPrintWriter.print(" -> ");
      paramPrintWriter.print(localObject);
    }
    while (true)
    {
      paramPrintWriter.print('>');
      return;
      paramPrintWriter.print("(unbound)");
    }
  }

  public abstract void set(Object paramObject);

  public void setRestore(Object paramObject)
  {
    set(paramObject);
  }

  public final Object setValue(Object paramObject)
  {
    Object localObject = get(null);
    set(paramObject);
    return localObject;
  }

  public Object setWithSave(Object paramObject)
  {
    Object localObject = get(UNBOUND);
    set(paramObject);
    return localObject;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(getClass().getName());
    Symbol localSymbol = getKeySymbol();
    localStringBuffer.append('[');
    if (localSymbol != null)
    {
      localStringBuffer.append(localSymbol);
      Object localObject = getKeyProperty();
      if ((localObject != null) && (localObject != this))
      {
        localStringBuffer.append('/');
        localStringBuffer.append(localObject);
      }
    }
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }

  public void undefine()
  {
    set(UNBOUND);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Location
 * JD-Core Version:    0.6.2
 */