package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.kawa.lispexpr.ClassNamespace;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.AbstractFormat;
import gnu.lists.CharSeq;
import gnu.lists.Consumer;
import gnu.lists.Convert;
import gnu.lists.FString;
import gnu.lists.PrintConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.InPort;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.NamedLocation;
import gnu.mapping.Namespace;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kawa.repl;

public abstract class Language
{
  public static final int FUNCTION_NAMESPACE = 2;
  public static final int NAMESPACE_PREFIX_NAMESPACE = 4;
  public static final int PARSE_CURRENT_NAMES = 2;
  public static final int PARSE_EXPLICIT = 64;
  public static final int PARSE_FOR_APPLET = 16;
  public static final int PARSE_FOR_EVAL = 3;
  public static final int PARSE_FOR_SERVLET = 32;
  public static final int PARSE_IMMEDIATE = 1;
  public static final int PARSE_ONE_LINE = 4;
  public static final int PARSE_PROLOG = 8;
  public static final int VALUE_NAMESPACE = 1;
  protected static final InheritableThreadLocal<Language> current = new InheritableThreadLocal();
  static int envCounter;
  protected static int env_counter = 0;
  protected static Language global;
  static String[][] languages;
  public static boolean requirePedantic;
  protected Environment environ;
  protected Environment userEnv;

  static
  {
    Environment.setGlobal(BuiltinEnvironment.getInstance());
    languages = new String[][] { { "scheme", ".scm", ".sc", "kawa.standard.Scheme" }, { "krl", ".krl", "gnu.kawa.brl.BRL" }, { "brl", ".brl", "gnu.kawa.brl.BRL" }, { "emacs", "elisp", "emacs-lisp", ".el", "gnu.jemacs.lang.ELisp" }, { "xquery", ".xquery", ".xq", ".xql", "gnu.xquery.lang.XQuery" }, { "q2", ".q2", "gnu.q2.lang.Q2" }, { "xslt", "xsl", ".xsl", "gnu.kawa.xslt.XSLT" }, { "commonlisp", "common-lisp", "clisp", "lisp", ".lisp", ".lsp", ".cl", "gnu.commonlisp.lang.CommonLisp" } };
  }

  protected Language()
  {
    Convert.setInstance(KawaConvert.getInstance());
  }

