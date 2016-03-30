package kawa.lang;

import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

public class NamedException extends RuntimeException
{
  Object[] args;
  Symbol name;

  public NamedException(Symbol paramSymbol, Object[] paramArrayOfObject)
  {
    this.name = paramSymbol;
    this.args = paramArrayOfObject;
  }

  public Object applyHandler(Object paramObject, Procedure paramProcedure)
    throws Throwable
  {
    checkMatch(paramObject);
    return paramProcedure.applyN(this.args);
  }

  public void checkMatch(Object paramObject)
  {
    if ((paramObject != this.name) && (paramObject != Boolean.TRUE))
      throw this;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("#<ERROR");
    int i = this.args.length;
    int j = 0;
    if (i > 1)
    {
      Object localObject = this.args[0];
      j = 0;
      if (localObject != "misc-error");
    }
    for (j = 0 + 1; j < i; j++)
    {
      localStringBuffer.append(' ');
      localStringBuffer.append(this.args[j]);
    }
    localStringBuffer.append(">");
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.NamedException
 * JD-Core Version:    0.6.2
 */