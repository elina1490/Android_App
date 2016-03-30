package gnu.kawa.functions;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class CountValues extends Procedure1
{
  public static final CountValues countValues = new CountValues();

  public static int countValues(Object paramObject)
  {
    if ((paramObject instanceof Values))
      return ((Values)paramObject).size();
    return 1;
  }

  public void apply(CallContext paramCallContext)
  {
    Consumer localConsumer = paramCallContext.consumer;
    Object localObject = paramCallContext.getNextArg();
    paramCallContext.lastArg();
    localConsumer.writeInt(countValues(localObject));
  }

  public Object apply1(Object paramObject)
  {
    return IntNum.make(countValues(paramObject));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.CountValues
 * JD-Core Version:    0.6.2
 */