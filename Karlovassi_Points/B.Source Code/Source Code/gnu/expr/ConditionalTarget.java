package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Type;

public class ConditionalTarget extends Target
{
  public Label ifFalse;
  public Label ifTrue;
  Language language;
  public boolean trueBranchComesFirst = true;

  public ConditionalTarget(Label paramLabel1, Label paramLabel2, Language paramLanguage)
  {
    this.ifTrue = paramLabel1;
    this.ifFalse = paramLabel2;
    this.language = paramLanguage;
  }

  public void compileFromStack(Compilation paramCompilation, Type paramType)
  {
    CodeAttr localCodeAttr = paramCompilation.getCode();
    switch (paramType.getSignature().charAt(0))
    {
    default:
      if (this.trueBranchComesFirst)
      {
        localCodeAttr.emitGotoIfIntEqZero(this.ifFalse);
        localCodeAttr.emitGoto(this.ifTrue);
        return;
      }
      break;
    case 'J':
      localCodeAttr.emitPushLong(0L);
      if (this.trueBranchComesFirst)
        localCodeAttr.emitGotoIfEq(this.ifFalse);
      break;
    case 'D':
    case 'F':
    case 'L':
    case '[':
    }
    while (true)
    {
      emitGotoFirstBranch(localCodeAttr);
      return;
      localCodeAttr.emitPushDouble(0.0D);
      break;
      localCodeAttr.emitPushFloat(0.0F);
      break;
      localCodeAttr.emitGotoIfIntNeZero(this.ifTrue);
      localCodeAttr.emitGoto(this.ifFalse);
      return;
      if (this.language == null);
      for (Object localObject = Boolean.FALSE; ; localObject = this.language.booleanObject(false))
      {
        paramCompilation.compileConstant(localObject);
        break;
      }
      localCodeAttr.emitGotoIfNE(this.ifTrue);
    }
  }

  public final void emitGotoFirstBranch(CodeAttr paramCodeAttr)
  {
    if (this.trueBranchComesFirst);
    for (Label localLabel = this.ifTrue; ; localLabel = this.ifFalse)
    {
      paramCodeAttr.emitGoto(localLabel);
      return;
    }
  }

  public Type getType()
  {
    return Type.booleanType;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ConditionalTarget
 * JD-Core Version:    0.6.2
 */