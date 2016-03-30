package gnu.lists;

import gnu.text.SourceLocator;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PairWithPosition extends ImmutablePair
  implements SourceLocator
{
  String filename;
  int position;

  public PairWithPosition()
  {
  }

  public PairWithPosition(SourceLocator paramSourceLocator, Object paramObject1, Object paramObject2)
  {
    super(paramObject1, paramObject2);
    this.filename = paramSourceLocator.getFileName();
    setLine(paramSourceLocator.getLineNumber(), paramSourceLocator.getColumnNumber());
  }

  public PairWithPosition(Object paramObject1, Object paramObject2)
  {
    super(paramObject1, paramObject2);
  }

  public static PairWithPosition make(Object paramObject1, Object paramObject2, String paramString, int paramInt)
  {
    PairWithPosition localPairWithPosition = new PairWithPosition(paramObject1, paramObject2);
    localPairWithPosition.filename = paramString;
    localPairWithPosition.position = paramInt;
    return localPairWithPosition;
  }

  public static PairWithPosition make(Object paramObject1, Object paramObject2, String paramString, int paramInt1, int paramInt2)
  {
    PairWithPosition localPairWithPosition = new PairWithPosition(paramObject1, paramObject2);
    localPairWithPosition.filename = paramString;
    localPairWithPosition.setLine(paramInt1, paramInt2);
    return localPairWithPosition;
  }

  public final int getColumnNumber()
  {
    int i = 0xFFF & this.position;
    if (i == 0)
      return -1;
    return i;
  }

  public final String getFileName()
  {
    return this.filename;
  }

  public final int getLineNumber()
  {
    int i = this.position >> 12;
    if (i == 0)
      return -1;
    return i;
  }

  public String getPublicId()
  {
    return null;
  }

  public String getSystemId()
  {
    return this.filename;
  }

  public boolean isStableSourceLocation()
  {
    return true;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.car = paramObjectInput.readObject();
    this.cdr = paramObjectInput.readObject();
    this.filename = ((String)paramObjectInput.readObject());
    this.position = paramObjectInput.readInt();
  }

  public final void setFile(String paramString)
  {
    this.filename = paramString;
  }

  public final void setLine(int paramInt)
  {
    setLine(paramInt, 0);
  }

  public final void setLine(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 < 0)
      paramInt2 = 0;
    this.position = (paramInt2 + (paramInt1 << 12));
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.car);
    paramObjectOutput.writeObject(this.cdr);
    paramObjectOutput.writeObject(this.filename);
    paramObjectOutput.writeInt(this.position);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.lists.PairWithPosition
 * JD-Core Version:    0.6.2
 */