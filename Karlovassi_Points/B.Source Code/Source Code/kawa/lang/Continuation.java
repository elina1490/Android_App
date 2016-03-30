package kawa.lang;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;

public class Continuation extends MethodProc
{
  static int counter;
  int id;
  public boolean invoked;

  public Continuation(CallContext paramCallContext)
  {
  }

  public static Object handleException(Throwable paramThrowable, Continuation paramContinuation)
    throws Throwable
  {
    CalledContinuation localCalledContinuation;
    if ((paramThrowable instanceof CalledContinuation))
    {
      localCalledContinuation = (CalledContinuation)paramThrowable;
      if (localCalledContinuation.continuation == paramContinuation);
    }
    else
    {
      throw paramThrowable;
    }
    paramContinuation.invoked = true;
    return Values.make(localCalledContinuation.values);
  }

  public static void handleException$X(Throwable paramThrowable, Continuation paramContinuation, CallContext paramCallContext)
    throws Throwable
  {
    CalledContinuation localCalledContinuation;
    if ((paramThrowable instanceof CalledContinuation))
    {
      localCalledContinuation = (CalledContinuation)paramThrowable;
      if (localCalledContinuation.continuation == paramContinuation);
    }
    else
    {
      throw paramThrowable;
    }
    paramContinuation.invoked = true;
    Object[] arrayOfObject = localCalledContinuation.values;
    int i = arrayOfObject.length;
    for (int j = 0; j < i; j++)
      paramCallContext.consumer.writeObject(arrayOfObject[j]);
  }

  public void apply(CallContext paramCallContext)
  {
    if (this.invoked)
      throw new GenericError("implementation restriction: continuation can only be used once");
    throw new CalledContinuation(paramCallContext.values, this, paramCallContext);
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("#<continuation ").append(this.id);
    if (this.invoked);
    for (String str = " (invoked)>"; ; str = ">")
      return str;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Continuation
 * JD-Core Version:    0.6.2
 */