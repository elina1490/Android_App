package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class define_class extends Syntax
{
  public static final define_class define_class = new define_class("define-class", false);
  public static final define_class define_simple_class = new define_class("define-simple-class", true);
  boolean isSimple;
  object objectSyntax;

  define_class(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.objectSyntax = object.objectSyntax;
    this.isSimple = paramBoolean;
  }

  define_class(object paramobject, boolean paramBoolean)
  {
    this.objectSyntax = paramobject;
    this.isSimple = paramBoolean;
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    boolean bool = localObject1 instanceof Pair;
    Declaration localDeclaration = null;
    if (bool)
    {
      paramPair = (Pair)localObject1;
      Object localObject2 = paramPair.getCar();
      if (!(localObject2 instanceof Declaration))
        return paramTranslator.syntaxError(getName() + " can only be used in <body>");
      localDeclaration = (Declaration)localObject2;
    }
    ClassExp localClassExp = (ClassExp)localDeclaration.getValue();
    this.objectSyntax.rewriteClassDef((Object[])paramPair.getCdr(), paramTranslator);
    SetExp localSetExp = new SetExp(localDeclaration, localClassExp);
    localSetExp.setDefining(true);
    return localSetExp;
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    SyntaxForm localSyntaxForm = null;
    while ((localObject1 instanceof SyntaxForm))
    {
      localSyntaxForm = (SyntaxForm)localObject1;
      localObject1 = localSyntaxForm.getDatum();
    }
    if (!(localObject1 instanceof Pair))
      return super.scanForDefinitions(paramPair, paramVector, paramScopeExp, paramTranslator);
    Pair localPair1 = (Pair)localObject1;
    for (Object localObject2 = localPair1.getCar(); (localObject2 instanceof SyntaxForm); localObject2 = localSyntaxForm.getDatum())
      localSyntaxForm = (SyntaxForm)localObject2;
    Object localObject3 = paramTranslator.namespaceResolve(localObject2);
    if ((!(localObject3 instanceof String)) && (!(localObject3 instanceof Symbol)))
    {
      paramTranslator.error('e', "missing class name");
      return false;
    }
    Declaration localDeclaration = paramTranslator.define(localObject3, localSyntaxForm, paramScopeExp);
    if ((localPair1 instanceof PairWithPosition))
      localDeclaration.setLocation((PairWithPosition)localPair1);
    ClassExp localClassExp = new ClassExp(this.isSimple);
    localDeclaration.noteValue(localClassExp);
    localDeclaration.setFlag(536887296L);
    ClassType localClassType;
    if (this.isSimple)
    {
      localClassType = Compilation.typeClass;
      localDeclaration.setType(localClassType);
      paramTranslator.mustCompileHere();
      if (!(localObject3 instanceof Symbol))
        break label334;
    }
    Object localObject4;
    label334: for (String str = ((Symbol)localObject3).getName(); ; str = localObject3.toString())
    {
      int i = str.length();
      if ((i > 2) && (str.charAt(0) == '<') && (str.charAt(i - 1) == '>'))
      {
        int j = i - 1;
        str = str.substring(1, j);
      }
      localClassExp.setName(str);
      for (localObject4 = localPair1.getCdr(); (localObject4 instanceof SyntaxForm); localObject4 = localSyntaxForm.getDatum())
        localSyntaxForm = (SyntaxForm)localObject4;
      localClassType = Compilation.typeClassType;
      break;
    }
    if (!(localObject4 instanceof Pair))
    {
      paramTranslator.error('e', "missing class members");
      return false;
    }
    Pair localPair2 = (Pair)localObject4;
    ScopeExp localScopeExp = paramTranslator.currentScope();
    if (localSyntaxForm != null)
      paramTranslator.setCurrentScope(localSyntaxForm.getScope());
    Object[] arrayOfObject = this.objectSyntax.scanClassDef(localPair2, localClassExp, paramTranslator);
    if (localSyntaxForm != null)
      paramTranslator.setCurrentScope(localScopeExp);
    if (arrayOfObject == null)
      return false;
    paramVector.addElement(Translator.makePair(paramPair, this, Translator.makePair(localPair2, localDeclaration, arrayOfObject)));
    return true;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.define_class
 * JD-Core Version:    0.6.2
 */