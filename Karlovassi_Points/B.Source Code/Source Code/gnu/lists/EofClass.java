package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class EofClass
  implements Externalizable
{
  public static final EofClass eofValue = new EofClass();

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    return Sequence.eofValue;
  }

  public final String toString()
  {
    return "#!eof";
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.EofClass
 * JD-Core Version:    0.6.2
 */