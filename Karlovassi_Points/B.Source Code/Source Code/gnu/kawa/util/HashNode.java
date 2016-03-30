package gnu.kawa.util;

import java.util.Map.Entry;

public class HashNode<K, V>
  implements Map.Entry<K, V>
{
  int hash;
  K key;
  public HashNode<K, V> next;
  V value;

  public HashNode(K paramK, V paramV)
  {
    this.key = paramK;
    this.value = paramV;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof HashNode))
      return false;
    HashNode localHashNode = (HashNode)paramObject;
    if (this.key == null)
    {
      if (localHashNode.key != null)
        break label58;
      if (this.value != null)
        break label60;
      if (localHashNode.value != null)
        break label58;
    }
    while (true)
    {
      return true;
      if (this.key.equals(localHashNode.key))
        break;
      label58: label60: 
      do
        return false;
      while (!this.value.equals(localHashNode.value));
    }
  }

  public V get(V paramV)
  {
    return getValue();
  }

  public K getKey()
  {
    return this.key;
  }

  public V getValue()
  {
    return this.value;
  }

  public int hashCode()
  {
    int i;
    if (this.key == null)
    {
      i = 0;
      if (this.value != null)
        break label33;
    }
    label33: for (int j = 0; ; j = this.value.hashCode())
    {
      return i ^ j;
      i = this.key.hashCode();
      break;
    }
  }

  public V setValue(V paramV)
  {
    Object localObject = this.value;
    this.value = paramV;
    return localObject;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.HashNode
 * JD-Core Version:    0.6.2
 */