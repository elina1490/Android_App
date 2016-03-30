package gnu.bytecode;

public abstract interface Member
{
  public abstract ClassType getDeclaringClass();

  public abstract int getModifiers();

  public abstract String getName();

  public abstract boolean getStaticFlag();

  public abstract void setName(String paramString);
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.Member
 * JD-Core Version:    0.6.2
 */