package gnu.expr;

import gnu.mapping.OutPort;

public class LangExp extends Expression
{
  Object hook;

  public LangExp()
  {
  }

  public LangExp(Object paramObject)
  {
    this.hook = paramObject;
  }

  public void compile(Compilation paramCompilation, Target paramTarget)
  {
    throw new RuntimeException("compile called on LangExp");
  }

  public Object getLangValue()
  {
    return this.hook;
  }

  protected boolean mustCompile()
  {
    return false;
  }

  public void print(OutPort paramOutPort)
  {
    paramOutPort.print("(LangExp ???)");
  }

  public void setLangValue(Object paramObject)
  {
    this.hook = paramObject;
  }

  protected <R, D> R visit(ExpVisitor<R, D> paramExpVisitor, D paramD)
  {
    return paramExpVisitor.visitLangExp(this, paramD);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.LangExp
 * JD-Core Version:    0.6.2
 */