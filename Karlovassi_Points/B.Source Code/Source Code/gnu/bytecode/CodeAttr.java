package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

public class CodeAttr extends Attribute
  implements AttrContainer
{
  public static final int DONT_USE_JSR = 2;
  static final int FIXUP_CASE = 3;
  static final int FIXUP_DEFINE = 1;
  static final int FIXUP_DELETE3 = 8;
  static final int FIXUP_GOTO = 4;
  static final int FIXUP_JSR = 5;
  static final int FIXUP_LINE_NUMBER = 15;
  static final int FIXUP_LINE_PC = 14;
  static final int FIXUP_MOVE = 9;
  static final int FIXUP_MOVE_TO_END = 10;
  static final int FIXUP_NONE = 0;
  static final int FIXUP_SWITCH = 2;
  static final int FIXUP_TRANSFER = 6;
  static final int FIXUP_TRANSFER2 = 7;
  static final int FIXUP_TRY = 11;
  static final int FIXUP_TRY_END = 12;
  static final int FIXUP_TRY_HANDLER = 13;
  public static final int GENERATE_STACK_MAP_TABLE = 1;
  public static boolean instructionLineMode = false;
  int PC;
  int SP;
  Attribute attributes;
  byte[] code;
  ExitableBlock currentExitableBlock;
  short[] exception_table;
  int exception_table_length;
  int exitableBlockLevel;
  int fixup_count;
  Label[] fixup_labels;
  int[] fixup_offsets;
  int flags;
  IfState if_stack;
  LineNumbersAttr lines;
  Type[] local_types;
  public LocalVarsAttr locals;
  private int max_locals;
  private int max_stack;
  Label previousLabel;
  SourceDebugExtAttr sourceDbgExt;
  public StackMapTableAttr stackMap;
  public Type[] stack_types;
  TryState try_stack;
  private boolean unreachable_here;
  boolean[] varsSetInCurrentBlock;

  public CodeAttr(Method paramMethod)
  {
    super("Code");
    addToFrontOf(paramMethod);
    paramMethod.code = this;
    if (paramMethod.getDeclaringClass().getClassfileMajorVersion() >= 50)
      this.flags = (0x3 | this.flags);
  }

  private int adjustTypedOp(char paramChar)
  {
    switch (paramChar)
    {
    default:
      return 4;
    case 'I':
      return 0;
    case 'J':
      return 1;
    case 'F':
      return 2;
    case 'D':
      return 3;
    case 'B':
    case 'Z':
      return 5;
    case 'C':
      return 6;
    case 'S':
    }
    return 7;
  }

  private int adjustTypedOp(Type paramType)
  {
    return adjustTypedOp(paramType.getSignature().charAt(0));
  }

  public static final String calculateSplit(String paramString)
  {
    int i = paramString.length();
    StringBuffer localStringBuffer = new StringBuffer(20);
    int j = 0;
    int k = 0;
    int m = 0;
    if (m < i)
    {
      int n = paramString.charAt(m);
      int i1;
      if (n >= 2048)
        i1 = 3;
      while (true)
      {
        if (k + i1 > 65535)
        {
          localStringBuffer.append((char)(m - j));
          j = m;
          k = 0;
        }
        k += i1;
        m++;
        break;
        if ((n >= 128) || (n == 0))
          i1 = 2;
        else
          i1 = 1;
      }
    }
    localStringBuffer.append((char)(i - j));
    return localStringBuffer.toString();
  }

  public static boolean castNeeded(Type paramType1, Type paramType2)
  {
    if ((paramType1 instanceof UninitializedType));
    for (paramType1 = ((UninitializedType)paramType1).getImplementationType(); ; paramType1 = ((ArrayType)paramType1).getComponentType())
    {
      if (paramType1 == paramType2)
        return false;
      if (((paramType2 instanceof ClassType)) && ((paramType1 instanceof ClassType)) && (((ClassType)paramType1).isSubclass((ClassType)paramType2)))
        return false;
      if ((!(paramType2 instanceof ArrayType)) || (!(paramType1 instanceof ArrayType)))
        break;
      paramType2 = ((ArrayType)paramType2).getComponentType();
    }
    return true;
  }

  private void emitBinop(int paramInt)
  {
    Type localType1 = popType().promote();
    Type localType2 = popType();
    Type localType3 = localType2.promote();
    if ((localType3 != localType1) || (!(localType3 instanceof PrimType)))
      throw new Error("non-matching or bad types in binary operation");
    emitTypedOp(paramInt, localType3);
    pushType(localType2);
  }

  private void emitBinop(int paramInt, char paramChar)
  {
    popType();
    popType();
    emitTypedOp(paramInt, paramChar);
    pushType(Type.signatureToPrimitive(paramChar));
  }

  private void emitCheckcast(Type paramType, int paramInt)
  {
    reserve(3);
    popType();
    put1(paramInt);
    if ((paramType instanceof ObjectType))
    {
      putIndex2(getConstants().addClass((ObjectType)paramType));
      return;
    }
    throw new Error("unimplemented type " + paramType + " in emitCheckcast/emitInstanceof");
  }

  private final void emitFieldop(Field paramField, int paramInt)
  {
    reserve(3);
    put1(paramInt);
    putIndex2(getConstants().addFieldRef(paramField));
  }

  private void emitShift(int paramInt)
  {
    Type localType1 = popType().promote();
    Type localType2 = popType();
    Type localType3 = localType2.promote();
    if ((localType3 != Type.intType) && (localType3 != Type.longType))
      throw new Error("the value shifted must be an int or a long");
    if (localType1 != Type.intType)
      throw new Error("the amount of shift must be an int");
    emitTypedOp(paramInt, localType3);
    pushType(localType2);
  }

  private void emitTryEnd(boolean paramBoolean)
  {
    if (this.try_stack.tryClauseDone)
      return;
    this.try_stack.tryClauseDone = true;
    if (this.try_stack.finally_subr != null)
      this.try_stack.exception = addLocal(Type.javalangThrowableType);
    gotoFinallyOrEnd(paramBoolean);
    this.try_stack.end_try = getLabel();
  }

  private void emitTypedOp(int paramInt, char paramChar)
  {
    reserve(1);
    put1(paramInt + adjustTypedOp(paramChar));
  }

  private void emitTypedOp(int paramInt, Type paramType)
  {
    reserve(1);
    put1(paramInt + adjustTypedOp(paramType));
  }

  private final int fixupKind(int paramInt)
  {
    return 0xF & this.fixup_offsets[paramInt];
  }

  private final int fixupOffset(int paramInt)
  {
    return this.fixup_offsets[paramInt] >> 4;
  }

  private void gotoFinallyOrEnd(boolean paramBoolean)
  {
    if (reachableHere())
    {
      if (this.try_stack.saved_result != null)
        emitStore(this.try_stack.saved_result);
      if (this.try_stack.end_label == null)
        this.try_stack.end_label = new Label();
      if ((this.try_stack.finally_subr != null) && (!useJsr()))
        break label102;
      if (this.try_stack.finally_subr != null)
        emitJsr(this.try_stack.finally_subr);
      emitGoto(this.try_stack.end_label);
    }
    label102: 
    do
    {
      return;
      if (this.try_stack.exitCases != null)
        emitPushInt(0);
      emitPushNull();
    }
    while (paramBoolean);
    emitGoto(this.try_stack.finally_subr);
  }

  private Label mergeLabels(Label paramLabel1, Label paramLabel2)
  {
    if (paramLabel1 != null)
      paramLabel2.setTypes(paramLabel1);
    return paramLabel2;
  }

  private void print(String paramString, int paramInt, PrintWriter paramPrintWriter)
  {
    int i = 0;
    int j = -1;
    while (paramInt >= 0)
    {
      i = j + 1;
      j = paramString.indexOf(';', i);
      paramInt--;
    }
    paramPrintWriter.write(paramString, i, j - i);
  }

  private int readInt(int paramInt)
  {
    return readUnsignedShort(paramInt) << 16 | readUnsignedShort(paramInt + 2);
  }

  private int readUnsignedShort(int paramInt)
  {
    return (0xFF & this.code[paramInt]) << 8 | 0xFF & this.code[(paramInt + 1)];
  }

  private int words(Type[] paramArrayOfType)
  {
    int i = 0;
    int j = paramArrayOfType.length;
    while (true)
    {
      j--;
      if (j < 0)
        break;
      if (paramArrayOfType[j].size > 4)
        i += 2;
      else
        i++;
    }
    return i;
  }

  public void addHandler(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 4 * this.exception_table_length;
    if (this.exception_table == null)
      this.exception_table = new short[20];
    while (true)
    {
      short[] arrayOfShort2 = this.exception_table;
      int j = i + 1;
      arrayOfShort2[i] = ((short)paramInt1);
      short[] arrayOfShort3 = this.exception_table;
      int k = j + 1;
      arrayOfShort3[j] = ((short)paramInt2);
      short[] arrayOfShort4 = this.exception_table;
      int m = k + 1;
      arrayOfShort4[k] = ((short)paramInt3);
      short[] arrayOfShort5 = this.exception_table;
      (m + 1);
      arrayOfShort5[m] = ((short)paramInt4);
      this.exception_table_length = (1 + this.exception_table_length);
      return;
      if (this.exception_table.length <= i)
      {
        short[] arrayOfShort1 = new short[2 * this.exception_table.length];
        System.arraycopy(this.exception_table, 0, arrayOfShort1, 0, i);
        this.exception_table = arrayOfShort1;
      }
    }
  }

  public void addHandler(Label paramLabel1, Label paramLabel2, ClassType paramClassType)
  {
    ConstantPool localConstantPool = getConstants();
    int i;
    Label localLabel;
    if (paramClassType == null)
    {
      i = 0;
      fixupAdd(11, paramLabel1);
      fixupAdd(12, i, paramLabel2);
      localLabel = new Label();
      localLabel.localTypes = paramLabel1.localTypes;
      localLabel.stackTypes = new Type[1];
      if (paramClassType != null)
        break label104;
    }
    label104: for (ClassType localClassType = Type.javalangThrowableType; ; localClassType = paramClassType)
    {
      localLabel.stackTypes[0] = localClassType;
      setTypes(localLabel);
      fixupAdd(13, 0, localLabel);
      return;
      i = localConstantPool.addClass(paramClassType).index;
      break;
    }
  }

  public Variable addLocal(Type paramType)
  {
    return this.locals.current_scope.addVariable(this, paramType, null);
  }

  public Variable addLocal(Type paramType, String paramString)
  {
    return this.locals.current_scope.addVariable(this, paramType, paramString);
  }

  public void addParamLocals()
  {
    Method localMethod = getMethod();
    if ((0x8 & localMethod.access_flags) == 0)
      addLocal(localMethod.classfile).setParameter(true);
    int i = localMethod.arg_types.length;
    for (int j = 0; j < i; j++)
      addLocal(localMethod.arg_types[j]).setParameter(true);
  }

  public void assignConstants(ClassType paramClassType)
  {
    if ((this.locals != null) && (this.locals.container == null) && (!this.locals.isEmpty()))
      this.locals.addToFrontOf(this);
    processFixups();
    if ((this.stackMap != null) && (this.stackMap.numEntries > 0))
      this.stackMap.addToFrontOf(this);
    if (instructionLineMode)
    {
      if (this.lines == null)
        this.lines = new LineNumbersAttr(this);
      this.lines.linenumber_count = 0;
      int i = getCodeLength();
      for (int j = 0; j < i; j++)
        this.lines.put(j, j);
    }
    super.assignConstants(paramClassType);
    Attribute.assignConstants(this, paramClassType);
  }

  public int beginFragment(Label paramLabel)
  {
    return beginFragment(new Label(), paramLabel);
  }

  public int beginFragment(Label paramLabel1, Label paramLabel2)
  {
    int i = this.fixup_count;
    fixupAdd(10, paramLabel2);
    paramLabel1.define(this);
    return i;
  }

  public void disAssemble(ClassTypeWriter paramClassTypeWriter, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1;
    int k;
    int m;
    int n;
    int i1;
    int i3;
    label117: int i4;
    int i5;
    if (j < paramInt2)
    {
      k = j + 1;
      m = j;
      n = 0xFF & this.code[m];
      String str1 = Integer.toString(m);
      i1 = 0;
      int i2 = str1.length();
      while (true)
      {
        i2++;
        if (i2 > 3)
          break;
        paramClassTypeWriter.print(' ');
      }
      paramClassTypeWriter.print(str1);
      paramClassTypeWriter.print(": ");
      if (n < 120)
        if (n < 87)
          if (n < 3)
          {
            print("nop;aconst_null;iconst_m1;", n, paramClassTypeWriter);
            i3 = k;
            if (i1 <= 0)
              break label2103;
            if (i1 != 1)
              break label2085;
            byte[] arrayOfByte1 = this.code;
            i4 = i3 + 1;
            i5 = 0xFF & arrayOfByte1[i3];
            label151: paramClassTypeWriter.printConstantOperand(i5);
          }
    }
    while (true)
    {
      paramClassTypeWriter.println();
      j = i4;
      break;
      if (n < 9)
      {
        paramClassTypeWriter.print("iconst_");
        paramClassTypeWriter.print(n - 3);
        i3 = k;
        i1 = 0;
        break label117;
      }
      if (n < 16)
      {
        char c2;
        int i44;
        if (n < 11)
        {
          c2 = 'l';
          i44 = n - 9;
        }
        while (true)
        {
          paramClassTypeWriter.print(c2);
          paramClassTypeWriter.print("const_");
          paramClassTypeWriter.print(i44);
          i3 = k;
          i1 = 0;
          break;
          if (n < 14)
          {
            c2 = 'f';
            i44 = n - 11;
          }
          else
          {
            c2 = 'd';
            i44 = n - 14;
          }
        }
      }
      if (n < 21)
      {
        if (n < 18)
        {
          print("bipush ;sipush ;", n - 16, paramClassTypeWriter);
          int i43;
          int i41;
          if (n == 16)
          {
            byte[] arrayOfByte6 = this.code;
            i43 = k + 1;
            i41 = arrayOfByte6[k];
          }
          for (int i42 = i43; ; i42 = k + 2)
          {
            paramClassTypeWriter.print(i41);
            i3 = i42;
            i1 = 0;
            break;
            i41 = (short)readUnsignedShort(k);
          }
        }
        if (n == 18);
        for (i1 = 1; ; i1 = 2)
        {
          print("ldc;ldc_w;ldc2_w;", n - 18, paramClassTypeWriter);
          i3 = k;
          break;
        }
      }
      String str2;
      label428: int i37;
      int i38;
      if (n < 54)
      {
        str2 = "load";
        if (n >= 26)
          break label514;
        i37 = -1;
        i38 = n - 21;
        label445: paramClassTypeWriter.print("ilfdabcs".charAt(i38));
        if (i37 == -2)
          paramClassTypeWriter.write(97);
        paramClassTypeWriter.print(str2);
        if (i37 < 0)
          break label557;
        paramClassTypeWriter.write(95);
        paramClassTypeWriter.print(i37);
      }
      label514: label557: 
      while (i37 != -1)
      {
        i3 = k;
        i1 = 0;
        break;
        str2 = "store";
        n -= 33;
        break label428;
        if (n < 46)
        {
          int i40 = n - 26;
          i37 = i40 % 4;
          i38 = i40 >> 2;
          break label445;
        }
        i37 = -2;
        i38 = n - 46;
        break label445;
      }
      int i39;
      if (i != 0)
      {
        i39 = readUnsignedShort(k);
        k += 2;
      }
      while (true)
      {
        paramClassTypeWriter.print(' ');
        paramClassTypeWriter.print(i39);
        i = 0;
        break;
        i39 = 0xFF & this.code[k];
        k++;
      }
      if (n < 96)
      {
        print("pop;pop2;dup;dup_x1;dup_x2;dup2;dup2_x1;dup2_x2;swap;", n - 87, paramClassTypeWriter);
        i3 = k;
        i1 = 0;
        break label117;
      }
      paramClassTypeWriter.print("ilfda".charAt((n - 96) % 4));
      print("add;sub;mul;div;rem;neg;", n - 96 >> 2, paramClassTypeWriter);
      i3 = k;
      i1 = 0;
      break label117;
      if (n < 170)
      {
        if (n < 132)
        {
          if ((n & 0x1) == 0);
          for (char c1 = 'i'; ; c1 = 'l')
          {
            paramClassTypeWriter.print(c1);
            print("shl;shr;ushr;and;or;xor;", n - 120 >> 1, paramClassTypeWriter);
            i3 = k;
            i1 = 0;
            break;
          }
        }
        if (n == 132)
        {
          paramClassTypeWriter.print("iinc");
          int i32;
          int i35;
          int i34;
          if (i == 0)
          {
            byte[] arrayOfByte4 = this.code;
            int i36 = k + 1;
            i32 = 0xFF & arrayOfByte4[k];
            byte[] arrayOfByte5 = this.code;
            i35 = i36 + 1;
            i34 = arrayOfByte5[i36];
          }
          while (true)
          {
            paramClassTypeWriter.print(' ');
            paramClassTypeWriter.print(i32);
            paramClassTypeWriter.print(' ');
            paramClassTypeWriter.print(i34);
            i3 = i35;
            i1 = 0;
            break;
            i32 = readUnsignedShort(k);
            int i33 = k + 2;
            i34 = (short)readUnsignedShort(i33);
            i35 = i33 + 2;
            i = 0;
          }
        }
        if (n < 148)
        {
          paramClassTypeWriter.print("ilfdi".charAt((n - 133) / 3));
          paramClassTypeWriter.print('2');
          paramClassTypeWriter.print("lfdifdildilfbcs".charAt(n - 133));
          i3 = k;
          i1 = 0;
          break label117;
        }
        if (n < 153)
        {
          print("lcmp;fcmpl;fcmpg;dcmpl;dcmpg;", n - 148, paramClassTypeWriter);
          i3 = k;
          i1 = 0;
          break label117;
        }
        if (n < 169)
        {
          if (n < 159)
          {
            paramClassTypeWriter.print("if");
            print("eq;ne;lt;ge;gt;le;", n - 153, paramClassTypeWriter);
          }
          while (true)
          {
            int i30 = (short)readUnsignedShort(k);
            int i31 = k + 2;
            paramClassTypeWriter.print(' ');
            paramClassTypeWriter.print(m + i30);
            i3 = i31;
            i1 = 0;
            break;
            if (n < 167)
            {
              if (n < 165)
                paramClassTypeWriter.print("if_icmp");
              while (true)
              {
                print("eq;ne;lt;ge;gt;le;", n - 159, paramClassTypeWriter);
                break;
                paramClassTypeWriter.print("if_acmp");
                n -= 6;
              }
            }
            print("goto;jsr;", n - 167, paramClassTypeWriter);
          }
        }
        paramClassTypeWriter.print("ret ");
        int i29;
        if (i != 0)
          i29 = 2 + readUnsignedShort(k);
        while (true)
        {
          paramClassTypeWriter.print(i29);
          i3 = k;
          i1 = 0;
          i = 0;
          break;
          i29 = 0xFF & this.code[k];
          k++;
        }
      }
      if (n < 172)
      {
        if (this.fixup_count <= 0)
          k = 0xFFFFFFFC & k + 3;
        int i18 = readInt(k);
        int i19 = k + 4;
        if (n == 170)
        {
          paramClassTypeWriter.print("tableswitch");
          int i25 = readInt(i19);
          int i26 = i19 + 4;
          int i27 = readInt(i26);
          i21 = i26 + 4;
          paramClassTypeWriter.print(" low: ");
          paramClassTypeWriter.print(i25);
          paramClassTypeWriter.print(" high: ");
          paramClassTypeWriter.print(i27);
          paramClassTypeWriter.print(" default: ");
          paramClassTypeWriter.print(m + i18);
          while (i25 <= i27)
          {
            int i28 = readInt(i21);
            i21 += 4;
            paramClassTypeWriter.println();
            paramClassTypeWriter.print("  ");
            paramClassTypeWriter.print(i25);
            paramClassTypeWriter.print(": ");
            paramClassTypeWriter.print(m + i28);
            i25++;
          }
        }
        paramClassTypeWriter.print("lookupswitch");
        int i20 = readInt(i19);
        int i21 = i19 + 4;
        paramClassTypeWriter.print(" npairs: ");
        paramClassTypeWriter.print(i20);
        paramClassTypeWriter.print(" default: ");
        paramClassTypeWriter.print(m + i18);
        while (true)
        {
          i20--;
          if (i20 < 0)
            break;
          int i22 = readInt(i21);
          int i23 = i21 + 4;
          int i24 = readInt(i23);
          i21 = i23 + 4;
          paramClassTypeWriter.println();
          paramClassTypeWriter.print("  ");
          paramClassTypeWriter.print(i22);
          paramClassTypeWriter.print(": ");
          paramClassTypeWriter.print(m + i24);
        }
        i3 = i21;
        i1 = 0;
        break label117;
      }
      if (n < 178)
      {
        if (n < 177)
          paramClassTypeWriter.print("ilfda".charAt(n - 172));
        paramClassTypeWriter.print("return");
        i3 = k;
        i1 = 0;
        break label117;
      }
      if (n < 182)
      {
        print("getstatic;putstatic;getfield;putfield;", n - 178, paramClassTypeWriter);
        i1 = 2;
        i3 = k;
        break label117;
      }
      if (n < 185)
      {
        paramClassTypeWriter.print("invoke");
        print("virtual;special;static;", n - 182, paramClassTypeWriter);
        i1 = 2;
        i3 = k;
        break label117;
      }
      if (n == 185)
      {
        paramClassTypeWriter.print("invokeinterface (");
        int i14 = readUnsignedShort(k);
        int i15 = k + 2;
        int i16 = 0xFF & this.code[i15];
        int i17 = i15 + 2;
        paramClassTypeWriter.print(i16 + " args)");
        paramClassTypeWriter.printConstantOperand(i14);
        i3 = i17;
        i1 = 0;
        break label117;
      }
      if (n < 196)
      {
        print("186;new;newarray;anewarray;arraylength;athrow;checkcast;instanceof;monitorenter;monitorexit;", n - 186, paramClassTypeWriter);
        if ((n == 187) || (n == 189) || (n == 192) || (n == 193))
        {
          i1 = 2;
          i3 = k;
          break label117;
        }
        if (n != 188)
          break label2075;
        byte[] arrayOfByte3 = this.code;
        i3 = k + 1;
        int i13 = arrayOfByte3[k];
        paramClassTypeWriter.print(' ');
        if ((i13 >= 4) && (i13 <= 11))
        {
          print("boolean;char;float;double;byte;short;int;long;", i13 - 4, paramClassTypeWriter);
          i1 = 0;
          break label117;
        }
        paramClassTypeWriter.print(i13);
        i1 = 0;
        break label117;
      }
      if (n == 196)
      {
        paramClassTypeWriter.print("wide");
        i = 1;
        i3 = k;
        i1 = 0;
        break label117;
      }
      if (n == 197)
      {
        paramClassTypeWriter.print("multianewarray");
        int i10 = readUnsignedShort(k);
        int i11 = k + 2;
        paramClassTypeWriter.printConstantOperand(i10);
        byte[] arrayOfByte2 = this.code;
        i3 = i11 + 1;
        int i12 = 0xFF & arrayOfByte2[i11];
        paramClassTypeWriter.print(' ');
        paramClassTypeWriter.print(i12);
        i1 = 0;
        break label117;
      }
      if (n < 200)
      {
        print("ifnull;ifnonnull;", n - 198, paramClassTypeWriter);
        int i8 = (short)readUnsignedShort(k);
        int i9 = k + 2;
        paramClassTypeWriter.print(' ');
        paramClassTypeWriter.print(m + i8);
        i3 = i9;
        i1 = 0;
        break label117;
      }
      if (n < 202)
      {
        print("goto_w;jsr_w;", n - 200, paramClassTypeWriter);
        int i6 = readInt(k);
        int i7 = k + 4;
        paramClassTypeWriter.print(' ');
        paramClassTypeWriter.print(m + i6);
        i3 = i7;
        i1 = 0;
        break label117;
      }
      paramClassTypeWriter.print(n);
      label2075: i3 = k;
      i1 = 0;
      break label117;
      label2085: i5 = readUnsignedShort(i3);
      i4 = i3 + 2;
      break label151;
      return;
      label2103: i4 = i3;
    }
  }

  public final void emitAdd()
  {
    emitBinop(96);
  }

  public final void emitAdd(char paramChar)
  {
    emitBinop(96, paramChar);
  }

  public final void emitAdd(PrimType paramPrimType)
  {
    emitBinop(96, paramPrimType);
  }

  public final void emitAnd()
  {
    emitBinop(126);
  }

  public final void emitArrayLength()
  {
    if (!(popType() instanceof ArrayType))
      throw new Error("non-array type in emitArrayLength");
    reserve(1);
    put1(190);
    pushType(Type.intType);
  }

  public void emitArrayLoad()
  {
    popType();
    Type localType = ((ArrayType)popType().getImplementationType()).getComponentType();
    emitTypedOp(46, localType);
    pushType(localType);
  }

  public void emitArrayLoad(Type paramType)
  {
    popType();
    popType();
    emitTypedOp(46, paramType);
    pushType(paramType);
  }

  public void emitArrayStore()
  {
    popType();
    popType();
    emitTypedOp(79, ((ArrayType)popType().getImplementationType()).getComponentType());
  }

  public void emitArrayStore(Type paramType)
  {
    popType();
    popType();
    popType();
    emitTypedOp(79, paramType);
  }

  public void emitBinop(int paramInt, Type paramType)
  {
    popType();
    popType();
    emitTypedOp(paramInt, paramType);
    pushType(paramType);
  }

  public void emitCatchEnd()
  {
    gotoFinallyOrEnd(false);
    this.try_stack.try_type = null;
  }

  public void emitCatchStart(Variable paramVariable)
  {
    emitTryEnd(false);
    setTypes(this.try_stack.start_try.localTypes, Type.typeArray0);
    if (this.try_stack.try_type != null)
      emitCatchEnd();
    if (paramVariable == null);
    for (ClassType localClassType = null; ; localClassType = (ClassType)paramVariable.getType())
    {
      this.try_stack.try_type = localClassType;
      addHandler(this.try_stack.start_try, this.try_stack.end_try, localClassType);
      if (paramVariable != null)
        emitStore(paramVariable);
      return;
    }
  }

  public void emitCheckcast(Type paramType)
  {
    if (castNeeded(topType(), paramType))
    {
      emitCheckcast(paramType, 192);
      pushType(paramType);
    }
  }

  public final void emitConvert(Type paramType1, Type paramType2)
  {
    String str1 = paramType2.getSignature();
    String str2 = paramType1.getSignature();
    int i = -1;
    int j;
    if ((str1.length() == 1) || (str2.length() == 1))
    {
      j = str1.charAt(0);
      int k = str2.charAt(0);
      if (k == j);
      do
      {
        return;
        if (paramType1.size < 4)
          k = 73;
        if (paramType2.size < 4)
        {
          emitConvert(paramType1, Type.intType);
          k = 73;
        }
      }
      while (k == j);
      switch (k)
      {
      case 69:
      case 71:
      case 72:
      default:
      case 73:
      case 74:
      case 70:
      case 68:
      }
    }
    while (i < 0)
    {
      throw new Error("unsupported CodeAttr.emitConvert");
      switch (j)
      {
      default:
        break;
      case 66:
        i = 145;
        break;
      case 67:
        i = 146;
        break;
      case 83:
        i = 147;
        break;
      case 74:
        i = 133;
        break;
      case 70:
        i = 134;
        break;
      case 68:
        i = 135;
        continue;
        switch (j)
        {
        case 69:
        case 71:
        case 72:
        default:
          break;
        case 68:
          i = 138;
          break;
        case 73:
          i = 136;
          break;
        case 70:
          i = 137;
          continue;
          switch (j)
          {
          default:
            break;
          case 68:
            i = 141;
            break;
          case 73:
            i = 139;
            break;
          case 74:
            i = 140;
            continue;
            switch (j)
            {
            case 71:
            case 72:
            default:
              break;
            case 70:
              i = 144;
              break;
            case 73:
              i = 142;
              break;
            case 74:
              i = 143;
            }
            break;
          }
          break;
        }
        break;
      }
    }
    reserve(1);
    popType();
    put1(i);
    pushType(paramType2);
  }

  public final void emitDiv()
  {
    emitBinop(108);
  }

  public void emitDup()
  {
    reserve(1);
    Type localType = topType();
    if (localType.size <= 4);
    for (int i = 89; ; i = 92)
    {
      put1(i);
      pushType(localType);
      return;
    }
  }

  public void emitDup(int paramInt)
  {
    emitDup(paramInt, 0);
  }

  public void emitDup(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
      return;
    reserve(1);
    Type localType1 = popType();
    Type localType2;
    if (paramInt1 == 1)
    {
      int n = localType1.size;
      localType2 = null;
      if (n > 4)
        throw new Error("using dup for 2-word type");
    }
    else
    {
      if (paramInt1 != 2)
        throw new Error("invalid size to emitDup");
      int i = localType1.size;
      localType2 = null;
      if (i <= 4)
      {
        localType2 = popType();
        if (localType2.size > 4)
          throw new Error("dup will cause invalid types on stack");
      }
    }
    Type localType3 = null;
    Type localType4 = null;
    int j;
    if (paramInt2 == 0)
    {
      if (paramInt1 == 1)
        j = 89;
      while (true)
      {
        put1(j);
        if (localType2 != null)
          pushType(localType2);
        pushType(localType1);
        if (localType4 != null)
          pushType(localType4);
        if (localType3 != null)
          pushType(localType3);
        if (localType2 != null)
          pushType(localType2);
        pushType(localType1);
        return;
        j = 92;
        localType3 = null;
        localType4 = null;
      }
    }
    if (paramInt2 == 1)
    {
      if (paramInt1 == 1);
      for (j = 90; ; j = 93)
      {
        localType3 = popType();
        int m = localType3.size;
        localType4 = null;
        if (m <= 4)
          break;
        throw new Error("dup will cause invalid types on stack");
      }
    }
    if (paramInt2 == 2)
    {
      if (paramInt1 == 1);
      for (j = 91; ; j = 94)
      {
        localType3 = popType();
        int k = localType3.size;
        localType4 = null;
        if (k > 4)
          break;
        localType4 = popType();
        if (localType4.size <= 4)
          break;
        throw new Error("dup will cause invalid types on stack");
      }
    }
    throw new Error("emitDup:  invalid offset");
  }

  public void emitDup(Type paramType)
  {
    if (paramType.size > 4);
    for (int i = 2; ; i = 1)
    {
      emitDup(i, 0);
      return;
    }
  }

  public void emitDupX()
  {
    reserve(1);
    Type localType1 = popType();
    Type localType2 = popType();
    if (localType2.size <= 4)
    {
      if (localType1.size <= 4);
      for (int j = 90; ; j = 93)
      {
        put1(j);
        pushType(localType1);
        pushType(localType2);
        pushType(localType1);
        return;
      }
    }
    if (localType1.size <= 4);
    for (int i = 91; ; i = 94)
    {
      put1(i);
      break;
    }
  }

  public final void emitElse()
  {
    Label localLabel1 = this.if_stack.end_label;
    if (reachableHere())
    {
      Label localLabel2 = new Label(this);
      this.if_stack.end_label = localLabel2;
      int i = this.SP - this.if_stack.start_stack_size;
      this.if_stack.stack_growth = i;
      if (i > 0)
      {
        this.if_stack.then_stacked_types = new Type[i];
        System.arraycopy(this.stack_types, this.if_stack.start_stack_size, this.if_stack.then_stacked_types, 0, i);
        emitGoto(localLabel2);
      }
    }
    while (true)
    {
      if (this.SP <= this.if_stack.start_stack_size)
        break label143;
      popType();
      continue;
      this.if_stack.then_stacked_types = new Type[0];
      break;
      this.if_stack.end_label = null;
    }
    label143: this.SP = this.if_stack.start_stack_size;
    if (localLabel1 != null)
      localLabel1.define(this);
    this.if_stack.doing_else = true;
  }

  public final void emitFi()
  {
    int i = 0;
    int j;
    if (!this.if_stack.doing_else)
    {
      boolean bool2 = reachableHere();
      i = 0;
      if (bool2)
      {
        int m = this.SP;
        int n = this.if_stack.start_stack_size;
        i = 0;
        if (m != n)
          throw new Error("at PC " + this.PC + " then clause grows stack with no else clause");
      }
    }
    else
    {
      if (this.if_stack.then_stacked_types == null)
        break label272;
      j = this.if_stack.start_stack_size + this.if_stack.stack_growth;
      if (reachableHere())
        break label204;
      if (this.if_stack.stack_growth > 0)
        System.arraycopy(this.if_stack.then_stacked_types, 0, this.stack_types, this.if_stack.start_stack_size, this.if_stack.stack_growth);
      this.SP = j;
    }
    while (true)
    {
      if (this.if_stack.end_label != null)
        this.if_stack.end_label.define(this);
      if (i != 0)
        setUnreachable();
      this.if_stack = this.if_stack.previous;
      return;
      label204: int k = this.SP;
      i = 0;
      if (k != j)
      {
        throw new Error("at PC " + this.PC + ": SP at end of 'then' was " + j + " while SP at end of 'else' was " + this.SP);
        label272: boolean bool1 = this.unreachable_here;
        i = 0;
        if (bool1)
          i = 1;
      }
    }
  }

  public void emitFinallyEnd()
  {
    if (useJsr())
      emitRet(this.try_stack.finally_ret_addr);
    while (true)
    {
      popScope();
      this.try_stack.finally_subr = null;
      return;
      if ((this.try_stack.end_label == null) && (this.try_stack.exitCases == null))
      {
        emitThrow();
      }
      else
      {
        emitStore(this.try_stack.exception);
        emitLoad(this.try_stack.exception);
        emitIfNotNull();
        emitLoad(this.try_stack.exception);
        emitThrow();
        emitElse();
        Object localObject = this.try_stack.exitCases;
        if (localObject != null)
        {
          SwitchState localSwitchState = startSwitch();
          if (localObject != null)
          {
            ExitableBlock localExitableBlock = ((ExitableBlock)localObject).nextCase;
            ((ExitableBlock)localObject).nextCase = null;
            ((ExitableBlock)localObject).currentTryState = null;
            TryState localTryState = TryState.outerHandler(this.try_stack.previous, ((ExitableBlock)localObject).initialTryState);
            if (localTryState == ((ExitableBlock)localObject).initialTryState)
              localSwitchState.addCaseGoto(((ExitableBlock)localObject).switchCase, this, ((ExitableBlock)localObject).endLabel);
            while (true)
            {
              localObject = localExitableBlock;
              break;
              localSwitchState.addCase(((ExitableBlock)localObject).switchCase, this);
              ((ExitableBlock)localObject).exit(localTryState);
            }
          }
          this.try_stack.exitCases = null;
          localSwitchState.addDefault(this);
          localSwitchState.finish(this);
        }
        emitFi();
        setUnreachable();
      }
    }
  }

  public void emitFinallyStart()
  {
    emitTryEnd(true);
    if (this.try_stack.try_type != null)
      emitCatchEnd();
    this.try_stack.end_try = getLabel();
    pushScope();
    if (useJsr())
    {
      this.SP = 0;
      emitCatchStart(null);
      emitStore(this.try_stack.exception);
      emitJsr(this.try_stack.finally_subr);
      emitLoad(this.try_stack.exception);
      emitThrow();
    }
    while (true)
    {
      this.try_stack.finally_subr.define(this);
      if (useJsr())
      {
        ClassType localClassType = Type.objectType;
        this.try_stack.finally_ret_addr = addLocal(localClassType);
        pushType(localClassType);
        emitStore(this.try_stack.finally_ret_addr);
      }
      return;
      setUnreachable();
      int i = beginFragment(new Label(this));
      addHandler(this.try_stack.start_try, this.try_stack.end_try, Type.javalangThrowableType);
      if (this.try_stack.saved_result != null)
        emitStoreDefaultValue(this.try_stack.saved_result);
      if (this.try_stack.exitCases != null)
      {
        emitPushInt(-1);
        emitSwap();
      }
      emitGoto(this.try_stack.finally_subr);
      endFragment(i);
    }
  }

  public final void emitGetField(Field paramField)
  {
    popType();
    pushType(paramField.type);
    emitFieldop(paramField, 180);
  }

  public final void emitGetStatic(Field paramField)
  {
    pushType(paramField.type);
    emitFieldop(paramField, 178);
  }

  public final void emitGoto(Label paramLabel)
  {
    paramLabel.setTypes(this);
    fixupAdd(4, paramLabel);
    reserve(3);
    put1(167);
    this.PC = (2 + this.PC);
    setUnreachable();
  }

  public final void emitGotoIfCompare1(Label paramLabel, int paramInt)
  {
    popType();
    reserve(3);
    emitTransfer(paramLabel, paramInt);
  }

  public final void emitGotoIfCompare2(Label paramLabel, int paramInt)
  {
    if ((paramInt < 153) || (paramInt > 158))
      throw new Error("emitGotoIfCompare2: logop must be one of ifeq...ifle");
    Type localType1 = popType().promote();
    Type localType2 = popType().promote();
    reserve(4);
    int i = localType2.getSignature().charAt(0);
    int j = localType1.getSignature().charAt(0);
    int k;
    if ((paramInt == 155) || (paramInt == 158))
    {
      k = 1;
      if ((i != 73) || (j != 73))
        break label115;
      paramInt += 6;
    }
    while (true)
    {
      emitTransfer(paramLabel, paramInt);
      return;
      k = 0;
      break;
      label115: if ((i == 74) && (j == 74))
      {
        put1(148);
      }
      else
      {
        if ((i == 70) && (j == 70))
        {
          if (k != 0);
          for (int n = 149; ; n = 150)
          {
            put1(n);
            break;
          }
        }
        if ((i == 68) && (j == 68))
        {
          if (k != 0);
          for (int m = 151; ; m = 152)
          {
            put1(m);
            break;
          }
        }
        if (((i != 76) && (i != 91)) || ((j != 76) && (j != 91)) || (paramInt > 154))
          break label262;
        paramInt += 12;
      }
    }
    label262: throw new Error("invalid types to emitGotoIfCompare2");
  }

  public final void emitGotoIfEq(Label paramLabel)
  {
    emitGotoIfCompare2(paramLabel, 153);
  }

  public final void emitGotoIfEq(Label paramLabel, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 154; ; i = 153)
    {
      emitGotoIfCompare2(paramLabel, i);
      return;
    }
  }

  public final void emitGotoIfGe(Label paramLabel)
  {
    emitGotoIfCompare2(paramLabel, 156);
  }

  public final void emitGotoIfGt(Label paramLabel)
  {
    emitGotoIfCompare2(paramLabel, 157);
  }

  public final void emitGotoIfIntEqZero(Label paramLabel)
  {
    emitGotoIfCompare1(paramLabel, 153);
  }

  public final void emitGotoIfIntGeZero(Label paramLabel)
  {
    emitGotoIfCompare1(paramLabel, 156);
  }

  public final void emitGotoIfIntGtZero(Label paramLabel)
  {
    emitGotoIfCompare1(paramLabel, 157);
  }

  public final void emitGotoIfIntLeZero(Label paramLabel)
  {
    emitGotoIfCompare1(paramLabel, 158);
  }

  public final void emitGotoIfIntLtZero(Label paramLabel)
  {
    emitGotoIfCompare1(paramLabel, 155);
  }

  public final void emitGotoIfIntNeZero(Label paramLabel)
  {
    emitGotoIfCompare1(paramLabel, 154);
  }

  public final void emitGotoIfLe(Label paramLabel)
  {
    emitGotoIfCompare2(paramLabel, 158);
  }

  public final void emitGotoIfLt(Label paramLabel)
  {
    emitGotoIfCompare2(paramLabel, 155);
  }

  public final void emitGotoIfNE(Label paramLabel)
  {
    emitGotoIfCompare2(paramLabel, 154);
  }

  public final void emitIOr()
  {
    emitBinop(128);
  }

  public final void emitIfCompare1(int paramInt)
  {
    IfState localIfState = new IfState(this);
    if (popType().promote() != Type.intType)
      throw new Error("non-int type to emitIfCompare1");
    reserve(3);
    emitTransfer(localIfState.end_label, paramInt);
    localIfState.start_stack_size = this.SP;
  }

  public final void emitIfEq()
  {
    IfState localIfState = new IfState(this);
    emitGotoIfNE(localIfState.end_label);
    localIfState.start_stack_size = this.SP;
  }

  public final void emitIfGe()
  {
    IfState localIfState = new IfState(this);
    emitGotoIfLt(localIfState.end_label);
    localIfState.start_stack_size = this.SP;
  }

  public final void emitIfGt()
  {
    IfState localIfState = new IfState(this);
    emitGotoIfLe(localIfState.end_label);
    localIfState.start_stack_size = this.SP;
  }

  public final void emitIfIntCompare(int paramInt)
  {
    IfState localIfState = new IfState(this);
    popType();
    popType();
    reserve(3);
    emitTransfer(localIfState.end_label, paramInt);
    localIfState.start_stack_size = this.SP;
  }

  public final void emitIfIntEqZero()
  {
    emitIfCompare1(154);
  }

  public final void emitIfIntLEqZero()
  {
    emitIfCompare1(157);
  }

  public final void emitIfIntLt()
  {
    emitIfIntCompare(162);
  }

  public final void emitIfIntNotZero()
  {
    emitIfCompare1(153);
  }

  public final void emitIfLe()
  {
    IfState localIfState = new IfState(this);
    emitGotoIfGt(localIfState.end_label);
    localIfState.start_stack_size = this.SP;
  }

  public final void emitIfLt()
  {
    IfState localIfState = new IfState(this);
    emitGotoIfGe(localIfState.end_label);
    localIfState.start_stack_size = this.SP;
  }

  public final void emitIfNEq()
  {
    IfState localIfState = new IfState(this);
    emitGotoIfEq(localIfState.end_label);
    localIfState.start_stack_size = this.SP;
  }

  public final void emitIfNotNull()
  {
    emitIfRefCompare1(198);
  }

  public final void emitIfNull()
  {
    emitIfRefCompare1(199);
  }

  public final void emitIfRefCompare1(int paramInt)
  {
    IfState localIfState = new IfState(this);
    if (!(popType() instanceof ObjectType))
      throw new Error("non-ref type to emitIfRefCompare1");
    reserve(3);
    emitTransfer(localIfState.end_label, paramInt);
    localIfState.start_stack_size = this.SP;
  }

  public final void emitIfThen()
  {
    new IfState(this, null);
  }

  public void emitInc(Variable paramVariable, short paramShort)
  {
    if (paramVariable.dead())
      throw new Error("attempting to increment dead variable");
    int i = paramVariable.offset;
    if ((i < 0) || (!paramVariable.isSimple()))
      throw new Error("attempting to increment unassigned variable" + paramVariable.getName() + " simple:" + paramVariable.isSimple() + ", offset: " + i);
    reserve(6);
    if (paramVariable.getType().getImplementationType().promote() != Type.intType)
      throw new Error("attempting to increment non-int variable");
    if ((i > 255) || (paramShort > 255) || (paramShort < -256));
    for (int j = 1; j != 0; j = 0)
    {
      put1(196);
      put1(132);
      put2(i);
      put2(paramShort);
      return;
    }
    put1(132);
    put1(i);
    put1(paramShort);
  }

  public void emitInstanceof(Type paramType)
  {
    emitCheckcast(paramType, 193);
    pushType(Type.booleanType);
  }

  public void emitInvoke(Method paramMethod)
  {
    int i;
    if ((0x8 & paramMethod.access_flags) != 0)
      i = 184;
    while (true)
    {
      emitInvokeMethod(paramMethod, i);
      return;
      if (paramMethod.classfile.isInterface())
        i = 185;
      else if ("<init>".equals(paramMethod.getName()))
        i = 183;
      else
        i = 182;
    }
  }

  public void emitInvokeInterface(Method paramMethod)
  {
    emitInvokeMethod(paramMethod, 185);
  }

  public void emitInvokeMethod(Method paramMethod, int paramInt)
  {
    int i;
    int j;
    int k;
    label31: int m;
    if (paramInt == 185)
    {
      i = 5;
      reserve(i);
      j = paramMethod.arg_types.length;
      if (paramInt != 184)
        break label110;
      k = 1;
      if ((paramInt != 183) || (!"<init>".equals(paramMethod.getName())))
        break label116;
      m = 1;
      label54: if ((0x8 & paramMethod.access_flags) == 0)
        break label122;
    }
    label110: label116: label122: for (int n = 1; ; n = 0)
    {
      if (k == n)
        break label128;
      throw new Error("emitInvokeXxx static flag mis-match method.flags=" + paramMethod.access_flags);
      i = 3;
      break;
      k = 0;
      break label31;
      m = 0;
      break label54;
    }
    label128: if ((k == 0) && (m == 0))
      j++;
    put1(paramInt);
    putIndex2(getConstants().addMethodRef(paramMethod));
    if (paramInt == 185)
    {
      put1(1 + words(paramMethod.arg_types));
      put1(0);
    }
    Type localType2;
    do
    {
      j--;
      if (j < 0)
        break;
      localType2 = popType();
    }
    while (!(localType2 instanceof UninitializedType));
    throw new Error("passing " + localType2 + " as parameter");
    if (m != 0)
    {
      Type localType1 = popType();
      if (!(localType1 instanceof UninitializedType))
        throw new Error("calling <init> on already-initialized object");
      ClassType localClassType = ((UninitializedType)localType1).ctype;
      for (int i1 = 0; i1 < this.SP; i1++)
        if (this.stack_types[i1] == localType1)
          this.stack_types[i1] = localClassType;
      Variable[] arrayOfVariable = this.locals.used;
      int i2;
      if (arrayOfVariable == null)
        i2 = 0;
      while (true)
      {
        i2--;
        if (i2 < 0)
          break;
        Variable localVariable = arrayOfVariable[i2];
        if ((localVariable != null) && (localVariable.type == localType1))
        {
          localVariable.type = localClassType;
          continue;
          i2 = arrayOfVariable.length;
        }
      }
      int i3;
      if (this.local_types == null)
        i3 = 0;
      while (true)
      {
        i3--;
        if (i3 < 0)
          break;
        if (this.local_types[i3] == localType1)
        {
          this.local_types[i3] = localClassType;
          continue;
          i3 = this.local_types.length;
        }
      }
    }
    if (paramMethod.return_type.size != 0)
      pushType(paramMethod.return_type);
  }

  public void emitInvokeSpecial(Method paramMethod)
  {
    emitInvokeMethod(paramMethod, 183);
  }

  public void emitInvokeStatic(Method paramMethod)
  {
    emitInvokeMethod(paramMethod, 184);
  }

  public void emitInvokeVirtual(Method paramMethod)
  {
    emitInvokeMethod(paramMethod, 182);
  }

  public final void emitJsr(Label paramLabel)
  {
    fixupAdd(5, paramLabel);
    reserve(3);
    put1(168);
    this.PC = (2 + this.PC);
  }

  public final void emitLoad(Variable paramVariable)
  {
    if (paramVariable.dead())
      throw new Error("attempting to push dead variable");
    int i = paramVariable.offset;
    if ((i < 0) || (!paramVariable.isSimple()))
      throw new Error("attempting to load from unassigned variable " + paramVariable + " simple:" + paramVariable.isSimple() + ", offset: " + i);
    Type localType = paramVariable.getType().promote();
    reserve(4);
    int j = adjustTypedOp(localType);
    if (i <= 3)
      put1(i + (26 + j * 4));
    while (true)
    {
      pushType(paramVariable.getType());
      return;
      emitMaybeWide(j + 21, i);
    }
  }

  void emitMaybeWide(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 256)
    {
      put1(196);
      put1(paramInt1);
      put2(paramInt2);
      return;
    }
    put1(paramInt1);
    put1(paramInt2);
  }

  public final void emitMonitorEnter()
  {
    popType();
    reserve(1);
    put1(194);
  }

  public final void emitMonitorExit()
  {
    popType();
    reserve(1);
    put1(195);
  }

  public final void emitMul()
  {
    emitBinop(104);
  }

  public void emitNew(ClassType paramClassType)
  {
    reserve(3);
    Label localLabel = new Label(this);
    localLabel.defineRaw(this);
    put1(187);
    putIndex2(getConstants().addClass(paramClassType));
    pushType(new UninitializedType(paramClassType, localLabel));
  }

  void emitNewArray(int paramInt)
  {
    reserve(2);
    put1(188);
    put1(paramInt);
  }

  public void emitNewArray(Type paramType)
  {
    emitNewArray(paramType, 1);
  }

  public void emitNewArray(Type paramType, int paramInt)
  {
    if (popType().promote() != Type.intType)
      throw new Error("non-int dim. spec. in emitNewArray");
    int i;
    if ((paramType instanceof PrimType))
      switch (paramType.getSignature().charAt(0))
      {
      default:
        throw new Error("bad PrimType in emitNewArray");
      case 'B':
        i = 8;
        emitNewArray(i);
      case 'S':
      case 'I':
      case 'J':
      case 'F':
      case 'D':
      case 'Z':
      case 'C':
      }
    label221: 
    do
      do
      {
        while (true)
        {
          pushType(new ArrayType(paramType));
          return;
          i = 9;
          break;
          i = 10;
          break;
          i = 11;
          break;
          i = 6;
          break;
          i = 7;
          break;
          i = 4;
          break;
          i = 5;
          break;
          if (!(paramType instanceof ObjectType))
            break label221;
          reserve(3);
          put1(189);
          putIndex2(getConstants().addClass((ObjectType)paramType));
        }
        if (!(paramType instanceof ArrayType))
          break label318;
        reserve(4);
        put1(197);
        putIndex2(getConstants().addClass(new ArrayType(paramType)));
        if ((paramInt < 1) || (paramInt > 255))
          throw new Error("dims out of range in emitNewArray");
        put1(paramInt);
        paramInt--;
      }
      while (paramInt <= 0);
    while (popType().promote() == Type.intType);
    throw new Error("non-int dim. spec. in emitNewArray");
    label318: throw new Error("unimplemented type in emitNewArray");
  }

  public final void emitNot(Type paramType)
  {
    emitPushConstant(1, paramType);
    emitAdd();
    emitPushConstant(1, paramType);
    emitAnd();
  }

  public void emitPop(int paramInt)
  {
    if (paramInt > 0)
    {
      reserve(1);
      if (popType().size > 4)
        put1(88);
      while (true)
      {
        paramInt--;
        break;
        if (paramInt > 1)
        {
          if (popType().size > 4)
          {
            put1(87);
            reserve(1);
          }
          put1(88);
          paramInt--;
        }
        else
        {
          put1(87);
        }
      }
    }
  }

  public void emitPrimop(int paramInt1, int paramInt2, Type paramType)
  {
    reserve(1);
    while (true)
    {
      paramInt2--;
      if (paramInt2 < 0)
        break;
      popType();
    }
    put1(paramInt1);
    pushType(paramType);
  }

  public final void emitPushClass(ObjectType paramObjectType)
  {
    emitPushConstant(getConstants().addClass(paramObjectType));
    pushType(Type.javalangClassType);
  }

  public final void emitPushConstant(int paramInt, Type paramType)
  {
    switch (paramType.getSignature().charAt(0))
    {
    default:
      throw new Error("bad type to emitPushConstant");
    case 'B':
    case 'C':
    case 'I':
    case 'S':
    case 'Z':
      emitPushInt(paramInt);
      return;
    case 'J':
      emitPushLong(paramInt);
      return;
    case 'F':
      emitPushFloat(paramInt);
      return;
    case 'D':
    }
    emitPushDouble(paramInt);
  }

  public final void emitPushConstant(CpoolEntry paramCpoolEntry)
  {
    reserve(3);
    int i = paramCpoolEntry.index;
    if ((paramCpoolEntry instanceof CpoolValue2))
    {
      put1(20);
      put2(i);
      return;
    }
    if (i < 256)
    {
      put1(18);
      put1(i);
      return;
    }
    put1(19);
    put2(i);
  }

  public void emitPushDefaultValue(Type paramType)
  {
    Type localType = paramType.getImplementationType();
    if ((localType instanceof PrimType))
    {
      emitPushConstant(0, localType);
      return;
    }
    emitPushNull();
  }

  public void emitPushDouble(double paramDouble)
  {
    int i = (int)paramDouble;
    if ((i == paramDouble) && (i >= -128) && (i < 128))
      if ((i == 0) || (i == 1))
      {
        reserve(1);
        put1(i + 14);
        if ((i == 0) && (Double.doubleToLongBits(paramDouble) != 0L))
        {
          reserve(1);
          put1(119);
        }
      }
    while (true)
    {
      pushType(Type.doubleType);
      return;
      emitPushInt(i);
      reserve(1);
      popType();
      put1(135);
      continue;
      emitPushConstant(getConstants().addDouble(paramDouble));
    }
  }

  public void emitPushFloat(float paramFloat)
  {
    int i = (int)paramFloat;
    if ((i == paramFloat) && (i >= -128) && (i < 128))
      if ((i >= 0) && (i <= 2))
      {
        reserve(1);
        put1(i + 11);
        if ((i == 0) && (Float.floatToIntBits(paramFloat) != 0))
        {
          reserve(1);
          put1(118);
        }
      }
    while (true)
    {
      pushType(Type.floatType);
      return;
      emitPushInt(i);
      reserve(1);
      popType();
      put1(134);
      continue;
      emitPushConstant(getConstants().addFloat(paramFloat));
    }
  }

  public final void emitPushInt(int paramInt)
  {
    reserve(3);
    if ((paramInt >= -1) && (paramInt <= 5))
      put1(paramInt + 3);
    while (true)
    {
      pushType(Type.intType);
      return;
      if ((paramInt >= -128) && (paramInt < 128))
      {
        put1(16);
        put1(paramInt);
      }
      else if ((paramInt >= -32768) && (paramInt < 32768))
      {
        put1(17);
        put2(paramInt);
      }
      else
      {
        emitPushConstant(getConstants().addInt(paramInt));
      }
    }
  }

  public void emitPushLong(long paramLong)
  {
    if ((paramLong == 0L) || (paramLong == 1L))
    {
      reserve(1);
      put1(9 + (int)paramLong);
    }
    while (true)
    {
      pushType(Type.longType);
      return;
      if ((int)paramLong == paramLong)
      {
        emitPushInt((int)paramLong);
        reserve(1);
        popType();
        put1(133);
      }
      else
      {
        emitPushConstant(getConstants().addLong(paramLong));
      }
    }
  }

  public void emitPushNull()
  {
    reserve(1);
    put1(1);
    pushType(Type.nullType);
  }

  public final void emitPushPrimArray(Object paramObject, ArrayType paramArrayType)
  {
    Type localType = paramArrayType.getComponentType();
    int i = Array.getLength(paramObject);
    emitPushInt(i);
    emitNewArray(localType);
    int j = localType.getSignature().charAt(0);
    int k = 0;
    if (k < i)
    {
      long l = 0L;
      double d = 0.0D;
      float f = 0.0F;
      switch (j)
      {
      default:
        label128: emitDup(paramArrayType);
        emitPushInt(k);
        switch (j)
        {
        default:
        case 66:
        case 67:
        case 73:
        case 83:
        case 90:
        case 74:
        case 70:
        case 68:
        }
        break;
      case 74:
      case 73:
      case 83:
      case 67:
      case 66:
      case 90:
      case 70:
      case 68:
      }
      while (true)
      {
        emitArrayStore(localType);
        while (true)
        {
          label221: k++;
          break;
          l = ((long[])(long[])paramObject)[k];
          boolean bool7 = l < 0L;
          f = 0.0F;
          if (bool7)
            break label128;
          continue;
          l = ((int[])(int[])paramObject)[k];
          boolean bool6 = l < 0L;
          f = 0.0F;
          if (bool6)
            break label128;
          continue;
          l = ((short[])(short[])paramObject)[k];
          boolean bool5 = l < 0L;
          f = 0.0F;
          if (bool5)
            break label128;
          continue;
          l = ((char[])(char[])paramObject)[k];
          boolean bool4 = l < 0L;
          f = 0.0F;
          if (bool4)
            break label128;
          continue;
          l = ((byte[])(byte[])paramObject)[k];
          boolean bool3 = l < 0L;
          f = 0.0F;
          if (bool3)
            break label128;
          continue;
          if (((boolean[])(boolean[])paramObject)[k] != 0);
          for (l = 1L; ; l = 0L)
          {
            boolean bool2 = l < 0L;
            f = 0.0F;
            if (bool2)
              break;
            break label221;
          }
          f = ((float[])(float[])paramObject)[k];
          if (f != 0.0D)
            break label128;
          continue;
          d = ((double[])(double[])paramObject)[k];
          boolean bool1 = d < 0.0D;
          f = 0.0F;
          if (bool1)
            break label128;
        }
        emitPushInt((int)l);
        continue;
        emitPushLong(l);
        continue;
        emitPushFloat(f);
        continue;
        emitPushDouble(d);
      }
    }
  }

  public final void emitPushString(String paramString)
  {
    if (paramString == null)
      emitPushNull();
    while (true)
    {
      return;
      int i = paramString.length();
      String str = calculateSplit(paramString);
      int j = str.length();
      if (j <= 1)
      {
        emitPushConstant(getConstants().addString(paramString));
        pushType(Type.javalangStringType);
        return;
      }
      if (j == 2)
      {
        int i1 = str.charAt(0);
        emitPushString(paramString.substring(0, i1));
        emitPushString(paramString.substring(i1));
        emitInvokeVirtual(Type.javalangStringType.getDeclaredMethod("concat", 1));
      }
      while (paramString == paramString.intern())
      {
        emitInvokeVirtual(Type.javalangStringType.getDeclaredMethod("intern", 0));
        return;
        ClassType localClassType = ClassType.make("java.lang.StringBuffer");
        emitNew(localClassType);
        emitDup(localClassType);
        emitPushInt(i);
        Type[] arrayOfType1 = new Type[1];
        arrayOfType1[0] = Type.intType;
        emitInvokeSpecial(localClassType.getDeclaredMethod("<init>", arrayOfType1));
        Type[] arrayOfType2 = new Type[1];
        arrayOfType2[0] = Type.javalangStringType;
        Method localMethod = localClassType.getDeclaredMethod("append", arrayOfType2);
        int k = 0;
        for (int m = 0; m < j; m++)
        {
          emitDup(localClassType);
          int n = k + str.charAt(m);
          emitPushString(paramString.substring(k, n));
          emitInvokeVirtual(localMethod);
          k = n;
        }
        emitInvokeVirtual(Type.toString_method);
      }
    }
  }

  public final void emitPushThis()
  {
    emitLoad(this.locals.used[0]);
  }

  public final void emitPutField(Field paramField)
  {
    popType();
    popType();
    emitFieldop(paramField, 181);
  }

  public final void emitPutStatic(Field paramField)
  {
    popType();
    emitFieldop(paramField, 179);
  }

  final void emitRawReturn()
  {
    if (getMethod().getReturnType().size == 0)
    {
      reserve(1);
      put1(177);
    }
    while (true)
    {
      setUnreachable();
      return;
      emitTypedOp(172, popType().promote());
    }
  }

  public final void emitRem()
  {
    emitBinop(112);
  }

  public void emitRet(Variable paramVariable)
  {
    int i = paramVariable.offset;
    if (i < 256)
    {
      reserve(2);
      put1(169);
      put1(i);
      return;
    }
    reserve(4);
    put1(196);
    put1(169);
    put2(i);
  }

  public final void emitReturn()
  {
    if (this.try_stack != null)
      new Error();
    emitRawReturn();
  }

  public final void emitShl()
  {
    emitShift(120);
  }

  public final void emitShr()
  {
    emitShift(122);
  }

  public void emitStore(Variable paramVariable)
  {
    int i = paramVariable.offset;
    if ((i < 0) || (!paramVariable.isSimple()))
      throw new Error("attempting to store in unassigned " + paramVariable + " simple:" + paramVariable.isSimple() + ", offset: " + i);
    Type localType = paramVariable.getType().promote();
    noteVarType(i, localType);
    reserve(4);
    popType();
    int j = adjustTypedOp(localType);
    if (i <= 3)
    {
      put1(i + (59 + j * 4));
      return;
    }
    emitMaybeWide(j + 54, i);
  }

  public void emitStoreDefaultValue(Variable paramVariable)
  {
    emitPushDefaultValue(paramVariable.getType());
    emitStore(paramVariable);
  }

  public final void emitSub()
  {
    emitBinop(100);
  }

  public final void emitSub(char paramChar)
  {
    emitBinop(100, paramChar);
  }

  public final void emitSub(PrimType paramPrimType)
  {
    emitBinop(100, paramPrimType);
  }

  public void emitSwap()
  {
    reserve(1);
    Type localType1 = popType();
    Type localType2 = popType();
    if ((localType1.size > 4) || (localType2.size > 4))
    {
      pushType(localType2);
      pushType(localType1);
      emitDupX();
      emitPop(1);
      return;
    }
    pushType(localType1);
    put1(95);
    pushType(localType2);
  }

  public void emitTailCall(boolean paramBoolean, Scope paramScope)
  {
    if (paramBoolean)
    {
      Method localMethod = getMethod();
      int i;
      if ((0x8 & localMethod.access_flags) != 0)
      {
        i = 0;
        int j = localMethod.arg_types.length;
        label29: j--;
        if (j < 0)
          break label76;
        if (localMethod.arg_types[j].size <= 4)
          break label70;
      }
      label70: for (int n = 2; ; n = 1)
      {
        i += n;
        break label29;
        i = 1;
        break;
      }
      label76: int k = localMethod.arg_types.length;
      k--;
      if (k >= 0)
      {
        if (localMethod.arg_types[k].size > 4);
        for (int m = 2; ; m = 1)
        {
          i -= m;
          emitStore(this.locals.used[i]);
          break;
        }
      }
    }
    emitGoto(paramScope.start);
  }

  public final void emitThen()
  {
    this.if_stack.start_stack_size = this.SP;
  }

  public final void emitThrow()
  {
    popType();
    reserve(1);
    put1(191);
    setUnreachable();
  }

  final void emitTransfer(Label paramLabel, int paramInt)
  {
    paramLabel.setTypes(this);
    fixupAdd(6, paramLabel);
    put1(paramInt);
    this.PC = (2 + this.PC);
  }

  public void emitTryCatchEnd()
  {
    if (this.try_stack.finally_subr != null)
      emitFinallyEnd();
    Variable[] arrayOfVariable = this.try_stack.savedStack;
    if (this.try_stack.end_label == null)
      setUnreachable();
    while (true)
    {
      if ((this.try_stack.saved_result != null) || (arrayOfVariable != null))
        popScope();
      this.try_stack = this.try_stack.previous;
      return;
      setTypes(this.try_stack.start_try.localTypes, Type.typeArray0);
      this.try_stack.end_label.define(this);
      if (arrayOfVariable != null)
      {
        int i = arrayOfVariable.length;
        while (true)
        {
          i--;
          if (i < 0)
            break;
          Variable localVariable = arrayOfVariable[i];
          if (localVariable != null)
            emitLoad(localVariable);
        }
      }
      if (this.try_stack.saved_result != null)
        emitLoad(this.try_stack.saved_result);
    }
  }

  public void emitTryEnd()
  {
    emitTryEnd(false);
  }

  public void emitTryStart(boolean paramBoolean, Type paramType)
  {
    if ((paramType != null) && (paramType.isVoid()))
      paramType = null;
    if ((paramType != null) || (this.SP > 0))
      pushScope();
    int i = this.SP;
    Variable[] arrayOfVariable = null;
    if (i > 0)
    {
      arrayOfVariable = new Variable[this.SP];
      int m;
      for (int k = 0; this.SP > 0; k = m)
      {
        Variable localVariable = addLocal(topType());
        emitStore(localVariable);
        m = k + 1;
        arrayOfVariable[k] = localVariable;
      }
    }
    TryState localTryState = new TryState(this);
    localTryState.savedStack = arrayOfVariable;
    int j;
    Type[] arrayOfType;
    if (this.local_types == null)
    {
      j = 0;
      if ((j > 0) && (this.local_types[(j - 1)] == null))
        break label203;
      if (j != 0)
        break label209;
      arrayOfType = Type.typeArray0;
    }
    while (true)
    {
      localTryState.start_try.localTypes = arrayOfType;
      if (paramType != null)
        localTryState.saved_result = addLocal(paramType);
      if (paramBoolean)
        localTryState.finally_subr = new Label();
      return;
      j = this.local_types.length;
      break;
      label203: j--;
      break;
      label209: arrayOfType = new Type[j];
      System.arraycopy(this.local_types, 0, arrayOfType, 0, j);
    }
  }

  public final void emitUshr()
  {
    emitShift(124);
  }

  public void emitWithCleanupCatch(Variable paramVariable)
  {
    emitTryEnd();
    Type[] arrayOfType;
    if (this.SP > 0)
    {
      arrayOfType = new Type[this.SP];
      System.arraycopy(this.stack_types, 0, arrayOfType, 0, this.SP);
      this.SP = 0;
    }
    while (true)
    {
      this.try_stack.savedTypes = arrayOfType;
      this.try_stack.saved_result = paramVariable;
      emitCatchStart(paramVariable);
      return;
      arrayOfType = null;
    }
  }

  public void emitWithCleanupDone()
  {
    Variable localVariable = this.try_stack.saved_result;
    this.try_stack.saved_result = null;
    if (localVariable != null)
      emitLoad(localVariable);
    emitThrow();
    emitCatchEnd();
    Type[] arrayOfType = this.try_stack.savedTypes;
    emitTryCatchEnd();
    if (arrayOfType != null)
    {
      this.SP = arrayOfType.length;
      if (this.SP >= this.stack_types.length)
      {
        this.stack_types = arrayOfType;
        return;
      }
      System.arraycopy(arrayOfType, 0, this.stack_types, 0, this.SP);
      return;
    }
    this.SP = 0;
  }

  public void emitWithCleanupStart()
  {
    int i = this.SP;
    this.SP = 0;
    emitTryStart(false, null);
    this.SP = i;
  }

  public final void emitXOr()
  {
    emitBinop(130);
  }

  public void endExitableBlock()
  {
    ExitableBlock localExitableBlock = this.currentExitableBlock;
    localExitableBlock.finish();
    this.currentExitableBlock = localExitableBlock.outer;
  }

  public void endFragment(int paramInt)
  {
    this.fixup_offsets[paramInt] = (0xA | this.fixup_count << 4);
    Label localLabel = this.fixup_labels[paramInt];
    fixupAdd(9, 0, null);
    localLabel.define(this);
  }

  public void enterScope(Scope paramScope)
  {
    paramScope.setStartPC(this);
    this.locals.enterScope(paramScope);
  }

  final void fixupAdd(int paramInt1, int paramInt2, Label paramLabel)
  {
    if ((paramLabel != null) && (paramInt1 != 1) && (paramInt1 != 0) && (paramInt1 != 2) && (paramInt1 != 11))
      paramLabel.needsStackMapEntry = true;
    int i = this.fixup_count;
    if (i == 0)
    {
      this.fixup_offsets = new int[30];
      this.fixup_labels = new Label[30];
    }
    while (true)
    {
      this.fixup_offsets[i] = (paramInt1 | paramInt2 << 4);
      this.fixup_labels[i] = paramLabel;
      this.fixup_count = (i + 1);
      return;
      if (this.fixup_count == this.fixup_offsets.length)
      {
        int j = i * 2;
        Label[] arrayOfLabel = new Label[j];
        System.arraycopy(this.fixup_labels, 0, arrayOfLabel, 0, i);
        this.fixup_labels = arrayOfLabel;
        int[] arrayOfInt = new int[j];
        System.arraycopy(this.fixup_offsets, 0, arrayOfInt, 0, i);
        this.fixup_offsets = arrayOfInt;
      }
    }
  }

  public final void fixupAdd(int paramInt, Label paramLabel)
  {
    fixupAdd(paramInt, this.PC, paramLabel);
  }

  public final void fixupChain(Label paramLabel1, Label paramLabel2)
  {
    fixupAdd(9, 0, paramLabel2);
    paramLabel1.defineRaw(this);
  }

  public Variable getArg(int paramInt)
  {
    return this.locals.parameter_scope.getVariable(paramInt);
  }

  public final Attribute getAttributes()
  {
    return this.attributes;
  }

  public byte[] getCode()
  {
    return this.code;
  }

  public int getCodeLength()
  {
    return this.PC;
  }

  public final ConstantPool getConstants()
  {
    return getMethod().classfile.constants;
  }

  public Scope getCurrentScope()
  {
    return this.locals.current_scope;
  }

  public final TryState getCurrentTry()
  {
    return this.try_stack;
  }

  public Label getLabel()
  {
    Label localLabel = new Label();
    localLabel.defineRaw(this);
    return localLabel;
  }

  public final int getLength()
  {
    return 12 + getCodeLength() + 8 * this.exception_table_length + Attribute.getLengthAll(this);
  }

  public int getMaxLocals()
  {
    return this.max_locals;
  }

  public int getMaxStack()
  {
    return this.max_stack;
  }

  public final Method getMethod()
  {
    return (Method)getContainer();
  }

  public final int getPC()
  {
    return this.PC;
  }

  public final int getSP()
  {
    return this.SP;
  }

  byte invert_opcode(byte paramByte)
  {
    int i = paramByte & 0xFF;
    if (((i >= 153) && (i <= 166)) || ((i >= 198) && (i <= 199)))
      return (byte)(i ^ 0x1);
    throw new Error("unknown opcode to invert_opcode");
  }

  public final boolean isInTry()
  {
    return this.try_stack != null;
  }

  public Variable lookup(String paramString)
  {
    for (Scope localScope = this.locals.current_scope; localScope != null; localScope = localScope.parent)
    {
      Variable localVariable = localScope.lookup(paramString);
      if (localVariable != null)
        return localVariable;
    }
    return null;
  }

  void noteParamTypes()
  {
    Method localMethod = getMethod();
    int i = 0x8 & localMethod.access_flags;
    int j = 0;
    if (i == 0)
    {
      Object localObject = localMethod.classfile;
      if (("<init>".equals(localMethod.getName())) && (!"java.lang.Object".equals(((Type)localObject).getName())))
        localObject = UninitializedType.uninitializedThis((ClassType)localObject);
      int i8 = 0 + 1;
      noteVarType(0, (Type)localObject);
      j = i8;
    }
    int k = localMethod.arg_types.length;
    int m = 0;
    int i6;
    for (int n = j; m < k; n = i6)
    {
      Type localType = localMethod.arg_types[m];
      i6 = n + 1;
      noteVarType(n, localType);
      int i7 = localType.getSizeInWords();
      while (true)
      {
        i7--;
        if (i7 <= 0)
          break;
        i6++;
      }
      m++;
    }
    if ((0x1 & this.flags) != 0)
    {
      this.stackMap = new StackMapTableAttr();
      int[] arrayOfInt = new int[n + 20];
      int i1 = 0;
      int i4;
      for (int i2 = 0; i1 < n; i2 = i4)
      {
        int i3 = this.stackMap.encodeVerificationType(this.local_types[i1], this);
        i4 = i2 + 1;
        arrayOfInt[i2] = i3;
        int i5 = i3 & 0xFF;
        if ((i5 == 3) || (i5 == 4))
          i1++;
        i1++;
      }
      this.stackMap.encodedLocals = arrayOfInt;
      this.stackMap.countLocals = i2;
      this.stackMap.encodedStack = new int[10];
      this.stackMap.countStack = 0;
    }
  }

  public void noteVarType(int paramInt, Type paramType)
  {
    int i = paramType.getSizeInWords();
    if (this.local_types == null)
    {
      this.local_types = new Type[20 + (paramInt + i)];
      this.local_types[paramInt] = paramType;
      if (this.varsSetInCurrentBlock != null)
        break label164;
      this.varsSetInCurrentBlock = new boolean[this.local_types.length];
    }
    while (true)
    {
      this.varsSetInCurrentBlock[paramInt] = true;
      if (paramInt > 0)
      {
        Type localType = this.local_types[(paramInt - 1)];
        if ((localType != null) && (localType.getSizeInWords() == 2))
          this.local_types[(paramInt - 1)] = null;
      }
      while (true)
      {
        i--;
        if (i <= 0)
          break;
        Type[] arrayOfType2 = this.local_types;
        paramInt++;
        arrayOfType2[paramInt] = null;
      }
      if (paramInt + i <= this.local_types.length)
        break;
      Type[] arrayOfType1 = new Type[2 * (paramInt + i)];
      System.arraycopy(this.local_types, 0, arrayOfType1, 0, this.local_types.length);
      this.local_types = arrayOfType1;
      break;
      label164: if (this.varsSetInCurrentBlock.length <= paramInt)
      {
        boolean[] arrayOfBoolean = new boolean[this.local_types.length];
        System.arraycopy(this.varsSetInCurrentBlock, 0, arrayOfBoolean, 0, this.varsSetInCurrentBlock.length);
        this.varsSetInCurrentBlock = arrayOfBoolean;
      }
    }
  }

  public Scope popScope()
  {
    Scope localScope = this.locals.current_scope;
    this.locals.current_scope = localScope.parent;
    localScope.freeLocals(this);
    localScope.end = getLabel();
    return localScope;
  }

  public final Type popType()
  {
    if (this.SP <= 0)
      throw new Error("popType called with empty stack " + getMethod());
    Type[] arrayOfType = this.stack_types;
    int i = this.SP - 1;
    this.SP = i;
    Type localType = arrayOfType[i];
    if ((localType.size == 8) && (!popType().isVoid()))
      throw new Error("missing void type on stack");
    return localType;
  }

  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    paramClassTypeWriter.print("Attribute \"");
    paramClassTypeWriter.print(getName());
    paramClassTypeWriter.print("\", length:");
    paramClassTypeWriter.print(getLength());
    paramClassTypeWriter.print(", max_stack:");
    paramClassTypeWriter.print(this.max_stack);
    paramClassTypeWriter.print(", max_locals:");
    paramClassTypeWriter.print(this.max_locals);
    paramClassTypeWriter.print(", code_length:");
    int i = getCodeLength();
    paramClassTypeWriter.println(i);
    disAssemble(paramClassTypeWriter, 0, i);
    if (this.exception_table_length > 0)
    {
      paramClassTypeWriter.print("Exceptions (count: ");
      paramClassTypeWriter.print(this.exception_table_length);
      paramClassTypeWriter.println("):");
      int j = this.exception_table_length;
      int k = 0;
      j--;
      if (j >= 0)
      {
        paramClassTypeWriter.print("  start: ");
        paramClassTypeWriter.print(0xFFFF & this.exception_table[k]);
        paramClassTypeWriter.print(", end: ");
        paramClassTypeWriter.print(0xFFFF & this.exception_table[(k + 1)]);
        paramClassTypeWriter.print(", handler: ");
        paramClassTypeWriter.print(0xFFFF & this.exception_table[(k + 2)]);
        paramClassTypeWriter.print(", type: ");
        int m = 0xFFFF & this.exception_table[(k + 3)];
        if (m == 0)
          paramClassTypeWriter.print("0 /* finally */");
        while (true)
        {
          paramClassTypeWriter.println();
          k += 4;
          break;
          paramClassTypeWriter.printOptionalIndex(m);
          paramClassTypeWriter.printConstantTersely(m, 7);
        }
      }
    }
    paramClassTypeWriter.printAttributes(this);
  }

  public void processFixups()
  {
    if (this.fixup_count <= 0)
      return;
    int i = 0;
    int j = this.fixup_count;
    fixupAdd(9, 0, null);
    int k = 0;
    int m = this.fixup_offsets[k];
    int n = m & 0xF;
    int i1 = m >> 4;
    Label localLabel1 = this.fixup_labels[k];
    switch (n)
    {
    case 7:
    case 12:
    case 13:
    default:
      throw new Error("unexpected fixup");
    case 11:
      k += 2;
    case 0:
    case 3:
    case 8:
    case 14:
    case 1:
    case 2:
    case 4:
    case 5:
    case 6:
      while (true)
      {
        k++;
        break;
        k++;
        continue;
        localLabel1.position = (i + localLabel1.position);
        continue;
        i += 3;
        continue;
        if ((localLabel1.first_fixup == k + 1) && (fixupOffset(k + 1) == i1 + 3))
        {
          this.fixup_offsets[k] = (0x8 | i1 << 4);
          this.fixup_labels[k] = null;
          i -= 3;
        }
        else if (this.PC >= 32768)
        {
          i += 2;
          continue;
          if (this.PC >= 32768)
            i += 5;
        }
      }
    case 10:
      this.fixup_labels[j] = this.fixup_labels[(k + 1)];
      j = i1;
    case 9:
    }
    int i2;
    label295: int i4;
    int i5;
    int i6;
    if (k + 1 >= this.fixup_count)
    {
      i2 = this.PC;
      this.fixup_offsets[k] = (0x9 | i2 << 4);
      if (localLabel1 != null)
        break label425;
      i4 = this.PC;
      i5 = 0;
      i6 = 0;
    }
    label425: label753: label763: byte[] arrayOfByte1;
    label796: int i8;
    int i9;
    int i10;
    Label localLabel2;
    int i11;
    int i12;
    while (true)
    {
      int i7 = this.fixup_count;
      Label localLabel5;
      int i53;
      if (i6 < i7)
      {
        int i51 = this.fixup_offsets[i6];
        int i52 = i51 & 0xF;
        localLabel5 = this.fixup_labels[i6];
        if ((localLabel5 != null) && (localLabel5.position < 0))
        {
          throw new Error("undefined label " + localLabel5);
          i2 = fixupOffset(this.fixup_labels[(k + 1)].first_fixup);
          break label295;
          k = localLabel1.first_fixup;
          int i3 = fixupOffset(k);
          i = i2 + i - i3;
          break;
        }
        while ((localLabel5 != null) && (i52 >= 4) && (i52 <= 7) && (1 + localLabel5.first_fixup < this.fixup_count) && (this.fixup_offsets[(1 + localLabel5.first_fixup)] == (0x4 | 0xF & this.fixup_offsets[localLabel5.first_fixup])))
        {
          localLabel5 = this.fixup_labels[(1 + localLabel5.first_fixup)];
          this.fixup_labels[i6] = localLabel5;
        }
        i53 = i51 >> 4;
        switch (i52)
        {
        case 7:
        case 10:
        case 12:
        case 13:
        default:
          throw new Error("unexpected fixup");
        case 11:
          i6 += 2;
          this.fixup_labels[i6].position = (i53 + i5);
        case 0:
        case 3:
        case 14:
        case 8:
        case 1:
        case 2:
        case 4:
        case 5:
        case 6:
          while (true)
          {
            i6++;
            break;
            i6++;
            continue;
            i5 -= 3;
            i4 -= 3;
            continue;
            int i59 = i53 + i5;
            localLabel5.position = i59;
            continue;
            int i58 = 0x3 & 3 - (i53 + i5);
            i5 += i58;
            i4 += i58;
            continue;
            int i55 = localLabel5.position - (i53 + i5);
            if ((short)i55 != i55)
              break label753;
            this.fixup_offsets[i6] = (0x7 | i53 << 4);
          }
          int i56;
          if (i52 == 6)
          {
            i56 = 5;
            i5 += i56;
            if (i52 != 6)
              break label796;
          }
          for (int i57 = 5; ; i57 = 2)
          {
            i4 += i57;
            break;
            i56 = 2;
            break label763;
          }
        case 9:
        }
        if (localLabel5 != null)
          break label881;
      }
      arrayOfByte1 = new byte[i4];
      i8 = -1;
      i9 = 0;
      i10 = fixupOffset(0);
      localLabel2 = null;
      i11 = 0;
      int i49;
      for (i12 = 0; i11 < i10; i12 = i49)
      {
        i49 = i12 + 1;
        byte[] arrayOfByte4 = this.code;
        int i50 = i11 + 1;
        arrayOfByte1[i12] = arrayOfByte4[i11];
        i11 = i50;
      }
      label881: i6 = localLabel5.first_fixup;
      int i54 = fixupOffset(i6);
      i5 = i53 + i5 - i54;
    }
    int i13 = 0xF & this.fixup_offsets[i9];
    Label localLabel3 = this.fixup_labels[i9];
    if ((localLabel2 != null) && (localLabel2.position < i12))
    {
      this.stackMap.emitStackMapEntry(localLabel2, this);
      localLabel2 = null;
    }
    if ((localLabel2 != null) && (localLabel2.position > i12))
      throw new Error("labels out of order");
    int i16;
    int i17;
    switch (i13)
    {
    case 3:
    case 10:
    case 12:
    case 13:
    default:
      throw new Error("unexpected fixup");
    case 0:
      i16 = i11;
      i17 = i12;
    case 1:
    case 8:
    case 7:
    case 4:
    case 5:
    case 6:
    case 2:
    case 11:
    case 14:
    case 9:
    }
    while (true)
    {
      label1079: i9++;
      i10 = fixupOffset(i9);
      i11 = i16;
      i12 = i17;
      break;
      if ((this.stackMap != null) && (localLabel3 != null) && (localLabel3.stackTypes != null) && (localLabel3.needsStackMapEntry))
      {
        localLabel2 = mergeLabels(localLabel2, localLabel3);
        i16 = i11;
        i17 = i12;
        continue;
        i16 = i11 + 3;
        i17 = i12;
        continue;
        int i46 = localLabel3.position - i12;
        int i47 = i12 + 1;
        arrayOfByte1[i12] = this.code[i11];
        int i48 = i47 + 1;
        arrayOfByte1[i47] = ((byte)(i46 >> 8));
        i17 = i48 + 1;
        arrayOfByte1[i48] = ((byte)(i46 & 0xFF));
        i16 = i11 + 3;
        continue;
        int i35 = localLabel3.position - i12;
        byte b = this.code[i11];
        int i37;
        int i36;
        if (i13 == 6)
        {
          int i43 = invert_opcode(b);
          int i44 = i12 + 1;
          arrayOfByte1[i12] = i43;
          int i45 = i44 + 1;
          arrayOfByte1[i44] = 0;
          i37 = i45 + 1;
          arrayOfByte1[i45] = 8;
          i36 = -56;
        }
        while (true)
        {
          int i38 = i37 + 1;
          arrayOfByte1[i37] = i36;
          int i39 = i38 + 1;
          arrayOfByte1[i38] = ((byte)(i35 >> 24));
          int i40 = i39 + 1;
          arrayOfByte1[i39] = ((byte)(i35 >> 16));
          int i41 = i40 + 1;
          arrayOfByte1[i40] = ((byte)(i35 >> 8));
          int i42 = i41 + 1;
          arrayOfByte1[i41] = ((byte)(i35 & 0xFF));
          i16 = i11 + 3;
          i17 = i42;
          break;
          i36 = (byte)(b + 33);
          i37 = i12;
        }
        int i19 = 0x3 & 3 - i12;
        int i20 = i12;
        int i21 = i12 + 1;
        byte[] arrayOfByte2 = this.code;
        i16 = i11 + 1;
        arrayOfByte1[i12] = arrayOfByte2[i11];
        int i34;
        for (int i22 = i21; ; i22 = i34)
        {
          i19--;
          if (i19 < 0)
            break;
          i34 = i22 + 1;
          arrayOfByte1[i22] = 0;
        }
        label1492: int i29 = this.fixup_labels[i9].position - i20;
        int i26;
        int i30 = i26 + 1;
        arrayOfByte1[i26] = ((byte)(i29 >> 24));
        int i31 = i30 + 1;
        arrayOfByte1[i30] = ((byte)(i29 >> 16));
        int i32 = i31 + 1;
        arrayOfByte1[i31] = ((byte)(i29 >> 8));
        int i33 = i32 + 1;
        arrayOfByte1[i32] = ((byte)(i29 & 0xFF));
        int i25;
        i16 = i25 + 4;
        for (i17 = i33; ; i17 = i22)
        {
          int i23 = this.fixup_count;
          if ((i9 >= i23) || (fixupKind(i9 + 1) != 3))
            break label1079;
          i9++;
          int i24 = fixupOffset(i9);
          i25 = i16;
          int i27;
          for (i26 = i17; i25 < i24; i26 = i27)
          {
            i27 = i26 + 1;
            byte[] arrayOfByte3 = this.code;
            int i28 = i25 + 1;
            arrayOfByte1[i26] = arrayOfByte3[i25];
            i25 = i28;
          }
          break label1492;
          Label localLabel4 = this.fixup_labels[(i9 + 2)];
          int i18 = fixupOffset(i9 + 1);
          if (this.stackMap != null)
            localLabel2 = mergeLabels(localLabel2, localLabel4);
          addHandler(this.fixup_labels[i9].position, this.fixup_labels[(i9 + 1)].position, i12, i18);
          i9 += 2;
          i16 = i11;
          i17 = i12;
          break label1079;
          if (this.lines == null)
          {
            LineNumbersAttr localLineNumbersAttr = new LineNumbersAttr(this);
            this.lines = localLineNumbersAttr;
          }
          i9++;
          int i15 = fixupOffset(i9);
          if (i15 != i8)
            this.lines.put(i15, i12);
          i8 = i15;
          i16 = i11;
          i17 = i12;
          break label1079;
          int i14;
          if (localLabel3 == null)
          {
            if (i4 != i12)
              throw new Error("PC confusion new_pc:" + i12 + " new_size:" + i4);
          }
          else
          {
            i9 = localLabel3.first_fixup;
            i14 = fixupOffset(i9);
            i10 = i14;
            if (localLabel3.position == i12)
              break label1945;
            throw new Error("bad pc");
          }
          this.PC = i4;
          this.code = arrayOfByte1;
          this.fixup_count = 0;
          this.fixup_labels = null;
          this.fixup_offsets = null;
          return;
          label1945: i11 = i14;
          break;
        }
      }
      else
      {
        i16 = i11;
        i17 = i12;
      }
    }
  }

  public Scope pushScope()
  {
    Scope localScope = new Scope();
    if (this.locals == null)
      this.locals = new LocalVarsAttr(getMethod());
    enterScope(localScope);
    if (this.locals.parameter_scope == null)
      this.locals.parameter_scope = localScope;
    return localScope;
  }

  public final void pushType(Type paramType)
  {
    if (paramType.size == 0)
      throw new Error("pushing void type onto stack");
    if ((this.stack_types == null) || (this.stack_types.length == 0))
      this.stack_types = new Type[20];
    while (true)
    {
      if (paramType.size == 8)
      {
        Type[] arrayOfType2 = this.stack_types;
        int j = this.SP;
        this.SP = (j + 1);
        arrayOfType2[j] = Type.voidType;
      }
      Type[] arrayOfType1 = this.stack_types;
      int i = this.SP;
      this.SP = (i + 1);
      arrayOfType1[i] = paramType;
      if (this.SP > this.max_stack)
        this.max_stack = this.SP;
      return;
      if (1 + this.SP >= this.stack_types.length)
      {
        Type[] arrayOfType3 = new Type[2 * this.stack_types.length];
        System.arraycopy(this.stack_types, 0, arrayOfType3, 0, this.SP);
        this.stack_types = arrayOfType3;
      }
    }
  }

  public final void put1(int paramInt)
  {
    byte[] arrayOfByte = this.code;
    int i = this.PC;
    this.PC = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.unreachable_here = false;
  }

  public final void put2(int paramInt)
  {
    byte[] arrayOfByte1 = this.code;
    int i = this.PC;
    this.PC = (i + 1);
    arrayOfByte1[i] = ((byte)(paramInt >> 8));
    byte[] arrayOfByte2 = this.code;
    int j = this.PC;
    this.PC = (j + 1);
    arrayOfByte2[j] = ((byte)paramInt);
    this.unreachable_here = false;
  }

  public final void put4(int paramInt)
  {
    byte[] arrayOfByte1 = this.code;
    int i = this.PC;
    this.PC = (i + 1);
    arrayOfByte1[i] = ((byte)(paramInt >> 24));
    byte[] arrayOfByte2 = this.code;
    int j = this.PC;
    this.PC = (j + 1);
    arrayOfByte2[j] = ((byte)(paramInt >> 16));
    byte[] arrayOfByte3 = this.code;
    int k = this.PC;
    this.PC = (k + 1);
    arrayOfByte3[k] = ((byte)(paramInt >> 8));
    byte[] arrayOfByte4 = this.code;
    int m = this.PC;
    this.PC = (m + 1);
    arrayOfByte4[m] = ((byte)paramInt);
    this.unreachable_here = false;
  }

  public final void putIndex2(CpoolEntry paramCpoolEntry)
  {
    put2(paramCpoolEntry.index);
  }

  public final void putLineNumber(int paramInt)
  {
    if (this.sourceDbgExt != null)
      paramInt = this.sourceDbgExt.fixLine(paramInt);
    fixupAdd(14, null);
    fixupAdd(15, paramInt, null);
  }

  public final void putLineNumber(String paramString, int paramInt)
  {
    if (paramString != null)
      getMethod().classfile.setSourceFile(paramString);
    putLineNumber(paramInt);
  }

  public final boolean reachableHere()
  {
    return !this.unreachable_here;
  }

  public final void reserve(int paramInt)
  {
    if (this.code == null)
      this.code = new byte[paramInt + 100];
    while (paramInt + this.PC <= this.code.length)
      return;
    byte[] arrayOfByte = new byte[paramInt + 2 * this.code.length];
    System.arraycopy(this.code, 0, arrayOfByte, 0, this.PC);
    this.code = arrayOfByte;
  }

  public final void setAttributes(Attribute paramAttribute)
  {
    this.attributes = paramAttribute;
  }

  public void setCode(byte[] paramArrayOfByte)
  {
    this.code = paramArrayOfByte;
    this.PC = paramArrayOfByte.length;
  }

  public void setCodeLength(int paramInt)
  {
    this.PC = paramInt;
  }

  public void setMaxLocals(int paramInt)
  {
    this.max_locals = paramInt;
  }

  public void setMaxStack(int paramInt)
  {
    this.max_stack = paramInt;
  }

  public final void setReachable(boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      this.unreachable_here = bool;
      return;
    }
  }

  public final void setTypes(Label paramLabel)
  {
    setTypes(paramLabel.localTypes, paramLabel.stackTypes);
  }

  public final void setTypes(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
  {
    int i = paramArrayOfType2.length;
    int j = paramArrayOfType1.length;
    if (this.local_types != null)
    {
      if (j > 0)
        System.arraycopy(paramArrayOfType1, 0, this.local_types, 0, j);
      for (int m = j; m < this.local_types.length; m++)
        this.local_types[m] = null;
    }
    if ((this.stack_types == null) || (i > this.stack_types.length))
      this.stack_types = new Type[i];
    while (true)
    {
      System.arraycopy(paramArrayOfType2, 0, this.stack_types, 0, i);
      this.SP = i;
      return;
      for (int k = i; k < this.stack_types.length; k++)
        this.stack_types[k] = null;
    }
  }

  public final void setUnreachable()
  {
    this.unreachable_here = true;
  }

  public ExitableBlock startExitableBlock(Type paramType, boolean paramBoolean)
  {
    ExitableBlock localExitableBlock = new ExitableBlock(paramType, this, paramBoolean);
    localExitableBlock.outer = this.currentExitableBlock;
    this.currentExitableBlock = localExitableBlock;
    return localExitableBlock;
  }

  public SwitchState startSwitch()
  {
    SwitchState localSwitchState = new SwitchState(this);
    localSwitchState.switchValuePushed(this);
    return localSwitchState;
  }

  public final Type topType()
  {
    return this.stack_types[(this.SP - 1)];
  }

  boolean useJsr()
  {
    return (0x2 & this.flags) == 0;
  }

  public void write(DataOutputStream paramDataOutputStream)
    throws IOException
  {
    paramDataOutputStream.writeShort(this.max_stack);
    paramDataOutputStream.writeShort(this.max_locals);
    paramDataOutputStream.writeInt(this.PC);
    paramDataOutputStream.write(this.code, 0, this.PC);
    paramDataOutputStream.writeShort(this.exception_table_length);
    int i = this.exception_table_length;
    for (int j = 0; ; j += 4)
    {
      i--;
      if (i < 0)
        break;
      paramDataOutputStream.writeShort(this.exception_table[j]);
      paramDataOutputStream.writeShort(this.exception_table[(j + 1)]);
      paramDataOutputStream.writeShort(this.exception_table[(j + 2)]);
      paramDataOutputStream.writeShort(this.exception_table[(j + 3)]);
    }
    Attribute.writeAll(this, paramDataOutputStream);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.CodeAttr
 * JD-Core Version:    0.6.2
 */