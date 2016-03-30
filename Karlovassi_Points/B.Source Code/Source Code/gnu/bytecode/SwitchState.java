package gnu.bytecode;

public class SwitchState
{
  Label after_label;
  Label cases_label;
  Label defaultLabel;
  Label[] labels;
  int maxValue;
  int minValue;
  int numCases;
  TryState outerTry;
  Label switch_label;
  int[] values;

  public SwitchState(CodeAttr paramCodeAttr)
  {
    this.switch_label = new Label(paramCodeAttr);
    this.cases_label = new Label(paramCodeAttr);
    this.after_label = new Label(paramCodeAttr);
    this.outerTry = paramCodeAttr.try_stack;
    this.numCases = 0;
  }

  public boolean addCase(int paramInt, CodeAttr paramCodeAttr)
  {
    Label localLabel = new Label(paramCodeAttr);
    localLabel.setTypes(this.cases_label);
    localLabel.define(paramCodeAttr);
    return insertCase(paramInt, localLabel, paramCodeAttr);
  }

  public boolean addCaseGoto(int paramInt, CodeAttr paramCodeAttr, Label paramLabel)
  {
    boolean bool = insertCase(paramInt, paramLabel, paramCodeAttr);
    paramLabel.setTypes(this.cases_label);
    paramCodeAttr.setUnreachable();
    return bool;
  }

  public void addDefault(CodeAttr paramCodeAttr)
  {
    Label localLabel = new Label(paramCodeAttr);
    localLabel.setTypes(this.cases_label);
    localLabel.define(paramCodeAttr);
    if (this.defaultLabel != null)
      throw new Error();
    this.defaultLabel = localLabel;
  }

  public void exitSwitch(CodeAttr paramCodeAttr)
  {
    if (this.outerTry != paramCodeAttr.try_stack)
      throw new Error("exitSwitch cannot exit through a try");
    paramCodeAttr.emitGoto(this.after_label);
  }

  public void finish(CodeAttr paramCodeAttr)
  {
    if (this.defaultLabel == null)
    {
      this.defaultLabel = new Label(paramCodeAttr);
      this.defaultLabel.define(paramCodeAttr);
      ClassType localClassType = ClassType.make("java.lang.RuntimeException");
      paramCodeAttr.emitNew(localClassType);
      paramCodeAttr.emitDup(localClassType);
      paramCodeAttr.emitPushString("bad case value!");
      Type[] arrayOfType = new Type[1];
      arrayOfType[0] = Type.string_type;
      paramCodeAttr.emitInvokeSpecial(localClassType.addMethod("<init>", 1, arrayOfType, Type.voidType));
      paramCodeAttr.emitThrow();
    }
    paramCodeAttr.fixupChain(this.switch_label, this.after_label);
    if (this.numCases <= 1)
    {
      paramCodeAttr.pushType(Type.intType);
      if (this.numCases == 1)
        if (this.minValue == 0)
        {
          paramCodeAttr.emitIfIntEqZero();
          paramCodeAttr.emitGoto(this.labels[0]);
          paramCodeAttr.emitElse();
          paramCodeAttr.emitGoto(this.defaultLabel);
          paramCodeAttr.emitFi();
        }
    }
    while (true)
    {
      paramCodeAttr.fixupChain(this.after_label, this.cases_label);
      return;
      paramCodeAttr.emitPushInt(this.minValue);
      paramCodeAttr.emitIfEq();
      break;
      paramCodeAttr.emitPop(1);
      paramCodeAttr.emitGoto(this.defaultLabel);
      continue;
      if (2 * this.numCases >= this.maxValue - this.minValue)
      {
        paramCodeAttr.reserve(13 + 4 * (1 + (this.maxValue - this.minValue)));
        paramCodeAttr.fixupAdd(2, null);
        paramCodeAttr.put1(170);
        paramCodeAttr.fixupAdd(3, this.defaultLabel);
        paramCodeAttr.PC = (4 + paramCodeAttr.PC);
        paramCodeAttr.put4(this.minValue);
        paramCodeAttr.put4(this.maxValue);
        int j = 0;
        int k = this.minValue;
        label296: Label localLabel;
        if (k <= this.maxValue)
        {
          if (this.values[j] != k)
            break label359;
          Label[] arrayOfLabel = this.labels;
          int m = j + 1;
          localLabel = arrayOfLabel[j];
          j = m;
        }
        while (true)
        {
          paramCodeAttr.fixupAdd(3, localLabel);
          paramCodeAttr.PC = (4 + paramCodeAttr.PC);
          k++;
          break label296;
          break;
          label359: localLabel = this.defaultLabel;
        }
      }
      paramCodeAttr.reserve(9 + 8 * this.numCases);
      paramCodeAttr.fixupAdd(2, null);
      paramCodeAttr.put1(171);
      paramCodeAttr.fixupAdd(3, this.defaultLabel);
      paramCodeAttr.PC = (4 + paramCodeAttr.PC);
      paramCodeAttr.put4(this.numCases);
      for (int i = 0; i < this.numCases; i++)
      {
        paramCodeAttr.put4(this.values[i]);
        paramCodeAttr.fixupAdd(3, this.labels[i]);
        paramCodeAttr.PC = (4 + paramCodeAttr.PC);
      }
    }
  }

  public int getMaxValue()
  {
    return this.maxValue;
  }

  public int getNumCases()
  {
    return this.numCases;
  }

  public boolean insertCase(int paramInt, Label paramLabel, CodeAttr paramCodeAttr)
  {
    if (this.values == null)
    {
      this.values = new int[10];
      this.labels = new Label[10];
      this.numCases = 1;
      this.maxValue = paramInt;
      this.minValue = paramInt;
      this.values[0] = paramInt;
      this.labels[0] = paramLabel;
      return true;
    }
    int[] arrayOfInt = this.values;
    Label[] arrayOfLabel = this.labels;
    if (this.numCases >= this.values.length)
    {
      this.values = new int[2 * this.numCases];
      this.labels = new Label[2 * this.numCases];
    }
    int k;
    if (paramInt < this.minValue)
    {
      k = 0;
      this.minValue = paramInt;
    }
    do
    {
      while (true)
      {
        int m = this.numCases - k;
        System.arraycopy(arrayOfInt, k, this.values, k + 1, m);
        System.arraycopy(arrayOfInt, 0, this.values, 0, k);
        this.values[k] = paramInt;
        System.arraycopy(arrayOfLabel, k, this.labels, k + 1, m);
        System.arraycopy(arrayOfLabel, 0, this.labels, 0, k);
        this.labels[k] = paramLabel;
        this.numCases = (1 + this.numCases);
        return true;
        if (paramInt <= this.maxValue)
          break;
        k = this.numCases;
        this.maxValue = paramInt;
      }
      int i = 0;
      int j = this.numCases - 1;
      k = 0;
      while (i <= j)
      {
        k = i + j >>> 1;
        if (arrayOfInt[k] >= paramInt)
        {
          j = k - 1;
        }
        else
        {
          k++;
          i = k;
        }
      }
    }
    while (paramInt != arrayOfInt[k]);
    return false;
  }

  public void switchValuePushed(CodeAttr paramCodeAttr)
  {
    paramCodeAttr.popType();
    this.cases_label.setTypes(paramCodeAttr);
    paramCodeAttr.fixupChain(this.cases_label, this.switch_label);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.SwitchState
 * JD-Core Version:    0.6.2
 */