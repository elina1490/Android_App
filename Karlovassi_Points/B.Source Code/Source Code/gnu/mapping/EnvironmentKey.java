package gnu.mapping;

public abstract interface EnvironmentKey
{
  public static final Object FUNCTION = Symbol.FUNCTION;

  public abstract Object getKeyProperty();

  public abstract Symbol getKeySymbol();

  public abstract boolean matches(EnvironmentKey paramEnvironmentKey);

  public abstract boolean matches(Symbol paramSymbol, Object paramObject);
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.EnvironmentKey
 * JD-Core Version:    0.6.2
 */