package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public abstract class TreeScanner extends MethodProc
  implements Externalizable
{
  public NodePredicate type;

  TreeScanner()
  {
    setProperty(Procedure.validateApplyKey, "gnu.kawa.xml.CompileXmlFunctions:validateApplyTreeScanner");
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    PositionConsumer localPositionConsumer = (PositionConsumer)paramCallContext.consumer;
    Object localObject = paramCallContext.getNextArg();
    paramCallContext.lastArg();
    try
    {
      KNode localKNode = (KNode)localObject;
      scan(localKNode.sequence, localKNode.getPos(), localPositionConsumer);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
    }
    throw new WrongType(getDesc(), -4, localObject, "node()");
  }

  public String getDesc()
  {
    String str = getClass().getName();
    int i = str.lastIndexOf('.');
    if (i > 0)
      str = str.substring(i + 1);
    return str + "::" + this.type;
  }

  public NodePredicate getNodePredicate()
  {
    return this.type;
  }

  public int numArgs()
  {
    return 4097;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.type = ((NodePredicate)paramObjectInput.readObject());
  }

  public abstract void scan(AbstractSequence paramAbstractSequence, int paramInt, PositionConsumer paramPositionConsumer);

  public String toString()
  {
    return "#<" + getClass().getName() + ' ' + this.type + '>';
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.type);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.TreeScanner
 * JD-Core Version:    0.6.2
 */