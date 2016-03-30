package gnu.bytecode;

public class IfState
{
  boolean doing_else;
  Label end_label;
  IfState previous;
  int stack_growth;
  int start_stack_size;
  Type[] then_stacked_types;

  public IfState(CodeAttr paramCodeAttr)
  {
    this(paramCodeAttr, new Label(paramCodeAttr));
  }

  public IfState(CodeAttr paramCodeAttr, Label paramLabel)
  {
    this.previous = paramCodeAttr.if_stack;
    paramCodeAttr.if_stack = this;
    this.end_label = paramLabel;
    this.start_stack_size = paramCodeAttr.SP;
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.bytecode.IfState
 * JD-Core Version:    0.6.2
 */