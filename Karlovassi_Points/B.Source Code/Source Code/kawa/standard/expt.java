package kawa.standard;

import gnu.mapping.Procedure2;
import gnu.math.Complex;
import gnu.math.IntNum;
import gnu.math.Numeric;

public class expt extends Procedure2
{
  public static final expt expt = new expt("expt");

  public expt(String paramString)
  {
    super(paramString);
  }

  public static IntNum expt(IntNum paramIntNum, int paramInt)
  {
    return IntNum.power(paramIntNum, paramInt);
  }

  public static Numeric expt(Object paramObject1, Object paramObject2)
  {
    if ((paramObject2 instanceof IntNum))
      return ((Numeric)paramObject1).power((IntNum)paramObject2);
    return Complex.power((Complex)paramObject1, (Complex)paramObject2);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    return expt(paramObject1, paramObject2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.expt
 * JD-Core Version:    0.6.2
 */