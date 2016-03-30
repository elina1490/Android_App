package gnu.kawa.slib;

public class condition$Mntype
{
  public Object all$Mnfields;
  public Object fields;
  public Object name;
  public Object supertype;

  public condition$Mntype(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    this.name = paramObject1;
    this.supertype = paramObject2;
    this.fields = paramObject3;
    this.all$Mnfields = paramObject4;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("#<condition-type ");
    localStringBuffer.append(this.name);
    localStringBuffer.append(">");
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.slib.condition.Mntype
 * JD-Core Version:    0.6.2
 */