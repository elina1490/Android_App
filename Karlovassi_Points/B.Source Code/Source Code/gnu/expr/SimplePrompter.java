package gnu.expr;

import gnu.mapping.InPort;
import gnu.mapping.Procedure1;

class SimplePrompter extends Procedure1
{
  public String prefix = "[";
  public String suffix = "] ";

  public Object apply1(Object paramObject)
  {
    if ((paramObject instanceof InPort))
    {
      int i = 1 + ((InPort)paramObject).getLineNumber();
      if (i >= 0)
        return this.prefix + i + this.suffix;
    }
    return this.suffix;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.SimplePrompter
 * JD-Core Version:    0.6.2
 */