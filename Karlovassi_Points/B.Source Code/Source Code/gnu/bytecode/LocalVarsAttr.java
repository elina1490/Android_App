package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class LocalVarsAttr extends Attribute
{
  public Scope current_scope;
  private Method method;
  Scope parameter_scope;
  Variable[] used;

  public LocalVarsAttr(CodeAttr paramCodeAttr)
  {
    super("LocalVariableTable");
    addToFrontOf(paramCodeAttr);
    this.method = ((Method)paramCodeAttr.getContainer());
    paramCodeAttr.locals = this;
  }

  public LocalVarsAttr(Method paramMethod)
  {
    super("LocalVariableTable");
    CodeAttr localCodeAttr = paramMethod.code;
    this.method = paramMethod;
    localCodeAttr.locals = this;
  }

  public VarEnumerator allVars()
  {
    return new VarEnumerator(this.parameter_scope);
  }

  public void assignConstants(ClassType paramClassType)
  {
    super.assignConstants(paramClassType);
    VarEnumerator localVarEnumerator = allVars();
    while (true)
    {
      Variable localVariable = localVarEnumerator.nextVar();
      if (localVariable == null)
        break;
      if ((localVariable.isSimple()) && (localVariable.name != null))
      {
        if (localVariable.name_index == 0)
          localVariable.name_index = paramClassType.getConstants().addUtf8(localVariable.getName()).index;
        if (localVariable.signature_index == 0)
          localVariable.signature_index = paramClassType.getConstants().addUtf8(localVariable.getType().getSignature()).index;
      }
    }
  }

  public void enterScope(Scope paramScope)
  {
    paramScope.linkChild(this.current_scope);
    this.current_scope = paramScope;
    CodeAttr localCodeAttr = this.method.getCode();
    Variable localVariable = paramScope.firstVar();
    if (localVariable != null)
    {
      if (localVariable.isSimple())
      {
        if (localVariable.isAssigned())
          break label57;
        localVariable.allocateLocal(localCodeAttr);
      }
      label57: label82: 
      do
        while (true)
        {
          localVariable = localVariable.nextVar();
          break;
          if (this.used[localVariable.offset] != null)
            break label82;
          this.used[localVariable.offset] = localVariable;
        }
      while (this.used[localVariable.offset] == localVariable);
      throw new Error("inconsistent local variable assignments for " + localVariable + " != " + this.used[localVariable.offset]);
    }
  }

  public final int getCount()
  {
    int i = 0;
    VarEnumerator localVarEnumerator = allVars();
    while (true)
    {
      Variable localVariable = localVarEnumerator.nextVar();
      if (localVariable == null)
        break;
      if (localVariable.shouldEmit())
        i++;
    }
    return i;
  }

  public final int getLength()
  {
    return 2 + 10 * getCount();
  }

  public final Method getMethod()
  {
    return this.method;
  }

  public final boolean isEmpty()
  {
    VarEnumerator localVarEnumerator = allVars();
    Variable localVariable;
    do
    {
      localVariable = localVarEnumerator.nextVar();
      if (localVariable == null)
        break;
    }
    while ((!localVariable.isSimple()) || (localVariable.name == null));
    return false;
    return true;
  }

  public void preserveVariablesUpto(Scope paramScope)
  {
    for (Scope localScope = this.current_scope; localScope != paramScope; localScope = localScope.parent)
      localScope.preserved = true;
  }

  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    VarEnumerator localVarEnumerator = allVars();
    paramClassTypeWriter.print("Attribute \"");
    paramClassTypeWriter.print(getName());
    paramClassTypeWriter.print("\", length:");
    paramClassTypeWriter.print(getLength());
    paramClassTypeWriter.print(", count: ");
    paramClassTypeWriter.println(getCount());
    localVarEnumerator.reset();
    Variable localVariable;
    do
    {
      localVariable = localVarEnumerator.nextVar();
      if (localVariable == null)
        break;
    }
    while ((!localVariable.isSimple()) || (localVariable.name == null));
    paramClassTypeWriter.print("  slot#");
    paramClassTypeWriter.print(localVariable.offset);
    paramClassTypeWriter.print(": name: ");
    paramClassTypeWriter.printOptionalIndex(localVariable.name_index);
    paramClassTypeWriter.print(localVariable.getName());
    paramClassTypeWriter.print(", type: ");
    paramClassTypeWriter.printOptionalIndex(localVariable.signature_index);
    paramClassTypeWriter.printSignature(localVariable.getType());
    paramClassTypeWriter.print(" (pc: ");
    Scope localScope = localVariable.scope;
    int i;
    int j;
    if ((localScope != null) && (localScope.start != null) && (localScope.end != null))
    {
      i = localScope.start.position;
      if (i >= 0)
      {
        j = localScope.end.position;
        if (j >= 0)
          break label210;
      }
    }
    paramClassTypeWriter.print("unknown");
    while (true)
    {
      paramClassTypeWriter.println(')');
      break;
      label210: paramClassTypeWriter.print(i);
      paramClassTypeWriter.print(" length: ");
      paramClassTypeWriter.print(j - i);
    }
  }

  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    VarEnumerator localVarEnumerator = allVars();
    paramDataOutputStream.writeShort(getCount());
    localVarEnumerator.reset();
    while (true)
    {
      Variable localVariable = localVarEnumerator.nextVar();
      if (localVariable == null)
        break;
      if (localVariable.shouldEmit())
      {
        Scope localScope = localVariable.scope;
        int i = localScope.start.position;
        int j = localScope.end.position;
        paramDataOutputStream.writeShort(i);
        paramDataOutputStream.writeShort(j - i);
        paramDataOutputStream.writeShort(localVariable.name_index);
        paramDataOutputStream.writeShort(localVariable.signature_index);
        paramDataOutputStream.writeShort(localVariable.offset);
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.LocalVarsAttr
 * JD-Core Version:    0.6.2
 */