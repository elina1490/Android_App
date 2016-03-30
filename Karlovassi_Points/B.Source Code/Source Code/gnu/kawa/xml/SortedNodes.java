package gnu.kawa.xml;

import gnu.lists.AbstractSequence;

public class SortedNodes extends Nodes
{
  int nesting = 0;

  int compareIndex(int paramInt1, AbstractSequence paramAbstractSequence, int paramInt2)
  {
    if (this.data[paramInt1] != 61711)
      throw new RuntimeException("invalid kind of value to compare");
    return AbstractSequence.compare((AbstractSequence)this.objects[getIntN(paramInt1 + 1)], getIntN(paramInt1 + 3), paramAbstractSequence, paramInt2);
  }

  int find(int paramInt1, int paramInt2, AbstractSequence paramAbstractSequence, int paramInt3)
  {
    int i = 0;
    int j = paramInt2;
    while (i < j)
    {
      int k = i + j >>> 1;
      int m = compareIndex(paramInt1 + k * 5, paramAbstractSequence, paramInt3);
      if (m == 0)
        return -1;
      if (m > 0)
        j = k;
      else
        i = k + 1;
    }
    return paramInt1 + i * 5;
  }

  public void writePosition(AbstractSequence paramAbstractSequence, int paramInt)
  {
    int i;
    int j;
    if (this.count > 0)
    {
      i = this.gapStart - 5;
      j = compareIndex(i, paramAbstractSequence, paramInt);
      if (j >= 0)
        break label119;
      int n = this.gapEnd;
      int i1 = find(n, (this.data.length - n) / 5, paramAbstractSequence, paramInt);
      if (i1 < 0)
        return;
      int i2 = i1 - this.gapEnd;
      if (i2 > 0)
      {
        System.arraycopy(this.data, this.gapEnd, this.data, this.gapStart, i2);
        this.gapEnd = i1;
        this.gapStart = (i2 + this.gapStart);
      }
    }
    while (true)
    {
      super.writePosition(paramAbstractSequence, paramInt);
      return;
      label119: if (j == 0)
        break;
      int k = find(0, i / 5, paramAbstractSequence, paramInt);
      if (k < 0)
        break;
      int m = this.gapStart - k;
      if (m > 0)
      {
        System.arraycopy(this.data, k, this.data, this.gapEnd - m, m);
        this.gapStart = k;
        this.gapEnd -= m;
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.SortedNodes
 * JD-Core Version:    0.6.2
 */