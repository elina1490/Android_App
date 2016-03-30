package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.ArrayGet;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.math.Numeric;
import gnu.text.Char;
import java.io.Externalizable;

public class CompilationHelpers
{
  public static final Declaration setterDecl;
  static final Field setterField;
  static final ClassType setterType;
  static final ClassType typeList = ClassType.make("java.util.List");

  static
  {
    setterType = ClassType.make("gnu.kawa.functions.Setter");
    setterField = setterType.getDeclaredField("setter");
    setterDecl = new Declaration("setter", setterField);
    setterDecl.noteValue(new QuoteExp(Setter.setter));
  }

  private static boolean nonNumeric(Expression paramExpression)
  {
    if ((paramExpression instanceof QuoteExp))
    {
      Object localObject = ((QuoteExp)paramExpression).getValue();
      return (!(localObject instanceof Numeric)) && (!(localObject instanceof Char)) && (!(localObject instanceof Symbol));
    }
    return false;
  }

  public static Expression validateApplyToArgs(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    int i = arrayOfExpression1.length - 1;
    Expression localExpression2;
    Type localType;
    Language localLanguage;
    ApplyExp localApplyExp1;
    if (i >= 0)
    {
      Expression localExpression1 = arrayOfExpression1[0];
      if (!localExpression1.getFlag(1))
      {
        if ((localExpression1 instanceof LambdaExp))
        {
          Expression[] arrayOfExpression3 = new Expression[i];
          System.arraycopy(arrayOfExpression1, 1, arrayOfExpression3, 0, i);
          return paramInlineCalls.visit(new ApplyExp(localExpression1, arrayOfExpression3).setLine(paramApplyExp), paramType);
        }
        localExpression1 = paramInlineCalls.visit(localExpression1, null);
        arrayOfExpression1[0] = localExpression1;
      }
      localExpression2 = localExpression1;
      localType = localExpression2.getType().getRealType();
      Compilation localCompilation = paramInlineCalls.getCompilation();
      localLanguage = localCompilation.getLanguage();
      if (localType.isSubtype(Compilation.typeProcedure))
      {
        Expression[] arrayOfExpression2 = new Expression[i];
        System.arraycopy(arrayOfExpression1, 1, arrayOfExpression2, 0, i);
        ApplyExp localApplyExp2 = new ApplyExp(localExpression2, arrayOfExpression2);
        localApplyExp2.setLine(paramApplyExp);
        return localExpression2.validateApply(localApplyExp2, paramInlineCalls, paramType, null);
      }
      if (CompileReflect.checkKnownClass(localType, localCompilation) < 0)
        localApplyExp1 = null;
    }
    while (true)
      if (localApplyExp1 != null)
      {
        localApplyExp1.setLine(paramApplyExp);
        return paramInlineCalls.visitApplyOnly(localApplyExp1, paramType);
        if ((localType.isSubtype(Compilation.typeType)) || (localLanguage.getTypeFor(localExpression2, false) != null))
        {
          localApplyExp1 = new ApplyExp(Invoke.make, arrayOfExpression1);
        }
        else if ((localType instanceof ArrayType))
        {
          localApplyExp1 = new ApplyExp(new ArrayGet(((ArrayType)localType).getComponentType()), arrayOfExpression1);
        }
        else if ((localType instanceof ClassType))
        {
          ClassType localClassType = (ClassType)localType;
          if ((localClassType.isSubclass(typeList)) && (i == 1))
          {
            Type[] arrayOfType = new Type[1];
            arrayOfType[0] = Type.intType;
            localApplyExp1 = new ApplyExp(localClassType.getMethod("get", arrayOfType), arrayOfExpression1);
          }
        }
      }
      else
      {
        paramApplyExp.visitArgs(paramInlineCalls);
        return paramApplyExp;
        localApplyExp1 = null;
      }
  }

  public static Expression validateIsEqv(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if ((nonNumeric(arrayOfExpression[0])) || (nonNumeric(arrayOfExpression[1])))
      return new ApplyExp(((IsEqv)paramProcedure).isEq, arrayOfExpression);
    return paramApplyExp;
  }

  public static Expression validateSetter(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if (arrayOfExpression.length == 1)
    {
      Expression localExpression = arrayOfExpression[0];
      Type localType = localExpression.getType();
      if ((localType instanceof ArrayType))
        return new SetArrayExp(localExpression, (ArrayType)localType);
      if (((localType instanceof ClassType)) && (((ClassType)localType).isSubclass(typeList)))
      {
        if ((paramApplyExp instanceof SetListExp))
          return paramApplyExp;
        return new SetListExp(paramApplyExp.getFunction(), arrayOfExpression);
      }
      if ((localExpression instanceof ReferenceExp))
      {
        Declaration localDeclaration2 = ((ReferenceExp)localExpression).getBinding();
        if (localDeclaration2 != null)
          localExpression = localDeclaration2.getValue();
      }
      if ((localExpression instanceof QuoteExp))
      {
        Object localObject = ((QuoteExp)localExpression).getValue();
        if ((localObject instanceof Procedure))
        {
          Procedure localProcedure = ((Procedure)localObject).getSetter();
          if ((localProcedure instanceof Procedure))
          {
            if ((localProcedure instanceof Externalizable))
              return new QuoteExp(localProcedure);
            Declaration localDeclaration1 = Declaration.getDeclaration((Procedure)localProcedure);
            if (localDeclaration1 != null)
              return new ReferenceExp(localDeclaration1);
          }
        }
      }
    }
    return paramApplyExp;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.CompilationHelpers
 * JD-Core Version:    0.6.2
 */