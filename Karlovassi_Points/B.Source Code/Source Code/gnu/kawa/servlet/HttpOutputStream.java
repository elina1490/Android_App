package gnu.kawa.servlet;

import java.io.IOException;
import java.io.OutputStream;

class HttpOutputStream extends OutputStream
{
  byte[] buffer;
  HttpRequestContext context;
  int count;
  OutputStream out;

  public HttpOutputStream(HttpRequestContext paramHttpRequestContext, int paramInt)
  {
    this.context = paramHttpRequestContext;
    this.buffer = new byte[paramInt];
  }

  public void close()
    throws IOException
  {
    if (this.out == null)
    {
      maybeSendResponseHeaders(this.count);
      this.out = this.context.getResponseStream();
    }
    flush();
    this.out.close();
  }

  public void flush()
    throws IOException
  {
    if (this.out == null)
    {
      maybeSendResponseHeaders(-1);
      this.out = this.context.getResponseStream();
    }
    if (this.count > 0)
    {
      this.out.write(this.buffer, 0, this.count);
      this.count = 0;
    }
  }

  void maybeSendResponseHeaders(int paramInt)
    throws IOException
  {
    int i = this.context.statusCode;
    if (i != -999)
    {
      this.context.sendResponseHeaders(i, this.context.statusReasonPhrase, paramInt);
      this.context.statusCode = -999;
    }
  }

  public boolean reset()
  {
    this.count = 0;
    return this.out == null;
  }

  public void write(int paramInt)
    throws IOException
  {
    if (this.count >= this.buffer.length)
      flush();
    byte[] arrayOfByte = this.buffer;
    int i = this.count;
    this.count = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    for (int i = this.buffer.length - this.count; paramInt2 > i; i = this.buffer.length)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.count, i);
      this.count = (i + this.count);
      flush();
      paramInt1 += i;
      paramInt2 -= i;
    }
    if (paramInt2 > 0)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.count, paramInt2);
      this.count = (paramInt2 + this.count);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.servlet.HttpOutputStream
 * JD-Core Version:    0.6.2
 */