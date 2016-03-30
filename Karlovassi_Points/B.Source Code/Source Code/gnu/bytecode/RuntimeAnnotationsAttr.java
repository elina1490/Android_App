package gnu.bytecode;

public class RuntimeAnnotationsAttr extends MiscAttr
{
  int numEntries;

  public RuntimeAnnotationsAttr(String paramString, byte[] paramArrayOfByte, AttrContainer paramAttrContainer)
  {
    super(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
    addToFrontOf(paramAttrContainer);
    this.numEntries = u2(0);
  }

  public void print(ClassTypeWriter paramClassTypeWriter)
  {
    paramClassTypeWriter.print("Attribute \"");
    paramClassTypeWriter.print(getName());
    paramClassTypeWriter.print("\", length:");
    paramClassTypeWriter.print(getLength());
    paramClassTypeWriter.print(", number of entries: ");
    paramClassTypeWriter.println(this.numEntries);
    int i = this.offset;
    this.offset = (i + 2);
    for (int j = 0; j < this.numEntries; j++)
      printAnnotation(2, paramClassTypeWriter);
    this.offset = i;
  }

  public void printAnnotation(int paramInt, ClassTypeWriter paramClassTypeWriter)
  {
    int i = u2();
    paramClassTypeWriter.printSpaces(paramInt);
    paramClassTypeWriter.printOptionalIndex(i);
    paramClassTypeWriter.print('@');
    paramClassTypeWriter.printContantUtf8AsClass(i);
    int j = u2();
    paramClassTypeWriter.println();
    int k = paramInt + 2;
    for (int m = 0; m < j; m++)
    {
      int n = u2();
      paramClassTypeWriter.printSpaces(k);
      paramClassTypeWriter.printOptionalIndex(n);
      paramClassTypeWriter.printConstantTersely(n, 1);
      paramClassTypeWriter.print(" => ");
      printAnnotationElementValue(k, paramClassTypeWriter);
      paramClassTypeWriter.println();
    }
  }

  public void printAnnotationElementValue(int paramInt, ClassTypeWriter paramClassTypeWriter)
  {
    int i = u1();
    int j;
    if ((0x8 & paramClassTypeWriter.flags) != 0)
    {
      paramClassTypeWriter.print("[kind:");
      if ((i >= 65) && (i <= 122))
      {
        paramClassTypeWriter.print((char)i);
        paramClassTypeWriter.print("] ");
      }
    }
    else
    {
      j = 0;
      switch (i)
      {
      default:
      case 66:
      case 67:
      case 73:
      case 83:
      case 90:
      case 74:
      case 68:
      case 70:
      case 115:
      case 101:
      case 99:
      case 64:
      case 91:
      }
    }
    while (true)
    {
      return;
      paramClassTypeWriter.print(i);
      break;
      j = 0;
      if (0 == 0)
        j = 3;
      if (j == 0)
        j = 5;
      if (j == 0)
        j = 6;
      if (j == 0)
        j = 4;
      if (j == 0)
        j = 1;
      int i3 = u2();
      CpoolEntry localCpoolEntry = paramClassTypeWriter.getCpoolEntry(i3);
      paramClassTypeWriter.printOptionalIndex(localCpoolEntry);
      if ((i == 90) && (localCpoolEntry != null) && (localCpoolEntry.getTag() == 3))
      {
        CpoolValue1 localCpoolValue1 = (CpoolValue1)localCpoolEntry;
        if ((localCpoolValue1.value == 0) || (localCpoolValue1.value == 1))
        {
          if (localCpoolValue1.value == 0);
          for (String str = "false"; ; str = "true")
          {
            paramClassTypeWriter.print(str);
            return;
          }
        }
      }
      paramClassTypeWriter.printConstantTersely(i3, j);
      return;
      int i1 = u2();
      int i2 = u2();
      paramClassTypeWriter.print("enum[");
      if ((0x8 & paramClassTypeWriter.flags) != 0)
        paramClassTypeWriter.print("type:");
      paramClassTypeWriter.printOptionalIndex(i1);
      paramClassTypeWriter.printContantUtf8AsClass(i1);
      if ((0x8 & paramClassTypeWriter.flags) != 0)
        paramClassTypeWriter.print(" value:");
      while (true)
      {
        paramClassTypeWriter.printOptionalIndex(i2);
        paramClassTypeWriter.printConstantTersely(i2, 1);
        paramClassTypeWriter.print("]");
        return;
        paramClassTypeWriter.print(' ');
      }
      int n = u2();
      paramClassTypeWriter.printOptionalIndex(n);
      paramClassTypeWriter.printContantUtf8AsClass(n);
      return;
      paramClassTypeWriter.println();
      paramClassTypeWriter.printSpaces(paramInt + 2);
      printAnnotation(paramInt + 2, paramClassTypeWriter);
      return;
      int k = u2();
      paramClassTypeWriter.print("array length:");
      paramClassTypeWriter.print(k);
      for (int m = 0; m < k; m++)
      {
        paramClassTypeWriter.println();
        paramClassTypeWriter.printSpaces(paramInt + 2);
        paramClassTypeWriter.print(m);
        paramClassTypeWriter.print(": ");
        printAnnotationElementValue(paramInt + 2, paramClassTypeWriter);
      }
    }
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.RuntimeAnnotationsAttr
 * JD-Core Version:    0.6.2
 */