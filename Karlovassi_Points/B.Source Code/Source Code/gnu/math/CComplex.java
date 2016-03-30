package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CComplex extends Complex
  implements Externalizable
{
  RealNum imag;
  RealNum real;

  public CComplex()
  {
  }

  public CComplex(RealNum paramRealNum1, RealNum paramRealNum2)
  {
    this.real = paramRealNum1;
    this.imag = paramRealNum2;
  }

  public RealNum im()
  {
    return this.imag;
  }

  public RealNum re()
  {
    return this.real;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.real = ((RealNum)paramObjectInput.readObject());
    this.imag = ((RealNum)paramObjectInput.readObject());
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.real);
    paramObjectOutput.writeObject(this.imag);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.math.CComplex
 * JD-Core Version:    0.6.2
 */