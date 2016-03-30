package gnu.ecmascript;

public class Convert
{
  public static double toInteger(double paramDouble)
  {
    if (Double.isNaN(paramDouble))
      return 0.0D;
    if (paramDouble < 0.0D)
      return Math.ceil(paramDouble);
    return Math.floor(paramDouble);
  }

  public static double toInteger(Object paramObject)
  {
    return toInteger(toNumber(paramObject));
  }

  public static double toNumber(Object paramObject)
  {
    if ((paramObject instanceof Number))
      return ((Number)paramObject).doubleValue();
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue())
        return 1.0D;
      return 0.0D;
    }
    if ((paramObject instanceof String))
      try
      {
        double d = Double.valueOf((String)paramObject).doubleValue();
        return d;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return (0.0D / 0.0D);
      }
    return (0.0D / 0.0D);
  }

  public int toInt32(double paramDouble)
  {
    if ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble)))
      return 0;
    return (int)paramDouble;
  }

  public int toInt32(Object paramObject)
  {
    return toInt32(toNumber(paramObject));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.ecmascript.Convert
 * JD-Core Version:    0.6.2
 */