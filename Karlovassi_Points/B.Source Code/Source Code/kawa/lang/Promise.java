package kawa.lang;

import gnu.lists.Consumer;
import gnu.mapping.Procedure;
import gnu.text.Printable;

public class Promise
  implements Printable
{
  Object result;
  Procedure thunk;

  public Promise(Procedure paramProcedure)
  {
    this.thunk = paramProcedure;
  }

  public static Object force(Object paramObject)
    throws Throwable
  {
    if ((paramObject instanceof Promise))
      return ((Promise)paramObject).force();
    if ((paramObject instanceof gnu.mapping.Future))
      return ((gnu.mapping.Future)paramObject).waitForResult();
    if ((paramObject instanceof java.util.concurrent.Future))
      return ((java.util.concurrent.Future)paramObject).get();
    return paramObject;
  }

  public Object force()
    throws Throwable
  {
    if (this.result == null)
    {
      Object localObject = this.thunk.apply0();
      if (this.result == null)
        this.result = localObject;
    }
    return this.result;
  }

  public void print(Consumer paramConsumer)
  {
    if (this.result == null)
    {
      paramConsumer.write("#<promise - not forced yet>");
      return;
    }
    paramConsumer.write("#<promise - forced to a ");
    paramConsumer.write(this.result.getClass().getName());
    paramConsumer.write(62);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Promise
 * JD-Core Version:    0.6.2
 */