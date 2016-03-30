package gnu.kawa.models;

import gnu.lists.CharBuffer;
import java.io.Serializable;

public class Text extends Model
  implements Viewable, Serializable
{
  public final CharBuffer buffer = new CharBuffer(100);

  public Text()
  {
    this("");
  }

  public Text(String paramString)
  {
    this.buffer.gapEnd = 99;
    this.buffer.getArray()[this.buffer.gapEnd] = 10;
    setText(paramString);
  }

  public CharBuffer getBuffer()
  {
    return this.buffer;
  }

  public String getText()
  {
    int i = this.buffer.size() - 1;
    int j = this.buffer.getSegment(0, i);
    return new String(this.buffer.getArray(), j, i);
  }

  public void makeView(Display paramDisplay, Object paramObject)
  {
    paramDisplay.addText(this, paramObject);
  }

  public void setText(String paramString)
  {
    int i = this.buffer.size() - 1;
    if (i > 0)
      this.buffer.delete(0, i);
    this.buffer.insert(0, paramString, false);
    notifyListeners("text");
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.models.Text
 * JD-Core Version:    0.6.2
 */