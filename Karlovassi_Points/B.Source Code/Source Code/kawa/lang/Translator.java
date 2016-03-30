package kawa.lang;

import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.Special;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.functions.CompileNamedPart;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.xml.MakeAttribute;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.xml.NamespaceBinding;
import java.util.Stack;
import java.util.Vector;
import kawa.standard.begin;
import kawa.standard.require;

public class Translator extends Compilation
{
  private static Expression errorExp = new ErrorExp("unknown syntax error");
  public static final Declaration getNamedPartDecl = Declaration.getDeclarationFromStatic("gnu.kawa.functions.GetNamedPart", "getNamedPart");
  public LambdaExp curMethodLambda;
  public Macro currentMacroDefinition;
  Syntax currentSyntax;
  private Environment env = Environment.getCurrent();
  public int firstForm;
  public Stack formStack = new Stack();
  Declaration macroContext;
  public Declaration matchArray;
  Vector notedAccess;
  public PatternScope patternScope;
  public Object pendingForm;
  PairWithPosition positionPair;
  Stack renamedAliasStack;
  public Declaration templateScopeDecl;
  public NamespaceBinding xmlElementNamespaces = NamespaceBinding.predefinedXML;

  static
  {
    LispLanguage.getNamedPartLocation.setDeclaration(getNamedPartDecl);
  }

  public Translator(Language paramLanguage, SourceMessages paramSourceMessages, NameLookup paramNameLookup)
  {
    super(paramLanguage, paramSourceMessages, paramNameLookup);
  }

  static ReferenceExp getOriginalRef(Declaration paramDeclaration)
  {
    if ((paramDeclaration != null) && (paramDeclaration.isAlias()) && (!paramDeclaration.isIndirectBinding()))
    {
      Expression localExpression = paramDeclaration.getValue();
      if ((localExpression instanceof ReferenceExp))
        return (ReferenceExp)localExpression;
    }
    return null;
  }

  public static int listLength(Object paramObject)
  {
    int i = 0;
    Object localObject1 = paramObject;
    Object localObject2 = paramObject;
    do
    {
      while ((localObject2 instanceof SyntaxForm))
        localObject2 = ((SyntaxForm)localObject2).getDatum();
      while ((localObject1 instanceof SyntaxForm))
        localObject1 = ((SyntaxForm)localObject1).getDatum();
      if (localObject2 == LList.Empty)
        return i;
      if (!(localObject2 instanceof Pair))
        return -1 - i;
      int j = i + 1;
      for (Object localObject3 = ((Pair)localObject2).getCdr(); (localObject3 instanceof SyntaxForm); localObject3 = ((SyntaxForm)localObject3).getDatum());
      if (localObject3 == LList.Empty)
        return j;
      if (!(localObject3 instanceof Pair))
        return -1 - j;
      localObject1 = ((Pair)localObject1).getCdr();
      localObject2 = ((Pair)localObject3).getCdr();
      i = j + 1;
    }
    while (localObject2 != localObject1);
    return -2147483648;
  }

  private Expression makeBody(int paramInt, ScopeExp paramScopeExp)
  {
    int i = this.formStack.size() - paramInt;
    if (i == 0)
      return QuoteExp.voidExp;
    if (i == 1)
      return (Expression)this.formStack.pop();
    Expression[] arrayOfExpression = new Expression[i];
    for (int j = 0; j < i; j++)
      arrayOfExpression[j] = ((Expression)this.formStack.elementAt(paramInt + j));
    this.formStack.setSize(paramInt);
    if ((paramScopeExp instanceof ModuleExp))
      return new ApplyExp(AppendValues.appendValues, arrayOfExpression);
    return ((LispLanguage)getLanguage()).makeBody(arrayOfExpression);
  }

  public static Pair makePair(Pair paramPair, Object paramObject1, Object paramObject2)
  {
    if ((paramPair instanceof PairWithPosition))
      return new PairWithPosition((PairWithPosition)paramPair, paramObject1, paramObject2);
    return new Pair(paramObject1, paramObject2);
  }

  private void rewriteBody(LList paramLList)
  {
    while (paramLList != LList.Empty)
    {
      Pair localPair = (Pair)paramLList;
      Object localObject1 = pushPositionOf(localPair);
      try
      {
        rewriteInBody(localPair.getCar());
        popPositionOf(localObject1);
        paramLList = (LList)localPair.getCdr();
      }
      finally
      {
        popPositionOf(localObject1);
      }
    }
  }

  public static Object safeCar(Object paramObject)
  {
    while ((paramObject instanceof SyntaxForm))
      paramObject = ((SyntaxForm)paramObject).getDatum();
    if (!(paramObject instanceof Pair))
      return null;
    return stripSyntax(((Pair)paramObject).getCar());
  }

  public static Object safeCdr(Object paramObject)
  {
    while ((paramObject instanceof SyntaxForm))
      paramObject = ((SyntaxForm)paramObject).getDatum();
    if (!(paramObject instanceof Pair))
      return null;
    return stripSyntax(((Pair)paramObject).getCdr());
  }

  public static void setLine(Declaration paramDeclaration, Object paramObject)
  {
    if ((paramObject instanceof SourceLocator))
      paramDeclaration.setLocation((SourceLocator)paramObject);
  }

  public static void setLine(Expression paramExpression, Object paramObject)
  {
    if ((paramObject instanceof SourceLocator))
      paramExpression.setLocation((SourceLocator)paramObject);
  }

  public static Object stripSyntax(Object paramObject)
  {
    while ((paramObject instanceof SyntaxForm))
      paramObject = ((SyntaxForm)paramObject).getDatum();
    return paramObject;
  }

  static void vectorReverse(Vector paramVector, int paramInt1, int paramInt2)
  {
    int i = paramInt2 / 2;
    int j = paramInt1 + paramInt2 - 1;
    for (int k = 0; k < i; k++)
    {
      Object localObject = paramVector.elementAt(paramInt1 + k);
      paramVector.setElementAt(paramVector.elementAt(j - k), paramInt1 + k);
      paramVector.setElementAt(localObject, j - k);
    }
  }

  public static Object wrapSyntax(Object paramObject, SyntaxForm paramSyntaxForm)
  {
    if ((paramSyntaxForm == null) || ((paramObject instanceof Expression)))
      return paramObject;
    return SyntaxForms.fromDatumIfNeeded(paramObject, paramSyntaxForm);
  }

  Expression apply_rewrite(Syntax paramSyntax, Pair paramPair)
  {
    Syntax localSyntax = this.currentSyntax;
    this.currentSyntax = paramSyntax;
    try
    {
      Expression localExpression = paramSyntax.rewriteForm(paramPair, this);
      return localExpression;
    }
    finally
    {
      this.currentSyntax = localSyntax;
    }
  }

