package gnu.bytecode;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class ClassTypeWriter extends PrintWriter
{
  public static final int PRINT_CONSTANT_POOL = 1;
  public static final int PRINT_CONSTANT_POOL_INDEXES = 2;
  public static final int PRINT_EXTRAS = 8;
  public static final int PRINT_VERBOSE = 15;
  public static final int PRINT_VERSION = 4;
  ClassType ctype;
  int flags;

  public ClassTypeWriter(ClassType paramClassType, OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    this.ctype = paramClassType;
    this.flags = paramInt;
  }

  public ClassTypeWriter(ClassType paramClassType, Writer paramWriter, int paramInt)
  {
    super(paramWriter);
    this.ctype = paramClassType;
    this.flags = paramInt;
  }

  public static void print(ClassType paramClassType, PrintStream paramPrintStream, int paramInt)
  {
    ClassTypeWriter localClassTypeWriter = new ClassTypeWriter(paramClassType, paramPrintStream, paramInt);
    localClassTypeWriter.print();
    localClassTypeWriter.flush();
  }

  public static void print(ClassType paramClassType, PrintWriter paramPrintWriter, int paramInt)
  {
    ClassTypeWriter localClassTypeWriter = new ClassTypeWriter(paramClassType, paramPrintWriter, paramInt);
    localClassTypeWriter.print();
    localClassTypeWriter.flush();
  }

  CpoolEntry getCpoolEntry(int paramInt)
  {
    CpoolEntry[] arrayOfCpoolEntry = this.ctype.constants.pool;
    if ((arrayOfCpoolEntry == null) || (paramInt < 0) || (paramInt >= arrayOfCpoolEntry.length))
      return null;
    return arrayOfCpoolEntry[paramInt];
  }

  public void print()
  {
    if ((0x4 & this.flags) != 0)
    {
      print("Classfile format major version: ");
      print(this.ctype.getClassfileMajorVersion());
      print(", minor version: ");
      print(this.ctype.getClassfileMinorVersion());
      println('.');
    }
    if ((0x1 & this.flags) != 0)
      printConstantPool();
    printClassInfo();
    printFields();
    printMethods();
    printAttributes();
  }

  public void print(ClassType paramClassType)
  {
    this.ctype = paramClassType;
    print();
  }

  public void printAttributes()
  {
    ClassType localClassType = this.ctype;
    println();
    print("Attributes (count: ");
    print(Attribute.count(localClassType));
    println("):");
    printAttributes(localClassType);
  }

  public void printAttributes(AttrContainer paramAttrContainer)
  {
    for (Attribute localAttribute = paramAttrContainer.getAttributes(); localAttribute != null; localAttribute = localAttribute.next)
      localAttribute.print(this);
  }

  public void printClassInfo()
  {
    println();
    print("Access flags:");
    print(Access.toString(this.ctype.getModifiers(), 'C'));
    println();
    print("This class: ");
    printOptionalIndex(this.ctype.thisClassIndex);
    printConstantTersely(this.ctype.thisClassIndex, 7);
    print(" super: ");
    int[] arrayOfInt;
    if (this.ctype.superClassIndex == -1)
    {
      print("<unknown>");
      println();
      print("Interfaces (count: ");
      arrayOfInt = this.ctype.interfaceIndexes;
      if (arrayOfInt != null)
        break label210;
    }
    label210: for (int i = 0; ; i = arrayOfInt.length)
    {
      print(i);
      print("):");
      println();
      for (int j = 0; j < i; j++)
      {
        print("- Implements: ");
        int k = arrayOfInt[j];
        printOptionalIndex(k);
        printConstantTersely(k, 7);
        println();
      }
      if (this.ctype.superClassIndex == 0)
      {
        print("0");
        break;
      }
      printOptionalIndex(this.ctype.superClassIndex);
      printConstantTersely(this.ctype.superClassIndex, 7);
      break;
    }
  }

  final void printConstantOperand(int paramInt)
  {
    print(' ');
    printOptionalIndex(paramInt);
    CpoolEntry[] arrayOfCpoolEntry = this.ctype.constants.pool;
    CpoolEntry localCpoolEntry;
    if ((arrayOfCpoolEntry != null) && (paramInt >= 0) && (paramInt < arrayOfCpoolEntry.length))
    {
      localCpoolEntry = arrayOfCpoolEntry[paramInt];
      if (localCpoolEntry != null);
    }
    else
    {
      print("<invalid constant index>");
      return;
    }
    print('<');
    localCpoolEntry.print(this, 1);
    print('>');
  }

  public void printConstantPool()
  {
    CpoolEntry[] arrayOfCpoolEntry = this.ctype.constants.pool;
    int i = this.ctype.constants.count;
    int j = 1;
    if (j <= i)
    {
      CpoolEntry localCpoolEntry = arrayOfCpoolEntry[j];
      if (localCpoolEntry == null);
      while (true)
      {
        j++;
        break;
        print('#');
        print(localCpoolEntry.index);
        print(": ");
        localCpoolEntry.print(this, 2);
        println();
      }
    }
  }

  final void printConstantTersely(int paramInt1, int paramInt2)
  {
    printConstantTersely(getCpoolEntry(paramInt1), paramInt2);
  }

  final void printConstantTersely(CpoolEntry paramCpoolEntry, int paramInt)
  {
    if (paramCpoolEntry == null)
    {
      print("<invalid constant index>");
      return;
    }
    if (paramCpoolEntry.getTag() != paramInt)
    {
      print("<unexpected constant type ");
      paramCpoolEntry.print(this, 1);
      print('>');
      return;
    }
    paramCpoolEntry.print(this, 0);
  }

  final void printContantUtf8AsClass(int paramInt)
  {
    CpoolEntry localCpoolEntry = getCpoolEntry(paramInt);
    if ((localCpoolEntry != null) && (localCpoolEntry.getTag() == 1))
    {
      String str = ((CpoolUtf8)localCpoolEntry).string;
      Type.printSignature(str, 0, str.length(), this);
      return;
    }
    printConstantTersely(paramInt, 1);
  }

  public void printFields()
  {
    println();
    print("Fields (count: ");
    print(this.ctype.fields_count);
    print("):");
    println();
    int i = 0;
    for (Field localField = this.ctype.fields; localField != null; localField = localField.next)
    {
      print("Field name: ");
      if (localField.name_index != 0)
        printOptionalIndex(localField.name_index);
      print(localField.getName());
      print(Access.toString(localField.flags, 'F'));
      print(" Signature: ");
      if (localField.signature_index != 0)
        printOptionalIndex(localField.signature_index);
      printSignature(localField.type);
      println();
      printAttributes(localField);
      i++;
    }
  }

  public void printMethod(Method paramMethod)
  {
    println();
    print("Method name:");
    if (paramMethod.name_index != 0)
      printOptionalIndex(paramMethod.name_index);
    print('"');
    print(paramMethod.getName());
    print('"');
    print(Access.toString(paramMethod.access_flags, 'M'));
    print(" Signature: ");
    if (paramMethod.signature_index != 0)
      printOptionalIndex(paramMethod.signature_index);
    print('(');
    for (int i = 0; i < paramMethod.arg_types.length; i++)
    {
      if (i > 0)
        print(',');
      printSignature(paramMethod.arg_types[i]);
    }
    print(')');
    printSignature(paramMethod.return_type);
    println();
    printAttributes(paramMethod);
  }

  public void printMethods()
  {
    println();
    print("Methods (count: ");
    print(this.ctype.methods_count);
    print("):");
    println();
    for (Method localMethod = this.ctype.methods; localMethod != null; localMethod = localMethod.next)
      printMethod(localMethod);
  }

  void printName(String paramString)
  {
    print(paramString);
  }

  public final void printOptionalIndex(int paramInt)
  {
    if ((0x2 & this.flags) != 0)
    {
      print('#');
      print(paramInt);
      print('=');
    }
  }

  public final void printOptionalIndex(CpoolEntry paramCpoolEntry)
  {
    printOptionalIndex(paramCpoolEntry.index);
  }

  public final void printQuotedString(String paramString)
  {
    print('"');
    int i = paramString.length();
    int j = 0;
    if (j < i)
    {
      int k = paramString.charAt(j);
      if (k == 34)
        print("\\\"");
      while (true)
      {
        j++;
        break;
        if ((k >= 32) && (k < 127))
        {
          print(k);
        }
        else if (k == 10)
        {
          print("\\n");
        }
        else
        {
          print("\\u");
          int m = 4;
          while (true)
          {
            m--;
            if (m < 0)
              break;
            print(Character.forDigit(0xF & k >> m * 4, 16));
          }
        }
      }
    }
    print('"');
  }

  public final int printSignature(String paramString, int paramInt)
  {
    int i = paramString.length();
    if (paramInt >= i)
    {
      print("<empty signature>");
      return paramInt;
    }
    int j = Type.signatureLength(paramString, paramInt);
    if (j > 0)
    {
      String str = Type.signatureToName(paramString.substring(paramInt, paramInt + j));
      if (str != null)
      {
        print(str);
        return paramInt + j;
      }
    }
    char c1 = paramString.charAt(paramInt);
    if (c1 != '(')
    {
      print(c1);
      return paramInt + 1;
    }
    int k = paramInt + 1;
    print(c1);
    int n;
    for (int m = 0; ; m = n)
    {
      if (k >= i)
      {
        print("<truncated method signature>");
        return k;
      }
      char c2 = paramString.charAt(k);
      if (c2 == ')')
      {
        int i1 = k + 1;
        print(c2);
        return printSignature(paramString, i1);
      }
      n = m + 1;
      if (m > 0)
        print(',');
      k = printSignature(paramString, k);
    }
  }

  public final void printSignature(Type paramType)
  {
    if (paramType == null)
    {
      print("<unknown type>");
      return;
    }
    printSignature(paramType.getSignature());
  }

  public final void printSignature(String paramString)
  {
    int i = printSignature(paramString, 0);
    if (i < paramString.length())
    {
      print("<trailing junk:");
      print(paramString.substring(i));
      print('>');
    }
  }

  public void printSpaces(int paramInt)
  {
    while (true)
    {
      paramInt--;
      if (paramInt < 0)
        break;
      print(' ');
    }
  }

  public void setClass(ClassType paramClassType)
  {
    this.ctype = paramClassType;
  }

  public void setFlags(int paramInt)
  {
    this.flags = paramInt;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.ClassTypeWriter
 * JD-Core Version:    0.6.2
 */