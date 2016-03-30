package gnu.mapping;

public class Setter extends ProcedureN
{
  protected Procedure getter;

  public Setter(Procedure paramProcedure)
  {
    this.getter = paramProcedure;
    String str = paramProcedure.getName();
    if (str != null)
      setName("(setter " + str + ")");
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    this.getter.setN(paramArrayOfObject);
    return Values.empty;
  }

  public int numArgs()
  {
    int i = this.getter.numArgs();
    if (i < 0)
      return i + 1;
    return i + 4097;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Setter
 * JD-Core Version:    0.6.2
 */