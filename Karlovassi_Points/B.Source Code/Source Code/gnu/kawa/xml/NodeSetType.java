package gnu.kawa.xml;

import gnu.bytecode.Type;
import gnu.kawa.reflect.OccurrenceType;

public class NodeSetType extends OccurrenceType
{
  public NodeSetType(Type paramType)
  {
    super(paramType, 0, -1);
  }

  public static Type getInstance(Type paramType)
  {
    return new NodeSetType(paramType);
  }

  public String toString()
  {
    return super.toString() + "node-set";
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.NodeSetType
 * JD-Core Version:    0.6.2
 */