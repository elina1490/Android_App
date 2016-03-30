package gnu.kawa.functions;

import gnu.expr.GenericProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;

public class MakeProcedure extends ProcedureN
{
  public static final MakeProcedure makeProcedure = new MakeProcedure("make-procedure");

  public MakeProcedure(String paramString)
  {
    super(paramString);
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakeProcedure");
  }

  public static GenericProc makeProcedure$V(Object[] paramArrayOfObject)
  {
    return GenericProc.make(paramArrayOfObject);
  }

  public Object applyN(Object[] paramArrayOfObject)
  {
    return GenericProc.make(paramArrayOfObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.MakeProcedure
 * JD-Core Version:    0.6.2
 */