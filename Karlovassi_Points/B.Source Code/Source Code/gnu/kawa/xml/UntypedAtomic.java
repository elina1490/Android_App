package gnu.kawa.xml;

public class UntypedAtomic
{
  String text;

  public UntypedAtomic(String paramString)
  {
    this.text = paramString;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof UntypedAtomic)) && (this.text.equals(((UntypedAtomic)paramObject).text));
  }

  public int hashCode()
  {
    return this.text.hashCode();
  }

  public String toString()
  {
    return this.text;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.UntypedAtomic
 * JD-Core Version:    0.6.2
 */