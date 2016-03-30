package gnu.mapping;

public abstract class Procedure0 extends Procedure
{
  public Procedure0()
  {
  }

  public Procedure0(String paramString)
  {
    super(paramString);
  }

  public abstract Object apply0()
    throws Throwable;

  public Object apply1(Object paramObject)
  {
    throw new WrongArguments(this, 1);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    throw new WrongArguments(this, 2);
  }

  public Object apply3(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    throw new WrongArguments(this, 3);
  }

  public Object apply4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    throw new WrongArguments(this, 4);
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    if (paramArrayOfObject.length != 0)
      throw new WrongArguments(this, paramArrayOfObject.length);
    return apply0();
  }

  public int numArgs()
  {
    return 0;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Procedure0
 * JD-Core Version:    0.6.2
 */