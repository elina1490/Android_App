package gnu.ecmascript;

import gnu.mapping.InPort;
import gnu.mapping.Procedure1;

class Prompter extends Procedure1
{
  public Object apply1(Object paramObject)
  {
    return prompt((InPort)paramObject);
  }

  String prompt(InPort paramInPort)
  {
    return "(EcmaScript:" + (1 + paramInPort.getLineNumber()) + ") ";
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.ecmascript.Prompter
 * JD-Core Version:    0.6.2
 */