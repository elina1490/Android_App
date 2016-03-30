package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.lists.FString;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

public class CompileReflect
{
  public static int checkKnownClass(Type paramType, Compilation paramCompilation)
  {
    if (((paramType instanceof ClassType)) && (paramType.isExisting()))
      try
      {
        paramType.getReflectClass();
        return 1;
      }
      catch (Exception localException)
      {
        paramCompilation.error('e', "unknown class: " + paramType.getName());
        return -1;
      }
    return 0;
  }

  public static ApplyExp inlineClassName(ApplyExp paramApplyExp, int paramInt, InlineCalls paramInlineCalls)
  {
    Compilation localCompilation = paramInlineCalls.getCompilation();
    Language localLanguage = localCompilation.getLanguage();
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    if (arrayOfExpression1.length > paramInt)
    {
      Type localType = localLanguage.getTypeFor(arrayOfExpression1[paramInt]);
      if (!(localType instanceof Type))
        return paramApplyExp;
      checkKnownClass(localType, localCompilation);
      Expression[] arrayOfExpression2 = new Expression[arrayOfExpression1.length];
      System.arraycopy(arrayOfExpression1, 0, arrayOfExpression2, 0, arrayOfExpression1.length);
      arrayOfExpression2[paramInt] = new QuoteExp(localType);
      ApplyExp localApplyExp = new ApplyExp(paramApplyExp.getFunction(), arrayOfExpression2);
      localApplyExp.setLine(paramApplyExp);
      return localApplyExp;
    }
    return paramApplyExp;
  }

  public static Expression validateApplyInstanceOf(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    ApplyExp localApplyExp = inlineClassName(paramApplyExp, 1, paramInlineCalls);
    Expression[] arrayOfExpression = localApplyExp.getArgs();
    if (arrayOfExpression.length == 2)
    {
      Expression localExpression1 = arrayOfExpression[0];
      Expression localExpression2 = arrayOfExpression[1];
      if ((localExpression2 instanceof QuoteExp))
      {
        Object localObject1 = ((QuoteExp)localExpression2).getValue();
        if ((localObject1 instanceof Type))
        {
          Object localObject2 = (Type)localObject1;
          if ((localObject2 instanceof PrimType))
            localObject2 = ((PrimType)localObject2).boxedType();
          if ((localExpression1 instanceof QuoteExp))
          {
            if (((Type)localObject2).isInstance(((QuoteExp)localExpression1).getValue()))
              return QuoteExp.trueExp;
            return QuoteExp.falseExp;
          }
          if (!localExpression1.side_effects())
          {
            int i = ((Type)localObject2).compare(localExpression1.getType());
            if ((i == 1) || (i == 0))
              return QuoteExp.trueExp;
            if (i == -3)
              return QuoteExp.falseExp;
          }
        }
      }
    }
    return localApplyExp;
  }

