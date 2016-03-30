package gnu.kawa.models;

public abstract class Model
  implements Viewable
{
  transient WeakListener listeners;

  public void addListener(ModelListener paramModelListener)
  {
    this.listeners = new WeakListener(paramModelListener, this.listeners);
  }

  public void addListener(WeakListener paramWeakListener)
  {
    paramWeakListener.next = this.listeners;
    this.listeners = paramWeakListener;
  }

  public void notifyListeners(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = this.listeners;
    if (localObject2 != null)
    {
      Object localObject3 = ((WeakListener)localObject2).get();
      WeakListener localWeakListener = ((WeakListener)localObject2).next;
      if (localObject3 == null)
        if (localObject1 != null)
          localObject1.next = localWeakListener;
      while (true)
      {
        localObject2 = localWeakListener;
        break;
        localObject1 = localObject2;
        ((WeakListener)localObject2).update(localObject3, this, paramString);
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.Model
 * JD-Core Version:    0.6.2
 */