package gnu.expr;

import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.WrongType;

public class GenericProc extends MethodProc
{
  int count;
  int maxArgs;
  protected MethodProc[] methods;
  int minArgs;

  public GenericProc()
  {
  }

  public GenericProc(String paramString)
  {
    setName(paramString);
  }

  public static GenericProc make(Object[] paramArrayOfObject)
  {
    GenericProc localGenericProc = new GenericProc();
    localGenericProc.setProperties(paramArrayOfObject);
    return localGenericProc;
  }

  public static GenericProc makeWithoutSorting(Object[] paramArrayOfObject)
  {
    GenericProc localGenericProc = new GenericProc();
    int i = paramArrayOfObject.length;
    int j = 0;
    if (j < i)
    {
      Object localObject = paramArrayOfObject[j];
      if ((localObject instanceof Keyword))
      {
        Keyword localKeyword = (Keyword)localObject;
        j++;
        localGenericProc.setProperty(localKeyword, paramArrayOfObject[j]);
      }
      while (true)
      {
        j++;
        break;
        localGenericProc.addAtEnd((MethodProc)localObject);
      }
    }
    return localGenericProc;
  }

  public void add(MethodProc paramMethodProc)
  {
    try
    {
      int i = this.count;
      addAtEnd(paramMethodProc);
      for (int j = 0; ; j++)
        if (j < i)
        {
          if (MethodProc.mostSpecific(paramMethodProc, this.methods[j]) == paramMethodProc)
          {
            System.arraycopy(this.methods, j, this.methods, j + 1, i - j);
            this.methods[j] = paramMethodProc;
          }
        }
        else
          return;
    }
    finally
    {
    }
  }

  protected void add(MethodProc[] paramArrayOfMethodProc)
  {
    while (true)
    {
      try
      {
        int i = paramArrayOfMethodProc.length;
        if (this.methods == null)
        {
          this.methods = new MethodProc[i];
          break label51;
          if (j < i)
          {
            add(paramArrayOfMethodProc[j]);
            j++;
            continue;
          }
          return;
        }
      }
      finally
      {
      }
      label51: int j = 0;
    }
  }

  public void addAtEnd(MethodProc paramMethodProc)
  {
    try
    {
      int i = this.count;
      if (this.methods == null)
        this.methods = new MethodProc[8];
      while (true)
      {
        this.methods[i] = paramMethodProc;
        int j = paramMethodProc.minArgs();
        if ((j < this.minArgs) || (this.count == 0))
          this.minArgs = j;
        int k = paramMethodProc.maxArgs();
        if ((k == -1) || (k > this.maxArgs))
          this.maxArgs = k;
        this.count = (i + 1);
        return;
        if (i >= this.methods.length)
        {
          MethodProc[] arrayOfMethodProc = new MethodProc[2 * this.methods.length];
          System.arraycopy(this.methods, 0, arrayOfMethodProc, 0, i);
          this.methods = arrayOfMethodProc;
        }
      }
    }
    finally
    {
    }
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    if (this.count == 1)
      return this.methods[0].applyN(paramArrayOfObject);
    checkArgCount(this, paramArrayOfObject.length);
    CallContext localCallContext = CallContext.getInstance();
    for (int i = 0; i < this.count; i++)
      if (this.methods[i].matchN(paramArrayOfObject, localCallContext) == 0)
        return localCallContext.runUntilValue();
    throw new WrongType(this, -1, null);
  }

  public MethodProc getMethod(int paramInt)
  {
    if (paramInt >= this.count)
      return null;
    return this.methods[paramInt];
  }

  public int getMethodCount()
  {
    return this.count;
  }

