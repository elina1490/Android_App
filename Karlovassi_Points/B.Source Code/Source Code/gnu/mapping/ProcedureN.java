package gnu.mapping;

public abstract class ProcedureN extends Procedure
{
  public static final Object[] noArgs = new Object[0];

  public ProcedureN()
  {
  }

  public ProcedureN(String paramString)
  {
    super(paramString);
  }

  public Object apply0()
    throws Throwable
  {
    return applyN(noArgs);
  }

  public Object apply1(Object paramObject)
    throws Throwable
  {
    return applyN(new Object[] { paramObject });
  }

  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    return applyN(new Object[] { paramObject1, paramObject2 });
  }

  public Object apply3(Object paramObject1, Object paramObject2, Object paramObject3)
    throws Throwable
  {
    return applyN(new Object[] { paramObject1, paramObject2, paramObject3 });
  }

  public Object apply4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    throws Throwable
  {
    return applyN(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
  }

  public abstract Object applyN(Object[] paramArrayOfObject)
    throws Throwable;
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.ProcedureN
 * JD-Core Version:    0.6.2
 */