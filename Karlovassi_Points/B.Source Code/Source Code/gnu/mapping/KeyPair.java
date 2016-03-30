package gnu.mapping;

public class KeyPair
  implements EnvironmentKey
{
  Symbol name;
  Object property;

  public KeyPair(Symbol paramSymbol, Object paramObject)
  {
    this.name = paramSymbol;
    this.property = paramObject;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof KeyPair))
      return false;
    KeyPair localKeyPair = (KeyPair)paramObject;
    if (this.property == localKeyPair.property)
      if (this.name == null)
      {
        if (localKeyPair.name != null);
      }
      else
        while (this.name.equals(localKeyPair.name))
          return true;
    return false;
  }

  public Object getKeyProperty()
  {
    return this.property;
  }

  public Symbol getKeySymbol()
  {
    return this.name;
  }

  public int hashCode()
  {
    return this.name.hashCode() ^ System.identityHashCode(this.property);
  }

  public final boolean matches(EnvironmentKey paramEnvironmentKey)
  {
    return (Symbol.equals(paramEnvironmentKey.getKeySymbol(), this.name)) && (paramEnvironmentKey.getKeyProperty() == this.property);
  }

  public final boolean matches(Symbol paramSymbol, Object paramObject)
  {
    return (Symbol.equals(paramSymbol, this.name)) && (paramObject == this.property);
  }

  public String toString()
  {
    return "KeyPair[sym:" + this.name + " prop:" + this.property + "]";
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.KeyPair
 * JD-Core Version:    0.6.2
 */