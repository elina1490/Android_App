package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExceptionsAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Filter;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import java.util.Set;
import java.util.Vector;

public class LambdaExp extends ScopeExp
{
  public static final int ATTEMPT_INLINE = 4096;
  static final int CANNOT_INLINE = 32;
  static final int CAN_CALL = 4;
  static final int CAN_READ = 2;
  static final int CLASS_METHOD = 64;
  static final int DEFAULT_CAPTURES_ARG = 512;
  static final int IMPORTS_LEX_VARS = 8;
  static final int INLINE_ONLY = 8192;
  static final int METHODS_COMPILED = 128;
  static final int NEEDS_STATIC_LINK = 16;
  protected static final int NEXT_AVAIL_FLAG = 16384;
  public static final int NO_FIELD = 256;
  public static final int OVERLOADABLE_FIELD = 2048;
  public static final int SEQUENCE_RESULT = 1024;
  static Method searchForKeywordMethod3;
  static Method searchForKeywordMethod4;
  static final ApplyExp unknownContinuation = new ApplyExp((Expression)null, null);
  Vector applyMethods;
  Variable argsArray;
  public Expression body;
  Declaration capturedVars;
  Variable closureEnv;
  public Field closureEnvField;
  public Expression[] defaultArgs;
  private Declaration firstArgsArrayArg;
  public LambdaExp firstChild;
  Variable heapFrame;
  Initializer initChain;
  public LambdaExp inlineHome;
  public Keyword[] keywords;
  public int max_args;
  public int min_args;
  public Declaration nameDecl;
  public LambdaExp nextSibling;
  Method[] primBodyMethods;
  Method[] primMethods;
  Object[] properties;
  public Expression returnContinuation;
  public Type returnType;
  int selectorValue;
  public Field staticLinkField;
  Set<LambdaExp> tailCallers;
  Procedure thisValue;
  Variable thisVariable;
  Expression[] throwsSpecification;
  ClassType type = Compilation.typeProcedure;

  public LambdaExp()
  {
  }

  public LambdaExp(int paramInt)
  {
    this.min_args = paramInt;
    this.max_args = paramInt;
  }

  public LambdaExp(Expression paramExpression)
  {
    this.body = paramExpression;
  }

  final void addApplyMethod(Compilation paramCompilation, Field paramField)
  {
    Object localObject = this;
    if ((paramField != null) && (paramField.getStaticFlag()))
      localObject = paramCompilation.getModule();
    while (true)
    {
      if (((LambdaExp)localObject).applyMethods == null)
        ((LambdaExp)localObject).applyMethods = new Vector();
      ((LambdaExp)localObject).applyMethods.addElement(this);
      return;
      do
        localObject = ((LambdaExp)localObject).outerLambda();
      while ((!(localObject instanceof ModuleExp)) && (((LambdaExp)localObject).heapFrame == null));
      if (!((LambdaExp)localObject).getHeapFrameType().getSuperclass().isSubtype(Compilation.typeModuleBody))
        localObject = paramCompilation.getModule();
    }
  }

