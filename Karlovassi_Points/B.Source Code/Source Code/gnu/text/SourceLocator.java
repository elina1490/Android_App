package gnu.text;

import org.xml.sax.Locator;

public abstract interface SourceLocator extends Locator
{
  public abstract int getColumnNumber();

  public abstract String getFileName();

  public abstract int getLineNumber();

  public abstract String getPublicId();

  public abstract String getSystemId();

  public abstract boolean isStableSourceLocation();
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.SourceLocator
 * JD-Core Version:    0.6.2
 */