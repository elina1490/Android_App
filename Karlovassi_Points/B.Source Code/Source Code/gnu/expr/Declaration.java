package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.Namespace;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.SourceLocator;

public class Declaration
  implements SourceLocator
{
  static final int CAN_CALL = 4;
  static final int CAN_READ = 2;
  static final int CAN_WRITE = 8;
  public static final long CLASS_ACCESS_FLAGS = 25820135424L;
  public static final int EARLY_INIT = 536870912;
  public static final long ENUM_ACCESS = 8589934592L;
  public static final int EXPORT_SPECIFIED = 1024;
  public static final int EXTERNAL_ACCESS = 524288;
  public static final long FIELD_ACCESS_FLAGS = 32463912960L;
  public static final int FIELD_OR_METHOD = 1048576;
  public static final long FINAL_ACCESS = 17179869184L;
  static final int INDIRECT_BINDING = 1;
  public static final int IS_ALIAS = 256;
  public static final int IS_CONSTANT = 16384;
  public static final int IS_DYNAMIC = 268435456;
  static final int IS_FLUID = 16;
  public static final int IS_IMPORTED = 131072;
  public static final int IS_NAMESPACE_PREFIX = 2097152;
  static final int IS_SIMPLE = 64;
  public static final int IS_SINGLE_VALUE = 262144;
  public static final int IS_SYNTAX = 32768;
  public static final int IS_UNKNOWN = 65536;
  public static final long METHOD_ACCESS_FLAGS = 17431527424L;
  public static final int MODULE_REFERENCE = 1073741824;
  public static final int NONSTATIC_SPECIFIED = 4096;
  public static final int NOT_DEFINING = 512;
  public static final int PACKAGE_ACCESS = 134217728;
  static final int PRIVATE = 32;
  public static final int PRIVATE_ACCESS = 16777216;
  public static final String PRIVATE_PREFIX = "$Prvt$";
  public static final int PRIVATE_SPECIFIED = 16777216;
  static final int PROCEDURE = 128;
  public static final int PROTECTED_ACCESS = 33554432;
  public static final int PUBLIC_ACCESS = 67108864;
  public static final int STATIC_SPECIFIED = 2048;
  public static final long TRANSIENT_ACCESS = 4294967296L;
  public static final int TYPE_SPECIFIED = 8192;
  static final String UNKNOWN_PREFIX = "loc$";
  public static final long VOLATILE_ACCESS = 2147483648L;
  static int counter;
  public Declaration base;
  public ScopeExp context;
  int evalIndex;
  public gnu.bytecode.Field field;
  String filename;
  public ApplyExp firstCall;
  protected long flags;
  protected int id;
  Method makeLocationMethod;
  Declaration next;
  Declaration nextCapturedVar;
  int position;
  Object symbol;
  protected Type type;
  protected Expression typeExp;
  protected Expression value;
  Variable var;

  protected Declaration()
  {
    int i = 1 + counter;
    counter = i;
    this.id = i;
    this.value = QuoteExp.undefined_exp;
    this.flags = 64L;
    this.makeLocationMethod = null;
  }

  public Declaration(Variable paramVariable)
  {
    this(paramVariable.getName(), paramVariable.getType());
    this.var = paramVariable;
  }

  public Declaration(Object paramObject)
  {
    int i = 1 + counter;
    counter = i;
    this.id = i;
    this.value = QuoteExp.undefined_exp;
    this.flags = 64L;
    this.makeLocationMethod = null;
    setName(paramObject);
  }

  public Declaration(Object paramObject, gnu.bytecode.Field paramField)
  {
    this(paramObject, paramField.getType());
    this.field = paramField;
    setSimple(false);
  }

  public Declaration(Object paramObject, Type paramType)
  {
    int i = 1 + counter;
    counter = i;
    this.id = i;
    this.value = QuoteExp.undefined_exp;
    this.flags = 64L;
    this.makeLocationMethod = null;
    setName(paramObject);
    setType(paramType);
  }

  public static Declaration followAliases(Declaration paramDeclaration)
  {
    while (true)
    {
      Expression localExpression;
      if ((paramDeclaration != null) && (paramDeclaration.isAlias()))
      {
        localExpression = paramDeclaration.getValue();
        if ((localExpression instanceof ReferenceExp))
          break label25;
      }
      label25: Declaration localDeclaration;
      do
      {
        return paramDeclaration;
        localDeclaration = ((ReferenceExp)localExpression).binding;
      }
      while (localDeclaration == null);
      paramDeclaration = localDeclaration;
    }
  }

  public static Declaration getDeclaration(Named paramNamed)
  {
    return getDeclaration(paramNamed, paramNamed.getName());
  }

  public static Declaration getDeclaration(Object paramObject, String paramString)
  {
    gnu.bytecode.Field localField = null;
    if (paramString != null)
    {
      Class localClass = PrimProcedure.getProcedureClass(paramObject);
      localField = null;
      if (localClass != null)
        localField = ((ClassType)Type.make(localClass)).getDeclaredField(Compilation.mangleNameIfNeeded(paramString));
    }
    if (localField != null)
    {
      int i = localField.getModifiers();
      if ((i & 0x8) != 0)
      {
        Declaration localDeclaration = new Declaration(paramString, localField);
        localDeclaration.noteValue(new QuoteExp(paramObject));
        if ((i & 0x10) != 0)
          localDeclaration.setFlag(16384L);
        return localDeclaration;
      }
    }
    return null;
  }

  public static Declaration getDeclarationFromStatic(String paramString1, String paramString2)
  {
    Declaration localDeclaration = new Declaration(paramString2, ClassType.make(paramString1).getDeclaredField(paramString2));
    localDeclaration.setFlag(18432L);
    return localDeclaration;
  }

  public static Declaration getDeclarationValueFromStatic(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Object localObject = Class.forName(paramString1).getDeclaredField(paramString2).get(null);
      Declaration localDeclaration = new Declaration(paramString3, ClassType.make(paramString1).getDeclaredField(paramString2));
      localDeclaration.noteValue(new QuoteExp(localObject));
      localDeclaration.setFlag(18432L);
      return localDeclaration;
    }
    catch (Exception localException)
    {
      throw new WrappedException(localException);
    }
  }

  public static final boolean isUnknown(Declaration paramDeclaration)
  {
    return (paramDeclaration == null) || (paramDeclaration.getFlag(65536L));
  }

  public final Variable allocateVariable(CodeAttr paramCodeAttr)
  {
    String str;
    Declaration localDeclaration;
    if ((!isSimple()) || (this.var == null))
    {
      Object localObject1 = this.symbol;
      str = null;
      if (localObject1 != null)
        str = Compilation.mangleNameIfNeeded(getName());
      if ((!isAlias()) || (!(getValue() instanceof ReferenceExp)))
        break label85;
      localDeclaration = followAliases(this);
      if (localDeclaration != null)
        break label75;
    }
    label75: for (Variable localVariable = null; ; localVariable = localDeclaration.var)
    {
      this.var = localVariable;
      return this.var;
    }
    label85: if (isIndirectBinding());
    for (Object localObject2 = Compilation.typeLocation; ; localObject2 = getType().getImplementationType())
    {
      this.var = this.context.getVarScope().addVariable(paramCodeAttr, (Type)localObject2, str);
      break;
    }
  }

  public void compileStore(Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (isSimple())
    {
      localCodeAttr.emitStore(getVariable());
      return;
    }
    if (!this.field.getStaticFlag())
    {
      loadOwningObject(null, paramCompilation);
      localCodeAttr.emitSwap();
      localCodeAttr.emitPutField(this.field);
      return;
    }
    localCodeAttr.emitPutStatic(this.field);
  }

  public short getAccessFlags(short paramShort)
  {
    if (getFlag(251658240L))
    {
      boolean bool = getFlag(16777216L);
      s = 0;
      if (bool)
        s = (short)(0x0 | 0x2);
      if (getFlag(33554432L))
        s = (short)(s | 0x4);
      if (!getFlag(67108864L));
    }
    for (short s = (short)(s | 0x1); ; s = paramShort)
    {
      if (getFlag(2147483648L))
        s = (short)(s | 0x40);
      if (getFlag(4294967296L))
        s = (short)(s | 0x80);
      if (getFlag(8589934592L))
        s = (short)(s | 0x4000);
      if (getFlag(17179869184L))
        s = (short)(s | 0x10);
      return s;
    }
  }

  public final boolean getCanCall()
  {
    return (0x4 & this.flags) != 0L;
  }

  public final boolean getCanRead()
  {
    return (0x2 & this.flags) != 0L;
  }

  public final boolean getCanWrite()
  {
    return (0x8 & this.flags) != 0L;
  }

  public int getCode()
  {
    return this.id;
  }

  public final int getColumnNumber()
  {
    int i = 0xFFF & this.position;
    if (i == 0)
      return -1;
    return i;
  }

  public final Object getConstantValue()
  {
    Expression localExpression = getValue();
    if ((!(localExpression instanceof QuoteExp)) || (localExpression == QuoteExp.undefined_exp))
      return null;
    return ((QuoteExp)localExpression).getValue();
  }

  public final ScopeExp getContext()
  {
    return this.context;
  }

  public final String getFileName()
  {
    return this.filename;
  }

  public final boolean getFlag(long paramLong)
  {
    return (paramLong & this.flags) != 0L;
  }

  public final int getLineNumber()
  {
    int i = this.position >> 12;
    if (i == 0)
      return -1;
    return i;
  }

  public final String getName()
  {
    if (this.symbol == null)
      return null;
    if ((this.symbol instanceof Symbol))
      return ((Symbol)this.symbol).getName();
    return this.symbol.toString();
  }

  public String getPublicId()
  {
    return null;
  }

  public final Object getSymbol()
  {
    return this.symbol;
  }

  public String getSystemId()
  {
    return this.filename;
  }

  public final Type getType()
  {
    if (this.type == null)
      setType(Type.objectType);
    return this.type;
  }

  public final Expression getTypeExp()
  {
    if (this.typeExp == null)
      setType(Type.objectType);
    return this.typeExp;
  }

  public final Expression getValue()
  {
    if ((this.value != QuoteExp.undefined_exp) || ((this.field != null) && ((0x18 & this.field.getModifiers()) == 24) && (!isIndirectBinding())));
    try
    {
      this.value = new QuoteExp(this.field.getReflectField().get(null));
      while (true)
      {
        label61: return this.value;
        if (((this.value instanceof QuoteExp)) && (getFlag(8192L)) && (this.value.getType() != this.type))
          try
          {
            Object localObject = ((QuoteExp)this.value).getValue();
            Type localType = getType();
            this.value = new QuoteExp(localType.coerceFromObject(localObject), localType);
          }
          catch (Throwable localThrowable1)
          {
          }
      }
    }
    catch (Throwable localThrowable2)
    {
      break label61;
    }
  }

  public Variable getVariable()
  {
    return this.var;
  }

  public final boolean hasConstantValue()
  {
    Expression localExpression = getValue();
    return ((localExpression instanceof QuoteExp)) && (localExpression != QuoteExp.undefined_exp);
  }

  public boolean ignorable()
  {
    if ((getCanRead()) || (isPublic()))
      return false;
    if ((getCanWrite()) && (getFlag(65536L)))
      return false;
    if (!getCanCall())
      return true;
    Expression localExpression = getValue();
    if ((localExpression == null) || (!(localExpression instanceof LambdaExp)))
      return false;
    LambdaExp localLambdaExp = (LambdaExp)localExpression;
    return (!localLambdaExp.isHandlingTailCalls()) || (localLambdaExp.getInlineOnly());
  }

  public final boolean isAlias()
  {
    return (0x100 & this.flags) != 0L;
  }

  public boolean isCompiletimeConstant()
  {
    return (getFlag(16384L)) && (hasConstantValue());
  }

  public final boolean isFluid()
  {
    return (0x10 & this.flags) != 0L;
  }

  public final boolean isIndirectBinding()
  {
    return (1L & this.flags) != 0L;
  }

  public final boolean isLexical()
  {
    return (0x10010010 & this.flags) == 0L;
  }

  public final boolean isNamespaceDecl()
  {
    return (0x200000 & this.flags) != 0L;
  }

  public final boolean isPrivate()
  {
    return (0x20 & this.flags) != 0L;
  }

  public final boolean isProcedureDecl()
  {
    return (0x80 & this.flags) != 0L;
  }

  public final boolean isPublic()
  {
    return ((this.context instanceof ModuleExp)) && ((0x20 & this.flags) == 0L);
  }

  public final boolean isSimple()
  {
    return (0x40 & this.flags) != 0L;
  }

  public boolean isStableSourceLocation()
  {
    return true;
  }

  public boolean isStatic()
  {
    if (this.field != null)
      return this.field.getStaticFlag();
    if ((getFlag(2048L)) || (isCompiletimeConstant()))
      return true;
    if (getFlag(4096L))
      return false;
    LambdaExp localLambdaExp = this.context.currentLambda();
    return ((localLambdaExp instanceof ModuleExp)) && (((ModuleExp)localLambdaExp).isStatic());
  }

  public final boolean isThisParameter()
  {
    return this.symbol == ThisExp.THIS_NAME;
  }

  public void load(AccessExp paramAccessExp, int paramInt, Compilation paramCompilation, Target paramTarget)
  {
    if ((paramTarget instanceof IgnoreTarget))
      return;
    if (paramAccessExp == null);
    for (Declaration localDeclaration1 = null; (isAlias()) && ((this.value instanceof ReferenceExp)); localDeclaration1 = paramAccessExp.contextDecl())
    {
      ReferenceExp localReferenceExp = (ReferenceExp)this.value;
      Declaration localDeclaration2 = localReferenceExp.binding;
      if ((localDeclaration2 == null) || (((paramInt & 0x2) != 0) && (!localDeclaration2.isIndirectBinding())) || ((localDeclaration1 != null) && (localDeclaration2.needsContext())))
        break;
      localDeclaration2.load(localReferenceExp, paramInt, paramCompilation, paramTarget);
      return;
    }
    if ((isFluid()) && ((this.context instanceof FluidLetExp)))
    {
      this.base.load(paramAccessExp, paramInt, paramCompilation, paramTarget);
      return;
    }
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Object localObject1 = getType();
    if ((!isIndirectBinding()) && ((paramInt & 0x2) != 0))
    {
      if (this.field == null)
        throw new Error("internal error: cannot take location of " + this);
      boolean bool4 = paramCompilation.immediate;
      ClassType localClassType2;
      int n;
      Method localMethod2;
      if (this.field.getStaticFlag())
      {
        localClassType2 = ClassType.make("gnu.kawa.reflect.StaticFieldLocation");
        if (bool4)
        {
          n = 1;
          localMethod2 = localClassType2.getDeclaredMethod("make", n);
          if (!bool4)
            break label316;
          paramCompilation.compileConstant(this);
        }
      }
      while (true)
      {
        localCodeAttr.emitInvokeStatic(localMethod2);
        localObject1 = localClassType2;
        paramTarget.compileFromStack(paramCompilation, (Type)localObject1);
        return;
        n = 2;
        break;
        localClassType2 = ClassType.make("gnu.kawa.reflect.FieldLocation");
        if (bool4);
        for (int m = 2; ; m = 3)
        {
          localMethod2 = localClassType2.getDeclaredMethod("make", m);
          loadOwningObject(localDeclaration1, paramCompilation);
          break;
        }
        label316: paramCompilation.compileConstant(this.field.getDeclaringClass().getName());
        paramCompilation.compileConstant(this.field.getName());
      }
    }
    label399: label533: int k;
    if (this.field != null)
    {
      paramCompilation.usedClass(this.field.getDeclaringClass());
      paramCompilation.usedClass(this.field.getType());
      if (!this.field.getStaticFlag())
      {
        loadOwningObject(localDeclaration1, paramCompilation);
        localCodeAttr.emitGetField(this.field);
        if ((!isIndirectBinding()) || ((paramInt & 0x2) != 0))
          break label951;
        if (paramAccessExp == null)
          break label971;
        String str1 = paramAccessExp.getFileName();
        if (str1 == null)
          break label971;
        int i = paramAccessExp.getLineNumber();
        if (i <= 0)
          break label971;
        ClassType localClassType1 = ClassType.make("gnu.mapping.UnboundLocationException");
        boolean bool1 = localCodeAttr.isInTry();
        int j = paramAccessExp.getColumnNumber();
        Label localLabel1 = new Label(localCodeAttr);
        localLabel1.define(localCodeAttr);
        localCodeAttr.emitInvokeVirtual(Compilation.getLocationMethod);
        Label localLabel2 = new Label(localCodeAttr);
        localLabel2.define(localCodeAttr);
        Label localLabel3 = new Label(localCodeAttr);
        localLabel3.setTypes(localCodeAttr);
        if (!bool1)
          break label953;
        localCodeAttr.emitGoto(localLabel3);
        k = 0;
        if (!bool1)
          k = localCodeAttr.beginFragment(localLabel3);
        localCodeAttr.addHandler(localLabel1, localLabel2, localClassType1);
        localCodeAttr.emitDup(localClassType1);
        localCodeAttr.emitPushString(str1);
        localCodeAttr.emitPushInt(i);
        localCodeAttr.emitPushInt(j);
        localCodeAttr.emitInvokeVirtual(localClassType1.getDeclaredMethod("setLine", 3));
        localCodeAttr.emitThrow();
        if (!bool1)
          break label961;
        localLabel3.define(localCodeAttr);
      }
    }
    while (true)
    {
      localObject1 = Type.pointer_type;
      break;
      localCodeAttr.emitGetStatic(this.field);
      break label399;
      if ((isIndirectBinding()) && (paramCompilation.immediate) && (getVariable() == null))
      {
        Environment localEnvironment = Environment.getCurrent();
        if ((this.symbol instanceof Symbol));
        for (Symbol localSymbol = (Symbol)this.symbol; ; localSymbol = localEnvironment.getSymbol(this.symbol.toString()))
        {
          boolean bool2 = isProcedureDecl();
          Object localObject3 = null;
          if (bool2)
          {
            boolean bool3 = paramCompilation.getLanguage().hasSeparateFunctionNamespace();
            localObject3 = null;
            if (bool3)
              localObject3 = EnvironmentKey.FUNCTION;
          }
          paramCompilation.compileConstant(localEnvironment.getLocation(localSymbol, localObject3), Target.pushValue(Compilation.typeLocation));
          break;
        }
      }
      if (paramCompilation.immediate)
      {
        Object localObject2 = getConstantValue();
        if (localObject2 != null)
        {
          paramCompilation.compileConstant(localObject2, paramTarget);
          return;
        }
      }
      if ((this.value != QuoteExp.undefined_exp) && (ignorable()) && ((!(this.value instanceof LambdaExp)) || (!(((LambdaExp)this.value).outer instanceof ModuleExp))))
      {
        this.value.compile(paramCompilation, paramTarget);
        return;
      }
      Variable localVariable = getVariable();
      if (((this.context instanceof ClassExp)) && (localVariable == null) && (!getFlag(128L)))
      {
        ClassExp localClassExp = (ClassExp)this.context;
        if (localClassExp.isMakingClassPair())
        {
          String str2 = ClassExp.slotToMethodName("get", getName());
          Method localMethod1 = localClassExp.type.getDeclaredMethod(str2, 0);
          localClassExp.loadHeapFrame(paramCompilation);
          localCodeAttr.emitInvoke(localMethod1);
          break label399;
        }
      }
      if (localVariable == null)
        localVariable = allocateVariable(localCodeAttr);
      localCodeAttr.emitLoad(localVariable);
      break label399;
      label951: break;
      label953: localCodeAttr.setUnreachable();
      break label533;
      label961: localCodeAttr.endFragment(k);
      continue;
      label971: localCodeAttr.emitInvokeVirtual(Compilation.getLocationMethod);
    }
  }

  void loadOwningObject(Declaration paramDeclaration, Compilation paramCompilation)
  {
    if (paramDeclaration == null)
      paramDeclaration = this.base;
    if (paramDeclaration != null)
    {
      paramDeclaration.load(null, 0, paramCompilation, Target.pushObject);
      return;
    }
    getContext().currentLambda().loadHeapFrame(paramCompilation);
  }

  public void makeField(ClassType paramClassType, Compilation paramCompilation, Expression paramExpression)
  {
    boolean bool1 = needsExternalAccess();
    boolean bool2 = getFlag(16384L);
    boolean bool3 = getFlag(8192L);
    if ((paramCompilation.immediate) && ((this.context instanceof ModuleExp)) && (!bool2) && (!bool3))
      setIndirectBinding(true);
    int i;
    if ((!isPublic()) && (!bool1))
    {
      boolean bool4 = paramCompilation.immediate;
      i = 0;
      if (!bool4);
    }
    else
    {
      i = 0x0 | 0x1;
    }
    if ((isStatic()) || ((getFlag(268501008L)) && (isIndirectBinding()) && (!isAlias())) || (((paramExpression instanceof ClassExp)) && (!((LambdaExp)paramExpression).getNeedsClosureEnv())))
      i |= 8;
    if (((isIndirectBinding()) || ((bool2) && ((shouldEarlyInit()) || (((this.context instanceof ModuleExp)) && (((ModuleExp)this.context).staticInitRun()))))) && (((this.context instanceof ClassExp)) || ((this.context instanceof ModuleExp))))
      i |= 16;
    Object localObject1 = getType().getImplementationType();
    if ((isIndirectBinding()) && (!((Type)localObject1).isSubtype(Compilation.typeLocation)))
      localObject1 = Compilation.typeLocation;
    Object localObject2;
    if (!ignorable())
    {
      String str1 = getName();
      String str2;
      if (str1 == null)
        str2 = "$unnamed$0";
      for (int j = str2.length() - 2; ; j = str2.length())
      {
        int k = 0;
        while (paramClassType.getDeclaredField(str2) != null)
        {
          StringBuilder localStringBuilder = new StringBuilder().append(str2.substring(0, j)).append('$');
          k++;
          str2 = k;
        }
        str2 = Compilation.mangleNameIfNeeded(str1);
        if (getFlag(65536L))
          str2 = "loc$" + str2;
        if ((bool1) && (!getFlag(1073741824L)))
          str2 = "$Prvt$" + str2;
      }
      this.field = paramClassType.addField(str2, (Type)localObject1, i);
      if ((paramExpression instanceof QuoteExp))
      {
        localObject2 = ((QuoteExp)paramExpression).getValue();
        if ((!this.field.getStaticFlag()) || (!localObject2.getClass().getName().equals(((Type)localObject1).getName())))
          break label539;
        localLiteral = paramCompilation.litTable.findLiteral(localObject2);
        if (localLiteral.field == null)
          localLiteral.assign(this.field, paramCompilation.litTable);
      }
    }
    label539: 
    while ((!(localObject1 instanceof PrimType)) && (!"java.lang.String".equals(((Type)localObject1).getName())))
    {
      Literal localLiteral;
      if ((!shouldEarlyInit()) && ((isIndirectBinding()) || ((paramExpression != null) && (!(paramExpression instanceof ClassExp)))))
        BindingInitializer.create(this, paramExpression, paramCompilation);
      return;
    }
    if ((localObject2 instanceof Char))
      localObject2 = IntNum.make(((Char)localObject2).intValue());
    this.field.setConstantValue(localObject2, paramClassType);
  }

  public void makeField(Compilation paramCompilation, Expression paramExpression)
  {
    setSimple(false);
    makeField(paramCompilation.mainClass, paramCompilation, paramExpression);
  }

  Location makeIndirectLocationFor()
  {
    if ((this.symbol instanceof Symbol));
    for (Symbol localSymbol = (Symbol)this.symbol; ; localSymbol = Namespace.EmptyNamespace.getSymbol(this.symbol.toString().intern()))
      return Location.make(localSymbol);
  }

  public void maybeIndirectBinding(Compilation paramCompilation)
  {
    if (((isLexical()) && (!(this.context instanceof ModuleExp))) || (this.context == paramCompilation.mainLambda))
      setIndirectBinding(true);
  }

  public final boolean needsContext()
  {
    return (this.base == null) && (this.field != null) && (!this.field.getStaticFlag());
  }

  public final boolean needsExternalAccess()
  {
    return ((0x80020 & this.flags) == 524320L) || ((0x200020 & this.flags) == 2097184L);
  }

  public boolean needsInit()
  {
    return (!ignorable()) && ((this.value != QuoteExp.nullExp) || (this.base == null));
  }

  public final Declaration nextDecl()
  {
    return this.next;
  }

  public void noteValue(Expression paramExpression)
  {
    if (this.value == QuoteExp.undefined_exp)
    {
      if ((paramExpression instanceof LambdaExp))
        ((LambdaExp)paramExpression).nameDecl = this;
      this.value = paramExpression;
    }
    while (this.value == paramExpression)
      return;
    if ((this.value instanceof LambdaExp))
      ((LambdaExp)this.value).nameDecl = null;
    this.value = null;
  }

  public void printInfo(OutPort paramOutPort)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    printInfo(localStringBuffer);
    paramOutPort.print(localStringBuffer.toString());
  }

  public void printInfo(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.symbol);
    paramStringBuffer.append('/');
    paramStringBuffer.append(this.id);
    paramStringBuffer.append("/fl:");
    paramStringBuffer.append(Long.toHexString(this.flags));
    if (ignorable())
      paramStringBuffer.append("(ignorable)");
    Expression localExpression = this.typeExp;
    Type localType = getType();
    if ((localExpression != null) && (!(localExpression instanceof QuoteExp)))
    {
      paramStringBuffer.append("::");
      paramStringBuffer.append(localExpression);
    }
    while (true)
    {
      if (this.base != null)
      {
        paramStringBuffer.append("(base:#");
        paramStringBuffer.append(this.base.id);
        paramStringBuffer.append(')');
      }
      return;
      if ((this.type != null) && (localType != Type.pointer_type))
      {
        paramStringBuffer.append("::");
        paramStringBuffer.append(localType.getName());
      }
    }
  }

  public void pushIndirectBinding(Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    localCodeAttr.emitPushString(getName());
    if (this.makeLocationMethod == null)
    {
      Type[] arrayOfType = new Type[2];
      arrayOfType[0] = Type.pointer_type;
      arrayOfType[1] = Type.string_type;
      this.makeLocationMethod = Compilation.typeLocation.addMethod("make", arrayOfType, Compilation.typeLocation, 9);
    }
    localCodeAttr.emitInvokeStatic(this.makeLocationMethod);
  }

  public final void setAlias(boolean paramBoolean)
  {
    setFlag(paramBoolean, 256L);
  }

  public final void setCanCall()
  {
    setFlag(true, 4L);
    if (this.base != null)
      this.base.setCanRead();
  }

  public final void setCanCall(boolean paramBoolean)
  {
    setFlag(paramBoolean, 4L);
  }

  public final void setCanRead()
  {
    setFlag(true, 2L);
    if (this.base != null)
      this.base.setCanRead();
  }

  public final void setCanRead(boolean paramBoolean)
  {
    setFlag(paramBoolean, 2L);
  }

  public final void setCanWrite()
  {
    this.flags = (0x8 | this.flags);
    if (this.base != null)
      this.base.setCanRead();
  }

  public final void setCanWrite(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x8 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFF7 & this.flags);
  }

  public void setCode(int paramInt)
  {
    if (paramInt >= 0)
      throw new Error("code must be negative");
    this.id = paramInt;
  }

  public final void setFile(String paramString)
  {
    this.filename = paramString;
  }

  public final void setFlag(long paramLong)
  {
    this.flags = (paramLong | this.flags);
  }

  public final void setFlag(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      this.flags = (paramLong | this.flags);
      return;
    }
    this.flags &= (0xFFFFFFFF ^ paramLong);
  }

  public final void setFluid(boolean paramBoolean)
  {
    setFlag(paramBoolean, 16L);
  }

  public final void setIndirectBinding(boolean paramBoolean)
  {
    setFlag(paramBoolean, 1L);
  }

  public final void setLine(int paramInt)
  {
    setLine(paramInt, 0);
  }

  public final void setLine(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramInt2 < 0)
      paramInt2 = 0;
    this.position = (paramInt2 + (paramInt1 << 12));
  }

  public final void setLocation(SourceLocator paramSourceLocator)
  {
    this.filename = paramSourceLocator.getFileName();
    setLine(paramSourceLocator.getLineNumber(), paramSourceLocator.getColumnNumber());
  }

  public final void setName(Object paramObject)
  {
    this.symbol = paramObject;
  }

  public final void setNext(Declaration paramDeclaration)
  {
    this.next = paramDeclaration;
  }

  public final void setPrivate(boolean paramBoolean)
  {
    setFlag(paramBoolean, 32L);
  }

  public final void setProcedureDecl(boolean paramBoolean)
  {
    setFlag(paramBoolean, 128L);
  }

  public final void setSimple(boolean paramBoolean)
  {
    setFlag(paramBoolean, 64L);
    if ((this.var != null) && (!this.var.isParameter()))
      this.var.setSimple(paramBoolean);
  }

  public final void setSymbol(Object paramObject)
  {
    this.symbol = paramObject;
  }

  public final void setSyntax()
  {
    setSimple(false);
    setFlag(536920064L);
  }

  public final void setType(Type paramType)
  {
    this.type = paramType;
    if (this.var != null)
      this.var.setType(paramType);
    this.typeExp = QuoteExp.getInstance(paramType);
  }

  public final void setTypeExp(Expression paramExpression)
  {
    this.typeExp = paramExpression;
    if ((paramExpression instanceof TypeValue));
    for (Object localObject = ((TypeValue)paramExpression).getImplementationType(); ; localObject = Language.getDefaultLanguage().getTypeFor(paramExpression, false))
    {
      if (localObject == null)
        localObject = Type.pointer_type;
      this.type = ((Type)localObject);
      if (this.var != null)
        this.var.setType((Type)localObject);
      return;
    }
  }

  public final void setValue(Expression paramExpression)
  {
    this.value = paramExpression;
  }

  boolean shouldEarlyInit()
  {
    return (getFlag(536870912L)) || (isCompiletimeConstant());
  }

  public String toString()
  {
    return "Declaration[" + this.symbol + '/' + this.id + ']';
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.Declaration
 * JD-Core Version:    0.6.2
 */