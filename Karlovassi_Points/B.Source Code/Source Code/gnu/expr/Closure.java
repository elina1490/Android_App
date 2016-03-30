package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import java.lang.reflect.Array;

class Closure extends MethodProc
{
  Object[][] evalFrames;
  LambdaExp lambda;

  public Closure(LambdaExp paramLambdaExp, CallContext paramCallContext)
  {
    this.lambda = paramLambdaExp;
    Object[][] arrayOfObject = paramCallContext.evalFrames;
    if (arrayOfObject != null)
    {
      for (int i = arrayOfObject.length; (i > 0) && (arrayOfObject[(i - 1)] == null); i--);
      this.evalFrames = new Object[i][];
      System.arraycopy(arrayOfObject, 0, this.evalFrames, 0, i);
    }
    setSymbol(this.lambda.getSymbol());
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    int i = ScopeExp.nesting(this.lambda);
    Object[] arrayOfObject = paramCallContext.values;
    Object[][] arrayOfObject1 = paramCallContext.evalFrames;
    if (this.evalFrames == null);
    for (int j = 0; ; j = this.evalFrames.length)
    {
      if (i >= j)
        j = i;
      Object[][] arrayOfObject; = new Object[j + 10][];
      if (this.evalFrames != null)
        System.arraycopy(this.evalFrames, 0, arrayOfObject;, 0, this.evalFrames.length);
      arrayOfObject;[i] = arrayOfObject;
      paramCallContext.evalFrames = arrayOfObject;;
      try
      {
        if (this.lambda.body != null)
          break;
        StringBuffer localStringBuffer = new StringBuffer("procedure ");
        String str = this.lambda.getName();
        if (str == null)
          str = "<anonymous>";
        localStringBuffer.append(str);
        int k = this.lambda.getLineNumber();
        if (k > 0)
        {
          localStringBuffer.append(" at line ");
          localStringBuffer.append(k);
        }
        localStringBuffer.append(" was called before it was expanded");
        throw new RuntimeException(localStringBuffer.toString());
      }
      finally
      {
        paramCallContext.evalFrames = arrayOfObject1;
      }
    }
    this.lambda.body.apply(paramCallContext);
    paramCallContext.evalFrames = arrayOfObject1;
  }

  public Object getProperty(Object paramObject1, Object paramObject2)
  {
    Object localObject = super.getProperty(paramObject1, paramObject2);
    if (localObject == null)
      localObject = this.lambda.getProperty(paramObject1, paramObject2);
    return localObject;
  }

  public int match0(CallContext paramCallContext)
  {
    return matchN(new Object[0], paramCallContext);
  }

  public int match1(Object paramObject, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject }, paramCallContext);
  }

  public int match2(Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject1, paramObject2 }, paramCallContext);
  }

  public int match3(Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject1, paramObject2, paramObject3 }, paramCallContext);
  }

  public int match4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }, paramCallContext);
  }

  public int matchN(Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    int i = numArgs();
    int j = paramArrayOfObject.length;
    int k = i & 0xFFF;
    if (j < k)
      return 0xFFF10000 | k;
    int m = i >> 12;
    if ((j > m) && (m >= 0))
      return 0xFFF20000 | m;
    Object[] arrayOfObject1 = new Object[this.lambda.frameSize];
    int n;
    if (this.lambda.keywords == null)
      n = 0;
    while (true)
    {
      int i1;
      label91: int i2;
      int i3;
      Declaration localDeclaration;
      int i4;
      int i5;
      label118: int i8;
      Object localObject2;
      int i7;
      if (this.lambda.defaultArgs == null)
      {
        i1 = 0;
        i2 = 0;
        i3 = this.lambda.min_args;
        localDeclaration = this.lambda.firstDecl();
        i4 = 0;
        i5 = 0;
        if (localDeclaration == null)
          break;
        if (i5 >= i3)
          break label253;
        i8 = i5 + 1;
        localObject2 = paramArrayOfObject[i5];
        i7 = i4;
        label146: if (localDeclaration.type == null);
      }
      try
      {
        Object localObject3 = localDeclaration.type.coerceFromObject(localObject2);
        localObject2 = localObject3;
        if (localDeclaration.isIndirectBinding())
        {
          Location localLocation = localDeclaration.makeIndirectLocationFor();
          localLocation.set(localObject2);
          localObject2 = localLocation;
        }
        arrayOfObject1[localDeclaration.evalIndex] = localObject2;
        localDeclaration = localDeclaration.nextDecl();
        i4 = i7;
        i5 = i8;
        break label118;
        n = this.lambda.keywords.length;
        continue;
        i1 = this.lambda.defaultArgs.length - n;
        break label91;
        label253: int i6 = i3 + i1;
        if (i5 < i6)
        {
          Object localObject6;
          if (i5 < j)
          {
            i8 = i5 + 1;
            localObject6 = paramArrayOfObject[i5];
          }
          while (true)
          {
            i2++;
            localObject2 = localObject6;
            i7 = i4;
            break;
            localObject6 = this.lambda.evalDefaultArg(i2, paramCallContext);
            i8 = i5;
          }
        }
        if (this.lambda.max_args < 0)
        {
          int i9 = i3 + i1;
          if (i5 == i9)
          {
            if ((localDeclaration.type instanceof ArrayType))
            {
              int i10 = j - i5;
              Type localType = ((ArrayType)localDeclaration.type).getComponentType();
              if (localType == Type.objectType)
              {
                Object[] arrayOfObject2 = new Object[i10];
                System.arraycopy(paramArrayOfObject, i5, arrayOfObject2, 0, i10);
                localObject4 = arrayOfObject2;
                localObject2 = localObject4;
                i7 = i4;
                i8 = i5;
                break label146;
              }
              Object localObject4 = Array.newInstance(localType.getReflectClass(), i10);
              int i11 = 0;
              while (i11 < i10)
              {
                int i12 = i5 + i11;
                try
                {
                  Object localObject5 = localType.coerceFromObject(paramArrayOfObject[i12]);
                  Array.set(localObject4, i11, localObject5);
                  i11++;
                }
                catch (ClassCastException localClassCastException2)
                {
                  return 0xFFF40000 | i5 + i11;
                }
              }
            }
            localObject2 = LList.makeList(paramArrayOfObject, i5);
            i7 = i4;
            i8 = i5;
            break label146;
          }
        }
        Keyword[] arrayOfKeyword = this.lambda.keywords;
        i7 = i4 + 1;
        Keyword localKeyword = arrayOfKeyword[i4];
        Object localObject1 = Keyword.searchForKeyword(paramArrayOfObject, i3 + i1, localKeyword);
        Special localSpecial = Special.dfault;
        if (localObject1 == localSpecial)
          localObject1 = this.lambda.evalDefaultArg(i2, paramCallContext);
        i2++;
        localObject2 = localObject1;
        i8 = i5;
      }
      catch (ClassCastException localClassCastException1)
      {
        return 0xFFF40000 | i8;
      }
    }
    paramCallContext.values = arrayOfObject1;
    paramCallContext.where = 0;
    paramCallContext.next = 0;
    paramCallContext.proc = this;
    return 0;
  }

  public int numArgs()
  {
    return this.lambda.min_args | this.lambda.max_args << 12;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.Closure
 * JD-Core Version:    0.6.2
 */