package kawa.lang;

import gnu.lists.Consumer;
import gnu.mapping.Symbol;
import gnu.text.Printable;
import gnu.text.ReportFormat;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class EqualPat extends Pattern
  implements Printable, Externalizable
{
  Object value;

  public EqualPat()
  {
  }

  public EqualPat(Object paramObject)
  {
    this.value = paramObject;
  }

  public static EqualPat make(Object paramObject)
  {
    return new EqualPat(paramObject);
  }

  public boolean match(Object paramObject, Object[] paramArrayOfObject, int paramInt)
  {
    if (((this.value instanceof String)) && ((paramObject instanceof Symbol)))
      paramObject = ((Symbol)paramObject).getName();
    return this.value.equals(paramObject);
  }

  public void print(Consumer paramConsumer)
  {
    paramConsumer.write("#<equals: ");
    ReportFormat.print(this.value, paramConsumer);
    paramConsumer.write(62);
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.value = paramObjectInput.readObject();
  }

  public int varCount()
  {
    return 0;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.value);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.EqualPat
 * JD-Core Version:    0.6.2
 */