package gnu.mapping;

public abstract class Procedure4 extends Procedure
{
  public Procedure4()
  {
  }

  public Procedure4(String paramString)
  {
    super(paramString);
  }

  public Object apply0()
  {
    throw new WrongArguments(this, 0);
  }

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

  public abstract Object apply4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    throws Throwable;

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    if (paramArrayOfObject.length != 4)
      throw new WrongArguments(this, paramArrayOfObject.length);
    return apply4(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2], paramArrayOfObject[3]);
  }

  public int numArgs()
  {
    return 16388;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Procedure4
 * JD-Core Version:    0.6.2
 */