package com.google.appinventor.components.runtime.collect;

import java.util.ArrayList;
import java.util.Collections;

public class Lists
{
  public static <E> ArrayList<E> newArrayList()
  {
    return new ArrayList();
  }

  public static <E> ArrayList<E> newArrayList(E[] paramArrayOfE)
  {
    ArrayList localArrayList = new ArrayList(5 + 110 * paramArrayOfE.length / 100);
    Collections.addAll(localArrayList, paramArrayOfE);
    return localArrayList;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.collect.Lists
 * JD-Core Version:    0.6.2
 */