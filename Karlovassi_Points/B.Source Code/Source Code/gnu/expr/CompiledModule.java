package gnu.expr;

import gnu.lists.AbstractFormat;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.OutPort;
import java.io.Writer;
import kawa.Shell;

public class CompiledModule
{
  Object cookie;
  Language language;
  ModuleExp mexp;

  public CompiledModule(ModuleExp paramModuleExp, Object paramObject, Language paramLanguage)
  {
    this.mexp = paramModuleExp;
    this.cookie = paramObject;
    this.language = paramLanguage;
  }

  public static CompiledModule make(Class paramClass, Language paramLanguage)
  {
    return new CompiledModule(null, paramClass, paramLanguage);
  }

  public void evalModule(Environment paramEnvironment, CallContext paramCallContext)
    throws Throwable
  {
    Language localLanguage = Language.setSaveCurrent(this.language);
    Environment localEnvironment = Environment.setSaveCurrent(paramEnvironment);
    try
    {
      ModuleExp.evalModule2(paramEnvironment, paramCallContext, this.language, this.mexp, this.cookie);
      return;
    }
    finally
    {
      Language.restoreCurrent(localLanguage);
      Environment.restoreCurrent(localEnvironment);
    }
  }

  public void evalModule(Environment paramEnvironment, OutPort paramOutPort)
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    Consumer localConsumer = localCallContext.consumer;
    boolean bool = ModuleBody.getMainPrintValues();
    AbstractFormat localAbstractFormat = paramOutPort.objectFormat;
    Object localObject1;
    if (bool)
      localObject1 = Shell.getOutputConsumer(paramOutPort);
    while (true)
    {
      localCallContext.consumer = ((Consumer)localObject1);
      try
      {
        evalModule(paramEnvironment, localCallContext);
        return;
        localObject1 = new VoidConsumer();
      }
      finally
      {
        if ((localCallContext.consumer instanceof Writer))
          ((Writer)localCallContext.consumer).flush();
        localCallContext.consumer = localConsumer;
        paramOutPort.objectFormat = localAbstractFormat;
      }
    }
  }

  public Object evalToResultValue(Environment paramEnvironment, CallContext paramCallContext)
    throws Throwable
  {
    int i = paramCallContext.startFromContext();
    try
    {
      evalModule(paramEnvironment, paramCallContext);
      Object localObject = paramCallContext.getFromContext(i);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      paramCallContext.cleanupFromContext(i);
      throw localThrowable;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.CompiledModule
 * JD-Core Version:    0.6.2
 */