package gnu.lists;

public class PositionManager
{
  static final PositionManager manager = new PositionManager();
  int freeListHead = -1;
  int[] ivals = new int[50];
  SeqPosition[] positions = new SeqPosition[50];

  public PositionManager()
  {
    addToFreeList(this.ivals, 1, this.ivals.length);
  }

  private void addToFreeList(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = this.freeListHead;
    for (int j = paramInt1; j < paramInt2; j++)
    {
      paramArrayOfInt[j] = i;
      i = j;
    }
    this.freeListHead = i;
  }

  private int getFreeSlot()
  {
    int i = this.freeListHead;
    if (i < 0)
    {
      int j = this.positions.length;
      SeqPosition[] arrayOfSeqPosition = new SeqPosition[j * 2];
      int[] arrayOfInt = new int[j * 2];
      System.arraycopy(this.positions, 0, arrayOfSeqPosition, 0, j);
      System.arraycopy(this.ivals, 0, arrayOfInt, 0, j);
      this.positions = arrayOfSeqPosition;
      this.ivals = arrayOfInt;
      addToFreeList(arrayOfInt, j, j * 2);
      i = this.freeListHead;
    }
    this.freeListHead = this.ivals[i];
    return i;
  }

  public static SeqPosition getPositionObject(int paramInt)
  {
    synchronized (manager)
    {
      SeqPosition localSeqPosition = ???.positions[paramInt];
      return localSeqPosition;
    }
  }

  public int register(SeqPosition paramSeqPosition)
  {
    try
    {
      int i = getFreeSlot();
      this.positions[i] = paramSeqPosition;
      this.ivals[i] = -1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void release(int paramInt)
  {
    try
    {
      SeqPosition localSeqPosition = this.positions[paramInt];
      if ((localSeqPosition instanceof ExtPosition))
        ((ExtPosition)localSeqPosition).position = -1;
      this.positions[paramInt] = null;
      this.ivals[paramInt] = this.freeListHead;
      this.freeListHead = paramInt;
      localSeqPosition.release();
      return;
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.PositionManager
 * JD-Core Version:    0.6.2
 */