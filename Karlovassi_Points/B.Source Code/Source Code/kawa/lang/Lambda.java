package kawa.lang;

import gnu.bytecode.Type;
import gnu.expr.BeginExp;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.ThisExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.SourceMessages;
import kawa.standard.object;

public class Lambda extends Syntax
{
  public static final Keyword nameKeyword = Keyword.make("name");
  public Expression defaultDefault = QuoteExp.falseExp;
  public Object keyKeyword;
  public Object optionalKeyword;
  public Object restKeyword;

  private static void addParam(Declaration paramDeclaration, ScopeExp paramScopeExp, LambdaExp paramLambdaExp, Translator paramTranslator)
  {
    if (paramScopeExp != null)
      paramDeclaration = paramTranslator.makeRenamedAlias(paramDeclaration, paramScopeExp);
    paramLambdaExp.addDeclaration(paramDeclaration);
    if (paramScopeExp != null)
      paramDeclaration.context = paramScopeExp;
  }

  public void print(Consumer paramConsumer)
  {
    paramConsumer.write("#<builtin lambda>");
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    if (!(paramObject instanceof Pair))
      return paramTranslator.syntaxError("missing formals in lambda");
    int i = paramTranslator.getMessages().getErrorCount();
    LambdaExp localLambdaExp = new LambdaExp();
    Pair localPair = (Pair)paramObject;
    Translator.setLine(localLambdaExp, localPair);
    rewrite(localLambdaExp, localPair.getCar(), localPair.getCdr(), paramTranslator, null);
    if (paramTranslator.getMessages().getErrorCount() > i)
      return new ErrorExp("bad lambda expression");
    return localLambdaExp;
  }

  public void rewrite(LambdaExp paramLambdaExp, Object paramObject1, Object paramObject2, Translator paramTranslator, TemplateScope paramTemplateScope)
  {
    rewriteFormals(paramLambdaExp, paramObject1, paramTranslator, paramTemplateScope);
    if ((paramObject2 instanceof PairWithPosition))
      paramLambdaExp.setFile(((PairWithPosition)paramObject2).getFileName());
    rewriteBody(paramLambdaExp, rewriteAttrs(paramLambdaExp, paramObject2, paramTranslator), paramTranslator);
  }

