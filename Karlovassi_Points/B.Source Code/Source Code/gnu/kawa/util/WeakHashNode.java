package gnu.kawa.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map.Entry;

public class WeakHashNode<K, V> extends WeakReference<K>
  implements Map.Entry<K, V>
{
  public int hash;
  public WeakHashNode<K, V> next;
  public V value;

  public WeakHashNode(K paramK, ReferenceQueue<K> paramReferenceQueue, int paramInt)
  {
    super(paramK, paramReferenceQueue);
    this.hash = paramInt;
  }

  public K getKey()
  {
    return get();
  }

  public V getValue()
  {
    return this.value;
  }

  public V setValue(V paramV)
  {
    Object localObject = this.value;
    this.value = paramV;
    return localObject;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.WeakHashNode
 * JD-Core Version:    0.6.2
 */