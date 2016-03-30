package kawa.lang;

import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ListRepeatPat extends Pattern
  implements Printable, Externalizable
{
  Pattern element_pattern;

  public ListRepeatPat()
  {
  }

  public ListRepeatPat(Pattern paramPattern)
  {
    this.element_pattern = paramPattern;
  }

  public static ListRepeatPat make(Pattern paramPattern)
  {
    return new ListRepeatPat(paramPattern);
  }

  public boolean match(Object paramObject, Object[] paramArrayOfObject, int paramInt)
  {
    int i = LList.listLength(paramObject, false);
    if (i < 0)
      return false;
    int j = this.element_pattern.varCount();
    int k = j;
    while (true)
    {
      k--;
      if (k < 0)
        break;
      paramArrayOfObject[(paramInt + k)] = new Object[i];
    }
    Object[] arrayOfObject = new Object[j];
    for (int m = 0; m < i; m++)
    {
      Pair localPair = (Pair)paramObject;
      if (!this.element_pattern.match(localPair.getCar(), arrayOfObject, 0))
        return false;
      for (int n = 0; n < j; n++)
        ((Object[])paramArrayOfObject[(paramInt + n)])[m] = arrayOfObject[n];
      paramObject = localPair.getCdr();
    }
    return true;
  }

  public void print(Consumer paramConsumer)
  {
    paramConsumer.write("#<list-repeat-pattern ");
    this.element_pattern.print(paramConsumer);
    paramConsumer.write(62);
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.element_pattern = ((Pattern)paramObjectInput.readObject());
  }

  public int varCount()
  {
    return this.element_pattern.varCount();
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.element_pattern);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.ListRepeatPat
 * JD-Core Version:    0.6.2
 */