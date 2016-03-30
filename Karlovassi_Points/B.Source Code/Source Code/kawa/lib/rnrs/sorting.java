package kawa.lib.rnrs;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lib.srfi95;
import kawa.standard.append;

public class sorting extends ModuleBody
{
  public static final sorting $instance;
  static final SimpleSymbol Lit0;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2 = (SimpleSymbol)new SimpleSymbol("vector-sort!").readResolve();
  public static final ModuleMethod list$Mnsort;
  public static final ModuleMethod vector$Mnsort;
  public static final ModuleMethod vector$Mnsort$Ex;

  static
  {
    Lit1 = (SimpleSymbol)new SimpleSymbol("vector-sort").readResolve();
    Lit0 = (SimpleSymbol)new SimpleSymbol("list-sort").readResolve();
    $instance = new sorting();
    sorting localsorting = $instance;
    list$Mnsort = new ModuleMethod(localsorting, 1, Lit0, 8194);
    vector$Mnsort = new ModuleMethod(localsorting, 2, Lit1, 8194);
    vector$Mnsort$Ex = new ModuleMethod(localsorting, 3, Lit2, 8194);
    $instance.run();
  }

  public sorting()
  {
    ModuleInfo.register(this);
  }

  public static Object listSort(Object paramObject1, Object paramObject2)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramObject2;
    arrayOfObject[1] = LList.Empty;
    return srfi95.$PcSortList(append.append$V(arrayOfObject), paramObject1, Boolean.FALSE);
  }

  public static void vectorSort(Object paramObject1, Object paramObject2)
  {
    try
    {
      Sequence localSequence = (Sequence)paramObject2;
      srfi95.$PcSortVector(localSequence, paramObject1, Boolean.FALSE);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "%sort-vector", 1, paramObject2);
    }
  }

  public static void vectorSort$Ex(Object paramObject1, Object paramObject2)
  {
    try
    {
      Sequence localSequence = (Sequence)paramObject2;
      srfi95.$PcVectorSort$Ex(localSequence, paramObject1, Boolean.FALSE);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new WrongType(localClassCastException, "%vector-sort!", 1, paramObject2);
    }
  }

  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.apply2(paramModuleMethod, paramObject1, paramObject2);
    case 1:
      return listSort(paramObject1, paramObject2);
    case 2:
      vectorSort(paramObject1, paramObject2);
      return Values.empty;
    case 3:
    }
    vectorSort$Ex(paramObject1, paramObject2);
    return Values.empty;
  }

  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    switch (paramModuleMethod.selector)
    {
    default:
      return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
    case 3:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 2:
      paramCallContext.value1 = paramObject1;
      paramCallContext.value2 = paramObject2;
      paramCallContext.proc = paramModuleMethod;
      paramCallContext.pc = 2;
      return 0;
    case 1:
    }
    paramCallContext.value1 = paramObject1;
    paramCallContext.value2 = paramObject2;
    paramCallContext.proc = paramModuleMethod;
    paramCallContext.pc = 2;
    return 0;
  }

  public final void run(CallContext paramCallContext)
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lib.rnrs.sorting
 * JD-Core Version:    0.6.2
 */