  public static Expression validateApplySlotGet(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Compilation localCompilation = paramInlineCalls.getCompilation();
    Language localLanguage = localCompilation.getLanguage();
    boolean bool1 = ((SlotGet)paramProcedure).isStatic;
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    Expression localExpression1 = arrayOfExpression1[0];
    Expression localExpression2 = arrayOfExpression1[1];
    Object localObject = localExpression2.valueIfConstant();
    String str1;
    Type localType2;
    int k;
    if (((localObject instanceof String)) || ((localObject instanceof FString)) || ((localObject instanceof Symbol)))
    {
      str1 = localObject.toString();
      if (!bool1)
        break label242;
      localType2 = localLanguage.getTypeFor(localExpression1);
      k = checkKnownClass(localType2, localCompilation);
      if (k < 0)
        return paramApplyExp;
    }
    else
    {
      return paramApplyExp;
    }
    if ("class".equals(str1))
    {
      if (k > 0)
        return QuoteExp.getInstance(localType2.getReflectClass());
      Method localMethod2 = Compilation.typeType.getDeclaredMethod("getReflectClass", 0);
      ApplyExp localApplyExp4 = new ApplyExp(localMethod2, new Expression[] { localExpression1 });
      return localApplyExp4;
    }
    if (localType2 != null)
    {
      Expression[] arrayOfExpression4 = new Expression[2];
      arrayOfExpression4[0] = new QuoteExp(localType2);
      arrayOfExpression4[1] = localExpression2;
      ApplyExp localApplyExp3 = new ApplyExp(paramApplyExp.getFunction(), arrayOfExpression4);
      localApplyExp3.setLine(paramApplyExp);
      paramApplyExp = localApplyExp3;
    }
    label242: for (Type localType1 = localType2; (localType1 instanceof ArrayType); localType1 = localExpression1.getType())
      return paramApplyExp;
    if ((localType1 instanceof ObjectType))
    {
      ObjectType localObjectType = (ObjectType)localType1;
      ClassType localClassType1;
      Member localMember;
      Field localField;
      if (localCompilation.curClass != null)
      {
        localClassType1 = localCompilation.curClass;
        localMember = SlotGet.lookupMember(localObjectType, str1, localClassType1);
        if (!(localMember instanceof Field))
          break label471;
        localField = (Field)localMember;
        if ((0x8 & localField.getModifiers()) == 0)
          break label393;
      }
      label393: for (int j = 1; ; j = 0)
      {
        if ((!bool1) || (j != 0))
          break label399;
        ErrorExp localErrorExp4 = new ErrorExp("cannot access non-static field `" + str1 + "' using `" + paramProcedure.getName() + '\'', localCompilation);
        return localErrorExp4;
        localClassType1 = localCompilation.mainClass;
        break;
      }
      label399: if ((localClassType1 != null) && (!localClassType1.isAccessible(localField, localObjectType)))
      {
        ErrorExp localErrorExp3 = new ErrorExp("field " + localField.getDeclaringClass().getName() + '.' + str1 + " is not accessible here", localCompilation);
        return localErrorExp3;
        label471: if ((localMember instanceof Method))
        {
          Method localMethod1 = (Method)localMember;
          ClassType localClassType3 = localMethod1.getDeclaringClass();
          int i = localMethod1.getModifiers();
          boolean bool2 = localMethod1.getStaticFlag();
          if ((bool1) && (!bool2))
          {
            ErrorExp localErrorExp2 = new ErrorExp("cannot call non-static getter method `" + str1 + "' using `" + paramProcedure.getName() + '\'', localCompilation);
            return localErrorExp2;
          }
          if ((localClassType1 != null) && (!localClassType1.isAccessible(localClassType3, localObjectType, i)))
          {
            ErrorExp localErrorExp1 = new ErrorExp("method " + localMethod1 + " is not accessible here", localCompilation);
            return localErrorExp1;
          }
        }
      }
      if (localMember != null)
      {
        Expression[] arrayOfExpression3 = new Expression[2];
        arrayOfExpression3[0] = localExpression1;
        QuoteExp localQuoteExp2 = new QuoteExp(localMember);
        arrayOfExpression3[1] = localQuoteExp2;
        ApplyExp localApplyExp2 = new ApplyExp(paramApplyExp.getFunction(), arrayOfExpression3);
        localApplyExp2.setLine(paramApplyExp);
        return localApplyExp2;
      }
      ClassType localClassType2 = Type.pointer_type;
      if ((localType1 != localClassType2) && (localCompilation.warnUnknownMember()))
        localCompilation.error('e', "no slot `" + str1 + "' in " + localObjectType.getName());
    }
    String str2 = Compilation.mangleNameIfNeeded(str1).intern();
    String str3 = ClassExp.slotToMethodName("get", str1);
    String str4 = ClassExp.slotToMethodName("is", str1);
    Invoke localInvoke = Invoke.invokeStatic;
    Expression[] arrayOfExpression2 = new Expression[9];
    arrayOfExpression2[0] = QuoteExp.getInstance("gnu.kawa.reflect.SlotGet");
    arrayOfExpression2[1] = QuoteExp.getInstance("getSlotValue");
    if (bool1);
    for (QuoteExp localQuoteExp1 = QuoteExp.trueExp; ; localQuoteExp1 = QuoteExp.falseExp)
    {
      arrayOfExpression2[2] = localQuoteExp1;
      arrayOfExpression2[3] = arrayOfExpression1[0];
      arrayOfExpression2[4] = QuoteExp.getInstance(str1);
      arrayOfExpression2[5] = QuoteExp.getInstance(str2);
      arrayOfExpression2[6] = QuoteExp.getInstance(str3);
      arrayOfExpression2[7] = QuoteExp.getInstance(str4);
      arrayOfExpression2[8] = QuoteExp.getInstance(localLanguage);
      ApplyExp localApplyExp1 = new ApplyExp(localInvoke, arrayOfExpression2);
      localApplyExp1.setLine(paramApplyExp);
      return paramInlineCalls.visitApplyOnly(localApplyExp1, null);
    }
  }

  public static Expression validateApplySlotSet(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    SlotSet localSlotSet = (SlotSet)paramProcedure;
    if ((localSlotSet.isStatic) && (paramInlineCalls.getCompilation().mustCompile))
      paramApplyExp = inlineClassName(paramApplyExp, 0, paramInlineCalls);
    if ((localSlotSet.returnSelf) && (paramApplyExp.getArgCount() == 3));
    for (Object localObject = paramApplyExp.getArg(0).getType(); ; localObject = Type.voidType)
    {
      paramApplyExp.setType((Type)localObject);
      return paramApplyExp;
    }
  }

  public static Expression validateApplyTypeSwitch(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    for (int i = 1; i < arrayOfExpression.length; i++)
      if ((arrayOfExpression[i] instanceof LambdaExp))
      {
        LambdaExp localLambdaExp = (LambdaExp)arrayOfExpression[i];
        localLambdaExp.setInlineOnly(true);
        localLambdaExp.returnContinuation = paramApplyExp;
        localLambdaExp.inlineHome = paramInlineCalls.getCurrentLambda();
      }
    return paramApplyExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.CompileReflect
 * JD-Core Version:    0.6.2
 */