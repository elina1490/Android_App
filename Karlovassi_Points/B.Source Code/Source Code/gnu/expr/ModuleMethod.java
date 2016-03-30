package gnu.expr;

import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import gnu.mapping.WrongArguments;
import java.lang.reflect.Method;

public class ModuleMethod extends MethodProc
{
  public ModuleBody module;
  protected int numArgs;
  public int selector;

  public ModuleMethod(ModuleBody paramModuleBody, int paramInt1, Object paramObject, int paramInt2)
  {
    init(paramModuleBody, paramInt1, paramObject, paramInt2);
  }

  public ModuleMethod(ModuleBody paramModuleBody, int paramInt1, Object paramObject1, int paramInt2, Object paramObject2)
  {
    init(paramModuleBody, paramInt1, paramObject1, paramInt2);
    this.argTypes = paramObject2;
  }

  public static Object apply0Default(ModuleMethod paramModuleMethod)
    throws Throwable
  {
    return paramModuleMethod.module.applyN(paramModuleMethod, Values.noArgs);
  }

  public static Object apply1Default(ModuleMethod paramModuleMethod, Object paramObject)
    throws Throwable
  {
    Object[] arrayOfObject = { paramObject };
    return paramModuleMethod.module.applyN(paramModuleMethod, arrayOfObject);
  }

  public static Object apply2Default(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
    throws Throwable
  {
    Object[] arrayOfObject = { paramObject1, paramObject2 };
    return paramModuleMethod.module.applyN(paramModuleMethod, arrayOfObject);
  }

  public static Object apply3Default(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    throws Throwable
  {
    Object[] arrayOfObject = { paramObject1, paramObject2, paramObject3 };
    return paramModuleMethod.module.applyN(paramModuleMethod, arrayOfObject);
  }

  public static Object apply4Default(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    throws Throwable
  {
    Object[] arrayOfObject = { paramObject1, paramObject2, paramObject3, paramObject4 };
    return paramModuleMethod.module.applyN(paramModuleMethod, arrayOfObject);
  }

  public static void applyError()
  {
    throw new Error("internal error - bad selector");
  }

  public static Object applyNDefault(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    int i = paramArrayOfObject.length;
    int j = paramModuleMethod.numArgs();
    ModuleBody localModuleBody = paramModuleMethod.module;
    if ((i >= (j & 0xFFF)) && ((j < 0) || (i <= j >> 12)));
    switch (i)
    {
    default:
      throw new WrongArguments(paramModuleMethod, i);
    case 0:
      return localModuleBody.apply0(paramModuleMethod);
    case 1:
      return localModuleBody.apply1(paramModuleMethod, paramArrayOfObject[0]);
    case 2:
      return localModuleBody.apply2(paramModuleMethod, paramArrayOfObject[0], paramArrayOfObject[1]);
    case 3:
      return localModuleBody.apply3(paramModuleMethod, paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2]);
    case 4:
    }
    return localModuleBody.apply4(paramModuleMethod, paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3]);
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    Object localObject;
    switch (paramCallContext.pc)
    {
    default:
      throw new Error("internal error - apply " + this);
    case 0:
      localObject = apply0();
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      paramCallContext.writeValue(localObject);
      return;
      localObject = apply1(paramCallContext.value1);
      continue;
      localObject = apply2(paramCallContext.value1, paramCallContext.value2);
      continue;
      localObject = apply3(paramCallContext.value1, paramCallContext.value2, paramCallContext.value3);
      continue;
      localObject = apply4(paramCallContext.value1, paramCallContext.value2, paramCallContext.value3, paramCallContext.value4);
      continue;
      localObject = applyN(paramCallContext.values);
    }
  }

  public Object apply0()
    throws Throwable
  {
    return this.module.apply0(this);
  }

  public Object apply1(Object paramObject)
    throws Throwable
  {
    return this.module.apply1(this, paramObject);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    try
    {
      Object localObject = this.module.apply2(this, paramObject1, paramObject2);
      return localObject;
    }
    catch (Exception localException)
    {
      throw localException;
    }
  }

  public Object apply3(Object paramObject1, Object paramObject2, Object paramObject3)
    throws Throwable
  {
    return this.module.apply3(this, paramObject1, paramObject2, paramObject3);
  }

  public Object apply4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    throws Throwable
  {
    return this.module.apply4(this, paramObject1, paramObject2, paramObject3, paramObject4);
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    return this.module.applyN(this, paramArrayOfObject);
  }

  public ModuleMethod init(ModuleBody paramModuleBody, int paramInt1, Object paramObject, int paramInt2)
  {
    this.module = paramModuleBody;
    this.selector = paramInt1;
    this.numArgs = paramInt2;
    if (paramObject != null)
      setSymbol(paramObject);
    return this;
  }

  public int match0(CallContext paramCallContext)
  {
    paramCallContext.count = 0;
    paramCallContext.where = 0;
    return this.module.match0(this, paramCallContext);
  }

  public int match1(Object paramObject, CallContext paramCallContext)
  {
    paramCallContext.count = 1;
    paramCallContext.where = 1;
    return this.module.match1(this, paramObject, paramCallContext);
  }

  public int match2(Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    paramCallContext.count = 2;
    paramCallContext.where = 33;
    return this.module.match2(this, paramObject1, paramObject2, paramCallContext);
  }

  public int match3(Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    paramCallContext.count = 3;
    paramCallContext.where = 801;
    return this.module.match3(this, paramObject1, paramObject2, paramObject3, paramCallContext);
  }

  public int match4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    paramCallContext.count = 4;
    paramCallContext.where = 17185;
    return this.module.match4(this, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
  }

  public int matchN(Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    paramCallContext.count = paramArrayOfObject.length;
    paramCallContext.where = 0;
    return this.module.matchN(this, paramArrayOfObject, paramCallContext);
  }

  public int numArgs()
  {
    return this.numArgs;
  }

  protected void resolveParameterTypes()
  {
    Object localObject = null;
    String str1 = getName();
    Method[] arrayOfMethod;
    int i;
    Type[] arrayOfType;
    if (str1 != null)
      try
      {
        arrayOfMethod = this.module.getClass().getDeclaredMethods();
        String str2 = Compilation.mangleNameIfNeeded(str1);
        i = arrayOfMethod.length;
        do
        {
          i--;
          if (i < 0)
            break;
        }
        while (!arrayOfMethod[i].getName().equals(str2));
        if (localObject != null)
        {
          localObject = null;
          if (localObject != null)
          {
            Language localLanguage = Language.getDefaultLanguage();
            if (localLanguage != null)
            {
              Class[] arrayOfClass = localObject.getParameterTypes();
              int j = arrayOfClass.length;
              arrayOfType = new Type[j];
              int k = j;
              while (true)
              {
                k--;
                if (k < 0)
                  break;
                arrayOfType[k] = localLanguage.getTypeFor(arrayOfClass[k]);
              }
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
      }
    while (true)
    {
      if (this.argTypes == null)
        super.resolveParameterTypes();
      return;
      localObject = arrayOfMethod[i];
      break;
      this.argTypes = arrayOfType;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ModuleMethod
 * JD-Core Version:    0.6.2
 */