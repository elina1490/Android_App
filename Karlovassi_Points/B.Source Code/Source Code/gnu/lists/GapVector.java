package gnu.lists;

public class GapVector extends AbstractSequence
  implements Sequence
{
  public SimpleVector base;
  public int gapEnd;
  public int gapStart;

  protected GapVector()
  {
  }

  public GapVector(SimpleVector paramSimpleVector)
  {
    this.base = paramSimpleVector;
    this.gapStart = 0;
    this.gapEnd = paramSimpleVector.size;
  }

  public void add(int paramInt, Object paramObject)
  {
    gapReserve(paramInt, 1);
    this.base.set(paramInt, paramObject);
    this.gapStart = (1 + this.gapStart);
  }

  protected int addPos(int paramInt, Object paramObject)
  {
    int i = paramInt >>> 1;
    if (i >= this.gapStart)
      i += this.gapEnd - this.gapStart;
    add(i, paramObject);
    return 0x1 | i + 1 << 1;
  }

  public void consumePosRange(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    if (paramConsumer.ignoring())
      return;
    int i = paramInt1 >>> 1;
    int j = paramInt2 >>> 1;
    if (i < this.gapStart)
      if (j <= this.gapStart)
        break label87;
    label87: for (int k = j; ; k = this.gapStart)
    {
      consumePosRange(paramInt1, k << 1, paramConsumer);
      if (j <= this.gapEnd)
        break;
      if (i < this.gapEnd)
        i = this.gapEnd;
      consumePosRange(i << 1, paramInt2, paramConsumer);
      return;
    }
  }

  public int createPos(int paramInt, boolean paramBoolean)
  {
    if (paramInt > this.gapStart)
      paramInt += this.gapEnd - this.gapStart;
    int i = paramInt << 1;
    if (paramBoolean);
    for (int j = 1; ; j = 0)
      return i | j;
  }

  public void fill(Object paramObject)
  {
    this.base.fill(this.gapEnd, this.base.size, paramObject);
    this.base.fill(0, this.gapStart, paramObject);
  }

  public void fillPosRange(int paramInt1, int paramInt2, Object paramObject)
  {
    int i;
    int j;
    if (paramInt1 == -1)
    {
      i = this.base.size;
      if (paramInt2 != -1)
        break label79;
      j = this.base.size;
      label28: if (this.gapStart >= j)
        break label87;
    }
    label79: label87: for (int k = this.gapStart; ; k = j)
    {
      for (int m = i; m < k; m++)
        this.base.setBuffer(m, paramObject);
      i = paramInt1 >>> 1;
      break;
      j = paramInt2 >>> 1;
      break label28;
    }
    for (int n = this.gapEnd; n < j; n++)
      this.base.setBuffer(n, paramObject);
  }

  protected final void gapReserve(int paramInt)
  {
    gapReserve(this.gapStart, paramInt);
  }

  protected void gapReserve(int paramInt1, int paramInt2)
  {
    if (paramInt2 > this.gapEnd - this.gapStart)
    {
      i = this.base.size;
      if (i < 16)
      {
        j = 16;
        k = i - (this.gapEnd - this.gapStart);
        m = k + paramInt2;
        if (j < m)
          j = m;
        n = paramInt1 + (j - k);
        this.base.resizeShift(this.gapStart, this.gapEnd, paramInt1, n);
        this.gapStart = paramInt1;
        this.gapEnd = n;
      }
    }
    while (paramInt1 == this.gapStart)
      while (true)
      {
        int i;
        int k;
        int m;
        int n;
        return;
        int j = i * 2;
      }
    shiftGap(paramInt1);
  }

  public Object get(int paramInt)
  {
    if (paramInt >= this.gapStart)
      paramInt += this.gapEnd - this.gapStart;
    return this.base.get(paramInt);
  }

  public int getNextKind(int paramInt)
  {
    if (hasNext(paramInt))
      return this.base.getElementKind();
    return 0;
  }

  public int getSegment(int paramInt1, int paramInt2)
  {
    int i = size();
    if ((paramInt1 < 0) || (paramInt1 > i))
      return -1;
    if (paramInt2 < 0)
      paramInt2 = 0;
    while (paramInt1 + paramInt2 <= this.gapStart)
    {
      return paramInt1;
      if (paramInt1 + paramInt2 > i)
        paramInt2 = i - paramInt1;
    }
    if (paramInt1 >= this.gapStart)
      return paramInt1 + (this.gapEnd - this.gapStart);
    if (this.gapStart - paramInt1 > paramInt2 >> 1)
    {
      shiftGap(paramInt1 + paramInt2);
      return paramInt1;
    }
    shiftGap(paramInt1);
    return paramInt1 + (this.gapEnd - this.gapStart);
  }

  public boolean hasNext(int paramInt)
  {
    int i = paramInt >>> 1;
    if (i >= this.gapStart)
      i += this.gapEnd - this.gapStart;
    return i < this.base.size;
  }

  protected boolean isAfterPos(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }

  protected int nextIndex(int paramInt)
  {
    if (paramInt == -1);
    for (int i = this.base.size; ; i = paramInt >>> 1)
    {
      if (i > this.gapStart)
        i -= this.gapEnd - this.gapStart;
      return i;
    }
  }

  protected void removePosRange(int paramInt1, int paramInt2)
  {
    int i = paramInt1 >>> 1;
    int j = paramInt2 >>> 1;
    if (i > this.gapEnd)
      shiftGap(i - this.gapEnd + this.gapStart);
    while (true)
    {
      if (i < this.gapStart)
      {
        this.base.clearBuffer(i, this.gapStart - i);
        this.gapStart = i;
      }
      if (j > this.gapEnd)
      {
        this.base.clearBuffer(this.gapEnd, j - this.gapEnd);
        this.gapEnd = j;
      }
      return;
      if (j < this.gapStart)
        shiftGap(j);
    }
  }

  public Object set(int paramInt, Object paramObject)
  {
    if (paramInt >= this.gapStart)
      paramInt += this.gapEnd - this.gapStart;
    return this.base.set(paramInt, paramObject);
  }

  protected void shiftGap(int paramInt)
  {
    int i = paramInt - this.gapStart;
    if (i > 0)
      this.base.shift(this.gapEnd, this.gapStart, i);
    while (true)
    {
      this.gapEnd = (i + this.gapEnd);
      this.gapStart = paramInt;
      return;
      if (i < 0)
        this.base.shift(paramInt, i + this.gapEnd, -i);
    }
  }

  public int size()
  {
    return this.base.size - (this.gapEnd - this.gapStart);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.GapVector
 * JD-Core Version:    0.6.2
 */