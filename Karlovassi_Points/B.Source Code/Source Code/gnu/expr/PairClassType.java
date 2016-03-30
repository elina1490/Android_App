package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;

public class PairClassType extends ClassType
{
  public ClassType instanceType;
  Object staticLink;

  public PairClassType()
  {
  }

  PairClassType(Class paramClass1, Class paramClass2)
  {
    super(paramClass1.getName());
    setExisting(true);
    this.reflectClass = paramClass1;
    Type.registerTypeForClass(paramClass1, this);
    this.instanceType = ((ClassType)Type.make(paramClass2));
  }

  public static Object extractStaticLink(ClassType paramClassType)
  {
    return ((PairClassType)paramClassType).staticLink;
  }

  public static PairClassType make(Class paramClass1, Class paramClass2)
  {
    return new PairClassType(paramClass1, paramClass2);
  }

  public static PairClassType make(Class paramClass1, Class paramClass2, Object paramObject)
  {
    PairClassType localPairClassType = new PairClassType(paramClass1, paramClass2);
    localPairClassType.staticLink = paramObject;
    return localPairClassType;
  }

  public Object getStaticLink()
  {
    return this.staticLink;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.PairClassType
 * JD-Core Version:    0.6.2
 */