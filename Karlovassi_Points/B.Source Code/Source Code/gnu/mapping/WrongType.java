package gnu.mapping;

import gnu.bytecode.Type;

public class WrongType extends WrappedException
{
  public static final int ARG_CAST = -4;
  public static final int ARG_DESCRIPTION = -3;
  public static final int ARG_UNKNOWN = -1;
  public static final int ARG_VARNAME = -2;
  public Object argValue;
  public Object expectedType;
  public int number;
  public Procedure proc;
  public String procname;

  public WrongType(int paramInt, Object paramObject, Type paramType)
  {
    this.number = paramInt;
    this.argValue = paramObject;
    this.expectedType = paramType;
  }

  public WrongType(Procedure paramProcedure, int paramInt, ClassCastException paramClassCastException)
  {
    super(paramClassCastException);
    this.proc = paramProcedure;
    this.procname = paramProcedure.getName();
    this.number = paramInt;
  }

  public WrongType(Procedure paramProcedure, int paramInt, Object paramObject)
  {
    this.proc = paramProcedure;
    this.procname = paramProcedure.getName();
    this.number = paramInt;
    this.argValue = paramObject;
  }

  public WrongType(Procedure paramProcedure, int paramInt, Object paramObject, Type paramType)
  {
    this.proc = paramProcedure;
    this.procname = paramProcedure.getName();
    this.number = paramInt;
    this.argValue = paramObject;
    this.expectedType = paramType;
  }

  public WrongType(Procedure paramProcedure, int paramInt, Object paramObject, String paramString)
  {
    this(paramProcedure.getName(), paramInt, paramObject, paramString);
    this.proc = paramProcedure;
  }

  public WrongType(ClassCastException paramClassCastException, Procedure paramProcedure, int paramInt, Object paramObject)
  {
    this(paramProcedure, paramInt, paramClassCastException);
    this.argValue = paramObject;
  }

  public WrongType(ClassCastException paramClassCastException, String paramString, int paramInt, Object paramObject)
  {
    this(paramString, paramInt, paramClassCastException);
    this.argValue = paramObject;
  }

  public WrongType(String paramString, int paramInt, ClassCastException paramClassCastException)
  {
    super(paramClassCastException);
    this.procname = paramString;
    this.number = paramInt;
  }

  public WrongType(String paramString1, int paramInt, Object paramObject, String paramString2)
  {
    this.procname = paramString1;
    this.number = paramInt;
    this.argValue = paramObject;
    this.expectedType = paramString2;
  }

  public WrongType(String paramString1, int paramInt, String paramString2)
  {
    super(null, null);
    this.procname = paramString1;
    this.number = paramInt;
    this.expectedType = paramString2;
  }

  public static WrongType make(ClassCastException paramClassCastException, Procedure paramProcedure, int paramInt)
  {
    return new WrongType(paramProcedure, paramInt, paramClassCastException);
  }

  public static WrongType make(ClassCastException paramClassCastException, Procedure paramProcedure, int paramInt, Object paramObject)
  {
    WrongType localWrongType = new WrongType(paramProcedure, paramInt, paramClassCastException);
    localWrongType.argValue = paramObject;
    return localWrongType;
  }

  public static WrongType make(ClassCastException paramClassCastException, String paramString, int paramInt)
  {
    return new WrongType(paramString, paramInt, paramClassCastException);
  }

  public static WrongType make(ClassCastException paramClassCastException, String paramString, int paramInt, Object paramObject)
  {
    WrongType localWrongType = new WrongType(paramString, paramInt, paramClassCastException);
    localWrongType.argValue = paramObject;
    return localWrongType;
  }

  public String getMessage()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    String str3;
    label81: String str2;
    label117: Object localObject1;
    Object localObject2;
    if (this.number == -3)
    {
      localStringBuffer.append(this.procname);
      if (this.argValue != null)
      {
        localStringBuffer.append(" (");
        str3 = this.argValue.toString();
        if (str3.length() <= 50)
          break label391;
        localStringBuffer.append(str3.substring(0, 47));
        localStringBuffer.append("...");
        localStringBuffer.append(")");
      }
      if ((this.procname != null) && (this.number != -3))
      {
        if (this.number != -2)
          break label401;
        str2 = " for variable '";
        localStringBuffer.append(str2);
        localStringBuffer.append(this.procname);
        localStringBuffer.append("'");
      }
      localStringBuffer.append(" has wrong type");
      if (this.argValue != null)
      {
        localStringBuffer.append(" (");
        localStringBuffer.append(this.argValue.getClass().getName());
        localStringBuffer.append(")");
      }
      localObject1 = this.expectedType;
      if ((localObject1 == null) && (this.number > 0) && ((this.proc instanceof MethodProc)))
        localObject1 = ((MethodProc)this.proc).getParameterType(this.number - 1);
      if ((localObject1 != null) && (localObject1 != Type.pointer_type))
      {
        localStringBuffer.append(" (expected: ");
        if (!(localObject1 instanceof Type))
          break label408;
        localObject2 = ((Type)localObject1).getName();
      }
    }
    while (true)
    {
      localStringBuffer.append(localObject2);
      localStringBuffer.append(")");
      Throwable localThrowable = getCause();
      if (localThrowable != null)
      {
        String str1 = localThrowable.getMessage();
        if (str1 != null)
        {
          localStringBuffer.append(" (");
          localStringBuffer.append(str1);
          localStringBuffer.append(')');
        }
      }
      return localStringBuffer.toString();
      if ((this.number == -4) || (this.number == -2))
      {
        localStringBuffer.append("Value");
        break;
      }
      localStringBuffer.append("Argument ");
      if (this.number <= 0)
        break;
      localStringBuffer.append('#');
      localStringBuffer.append(this.number);
      break;
      label391: localStringBuffer.append(str3);
      break label81;
      label401: str2 = " to '";
      break label117;
      label408: if ((localObject1 instanceof Class))
        localObject2 = ((Class)localObject1).getName();
      else
        localObject2 = localObject1;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.WrongType
 * JD-Core Version:    0.6.2
 */