package kawa.standard;

import gnu.mapping.Environment;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import kawa.Shell;

public class load extends Procedure1
{
  public static final load load = new load("load", false);
  public static final load loadRelative = new load("load-relative", true);
  boolean relative;

  public load(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.relative = paramBoolean;
  }

  public final Object apply1(Object paramObject)
    throws Throwable
  {
    return apply2(paramObject, Environment.getCurrent());
  }

  public final Object apply2(Object paramObject1, Object paramObject2)
    throws Throwable
  {
    try
    {
      Environment localEnvironment = (Environment)paramObject2;
      Path localPath1 = Path.valueOf(paramObject1);
      if (this.relative)
      {
        Path localPath2 = (Path)Shell.currentLoadPath.get();
        if (localPath2 != null)
          localPath1 = localPath2.resolve(localPath1);
      }
      Shell.runFile(localPath1.openInputStream(), localPath1, localEnvironment, true, 0);
      Values localValues = Values.empty;
      return localValues;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      throw new RuntimeException("cannot load " + localFileNotFoundException.getMessage());
    }
    catch (SyntaxException localSyntaxException)
    {
      throw new RuntimeException("load: errors while compiling '" + paramObject1 + "':\n" + localSyntaxException.getMessages().toString(20));
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.load
 * JD-Core Version:    0.6.2
 */