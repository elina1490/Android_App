package com.google.appinventor.components.runtime.collect;

import java.util.HashMap;
import java.util.TreeMap;

public class Maps
{
  public static <K, V> HashMap<K, V> newHashMap()
  {
    return new HashMap();
  }

  public static <K, V> TreeMap<K, V> newTreeMap()
  {
    return new TreeMap();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.collect.Maps
 * JD-Core Version:    0.6.2
 */