  void addMethodFor(ClassType paramClassType, Compilation paramCompilation, ObjectType paramObjectType)
  {
    String str1 = getName();
    LambdaExp localLambdaExp1 = outerLambda();
    int i;
    int j;
    label32: int k;
    label46: int m;
    label70: Method[] arrayOfMethod1;
    int n;
    int i1;
    label124: StringBuffer localStringBuffer;
    int i2;
    label144: label233: int i3;
    label267: label286: Method[] arrayOfMethod2;
    int i20;
    Declaration localDeclaration3;
    label358: Object localObject1;
    label381: int i4;
    label393: int i6;
    int i7;
    if (this.keywords == null)
    {
      i = 0;
      if (this.defaultArgs != null)
        break label576;
      j = 0;
      if ((0x200 & this.flags) == 0)
        break label589;
      k = 0;
      if ((this.max_args >= 0) && (k + this.min_args >= this.max_args))
        break label596;
      m = 1;
      arrayOfMethod1 = new Method[k + 1];
      this.primBodyMethods = arrayOfMethod1;
      if (this.primMethods == null)
        this.primMethods = arrayOfMethod1;
      n = 0;
      if ((this.nameDecl == null) || (!this.nameDecl.getFlag(4096L)))
        break label602;
      i1 = 0;
      localStringBuffer = new StringBuffer(60);
      if (i1 == 0)
        break label818;
      i2 = 8;
      if (this.nameDecl != null)
      {
        if (!this.nameDecl.needsExternalAccess())
          break label824;
        i2 |= 1;
      }
      if (((!localLambdaExp1.isModuleBody()) && (!(localLambdaExp1 instanceof ClassExp))) || (str1 == null))
      {
        localStringBuffer.append("lambda");
        int i22 = 1 + paramCompilation.method_counter;
        paramCompilation.method_counter = i22;
        localStringBuffer.append(i22);
      }
      if (n != 67)
        break label871;
      localStringBuffer.append("<clinit>");
      if (getFlag(1024))
        localStringBuffer.append("$C");
      if ((getCallConvention() < 2) || (n != 0))
        break label892;
      i3 = 1;
      if (n != 0)
      {
        if (i1 == 0)
          break label898;
        i2 = 1 + (i2 & 0xFFFFFFFD);
      }
      if ((paramClassType.isInterface()) || (isAbstract()))
        i2 = 0x400 | i2;
      if ((isClassMethod()) && ((localLambdaExp1 instanceof ClassExp)) && (this.min_args == this.max_args))
      {
        arrayOfMethod2 = null;
        i20 = 0;
        localDeclaration3 = firstDecl();
        if (localDeclaration3 != null)
          break label909;
        if (this.returnType == null)
          break label944;
      }
      if ((!getFlag(1024)) && (getCallConvention() < 2))
        break label1086;
      localObject1 = Type.voidType;
      if ((paramObjectType == null) || (paramObjectType == paramClassType))
        break label1098;
      i4 = 1;
      int i5 = getCallConvention();
      i6 = 0;
      if (i5 >= 2)
      {
        i6 = 0;
        if (n == 0)
          i6 = 1;
      }
      i7 = localStringBuffer.length();
    }
    for (int i8 = 0; ; i8++)
    {
      if (i8 > k)
        return;
      localStringBuffer.setLength(i7);
      int i9 = i8 + this.min_args;
      int i10 = i9;
      if ((i8 == k) && (m != 0))
        i10++;
      Type[] arrayOfType = new Type[i6 + (i4 + i10)];
      if (i4 > 0)
        arrayOfType[0] = paramObjectType;
      Declaration localDeclaration1 = firstDecl();
      if ((localDeclaration1 != null) && (localDeclaration1.isThisParameter()))
        localDeclaration1 = localDeclaration1.nextDecl();
      int i11 = 0;
      while (true)
        if (i11 < i9)
        {
          int i19 = i11 + 1;
          arrayOfType[(i4 + i11)] = localDeclaration1.getType().getImplementationType();
          localDeclaration1 = localDeclaration1.nextDecl();
          i11 = i19;
          continue;
          i = this.keywords.length;
          break;
          label576: j = this.defaultArgs.length - i;
          break label32;
          label589: k = j;
          break label46;
          label596: m = 0;
          break label70;
          label602: if ((this.nameDecl != null) && (this.nameDecl.getFlag(2048L)))
          {
            i1 = 1;
            n = 0;
            break label124;
          }
          if (isClassMethod())
          {
            if ((localLambdaExp1 instanceof ClassExp))
            {
              ClassExp localClassExp = (ClassExp)localLambdaExp1;
              if ((localClassExp.isMakingClassPair()) && (paramObjectType != null));
              for (i1 = 1; ; i1 = 0)
              {
                if (this != localClassExp.initMethod)
                  break label690;
                n = 73;
                break;
              }
              label690: LambdaExp localLambdaExp2 = localClassExp.clinitMethod;
              n = 0;
              if (this != localLambdaExp2)
                break label124;
              n = 67;
              i1 = 1;
              break label124;
            }
            n = 0;
            i1 = 0;
            break label124;
          }
          if ((this.thisVariable != null) || (paramObjectType == paramClassType))
          {
            n = 0;
            i1 = 0;
            break label124;
          }
          if ((this.nameDecl != null) && ((this.nameDecl.context instanceof ModuleExp)))
          {
            ModuleExp localModuleExp = (ModuleExp)this.nameDecl.context;
            if ((localModuleExp.getSuperType() == null) && (localModuleExp.getInterfaces() == null));
            for (i1 = 1; ; i1 = 0)
            {
              n = 0;
              break;
            }
          }
          i1 = 1;
          n = 0;
          break label124;
          label818: i2 = 0;
          break label144;
          label824: if (this.nameDecl.isPrivate());
          int i24;
          for (int i23 = 0; ; i24 = 1)
          {
            if (isClassMethod())
              i23 = this.nameDecl.getAccessFlags(i23);
            i2 |= i23;
            break;
          }
          label871: if (getSymbol() == null)
            break label233;
          localStringBuffer.append(Compilation.mangleName(str1));
          break label233;
          label892: i3 = 0;
          break label267;
          label898: i2 = 2 + (i2 & 0x2);
          break label286;
          label909: if (localDeclaration3.isThisParameter())
            i20--;
          label944: label1077: label1084: 
          while (true)
          {
            localDeclaration3 = localDeclaration3.nextDecl();
            i20++;
            break;
            if (!localDeclaration3.getFlag(8192L))
            {
              if (arrayOfMethod2 == null)
              {
                final String str5 = localStringBuffer.toString();
                Filter local1 = new Filter()
                {
                  public boolean select(Object paramAnonymousObject)
                  {
                    Method localMethod = (Method)paramAnonymousObject;
                    if (!localMethod.getName().equals(str5))
                      return false;
                    return localMethod.getParameterTypes().length == LambdaExp.this.min_args;
                  }
                };
                arrayOfMethod2 = paramClassType.getMethods(local1, 2);
              }
              Object localObject4 = null;
              int i21 = arrayOfMethod2.length;
              Type localType;
              do
              {
                i21--;
                if (i21 < 0)
                  break;
                Method localMethod2 = arrayOfMethod2[i21];
                if (localDeclaration3 == null);
                for (localType = localMethod2.getReturnType(); ; localType = localMethod2.getParameterTypes()[i20])
                {
                  if (localObject4 != null)
                    break label1037;
                  localObject4 = localType;
                  break;
                }
              }
              while (localType == localObject4);
              if (localDeclaration3 == null)
              {
                break label358;
                if (localObject4 != null)
                {
                  if (localDeclaration3 == null)
                    break label1077;
                  localDeclaration3.setType(localObject4);
                }
                while (true)
                {
                  if (localDeclaration3 != null)
                    break label1084;
                  break;
                  setCoercedReturnType(localObject4);
                }
              }
            }
          }
          label1037: label1086: localObject1 = getReturnType().getImplementationType();
          break label381;
          label1098: i4 = 0;
          break label393;
        }
      if (i6 != 0)
        arrayOfType[(arrayOfType.length - 1)] = Compilation.typeCallContext;
      int i18;
      if (i9 < i10)
      {
        Object localObject3 = localDeclaration1.getType();
        String str4 = ((Type)localObject3).getName();
        if ((paramClassType.getClassfileVersion() >= 3211264) && ((localObject3 instanceof ArrayType)))
        {
          i2 = 0x80 | i2;
          if ((i > 0) || (k < j) || ((!"gnu.lists.LList".equals(str4)) && (!(localObject3 instanceof ArrayType))))
          {
            localObject3 = Compilation.objArrayType;
            this.argsArray = new Variable("argsArray", Compilation.objArrayType);
            this.argsArray.setParameter(true);
          }
          this.firstArgsArrayArg = localDeclaration1;
          int i17 = arrayOfType.length;
          if (i3 == 0)
            break label1389;
          i18 = 2;
          label1247: arrayOfType[(i17 - i18)] = localObject3;
        }
      }
      else
      {
        if (i3 != 0)
          localStringBuffer.append("$X");
        if ((!(localLambdaExp1 instanceof ClassExp)) && ((!(localLambdaExp1 instanceof ModuleExp)) || (!((ModuleExp)localLambdaExp1).getFlag(131072))))
          break label1395;
      }
      String str2;
      ClassType localClassType1;
      label1389: label1395: for (int i12 = 1; ; i12 = 0)
      {
        str2 = localStringBuffer.toString();
        int i13 = 0;
        int i14 = localStringBuffer.length();
        while (true)
        {
          localClassType1 = paramClassType;
          if (localClassType1 == null)
            break label1406;
          if (localClassType1.getDeclaredMethod(str2, arrayOfType) == null)
            break;
          localStringBuffer.setLength(i14);
          localStringBuffer.append('$');
          i13++;
          localStringBuffer.append(i13);
          str2 = localStringBuffer.toString();
        }
        localStringBuffer.append("$V");
        break;
        i18 = 1;
        break label1247;
      }
      label1406: Method localMethod1;
      ClassType[] arrayOfClassType;
      int i16;
      label1459: Expression localExpression1;
      String str3;
      ReferenceExp localReferenceExp;
      Declaration localDeclaration2;
      ClassType localClassType2;
      if (i12 != 0)
      {
        localMethod1 = paramClassType.addMethod(str2, arrayOfType, (Type)localObject1, i2);
        arrayOfMethod1[i8] = localMethod1;
        if ((this.throwsSpecification == null) || (this.throwsSpecification.length <= 0))
          continue;
        int i15 = this.throwsSpecification.length;
        arrayOfClassType = new ClassType[i15];
        i16 = 0;
        if (i16 >= i15)
          break label1786;
        localExpression1 = this.throwsSpecification[i16];
        str3 = null;
        if (!(localExpression1 instanceof ReferenceExp))
          break label1659;
        localReferenceExp = (ReferenceExp)localExpression1;
        localDeclaration2 = localReferenceExp.getBinding();
        if (localDeclaration2 == null)
          break label1627;
        Expression localExpression2 = localDeclaration2.getValue();
        if (!(localExpression2 instanceof ClassExp))
          break label1589;
        localClassType2 = ((ClassExp)localExpression2).getCompiledClassType(paramCompilation);
      }
      while (true)
      {
        if ((localClassType2 == null) && (str3 == null))
          str3 = "invalid throws specification";
        if (str3 != null)
        {
          paramCompilation.error('e', str3, localExpression1);
          localClassType2 = Type.javalangThrowableType;
        }
        arrayOfClassType[i16] = localClassType2;
        i16++;
        break label1459;
        localClassType1 = localClassType1.getSuperclass();
        break;
        label1589: str3 = "throws specification " + localDeclaration2.getName() + " has non-class lexical binding";
        localClassType2 = null;
        continue;
        label1627: str3 = "unknown class " + localReferenceExp.getName();
        localClassType2 = null;
        continue;
        label1659: boolean bool1 = localExpression1 instanceof QuoteExp;
        localClassType2 = null;
        str3 = null;
        if (bool1)
        {
          Object localObject2 = ((QuoteExp)localExpression1).getValue();
          if ((localObject2 instanceof Class))
            localObject2 = Type.make((Class)localObject2);
          boolean bool2 = localObject2 instanceof ClassType;
          localClassType2 = null;
          if (bool2)
            localClassType2 = (ClassType)localObject2;
          str3 = null;
          if (localClassType2 != null)
          {
            ClassType localClassType3 = Type.javalangThrowableType;
            boolean bool3 = localClassType2.isSubtype(localClassType3);
            str3 = null;
            if (!bool3)
              str3 = localClassType2.getName() + " does not extend Throwable";
          }
        }
      }
      label1786: ExceptionsAttr localExceptionsAttr = new ExceptionsAttr(localMethod1);
      localExceptionsAttr.setExceptions(arrayOfClassType);
    }
  }

