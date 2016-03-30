package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.mapping.InPort;
import gnu.mapping.WrappedException;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompileFile
{
  public static final Compilation read(InPort paramInPort, SourceMessages paramSourceMessages)
    throws IOException, SyntaxException
  {
    return Language.getDefaultLanguage().parse(paramInPort, paramSourceMessages, 0);
  }

  public static final Compilation read(String paramString, SourceMessages paramSourceMessages)
    throws IOException, SyntaxException
  {
    try
    {
      InPort localInPort = InPort.openFile(paramString);
      Compilation localCompilation = read(localInPort, paramSourceMessages);
      localInPort.close();
      return localCompilation;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      throw new WrappedException("compile-file: file not found: " + paramString, localFileNotFoundException);
    }
    catch (IOException localIOException)
    {
      throw new WrappedException("compile-file: read-error: " + paramString, localIOException);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.CompileFile
 * JD-Core Version:    0.6.2
 */