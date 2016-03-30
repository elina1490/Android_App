package gnu.kawa.xml;

public class XString
  implements CharSequence
{
  public String text;
  private XStringType type;

  XString(String paramString, XStringType paramXStringType)
  {
    this.text = paramString;
    this.type = paramXStringType;
  }

  public char charAt(int paramInt)
  {
    return this.text.charAt(paramInt);
  }

  public XStringType getStringType()
  {
    return this.type;
  }

  public int length()
  {
    return this.text.length();
  }

  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.text.substring(paramInt1, paramInt2);
  }

  public String toString()
  {
    return this.text;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.XString
 * JD-Core Version:    0.6.2
 */