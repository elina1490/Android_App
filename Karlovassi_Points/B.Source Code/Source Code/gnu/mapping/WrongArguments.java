package gnu.mapping;

public class WrongArguments extends IllegalArgumentException
{
  public int number;
  Procedure proc;
  public String procname;
  public String usage;

  public WrongArguments(Procedure paramProcedure, int paramInt)
  {
    this.proc = paramProcedure;
    this.number = paramInt;
  }

  public WrongArguments(String paramString1, int paramInt, String paramString2)
  {
    this.procname = paramString1;
    this.number = paramInt;
    this.usage = paramString2;
  }

  public static String checkArgCount(Procedure paramProcedure, int paramInt)
  {
    int i = paramProcedure.numArgs();
    int j = i & 0xFFF;
    int k = i >> 12;
    String str = paramProcedure.getName();
    if (str == null)
      str = paramProcedure.getClass().getName();
    return checkArgCount(str, j, k, paramInt);
  }

  public static String checkArgCount(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    StringBuffer localStringBuffer;
    label39: String str;
    if (paramInt3 < paramInt1)
    {
      i = 0;
      localStringBuffer = new StringBuffer(100);
      localStringBuffer.append("call to ");
      if (paramString != null)
        break label122;
      localStringBuffer.append("unnamed procedure");
      if (i == 0)
        break label148;
      str = " has too many";
      label48: localStringBuffer.append(str);
      localStringBuffer.append(" arguments (");
      localStringBuffer.append(paramInt3);
      if (paramInt1 != paramInt2)
        break label155;
      localStringBuffer.append("; must be ");
      localStringBuffer.append(paramInt1);
    }
    while (true)
    {
      localStringBuffer.append(')');
      return localStringBuffer.toString();
      if ((paramInt2 >= 0) && (paramInt3 > paramInt2))
      {
        i = 1;
        break;
      }
      return null;
      label122: localStringBuffer.append('\'');
      localStringBuffer.append(paramString);
      localStringBuffer.append('\'');
      break label39;
      label148: str = " has too few";
      break label48;
      label155: localStringBuffer.append("; min=");
      localStringBuffer.append(paramInt1);
      if (paramInt2 >= 0)
      {
        localStringBuffer.append(", max=");
        localStringBuffer.append(paramInt2);
      }
    }
  }

  public String getMessage()
  {
    if (this.proc != null)
    {
      String str = checkArgCount(this.proc, this.number);
      if (str != null)
        return str;
    }
    return super.getMessage();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.WrongArguments
 * JD-Core Version:    0.6.2
 */