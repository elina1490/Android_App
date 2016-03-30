package kawa;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TelnetOutputStream extends FilterOutputStream
{
  public TelnetOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public void write(int paramInt)
    throws IOException
  {
    if (paramInt == 255)
      this.out.write(paramInt);
    this.out.write(paramInt);
  }

  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = paramInt1 + paramInt2;
    for (int j = paramInt1; j < i; j++)
      if (paramArrayOfByte[j] == -1)
      {
        this.out.write(paramArrayOfByte, paramInt1, j + 1 - paramInt1);
        paramInt1 = j;
      }
    this.out.write(paramArrayOfByte, paramInt1, i - paramInt1);
  }

  public void writeCommand(int paramInt)
    throws IOException
  {
    this.out.write(255);
    this.out.write(paramInt);
  }

  public final void writeCommand(int paramInt1, int paramInt2)
    throws IOException
  {
    this.out.write(255);
    this.out.write(paramInt1);
    this.out.write(paramInt2);
  }

  public final void writeDo(int paramInt)
    throws IOException
  {
    writeCommand(253, paramInt);
  }

  public final void writeDont(int paramInt)
    throws IOException
  {
    writeCommand(254, paramInt);
  }

  public final void writeSubCommand(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    writeCommand(250, paramInt);
    write(paramArrayOfByte);
    writeCommand(240);
  }

  public final void writeWill(int paramInt)
    throws IOException
  {
    writeCommand(251, paramInt);
  }

  public final void writeWont(int paramInt)
    throws IOException
  {
    writeCommand(252, paramInt);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.TelnetOutputStream
 * JD-Core Version:    0.6.2
 */