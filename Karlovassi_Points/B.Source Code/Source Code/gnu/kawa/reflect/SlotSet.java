package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.CheckedTarget;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.lists.FString;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure3;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import kawa.standard.Scheme;

public class SlotSet extends Procedure3
  implements Inlineable
{
  public static final SlotSet set$Mnfield$Ex = new SlotSet("set-field!", false);
  public static final SlotSet set$Mnstatic$Mnfield$Ex = new SlotSet("set-static-field!", true);
  public static final SlotSet setFieldReturnObject = new SlotSet("set-field-return-object!", false);
  static final Type[] type1Array = new Type[1];
  boolean isStatic;
  boolean returnSelf;

  static
  {
    setFieldReturnObject.returnSelf = true;
  }

  public SlotSet(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.isStatic = paramBoolean;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotSet");
  }

  // ERROR //
  public static void apply(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: invokestatic 74	gnu/expr/Language:getDefaultLanguage	()Lgnu/expr/Language;
    //   3: astore 4
    //   5: aload_2
    //   6: instanceof 76
    //   9: ifne +17 -> 26
    //   12: aload_2
    //   13: instanceof 78
    //   16: ifne +10 -> 26
    //   19: aload_2
    //   20: instanceof 80
    //   23: ifeq +81 -> 104
    //   26: aload_2
    //   27: invokevirtual 86	java/lang/Object:toString	()Ljava/lang/String;
    //   30: astore 5
    //   32: aload 5
    //   34: invokestatic 92	gnu/expr/Compilation:mangleNameIfNeeded	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore 6
    //   39: iload_0
    //   40: ifeq +55 -> 95
    //   43: aload_1
    //   44: invokestatic 98	gnu/kawa/reflect/SlotGet:coerceToClass	(Ljava/lang/Object;)Ljava/lang/Class;
    //   47: astore 7
    //   49: aload 5
    //   51: astore 8
    //   53: aload 6
    //   55: astore 9
    //   57: aload 7
    //   59: astore 10
    //   61: aload_2
    //   62: instanceof 100
    //   65: ifeq +64 -> 129
    //   68: aload_2
    //   69: checkcast 100	gnu/bytecode/Field
    //   72: invokevirtual 104	gnu/bytecode/Field:getReflectField	()Ljava/lang/reflect/Field;
    //   75: astore 41
    //   77: aload 41
    //   79: aload_1
    //   80: aload 4
    //   82: aload 41
    //   84: invokevirtual 110	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   87: aload_3
    //   88: invokevirtual 114	gnu/expr/Language:coerceFromObject	(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: invokevirtual 117	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   94: return
    //   95: aload_1
    //   96: invokevirtual 120	java/lang/Object:getClass	()Ljava/lang/Class;
    //   99: astore 7
    //   101: goto -52 -> 49
    //   104: aload_2
    //   105: checkcast 122	gnu/bytecode/Member
    //   108: invokeinterface 125 1 0
    //   113: astore 42
    //   115: aload 42
    //   117: astore 8
    //   119: aload 42
    //   121: astore 9
    //   123: aconst_null
    //   124: astore 10
    //   126: goto -65 -> 61
    //   129: aload 10
    //   131: aload 9
    //   133: invokevirtual 131	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   136: astore 40
    //   138: aload 40
    //   140: astore 41
    //   142: goto -65 -> 77
    //   145: astore 39
    //   147: iconst_1
    //   148: istore 12
    //   150: aload_2
    //   151: instanceof 133
    //   154: istore 17
    //   156: iload 17
    //   158: ifeq +135 -> 293
    //   161: aload 9
    //   163: astore 19
    //   165: iload 17
    //   167: ifeq +353 -> 520
    //   170: aload 19
    //   172: ldc 134
    //   174: invokevirtual 138	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   177: istore 20
    //   179: iload 20
    //   181: ifne +339 -> 520
    //   184: iconst_0
    //   185: istore 21
    //   187: iload 21
    //   189: ifeq +120 -> 309
    //   192: new 140	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   199: ldc 144
    //   201: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 19
    //   206: iconst_3
    //   207: invokevirtual 152	java/lang/String:substring	(I)Ljava/lang/String;
    //   210: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: astore 37
    //   218: aload 10
    //   220: aload 37
    //   222: getstatic 157	gnu/kawa/reflect/SlotGet:noClasses	[Ljava/lang/Class;
    //   225: invokevirtual 161	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   228: astore 38
    //   230: aload 38
    //   232: astore 25
    //   234: iconst_1
    //   235: anewarray 127	java/lang/Class
    //   238: astore 31
    //   240: aload 31
    //   242: iconst_0
    //   243: aload 25
    //   245: invokevirtual 166	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   248: aastore
    //   249: aload 10
    //   251: aload 19
    //   253: aload 31
    //   255: invokevirtual 161	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   258: astore 32
    //   260: iconst_1
    //   261: anewarray 82	java/lang/Object
    //   264: astore 33
    //   266: aload 33
    //   268: iconst_0
    //   269: aload 4
    //   271: aload 31
    //   273: iconst_0
    //   274: aaload
    //   275: aload_3
    //   276: invokevirtual 114	gnu/expr/Language:coerceFromObject	(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: aastore
    //   280: aload 32
    //   282: aload_1
    //   283: aload 33
    //   285: invokevirtual 170	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   288: pop
    //   289: iload 12
    //   291: pop
    //   292: return
    //   293: ldc 134
    //   295: aload 8
    //   297: invokestatic 176	gnu/expr/ClassExp:slotToMethodName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   300: astore 18
    //   302: aload 18
    //   304: astore 19
    //   306: goto -141 -> 165
    //   309: ldc 144
    //   311: aload 8
    //   313: invokestatic 176	gnu/expr/ClassExp:slotToMethodName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   316: astore 36
    //   318: aload 36
    //   320: astore 37
    //   322: goto -104 -> 218
    //   325: astore 22
    //   327: iload 21
    //   329: ifeq +44 -> 373
    //   332: new 140	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   339: ldc 178
    //   341: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload 19
    //   346: iconst_3
    //   347: invokevirtual 152	java/lang/String:substring	(I)Ljava/lang/String;
    //   350: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: astore 24
    //   358: aload 10
    //   360: aload 24
    //   362: getstatic 157	gnu/kawa/reflect/SlotGet:noClasses	[Ljava/lang/Class;
    //   365: invokevirtual 161	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   368: astore 25
    //   370: goto -136 -> 234
    //   373: ldc 178
    //   375: aload 8
    //   377: invokestatic 176	gnu/expr/ClassExp:slotToMethodName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   380: astore 23
    //   382: aload 23
    //   384: astore 24
    //   386: goto -28 -> 358
    //   389: astore 16
    //   391: aload 16
    //   393: invokevirtual 182	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   396: invokestatic 188	gnu/mapping/WrappedException:wrapIfNeeded	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   399: athrow
    //   400: astore 15
    //   402: iconst_1
    //   403: istore 14
    //   405: iload 14
    //   407: ifeq +40 -> 447
    //   410: new 190	java/lang/RuntimeException
    //   413: dup
    //   414: new 140	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   421: ldc 192
    //   423: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload 8
    //   428: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokespecial 193	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   437: athrow
    //   438: astore 13
    //   440: iload 12
    //   442: istore 14
    //   444: goto -39 -> 405
    //   447: new 190	java/lang/RuntimeException
    //   450: dup
    //   451: new 140	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   458: ldc 195
    //   460: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload 8
    //   465: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: ldc 197
    //   470: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 10
    //   475: invokevirtual 198	java/lang/Class:getName	()Ljava/lang/String;
    //   478: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokespecial 193	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   487: athrow
    //   488: astore 29
    //   490: aload 25
    //   492: pop
    //   493: goto -53 -> 440
    //   496: astore 27
    //   498: aload 25
    //   500: pop
    //   501: goto -99 -> 402
    //   504: astore 16
    //   506: aload 25
    //   508: pop
    //   509: goto -118 -> 391
    //   512: astore 11
    //   514: iconst_0
    //   515: istore 12
    //   517: goto -367 -> 150
    //   520: iload 17
    //   522: istore 21
    //   524: goto -337 -> 187
    //
    // Exception table:
    //   from	to	target	type
    //   61	77	145	java/lang/IllegalAccessException
    //   77	94	145	java/lang/IllegalAccessException
    //   129	138	145	java/lang/IllegalAccessException
    //   192	218	325	java/lang/Exception
    //   218	230	325	java/lang/Exception
    //   309	318	325	java/lang/Exception
    //   150	156	389	java/lang/reflect/InvocationTargetException
    //   170	179	389	java/lang/reflect/InvocationTargetException
    //   192	218	389	java/lang/reflect/InvocationTargetException
    //   218	230	389	java/lang/reflect/InvocationTargetException
    //   293	302	389	java/lang/reflect/InvocationTargetException
    //   309	318	389	java/lang/reflect/InvocationTargetException
    //   332	358	389	java/lang/reflect/InvocationTargetException
    //   358	370	389	java/lang/reflect/InvocationTargetException
    //   373	382	389	java/lang/reflect/InvocationTargetException
    //   150	156	400	java/lang/IllegalAccessException
    //   170	179	400	java/lang/IllegalAccessException
    //   192	218	400	java/lang/IllegalAccessException
    //   218	230	400	java/lang/IllegalAccessException
    //   293	302	400	java/lang/IllegalAccessException
    //   309	318	400	java/lang/IllegalAccessException
    //   332	358	400	java/lang/IllegalAccessException
    //   358	370	400	java/lang/IllegalAccessException
    //   373	382	400	java/lang/IllegalAccessException
    //   150	156	438	java/lang/NoSuchMethodException
    //   170	179	438	java/lang/NoSuchMethodException
    //   192	218	438	java/lang/NoSuchMethodException
    //   218	230	438	java/lang/NoSuchMethodException
    //   293	302	438	java/lang/NoSuchMethodException
    //   309	318	438	java/lang/NoSuchMethodException
    //   332	358	438	java/lang/NoSuchMethodException
    //   358	370	438	java/lang/NoSuchMethodException
    //   373	382	438	java/lang/NoSuchMethodException
    //   234	289	488	java/lang/NoSuchMethodException
    //   234	289	496	java/lang/IllegalAccessException
    //   234	289	504	java/lang/reflect/InvocationTargetException
    //   61	77	512	java/lang/NoSuchFieldException
    //   77	94	512	java/lang/NoSuchFieldException
    //   129	138	512	java/lang/NoSuchFieldException
  }

  static void compileSet(Procedure paramProcedure, ObjectType paramObjectType, Expression paramExpression, Object paramObject, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    Language localLanguage = paramCompilation.getLanguage();
    int i;
    Field localField;
    if (((paramProcedure instanceof SlotSet)) && (((SlotSet)paramProcedure).isStatic))
    {
      i = 1;
      if (!(paramObject instanceof Field))
        break label161;
      localField = (Field)paramObject;
      boolean bool2 = localField.getStaticFlag();
      Type localType = localLanguage.getLangTypeFor(localField.getType());
      if ((i != 0) && (!bool2))
        paramCompilation.error('e', "cannot access non-static field `" + localField.getName() + "' using `" + paramProcedure.getName() + '\'');
      paramExpression.compile(paramCompilation, CheckedTarget.getInstance(localType));
      if (!bool2)
        break label153;
      localCodeAttr.emitPutStatic(localField);
    }
    while (true)
    {
      return;
      i = 0;
      break;
      label153: localCodeAttr.emitPutField(localField);
      return;
      label161: if ((paramObject instanceof Method))
      {
        Method localMethod = (Method)paramObject;
        boolean bool1 = localMethod.getStaticFlag();
        if ((i != 0) && (!bool1))
          paramCompilation.error('e', "cannot call non-static getter method `" + localMethod.getName() + "' using `" + paramProcedure.getName() + '\'');
        paramExpression.compile(paramCompilation, CheckedTarget.getInstance(localLanguage.getLangTypeFor(localMethod.getParameterTypes()[0])));
        if (bool1)
          localCodeAttr.emitInvokeStatic(localMethod);
        while (!localMethod.getReturnType().isVoid())
        {
          localCodeAttr.emitPop(1);
          return;
          localCodeAttr.emitInvoke(localMethod);
        }
      }
    }
  }

  public static Member lookupMember(ObjectType paramObjectType, String paramString, ClassType paramClassType)
  {
    Field localField = paramObjectType.getField(Compilation.mangleNameIfNeeded(paramString), -1);
    if (localField != null)
    {
      if (paramClassType == null)
        paramClassType = Type.pointer_type;
      if (paramClassType.isAccessible(localField, paramObjectType))
        return localField;
    }
    Method localMethod = paramObjectType.getMethod(ClassExp.slotToMethodName("set", paramString), type1Array);
    if (localMethod == null)
      return localField;
    return localMethod;
  }

  public static void setField(Object paramObject1, String paramString, Object paramObject2)
  {
    apply(false, paramObject1, paramString, paramObject2);
  }

  public static void setStaticField(Object paramObject1, String paramString, Object paramObject2)
  {
    apply(true, paramObject1, paramString, paramObject2);
  }

  public Object apply3(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    apply(this.isStatic, paramObject1, paramObject2, paramObject3);
    if (this.returnSelf)
      return paramObject1;
    return Values.empty;
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    int i = arrayOfExpression.length;
    if (i != 3)
    {
      if (i < 3);
      for (String str2 = "too few"; ; str2 = "too many")
      {
        paramCompilation.error('e', str2 + " arguments to `" + getName() + '\'');
        paramCompilation.compileConstant(null, paramTarget);
        return;
      }
    }
    Expression localExpression1 = arrayOfExpression[0];
    Expression localExpression2 = arrayOfExpression[1];
    arrayOfExpression[2];
    Type localType;
    Object localObject;
    ObjectType localObjectType;
    ClassType localClassType1;
    label159: String str1;
    Member localMember;
    label266: int j;
    label287: Expression localExpression3;
    if (this.isStatic)
    {
      localType = Scheme.exp2Type(localExpression1);
      if ((!(localType instanceof ObjectType)) || (!(localExpression2 instanceof QuoteExp)))
        break label507;
      localObject = ((QuoteExp)localExpression2).getValue();
      localObjectType = (ObjectType)localType;
      if (paramCompilation.curClass == null)
        break label437;
      localClassType1 = paramCompilation.curClass;
      if ((!(localObject instanceof String)) && (!(localObject instanceof FString)) && (!(localObject instanceof Symbol)))
        break label446;
      str1 = localObject.toString();
      localMember = lookupMember(localObjectType, str1, localClassType1);
      if (localMember == null)
      {
        ClassType localClassType2 = Type.pointer_type;
        if ((localType != localClassType2) && (paramCompilation.warnUnknownMember()))
          paramCompilation.error('w', "no slot `" + str1 + "' in " + localObjectType.getName());
      }
      if (localMember == null)
        break label507;
      if ((0x8 & localMember.getModifiers()) == 0)
        break label482;
      j = 1;
      if ((localClassType1 != null) && (!localClassType1.isAccessible(localMember, localObjectType)))
        paramCompilation.error('e', "slot '" + str1 + "' in " + localMember.getDeclaringClass().getName() + " not accessible here");
      localExpression3 = arrayOfExpression[0];
      if (j == 0)
        break label488;
    }
    label437: label446: label482: label488: for (Target localTarget = Target.Ignore; ; localTarget = Target.pushValue(localObjectType))
    {
      localExpression3.compile(paramCompilation, localTarget);
      if (this.returnSelf)
        paramCompilation.getCode().emitDup(localObjectType.getImplementationType());
      compileSet(this, localObjectType, arrayOfExpression[2], localMember, paramCompilation);
      if (!this.returnSelf)
        break label498;
      paramTarget.compileFromStack(paramCompilation, localObjectType);
      return;
      localType = localExpression1.getType();
      break;
      localClassType1 = paramCompilation.mainClass;
      break label159;
      if ((localObject instanceof Member))
      {
        localMember = (Member)localObject;
        str1 = localMember.getName();
        break label266;
      }
      str1 = null;
      localMember = null;
      break label266;
      j = 0;
      break label287;
    }
    label498: paramCompilation.compileConstant(Values.empty, paramTarget);
    return;
    label507: ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.SlotSet
 * JD-Core Version:    0.6.2
 */