  Syntax check_if_Syntax(Declaration paramDeclaration)
  {
    Declaration localDeclaration1 = Declaration.followAliases(paramDeclaration);
    Expression localExpression = localDeclaration1.getValue();
    if ((localExpression != null) && (localDeclaration1.getFlag(32768L)));
    while (true)
    {
      try
      {
        if ((paramDeclaration.getValue() instanceof ReferenceExp))
        {
          Declaration localDeclaration2 = ((ReferenceExp)paramDeclaration.getValue()).contextDecl();
          if (localDeclaration2 != null)
          {
            this.macroContext = localDeclaration2;
            Object localObject2 = localExpression.eval(this.env);
            localObject1 = localObject2;
            if (!(localObject1 instanceof Syntax))
              break;
            return (Syntax)localObject1;
          }
          if (!(this.current_scope instanceof TemplateScope))
            continue;
          this.macroContext = ((TemplateScope)this.current_scope).macroContext;
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        error('e', "unable to evaluate macro for " + paramDeclaration.getSymbol());
        localObject1 = null;
        continue;
        if (!(this.current_scope instanceof TemplateScope))
          continue;
        this.macroContext = ((TemplateScope)this.current_scope).macroContext;
        continue;
      }
      boolean bool1 = paramDeclaration.getFlag(32768L);
      Object localObject1 = null;
      if (bool1)
      {
        boolean bool2 = paramDeclaration.needsContext();
        localObject1 = null;
        if (!bool2)
          localObject1 = StaticFieldLocation.make(paramDeclaration).get(null);
      }
    }
    return null;
  }

  public Declaration define(Object paramObject, SyntaxForm paramSyntaxForm, ScopeExp paramScopeExp)
  {
    int i;
    if ((paramSyntaxForm != null) && (paramSyntaxForm.getScope() != currentScope()))
    {
      i = 1;
      if (i == 0)
        break label95;
    }
    label95: for (Object localObject = new String(paramObject.toString()); ; localObject = paramObject)
    {
      Declaration localDeclaration1 = paramScopeExp.getDefine(localObject, 'w', this);
      if (i != 0)
      {
        Declaration localDeclaration2 = makeRenamedAlias(paramObject, localDeclaration1, paramSyntaxForm.getScope());
        paramSyntaxForm.getScope().addDeclaration(localDeclaration2);
      }
      push(localDeclaration1);
      return localDeclaration1;
      i = 0;
      break;
    }
  }

  // ERROR //
  public gnu.bytecode.Type exp2Type(Pair paramPair)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 190	kawa/lang/Translator:pushPositionOf	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5: astore_2
    //   6: aload_0
    //   7: aload_1
    //   8: iconst_0
    //   9: invokevirtual 346	kawa/lang/Translator:rewrite_car	(Lgnu/lists/Pair;Z)Lgnu/expr/Expression;
    //   12: aload_0
    //   13: invokestatic 352	gnu/expr/InlineCalls:inlineCalls	(Lgnu/expr/Expression;Lgnu/expr/Compilation;)Lgnu/expr/Expression;
    //   16: astore 4
    //   18: aload 4
    //   20: instanceof 62
    //   23: istore 5
    //   25: iload 5
    //   27: ifeq +10 -> 37
    //   30: aload_0
    //   31: aload_2
    //   32: invokevirtual 200	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   35: aconst_null
    //   36: areturn
    //   37: aload_0
    //   38: invokevirtual 171	kawa/lang/Translator:getLanguage	()Lgnu/expr/Language;
    //   41: aload 4
    //   43: invokevirtual 358	gnu/expr/Language:getTypeFor	(Lgnu/expr/Expression;)Lgnu/bytecode/Type;
    //   46: astore 6
    //   48: aload 6
    //   50: astore 7
    //   52: aload 7
    //   54: ifnonnull +36 -> 90
    //   57: aload 4
    //   59: aload_0
    //   60: getfield 94	kawa/lang/Translator:env	Lgnu/mapping/Environment;
    //   63: invokevirtual 265	gnu/expr/Expression:eval	(Lgnu/mapping/Environment;)Ljava/lang/Object;
    //   66: astore 10
    //   68: aload 10
    //   70: instanceof 360
    //   73: ifeq +81 -> 154
    //   76: aload 10
    //   78: checkcast 360	java/lang/Class
    //   81: invokestatic 365	gnu/bytecode/Type:make	(Ljava/lang/Class;)Lgnu/bytecode/Type;
    //   84: astore 11
    //   86: aload 11
    //   88: astore 7
    //   90: aload 7
    //   92: ifnonnull +100 -> 192
    //   95: aload 4
    //   97: instanceof 109
    //   100: ifeq +72 -> 172
    //   103: aload_0
    //   104: bipush 101
    //   106: new 277	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 367
    //   116: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 4
    //   121: checkcast 109	gnu/expr/ReferenceExp
    //   124: invokevirtual 370	gnu/expr/ReferenceExp:getName	()Ljava/lang/String;
    //   127: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: bipush 39
    //   132: invokevirtual 373	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   135: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokevirtual 298	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   141: getstatic 377	gnu/bytecode/Type:pointer_type	Lgnu/bytecode/ClassType;
    //   144: astore 8
    //   146: aload_0
    //   147: aload_2
    //   148: invokevirtual 200	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   151: aload 8
    //   153: areturn
    //   154: aload 10
    //   156: instanceof 362
    //   159: ifeq -69 -> 90
    //   162: aload 10
    //   164: checkcast 362	gnu/bytecode/Type
    //   167: astore 7
    //   169: goto -79 -> 90
    //   172: aload_0
    //   173: bipush 101
    //   175: ldc_w 379
    //   178: invokevirtual 298	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   181: goto -40 -> 141
    //   184: astore_3
    //   185: aload_0
    //   186: aload_2
    //   187: invokevirtual 200	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   190: aload_3
    //   191: athrow
    //   192: aload_0
    //   193: aload_2
    //   194: invokevirtual 200	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   197: aload 7
    //   199: areturn
    //   200: astore 9
    //   202: goto -112 -> 90
    //
    // Exception table:
    //   from	to	target	type
    //   6	25	184	finally
    //   37	48	184	finally
    //   57	86	184	finally
    //   95	141	184	finally
    //   141	146	184	finally
    //   154	169	184	finally
    //   172	181	184	finally
    //   57	86	200	java/lang/Throwable
    //   154	169	200	java/lang/Throwable
  }

  public void finishModule(ModuleExp paramModuleExp)
  {
    boolean bool = paramModuleExp.isStatic();
    Declaration localDeclaration = paramModuleExp.firstDecl();
    if (localDeclaration != null)
    {
      String str;
      if (localDeclaration.getFlag(512L))
      {
        if (localDeclaration.getFlag(1024L))
        {
          str = "' exported but never defined";
          label39: error('e', localDeclaration, "'", str);
        }
      }
      else
      {
        if ((paramModuleExp.getFlag(16384)) || ((this.generateMain) && (!this.immediate)))
        {
          if (!localDeclaration.getFlag(1024L))
            break label165;
          if (localDeclaration.isPrivate())
          {
            if (localDeclaration.getFlag(16777216L))
              error('e', localDeclaration, "'", "' is declared both private and exported");
            localDeclaration.setPrivate(false);
          }
        }
        label120: if (!bool)
          break label173;
        localDeclaration.setFlag(2048L);
      }
      while (true)
      {
        localDeclaration = localDeclaration.nextDecl();
        break;
        if (localDeclaration.getFlag(2048L))
        {
          str = "' declared static but never defined";
          break label39;
        }
        str = "' declared but never defined";
        break label39;
        label165: localDeclaration.setPrivate(true);
        break label120;
        label173: if (((paramModuleExp.getFlag(65536)) && (!localDeclaration.getFlag(2048L))) || (Compilation.moduleStatic < 0) || (paramModuleExp.getFlag(131072)))
          localDeclaration.setFlag(4096L);
      }
    }
  }

  public Syntax getCurrentSyntax()
  {
    return this.currentSyntax;
  }

  public final Environment getGlobalEnvironment()
  {
    return this.env;
  }

  public Declaration lookup(Object paramObject, int paramInt)
  {
    Declaration localDeclaration = this.lexical.lookup(paramObject, paramInt);
    if ((localDeclaration != null) && (getLanguage().hasNamespace(localDeclaration, paramInt)))
      return localDeclaration;
    return currentModule().lookup(paramObject, getLanguage(), paramInt);
  }

  public Declaration lookupGlobal(Object paramObject)
  {
    return lookupGlobal(paramObject, -1);
  }

  public Declaration lookupGlobal(Object paramObject, int paramInt)
  {
    ModuleExp localModuleExp = currentModule();
    Declaration localDeclaration = localModuleExp.lookup(paramObject, getLanguage(), paramInt);
    if (localDeclaration == null)
    {
      localDeclaration = localModuleExp.getNoDefine(paramObject);
      localDeclaration.setIndirectBinding(true);
    }
    return localDeclaration;
  }

  public Declaration makeRenamedAlias(Declaration paramDeclaration, ScopeExp paramScopeExp)
  {
    if (paramScopeExp == null)
      return paramDeclaration;
    return makeRenamedAlias(paramDeclaration.getSymbol(), paramDeclaration, paramScopeExp);
  }

  public Declaration makeRenamedAlias(Object paramObject, Declaration paramDeclaration, ScopeExp paramScopeExp)
  {
    Declaration localDeclaration = new Declaration(paramObject);
    localDeclaration.setAlias(true);
    localDeclaration.setPrivate(true);
    localDeclaration.context = paramScopeExp;
    ReferenceExp localReferenceExp = new ReferenceExp(paramDeclaration);
    localReferenceExp.setDontDereference(true);
    localDeclaration.noteValue(localReferenceExp);
    return localDeclaration;
  }

  public Object matchQuoted(Pair paramPair)
  {
    if ((matches(paramPair.getCar(), "quote")) && ((paramPair.getCdr() instanceof Pair)))
    {
      Pair localPair = (Pair)paramPair.getCdr();
      if (localPair.getCdr() == LList.Empty)
        return localPair.getCar();
    }
    return null;
  }

  public final boolean matches(Object paramObject, String paramString)
  {
    return matches(paramObject, null, paramString);
  }

  public boolean matches(Object paramObject, SyntaxForm paramSyntaxForm, Symbol paramSymbol)
  {
    if ((paramSyntaxForm == null) || ((paramObject instanceof SyntaxForm)))
      paramObject = ((SyntaxForm)paramObject).getDatum();
    if (((paramObject instanceof SimpleSymbol)) && (!selfEvaluatingSymbol(paramObject)))
    {
      ReferenceExp localReferenceExp = getOriginalRef(this.lexical.lookup(paramObject, -1));
      if (localReferenceExp != null)
        paramObject = localReferenceExp.getSymbol();
    }
    return paramObject == paramSymbol;
  }

  public boolean matches(Object paramObject, SyntaxForm paramSyntaxForm, String paramString)
  {
    if ((paramSyntaxForm == null) || ((paramObject instanceof SyntaxForm)))
      paramObject = ((SyntaxForm)paramObject).getDatum();
    if (((paramObject instanceof SimpleSymbol)) && (!selfEvaluatingSymbol(paramObject)))
    {
      ReferenceExp localReferenceExp = getOriginalRef(this.lexical.lookup(paramObject, -1));
      if (localReferenceExp != null)
        paramObject = localReferenceExp.getSymbol();
    }
    return ((paramObject instanceof SimpleSymbol)) && (((Symbol)paramObject).getLocalPart() == paramString);
  }

  public Symbol namespaceResolve(Expression paramExpression1, Expression paramExpression2)
  {
    return namespaceResolve(namespaceResolvePrefix(paramExpression1), paramExpression2);
  }

  public Symbol namespaceResolve(Namespace paramNamespace, Expression paramExpression)
  {
    if ((paramNamespace != null) && ((paramExpression instanceof QuoteExp)))
      return paramNamespace.getSymbol(((QuoteExp)paramExpression).getValue().toString().intern());
    return null;
  }

  public Object namespaceResolve(Object paramObject)
  {
    if ((!(paramObject instanceof SimpleSymbol)) && ((paramObject instanceof Pair)))
    {
      Pair localPair1 = (Pair)paramObject;
      if ((safeCar(localPair1) == LispLanguage.lookup_sym) && ((localPair1.getCdr() instanceof Pair)))
      {
        Pair localPair2 = (Pair)localPair1.getCdr();
        if ((localPair2.getCdr() instanceof Pair))
        {
          Expression localExpression1 = rewrite(localPair2.getCar());
          Expression localExpression2 = rewrite(((Pair)localPair2.getCdr()).getCar());
          Symbol localSymbol = namespaceResolve(localExpression1, localExpression2);
          if (localSymbol != null)
            return localSymbol;
          String str = CompileNamedPart.combineName(localExpression1, localExpression2);
          if (str != null)
            return Namespace.EmptyNamespace.getSymbol(str);
        }
      }
    }
    return paramObject;
  }

