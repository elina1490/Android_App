package gnu.mapping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class LazyPropertyKey<T> extends PropertyKey<T>
{
  public LazyPropertyKey(String paramString)
  {
    super(paramString);
  }

  public T get(PropertySet paramPropertySet, T paramT)
  {
    Object localObject1 = paramPropertySet.getProperty(this, paramT);
    if ((localObject1 instanceof String))
    {
      String str1 = (String)localObject1;
      if (str1.charAt(0) == '*');
      int j;
      for (int i = 1; ; i = 0)
      {
        j = str1.indexOf(':');
        if ((j > i) && (j < str1.length() - 1))
          break;
        throw new RuntimeException("lazy property " + this + " must have the form \"ClassName:fieldName\" or \"ClassName:staticMethodName\"");
      }
      String str2 = str1.substring(i, j);
      String str3 = str1.substring(j + 1);
      StringBuilder localStringBuilder;
      try
      {
        Class localClass = Class.forName(str2, true, paramPropertySet.getClass().getClassLoader());
        Object localObject2;
        if (i == 0)
          localObject2 = localClass.getField(str3).get(null);
        Object localObject4;
        for (Object localObject3 = localObject2; ; localObject3 = localObject4)
        {
          paramPropertySet.setProperty(this, localObject3);
          return localObject3;
          localObject4 = localClass.getDeclaredMethod(str3, new Class[] { Object.class }).invoke(null, new Object[] { paramPropertySet });
        }
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder().append("lazy property ").append(this).append(" has specifier \"").append(str1).append("\" but there is no such ");
        if (i != 0);
      }
      for (String str4 = "field"; ; str4 = "method")
        throw new RuntimeException(str4, localThrowable);
    }
    return localObject1;
  }

  public void set(PropertySet paramPropertySet, String paramString)
  {
    paramPropertySet.setProperty(this, paramString);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.LazyPropertyKey
 * JD-Core Version:    0.6.2
 */