package gnu.lists;

public abstract interface XConsumer extends Consumer
{
  public abstract void beginEntity(Object paramObject);

  public abstract void endEntity();

  public abstract void writeCDATA(char[] paramArrayOfChar, int paramInt1, int paramInt2);

  public abstract void writeComment(char[] paramArrayOfChar, int paramInt1, int paramInt2);

  public abstract void writeProcessingInstruction(String paramString, char[] paramArrayOfChar, int paramInt1, int paramInt2);
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.XConsumer
 * JD-Core Version:    0.6.2
 */