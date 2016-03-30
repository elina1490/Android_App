package kawa.standard;

import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import kawa.lang.GenericError;
import kawa.lang.NamedException;

public class throw_name extends ProcedureN
{
  public static final throw_name throwName = new throw_name();

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    Object localObject;
    if (paramArrayOfObject.length > 0)
    {
      localObject = paramArrayOfObject[0];
      if (!(localObject instanceof Throwable))
        break label36;
      if (paramArrayOfObject.length == 1)
        prim_throw.throw_it(localObject);
    }
    label36: 
    while (!(localObject instanceof Symbol))
      throw new GenericError("bad arguments to throw");
    throw new NamedException((Symbol)localObject, paramArrayOfObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.throw_name
 * JD-Core Version:    0.6.2
 */