  void addMethodFor(Compilation paramCompilation, ObjectType paramObjectType)
  {
    for (Object localObject = this; (localObject != null) && (!(localObject instanceof ClassExp)); localObject = ((ScopeExp)localObject).outer);
    if (localObject != null);
    for (ClassType localClassType = ((ClassExp)localObject).instanceType; ; localClassType = getOwningLambda().getHeapFrameType())
    {
      addMethodFor(localClassType, paramCompilation, paramObjectType);
      return;
    }
  }

  public void allocChildClasses(Compilation paramCompilation)
  {
    Method localMethod = getMainMethod();
    if ((localMethod != null) && (!localMethod.getStaticFlag()))
      declareThis(localMethod.getDeclaringClass());
    Declaration localDeclaration = firstDecl();
    if ((localDeclaration == this.firstArgsArrayArg) && (this.argsArray != null))
      getVarScope().addVariable(this.argsArray);
    if ((!getInlineOnly()) && (getCallConvention() >= 2))
    {
      if (this.firstArgsArrayArg != null)
        break label120;
      if (localDeclaration != null);
    }
    while (true)
    {
      getVarScope().addVariable(null, Compilation.typeCallContext, "$ctx").setParameter(true);
      label120: 
      do
      {
        do
        {
          if (localDeclaration != null)
            break label152;
          declareClosureEnv();
          allocFrame(paramCompilation);
          allocChildMethods(paramCompilation);
          return;
          if (this.argsArray == null)
            break;
        }
        while (localDeclaration != this.firstArgsArrayArg);
        break;
      }
      while (localDeclaration != this.firstArgsArrayArg.nextDecl());
    }
    label152: if ((localDeclaration.var != null) || ((getInlineOnly()) && (localDeclaration.ignorable())));
    while (true)
    {
      localDeclaration = localDeclaration.nextDecl();
      break;
      if ((localDeclaration.isSimple()) && (!localDeclaration.isIndirectBinding()))
      {
        localDeclaration.allocateVariable(null);
      }
      else
      {
        String str = Compilation.mangleName(localDeclaration.getName()).intern();
        Type localType = localDeclaration.getType().getImplementationType();
        Variable localVariable = getVarScope().addVariable(null, localType, str);
        localDeclaration.var = localVariable;
        localVariable.setParameter(true);
      }
    }
  }

  void allocChildMethods(Compilation paramCompilation)
  {
    LambdaExp localLambdaExp = this.firstChild;
    while (localLambdaExp != null)
    {
      if ((!localLambdaExp.isClassGenerated()) && (!localLambdaExp.getInlineOnly()) && (localLambdaExp.nameDecl != null))
        localLambdaExp.allocMethod(this, paramCompilation);
      ClassType localClassType;
      if ((localLambdaExp instanceof ClassExp))
      {
        ClassExp localClassExp = (ClassExp)localLambdaExp;
        if (localClassExp.getNeedsClosureEnv())
        {
          if ((!(this instanceof ModuleExp)) && (!(this instanceof ClassExp)))
            break label109;
          localClassType = (ClassType)getType();
          Field localField = localClassExp.instanceType.setOuterLink(localClassType);
          localClassExp.staticLinkField = localField;
          localClassExp.closureEnvField = localField;
        }
      }
      localLambdaExp = localLambdaExp.nextSibling;
      continue;
      label109: if (this.heapFrame != null);
      for (Variable localVariable = this.heapFrame; ; localVariable = this.closureEnv)
      {
        localClassType = (ClassType)localVariable.getType();
        break;
      }
    }
  }

  Field allocFieldFor(Compilation paramCompilation)
  {
    if ((this.nameDecl != null) && (this.nameDecl.field != null))
      return this.nameDecl.field;
    boolean bool1 = getNeedsClosureEnv();
    ClassType localClassType;
    String str1;
    String str2;
    label57: int i;
    String str3;
    int k;
    if (bool1)
    {
      localClassType = getOwningLambda().getHeapFrameType();
      str1 = getName();
      if (str1 != null)
        break label307;
      str2 = "lambda";
      i = 16;
      if ((this.nameDecl == null) || (!(this.nameDecl.context instanceof ModuleExp)))
        break label323;
      boolean bool2 = this.nameDecl.needsExternalAccess();
      if (bool2)
        str2 = "$Prvt$" + str2;
      if (this.nameDecl.getFlag(2048L))
      {
        i |= 8;
        if (!((ModuleExp)this.nameDecl.context).isStatic())
          i &= -17;
      }
      if ((!this.nameDecl.isPrivate()) || (bool2) || (paramCompilation.immediate))
        i |= 1;
      if ((0x800 & this.flags) != 0)
      {
        str3 = str2;
        if (this.min_args != this.max_args)
          break label317;
        k = this.min_args;
      }
    }
    while (true)
    {
      label221: StringBuilder localStringBuilder2 = new StringBuilder().append(str3).append('$');
      int m = k + 1;
      str2 = k;
      if (localClassType.getDeclaredField(str2) == null)
        while (true)
        {
          Field localField = localClassType.addField(str2, Compilation.typeModuleMethod, i);
          if (this.nameDecl != null)
            this.nameDecl.field = localField;
          return localField;
          localClassType = paramCompilation.mainClass;
          break;
          label307: str2 = Compilation.mangleNameIfNeeded(str1);
          break label57;
          label317: k = 1;
          break label221;
          label323: StringBuilder localStringBuilder1 = new StringBuilder().append(str2).append("$Fn");
          int j = 1 + paramCompilation.localFieldIndex;
          paramCompilation.localFieldIndex = j;
          str2 = j;
          if (!bool1)
            i |= 8;
        }
      k = m;
    }
  }

  public void allocFrame(Compilation paramCompilation)
  {
    ClassType localClassType;
    if (this.heapFrame != null)
    {
      if ((!(this instanceof ModuleExp)) && (!(this instanceof ClassExp)))
        break label36;
      localClassType = getCompiledClassType(paramCompilation);
    }
    while (true)
    {
      this.heapFrame.setType(localClassType);
      return;
      label36: localClassType = new ClassType(paramCompilation.generateClassName("frame"));
      localClassType.setSuper(paramCompilation.getModuleType());
      paramCompilation.addClass(localClassType);
    }
  }

  void allocMethod(LambdaExp paramLambdaExp, Compilation paramCompilation)
  {
    Object localObject;
    if (!getNeedsClosureEnv())
      localObject = null;
    while (true)
    {
      addMethodFor(paramCompilation, (ObjectType)localObject);
      return;
      if (((paramLambdaExp instanceof ClassExp)) || ((paramLambdaExp instanceof ModuleExp)))
      {
        localObject = paramLambdaExp.getCompiledClassType(paramCompilation);
      }
      else
      {
        for (LambdaExp localLambdaExp = paramLambdaExp; localLambdaExp.heapFrame == null; localLambdaExp = localLambdaExp.outerLambda());
        localObject = (ClassType)localLambdaExp.heapFrame.getType();
      }
    }
  }

  void allocParameters(Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    localCodeAttr.locals.enterScope(getVarScope());
    int i = getLineNumber();
    if (i > 0)
      localCodeAttr.putLineNumber(getFileName(), i);
    if (this.heapFrame != null)
      this.heapFrame.allocateLocal(localCodeAttr);
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    setIndexes();
    paramCallContext.writeValue(new Closure(this, paramCallContext));
  }

