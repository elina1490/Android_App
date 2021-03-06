package gnu.kawa.functions;

import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.mapping.ProcedureN;
import gnu.math.IntNum;

public abstract class ArithOp extends ProcedureN
{
  static final int ADD = 1;
  public static final int AND = 13;
  public static final int ASHIFT_GENERAL = 9;
  public static final int ASHIFT_LEFT = 10;
  public static final int ASHIFT_RIGHT = 11;
  public static final int DIVIDE_GENERIC = 4;
  public static final int DIVIDE_INEXACT = 5;
  public static final int IOR = 14;
  public static final int LSHIFT_RIGHT = 12;
  public static final int MODULO = 8;
  static final int MUL = 3;
  public static final int NOT = 16;
  public static final int QUOTIENT = 6;
  public static final int QUOTIENT_EXACT = 7;
  static final int SUB = 2;
  public static final int XOR = 15;
  final int op;

  public ArithOp(String paramString, int paramInt)
  {
    super(paramString);
    this.op = paramInt;
  }

  public static int classify(Type paramType)
  {
    if ((paramType instanceof PrimType))
    {
      int i = paramType.getSignature().charAt(0);
      if ((i == 86) || (i == 90) || (i == 67))
        return 0;
      if ((i == 68) || (i == 70))
        return 3;
      return 4;
    }
    if (paramType.isSubtype(Arithmetic.typeIntNum))
      return 4;
    if (paramType.isSubtype(Arithmetic.typeDFloNum))
      return 3;
    if (paramType.isSubtype(Arithmetic.typeRealNum))
      return 2;
    if (paramType.isSubtype(Arithmetic.typeNumeric))
      return 1;
    return 0;
  }

  public Object defaultResult()
  {
    return IntNum.zero();
  }

  public boolean isSideEffectFree()
  {
    return true;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.ArithOp
 * JD-Core Version:    0.6.2
 */