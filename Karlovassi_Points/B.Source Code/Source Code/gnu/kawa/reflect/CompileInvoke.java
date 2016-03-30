package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.TypeValue;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;

public class CompileInvoke
{
  private static void append(PrimProcedure[] paramArrayOfPrimProcedure, int paramInt, StringBuffer paramStringBuffer)
  {
    for (int i = 0; i < paramInt; i++)
    {
      paramStringBuffer.append("\n  candidate: ");
      paramStringBuffer.append(paramArrayOfPrimProcedure[i]);
    }
  }

  static Object[] checkKeywords(ObjectType paramObjectType, Expression[] paramArrayOfExpression, int paramInt, ClassType paramClassType)
  {
    int i = paramArrayOfExpression.length;
    for (int j = 0; (1 + (paramInt + j * 2) < i) && ((paramArrayOfExpression[(paramInt + j * 2)].valueIfConstant() instanceof Keyword)); j++);
    Object[] arrayOfObject = new Object[j];
    int k = 0;
    if (k < j)
    {
      String str = ((Keyword)paramArrayOfExpression[(paramInt + k * 2)].valueIfConstant()).getName();
      Object localObject1 = SlotSet.lookupMember(paramObjectType, str, paramClassType);
      if (localObject1 == null)
        localObject1 = paramObjectType.getMethod(ClassExp.slotToMethodName("add", str), SlotSet.type1Array);
      if (localObject1 != null);
      for (Object localObject2 = localObject1; ; localObject2 = str)
      {
        arrayOfObject[k] = localObject2;
        k++;
        break;
      }
    }
    return arrayOfObject;
  }

  private static String getMethodName(Expression[] paramArrayOfExpression, char paramChar)
  {
    if (paramChar == 'N')
      return "<init>";
    if (paramChar == 'P');
    for (int i = 2; paramArrayOfExpression.length >= i + 1; i = 1)
      return ClassMethods.checkName(paramArrayOfExpression[i], false);
    return null;
  }

  protected static PrimProcedure[] getMethods(ObjectType paramObjectType, String paramString, ClassType paramClassType, Invoke paramInvoke)
  {
    char c1 = 'P';
    char c2 = paramInvoke.kind;
    if (c2 == c1);
    while (true)
    {
      return ClassMethods.getMethods(paramObjectType, paramString, c1, paramClassType, paramInvoke.language);
      if ((c2 == '*') || (c2 == 'V'))
        c1 = 'V';
      else
        c1 = '\000';
    }
  }

  public static PrimProcedure getStaticMethod(ClassType paramClassType, String paramString, Expression[] paramArrayOfExpression)
  {
    while (true)
    {
      int j;
      int k;
      try
      {
        PrimProcedure[] arrayOfPrimProcedure = getMethods(paramClassType, paramString, null, Invoke.invokeStatic);
        long l = selectApplicable(arrayOfPrimProcedure, paramClassType, paramArrayOfExpression, paramArrayOfExpression.length, 0, -1);
        int i = (int)(l >> 32);
        j = (int)l;
        if (arrayOfPrimProcedure == null)
        {
          k = -1;
          if (k < 0)
          {
            localPrimProcedure = null;
            return localPrimProcedure;
          }
        }
        else
        {
          if (i <= 0)
            break label95;
          k = MethodProc.mostSpecific(arrayOfPrimProcedure, i);
          continue;
        }
        PrimProcedure localPrimProcedure = arrayOfPrimProcedure[k];
        continue;
      }
      finally
      {
      }
      label95: if (j == 1)
        k = 0;
      else
        k = -1;
    }
  }

  static int hasKeywordArgument(int paramInt, Expression[] paramArrayOfExpression)
  {
    for (int i = paramInt; i < paramArrayOfExpression.length; i++)
      if ((paramArrayOfExpression[i].valueIfConstant() instanceof Keyword))
        return i;
    return paramArrayOfExpression.length;
  }

