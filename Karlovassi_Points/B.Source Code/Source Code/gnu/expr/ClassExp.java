package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.mapping.OutPort;
import java.util.Hashtable;
import java.util.Vector;

public class ClassExp extends LambdaExp
{
  public static final int CLASS_SPECIFIED = 65536;
  public static final int HAS_SUBCLASS = 131072;
  public static final int INTERFACE_SPECIFIED = 32768;
  public static final int IS_ABSTRACT = 16384;
  public String classNameSpecifier;
  public LambdaExp clinitMethod;
  boolean explicitInit;
  public LambdaExp initMethod;
  ClassType instanceType;
  boolean partsDeclared;
  boolean simple;
  public int superClassIndex = -1;
  public Expression[] supers;

  public ClassExp()
  {
  }

  public ClassExp(boolean paramBoolean)
  {
    this.simple = paramBoolean;
    ClassType localClassType = new ClassType();
    this.type = localClassType;
    this.instanceType = localClassType;
  }

  static void getImplMethods(ClassType paramClassType, String paramString, Type[] paramArrayOfType, Vector paramVector)
  {
    ClassType localClassType;
    if ((paramClassType instanceof PairClassType))
    {
      localClassType = ((PairClassType)paramClassType).instanceType;
      Type[] arrayOfType = new Type[1 + paramArrayOfType.length];
      arrayOfType[0] = paramClassType;
      System.arraycopy(paramArrayOfType, 0, arrayOfType, 1, paramArrayOfType.length);
      Method localMethod = localClassType.getDeclaredMethod(paramString, arrayOfType);
      if (localMethod == null)
        break label152;
      int j = paramVector.size();
      if ((j == 0) || (!paramVector.elementAt(j - 1).equals(localMethod)))
        paramVector.addElement(localMethod);
    }
    while (true)
    {
      while (true)
      {
        return;
        if (paramClassType.isInterface())
          try
          {
            Class localClass = paramClassType.getReflectClass();
            if (localClass != null)
              localClassType = (ClassType)Type.make(Class.forName(paramClassType.getName() + "$class", false, localClass.getClassLoader()));
          }
          catch (Throwable localThrowable)
          {
            return;
          }
      }
      label152: ClassType[] arrayOfClassType = paramClassType.getInterfaces();
      for (int i = 0; i < arrayOfClassType.length; i++)
        getImplMethods(arrayOfClassType[i], paramString, paramArrayOfType, paramVector);
    }
  }

