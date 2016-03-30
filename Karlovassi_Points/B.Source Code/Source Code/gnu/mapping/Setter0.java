package gnu.mapping;

public class Setter0 extends Setter
{
  public Setter0(Procedure paramProcedure)
  {
    super(paramProcedure);
  }

  public Object apply1(Object paramObject)
    throws Throwable
  {
    this.getter.set0(paramObject);
    return Values.empty;
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    int i = paramArrayOfObject.length;
    if (i != 1)
      throw new WrongArguments(this, i);
    this.getter.set0(paramArrayOfObject[0]);
    return Values.empty;
  }

  public int numArgs()
  {
    return 4097;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Setter0
 * JD-Core Version:    0.6.2
 */