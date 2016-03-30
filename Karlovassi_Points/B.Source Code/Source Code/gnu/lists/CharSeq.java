package gnu.lists;

import java.io.IOException;

public abstract interface CharSeq extends CharSequence, Sequence
{
  public abstract char charAt(int paramInt);

  public abstract void consume(int paramInt1, int paramInt2, Consumer paramConsumer);

  public abstract void fill(char paramChar);

  public abstract void fill(int paramInt1, int paramInt2, char paramChar);

  public abstract void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3);

  public abstract int length();

  public abstract void setCharAt(int paramInt, char paramChar);

  public abstract CharSequence subSequence(int paramInt1, int paramInt2);

  public abstract String toString();

  public abstract void writeTo(int paramInt1, int paramInt2, Appendable paramAppendable)
    throws IOException;

  public abstract void writeTo(Appendable paramAppendable)
    throws IOException;
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.CharSeq
 * JD-Core Version:    0.6.2
 */