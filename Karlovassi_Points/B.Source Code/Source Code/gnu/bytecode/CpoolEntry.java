package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class CpoolEntry
{
  int hash;
  public int index;
  CpoolEntry next;

  protected CpoolEntry()
  {
  }

  public CpoolEntry(ConstantPool paramConstantPool, int paramInt)
  {
    this.hash = paramInt;
    if (paramConstantPool.locked)
      throw new Error("adding new entry to locked contant pool");
    int i = 1 + paramConstantPool.count;
    paramConstantPool.count = i;
    this.index = i;
    if (paramConstantPool.pool == null)
      paramConstantPool.pool = new CpoolEntry[60];
    while (true)
    {
      if ((paramConstantPool.hashTab == null) || (this.index >= 0.6D * paramConstantPool.hashTab.length))
        paramConstantPool.rehash();
      paramConstantPool.pool[this.index] = this;
      add_hashed(paramConstantPool);
      return;
      if (this.index >= paramConstantPool.pool.length)
      {
        int j = paramConstantPool.pool.length;
        CpoolEntry[] arrayOfCpoolEntry = new CpoolEntry[2 * paramConstantPool.pool.length];
        for (int k = 0; k < j; k++)
          arrayOfCpoolEntry[k] = paramConstantPool.pool[k];
        paramConstantPool.pool = arrayOfCpoolEntry;
      }
    }
  }

  void add_hashed(ConstantPool paramConstantPool)
  {
    CpoolEntry[] arrayOfCpoolEntry = paramConstantPool.hashTab;
    int i = (0x7FFFFFFF & this.hash) % arrayOfCpoolEntry.length;
    this.next = arrayOfCpoolEntry[i];
    arrayOfCpoolEntry[i] = this;
  }

  public int getIndex()
  {
    return this.index;
  }

  public abstract int getTag();

  public int hashCode()
  {
    return this.hash;
  }

  public abstract void print(ClassTypeWriter paramClassTypeWriter, int paramInt);

  abstract void write(DataOutputStream paramDataOutputStream)
    throws IOException;
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.CpoolEntry
 * JD-Core Version:    0.6.2
 */