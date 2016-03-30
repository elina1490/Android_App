package gnu.kawa.servlet;

import gnu.kawa.xml.HttpPrinter;
import java.io.IOException;

public class ServletPrinter extends HttpPrinter
{
  HttpRequestContext hctx;

  public ServletPrinter(HttpRequestContext paramHttpRequestContext, int paramInt)
    throws IOException
  {
    super(new HttpOutputStream(paramHttpRequestContext, paramInt));
    this.hctx = paramHttpRequestContext;
  }

  public void addHeader(String paramString1, String paramString2)
  {
    if (paramString1.equalsIgnoreCase("Content-type"))
    {
      this.sawContentType = paramString2;
      this.hctx.setContentType(paramString2);
    }
    int j;
    int k;
    char c;
    while (true)
    {
      return;
      if (!paramString1.equalsIgnoreCase("Status"))
        break label136;
      int i = paramString2.length();
      j = 0;
      for (k = 0; k < i; k++)
      {
        if (k >= i)
        {
          this.hctx.statusCode = j;
          return;
        }
        c = paramString2.charAt(k);
        int m = Character.digit(c, 10);
        if (m < 0)
          break label103;
        j = m + j * 10;
      }
    }
    label103: if (c == ' ')
      k++;
    this.hctx.statusCode = j;
    this.hctx.statusReasonPhrase = paramString2.substring(k);
    return;
    label136: this.hctx.setResponseHeader(paramString1, paramString2);
  }

  public void printHeaders()
  {
  }

  public boolean reset(boolean paramBoolean)
  {
    return ((HttpOutputStream)this.ostream).reset() & super.reset(paramBoolean);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.servlet.ServletPrinter
 * JD-Core Version:    0.6.2
 */