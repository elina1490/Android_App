package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;

public class SlotGet extends Procedure2
  implements HasSetter, Inlineable
{
  public static final SlotGet field = new SlotGet("field", false, SlotSet.set$Mnfield$Ex);
  static Class[] noClasses = new Class[0];
  public static final SlotGet slotRef = new SlotGet("slot-ref", false, SlotSet.set$Mnfield$Ex);
  public static final SlotGet staticField = new SlotGet("static-field", true, SlotSet.set$Mnstatic$Mnfield$Ex);
  boolean isStatic;
  Procedure setter;

  public SlotGet(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.isStatic = paramBoolean;
    setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotGet");
  }

  public SlotGet(String paramString, boolean paramBoolean, Procedure paramProcedure)
  {
    this(paramString, paramBoolean);
    this.setter = paramProcedure;
  }

  static Class coerceToClass(Object paramObject)
  {
    if ((paramObject instanceof Class))
      return (Class)paramObject;
    if ((paramObject instanceof Type))
      return ((Type)paramObject).getReflectClass();
    throw new RuntimeException("argument is neither Class nor Type");
  }

  public static Object field(Object paramObject, String paramString)
  {
    return field.apply2(paramObject, paramString);
  }

  // ERROR //
  public static Object getSlotValue(boolean paramBoolean, Object paramObject, String paramString1, String paramString2, String paramString3, String paramString4, Language paramLanguage)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifeq +31 -> 32
    //   4: aload_1
    //   5: invokestatic 100	gnu/kawa/reflect/SlotGet:coerceToClass	(Ljava/lang/Object;)Ljava/lang/Class;
    //   8: astore 7
    //   10: aload_3
    //   11: ldc 102
    //   13: if_acmpne +28 -> 41
    //   16: aload 7
    //   18: invokevirtual 106	java/lang/Class:isArray	()Z
    //   21: ifeq +20 -> 41
    //   24: aload_1
    //   25: invokestatic 112	java/lang/reflect/Array:getLength	(Ljava/lang/Object;)I
    //   28: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: areturn
    //   32: aload_1
    //   33: invokevirtual 123	java/lang/Object:getClass	()Ljava/lang/Class;
    //   36: astore 7
    //   38: goto -28 -> 10
    //   41: aload_3
    //   42: ldc 125
    //   44: if_acmpne +6 -> 50
    //   47: aload 7
    //   49: areturn
    //   50: iconst_0
    //   51: istore 8
    //   53: aload_3
    //   54: ifnull +104 -> 158
    //   57: aload 7
    //   59: aload_3
    //   60: invokevirtual 129	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   63: astore 47
    //   65: aload 47
    //   67: astore 43
    //   69: iconst_0
    //   70: istore 8
    //   72: aload 43
    //   74: ifnull +84 -> 158
    //   77: iload_0
    //   78: ifeq +54 -> 132
    //   81: bipush 8
    //   83: aload 43
    //   85: invokevirtual 135	java/lang/reflect/Field:getModifiers	()I
    //   88: iand
    //   89: ifne +43 -> 132
    //   92: new 80	java/lang/RuntimeException
    //   95: dup
    //   96: new 137	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   103: ldc 141
    //   105: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_3
    //   109: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: bipush 39
    //   114: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   117: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   123: athrow
    //   124: astore 42
    //   126: aconst_null
    //   127: astore 43
    //   129: goto -60 -> 69
    //   132: aload 6
    //   134: aload 43
    //   136: invokevirtual 155	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   139: aload 43
    //   141: aload_1
    //   142: invokevirtual 159	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   145: invokevirtual 165	gnu/expr/Language:coerceToObject	(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    //   148: astore 46
    //   150: aload 46
    //   152: areturn
    //   153: astore 45
    //   155: iconst_1
    //   156: istore 8
    //   158: aconst_null
    //   159: astore 9
    //   161: aload 4
    //   163: ifnull +97 -> 260
    //   166: aload 7
    //   168: aload 4
    //   170: getstatic 24	gnu/kawa/reflect/SlotGet:noClasses	[Ljava/lang/Class;
    //   173: invokevirtual 169	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   176: astore 41
    //   178: aload 41
    //   180: astore 29
    //   182: iload_0
    //   183: ifeq +137 -> 320
    //   186: bipush 8
    //   188: aload 29
    //   190: invokevirtual 172	java/lang/reflect/Method:getModifiers	()I
    //   193: iand
    //   194: ifne +126 -> 320
    //   197: new 80	java/lang/RuntimeException
    //   200: dup
    //   201: new 137	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   208: ldc 174
    //   210: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 4
    //   215: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: bipush 39
    //   220: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   223: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   229: athrow
    //   230: astore 10
    //   232: aload 29
    //   234: pop
    //   235: aload 4
    //   237: pop
    //   238: aload 10
    //   240: invokevirtual 178	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   243: invokestatic 184	gnu/mapping/WrappedException:wrapIfNeeded	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   246: athrow
    //   247: astore 44
    //   249: aload 44
    //   251: invokevirtual 187	java/lang/Exception:printStackTrace	()V
    //   254: iconst_0
    //   255: istore 8
    //   257: goto -99 -> 158
    //   260: ldc 188
    //   262: aload_2
    //   263: invokestatic 194	gnu/expr/ClassExp:slotToMethodName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   266: astore 39
    //   268: aload 39
    //   270: astore 4
    //   272: goto -106 -> 166
    //   275: astore 16
    //   277: aload 5
    //   279: ifnull +26 -> 305
    //   282: aload 5
    //   284: astore 4
    //   286: aload 7
    //   288: aload 4
    //   290: getstatic 24	gnu/kawa/reflect/SlotGet:noClasses	[Ljava/lang/Class;
    //   293: invokevirtual 169	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   296: astore 28
    //   298: aload 28
    //   300: astore 29
    //   302: goto -120 -> 182
    //   305: ldc 196
    //   307: aload_2
    //   308: invokestatic 194	gnu/expr/ClassExp:slotToMethodName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   311: astore 22
    //   313: aload 22
    //   315: astore 4
    //   317: goto -31 -> 286
    //   320: aload 29
    //   322: aload_1
    //   323: getstatic 202	gnu/mapping/Values:noArgs	[Ljava/lang/Object;
    //   326: invokevirtual 206	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   329: astore 35
    //   331: aload 6
    //   333: aload 29
    //   335: invokevirtual 209	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   338: aload 35
    //   340: invokevirtual 165	gnu/expr/Language:coerceToObject	(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    //   343: astore 36
    //   345: aload 36
    //   347: areturn
    //   348: astore 13
    //   350: aconst_null
    //   351: astore 14
    //   353: aload 14
    //   355: pop
    //   356: iconst_1
    //   357: istore 12
    //   359: iload 12
    //   361: ifeq +39 -> 400
    //   364: new 80	java/lang/RuntimeException
    //   367: dup
    //   368: new 137	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   375: ldc 211
    //   377: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_3
    //   381: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   390: athrow
    //   391: astore 11
    //   393: iload 8
    //   395: istore 12
    //   397: goto -38 -> 359
    //   400: new 80	java/lang/RuntimeException
    //   403: dup
    //   404: new 137	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   411: ldc 213
    //   413: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_3
    //   417: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc 215
    //   422: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 7
    //   427: invokevirtual 218	java/lang/Class:getName	()Ljava/lang/String;
    //   430: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokespecial 83	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   439: athrow
    //   440: astore 26
    //   442: aload 4
    //   444: pop
    //   445: goto -52 -> 393
    //   448: astore 20
    //   450: aload 9
    //   452: pop
    //   453: goto -60 -> 393
    //   456: astore 32
    //   458: aload 29
    //   460: pop
    //   461: aload 4
    //   463: pop
    //   464: goto -71 -> 393
    //   467: astore 24
    //   469: aload 4
    //   471: pop
    //   472: aconst_null
    //   473: astore 14
    //   475: goto -122 -> 353
    //   478: astore 18
    //   480: aload 9
    //   482: pop
    //   483: aconst_null
    //   484: astore 14
    //   486: goto -133 -> 353
    //   489: astore 30
    //   491: aload 29
    //   493: astore 14
    //   495: aload 4
    //   497: pop
    //   498: goto -145 -> 353
    //   501: astore 10
    //   503: goto -265 -> 238
    //   506: astore 10
    //   508: aload 4
    //   510: pop
    //   511: goto -273 -> 238
    //   514: astore 10
    //   516: aload 9
    //   518: pop
    //   519: goto -281 -> 238
    //   522: astore 40
    //   524: aload 4
    //   526: astore 9
    //   528: goto -251 -> 277
    //
    // Exception table:
    //   from	to	target	type
    //   57	65	124	java/lang/Exception
    //   132	150	153	java/lang/IllegalAccessException
    //   186	230	230	java/lang/reflect/InvocationTargetException
    //   320	345	230	java/lang/reflect/InvocationTargetException
    //   132	150	247	java/lang/Exception
    //   260	268	275	java/lang/Exception
    //   260	268	348	java/lang/IllegalAccessException
    //   260	268	391	java/lang/NoSuchMethodException
    //   166	178	440	java/lang/NoSuchMethodException
    //   286	298	440	java/lang/NoSuchMethodException
    //   305	313	448	java/lang/NoSuchMethodException
    //   186	230	456	java/lang/NoSuchMethodException
    //   320	345	456	java/lang/NoSuchMethodException
    //   166	178	467	java/lang/IllegalAccessException
    //   286	298	467	java/lang/IllegalAccessException
    //   305	313	478	java/lang/IllegalAccessException
    //   186	230	489	java/lang/IllegalAccessException
    //   320	345	489	java/lang/IllegalAccessException
    //   260	268	501	java/lang/reflect/InvocationTargetException
    //   166	178	506	java/lang/reflect/InvocationTargetException
    //   286	298	506	java/lang/reflect/InvocationTargetException
    //   305	313	514	java/lang/reflect/InvocationTargetException
    //   166	178	522	java/lang/Exception
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
    Method localMethod = paramObjectType.getMethod(ClassExp.slotToMethodName("get", paramString), Type.typeArray0);
    if (localMethod == null)
      return localField;
    return localMethod;
  }

  public static ApplyExp makeGetField(Expression paramExpression, String paramString)
  {
    Expression[] arrayOfExpression = new Expression[2];
    arrayOfExpression[0] = paramExpression;
    arrayOfExpression[1] = new QuoteExp(paramString);
    return new ApplyExp(field, arrayOfExpression);
  }

  public static Object staticField(Object paramObject, String paramString)
  {
    return staticField.apply2(paramObject, paramString);
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    String str2;
    String str1;
    if ((paramObject2 instanceof Field))
    {
      str2 = ((Field)paramObject2).getName();
      str1 = Compilation.demangleName(str2, true);
      if (!"class".equals(str2))
        break label182;
      str2 = "class";
    }
    while (true)
    {
      return getSlotValue(this.isStatic, paramObject1, str1, str2, (String)localObject1, (String)localObject2, Language.getDefaultLanguage());
      if ((paramObject2 instanceof Method))
      {
        String str3 = ((Method)paramObject2).getName();
        str1 = Compilation.demangleName(str3, false);
        if (str3.startsWith("get"))
          localObject1 = str3;
        while (true)
        {
          str2 = null;
          break;
          boolean bool = str3.startsWith("is");
          localObject1 = null;
          localObject2 = null;
          if (bool)
          {
            localObject2 = str3;
            localObject1 = null;
          }
        }
      }
      if (((paramObject2 instanceof SimpleSymbol)) || ((paramObject2 instanceof CharSequence)))
      {
        str1 = paramObject2.toString();
        str2 = Compilation.mangleNameIfNeeded(str1);
        localObject1 = null;
        localObject2 = null;
        break;
      }
      throw new WrongType(this, 2, paramObject2, "string");
      label182: if ("length".equals(str2))
        str2 = "length";
    }
  }

  public void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget)
  {
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    Expression localExpression1 = arrayOfExpression[0];
    Expression localExpression2 = arrayOfExpression[1];
    Language localLanguage = paramCompilation.getLanguage();
    Type localType;
    CodeAttr localCodeAttr;
    ObjectType localObjectType;
    Object localObject;
    Field localField;
    int i;
    label108: Target localTarget2;
    if (this.isStatic)
    {
      localType = localLanguage.getTypeFor(localExpression1);
      localCodeAttr = paramCompilation.getCode();
      if ((!(localType instanceof ObjectType)) || (!(localExpression2 instanceof QuoteExp)))
        break label295;
      localObjectType = (ObjectType)localType;
      localObject = ((QuoteExp)localExpression2).getValue();
      if (!(localObject instanceof Field))
        break label200;
      localField = (Field)localObject;
      if ((0x8 & localField.getModifiers()) == 0)
        break label174;
      i = 1;
      Expression localExpression4 = arrayOfExpression[0];
      if (i == 0)
        break label180;
      localTarget2 = Target.Ignore;
      label124: localExpression4.compile(paramCompilation, localTarget2);
      if (i == 0)
        break label190;
      if (0 == 0)
        localCodeAttr.emitGetStatic(localField);
    }
    while (true)
    {
      paramTarget.compileFromStack(paramCompilation, localLanguage.getLangTypeFor(localField.getType()));
      return;
      localType = localExpression1.getType();
      break;
      label174: i = 0;
      break label108;
      label180: localTarget2 = Target.pushValue(localObjectType);
      break label124;
      label190: localCodeAttr.emitGetField(localField);
    }
    label200: if ((localObject instanceof Method))
    {
      Method localMethod = (Method)localObject;
      localMethod.getModifiers();
      boolean bool = localMethod.getStaticFlag();
      Expression localExpression3 = arrayOfExpression[0];
      Target localTarget1;
      if (bool)
      {
        localTarget1 = Target.Ignore;
        localExpression3.compile(paramCompilation, localTarget1);
        if (!bool)
          break label285;
        localCodeAttr.emitInvokeStatic(localMethod);
      }
      while (true)
      {
        paramTarget.compileFromStack(paramCompilation, localMethod.getReturnType());
        return;
        localTarget1 = Target.pushValue(localObjectType);
        break;
        localCodeAttr.emitInvoke(localMethod);
      }
    }
    label285: label295: String str = ClassMethods.checkName(localExpression2);
    if (((localType instanceof ArrayType)) && ("length".equals(str)) && (!this.isStatic))
    {
      arrayOfExpression[0].compile(paramCompilation, Target.pushValue(localType));
      localCodeAttr.emitArrayLength();
      paramTarget.compileFromStack(paramCompilation, LangPrimType.intType);
      return;
    }
    ApplyExp.compile(paramApplyExp, paramCompilation, paramTarget);
  }

  public Type getReturnType(Expression[] paramArrayOfExpression)
  {
    if (paramArrayOfExpression.length == 2)
    {
      Expression localExpression1 = paramArrayOfExpression[0];
      Expression localExpression2 = paramArrayOfExpression[1];
      if ((localExpression2 instanceof QuoteExp))
      {
        Object localObject = ((QuoteExp)localExpression2).getValue();
        if ((localObject instanceof Field))
          return ((Field)localObject).getType();
        if ((localObject instanceof Method))
          return ((Method)localObject).getReturnType();
        if ((!this.isStatic) && ((localExpression1.getType() instanceof ArrayType)) && ("length".equals(ClassMethods.checkName(localExpression2, true))))
          return LangPrimType.intType;
      }
    }
    return Type.pointer_type;
  }

  public Procedure getSetter()
  {
    if (this.setter == null)
      return super.getSetter();
    return this.setter;
  }

  public void set2(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    SlotSet.apply(this.isStatic, paramObject1, (String)paramObject2, paramObject3);
  }

  public void setN(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (i != 3)
      throw new WrongArguments(getSetter(), i);
    set2(paramArrayOfObject[0], paramArrayOfObject[1], paramArrayOfObject[2]);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.SlotGet
 * JD-Core Version:    0.6.2
 */