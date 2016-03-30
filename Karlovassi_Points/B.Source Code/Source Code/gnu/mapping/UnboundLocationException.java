package gnu.mapping;

import gnu.text.SourceLocator;

public class UnboundLocationException extends RuntimeException
{
  int column;
  String filename;
  int line;
  Location location;
  public Object symbol;

  public UnboundLocationException()
  {
  }

  public UnboundLocationException(Location paramLocation)
  {
    this.location = paramLocation;
  }

  public UnboundLocationException(Object paramObject)
  {
    this.symbol = paramObject;
  }

  public UnboundLocationException(Object paramObject, SourceLocator paramSourceLocator)
  {
    this.symbol = paramObject;
    if (paramSourceLocator != null)
    {
      this.filename = paramSourceLocator.getFileName();
      this.line = paramSourceLocator.getLineNumber();
      this.column = paramSourceLocator.getColumnNumber();
    }
  }

  public UnboundLocationException(Object paramObject, String paramString)
  {
    super(paramString);
    this.symbol = paramObject;
  }

  public UnboundLocationException(Object paramObject, String paramString, int paramInt1, int paramInt2)
  {
    this.symbol = paramObject;
    this.filename = paramString;
    this.line = paramInt1;
    this.column = paramInt2;
  }

  public String getMessage()
  {
    String str = super.getMessage();
    if (str != null)
      return str;
    StringBuffer localStringBuffer = new StringBuffer();
    if ((this.filename != null) || (this.line > 0))
    {
      if (this.filename != null)
        localStringBuffer.append(this.filename);
      if (this.line >= 0)
      {
        localStringBuffer.append(':');
        localStringBuffer.append(this.line);
        if (this.column > 0)
        {
          localStringBuffer.append(':');
          localStringBuffer.append(this.column);
        }
      }
      localStringBuffer.append(": ");
    }
    Object localObject1;
    if (this.location == null)
    {
      localObject1 = null;
      if (localObject1 == null)
        break label183;
      localStringBuffer.append("unbound location ");
      localStringBuffer.append(localObject1);
      Object localObject2 = this.location.getKeyProperty();
      if (localObject2 != null)
      {
        localStringBuffer.append(" (property ");
        localStringBuffer.append(localObject2);
        localStringBuffer.append(')');
      }
    }
    while (true)
    {
      return localStringBuffer.toString();
      localObject1 = this.location.getKeySymbol();
      break;
      label183: if (this.symbol != null)
      {
        localStringBuffer.append("unbound location ");
        localStringBuffer.append(this.symbol);
      }
      else
      {
        localStringBuffer.append("unbound location");
      }
    }
  }

  public void setLine(String paramString, int paramInt1, int paramInt2)
  {
    this.filename = paramString;
    this.line = paramInt1;
    this.column = paramInt2;
  }

  public String toString()
  {
    return getMessage();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.UnboundLocationException
 * JD-Core Version:    0.6.2
 */