package kawa;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class TelnetInputStream extends FilterInputStream
{
  static final int SB_IAC = 400;
  protected byte[] buf = new byte[512];
  Telnet connection;
  int count;
  int pos;
  int state = 0;
  int subCommandLength = 0;

  public TelnetInputStream(InputStream paramInputStream, Telnet paramTelnet)
    throws IOException
  {
    super(paramInputStream);
    this.connection = paramTelnet;
  }

  public int read()
    throws IOException
  {
    while (true)
    {
      if (this.pos >= this.count)
      {
        int n = this.in.available();
        if (n <= 0)
          n = 1;
        while (true)
        {
          int i1 = this.in.read(this.buf, this.subCommandLength, n);
          this.pos = this.subCommandLength;
          this.count = i1;
          if (i1 > 0)
            break;
          return -1;
          if (n > this.buf.length - this.subCommandLength)
            n = this.buf.length - this.subCommandLength;
        }
      }
      byte[] arrayOfByte1 = this.buf;
      int i = this.pos;
      this.pos = (i + 1);
      int j = 0xFF & arrayOfByte1[i];
      if (this.state == 0)
      {
        if (j != 255)
          return j;
        this.state = 255;
      }
      else if (this.state == 255)
      {
        if (j == 255)
        {
          this.state = 0;
          return 255;
        }
        if ((j == 251) || (j == 252) || (j == 253) || (j == 254) || (j == 250))
        {
          this.state = j;
        }
        else if (j == 244)
        {
          System.err.println("Interrupt Process");
          this.state = 0;
        }
        else
        {
          if (j == 236)
            return -1;
          this.state = 0;
        }
      }
      else if ((this.state == 251) || (this.state == 252) || (this.state == 253) || (this.state == 254))
      {
        this.connection.handle(this.state, j);
        this.state = 0;
      }
      else if (this.state == 250)
      {
        if (j == 255)
        {
          this.state = 400;
        }
        else
        {
          byte[] arrayOfByte3 = this.buf;
          int m = this.subCommandLength;
          this.subCommandLength = (m + 1);
          arrayOfByte3[m] = ((byte)j);
        }
      }
      else if (this.state == 400)
      {
        if (j == 255)
        {
          byte[] arrayOfByte2 = this.buf;
          int k = this.subCommandLength;
          this.subCommandLength = (k + 1);
          arrayOfByte2[k] = ((byte)j);
          this.state = 250;
        }
        else if (j == 240)
        {
          this.connection.subCommand(this.buf, 0, this.subCommandLength);
          this.state = 0;
          this.subCommandLength = 0;
        }
        else
        {
          this.state = 0;
          this.subCommandLength = 0;
        }
      }
      else
      {
        System.err.println("Bad state " + this.state);
      }
    }
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 <= 0)
      return 0;
    int k;
    if (this.state == 0)
    {
      int i1 = this.pos;
      int i2 = this.count;
      k = 0;
      if (i1 < i2);
    }
    else
    {
      int i = read();
      if (i < 0)
        return i;
      int j = paramInt1 + 1;
      paramArrayOfByte[paramInt1] = ((byte)i);
      k = 0 + 1;
      paramInt1 = j;
    }
    if (this.state == 0);
    while (true)
    {
      int m;
      if ((this.pos < this.count) && (k < paramInt2))
      {
        m = this.buf[this.pos];
        if (m != -1);
      }
      else
      {
        return k;
      }
      int n = paramInt1 + 1;
      paramArrayOfByte[paramInt1] = m;
      k++;
      this.pos = (1 + this.pos);
      paramInt1 = n;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.TelnetInputStream
 * JD-Core Version:    0.6.2
 */