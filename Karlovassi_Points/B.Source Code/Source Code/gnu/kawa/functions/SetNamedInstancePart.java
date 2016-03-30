package gnu.kawa.functions;

import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class SetNamedInstancePart extends Procedure2
  implements Externalizable
{
  String pname;

  public SetNamedInstancePart()
  {
    setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateSetNamedInstancePart");
  }

  public SetNamedInstancePart(String paramString)
  {
    this();
    setPartName(paramString);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    SlotSet.setField(paramObject1, this.pname, paramObject2);
    return Values.empty;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    setPartName((String)paramObjectInput.readObject());
  }

  public void setPartName(String paramString)
  {
    setName("set-instance-part:." + paramString);
    this.pname = paramString;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.pname);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.SetNamedInstancePart
 * JD-Core Version:    0.6.2
 */