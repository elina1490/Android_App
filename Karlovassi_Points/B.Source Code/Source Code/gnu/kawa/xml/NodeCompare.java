package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import gnu.mapping.WrongType;

public class NodeCompare extends Procedure2
{
  public static final NodeCompare $Eq = make("is", 8);
  public static final NodeCompare $Gr = make(">>", 16);
  public static final NodeCompare $Ls = make("<<", 4);
  public static final NodeCompare $Ne = make("isnot", 20);
  static final int RESULT_EQU = 0;
  static final int RESULT_GRT = 1;
  static final int RESULT_LSS = -1;
  static final int TRUE_IF_EQU = 8;
  static final int TRUE_IF_GRT = 16;
  static final int TRUE_IF_LSS = 4;
  int flags;

  public static NodeCompare make(String paramString, int paramInt)
  {
    NodeCompare localNodeCompare = new NodeCompare();
    localNodeCompare.setName(paramString);
    localNodeCompare.flags = paramInt;
    return localNodeCompare;
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null))
      return null;
    if (paramObject1 == Values.empty)
      return paramObject1;
    if (paramObject2 == Values.empty)
      return paramObject2;
    AbstractSequence localAbstractSequence1;
    int j;
    AbstractSequence localAbstractSequence2;
    int m;
    if ((paramObject1 instanceof AbstractSequence))
    {
      localAbstractSequence1 = (AbstractSequence)paramObject1;
      j = localAbstractSequence1.startPos();
      if (!(paramObject2 instanceof AbstractSequence))
        break label140;
      localAbstractSequence2 = (AbstractSequence)paramObject2;
      m = localAbstractSequence2.startPos();
      if (localAbstractSequence1 != localAbstractSequence2)
        break label178;
    }
    for (int n = localAbstractSequence1.compare(j, m); ; n = localAbstractSequence1.stableCompare(localAbstractSequence2))
    {
      while (true)
      {
        while (true)
        {
          if ((1 << n + 3 & this.flags) == 0)
            break label212;
          return Boolean.TRUE;
          try
          {
            SeqPosition localSeqPosition1 = (SeqPosition)paramObject1;
            localAbstractSequence1 = localSeqPosition1.sequence;
            int i = localSeqPosition1.getPos();
            j = i;
          }
          catch (ClassCastException localClassCastException1)
          {
            throw WrongType.make(localClassCastException1, this, 1, paramObject1);
          }
        }
        try
        {
          label140: SeqPosition localSeqPosition2 = (SeqPosition)paramObject2;
          localAbstractSequence2 = localSeqPosition2.sequence;
          int k = localSeqPosition2.getPos();
          m = k;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw WrongType.make(localClassCastException2, this, 2, paramObject2);
        }
      }
      label178: if (this == $Eq)
        return Boolean.FALSE;
      if (this == $Ne)
        return Boolean.TRUE;
    }
    label212: return Boolean.FALSE;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.NodeCompare
 * JD-Core Version:    0.6.2
 */