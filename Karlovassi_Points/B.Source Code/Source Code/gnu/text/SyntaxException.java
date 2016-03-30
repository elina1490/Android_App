package gnu.text;

import java.io.PrintWriter;

public class SyntaxException extends Exception
{
  String header;
  public int maxToPrint = 10;
  SourceMessages messages;

  public SyntaxException(SourceMessages paramSourceMessages)
  {
    this.messages = paramSourceMessages;
  }

  public SyntaxException(String paramString, SourceMessages paramSourceMessages)
  {
    this.header = paramString;
    this.messages = paramSourceMessages;
  }

  public void clear()
  {
    this.messages.clear();
  }

  public final String getHeader()
  {
    return this.header;
  }

  public String getMessage()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.header != null)
      localStringBuffer.append(this.header);
    int i = this.maxToPrint;
    for (SourceError localSourceError = this.messages.firstError; localSourceError != null; localSourceError = localSourceError.next)
    {
      i--;
      if (i < 0)
        break;
      localStringBuffer.append('\n');
      localStringBuffer.append(localSourceError);
    }
    return localStringBuffer.toString();
  }

  public SourceMessages getMessages()
  {
    return this.messages;
  }

  public void printAll(PrintWriter paramPrintWriter, int paramInt)
  {
    if (this.header != null)
      paramPrintWriter.println(this.header);
    this.messages.printAll(paramPrintWriter, paramInt);
  }

  public final void setHeader(String paramString)
  {
    this.header = paramString;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.SyntaxException
 * JD-Core Version:    0.6.2
 */