  public Namespace namespaceResolvePrefix(Expression paramExpression)
  {
    if ((paramExpression instanceof ReferenceExp))
    {
      ReferenceExp localReferenceExp = (ReferenceExp)paramExpression;
      Declaration localDeclaration = localReferenceExp.getBinding();
      Object localObject1;
      Symbol localSymbol;
      Object localObject2;
      if ((localDeclaration == null) || (localDeclaration.getFlag(65536L)))
      {
        localObject1 = localReferenceExp.getSymbol();
        if ((localObject1 instanceof Symbol))
        {
          localSymbol = (Symbol)localObject1;
          localObject2 = this.env.get(localSymbol, null);
        }
      }
      while (true)
        if ((localObject2 instanceof Namespace))
        {
          Namespace localNamespace = (Namespace)localObject2;
          String str = localNamespace.getName();
          if ((str != null) && (str.startsWith("class:")))
          {
            return null;
            localSymbol = this.env.getSymbol(localObject1.toString());
            break;
            if (localDeclaration.isNamespaceDecl())
            {
              localObject2 = localDeclaration.getConstantValue();
              continue;
            }
            localObject2 = null;
            continue;
          }
          return localNamespace;
        }
    }
    return null;
  }

  public void noteAccess(Object paramObject, ScopeExp paramScopeExp)
  {
    if (this.notedAccess == null)
      this.notedAccess = new Vector();
    this.notedAccess.addElement(paramObject);
    this.notedAccess.addElement(paramScopeExp);
  }

  public Expression parse(Object paramObject)
  {
    return rewrite(paramObject);
  }

  public Object popForms(int paramInt)
  {
    int i = this.formStack.size();
    if (i == paramInt)
      return Values.empty;
    if (i == paramInt + 1);
    Values localValues;
    for (Object localObject = this.formStack.elementAt(paramInt); ; localObject = localValues)
    {
      this.formStack.setSize(paramInt);
      return localObject;
      localValues = new Values();
      for (int j = paramInt; j < i; j++)
        localValues.writeObject(this.formStack.elementAt(j));
    }
  }

  public void popPositionOf(Object paramObject)
  {
    if (paramObject == null);
    do
    {
      return;
      setLine(paramObject);
      this.positionPair = ((PairWithPosition)paramObject);
    }
    while (this.positionPair.getCar() != Special.eof);
    this.positionPair = ((PairWithPosition)this.positionPair.getCdr());
  }

