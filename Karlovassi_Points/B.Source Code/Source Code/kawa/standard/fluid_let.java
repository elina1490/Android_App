package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.expr.NameLookup;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class fluid_let extends Syntax
{
  public static final fluid_let fluid_let = new fluid_let();
  Expression defaultInit;
  boolean star;

  static
  {
    fluid_let.setName("fluid-set");
  }

  public fluid_let()
  {
    this.star = false;
  }

  public fluid_let(boolean paramBoolean, Expression paramExpression)
  {
    this.star = paramBoolean;
    this.defaultInit = paramExpression;
  }

  public Expression rewrite(Object paramObject1, Object paramObject2, Translator paramTranslator)
  {
    int i;
    if (this.star)
      i = 1;
    FluidLetExp localFluidLetExp;
    label398: 
    while (true)
    {
      Expression[] arrayOfExpression = new Expression[i];
      localFluidLetExp = new FluidLetExp(arrayOfExpression);
      int j = 0;
      label31: if (j < i)
      {
        Pair localPair1 = (Pair)paramObject1;
        Object localObject1 = paramTranslator.pushPositionOf(localPair1);
        try
        {
          Object localObject3 = localPair1.getCar();
          Object localObject4;
          if (((localObject3 instanceof String)) || ((localObject3 instanceof Symbol)))
            localObject4 = this.defaultInit;
          while (true)
          {
            Declaration localDeclaration1 = localFluidLetExp.addDeclaration(localObject3);
            Declaration localDeclaration2 = paramTranslator.lexical.lookup(localObject3, false);
            if (localDeclaration2 != null)
            {
              localDeclaration2.maybeIndirectBinding(paramTranslator);
              localDeclaration1.base = localDeclaration2;
              localDeclaration2.setFluid(true);
              localDeclaration2.setCanWrite(true);
            }
            localDeclaration1.setCanWrite(true);
            localDeclaration1.setFluid(true);
            localDeclaration1.setIndirectBinding(true);
            if (localObject4 == null)
              localObject4 = new ReferenceExp(localObject3);
            arrayOfExpression[j] = localObject4;
            localDeclaration1.noteValue(null);
            Object localObject5 = localPair1.getCdr();
            paramObject1 = localObject5;
            paramTranslator.popPositionOf(localObject1);
            j++;
            break label31;
            i = LList.length(paramObject1);
            break;
            if (!(localObject3 instanceof Pair))
              break label398;
            Pair localPair2 = (Pair)localObject3;
            if ((!(localPair2.getCar() instanceof String)) && (!(localPair2.getCar() instanceof Symbol)) && (!(localPair2.getCar() instanceof SyntaxForm)))
              break label398;
            localObject3 = localPair2.getCar();
            if ((localObject3 instanceof SyntaxForm))
              localObject3 = ((SyntaxForm)localObject3).getDatum();
            if (localPair2.getCdr() == LList.Empty)
            {
              localObject4 = this.defaultInit;
            }
            else
            {
              Pair localPair3;
              if ((localPair2.getCdr() instanceof Pair))
              {
                localPair3 = (Pair)localPair2.getCdr();
                if (localPair3.getCdr() == LList.Empty);
              }
              else
              {
                Expression localExpression2 = paramTranslator.syntaxError("bad syntax for value of " + localObject3 + " in " + getName());
                return localExpression2;
              }
              localObject4 = paramTranslator.rewrite(localPair3.getCar());
            }
          }
          Expression localExpression1 = paramTranslator.syntaxError("invalid " + getName() + " syntax");
          return localExpression1;
        }
        finally
        {
          paramTranslator.popPositionOf(localObject1);
        }
      }
    }
    paramTranslator.push(localFluidLetExp);
    if (this.star)
    {
      LList localLList = LList.Empty;
      if (paramObject1 == localLList);
    }
    for (localFluidLetExp.body = rewrite(paramObject1, paramObject2, paramTranslator); ; localFluidLetExp.body = paramTranslator.rewrite_body(paramObject2))
    {
      paramTranslator.pop(localFluidLetExp);
      return localFluidLetExp;
    }
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    if (!(paramObject instanceof Pair))
      return paramTranslator.syntaxError("missing let arguments");
    Pair localPair = (Pair)paramObject;
    return rewrite(localPair.getCar(), localPair.getCdr(), paramTranslator);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.fluid_let
 * JD-Core Version:    0.6.2
 */