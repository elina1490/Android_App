package gnu.bytecode;

import java.util.ArrayList;
import java.util.Iterator;

public class Label
{
  int first_fixup;
  Type[] localTypes;
  boolean needsStackMapEntry;
  int position;
  Type[] stackTypes;
  private Object[] typeChangeListeners;

  public Label()
  {
    this(-1);
  }

  public Label(int paramInt)
  {
    this.position = paramInt;
  }

  public Label(CodeAttr paramCodeAttr)
  {
    this(-1);
  }

  private void mergeLocalType(int paramInt, Type paramType)
  {
    Type localType1 = this.localTypes[paramInt];
    Type localType2 = mergeTypes(localType1, paramType);
    this.localTypes[paramInt] = localType2;
    if (localType2 != localType1)
      notifyTypeChangeListeners(paramInt, localType2);
  }

  private void notifyTypeChangeListeners(int paramInt, Type paramType)
  {
    Object[] arrayOfObject = this.typeChangeListeners;
    if ((arrayOfObject == null) || (arrayOfObject.length <= paramInt));
    Object localObject;
    do
    {
      return;
      localObject = arrayOfObject[paramInt];
    }
    while (localObject == null);
    if ((localObject instanceof Label))
      ((Label)localObject).mergeLocalType(paramInt, paramType);
    while (paramType == null)
    {
      arrayOfObject[paramInt] = null;
      return;
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
        ((Label)localIterator.next()).mergeLocalType(paramInt, paramType);
    }
  }

  void addTypeChangeListener(int paramInt, Label paramLabel)
  {
    Object[] arrayOfObject = this.typeChangeListeners;
    if (arrayOfObject == null)
    {
      arrayOfObject = new Object[paramInt + 10];
      this.typeChangeListeners = arrayOfObject;
    }
    Object localObject;
    while (true)
    {
      localObject = arrayOfObject[paramInt];
      if (localObject != null)
        break;
      arrayOfObject[paramInt] = paramLabel;
      return;
      if (arrayOfObject.length <= paramInt)
      {
        arrayOfObject = new Object[paramInt + 10];
        System.arraycopy(this.typeChangeListeners, 0, arrayOfObject, 0, this.typeChangeListeners.length);
        this.typeChangeListeners = arrayOfObject;
      }
    }
    ArrayList localArrayList;
    if ((localObject instanceof Label))
    {
      localArrayList = new ArrayList();
      localArrayList.add((Label)localObject);
      arrayOfObject[paramInt] = localArrayList;
    }
    while (true)
    {
      localArrayList.add(paramLabel);
      return;
      localArrayList = (ArrayList)localObject;
    }
  }

  void addTypeChangeListeners(CodeAttr paramCodeAttr)
  {
    if ((paramCodeAttr.local_types != null) && (paramCodeAttr.previousLabel != null))
    {
      int i = paramCodeAttr.local_types.length;
      for (int j = 0; j < i; j++)
        if ((paramCodeAttr.local_types[j] != null) && ((paramCodeAttr.varsSetInCurrentBlock == null) || (paramCodeAttr.varsSetInCurrentBlock.length <= j) || (paramCodeAttr.varsSetInCurrentBlock[j] == 0)))
          paramCodeAttr.previousLabel.addTypeChangeListener(j, this);
    }
  }

  public void define(CodeAttr paramCodeAttr)
  {
    if (paramCodeAttr.reachableHere())
      setTypes(paramCodeAttr);
    while (true)
    {
      paramCodeAttr.previousLabel = this;
      paramCodeAttr.varsSetInCurrentBlock = null;
      defineRaw(paramCodeAttr);
      if (this.localTypes != null)
        paramCodeAttr.setTypes(this);
      paramCodeAttr.setReachable(true);
      return;
      if (this.localTypes != null)
      {
        int i = this.localTypes.length;
        while (true)
        {
          i--;
          if (i < 0)
            break;
          if ((this.localTypes[i] != null) && ((paramCodeAttr.locals.used == null) || (paramCodeAttr.locals.used[i] == null)))
            this.localTypes[i] = null;
        }
      }
    }
  }

  public void defineRaw(CodeAttr paramCodeAttr)
  {
    if (this.position >= 0)
      throw new Error("label definition more than once");
    this.position = paramCodeAttr.PC;
    this.first_fixup = paramCodeAttr.fixup_count;
    if (this.first_fixup >= 0)
      paramCodeAttr.fixupAdd(1, this);
  }

  public final boolean defined()
  {
    return this.position >= 0;
  }

  Type mergeTypes(Type paramType1, Type paramType2)
  {
    if (paramType1 instanceof PrimType != paramType2 instanceof PrimType)
      return null;
    return Type.lowestCommonSuperType(paramType1, paramType2);
  }

  public void setTypes(CodeAttr paramCodeAttr)
  {
    addTypeChangeListeners(paramCodeAttr);
    if ((this.stackTypes != null) && (paramCodeAttr.SP != this.stackTypes.length))
      throw new InternalError();
    Type[] arrayOfType = paramCodeAttr.local_types;
    if (paramCodeAttr.local_types == null);
    for (int i = 0; ; i = paramCodeAttr.local_types.length)
    {
      setTypes(arrayOfType, i, paramCodeAttr.stack_types, paramCodeAttr.SP);
      return;
    }
  }

  public void setTypes(Label paramLabel)
  {
    setTypes(paramLabel.localTypes, paramLabel.localTypes.length, paramLabel.stackTypes, paramLabel.stackTypes.length);
  }

  void setTypes(Type[] paramArrayOfType1, int paramInt1, Type[] paramArrayOfType2, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramArrayOfType1[(paramInt1 - 1)] != null))
    {
      if (this.stackTypes != null)
        break label93;
      if (paramInt2 != 0)
        break label49;
      this.stackTypes = Type.typeArray0;
      label31: if (paramInt1 != 0)
        break label73;
      this.localTypes = Type.typeArray0;
    }
    while (true)
    {
      return;
      paramInt1--;
      break;
      label49: this.stackTypes = new Type[paramInt2];
      System.arraycopy(paramArrayOfType2, 0, this.stackTypes, 0, paramInt2);
      break label31;
      label73: this.localTypes = new Type[paramInt1];
      System.arraycopy(paramArrayOfType1, 0, this.localTypes, 0, paramInt1);
      return;
      label93: if (paramInt2 != this.stackTypes.length)
        throw new InternalError("inconsistent stack length");
      for (int i = 0; i < paramInt2; i++)
        this.stackTypes[i] = mergeTypes(this.stackTypes[i], paramArrayOfType2[i]);
      if (paramInt1 < this.localTypes.length);
      for (int j = paramInt1; ; j = this.localTypes.length)
        for (int k = 0; k < j; k++)
          mergeLocalType(k, paramArrayOfType1[k]);
      for (int m = paramInt1; m < this.localTypes.length; m++)
        this.localTypes[m] = null;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.Label
 * JD-Core Version:    0.6.2
 */