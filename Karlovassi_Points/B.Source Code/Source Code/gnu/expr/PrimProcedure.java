package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassFileInput;
import gnu.bytecode.ClassType;
import gnu.bytecode.ClassTypeWriter;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.functions.MakeList;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.ConsumerWriter;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongArguments;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.net.URL;

public class PrimProcedure extends MethodProc
  implements Inlineable
{
  private static ClassLoader systemClassLoader = PrimProcedure.class.getClassLoader();
  Type[] argTypes;
  Member member;
  gnu.bytecode.Method method;
  char mode;
  int op_code;
  Type retType;
  boolean sideEffectFree;
  LambdaExp source;

  public PrimProcedure(int paramInt, ClassType paramClassType, String paramString, Type paramType, Type[] paramArrayOfType)
  {
    this.op_code = paramInt;
    int i;
    if (paramInt == 184)
    {
      i = 8;
      this.method = paramClassType.addMethod(paramString, i, paramArrayOfType, paramType);
      this.retType = paramType;
      this.argTypes = paramArrayOfType;
      if (paramInt != 184)
        break label70;
    }
    label70: for (char c = '\000'; ; c = 'V')
    {
      this.mode = c;
      return;
      i = 0;
      break;
    }
  }

  public PrimProcedure(int paramInt, Type paramType, Type[] paramArrayOfType)
  {
    this.op_code = paramInt;
    this.retType = paramType;
    this.argTypes = paramArrayOfType;
  }

  public PrimProcedure(gnu.bytecode.Method paramMethod)
  {
    init(paramMethod);
    if (paramMethod.getName().endsWith("$X"));
    for (Object localObject = Type.objectType; ; localObject = paramMethod.getReturnType())
    {
      this.retType = ((Type)localObject);
      return;
    }
  }

  public PrimProcedure(gnu.bytecode.Method paramMethod, char paramChar, Language paramLanguage)
  {
    this.mode = paramChar;
    init(paramMethod);
    Type[] arrayOfType = this.argTypes;
    int i = arrayOfType.length;
    this.argTypes = null;
    int j = i;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      Type localType1 = arrayOfType[j];
      Type localType2 = paramLanguage.getLangTypeFor(localType1);
      if (localType1 != localType2)
      {
        if (this.argTypes == null)
        {
          this.argTypes = new Type[i];
          System.arraycopy(arrayOfType, 0, this.argTypes, 0, i);
        }
        this.argTypes[j] = localType2;
      }
    }
    if (this.argTypes == null)
      this.argTypes = arrayOfType;
    if (isConstructor())
      this.retType = paramMethod.getDeclaringClass();
    do
    {
      return;
      if (paramMethod.getName().endsWith("$X"))
      {
        this.retType = Type.objectType;
        return;
      }
      this.retType = paramLanguage.getLangTypeFor(paramMethod.getReturnType());
    }
    while (this.retType != Type.toStringType);
    this.retType = Type.javalangStringType;
  }

  public PrimProcedure(gnu.bytecode.Method paramMethod, LambdaExp paramLambdaExp)
  {
    this(paramMethod);
    this.retType = paramLambdaExp.getReturnType();
    this.source = paramLambdaExp;
  }

  public PrimProcedure(gnu.bytecode.Method paramMethod, Language paramLanguage)
  {
    this(paramMethod, '\000', paramLanguage);
  }

  public PrimProcedure(String paramString1, String paramString2, int paramInt)
  {
    this(ClassType.make(paramString1).getDeclaredMethod(paramString2, paramInt));
  }

  public PrimProcedure(java.lang.reflect.Method paramMethod, Language paramLanguage)
  {
    this(((ClassType)paramLanguage.getTypeFor(paramMethod.getDeclaringClass())).getMethod(paramMethod), paramLanguage);
  }

  private void compileArgs(Expression[] paramArrayOfExpression, int paramInt, Type paramType, Compilation paramCompilation)
  {
    boolean bool1 = takesVarArgs();
    String str = getName();
    Type localType1 = null;
    CodeAttr localCodeAttr = paramCompilation.getCode();
    int i;
    int k;
    int m;
    label70: int n;
    int i8;
    label130: int i5;
    label257: int i1;
    label264: Declaration localDeclaration;
    label274: int i2;
    if (paramType == Type.voidType)
    {
      i = 1;
      int j = this.argTypes.length - i;
      if (takesContext())
        j--;
      k = paramArrayOfExpression.length - paramInt;
      if ((paramType != null) && (i == 0))
        break label356;
      m = 1;
      n = 0;
      if (bool1)
      {
        int i6 = 0x80 & this.method.getModifiers();
        n = 0;
        if (i6 != 0)
        {
          n = 0;
          if (k > 0)
          {
            int i7 = this.argTypes.length;
            n = 0;
            if (i7 > 0)
            {
              if (m == 0)
                break label362;
              i8 = 0;
              int i9 = i8 + j;
              n = 0;
              if (k == i9)
              {
                Type localType4 = paramArrayOfExpression[(paramArrayOfExpression.length - 1)].getType();
                Type localType5 = this.argTypes[(this.argTypes.length - 1)];
                boolean bool2 = localType4 instanceof ObjectType;
                n = 0;
                if (bool2)
                {
                  boolean bool3 = localType5 instanceof ArrayType;
                  n = 0;
                  if (bool3)
                  {
                    boolean bool4 = ((ArrayType)localType5).getComponentType() instanceof ArrayType;
                    n = 0;
                    if (!bool4)
                    {
                      boolean bool5 = localType4 instanceof ArrayType;
                      n = 0;
                      if (!bool5)
                        n = 1;
                      bool1 = false;
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (!bool1)
        break label374;
      if (m == 0)
        break label368;
      i5 = 1;
      i1 = j - i5;
      if (this.source != null)
        break label383;
      localDeclaration = null;
      if ((localDeclaration != null) && (localDeclaration.isThisParameter()))
        localDeclaration = localDeclaration.nextDecl();
      i2 = 0;
      if ((!bool1) || (i2 != i1))
        break label424;
      localType3 = this.argTypes[(i + (j - 1))];
      if ((localType3 != Compilation.scmListType) && (localType3 != LangObjType.listType))
        break label395;
      MakeList.compile(paramArrayOfExpression, paramInt + i2, paramCompilation);
    }
    label356: label362: label368: label374: label383: 
    while (i2 >= k)
    {
      Type localType3;
      return;
      i = 0;
      break;
      m = 0;
      break label70;
      i8 = 1;
      break label130;
      i5 = 0;
      break label257;
      i1 = paramArrayOfExpression.length - paramInt;
      break label264;
      localDeclaration = this.source.firstDecl();
      break label274;
      localCodeAttr.emitPushInt(paramArrayOfExpression.length - paramInt - i1);
      localType1 = ((ArrayType)localType3).getComponentType();
      localCodeAttr.emitNewArray(localType1);
    }
    label395: label424: int i3;
    label448: Object localObject;
    label488: int i4;
    if ((n != 0) && (i2 + 1 == k))
    {
      i3 = 1;
      if (i2 < i1)
        break label684;
      localCodeAttr.emitDup(1);
      localCodeAttr.emitPushInt(i2 - i1);
      paramCompilation.usedClass(localType1);
      if (i3 == 0)
        break label754;
      localObject = Type.objectType;
      if (this.source != null)
        break label761;
      i4 = i2 + 1;
    }
    label684: label754: label761: LambdaExp localLambdaExp;
    for (Target localTarget = CheckedTarget.getInstance((Type)localObject, str, i4); ; localTarget = CheckedTarget.getInstance((Type)localObject, localLambdaExp, i2))
    {
      Expression localExpression1 = paramArrayOfExpression[(paramInt + i2)];
      Expression localExpression2 = paramArrayOfExpression[(paramInt + i2)];
      localExpression1.compileNotePosition(paramCompilation, localTarget, localExpression2);
      if (i3 != 0)
      {
        Type localType2 = ((ArrayType)localType1).getComponentType();
        localCodeAttr.emitDup();
        localCodeAttr.emitInstanceof(localType1);
        localCodeAttr.emitIfIntNotZero();
        localCodeAttr.emitCheckcast(localType1);
        localCodeAttr.emitElse();
        localCodeAttr.emitPushInt(1);
        localCodeAttr.emitNewArray(localType2);
        localCodeAttr.emitDupX();
        localCodeAttr.emitSwap();
        localCodeAttr.emitPushInt(0);
        localCodeAttr.emitSwap();
        localType2.emitCoerceFromObject(localCodeAttr);
        localCodeAttr.emitArrayStore(localType1);
        localCodeAttr.emitFi();
      }
      if (i2 >= i1)
        localCodeAttr.emitArrayStore(localType1);
      if ((localDeclaration != null) && ((m != 0) || (i2 > 0)))
        localDeclaration = localDeclaration.nextDecl();
      i2++;
      break;
      i3 = 0;
      break label448;
      if ((localDeclaration != null) && ((m != 0) || (i2 > 0)))
        localType1 = localDeclaration.getType();
      while (true)
      {
        break;
        if (m != 0)
          localType1 = this.argTypes[(i2 + i)];
        else if (i2 == 0)
          localType1 = paramType;
        else
          localType1 = this.argTypes[(i2 - 1)];
      }
      localObject = localType1;
      break label488;
      localLambdaExp = this.source;
    }
  }

  public static void compileInvoke(Compilation paramCompilation, gnu.bytecode.Method paramMethod, Target paramTarget, boolean paramBoolean, int paramInt, Type paramType)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    paramCompilation.usedClass(paramMethod.getDeclaringClass());
    paramCompilation.usedClass(paramMethod.getReturnType());
    if (!takesContext(paramMethod))
      localCodeAttr.emitInvokeMethod(paramMethod, paramInt);
    while (true)
    {
      paramTarget.compileFromStack(paramCompilation, paramType);
      Field localField;
      Variable localVariable1;
      do
      {
        return;
        if ((!(paramTarget instanceof IgnoreTarget)) && ((!(paramTarget instanceof ConsumerTarget)) || (!((ConsumerTarget)paramTarget).isContextTarget())))
          break;
        paramCompilation.loadCallContext();
        boolean bool = paramTarget instanceof IgnoreTarget;
        localField = null;
        localVariable1 = null;
        if (bool)
        {
          ClassType localClassType = Compilation.typeCallContext;
          localField = localClassType.getDeclaredField("consumer");
          localCodeAttr.pushScope();
          localVariable1 = localCodeAttr.addLocal(localClassType);
          localCodeAttr.emitDup();
          localCodeAttr.emitGetField(localField);
          localCodeAttr.emitStore(localVariable1);
          localCodeAttr.emitDup();
          localCodeAttr.emitGetStatic(ClassType.make("gnu.lists.VoidConsumer").getDeclaredField("instance"));
          localCodeAttr.emitPutField(localField);
        }
        localCodeAttr.emitInvokeMethod(paramMethod, paramInt);
        if (paramBoolean)
        {
          paramCompilation.loadCallContext();
          localCodeAttr.emitInvoke(Compilation.typeCallContext.getDeclaredMethod("runUntilDone", 0));
        }
      }
      while (!(paramTarget instanceof IgnoreTarget));
      paramCompilation.loadCallContext();
      localCodeAttr.emitLoad(localVariable1);
      localCodeAttr.emitPutField(localField);
      localCodeAttr.popScope();
      return;
      paramCompilation.loadCallContext();
      paramType = Type.objectType;
      localCodeAttr.pushScope();
      Variable localVariable2 = localCodeAttr.addLocal(Type.intType);
      paramCompilation.loadCallContext();
      localCodeAttr.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("startFromContext", 0));
      localCodeAttr.emitStore(localVariable2);
      localCodeAttr.emitWithCleanupStart();
      localCodeAttr.emitInvokeMethod(paramMethod, paramInt);
      localCodeAttr.emitWithCleanupCatch(null);
      paramCompilation.loadCallContext();
      localCodeAttr.emitLoad(localVariable2);
      localCodeAttr.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("cleanupFromContext", 1));
      localCodeAttr.emitWithCleanupDone();
      paramCompilation.loadCallContext();
      localCodeAttr.emitLoad(localVariable2);
      localCodeAttr.emitInvokeVirtual(Compilation.typeCallContext.getDeclaredMethod("getFromContext", 1));
      localCodeAttr.popScope();
    }
  }

  public static void disassemble(Procedure paramProcedure, ClassTypeWriter paramClassTypeWriter)
    throws Exception
  {
    if ((paramProcedure instanceof GenericProc))
    {
      GenericProc localGenericProc = (GenericProc)paramProcedure;
      int i = localGenericProc.getMethodCount();
      paramClassTypeWriter.print("Generic procedure with ");
      paramClassTypeWriter.print(i);
      if (i == 1);
      for (String str6 = " method."; ; str6 = "methods.")
      {
        paramClassTypeWriter.println(str6);
        for (int j = 0; j < i; j++)
        {
          MethodProc localMethodProc = localGenericProc.getMethod(j);
          if (localMethodProc != null)
          {
            paramClassTypeWriter.println();
            disassemble(localMethodProc, paramClassTypeWriter);
          }
        }
      }
    }
    Class localClass = paramProcedure.getClass();
    String str1;
    if ((paramProcedure instanceof ModuleMethod))
    {
      localClass = ((ModuleMethod)paramProcedure).module.getClass();
      str1 = null;
    }
    while (true)
    {
      ClassLoader localClassLoader = localClass.getClassLoader();
      String str2 = localClass.getName();
      String str3 = str2.replace('.', '/') + ".class";
      ClassType localClassType = new ClassType();
      InputStream localInputStream = localClassLoader.getResourceAsStream(str3);
      if (localInputStream == null)
      {
        throw new RuntimeException("missing resource " + str3);
        if ((paramProcedure instanceof PrimProcedure))
        {
          gnu.bytecode.Method localMethod2 = ((PrimProcedure)paramProcedure).method;
          if (localMethod2 != null)
          {
            localClass = localMethod2.getDeclaringClass().getReflectClass();
            str1 = localMethod2.getName();
          }
        }
      }
      else
      {
        new ClassFileInput(localClassType, localInputStream);
        paramClassTypeWriter.setClass(localClassType);
        URL localURL = localClassLoader.getResource(str3);
        paramClassTypeWriter.print("In class ");
        paramClassTypeWriter.print(str2);
        if (localURL != null)
        {
          paramClassTypeWriter.print(" at ");
          paramClassTypeWriter.print(localURL);
        }
        paramClassTypeWriter.println();
        String str5;
        if (str1 == null)
        {
          str5 = paramProcedure.getName();
          if (str5 == null)
          {
            paramClassTypeWriter.println("Anonymous function - unknown method.");
            return;
          }
        }
        for (String str4 = Compilation.mangleName(str5); ; str4 = str1)
        {
          for (gnu.bytecode.Method localMethod1 = localClassType.getMethods(); localMethod1 != null; localMethod1 = localMethod1.getNext())
            if (localMethod1.getName().equals(str4))
              paramClassTypeWriter.printMethod(localMethod1);
          paramClassTypeWriter.flush();
          return;
        }
        str1 = null;
      }
    }
  }

  public static void disassemble(Procedure paramProcedure, Writer paramWriter)
    throws Exception
  {
    disassemble(paramProcedure, new ClassTypeWriter(null, paramWriter, 0));
  }

  public static void disassemble$X(Procedure paramProcedure, CallContext paramCallContext)
    throws Exception
  {
    Consumer localConsumer = paramCallContext.consumer;
    if ((localConsumer instanceof Writer));
    for (Object localObject = (Writer)localConsumer; ; localObject = new ConsumerWriter(localConsumer))
    {
      disassemble(paramProcedure, (Writer)localObject);
      return;
    }
  }

  public static PrimProcedure getMethodFor(ClassType paramClassType, String paramString, Declaration paramDeclaration, Type[] paramArrayOfType, Language paramLanguage)
  {
    if (paramString == null)
      return null;
    label390: label394: 
    while (true)
    {
      int i;
      Object localObject2;
      int j;
      int k;
      label191: int n;
      int m;
      try
      {
        str1 = Compilation.mangleName(paramString);
        str2 = str1 + "$V";
        str3 = str1 + "$V$X";
        str4 = str1 + "$X";
        gnu.bytecode.Method localMethod1 = paramClassType.getDeclaredMethods();
        localMethod2 = localMethod1;
        i = 1;
        localObject2 = null;
        j = -1;
        k = 0;
        if (localMethod2 == null);
      }
      catch (SecurityException localSecurityException1)
      {
        try
        {
          String str1;
          String str2;
          String str3;
          String str4;
          gnu.bytecode.Method localMethod2;
          if (((0x9 & localMethod2.getModifiers()) != 9) && ((paramDeclaration == null) || (paramDeclaration.base == null)))
          {
            localMethod2 = localMethod2.getNext();
            continue;
          }
          String str5 = localMethod2.getName();
          if ((!str5.equals(str1)) && (!str5.equals(str2)) && (!str5.equals(str4)))
          {
            PrimProcedure localPrimProcedure;
            if (str5.equals(str3))
            {
              continue;
              localPrimProcedure = new PrimProcedure(localMethod2, paramLanguage);
              localPrimProcedure.setName(paramString);
              n = localPrimProcedure.isApplicable(paramArrayOfType);
              if ((n < 0) || (n < j))
                continue;
              if (n <= j)
                continue;
              localObject2 = localPrimProcedure;
              break label379;
            }
            if (i == 0)
              continue;
            if (str5.equals("apply"))
              break label390;
            if (!str5.equals("apply$V"))
              continue;
            break label390;
            if (localObject2 == null)
              break label379;
            localObject2 = (PrimProcedure)MethodProc.mostSpecific((MethodProc)localObject2, localPrimProcedure);
            if ((localObject2 != null) || (j <= 0))
              break label379;
            return null;
            localObject1 = localObject2;
            return localObject1;
            localSecurityException1 = localSecurityException1;
            localObject1 = null;
            continue;
          }
        }
        catch (SecurityException localSecurityException2)
        {
          Object localObject1 = localObject2;
          continue;
          m = 0;
        }
      }
      while (true)
      {
        if (m != 0)
          break label394;
        i = 0;
        if (k == 0)
          break label191;
        j = -1;
        localObject2 = null;
        k = 0;
        i = 0;
        break label191;
        label379: j = n;
        k = m;
        break;
        m = 1;
      }
    }
  }

  public static PrimProcedure getMethodFor(ClassType paramClassType, String paramString, Declaration paramDeclaration, Expression[] paramArrayOfExpression, Language paramLanguage)
  {
    int i = paramArrayOfExpression.length;
    Type[] arrayOfType = new Type[i];
    int j = i;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      arrayOfType[j] = paramArrayOfExpression[j].getType();
    }
    return getMethodFor(paramClassType, paramString, paramDeclaration, arrayOfType, paramLanguage);
  }

  public static PrimProcedure getMethodFor(Procedure paramProcedure, Declaration paramDeclaration, Type[] paramArrayOfType, Language paramLanguage)
  {
    if ((paramProcedure instanceof GenericProc))
    {
      GenericProc localGenericProc = (GenericProc)paramProcedure;
      MethodProc[] arrayOfMethodProc = localGenericProc.methods;
      paramProcedure = null;
      int i = localGenericProc.count;
      while (true)
      {
        i--;
        if (i < 0)
          break;
        if (arrayOfMethodProc[i].isApplicable(paramArrayOfType) >= 0)
        {
          if (paramProcedure != null)
            return null;
          paramProcedure = arrayOfMethodProc[i];
        }
      }
      if (paramProcedure == null)
        return null;
    }
    if ((paramProcedure instanceof PrimProcedure))
    {
      PrimProcedure localPrimProcedure = (PrimProcedure)paramProcedure;
      if (localPrimProcedure.isApplicable(paramArrayOfType) >= 0)
        return localPrimProcedure;
    }
    Class localClass = getProcedureClass(paramProcedure);
    if (localClass == null)
      return null;
    return getMethodFor((ClassType)Type.make(localClass), paramProcedure.getName(), paramDeclaration, paramArrayOfType, paramLanguage);
  }

  public static PrimProcedure getMethodFor(Procedure paramProcedure, Declaration paramDeclaration, Expression[] paramArrayOfExpression, Language paramLanguage)
  {
    int i = paramArrayOfExpression.length;
    Type[] arrayOfType = new Type[i];
    int j = i;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      arrayOfType[j] = paramArrayOfExpression[j].getType();
    }
    return getMethodFor(paramProcedure, paramDeclaration, arrayOfType, paramLanguage);
  }

  public static PrimProcedure getMethodFor(Procedure paramProcedure, Expression[] paramArrayOfExpression)
  {
    return getMethodFor(paramProcedure, null, paramArrayOfExpression, Language.getDefaultLanguage());
  }

  public static PrimProcedure getMethodFor(Class paramClass, String paramString, Declaration paramDeclaration, Expression[] paramArrayOfExpression, Language paramLanguage)
  {
    return getMethodFor((ClassType)Type.make(paramClass), paramString, paramDeclaration, paramArrayOfExpression, paramLanguage);
  }

  public static Class getProcedureClass(Object paramObject)
  {
    Class localClass;
    if ((paramObject instanceof ModuleMethod))
      localClass = ((ModuleMethod)paramObject).module.getClass();
    try
    {
      while (true)
      {
        ClassLoader localClassLoader1 = localClass.getClassLoader();
        ClassLoader localClassLoader2 = systemClassLoader;
        if (localClassLoader1 != localClassLoader2)
          break;
        return localClass;
        localClass = paramObject.getClass();
      }
    }
    catch (SecurityException localSecurityException)
    {
    }
    return null;
  }

  private void init(gnu.bytecode.Method paramMethod)
  {
    this.method = paramMethod;
    if ((0x8 & paramMethod.getModifiers()) != 0)
      this.op_code = 184;
    while (true)
    {
      Object localObject = paramMethod.getParameterTypes();
      if ((isConstructor()) && (paramMethod.getDeclaringClass().hasOuterLink()))
      {
        int i = localObject.length - 1;
        Type[] arrayOfType = new Type[i];
        System.arraycopy(localObject, 1, arrayOfType, 0, i);
        localObject = arrayOfType;
      }
      this.argTypes = ((Type[])localObject);
      return;
      ClassType localClassType = paramMethod.getDeclaringClass();
      if (this.mode == 'P')
      {
        this.op_code = 183;
      }
      else
      {
        this.mode = 'V';
        if ("<init>".equals(paramMethod.getName()))
          this.op_code = 183;
        else if ((0x200 & localClassType.getModifiers()) != 0)
          this.op_code = 185;
        else
          this.op_code = 182;
      }
    }
  }

  public static PrimProcedure makeBuiltinBinary(int paramInt, Type paramType)
  {
    return new PrimProcedure(paramInt, paramType, new Type[] { paramType, paramType });
  }

  public static PrimProcedure makeBuiltinUnary(int paramInt, Type paramType)
  {
    return new PrimProcedure(paramInt, paramType, new Type[] { paramType });
  }

  public static boolean takesContext(gnu.bytecode.Method paramMethod)
  {
    return paramMethod.getName().endsWith("$X");
  }

  public void apply(CallContext paramCallContext)
    throws Throwable
  {
    int i = this.argTypes.length;
    boolean bool = isConstructor();
    int j;
    if ((bool) && (this.method.getDeclaringClass().hasOuterLink()))
      j = 1;
    while (true)
    {
      Class localClass2;
      Class[] arrayOfClass;
      int i2;
      try
      {
        if (this.member != null)
          break label157;
        localClass2 = this.method.getDeclaringClass().getReflectClass();
        if (j == 0)
          break label108;
        i1 = 1;
        arrayOfClass = new Class[i1 + i];
        i2 = i;
        break label375;
        arrayOfClass[(i3 + i2)] = this.argTypes[i2].getReflectClass();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw localInvocationTargetException.getTargetException();
      }
      j = 0;
      continue;
      label108: int i1 = 0;
      continue;
      label157: label285: label375: 
      do
      {
        i3 = 0;
        break;
        do
        {
          if (j != 0)
            arrayOfClass[0] = this.method.getDeclaringClass().getOuterLinkType().getReflectClass();
          Object localObject2;
          if (bool)
          {
            this.member = localClass2.getConstructor(arrayOfClass);
            if (!bool)
              break label285;
            Object localObject1 = paramCallContext.values;
            if (j != 0)
            {
              int k = 1 + localObject1.length;
              Object[] arrayOfObject = new Object[k];
              int m = k - 1;
              System.arraycopy(localObject1, 0, arrayOfObject, 1, m);
              arrayOfObject[0] = ((PairClassType)paramCallContext.value1).staticLink;
              localObject1 = arrayOfObject;
            }
            localObject2 = ((Constructor)this.member).newInstance((Object[])localObject1);
          }
          while (true)
          {
            if (takesContext())
              return;
            paramCallContext.consumer.writeObject(localObject2);
            return;
            if (this.method == Type.clone_method)
              break;
            this.member = localClass2.getMethod(this.method.getName(), arrayOfClass);
            break;
            if (this.method == Type.clone_method)
            {
              Object localObject4 = paramCallContext.value1;
              Class localClass1 = localObject4.getClass().getComponentType();
              int n = Array.getLength(localObject4);
              localObject2 = Array.newInstance(localClass1, n);
              System.arraycopy(localObject4, 0, localObject2, 0, n);
            }
            else
            {
              Object localObject3 = this.retType.coerceToObject(((java.lang.reflect.Method)this.member).invoke(paramCallContext.value1, paramCallContext.values));
              localObject2 = localObject3;
            }
          }
          i2--;
        }
        while (i2 < 0);
      }
      while (j == 0);
      int i3 = 1;
    }
  }

  void compile(Type paramType, ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Type localType = this.retType;
    ClassType localClassType2;
    int i;
    if (isConstructor())
      if (this.method == null)
      {
        localClassType2 = null;
        if (localClassType2.hasOuterLink())
          ClassExp.loadSuperStaticLink(arrayOfExpression[0], localClassType2, paramCompilation);
        paramType = null;
        i = 1;
      }
    while (true)
    {
      compileArgs(arrayOfExpression, i, paramType, paramCompilation);
      if (this.method != null)
        break label248;
      localCodeAttr.emitPrimop(opcode(), arrayOfExpression.length, this.retType);
      paramTarget.compileFromStack(paramCompilation, localType);
      return;
      localClassType2 = this.method.getDeclaringClass();
      break;
      if ((opcode() == 183) && (this.mode == 'P') && ("<init>".equals(this.method.getName())))
      {
        if (this.method == null);
        for (ClassType localClassType1 = null; ; localClassType1 = this.method.getDeclaringClass())
        {
          boolean bool3 = localClassType1.hasOuterLink();
          i = 0;
          if (!bool3)
            break;
          localCodeAttr.emitPushThis();
          localCodeAttr.emitLoad(localCodeAttr.getCurrentScope().getVariable(1));
          i = 1;
          paramType = null;
          break;
        }
      }
      boolean bool1 = takesTarget();
      i = 0;
      if (bool1)
      {
        boolean bool2 = this.method.getStaticFlag();
        i = 0;
        if (bool2)
          i = 1;
      }
    }
    label248: compileInvoke(paramCompilation, this.method, paramTarget, paramApplyExp.isTailCall(), this.op_code, localType);
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (this.method == null);
    Expression[] arrayOfExpression1;
    Expression[] arrayOfExpression2;
    for (ClassType localClassType = null; ; localClassType = this.method.getDeclaringClass())
    {
      arrayOfExpression1 = paramApplyExp.getArgs();
      if (!isConstructor())
        break label172;
      if (!paramApplyExp.getFlag(8))
        break label158;
      int i = arrayOfExpression1.length;
      paramCompilation.letStart();
      arrayOfExpression2 = new Expression[i];
      arrayOfExpression2[0] = arrayOfExpression1[0];
      for (int j = 1; j < i; j++)
      {
        Expression localExpression = arrayOfExpression1[j];
        Declaration localDeclaration = paramCompilation.letVariable(null, localExpression.getType(), localExpression);
        localDeclaration.setCanRead(true);
        arrayOfExpression2[j] = new ReferenceExp(localDeclaration);
      }
    }
    paramCompilation.letEnter();
    paramCompilation.letDone(new ApplyExp(paramApplyExp.func, arrayOfExpression2)).compile(paramCompilation, paramTarget);
    return;
    label158: localCodeAttr.emitNew(localClassType);
    localCodeAttr.emitDup(localClassType);
    label172: String str = WrongArguments.checkArgCount(this, arrayOfExpression1.length);
    if (str != null)
      paramCompilation.error('e', str);
    if (getStaticFlag());
    for (Object localObject = null; ; localObject = localClassType)
    {
      compile((Type)localObject, paramApplyExp, paramCompilation, paramTarget);
      return;
    }
  }

  public gnu.bytecode.Method getMethod()
  {
    return this.method;
  }

  public String getName()
  {
    String str1 = super.getName();
    if (str1 != null)
      return str1;
    String str2 = getVerboseName();
    setName(str2);
    return str2;
  }

  public Type getParameterType(int paramInt)
  {
    if (takesTarget())
    {
      if (paramInt == 0)
      {
        if (isConstructor())
          return Type.objectType;
        return this.method.getDeclaringClass();
      }
      paramInt--;
    }
    int i = this.argTypes.length;
    if (paramInt < i - 1)
      return this.argTypes[paramInt];
    boolean bool = takesVarArgs();
    if ((paramInt < i) && (!bool))
      return this.argTypes[paramInt];
    Type localType = this.argTypes[(i - 1)];
    if ((localType instanceof ArrayType))
      return ((ArrayType)localType).getComponentType();
    return Type.objectType;
  }

  public final Type[] getParameterTypes()
  {
    return this.argTypes;
  }

  public Type getReturnType()
  {
    return this.retType;
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    return this.retType;
  }

  public final boolean getStaticFlag()
  {
    return (this.method == null) || (this.method.getStaticFlag()) || (isConstructor());
  }

  public String getVerboseName()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    if (this.method == null)
    {
      localStringBuffer.append("<op ");
      localStringBuffer.append(this.op_code);
      localStringBuffer.append('>');
    }
    while (true)
    {
      localStringBuffer.append('(');
      for (int i = 0; i < this.argTypes.length; i++)
      {
        if (i > 0)
          localStringBuffer.append(',');
        localStringBuffer.append(this.argTypes[i].getName());
      }
      localStringBuffer.append(this.method.getDeclaringClass().getName());
      localStringBuffer.append('.');
      localStringBuffer.append(this.method.getName());
    }
    localStringBuffer.append(')');
    return localStringBuffer.toString();
  }

  public int isApplicable(Type[] paramArrayOfType)
  {
    int i = super.isApplicable(paramArrayOfType);
    int j = paramArrayOfType.length;
    if ((i == -1) && (this.method != null) && ((0x80 & this.method.getModifiers()) != 0) && (j > 0) && ((paramArrayOfType[(j - 1)] instanceof ArrayType)))
    {
      Type[] arrayOfType = new Type[j];
      System.arraycopy(paramArrayOfType, 0, arrayOfType, 0, j - 1);
      arrayOfType[(j - 1)] = ((ArrayType)paramArrayOfType[(j - 1)]).getComponentType();
      return super.isApplicable(arrayOfType);
    }
    return i;
  }

  public final boolean isConstructor()
  {
    return (opcode() == 183) && (this.mode != 'P');
  }

  public boolean isSideEffectFree()
  {
    return this.sideEffectFree;
  }

  public boolean isSpecial()
  {
    return this.mode == 'P';
  }

  public int match0(CallContext paramCallContext)
  {
    return matchN(ProcedureN.noArgs, paramCallContext);
  }

  public int match1(Object paramObject, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject }, paramCallContext);
  }

  public int match2(Object paramObject1, Object paramObject2, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject1, paramObject2 }, paramCallContext);
  }

  public int match3(Object paramObject1, Object paramObject2, Object paramObject3, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject1, paramObject2, paramObject3 }, paramCallContext);
  }

  public int match4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext)
  {
    return matchN(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }, paramCallContext);
  }

  public int matchN(Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    int i = paramArrayOfObject.length;
    boolean bool1 = takesVarArgs();
    int j = minArgs();
    if (i < j)
      return 0xFFF10000 | j;
    if ((!bool1) && (i > j))
      return 0xFFF20000 | j;
    int k = this.argTypes.length;
    int m;
    Object[] arrayOfObject1;
    Object localObject1;
    Object[] arrayOfObject2;
    Type localType;
    label153: Object localObject2;
    label165: int n;
    label169: Object localObject3;
    Object localObject4;
    if ((takesTarget()) || (isConstructor()))
    {
      m = 1;
      boolean bool2 = takesContext();
      arrayOfObject1 = new Object[k];
      if (bool2)
      {
        k--;
        arrayOfObject1[k] = paramCallContext;
      }
      localObject1 = null;
      arrayOfObject2 = null;
      if (bool1)
      {
        localType = this.argTypes[(k - 1)];
        if ((localType != Compilation.scmListType) && (localType != LangObjType.listType))
          break label259;
        arrayOfObject1[(k - 1)] = LList.makeList(paramArrayOfObject, j);
        localObject1 = Type.objectType;
      }
      if (!isConstructor())
        break label301;
      localObject2 = paramArrayOfObject[0];
      n = m;
      int i1 = paramArrayOfObject.length;
      if (n >= i1)
        break label376;
      localObject3 = paramArrayOfObject[n];
      if (n >= j)
        break label340;
      localObject4 = this.argTypes[(n - m)];
      ClassType localClassType = Type.objectType;
      if (localObject4 == localClassType);
    }
    while (true)
    {
      try
      {
        while (true)
        {
          Object localObject5 = ((Type)localObject4).coerceFromObject(localObject3);
          localObject3 = localObject5;
          if (n >= j)
            break label358;
          arrayOfObject1[(n - m)] = localObject3;
          n++;
          break label169;
          m = 0;
          break;
          label259: localObject1 = ((ArrayType)localType).getComponentType();
          arrayOfObject2 = (Object[])Array.newInstance(((Type)localObject1).getReflectClass(), i - j);
          arrayOfObject1[(k - 1)] = arrayOfObject2;
          break label153;
          label301: if (m != 0)
            try
            {
              Object localObject6 = this.method.getDeclaringClass().coerceFromObject(paramArrayOfObject[0]);
              localObject2 = localObject6;
            }
            catch (ClassCastException localClassCastException2)
            {
              return -786431;
            }
        }
        localObject2 = null;
        break label165;
        label340: localObject4 = localObject1;
      }
      catch (ClassCastException localClassCastException1)
      {
        return 0xFFF40000 | n + 1;
      }
      label358: if (arrayOfObject2 != null)
        arrayOfObject2[(n - j)] = localObject3;
    }
    label376: paramCallContext.value1 = localObject2;
    paramCallContext.values = arrayOfObject1;
    paramCallContext.proc = this;
    return 0;
  }

  public int numArgs()
  {
    int i = this.argTypes.length;
    if (takesTarget())
      i++;
    if (takesContext())
      i--;
    if (takesVarArgs())
      return -4096 + (i - 1);
    return i + (i << 12);
  }

  public final int opcode()
  {
    return this.op_code;
  }

  public void print(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.print("#<primitive procedure ");
    paramPrintWriter.print(toString());
    paramPrintWriter.print('>');
  }

  public void setReturnType(Type paramType)
  {
    this.retType = paramType;
  }

  public void setSideEffectFree()
  {
    this.sideEffectFree = true;
  }

  public boolean takesContext()
  {
    return (this.method != null) && (takesContext(this.method));
  }

  public boolean takesTarget()
  {
    return this.mode != 0;
  }

  public boolean takesVarArgs()
  {
    if (this.method != null)
    {
      if ((0x80 & this.method.getModifiers()) != 0)
        return true;
      String str = this.method.getName();
      return (str.endsWith("$V")) || (str.endsWith("$V$X"));
    }
    return false;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(100);
    if (this.retType == null);
    for (String str = "<unknown>"; ; str = this.retType.getName())
    {
      localStringBuffer.append(str);
      localStringBuffer.append(' ');
      localStringBuffer.append(getVerboseName());
      return localStringBuffer.toString();
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.PrimProcedure
 * JD-Core Version:    0.6.2
 */