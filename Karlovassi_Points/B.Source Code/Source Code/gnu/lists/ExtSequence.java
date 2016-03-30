package gnu.lists;

public abstract class ExtSequence extends AbstractSequence
{
  public int copyPos(int paramInt)
  {
    if (paramInt <= 0)
      return paramInt;
    return PositionManager.manager.register(PositionManager.getPositionObject(paramInt).copy());
  }

  protected boolean isAfterPos(int paramInt)
  {
    if (paramInt <= 0)
      return paramInt < 0;
    return (0x1 & PositionManager.getPositionObject(paramInt).ipos) != 0;
  }

  protected int nextIndex(int paramInt)
  {
    if (paramInt == -1)
      return size();
    if (paramInt == 0)
      return 0;
    return PositionManager.getPositionObject(paramInt).nextIndex();
  }

  protected void releasePos(int paramInt)
  {
    if (paramInt > 0)
      PositionManager.manager.release(paramInt);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.ExtSequence
 * JD-Core Version:    0.6.2
 */