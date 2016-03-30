package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.lists.ItemPredicate;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class OccurrenceType extends ObjectType
  implements Externalizable, TypeValue
{
  public static final Type emptySequenceType = getInstance(SingletonType.instance, 0, 0);
  static final Method isInstanceMethod = typeOccurrenceType.getDeclaredMethod("isInstance", 1);
  public static final ClassType typeOccurrenceType = ClassType.make("gnu.kawa.reflect.OccurrenceType");
  Type base;
  int maxOccurs;
  int minOccurs;

  public OccurrenceType(Type paramType, int paramInt1, int paramInt2)
  {
    this.base = paramType;
    this.minOccurs = paramInt1;
    this.maxOccurs = paramInt2;
  }

  public static Type getInstance(Type paramType, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 1))
      return paramType;
    if ((paramInt1 == 0) && (paramInt2 < 0) && ((paramType == SingletonType.instance) || (paramType == Type.pointer_type)))
      return Type.pointer_type;
    return new OccurrenceType(paramType, paramInt1, paramInt2);
  }

  public static char itemCountCode(Type paramType)
  {
    int i = itemCountRange(paramType);
    int j = i & 0xFFF;
    int k = i >> 12;
    if (k == 0)
      return '0';
    if (j == 0)
    {
      if (k == 1)
        return '?';
      return '*';
    }
    if ((j == 1) && (k == 1))
      return '1';
    return '+';
  }

  public static boolean itemCountIsOne(Type paramType)
  {
    return itemCountRange(paramType) == 4097;
  }

  public static boolean itemCountIsZeroOrOne(Type paramType)
  {
    return itemCountRange(paramType) >> 13 == 0;
  }

  public static int itemCountRange(Type paramType)
  {
    if ((paramType instanceof SingletonType))
      return 4097;
    if ((paramType instanceof OccurrenceType))
    {
      OccurrenceType localOccurrenceType = (OccurrenceType)paramType;
      int i = localOccurrenceType.minOccurs();
      int j = localOccurrenceType.maxOccurs();
      int k = itemCountRange(localOccurrenceType.getBase());
      if (((i == 1) && (j == 1)) || (k == 0))
        return k;
      if (j > 1048575)
        j = -1;
      if (j == 0)
        return 0;
      int m = k & 0xFFF;
      int n = k >> 12;
      if (k != 4097)
      {
        if (i > 4095)
          i = 4095;
        i *= m;
        if (i > 4095)
          i = 4095;
        if ((j >= 0) && (n >= 0))
          break label150;
        j = -1;
      }
      while (true)
      {
        if (j > 1048575)
          j = -1;
        return i | j << 12;
        label150: j *= n;
      }
    }
    if ((paramType instanceof PrimType))
    {
      if (paramType.isVoid())
        return 0;
      return 4097;
    }
    if ((paramType instanceof ArrayType))
      return 4097;
    if (((paramType instanceof ObjectType)) && (paramType.compare(Compilation.typeValues) == -3))
      return 4097;
    return -4096;
  }

  public static Type itemPrimeType(Type paramType)
  {
    while ((paramType instanceof OccurrenceType))
      paramType = ((OccurrenceType)paramType).getBase();
    if (itemCountIsOne(paramType))
      return paramType;
    return SingletonType.instance;
  }

  public Object coerceFromObject(Object paramObject)
  {
    if ((paramObject instanceof Values));
    while (!isInstance(paramObject))
    {
      throw new ClassCastException();
      if ((this.minOccurs <= 1) && (this.maxOccurs != 0))
        return this.base.coerceFromObject(paramObject);
    }
    return paramObject;
  }

  public int compare(Type paramType)
  {
    if ((paramType instanceof OccurrenceType))
    {
      OccurrenceType localOccurrenceType = (OccurrenceType)paramType;
      if ((this.minOccurs == localOccurrenceType.minOccurs) && (this.maxOccurs == localOccurrenceType.maxOccurs))
        return this.base.compare(localOccurrenceType.getBase());
    }
    return -2;
  }

  public Expression convertValue(Expression paramExpression)
  {
    return null;
  }

  public void emitIsInstance(Variable paramVariable, Compilation paramCompilation, Target paramTarget)
  {
    InstanceOf.emitIsInstance(this, paramVariable, paramCompilation, paramTarget);
  }

  public void emitTestIf(Variable paramVariable, Declaration paramDeclaration, Compilation paramCompilation)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    if (paramVariable != null)
      localCodeAttr.emitLoad(paramVariable);
    if (paramDeclaration != null)
    {
      localCodeAttr.emitDup();
      paramDeclaration.compileStore(paramCompilation);
    }
    paramCompilation.compileConstant(this);
    localCodeAttr.emitSwap();
    localCodeAttr.emitInvokeVirtual(isInstanceMethod);
    localCodeAttr.emitIfIntNotZero();
  }

  public Type getBase()
  {
    return this.base;
  }

  public Procedure getConstructor()
  {
    return null;
  }

  public Type getImplementationType()
  {
    return Type.pointer_type;
  }

  public boolean isInstance(Object paramObject)
  {
    if ((paramObject instanceof Values))
    {
      Values localValues = (Values)paramObject;
      int i = localValues.startPos();
      boolean bool1 = this.base instanceof ItemPredicate;
      int j = 0;
      if (bool1)
      {
        ItemPredicate localItemPredicate = (ItemPredicate)this.base;
        while (true)
        {
          boolean bool2 = localItemPredicate.isInstancePos(localValues, i);
          i = localValues.nextPos(i);
          if (i == 0)
            return (j >= this.minOccurs) && ((this.maxOccurs < 0) || (j <= this.maxOccurs));
          if (!bool2)
            return false;
          j++;
        }
      }
      Object localObject;
      do
      {
        j++;
        i = localValues.nextPos(i);
        if (i == 0)
          return (j >= this.minOccurs) && ((this.maxOccurs < 0) || (j <= this.maxOccurs));
        localObject = localValues.getPosPrevious(i);
      }
      while (this.base.isInstance(localObject));
      return false;
    }
    if ((this.minOccurs > 1) || (this.maxOccurs == 0))
      return false;
    return this.base.isInstance(paramObject);
  }

  public int maxOccurs()
  {
    return this.maxOccurs;
  }

  public int minOccurs()
  {
    return this.minOccurs;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.base = ((Type)paramObjectInput.readObject());
    this.minOccurs = paramObjectInput.readInt();
    this.maxOccurs = paramObjectInput.readInt();
  }

  public String toString()
  {
    String str = this.base.toString();
    int i;
    StringBuffer localStringBuffer;
    if ((str == null) || (str.indexOf(' ') >= 0))
    {
      i = 1;
      localStringBuffer = new StringBuffer();
      if (i != 0)
        localStringBuffer.append('(');
      localStringBuffer.append(str);
      if (i != 0)
        localStringBuffer.append(')');
      if ((this.minOccurs != 1) || (this.maxOccurs != 1))
        break label85;
    }
    while (true)
    {
      return localStringBuffer.toString();
      i = 0;
      break;
      label85: if ((this.minOccurs == 0) && (this.maxOccurs == 1))
      {
        localStringBuffer.append('?');
      }
      else if ((this.minOccurs == 1) && (this.maxOccurs == -1))
      {
        localStringBuffer.append('+');
      }
      else
      {
        if ((this.minOccurs != 0) || (this.maxOccurs != -1))
          break label161;
        localStringBuffer.append('*');
      }
    }
    label161: localStringBuffer.append('{');
    localStringBuffer.append(this.minOccurs);
    localStringBuffer.append(',');
    if (this.maxOccurs >= 0)
      localStringBuffer.append(this.maxOccurs);
    while (true)
    {
      localStringBuffer.append('}');
      break;
      localStringBuffer.append('*');
    }
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.base);
    paramObjectOutput.writeInt(this.minOccurs);
    paramObjectOutput.writeInt(this.maxOccurs);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.reflect.OccurrenceType
 * JD-Core Version:    0.6.2
 */