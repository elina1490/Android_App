package gnu.mapping;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class SimpleSymbol extends Symbol
{
  public SimpleSymbol()
  {
  }

  public SimpleSymbol(String paramString)
  {
    super(Namespace.EmptyNamespace, paramString);
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.name = ((String)paramObjectInput.readObject()).intern();
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    return Namespace.EmptyNamespace.getSymbol(getName().intern());
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(getName());
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.SimpleSymbol
 * JD-Core Version:    0.6.2
 */