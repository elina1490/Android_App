package gnu.bytecode;

public class UninitializedType extends ObjectType
{
  ClassType ctype;
  Label label;

  UninitializedType(ClassType paramClassType)
  {
    super(paramClassType.getName());
    setSignature(paramClassType.getSignature());
    this.ctype = paramClassType;
  }

  UninitializedType(ClassType paramClassType, Label paramLabel)
  {
    this(paramClassType);
    this.label = paramLabel;
  }

  static UninitializedType uninitializedThis(ClassType paramClassType)
  {
    return new UninitializedType(paramClassType);
  }

  public Type getImplementationType()
  {
    return this.ctype;
  }

  public String toString()
  {
    return "Uninitialized<" + this.ctype.getName() + '>';
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.UninitializedType
 * JD-Core Version:    0.6.2
 */