package gnu.lists;

public class SubSequence extends AbstractSequence
  implements Sequence
{
  AbstractSequence base;
  int ipos0;
  int ipos1;

  public SubSequence()
  {
  }

  public SubSequence(AbstractSequence paramAbstractSequence)
  {
    this.base = paramAbstractSequence;
  }

  public SubSequence(AbstractSequence paramAbstractSequence, int paramInt1, int paramInt2)
  {
    this.base = paramAbstractSequence;
    this.ipos0 = paramInt1;
    this.ipos1 = paramInt2;
  }

  public void clear()
  {
    removePosRange(this.ipos0, this.ipos1);
  }

  public int compare(int paramInt1, int paramInt2)
  {
    return this.base.compare(paramInt1, paramInt2);
  }

  public int createPos(int paramInt, boolean paramBoolean)
  {
    return this.base.createRelativePos(this.ipos0, paramInt, paramBoolean);
  }

  public int createRelativePos(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return this.base.createRelativePos(paramInt1, paramInt2, paramBoolean);
  }

  public int endPos()
  {
    return this.ipos1;
  }

  public void finalize()
  {
    this.base.releasePos(this.ipos0);
    this.base.releasePos(this.ipos1);
  }

  public Object get(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= size()))
      throw new IndexOutOfBoundsException();
    int i = this.base.nextIndex(this.ipos0);
    return this.base.get(i + paramInt);
  }

  protected int getIndexDifference(int paramInt1, int paramInt2)
  {
    return this.base.getIndexDifference(paramInt1, paramInt2);
  }

  public int getNextKind(int paramInt)
  {
    if (this.base.compare(paramInt, this.ipos1) >= 0)
      return 0;
    return this.base.getNextKind(paramInt);
  }

  public Object getPosNext(int paramInt)
  {
    if (this.base.compare(paramInt, this.ipos1) >= 0)
      return eofValue;
    return this.base.getPosNext(paramInt);
  }

  public Object getPosPrevious(int paramInt)
  {
    if (this.base.compare(paramInt, this.ipos0) <= 0)
      return eofValue;
    return this.base.getPosPrevious(paramInt);
  }

  protected boolean isAfterPos(int paramInt)
  {
    return this.base.isAfterPos(paramInt);
  }

  protected int nextIndex(int paramInt)
  {
    return getIndexDifference(paramInt, this.ipos0);
  }

  public void releasePos(int paramInt)
  {
    this.base.releasePos(paramInt);
  }

  public void removePosRange(int paramInt1, int paramInt2)
  {
    AbstractSequence localAbstractSequence = this.base;
    int i;
    int j;
    if (paramInt1 == 0)
    {
      i = this.ipos0;
      if (paramInt2 != -1)
        break label55;
      j = this.ipos1;
    }
    while (true)
    {
      localAbstractSequence.removePosRange(i, j);
      return;
      if (paramInt1 == -1)
      {
        i = this.ipos1;
        break;
      }
      i = paramInt1;
      break;
      label55: if (paramInt2 == 0)
        j = this.ipos0;
      else
        j = paramInt2;
    }
  }

  public int size()
  {
    return this.base.getIndexDifference(this.ipos1, this.ipos0);
  }

  public int startPos()
  {
    return this.ipos0;
  }

  protected Sequence subSequencePos(int paramInt1, int paramInt2)
  {
    return new SubSequence(this.base, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.SubSequence
 * JD-Core Version:    0.6.2
 */