package gnu.expr;

import gnu.lists.Consumer;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class Keyword extends Symbol
  implements Printable, Externalizable
{
  public static final Namespace keywordNamespace = Namespace.create();

  static
  {
    keywordNamespace.setName("(keywords)");
  }

  public Keyword()
  {
  }

  public Keyword(Namespace paramNamespace, String paramString)
  {
    super(paramNamespace, paramString);
  }

  private Keyword(String paramString)
  {
    super(keywordNamespace, paramString);
  }

  public static boolean isKeyword(Object paramObject)
  {
    return paramObject instanceof Keyword;
  }

  public static Keyword make(String paramString)
  {
    int i = paramString.hashCode();
    Keyword localKeyword = (Keyword)keywordNamespace.lookup(paramString, i, false);
    if (localKeyword == null)
    {
      localKeyword = new Keyword(paramString);
      keywordNamespace.add(localKeyword, i);
    }
    return localKeyword;
  }

  public static Object searchForKeyword(Object[] paramArrayOfObject, int paramInt, Object paramObject)
  {
    for (int i = paramInt; i < paramArrayOfObject.length; i += 2)
      if (paramArrayOfObject[i] == paramObject)
        return paramArrayOfObject[(i + 1)];
    return Special.dfault;
  }

  public static Object searchForKeyword(Object[] paramArrayOfObject, int paramInt, Object paramObject1, Object paramObject2)
  {
    for (int i = paramInt; i < paramArrayOfObject.length; i += 2)
      if (paramArrayOfObject[i] == paramObject1)
        return paramArrayOfObject[(i + 1)];
    return paramObject2;
  }

  public Symbol asSymbol()
  {
    return Namespace.EmptyNamespace.getSymbol(getName());
  }

  public void print(Consumer paramConsumer)
  {
    Symbols.print(getName(), paramConsumer);
    paramConsumer.write(58);
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.name = ((String)paramObjectInput.readObject());
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    return make(keywordNamespace, getName());
  }

  public final String toString()
  {
    return getName() + ':';
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(getName());
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.Keyword
 * JD-Core Version:    0.6.2
 */