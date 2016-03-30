package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Language;
import gnu.expr.NameLookup;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Environment;
import gnu.mapping.HasNamedParts;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Translator;

public class CompileNamedPart
{
  static final ClassType typeHasNamedParts = ClassType.make("gnu.mapping.HasNamedParts");

  public static String combineName(Expression paramExpression1, Expression paramExpression2)
  {
    Object localObject = paramExpression2.valueIfConstant();
    if ((localObject instanceof SimpleSymbol))
    {
      String str;
      if ((paramExpression1 instanceof ReferenceExp))
      {
        str = ((ReferenceExp)paramExpression1).getSimpleName();
        if (str != null);
      }
      else
      {
        if (!(paramExpression1 instanceof GetNamedExp))
          break label77;
        str = ((GetNamedExp)paramExpression1).combinedName;
        if (str == null)
          break label77;
      }
      return (str + ':' + localObject).intern();
    }
    label77: return null;
  }

  public static Expression makeExp(Type paramType, String paramString)
  {
    return makeExp(new QuoteExp(paramType), new QuoteExp(paramString));
  }

  public static Expression makeExp(Expression paramExpression1, Expression paramExpression2)
  {
    String str1 = combineName(paramExpression1, paramExpression2);
    Environment localEnvironment = Environment.getCurrent();
    if (str1 != null)
    {
      Translator localTranslator = (Translator)Compilation.getCurrent();
      Symbol localSymbol2 = Namespace.EmptyNamespace.getSymbol(str1);
      Declaration localDeclaration = localTranslator.lexical.lookup(localSymbol2, false);
      if (!Declaration.isUnknown(localDeclaration))
        return new ReferenceExp(localDeclaration);
      if ((localSymbol2 != null) && (localEnvironment.isBound(localSymbol2, null)))
        return new ReferenceExp(str1);
    }
    ReferenceExp localReferenceExp;
    Object localObject;
    Symbol localSymbol1;
    if ((paramExpression1 instanceof ReferenceExp))
    {
      localReferenceExp = (ReferenceExp)paramExpression1;
      if (localReferenceExp.isUnknown())
      {
        localObject = localReferenceExp.getSymbol();
        if (!(localObject instanceof Symbol))
          break label192;
        localSymbol1 = (Symbol)localObject;
      }
    }
    while (true)
    {
      String str2;
      if (localEnvironment.get(localSymbol1, null) == null)
        str2 = localReferenceExp.getName();
      try
      {
        QuoteExp localQuoteExp = QuoteExp.getInstance(Type.make(ClassType.getContextClass(str2)));
        paramExpression1 = localQuoteExp;
        label162: GetNamedExp localGetNamedExp = new GetNamedExp(new Expression[] { paramExpression1, paramExpression2 });
        localGetNamedExp.combinedName = str1;
        return localGetNamedExp;
        label192: localSymbol1 = localEnvironment.getSymbol(localObject.toString());
      }
      catch (Throwable localThrowable)
      {
        break label162;
      }
    }
  }

  public static Expression makeExp(Expression paramExpression, String paramString)
  {
    return makeExp(paramExpression, new QuoteExp(paramString));
  }

  public static Expression makeGetNamedInstancePartExp(Expression paramExpression)
  {
    if ((paramExpression instanceof QuoteExp))
    {
      Object localObject = ((QuoteExp)paramExpression).getValue();
      if ((localObject instanceof SimpleSymbol))
        return QuoteExp.getInstance(new GetNamedInstancePart(localObject.toString()));
    }
    Expression[] arrayOfExpression = new Expression[2];
    arrayOfExpression[0] = new QuoteExp(ClassType.make("gnu.kawa.functions.GetNamedInstancePart"));
    arrayOfExpression[1] = paramExpression;
    return new ApplyExp(Invoke.make, arrayOfExpression);
  }

  public static Expression validateGetNamedInstancePart(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    GetNamedInstancePart localGetNamedInstancePart = (GetNamedInstancePart)paramProcedure;
    Expression[] arrayOfExpression2;
    if (localGetNamedInstancePart.isField)
    {
      arrayOfExpression2 = new Expression[2];
      arrayOfExpression2[0] = arrayOfExpression1[0];
      arrayOfExpression2[1] = new QuoteExp(localGetNamedInstancePart.pname);
    }
    for (Object localObject = SlotGet.field; ; localObject = Invoke.invoke)
    {
      return paramInlineCalls.visitApplyOnly(new ApplyExp((Procedure)localObject, arrayOfExpression2), paramType);
      int i = arrayOfExpression1.length;
      arrayOfExpression2 = new Expression[i + 1];
      arrayOfExpression2[0] = arrayOfExpression1[0];
      arrayOfExpression2[1] = new QuoteExp(localGetNamedInstancePart.pname);
      System.arraycopy(arrayOfExpression1, 1, arrayOfExpression2, 2, i - 1);
    }
  }

