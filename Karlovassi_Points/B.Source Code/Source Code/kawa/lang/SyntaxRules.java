package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.ScopeExp;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure1;
import gnu.text.Printable;
import gnu.text.ReportFormat;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SyntaxRules extends Procedure1
  implements Printable, Externalizable
{
  Object[] literal_identifiers;
  int maxVars = 0;
  SyntaxRule[] rules;

  public SyntaxRules()
  {
  }

  public SyntaxRules(Object[] paramArrayOfObject, Object paramObject, Translator paramTranslator)
  {
    this.literal_identifiers = paramArrayOfObject;
    int i = Translator.listLength(paramObject);
    if (i < 0)
    {
      i = 0;
      paramTranslator.syntaxError("missing or invalid syntax-rules");
    }
    this.rules = new SyntaxRule[i];
    SyntaxForm localSyntaxForm1 = null;
    int j = 0;
    Pair localPair1;
    SyntaxForm localSyntaxForm2;
    Object localObject1;
    if (j < i)
    {
      while ((paramObject instanceof SyntaxForm))
      {
        localSyntaxForm1 = (SyntaxForm)paramObject;
        paramObject = localSyntaxForm1.getDatum();
      }
      localPair1 = (Pair)paramObject;
      localSyntaxForm2 = localSyntaxForm1;
      for (localObject1 = localPair1.getCar(); (localObject1 instanceof SyntaxForm); localObject1 = localSyntaxForm2.getDatum())
        localSyntaxForm2 = (SyntaxForm)localObject1;
      if (!(localObject1 instanceof Pair))
        paramTranslator.syntaxError("missing pattern in " + j + "'th syntax rule");
    }
    while (true)
    {
      while (true)
      {
        return;
        SyntaxForm localSyntaxForm3 = localSyntaxForm2;
        Pair localPair2 = (Pair)localObject1;
        Object localObject2 = localPair2.getCar();
        String str = paramTranslator.getFileName();
        int n = paramTranslator.getLineNumber();
        int i1 = paramTranslator.getColumnNumber();
        SyntaxForm localSyntaxForm4 = localSyntaxForm2;
        try
        {
          paramTranslator.setLine(localPair2);
          for (Object localObject4 = localPair2.getCdr(); (localObject4 instanceof SyntaxForm); localObject4 = localSyntaxForm4.getDatum())
            localSyntaxForm4 = (SyntaxForm)localObject4;
          if (!(localObject4 instanceof Pair))
          {
            paramTranslator.syntaxError("missing template in " + j + "'th syntax rule");
            return;
          }
          Pair localPair3 = (Pair)localObject4;
          if (localPair3.getCdr() != LList.Empty)
          {
            paramTranslator.syntaxError("junk after " + j + "'th syntax rule");
            return;
          }
          Object localObject5 = localPair3.getCar();
          paramTranslator.push(PatternScope.push(paramTranslator));
          while ((localObject2 instanceof SyntaxForm))
          {
            localSyntaxForm3 = (SyntaxForm)localObject2;
            localObject2 = localSyntaxForm3.getDatum();
          }
          StringBuffer localStringBuffer = new StringBuffer();
          if ((localObject2 instanceof Pair))
          {
            paramArrayOfObject[0] = ((Pair)localObject2).getCar();
            Pair localPair4 = (Pair)localObject2;
            localStringBuffer.append('\f');
            localStringBuffer.append('\030');
            SyntaxPattern localSyntaxPattern = new SyntaxPattern(localStringBuffer, localPair4.getCdr(), localSyntaxForm3, paramArrayOfObject, paramTranslator);
            SyntaxRule[] arrayOfSyntaxRule = this.rules;
            SyntaxRule localSyntaxRule = new SyntaxRule(localSyntaxPattern, localObject5, localSyntaxForm4, paramTranslator);
            arrayOfSyntaxRule[j] = localSyntaxRule;
            PatternScope.pop(paramTranslator);
            paramTranslator.pop();
            paramTranslator.setLine(str, n, i1);
            j++;
            paramObject = localPair1.getCdr();
            break;
          }
          paramTranslator.syntaxError("pattern does not start with name");
          return;
        }
        finally
        {
          paramTranslator.setLine(str, n, i1);
        }
      }
      int k = this.rules.length;
      while (true)
      {
        k--;
        if (k < 0)
          break;
        int m = this.rules[k].patternNesting.length();
        if (m > this.maxVars)
          this.maxVars = m;
      }
    }
  }

  public SyntaxRules(Object[] paramArrayOfObject, SyntaxRule[] paramArrayOfSyntaxRule, int paramInt)
  {
    this.literal_identifiers = paramArrayOfObject;
    this.rules = paramArrayOfSyntaxRule;
    this.maxVars = paramInt;
  }

  public Object apply1(Object paramObject)
  {
    if ((paramObject instanceof SyntaxForm))
    {
      SyntaxForm localSyntaxForm = (SyntaxForm)paramObject;
      Translator localTranslator = (Translator)Compilation.getCurrent();
      ScopeExp localScopeExp = localTranslator.currentScope();
      localTranslator.setCurrentScope(localSyntaxForm.getScope());
      try
      {
        Object localObject2 = expand(localSyntaxForm, localTranslator);
        return localObject2;
      }
      finally
      {
        localTranslator.setCurrentScope(localScopeExp);
      }
    }
    return expand(paramObject, (Translator)Compilation.getCurrent());
  }

  public Object expand(Object paramObject, Translator paramTranslator)
  {
    Object[] arrayOfObject = new Object[this.maxVars];
    Macro localMacro = (Macro)paramTranslator.getCurrentSyntax();
    for (int i = 0; i < this.rules.length; i++)
    {
      SyntaxRule localSyntaxRule = this.rules[i];
      if (localSyntaxRule == null)
        return new ErrorExp("error defining " + localMacro);
      if (localSyntaxRule.pattern.match(paramObject, arrayOfObject, 0))
        return localSyntaxRule.execute(arrayOfObject, paramTranslator, TemplateScope.make(paramTranslator));
    }
    return paramTranslator.syntaxError("no matching syntax-rule for " + this.literal_identifiers[0]);
  }

  public void print(Consumer paramConsumer)
  {
    paramConsumer.write("#<macro ");
    ReportFormat.print(this.literal_identifiers[0], paramConsumer);
    paramConsumer.write(62);
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.literal_identifiers = ((Object[])paramObjectInput.readObject());
    this.rules = ((SyntaxRule[])paramObjectInput.readObject());
    this.maxVars = paramObjectInput.readInt();
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.literal_identifiers);
    paramObjectOutput.writeObject(this.rules);
    paramObjectOutput.writeInt(this.maxVars);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.SyntaxRules
 * JD-Core Version:    0.6.2
 */