  private static long selectApplicable(PrimProcedure[] paramArrayOfPrimProcedure, ObjectType paramObjectType, Expression[] paramArrayOfExpression, int paramInt1, int paramInt2, int paramInt3)
  {
    Type[] arrayOfType = new Type[paramInt1];
    int i = 0;
    if (paramInt3 >= 0)
    {
      int k = 0 + 1;
      arrayOfType[0] = paramObjectType;
      i = k;
    }
    int j = paramInt2;
    if ((j < paramArrayOfExpression.length) && (i < arrayOfType.length))
    {
      Expression localExpression = paramArrayOfExpression[j];
      Object localObject;
      if (InlineCalls.checkIntValue(localExpression) != null)
        localObject = Type.intType;
      while (true)
      {
        arrayOfType[i] = localObject;
        j++;
        i++;
        break;
        if (InlineCalls.checkLongValue(localExpression) != null)
        {
          localObject = Type.longType;
        }
        else
        {
          localObject = null;
          if (0 == 0)
            localObject = localExpression.getType();
        }
      }
    }
    return ClassMethods.selectApplicable(paramArrayOfPrimProcedure, arrayOfType);
  }

  public static Expression validateApplyInvoke(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    Invoke localInvoke1 = (Invoke)paramProcedure;
    char c1 = localInvoke1.kind;
    Compilation localCompilation = paramInlineCalls.getCompilation();
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    int i = arrayOfExpression1.length;
    if ((!localCompilation.mustCompile) || (i == 0) || (((c1 == 'V') || (c1 == '*')) && (i == 1)))
    {
      paramApplyExp.visitArgs(paramInlineCalls);
      return paramApplyExp;
    }
    Expression localExpression1 = paramInlineCalls.visit(arrayOfExpression1[0], null);
    arrayOfExpression1[0] = localExpression1;
    Type localType1;
    Object localObject1;
    label133: String str1;
    int j;
    int k;
    int m;
    label168: ArrayType localArrayType;
    Type localType4;
    Expression localExpression3;
    int i26;
    if ((c1 == 'V') || (c1 == '*'))
    {
      localType1 = localExpression1.getType();
      if ((!(localType1 instanceof PairClassType)) || (c1 != 'N'))
        break label370;
      localObject1 = ((PairClassType)localType1).instanceType;
      str1 = getMethodName(arrayOfExpression1, c1);
      if ((c1 != 'V') && (c1 != '*'))
        break label394;
      j = i - 1;
      k = 2;
      m = 0;
      if ((c1 != 'N') || (!(localObject1 instanceof ArrayType)))
        break label792;
      localArrayType = (ArrayType)localObject1;
      localType4 = localArrayType.getComponentType();
      if ((arrayOfExpression1.length < 3) || (!(arrayOfExpression1[1] instanceof QuoteExp)))
        break label2805;
      Object localObject11 = ((QuoteExp)arrayOfExpression1[1]).getValue();
      if (!(localObject11 instanceof Keyword))
        break label2805;
      String str9 = ((Keyword)localObject11).getName();
      if ((!"length".equals(str9)) && (!"size".equals(str9)))
        break label2796;
      localExpression3 = arrayOfExpression1[2];
      i26 = 1;
    }
    while (true)
    {
      if (localExpression3 == null);
      for (Object localObject9 = QuoteExp.getInstance(new Integer(arrayOfExpression1.length - 1)); ; localObject9 = localExpression3)
      {
        Expression localExpression4 = paramInlineCalls.visit((Expression)localObject9, Type.intType);
        ApplyExp localApplyExp6 = new ApplyExp(new ArrayNew(localType4), new Expression[] { localExpression4 });
        localApplyExp6.setType(localArrayType);
        if ((i26 != 0) && (arrayOfExpression1.length == 3))
        {
          return localApplyExp6;
          localType1 = localInvoke1.language.getTypeFor(localExpression1);
          break;
          label370: if ((localType1 instanceof ObjectType))
          {
            localObject1 = (ObjectType)localType1;
            break label133;
          }
          localObject1 = null;
          break label133;
          label394: if (c1 == 'N')
          {
            j = i;
            m = -1;
            k = 0;
            break label168;
          }
          if ((c1 == 'S') || (c1 == 's'))
          {
            j = i - 2;
            k = 2;
            m = -1;
            break label168;
          }
          if (c1 == 'P')
          {
            j = i - 2;
            k = 3;
            m = 1;
            break label168;
          }
          paramApplyExp.visitArgs(paramInlineCalls);
          return paramApplyExp;
        }
        LetExp localLetExp2 = new LetExp(new Expression[] { localApplyExp6 });
        Declaration localDeclaration2 = localLetExp2.addDeclaration((String)null, localArrayType);
        localDeclaration2.noteValue(localApplyExp6);
        BeginExp localBeginExp2 = new BeginExp();
        int i27;
        if (i26 != 0)
          i27 = 3;
        while (true)
        {
          int i28 = 0;
          int i29 = i27;
          label534: int i30 = arrayOfExpression1.length;
          if (i29 < i30)
          {
            Expression localExpression5 = arrayOfExpression1[i29];
            String str8;
            if ((i26 != 0) && (i29 + 1 < arrayOfExpression1.length) && ((localExpression5 instanceof QuoteExp)))
            {
              Object localObject10 = ((QuoteExp)localExpression5).getValue();
              if ((localObject10 instanceof Keyword))
                str8 = ((Keyword)localObject10).getName();
            }
            try
            {
              i28 = Integer.parseInt(str8);
              i29++;
              localExpression5 = arrayOfExpression1[i29];
              Expression localExpression6 = paramInlineCalls.visit(localExpression5, localType4);
              ArraySet localArraySet = new ArraySet(localType4);
              Expression[] arrayOfExpression8 = new Expression[3];
              ReferenceExp localReferenceExp4 = new ReferenceExp(localDeclaration2);
              arrayOfExpression8[0] = localReferenceExp4;
              Integer localInteger = new Integer(i28);
              arrayOfExpression8[1] = QuoteExp.getInstance(localInteger);
              arrayOfExpression8[2] = localExpression6;
              localBeginExp2.add(new ApplyExp(localArraySet, arrayOfExpression8));
              i28++;
              i29++;
              break label534;
              i27 = 1;
            }
            catch (Throwable localThrowable)
            {
              localCompilation.error('e', "non-integer keyword '" + str8 + "' in array constructor");
              return paramApplyExp;
            }
          }
        }
        ReferenceExp localReferenceExp3 = new ReferenceExp(localDeclaration2);
        localBeginExp2.add(localReferenceExp3);
        localLetExp2.body = localBeginExp2;
        return localLetExp2;
        label792: label1176: Object localObject4;
        Object localObject5;
        label1297: label1468: label1495: Object localObject6;
        label1695: label1707: label1734: label1791: String str5;
        label1829: label1839: label1871: label2144: label2171: String str2;
        label1922: label1928: label1978: int i4;
        label2210: label2233: label2388: label2395: int i9;
        if ((localObject1 != null) && (str1 != null))
        {
          if (((localObject1 instanceof TypeValue)) && (c1 == 'N'))
          {
            Procedure localProcedure = ((TypeValue)localObject1).getConstructor();
            if (localProcedure != null)
            {
              Expression[] arrayOfExpression7 = new Expression[i - 1];
              System.arraycopy(arrayOfExpression1, 1, arrayOfExpression7, 0, i - 1);
              ApplyExp localApplyExp5 = new ApplyExp(localProcedure, arrayOfExpression7);
              return paramInlineCalls.visit(localApplyExp5, paramType);
            }
          }
          ClassType localClassType;
          Object localObject2;
          if (localCompilation == null)
          {
            localClassType = null;
            localObject2 = localObject1;
          }
          PrimProcedure[] arrayOfPrimProcedure;
          int n;
          int i19;
          Object[] arrayOfObject;
          StringBuffer localStringBuffer3;
          while (true)
          {
            try
            {
              arrayOfPrimProcedure = getMethods(localObject2, str1, localClassType, localInvoke1);
              n = ClassMethods.selectApplicable(arrayOfPrimProcedure, j);
              if (c1 != 'N')
                break label1707;
              i19 = hasKeywordArgument(1, arrayOfExpression1);
              if (i19 >= arrayOfExpression1.length)
              {
                if (n > 0)
                  break label1707;
                Type[] arrayOfType = new Type[1];
                arrayOfType[0] = Compilation.typeClassType;
                if (ClassMethods.selectApplicable(arrayOfPrimProcedure, arrayOfType) >> 32 != 1L)
                  break label1707;
              }
              arrayOfObject = checkKeywords(localObject2, arrayOfExpression1, i19, localClassType);
              if ((2 * arrayOfObject.length != arrayOfExpression1.length - i19) && (ClassMethods.selectApplicable(ClassMethods.getMethods(localObject2, "add", 'V', null, localInvoke1.language), 2) <= 0))
                break label1707;
              localStringBuffer3 = null;
              int i20 = 0;
              if (i20 >= arrayOfObject.length)
                break label1176;
              if ((arrayOfObject[i20] instanceof String))
              {
                if (localStringBuffer3 == null)
                {
                  localStringBuffer3 = new StringBuffer();
                  localStringBuffer3.append("no field or setter ");
                  localStringBuffer3.append('`');
                  Object localObject8 = arrayOfObject[i20];
                  localStringBuffer3.append(localObject8);
                  localStringBuffer3.append('\'');
                }
              }
              else
              {
                i20++;
                continue;
                if (localCompilation.curClass != null)
                {
                  localClassType = localCompilation.curClass;
                  break;
                }
                localClassType = localCompilation.mainClass;
              }
            }
            catch (Exception localException)
            {
              localCompilation.error('w', "unknown class: " + ((ObjectType)localObject1).getName());
              return paramApplyExp;
            }
            localStringBuffer3.append(", ");
          }
          if (localStringBuffer3 != null)
          {
            localStringBuffer3.append(" in class ");
            String str7 = ((ObjectType)localObject1).getName();
            localStringBuffer3.append(str7);
            localCompilation.error('w', localStringBuffer3.toString());
            return paramApplyExp;
          }
          ApplyExp localApplyExp2;
          int i21;
          Object localObject7;
          Type localType3;
          if (i19 < arrayOfExpression1.length)
          {
            Expression[] arrayOfExpression6 = new Expression[i19];
            System.arraycopy(arrayOfExpression1, 0, arrayOfExpression6, 0, i19);
            ApplyExp localApplyExp4 = new ApplyExp(paramApplyExp.getFunction(), arrayOfExpression6);
            localApplyExp2 = (ApplyExp)paramInlineCalls.visit(localApplyExp4, localObject2);
            localApplyExp2.setType(localObject2);
            localObject4 = localApplyExp2;
            if (arrayOfExpression1.length <= 0)
              break label1695;
            i21 = 0;
            localObject5 = localApplyExp2;
            int i22 = arrayOfObject.length;
            if (i21 >= i22)
              break label1495;
            localObject7 = arrayOfObject[i21];
            if (!(localObject7 instanceof Method))
              break label1468;
            localType3 = ((Method)localObject7).getParameterTypes()[0];
          }
          while (true)
          {
            if (localType3 != null)
              localType3 = localInvoke1.language.getLangTypeFor(localType3);
            Expression localExpression2 = paramInlineCalls.visit(arrayOfExpression1[(1 + (i19 + i21 * 2))], localType3);
            Expression[] arrayOfExpression5 = new Expression[3];
            arrayOfExpression5[0] = localObject5;
            arrayOfExpression5[1] = new QuoteExp(localObject7);
            arrayOfExpression5[2] = localExpression2;
            ApplyExp localApplyExp3 = new ApplyExp(SlotSet.setFieldReturnObject, arrayOfExpression5);
            localApplyExp3.setType(localObject2);
            i21++;
            localObject5 = localApplyExp3;
            break label1297;
            PrimProcedure localPrimProcedure3 = arrayOfPrimProcedure[0];
            Expression[] arrayOfExpression3 = { localExpression1 };
            localApplyExp2 = new ApplyExp(localPrimProcedure3, arrayOfExpression3);
            break;
            if ((localObject7 instanceof Field))
              localType3 = ((Field)localObject7).getType();
            else
              localType3 = null;
          }
          if (i19 == arrayOfExpression1.length);
          LetExp localLetExp1;
          Declaration localDeclaration1;
          BeginExp localBeginExp1;
          for (int i23 = 1; ; i23 = i19 + 2 * arrayOfObject.length)
          {
            localObject6 = localObject5;
            int i24 = arrayOfExpression1.length;
            if (i23 >= i24)
              break label2776;
            localLetExp1 = new LetExp(new Expression[] { localObject6 });
            localDeclaration1 = localLetExp1.addDeclaration((String)null, localObject2);
            localDeclaration1.noteValue(localObject6);
            localBeginExp1 = new BeginExp();
            for (int i25 = i23; i25 < arrayOfExpression1.length; i25++)
            {
              Expression[] arrayOfExpression4 = new Expression[3];
              ReferenceExp localReferenceExp2 = new ReferenceExp(localDeclaration1);
              arrayOfExpression4[0] = localReferenceExp2;
              arrayOfExpression4[1] = QuoteExp.getInstance("add");
              arrayOfExpression4[2] = arrayOfExpression1[i25];
              localBeginExp1.add(paramInlineCalls.visit(new ApplyExp(Invoke.invoke, arrayOfExpression4), null));
            }
          }
          ReferenceExp localReferenceExp1 = new ReferenceExp(localDeclaration1);
          localBeginExp1.add(localReferenceExp1);
          localLetExp1.body = localBeginExp1;
          localObject4 = localLetExp1;
          return paramInlineCalls.checkType(((Expression)localObject4).setLine(paramApplyExp), paramType);
          int i1;
          int i2;
          StringBuilder localStringBuilder;
          char c4;
          if (n >= 0)
          {
            int i12 = 1;
            if (i12 < i)
            {
              int i13;
              Object localObject3;
              if (i12 == i - 1)
              {
                i13 = 1;
                if (((c1 != 'P') || (i12 != 2)) && ((c1 == 'N') || (i12 != 1)))
                  break label1791;
                localObject3 = null;
              }
              while (true)
              {
                arrayOfExpression1[i12] = paramInlineCalls.visit(arrayOfExpression1[i12], (Type)localObject3);
                i12++;
                break;
                i13 = 0;
                break label1734;
                if ((c1 == 'P') && (i12 == 1))
                {
                  localObject3 = localObject2;
                }
                else
                {
                  localObject3 = null;
                  if (n > 0)
                  {
                    int i14;
                    int i16;
                    PrimProcedure localPrimProcedure2;
                    int i17;
                    int i18;
                    if (c1 == 'N')
                    {
                      i14 = 1;
                      int i15 = i12 - i14;
                      i16 = 0;
                      if (i16 < n)
                      {
                        localPrimProcedure2 = arrayOfPrimProcedure[i16];
                        if ((c1 == 'S') || (!localPrimProcedure2.takesTarget()))
                          break label1922;
                        i17 = 1;
                        i18 = i17 + i15;
                        if ((i13 == 0) || (!localPrimProcedure2.takesVarArgs()) || (i18 != localPrimProcedure2.minArgs()))
                          break label1928;
                        localObject3 = null;
                      }
                    }
                    while (true)
                    {
                      if (localObject3 == null)
                        break label1978;
                      i16++;
                      break label1839;
                      break;
                      i14 = k;
                      break label1829;
                      i17 = 0;
                      break label1871;
                      Type localType2 = localPrimProcedure2.getParameterType(i18);
                      if (i16 == 0)
                        localObject3 = localType2;
                      else if (localType2 instanceof PrimType != localObject3 instanceof PrimType)
                        localObject3 = null;
                      else
                        localObject3 = Type.lowestCommonSuperType((Type)localObject3, localType2);
                    }
                  }
                }
              }
            }
            long l2 = selectApplicable(arrayOfPrimProcedure, localObject2, arrayOfExpression1, j, k, m);
            i1 = (int)(l2 >> 32);
            i2 = (int)l2;
            int i3 = arrayOfPrimProcedure.length;
            if ((i1 + i2 == 0) && (c1 == 'N'))
            {
              Invoke localInvoke2 = Invoke.invokeStatic;
              arrayOfPrimProcedure = getMethods(localObject2, "valueOf", localClassType, localInvoke2);
              k = 1;
              j = i - 1;
              long l1 = selectApplicable(arrayOfPrimProcedure, localObject2, arrayOfExpression1, j, k, -1);
              int i11 = (int)(l1 >> 32);
              i2 = (int)l1;
              i1 = i11;
            }
            if (i1 + i2 != 0)
              break label2395;
            if ((c1 != 'P') && (!localCompilation.warnInvokeUnknownMethod()))
              break label2700;
            if (c1 != 'N')
              break label2769;
            str5 = str1 + "/valueOf";
            localStringBuilder = new StringBuilder();
            if (i3 + arrayOfPrimProcedure.length != 0)
              break label2336;
            localStringBuilder.append("no accessible method '");
            localStringBuilder.append(str5);
            localStringBuilder.append("' in ");
            localStringBuilder.append(((ObjectType)localObject1).getName());
            if (c1 != 'P')
              break label2388;
            c4 = 'e';
            String str6 = localStringBuilder.toString();
            localCompilation.error(c4, str6);
            str2 = str5;
            i4 = -1;
          }
          while (true)
            if (i4 >= 0)
            {
              Expression[] arrayOfExpression2 = new Expression[j];
              PrimProcedure localPrimProcedure1 = arrayOfPrimProcedure[i4];
              localPrimProcedure1.takesVarArgs();
              int i5 = 0;
              if (m >= 0)
              {
                int i8 = 0 + 1;
                arrayOfExpression2[0] = arrayOfExpression1[m];
                i5 = i8;
              }
              int i6 = k;
              while (true)
                if (i6 < arrayOfExpression1.length)
                {
                  int i7 = arrayOfExpression2.length;
                  if (i5 < i7)
                  {
                    arrayOfExpression2[i5] = arrayOfExpression1[i6];
                    i6++;
                    i5++;
                    continue;
                    i1 = 0;
                    i2 = 0;
                    break;
                    label2336: if (n == -983040)
                    {
                      localStringBuilder.append("too few arguments for method '");
                      break label2171;
                    }
                    if (n == -917504)
                    {
                      localStringBuilder.append("too many arguments for method '");
                      break label2171;
                    }
                    localStringBuilder.append("no possibly applicable method '");
                    break label2171;
                    c4 = 'w';
                    break label2210;
                    if ((i1 == 1) || ((i1 == 0) && (i2 == 1)))
                    {
                      str2 = str1;
                      i4 = 0;
                      break label2233;
                    }
                    if (i1 > 0)
                    {
                      i9 = MethodProc.mostSpecific(arrayOfPrimProcedure, i1);
                      if ((i9 >= 0) || (c1 != 'S'))
                        break label2762;
                      int i10 = 0;
                      label2451: if (i10 >= i1)
                        break label2762;
                      label2477: StringBuffer localStringBuffer2;
                      if (arrayOfPrimProcedure[i10].getStaticFlag())
                        if (i9 >= 0)
                        {
                          i4 = -1;
                          if ((i4 >= 0) || ((c1 != 'P') && (!localCompilation.warnInvokeUnknownMethod())))
                            break label2755;
                          localStringBuffer2 = new StringBuffer();
                          localStringBuffer2.append("more than one definitely applicable method `");
                          localStringBuffer2.append(str1);
                          localStringBuffer2.append("' in ");
                          localStringBuffer2.append(((ObjectType)localObject1).getName());
                          append(arrayOfPrimProcedure, i1, localStringBuffer2);
                          if (c1 != 'P')
                            break label2596;
                        }
                      label2596: for (char c3 = 'e'; ; c3 = 'w')
                      {
                        String str4 = localStringBuffer2.toString();
                        localCompilation.error(c3, str4);
                        str2 = str1;
                        break;
                        i9 = i10;
                        i10++;
                        break label2451;
                      }
                    }
                    StringBuffer localStringBuffer1;
                    if ((c1 == 'P') || (localCompilation.warnInvokeUnknownMethod()))
                    {
                      localStringBuffer1 = new StringBuffer();
                      localStringBuffer1.append("more than one possibly applicable method '");
                      localStringBuffer1.append(str1);
                      localStringBuffer1.append("' in ");
                      localStringBuffer1.append(((ObjectType)localObject1).getName());
                      append(arrayOfPrimProcedure, i2, localStringBuffer1);
                      if (c1 != 'P')
                        break label2710;
                    }
                    label2700: label2710: for (char c2 = 'e'; ; c2 = 'w')
                    {
                      String str3 = localStringBuffer1.toString();
                      localCompilation.error(c2, str3);
                      i4 = -1;
                      str2 = str1;
                      break;
                    }
                  }
                }
              ApplyExp localApplyExp1 = new ApplyExp(localPrimProcedure1, arrayOfExpression2);
              localApplyExp1.setLine(paramApplyExp);
              return paramInlineCalls.visitApplyOnly(localApplyExp1, paramType);
            }
        }
        while (true)
        {
          paramApplyExp.visitArgs(paramInlineCalls);
          return paramApplyExp;
          label2755: str2 = str1;
          break label2233;
          label2762: i4 = i9;
          break label2477;
          label2769: str5 = str1;
          break label2144;
          label2776: localObject4 = localObject6;
          break;
        }
      }
      label2796: i26 = 0;
      localExpression3 = null;
      continue;
      label2805: i26 = 0;
      localExpression3 = null;
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.CompileInvoke
 * JD-Core Version:    0.6.2
 */