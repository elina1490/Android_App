package kawa.standard;

import gnu.math.NamedUnit;
import gnu.math.Quantity;
import gnu.math.Unit;
import kawa.lang.GenericError;

public class sleep
{
  public static void sleep(Quantity paramQuantity)
  {
    Unit localUnit = paramQuantity.unit();
    long l;
    int i;
    if ((localUnit == Unit.Empty) || (localUnit.dimensions() == Unit.second.dimensions()))
    {
      double d = paramQuantity.doubleValue();
      l = ()(1000.0D * d);
      i = (int)(1000000000.0D * d - 1000000.0D * l);
    }
    try
    {
      Thread.sleep(l, i);
      return;
      throw new GenericError("bad unit for sleep");
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    throw new GenericError("sleep was interrupted");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.sleep
 * JD-Core Version:    0.6.2
 */