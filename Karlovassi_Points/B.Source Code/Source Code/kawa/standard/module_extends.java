package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class module_extends extends Syntax
{
  public static final module_extends module_extends = new module_extends();

  static
  {
    module_extends.setName("module-extends");
  }

  public void scanForm(Pair paramPair, ScopeExp paramScopeExp, Translator paramTranslator)
  {
    Type localType = paramTranslator.exp2Type((Pair)paramPair.getCdr());
    ModuleExp localModuleExp = paramTranslator.getModule();
    localModuleExp.setSuperType((ClassType)localType);
    localModuleExp.setFlag(131072);
  }
}

/* Location:           C:\Users\er0s\Desktop\New folder (2)\classes_dex2jar.jar
 * Qualified Name:     kawa.standard.module_extends
 * JD-Core Version:    0.6.2
 */