  static void invokeDefaultSuperConstructor(ClassType paramClassType, Compilation paramCompilation, LambdaExp paramLambdaExp)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Method localMethod = paramClassType.getDeclaredMethod("<init>", 0);
    if (localMethod == null)
    {
      paramCompilation.error('e', "super class does not have a default constructor");
      return;
    }
    localCodeAttr.emitPushThis();
    if ((paramClassType.hasOuterLink()) && ((paramLambdaExp instanceof ClassExp)))
    {
      ClassExp localClassExp = (ClassExp)paramLambdaExp;
      loadSuperStaticLink(localClassExp.supers[localClassExp.superClassIndex], paramClassType, paramCompilation);
    }
    localCodeAttr.emitInvokeSpecial(localMethod);
  }

  static void loadSuperStaticLink(Expression paramExpression, ClassType paramClassType, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    paramExpression.compile(paramCompilation, Target.pushValue(Compilation.typeClassType));
    localCodeAttr.emitInvokeStatic(ClassType.make("gnu.expr.PairClassType").getDeclaredMethod("extractStaticLink", 1));
    localCodeAttr.emitCheckcast(paramClassType.getOuterLinkType());
  }

  public static String slotToMethodName(String paramString1, String paramString2)
  {
    if (!Compilation.isValidJavaName(paramString2))
      paramString2 = Compilation.mangleName(paramString2, false);
    int i = paramString2.length();
    StringBuffer localStringBuffer = new StringBuffer(i + 3);
    localStringBuffer.append(paramString1);
    if (i > 0)
    {
      localStringBuffer.append(Character.toTitleCase(paramString2.charAt(0)));
      localStringBuffer.append(paramString2.substring(1));
    }
    return localStringBuffer.toString();
  }

  private static void usedSuperClasses(ClassType paramClassType, Compilation paramCompilation)
  {
    paramCompilation.usedClass(paramClassType.getSuperclass());
    ClassType[] arrayOfClassType = paramClassType.getInterfaces();
    if (arrayOfClassType != null)
    {
      int i = arrayOfClassType.length;
      while (true)
      {
        i--;
        if (i < 0)
          break;
        paramCompilation.usedClass(arrayOfClassType[i]);
      }
    }
  }

  public Declaration addMethod(LambdaExp paramLambdaExp, Object paramObject)
  {
    Declaration localDeclaration = addDeclaration(paramObject, Compilation.typeProcedure);
    paramLambdaExp.outer = this;
    paramLambdaExp.setClassMethod(true);
    localDeclaration.noteValue(paramLambdaExp);
    localDeclaration.setFlag(1048576L);
    localDeclaration.setProcedureDecl(true);
    paramLambdaExp.setSymbol(paramObject);
    return localDeclaration;
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    if ((paramTarget instanceof IgnoreTarget))
      return;
    compileMembers(paramCompilation);
    compilePushClass(paramCompilation, paramTarget);
  }

  public ClassType compileMembers(Compilation paramCompilation)
  {
    ClassType localClassType1 = paramCompilation.curClass;
    Method localMethod1 = paramCompilation.method;
    ClassType localClassType2;
    LambdaExp localLambdaExp2;
    while (true)
    {
      LambdaExp localLambdaExp3;
      ClassType localClassType5;
      try
      {
        localClassType2 = getCompiledClassType(paramCompilation);
        paramCompilation.curClass = localClassType2;
        LambdaExp localLambdaExp1 = outerLambda();
        Object localObject2;
        if ((localLambdaExp1 instanceof ClassExp))
        {
          localObject2 = localLambdaExp1.type;
          if (localObject2 != null)
          {
            localClassType2.setEnclosingMember((Member)localObject2);
            if ((localObject2 instanceof ClassType))
              ((ClassType)localObject2).addMemberClass(localClassType2);
          }
          if (this.instanceType != localClassType2)
          {
            this.instanceType.setEnclosingMember(this.type);
            this.type.addMemberClass(this.instanceType);
          }
          usedSuperClasses(this.type, paramCompilation);
          if (this.type != this.instanceType)
            usedSuperClasses(this.instanceType, paramCompilation);
          String str1 = getFileName();
          if (str1 != null)
            localClassType2.setSourceFile(str1);
          localLambdaExp2 = paramCompilation.curLambda;
          paramCompilation.curLambda = this;
          allocFrame(paramCompilation);
          localLambdaExp3 = this.firstChild;
          if (localLambdaExp3 == null)
            break;
          if (localLambdaExp3.isAbstract())
          {
            localLambdaExp3 = localLambdaExp3.nextSibling;
            continue;
          }
        }
        else
        {
          if ((localLambdaExp1 != null) && (!(localLambdaExp1 instanceof ModuleExp)))
          {
            localObject2 = localMethod1;
            continue;
          }
          boolean bool6 = localLambdaExp1 instanceof ModuleExp;
          localObject2 = null;
          if (!bool6)
            continue;
          int i1 = this.type.getName().indexOf('$');
          localObject2 = null;
          if (i1 <= 0)
            continue;
          localObject2 = localLambdaExp1.type;
          continue;
        }
        Method localMethod2 = paramCompilation.method;
        LambdaExp localLambdaExp4 = paramCompilation.curLambda;
        String str2 = paramCompilation.getFileName();
        int i = paramCompilation.getLineNumber();
        int j = paramCompilation.getColumnNumber();
        paramCompilation.setLine(localLambdaExp3);
        paramCompilation.method = localLambdaExp3.getMainMethod();
        Declaration localDeclaration = localLambdaExp3.nameDecl;
        if ((localDeclaration == null) || (!localDeclaration.getFlag(2048L)))
        {
          ClassType localClassType3 = paramCompilation.curClass;
          localLambdaExp3.declareThis(localClassType3);
        }
        paramCompilation.curClass = this.instanceType;
        paramCompilation.curLambda = localLambdaExp3;
        paramCompilation.method.initCode();
        localLambdaExp3.allocChildClasses(paramCompilation);
        localLambdaExp3.allocParameters(paramCompilation);
        if (!"*init*".equals(localLambdaExp3.getName()))
          break label788;
        CodeAttr localCodeAttr1 = paramCompilation.getCode();
        if (this.staticLinkField != null)
        {
          localCodeAttr1.emitPushThis();
          localCodeAttr1.emitLoad(localCodeAttr1.getCurrentScope().getVariable(1));
          localCodeAttr1.emitPutField(this.staticLinkField);
        }
        Expression localExpression1 = localLambdaExp3.body;
        if ((localExpression1 instanceof BeginExp))
        {
          BeginExp localBeginExp = (BeginExp)localExpression1;
          if (localBeginExp.length == 0)
          {
            localExpression1 = null;
            continue;
          }
          localExpression1 = localBeginExp.exps[0];
          continue;
        }
        boolean bool1 = localExpression1 instanceof ApplyExp;
        ClassType localClassType4 = null;
        if (bool1)
        {
          Expression localExpression2 = ((ApplyExp)localExpression1).func;
          boolean bool2 = localExpression2 instanceof QuoteExp;
          localClassType4 = null;
          if (bool2)
          {
            Object localObject3 = ((QuoteExp)localExpression2).getValue();
            boolean bool3 = localObject3 instanceof PrimProcedure;
            localClassType4 = null;
            if (bool3)
            {
              PrimProcedure localPrimProcedure = (PrimProcedure)localObject3;
              boolean bool4 = localPrimProcedure.isSpecial();
              localClassType4 = null;
              if (bool4)
              {
                boolean bool5 = "<init>".equals(localPrimProcedure.method.getName());
                localClassType4 = null;
                if (bool5)
                  localClassType4 = localPrimProcedure.method.getDeclaringClass();
              }
            }
          }
        }
        localClassType5 = this.instanceType.getSuperclass();
        if (localClassType4 != null)
        {
          Target localTarget = Target.Ignore;
          localExpression1.compileWithPosition(paramCompilation, localTarget);
          ClassType localClassType6 = this.instanceType;
          if ((localClassType4 != localClassType6) && (localClassType4 != localClassType5))
            paramCompilation.error('e', "call to <init> for not this or super class");
          localLambdaExp3.enterFunction(paramCompilation);
          ClassType localClassType7 = this.instanceType;
          if (localClassType4 != localClassType7)
            paramCompilation.callInitMethods(getCompiledClassType(paramCompilation), new Vector(10));
          if (localClassType4 == null)
            break label779;
          Expression.compileButFirst(localLambdaExp3.body, paramCompilation);
          localLambdaExp3.compileEnd(paramCompilation);
          localLambdaExp3.generateApplyMethods(paramCompilation);
          paramCompilation.method = localMethod2;
          paramCompilation.curClass = localClassType2;
          paramCompilation.curLambda = localLambdaExp4;
          paramCompilation.setLine(str2, i, j);
          continue;
        }
      }
      finally
      {
        paramCompilation.curClass = localClassType1;
        paramCompilation.method = localMethod1;
      }
      if (localClassType5 != null)
      {
        invokeDefaultSuperConstructor(localClassType5, paramCompilation, this);
        continue;
        label779: localLambdaExp3.compileBody(paramCompilation);
        continue;
        label788: localLambdaExp3.enterFunction(paramCompilation);
        localLambdaExp3.compileBody(paramCompilation);
      }
    }
    if ((!this.explicitInit) && (!this.instanceType.isInterface()))
      paramCompilation.generateConstructor(this.instanceType, this);
    int m;
    Method localMethod3;
    String str3;
    Type[] arrayOfType;
    Type localType1;
    while (isAbstract())
    {
      arrayOfMethod = null;
      k = 0;
      break label1348;
      if (m >= k)
        break label1324;
      localMethod3 = arrayOfMethod[m];
      str3 = localMethod3.getName();
      arrayOfType = localMethod3.getParameterTypes();
      localType1 = localMethod3.getReturnType();
      Method localMethod4 = this.instanceType.getMethod(str3, arrayOfType);
      if ((localMethod4 == null) || (localMethod4.isAbstract()))
        break label947;
      break label1354;
      if (this.initChain != null)
        this.initChain.reportError("unimplemented: explicit constructor cannot initialize ", paramCompilation);
    }
    Method[] arrayOfMethod = this.type.getAbstractMethods();
    int k = arrayOfMethod.length;
    break label1348;
    label947: if ((str3.length() > 3) && (str3.charAt(2) == 't') && (str3.charAt(1) == 'e'))
    {
      int n = str3.charAt(0);
      if ((n == 103) || (n == 115))
      {
        Type localType2;
        Field localField;
        CodeAttr localCodeAttr3;
        if ((n == 115) && (localType1.isVoid()) && (arrayOfType.length == 1))
        {
          localType2 = arrayOfType[0];
          String str5 = Character.toLowerCase(str3.charAt(3)) + str3.substring(4);
          localField = this.instanceType.getField(str5);
          if (localField == null)
            localField = this.instanceType.addField(str5, localType2, 1);
          localCodeAttr3 = this.instanceType.addMethod(str3, 1, arrayOfType, localType1).startCode();
          localCodeAttr3.emitPushThis();
          if (n != 103)
            break label1157;
          localCodeAttr3.emitGetField(localField);
        }
        while (true)
        {
          localCodeAttr3.emitReturn();
          break label1354;
          if ((n != 103) || (arrayOfType.length != 0))
            break label1354;
          localType2 = localType1;
          break;
          localCodeAttr3.emitLoad(localCodeAttr3.getArg(1));
          localCodeAttr3.emitPutField(localField);
        }
      }
    }
    label1157: Vector localVector = new Vector();
    getImplMethods(this.type, str3, arrayOfType, localVector);
    if (localVector.size() != 1)
      if (localVector.size() != 0)
        break label1360;
    label1324: label1348: label1354: label1360: for (String str4 = "missing implementation for "; ; str4 = "ambiguous implementation for ")
    {
      paramCompilation.error('e', str4 + localMethod3);
      break label1354;
      CodeAttr localCodeAttr2 = this.instanceType.addMethod(str3, 1, arrayOfType, localType1).startCode();
      for (Variable localVariable = localCodeAttr2.getCurrentScope().firstVar(); localVariable != null; localVariable = localVariable.nextVar())
        localCodeAttr2.emitLoad(localVariable);
      localCodeAttr2.emitInvokeStatic((Method)localVector.elementAt(0));
      localCodeAttr2.emitReturn();
      break label1354;
      generateApplyMethods(paramCompilation);
      paramCompilation.curLambda = localLambdaExp2;
      paramCompilation.curClass = localClassType1;
      paramCompilation.method = localMethod1;
      return localClassType2;
      m = 0;
      break;
      m++;
      break;
    }
  }

  public void compilePushClass(Compilation paramCompilation, Target paramTarget)
  {
    ClassType localClassType1 = this.type;
    CodeAttr localCodeAttr = paramCompilation.getCode();
    paramCompilation.loadClassRef(localClassType1);
    boolean bool = getNeedsClosureEnv();
    if ((isSimple()) && (!bool))
      return;
    ClassType localClassType2;
    int i;
    if ((isMakingClassPair()) || (bool))
      if (localClassType1 == this.instanceType)
      {
        localCodeAttr.emitDup(this.instanceType);
        localClassType2 = ClassType.make("gnu.expr.PairClassType");
        if (!bool)
          break label147;
        i = 3;
      }
    Type[] arrayOfType;
    while (true)
    {
      arrayOfType = new Type[i];
      if (bool)
      {
        getOwningLambda().loadHeapFrame(paramCompilation);
        i--;
        arrayOfType[i] = Type.pointer_type;
      }
      ClassType localClassType3 = ClassType.make("java.lang.Class");
      while (true)
      {
        i--;
        if (i < 0)
          break;
        arrayOfType[i] = localClassType3;
      }
      paramCompilation.loadClassRef(this.instanceType);
      break;
      label147: i = 2;
      continue;
      localClassType2 = ClassType.make("gnu.bytecode.Type");
      i = 1;
    }
    localCodeAttr.emitInvokeStatic(localClassType2.addMethod("make", arrayOfType, localClassType2, 9));
    paramTarget.compileFromStack(paramCompilation, localClassType2);
  }

  public Field compileSetField(Compilation paramCompilation)
  {
    return new ClassInitializer(this, paramCompilation).field;
  }

  public void declareParts(Compilation paramCompilation)
  {
    if (this.partsDeclared);
    label154: 
    do
    {
      return;
      this.partsDeclared = true;
      Hashtable localHashtable = new Hashtable();
      Declaration localDeclaration1 = firstDecl();
      if (localDeclaration1 != null)
      {
        int i;
        if (localDeclaration1.getCanRead())
        {
          i = localDeclaration1.getAccessFlags((short)1);
          if (localDeclaration1.getFlag(2048L))
            i |= 8;
          if (!isMakingClassPair())
            break label154;
          int j = i | 0x400;
          Type localType = localDeclaration1.getType().getImplementationType();
          this.type.addMethod(slotToMethodName("get", localDeclaration1.getName()), j, Type.typeArray0, localType);
          Type[] arrayOfType = { localType };
          this.type.addMethod(slotToMethodName("set", localDeclaration1.getName()), j, arrayOfType, Type.voidType);
        }
        while (true)
        {
          localDeclaration1 = localDeclaration1.nextDecl();
          break;
          String str = Compilation.mangleNameIfNeeded(localDeclaration1.getName());
          localDeclaration1.field = this.instanceType.addField(str, localDeclaration1.getType(), i);
          localDeclaration1.setSimple(false);
          Declaration localDeclaration2 = (Declaration)localHashtable.get(str);
          if (localDeclaration2 != null)
            duplicateDeclarationError(localDeclaration2, localDeclaration1, paramCompilation);
          localHashtable.put(str, localDeclaration1);
        }
      }
      for (LambdaExp localLambdaExp = this.firstChild; localLambdaExp != null; localLambdaExp = localLambdaExp.nextSibling)
      {
        if (localLambdaExp.isAbstract())
          setFlag(16384);
        if ("*init*".equals(localLambdaExp.getName()))
        {
          this.explicitInit = true;
          if (localLambdaExp.isAbstract())
            paramCompilation.error('e', "*init* method cannot be abstract", localLambdaExp);
          if ((this.type instanceof PairClassType))
            paramCompilation.error('e', "'*init*' methods only supported for simple classes");
        }
        localLambdaExp.outer = this;
        if (((localLambdaExp != this.initMethod) && (localLambdaExp != this.clinitMethod) && (localLambdaExp.nameDecl != null) && (!localLambdaExp.nameDecl.getFlag(2048L))) || (!isMakingClassPair()))
          localLambdaExp.addMethodFor(this.type, paramCompilation, null);
        if (isMakingClassPair())
          localLambdaExp.addMethodFor(this.instanceType, paramCompilation, this.type);
      }
      if ((!this.explicitInit) && (!this.instanceType.isInterface()))
        Compilation.getConstructor(this.instanceType, this);
      if (isAbstract())
        this.instanceType.setModifiers(0x400 | this.instanceType.getModifiers());
    }
    while (this.nameDecl == null);
    this.instanceType.setModifiers(0xFFFFFFFE & this.instanceType.getModifiers() | this.nameDecl.getAccessFlags((short)1));
  }

  public ClassType getClassType()
  {
    return this.type;
  }

  protected ClassType getCompiledClassType(Compilation paramCompilation)
  {
    return this.type;
  }

  public Type getType()
  {
    if (this.simple)
      return Compilation.typeClass;
    return Compilation.typeClassType;
  }

  public final boolean isAbstract()
  {
    return getFlag(16384);
  }

  public boolean isMakingClassPair()
  {
    return this.type != this.instanceType;
  }

  public boolean isSimple()
  {
    return this.simple;
  }

  protected boolean mustCompile()
  {
    return true;
  }

  public void print(OutPort paramOutPort)
  {
    paramOutPort.startLogicalBlock("(" + getExpClassName() + "/", ")", 2);
    Object localObject = getSymbol();
    if (localObject != null)
    {
      paramOutPort.print(localObject);
      paramOutPort.print('/');
    }
    paramOutPort.print(this.id);
    paramOutPort.print("/fl:");
    paramOutPort.print(Integer.toHexString(this.flags));
    if (this.supers.length > 0)
    {
      paramOutPort.writeSpaceFill();
      paramOutPort.startLogicalBlock("supers:", "", 2);
      for (int j = 0; j < this.supers.length; j++)
      {
        this.supers[j].print(paramOutPort);
        paramOutPort.writeSpaceFill();
      }
      paramOutPort.endLogicalBlock("");
    }
    paramOutPort.print('(');
    int i = 0;
    if (this.keywords == null);
    while (true)
    {
      for (Declaration localDeclaration = firstDecl(); localDeclaration != null; localDeclaration = localDeclaration.nextDecl())
      {
        if (i > 0)
          paramOutPort.print(' ');
        localDeclaration.printInfo(paramOutPort);
        i++;
      }
      this.keywords.length;
    }
    paramOutPort.print(") ");
    for (LambdaExp localLambdaExp = this.firstChild; localLambdaExp != null; localLambdaExp = localLambdaExp.nextSibling)
    {
      paramOutPort.writeBreakLinear();
      localLambdaExp.print(paramOutPort);
    }
    if (this.body != null)
    {
      paramOutPort.writeBreakLinear();
      this.body.print(paramOutPort);
    }
    paramOutPort.endLogicalBlock(")");
  }

  public void setSimple(boolean paramBoolean)
  {
    this.simple = paramBoolean;
  }

  public void setTypes(Compilation paramCompilation)
  {
    int i;
    ClassType[] arrayOfClassType1;
    Object localObject1;
    int j;
    int k;
    label23: Type localType;
    int i12;
    if (this.supers == null)
    {
      i = 0;
      arrayOfClassType1 = new ClassType[i];
      localObject1 = null;
      j = 0;
      k = 0;
      if (j >= i)
        break label232;
      localType = Language.getDefaultLanguage().getTypeFor(this.supers[j]);
      if ((localType instanceof ClassType))
        break label95;
      paramCompilation.setLine(this.supers[j]);
      paramCompilation.error('e', "invalid super type");
      i12 = k;
    }
    while (true)
    {
      j++;
      k = i12;
      break label23;
      i = this.supers.length;
      break;
      label95: ClassType localClassType2 = (ClassType)localType;
      try
      {
        int i13 = localClassType2.getModifiers();
        i11 = i13;
        if ((0x200 & i11) == 0)
        {
          if (k < j)
            paramCompilation.error('e', "duplicate superclass for " + this);
          localObject1 = localClassType2;
          this.superClassIndex = j;
          i12 = k;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        while (true)
        {
          int i11 = 0;
          if (paramCompilation != null)
          {
            paramCompilation.error('e', "unknown super-type " + localClassType2.getName());
            i11 = 0;
          }
        }
        i12 = k + 1;
        arrayOfClassType1[k] = localClassType2;
      }
    }
    label232: if ((localObject1 != null) && ((0x8000 & this.flags) != 0))
      paramCompilation.error('e', "cannot be interface since has superclass");
    Object localObject2;
    label383: ClassType[] arrayOfClassType2;
    label399: String str1;
    label431: StringBuffer localStringBuffer1;
    int i2;
    int i3;
    label487: String str2;
    if ((!this.simple) && (localObject1 == null) && ((0x10000 & this.flags) == 0) && ((getFlag(131072)) || ((this.nameDecl != null) && (this.nameDecl.isPublic()))))
    {
      PairClassType localPairClassType = new PairClassType();
      this.type = localPairClassType;
      localPairClassType.setInterface(true);
      localPairClassType.instanceType = this.instanceType;
      ClassType[] arrayOfClassType3 = new ClassType[1];
      arrayOfClassType3[0] = this.type;
      this.instanceType.setSuper(Type.pointer_type);
      this.instanceType.setInterfaces(arrayOfClassType3);
      ClassType localClassType1 = this.type;
      if (localObject1 != null)
        break label596;
      localObject2 = Type.pointer_type;
      localClassType1.setSuper((ClassType)localObject2);
      if (k != i)
        break label603;
      arrayOfClassType2 = arrayOfClassType1;
      this.type.setInterfaces(arrayOfClassType2);
      if (this.type.getName() == null)
      {
        if (this.classNameSpecifier == null)
          break label623;
        str1 = this.classNameSpecifier;
        if (str1 != null)
          break label708;
        localStringBuffer1 = new StringBuffer(100);
        paramCompilation.getModule().classFor(paramCompilation);
        localStringBuffer1.append(paramCompilation.mainClass.getName());
        localStringBuffer1.append('$');
        i2 = localStringBuffer1.length();
        i3 = 0;
        localStringBuffer1.append(i3);
        str2 = localStringBuffer1.toString();
        if (paramCompilation.findNamedClass(str2) != null)
          break label695;
      }
    }
    while (true)
    {
      this.type.setName(str2);
      paramCompilation.addClass(this.type);
      if (isMakingClassPair())
      {
        this.instanceType.setName(this.type.getName() + "$class");
        paramCompilation.addClass(this.instanceType);
      }
      return;
      if (!getFlag(32768))
        break;
      this.instanceType.setInterface(true);
      break;
      label596: localObject2 = localObject1;
      break label383;
      label603: arrayOfClassType2 = new ClassType[k];
      System.arraycopy(arrayOfClassType1, 0, arrayOfClassType2, 0, k);
      break label399;
      label623: str1 = getName();
      if (str1 == null)
        break label431;
      int m = str1.length();
      if ((m <= 2) || (str1.charAt(0) != '<'))
        break label431;
      int n = m - 1;
      if (str1.charAt(n) != '>')
        break label431;
      int i1 = m - 1;
      str1 = str1.substring(1, i1);
      break label431;
      label695: localStringBuffer1.setLength(i2);
      i3++;
      break label487;
      label708: if ((isSimple()) && (!(this instanceof ObjectExp)))
        break label733;
      str2 = paramCompilation.generateClassName(str1);
    }
    label733: int i4 = 0;
    StringBuffer localStringBuffer2 = new StringBuffer(100);
    label747: int i5 = str1.indexOf('.', i4);
    String str3;
    label778: int i9;
    if (i5 < 0)
    {
      if (i4 != 0)
        break label944;
      if (paramCompilation.mainClass != null)
        break label900;
      str3 = null;
      if (str3 != null)
        break label912;
      i9 = -1;
      label786: if (i9 <= 0)
        break label924;
      int i10 = i9 + 1;
      localStringBuffer2.append(str3.substring(0, i10));
    }
    while (true)
    {
      int i8 = str1.length();
      if (i4 < i8)
        localStringBuffer2.append(Compilation.mangleNameIfNeeded(str1.substring(i4)));
      str2 = localStringBuffer2.toString();
      break;
      localStringBuffer2.append(Compilation.mangleNameIfNeeded(str1.substring(i4, i5)));
      i4 = i5 + 1;
      int i6 = str1.length();
      if (i4 >= i6)
        break label747;
      localStringBuffer2.append('.');
      break label747;
      label900: str3 = paramCompilation.mainClass.getName();
      break label778;
      label912: i9 = str3.lastIndexOf('.');
      break label786;
      label924: if (paramCompilation.classPrefix != null)
      {
        localStringBuffer2.append(paramCompilation.classPrefix);
        continue;
        label944: if (i4 == 1)
        {
          int i7 = str1.length();
          if (i4 < i7)
          {
            localStringBuffer2.setLength(0);
            localStringBuffer2.append(paramCompilation.mainClass.getName());
            localStringBuffer2.append('$');
          }
        }
      }
    }
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    Compilation localCompilation = paramExpVisitor.getCompilation();
    if (localCompilation == null)
      return paramExpVisitor.visitClassExp(this, paramD);
    ClassType localClassType = localCompilation.curClass;
    try
    {
      localCompilation.curClass = this.type;
      Object localObject2 = paramExpVisitor.visitClassExp(this, paramD);
      return localObject2;
    }
    finally
    {
      localCompilation.curClass = localClassType;
    }
  }

  protected <R, D> void visitChildren(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    LambdaExp localLambdaExp1 = paramExpVisitor.currentLambda;
    paramExpVisitor.currentLambda = this;
    this.supers = paramExpVisitor.visitExps(this.supers, this.supers.length, paramD);
    try
    {
      for (LambdaExp localLambdaExp2 = this.firstChild; (localLambdaExp2 != null) && (paramExpVisitor.exitValue == null); localLambdaExp2 = localLambdaExp2.nextSibling)
      {
        if (this.instanceType != null)
        {
          Declaration localDeclaration = localLambdaExp2.firstDecl();
          if ((localDeclaration != null) && (localDeclaration.isThisParameter()))
            localDeclaration.setType(this.type);
        }
        paramExpVisitor.visitLambdaExp(localLambdaExp2, paramD);
      }
      return;
    }
    finally
    {
      paramExpVisitor.currentLambda = localLambdaExp1;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ClassExp
 * JD-Core Version:    0.6.2
 */