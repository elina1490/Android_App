package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.Consumer;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import java.util.Vector;

public class SyntaxPattern extends Pattern
  implements Externalizable
{
  static final int MATCH_ANY = 3;
  static final int MATCH_ANY_CAR = 7;
  static final int MATCH_EQUALS = 2;
  static final int MATCH_IGNORE = 24;
  static final int MATCH_LENGTH = 6;
  static final int MATCH_LREPEAT = 5;
  static final int MATCH_MISC = 0;
  static final int MATCH_NIL = 8;
  static final int MATCH_PAIR = 4;
  static final int MATCH_VECTOR = 16;
  static final int MATCH_WIDE = 1;
  Object[] literals;
  String program;
  int varCount;

  public SyntaxPattern(Object paramObject, Object[] paramArrayOfObject, Translator paramTranslator)
  {
    this(new StringBuffer(), paramObject, null, paramArrayOfObject, paramTranslator);
  }

  public SyntaxPattern(String paramString, Object[] paramArrayOfObject, int paramInt)
  {
    this.program = paramString;
    this.literals = paramArrayOfObject;
    this.varCount = paramInt;
  }

  SyntaxPattern(StringBuffer paramStringBuffer, Object paramObject, SyntaxForm paramSyntaxForm, Object[] paramArrayOfObject, Translator paramTranslator)
  {
    Vector localVector = new Vector();
    translate(paramObject, paramStringBuffer, paramArrayOfObject, 0, localVector, null, '\000', paramTranslator);
    this.program = paramStringBuffer.toString();
    this.literals = new Object[localVector.size()];
    localVector.copyInto(this.literals);
    this.varCount = paramTranslator.patternScope.pattern_names.size();
  }

  private static void addInt(StringBuffer paramStringBuffer, int paramInt)
  {
    if (paramInt > 65535)
      addInt(paramStringBuffer, 1 + (paramInt << 13));
    paramStringBuffer.append((char)paramInt);
  }

  public static Object[] allocVars(int paramInt, Object[] paramArrayOfObject)
  {
    Object[] arrayOfObject = new Object[paramInt];
    if (paramArrayOfObject != null)
      System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramArrayOfObject.length);
    return arrayOfObject;
  }

  public static Object[] getLiteralsList(Object paramObject, SyntaxForm paramSyntaxForm, Translator paramTranslator)
  {
    Object localObject1 = paramTranslator.pushPositionOf(paramObject);
    int i = Translator.listLength(paramObject);
    if (i < 0)
    {
      paramTranslator.error('e', "missing or malformed literals list");
      i = 0;
    }
    Object[] arrayOfObject = new Object[i + 1];
    int j = 1;
    if (j <= i)
    {
      while ((paramObject instanceof SyntaxForm))
        paramObject = ((SyntaxForm)paramObject).getDatum();
      Pair localPair = (Pair)paramObject;
      paramTranslator.pushPositionOf(localPair);
      Object localObject2 = localPair.getCar();
      Object localObject3;
      if ((localObject2 instanceof SyntaxForm))
      {
        localObject3 = localObject2;
        localObject2 = ((SyntaxForm)localObject2).getDatum();
      }
      while (true)
      {
        if (!(localObject2 instanceof Symbol))
          paramTranslator.error('e', "non-symbol '" + localObject2 + "' in literals list");
        arrayOfObject[j] = localObject3;
        paramObject = localPair.getCdr();
        j++;
        break;
        localObject3 = localObject2;
      }
    }
    paramTranslator.popPositionOf(localObject1);
    return arrayOfObject;
  }

  private static int insertInt(int paramInt1, StringBuffer paramStringBuffer, int paramInt2)
  {
    if (paramInt2 > 65535)
      paramInt1 += insertInt(paramInt1, paramStringBuffer, 1 + (paramInt2 << 13));
    paramStringBuffer.insert(paramInt1, (char)paramInt2);
    return paramInt1 + 1;
  }

  public static boolean literalIdentifierEq(Object paramObject1, ScopeExp paramScopeExp1, Object paramObject2, ScopeExp paramScopeExp2)
  {
    if ((paramObject1 != paramObject2) && ((paramObject1 == null) || (paramObject2 == null) || (!paramObject1.equals(paramObject2))))
      return false;
    if (paramScopeExp1 == paramScopeExp2)
      return true;
    Declaration localDeclaration1 = null;
    Declaration localDeclaration2 = null;
    if (paramScopeExp1 != null)
    {
      boolean bool = paramScopeExp1 instanceof ModuleExp;
      localDeclaration2 = null;
      if (!bool)
      {
        localDeclaration1 = paramScopeExp1.lookup(paramObject1);
        localDeclaration2 = null;
        if (localDeclaration1 == null)
          break label101;
      }
    }
    while (true)
    {
      if ((paramScopeExp2 != null) && (!(paramScopeExp2 instanceof ModuleExp)))
      {
        localDeclaration2 = paramScopeExp2.lookup(paramObject2);
        if (localDeclaration2 == null);
      }
      else
      {
        if (localDeclaration1 != localDeclaration2)
          break label117;
        return true;
        label101: paramScopeExp1 = paramScopeExp1.outer;
        break;
      }
      paramScopeExp2 = paramScopeExp2.outer;
    }
    label117: return false;
  }

  public void disassemble()
  {
    disassemble(OutPort.errDefault(), (Translator)Compilation.getCurrent(), 0, this.program.length());
  }

  public void disassemble(PrintWriter paramPrintWriter, Translator paramTranslator)
  {
    disassemble(paramPrintWriter, paramTranslator, 0, this.program.length());
  }

  void disassemble(PrintWriter paramPrintWriter, Translator paramTranslator, int paramInt1, int paramInt2)
  {
    Vector localVector = null;
    if (paramTranslator != null)
    {
      PatternScope localPatternScope = paramTranslator.patternScope;
      localVector = null;
      if (localPatternScope != null)
        localVector = paramTranslator.patternScope.pattern_names;
    }
    int i = 0;
    int j = paramInt1;
    if (j < paramInt2)
    {
      int k = this.program.charAt(j);
      paramPrintWriter.print(" " + j + ": " + k);
      j++;
      int m = k & 0x7;
      i = i << 13 | k >> 3;
      switch (m)
      {
      default:
        label160: paramPrintWriter.println(" - " + m + '/' + i);
      case 1:
      case 2:
      case 3:
      case 7:
      case 4:
      case 5:
      case 6:
      case 0:
      }
      while (true)
      {
        i = 0;
        break;
        paramPrintWriter.println(" - WIDE " + i);
        break;
        paramPrintWriter.print(" - EQUALS[" + i + "]");
        if ((this.literals != null) && (i >= 0) && (i < this.literals.length))
          paramPrintWriter.print(this.literals[i]);
        paramPrintWriter.println();
        continue;
        StringBuilder localStringBuilder4 = new StringBuilder();
        if (m == 3);
        for (String str4 = " - ANY["; ; str4 = " - ANY_CAR[")
        {
          paramPrintWriter.print(str4 + i + "]");
          if ((localVector != null) && (i >= 0) && (i < localVector.size()))
            paramPrintWriter.print(localVector.elementAt(i));
          paramPrintWriter.println();
          break;
        }
        paramPrintWriter.println(" - PAIR[" + i + "]");
        continue;
        paramPrintWriter.println(" - LREPEAT[" + i + "]");
        disassemble(paramPrintWriter, paramTranslator, j, j + i);
        int n = j + i;
        StringBuilder localStringBuilder2 = new StringBuilder().append(" ").append(n).append(": - repeat first var:");
        String str2 = this.program;
        int i1 = n + 1;
        paramPrintWriter.println(str2.charAt(n) >> '\003');
        StringBuilder localStringBuilder3 = new StringBuilder().append(" ").append(i1).append(": - repeast nested vars:");
        String str3 = this.program;
        j = i1 + 1;
        paramPrintWriter.println(str3.charAt(i1) >> '\003');
        continue;
        StringBuilder localStringBuilder1 = new StringBuilder().append(" - LENGTH ").append(i >> 1).append(" pairs. ");
        if ((i & 0x1) == 0);
        for (String str1 = "pure list"; ; str1 = "impure list")
        {
          paramPrintWriter.println(str1);
          break;
        }
        paramPrintWriter.print("[misc ch:" + k + " n:" + 8 + "]");
        if (k == 8)
        {
          paramPrintWriter.println(" - NIL");
        }
        else if (k == 16)
        {
          paramPrintWriter.println(" - VECTOR");
        }
        else
        {
          if (k != 24)
            break label160;
          paramPrintWriter.println(" - IGNORE");
        }
      }
    }
  }

  public boolean match(Object paramObject, Object[] paramArrayOfObject, int paramInt)
  {
    return match(paramObject, paramArrayOfObject, paramInt, 0, null);
  }

  public boolean match(Object paramObject, Object[] paramArrayOfObject, int paramInt1, int paramInt2, SyntaxForm paramSyntaxForm)
  {
    int i = 0;
    label372: int i9;
    label751: label763: 
    do
    {
      int i12;
      do
      {
        int j;
        while (true)
          if ((paramObject instanceof SyntaxForm))
          {
            paramSyntaxForm = (SyntaxForm)paramObject;
            paramObject = paramSyntaxForm.getDatum();
          }
          else
          {
            String str1 = this.program;
            j = paramInt2 + 1;
            int k = str1.charAt(paramInt2);
            int m = k & 0x7;
            i = i << 13 | k >> 3;
            switch (m)
            {
            case 7:
            default:
              disassemble();
              throw new Error("unrecognized pattern opcode @pc:" + j);
            case 1:
              paramInt2 = j;
              break;
            case 0:
              if (k == 8)
              {
                LList localLList3 = LList.Empty;
                if (paramObject == localLList3);
                for (boolean bool2 = true; ; bool2 = false)
                  return bool2;
              }
              if (k == 16)
              {
                if (!(paramObject instanceof FVector))
                  return false;
                return match(LList.makeList((FVector)paramObject), paramArrayOfObject, paramInt1, j, paramSyntaxForm);
              }
              if (k == 24)
                return true;
              throw new Error("unknwon pattern opcode");
            case 8:
              LList localLList2 = LList.Empty;
              if (paramObject == localLList2);
              for (boolean bool1 = true; ; bool1 = false)
                return bool1;
            case 6:
              int i26 = i >> 1;
              Object localObject6 = paramObject;
              int i27 = 0;
              while (true)
                if ((localObject6 instanceof SyntaxForm))
                {
                  localObject6 = ((SyntaxForm)localObject6).getDatum();
                }
                else
                {
                  if (i27 == i26)
                  {
                    if ((i & 0x1) == 0)
                    {
                      localLList1 = LList.Empty;
                      if (localObject6 == localLList1);
                    }
                    else
                    {
                      while ((localObject6 instanceof Pair))
                      {
                        LList localLList1;
                        return false;
                      }
                    }
                    paramInt2 = j;
                    i = 0;
                    break;
                  }
                  if (!(localObject6 instanceof Pair))
                    break label372;
                  localObject6 = ((Pair)localObject6).getCdr();
                  i27++;
                }
              return false;
            case 4:
              if (!(paramObject instanceof Pair))
                return false;
              Pair localPair2 = (Pair)paramObject;
              if (!match_car(localPair2, paramArrayOfObject, paramInt1, j, paramSyntaxForm))
                return false;
              paramInt2 = j + i;
              paramObject = localPair2.getCdr();
              i = 0;
            case 5:
            case 2:
            case 3:
            }
          }
        int n = j + i;
        String str2 = this.program;
        int i1 = n + 1;
        int i2 = str2.charAt(n);
        int i3 = i2 >> 3;
        while ((i2 & 0x7) == 1)
        {
          int i24 = i3 << 13;
          String str7 = this.program;
          int i25 = i1 + 1;
          i2 = str7.charAt(i1);
          i3 = i24 | i2 >> 3;
          i1 = i25;
        }
        int i4 = i3 + paramInt1;
        String str3 = this.program;
        int i5 = i1 + 1;
        int i6 = str3.charAt(i1) >> '\003';
        int i23;
        for (int i7 = i5; (i2 & 0x7) == 1; i7 = i23)
        {
          int i22 = i6 << 13;
          String str6 = this.program;
          i23 = i7 + 1;
          i2 = str6.charAt(i7);
          i6 = i22 | i2 >> 3;
        }
        String str4 = this.program;
        paramInt2 = i7 + 1;
        int i8 = str4.charAt(i7);
        i9 = 1;
        int i13;
        if (i8 == 8)
        {
          i12 = 0;
          i13 = Translator.listLength(paramObject);
          if (i13 < 0)
            break label751;
        }
        for (int i14 = 1; ; i14 = 0)
        {
          if ((i13 >= i12) && ((i9 == 0) || (i14 != 0)))
            break label763;
          return false;
          int i10 = i8 >> 3;
          int i21;
          for (int i11 = paramInt2; (i8 & 0x7) == 1; i11 = i21)
          {
            int i20 = i10 << 13;
            String str5 = this.program;
            i21 = i11 + 1;
            i8 = str5.charAt(i11);
            i10 = i20 | i8 >> 3;
          }
          if ((i10 & 0x1) != 0)
            i9 = 0;
          i12 = i10 >> 1;
          paramInt2 = i11;
          break;
          i13 = -1 - i13;
        }
        int i15 = i13 - i12;
        Object[][] arrayOfObject; = new Object[i6][];
        for (int i16 = 0; i16 < i6; i16++)
          arrayOfObject;[i16] = new Object[i15];
        for (int i17 = 0; i17 < i15; i17++)
        {
          while ((paramObject instanceof SyntaxForm))
          {
            paramSyntaxForm = (SyntaxForm)paramObject;
            paramObject = paramSyntaxForm.getDatum();
          }
          Pair localPair1 = (Pair)paramObject;
          if (!match_car(localPair1, paramArrayOfObject, paramInt1, j, paramSyntaxForm))
            return false;
          paramObject = localPair1.getCdr();
          for (int i19 = 0; i19 < i6; i19++)
            arrayOfObject;[i19][i17] = paramArrayOfObject[(i4 + i19)];
        }
        for (int i18 = 0; i18 < i6; i18++)
          paramArrayOfObject[(i4 + i18)] = arrayOfObject;[i18];
        i = 0;
      }
      while (i12 != 0);
      i = 0;
    }
    while (i9 == 0);
    return true;
    Object localObject1 = this.literals[i];
    Translator localTranslator = (Translator)Compilation.getCurrent();
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof SyntaxForm))
    {
      SyntaxForm localSyntaxForm2 = (SyntaxForm)localObject1;
      localObject2 = localSyntaxForm2.getDatum();
      localObject3 = localSyntaxForm2.getScope();
      if ((paramObject instanceof SyntaxForm))
      {
        SyntaxForm localSyntaxForm1 = (SyntaxForm)paramObject;
        localObject4 = localSyntaxForm1.getDatum();
        localObject5 = localSyntaxForm1.getScope();
        return literalIdentifierEq(localObject2, (ScopeExp)localObject3, localObject4, (ScopeExp)localObject5);
      }
    }
    else
    {
      localObject2 = localObject1;
      Syntax localSyntax = localTranslator.getCurrentSyntax();
      if ((localSyntax instanceof Macro));
      for (localObject3 = ((Macro)localSyntax).getCapturedScope(); ; localObject3 = null)
        break;
    }
    Object localObject4 = paramObject;
    if (paramSyntaxForm == null);
    for (Object localObject5 = localTranslator.currentScope(); ; localObject5 = paramSyntaxForm.getScope())
      break;
    if (paramSyntaxForm != null)
      paramObject = SyntaxForms.fromDatum(paramObject, paramSyntaxForm);
    paramArrayOfObject[(paramInt1 + i)] = paramObject;
    return true;
  }

  boolean match_car(Pair paramPair, Object[] paramArrayOfObject, int paramInt1, int paramInt2, SyntaxForm paramSyntaxForm)
  {
    String str1 = this.program;
    int i = paramInt2 + 1;
    int j = str1.charAt(paramInt2);
    int k = j >> 3;
    while ((j & 0x7) == 1)
    {
      int m = k << 13;
      String str2 = this.program;
      int n = i + 1;
      j = str2.charAt(i);
      k = m | j >> 3;
      i = n;
    }
    if ((j & 0x7) == 7)
    {
      if ((paramSyntaxForm != null) && (!(paramPair.getCar() instanceof SyntaxForm)))
        paramPair = Translator.makePair(paramPair, SyntaxForms.fromDatum(paramPair.getCar(), paramSyntaxForm), paramPair.getCdr());
      paramArrayOfObject[(paramInt1 + k)] = paramPair;
      return true;
    }
    return match(paramPair.getCar(), paramArrayOfObject, paramInt1, paramInt2, paramSyntaxForm);
  }

  public void print(Consumer paramConsumer)
  {
    paramConsumer.write("#<syntax-pattern>");
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.literals = ((Object[])paramObjectInput.readObject());
    this.program = ((String)paramObjectInput.readObject());
    this.varCount = paramObjectInput.readInt();
  }

  void translate(Object paramObject, StringBuffer paramStringBuffer, Object[] paramArrayOfObject, int paramInt, Vector paramVector, SyntaxForm paramSyntaxForm, char paramChar, Translator paramTranslator)
  {
    PatternScope localPatternScope = paramTranslator.patternScope;
    Vector localVector = localPatternScope.pattern_names;
    while ((paramObject instanceof SyntaxForm))
    {
      paramSyntaxForm = (SyntaxForm)paramObject;
      paramObject = paramSyntaxForm.getDatum();
    }
    Object localObject4;
    if ((paramObject instanceof Pair))
      localObject4 = paramTranslator.pushPositionOf(paramObject);
    while (true)
    {
      try
      {
        int i6 = paramStringBuffer.length();
        paramStringBuffer.append('\004');
        Pair localPair = (Pair)paramObject;
        SyntaxForm localSyntaxForm2 = paramSyntaxForm;
        Object localObject6 = localPair.getCdr();
        if ((localObject6 instanceof SyntaxForm))
        {
          paramSyntaxForm = (SyntaxForm)localObject6;
          localObject6 = paramSyntaxForm.getDatum();
          continue;
        }
        boolean bool1 = localObject6 instanceof Pair;
        int i7 = 0;
        if (bool1)
        {
          boolean bool2 = paramTranslator.matches(((Pair)localObject6).getCar(), "...");
          i7 = 0;
          int i8;
          Object localObject7;
          int i9;
          char c1;
          int i10;
          int i11;
          int i12;
          int i13;
          int i18;
          char c2;
          int i14;
          int i15;
          LList localLList2;
          int i16;
          int i17;
          int j;
          int k;
          int m;
          int n;
          int i1;
          int i2;
          Declaration localDeclaration;
          int i3;
          int i4;
          LList localLList1;
          int i;
          if (bool2)
          {
            i7 = 1;
            localObject6 = ((Pair)localObject6).getCdr();
            if ((localObject6 instanceof SyntaxForm))
            {
              paramSyntaxForm = (SyntaxForm)localObject6;
              localObject6 = paramSyntaxForm.getDatum();
              continue;
            }
          }
        }
        i8 = localVector.size();
        if (paramChar == 'P')
          paramChar = '\000';
        localObject7 = localPair.getCar();
        if (i7 != 0)
        {
          i9 = paramInt + 1;
          break label898;
          translate(localObject7, paramStringBuffer, paramArrayOfObject, i9, paramVector, localSyntaxForm2, c1, paramTranslator);
          i10 = localVector.size() - i8;
          i11 = paramStringBuffer.length() - i6 - 1 << 3;
          if (i7 != 0)
          {
            i12 = 5;
            i13 = i11 | i12;
            if (i13 > 65535)
            {
              i18 = 1 + (i13 >> 13);
              i6 += insertInt(i6, paramStringBuffer, i18);
            }
            c2 = (char)i13;
            paramStringBuffer.setCharAt(i6, c2);
            i14 = Translator.listLength(localObject6);
            if (i14 != -2147483648)
              continue;
            paramTranslator.syntaxError("cyclic pattern list");
          }
        }
        else
        {
          i9 = paramInt;
          break label898;
          c1 = 'P';
          continue;
        }
        i12 = 4;
        continue;
        if (i7 != 0)
        {
          i15 = i8 << 3;
          addInt(paramStringBuffer, i15);
          addInt(paramStringBuffer, i10 << 3);
          localLList2 = LList.Empty;
          if (localObject6 == localLList2)
          {
            paramStringBuffer.append('\b');
            return;
          }
          if (i14 >= 0)
          {
            i16 = i14 << 1;
            i17 = 0x6 | i16 << 3;
            addInt(paramStringBuffer, i17);
          }
        }
        else
        {
          paramObject = localObject6;
          paramTranslator.popPositionOf(localObject4);
          break;
        }
        i16 = (-i14 << 1) - 1;
        continue;
      }
      finally
      {
        paramTranslator.popPositionOf(localObject4);
      }
      if ((paramObject instanceof Symbol))
      {
        j = paramArrayOfObject.length;
        label655: 
        while (true)
        {
          j--;
          if (j < 0)
            break;
          ScopeExp localScopeExp = paramTranslator.currentScope();
          Object localObject1;
          Object localObject2;
          Object localObject3;
          if (paramSyntaxForm == null)
          {
            localObject1 = localScopeExp;
            localObject2 = paramArrayOfObject[j];
            if (!(localObject2 instanceof SyntaxForm))
              break label629;
            SyntaxForm localSyntaxForm1 = (SyntaxForm)localObject2;
            localObject2 = localSyntaxForm1.getDatum();
            localObject3 = localSyntaxForm1.getScope();
          }
          while (true)
          {
            if (!literalIdentifierEq(paramObject, (ScopeExp)localObject1, localObject2, (ScopeExp)localObject3))
              break label655;
            int i5 = SyntaxTemplate.indexOf(paramVector, paramObject);
            if (i5 < 0)
            {
              i5 = paramVector.size();
              paramVector.addElement(paramObject);
            }
            addInt(paramStringBuffer, 0x2 | i5 << 3);
            return;
            localObject1 = paramSyntaxForm.getScope();
            break;
            label629: if (paramTranslator.currentMacroDefinition != null)
              localObject3 = paramTranslator.currentMacroDefinition.getCapturedScope();
            else
              localObject3 = localScopeExp;
          }
        }
        if (localVector.contains(paramObject))
          paramTranslator.syntaxError("duplicated pattern variable " + paramObject);
        k = localVector.size();
        localVector.addElement(paramObject);
        if (paramChar == 'P')
        {
          m = 1;
          n = paramInt << 1;
          if (m == 0)
            break label801;
          i1 = 1;
          label729: i2 = n + i1;
          localPatternScope.patternNesting.append((char)i2);
          localDeclaration = localPatternScope.addDeclaration(paramObject);
          localDeclaration.setLocation(paramTranslator);
          paramTranslator.push(localDeclaration);
          i3 = k << 3;
          if (m == 0)
            break label807;
        }
        label801: label807: for (i4 = 7; ; i4 = 3)
        {
          addInt(paramStringBuffer, i3 | i4);
          return;
          m = 0;
          break;
          i1 = 0;
          break label729;
        }
      }
      localLList1 = LList.Empty;
      if (paramObject == localLList1)
      {
        paramStringBuffer.append('\b');
        return;
      }
      if ((paramObject instanceof FVector))
      {
        paramStringBuffer.append('\020');
        paramObject = LList.makeList((FVector)paramObject);
        paramChar = 'V';
        break;
      }
      i = SyntaxTemplate.indexOf(paramVector, paramObject);
      if (i < 0)
      {
        i = paramVector.size();
        paramVector.addElement(paramObject);
      }
      addInt(paramStringBuffer, 0x2 | i << 3);
      return;
      label898: if (paramChar == 'V')
        c1 = '\000';
    }
  }

  public int varCount()
  {
    return this.varCount;
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.program);
    paramObjectOutput.writeObject(this.literals);
    paramObjectOutput.writeInt(this.varCount);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.SyntaxPattern
 * JD-Core Version:    0.6.2
 */