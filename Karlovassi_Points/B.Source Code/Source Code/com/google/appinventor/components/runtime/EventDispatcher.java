package com.google.appinventor.components.runtime;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EventDispatcher
{
  private static final boolean DEBUG;
  private static final Map<HandlesEventDispatching, EventRegistry> mapDispatchDelegateToEventRegistry = new HashMap();

  private static boolean delegateDispatchEvent(HandlesEventDispatching paramHandlesEventDispatching, Set<EventClosure> paramSet, Component paramComponent, Object[] paramArrayOfObject)
  {
    boolean bool = false;
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      EventClosure localEventClosure = (EventClosure)localIterator.next();
      if (paramHandlesEventDispatching.dispatchEvent(paramComponent, localEventClosure.componentId, localEventClosure.eventName, paramArrayOfObject))
        bool = true;
    }
    return bool;
  }

  public static boolean dispatchEvent(Component paramComponent, String paramString, Object[] paramArrayOfObject)
  {
    HandlesEventDispatching localHandlesEventDispatching = paramComponent.getDispatchDelegate();
    boolean bool1 = localHandlesEventDispatching.canDispatchEvent(paramComponent, paramString);
    boolean bool2 = false;
    if (bool1)
    {
      Set localSet = (Set)getEventRegistry(localHandlesEventDispatching).eventClosuresMap.get(paramString);
      bool2 = false;
      if (localSet != null)
      {
        int i = localSet.size();
        bool2 = false;
        if (i > 0)
          bool2 = delegateDispatchEvent(localHandlesEventDispatching, localSet, paramComponent, paramArrayOfObject);
      }
    }
    return bool2;
  }

  private static EventRegistry getEventRegistry(HandlesEventDispatching paramHandlesEventDispatching)
  {
    EventRegistry localEventRegistry = (EventRegistry)mapDispatchDelegateToEventRegistry.get(paramHandlesEventDispatching);
    if (localEventRegistry == null)
    {
      localEventRegistry = new EventRegistry(paramHandlesEventDispatching);
      mapDispatchDelegateToEventRegistry.put(paramHandlesEventDispatching, localEventRegistry);
    }
    return localEventRegistry;
  }

  public static String makeFullEventName(String paramString1, String paramString2)
  {
    return paramString1 + '$' + paramString2;
  }

  public static void registerEventForDelegation(HandlesEventDispatching paramHandlesEventDispatching, String paramString1, String paramString2)
  {
    EventRegistry localEventRegistry = getEventRegistry(paramHandlesEventDispatching);
    Object localObject = (Set)localEventRegistry.eventClosuresMap.get(paramString2);
    if (localObject == null)
    {
      localObject = new HashSet();
      localEventRegistry.eventClosuresMap.put(paramString2, localObject);
    }
    ((Set)localObject).add(new EventClosure(paramString1, paramString2, null));
  }

  public static void removeDispatchDelegate(HandlesEventDispatching paramHandlesEventDispatching)
  {
    EventRegistry localEventRegistry = removeEventRegistry(paramHandlesEventDispatching);
    if (localEventRegistry != null)
      localEventRegistry.eventClosuresMap.clear();
  }

  private static EventRegistry removeEventRegistry(HandlesEventDispatching paramHandlesEventDispatching)
  {
    return (EventRegistry)mapDispatchDelegateToEventRegistry.remove(paramHandlesEventDispatching);
  }

  public static void unregisterAllEventsForDelegation()
  {
    Iterator localIterator = mapDispatchDelegateToEventRegistry.values().iterator();
    while (localIterator.hasNext())
      ((EventRegistry)localIterator.next()).eventClosuresMap.clear();
  }

  public static void unregisterEventForDelegation(HandlesEventDispatching paramHandlesEventDispatching, String paramString1, String paramString2)
  {
    Set localSet = (Set)getEventRegistry(paramHandlesEventDispatching).eventClosuresMap.get(paramString2);
    if ((localSet == null) || (localSet.isEmpty()));
    while (true)
    {
      return;
      HashSet localHashSet = new HashSet();
      Iterator localIterator1 = localSet.iterator();
      while (localIterator1.hasNext())
      {
        EventClosure localEventClosure = (EventClosure)localIterator1.next();
        if (localEventClosure.componentId.equals(paramString1))
          localHashSet.add(localEventClosure);
      }
      Iterator localIterator2 = localHashSet.iterator();
      while (localIterator2.hasNext())
        localSet.remove((EventClosure)localIterator2.next());
    }
  }

  private static final class EventClosure
  {
    private final String componentId;
    private final String eventName;

    private EventClosure(String paramString1, String paramString2)
    {
      this.componentId = paramString1;
      this.eventName = paramString2;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject)
        return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      EventClosure localEventClosure = (EventClosure)paramObject;
      if (!this.componentId.equals(localEventClosure.componentId))
        return false;
      return this.eventName.equals(localEventClosure.eventName);
    }

    public int hashCode()
    {
      return 31 * this.eventName.hashCode() + this.componentId.hashCode();
    }
  }

  private static final class EventRegistry
  {
    private final HandlesEventDispatching dispatchDelegate;
    private final HashMap<String, Set<EventDispatcher.EventClosure>> eventClosuresMap = new HashMap();

    EventRegistry(HandlesEventDispatching paramHandlesEventDispatching)
    {
      this.dispatchDelegate = paramHandlesEventDispatching;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     com.google.appinventor.components.runtime.EventDispatcher
 * JD-Core Version:    0.6.2
 */