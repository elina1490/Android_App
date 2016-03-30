package gnu.lists;

public class StableVector extends GapVector
{
  static final int END_POSITION = 1;
  protected static final int FREE_POSITION = -2;
  static final int START_POSITION;
  protected int free;
  protected int[] positions;

  protected StableVector()
  {
  }

  public StableVector(SimpleVector paramSimpleVector)
  {
    super(paramSimpleVector);
    this.positions = new int[16];
    this.positions[0] = 0;
    this.positions[1] = (0x1 | paramSimpleVector.getBufferLength() << 1);
    this.free = -1;
    int i = this.positions.length;
    while (true)
    {
      i--;
      if (i <= 1)
        break;
      this.positions[i] = this.free;
      this.free = i;
    }
  }

  protected int addPos(int paramInt, Object paramObject)
  {
    int i = this.positions[paramInt];
    int j = i >>> 1;
    if (j >= this.gapStart)
      j += this.gapEnd - this.gapStart;
    if ((i & 0x1) == 0)
    {
      if (paramInt != 0)
        break label61;
      paramInt = createPos(0, true);
    }
    while (true)
    {
      add(j, paramObject);
      return paramInt;
      label61: this.positions[paramInt] = (i | 0x1);
    }
  }

  protected void adjustPositions(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.free >= -1)
      unchainFreelist();
    int i = paramInt1 ^ 0x80000000;
    int j = paramInt2 ^ 0x80000000;
    int k = this.positions.length;
    while (true)
    {
      k--;
      if (k <= 0)
        break;
      int m = this.positions[k];
      if (m != -2)
      {
        int n = m ^ 0x80000000;
        if ((n >= i) && (n <= j))
          this.positions[k] = (m + paramInt3);
      }
    }
  }

  protected int allocPositionIndex()
  {
    if (this.free == -2)
      chainFreelist();
    if (this.free < 0)
    {
      int j = this.positions.length;
      int[] arrayOfInt = new int[j * 2];
      System.arraycopy(this.positions, 0, arrayOfInt, 0, j);
      int k = j * 2;
      while (true)
      {
        k--;
        if (k < j)
          break;
        arrayOfInt[k] = this.free;
        this.free = k;
      }
      this.positions = arrayOfInt;
    }
    int i = this.free;
    this.free = this.positions[this.free];
    return i;
  }

  protected void chainFreelist()
  {
    this.free = -1;
    int i = this.positions.length;
    while (true)
    {
      i--;
      if (i <= 1)
        break;
      if (this.positions[i] == -2)
      {
        this.positions[i] = this.free;
        this.free = i;
      }
    }
  }

  public void consumePosRange(int paramInt1, int paramInt2, Consumer paramConsumer)
  {
    super.consumePosRange(this.positions[paramInt1], this.positions[paramInt2], paramConsumer);
  }

  public int copyPos(int paramInt)
  {
    if (paramInt > 1)
    {
      int i = allocPositionIndex();
      this.positions[i] = this.positions[paramInt];
      paramInt = i;
    }
    return paramInt;
  }

  public int createPos(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 0) && (!paramBoolean))
      return 0;
    if ((paramBoolean) && (paramInt == size()))
      return 1;
    if ((paramInt > this.gapStart) || ((paramInt == this.gapStart) && (paramBoolean)))
      paramInt += this.gapEnd - this.gapStart;
    int i = allocPositionIndex();
    int[] arrayOfInt = this.positions;
    int j = paramInt << 1;
    int k = 0;
    if (paramBoolean)
      k = 1;
    arrayOfInt[i] = (j | k);
    return i;
  }

  public int endPos()
  {
    return 1;
  }

  public void fillPosRange(int paramInt1, int paramInt2, Object paramObject)
  {
    fillPosRange(this.positions[paramInt1], this.positions[paramInt2], paramObject);
  }

  protected void gapReserve(int paramInt1, int paramInt2)
  {
    int i = this.gapEnd;
    int j = this.gapStart;
    if (paramInt2 > i - j)
    {
      k = this.base.size;
      super.gapReserve(paramInt1, paramInt2);
      m = this.base.size;
      if (paramInt1 == j)
        adjustPositions(i << 1, 0x1 | m << 1, m - k << 1);
    }
    while (paramInt1 == this.gapStart)
    {
      int k;
      int m;
      return;
      adjustPositions(i << 1, 0x1 | k << 1, j - i << 1);
      adjustPositions(this.gapStart << 1, 0x1 | m << 1, this.gapEnd - this.gapStart << 1);
      return;
    }
    shiftGap(paramInt1);
  }

  public boolean hasNext(int paramInt)
  {
    int i = this.positions[paramInt] >>> 1;
    if (i >= this.gapStart)
      i += this.gapEnd - this.gapStart;
    return i < this.base.getBufferLength();
  }

  protected boolean isAfterPos(int paramInt)
  {
    return (0x1 & this.positions[paramInt]) != 0;
  }

  public int nextIndex(int paramInt)
  {
    int i = this.positions[paramInt] >>> 1;
    if (i > this.gapStart)
      i -= this.gapEnd - this.gapStart;
    return i;
  }

  public int nextPos(int paramInt)
  {
    int i = this.positions[paramInt];
    int j = i >>> 1;
    if (j >= this.gapStart)
      j += this.gapEnd - this.gapStart;
    if (j >= this.base.getBufferLength())
    {
      releasePos(paramInt);
      return 0;
    }
    if (paramInt == 0)
      paramInt = createPos(0, true);
    this.positions[paramInt] = (i | 0x1);
    return paramInt;
  }

  public void releasePos(int paramInt)
  {
    if (paramInt >= 2)
    {
      if (this.free == -2)
        chainFreelist();
      this.positions[paramInt] = this.free;
      this.free = paramInt;
    }
  }

  protected void removePosRange(int paramInt1, int paramInt2)
  {
    super.removePosRange(this.positions[paramInt1], this.positions[paramInt2]);
    int i = this.gapStart;
    int j = this.gapEnd;
    if (this.free >= -1)
      unchainFreelist();
    int k = this.positions.length;
    while (true)
    {
      k--;
      if (k <= 0)
        break;
      int m = this.positions[k];
      if (m != -2)
      {
        int n = m >> 1;
        if ((m & 0x1) != 0);
        for (int i1 = 1; ; i1 = 0)
        {
          if (i1 == 0)
            break label128;
          if ((n < i) || (n >= j))
            break;
          this.positions[k] = (0x1 | this.gapEnd << 1);
          break;
        }
        label128: if ((n > i) && (n <= j))
          this.positions[k] = (this.gapStart << 1);
      }
    }
  }

  protected void shiftGap(int paramInt)
  {
    int i = this.gapStart;
    int j = paramInt - i;
    int n;
    int k;
    int m;
    if (j > 0)
    {
      int i1 = this.gapEnd;
      int i2 = i1 + j;
      n = i - i1 << 1;
      k = i1 << 1;
      m = (i2 << 1) - 1;
    }
    while (true)
    {
      super.shiftGap(paramInt);
      adjustPositions(k, m, n);
      do
        return;
      while (paramInt == i);
      k = 1 + (paramInt << 1);
      m = i << 1;
      n = this.gapEnd - i << 1;
    }
  }

  public int startPos()
  {
    return 0;
  }

  protected void unchainFreelist()
  {
    int j;
    for (int i = this.free; i >= 0; i = j)
    {
      j = this.positions[i];
      this.positions[i] = -2;
    }
    this.free = -2;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.StableVector
 * JD-Core Version:    0.6.2
 */