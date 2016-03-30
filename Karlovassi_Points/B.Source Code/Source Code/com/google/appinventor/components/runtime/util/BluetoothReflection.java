package com.google.appinventor.components.runtime.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.UUID;

public class BluetoothReflection
{
  private static final int BOND_BONDED = 12;

  public static Object accept(Object paramObject)
    throws IOException
  {
    return invokeMethodThrowsIOException(getMethod(paramObject.getClass(), "accept"), paramObject, new Object[0]);
  }

  public static boolean checkBluetoothAddress(Object paramObject, String paramString)
  {
    return ((Boolean)invokeMethod(getMethod(paramObject.getClass(), "checkBluetoothAddress", new Class[] { String.class }), paramObject, new Object[] { paramString })).booleanValue();
  }

  public static void closeBluetoothServerSocket(Object paramObject)
    throws IOException
  {
    invokeMethodThrowsIOException(getMethod(paramObject.getClass(), "close"), paramObject, new Object[0]);
  }

  public static void closeBluetoothSocket(Object paramObject)
    throws IOException
  {
    invokeMethodThrowsIOException(getMethod(paramObject.getClass(), "close"), paramObject, new Object[0]);
  }

  public static void connectToBluetoothSocket(Object paramObject)
    throws IOException
  {
    invokeMethodThrowsIOException(getMethod(paramObject.getClass(), "connect"), paramObject, new Object[0]);
  }

  public static Object createInsecureRfcommSocketToServiceRecord(Object paramObject, UUID paramUUID)
    throws IOException
  {
    return invokeMethodThrowsIOException(getMethod(paramObject.getClass(), "createInsecureRfcommSocketToServiceRecord", new Class[] { UUID.class }), paramObject, new Object[] { paramUUID });
  }

  public static Object createRfcommSocketToServiceRecord(Object paramObject, UUID paramUUID)
    throws IOException
  {
    return invokeMethodThrowsIOException(getMethod(paramObject.getClass(), "createRfcommSocketToServiceRecord", new Class[] { UUID.class }), paramObject, new Object[] { paramUUID });
  }

  public static Object getBluetoothAdapter()
  {
    try
    {
      Class localClass = Class.forName("android.bluetooth.BluetoothAdapter");
      return invokeStaticMethod(getMethod(localClass, "getDefaultAdapter"));
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return null;
  }

  public static Object getBluetoothClass(Object paramObject)
  {
    return invokeMethod(getMethod(paramObject.getClass(), "getBluetoothClass"), paramObject, new Object[0]);
  }

  public static String getBluetoothDeviceAddress(Object paramObject)
  {
    return (String)invokeMethod(getMethod(paramObject.getClass(), "getAddress"), paramObject, new Object[0]);
  }

  public static String getBluetoothDeviceName(Object paramObject)
  {
    return (String)invokeMethod(getMethod(paramObject.getClass(), "getName"), paramObject, new Object[0]);
  }

  public static Set getBondedDevices(Object paramObject)
  {
    return (Set)invokeMethod(getMethod(paramObject.getClass(), "getBondedDevices"), paramObject, new Object[0]);
  }

  public static int getDeviceClass(Object paramObject)
  {
    return ((Integer)invokeMethod(getMethod(paramObject.getClass(), "getDeviceClass"), paramObject, new Object[0])).intValue();
  }

  public static InputStream getInputStream(Object paramObject)
    throws IOException
  {
    return (InputStream)invokeMethodThrowsIOException(getMethod(paramObject.getClass(), "getInputStream"), paramObject, new Object[0]);
  }

  private static Method getMethod(Class paramClass, String paramString)
  {
    try
    {
      Method localMethod = paramClass.getMethod(paramString, new Class[0]);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException(localNoSuchMethodException);
    }
  }

  private static Method getMethod(Class paramClass, String paramString, Class<?>[] paramArrayOfClass)
  {
    try
    {
      Method localMethod = paramClass.getMethod(paramString, paramArrayOfClass);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException(localNoSuchMethodException);
    }
  }

  public static OutputStream getOutputStream(Object paramObject)
    throws IOException
  {
    return (OutputStream)invokeMethodThrowsIOException(getMethod(paramObject.getClass(), "getOutputStream"), paramObject, new Object[0]);
  }

  public static Object getRemoteDevice(Object paramObject, String paramString)
    throws IllegalArgumentException
  {
    return invokeMethodThrowsIllegalArgumentException(getMethod(paramObject.getClass(), "getRemoteDevice", new Class[] { String.class }), paramObject, new Object[] { paramString });
  }

  private static Object invokeMethod(Method paramMethod, Object paramObject, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      localThrowable.printStackTrace();
      if ((localThrowable instanceof RuntimeException))
        throw ((RuntimeException)localThrowable);
      throw new RuntimeException(localThrowable);
    }
  }

  private static Object invokeMethodThrowsIOException(Method paramMethod, Object paramObject, Object[] paramArrayOfObject)
    throws IOException
  {
    try
    {
      Object localObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      localThrowable.printStackTrace();
      if ((localThrowable instanceof IOException))
        throw ((IOException)localThrowable);
      if ((localThrowable instanceof RuntimeException))
        throw ((RuntimeException)localThrowable);
      throw new RuntimeException(localInvocationTargetException);
    }
  }

  private static Object invokeMethodThrowsIllegalArgumentException(Method paramMethod, Object paramObject, Object[] paramArrayOfObject)
    throws IllegalArgumentException
  {
    try
    {
      Object localObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      localThrowable.printStackTrace();
      if ((localThrowable instanceof IllegalArgumentException))
        throw ((IllegalArgumentException)localThrowable);
      if ((localThrowable instanceof RuntimeException))
        throw ((RuntimeException)localThrowable);
      throw new RuntimeException(localInvocationTargetException);
    }
  }

  private static Object invokeStaticMethod(Method paramMethod)
  {
    try
    {
      Object localObject = paramMethod.invoke(null, new Object[0]);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      localThrowable.printStackTrace();
      if ((localThrowable instanceof RuntimeException))
        throw ((RuntimeException)localThrowable);
      throw new RuntimeException(localThrowable);
    }
  }

  public static boolean isBluetoothEnabled(Object paramObject)
  {
    return ((Boolean)invokeMethod(getMethod(paramObject.getClass(), "isEnabled"), paramObject, new Object[0])).booleanValue();
  }

  public static boolean isBonded(Object paramObject)
  {
    return ((Integer)invokeMethod(getMethod(paramObject.getClass(), "getBondState"), paramObject, new Object[0])).intValue() == 12;
  }

  public static Object listenUsingInsecureRfcommWithServiceRecord(Object paramObject, String paramString, UUID paramUUID)
    throws IOException
  {
    return invokeMethodThrowsIOException(getMethod(paramObject.getClass(), "listenUsingInsecureRfcommWithServiceRecord", new Class[] { String.class, UUID.class }), paramObject, new Object[] { paramString, paramUUID });
  }

  public static Object listenUsingRfcommWithServiceRecord(Object paramObject, String paramString, UUID paramUUID)
    throws IOException
  {
    return invokeMethodThrowsIOException(getMethod(paramObject.getClass(), "listenUsingRfcommWithServiceRecord", new Class[] { String.class, UUID.class }), paramObject, new Object[] { paramString, paramUUID });
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.BluetoothReflection
 * JD-Core Version:    0.6.2
 */