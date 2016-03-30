package gnu.mapping;

import gnu.lists.Sequence;

public class ValueStack extends Values
  implements Sequence
{
  public void clear()
  {
    this.oindex = 0;
    super.clear();
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.ValueStack
 * JD-Core Version:    0.6.2
 */