  public void capture(Declaration paramDeclaration)
  {
    if (paramDeclaration.isSimple())
    {
      if ((this.capturedVars == null) && (!paramDeclaration.isStatic()) && (!(this instanceof ModuleExp)) && (!(this instanceof ClassExp)))
        this.heapFrame = new Variable("heapFrame");
      paramDeclaration.setSimple(false);
      if (!paramDeclaration.isPublic())
      {
        paramDeclaration.nextCapturedVar = this.capturedVars;
        this.capturedVars = paramDeclaration;
      }
    }
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    if ((paramTarget instanceof IgnoreTarget))
      return;
    CodeAttr localCodeAttr = paramCompilation.getCode();
    LambdaExp localLambdaExp1 = outerLambda();
    ClassType localClassType = Compilation.typeModuleMethod;
    if (((0x100 & this.flags) != 0) || ((paramCompilation.immediate) && ((localLambdaExp1 instanceof ModuleExp))))
    {
      if (this.primMethods == null)
        allocMethod(outerLambda(), paramCompilation);
      compileAsMethod(paramCompilation);
      addApplyMethod(paramCompilation, null);
      ProcInitializer.emitLoadModuleMethod(this, paramCompilation);
    }
    Field localField;
    while (true)
    {
      paramTarget.compileFromStack(paramCompilation, localClassType);
      return;
      localField = compileSetField(paramCompilation);
      if (!localField.getStaticFlag())
        break;
      localCodeAttr.emitGetStatic(localField);
    }
    LambdaExp localLambdaExp2 = paramCompilation.curLambda;
    if (localLambdaExp2.heapFrame != null);
    for (Variable localVariable = localLambdaExp2.heapFrame; ; localVariable = localLambdaExp2.closureEnv)
    {
      localCodeAttr.emitLoad(localVariable);
      localCodeAttr.emitGetField(localField);
      break;
    }
  }

  void compileAsMethod(Compilation paramCompilation)
  {
    if (((0x80 & this.flags) != 0) || (isAbstract()));
    do
    {
      return;
      this.flags = (0x80 | this.flags);
    }
    while (this.primMethods == null);
    Method localMethod = paramCompilation.method;
    LambdaExp localLambdaExp = paramCompilation.curLambda;
    paramCompilation.curLambda = this;
    boolean bool = this.primMethods[0].getStaticFlag();
    int i = this.primMethods.length - 1;
    Type localType = restArgType();
    long[] arrayOfLong = null;
    if (i > 0)
    {
      arrayOfLong = new long[i + this.min_args];
      int i7 = 0;
      Declaration localDeclaration3 = firstDecl();
      while (true)
      {
        int i8 = i + this.min_args;
        if (i7 >= i8)
          break;
        int i9 = i7 + 1;
        arrayOfLong[i7] = localDeclaration3.flags;
        localDeclaration3 = localDeclaration3.nextDecl();
        i7 = i9;
      }
    }
    if (getCallConvention() >= 2);
    int k;
    CodeAttr localCodeAttr;
    int i2;
    for (int j = 1; ; j = 0)
    {
      k = 0;
      if (k > i)
        break label736;
      paramCompilation.method = this.primMethods[k];
      if (k >= i)
        break label626;
      localCodeAttr = paramCompilation.method.startCode();
      for (i2 = k + 1; (i2 < i) && ((this.defaultArgs[i2] instanceof QuoteExp)); i2++);
    }
    if ((i2 == i) && (localType != null));
    Variable localVariable1;
    Variable localVariable2;
    Declaration localDeclaration2;
    for (int i3 = 1; ; i3 = 0)
    {
      localVariable1 = paramCompilation.callContextVar;
      localVariable2 = localCodeAttr.getArg(0);
      if (!bool)
      {
        localCodeAttr.emitPushThis();
        if (getNeedsClosureEnv())
          this.closureEnv = localVariable2;
        localVariable2 = localCodeAttr.getArg(1);
      }
      localDeclaration2 = firstDecl();
      int i4 = 0;
      while (true)
      {
        int i5 = k + this.min_args;
        if (i4 >= i5)
          break;
        long l2 = 0x40 | localDeclaration2.flags;
        localDeclaration2.flags = l2;
        Variable localVariable4 = localVariable2;
        localDeclaration2.var = localVariable4;
        localCodeAttr.emitLoad(localVariable2);
        localVariable2 = localVariable2.nextVar();
        i4++;
        localDeclaration2 = localDeclaration2.nextDecl();
      }
    }
    if (j != 0);
    for (Variable localVariable3 = localVariable2; ; localVariable3 = null)
    {
      paramCompilation.callContextVar = localVariable3;
      int i6 = k;
      while (i6 < i2)
      {
        Target localTarget = StackTarget.getInstance(localDeclaration2.getType());
        this.defaultArgs[i6].compile(paramCompilation, localTarget);
        i6++;
        localDeclaration2 = localDeclaration2.nextDecl();
      }
    }
    String str;
    QuoteExp localQuoteExp;
    if (i3 != 0)
    {
      str = localType.getName();
      if ("gnu.lists.LList".equals(str))
      {
        LList localLList = LList.Empty;
        localQuoteExp = new QuoteExp(localLList);
        label493: localQuoteExp.compile(paramCompilation, localType);
      }
    }
    else
    {
      if (j != 0)
        localCodeAttr.emitLoad(localVariable2);
      if (!bool)
        break label611;
      localCodeAttr.emitInvokeStatic(this.primMethods[i2]);
      label530: localCodeAttr.emitReturn();
      this.closureEnv = null;
      paramCompilation.callContextVar = localVariable1;
    }
    while (true)
    {
      k++;
      break;
      if ("java.lang.Object[]".equals(str))
      {
        Object[] arrayOfObject = Values.noArgs;
        localQuoteExp = new QuoteExp(arrayOfObject);
        break label493;
      }
      throw new Error("unimplemented #!rest type " + str);
      label611: localCodeAttr.emitInvokeVirtual(this.primMethods[i2]);
      break label530;
      label626: if (arrayOfLong != null)
      {
        int m = 0;
        Declaration localDeclaration1 = firstDecl();
        while (true)
        {
          int n = i + this.min_args;
          if (m >= n)
            break;
          int i1 = m + 1;
          long l1 = arrayOfLong[m];
          localDeclaration1.flags = l1;
          localDeclaration1.var = null;
          localDeclaration1 = localDeclaration1.nextDecl();
          m = i1;
        }
      }
      paramCompilation.method.initCode();
      allocChildClasses(paramCompilation);
      allocParameters(paramCompilation);
      enterFunction(paramCompilation);
      compileBody(paramCompilation);
      compileEnd(paramCompilation);
      generateApplyMethods(paramCompilation);
    }
    label736: paramCompilation.method = localMethod;
    paramCompilation.curLambda = localLambdaExp;
  }

  public void compileBody(Compilation paramCompilation)
  {
    Variable localVariable1 = paramCompilation.callContextVar;
    paramCompilation.callContextVar = null;
    Target localTarget;
    Expression localExpression;
    if (getCallConvention() >= 2)
    {
      Variable localVariable2 = getVarScope().lookup("$ctx");
      if ((localVariable2 != null) && (localVariable2.getType() == Compilation.typeCallContext))
        paramCompilation.callContextVar = localVariable2;
      localTarget = ConsumerTarget.makeContextTarget(paramCompilation);
      localExpression = this.body;
      if (this.body.getLineNumber() <= 0)
        break label105;
    }
    label105: for (Object localObject = this.body; ; localObject = this)
    {
      localExpression.compileWithPosition(paramCompilation, localTarget, (Expression)localObject);
      paramCompilation.callContextVar = localVariable1;
      return;
      localTarget = Target.pushValue(getReturnType());
      break;
    }
  }

