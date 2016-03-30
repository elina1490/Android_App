package kawa.standard;

import gnu.kawa.functions.ObjectFormat;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.math.IntNum;
import java.io.IOException;
import java.io.PrintWriter;

public class TracedProcedure extends ProcedureN
{
  static Symbol curIndentSym = Symbol.makeUninterned("current-indentation");
  static int indentationStep = 2;
  boolean enabled;
  public Procedure proc;

  public TracedProcedure(Procedure paramProcedure, boolean paramBoolean)
  {
    this.proc = paramProcedure;
    this.enabled = paramBoolean;
    String str = paramProcedure.getName();
    if (str != null)
      setName(str);
  }

  public static Procedure doTrace(Procedure paramProcedure, boolean paramBoolean)
  {
    if ((paramProcedure instanceof TracedProcedure))
    {
      ((TracedProcedure)paramProcedure).enabled = paramBoolean;
      return paramProcedure;
    }
    return new TracedProcedure(paramProcedure, paramBoolean);
  }

  static void indent(int paramInt, PrintWriter paramPrintWriter)
  {
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      paramPrintWriter.print(' ');
    }
  }

  static void put(Object paramObject, PrintWriter paramPrintWriter)
  {
    try
    {
      if (!ObjectFormat.format(paramObject, paramPrintWriter, 50, true))
        paramPrintWriter.print("...");
      return;
    }
    catch (IOException localIOException)
    {
      paramPrintWriter.print("<caught ");
      paramPrintWriter.print(localIOException);
      paramPrintWriter.print('>');
    }
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    if (this.enabled)
    {
      Location localLocation = Environment.getCurrent().getLocation(curIndentSym);
      Object localObject1 = localLocation.get(null);
      int i;
      if (!(localObject1 instanceof IntNum))
      {
        i = 0;
        localLocation.set(IntNum.zero());
      }
      OutPort localOutPort;
      String str;
      while (true)
      {
        localOutPort = OutPort.errDefault();
        str = getName();
        if (str == null)
          str = "??";
        indent(i, localOutPort);
        localOutPort.print("call to ");
        localOutPort.print(str);
        int j = paramArrayOfObject.length;
        localOutPort.print(" (");
        for (int k = 0; k < j; k++)
        {
          if (k > 0)
            localOutPort.print(' ');
          put(paramArrayOfObject[k], localOutPort);
        }
        i = ((IntNum)localObject1).intValue();
      }
      localOutPort.println(")");
      Object localObject2 = localLocation.setWithSave(IntNum.make(i + indentationStep));
      try
      {
        Object localObject4 = this.proc.applyN(paramArrayOfObject);
        localLocation.setRestore(localObject2);
        indent(i, localOutPort);
        localOutPort.print("return from ");
        localOutPort.print(str);
        localOutPort.print(" => ");
        put(localObject4, localOutPort);
        localOutPort.println();
        return localObject4;
      }
      catch (RuntimeException localRuntimeException)
      {
        indent(i, localOutPort);
        localOutPort.println("procedure " + str + " throws exception " + localRuntimeException);
        throw localRuntimeException;
      }
      finally
      {
        localLocation.setRestore(localObject2);
      }
    }
    return this.proc.applyN(paramArrayOfObject);
  }

  public void print(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print("#<procedure ");
    String str1 = getName();
    if (str1 == null)
    {
      paramPrintWriter.print("<unnamed>");
      if (!this.enabled)
        break label45;
    }
    label45: for (String str2 = ", traced>"; ; str2 = ">")
    {
      paramPrintWriter.print(str2);
      return;
      paramPrintWriter.print(str1);
      break;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.TracedProcedure
 * JD-Core Version:    0.6.2
 */