  public Object rewriteAttrs(LambdaExp paramLambdaExp, Object paramObject, Translator paramTranslator)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    int j = 0;
    SyntaxForm localSyntaxForm1 = null;
    while ((paramObject instanceof SyntaxForm))
    {
      localSyntaxForm1 = (SyntaxForm)paramObject;
      paramObject = localSyntaxForm1.getDatum();
    }
    if (!(paramObject instanceof Pair));
    Object localObject3;
    SyntaxForm localSyntaxForm2;
    Object localObject4;
    do
      while (true)
      {
        int k = i | j;
        if (k != 0)
          paramLambdaExp.nameDecl.setFlag(k);
        if (localSyntaxForm1 != null)
          paramObject = SyntaxForms.fromDatumIfNeeded(paramObject, localSyntaxForm1);
        return paramObject;
        Pair localPair1 = (Pair)paramObject;
        localObject3 = Translator.stripSyntax(localPair1.getCar());
        if (paramTranslator.matches(localObject3, "::"))
          localObject3 = null;
        while ((localObject3 instanceof Keyword))
        {
          localSyntaxForm2 = localSyntaxForm1;
          for (localObject4 = localPair1.getCdr(); (localObject4 instanceof SyntaxForm); localObject4 = localSyntaxForm2.getDatum())
            localSyntaxForm2 = (SyntaxForm)localObject4;
        }
      }
    while (!(localObject4 instanceof Pair));
    Pair localPair2 = (Pair)localObject4;
    if (localObject3 == null)
      if ((paramLambdaExp.isClassMethod()) && ("*init*".equals(paramLambdaExp.getName())))
        paramTranslator.error('e', "explicit return type for '*init*' method");
    while (true)
    {
      paramObject = localPair2.getCdr();
      break;
      paramLambdaExp.body = new LangExp(new Object[] { localPair2, localSyntaxForm2 });
      continue;
      Keyword localKeyword1 = object.accessKeyword;
      if (localObject3 == localKeyword1)
      {
        Expression localExpression3 = paramTranslator.rewrite_car(localPair2, localSyntaxForm2);
        Object localObject7;
        if ((localExpression3 instanceof QuoteExp))
        {
          localObject7 = ((QuoteExp)localExpression3).getValue();
          if (((localObject7 instanceof SimpleSymbol)) || ((localObject7 instanceof CharSequence)));
        }
        else
        {
          paramTranslator.error('e', "access: value not a constant symbol or string");
          continue;
        }
        if (paramLambdaExp.nameDecl == null)
        {
          paramTranslator.error('e', "access: not allowed for anonymous function");
        }
        else
        {
          String str2 = localObject7.toString();
          if ("private".equals(str2))
            i = 16777216;
          while (true)
          {
            if ((localObject1 != null) && (str2 != null))
              paramTranslator.error('e', "duplicate access specifiers - " + (String)localObject1 + " and " + str2);
            localObject1 = str2;
            break;
            if ("protected".equals(str2))
              i = 33554432;
            else if ("public".equals(str2))
              i = 67108864;
            else if ("package".equals(str2))
              i = 134217728;
            else
              paramTranslator.error('e', "unknown access specifier");
          }
        }
      }
      else
      {
        Keyword localKeyword2 = object.allocationKeyword;
        if (localObject3 == localKeyword2)
        {
          Expression localExpression2 = paramTranslator.rewrite_car(localPair2, localSyntaxForm2);
          Object localObject6;
          if ((localExpression2 instanceof QuoteExp))
          {
            localObject6 = ((QuoteExp)localExpression2).getValue();
            if (((localObject6 instanceof SimpleSymbol)) || ((localObject6 instanceof CharSequence)));
          }
          else
          {
            paramTranslator.error('e', "allocation: value not a constant symbol or string");
            continue;
          }
          if (paramLambdaExp.nameDecl == null)
          {
            paramTranslator.error('e', "allocation: not allowed for anonymous function");
          }
          else
          {
            String str1 = localObject6.toString();
            if (("class".equals(str1)) || ("static".equals(str1)))
              j = 2048;
            while (true)
            {
              if ((localObject2 != null) && (str1 != null))
                paramTranslator.error('e', "duplicate allocation specifiers - " + (String)localObject2 + " and " + str1);
              localObject2 = str1;
              break;
              if ("instance".equals(str1))
                j = 4096;
              else
                paramTranslator.error('e', "unknown allocation specifier");
            }
          }
        }
        else
        {
          Keyword localKeyword3 = object.throwsKeyword;
          if (localObject3 == localKeyword3)
          {
            Object localObject5 = localPair2.getCar();
            int m = Translator.listLength(localObject5);
            if (m < 0)
            {
              paramTranslator.error('e', "throws: not followed by a list");
            }
            else
            {
              Expression[] arrayOfExpression = new Expression[m];
              SyntaxForm localSyntaxForm3 = localSyntaxForm2;
              for (int n = 0; n < m; n++)
              {
                while ((localObject5 instanceof SyntaxForm))
                {
                  localSyntaxForm3 = (SyntaxForm)localObject5;
                  localObject5 = localSyntaxForm3.getDatum();
                }
                Pair localPair3 = (Pair)localObject5;
                arrayOfExpression[n] = paramTranslator.rewrite_car(localPair3, localSyntaxForm3);
                Translator.setLine(arrayOfExpression[n], localPair3);
                localObject5 = localPair3.getCdr();
              }
              paramLambdaExp.setExceptions(arrayOfExpression);
            }
          }
          else
          {
            Keyword localKeyword4 = nameKeyword;
            if (localObject3 == localKeyword4)
            {
              Expression localExpression1 = paramTranslator.rewrite_car(localPair2, localSyntaxForm2);
              if ((localExpression1 instanceof QuoteExp))
                paramLambdaExp.setName(((QuoteExp)localExpression1).getValue().toString());
            }
            else
            {
              paramTranslator.error('w', "unknown procedure property " + localObject3);
            }
          }
        }
      }
    }
  }

  public void rewriteBody(LambdaExp paramLambdaExp, Object paramObject, Translator paramTranslator)
  {
    int i = 0;
    if ((paramTranslator.curMethodLambda == null) && (paramLambdaExp.nameDecl != null) && (paramTranslator.getModule().getFlag(131072)))
      paramTranslator.curMethodLambda = paramLambdaExp;
    paramTranslator.currentScope();
    paramTranslator.pushScope(paramLambdaExp);
    Object localObject1 = null;
    int j;
    if (paramLambdaExp.keywords == null)
    {
      j = 0;
      if (paramLambdaExp.defaultArgs != null)
        break label278;
    }
    label278: for (int k = 0; ; k = paramLambdaExp.defaultArgs.length - j)
    {
      int m = 0;
      int n = 0;
      for (Object localObject2 = paramLambdaExp.firstDecl(); localObject2 != null; localObject2 = ((Declaration)localObject2).nextDecl())
      {
        if (((Declaration)localObject2).isAlias())
        {
          Declaration localDeclaration = Translator.getOriginalRef((Declaration)localObject2).getBinding();
          paramLambdaExp.replaceFollowing((Declaration)localObject1, localDeclaration);
          localDeclaration.context = paramLambdaExp;
          paramTranslator.pushRenamedAlias((Declaration)localObject2);
          i++;
          localObject2 = localDeclaration;
        }
        Expression localExpression3 = ((Declaration)localObject2).getTypeExp();
        if ((localExpression3 instanceof LangExp))
        {
          Type localType2 = paramTranslator.exp2Type((Pair)((LangExp)localExpression3).getLangValue());
          ((Declaration)localObject2).setType(localType2);
        }
        localObject1 = localObject2;
        int i3 = paramLambdaExp.min_args;
        if (m >= i3)
        {
          int i4 = k + paramLambdaExp.min_args;
          if ((m >= i4) && (paramLambdaExp.max_args < 0))
          {
            int i5 = k + paramLambdaExp.min_args;
            if (m == i5);
          }
          else
          {
            paramLambdaExp.defaultArgs[n] = paramTranslator.rewrite(paramLambdaExp.defaultArgs[n]);
            n++;
          }
        }
        m++;
        paramTranslator.lexical.push((Declaration)localObject2);
      }
      j = paramLambdaExp.keywords.length;
      break;
    }
    if ((paramLambdaExp.isClassMethod()) && (!paramLambdaExp.nameDecl.getFlag(2048L)))
      paramLambdaExp.add(null, new Declaration(ThisExp.THIS_NAME));
    LambdaExp localLambdaExp = paramTranslator.curLambda;
    paramTranslator.curLambda = paramLambdaExp;
    Type localType1 = paramLambdaExp.returnType;
    if ((paramLambdaExp.body instanceof LangExp))
    {
      Object[] arrayOfObject = (Object[])((LangExp)paramLambdaExp.body).getLangValue();
      Expression localExpression2 = paramTranslator.rewrite_car((Pair)arrayOfObject[0], (SyntaxForm)arrayOfObject[1]);
      localType1 = paramTranslator.getLanguage().getTypeFor(localExpression2);
    }
    paramLambdaExp.body = paramTranslator.rewrite_body(paramObject);
    paramTranslator.curLambda = localLambdaExp;
    Expression[] arrayOfExpression1;
    int i2;
    if ((paramLambdaExp.body instanceof BeginExp))
    {
      arrayOfExpression1 = ((BeginExp)paramLambdaExp.body).getExpressions();
      int i1 = arrayOfExpression1.length;
      if (i1 > 1)
        if (!(arrayOfExpression1[0] instanceof ReferenceExp))
        {
          Object localObject3 = arrayOfExpression1[0].valueIfConstant();
          if ((!(localObject3 instanceof Type)) && (!(localObject3 instanceof Class)));
        }
        else
        {
          Expression localExpression1 = arrayOfExpression1[0];
          i2 = i1 - 1;
          if (i2 == 1)
          {
            paramLambdaExp.body = arrayOfExpression1[1];
            paramLambdaExp.setCoercedReturnValue(localExpression1, paramTranslator.getLanguage());
          }
        }
    }
    while (true)
    {
      paramTranslator.pop(paramLambdaExp);
      paramLambdaExp.countDecls();
      paramTranslator.popRenamedAlias(i);
      paramLambdaExp.countDecls();
      if (paramTranslator.curMethodLambda == paramLambdaExp)
        paramTranslator.curMethodLambda = null;
      return;
      Expression[] arrayOfExpression2 = new Expression[i2];
      System.arraycopy(arrayOfExpression1, 1, arrayOfExpression2, 0, i2);
      paramLambdaExp.body = BeginExp.canonicalize(arrayOfExpression2);
      break;
      paramLambdaExp.setCoercedReturnType(localType1);
    }
  }

  public Expression rewriteForm(Pair paramPair, Translator paramTranslator)
  {
    Expression localExpression = rewrite(paramPair.getCdr(), paramTranslator);
    Translator.setLine(localExpression, paramPair);
    return localExpression;
  }

  public void rewriteFormals(LambdaExp paramLambdaExp, Object paramObject, Translator paramTranslator, TemplateScope paramTemplateScope)
  {
    if (paramLambdaExp.getSymbol() == null)
    {
      String str2 = paramLambdaExp.getFileName();
      int i3 = paramLambdaExp.getLineNumber();
      if ((str2 != null) && (i3 > 0))
        paramLambdaExp.setSourceLocation(str2, i3);
    }
    Object localObject1 = paramObject;
    int i = -1;
    int j = -1;
    int k = -1;
    if ((localObject1 instanceof SyntaxForm))
      localObject1 = ((SyntaxForm)localObject1).getDatum();
    if (!(localObject1 instanceof Pair))
    {
      if (!(localObject1 instanceof Symbol))
        break label613;
      if ((i >= 0) || (k >= 0) || (j >= 0))
        paramTranslator.syntaxError("dotted rest-arg after " + this.optionalKeyword + ", " + this.restKeyword + ", or " + this.keyKeyword);
    }
    else
    {
      Pair localPair1 = (Pair)localObject1;
      Object localObject2 = localPair1.getCar();
      if ((localObject2 instanceof SyntaxForm))
        localObject2 = ((SyntaxForm)localObject2).getDatum();
      Object localObject3 = this.optionalKeyword;
      if (localObject2 == localObject3)
      {
        if (i >= 0)
        {
          paramTranslator.syntaxError("multiple " + this.optionalKeyword + " in parameter list");
          return;
        }
        if ((j >= 0) || (k >= 0))
        {
          paramTranslator.syntaxError(this.optionalKeyword.toString() + " after " + this.restKeyword + " or " + this.keyKeyword);
          return;
        }
        i = 0;
      }
      while (true)
      {
        localPair1.getCdr();
        localObject1 = localPair1.getCdr();
        break;
        Object localObject4 = this.restKeyword;
        if (localObject2 == localObject4)
        {
          if (j >= 0)
          {
            paramTranslator.syntaxError("multiple " + this.restKeyword + " in parameter list");
            return;
          }
          if (k >= 0)
          {
            paramTranslator.syntaxError(this.restKeyword.toString() + " after " + this.keyKeyword);
            return;
          }
          j = 0;
        }
        else
        {
          Object localObject5 = this.keyKeyword;
          if (localObject2 == localObject5)
          {
            if (k >= 0)
            {
              paramTranslator.syntaxError("multiple " + this.keyKeyword + " in parameter list");
              return;
            }
            k = 0;
          }
          else if ((paramTranslator.matches(localPair1.getCar(), "::")) && ((localPair1.getCdr() instanceof Pair)))
          {
            localPair1 = (Pair)localPair1.getCdr();
          }
          else if (k >= 0)
          {
            k++;
          }
          else if (j >= 0)
          {
            j++;
          }
          else if (i >= 0)
          {
            i++;
          }
          else
          {
            paramLambdaExp.min_args = (1 + paramLambdaExp.min_args);
          }
        }
      }
    }
    j = 1;
    while (j > 1)
    {
      paramTranslator.syntaxError("multiple " + this.restKeyword + " parameters");
      return;
      label613: LList localLList = LList.Empty;
      if (localObject1 != localLList)
      {
        paramTranslator.syntaxError("misformed formals in lambda");
        return;
      }
    }
    if (i < 0)
      i = 0;
    if (j < 0)
      j = 0;
    if (k < 0)
      k = 0;
    label668: Object localObject6;
    int m;
    int n;
    Object localObject7;
    if (j > 0)
    {
      paramLambdaExp.max_args = -1;
      if (i + k > 0)
        paramLambdaExp.defaultArgs = new Expression[i + k];
      if (k > 0)
        paramLambdaExp.keywords = new Keyword[k];
      localObject6 = paramObject;
      m = 0;
      n = 0;
      localObject7 = null;
    }
    TemplateScope localTemplateScope;
    Object localObject8;
    Object localObject9;
    while (true)
    {
      if ((localObject6 instanceof SyntaxForm))
      {
        SyntaxForm localSyntaxForm4 = (SyntaxForm)localObject6;
        localObject6 = localSyntaxForm4.getDatum();
        paramTemplateScope = localSyntaxForm4.getScope();
      }
      localTemplateScope = paramTemplateScope;
      if (!(localObject6 instanceof Pair))
      {
        if ((localObject6 instanceof SyntaxForm))
        {
          SyntaxForm localSyntaxForm3 = (SyntaxForm)localObject6;
          localObject6 = localSyntaxForm3.getDatum();
          paramTemplateScope = localSyntaxForm3.getScope();
        }
        if (!(localObject6 instanceof Symbol))
          break;
        Declaration localDeclaration2 = new Declaration(localObject6);
        localDeclaration2.setType(LangObjType.listType);
        localDeclaration2.setFlag(262144L);
        localDeclaration2.noteValue(null);
        addParam(localDeclaration2, paramTemplateScope, paramLambdaExp, paramTranslator);
        return;
        paramLambdaExp.max_args = (i + paramLambdaExp.min_args + k * 2);
        break label668;
      }
      localObject8 = (Pair)localObject6;
      localObject9 = ((Pair)localObject8).getCar();
      if ((localObject9 instanceof SyntaxForm))
      {
        SyntaxForm localSyntaxForm2 = (SyntaxForm)localObject9;
        localObject9 = localSyntaxForm2.getDatum();
        localTemplateScope = localSyntaxForm2.getScope();
      }
      Object localObject10 = this.optionalKeyword;
      if (localObject9 != localObject10)
      {
        Object localObject11 = this.restKeyword;
        if (localObject9 != localObject11)
        {
          Object localObject12 = this.keyKeyword;
          if (localObject9 != localObject12)
            break label962;
        }
      }
      localObject7 = localObject9;
      localObject6 = ((Pair)localObject8).getCdr();
    }
    label962: Object localObject13 = paramTranslator.pushPositionOf(localObject8);
    Object localObject14 = this.defaultDefault;
    if (paramTranslator.matches(localObject9, "::"))
    {
      paramTranslator.syntaxError("'::' must follow parameter name");
      return;
    }
    Object localObject15 = paramTranslator.namespaceResolve(localObject9);
    Object localObject16;
    Object localObject18;
    Object localObject17;
    if ((localObject15 instanceof Symbol))
    {
      localObject16 = localObject15;
      if (!(((Pair)localObject8).getCdr() instanceof Pair))
        break label1846;
      Pair localPair5 = (Pair)((Pair)localObject8).getCdr();
      if (!paramTranslator.matches(localPair5.getCar(), "::"))
        break label1846;
      if (!(((Pair)localObject8).getCdr() instanceof Pair))
      {
        paramTranslator.syntaxError("'::' not followed by a type specifier (for parameter '" + localObject16 + "')");
        return;
      }
      Pair localPair6 = (Pair)localPair5.getCdr();
      localObject18 = localPair6;
      localObject8 = localPair6;
      localObject17 = localObject14;
    }
    while (true)
    {
      if (localObject16 == null)
      {
        paramTranslator.syntaxError("parameter is neither name nor (name :: type) nor (name default): " + localObject8);
        return;
        boolean bool1 = localObject15 instanceof Pair;
        localObject16 = null;
        if (!bool1)
          break label1846;
        Pair localPair2 = (Pair)localObject15;
        Object localObject23 = localPair2.getCar();
        if ((localObject23 instanceof SyntaxForm))
        {
          SyntaxForm localSyntaxForm1 = (SyntaxForm)localObject23;
          localObject23 = localSyntaxForm1.getDatum();
          localTemplateScope = localSyntaxForm1.getScope();
        }
        Object localObject24 = paramTranslator.namespaceResolve(localObject23);
        boolean bool2 = localObject24 instanceof Symbol;
        localObject16 = null;
        if (!bool2)
          break label1846;
        boolean bool3 = localPair2.getCdr() instanceof Pair;
        localObject16 = null;
        if (!bool3)
          break label1846;
        localObject16 = localObject24;
        Pair localPair3 = (Pair)localPair2.getCdr();
        boolean bool4 = paramTranslator.matches(localPair3.getCar(), "::");
        localObject18 = null;
        Pair localPair4;
        if (bool4)
        {
          if (!(localPair3.getCdr() instanceof Pair))
          {
            paramTranslator.syntaxError("'::' not followed by a type specifier (for parameter '" + localObject16 + "')");
            return;
          }
          localPair4 = (Pair)localPair3.getCdr();
          localObject18 = localPair4;
          if ((localPair4.getCdr() instanceof Pair))
            localPair3 = (Pair)localPair4.getCdr();
        }
        else if ((localPair3 != null) && (localObject7 != null))
        {
          localObject14 = localPair3.getCar();
          if (!(localPair3.getCdr() instanceof Pair))
            break label1496;
        }
        for (localPair3 = (Pair)localPair3.getCdr(); ; localPair3 = null)
        {
          if (localPair3 == null)
            break label1839;
          if (localObject18 == null)
            break label1546;
          paramTranslator.syntaxError("duplicate type specifier for parameter '" + localObject16 + '\'');
          return;
          if (localPair4.getCdr() == LList.Empty)
          {
            localPair3 = null;
            break;
          }
          paramTranslator.syntaxError("improper list in specifier for parameter '" + localObject16 + "')");
          return;
          label1496: if (localPair3.getCdr() != LList.Empty)
            break label1513;
        }
        label1513: paramTranslator.syntaxError("improper list in specifier for parameter '" + localObject16 + "')");
        return;
        label1546: localObject18 = localPair3;
        if (localPair3.getCdr() != LList.Empty)
          paramTranslator.syntaxError("junk at end of specifier for parameter '" + localObject16 + '\'' + " after type " + localPair3.getCar());
      }
      else
      {
        Object localObject19 = this.optionalKeyword;
        if (localObject7 != localObject19)
        {
          Object localObject22 = this.keyKeyword;
          if (localObject7 != localObject22);
        }
        else
        {
          Expression[] arrayOfExpression = paramLambdaExp.defaultArgs;
          int i1 = m + 1;
          LangExp localLangExp1 = new LangExp(localObject17);
          arrayOfExpression[m] = localLangExp1;
          m = i1;
        }
        Object localObject20 = this.keyKeyword;
        String str1;
        label1710: Declaration localDeclaration1;
        if (localObject7 == localObject20)
        {
          Keyword[] arrayOfKeyword = paramLambdaExp.keywords;
          int i2 = n + 1;
          if ((localObject16 instanceof Symbol))
          {
            str1 = ((Symbol)localObject16).getName();
            arrayOfKeyword[n] = Keyword.make(str1);
            n = i2;
          }
        }
        else
        {
          localDeclaration1 = new Declaration(localObject16);
          Translator.setLine(localDeclaration1, localObject6);
          if (localObject18 == null)
            break label1815;
          LangExp localLangExp2 = new LangExp(localObject18);
          localDeclaration1.setTypeExp(localLangExp2);
          localDeclaration1.setFlag(8192L);
        }
        while (true)
        {
          localDeclaration1.setFlag(262144L);
          localDeclaration1.noteValue(null);
          addParam(localDeclaration1, localTemplateScope, paramLambdaExp, paramTranslator);
          paramTranslator.popPositionOf(localObject13);
          break;
          str1 = localObject16.toString();
          break label1710;
          label1815: Object localObject21 = this.restKeyword;
          if (localObject7 == localObject21)
            localDeclaration1.setType(LangObjType.listType);
        }
      }
      label1839: localObject17 = localObject14;
      continue;
      label1846: localObject17 = localObject14;
      localObject18 = null;
    }
  }

  public void setKeywords(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    this.optionalKeyword = paramObject1;
    this.restKeyword = paramObject2;
    this.keyKeyword = paramObject3;
  }

  public Object skipAttrs(LambdaExp paramLambdaExp, Object paramObject, Translator paramTranslator)
  {
    Pair localPair;
    if ((paramObject instanceof Pair))
    {
      localPair = (Pair)paramObject;
      if ((localPair.getCdr() instanceof Pair));
    }
    else
    {
      return paramObject;
    }
    Object localObject = localPair.getCar();
    if (paramTranslator.matches(localObject, "::"));
    while ((localObject instanceof Keyword))
    {
      paramObject = ((Pair)localPair.getCdr()).getCdr();
      break;
    }
    return paramObject;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Lambda
 * JD-Core Version:    0.6.2
 */