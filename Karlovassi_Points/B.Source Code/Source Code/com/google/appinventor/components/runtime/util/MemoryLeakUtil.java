package com.google.appinventor.components.runtime.util;

import android.util.Log;
import com.google.appinventor.components.runtime.collect.Maps;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryLeakUtil
{
  private static final String LOG_TAG = "MemoryLeakUtil";
  private static final Map<String, WeakReference<Object>> TRACKED_OBJECTS = Maps.newTreeMap();
  private static final AtomicInteger prefixGenerator = new AtomicInteger(0);

  public static void checkAllTrackedObjects(boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.i("MemoryLeakUtil", "Checking Tracked Objects ----------------------------------------");
    System.gc();
    int i = 0;
    int j = 0;
    Iterator localIterator = TRACKED_OBJECTS.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      Object localObject = ((WeakReference)localEntry.getValue()).get();
      label88: StringBuilder localStringBuilder;
      if (localObject != null)
      {
        i++;
        if (!paramBoolean1)
          break label180;
        String str2 = str1.substring(1 + str1.indexOf("_"));
        localStringBuilder = new StringBuilder().append("Object with tag ").append(str2).append(" has ");
        if (localObject == null)
          break label182;
      }
      label180: label182: for (String str3 = "not "; ; str3 = "")
      {
        Log.i("MemoryLeakUtil", str3 + "been garbage collected.");
        break;
        j++;
        if (!paramBoolean2)
          break label88;
        localIterator.remove();
        break label88;
        break;
      }
    }
    Log.i("MemoryLeakUtil", "summary: collected " + j);
    Log.i("MemoryLeakUtil", "summary: remaining " + i);
    Log.i("MemoryLeakUtil", "-----------------------------------------------------------------");
  }

  public static boolean isTrackedObjectCollected(String paramString, boolean paramBoolean)
  {
    System.gc();
    WeakReference localWeakReference = (WeakReference)TRACKED_OBJECTS.get(paramString);
    if (localWeakReference != null)
    {
      Object localObject = localWeakReference.get();
      String str1 = paramString.substring(1 + paramString.indexOf("_"));
      StringBuilder localStringBuilder = new StringBuilder().append("Object with tag ").append(str1).append(" has ");
      if (localObject != null);
      for (String str2 = "not "; ; str2 = "")
      {
        Log.i("MemoryLeakUtil", str2 + "been garbage collected.");
        if ((paramBoolean) && (localObject == null))
          TRACKED_OBJECTS.remove(paramString);
        if (localObject != null)
          break;
        return true;
      }
      return false;
    }
    throw new IllegalArgumentException("key not found");
  }

  public static String trackObject(String paramString, Object paramObject)
  {
    if (paramString == null);
    for (String str = prefixGenerator.incrementAndGet() + "_"; ; str = prefixGenerator.incrementAndGet() + "_" + paramString)
    {
      TRACKED_OBJECTS.put(str, new WeakReference(paramObject));
      return str;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.util.MemoryLeakUtil
 * JD-Core Version:    0.6.2
 */