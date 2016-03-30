package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;

public class IntersectNodes extends Procedure2
{
  public static final IntersectNodes exceptNodes = new IntersectNodes(true);
  public static final IntersectNodes intersectNodes = new IntersectNodes(false);
  boolean isExcept;

  public IntersectNodes(boolean paramBoolean)
  {
    this.isExcept = paramBoolean;
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    SortedNodes localSortedNodes1 = new SortedNodes();
    SortedNodes localSortedNodes2 = new SortedNodes();
    SortedNodes localSortedNodes3 = new SortedNodes();
    Values.writeValues(paramObject1, localSortedNodes1);
    Values.writeValues(paramObject2, localSortedNodes2);
    int i = 0;
    AbstractSequence localAbstractSequence1 = null;
    int j = 0;
    int k = 0;
    int m = 0;
    AbstractSequence localAbstractSequence2 = localSortedNodes1.getSeq(m);
    if (localAbstractSequence2 == null)
      return localSortedNodes3;
    int n = localSortedNodes1.getPos(m);
    int i1;
    if (k == -1)
    {
      k = AbstractSequence.compare(localAbstractSequence2, n, localAbstractSequence1, j);
      i1 = i;
    }
    while (true)
    {
      label99: if (k > 0)
      {
        localAbstractSequence1 = localSortedNodes2.getSeq(i1);
        if (localAbstractSequence1 == null)
          k = -2;
      }
      else
      {
        if (k != 0)
          break label208;
      }
      label208: for (int i2 = 1; ; i2 = 0)
      {
        if (i2 != this.isExcept)
          localSortedNodes3.writePosition(localAbstractSequence2, n);
        m++;
        i = i1;
        break;
        if (k != 0)
          break label214;
        k = 1;
        i1 = i;
        break label99;
        int i3 = i1 + 1;
        j = localSortedNodes2.getPos(i1);
        k = AbstractSequence.compare(localAbstractSequence2, n, localAbstractSequence1, j);
        i1 = i3;
        break label99;
      }
      label214: i1 = i;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.IntersectNodes
 * JD-Core Version:    0.6.2
 */