  public static Language detect(InPort paramInPort)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramInPort.mark(300);
    paramInPort.readLine(localStringBuffer, 'P');
    paramInPort.reset();
    return detect(localStringBuffer.toString());
  }

  public static Language detect(InputStream paramInputStream)
    throws IOException
  {
    if (!paramInputStream.markSupported())
      return null;
    StringBuffer localStringBuffer = new StringBuffer();
    paramInputStream.mark(200);
    while (true)
    {
      if (localStringBuffer.length() >= 200);
      int i;
      do
      {
        paramInputStream.reset();
        return detect(localStringBuffer.toString());
        i = paramInputStream.read();
      }
      while ((i < 0) || (i == 10) || (i == 13));
      localStringBuffer.append((char)i);
    }
  }

  public static Language detect(String paramString)
  {
    String str = paramString.trim();
    int i = str.indexOf("kawa:");
    if (i >= 0)
    {
      int j = i + 5;
      for (int k = j; (k < str.length()) && (Character.isJavaIdentifierPart(str.charAt(k))); k++);
      if (k > j)
      {
        Language localLanguage = getInstance(str.substring(j, k));
        if (localLanguage != null)
          return localLanguage;
      }
    }
    if (str.indexOf("-*- scheme -*-") >= 0)
      return getInstance("scheme");
    if (str.indexOf("-*- xquery -*-") >= 0)
      return getInstance("xquery");
    if (str.indexOf("-*- emacs-lisp -*-") >= 0)
      return getInstance("elisp");
    if ((str.indexOf("-*- common-lisp -*-") >= 0) || (str.indexOf("-*- lisp -*-") >= 0))
      return getInstance("common-lisp");
    if (((str.charAt(0) == '(') && (str.charAt(1) == ':')) || ((str.length() >= 7) && (str.substring(0, 7).equals("xquery "))))
      return getInstance("xquery");
    if ((str.charAt(0) == ';') && (str.charAt(1) == ';'))
      return getInstance("scheme");
    return null;
  }

  public static Language getDefaultLanguage()
  {
    Language localLanguage = (Language)current.get();
    if (localLanguage != null)
      return localLanguage;
    return global;
  }

  public static Language getInstance(String paramString)
  {
    int i = languages.length;
    for (int j = 0; j < i; j++)
    {
      String[] arrayOfString = languages[j];
      int k = arrayOfString.length - 1;
      int m = k;
      do
      {
        m--;
        if (m < 0)
          break;
      }
      while ((paramString != null) && (!arrayOfString[m].equalsIgnoreCase(paramString)));
      try
      {
        Class localClass = Class.forName(arrayOfString[k]);
        return getInstance(arrayOfString[0], localClass);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
      }
    }
    return null;
  }

  public static Language getInstance(String paramString, Class paramClass)
  {
    String str1;
    try
    {
      Class[] arrayOfClass = new Class[0];
      try
      {
        String str2 = Character.toTitleCase(paramString.charAt(0)) + paramString.substring(1).toLowerCase();
        Method localMethod2 = paramClass.getDeclaredMethod("get" + str2 + "Instance", arrayOfClass);
        localObject2 = localMethod2;
        return (Language)((Method)localObject2).invoke(null, Values.noArgs);
      }
      catch (Exception localException1)
      {
        while (true)
        {
          Method localMethod1 = paramClass.getDeclaredMethod("getInstance", arrayOfClass);
          Object localObject2 = localMethod1;
        }
      }
    }
    catch (Exception localException2)
    {
      str1 = paramClass.getName();
      if (!(localException2 instanceof InvocationTargetException));
    }
    for (Object localObject1 = ((InvocationTargetException)localException2).getTargetException(); ; localObject1 = localException2)
      throw new WrappedException("getInstance for '" + str1 + "' failed", (Throwable)localObject1);
  }

  public static Language getInstanceFromFilenameExtension(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    if (i > 0)
    {
      Language localLanguage = getInstance(paramString.substring(i));
      if (localLanguage != null)
        return localLanguage;
    }
    return null;
  }

  public static String[][] getLanguages()
  {
    return languages;
  }

  public static void registerLanguage(String[] paramArrayOfString)
  {
    String[][] arrayOfString; = new String[1 + languages.length][];
    System.arraycopy(languages, 0, arrayOfString;, 0, languages.length);
    arrayOfString;[(arrayOfString;.length - 1)] = paramArrayOfString;
    languages = arrayOfString;;
  }

  public static void restoreCurrent(Language paramLanguage)
  {
    current.set(paramLanguage);
  }

  public static void setCurrentLanguage(Language paramLanguage)
  {
    current.set(paramLanguage);
  }

  public static void setDefaults(Language paramLanguage)
  {
    try
    {
      setCurrentLanguage(paramLanguage);
      global = paramLanguage;
      if (Environment.getGlobal() == BuiltinEnvironment.getInstance())
        Environment.setGlobal(Environment.getCurrent());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static Language setSaveCurrent(Language paramLanguage)
  {
    Language localLanguage = (Language)current.get();
    current.set(paramLanguage);
    return localLanguage;
  }

  public static Type string2Type(String paramString)
  {
    Type localType;
    if (paramString.endsWith("[]"))
    {
      localType = string2Type(paramString.substring(0, paramString.length() - 2));
      if (localType == null)
        return null;
    }
    for (Object localObject = ArrayType.make(localType); ; localObject = Type.getType(paramString))
    {
      return localObject;
      if (!Type.isValidJavaTypeName(paramString))
        break;
    }
    return null;
  }

  public static Type unionType(Type paramType1, Type paramType2)
  {
    if (paramType1 == Type.toStringType)
      paramType1 = Type.javalangStringType;
    if (paramType2 == Type.toStringType)
      paramType2 = Type.javalangStringType;
    if (paramType1 == paramType2)
      return paramType1;
    if (((paramType1 instanceof PrimType)) && ((paramType2 instanceof PrimType)))
    {
      int i = paramType1.getSignature().charAt(0);
      int j = paramType2.getSignature().charAt(0);
      if (i == j)
        return paramType1;
      if (((i == 66) || (i == 83) || (i == 73)) && ((j == 73) || (j == 74)))
        return paramType2;
      if (((j == 66) || (j == 83) || (j == 73)) && ((i == 73) || (i == 74)))
        return paramType1;
      if ((i == 70) && (j == 68))
        return paramType2;
      if ((j == 70) && (i == 68))
        return paramType1;
      return Type.objectType;
    }
    return Type.objectType;
  }

  public final Type asType(Object paramObject)
  {
    Type localType = getTypeFor(paramObject, true);
    if (localType == null)
      return (Type)paramObject;
    return localType;
  }

  public Object booleanObject(boolean paramBoolean)
  {
    if (paramBoolean)
      return Boolean.TRUE;
    return Boolean.FALSE;
  }

  public Object coerceFromObject(Class paramClass, Object paramObject)
  {
    return getTypeFor(paramClass).coerceFromObject(paramObject);
  }

  public Object coerceToObject(Class paramClass, Object paramObject)
  {
    return getTypeFor(paramClass).coerceToObject(paramObject);
  }

  public Declaration declFromField(ModuleExp paramModuleExp, Object paramObject, gnu.bytecode.Field paramField)
  {
    String str1 = paramField.getName();
    Type localType = paramField.getType();
    boolean bool1 = localType.isSubtype(Compilation.typeLocation);
    int i = 0;
    int j;
    boolean bool2;
    Object localObject1;
    label57: String str2;
    String str3;
    Object localObject2;
    if ((0x10 & paramField.getModifiers()) != 0)
    {
      j = 1;
      bool2 = str1.endsWith("$instance");
      if (!bool2)
        break label242;
      localObject1 = str1;
      if (!(localObject1 instanceof String))
        break label409;
      str2 = paramModuleExp.getNamespaceUri();
      str3 = (String)localObject1;
      if (str2 != null)
        break label319;
      localObject2 = SimpleSymbol.valueOf(str3);
    }
    while (true)
    {
      label90: Object localObject3;
      label100: Declaration localDeclaration;
      int k;
      if (bool1)
      {
        localObject3 = Type.objectType;
        localDeclaration = paramModuleExp.addDeclaration(localObject2, (Type)localObject3);
        if ((0x8 & paramField.getModifiers()) == 0)
          break label345;
        k = 1;
        label123: if (!bool1)
          break label351;
        localDeclaration.setIndirectBinding(true);
        if (((localType instanceof ClassType)) && (((ClassType)localType).isSubclass("gnu.mapping.ThreadLocation")))
          localDeclaration.setFlag(268435456L);
      }
      while (true)
      {
        if (k != 0)
          localDeclaration.setFlag(2048L);
        localDeclaration.field = paramField;
        if ((j != 0) && (!bool1))
          localDeclaration.setFlag(16384L);
        if (bool2)
          localDeclaration.setFlag(1073741824L);
        localDeclaration.setSimple(false);
        if (i != 0)
          localDeclaration.setFlag(524320L);
        return localDeclaration;
        j = 0;
        break;
        label242: if ((j != 0) && ((paramObject instanceof Named)))
        {
          localObject1 = ((Named)paramObject).getSymbol();
          i = 0;
          break label57;
        }
        boolean bool3 = str1.startsWith("$Prvt$");
        i = 0;
        if (bool3)
        {
          i = 1;
          str1 = str1.substring("$Prvt$".length());
        }
        localObject1 = Compilation.demangleName(str1, true).intern();
        break label57;
        label319: localObject2 = Symbol.make(str2, str3);
        break label90;
        localObject3 = getTypeFor(localType.getReflectClass());
        break label100;
        label345: k = 0;
        break label123;
        label351: if ((j != 0) && ((localType instanceof ClassType)))
          if (localType.isSubtype(Compilation.typeProcedure))
            localDeclaration.setProcedureDecl(true);
          else if (((ClassType)localType).isSubclass("gnu.mapping.Namespace"))
            localDeclaration.setFlag(2097152L);
      }
      label409: localObject2 = localObject1;
    }
  }

  protected void defAliasStFld(String paramString1, String paramString2, String paramString3)
  {
    StaticFieldLocation.define(this.environ, getSymbol(paramString1), null, paramString2, paramString3);
  }

  protected void defProcStFld(String paramString1, String paramString2)
  {
    defProcStFld(paramString1, paramString2, Compilation.mangleNameIfNeeded(paramString1));
  }

  protected void defProcStFld(String paramString1, String paramString2, String paramString3)
  {
    if (hasSeparateFunctionNamespace());
    for (Object localObject = EnvironmentKey.FUNCTION; ; localObject = null)
    {
      Symbol localSymbol = getSymbol(paramString1);
      StaticFieldLocation.define(this.environ, localSymbol, localObject, paramString2, paramString3).setProcedure();
      return;
    }
  }

  public void define(String paramString, Object paramObject)
  {
    Symbol localSymbol = getSymbol(paramString);
    this.environ.define(localSymbol, null, paramObject);
  }

  public final void defineFunction(Named paramNamed)
  {
    Object localObject1 = paramNamed.getSymbol();
    Symbol localSymbol;
    if ((localObject1 instanceof Symbol))
    {
      localSymbol = (Symbol)localObject1;
      if (!hasSeparateFunctionNamespace())
        break label55;
    }
    label55: for (Object localObject2 = EnvironmentKey.FUNCTION; ; localObject2 = null)
    {
      this.environ.define(localSymbol, localObject2, paramNamed);
      return;
      localSymbol = getSymbol(localObject1.toString());
      break;
    }
  }

  public void defineFunction(String paramString, Object paramObject)
  {
    if (hasSeparateFunctionNamespace());
    for (Object localObject = EnvironmentKey.FUNCTION; ; localObject = null)
    {
      this.environ.define(getSymbol(paramString), localObject, paramObject);
      return;
    }
  }

  public void emitCoerceToBoolean(CodeAttr paramCodeAttr)
  {
    emitPushBoolean(false, paramCodeAttr);
    paramCodeAttr.emitIfNEq();
    paramCodeAttr.emitPushInt(1);
    paramCodeAttr.emitElse();
    paramCodeAttr.emitPushInt(0);
    paramCodeAttr.emitFi();
  }

  public void emitPushBoolean(boolean paramBoolean, CodeAttr paramCodeAttr)
  {
    if (paramBoolean);
    for (gnu.bytecode.Field localField = Compilation.trueConstant; ; localField = Compilation.falseConstant)
    {
      paramCodeAttr.emitGetStatic(localField);
      return;
    }
  }

  public final Object eval(InPort paramInPort)
    throws Throwable
  {
    CallContext localCallContext = CallContext.getInstance();
    int i = localCallContext.startFromContext();
    try
    {
      eval(paramInPort, localCallContext);
      Object localObject = localCallContext.getFromContext(i);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localCallContext.cleanupFromContext(i);
      throw localThrowable;
    }
  }

  public final Object eval(Reader paramReader)
    throws Throwable
  {
    if ((paramReader instanceof InPort));
    for (InPort localInPort = (InPort)paramReader; ; localInPort = new InPort(paramReader))
      return eval(localInPort);
  }

  public final Object eval(String paramString)
    throws Throwable
  {
    return eval(new CharArrayInPort(paramString));
  }

  public void eval(InPort paramInPort, CallContext paramCallContext)
    throws Throwable
  {
    SourceMessages localSourceMessages = new SourceMessages();
    Language localLanguage = setSaveCurrent(this);
    try
    {
      Compilation localCompilation = parse(paramInPort, localSourceMessages, 3);
      ModuleExp.evalModule(getEnvironment(), paramCallContext, localCompilation, null, null);
      restoreCurrent(localLanguage);
      if (localSourceMessages.seenErrors())
        throw new RuntimeException("invalid syntax in eval form:\n" + localSourceMessages.toString(20));
    }
    finally
    {
      restoreCurrent(localLanguage);
    }
  }

  public void eval(Reader paramReader, Consumer paramConsumer)
    throws Throwable
  {
    InPort localInPort;
    if ((paramReader instanceof InPort))
      localInPort = (InPort)paramReader;
    while (true)
    {
      CallContext localCallContext = CallContext.getInstance();
      Consumer localConsumer = localCallContext.consumer;
      try
      {
        localCallContext.consumer = paramConsumer;
        eval(localInPort, localCallContext);
        return;
        localInPort = new InPort(paramReader);
      }
      finally
      {
        localCallContext.consumer = localConsumer;
      }
    }
  }

  public final void eval(Reader paramReader, Writer paramWriter)
    throws Throwable
  {
    eval(paramReader, getOutputConsumer(paramWriter));
  }

  public final void eval(String paramString, Consumer paramConsumer)
    throws Throwable
  {
    eval(new CharArrayInPort(paramString), paramConsumer);
  }

  public final void eval(String paramString, PrintConsumer paramPrintConsumer)
    throws Throwable
  {
    eval(paramString, getOutputConsumer(paramPrintConsumer));
  }

  public final void eval(String paramString, Writer paramWriter)
    throws Throwable
  {
    eval(new CharArrayInPort(paramString), paramWriter);
  }

  public String formatType(Type paramType)
  {
    return paramType.getName();
  }

  public Compilation getCompilation(Lexer paramLexer, SourceMessages paramSourceMessages, NameLookup paramNameLookup)
  {
    return new Compilation(this, paramSourceMessages, paramNameLookup);
  }

  public Object getEnvPropertyFor(Declaration paramDeclaration)
  {
    if ((hasSeparateFunctionNamespace()) && (paramDeclaration.isProcedureDecl()))
      return EnvironmentKey.FUNCTION;
    return null;
  }

  public Object getEnvPropertyFor(java.lang.reflect.Field paramField, Object paramObject)
  {
    if (!hasSeparateFunctionNamespace())
      return null;
    if (Compilation.typeProcedure.getReflectClass().isAssignableFrom(paramField.getType()))
      return EnvironmentKey.FUNCTION;
    return null;
  }

  public final Environment getEnvironment()
  {
    if (this.userEnv != null)
      return this.userEnv;
    return Environment.getCurrent();
  }

  public AbstractFormat getFormat(boolean paramBoolean)
  {
    return null;
  }

  public Environment getLangEnvironment()
  {
    return this.environ;
  }

  public final Type getLangTypeFor(Type paramType)
  {
    if (paramType.isExisting())
    {
      Class localClass = paramType.getReflectClass();
      if (localClass != null)
        return getTypeFor(localClass);
    }
    return paramType;
  }

  public abstract Lexer getLexer(InPort paramInPort, SourceMessages paramSourceMessages);

  public String getName()
  {
    String str = getClass().getName();
    int i = str.lastIndexOf('.');
    if (i >= 0)
      str = str.substring(i + 1);
    return str;
  }

  public int getNamespaceOf(Declaration paramDeclaration)
  {
    return 1;
  }

  public final Environment getNewEnvironment()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("environment-");
    int i = 1 + envCounter;
    envCounter = i;
    return Environment.make(i, this.environ);
  }

  public Consumer getOutputConsumer(Writer paramWriter)
  {
    if ((paramWriter instanceof OutPort));
    for (OutPort localOutPort = (OutPort)paramWriter; ; localOutPort = new OutPort(paramWriter))
    {
      localOutPort.objectFormat = getFormat(false);
      return localOutPort;
    }
  }

  public Procedure getPrompter()
  {
    boolean bool = hasSeparateFunctionNamespace();
    Object localObject = null;
    if (bool)
      localObject = EnvironmentKey.FUNCTION;
    Procedure localProcedure = (Procedure)getEnvironment().get(getSymbol("default-prompter"), localObject, null);
    if (localProcedure != null)
      return localProcedure;
    return new SimplePrompter();
  }

  public Symbol getSymbol(String paramString)
  {
    return this.environ.getSymbol(paramString);
  }

  public final Type getTypeFor(Expression paramExpression)
  {
    return getTypeFor(paramExpression, true);
  }

  public Type getTypeFor(Expression paramExpression, boolean paramBoolean)
  {
    if ((paramExpression instanceof QuoteExp))
    {
      Object localObject3 = ((QuoteExp)paramExpression).getValue();
      if ((localObject3 instanceof Type))
        return (Type)localObject3;
      if ((localObject3 instanceof Class))
        return Type.make((Class)localObject3);
      return getTypeFor(localObject3, paramBoolean);
    }
    if ((paramExpression instanceof ReferenceExp))
    {
      ReferenceExp localReferenceExp = (ReferenceExp)paramExpression;
      Declaration localDeclaration = Declaration.followAliases(localReferenceExp.getBinding());
      String str = localReferenceExp.getName();
      Expression localExpression;
      if (localDeclaration != null)
      {
        localExpression = localDeclaration.getValue();
        if (((localExpression instanceof QuoteExp)) && (localDeclaration.getFlag(16384L)) && (!localDeclaration.isIndirectBinding()))
          return getTypeFor(((QuoteExp)localExpression).getValue(), paramBoolean);
        if (((localExpression instanceof ClassExp)) || ((localExpression instanceof ModuleExp)))
        {
          localDeclaration.setCanRead(true);
          return ((LambdaExp)localExpression).getClassType();
        }
        if ((!localDeclaration.isAlias()) || (!(localExpression instanceof QuoteExp)))
          break label273;
        localObject2 = ((QuoteExp)localExpression).getValue();
        if ((localObject2 instanceof Location))
        {
          localLocation = (Location)localObject2;
          if (localLocation.isBound())
            return getTypeFor(localLocation.get(), paramBoolean);
          if (!(localLocation instanceof Named))
            return null;
          str = ((Named)localLocation).getName();
        }
      }
      Object localObject1;
      label273: 
      while (localDeclaration.getFlag(65536L))
      {
        Object localObject2;
        Location localLocation;
        localObject1 = getEnvironment().get(str);
        if (!(localObject1 instanceof Type))
          break;
        return (Type)localObject1;
      }
      return getTypeFor(localExpression, paramBoolean);
      if ((localObject1 instanceof ClassNamespace))
        return ((ClassNamespace)localObject1).getClassType();
      int i = str.length();
      if ((i > 2) && (str.charAt(0) == '<') && (str.charAt(i - 1) == '>'))
        return getTypeFor(str.substring(1, i - 1));
    }
    else if (((paramExpression instanceof ClassExp)) || ((paramExpression instanceof ModuleExp)))
    {
      return ((LambdaExp)paramExpression).getClassType();
    }
    return null;
  }

  public Type getTypeFor(Class paramClass)
  {
    return Type.make(paramClass);
  }

  public final Type getTypeFor(Object paramObject, boolean paramBoolean)
  {
    if ((paramObject instanceof Type))
      return (Type)paramObject;
    if ((paramObject instanceof Class))
      return getTypeFor((Class)paramObject);
    if ((paramBoolean) && (((paramObject instanceof FString)) || ((paramObject instanceof String)) || (((paramObject instanceof Symbol)) && (((Symbol)paramObject).hasEmptyNamespace())) || ((paramObject instanceof CharSeq))))
      return getTypeFor(paramObject.toString());
    if ((paramObject instanceof Namespace))
    {
      String str = ((Namespace)paramObject).getName();
      if ((str != null) && (str.startsWith("class:")))
        return getLangTypeFor(string2Type(str.substring(6)));
    }
    return null;
  }

  public Type getTypeFor(String paramString)
  {
    return string2Type(paramString);
  }

  public boolean hasNamespace(Declaration paramDeclaration, int paramInt)
  {
    return (paramInt & getNamespaceOf(paramDeclaration)) != 0;
  }

  public boolean hasSeparateFunctionNamespace()
  {
    return false;
  }

  public boolean isTrue(Object paramObject)
  {
    return paramObject != Boolean.FALSE;
  }

  // ERROR //
  public void loadClass(String paramString)
    throws ClassNotFoundException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 256	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual 839	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   9: astore 5
    //   11: aload 5
    //   13: aload_0
    //   14: invokestatic 351	gnu/mapping/Environment:getCurrent	()Lgnu/mapping/Environment;
    //   17: invokestatic 845	gnu/kawa/reflect/ClassMemberLocation:defineAll	(Ljava/lang/Object;Lgnu/expr/Language;Lgnu/mapping/Environment;)V
    //   20: aload 5
    //   22: instanceof 847
    //   25: ifeq +11 -> 36
    //   28: aload 5
    //   30: checkcast 847	gnu/expr/ModuleBody
    //   33: invokevirtual 850	gnu/expr/ModuleBody:run	()V
    //   36: return
    //   37: astore_2
    //   38: aload_2
    //   39: athrow
    //   40: astore 4
    //   42: new 312	gnu/mapping/WrappedException
    //   45: dup
    //   46: new 263	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 852
    //   56: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: aload 4
    //   68: invokespecial 319	gnu/mapping/WrappedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	5	37	java/lang/ClassNotFoundException
    //   5	36	40	java/lang/Exception
  }

  public Object lookup(String paramString)
  {
    return this.environ.get(paramString);
  }

  public NamedLocation lookupBuiltin(Symbol paramSymbol, Object paramObject, int paramInt)
  {
    if (this.environ == null)
      return null;
    return this.environ.lookup(paramSymbol, paramObject, paramInt);
  }

  public Object noValue()
  {
    return Values.empty;
  }

  public final Compilation parse(InPort paramInPort, SourceMessages paramSourceMessages, int paramInt)
    throws IOException, SyntaxException
  {
    return parse(getLexer(paramInPort, paramSourceMessages), paramInt, null);
  }

  public final Compilation parse(InPort paramInPort, SourceMessages paramSourceMessages, int paramInt, ModuleInfo paramModuleInfo)
    throws IOException, SyntaxException
  {
    return parse(getLexer(paramInPort, paramSourceMessages), paramInt, paramModuleInfo);
  }

  public final Compilation parse(InPort paramInPort, SourceMessages paramSourceMessages, ModuleInfo paramModuleInfo)
    throws IOException, SyntaxException
  {
    return parse(getLexer(paramInPort, paramSourceMessages), 8, paramModuleInfo);
  }

  public final Compilation parse(Lexer paramLexer, int paramInt, ModuleInfo paramModuleInfo)
    throws IOException, SyntaxException
  {
    SourceMessages localSourceMessages = paramLexer.getMessages();
    NameLookup localNameLookup;
    if ((paramInt & 0x2) != 0)
    {
      localNameLookup = NameLookup.getInstance(getEnvironment(), this);
      if ((paramInt & 0x1) == 0)
        break label146;
    }
    Compilation localCompilation;
    label146: for (boolean bool = true; ; bool = false)
    {
      localCompilation = getCompilation(paramLexer, localSourceMessages, localNameLookup);
      if (requirePedantic)
        localCompilation.pedantic = true;
      if (!bool)
        localCompilation.mustCompile = true;
      localCompilation.immediate = bool;
      localCompilation.langOptions = paramInt;
      if ((paramInt & 0x40) != 0)
        localCompilation.explicit = true;
      if ((paramInt & 0x8) != 0)
        localCompilation.setState(1);
      localCompilation.pushNewModule(paramLexer);
      if (paramModuleInfo != null)
        paramModuleInfo.setCompilation(localCompilation);
      if (parse(localCompilation, paramInt))
        break label152;
      return null;
      localNameLookup = new NameLookup(this);
      break;
    }
    label152: if (localCompilation.getState() == 1)
      localCompilation.setState(2);
    return localCompilation;
  }

  public abstract boolean parse(Compilation paramCompilation, int paramInt)
    throws IOException, SyntaxException;

  public void resolve(Compilation paramCompilation)
  {
  }

  public void runAsApplication(String[] paramArrayOfString)
  {
    setDefaults(this);
    repl.main(paramArrayOfString);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.Language
 * JD-Core Version:    0.6.2
 */