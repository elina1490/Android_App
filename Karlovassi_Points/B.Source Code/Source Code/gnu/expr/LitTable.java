package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.lists.FString;
import gnu.mapping.Symbol;
import gnu.mapping.Table2D;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.IdentityHashMap;
import java.util.regex.Pattern;

public class LitTable
  implements ObjectOutput
{
  static Table2D staticTable = new Table2D(100);
  Compilation comp;
  IdentityHashMap literalTable = new IdentityHashMap(100);
  Literal literalsChain;
  int literalsCount;
  ClassType mainClass;
  int stackPointer;
  Type[] typeStack = new Type[20];
  Object[] valueStack = new Object[20];

  public LitTable(Compilation paramCompilation)
  {
    this.comp = paramCompilation;
    this.mainClass = paramCompilation.mainClass;
  }

  private void store(Literal paramLiteral, boolean paramBoolean, CodeAttr paramCodeAttr)
  {
    if (paramLiteral.field != null)
    {
      if (!paramBoolean)
        paramCodeAttr.emitDup(paramLiteral.type);
      paramCodeAttr.emitPutStatic(paramLiteral.field);
    }
    paramLiteral.flags = (0x8 | paramLiteral.flags);
  }

  public void close()
  {
  }

  public void emit()
    throws IOException
  {
    for (Literal localLiteral1 = this.literalsChain; localLiteral1 != null; localLiteral1 = localLiteral1.next)
      writeObject(localLiteral1.value);
    for (Literal localLiteral2 = this.literalsChain; localLiteral2 != null; localLiteral2 = localLiteral2.next)
      emit(localLiteral2, true);
    this.literalTable = null;
    this.literalsCount = 0;
  }

  void emit(Literal paramLiteral, boolean paramBoolean)
  {
    CodeAttr localCodeAttr = this.comp.getCode();
    if (paramLiteral.value == null)
      if (!paramBoolean)
        localCodeAttr.emitPushNull();
    do
    {
      do
      {
        return;
        if (!(paramLiteral.value instanceof String))
          break;
      }
      while (paramBoolean);
      localCodeAttr.emitPushString(paramLiteral.value.toString());
      return;
      if ((0x8 & paramLiteral.flags) == 0)
        break;
    }
    while (paramBoolean);
    localCodeAttr.emitGetStatic(paramLiteral.field);
    return;
    if ((paramLiteral.value instanceof Object[]))
    {
      int m = paramLiteral.argValues.length;
      Type localType = ((ArrayType)paramLiteral.type).getComponentType();
      localCodeAttr.emitPushInt(m);
      localCodeAttr.emitNewArray(localType);
      store(paramLiteral, paramBoolean, localCodeAttr);
      int n = 0;
      label124: Literal localLiteral;
      if (n < m)
      {
        localLiteral = (Literal)paramLiteral.argValues[n];
        if (localLiteral.value != null)
          break label157;
      }
      while (true)
      {
        n++;
        break label124;
        break;
        label157: localCodeAttr.emitDup(localType);
        localCodeAttr.emitPushInt(n);
        emit(localLiteral, false);
        localCodeAttr.emitArrayStore(localType);
      }
    }
    if ((paramLiteral.type instanceof ArrayType))
    {
      localCodeAttr.emitPushPrimArray(paramLiteral.value, (ArrayType)paramLiteral.type);
      store(paramLiteral, paramBoolean, localCodeAttr);
      return;
    }
    if ((paramLiteral.value instanceof Class))
    {
      Class localClass = (Class)paramLiteral.value;
      if (localClass.isPrimitive())
      {
        String str2 = localClass.getName();
        if (str2.equals("int"))
          str2 = "integer";
        localCodeAttr.emitGetStatic(ClassType.make("java.lang." + Character.toUpperCase(str2.charAt(0)) + str2.substring(1)).getDeclaredField("TYPE"));
      }
      while (true)
      {
        store(paramLiteral, paramBoolean, localCodeAttr);
        return;
        this.comp.loadClassRef((ObjectType)Type.make(localClass));
      }
    }
    if (((paramLiteral.value instanceof ClassType)) && (!((ClassType)paramLiteral.value).isExisting()))
    {
      this.comp.loadClassRef((ClassType)paramLiteral.value);
      Method localMethod3 = Compilation.typeType.getDeclaredMethod("valueOf", 1);
      if (localMethod3 == null)
        localMethod3 = Compilation.typeType.getDeclaredMethod("make", 1);
      localCodeAttr.emitInvokeStatic(localMethod3);
      localCodeAttr.emitCheckcast(Compilation.typeClassType);
      store(paramLiteral, paramBoolean, localCodeAttr);
      return;
    }
    ClassType localClassType = (ClassType)paramLiteral.type;
    int i;
    label446: int j;
    Method localMethod1;
    label539: label620: Method localMethod2;
    if ((0x4 & paramLiteral.flags) != 0)
    {
      i = 1;
      j = 0;
      localMethod1 = null;
      if (i == 0)
      {
        boolean bool2 = paramLiteral.value instanceof Symbol;
        localMethod1 = null;
        if (!bool2)
          localMethod1 = getMethod(localClassType, "valueOf", paramLiteral, true);
        if ((localMethod1 == null) && (!(paramLiteral.value instanceof Values)))
        {
          String str1 = "make";
          if ((paramLiteral.value instanceof Pattern))
            str1 = "compile";
          localMethod1 = getMethod(localClassType, str1, paramLiteral, true);
        }
        if (localMethod1 == null)
          break label719;
        j = 1;
        if (localMethod1 == null)
          i = 1;
      }
      if (i != 0)
        localMethod1 = getMethod(localClassType, "set", paramLiteral, false);
      if ((localMethod1 == null) && (paramLiteral.argTypes.length > 0))
        error("no method to construct " + paramLiteral.type);
      if (j == 0)
        break label753;
      putArgs(paramLiteral, localCodeAttr);
      localCodeAttr.emitInvokeStatic(localMethod1);
      if ((j == 0) && (!(paramLiteral.value instanceof Values)))
        break label813;
      localMethod2 = null;
      label638: if (localMethod2 != null)
      {
        localCodeAttr.emitInvokeVirtual(localMethod2);
        localClassType.emitCoerceFromObject(localCodeAttr);
      }
      if ((!paramBoolean) || ((i != 0) && (localMethod1 != null)))
        break label827;
    }
    label813: label827: for (boolean bool1 = true; ; bool1 = false)
    {
      store(paramLiteral, bool1, localCodeAttr);
      if ((i == 0) || (localMethod1 == null))
        break;
      if (!paramBoolean)
        localCodeAttr.emitDup(localClassType);
      putArgs(paramLiteral, localCodeAttr);
      localCodeAttr.emitInvokeVirtual(localMethod1);
      return;
      i = 0;
      break label446;
      label719: int k = paramLiteral.argTypes.length;
      j = 0;
      if (k <= 0)
        break label539;
      localMethod1 = getMethod(localClassType, "<init>", paramLiteral, false);
      j = 0;
      break label539;
      label753: if (i != 0)
      {
        localCodeAttr.emitNew(localClassType);
        localCodeAttr.emitDup(localClassType);
        localCodeAttr.emitInvokeSpecial(localClassType.getDeclaredMethod("<init>", 0));
        break label620;
      }
      localCodeAttr.emitNew(localClassType);
      localCodeAttr.emitDup(localClassType);
      putArgs(paramLiteral, localCodeAttr);
      localCodeAttr.emitInvokeSpecial(localMethod1);
      break label620;
      localMethod2 = localClassType.getDeclaredMethod("readResolve", 0);
      break label638;
    }
  }

  void error(String paramString)
  {
    throw new Error(paramString);
  }

  public Literal findLiteral(Object paramObject)
  {
    if (paramObject == null)
      return Literal.nullLiteral;
    Literal localLiteral1 = (Literal)this.literalTable.get(paramObject);
    if (localLiteral1 != null)
      return localLiteral1;
    if (this.comp.immediate)
    {
      Literal localLiteral2 = new Literal(paramObject, this);
      return localLiteral2;
    }
    Class localClass1 = paramObject.getClass();
    Type localType = Type.make(localClass1);
    Object localObject2;
    ClassType localClassType;
    synchronized (staticTable)
    {
      localObject2 = (Literal)staticTable.get(paramObject, null, null);
      if (((localObject2 != null) && (((Literal)localObject2).value == paramObject)) || (!(localType instanceof ClassType)))
        break label334;
      localClass2 = localClass1;
      localClassType = (ClassType)localType;
      Table2D localTable2D2 = staticTable;
      Boolean localBoolean1 = Boolean.TRUE;
      if (localTable2D2.get(localClass2, localBoolean1, null) != null)
        break label334;
      Table2D localTable2D3 = staticTable;
      Boolean localBoolean2 = Boolean.TRUE;
      localTable2D3.put(localClass2, localBoolean2, localClass2);
      Object localObject3 = localClassType.getFields();
      while (true)
        if (localObject3 != null)
        {
          int i = ((gnu.bytecode.Field)localObject3).getModifiers();
          if ((i & 0x19) == 25);
          try
          {
            Object localObject4 = ((gnu.bytecode.Field)localObject3).getReflectField().get(null);
            if (localObject4 != null)
            {
              boolean bool = localClass2.isInstance(localObject4);
              if (bool)
                break label234;
            }
            while (true)
            {
              gnu.bytecode.Field localField = ((gnu.bytecode.Field)localObject3).getNext();
              localObject3 = localField;
              break;
              label234: Literal localLiteral3 = new Literal(localObject4, (gnu.bytecode.Field)localObject3, this);
              staticTable.put(localObject4, null, localLiteral3);
              if (paramObject == localObject4)
                localObject2 = localLiteral3;
            }
          }
          catch (Throwable localThrowable)
          {
            while (true)
              error("caught " + localThrowable + " getting static field " + localObject3);
          }
        }
    }
    Class localClass2 = localClass2.getSuperclass();
    if (localClass2 == null)
    {
      label334: if (localObject2 == null)
        break label369;
      this.literalTable.put(paramObject, localObject2);
    }
    while (true)
    {
      return localObject2;
      localClassType = (ClassType)Type.make(localClass2);
      break;
      label369: localObject2 = new Literal(paramObject, localType, this);
    }
  }

  public void flush()
  {
  }

  Method getMethod(ClassType paramClassType, String paramString, Literal paramLiteral, boolean paramBoolean)
  {
    Type[] arrayOfType1 = paramLiteral.argTypes;
    Method localMethod1 = paramClassType.getDeclaredMethods();
    int i = arrayOfType1.length;
    Method localMethod2 = null;
    long l1 = 0L;
    int j = 0;
    Object localObject1 = null;
    if (localMethod1 != null)
    {
      if (!paramString.equals(localMethod1.getName()));
      long l2;
      Type[] arrayOfType3;
      int i3;
      int i4;
      label82: label235: label239: label241: int i5;
      label135: label152: label189: 
      do
      {
        do
        {
          do
            while (true)
            {
              localMethod1 = localMethod1.getNext();
              break;
              if (paramBoolean == localMethod1.getStaticFlag())
              {
                l2 = 0L;
                arrayOfType3 = localMethod1.getParameterTypes();
                i3 = 0;
                i4 = 0;
                if (i3 != i)
                  break label241;
                int i8 = arrayOfType3.length;
                if (i4 != i8)
                  break label241;
                if ((localMethod2 != null) && ((l1 == 0L) || (l2 != 0L)))
                  break label135;
                localMethod2 = localMethod1;
                localObject1 = arrayOfType3;
                l1 = l2;
              }
            }
          while (l2 != 0L);
          int i9 = 0;
          int i10 = 0;
          int i11 = i;
          while (true)
          {
            i11--;
            int i12;
            if (i11 >= 0)
            {
              i12 = localObject1[i11].compare(arrayOfType3[i11]);
              if (i12 != 1)
              {
                i10 = 1;
                if (i9 == 0);
              }
            }
            else
            {
              if (i9 != 0)
              {
                localMethod2 = localMethod1;
                localObject1 = arrayOfType3;
              }
              if ((i9 == 0) || (i10 == 0))
                break label235;
            }
            for (j = 1; ; j = 0)
            {
              break;
              if (i12 == -1)
                break label239;
              i9 = 1;
              if (i10 == 0)
                break label152;
              break label189;
            }
          }
        }
        while (i3 == i);
        i5 = arrayOfType3.length;
      }
      while (i4 == i5);
      Type localType3 = arrayOfType1[i3];
      Type localType4 = arrayOfType3[i4];
      if (localType3.isSubtype(localType4));
      while (true)
      {
        i3++;
        i4++;
        break label82;
        if ((!(localType4 instanceof ArrayType)) || (i4 >= 64) || ((localType3 != Type.intType) && (localType3 != Type.shortType)))
          break;
        int i6 = ((Number)paramLiteral.argValues[i3]).intValue();
        if ((i6 < 0) && (paramClassType.getName().equals("gnu.math.IntNum")))
          i6 += 0;
        Type localType5 = ((ArrayType)localType4).getComponentType();
        if ((i6 < 0) || (i3 + i6 >= i))
          break;
        int i7 = i6;
        Type localType6;
        do
        {
          do
          {
            i7--;
            if (i7 < 0)
              break label449;
            localType6 = arrayOfType1[(1 + (i3 + i7))];
            if (!(localType5 instanceof PrimType))
              break;
          }
          while (localType5.getSignature() == localType6.getSignature());
          break;
        }
        while (localType6.isSubtype(localType5));
        break;
        label449: i3 += i6;
        l2 |= 1 << i4;
      }
    }
    if (j != 0)
      return null;
    Object[] arrayOfObject1;
    Type[] arrayOfType2;
    int k;
    int m;
    if (l1 != 0L)
    {
      arrayOfObject1 = new Object[localObject1.length];
      arrayOfType2 = new Type[localObject1.length];
      k = 0;
      m = 0;
      if (k == i)
      {
        paramLiteral.argValues = arrayOfObject1;
        paramLiteral.argTypes = arrayOfType2;
      }
    }
    else
    {
      return localMethod2;
    }
    Type localType1 = localObject1[m];
    if ((l1 & 1 << m) == 0L)
    {
      arrayOfObject1[m] = paramLiteral.argValues[k];
      arrayOfType2[m] = paramLiteral.argTypes[k];
    }
    while (true)
    {
      k++;
      m++;
      break;
      int n = ((Number)paramLiteral.argValues[k]).intValue();
      boolean bool = paramClassType.getName().equals("gnu.math.IntNum");
      if (bool)
        n += 0;
      Type localType2 = ((ArrayType)localType1).getComponentType();
      arrayOfType2[m] = localType1;
      arrayOfObject1[m] = Array.newInstance(localType2.getReflectClass(), n);
      Object[] arrayOfObject2 = paramLiteral.argValues;
      if (bool)
      {
        int[] arrayOfInt = (int[])arrayOfObject1[m];
        for (int i2 = n; i2 > 0; i2--)
          arrayOfInt[(n - i2)] = ((Integer)arrayOfObject2[(k + i2)]).intValue();
      }
      int i1 = n;
      while (true)
      {
        i1--;
        if (i1 < 0)
          break;
        Object localObject2 = arrayOfObject1[m];
        Object localObject3 = arrayOfObject2[(i1 + (k + 1))];
        Array.set(localObject2, i1, localObject3);
      }
      Literal localLiteral = new Literal(arrayOfObject1[m], localType1);
      if ((localType2 instanceof ObjectType))
        localLiteral.argValues = ((Object[])arrayOfObject1[m]);
      arrayOfObject1[m] = localLiteral;
      k += n;
    }
  }

  void push(Object paramObject, Type paramType)
  {
    if (this.stackPointer >= this.valueStack.length)
    {
      Object[] arrayOfObject = new Object[2 * this.valueStack.length];
      Type[] arrayOfType = new Type[2 * this.typeStack.length];
      System.arraycopy(this.valueStack, 0, arrayOfObject, 0, this.stackPointer);
      System.arraycopy(this.typeStack, 0, arrayOfType, 0, this.stackPointer);
      this.valueStack = arrayOfObject;
      this.typeStack = arrayOfType;
    }
    this.valueStack[this.stackPointer] = paramObject;
    this.typeStack[this.stackPointer] = paramType;
    this.stackPointer = (1 + this.stackPointer);
  }

  void putArgs(Literal paramLiteral, CodeAttr paramCodeAttr)
  {
    Type[] arrayOfType = paramLiteral.argTypes;
    int i = arrayOfType.length;
    int j = 0;
    if (j < i)
    {
      Object localObject = paramLiteral.argValues[j];
      if ((localObject instanceof Literal))
        emit((Literal)localObject, false);
      while (true)
      {
        j++;
        break;
        this.comp.compileConstant(localObject, new StackTarget(arrayOfType[j]));
      }
    }
  }

  public void write(int paramInt)
    throws IOException
  {
    error("cannot handle call to write(int) when externalizing literal");
  }

  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    error("cannot handle call to write(byte[]) when externalizing literal");
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    error("cannot handle call to write(byte[],int,int) when externalizing literal");
  }

  public void writeBoolean(boolean paramBoolean)
  {
    push(new Boolean(paramBoolean), Type.booleanType);
  }

  public void writeByte(int paramInt)
  {
    push(new Byte((byte)paramInt), Type.byteType);
  }

  public void writeBytes(String paramString)
    throws IOException
  {
    error("cannot handle call to writeBytes(String) when externalizing literal");
  }

  public void writeChar(int paramInt)
  {
    push(new Character((char)paramInt), Type.charType);
  }

  public void writeChars(String paramString)
  {
    push(paramString, Type.string_type);
  }

  public void writeDouble(double paramDouble)
  {
    push(new Double(paramDouble), Type.doubleType);
  }

  public void writeFloat(float paramFloat)
  {
    push(new Float(paramFloat), Type.floatType);
  }

  public void writeInt(int paramInt)
  {
    push(new Integer(paramInt), Type.intType);
  }

  public void writeLong(long paramLong)
  {
    push(new Long(paramLong), Type.longType);
  }

  public void writeObject(Object paramObject)
    throws IOException
  {
    Literal localLiteral = findLiteral(paramObject);
    if ((0x3 & localLiteral.flags) != 0)
    {
      if ((localLiteral.field == null) && (paramObject != null) && (!(paramObject instanceof String)))
        localLiteral.assign(this);
      if ((0x2 & localLiteral.flags) == 0)
        localLiteral.flags = (0x4 | localLiteral.flags);
      push(localLiteral, localLiteral.type);
      return;
    }
    localLiteral.flags = (0x1 | localLiteral.flags);
    int i = this.stackPointer;
    label113: int j;
    if (((paramObject instanceof FString)) && (((FString)paramObject).size() < 65535))
    {
      push(paramObject.toString(), Type.string_type);
      j = this.stackPointer - i;
      if (j != 0)
        break label508;
      localLiteral.argValues = Values.noArgs;
      localLiteral.argTypes = Type.typeArray0;
    }
    while (true)
    {
      localLiteral.flags = (0x2 | localLiteral.flags);
      break;
      if ((paramObject instanceof Externalizable))
      {
        ((Externalizable)paramObject).writeExternal(this);
        break label113;
      }
      if ((paramObject instanceof Object[]))
      {
        Object[] arrayOfObject = (Object[])paramObject;
        for (int k = 0; k < arrayOfObject.length; k++)
          writeObject(arrayOfObject[k]);
        break label113;
      }
      if ((paramObject == null) || ((paramObject instanceof String)) || ((localLiteral.type instanceof ArrayType)))
        break label113;
      if ((paramObject instanceof BigInteger))
      {
        writeChars(paramObject.toString());
        break label113;
      }
      if ((paramObject instanceof BigDecimal))
      {
        BigDecimal localBigDecimal = (BigDecimal)paramObject;
        writeObject(localBigDecimal.unscaledValue());
        writeInt(localBigDecimal.scale());
        break label113;
      }
      if ((paramObject instanceof Integer))
      {
        push(paramObject, Type.intType);
        break label113;
      }
      if ((paramObject instanceof Short))
      {
        push(paramObject, Type.shortType);
        break label113;
      }
      if ((paramObject instanceof Byte))
      {
        push(paramObject, Type.byteType);
        break label113;
      }
      if ((paramObject instanceof Long))
      {
        push(paramObject, Type.longType);
        break label113;
      }
      if ((paramObject instanceof Double))
      {
        push(paramObject, Type.doubleType);
        break label113;
      }
      if ((paramObject instanceof Float))
      {
        push(paramObject, Type.floatType);
        break label113;
      }
      if ((paramObject instanceof Character))
      {
        push(paramObject, Type.charType);
        break label113;
      }
      if ((paramObject instanceof Class))
      {
        push(paramObject, Type.java_lang_Class_type);
        break label113;
      }
      if ((paramObject instanceof Pattern))
      {
        Pattern localPattern = (Pattern)paramObject;
        push(localPattern.pattern(), Type.string_type);
        push(Integer.valueOf(localPattern.flags()), Type.intType);
        break label113;
      }
      error(paramObject.getClass().getName() + " does not implement Externalizable");
      break label113;
      label508: localLiteral.argValues = new Object[j];
      localLiteral.argTypes = new Type[j];
      System.arraycopy(this.valueStack, i, localLiteral.argValues, 0, j);
      System.arraycopy(this.typeStack, i, localLiteral.argTypes, 0, j);
      this.stackPointer = i;
    }
  }

  public void writeShort(int paramInt)
  {
    push(new Short((short)paramInt), Type.shortType);
  }

  public void writeUTF(String paramString)
  {
    push(paramString, Type.string_type);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.LitTable
 * JD-Core Version:    0.6.2
 */