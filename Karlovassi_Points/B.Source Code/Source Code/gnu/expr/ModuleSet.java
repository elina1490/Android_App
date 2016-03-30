package gnu.expr;

public abstract class ModuleSet
{
  public static final String MODULES_MAP = "$ModulesMap$";
  ModuleSet next;

  public abstract void register(ModuleManager paramModuleManager);
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     gnu.expr.ModuleSet
 * JD-Core Version:    0.6.2
 */