  public void compileEnd(Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (!getInlineOnly())
    {
      if ((paramCompilation.method.reachableHere()) && ((Compilation.defaultCallConvention < 3) || (isModuleBody()) || (isClassMethod()) || (isHandlingTailCalls())))
        localCodeAttr.emitReturn();
      popScope(localCodeAttr);
      localCodeAttr.popScope();
    }
    for (LambdaExp localLambdaExp = this.firstChild; localLambdaExp != null; localLambdaExp = localLambdaExp.nextSibling)
      if ((!localLambdaExp.getCanRead()) && (!localLambdaExp.getInlineOnly()))
        localLambdaExp.compileAsMethod(paramCompilation);
    if (this.heapFrame != null)
      paramCompilation.generateConstructor(this);
  }

  public Field compileSetField(Compilation paramCompilation)
  {
    if (this.primMethods == null)
      allocMethod(outerLambda(), paramCompilation);
    Field localField = allocFieldFor(paramCompilation);
    if (paramCompilation.usingCPStyle())
      compile(paramCompilation, Type.objectType);
    while (true)
    {
      return new ProcInitializer(this, paramCompilation, localField).field;
      compileAsMethod(paramCompilation);
      addApplyMethod(paramCompilation, localField);
    }
  }

  public Variable declareClosureEnv()
  {
    LambdaExp localLambdaExp;
    Variable localVariable1;
    if ((this.closureEnv == null) && (getNeedsClosureEnv()))
    {
      localLambdaExp = outerLambda();
      if ((localLambdaExp instanceof ClassExp))
        localLambdaExp = localLambdaExp.outerLambda();
      if (localLambdaExp.heapFrame == null)
        break label80;
      localVariable1 = localLambdaExp.heapFrame;
      if ((!isClassMethod()) || ("*init*".equals(getName())))
        break label88;
      this.closureEnv = declareThis(this.type);
    }
    while (true)
    {
      return this.closureEnv;
      label80: localVariable1 = localLambdaExp.closureEnv;
      break;
      label88: if ((localLambdaExp.heapFrame == null) && (!localLambdaExp.getNeedsStaticLink()) && (!(localLambdaExp instanceof ModuleExp)))
      {
        this.closureEnv = null;
      }
      else if ((!isClassGenerated()) && (!getInlineOnly()))
      {
        Method localMethod = getMainMethod();
        boolean bool = "*init*".equals(getName());
        if ((!localMethod.getStaticFlag()) && (!bool))
        {
          this.closureEnv = declareThis(localMethod.getDeclaringClass());
        }
        else
        {
          this.closureEnv = new Variable("closureEnv", localMethod.getParameterTypes()[0]);
          if (bool);
          for (Variable localVariable2 = declareThis(localMethod.getDeclaringClass()); ; localVariable2 = null)
          {
            getVarScope().addVariableAfter(localVariable2, this.closureEnv);
            this.closureEnv.setParameter(true);
            break;
          }
        }
      }
      else if (inlinedIn(localLambdaExp))
      {
        this.closureEnv = localVariable1;
      }
      else
      {
        this.closureEnv = new Variable("closureEnv", localVariable1.getType());
        getVarScope().addVariable(this.closureEnv);
      }
    }
  }

  public Variable declareThis(ClassType paramClassType)
  {
    if (this.thisVariable == null)
    {
      this.thisVariable = new Variable("this");
      getVarScope().addVariableAfter(null, this.thisVariable);
      this.thisVariable.setParameter(true);
    }
    if (this.thisVariable.getType() == null)
      this.thisVariable.setType(paramClassType);
    if ((this.decls != null) && (this.decls.isThisParameter()))
      this.decls.var = this.thisVariable;
    return this.thisVariable;
  }

