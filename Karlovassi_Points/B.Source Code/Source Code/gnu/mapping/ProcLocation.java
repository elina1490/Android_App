package gnu.mapping;

public class ProcLocation extends Location
{
  Object[] args;
  Procedure proc;

  public ProcLocation(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    this.proc = paramProcedure;
    this.args = paramArrayOfObject;
  }

  public Object get(Object paramObject)
  {
    try
    {
      Object localObject = this.proc.applyN(this.args);
      return localObject;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Error localError)
    {
      throw localError;
    }
    catch (Throwable localThrowable)
    {
      throw new WrappedException(localThrowable);
    }
  }

  public boolean isBound()
  {
    return true;
  }

  public void set(Object paramObject)
  {
    int i = this.args.length;
    Object[] arrayOfObject = new Object[i + 1];
    arrayOfObject[i] = paramObject;
    System.arraycopy(this.args, 0, arrayOfObject, 0, i);
    try
    {
      this.proc.setN(arrayOfObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Error localError)
    {
      throw localError;
    }
    catch (Throwable localThrowable)
    {
      throw new WrappedException(localThrowable);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.ProcLocation
 * JD-Core Version:    0.6.2
 */