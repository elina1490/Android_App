package gnu.mapping;

public class PropertyKey<T>
{
  String name;

  public PropertyKey(String paramString)
  {
    this.name = paramString;
  }

  public final T get(PropertySet paramPropertySet)
  {
    return get(paramPropertySet, null);
  }

  public T get(PropertySet paramPropertySet, T paramT)
  {
    return paramPropertySet.getProperty(this, paramT);
  }

  public void set(PropertySet paramPropertySet, T paramT)
  {
    paramPropertySet.setProperty(this, paramT);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.PropertyKey
 * JD-Core Version:    0.6.2
 */