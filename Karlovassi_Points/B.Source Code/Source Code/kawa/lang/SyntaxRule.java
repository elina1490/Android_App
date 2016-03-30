package kawa.lang;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SyntaxRule extends SyntaxTemplate
  implements Externalizable
{
  SyntaxPattern pattern;

  public SyntaxRule()
  {
  }

  public SyntaxRule(SyntaxPattern paramSyntaxPattern, Object paramObject, SyntaxForm paramSyntaxForm, Translator paramTranslator)
  {
    super(paramObject, paramSyntaxForm, paramTranslator);
    this.pattern = paramSyntaxPattern;
  }

  public SyntaxRule(SyntaxPattern paramSyntaxPattern, String paramString1, String paramString2, Object[] paramArrayOfObject, int paramInt)
  {
    super(paramString1, paramString2, paramArrayOfObject, paramInt);
    this.pattern = paramSyntaxPattern;
  }

  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    this.pattern = ((SyntaxPattern)paramObjectInput.readObject());
    super.readExternal(paramObjectInput);
  }

  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeObject(this.pattern);
    super.writeExternal(paramObjectOutput);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.lang.SyntaxRule
 * JD-Core Version:    0.6.2
 */