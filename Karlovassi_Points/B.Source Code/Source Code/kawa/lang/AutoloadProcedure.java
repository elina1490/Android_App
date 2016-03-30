package kawa.lang;

import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleContext;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class AutoloadProcedure extends Procedure
  implements Externalizable
{
  static final Class classModuleBody = ModuleBody.class;
  String className;
  Language language;
  Procedure loaded;

  public AutoloadProcedure()
  {
  }

  public AutoloadProcedure(String paramString1, String paramString2)
  {
    super(paramString1);
    this.className = paramString2;
  }

  public AutoloadProcedure(String paramString1, String paramString2, Language paramLanguage)
  {
    super(paramString1);
    this.className = paramString2;
    this.language = paramLanguage;
  }

  private void throw_error(String paramString)
  {
    this.loaded = null;
    String str1 = getName();
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(this.className).append(" while autoloading ");
    if (str1 == null);
    for (String str2 = ""; ; str2 = str1.toString())
      throw new RuntimeException(str2);
  }

  public Object apply0()
    throws Throwable
  {
    return getLoaded().apply0();
  }

  public Object apply1(Object paramObject)
    throws Throwable
  {
    return getLoaded().apply1(paramObject);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    return getLoaded().apply2(paramObject1, paramObject2);
  }

  public Object apply3(Object paramObject1, Object paramObject2, Object paramObject3)
    throws Throwable
  {
    return getLoaded().apply3(paramObject1, paramObject2, paramObject3);
  }

  public Object apply4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    throws Throwable
  {
    return getLoaded().apply4(paramObject1, paramObject2, paramObject3, paramObject4);
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    if (this.loaded == null)
      load();
    if ((this.loaded instanceof AutoloadProcedure))
      throw new InternalError("circularity in autoload of " + getName());
    return this.loaded.applyN(paramArrayOfObject);
  }

  public Procedure getLoaded()
  {
    if (this.loaded == null)
      load();
    return this.loaded;
  }

  public Object getProperty(Object paramObject1, Object paramObject2)
  {
    Object localObject = super.getProperty(paramObject1, null);
    if (localObject != null)
      return localObject;
    return getLoaded().getProperty(paramObject1, paramObject2);
  }

  public Procedure getSetter()
  {
    if (this.loaded == null)
      load();
    if ((this.loaded instanceof HasSetter))
      return this.loaded.getSetter();
    return super.getSetter();
  }

  void load()
  {
    Object localObject1 = getSymbol();
    Language localLanguage = this.language;
    if (localLanguage == null)
      localLanguage = Language.getDefaultLanguage();
    Environment localEnvironment = localLanguage.getLangEnvironment();
    Symbol localSymbol;
    if ((localObject1 instanceof Symbol))
      localSymbol = (Symbol)localObject1;
    try
    {
      Class localClass = Class.forName(this.className);
      if (classModuleBody.isAssignableFrom(localClass))
      {
        Object localObject3 = ModuleContext.getContext().searchInstance(localClass);
        if (localObject3 != null);
      }
      do
      {
        try
        {
          Object localObject6 = localClass.getDeclaredField("$instance").get(null);
          localObject5 = localObject6;
          ClassMemberLocation.defineAll(localObject5, localLanguage, localEnvironment);
          if ((localObject5 instanceof ModuleBody))
            ((ModuleBody)localObject5).run();
          Object localObject4 = localEnvironment.getFunction(localSymbol, null);
          if ((localObject4 == null) || (!(localObject4 instanceof Procedure)))
            throw_error("invalid ModuleBody class - does not define " + localObject1);
          this.loaded = ((Procedure)localObject4);
          if ((localObject1 != null) && (this.loaded.getSymbol() == null))
            this.loaded.setSymbol(localObject1);
          return;
          localSymbol = localEnvironment.getSymbol(localObject1.toString());
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          while (true)
            Object localObject5 = localClass.newInstance();
        }
        this.loaded = ((Procedure)localClass.newInstance());
        if (this.loaded == this)
          throw_error("circularity detected");
      }
      while (localObject1 == null);
      while (true)
      {
        try
        {
          if (!localLanguage.hasSeparateFunctionNamespace())
            break label275;
          localObject2 = EnvironmentKey.FUNCTION;
          localEnvironment.put(localSymbol, localObject2, this.loaded);
        }
        catch (UnboundLocationException localUnboundLocationException)
        {
        }
        break;
        label275: Object localObject2 = null;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw_error("failed to find class ");
      return;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw_error("failed to instantiate class ");
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw_error("illegal access in class ");
    }
  }

  public int numArgs()
  {
    return getLoaded().numArgs();
  }

  public void print(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print("#<procedure ");
    String str = getName();
    if (str != null)
      paramPrintWriter.print(str);
    paramPrintWriter.print('>');
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    setName((String)paramObjectInput.readObject());
    this.className = ((String)paramObjectInput.readObject());
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(getName());
    paramObjectOutput.writeObject(this.className);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.AutoloadProcedure
 * JD-Core Version:    0.6.2
 */