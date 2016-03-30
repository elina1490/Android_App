package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Location;
import gnu.mapping.LocationProc;
import gnu.mapping.ProcLocation;
import gnu.mapping.Procedure;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class location extends Syntax
{
  public static final location location = new location();
  private static ClassType thisType = ClassType.make("kawa.standard.location");

  static
  {
    location.setName("location");
  }

  public static Procedure makeLocationProc(Location paramLocation)
  {
    return new LocationProc(paramLocation);
  }

  public static Location makeProcLocation$V(Procedure paramProcedure, Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    if (((paramProcedure instanceof ApplyToArgs)) && (i > 0) && ((paramArrayOfObject[0] instanceof Procedure)))
    {
      Procedure localProcedure = (Procedure)paramArrayOfObject[0];
      if (((localProcedure instanceof LocationProc)) && (i == 1))
        return ((LocationProc)localProcedure).getLocation();
      Object[] arrayOfObject = new Object[i - 1];
      System.arraycopy(paramArrayOfObject, 1, arrayOfObject, 0, arrayOfObject.length);
      return new ProcLocation(localProcedure, arrayOfObject);
    }
    if (((paramProcedure instanceof LocationProc)) && (i == 0))
      return ((LocationProc)paramProcedure).getLocation();
    return new ProcLocation(paramProcedure, paramArrayOfObject);
  }

  public static Expression rewrite(Expression paramExpression, Translator paramTranslator)
  {
    if ((paramExpression instanceof ReferenceExp))
    {
      ReferenceExp localReferenceExp = (ReferenceExp)paramExpression;
      localReferenceExp.setDontDereference(true);
      Declaration localDeclaration1 = localReferenceExp.getBinding();
      if (localDeclaration1 != null)
      {
        localDeclaration1.maybeIndirectBinding(paramTranslator);
        Declaration localDeclaration2 = Declaration.followAliases(localDeclaration1);
        localDeclaration2.setCanRead(true);
        localDeclaration2.setCanWrite(true);
      }
      return localReferenceExp;
    }
    if ((paramExpression instanceof ApplyExp))
    {
      ApplyExp localApplyExp = (ApplyExp)paramExpression;
      Expression[] arrayOfExpression = new Expression[1 + localApplyExp.getArgs().length];
      arrayOfExpression[0] = localApplyExp.getFunction();
      System.arraycopy(localApplyExp.getArgs(), 0, arrayOfExpression, 1, arrayOfExpression.length - 1);
      return Invoke.makeInvokeStatic(thisType, "makeProcLocation", arrayOfExpression);
    }
    return paramTranslator.syntaxError("invalid argument to location");
  }

  public Expression rewrite(Object paramObject, Translator paramTranslator)
  {
    if (!(paramObject instanceof Pair))
      return paramTranslator.syntaxError("missing argument to location");
    Pair localPair = (Pair)paramObject;
    if (localPair.getCdr() != LList.Empty)
      return paramTranslator.syntaxError("extra arguments to location");
    Expression[] arrayOfExpression = new Expression[1];
    arrayOfExpression[0] = rewrite(paramTranslator.rewrite(localPair.getCar()), paramTranslator);
    return Invoke.makeInvokeStatic(thisType, "makeLocationProc", arrayOfExpression);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.location
 * JD-Core Version:    0.6.2
 */