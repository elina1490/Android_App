package gnu.expr;

import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.WrappedException;
import java.lang.reflect.Field;

public class ModuleContext
{
  public static int IN_HTTP_SERVER = 1;
  public static int IN_SERVLET = 2;
  static ModuleContext global = new ModuleContext(ModuleManager.instance);
  int flags;
  ModuleManager manager;
  private ClassToInstanceMap table = new ClassToInstanceMap();

  public ModuleContext(ModuleManager paramModuleManager)
  {
    this.manager = paramModuleManager;
  }

  public static ModuleContext getContext()
  {
    return global;
  }

  public void addFlags(int paramInt)
  {
    this.flags = (paramInt | this.flags);
  }

  public void clear()
  {
    try
    {
      this.table.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public ModuleInfo findFromInstance(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    try
    {
      ModuleInfo localModuleInfo = ModuleManager.findWithClass(localClass);
      setInstance(paramObject);
      return localModuleInfo;
    }
    finally
    {
    }
  }

  public Object findInstance(ModuleInfo paramModuleInfo)
  {
    try
    {
      Class localClass = paramModuleInfo.getModuleClass();
      Object localObject2 = findInstance(localClass);
      return localObject2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      String str = paramModuleInfo.getClassName();
      throw new WrappedException("cannot find module " + str, localClassNotFoundException);
    }
    finally
    {
    }
  }

  public Object findInstance(Class paramClass)
  {
    try
    {
      Object localObject2 = this.table.get(paramClass);
      Object localObject3 = localObject2;
      if (localObject3 == null);
      try
      {
        Object localObject5 = paramClass.getDeclaredField("$instance").get(null);
        localObject3 = localObject5;
        setInstance(localObject3);
        return localObject3;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        while (true)
        {
          Object localObject4 = paramClass.newInstance();
          localObject3 = localObject4;
        }
      }
      catch (Throwable localThrowable)
      {
        throw new WrappedException("exception while initializing module " + paramClass.getName(), localThrowable);
      }
    }
    finally
    {
    }
  }

  public int getFlags()
  {
    return this.flags;
  }

  public ModuleManager getManager()
  {
    return this.manager;
  }

  public Object searchInstance(Class paramClass)
  {
    try
    {
      Object localObject2 = this.table.get(paramClass);
      return localObject2;
    }
    finally
    {
      localObject1 = finally;
      throw localObject1;
    }
  }

  public void setFlags(int paramInt)
  {
    this.flags = paramInt;
  }

  public void setInstance(Object paramObject)
  {
    try
    {
      this.table.put(paramObject.getClass(), paramObject);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  static class ClassToInstanceMap extends AbstractWeakHashTable<Class, Object>
  {
    protected Class getKeyFromValue(Object paramObject)
    {
      return paramObject.getClass();
    }

    protected boolean matches(Class paramClass1, Class paramClass2)
    {
      return paramClass1 == paramClass2;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ModuleContext
 * JD-Core Version:    0.6.2
 */