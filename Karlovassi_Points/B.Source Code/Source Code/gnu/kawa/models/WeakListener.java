package gnu.kawa.models;

import java.lang.ref.WeakReference;

public class WeakListener extends WeakReference
{
  WeakListener next;

  public WeakListener(Object paramObject)
  {
    super(paramObject);
  }

  public WeakListener(Object paramObject, WeakListener paramWeakListener)
  {
    super(paramObject);
    this.next = paramWeakListener;
  }

  public void update(Object paramObject1, Model paramModel, Object paramObject2)
  {
    ((ModelListener)paramObject1).modelUpdated(paramModel, paramObject2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.WeakListener
 * JD-Core Version:    0.6.2
 */