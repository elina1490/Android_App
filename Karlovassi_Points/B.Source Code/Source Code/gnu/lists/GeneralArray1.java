package gnu.lists;

public class GeneralArray1 extends GeneralArray
  implements Sequence
{
  public void consumePosRange(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    if (paramConsumer.ignoring());
    while (true)
    {
      return;
      for (int i = paramInt1; !equals(i, paramInt2); i = nextPos(i))
      {
        if (!hasNext(i))
          throw new RuntimeException();
        this.base.consume(this.offset + this.strides[0] * (i >>> 1), 1, paramConsumer);
      }
    }
  }

  public int createPos(int paramInt, boolean paramBoolean)
  {
    int i = paramInt << 1;
    if (paramBoolean);
    for (int j = 1; ; j = 0)
      return i | j;
  }

  protected int nextIndex(int paramInt)
  {
    if (paramInt == -1)
      return size();
    return paramInt >>> 1;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.GeneralArray1
 * JD-Core Version:    0.6.2
 */