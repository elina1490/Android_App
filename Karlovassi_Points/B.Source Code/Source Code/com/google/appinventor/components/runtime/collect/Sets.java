package com.google.appinventor.components.runtime.collect;

import java.util.Collections;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sets
{
  public static <K> HashSet<K> newHashSet()
  {
    return new HashSet();
  }

  public static <E> HashSet<E> newHashSet(E[] paramArrayOfE)
  {
    HashSet localHashSet = new HashSet(1 + 4 * paramArrayOfE.length / 3);
    Collections.addAll(localHashSet, paramArrayOfE);
    return localHashSet;
  }

  public static <E> SortedSet<E> newSortedSet(E[] paramArrayOfE)
  {
    TreeSet localTreeSet = new TreeSet();
    Collections.addAll(localTreeSet, paramArrayOfE);
    return localTreeSet;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.collect.Sets
 * JD-Core Version:    0.6.2
 */