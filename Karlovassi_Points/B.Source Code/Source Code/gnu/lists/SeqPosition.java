package gnu.lists;

import java.util.Enumeration;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SeqPosition
  implements ListIterator, Enumeration
{
  public int ipos;
  public AbstractSequence sequence;

  public SeqPosition()
  {
  }

  public SeqPosition(AbstractSequence paramAbstractSequence)
  {
    this.sequence = paramAbstractSequence;
  }

  public SeqPosition(AbstractSequence paramAbstractSequence, int paramInt)
  {
    this.sequence = paramAbstractSequence;
    this.ipos = paramInt;
  }

  public SeqPosition(AbstractSequence paramAbstractSequence, int paramInt, boolean paramBoolean)
  {
    this.sequence = paramAbstractSequence;
    this.ipos = paramAbstractSequence.createPos(paramInt, paramBoolean);
  }

  public static SeqPosition make(AbstractSequence paramAbstractSequence, int paramInt)
  {
    return new SeqPosition(paramAbstractSequence, paramAbstractSequence.copyPos(paramInt));
  }

  public void add(Object paramObject)
  {
    setPos(this.sequence.addPos(getPos(), paramObject));
  }

  public SeqPosition copy()
  {
    return new SeqPosition(this.sequence, this.sequence.copyPos(getPos()));
  }

  public void finalize()
  {
    release();
  }

  public final int fromEndIndex()
  {
    return this.sequence.fromEndIndex(getPos());
  }

  public int getContainingSequenceSize()
  {
    return this.sequence.getContainingSequenceSize(getPos());
  }

  public Object getNext()
  {
    return this.sequence.getPosNext(getPos());
  }

  public int getNextKind()
  {
    return this.sequence.getNextKind(getPos());
  }

  public String getNextTypeName()
  {
    return this.sequence.getNextTypeName(getPos());
  }

  public Object getNextTypeObject()
  {
    return this.sequence.getNextTypeObject(getPos());
  }

  public int getPos()
  {
    return this.ipos;
  }

  public Object getPrevious()
  {
    return this.sequence.getPosPrevious(getPos());
  }

  public boolean gotoChildrenStart()
  {
    int i = this.sequence.firstChildPos(getPos());
    if (i == 0)
      return false;
    this.ipos = i;
    return true;
  }

  public final void gotoEnd(AbstractSequence paramAbstractSequence)
  {
    setPos(paramAbstractSequence, paramAbstractSequence.endPos());
  }

  public boolean gotoNext()
  {
    int i = this.sequence.nextPos(this.ipos);
    if (i != 0)
    {
      this.ipos = i;
      return true;
    }
    this.ipos = -1;
    return false;
  }

  public boolean gotoPrevious()
  {
    int i = this.sequence.previousPos(this.ipos);
    if (i != -1)
    {
      this.ipos = i;
      return true;
    }
    this.ipos = 0;
    return false;
  }

  public final void gotoStart(AbstractSequence paramAbstractSequence)
  {
    setPos(paramAbstractSequence, paramAbstractSequence.startPos());
  }

  public final boolean hasMoreElements()
  {
    return hasNext();
  }

  public boolean hasNext()
  {
    return this.sequence.hasNext(getPos());
  }

  public boolean hasPrevious()
  {
    return this.sequence.hasPrevious(getPos());
  }

  public boolean isAfter()
  {
    return this.sequence.isAfterPos(getPos());
  }

  public Object next()
  {
    Object localObject = getNext();
    if ((localObject == Sequence.eofValue) || (!gotoNext()))
      throw new NoSuchElementException();
    return localObject;
  }

  public final Object nextElement()
  {
    return next();
  }

  public int nextIndex()
  {
    return this.sequence.nextIndex(getPos());
  }

  public Object previous()
  {
    Object localObject = getPrevious();
    if ((localObject == Sequence.eofValue) || (!gotoPrevious()))
      throw new NoSuchElementException();
    return localObject;
  }

  public final int previousIndex()
  {
    return this.sequence.nextIndex(getPos()) - 1;
  }

  public void release()
  {
    if (this.sequence != null)
    {
      this.sequence.releasePos(getPos());
      this.sequence = null;
    }
  }

  public void remove()
  {
    AbstractSequence localAbstractSequence = this.sequence;
    int i = getPos();
    if (isAfter());
    for (int j = -1; ; j = 1)
    {
      localAbstractSequence.removePos(i, j);
      return;
    }
  }

  public void set(AbstractSequence paramAbstractSequence, int paramInt, boolean paramBoolean)
  {
    if (this.sequence != null)
      this.sequence.releasePos(this.ipos);
    this.sequence = paramAbstractSequence;
    this.ipos = paramAbstractSequence.createPos(paramInt, paramBoolean);
  }

  public void set(SeqPosition paramSeqPosition)
  {
    if (this.sequence != null)
      this.sequence.releasePos(this.ipos);
    this.sequence = paramSeqPosition.sequence;
    paramSeqPosition.ipos = this.sequence.copyPos(paramSeqPosition.ipos);
  }

  public final void set(Object paramObject)
  {
    if (isAfter())
    {
      setPrevious(paramObject);
      return;
    }
    setNext(paramObject);
  }

  public void setNext(Object paramObject)
  {
    this.sequence.setPosNext(getPos(), paramObject);
  }

  public void setPos(int paramInt)
  {
    if (this.sequence != null)
      this.sequence.releasePos(getPos());
    this.ipos = paramInt;
  }

  public void setPos(AbstractSequence paramAbstractSequence, int paramInt)
  {
    if (this.sequence != null)
      this.sequence.releasePos(getPos());
    this.ipos = paramInt;
    this.sequence = paramAbstractSequence;
  }

  public void setPrevious(Object paramObject)
  {
    this.sequence.setPosPrevious(getPos(), paramObject);
  }

  public String toInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer(60);
    localStringBuffer.append('{');
    if (this.sequence == null)
      localStringBuffer.append("null sequence");
    while (true)
    {
      localStringBuffer.append(" ipos: ");
      localStringBuffer.append(this.ipos);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
      localStringBuffer.append(this.sequence.getClass().getName());
      localStringBuffer.append('@');
      localStringBuffer.append(System.identityHashCode(this.sequence));
    }
  }

  public String toString()
  {
    if (this.sequence == null)
      return toInfo();
    Object localObject = this.sequence.getPosNext(this.ipos);
    StringBuilder localStringBuilder = new StringBuilder().append("@").append(nextIndex()).append(": ");
    if (localObject == null);
    for (String str = "(null)"; ; str = localObject.toString())
      return str;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.SeqPosition
 * JD-Core Version:    0.6.2
 */