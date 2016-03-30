package gnu.lists;

public class ExtPosition extends SeqPosition
{
  int position = -1;

  public int getPos()
  {
    if (this.position < 0)
      this.position = PositionManager.manager.register(this);
    return this.position;
  }

  public final boolean isAfter()
  {
    return (0x1 & this.ipos) != 0;
  }

  public void release()
  {
    if (this.position >= 0)
      PositionManager.manager.release(this.position);
    this.sequence = null;
  }

  public void setPos(AbstractSequence paramAbstractSequence, int paramInt)
  {
    throw paramAbstractSequence.unsupported("setPos");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.ExtPosition
 * JD-Core Version:    0.6.2
 */