  void enterFunction(Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    getVarScope().noteStartFunction(localCodeAttr);
    ClassType localClassType2;
    label106: Declaration localDeclaration3;
    if ((this.closureEnv != null) && (!this.closureEnv.isParameter()) && (!paramCompilation.usingCPStyle()))
    {
      if (!getInlineOnly())
      {
        localCodeAttr.emitPushThis();
        Field localField = this.closureEnvField;
        if (localField == null)
          localField = outerLambda().closureEnvField;
        localCodeAttr.emitGetField(localField);
        localCodeAttr.emitStore(this.closureEnv);
      }
    }
    else
    {
      if (paramCompilation.usingCPStyle())
        break label192;
      if (this.heapFrame != null)
        break label165;
      localClassType2 = currentModule().getCompiledClassType(paramCompilation);
      localDeclaration3 = this.capturedVars;
      label112: if (localDeclaration3 == null)
        break label192;
      if (localDeclaration3.field == null)
        break label180;
    }
    while (true)
    {
      localDeclaration3 = localDeclaration3.nextCapturedVar;
      break label112;
      if (inlinedIn(outerLambda()))
        break;
      outerLambda().loadHeapFrame(paramCompilation);
      localCodeAttr.emitStore(this.closureEnv);
      break;
      label165: localClassType2 = (ClassType)this.heapFrame.getType();
      break label106;
      label180: localDeclaration3.makeField(localClassType2, paramCompilation, null);
    }
    label192: if ((this.heapFrame != null) && (!paramCompilation.usingCPStyle()))
    {
      ClassType localClassType1 = (ClassType)this.heapFrame.getType();
      if ((this.closureEnv != null) && (!(this instanceof ModuleExp)))
        this.staticLinkField = localClassType1.addField("staticLink", this.closureEnv.getType());
      if ((!(this instanceof ModuleExp)) && (!(this instanceof ClassExp)))
      {
        localClassType1.setEnclosingMember(paramCompilation.method);
        localCodeAttr.emitNew(localClassType1);
        localCodeAttr.emitDup(localClassType1);
        localCodeAttr.emitInvokeSpecial(Compilation.getConstructor(localClassType1, this));
        if (this.staticLinkField != null)
        {
          localCodeAttr.emitDup(localClassType1);
          localCodeAttr.emitLoad(this.closureEnv);
          localCodeAttr.emitPutField(this.staticLinkField);
        }
        localCodeAttr.emitStore(this.heapFrame);
      }
    }
    Variable localVariable1 = this.argsArray;
    if ((this.min_args == this.max_args) && (this.primMethods == null) && (getCallConvention() < 2))
      localVariable1 = null;
    int i = 0;
    int j;
    if (this.keywords == null)
    {
      j = 0;
      if (this.defaultArgs != null)
        break label407;
    }
    label407: for (int k = 0; ; k = this.defaultArgs.length - j)
    {
      if (!(this instanceof ModuleExp))
        break label420;
      return;
      j = this.keywords.length;
      break;
    }
    label420: int m = -1;
    int n = 0;
    getMainMethod();
    Variable localVariable2 = paramCompilation.callContextVar;
    Declaration localDeclaration1 = firstDecl();
    int i1 = 0;
    int i2 = 0;
    Variable localVariable3;
    label465: label508: Type localType;
    Object localObject;
    label546: int i5;
    int i6;
    if (localDeclaration1 != null)
      if (getCallConvention() < 2)
      {
        localVariable3 = null;
        paramCompilation.callContextVar = localVariable3;
        Declaration localDeclaration2 = this.firstArgsArrayArg;
        if ((localDeclaration1 == localDeclaration2) && (localVariable1 != null))
        {
          if (this.primMethods == null)
            break label688;
          m = i;
          n = m - this.min_args;
        }
        if ((m < 0) && (localDeclaration1.isSimple()) && (!localDeclaration1.isIndirectBinding()))
          break label1170;
        localType = localDeclaration1.getType();
        if (m < 0)
          break label697;
        localObject = Type.objectType;
        if (!localDeclaration1.isSimple())
          localDeclaration1.loadOwningObject(null, paramCompilation);
        if (m >= 0)
          break label704;
        localCodeAttr.emitLoad(localDeclaration1.getVariable());
        i5 = i1;
        i6 = i2;
        label583: if (localType != localObject)
          CheckedTarget.emitCheckedCoerce(paramCompilation, this, i + 1, localType);
        if (localDeclaration1.isIndirectBinding())
          localDeclaration1.pushIndirectBinding(paramCompilation);
        if (!localDeclaration1.isSimple())
          break label1145;
        Variable localVariable4 = localDeclaration1.getVariable();
        if (localDeclaration1.isIndirectBinding())
          localVariable4.setType(Compilation.typeLocation);
        localCodeAttr.emitStore(localVariable4);
      }
    while (true)
    {
      i++;
      localDeclaration1 = localDeclaration1.nextDecl();
      i1 = i5;
      i2 = i6;
      break;
      localVariable3 = getVarScope().lookup("$ctx");
      break label465;
      label688: n = 0;
      m = 0;
      break label508;
      label697: localObject = localType;
      break label546;
      label704: int i3 = this.min_args;
      if (i < i3)
      {
        localCodeAttr.emitLoad(localVariable1);
        localCodeAttr.emitPushInt(i);
        localCodeAttr.emitArrayLoad(Type.objectType);
        i5 = i1;
        i6 = i2;
        break label583;
      }
      int i4 = k + this.min_args;
      if (i < i4)
      {
        localCodeAttr.emitPushInt(i - m);
        localCodeAttr.emitLoad(localVariable1);
        localCodeAttr.emitArrayLength();
        localCodeAttr.emitIfIntLt();
        localCodeAttr.emitLoad(localVariable1);
        localCodeAttr.emitPushInt(i - m);
        localCodeAttr.emitArrayLoad();
        localCodeAttr.emitElse();
        Expression[] arrayOfExpression2 = this.defaultArgs;
        i6 = i2 + 1;
        arrayOfExpression2[(n + i2)].compile(paramCompilation, localType);
        localCodeAttr.emitFi();
        i5 = i1;
        break label583;
      }
      if (this.max_args < 0)
      {
        int i7 = k + this.min_args;
        if (i == i7)
        {
          localCodeAttr.emitLoad(localVariable1);
          localCodeAttr.emitPushInt(i - m);
          localCodeAttr.emitInvokeStatic(Compilation.makeListMethod);
          localObject = Compilation.scmListType;
          i5 = i1;
          i6 = i2;
          break label583;
        }
      }
      localCodeAttr.emitLoad(localVariable1);
      localCodeAttr.emitPushInt(k + this.min_args - m);
      Keyword[] arrayOfKeyword = this.keywords;
      i5 = i1 + 1;
      paramCompilation.compileConstant(arrayOfKeyword[i1]);
      Expression[] arrayOfExpression1 = this.defaultArgs;
      i6 = i2 + 1;
      Expression localExpression = arrayOfExpression1[(n + i2)];
      if ((localExpression instanceof QuoteExp))
      {
        if (searchForKeywordMethod4 == null)
        {
          Type[] arrayOfType2 = new Type[4];
          arrayOfType2[0] = Compilation.objArrayType;
          arrayOfType2[1] = Type.intType;
          arrayOfType2[2] = Type.objectType;
          arrayOfType2[3] = Type.objectType;
          searchForKeywordMethod4 = Compilation.scmKeywordType.addMethod("searchForKeyword", arrayOfType2, Type.objectType, 9);
        }
        localExpression.compile(paramCompilation, localType);
        localCodeAttr.emitInvokeStatic(searchForKeywordMethod4);
        break label583;
      }
      if (searchForKeywordMethod3 == null)
      {
        Type[] arrayOfType1 = new Type[3];
        arrayOfType1[0] = Compilation.objArrayType;
        arrayOfType1[1] = Type.intType;
        arrayOfType1[2] = Type.objectType;
        searchForKeywordMethod3 = Compilation.scmKeywordType.addMethod("searchForKeyword", arrayOfType1, Type.objectType, 9);
      }
      localCodeAttr.emitInvokeStatic(searchForKeywordMethod3);
      localCodeAttr.emitDup(1);
      paramCompilation.compileConstant(Special.dfault);
      localCodeAttr.emitIfEq();
      localCodeAttr.emitPop(1);
      localExpression.compile(paramCompilation, localType);
      localCodeAttr.emitFi();
      break label583;
      label1145: localCodeAttr.emitPutField(localDeclaration1.field);
      continue;
      paramCompilation.callContextVar = localVariable2;
      return;
      label1170: i5 = i1;
      i6 = i2;
    }
  }

  Object evalDefaultArg(int paramInt, CallContext paramCallContext)
  {
    try
    {
      Object localObject = this.defaultArgs[paramInt].eval(paramCallContext);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw new WrappedException("error evaluating default argument", localThrowable);
    }
  }

  public void generateApplyMethods(Compilation paramCompilation)
  {
    paramCompilation.generateMatchMethods(this);
    if (Compilation.defaultCallConvention >= 2)
    {
      paramCompilation.generateApplyMethodsWithContext(this);
      return;
    }
    paramCompilation.generateApplyMethodsWithoutContext(this);
  }

  Declaration getArg(int paramInt)
  {
    for (Declaration localDeclaration = firstDecl(); ; localDeclaration = localDeclaration.nextDecl())
    {
      if (localDeclaration == null)
        throw new Error("internal error - getArg");
      if (paramInt == 0)
        return localDeclaration;
      paramInt--;
    }
  }

  public int getCallConvention()
  {
    if (isModuleBody())
    {
      if (Compilation.defaultCallConvention >= 2)
        return Compilation.defaultCallConvention;
      return 2;
    }
    if (isClassMethod())
      return 1;
    if (Compilation.defaultCallConvention != 0)
      return Compilation.defaultCallConvention;
    return 1;
  }

  public LambdaExp getCaller()
  {
    return this.inlineHome;
  }

  public final boolean getCanCall()
  {
    return (0x4 & this.flags) != 0;
  }

  public final boolean getCanRead()
  {
    return (0x2 & this.flags) != 0;
  }

  public ClassType getClassType()
  {
    return this.type;
  }

  protected ClassType getCompiledClassType(Compilation paramCompilation)
  {
    if (this.type == Compilation.typeProcedure)
      throw new Error("internal error: getCompiledClassType");
    return this.type;
  }

  protected final String getExpClassName()
  {
    String str = getClass().getName();
    int i = str.lastIndexOf('.');
    if (i >= 0)
      str = str.substring(i + 1);
    return str;
  }

  public ClassType getHeapFrameType()
  {
    if (((this instanceof ModuleExp)) || ((this instanceof ClassExp)))
      return (ClassType)getType();
    return (ClassType)this.heapFrame.getType();
  }

  public final boolean getImportsLexVars()
  {
    return (0x8 & this.flags) != 0;
  }

  public final boolean getInlineOnly()
  {
    return (0x2000 & this.flags) != 0;
  }

  public final Method getMainMethod()
  {
    Method[] arrayOfMethod = this.primBodyMethods;
    if (arrayOfMethod == null)
      return null;
    return arrayOfMethod[(arrayOfMethod.length - 1)];
  }

  public final Method getMethod(int paramInt)
  {
    if ((this.primMethods == null) || ((this.max_args >= 0) && (paramInt > this.max_args)))
      return null;
    int i = paramInt - this.min_args;
    if (i < 0)
      return null;
    int j = this.primMethods.length;
    Method[] arrayOfMethod = this.primMethods;
    if (i < j);
    for (int k = i; ; k = j - 1)
      return arrayOfMethod[k];
  }

  public final boolean getNeedsClosureEnv()
  {
    return (0x18 & this.flags) != 0;
  }

  public final boolean getNeedsStaticLink()
  {
    return (0x10 & this.flags) != 0;
  }

