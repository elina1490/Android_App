package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.math.BaseUnit;
import gnu.math.Quantity;
import gnu.math.Unit;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class define_unit extends Syntax
{
  public static final define_unit define_base_unit;
  public static final define_unit define_unit = new define_unit(false);
  boolean base;

  static
  {
    define_unit.setName("define-unit");
    define_base_unit = new define_unit(true);
    define_base_unit.setName("define-base-unit");
  }

  public define_unit(boolean paramBoolean)
  {
    this.base = paramBoolean;
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Object localObject1 = paramPair.getCdr();
    Pair localPair;
    if ((localObject1 instanceof Pair))
    {
      localPair = (Pair)localObject1;
      if ((localPair.getCar() instanceof Declaration));
    }
    else
    {
      return paramTranslator.syntaxError("invalid syntax for " + getName());
    }
    Declaration localDeclaration = (Declaration)localPair.getCar();
    String str1 = ((Symbol)localDeclaration.getSymbol()).getLocalPart();
    ClassType localClassType = ClassType.make("gnu.math.Unit");
    localDeclaration.setType(localClassType);
    Object localObject2 = localDeclaration.getValue();
    if (((localObject2 instanceof QuoteExp)) && ((((QuoteExp)localObject2).getValue() instanceof Unit)));
    while (true)
    {
      SetExp localSetExp = new SetExp(localDeclaration, (Expression)localObject2);
      localSetExp.setDefining(true);
      localDeclaration.noteValue((Expression)localObject2);
      return localSetExp;
      if (this.base)
      {
        Object localObject4 = localPair.getCdr();
        LList localLList = LList.Empty;
        String str2 = null;
        if (localObject4 != localLList)
          str2 = ((Pair)localPair.getCdr()).getCar().toString();
        localObject2 = new QuoteExp(BaseUnit.make(str1, str2));
      }
      else
      {
        if (!(localPair.getCdr() instanceof Pair))
          return paramTranslator.syntaxError("missing value for define-unit");
        Expression localExpression = paramTranslator.rewrite(((Pair)localPair.getCdr()).getCar());
        if ((localExpression instanceof QuoteExp))
        {
          Object localObject3 = ((QuoteExp)localExpression).getValue();
          if ((localObject3 instanceof Quantity))
            localObject2 = new QuoteExp(Unit.make(str1, (Quantity)localObject3));
        }
        else
        {
          Expression[] arrayOfExpression = new Expression[2];
          QuoteExp localQuoteExp = new QuoteExp(str1);
          arrayOfExpression[0] = localQuoteExp;
          arrayOfExpression[1] = localExpression;
          localObject2 = Invoke.makeInvokeStatic(localClassType, "make", arrayOfExpression);
        }
      }
    }
  }

  public boolean scanForDefinitions(Pair paramPair, Vector paramVector, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    if ((paramPair.getCdr() instanceof Pair))
    {
      Pair localPair = (Pair)paramPair.getCdr();
      Object localObject1 = localPair.getCar();
      if ((localObject1 instanceof SimpleSymbol))
      {
        String str = localObject1.toString();
        Declaration localDeclaration = paramScopeExp.getDefine(Scheme.unitNamespace.getSymbol(str), 'w', paramTranslator);
        paramTranslator.push(localDeclaration);
        Translator.setLine(localDeclaration, localPair);
        localDeclaration.setFlag(16384L);
        if ((paramScopeExp instanceof ModuleExp))
          localDeclaration.setCanRead(true);
        Object localObject2;
        if ((this.base) && (localPair.getCdr() == LList.Empty))
          localObject2 = BaseUnit.make(str, (String)null);
        while (true)
        {
          if (localObject2 != null)
            localDeclaration.noteValue(new QuoteExp(localObject2));
          paramVector.addElement(Translator.makePair(paramPair, this, Translator.makePair(localPair, localDeclaration, localPair.getCdr())));
          return true;
          boolean bool1 = localPair.getCdr() instanceof Pair;
          localObject2 = null;
          if (bool1)
          {
            Object localObject3 = ((Pair)localPair.getCdr()).getCar();
            if ((this.base) && ((localObject3 instanceof CharSequence)))
            {
              localObject2 = BaseUnit.make(str, localObject3.toString());
            }
            else
            {
              boolean bool2 = this.base;
              localObject2 = null;
              if (!bool2)
              {
                boolean bool3 = localObject3 instanceof Quantity;
                localObject2 = null;
                if (bool3)
                  localObject2 = Unit.make(str, (Quantity)localObject3);
              }
            }
          }
        }
      }
    }
    paramTranslator.error('e', "missing name in define-unit");
    return false;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.define_unit
 * JD-Core Version:    0.6.2
 */