package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class DefineNamespace extends Syntax
{
  public static final String XML_NAMESPACE_MAGIC = "&xml&";
  public static final DefineNamespace define_namespace = new DefineNamespace();
  public static final DefineNamespace define_private_namespace = new DefineNamespace();
  public static final DefineNamespace define_xml_namespace = new DefineNamespace();
  private boolean makePrivate;
  private boolean makeXML;

  static
  {
    define_namespace.setName("define-namespace");
    define_private_namespace.setName("define-private-namespace");
    define_private_namespace.makePrivate = true;
    define_xml_namespace.setName("define-xml-namespace");
    define_xml_namespace.makeXML = true;
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    return paramTranslator.syntaxError("define-namespace is only allowed in a <body>");
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Pair localPair1;
    Pair localPair2;
    if ((paramPair.getCdr() instanceof Pair))
    {
      localPair1 = (Pair)paramPair.getCdr();
      if (((localPair1.getCar() instanceof Symbol)) && ((localPair1.getCdr() instanceof Pair)))
      {
        localPair2 = (Pair)localPair1.getCdr();
        if (localPair2.getCdr() == LList.Empty)
          break label73;
      }
    }
    paramTranslator.error('e', "invalid syntax for define-namespace");
    return false;
    label73: Symbol localSymbol = (Symbol)localPair1.getCar();
    Declaration localDeclaration = paramScopeExp.getDefine(localSymbol, 'w', paramTranslator);
    paramTranslator.push(localDeclaration);
    localDeclaration.setFlag(2375680L);
    String str;
    Object localObject2;
    label196: Object localObject1;
    if (this.makePrivate)
    {
      localDeclaration.setFlag(16777216L);
      localDeclaration.setPrivate(true);
      Translator.setLine(localDeclaration, localPair1);
      if (!(localPair2.getCar() instanceof CharSequence))
        break label303;
      str = localPair2.getCar().toString();
      if (!str.startsWith("class:"))
        break label251;
      localObject2 = ClassNamespace.getInstance(str, ClassType.make(str.substring(6)));
      localDeclaration.setType(ClassType.make("gnu.kawa.lispexpr.ClassNamespace"));
      localObject1 = new QuoteExp(localObject2);
      localDeclaration.setFlag(8192L);
    }
    while (true)
    {
      localDeclaration.noteValue((Expression)localObject1);
      paramVector.addElement(SetExp.makeDefinition(localDeclaration, (Expression)localObject1));
      return true;
      if (!(paramScopeExp instanceof ModuleExp))
        break;
      localDeclaration.setCanRead(true);
      break;
      label251: if (this.makeXML)
      {
        localObject2 = XmlNamespace.getInstance(localSymbol.getName(), str);
        localDeclaration.setType(ClassType.make("gnu.kawa.xml.XmlNamespace"));
        break label196;
      }
      localObject2 = Namespace.valueOf(str);
      localDeclaration.setType(ClassType.make("gnu.mapping.Namespace"));
      break label196;
      label303: localObject1 = paramTranslator.rewrite_car(localPair2, false);
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.DefineNamespace
 * JD-Core Version:    0.6.2
 */