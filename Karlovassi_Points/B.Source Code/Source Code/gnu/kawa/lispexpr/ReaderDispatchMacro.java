package gnu.kawa.lispexpr;

import gnu.mapping.Procedure;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderDispatchMacro extends ReaderMisc
{
  Procedure procedure;

  public ReaderDispatchMacro(Procedure paramProcedure)
  {
    super(5);
    this.procedure = paramProcedure;
  }

  public Procedure getProcedure()
  {
    return this.procedure;
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    LineBufferedReader localLineBufferedReader = paramLexer.getPort();
    try
    {
      Object localObject = this.procedure.apply3(localLineBufferedReader, Char.make(paramInt1), IntNum.make(paramInt2));
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw localIOException;
    }
    catch (SyntaxException localSyntaxException)
    {
      throw localSyntaxException;
    }
    catch (Throwable localThrowable)
    {
      paramLexer.fatal("reader macro '" + this.procedure + "' threw: " + localThrowable);
    }
    return null;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.ReaderDispatchMacro
 * JD-Core Version:    0.6.2
 */