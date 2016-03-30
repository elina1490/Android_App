package gnu.mapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;

public class Namespace
  implements Externalizable, HasNamedParts
{
  public static final Namespace EmptyNamespace = valueOf("");
  protected static final Hashtable nsTable = new Hashtable(50);
  int log2Size;
  private int mask;
  String name;
  int num_bindings;
  protected String prefix = "";
  protected SymbolRef[] table;

  protected Namespace()
  {
    this(64);
  }

  protected Namespace(int paramInt)
  {
    for (this.log2Size = 4; paramInt > 1 << this.log2Size; this.log2Size = (1 + this.log2Size));
    int i = 1 << this.log2Size;
    this.table = new SymbolRef[i];
    this.mask = (i - 1);
  }

  public static Namespace create()
  {
    return new Namespace(64);
  }

  public static Namespace create(int paramInt)
  {
    return new Namespace(paramInt);
  }

  public static Namespace getDefault()
  {
    return EmptyNamespace;
  }

  public static Symbol getDefaultSymbol(String paramString)
  {
    return EmptyNamespace.getSymbol(paramString);
  }

  public static Namespace makeUnknownNamespace(String paramString)
  {
    if ((paramString == null) || (paramString == ""));
    for (String str = ""; ; str = "http://kawa.gnu.org/unknown-namespace/" + paramString)
      return valueOf(str, paramString);
  }

  public static Namespace valueOf()
  {
    return EmptyNamespace;
  }

  public static Namespace valueOf(String paramString)
  {
    if (paramString == null)
      paramString = "";
    synchronized (nsTable)
    {
      Namespace localNamespace1 = (Namespace)nsTable.get(paramString);
      if (localNamespace1 != null)
        return localNamespace1;
      Namespace localNamespace2 = new Namespace();
      localNamespace2.setName(paramString.intern());
      nsTable.put(paramString, localNamespace2);
      return localNamespace2;
    }
  }

  public static Namespace valueOf(String paramString, SimpleSymbol paramSimpleSymbol)
  {
    if (paramSimpleSymbol == null);
    for (String str = null; ; str = paramSimpleSymbol.getName())
      return valueOf(paramString, str);
  }

  public static Namespace valueOf(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0))
      return valueOf(paramString1);
    String str = paramString2 + " -> " + paramString1;
    synchronized (nsTable)
    {
      Object localObject2 = nsTable.get(str);
      if ((localObject2 instanceof Namespace))
      {
        Namespace localNamespace2 = (Namespace)localObject2;
        return localNamespace2;
      }
      Namespace localNamespace1 = new Namespace();
      localNamespace1.setName(paramString1.intern());
      localNamespace1.prefix = paramString2.intern();
      nsTable.put(str, localNamespace1);
      return localNamespace1;
    }
  }

  public Symbol add(Symbol paramSymbol, int paramInt)
  {
    int i = paramInt & this.mask;
    SymbolRef localSymbolRef = new SymbolRef(paramSymbol, this);
    paramSymbol.namespace = this;
    localSymbolRef.next = this.table[i];
    this.table[i] = localSymbolRef;
    this.num_bindings = (1 + this.num_bindings);
    if (this.num_bindings >= this.table.length)
      rehash();
    return paramSymbol;
  }

  public Object get(String paramString)
  {
    return Environment.getCurrent().get(getSymbol(paramString));
  }

  public final String getName()
  {
    return this.name;
  }

  public final String getPrefix()
  {
    return this.prefix;
  }

  public Symbol getSymbol(String paramString)
  {
    return lookup(paramString, paramString.hashCode(), true);
  }

  public boolean isConstant(String paramString)
  {
    return false;
  }

  public Symbol lookup(String paramString)
  {
    return lookup(paramString, paramString.hashCode(), false);
  }

  public Symbol lookup(String paramString, int paramInt, boolean paramBoolean)
  {
    while (true)
    {
      try
      {
        Symbol localSymbol1 = lookupInternal(paramString, paramInt);
        if (localSymbol1 != null)
          return localSymbol1;
        if (!paramBoolean)
          break;
        if (this == EmptyNamespace)
        {
          localObject2 = new SimpleSymbol(paramString);
          Symbol localSymbol2 = add((Symbol)localObject2, paramInt);
          return localSymbol2;
        }
      }
      finally
      {
      }
      Object localObject2 = new Symbol(this, paramString);
    }
    return null;
  }

  protected final Symbol lookupInternal(String paramString, int paramInt)
  {
    int i = paramInt & this.mask;
    Object localObject1 = null;
    Object localObject2 = this.table[i];
    if (localObject2 != null)
    {
      SymbolRef localSymbolRef = ((SymbolRef)localObject2).next;
      Symbol localSymbol = ((SymbolRef)localObject2).getSymbol();
      if (localSymbol == null)
        if (localObject1 == null)
        {
          this.table[i] = localSymbolRef;
          label55: this.num_bindings -= 1;
        }
      while (true)
      {
        localObject2 = localSymbolRef;
        break;
        localObject1.next = localSymbolRef;
        break label55;
        if (localSymbol.getLocalPart().equals(paramString))
          return localSymbol;
        localObject1 = localObject2;
      }
    }
    return null;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.name = ((String)paramObjectInput.readObject()).intern();
    this.prefix = ((String)paramObjectInput.readObject());
  }

  public Object readResolve()
    throws ObjectStreamException
  {
    String str1 = getName();
    if (str1 != null)
    {
      if ((this.prefix == null) || (this.prefix.length() == 0));
      for (String str2 = str1; ; str2 = this.prefix + " -> " + str1)
      {
        Namespace localNamespace = (Namespace)nsTable.get(str2);
        if (localNamespace == null)
          break;
        return localNamespace;
      }
      nsTable.put(str2, this);
    }
    return this;
  }

  protected void rehash()
  {
    int i = this.table.length;
    int j = i * 2;
    int k = j - 1;
    int m = 0;
    SymbolRef[] arrayOfSymbolRef1 = this.table;
    SymbolRef[] arrayOfSymbolRef2 = new SymbolRef[j];
    int n = i;
    while (true)
    {
      n--;
      if (n < 0)
        break;
      SymbolRef localSymbolRef;
      for (Object localObject = arrayOfSymbolRef1[n]; localObject != null; localObject = localSymbolRef)
      {
        localSymbolRef = ((SymbolRef)localObject).next;
        Symbol localSymbol = ((SymbolRef)localObject).getSymbol();
        if (localSymbol != null)
        {
          int i1 = k & localSymbol.getName().hashCode();
          m++;
          ((SymbolRef)localObject).next = arrayOfSymbolRef2[i1];
          arrayOfSymbolRef2[i1] = localObject;
        }
      }
    }
    this.table = arrayOfSymbolRef2;
    this.log2Size = (1 + this.log2Size);
    this.mask = k;
    this.num_bindings = m;
  }

  public boolean remove(Symbol paramSymbol)
  {
    while (true)
    {
      SymbolRef localSymbolRef;
      try
      {
        int i = paramSymbol.getLocalPart().hashCode() & this.mask;
        localObject2 = null;
        localObject3 = this.table[i];
        if (localObject3 == null)
          break;
        localSymbolRef = ((SymbolRef)localObject3).next;
        Symbol localSymbol = ((SymbolRef)localObject3).getSymbol();
        if ((localSymbol == null) || (localSymbol == paramSymbol))
        {
          if (localObject2 == null)
          {
            this.table[i] = localSymbolRef;
            this.num_bindings -= 1;
            if (localSymbol == null)
              break label107;
            return true;
          }
          localObject2.next = localSymbolRef;
          continue;
        }
      }
      finally
      {
      }
      Object localObject2 = localObject3;
      label107: Object localObject3 = localSymbolRef;
    }
    return false;
  }

  public final void setName(String paramString)
  {
    this.name = paramString;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("#,(namespace \"");
    localStringBuilder.append(this.name);
    localStringBuilder.append('"');
    if ((this.prefix != null) && (this.prefix != ""))
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(this.prefix);
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(getName());
    paramObjectOutput.writeObject(this.prefix);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.mapping.Namespace
 * JD-Core Version:    0.6.2
 */