  public static Expression validateGetNamedPart(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    if ((arrayOfExpression1.length != 2) || (!(arrayOfExpression1[1] instanceof QuoteExp)) || (!(paramApplyExp instanceof GetNamedExp)))
      return paramApplyExp;
    Expression localExpression = arrayOfExpression1[0];
    ReferenceExp localReferenceExp;
    if ((localExpression instanceof ReferenceExp))
    {
      localReferenceExp = (ReferenceExp)localExpression;
      if ("*".equals(localReferenceExp.getName()))
        return makeGetNamedInstancePartExp(arrayOfExpression1[1]);
    }
    for (Declaration localDeclaration = localReferenceExp.getBinding(); ; localDeclaration = null)
    {
      String str = ((QuoteExp)arrayOfExpression1[1]).getValue().toString();
      Type localType1 = localExpression.getType();
      Compilation localCompilation;
      Language localLanguage;
      Type localType2;
      ClassType localClassType;
      if (localExpression == QuoteExp.nullExp)
      {
        localCompilation = paramInlineCalls.getCompilation();
        localLanguage = localCompilation.getLanguage();
        localType2 = localLanguage.getTypeFor(localExpression, false);
        if (localCompilation != null)
          break label181;
        localClassType = null;
      }
      GetNamedExp localGetNamedExp;
      while (true)
      {
        localGetNamedExp = (GetNamedExp)paramApplyExp;
        if (localType2 == null)
          break label274;
        if (!str.equals("<>"))
          break label209;
        return new QuoteExp(localType2);
        break;
        label181: if (localCompilation.curClass != null)
          localClassType = localCompilation.curClass;
        else
          localClassType = localCompilation.mainClass;
      }
      label209: if ((localType2 instanceof ObjectType))
      {
        if (str.equals("new"))
          return localGetNamedExp.setProcedureKind('N');
        if (str.equals("instance?"))
          return localGetNamedExp.setProcedureKind('I');
        if (str.equals("@"))
          return localGetNamedExp.setProcedureKind('C');
      }
      label274: if ((localType2 instanceof ObjectType))
      {
        if ((str.length() > 1) && (str.charAt(0) == '.'))
          return new QuoteExp(new NamedPart(localType2, str, 'D'));
        if (CompileReflect.checkKnownClass(localType2, localCompilation) < 0)
          return paramApplyExp;
        PrimProcedure[] arrayOfPrimProcedure2 = ClassMethods.getMethods((ObjectType)localType2, Compilation.mangleName(str), '\000', localClassType, localLanguage);
        if ((arrayOfPrimProcedure2 != null) && (arrayOfPrimProcedure2.length > 0))
        {
          localGetNamedExp.methods = arrayOfPrimProcedure2;
          return localGetNamedExp.setProcedureKind('S');
        }
        ApplyExp localApplyExp2 = new ApplyExp(SlotGet.staticField, arrayOfExpression1);
        localApplyExp2.setLine(paramApplyExp);
        return paramInlineCalls.visitApplyOnly(localApplyExp2, paramType);
      }
      if ((localType2 == null) || ((localType1.isSubtype(Compilation.typeClassType)) || (localType1.isSubtype(Type.javalangClassType))))
        return paramApplyExp;
      if ((localType1 instanceof ObjectType))
      {
        ObjectType localObjectType = (ObjectType)localType1;
        PrimProcedure[] arrayOfPrimProcedure1 = ClassMethods.getMethods(localObjectType, Compilation.mangleName(str), 'V', localClassType, localLanguage);
        if ((arrayOfPrimProcedure1 != null) && (arrayOfPrimProcedure1.length > 0))
        {
          localGetNamedExp.methods = arrayOfPrimProcedure1;
          return localGetNamedExp.setProcedureKind('M');
        }
        if (localType1.isSubtype(typeHasNamedParts))
        {
          if (localDeclaration != null)
          {
            Object localObject = Declaration.followAliases(localDeclaration).getConstantValue();
            if (localObject != null)
            {
              HasNamedParts localHasNamedParts = (HasNamedParts)localObject;
              if (localHasNamedParts.isConstant(str))
                return QuoteExp.getInstance(localHasNamedParts.get(str));
            }
          }
          Expression[] arrayOfExpression2 = new Expression[2];
          arrayOfExpression2[0] = arrayOfExpression1[0];
          arrayOfExpression2[1] = QuoteExp.getInstance(str);
          return new ApplyExp(typeHasNamedParts.getDeclaredMethod("get", 1), arrayOfExpression2).setLine(paramApplyExp);
        }
        if ((SlotGet.lookupMember(localObjectType, str, localClassType) != null) || ((str.equals("length")) && ((localType1 instanceof ArrayType))))
        {
          ApplyExp localApplyExp1 = new ApplyExp(SlotGet.field, arrayOfExpression1);
          localApplyExp1.setLine(paramApplyExp);
          return paramInlineCalls.visitApplyOnly(localApplyExp1, paramType);
        }
      }
      if (localCompilation.warnUnknownMember())
        localCompilation.error('w', "no known slot '" + str + "' in " + localType1.getName());
      return paramApplyExp;
    }
  }

