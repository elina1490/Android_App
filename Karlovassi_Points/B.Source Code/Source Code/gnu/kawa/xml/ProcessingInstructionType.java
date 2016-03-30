package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.TypeValue;
import gnu.lists.AbstractSequence;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ProcessingInstructionType extends NodeType
  implements TypeValue, Externalizable
{
  static final Method coerceMethod = typeProcessingInstructionType.getDeclaredMethod("coerce", 2);
  static final Method coerceOrNullMethod = typeProcessingInstructionType.getDeclaredMethod("coerceOrNull", 2);
  public static final ProcessingInstructionType piNodeTest = new ProcessingInstructionType(null);
  public static final ClassType typeProcessingInstructionType = ClassType.make("gnu.kawa.xml.ProcessingInstructionType");
  String target;

  public ProcessingInstructionType(String paramString)
  {
  }

  public static KProcessingInstruction coerce(Object paramObject, String paramString)
  {
    KProcessingInstruction localKProcessingInstruction = coerceOrNull(paramObject, paramString);
    if (localKProcessingInstruction == null)
      throw new ClassCastException();
    return localKProcessingInstruction;
  }

  public static KProcessingInstruction coerceOrNull(Object paramObject, String paramString)
  {
    KProcessingInstruction localKProcessingInstruction = (KProcessingInstruction)NodeType.coerceOrNull(paramObject, 32);
    if ((localKProcessingInstruction != null) && ((paramString == null) || (paramString.equals(localKProcessingInstruction.getTarget()))))
      return localKProcessingInstruction;
    return null;
  }

  public static ProcessingInstructionType getInstance(String paramString)
  {
    if (paramString == null)
      return piNodeTest;
    return new ProcessingInstructionType(paramString);
  }

  public Object coerceFromObject(Object paramObject)
  {
    return coerce(paramObject, this.target);
  }

  public void emitCoerceFromObject(CodeAttr paramCodeAttr)
  {
    paramCodeAttr.emitPushString(this.target);
    paramCodeAttr.emitInvokeStatic(coerceMethod);
  }

  protected void emitCoerceOrNullMethod(Variable paramVariable, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (paramVariable != null)
      localCodeAttr.emitLoad(paramVariable);
    localCodeAttr.emitPushString(this.target);
    localCodeAttr.emitInvokeStatic(coerceOrNullMethod);
  }

  public Type getImplementationType()
  {
    return ClassType.make("gnu.kawa.xml.KProcessingInstruction");
  }

  public boolean isInstance(Object paramObject)
  {
    return coerceOrNull(paramObject, this.target) != null;
  }

  public boolean isInstancePos(AbstractSequence paramAbstractSequence, int paramInt)
  {
    int i = paramAbstractSequence.getNextKind(paramInt);
    if (i == 37)
      return (this.target == null) || (this.target.equals(paramAbstractSequence.getNextTypeObject(paramInt)));
    if (i == 32)
      return isInstance(paramAbstractSequence.getPosNext(paramInt));
    return false;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.target = ((String)paramObjectInput.readObject());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ProcessingInstructionType ");
    if (this.target == null);
    for (String str = "*"; ; str = this.target)
      return str;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.target);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.ProcessingInstructionType
 * JD-Core Version:    0.6.2
 */