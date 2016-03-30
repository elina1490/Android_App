package gnu.mapping;

public abstract class PropertySet
  implements Named
{
  public static final Symbol nameKey = Namespace.EmptyNamespace.getSymbol("name");
  private Object[] properties;

  public static Object[] setProperty(Object[] paramArrayOfObject, Object paramObject1, Object paramObject2)
  {
    Object[] arrayOfObject = paramArrayOfObject;
    int i;
    if (arrayOfObject == null)
    {
      arrayOfObject = new Object[10];
      paramArrayOfObject = arrayOfObject;
      i = 0;
    }
    while (true)
    {
      arrayOfObject[i] = paramObject1;
      arrayOfObject[(i + 1)] = paramObject2;
      return paramArrayOfObject;
      i = -1;
      int j = arrayOfObject.length;
      while (true)
      {
        j -= 2;
        if (j < 0)
          break;
        Object localObject = arrayOfObject[j];
        if (localObject == paramObject1)
        {
          arrayOfObject[(j + 1)];
          arrayOfObject[(j + 1)] = paramObject2;
          return paramArrayOfObject;
        }
        if (localObject == null)
          i = j;
      }
      if (i < 0)
      {
        i = arrayOfObject.length;
        paramArrayOfObject = new Object[i * 2];
        System.arraycopy(arrayOfObject, 0, paramArrayOfObject, 0, i);
        arrayOfObject = paramArrayOfObject;
      }
    }
  }

  public String getName()
  {
    Object localObject = getProperty(nameKey, null);
    if (localObject == null)
      return null;
    if ((localObject instanceof Symbol))
      return ((Symbol)localObject).getName();
    return localObject.toString();
  }

  public Object getProperty(Object paramObject1, Object paramObject2)
  {
    if (this.properties != null)
    {
      int i = this.properties.length;
      do
      {
        i -= 2;
        if (i < 0)
          break;
      }
      while (this.properties[i] != paramObject1);
      return this.properties[(i + 1)];
    }
    return paramObject2;
  }

  public Object getSymbol()
  {
    return getProperty(nameKey, null);
  }

  public Object removeProperty(Object paramObject)
  {
    Object[] arrayOfObject = this.properties;
    if (arrayOfObject == null)
      return null;
    int i = arrayOfObject.length;
    do
    {
      i -= 2;
      if (i < 0)
        break;
    }
    while (arrayOfObject[i] != paramObject);
    Object localObject = arrayOfObject[(i + 1)];
    arrayOfObject[i] = null;
    arrayOfObject[(i + 1)] = null;
    return localObject;
    return null;
  }

  public final void setName(String paramString)
  {
    setProperty(nameKey, paramString);
  }

  public void setProperty(Object paramObject1, Object paramObject2)
  {
    try
    {
      this.properties = setProperty(this.properties, paramObject1, paramObject2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setSymbol(Object paramObject)
  {
    setProperty(nameKey, paramObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.PropertySet
 * JD-Core Version:    0.6.2
 */