package gnu.kawa.lispexpr;

import gnu.mapping.Procedure;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderMacro extends ReaderMisc
{
  Procedure procedure;

  public ReaderMacro(Procedure paramProcedure)
  {
    super(5);
    this.procedure = paramProcedure;
  }

  public ReaderMacro(Procedure paramProcedure, boolean paramBoolean)
  {
  }

  public Procedure getProcedure()
  {
    return this.procedure;
  }

  public boolean isNonTerminating()
  {
    return this.kind == 6;
  }

  public Object read(Lexer paramLexer, int paramInt1, int paramInt2)
    throws IOException, SyntaxException
  {
    LineBufferedReader localLineBufferedReader = paramLexer.getPort();
    try
    {
      Object localObject = this.procedure.apply2(localLineBufferedReader, Char.make(paramInt1));
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
 * Qualified Name:     gnu.kawa.lispexpr.ReaderMacro
 * JD-Core Version:    0.6.2
 */