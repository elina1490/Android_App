package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.SimplePropertyCopier;
import com.google.appinventor.components.runtime.Component;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PropertyUtil
{
  public static Component copyComponentProperties(Component paramComponent1, Component paramComponent2)
    throws Throwable
  {
    if (!paramComponent1.getClass().equals(paramComponent2.getClass()))
      throw new IllegalArgumentException("Source and target classes must be identical");
    Class localClass1 = paramComponent1.getClass();
    Method[] arrayOfMethod = localClass1.getMethods();
    int i = arrayOfMethod.length;
    for (int j = 0; ; j++)
      if (j < i)
      {
        Method localMethod1 = arrayOfMethod[j];
        if ((localMethod1.isAnnotationPresent(SimpleProperty.class)) && (localMethod1.getParameterTypes().length == 1))
          try
          {
            String str = localMethod1.getName();
            Method localMethod2 = getPropertyCopierMethod("Copy" + str, localClass1);
            if (localMethod2 != null)
            {
              localMethod2.invoke(paramComponent2, new Object[] { paramComponent1 });
            }
            else
            {
              Method localMethod3 = localClass1.getMethod(str, new Class[0]);
              Class localClass2 = localMethod1.getParameterTypes()[0];
              if ((localMethod3.isAnnotationPresent(SimpleProperty.class)) && (localClass2.isAssignableFrom(localMethod3.getReturnType())))
                localMethod1.invoke(paramComponent2, new Object[] { localMethod3.invoke(paramComponent1, new Object[0]) });
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            throw localInvocationTargetException.getCause();
          }
      }
      else
      {
        return paramComponent2;
      }
  }

  private static Method getPropertyCopierMethod(String paramString, Class paramClass)
  {
    do
      try
      {
        Method localMethod = paramClass.getMethod(paramString, new Class[] { paramClass });
        boolean bool = localMethod.isAnnotationPresent(SimplePropertyCopier.class);
        if (bool)
          return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        paramClass = paramClass.getSuperclass();
      }
    while (paramClass != null);
    return null;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.PropertyUtil
 * JD-Core Version:    0.6.2
 */