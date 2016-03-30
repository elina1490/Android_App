package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.ListPat;
import kawa.lang.Pattern;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class prim_method extends Syntax
{
  public static final prim_method interface_method;
  public static final prim_method op1;
  private static Pattern pattern3 = new ListPat(3);
  private static Pattern pattern4 = new ListPat(4);
  public static final prim_method static_method;
  public static final prim_method virtual_method = new prim_method(182);
  int op_code;

  static
  {
    virtual_method.setName("primitive-virtual-method");
    static_method = new prim_method(184);
    static_method.setName("primitive-static-method");
    interface_method = new prim_method(185);
    interface_method.setName("primitive-interface-method");
    op1 = new prim_method();
    op1.setName("primitive-op1");
  }

  public prim_method()
  {
  }

  public prim_method(int paramInt)
  {
    this.op_code = paramInt;
  }

  int opcode()
  {
    return this.op_code;
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    Object[] arrayOfObject = new Object[4];
    if (this.op_code == 0)
    {
      if (!pattern3.match(paramObject, arrayOfObject, 1));
    }
    else
      while (pattern4.match(paramObject, arrayOfObject, 0))
      {
        if ((arrayOfObject[3] instanceof LList))
          break;
        return paramTranslator.syntaxError("missing/invalid parameter list in " + getName());
      }
    return paramTranslator.syntaxError("wrong number of arguments to " + getName() + "(opcode:" + this.op_code + ")");
    LList localLList = (LList)arrayOfObject[3];
    int i = localLList.size();
    Type[] arrayOfType = new Type[i];
    for (int j = 0; j < i; j++)
    {
      Pair localPair2 = (Pair)localLList;
      arrayOfType[j] = paramTranslator.exp2Type(localPair2);
      localLList = (LList)localPair2.getCdr();
    }
    Type localType1 = paramTranslator.exp2Type(new Pair(arrayOfObject[2], null));
    PrimProcedure localPrimProcedure;
    if (this.op_code == 0)
    {
      int k = ((Number)arrayOfObject[1]).intValue();
      localPrimProcedure = new PrimProcedure(k, localType1, arrayOfType);
    }
    ClassType localClassType;
    while (true)
    {
      return new QuoteExp(localPrimProcedure);
      localClassType = null;
      Type localType2 = paramTranslator.exp2Type((Pair)paramObject);
      if (localType2 != null)
        localType2 = localType2.getImplementationType();
      try
      {
        localClassType = (ClassType)localType2;
        localClassType.getReflectClass();
        if ((arrayOfObject[1] instanceof Pair))
        {
          Pair localPair1 = (Pair)arrayOfObject[1];
          if (localPair1.getCar() == "quote")
            arrayOfObject[1] = ((Pair)localPair1.getCdr()).getCar();
        }
        localPrimProcedure = new PrimProcedure(this.op_code, localClassType, arrayOfObject[1].toString(), localType1, arrayOfType);
      }
      catch (Exception localException)
      {
        if (localClassType != null)
          break label397;
      }
    }
    char c = 'e';
    while (true)
    {
      String str = "unknown class: " + arrayOfObject[0];
      paramTranslator.error(c, str);
      break;
      label397: c = 'w';
      localClassType.setExisting(false);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.prim_method
 * JD-Core Version:    0.6.2
 */