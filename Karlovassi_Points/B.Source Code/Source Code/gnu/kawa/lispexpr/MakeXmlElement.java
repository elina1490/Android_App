package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.MakeText;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class MakeXmlElement extends Syntax
{
  public static final MakeXmlElement makeXml = new MakeXmlElement();
  static final ClassType typeNamespace = ClassType.make("gnu.mapping.Namespace");

  static
  {
    makeXml.setName("$make-xml$");
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Pair localPair1 = (Pair)paramPair.getCdr();
    Object localObject1 = localPair1.getCar();
    Object localObject2 = localPair1.getCdr();
    int i = 0;
    NamespaceBinding localNamespaceBinding1 = paramTranslator.xmlElementNamespaces;
    Object localObject3 = localNamespaceBinding1;
    if ((localObject1 instanceof Pair))
    {
      if (i == 0)
      {
        paramTranslator.letStart();
        i = 1;
      }
      Pair localPair2 = (Pair)localObject1;
      Pair localPair3 = (Pair)localPair2.getCar();
      String str1 = (String)localPair3.getCar();
      String str2;
      Object localObject6;
      StringBuilder localStringBuilder;
      label107: Pair localPair4;
      Object localObject9;
      if (str1.length() == 0)
      {
        str2 = null;
        localObject6 = localPair3.getCdr();
        localStringBuilder = new StringBuilder();
        if (!(localObject6 instanceof Pair))
          break label250;
        localPair4 = (Pair)localObject6;
        Object localObject8 = localPair4.getCar();
        if ((LList.listLength(localObject8, false) != 2) || (!(localObject8 instanceof Pair)) || (((Pair)localObject8).getCar() != MakeText.makeText))
          break label224;
        localObject9 = ((Pair)((Pair)localObject8).getCdr()).getCar();
        label177: if (localObject9 != null)
          break label239;
        Object localObject10 = paramTranslator.pushPositionOf(localPair4);
        paramTranslator.error('e', "namespace URI must be literal");
        paramTranslator.popPositionOf(localObject10);
      }
      while (true)
      {
        localObject6 = localPair4.getCdr();
        break label107;
        str2 = str1.intern();
        break;
        label224: localObject9 = paramTranslator.rewrite_car(localPair4, false).valueIfConstant();
        break label177;
        label239: localStringBuilder.append(localObject9);
      }
      label250: String str3 = localStringBuilder.toString().intern();
      String str4;
      label270: NamespaceBinding localNamespaceBinding2;
      Object localObject7;
      if (str3 == "")
      {
        str4 = null;
        localNamespaceBinding2 = new NamespaceBinding(str2, str4, (NamespaceBinding)localObject3);
        if (str2 != null)
          break label364;
        localObject7 = Namespace.valueOf(str3);
        str2 = "[default-element-namespace]";
      }
      while (true)
      {
        Symbol localSymbol = Namespace.EmptyNamespace.getSymbol(str2);
        ClassType localClassType = typeNamespace;
        QuoteExp localQuoteExp = new QuoteExp(localObject7);
        paramTranslator.letVariable(localSymbol, localClassType, localQuoteExp).setFlag(2121728L);
        localObject1 = localPair2.getCdr();
        localObject3 = localNamespaceBinding2;
        break;
        str4 = str3;
        break label270;
        label364: localObject7 = XmlNamespace.getInstance(str2, str3);
      }
    }
    MakeElement localMakeElement = new MakeElement();
    localMakeElement.setNamespaceNodes((NamespaceBinding)localObject3);
    paramTranslator.xmlElementNamespaces = ((NamespaceBinding)localObject3);
    if (i != 0);
    try
    {
      paramTranslator.letEnter();
      Expression localExpression = paramTranslator.rewrite(Translator.makePair(paramPair, localMakeElement, localObject2));
      LetExp localLetExp;
      if (i != 0)
        localLetExp = paramTranslator.letDone(localExpression);
      for (Object localObject5 = localLetExp; ; localObject5 = localExpression)
        return localObject5;
    }
    finally
    {
      paramTranslator.xmlElementNamespaces = localNamespaceBinding1;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.MakeXmlElement
 * JD-Core Version:    0.6.2
 */