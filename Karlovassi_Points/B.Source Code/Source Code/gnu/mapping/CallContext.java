package gnu.mapping;

import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.math.IntNum;

public class CallContext
{
  public static final int ARG_IN_IVALUE1 = 5;
  public static final int ARG_IN_IVALUE2 = 6;
  public static final int ARG_IN_VALUE1 = 1;
  public static final int ARG_IN_VALUE2 = 2;
  public static final int ARG_IN_VALUE3 = 3;
  public static final int ARG_IN_VALUE4 = 4;
  public static final int ARG_IN_VALUES_ARRAY;
  static ThreadLocal currentContext = new ThreadLocal();
  public Consumer consumer = this.vstack;
  public int count;
  public Object[][] evalFrames;
  public int ivalue1;
  public int ivalue2;
  public int next;
  public int pc;
  public Procedure proc;
  public Object value1;
  public Object value2;
  public Object value3;
  public Object value4;
  public Object[] values;
  public ValueStack vstack = new ValueStack();
  public int where;

  public static CallContext getInstance()
  {
    CallContext localCallContext = getOnlyInstance();
    if (localCallContext == null)
    {
      localCallContext = new CallContext();
      setInstance(localCallContext);
    }
    return localCallContext;
  }

  public static CallContext getOnlyInstance()
  {
    return (CallContext)currentContext.get();
  }

  public static void setInstance(CallContext paramCallContext)
  {
    Thread.currentThread();
    currentContext.set(paramCallContext);
  }

  public final void cleanupFromContext(int paramInt)
  {
    ValueStack localValueStack = this.vstack;
    char[] arrayOfChar = localValueStack.data;
    int i = arrayOfChar[(paramInt - 2)] << '\020' | 0xFFFF & arrayOfChar[(paramInt - 1)];
    this.consumer = ((Consumer)localValueStack.objects[i]);
    localValueStack.objects[i] = null;
    localValueStack.oindex = i;
    localValueStack.gapStart = (paramInt - 3);
  }

  Object getArgAsObject(int paramInt)
  {
    if (paramInt < 8);
    switch (0xF & this.where >> paramInt * 4)
    {
    default:
      return this.values[paramInt];
    case 1:
      return this.value1;
    case 2:
      return this.value2;
    case 3:
      return this.value3;
    case 4:
      return this.value4;
    case 5:
      return IntNum.make(this.ivalue1);
    case 6:
    }
    return IntNum.make(this.ivalue2);
  }

  public int getArgCount()
  {
    return this.count;
  }

  public Object[] getArgs()
  {
    if (this.where == 0)
      return this.values;
    int i = this.count;
    this.next = 0;
    Object[] arrayOfObject = new Object[i];
    for (int j = 0; j < i; j++)
      arrayOfObject[j] = getNextArg();
    return arrayOfObject;
  }

  public final Object getFromContext(int paramInt)
    throws Throwable
  {
    runUntilDone();
    ValueStack localValueStack = this.vstack;
    Object localObject = Values.make(localValueStack, paramInt, localValueStack.gapStart);
    cleanupFromContext(paramInt);
    return localObject;
  }

  public Object getNextArg()
  {
    if (this.next >= this.count)
      throw new WrongArguments(null, this.count);
    int i = this.next;
    this.next = (i + 1);
    return getArgAsObject(i);
  }

  public Object getNextArg(Object paramObject)
  {
    if (this.next >= this.count)
      return paramObject;
    int i = this.next;
    this.next = (i + 1);
    return getArgAsObject(i);
  }

  public int getNextIntArg()
  {
    if (this.next >= this.count)
      throw new WrongArguments(null, this.count);
    int i = this.next;
    this.next = (i + 1);
    return ((Number)getArgAsObject(i)).intValue();
  }

  public int getNextIntArg(int paramInt)
  {
    if (this.next >= this.count)
      return paramInt;
    int i = this.next;
    this.next = (i + 1);
    return ((Number)getArgAsObject(i)).intValue();
  }

  public final Object[] getRestArgsArray(int paramInt)
  {
    Object[] arrayOfObject = new Object[this.count - paramInt];
    int i = 0;
    while (paramInt < this.count)
    {
      int j = i + 1;
      int k = paramInt + 1;
      arrayOfObject[i] = getArgAsObject(paramInt);
      i = j;
      paramInt = k;
    }
    return arrayOfObject;
  }

  public final LList getRestArgsList(int paramInt)
  {
    LList localLList = LList.Empty;
    Object localObject1 = localLList;
    Object localObject2 = null;
    if (paramInt < this.count)
    {
      int i = paramInt + 1;
      Pair localPair = new Pair(getArgAsObject(paramInt), localLList);
      if (localObject2 == null)
        localObject1 = localPair;
      while (true)
      {
        localObject2 = localPair;
        paramInt = i;
        break;
        localObject2.setCdr(localPair);
      }
    }
    return localObject1;
  }

  public void lastArg()
  {
    if (this.next < this.count)
      throw new WrongArguments(null, this.count);
    this.values = null;
  }

  public void runUntilDone()
    throws Throwable
  {
    while (true)
    {
      Procedure localProcedure = this.proc;
      if (localProcedure == null)
        return;
      this.proc = null;
      localProcedure.apply(this);
    }
  }

  public final Object runUntilValue()
    throws Throwable
  {
    Consumer localConsumer = this.consumer;
    ValueStack localValueStack = this.vstack;
    this.consumer = localValueStack;
    int i = localValueStack.gapStart;
    int j = localValueStack.oindex;
    try
    {
      runUntilDone();
      Object localObject2 = Values.make(localValueStack, i, localValueStack.gapStart);
      return localObject2;
    }
    finally
    {
      this.consumer = localConsumer;
      localValueStack.gapStart = i;
      localValueStack.oindex = j;
    }
  }

  public final void runUntilValue(Consumer paramConsumer)
    throws Throwable
  {
    Consumer localConsumer = this.consumer;
    this.consumer = paramConsumer;
    try
    {
      runUntilDone();
      return;
    }
    finally
    {
      this.consumer = localConsumer;
    }
  }

  public final int startFromContext()
  {
    ValueStack localValueStack = this.vstack;
    int i = localValueStack.find(this.consumer);
    localValueStack.ensureSpace(3);
    int j = localValueStack.gapStart;
    char[] arrayOfChar = localValueStack.data;
    int k = j + 1;
    arrayOfChar[j] = 61698;
    localValueStack.setIntN(k, i);
    int m = k + 2;
    this.consumer = localValueStack;
    localValueStack.gapStart = m;
    return m;
  }

  public void writeValue(Object paramObject)
  {
    Values.writeValues(paramObject, this.consumer);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.CallContext
 * JD-Core Version:    0.6.2
 */