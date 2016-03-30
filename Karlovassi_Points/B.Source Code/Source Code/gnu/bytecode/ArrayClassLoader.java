package gnu.bytecode;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;

public class ArrayClassLoader extends ClassLoader
{
  Hashtable cmap = new Hashtable(100);
  URL context;
  Hashtable map = new Hashtable(100);

  public ArrayClassLoader()
  {
  }

  public ArrayClassLoader(ClassLoader paramClassLoader)
  {
    super(paramClassLoader);
  }

  public ArrayClassLoader(String[] paramArrayOfString, byte[][] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      addClass(paramArrayOfString[i], paramArrayOfByte[i]);
    }
  }

  public ArrayClassLoader(byte[][] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    while (true)
    {
      i--;
      if (i < 0)
        break;
      addClass("lambda" + i, paramArrayOfByte[i]);
    }
  }

  public static Package getContextPackage(String paramString)
  {
    try
    {
      ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
      if ((localClassLoader instanceof ArrayClassLoader))
      {
        Package localPackage = ((ArrayClassLoader)localClassLoader).getPackage(paramString);
        return localPackage;
      }
    }
    catch (SecurityException localSecurityException)
    {
    }
    return Package.getPackage(paramString);
  }

  public void addClass(ClassType paramClassType)
  {
    this.map.put(paramClassType.getName(), paramClassType);
  }

  public void addClass(Class paramClass)
  {
    this.cmap.put(paramClass.getName(), paramClass);
  }

  public void addClass(String paramString, byte[] paramArrayOfByte)
  {
    this.map.put(paramString, paramArrayOfByte);
  }

  protected URL findResource(String paramString)
  {
    if (this.context != null)
      try
      {
        URL localURL = new URL(this.context, paramString);
        localURL.openConnection().connect();
        return localURL;
      }
      catch (Throwable localThrowable)
      {
      }
    return super.findResource(paramString);
  }

  public InputStream getResourceAsStream(String paramString)
  {
    InputStream localInputStream = super.getResourceAsStream(paramString);
    if ((localInputStream == null) && (paramString.endsWith(".class")))
    {
      String str = paramString.substring(0, paramString.length() - 6).replace('/', '.');
      Object localObject = this.map.get(str);
      if ((localObject instanceof byte[]))
        return new ByteArrayInputStream((byte[])localObject);
    }
    return localInputStream;
  }

  public URL getResourceContext()
  {
    return this.context;
  }

  public Class loadClass(String paramString)
    throws ClassNotFoundException
  {
    Object localObject1 = this.cmap.get(paramString);
    if (localObject1 != null)
      return (Class)localObject1;
    Object localObject2 = this.map.get(paramString);
    ClassType localClassType;
    if ((localObject2 instanceof ClassType))
    {
      localClassType = (ClassType)localObject2;
      if (localClassType.isExisting())
        localObject2 = localClassType.reflectClass;
    }
    else
    {
      if (!(localObject2 instanceof byte[]))
        break label146;
    }
    while (true)
    {
      Class localClass;
      try
      {
        Object localObject4 = this.map.get(paramString);
        if ((localObject4 instanceof byte[]))
        {
          byte[] arrayOfByte = (byte[])localObject4;
          localClass = defineClass(paramString, arrayOfByte, 0, arrayOfByte.length);
          this.cmap.put(paramString, localClass);
          return localClass;
          localObject2 = localClassType.writeToArray();
          break;
        }
        localClass = (Class)localObject4;
        continue;
      }
      finally
      {
      }
      label146: if (localObject2 == null)
        localClass = getParent().loadClass(paramString);
      else
        localClass = (Class)localObject2;
    }
  }

  public Class loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    Class localClass = loadClass(paramString);
    if (paramBoolean)
      resolveClass(localClass);
    return localClass;
  }

  public void setResourceContext(URL paramURL)
  {
    this.context = paramURL;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ArrayClassLoader
 * JD-Core Version:    0.6.2
 */