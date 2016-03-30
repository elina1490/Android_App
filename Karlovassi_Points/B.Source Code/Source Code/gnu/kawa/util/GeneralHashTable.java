package gnu.kawa.util;

public class GeneralHashTable<K, V> extends AbstractHashTable<HashNode<K, V>, K, V>
{
  public GeneralHashTable()
  {
  }

  public GeneralHashTable(int paramInt)
  {
    super(paramInt);
  }

  protected HashNode<K, V>[] allocEntries(int paramInt)
  {
    return (HashNode[])new HashNode[paramInt];
  }

  protected int getEntryHashCode(HashNode<K, V> paramHashNode)
  {
    return paramHashNode.hash;
  }

  protected HashNode<K, V> getEntryNext(HashNode<K, V> paramHashNode)
  {
    return paramHashNode.next;
  }

  public HashNode<K, V> getNode(Object paramObject)
  {
    return (HashNode)super.getNode(paramObject);
  }

  protected HashNode<K, V> makeEntry(K paramK, int paramInt, V paramV)
  {
    HashNode localHashNode = new HashNode(paramK, paramV);
    localHashNode.hash = paramInt;
    return localHashNode;
  }

  protected void setEntryNext(HashNode<K, V> paramHashNode1, HashNode<K, V> paramHashNode2)
  {
    paramHashNode1.next = paramHashNode2;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.util.GeneralHashTable
 * JD-Core Version:    0.6.2
 */