  public void popRenamedAlias(int paramInt)
  {
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      ScopeExp localScopeExp = (ScopeExp)this.renamedAliasStack.pop();
      Declaration localDeclaration = (Declaration)this.renamedAliasStack.pop();
      getOriginalRef(localDeclaration).getBinding().setSymbol(localDeclaration.getSymbol());
      localScopeExp.remove(localDeclaration);
      Object localObject = this.renamedAliasStack.pop();
      if (localObject != null)
        localScopeExp.addDeclaration((Declaration)localObject);
    }
  }

  public void processAccesses()
  {
    if (this.notedAccess == null);
    ScopeExp localScopeExp1;
    do
    {
      return;
      int i = this.notedAccess.size();
      localScopeExp1 = this.current_scope;
      for (int j = 0; j < i; j += 2)
      {
        Object localObject = this.notedAccess.elementAt(j);
        ScopeExp localScopeExp2 = (ScopeExp)this.notedAccess.elementAt(j + 1);
        if (this.current_scope != localScopeExp2)
          setCurrentScope(localScopeExp2);
        Declaration localDeclaration = this.lexical.lookup(localObject, -1);
        if ((localDeclaration != null) && (!localDeclaration.getFlag(65536L)))
        {
          localDeclaration.getContext().currentLambda().capture(localDeclaration);
          localDeclaration.setCanRead(true);
          localDeclaration.setSimple(false);
          localDeclaration.setFlag(524288L);
        }
      }
    }
    while (this.current_scope == localScopeExp1);
    setCurrentScope(localScopeExp1);
  }

  public Object pushPositionOf(Object paramObject)
  {
    if ((paramObject instanceof SyntaxForm))
      paramObject = ((SyntaxForm)paramObject).getDatum();
    if (!(paramObject instanceof PairWithPosition))
      return null;
    PairWithPosition localPairWithPosition1 = (PairWithPosition)paramObject;
    if ((this.positionPair == null) || (this.positionPair.getFileName() != getFileName()) || (this.positionPair.getLineNumber() != getLineNumber()) || (this.positionPair.getColumnNumber() != getColumnNumber()));
    for (PairWithPosition localPairWithPosition2 = new PairWithPosition(this, Special.eof, this.positionPair); ; localPairWithPosition2 = this.positionPair)
    {
      setLine(paramObject);
      this.positionPair = localPairWithPosition1;
      return localPairWithPosition2;
    }
  }

  public void pushRenamedAlias(Declaration paramDeclaration)
  {
    Declaration localDeclaration1 = getOriginalRef(paramDeclaration).getBinding();
    ScopeExp localScopeExp = paramDeclaration.context;
    localDeclaration1.setSymbol(null);
    Declaration localDeclaration2 = localScopeExp.lookup(localDeclaration1.getSymbol());
    if (localDeclaration2 != null)
      localScopeExp.remove(localDeclaration2);
    localScopeExp.addDeclaration(paramDeclaration);
    if (this.renamedAliasStack == null)
      this.renamedAliasStack = new Stack();
    this.renamedAliasStack.push(localDeclaration2);
    this.renamedAliasStack.push(paramDeclaration);
    this.renamedAliasStack.push(localScopeExp);
  }

  public void resolveModule(ModuleExp paramModuleExp)
  {
    if (this.pendingImports == null);
    for (int i = 0; ; i = this.pendingImports.size())
    {
      int j = 0;
      while (j < i)
      {
        Stack localStack1 = this.pendingImports;
        int k = j + 1;
        ModuleInfo localModuleInfo = (ModuleInfo)localStack1.elementAt(j);
        Stack localStack2 = this.pendingImports;
        int m = k + 1;
        ScopeExp localScopeExp = (ScopeExp)localStack2.elementAt(k);
        Stack localStack3 = this.pendingImports;
        int n = m + 1;
        Expression localExpression = (Expression)localStack3.elementAt(m);
        Stack localStack4 = this.pendingImports;
        j = n + 1;
        Integer localInteger = (Integer)localStack4.elementAt(n);
        if (paramModuleExp == localScopeExp)
        {
          ReferenceExp localReferenceExp = new ReferenceExp((Object)null);
          localReferenceExp.setLine(this);
          setLine(localExpression);
          int i1 = this.formStack.size();
          require.importDefinitions(null, localModuleInfo, null, this.formStack, localScopeExp, this);
          int i2 = localInteger.intValue();
          if (localInteger.intValue() != i1)
          {
            int i3 = this.formStack.size();
            int i4 = i3 - i2;
            vectorReverse(this.formStack, i2, i1 - i2);
            vectorReverse(this.formStack, i1, i3 - i1);
            vectorReverse(this.formStack, i2, i4);
          }
          setLine(localReferenceExp);
        }
      }
    }
    this.pendingImports = null;
    processAccesses();
    setModule(paramModuleExp);
    Compilation localCompilation = Compilation.setSaveCurrent(this);
    try
    {
      rewriteInBody(popForms(this.firstForm));
      paramModuleExp.body = makeBody(this.firstForm, paramModuleExp);
      if (!this.immediate)
        this.lexical.pop(paramModuleExp);
      return;
    }
    finally
    {
      Compilation.restoreCurrent(localCompilation);
    }
  }

  public Expression rewrite(Object paramObject)
  {
    return rewrite(paramObject, false);
  }

  // ERROR //
  public Expression rewrite(Object paramObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 113
    //   4: ifeq +60 -> 64
    //   7: aload_1
    //   8: checkcast 113	kawa/lang/SyntaxForm
    //   11: astore 45
    //   13: aload_0
    //   14: getfield 269	kawa/lang/Translator:current_scope	Lgnu/expr/ScopeExp;
    //   17: astore 46
    //   19: aload_0
    //   20: aload 45
    //   22: invokeinterface 314 1 0
    //   27: invokevirtual 627	kawa/lang/Translator:setCurrentScope	(Lgnu/expr/ScopeExp;)V
    //   30: aload_0
    //   31: aload 45
    //   33: invokeinterface 117 1 0
    //   38: iload_2
    //   39: invokevirtual 715	kawa/lang/Translator:rewrite	(Ljava/lang/Object;Z)Lgnu/expr/Expression;
    //   42: astore 48
    //   44: aload_0
    //   45: aload 46
    //   47: invokevirtual 627	kawa/lang/Translator:setCurrentScope	(Lgnu/expr/ScopeExp;)V
    //   50: aload 48
    //   52: areturn
    //   53: astore 47
    //   55: aload_0
    //   56: aload 46
    //   58: invokevirtual 627	kawa/lang/Translator:setCurrentScope	(Lgnu/expr/ScopeExp;)V
    //   61: aload 47
    //   63: athrow
    //   64: aload_1
    //   65: instanceof 178
    //   68: ifeq +14 -> 82
    //   71: aload_0
    //   72: aload_1
    //   73: iload_2
    //   74: aload_1
    //   75: checkcast 178	gnu/lists/PairWithPosition
    //   78: invokevirtual 719	kawa/lang/Translator:rewrite_with_position	(Ljava/lang/Object;ZLgnu/lists/PairWithPosition;)Lgnu/expr/Expression;
    //   81: areturn
    //   82: aload_1
    //   83: instanceof 125
    //   86: ifeq +13 -> 99
    //   89: aload_0
    //   90: aload_1
    //   91: checkcast 125	gnu/lists/Pair
    //   94: iload_2
    //   95: invokevirtual 722	kawa/lang/Translator:rewrite_pair	(Lgnu/lists/Pair;Z)Lgnu/expr/Expression;
    //   98: areturn
    //   99: aload_1
    //   100: instanceof 514
    //   103: ifeq +989 -> 1092
    //   106: aload_0
    //   107: aload_1
    //   108: invokevirtual 509	kawa/lang/Translator:selfEvaluatingSymbol	(Ljava/lang/Object;)Z
    //   111: ifne +981 -> 1092
    //   114: aload_0
    //   115: getfield 448	kawa/lang/Translator:lexical	Lgnu/expr/NameLookup;
    //   118: aload_1
    //   119: iload_2
    //   120: invokevirtual 725	gnu/expr/NameLookup:lookup	(Ljava/lang/Object;Z)Lgnu/expr/Declaration;
    //   123: astore_3
    //   124: aconst_null
    //   125: astore 4
    //   127: aload_0
    //   128: getfield 269	kawa/lang/Translator:current_scope	Lgnu/expr/ScopeExp;
    //   131: astore 5
    //   133: aload_3
    //   134: ifnonnull +207 -> 341
    //   137: iconst_m1
    //   138: istore 6
    //   140: aload_1
    //   141: instanceof 514
    //   144: ifeq +209 -> 353
    //   147: aload_1
    //   148: checkcast 514	gnu/mapping/Symbol
    //   151: invokevirtual 728	gnu/mapping/Symbol:hasEmptyNamespace	()Z
    //   154: ifeq +199 -> 353
    //   157: aload_1
    //   158: invokevirtual 323	java/lang/Object:toString	()Ljava/lang/String;
    //   161: astore 7
    //   163: aload 5
    //   165: ifnull +50 -> 215
    //   168: aload 5
    //   170: instanceof 636
    //   173: ifeq +295 -> 468
    //   176: aload 5
    //   178: getfield 731	gnu/expr/ScopeExp:outer	Lgnu/expr/ScopeExp;
    //   181: instanceof 733
    //   184: ifeq +284 -> 468
    //   187: aload 5
    //   189: checkcast 636	gnu/expr/LambdaExp
    //   192: invokevirtual 736	gnu/expr/LambdaExp:isClassMethod	()Z
    //   195: ifeq +273 -> 468
    //   198: aload 5
    //   200: getfield 731	gnu/expr/ScopeExp:outer	Lgnu/expr/ScopeExp;
    //   203: invokestatic 740	gnu/expr/ScopeExp:nesting	(Lgnu/expr/ScopeExp;)I
    //   206: istore 33
    //   208: iload 6
    //   210: iload 33
    //   212: if_icmplt +150 -> 362
    //   215: aload_3
    //   216: ifnull +340 -> 556
    //   219: aload_3
    //   220: invokevirtual 287	gnu/expr/Declaration:getSymbol	()Ljava/lang/Object;
    //   223: astore 8
    //   225: aload_3
    //   226: invokestatic 511	kawa/lang/Translator:getOriginalRef	(Lgnu/expr/Declaration;)Lgnu/expr/ReferenceExp;
    //   229: astore 31
    //   231: aconst_null
    //   232: astore 32
    //   234: aload 31
    //   236: ifnull +27 -> 263
    //   239: aload 31
    //   241: invokevirtual 561	gnu/expr/ReferenceExp:getBinding	()Lgnu/expr/Declaration;
    //   244: astore_3
    //   245: aconst_null
    //   246: astore 32
    //   248: aload_3
    //   249: ifnonnull +14 -> 263
    //   252: aload 31
    //   254: invokevirtual 512	gnu/expr/ReferenceExp:getSymbol	()Ljava/lang/Object;
    //   257: astore 32
    //   259: aload 32
    //   261: astore 8
    //   263: aload 32
    //   265: astore 9
    //   267: aload 9
    //   269: checkcast 514	gnu/mapping/Symbol
    //   272: astore 10
    //   274: aload_0
    //   275: invokevirtual 171	kawa/lang/Translator:getLanguage	()Lgnu/expr/Language;
    //   278: invokevirtual 743	gnu/expr/Language:hasSeparateFunctionNamespace	()Z
    //   281: istore 11
    //   283: aload_3
    //   284: ifnull +383 -> 667
    //   287: aload_0
    //   288: getfield 269	kawa/lang/Translator:current_scope	Lgnu/expr/ScopeExp;
    //   291: instanceof 271
    //   294: ifeq +271 -> 565
    //   297: aload_3
    //   298: invokevirtual 301	gnu/expr/Declaration:needsContext	()Z
    //   301: ifeq +264 -> 565
    //   304: aload_0
    //   305: getfield 269	kawa/lang/Translator:current_scope	Lgnu/expr/ScopeExp;
    //   308: checkcast 271	kawa/lang/TemplateScope
    //   311: getfield 272	kawa/lang/TemplateScope:macroContext	Lgnu/expr/Declaration;
    //   314: astore 4
    //   316: aload_3
    //   317: ifnull +731 -> 1048
    //   320: iload_2
    //   321: ifne +683 -> 1004
    //   324: aload_3
    //   325: invokevirtual 580	gnu/expr/Declaration:getConstantValue	()Ljava/lang/Object;
    //   328: instanceof 745
    //   331: ifeq +673 -> 1004
    //   334: ldc_w 322
    //   337: invokestatic 749	gnu/expr/QuoteExp:getInstance	(Ljava/lang/Object;)Lgnu/expr/QuoteExp;
    //   340: areturn
    //   341: aload_3
    //   342: getfield 482	gnu/expr/Declaration:context	Lgnu/expr/ScopeExp;
    //   345: invokestatic 740	gnu/expr/ScopeExp:nesting	(Lgnu/expr/ScopeExp;)I
    //   348: istore 6
    //   350: goto -210 -> 140
    //   353: aconst_null
    //   354: astore 7
    //   356: aconst_null
    //   357: astore 5
    //   359: goto -196 -> 163
    //   362: aload 5
    //   364: checkcast 636	gnu/expr/LambdaExp
    //   367: astore 34
    //   369: aload 5
    //   371: getfield 731	gnu/expr/ScopeExp:outer	Lgnu/expr/ScopeExp;
    //   374: checkcast 733	gnu/expr/ClassExp
    //   377: astore 35
    //   379: aload 35
    //   381: invokevirtual 753	gnu/expr/ClassExp:getClassType	()Lgnu/bytecode/ClassType;
    //   384: astore 36
    //   386: aload 36
    //   388: aload 7
    //   390: aload 36
    //   392: invokestatic 759	gnu/kawa/reflect/SlotGet:lookupMember	(Lgnu/bytecode/ObjectType;Ljava/lang/String;Lgnu/bytecode/ClassType;)Lgnu/bytecode/Member;
    //   395: astore 37
    //   397: aload 34
    //   399: aload 35
    //   401: getfield 762	gnu/expr/ClassExp:clinitMethod	Lgnu/expr/LambdaExp;
    //   404: if_acmpeq +24 -> 428
    //   407: aload 34
    //   409: aload 35
    //   411: getfield 765	gnu/expr/ClassExp:initMethod	Lgnu/expr/LambdaExp;
    //   414: if_acmpeq +64 -> 478
    //   417: aload 34
    //   419: getfield 768	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   422: invokevirtual 769	gnu/expr/Declaration:isStatic	()Z
    //   425: ifeq +53 -> 478
    //   428: iconst_1
    //   429: istore 38
    //   431: aload 37
    //   433: ifnonnull +58 -> 491
    //   436: iload 38
    //   438: ifeq +46 -> 484
    //   441: bipush 83
    //   443: istore 43
    //   445: aload_0
    //   446: getfield 773	kawa/lang/Translator:language	Lgnu/expr/Language;
    //   449: astore 44
    //   451: aload 36
    //   453: aload 7
    //   455: iload 43
    //   457: aload 36
    //   459: aload 44
    //   461: invokestatic 779	gnu/kawa/reflect/ClassMethods:getMethods	(Lgnu/bytecode/ObjectType;Ljava/lang/String;CLgnu/bytecode/ClassType;Lgnu/expr/Language;)[Lgnu/expr/PrimProcedure;
    //   464: arraylength
    //   465: ifne +26 -> 491
    //   468: aload 5
    //   470: getfield 731	gnu/expr/ScopeExp:outer	Lgnu/expr/ScopeExp;
    //   473: astore 5
    //   475: goto -312 -> 163
    //   478: iconst_0
    //   479: istore 38
    //   481: goto -50 -> 431
    //   484: bipush 86
    //   486: istore 43
    //   488: goto -43 -> 445
    //   491: iload 38
    //   493: ifeq +42 -> 535
    //   496: aload 34
    //   498: getfield 780	gnu/expr/LambdaExp:outer	Lgnu/expr/ScopeExp;
    //   501: checkcast 733	gnu/expr/ClassExp
    //   504: getfield 781	gnu/expr/ClassExp:nameDecl	Lgnu/expr/Declaration;
    //   507: astore 42
    //   509: new 109	gnu/expr/ReferenceExp
    //   512: dup
    //   513: aload 42
    //   515: invokespecial 484	gnu/expr/ReferenceExp:<init>	(Lgnu/expr/Declaration;)V
    //   518: astore 40
    //   520: aload 7
    //   522: invokestatic 749	gnu/expr/QuoteExp:getInstance	(Ljava/lang/Object;)Lgnu/expr/QuoteExp;
    //   525: astore 41
    //   527: aload 40
    //   529: aload 41
    //   531: invokestatic 785	gnu/kawa/functions/CompileNamedPart:makeExp	(Lgnu/expr/Expression;Lgnu/expr/Expression;)Lgnu/expr/Expression;
    //   534: areturn
    //   535: aload 34
    //   537: invokevirtual 786	gnu/expr/LambdaExp:firstDecl	()Lgnu/expr/Declaration;
    //   540: astore 39
    //   542: new 788	gnu/expr/ThisExp
    //   545: dup
    //   546: aload 39
    //   548: invokespecial 789	gnu/expr/ThisExp:<init>	(Lgnu/expr/Declaration;)V
    //   551: astore 40
    //   553: goto -33 -> 520
    //   556: aload_1
    //   557: astore 8
    //   559: aload_1
    //   560: astore 9
    //   562: goto -295 -> 267
    //   565: aload_3
    //   566: ldc2_w 790
    //   569: invokevirtual 255	gnu/expr/Declaration:getFlag	(J)Z
    //   572: istore 28
    //   574: aconst_null
    //   575: astore 4
    //   577: iload 28
    //   579: ifeq -263 -> 316
    //   582: aload_3
    //   583: invokevirtual 769	gnu/expr/Declaration:isStatic	()Z
    //   586: istore 29
    //   588: aconst_null
    //   589: astore 4
    //   591: iload 29
    //   593: ifne -277 -> 316
    //   596: aload_0
    //   597: invokevirtual 318	kawa/lang/Translator:currentScope	()Lgnu/expr/ScopeExp;
    //   600: astore 30
    //   602: aload 30
    //   604: ifnonnull +31 -> 635
    //   607: new 793	java/lang/Error
    //   610: dup
    //   611: new 277	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 795
    //   621: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_3
    //   625: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokespecial 796	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   634: athrow
    //   635: aload 30
    //   637: getfield 731	gnu/expr/ScopeExp:outer	Lgnu/expr/ScopeExp;
    //   640: aload_3
    //   641: getfield 482	gnu/expr/Declaration:context	Lgnu/expr/ScopeExp;
    //   644: if_acmpne +13 -> 657
    //   647: aload 30
    //   649: invokevirtual 797	gnu/expr/ScopeExp:firstDecl	()Lgnu/expr/Declaration;
    //   652: astore 4
    //   654: goto -338 -> 316
    //   657: aload 30
    //   659: getfield 731	gnu/expr/ScopeExp:outer	Lgnu/expr/ScopeExp;
    //   662: astore 30
    //   664: goto -62 -> 602
    //   667: aload_0
    //   668: getfield 94	kawa/lang/Translator:env	Lgnu/mapping/Environment;
    //   671: astore 12
    //   673: iload_2
    //   674: ifeq +492 -> 1166
    //   677: iload 11
    //   679: ifeq +487 -> 1166
    //   682: getstatic 802	gnu/mapping/EnvironmentKey:FUNCTION	Ljava/lang/Object;
    //   685: astore 13
    //   687: aload 12
    //   689: aload 10
    //   691: aload 13
    //   693: invokevirtual 805	gnu/mapping/Environment:lookup	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;
    //   696: astore 14
    //   698: aload 14
    //   700: ifnull +10 -> 710
    //   703: aload 14
    //   705: invokevirtual 811	gnu/mapping/Location:getBase	()Lgnu/mapping/Location;
    //   708: astore 14
    //   710: aload 14
    //   712: instanceof 813
    //   715: ifeq +243 -> 958
    //   718: aload 14
    //   720: checkcast 813	gnu/kawa/reflect/FieldLocation
    //   723: astore 18
    //   725: aload 18
    //   727: invokevirtual 816	gnu/kawa/reflect/FieldLocation:getDeclaration	()Lgnu/expr/Declaration;
    //   730: astore_3
    //   731: aload_0
    //   732: aconst_null
    //   733: invokevirtual 820	kawa/lang/Translator:inlineOk	(Lgnu/expr/Expression;)Z
    //   736: ifne +48 -> 784
    //   739: getstatic 48	kawa/lang/Translator:getNamedPartDecl	Lgnu/expr/Declaration;
    //   742: astore 27
    //   744: aload_3
    //   745: aload 27
    //   747: if_acmpeq +37 -> 784
    //   750: ldc_w 822
    //   753: aload 18
    //   755: invokevirtual 825	gnu/kawa/reflect/FieldLocation:getMemberName	()Ljava/lang/String;
    //   758: invokevirtual 828	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   761: ifeq +397 -> 1158
    //   764: ldc_w 830
    //   767: aload 18
    //   769: invokevirtual 833	gnu/kawa/reflect/FieldLocation:getDeclaringClass	()Lgnu/bytecode/ClassType;
    //   772: invokevirtual 836	gnu/bytecode/ClassType:getName	()Ljava/lang/String;
    //   775: invokevirtual 828	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   778: ifne +6 -> 784
    //   781: goto +377 -> 1158
    //   784: aload_0
    //   785: getfield 408	kawa/lang/Translator:immediate	Z
    //   788: ifeq +53 -> 841
    //   791: aload_3
    //   792: invokevirtual 769	gnu/expr/Declaration:isStatic	()Z
    //   795: istore 24
    //   797: aconst_null
    //   798: astore 4
    //   800: iload 24
    //   802: ifne -486 -> 316
    //   805: new 42	gnu/expr/Declaration
    //   808: dup
    //   809: ldc_w 838
    //   812: invokespecial 476	gnu/expr/Declaration:<init>	(Ljava/lang/Object;)V
    //   815: astore 25
    //   817: aload 25
    //   819: new 137	gnu/expr/QuoteExp
    //   822: dup
    //   823: aload 18
    //   825: invokevirtual 840	gnu/kawa/reflect/FieldLocation:getInstance	()Ljava/lang/Object;
    //   828: invokespecial 841	gnu/expr/QuoteExp:<init>	(Ljava/lang/Object;)V
    //   831: invokevirtual 844	gnu/expr/Declaration:setValue	(Lgnu/expr/Expression;)V
    //   834: aload 25
    //   836: astore 4
    //   838: goto -522 -> 316
    //   841: aload_3
    //   842: invokevirtual 769	gnu/expr/Declaration:isStatic	()Z
    //   845: ifeq +53 -> 898
    //   848: aload 18
    //   850: invokevirtual 848	gnu/kawa/reflect/FieldLocation:getRClass	()Ljava/lang/Class;
    //   853: astore 21
    //   855: aload 21
    //   857: ifnull +33 -> 890
    //   860: aload 21
    //   862: invokevirtual 852	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   865: astore 22
    //   867: aload 22
    //   869: instanceof 854
    //   872: ifne +18 -> 890
    //   875: aload 22
    //   877: instanceof 856
    //   880: istore 23
    //   882: aconst_null
    //   883: astore 4
    //   885: iload 23
    //   887: ifeq -571 -> 316
    //   890: aconst_null
    //   891: astore 4
    //   893: aconst_null
    //   894: astore_3
    //   895: goto -579 -> 316
    //   898: aconst_null
    //   899: astore 4
    //   901: aconst_null
    //   902: astore_3
    //   903: goto -587 -> 316
    //   906: astore 19
    //   908: aload 19
    //   910: astore 20
    //   912: aload_0
    //   913: bipush 101
    //   915: new 277	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   922: ldc_w 858
    //   925: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: aload 9
    //   930: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   933: ldc_w 860
    //   936: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: aload 20
    //   941: invokevirtual 863	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   944: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: invokevirtual 298	kawa/lang/Translator:error	(CLjava/lang/String;)V
    //   953: aconst_null
    //   954: astore_3
    //   955: goto -639 -> 316
    //   958: aload 14
    //   960: ifnull +18 -> 978
    //   963: aload 14
    //   965: invokevirtual 866	gnu/mapping/Location:isBound	()Z
    //   968: istore 17
    //   970: aconst_null
    //   971: astore 4
    //   973: iload 17
    //   975: ifne -659 -> 316
    //   978: aload_0
    //   979: invokevirtual 171	kawa/lang/Translator:getLanguage	()Lgnu/expr/Language;
    //   982: checkcast 50	gnu/kawa/lispexpr/LispLanguage
    //   985: aload 10
    //   987: aload_0
    //   988: invokevirtual 870	gnu/kawa/lispexpr/LispLanguage:checkDefaultBinding	(Lgnu/mapping/Symbol;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    //   991: astore 15
    //   993: aconst_null
    //   994: astore 4
    //   996: aload 15
    //   998: ifnull -682 -> 316
    //   1001: aload 15
    //   1003: areturn
    //   1004: aload_3
    //   1005: invokevirtual 630	gnu/expr/Declaration:getContext	()Lgnu/expr/ScopeExp;
    //   1008: instanceof 872
    //   1011: ifeq +37 -> 1048
    //   1014: aload_0
    //   1015: new 277	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   1022: ldc_w 874
    //   1025: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: aload_3
    //   1029: invokevirtual 875	gnu/expr/Declaration:getName	()Ljava/lang/String;
    //   1032: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: ldc_w 877
    //   1038: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: invokevirtual 881	kawa/lang/Translator:syntaxError	(Ljava/lang/String;)Lgnu/expr/Expression;
    //   1047: areturn
    //   1048: new 109	gnu/expr/ReferenceExp
    //   1051: dup
    //   1052: aload 8
    //   1054: aload_3
    //   1055: invokespecial 884	gnu/expr/ReferenceExp:<init>	(Ljava/lang/Object;Lgnu/expr/Declaration;)V
    //   1058: astore 16
    //   1060: aload 16
    //   1062: aload 4
    //   1064: invokevirtual 887	gnu/expr/ReferenceExp:setContextDecl	(Lgnu/expr/Declaration;)V
    //   1067: aload 16
    //   1069: aload_0
    //   1070: invokevirtual 888	gnu/expr/ReferenceExp:setLine	(Lgnu/expr/Compilation;)V
    //   1073: iload_2
    //   1074: ifeq +15 -> 1089
    //   1077: iload 11
    //   1079: ifeq +10 -> 1089
    //   1082: aload 16
    //   1084: bipush 8
    //   1086: invokevirtual 890	gnu/expr/ReferenceExp:setFlag	(I)V
    //   1089: aload 16
    //   1091: areturn
    //   1092: aload_1
    //   1093: instanceof 892
    //   1096: ifeq +16 -> 1112
    //   1099: aload_0
    //   1100: aload_1
    //   1101: checkcast 892	gnu/expr/LangExp
    //   1104: invokevirtual 895	gnu/expr/LangExp:getLangValue	()Ljava/lang/Object;
    //   1107: iload_2
    //   1108: invokevirtual 715	kawa/lang/Translator:rewrite	(Ljava/lang/Object;Z)Lgnu/expr/Expression;
    //   1111: areturn
    //   1112: aload_1
    //   1113: instanceof 146
    //   1116: ifeq +8 -> 1124
    //   1119: aload_1
    //   1120: checkcast 146	gnu/expr/Expression
    //   1123: areturn
    //   1124: aload_1
    //   1125: getstatic 899	gnu/expr/Special:abstractSpecial	Lgnu/expr/Special;
    //   1128: if_acmpne +7 -> 1135
    //   1131: getstatic 902	gnu/expr/QuoteExp:abstractExp	Lgnu/expr/QuoteExp;
    //   1134: areturn
    //   1135: aload_1
    //   1136: aload_0
    //   1137: invokestatic 907	kawa/lang/Quote:quote	(Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;
    //   1140: aload_0
    //   1141: invokestatic 910	gnu/expr/QuoteExp:getInstance	(Ljava/lang/Object;Lgnu/text/SourceLocator;)Lgnu/expr/QuoteExp;
    //   1144: areturn
    //   1145: astore 26
    //   1147: aload 26
    //   1149: astore 20
    //   1151: aload 25
    //   1153: astore 4
    //   1155: goto -243 -> 912
    //   1158: aconst_null
    //   1159: astore 4
    //   1161: aconst_null
    //   1162: astore_3
    //   1163: goto -847 -> 316
    //   1166: aconst_null
    //   1167: astore 13
    //   1169: goto -482 -> 687
    //
    // Exception table:
    //   from	to	target	type
    //   19	44	53	finally
    //   725	744	906	java/lang/Throwable
    //   750	781	906	java/lang/Throwable
    //   784	797	906	java/lang/Throwable
    //   805	817	906	java/lang/Throwable
    //   841	855	906	java/lang/Throwable
    //   860	882	906	java/lang/Throwable
    //   817	834	1145	java/lang/Throwable
  }

  public void rewriteInBody(Object paramObject)
  {
    SyntaxForm localSyntaxForm;
    ScopeExp localScopeExp;
    if ((paramObject instanceof SyntaxForm))
    {
      localSyntaxForm = (SyntaxForm)paramObject;
      localScopeExp = this.current_scope;
    }
    while (true)
    {
      try
      {
        setCurrentScope(localSyntaxForm.getScope());
        rewriteInBody(localSyntaxForm.getDatum());
        return;
      }
      finally
      {
        setCurrentScope(localScopeExp);
      }
      if (!(paramObject instanceof Values))
        break;
      Object[] arrayOfObject = ((Values)paramObject).getValues();
      for (int i = 0; i < arrayOfObject.length; i++)
        rewriteInBody(arrayOfObject[i]);
    }
    this.formStack.add(rewrite(paramObject, false));
  }

  public Expression rewrite_body(Object paramObject)
  {
    Object localObject1 = pushPositionOf(paramObject);
    LetExp localLetExp = new LetExp(null);
    int i = this.formStack.size();
    localLetExp.outer = this.current_scope;
    this.current_scope = localLetExp;
    LList localLList;
    int j;
    Expression[] arrayOfExpression;
    try
    {
      localLList = scanBody(paramObject, localLetExp, true);
      if (localLList.isEmpty())
        this.formStack.add(syntaxError("body with no expressions"));
      j = localLetExp.countNonDynamicDecls();
      if (j == 0)
        break label131;
      arrayOfExpression = new Expression[j];
      int k = j;
      while (true)
      {
        k--;
        if (k < 0)
          break;
        arrayOfExpression[k] = QuoteExp.undefined_exp;
      }
    }
    finally
    {
      pop(localLetExp);
      popPositionOf(localObject1);
    }
    localLetExp.inits = arrayOfExpression;
    label131: rewriteBody(localLList);
    Expression localExpression = makeBody(i, null);
    setLineOf(localExpression);
    if (j == 0)
    {
      pop(localLetExp);
      popPositionOf(localObject1);
      return localExpression;
    }
    localLetExp.body = localExpression;
    setLineOf(localLetExp);
    pop(localLetExp);
    popPositionOf(localObject1);
    return localLetExp;
  }

  public final Expression rewrite_car(Pair paramPair, SyntaxForm paramSyntaxForm)
  {
    if ((paramSyntaxForm == null) || (paramSyntaxForm.getScope() == this.current_scope) || ((paramPair.getCar() instanceof SyntaxForm)))
      return rewrite_car(paramPair, false);
    ScopeExp localScopeExp = this.current_scope;
    try
    {
      setCurrentScope(paramSyntaxForm.getScope());
      Expression localExpression = rewrite_car(paramPair, false);
      return localExpression;
    }
    finally
    {
      setCurrentScope(localScopeExp);
    }
  }

  public final Expression rewrite_car(Pair paramPair, boolean paramBoolean)
  {
    Object localObject = paramPair.getCar();
    if ((paramPair instanceof PairWithPosition))
      return rewrite_with_position(localObject, paramBoolean, (PairWithPosition)paramPair);
    return rewrite(localObject, paramBoolean);
  }

  public Expression rewrite_pair(Pair paramPair, boolean paramBoolean)
  {
    Expression localExpression1 = rewrite_car(paramPair, true);
    if ((localExpression1 instanceof QuoteExp))
    {
      Object localObject7 = localExpression1.valueIfConstant();
      if ((localObject7 instanceof Syntax))
        return apply_rewrite((Syntax)localObject7, paramPair);
    }
    ReferenceExp localReferenceExp;
    Declaration localDeclaration1;
    Object localObject6;
    if ((localExpression1 instanceof ReferenceExp))
    {
      localReferenceExp = (ReferenceExp)localExpression1;
      localDeclaration1 = localReferenceExp.getBinding();
      if (localDeclaration1 != null)
        break label271;
      Object localObject4 = localReferenceExp.getSymbol();
      Symbol localSymbol3;
      Environment localEnvironment;
      if (((localObject4 instanceof Symbol)) && (!selfEvaluatingSymbol(localObject4)))
      {
        localSymbol3 = (Symbol)localObject4;
        localSymbol3.getName();
        localEnvironment = this.env;
        if (!getLanguage().hasSeparateFunctionNamespace())
          break label174;
      }
      label174: for (Object localObject5 = EnvironmentKey.FUNCTION; ; localObject5 = null)
      {
        localObject6 = localEnvironment.get(localSymbol3, localObject5, null);
        if (!(localObject6 instanceof Syntax))
          break label180;
        return apply_rewrite((Syntax)localObject6, paramPair);
        String str = localObject4.toString();
        localSymbol3 = this.env.getSymbol(str);
        break;
      }
      label180: if (!(localObject6 instanceof AutoloadProcedure));
    }
    Object localObject1;
    int i;
    while (true)
    {
      try
      {
        ((AutoloadProcedure)localObject6).getLoaded();
        localReferenceExp.setProcedureName(true);
        if (getLanguage().hasSeparateFunctionNamespace())
          localExpression1.setFlag(8);
        localObject1 = paramPair.getCdr();
        i = listLength(localObject1);
        if (i != -1)
          break;
        return syntaxError("circular list is not allowed after " + paramPair.getCar());
      }
      catch (RuntimeException localRuntimeException)
      {
        continue;
      }
      label271: Declaration localDeclaration2 = this.macroContext;
      Syntax localSyntax = check_if_Syntax(localDeclaration1);
      if (localSyntax != null)
      {
        Expression localExpression4 = apply_rewrite(localSyntax, paramPair);
        this.macroContext = localDeclaration2;
        return localExpression4;
      }
    }
    if (i < 0)
      return syntaxError("dotted list [" + localObject1 + "] is not allowed after " + paramPair.getCar());
    Stack localStack = new Stack();
    ScopeExp localScopeExp = this.current_scope;
    int j = 0;
    if (j < i)
    {
      if ((localObject1 instanceof SyntaxForm))
      {
        SyntaxForm localSyntaxForm = (SyntaxForm)localObject1;
        localObject1 = localSyntaxForm.getDatum();
        setCurrentScope(localSyntaxForm.getScope());
      }
      Pair localPair = (Pair)localObject1;
      Object localObject2 = rewrite_car(localPair, false);
      j++;
      if (0 != 0)
      {
        if ((j & 0x1) != 0)
          break label501;
        Expression[] arrayOfExpression2 = new Expression[2];
        arrayOfExpression2[0] = ((Expression)localStack.pop());
        arrayOfExpression2[1] = localObject2;
        MakeAttribute localMakeAttribute = MakeAttribute.makeAttribute;
        localObject2 = new ApplyExp(localMakeAttribute, arrayOfExpression2);
      }
      while (true)
      {
        localStack.addElement(localObject2);
        localObject1 = localPair.getCdr();
        break;
        label501: if ((localObject2 instanceof QuoteExp))
        {
          Object localObject3 = ((QuoteExp)localObject2).getValue();
          if (((localObject3 instanceof Keyword)) && (j < i))
          {
            Symbol localSymbol2 = ((Keyword)localObject3).asSymbol();
            localObject2 = new QuoteExp(localSymbol2);
          }
        }
      }
    }
    Expression[] arrayOfExpression1 = new Expression[localStack.size()];
    localStack.copyInto(arrayOfExpression1);
    if (localScopeExp != this.current_scope)
      setCurrentScope(localScopeExp);
    if (((localExpression1 instanceof ReferenceExp)) && (((ReferenceExp)localExpression1).getBinding() == getNamedPartDecl))
    {
      Expression localExpression2 = arrayOfExpression1[0];
      Expression localExpression3 = arrayOfExpression1[1];
      Symbol localSymbol1 = namespaceResolve(localExpression2, localExpression3);
      if (localSymbol1 != null)
        return rewrite(localSymbol1, paramBoolean);
      return CompileNamedPart.makeExp(localExpression2, localExpression3);
    }
    return ((LispLanguage)getLanguage()).makeApply(localExpression1, arrayOfExpression1);
  }

  public Expression rewrite_with_position(Object paramObject, boolean paramBoolean, PairWithPosition paramPairWithPosition)
  {
    Object localObject1 = pushPositionOf(paramPairWithPosition);
    if (paramObject == paramPairWithPosition);
    try
    {
      Expression localExpression;
      for (Object localObject3 = rewrite_pair(paramPairWithPosition, paramBoolean); ; localObject3 = localExpression)
      {
        setLineOf((Expression)localObject3);
        return localObject3;
        localExpression = rewrite(paramObject, paramBoolean);
      }
    }
    finally
    {
      popPositionOf(localObject1);
    }
  }

  public LList scanBody(Object paramObject, ScopeExp paramScopeExp, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = LList.Empty;
      localObject2 = null;
    }
    while (true)
    {
      while (true)
      {
        LList localLList1 = LList.Empty;
        if (paramObject == localLList1)
          break label360;
        if ((paramObject instanceof SyntaxForm))
        {
          SyntaxForm localSyntaxForm = (SyntaxForm)paramObject;
          ScopeExp localScopeExp = this.current_scope;
          try
          {
            setCurrentScope(localSyntaxForm.getScope());
            int m = this.formStack.size();
            LList localLList2 = scanBody(localSyntaxForm.getDatum(), paramScopeExp, paramBoolean);
            if (paramBoolean)
            {
              LList localLList3 = (LList)SyntaxForms.fromDatumIfNeeded(localLList2, localSyntaxForm);
              if (localObject2 == null)
              {
                return localLList3;
                localObject1 = null;
                break;
              }
              localObject2.setCdrBackdoor(localLList3);
              return localObject1;
            }
            this.formStack.add(wrapSyntax(popForms(m), localSyntaxForm));
            return null;
          }
          finally
          {
            setCurrentScope(localScopeExp);
          }
        }
      }
      if (!(paramObject instanceof Pair))
        break label345;
      Pair localPair1 = (Pair)paramObject;
      int i = this.formStack.size();
      scanForm(localPair1.getCar(), paramScopeExp);
      if (getState() == 2)
      {
        if (localPair1.getCar() != this.pendingForm)
          localPair1 = makePair(localPair1, this.pendingForm, localPair1.getCdr());
        this.pendingForm = new Pair(begin.begin, localPair1);
        return LList.Empty;
      }
      int j = this.formStack.size();
      if (paramBoolean)
      {
        int k = i;
        if (k < j)
        {
          Pair localPair2 = makePair(localPair1, this.formStack.elementAt(k), LList.Empty);
          if (localObject2 == null)
            localObject1 = localPair2;
          while (true)
          {
            localObject2 = localPair2;
            k++;
            break;
            localObject2.setCdrBackdoor(localPair2);
          }
        }
        this.formStack.setSize(i);
      }
      paramObject = localPair1.getCdr();
    }
    label345: this.formStack.add(syntaxError("body is not a proper list"));
    label360: return localObject1;
  }

  // ERROR //
  public void scanForm(Object paramObject, ScopeExp paramScopeExp)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 113
    //   4: ifeq +84 -> 88
    //   7: aload_1
    //   8: checkcast 113	kawa/lang/SyntaxForm
    //   11: astore 39
    //   13: aload_0
    //   14: invokevirtual 318	kawa/lang/Translator:currentScope	()Lgnu/expr/ScopeExp;
    //   17: astore 40
    //   19: aload_0
    //   20: aload 39
    //   22: invokeinterface 314 1 0
    //   27: invokevirtual 627	kawa/lang/Translator:setCurrentScope	(Lgnu/expr/ScopeExp;)V
    //   30: aload_0
    //   31: getfield 79	kawa/lang/Translator:formStack	Ljava/util/Stack;
    //   34: invokevirtual 135	java/util/Stack:size	()I
    //   37: istore 42
    //   39: aload_0
    //   40: aload 39
    //   42: invokeinterface 117 1 0
    //   47: aload_2
    //   48: invokevirtual 1011	kawa/lang/Translator:scanForm	(Ljava/lang/Object;Lgnu/expr/ScopeExp;)V
    //   51: aload_0
    //   52: getfield 79	kawa/lang/Translator:formStack	Ljava/util/Stack;
    //   55: aload_0
    //   56: iload 42
    //   58: invokevirtual 702	kawa/lang/Translator:popForms	(I)Ljava/lang/Object;
    //   61: aload 39
    //   63: invokestatic 1008	kawa/lang/Translator:wrapSyntax	(Ljava/lang/Object;Lkawa/lang/SyntaxForm;)Ljava/lang/Object;
    //   66: invokevirtual 917	java/util/Stack:add	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: aload_0
    //   71: aload 40
    //   73: invokevirtual 627	kawa/lang/Translator:setCurrentScope	(Lgnu/expr/ScopeExp;)V
    //   76: return
    //   77: astore 41
    //   79: aload_0
    //   80: aload 40
    //   82: invokevirtual 627	kawa/lang/Translator:setCurrentScope	(Lgnu/expr/ScopeExp;)V
    //   85: aload 41
    //   87: athrow
    //   88: aload_1
    //   89: instanceof 592
    //   92: ifeq +18 -> 110
    //   95: getstatic 596	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   98: astore 35
    //   100: aload_1
    //   101: aload 35
    //   103: if_acmpne +429 -> 532
    //   106: getstatic 141	gnu/expr/QuoteExp:voidExp	Lgnu/expr/QuoteExp;
    //   109: astore_1
    //   110: aload_1
    //   111: instanceof 125
    //   114: ifeq +581 -> 695
    //   117: aload_1
    //   118: checkcast 125	gnu/lists/Pair
    //   121: astore 4
    //   123: aload_0
    //   124: getfield 261	kawa/lang/Translator:macroContext	Lgnu/expr/Declaration;
    //   127: astore 5
    //   129: aload_0
    //   130: getfield 269	kawa/lang/Translator:current_scope	Lgnu/expr/ScopeExp;
    //   133: astore 6
    //   135: aload_0
    //   136: aload_1
    //   137: invokevirtual 190	kawa/lang/Translator:pushPositionOf	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: astore 7
    //   142: aload_1
    //   143: instanceof 209
    //   146: ifeq +18 -> 164
    //   149: aload_2
    //   150: invokevirtual 1027	gnu/expr/ScopeExp:getLineNumber	()I
    //   153: ifge +11 -> 164
    //   156: aload_2
    //   157: aload_1
    //   158: checkcast 209	gnu/text/SourceLocator
    //   161: invokevirtual 1028	gnu/expr/ScopeExp:setLocation	(Lgnu/text/SourceLocator;)V
    //   164: aload 4
    //   166: invokevirtual 193	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   169: astore 9
    //   171: aload 9
    //   173: instanceof 113
    //   176: ifeq +33 -> 209
    //   179: aload 4
    //   181: invokevirtual 193	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   184: checkcast 113	kawa/lang/SyntaxForm
    //   187: astore 34
    //   189: aload_0
    //   190: aload 34
    //   192: invokeinterface 314 1 0
    //   197: invokevirtual 627	kawa/lang/Translator:setCurrentScope	(Lgnu/expr/ScopeExp;)V
    //   200: aload 34
    //   202: invokeinterface 117 1 0
    //   207: astore 9
    //   209: aload 9
    //   211: instanceof 125
    //   214: istore 10
    //   216: aconst_null
    //   217: astore 11
    //   219: iload 10
    //   221: ifeq +174 -> 395
    //   224: aload 9
    //   226: checkcast 125	gnu/lists/Pair
    //   229: astore 12
    //   231: aload 12
    //   233: invokevirtual 193	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   236: astore 13
    //   238: getstatic 542	gnu/kawa/lispexpr/LispLanguage:lookup_sym	Lgnu/mapping/Symbol;
    //   241: astore 14
    //   243: aconst_null
    //   244: astore 11
    //   246: aload 13
    //   248: aload 14
    //   250: if_acmpne +145 -> 395
    //   253: aload 12
    //   255: invokevirtual 128	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   258: instanceof 125
    //   261: istore 15
    //   263: aconst_null
    //   264: astore 11
    //   266: iload 15
    //   268: ifeq +127 -> 395
    //   271: aload 12
    //   273: invokevirtual 128	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   276: checkcast 125	gnu/lists/Pair
    //   279: astore 16
    //   281: aload 16
    //   283: invokevirtual 128	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   286: instanceof 125
    //   289: istore 17
    //   291: aconst_null
    //   292: astore 11
    //   294: iload 17
    //   296: ifeq +99 -> 395
    //   299: aload_0
    //   300: aload 16
    //   302: invokevirtual 193	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   305: invokevirtual 546	kawa/lang/Translator:rewrite	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   308: astore 18
    //   310: aload_0
    //   311: aload 16
    //   313: invokevirtual 128	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   316: checkcast 125	gnu/lists/Pair
    //   319: invokevirtual 193	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   322: invokevirtual 546	kawa/lang/Translator:rewrite	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   325: astore 19
    //   327: aload 18
    //   329: invokevirtual 956	gnu/expr/Expression:valueIfConstant	()Ljava/lang/Object;
    //   332: astore 20
    //   334: aload 19
    //   336: invokevirtual 956	gnu/expr/Expression:valueIfConstant	()Ljava/lang/Object;
    //   339: astore 21
    //   341: aload 20
    //   343: instanceof 360
    //   346: ifeq +237 -> 583
    //   349: aload 21
    //   351: instanceof 514
    //   354: istore 31
    //   356: iload 31
    //   358: ifeq +225 -> 583
    //   361: aload 20
    //   363: aload 21
    //   365: checkcast 514	gnu/mapping/Symbol
    //   368: invokestatic 1033	gnu/kawa/functions/GetNamedPart:getNamedPart	(Ljava/lang/Object;Lgnu/mapping/Symbol;)Ljava/lang/Object;
    //   371: astore 9
    //   373: aload 9
    //   375: instanceof 237
    //   378: istore 33
    //   380: aconst_null
    //   381: astore 11
    //   383: iload 33
    //   385: ifeq +10 -> 395
    //   388: aload 9
    //   390: checkcast 237	kawa/lang/Syntax
    //   393: astore 11
    //   395: aload 9
    //   397: instanceof 514
    //   400: ifeq +226 -> 626
    //   403: aload_0
    //   404: aload 9
    //   406: invokevirtual 509	kawa/lang/Translator:selfEvaluatingSymbol	(Ljava/lang/Object;)Z
    //   409: ifne +217 -> 626
    //   412: aload_0
    //   413: aload 9
    //   415: iconst_1
    //   416: invokevirtual 715	kawa/lang/Translator:rewrite	(Ljava/lang/Object;Z)Lgnu/expr/Expression;
    //   419: astore 27
    //   421: aload 27
    //   423: instanceof 109
    //   426: ifeq +30 -> 456
    //   429: aload 27
    //   431: checkcast 109	gnu/expr/ReferenceExp
    //   434: invokevirtual 561	gnu/expr/ReferenceExp:getBinding	()Lgnu/expr/Declaration;
    //   437: astore 28
    //   439: aload 28
    //   441: ifnull +158 -> 599
    //   444: aload_0
    //   445: aload 28
    //   447: invokevirtual 978	kawa/lang/Translator:check_if_Syntax	(Lgnu/expr/Declaration;)Lkawa/lang/Syntax;
    //   450: astore 29
    //   452: aload 29
    //   454: astore 11
    //   456: aload 6
    //   458: aload_0
    //   459: getfield 269	kawa/lang/Translator:current_scope	Lgnu/expr/ScopeExp;
    //   462: if_acmpeq +9 -> 471
    //   465: aload_0
    //   466: aload 6
    //   468: invokevirtual 627	kawa/lang/Translator:setCurrentScope	(Lgnu/expr/ScopeExp;)V
    //   471: aload_0
    //   472: aload 7
    //   474: invokevirtual 200	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   477: aload 11
    //   479: ifnull +216 -> 695
    //   482: aload_0
    //   483: invokevirtual 651	kawa/lang/Translator:getFileName	()Ljava/lang/String;
    //   486: astore 23
    //   488: aload_0
    //   489: invokevirtual 655	kawa/lang/Translator:getLineNumber	()I
    //   492: istore 24
    //   494: aload_0
    //   495: invokevirtual 659	kawa/lang/Translator:getColumnNumber	()I
    //   498: istore 25
    //   500: aload_0
    //   501: aload 4
    //   503: invokevirtual 602	kawa/lang/Translator:setLine	(Ljava/lang/Object;)V
    //   506: aload 11
    //   508: aload 4
    //   510: aload_2
    //   511: aload_0
    //   512: invokevirtual 1036	kawa/lang/Syntax:scanForm	(Lgnu/lists/Pair;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)V
    //   515: aload_0
    //   516: aload 5
    //   518: putfield 261	kawa/lang/Translator:macroContext	Lgnu/expr/Declaration;
    //   521: aload_0
    //   522: aload 23
    //   524: iload 24
    //   526: iload 25
    //   528: invokevirtual 1039	kawa/lang/Translator:setLine	(Ljava/lang/String;II)V
    //   531: return
    //   532: aload_1
    //   533: checkcast 592	gnu/mapping/Values
    //   536: invokevirtual 914	gnu/mapping/Values:getValues	()[Ljava/lang/Object;
    //   539: astore 36
    //   541: iconst_0
    //   542: istore 37
    //   544: aload 36
    //   546: arraylength
    //   547: istore 38
    //   549: iload 37
    //   551: iload 38
    //   553: if_icmpge -477 -> 76
    //   556: aload_0
    //   557: aload 36
    //   559: iload 37
    //   561: aaload
    //   562: aload_2
    //   563: invokevirtual 1011	kawa/lang/Translator:scanForm	(Ljava/lang/Object;Lgnu/expr/ScopeExp;)V
    //   566: iinc 37 1
    //   569: goto -25 -> 544
    //   572: astore 32
    //   574: aconst_null
    //   575: astore 9
    //   577: aconst_null
    //   578: astore 11
    //   580: goto -185 -> 395
    //   583: aload_0
    //   584: aload 18
    //   586: aload 19
    //   588: invokevirtual 548	kawa/lang/Translator:namespaceResolve	(Lgnu/expr/Expression;Lgnu/expr/Expression;)Lgnu/mapping/Symbol;
    //   591: astore 9
    //   593: aconst_null
    //   594: astore 11
    //   596: goto -201 -> 395
    //   599: aload_0
    //   600: aload 9
    //   602: iconst_1
    //   603: invokevirtual 1043	kawa/lang/Translator:resolve	(Ljava/lang/Object;Z)Ljava/lang/Object;
    //   606: astore 30
    //   608: aload 30
    //   610: instanceof 237
    //   613: ifeq -157 -> 456
    //   616: aload 30
    //   618: checkcast 237	kawa/lang/Syntax
    //   621: astore 11
    //   623: goto -167 -> 456
    //   626: getstatic 1024	kawa/standard/begin:begin	Lkawa/standard/begin;
    //   629: astore 22
    //   631: aload 9
    //   633: aload 22
    //   635: if_acmpne -179 -> 456
    //   638: aload 9
    //   640: checkcast 237	kawa/lang/Syntax
    //   643: astore 11
    //   645: goto -189 -> 456
    //   648: astore 8
    //   650: aload 6
    //   652: aload_0
    //   653: getfield 269	kawa/lang/Translator:current_scope	Lgnu/expr/ScopeExp;
    //   656: if_acmpeq +9 -> 665
    //   659: aload_0
    //   660: aload 6
    //   662: invokevirtual 627	kawa/lang/Translator:setCurrentScope	(Lgnu/expr/ScopeExp;)V
    //   665: aload_0
    //   666: aload 7
    //   668: invokevirtual 200	kawa/lang/Translator:popPositionOf	(Ljava/lang/Object;)V
    //   671: aload 8
    //   673: athrow
    //   674: astore 26
    //   676: aload_0
    //   677: aload 5
    //   679: putfield 261	kawa/lang/Translator:macroContext	Lgnu/expr/Declaration;
    //   682: aload_0
    //   683: aload 23
    //   685: iload 24
    //   687: iload 25
    //   689: invokevirtual 1039	kawa/lang/Translator:setLine	(Ljava/lang/String;II)V
    //   692: aload 26
    //   694: athrow
    //   695: aload_0
    //   696: getfield 79	kawa/lang/Translator:formStack	Ljava/util/Stack;
    //   699: aload_1
    //   700: invokevirtual 917	java/util/Stack:add	(Ljava/lang/Object;)Z
    //   703: pop
    //   704: return
    //
    // Exception table:
    //   from	to	target	type
    //   19	70	77	finally
    //   361	380	572	java/lang/Throwable
    //   388	395	572	java/lang/Throwable
    //   164	209	648	finally
    //   209	216	648	finally
    //   224	243	648	finally
    //   253	263	648	finally
    //   271	291	648	finally
    //   299	356	648	finally
    //   361	380	648	finally
    //   388	395	648	finally
    //   395	439	648	finally
    //   444	452	648	finally
    //   583	593	648	finally
    //   599	623	648	finally
    //   626	631	648	finally
    //   638	645	648	finally
    //   500	515	674	finally
  }

  public final boolean selfEvaluatingSymbol(Object paramObject)
  {
    return ((LispLanguage)getLanguage()).selfEvaluatingSymbol(paramObject);
  }

  public void setLineOf(Expression paramExpression)
  {
    if ((paramExpression instanceof QuoteExp))
      return;
    paramExpression.setLocation(this);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.Translator
 * JD-Core Version:    0.6.2
 */