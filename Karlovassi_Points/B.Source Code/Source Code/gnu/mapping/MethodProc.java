package gnu.mapping;

import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;

public abstract class MethodProc extends ProcedureN
{
  public static final int NO_MATCH = -1;
  public static final int NO_MATCH_AMBIGUOUS = -851968;
  public static final int NO_MATCH_BAD_TYPE = -786432;
  public static final int NO_MATCH_TOO_FEW_ARGS = -983040;
  public static final int NO_MATCH_TOO_MANY_ARGS = -917504;
  static final Type[] unknownArgTypes = arrayOfType;
  protected Object argTypes;

  static
  {
    Type[] arrayOfType = new Type[1];
    arrayOfType[0] = Type.pointer_type;
  }

  public static RuntimeException matchFailAsException(int paramInt, Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    int i = (short)paramInt;
    if ((paramInt & 0xFFFF0000) != -786432)
      return new WrongArguments(paramProcedure, paramArrayOfObject.length);
    if (i > 0);
    for (Object localObject = paramArrayOfObject[(i - 1)]; ; localObject = null)
      return new WrongType(paramProcedure, i, localObject);
  }

  public static int mostSpecific(MethodProc[] paramArrayOfMethodProc, int paramInt)
  {
    if (paramInt <= 1)
      return paramInt - 1;
    Object localObject = paramArrayOfMethodProc[0];
    MethodProc[] arrayOfMethodProc = null;
    int i = 1;
    int j = 0;
    MethodProc localMethodProc1;
    MethodProc localMethodProc4;
    int m;
    if (i < paramInt)
    {
      localMethodProc1 = paramArrayOfMethodProc[i];
      if (localObject != null)
      {
        localMethodProc4 = mostSpecific((MethodProc)localObject, localMethodProc1);
        if (localMethodProc4 == null)
        {
          if (arrayOfMethodProc == null)
            arrayOfMethodProc = new MethodProc[paramInt];
          arrayOfMethodProc[0] = localObject;
          arrayOfMethodProc[1] = localMethodProc1;
          m = 2;
          localObject = null;
        }
      }
    }
    while (true)
    {
      i++;
      j = m;
      break;
      if (localMethodProc4 == localMethodProc1)
      {
        localObject = localMethodProc1;
        m = i;
        continue;
        for (int k = 0; ; k++)
        {
          if (k >= j)
            break label165;
          MethodProc localMethodProc2 = arrayOfMethodProc[k];
          MethodProc localMethodProc3 = mostSpecific(localMethodProc2, localMethodProc1);
          if (localMethodProc3 == localMethodProc2)
          {
            m = j;
            break;
          }
          if (localMethodProc3 == null)
          {
            m = j + 1;
            arrayOfMethodProc[j] = localMethodProc1;
            break;
          }
        }
        label165: localObject = localMethodProc1;
        m = i;
        continue;
        if (localObject == null)
          return -1;
        return j;
      }
      else
      {
        m = j;
      }
    }
  }

  public static MethodProc mostSpecific(MethodProc paramMethodProc1, MethodProc paramMethodProc2)
  {
    int i = paramMethodProc1.minArgs();
    int j = paramMethodProc2.minArgs();
    int k = paramMethodProc1.maxArgs();
    int m = paramMethodProc2.maxArgs();
    if (((k >= 0) && (k < j)) || ((m >= 0) && (m < i)))
      return null;
    int n = paramMethodProc1.numParameters();
    int i1 = paramMethodProc2.numParameters();
    int i2;
    label80: int i3;
    if (n > i1)
    {
      if (k == m)
        break label259;
      if (k >= 0)
        break label253;
      i2 = 1;
      if (m >= 0)
        break label247;
      i3 = 1;
    }
    while (true)
    {
      int i4;
      int i5;
      if (i < j)
      {
        i4 = i3;
        i5 = 1;
      }
      while (true)
      {
        label100: int i6 = i4;
        int i7 = i5;
        for (int i8 = 0; ; i8++)
        {
          if (i8 >= n)
            break label204;
          int i9 = paramMethodProc1.getParameterType(i8).compare(paramMethodProc2.getParameterType(i8));
          if (i9 == -1)
          {
            i6 = 1;
            if (i7 != 0)
            {
              return null;
              n = i1;
              break;
              if (i <= j)
                break label236;
              i4 = 1;
              i5 = i2;
              break label100;
            }
          }
          if (i9 == 1)
          {
            if (i6 != 0)
              return null;
            i7 = 1;
          }
        }
        label204: if (i6 != 0);
        while (true)
        {
          MethodProc localMethodProc = paramMethodProc1;
          return localMethodProc;
          if (i7 != 0)
            paramMethodProc1 = paramMethodProc2;
          else
            paramMethodProc1 = null;
        }
        label236: i4 = i3;
        i5 = i2;
      }
      label247: i3 = 0;
      continue;
      label253: i2 = 0;
      break label80;
      label259: i2 = 0;
      i3 = 0;
    }
  }

  public Object applyN(Object[] paramArrayOfObject)
    throws Throwable
  {
    checkArgCount(this, paramArrayOfObject.length);
    CallContext localCallContext = CallContext.getInstance();
    checkN(paramArrayOfObject, localCallContext);
    return localCallContext.runUntilValue();
  }

  public Type getParameterType(int paramInt)
  {
    if (!(this.argTypes instanceof Type[]))
      resolveParameterTypes();
    Type[] arrayOfType = (Type[])this.argTypes;
    if ((paramInt < arrayOfType.length) && ((paramInt < arrayOfType.length - 1) || (maxArgs() >= 0)))
      return arrayOfType[paramInt];
    if (maxArgs() < 0)
    {
      Type localType = arrayOfType[(arrayOfType.length - 1)];
      if ((localType instanceof ArrayType))
        return ((ArrayType)localType).getComponentType();
    }
    return Type.objectType;
  }

  public int isApplicable(Type[] paramArrayOfType)
  {
    int i = paramArrayOfType.length;
    int j = numArgs();
    if ((i < (j & 0xFFF)) || ((j >= 0) && (i > j >> 12)))
      return -1;
    int k = 1;
    int m = i;
    while (true)
    {
      m--;
      if (m < 0)
        break;
      int n = getParameterType(m).compare(paramArrayOfType[m]);
      if (n == -3)
        return -1;
      if (n < 0)
        k = 0;
    }
    return k;
  }

  public int numParameters()
  {
    int i = numArgs();
    int j = i >> 12;
    if (j >= 0)
      return j;
    return 1 + (i & 0xFFF);
  }

  protected void resolveParameterTypes()
  {
    this.argTypes = unknownArgTypes;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.MethodProc
 * JD-Core Version:    0.6.2
 */