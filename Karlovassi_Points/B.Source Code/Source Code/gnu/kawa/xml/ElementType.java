package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.TypeValue;
import gnu.lists.AbstractSequence;
import gnu.lists.ElementPredicate;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.xml.namespace.QName;

public class ElementType extends NodeType
  implements TypeValue, Externalizable, ElementPredicate
{
  public static final String MATCH_ANY_LOCALNAME = "";
  public static final Symbol MATCH_ANY_QNAME = new Symbol(null, "");
  public static final ElementType anyElement = make(null, null);
  static final Method coerceMethod = typeElementType.getDeclaredMethod("coerce", 3);
  static final Method coerceOrNullMethod = typeElementType.getDeclaredMethod("coerceOrNull", 3);
  public static final ClassType typeElementType = ClassType.make("gnu.kawa.xml.ElementType");
  NamespaceBinding namespaceNodes;
  Symbol qname;

  public ElementType(Symbol paramSymbol)
  {
    this(null, paramSymbol);
  }

  public ElementType(String paramString, Symbol paramSymbol)
  {
  }

  public static KElement coerce(Object paramObject, String paramString1, String paramString2)
  {
    KElement localKElement = coerceOrNull(paramObject, paramString1, paramString2);
    if (localKElement == null)
      throw new ClassCastException();
    return localKElement;
  }

  public static KElement coerceOrNull(Object paramObject, String paramString1, String paramString2)
  {
    KElement localKElement = (KElement)NodeType.coerceOrNull(paramObject, 2);
    if (localKElement == null)
      return null;
    if ((paramString2 != null) && (paramString2.length() == 0))
      paramString2 = null;
    Object localObject = localKElement.getNextTypeObject();
    String str1;
    String str2;
    if ((localObject instanceof Symbol))
    {
      Symbol localSymbol = (Symbol)localObject;
      str1 = localSymbol.getNamespaceURI();
      str2 = localSymbol.getLocalName();
    }
    while (((paramString2 == str2) || (paramString2 == null)) && ((paramString1 == str1) || (paramString1 == null)))
    {
      return localKElement;
      if ((localObject instanceof QName))
      {
        QName localQName = (QName)localObject;
        str1 = localQName.getNamespaceURI();
        str2 = localQName.getLocalPart();
      }
      else
      {
        str1 = "";
        str2 = localObject.toString().intern();
      }
    }
    return null;
  }

  public static ElementType make(Symbol paramSymbol)
  {
    return new ElementType(paramSymbol);
  }

  public static ElementType make(String paramString1, String paramString2)
  {
    Symbol localSymbol;
    if (paramString1 != null)
      localSymbol = Symbol.make(paramString1, paramString2);
    while (true)
    {
      return new ElementType(localSymbol);
      if (paramString2 == "")
        localSymbol = MATCH_ANY_QNAME;
      else
        localSymbol = new Symbol(null, paramString2);
    }
  }

  public Object coerceFromObject(Object paramObject)
  {
    return coerce(paramObject, this.qname.getNamespaceURI(), this.qname.getLocalName());
  }

  public void emitCoerceFromObject(CodeAttr paramCodeAttr)
  {
    paramCodeAttr.emitPushString(this.qname.getNamespaceURI());
    paramCodeAttr.emitPushString(this.qname.getLocalName());
    paramCodeAttr.emitInvokeStatic(coerceMethod);
  }

  protected void emitCoerceOrNullMethod(Variable paramVariable, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (paramVariable != null)
      localCodeAttr.emitLoad(paramVariable);
    localCodeAttr.emitPushString(this.qname.getNamespaceURI());
    localCodeAttr.emitPushString(this.qname.getLocalName());
    localCodeAttr.emitInvokeStatic(coerceOrNullMethod);
  }

  public Procedure getConstructor()
  {
    MakeElement localMakeElement = new MakeElement();
    localMakeElement.tag = this.qname;
    localMakeElement.setHandlingKeywordParameters(true);
    if (this.namespaceNodes != null)
      localMakeElement.setNamespaceNodes(this.namespaceNodes);
    return localMakeElement;
  }

  public Type getImplementationType()
  {
    return ClassType.make("gnu.kawa.xml.KElement");
  }

  public final String getLocalName()
  {
    return this.qname.getLocalName();
  }

  public NamespaceBinding getNamespaceNodes()
  {
    return this.namespaceNodes;
  }

  public final String getNamespaceURI()
  {
    return this.qname.getNamespaceURI();
  }

  public boolean isInstance(AbstractSequence paramAbstractSequence, int paramInt, Object paramObject)
  {
    String str1 = this.qname.getNamespaceURI();
    String str2 = this.qname.getLocalName();
    String str3;
    String str4;
    if ((paramObject instanceof Symbol))
    {
      Symbol localSymbol = (Symbol)paramObject;
      str3 = localSymbol.getNamespaceURI();
      str4 = localSymbol.getLocalName();
    }
    while (true)
    {
      if ((str2 != null) && (str2.length() == 0))
        str2 = null;
      if (((str2 != str4) && (str2 != null)) || ((str1 != str3) && (str1 != null)))
        break;
      return true;
      if ((paramObject instanceof QName))
      {
        QName localQName = (QName)paramObject;
        str3 = localQName.getNamespaceURI();
        str4 = localQName.getLocalPart();
      }
      else
      {
        str3 = "";
        str4 = paramObject.toString().intern();
      }
    }
    return false;
  }

  public boolean isInstance(Object paramObject)
  {
    return coerceOrNull(paramObject, this.qname.getNamespaceURI(), this.qname.getLocalName()) != null;
  }

  public boolean isInstancePos(AbstractSequence paramAbstractSequence, int paramInt)
  {
    int i = paramAbstractSequence.getNextKind(paramInt);
    if (i == 33)
      return isInstance(paramAbstractSequence, paramInt, paramAbstractSequence.getNextTypeObject(paramInt));
    if (i == 32)
      return isInstance(paramAbstractSequence.getPosNext(paramInt));
    return false;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    String str = paramObjectInput.readUTF();
    if (str.length() > 0)
      setName(str);
    this.qname = ((Symbol)paramObjectInput.readObject());
  }

  public void setNamespaceNodes(NamespaceBinding paramNamespaceBinding)
  {
    this.namespaceNodes = paramNamespaceBinding;
  }

  public String toString()
  {
    return "ElementType " + this.qname;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    String str1 = getName();
    if (str1 == null);
    for (String str2 = ""; ; str2 = str1)
    {
      paramObjectOutput.writeUTF(str2);
      paramObjectOutput.writeObject(this.qname);
      return;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.xml.ElementType
 * JD-Core Version:    0.6.2
 */