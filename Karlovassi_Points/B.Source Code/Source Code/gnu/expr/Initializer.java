package gnu.expr;

import gnu.bytecode.Field;

public abstract class Initializer
{
  public Field field;
  Initializer next;

  public static Initializer reverse(Initializer paramInitializer)
  {
    Initializer localInitializer1 = null;
    while (paramInitializer != null)
    {
      Initializer localInitializer2 = paramInitializer.next;
      paramInitializer.next = localInitializer1;
      localInitializer1 = paramInitializer;
      paramInitializer = localInitializer2;
    }
    return localInitializer1;
  }

  public abstract void emit(Compilation paramCompilation);

  public void reportError(String paramString, Compilation paramCompilation)
  {
    paramCompilation.error('e', paramString + "field " + this.field);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.Initializer
 * JD-Core Version:    0.6.2
 */