  public static Expression validateNamedPart(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    NamedPart localNamedPart = (NamedPart)paramProcedure;
    switch (localNamedPart.kind)
    {
    default:
      return paramApplyExp;
    case 'D':
    }
    String str = localNamedPart.member.toString().substring(1);
    Expression[] arrayOfExpression2 = new Expression[2];
    arrayOfExpression2[1] = QuoteExp.getInstance(str);
    if (arrayOfExpression1.length > 0)
      arrayOfExpression2[0] = Compilation.makeCoercion(arrayOfExpression1[0], new QuoteExp(localNamedPart.container));
    for (SlotGet localSlotGet = SlotGet.field; ; localSlotGet = SlotGet.staticField)
    {
      ApplyExp localApplyExp = new ApplyExp(localSlotGet, arrayOfExpression2);
      localApplyExp.setLine(paramApplyExp);
      return paramInlineCalls.visitApplyOnly(localApplyExp, paramType);
      arrayOfExpression2[0] = QuoteExp.getInstance(localNamedPart.container);
    }
  }

  public static Expression validateNamedPartSetter(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    NamedPart localNamedPart = (NamedPart)((NamedPartSetter)paramProcedure).getGetter();
    if (localNamedPart.kind == 'D')
    {
      Expression[] arrayOfExpression = new Expression[3];
      arrayOfExpression[1] = QuoteExp.getInstance(localNamedPart.member.toString().substring(1));
      arrayOfExpression[2] = paramApplyExp.getArgs()[0];
      if (paramApplyExp.getArgCount() == 1)
        arrayOfExpression[0] = QuoteExp.getInstance(localNamedPart.container);
      for (SlotSet localSlotSet = SlotSet.set$Mnstatic$Mnfield$Ex; ; localSlotSet = SlotSet.set$Mnfield$Ex)
      {
        ApplyExp localApplyExp = new ApplyExp(localSlotSet, arrayOfExpression);
        localApplyExp.setLine(paramApplyExp);
        return paramInlineCalls.visitApplyOnly(localApplyExp, paramType);
        if (paramApplyExp.getArgCount() != 2)
          break;
        arrayOfExpression[0] = Compilation.makeCoercion(paramApplyExp.getArgs()[0], new QuoteExp(localNamedPart.container));
      }
      return paramApplyExp;
    }
    return paramApplyExp;
  }

  public static Expression validateSetNamedInstancePart(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression1 = paramApplyExp.getArgs();
    String str = ((SetNamedInstancePart)paramProcedure).pname;
    Expression[] arrayOfExpression2 = new Expression[3];
    arrayOfExpression2[0] = arrayOfExpression1[0];
    arrayOfExpression2[1] = new QuoteExp(str);
    arrayOfExpression2[2] = arrayOfExpression1[1];
    return paramInlineCalls.visitApplyOnly(new ApplyExp(SlotSet.set$Mnfield$Ex, arrayOfExpression2), paramType);
  }

  public static Expression validateSetNamedPart(ApplyExp paramApplyExp, InlineCalls paramInlineCalls, Type paramType, Procedure paramProcedure)
  {
    paramApplyExp.visitArgs(paramInlineCalls);
    Expression[] arrayOfExpression = paramApplyExp.getArgs();
    if ((arrayOfExpression.length != 3) || (!(arrayOfExpression[1] instanceof QuoteExp)))
      return paramApplyExp;
    Expression localExpression = arrayOfExpression[0];
    String str = ((QuoteExp)arrayOfExpression[1]).getValue().toString();
    Type localType1 = localExpression.getType();
    Compilation localCompilation = paramInlineCalls.getCompilation();
    Type localType2 = localCompilation.getLanguage().getTypeFor(localExpression);
    ClassType localClassType;
    ApplyExp localApplyExp;
    if (localCompilation == null)
    {
      localClassType = null;
      localApplyExp = paramApplyExp;
      if (!(localType2 instanceof ClassType))
        break label158;
    }
    for (paramApplyExp = new ApplyExp(SlotSet.set$Mnstatic$Mnfield$Ex, arrayOfExpression); ; paramApplyExp = new ApplyExp(SlotSet.set$Mnfield$Ex, arrayOfExpression))
      label158: 
      do
      {
        if (paramApplyExp != localApplyExp)
          paramApplyExp.setLine(localApplyExp);
        paramApplyExp.setType(Type.voidType);
        return paramApplyExp;
        if (localCompilation.curClass != null)
        {
          localClassType = localCompilation.curClass;
          break;
        }
        localClassType = localCompilation.mainClass;
        break;
      }
      while ((!(localType1 instanceof ClassType)) || (SlotSet.lookupMember((ClassType)localType1, str, localClassType) == null));
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.functions.CompileNamedPart
 * JD-Core Version:    0.6.2
 */