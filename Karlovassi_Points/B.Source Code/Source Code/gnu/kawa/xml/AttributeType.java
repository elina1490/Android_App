package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.TypeValue;
import gnu.lists.AbstractSequence;
import gnu.lists.AttributePredicate;
import gnu.lists.SeqPosition;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.xml.namespace.QName;

public class AttributeType extends NodeType
  implements TypeValue, Externalizable, AttributePredicate
{
  static final Method coerceMethod = typeAttributeType.getDeclaredMethod("coerce", 3);
  static final Method coerceOrNullMethod = typeAttributeType.getDeclaredMethod("coerceOrNull", 3);
  public static final ClassType typeAttributeType = ClassType.make("gnu.kawa.xml.AttributeType");
  Symbol qname;

  public AttributeType(Symbol paramSymbol)
  {
    this(null, paramSymbol);
  }

  public AttributeType(String paramString, Symbol paramSymbol)
  {
  }

  public static SeqPosition coerce(Object paramObject, String paramString1, String paramString2)
  {
    KAttr localKAttr = coerceOrNull(paramObject, paramString1, paramString2);
    if (localKAttr == null)
      throw new ClassCastException();
    return localKAttr;
  }

  public static KAttr coerceOrNull(Object paramObject, String paramString1, String paramString2)
  {
    KNode localKNode = NodeType.coerceOrNull(paramObject, 4);
    if (localKNode == null)
      return null;
    if ((paramString2 != null) && (paramString2.length() == 0))
      paramString2 = null;
    Object localObject = localKNode.getNextTypeObject();
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
      return (KAttr)localKNode;
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

  public static AttributeType make(Symbol paramSymbol)
  {
    return new AttributeType(paramSymbol);
  }

  public static AttributeType make(String paramString1, String paramString2)
  {
    Symbol localSymbol;
    if (paramString1 != null)
      localSymbol = Symbol.make(paramString1, paramString2);
    while (true)
    {
      return new AttributeType(localSymbol);
      if (paramString2 == "")
        localSymbol = ElementType.MATCH_ANY_QNAME;
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

  public Type getImplementationType()
  {
    return ClassType.make("gnu.kawa.xml.KAttr");
  }

  public final String getLocalName()
  {
    return this.qname.getLocalName();
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
    if (i == 35)
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

  public String toString()
  {
    return "AttributeType " + this.qname;
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
 * Qualified Name:     gnu.kawa.xml.AttributeType
 * JD-Core Version:    0.6.2
 */