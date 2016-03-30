package gnu.mapping;

import gnu.text.Path;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class TtyInPort extends InPort
{
  protected boolean promptEmitted;
  protected Procedure prompter;
  protected OutPort tie;

  public TtyInPort(InputStream paramInputStream, Path paramPath, OutPort paramOutPort)
  {
    super(paramInputStream, paramPath);
    setConvertCR(true);
    this.tie = paramOutPort;
  }

  public TtyInPort(Reader paramReader, Path paramPath, OutPort paramOutPort)
  {
    super(paramReader, paramPath);
    setConvertCR(true);
    this.tie = paramOutPort;
  }

  public void emitPrompt(String paramString)
    throws IOException
  {
    this.tie.print(paramString);
    this.tie.flush();
    this.tie.clearBuffer();
  }

  public int fill(int paramInt)
    throws IOException
  {
    int i = this.in.read(this.buffer, this.pos, paramInt);
    if ((this.tie != null) && (i > 0))
      this.tie.echo(this.buffer, this.pos, i);
    return i;
  }

  public Procedure getPrompter()
  {
    return this.prompter;
  }

  public void lineStart(boolean paramBoolean)
    throws IOException
  {
    if (!paramBoolean)
    {
      if (this.tie != null)
        this.tie.freshLine();
      if (this.prompter == null);
    }
    try
    {
      Object localObject = this.prompter.apply1(this);
      if (localObject != null)
      {
        String str = localObject.toString();
        if ((str != null) && (str.length() > 0))
        {
          emitPrompt(str);
          this.promptEmitted = true;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new IOException("Error when evaluating prompt:" + localThrowable);
    }
  }

  public int read()
    throws IOException
  {
    if (this.tie != null)
      this.tie.flush();
    int i = super.read();
    boolean bool1;
    if (i < 0)
    {
      bool1 = this.promptEmitted;
      if (this.tie == null)
        break label57;
    }
    label57: for (boolean bool2 = true; ; bool2 = false)
    {
      if ((bool1 & bool2))
        this.tie.println();
      this.promptEmitted = false;
      return i;
    }
  }

  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.tie != null)
      this.tie.flush();
    int i = super.read(paramArrayOfChar, paramInt1, paramInt2);
    boolean bool1;
    if (i < 0)
    {
      bool1 = this.promptEmitted;
      if (this.tie == null)
        break label67;
    }
    label67: for (boolean bool2 = true; ; bool2 = false)
    {
      if ((bool1 & bool2))
        this.tie.println();
      this.promptEmitted = false;
      return i;
    }
  }

  public void setPrompter(Procedure paramProcedure)
  {
    this.prompter = paramProcedure;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.TtyInPort
 * JD-Core Version:    0.6.2
 */