  public LambdaExp getOwningLambda()
  {
    for (ScopeExp localScopeExp = this.outer; ; localScopeExp = localScopeExp.outer)
    {
      if (localScopeExp == null)
        return null;
      if (((localScopeExp instanceof ModuleExp)) || (((localScopeExp instanceof ClassExp)) && (getNeedsClosureEnv())) || (((localScopeExp instanceof LambdaExp)) && (((LambdaExp)localScopeExp).heapFrame != null)))
        return (LambdaExp)localScopeExp;
    }
  }

  public Object getProperty(Object paramObject1, Object paramObject2)
  {
    if (this.properties != null)
    {
      int i = this.properties.length;
      do
      {
        i -= 2;
        if (i < 0)
          break;
      }
      while (this.properties[i] != paramObject1);
      return this.properties[(i + 1)];
    }
    return paramObject2;
  }

  public final Type getReturnType()
  {
    if (this.returnType == null)
    {
      this.returnType = Type.objectType;
      if ((this.body != null) && (!isAbstract()))
        this.returnType = this.body.getType();
    }
    return this.returnType;
  }

  int getSelectorValue(Compilation paramCompilation)
  {
    int i = this.selectorValue;
    if (i == 0)
    {
      int j = paramCompilation.maxSelectorValue;
      paramCompilation.maxSelectorValue = (j + this.primMethods.length);
      i = j + 1;
      this.selectorValue = i;
    }
    return i;
  }

  public Type getType()
  {
    return this.type;
  }

  public int incomingArgs()
  {
    if ((this.min_args == this.max_args) && (this.max_args <= 4) && (this.max_args > 0))
      return this.max_args;
    return 1;
  }

  boolean inlinedIn(LambdaExp paramLambdaExp)
  {
    for (LambdaExp localLambdaExp = this; localLambdaExp.getInlineOnly(); localLambdaExp = localLambdaExp.getCaller())
      if (localLambdaExp == paramLambdaExp)
        return true;
    return false;
  }

  public boolean isAbstract()
  {
    return this.body == QuoteExp.abstractExp;
  }

  public final boolean isClassGenerated()
  {
    return (isModuleBody()) || ((this instanceof ClassExp));
  }

  public final boolean isClassMethod()
  {
    return (0x40 & this.flags) != 0;
  }

  public final boolean isHandlingTailCalls()
  {
    return (isModuleBody()) || ((Compilation.defaultCallConvention >= 3) && (!isClassMethod()));
  }

  public final boolean isModuleBody()
  {
    return this instanceof ModuleExp;
  }

  public void loadHeapFrame(Compilation paramCompilation)
  {
    for (LambdaExp localLambdaExp = paramCompilation.curLambda; (localLambdaExp != this) && (localLambdaExp.getInlineOnly()); localLambdaExp = localLambdaExp.getCaller());
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if ((localLambdaExp.heapFrame != null) && (this == localLambdaExp))
      localCodeAttr.emitLoad(localLambdaExp.heapFrame);
    while (true)
    {
      return;
      ClassType localClassType;
      if (localLambdaExp.closureEnv != null)
      {
        localCodeAttr.emitLoad(localLambdaExp.closureEnv);
        localClassType = (ClassType)localLambdaExp.closureEnv.getType();
      }
      while (localLambdaExp != this)
      {
        Field localField = localLambdaExp.staticLinkField;
        if ((localField != null) && (localField.getDeclaringClass() == localClassType))
        {
          localCodeAttr.emitGetField(localField);
          localClassType = (ClassType)localField.getType();
        }
        localLambdaExp = localLambdaExp.outerLambda();
        continue;
        localCodeAttr.emitPushThis();
        localClassType = paramCompilation.curClass;
      }
    }
  }

  protected boolean mustCompile()
  {
    if ((this.keywords != null) && (this.keywords.length > 0))
      return true;
    if (this.defaultArgs != null)
    {
      int i = this.defaultArgs.length;
      Expression localExpression;
      do
      {
        i--;
        if (i < 0)
          break;
        localExpression = this.defaultArgs[i];
      }
      while ((localExpression == null) || ((localExpression instanceof QuoteExp)));
      return true;
    }
    return false;
  }

  public LambdaExp outerLambda()
  {
    if (this.outer == null)
      return null;
    return this.outer.currentLambda();
  }

