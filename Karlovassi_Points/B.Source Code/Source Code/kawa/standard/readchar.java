package kawa.standard;

import gnu.lists.Sequence;
import gnu.mapping.InPort;
import gnu.mapping.Procedure0or1;
import gnu.mapping.WrongType;
import gnu.text.Char;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class readchar extends Procedure0or1
{
  public static final readchar peekChar = new readchar(true);
  public static final readchar readChar = new readchar(false);
  boolean peeking;

  public readchar(boolean paramBoolean)
  {
  }

  public final Object apply0()
  {
    return readChar(InPort.inDefault());
  }

  public final Object apply1(Object paramObject)
  {
    if ((paramObject instanceof InPort))
      return readChar((InPort)paramObject);
    if ((paramObject instanceof Reader))
      return readChar((Reader)paramObject);
    if ((paramObject instanceof InputStream))
      return readChar((InputStream)paramObject);
    throw new WrongType(this, 1, paramObject, "<input-port>");
  }

  final Object readChar(InPort paramInPort)
  {
    try
    {
      if (this.peeking);
      for (int i = paramInPort.peek(); i < 0; i = paramInPort.read())
        return Sequence.eofValue;
      Char localChar = Char.make(i);
      return localChar;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException("IO Exception caught");
  }

  final Object readChar(InputStream paramInputStream)
  {
    try
    {
      int i;
      if (this.peeking)
      {
        paramInputStream.mark(1);
        i = paramInputStream.read();
        paramInputStream.reset();
      }
      while (i < 0)
      {
        return Sequence.eofValue;
        i = paramInputStream.read();
      }
      Char localChar = Char.make(i);
      return localChar;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException("IO Exception caught");
  }

  final Object readChar(Reader paramReader)
  {
    try
    {
      int i;
      if (this.peeking)
      {
        paramReader.mark(1);
        i = paramReader.read();
        paramReader.reset();
      }
      while (i < 0)
      {
        return Sequence.eofValue;
        i = paramReader.read();
      }
      Char localChar = Char.make(i);
      return localChar;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException("IO Exception caught");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.readchar
 * JD-Core Version:    0.6.2
 */