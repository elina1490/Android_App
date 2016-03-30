package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.ScopeExp;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.IdentityHashMap;
import java.util.Vector;

public class SyntaxTemplate
  implements Externalizable
{
  static final int BUILD_CONS = 1;
  static final int BUILD_DOTS = 5;
  static final int BUILD_LIST1 = 8;
  static final int BUILD_LITERAL = 4;
  static final int BUILD_MISC = 0;
  static final int BUILD_NIL = 16;
  static final int BUILD_SYNTAX = 24;
  static final int BUILD_VAR = 2;
  static final int BUILD_VAR_CAR = 3;
  static final int BUILD_VECTOR = 40;
  static final int BUILD_WIDE = 7;
  static final String dots3 = "...";
  Object[] literal_values;
  int max_nesting;
  String patternNesting;
  String template_program;

  protected SyntaxTemplate()
  {
  }

  public SyntaxTemplate(Object paramObject, SyntaxForm paramSyntaxForm, Translator paramTranslator)
  {
    if ((paramTranslator == null) || (paramTranslator.patternScope == null));
    for (String str = ""; ; str = paramTranslator.patternScope.patternNesting.toString())
    {
      this.patternNesting = str;
      StringBuffer localStringBuffer = new StringBuffer();
      Vector localVector = new Vector();
      convert_template(paramObject, paramSyntaxForm, localStringBuffer, 0, localVector, new IdentityHashMap(), false, paramTranslator);
      this.template_program = localStringBuffer.toString();
      this.literal_values = new Object[localVector.size()];
      localVector.copyInto(this.literal_values);
      return;
    }
  }

  public SyntaxTemplate(String paramString1, String paramString2, Object[] paramArrayOfObject, int paramInt)
  {
    this.patternNesting = paramString1;
    this.template_program = paramString2;
    this.literal_values = paramArrayOfObject;
    this.max_nesting = paramInt;
  }

  private int get_count(Object paramObject, int paramInt, int[] paramArrayOfInt)
  {
    for (int i = 0; i < paramInt; i++)
      paramObject = ((Object[])(Object[])paramObject)[paramArrayOfInt[i]];
    return ((Object[])paramObject).length;
  }

  static int indexOf(Vector paramVector, Object paramObject)
  {
    int i = paramVector.size();
    for (int j = 0; j < i; j++)
      if (paramVector.elementAt(j) == paramObject)
        return j;
    return -1;
  }

  public int convert_template(Object paramObject1, SyntaxForm paramSyntaxForm, StringBuffer paramStringBuffer, int paramInt, Vector paramVector, Object paramObject2, boolean paramBoolean, Translator paramTranslator)
  {
    while ((paramObject1 instanceof SyntaxForm))
    {
      paramSyntaxForm = (SyntaxForm)paramObject1;
      paramObject1 = paramSyntaxForm.getDatum();
    }
    if (((paramObject1 instanceof Pair)) || ((paramObject1 instanceof FVector)))
    {
      IdentityHashMap localIdentityHashMap = (IdentityHashMap)paramObject2;
      if (localIdentityHashMap.containsKey(paramObject1))
      {
        paramTranslator.syntaxError("self-referential (cyclic) syntax template");
        return -2;
      }
      localIdentityHashMap.put(paramObject1, paramObject1);
    }
    Pair localPair1;
    int i1;
    int i2;
    Object localObject1;
    if ((paramObject1 instanceof Pair))
    {
      localPair1 = (Pair)paramObject1;
      i1 = -2;
      i2 = paramStringBuffer.length();
      localObject1 = localPair1.getCar();
      if (paramTranslator.matches(localObject1, "..."))
      {
        Object localObject3 = Translator.stripSyntax(localPair1.getCdr());
        if ((localObject3 instanceof Pair))
        {
          Pair localPair3 = (Pair)localObject3;
          if ((localPair3.getCar() == "...") && (localPair3.getCdr() == LList.Empty))
            paramObject1 = "...";
        }
      }
    }
    int i;
    do
    {
      do
      {
        while (true)
        {
          int n = indexOf(paramVector, paramObject1);
          if (n < 0)
          {
            n = paramVector.size();
            paramVector.addElement(paramObject1);
          }
          if ((paramObject1 instanceof Symbol))
          {
            ScopeExp localScopeExp = paramTranslator.currentScope();
            paramTranslator.noteAccess(paramObject1, localScopeExp);
          }
          if ((!(paramObject1 instanceof SyntaxForm)) && (paramObject1 != "..."))
            paramStringBuffer.append('\030');
          paramStringBuffer.append((char)(4 + n * 8));
          if (paramObject1 != "...")
            break;
          return -1;
          int i3 = paramVector.size();
          paramStringBuffer.append('\b');
          int i4 = 0;
          Object localObject2 = localPair1.getCdr();
          int i6;
          while (true)
          {
            Pair localPair2;
            if ((localObject2 instanceof Pair))
            {
              localPair2 = (Pair)localObject2;
              if (paramTranslator.matches(localPair2.getCar(), "..."));
            }
            else
            {
              int i5 = paramInt + i4;
              i6 = convert_template(localObject1, paramSyntaxForm, paramStringBuffer, i5, paramVector, paramObject2, false, paramTranslator);
              LList localLList2 = LList.Empty;
              if (localObject2 != localLList2)
              {
                paramStringBuffer.setCharAt(i2, (char)(1 + (paramStringBuffer.length() - i2 - 1 << 3)));
                i1 = convert_template(localObject2, paramSyntaxForm, paramStringBuffer, paramInt, paramVector, paramObject2, paramBoolean, paramTranslator);
              }
              if (i4 <= 0)
                break;
              if (i6 < 0)
                paramTranslator.syntaxError("... follows template with no suitably-nested pattern variable");
              int i7 = i4;
              while (true)
              {
                i7--;
                if (i7 < 0)
                  break;
                char c = (char)(5 + (i6 << 3));
                paramStringBuffer.setCharAt(1 + (i2 + i7), c);
                int i8 = paramInt + i4;
                if (i8 >= this.max_nesting)
                  this.max_nesting = i8;
              }
            }
            i4++;
            localObject2 = localPair2.getCdr();
            paramStringBuffer.append('\005');
          }
          if (i6 >= 0)
            return i6;
          if (i1 >= 0)
            return i1;
          if ((i6 == -1) || (i1 == -1))
            return -1;
          if (paramBoolean)
            return -2;
          paramVector.setSize(i3);
          paramStringBuffer.setLength(i2);
        }
        if ((paramObject1 instanceof FVector))
        {
          paramStringBuffer.append('(');
          return convert_template(LList.makeList((FVector)paramObject1), paramSyntaxForm, paramStringBuffer, paramInt, paramVector, paramObject2, true, paramTranslator);
        }
        LList localLList1 = LList.Empty;
        if (paramObject1 == localLList1)
        {
          paramStringBuffer.append('\020');
          return -2;
        }
      }
      while ((!(paramObject1 instanceof Symbol)) || (paramTranslator == null) || (paramTranslator.patternScope == null));
      i = indexOf(paramTranslator.patternScope.pattern_names, paramObject1);
    }
    while (i < 0);
    int j = this.patternNesting.charAt(i);
    if ((j & 0x1) != 0);
    for (int k = 3; ; k = 2)
    {
      int m = j >> 1;
      if (m > paramInt)
        paramTranslator.syntaxError("inconsistent ... nesting of " + paramObject1);
      paramStringBuffer.append((char)(k + i * 8));
      if (m != paramInt)
        break;
      return i;
    }
    return -1;
    return -2;
  }

  Object execute(int paramInt1, Object[] paramArrayOfObject, int paramInt2, int[] paramArrayOfInt, Translator paramTranslator, TemplateScope paramTemplateScope)
  {
    int m;
    String str;
    for (int i = this.template_program.charAt(paramInt1); (i & 0x7) == 7; i = m | str.charAt(paramInt1))
    {
      m = i - 7 << 13;
      str = this.template_program;
      paramInt1++;
    }
    if (i == 8)
      return executeToList(paramInt1 + 1, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
    if (i == 16)
      return LList.Empty;
    if (i == 24)
    {
      Object localObject5 = execute(paramInt1 + 1, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
      if (localObject5 == LList.Empty)
        return localObject5;
      return SyntaxForms.makeForm(localObject5, paramTemplateScope);
    }
    if ((i & 0x7) == 1)
    {
      Pair localPair = null;
      Object localObject2 = null;
      do
      {
        int k = paramInt1 + 1;
        Object localObject3 = executeToList(k, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
        if (localPair == null)
          localObject2 = localObject3;
        while ((localObject3 instanceof Pair))
        {
          localPair = (Pair)localObject3;
          localObject3 = localPair.getCdr();
          continue;
          localPair.setCdrBackdoor(localObject3);
        }
        paramInt1 = k + (i >> 3);
        i = this.template_program.charAt(paramInt1);
      }
      while ((i & 0x7) == 1);
      Object localObject4 = execute(paramInt1, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
      if (localPair == null)
        return localObject4;
      localPair.setCdrBackdoor(localObject4);
      return localObject2;
    }
    if (i == 40)
      return new FVector((LList)execute(paramInt1 + 1, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope));
    if ((i & 0x7) == 4)
    {
      int j = i >> 3;
      return this.literal_values[j];
    }
    if ((i & 0x6) == 2)
    {
      Object localObject1 = get_var(i >> 3, paramArrayOfObject, paramArrayOfInt);
      if ((i & 0x7) == 3)
        localObject1 = ((Pair)localObject1).getCar();
      return localObject1;
    }
    throw new Error("unknown template code: " + i + " at " + paramInt1);
  }

  public Object execute(Object[] paramArrayOfObject, TemplateScope paramTemplateScope)
  {
    return execute(0, paramArrayOfObject, 0, new int[this.max_nesting], (Translator)Compilation.getCurrent(), paramTemplateScope);
  }

  public Object execute(Object[] paramArrayOfObject, Translator paramTranslator, TemplateScope paramTemplateScope)
  {
    return execute(0, paramArrayOfObject, 0, new int[this.max_nesting], paramTranslator, paramTemplateScope);
  }

  LList executeToList(int paramInt1, Object[] paramArrayOfObject, int paramInt2, int[] paramArrayOfInt, Translator paramTranslator, TemplateScope paramTemplateScope)
  {
    int i = paramInt1;
    int i1;
    String str;
    for (int j = this.template_program.charAt(paramInt1); (j & 0x7) == 7; j = i1 | str.charAt(paramInt1))
    {
      i1 = j - 7 << 13;
      str = this.template_program;
      paramInt1++;
    }
    if ((j & 0x7) == 3)
    {
      Pair localPair3 = (Pair)get_var(j >> 3, paramArrayOfObject, paramArrayOfInt);
      return Translator.makePair(localPair3, localPair3.getCar(), LList.Empty);
    }
    if ((j & 0x7) == 5)
    {
      int k = get_count(paramArrayOfObject[(j >> 3)], paramInt2, paramArrayOfInt);
      Object localObject2 = LList.Empty;
      Pair localPair2 = null;
      int m = paramInt1 + 1;
      for (int n = 0; n < k; n++)
      {
        paramArrayOfInt[paramInt2] = n;
        LList localLList = executeToList(m, paramArrayOfObject, paramInt2 + 1, paramArrayOfInt, paramTranslator, paramTemplateScope);
        if (localPair2 == null)
          localObject2 = localLList;
        while ((localLList instanceof Pair))
        {
          localPair2 = (Pair)localLList;
          localLList = (LList)localPair2.getCdr();
          continue;
          localPair2.setCdrBackdoor(localLList);
        }
      }
      return localObject2;
    }
    Object localObject1 = execute(i, paramArrayOfObject, paramInt2, paramArrayOfInt, paramTranslator, paramTemplateScope);
    Pair localPair1 = new Pair(localObject1, LList.Empty);
    return localPair1;
  }

  Object get_var(int paramInt, Object[] paramArrayOfObject, int[] paramArrayOfInt)
  {
    Object localObject = paramArrayOfObject[paramInt];
    if (paramInt < this.patternNesting.length())
    {
      int i = this.patternNesting.charAt(paramInt) >> '\001';
      for (int j = 0; j < i; j++)
        localObject = ((Object[])(Object[])localObject)[paramArrayOfInt[j]];
    }
    return localObject;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.patternNesting = ((String)paramObjectInput.readObject());
    this.template_program = ((String)paramObjectInput.readObject());
    this.literal_values = ((Object[])paramObjectInput.readObject());
    this.max_nesting = paramObjectInput.readInt();
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.patternNesting);
    paramObjectOutput.writeObject(this.template_program);
    paramObjectOutput.writeObject(this.literal_values);
    paramObjectOutput.writeInt(this.max_nesting);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.SyntaxTemplate
 * JD-Core Version:    0.6.2
 */