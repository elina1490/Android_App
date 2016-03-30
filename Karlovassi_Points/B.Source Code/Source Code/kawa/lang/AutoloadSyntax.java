package kawa.lang;

import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import gnu.mapping.Environment;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrongArguments;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintWriter;

public class AutoloadSyntax extends Syntax
  implements Externalizable
{
  String className;
  Environment env;
  Syntax loaded;

  public AutoloadSyntax()
  {
  }

  public AutoloadSyntax(String paramString1, String paramString2)
  {
    super(paramString1);
    this.className = paramString2;
  }

  public AutoloadSyntax(String paramString1, String paramString2, Environment paramEnvironment)
  {
    super(paramString1);
    this.className = paramString2;
    this.env = paramEnvironment;
  }

  private void throw_error(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(this.className).append(" while autoloading ");
    if (getName() == null);
    for (String str = ""; ; str = getName().toString())
      throw new GenericError(str);
  }

  void load()
  {
    String str = getName();
    try
    {
      Object localObject = Class.forName(this.className).newInstance();
      if ((localObject instanceof Syntax))
      {
        this.loaded = ((Syntax)localObject);
        if ((str != null) && (this.loaded.getName() == null))
          this.loaded.setName(str);
      }
      else
      {
        throw_error("failed to autoload valid syntax object ");
        return;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw_error("failed to find class ");
      return;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw_error("failed to instantiate class ");
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw_error("illegal access in class ");
      return;
    }
    catch (UnboundLocationException localUnboundLocationException)
    {
      throw_error("missing symbol '" + localUnboundLocationException.getMessage() + "' ");
      return;
    }
    catch (WrongArguments localWrongArguments)
    {
      throw_error("type error");
    }
  }

  public void print(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print(toString());
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    setName((String)paramObjectInput.readObject());
    this.className = ((String)paramObjectInput.readObject());
  }

  // ERROR //
  public gnu.expr.Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	kawa/lang/AutoloadSyntax:loaded	Lkawa/lang/Syntax;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 121	kawa/lang/AutoloadSyntax:load	()V
    //   11: aload_2
    //   12: getfield 126	kawa/lang/Translator:currentSyntax	Lkawa/lang/Syntax;
    //   15: astore_3
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 75	kawa/lang/AutoloadSyntax:loaded	Lkawa/lang/Syntax;
    //   21: putfield 126	kawa/lang/Translator:currentSyntax	Lkawa/lang/Syntax;
    //   24: aload_0
    //   25: getfield 75	kawa/lang/AutoloadSyntax:loaded	Lkawa/lang/Syntax;
    //   28: aload_1
    //   29: aload_2
    //   30: invokevirtual 128	kawa/lang/Syntax:rewriteForm	(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    //   33: astore 5
    //   35: aload_2
    //   36: aload_3
    //   37: putfield 126	kawa/lang/Translator:currentSyntax	Lkawa/lang/Syntax;
    //   40: aload 5
    //   42: areturn
    //   43: astore 7
    //   45: aload_2
    //   46: aload 7
    //   48: invokevirtual 129	kawa/lang/GenericError:getMessage	()Ljava/lang/String;
    //   51: invokevirtual 133	kawa/lang/Translator:syntaxError	(Ljava/lang/String;)Lgnu/expr/Expression;
    //   54: areturn
    //   55: astore 6
    //   57: aload_2
    //   58: aload 6
    //   60: invokevirtual 134	gnu/mapping/WrongType:getMessage	()Ljava/lang/String;
    //   63: invokevirtual 133	kawa/lang/Translator:syntaxError	(Ljava/lang/String;)Lgnu/expr/Expression;
    //   66: areturn
    //   67: astore 4
    //   69: aload_2
    //   70: aload_3
    //   71: putfield 126	kawa/lang/Translator:currentSyntax	Lkawa/lang/Syntax;
    //   74: aload 4
    //   76: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   7	11	43	kawa/lang/GenericError
    //   7	11	55	gnu/mapping/WrongType
    //   24	35	67	finally
  }

  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    if (this.loaded == null);
    try
    {
      load();
      this.loaded.scanForm(paramPair, paramScopeExp, paramTranslator);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramTranslator.syntaxError(localRuntimeException.getMessage());
    }
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    localStringBuffer.append("#<syntax ");
    if (getName() != null)
    {
      localStringBuffer.append(getName());
      localStringBuffer.append(' ');
    }
    if (this.loaded != null)
      localStringBuffer.append("autoloaded>");
    while (true)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("autoload ");
      localStringBuffer.append(this.className);
      localStringBuffer.append(">");
    }
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(getName());
    paramObjectOutput.writeObject(this.className);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.AutoloadSyntax
 * JD-Core Version:    0.6.2
 */