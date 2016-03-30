package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.GenericProc;
import gnu.expr.Language;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.lists.FString;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.util.Vector;

public class ClassMethods extends Procedure2
{
  public static final ClassMethods classMethods = new ClassMethods();

  static
  {
    classMethods.setName("class-methods");
  }

  public static MethodProc apply(ObjectType paramObjectType, String paramString, char paramChar, Language paramLanguage)
  {
    PrimProcedure[] arrayOfPrimProcedure = getMethods(paramObjectType, paramString, paramChar, null, paramLanguage);
    GenericProc localGenericProc = null;
    Object localObject = null;
    for (int i = 0; i < arrayOfPrimProcedure.length; i++)
    {
      PrimProcedure localPrimProcedure = arrayOfPrimProcedure[i];
      if ((localObject != null) && (localGenericProc == null))
      {
        localGenericProc = new GenericProc();
        localGenericProc.add((MethodProc)localObject);
      }
      localObject = localPrimProcedure;
      if (localGenericProc != null)
        localGenericProc.add((MethodProc)localObject);
    }
    if (localGenericProc != null)
    {
      localGenericProc.setName(paramObjectType.getName() + "." + paramString);
      return localGenericProc;
    }
    return localObject;
  }

  public static MethodProc apply(Procedure paramProcedure, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof Class))
      paramObject1 = Type.make((Class)paramObject1);
    ClassType localClassType;
    if ((paramObject1 instanceof ClassType))
      localClassType = (ClassType)paramObject1;
    MethodProc localMethodProc;
    while (((paramObject2 instanceof String)) || ((paramObject2 instanceof FString)) || ((paramObject2 instanceof Symbol)))
    {
      String str = paramObject2.toString();
      if (!"<init>".equals(str))
        str = Compilation.mangleName(str);
      localMethodProc = apply(localClassType, str, '\000', Language.getDefaultLanguage());
      if (localMethodProc != null)
        break label182;
      throw new RuntimeException("no applicable method named `" + str + "' in " + localClassType.getName());
      if (((paramObject1 instanceof String)) || ((paramObject1 instanceof FString)) || ((paramObject1 instanceof Symbol)))
        localClassType = ClassType.make(paramObject1.toString());
      else
        throw new WrongType(paramProcedure, 0, null);
    }
    throw new WrongType(paramProcedure, 1, null);
    label182: return localMethodProc;
  }

  static String checkName(Expression paramExpression)
  {
    if ((paramExpression instanceof QuoteExp))
    {
      Object localObject = ((QuoteExp)paramExpression).getValue();
      if (((localObject instanceof FString)) || ((localObject instanceof String)))
        return localObject.toString();
      if ((localObject instanceof Symbol))
        return ((Symbol)localObject).getName();
      return null;
    }
    return null;
  }

  static String checkName(Expression paramExpression, boolean paramBoolean)
  {
    if ((paramExpression instanceof QuoteExp))
    {
      Object localObject = ((QuoteExp)paramExpression).getValue();
      String str;
      if (((localObject instanceof FString)) || ((localObject instanceof String)))
        str = localObject.toString();
      while (Compilation.isValidJavaName(str))
      {
        return str;
        if ((localObject instanceof Symbol))
          str = ((Symbol)localObject).getName();
        else
          return null;
      }
      return Compilation.mangleName(str, paramBoolean);
    }
    return null;
  }

  public static PrimProcedure[] getMethods(ObjectType paramObjectType, String paramString, char paramChar, ClassType paramClassType, Language paramLanguage)
  {
    if (paramObjectType == Type.tostring_type)
      paramObjectType = Type.string_type;
    ObjectType localObjectType;
    int i;
    label53: Vector localVector;
    int j;
    label70: int k;
    label127: PrimProcedure[] arrayOfPrimProcedure;
    int n;
    int i1;
    label145: int i2;
    Method localMethod1;
    Type localType;
    if (paramChar == 'P')
    {
      localObjectType = null;
      MethodFilter localMethodFilter = new MethodFilter(paramString, 0, 0, paramClassType, localObjectType);
      if ((paramChar != 'P') && (!"<init>".equals(paramString)))
        break label256;
      i = 1;
      localVector = new Vector();
      if (i == 0)
        break label262;
      j = 0;
      paramObjectType.getMethods(localMethodFilter, j, localVector);
      if ((i == 0) && ((!(paramObjectType instanceof ClassType)) || (((ClassType)paramObjectType).isInterface())))
        Type.pointer_type.getMethods(localMethodFilter, 0, localVector);
      if (i == 0)
        break label268;
      k = localVector.size();
      arrayOfPrimProcedure = new PrimProcedure[k];
      int m = k;
      n = 0;
      i1 = m;
      i2 = i1 - 1;
      if (i2 < 0)
        break label278;
      localMethod1 = (Method)localVector.elementAt(i2);
      if ((i != 0) || (localMethod1.getDeclaringClass() == paramObjectType))
        break label281;
      localType = paramObjectType.getImplementationType();
      if (!(localType instanceof ClassType))
        break label281;
    }
    label256: label262: label268: label278: label281: for (Method localMethod2 = new Method(localMethod1, (ClassType)localType); ; localMethod2 = localMethod1)
    {
      PrimProcedure localPrimProcedure = new PrimProcedure(localMethod2, paramChar, paramLanguage);
      int i3 = n + 1;
      arrayOfPrimProcedure[n] = localPrimProcedure;
      n = i3;
      i1 = i2;
      break label145;
      localObjectType = paramObjectType;
      break;
      i = 0;
      break label53;
      j = 2;
      break label70;
      k = removeRedundantMethods(localVector);
      break label127;
      return arrayOfPrimProcedure;
    }
  }

  private static int removeRedundantMethods(Vector paramVector)
  {
    int i = paramVector.size();
    int j = 1;
    while (j < i)
    {
      Method localMethod1 = (Method)paramVector.elementAt(j);
      ClassType localClassType = localMethod1.getDeclaringClass();
      Type[] arrayOfType1 = localMethod1.getParameterTypes();
      int k = arrayOfType1.length;
      int m = 0;
      if (m < j)
      {
        Method localMethod2 = (Method)paramVector.elementAt(m);
        Type[] arrayOfType2 = localMethod2.getParameterTypes();
        if (k != arrayOfType2.length);
        int n;
        do
        {
          m++;
          break;
          n = k;
          do
            n--;
          while ((n >= 0) && (arrayOfType1[n] == arrayOfType2[n]));
        }
        while (n >= 0);
        if (localClassType.isSubtype(localMethod2.getDeclaringClass()))
          paramVector.setElementAt(localMethod1, m);
        paramVector.setElementAt(paramVector.elementAt(i - 1), j);
        i--;
      }
      else
      {
        j++;
      }
    }
    return i;
  }

  public static int selectApplicable(PrimProcedure[] paramArrayOfPrimProcedure, int paramInt)
  {
    int i = paramArrayOfPrimProcedure.length;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    while (n < i)
    {
      int i1 = paramArrayOfPrimProcedure[n].numArgs();
      int i2 = Procedure.minArgs(i1);
      int i3 = Procedure.maxArgs(i1);
      int i4 = 0;
      if (paramInt < i2)
        k++;
      while (true)
      {
        if (i4 == 0)
          break label95;
        m++;
        n++;
        break;
        if ((paramInt > i3) && (i3 >= 0))
        {
          j++;
          i4 = 0;
        }
        else
        {
          i4 = 1;
        }
      }
      label95: PrimProcedure localPrimProcedure = paramArrayOfPrimProcedure[(i - 1)];
      paramArrayOfPrimProcedure[(i - 1)] = paramArrayOfPrimProcedure[n];
      paramArrayOfPrimProcedure[n] = localPrimProcedure;
      i--;
    }
    if (m > 0)
      return m;
    if (k > 0)
      return -983040;
    if (j > 0)
      return -917504;
    return 0;
  }

  public static long selectApplicable(PrimProcedure[] paramArrayOfPrimProcedure, Type[] paramArrayOfType)
  {
    int i = paramArrayOfPrimProcedure.length;
    int j = 0;
    int k = 0;
    int m = 0;
    while (m < i)
    {
      int n = paramArrayOfPrimProcedure[m].isApplicable(paramArrayOfType);
      if (n < 0)
      {
        PrimProcedure localPrimProcedure2 = paramArrayOfPrimProcedure[(i - 1)];
        paramArrayOfPrimProcedure[(i - 1)] = paramArrayOfPrimProcedure[m];
        paramArrayOfPrimProcedure[m] = localPrimProcedure2;
        i--;
      }
      else if (n > 0)
      {
        PrimProcedure localPrimProcedure1 = paramArrayOfPrimProcedure[j];
        paramArrayOfPrimProcedure[j] = paramArrayOfPrimProcedure[m];
        paramArrayOfPrimProcedure[m] = localPrimProcedure1;
        j++;
        m++;
      }
      else
      {
        k++;
        m++;
      }
    }
    return (j << 32) + k;
  }

  public Object apply2(Object paramObject1, Object paramObject2)
  {
    return apply(this, paramObject1, paramObject2);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.ClassMethods
 * JD-Core Version:    0.6.2
 */