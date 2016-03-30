package gnu.text;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class LineInputStreamReader extends LineBufferedReader
{
  byte[] barr = new byte[8192];
  ByteBuffer bbuf = ByteBuffer.wrap(this.barr);
  char[] carr;
  CharBuffer cbuf = null;
  Charset cset;
  CharsetDecoder decoder;
  InputStream istrm;

  public LineInputStreamReader(InputStream paramInputStream)
  {
    super((Reader)null);
    this.bbuf.position(this.barr.length);
    this.istrm = paramInputStream;
  }

  private int fillBytes(int paramInt)
    throws IOException
  {
    int i = this.istrm.read(this.barr, paramInt, this.barr.length - paramInt);
    this.bbuf.position(0);
    ByteBuffer localByteBuffer = this.bbuf;
    if (i < 0);
    for (int j = 0; ; j = i)
    {
      localByteBuffer.limit(j + paramInt);
      return i;
    }
  }

  public void close()
    throws IOException
  {
    if (this.in != null)
      this.in.close();
    this.istrm.close();
  }

  public int fill(int paramInt)
    throws IOException
  {
    if (this.cset == null)
      setCharset("UTF-8");
    if (this.buffer != this.carr)
    {
      this.cbuf = CharBuffer.wrap(this.buffer);
      this.carr = this.buffer;
    }
    this.cbuf.limit(paramInt + this.pos);
    this.cbuf.position(this.pos);
    CoderResult localCoderResult = this.decoder.decode(this.bbuf, this.cbuf, false);
    int i = this.cbuf.position() - this.pos;
    int j = 0;
    if (i <= 0)
    {
      boolean bool = localCoderResult.isUnderflow();
      j = 0;
      if (bool)
        break label136;
    }
    while (true)
    {
      if ((i != 0) || (j == 0))
        break label173;
      return -1;
      label136: int k = this.bbuf.remaining();
      if (k > 0)
        this.bbuf.compact();
      if (fillBytes(k) >= 0)
        break;
      j = 1;
    }
    label173: return i;
  }

  public int getByte()
    throws IOException
  {
    if ((!this.bbuf.hasRemaining()) && (fillBytes(0) <= 0))
      return -1;
    return 0xFF & this.bbuf.get();
  }

  public void markStart()
    throws IOException
  {
  }

  public boolean ready()
    throws IOException
  {
    return (this.pos < this.limit) || (this.bbuf.hasRemaining()) || (this.istrm.available() > 0);
  }

  public void resetStart(int paramInt)
    throws IOException
  {
    this.bbuf.position(paramInt);
  }

  public void setCharset(String paramString)
  {
    Charset localCharset = Charset.forName(paramString);
    if (this.cset == null)
      setCharset(localCharset);
    while (localCharset.equals(this.cset))
      return;
    throw new RuntimeException("encoding " + paramString + " does not match previous " + this.cset);
  }

  public void setCharset(Charset paramCharset)
  {
    this.cset = paramCharset;
    this.decoder = paramCharset.newDecoder();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.LineInputStreamReader
 * JD-Core Version:    0.6.2
 */