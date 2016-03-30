package gnu.kawa.xml;

import gnu.mapping.Symbol;

public class Notation
{
  Symbol qname;

  public boolean equals(Notation paramNotation1, Notation paramNotation2)
  {
    return paramNotation1.qname.equals(paramNotation2.qname);
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Notation)) && (equals(this, (Notation)paramObject));
  }

  public int hashCode()
  {
    return this.qname.hashCode();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.Notation
 * JD-Core Version:    0.6.2
 */