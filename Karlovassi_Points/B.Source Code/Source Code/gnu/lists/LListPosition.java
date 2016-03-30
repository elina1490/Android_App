package gnu.lists;

class LListPosition extends ExtPosition
{
  Object xpos;

  public LListPosition(LList paramLList, int paramInt, boolean paramBoolean)
  {
    set(paramLList, paramInt, paramBoolean);
  }

  public LListPosition(LListPosition paramLListPosition)
  {
    this.sequence = paramLListPosition.sequence;
    this.ipos = paramLListPosition.ipos;
    this.xpos = paramLListPosition.xpos;
  }

  public SeqPosition copy()
  {
    return new LListPosition(this);
  }

  public Object getNext()
  {
    Pair localPair = getNextPair();
    if (localPair == null)
      return LList.eofValue;
    return localPair.car;
  }

  public Pair getNextPair()
  {
    Object localObject;
    if ((0x1 & this.ipos) > 0)
      if (this.xpos == null)
      {
        localObject = this.sequence;
        if (this.ipos >> 1 != 0)
          localObject = ((Pair)localObject).cdr;
      }
    while (localObject == LList.Empty)
    {
      return null;
      localObject = ((Pair)((Pair)this.xpos).cdr).cdr;
      continue;
      if (this.xpos == null)
        localObject = this.sequence;
      else
        localObject = ((Pair)this.xpos).cdr;
    }
    return (Pair)localObject;
  }

  public Object getPrevious()
  {
    Pair localPair = getPreviousPair();
    if (localPair == null)
      return LList.eofValue;
    return localPair.car;
  }

  public Pair getPreviousPair()
  {
    int i = 0x1 & this.ipos;
    Object localObject = this.xpos;
    if (i > 0)
      if (localObject == null)
        localObject = this.sequence;
    while (localObject == LList.Empty)
    {
      return null;
      localObject = ((Pair)localObject).cdr;
      continue;
      if (localObject == null)
        return null;
    }
    return (Pair)localObject;
  }

  public boolean gotoNext()
  {
    if ((0x1 & this.ipos) != 0);
    Object localObject;
    for (int i = 1; ; i = 0)
    {
      localObject = this.xpos;
      if (localObject == null)
        break label76;
      if (i != 0)
        localObject = ((Pair)localObject).cdr;
      if (((Pair)localObject).cdr != LList.Empty)
        break;
      return false;
    }
    this.xpos = localObject;
    this.ipos = (2 + (0x1 | this.ipos));
    while (true)
    {
      return true;
      label76: if (this.ipos >> 1 == 0)
      {
        if (this.sequence == LList.Empty)
          return false;
        this.ipos = 3;
      }
      else
      {
        AbstractSequence localAbstractSequence = this.sequence;
        if (((Pair)localAbstractSequence).cdr == LList.Empty)
          return false;
        this.ipos = 5;
        this.xpos = localAbstractSequence;
      }
    }
  }

  public boolean gotoPrevious()
  {
    if (this.ipos >>> 1 == 0)
      return false;
    if ((0x1 & this.ipos) != 0)
    {
      this.ipos -= 3;
      return true;
    }
    int i = nextIndex();
    set((LList)this.sequence, i - 1, false);
    return true;
  }

  public boolean hasNext()
  {
    if (this.xpos == null)
    {
      if (this.ipos >> 1 == 0)
        return this.sequence != LList.Empty;
      return ((Pair)this.sequence).cdr != LList.Empty;
    }
    Object localObject = ((Pair)this.xpos).cdr;
    if ((0x1 & this.ipos) > 0)
      localObject = ((Pair)localObject).cdr;
    return localObject != LList.Empty;
  }

  public boolean hasPrevious()
  {
    return this.ipos >>> 1 != 0;
  }

  public int nextIndex()
  {
    return this.ipos >> 1;
  }

  public void set(AbstractSequence paramAbstractSequence, int paramInt, boolean paramBoolean)
  {
    set((LList)paramAbstractSequence, paramInt, paramBoolean);
  }

  public void set(LList paramLList, int paramInt, boolean paramBoolean)
  {
    this.sequence = paramLList;
    int i = paramInt << 1;
    int j;
    int k;
    if (paramBoolean)
    {
      j = 1;
      this.ipos = (i | j);
      if (!paramBoolean)
        break label70;
      k = paramInt - 2;
    }
    while (true)
      if (k >= 0)
      {
        for (Object localObject = paramLList; ; localObject = ((Pair)localObject).cdr)
        {
          k--;
          if (k < 0)
            break;
        }
        j = 0;
        break;
        label70: k = paramInt - 1;
        continue;
        this.xpos = localObject;
        return;
      }
    this.xpos = null;
  }

  public void setNext(Object paramObject)
  {
    getNextPair().car = paramObject;
  }

  public void setPrevious(Object paramObject)
  {
    getPreviousPair().car = paramObject;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("LListPos[");
    localStringBuffer.append("index:");
    localStringBuffer.append(this.ipos);
    if (isAfter())
      localStringBuffer.append(" after");
    if (this.position >= 0)
    {
      localStringBuffer.append(" position:");
      localStringBuffer.append(this.position);
    }
    localStringBuffer.append(']');
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.LListPosition
 * JD-Core Version:    0.6.2
 */