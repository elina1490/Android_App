package gnu.lists;

import java.io.PrintStream;

public class TreePosition extends SeqPosition
  implements Cloneable
{
  int depth;
  int[] istack;
  AbstractSequence[] sstack;
  int start;
  private Object xpos;

  public TreePosition()
  {
    this.depth = -1;
  }

  public TreePosition(AbstractSequence paramAbstractSequence, int paramInt)
  {
    super(paramAbstractSequence, paramInt, false);
  }

  public TreePosition(TreePosition paramTreePosition)
  {
    set(paramTreePosition);
  }

  public TreePosition(Object paramObject)
  {
    this.xpos = paramObject;
    this.depth = -1;
  }

  public Object clone()
  {
    return new TreePosition(this);
  }

  public void dump()
  {
    System.err.println("TreePosition dump depth:" + this.depth + " start:" + this.start);
    int i = 0;
    if (i <= this.depth)
    {
      AbstractSequence localAbstractSequence;
      label59: PrintStream localPrintStream;
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        localAbstractSequence = this.sequence;
        System.err.print("#" + i + " seq:" + localAbstractSequence);
        localPrintStream = System.err;
        localStringBuilder = new StringBuilder().append(" ipos:");
        if (i != 0)
          break label156;
      }
      label156: for (int j = this.ipos; ; j = this.istack[(this.depth - i)])
      {
        localPrintStream.println(j);
        i++;
        break;
        localAbstractSequence = this.sstack[(this.depth - i)];
        break label59;
      }
    }
  }

  public Object getAncestor(int paramInt)
  {
    if (paramInt == 0)
      return this.sequence.getPosNext(this.ipos);
    int i = this.depth - paramInt;
    if (i <= 0)
      return getRoot();
    int j = i + this.start;
    return this.sstack[j].getPosNext(this.istack[j]);
  }

  public int getDepth()
  {
    return 1 + this.depth;
  }

  public Object getPosNext()
  {
    if (this.sequence == null)
      return this.xpos;
    return this.sequence.getPosNext(this.ipos);
  }

  public AbstractSequence getRoot()
  {
    if (this.depth == 0)
      return this.sequence;
    return this.sstack[this.start];
  }

  public boolean gotoAttributesStart()
  {
    if (this.sequence == null)
    {
      if ((this.xpos instanceof AbstractSequence));
      return false;
    }
    return this.sequence.gotoAttributesStart(this);
  }

  public boolean gotoChildrenStart()
  {
    if (this.sequence == null)
    {
      if (!(this.xpos instanceof AbstractSequence))
        return false;
      this.depth = 0;
      this.sequence = ((AbstractSequence)this.xpos);
      setPos(this.sequence.startPos());
    }
    while (this.sequence.gotoChildrenStart(this))
      return true;
    return false;
  }

  public final boolean gotoParent()
  {
    if (this.sequence == null)
      return false;
    return this.sequence.gotoParent(this);
  }

  public void pop()
  {
    this.sequence.releasePos(this.ipos);
    popNoRelease();
  }

  public void popNoRelease()
  {
    int i = this.depth - 1;
    this.depth = i;
    if (i < 0)
    {
      this.xpos = this.sequence;
      this.sequence = null;
      return;
    }
    this.sequence = this.sstack[(this.start + this.depth)];
    this.ipos = this.istack[(this.start + this.depth)];
  }

  public void push(AbstractSequence paramAbstractSequence, int paramInt)
  {
    int i = this.depth + this.start;
    if (i >= 0)
    {
      if (i != 0)
        break label76;
      this.istack = new int[8];
      this.sstack = new AbstractSequence[8];
    }
    while (true)
    {
      this.sstack[i] = this.sequence;
      this.istack[i] = this.ipos;
      this.depth = (1 + this.depth);
      this.sequence = paramAbstractSequence;
      this.ipos = paramInt;
      return;
      label76: if (i >= this.istack.length)
      {
        int j = i * 2;
        int[] arrayOfInt = new int[j];
        new Object[j];
        AbstractSequence[] arrayOfAbstractSequence = new AbstractSequence[j];
        System.arraycopy(this.istack, 0, arrayOfInt, 0, this.depth);
        System.arraycopy(this.sstack, 0, arrayOfAbstractSequence, 0, this.depth);
        this.istack = arrayOfInt;
        this.sstack = arrayOfAbstractSequence;
      }
    }
  }

  public void release()
  {
    while (this.sequence != null)
    {
      this.sequence.releasePos(this.ipos);
      pop();
    }
    this.xpos = null;
  }

  public void set(TreePosition paramTreePosition)
  {
    release();
    int i = paramTreePosition.depth;
    this.depth = i;
    if (i < 0)
    {
      this.xpos = paramTreePosition.xpos;
      return;
    }
    if ((this.sstack == null) || (this.sstack.length <= i))
      this.sstack = new AbstractSequence[i + 10];
    if ((this.istack == null) || (this.istack.length <= i))
      this.istack = new int[i + 10];
    for (int j = 0; j < this.depth; j++)
    {
      int k = j + paramTreePosition.start;
      AbstractSequence localAbstractSequence2 = paramTreePosition.sstack[k];
      this.sstack[(this.depth - 1)] = localAbstractSequence2;
      this.istack[(this.depth - j)] = localAbstractSequence2.copyPos(paramTreePosition.istack[k]);
    }
    AbstractSequence localAbstractSequence1 = paramTreePosition.sequence;
    this.sequence = localAbstractSequence1;
    this.ipos = localAbstractSequence1.copyPos(paramTreePosition.ipos);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.TreePosition
 * JD-Core Version:    0.6.2
 */