package gnu.mapping;

public abstract class Procedure1or2 extends Procedure
{
  public Procedure1or2()
  {
  }

  public Procedure1or2(String paramString)
  {
    super(paramString);
  }

  public Object apply0()
  {
    throw new WrongArguments(this, 0);
  }

  public abstract Object apply1(Object paramObject)
    throws Throwable;

  public abstract Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable;

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
    if (paramArrayOfObject.length == 1)
      return apply1(paramArrayOfObject[0]);
    if (paramArrayOfObject.length == 2)
      return apply2(paramArrayOfObject[0], paramArrayOfObject[1]);
    throw new WrongArguments(this, paramArrayOfObject.length);
  }

  public int numArgs()
  {
    return 8193;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Procedure1or2
 * JD-Core Version:    0.6.2
 */