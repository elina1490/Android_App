package gnu.bytecode;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class Variable extends Location
  implements Enumeration
{
  private static final int LIVE_FLAG = 4;
  private static final int PARAMETER_FLAG = 2;
  private static final int SIMPLE_FLAG = 1;
  static final int UNASSIGNED = -1;
  private int flags = 1;
  Variable next;
  int offset = -1;
  Scope scope;

  public Variable()
  {
  }

  public Variable(String paramString)
  {
    setName(paramString);
  }

  public Variable(String paramString, Type paramType)
  {
    setName(paramString);
    setType(paramType);
  }

  private void setFlag(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.flags = (paramInt | this.flags);
      return;
    }
    this.flags &= (paramInt ^ 0xFFFFFFFF);
  }

  public void allocateLocal(CodeAttr paramCodeAttr)
  {
    if (this.offset != -1);
    while (true)
    {
      return;
      for (int i = 0; !reserveLocal(i, paramCodeAttr); i++);
    }
  }

  public final boolean dead()
  {
    return (0x4 & this.flags) == 0;
  }

  public void freeLocal(CodeAttr paramCodeAttr)
  {
    this.flags = (0xFFFFFFFB & this.flags);
    if (getType().size > 4);
    for (int i = 2; ; i = 1)
    {
      int j = i + this.offset;
      while (true)
      {
        j--;
        if (j < this.offset)
          break;
        paramCodeAttr.locals.used[j] = null;
        Type[] arrayOfType = paramCodeAttr.local_types;
        if (arrayOfType != null)
          arrayOfType[j] = null;
      }
    }
  }

  public final boolean hasMoreElements()
  {
    return this.next != null;
  }

  public final boolean isAssigned()
  {
    return this.offset != -1;
  }

  public final boolean isParameter()
  {
    return (0x2 & this.flags) != 0;
  }

  public final boolean isSimple()
  {
    return (0x1 & this.flags) != 0;
  }

  public Object nextElement()
  {
    if (this.next == null)
      throw new NoSuchElementException("Variable enumeration");
    return this.next;
  }

  public final Variable nextVar()
  {
    return this.next;
  }

  public boolean reserveLocal(int paramInt, CodeAttr paramCodeAttr)
  {
    int i = getType().getSizeInWords();
    if (paramCodeAttr.locals.used == null)
      paramCodeAttr.locals.used = new Variable[i + 20];
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label128;
      if (paramCodeAttr.locals.used[(paramInt + j)] != null)
      {
        return false;
        if (i + paramCodeAttr.getMaxLocals() < paramCodeAttr.locals.used.length)
          break;
        Variable[] arrayOfVariable = new Variable[i + 2 * paramCodeAttr.locals.used.length];
        System.arraycopy(paramCodeAttr.locals.used, 0, arrayOfVariable, 0, paramCodeAttr.getMaxLocals());
        paramCodeAttr.locals.used = arrayOfVariable;
        break;
      }
    }
    label128: for (int k = 0; k < i; k++)
      paramCodeAttr.locals.used[(paramInt + k)] = this;
    if (paramInt + i > paramCodeAttr.getMaxLocals())
      paramCodeAttr.setMaxLocals(paramInt + i);
    this.offset = paramInt;
    this.flags = (0x4 | this.flags);
    if ((this.offset == 0) && ("<init>".equals(paramCodeAttr.getMethod().getName())))
      setType(paramCodeAttr.local_types[0]);
    return true;
  }

  public final void setParameter(boolean paramBoolean)
  {
    setFlag(paramBoolean, 2);
  }

  public final void setSimple(boolean paramBoolean)
  {
    setFlag(paramBoolean, 1);
  }

  boolean shouldEmit()
  {
    Scope localScope = this.scope;
    if ((isSimple()) && (this.name != null) && (localScope != null))
    {
      Label localLabel1 = localScope.start;
      if (localLabel1 != null)
      {
        int i = localLabel1.position;
        if (i >= 0)
        {
          Label localLabel2 = localScope.end;
          if ((localLabel2 != null) && (localLabel2.position > i))
            return true;
        }
      }
    }
    return false;
  }

  public String toString()
  {
    return "Variable[" + getName() + " offset:" + this.offset + ']';
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.Variable
 * JD-Core Version:    0.6.2
 */