  public int isApplicable(Type[] paramArrayOfType)
  {
    int i = -1;
    int j = this.count;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      int k = this.methods[j].isApplicable(paramArrayOfType);
      if (k == 1)
        return 1;
      if (k == 0)
        i = 0;
    }
    return i;
  }

  public int match0(CallContext paramCallContext)
  {
    if (this.count == 1)
      return this.methods[0].match0(paramCallContext);
    for (int i = 0; i < this.count; i++)
      if (this.methods[i].match0(paramCallContext) == 0)
        return 0;
    paramCallContext.proc = null;
    return -1;
  }

  public int match1(Object paramObject, CallContext paramCallContext)
  {
    if (this.count == 1)
      return this.methods[0].match1(paramObject, paramCallContext);
    for (int i = 0; i < this.count; i++)
      if (this.methods[i].match1(paramObject, paramCallContext) == 0)
        return 0;
    paramCallContext.proc = null;
    return -1;
  }

  public int match2(Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    if (this.count == 1)
      return this.methods[0].match2(paramObject1, paramObject2, paramCallContext);
    for (int i = 0; i < this.count; i++)
      if (this.methods[i].match2(paramObject1, paramObject2, paramCallContext) == 0)
        return 0;
    paramCallContext.proc = null;
    return -1;
  }

  public int match3(Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    if (this.count == 1)
      return this.methods[0].match3(paramObject1, paramObject2, paramObject3, paramCallContext);
    for (int i = 0; i < this.count; i++)
      if (this.methods[i].match3(paramObject1, paramObject2, paramObject3, paramCallContext) == 0)
        return 0;
    paramCallContext.proc = null;
    return -1;
  }

  public int match4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    if (this.count == 1)
      return this.methods[0].match4(paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext);
    for (int i = 0; i < this.count; i++)
      if (this.methods[i].match4(paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext) == 0)
        return 0;
    paramCallContext.proc = null;
    return -1;
  }

  public int matchN(Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (this.count == 1)
      return this.methods[0].matchN(paramArrayOfObject, paramCallContext);
    int i = paramArrayOfObject.length;
    Type[] arrayOfType = new Type[i];
    Language localLanguage = Language.getDefaultLanguage();
    int j = 0;
    if (j < i)
    {
      Object localObject1 = paramArrayOfObject[j];
      Object localObject2;
      if (localObject1 == null)
        localObject2 = Type.nullType;
      while (true)
      {
        arrayOfType[j] = localObject2;
        j++;
        break;
        Class localClass = localObject1.getClass();
        if (localLanguage != null)
          localObject2 = localLanguage.getTypeFor(localClass);
        else
          localObject2 = Type.make(localClass);
      }
    }
    int[] arrayOfInt = new int[this.count];
    int k = 0;
    int m = 0;
    int n = -1;
    int i1 = 0;
    int i2 = this.count;
    if (i1 < i2)
    {
      int i6 = this.methods[i1].isApplicable(arrayOfType);
      if ((k == 0) && (i6 >= 0))
        n = i1;
      if (i6 > 0)
        k++;
      while (true)
      {
        arrayOfInt[i1] = i6;
        i1++;
        break;
        if (i6 == 0)
          m++;
      }
    }
    if ((k == 1) || ((k == 0) && (m == 1)))
      return this.methods[n].matchN(paramArrayOfObject, paramCallContext);
    int i3 = 0;
    int i4 = this.count;
    if (i3 < i4)
    {
      int i5 = arrayOfInt[i3];
      if ((i5 < 0) || ((i5 == 0) && (k > 0)));
      while (this.methods[i3].matchN(paramArrayOfObject, paramCallContext) != 0)
      {
        i3++;
        break;
      }
      return 0;
    }
    paramCallContext.proc = null;
    return -1;
  }

  public int numArgs()
  {
    return this.minArgs | this.maxArgs << 12;
  }

  public final void setProperties(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    int j = 0;
    if (j < i)
    {
      Object localObject = paramArrayOfObject[j];
      if ((localObject instanceof Keyword))
      {
        Keyword localKeyword = (Keyword)localObject;
        j++;
        setProperty(localKeyword, paramArrayOfObject[j]);
      }
      while (true)
      {
        j++;
        break;
        add((MethodProc)localObject);
      }
    }
  }

  public void setProperty(Keyword paramKeyword, Object paramObject)
  {
    String str = paramKeyword.getName();
    if (str == "name")
    {
      setName(paramObject.toString());
      return;
    }
    if (str == "method")
    {
      add((MethodProc)paramObject);
      return;
    }
    super.setProperty(paramKeyword.asSymbol(), paramObject);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.GenericProc
 * JD-Core Version:    0.6.2
 */