package gnu.kawa.lispexpr;

public class ReaderMisc extends ReadTableEntry
{
  int kind;

  public ReaderMisc(int paramInt)
  {
    this.kind = paramInt;
  }

  public int getKind()
  {
    return this.kind;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderMisc
 * JD-Core Version:    0.6.2
 */