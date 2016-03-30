package gnu.text;

import java.io.Writer;
import java.lang.ref.WeakReference;

class WriterRef extends WeakReference
{
  WriterRef next;
  WriterRef prev;

  public WriterRef(Writer paramWriter)
  {
    super(paramWriter);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.text.WriterRef
 * JD-Core Version:    0.6.2
 */