  public LambdaExp outerLambdaNotInline()
  {
    Object localObject = this;
    LambdaExp localLambdaExp;
    do
    {
      do
      {
        localObject = ((ScopeExp)localObject).outer;
        if (localObject == null)
          break;
      }
      while (!(localObject instanceof LambdaExp));
      localLambdaExp = (LambdaExp)localObject;
    }
    while (localLambdaExp.getInlineOnly());
    return localLambdaExp;
    return null;
  }

  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(Lambda/", ")", 2);
    Object localObject1 = getSymbol();
    if (localObject1 != null)
    {
      paramOutPort.print(localObject1);
      paramOutPort.print('/');
    }
    paramOutPort.print(this.id);
    paramOutPort.print('/');
    paramOutPort.print("fl:");
    paramOutPort.print(Integer.toHexString(this.flags));
    paramOutPort.writeSpaceFill();
    printLineColumn(paramOutPort);
    paramOutPort.startLogicalBlock("(", false, ")");
    Object localObject2 = null;
    int i;
    int j;
    label105: Declaration localDeclaration;
    int k;
    int m;
    if (this.keywords == null)
    {
      i = 0;
      if (this.defaultArgs != null)
        break label289;
      j = 0;
      localDeclaration = firstDecl();
      if ((localDeclaration == null) || (!localDeclaration.isThisParameter()))
        break label411;
      k = -1;
      m = 0;
    }
    while (true)
    {
      label130: Object localObject3;
      label147: Expression[] arrayOfExpression;
      int n;
      if (localDeclaration != null)
        if (k < this.min_args)
        {
          localObject3 = null;
          if (localDeclaration != firstDecl())
            paramOutPort.writeSpaceFill();
          if (localObject3 != localObject2)
          {
            paramOutPort.print(localObject3);
            paramOutPort.writeSpaceFill();
          }
          if ((localObject3 != Special.optional) && (localObject3 != Special.key))
            break label401;
          arrayOfExpression = this.defaultArgs;
          n = m + 1;
        }
      for (Expression localExpression = arrayOfExpression[m]; ; localExpression = null)
      {
        if (localExpression != null)
          paramOutPort.print('(');
        localDeclaration.printInfo(paramOutPort);
        if ((localExpression != null) && (localExpression != QuoteExp.falseExp))
        {
          paramOutPort.print(' ');
          localExpression.print(paramOutPort);
          paramOutPort.print(')');
        }
        k++;
        localObject2 = localObject3;
        localDeclaration = localDeclaration.nextDecl();
        m = n;
        break label130;
        i = this.keywords.length;
        break;
        label289: j = this.defaultArgs.length - i;
        break label105;
        if (k < j + this.min_args)
        {
          localObject3 = Special.optional;
          break label147;
        }
        if ((this.max_args < 0) && (k == j + this.min_args))
        {
          localObject3 = Special.rest;
          break label147;
        }
        localObject3 = Special.key;
        break label147;
        paramOutPort.endLogicalBlock(")");
        paramOutPort.writeSpaceLinear();
        if (this.body == null)
          paramOutPort.print("<null body>");
        while (true)
        {
          paramOutPort.endLogicalBlock(")");
          return;
          this.body.print(paramOutPort);
        }
        label401: n = m;
      }
      label411: k = 0;
      m = 0;
      localObject2 = null;
    }
  }

  public final Type restArgType()
  {
    if (this.min_args == this.max_args)
      return null;
    if (this.primMethods == null)
      throw new Error("internal error - restArgType");
    Method[] arrayOfMethod = this.primMethods;
    if ((this.max_args >= 0) && (arrayOfMethod.length > this.max_args - this.min_args))
      return null;
    Method localMethod = arrayOfMethod[(arrayOfMethod.length - 1)];
    Type[] arrayOfType = localMethod.getParameterTypes();
    int i = arrayOfType.length - 1;
    if (localMethod.getName().endsWith("$X"))
      i--;
    return arrayOfType[i];
  }

  void setCallersNeedStaticLink()
  {
    LambdaExp localLambdaExp1 = outerLambda();
    for (ApplyExp localApplyExp = this.nameDecl.firstCall; localApplyExp != null; localApplyExp = localApplyExp.nextCall)
      for (LambdaExp localLambdaExp2 = localApplyExp.context; (localLambdaExp2 != localLambdaExp1) && (!(localLambdaExp2 instanceof ModuleExp)); localLambdaExp2 = localLambdaExp2.outerLambda())
        localLambdaExp2.setNeedsStaticLink();
  }

  public final void setCanCall(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x4 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFFB & this.flags);
  }

  public final void setCanRead(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x2 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFFD & this.flags);
  }

  public final void setClassMethod(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x40 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFBF & this.flags);
  }

  public final void setCoercedReturnType(Type paramType)
  {
    this.returnType = paramType;
    if ((paramType != null) && (paramType != Type.objectType) && (paramType != Type.voidType) && (this.body != QuoteExp.abstractExp))
    {
      Expression localExpression = this.body;
      this.body = Compilation.makeCoercion(localExpression, paramType);
      this.body.setLine(localExpression);
    }
  }

  public final void setCoercedReturnValue(Expression paramExpression, Language paramLanguage)
  {
    if (!isAbstract())
    {
      Expression localExpression = this.body;
      this.body = Compilation.makeCoercion(localExpression, paramExpression);
      this.body.setLine(localExpression);
    }
    Type localType = paramLanguage.getTypeFor(paramExpression);
    if (localType != null)
      setReturnType(localType);
  }

  public void setExceptions(Expression[] paramArrayOfExpression)
  {
    this.throwsSpecification = paramArrayOfExpression;
  }

  public final void setImportsLexVars()
  {
    int i = this.flags;
    this.flags = (0x8 | this.flags);
    if (((i & 0x8) == 0) && (this.nameDecl != null))
      setCallersNeedStaticLink();
  }

  public final void setImportsLexVars(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x8 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFF7 & this.flags);
  }

  public final void setInlineOnly(boolean paramBoolean)
  {
    setFlag(paramBoolean, 8192);
  }

  public final void setNeedsStaticLink()
  {
    int i = this.flags;
    this.flags = (0x10 | this.flags);
    if (((i & 0x10) == 0) && (this.nameDecl != null))
      setCallersNeedStaticLink();
  }

  public final void setNeedsStaticLink(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.flags = (0x10 | this.flags);
      return;
    }
    this.flags = (0xFFFFFFEF & this.flags);
  }

  public void setProperty(Object paramObject1, Object paramObject2)
  {
    try
    {
      this.properties = PropertySet.setProperty(this.properties, paramObject1, paramObject2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setReturnType(Type paramType)
  {
    this.returnType = paramType;
  }

  public void setType(ClassType paramClassType)
  {
    this.type = paramClassType;
  }

  public boolean side_effects()
  {
    return false;
  }

  public String toString()
  {
    String str = getExpClassName() + ':' + getSymbol() + '/' + this.id + '/';
    int i = getLineNumber();
    if ((i <= 0) && (this.body != null))
      i = this.body.getLineNumber();
    if (i > 0)
      str = str + "l:" + i;
    return str;
  }

  public Expression validateApply(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Declaration paramDeclaration)
  {
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    if ((0x1000 & this.flags) != 0)
    {
      Expression localExpression = InlineCalls.inlineCall(this, arrayOfExpression1, true);
      if (localExpression != null)
        return paramInlineCalls.visit(localExpression, paramType);
    }
    paramApplyExp.visitArgs(paramInlineCalls);
    int i = paramApplyExp.args.length;
    String str = WrongArguments.checkArgCount(getName(), this.min_args, this.max_args, i);
    if (str != null)
      return paramInlineCalls.noteError(str);
    int j = getCallConvention();
    if ((paramInlineCalls.getCompilation().inlineOk(this)) && (isClassMethod()) && ((j <= 2) || (j == 3)))
    {
      Method localMethod = getMethod(i);
      if (localMethod != null)
      {
        boolean bool = this.nameDecl.isStatic();
        if ((!bool) && ((this.outer instanceof ClassExp)) && (((ClassExp)this.outer).isMakingClassPair()));
        PrimProcedure localPrimProcedure = new PrimProcedure(localMethod, this);
        Expression[] arrayOfExpression2;
        if (bool)
          arrayOfExpression2 = paramApplyExp.args;
        while (true)
        {
          ApplyExp localApplyExp = new ApplyExp(localPrimProcedure, arrayOfExpression2);
          return localApplyExp.setLine(paramApplyExp);
          Declaration localDeclaration;
          for (LambdaExp localLambdaExp = paramInlineCalls.getCurrentLambda(); ; localLambdaExp = localLambdaExp.outerLambda())
          {
            if (localLambdaExp == null)
              return paramInlineCalls.noteError("internal error: missing " + this);
            if (localLambdaExp.outer == this.outer)
            {
              localDeclaration = localLambdaExp.firstDecl();
              if ((localDeclaration != null) && (localDeclaration.isThisParameter()))
                break;
              return paramInlineCalls.noteError("calling non-static method " + getName() + " from static method " + localLambdaExp.getName());
            }
          }
          int k = paramApplyExp.getArgCount();
          arrayOfExpression2 = new Expression[k + 1];
          System.arraycopy(paramApplyExp.getArgs(), 0, arrayOfExpression2, 1, k);
          ThisExp localThisExp = new ThisExp(localDeclaration);
          arrayOfExpression2[0] = localThisExp;
        }
      }
    }
    return paramApplyExp;
  }

  public final boolean variable_args()
  {
    return this.max_args < 0;
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    Compilation localCompilation = paramExpVisitor.getCompilation();
    LambdaExp localLambdaExp;
    if (localCompilation == null)
      localLambdaExp = null;
    try
    {
      Object localObject2 = paramExpVisitor.visitLambdaExp(this, paramD);
      return localObject2;
      localLambdaExp = localCompilation.curLambda;
      localCompilation.curLambda = this;
    }
    finally
    {
      if (localCompilation != null)
        localCompilation.curLambda = localLambdaExp;
    }
  }

  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    visitChildrenOnly(paramExpVisitor, paramD);
    visitProperties(paramExpVisitor, paramD);
  }

  protected final <R, D> void visitChildrenOnly(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    LambdaExp localLambdaExp = paramExpVisitor.currentLambda;
    paramExpVisitor.currentLambda = this;
    try
    {
      this.throwsSpecification = paramExpVisitor.visitExps(this.throwsSpecification, paramD);
      paramExpVisitor.visitDefaultArgs(this, paramD);
      if ((paramExpVisitor.exitValue == null) && (this.body != null))
        this.body = paramExpVisitor.update(this.body, paramExpVisitor.visit(this.body, paramD));
      return;
    }
    finally
    {
      paramExpVisitor.currentLambda = localLambdaExp;
    }
  }

  protected final <R, D> void visitProperties(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    if (this.properties != null)
    {
      int i = this.properties.length;
      for (int j = 1; j < i; j += 2)
      {
        Object localObject = this.properties[j];
        if ((localObject instanceof Expression))
          this.properties[j] = paramExpVisitor.visitAndUpdate((Expression)localObject, paramD);
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.LambdaExp
 * JD-Core Version:    0.6.2
 */