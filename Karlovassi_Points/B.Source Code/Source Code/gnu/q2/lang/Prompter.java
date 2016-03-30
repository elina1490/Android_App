package gnu.q2.lang;

import gnu.mapping.InPort;
import gnu.mapping.Procedure1;

class Prompter extends Procedure1
{
  public Object apply1(Object paramObject)
  {
    InPort localInPort = (InPort)paramObject;
    int i = 1 + localInPort.getLineNumber();
    char c = localInPort.readState;
    if (c == ']')
      return "<!--Q2:" + i + "-->";
    if (c == '\n')
      c = '-';
    return "#|--Q2:" + i + "|#" + c;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.q2.lang.Prompter
 * JD-Core Version:    0.6.2
 */