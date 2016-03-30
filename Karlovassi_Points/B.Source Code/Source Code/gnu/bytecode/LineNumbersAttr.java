package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public class LineNumbersAttr extends Attribute
{
  int linenumber_count;
  short[] linenumber_table;

  public LineNumbersAttr(CodeAttr paramCodeAttr)
  {
    super("LineNumberTable");
    addToFrontOf(paramCodeAttr);
    paramCodeAttr.lines = this;
  }

  public LineNumbersAttr(short[] paramArrayOfShort, CodeAttr paramCodeAttr)
  {
    this(paramCodeAttr);
    this.linenumber_table = paramArrayOfShort;
    this.linenumber_count = (paramArrayOfShort.length >> 1);
  }

  public final int getLength()
  {
    return 2 + 4 * this.linenumber_count;
  }

  public int getLineCount()
  {
    return this.linenumber_count;
  }

  public short[] getLineNumberTable()
  {
    return this.linenumber_table;
  }

  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    paramClassTypeWriter.print("Attribute \"");
    paramClassTypeWriter.print(getName());
    paramClassTypeWriter.print("\", length:");
    paramClassTypeWriter.print(getLength());
    paramClassTypeWriter.print(", count: ");
    paramClassTypeWriter.println(this.linenumber_count);
    for (int i = 0; i < this.linenumber_count; i++)
    {
      paramClassTypeWriter.print("  line: ");
      paramClassTypeWriter.print(0xFFFF & this.linenumber_table[(1 + i * 2)]);
      paramClassTypeWriter.print(" at pc: ");
      paramClassTypeWriter.println(0xFFFF & this.linenumber_table[(i * 2)]);
    }
  }

  public void put(int paramInt1, int paramInt2)
  {
    if (this.linenumber_table == null)
      this.linenumber_table = new short[32];
    while (true)
    {
      this.linenumber_table[(2 * this.linenumber_count)] = ((short)paramInt2);
      this.linenumber_table[(1 + 2 * this.linenumber_count)] = ((short)paramInt1);
      this.linenumber_count = (1 + this.linenumber_count);
      return;
      if (2 * this.linenumber_count >= this.linenumber_table.length)
      {
        short[] arrayOfShort = new short[2 * this.linenumber_table.length];
        System.arraycopy(this.linenumber_table, 0, arrayOfShort, 0, 2 * this.linenumber_count);
        this.linenumber_table = arrayOfShort;
      }
    }
  }

  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeShort(this.linenumber_count);
    int i = 2 * this.linenumber_count;
    for (int j = 0; j < i; j++)
      paramDataOutputStream.writeShort(this.linenumber_table[j]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.LineNumbersAttr
 * JD-Core Version:    0.6.2
 */